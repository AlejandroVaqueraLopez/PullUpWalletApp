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
	Dim colorCaja As Int
	Dim diasPeriodo As Int
	Dim aparicionMsgBox1 As Boolean
	Dim aparicionMsgBox2 As Boolean
	Dim aparicionMsgBox3 As Boolean
	Dim aparicionMsgBox4 As Boolean
	Dim cur As Cursor
	Dim idRegistro As Int
	Dim stu As StringUtils
	
	'Views
	'Botones
	Private btnMenu As Button
	Private btnOperacionMetaAhorro As Button
	'Cajas de texto
	Private txtDescripcion As EditText
	Private txtNombre As EditText
	Private txtMetaAhorro As EditText
	Private txtMontoAhorro As EditText
	'Etiquetas
	Private lblFondoDescripcion As Label
	Private lblFondoNombre As Label
	Private lblFondoMetaAhorro As Label
	Private lblFondoMontoAhorro As Label
	Private lblContornoBoton As Label
	Private lblNombreVista As Label
	Private lblMetaAhorroTitulo As Label
	Private lblMontoAhorroTitulo As Label
	'Botones de radio
	Private pnlNavInferior As Panel
	Private pnlPeriodos As Panel
	Private pnlSelector As Panel
	'Páneles
	Private rd1Ano As RadioButton
	Private rd1Mes As RadioButton
	Private rd1Semana As RadioButton
	Private rd2Semanas As RadioButton
	Private rd3Semanas As RadioButton
	'Otros views
	Private cpBarraColor As ASColorSlider  'Miembro generado de la barra selectora de colores
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("LFormMetaAhorro")
	alturaDispositivo = Main.alturaDispositivo
	anchoDispositivo = Main.anchoDispositivo
	sql = Starter.sql
	aparicionMsgBox1 = False
	aparicionMsgBox2 = False
	aparicionMsgBox3 = False
	aparicionMsgBox4 = False
	
	'Etiqueta declarativa del view
	lblNombreVista.TextSize = 20
	lblNombreVista.TextColor = Colors.Black
	lblNombreVista.Height = 30dip
	lblNombreVista.Width = anchoDispositivo * 0.9
	lblNombreVista.Top = 30dip
	lblNombreVista.Left = (anchoDispositivo - lblNombreVista.Width) / 2
	'Caja de texto del monto meta
	txtMetaAhorro.Width = anchoDispositivo * 0.9
	txtMetaAhorro.Height = alturaDispositivo * 0.14
	txtMetaAhorro.Top = lblNombreVista.Top * 1.5 + lblNombreVista.Height
	txtMetaAhorro.Left = (anchoDispositivo - txtMetaAhorro.Width) / 2
	lblFondoMetaAhorro.Width = txtMetaAhorro.Width
	lblFondoMetaAhorro.Height = txtMetaAhorro.Height
	lblFondoMetaAhorro.Top = txtMetaAhorro.Top
	lblFondoMetaAhorro.Left = txtMetaAhorro.Left
	'Nombre del campo de la meta de ahorro
	lblMetaAhorroTitulo.Width = lblFondoMetaAhorro.Width * 0.9
	lblMetaAhorroTitulo.Height = stu.MeasureMultilineTextHeight(lblMetaAhorroTitulo, lblMetaAhorroTitulo.Text) + 2
	lblMetaAhorroTitulo.Top = lblFondoMetaAhorro.Top + lblFondoMetaAhorro.Height * 0.05
	lblMetaAhorroTitulo.Left = lblFondoMetaAhorro.Left + lblFondoMontoAhorro.Height * 0.1
	lblMetaAhorroTitulo.Gravity = Gravity.CENTER_VERTICAL
	'Caja de texto del nombre
	txtNombre.Width = anchoDispositivo * 0.9
	txtNombre.Height = alturaDispositivo * 0.06
	txtNombre.Top = txtMetaAhorro.Top + txtMetaAhorro.Height + lblNombreVista.Top / 2
	txtNombre.Left = (anchoDispositivo - txtNombre.Width) / 2
	lblFondoNombre.Width = txtMetaAhorro.Width
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
	'Caja de texto del monto del ahorro
	txtMontoAhorro.Width = txtMetaAhorro.Width
	txtMontoAhorro.Height = txtMetaAhorro.Height
	txtMontoAhorro.Top = txtDescripcion.Top + txtDescripcion.Height + lblNombreVista.Top / 2
	txtMontoAhorro.Left = txtNombre.Left
	lblFondoMontoAhorro.Width = txtMontoAhorro.Width
	lblFondoMontoAhorro.Height = txtMontoAhorro.Height
	lblFondoMontoAhorro.Top = txtMontoAhorro.Top
	lblFondoMontoAhorro.Left = txtMontoAhorro.Left
	'Nombre del campo del monto del ahorro periódico del ahorro
	lblMontoAhorroTitulo.Width = lblFondoMontoAhorro.Width * 0.9
	lblMontoAhorroTitulo.Height = stu.MeasureMultilineTextHeight(lblMontoAhorroTitulo, lblMontoAhorroTitulo.Text) + 2
	lblMontoAhorroTitulo.Top = lblFondoMontoAhorro.Top + lblFondoMontoAhorro.Height * 0.05
	lblMontoAhorroTitulo.Left = lblFondoMontoAhorro.Left + lblFondoMontoAhorro.Height * 0.1
	lblMontoAhorroTitulo.Gravity = Gravity.CENTER_VERTICAL
	'Panel para selector de color
	pnlSelector.Top = txtMontoAhorro.Top + txtMontoAhorro.Height + lblNombreVista.Top / 2
	pnlSelector.Left = txtMontoAhorro.Left + txtMontoAhorro.Width - pnlSelector.Width
	'Panel contenedor de radiobuttons
	pnlPeriodos.Top = pnlSelector.Top
	pnlPeriodos.Left = txtMontoAhorro.Left
	pnlPeriodos.Width = (txtMontoAhorro.Width - pnlSelector.Width) * 0.9
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
	btnOperacionMetaAhorro.Text = "Editar meta de ahorro"
	btnOperacionMetaAhorro.Top = pnlPeriodos.Top + pnlPeriodos.Height + (lblContornoBoton.Top - (pnlPeriodos.Top + pnlPeriodos.Height + btnOperacionMetaAhorro.Height)) / 2
	btnOperacionMetaAhorro.Left = (anchoDispositivo - btnOperacionMetaAhorro.Width) / 2
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
	If(txtMetaAhorro.Text.Length <> 0 And txtNombre.Text.Length <> 0 And txtMontoAhorro.Text.Length <> 0 And txtDescripcion.Text.Length <> 0 And colorCaja <> 0 And diasPeriodo <> 0) Then
		Return True
	Else
		Return False
	End If
End Sub

'Captura el color elegido con el selector de colores y lo asigna a las etiquetas de fondo de los montos y guarda el valor
'del color en una variable
Private Sub cpBarraColor_ColorChanged(color As Int)
	lblFondoMontoAhorro.Color = color
	lblFondoMetaAhorro.Color = color
	colorCaja = color
End Sub

'Verifica que los respectivos campos no sobrepasen el límite de caractéres, en dado caso, despliega una alerta para cada campo
'la primera vez que alcanzan el límite, luego, limita el texto ingresado
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

'Los siguientes eventos sirven para verificar la longitud de la entrada, y en el peor de los casos, limitar la longitud de la entrada
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

'Asigna los campos a las propiedades de un objeto de tipo RegistroMetaAhorro y lo retorna
Sub asignacionCampos As RegistroMetaAhorro
	Dim metaAhorro As RegistroMetaAhorro
	'Guarda el monto meta
	metaAhorro.montoMeta = txtMetaAhorro.Text
	'Guarda el monto ahorro (periódico)
	metaAhorro.montoAhorro = txtMontoAhorro.Text
	'Guarda el nombre
	metaAhorro.nombre = txtNombre.Text
	'Guarda la descripción
	metaAhorro.descripcion = (txtDescripcion.Text)
	'Guarda el periodo
	metaAhorro.periodo = diasPeriodo
	'Guarda el progreso inicial
	metaAhorro.progreso = 0
	'Guarda el color elegido
	metaAhorro.color = colorCaja
	
	Return metaAhorro
End Sub

'Valida el rellenado de los campos, obtiene el objeto de tipo RegistroMetaAhorro de asignacionCampos y realiza la actualización 
'del registro en la tabla metas_ahorro
Private Sub btnOperacionMetaAhorro_Click
	Dim validaciones As Boolean
	'Valida que los campos se hayan llenado satisfactoriamente
	validaciones = validarCampos
	If(validaciones = True) Then
		'Si los campos están llenos, se obtiene el objeto ya validado con los campos del formulario
		Dim metaAhorroRegistrar As RegistroMetaAhorro
		metaAhorroRegistrar = asignacionCampos

		'Sentencia para realizar una actualización en la tabla metas_ahorro
		Starter.sql.ExecNonQuery2("UPDATE metas_ahorro SET monto_meta = ?, nombre = ?, descripcion = ?, monto_ahorro = ?, periodo_ahorro = ?, color = ?  WHERE id_meta_ahorro = '" & idRegistro & "'", Array As Object(metaAhorroRegistrar.montoMeta, metaAhorroRegistrar.nombre, metaAhorroRegistrar.descripcion, metaAhorroRegistrar.montoAhorro, metaAhorroRegistrar.periodo, metaAhorroRegistrar.color))
		
		ToastMessageShow("Meta de ahorro editada", True)
		'Cierra este activity
		Activity.Finish
		'Abre el activity de MetasDeAhorro
		StartActivity(MetasDeAhorro)
	Else
		'Manda un mensaje aclarativo sobre rellenar los campos de forma correcta
		Msgbox2("Por favor, rellene todos los campos, seleccione un periodo y color", "Registro incorrecto", "Entendido", "", "", Null)
	End If
End Sub

'Realiza la consulta de los datos del registro a editar y los guarda en las propiedades de un objeto de tipo RegistroMetaAhorro
Sub consultaAEditar(rowid As Int)
	Dim metaAhorro As RegistroMetaAhorro
	idRegistro = rowid

	cur = sql.ExecQuery("SELECT * FROM metas_ahorro WHERE id_meta_ahorro = '" & idRegistro & "'")
	If(cur.RowCount > 0) Then
		cur.Position = 0
		metaAhorro.nombre = cur.GetString("nombre")
		metaAhorro.montoMeta = cur.GetInt("monto_meta")
		metaAhorro.montoAhorro = cur.GetInt("monto_ahorro")
		metaAhorro.descripcion = cur.GetString("descripcion")
		metaAhorro.periodo = cur.GetInt("periodo_ahorro")
		metaAhorro.color = cur.GetString("color")
		
		reasignarCamposAEditar(metaAhorro)
	End If
End Sub

'Asigna los campos del registro a editar, en los views
Sub reasignarCamposAEditar(registro As RegistroMetaAhorro)
	txtNombre.Text = registro.nombre
	txtMetaAhorro.Text = registro.montoMeta
	txtMontoAhorro.Text = registro.montoAhorro
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