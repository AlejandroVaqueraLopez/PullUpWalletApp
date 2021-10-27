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
	'Variables publicas
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created
	Dim alturaDispositivo As Int
	Dim anchoDispositivo As Int
	Private btnMenu As Button
	Private txtDescripcion As EditText
	Private txtNombre As EditText
	Private lblFondoDescripcion As Label
	Private lblFondoNombre As Label
	Private cpBarraColor As ASColorSlider  'Miembro generado de la barra selectora de colores
	Private rd1Ano As RadioButton
	Private rd1Mes As RadioButton
	Private rd1Semana As RadioButton
	Private rd2Semanas As RadioButton
	Private rd3Semanas As RadioButton
	Private btnGuardarNotificacion As Button
	Private lblPanelColor As Label
	Private lblContornoBoton As Label
	Private pnlNavInferior As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("LRegistrarNotificacion")
	alturaDispositivo = Main.alturaDispositivo
	anchoDispositivo = Main.anchoDispositivo
	
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

'MODULO DE ELECCION DE COLOR
Private Sub cpBarraColor_ColorChanged(color As Int)
	lblPanelColor.Color = color  'Devuelve la variable numerica "color" y se puede asignar a cualquier propiedad
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

Private Sub btnGuardarNotificacion_Click
	
End Sub