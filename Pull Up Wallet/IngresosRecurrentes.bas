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
	Type IndiceIngresoRecurrente(indiceElemento As Int, rowid As Int)
	Type IngresoRecurrente(rowid As Int, nombre As String, monto As Int, periodo As String, descripcion As String, color As Int)
	Dim alturaDispositivo As Int
	Dim anchoDispositivo As Int
	Dim nRegistros As Int
	Dim Relaciones(,) As B4XView
	Dim arrayPnlsOpciones() As B4XView
	Private btnMenu As Button
	Private lblContornoBoton As Label
	Private pnlNavInferior As Panel
	Private pnlDeslizable As Panel
	Private svPantalla As ScrollView
	Dim cur As Cursor
	Dim cs As CSBuilder
	Dim cvsTest As Canvas
	Dim bmpTest As Bitmap
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("LDeslizable")
	Activity.Color = Colors.ARGB(255, 233, 236, 239)
	alturaDispositivo = Main.alturaDispositivo
	anchoDispositivo = Main.anchoDispositivo
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
	lblSeccion.Text = "Ingresos recurrentes"
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
	sql = Starter.sql
	cur = sql.ExecQuery("SELECT * FROM ingresos_recurrentes ORDER BY rowid ASC")
	nRegistros = cur.RowCount
	
	'Itera sobre todos los registros y guarda los campos del registro actual en un objeto de tipo IngresoRecurrente, luego
	'crea el componente del registro para la lista
	If nRegistros > 0 Then
		'Se actualiza las dimensiones de los arrays
		Dim Relaciones(nRegistros, 2) As B4XView
		Dim arrayPnlsOpciones(nRegistros) As B4XView
		'Se itera a través de los registros
		For id = 0 To nRegistros - 1
			cur.Position = id
			'Se guardan los campos del registro actual en un objeto de tipo IngresoRecurrente
			Dim datosIngresoRecurrente As IngresoRecurrente
			datosIngresoRecurrente.rowid = cur.GetInt("id_ingreso_recurrente")
			datosIngresoRecurrente.nombre = cur.GetString("nombre")
			datosIngresoRecurrente.monto = cur.GetInt("monto")
			datosIngresoRecurrente.descripcion = cur.GetString("descripcion")
			datosIngresoRecurrente.periodo = cur.GetString("periodo")
			datosIngresoRecurrente.color = cur.GetInt("color")
			'Se envian los argumentos necesarios para crear el componente de la lista
			creaObjetoLista(id, top, datosIngresoRecurrente)
			'Se actualiza el top para el siguiente componente
			top = top + alturaDispositivo * 0.12 + 60
		Next
	Else
		'En caso de que no haya registros en la base de datos, se despliega un mensaje que incite a insertar un registro en la respectiva tabla
		Dim lblMensaje As Label
		lblMensaje.Initialize("lblMensaje")
		lblMensaje.Height = alturaDispositivo * 0.2
		lblMensaje.Width = anchoDispositivo * 0.9
		lblMensaje.Top = (alturaDispositivo - lblMensaje.Height) / 2
		lblMensaje.Left = (anchoDispositivo - lblMensaje.Width) / 2
		lblMensaje.Text = cs.Initialize.Color(Colors.Black).Alignment("ALIGN_CENTER").Typeface(Typeface.MATERIALICONS).Size(50).Append(Chr(0xE89C) & CRLF).Typeface(Typeface.DEFAULT).Size(18).Append("Está muy vacío aquí adentro." & CRLF).Append("Agrega un ingreso recurrente desde el menú principal.").PopAll
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
	CallSubDelayed(Main, "actualizarDatos")
	Activity.Finish
End Sub

'Crea el componente de la lista, con respecto al registro en la base de datos
Sub creaObjetoLista(indice As Int, top As Int, datos As IngresoRecurrente)
	Dim pnlIngresoRecurrente As Panel
	Dim pnlOpciones As Panel
	Dim lblNombre As Label
	Dim lblMonto As Label
	Dim lblDescripcion As Label
	Dim lblPeriodo As Label
	Dim lblOpciones As Label
	Dim btnEditar As Button
	Dim btnEliminar As Button
	
	'https://www.b4x.com/android/forum/threads/help-corner-radius-on-panel.60052/
	Dim cd As ColorDrawable
	cd.Initialize(datos.color, 20)
	
	'Panel contenedor
	pnlIngresoRecurrente.Initialize("pnlSuscripcion")
	pnlIngresoRecurrente.Top = top
	pnlIngresoRecurrente.Background = cd
	pnlIngresoRecurrente.Width = anchoDispositivo * 0.9
	pnlIngresoRecurrente.Height = alturaDispositivo * 0.14
	pnlIngresoRecurrente.Left = (anchoDispositivo - pnlIngresoRecurrente.Width) / 2
	'Etiqueta del nombre del ingreso recurrente
	lblNombre.Initialize("lblNombre")
	lblNombre.TextColor = Colors.White
	lblNombre.Text = datos.nombre.ToUpperCase.CharAt(0) & datos.nombre.SubString(1).ToLowerCase
	lblNombre.TextSize = 19
	lblNombre.Height = pnlIngresoRecurrente.Height * 0.3
	lblNombre.Width = pnlIngresoRecurrente.Width * 0.9
	lblNombre.Top = 0
	lblNombre.Left = pnlIngresoRecurrente.Width * 0.05
	lblNombre.Gravity = Gravity.CENTER_VERTICAL
	pnlIngresoRecurrente.AddView(lblNombre, lblNombre.Left, lblNombre.Top, lblNombre.Width, lblNombre.Height)
	'Etiqueta de la descripción
	lblDescripcion.Initialize("lblDescripcion")
	lblDescripcion.Text = datos.descripcion.ToUpperCase.CharAt(0) & datos.descripcion.SubString(1).ToLowerCase
	lblDescripcion.TextColor = Colors.White
	lblDescripcion.Height = pnlIngresoRecurrente.Height * 0.3
	lblDescripcion.Width = pnlIngresoRecurrente.Width * 0.9
	lblDescripcion.Top = lblNombre.Height
	lblDescripcion.Left = lblNombre.Left
	lblDescripcion.Gravity = Gravity.CENTER_VERTICAL
	pnlIngresoRecurrente.AddView(lblDescripcion, lblDescripcion.Left, lblDescripcion.Top, lblDescripcion.Width, lblDescripcion.Height)
	'Etiqueta del periodo
	lblPeriodo.Initialize("lblPeriodo")
	
	Dim textoPeriodo As String
	If (datos.periodo = 7) Then
		textoPeriodo = "1 semana"
	Else If (datos.periodo = 14) Then
		textoPeriodo = "2 semanas"
	Else If (datos.periodo = 21) Then
		textoPeriodo = "3 semanas"
	Else If (datos.periodo = 30) Then
		textoPeriodo = "1 mes"
	Else If (datos.periodo = 365) Then
		textoPeriodo = "1 año"
	End If
	
	lblPeriodo.Text = textoPeriodo
	lblPeriodo.TextSize = 16
	lblPeriodo.TextColor = Colors.DarkGray
	lblPeriodo.Height = pnlIngresoRecurrente.Height * 0.4
	lblPeriodo.Width = pnlIngresoRecurrente.Width * 0.9
	lblPeriodo.Top = lblDescripcion.Top + lblDescripcion.Height
	lblPeriodo.Left = lblNombre.Left
	lblPeriodo.Gravity = Gravity.CENTER_VERTICAL
	pnlIngresoRecurrente.AddView(lblPeriodo, lblPeriodo.Left, lblPeriodo.Top, lblPeriodo.Width, lblPeriodo.Height)
	'Etiqueta del monto
	lblMonto.Initialize("lblMonto")
	lblMonto.TextSize = 16
	lblMonto.TextColor = Colors.White
	lblMonto.Width = cvsTest.MeasureStringWidth(("$" & datos.monto), Typeface.DEFAULT, lblMonto.TextSize) + 2
	lblMonto.Height = pnlIngresoRecurrente.Height * 0.4
	lblMonto.Text = "$" & datos.monto
	lblMonto.Top = lblPeriodo.Top
	lblMonto.Left = pnlIngresoRecurrente.Width - lblMonto.Width - lblNombre.Left
	lblMonto.Gravity = Gravity.CENTER_VERTICAL
	pnlIngresoRecurrente.AddView(lblMonto, lblMonto.Left, lblMonto.Top, lblMonto.Width, lblMonto.Height)
	'Opcion para abrir el panel de operaciones con el registro
	lblOpciones.Initialize("lblOpciones")
	lblOpciones.Typeface = Typeface.FONTAWESOME
	lblOpciones.Text = Chr(0xF142)
	lblOpciones.TextSize = 18
	lblOpciones.TextColor = Colors.White
	lblOpciones.Height = lblNombre.Height
	lblOpciones.Width = 8dip
	lblOpciones.Left = lblMonto.Left + lblMonto.Width - lblOpciones.Width
	lblOpciones.Top = 0
	lblOpciones.Gravity = Gravity.CENTER_VERTICAL
	pnlIngresoRecurrente.AddView(lblOpciones, lblOpciones.Left, lblOpciones.Top, lblOpciones.Width, lblOpciones.Height)
	'Panel de opciones de operaciones con el registro
	pnlOpciones.Initialize("pnlOpciones")
	cd.Initialize(Colors.Black, 20)
	pnlOpciones.Background = cd
	pnlOpciones.Height = pnlIngresoRecurrente.Height * 0.8
	pnlOpciones.Width = pnlIngresoRecurrente.Height
	pnlOpciones.Top = lblOpciones.Top
	pnlOpciones.Left = lblOpciones.Left - lblOpciones.Width * 2 - pnlOpciones.Width
	pnlOpciones.Visible = False
	pnlIngresoRecurrente.AddView(pnlOpciones, pnlOpciones.Left, pnlOpciones.Top, pnlOpciones.Width, pnlOpciones.Height)
	'Opción de editar del panel
	btnEditar.Initialize("btnEditar")
	btnEditar.Color = Colors.Transparent
	btnEditar.Text = "Editar"
	btnEditar.TextColor = Colors.White
	btnEditar.TextSize = 14
	btnEditar.Height = pnlOpciones.Height * 0.4
	btnEditar.Width = pnlOpciones.Height * 0.8
	btnEditar.Top = (pnlOpciones.Height * 0.2) / 3
	btnEditar.Left = (pnlOpciones.Width - btnEditar.Width) / 2
	pnlOpciones.AddView(btnEditar, btnEditar.Left, btnEditar.Top, btnEditar.Width, btnEditar.Height)
	'Opción de eliminar en el panel
	btnEliminar.Initialize("btnEliminar")
	btnEliminar.Color = Colors.Transparent
	btnEliminar.Text = "Eliminar"
	btnEliminar.TextColor = Colors.White
	btnEliminar.TextSize = 14
	btnEliminar.Height = btnEditar.Height
	btnEliminar.Width = pnlOpciones.Width * 0.9
	btnEliminar.Top = btnEditar.Top * 2 + btnEditar.Height
	btnEliminar.Left = (pnlOpciones.Width - btnEliminar.Width) / 2
	pnlOpciones.AddView(btnEliminar, btnEliminar.Left, btnEliminar.Top, btnEliminar.Width, btnEliminar.Height)
	'Se agrega el panel del registro en el panel del ScrollView
	pnlDeslizable.AddView(pnlIngresoRecurrente, pnlIngresoRecurrente.Left, top, pnlIngresoRecurrente.Width, pnlIngresoRecurrente.Height)
	
	'Se crea este objeto de tipo Indice para guardar solo el indice del objeto actual
	Dim referencia As IndiceIngresoRecurrente
	referencia.indiceElemento = indice
	referencia.rowid = 0
	'Se liga el objeto referencia al lblOpciones
	lblOpciones.Tag = referencia
	
	'Se crea este objeto de tipo Indice para guardar solo el rowid (ya que pueden haber saltos de rowids entre registros consecutivos)
	Dim referencia2 As IndiceIngresoRecurrente
	referencia2.indiceElemento = 0
	referencia2.rowid = datos.rowid
	'Se liga el objeto referencia al pnlOpciones ya que este contiene los botones de las operaciones de Editar y Eliminar
	pnlOpciones.Tag = referencia2
	
	'Se guarda la referencia de estos controles en los respectivos índices del array
	Relaciones(indice, 0) = lblOpciones
	Relaciones(indice, 1) = pnlOpciones
	
	'Se guarda la referencia del panel de opciones en el array que nos servirá para hacer invisibles los páneles que sean distintos al que lance el evento click
	arrayPnlsOpciones(indice) = pnlOpciones
End Sub

'Despliega u oculta el panel de opciones correspondiente al registro que lanzó el evento
Sub lblOpciones_Click
	Dim lblOpcion As Label
	Dim indice As IndiceIngresoRecurrente
	
	lblOpcion = Sender
	indice = lblOpcion.Tag
	
	'Hace invisibles a los demás páneles de opciones, exceptuando el que lanzó este evento
	For contador = 0 To arrayPnlsOpciones.Length - 1
		If (contador <> indice.indiceElemento) Then
			arrayPnlsOpciones(contador).Visible = False
		End If
	Next
	
	'Hace toggle entre los valores de la propiedad Visible del panel en caso de que se presione de nuevo
	Relaciones(indice.indiceElemento, 1).SetVisibleAnimated(200, Not(Relaciones(indice.indiceElemento, 1).Visible))
End Sub

Sub btnEditar_Click
	Dim btnEditar As Button
	Dim pnlPadre As Panel
	Dim idRegistro As Int
	Dim indice As IndiceIngresoRecurrente
	
	'Copia el botón que lanzó este evento
	btnEditar = Sender
	'Se copia el control padre del btnEditar
	pnlPadre = btnEditar.Parent
	'Se obtiene el objeto ligado al pnlPadre
	indice = pnlPadre.Tag
	'Se obtiene el rowid ligado al objeto de la lista
	idRegistro = indice.rowid
	CallSubDelayed2(editarIngresoRecurrente, "consultaAEditar", idRegistro)
	Activity.Finish
End Sub

Sub btnEliminar_Click
	Dim btnEliminar As Button
	Dim pnlPadre As Panel
	Dim idRegistro As Int
	Dim indice As IndiceIngresoRecurrente
	
	'Copia el botón que lanzó este evento
	btnEliminar = Sender
	'Se copia el control padre del btnEliminar
	pnlPadre = btnEliminar.Parent
	'Se obtiene el objeto ligado al pnlPadre
	indice = pnlPadre.Tag
	'Se obtiene el rowid ligado al objeto de la lista
	idRegistro = indice.rowid
	'Se pregunta al usuario si está seguro de querer eliminar el registro
	'https://www.b4x.com/android/forum/threads/msgbox-with-confirmation-and-cancel.22412/
	Dim resultado As Int
	resultado = Msgbox2("¿Estás seguro?", "Eliminar ingreso recurrente", "Sí", "", "No", Null)
	If (resultado = DialogResponse.POSITIVE) Then
		'https://www.b4x.com/android/forum/threads/how-do-i-delete-a-row-from-the-table-example.8799/
		sql.ExecNonQuery("DELETE FROM ingresos_recurrentes WHERE id_ingreso_recurrente = '" & idRegistro & "'")
		
		'Se simula el reinicio del activity
		'https://www.b4x.com/android/forum/threads/restarting-an-activity.106576/
		Activity.Finish
		StartActivity(Me)
	End If
End Sub