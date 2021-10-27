package pullup.wallet;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class editarsuscripcion_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (editarsuscripcion) ","editarsuscripcion",8,editarsuscripcion.mostCurrent.activityBA,editarsuscripcion.mostCurrent,52);
if (RapidSub.canDelegate("activity_create")) { return pullup.wallet.editarsuscripcion.remoteMe.runUserSub(false, "editarsuscripcion","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 52;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 53;BA.debugLine="Activity.LoadLayout(\"LFormSuscripcion\")";
Debug.ShouldStop(1048576);
editarsuscripcion.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("LFormSuscripcion")),editarsuscripcion.mostCurrent.activityBA);
 BA.debugLineNum = 54;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
Debug.ShouldStop(2097152);
editarsuscripcion._alturadispositivo = editarsuscripcion.mostCurrent._main._alturadispositivo /*RemoteObject*/ ;
 BA.debugLineNum = 55;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
Debug.ShouldStop(4194304);
editarsuscripcion._anchodispositivo = editarsuscripcion.mostCurrent._main._anchodispositivo /*RemoteObject*/ ;
 BA.debugLineNum = 56;BA.debugLine="sql = Starter.sql";
Debug.ShouldStop(8388608);
editarsuscripcion._sql = editarsuscripcion.mostCurrent._starter._sql /*RemoteObject*/ ;
 BA.debugLineNum = 57;BA.debugLine="aparicionMsgBox1 = False";
Debug.ShouldStop(16777216);
editarsuscripcion._aparicionmsgbox1 = editarsuscripcion.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 58;BA.debugLine="aparicionMsgBox2 = False";
Debug.ShouldStop(33554432);
editarsuscripcion._aparicionmsgbox2 = editarsuscripcion.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 59;BA.debugLine="aparicionMsgBox3 = False";
Debug.ShouldStop(67108864);
editarsuscripcion._aparicionmsgbox3 = editarsuscripcion.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 62;BA.debugLine="lblNombreVista.TextSize = 20";
Debug.ShouldStop(536870912);
editarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 63;BA.debugLine="lblNombreVista.TextColor = Colors.Black";
Debug.ShouldStop(1073741824);
editarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"setTextColor",editarsuscripcion.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 64;BA.debugLine="lblNombreVista.Height = 30dip";
Debug.ShouldStop(-2147483648);
editarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"setHeight",editarsuscripcion.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 65;BA.debugLine="lblNombreVista.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(1);
editarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarsuscripcion._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 66;BA.debugLine="lblNombreVista.Top = 30dip";
Debug.ShouldStop(2);
editarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"setTop",editarsuscripcion.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 67;BA.debugLine="lblNombreVista.Left = (anchoDispositivo - lblNomb";
Debug.ShouldStop(4);
editarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editarsuscripcion._anchodispositivo,editarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 69;BA.debugLine="txtMonto.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(16);
editarsuscripcion.mostCurrent._txtmonto.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarsuscripcion._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 70;BA.debugLine="txtMonto.Height = alturaDispositivo * 0.22";
Debug.ShouldStop(32);
editarsuscripcion.mostCurrent._txtmonto.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarsuscripcion._alturadispositivo,RemoteObject.createImmutable(0.22)}, "*",0, 0)));
 BA.debugLineNum = 71;BA.debugLine="txtMonto.Top = lblNombreVista.Top * 2 + lblNombre";
Debug.ShouldStop(64);
editarsuscripcion.mostCurrent._txtmonto.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {editarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2),editarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"getHeight")}, "*+",1, 1));
 BA.debugLineNum = 72;BA.debugLine="txtMonto.Left = (anchoDispositivo - txtMonto.Widt";
Debug.ShouldStop(128);
editarsuscripcion.mostCurrent._txtmonto.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editarsuscripcion._anchodispositivo,editarsuscripcion.mostCurrent._txtmonto.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 73;BA.debugLine="lblFondoMonto.Width = txtMonto.Width";
Debug.ShouldStop(256);
editarsuscripcion.mostCurrent._lblfondomonto.runMethod(true,"setWidth",editarsuscripcion.mostCurrent._txtmonto.runMethod(true,"getWidth"));
 BA.debugLineNum = 74;BA.debugLine="lblFondoMonto.Height = txtMonto.Height";
Debug.ShouldStop(512);
editarsuscripcion.mostCurrent._lblfondomonto.runMethod(true,"setHeight",editarsuscripcion.mostCurrent._txtmonto.runMethod(true,"getHeight"));
 BA.debugLineNum = 75;BA.debugLine="lblFondoMonto.Top = txtMonto.Top";
Debug.ShouldStop(1024);
editarsuscripcion.mostCurrent._lblfondomonto.runMethod(true,"setTop",editarsuscripcion.mostCurrent._txtmonto.runMethod(true,"getTop"));
 BA.debugLineNum = 76;BA.debugLine="lblFondoMonto.Left = txtMonto.Left";
Debug.ShouldStop(2048);
editarsuscripcion.mostCurrent._lblfondomonto.runMethod(true,"setLeft",editarsuscripcion.mostCurrent._txtmonto.runMethod(true,"getLeft"));
 BA.debugLineNum = 78;BA.debugLine="txtNombre.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(8192);
editarsuscripcion.mostCurrent._txtnombre.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarsuscripcion._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 79;BA.debugLine="txtNombre.Height = alturaDispositivo * 0.07";
Debug.ShouldStop(16384);
editarsuscripcion.mostCurrent._txtnombre.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarsuscripcion._alturadispositivo,RemoteObject.createImmutable(0.07)}, "*",0, 0)));
 BA.debugLineNum = 80;BA.debugLine="txtNombre.Top = txtMonto.Top + txtMonto.Height +";
Debug.ShouldStop(32768);
editarsuscripcion.mostCurrent._txtnombre.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarsuscripcion.mostCurrent._txtmonto.runMethod(true,"getTop"),editarsuscripcion.mostCurrent._txtmonto.runMethod(true,"getHeight"),editarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 81;BA.debugLine="txtNombre.Left = (anchoDispositivo - txtNombre.Wi";
Debug.ShouldStop(65536);
editarsuscripcion.mostCurrent._txtnombre.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editarsuscripcion._anchodispositivo,editarsuscripcion.mostCurrent._txtnombre.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 82;BA.debugLine="lblFondoNombre.Width = txtMonto.Width";
Debug.ShouldStop(131072);
editarsuscripcion.mostCurrent._lblfondonombre.runMethod(true,"setWidth",editarsuscripcion.mostCurrent._txtmonto.runMethod(true,"getWidth"));
 BA.debugLineNum = 83;BA.debugLine="lblFondoNombre.Height = txtNombre.Height";
Debug.ShouldStop(262144);
editarsuscripcion.mostCurrent._lblfondonombre.runMethod(true,"setHeight",editarsuscripcion.mostCurrent._txtnombre.runMethod(true,"getHeight"));
 BA.debugLineNum = 84;BA.debugLine="lblFondoNombre.Top = txtNombre.Top";
Debug.ShouldStop(524288);
editarsuscripcion.mostCurrent._lblfondonombre.runMethod(true,"setTop",editarsuscripcion.mostCurrent._txtnombre.runMethod(true,"getTop"));
 BA.debugLineNum = 85;BA.debugLine="lblFondoNombre.Left = txtNombre.Left";
Debug.ShouldStop(1048576);
editarsuscripcion.mostCurrent._lblfondonombre.runMethod(true,"setLeft",editarsuscripcion.mostCurrent._txtnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 87;BA.debugLine="txtDescripcion.Width = txtNombre.Width";
Debug.ShouldStop(4194304);
editarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"setWidth",editarsuscripcion.mostCurrent._txtnombre.runMethod(true,"getWidth"));
 BA.debugLineNum = 88;BA.debugLine="txtDescripcion.Height = txtNombre.Height";
Debug.ShouldStop(8388608);
editarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"setHeight",editarsuscripcion.mostCurrent._txtnombre.runMethod(true,"getHeight"));
 BA.debugLineNum = 89;BA.debugLine="txtDescripcion.Top = txtNombre.Top + txtNombre.He";
Debug.ShouldStop(16777216);
editarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarsuscripcion.mostCurrent._txtnombre.runMethod(true,"getTop"),editarsuscripcion.mostCurrent._txtnombre.runMethod(true,"getHeight"),editarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 90;BA.debugLine="txtDescripcion.Left = txtNombre.Left";
Debug.ShouldStop(33554432);
editarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"setLeft",editarsuscripcion.mostCurrent._txtnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 91;BA.debugLine="lblFondoDescripcion.Width = txtDescripcion.Width";
Debug.ShouldStop(67108864);
editarsuscripcion.mostCurrent._lblfondodescripcion.runMethod(true,"setWidth",editarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getWidth"));
 BA.debugLineNum = 92;BA.debugLine="lblFondoDescripcion.Height = txtDescripcion.Heigh";
Debug.ShouldStop(134217728);
editarsuscripcion.mostCurrent._lblfondodescripcion.runMethod(true,"setHeight",editarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getHeight"));
 BA.debugLineNum = 93;BA.debugLine="lblFondoDescripcion.Top = txtDescripcion.Top";
Debug.ShouldStop(268435456);
editarsuscripcion.mostCurrent._lblfondodescripcion.runMethod(true,"setTop",editarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getTop"));
 BA.debugLineNum = 94;BA.debugLine="lblFondoDescripcion.Left = txtDescripcion.Left";
Debug.ShouldStop(536870912);
editarsuscripcion.mostCurrent._lblfondodescripcion.runMethod(true,"setLeft",editarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getLeft"));
 BA.debugLineNum = 96;BA.debugLine="pnlSelector.Top = txtDescripcion.Top + txtDescrip";
Debug.ShouldStop(-2147483648);
editarsuscripcion.mostCurrent._pnlselector.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getTop"),editarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getHeight"),editarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 97;BA.debugLine="pnlSelector.Left = txtDescripcion.Left + txtDescr";
Debug.ShouldStop(1);
editarsuscripcion.mostCurrent._pnlselector.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {editarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getLeft"),editarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getWidth"),editarsuscripcion.mostCurrent._pnlselector.runMethod(true,"getWidth")}, "+-",2, 1));
 BA.debugLineNum = 99;BA.debugLine="pnlPeriodos.Top = pnlSelector.Top";
Debug.ShouldStop(4);
editarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"setTop",editarsuscripcion.mostCurrent._pnlselector.runMethod(true,"getTop"));
 BA.debugLineNum = 100;BA.debugLine="pnlPeriodos.Left = txtDescripcion.Left";
Debug.ShouldStop(8);
editarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"setLeft",editarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getLeft"));
 BA.debugLineNum = 101;BA.debugLine="pnlPeriodos.Width = (txtDescripcion.Width - pnlSe";
Debug.ShouldStop(16);
editarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getWidth"),editarsuscripcion.mostCurrent._pnlselector.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 102;BA.debugLine="pnlPeriodos.Height = pnlSelector.Height";
Debug.ShouldStop(32);
editarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"setHeight",editarsuscripcion.mostCurrent._pnlselector.runMethod(true,"getHeight"));
 BA.debugLineNum = 105;BA.debugLine="rd1Semana.Width = pnlPeriodos.Width";
Debug.ShouldStop(256);
editarsuscripcion.mostCurrent._rd1semana.runMethod(true,"setWidth",editarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"getWidth"));
 BA.debugLineNum = 106;BA.debugLine="rd1Semana.Height = pnlPeriodos.Height * 0.18";
Debug.ShouldStop(512);
editarsuscripcion.mostCurrent._rd1semana.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.18)}, "*",0, 0)));
 BA.debugLineNum = 107;BA.debugLine="rd1Semana.Left = 0";
Debug.ShouldStop(1024);
editarsuscripcion.mostCurrent._rd1semana.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 108;BA.debugLine="rd1Semana.Top = 0";
Debug.ShouldStop(2048);
editarsuscripcion.mostCurrent._rd1semana.runMethod(true,"setTop",BA.numberCast(int.class, 0));
 BA.debugLineNum = 110;BA.debugLine="rd2Semanas.Width = rd1Semana.Width";
Debug.ShouldStop(8192);
editarsuscripcion.mostCurrent._rd2semanas.runMethod(true,"setWidth",editarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 111;BA.debugLine="rd2Semanas.Height = rd1Semana.Height";
Debug.ShouldStop(16384);
editarsuscripcion.mostCurrent._rd2semanas.runMethod(true,"setHeight",editarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 112;BA.debugLine="rd2Semanas.Left = rd1Semana.Left";
Debug.ShouldStop(32768);
editarsuscripcion.mostCurrent._rd2semanas.runMethod(true,"setLeft",editarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 113;BA.debugLine="rd2Semanas.Top = rd1Semana.Height + pnlPeriodos.H";
Debug.ShouldStop(65536);
editarsuscripcion.mostCurrent._rd2semanas.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getHeight"),editarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "+*",1, 0)));
 BA.debugLineNum = 115;BA.debugLine="rd3Semanas.Width = rd1Semana.Width";
Debug.ShouldStop(262144);
editarsuscripcion.mostCurrent._rd3semanas.runMethod(true,"setWidth",editarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 116;BA.debugLine="rd3Semanas.Height = rd1Semana.Height";
Debug.ShouldStop(524288);
editarsuscripcion.mostCurrent._rd3semanas.runMethod(true,"setHeight",editarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 117;BA.debugLine="rd3Semanas.Left = rd1Semana.Left";
Debug.ShouldStop(1048576);
editarsuscripcion.mostCurrent._rd3semanas.runMethod(true,"setLeft",editarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 118;BA.debugLine="rd3Semanas.Top = rd2Semanas.Top + rd2Semanas.Heig";
Debug.ShouldStop(2097152);
editarsuscripcion.mostCurrent._rd3semanas.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarsuscripcion.mostCurrent._rd2semanas.runMethod(true,"getTop"),editarsuscripcion.mostCurrent._rd2semanas.runMethod(true,"getHeight"),editarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "++*",2, 0)));
 BA.debugLineNum = 120;BA.debugLine="rd1Mes.Width = rd1Semana.Width";
Debug.ShouldStop(8388608);
editarsuscripcion.mostCurrent._rd1mes.runMethod(true,"setWidth",editarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 121;BA.debugLine="rd1Mes.Height = rd1Semana.Height";
Debug.ShouldStop(16777216);
editarsuscripcion.mostCurrent._rd1mes.runMethod(true,"setHeight",editarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 122;BA.debugLine="rd1Mes.Left = rd1Semana.Left";
Debug.ShouldStop(33554432);
editarsuscripcion.mostCurrent._rd1mes.runMethod(true,"setLeft",editarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 123;BA.debugLine="rd1Mes.Top = rd3Semanas.Top + rd3Semanas.Height +";
Debug.ShouldStop(67108864);
editarsuscripcion.mostCurrent._rd1mes.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarsuscripcion.mostCurrent._rd3semanas.runMethod(true,"getTop"),editarsuscripcion.mostCurrent._rd3semanas.runMethod(true,"getHeight"),editarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "++*",2, 0)));
 BA.debugLineNum = 125;BA.debugLine="rd1Ano.Width = rd1Semana.Width";
Debug.ShouldStop(268435456);
editarsuscripcion.mostCurrent._rd1ano.runMethod(true,"setWidth",editarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 126;BA.debugLine="rd1Ano.Height = rd1Semana.Height";
Debug.ShouldStop(536870912);
editarsuscripcion.mostCurrent._rd1ano.runMethod(true,"setHeight",editarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 127;BA.debugLine="rd1Ano.Left = rd1Semana.Left";
Debug.ShouldStop(1073741824);
editarsuscripcion.mostCurrent._rd1ano.runMethod(true,"setLeft",editarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 128;BA.debugLine="rd1Ano.Top = rd1Mes.Top + rd1Mes.Height + pnlPeri";
Debug.ShouldStop(-2147483648);
editarsuscripcion.mostCurrent._rd1ano.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarsuscripcion.mostCurrent._rd1mes.runMethod(true,"getTop"),editarsuscripcion.mostCurrent._rd1mes.runMethod(true,"getHeight"),editarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "++*",2, 0)));
 BA.debugLineNum = 133;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
Debug.ShouldStop(16);
editarsuscripcion.mostCurrent._pnlnavinferior.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarsuscripcion._alturadispositivo,RemoteObject.createImmutable(0.08)}, "*",0, 0)));
 BA.debugLineNum = 134;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
Debug.ShouldStop(32);
editarsuscripcion.mostCurrent._pnlnavinferior.runMethod(true,"setWidth",editarsuscripcion._anchodispositivo);
 BA.debugLineNum = 135;BA.debugLine="pnlNavInferior.Left = 0";
Debug.ShouldStop(64);
editarsuscripcion.mostCurrent._pnlnavinferior.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 136;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
Debug.ShouldStop(128);
editarsuscripcion.mostCurrent._pnlnavinferior.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {editarsuscripcion._alturadispositivo,editarsuscripcion.mostCurrent._pnlnavinferior.runMethod(true,"getHeight")}, "-",1, 1));
 BA.debugLineNum = 139;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
Debug.ShouldStop(1024);
editarsuscripcion.mostCurrent._btnmenu.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarsuscripcion._anchodispositivo,RemoteObject.createImmutable(0.15)}, "*",0, 0)));
 BA.debugLineNum = 140;BA.debugLine="btnMenu.Height = btnMenu.Width";
Debug.ShouldStop(2048);
editarsuscripcion.mostCurrent._btnmenu.runMethod(true,"setHeight",editarsuscripcion.mostCurrent._btnmenu.runMethod(true,"getWidth"));
 BA.debugLineNum = 141;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
Debug.ShouldStop(4096);
editarsuscripcion.mostCurrent._btnmenu.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarsuscripcion.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),editarsuscripcion.mostCurrent._btnmenu.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 142;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
Debug.ShouldStop(8192);
editarsuscripcion.mostCurrent._btnmenu.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editarsuscripcion._anchodispositivo,editarsuscripcion.mostCurrent._btnmenu.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 144;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
Debug.ShouldStop(32768);
editarsuscripcion.mostCurrent._lblcontornoboton.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarsuscripcion._anchodispositivo,RemoteObject.createImmutable(0.17)}, "*",0, 0)));
 BA.debugLineNum = 145;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
Debug.ShouldStop(65536);
editarsuscripcion.mostCurrent._lblcontornoboton.runMethod(true,"setHeight",editarsuscripcion.mostCurrent._lblcontornoboton.runMethod(true,"getWidth"));
 BA.debugLineNum = 146;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
Debug.ShouldStop(131072);
editarsuscripcion.mostCurrent._lblcontornoboton.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editarsuscripcion._anchodispositivo,editarsuscripcion.mostCurrent._lblcontornoboton.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 147;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
Debug.ShouldStop(262144);
editarsuscripcion.mostCurrent._lblcontornoboton.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarsuscripcion.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),editarsuscripcion.mostCurrent._lblcontornoboton.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 152;BA.debugLine="btnOperacionSuscripcion.Text = \"Editar suscripció";
Debug.ShouldStop(8388608);
editarsuscripcion.mostCurrent._btnoperacionsuscripcion.runMethod(true,"setText",BA.ObjectToCharSequence("Editar suscripción"));
 BA.debugLineNum = 153;BA.debugLine="btnOperacionSuscripcion.Top = pnlPeriodos.Top + p";
Debug.ShouldStop(16777216);
editarsuscripcion.mostCurrent._btnoperacionsuscripcion.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"getTop"),editarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {editarsuscripcion.mostCurrent._lblcontornoboton.runMethod(true,"getTop"),(RemoteObject.solve(new RemoteObject[] {editarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"getTop"),editarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),editarsuscripcion.mostCurrent._btnoperacionsuscripcion.runMethod(true,"getHeight")}, "++",2, 1))}, "-",1, 1)),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 154;BA.debugLine="btnOperacionSuscripcion.Left = (anchoDispositivo";
Debug.ShouldStop(33554432);
editarsuscripcion.mostCurrent._btnoperacionsuscripcion.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editarsuscripcion._anchodispositivo,editarsuscripcion.mostCurrent._btnoperacionsuscripcion.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 155;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Pause (editarsuscripcion) ","editarsuscripcion",8,editarsuscripcion.mostCurrent.activityBA,editarsuscripcion.mostCurrent,160);
if (RapidSub.canDelegate("activity_pause")) { return pullup.wallet.editarsuscripcion.remoteMe.runUserSub(false, "editarsuscripcion","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 160;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 161;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("Activity_Resume (editarsuscripcion) ","editarsuscripcion",8,editarsuscripcion.mostCurrent.activityBA,editarsuscripcion.mostCurrent,157);
if (RapidSub.canDelegate("activity_resume")) { return pullup.wallet.editarsuscripcion.remoteMe.runUserSub(false, "editarsuscripcion","activity_resume");}
 BA.debugLineNum = 157;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 158;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("asignacionCampos (editarsuscripcion) ","editarsuscripcion",8,editarsuscripcion.mostCurrent.activityBA,editarsuscripcion.mostCurrent,242);
if (RapidSub.canDelegate("asignacioncampos")) { return pullup.wallet.editarsuscripcion.remoteMe.runUserSub(false, "editarsuscripcion","asignacioncampos");}
RemoteObject _susripcion = RemoteObject.declareNull("pullup.wallet.main._registrosuscripcion");
 BA.debugLineNum = 242;BA.debugLine="Sub asignacionCampos As RegistroSuscripcion";
Debug.ShouldStop(131072);
 BA.debugLineNum = 243;BA.debugLine="Dim susripcion As RegistroSuscripcion";
Debug.ShouldStop(262144);
_susripcion = RemoteObject.createNew ("pullup.wallet.main._registrosuscripcion");Debug.locals.put("susripcion", _susripcion);
 BA.debugLineNum = 245;BA.debugLine="susripcion.monto = txtMonto.Text";
Debug.ShouldStop(1048576);
_susripcion.setField ("monto" /*RemoteObject*/ ,BA.numberCast(int.class, editarsuscripcion.mostCurrent._txtmonto.runMethod(true,"getText")));
 BA.debugLineNum = 247;BA.debugLine="susripcion.nombre = txtNombre.Text";
Debug.ShouldStop(4194304);
_susripcion.setField ("nombre" /*RemoteObject*/ ,editarsuscripcion.mostCurrent._txtnombre.runMethod(true,"getText"));
 BA.debugLineNum = 249;BA.debugLine="susripcion.descripcion = (txtDescripcion.Text)";
Debug.ShouldStop(16777216);
_susripcion.setField ("descripcion" /*RemoteObject*/ ,(editarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getText")));
 BA.debugLineNum = 251;BA.debugLine="susripcion.periodo = diasPeriodo";
Debug.ShouldStop(67108864);
_susripcion.setField ("periodo" /*RemoteObject*/ ,editarsuscripcion._diasperiodo);
 BA.debugLineNum = 253;BA.debugLine="susripcion.color = colorCaja";
Debug.ShouldStop(268435456);
_susripcion.setField ("color" /*RemoteObject*/ ,editarsuscripcion._colorcaja);
 BA.debugLineNum = 255;BA.debugLine="Return susripcion";
Debug.ShouldStop(1073741824);
if (true) return _susripcion;
 BA.debugLineNum = 256;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("btnMenu_Click (editarsuscripcion) ","editarsuscripcion",8,editarsuscripcion.mostCurrent.activityBA,editarsuscripcion.mostCurrent,163);
if (RapidSub.canDelegate("btnmenu_click")) { return pullup.wallet.editarsuscripcion.remoteMe.runUserSub(false, "editarsuscripcion","btnmenu_click");}
 BA.debugLineNum = 163;BA.debugLine="Private Sub btnMenu_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 164;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8);
editarsuscripcion.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _btnoperacionsuscripcion_click() throws Exception{
try {
		Debug.PushSubsStack("btnOperacionSuscripcion_Click (editarsuscripcion) ","editarsuscripcion",8,editarsuscripcion.mostCurrent.activityBA,editarsuscripcion.mostCurrent,260);
if (RapidSub.canDelegate("btnoperacionsuscripcion_click")) { return pullup.wallet.editarsuscripcion.remoteMe.runUserSub(false, "editarsuscripcion","btnoperacionsuscripcion_click");}
RemoteObject _validaciones = RemoteObject.createImmutable(false);
RemoteObject _suscripcionregistro = RemoteObject.declareNull("pullup.wallet.main._registrosuscripcion");
 BA.debugLineNum = 260;BA.debugLine="Private Sub btnOperacionSuscripcion_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 261;BA.debugLine="Dim validaciones As Boolean";
Debug.ShouldStop(16);
_validaciones = RemoteObject.createImmutable(false);Debug.locals.put("validaciones", _validaciones);
 BA.debugLineNum = 263;BA.debugLine="validaciones = validarCampos";
Debug.ShouldStop(64);
_validaciones = _validarcampos();Debug.locals.put("validaciones", _validaciones);
 BA.debugLineNum = 264;BA.debugLine="If(validaciones = True) Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",_validaciones,editarsuscripcion.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 266;BA.debugLine="Dim suscripcionRegistro As RegistroSuscripcion";
Debug.ShouldStop(512);
_suscripcionregistro = RemoteObject.createNew ("pullup.wallet.main._registrosuscripcion");Debug.locals.put("suscripcionRegistro", _suscripcionregistro);
 BA.debugLineNum = 267;BA.debugLine="suscripcionRegistro = asignacionCampos";
Debug.ShouldStop(1024);
_suscripcionregistro = _asignacioncampos();Debug.locals.put("suscripcionRegistro", _suscripcionregistro);
 BA.debugLineNum = 270;BA.debugLine="sql.ExecNonQuery2(\"UPDATE suscripciones SET mont";
Debug.ShouldStop(8192);
editarsuscripcion._sql.runVoidMethod ("ExecNonQuery2",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE suscripciones SET monto = ?, nombre = ?, descripcion = ?, periodo = ?, color = ? WHERE id_suscripcion = '"),editarsuscripcion._idregistro,RemoteObject.createImmutable("'"))),(Object)(editarsuscripcion.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {(_suscripcionregistro.getField(true,"monto" /*RemoteObject*/ )),(_suscripcionregistro.getField(true,"nombre" /*RemoteObject*/ )),(_suscripcionregistro.getField(true,"descripcion" /*RemoteObject*/ )),(_suscripcionregistro.getField(true,"periodo" /*RemoteObject*/ )),(_suscripcionregistro.getField(true,"color" /*RemoteObject*/ ))})))));
 BA.debugLineNum = 272;BA.debugLine="ToastMessageShow(\"Suscripción editada\", True)";
Debug.ShouldStop(32768);
editarsuscripcion.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Suscripción editada")),(Object)(editarsuscripcion.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 274;BA.debugLine="Activity.Finish";
Debug.ShouldStop(131072);
editarsuscripcion.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 276;BA.debugLine="StartActivity(Suscripciones)";
Debug.ShouldStop(524288);
editarsuscripcion.mostCurrent.__c.runVoidMethod ("StartActivity",editarsuscripcion.processBA,(Object)((editarsuscripcion.mostCurrent._suscripciones.getObject())));
 }else {
 BA.debugLineNum = 279;BA.debugLine="Msgbox2(\"Por favor, rellene todos los campos, se";
Debug.ShouldStop(4194304);
editarsuscripcion.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("Por favor, rellene todos los campos, seleccione un periodo y color")),(Object)(BA.ObjectToCharSequence("Registro incorrecto")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((editarsuscripcion.mostCurrent.__c.getField(false,"Null"))),editarsuscripcion.mostCurrent.activityBA);
 };
 BA.debugLineNum = 281;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("consultaAEditar (editarsuscripcion) ","editarsuscripcion",8,editarsuscripcion.mostCurrent.activityBA,editarsuscripcion.mostCurrent,284);
if (RapidSub.canDelegate("consultaaeditar")) { return pullup.wallet.editarsuscripcion.remoteMe.runUserSub(false, "editarsuscripcion","consultaaeditar", _rowid);}
RemoteObject _suscripcion = RemoteObject.declareNull("pullup.wallet.main._registrosuscripcion");
Debug.locals.put("rowid", _rowid);
 BA.debugLineNum = 284;BA.debugLine="Sub consultaAEditar(rowid As Int)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 285;BA.debugLine="Dim suscripcion As RegistroSuscripcion";
Debug.ShouldStop(268435456);
_suscripcion = RemoteObject.createNew ("pullup.wallet.main._registrosuscripcion");Debug.locals.put("suscripcion", _suscripcion);
 BA.debugLineNum = 286;BA.debugLine="idRegistro = rowid";
Debug.ShouldStop(536870912);
editarsuscripcion._idregistro = _rowid;
 BA.debugLineNum = 288;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM suscripciones";
Debug.ShouldStop(-2147483648);
editarsuscripcion.mostCurrent._cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), editarsuscripcion._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM suscripciones WHERE id_suscripcion = '"),editarsuscripcion._idregistro,RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 289;BA.debugLine="If(cur.RowCount > 0) Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean(">",editarsuscripcion.mostCurrent._cur.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 290;BA.debugLine="cur.Position = 0";
Debug.ShouldStop(2);
editarsuscripcion.mostCurrent._cur.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 291;BA.debugLine="suscripcion.nombre = cur.GetString(\"nombre\")";
Debug.ShouldStop(4);
_suscripcion.setField ("nombre" /*RemoteObject*/ ,editarsuscripcion.mostCurrent._cur.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("nombre"))));
 BA.debugLineNum = 292;BA.debugLine="suscripcion.monto = cur.GetInt(\"monto\")";
Debug.ShouldStop(8);
_suscripcion.setField ("monto" /*RemoteObject*/ ,editarsuscripcion.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("monto"))));
 BA.debugLineNum = 293;BA.debugLine="suscripcion.descripcion = cur.GetString(\"descrip";
Debug.ShouldStop(16);
_suscripcion.setField ("descripcion" /*RemoteObject*/ ,editarsuscripcion.mostCurrent._cur.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("descripcion"))));
 BA.debugLineNum = 294;BA.debugLine="suscripcion.periodo = cur.GetInt(\"periodo\")";
Debug.ShouldStop(32);
_suscripcion.setField ("periodo" /*RemoteObject*/ ,editarsuscripcion.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("periodo"))));
 BA.debugLineNum = 295;BA.debugLine="suscripcion.color = cur.GetString(\"color\")";
Debug.ShouldStop(64);
_suscripcion.setField ("color" /*RemoteObject*/ ,BA.numberCast(int.class, editarsuscripcion.mostCurrent._cur.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("color")))));
 BA.debugLineNum = 297;BA.debugLine="reasignarCamposAEditar(suscripcion)";
Debug.ShouldStop(256);
_reasignarcamposaeditar(_suscripcion);
 };
 BA.debugLineNum = 299;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("cpBarraColor_ColorChanged (editarsuscripcion) ","editarsuscripcion",8,editarsuscripcion.mostCurrent.activityBA,editarsuscripcion.mostCurrent,178);
if (RapidSub.canDelegate("cpbarracolor_colorchanged")) { return pullup.wallet.editarsuscripcion.remoteMe.runUserSub(false, "editarsuscripcion","cpbarracolor_colorchanged", _color);}
Debug.locals.put("color", _color);
 BA.debugLineNum = 178;BA.debugLine="Sub cpBarraColor_ColorChanged(color As Int)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 179;BA.debugLine="lblFondoMonto.Color = color";
Debug.ShouldStop(262144);
editarsuscripcion.mostCurrent._lblfondomonto.runVoidMethod ("setColor",_color);
 BA.debugLineNum = 180;BA.debugLine="colorCaja = color";
Debug.ShouldStop(524288);
editarsuscripcion._colorcaja = _color;
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 14;BA.debugLine="Dim alturaDispositivo As Int";
editarsuscripcion._alturadispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 15;BA.debugLine="Dim anchoDispositivo As Int";
editarsuscripcion._anchodispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 16;BA.debugLine="Dim colorCaja As Int";
editarsuscripcion._colorcaja = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 17;BA.debugLine="Dim diasPeriodo As Int";
editarsuscripcion._diasperiodo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 18;BA.debugLine="Dim aparicionMsgBox1 As Boolean";
editarsuscripcion._aparicionmsgbox1 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 19;BA.debugLine="Dim aparicionMsgBox2 As Boolean";
editarsuscripcion._aparicionmsgbox2 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 20;BA.debugLine="Dim aparicionMsgBox3 As Boolean";
editarsuscripcion._aparicionmsgbox3 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 21;BA.debugLine="Dim cur As Cursor";
editarsuscripcion.mostCurrent._cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Dim idRegistro As Int";
editarsuscripcion._idregistro = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 26;BA.debugLine="Private btnMenu As Button";
editarsuscripcion.mostCurrent._btnmenu = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private btnOperacionSuscripcion As Button";
editarsuscripcion.mostCurrent._btnoperacionsuscripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private txtDescripcion As EditText";
editarsuscripcion.mostCurrent._txtdescripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private txtMonto As EditText";
editarsuscripcion.mostCurrent._txtmonto = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private txtNombre As EditText";
editarsuscripcion.mostCurrent._txtnombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private lblFondoMonto As Label";
editarsuscripcion.mostCurrent._lblfondomonto = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private lblFondoDescripcion As Label";
editarsuscripcion.mostCurrent._lblfondodescripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private lblFondoNombre As Label";
editarsuscripcion.mostCurrent._lblfondonombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private lblContornoBoton As Label";
editarsuscripcion.mostCurrent._lblcontornoboton = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private lblNombreVista As Label";
editarsuscripcion.mostCurrent._lblnombrevista = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private rd1Ano As RadioButton";
editarsuscripcion.mostCurrent._rd1ano = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private rd1Mes As RadioButton";
editarsuscripcion.mostCurrent._rd1mes = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private rd1Semana As RadioButton";
editarsuscripcion.mostCurrent._rd1semana = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private rd2Semanas As RadioButton";
editarsuscripcion.mostCurrent._rd2semanas = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private rd3Semanas As RadioButton";
editarsuscripcion.mostCurrent._rd3semanas = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private pnlNavInferior As Panel";
editarsuscripcion.mostCurrent._pnlnavinferior = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private pnlPeriodos As Panel";
editarsuscripcion.mostCurrent._pnlperiodos = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private pnlSelector As Panel";
editarsuscripcion.mostCurrent._pnlselector = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private cpBarraColor As ASColorSlider  'Miembro g";
editarsuscripcion.mostCurrent._cpbarracolor = RemoteObject.createNew ("pullup.wallet.ascolorslider");
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _limitarlongitudentrada(RemoteObject _antiguo,RemoteObject _nuevo,RemoteObject _longitud,RemoteObject _view,RemoteObject _campo) throws Exception{
try {
		Debug.PushSubsStack("limitarLongitudEntrada (editarsuscripcion) ","editarsuscripcion",8,editarsuscripcion.mostCurrent.activityBA,editarsuscripcion.mostCurrent,185);
if (RapidSub.canDelegate("limitarlongitudentrada")) { return pullup.wallet.editarsuscripcion.remoteMe.runUserSub(false, "editarsuscripcion","limitarlongitudentrada", _antiguo, _nuevo, _longitud, _view, _campo);}
Debug.locals.put("antiguo", _antiguo);
Debug.locals.put("nuevo", _nuevo);
Debug.locals.put("longitud", _longitud);
Debug.locals.put("view", _view);
Debug.locals.put("campo", _campo);
 BA.debugLineNum = 185;BA.debugLine="Sub limitarLongitudEntrada(antiguo As String, nuev";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 186;BA.debugLine="If(nuevo.Length > longitud) Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean(">",_nuevo.runMethod(true,"length"),BA.numberCast(double.class, _longitud)))) { 
 BA.debugLineNum = 187;BA.debugLine="If(campo = \"monto\") Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("monto")))) { 
 BA.debugLineNum = 188;BA.debugLine="If(aparicionMsgBox1 = False) Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",editarsuscripcion._aparicionmsgbox1,editarsuscripcion.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 189;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
Debug.ShouldStop(268435456);
editarsuscripcion.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para el monto es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((editarsuscripcion.mostCurrent.__c.getField(false,"Null"))),editarsuscripcion.mostCurrent.activityBA);
 BA.debugLineNum = 190;BA.debugLine="aparicionMsgBox1 = True";
Debug.ShouldStop(536870912);
editarsuscripcion._aparicionmsgbox1 = editarsuscripcion.mostCurrent.__c.getField(true,"True");
 };
 }else 
{ BA.debugLineNum = 192;BA.debugLine="Else If(campo = \"nombre\") Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("nombre")))) { 
 BA.debugLineNum = 193;BA.debugLine="If(aparicionMsgBox2 = False) Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",editarsuscripcion._aparicionmsgbox2,editarsuscripcion.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 194;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
Debug.ShouldStop(2);
editarsuscripcion.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para el nombre es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((editarsuscripcion.mostCurrent.__c.getField(false,"Null"))),editarsuscripcion.mostCurrent.activityBA);
 BA.debugLineNum = 195;BA.debugLine="aparicionMsgBox2 = True";
Debug.ShouldStop(4);
editarsuscripcion._aparicionmsgbox2 = editarsuscripcion.mostCurrent.__c.getField(true,"True");
 };
 }else 
{ BA.debugLineNum = 197;BA.debugLine="Else If(campo = \"descripcion\") Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("descripcion")))) { 
 BA.debugLineNum = 198;BA.debugLine="If(aparicionMsgBox3 = False) Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",editarsuscripcion._aparicionmsgbox3,editarsuscripcion.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 199;BA.debugLine="Msgbox2(\"La longitud máxima permitida para la";
Debug.ShouldStop(64);
editarsuscripcion.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para la descripción es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((editarsuscripcion.mostCurrent.__c.getField(false,"Null"))),editarsuscripcion.mostCurrent.activityBA);
 BA.debugLineNum = 200;BA.debugLine="aparicionMsgBox3 = True";
Debug.ShouldStop(128);
editarsuscripcion._aparicionmsgbox3 = editarsuscripcion.mostCurrent.__c.getField(true,"True");
 };
 }}}
;
 BA.debugLineNum = 203;BA.debugLine="view.Text = antiguo";
Debug.ShouldStop(1024);
_view.runMethod(true,"setText",BA.ObjectToCharSequence(_antiguo));
 };
 BA.debugLineNum = 205;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
editarsuscripcion._sql = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _rd1ano_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("rd1Ano_CheckedChange (editarsuscripcion) ","editarsuscripcion",8,editarsuscripcion.mostCurrent.activityBA,editarsuscripcion.mostCurrent,237);
if (RapidSub.canDelegate("rd1ano_checkedchange")) { return pullup.wallet.editarsuscripcion.remoteMe.runUserSub(false, "editarsuscripcion","rd1ano_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 237;BA.debugLine="Private Sub rd1Ano_CheckedChange(Checked As Boolea";
Debug.ShouldStop(4096);
 BA.debugLineNum = 238;BA.debugLine="diasPeriodo = 365";
Debug.ShouldStop(8192);
editarsuscripcion._diasperiodo = BA.numberCast(int.class, 365);
 BA.debugLineNum = 239;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rd1mes_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("rd1Mes_CheckedChange (editarsuscripcion) ","editarsuscripcion",8,editarsuscripcion.mostCurrent.activityBA,editarsuscripcion.mostCurrent,233);
if (RapidSub.canDelegate("rd1mes_checkedchange")) { return pullup.wallet.editarsuscripcion.remoteMe.runUserSub(false, "editarsuscripcion","rd1mes_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 233;BA.debugLine="Private Sub rd1Mes_CheckedChange(Checked As Boolea";
Debug.ShouldStop(256);
 BA.debugLineNum = 234;BA.debugLine="diasPeriodo = 30";
Debug.ShouldStop(512);
editarsuscripcion._diasperiodo = BA.numberCast(int.class, 30);
 BA.debugLineNum = 235;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rd1semana_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("rd1Semana_CheckedChange (editarsuscripcion) ","editarsuscripcion",8,editarsuscripcion.mostCurrent.activityBA,editarsuscripcion.mostCurrent,229);
if (RapidSub.canDelegate("rd1semana_checkedchange")) { return pullup.wallet.editarsuscripcion.remoteMe.runUserSub(false, "editarsuscripcion","rd1semana_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 229;BA.debugLine="Private Sub rd1Semana_CheckedChange(Checked As Boo";
Debug.ShouldStop(16);
 BA.debugLineNum = 230;BA.debugLine="diasPeriodo = 7";
Debug.ShouldStop(32);
editarsuscripcion._diasperiodo = BA.numberCast(int.class, 7);
 BA.debugLineNum = 231;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rd2semanas_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("rd2Semanas_CheckedChange (editarsuscripcion) ","editarsuscripcion",8,editarsuscripcion.mostCurrent.activityBA,editarsuscripcion.mostCurrent,225);
if (RapidSub.canDelegate("rd2semanas_checkedchange")) { return pullup.wallet.editarsuscripcion.remoteMe.runUserSub(false, "editarsuscripcion","rd2semanas_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 225;BA.debugLine="Private Sub rd2Semanas_CheckedChange(Checked As Bo";
Debug.ShouldStop(1);
 BA.debugLineNum = 226;BA.debugLine="diasPeriodo = 14";
Debug.ShouldStop(2);
editarsuscripcion._diasperiodo = BA.numberCast(int.class, 14);
 BA.debugLineNum = 227;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rd3semanas_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("rd3Semanas_CheckedChange (editarsuscripcion) ","editarsuscripcion",8,editarsuscripcion.mostCurrent.activityBA,editarsuscripcion.mostCurrent,221);
if (RapidSub.canDelegate("rd3semanas_checkedchange")) { return pullup.wallet.editarsuscripcion.remoteMe.runUserSub(false, "editarsuscripcion","rd3semanas_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 221;BA.debugLine="Private Sub rd3Semanas_CheckedChange(Checked As Bo";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 222;BA.debugLine="diasPeriodo = 21";
Debug.ShouldStop(536870912);
editarsuscripcion._diasperiodo = BA.numberCast(int.class, 21);
 BA.debugLineNum = 223;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _reasignarcamposaeditar(RemoteObject _registro) throws Exception{
try {
		Debug.PushSubsStack("reasignarCamposAEditar (editarsuscripcion) ","editarsuscripcion",8,editarsuscripcion.mostCurrent.activityBA,editarsuscripcion.mostCurrent,302);
if (RapidSub.canDelegate("reasignarcamposaeditar")) { return pullup.wallet.editarsuscripcion.remoteMe.runUserSub(false, "editarsuscripcion","reasignarcamposaeditar", _registro);}
Debug.locals.put("registro", _registro);
 BA.debugLineNum = 302;BA.debugLine="Sub reasignarCamposAEditar(registro As RegistroSus";
Debug.ShouldStop(8192);
 BA.debugLineNum = 303;BA.debugLine="txtNombre.Text = registro.nombre";
Debug.ShouldStop(16384);
editarsuscripcion.mostCurrent._txtnombre.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_registro.getField(true,"nombre" /*RemoteObject*/ )));
 BA.debugLineNum = 304;BA.debugLine="txtMonto.Text = registro.monto";
Debug.ShouldStop(32768);
editarsuscripcion.mostCurrent._txtmonto.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_registro.getField(true,"monto" /*RemoteObject*/ )));
 BA.debugLineNum = 305;BA.debugLine="txtDescripcion.Text = registro.descripcion";
Debug.ShouldStop(65536);
editarsuscripcion.mostCurrent._txtdescripcion.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_registro.getField(true,"descripcion" /*RemoteObject*/ )));
 BA.debugLineNum = 306;BA.debugLine="Select registro.periodo";
Debug.ShouldStop(131072);
switch (BA.switchObjectToInt(_registro.getField(true,"periodo" /*RemoteObject*/ ),BA.numberCast(int.class, 7),BA.numberCast(int.class, 14),BA.numberCast(int.class, 21),BA.numberCast(int.class, 30),BA.numberCast(int.class, 365))) {
case 0: {
 BA.debugLineNum = 308;BA.debugLine="rd1Semana.Checked = True";
Debug.ShouldStop(524288);
editarsuscripcion.mostCurrent._rd1semana.runMethodAndSync(true,"setChecked",editarsuscripcion.mostCurrent.__c.getField(true,"True"));
 break; }
case 1: {
 BA.debugLineNum = 310;BA.debugLine="rd2Semanas.Checked = True";
Debug.ShouldStop(2097152);
editarsuscripcion.mostCurrent._rd2semanas.runMethodAndSync(true,"setChecked",editarsuscripcion.mostCurrent.__c.getField(true,"True"));
 break; }
case 2: {
 BA.debugLineNum = 312;BA.debugLine="rd3Semanas.Checked = True";
Debug.ShouldStop(8388608);
editarsuscripcion.mostCurrent._rd3semanas.runMethodAndSync(true,"setChecked",editarsuscripcion.mostCurrent.__c.getField(true,"True"));
 break; }
case 3: {
 BA.debugLineNum = 314;BA.debugLine="rd1Mes.Checked = True";
Debug.ShouldStop(33554432);
editarsuscripcion.mostCurrent._rd1mes.runMethodAndSync(true,"setChecked",editarsuscripcion.mostCurrent.__c.getField(true,"True"));
 break; }
case 4: {
 BA.debugLineNum = 316;BA.debugLine="rd1Ano.Checked = True";
Debug.ShouldStop(134217728);
editarsuscripcion.mostCurrent._rd1ano.runMethodAndSync(true,"setChecked",editarsuscripcion.mostCurrent.__c.getField(true,"True"));
 break; }
}
;
 BA.debugLineNum = 318;BA.debugLine="diasPeriodo = registro.periodo";
Debug.ShouldStop(536870912);
editarsuscripcion._diasperiodo = _registro.getField(true,"periodo" /*RemoteObject*/ );
 BA.debugLineNum = 319;BA.debugLine="cpBarraColor_ColorChanged(registro.color)";
Debug.ShouldStop(1073741824);
_cpbarracolor_colorchanged(_registro.getField(true,"color" /*RemoteObject*/ ));
 BA.debugLineNum = 320;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("txtDescripcion_TextChanged (editarsuscripcion) ","editarsuscripcion",8,editarsuscripcion.mostCurrent.activityBA,editarsuscripcion.mostCurrent,216);
if (RapidSub.canDelegate("txtdescripcion_textchanged")) { return pullup.wallet.editarsuscripcion.remoteMe.runUserSub(false, "editarsuscripcion","txtdescripcion_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 216;BA.debugLine="Private Sub txtDescripcion_TextChanged (Old As Str";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 217;BA.debugLine="limitarLongitudEntrada(Old, New, 41, txtDescripci";
Debug.ShouldStop(16777216);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 41),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), editarsuscripcion.mostCurrent._txtdescripcion.getObject()),RemoteObject.createImmutable("descripcion"));
 BA.debugLineNum = 218;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("txtMonto_TextChanged (editarsuscripcion) ","editarsuscripcion",8,editarsuscripcion.mostCurrent.activityBA,editarsuscripcion.mostCurrent,208);
if (RapidSub.canDelegate("txtmonto_textchanged")) { return pullup.wallet.editarsuscripcion.remoteMe.runUserSub(false, "editarsuscripcion","txtmonto_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 208;BA.debugLine="Private Sub txtMonto_TextChanged (Old As String, N";
Debug.ShouldStop(32768);
 BA.debugLineNum = 209;BA.debugLine="limitarLongitudEntrada(Old, New, 9, txtMonto, \"mo";
Debug.ShouldStop(65536);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 9),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), editarsuscripcion.mostCurrent._txtmonto.getObject()),RemoteObject.createImmutable("monto"));
 BA.debugLineNum = 210;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("txtNombre_TextChanged (editarsuscripcion) ","editarsuscripcion",8,editarsuscripcion.mostCurrent.activityBA,editarsuscripcion.mostCurrent,212);
if (RapidSub.canDelegate("txtnombre_textchanged")) { return pullup.wallet.editarsuscripcion.remoteMe.runUserSub(false, "editarsuscripcion","txtnombre_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 212;BA.debugLine="Private Sub txtNombre_TextChanged (Old As String,";
Debug.ShouldStop(524288);
 BA.debugLineNum = 213;BA.debugLine="limitarLongitudEntrada(Old, New, 16, txtNombre, \"";
Debug.ShouldStop(1048576);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 16),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), editarsuscripcion.mostCurrent._txtnombre.getObject()),RemoteObject.createImmutable("nombre"));
 BA.debugLineNum = 214;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("validarCampos (editarsuscripcion) ","editarsuscripcion",8,editarsuscripcion.mostCurrent.activityBA,editarsuscripcion.mostCurrent,168);
if (RapidSub.canDelegate("validarcampos")) { return pullup.wallet.editarsuscripcion.remoteMe.runUserSub(false, "editarsuscripcion","validarcampos");}
 BA.debugLineNum = 168;BA.debugLine="Sub validarCampos As Boolean";
Debug.ShouldStop(128);
 BA.debugLineNum = 169;BA.debugLine="If(txtMonto.Text.Length <> 0 And txtNombre.Text.L";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("!",editarsuscripcion.mostCurrent._txtmonto.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",editarsuscripcion.mostCurrent._txtnombre.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",editarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",editarsuscripcion._colorcaja,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",editarsuscripcion._diasperiodo,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 170;BA.debugLine="Return True";
Debug.ShouldStop(512);
if (true) return editarsuscripcion.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 172;BA.debugLine="Return False";
Debug.ShouldStop(2048);
if (true) return editarsuscripcion.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 174;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}