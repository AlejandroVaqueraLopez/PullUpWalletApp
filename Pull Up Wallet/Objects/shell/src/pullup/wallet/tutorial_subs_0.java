package pullup.wallet;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class tutorial_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (tutorial) ","tutorial",2,tutorial.mostCurrent.activityBA,tutorial.mostCurrent,27);
if (RapidSub.canDelegate("activity_create")) { return pullup.wallet.tutorial.remoteMe.runUserSub(false, "tutorial","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 28;BA.debugLine="contador1 = 0";
Debug.ShouldStop(134217728);
tutorial._contador1 = BA.numberCast(int.class, 0);
 BA.debugLineNum = 31;BA.debugLine="esquinas.Initialize(Colors.RGB(197,197,197), 20)";
Debug.ShouldStop(1073741824);
tutorial.mostCurrent._esquinas.runVoidMethod ("Initialize",(Object)(tutorial.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 197)),(Object)(BA.numberCast(int.class, 197)),(Object)(BA.numberCast(int.class, 197)))),(Object)(BA.numberCast(int.class, 20)));
 BA.debugLineNum = 32;BA.debugLine="For contador1 = 0 To paneles.Length - 1 Step 1 'S";
Debug.ShouldStop(-2147483648);
{
final int step3 = 1;
final int limit3 = RemoteObject.solve(new RemoteObject[] {tutorial.mostCurrent._paneles.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
tutorial._contador1 = BA.numberCast(int.class, 0) ;
for (;(step3 > 0 && tutorial._contador1.<Integer>get().intValue() <= limit3) || (step3 < 0 && tutorial._contador1.<Integer>get().intValue() >= limit3) ;tutorial._contador1 = RemoteObject.createImmutable((int)(0 + tutorial._contador1.<Integer>get().intValue() + step3))  ) {
 BA.debugLineNum = 33;BA.debugLine="diapositiva = contador1 + 1 'Se guarda el numero";
Debug.ShouldStop(1);
tutorial.mostCurrent._diapositiva = BA.NumberToString(RemoteObject.solve(new RemoteObject[] {tutorial._contador1,RemoteObject.createImmutable(1)}, "+",1, 1));
 BA.debugLineNum = 34;BA.debugLine="paneles(contador1).Initialize(\"paneles\")";
Debug.ShouldStop(2);
tutorial.mostCurrent._paneles.getArrayElement(false,tutorial._contador1).runVoidMethod ("Initialize",tutorial.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("paneles")));
 BA.debugLineNum = 35;BA.debugLine="paneles(contador1).SetBackgroundImage(LoadBitmap";
Debug.ShouldStop(4);
tutorial.mostCurrent._paneles.getArrayElement(false,tutorial._contador1).runVoidMethod ("SetBackgroundImageNew",(Object)((tutorial.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(tutorial.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.concat(RemoteObject.createImmutable("slide"),tutorial.mostCurrent._diapositiva,RemoteObject.createImmutable(".png")))).getObject())));
 BA.debugLineNum = 36;BA.debugLine="Activity.AddView(paneles(contador1), 100%x, 0, 1";
Debug.ShouldStop(8);
tutorial.mostCurrent._activity.runVoidMethod ("AddView",(Object)((tutorial.mostCurrent._paneles.getArrayElement(false,tutorial._contador1).getObject())),(Object)(tutorial.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),tutorial.mostCurrent.activityBA)),(Object)(BA.numberCast(int.class, 0)),(Object)(tutorial.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),tutorial.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {tutorial.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),tutorial.mostCurrent.activityBA),tutorial.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 80)))}, "-",1, 1)));
 BA.debugLineNum = 37;BA.debugLine="Activity.AddMenuItem(\"Panel #\" & contador1, \"Men";
Debug.ShouldStop(16);
tutorial.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Panel #"),tutorial._contador1))),(Object)(RemoteObject.createImmutable("Menu")));
 }
};
 BA.debugLineNum = 41;BA.debugLine="btnIzquierda.Initialize(\"Left\")";
Debug.ShouldStop(256);
tutorial.mostCurrent._btnizquierda.runVoidMethod ("Initialize",tutorial.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Left")));
 BA.debugLineNum = 42;BA.debugLine="btnIzquierda.Text = \">\"";
Debug.ShouldStop(512);
tutorial.mostCurrent._btnizquierda.runMethod(true,"setText",BA.ObjectToCharSequence(">"));
 BA.debugLineNum = 43;BA.debugLine="btnIzquierda.Background = esquinas";
Debug.ShouldStop(1024);
tutorial.mostCurrent._btnizquierda.runMethod(false,"setBackground",(tutorial.mostCurrent._esquinas.getObject()));
 BA.debugLineNum = 44;BA.debugLine="btnIzquierda.Color = Colors.RGB(28,230,210)";
Debug.ShouldStop(2048);
tutorial.mostCurrent._btnizquierda.runVoidMethod ("setColor",tutorial.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 28)),(Object)(BA.numberCast(int.class, 230)),(Object)(BA.numberCast(int.class, 210))));
 BA.debugLineNum = 45;BA.debugLine="Activity.AddView(btnIzquierda, 60%x, 101%y - 75di";
Debug.ShouldStop(4096);
tutorial.mostCurrent._activity.runVoidMethod ("AddView",(Object)((tutorial.mostCurrent._btnizquierda.getObject())),(Object)(tutorial.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 60)),tutorial.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {tutorial.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 101)),tutorial.mostCurrent.activityBA),tutorial.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 75)))}, "-",1, 1)),(Object)(tutorial.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(tutorial.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 53;BA.debugLine="btnTerminarTutorial.Initialize(\"TerminarTutorial\"";
Debug.ShouldStop(1048576);
tutorial.mostCurrent._btnterminartutorial.runVoidMethod ("Initialize",tutorial.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("TerminarTutorial")));
 BA.debugLineNum = 54;BA.debugLine="btnTerminarTutorial.Text = \"Terminar\"";
Debug.ShouldStop(2097152);
tutorial.mostCurrent._btnterminartutorial.runMethod(true,"setText",BA.ObjectToCharSequence("Terminar"));
 BA.debugLineNum = 55;BA.debugLine="btnTerminarTutorial.Background = esquinas";
Debug.ShouldStop(4194304);
tutorial.mostCurrent._btnterminartutorial.runMethod(false,"setBackground",(tutorial.mostCurrent._esquinas.getObject()));
 BA.debugLineNum = 56;BA.debugLine="btnTerminarTutorial.Color = Colors.RGB(28,230,210";
Debug.ShouldStop(8388608);
tutorial.mostCurrent._btnterminartutorial.runVoidMethod ("setColor",tutorial.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 28)),(Object)(BA.numberCast(int.class, 230)),(Object)(BA.numberCast(int.class, 210))));
 BA.debugLineNum = 57;BA.debugLine="Activity.AddView(btnTerminarTutorial, 10%x, 101%y";
Debug.ShouldStop(16777216);
tutorial.mostCurrent._activity.runVoidMethod ("AddView",(Object)((tutorial.mostCurrent._btnterminartutorial.getObject())),(Object)(tutorial.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),tutorial.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {tutorial.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 101)),tutorial.mostCurrent.activityBA),tutorial.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 75)))}, "-",1, 1)),(Object)(tutorial.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(tutorial.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 60;BA.debugLine="activarBitmap.Initialize(File.DirAssets, \"indicat";
Debug.ShouldStop(134217728);
tutorial.mostCurrent._activarbitmap.runVoidMethod ("Initialize",(Object)(tutorial.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("indicator_active.png")));
 BA.debugLineNum = 61;BA.debugLine="inactivarBitmap.Initialize(File.DirAssets, \"indic";
Debug.ShouldStop(268435456);
tutorial.mostCurrent._inactivarbitmap.runVoidMethod ("Initialize",(Object)(tutorial.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("indicator_inactive.png")));
 BA.debugLineNum = 67;BA.debugLine="sdSosten.Initialize";
Debug.ShouldStop(4);
tutorial.mostCurrent._sdsosten.runVoidMethod ("Initialize");
 BA.debugLineNum = 68;BA.debugLine="Diapositivas.Initialize(sdSosten, paneles, True,";
Debug.ShouldStop(8);
tutorial.mostCurrent._diapositivas.runVoidMethod ("_initialize" /*RemoteObject*/ ,tutorial.mostCurrent.activityBA,(Object)(tutorial.mostCurrent._sdsosten),(Object)(tutorial.mostCurrent._paneles),(Object)(tutorial.mostCurrent.__c.getField(true,"True")),(Object)(BA.numberCast(int.class, 150)));
 BA.debugLineNum = 69;BA.debugLine="sdSosten.currentPanel = pausarPanel - 1";
Debug.ShouldStop(16);
tutorial.mostCurrent._sdsosten.setField ("currentPanel" /*RemoteObject*/ ,RemoteObject.solve(new RemoteObject[] {tutorial._pausarpanel,RemoteObject.createImmutable(1)}, "-",1, 1));
 BA.debugLineNum = 71;BA.debugLine="pnIndicador = Diapositivas.CreatePageIndicator(pa";
Debug.ShouldStop(64);
tutorial.mostCurrent._pnindicador = tutorial.mostCurrent._diapositivas.runMethod(false,"_createpageindicator" /*RemoteObject*/ ,tutorial.mostCurrent.activityBA,(Object)(tutorial.mostCurrent._paneles.getField(true,"length")),(Object)(tutorial.mostCurrent._inactivarbitmap),(Object)(tutorial.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))),(Object)(tutorial.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 16)))));
 BA.debugLineNum = 72;BA.debugLine="Activity.AddView(pnIndicador , (100%x - 120dip) /";
Debug.ShouldStop(128);
tutorial.mostCurrent._activity.runVoidMethod ("AddView",(Object)((tutorial.mostCurrent._pnindicador.getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {tutorial.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),tutorial.mostCurrent.activityBA),tutorial.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0))),(Object)(BA.numberCast(int.class, 0)),(Object)(tutorial.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))),(Object)(tutorial.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 16)))));
 BA.debugLineNum = 73;BA.debugLine="pnIndicador.BringToFront";
Debug.ShouldStop(256);
tutorial.mostCurrent._pnindicador.runVoidMethod ("BringToFront");
 BA.debugLineNum = 74;BA.debugLine="ChangePanel(0)";
Debug.ShouldStop(512);
_changepanel(BA.numberCast(int.class, 0));
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (tutorial) ","tutorial",2,tutorial.mostCurrent.activityBA,tutorial.mostCurrent,132);
if (RapidSub.canDelegate("activity_pause")) { return pullup.wallet.tutorial.remoteMe.runUserSub(false, "tutorial","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 132;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8);
 BA.debugLineNum = 133;BA.debugLine="If UserClosed = False Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",_userclosed,tutorial.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 134;BA.debugLine="pausarPanel = sdSosten.currentPanel";
Debug.ShouldStop(32);
tutorial._pausarpanel = tutorial.mostCurrent._sdsosten.getField(true,"currentPanel" /*RemoteObject*/ );
 }else {
 BA.debugLineNum = 136;BA.debugLine="pausarPanel = 0";
Debug.ShouldStop(128);
tutorial._pausarpanel = BA.numberCast(int.class, 0);
 };
 BA.debugLineNum = 138;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (tutorial) ","tutorial",2,tutorial.mostCurrent.activityBA,tutorial.mostCurrent,127);
if (RapidSub.canDelegate("activity_resume")) { return pullup.wallet.tutorial.remoteMe.runUserSub(false, "tutorial","activity_resume");}
 BA.debugLineNum = 127;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 129;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _animation1_animationend() throws Exception{
try {
		Debug.PushSubsStack("Animation1_AnimationEnd (tutorial) ","tutorial",2,tutorial.mostCurrent.activityBA,tutorial.mostCurrent,110);
if (RapidSub.canDelegate("animation1_animationend")) { return pullup.wallet.tutorial.remoteMe.runUserSub(false, "tutorial","animation1_animationend");}
 BA.debugLineNum = 110;BA.debugLine="Sub Animation1_AnimationEnd";
Debug.ShouldStop(8192);
 BA.debugLineNum = 112;BA.debugLine="Diapositivas.AnimationEnd(sdSosten)";
Debug.ShouldStop(32768);
tutorial.mostCurrent._diapositivas.runVoidMethod ("_animationend" /*RemoteObject*/ ,tutorial.mostCurrent.activityBA,(Object)(tutorial.mostCurrent._sdsosten));
 BA.debugLineNum = 115;BA.debugLine="If sdSosten.rotate Then";
Debug.ShouldStop(262144);
if (tutorial.mostCurrent._sdsosten.getField(true,"rotate" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 116;BA.debugLine="btnIzquierda.Enabled = True";
Debug.ShouldStop(524288);
tutorial.mostCurrent._btnizquierda.runMethod(true,"setEnabled",tutorial.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 119;BA.debugLine="If sdSosten.currentPanel = sdSosten.panels.Lengt";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",tutorial.mostCurrent._sdsosten.getField(true,"currentPanel" /*RemoteObject*/ ),BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {tutorial.mostCurrent._sdsosten.getField(false,"Panels" /*RemoteObject*/ ).getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)))) { 
tutorial.mostCurrent._btnizquierda.runMethod(true,"setEnabled",tutorial.mostCurrent.__c.getField(true,"False"));}
else {
tutorial.mostCurrent._btnizquierda.runMethod(true,"setEnabled",tutorial.mostCurrent.__c.getField(true,"True"));};
 };
 BA.debugLineNum = 124;BA.debugLine="Diapositivas.SetPageIndicator(pnIndicador, sdSost";
Debug.ShouldStop(134217728);
tutorial.mostCurrent._diapositivas.runVoidMethod ("_setpageindicator" /*RemoteObject*/ ,tutorial.mostCurrent.activityBA,(Object)(tutorial.mostCurrent._pnindicador),(Object)(tutorial.mostCurrent._sdsosten.getField(true,"currentPanel" /*RemoteObject*/ )),(Object)(tutorial.mostCurrent._activarbitmap),(Object)(tutorial.mostCurrent._inactivarbitmap));
 BA.debugLineNum = 125;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _changepanel(RemoteObject _page) throws Exception{
try {
		Debug.PushSubsStack("ChangePanel (tutorial) ","tutorial",2,tutorial.mostCurrent.activityBA,tutorial.mostCurrent,100);
if (RapidSub.canDelegate("changepanel")) { return pullup.wallet.tutorial.remoteMe.runUserSub(false, "tutorial","changepanel", _page);}
Debug.locals.put("page", _page);
 BA.debugLineNum = 100;BA.debugLine="Sub ChangePanel(page As Int)";
Debug.ShouldStop(8);
 BA.debugLineNum = 102;BA.debugLine="btnIzquierda.Enabled = False";
Debug.ShouldStop(32);
tutorial.mostCurrent._btnizquierda.runMethod(true,"setEnabled",tutorial.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 106;BA.debugLine="sdSosten.targetPanel = page";
Debug.ShouldStop(512);
tutorial.mostCurrent._sdsosten.setField ("targetPanel" /*RemoteObject*/ ,_page);
 BA.debugLineNum = 107;BA.debugLine="Diapositivas.ChangePanel(sdSosten)";
Debug.ShouldStop(1024);
tutorial.mostCurrent._diapositivas.runVoidMethod ("_changepanel" /*RemoteObject*/ ,tutorial.mostCurrent.activityBA,(Object)(tutorial.mostCurrent._sdsosten));
 BA.debugLineNum = 108;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 13;BA.debugLine="Dim sdSosten As SlidingData 'Este objeto sostiene";
tutorial.mostCurrent._sdsosten = RemoteObject.createNew ("pullup.wallet.diapositivas._slidingdata");
 //BA.debugLineNum = 14;BA.debugLine="Dim paneles(7) As Panel 'Se crean n cantidad de p";
tutorial.mostCurrent._paneles = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.PanelWrapper", new int[] {7}, new Object[]{});
 //BA.debugLineNum = 15;BA.debugLine="Dim diapositiva As String";
tutorial.mostCurrent._diapositiva = RemoteObject.createImmutable("");
 //BA.debugLineNum = 16;BA.debugLine="Dim esquinas As ColorDrawable 'Variable que ayuda";
tutorial.mostCurrent._esquinas = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");
 //BA.debugLineNum = 17;BA.debugLine="Dim btnIzquierda As Button";
tutorial.mostCurrent._btnizquierda = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Dim btnTerminarTutorial As Button";
tutorial.mostCurrent._btnterminartutorial = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Dim pnIndicador As Panel";
tutorial.mostCurrent._pnindicador = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Dim menu As String";
tutorial.mostCurrent._menu = RemoteObject.createImmutable("");
 //BA.debugLineNum = 22;BA.debugLine="Dim activarBitmap As Bitmap";
tutorial.mostCurrent._activarbitmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Dim inactivarBitmap As Bitmap";
tutorial.mostCurrent._inactivarbitmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _left_click() throws Exception{
try {
		Debug.PushSubsStack("Left_Click (tutorial) ","tutorial",2,tutorial.mostCurrent.activityBA,tutorial.mostCurrent,85);
if (RapidSub.canDelegate("left_click")) { return pullup.wallet.tutorial.remoteMe.runUserSub(false, "tutorial","left_click");}
 BA.debugLineNum = 85;BA.debugLine="Sub Left_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 86;BA.debugLine="ChangePanel(Diapositivas.PANEL_LEFT)";
Debug.ShouldStop(2097152);
_changepanel(tutorial.mostCurrent._diapositivas._panel_left /*RemoteObject*/ );
 BA.debugLineNum = 87;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _menu_click() throws Exception{
try {
		Debug.PushSubsStack("Menu_Click (tutorial) ","tutorial",2,tutorial.mostCurrent.activityBA,tutorial.mostCurrent,77);
if (RapidSub.canDelegate("menu_click")) { return pullup.wallet.tutorial.remoteMe.runUserSub(false, "tutorial","menu_click");}
 BA.debugLineNum = 77;BA.debugLine="Sub Menu_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 78;BA.debugLine="menu = Sender";
Debug.ShouldStop(8192);
tutorial.mostCurrent._menu = BA.ObjectToString(tutorial.mostCurrent.__c.runMethod(false,"Sender",tutorial.mostCurrent.activityBA));
 BA.debugLineNum = 79;BA.debugLine="btnIzquierda.Enabled = False";
Debug.ShouldStop(16384);
tutorial.mostCurrent._btnizquierda.runMethod(true,"setEnabled",tutorial.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 81;BA.debugLine="ChangePanel(menu.SubString(\"Panel #\".Length))";
Debug.ShouldStop(65536);
_changepanel(BA.numberCast(int.class, tutorial.mostCurrent._menu.runMethod(true,"substring",(Object)(RemoteObject.createImmutable("Panel #").runMethod(true,"length")))));
 BA.debugLineNum = 82;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Dim tmrAnimacion As Timer";
tutorial._tmranimacion = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 8;BA.debugLine="Dim pausarPanel As Int";
tutorial._pausarpanel = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 9;BA.debugLine="Dim contador1 As Int";
tutorial._contador1 = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _right_click() throws Exception{
try {
		Debug.PushSubsStack("Right_Click (tutorial) ","tutorial",2,tutorial.mostCurrent.activityBA,tutorial.mostCurrent,95);
if (RapidSub.canDelegate("right_click")) { return pullup.wallet.tutorial.remoteMe.runUserSub(false, "tutorial","right_click");}
 BA.debugLineNum = 95;BA.debugLine="Sub Right_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 96;BA.debugLine="ChangePanel(Diapositivas.PANEL_RIGHT)";
Debug.ShouldStop(-2147483648);
_changepanel(tutorial.mostCurrent._diapositivas._panel_right /*RemoteObject*/ );
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _terminartutorial_click() throws Exception{
try {
		Debug.PushSubsStack("TerminarTutorial_Click (tutorial) ","tutorial",2,tutorial.mostCurrent.activityBA,tutorial.mostCurrent,89);
if (RapidSub.canDelegate("terminartutorial_click")) { return pullup.wallet.tutorial.remoteMe.runUserSub(false, "tutorial","terminartutorial_click");}
 BA.debugLineNum = 89;BA.debugLine="Sub TerminarTutorial_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 90;BA.debugLine="StartActivity(\"Main\")";
Debug.ShouldStop(33554432);
tutorial.mostCurrent.__c.runVoidMethod ("StartActivity",tutorial.processBA,(Object)((RemoteObject.createImmutable("Main"))));
 BA.debugLineNum = 91;BA.debugLine="Log(\"Ir a menu\")";
Debug.ShouldStop(67108864);
tutorial.mostCurrent.__c.runVoidMethod ("LogImpl","52424834",RemoteObject.createImmutable("Ir a menu"),0);
 BA.debugLineNum = 92;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}