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
	Type RegistroGasto(nombre As String, monto As Int, descripcion As String, fechaRegistro As String, color As Int)
	Dim alturaDispositivo As Int
	Dim anchoDispositivo As Int
	Dim colorCaja As Int
	Dim aparicionMsgBox1 As Boolean
	Dim aparicionMsgBox2 As Boolean
	Dim aparicionMsgBox3 As Boolean
	Dim cur As Cursor
	
	'Views
	Private btnMenu As Button
	Private txtDescripcion As EditText
	Private txtMonto As EditText
	Private txtNombre As EditText
	Private lblFondoMonto As Label
	Private btnNotificacion As Button
	Private lblFondoDescripcion As Label
	Private lblFondoNombre As Label
	Private cpBarraColor As ASColorSlider  'Miembro generado de la barra selectora de colores
	Private lblContornoBoton As Label
	Private pnlNavInferior As Panel
	Private lblNombreVista As Label
	Private btnOperacionGasto As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("LFormGasto")
	alturaDispositivo = Main.alturaDispositivo
	anchoDispositivo = Main.anchoDispositivo
	sql = Starter.sql
	aparicionMsgBox1 = False
	aparicionMsgBox2 = False
	aparicionMsgBox3 = False
	colorCaja = 0
	
	btnOperacionGasto.Text = "Guardar gasto"

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
	
'///////////////////////////////////// VERIFICACION DE CAMPOS (LLENADO)////////////////////////////////////////////////////////////////////////////////////////
Sub validarCampos As Boolean
	'Valida si todos los campos están llenos
	If ((Not(txtMonto.Text.Length = 0)) And (Not(txtNombre.Text.Length = 0)) And (Not(txtDescripcion.Text.Length = 0)) And (Not(colorCaja = 0))) Then
		Return True
	Else
		Return False
	End If
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
'///////////////////////////////////////////ASIGNACION DE VALORES DE ENTRADA A VARIABLES///////////////////////////////////////////////////////////////////////////////////////
									
									'////////////////////////////////////////////
									'//////////OBTENCION DE FECHA ACTUAL/////////
									'////////////////////////////////////////////
Sub obtenerFechaActual As String
	Dim ahora As Long
	ahora = DateTime.Now
	Return (DateTime.Date(ahora))
	'https://www.b4x.com/android/help/core.html#datetime OBTENIDO DE AQUI
End Sub
									'////////////////////////////////////////////
									'//////////ELECCION DE COLOR-PICKER//////////
									'////////////////////////////////////////////
Sub cpBarraColor_ColorChanged(color As Int)
	lblFondoMonto.Color = color  'Devuelve la variable numerica "color" y se puede asignar a cualquier propiedad
	colorCaja = color
End Sub
									'////////////////////////////////////////////
									'//////////ASIGNACION DE VARIABLES///////////
									'////////////////////////////////////////////

Sub asignacionCampos As RegistroGasto
	'Captura de todos los datos dentro de variables
	Dim gasto As RegistroGasto
	'Añadir monto
	gasto.monto = txtMonto.Text
	'Añadir nombre
	gasto.nombre = txtNombre.Text
	'Añadir descripción
	gasto.descripcion = (txtDescripcion.Text)
	'Añadir fecha de registro
	gasto.fechaRegistro = obtenerFechaActual
	'Color de la tarjeta se asigna desde su subrutina de obtencion de color
	gasto.color = colorCaja
	
	Return gasto
End Sub

'//////////////////////////////////////////////////REGISTRO DE GASTO UNICO///////////////////////////////////////////////////////////////////////////////////

Private Sub btnOperacionGasto_Click
	Dim validaciones As Boolean
	validaciones = validarCampos 'Validamos que se hayan llenado
	If(validaciones = True) Then
		'Si los campos estan llenos, se asignan los valores a las variables
		Dim gastoRegistrar As RegistroGasto
		gastoRegistrar = asignacionCampos

		'/////////////////////////////////////////Solicitud de ingreso de datos a la BD/////////////////////////////////////////////////////////////////////
		'Sentencia para insertar datos a la tabla "ingresos"
			
									'////////////////////////////////////////////
									'///////REGISTRO DE SUSCRIPCION//////////////
									'////////////////////////////////////////////
									
									'////////////////////////////////////////////
									'///SOLICITUD DE INGRESO DE DATOS A LA BD////
									'////////////////////////////////////////////
									
		sql.ExecNonQuery2("INSERT INTO gastos (monto, nombre, descripcion, fecha_registro, color) VALUES (?, ?, ?, ?, ?)", Array As Object(gastoRegistrar.monto, gastoRegistrar.nombre, gastoRegistrar.descripcion, gastoRegistrar.fechaRegistro, gastoRegistrar.color))

		ToastMessageShow("Gasto registrado",True)
		Activity.Finish
		StartActivity(Gastos)
	Else
		Msgbox2("Por favor, rellene todos los campos y seleccione un color", "Registro incorrecto", "Entendido", "", "", Null)
	End If
End Sub

Sub consultaAEditar(rowid As Int)
	Dim gasto As RegistroGasto
	
	cur = sql.ExecQuery("SELECT * FROM gastos ORDER BY rowid ASC")
	If(cur.RowCount > 0) Then
		cur.Position = rowid
		gasto.nombre = cur.GetString("nombre")
		gasto.monto = cur.GetInt("monto")
		gasto.descripcion = cur.GetString("descripcion")
		gasto.color = cur.GetString("color")
		
		reasignarCamposAEditar(gasto)
	End If
End Sub

Sub reasignarCamposAEditar(registro As RegistroGasto)
	txtNombre.Text = registro.nombre
	txtMonto.Text = registro.monto
	txtDescripcion.Text = registro.descripcion
	cpBarraColor_ColorChanged(registro.color)
End Sub