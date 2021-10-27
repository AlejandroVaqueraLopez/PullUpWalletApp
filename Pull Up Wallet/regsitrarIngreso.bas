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
	'Variables publicas
	Dim selecciona As Boolean
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created
	Dim alturaDispositivo As Int
	Dim anchoDispositivo As Int
	Private btnMenu As Button
	Private txtDescripcion As EditText
	Private txtMonto As EditText
	Private txtNombre As EditText
	Private lblFondoMonto As Label
	Private btnNotificacion As Button
	Private btnRecurrente As Button
	Private lblFondoDescripcion As Label
	Private lblFondoNombre As Label
	Private btnUnico As Button
	Private cpBarraColor As ASColorSlider  'Miembro generado de la barra selectora de colores
	Private rd1Ano As RadioButton
	Private rd1Mes As RadioButton
	Private rd1Semana As RadioButton
	Private rd2Semanas As RadioButton
	Private rd3Semanas As RadioButton
	Private btnGuardarIngreso As Button
	Private lblContornoBoton As Label
	Private pnlNavInferior As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("LRegistrarIngreso")
	selecciona = True
	btnRecurrente.TextColor = Colors.White
	btnUnico.TextColor = Colors.Black
	alturaDispositivo = GetDeviceLayoutValues.Height
	anchoDispositivo = GetDeviceLayoutValues.Width
	
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

Private Sub btnRecurrente_Click
	selecciona = Not(selecciona)
	rd1Semana.Enabled = True
	rd2Semanas.Enabled = True
	rd3Semanas.Enabled = True
	rd1Mes.Enabled = True
	rd1Ano.Enabled = True
	If (selecciona = True) Then
		btnRecurrente.TextColor = Colors.White
		btnUnico.TextColor = Colors.Black
		'EL BOTON RECURRENTE ESTA ENCENDIDO REALIZAR ACCION
	Else
		rd1Semana.Enabled = False
		rd2Semanas.Enabled = False
		rd3Semanas.Enabled = False
		rd1Mes.Enabled = False
		rd1Ano.Enabled = False
		btnRecurrente.TextColor = Colors.Black
		btnUnico.TextColor = Colors.White
		'EL BOTON UNICO ESTA ENCENDIDO REALIZAR ACCION
	End If
End Sub

Private Sub btnUnico_Click
	selecciona = Not(selecciona)
	If (selecciona = True) Then
		rd1Semana.Enabled = True
		rd2Semanas.Enabled = True
		rd3Semanas.Enabled = True
		rd1Mes.Enabled = True
		rd1Ano.Enabled = True
		btnRecurrente.TextColor = Colors.White
		btnUnico.TextColor = Colors.Black
		'EL BOTON RECURRENTE ESTA ENCENDIDO REALIZAR ACCION
	Else
		rd1Semana.Enabled = False
		rd2Semanas.Enabled = False
		rd3Semanas.Enabled = False
		rd1Mes.Enabled = False
		rd1Ano.Enabled = False
		btnRecurrente.TextColor = Colors.Black
		btnUnico.TextColor = Colors.White
		'EL BOTON UNICO ESTA ENCENDIDO REALIZAR ACCION
	End If
End Sub

'MODULO DE ELECCION DE COLOR
Private Sub cpBarraColor_ColorChanged(color As Int)
	lblFondoMonto.Color = color  'Devuelve la variable numerica "color" y se puede asignar a cualquier propiedad
End Sub

Private Sub rd3Semanas_CheckedChange(Checked As Boolean)
End Sub

Private Sub rd2Semanas_CheckedChange(Checked As Boolean)
End Sub

Private Sub rd1Semana_CheckedChange(Checked As Boolean)
End Sub

Private Sub rd1Mes_CheckedChange(Checked As Boolean)
End Sub

Private Sub rd1Ano_CheckedChange(Checked As Boolean)
End Sub

Private Sub btnGuardarIngreso_Click
	
End Sub