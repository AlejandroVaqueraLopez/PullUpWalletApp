package pullup.wallet;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class suscripciones_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (suscripciones) ","suscripciones",18,suscripciones.mostCurrent.activityBA,suscripciones.mostCurrent,33);
if (RapidSub.canDelegate("activity_create")) { return pullup.wallet.suscripciones.remoteMe.runUserSub(false, "suscripciones","activity_create", _firsttime);}
RemoteObject _lblseccion = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _top = RemoteObject.createImmutable(0);
int _id = 0;
RemoteObject _datossuscripcion = RemoteObject.declareNull("pullup.wallet.suscripciones._suscripcion");
RemoteObject _lblmensaje = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 33;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 36;BA.debugLine="Activity.LoadLayout(\"LDeslizable\")";
Debug.ShouldStop(8);
suscripciones.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("LDeslizable")),suscripciones.mostCurrent.activityBA);
 BA.debugLineNum = 37;BA.debugLine="Activity.Color = Colors.ARGB(255, 233, 236, 239)";
Debug.ShouldStop(16);
suscripciones.mostCurrent._activity.runVoidMethod ("setColor",suscripciones.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 233)),(Object)(BA.numberCast(int.class, 236)),(Object)(BA.numberCast(int.class, 239))));
 BA.debugLineNum = 38;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
Debug.ShouldStop(32);
suscripciones._alturadispositivo = suscripciones.mostCurrent._main._alturadispositivo /*RemoteObject*/ ;
 BA.debugLineNum = 39;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
Debug.ShouldStop(64);
suscripciones._anchodispositivo = suscripciones.mostCurrent._main._anchodispositivo /*RemoteObject*/ ;
 BA.debugLineNum = 40;BA.debugLine="bmpTest.InitializeMutable(1dip, 1dip)";
Debug.ShouldStop(128);
suscripciones.mostCurrent._bmptest.runVoidMethod ("InitializeMutable",(Object)(suscripciones.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))),(Object)(suscripciones.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 41;BA.debugLine="cvsTest.Initialize2(bmpTest)";
Debug.ShouldStop(256);
suscripciones.mostCurrent._cvstest.runVoidMethod ("Initialize2",(Object)((suscripciones.mostCurrent._bmptest.getObject())));
 BA.debugLineNum = 44;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
Debug.ShouldStop(2048);
suscripciones.mostCurrent._pnlnavinferior.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {suscripciones._alturadispositivo,RemoteObject.createImmutable(0.08)}, "*",0, 0)));
 BA.debugLineNum = 45;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
Debug.ShouldStop(4096);
suscripciones.mostCurrent._pnlnavinferior.runMethod(true,"setWidth",suscripciones._anchodispositivo);
 BA.debugLineNum = 46;BA.debugLine="pnlNavInferior.Left = 0";
Debug.ShouldStop(8192);
suscripciones.mostCurrent._pnlnavinferior.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 47;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
Debug.ShouldStop(16384);
suscripciones.mostCurrent._pnlnavinferior.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {suscripciones._alturadispositivo,suscripciones.mostCurrent._pnlnavinferior.runMethod(true,"getHeight")}, "-",1, 1));
 BA.debugLineNum = 50;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
Debug.ShouldStop(131072);
suscripciones.mostCurrent._btnmenu.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {suscripciones._anchodispositivo,RemoteObject.createImmutable(0.15)}, "*",0, 0)));
 BA.debugLineNum = 51;BA.debugLine="btnMenu.Height = btnMenu.Width";
Debug.ShouldStop(262144);
suscripciones.mostCurrent._btnmenu.runMethod(true,"setHeight",suscripciones.mostCurrent._btnmenu.runMethod(true,"getWidth"));
 BA.debugLineNum = 52;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
Debug.ShouldStop(524288);
suscripciones.mostCurrent._btnmenu.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {suscripciones.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),suscripciones.mostCurrent._btnmenu.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 53;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
Debug.ShouldStop(1048576);
suscripciones.mostCurrent._btnmenu.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {suscripciones._anchodispositivo,suscripciones.mostCurrent._btnmenu.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 55;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
Debug.ShouldStop(4194304);
suscripciones.mostCurrent._lblcontornoboton.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {suscripciones._anchodispositivo,RemoteObject.createImmutable(0.17)}, "*",0, 0)));
 BA.debugLineNum = 56;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
Debug.ShouldStop(8388608);
suscripciones.mostCurrent._lblcontornoboton.runMethod(true,"setHeight",suscripciones.mostCurrent._lblcontornoboton.runMethod(true,"getWidth"));
 BA.debugLineNum = 57;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
Debug.ShouldStop(16777216);
suscripciones.mostCurrent._lblcontornoboton.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {suscripciones._anchodispositivo,suscripciones.mostCurrent._lblcontornoboton.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 58;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
Debug.ShouldStop(33554432);
suscripciones.mostCurrent._lblcontornoboton.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {suscripciones.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),suscripciones.mostCurrent._lblcontornoboton.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 62;BA.debugLine="svPantalla.Height = pnlNavInferior.Top";
Debug.ShouldStop(536870912);
suscripciones.mostCurrent._svpantalla.runMethod(true,"setHeight",suscripciones.mostCurrent._pnlnavinferior.runMethod(true,"getTop"));
 BA.debugLineNum = 63;BA.debugLine="svPantalla.Panel.LoadLayout(\"LPantallaDeslizable\"";
Debug.ShouldStop(1073741824);
suscripciones.mostCurrent._svpantalla.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("LPantallaDeslizable")),suscripciones.mostCurrent.activityBA);
 BA.debugLineNum = 64;BA.debugLine="svPantalla.Width = anchoDispositivo * 1.5";
Debug.ShouldStop(-2147483648);
suscripciones.mostCurrent._svpantalla.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {suscripciones._anchodispositivo,RemoteObject.createImmutable(1.5)}, "*",0, 0)));
 BA.debugLineNum = 65;BA.debugLine="pnlDeslizable.Width = svPantalla.Width";
Debug.ShouldStop(1);
suscripciones.mostCurrent._pnldeslizable.runMethod(true,"setWidth",suscripciones.mostCurrent._svpantalla.runMethod(true,"getWidth"));
 BA.debugLineNum = 71;BA.debugLine="Dim lblSeccion As Label";
Debug.ShouldStop(64);
_lblseccion = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblSeccion", _lblseccion);
 BA.debugLineNum = 72;BA.debugLine="lblSeccion.Initialize(\"lblSeccion\")";
Debug.ShouldStop(128);
_lblseccion.runVoidMethod ("Initialize",suscripciones.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("lblSeccion")));
 BA.debugLineNum = 73;BA.debugLine="lblSeccion.Text = \"Suscripciones\"";
Debug.ShouldStop(256);
_lblseccion.runMethod(true,"setText",BA.ObjectToCharSequence("Suscripciones"));
 BA.debugLineNum = 74;BA.debugLine="lblSeccion.TextSize = 20";
Debug.ShouldStop(512);
_lblseccion.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 75;BA.debugLine="lblSeccion.TextColor = Colors.Black";
Debug.ShouldStop(1024);
_lblseccion.runMethod(true,"setTextColor",suscripciones.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 76;BA.debugLine="lblSeccion.Height = 30dip";
Debug.ShouldStop(2048);
_lblseccion.runMethod(true,"setHeight",suscripciones.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 77;BA.debugLine="lblSeccion.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(4096);
_lblseccion.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {suscripciones._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 78;BA.debugLine="lblSeccion.Top = 30dip";
Debug.ShouldStop(8192);
_lblseccion.runMethod(true,"setTop",suscripciones.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 79;BA.debugLine="lblSeccion.Left = (anchoDispositivo - lblSeccion.";
Debug.ShouldStop(16384);
_lblseccion.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {suscripciones._anchodispositivo,_lblseccion.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 80;BA.debugLine="pnlDeslizable.AddView(lblSeccion, lblSeccion.Left";
Debug.ShouldStop(32768);
suscripciones.mostCurrent._pnldeslizable.runVoidMethod ("AddView",(Object)((_lblseccion.getObject())),(Object)(_lblseccion.runMethod(true,"getLeft")),(Object)(_lblseccion.runMethod(true,"getTop")),(Object)(_lblseccion.runMethod(true,"getWidth")),(Object)(_lblseccion.runMethod(true,"getHeight")));
 BA.debugLineNum = 85;BA.debugLine="Dim top As Int";
Debug.ShouldStop(1048576);
_top = RemoteObject.createImmutable(0);Debug.locals.put("top", _top);
 BA.debugLineNum = 86;BA.debugLine="top = lblSeccion.Top + lblSeccion.Height + 30dip";
Debug.ShouldStop(2097152);
_top = RemoteObject.solve(new RemoteObject[] {_lblseccion.runMethod(true,"getTop"),_lblseccion.runMethod(true,"getHeight"),suscripciones.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "++",2, 1);Debug.locals.put("top", _top);
 BA.debugLineNum = 89;BA.debugLine="sql = Starter.sql";
Debug.ShouldStop(16777216);
suscripciones._sql = suscripciones.mostCurrent._starter._sql /*RemoteObject*/ ;
 BA.debugLineNum = 90;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM suscripciones";
Debug.ShouldStop(33554432);
suscripciones.mostCurrent._cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), suscripciones._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM suscripciones ORDER BY rowid ASC"))));
 BA.debugLineNum = 91;BA.debugLine="nRegistros = cur.RowCount";
Debug.ShouldStop(67108864);
suscripciones._nregistros = suscripciones.mostCurrent._cur.runMethod(true,"getRowCount");
 BA.debugLineNum = 95;BA.debugLine="If nRegistros > 0 Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean(">",suscripciones._nregistros,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 97;BA.debugLine="Dim Relaciones(nRegistros, 2) As B4XView";
Debug.ShouldStop(1);
suscripciones.mostCurrent._relaciones = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.B4XViewWrapper", new int[] {suscripciones._nregistros.<Integer>get().intValue(),2}, new Object[]{});
 BA.debugLineNum = 98;BA.debugLine="Dim arrayPnlsOpciones(nRegistros) As B4XView";
Debug.ShouldStop(2);
suscripciones.mostCurrent._arraypnlsopciones = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.B4XViewWrapper", new int[] {suscripciones._nregistros.<Integer>get().intValue()}, new Object[]{});
 BA.debugLineNum = 100;BA.debugLine="For id = 0 To nRegistros - 1";
Debug.ShouldStop(8);
{
final int step41 = 1;
final int limit41 = RemoteObject.solve(new RemoteObject[] {suscripciones._nregistros,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_id = 0 ;
for (;(step41 > 0 && _id <= limit41) || (step41 < 0 && _id >= limit41) ;_id = ((int)(0 + _id + step41))  ) {
Debug.locals.put("id", _id);
 BA.debugLineNum = 101;BA.debugLine="cur.Position = id";
Debug.ShouldStop(16);
suscripciones.mostCurrent._cur.runMethod(true,"setPosition",BA.numberCast(int.class, _id));
 BA.debugLineNum = 103;BA.debugLine="Dim datosSuscripcion As Suscripcion";
Debug.ShouldStop(64);
_datossuscripcion = RemoteObject.createNew ("pullup.wallet.suscripciones._suscripcion");Debug.locals.put("datosSuscripcion", _datossuscripcion);
 BA.debugLineNum = 104;BA.debugLine="datosSuscripcion.rowid = cur.GetInt(\"id_suscrip";
Debug.ShouldStop(128);
_datossuscripcion.setField ("rowid" /*RemoteObject*/ ,suscripciones.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("id_suscripcion"))));
 BA.debugLineNum = 105;BA.debugLine="datosSuscripcion.nombre = cur.GetString(\"nombre";
Debug.ShouldStop(256);
_datossuscripcion.setField ("nombre" /*RemoteObject*/ ,suscripciones.mostCurrent._cur.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("nombre"))));
 BA.debugLineNum = 106;BA.debugLine="datosSuscripcion.monto = cur.GetInt(\"monto\")";
Debug.ShouldStop(512);
_datossuscripcion.setField ("monto" /*RemoteObject*/ ,suscripciones.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("monto"))));
 BA.debugLineNum = 107;BA.debugLine="datosSuscripcion.descripcion = cur.GetString(\"d";
Debug.ShouldStop(1024);
_datossuscripcion.setField ("descripcion" /*RemoteObject*/ ,suscripciones.mostCurrent._cur.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("descripcion"))));
 BA.debugLineNum = 108;BA.debugLine="datosSuscripcion.periodo = cur.GetString(\"perio";
Debug.ShouldStop(2048);
_datossuscripcion.setField ("periodo" /*RemoteObject*/ ,suscripciones.mostCurrent._cur.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("periodo"))));
 BA.debugLineNum = 109;BA.debugLine="datosSuscripcion.color = cur.GetInt(\"color\")";
Debug.ShouldStop(4096);
_datossuscripcion.setField ("color" /*RemoteObject*/ ,suscripciones.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("color"))));
 BA.debugLineNum = 111;BA.debugLine="creaObjetoLista(id, top, datosSuscripcion)";
Debug.ShouldStop(16384);
_creaobjetolista(BA.numberCast(int.class, _id),_top,_datossuscripcion);
 BA.debugLineNum = 113;BA.debugLine="top = top + alturaDispositivo * 0.12 + 60";
Debug.ShouldStop(65536);
_top = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_top,suscripciones._alturadispositivo,RemoteObject.createImmutable(0.12),RemoteObject.createImmutable(60)}, "+*+",2, 0));Debug.locals.put("top", _top);
 }
}Debug.locals.put("id", _id);
;
 }else {
 BA.debugLineNum = 117;BA.debugLine="Dim lblMensaje As Label";
Debug.ShouldStop(1048576);
_lblmensaje = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblMensaje", _lblmensaje);
 BA.debugLineNum = 118;BA.debugLine="lblMensaje.Initialize(\"lblMensaje\")";
Debug.ShouldStop(2097152);
_lblmensaje.runVoidMethod ("Initialize",suscripciones.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("lblMensaje")));
 BA.debugLineNum = 119;BA.debugLine="lblMensaje.Height = alturaDispositivo * 0.2";
Debug.ShouldStop(4194304);
_lblmensaje.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {suscripciones._alturadispositivo,RemoteObject.createImmutable(0.2)}, "*",0, 0)));
 BA.debugLineNum = 120;BA.debugLine="lblMensaje.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(8388608);
_lblmensaje.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {suscripciones._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 121;BA.debugLine="lblMensaje.Top = (alturaDispositivo - lblMensaje";
Debug.ShouldStop(16777216);
_lblmensaje.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {suscripciones._alturadispositivo,_lblmensaje.runMethod(true,"getHeight")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 122;BA.debugLine="lblMensaje.Left = (anchoDispositivo - lblMensaje";
Debug.ShouldStop(33554432);
_lblmensaje.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {suscripciones._anchodispositivo,_lblmensaje.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 123;BA.debugLine="lblMensaje.Text = cs.Initialize.Color(Colors.Bla";
Debug.ShouldStop(67108864);
_lblmensaje.runMethod(true,"setText",BA.ObjectToCharSequence(suscripciones.mostCurrent._cs.runMethod(false,"Initialize").runMethod(false,"Color",(Object)(suscripciones.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"))).runMethod(false,"Alignment",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.text.Layout.Alignment"),RemoteObject.createImmutable("ALIGN_CENTER")))).runMethod(false,"Typeface",(Object)(suscripciones.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"getMATERIALICONS"))).runMethod(false,"Size",(Object)(BA.numberCast(int.class, 50))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(suscripciones.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xe89c))),suscripciones.mostCurrent.__c.getField(true,"CRLF"))))).runMethod(false,"Typeface",(Object)(suscripciones.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT"))).runMethod(false,"Size",(Object)(BA.numberCast(int.class, 18))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Está muy vacío aquí adentro."),suscripciones.mostCurrent.__c.getField(true,"CRLF"))))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Agrega una suscripción desde el menú principal.")))).runMethod(false,"PopAll").getObject()));
 BA.debugLineNum = 124;BA.debugLine="Activity.AddView(lblMensaje, lblMensaje.Left, lb";
Debug.ShouldStop(134217728);
suscripciones.mostCurrent._activity.runVoidMethod ("AddView",(Object)((_lblmensaje.getObject())),(Object)(_lblmensaje.runMethod(true,"getLeft")),(Object)(_lblmensaje.runMethod(true,"getTop")),(Object)(_lblmensaje.runMethod(true,"getWidth")),(Object)(_lblmensaje.runMethod(true,"getHeight")));
 };
 BA.debugLineNum = 127;BA.debugLine="svPantalla.Panel.Height = top + 100";
Debug.ShouldStop(1073741824);
suscripciones.mostCurrent._svpantalla.runMethod(false,"getPanel").runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {_top,RemoteObject.createImmutable(100)}, "+",1, 1));
 BA.debugLineNum = 128;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("Activity_Pause (suscripciones) ","suscripciones",18,suscripciones.mostCurrent.activityBA,suscripciones.mostCurrent,134);
if (RapidSub.canDelegate("activity_pause")) { return pullup.wallet.suscripciones.remoteMe.runUserSub(false, "suscripciones","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 134;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(32);
 BA.debugLineNum = 136;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("Activity_Resume (suscripciones) ","suscripciones",18,suscripciones.mostCurrent.activityBA,suscripciones.mostCurrent,130);
if (RapidSub.canDelegate("activity_resume")) { return pullup.wallet.suscripciones.remoteMe.runUserSub(false, "suscripciones","activity_resume");}
 BA.debugLineNum = 130;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2);
 BA.debugLineNum = 132;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btneditar_click() throws Exception{
try {
		Debug.PushSubsStack("btnEditar_Click (suscripciones) ","suscripciones",18,suscripciones.mostCurrent.activityBA,suscripciones.mostCurrent,311);
if (RapidSub.canDelegate("btneditar_click")) { return pullup.wallet.suscripciones.remoteMe.runUserSub(false, "suscripciones","btneditar_click");}
RemoteObject _btneditar = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _pnlpadre = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _idregistro = RemoteObject.createImmutable(0);
RemoteObject _indice = RemoteObject.declareNull("pullup.wallet.suscripciones._indicesuscripcion");
 BA.debugLineNum = 311;BA.debugLine="Sub btnEditar_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 312;BA.debugLine="Dim btnEditar As Button";
Debug.ShouldStop(8388608);
_btneditar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("btnEditar", _btneditar);
 BA.debugLineNum = 313;BA.debugLine="Dim pnlPadre As Panel";
Debug.ShouldStop(16777216);
_pnlpadre = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnlPadre", _pnlpadre);
 BA.debugLineNum = 314;BA.debugLine="Dim idRegistro As Int";
Debug.ShouldStop(33554432);
_idregistro = RemoteObject.createImmutable(0);Debug.locals.put("idRegistro", _idregistro);
 BA.debugLineNum = 315;BA.debugLine="Dim indice As IndiceSuscripcion";
Debug.ShouldStop(67108864);
_indice = RemoteObject.createNew ("pullup.wallet.suscripciones._indicesuscripcion");Debug.locals.put("indice", _indice);
 BA.debugLineNum = 318;BA.debugLine="btnEditar = Sender";
Debug.ShouldStop(536870912);
_btneditar = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), suscripciones.mostCurrent.__c.runMethod(false,"Sender",suscripciones.mostCurrent.activityBA));
 BA.debugLineNum = 320;BA.debugLine="pnlPadre = btnEditar.Parent";
Debug.ShouldStop(-2147483648);
_pnlpadre = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), _btneditar.runMethod(false,"getParent"));
 BA.debugLineNum = 322;BA.debugLine="indice = pnlPadre.Tag";
Debug.ShouldStop(2);
_indice = (_pnlpadre.runMethod(false,"getTag"));Debug.locals.put("indice", _indice);
 BA.debugLineNum = 324;BA.debugLine="idRegistro = indice.rowid";
Debug.ShouldStop(8);
_idregistro = _indice.getField(true,"rowid" /*RemoteObject*/ );Debug.locals.put("idRegistro", _idregistro);
 BA.debugLineNum = 325;BA.debugLine="CallSubDelayed2(editarSuscripcion, \"consultaAEdit";
Debug.ShouldStop(16);
suscripciones.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",suscripciones.processBA,(Object)((suscripciones.mostCurrent._editarsuscripcion.getObject())),(Object)(BA.ObjectToString("consultaAEditar")),(Object)((_idregistro)));
 BA.debugLineNum = 326;BA.debugLine="Activity.Finish";
Debug.ShouldStop(32);
suscripciones.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 327;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btneliminar_click() throws Exception{
try {
		Debug.PushSubsStack("btnEliminar_Click (suscripciones) ","suscripciones",18,suscripciones.mostCurrent.activityBA,suscripciones.mostCurrent,329);
if (RapidSub.canDelegate("btneliminar_click")) { return pullup.wallet.suscripciones.remoteMe.runUserSub(false, "suscripciones","btneliminar_click");}
RemoteObject _btneliminar = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _pnlpadre = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _idregistro = RemoteObject.createImmutable(0);
RemoteObject _indice = RemoteObject.declareNull("pullup.wallet.suscripciones._indicesuscripcion");
RemoteObject _resultado = RemoteObject.createImmutable(0);
 BA.debugLineNum = 329;BA.debugLine="Sub btnEliminar_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 330;BA.debugLine="Dim btnEliminar As Button";
Debug.ShouldStop(512);
_btneliminar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("btnEliminar", _btneliminar);
 BA.debugLineNum = 331;BA.debugLine="Dim pnlPadre As Panel";
Debug.ShouldStop(1024);
_pnlpadre = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnlPadre", _pnlpadre);
 BA.debugLineNum = 332;BA.debugLine="Dim idRegistro As Int";
Debug.ShouldStop(2048);
_idregistro = RemoteObject.createImmutable(0);Debug.locals.put("idRegistro", _idregistro);
 BA.debugLineNum = 333;BA.debugLine="Dim indice As IndiceSuscripcion";
Debug.ShouldStop(4096);
_indice = RemoteObject.createNew ("pullup.wallet.suscripciones._indicesuscripcion");Debug.locals.put("indice", _indice);
 BA.debugLineNum = 336;BA.debugLine="btnEliminar = Sender";
Debug.ShouldStop(32768);
_btneliminar = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), suscripciones.mostCurrent.__c.runMethod(false,"Sender",suscripciones.mostCurrent.activityBA));
 BA.debugLineNum = 338;BA.debugLine="pnlPadre = btnEliminar.Parent";
Debug.ShouldStop(131072);
_pnlpadre = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), _btneliminar.runMethod(false,"getParent"));
 BA.debugLineNum = 340;BA.debugLine="indice = pnlPadre.Tag";
Debug.ShouldStop(524288);
_indice = (_pnlpadre.runMethod(false,"getTag"));Debug.locals.put("indice", _indice);
 BA.debugLineNum = 342;BA.debugLine="idRegistro = indice.rowid";
Debug.ShouldStop(2097152);
_idregistro = _indice.getField(true,"rowid" /*RemoteObject*/ );Debug.locals.put("idRegistro", _idregistro);
 BA.debugLineNum = 345;BA.debugLine="Dim resultado As Int";
Debug.ShouldStop(16777216);
_resultado = RemoteObject.createImmutable(0);Debug.locals.put("resultado", _resultado);
 BA.debugLineNum = 346;BA.debugLine="resultado = Msgbox2(\"¿Estás seguro?\", \"Eliminar s";
Debug.ShouldStop(33554432);
_resultado = suscripciones.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("¿Estás seguro?")),(Object)(BA.ObjectToCharSequence("Eliminar suscripción")),(Object)(BA.ObjectToString("Sí")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("No")),(Object)((suscripciones.mostCurrent.__c.getField(false,"Null"))),suscripciones.mostCurrent.activityBA);Debug.locals.put("resultado", _resultado);
 BA.debugLineNum = 347;BA.debugLine="If (resultado = DialogResponse.POSITIVE) Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",_resultado,BA.numberCast(double.class, suscripciones.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE"))))) { 
 BA.debugLineNum = 349;BA.debugLine="sql.ExecNonQuery(\"DELETE FROM suscripciones WHER";
Debug.ShouldStop(268435456);
suscripciones._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("DELETE FROM suscripciones WHERE id_suscripcion = '"),_idregistro,RemoteObject.createImmutable("'"))));
 BA.debugLineNum = 352;BA.debugLine="Activity.Finish";
Debug.ShouldStop(-2147483648);
suscripciones.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 353;BA.debugLine="StartActivity(Me)";
Debug.ShouldStop(1);
suscripciones.mostCurrent.__c.runVoidMethod ("StartActivity",suscripciones.processBA,(Object)(suscripciones.getObject()));
 };
 BA.debugLineNum = 355;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnmenu_click() throws Exception{
try {
		Debug.PushSubsStack("btnMenu_Click (suscripciones) ","suscripciones",18,suscripciones.mostCurrent.activityBA,suscripciones.mostCurrent,138);
if (RapidSub.canDelegate("btnmenu_click")) { return pullup.wallet.suscripciones.remoteMe.runUserSub(false, "suscripciones","btnmenu_click");}
 BA.debugLineNum = 138;BA.debugLine="Private Sub btnMenu_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 139;BA.debugLine="CallSubDelayed(Main, \"actualizarDatos\")";
Debug.ShouldStop(1024);
suscripciones.mostCurrent.__c.runVoidMethod ("CallSubDelayed",suscripciones.processBA,(Object)((suscripciones.mostCurrent._main.getObject())),(Object)(RemoteObject.createImmutable("actualizarDatos")));
 BA.debugLineNum = 140;BA.debugLine="Activity.Finish";
Debug.ShouldStop(2048);
suscripciones.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 141;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _creaobjetolista(RemoteObject _indice,RemoteObject _top,RemoteObject _datos) throws Exception{
try {
		Debug.PushSubsStack("creaObjetoLista (suscripciones) ","suscripciones",18,suscripciones.mostCurrent.activityBA,suscripciones.mostCurrent,144);
if (RapidSub.canDelegate("creaobjetolista")) { return pullup.wallet.suscripciones.remoteMe.runUserSub(false, "suscripciones","creaobjetolista", _indice, _top, _datos);}
RemoteObject _pnlsuscripcion = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _pnlopciones = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _lblnombre = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lblmonto = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lbldescripcion = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lblperiodo = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lblopciones = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _btneditar = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _btneliminar = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _textoperiodo = RemoteObject.createImmutable("");
RemoteObject _referencia = RemoteObject.declareNull("pullup.wallet.suscripciones._indicesuscripcion");
RemoteObject _referencia2 = RemoteObject.declareNull("pullup.wallet.suscripciones._indicesuscripcion");
Debug.locals.put("indice", _indice);
Debug.locals.put("top", _top);
Debug.locals.put("datos", _datos);
 BA.debugLineNum = 144;BA.debugLine="Sub creaObjetoLista(indice As Int, top As Int, dat";
Debug.ShouldStop(32768);
 BA.debugLineNum = 145;BA.debugLine="Dim pnlSuscripcion As Panel";
Debug.ShouldStop(65536);
_pnlsuscripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnlSuscripcion", _pnlsuscripcion);
 BA.debugLineNum = 146;BA.debugLine="Dim pnlOpciones As Panel";
Debug.ShouldStop(131072);
_pnlopciones = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnlOpciones", _pnlopciones);
 BA.debugLineNum = 147;BA.debugLine="Dim lblNombre As Label";
Debug.ShouldStop(262144);
_lblnombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblNombre", _lblnombre);
 BA.debugLineNum = 148;BA.debugLine="Dim lblMonto As Label";
Debug.ShouldStop(524288);
_lblmonto = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblMonto", _lblmonto);
 BA.debugLineNum = 149;BA.debugLine="Dim lblDescripcion As Label";
Debug.ShouldStop(1048576);
_lbldescripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblDescripcion", _lbldescripcion);
 BA.debugLineNum = 150;BA.debugLine="Dim lblPeriodo As Label";
Debug.ShouldStop(2097152);
_lblperiodo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblPeriodo", _lblperiodo);
 BA.debugLineNum = 151;BA.debugLine="Dim lblOpciones As Label";
Debug.ShouldStop(4194304);
_lblopciones = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblOpciones", _lblopciones);
 BA.debugLineNum = 152;BA.debugLine="Dim btnEditar As Button";
Debug.ShouldStop(8388608);
_btneditar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("btnEditar", _btneditar);
 BA.debugLineNum = 153;BA.debugLine="Dim btnEliminar As Button";
Debug.ShouldStop(16777216);
_btneliminar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("btnEliminar", _btneliminar);
 BA.debugLineNum = 156;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(134217728);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 157;BA.debugLine="cd.Initialize(datos.color, 20)";
Debug.ShouldStop(268435456);
_cd.runVoidMethod ("Initialize",(Object)(_datos.getField(true,"color" /*RemoteObject*/ )),(Object)(BA.numberCast(int.class, 20)));
 BA.debugLineNum = 160;BA.debugLine="pnlSuscripcion.Initialize(\"pnlSuscripcion\")";
Debug.ShouldStop(-2147483648);
_pnlsuscripcion.runVoidMethod ("Initialize",suscripciones.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("pnlSuscripcion")));
 BA.debugLineNum = 161;BA.debugLine="pnlSuscripcion.Top = top";
Debug.ShouldStop(1);
_pnlsuscripcion.runMethod(true,"setTop",_top);
 BA.debugLineNum = 162;BA.debugLine="pnlSuscripcion.Background = cd";
Debug.ShouldStop(2);
_pnlsuscripcion.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 163;BA.debugLine="pnlSuscripcion.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(4);
_pnlsuscripcion.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {suscripciones._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 164;BA.debugLine="pnlSuscripcion.Height = alturaDispositivo * 0.14";
Debug.ShouldStop(8);
_pnlsuscripcion.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {suscripciones._alturadispositivo,RemoteObject.createImmutable(0.14)}, "*",0, 0)));
 BA.debugLineNum = 165;BA.debugLine="pnlSuscripcion.Left = (anchoDispositivo - pnlSusc";
Debug.ShouldStop(16);
_pnlsuscripcion.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {suscripciones._anchodispositivo,_pnlsuscripcion.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 167;BA.debugLine="lblNombre.Initialize(\"lblNombre\")";
Debug.ShouldStop(64);
_lblnombre.runVoidMethod ("Initialize",suscripciones.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("lblNombre")));
 BA.debugLineNum = 168;BA.debugLine="lblNombre.TextColor = Colors.White";
Debug.ShouldStop(128);
_lblnombre.runMethod(true,"setTextColor",suscripciones.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 169;BA.debugLine="lblNombre.Text = datos.nombre.ToUpperCase.CharAt(";
Debug.ShouldStop(256);
_lblnombre.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_datos.getField(true,"nombre" /*RemoteObject*/ ).runMethod(true,"toUpperCase").runMethod(true,"charAt",(Object)(BA.numberCast(int.class, 0))),_datos.getField(true,"nombre" /*RemoteObject*/ ).runMethod(true,"substring",(Object)(BA.numberCast(int.class, 1))).runMethod(true,"toLowerCase"))));
 BA.debugLineNum = 170;BA.debugLine="lblNombre.TextSize = 19";
Debug.ShouldStop(512);
_lblnombre.runMethod(true,"setTextSize",BA.numberCast(float.class, 19));
 BA.debugLineNum = 171;BA.debugLine="lblNombre.Height = pnlSuscripcion.Height * 0.3";
Debug.ShouldStop(1024);
_lblnombre.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlsuscripcion.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.3)}, "*",0, 0)));
 BA.debugLineNum = 172;BA.debugLine="lblNombre.Width = pnlSuscripcion.Width * 0.9";
Debug.ShouldStop(2048);
_lblnombre.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlsuscripcion.runMethod(true,"getWidth"),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 173;BA.debugLine="lblNombre.Top = 0";
Debug.ShouldStop(4096);
_lblnombre.runMethod(true,"setTop",BA.numberCast(int.class, 0));
 BA.debugLineNum = 174;BA.debugLine="lblNombre.Left = pnlSuscripcion.Width * 0.05";
Debug.ShouldStop(8192);
_lblnombre.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlsuscripcion.runMethod(true,"getWidth"),RemoteObject.createImmutable(0.05)}, "*",0, 0)));
 BA.debugLineNum = 175;BA.debugLine="lblNombre.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(16384);
_lblnombre.runMethod(true,"setGravity",suscripciones.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 176;BA.debugLine="pnlSuscripcion.AddView(lblNombre, lblNombre.Left,";
Debug.ShouldStop(32768);
_pnlsuscripcion.runVoidMethod ("AddView",(Object)((_lblnombre.getObject())),(Object)(_lblnombre.runMethod(true,"getLeft")),(Object)(_lblnombre.runMethod(true,"getTop")),(Object)(_lblnombre.runMethod(true,"getWidth")),(Object)(_lblnombre.runMethod(true,"getHeight")));
 BA.debugLineNum = 178;BA.debugLine="lblDescripcion.Initialize(\"lblDescripcion\")";
Debug.ShouldStop(131072);
_lbldescripcion.runVoidMethod ("Initialize",suscripciones.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("lblDescripcion")));
 BA.debugLineNum = 179;BA.debugLine="lblDescripcion.Text = datos.descripcion.ToUpperCa";
Debug.ShouldStop(262144);
_lbldescripcion.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_datos.getField(true,"descripcion" /*RemoteObject*/ ).runMethod(true,"toUpperCase").runMethod(true,"charAt",(Object)(BA.numberCast(int.class, 0))),_datos.getField(true,"descripcion" /*RemoteObject*/ ).runMethod(true,"substring",(Object)(BA.numberCast(int.class, 1))).runMethod(true,"toLowerCase"))));
 BA.debugLineNum = 180;BA.debugLine="lblDescripcion.TextColor = Colors.White";
Debug.ShouldStop(524288);
_lbldescripcion.runMethod(true,"setTextColor",suscripciones.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 181;BA.debugLine="lblDescripcion.Height = pnlSuscripcion.Height * 0";
Debug.ShouldStop(1048576);
_lbldescripcion.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlsuscripcion.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.3)}, "*",0, 0)));
 BA.debugLineNum = 182;BA.debugLine="lblDescripcion.Width = pnlSuscripcion.Width * 0.9";
Debug.ShouldStop(2097152);
_lbldescripcion.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlsuscripcion.runMethod(true,"getWidth"),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 183;BA.debugLine="lblDescripcion.Top = lblNombre.Height";
Debug.ShouldStop(4194304);
_lbldescripcion.runMethod(true,"setTop",_lblnombre.runMethod(true,"getHeight"));
 BA.debugLineNum = 184;BA.debugLine="lblDescripcion.Left = lblNombre.Left";
Debug.ShouldStop(8388608);
_lbldescripcion.runMethod(true,"setLeft",_lblnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 185;BA.debugLine="lblDescripcion.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(16777216);
_lbldescripcion.runMethod(true,"setGravity",suscripciones.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 186;BA.debugLine="pnlSuscripcion.AddView(lblDescripcion, lblDescrip";
Debug.ShouldStop(33554432);
_pnlsuscripcion.runVoidMethod ("AddView",(Object)((_lbldescripcion.getObject())),(Object)(_lbldescripcion.runMethod(true,"getLeft")),(Object)(_lbldescripcion.runMethod(true,"getTop")),(Object)(_lbldescripcion.runMethod(true,"getWidth")),(Object)(_lbldescripcion.runMethod(true,"getHeight")));
 BA.debugLineNum = 188;BA.debugLine="lblPeriodo.Initialize(\"lblPeriodo\")";
Debug.ShouldStop(134217728);
_lblperiodo.runVoidMethod ("Initialize",suscripciones.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("lblPeriodo")));
 BA.debugLineNum = 190;BA.debugLine="Dim textoPeriodo As String";
Debug.ShouldStop(536870912);
_textoperiodo = RemoteObject.createImmutable("");Debug.locals.put("textoPeriodo", _textoperiodo);
 BA.debugLineNum = 191;BA.debugLine="If (datos.periodo = 7) Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",_datos.getField(true,"periodo" /*RemoteObject*/ ),BA.NumberToString(7)))) { 
 BA.debugLineNum = 192;BA.debugLine="textoPeriodo = \"1 semana\"";
Debug.ShouldStop(-2147483648);
_textoperiodo = BA.ObjectToString("1 semana");Debug.locals.put("textoPeriodo", _textoperiodo);
 }else 
{ BA.debugLineNum = 193;BA.debugLine="Else If (datos.periodo = 14) Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",_datos.getField(true,"periodo" /*RemoteObject*/ ),BA.NumberToString(14)))) { 
 BA.debugLineNum = 194;BA.debugLine="textoPeriodo = \"2 semanas\"";
Debug.ShouldStop(2);
_textoperiodo = BA.ObjectToString("2 semanas");Debug.locals.put("textoPeriodo", _textoperiodo);
 }else 
{ BA.debugLineNum = 195;BA.debugLine="Else If (datos.periodo = 21) Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",_datos.getField(true,"periodo" /*RemoteObject*/ ),BA.NumberToString(21)))) { 
 BA.debugLineNum = 196;BA.debugLine="textoPeriodo = \"3 semanas\"";
Debug.ShouldStop(8);
_textoperiodo = BA.ObjectToString("3 semanas");Debug.locals.put("textoPeriodo", _textoperiodo);
 }else 
{ BA.debugLineNum = 197;BA.debugLine="Else If (datos.periodo = 30) Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",_datos.getField(true,"periodo" /*RemoteObject*/ ),BA.NumberToString(30)))) { 
 BA.debugLineNum = 198;BA.debugLine="textoPeriodo = \"1 mes\"";
Debug.ShouldStop(32);
_textoperiodo = BA.ObjectToString("1 mes");Debug.locals.put("textoPeriodo", _textoperiodo);
 }else 
{ BA.debugLineNum = 199;BA.debugLine="Else If (datos.periodo = 365) Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",_datos.getField(true,"periodo" /*RemoteObject*/ ),BA.NumberToString(365)))) { 
 BA.debugLineNum = 200;BA.debugLine="textoPeriodo = \"1 año\"";
Debug.ShouldStop(128);
_textoperiodo = BA.ObjectToString("1 año");Debug.locals.put("textoPeriodo", _textoperiodo);
 }}}}}
;
 BA.debugLineNum = 203;BA.debugLine="lblPeriodo.Text = textoPeriodo";
Debug.ShouldStop(1024);
_lblperiodo.runMethod(true,"setText",BA.ObjectToCharSequence(_textoperiodo));
 BA.debugLineNum = 204;BA.debugLine="lblPeriodo.TextSize = 16";
Debug.ShouldStop(2048);
_lblperiodo.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 205;BA.debugLine="lblPeriodo.TextColor = Colors.DarkGray";
Debug.ShouldStop(4096);
_lblperiodo.runMethod(true,"setTextColor",suscripciones.mostCurrent.__c.getField(false,"Colors").getField(true,"DarkGray"));
 BA.debugLineNum = 206;BA.debugLine="lblPeriodo.Height = pnlSuscripcion.Height * 0.4";
Debug.ShouldStop(8192);
_lblperiodo.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlsuscripcion.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.4)}, "*",0, 0)));
 BA.debugLineNum = 207;BA.debugLine="lblPeriodo.Width = pnlSuscripcion.Width * 0.9";
Debug.ShouldStop(16384);
_lblperiodo.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlsuscripcion.runMethod(true,"getWidth"),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 208;BA.debugLine="lblPeriodo.Top = lblDescripcion.Top + lblDescripc";
Debug.ShouldStop(32768);
_lblperiodo.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {_lbldescripcion.runMethod(true,"getTop"),_lbldescripcion.runMethod(true,"getHeight")}, "+",1, 1));
 BA.debugLineNum = 209;BA.debugLine="lblPeriodo.Left = lblNombre.Left";
Debug.ShouldStop(65536);
_lblperiodo.runMethod(true,"setLeft",_lblnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 210;BA.debugLine="lblPeriodo.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(131072);
_lblperiodo.runMethod(true,"setGravity",suscripciones.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 211;BA.debugLine="pnlSuscripcion.AddView(lblPeriodo, lblPeriodo.Lef";
Debug.ShouldStop(262144);
_pnlsuscripcion.runVoidMethod ("AddView",(Object)((_lblperiodo.getObject())),(Object)(_lblperiodo.runMethod(true,"getLeft")),(Object)(_lblperiodo.runMethod(true,"getTop")),(Object)(_lblperiodo.runMethod(true,"getWidth")),(Object)(_lblperiodo.runMethod(true,"getHeight")));
 BA.debugLineNum = 213;BA.debugLine="lblMonto.Initialize(\"lblMonto\")";
Debug.ShouldStop(1048576);
_lblmonto.runVoidMethod ("Initialize",suscripciones.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("lblMonto")));
 BA.debugLineNum = 214;BA.debugLine="lblMonto.TextSize = 16";
Debug.ShouldStop(2097152);
_lblmonto.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 215;BA.debugLine="lblMonto.TextColor = Colors.White";
Debug.ShouldStop(4194304);
_lblmonto.runMethod(true,"setTextColor",suscripciones.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 216;BA.debugLine="lblMonto.Width = cvsTest.MeasureStringWidth((\"$\"";
Debug.ShouldStop(8388608);
_lblmonto.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {suscripciones.mostCurrent._cvstest.runMethod(true,"MeasureStringWidth",(Object)((RemoteObject.concat(RemoteObject.createImmutable("$"),_datos.getField(true,"monto" /*RemoteObject*/ )))),(Object)(suscripciones.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT")),(Object)(_lblmonto.runMethod(true,"getTextSize"))),RemoteObject.createImmutable(2)}, "+",1, 0)));
 BA.debugLineNum = 217;BA.debugLine="lblMonto.Height = pnlSuscripcion.Height * 0.4";
Debug.ShouldStop(16777216);
_lblmonto.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlsuscripcion.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.4)}, "*",0, 0)));
 BA.debugLineNum = 218;BA.debugLine="lblMonto.Text = \"$\" & datos.monto";
Debug.ShouldStop(33554432);
_lblmonto.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("$"),_datos.getField(true,"monto" /*RemoteObject*/ ))));
 BA.debugLineNum = 219;BA.debugLine="lblMonto.Top = lblPeriodo.Top";
Debug.ShouldStop(67108864);
_lblmonto.runMethod(true,"setTop",_lblperiodo.runMethod(true,"getTop"));
 BA.debugLineNum = 220;BA.debugLine="lblMonto.Left = pnlSuscripcion.Width - lblMonto.W";
Debug.ShouldStop(134217728);
_lblmonto.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {_pnlsuscripcion.runMethod(true,"getWidth"),_lblmonto.runMethod(true,"getWidth"),_lblnombre.runMethod(true,"getLeft")}, "--",2, 1));
 BA.debugLineNum = 221;BA.debugLine="lblMonto.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(268435456);
_lblmonto.runMethod(true,"setGravity",suscripciones.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 222;BA.debugLine="pnlSuscripcion.AddView(lblMonto, lblMonto.Left, l";
Debug.ShouldStop(536870912);
_pnlsuscripcion.runVoidMethod ("AddView",(Object)((_lblmonto.getObject())),(Object)(_lblmonto.runMethod(true,"getLeft")),(Object)(_lblmonto.runMethod(true,"getTop")),(Object)(_lblmonto.runMethod(true,"getWidth")),(Object)(_lblmonto.runMethod(true,"getHeight")));
 BA.debugLineNum = 224;BA.debugLine="lblOpciones.Initialize(\"lblOpciones\")";
Debug.ShouldStop(-2147483648);
_lblopciones.runVoidMethod ("Initialize",suscripciones.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("lblOpciones")));
 BA.debugLineNum = 225;BA.debugLine="lblOpciones.Typeface = Typeface.FONTAWESOME";
Debug.ShouldStop(1);
_lblopciones.runMethod(false,"setTypeface",suscripciones.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"getFONTAWESOME"));
 BA.debugLineNum = 226;BA.debugLine="lblOpciones.Text = Chr(0xF142)";
Debug.ShouldStop(2);
_lblopciones.runMethod(true,"setText",BA.ObjectToCharSequence(suscripciones.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf142)))));
 BA.debugLineNum = 227;BA.debugLine="lblOpciones.TextSize = 18";
Debug.ShouldStop(4);
_lblopciones.runMethod(true,"setTextSize",BA.numberCast(float.class, 18));
 BA.debugLineNum = 228;BA.debugLine="lblOpciones.TextColor = Colors.White";
Debug.ShouldStop(8);
_lblopciones.runMethod(true,"setTextColor",suscripciones.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 229;BA.debugLine="lblOpciones.Height = lblNombre.Height";
Debug.ShouldStop(16);
_lblopciones.runMethod(true,"setHeight",_lblnombre.runMethod(true,"getHeight"));
 BA.debugLineNum = 230;BA.debugLine="lblOpciones.Width = 8dip";
Debug.ShouldStop(32);
_lblopciones.runMethod(true,"setWidth",suscripciones.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 8))));
 BA.debugLineNum = 231;BA.debugLine="lblOpciones.Left = lblMonto.Left + lblMonto.Width";
Debug.ShouldStop(64);
_lblopciones.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {_lblmonto.runMethod(true,"getLeft"),_lblmonto.runMethod(true,"getWidth"),_lblopciones.runMethod(true,"getWidth")}, "+-",2, 1));
 BA.debugLineNum = 232;BA.debugLine="lblOpciones.Top = 0";
Debug.ShouldStop(128);
_lblopciones.runMethod(true,"setTop",BA.numberCast(int.class, 0));
 BA.debugLineNum = 233;BA.debugLine="lblOpciones.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(256);
_lblopciones.runMethod(true,"setGravity",suscripciones.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 234;BA.debugLine="pnlSuscripcion.AddView(lblOpciones, lblOpciones.L";
Debug.ShouldStop(512);
_pnlsuscripcion.runVoidMethod ("AddView",(Object)((_lblopciones.getObject())),(Object)(_lblopciones.runMethod(true,"getLeft")),(Object)(_lblopciones.runMethod(true,"getTop")),(Object)(_lblopciones.runMethod(true,"getWidth")),(Object)(_lblopciones.runMethod(true,"getHeight")));
 BA.debugLineNum = 236;BA.debugLine="pnlOpciones.Initialize(\"pnlOpciones\")";
Debug.ShouldStop(2048);
_pnlopciones.runVoidMethod ("Initialize",suscripciones.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("pnlOpciones")));
 BA.debugLineNum = 237;BA.debugLine="cd.Initialize(Colors.Black, 20)";
Debug.ShouldStop(4096);
_cd.runVoidMethod ("Initialize",(Object)(suscripciones.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.numberCast(int.class, 20)));
 BA.debugLineNum = 238;BA.debugLine="pnlOpciones.Background = cd";
Debug.ShouldStop(8192);
_pnlopciones.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 239;BA.debugLine="pnlOpciones.Height = pnlSuscripcion.Height * 0.8";
Debug.ShouldStop(16384);
_pnlopciones.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlsuscripcion.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.8)}, "*",0, 0)));
 BA.debugLineNum = 240;BA.debugLine="pnlOpciones.Width = pnlSuscripcion.Height";
Debug.ShouldStop(32768);
_pnlopciones.runMethod(true,"setWidth",_pnlsuscripcion.runMethod(true,"getHeight"));
 BA.debugLineNum = 241;BA.debugLine="pnlOpciones.Top = lblOpciones.Top";
Debug.ShouldStop(65536);
_pnlopciones.runMethod(true,"setTop",_lblopciones.runMethod(true,"getTop"));
 BA.debugLineNum = 242;BA.debugLine="pnlOpciones.Left = lblOpciones.Left - lblOpciones";
Debug.ShouldStop(131072);
_pnlopciones.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {_lblopciones.runMethod(true,"getLeft"),_lblopciones.runMethod(true,"getWidth"),RemoteObject.createImmutable(2),_pnlopciones.runMethod(true,"getWidth")}, "-*-",2, 1));
 BA.debugLineNum = 243;BA.debugLine="pnlOpciones.Visible = False";
Debug.ShouldStop(262144);
_pnlopciones.runMethod(true,"setVisible",suscripciones.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 244;BA.debugLine="pnlSuscripcion.AddView(pnlOpciones, pnlOpciones.L";
Debug.ShouldStop(524288);
_pnlsuscripcion.runVoidMethod ("AddView",(Object)((_pnlopciones.getObject())),(Object)(_pnlopciones.runMethod(true,"getLeft")),(Object)(_pnlopciones.runMethod(true,"getTop")),(Object)(_pnlopciones.runMethod(true,"getWidth")),(Object)(_pnlopciones.runMethod(true,"getHeight")));
 BA.debugLineNum = 246;BA.debugLine="btnEditar.Initialize(\"btnEditar\")";
Debug.ShouldStop(2097152);
_btneditar.runVoidMethod ("Initialize",suscripciones.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("btnEditar")));
 BA.debugLineNum = 247;BA.debugLine="btnEditar.Color = Colors.Transparent";
Debug.ShouldStop(4194304);
_btneditar.runVoidMethod ("setColor",suscripciones.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 248;BA.debugLine="btnEditar.Text = \"Editar\"";
Debug.ShouldStop(8388608);
_btneditar.runMethod(true,"setText",BA.ObjectToCharSequence("Editar"));
 BA.debugLineNum = 249;BA.debugLine="btnEditar.TextColor = Colors.White";
Debug.ShouldStop(16777216);
_btneditar.runMethod(true,"setTextColor",suscripciones.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 250;BA.debugLine="btnEditar.TextSize = 14";
Debug.ShouldStop(33554432);
_btneditar.runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 251;BA.debugLine="btnEditar.Height = pnlOpciones.Height * 0.4";
Debug.ShouldStop(67108864);
_btneditar.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlopciones.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.4)}, "*",0, 0)));
 BA.debugLineNum = 252;BA.debugLine="btnEditar.Width = pnlOpciones.Height * 0.8";
Debug.ShouldStop(134217728);
_btneditar.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlopciones.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.8)}, "*",0, 0)));
 BA.debugLineNum = 253;BA.debugLine="btnEditar.Top = (pnlOpciones.Height * 0.2) / 3";
Debug.ShouldStop(268435456);
_btneditar.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_pnlopciones.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.2)}, "*",0, 0)),RemoteObject.createImmutable(3)}, "/",0, 0)));
 BA.debugLineNum = 254;BA.debugLine="btnEditar.Left = (pnlOpciones.Width - btnEditar.W";
Debug.ShouldStop(536870912);
_btneditar.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_pnlopciones.runMethod(true,"getWidth"),_btneditar.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 255;BA.debugLine="pnlOpciones.AddView(btnEditar, btnEditar.Left, bt";
Debug.ShouldStop(1073741824);
_pnlopciones.runVoidMethod ("AddView",(Object)((_btneditar.getObject())),(Object)(_btneditar.runMethod(true,"getLeft")),(Object)(_btneditar.runMethod(true,"getTop")),(Object)(_btneditar.runMethod(true,"getWidth")),(Object)(_btneditar.runMethod(true,"getHeight")));
 BA.debugLineNum = 257;BA.debugLine="btnEliminar.Initialize(\"btnEliminar\")";
Debug.ShouldStop(1);
_btneliminar.runVoidMethod ("Initialize",suscripciones.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("btnEliminar")));
 BA.debugLineNum = 258;BA.debugLine="btnEliminar.Color = Colors.Transparent";
Debug.ShouldStop(2);
_btneliminar.runVoidMethod ("setColor",suscripciones.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 259;BA.debugLine="btnEliminar.Text = \"Eliminar\"";
Debug.ShouldStop(4);
_btneliminar.runMethod(true,"setText",BA.ObjectToCharSequence("Eliminar"));
 BA.debugLineNum = 260;BA.debugLine="btnEliminar.TextColor = Colors.White";
Debug.ShouldStop(8);
_btneliminar.runMethod(true,"setTextColor",suscripciones.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 261;BA.debugLine="btnEliminar.TextSize = 14";
Debug.ShouldStop(16);
_btneliminar.runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 262;BA.debugLine="btnEliminar.Height = btnEditar.Height";
Debug.ShouldStop(32);
_btneliminar.runMethod(true,"setHeight",_btneditar.runMethod(true,"getHeight"));
 BA.debugLineNum = 263;BA.debugLine="btnEliminar.Width = pnlOpciones.Width * 0.9";
Debug.ShouldStop(64);
_btneliminar.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlopciones.runMethod(true,"getWidth"),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 264;BA.debugLine="btnEliminar.Top = btnEditar.Top * 2 + btnEditar.H";
Debug.ShouldStop(128);
_btneliminar.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {_btneditar.runMethod(true,"getTop"),RemoteObject.createImmutable(2),_btneditar.runMethod(true,"getHeight")}, "*+",1, 1));
 BA.debugLineNum = 265;BA.debugLine="btnEliminar.Left = (pnlOpciones.Width - btnElimin";
Debug.ShouldStop(256);
_btneliminar.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_pnlopciones.runMethod(true,"getWidth"),_btneliminar.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 266;BA.debugLine="pnlOpciones.AddView(btnEliminar, btnEliminar.Left";
Debug.ShouldStop(512);
_pnlopciones.runVoidMethod ("AddView",(Object)((_btneliminar.getObject())),(Object)(_btneliminar.runMethod(true,"getLeft")),(Object)(_btneliminar.runMethod(true,"getTop")),(Object)(_btneliminar.runMethod(true,"getWidth")),(Object)(_btneliminar.runMethod(true,"getHeight")));
 BA.debugLineNum = 268;BA.debugLine="pnlDeslizable.AddView(pnlSuscripcion, pnlSuscripc";
Debug.ShouldStop(2048);
suscripciones.mostCurrent._pnldeslizable.runVoidMethod ("AddView",(Object)((_pnlsuscripcion.getObject())),(Object)(_pnlsuscripcion.runMethod(true,"getLeft")),(Object)(_top),(Object)(_pnlsuscripcion.runMethod(true,"getWidth")),(Object)(_pnlsuscripcion.runMethod(true,"getHeight")));
 BA.debugLineNum = 271;BA.debugLine="Dim referencia As IndiceSuscripcion";
Debug.ShouldStop(16384);
_referencia = RemoteObject.createNew ("pullup.wallet.suscripciones._indicesuscripcion");Debug.locals.put("referencia", _referencia);
 BA.debugLineNum = 272;BA.debugLine="referencia.indiceElemento = indice";
Debug.ShouldStop(32768);
_referencia.setField ("indiceElemento" /*RemoteObject*/ ,_indice);
 BA.debugLineNum = 273;BA.debugLine="referencia.rowid = 0";
Debug.ShouldStop(65536);
_referencia.setField ("rowid" /*RemoteObject*/ ,BA.numberCast(int.class, 0));
 BA.debugLineNum = 275;BA.debugLine="lblOpciones.Tag = referencia";
Debug.ShouldStop(262144);
_lblopciones.runMethod(false,"setTag",(_referencia));
 BA.debugLineNum = 278;BA.debugLine="Dim referencia2 As IndiceSuscripcion";
Debug.ShouldStop(2097152);
_referencia2 = RemoteObject.createNew ("pullup.wallet.suscripciones._indicesuscripcion");Debug.locals.put("referencia2", _referencia2);
 BA.debugLineNum = 279;BA.debugLine="referencia2.indiceElemento = 0";
Debug.ShouldStop(4194304);
_referencia2.setField ("indiceElemento" /*RemoteObject*/ ,BA.numberCast(int.class, 0));
 BA.debugLineNum = 280;BA.debugLine="referencia2.rowid = datos.rowid";
Debug.ShouldStop(8388608);
_referencia2.setField ("rowid" /*RemoteObject*/ ,_datos.getField(true,"rowid" /*RemoteObject*/ ));
 BA.debugLineNum = 282;BA.debugLine="pnlOpciones.Tag = referencia2";
Debug.ShouldStop(33554432);
_pnlopciones.runMethod(false,"setTag",(_referencia2));
 BA.debugLineNum = 285;BA.debugLine="Relaciones(indice, 0) = lblOpciones";
Debug.ShouldStop(268435456);
suscripciones.mostCurrent._relaciones.setArrayElement (RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _lblopciones.getObject()),_indice,BA.numberCast(int.class, 0));
 BA.debugLineNum = 286;BA.debugLine="Relaciones(indice, 1) = pnlOpciones";
Debug.ShouldStop(536870912);
suscripciones.mostCurrent._relaciones.setArrayElement (RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _pnlopciones.getObject()),_indice,BA.numberCast(int.class, 1));
 BA.debugLineNum = 289;BA.debugLine="arrayPnlsOpciones(indice) = pnlOpciones";
Debug.ShouldStop(1);
suscripciones.mostCurrent._arraypnlsopciones.setArrayElement (RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _pnlopciones.getObject()),_indice);
 BA.debugLineNum = 290;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
 //BA.debugLineNum = 15;BA.debugLine="Type IndiceSuscripcion(indiceElemento As Int, row";
;
 //BA.debugLineNum = 16;BA.debugLine="Type Suscripcion(rowid As Int, nombre As String,";
;
 //BA.debugLineNum = 17;BA.debugLine="Dim alturaDispositivo As Int";
suscripciones._alturadispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 18;BA.debugLine="Dim anchoDispositivo As Int";
suscripciones._anchodispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 19;BA.debugLine="Dim nRegistros As Int";
suscripciones._nregistros = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 20;BA.debugLine="Dim Relaciones(,) As B4XView";
suscripciones.mostCurrent._relaciones = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.B4XViewWrapper", new int[] {0,0}, new Object[]{});
 //BA.debugLineNum = 21;BA.debugLine="Dim arrayPnlsOpciones() As B4XView";
suscripciones.mostCurrent._arraypnlsopciones = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.B4XViewWrapper", new int[] {0}, new Object[]{});
 //BA.debugLineNum = 22;BA.debugLine="Private btnMenu As Button";
suscripciones.mostCurrent._btnmenu = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private lblContornoBoton As Label";
suscripciones.mostCurrent._lblcontornoboton = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private pnlNavInferior As Panel";
suscripciones.mostCurrent._pnlnavinferior = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private pnlDeslizable As Panel";
suscripciones.mostCurrent._pnldeslizable = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private svPantalla As ScrollView";
suscripciones.mostCurrent._svpantalla = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Dim cur As Cursor";
suscripciones.mostCurrent._cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Dim cs As CSBuilder";
suscripciones.mostCurrent._cs = RemoteObject.createNew ("anywheresoftware.b4a.objects.CSBuilder");
 //BA.debugLineNum = 29;BA.debugLine="Dim cvsTest As Canvas";
suscripciones.mostCurrent._cvstest = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Dim bmpTest As Bitmap";
suscripciones.mostCurrent._bmptest = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lblopciones_click() throws Exception{
try {
		Debug.PushSubsStack("lblOpciones_Click (suscripciones) ","suscripciones",18,suscripciones.mostCurrent.activityBA,suscripciones.mostCurrent,293);
if (RapidSub.canDelegate("lblopciones_click")) { return pullup.wallet.suscripciones.remoteMe.runUserSub(false, "suscripciones","lblopciones_click");}
RemoteObject _lblopcion = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _indice = RemoteObject.declareNull("pullup.wallet.suscripciones._indicesuscripcion");
int _contador = 0;
 BA.debugLineNum = 293;BA.debugLine="Sub lblOpciones_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 294;BA.debugLine="Dim lblOpcion As Label";
Debug.ShouldStop(32);
_lblopcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblOpcion", _lblopcion);
 BA.debugLineNum = 295;BA.debugLine="Dim indice As IndiceSuscripcion";
Debug.ShouldStop(64);
_indice = RemoteObject.createNew ("pullup.wallet.suscripciones._indicesuscripcion");Debug.locals.put("indice", _indice);
 BA.debugLineNum = 297;BA.debugLine="lblOpcion = Sender";
Debug.ShouldStop(256);
_lblopcion = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), suscripciones.mostCurrent.__c.runMethod(false,"Sender",suscripciones.mostCurrent.activityBA));
 BA.debugLineNum = 298;BA.debugLine="indice = lblOpcion.Tag";
Debug.ShouldStop(512);
_indice = (_lblopcion.runMethod(false,"getTag"));Debug.locals.put("indice", _indice);
 BA.debugLineNum = 301;BA.debugLine="For contador = 0 To arrayPnlsOpciones.Length - 1";
Debug.ShouldStop(4096);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {suscripciones.mostCurrent._arraypnlsopciones.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_contador = 0 ;
for (;(step5 > 0 && _contador <= limit5) || (step5 < 0 && _contador >= limit5) ;_contador = ((int)(0 + _contador + step5))  ) {
Debug.locals.put("contador", _contador);
 BA.debugLineNum = 302;BA.debugLine="If (contador <> indice.indiceElemento) Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("!",RemoteObject.createImmutable(_contador),BA.numberCast(double.class, _indice.getField(true,"indiceElemento" /*RemoteObject*/ ))))) { 
 BA.debugLineNum = 303;BA.debugLine="arrayPnlsOpciones(contador).Visible = False";
Debug.ShouldStop(16384);
suscripciones.mostCurrent._arraypnlsopciones.getArrayElement(false,BA.numberCast(int.class, _contador)).runMethod(true,"setVisible",suscripciones.mostCurrent.__c.getField(true,"False"));
 };
 }
}Debug.locals.put("contador", _contador);
;
 BA.debugLineNum = 308;BA.debugLine="Relaciones(indice.indiceElemento, 1).SetVisibleAn";
Debug.ShouldStop(524288);
suscripciones.mostCurrent._relaciones.getArrayElement(false,_indice.getField(true,"indiceElemento" /*RemoteObject*/ ),BA.numberCast(int.class, 1)).runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 200)),(Object)(suscripciones.mostCurrent.__c.runMethod(true,"Not",(Object)(suscripciones.mostCurrent._relaciones.getArrayElement(false,_indice.getField(true,"indiceElemento" /*RemoteObject*/ ),BA.numberCast(int.class, 1)).runMethod(true,"getVisible")))));
 BA.debugLineNum = 309;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
 //BA.debugLineNum = 9;BA.debugLine="Dim sql As SQL";
suscripciones._sql = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}