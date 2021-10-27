package pullup.wallet;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class metasdeahorro_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (metasdeahorro) ","metasdeahorro",13,metasdeahorro.mostCurrent.activityBA,metasdeahorro.mostCurrent,34);
if (RapidSub.canDelegate("activity_create")) { return pullup.wallet.metasdeahorro.remoteMe.runUserSub(false, "metasdeahorro","activity_create", _firsttime);}
RemoteObject _lblseccion = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _top = RemoteObject.createImmutable(0);
int _id = 0;
RemoteObject _datosmetaahorro = RemoteObject.declareNull("pullup.wallet.metasdeahorro._metaahorro");
RemoteObject _lblmensaje = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 34;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 37;BA.debugLine="Activity.LoadLayout(\"LDeslizable\")";
Debug.ShouldStop(16);
metasdeahorro.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("LDeslizable")),metasdeahorro.mostCurrent.activityBA);
 BA.debugLineNum = 38;BA.debugLine="Activity.Color = Colors.ARGB(255, 233, 236, 239)";
Debug.ShouldStop(32);
metasdeahorro.mostCurrent._activity.runVoidMethod ("setColor",metasdeahorro.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 233)),(Object)(BA.numberCast(int.class, 236)),(Object)(BA.numberCast(int.class, 239))));
 BA.debugLineNum = 39;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
Debug.ShouldStop(64);
metasdeahorro._alturadispositivo = metasdeahorro.mostCurrent._main._alturadispositivo /*RemoteObject*/ ;
 BA.debugLineNum = 40;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
Debug.ShouldStop(128);
metasdeahorro._anchodispositivo = metasdeahorro.mostCurrent._main._anchodispositivo /*RemoteObject*/ ;
 BA.debugLineNum = 41;BA.debugLine="bmpTest.InitializeMutable(1dip, 1dip)";
Debug.ShouldStop(256);
metasdeahorro.mostCurrent._bmptest.runVoidMethod ("InitializeMutable",(Object)(metasdeahorro.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))),(Object)(metasdeahorro.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 42;BA.debugLine="cvsTest.Initialize2(bmpTest)";
Debug.ShouldStop(512);
metasdeahorro.mostCurrent._cvstest.runVoidMethod ("Initialize2",(Object)((metasdeahorro.mostCurrent._bmptest.getObject())));
 BA.debugLineNum = 45;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
Debug.ShouldStop(4096);
metasdeahorro.mostCurrent._pnlnavinferior.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {metasdeahorro._alturadispositivo,RemoteObject.createImmutable(0.08)}, "*",0, 0)));
 BA.debugLineNum = 46;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
Debug.ShouldStop(8192);
metasdeahorro.mostCurrent._pnlnavinferior.runMethod(true,"setWidth",metasdeahorro._anchodispositivo);
 BA.debugLineNum = 47;BA.debugLine="pnlNavInferior.Left = 0";
Debug.ShouldStop(16384);
metasdeahorro.mostCurrent._pnlnavinferior.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 48;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
Debug.ShouldStop(32768);
metasdeahorro.mostCurrent._pnlnavinferior.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {metasdeahorro._alturadispositivo,metasdeahorro.mostCurrent._pnlnavinferior.runMethod(true,"getHeight")}, "-",1, 1));
 BA.debugLineNum = 51;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
Debug.ShouldStop(262144);
metasdeahorro.mostCurrent._btnmenu.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {metasdeahorro._anchodispositivo,RemoteObject.createImmutable(0.15)}, "*",0, 0)));
 BA.debugLineNum = 52;BA.debugLine="btnMenu.Height = btnMenu.Width";
Debug.ShouldStop(524288);
metasdeahorro.mostCurrent._btnmenu.runMethod(true,"setHeight",metasdeahorro.mostCurrent._btnmenu.runMethod(true,"getWidth"));
 BA.debugLineNum = 53;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
Debug.ShouldStop(1048576);
metasdeahorro.mostCurrent._btnmenu.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {metasdeahorro.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),metasdeahorro.mostCurrent._btnmenu.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 54;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
Debug.ShouldStop(2097152);
metasdeahorro.mostCurrent._btnmenu.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {metasdeahorro._anchodispositivo,metasdeahorro.mostCurrent._btnmenu.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 56;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
Debug.ShouldStop(8388608);
metasdeahorro.mostCurrent._lblcontornoboton.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {metasdeahorro._anchodispositivo,RemoteObject.createImmutable(0.17)}, "*",0, 0)));
 BA.debugLineNum = 57;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
Debug.ShouldStop(16777216);
metasdeahorro.mostCurrent._lblcontornoboton.runMethod(true,"setHeight",metasdeahorro.mostCurrent._lblcontornoboton.runMethod(true,"getWidth"));
 BA.debugLineNum = 58;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
Debug.ShouldStop(33554432);
metasdeahorro.mostCurrent._lblcontornoboton.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {metasdeahorro._anchodispositivo,metasdeahorro.mostCurrent._lblcontornoboton.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 59;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
Debug.ShouldStop(67108864);
metasdeahorro.mostCurrent._lblcontornoboton.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {metasdeahorro.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),metasdeahorro.mostCurrent._lblcontornoboton.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 63;BA.debugLine="svPantalla.Height = pnlNavInferior.Top";
Debug.ShouldStop(1073741824);
metasdeahorro.mostCurrent._svpantalla.runMethod(true,"setHeight",metasdeahorro.mostCurrent._pnlnavinferior.runMethod(true,"getTop"));
 BA.debugLineNum = 64;BA.debugLine="svPantalla.Panel.LoadLayout(\"LPantallaDeslizable\"";
Debug.ShouldStop(-2147483648);
metasdeahorro.mostCurrent._svpantalla.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("LPantallaDeslizable")),metasdeahorro.mostCurrent.activityBA);
 BA.debugLineNum = 65;BA.debugLine="svPantalla.Width = anchoDispositivo * 1.5";
Debug.ShouldStop(1);
metasdeahorro.mostCurrent._svpantalla.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {metasdeahorro._anchodispositivo,RemoteObject.createImmutable(1.5)}, "*",0, 0)));
 BA.debugLineNum = 66;BA.debugLine="pnlDeslizable.Width = svPantalla.Width";
Debug.ShouldStop(2);
metasdeahorro.mostCurrent._pnldeslizable.runMethod(true,"setWidth",metasdeahorro.mostCurrent._svpantalla.runMethod(true,"getWidth"));
 BA.debugLineNum = 72;BA.debugLine="Dim lblSeccion As Label";
Debug.ShouldStop(128);
_lblseccion = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblSeccion", _lblseccion);
 BA.debugLineNum = 73;BA.debugLine="lblSeccion.Initialize(\"lblSeccion\")";
Debug.ShouldStop(256);
_lblseccion.runVoidMethod ("Initialize",metasdeahorro.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("lblSeccion")));
 BA.debugLineNum = 74;BA.debugLine="lblSeccion.Text = \"Metas de ahorro\"";
Debug.ShouldStop(512);
_lblseccion.runMethod(true,"setText",BA.ObjectToCharSequence("Metas de ahorro"));
 BA.debugLineNum = 75;BA.debugLine="lblSeccion.TextSize = 20";
Debug.ShouldStop(1024);
_lblseccion.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 76;BA.debugLine="lblSeccion.TextColor = Colors.Black";
Debug.ShouldStop(2048);
_lblseccion.runMethod(true,"setTextColor",metasdeahorro.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 77;BA.debugLine="lblSeccion.Height = 30dip";
Debug.ShouldStop(4096);
_lblseccion.runMethod(true,"setHeight",metasdeahorro.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 78;BA.debugLine="lblSeccion.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(8192);
_lblseccion.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {metasdeahorro._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 79;BA.debugLine="lblSeccion.Top = 30dip";
Debug.ShouldStop(16384);
_lblseccion.runMethod(true,"setTop",metasdeahorro.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 80;BA.debugLine="lblSeccion.Left = (anchoDispositivo - lblSeccion.";
Debug.ShouldStop(32768);
_lblseccion.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {metasdeahorro._anchodispositivo,_lblseccion.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 81;BA.debugLine="pnlDeslizable.AddView(lblSeccion, lblSeccion.Left";
Debug.ShouldStop(65536);
metasdeahorro.mostCurrent._pnldeslizable.runVoidMethod ("AddView",(Object)((_lblseccion.getObject())),(Object)(_lblseccion.runMethod(true,"getLeft")),(Object)(_lblseccion.runMethod(true,"getTop")),(Object)(_lblseccion.runMethod(true,"getWidth")),(Object)(_lblseccion.runMethod(true,"getHeight")));
 BA.debugLineNum = 86;BA.debugLine="Dim top As Int";
Debug.ShouldStop(2097152);
_top = RemoteObject.createImmutable(0);Debug.locals.put("top", _top);
 BA.debugLineNum = 87;BA.debugLine="top = lblSeccion.Top + lblSeccion.Height + 30dip";
Debug.ShouldStop(4194304);
_top = RemoteObject.solve(new RemoteObject[] {_lblseccion.runMethod(true,"getTop"),_lblseccion.runMethod(true,"getHeight"),metasdeahorro.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "++",2, 1);Debug.locals.put("top", _top);
 BA.debugLineNum = 90;BA.debugLine="sql = Starter.sql";
Debug.ShouldStop(33554432);
metasdeahorro._sql = metasdeahorro.mostCurrent._starter._sql /*RemoteObject*/ ;
 BA.debugLineNum = 91;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM metas_ahorro O";
Debug.ShouldStop(67108864);
metasdeahorro.mostCurrent._cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), metasdeahorro._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM metas_ahorro ORDER BY rowid ASC"))));
 BA.debugLineNum = 92;BA.debugLine="nRegistros = cur.RowCount";
Debug.ShouldStop(134217728);
metasdeahorro._nregistros = metasdeahorro.mostCurrent._cur.runMethod(true,"getRowCount");
 BA.debugLineNum = 96;BA.debugLine="If nRegistros > 0 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean(">",metasdeahorro._nregistros,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 98;BA.debugLine="Dim Relaciones(nRegistros, 2) As B4XView";
Debug.ShouldStop(2);
metasdeahorro.mostCurrent._relaciones = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.B4XViewWrapper", new int[] {metasdeahorro._nregistros.<Integer>get().intValue(),2}, new Object[]{});
 BA.debugLineNum = 99;BA.debugLine="Dim arrayPnlsOpciones(nRegistros) As B4XView";
Debug.ShouldStop(4);
metasdeahorro.mostCurrent._arraypnlsopciones = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.B4XViewWrapper", new int[] {metasdeahorro._nregistros.<Integer>get().intValue()}, new Object[]{});
 BA.debugLineNum = 101;BA.debugLine="For id = 0 To nRegistros - 1";
Debug.ShouldStop(16);
{
final int step41 = 1;
final int limit41 = RemoteObject.solve(new RemoteObject[] {metasdeahorro._nregistros,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_id = 0 ;
for (;(step41 > 0 && _id <= limit41) || (step41 < 0 && _id >= limit41) ;_id = ((int)(0 + _id + step41))  ) {
Debug.locals.put("id", _id);
 BA.debugLineNum = 102;BA.debugLine="cur.Position = id";
Debug.ShouldStop(32);
metasdeahorro.mostCurrent._cur.runMethod(true,"setPosition",BA.numberCast(int.class, _id));
 BA.debugLineNum = 104;BA.debugLine="Dim datosMetaAhorro As MetaAhorro";
Debug.ShouldStop(128);
_datosmetaahorro = RemoteObject.createNew ("pullup.wallet.metasdeahorro._metaahorro");Debug.locals.put("datosMetaAhorro", _datosmetaahorro);
 BA.debugLineNum = 105;BA.debugLine="datosMetaAhorro.rowid = cur.GetInt(\"id_meta_aho";
Debug.ShouldStop(256);
_datosmetaahorro.setField ("rowid" /*RemoteObject*/ ,metasdeahorro.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("id_meta_ahorro"))));
 BA.debugLineNum = 106;BA.debugLine="datosMetaAhorro.nombre = cur.GetString(\"nombre\"";
Debug.ShouldStop(512);
_datosmetaahorro.setField ("nombre" /*RemoteObject*/ ,metasdeahorro.mostCurrent._cur.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("nombre"))));
 BA.debugLineNum = 107;BA.debugLine="datosMetaAhorro.montoPeriodico = cur.GetString(";
Debug.ShouldStop(1024);
_datosmetaahorro.setField ("montoPeriodico" /*RemoteObject*/ ,BA.numberCast(int.class, metasdeahorro.mostCurrent._cur.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("monto_ahorro")))));
 BA.debugLineNum = 108;BA.debugLine="datosMetaAhorro.montoFinal = cur.GetInt(\"monto_";
Debug.ShouldStop(2048);
_datosmetaahorro.setField ("montoFinal" /*RemoteObject*/ ,metasdeahorro.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("monto_meta"))));
 BA.debugLineNum = 109;BA.debugLine="datosMetaAhorro.progreso = cur.GetInt(\"progreso";
Debug.ShouldStop(4096);
_datosmetaahorro.setField ("progreso" /*RemoteObject*/ ,metasdeahorro.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("progreso"))));
 BA.debugLineNum = 110;BA.debugLine="datosMetaAhorro.descripcion = cur.GetString(\"de";
Debug.ShouldStop(8192);
_datosmetaahorro.setField ("descripcion" /*RemoteObject*/ ,metasdeahorro.mostCurrent._cur.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("descripcion"))));
 BA.debugLineNum = 111;BA.debugLine="datosMetaAhorro.periodo = cur.GetString(\"period";
Debug.ShouldStop(16384);
_datosmetaahorro.setField ("periodo" /*RemoteObject*/ ,metasdeahorro.mostCurrent._cur.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("periodo_ahorro"))));
 BA.debugLineNum = 112;BA.debugLine="datosMetaAhorro.color = cur.GetInt(\"color\")";
Debug.ShouldStop(32768);
_datosmetaahorro.setField ("color" /*RemoteObject*/ ,metasdeahorro.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("color"))));
 BA.debugLineNum = 114;BA.debugLine="creaObjetoLista(id, top, datosMetaAhorro)";
Debug.ShouldStop(131072);
_creaobjetolista(BA.numberCast(int.class, _id),_top,_datosmetaahorro);
 BA.debugLineNum = 116;BA.debugLine="top = top + alturaDispositivo * 0.18 + 60";
Debug.ShouldStop(524288);
_top = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_top,metasdeahorro._alturadispositivo,RemoteObject.createImmutable(0.18),RemoteObject.createImmutable(60)}, "+*+",2, 0));Debug.locals.put("top", _top);
 }
}Debug.locals.put("id", _id);
;
 }else {
 BA.debugLineNum = 120;BA.debugLine="Dim lblMensaje As Label";
Debug.ShouldStop(8388608);
_lblmensaje = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblMensaje", _lblmensaje);
 BA.debugLineNum = 121;BA.debugLine="lblMensaje.Initialize(\"lblMensaje\")";
Debug.ShouldStop(16777216);
_lblmensaje.runVoidMethod ("Initialize",metasdeahorro.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("lblMensaje")));
 BA.debugLineNum = 122;BA.debugLine="lblMensaje.Height = alturaDispositivo * 0.2";
Debug.ShouldStop(33554432);
_lblmensaje.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {metasdeahorro._alturadispositivo,RemoteObject.createImmutable(0.2)}, "*",0, 0)));
 BA.debugLineNum = 123;BA.debugLine="lblMensaje.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(67108864);
_lblmensaje.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {metasdeahorro._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 124;BA.debugLine="lblMensaje.Top = (alturaDispositivo - lblMensaje";
Debug.ShouldStop(134217728);
_lblmensaje.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {metasdeahorro._alturadispositivo,_lblmensaje.runMethod(true,"getHeight")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 125;BA.debugLine="lblMensaje.Left = (anchoDispositivo - lblMensaje";
Debug.ShouldStop(268435456);
_lblmensaje.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {metasdeahorro._anchodispositivo,_lblmensaje.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 126;BA.debugLine="lblMensaje.Text = cs.Initialize.Color(Colors.Bla";
Debug.ShouldStop(536870912);
_lblmensaje.runMethod(true,"setText",BA.ObjectToCharSequence(metasdeahorro.mostCurrent._cs.runMethod(false,"Initialize").runMethod(false,"Color",(Object)(metasdeahorro.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"))).runMethod(false,"Alignment",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.text.Layout.Alignment"),RemoteObject.createImmutable("ALIGN_CENTER")))).runMethod(false,"Typeface",(Object)(metasdeahorro.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"getMATERIALICONS"))).runMethod(false,"Size",(Object)(BA.numberCast(int.class, 50))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(metasdeahorro.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xe89c))),metasdeahorro.mostCurrent.__c.getField(true,"CRLF"))))).runMethod(false,"Typeface",(Object)(metasdeahorro.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT"))).runMethod(false,"Size",(Object)(BA.numberCast(int.class, 18))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Está muy vacío aquí adentro."),metasdeahorro.mostCurrent.__c.getField(true,"CRLF"))))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Agrega una meta de ahorro desde el menú principal.")))).runMethod(false,"PopAll").getObject()));
 BA.debugLineNum = 127;BA.debugLine="Activity.AddView(lblMensaje, lblMensaje.Left, lb";
Debug.ShouldStop(1073741824);
metasdeahorro.mostCurrent._activity.runVoidMethod ("AddView",(Object)((_lblmensaje.getObject())),(Object)(_lblmensaje.runMethod(true,"getLeft")),(Object)(_lblmensaje.runMethod(true,"getTop")),(Object)(_lblmensaje.runMethod(true,"getWidth")),(Object)(_lblmensaje.runMethod(true,"getHeight")));
 };
 BA.debugLineNum = 130;BA.debugLine="svPantalla.Panel.Height = top + 100";
Debug.ShouldStop(2);
metasdeahorro.mostCurrent._svpantalla.runMethod(false,"getPanel").runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {_top,RemoteObject.createImmutable(100)}, "+",1, 1));
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (metasdeahorro) ","metasdeahorro",13,metasdeahorro.mostCurrent.activityBA,metasdeahorro.mostCurrent,137);
if (RapidSub.canDelegate("activity_pause")) { return pullup.wallet.metasdeahorro.remoteMe.runUserSub(false, "metasdeahorro","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 137;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(256);
 BA.debugLineNum = 139;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("Activity_Resume (metasdeahorro) ","metasdeahorro",13,metasdeahorro.mostCurrent.activityBA,metasdeahorro.mostCurrent,133);
if (RapidSub.canDelegate("activity_resume")) { return pullup.wallet.metasdeahorro.remoteMe.runUserSub(false, "metasdeahorro","activity_resume");}
 BA.debugLineNum = 133;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16);
 BA.debugLineNum = 135;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("btnEditar_Click (metasdeahorro) ","metasdeahorro",13,metasdeahorro.mostCurrent.activityBA,metasdeahorro.mostCurrent,336);
if (RapidSub.canDelegate("btneditar_click")) { return pullup.wallet.metasdeahorro.remoteMe.runUserSub(false, "metasdeahorro","btneditar_click");}
RemoteObject _btneditar = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _pnlpadre = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _idregistro = RemoteObject.createImmutable(0);
RemoteObject _indice = RemoteObject.declareNull("pullup.wallet.suscripciones._indicesuscripcion");
 BA.debugLineNum = 336;BA.debugLine="Sub btnEditar_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 337;BA.debugLine="Dim btnEditar As Button";
Debug.ShouldStop(65536);
_btneditar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("btnEditar", _btneditar);
 BA.debugLineNum = 338;BA.debugLine="Dim pnlPadre As Panel";
Debug.ShouldStop(131072);
_pnlpadre = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnlPadre", _pnlpadre);
 BA.debugLineNum = 339;BA.debugLine="Dim idRegistro As Int";
Debug.ShouldStop(262144);
_idregistro = RemoteObject.createImmutable(0);Debug.locals.put("idRegistro", _idregistro);
 BA.debugLineNum = 340;BA.debugLine="Dim indice As IndiceSuscripcion";
Debug.ShouldStop(524288);
_indice = RemoteObject.createNew ("pullup.wallet.suscripciones._indicesuscripcion");Debug.locals.put("indice", _indice);
 BA.debugLineNum = 343;BA.debugLine="btnEditar = Sender";
Debug.ShouldStop(4194304);
_btneditar = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), metasdeahorro.mostCurrent.__c.runMethod(false,"Sender",metasdeahorro.mostCurrent.activityBA));
 BA.debugLineNum = 345;BA.debugLine="pnlPadre = btnEditar.Parent";
Debug.ShouldStop(16777216);
_pnlpadre = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), _btneditar.runMethod(false,"getParent"));
 BA.debugLineNum = 347;BA.debugLine="indice = pnlPadre.Tag";
Debug.ShouldStop(67108864);
_indice = (_pnlpadre.runMethod(false,"getTag"));Debug.locals.put("indice", _indice);
 BA.debugLineNum = 349;BA.debugLine="idRegistro = indice.rowid";
Debug.ShouldStop(268435456);
_idregistro = _indice.getField(true,"rowid" /*RemoteObject*/ );Debug.locals.put("idRegistro", _idregistro);
 BA.debugLineNum = 350;BA.debugLine="CallSubDelayed2(editarMetaAhorro, \"consultaAEdita";
Debug.ShouldStop(536870912);
metasdeahorro.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",metasdeahorro.processBA,(Object)((metasdeahorro.mostCurrent._editarmetaahorro.getObject())),(Object)(BA.ObjectToString("consultaAEditar")),(Object)((_idregistro)));
 BA.debugLineNum = 351;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1073741824);
metasdeahorro.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 352;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("btnEliminar_Click (metasdeahorro) ","metasdeahorro",13,metasdeahorro.mostCurrent.activityBA,metasdeahorro.mostCurrent,354);
if (RapidSub.canDelegate("btneliminar_click")) { return pullup.wallet.metasdeahorro.remoteMe.runUserSub(false, "metasdeahorro","btneliminar_click");}
RemoteObject _btneliminar = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _pnlpadre = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _idregistro = RemoteObject.createImmutable(0);
RemoteObject _indice = RemoteObject.declareNull("pullup.wallet.suscripciones._indicesuscripcion");
RemoteObject _resultado = RemoteObject.createImmutable(0);
 BA.debugLineNum = 354;BA.debugLine="Sub btnEliminar_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 355;BA.debugLine="Dim btnEliminar As Button";
Debug.ShouldStop(4);
_btneliminar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("btnEliminar", _btneliminar);
 BA.debugLineNum = 356;BA.debugLine="Dim pnlPadre As Panel";
Debug.ShouldStop(8);
_pnlpadre = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnlPadre", _pnlpadre);
 BA.debugLineNum = 357;BA.debugLine="Dim idRegistro As Int";
Debug.ShouldStop(16);
_idregistro = RemoteObject.createImmutable(0);Debug.locals.put("idRegistro", _idregistro);
 BA.debugLineNum = 358;BA.debugLine="Dim indice As IndiceSuscripcion";
Debug.ShouldStop(32);
_indice = RemoteObject.createNew ("pullup.wallet.suscripciones._indicesuscripcion");Debug.locals.put("indice", _indice);
 BA.debugLineNum = 361;BA.debugLine="btnEliminar = Sender";
Debug.ShouldStop(256);
_btneliminar = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), metasdeahorro.mostCurrent.__c.runMethod(false,"Sender",metasdeahorro.mostCurrent.activityBA));
 BA.debugLineNum = 363;BA.debugLine="pnlPadre = btnEliminar.Parent";
Debug.ShouldStop(1024);
_pnlpadre = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), _btneliminar.runMethod(false,"getParent"));
 BA.debugLineNum = 365;BA.debugLine="indice = pnlPadre.Tag";
Debug.ShouldStop(4096);
_indice = (_pnlpadre.runMethod(false,"getTag"));Debug.locals.put("indice", _indice);
 BA.debugLineNum = 367;BA.debugLine="idRegistro = indice.rowid";
Debug.ShouldStop(16384);
_idregistro = _indice.getField(true,"rowid" /*RemoteObject*/ );Debug.locals.put("idRegistro", _idregistro);
 BA.debugLineNum = 370;BA.debugLine="Dim resultado As Int";
Debug.ShouldStop(131072);
_resultado = RemoteObject.createImmutable(0);Debug.locals.put("resultado", _resultado);
 BA.debugLineNum = 371;BA.debugLine="resultado = Msgbox2(\"¿Estás seguro?\", \"Eliminar m";
Debug.ShouldStop(262144);
_resultado = metasdeahorro.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("¿Estás seguro?")),(Object)(BA.ObjectToCharSequence("Eliminar meta de ahorro")),(Object)(BA.ObjectToString("Sí")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("No")),(Object)((metasdeahorro.mostCurrent.__c.getField(false,"Null"))),metasdeahorro.mostCurrent.activityBA);Debug.locals.put("resultado", _resultado);
 BA.debugLineNum = 372;BA.debugLine="If (resultado = DialogResponse.POSITIVE) Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",_resultado,BA.numberCast(double.class, metasdeahorro.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE"))))) { 
 BA.debugLineNum = 374;BA.debugLine="sql.ExecNonQuery(\"DELETE FROM metas_ahorro WHERE";
Debug.ShouldStop(2097152);
metasdeahorro._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("DELETE FROM metas_ahorro WHERE id_meta_ahorro = '"),_idregistro,RemoteObject.createImmutable("'"))));
 BA.debugLineNum = 377;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16777216);
metasdeahorro.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 378;BA.debugLine="StartActivity(Me)";
Debug.ShouldStop(33554432);
metasdeahorro.mostCurrent.__c.runVoidMethod ("StartActivity",metasdeahorro.processBA,(Object)(metasdeahorro.getObject()));
 };
 BA.debugLineNum = 380;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("btnMenu_Click (metasdeahorro) ","metasdeahorro",13,metasdeahorro.mostCurrent.activityBA,metasdeahorro.mostCurrent,141);
if (RapidSub.canDelegate("btnmenu_click")) { return pullup.wallet.metasdeahorro.remoteMe.runUserSub(false, "metasdeahorro","btnmenu_click");}
 BA.debugLineNum = 141;BA.debugLine="Private Sub btnMenu_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 142;BA.debugLine="CallSubDelayed(Main, \"actualizarDatos\")";
Debug.ShouldStop(8192);
metasdeahorro.mostCurrent.__c.runVoidMethod ("CallSubDelayed",metasdeahorro.processBA,(Object)((metasdeahorro.mostCurrent._main.getObject())),(Object)(RemoteObject.createImmutable("actualizarDatos")));
 BA.debugLineNum = 143;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16384);
metasdeahorro.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 144;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("creaObjetoLista (metasdeahorro) ","metasdeahorro",13,metasdeahorro.mostCurrent.activityBA,metasdeahorro.mostCurrent,147);
if (RapidSub.canDelegate("creaobjetolista")) { return pullup.wallet.metasdeahorro.remoteMe.runUserSub(false, "metasdeahorro","creaobjetolista", _indice, _top, _datos);}
RemoteObject _pnlmetaahorro = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _pnlopciones = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _lblnombre = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lblmontofinal = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lbldescripcion = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _pbprogreso = RemoteObject.declareNull("anywheresoftware.b4a.objects.ProgressBarWrapper");
RemoteObject _lblprogreso = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lblperiodoymonto = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
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
 BA.debugLineNum = 147;BA.debugLine="Sub creaObjetoLista(indice As Int, top As Int, dat";
Debug.ShouldStop(262144);
 BA.debugLineNum = 148;BA.debugLine="Dim pnlMetaAhorro As Panel";
Debug.ShouldStop(524288);
_pnlmetaahorro = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnlMetaAhorro", _pnlmetaahorro);
 BA.debugLineNum = 149;BA.debugLine="Dim pnlOpciones As Panel";
Debug.ShouldStop(1048576);
_pnlopciones = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnlOpciones", _pnlopciones);
 BA.debugLineNum = 150;BA.debugLine="Dim lblNombre As Label";
Debug.ShouldStop(2097152);
_lblnombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblNombre", _lblnombre);
 BA.debugLineNum = 151;BA.debugLine="Dim lblMontoFinal As Label";
Debug.ShouldStop(4194304);
_lblmontofinal = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblMontoFinal", _lblmontofinal);
 BA.debugLineNum = 152;BA.debugLine="Dim lblDescripcion As Label";
Debug.ShouldStop(8388608);
_lbldescripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblDescripcion", _lbldescripcion);
 BA.debugLineNum = 153;BA.debugLine="Dim pbProgreso As ProgressBar";
Debug.ShouldStop(16777216);
_pbprogreso = RemoteObject.createNew ("anywheresoftware.b4a.objects.ProgressBarWrapper");Debug.locals.put("pbProgreso", _pbprogreso);
 BA.debugLineNum = 154;BA.debugLine="Dim lblProgreso As Label";
Debug.ShouldStop(33554432);
_lblprogreso = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblProgreso", _lblprogreso);
 BA.debugLineNum = 155;BA.debugLine="Dim lblPeriodoYMonto As Label";
Debug.ShouldStop(67108864);
_lblperiodoymonto = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblPeriodoYMonto", _lblperiodoymonto);
 BA.debugLineNum = 156;BA.debugLine="Dim lblOpciones As Label";
Debug.ShouldStop(134217728);
_lblopciones = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblOpciones", _lblopciones);
 BA.debugLineNum = 157;BA.debugLine="Dim btnEditar As Button";
Debug.ShouldStop(268435456);
_btneditar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("btnEditar", _btneditar);
 BA.debugLineNum = 158;BA.debugLine="Dim btnEliminar As Button";
Debug.ShouldStop(536870912);
_btneliminar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("btnEliminar", _btneliminar);
 BA.debugLineNum = 161;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(1);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 162;BA.debugLine="cd.Initialize(datos.color, 20)";
Debug.ShouldStop(2);
_cd.runVoidMethod ("Initialize",(Object)(_datos.getField(true,"color" /*RemoteObject*/ )),(Object)(BA.numberCast(int.class, 20)));
 BA.debugLineNum = 165;BA.debugLine="pnlMetaAhorro.Initialize(\"pnlMetaAhorro\")";
Debug.ShouldStop(16);
_pnlmetaahorro.runVoidMethod ("Initialize",metasdeahorro.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("pnlMetaAhorro")));
 BA.debugLineNum = 166;BA.debugLine="pnlMetaAhorro.Top = top";
Debug.ShouldStop(32);
_pnlmetaahorro.runMethod(true,"setTop",_top);
 BA.debugLineNum = 167;BA.debugLine="pnlMetaAhorro.Background = cd";
Debug.ShouldStop(64);
_pnlmetaahorro.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 168;BA.debugLine="pnlMetaAhorro.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(128);
_pnlmetaahorro.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {metasdeahorro._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 169;BA.debugLine="pnlMetaAhorro.Height = alturaDispositivo * 0.18";
Debug.ShouldStop(256);
_pnlmetaahorro.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {metasdeahorro._alturadispositivo,RemoteObject.createImmutable(0.18)}, "*",0, 0)));
 BA.debugLineNum = 170;BA.debugLine="pnlMetaAhorro.Left = (anchoDispositivo - pnlMetaA";
Debug.ShouldStop(512);
_pnlmetaahorro.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {metasdeahorro._anchodispositivo,_pnlmetaahorro.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 172;BA.debugLine="lblNombre.Initialize(\"lblNombre\")";
Debug.ShouldStop(2048);
_lblnombre.runVoidMethod ("Initialize",metasdeahorro.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("lblNombre")));
 BA.debugLineNum = 173;BA.debugLine="lblNombre.TextColor = Colors.White";
Debug.ShouldStop(4096);
_lblnombre.runMethod(true,"setTextColor",metasdeahorro.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 174;BA.debugLine="lblNombre.Text = datos.nombre.ToUpperCase.CharAt(";
Debug.ShouldStop(8192);
_lblnombre.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_datos.getField(true,"nombre" /*RemoteObject*/ ).runMethod(true,"toUpperCase").runMethod(true,"charAt",(Object)(BA.numberCast(int.class, 0))),_datos.getField(true,"nombre" /*RemoteObject*/ ).runMethod(true,"substring",(Object)(BA.numberCast(int.class, 1))).runMethod(true,"toLowerCase"))));
 BA.debugLineNum = 175;BA.debugLine="lblNombre.TextSize = 19";
Debug.ShouldStop(16384);
_lblnombre.runMethod(true,"setTextSize",BA.numberCast(float.class, 19));
 BA.debugLineNum = 176;BA.debugLine="lblNombre.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(32768);
_lblnombre.runMethod(true,"setGravity",metasdeahorro.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 177;BA.debugLine="lblNombre.Height = pnlMetaAhorro.Height * 0.25";
Debug.ShouldStop(65536);
_lblnombre.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlmetaahorro.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.25)}, "*",0, 0)));
 BA.debugLineNum = 178;BA.debugLine="lblNombre.Width = pnlMetaAhorro.Width * 0.9";
Debug.ShouldStop(131072);
_lblnombre.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlmetaahorro.runMethod(true,"getWidth"),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 179;BA.debugLine="lblNombre.Top = 0";
Debug.ShouldStop(262144);
_lblnombre.runMethod(true,"setTop",BA.numberCast(int.class, 0));
 BA.debugLineNum = 180;BA.debugLine="lblNombre.Left = pnlMetaAhorro.Width * 0.05";
Debug.ShouldStop(524288);
_lblnombre.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlmetaahorro.runMethod(true,"getWidth"),RemoteObject.createImmutable(0.05)}, "*",0, 0)));
 BA.debugLineNum = 181;BA.debugLine="pnlMetaAhorro.AddView(lblNombre, lblNombre.Left,";
Debug.ShouldStop(1048576);
_pnlmetaahorro.runVoidMethod ("AddView",(Object)((_lblnombre.getObject())),(Object)(_lblnombre.runMethod(true,"getLeft")),(Object)(_lblnombre.runMethod(true,"getTop")),(Object)(_lblnombre.runMethod(true,"getWidth")),(Object)(_lblnombre.runMethod(true,"getHeight")));
 BA.debugLineNum = 183;BA.debugLine="lblDescripcion.Initialize(\"lblDescripcion\")";
Debug.ShouldStop(4194304);
_lbldescripcion.runVoidMethod ("Initialize",metasdeahorro.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("lblDescripcion")));
 BA.debugLineNum = 184;BA.debugLine="lblDescripcion.Text = datos.descripcion.ToUpperCa";
Debug.ShouldStop(8388608);
_lbldescripcion.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_datos.getField(true,"descripcion" /*RemoteObject*/ ).runMethod(true,"toUpperCase").runMethod(true,"charAt",(Object)(BA.numberCast(int.class, 0))),_datos.getField(true,"descripcion" /*RemoteObject*/ ).runMethod(true,"substring",(Object)(BA.numberCast(int.class, 1))).runMethod(true,"toLowerCase"))));
 BA.debugLineNum = 185;BA.debugLine="lblDescripcion.TextColor = Colors.White";
Debug.ShouldStop(16777216);
_lbldescripcion.runMethod(true,"setTextColor",metasdeahorro.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 186;BA.debugLine="lblDescripcion.Height = pnlMetaAhorro.Height * 0.";
Debug.ShouldStop(33554432);
_lbldescripcion.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlmetaahorro.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.25)}, "*",0, 0)));
 BA.debugLineNum = 187;BA.debugLine="lblDescripcion.Width = pnlMetaAhorro.Width * 0.9";
Debug.ShouldStop(67108864);
_lbldescripcion.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlmetaahorro.runMethod(true,"getWidth"),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 188;BA.debugLine="lblDescripcion.Top = lblNombre.Top + lblNombre.He";
Debug.ShouldStop(134217728);
_lbldescripcion.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {_lblnombre.runMethod(true,"getTop"),_lblnombre.runMethod(true,"getHeight"),RemoteObject.createImmutable(5)}, "++",2, 1));
 BA.debugLineNum = 189;BA.debugLine="lblDescripcion.Left = lblNombre.Left";
Debug.ShouldStop(268435456);
_lbldescripcion.runMethod(true,"setLeft",_lblnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 190;BA.debugLine="pnlMetaAhorro.AddView(lblDescripcion, lblDescripc";
Debug.ShouldStop(536870912);
_pnlmetaahorro.runVoidMethod ("AddView",(Object)((_lbldescripcion.getObject())),(Object)(_lbldescripcion.runMethod(true,"getLeft")),(Object)(_lbldescripcion.runMethod(true,"getTop")),(Object)(_lbldescripcion.runMethod(true,"getWidth")),(Object)(_lbldescripcion.runMethod(true,"getHeight")));
 BA.debugLineNum = 192;BA.debugLine="pbProgreso.Initialize(\"pgProgreso\")";
Debug.ShouldStop(-2147483648);
_pbprogreso.runVoidMethod ("Initialize",metasdeahorro.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("pgProgreso")));
 BA.debugLineNum = 193;BA.debugLine="pbProgreso.Width = pnlMetaAhorro.Width * 0.9";
Debug.ShouldStop(1);
_pbprogreso.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlmetaahorro.runMethod(true,"getWidth"),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 194;BA.debugLine="pbProgreso.Height = pnlMetaAhorro.Height * 0.15";
Debug.ShouldStop(2);
_pbprogreso.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlmetaahorro.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.15)}, "*",0, 0)));
 BA.debugLineNum = 195;BA.debugLine="pbProgreso.Top = lblDescripcion.Top + lblDescripc";
Debug.ShouldStop(4);
_pbprogreso.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {_lbldescripcion.runMethod(true,"getTop"),_lbldescripcion.runMethod(true,"getHeight")}, "+",1, 1));
 BA.debugLineNum = 196;BA.debugLine="pbProgreso.Left = (pnlMetaAhorro.Width - pbProgre";
Debug.ShouldStop(8);
_pbprogreso.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_pnlmetaahorro.runMethod(true,"getWidth"),_pbprogreso.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 197;BA.debugLine="If(datos.progreso <> 0 Or datos.periodo <> Null)";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("!",_datos.getField(true,"progreso" /*RemoteObject*/ ),BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("N",_datos.getField(true,"periodo" /*RemoteObject*/ )))) { 
 BA.debugLineNum = 198;BA.debugLine="pbProgreso.Progress = (datos.progreso * 100) / d";
Debug.ShouldStop(32);
_pbprogreso.runMethod(true,"setProgress",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_datos.getField(true,"progreso" /*RemoteObject*/ ),RemoteObject.createImmutable(100)}, "*",0, 1)),_datos.getField(true,"montoFinal" /*RemoteObject*/ )}, "/",0, 0)));
 }else {
 BA.debugLineNum = 200;BA.debugLine="pbProgreso.Progress = 0";
Debug.ShouldStop(128);
_pbprogreso.runMethod(true,"setProgress",BA.numberCast(int.class, 0));
 };
 BA.debugLineNum = 202;BA.debugLine="pnlMetaAhorro.AddView(pbProgreso, pbProgreso.Left";
Debug.ShouldStop(512);
_pnlmetaahorro.runVoidMethod ("AddView",(Object)((_pbprogreso.getObject())),(Object)(_pbprogreso.runMethod(true,"getLeft")),(Object)(_pbprogreso.runMethod(true,"getTop")),(Object)(_pbprogreso.runMethod(true,"getWidth")),(Object)(_pbprogreso.runMethod(true,"getHeight")));
 BA.debugLineNum = 204;BA.debugLine="lblProgreso.Initialize(\"lblProgreso\")";
Debug.ShouldStop(2048);
_lblprogreso.runVoidMethod ("Initialize",metasdeahorro.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("lblProgreso")));
 BA.debugLineNum = 205;BA.debugLine="lblProgreso.TextColor = Colors.Black";
Debug.ShouldStop(4096);
_lblprogreso.runMethod(true,"setTextColor",metasdeahorro.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 208;BA.debugLine="lblProgreso.Width = cvsTest.MeasureStringWidth(\"$";
Debug.ShouldStop(32768);
_lblprogreso.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {metasdeahorro.mostCurrent._cvstest.runMethod(true,"MeasureStringWidth",(Object)(RemoteObject.concat(RemoteObject.createImmutable("$"),_datos.getField(true,"progreso" /*RemoteObject*/ ))),(Object)(metasdeahorro.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT")),(Object)(_lblprogreso.runMethod(true,"getTextSize"))),RemoteObject.createImmutable(2)}, "+",1, 0)));
 BA.debugLineNum = 209;BA.debugLine="lblProgreso.Height = stu.MeasureMultilineTextHeig";
Debug.ShouldStop(65536);
_lblprogreso.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {metasdeahorro.mostCurrent._stu.runMethod(true,"MeasureMultilineTextHeight",(Object)((_lblprogreso.getObject())),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("$"),_datos.getField(true,"progreso" /*RemoteObject*/ ))))),RemoteObject.createImmutable(2)}, "+",1, 1));
 BA.debugLineNum = 210;BA.debugLine="lblProgreso.Text = \"$\" & datos.progreso";
Debug.ShouldStop(131072);
_lblprogreso.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("$"),_datos.getField(true,"progreso" /*RemoteObject*/ ))));
 BA.debugLineNum = 212;BA.debugLine="lblProgreso.Left = (pbProgreso.Width - lblProgres";
Debug.ShouldStop(524288);
_lblprogreso.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_pbprogreso.runMethod(true,"getWidth"),_lblprogreso.runMethod(true,"getWidth")}, "-",1, 1)),(RemoteObject.solve(new RemoteObject[] {_pbprogreso.runMethod(true,"getProgress"),RemoteObject.createImmutable(100)}, "/",0, 0)),_pbprogreso.runMethod(true,"getLeft")}, "*+",1, 0)));
 BA.debugLineNum = 213;BA.debugLine="lblProgreso.Top = pbProgreso.Top + pbProgreso.Hei";
Debug.ShouldStop(1048576);
_lblprogreso.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {_pbprogreso.runMethod(true,"getTop"),_pbprogreso.runMethod(true,"getHeight")}, "+",1, 1));
 BA.debugLineNum = 214;BA.debugLine="pnlMetaAhorro.AddView(lblProgreso, lblProgreso.Le";
Debug.ShouldStop(2097152);
_pnlmetaahorro.runVoidMethod ("AddView",(Object)((_lblprogreso.getObject())),(Object)(_lblprogreso.runMethod(true,"getLeft")),(Object)(_lblprogreso.runMethod(true,"getTop")),(Object)(_lblprogreso.runMethod(true,"getWidth")),(Object)(_lblprogreso.runMethod(true,"getHeight")));
 BA.debugLineNum = 216;BA.debugLine="lblPeriodoYMonto.Initialize(\"lblPeriodoYMonto\")";
Debug.ShouldStop(8388608);
_lblperiodoymonto.runVoidMethod ("Initialize",metasdeahorro.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("lblPeriodoYMonto")));
 BA.debugLineNum = 218;BA.debugLine="Dim textoPeriodo As String";
Debug.ShouldStop(33554432);
_textoperiodo = RemoteObject.createImmutable("");Debug.locals.put("textoPeriodo", _textoperiodo);
 BA.debugLineNum = 219;BA.debugLine="If (datos.periodo = 7) Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",_datos.getField(true,"periodo" /*RemoteObject*/ ),BA.NumberToString(7)))) { 
 BA.debugLineNum = 220;BA.debugLine="textoPeriodo = \"1 semana\"";
Debug.ShouldStop(134217728);
_textoperiodo = BA.ObjectToString("1 semana");Debug.locals.put("textoPeriodo", _textoperiodo);
 }else 
{ BA.debugLineNum = 221;BA.debugLine="Else If (datos.periodo = 14) Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",_datos.getField(true,"periodo" /*RemoteObject*/ ),BA.NumberToString(14)))) { 
 BA.debugLineNum = 222;BA.debugLine="textoPeriodo = \"2 semanas\"";
Debug.ShouldStop(536870912);
_textoperiodo = BA.ObjectToString("2 semanas");Debug.locals.put("textoPeriodo", _textoperiodo);
 }else 
{ BA.debugLineNum = 223;BA.debugLine="Else If (datos.periodo = 21) Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",_datos.getField(true,"periodo" /*RemoteObject*/ ),BA.NumberToString(21)))) { 
 BA.debugLineNum = 224;BA.debugLine="textoPeriodo = \"3 semanas\"";
Debug.ShouldStop(-2147483648);
_textoperiodo = BA.ObjectToString("3 semanas");Debug.locals.put("textoPeriodo", _textoperiodo);
 }else 
{ BA.debugLineNum = 225;BA.debugLine="Else If (datos.periodo = 30) Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",_datos.getField(true,"periodo" /*RemoteObject*/ ),BA.NumberToString(30)))) { 
 BA.debugLineNum = 226;BA.debugLine="textoPeriodo = \"1 mes\"";
Debug.ShouldStop(2);
_textoperiodo = BA.ObjectToString("1 mes");Debug.locals.put("textoPeriodo", _textoperiodo);
 }else 
{ BA.debugLineNum = 227;BA.debugLine="Else If (datos.periodo = 365) Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",_datos.getField(true,"periodo" /*RemoteObject*/ ),BA.NumberToString(365)))) { 
 BA.debugLineNum = 228;BA.debugLine="textoPeriodo = \"1 año\"";
Debug.ShouldStop(8);
_textoperiodo = BA.ObjectToString("1 año");Debug.locals.put("textoPeriodo", _textoperiodo);
 }}}}}
;
 BA.debugLineNum = 231;BA.debugLine="lblPeriodoYMonto.Text = textoPeriodo & \": $\" & da";
Debug.ShouldStop(64);
_lblperiodoymonto.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_textoperiodo,RemoteObject.createImmutable(": $"),_datos.getField(true,"montoPeriodico" /*RemoteObject*/ ))));
 BA.debugLineNum = 232;BA.debugLine="lblPeriodoYMonto.TextSize = 16";
Debug.ShouldStop(128);
_lblperiodoymonto.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 233;BA.debugLine="lblPeriodoYMonto.TextColor = Colors.DarkGray";
Debug.ShouldStop(256);
_lblperiodoymonto.runMethod(true,"setTextColor",metasdeahorro.mostCurrent.__c.getField(false,"Colors").getField(true,"DarkGray"));
 BA.debugLineNum = 234;BA.debugLine="lblPeriodoYMonto.Height = pnlMetaAhorro.Height *";
Debug.ShouldStop(512);
_lblperiodoymonto.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlmetaahorro.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.25)}, "*",0, 0)));
 BA.debugLineNum = 235;BA.debugLine="lblPeriodoYMonto.Width = pnlMetaAhorro.Width * 0.";
Debug.ShouldStop(1024);
_lblperiodoymonto.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlmetaahorro.runMethod(true,"getWidth"),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 236;BA.debugLine="lblPeriodoYMonto.Top = lblProgreso.Top + lblProgr";
Debug.ShouldStop(2048);
_lblperiodoymonto.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {_lblprogreso.runMethod(true,"getTop"),_lblprogreso.runMethod(true,"getHeight")}, "+",1, 1));
 BA.debugLineNum = 237;BA.debugLine="lblPeriodoYMonto.Left = lblNombre.Left";
Debug.ShouldStop(4096);
_lblperiodoymonto.runMethod(true,"setLeft",_lblnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 238;BA.debugLine="pnlMetaAhorro.AddView(lblPeriodoYMonto, lblPeriod";
Debug.ShouldStop(8192);
_pnlmetaahorro.runVoidMethod ("AddView",(Object)((_lblperiodoymonto.getObject())),(Object)(_lblperiodoymonto.runMethod(true,"getLeft")),(Object)(_lblperiodoymonto.runMethod(true,"getTop")),(Object)(_lblperiodoymonto.runMethod(true,"getWidth")),(Object)(_lblperiodoymonto.runMethod(true,"getHeight")));
 BA.debugLineNum = 240;BA.debugLine="lblMontoFinal.Initialize(\"lblMontoFinal\")";
Debug.ShouldStop(32768);
_lblmontofinal.runVoidMethod ("Initialize",metasdeahorro.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("lblMontoFinal")));
 BA.debugLineNum = 241;BA.debugLine="lblMontoFinal.Text = \"$\" & datos.montoFinal";
Debug.ShouldStop(65536);
_lblmontofinal.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("$"),_datos.getField(true,"montoFinal" /*RemoteObject*/ ))));
 BA.debugLineNum = 242;BA.debugLine="lblMontoFinal.TextSize = 18";
Debug.ShouldStop(131072);
_lblmontofinal.runMethod(true,"setTextSize",BA.numberCast(float.class, 18));
 BA.debugLineNum = 243;BA.debugLine="lblMontoFinal.TextColor = Colors.Red";
Debug.ShouldStop(262144);
_lblmontofinal.runMethod(true,"setTextColor",metasdeahorro.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 244;BA.debugLine="lblMontoFinal.Height = pnlMetaAhorro.Height * 0.2";
Debug.ShouldStop(524288);
_lblmontofinal.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlmetaahorro.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.25)}, "*",0, 0)));
 BA.debugLineNum = 245;BA.debugLine="lblMontoFinal.Width = pnlMetaAhorro.Width * 0.2";
Debug.ShouldStop(1048576);
_lblmontofinal.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlmetaahorro.runMethod(true,"getWidth"),RemoteObject.createImmutable(0.2)}, "*",0, 0)));
 BA.debugLineNum = 246;BA.debugLine="lblMontoFinal.Top = lblPeriodoYMonto.Top";
Debug.ShouldStop(2097152);
_lblmontofinal.runMethod(true,"setTop",_lblperiodoymonto.runMethod(true,"getTop"));
 BA.debugLineNum = 247;BA.debugLine="lblMontoFinal.Left = pnlMetaAhorro.Width - lblMon";
Debug.ShouldStop(4194304);
_lblmontofinal.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {_pnlmetaahorro.runMethod(true,"getWidth"),_lblmontofinal.runMethod(true,"getWidth"),_lblnombre.runMethod(true,"getLeft")}, "--",2, 1));
 BA.debugLineNum = 248;BA.debugLine="pnlMetaAhorro.AddView(lblMontoFinal, lblMontoFina";
Debug.ShouldStop(8388608);
_pnlmetaahorro.runVoidMethod ("AddView",(Object)((_lblmontofinal.getObject())),(Object)(_lblmontofinal.runMethod(true,"getLeft")),(Object)(_lblmontofinal.runMethod(true,"getTop")),(Object)(_lblmontofinal.runMethod(true,"getWidth")),(Object)(_lblmontofinal.runMethod(true,"getHeight")));
 BA.debugLineNum = 250;BA.debugLine="lblOpciones.Initialize(\"lblOpciones\")";
Debug.ShouldStop(33554432);
_lblopciones.runVoidMethod ("Initialize",metasdeahorro.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("lblOpciones")));
 BA.debugLineNum = 251;BA.debugLine="lblOpciones.Typeface = Typeface.FONTAWESOME";
Debug.ShouldStop(67108864);
_lblopciones.runMethod(false,"setTypeface",metasdeahorro.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"getFONTAWESOME"));
 BA.debugLineNum = 252;BA.debugLine="lblOpciones.Text = Chr(0xF142)";
Debug.ShouldStop(134217728);
_lblopciones.runMethod(true,"setText",BA.ObjectToCharSequence(metasdeahorro.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf142)))));
 BA.debugLineNum = 253;BA.debugLine="lblOpciones.TextSize = 18";
Debug.ShouldStop(268435456);
_lblopciones.runMethod(true,"setTextSize",BA.numberCast(float.class, 18));
 BA.debugLineNum = 254;BA.debugLine="lblOpciones.TextColor = Colors.White";
Debug.ShouldStop(536870912);
_lblopciones.runMethod(true,"setTextColor",metasdeahorro.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 255;BA.debugLine="lblOpciones.Height = lblNombre.Height";
Debug.ShouldStop(1073741824);
_lblopciones.runMethod(true,"setHeight",_lblnombre.runMethod(true,"getHeight"));
 BA.debugLineNum = 256;BA.debugLine="lblOpciones.Width = 8dip";
Debug.ShouldStop(-2147483648);
_lblopciones.runMethod(true,"setWidth",metasdeahorro.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 8))));
 BA.debugLineNum = 257;BA.debugLine="lblOpciones.Left = lblMontoFinal.Left + lblMontoF";
Debug.ShouldStop(1);
_lblopciones.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {_lblmontofinal.runMethod(true,"getLeft"),_lblmontofinal.runMethod(true,"getWidth"),_lblopciones.runMethod(true,"getWidth")}, "+-",2, 1));
 BA.debugLineNum = 258;BA.debugLine="lblOpciones.Top = pnlMetaAhorro.Height * 0.12";
Debug.ShouldStop(2);
_lblopciones.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlmetaahorro.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.12)}, "*",0, 0)));
 BA.debugLineNum = 259;BA.debugLine="pnlMetaAhorro.AddView(lblOpciones, lblOpciones.Le";
Debug.ShouldStop(4);
_pnlmetaahorro.runVoidMethod ("AddView",(Object)((_lblopciones.getObject())),(Object)(_lblopciones.runMethod(true,"getLeft")),(Object)(_lblopciones.runMethod(true,"getTop")),(Object)(_lblopciones.runMethod(true,"getWidth")),(Object)(_lblopciones.runMethod(true,"getHeight")));
 BA.debugLineNum = 261;BA.debugLine="pnlOpciones.Initialize(\"pnlOpciones\")";
Debug.ShouldStop(16);
_pnlopciones.runVoidMethod ("Initialize",metasdeahorro.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("pnlOpciones")));
 BA.debugLineNum = 262;BA.debugLine="cd.Initialize(Colors.Black, 20)";
Debug.ShouldStop(32);
_cd.runVoidMethod ("Initialize",(Object)(metasdeahorro.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.numberCast(int.class, 20)));
 BA.debugLineNum = 263;BA.debugLine="pnlOpciones.Background = cd";
Debug.ShouldStop(64);
_pnlopciones.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 264;BA.debugLine="pnlOpciones.Height = pnlMetaAhorro.Height * 0.8";
Debug.ShouldStop(128);
_pnlopciones.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlmetaahorro.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.8)}, "*",0, 0)));
 BA.debugLineNum = 265;BA.debugLine="pnlOpciones.Width = pnlMetaAhorro.Height";
Debug.ShouldStop(256);
_pnlopciones.runMethod(true,"setWidth",_pnlmetaahorro.runMethod(true,"getHeight"));
 BA.debugLineNum = 266;BA.debugLine="pnlOpciones.Top = lblOpciones.Top";
Debug.ShouldStop(512);
_pnlopciones.runMethod(true,"setTop",_lblopciones.runMethod(true,"getTop"));
 BA.debugLineNum = 267;BA.debugLine="pnlOpciones.Left = lblOpciones.Left - lblOpciones";
Debug.ShouldStop(1024);
_pnlopciones.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {_lblopciones.runMethod(true,"getLeft"),_lblopciones.runMethod(true,"getWidth"),RemoteObject.createImmutable(2),_pnlopciones.runMethod(true,"getWidth")}, "-*-",2, 1));
 BA.debugLineNum = 268;BA.debugLine="pnlOpciones.Visible = False";
Debug.ShouldStop(2048);
_pnlopciones.runMethod(true,"setVisible",metasdeahorro.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 269;BA.debugLine="pnlMetaAhorro.AddView(pnlOpciones, pnlOpciones.Le";
Debug.ShouldStop(4096);
_pnlmetaahorro.runVoidMethod ("AddView",(Object)((_pnlopciones.getObject())),(Object)(_pnlopciones.runMethod(true,"getLeft")),(Object)(_pnlopciones.runMethod(true,"getTop")),(Object)(_pnlopciones.runMethod(true,"getWidth")),(Object)(_pnlopciones.runMethod(true,"getHeight")));
 BA.debugLineNum = 271;BA.debugLine="btnEditar.Initialize(\"btnEditar\")";
Debug.ShouldStop(16384);
_btneditar.runVoidMethod ("Initialize",metasdeahorro.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("btnEditar")));
 BA.debugLineNum = 272;BA.debugLine="btnEditar.Color = Colors.Transparent";
Debug.ShouldStop(32768);
_btneditar.runVoidMethod ("setColor",metasdeahorro.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 273;BA.debugLine="btnEditar.Text = \"Editar\"";
Debug.ShouldStop(65536);
_btneditar.runMethod(true,"setText",BA.ObjectToCharSequence("Editar"));
 BA.debugLineNum = 274;BA.debugLine="btnEditar.TextColor = Colors.White";
Debug.ShouldStop(131072);
_btneditar.runMethod(true,"setTextColor",metasdeahorro.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 275;BA.debugLine="btnEditar.TextSize = 14";
Debug.ShouldStop(262144);
_btneditar.runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 276;BA.debugLine="btnEditar.Height = pnlOpciones.Height * 0.4";
Debug.ShouldStop(524288);
_btneditar.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlopciones.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.4)}, "*",0, 0)));
 BA.debugLineNum = 277;BA.debugLine="btnEditar.Width = pnlOpciones.Height * 0.8";
Debug.ShouldStop(1048576);
_btneditar.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlopciones.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.8)}, "*",0, 0)));
 BA.debugLineNum = 278;BA.debugLine="btnEditar.Top = (pnlOpciones.Height * 0.2) / 3";
Debug.ShouldStop(2097152);
_btneditar.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_pnlopciones.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.2)}, "*",0, 0)),RemoteObject.createImmutable(3)}, "/",0, 0)));
 BA.debugLineNum = 279;BA.debugLine="btnEditar.Left = (pnlOpciones.Width - btnEditar.W";
Debug.ShouldStop(4194304);
_btneditar.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_pnlopciones.runMethod(true,"getWidth"),_btneditar.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 280;BA.debugLine="pnlOpciones.AddView(btnEditar, btnEditar.Left, bt";
Debug.ShouldStop(8388608);
_pnlopciones.runVoidMethod ("AddView",(Object)((_btneditar.getObject())),(Object)(_btneditar.runMethod(true,"getLeft")),(Object)(_btneditar.runMethod(true,"getTop")),(Object)(_btneditar.runMethod(true,"getWidth")),(Object)(_btneditar.runMethod(true,"getHeight")));
 BA.debugLineNum = 282;BA.debugLine="btnEliminar.Initialize(\"btnEliminar\")";
Debug.ShouldStop(33554432);
_btneliminar.runVoidMethod ("Initialize",metasdeahorro.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("btnEliminar")));
 BA.debugLineNum = 283;BA.debugLine="btnEliminar.Color = Colors.Transparent";
Debug.ShouldStop(67108864);
_btneliminar.runVoidMethod ("setColor",metasdeahorro.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 284;BA.debugLine="btnEliminar.Text = \"Eliminar\"";
Debug.ShouldStop(134217728);
_btneliminar.runMethod(true,"setText",BA.ObjectToCharSequence("Eliminar"));
 BA.debugLineNum = 285;BA.debugLine="btnEliminar.TextColor = Colors.White";
Debug.ShouldStop(268435456);
_btneliminar.runMethod(true,"setTextColor",metasdeahorro.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 286;BA.debugLine="btnEliminar.TextSize = 14";
Debug.ShouldStop(536870912);
_btneliminar.runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 287;BA.debugLine="btnEliminar.Height = btnEditar.Height";
Debug.ShouldStop(1073741824);
_btneliminar.runMethod(true,"setHeight",_btneditar.runMethod(true,"getHeight"));
 BA.debugLineNum = 288;BA.debugLine="btnEliminar.Width = pnlOpciones.Width * 0.9";
Debug.ShouldStop(-2147483648);
_btneliminar.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pnlopciones.runMethod(true,"getWidth"),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 289;BA.debugLine="btnEliminar.Top = btnEditar.Top * 2 + btnEditar.H";
Debug.ShouldStop(1);
_btneliminar.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {_btneditar.runMethod(true,"getTop"),RemoteObject.createImmutable(2),_btneditar.runMethod(true,"getHeight")}, "*+",1, 1));
 BA.debugLineNum = 290;BA.debugLine="btnEliminar.Left = (pnlOpciones.Width - btnElimin";
Debug.ShouldStop(2);
_btneliminar.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_pnlopciones.runMethod(true,"getWidth"),_btneliminar.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 291;BA.debugLine="pnlOpciones.AddView(btnEliminar, btnEliminar.Left";
Debug.ShouldStop(4);
_pnlopciones.runVoidMethod ("AddView",(Object)((_btneliminar.getObject())),(Object)(_btneliminar.runMethod(true,"getLeft")),(Object)(_btneliminar.runMethod(true,"getTop")),(Object)(_btneliminar.runMethod(true,"getWidth")),(Object)(_btneliminar.runMethod(true,"getHeight")));
 BA.debugLineNum = 293;BA.debugLine="pnlDeslizable.AddView(pnlMetaAhorro, pnlMetaAhorr";
Debug.ShouldStop(16);
metasdeahorro.mostCurrent._pnldeslizable.runVoidMethod ("AddView",(Object)((_pnlmetaahorro.getObject())),(Object)(_pnlmetaahorro.runMethod(true,"getLeft")),(Object)(_top),(Object)(_pnlmetaahorro.runMethod(true,"getWidth")),(Object)(_pnlmetaahorro.runMethod(true,"getHeight")));
 BA.debugLineNum = 296;BA.debugLine="Dim referencia As IndiceSuscripcion";
Debug.ShouldStop(128);
_referencia = RemoteObject.createNew ("pullup.wallet.suscripciones._indicesuscripcion");Debug.locals.put("referencia", _referencia);
 BA.debugLineNum = 297;BA.debugLine="referencia.indiceElemento = indice";
Debug.ShouldStop(256);
_referencia.setField ("indiceElemento" /*RemoteObject*/ ,_indice);
 BA.debugLineNum = 298;BA.debugLine="referencia.rowid = 0";
Debug.ShouldStop(512);
_referencia.setField ("rowid" /*RemoteObject*/ ,BA.numberCast(int.class, 0));
 BA.debugLineNum = 300;BA.debugLine="lblOpciones.Tag = referencia";
Debug.ShouldStop(2048);
_lblopciones.runMethod(false,"setTag",(_referencia));
 BA.debugLineNum = 303;BA.debugLine="Dim referencia2 As IndiceSuscripcion";
Debug.ShouldStop(16384);
_referencia2 = RemoteObject.createNew ("pullup.wallet.suscripciones._indicesuscripcion");Debug.locals.put("referencia2", _referencia2);
 BA.debugLineNum = 304;BA.debugLine="referencia2.indiceElemento = 0";
Debug.ShouldStop(32768);
_referencia2.setField ("indiceElemento" /*RemoteObject*/ ,BA.numberCast(int.class, 0));
 BA.debugLineNum = 305;BA.debugLine="referencia2.rowid = datos.rowid";
Debug.ShouldStop(65536);
_referencia2.setField ("rowid" /*RemoteObject*/ ,_datos.getField(true,"rowid" /*RemoteObject*/ ));
 BA.debugLineNum = 307;BA.debugLine="pnlOpciones.Tag = referencia2";
Debug.ShouldStop(262144);
_pnlopciones.runMethod(false,"setTag",(_referencia2));
 BA.debugLineNum = 310;BA.debugLine="Relaciones(indice, 0) = lblOpciones";
Debug.ShouldStop(2097152);
metasdeahorro.mostCurrent._relaciones.setArrayElement (RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _lblopciones.getObject()),_indice,BA.numberCast(int.class, 0));
 BA.debugLineNum = 311;BA.debugLine="Relaciones(indice, 1) = pnlOpciones";
Debug.ShouldStop(4194304);
metasdeahorro.mostCurrent._relaciones.setArrayElement (RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _pnlopciones.getObject()),_indice,BA.numberCast(int.class, 1));
 BA.debugLineNum = 314;BA.debugLine="arrayPnlsOpciones(indice) = pnlOpciones";
Debug.ShouldStop(33554432);
metasdeahorro.mostCurrent._arraypnlsopciones.setArrayElement (RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _pnlopciones.getObject()),_indice);
 BA.debugLineNum = 315;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
 //BA.debugLineNum = 15;BA.debugLine="Type IndiceMetaAhorro(indiceElemento As Int, rowi";
;
 //BA.debugLineNum = 16;BA.debugLine="Type MetaAhorro(rowid As Int, nombre As String, m";
;
 //BA.debugLineNum = 17;BA.debugLine="Dim alturaDispositivo As Int";
metasdeahorro._alturadispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 18;BA.debugLine="Dim anchoDispositivo As Int";
metasdeahorro._anchodispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 19;BA.debugLine="Dim nRegistros As Int";
metasdeahorro._nregistros = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 20;BA.debugLine="Dim Relaciones(,) As B4XView";
metasdeahorro.mostCurrent._relaciones = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.B4XViewWrapper", new int[] {0,0}, new Object[]{});
 //BA.debugLineNum = 21;BA.debugLine="Dim arrayPnlsOpciones() As B4XView";
metasdeahorro.mostCurrent._arraypnlsopciones = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.B4XViewWrapper", new int[] {0}, new Object[]{});
 //BA.debugLineNum = 22;BA.debugLine="Private btnMenu As Button";
metasdeahorro.mostCurrent._btnmenu = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private lblContornoBoton As Label";
metasdeahorro.mostCurrent._lblcontornoboton = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private pnlNavInferior As Panel";
metasdeahorro.mostCurrent._pnlnavinferior = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private pnlDeslizable As Panel";
metasdeahorro.mostCurrent._pnldeslizable = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private svPantalla As ScrollView";
metasdeahorro.mostCurrent._svpantalla = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Dim cur As Cursor";
metasdeahorro.mostCurrent._cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Dim cs As CSBuilder";
metasdeahorro.mostCurrent._cs = RemoteObject.createNew ("anywheresoftware.b4a.objects.CSBuilder");
 //BA.debugLineNum = 29;BA.debugLine="Dim bmpTest As Bitmap";
metasdeahorro.mostCurrent._bmptest = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Dim cvsTest As Canvas";
metasdeahorro.mostCurrent._cvstest = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Dim stu As StringUtils";
metasdeahorro.mostCurrent._stu = RemoteObject.createNew ("anywheresoftware.b4a.objects.StringUtils");
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lblopciones_click() throws Exception{
try {
		Debug.PushSubsStack("lblOpciones_Click (metasdeahorro) ","metasdeahorro",13,metasdeahorro.mostCurrent.activityBA,metasdeahorro.mostCurrent,318);
if (RapidSub.canDelegate("lblopciones_click")) { return pullup.wallet.metasdeahorro.remoteMe.runUserSub(false, "metasdeahorro","lblopciones_click");}
RemoteObject _lblopcion = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _indice = RemoteObject.declareNull("pullup.wallet.suscripciones._indicesuscripcion");
int _contador = 0;
 BA.debugLineNum = 318;BA.debugLine="Sub lblOpciones_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 319;BA.debugLine="Dim lblOpcion As Label";
Debug.ShouldStop(1073741824);
_lblopcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblOpcion", _lblopcion);
 BA.debugLineNum = 320;BA.debugLine="Dim indice As IndiceSuscripcion";
Debug.ShouldStop(-2147483648);
_indice = RemoteObject.createNew ("pullup.wallet.suscripciones._indicesuscripcion");Debug.locals.put("indice", _indice);
 BA.debugLineNum = 322;BA.debugLine="lblOpcion = Sender";
Debug.ShouldStop(2);
_lblopcion = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), metasdeahorro.mostCurrent.__c.runMethod(false,"Sender",metasdeahorro.mostCurrent.activityBA));
 BA.debugLineNum = 323;BA.debugLine="indice = lblOpcion.Tag";
Debug.ShouldStop(4);
_indice = (_lblopcion.runMethod(false,"getTag"));Debug.locals.put("indice", _indice);
 BA.debugLineNum = 326;BA.debugLine="For contador = 0 To arrayPnlsOpciones.Length - 1";
Debug.ShouldStop(32);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {metasdeahorro.mostCurrent._arraypnlsopciones.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_contador = 0 ;
for (;(step5 > 0 && _contador <= limit5) || (step5 < 0 && _contador >= limit5) ;_contador = ((int)(0 + _contador + step5))  ) {
Debug.locals.put("contador", _contador);
 BA.debugLineNum = 327;BA.debugLine="If (contador <> indice.indiceElemento) Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("!",RemoteObject.createImmutable(_contador),BA.numberCast(double.class, _indice.getField(true,"indiceElemento" /*RemoteObject*/ ))))) { 
 BA.debugLineNum = 328;BA.debugLine="arrayPnlsOpciones(contador).Visible = False";
Debug.ShouldStop(128);
metasdeahorro.mostCurrent._arraypnlsopciones.getArrayElement(false,BA.numberCast(int.class, _contador)).runMethod(true,"setVisible",metasdeahorro.mostCurrent.__c.getField(true,"False"));
 };
 }
}Debug.locals.put("contador", _contador);
;
 BA.debugLineNum = 333;BA.debugLine="Relaciones(indice.indiceElemento, 1).SetVisibleAn";
Debug.ShouldStop(4096);
metasdeahorro.mostCurrent._relaciones.getArrayElement(false,_indice.getField(true,"indiceElemento" /*RemoteObject*/ ),BA.numberCast(int.class, 1)).runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 200)),(Object)(metasdeahorro.mostCurrent.__c.runMethod(true,"Not",(Object)(metasdeahorro.mostCurrent._relaciones.getArrayElement(false,_indice.getField(true,"indiceElemento" /*RemoteObject*/ ),BA.numberCast(int.class, 1)).runMethod(true,"getVisible")))));
 BA.debugLineNum = 334;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
metasdeahorro._sql = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}