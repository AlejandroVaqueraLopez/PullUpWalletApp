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
	Dim aparicionMsgBox1 As Boolean
	Dim aparicionMsgBox2 As Boolean
	Dim aparicionMsgBox3 As Boolean
	Dim cur As Cursor
	Dim idRegistro As Int
	Dim sumaIngresosAntigua As Int
	Dim montoAntiguo As Int
	Dim montoNuevo As Int
	Dim sumaIngresosActual As Int
	
	'Views
	'Botones
	Private btnMenu As Button
	Private btnOperacionIngresoUnico As Button
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
	'Páneles
	Private pnlNavInferior As Panel
	Private pnlSelector As Panel
	'Otros views
	Private cpBarraColor As ASColorSlider  'Miembro generado de la barra selectora de colores
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("LEditarIngresoUnico")
	alturaDispositivo = Main.alturaDispositivo
	anchoDispositivo = Main.anchoDispositivo
	sql = Starter.sql
	aparicionMsgBox1 = False
	aparicionMsgBox2 = False
	aparicionMsgBox3 = False
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
	txtMonto.Height = alturaDispositivo * 0.25
	txtMonto.Top = lblNombreVista.Top * 2 + lblNombreVista.Height
	txtMonto.Left = (anchoDispositivo - txtMonto.Width) / 2
	lblFondoMonto.Width = txtMonto.Width
	lblFondoMonto.Height = txtMonto.Height
	lblFondoMonto.Top = txtMonto.Top
	lblFondoMonto.Left = txtMonto.Left
	'Caja de texto del nombre
	txtNombre.Width = anchoDispositivo * 0.9
	txtNombre.Height = alturaDispositivo * 0.1
	txtNombre.Top = txtMonto.Top + txtMonto.Height + lblNombreVista.Top
	txtNombre.Left = (anchoDispositivo - txtNombre.Width) / 2
	lblFondoNombre.Width = txtMonto.Width
	lblFondoNombre.Height = txtNombre.Height
	lblFondoNombre.Top = txtNombre.Top
	lblFondoNombre.Left = txtNombre.Left
	'Selector de color
	pnlSelector.Top = txtNombre.Top + txtNombre.Height + lblNombreVista.Top
	pnlSelector.Left = txtNombre.Left + txtNombre.Width - pnlSelector.Width
	'Caja de texto de descripción
	txtDescripcion.Width = (txtNombre.Width - pnlSelector.Width) * 0.9
	txtDescripcion.Height = pnlSelector.Height
	txtDescripcion.Top = pnlSelector.Top
	txtDescripcion.Left = txtNombre.Left
	lblFondoDescripcion.Width = txtDescripcion.Width
	lblFondoDescripcion.Height = txtDescripcion.Height
	lblFondoDescripcion.Top = txtDescripcion.Top
	lblFondoDescripcion.Left = txtDescripcion.Left

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
	
	'Botón de operación con el ingreso único
	btnOperacionIngresoUnico.Text = "Editar ingreso único"
	btnOperacionIngresoUnico.Top = txtDescripcion.Top + txtDescripcion.Height + (lblContornoBoton.Top - (txtDescripcion.Top + txtDescripcion.Height + btnOperacionIngresoUnico.Height)) / 2
	btnOperacionIngresoUnico.Left = (anchoDispositivo - btnOperacionIngresoUnico.Width) / 2
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
	If(txtMonto.Text.Length <> 0 And txtNombre.Text.Length <> 0 And txtDescripcion.Text.Length <> 0 And colorCaja <> 0) Then
		Return True
	Else
		Return False
	End If
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

'Captura el color elegido con el selector de colores y lo asigna a la etiqueta de fondo del monto y guarda el valor
'del color en una variable
Sub cpBarraColor_ColorChanged(color As Int)
	lblFondoMonto.Color = color
	colorCaja = color
End Sub

'Asigna los campos a las propiedades de un objeto de tipo RegistroIngreso y lo retorna
Sub asignacionCampos As RegistroIngreso
	Dim ingresoUnico As RegistroIngreso
	'Guarda el monto
	ingresoUnico.monto = txtMonto.Text
	'Guarda el nombre
	ingresoUnico.nombre = txtNombre.Text
	'Guarda la descripción
	ingresoUnico.descripcion = (txtDescripcion.Text)
	'Guarda el color elegido
	ingresoUnico.color = colorCaja
	
	Return ingresoUnico
End Sub

'Valida el rellenado de los campos, obtiene el objeto de tipo RegistroIngreso de asignacionCampos y realiza la actualización 
'del registro en la tabla ingresos_unicos
Private Sub btnOperacionIngresoUnico_Click
	Dim validaciones As Boolean
	'Valida que los campos se hayan llenado satisfactoriamente
	validaciones = validarCampos
	If(validaciones = True) Then
		'Si los campos están llenos, se obtiene el objeto ya validado con los campos del formulario
		Dim ingresoUnicoRegistro As RegistroIngreso
		ingresoUnicoRegistro = asignacionCampos
		
		'Consulta al registro que se quiere eliminar y se obtiene el monto
		cur = sql.ExecQuery2("SELECT monto FROM ingresos_unicos WHERE id_ingreso_unico = ?", Array As String(idRegistro & ""))
		cur.Position = 0
		
		montoAntiguo = cur.GetInt("monto")
		montoNuevo = ingresoUnicoRegistro.monto
		
		'Se obtiene la suma antigua del registro unico en la tabla ingresos
		cur = sql.ExecQuery("SELECT * FROM ingresos WHERE id_ingreso = 1")
		cur.Position = 0
		sumaIngresosAntigua = cur.GetInt("suma_ingresos")
		
		'Resta de monto de ingreso único a mi suma de ingresos en la tabla "ingresos"
		sumaIngresosActual = (sumaIngresosAntigua - montoAntiguo) + montoNuevo
		
		'Inserción de la nueva suma en la tabla de ingresos
		sql.ExecNonQuery2("UPDATE ingresos SET suma_ingresos = ? WHERE id_ingreso = 1", Array As Object(sumaIngresosActual))
		
		'Sentencia para realizar una actualización en la tabla ingresos_unicos
		Starter.sql.ExecNonQuery2("UPDATE ingresos_unicos SET monto = ?, nombre = ?, descripcion = ?, color = ?  WHERE id_ingreso_unico = '" & idRegistro & "'", Array As Object(ingresoUnicoRegistro.monto, ingresoUnicoRegistro.nombre, ingresoUnicoRegistro.descripcion, ingresoUnicoRegistro.color))
		
		ToastMessageShow("Ingreso único editado",True)
		'Cierra este activity
		Activity.Finish
		'Abre el activity de IngresosUnicos
		StartActivity(IngresosUnicos)
	Else
		'Manda un mensaje aclarativo sobre rellenar los campos de forma correcta
		Msgbox2("Por favor, rellene todos los campos y seleccione un color", "Registro incorrecto", "Entendido", "", "", Null)
	End If
End Sub

'Realiza la consulta de los datos del registro a editar y los guarda en las propiedades de un objeto de tipo RegistroIngreso
Sub consultaAEditar(rowid As Int)
	Dim ingresoUnico As RegistroIngreso
	idRegistro = rowid

	cur = sql.ExecQuery("SELECT * FROM ingresos_unicos WHERE id_ingreso_unico = '" & idRegistro & "'")
	If(cur.RowCount > 0) Then
		cur.Position = 0
		ingresoUnico.nombre = cur.GetString("nombre")
		ingresoUnico.monto = cur.GetInt("monto")
		ingresoUnico.descripcion = cur.GetString("descripcion")
		ingresoUnico.color = cur.GetString("color")
		
		reasignarCamposAEditar(ingresoUnico)
	End If
End Sub

'Asigna los campos del registro a editar, en los views
Sub reasignarCamposAEditar(registro As RegistroIngreso)
	txtNombre.Text = registro.nombre
	txtMonto.Text = registro.monto
	txtDescripcion.Text = registro.descripcion
	
	cpBarraColor_ColorChanged(registro.color)
End Sub