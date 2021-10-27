﻿B4A=true
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
	Dim colorCaja As Int
	Dim diasPeriodo As Int
	Dim aparicionMsgBox1 As Boolean
	Dim aparicionMsgBox2 As Boolean
	Dim aparicionMsgBox3 As Boolean
	Dim cur As Cursor
	Dim egresosActuales As Int
	
	'Views
	'Botones
	Private btnMenu As Button
	Private btnOperacionSuscripcion As Button
	'Cajas de texto
	Private txtDescripcion As EditText
	Private txtMonto As EditText
	Private txtNombre As EditText
	'Etiquetas
	Private lblFondoMonto As Label
	Private lblFondoDescripcion As Label
	Private lblFondoNombre As Label
	Private lblContornoBoton As Label
	Private lblNombreVista As Label
	'Botones de radio
	Private rd1Ano As RadioButton
	Private rd1Mes As RadioButton
	Private rd1Semana As RadioButton
	Private rd2Semanas As RadioButton
	Private rd3Semanas As RadioButton
	'Páneles
	Private pnlNavInferior As Panel
	Private pnlPeriodos As Panel
	Private pnlSelector As Panel
	'Otros views
	Private cpBarraColor As ASColorSlider  'Miembro generado de la barra selectora de colores
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("LFormSuscripcion")
	alturaDispositivo = Main.alturaDispositivo
	anchoDispositivo = Main.anchoDispositivo
	sql = Starter.sql
	aparicionMsgBox1 = False
	aparicionMsgBox2 = False
	aparicionMsgBox3 = False
	diasPeriodo = 7
	colorCaja = 0
	
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
	
	'Botón de operación con la suscripción
	btnOperacionSuscripcion.Text = "Guardar suscripción"
	btnOperacionSuscripcion.Top = pnlPeriodos.Top + pnlPeriodos.Height + (lblContornoBoton.Top - (pnlPeriodos.Top + pnlPeriodos.Height + btnOperacionSuscripcion.Height)) / 2
	btnOperacionSuscripcion.Left = (anchoDispositivo - btnOperacionSuscripcion.Width) / 2
End Sub

Sub Activity_Resume
End Sub

Sub Activity_Pause (UserClosed As Boolean)
End Sub

Private Sub btnMenu_Click
	Activity.Finish 
End Sub

'Verifica que los campos necesarios hayan sido rellenados
Sub validarCampos As Boolean
	If(txtMonto.Text.Length <> 0 And txtNombre.Text.Length <> 0 And txtDescripcion.Text.Length <> 0 And colorCaja <> 0 And diasPeriodo <> 0) Then
		Return True
	Else
		Return False
	End If
End Sub

'Verifica que los campos necesarios hayan sido rellenados
Sub cpBarraColor_ColorChanged(color As Int)
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

'Obtiene la fecha próxima de pago en donde se le suma el periodo a la fecha actual del sistema. Esta sirve para
'que, cuando se registre la suscripción, se realice un primer pago de la suscripción en la fecha de hoy
'así, la próxima fecha de pago sería la fecha de hoy más el periodo
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


'Asigna los campos a las propiedades de un objeto de tipo RegistroMetaAhorro y lo RegistroSuscripcion
Sub asignacionCampos As RegistroSuscripcion
	Dim susripcion As RegistroSuscripcion
	'Guarda el monto
	susripcion.monto = txtMonto.Text
	'Guarda el nombre
	susripcion.nombre = txtNombre.Text
	'Guarda la descripción
	susripcion.descripcion = (txtDescripcion.Text)
	'Guarda el periodo
	susripcion.periodo = diasPeriodo
	'Guarda la fecha próxima del pago
	susripcion.fechaPago = fechaMasPeriodo(susripcion.periodo)
	'Guarda el color elegido
	susripcion.color = colorCaja
	
	Return susripcion
End Sub

'Valida el rellenado de los campos, obtiene el objeto de tipo RegistroSuscripcion de asignacionCampos y realiza la inserción 
'del registro en la tabla suscripciones
Private Sub btnOperacionSuscripcion_Click
	Dim validaciones As Boolean
	'Valida que los campos se hayan llenado satisfactoriamente
	validaciones = validarCampos
	If(validaciones = True) Then
		'Si los campos están llenos, se obtiene el objeto ya validado con los campos del formulario
		Dim suscripcionRegistrar As RegistroSuscripcion
		suscripcionRegistrar = asignacionCampos
		
		'Sentencia para realizar una inserción en la tabla suscripciones
		sql.ExecNonQuery2("INSERT INTO suscripciones (monto, nombre, descripcion, periodo, fecha_pago, color) VALUES (?, ?, ?, ?, ?, ?)", Array As Object(suscripcionRegistrar.monto, suscripcionRegistrar.nombre, suscripcionRegistrar.descripcion, suscripcionRegistrar.periodo, suscripcionRegistrar.fechaPago, suscripcionRegistrar.color))

		'Actualizar los egresos totales
		'Sentencia para consultar la suma de egresos
		cur = sql.ExecQuery("SELECT suma_egresos FROM egresos")
		cur.Position = 0
		egresosActuales = cur.GetInt("suma_egresos")
		
		'Sentencia para actualizar los egresos dado el primer pago de la suscripción
		sql.ExecNonQuery2("UPDATE egresos SET suma_egresos = ? WHERE id_egreso = 1", Array As Object((egresosActuales + suscripcionRegistrar.monto)))

		ToastMessageShow("Suscripción registrada", True)
		'Cierra este activity
		Activity.Finish
		'Abre el activity de Suscripciones
		StartActivity(Suscripciones)
	Else
		'Manda un mensaje aclarativo sobre rellenar los campos de forma correcta
		Msgbox2("Por favor, rellene todos los campos, seleccione un periodo y color", "Registro incorrecto", "Entendido", "", "", Null)
	End If
End Sub