B4A=true
Group=Default Group\Primer uso
ModulesStructureVersion=1
Type=Activity
Version=10.6
@EndOfDesignText@
'Este slider fue obtenido de aqui: https://www.b4x.com/android/forum/threads/betterslidingpanels-nice-sliding-panels-with-page-indicator.12105/#content
#Region  Activity Attributes
	#FullScreen: False
	#IncludeTitle: False
#End Region
Sub Process_Globals
	Dim tmrAnimacion As Timer
	Dim pausarPanel As Int
	Dim contador1 As Int
End Sub

Sub Globals
	Dim sdSosten As SlidingData 'Este objeto sostiene los datos de la clase "SlidingPanels"
	Dim paneles(7) As Panel 'Se crean n cantidad de paneles deslizables
	Dim diapositiva As String
	Dim esquinas As ColorDrawable 'Variable que ayuda a inicializar el redondeo de esquinas de los editText
	Dim btnIzquierda As Button
'	Dim btnDerecha As Button
	Dim btnTerminarTutorial As Button
	Dim pnIndicador As Panel
	Dim menu As String
	Dim activarBitmap As Bitmap
	Dim inactivarBitmap As Bitmap
End Sub

	
Sub Activity_Create(FirstTime As Boolean)
	contador1 = 0
	'Se crean los paneles
	'Es posible crear los paneles de manera manual en la GUI, pero eso representaria mayor procesamiento de la app.
	esquinas.Initialize(Colors.RGB(197,197,197), 20) 'Se inicializa un estilo para aplicar a los botones que cambian de diapositiva
	For contador1 = 0 To paneles.Length - 1 Step 1 'Se contará la cantidad de objetos paneles que hayamos creado
		diapositiva = contador1 + 1 'Se guarda el numero de contador +1
		paneles(contador1).Initialize("paneles")
		paneles(contador1).SetBackgroundImage(LoadBitmap(File.DirAssets, "slide" & diapositiva & ".png"))'Se carga en cada panel una diapositiva png con cada iteración
		Activity.AddView(paneles(contador1), 100%x, 0, 100%x, 100%y - 80dip) 'Se agrega cada panel al layuout y se ajusta
		Activity.AddMenuItem("Panel #" & contador1, "Menu") 'Se indica que numero de panel esta presente
	Next

	'Se agregan los botones "izquiera" y "derecha"
	btnIzquierda.Initialize("Left")
	btnIzquierda.Text = ">"
	btnIzquierda.Background = esquinas
	btnIzquierda.Color = Colors.RGB(28,230,210)
	Activity.AddView(btnIzquierda, 60%x, 101%y - 75dip, 100dip, 50dip)
		
	'btnDerecha.Initialize("Right")
	'btnDerecha.Text = "<"
	'btnDerecha.Background = esquinas
	'btnDerecha.Color = Colors.RGB(28,230,210)
	'Activity.AddView(btnDerecha, 10%x, 101%y - 75dip, 100dip, 50dip)
		
	btnTerminarTutorial.Initialize("TerminarTutorial")
	btnTerminarTutorial.Text = "Terminar"
	btnTerminarTutorial.Background = esquinas
	btnTerminarTutorial.Color = Colors.RGB(28,230,210)
	Activity.AddView(btnTerminarTutorial, 10%x, 101%y - 75dip, 100dip, 50dip)
		
	'Se cargan los Bitmaps a los indicadores, serviran para las bolitas superiores que indican la diapositiva seleccionada
	activarBitmap.Initialize(File.DirAssets, "indicator_active.png")
	inactivarBitmap.Initialize(File.DirAssets, "indicator_inactive.png")
		
	'//////////////////////////////////////////////////////////////////////////////////////////
	'Inicialización del objeto SlidingData y creación de array de paneles.
	'Luego llamamos a las Diapositivas.Initialize para preparar la animación de los objetos.
	'La ultima llamada a ChangePanel trae el primer panel de vuelta y así sucesivamente.
	sdSosten.Initialize
	Diapositivas.Initialize(sdSosten, paneles, True, 150)
	sdSosten.currentPanel = pausarPanel - 1
		
	pnIndicador = Diapositivas.CreatePageIndicator(paneles.Length, inactivarBitmap, 120dip, 16dip)
	Activity.AddView(pnIndicador , (100%x - 120dip) / 2, 0, 120dip, 16dip)
	pnIndicador.BringToFront
	ChangePanel(0)
End Sub

Sub Menu_Click
	menu = Sender
	btnIzquierda.Enabled = False
	'btnDerecha.Enabled = False
	ChangePanel(menu.SubString("Panel #".Length))
End Sub

	'Cambio de panel izquierdo
Sub Left_Click
	ChangePanel(Diapositivas.PANEL_LEFT)
End Sub

Sub TerminarTutorial_Click
	StartActivity("Main")
	Log("Ir a menu")
End Sub

	'Cambio de panel derecho
Sub Right_Click		
	ChangePanel(Diapositivas.PANEL_RIGHT)
End Sub

	'/////// Estas dos subrutinas se requieren para encabezar el sliding////////
Sub ChangePanel(page As Int)
	'Desactivación de los botones durante la animación ocurre
	btnIzquierda.Enabled = False
	'btnDerecha.Enabled = False
			
	'Llamado a SlidingPanels.ChangePanel para cambiar de panel.
	sdSosten.targetPanel = page
	Diapositivas.ChangePanel(sdSosten)
End Sub

Sub Animation1_AnimationEnd
	'Este evento ocurre cuando la animacion termina. Se debe llamar a SlidingPanels.AnimationEnd desde esta subrutina.
	Diapositivas.AnimationEnd(sdSosten)

	'Habilitar de nuevo los botones (Hasta que no haya más paneles).
	If sdSosten.rotate Then
		btnIzquierda.Enabled = True
		'btnDerecha.Enabled = True
	Else
		If sdSosten.currentPanel = sdSosten.panels.Length - 1 Then btnIzquierda.Enabled = False Else btnIzquierda.Enabled = True
		'If sdSosten.currentPanel = 0 Then btnDerecha.Enabled = False Else btnDerecha.Enabled = True
	End If

	'Colocación del indicador a la página correcta.
	Diapositivas.SetPageIndicator(pnIndicador, sdSosten.currentPanel, activarBitmap, inactivarBitmap)
End Sub

Sub Activity_Resume

End Sub

'En caso de que la aplicacion sea pausada, se pausan las animaciones y se sostienen los paneles presentes
Sub Activity_Pause (UserClosed As Boolean)
	If UserClosed = False Then
		pausarPanel = sdSosten.currentPanel
	Else
		pausarPanel = 0
	End If
End Sub