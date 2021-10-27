package pullup.wallet;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class diapositivas {
private static diapositivas mostCurrent = new diapositivas();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 
public static class _slidingdata{
public boolean IsInitialized;
public int currentPanel;
public int targetPanel;
public boolean rotate;
public int duration;
public anywheresoftware.b4a.objects.PanelWrapper[] Panels;
public anywheresoftware.b4a.objects.AnimationWrapper[] slideAnimations;
public void Initialize() {
IsInitialized = true;
currentPanel = 0;
targetPanel = 0;
rotate = false;
duration = 0;
Panels = new anywheresoftware.b4a.objects.PanelWrapper[0];
{
int d0 = Panels.length;
for (int i0 = 0;i0 < d0;i0++) {
Panels[i0] = new anywheresoftware.b4a.objects.PanelWrapper();
}
}
;
slideAnimations = new anywheresoftware.b4a.objects.AnimationWrapper[0];
{
int d0 = slideAnimations.length;
for (int i0 = 0;i0 < d0;i0++) {
slideAnimations[i0] = new anywheresoftware.b4a.objects.AnimationWrapper();
}
}
;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public anywheresoftware.b4a.keywords.Common __c = null;
public static int _panel_left = 0;
public static int _panel_right = 0;
public static int _leftpanel = 0;
public pullup.wallet.main _main = null;
public pullup.wallet.starter _starter = null;
public pullup.wallet.tutorial _tutorial = null;
public pullup.wallet.editargasto _editargasto = null;
public pullup.wallet.editaringresorecurrente _editaringresorecurrente = null;
public pullup.wallet.editaringresounico _editaringresounico = null;
public pullup.wallet.editarmetaahorro _editarmetaahorro = null;
public pullup.wallet.editarsuscripcion _editarsuscripcion = null;
public pullup.wallet.gastos _gastos = null;
public pullup.wallet.historiales _historiales = null;
public pullup.wallet.ingresosrecurrentes _ingresosrecurrentes = null;
public pullup.wallet.ingresosunicos _ingresosunicos = null;
public pullup.wallet.metasdeahorro _metasdeahorro = null;
public pullup.wallet.registrargasto _registrargasto = null;
public pullup.wallet.registraringreso _registraringreso = null;
public pullup.wallet.registrarmetaahorro _registrarmetaahorro = null;
public pullup.wallet.registrarsuscripcion _registrarsuscripcion = null;
public pullup.wallet.suscripciones _suscripciones = null;
public static String  _initialize(anywheresoftware.b4a.BA _ba,pullup.wallet.diapositivas._slidingdata _sd,anywheresoftware.b4a.objects.PanelWrapper[] _panels,boolean _rotate,int _slidingduration) throws Exception{
RDebugUtils.currentModule="diapositivas";
if (Debug.shouldDelegate(null, "initialize", false))
	 {return ((String) Debug.delegate(null, "initialize", new Object[] {_ba,_sd,_panels,_rotate,_slidingduration}));}
anywheresoftware.b4a.objects.AnimationWrapper[] _a = null;
int _i = 0;
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub Initialize(sd As SlidingData, panels() As Pane";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="sd.duration = SlidingDuration";
_sd.duration /*int*/  = _slidingduration;
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="sd.rotate = Rotate";
_sd.rotate /*boolean*/  = _rotate;
RDebugUtils.currentLine=2883587;
 //BA.debugLineNum = 2883587;BA.debugLine="sd.targetPanel = -1";
_sd.targetPanel /*int*/  = (int) (-1);
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="sd.currentPanel = -1";
_sd.currentPanel /*int*/  = (int) (-1);
RDebugUtils.currentLine=2883589;
 //BA.debugLineNum = 2883589;BA.debugLine="sd.Panels = panels";
_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/  = _panels;
RDebugUtils.currentLine=2883590;
 //BA.debugLineNum = 2883590;BA.debugLine="Tutorial.tmrAnimacion.Initialize(\"tmrAnimation\",";
mostCurrent._tutorial._tmranimacion /*anywheresoftware.b4a.objects.Timer*/ .Initialize((_ba.processBA == null ? _ba : _ba.processBA),"tmrAnimation",(long) (2));
RDebugUtils.currentLine=2883591;
 //BA.debugLineNum = 2883591;BA.debugLine="Dim a(2) As Animation";
_a = new anywheresoftware.b4a.objects.AnimationWrapper[(int) (2)];
{
int d0 = _a.length;
for (int i0 = 0;i0 < d0;i0++) {
_a[i0] = new anywheresoftware.b4a.objects.AnimationWrapper();
}
}
;
RDebugUtils.currentLine=2883592;
 //BA.debugLineNum = 2883592;BA.debugLine="sd.slideAnimations = a";
_sd.slideAnimations /*anywheresoftware.b4a.objects.AnimationWrapper[]*/  = _a;
RDebugUtils.currentLine=2883593;
 //BA.debugLineNum = 2883593;BA.debugLine="Dim a(2) As Animation";
_a = new anywheresoftware.b4a.objects.AnimationWrapper[(int) (2)];
{
int d0 = _a.length;
for (int i0 = 0;i0 < d0;i0++) {
_a[i0] = new anywheresoftware.b4a.objects.AnimationWrapper();
}
}
;
RDebugUtils.currentLine=2883594;
 //BA.debugLineNum = 2883594;BA.debugLine="sd.slideAnimations = a";
_sd.slideAnimations /*anywheresoftware.b4a.objects.AnimationWrapper[]*/  = _a;
RDebugUtils.currentLine=2883596;
 //BA.debugLineNum = 2883596;BA.debugLine="For i = 0 To sd.Panels.Length - 1";
{
final int step11 = 1;
final int limit11 = (int) (_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ .length-1);
_i = (int) (0) ;
for (;_i <= limit11 ;_i = _i + step11 ) {
RDebugUtils.currentLine=2883597;
 //BA.debugLineNum = 2883597;BA.debugLine="sd.Panels(i).Left = 100%x 'Move the panels right";
_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ [_i].setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba));
 }
};
RDebugUtils.currentLine=2883599;
 //BA.debugLineNum = 2883599;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.PanelWrapper  _createpageindicator(anywheresoftware.b4a.BA _ba,int _numberofpages,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _inactivebitmap,int _width,int _height) throws Exception{
RDebugUtils.currentModule="diapositivas";
if (Debug.shouldDelegate(null, "createpageindicator", false))
	 {return ((anywheresoftware.b4a.objects.PanelWrapper) Debug.delegate(null, "createpageindicator", new Object[] {_ba,_numberofpages,_inactivebitmap,_width,_height}));}
int _imagesize = 0;
int _maxwidth = 0;
int _gap = 0;
int _top = 0;
anywheresoftware.b4a.objects.PanelWrapper _basepanel = null;
int _i = 0;
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Sub CreatePageIndicator(numberOfPages As Int, inac";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="Dim imageSize, maxWidth, Gap, Top As Int";
_imagesize = 0;
_maxwidth = 0;
_gap = 0;
_top = 0;
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="maxWidth = Width / numberOfPages";
_maxwidth = (int) (_width/(double)_numberofpages);
RDebugUtils.currentLine=3080196;
 //BA.debugLineNum = 3080196;BA.debugLine="If maxWidth < Height Then";
if (_maxwidth<_height) { 
RDebugUtils.currentLine=3080197;
 //BA.debugLineNum = 3080197;BA.debugLine="imageSize = maxWidth";
_imagesize = _maxwidth;
RDebugUtils.currentLine=3080198;
 //BA.debugLineNum = 3080198;BA.debugLine="Top = (Height - maxWidth) / 2";
_top = (int) ((_height-_maxwidth)/(double)2);
RDebugUtils.currentLine=3080199;
 //BA.debugLineNum = 3080199;BA.debugLine="Gap = 0";
_gap = (int) (0);
 }else {
RDebugUtils.currentLine=3080201;
 //BA.debugLineNum = 3080201;BA.debugLine="imageSize = Height";
_imagesize = _height;
RDebugUtils.currentLine=3080202;
 //BA.debugLineNum = 3080202;BA.debugLine="Top = 0";
_top = (int) (0);
RDebugUtils.currentLine=3080203;
 //BA.debugLineNum = 3080203;BA.debugLine="Gap = (Width - numberOfPages * imageSize) / (num";
_gap = (int) ((_width-_numberofpages*_imagesize)/(double)(_numberofpages-1));
 };
RDebugUtils.currentLine=3080206;
 //BA.debugLineNum = 3080206;BA.debugLine="Dim basePanel As Panel";
_basepanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3080208;
 //BA.debugLineNum = 3080208;BA.debugLine="basePanel.Initialize(\"\")";
_basepanel.Initialize(_ba,"");
RDebugUtils.currentLine=3080209;
 //BA.debugLineNum = 3080209;BA.debugLine="For i = 0 To numberOfPages - 1";
{
final int step14 = 1;
final int limit14 = (int) (_numberofpages-1);
_i = (int) (0) ;
for (;_i <= limit14 ;_i = _i + step14 ) {
RDebugUtils.currentLine=3080210;
 //BA.debugLineNum = 3080210;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=3080212;
 //BA.debugLineNum = 3080212;BA.debugLine="iv.Initialize(\"\")";
_iv.Initialize(_ba,"");
RDebugUtils.currentLine=3080213;
 //BA.debugLineNum = 3080213;BA.debugLine="iv.Gravity=Gravity.FILL";
_iv.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=3080214;
 //BA.debugLineNum = 3080214;BA.debugLine="iv.Bitmap = inactiveBitmap";
_iv.setBitmap((android.graphics.Bitmap)(_inactivebitmap.getObject()));
RDebugUtils.currentLine=3080215;
 //BA.debugLineNum = 3080215;BA.debugLine="basePanel.AddView(iv, i * (imageSize + Gap), Top";
_basepanel.AddView((android.view.View)(_iv.getObject()),(int) (_i*(_imagesize+_gap)),_top,_imagesize,_imagesize);
 }
};
RDebugUtils.currentLine=3080218;
 //BA.debugLineNum = 3080218;BA.debugLine="Return basePanel";
if (true) return _basepanel;
RDebugUtils.currentLine=3080219;
 //BA.debugLineNum = 3080219;BA.debugLine="End Sub";
return null;
}
public static String  _animationend(anywheresoftware.b4a.BA _ba,pullup.wallet.diapositivas._slidingdata _sd) throws Exception{
RDebugUtils.currentModule="diapositivas";
if (Debug.shouldDelegate(null, "animationend", false))
	 {return ((String) Debug.delegate(null, "animationend", new Object[] {_ba,_sd}));}
int _i = 0;
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Sub AnimationEnd (sd As SlidingData)";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="sd.panels(sd.currentPanel).Left = 0 'Set the posi";
_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ [_sd.currentPanel /*int*/ ].setLeft((int) (0));
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="For i = 0 To sd.panels.Length - 1";
{
final int step2 = 1;
final int limit2 = (int) (_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ .length-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=3014659;
 //BA.debugLineNum = 3014659;BA.debugLine="If i <> sd.currentPanel Then";
if (_i!=_sd.currentPanel /*int*/ ) { 
RDebugUtils.currentLine=3014660;
 //BA.debugLineNum = 3014660;BA.debugLine="sd.Panels(i).Left = 100%x 'Move all other panel";
_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ [_i].setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba));
 };
 }
};
RDebugUtils.currentLine=3014663;
 //BA.debugLineNum = 3014663;BA.debugLine="End Sub";
return "";
}
public static String  _setpageindicator(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.PanelWrapper _pagepanel,int _page,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _activebitmap,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _inactivebitmap) throws Exception{
RDebugUtils.currentModule="diapositivas";
if (Debug.shouldDelegate(null, "setpageindicator", false))
	 {return ((String) Debug.delegate(null, "setpageindicator", new Object[] {_ba,_pagepanel,_page,_activebitmap,_inactivebitmap}));}
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
int _i = 0;
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Sub SetPageIndicator(pagePanel As Panel, page As I";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="Dim v As View";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=3145732;
 //BA.debugLineNum = 3145732;BA.debugLine="For i = 0 To pagePanel.NumberOfViews - 1";
{
final int step3 = 1;
final int limit3 = (int) (_pagepanel.getNumberOfViews()-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=3145733;
 //BA.debugLineNum = 3145733;BA.debugLine="v = pagePanel.GetView(i)";
_v = _pagepanel.GetView(_i);
RDebugUtils.currentLine=3145734;
 //BA.debugLineNum = 3145734;BA.debugLine="If v Is ImageView Then";
if (_v.getObjectOrNull() instanceof android.widget.ImageView) { 
RDebugUtils.currentLine=3145735;
 //BA.debugLineNum = 3145735;BA.debugLine="iv = v";
_iv = (anywheresoftware.b4a.objects.ImageViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ImageViewWrapper(), (android.widget.ImageView)(_v.getObject()));
RDebugUtils.currentLine=3145736;
 //BA.debugLineNum = 3145736;BA.debugLine="If i = page Then";
if (_i==_page) { 
RDebugUtils.currentLine=3145737;
 //BA.debugLineNum = 3145737;BA.debugLine="iv.Bitmap = activeBitmap";
_iv.setBitmap((android.graphics.Bitmap)(_activebitmap.getObject()));
 }else {
RDebugUtils.currentLine=3145739;
 //BA.debugLineNum = 3145739;BA.debugLine="iv.Bitmap = inactiveBitmap";
_iv.setBitmap((android.graphics.Bitmap)(_inactivebitmap.getObject()));
 };
 };
 }
};
RDebugUtils.currentLine=3145743;
 //BA.debugLineNum = 3145743;BA.debugLine="End Sub";
return "";
}
public static String  _changepanel(anywheresoftware.b4a.BA _ba,pullup.wallet.diapositivas._slidingdata _sd) throws Exception{
RDebugUtils.currentModule="diapositivas";
if (Debug.shouldDelegate(null, "changepanel", false))
	 {return ((String) Debug.delegate(null, "changepanel", new Object[] {_ba,_sd}));}
int _relativeduration = 0;
int _secondaryindex = 0;
boolean _slideleft = false;
int _tox = 0;
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Sub ChangePanel(sd As SlidingData)";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="Dim relativeDuration As Int";
_relativeduration = 0;
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="Dim secondaryIndex As Int";
_secondaryindex = 0;
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="Dim slideleft As Boolean : slideleft = False";
_slideleft = false;
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="Dim slideleft As Boolean : slideleft = False";
_slideleft = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=2949126;
 //BA.debugLineNum = 2949126;BA.debugLine="If sd.targetPanel = PANEL_LEFT Then";
if (_sd.targetPanel /*int*/ ==_panel_left) { 
RDebugUtils.currentLine=2949127;
 //BA.debugLineNum = 2949127;BA.debugLine="sd.targetPanel = sd.currentPanel  + 1";
_sd.targetPanel /*int*/  = (int) (_sd.currentPanel /*int*/ +1);
 };
RDebugUtils.currentLine=2949131;
 //BA.debugLineNum = 2949131;BA.debugLine="If sd.targetPanel = PANEL_RIGHT Then";
if (_sd.targetPanel /*int*/ ==_panel_right) { 
RDebugUtils.currentLine=2949132;
 //BA.debugLineNum = 2949132;BA.debugLine="sd.targetPanel = sd.currentPanel - 1";
_sd.targetPanel /*int*/  = (int) (_sd.currentPanel /*int*/ -1);
 };
RDebugUtils.currentLine=2949136;
 //BA.debugLineNum = 2949136;BA.debugLine="If sd.currentPanel < sd.targetPanel Then slidelef";
if (_sd.currentPanel /*int*/ <_sd.targetPanel /*int*/ ) { 
_slideleft = anywheresoftware.b4a.keywords.Common.True;};
RDebugUtils.currentLine=2949139;
 //BA.debugLineNum = 2949139;BA.debugLine="If sd.targetPanel > sd.Panels.Length - 1 Then";
if (_sd.targetPanel /*int*/ >_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ .length-1) { 
RDebugUtils.currentLine=2949140;
 //BA.debugLineNum = 2949140;BA.debugLine="If sd.rotate Then";
if (_sd.rotate /*boolean*/ ) { 
RDebugUtils.currentLine=2949141;
 //BA.debugLineNum = 2949141;BA.debugLine="sd.targetPanel = 0";
_sd.targetPanel /*int*/  = (int) (0);
 }else {
RDebugUtils.currentLine=2949143;
 //BA.debugLineNum = 2949143;BA.debugLine="sd.targetPanel = sd.currentPanel";
_sd.targetPanel /*int*/  = _sd.currentPanel /*int*/ ;
 };
 };
RDebugUtils.currentLine=2949147;
 //BA.debugLineNum = 2949147;BA.debugLine="If sd.targetPanel < 0 Then";
if (_sd.targetPanel /*int*/ <0) { 
RDebugUtils.currentLine=2949148;
 //BA.debugLineNum = 2949148;BA.debugLine="If sd.rotate Then";
if (_sd.rotate /*boolean*/ ) { 
RDebugUtils.currentLine=2949149;
 //BA.debugLineNum = 2949149;BA.debugLine="sd.targetPanel = sd.Panels.Length - 1";
_sd.targetPanel /*int*/  = (int) (_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ .length-1);
 }else {
RDebugUtils.currentLine=2949151;
 //BA.debugLineNum = 2949151;BA.debugLine="sd.targetPanel = sd.currentPanel";
_sd.targetPanel /*int*/  = _sd.currentPanel /*int*/ ;
 };
 };
RDebugUtils.currentLine=2949155;
 //BA.debugLineNum = 2949155;BA.debugLine="If sd.currentPanel = sd.targetPanel And sd.curren";
if (_sd.currentPanel /*int*/ ==_sd.targetPanel /*int*/  && _sd.currentPanel /*int*/ !=-1) { 
RDebugUtils.currentLine=2949156;
 //BA.debugLineNum = 2949156;BA.debugLine="relativeDuration = sd.duration / 100%x * Abs(sd.";
_relativeduration = (int) (_sd.duration /*int*/ /(double)anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)*anywheresoftware.b4a.keywords.Common.Abs(_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ [_sd.currentPanel /*int*/ ].getLeft()));
RDebugUtils.currentLine=2949159;
 //BA.debugLineNum = 2949159;BA.debugLine="If sd.Panels(sd.currentPanel).Left >= 0 Then";
if (_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ [_sd.currentPanel /*int*/ ].getLeft()>=0) { 
RDebugUtils.currentLine=2949160;
 //BA.debugLineNum = 2949160;BA.debugLine="secondaryIndex = sd.currentPanel - 1";
_secondaryindex = (int) (_sd.currentPanel /*int*/ -1);
RDebugUtils.currentLine=2949161;
 //BA.debugLineNum = 2949161;BA.debugLine="If secondaryIndex < 0 And sd.rotate Then second";
if (_secondaryindex<0 && _sd.rotate /*boolean*/ ) { 
_secondaryindex = (int) (_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ .length-1);};
 }else {
RDebugUtils.currentLine=2949163;
 //BA.debugLineNum = 2949163;BA.debugLine="secondaryIndex = sd.currentPanel + 1";
_secondaryindex = (int) (_sd.currentPanel /*int*/ +1);
RDebugUtils.currentLine=2949164;
 //BA.debugLineNum = 2949164;BA.debugLine="If secondaryIndex > sd.Panels.Length - 1 Then";
if (_secondaryindex>_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ .length-1) { 
RDebugUtils.currentLine=2949165;
 //BA.debugLineNum = 2949165;BA.debugLine="If sd.rotate Then secondaryIndex = 0 Else seco";
if (_sd.rotate /*boolean*/ ) { 
_secondaryindex = (int) (0);}
else {
_secondaryindex = (int) (-1);};
 };
 };
RDebugUtils.currentLine=2949169;
 //BA.debugLineNum = 2949169;BA.debugLine="Dim toX As Int";
_tox = 0;
RDebugUtils.currentLine=2949171;
 //BA.debugLineNum = 2949171;BA.debugLine="toX = -sd.Panels(sd.currentPanel).Left";
_tox = (int) (-_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ [_sd.currentPanel /*int*/ ].getLeft());
RDebugUtils.currentLine=2949174;
 //BA.debugLineNum = 2949174;BA.debugLine="sd.slideAnimations(1).InitializeTranslate(\"anima";
_sd.slideAnimations /*anywheresoftware.b4a.objects.AnimationWrapper[]*/ [(int) (1)].InitializeTranslate(_ba,"animation1",(float) (0),(float) (0),(float) (_tox),(float) (0));
RDebugUtils.currentLine=2949175;
 //BA.debugLineNum = 2949175;BA.debugLine="sd.slideAnimations(1).Duration = relativeDuratio";
_sd.slideAnimations /*anywheresoftware.b4a.objects.AnimationWrapper[]*/ [(int) (1)].setDuration((long) (_relativeduration));
RDebugUtils.currentLine=2949176;
 //BA.debugLineNum = 2949176;BA.debugLine="sd.slideAnimations(1).Start(sd.panels(sd.current";
_sd.slideAnimations /*anywheresoftware.b4a.objects.AnimationWrapper[]*/ [(int) (1)].Start((android.view.View)(_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ [_sd.currentPanel /*int*/ ].getObject()));
RDebugUtils.currentLine=2949179;
 //BA.debugLineNum = 2949179;BA.debugLine="If secondaryIndex <> -1 Then";
if (_secondaryindex!=-1) { 
RDebugUtils.currentLine=2949180;
 //BA.debugLineNum = 2949180;BA.debugLine="sd.slideAnimations(0).InitializeTranslate( \"ani";
_sd.slideAnimations /*anywheresoftware.b4a.objects.AnimationWrapper[]*/ [(int) (0)].InitializeTranslate(_ba,"animation0",(float) (0),(float) (0),(float) (_tox),(float) (0));
RDebugUtils.currentLine=2949181;
 //BA.debugLineNum = 2949181;BA.debugLine="sd.slideAnimations(0).Duration = relativeDurati";
_sd.slideAnimations /*anywheresoftware.b4a.objects.AnimationWrapper[]*/ [(int) (0)].setDuration((long) (_relativeduration));
RDebugUtils.currentLine=2949182;
 //BA.debugLineNum = 2949182;BA.debugLine="sd.slideAnimations(0).Start(sd.panels(secondary";
_sd.slideAnimations /*anywheresoftware.b4a.objects.AnimationWrapper[]*/ [(int) (0)].Start((android.view.View)(_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ [_secondaryindex].getObject()));
 };
 }else {
RDebugUtils.currentLine=2949185;
 //BA.debugLineNum = 2949185;BA.debugLine="If slideleft Or sd.currentPanel = -1 Then";
if (_slideleft || _sd.currentPanel /*int*/ ==-1) { 
RDebugUtils.currentLine=2949186;
 //BA.debugLineNum = 2949186;BA.debugLine="relativeDuration = sd.duration / 100%x * Abs(sd";
_relativeduration = (int) (_sd.duration /*int*/ /(double)anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)*anywheresoftware.b4a.keywords.Common.Abs(_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ [_sd.targetPanel /*int*/ ].getLeft()));
RDebugUtils.currentLine=2949187;
 //BA.debugLineNum = 2949187;BA.debugLine="If sd.currentPanel <> -1 Then";
if (_sd.currentPanel /*int*/ !=-1) { 
RDebugUtils.currentLine=2949188;
 //BA.debugLineNum = 2949188;BA.debugLine="sd.Panels(sd.targetPanel).Left = sd.Panels(sd.";
_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ [_sd.targetPanel /*int*/ ].setLeft((int) (_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ [_sd.currentPanel /*int*/ ].getLeft()+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)));
RDebugUtils.currentLine=2949189;
 //BA.debugLineNum = 2949189;BA.debugLine="sd.slideAnimations(0).InitializeTranslate(\"ani";
_sd.slideAnimations /*anywheresoftware.b4a.objects.AnimationWrapper[]*/ [(int) (0)].InitializeTranslate(_ba,"animation0",(float) (0),(float) (0),(float) (-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)-_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ [_sd.currentPanel /*int*/ ].getLeft()),(float) (0));
RDebugUtils.currentLine=2949190;
 //BA.debugLineNum = 2949190;BA.debugLine="sd.slideAnimations(0).Duration = relativeDurat";
_sd.slideAnimations /*anywheresoftware.b4a.objects.AnimationWrapper[]*/ [(int) (0)].setDuration((long) (_relativeduration));
RDebugUtils.currentLine=2949191;
 //BA.debugLineNum = 2949191;BA.debugLine="sd.slideAnimations(0).Start(sd.panels(sd.curre";
_sd.slideAnimations /*anywheresoftware.b4a.objects.AnimationWrapper[]*/ [(int) (0)].Start((android.view.View)(_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ [_sd.currentPanel /*int*/ ].getObject()));
 };
RDebugUtils.currentLine=2949193;
 //BA.debugLineNum = 2949193;BA.debugLine="sd.slideAnimations(1).InitializeTranslate( \"ani";
_sd.slideAnimations /*anywheresoftware.b4a.objects.AnimationWrapper[]*/ [(int) (1)].InitializeTranslate(_ba,"animation1",(float) (0),(float) (0),(float) (-_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ [_sd.targetPanel /*int*/ ].getLeft()),(float) (0));
RDebugUtils.currentLine=2949194;
 //BA.debugLineNum = 2949194;BA.debugLine="sd.slideAnimations(1).Duration = relativeDurati";
_sd.slideAnimations /*anywheresoftware.b4a.objects.AnimationWrapper[]*/ [(int) (1)].setDuration((long) (_relativeduration));
RDebugUtils.currentLine=2949195;
 //BA.debugLineNum = 2949195;BA.debugLine="sd.slideAnimations(1).Start(sd.panels(sd.target";
_sd.slideAnimations /*anywheresoftware.b4a.objects.AnimationWrapper[]*/ [(int) (1)].Start((android.view.View)(_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ [_sd.targetPanel /*int*/ ].getObject()));
RDebugUtils.currentLine=2949196;
 //BA.debugLineNum = 2949196;BA.debugLine="sd.currentPanel = sd.targetPanel";
_sd.currentPanel /*int*/  = _sd.targetPanel /*int*/ ;
 }else {
RDebugUtils.currentLine=2949198;
 //BA.debugLineNum = 2949198;BA.debugLine="sd.Panels(sd.targetPanel).Left = sd.Panels(sd.c";
_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ [_sd.targetPanel /*int*/ ].setLeft((int) (_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ [_sd.currentPanel /*int*/ ].getLeft()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)));
RDebugUtils.currentLine=2949199;
 //BA.debugLineNum = 2949199;BA.debugLine="relativeDuration = sd.duration / 100%x * Abs(10";
_relativeduration = (int) (_sd.duration /*int*/ /(double)anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)*anywheresoftware.b4a.keywords.Common.Abs(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)-_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ [_sd.currentPanel /*int*/ ].getLeft()));
RDebugUtils.currentLine=2949200;
 //BA.debugLineNum = 2949200;BA.debugLine="leftPanel = (sd.currentPanel + sd.Panels.Length";
_leftpanel = (int) ((_sd.currentPanel /*int*/ +_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ .length-1)%_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ .length);
RDebugUtils.currentLine=2949201;
 //BA.debugLineNum = 2949201;BA.debugLine="sd.slideAnimations(0).InitializeTranslate(\"anim";
_sd.slideAnimations /*anywheresoftware.b4a.objects.AnimationWrapper[]*/ [(int) (0)].InitializeTranslate(_ba,"animation0",(float) (0),(float) (0),(float) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)-_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ [_sd.currentPanel /*int*/ ].getLeft()),(float) (0));
RDebugUtils.currentLine=2949202;
 //BA.debugLineNum = 2949202;BA.debugLine="sd.slideAnimations(1).InitializeTranslate(\"anim";
_sd.slideAnimations /*anywheresoftware.b4a.objects.AnimationWrapper[]*/ [(int) (1)].InitializeTranslate(_ba,"animation1",(float) (0),(float) (0),(float) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)-_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ [_sd.currentPanel /*int*/ ].getLeft()),(float) (0));
RDebugUtils.currentLine=2949203;
 //BA.debugLineNum = 2949203;BA.debugLine="sd.slideAnimations(0).Duration = relativeDurati";
_sd.slideAnimations /*anywheresoftware.b4a.objects.AnimationWrapper[]*/ [(int) (0)].setDuration((long) (_relativeduration));
RDebugUtils.currentLine=2949204;
 //BA.debugLineNum = 2949204;BA.debugLine="sd.slideAnimations(1).Duration = relativeDurati";
_sd.slideAnimations /*anywheresoftware.b4a.objects.AnimationWrapper[]*/ [(int) (1)].setDuration((long) (_relativeduration));
RDebugUtils.currentLine=2949205;
 //BA.debugLineNum = 2949205;BA.debugLine="sd.slideAnimations(0).Start(sd.panels(sd.curren";
_sd.slideAnimations /*anywheresoftware.b4a.objects.AnimationWrapper[]*/ [(int) (0)].Start((android.view.View)(_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ [_sd.currentPanel /*int*/ ].getObject()));
RDebugUtils.currentLine=2949206;
 //BA.debugLineNum = 2949206;BA.debugLine="sd.slideAnimations(1).Start(sd.panels(sd.target";
_sd.slideAnimations /*anywheresoftware.b4a.objects.AnimationWrapper[]*/ [(int) (1)].Start((android.view.View)(_sd.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ [_sd.targetPanel /*int*/ ].getObject()));
RDebugUtils.currentLine=2949207;
 //BA.debugLineNum = 2949207;BA.debugLine="sd.currentPanel = sd.targetPanel";
_sd.currentPanel /*int*/  = _sd.targetPanel /*int*/ ;
 };
 };
RDebugUtils.currentLine=2949210;
 //BA.debugLineNum = 2949210;BA.debugLine="End Sub";
return "";
}
}