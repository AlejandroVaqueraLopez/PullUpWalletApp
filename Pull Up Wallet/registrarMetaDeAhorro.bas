B4A=true
Group=Default Group\Formularios\Registrar
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
	Type RegistroMetaAhorro(nombre As String, montoAhorro As Int, montoMeta As Int, descripcion As String, periodo As Int, progreso As Int, fechaRegistro As String, color As Int)
	Dim alturaDispositivo As Int
	Dim anchoDispositivo As Int
	Dim colorCaja As Int
	Dim diasPeriodo As Int
	Dim aparicionMsgBox1 As Boolean
	Dim aparicionMsgBox2 As Boolean
	Dim aparicionMsgBox3 As Boolean
	Dim aparicionMsgBox4 As Boolean
	
	'Views
	Private btnMenu As Button
	Private txtDescripcion As EditText
	Private txtNombre As EditText
	Private btnNotificacion As Button
	Private lblFondoDescripcion As Label
	Private lblFondoNombre As Label
	Private cpBarraColor As ASColorSlider  'Miembro generado de la barra selectora de colores
	Private rd1Ano As RadioButton
	Private rd1Mes As RadioButton
	Private rd1Semana As RadioButton
	Private rd2Semanas As RadioButton
	Private rd3Semanas As RadioButton
	Private lblFondoMetaAhorro As Label
	Private lblFondoMontoAhorro As Label
	Private txtMetaAhorro As EditText
	Private txtMontoAhorro As EditText
	Private btnGuardarMetaDeAhorro As Button
	Private lblContornoBoton As Label
	Private pnlNavInferior As Panel
	Private lblNombreVista As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("LRegistrarMetaDeAhorro")
	alturaDispositivo = Main.alturaDispositivo
	anchoDispositivo = Main.anchoDispositivo
	sql = Starter.sql
	aparicionMsgBox1 = False
	aparicionMsgBox2 = False
	aparicionMsgBox3 = False
	aparicionMsgBox4 = False
	colorCaja = 0
	diasPeriodo = 0
	
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
	Activity.Finish
End Sub

Private Sub btnNotificacion_Click
End Sub

Sub validarCampos As Boolean
	'Valida si todos los campos estan llenos
	If ((Not(txtMetaAhorro.Text.Length = 0)) And (Not(txtNombre.Text.Length = 0)) And (Not(txtDescripcion.Text.Length = 0)) And (Not(txtMontoAhorro.Text.Length = 0)) And (Not(colorCaja = 0)) And (Not(diasPeriodo = 0))) Then
		Return True
	Else
		Return False
	End If
End Sub

'MODULO DE ELECCION DE COLOR
Private Sub cpBarraColor_ColorChanged(color As Int)
	lblFondoMontoAhorro.Color = color  'Devuelve la variable numerica "color" y se puede asignar a cualquier propiedad
	lblFondoMetaAhorro.Color = color  'Devuelve la variable numerica "color" y se puede asignar a cualquier propiedad
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
		If(campo = "montoAhorro") Then
			If(aparicionMsgBox1 = False) Then
				Msgbox2("La longitud máxima permitida para el monto del ahorro es de " & longitud & " caracteres", "Límite alcanzado", "Entendido", "", "", Null)
				aparicionMsgBox1 = True
			End If
		Else If(campo = "metaAhorro") Then
			If(aparicionMsgBox2 = False) Then
				Msgbox2("La longitud máxima permitida para la monto meta es de " & longitud & " caracteres", "Límite alcanzado", "Entendido", "", "", Null)
				aparicionMsgBox2 = True 
			End If
		Else If(campo = "nombre") Then
			If(aparicionMsgBox3 = False) Then
				Msgbox2("La longitud máxima permitida para el nombre es de " & longitud & " caracteres", "Límite alcanzado", "Entendido", "", "", Null)
				aparicionMsgBox3 = True
			End If
		Else If(campo = "descripcion") Then
			If(aparicionMsgBox4 = False) Then
				Msgbox2("La longitud máxima permitida para la descripción es de " & longitud & " caracteres", "Límite alcanzado", "Entendido", "", "", Null)
				aparicionMsgBox4 = True
			End If
		End If
		view.Text = antiguo
	End If
End Sub

Private Sub txtNombre_TextChanged (Old As String, New As String)
	limitarLongitudEntrada(Old, New, 16, txtNombre, "nombre")
End Sub

Private Sub txtMontoAhorro_TextChanged (Old As String, New As String)
	limitarLongitudEntrada(Old ,New, 9, txtMontoAhorro, "montoAhorro")
End Sub

Private Sub txtMetaAhorro_TextChanged (Old As String, New As String)
	limitarLongitudEntrada(Old, New, 9, txtMetaAhorro, "metaAhorro")
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

Sub asignacionCampos As RegistroMetaAhorro
	'Captura de todos los datos dentro de variables
	Dim metaAhorro As RegistroMetaAhorro
	'Añadir monto meta
	metaAhorro.montoMeta = txtMetaAhorro.Text
	'Añadir monto ahorro (periódico)
	metaAhorro.montoAhorro = txtMontoAhorro.Text
	'Añadir nombre
	metaAhorro.nombre = txtNombre.Text
	'Añadir descripción
	metaAhorro.descripcion = (txtDescripcion.Text)
	'Añadir periodo
	metaAhorro.periodo = diasPeriodo
	'Añadir el progreso inicial
	metaAhorro.progreso = 0
	'Añadir fecha de registro
	metaAhorro.fechaRegistro = obtenerFechaActual
	'Color de la tarjeta se asigna desde su subrutina de obtencion de color
	metaAhorro.color = colorCaja
	
	Return metaAhorro
End Sub

Private Sub btnGuardarMetaDeAhorro_Click
	Dim validaciones As Boolean
	validaciones = validarCampos 'Validamos que se hayan llenado
	If(validaciones = True) Then
		'Si los campos estan llenos, se asignan los valores a las variables
		Dim metaAhorroRegistrar As RegistroMetaAhorro
		metaAhorroRegistrar = asignacionCampos

		'/////////////////////////////////////////Solicitud de ingreso de datos a la BD/////////////////////////////////////////////////////////////////////
		'Sentencia para insertar datos a la tabla "ingresos"
			
		'////////////////////////////////////////////
		'///////REGISTRO DE SUSCRIPCION//////////////
		'////////////////////////////////////////////
									
		'////////////////////////////////////////////
		'///SOLICITUD DE INGRESO DE DATOS A LA BD////
		'////////////////////////////////////////////
									
		sql.ExecNonQuery2("INSERT INTO metas_ahorro (monto_meta, monto_ahorro, nombre, descripcion, periodo_ahorro, progreso, fecha_registro, color) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", Array As Object(metaAhorroRegistrar.montoMeta, metaAhorroRegistrar.montoAhorro, metaAhorroRegistrar.nombre, metaAhorroRegistrar.descripcion, metaAhorroRegistrar.periodo, metaAhorroRegistrar.progreso, metaAhorroRegistrar.fechaRegistro, metaAhorroRegistrar.color))
		
		ToastMessageShow("Meta de ahorro registrada",True)
		Activity.Finish
		StartActivity(MetasDeAhorro)
	Else
		Msgbox2("Por favor, rellene todos los campos, seleccione un periodo y color", "Registro incorrecto", "Entendido", "", "", Null)
	End If
End Sub