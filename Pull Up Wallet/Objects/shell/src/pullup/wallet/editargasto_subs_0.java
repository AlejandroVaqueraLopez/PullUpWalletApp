package pullup.wallet;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class editargasto_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (editargasto) ","editargasto",4,editargasto.mostCurrent.activityBA,editargasto.mostCurrent,48);
if (RapidSub.canDelegate("activity_create")) { return pullup.wallet.editargasto.remoteMe.runUserSub(false, "editargasto","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 48;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 49;BA.debugLine="Activity.LoadLayout(\"LFormGasto\")";
Debug.ShouldStop(65536);
editargasto.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("LFormGasto")),editargasto.mostCurrent.activityBA);
 BA.debugLineNum = 50;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
Debug.ShouldStop(131072);
editargasto._alturadispositivo = editargasto.mostCurrent._main._alturadispositivo /*RemoteObject*/ ;
 BA.debugLineNum = 51;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
Debug.ShouldStop(262144);
editargasto._anchodispositivo = editargasto.mostCurrent._main._anchodispositivo /*RemoteObject*/ ;
 BA.debugLineNum = 52;BA.debugLine="sql = Starter.sql";
Debug.ShouldStop(524288);
editargasto._sql = editargasto.mostCurrent._starter._sql /*RemoteObject*/ ;
 BA.debugLineNum = 53;BA.debugLine="aparicionMsgBox1 = False";
Debug.ShouldStop(1048576);
editargasto._aparicionmsgbox1 = editargasto.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 54;BA.debugLine="aparicionMsgBox2 = False";
Debug.ShouldStop(2097152);
editargasto._aparicionmsgbox2 = editargasto.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 55;BA.debugLine="aparicionMsgBox3 = False";
Debug.ShouldStop(4194304);
editargasto._aparicionmsgbox3 = editargasto.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 56;BA.debugLine="colorCaja = 0";
Debug.ShouldStop(8388608);
editargasto._colorcaja = BA.numberCast(int.class, 0);
 BA.debugLineNum = 60;BA.debugLine="lblNombreVista.TextSize = 20";
Debug.ShouldStop(134217728);
editargasto.mostCurrent._lblnombrevista.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 61;BA.debugLine="lblNombreVista.TextColor = Colors.Black";
Debug.ShouldStop(268435456);
editargasto.mostCurrent._lblnombrevista.runMethod(true,"setTextColor",editargasto.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 62;BA.debugLine="lblNombreVista.Height = 30dip";
Debug.ShouldStop(536870912);
editargasto.mostCurrent._lblnombrevista.runMethod(true,"setHeight",editargasto.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 63;BA.debugLine="lblNombreVista.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(1073741824);
editargasto.mostCurrent._lblnombrevista.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editargasto._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 64;BA.debugLine="lblNombreVista.Top = 30dip";
Debug.ShouldStop(-2147483648);
editargasto.mostCurrent._lblnombrevista.runMethod(true,"setTop",editargasto.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 65;BA.debugLine="lblNombreVista.Left = (anchoDispositivo - lblNomb";
Debug.ShouldStop(1);
editargasto.mostCurrent._lblnombrevista.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editargasto._anchodispositivo,editargasto.mostCurrent._lblnombrevista.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 67;BA.debugLine="txtMonto.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(4);
editargasto.mostCurrent._txtmonto.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editargasto._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 68;BA.debugLine="txtMonto.Height = alturaDispositivo * 0.25";
Debug.ShouldStop(8);
editargasto.mostCurrent._txtmonto.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editargasto._alturadispositivo,RemoteObject.createImmutable(0.25)}, "*",0, 0)));
 BA.debugLineNum = 69;BA.debugLine="txtMonto.Top = lblNombreVista.Top * 2 + lblNombre";
Debug.ShouldStop(16);
editargasto.mostCurrent._txtmonto.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {editargasto.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2),editargasto.mostCurrent._lblnombrevista.runMethod(true,"getHeight")}, "*+",1, 1));
 BA.debugLineNum = 70;BA.debugLine="txtMonto.Left = (anchoDispositivo - txtMonto.Widt";
Debug.ShouldStop(32);
editargasto.mostCurrent._txtmonto.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editargasto._anchodispositivo,editargasto.mostCurrent._txtmonto.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 71;BA.debugLine="lblFondoMonto.Width = txtMonto.Width";
Debug.ShouldStop(64);
editargasto.mostCurrent._lblfondomonto.runMethod(true,"setWidth",editargasto.mostCurrent._txtmonto.runMethod(true,"getWidth"));
 BA.debugLineNum = 72;BA.debugLine="lblFondoMonto.Height = txtMonto.Height";
Debug.ShouldStop(128);
editargasto.mostCurrent._lblfondomonto.runMethod(true,"setHeight",editargasto.mostCurrent._txtmonto.runMethod(true,"getHeight"));
 BA.debugLineNum = 73;BA.debugLine="lblFondoMonto.Top = txtMonto.Top";
Debug.ShouldStop(256);
editargasto.mostCurrent._lblfondomonto.runMethod(true,"setTop",editargasto.mostCurrent._txtmonto.runMethod(true,"getTop"));
 BA.debugLineNum = 74;BA.debugLine="lblFondoMonto.Left = txtMonto.Left";
Debug.ShouldStop(512);
editargasto.mostCurrent._lblfondomonto.runMethod(true,"setLeft",editargasto.mostCurrent._txtmonto.runMethod(true,"getLeft"));
 BA.debugLineNum = 76;BA.debugLine="txtNombre.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(2048);
editargasto.mostCurrent._txtnombre.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editargasto._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 77;BA.debugLine="txtNombre.Height = alturaDispositivo * 0.1";
Debug.ShouldStop(4096);
editargasto.mostCurrent._txtnombre.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editargasto._alturadispositivo,RemoteObject.createImmutable(0.1)}, "*",0, 0)));
 BA.debugLineNum = 78;BA.debugLine="txtNombre.Top = txtMonto.Top + txtMonto.Height +";
Debug.ShouldStop(8192);
editargasto.mostCurrent._txtnombre.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {editargasto.mostCurrent._txtmonto.runMethod(true,"getTop"),editargasto.mostCurrent._txtmonto.runMethod(true,"getHeight"),editargasto.mostCurrent._lblnombrevista.runMethod(true,"getTop")}, "++",2, 1));
 BA.debugLineNum = 79;BA.debugLine="txtNombre.Left = (anchoDispositivo - txtNombre.Wi";
Debug.ShouldStop(16384);
editargasto.mostCurrent._txtnombre.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editargasto._anchodispositivo,editargasto.mostCurrent._txtnombre.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 80;BA.debugLine="lblFondoNombre.Width = txtMonto.Width";
Debug.ShouldStop(32768);
editargasto.mostCurrent._lblfondonombre.runMethod(true,"setWidth",editargasto.mostCurrent._txtmonto.runMethod(true,"getWidth"));
 BA.debugLineNum = 81;BA.debugLine="lblFondoNombre.Height = txtNombre.Height";
Debug.ShouldStop(65536);
editargasto.mostCurrent._lblfondonombre.runMethod(true,"setHeight",editargasto.mostCurrent._txtnombre.runMethod(true,"getHeight"));
 BA.debugLineNum = 82;BA.debugLine="lblFondoNombre.Top = txtNombre.Top";
Debug.ShouldStop(131072);
editargasto.mostCurrent._lblfondonombre.runMethod(true,"setTop",editargasto.mostCurrent._txtnombre.runMethod(true,"getTop"));
 BA.debugLineNum = 83;BA.debugLine="lblFondoNombre.Left = txtNombre.Left";
Debug.ShouldStop(262144);
editargasto.mostCurrent._lblfondonombre.runMethod(true,"setLeft",editargasto.mostCurrent._txtnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 85;BA.debugLine="pnlSelector.Top = txtNombre.Top + txtNombre.Heigh";
Debug.ShouldStop(1048576);
editargasto.mostCurrent._pnlselector.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {editargasto.mostCurrent._txtnombre.runMethod(true,"getTop"),editargasto.mostCurrent._txtnombre.runMethod(true,"getHeight"),editargasto.mostCurrent._lblnombrevista.runMethod(true,"getTop")}, "++",2, 1));
 BA.debugLineNum = 86;BA.debugLine="pnlSelector.Left = txtNombre.Left + txtNombre.Wid";
Debug.ShouldStop(2097152);
editargasto.mostCurrent._pnlselector.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {editargasto.mostCurrent._txtnombre.runMethod(true,"getLeft"),editargasto.mostCurrent._txtnombre.runMethod(true,"getWidth"),editargasto.mostCurrent._pnlselector.runMethod(true,"getWidth")}, "+-",2, 1));
 BA.debugLineNum = 88;BA.debugLine="txtDescripcion.Width = (txtNombre.Width - pnlSele";
Debug.ShouldStop(8388608);
editargasto.mostCurrent._txtdescripcion.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editargasto.mostCurrent._txtnombre.runMethod(true,"getWidth"),editargasto.mostCurrent._pnlselector.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 89;BA.debugLine="txtDescripcion.Height = pnlSelector.Height";
Debug.ShouldStop(16777216);
editargasto.mostCurrent._txtdescripcion.runMethod(true,"setHeight",editargasto.mostCurrent._pnlselector.runMethod(true,"getHeight"));
 BA.debugLineNum = 90;BA.debugLine="txtDescripcion.Top = pnlSelector.Top";
Debug.ShouldStop(33554432);
editargasto.mostCurrent._txtdescripcion.runMethod(true,"setTop",editargasto.mostCurrent._pnlselector.runMethod(true,"getTop"));
 BA.debugLineNum = 91;BA.debugLine="txtDescripcion.Left = txtNombre.Left";
Debug.ShouldStop(67108864);
editargasto.mostCurrent._txtdescripcion.runMethod(true,"setLeft",editargasto.mostCurrent._txtnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 92;BA.debugLine="lblFondoDescripcion.Width = txtDescripcion.Width";
Debug.ShouldStop(134217728);
editargasto.mostCurrent._lblfondodescripcion.runMethod(true,"setWidth",editargasto.mostCurrent._txtdescripcion.runMethod(true,"getWidth"));
 BA.debugLineNum = 93;BA.debugLine="lblFondoDescripcion.Height = txtDescripcion.Heigh";
Debug.ShouldStop(268435456);
editargasto.mostCurrent._lblfondodescripcion.runMethod(true,"setHeight",editargasto.mostCurrent._txtdescripcion.runMethod(true,"getHeight"));
 BA.debugLineNum = 94;BA.debugLine="lblFondoDescripcion.Top = txtDescripcion.Top";
Debug.ShouldStop(536870912);
editargasto.mostCurrent._lblfondodescripcion.runMethod(true,"setTop",editargasto.mostCurrent._txtdescripcion.runMethod(true,"getTop"));
 BA.debugLineNum = 95;BA.debugLine="lblFondoDescripcion.Left = txtDescripcion.Left";
Debug.ShouldStop(1073741824);
editargasto.mostCurrent._lblfondodescripcion.runMethod(true,"setLeft",editargasto.mostCurrent._txtdescripcion.runMethod(true,"getLeft"));
 BA.debugLineNum = 100;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
Debug.ShouldStop(8);
editargasto.mostCurrent._pnlnavinferior.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editargasto._alturadispositivo,RemoteObject.createImmutable(0.08)}, "*",0, 0)));
 BA.debugLineNum = 101;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
Debug.ShouldStop(16);
editargasto.mostCurrent._pnlnavinferior.runMethod(true,"setWidth",editargasto._anchodispositivo);
 BA.debugLineNum = 102;BA.debugLine="pnlNavInferior.Left = 0";
Debug.ShouldStop(32);
editargasto.mostCurrent._pnlnavinferior.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 103;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
Debug.ShouldStop(64);
editargasto.mostCurrent._pnlnavinferior.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {editargasto._alturadispositivo,editargasto.mostCurrent._pnlnavinferior.runMethod(true,"getHeight")}, "-",1, 1));
 BA.debugLineNum = 106;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
Debug.ShouldStop(512);
editargasto.mostCurrent._btnmenu.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editargasto._anchodispositivo,RemoteObject.createImmutable(0.15)}, "*",0, 0)));
 BA.debugLineNum = 107;BA.debugLine="btnMenu.Height = btnMenu.Width";
Debug.ShouldStop(1024);
editargasto.mostCurrent._btnmenu.runMethod(true,"setHeight",editargasto.mostCurrent._btnmenu.runMethod(true,"getWidth"));
 BA.debugLineNum = 108;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
Debug.ShouldStop(2048);
editargasto.mostCurrent._btnmenu.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editargasto.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),editargasto.mostCurrent._btnmenu.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 109;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
Debug.ShouldStop(4096);
editargasto.mostCurrent._btnmenu.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editargasto._anchodispositivo,editargasto.mostCurrent._btnmenu.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 111;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
Debug.ShouldStop(16384);
editargasto.mostCurrent._lblcontornoboton.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editargasto._anchodispositivo,RemoteObject.createImmutable(0.17)}, "*",0, 0)));
 BA.debugLineNum = 112;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
Debug.ShouldStop(32768);
editargasto.mostCurrent._lblcontornoboton.runMethod(true,"setHeight",editargasto.mostCurrent._lblcontornoboton.runMethod(true,"getWidth"));
 BA.debugLineNum = 113;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
Debug.ShouldStop(65536);
editargasto.mostCurrent._lblcontornoboton.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editargasto._anchodispositivo,editargasto.mostCurrent._lblcontornoboton.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 114;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
Debug.ShouldStop(131072);
editargasto.mostCurrent._lblcontornoboton.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editargasto.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),editargasto.mostCurrent._lblcontornoboton.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 119;BA.debugLine="btnOperacionGasto.Text = \"Editar gasto\"";
Debug.ShouldStop(4194304);
editargasto.mostCurrent._btnoperaciongasto.runMethod(true,"setText",BA.ObjectToCharSequence("Editar gasto"));
 BA.debugLineNum = 120;BA.debugLine="btnOperacionGasto.Top = txtDescripcion.Top + txtD";
Debug.ShouldStop(8388608);
editargasto.mostCurrent._btnoperaciongasto.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editargasto.mostCurrent._txtdescripcion.runMethod(true,"getTop"),editargasto.mostCurrent._txtdescripcion.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {editargasto.mostCurrent._lblcontornoboton.runMethod(true,"getTop"),(RemoteObject.solve(new RemoteObject[] {editargasto.mostCurrent._txtdescripcion.runMethod(true,"getTop"),editargasto.mostCurrent._txtdescripcion.runMethod(true,"getHeight"),editargasto.mostCurrent._btnoperaciongasto.runMethod(true,"getHeight")}, "++",2, 1))}, "-",1, 1)),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 121;BA.debugLine="btnOperacionGasto.Left = (anchoDispositivo - btnO";
Debug.ShouldStop(16777216);
editargasto.mostCurrent._btnoperaciongasto.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editargasto._anchodispositivo,editargasto.mostCurrent._btnoperaciongasto.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (editargasto) ","editargasto",4,editargasto.mostCurrent.activityBA,editargasto.mostCurrent,128);
if (RapidSub.canDelegate("activity_pause")) { return pullup.wallet.editargasto.remoteMe.runUserSub(false, "editargasto","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 128;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 130;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("Activity_Resume (editargasto) ","editargasto",4,editargasto.mostCurrent.activityBA,editargasto.mostCurrent,124);
if (RapidSub.canDelegate("activity_resume")) { return pullup.wallet.editargasto.remoteMe.runUserSub(false, "editargasto","activity_resume");}
 BA.debugLineNum = 124;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 126;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("asignacionCampos (editargasto) ","editargasto",4,editargasto.mostCurrent.activityBA,editargasto.mostCurrent,190);
if (RapidSub.canDelegate("asignacioncampos")) { return pullup.wallet.editargasto.remoteMe.runUserSub(false, "editargasto","asignacioncampos");}
RemoteObject _gasto = RemoteObject.declareNull("pullup.wallet.main._registrogasto");
 BA.debugLineNum = 190;BA.debugLine="Sub asignacionCampos As RegistroGasto";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 191;BA.debugLine="Dim gasto As RegistroGasto";
Debug.ShouldStop(1073741824);
_gasto = RemoteObject.createNew ("pullup.wallet.main._registrogasto");Debug.locals.put("gasto", _gasto);
 BA.debugLineNum = 193;BA.debugLine="gasto.monto = txtMonto.Text";
Debug.ShouldStop(1);
_gasto.setField ("monto" /*RemoteObject*/ ,BA.numberCast(int.class, editargasto.mostCurrent._txtmonto.runMethod(true,"getText")));
 BA.debugLineNum = 195;BA.debugLine="gasto.nombre = txtNombre.Text";
Debug.ShouldStop(4);
_gasto.setField ("nombre" /*RemoteObject*/ ,editargasto.mostCurrent._txtnombre.runMethod(true,"getText"));
 BA.debugLineNum = 197;BA.debugLine="gasto.descripcion = (txtDescripcion.Text)";
Debug.ShouldStop(16);
_gasto.setField ("descripcion" /*RemoteObject*/ ,(editargasto.mostCurrent._txtdescripcion.runMethod(true,"getText")));
 BA.debugLineNum = 199;BA.debugLine="gasto.color = colorCaja";
Debug.ShouldStop(64);
_gasto.setField ("color" /*RemoteObject*/ ,editargasto._colorcaja);
 BA.debugLineNum = 201;BA.debugLine="Return gasto";
Debug.ShouldStop(256);
if (true) return _gasto;
 BA.debugLineNum = 202;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("btnMenu_Click (editargasto) ","editargasto",4,editargasto.mostCurrent.activityBA,editargasto.mostCurrent,132);
if (RapidSub.canDelegate("btnmenu_click")) { return pullup.wallet.editargasto.remoteMe.runUserSub(false, "editargasto","btnmenu_click");}
 BA.debugLineNum = 132;BA.debugLine="Private Sub btnMenu_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 133;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16);
editargasto.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 134;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("btnOperacionGasto_Click (editargasto) ","editargasto",4,editargasto.mostCurrent.activityBA,editargasto.mostCurrent,206);
if (RapidSub.canDelegate("btnoperaciongasto_click")) { return pullup.wallet.editargasto.remoteMe.runUserSub(false, "editargasto","btnoperaciongasto_click");}
RemoteObject _validaciones = RemoteObject.createImmutable(false);
RemoteObject _gastoregistro = RemoteObject.declareNull("pullup.wallet.main._registrogasto");
 BA.debugLineNum = 206;BA.debugLine="Private Sub btnOperacionGasto_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 207;BA.debugLine="Dim validaciones As Boolean";
Debug.ShouldStop(16384);
_validaciones = RemoteObject.createImmutable(false);Debug.locals.put("validaciones", _validaciones);
 BA.debugLineNum = 209;BA.debugLine="validaciones = validarCampos";
Debug.ShouldStop(65536);
_validaciones = _validarcampos();Debug.locals.put("validaciones", _validaciones);
 BA.debugLineNum = 210;BA.debugLine="If(validaciones = True) Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("=",_validaciones,editargasto.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 212;BA.debugLine="Dim gastoRegistro As RegistroGasto";
Debug.ShouldStop(524288);
_gastoregistro = RemoteObject.createNew ("pullup.wallet.main._registrogasto");Debug.locals.put("gastoRegistro", _gastoregistro);
 BA.debugLineNum = 213;BA.debugLine="gastoRegistro = asignacionCampos";
Debug.ShouldStop(1048576);
_gastoregistro = _asignacioncampos();Debug.locals.put("gastoRegistro", _gastoregistro);
 BA.debugLineNum = 216;BA.debugLine="cur = sql.ExecQuery2(\"SELECT monto FROM gastos W";
Debug.ShouldStop(8388608);
editargasto.mostCurrent._cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), editargasto._sql.runMethod(false,"ExecQuery2",(Object)(BA.ObjectToString("SELECT monto FROM gastos WHERE id_gasto = ?")),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {RemoteObject.concat(editargasto._idregistro,RemoteObject.createImmutable(""))}))));
 BA.debugLineNum = 217;BA.debugLine="cur.Position = 0";
Debug.ShouldStop(16777216);
editargasto.mostCurrent._cur.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 219;BA.debugLine="montoAntiguo = cur.GetInt(\"monto\")";
Debug.ShouldStop(67108864);
editargasto._montoantiguo = editargasto.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("monto")));
 BA.debugLineNum = 220;BA.debugLine="montoNuevo = gastoRegistro.monto";
Debug.ShouldStop(134217728);
editargasto._montonuevo = _gastoregistro.getField(true,"monto" /*RemoteObject*/ );
 BA.debugLineNum = 223;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM egresos WHERE";
Debug.ShouldStop(1073741824);
editargasto.mostCurrent._cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), editargasto._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM egresos WHERE id_egreso = 1"))));
 BA.debugLineNum = 224;BA.debugLine="cur.Position = 0";
Debug.ShouldStop(-2147483648);
editargasto.mostCurrent._cur.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 225;BA.debugLine="sumaEgresosAntigua = cur.GetInt(\"suma_egresos\")";
Debug.ShouldStop(1);
editargasto._sumaegresosantigua = editargasto.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("suma_egresos")));
 BA.debugLineNum = 228;BA.debugLine="sumaEgresosActual = (sumaEgresosAntigua - montoA";
Debug.ShouldStop(8);
editargasto._sumaegresosactual = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editargasto._sumaegresosantigua,editargasto._montoantiguo}, "-",1, 1)),editargasto._montonuevo}, "+",1, 1);
 BA.debugLineNum = 231;BA.debugLine="sql.ExecNonQuery2(\"UPDATE egresos SET suma_egres";
Debug.ShouldStop(64);
editargasto._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE egresos SET suma_egresos = ? WHERE id_egreso = 1")),(Object)(editargasto.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(editargasto._sumaegresosactual)})))));
 BA.debugLineNum = 234;BA.debugLine="Starter.sql.ExecNonQuery2(\"UPDATE gastos SET mon";
Debug.ShouldStop(512);
editargasto.mostCurrent._starter._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery2",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE gastos SET monto = ?, nombre = ?, descripcion = ?, color = ?  WHERE id_gasto = '"),editargasto._idregistro,RemoteObject.createImmutable("'"))),(Object)(editargasto.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {4},new Object[] {(_gastoregistro.getField(true,"monto" /*RemoteObject*/ )),(_gastoregistro.getField(true,"nombre" /*RemoteObject*/ )),(_gastoregistro.getField(true,"descripcion" /*RemoteObject*/ )),(_gastoregistro.getField(true,"color" /*RemoteObject*/ ))})))));
 BA.debugLineNum = 236;BA.debugLine="ToastMessageShow(\"Gasto editado\",True)";
Debug.ShouldStop(2048);
editargasto.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Gasto editado")),(Object)(editargasto.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 238;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8192);
editargasto.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 240;BA.debugLine="StartActivity(Gastos)";
Debug.ShouldStop(32768);
editargasto.mostCurrent.__c.runVoidMethod ("StartActivity",editargasto.processBA,(Object)((editargasto.mostCurrent._gastos.getObject())));
 }else {
 BA.debugLineNum = 243;BA.debugLine="Msgbox2(\"Por favor, rellene todos los campos y s";
Debug.ShouldStop(262144);
editargasto.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("Por favor, rellene todos los campos y seleccione un color")),(Object)(BA.ObjectToCharSequence("Registro incorrecto")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((editargasto.mostCurrent.__c.getField(false,"Null"))),editargasto.mostCurrent.activityBA);
 };
 BA.debugLineNum = 245;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _consultaaeditar(RemoteObject _rowid) throws Exception{
try {
		Debug.PushSubsStack("consultaAEditar (editargasto) ","editargasto",4,editargasto.mostCurrent.activityBA,editargasto.mostCurrent,248);
if (RapidSub.canDelegate("consultaaeditar")) { return pullup.wallet.editargasto.remoteMe.runUserSub(false, "editargasto","consultaaeditar", _rowid);}
RemoteObject _gasto = RemoteObject.declareNull("pullup.wallet.main._registrogasto");
Debug.locals.put("rowid", _rowid);
 BA.debugLineNum = 248;BA.debugLine="Sub consultaAEditar(rowid As Int)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 249;BA.debugLine="Dim gasto As RegistroGasto";
Debug.ShouldStop(16777216);
_gasto = RemoteObject.createNew ("pullup.wallet.main._registrogasto");Debug.locals.put("gasto", _gasto);
 BA.debugLineNum = 250;BA.debugLine="idRegistro = rowid";
Debug.ShouldStop(33554432);
editargasto._idregistro = _rowid;
 BA.debugLineNum = 252;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM gastos WHERE i";
Debug.ShouldStop(134217728);
editargasto.mostCurrent._cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), editargasto._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM gastos WHERE id_gasto = '"),editargasto._idregistro,RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 253;BA.debugLine="If(cur.RowCount > 0) Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean(">",editargasto.mostCurrent._cur.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 254;BA.debugLine="cur.Position = 0";
Debug.ShouldStop(536870912);
editargasto.mostCurrent._cur.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 255;BA.debugLine="gasto.nombre = cur.GetString(\"nombre\")";
Debug.ShouldStop(1073741824);
_gasto.setField ("nombre" /*RemoteObject*/ ,editargasto.mostCurrent._cur.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("nombre"))));
 BA.debugLineNum = 256;BA.debugLine="gasto.monto = cur.GetInt(\"monto\")";
Debug.ShouldStop(-2147483648);
_gasto.setField ("monto" /*RemoteObject*/ ,editargasto.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("monto"))));
 BA.debugLineNum = 257;BA.debugLine="gasto.descripcion = cur.GetString(\"descripcion\")";
Debug.ShouldStop(1);
_gasto.setField ("descripcion" /*RemoteObject*/ ,editargasto.mostCurrent._cur.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("descripcion"))));
 BA.debugLineNum = 258;BA.debugLine="gasto.color = cur.GetString(\"color\")";
Debug.ShouldStop(2);
_gasto.setField ("color" /*RemoteObject*/ ,BA.numberCast(int.class, editargasto.mostCurrent._cur.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("color")))));
 BA.debugLineNum = 260;BA.debugLine="reasignarCamposAEditar(gasto)";
Debug.ShouldStop(8);
_reasignarcamposaeditar(_gasto);
 };
 BA.debugLineNum = 262;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("cpBarraColor_ColorChanged (editargasto) ","editargasto",4,editargasto.mostCurrent.activityBA,editargasto.mostCurrent,184);
if (RapidSub.canDelegate("cpbarracolor_colorchanged")) { return pullup.wallet.editargasto.remoteMe.runUserSub(false, "editargasto","cpbarracolor_colorchanged", _color);}
Debug.locals.put("color", _color);
 BA.debugLineNum = 184;BA.debugLine="Sub cpBarraColor_ColorChanged(color As Int)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 185;BA.debugLine="lblFondoMonto.Color = color";
Debug.ShouldStop(16777216);
editargasto.mostCurrent._lblfondomonto.runVoidMethod ("setColor",_color);
 BA.debugLineNum = 186;BA.debugLine="colorCaja = color";
Debug.ShouldStop(33554432);
editargasto._colorcaja = _color;
 BA.debugLineNum = 187;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 14;BA.debugLine="Dim alturaDispositivo As Int";
editargasto._alturadispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 15;BA.debugLine="Dim anchoDispositivo As Int";
editargasto._anchodispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 16;BA.debugLine="Dim colorCaja As Int";
editargasto._colorcaja = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 17;BA.debugLine="Dim aparicionMsgBox1 As Boolean";
editargasto._aparicionmsgbox1 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 18;BA.debugLine="Dim aparicionMsgBox2 As Boolean";
editargasto._aparicionmsgbox2 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 19;BA.debugLine="Dim aparicionMsgBox3 As Boolean";
editargasto._aparicionmsgbox3 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 20;BA.debugLine="Dim cur As Cursor";
editargasto.mostCurrent._cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Dim idRegistro As Int";
editargasto._idregistro = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 22;BA.debugLine="Dim sumaEgresosAntigua As Int";
editargasto._sumaegresosantigua = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 23;BA.debugLine="Dim montoAntiguo As Int";
editargasto._montoantiguo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 24;BA.debugLine="Dim montoNuevo As Int";
editargasto._montonuevo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 25;BA.debugLine="Dim sumaEgresosActual As Int";
editargasto._sumaegresosactual = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 29;BA.debugLine="Private btnMenu As Button";
editargasto.mostCurrent._btnmenu = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private btnOperacionGasto As Button";
editargasto.mostCurrent._btnoperaciongasto = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private txtDescripcion As EditText";
editargasto.mostCurrent._txtdescripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private txtMonto As EditText";
editargasto.mostCurrent._txtmonto = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private txtNombre As EditText";
editargasto.mostCurrent._txtnombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private lblFondoMonto As Label";
editargasto.mostCurrent._lblfondomonto = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private lblFondoDescripcion As Label";
editargasto.mostCurrent._lblfondodescripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private lblFondoNombre As Label";
editargasto.mostCurrent._lblfondonombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private lblContornoBoton As Label";
editargasto.mostCurrent._lblcontornoboton = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private lblNombreVista As Label";
editargasto.mostCurrent._lblnombrevista = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private pnlNavInferior As Panel";
editargasto.mostCurrent._pnlnavinferior = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private pnlSelector As Panel";
editargasto.mostCurrent._pnlselector = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private cpBarraColor As ASColorSlider  'Miembro g";
editargasto.mostCurrent._cpbarracolor = RemoteObject.createNew ("pullup.wallet.ascolorslider");
 //BA.debugLineNum = 46;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _limitarlongitudentrada(RemoteObject _antiguo,RemoteObject _nuevo,RemoteObject _longitud,RemoteObject _view,RemoteObject _campo) throws Exception{
try {
		Debug.PushSubsStack("limitarLongitudEntrada (editargasto) ","editargasto",4,editargasto.mostCurrent.activityBA,editargasto.mostCurrent,147);
if (RapidSub.canDelegate("limitarlongitudentrada")) { return pullup.wallet.editargasto.remoteMe.runUserSub(false, "editargasto","limitarlongitudentrada", _antiguo, _nuevo, _longitud, _view, _campo);}
Debug.locals.put("antiguo", _antiguo);
Debug.locals.put("nuevo", _nuevo);
Debug.locals.put("longitud", _longitud);
Debug.locals.put("view", _view);
Debug.locals.put("campo", _campo);
 BA.debugLineNum = 147;BA.debugLine="Sub limitarLongitudEntrada(antiguo As String, nuev";
Debug.ShouldStop(262144);
 BA.debugLineNum = 148;BA.debugLine="If(nuevo.Length > longitud) Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean(">",_nuevo.runMethod(true,"length"),BA.numberCast(double.class, _longitud)))) { 
 BA.debugLineNum = 149;BA.debugLine="If(campo = \"monto\") Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("monto")))) { 
 BA.debugLineNum = 150;BA.debugLine="If(aparicionMsgBox1 = False) Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",editargasto._aparicionmsgbox1,editargasto.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 151;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
Debug.ShouldStop(4194304);
editargasto.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para el monto es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((editargasto.mostCurrent.__c.getField(false,"Null"))),editargasto.mostCurrent.activityBA);
 BA.debugLineNum = 152;BA.debugLine="aparicionMsgBox1 = True";
Debug.ShouldStop(8388608);
editargasto._aparicionmsgbox1 = editargasto.mostCurrent.__c.getField(true,"True");
 };
 }else 
{ BA.debugLineNum = 154;BA.debugLine="Else If(campo = \"nombre\") Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("nombre")))) { 
 BA.debugLineNum = 155;BA.debugLine="If(aparicionMsgBox2 = False) Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",editargasto._aparicionmsgbox2,editargasto.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 156;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
Debug.ShouldStop(134217728);
editargasto.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para el nombre es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((editargasto.mostCurrent.__c.getField(false,"Null"))),editargasto.mostCurrent.activityBA);
 BA.debugLineNum = 157;BA.debugLine="aparicionMsgBox2 = True";
Debug.ShouldStop(268435456);
editargasto._aparicionmsgbox2 = editargasto.mostCurrent.__c.getField(true,"True");
 };
 }else 
{ BA.debugLineNum = 159;BA.debugLine="Else If(campo = \"descripcion\") Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("descripcion")))) { 
 BA.debugLineNum = 160;BA.debugLine="If(aparicionMsgBox3 = False) Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("=",editargasto._aparicionmsgbox3,editargasto.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 161;BA.debugLine="Msgbox2(\"La longitud máxima permitida para la";
Debug.ShouldStop(1);
editargasto.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para la descripción es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((editargasto.mostCurrent.__c.getField(false,"Null"))),editargasto.mostCurrent.activityBA);
 BA.debugLineNum = 162;BA.debugLine="aparicionMsgBox3 = True";
Debug.ShouldStop(2);
editargasto._aparicionmsgbox3 = editargasto.mostCurrent.__c.getField(true,"True");
 };
 }}}
;
 BA.debugLineNum = 165;BA.debugLine="view.Text = antiguo";
Debug.ShouldStop(16);
_view.runMethod(true,"setText",BA.ObjectToCharSequence(_antiguo));
 };
 BA.debugLineNum = 167;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
editargasto._sql = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _reasignarcamposaeditar(RemoteObject _registro) throws Exception{
try {
		Debug.PushSubsStack("reasignarCamposAEditar (editargasto) ","editargasto",4,editargasto.mostCurrent.activityBA,editargasto.mostCurrent,265);
if (RapidSub.canDelegate("reasignarcamposaeditar")) { return pullup.wallet.editargasto.remoteMe.runUserSub(false, "editargasto","reasignarcamposaeditar", _registro);}
Debug.locals.put("registro", _registro);
 BA.debugLineNum = 265;BA.debugLine="Sub reasignarCamposAEditar(registro As RegistroGas";
Debug.ShouldStop(256);
 BA.debugLineNum = 266;BA.debugLine="txtNombre.Text = registro.nombre";
Debug.ShouldStop(512);
editargasto.mostCurrent._txtnombre.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_registro.getField(true,"nombre" /*RemoteObject*/ )));
 BA.debugLineNum = 267;BA.debugLine="txtMonto.Text = registro.monto";
Debug.ShouldStop(1024);
editargasto.mostCurrent._txtmonto.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_registro.getField(true,"monto" /*RemoteObject*/ )));
 BA.debugLineNum = 268;BA.debugLine="txtDescripcion.Text = registro.descripcion";
Debug.ShouldStop(2048);
editargasto.mostCurrent._txtdescripcion.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_registro.getField(true,"descripcion" /*RemoteObject*/ )));
 BA.debugLineNum = 270;BA.debugLine="cpBarraColor_ColorChanged(registro.color)";
Debug.ShouldStop(8192);
_cpbarracolor_colorchanged(_registro.getField(true,"color" /*RemoteObject*/ ));
 BA.debugLineNum = 271;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtdescripcion_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtDescripcion_TextChanged (editargasto) ","editargasto",4,editargasto.mostCurrent.activityBA,editargasto.mostCurrent,178);
if (RapidSub.canDelegate("txtdescripcion_textchanged")) { return pullup.wallet.editargasto.remoteMe.runUserSub(false, "editargasto","txtdescripcion_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 178;BA.debugLine="Private Sub txtDescripcion_TextChanged (Old As Str";
Debug.ShouldStop(131072);
 BA.debugLineNum = 179;BA.debugLine="limitarLongitudEntrada(Old, New, 41, txtDescripci";
Debug.ShouldStop(262144);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 41),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), editargasto.mostCurrent._txtdescripcion.getObject()),RemoteObject.createImmutable("descripcion"));
 BA.debugLineNum = 180;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("txtMonto_TextChanged (editargasto) ","editargasto",4,editargasto.mostCurrent.activityBA,editargasto.mostCurrent,170);
if (RapidSub.canDelegate("txtmonto_textchanged")) { return pullup.wallet.editargasto.remoteMe.runUserSub(false, "editargasto","txtmonto_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 170;BA.debugLine="Private Sub txtMonto_TextChanged (Old As String, N";
Debug.ShouldStop(512);
 BA.debugLineNum = 171;BA.debugLine="limitarLongitudEntrada(Old, New, 9, txtMonto, \"mo";
Debug.ShouldStop(1024);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 9),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), editargasto.mostCurrent._txtmonto.getObject()),RemoteObject.createImmutable("monto"));
 BA.debugLineNum = 172;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("txtNombre_TextChanged (editargasto) ","editargasto",4,editargasto.mostCurrent.activityBA,editargasto.mostCurrent,174);
if (RapidSub.canDelegate("txtnombre_textchanged")) { return pullup.wallet.editargasto.remoteMe.runUserSub(false, "editargasto","txtnombre_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 174;BA.debugLine="Private Sub txtNombre_TextChanged (Old As String,";
Debug.ShouldStop(8192);
 BA.debugLineNum = 175;BA.debugLine="limitarLongitudEntrada(Old, New, 16, txtNombre, \"";
Debug.ShouldStop(16384);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 16),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), editargasto.mostCurrent._txtnombre.getObject()),RemoteObject.createImmutable("nombre"));
 BA.debugLineNum = 176;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("validarCampos (editargasto) ","editargasto",4,editargasto.mostCurrent.activityBA,editargasto.mostCurrent,137);
if (RapidSub.canDelegate("validarcampos")) { return pullup.wallet.editargasto.remoteMe.runUserSub(false, "editargasto","validarcampos");}
 BA.debugLineNum = 137;BA.debugLine="Sub validarCampos As Boolean";
Debug.ShouldStop(256);
 BA.debugLineNum = 138;BA.debugLine="If(txtMonto.Text.Length <> 0 And txtNombre.Text.L";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("!",editargasto.mostCurrent._txtmonto.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",editargasto.mostCurrent._txtnombre.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",editargasto.mostCurrent._txtdescripcion.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",editargasto._colorcaja,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 139;BA.debugLine="Return True";
Debug.ShouldStop(1024);
if (true) return editargasto.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 141;BA.debugLine="Return False";
Debug.ShouldStop(4096);
if (true) return editargasto.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 143;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}