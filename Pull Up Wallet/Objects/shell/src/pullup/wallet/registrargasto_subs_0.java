package pullup.wallet;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class registrargasto_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (registrargasto) ","registrargasto",14,registrargasto.mostCurrent.activityBA,registrargasto.mostCurrent,42);
if (RapidSub.canDelegate("activity_create")) { return pullup.wallet.registrargasto.remoteMe.runUserSub(false, "registrargasto","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 42;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(512);
 BA.debugLineNum = 43;BA.debugLine="Activity.LoadLayout(\"LFormGasto\")";
Debug.ShouldStop(1024);
registrargasto.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("LFormGasto")),registrargasto.mostCurrent.activityBA);
 BA.debugLineNum = 44;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
Debug.ShouldStop(2048);
registrargasto._alturadispositivo = registrargasto.mostCurrent._main._alturadispositivo /*RemoteObject*/ ;
 BA.debugLineNum = 45;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
Debug.ShouldStop(4096);
registrargasto._anchodispositivo = registrargasto.mostCurrent._main._anchodispositivo /*RemoteObject*/ ;
 BA.debugLineNum = 46;BA.debugLine="sql = Starter.sql";
Debug.ShouldStop(8192);
registrargasto._sql = registrargasto.mostCurrent._starter._sql /*RemoteObject*/ ;
 BA.debugLineNum = 47;BA.debugLine="aparicionMsgBox1 = False";
Debug.ShouldStop(16384);
registrargasto._aparicionmsgbox1 = registrargasto.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 48;BA.debugLine="aparicionMsgBox2 = False";
Debug.ShouldStop(32768);
registrargasto._aparicionmsgbox2 = registrargasto.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 49;BA.debugLine="aparicionMsgBox3 = False";
Debug.ShouldStop(65536);
registrargasto._aparicionmsgbox3 = registrargasto.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 50;BA.debugLine="colorCaja = 0";
Debug.ShouldStop(131072);
registrargasto._colorcaja = BA.numberCast(int.class, 0);
 BA.debugLineNum = 53;BA.debugLine="lblNombreVista.TextSize = 20";
Debug.ShouldStop(1048576);
registrargasto.mostCurrent._lblnombrevista.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 54;BA.debugLine="lblNombreVista.TextColor = Colors.Black";
Debug.ShouldStop(2097152);
registrargasto.mostCurrent._lblnombrevista.runMethod(true,"setTextColor",registrargasto.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 55;BA.debugLine="lblNombreVista.Height = 30dip";
Debug.ShouldStop(4194304);
registrargasto.mostCurrent._lblnombrevista.runMethod(true,"setHeight",registrargasto.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 56;BA.debugLine="lblNombreVista.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(8388608);
registrargasto.mostCurrent._lblnombrevista.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrargasto._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 57;BA.debugLine="lblNombreVista.Top = 30dip";
Debug.ShouldStop(16777216);
registrargasto.mostCurrent._lblnombrevista.runMethod(true,"setTop",registrargasto.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 58;BA.debugLine="lblNombreVista.Left = (anchoDispositivo - lblNomb";
Debug.ShouldStop(33554432);
registrargasto.mostCurrent._lblnombrevista.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registrargasto._anchodispositivo,registrargasto.mostCurrent._lblnombrevista.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 60;BA.debugLine="txtMonto.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(134217728);
registrargasto.mostCurrent._txtmonto.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrargasto._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 61;BA.debugLine="txtMonto.Height = alturaDispositivo * 0.25";
Debug.ShouldStop(268435456);
registrargasto.mostCurrent._txtmonto.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrargasto._alturadispositivo,RemoteObject.createImmutable(0.25)}, "*",0, 0)));
 BA.debugLineNum = 62;BA.debugLine="txtMonto.Top = lblNombreVista.Top * 2 + lblNombre";
Debug.ShouldStop(536870912);
registrargasto.mostCurrent._txtmonto.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {registrargasto.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2),registrargasto.mostCurrent._lblnombrevista.runMethod(true,"getHeight")}, "*+",1, 1));
 BA.debugLineNum = 63;BA.debugLine="txtMonto.Left = (anchoDispositivo - txtMonto.Widt";
Debug.ShouldStop(1073741824);
registrargasto.mostCurrent._txtmonto.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registrargasto._anchodispositivo,registrargasto.mostCurrent._txtmonto.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 64;BA.debugLine="lblFondoMonto.Width = txtMonto.Width";
Debug.ShouldStop(-2147483648);
registrargasto.mostCurrent._lblfondomonto.runMethod(true,"setWidth",registrargasto.mostCurrent._txtmonto.runMethod(true,"getWidth"));
 BA.debugLineNum = 65;BA.debugLine="lblFondoMonto.Height = txtMonto.Height";
Debug.ShouldStop(1);
registrargasto.mostCurrent._lblfondomonto.runMethod(true,"setHeight",registrargasto.mostCurrent._txtmonto.runMethod(true,"getHeight"));
 BA.debugLineNum = 66;BA.debugLine="lblFondoMonto.Top = txtMonto.Top";
Debug.ShouldStop(2);
registrargasto.mostCurrent._lblfondomonto.runMethod(true,"setTop",registrargasto.mostCurrent._txtmonto.runMethod(true,"getTop"));
 BA.debugLineNum = 67;BA.debugLine="lblFondoMonto.Left = txtMonto.Left";
Debug.ShouldStop(4);
registrargasto.mostCurrent._lblfondomonto.runMethod(true,"setLeft",registrargasto.mostCurrent._txtmonto.runMethod(true,"getLeft"));
 BA.debugLineNum = 69;BA.debugLine="txtNombre.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(16);
registrargasto.mostCurrent._txtnombre.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrargasto._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 70;BA.debugLine="txtNombre.Height = alturaDispositivo * 0.1";
Debug.ShouldStop(32);
registrargasto.mostCurrent._txtnombre.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrargasto._alturadispositivo,RemoteObject.createImmutable(0.1)}, "*",0, 0)));
 BA.debugLineNum = 71;BA.debugLine="txtNombre.Top = txtMonto.Top + txtMonto.Height +";
Debug.ShouldStop(64);
registrargasto.mostCurrent._txtnombre.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {registrargasto.mostCurrent._txtmonto.runMethod(true,"getTop"),registrargasto.mostCurrent._txtmonto.runMethod(true,"getHeight"),registrargasto.mostCurrent._lblnombrevista.runMethod(true,"getTop")}, "++",2, 1));
 BA.debugLineNum = 72;BA.debugLine="txtNombre.Left = (anchoDispositivo - txtNombre.Wi";
Debug.ShouldStop(128);
registrargasto.mostCurrent._txtnombre.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registrargasto._anchodispositivo,registrargasto.mostCurrent._txtnombre.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 73;BA.debugLine="lblFondoNombre.Width = txtMonto.Width";
Debug.ShouldStop(256);
registrargasto.mostCurrent._lblfondonombre.runMethod(true,"setWidth",registrargasto.mostCurrent._txtmonto.runMethod(true,"getWidth"));
 BA.debugLineNum = 74;BA.debugLine="lblFondoNombre.Height = txtNombre.Height";
Debug.ShouldStop(512);
registrargasto.mostCurrent._lblfondonombre.runMethod(true,"setHeight",registrargasto.mostCurrent._txtnombre.runMethod(true,"getHeight"));
 BA.debugLineNum = 75;BA.debugLine="lblFondoNombre.Top = txtNombre.Top";
Debug.ShouldStop(1024);
registrargasto.mostCurrent._lblfondonombre.runMethod(true,"setTop",registrargasto.mostCurrent._txtnombre.runMethod(true,"getTop"));
 BA.debugLineNum = 76;BA.debugLine="lblFondoNombre.Left = txtNombre.Left";
Debug.ShouldStop(2048);
registrargasto.mostCurrent._lblfondonombre.runMethod(true,"setLeft",registrargasto.mostCurrent._txtnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 78;BA.debugLine="pnlSelector.Top = txtNombre.Top + txtNombre.Heigh";
Debug.ShouldStop(8192);
registrargasto.mostCurrent._pnlselector.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {registrargasto.mostCurrent._txtnombre.runMethod(true,"getTop"),registrargasto.mostCurrent._txtnombre.runMethod(true,"getHeight"),registrargasto.mostCurrent._lblnombrevista.runMethod(true,"getTop")}, "++",2, 1));
 BA.debugLineNum = 79;BA.debugLine="pnlSelector.Left = txtNombre.Left + txtNombre.Wid";
Debug.ShouldStop(16384);
registrargasto.mostCurrent._pnlselector.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {registrargasto.mostCurrent._txtnombre.runMethod(true,"getLeft"),registrargasto.mostCurrent._txtnombre.runMethod(true,"getWidth"),registrargasto.mostCurrent._pnlselector.runMethod(true,"getWidth")}, "+-",2, 1));
 BA.debugLineNum = 81;BA.debugLine="txtDescripcion.Width = (txtNombre.Width - pnlSele";
Debug.ShouldStop(65536);
registrargasto.mostCurrent._txtdescripcion.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registrargasto.mostCurrent._txtnombre.runMethod(true,"getWidth"),registrargasto.mostCurrent._pnlselector.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 82;BA.debugLine="txtDescripcion.Height = pnlSelector.Height";
Debug.ShouldStop(131072);
registrargasto.mostCurrent._txtdescripcion.runMethod(true,"setHeight",registrargasto.mostCurrent._pnlselector.runMethod(true,"getHeight"));
 BA.debugLineNum = 83;BA.debugLine="txtDescripcion.Top = pnlSelector.Top";
Debug.ShouldStop(262144);
registrargasto.mostCurrent._txtdescripcion.runMethod(true,"setTop",registrargasto.mostCurrent._pnlselector.runMethod(true,"getTop"));
 BA.debugLineNum = 84;BA.debugLine="txtDescripcion.Left = txtNombre.Left";
Debug.ShouldStop(524288);
registrargasto.mostCurrent._txtdescripcion.runMethod(true,"setLeft",registrargasto.mostCurrent._txtnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 85;BA.debugLine="lblFondoDescripcion.Width = txtDescripcion.Width";
Debug.ShouldStop(1048576);
registrargasto.mostCurrent._lblfondodescripcion.runMethod(true,"setWidth",registrargasto.mostCurrent._txtdescripcion.runMethod(true,"getWidth"));
 BA.debugLineNum = 86;BA.debugLine="lblFondoDescripcion.Height = txtDescripcion.Heigh";
Debug.ShouldStop(2097152);
registrargasto.mostCurrent._lblfondodescripcion.runMethod(true,"setHeight",registrargasto.mostCurrent._txtdescripcion.runMethod(true,"getHeight"));
 BA.debugLineNum = 87;BA.debugLine="lblFondoDescripcion.Top = txtDescripcion.Top";
Debug.ShouldStop(4194304);
registrargasto.mostCurrent._lblfondodescripcion.runMethod(true,"setTop",registrargasto.mostCurrent._txtdescripcion.runMethod(true,"getTop"));
 BA.debugLineNum = 88;BA.debugLine="lblFondoDescripcion.Left = txtDescripcion.Left";
Debug.ShouldStop(8388608);
registrargasto.mostCurrent._lblfondodescripcion.runMethod(true,"setLeft",registrargasto.mostCurrent._txtdescripcion.runMethod(true,"getLeft"));
 BA.debugLineNum = 93;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
Debug.ShouldStop(268435456);
registrargasto.mostCurrent._pnlnavinferior.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrargasto._alturadispositivo,RemoteObject.createImmutable(0.08)}, "*",0, 0)));
 BA.debugLineNum = 94;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
Debug.ShouldStop(536870912);
registrargasto.mostCurrent._pnlnavinferior.runMethod(true,"setWidth",registrargasto._anchodispositivo);
 BA.debugLineNum = 95;BA.debugLine="pnlNavInferior.Left = 0";
Debug.ShouldStop(1073741824);
registrargasto.mostCurrent._pnlnavinferior.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 96;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
Debug.ShouldStop(-2147483648);
registrargasto.mostCurrent._pnlnavinferior.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {registrargasto._alturadispositivo,registrargasto.mostCurrent._pnlnavinferior.runMethod(true,"getHeight")}, "-",1, 1));
 BA.debugLineNum = 99;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
Debug.ShouldStop(4);
registrargasto.mostCurrent._btnmenu.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrargasto._anchodispositivo,RemoteObject.createImmutable(0.15)}, "*",0, 0)));
 BA.debugLineNum = 100;BA.debugLine="btnMenu.Height = btnMenu.Width";
Debug.ShouldStop(8);
registrargasto.mostCurrent._btnmenu.runMethod(true,"setHeight",registrargasto.mostCurrent._btnmenu.runMethod(true,"getWidth"));
 BA.debugLineNum = 101;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
Debug.ShouldStop(16);
registrargasto.mostCurrent._btnmenu.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrargasto.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),registrargasto.mostCurrent._btnmenu.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 102;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
Debug.ShouldStop(32);
registrargasto.mostCurrent._btnmenu.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registrargasto._anchodispositivo,registrargasto.mostCurrent._btnmenu.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 104;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
Debug.ShouldStop(128);
registrargasto.mostCurrent._lblcontornoboton.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrargasto._anchodispositivo,RemoteObject.createImmutable(0.17)}, "*",0, 0)));
 BA.debugLineNum = 105;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
Debug.ShouldStop(256);
registrargasto.mostCurrent._lblcontornoboton.runMethod(true,"setHeight",registrargasto.mostCurrent._lblcontornoboton.runMethod(true,"getWidth"));
 BA.debugLineNum = 106;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
Debug.ShouldStop(512);
registrargasto.mostCurrent._lblcontornoboton.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registrargasto._anchodispositivo,registrargasto.mostCurrent._lblcontornoboton.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 107;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
Debug.ShouldStop(1024);
registrargasto.mostCurrent._lblcontornoboton.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrargasto.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),registrargasto.mostCurrent._lblcontornoboton.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 112;BA.debugLine="btnOperacionGasto.Text = \"Guardar gasto\"";
Debug.ShouldStop(32768);
registrargasto.mostCurrent._btnoperaciongasto.runMethod(true,"setText",BA.ObjectToCharSequence("Guardar gasto"));
 BA.debugLineNum = 113;BA.debugLine="btnOperacionGasto.Top = txtDescripcion.Top + txtD";
Debug.ShouldStop(65536);
registrargasto.mostCurrent._btnoperaciongasto.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrargasto.mostCurrent._txtdescripcion.runMethod(true,"getTop"),registrargasto.mostCurrent._txtdescripcion.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {registrargasto.mostCurrent._lblcontornoboton.runMethod(true,"getTop"),(RemoteObject.solve(new RemoteObject[] {registrargasto.mostCurrent._txtdescripcion.runMethod(true,"getTop"),registrargasto.mostCurrent._txtdescripcion.runMethod(true,"getHeight"),registrargasto.mostCurrent._btnoperaciongasto.runMethod(true,"getHeight")}, "++",2, 1))}, "-",1, 1)),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 114;BA.debugLine="btnOperacionGasto.Left = (anchoDispositivo - btnO";
Debug.ShouldStop(131072);
registrargasto.mostCurrent._btnoperaciongasto.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registrargasto._anchodispositivo,registrargasto.mostCurrent._btnoperaciongasto.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 115;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("Activity_Pause (registrargasto) ","registrargasto",14,registrargasto.mostCurrent.activityBA,registrargasto.mostCurrent,121);
if (RapidSub.canDelegate("activity_pause")) { return pullup.wallet.registrargasto.remoteMe.runUserSub(false, "registrargasto","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 121;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 123;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("Activity_Resume (registrargasto) ","registrargasto",14,registrargasto.mostCurrent.activityBA,registrargasto.mostCurrent,117);
if (RapidSub.canDelegate("activity_resume")) { return pullup.wallet.registrargasto.remoteMe.runUserSub(false, "registrargasto","activity_resume");}
 BA.debugLineNum = 117;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 119;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _asignacioncampos() throws Exception{
try {
		Debug.PushSubsStack("asignacionCampos (registrargasto) ","registrargasto",14,registrargasto.mostCurrent.activityBA,registrargasto.mostCurrent,191);
if (RapidSub.canDelegate("asignacioncampos")) { return pullup.wallet.registrargasto.remoteMe.runUserSub(false, "registrargasto","asignacioncampos");}
RemoteObject _gasto = RemoteObject.declareNull("pullup.wallet.main._registrogasto");
 BA.debugLineNum = 191;BA.debugLine="Sub asignacionCampos As RegistroGasto";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 192;BA.debugLine="Dim gasto As RegistroGasto";
Debug.ShouldStop(-2147483648);
_gasto = RemoteObject.createNew ("pullup.wallet.main._registrogasto");Debug.locals.put("gasto", _gasto);
 BA.debugLineNum = 194;BA.debugLine="gasto.monto = txtMonto.Text";
Debug.ShouldStop(2);
_gasto.setField ("monto" /*RemoteObject*/ ,BA.numberCast(int.class, registrargasto.mostCurrent._txtmonto.runMethod(true,"getText")));
 BA.debugLineNum = 196;BA.debugLine="gasto.nombre = txtNombre.Text";
Debug.ShouldStop(8);
_gasto.setField ("nombre" /*RemoteObject*/ ,registrargasto.mostCurrent._txtnombre.runMethod(true,"getText"));
 BA.debugLineNum = 198;BA.debugLine="gasto.descripcion = (txtDescripcion.Text)";
Debug.ShouldStop(32);
_gasto.setField ("descripcion" /*RemoteObject*/ ,(registrargasto.mostCurrent._txtdescripcion.runMethod(true,"getText")));
 BA.debugLineNum = 200;BA.debugLine="gasto.fechaRegistro = obtenerFechaActual";
Debug.ShouldStop(128);
_gasto.setField ("fechaRegistro" /*RemoteObject*/ ,_obtenerfechaactual());
 BA.debugLineNum = 202;BA.debugLine="gasto.color = colorCaja";
Debug.ShouldStop(512);
_gasto.setField ("color" /*RemoteObject*/ ,registrargasto._colorcaja);
 BA.debugLineNum = 204;BA.debugLine="Return gasto";
Debug.ShouldStop(2048);
if (true) return _gasto;
 BA.debugLineNum = 205;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnmenu_click() throws Exception{
try {
		Debug.PushSubsStack("btnMenu_Click (registrargasto) ","registrargasto",14,registrargasto.mostCurrent.activityBA,registrargasto.mostCurrent,125);
if (RapidSub.canDelegate("btnmenu_click")) { return pullup.wallet.registrargasto.remoteMe.runUserSub(false, "registrargasto","btnmenu_click");}
 BA.debugLineNum = 125;BA.debugLine="Private Sub btnMenu_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 126;BA.debugLine="Activity.Finish";
Debug.ShouldStop(536870912);
registrargasto.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 127;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnoperaciongasto_click() throws Exception{
try {
		Debug.PushSubsStack("btnOperacionGasto_Click (registrargasto) ","registrargasto",14,registrargasto.mostCurrent.activityBA,registrargasto.mostCurrent,209);
if (RapidSub.canDelegate("btnoperaciongasto_click")) { return pullup.wallet.registrargasto.remoteMe.runUserSub(false, "registrargasto","btnoperaciongasto_click");}
RemoteObject _cur = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _validaciones = RemoteObject.createImmutable(false);
RemoteObject _egresosactuales = RemoteObject.createImmutable(0);
RemoteObject _gastoregistrar = RemoteObject.declareNull("pullup.wallet.main._registrogasto");
 BA.debugLineNum = 209;BA.debugLine="Private Sub btnOperacionGasto_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 210;BA.debugLine="Dim cur As Cursor";
Debug.ShouldStop(131072);
_cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("cur", _cur);
 BA.debugLineNum = 211;BA.debugLine="Dim validaciones As Boolean";
Debug.ShouldStop(262144);
_validaciones = RemoteObject.createImmutable(false);Debug.locals.put("validaciones", _validaciones);
 BA.debugLineNum = 212;BA.debugLine="Dim egresosActuales As Int";
Debug.ShouldStop(524288);
_egresosactuales = RemoteObject.createImmutable(0);Debug.locals.put("egresosActuales", _egresosactuales);
 BA.debugLineNum = 214;BA.debugLine="validaciones = validarCampos";
Debug.ShouldStop(2097152);
_validaciones = _validarcampos();Debug.locals.put("validaciones", _validaciones);
 BA.debugLineNum = 215;BA.debugLine="If(validaciones = True) Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("=",_validaciones,registrargasto.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 217;BA.debugLine="Dim gastoRegistrar As RegistroGasto";
Debug.ShouldStop(16777216);
_gastoregistrar = RemoteObject.createNew ("pullup.wallet.main._registrogasto");Debug.locals.put("gastoRegistrar", _gastoregistrar);
 BA.debugLineNum = 218;BA.debugLine="gastoRegistrar = asignacionCampos";
Debug.ShouldStop(33554432);
_gastoregistrar = _asignacioncampos();Debug.locals.put("gastoRegistrar", _gastoregistrar);
 BA.debugLineNum = 221;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO gastos (monto, no";
Debug.ShouldStop(268435456);
registrargasto._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO gastos (monto, nombre, descripcion, fecha_registro, color) VALUES (?, ?, ?, ?, ?)")),(Object)(registrargasto.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {(_gastoregistrar.getField(true,"monto" /*RemoteObject*/ )),(_gastoregistrar.getField(true,"nombre" /*RemoteObject*/ )),(_gastoregistrar.getField(true,"descripcion" /*RemoteObject*/ )),(_gastoregistrar.getField(true,"fechaRegistro" /*RemoteObject*/ )),(_gastoregistrar.getField(true,"color" /*RemoteObject*/ ))})))));
 BA.debugLineNum = 225;BA.debugLine="cur = sql.ExecQuery(\"SELECT suma_egresos FROM eg";
Debug.ShouldStop(1);
_cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), registrargasto._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT suma_egresos FROM egresos"))));
 BA.debugLineNum = 226;BA.debugLine="cur.Position = 0";
Debug.ShouldStop(2);
_cur.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 227;BA.debugLine="egresosActuales = cur.GetInt(\"suma_egresos\")";
Debug.ShouldStop(4);
_egresosactuales = _cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("suma_egresos")));Debug.locals.put("egresosActuales", _egresosactuales);
 BA.debugLineNum = 230;BA.debugLine="sql.ExecNonQuery2(\"UPDATE egresos SET suma_egres";
Debug.ShouldStop(32);
registrargasto._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE egresos SET suma_egresos = ? WHERE id_egreso = 1")),(Object)(registrargasto.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {((RemoteObject.solve(new RemoteObject[] {_egresosactuales,_gastoregistrar.getField(true,"monto" /*RemoteObject*/ )}, "+",1, 1)))})))));
 BA.debugLineNum = 232;BA.debugLine="ToastMessageShow(\"Gasto registrado\",True)";
Debug.ShouldStop(128);
registrargasto.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Gasto registrado")),(Object)(registrargasto.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 234;BA.debugLine="Activity.Finish";
Debug.ShouldStop(512);
registrargasto.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 236;BA.debugLine="StartActivity(Gastos)";
Debug.ShouldStop(2048);
registrargasto.mostCurrent.__c.runVoidMethod ("StartActivity",registrargasto.processBA,(Object)((registrargasto.mostCurrent._gastos.getObject())));
 }else {
 BA.debugLineNum = 239;BA.debugLine="Msgbox2(\"Por favor, rellene todos los campos y s";
Debug.ShouldStop(16384);
registrargasto.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("Por favor, rellene todos los campos y seleccione un color")),(Object)(BA.ObjectToCharSequence("Registro incorrecto")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((registrargasto.mostCurrent.__c.getField(false,"Null"))),registrargasto.mostCurrent.activityBA);
 };
 BA.debugLineNum = 241;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cpbarracolor_colorchanged(RemoteObject _color) throws Exception{
try {
		Debug.PushSubsStack("cpBarraColor_ColorChanged (registrargasto) ","registrargasto",14,registrargasto.mostCurrent.activityBA,registrargasto.mostCurrent,185);
if (RapidSub.canDelegate("cpbarracolor_colorchanged")) { return pullup.wallet.registrargasto.remoteMe.runUserSub(false, "registrargasto","cpbarracolor_colorchanged", _color);}
Debug.locals.put("color", _color);
 BA.debugLineNum = 185;BA.debugLine="Sub cpBarraColor_ColorChanged(color As Int)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 186;BA.debugLine="lblFondoMonto.Color = color  'Devuelve la variabl";
Debug.ShouldStop(33554432);
registrargasto.mostCurrent._lblfondomonto.runVoidMethod ("setColor",_color);
 BA.debugLineNum = 187;BA.debugLine="colorCaja = color";
Debug.ShouldStop(67108864);
registrargasto._colorcaja = _color;
 BA.debugLineNum = 188;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
 //BA.debugLineNum = 14;BA.debugLine="Dim alturaDispositivo As Int";
registrargasto._alturadispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 15;BA.debugLine="Dim anchoDispositivo As Int";
registrargasto._anchodispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 16;BA.debugLine="Dim colorCaja As Int";
registrargasto._colorcaja = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 17;BA.debugLine="Dim aparicionMsgBox1 As Boolean";
registrargasto._aparicionmsgbox1 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 18;BA.debugLine="Dim aparicionMsgBox2 As Boolean";
registrargasto._aparicionmsgbox2 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 19;BA.debugLine="Dim aparicionMsgBox3 As Boolean";
registrargasto._aparicionmsgbox3 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 23;BA.debugLine="Private btnMenu As Button";
registrargasto.mostCurrent._btnmenu = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private btnOperacionGasto As Button";
registrargasto.mostCurrent._btnoperaciongasto = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private txtDescripcion As EditText";
registrargasto.mostCurrent._txtdescripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private txtMonto As EditText";
registrargasto.mostCurrent._txtmonto = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private txtNombre As EditText";
registrargasto.mostCurrent._txtnombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private lblFondoMonto As Label";
registrargasto.mostCurrent._lblfondomonto = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private lblFondoDescripcion As Label";
registrargasto.mostCurrent._lblfondodescripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private lblFondoNombre As Label";
registrargasto.mostCurrent._lblfondonombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private lblContornoBoton As Label";
registrargasto.mostCurrent._lblcontornoboton = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private lblNombreVista As Label";
registrargasto.mostCurrent._lblnombrevista = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private pnlNavInferior As Panel";
registrargasto.mostCurrent._pnlnavinferior = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private pnlSelector As Panel";
registrargasto.mostCurrent._pnlselector = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private cpBarraColor As ASColorSlider  'Miembro g";
registrargasto.mostCurrent._cpbarracolor = RemoteObject.createNew ("pullup.wallet.ascolorslider");
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _limitarlongitudentrada(RemoteObject _antiguo,RemoteObject _nuevo,RemoteObject _longitud,RemoteObject _view,RemoteObject _campo) throws Exception{
try {
		Debug.PushSubsStack("limitarLongitudEntrada (registrargasto) ","registrargasto",14,registrargasto.mostCurrent.activityBA,registrargasto.mostCurrent,140);
if (RapidSub.canDelegate("limitarlongitudentrada")) { return pullup.wallet.registrargasto.remoteMe.runUserSub(false, "registrargasto","limitarlongitudentrada", _antiguo, _nuevo, _longitud, _view, _campo);}
Debug.locals.put("antiguo", _antiguo);
Debug.locals.put("nuevo", _nuevo);
Debug.locals.put("longitud", _longitud);
Debug.locals.put("view", _view);
Debug.locals.put("campo", _campo);
 BA.debugLineNum = 140;BA.debugLine="Sub limitarLongitudEntrada(antiguo As String, nuev";
Debug.ShouldStop(2048);
 BA.debugLineNum = 141;BA.debugLine="If(nuevo.Length > longitud) Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean(">",_nuevo.runMethod(true,"length"),BA.numberCast(double.class, _longitud)))) { 
 BA.debugLineNum = 142;BA.debugLine="If(campo = \"monto\") Then";
Debug.ShouldStop(8192);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("monto")))) { 
 BA.debugLineNum = 143;BA.debugLine="If(aparicionMsgBox1 = False) Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("=",registrargasto._aparicionmsgbox1,registrargasto.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 144;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
Debug.ShouldStop(32768);
registrargasto.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para el monto es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((registrargasto.mostCurrent.__c.getField(false,"Null"))),registrargasto.mostCurrent.activityBA);
 BA.debugLineNum = 145;BA.debugLine="aparicionMsgBox1 = True";
Debug.ShouldStop(65536);
registrargasto._aparicionmsgbox1 = registrargasto.mostCurrent.__c.getField(true,"True");
 };
 }else 
{ BA.debugLineNum = 147;BA.debugLine="Else If(campo = \"nombre\") Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("nombre")))) { 
 BA.debugLineNum = 148;BA.debugLine="If(aparicionMsgBox2 = False) Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",registrargasto._aparicionmsgbox2,registrargasto.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 149;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
Debug.ShouldStop(1048576);
registrargasto.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para el nombre es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((registrargasto.mostCurrent.__c.getField(false,"Null"))),registrargasto.mostCurrent.activityBA);
 BA.debugLineNum = 150;BA.debugLine="aparicionMsgBox2 = True";
Debug.ShouldStop(2097152);
registrargasto._aparicionmsgbox2 = registrargasto.mostCurrent.__c.getField(true,"True");
 };
 }else 
{ BA.debugLineNum = 152;BA.debugLine="Else If(campo = \"descripcion\") Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("descripcion")))) { 
 BA.debugLineNum = 153;BA.debugLine="If(aparicionMsgBox3 = False) Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",registrargasto._aparicionmsgbox3,registrargasto.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 154;BA.debugLine="Msgbox2(\"La longitud máxima permitida para la";
Debug.ShouldStop(33554432);
registrargasto.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para la descripción es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((registrargasto.mostCurrent.__c.getField(false,"Null"))),registrargasto.mostCurrent.activityBA);
 BA.debugLineNum = 155;BA.debugLine="aparicionMsgBox3 = True";
Debug.ShouldStop(67108864);
registrargasto._aparicionmsgbox3 = registrargasto.mostCurrent.__c.getField(true,"True");
 };
 }}}
;
 BA.debugLineNum = 158;BA.debugLine="view.Text = antiguo";
Debug.ShouldStop(536870912);
_view.runMethod(true,"setText",BA.ObjectToCharSequence(_antiguo));
 };
 BA.debugLineNum = 160;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _obtenerfechaactual() throws Exception{
try {
		Debug.PushSubsStack("obtenerFechaActual (registrargasto) ","registrargasto",14,registrargasto.mostCurrent.activityBA,registrargasto.mostCurrent,176);
if (RapidSub.canDelegate("obtenerfechaactual")) { return pullup.wallet.registrargasto.remoteMe.runUserSub(false, "registrargasto","obtenerfechaactual");}
RemoteObject _ahora = RemoteObject.createImmutable(0L);
 BA.debugLineNum = 176;BA.debugLine="Sub obtenerFechaActual As String";
Debug.ShouldStop(32768);
 BA.debugLineNum = 177;BA.debugLine="Dim ahora As Long";
Debug.ShouldStop(65536);
_ahora = RemoteObject.createImmutable(0L);Debug.locals.put("ahora", _ahora);
 BA.debugLineNum = 178;BA.debugLine="ahora = DateTime.Now";
Debug.ShouldStop(131072);
_ahora = registrargasto.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow");Debug.locals.put("ahora", _ahora);
 BA.debugLineNum = 179;BA.debugLine="Return (DateTime.Date(ahora))";
Debug.ShouldStop(262144);
if (true) return (registrargasto.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(_ahora)));
 BA.debugLineNum = 181;BA.debugLine="End Sub";
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
registrargasto._sql = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _txtdescripcion_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtDescripcion_TextChanged (registrargasto) ","registrargasto",14,registrargasto.mostCurrent.activityBA,registrargasto.mostCurrent,171);
if (RapidSub.canDelegate("txtdescripcion_textchanged")) { return pullup.wallet.registrargasto.remoteMe.runUserSub(false, "registrargasto","txtdescripcion_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 171;BA.debugLine="Private Sub txtDescripcion_TextChanged (Old As Str";
Debug.ShouldStop(1024);
 BA.debugLineNum = 172;BA.debugLine="limitarLongitudEntrada(Old, New, 41, txtDescripci";
Debug.ShouldStop(2048);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 41),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), registrargasto.mostCurrent._txtdescripcion.getObject()),RemoteObject.createImmutable("descripcion"));
 BA.debugLineNum = 173;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtmonto_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtMonto_TextChanged (registrargasto) ","registrargasto",14,registrargasto.mostCurrent.activityBA,registrargasto.mostCurrent,163);
if (RapidSub.canDelegate("txtmonto_textchanged")) { return pullup.wallet.registrargasto.remoteMe.runUserSub(false, "registrargasto","txtmonto_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 163;BA.debugLine="Private Sub txtMonto_TextChanged (Old As String, N";
Debug.ShouldStop(4);
 BA.debugLineNum = 164;BA.debugLine="limitarLongitudEntrada(Old, New, 9, txtMonto, \"mo";
Debug.ShouldStop(8);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 9),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), registrargasto.mostCurrent._txtmonto.getObject()),RemoteObject.createImmutable("monto"));
 BA.debugLineNum = 165;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtnombre_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtNombre_TextChanged (registrargasto) ","registrargasto",14,registrargasto.mostCurrent.activityBA,registrargasto.mostCurrent,167);
if (RapidSub.canDelegate("txtnombre_textchanged")) { return pullup.wallet.registrargasto.remoteMe.runUserSub(false, "registrargasto","txtnombre_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 167;BA.debugLine="Private Sub txtNombre_TextChanged (Old As String,";
Debug.ShouldStop(64);
 BA.debugLineNum = 168;BA.debugLine="limitarLongitudEntrada(Old, New, 16, txtNombre, \"";
Debug.ShouldStop(128);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 16),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), registrargasto.mostCurrent._txtnombre.getObject()),RemoteObject.createImmutable("nombre"));
 BA.debugLineNum = 169;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _validarcampos() throws Exception{
try {
		Debug.PushSubsStack("validarCampos (registrargasto) ","registrargasto",14,registrargasto.mostCurrent.activityBA,registrargasto.mostCurrent,130);
if (RapidSub.canDelegate("validarcampos")) { return pullup.wallet.registrargasto.remoteMe.runUserSub(false, "registrargasto","validarcampos");}
 BA.debugLineNum = 130;BA.debugLine="Sub validarCampos As Boolean";
Debug.ShouldStop(2);
 BA.debugLineNum = 131;BA.debugLine="If(txtMonto.Text.Length <> 0 And txtNombre.Text.L";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("!",registrargasto.mostCurrent._txtmonto.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",registrargasto.mostCurrent._txtnombre.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",registrargasto.mostCurrent._txtdescripcion.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",registrargasto._colorcaja,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 132;BA.debugLine="Return True";
Debug.ShouldStop(8);
if (true) return registrargasto.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 134;BA.debugLine="Return False";
Debug.ShouldStop(32);
if (true) return registrargasto.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 136;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}