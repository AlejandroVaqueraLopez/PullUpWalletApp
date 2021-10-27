package pullup.wallet;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class diapositivas_subs_0 {


public static RemoteObject  _animationend(RemoteObject _ba,RemoteObject _sd) throws Exception{
try {
		Debug.PushSubsStack("AnimationEnd (diapositivas) ","diapositivas",3,_ba,diapositivas.mostCurrent,124);
if (RapidSub.canDelegate("animationend")) { return pullup.wallet.diapositivas.remoteMe.runUserSub(false, "diapositivas","animationend", _ba, _sd);}
int _i = 0;
;
Debug.locals.put("sd", _sd);
 BA.debugLineNum = 124;BA.debugLine="Sub AnimationEnd (sd As SlidingData)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 125;BA.debugLine="sd.panels(sd.currentPanel).Left = 0 'Set the posi";
Debug.ShouldStop(268435456);
_sd.getField(false,"Panels" /*RemoteObject*/ ).getArrayElement(false,_sd.getField(true,"currentPanel" /*RemoteObject*/ )).runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 126;BA.debugLine="For i = 0 To sd.panels.Length - 1";
Debug.ShouldStop(536870912);
{
final int step2 = 1;
final int limit2 = RemoteObject.solve(new RemoteObject[] {_sd.getField(false,"Panels" /*RemoteObject*/ ).getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2) ;_i = ((int)(0 + _i + step2))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 127;BA.debugLine="If i <> sd.currentPanel Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("!",RemoteObject.createImmutable(_i),BA.numberCast(double.class, _sd.getField(true,"currentPanel" /*RemoteObject*/ )))) { 
 BA.debugLineNum = 128;BA.debugLine="sd.Panels(i).Left = 100%x 'Move all other panel";
Debug.ShouldStop(-2147483648);
_sd.getField(false,"Panels" /*RemoteObject*/ ).getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setLeft",diapositivas.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba));
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 131;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _changepanel(RemoteObject _ba,RemoteObject _sd) throws Exception{
try {
		Debug.PushSubsStack("ChangePanel (diapositivas) ","diapositivas",3,_ba,diapositivas.mostCurrent,32);
if (RapidSub.canDelegate("changepanel")) { return pullup.wallet.diapositivas.remoteMe.runUserSub(false, "diapositivas","changepanel", _ba, _sd);}
RemoteObject _relativeduration = RemoteObject.createImmutable(0);
RemoteObject _secondaryindex = RemoteObject.createImmutable(0);
RemoteObject _slideleft = RemoteObject.createImmutable(false);
RemoteObject _tox = RemoteObject.createImmutable(0);
;
Debug.locals.put("sd", _sd);
 BA.debugLineNum = 32;BA.debugLine="Sub ChangePanel(sd As SlidingData)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 33;BA.debugLine="Dim relativeDuration As Int";
Debug.ShouldStop(1);
_relativeduration = RemoteObject.createImmutable(0);Debug.locals.put("relativeDuration", _relativeduration);
 BA.debugLineNum = 34;BA.debugLine="Dim secondaryIndex As Int";
Debug.ShouldStop(2);
_secondaryindex = RemoteObject.createImmutable(0);Debug.locals.put("secondaryIndex", _secondaryindex);
 BA.debugLineNum = 35;BA.debugLine="Dim slideleft As Boolean : slideleft = False";
Debug.ShouldStop(4);
_slideleft = RemoteObject.createImmutable(false);Debug.locals.put("slideleft", _slideleft);
 BA.debugLineNum = 35;BA.debugLine="Dim slideleft As Boolean : slideleft = False";
Debug.ShouldStop(4);
_slideleft = diapositivas.mostCurrent.__c.getField(true,"False");Debug.locals.put("slideleft", _slideleft);
 BA.debugLineNum = 38;BA.debugLine="If sd.targetPanel = PANEL_LEFT Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_sd.getField(true,"targetPanel" /*RemoteObject*/ ),BA.numberCast(double.class, diapositivas._panel_left))) { 
 BA.debugLineNum = 39;BA.debugLine="sd.targetPanel = sd.currentPanel  + 1";
Debug.ShouldStop(64);
_sd.setField ("targetPanel" /*RemoteObject*/ ,RemoteObject.solve(new RemoteObject[] {_sd.getField(true,"currentPanel" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "+",1, 1));
 };
 BA.debugLineNum = 43;BA.debugLine="If sd.targetPanel = PANEL_RIGHT Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",_sd.getField(true,"targetPanel" /*RemoteObject*/ ),BA.numberCast(double.class, diapositivas._panel_right))) { 
 BA.debugLineNum = 44;BA.debugLine="sd.targetPanel = sd.currentPanel - 1";
Debug.ShouldStop(2048);
_sd.setField ("targetPanel" /*RemoteObject*/ ,RemoteObject.solve(new RemoteObject[] {_sd.getField(true,"currentPanel" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "-",1, 1));
 };
 BA.debugLineNum = 48;BA.debugLine="If sd.currentPanel < sd.targetPanel Then slidelef";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("<",_sd.getField(true,"currentPanel" /*RemoteObject*/ ),BA.numberCast(double.class, _sd.getField(true,"targetPanel" /*RemoteObject*/ )))) { 
_slideleft = diapositivas.mostCurrent.__c.getField(true,"True");Debug.locals.put("slideleft", _slideleft);};
 BA.debugLineNum = 51;BA.debugLine="If sd.targetPanel > sd.Panels.Length - 1 Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean(">",_sd.getField(true,"targetPanel" /*RemoteObject*/ ),BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_sd.getField(false,"Panels" /*RemoteObject*/ ).getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)))) { 
 BA.debugLineNum = 52;BA.debugLine="If sd.rotate Then";
Debug.ShouldStop(524288);
if (_sd.getField(true,"rotate" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 53;BA.debugLine="sd.targetPanel = 0";
Debug.ShouldStop(1048576);
_sd.setField ("targetPanel" /*RemoteObject*/ ,BA.numberCast(int.class, 0));
 }else {
 BA.debugLineNum = 55;BA.debugLine="sd.targetPanel = sd.currentPanel";
Debug.ShouldStop(4194304);
_sd.setField ("targetPanel" /*RemoteObject*/ ,_sd.getField(true,"currentPanel" /*RemoteObject*/ ));
 };
 };
 BA.debugLineNum = 59;BA.debugLine="If sd.targetPanel < 0 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("<",_sd.getField(true,"targetPanel" /*RemoteObject*/ ),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 60;BA.debugLine="If sd.rotate Then";
Debug.ShouldStop(134217728);
if (_sd.getField(true,"rotate" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 61;BA.debugLine="sd.targetPanel = sd.Panels.Length - 1";
Debug.ShouldStop(268435456);
_sd.setField ("targetPanel" /*RemoteObject*/ ,RemoteObject.solve(new RemoteObject[] {_sd.getField(false,"Panels" /*RemoteObject*/ ).getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1));
 }else {
 BA.debugLineNum = 63;BA.debugLine="sd.targetPanel = sd.currentPanel";
Debug.ShouldStop(1073741824);
_sd.setField ("targetPanel" /*RemoteObject*/ ,_sd.getField(true,"currentPanel" /*RemoteObject*/ ));
 };
 };
 BA.debugLineNum = 67;BA.debugLine="If sd.currentPanel = sd.targetPanel And sd.curren";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",_sd.getField(true,"currentPanel" /*RemoteObject*/ ),BA.numberCast(double.class, _sd.getField(true,"targetPanel" /*RemoteObject*/ ))) && RemoteObject.solveBoolean("!",_sd.getField(true,"currentPanel" /*RemoteObject*/ ),BA.numberCast(double.class, -(double) (0 + 1)))) { 
 BA.debugLineNum = 68;BA.debugLine="relativeDuration = sd.duration / 100%x * Abs(sd.";
Debug.ShouldStop(8);
_relativeduration = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_sd.getField(true,"duration" /*RemoteObject*/ ),diapositivas.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),diapositivas.mostCurrent.__c.runMethod(true,"Abs",(Object)(BA.numberCast(double.class, _sd.getField(false,"Panels" /*RemoteObject*/ ).getArrayElement(false,_sd.getField(true,"currentPanel" /*RemoteObject*/ )).runMethod(true,"getLeft"))))}, "/*",0, 0));Debug.locals.put("relativeDuration", _relativeduration);
 BA.debugLineNum = 71;BA.debugLine="If sd.Panels(sd.currentPanel).Left >= 0 Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("g",_sd.getField(false,"Panels" /*RemoteObject*/ ).getArrayElement(false,_sd.getField(true,"currentPanel" /*RemoteObject*/ )).runMethod(true,"getLeft"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 72;BA.debugLine="secondaryIndex = sd.currentPanel - 1";
Debug.ShouldStop(128);
_secondaryindex = RemoteObject.solve(new RemoteObject[] {_sd.getField(true,"currentPanel" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "-",1, 1);Debug.locals.put("secondaryIndex", _secondaryindex);
 BA.debugLineNum = 73;BA.debugLine="If secondaryIndex < 0 And sd.rotate Then second";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("<",_secondaryindex,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean(".",_sd.getField(true,"rotate" /*RemoteObject*/ ))) { 
_secondaryindex = RemoteObject.solve(new RemoteObject[] {_sd.getField(false,"Panels" /*RemoteObject*/ ).getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1);Debug.locals.put("secondaryIndex", _secondaryindex);};
 }else {
 BA.debugLineNum = 75;BA.debugLine="secondaryIndex = sd.currentPanel + 1";
Debug.ShouldStop(1024);
_secondaryindex = RemoteObject.solve(new RemoteObject[] {_sd.getField(true,"currentPanel" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("secondaryIndex", _secondaryindex);
 BA.debugLineNum = 76;BA.debugLine="If secondaryIndex > sd.Panels.Length - 1 Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean(">",_secondaryindex,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_sd.getField(false,"Panels" /*RemoteObject*/ ).getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)))) { 
 BA.debugLineNum = 77;BA.debugLine="If sd.rotate Then secondaryIndex = 0 Else seco";
Debug.ShouldStop(4096);
if (_sd.getField(true,"rotate" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
_secondaryindex = BA.numberCast(int.class, 0);Debug.locals.put("secondaryIndex", _secondaryindex);}
else {
_secondaryindex = BA.numberCast(int.class, -(double) (0 + 1));Debug.locals.put("secondaryIndex", _secondaryindex);};
 };
 };
 BA.debugLineNum = 81;BA.debugLine="Dim toX As Int";
Debug.ShouldStop(65536);
_tox = RemoteObject.createImmutable(0);Debug.locals.put("toX", _tox);
 BA.debugLineNum = 83;BA.debugLine="toX = -sd.Panels(sd.currentPanel).Left";
Debug.ShouldStop(262144);
_tox = BA.numberCast(int.class, -(double) (0 + _sd.getField(false,"Panels" /*RemoteObject*/ ).getArrayElement(false,_sd.getField(true,"currentPanel" /*RemoteObject*/ )).runMethod(true,"getLeft").<Integer>get().intValue()));Debug.locals.put("toX", _tox);
 BA.debugLineNum = 86;BA.debugLine="sd.slideAnimations(1).InitializeTranslate(\"anima";
Debug.ShouldStop(2097152);
_sd.getField(false,"slideAnimations" /*RemoteObject*/ ).getArrayElement(false,BA.numberCast(int.class, 1)).runVoidMethod ("InitializeTranslate",_ba,(Object)(BA.ObjectToString("animation1")),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, _tox)),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 87;BA.debugLine="sd.slideAnimations(1).Duration = relativeDuratio";
Debug.ShouldStop(4194304);
_sd.getField(false,"slideAnimations" /*RemoteObject*/ ).getArrayElement(false,BA.numberCast(int.class, 1)).runMethod(true,"setDuration",BA.numberCast(long.class, _relativeduration));
 BA.debugLineNum = 88;BA.debugLine="sd.slideAnimations(1).Start(sd.panels(sd.current";
Debug.ShouldStop(8388608);
_sd.getField(false,"slideAnimations" /*RemoteObject*/ ).getArrayElement(false,BA.numberCast(int.class, 1)).runVoidMethod ("Start",(Object)((_sd.getField(false,"Panels" /*RemoteObject*/ ).getArrayElement(false,_sd.getField(true,"currentPanel" /*RemoteObject*/ )).getObject())));
 BA.debugLineNum = 91;BA.debugLine="If secondaryIndex <> -1 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("!",_secondaryindex,BA.numberCast(double.class, -(double) (0 + 1)))) { 
 BA.debugLineNum = 92;BA.debugLine="sd.slideAnimations(0).InitializeTranslate( \"ani";
Debug.ShouldStop(134217728);
_sd.getField(false,"slideAnimations" /*RemoteObject*/ ).getArrayElement(false,BA.numberCast(int.class, 0)).runVoidMethod ("InitializeTranslate",_ba,(Object)(BA.ObjectToString("animation0")),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, _tox)),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 93;BA.debugLine="sd.slideAnimations(0).Duration = relativeDurati";
Debug.ShouldStop(268435456);
_sd.getField(false,"slideAnimations" /*RemoteObject*/ ).getArrayElement(false,BA.numberCast(int.class, 0)).runMethod(true,"setDuration",BA.numberCast(long.class, _relativeduration));
 BA.debugLineNum = 94;BA.debugLine="sd.slideAnimations(0).Start(sd.panels(secondary";
Debug.ShouldStop(536870912);
_sd.getField(false,"slideAnimations" /*RemoteObject*/ ).getArrayElement(false,BA.numberCast(int.class, 0)).runVoidMethod ("Start",(Object)((_sd.getField(false,"Panels" /*RemoteObject*/ ).getArrayElement(false,_secondaryindex).getObject())));
 };
 }else {
 BA.debugLineNum = 97;BA.debugLine="If slideleft Or sd.currentPanel = -1 Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean(".",_slideleft) || RemoteObject.solveBoolean("=",_sd.getField(true,"currentPanel" /*RemoteObject*/ ),BA.numberCast(double.class, -(double) (0 + 1)))) { 
 BA.debugLineNum = 98;BA.debugLine="relativeDuration = sd.duration / 100%x * Abs(sd";
Debug.ShouldStop(2);
_relativeduration = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_sd.getField(true,"duration" /*RemoteObject*/ ),diapositivas.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),diapositivas.mostCurrent.__c.runMethod(true,"Abs",(Object)(BA.numberCast(double.class, _sd.getField(false,"Panels" /*RemoteObject*/ ).getArrayElement(false,_sd.getField(true,"targetPanel" /*RemoteObject*/ )).runMethod(true,"getLeft"))))}, "/*",0, 0));Debug.locals.put("relativeDuration", _relativeduration);
 BA.debugLineNum = 99;BA.debugLine="If sd.currentPanel <> -1 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("!",_sd.getField(true,"currentPanel" /*RemoteObject*/ ),BA.numberCast(double.class, -(double) (0 + 1)))) { 
 BA.debugLineNum = 100;BA.debugLine="sd.Panels(sd.targetPanel).Left = sd.Panels(sd.";
Debug.ShouldStop(8);
_sd.getField(false,"Panels" /*RemoteObject*/ ).getArrayElement(false,_sd.getField(true,"targetPanel" /*RemoteObject*/ )).runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {_sd.getField(false,"Panels" /*RemoteObject*/ ).getArrayElement(false,_sd.getField(true,"currentPanel" /*RemoteObject*/ )).runMethod(true,"getLeft"),diapositivas.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba)}, "+",1, 1));
 BA.debugLineNum = 101;BA.debugLine="sd.slideAnimations(0).InitializeTranslate(\"ani";
Debug.ShouldStop(16);
_sd.getField(false,"slideAnimations" /*RemoteObject*/ ).getArrayElement(false,BA.numberCast(int.class, 0)).runVoidMethod ("InitializeTranslate",_ba,(Object)(BA.ObjectToString("animation0")),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, -(double) (0 + diapositivas.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba).<Integer>get().intValue())-(double) (0 + _sd.getField(false,"Panels" /*RemoteObject*/ ).getArrayElement(false,_sd.getField(true,"currentPanel" /*RemoteObject*/ )).runMethod(true,"getLeft").<Integer>get().intValue()))),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 102;BA.debugLine="sd.slideAnimations(0).Duration = relativeDurat";
Debug.ShouldStop(32);
_sd.getField(false,"slideAnimations" /*RemoteObject*/ ).getArrayElement(false,BA.numberCast(int.class, 0)).runMethod(true,"setDuration",BA.numberCast(long.class, _relativeduration));
 BA.debugLineNum = 103;BA.debugLine="sd.slideAnimations(0).Start(sd.panels(sd.curre";
Debug.ShouldStop(64);
_sd.getField(false,"slideAnimations" /*RemoteObject*/ ).getArrayElement(false,BA.numberCast(int.class, 0)).runVoidMethod ("Start",(Object)((_sd.getField(false,"Panels" /*RemoteObject*/ ).getArrayElement(false,_sd.getField(true,"currentPanel" /*RemoteObject*/ )).getObject())));
 };
 BA.debugLineNum = 105;BA.debugLine="sd.slideAnimations(1).InitializeTranslate( \"ani";
Debug.ShouldStop(256);
_sd.getField(false,"slideAnimations" /*RemoteObject*/ ).getArrayElement(false,BA.numberCast(int.class, 1)).runVoidMethod ("InitializeTranslate",_ba,(Object)(BA.ObjectToString("animation1")),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, -(double) (0 + _sd.getField(false,"Panels" /*RemoteObject*/ ).getArrayElement(false,_sd.getField(true,"targetPanel" /*RemoteObject*/ )).runMethod(true,"getLeft").<Integer>get().intValue()))),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 106;BA.debugLine="sd.slideAnimations(1).Duration = relativeDurati";
Debug.ShouldStop(512);
_sd.getField(false,"slideAnimations" /*RemoteObject*/ ).getArrayElement(false,BA.numberCast(int.class, 1)).runMethod(true,"setDuration",BA.numberCast(long.class, _relativeduration));
 BA.debugLineNum = 107;BA.debugLine="sd.slideAnimations(1).Start(sd.panels(sd.target";
Debug.ShouldStop(1024);
_sd.getField(false,"slideAnimations" /*RemoteObject*/ ).getArrayElement(false,BA.numberCast(int.class, 1)).runVoidMethod ("Start",(Object)((_sd.getField(false,"Panels" /*RemoteObject*/ ).getArrayElement(false,_sd.getField(true,"targetPanel" /*RemoteObject*/ )).getObject())));
 BA.debugLineNum = 108;BA.debugLine="sd.currentPanel = sd.targetPanel";
Debug.ShouldStop(2048);
_sd.setField ("currentPanel" /*RemoteObject*/ ,_sd.getField(true,"targetPanel" /*RemoteObject*/ ));
 }else {
 BA.debugLineNum = 110;BA.debugLine="sd.Panels(sd.targetPanel).Left = sd.Panels(sd.c";
Debug.ShouldStop(8192);
_sd.getField(false,"Panels" /*RemoteObject*/ ).getArrayElement(false,_sd.getField(true,"targetPanel" /*RemoteObject*/ )).runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {_sd.getField(false,"Panels" /*RemoteObject*/ ).getArrayElement(false,_sd.getField(true,"currentPanel" /*RemoteObject*/ )).runMethod(true,"getLeft"),diapositivas.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba)}, "-",1, 1));
 BA.debugLineNum = 111;BA.debugLine="relativeDuration = sd.duration / 100%x * Abs(10";
Debug.ShouldStop(16384);
_relativeduration = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_sd.getField(true,"duration" /*RemoteObject*/ ),diapositivas.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),diapositivas.mostCurrent.__c.runMethod(true,"Abs",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {diapositivas.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_sd.getField(false,"Panels" /*RemoteObject*/ ).getArrayElement(false,_sd.getField(true,"currentPanel" /*RemoteObject*/ )).runMethod(true,"getLeft")}, "-",1, 1))))}, "/*",0, 0));Debug.locals.put("relativeDuration", _relativeduration);
 BA.debugLineNum = 112;BA.debugLine="leftPanel = (sd.currentPanel + sd.Panels.Length";
Debug.ShouldStop(32768);
diapositivas._leftpanel = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_sd.getField(true,"currentPanel" /*RemoteObject*/ ),_sd.getField(false,"Panels" /*RemoteObject*/ ).getField(true,"length"),RemoteObject.createImmutable(1)}, "+-",2, 1)),_sd.getField(false,"Panels" /*RemoteObject*/ ).getField(true,"length")}, "%",0, 1);
 BA.debugLineNum = 113;BA.debugLine="sd.slideAnimations(0).InitializeTranslate(\"anim";
Debug.ShouldStop(65536);
_sd.getField(false,"slideAnimations" /*RemoteObject*/ ).getArrayElement(false,BA.numberCast(int.class, 0)).runVoidMethod ("InitializeTranslate",_ba,(Object)(BA.ObjectToString("animation0")),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {diapositivas.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_sd.getField(false,"Panels" /*RemoteObject*/ ).getArrayElement(false,_sd.getField(true,"currentPanel" /*RemoteObject*/ )).runMethod(true,"getLeft")}, "-",1, 1))),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 114;BA.debugLine="sd.slideAnimations(1).InitializeTranslate(\"anim";
Debug.ShouldStop(131072);
_sd.getField(false,"slideAnimations" /*RemoteObject*/ ).getArrayElement(false,BA.numberCast(int.class, 1)).runVoidMethod ("InitializeTranslate",_ba,(Object)(BA.ObjectToString("animation1")),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {diapositivas.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_sd.getField(false,"Panels" /*RemoteObject*/ ).getArrayElement(false,_sd.getField(true,"currentPanel" /*RemoteObject*/ )).runMethod(true,"getLeft")}, "-",1, 1))),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 115;BA.debugLine="sd.slideAnimations(0).Duration = relativeDurati";
Debug.ShouldStop(262144);
_sd.getField(false,"slideAnimations" /*RemoteObject*/ ).getArrayElement(false,BA.numberCast(int.class, 0)).runMethod(true,"setDuration",BA.numberCast(long.class, _relativeduration));
 BA.debugLineNum = 116;BA.debugLine="sd.slideAnimations(1).Duration = relativeDurati";
Debug.ShouldStop(524288);
_sd.getField(false,"slideAnimations" /*RemoteObject*/ ).getArrayElement(false,BA.numberCast(int.class, 1)).runMethod(true,"setDuration",BA.numberCast(long.class, _relativeduration));
 BA.debugLineNum = 117;BA.debugLine="sd.slideAnimations(0).Start(sd.panels(sd.curren";
Debug.ShouldStop(1048576);
_sd.getField(false,"slideAnimations" /*RemoteObject*/ ).getArrayElement(false,BA.numberCast(int.class, 0)).runVoidMethod ("Start",(Object)((_sd.getField(false,"Panels" /*RemoteObject*/ ).getArrayElement(false,_sd.getField(true,"currentPanel" /*RemoteObject*/ )).getObject())));
 BA.debugLineNum = 118;BA.debugLine="sd.slideAnimations(1).Start(sd.panels(sd.target";
Debug.ShouldStop(2097152);
_sd.getField(false,"slideAnimations" /*RemoteObject*/ ).getArrayElement(false,BA.numberCast(int.class, 1)).runVoidMethod ("Start",(Object)((_sd.getField(false,"Panels" /*RemoteObject*/ ).getArrayElement(false,_sd.getField(true,"targetPanel" /*RemoteObject*/ )).getObject())));
 BA.debugLineNum = 119;BA.debugLine="sd.currentPanel = sd.targetPanel";
Debug.ShouldStop(4194304);
_sd.setField ("currentPanel" /*RemoteObject*/ ,_sd.getField(true,"targetPanel" /*RemoteObject*/ ));
 };
 };
 BA.debugLineNum = 122;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createpageindicator(RemoteObject _ba,RemoteObject _numberofpages,RemoteObject _inactivebitmap,RemoteObject _width,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("CreatePageIndicator (diapositivas) ","diapositivas",3,_ba,diapositivas.mostCurrent,133);
if (RapidSub.canDelegate("createpageindicator")) { return pullup.wallet.diapositivas.remoteMe.runUserSub(false, "diapositivas","createpageindicator", _ba, _numberofpages, _inactivebitmap, _width, _height);}
RemoteObject _imagesize = RemoteObject.createImmutable(0);
RemoteObject _maxwidth = RemoteObject.createImmutable(0);
RemoteObject _gap = RemoteObject.createImmutable(0);
RemoteObject _top = RemoteObject.createImmutable(0);
RemoteObject _basepanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
int _i = 0;
RemoteObject _iv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
;
Debug.locals.put("numberOfPages", _numberofpages);
Debug.locals.put("inactiveBitmap", _inactivebitmap);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 133;BA.debugLine="Sub CreatePageIndicator(numberOfPages As Int, inac";
Debug.ShouldStop(16);
 BA.debugLineNum = 134;BA.debugLine="Dim imageSize, maxWidth, Gap, Top As Int";
Debug.ShouldStop(32);
_imagesize = RemoteObject.createImmutable(0);Debug.locals.put("imageSize", _imagesize);
_maxwidth = RemoteObject.createImmutable(0);Debug.locals.put("maxWidth", _maxwidth);
_gap = RemoteObject.createImmutable(0);Debug.locals.put("Gap", _gap);
_top = RemoteObject.createImmutable(0);Debug.locals.put("Top", _top);
 BA.debugLineNum = 136;BA.debugLine="maxWidth = Width / numberOfPages";
Debug.ShouldStop(128);
_maxwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_width,_numberofpages}, "/",0, 0));Debug.locals.put("maxWidth", _maxwidth);
 BA.debugLineNum = 137;BA.debugLine="If maxWidth < Height Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("<",_maxwidth,BA.numberCast(double.class, _height))) { 
 BA.debugLineNum = 138;BA.debugLine="imageSize = maxWidth";
Debug.ShouldStop(512);
_imagesize = _maxwidth;Debug.locals.put("imageSize", _imagesize);
 BA.debugLineNum = 139;BA.debugLine="Top = (Height - maxWidth) / 2";
Debug.ShouldStop(1024);
_top = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_height,_maxwidth}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("Top", _top);
 BA.debugLineNum = 140;BA.debugLine="Gap = 0";
Debug.ShouldStop(2048);
_gap = BA.numberCast(int.class, 0);Debug.locals.put("Gap", _gap);
 }else {
 BA.debugLineNum = 142;BA.debugLine="imageSize = Height";
Debug.ShouldStop(8192);
_imagesize = _height;Debug.locals.put("imageSize", _imagesize);
 BA.debugLineNum = 143;BA.debugLine="Top = 0";
Debug.ShouldStop(16384);
_top = BA.numberCast(int.class, 0);Debug.locals.put("Top", _top);
 BA.debugLineNum = 144;BA.debugLine="Gap = (Width - numberOfPages * imageSize) / (num";
Debug.ShouldStop(32768);
_gap = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_width,_numberofpages,_imagesize}, "-*",1, 1)),(RemoteObject.solve(new RemoteObject[] {_numberofpages,RemoteObject.createImmutable(1)}, "-",1, 1))}, "/",0, 0));Debug.locals.put("Gap", _gap);
 };
 BA.debugLineNum = 147;BA.debugLine="Dim basePanel As Panel";
Debug.ShouldStop(262144);
_basepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("basePanel", _basepanel);
 BA.debugLineNum = 149;BA.debugLine="basePanel.Initialize(\"\")";
Debug.ShouldStop(1048576);
_basepanel.runVoidMethod ("Initialize",_ba,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 150;BA.debugLine="For i = 0 To numberOfPages - 1";
Debug.ShouldStop(2097152);
{
final int step14 = 1;
final int limit14 = RemoteObject.solve(new RemoteObject[] {_numberofpages,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14) ;_i = ((int)(0 + _i + step14))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 151;BA.debugLine="Dim iv As ImageView";
Debug.ShouldStop(4194304);
_iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("iv", _iv);
 BA.debugLineNum = 153;BA.debugLine="iv.Initialize(\"\")";
Debug.ShouldStop(16777216);
_iv.runVoidMethod ("Initialize",_ba,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 154;BA.debugLine="iv.Gravity=Gravity.FILL";
Debug.ShouldStop(33554432);
_iv.runMethod(true,"setGravity",diapositivas.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 155;BA.debugLine="iv.Bitmap = inactiveBitmap";
Debug.ShouldStop(67108864);
_iv.runMethod(false,"setBitmap",(_inactivebitmap.getObject()));
 BA.debugLineNum = 156;BA.debugLine="basePanel.AddView(iv, i * (imageSize + Gap), Top";
Debug.ShouldStop(134217728);
_basepanel.runVoidMethod ("AddView",(Object)((_iv.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),(RemoteObject.solve(new RemoteObject[] {_imagesize,_gap}, "+",1, 1))}, "*",0, 1)),(Object)(_top),(Object)(_imagesize),(Object)(_imagesize));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 159;BA.debugLine="Return basePanel";
Debug.ShouldStop(1073741824);
if (true) return _basepanel;
 BA.debugLineNum = 160;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject _ba,RemoteObject _sd,RemoteObject _panels,RemoteObject _rotate,RemoteObject _slidingduration) throws Exception{
try {
		Debug.PushSubsStack("Initialize (diapositivas) ","diapositivas",3,_ba,diapositivas.mostCurrent,15);
if (RapidSub.canDelegate("initialize")) { return pullup.wallet.diapositivas.remoteMe.runUserSub(false, "diapositivas","initialize", _ba, _sd, _panels, _rotate, _slidingduration);}
RemoteObject _a = null;
int _i = 0;
;
Debug.locals.put("sd", _sd);
Debug.locals.put("panels", _panels);
Debug.locals.put("Rotate", _rotate);
Debug.locals.put("SlidingDuration", _slidingduration);
 BA.debugLineNum = 15;BA.debugLine="Sub Initialize(sd As SlidingData, panels() As Pane";
Debug.ShouldStop(16384);
 BA.debugLineNum = 16;BA.debugLine="sd.duration = SlidingDuration";
Debug.ShouldStop(32768);
_sd.setField ("duration" /*RemoteObject*/ ,_slidingduration);
 BA.debugLineNum = 17;BA.debugLine="sd.rotate = Rotate";
Debug.ShouldStop(65536);
_sd.setField ("rotate" /*RemoteObject*/ ,_rotate);
 BA.debugLineNum = 18;BA.debugLine="sd.targetPanel = -1";
Debug.ShouldStop(131072);
_sd.setField ("targetPanel" /*RemoteObject*/ ,BA.numberCast(int.class, -(double) (0 + 1)));
 BA.debugLineNum = 19;BA.debugLine="sd.currentPanel = -1";
Debug.ShouldStop(262144);
_sd.setField ("currentPanel" /*RemoteObject*/ ,BA.numberCast(int.class, -(double) (0 + 1)));
 BA.debugLineNum = 20;BA.debugLine="sd.Panels = panels";
Debug.ShouldStop(524288);
_sd.setField ("Panels" /*RemoteObject*/ ,_panels);
 BA.debugLineNum = 21;BA.debugLine="Tutorial.tmrAnimacion.Initialize(\"tmrAnimation\",";
Debug.ShouldStop(1048576);
diapositivas.mostCurrent._tutorial._tmranimacion /*RemoteObject*/ .runVoidMethod ("Initialize",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba),(Object)(BA.ObjectToString("tmrAnimation")),(Object)(BA.numberCast(long.class, 2)));
 BA.debugLineNum = 22;BA.debugLine="Dim a(2) As Animation";
Debug.ShouldStop(2097152);
_a = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.AnimationWrapper", new int[] {2}, new Object[]{});Debug.locals.put("a", _a);
 BA.debugLineNum = 23;BA.debugLine="sd.slideAnimations = a";
Debug.ShouldStop(4194304);
_sd.setField ("slideAnimations" /*RemoteObject*/ ,_a);
 BA.debugLineNum = 24;BA.debugLine="Dim a(2) As Animation";
Debug.ShouldStop(8388608);
_a = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.AnimationWrapper", new int[] {2}, new Object[]{});Debug.locals.put("a", _a);
 BA.debugLineNum = 25;BA.debugLine="sd.slideAnimations = a";
Debug.ShouldStop(16777216);
_sd.setField ("slideAnimations" /*RemoteObject*/ ,_a);
 BA.debugLineNum = 27;BA.debugLine="For i = 0 To sd.Panels.Length - 1";
Debug.ShouldStop(67108864);
{
final int step11 = 1;
final int limit11 = RemoteObject.solve(new RemoteObject[] {_sd.getField(false,"Panels" /*RemoteObject*/ ).getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step11 > 0 && _i <= limit11) || (step11 < 0 && _i >= limit11) ;_i = ((int)(0 + _i + step11))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 28;BA.debugLine="sd.Panels(i).Left = 100%x 'Move the panels right";
Debug.ShouldStop(134217728);
_sd.getField(false,"Panels" /*RemoteObject*/ ).getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setLeft",diapositivas.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Dim PANEL_LEFT As Int : PANEL_LEFT = -2";
diapositivas._panel_left = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 3;BA.debugLine="Dim PANEL_LEFT As Int : PANEL_LEFT = -2";
diapositivas._panel_left = BA.numberCast(int.class, -(double) (0 + 2));
 //BA.debugLineNum = 4;BA.debugLine="Dim PANEL_RIGHT As Int : PANEL_RIGHT = -3";
diapositivas._panel_right = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 4;BA.debugLine="Dim PANEL_RIGHT As Int : PANEL_RIGHT = -3";
diapositivas._panel_right = BA.numberCast(int.class, -(double) (0 + 3));
 //BA.debugLineNum = 5;BA.debugLine="Dim leftPanel As Int = 0";
diapositivas._leftpanel = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 7;BA.debugLine="Type SlidingData (currentPanel As Int, _ 					  t";
;
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _setpageindicator(RemoteObject _ba,RemoteObject _pagepanel,RemoteObject _page,RemoteObject _activebitmap,RemoteObject _inactivebitmap) throws Exception{
try {
		Debug.PushSubsStack("SetPageIndicator (diapositivas) ","diapositivas",3,_ba,diapositivas.mostCurrent,162);
if (RapidSub.canDelegate("setpageindicator")) { return pullup.wallet.diapositivas.remoteMe.runUserSub(false, "diapositivas","setpageindicator", _ba, _pagepanel, _page, _activebitmap, _inactivebitmap);}
RemoteObject _v = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
RemoteObject _iv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
int _i = 0;
;
Debug.locals.put("pagePanel", _pagepanel);
Debug.locals.put("page", _page);
Debug.locals.put("activeBitmap", _activebitmap);
Debug.locals.put("inactiveBitmap", _inactivebitmap);
 BA.debugLineNum = 162;BA.debugLine="Sub SetPageIndicator(pagePanel As Panel, page As I";
Debug.ShouldStop(2);
 BA.debugLineNum = 163;BA.debugLine="Dim v As View";
Debug.ShouldStop(4);
_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.ConcreteViewWrapper");Debug.locals.put("v", _v);
 BA.debugLineNum = 164;BA.debugLine="Dim iv As ImageView";
Debug.ShouldStop(8);
_iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("iv", _iv);
 BA.debugLineNum = 166;BA.debugLine="For i = 0 To pagePanel.NumberOfViews - 1";
Debug.ShouldStop(32);
{
final int step3 = 1;
final int limit3 = RemoteObject.solve(new RemoteObject[] {_pagepanel.runMethod(true,"getNumberOfViews"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 167;BA.debugLine="v = pagePanel.GetView(i)";
Debug.ShouldStop(64);
_v = _pagepanel.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _i)));Debug.locals.put("v", _v);
 BA.debugLineNum = 168;BA.debugLine="If v Is ImageView Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.ImageView"))) { 
 BA.debugLineNum = 169;BA.debugLine="iv = v";
Debug.ShouldStop(256);
_iv = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ImageViewWrapper"), _v.getObject());
 BA.debugLineNum = 170;BA.debugLine="If i = page Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",RemoteObject.createImmutable(_i),BA.numberCast(double.class, _page))) { 
 BA.debugLineNum = 171;BA.debugLine="iv.Bitmap = activeBitmap";
Debug.ShouldStop(1024);
_iv.runMethod(false,"setBitmap",(_activebitmap.getObject()));
 }else {
 BA.debugLineNum = 173;BA.debugLine="iv.Bitmap = inactiveBitmap";
Debug.ShouldStop(4096);
_iv.runMethod(false,"setBitmap",(_inactivebitmap.getObject()));
 };
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 177;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}