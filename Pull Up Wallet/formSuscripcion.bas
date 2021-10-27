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
	'These global variables will be redeclared each time the activity is created
	Type RegistroSuscripcion(nombre As String, monto As Int, descripcion As String, periodo As Int, fechaRegistro As String, color As Int)
	Dim alturaDispositivo As Int
	Dim anchoDispositivo As Int
	Dim colorCaja As Int
	Dim diasPeriodo As Int
	Dim aparicionMsgBox1 As Boolean
	Dim aparicionMsgBox2 As Boolean
	Dim aparicionMsgBox3 As Boolean
	
	'Views
	Private btnMenu As Button
	Private txtDescripcion As EditText
	Private txtMonto As EditText
	Private txtNombre As EditText
	Private lblFondoMonto As Label
	Private lblFondoDescripcion As Label
	Private lblFondoNombre As Label
	Private cpBarraColor As ASColorSlider  'Miembro generado de la barra selectora de colores
	Private rd1Ano As RadioButton
	Private rd1Mes As RadioButton
	Private rd1Semana As RadioButton
	Private rd2Semanas As RadioButton
	Private rd3Semanas As RadioButton
	Private btnGuardarSuscripcion As Button
	Private lblContornoBoton As Label
	Private pnlNavInferior As Panel
	Private lblNombreVista As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("LRegistrarSuscripcion")
	alturaDispositivo = Main.alturaDispositivo
	anchoDispositivo = Main.anchoDispositivo
	sql = Starter.sql
	aparicionMsgBox1 = False
	aparicionMsgBox2 = False
	aparicionMsgBox3 = False
	diasPeriodo = 0
	colorCaja = 0
	
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
End Sub

Sub Activity_Resume
End Sub

Sub Activity_Pause (UserClosed As Boolean)
End Sub

Private Sub btnNotificacion_CheckedChange(Checked As Boolean)
End Sub

Private Sub btnMenu_Click
	Activity.Finish 'REGRESAR A MENU
End Sub

Private Sub btnNotificacion_Click
End Sub

'///////////////////////////////////// VERIFICACION DE CAMPOS (LLENADO)////////////////////////////////////////////////////////////////////////////////////////
Sub validarCampos As Boolean
	'Valida si todos los campos están llenos
	If ((Not(txtMonto.Text.Length = 0)) And (Not(txtNombre.Text.Length = 0)) And (Not(txtDescripcion.Text.Length = 0)) And (Not(colorCaja = 0)) And (Not(diasPeriodo = 0)) And (Not(diasPeriodo = 0))) Then
		Return True
	Else
		Return False
	End If
End Sub

'MODULO DE ELECCION DE COLOR
Sub cpBarraColor_ColorChanged(color As Int)
	lblFondoMonto.Color = color  'Devuelve la variable numerica "color" y se puede asignar a cualquier propiedad
	colorCaja = color
End Sub

Sub obtenerFechaActual As String
	Dim ahora As Long
	ahora = DateTime.Now
	Return (DateTime.Date(ahora))
	'https://www.b4x.com/android/help/core.html#datetime OBTENIDO DE AQUI
End Sub
'///////////////////////////////////// VERIFICACION DE CAMPOS (LONGITUD)////////////////////////////////////////////////////////////////////////////////////////
'Esta subrutina me verifica que el usuario no ingrese mas digitos de los que se tienen como límite en cada entrada
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
									'/////////////////////////////////////////////////////////////////////////////
									'//////////EJECUCION DE VERIFICACION DE LONGITUD DE DIGITOS EN CAMPOS/////////
									'/////////////////////////////////////////////////////////////////////////////
									
Private Sub txtMonto_TextChanged (Old As String, New As String) 'Al mandar un numero limite de digitos a capturar, mandar n+1
	limitarLongitudEntrada(Old, New, 9, txtMonto, "monto")
End Sub

Private Sub txtNombre_TextChanged (Old As String, New As String)
	limitarLongitudEntrada(Old, New, 16, txtNombre, "nombre")
End Sub

Private Sub txtDescripcion_TextChanged (Old As String, New As String)
	limitarLongitudEntrada(Old, New, 41, txtDescripcion, "descripcion")
End Sub

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

Sub asignacionCampos As RegistroSuscripcion
	'Captura de todos los datos dentro de variables
	Dim susripcion As RegistroSuscripcion
	'Añadir monto
	susripcion.monto = txtMonto.Text
	'Añadir nombre
	susripcion.nombre = txtNombre.Text
	'Añadir descripción
	susripcion.descripcion = (txtDescripcion.Text)
	'Añadir periodo
	susripcion.periodo = diasPeriodo
	'Añadir fecha de registro
	susripcion.fechaRegistro = obtenerFechaActual
	'Color de la tarjeta se asigna desde su subrutina de obtencion de color
	susripcion.color = colorCaja
	
	Return susripcion
End Sub

Private Sub btnGuardarSuscripcion_Click
	Dim validaciones As Boolean
	validaciones = validarCampos 'Validamos que se hayan llenado
	If(validaciones = True) Then
		'Si los campos estan llenos, se asignan los valores a las variables
		Dim suscripcionRegistrar As RegistroSuscripcion
		suscripcionRegistrar = asignacionCampos

		'/////////////////////////////////////////Solicitud de ingreso de datos a la BD/////////////////////////////////////////////////////////////////////
		'Sentencia para insertar datos a la tabla "ingresos"
			
		'////////////////////////////////////////////
		'///////REGISTRO DE SUSCRIPCION//////////////
		'////////////////////////////////////////////
									
		'////////////////////////////////////////////
		'///SOLICITUD DE INGRESO DE DATOS A LA BD////
		'////////////////////////////////////////////
									
		sql.ExecNonQuery2("INSERT INTO suscripciones (monto, nombre, descripcion, periodo, fecha_registro, color) VALUES (?, ?, ?, ?, ?, ?)", Array As Object(suscripcionRegistrar.monto, suscripcionRegistrar.nombre, suscripcionRegistrar.descripcion, suscripcionRegistrar.periodo, suscripcionRegistrar.fechaRegistro, suscripcionRegistrar.color))

		ToastMessageShow("Suscrpción registrado",True)
		Activity.Finish
		StartActivity(Suscripciones)
	Else
		Msgbox2("Por favor, rellene todos los campos, seleccione un periodo y color", "Registro incorrecto", "Entendido", "", "", Null)
	End If
End Sub