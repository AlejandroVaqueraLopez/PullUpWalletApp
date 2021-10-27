package pullup.wallet;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class editaringresorecurrente_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (editaringresorecurrente) ","editaringresorecurrente",5,editaringresorecurrente.mostCurrent.activityBA,editaringresorecurrente.mostCurrent,53);
if (RapidSub.canDelegate("activity_create")) { return pullup.wallet.editaringresorecurrente.remoteMe.runUserSub(false, "editaringresorecurrente","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 53;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 55;BA.debugLine="Activity.LoadLayout(\"LEditarIngresoRecurrente\")";
Debug.ShouldStop(4194304);
editaringresorecurrente.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("LEditarIngresoRecurrente")),editaringresorecurrente.mostCurrent.activityBA);
 BA.debugLineNum = 56;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
Debug.ShouldStop(8388608);
editaringresorecurrente._alturadispositivo = editaringresorecurrente.mostCurrent._main._alturadispositivo /*RemoteObject*/ ;
 BA.debugLineNum = 57;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
Debug.ShouldStop(16777216);
editaringresorecurrente._anchodispositivo = editaringresorecurrente.mostCurrent._main._anchodispositivo /*RemoteObject*/ ;
 BA.debugLineNum = 58;BA.debugLine="sql = Starter.sql";
Debug.ShouldStop(33554432);
editaringresorecurrente._sql = editaringresorecurrente.mostCurrent._starter._sql /*RemoteObject*/ ;
 BA.debugLineNum = 59;BA.debugLine="aparicionMsgBox1 = False";
Debug.ShouldStop(67108864);
editaringresorecurrente._aparicionmsgbox1 = editaringresorecurrente.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 60;BA.debugLine="aparicionMsgBox2 = False";
Debug.ShouldStop(134217728);
editaringresorecurrente._aparicionmsgbox2 = editaringresorecurrente.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 61;BA.debugLine="aparicionMsgBox3 = False";
Debug.ShouldStop(268435456);
editaringresorecurrente._aparicionmsgbox3 = editaringresorecurrente.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 64;BA.debugLine="lblNombreVista.TextSize = 20";
Debug.ShouldStop(-2147483648);
editaringresorecurrente.mostCurrent._lblnombrevista.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 65;BA.debugLine="lblNombreVista.TextColor = Colors.Black";
Debug.ShouldStop(1);
editaringresorecurrente.mostCurrent._lblnombrevista.runMethod(true,"setTextColor",editaringresorecurrente.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 66;BA.debugLine="lblNombreVista.Height = 30dip";
Debug.ShouldStop(2);
editaringresorecurrente.mostCurrent._lblnombrevista.runMethod(true,"setHeight",editaringresorecurrente.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 67;BA.debugLine="lblNombreVista.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(4);
editaringresorecurrente.mostCurrent._lblnombrevista.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresorecurrente._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 68;BA.debugLine="lblNombreVista.Top = 30dip";
Debug.ShouldStop(8);
editaringresorecurrente.mostCurrent._lblnombrevista.runMethod(true,"setTop",editaringresorecurrente.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 69;BA.debugLine="lblNombreVista.Left = (anchoDispositivo - lblNomb";
Debug.ShouldStop(16);
editaringresorecurrente.mostCurrent._lblnombrevista.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editaringresorecurrente._anchodispositivo,editaringresorecurrente.mostCurrent._lblnombrevista.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 71;BA.debugLine="txtMonto.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(64);
editaringresorecurrente.mostCurrent._txtmonto.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresorecurrente._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 72;BA.debugLine="txtMonto.Height = alturaDispositivo * 0.22";
Debug.ShouldStop(128);
editaringresorecurrente.mostCurrent._txtmonto.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresorecurrente._alturadispositivo,RemoteObject.createImmutable(0.22)}, "*",0, 0)));
 BA.debugLineNum = 73;BA.debugLine="txtMonto.Top = lblNombreVista.Top * 2 + lblNombre";
Debug.ShouldStop(256);
editaringresorecurrente.mostCurrent._txtmonto.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {editaringresorecurrente.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2),editaringresorecurrente.mostCurrent._lblnombrevista.runMethod(true,"getHeight")}, "*+",1, 1));
 BA.debugLineNum = 74;BA.debugLine="txtMonto.Left = (anchoDispositivo - txtMonto.Widt";
Debug.ShouldStop(512);
editaringresorecurrente.mostCurrent._txtmonto.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editaringresorecurrente._anchodispositivo,editaringresorecurrente.mostCurrent._txtmonto.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 75;BA.debugLine="lblFondoMonto.Width = txtMonto.Width";
Debug.ShouldStop(1024);
editaringresorecurrente.mostCurrent._lblfondomonto.runMethod(true,"setWidth",editaringresorecurrente.mostCurrent._txtmonto.runMethod(true,"getWidth"));
 BA.debugLineNum = 76;BA.debugLine="lblFondoMonto.Height = txtMonto.Height";
Debug.ShouldStop(2048);
editaringresorecurrente.mostCurrent._lblfondomonto.runMethod(true,"setHeight",editaringresorecurrente.mostCurrent._txtmonto.runMethod(true,"getHeight"));
 BA.debugLineNum = 77;BA.debugLine="lblFondoMonto.Top = txtMonto.Top";
Debug.ShouldStop(4096);
editaringresorecurrente.mostCurrent._lblfondomonto.runMethod(true,"setTop",editaringresorecurrente.mostCurrent._txtmonto.runMethod(true,"getTop"));
 BA.debugLineNum = 78;BA.debugLine="lblFondoMonto.Left = txtMonto.Left";
Debug.ShouldStop(8192);
editaringresorecurrente.mostCurrent._lblfondomonto.runMethod(true,"setLeft",editaringresorecurrente.mostCurrent._txtmonto.runMethod(true,"getLeft"));
 BA.debugLineNum = 80;BA.debugLine="txtNombre.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(32768);
editaringresorecurrente.mostCurrent._txtnombre.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresorecurrente._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 81;BA.debugLine="txtNombre.Height = alturaDispositivo * 0.07";
Debug.ShouldStop(65536);
editaringresorecurrente.mostCurrent._txtnombre.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresorecurrente._alturadispositivo,RemoteObject.createImmutable(0.07)}, "*",0, 0)));
 BA.debugLineNum = 82;BA.debugLine="txtNombre.Top = txtMonto.Top + txtMonto.Height +";
Debug.ShouldStop(131072);
editaringresorecurrente.mostCurrent._txtnombre.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresorecurrente.mostCurrent._txtmonto.runMethod(true,"getTop"),editaringresorecurrente.mostCurrent._txtmonto.runMethod(true,"getHeight"),editaringresorecurrente.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 83;BA.debugLine="txtNombre.Left = (anchoDispositivo - txtNombre.Wi";
Debug.ShouldStop(262144);
editaringresorecurrente.mostCurrent._txtnombre.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editaringresorecurrente._anchodispositivo,editaringresorecurrente.mostCurrent._txtnombre.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 84;BA.debugLine="lblFondoNombre.Width = txtMonto.Width";
Debug.ShouldStop(524288);
editaringresorecurrente.mostCurrent._lblfondonombre.runMethod(true,"setWidth",editaringresorecurrente.mostCurrent._txtmonto.runMethod(true,"getWidth"));
 BA.debugLineNum = 85;BA.debugLine="lblFondoNombre.Height = txtNombre.Height";
Debug.ShouldStop(1048576);
editaringresorecurrente.mostCurrent._lblfondonombre.runMethod(true,"setHeight",editaringresorecurrente.mostCurrent._txtnombre.runMethod(true,"getHeight"));
 BA.debugLineNum = 86;BA.debugLine="lblFondoNombre.Top = txtNombre.Top";
Debug.ShouldStop(2097152);
editaringresorecurrente.mostCurrent._lblfondonombre.runMethod(true,"setTop",editaringresorecurrente.mostCurrent._txtnombre.runMethod(true,"getTop"));
 BA.debugLineNum = 87;BA.debugLine="lblFondoNombre.Left = txtNombre.Left";
Debug.ShouldStop(4194304);
editaringresorecurrente.mostCurrent._lblfondonombre.runMethod(true,"setLeft",editaringresorecurrente.mostCurrent._txtnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 89;BA.debugLine="txtDescripcion.Width = txtNombre.Width";
Debug.ShouldStop(16777216);
editaringresorecurrente.mostCurrent._txtdescripcion.runMethod(true,"setWidth",editaringresorecurrente.mostCurrent._txtnombre.runMethod(true,"getWidth"));
 BA.debugLineNum = 90;BA.debugLine="txtDescripcion.Height = txtNombre.Height";
Debug.ShouldStop(33554432);
editaringresorecurrente.mostCurrent._txtdescripcion.runMethod(true,"setHeight",editaringresorecurrente.mostCurrent._txtnombre.runMethod(true,"getHeight"));
 BA.debugLineNum = 91;BA.debugLine="txtDescripcion.Top = txtNombre.Top + txtNombre.He";
Debug.ShouldStop(67108864);
editaringresorecurrente.mostCurrent._txtdescripcion.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresorecurrente.mostCurrent._txtnombre.runMethod(true,"getTop"),editaringresorecurrente.mostCurrent._txtnombre.runMethod(true,"getHeight"),editaringresorecurrente.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 92;BA.debugLine="txtDescripcion.Left = txtNombre.Left";
Debug.ShouldStop(134217728);
editaringresorecurrente.mostCurrent._txtdescripcion.runMethod(true,"setLeft",editaringresorecurrente.mostCurrent._txtnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 93;BA.debugLine="lblFondoDescripcion.Width = txtDescripcion.Width";
Debug.ShouldStop(268435456);
editaringresorecurrente.mostCurrent._lblfondodescripcion.runMethod(true,"setWidth",editaringresorecurrente.mostCurrent._txtdescripcion.runMethod(true,"getWidth"));
 BA.debugLineNum = 94;BA.debugLine="lblFondoDescripcion.Height = txtDescripcion.Heigh";
Debug.ShouldStop(536870912);
editaringresorecurrente.mostCurrent._lblfondodescripcion.runMethod(true,"setHeight",editaringresorecurrente.mostCurrent._txtdescripcion.runMethod(true,"getHeight"));
 BA.debugLineNum = 95;BA.debugLine="lblFondoDescripcion.Top = txtDescripcion.Top";
Debug.ShouldStop(1073741824);
editaringresorecurrente.mostCurrent._lblfondodescripcion.runMethod(true,"setTop",editaringresorecurrente.mostCurrent._txtdescripcion.runMethod(true,"getTop"));
 BA.debugLineNum = 96;BA.debugLine="lblFondoDescripcion.Left = txtDescripcion.Left";
Debug.ShouldStop(-2147483648);
editaringresorecurrente.mostCurrent._lblfondodescripcion.runMethod(true,"setLeft",editaringresorecurrente.mostCurrent._txtdescripcion.runMethod(true,"getLeft"));
 BA.debugLineNum = 98;BA.debugLine="pnlSelector.Top = txtDescripcion.Top + txtDescrip";
Debug.ShouldStop(2);
editaringresorecurrente.mostCurrent._pnlselector.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresorecurrente.mostCurrent._txtdescripcion.runMethod(true,"getTop"),editaringresorecurrente.mostCurrent._txtdescripcion.runMethod(true,"getHeight"),editaringresorecurrente.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 99;BA.debugLine="pnlSelector.Left = txtDescripcion.Left + txtDescr";
Debug.ShouldStop(4);
editaringresorecurrente.mostCurrent._pnlselector.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {editaringresorecurrente.mostCurrent._txtdescripcion.runMethod(true,"getLeft"),editaringresorecurrente.mostCurrent._txtdescripcion.runMethod(true,"getWidth"),editaringresorecurrente.mostCurrent._pnlselector.runMethod(true,"getWidth")}, "+-",2, 1));
 BA.debugLineNum = 101;BA.debugLine="pnlPeriodos.Top = pnlSelector.Top";
Debug.ShouldStop(16);
editaringresorecurrente.mostCurrent._pnlperiodos.runMethod(true,"setTop",editaringresorecurrente.mostCurrent._pnlselector.runMethod(true,"getTop"));
 BA.debugLineNum = 102;BA.debugLine="pnlPeriodos.Left = txtDescripcion.Left";
Debug.ShouldStop(32);
editaringresorecurrente.mostCurrent._pnlperiodos.runMethod(true,"setLeft",editaringresorecurrente.mostCurrent._txtdescripcion.runMethod(true,"getLeft"));
 BA.debugLineNum = 103;BA.debugLine="pnlPeriodos.Width = (txtDescripcion.Width - pnlSe";
Debug.ShouldStop(64);
editaringresorecurrente.mostCurrent._pnlperiodos.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editaringresorecurrente.mostCurrent._txtdescripcion.runMethod(true,"getWidth"),editaringresorecurrente.mostCurrent._pnlselector.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 104;BA.debugLine="pnlPeriodos.Height = pnlSelector.Height";
Debug.ShouldStop(128);
editaringresorecurrente.mostCurrent._pnlperiodos.runMethod(true,"setHeight",editaringresorecurrente.mostCurrent._pnlselector.runMethod(true,"getHeight"));
 BA.debugLineNum = 107;BA.debugLine="rd1Semana.Width = pnlPeriodos.Width";
Debug.ShouldStop(1024);
editaringresorecurrente.mostCurrent._rd1semana.runMethod(true,"setWidth",editaringresorecurrente.mostCurrent._pnlperiodos.runMethod(true,"getWidth"));
 BA.debugLineNum = 108;BA.debugLine="rd1Semana.Height = pnlPeriodos.Height * 0.18";
Debug.ShouldStop(2048);
editaringresorecurrente.mostCurrent._rd1semana.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresorecurrente.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.18)}, "*",0, 0)));
 BA.debugLineNum = 109;BA.debugLine="rd1Semana.Left = 0";
Debug.ShouldStop(4096);
editaringresorecurrente.mostCurrent._rd1semana.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 110;BA.debugLine="rd1Semana.Top = 0";
Debug.ShouldStop(8192);
editaringresorecurrente.mostCurrent._rd1semana.runMethod(true,"setTop",BA.numberCast(int.class, 0));
 BA.debugLineNum = 112;BA.debugLine="rd2Semanas.Width = rd1Semana.Width";
Debug.ShouldStop(32768);
editaringresorecurrente.mostCurrent._rd2semanas.runMethod(true,"setWidth",editaringresorecurrente.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 113;BA.debugLine="rd2Semanas.Height = rd1Semana.Height";
Debug.ShouldStop(65536);
editaringresorecurrente.mostCurrent._rd2semanas.runMethod(true,"setHeight",editaringresorecurrente.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 114;BA.debugLine="rd2Semanas.Left = rd1Semana.Left";
Debug.ShouldStop(131072);
editaringresorecurrente.mostCurrent._rd2semanas.runMethod(true,"setLeft",editaringresorecurrente.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 115;BA.debugLine="rd2Semanas.Top = rd1Semana.Height + pnlPeriodos.H";
Debug.ShouldStop(262144);
editaringresorecurrente.mostCurrent._rd2semanas.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresorecurrente.mostCurrent._rd1semana.runMethod(true,"getHeight"),editaringresorecurrente.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "+*",1, 0)));
 BA.debugLineNum = 117;BA.debugLine="rd3Semanas.Width = rd1Semana.Width";
Debug.ShouldStop(1048576);
editaringresorecurrente.mostCurrent._rd3semanas.runMethod(true,"setWidth",editaringresorecurrente.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 118;BA.debugLine="rd3Semanas.Height = rd1Semana.Height";
Debug.ShouldStop(2097152);
editaringresorecurrente.mostCurrent._rd3semanas.runMethod(true,"setHeight",editaringresorecurrente.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 119;BA.debugLine="rd3Semanas.Left = rd1Semana.Left";
Debug.ShouldStop(4194304);
editaringresorecurrente.mostCurrent._rd3semanas.runMethod(true,"setLeft",editaringresorecurrente.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 120;BA.debugLine="rd3Semanas.Top = rd2Semanas.Top + rd2Semanas.Heig";
Debug.ShouldStop(8388608);
editaringresorecurrente.mostCurrent._rd3semanas.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresorecurrente.mostCurrent._rd2semanas.runMethod(true,"getTop"),editaringresorecurrente.mostCurrent._rd2semanas.runMethod(true,"getHeight"),editaringresorecurrente.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "++*",2, 0)));
 BA.debugLineNum = 122;BA.debugLine="rd1Mes.Width = rd1Semana.Width";
Debug.ShouldStop(33554432);
editaringresorecurrente.mostCurrent._rd1mes.runMethod(true,"setWidth",editaringresorecurrente.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 123;BA.debugLine="rd1Mes.Height = rd1Semana.Height";
Debug.ShouldStop(67108864);
editaringresorecurrente.mostCurrent._rd1mes.runMethod(true,"setHeight",editaringresorecurrente.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 124;BA.debugLine="rd1Mes.Left = rd1Semana.Left";
Debug.ShouldStop(134217728);
editaringresorecurrente.mostCurrent._rd1mes.runMethod(true,"setLeft",editaringresorecurrente.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 125;BA.debugLine="rd1Mes.Top = rd3Semanas.Top + rd3Semanas.Height +";
Debug.ShouldStop(268435456);
editaringresorecurrente.mostCurrent._rd1mes.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresorecurrente.mostCurrent._rd3semanas.runMethod(true,"getTop"),editaringresorecurrente.mostCurrent._rd3semanas.runMethod(true,"getHeight"),editaringresorecurrente.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "++*",2, 0)));
 BA.debugLineNum = 127;BA.debugLine="rd1Ano.Width = rd1Semana.Width";
Debug.ShouldStop(1073741824);
editaringresorecurrente.mostCurrent._rd1ano.runMethod(true,"setWidth",editaringresorecurrente.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 128;BA.debugLine="rd1Ano.Height = rd1Semana.Height";
Debug.ShouldStop(-2147483648);
editaringresorecurrente.mostCurrent._rd1ano.runMethod(true,"setHeight",editaringresorecurrente.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 129;BA.debugLine="rd1Ano.Left = rd1Semana.Left";
Debug.ShouldStop(1);
editaringresorecurrente.mostCurrent._rd1ano.runMethod(true,"setLeft",editaringresorecurrente.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 130;BA.debugLine="rd1Ano.Top = rd1Mes.Top + rd1Mes.Height + pnlPeri";
Debug.ShouldStop(2);
editaringresorecurrente.mostCurrent._rd1ano.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresorecurrente.mostCurrent._rd1mes.runMethod(true,"getTop"),editaringresorecurrente.mostCurrent._rd1mes.runMethod(true,"getHeight"),editaringresorecurrente.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "++*",2, 0)));
 BA.debugLineNum = 135;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
Debug.ShouldStop(64);
editaringresorecurrente.mostCurrent._pnlnavinferior.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresorecurrente._alturadispositivo,RemoteObject.createImmutable(0.08)}, "*",0, 0)));
 BA.debugLineNum = 136;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
Debug.ShouldStop(128);
editaringresorecurrente.mostCurrent._pnlnavinferior.runMethod(true,"setWidth",editaringresorecurrente._anchodispositivo);
 BA.debugLineNum = 137;BA.debugLine="pnlNavInferior.Left = 0";
Debug.ShouldStop(256);
editaringresorecurrente.mostCurrent._pnlnavinferior.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 138;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
Debug.ShouldStop(512);
editaringresorecurrente.mostCurrent._pnlnavinferior.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {editaringresorecurrente._alturadispositivo,editaringresorecurrente.mostCurrent._pnlnavinferior.runMethod(true,"getHeight")}, "-",1, 1));
 BA.debugLineNum = 141;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
Debug.ShouldStop(4096);
editaringresorecurrente.mostCurrent._btnmenu.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresorecurrente._anchodispositivo,RemoteObject.createImmutable(0.15)}, "*",0, 0)));
 BA.debugLineNum = 142;BA.debugLine="btnMenu.Height = btnMenu.Width";
Debug.ShouldStop(8192);
editaringresorecurrente.mostCurrent._btnmenu.runMethod(true,"setHeight",editaringresorecurrente.mostCurrent._btnmenu.runMethod(true,"getWidth"));
 BA.debugLineNum = 143;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
Debug.ShouldStop(16384);
editaringresorecurrente.mostCurrent._btnmenu.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresorecurrente.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),editaringresorecurrente.mostCurrent._btnmenu.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 144;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
Debug.ShouldStop(32768);
editaringresorecurrente.mostCurrent._btnmenu.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editaringresorecurrente._anchodispositivo,editaringresorecurrente.mostCurrent._btnmenu.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 146;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
Debug.ShouldStop(131072);
editaringresorecurrente.mostCurrent._lblcontornoboton.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresorecurrente._anchodispositivo,RemoteObject.createImmutable(0.17)}, "*",0, 0)));
 BA.debugLineNum = 147;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
Debug.ShouldStop(262144);
editaringresorecurrente.mostCurrent._lblcontornoboton.runMethod(true,"setHeight",editaringresorecurrente.mostCurrent._lblcontornoboton.runMethod(true,"getWidth"));
 BA.debugLineNum = 148;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
Debug.ShouldStop(524288);
editaringresorecurrente.mostCurrent._lblcontornoboton.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editaringresorecurrente._anchodispositivo,editaringresorecurrente.mostCurrent._lblcontornoboton.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 149;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
Debug.ShouldStop(1048576);
editaringresorecurrente.mostCurrent._lblcontornoboton.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresorecurrente.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),editaringresorecurrente.mostCurrent._lblcontornoboton.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 154;BA.debugLine="btnOperacionIngresoRecurrente.Text = \"Editar ingr";
Debug.ShouldStop(33554432);
editaringresorecurrente.mostCurrent._btnoperacioningresorecurrente.runMethod(true,"setText",BA.ObjectToCharSequence("Editar ingreso recurrente"));
 BA.debugLineNum = 155;BA.debugLine="btnOperacionIngresoRecurrente.Top = pnlPeriodos.T";
Debug.ShouldStop(67108864);
editaringresorecurrente.mostCurrent._btnoperacioningresorecurrente.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editaringresorecurrente.mostCurrent._pnlperiodos.runMethod(true,"getTop"),editaringresorecurrente.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {editaringresorecurrente.mostCurrent._lblcontornoboton.runMethod(true,"getTop"),(RemoteObject.solve(new RemoteObject[] {editaringresorecurrente.mostCurrent._pnlperiodos.runMethod(true,"getTop"),editaringresorecurrente.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),editaringresorecurrente.mostCurrent._btnoperacioningresorecurrente.runMethod(true,"getHeight")}, "++",2, 1))}, "-",1, 1)),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 156;BA.debugLine="btnOperacionIngresoRecurrente.Left = (anchoDispos";
Debug.ShouldStop(134217728);
editaringresorecurrente.mostCurrent._btnoperacioningresorecurrente.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editaringresorecurrente._anchodispositivo,editaringresorecurrente.mostCurrent._btnoperacioningresorecurrente.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 157;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Activity_Pause (editaringresorecurrente) ","editaringresorecurrente",5,editaringresorecurrente.mostCurrent.activityBA,editaringresorecurrente.mostCurrent,162);
if (RapidSub.canDelegate("activity_pause")) { return pullup.wallet.editaringresorecurrente.remoteMe.runUserSub(false, "editaringresorecurrente","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 162;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 163;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Resume (editaringresorecurrente) ","editaringresorecurrente",5,editaringresorecurrente.mostCurrent.activityBA,editaringresorecurrente.mostCurrent,159);
if (RapidSub.canDelegate("activity_resume")) { return pullup.wallet.editaringresorecurrente.remoteMe.runUserSub(false, "editaringresorecurrente","activity_resume");}
 BA.debugLineNum = 159;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1073741824);
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
public static RemoteObject  _asignacioncampos() throws Exception{
try {
		Debug.PushSubsStack("asignacionCampos (editaringresorecurrente) ","editaringresorecurrente",5,editaringresorecurrente.mostCurrent.activityBA,editaringresorecurrente.mostCurrent,244);
if (RapidSub.canDelegate("asignacioncampos")) { return pullup.wallet.editaringresorecurrente.remoteMe.runUserSub(false, "editaringresorecurrente","asignacioncampos");}
RemoteObject _ingresorecurrente = RemoteObject.declareNull("pullup.wallet.main._registroingreso");
 BA.debugLineNum = 244;BA.debugLine="Sub asignacionCampos As RegistroIngreso";
Debug.ShouldStop(524288);
 BA.debugLineNum = 245;BA.debugLine="Dim ingresoRecurrente As RegistroIngreso";
Debug.ShouldStop(1048576);
_ingresorecurrente = RemoteObject.createNew ("pullup.wallet.main._registroingreso");Debug.locals.put("ingresoRecurrente", _ingresorecurrente);
 BA.debugLineNum = 247;BA.debugLine="ingresoRecurrente.monto = txtMonto.Text";
Debug.ShouldStop(4194304);
_ingresorecurrente.setField ("monto" /*RemoteObject*/ ,BA.numberCast(int.class, editaringresorecurrente.mostCurrent._txtmonto.runMethod(true,"getText")));
 BA.debugLineNum = 249;BA.debugLine="ingresoRecurrente.nombre = txtNombre.Text";
Debug.ShouldStop(16777216);
_ingresorecurrente.setField ("nombre" /*RemoteObject*/ ,editaringresorecurrente.mostCurrent._txtnombre.runMethod(true,"getText"));
 BA.debugLineNum = 251;BA.debugLine="ingresoRecurrente.descripcion = (txtDescripcion.T";
Debug.ShouldStop(67108864);
_ingresorecurrente.setField ("descripcion" /*RemoteObject*/ ,(editaringresorecurrente.mostCurrent._txtdescripcion.runMethod(true,"getText")));
 BA.debugLineNum = 253;BA.debugLine="ingresoRecurrente.periodo = diasPeriodo";
Debug.ShouldStop(268435456);
_ingresorecurrente.setField ("periodo" /*RemoteObject*/ ,editaringresorecurrente._diasperiodo);
 BA.debugLineNum = 255;BA.debugLine="ingresoRecurrente.color = colorCaja";
Debug.ShouldStop(1073741824);
_ingresorecurrente.setField ("color" /*RemoteObject*/ ,editaringresorecurrente._colorcaja);
 BA.debugLineNum = 257;BA.debugLine="Return ingresoRecurrente";
Debug.ShouldStop(1);
if (true) return _ingresorecurrente;
 BA.debugLineNum = 258;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("btnMenu_Click (editaringresorecurrente) ","editaringresorecurrente",5,editaringresorecurrente.mostCurrent.activityBA,editaringresorecurrente.mostCurrent,165);
if (RapidSub.canDelegate("btnmenu_click")) { return pullup.wallet.editaringresorecurrente.remoteMe.runUserSub(false, "editaringresorecurrente","btnmenu_click");}
 BA.debugLineNum = 165;BA.debugLine="Private Sub btnMenu_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 166;BA.debugLine="Activity.Finish 'REGRESAR A MENU";
Debug.ShouldStop(32);
editaringresorecurrente.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _btnoperacioningresorecurrente_click() throws Exception{
try {
		Debug.PushSubsStack("btnOperacionIngresoRecurrente_Click (editaringresorecurrente) ","editaringresorecurrente",5,editaringresorecurrente.mostCurrent.activityBA,editaringresorecurrente.mostCurrent,262);
if (RapidSub.canDelegate("btnoperacioningresorecurrente_click")) { return pullup.wallet.editaringresorecurrente.remoteMe.runUserSub(false, "editaringresorecurrente","btnoperacioningresorecurrente_click");}
RemoteObject _validaciones = RemoteObject.createImmutable(false);
RemoteObject _ingresorecurrenteregistro = RemoteObject.declareNull("pullup.wallet.main._registroingreso");
 BA.debugLineNum = 262;BA.debugLine="Private Sub btnOperacionIngresoRecurrente_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 263;BA.debugLine="Dim validaciones As Boolean";
Debug.ShouldStop(64);
_validaciones = RemoteObject.createImmutable(false);Debug.locals.put("validaciones", _validaciones);
 BA.debugLineNum = 265;BA.debugLine="validaciones = validarCampos";
Debug.ShouldStop(256);
_validaciones = _validarcampos();Debug.locals.put("validaciones", _validaciones);
 BA.debugLineNum = 266;BA.debugLine="If(validaciones = True) Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("=",_validaciones,editaringresorecurrente.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 268;BA.debugLine="Dim ingresoRecurrenteRegistro As RegistroIngreso";
Debug.ShouldStop(2048);
_ingresorecurrenteregistro = RemoteObject.createNew ("pullup.wallet.main._registroingreso");Debug.locals.put("ingresoRecurrenteRegistro", _ingresorecurrenteregistro);
 BA.debugLineNum = 269;BA.debugLine="ingresoRecurrenteRegistro = asignacionCampos";
Debug.ShouldStop(4096);
_ingresorecurrenteregistro = _asignacioncampos();Debug.locals.put("ingresoRecurrenteRegistro", _ingresorecurrenteregistro);
 BA.debugLineNum = 272;BA.debugLine="sql.ExecNonQuery2(\"UPDATE ingresos_recurrentes S";
Debug.ShouldStop(32768);
editaringresorecurrente._sql.runVoidMethod ("ExecNonQuery2",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE ingresos_recurrentes SET monto = ?, nombre = ?, descripcion = ?, periodo = ?, color = ? WHERE id_ingreso_recurrente = '"),editaringresorecurrente._idregistro,RemoteObject.createImmutable("'"))),(Object)(editaringresorecurrente.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {(_ingresorecurrenteregistro.getField(true,"monto" /*RemoteObject*/ )),(_ingresorecurrenteregistro.getField(true,"nombre" /*RemoteObject*/ )),(_ingresorecurrenteregistro.getField(true,"descripcion" /*RemoteObject*/ )),(_ingresorecurrenteregistro.getField(true,"periodo" /*RemoteObject*/ )),(_ingresorecurrenteregistro.getField(true,"color" /*RemoteObject*/ ))})))));
 BA.debugLineNum = 274;BA.debugLine="ToastMessageShow(\"Ingreso recurrente editado\",Tr";
Debug.ShouldStop(131072);
editaringresorecurrente.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Ingreso recurrente editado")),(Object)(editaringresorecurrente.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 276;BA.debugLine="Activity.Finish";
Debug.ShouldStop(524288);
editaringresorecurrente.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 278;BA.debugLine="StartActivity(IngresosRecurrentes)";
Debug.ShouldStop(2097152);
editaringresorecurrente.mostCurrent.__c.runVoidMethod ("StartActivity",editaringresorecurrente.processBA,(Object)((editaringresorecurrente.mostCurrent._ingresosrecurrentes.getObject())));
 }else {
 BA.debugLineNum = 281;BA.debugLine="Msgbox2(\"Por favor, rellene todos los campos, se";
Debug.ShouldStop(16777216);
editaringresorecurrente.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("Por favor, rellene todos los campos, seleccione un periodo y color")),(Object)(BA.ObjectToCharSequence("Registro incorrecto")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((editaringresorecurrente.mostCurrent.__c.getField(false,"Null"))),editaringresorecurrente.mostCurrent.activityBA);
 };
 BA.debugLineNum = 283;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("consultaAEditar (editaringresorecurrente) ","editaringresorecurrente",5,editaringresorecurrente.mostCurrent.activityBA,editaringresorecurrente.mostCurrent,286);
if (RapidSub.canDelegate("consultaaeditar")) { return pullup.wallet.editaringresorecurrente.remoteMe.runUserSub(false, "editaringresorecurrente","consultaaeditar", _rowid);}
RemoteObject _ingresorecurrente = RemoteObject.declareNull("pullup.wallet.main._registroingreso");
Debug.locals.put("rowid", _rowid);
 BA.debugLineNum = 286;BA.debugLine="Sub consultaAEditar(rowid As Int)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 287;BA.debugLine="Dim ingresoRecurrente As RegistroIngreso";
Debug.ShouldStop(1073741824);
_ingresorecurrente = RemoteObject.createNew ("pullup.wallet.main._registroingreso");Debug.locals.put("ingresoRecurrente", _ingresorecurrente);
 BA.debugLineNum = 288;BA.debugLine="idRegistro = rowid";
Debug.ShouldStop(-2147483648);
editaringresorecurrente._idregistro = _rowid;
 BA.debugLineNum = 290;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM ingresos_recur";
Debug.ShouldStop(2);
editaringresorecurrente.mostCurrent._cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), editaringresorecurrente._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM ingresos_recurrentes WHERE id_ingreso_recurrente = '"),editaringresorecurrente._idregistro,RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 291;BA.debugLine="If(cur.RowCount > 0) Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean(">",editaringresorecurrente.mostCurrent._cur.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 292;BA.debugLine="cur.Position = 0";
Debug.ShouldStop(8);
editaringresorecurrente.mostCurrent._cur.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 293;BA.debugLine="ingresoRecurrente.nombre = cur.GetString(\"nombre";
Debug.ShouldStop(16);
_ingresorecurrente.setField ("nombre" /*RemoteObject*/ ,editaringresorecurrente.mostCurrent._cur.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("nombre"))));
 BA.debugLineNum = 294;BA.debugLine="ingresoRecurrente.monto = cur.GetInt(\"monto\")";
Debug.ShouldStop(32);
_ingresorecurrente.setField ("monto" /*RemoteObject*/ ,editaringresorecurrente.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("monto"))));
 BA.debugLineNum = 295;BA.debugLine="ingresoRecurrente.descripcion = cur.GetString(\"d";
Debug.ShouldStop(64);
_ingresorecurrente.setField ("descripcion" /*RemoteObject*/ ,editaringresorecurrente.mostCurrent._cur.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("descripcion"))));
 BA.debugLineNum = 296;BA.debugLine="ingresoRecurrente.periodo = cur.GetInt(\"periodo\"";
Debug.ShouldStop(128);
_ingresorecurrente.setField ("periodo" /*RemoteObject*/ ,editaringresorecurrente.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("periodo"))));
 BA.debugLineNum = 297;BA.debugLine="ingresoRecurrente.color = cur.GetString(\"color\")";
Debug.ShouldStop(256);
_ingresorecurrente.setField ("color" /*RemoteObject*/ ,BA.numberCast(int.class, editaringresorecurrente.mostCurrent._cur.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("color")))));
 BA.debugLineNum = 299;BA.debugLine="reasignarCamposAEditar(ingresoRecurrente)";
Debug.ShouldStop(1024);
_reasignarcamposaeditar(_ingresorecurrente);
 };
 BA.debugLineNum = 301;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("cpBarraColor_ColorChanged (editaringresorecurrente) ","editaringresorecurrente",5,editaringresorecurrente.mostCurrent.activityBA,editaringresorecurrente.mostCurrent,180);
if (RapidSub.canDelegate("cpbarracolor_colorchanged")) { return pullup.wallet.editaringresorecurrente.remoteMe.runUserSub(false, "editaringresorecurrente","cpbarracolor_colorchanged", _color);}
Debug.locals.put("color", _color);
 BA.debugLineNum = 180;BA.debugLine="Sub cpBarraColor_ColorChanged(color As Int)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 181;BA.debugLine="lblFondoMonto.Color = color";
Debug.ShouldStop(1048576);
editaringresorecurrente.mostCurrent._lblfondomonto.runVoidMethod ("setColor",_color);
 BA.debugLineNum = 182;BA.debugLine="colorCaja = color";
Debug.ShouldStop(2097152);
editaringresorecurrente._colorcaja = _color;
 BA.debugLineNum = 183;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
editaringresorecurrente._alturadispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 16;BA.debugLine="Dim anchoDispositivo As Int";
editaringresorecurrente._anchodispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 17;BA.debugLine="Dim colorCaja As Int";
editaringresorecurrente._colorcaja = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 18;BA.debugLine="Dim diasPeriodo As Int";
editaringresorecurrente._diasperiodo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 19;BA.debugLine="Dim aparicionMsgBox1 As Boolean";
editaringresorecurrente._aparicionmsgbox1 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 20;BA.debugLine="Dim aparicionMsgBox2 As Boolean";
editaringresorecurrente._aparicionmsgbox2 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 21;BA.debugLine="Dim aparicionMsgBox3 As Boolean";
editaringresorecurrente._aparicionmsgbox3 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 22;BA.debugLine="Dim cur As Cursor";
editaringresorecurrente.mostCurrent._cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Dim idRegistro As Int";
editaringresorecurrente._idregistro = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 27;BA.debugLine="Private btnMenu As Button";
editaringresorecurrente.mostCurrent._btnmenu = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private btnOperacionIngresoRecurrente As Button";
editaringresorecurrente.mostCurrent._btnoperacioningresorecurrente = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private txtDescripcion As EditText";
editaringresorecurrente.mostCurrent._txtdescripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private txtMonto As EditText";
editaringresorecurrente.mostCurrent._txtmonto = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private txtNombre As EditText";
editaringresorecurrente.mostCurrent._txtnombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private lblContornoBoton As Label";
editaringresorecurrente.mostCurrent._lblcontornoboton = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private lblFondoDescripcion As Label";
editaringresorecurrente.mostCurrent._lblfondodescripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private lblFondoMonto As Label";
editaringresorecurrente.mostCurrent._lblfondomonto = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private lblFondoNombre As Label";
editaringresorecurrente.mostCurrent._lblfondonombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private lblNombreVista As Label";
editaringresorecurrente.mostCurrent._lblnombrevista = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private rd1Ano As RadioButton";
editaringresorecurrente.mostCurrent._rd1ano = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private rd1Mes As RadioButton";
editaringresorecurrente.mostCurrent._rd1mes = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private rd1Semana As RadioButton";
editaringresorecurrente.mostCurrent._rd1semana = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private rd2Semanas As RadioButton";
editaringresorecurrente.mostCurrent._rd2semanas = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private rd3Semanas As RadioButton";
editaringresorecurrente.mostCurrent._rd3semanas = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private pnlPeriodos As Panel";
editaringresorecurrente.mostCurrent._pnlperiodos = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private pnlSelector As Panel";
editaringresorecurrente.mostCurrent._pnlselector = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private pnlNavInferior As Panel";
editaringresorecurrente.mostCurrent._pnlnavinferior = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private cpBarraColor As ASColorSlider";
editaringresorecurrente.mostCurrent._cpbarracolor = RemoteObject.createNew ("pullup.wallet.ascolorslider");
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _limitarlongitudentrada(RemoteObject _antiguo,RemoteObject _nuevo,RemoteObject _longitud,RemoteObject _view,RemoteObject _campo) throws Exception{
try {
		Debug.PushSubsStack("limitarLongitudEntrada (editaringresorecurrente) ","editaringresorecurrente",5,editaringresorecurrente.mostCurrent.activityBA,editaringresorecurrente.mostCurrent,187);
if (RapidSub.canDelegate("limitarlongitudentrada")) { return pullup.wallet.editaringresorecurrente.remoteMe.runUserSub(false, "editaringresorecurrente","limitarlongitudentrada", _antiguo, _nuevo, _longitud, _view, _campo);}
Debug.locals.put("antiguo", _antiguo);
Debug.locals.put("nuevo", _nuevo);
Debug.locals.put("longitud", _longitud);
Debug.locals.put("view", _view);
Debug.locals.put("campo", _campo);
 BA.debugLineNum = 187;BA.debugLine="Sub limitarLongitudEntrada(antiguo As String, nuev";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 188;BA.debugLine="If(nuevo.Length > longitud) Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean(">",_nuevo.runMethod(true,"length"),BA.numberCast(double.class, _longitud)))) { 
 BA.debugLineNum = 189;BA.debugLine="If(campo = \"monto\") Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("monto")))) { 
 BA.debugLineNum = 190;BA.debugLine="If(aparicionMsgBox1 = False) Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",editaringresorecurrente._aparicionmsgbox1,editaringresorecurrente.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 191;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
Debug.ShouldStop(1073741824);
editaringresorecurrente.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para el monto es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((editaringresorecurrente.mostCurrent.__c.getField(false,"Null"))),editaringresorecurrente.mostCurrent.activityBA);
 BA.debugLineNum = 192;BA.debugLine="aparicionMsgBox1 = True";
Debug.ShouldStop(-2147483648);
editaringresorecurrente._aparicionmsgbox1 = editaringresorecurrente.mostCurrent.__c.getField(true,"True");
 };
 }else 
{ BA.debugLineNum = 194;BA.debugLine="Else If(campo = \"nombre\") Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("nombre")))) { 
 BA.debugLineNum = 195;BA.debugLine="If(aparicionMsgBox2 = False) Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",editaringresorecurrente._aparicionmsgbox2,editaringresorecurrente.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 196;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
Debug.ShouldStop(8);
editaringresorecurrente.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para el nombre es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((editaringresorecurrente.mostCurrent.__c.getField(false,"Null"))),editaringresorecurrente.mostCurrent.activityBA);
 BA.debugLineNum = 197;BA.debugLine="aparicionMsgBox2 = True";
Debug.ShouldStop(16);
editaringresorecurrente._aparicionmsgbox2 = editaringresorecurrente.mostCurrent.__c.getField(true,"True");
 };
 }else 
{ BA.debugLineNum = 199;BA.debugLine="Else If(campo = \"descripcion\") Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("descripcion")))) { 
 BA.debugLineNum = 200;BA.debugLine="If(aparicionMsgBox3 = False) Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",editaringresorecurrente._aparicionmsgbox3,editaringresorecurrente.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 201;BA.debugLine="Msgbox2(\"La longitud máxima permitida para la";
Debug.ShouldStop(256);
editaringresorecurrente.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para la descripción es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((editaringresorecurrente.mostCurrent.__c.getField(false,"Null"))),editaringresorecurrente.mostCurrent.activityBA);
 BA.debugLineNum = 202;BA.debugLine="aparicionMsgBox3 = True";
Debug.ShouldStop(512);
editaringresorecurrente._aparicionmsgbox3 = editaringresorecurrente.mostCurrent.__c.getField(true,"True");
 };
 }}}
;
 BA.debugLineNum = 205;BA.debugLine="view.Text = antiguo";
Debug.ShouldStop(4096);
_view.runMethod(true,"setText",BA.ObjectToCharSequence(_antiguo));
 };
 BA.debugLineNum = 207;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
editaringresorecurrente._sql = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _rd1ano_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("rd1Ano_CheckedChange (editaringresorecurrente) ","editaringresorecurrente",5,editaringresorecurrente.mostCurrent.activityBA,editaringresorecurrente.mostCurrent,239);
if (RapidSub.canDelegate("rd1ano_checkedchange")) { return pullup.wallet.editaringresorecurrente.remoteMe.runUserSub(false, "editaringresorecurrente","rd1ano_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 239;BA.debugLine="Private Sub rd1Ano_CheckedChange(Checked As Boolea";
Debug.ShouldStop(16384);
 BA.debugLineNum = 240;BA.debugLine="diasPeriodo = 365";
Debug.ShouldStop(32768);
editaringresorecurrente._diasperiodo = BA.numberCast(int.class, 365);
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
public static RemoteObject  _rd1mes_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("rd1Mes_CheckedChange (editaringresorecurrente) ","editaringresorecurrente",5,editaringresorecurrente.mostCurrent.activityBA,editaringresorecurrente.mostCurrent,235);
if (RapidSub.canDelegate("rd1mes_checkedchange")) { return pullup.wallet.editaringresorecurrente.remoteMe.runUserSub(false, "editaringresorecurrente","rd1mes_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 235;BA.debugLine="Private Sub rd1Mes_CheckedChange(Checked As Boolea";
Debug.ShouldStop(1024);
 BA.debugLineNum = 236;BA.debugLine="diasPeriodo = 30";
Debug.ShouldStop(2048);
editaringresorecurrente._diasperiodo = BA.numberCast(int.class, 30);
 BA.debugLineNum = 237;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("rd1Semana_CheckedChange (editaringresorecurrente) ","editaringresorecurrente",5,editaringresorecurrente.mostCurrent.activityBA,editaringresorecurrente.mostCurrent,231);
if (RapidSub.canDelegate("rd1semana_checkedchange")) { return pullup.wallet.editaringresorecurrente.remoteMe.runUserSub(false, "editaringresorecurrente","rd1semana_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 231;BA.debugLine="Private Sub rd1Semana_CheckedChange(Checked As Boo";
Debug.ShouldStop(64);
 BA.debugLineNum = 232;BA.debugLine="diasPeriodo = 7";
Debug.ShouldStop(128);
editaringresorecurrente._diasperiodo = BA.numberCast(int.class, 7);
 BA.debugLineNum = 233;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("rd2Semanas_CheckedChange (editaringresorecurrente) ","editaringresorecurrente",5,editaringresorecurrente.mostCurrent.activityBA,editaringresorecurrente.mostCurrent,227);
if (RapidSub.canDelegate("rd2semanas_checkedchange")) { return pullup.wallet.editaringresorecurrente.remoteMe.runUserSub(false, "editaringresorecurrente","rd2semanas_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 227;BA.debugLine="Private Sub rd2Semanas_CheckedChange(Checked As Bo";
Debug.ShouldStop(4);
 BA.debugLineNum = 228;BA.debugLine="diasPeriodo = 14";
Debug.ShouldStop(8);
editaringresorecurrente._diasperiodo = BA.numberCast(int.class, 14);
 BA.debugLineNum = 229;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("rd3Semanas_CheckedChange (editaringresorecurrente) ","editaringresorecurrente",5,editaringresorecurrente.mostCurrent.activityBA,editaringresorecurrente.mostCurrent,223);
if (RapidSub.canDelegate("rd3semanas_checkedchange")) { return pullup.wallet.editaringresorecurrente.remoteMe.runUserSub(false, "editaringresorecurrente","rd3semanas_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 223;BA.debugLine="Private Sub rd3Semanas_CheckedChange(Checked As Bo";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 224;BA.debugLine="diasPeriodo = 21";
Debug.ShouldStop(-2147483648);
editaringresorecurrente._diasperiodo = BA.numberCast(int.class, 21);
 BA.debugLineNum = 225;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("reasignarCamposAEditar (editaringresorecurrente) ","editaringresorecurrente",5,editaringresorecurrente.mostCurrent.activityBA,editaringresorecurrente.mostCurrent,304);
if (RapidSub.canDelegate("reasignarcamposaeditar")) { return pullup.wallet.editaringresorecurrente.remoteMe.runUserSub(false, "editaringresorecurrente","reasignarcamposaeditar", _registro);}
Debug.locals.put("registro", _registro);
 BA.debugLineNum = 304;BA.debugLine="Sub reasignarCamposAEditar(registro As RegistroIng";
Debug.ShouldStop(32768);
 BA.debugLineNum = 305;BA.debugLine="txtNombre.Text = registro.nombre";
Debug.ShouldStop(65536);
editaringresorecurrente.mostCurrent._txtnombre.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_registro.getField(true,"nombre" /*RemoteObject*/ )));
 BA.debugLineNum = 306;BA.debugLine="txtMonto.Text = registro.monto";
Debug.ShouldStop(131072);
editaringresorecurrente.mostCurrent._txtmonto.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_registro.getField(true,"monto" /*RemoteObject*/ )));
 BA.debugLineNum = 307;BA.debugLine="txtDescripcion.Text = registro.descripcion";
Debug.ShouldStop(262144);
editaringresorecurrente.mostCurrent._txtdescripcion.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_registro.getField(true,"descripcion" /*RemoteObject*/ )));
 BA.debugLineNum = 308;BA.debugLine="Select registro.periodo";
Debug.ShouldStop(524288);
switch (BA.switchObjectToInt(_registro.getField(true,"periodo" /*RemoteObject*/ ),BA.numberCast(int.class, 7),BA.numberCast(int.class, 14),BA.numberCast(int.class, 21),BA.numberCast(int.class, 30),BA.numberCast(int.class, 365))) {
case 0: {
 BA.debugLineNum = 310;BA.debugLine="rd1Semana.Checked = True";
Debug.ShouldStop(2097152);
editaringresorecurrente.mostCurrent._rd1semana.runMethodAndSync(true,"setChecked",editaringresorecurrente.mostCurrent.__c.getField(true,"True"));
 break; }
case 1: {
 BA.debugLineNum = 312;BA.debugLine="rd2Semanas.Checked = True";
Debug.ShouldStop(8388608);
editaringresorecurrente.mostCurrent._rd2semanas.runMethodAndSync(true,"setChecked",editaringresorecurrente.mostCurrent.__c.getField(true,"True"));
 break; }
case 2: {
 BA.debugLineNum = 314;BA.debugLine="rd3Semanas.Checked = True";
Debug.ShouldStop(33554432);
editaringresorecurrente.mostCurrent._rd3semanas.runMethodAndSync(true,"setChecked",editaringresorecurrente.mostCurrent.__c.getField(true,"True"));
 break; }
case 3: {
 BA.debugLineNum = 316;BA.debugLine="rd1Mes.Checked = True";
Debug.ShouldStop(134217728);
editaringresorecurrente.mostCurrent._rd1mes.runMethodAndSync(true,"setChecked",editaringresorecurrente.mostCurrent.__c.getField(true,"True"));
 break; }
case 4: {
 BA.debugLineNum = 318;BA.debugLine="rd1Ano.Checked = True";
Debug.ShouldStop(536870912);
editaringresorecurrente.mostCurrent._rd1ano.runMethodAndSync(true,"setChecked",editaringresorecurrente.mostCurrent.__c.getField(true,"True"));
 break; }
}
;
 BA.debugLineNum = 320;BA.debugLine="diasPeriodo = registro.periodo";
Debug.ShouldStop(-2147483648);
editaringresorecurrente._diasperiodo = _registro.getField(true,"periodo" /*RemoteObject*/ );
 BA.debugLineNum = 321;BA.debugLine="cpBarraColor_ColorChanged(registro.color)";
Debug.ShouldStop(1);
_cpbarracolor_colorchanged(_registro.getField(true,"color" /*RemoteObject*/ ));
 BA.debugLineNum = 322;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("txtDescripcion_TextChanged (editaringresorecurrente) ","editaringresorecurrente",5,editaringresorecurrente.mostCurrent.activityBA,editaringresorecurrente.mostCurrent,218);
if (RapidSub.canDelegate("txtdescripcion_textchanged")) { return pullup.wallet.editaringresorecurrente.remoteMe.runUserSub(false, "editaringresorecurrente","txtdescripcion_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 218;BA.debugLine="Private Sub txtDescripcion_TextChanged (Old As Str";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 219;BA.debugLine="limitarLongitudEntrada(Old, New, 41, txtDescripci";
Debug.ShouldStop(67108864);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 41),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), editaringresorecurrente.mostCurrent._txtdescripcion.getObject()),RemoteObject.createImmutable("descripcion"));
 BA.debugLineNum = 220;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("txtMonto_TextChanged (editaringresorecurrente) ","editaringresorecurrente",5,editaringresorecurrente.mostCurrent.activityBA,editaringresorecurrente.mostCurrent,210);
if (RapidSub.canDelegate("txtmonto_textchanged")) { return pullup.wallet.editaringresorecurrente.remoteMe.runUserSub(false, "editaringresorecurrente","txtmonto_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 210;BA.debugLine="Private Sub txtMonto_TextChanged (Old As String, N";
Debug.ShouldStop(131072);
 BA.debugLineNum = 211;BA.debugLine="limitarLongitudEntrada(Old, New, 9, txtMonto, \"mo";
Debug.ShouldStop(262144);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 9),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), editaringresorecurrente.mostCurrent._txtmonto.getObject()),RemoteObject.createImmutable("monto"));
 BA.debugLineNum = 212;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("txtNombre_TextChanged (editaringresorecurrente) ","editaringresorecurrente",5,editaringresorecurrente.mostCurrent.activityBA,editaringresorecurrente.mostCurrent,214);
if (RapidSub.canDelegate("txtnombre_textchanged")) { return pullup.wallet.editaringresorecurrente.remoteMe.runUserSub(false, "editaringresorecurrente","txtnombre_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 214;BA.debugLine="Private Sub txtNombre_TextChanged (Old As String,";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 215;BA.debugLine="limitarLongitudEntrada(Old, New, 16, txtNombre, \"";
Debug.ShouldStop(4194304);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 16),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), editaringresorecurrente.mostCurrent._txtnombre.getObject()),RemoteObject.createImmutable("nombre"));
 BA.debugLineNum = 216;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("validarCampos (editaringresorecurrente) ","editaringresorecurrente",5,editaringresorecurrente.mostCurrent.activityBA,editaringresorecurrente.mostCurrent,170);
if (RapidSub.canDelegate("validarcampos")) { return pullup.wallet.editaringresorecurrente.remoteMe.runUserSub(false, "editaringresorecurrente","validarcampos");}
 BA.debugLineNum = 170;BA.debugLine="Sub validarCampos As Boolean";
Debug.ShouldStop(512);
 BA.debugLineNum = 171;BA.debugLine="If(txtMonto.Text.Length <> 0 And txtNombre.Text.L";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("!",editaringresorecurrente.mostCurrent._txtmonto.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",editaringresorecurrente.mostCurrent._txtnombre.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",editaringresorecurrente.mostCurrent._txtdescripcion.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",editaringresorecurrente._colorcaja,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",editaringresorecurrente._diasperiodo,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 172;BA.debugLine="Return True";
Debug.ShouldStop(2048);
if (true) return editaringresorecurrente.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 174;BA.debugLine="Return False";
Debug.ShouldStop(8192);
if (true) return editaringresorecurrente.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 176;BA.debugLine="End Sub";
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