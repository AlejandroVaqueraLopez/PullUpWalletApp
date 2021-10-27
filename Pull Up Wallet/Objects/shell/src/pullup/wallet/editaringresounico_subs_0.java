package pullup.wallet;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class editaringresounico_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (editaringresounico) ","editaringresounico",6,editaringresounico.mostCurrent.activityBA,editaringresounico.mostCurrent,49);
if (RapidSub.canDelegate("activity_create")) { return pullup.wallet.editaringresounico.remoteMe.runUserSub(false, "editaringresounico","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 49;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 51;BA.debugLine="Activity.LoadLayout(\"LEditarIngresoUnico\")";
Debug.ShouldStop(262144);
editaringresounico.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("LEditarIngresoUnico")),editaringresounico.mostCurrent.activityBA);
 BA.debugLineNum = 52;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
Debug.ShouldStop(524288);
editaringresounico._alturadispositivo = editaringresounico.mostCurrent._main._alturadispositivo /*RemoteObject*/ ;
 BA.debugLineNum = 53;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
Debug.ShouldStop(1048576);
editaringresounico._anchodispositivo = editaringresounico.mostCurrent._main._anchodispositivo /*RemoteObject*/ ;
 BA.debugLineNum = 54;BA.debugLine="sql = Starter.sql";
Debug.ShouldStop(2097152);
editaringresounico._sql = editaringresounico.mostCurrent._starter._sql /*RemoteObject*/ ;
 BA.debugLineNum = 55;BA.debugLine="aparicionMsgBox1 = False";
Debug.ShouldStop(4194304);
editaringresounico._aparicionmsgbox1 = editaringresounico.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 56;BA.debugLine="aparicionMsgBox2 = False";
Debug.ShouldStop(8388608);
editaringresounico._aparicionmsgbox2 = editaringresounico.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 57;BA.debugLine="aparicionMsgBox3 = False";
Debug.ShouldStop(16777216);
editaringresounico._aparicionmsgbox3 = editaringresounico.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 58;BA.debugLine="colorCaja = 0";
Debug.ShouldStop(33554432);
editaringresounico._colorcaja = BA.numberCast(int.class, 0);
 BA.debugLineNum = 61;BA.debugLine="lblNombreVista.TextSize = 20";
Debug.ShouldStop(268435456);
editaringresounico.mostCurrent._lblnombrevista.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 62;BA.debugLine="lblNombreVista.TextColor = Colors.Black";
Debug.ShouldStop(536870912);
editaringresounico.mostCurrent._lblnombrevista.runMethod(true,"setTextColor",editaringresounico.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 63;BA.debugLine="lblNombreVista.Height = 30dip";
Debug.ShouldStop(1073741824);
editaringresounico.mostCurrent._lblnombrevista.runMethod(true,"setHeight",editaringresounico.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 64;BA.debugLine="lblNombreVista.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(-2147483648);
editaringresounico.mostCurrent._lblnombrevista.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresounico._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 65;BA.debugLine="lblNombreVista.Top = 30dip";
Debug.ShouldStop(1);
editaringresounico.mostCurrent._lblnombrevista.runMethod(true,"setTop",editaringresounico.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 66;BA.debugLine="lblNombreVista.Left = (anchoDispositivo - lblNomb";
Debug.ShouldStop(2);
editaringresounico.mostCurrent._lblnombrevista.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editaringresounico._anchodispositivo,editaringresounico.mostCurrent._lblnombrevista.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 68;BA.debugLine="txtMonto.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(8);
editaringresounico.mostCurrent._txtmonto.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresounico._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 69;BA.debugLine="txtMonto.Height = alturaDispositivo * 0.25";
Debug.ShouldStop(16);
editaringresounico.mostCurrent._txtmonto.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresounico._alturadispositivo,RemoteObject.createImmutable(0.25)}, "*",0, 0)));
 BA.debugLineNum = 70;BA.debugLine="txtMonto.Top = lblNombreVista.Top * 2 + lblNombre";
Debug.ShouldStop(32);
editaringresounico.mostCurrent._txtmonto.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {editaringresounico.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2),editaringresounico.mostCurrent._lblnombrevista.runMethod(true,"getHeight")}, "*+",1, 1));
 BA.debugLineNum = 71;BA.debugLine="txtMonto.Left = (anchoDispositivo - txtMonto.Widt";
Debug.ShouldStop(64);
editaringresounico.mostCurrent._txtmonto.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editaringresounico._anchodispositivo,editaringresounico.mostCurrent._txtmonto.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 72;BA.debugLine="lblFondoMonto.Width = txtMonto.Width";
Debug.ShouldStop(128);
editaringresounico.mostCurrent._lblfondomonto.runMethod(true,"setWidth",editaringresounico.mostCurrent._txtmonto.runMethod(true,"getWidth"));
 BA.debugLineNum = 73;BA.debugLine="lblFondoMonto.Height = txtMonto.Height";
Debug.ShouldStop(256);
editaringresounico.mostCurrent._lblfondomonto.runMethod(true,"setHeight",editaringresounico.mostCurrent._txtmonto.runMethod(true,"getHeight"));
 BA.debugLineNum = 74;BA.debugLine="lblFondoMonto.Top = txtMonto.Top";
Debug.ShouldStop(512);
editaringresounico.mostCurrent._lblfondomonto.runMethod(true,"setTop",editaringresounico.mostCurrent._txtmonto.runMethod(true,"getTop"));
 BA.debugLineNum = 75;BA.debugLine="lblFondoMonto.Left = txtMonto.Left";
Debug.ShouldStop(1024);
editaringresounico.mostCurrent._lblfondomonto.runMethod(true,"setLeft",editaringresounico.mostCurrent._txtmonto.runMethod(true,"getLeft"));
 BA.debugLineNum = 77;BA.debugLine="txtNombre.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(4096);
editaringresounico.mostCurrent._txtnombre.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresounico._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 78;BA.debugLine="txtNombre.Height = alturaDispositivo * 0.1";
Debug.ShouldStop(8192);
editaringresounico.mostCurrent._txtnombre.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresounico._alturadispositivo,RemoteObject.createImmutable(0.1)}, "*",0, 0)));
 BA.debugLineNum = 79;BA.debugLine="txtNombre.Top = txtMonto.Top + txtMonto.Height +";
Debug.ShouldStop(16384);
editaringresounico.mostCurrent._txtnombre.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {editaringresounico.mostCurrent._txtmonto.runMethod(true,"getTop"),editaringresounico.mostCurrent._txtmonto.runMethod(true,"getHeight"),editaringresounico.mostCurrent._lblnombrevista.runMethod(true,"getTop")}, "++",2, 1));
 BA.debugLineNum = 80;BA.debugLine="txtNombre.Left = (anchoDispositivo - txtNombre.Wi";
Debug.ShouldStop(32768);
editaringresounico.mostCurrent._txtnombre.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editaringresounico._anchodispositivo,editaringresounico.mostCurrent._txtnombre.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 81;BA.debugLine="lblFondoNombre.Width = txtMonto.Width";
Debug.ShouldStop(65536);
editaringresounico.mostCurrent._lblfondonombre.runMethod(true,"setWidth",editaringresounico.mostCurrent._txtmonto.runMethod(true,"getWidth"));
 BA.debugLineNum = 82;BA.debugLine="lblFondoNombre.Height = txtNombre.Height";
Debug.ShouldStop(131072);
editaringresounico.mostCurrent._lblfondonombre.runMethod(true,"setHeight",editaringresounico.mostCurrent._txtnombre.runMethod(true,"getHeight"));
 BA.debugLineNum = 83;BA.debugLine="lblFondoNombre.Top = txtNombre.Top";
Debug.ShouldStop(262144);
editaringresounico.mostCurrent._lblfondonombre.runMethod(true,"setTop",editaringresounico.mostCurrent._txtnombre.runMethod(true,"getTop"));
 BA.debugLineNum = 84;BA.debugLine="lblFondoNombre.Left = txtNombre.Left";
Debug.ShouldStop(524288);
editaringresounico.mostCurrent._lblfondonombre.runMethod(true,"setLeft",editaringresounico.mostCurrent._txtnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 86;BA.debugLine="pnlSelector.Top = txtNombre.Top + txtNombre.Heigh";
Debug.ShouldStop(2097152);
editaringresounico.mostCurrent._pnlselector.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {editaringresounico.mostCurrent._txtnombre.runMethod(true,"getTop"),editaringresounico.mostCurrent._txtnombre.runMethod(true,"getHeight"),editaringresounico.mostCurrent._lblnombrevista.runMethod(true,"getTop")}, "++",2, 1));
 BA.debugLineNum = 87;BA.debugLine="pnlSelector.Left = txtNombre.Left + txtNombre.Wid";
Debug.ShouldStop(4194304);
editaringresounico.mostCurrent._pnlselector.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {editaringresounico.mostCurrent._txtnombre.runMethod(true,"getLeft"),editaringresounico.mostCurrent._txtnombre.runMethod(true,"getWidth"),editaringresounico.mostCurrent._pnlselector.runMethod(true,"getWidth")}, "+-",2, 1));
 BA.debugLineNum = 89;BA.debugLine="txtDescripcion.Width = (txtNombre.Width - pnlSele";
Debug.ShouldStop(16777216);
editaringresounico.mostCurrent._txtdescripcion.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editaringresounico.mostCurrent._txtnombre.runMethod(true,"getWidth"),editaringresounico.mostCurrent._pnlselector.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 90;BA.debugLine="txtDescripcion.Height = pnlSelector.Height";
Debug.ShouldStop(33554432);
editaringresounico.mostCurrent._txtdescripcion.runMethod(true,"setHeight",editaringresounico.mostCurrent._pnlselector.runMethod(true,"getHeight"));
 BA.debugLineNum = 91;BA.debugLine="txtDescripcion.Top = pnlSelector.Top";
Debug.ShouldStop(67108864);
editaringresounico.mostCurrent._txtdescripcion.runMethod(true,"setTop",editaringresounico.mostCurrent._pnlselector.runMethod(true,"getTop"));
 BA.debugLineNum = 92;BA.debugLine="txtDescripcion.Left = txtNombre.Left";
Debug.ShouldStop(134217728);
editaringresounico.mostCurrent._txtdescripcion.runMethod(true,"setLeft",editaringresounico.mostCurrent._txtnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 93;BA.debugLine="lblFondoDescripcion.Width = txtDescripcion.Width";
Debug.ShouldStop(268435456);
editaringresounico.mostCurrent._lblfondodescripcion.runMethod(true,"setWidth",editaringresounico.mostCurrent._txtdescripcion.runMethod(true,"getWidth"));
 BA.debugLineNum = 94;BA.debugLine="lblFondoDescripcion.Height = txtDescripcion.Heigh";
Debug.ShouldStop(536870912);
editaringresounico.mostCurrent._lblfondodescripcion.runMethod(true,"setHeight",editaringresounico.mostCurrent._txtdescripcion.runMethod(true,"getHeight"));
 BA.debugLineNum = 95;BA.debugLine="lblFondoDescripcion.Top = txtDescripcion.Top";
Debug.ShouldStop(1073741824);
editaringresounico.mostCurrent._lblfondodescripcion.runMethod(true,"setTop",editaringresounico.mostCurrent._txtdescripcion.runMethod(true,"getTop"));
 BA.debugLineNum = 96;BA.debugLine="lblFondoDescripcion.Left = txtDescripcion.Left";
Debug.ShouldStop(-2147483648);
editaringresounico.mostCurrent._lblfondodescripcion.runMethod(true,"setLeft",editaringresounico.mostCurrent._txtdescripcion.runMethod(true,"getLeft"));
 BA.debugLineNum = 101;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
Debug.ShouldStop(16);
editaringresounico.mostCurrent._pnlnavinferior.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresounico._alturadispositivo,RemoteObject.createImmutable(0.08)}, "*",0, 0)));
 BA.debugLineNum = 102;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
Debug.ShouldStop(32);
editaringresounico.mostCurrent._pnlnavinferior.runMethod(true,"setWidth",editaringresounico._anchodispositivo);
 BA.debugLineNum = 103;BA.debugLine="pnlNavInferior.Left = 0";
Debug.ShouldStop(64);
editaringresounico.mostCurrent._pnlnavinferior.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 104;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
Debug.ShouldStop(128);
editaringresounico.mostCurrent._pnlnavinferior.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {editaringresounico._alturadispositivo,editaringresounico.mostCurrent._pnlnavinferior.runMethod(true,"getHeight")}, "-",1, 1));
 BA.debugLineNum = 107;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
Debug.ShouldStop(1024);
editaringresounico.mostCurrent._btnmenu.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresounico._anchodispositivo,RemoteObject.createImmutable(0.15)}, "*",0, 0)));
 BA.debugLineNum = 108;BA.debugLine="btnMenu.Height = btnMenu.Width";
Debug.ShouldStop(2048);
editaringresounico.mostCurrent._btnmenu.runMethod(true,"setHeight",editaringresounico.mostCurrent._btnmenu.runMethod(true,"getWidth"));
 BA.debugLineNum = 109;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
Debug.ShouldStop(4096);
editaringresounico.mostCurrent._btnmenu.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresounico.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),editaringresounico.mostCurrent._btnmenu.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 110;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
Debug.ShouldStop(8192);
editaringresounico.mostCurrent._btnmenu.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editaringresounico._anchodispositivo,editaringresounico.mostCurrent._btnmenu.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 112;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
Debug.ShouldStop(32768);
editaringresounico.mostCurrent._lblcontornoboton.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresounico._anchodispositivo,RemoteObject.createImmutable(0.17)}, "*",0, 0)));
 BA.debugLineNum = 113;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
Debug.ShouldStop(65536);
editaringresounico.mostCurrent._lblcontornoboton.runMethod(true,"setHeight",editaringresounico.mostCurrent._lblcontornoboton.runMethod(true,"getWidth"));
 BA.debugLineNum = 114;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
Debug.ShouldStop(131072);
editaringresounico.mostCurrent._lblcontornoboton.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editaringresounico._anchodispositivo,editaringresounico.mostCurrent._lblcontornoboton.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 115;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
Debug.ShouldStop(262144);
editaringresounico.mostCurrent._lblcontornoboton.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresounico.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),editaringresounico.mostCurrent._lblcontornoboton.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 120;BA.debugLine="btnOperacionIngresoUnico.Text = \"Editar ingreso ú";
Debug.ShouldStop(8388608);
editaringresounico.mostCurrent._btnoperacioningresounico.runMethod(true,"setText",BA.ObjectToCharSequence("Editar ingreso único"));
 BA.debugLineNum = 121;BA.debugLine="btnOperacionIngresoUnico.Top = txtDescripcion.Top";
Debug.ShouldStop(16777216);
editaringresounico.mostCurrent._btnoperacioningresounico.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresounico.mostCurrent._txtdescripcion.runMethod(true,"getTop"),editaringresounico.mostCurrent._txtdescripcion.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {editaringresounico.mostCurrent._lblcontornoboton.runMethod(true,"getTop"),(RemoteObject.solve(new RemoteObject[] {editaringresounico.mostCurrent._txtdescripcion.runMethod(true,"getTop"),editaringresounico.mostCurrent._txtdescripcion.runMethod(true,"getHeight"),editaringresounico.mostCurrent._btnoperacioningresounico.runMethod(true,"getHeight")}, "++",2, 1))}, "-",1, 1)),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 122;BA.debugLine="btnOperacionIngresoUnico.Left = (anchoDispositivo";
Debug.ShouldStop(33554432);
editaringresounico.mostCurrent._btnoperacioningresounico.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editaringresounico._anchodispositivo,editaringresounico.mostCurrent._btnoperacioningresounico.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (editaringresounico) ","editaringresounico",6,editaringresounico.mostCurrent.activityBA,editaringresounico.mostCurrent,129);
if (RapidSub.canDelegate("activity_pause")) { return pullup.wallet.editaringresounico.remoteMe.runUserSub(false, "editaringresounico","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 129;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (editaringresounico) ","editaringresounico",6,editaringresounico.mostCurrent.activityBA,editaringresounico.mostCurrent,125);
if (RapidSub.canDelegate("activity_resume")) { return pullup.wallet.editaringresounico.remoteMe.runUserSub(false, "editaringresounico","activity_resume");}
 BA.debugLineNum = 125;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(268435456);
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
public static RemoteObject  _asignacioncampos() throws Exception{
try {
		Debug.PushSubsStack("asignacionCampos (editaringresounico) ","editaringresounico",6,editaringresounico.mostCurrent.activityBA,editaringresounico.mostCurrent,191);
if (RapidSub.canDelegate("asignacioncampos")) { return pullup.wallet.editaringresounico.remoteMe.runUserSub(false, "editaringresounico","asignacioncampos");}
RemoteObject _ingresounico = RemoteObject.declareNull("pullup.wallet.main._registroingreso");
 BA.debugLineNum = 191;BA.debugLine="Sub asignacionCampos As RegistroIngreso";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 192;BA.debugLine="Dim ingresoUnico As RegistroIngreso";
Debug.ShouldStop(-2147483648);
_ingresounico = RemoteObject.createNew ("pullup.wallet.main._registroingreso");Debug.locals.put("ingresoUnico", _ingresounico);
 BA.debugLineNum = 194;BA.debugLine="ingresoUnico.monto = txtMonto.Text";
Debug.ShouldStop(2);
_ingresounico.setField ("monto" /*RemoteObject*/ ,BA.numberCast(int.class, editaringresounico.mostCurrent._txtmonto.runMethod(true,"getText")));
 BA.debugLineNum = 196;BA.debugLine="ingresoUnico.nombre = txtNombre.Text";
Debug.ShouldStop(8);
_ingresounico.setField ("nombre" /*RemoteObject*/ ,editaringresounico.mostCurrent._txtnombre.runMethod(true,"getText"));
 BA.debugLineNum = 198;BA.debugLine="ingresoUnico.descripcion = (txtDescripcion.Text)";
Debug.ShouldStop(32);
_ingresounico.setField ("descripcion" /*RemoteObject*/ ,(editaringresounico.mostCurrent._txtdescripcion.runMethod(true,"getText")));
 BA.debugLineNum = 200;BA.debugLine="ingresoUnico.color = colorCaja";
Debug.ShouldStop(128);
_ingresounico.setField ("color" /*RemoteObject*/ ,editaringresounico._colorcaja);
 BA.debugLineNum = 202;BA.debugLine="Return ingresoUnico";
Debug.ShouldStop(512);
if (true) return _ingresounico;
 BA.debugLineNum = 203;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("btnMenu_Click (editaringresounico) ","editaringresounico",6,editaringresounico.mostCurrent.activityBA,editaringresounico.mostCurrent,133);
if (RapidSub.canDelegate("btnmenu_click")) { return pullup.wallet.editaringresounico.remoteMe.runUserSub(false, "editaringresounico","btnmenu_click");}
 BA.debugLineNum = 133;BA.debugLine="Private Sub btnMenu_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 134;BA.debugLine="Activity.Finish";
Debug.ShouldStop(32);
editaringresounico.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _btnoperacioningresounico_click() throws Exception{
try {
		Debug.PushSubsStack("btnOperacionIngresoUnico_Click (editaringresounico) ","editaringresounico",6,editaringresounico.mostCurrent.activityBA,editaringresounico.mostCurrent,207);
if (RapidSub.canDelegate("btnoperacioningresounico_click")) { return pullup.wallet.editaringresounico.remoteMe.runUserSub(false, "editaringresounico","btnoperacioningresounico_click");}
RemoteObject _validaciones = RemoteObject.createImmutable(false);
RemoteObject _ingresounicoregistro = RemoteObject.declareNull("pullup.wallet.main._registroingreso");
 BA.debugLineNum = 207;BA.debugLine="Private Sub btnOperacionIngresoUnico_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 208;BA.debugLine="Dim validaciones As Boolean";
Debug.ShouldStop(32768);
_validaciones = RemoteObject.createImmutable(false);Debug.locals.put("validaciones", _validaciones);
 BA.debugLineNum = 210;BA.debugLine="validaciones = validarCampos";
Debug.ShouldStop(131072);
_validaciones = _validarcampos();Debug.locals.put("validaciones", _validaciones);
 BA.debugLineNum = 211;BA.debugLine="If(validaciones = True) Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",_validaciones,editaringresounico.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 213;BA.debugLine="Dim ingresoUnicoRegistro As RegistroIngreso";
Debug.ShouldStop(1048576);
_ingresounicoregistro = RemoteObject.createNew ("pullup.wallet.main._registroingreso");Debug.locals.put("ingresoUnicoRegistro", _ingresounicoregistro);
 BA.debugLineNum = 214;BA.debugLine="ingresoUnicoRegistro = asignacionCampos";
Debug.ShouldStop(2097152);
_ingresounicoregistro = _asignacioncampos();Debug.locals.put("ingresoUnicoRegistro", _ingresounicoregistro);
 BA.debugLineNum = 217;BA.debugLine="cur = sql.ExecQuery2(\"SELECT monto FROM ingresos";
Debug.ShouldStop(16777216);
editaringresounico.mostCurrent._cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), editaringresounico._sql.runMethod(false,"ExecQuery2",(Object)(BA.ObjectToString("SELECT monto FROM ingresos_unicos WHERE id_ingreso_unico = ?")),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {RemoteObject.concat(editaringresounico._idregistro,RemoteObject.createImmutable(""))}))));
 BA.debugLineNum = 218;BA.debugLine="cur.Position = 0";
Debug.ShouldStop(33554432);
editaringresounico.mostCurrent._cur.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 220;BA.debugLine="montoAntiguo = cur.GetInt(\"monto\")";
Debug.ShouldStop(134217728);
editaringresounico._montoantiguo = editaringresounico.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("monto")));
 BA.debugLineNum = 221;BA.debugLine="montoNuevo = ingresoUnicoRegistro.monto";
Debug.ShouldStop(268435456);
editaringresounico._montonuevo = _ingresounicoregistro.getField(true,"monto" /*RemoteObject*/ );
 BA.debugLineNum = 224;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM ingresos WHER";
Debug.ShouldStop(-2147483648);
editaringresounico.mostCurrent._cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), editaringresounico._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM ingresos WHERE id_ingreso = 1"))));
 BA.debugLineNum = 225;BA.debugLine="cur.Position = 0";
Debug.ShouldStop(1);
editaringresounico.mostCurrent._cur.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 226;BA.debugLine="sumaIngresosAntigua = cur.GetInt(\"suma_ingresos\"";
Debug.ShouldStop(2);
editaringresounico._sumaingresosantigua = editaringresounico.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("suma_ingresos")));
 BA.debugLineNum = 229;BA.debugLine="sumaIngresosActual = (sumaIngresosAntigua - mont";
Debug.ShouldStop(16);
editaringresounico._sumaingresosactual = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editaringresounico._sumaingresosantigua,editaringresounico._montoantiguo}, "-",1, 1)),editaringresounico._montonuevo}, "+",1, 1);
 BA.debugLineNum = 232;BA.debugLine="sql.ExecNonQuery2(\"UPDATE ingresos SET suma_ingr";
Debug.ShouldStop(128);
editaringresounico._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE ingresos SET suma_ingresos = ? WHERE id_ingreso = 1")),(Object)(editaringresounico.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(editaringresounico._sumaingresosactual)})))));
 BA.debugLineNum = 235;BA.debugLine="Starter.sql.ExecNonQuery2(\"UPDATE ingresos_unico";
Debug.ShouldStop(1024);
editaringresounico.mostCurrent._starter._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery2",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE ingresos_unicos SET monto = ?, nombre = ?, descripcion = ?, color = ?  WHERE id_ingreso_unico = '"),editaringresounico._idregistro,RemoteObject.createImmutable("'"))),(Object)(editaringresounico.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {4},new Object[] {(_ingresounicoregistro.getField(true,"monto" /*RemoteObject*/ )),(_ingresounicoregistro.getField(true,"nombre" /*RemoteObject*/ )),(_ingresounicoregistro.getField(true,"descripcion" /*RemoteObject*/ )),(_ingresounicoregistro.getField(true,"color" /*RemoteObject*/ ))})))));
 BA.debugLineNum = 237;BA.debugLine="ToastMessageShow(\"Ingreso único editado\",True)";
Debug.ShouldStop(4096);
editaringresounico.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Ingreso único editado")),(Object)(editaringresounico.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 239;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16384);
editaringresounico.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 241;BA.debugLine="StartActivity(IngresosUnicos)";
Debug.ShouldStop(65536);
editaringresounico.mostCurrent.__c.runVoidMethod ("StartActivity",editaringresounico.processBA,(Object)((editaringresounico.mostCurrent._ingresosunicos.getObject())));
 }else {
 BA.debugLineNum = 244;BA.debugLine="Msgbox2(\"Por favor, rellene todos los campos y s";
Debug.ShouldStop(524288);
editaringresounico.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("Por favor, rellene todos los campos y seleccione un color")),(Object)(BA.ObjectToCharSequence("Registro incorrecto")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((editaringresounico.mostCurrent.__c.getField(false,"Null"))),editaringresounico.mostCurrent.activityBA);
 };
 BA.debugLineNum = 246;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("consultaAEditar (editaringresounico) ","editaringresounico",6,editaringresounico.mostCurrent.activityBA,editaringresounico.mostCurrent,249);
if (RapidSub.canDelegate("consultaaeditar")) { return pullup.wallet.editaringresounico.remoteMe.runUserSub(false, "editaringresounico","consultaaeditar", _rowid);}
RemoteObject _ingresounico = RemoteObject.declareNull("pullup.wallet.main._registroingreso");
Debug.locals.put("rowid", _rowid);
 BA.debugLineNum = 249;BA.debugLine="Sub consultaAEditar(rowid As Int)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 250;BA.debugLine="Dim ingresoUnico As RegistroIngreso";
Debug.ShouldStop(33554432);
_ingresounico = RemoteObject.createNew ("pullup.wallet.main._registroingreso");Debug.locals.put("ingresoUnico", _ingresounico);
 BA.debugLineNum = 251;BA.debugLine="idRegistro = rowid";
Debug.ShouldStop(67108864);
editaringresounico._idregistro = _rowid;
 BA.debugLineNum = 253;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM ingresos_unico";
Debug.ShouldStop(268435456);
editaringresounico.mostCurrent._cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), editaringresounico._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM ingresos_unicos WHERE id_ingreso_unico = '"),editaringresounico._idregistro,RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 254;BA.debugLine="If(cur.RowCount > 0) Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean(">",editaringresounico.mostCurrent._cur.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 255;BA.debugLine="cur.Position = 0";
Debug.ShouldStop(1073741824);
editaringresounico.mostCurrent._cur.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 256;BA.debugLine="ingresoUnico.nombre = cur.GetString(\"nombre\")";
Debug.ShouldStop(-2147483648);
_ingresounico.setField ("nombre" /*RemoteObject*/ ,editaringresounico.mostCurrent._cur.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("nombre"))));
 BA.debugLineNum = 257;BA.debugLine="ingresoUnico.monto = cur.GetInt(\"monto\")";
Debug.ShouldStop(1);
_ingresounico.setField ("monto" /*RemoteObject*/ ,editaringresounico.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("monto"))));
 BA.debugLineNum = 258;BA.debugLine="ingresoUnico.descripcion = cur.GetString(\"descri";
Debug.ShouldStop(2);
_ingresounico.setField ("descripcion" /*RemoteObject*/ ,editaringresounico.mostCurrent._cur.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("descripcion"))));
 BA.debugLineNum = 259;BA.debugLine="ingresoUnico.color = cur.GetString(\"color\")";
Debug.ShouldStop(4);
_ingresounico.setField ("color" /*RemoteObject*/ ,BA.numberCast(int.class, editaringresounico.mostCurrent._cur.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("color")))));
 BA.debugLineNum = 261;BA.debugLine="reasignarCamposAEditar(ingresoUnico)";
Debug.ShouldStop(16);
_reasignarcamposaeditar(_ingresounico);
 };
 BA.debugLineNum = 263;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("cpBarraColor_ColorChanged (editaringresounico) ","editaringresounico",6,editaringresounico.mostCurrent.activityBA,editaringresounico.mostCurrent,185);
if (RapidSub.canDelegate("cpbarracolor_colorchanged")) { return pullup.wallet.editaringresounico.remoteMe.runUserSub(false, "editaringresounico","cpbarracolor_colorchanged", _color);}
Debug.locals.put("color", _color);
 BA.debugLineNum = 185;BA.debugLine="Sub cpBarraColor_ColorChanged(color As Int)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 186;BA.debugLine="lblFondoMonto.Color = color";
Debug.ShouldStop(33554432);
editaringresounico.mostCurrent._lblfondomonto.runVoidMethod ("setColor",_color);
 BA.debugLineNum = 187;BA.debugLine="colorCaja = color";
Debug.ShouldStop(67108864);
editaringresounico._colorcaja = _color;
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
 //BA.debugLineNum = 15;BA.debugLine="Dim alturaDispositivo As Int";
editaringresounico._alturadispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 16;BA.debugLine="Dim anchoDispositivo As Int";
editaringresounico._anchodispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 17;BA.debugLine="Dim colorCaja As Int";
editaringresounico._colorcaja = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 18;BA.debugLine="Dim aparicionMsgBox1 As Boolean";
editaringresounico._aparicionmsgbox1 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 19;BA.debugLine="Dim aparicionMsgBox2 As Boolean";
editaringresounico._aparicionmsgbox2 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 20;BA.debugLine="Dim aparicionMsgBox3 As Boolean";
editaringresounico._aparicionmsgbox3 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 21;BA.debugLine="Dim cur As Cursor";
editaringresounico.mostCurrent._cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Dim idRegistro As Int";
editaringresounico._idregistro = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 23;BA.debugLine="Dim sumaIngresosAntigua As Int";
editaringresounico._sumaingresosantigua = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 24;BA.debugLine="Dim montoAntiguo As Int";
editaringresounico._montoantiguo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 25;BA.debugLine="Dim montoNuevo As Int";
editaringresounico._montonuevo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 26;BA.debugLine="Dim sumaIngresosActual As Int";
editaringresounico._sumaingresosactual = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 30;BA.debugLine="Private btnMenu As Button";
editaringresounico.mostCurrent._btnmenu = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private btnOperacionIngresoUnico As Button";
editaringresounico.mostCurrent._btnoperacioningresounico = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private txtDescripcion As EditText";
editaringresounico.mostCurrent._txtdescripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private txtMonto As EditText";
editaringresounico.mostCurrent._txtmonto = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private txtNombre As EditText";
editaringresounico.mostCurrent._txtnombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private lblFondoMonto As Label";
editaringresounico.mostCurrent._lblfondomonto = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private lblFondoDescripcion As Label";
editaringresounico.mostCurrent._lblfondodescripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private lblFondoNombre As Label";
editaringresounico.mostCurrent._lblfondonombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private lblContornoBoton As Label";
editaringresounico.mostCurrent._lblcontornoboton = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private lblNombreVista As Label";
editaringresounico.mostCurrent._lblnombrevista = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private pnlNavInferior As Panel";
editaringresounico.mostCurrent._pnlnavinferior = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private pnlSelector As Panel";
editaringresounico.mostCurrent._pnlselector = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private cpBarraColor As ASColorSlider  'Miembro g";
editaringresounico.mostCurrent._cpbarracolor = RemoteObject.createNew ("pullup.wallet.ascolorslider");
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _limitarlongitudentrada(RemoteObject _antiguo,RemoteObject _nuevo,RemoteObject _longitud,RemoteObject _view,RemoteObject _campo) throws Exception{
try {
		Debug.PushSubsStack("limitarLongitudEntrada (editaringresounico) ","editaringresounico",6,editaringresounico.mostCurrent.activityBA,editaringresounico.mostCurrent,148);
if (RapidSub.canDelegate("limitarlongitudentrada")) { return pullup.wallet.editaringresounico.remoteMe.runUserSub(false, "editaringresounico","limitarlongitudentrada", _antiguo, _nuevo, _longitud, _view, _campo);}
Debug.locals.put("antiguo", _antiguo);
Debug.locals.put("nuevo", _nuevo);
Debug.locals.put("longitud", _longitud);
Debug.locals.put("view", _view);
Debug.locals.put("campo", _campo);
 BA.debugLineNum = 148;BA.debugLine="Sub limitarLongitudEntrada(antiguo As String, nuev";
Debug.ShouldStop(524288);
 BA.debugLineNum = 149;BA.debugLine="If(nuevo.Length > longitud) Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean(">",_nuevo.runMethod(true,"length"),BA.numberCast(double.class, _longitud)))) { 
 BA.debugLineNum = 150;BA.debugLine="If(campo = \"monto\") Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("monto")))) { 
 BA.debugLineNum = 151;BA.debugLine="If(aparicionMsgBox1 = False) Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("=",editaringresounico._aparicionmsgbox1,editaringresounico.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 152;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
Debug.ShouldStop(8388608);
editaringresounico.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para el monto es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((editaringresounico.mostCurrent.__c.getField(false,"Null"))),editaringresounico.mostCurrent.activityBA);
 BA.debugLineNum = 153;BA.debugLine="aparicionMsgBox1 = True";
Debug.ShouldStop(16777216);
editaringresounico._aparicionmsgbox1 = editaringresounico.mostCurrent.__c.getField(true,"True");
 };
 }else 
{ BA.debugLineNum = 155;BA.debugLine="Else If(campo = \"nombre\") Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("nombre")))) { 
 BA.debugLineNum = 156;BA.debugLine="If(aparicionMsgBox2 = False) Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",editaringresounico._aparicionmsgbox2,editaringresounico.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 157;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
Debug.ShouldStop(268435456);
editaringresounico.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para el nombre es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((editaringresounico.mostCurrent.__c.getField(false,"Null"))),editaringresounico.mostCurrent.activityBA);
 BA.debugLineNum = 158;BA.debugLine="aparicionMsgBox2 = True";
Debug.ShouldStop(536870912);
editaringresounico._aparicionmsgbox2 = editaringresounico.mostCurrent.__c.getField(true,"True");
 };
 }else 
{ BA.debugLineNum = 160;BA.debugLine="Else If(campo = \"descripcion\") Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("descripcion")))) { 
 BA.debugLineNum = 161;BA.debugLine="If(aparicionMsgBox3 = False) Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",editaringresounico._aparicionmsgbox3,editaringresounico.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 162;BA.debugLine="Msgbox2(\"La longitud máxima permitida para la";
Debug.ShouldStop(2);
editaringresounico.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para la descripción es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((editaringresounico.mostCurrent.__c.getField(false,"Null"))),editaringresounico.mostCurrent.activityBA);
 BA.debugLineNum = 163;BA.debugLine="aparicionMsgBox3 = True";
Debug.ShouldStop(4);
editaringresounico._aparicionmsgbox3 = editaringresounico.mostCurrent.__c.getField(true,"True");
 };
 }}}
;
 BA.debugLineNum = 166;BA.debugLine="view.Text = antiguo";
Debug.ShouldStop(32);
_view.runMethod(true,"setText",BA.ObjectToCharSequence(_antiguo));
 };
 BA.debugLineNum = 168;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
editaringresounico._sql = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _reasignarcamposaeditar(RemoteObject _registro) throws Exception{
try {
		Debug.PushSubsStack("reasignarCamposAEditar (editaringresounico) ","editaringresounico",6,editaringresounico.mostCurrent.activityBA,editaringresounico.mostCurrent,266);
if (RapidSub.canDelegate("reasignarcamposaeditar")) { return pullup.wallet.editaringresounico.remoteMe.runUserSub(false, "editaringresounico","reasignarcamposaeditar", _registro);}
Debug.locals.put("registro", _registro);
 BA.debugLineNum = 266;BA.debugLine="Sub reasignarCamposAEditar(registro As RegistroIng";
Debug.ShouldStop(512);
 BA.debugLineNum = 267;BA.debugLine="txtNombre.Text = registro.nombre";
Debug.ShouldStop(1024);
editaringresounico.mostCurrent._txtnombre.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_registro.getField(true,"nombre" /*RemoteObject*/ )));
 BA.debugLineNum = 268;BA.debugLine="txtMonto.Text = registro.monto";
Debug.ShouldStop(2048);
editaringresounico.mostCurrent._txtmonto.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_registro.getField(true,"monto" /*RemoteObject*/ )));
 BA.debugLineNum = 269;BA.debugLine="txtDescripcion.Text = registro.descripcion";
Debug.ShouldStop(4096);
editaringresounico.mostCurrent._txtdescripcion.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_registro.getField(true,"descripcion" /*RemoteObject*/ )));
 BA.debugLineNum = 271;BA.debugLine="cpBarraColor_ColorChanged(registro.color)";
Debug.ShouldStop(16384);
_cpbarracolor_colorchanged(_registro.getField(true,"color" /*RemoteObject*/ ));
 BA.debugLineNum = 272;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("txtDescripcion_TextChanged (editaringresounico) ","editaringresounico",6,editaringresounico.mostCurrent.activityBA,editaringresounico.mostCurrent,179);
if (RapidSub.canDelegate("txtdescripcion_textchanged")) { return pullup.wallet.editaringresounico.remoteMe.runUserSub(false, "editaringresounico","txtdescripcion_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 179;BA.debugLine="Private Sub txtDescripcion_TextChanged (Old As Str";
Debug.ShouldStop(262144);
 BA.debugLineNum = 180;BA.debugLine="limitarLongitudEntrada(Old, New, 41, txtDescripci";
Debug.ShouldStop(524288);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 41),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), editaringresounico.mostCurrent._txtdescripcion.getObject()),RemoteObject.createImmutable("descripcion"));
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
public static RemoteObject  _txtmonto_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtMonto_TextChanged (editaringresounico) ","editaringresounico",6,editaringresounico.mostCurrent.activityBA,editaringresounico.mostCurrent,171);
if (RapidSub.canDelegate("txtmonto_textchanged")) { return pullup.wallet.editaringresounico.remoteMe.runUserSub(false, "editaringresounico","txtmonto_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 171;BA.debugLine="Private Sub txtMonto_TextChanged (Old As String, N";
Debug.ShouldStop(1024);
 BA.debugLineNum = 172;BA.debugLine="limitarLongitudEntrada(Old, New, 9, txtMonto, \"mo";
Debug.ShouldStop(2048);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 9),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), editaringresounico.mostCurrent._txtmonto.getObject()),RemoteObject.createImmutable("monto"));
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
public static RemoteObject  _txtnombre_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtNombre_TextChanged (editaringresounico) ","editaringresounico",6,editaringresounico.mostCurrent.activityBA,editaringresounico.mostCurrent,175);
if (RapidSub.canDelegate("txtnombre_textchanged")) { return pullup.wallet.editaringresounico.remoteMe.runUserSub(false, "editaringresounico","txtnombre_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 175;BA.debugLine="Private Sub txtNombre_TextChanged (Old As String,";
Debug.ShouldStop(16384);
 BA.debugLineNum = 176;BA.debugLine="limitarLongitudEntrada(Old, New, 16, txtNombre, \"";
Debug.ShouldStop(32768);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 16),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), editaringresounico.mostCurrent._txtnombre.getObject()),RemoteObject.createImmutable("nombre"));
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
public static RemoteObject  _validarcampos() throws Exception{
try {
		Debug.PushSubsStack("validarCampos (editaringresounico) ","editaringresounico",6,editaringresounico.mostCurrent.activityBA,editaringresounico.mostCurrent,138);
if (RapidSub.canDelegate("validarcampos")) { return pullup.wallet.editaringresounico.remoteMe.runUserSub(false, "editaringresounico","validarcampos");}
 BA.debugLineNum = 138;BA.debugLine="Sub validarCampos As Boolean";
Debug.ShouldStop(512);
 BA.debugLineNum = 139;BA.debugLine="If(txtMonto.Text.Length <> 0 And txtNombre.Text.L";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("!",editaringresounico.mostCurrent._txtmonto.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",editaringresounico.mostCurrent._txtnombre.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",editaringresounico.mostCurrent._txtdescripcion.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",editaringresounico._colorcaja,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 140;BA.debugLine="Return True";
Debug.ShouldStop(2048);
if (true) return editaringresounico.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 142;BA.debugLine="Return False";
Debug.ShouldStop(8192);
if (true) return editaringresounico.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 144;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}