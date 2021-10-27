package pullup.wallet;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class ascolorslider_subs_0 {


public static RemoteObject  _base_resize(RemoteObject __ref,RemoteObject _width,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("Base_Resize (ascolorslider) ","ascolorslider",19,__ref.getField(false, "ba"),__ref,62);
if (RapidSub.canDelegate("base_resize")) { return __ref.runUserSub(false, "ascolorslider","base_resize", __ref, _width, _height);}
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 62;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 63;BA.debugLine="xiv_hue.SetLayoutAnimated(0,0,0,Width,Height)";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_xiv_hue" /*RemoteObject*/ ).runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, _width)),(Object)(BA.numberCast(int.class, _height)));
 BA.debugLineNum = 64;BA.debugLine="xpnl_background.SetLayoutAnimated(0,0,0,Width,Hei";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_xpnl_background" /*RemoteObject*/ ).runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, _width)),(Object)(BA.numberCast(int.class, _height)));
 BA.debugLineNum = 65;BA.debugLine="xpnl_background.Color = xui.Color_Transparent";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_xpnl_background" /*RemoteObject*/ ).runMethod(true,"setColor",__ref.getField(false,"_xui" /*RemoteObject*/ ).getField(true,"Color_Transparent"));
 BA.debugLineNum = 67;BA.debugLine="xiv_hue.SetColorAndBorder(xui.Color_Transparent,0";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_xiv_hue" /*RemoteObject*/ ).runVoidMethod ("SetColorAndBorder",(Object)(__ref.getField(false,"_xui" /*RemoteObject*/ ).getField(true,"Color_Transparent")),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_height,RemoteObject.createImmutable(2)}, "/",0, 0))));
 BA.debugLineNum = 69;BA.debugLine="DrawHueBar";
Debug.JustUpdateDeviceLine();
__ref.runClassMethod (pullup.wallet.ascolorslider.class, "_drawhuebar" /*RemoteObject*/ );
 BA.debugLineNum = 70;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private mEventName As String 'ignore";
ascolorslider._meventname = RemoteObject.createImmutable("");__ref.setField("_meventname",ascolorslider._meventname);
 //BA.debugLineNum = 19;BA.debugLine="Private mCallBack As Object 'ignore";
ascolorslider._mcallback = RemoteObject.createNew ("Object");__ref.setField("_mcallback",ascolorslider._mcallback);
 //BA.debugLineNum = 20;BA.debugLine="Private mBase As B4XView 'ignore";
ascolorslider._mbase = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");__ref.setField("_mbase",ascolorslider._mbase);
 //BA.debugLineNum = 21;BA.debugLine="Private xui As XUI 'ignore";
ascolorslider._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");__ref.setField("_xui",ascolorslider._xui);
 //BA.debugLineNum = 22;BA.debugLine="Private xiv_hue As B4XView";
ascolorslider._xiv_hue = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");__ref.setField("_xiv_hue",ascolorslider._xiv_hue);
 //BA.debugLineNum = 23;BA.debugLine="Private xpnl_background As B4XView";
ascolorslider._xpnl_background = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");__ref.setField("_xpnl_background",ascolorslider._xpnl_background);
 //BA.debugLineNum = 24;BA.debugLine="Dim bc As BitmapCreator";
ascolorslider._bc = RemoteObject.createNew ("b4a.example.bitmapcreator");__ref.setField("_bc",ascolorslider._bc);
 //BA.debugLineNum = 26;BA.debugLine="Private g_BorderWidth As Int";
ascolorslider._g_borderwidth = RemoteObject.createImmutable(0);__ref.setField("_g_borderwidth",ascolorslider._g_borderwidth);
 //BA.debugLineNum = 27;BA.debugLine="Private g_BorderColor As Int";
ascolorslider._g_bordercolor = RemoteObject.createImmutable(0);__ref.setField("_g_bordercolor",ascolorslider._g_bordercolor);
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _createimageview(RemoteObject __ref,RemoteObject _eventname) throws Exception{
try {
		Debug.PushSubsStack("CreateImageview (ascolorslider) ","ascolorslider",19,__ref.getField(false, "ba"),__ref,134);
if (RapidSub.canDelegate("createimageview")) { return __ref.runUserSub(false, "ascolorslider","createimageview", __ref, _eventname);}
RemoteObject _tmp_iv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
Debug.locals.put("EventName", _eventname);
 BA.debugLineNum = 134;BA.debugLine="Private Sub CreateImageview(EventName As String) A";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 135;BA.debugLine="Dim tmp_iv As ImageView";
Debug.JustUpdateDeviceLine();
_tmp_iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("tmp_iv", _tmp_iv);
 BA.debugLineNum = 136;BA.debugLine="tmp_iv.Initialize(EventName)";
Debug.JustUpdateDeviceLine();
_tmp_iv.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(_eventname));
 BA.debugLineNum = 137;BA.debugLine="Return tmp_iv";
Debug.JustUpdateDeviceLine();
if (true) return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _tmp_iv.getObject());
 BA.debugLineNum = 138;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createroundrectbitmap(RemoteObject __ref,RemoteObject _input,RemoteObject _radius) throws Exception{
try {
		Debug.PushSubsStack("CreateRoundRectBitmap (ascolorslider) ","ascolorslider",19,__ref.getField(false, "ba"),__ref,140);
if (RapidSub.canDelegate("createroundrectbitmap")) { return __ref.runUserSub(false, "ascolorslider","createroundrectbitmap", __ref, _input, _radius);}
RemoteObject _c = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas");
RemoteObject _xview = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _path = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas.B4XPath");
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas.B4XRect");
RemoteObject _res = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper");
Debug.locals.put("Input", _input);
Debug.locals.put("Radius", _radius);
 BA.debugLineNum = 140;BA.debugLine="Private Sub CreateRoundRectBitmap (Input As B4XBit";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 141;BA.debugLine="Dim c As B4XCanvas";
Debug.JustUpdateDeviceLine();
_c = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XCanvas");Debug.locals.put("c", _c);
 BA.debugLineNum = 142;BA.debugLine="Dim xview As B4XView = xui.CreatePanel(\"\")";
Debug.JustUpdateDeviceLine();
_xview = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_xview = __ref.getField(false,"_xui" /*RemoteObject*/ ).runMethod(false,"CreatePanel",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("xview", _xview);Debug.locals.put("xview", _xview);
 BA.debugLineNum = 143;BA.debugLine="xview.SetLayoutAnimated(0, 0, 0, mBase.Width, mBa";
Debug.JustUpdateDeviceLine();
_xview.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth")),(Object)(__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getHeight")));
 BA.debugLineNum = 144;BA.debugLine="c.Initialize(xview)";
Debug.JustUpdateDeviceLine();
_c.runVoidMethod ("Initialize",(Object)(_xview));
 BA.debugLineNum = 145;BA.debugLine="Dim path As B4XPath";
Debug.JustUpdateDeviceLine();
_path = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XCanvas.B4XPath");Debug.locals.put("path", _path);
 BA.debugLineNum = 146;BA.debugLine="path.InitializeRoundedRect(c.TargetRect, Radius)";
Debug.JustUpdateDeviceLine();
_path.runVoidMethod ("InitializeRoundedRect",(Object)(_c.runMethod(false,"getTargetRect")),(Object)(_radius));
 BA.debugLineNum = 147;BA.debugLine="c.ClipPath(path)";
Debug.JustUpdateDeviceLine();
_c.runVoidMethod ("ClipPath",(Object)(_path));
 BA.debugLineNum = 148;BA.debugLine="c.DrawRect(c.TargetRect, g_BorderColor, True, g_B";
Debug.JustUpdateDeviceLine();
_c.runVoidMethod ("DrawRect",(Object)(_c.runMethod(false,"getTargetRect")),(Object)(__ref.getField(true,"_g_bordercolor" /*RemoteObject*/ )),(Object)(ascolorslider.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, __ref.getField(true,"_g_borderwidth" /*RemoteObject*/ ))));
 BA.debugLineNum = 149;BA.debugLine="c.RemoveClip";
Debug.JustUpdateDeviceLine();
_c.runVoidMethod ("RemoveClip");
 BA.debugLineNum = 150;BA.debugLine="Dim r As B4XRect";
Debug.JustUpdateDeviceLine();
_r = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XCanvas.B4XRect");Debug.locals.put("r", _r);
 BA.debugLineNum = 151;BA.debugLine="r.Initialize(g_BorderWidth, g_BorderWidth, c.Targ";
Debug.JustUpdateDeviceLine();
_r.runVoidMethod ("Initialize",(Object)(BA.numberCast(float.class, __ref.getField(true,"_g_borderwidth" /*RemoteObject*/ ))),(Object)(BA.numberCast(float.class, __ref.getField(true,"_g_borderwidth" /*RemoteObject*/ ))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_c.runMethod(false,"getTargetRect").runMethod(true,"getWidth"),__ref.getField(true,"_g_borderwidth" /*RemoteObject*/ )}, "-",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_c.runMethod(false,"getTargetRect").runMethod(true,"getHeight"),__ref.getField(true,"_g_borderwidth" /*RemoteObject*/ )}, "-",1, 0))));
 BA.debugLineNum = 152;BA.debugLine="path.InitializeRoundedRect(r, Radius - 0.7 * g_Bo";
Debug.JustUpdateDeviceLine();
_path.runVoidMethod ("InitializeRoundedRect",(Object)(_r),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_radius,RemoteObject.createImmutable(0.7),__ref.getField(true,"_g_borderwidth" /*RemoteObject*/ )}, "-*",1, 0))));
 BA.debugLineNum = 153;BA.debugLine="c.ClipPath(path)";
Debug.JustUpdateDeviceLine();
_c.runVoidMethod ("ClipPath",(Object)(_path));
 BA.debugLineNum = 154;BA.debugLine="c.DrawBitmap(Input, r)";
Debug.JustUpdateDeviceLine();
_c.runVoidMethod ("DrawBitmap",(Object)((_input.getObject())),(Object)(_r));
 BA.debugLineNum = 155;BA.debugLine="c.RemoveClip";
Debug.JustUpdateDeviceLine();
_c.runVoidMethod ("RemoveClip");
 BA.debugLineNum = 156;BA.debugLine="c.Invalidate";
Debug.JustUpdateDeviceLine();
_c.runVoidMethod ("Invalidate");
 BA.debugLineNum = 157;BA.debugLine="Dim res As B4XBitmap = c.CreateBitmap";
Debug.JustUpdateDeviceLine();
_res = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper");
_res = _c.runMethod(false,"CreateBitmap");Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 158;BA.debugLine="c.Release";
Debug.JustUpdateDeviceLine();
_c.runVoidMethod ("Release");
 BA.debugLineNum = 159;BA.debugLine="Return res";
Debug.JustUpdateDeviceLine();
if (true) return _res;
 BA.debugLineNum = 160;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _designercreateview(RemoteObject __ref,RemoteObject _base,RemoteObject _lbl,RemoteObject _props) throws Exception{
try {
		Debug.PushSubsStack("DesignerCreateView (ascolorslider) ","ascolorslider",19,__ref.getField(false, "ba"),__ref,37);
if (RapidSub.canDelegate("designercreateview")) { return __ref.runUserSub(false, "ascolorslider","designercreateview", __ref, _base, _lbl, _props);}
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
Debug.locals.put("Base", _base);
Debug.locals.put("Lbl", _lbl);
Debug.locals.put("Props", _props);
 BA.debugLineNum = 37;BA.debugLine="Public Sub DesignerCreateView (Base As Object, Lbl";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 38;BA.debugLine="mBase = Base";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_mbase" /*RemoteObject*/ ).setObject (_base);
 BA.debugLineNum = 39;BA.debugLine="ini_props(Props)";
Debug.JustUpdateDeviceLine();
__ref.runClassMethod (pullup.wallet.ascolorslider.class, "_ini_props" /*RemoteObject*/ ,(Object)(_props));
 BA.debugLineNum = 40;BA.debugLine="xiv_hue = CreateImageview(\"\")";
Debug.JustUpdateDeviceLine();
__ref.setField ("_xiv_hue" /*RemoteObject*/ ,__ref.runClassMethod (pullup.wallet.ascolorslider.class, "_createimageview" /*RemoteObject*/ ,(Object)(RemoteObject.createImmutable(""))));
 BA.debugLineNum = 41;BA.debugLine="xpnl_background = xui.CreatePanel(\"xpnl_backgroun";
Debug.JustUpdateDeviceLine();
__ref.setField ("_xpnl_background" /*RemoteObject*/ ,__ref.getField(false,"_xui" /*RemoteObject*/ ).runMethod(false,"CreatePanel",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("xpnl_background"))));
 BA.debugLineNum = 42;BA.debugLine="mBase.AddView(xpnl_background,0,0,0,0)";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_mbase" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((__ref.getField(false,"_xpnl_background" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 43;BA.debugLine="mBase.AddView(xiv_hue,0,0,0,0)";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_mbase" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((__ref.getField(false,"_xiv_hue" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 44;BA.debugLine="bc.Initialize(mBase.Width/ xui.Scale,mBase.Height";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_bc" /*RemoteObject*/ ).runVoidMethod ("_initialize",__ref.getField(false, "ba"),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth"),__ref.getField(false,"_xui" /*RemoteObject*/ ).runMethod(true,"getScale")}, "/",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getHeight"),__ref.getField(false,"_xui" /*RemoteObject*/ ).runMethod(true,"getScale")}, "/",0, 0))));
 BA.debugLineNum = 47;BA.debugLine="Base_Resize(mBase.Width,mBase.Height)";
Debug.JustUpdateDeviceLine();
__ref.runClassMethod (pullup.wallet.ascolorslider.class, "_base_resize" /*RemoteObject*/ ,(Object)(BA.numberCast(double.class, __ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth"))),(Object)(BA.numberCast(double.class, __ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getHeight"))));
 BA.debugLineNum = 48;BA.debugLine="Private r As Reflector";
Debug.JustUpdateDeviceLine();
_r = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");Debug.locals.put("r", _r);
 BA.debugLineNum = 49;BA.debugLine="r.Target = xpnl_background";
Debug.JustUpdateDeviceLine();
_r.setField ("Target",(__ref.getField(false,"_xpnl_background" /*RemoteObject*/ ).getObject()));
 BA.debugLineNum = 50;BA.debugLine="r.SetOnTouchListener(\"xpnl_background_Touch2\")";
Debug.JustUpdateDeviceLine();
_r.runVoidMethod ("SetOnTouchListener",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("xpnl_background_Touch2")));
 BA.debugLineNum = 55;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _drawhuebar(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("DrawHueBar (ascolorslider) ","ascolorslider",19,__ref.getField(false, "ba"),__ref,125);
if (RapidSub.canDelegate("drawhuebar")) { return __ref.runUserSub(false, "ascolorslider","drawhuebar", __ref);}
int _y = 0;
int _x = 0;
 BA.debugLineNum = 125;BA.debugLine="Private Sub DrawHueBar";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 126;BA.debugLine="For y = 0 To bc.mHeight - 1";
Debug.JustUpdateDeviceLine();
{
final int step1 = 1;
final int limit1 = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_bc" /*RemoteObject*/ ).getField(true,"_mheight"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_y = 0 ;
for (;(step1 > 0 && _y <= limit1) || (step1 < 0 && _y >= limit1) ;_y = ((int)(0 + _y + step1))  ) {
Debug.locals.put("y", _y);
 BA.debugLineNum = 127;BA.debugLine="For x = 0 To bc.mWidth - 1";
Debug.JustUpdateDeviceLine();
{
final int step2 = 1;
final int limit2 = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_bc" /*RemoteObject*/ ).getField(true,"_mwidth"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_x = 0 ;
for (;(step2 > 0 && _x <= limit2) || (step2 < 0 && _x >= limit2) ;_x = ((int)(0 + _x + step2))  ) {
Debug.locals.put("x", _x);
 BA.debugLineNum = 128;BA.debugLine="bc.SetHSV(x, y, 255, 360 / bc.mHeight * y, 1, 1";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_bc" /*RemoteObject*/ ).runVoidMethod ("_sethsv",(Object)(BA.numberCast(int.class, _x)),(Object)(BA.numberCast(int.class, _y)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(360),__ref.getField(false,"_bc" /*RemoteObject*/ ).getField(true,"_mheight"),RemoteObject.createImmutable(_y)}, "/*",0, 0))),(Object)(BA.numberCast(float.class, 1)),(Object)(BA.numberCast(float.class, 1)));
 }
}Debug.locals.put("x", _x);
;
 }
}Debug.locals.put("y", _y);
;
 BA.debugLineNum = 131;BA.debugLine="xiv_hue.SetBitmap(CreateRoundRectBitmap(bc.Bitmap";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_xiv_hue" /*RemoteObject*/ ).runVoidMethod ("SetBitmap",(Object)((__ref.runClassMethod (pullup.wallet.ascolorslider.class, "_createroundrectbitmap" /*RemoteObject*/ ,(Object)(__ref.getField(false,"_bc" /*RemoteObject*/ ).runMethod(false,"_getbitmap")),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0)))).getObject())));
 BA.debugLineNum = 132;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getcolor(RemoteObject __ref,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("GetColor (ascolorslider) ","ascolorslider",19,__ref.getField(false, "ba"),__ref,87);
if (RapidSub.canDelegate("getcolor")) { return __ref.runUserSub(false, "ascolorslider","getcolor", __ref, _y);}
RemoteObject _crl = RemoteObject.createImmutable(0);
RemoteObject _tt = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
Debug.locals.put("y", _y);
 BA.debugLineNum = 87;BA.debugLine="Private Sub GetColor(y As Float)";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 89;BA.debugLine="Dim crl As Int = 0";
Debug.JustUpdateDeviceLine();
_crl = BA.numberCast(int.class, 0);Debug.locals.put("crl", _crl);Debug.locals.put("crl", _crl);
 BA.debugLineNum = 91;BA.debugLine="Dim tt As ImageView = xiv_hue";
Debug.JustUpdateDeviceLine();
_tt = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
_tt = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ImageViewWrapper"), __ref.getField(false,"_xiv_hue" /*RemoteObject*/ ).getObject());Debug.locals.put("tt", _tt);
 BA.debugLineNum = 95;BA.debugLine="Dim bmp As Bitmap = tt.Bitmap";
Debug.JustUpdateDeviceLine();
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_bmp = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), _tt.runMethod(false,"getBitmap"));Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 98;BA.debugLine="If y < bmp.Height And y >= 0 Then";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, _bmp.runMethod(true,"getHeight"))) && RemoteObject.solveBoolean("g",_y,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 100;BA.debugLine="crl = bmp.GetPixel(mBase.Width/2,y)";
Debug.JustUpdateDeviceLine();
_crl = _bmp.runMethod(true,"GetPixel",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0))),(Object)(BA.numberCast(int.class, _y)));Debug.locals.put("crl", _crl);
 }else 
{ BA.debugLineNum = 104;BA.debugLine="Else If y < 0 Then";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean("<",_y,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 105;BA.debugLine="crl = xui.Color_White";
Debug.JustUpdateDeviceLine();
_crl = __ref.getField(false,"_xui" /*RemoteObject*/ ).getField(true,"Color_White");Debug.locals.put("crl", _crl);
 }else {
 BA.debugLineNum = 107;BA.debugLine="crl = xui.Color_Black";
Debug.JustUpdateDeviceLine();
_crl = __ref.getField(false,"_xui" /*RemoteObject*/ ).getField(true,"Color_Black");Debug.locals.put("crl", _crl);
 }}
;
 BA.debugLineNum = 110;BA.debugLine="CallSub2(mCallBack, mEventName & \"_ColorChanged\",";
Debug.JustUpdateDeviceLine();
ascolorslider.__c.runMethodAndSync(false,"CallSubNew2",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_mcallback" /*RemoteObject*/ )),(Object)(RemoteObject.concat(__ref.getField(true,"_meventname" /*RemoteObject*/ ),RemoteObject.createImmutable("_ColorChanged"))),(Object)((_crl)));
 BA.debugLineNum = 112;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ini_props(RemoteObject __ref,RemoteObject _props) throws Exception{
try {
		Debug.PushSubsStack("ini_props (ascolorslider) ","ascolorslider",19,__ref.getField(false, "ba"),__ref,57);
if (RapidSub.canDelegate("ini_props")) { return __ref.runUserSub(false, "ascolorslider","ini_props", __ref, _props);}
Debug.locals.put("props", _props);
 BA.debugLineNum = 57;BA.debugLine="Private Sub ini_props(props As Map)";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 58;BA.debugLine="g_BorderWidth = props.Get(\"BorderWidth\")";
Debug.JustUpdateDeviceLine();
__ref.setField ("_g_borderwidth" /*RemoteObject*/ ,BA.numberCast(int.class, _props.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("BorderWidth"))))));
 BA.debugLineNum = 59;BA.debugLine="g_BorderColor = props.Get(\"BorderColor\")";
Debug.JustUpdateDeviceLine();
__ref.setField ("_g_bordercolor" /*RemoteObject*/ ,BA.numberCast(int.class, _props.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("BorderColor"))))));
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _callback,RemoteObject _eventname) throws Exception{
try {
		Debug.PushSubsStack("Initialize (ascolorslider) ","ascolorslider",19,__ref.getField(false, "ba"),__ref,31);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "ascolorslider","initialize", __ref, _ba, _callback, _eventname);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("Callback", _callback);
Debug.locals.put("EventName", _eventname);
 BA.debugLineNum = 31;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 32;BA.debugLine="mEventName = EventName";
Debug.JustUpdateDeviceLine();
__ref.setField ("_meventname" /*RemoteObject*/ ,_eventname);
 BA.debugLineNum = 33;BA.debugLine="mCallBack = Callback";
Debug.JustUpdateDeviceLine();
__ref.setField ("_mcallback" /*RemoteObject*/ ,_callback);
 BA.debugLineNum = 34;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setcolorpalettebitmap(RemoteObject __ref,RemoteObject _palette) throws Exception{
try {
		Debug.PushSubsStack("setColorPaletteBitmap (ascolorslider) ","ascolorslider",19,__ref.getField(false, "ba"),__ref,117);
if (RapidSub.canDelegate("setcolorpalettebitmap")) { return __ref.runUserSub(false, "ascolorslider","setcolorpalettebitmap", __ref, _palette);}
Debug.locals.put("palette", _palette);
 BA.debugLineNum = 117;BA.debugLine="Public Sub setColorPaletteBitmap(palette As B4XBit";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 118;BA.debugLine="xiv_hue.SetBitmap(CreateRoundRectBitmap(palette,m";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_xiv_hue" /*RemoteObject*/ ).runVoidMethod ("SetBitmap",(Object)((__ref.runClassMethod (pullup.wallet.ascolorslider.class, "_createroundrectbitmap" /*RemoteObject*/ ,(Object)(_palette),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0)))).getObject())));
 BA.debugLineNum = 119;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _xpnl_background_touch2(RemoteObject __ref,RemoteObject _o,RemoteObject _action,RemoteObject _x,RemoteObject _y,RemoteObject _motion) throws Exception{
try {
		Debug.PushSubsStack("xpnl_background_Touch2 (ascolorslider) ","ascolorslider",19,__ref.getField(false, "ba"),__ref,73);
if (RapidSub.canDelegate("xpnl_background_touch2")) { return __ref.runUserSub(false, "ascolorslider","xpnl_background_touch2", __ref, _o, _action, _x, _y, _motion);}
Debug.locals.put("o", _o);
Debug.locals.put("ACTION", _action);
Debug.locals.put("x", _x);
Debug.locals.put("y", _y);
Debug.locals.put("motion", _motion);
 BA.debugLineNum = 73;BA.debugLine="Private Sub xpnl_background_Touch2 (o As Object, A";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 82;BA.debugLine="GetColor(y)";
Debug.JustUpdateDeviceLine();
__ref.runClassMethod (pullup.wallet.ascolorslider.class, "_getcolor" /*RemoteObject*/ ,(Object)(_y));
 BA.debugLineNum = 84;BA.debugLine="Return True";
Debug.JustUpdateDeviceLine();
if (true) return ascolorslider.__c.getField(true,"True");
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}