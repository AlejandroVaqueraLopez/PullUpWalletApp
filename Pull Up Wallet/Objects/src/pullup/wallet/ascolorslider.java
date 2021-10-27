package pullup.wallet;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class ascolorslider extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "pullup.wallet.ascolorslider");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", pullup.wallet.ascolorslider.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mbase = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xiv_hue = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xpnl_background = null;
public b4a.example.bitmapcreator _bc = null;
public int _g_borderwidth = 0;
public int _g_bordercolor = 0;
public pullup.wallet.main _main = null;
public pullup.wallet.starter _starter = null;
public pullup.wallet.tutorial _tutorial = null;
public pullup.wallet.diapositivas _diapositivas = null;
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
public String  _base_resize(pullup.wallet.ascolorslider __ref,double _width,double _height) throws Exception{
__ref = this;
RDebugUtils.currentModule="ascolorslider";
if (Debug.shouldDelegate(ba, "base_resize", true))
	 {return ((String) Debug.delegate(ba, "base_resize", new Object[] {_width,_height}));}
RDebugUtils.currentLine=18874368;
 //BA.debugLineNum = 18874368;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
RDebugUtils.currentLine=18874369;
 //BA.debugLineNum = 18874369;BA.debugLine="xiv_hue.SetLayoutAnimated(0,0,0,Width,Height)";
__ref._xiv_hue /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetLayoutAnimated((int) (0),(int) (0),(int) (0),(int) (_width),(int) (_height));
RDebugUtils.currentLine=18874370;
 //BA.debugLineNum = 18874370;BA.debugLine="xpnl_background.SetLayoutAnimated(0,0,0,Width,Hei";
__ref._xpnl_background /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetLayoutAnimated((int) (0),(int) (0),(int) (0),(int) (_width),(int) (_height));
RDebugUtils.currentLine=18874371;
 //BA.debugLineNum = 18874371;BA.debugLine="xpnl_background.Color = xui.Color_Transparent";
__ref._xpnl_background /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setColor(__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .Color_Transparent);
RDebugUtils.currentLine=18874373;
 //BA.debugLineNum = 18874373;BA.debugLine="xiv_hue.SetColorAndBorder(xui.Color_Transparent,0";
__ref._xiv_hue /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetColorAndBorder(__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .Color_Transparent,(int) (0),(int) (0),(int) (_height/(double)2));
RDebugUtils.currentLine=18874375;
 //BA.debugLineNum = 18874375;BA.debugLine="DrawHueBar";
__ref._drawhuebar /*String*/ (null);
RDebugUtils.currentLine=18874376;
 //BA.debugLineNum = 18874376;BA.debugLine="End Sub";
return "";
}
public String  _drawhuebar(pullup.wallet.ascolorslider __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="ascolorslider";
if (Debug.shouldDelegate(ba, "drawhuebar", true))
	 {return ((String) Debug.delegate(ba, "drawhuebar", null));}
int _y = 0;
int _x = 0;
RDebugUtils.currentLine=19136512;
 //BA.debugLineNum = 19136512;BA.debugLine="Private Sub DrawHueBar";
RDebugUtils.currentLine=19136513;
 //BA.debugLineNum = 19136513;BA.debugLine="For y = 0 To bc.mHeight - 1";
{
final int step1 = 1;
final int limit1 = (int) (__ref._bc /*b4a.example.bitmapcreator*/ ._mheight-1);
_y = (int) (0) ;
for (;_y <= limit1 ;_y = _y + step1 ) {
RDebugUtils.currentLine=19136514;
 //BA.debugLineNum = 19136514;BA.debugLine="For x = 0 To bc.mWidth - 1";
{
final int step2 = 1;
final int limit2 = (int) (__ref._bc /*b4a.example.bitmapcreator*/ ._mwidth-1);
_x = (int) (0) ;
for (;_x <= limit2 ;_x = _x + step2 ) {
RDebugUtils.currentLine=19136515;
 //BA.debugLineNum = 19136515;BA.debugLine="bc.SetHSV(x, y, 255, 360 / bc.mHeight * y, 1, 1";
__ref._bc /*b4a.example.bitmapcreator*/ ._sethsv(_x,_y,(int) (255),(int) (360/(double)__ref._bc /*b4a.example.bitmapcreator*/ ._mheight*_y),(float) (1),(float) (1));
 }
};
 }
};
RDebugUtils.currentLine=19136518;
 //BA.debugLineNum = 19136518;BA.debugLine="xiv_hue.SetBitmap(CreateRoundRectBitmap(bc.Bitmap";
__ref._xiv_hue /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetBitmap((android.graphics.Bitmap)(__ref._createroundrectbitmap /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/ (null,__ref._bc /*b4a.example.bitmapcreator*/ ._getbitmap(),(float) (__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth()/(double)2)).getObject()));
RDebugUtils.currentLine=19136519;
 //BA.debugLineNum = 19136519;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(pullup.wallet.ascolorslider __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="ascolorslider";
RDebugUtils.currentLine=18612224;
 //BA.debugLineNum = 18612224;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=18612225;
 //BA.debugLineNum = 18612225;BA.debugLine="Private mEventName As String 'ignore";
_meventname = "";
RDebugUtils.currentLine=18612226;
 //BA.debugLineNum = 18612226;BA.debugLine="Private mCallBack As Object 'ignore";
_mcallback = new Object();
RDebugUtils.currentLine=18612227;
 //BA.debugLineNum = 18612227;BA.debugLine="Private mBase As B4XView 'ignore";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
RDebugUtils.currentLine=18612228;
 //BA.debugLineNum = 18612228;BA.debugLine="Private xui As XUI 'ignore";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
RDebugUtils.currentLine=18612229;
 //BA.debugLineNum = 18612229;BA.debugLine="Private xiv_hue As B4XView";
_xiv_hue = new anywheresoftware.b4a.objects.B4XViewWrapper();
RDebugUtils.currentLine=18612230;
 //BA.debugLineNum = 18612230;BA.debugLine="Private xpnl_background As B4XView";
_xpnl_background = new anywheresoftware.b4a.objects.B4XViewWrapper();
RDebugUtils.currentLine=18612231;
 //BA.debugLineNum = 18612231;BA.debugLine="Dim bc As BitmapCreator";
_bc = new b4a.example.bitmapcreator();
RDebugUtils.currentLine=18612233;
 //BA.debugLineNum = 18612233;BA.debugLine="Private g_BorderWidth As Int";
_g_borderwidth = 0;
RDebugUtils.currentLine=18612234;
 //BA.debugLineNum = 18612234;BA.debugLine="Private g_BorderColor As Int";
_g_bordercolor = 0;
RDebugUtils.currentLine=18612236;
 //BA.debugLineNum = 18612236;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _createimageview(pullup.wallet.ascolorslider __ref,String _eventname) throws Exception{
__ref = this;
RDebugUtils.currentModule="ascolorslider";
if (Debug.shouldDelegate(ba, "createimageview", true))
	 {return ((anywheresoftware.b4a.objects.B4XViewWrapper) Debug.delegate(ba, "createimageview", new Object[] {_eventname}));}
anywheresoftware.b4a.objects.ImageViewWrapper _tmp_iv = null;
RDebugUtils.currentLine=19202048;
 //BA.debugLineNum = 19202048;BA.debugLine="Private Sub CreateImageview(EventName As String) A";
RDebugUtils.currentLine=19202049;
 //BA.debugLineNum = 19202049;BA.debugLine="Dim tmp_iv As ImageView";
_tmp_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=19202050;
 //BA.debugLineNum = 19202050;BA.debugLine="tmp_iv.Initialize(EventName)";
_tmp_iv.Initialize(ba,_eventname);
RDebugUtils.currentLine=19202051;
 //BA.debugLineNum = 19202051;BA.debugLine="Return tmp_iv";
if (true) return (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_tmp_iv.getObject()));
RDebugUtils.currentLine=19202052;
 //BA.debugLineNum = 19202052;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper  _createroundrectbitmap(pullup.wallet.ascolorslider __ref,anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _input,float _radius) throws Exception{
__ref = this;
RDebugUtils.currentModule="ascolorslider";
if (Debug.shouldDelegate(ba, "createroundrectbitmap", true))
	 {return ((anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper) Debug.delegate(ba, "createroundrectbitmap", new Object[] {_input,_radius}));}
anywheresoftware.b4a.objects.B4XCanvas _c = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xview = null;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _path = null;
anywheresoftware.b4a.objects.B4XCanvas.B4XRect _r = null;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _res = null;
RDebugUtils.currentLine=19267584;
 //BA.debugLineNum = 19267584;BA.debugLine="Private Sub CreateRoundRectBitmap (Input As B4XBit";
RDebugUtils.currentLine=19267585;
 //BA.debugLineNum = 19267585;BA.debugLine="Dim c As B4XCanvas";
_c = new anywheresoftware.b4a.objects.B4XCanvas();
RDebugUtils.currentLine=19267586;
 //BA.debugLineNum = 19267586;BA.debugLine="Dim xview As B4XView = xui.CreatePanel(\"\")";
_xview = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xview = __ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .CreatePanel(ba,"");
RDebugUtils.currentLine=19267587;
 //BA.debugLineNum = 19267587;BA.debugLine="xview.SetLayoutAnimated(0, 0, 0, mBase.Width, mBa";
_xview.SetLayoutAnimated((int) (0),(int) (0),(int) (0),__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth(),__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight());
RDebugUtils.currentLine=19267588;
 //BA.debugLineNum = 19267588;BA.debugLine="c.Initialize(xview)";
_c.Initialize(_xview);
RDebugUtils.currentLine=19267589;
 //BA.debugLineNum = 19267589;BA.debugLine="Dim path As B4XPath";
_path = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
RDebugUtils.currentLine=19267590;
 //BA.debugLineNum = 19267590;BA.debugLine="path.InitializeRoundedRect(c.TargetRect, Radius)";
_path.InitializeRoundedRect(_c.getTargetRect(),_radius);
RDebugUtils.currentLine=19267591;
 //BA.debugLineNum = 19267591;BA.debugLine="c.ClipPath(path)";
_c.ClipPath(_path);
RDebugUtils.currentLine=19267592;
 //BA.debugLineNum = 19267592;BA.debugLine="c.DrawRect(c.TargetRect, g_BorderColor, True, g_B";
_c.DrawRect(_c.getTargetRect(),__ref._g_bordercolor /*int*/ ,__c.True,(float) (__ref._g_borderwidth /*int*/ ));
RDebugUtils.currentLine=19267593;
 //BA.debugLineNum = 19267593;BA.debugLine="c.RemoveClip";
_c.RemoveClip();
RDebugUtils.currentLine=19267594;
 //BA.debugLineNum = 19267594;BA.debugLine="Dim r As B4XRect";
_r = new anywheresoftware.b4a.objects.B4XCanvas.B4XRect();
RDebugUtils.currentLine=19267595;
 //BA.debugLineNum = 19267595;BA.debugLine="r.Initialize(g_BorderWidth, g_BorderWidth, c.Targ";
_r.Initialize((float) (__ref._g_borderwidth /*int*/ ),(float) (__ref._g_borderwidth /*int*/ ),(float) (_c.getTargetRect().getWidth()-__ref._g_borderwidth /*int*/ ),(float) (_c.getTargetRect().getHeight()-__ref._g_borderwidth /*int*/ ));
RDebugUtils.currentLine=19267596;
 //BA.debugLineNum = 19267596;BA.debugLine="path.InitializeRoundedRect(r, Radius - 0.7 * g_Bo";
_path.InitializeRoundedRect(_r,(float) (_radius-0.7*__ref._g_borderwidth /*int*/ ));
RDebugUtils.currentLine=19267597;
 //BA.debugLineNum = 19267597;BA.debugLine="c.ClipPath(path)";
_c.ClipPath(_path);
RDebugUtils.currentLine=19267598;
 //BA.debugLineNum = 19267598;BA.debugLine="c.DrawBitmap(Input, r)";
_c.DrawBitmap((android.graphics.Bitmap)(_input.getObject()),_r);
RDebugUtils.currentLine=19267599;
 //BA.debugLineNum = 19267599;BA.debugLine="c.RemoveClip";
_c.RemoveClip();
RDebugUtils.currentLine=19267600;
 //BA.debugLineNum = 19267600;BA.debugLine="c.Invalidate";
_c.Invalidate();
RDebugUtils.currentLine=19267601;
 //BA.debugLineNum = 19267601;BA.debugLine="Dim res As B4XBitmap = c.CreateBitmap";
_res = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
_res = _c.CreateBitmap();
RDebugUtils.currentLine=19267602;
 //BA.debugLineNum = 19267602;BA.debugLine="c.Release";
_c.Release();
RDebugUtils.currentLine=19267603;
 //BA.debugLineNum = 19267603;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=19267604;
 //BA.debugLineNum = 19267604;BA.debugLine="End Sub";
return null;
}
public String  _designercreateview(pullup.wallet.ascolorslider __ref,Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
__ref = this;
RDebugUtils.currentModule="ascolorslider";
if (Debug.shouldDelegate(ba, "designercreateview", true))
	 {return ((String) Debug.delegate(ba, "designercreateview", new Object[] {_base,_lbl,_props}));}
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
RDebugUtils.currentLine=18743296;
 //BA.debugLineNum = 18743296;BA.debugLine="Public Sub DesignerCreateView (Base As Object, Lbl";
RDebugUtils.currentLine=18743297;
 //BA.debugLineNum = 18743297;BA.debugLine="mBase = Base";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
RDebugUtils.currentLine=18743298;
 //BA.debugLineNum = 18743298;BA.debugLine="ini_props(Props)";
__ref._ini_props /*String*/ (null,_props);
RDebugUtils.currentLine=18743299;
 //BA.debugLineNum = 18743299;BA.debugLine="xiv_hue = CreateImageview(\"\")";
__ref._xiv_hue /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = __ref._createimageview /*anywheresoftware.b4a.objects.B4XViewWrapper*/ (null,"");
RDebugUtils.currentLine=18743300;
 //BA.debugLineNum = 18743300;BA.debugLine="xpnl_background = xui.CreatePanel(\"xpnl_backgroun";
__ref._xpnl_background /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = __ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .CreatePanel(ba,"xpnl_background");
RDebugUtils.currentLine=18743301;
 //BA.debugLineNum = 18743301;BA.debugLine="mBase.AddView(xpnl_background,0,0,0,0)";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .AddView((android.view.View)(__ref._xpnl_background /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getObject()),(int) (0),(int) (0),(int) (0),(int) (0));
RDebugUtils.currentLine=18743302;
 //BA.debugLineNum = 18743302;BA.debugLine="mBase.AddView(xiv_hue,0,0,0,0)";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .AddView((android.view.View)(__ref._xiv_hue /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getObject()),(int) (0),(int) (0),(int) (0),(int) (0));
RDebugUtils.currentLine=18743303;
 //BA.debugLineNum = 18743303;BA.debugLine="bc.Initialize(mBase.Width/ xui.Scale,mBase.Height";
__ref._bc /*b4a.example.bitmapcreator*/ ._initialize(ba,(int) (__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth()/(double)__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .getScale()),(int) (__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight()/(double)__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .getScale()));
RDebugUtils.currentLine=18743306;
 //BA.debugLineNum = 18743306;BA.debugLine="Base_Resize(mBase.Width,mBase.Height)";
__ref._base_resize /*String*/ (null,__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth(),__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight());
RDebugUtils.currentLine=18743307;
 //BA.debugLineNum = 18743307;BA.debugLine="Private r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=18743308;
 //BA.debugLineNum = 18743308;BA.debugLine="r.Target = xpnl_background";
_r.Target = (Object)(__ref._xpnl_background /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getObject());
RDebugUtils.currentLine=18743309;
 //BA.debugLineNum = 18743309;BA.debugLine="r.SetOnTouchListener(\"xpnl_background_Touch2\")";
_r.SetOnTouchListener(ba,"xpnl_background_Touch2");
RDebugUtils.currentLine=18743314;
 //BA.debugLineNum = 18743314;BA.debugLine="End Sub";
return "";
}
public String  _ini_props(pullup.wallet.ascolorslider __ref,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
__ref = this;
RDebugUtils.currentModule="ascolorslider";
if (Debug.shouldDelegate(ba, "ini_props", true))
	 {return ((String) Debug.delegate(ba, "ini_props", new Object[] {_props}));}
RDebugUtils.currentLine=18808832;
 //BA.debugLineNum = 18808832;BA.debugLine="Private Sub ini_props(props As Map)";
RDebugUtils.currentLine=18808833;
 //BA.debugLineNum = 18808833;BA.debugLine="g_BorderWidth = props.Get(\"BorderWidth\")";
__ref._g_borderwidth /*int*/  = (int)(BA.ObjectToNumber(_props.Get((Object)("BorderWidth"))));
RDebugUtils.currentLine=18808834;
 //BA.debugLineNum = 18808834;BA.debugLine="g_BorderColor = props.Get(\"BorderColor\")";
__ref._g_bordercolor /*int*/  = (int)(BA.ObjectToNumber(_props.Get((Object)("BorderColor"))));
RDebugUtils.currentLine=18808835;
 //BA.debugLineNum = 18808835;BA.debugLine="End Sub";
return "";
}
public String  _getcolor(pullup.wallet.ascolorslider __ref,float _y) throws Exception{
__ref = this;
RDebugUtils.currentModule="ascolorslider";
if (Debug.shouldDelegate(ba, "getcolor", true))
	 {return ((String) Debug.delegate(ba, "getcolor", new Object[] {_y}));}
int _crl = 0;
anywheresoftware.b4a.objects.ImageViewWrapper _tt = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
RDebugUtils.currentLine=19005440;
 //BA.debugLineNum = 19005440;BA.debugLine="Private Sub GetColor(y As Float)";
RDebugUtils.currentLine=19005442;
 //BA.debugLineNum = 19005442;BA.debugLine="Dim crl As Int = 0";
_crl = (int) (0);
RDebugUtils.currentLine=19005444;
 //BA.debugLineNum = 19005444;BA.debugLine="Dim tt As ImageView = xiv_hue";
_tt = new anywheresoftware.b4a.objects.ImageViewWrapper();
_tt = (anywheresoftware.b4a.objects.ImageViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ImageViewWrapper(), (android.widget.ImageView)(__ref._xiv_hue /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getObject()));
RDebugUtils.currentLine=19005448;
 //BA.debugLineNum = 19005448;BA.debugLine="Dim bmp As Bitmap = tt.Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp = (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(_tt.getBitmap()));
RDebugUtils.currentLine=19005451;
 //BA.debugLineNum = 19005451;BA.debugLine="If y < bmp.Height And y >= 0 Then";
if (_y<_bmp.getHeight() && _y>=0) { 
RDebugUtils.currentLine=19005453;
 //BA.debugLineNum = 19005453;BA.debugLine="crl = bmp.GetPixel(mBase.Width/2,y)";
_crl = _bmp.GetPixel((int) (__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth()/(double)2),(int) (_y));
 }else 
{RDebugUtils.currentLine=19005457;
 //BA.debugLineNum = 19005457;BA.debugLine="Else If y < 0 Then";
if (_y<0) { 
RDebugUtils.currentLine=19005458;
 //BA.debugLineNum = 19005458;BA.debugLine="crl = xui.Color_White";
_crl = __ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .Color_White;
 }else {
RDebugUtils.currentLine=19005460;
 //BA.debugLineNum = 19005460;BA.debugLine="crl = xui.Color_Black";
_crl = __ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .Color_Black;
 }}
;
RDebugUtils.currentLine=19005463;
 //BA.debugLineNum = 19005463;BA.debugLine="CallSub2(mCallBack, mEventName & \"_ColorChanged\",";
__c.CallSubNew2(ba,__ref._mcallback /*Object*/ ,__ref._meventname /*String*/ +"_ColorChanged",(Object)(_crl));
RDebugUtils.currentLine=19005465;
 //BA.debugLineNum = 19005465;BA.debugLine="End Sub";
return "";
}
public String  _initialize(pullup.wallet.ascolorslider __ref,anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="ascolorslider";
if (Debug.shouldDelegate(ba, "initialize", true))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_callback,_eventname}));}
RDebugUtils.currentLine=18677760;
 //BA.debugLineNum = 18677760;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
RDebugUtils.currentLine=18677761;
 //BA.debugLineNum = 18677761;BA.debugLine="mEventName = EventName";
__ref._meventname /*String*/  = _eventname;
RDebugUtils.currentLine=18677762;
 //BA.debugLineNum = 18677762;BA.debugLine="mCallBack = Callback";
__ref._mcallback /*Object*/  = _callback;
RDebugUtils.currentLine=18677763;
 //BA.debugLineNum = 18677763;BA.debugLine="End Sub";
return "";
}
public String  _setcolorpalettebitmap(pullup.wallet.ascolorslider __ref,anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _palette) throws Exception{
__ref = this;
RDebugUtils.currentModule="ascolorslider";
if (Debug.shouldDelegate(ba, "setcolorpalettebitmap", true))
	 {return ((String) Debug.delegate(ba, "setcolorpalettebitmap", new Object[] {_palette}));}
RDebugUtils.currentLine=19070976;
 //BA.debugLineNum = 19070976;BA.debugLine="Public Sub setColorPaletteBitmap(palette As B4XBit";
RDebugUtils.currentLine=19070977;
 //BA.debugLineNum = 19070977;BA.debugLine="xiv_hue.SetBitmap(CreateRoundRectBitmap(palette,m";
__ref._xiv_hue /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetBitmap((android.graphics.Bitmap)(__ref._createroundrectbitmap /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/ (null,_palette,(float) (__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth()/(double)2)).getObject()));
RDebugUtils.currentLine=19070978;
 //BA.debugLineNum = 19070978;BA.debugLine="End Sub";
return "";
}
public boolean  _xpnl_background_touch2(pullup.wallet.ascolorslider __ref,Object _o,int _action,float _x,float _y,Object _motion) throws Exception{
__ref = this;
RDebugUtils.currentModule="ascolorslider";
if (Debug.shouldDelegate(ba, "xpnl_background_touch2", true))
	 {return ((Boolean) Debug.delegate(ba, "xpnl_background_touch2", new Object[] {_o,_action,_x,_y,_motion}));}
RDebugUtils.currentLine=18939904;
 //BA.debugLineNum = 18939904;BA.debugLine="Private Sub xpnl_background_Touch2 (o As Object, A";
RDebugUtils.currentLine=18939913;
 //BA.debugLineNum = 18939913;BA.debugLine="GetColor(y)";
__ref._getcolor /*String*/ (null,_y);
RDebugUtils.currentLine=18939915;
 //BA.debugLineNum = 18939915;BA.debugLine="Return True";
if (true) return __c.True;
RDebugUtils.currentLine=18939916;
 //BA.debugLineNum = 18939916;BA.debugLine="End Sub";
return false;
}
}