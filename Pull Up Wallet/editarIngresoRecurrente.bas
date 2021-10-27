B4A=true
Group=Default Group\Formularios
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
	Dim alturaDispositivo As Int
	Dim anchoDispositivo As Int
	Dim colorCaja As Int
	Dim diasPeriodo As Int
	Dim aparicionMsgBox1 As Boolean
	Dim aparicionMsgBox2 As Boolean
	Dim aparicionMsgBox3 As Boolean
	Dim cur As Cursor
	Dim idRegistro As Int
	
	'Views
	'Botones
	Private btnMenu As Button
	Private btnOperacionIngresoRecurrente As Button
	'Cajas de texto
	Private txtDescripcion As EditText
	Private txtMonto As EditText
	Private txtNombre As EditText
	'Etiquetas
	Private lblContornoBoton As Label
	Private lblFondoDescripcion As Label
	Private lblFondoMonto As Label
	Private lblFondoNombre As Label
	Private lblNombreVista As Label
	'Botones de radio
	Private rd1Ano As RadioButton
	Private rd1Mes As RadioButton
	Private rd1Semana As RadioButton
	Private rd2Semanas As RadioButton
	Private rd3Semanas As RadioButton
	'Páneles
	Private pnlPeriodos As Panel
	Private pnlSelector As Panel
	Private pnlNavInferior As Panel
	'Otros views
	Private cpBarraColor As ASColorSlider
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("LEditarIngresoRecurrente")
	alturaDispositivo = Main.alturaDispositivo
	anchoDispositivo = Main.anchoDispositivo
	sql = Starter.sql
	aparicionMsgBox1 = False
	aparicionMsgBox2 = False
	aparicionMsgBox3 = False
	
	'Etiqueta declarativa del view
	lblNombreVista.TextSize = 20
	lblNombreVista.TextColor = Colors.Black
	lblNombreVista.Height = 30dip
	lblNombreVista.Width = anchoDispositivo * 0.9
	lblNombreVista.Top = 30dip
	lblNombreVista.Left = (anchoDispositivo - lblNombreVista.Width) / 2
	'Caja de texto del monto
	txtMonto.Width = anchoDispositivo * 0.9
	txtMonto.Height = alturaDispositivo * 0.22
	txtMonto.Top = lblNombreVista.Top * 2 + lblNombreVista.Height
	txtMonto.Left = (anchoDispositivo - txtMonto.Width) / 2
	lblFondoMonto.Width = txtMonto.Width
	lblFondoMonto.Height = txtMonto.Height
	lblFondoMonto.Top = txtMonto.Top
	lblFondoMonto.Left = txtMonto.Left
	'Caja de texto del nombre
	txtNombre.Width = anchoDispositivo * 0.9
	txtNombre.Height = alturaDispositivo * 0.07
	txtNombre.Top = txtMonto.Top + txtMonto.Height + lblNombreVista.Top / 2
	txtNombre.Left = (anchoDispositivo - txtNombre.Width) / 2
	lblFondoNombre.Width = txtMonto.Width
	lblFondoNombre.Height = txtNombre.Height
	lblFondoNombre.Top = txtNombre.Top
	lblFondoNombre.Left = txtNombre.Left
	'Caja de texto de descripción
	txtDescripcion.Width = txtNombre.Width
	txtDescripcion.Height = txtNombre.Height
	txtDescripcion.Top = txtNombre.Top + txtNombre.Height + lblNombreVista.Top / 2
	txtDescripcion.Left = txtNombre.Left
	lblFondoDescripcion.Width = txtDescripcion.Width
	lblFondoDescripcion.Height = txtDescripcion.Height
	lblFondoDescripcion.Top = txtDescripcion.Top
	lblFondoDescripcion.Left = txtDescripcion.Left
	'Panel para el selector de color
	pnlSelector.Top = txtDescripcion.Top + txtDescripcion.Height + lblNombreVista.Top / 2
	pnlSelector.Left = txtDescripcion.Left + txtDescripcion.Width - pnlSelector.Width
	'Panel contenedor de radiobuttons
	pnlPeriodos.Top = pnlSelector.Top
	pnlPeriodos.Left = txtDescripcion.Left
	pnlPeriodos.Width = (txtDescripcion.Width - pnlSelector.Width) * 0.9
	pnlPeriodos.Height = pnlSelector.Height
	'Botones de radio
	'1 semana
	rd1Semana.Width = pnlPeriodos.Width
	rd1Semana.Height = pnlPeriodos.Height * 0.18
	rd1Semana.Left = 0
	rd1Semana.Top = 0
	'2 semanas
	rd2Semanas.Width = rd1Semana.Width
	rd2Semanas.Height = rd1Semana.Height
	rd2Semanas.Left = rd1Semana.Left
	rd2Semanas.Top = rd1Semana.Height + pnlPeriodos.Height * 0.025
	'3 semanas
	rd3Semanas.Width = rd1Semana.Width
	rd3Semanas.Height = rd1Semana.Height
	rd3Semanas.Left = rd1Semana.Left
	rd3Semanas.Top = rd2Semanas.Top + rd2Semanas.Height + pnlPeriodos.Height * 0.025
	'1 mes
	rd1Mes.Width = rd1Semana.Width
	rd1Mes.Height = rd1Semana.Height
	rd1Mes.Left = rd1Semana.Left
	rd1Mes.Top = rd3Semanas.Top + rd3Semanas.Height + pnlPeriodos.Height * 0.025
	'1 año
	rd1Ano.Width = rd1Semana.Width
	rd1Ano.Height = rd1Semana.Height
	rd1Ano.Left = rd1Semana.Left
	rd1Ano.Top = rd1Mes.Top + rd1Mes.Height + pnlPeriodos.Height * 0.025
	
	'-----------------------------------------------------------------------------------------
	
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
	
	'Botón de operación con el ingreso recurrente
	btnOperacionIngresoRecurrente.Text = "Editar ingreso recurrente"
	btnOperacionIngresoRecurrente.Top = pnlPeriodos.Top + pnlPeriodos.Height + (lblContornoBoton.Top - (pnlPeriodos.Top + pnlPeriodos.Height + btnOperacionIngresoRecurrente.Height)) / 2
	btnOperacionIngresoRecurrente.Left = (anchoDispositivo - btnOperacionIngresoRecurrente.Width) / 2
End Sub

Sub Activity_Resume
End Sub

Sub Activity_Pause (UserClosed As Boolean)
End Sub

Private Sub btnMenu_Click
	Activity.Finish 'REGRESAR A MENU
End Sub

'Verifica que los campos necesarios hayan sido rellenados
Sub validarCampos As Boolean
	If(txtMonto.Text.Length <> 0 And txtNombre.Text.Length <> 0 And txtDescripcion.Text.Length <> 0 And colorCaja <> 0 And diasPeriodo <> 0) Then
		Return True
	Else
		Return False
	End If
End Sub

'Captura el color elegido con el selector de colores y lo asigna a la etiqueta de fondo del monto y guarda el valor
'del color en una variable
Sub cpBarraColor_ColorChanged(color As Int)
	lblFondoMonto.Color = color
	colorCaja = color
End Sub

'Verifica que los respectivos campos no sobrepasen el límite de caractéres, en dado caso, despliega una alerta para cada campo
'la primera vez que alcanzan el límite, luego, limita el texto ingresado
Sub limitarLongitudEntrada(antiguo As String, nuevo As String, longitud As Int, view As B4XView, campo As String)
	If(nuevo.Length > longitud) Then
		If(campo = "monto") Then
			If(aparicionMsgBox1 = False) Then
				Msgbox2("La longitud máxima permitida para el monto es de " & longitud & " caracteres", "Límite alcanzado", "Entendido", "", "", Null)
				aparicionMsgBox1 = True
			End If
		Else If(campo = "nombre") Then
			If(aparicionMsgBox2 = False) Then
				Msgbox2("La longitud máxima permitida para el nombre es de " & longitud & " caracteres", "Límite alcanzado", "Entendido", "", "", Null)
				aparicionMsgBox2 = True
			End If
		Else If(campo = "descripcion") Then
			If(aparicionMsgBox3 = False) Then
				Msgbox2("La longitud máxima permitida para la descripción es de " & longitud & " caracteres", "Límite alcanzado", "Entendido", "", "", Null)
				aparicionMsgBox3 = True
			End If
		End If
		view.Text = antiguo
	End If
End Sub

'Los siguientes eventos sirven para verificar la longitud de la entrada, y en el peor de los casos, limitar la longitud de la entrada									
Private Sub txtMonto_TextChanged (Old As String, New As String)
	limitarLongitudEntrada(Old, New, 9, txtMonto, "monto")
End Sub

Private Sub txtNombre_TextChanged (Old As String, New As String)
	limitarLongitudEntrada(Old, New, 16, txtNombre, "nombre")
End Sub

Private Sub txtDescripcion_TextChanged (Old As String, New As String)
	limitarLongitudEntrada(Old, New, 41, txtDescripcion, "descripcion")
End Sub

'Los siguientes eventos asignan el periodo en días en la variable diasPeriodo, según el botón de radio presionado
Private Sub rd3Semanas_CheckedChange(Checked As Boolean)
	diasPeriodo = 21
End Sub

Private Sub rd2Semanas_CheckedChange(Checked As Boolean)
	diasPeriodo = 14
End Sub

Private Sub rd1Semana_CheckedChange(Checked As Boolean)
	diasPeriodo = 7
End Sub

Private Sub rd1Mes_CheckedChange(Checked As Boolean)
	diasPeriodo = 30
End Sub

Private Sub rd1Ano_CheckedChange(Checked As Boolean)
	diasPeriodo = 365
End Sub

'Asigna los campos a las propiedades de un objeto de tipo RegistroIngreso y lo retorna
Sub asignacionCampos As RegistroIngreso
	Dim ingresoRecurrente As RegistroIngreso
	'Guarda el monto
	ingresoRecurrente.monto = txtMonto.Text
	'Guarda el nombre
	ingresoRecurrente.nombre = txtNombre.Text
	'Guarda la descripción
	ingresoRecurrente.descripcion = (txtDescripcion.Text)
	'Guarda el periodo
	ingresoRecurrente.periodo = diasPeriodo
	'Guarda el color elegido
	ingresoRecurrente.color = colorCaja
	
	Return ingresoRecurrente
End Sub

'Valida el rellenado de los campos, obtiene el objeto de tipo RegistroIngreso de asignacionCampos y realiza la actualización 
'del registro en la tabla ingresos_recurrentes
Private Sub btnOperacionIngresoRecurrente_Click
	Dim validaciones As Boolean
	'Valida que los campos se hayan llenado satisfactoriamente
	validaciones = validarCampos
	If(validaciones = True) Then
		'Si los campos están llenos, se obtiene el objeto ya validado con los campos del formulario
		Dim ingresoRecurrenteRegistro As RegistroIngreso
		ingresoRecurrenteRegistro = asignacionCampos

		'Sentencia para realizar una actualización en la tabla ingresos_recurrentes
		sql.ExecNonQuery2("UPDATE ingresos_recurrentes SET monto = ?, nombre = ?, descripcion = ?, periodo = ?, color = ? WHERE id_ingreso_recurrente = '" & idRegistro & "'", Array As Object(ingresoRecurrenteRegistro.monto, ingresoRecurrenteRegistro.nombre, ingresoRecurrenteRegistro.descripcion, ingresoRecurrenteRegistro.periodo, ingresoRecurrenteRegistro.color))

		ToastMessageShow("Ingreso recurrente editado",True)
		'Cierra este activity
		Activity.Finish
		'Abre el activity de IngresosRecurrentes
		StartActivity(IngresosRecurrentes)
	Else
		'Manda un mensaje aclarativo sobre rellenar los campos de forma correcta
		Msgbox2("Por favor, rellene todos los campos, seleccione un periodo y color", "Registro incorrecto", "Entendido", "", "", Null)
	End If
End Sub

'Realiza la consulta de los datos del registro a editar y los guarda en las propiedades de un objeto de tipo RegistroIngreso
Sub consultaAEditar(rowid As Int)
	Dim ingresoRecurrente As RegistroIngreso
	idRegistro = rowid

	cur = sql.ExecQuery("SELECT * FROM ingresos_recurrentes WHERE id_ingreso_recurrente = '" & idRegistro & "'")
	If(cur.RowCount > 0) Then
		cur.Position = 0
		ingresoRecurrente.nombre = cur.GetString("nombre")
		ingresoRecurrente.monto = cur.GetInt("monto")
		ingresoRecurrente.descripcion = cur.GetString("descripcion")
		ingresoRecurrente.periodo = cur.GetInt("periodo")
		ingresoRecurrente.color = cur.GetString("color")
		
		reasignarCamposAEditar(ingresoRecurrente)
	End If
End Sub

'Asigna los campos del registro a editar, en los views
Sub reasignarCamposAEditar(registro As RegistroIngreso)
	txtNombre.Text = registro.nombre
	txtMonto.Text = registro.monto
	txtDescripcion.Text = registro.descripcion
	Select registro.periodo
		Case 7
			rd1Semana.Checked = True
		Case 14
			rd2Semanas.Checked = True
		Case 21
			rd3Semanas.Checked = True
		Case 30
			rd1Mes.Checked = True
		Case 365
			rd1Ano.Checked = True
	End Select
	diasPeriodo = registro.periodo
	cpBarraColor_ColorChanged(registro.color)
End Sub