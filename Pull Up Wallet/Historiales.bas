B4A=true
Group=Default Group\Listas
ModulesStructureVersion=1
Type=Activity
Version=10.6
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim sql As SQL
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Type IndiceHistorial(rowid As Int)
	Type Historial(rowid As Int, sumaIngresos As Int, sumaEgresos As Int, balance As Int, fechaHistorial As String)
	Dim alturaDispositivo As Int
	Dim anchoDispositivo As Int
	Dim nRegistros As Int
	Private btnMenu As Button
	Private lblContornoBoton As Label
	Private pnlNavInferior As Panel
	Private pnlDeslizable As Panel
	Private svPantalla As ScrollView
	Dim cur As Cursor
	Dim cs As CSBuilder
	Dim cvsTest As Canvas
	Dim bmpTest As Bitmap
	Dim stu As StringUtils
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("LDeslizable")
	Activity.Color = Colors.ARGB(255, 233, 236, 239)
	alturaDispositivo = Main.alturaDispositivo
	anchoDispositivo = Main.anchoDispositivo
	sql = Starter.sql
	bmpTest.InitializeMutable(1dip, 1dip)
	cvsTest.Initialize2(bmpTest)
	
	'Panel de navegación inferior
	pnlNavInferior.Height = alturaDispositivo * 0.08
	pnlNavInferior.Width = anchoDispositivo
	pnlNavInferior.Left = 0
	pnlNavInferior.Top = alturaDispositivo - pnlNavInferior.Height
	'Controles relacionados
	'Botón para agregar
	btnMenu.Width = anchoDispositivo * 0.15
	btnMenu.Height = btnMenu.Width
	btnMenu.Top = pnlNavInferior.Top - btnMenu.Height / 2
	btnMenu.Left = (anchoDispositivo - btnMenu.Width) / 2
	'Etiqueta para contorno del botón de agregar
	lblContornoBoton.Width = anchoDispositivo * 0.17
	lblContornoBoton.Height = lblContornoBoton.Width
	lblContornoBoton.Left = (anchoDispositivo - lblContornoBoton.Width) / 2
	lblContornoBoton.Top = pnlNavInferior.Top - lblContornoBoton.Height / 2
	
	'-----------------------------------------------------------------------------------------
	
	svPantalla.Height = pnlNavInferior.Top
	svPantalla.Panel.LoadLayout("LPantallaDeslizable")
	svPantalla.Width = anchoDispositivo * 1.5
	pnlDeslizable.Width = svPantalla.Width
	
	'-----------------------------------------------------------------------------------------
	
	'https://www.b4x.com/android/forum/threads/tick-tack-toe-working-with-arrays-of-views.8506/#content arreglos de views
	'Título de la lista
	Dim lblSeccion As Label
	lblSeccion.Initialize("lblSeccion")
	lblSeccion.Text = "Historiales"
	lblSeccion.TextSize = 20
	lblSeccion.TextColor = Colors.Black
	lblSeccion.Height = 30dip
	lblSeccion.Width = anchoDispositivo * 0.9
	lblSeccion.Top = 30dip
	lblSeccion.Left = (anchoDispositivo - lblSeccion.Width) / 2
	pnlDeslizable.AddView(lblSeccion, lblSeccion.Left, lblSeccion.Top, lblSeccion.Width, lblSeccion.Height)
	
	'-----------------------------------------------------------------------------------------
	
	'Top desde que los objetos creados a partir de los registros se posicionarán
	Dim top As Int
	top = lblSeccion.Top + lblSeccion.Height + 30dip
	
	'Operación de consulta a la base de datos
	cur = sql.ExecQuery("SELECT * FROM historial_balance ORDER BY rowid ASC")
	nRegistros = cur.RowCount
	
	'Itera sobre todos los registros y guarda los campos del registro actual en un objeto de tipo Historial, luego
	'crea el componente del registro para la lista
	If nRegistros > 0 Then
		'Se itera a través de los registros
		For id = 0 To nRegistros - 1
			cur.Position = id
			'Se guardan los campos del registro actual en un objeto de tipo Historial
			Dim datosHistorial As Historial
			datosHistorial.rowid = cur.GetInt("id_historial")
			datosHistorial.sumaIngresos = cur.GetInt("suma_ingresos")
			datosHistorial.sumaEgresos = cur.GetInt("suma_egresos")
			datosHistorial.balance = cur.GetInt("balance")
			datosHistorial.fechaHistorial = cur.GetString("fecha_historial")
			'Se envian los argumentos necesarios para crear el componente de la lista
			creaObjetoLista(top, datosHistorial)
			'Se actualiza el top para el siguiente componente
			top = top + alturaDispositivo * 0.2 + 60
		Next
	Else
		'En caso de que no haya registros en la base de datos, se despliega un mensaje que incite a insertar un registro en la respectiva tabla
		Dim lblMensaje As Label
		lblMensaje.Initialize("lblMensaje")
		lblMensaje.Height = alturaDispositivo * 0.2
		lblMensaje.Width = anchoDispositivo * 0.9
		lblMensaje.Top = (alturaDispositivo - lblMensaje.Height) / 2
		lblMensaje.Left = (anchoDispositivo - lblMensaje.Width) / 2
		lblMensaje.Text = cs.Initialize.Color(Colors.Black).Alignment("ALIGN_CENTER").Typeface(Typeface.MATERIALICONS).Size(50).Append(Chr(0xE89C) & CRLF).Typeface(Typeface.DEFAULT).Size(18).Append("Está muy vacío aquí adentro." & CRLF).Append("Genera tu historial si lo crees necesario.").PopAll
		Activity.AddView(lblMensaje, lblMensaje.Left, lblMensaje.Top, lblMensaje.Width, lblMensaje.Height)
	End If
	'Se actualiza la altura del panel del ScrollView con el último top calculado
	svPantalla.Panel.Height = top + 100
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Private Sub btnMenu_Click
	Activity.Finish
End Sub

'Crea el componente de la lista, con respecto al registro en la base de datos
Sub creaObjetoLista(top As Int, datos As Historial)
	Dim pnlHistorial As Panel
	Dim lblBalance As Label
	Dim lblIngresos As Label
	Dim lblEgresos As Label
	Dim lblFechaHistorial As Label
	Dim lblEliminar As Label
	Dim lblIconoIngresos As Label
	Dim lblIconoEgresos As Label
	
	'https://www.b4x.com/android/forum/threads/help-corner-radius-on-panel.60052/
	Dim cd As ColorDrawable
	cd.Initialize(Colors.White, 20)
	
	'--------------------------------------------------------------------
	
	'Panel de balance
	pnlHistorial.Initialize("pnlHistorial")
	pnlHistorial.Top = top
	pnlHistorial.Background = cd
	pnlHistorial.Width = anchoDispositivo * 0.9
	pnlHistorial.Height = alturaDispositivo * 0.2
	pnlHistorial.Left = (anchoDispositivo - pnlHistorial.Width) / 2
	pnlHistorial.Width = anchoDispositivo * 0.9
	'Subcontroles
	'Etiquetas
	'Etiqueta para desplegar el balance
	lblBalance.Initialize("lblBalance")
	lblBalance.Text = cs.Initialize.Color(Colors.Black).Alignment("ALIGN_CENTER").Typeface(Typeface.DEFAULT).Size(14).Append("Balance:" & CRLF).Typeface(Typeface.DEFAULT).Size(16).Append("$" & datos.balance).PopAll
	lblBalance.Height = pnlHistorial.Height * 0.4
	lblBalance.Top = 0
	lblBalance.Gravity = Gravity.CENTER
	pnlHistorial.AddView(lblBalance, lblBalance.Left, lblBalance.Top, lblBalance.Width, lblBalance.Height)
	lblBalance.Width = stu.MeasureMultilineTextHeight(lblBalance, lblBalance.Text)
	lblBalance.Left = (pnlHistorial.Width - lblBalance.Width) / 2
	'Ícono de ingresos
	cd.Initialize(Colors.Transparent, 100)
	lblIconoIngresos.Initialize("lblIconoIngresos")
	lblIconoIngresos.Background = cd
	lblIconoIngresos.Typeface = Typeface.MATERIALICONS
	lblIconoIngresos.Top = lblBalance.Height
	lblIconoIngresos.Left = pnlHistorial.Width * 0.05
	lblIconoIngresos.Height = pnlHistorial.Height * 0.3
	lblIconoIngresos.Width = lblIconoIngresos.Height
	lblIconoIngresos.Text = Chr(0xE5D8)
	lblIconoIngresos.TextColor = Colors.White
	lblIconoIngresos.Color = Colors.ARGB(255, 42, 197, 33)
	lblIconoIngresos.Gravity = Gravity.CENTER
	pnlHistorial.AddView(lblIconoIngresos, lblIconoIngresos.Left, lblIconoIngresos.Top, lblIconoIngresos.Width, lblIconoIngresos.Height)
	'Información sobre ingresos
	lblIngresos.Initialize("lblIngresos")
	lblIngresos.Height = lblIconoIngresos.Height
	lblIngresos.Width = pnlHistorial.Width * 0.5 - (lblIconoIngresos.Left + lblIconoIngresos.Width)
	lblIngresos.Left = lblIconoIngresos.Left + lblIconoIngresos.Width
	lblIngresos.Top = lblIconoIngresos.Top
	lblIngresos.Text = "$" & datos.sumaIngresos & ".00"
	lblIngresos.TextSize = 13
	lblIngresos.TextColor = Colors.ARGB(255, 42, 197, 33)
	lblIngresos.Gravity = Gravity.CENTER
	pnlHistorial.AddView(lblIngresos, lblIngresos.Left, lblIngresos.Top, lblIngresos.Width, lblIngresos.Height)
	'Ícono de egresos
	lblIconoEgresos.Initialize("lblIconoEgresos")
	lblIconoEgresos.Background = cd
	lblIconoEgresos.Typeface = Typeface.MATERIALICONS
	lblIconoEgresos.Top = lblIconoIngresos.Top
	lblIconoEgresos.Left = pnlHistorial.Width * 0.5 + lblIconoIngresos.Left
	lblIconoEgresos.Height = lblIconoIngresos.Height
	lblIconoEgresos.Width = lblIconoIngresos.Width
	lblIconoEgresos.Text = Chr(0xE5DB)
	lblIconoEgresos.TextColor = Colors.White
	lblIconoEgresos.Color = Colors.Red
	lblIconoEgresos.Gravity = Gravity.CENTER
	pnlHistorial.AddView(lblIconoEgresos, lblIconoEgresos.Left, lblIconoEgresos.Top, lblIconoEgresos.Width, lblIconoEgresos.Height)
	'Información sobre egresos
	lblEgresos.Initialize("lblEgresos")
	lblEgresos.Height = lblIconoEgresos.Height
	lblEgresos.Width = lblIngresos.Width
	lblEgresos.Left = lblIconoEgresos.Left + lblIconoEgresos.Width
	lblEgresos.Top = lblIconoEgresos.Top
	lblEgresos.Text = "$" & datos.sumaEgresos & ".00"
	lblEgresos.TextSize = 13
	lblEgresos.TextColor = Colors.Red
	lblEgresos.Gravity = Gravity.CENTER
	pnlHistorial.AddView(lblEgresos, lblEgresos.Left, lblEgresos.Top, lblEgresos.Width, lblEgresos.Height)
	'Fecha del historial
	lblFechaHistorial.Initialize("lblFechaHistorial")
	lblFechaHistorial.TextColor = Colors.Black
	lblFechaHistorial.Text = cs.Initialize.Color(Colors.Black).Typeface(Typeface.DEFAULT).Size(14).Append("Fecha del historial:" & CRLF).Append(datos.fechaHistorial).PopAll
	lblFechaHistorial.Width = cvsTest.MeasureStringWidth(lblFechaHistorial.Text, Typeface.DEFAULT, 16) + 2
	lblFechaHistorial.Height = pnlHistorial.Height * 0.3
	lblFechaHistorial.Top = lblIconoIngresos.Top + lblIconoIngresos.Height
	lblFechaHistorial.Left = (pnlHistorial.Width - lblFechaHistorial.Width) * 0.5
	lblFechaHistorial.Gravity = Gravity.CENTER
	pnlHistorial.AddView(lblFechaHistorial, lblFechaHistorial.Left, lblFechaHistorial.Top, lblFechaHistorial.Width, lblFechaHistorial.Height)
	'Etiqueta (como botón) para eliminar el historial
	lblEliminar.Initialize("lblEliminar")
	lblEliminar.Typeface = Typeface.FONTAWESOME
	lblEliminar.Text = Chr(0xF1F8)
	lblEliminar.TextSize = 18
	lblEliminar.TextColor = Colors.Black
	lblEliminar.Width = cvsTest.MeasureStringWidth(lblEliminar.Text, Typeface.FONTAWESOME, lblEliminar.TextSize) + 2
	lblEliminar.Left = pnlHistorial.Width - lblEliminar.Width * 2
	lblEliminar.Top = lblEliminar.Width
	lblEliminar.Gravity = Gravity.CENTER
	pnlHistorial.AddView(lblEliminar, lblEliminar.Left, lblEliminar.Top, lblEliminar.Width, lblEliminar.Height)
	'Se tiene que agregar primero a un elemento padre para luego ajustar su altura
	lblEliminar.Height = stu.MeasureMultilineTextHeight(lblEliminar, lblEliminar.Text) + 2
	'Se agrega el panel del historial en el panel del ScrollView
	pnlDeslizable.AddView(pnlHistorial, pnlHistorial.Left, top, pnlHistorial.Width, pnlHistorial.Height)
	
	'--------------------------------------------------------------------
	
	'Se crea este objeto de tipo Indice para guardar el indice del objeto actual
	Dim referencia As IndiceHistorial
	referencia.rowid = datos.rowid
	'Se liga el objeto referencia al lblEliminar
	lblEliminar.Tag = referencia
End Sub

'Despliega u oculta el panel de opciones correspondiente al registro que lanzó el evento
Sub lblEliminar_Click
	Dim lblEliminar As Label
	Dim indice As IndiceHistorial
	Dim idRegistro As Int
	
	lblEliminar = Sender
	indice = lblEliminar.Tag
	'Copia la etiqueta que lanzó este evento
	lblEliminar = Sender
	'Se obtiene el objeto ligado a la etiqueta
	indice = lblEliminar.Tag
	'Se obtiene el rowid ligado al objeto de la lista
	idRegistro = indice.rowid
	'Se pregunta al usuario si está seguro de querer eliminar el historial
	'https://www.b4x.com/android/forum/threads/msgbox-with-confirmation-and-cancel.22412/
	Log(idRegistro)
	Dim resultado As Int
	resultado = Msgbox2("¿Estás seguro?", "Eliminar historial", "Sí", "", "No", Null)
	If (resultado = DialogResponse.POSITIVE) Then
		'https://www.b4x.com/android/forum/threads/how-do-i-delete-a-row-from-the-table-example.8799/
		sql.ExecNonQuery("DELETE FROM historial_balance WHERE id_historial = '" & idRegistro & "'")
		'Se simula el reinicio del activity
		'https://www.b4x.com/android/forum/threads/how-do-i-delete-a-row-from-the-table-example.8799/
		Activity.Finish
		StartActivity(Me)
	End If
End Sub