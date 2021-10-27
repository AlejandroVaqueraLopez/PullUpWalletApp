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
	Dim alturaDispositivo As Int
	Dim anchoDispositivo As Int
	Dim tipoIngreso As String
	Dim colorCaja As Int
	Dim diasPeriodo As Int
	Dim aparicionMsgBox1 As Boolean
	Dim aparicionMsgBox2 As Boolean
	Dim aparicionMsgBox3 As Boolean
	Dim esquinas As ColorDrawable
	Dim esquinas2 As ColorDrawable
	Dim cur As Cursor
	Dim ingresosActuales As Int
	
	'Views
	'Botones
	Private btnMenu As Button
	Private btnOperacionIngreso As Button
	Private btnRecurrente As Button
	Private btnUnico As Button
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
	Activity.LoadLayout("LFormIngreso")
	alturaDispositivo = GetDeviceLayoutValues.Height
	anchoDispositivo = GetDeviceLayoutValues.Width
	btnRecurrente.TextColor = Colors.White
	btnUnico.TextColor = Colors.Black
	tipoIngreso = "Recurrente"
	sql = Starter.sql
	diasPeriodo = 7
	
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
	txtMonto.Top = lblNombreVista.Top * 1.5 + lblNombreVista.Height
	txtMonto.Left = (anchoDispositivo - txtMonto.Width) / 2
	lblFondoMonto.Width = txtMonto.Width
	lblFondoMonto.Height = txtMonto.Height
	lblFondoMonto.Top = txtMonto.Top
	lblFondoMonto.Left = txtMonto.Left
	'Botones de tipo de ingreso
	'Botón de ingreso recurrente
	btnRecurrente.Width = anchoDispositivo * 0.3
	btnRecurrente.Height = alturaDispositivo * 0.05
	btnRecurrente.Top = txtMonto.Top + txtMonto.Height + lblNombreVista.Top / 2
	btnRecurrente.Left = ((anchoDispositivo / 2) - btnRecurrente.Width) / 2
	'Botón de ingreso único
	btnUnico.Width = btnRecurrente.Width
	btnUnico.Height = btnRecurrente.Height
	btnUnico.Top = btnRecurrente.Top
	btnUnico.Left = (anchoDispositivo / 2) + btnRecurrente.Left
	'Caja de texto del nombre
	txtNombre.Width = anchoDispositivo * 0.9
	txtNombre.Height = alturaDispositivo * 0.07
	txtNombre.Top = btnRecurrente.Top + btnRecurrente.Height + lblNombreVista.Top / 2
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
	'Selector de color
	pnlSelector.Top = txtDescripcion.Top + txtDescripcion.Height + lblNombreVista.Top / 2
	pnlSelector.Left = txtDescripcion.Left + txtDescripcion.Width - pnlSelector.Width
	'Panel contenedor de radiobuttons
	pnlPeriodos.Top = pnlSelector.Top
	pnlPeriodos.Left = txtDescripcion.Left
	pnlPeriodos.Width = (txtDescripcion.Width - pnlSelector.Width) * 0.9
	pnlPeriodos.Height = pnlSelector.Height
	'Radiobuttons
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
	
	'Botón de operación con el ingreso
	btnOperacionIngreso.Text = "Guardar ingreso"
	btnOperacionIngreso.Top = pnlPeriodos.Top + pnlPeriodos.Height + (lblContornoBoton.Top - (pnlPeriodos.Top + pnlPeriodos.Height + btnOperacionIngreso.Height)) / 2
	btnOperacionIngreso.Left = (anchoDispositivo - btnOperacionIngreso.Width) / 2
End Sub

Sub Activity_Resume
	
End Sub

Sub Activity_Pause (UserClosed As Boolean)
	
End Sub

Private Sub btnMenu_Click
	Activity.Finish
End Sub

'Activa los botones de radio de los periodos y cambia el color del btnRecurrente a blanco (indicativo de que está presionado)
'y el color del btnUnico (indicativo de que no está presionado). Guarda en una variable, el tipo de ingreso elegido según
'el botón
Private Sub btnRecurrente_Click
	tipoIngreso = "Recurrente"
	Log(tipoIngreso)
	rd1Semana.Enabled = True
	rd2Semanas.Enabled = True
	rd3Semanas.Enabled = True
	rd1Mes.Enabled = True
	rd1Ano.Enabled = True
	btnRecurrente.TextColor = Colors.White
	btnUnico.TextColor = Colors.Black
	esquinas.Initialize(Colors.RGB(121,80,242), 20)
	esquinas2.Initialize(Colors.RGB(237,237,237), 20)
	btnRecurrente.Background = esquinas
	btnUnico.Background = esquinas2
End Sub

'Activa los botones de radio de los periodos y cambia el color del btnUnico a blanco (indicativo de que está presionado)
'y el color del btnRecurrente (indicativo de que no está presionado). Guarda en una variable, el tipo de ingreso elegido según
'el botón
Private Sub btnUnico_Click
	tipoIngreso = "Unico"
	Log(tipoIngreso)
	rd1Semana.Enabled = False
	rd2Semanas.Enabled = False
	rd3Semanas.Enabled = False
	rd1Mes.Enabled = False
	rd1Ano.Enabled = False
	btnRecurrente.TextColor = Colors.Black
	btnUnico.TextColor = Colors.White
	esquinas.Initialize(Colors.RGB(237,237,237), 20)
	esquinas2.Initialize(Colors.RGB(121,80,242), 20)
	btnRecurrente.Background = esquinas
	btnUnico.Background = esquinas2
End Sub

'Verifica que los campos necesarios hayan sido rellenados, según el tipo de ingreso seleccionado
Sub validarCampos As Boolean
	If(txtMonto.Text.Length <> 0 And txtNombre.Text.Length <> 0 And txtDescripcion.Text.Length <> 0 And colorCaja <> 0) Then
		If(tipoIngreso = "Recurrente" And diasPeriodo <> 0) Then
			Return True
		Else If(tipoIngreso = "Unico") Then
			Return True
		Else
			Return False
		End If
	Else
		Return False
	End If
End Sub

'Captura el color elegido con el selector de colores y lo asigna a la etiqueta de fondo del monto y guarda el valor
'del color en una variable
Private Sub cpBarraColor_ColorChanged(color As Int)
	lblFondoMonto.Color = color
	colorCaja = color
End Sub

'Obtiene la fecha actual del sistema
Sub obtenerFechaActual As Long
	Dim ahora As Long
	ahora = DateTime.Now
	Return ahora
	'https://www.b4x.com/android/help/core.html#datetime OBTENIDO DE AQUI
End Sub

'Obtiene la fecha próxima de cobro en donde se le suma el periodo a la fecha actual del sistema. Esta sirve para
'que, cuando se registre el ingreso recurrente, se realice un primer cobro de la fuente de ingreso en la fecha de hoy
'así, la próxima fecha de cobro sería la fecha de hoy más el periodo
Sub fechaMasPeriodo(periodo As Int) As String
	Dim fechaActual As String
	Dim fechaProxima As Long
	
	fechaActual = DateTime.Date(obtenerFechaActual)
	fechaProxima = DateTime.DateParse(fechaActual)
	fechaProxima = DateTime.Add(fechaProxima, 0, 0, periodo)
	
	Return DateTime.Date(fechaProxima)
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
Private Sub txtMonto_TextChanged (Old As String, New As String) 'Al mandar un numero limite de digitos a capturar, mandar n+1
	limitarLongitudEntrada(Old, New, 9, txtMonto, "monto")
End Sub

Private Sub txtNombre_TextChanged (Old As String, New As String)
	limitarLongitudEntrada(Old, New, 16, txtNombre, "nombre")
End Sub

Private Sub txtDescripcion_TextChanged (Old As String, New As String)
	limitarLongitudEntrada(Old, New, 41, txtDescripcion, "descripcion")
End Sub

'Los siguientes eventos asignan el periodo en días en la variable diasPeriodo para el ingreso recurrente
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
	Dim ingreso As RegistroIngreso
	'Guarda el monto
	ingreso.monto = txtMonto.Text
	'Guarda el nombre
	ingreso.nombre = txtNombre.Text
	'Guarda la descripción
	ingreso.descripcion = (txtDescripcion.Text)
	'Guarda el periodo
	ingreso.periodo = diasPeriodo
	'Guarda la próxima fecha de cobro
	ingreso.fechaCobro = fechaMasPeriodo(ingreso.periodo)
	'Guarda el color elegido
	ingreso.color = colorCaja
	
	Return ingreso
End Sub

'Valida el rellenado de los campos, obtiene el objeto de tipo RegistroIngreso de asignacionCampos y realiza la inserción 
'del registro en la respectiva tabla según el tipo elegido
Private Sub btnOperacionIngreso_Click
	Dim cur As Cursor
	Dim validaciones As Boolean
	Dim ingresosActuales As Int
	'Valida que los campos se hayan llenado satisfactoriamente
	validaciones = validarCampos
	If(validaciones = True) Then
		'Si los campos están llenos, se obtiene el objeto ya validado con los campos del formulario
		Dim ingresoRegistrar As RegistroIngreso
		ingresoRegistrar = asignacionCampos
		
		'Si el tipo de ingreso elegido es recurrente, se realiza la inserción en la tabla ingresos_recurrentes
		If(tipoIngreso = "Recurrente") Then
			sql.ExecNonQuery2("INSERT INTO ingresos_recurrentes (monto, nombre, descripcion, periodo, fecha_cobro, color) VALUES (?, ?, ?, ?, ?, ?)", Array As Object(ingresoRegistrar.monto, ingresoRegistrar.nombre, ingresoRegistrar.descripcion, ingresoRegistrar.periodo, ingresoRegistrar.fechaCobro, ingresoRegistrar.color))
			
			'Actualizar los ingresos totales
			'Sentencia para consultar la suma de ingresos
			cur = sql.ExecQuery("SELECT suma_ingresos FROM ingresos")
			cur.Position = 0
			ingresosActuales = cur.GetInt("suma_ingresos")
		
			'Sentencia para actualizar los ingresos dado el primer cobro del ingreso recurrente
			sql.ExecNonQuery2("UPDATE ingresos SET suma_ingresos = ? WHERE id_ingreso = 1", Array As Object((ingresosActuales + ingresoRegistrar.monto)))

			
			ToastMessageShow("Ingreso registrado",True)
			'Cierra este activity
			Activity.Finish
			'Abre el activity de IngresosRecurrentes
			StartActivity(IngresosRecurrentes)
			'Si el tipo de ingreso elegido es Unico, se realiza la inserción en la tabla ingresos_unicos
		Else If(tipoIngreso = "Unico") Then
			sql.ExecNonQuery2("INSERT INTO ingresos_unicos (monto, nombre, descripcion, fecha_registro, color) VALUES (?, ?, ?, ?, ?)", Array As Object(ingresoRegistrar.monto, ingresoRegistrar.nombre, ingresoRegistrar.descripcion, ingresoRegistrar.fechaCobro, ingresoRegistrar.color))
			
			'Actualizar los ingresos totales
			'Sentencia para consultar la suma de ingresos
			cur = sql.ExecQuery("SELECT suma_ingresos FROM ingresos")
			cur.Position = 0
			ingresosActuales = cur.GetInt("suma_ingresos")
			'Sentencia para actualizar los ingresos dado el ingreso realizado
			sql.ExecNonQuery2("UPDATE ingresos SET suma_ingresos = ? WHERE id_ingreso = 1", Array As Object((ingresosActuales + ingresoRegistrar.monto)))
			
			ToastMessageShow("Ingreso registrado",True)
			'Cierra este activity
			Activity.Finish
			'Abre el activity de IngresosUnicos
			StartActivity(IngresosUnicos)
		End If
	Else
		'Manda un mensaje aclarativo sobre rellenar los campos de forma correcta
		Msgbox2("Por favor, rellene todos los campos, seleccione un periodo y color", "Registro incorrecto", "Entendido", "", "", Null)
	End If
End Sub