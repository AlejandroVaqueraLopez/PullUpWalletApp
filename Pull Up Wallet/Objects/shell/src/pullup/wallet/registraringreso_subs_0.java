package pullup.wallet;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class registraringreso_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (registraringreso) ","registraringreso",15,registraringreso.mostCurrent.activityBA,registraringreso.mostCurrent,57);
if (RapidSub.canDelegate("activity_create")) { return pullup.wallet.registraringreso.remoteMe.runUserSub(false, "registraringreso","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 57;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 58;BA.debugLine="Activity.LoadLayout(\"LFormIngreso\")";
Debug.ShouldStop(33554432);
registraringreso.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("LFormIngreso")),registraringreso.mostCurrent.activityBA);
 BA.debugLineNum = 59;BA.debugLine="alturaDispositivo = GetDeviceLayoutValues.Height";
Debug.ShouldStop(67108864);
registraringreso._alturadispositivo = registraringreso.mostCurrent.__c.runMethod(false,"GetDeviceLayoutValues",registraringreso.mostCurrent.activityBA).getField(true,"Height");
 BA.debugLineNum = 60;BA.debugLine="anchoDispositivo = GetDeviceLayoutValues.Width";
Debug.ShouldStop(134217728);
registraringreso._anchodispositivo = registraringreso.mostCurrent.__c.runMethod(false,"GetDeviceLayoutValues",registraringreso.mostCurrent.activityBA).getField(true,"Width");
 BA.debugLineNum = 61;BA.debugLine="btnRecurrente.TextColor = Colors.White";
Debug.ShouldStop(268435456);
registraringreso.mostCurrent._btnrecurrente.runMethod(true,"setTextColor",registraringreso.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 62;BA.debugLine="btnUnico.TextColor = Colors.Black";
Debug.ShouldStop(536870912);
registraringreso.mostCurrent._btnunico.runMethod(true,"setTextColor",registraringreso.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 63;BA.debugLine="tipoIngreso = \"Recurrente\"";
Debug.ShouldStop(1073741824);
registraringreso.mostCurrent._tipoingreso = BA.ObjectToString("Recurrente");
 BA.debugLineNum = 64;BA.debugLine="sql = Starter.sql";
Debug.ShouldStop(-2147483648);
registraringreso._sql = registraringreso.mostCurrent._starter._sql /*RemoteObject*/ ;
 BA.debugLineNum = 65;BA.debugLine="diasPeriodo = 7";
Debug.ShouldStop(1);
registraringreso._diasperiodo = BA.numberCast(int.class, 7);
 BA.debugLineNum = 68;BA.debugLine="lblNombreVista.TextSize = 20";
Debug.ShouldStop(8);
registraringreso.mostCurrent._lblnombrevista.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 69;BA.debugLine="lblNombreVista.TextColor = Colors.Black";
Debug.ShouldStop(16);
registraringreso.mostCurrent._lblnombrevista.runMethod(true,"setTextColor",registraringreso.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 70;BA.debugLine="lblNombreVista.Height = 30dip";
Debug.ShouldStop(32);
registraringreso.mostCurrent._lblnombrevista.runMethod(true,"setHeight",registraringreso.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 71;BA.debugLine="lblNombreVista.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(64);
registraringreso.mostCurrent._lblnombrevista.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 72;BA.debugLine="lblNombreVista.Top = 30dip";
Debug.ShouldStop(128);
registraringreso.mostCurrent._lblnombrevista.runMethod(true,"setTop",registraringreso.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 73;BA.debugLine="lblNombreVista.Left = (anchoDispositivo - lblNomb";
Debug.ShouldStop(256);
registraringreso.mostCurrent._lblnombrevista.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registraringreso._anchodispositivo,registraringreso.mostCurrent._lblnombrevista.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 75;BA.debugLine="txtMonto.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(1024);
registraringreso.mostCurrent._txtmonto.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 76;BA.debugLine="txtMonto.Height = alturaDispositivo * 0.22";
Debug.ShouldStop(2048);
registraringreso.mostCurrent._txtmonto.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso._alturadispositivo,RemoteObject.createImmutable(0.22)}, "*",0, 0)));
 BA.debugLineNum = 77;BA.debugLine="txtMonto.Top = lblNombreVista.Top * 1.5 + lblNomb";
Debug.ShouldStop(4096);
registraringreso.mostCurrent._txtmonto.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(1.5),registraringreso.mostCurrent._lblnombrevista.runMethod(true,"getHeight")}, "*+",1, 0)));
 BA.debugLineNum = 78;BA.debugLine="txtMonto.Left = (anchoDispositivo - txtMonto.Widt";
Debug.ShouldStop(8192);
registraringreso.mostCurrent._txtmonto.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registraringreso._anchodispositivo,registraringreso.mostCurrent._txtmonto.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 79;BA.debugLine="lblFondoMonto.Width = txtMonto.Width";
Debug.ShouldStop(16384);
registraringreso.mostCurrent._lblfondomonto.runMethod(true,"setWidth",registraringreso.mostCurrent._txtmonto.runMethod(true,"getWidth"));
 BA.debugLineNum = 80;BA.debugLine="lblFondoMonto.Height = txtMonto.Height";
Debug.ShouldStop(32768);
registraringreso.mostCurrent._lblfondomonto.runMethod(true,"setHeight",registraringreso.mostCurrent._txtmonto.runMethod(true,"getHeight"));
 BA.debugLineNum = 81;BA.debugLine="lblFondoMonto.Top = txtMonto.Top";
Debug.ShouldStop(65536);
registraringreso.mostCurrent._lblfondomonto.runMethod(true,"setTop",registraringreso.mostCurrent._txtmonto.runMethod(true,"getTop"));
 BA.debugLineNum = 82;BA.debugLine="lblFondoMonto.Left = txtMonto.Left";
Debug.ShouldStop(131072);
registraringreso.mostCurrent._lblfondomonto.runMethod(true,"setLeft",registraringreso.mostCurrent._txtmonto.runMethod(true,"getLeft"));
 BA.debugLineNum = 85;BA.debugLine="btnRecurrente.Width = anchoDispositivo * 0.3";
Debug.ShouldStop(1048576);
registraringreso.mostCurrent._btnrecurrente.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso._anchodispositivo,RemoteObject.createImmutable(0.3)}, "*",0, 0)));
 BA.debugLineNum = 86;BA.debugLine="btnRecurrente.Height = alturaDispositivo * 0.05";
Debug.ShouldStop(2097152);
registraringreso.mostCurrent._btnrecurrente.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso._alturadispositivo,RemoteObject.createImmutable(0.05)}, "*",0, 0)));
 BA.debugLineNum = 87;BA.debugLine="btnRecurrente.Top = txtMonto.Top + txtMonto.Heigh";
Debug.ShouldStop(4194304);
registraringreso.mostCurrent._btnrecurrente.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso.mostCurrent._txtmonto.runMethod(true,"getTop"),registraringreso.mostCurrent._txtmonto.runMethod(true,"getHeight"),registraringreso.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 88;BA.debugLine="btnRecurrente.Left = ((anchoDispositivo / 2) - bt";
Debug.ShouldStop(8388608);
registraringreso.mostCurrent._btnrecurrente.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registraringreso._anchodispositivo,RemoteObject.createImmutable(2)}, "/",0, 0)),registraringreso.mostCurrent._btnrecurrente.runMethod(true,"getWidth")}, "-",1, 0)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 90;BA.debugLine="btnUnico.Width = btnRecurrente.Width";
Debug.ShouldStop(33554432);
registraringreso.mostCurrent._btnunico.runMethod(true,"setWidth",registraringreso.mostCurrent._btnrecurrente.runMethod(true,"getWidth"));
 BA.debugLineNum = 91;BA.debugLine="btnUnico.Height = btnRecurrente.Height";
Debug.ShouldStop(67108864);
registraringreso.mostCurrent._btnunico.runMethod(true,"setHeight",registraringreso.mostCurrent._btnrecurrente.runMethod(true,"getHeight"));
 BA.debugLineNum = 92;BA.debugLine="btnUnico.Top = btnRecurrente.Top";
Debug.ShouldStop(134217728);
registraringreso.mostCurrent._btnunico.runMethod(true,"setTop",registraringreso.mostCurrent._btnrecurrente.runMethod(true,"getTop"));
 BA.debugLineNum = 93;BA.debugLine="btnUnico.Left = (anchoDispositivo / 2) + btnRecur";
Debug.ShouldStop(268435456);
registraringreso.mostCurrent._btnunico.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registraringreso._anchodispositivo,RemoteObject.createImmutable(2)}, "/",0, 0)),registraringreso.mostCurrent._btnrecurrente.runMethod(true,"getLeft")}, "+",1, 0)));
 BA.debugLineNum = 95;BA.debugLine="txtNombre.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(1073741824);
registraringreso.mostCurrent._txtnombre.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 96;BA.debugLine="txtNombre.Height = alturaDispositivo * 0.07";
Debug.ShouldStop(-2147483648);
registraringreso.mostCurrent._txtnombre.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso._alturadispositivo,RemoteObject.createImmutable(0.07)}, "*",0, 0)));
 BA.debugLineNum = 97;BA.debugLine="txtNombre.Top = btnRecurrente.Top + btnRecurrente";
Debug.ShouldStop(1);
registraringreso.mostCurrent._txtnombre.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso.mostCurrent._btnrecurrente.runMethod(true,"getTop"),registraringreso.mostCurrent._btnrecurrente.runMethod(true,"getHeight"),registraringreso.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 98;BA.debugLine="txtNombre.Left = (anchoDispositivo - txtNombre.Wi";
Debug.ShouldStop(2);
registraringreso.mostCurrent._txtnombre.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registraringreso._anchodispositivo,registraringreso.mostCurrent._txtnombre.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 99;BA.debugLine="lblFondoNombre.Width = txtMonto.Width";
Debug.ShouldStop(4);
registraringreso.mostCurrent._lblfondonombre.runMethod(true,"setWidth",registraringreso.mostCurrent._txtmonto.runMethod(true,"getWidth"));
 BA.debugLineNum = 100;BA.debugLine="lblFondoNombre.Height = txtNombre.Height";
Debug.ShouldStop(8);
registraringreso.mostCurrent._lblfondonombre.runMethod(true,"setHeight",registraringreso.mostCurrent._txtnombre.runMethod(true,"getHeight"));
 BA.debugLineNum = 101;BA.debugLine="lblFondoNombre.Top = txtNombre.Top";
Debug.ShouldStop(16);
registraringreso.mostCurrent._lblfondonombre.runMethod(true,"setTop",registraringreso.mostCurrent._txtnombre.runMethod(true,"getTop"));
 BA.debugLineNum = 102;BA.debugLine="lblFondoNombre.Left = txtNombre.Left";
Debug.ShouldStop(32);
registraringreso.mostCurrent._lblfondonombre.runMethod(true,"setLeft",registraringreso.mostCurrent._txtnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 104;BA.debugLine="txtDescripcion.Width = txtNombre.Width";
Debug.ShouldStop(128);
registraringreso.mostCurrent._txtdescripcion.runMethod(true,"setWidth",registraringreso.mostCurrent._txtnombre.runMethod(true,"getWidth"));
 BA.debugLineNum = 105;BA.debugLine="txtDescripcion.Height = txtNombre.Height";
Debug.ShouldStop(256);
registraringreso.mostCurrent._txtdescripcion.runMethod(true,"setHeight",registraringreso.mostCurrent._txtnombre.runMethod(true,"getHeight"));
 BA.debugLineNum = 106;BA.debugLine="txtDescripcion.Top = txtNombre.Top + txtNombre.He";
Debug.ShouldStop(512);
registraringreso.mostCurrent._txtdescripcion.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso.mostCurrent._txtnombre.runMethod(true,"getTop"),registraringreso.mostCurrent._txtnombre.runMethod(true,"getHeight"),registraringreso.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 107;BA.debugLine="txtDescripcion.Left = txtNombre.Left";
Debug.ShouldStop(1024);
registraringreso.mostCurrent._txtdescripcion.runMethod(true,"setLeft",registraringreso.mostCurrent._txtnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 108;BA.debugLine="lblFondoDescripcion.Width = txtDescripcion.Width";
Debug.ShouldStop(2048);
registraringreso.mostCurrent._lblfondodescripcion.runMethod(true,"setWidth",registraringreso.mostCurrent._txtdescripcion.runMethod(true,"getWidth"));
 BA.debugLineNum = 109;BA.debugLine="lblFondoDescripcion.Height = txtDescripcion.Heigh";
Debug.ShouldStop(4096);
registraringreso.mostCurrent._lblfondodescripcion.runMethod(true,"setHeight",registraringreso.mostCurrent._txtdescripcion.runMethod(true,"getHeight"));
 BA.debugLineNum = 110;BA.debugLine="lblFondoDescripcion.Top = txtDescripcion.Top";
Debug.ShouldStop(8192);
registraringreso.mostCurrent._lblfondodescripcion.runMethod(true,"setTop",registraringreso.mostCurrent._txtdescripcion.runMethod(true,"getTop"));
 BA.debugLineNum = 111;BA.debugLine="lblFondoDescripcion.Left = txtDescripcion.Left";
Debug.ShouldStop(16384);
registraringreso.mostCurrent._lblfondodescripcion.runMethod(true,"setLeft",registraringreso.mostCurrent._txtdescripcion.runMethod(true,"getLeft"));
 BA.debugLineNum = 113;BA.debugLine="pnlSelector.Top = txtDescripcion.Top + txtDescrip";
Debug.ShouldStop(65536);
registraringreso.mostCurrent._pnlselector.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso.mostCurrent._txtdescripcion.runMethod(true,"getTop"),registraringreso.mostCurrent._txtdescripcion.runMethod(true,"getHeight"),registraringreso.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 114;BA.debugLine="pnlSelector.Left = txtDescripcion.Left + txtDescr";
Debug.ShouldStop(131072);
registraringreso.mostCurrent._pnlselector.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {registraringreso.mostCurrent._txtdescripcion.runMethod(true,"getLeft"),registraringreso.mostCurrent._txtdescripcion.runMethod(true,"getWidth"),registraringreso.mostCurrent._pnlselector.runMethod(true,"getWidth")}, "+-",2, 1));
 BA.debugLineNum = 116;BA.debugLine="pnlPeriodos.Top = pnlSelector.Top";
Debug.ShouldStop(524288);
registraringreso.mostCurrent._pnlperiodos.runMethod(true,"setTop",registraringreso.mostCurrent._pnlselector.runMethod(true,"getTop"));
 BA.debugLineNum = 117;BA.debugLine="pnlPeriodos.Left = txtDescripcion.Left";
Debug.ShouldStop(1048576);
registraringreso.mostCurrent._pnlperiodos.runMethod(true,"setLeft",registraringreso.mostCurrent._txtdescripcion.runMethod(true,"getLeft"));
 BA.debugLineNum = 118;BA.debugLine="pnlPeriodos.Width = (txtDescripcion.Width - pnlSe";
Debug.ShouldStop(2097152);
registraringreso.mostCurrent._pnlperiodos.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registraringreso.mostCurrent._txtdescripcion.runMethod(true,"getWidth"),registraringreso.mostCurrent._pnlselector.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 119;BA.debugLine="pnlPeriodos.Height = pnlSelector.Height";
Debug.ShouldStop(4194304);
registraringreso.mostCurrent._pnlperiodos.runMethod(true,"setHeight",registraringreso.mostCurrent._pnlselector.runMethod(true,"getHeight"));
 BA.debugLineNum = 122;BA.debugLine="rd1Semana.Width = pnlPeriodos.Width";
Debug.ShouldStop(33554432);
registraringreso.mostCurrent._rd1semana.runMethod(true,"setWidth",registraringreso.mostCurrent._pnlperiodos.runMethod(true,"getWidth"));
 BA.debugLineNum = 123;BA.debugLine="rd1Semana.Height = pnlPeriodos.Height * 0.18";
Debug.ShouldStop(67108864);
registraringreso.mostCurrent._rd1semana.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.18)}, "*",0, 0)));
 BA.debugLineNum = 124;BA.debugLine="rd1Semana.Left = 0";
Debug.ShouldStop(134217728);
registraringreso.mostCurrent._rd1semana.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 125;BA.debugLine="rd1Semana.Top = 0";
Debug.ShouldStop(268435456);
registraringreso.mostCurrent._rd1semana.runMethod(true,"setTop",BA.numberCast(int.class, 0));
 BA.debugLineNum = 127;BA.debugLine="rd2Semanas.Width = rd1Semana.Width";
Debug.ShouldStop(1073741824);
registraringreso.mostCurrent._rd2semanas.runMethod(true,"setWidth",registraringreso.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 128;BA.debugLine="rd2Semanas.Height = rd1Semana.Height";
Debug.ShouldStop(-2147483648);
registraringreso.mostCurrent._rd2semanas.runMethod(true,"setHeight",registraringreso.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 129;BA.debugLine="rd2Semanas.Left = rd1Semana.Left";
Debug.ShouldStop(1);
registraringreso.mostCurrent._rd2semanas.runMethod(true,"setLeft",registraringreso.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 130;BA.debugLine="rd2Semanas.Top = rd1Semana.Height + pnlPeriodos.H";
Debug.ShouldStop(2);
registraringreso.mostCurrent._rd2semanas.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso.mostCurrent._rd1semana.runMethod(true,"getHeight"),registraringreso.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "+*",1, 0)));
 BA.debugLineNum = 132;BA.debugLine="rd3Semanas.Width = rd1Semana.Width";
Debug.ShouldStop(8);
registraringreso.mostCurrent._rd3semanas.runMethod(true,"setWidth",registraringreso.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 133;BA.debugLine="rd3Semanas.Height = rd1Semana.Height";
Debug.ShouldStop(16);
registraringreso.mostCurrent._rd3semanas.runMethod(true,"setHeight",registraringreso.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 134;BA.debugLine="rd3Semanas.Left = rd1Semana.Left";
Debug.ShouldStop(32);
registraringreso.mostCurrent._rd3semanas.runMethod(true,"setLeft",registraringreso.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 135;BA.debugLine="rd3Semanas.Top = rd2Semanas.Top + rd2Semanas.Heig";
Debug.ShouldStop(64);
registraringreso.mostCurrent._rd3semanas.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso.mostCurrent._rd2semanas.runMethod(true,"getTop"),registraringreso.mostCurrent._rd2semanas.runMethod(true,"getHeight"),registraringreso.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "++*",2, 0)));
 BA.debugLineNum = 137;BA.debugLine="rd1Mes.Width = rd1Semana.Width";
Debug.ShouldStop(256);
registraringreso.mostCurrent._rd1mes.runMethod(true,"setWidth",registraringreso.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 138;BA.debugLine="rd1Mes.Height = rd1Semana.Height";
Debug.ShouldStop(512);
registraringreso.mostCurrent._rd1mes.runMethod(true,"setHeight",registraringreso.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 139;BA.debugLine="rd1Mes.Left = rd1Semana.Left";
Debug.ShouldStop(1024);
registraringreso.mostCurrent._rd1mes.runMethod(true,"setLeft",registraringreso.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 140;BA.debugLine="rd1Mes.Top = rd3Semanas.Top + rd3Semanas.Height +";
Debug.ShouldStop(2048);
registraringreso.mostCurrent._rd1mes.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso.mostCurrent._rd3semanas.runMethod(true,"getTop"),registraringreso.mostCurrent._rd3semanas.runMethod(true,"getHeight"),registraringreso.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "++*",2, 0)));
 BA.debugLineNum = 142;BA.debugLine="rd1Ano.Width = rd1Semana.Width";
Debug.ShouldStop(8192);
registraringreso.mostCurrent._rd1ano.runMethod(true,"setWidth",registraringreso.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 143;BA.debugLine="rd1Ano.Height = rd1Semana.Height";
Debug.ShouldStop(16384);
registraringreso.mostCurrent._rd1ano.runMethod(true,"setHeight",registraringreso.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 144;BA.debugLine="rd1Ano.Left = rd1Semana.Left";
Debug.ShouldStop(32768);
registraringreso.mostCurrent._rd1ano.runMethod(true,"setLeft",registraringreso.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 145;BA.debugLine="rd1Ano.Top = rd1Mes.Top + rd1Mes.Height + pnlPeri";
Debug.ShouldStop(65536);
registraringreso.mostCurrent._rd1ano.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso.mostCurrent._rd1mes.runMethod(true,"getTop"),registraringreso.mostCurrent._rd1mes.runMethod(true,"getHeight"),registraringreso.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "++*",2, 0)));
 BA.debugLineNum = 150;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
Debug.ShouldStop(2097152);
registraringreso.mostCurrent._pnlnavinferior.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso._alturadispositivo,RemoteObject.createImmutable(0.08)}, "*",0, 0)));
 BA.debugLineNum = 151;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
Debug.ShouldStop(4194304);
registraringreso.mostCurrent._pnlnavinferior.runMethod(true,"setWidth",registraringreso._anchodispositivo);
 BA.debugLineNum = 152;BA.debugLine="pnlNavInferior.Left = 0";
Debug.ShouldStop(8388608);
registraringreso.mostCurrent._pnlnavinferior.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 153;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
Debug.ShouldStop(16777216);
registraringreso.mostCurrent._pnlnavinferior.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {registraringreso._alturadispositivo,registraringreso.mostCurrent._pnlnavinferior.runMethod(true,"getHeight")}, "-",1, 1));
 BA.debugLineNum = 156;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
Debug.ShouldStop(134217728);
registraringreso.mostCurrent._btnmenu.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso._anchodispositivo,RemoteObject.createImmutable(0.15)}, "*",0, 0)));
 BA.debugLineNum = 157;BA.debugLine="btnMenu.Height = btnMenu.Width";
Debug.ShouldStop(268435456);
registraringreso.mostCurrent._btnmenu.runMethod(true,"setHeight",registraringreso.mostCurrent._btnmenu.runMethod(true,"getWidth"));
 BA.debugLineNum = 158;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
Debug.ShouldStop(536870912);
registraringreso.mostCurrent._btnmenu.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),registraringreso.mostCurrent._btnmenu.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 159;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
Debug.ShouldStop(1073741824);
registraringreso.mostCurrent._btnmenu.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registraringreso._anchodispositivo,registraringreso.mostCurrent._btnmenu.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 161;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
Debug.ShouldStop(1);
registraringreso.mostCurrent._lblcontornoboton.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso._anchodispositivo,RemoteObject.createImmutable(0.17)}, "*",0, 0)));
 BA.debugLineNum = 162;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
Debug.ShouldStop(2);
registraringreso.mostCurrent._lblcontornoboton.runMethod(true,"setHeight",registraringreso.mostCurrent._lblcontornoboton.runMethod(true,"getWidth"));
 BA.debugLineNum = 163;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
Debug.ShouldStop(4);
registraringreso.mostCurrent._lblcontornoboton.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registraringreso._anchodispositivo,registraringreso.mostCurrent._lblcontornoboton.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 164;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
Debug.ShouldStop(8);
registraringreso.mostCurrent._lblcontornoboton.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),registraringreso.mostCurrent._lblcontornoboton.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 169;BA.debugLine="btnOperacionIngreso.Text = \"Guardar ingreso\"";
Debug.ShouldStop(256);
registraringreso.mostCurrent._btnoperacioningreso.runMethod(true,"setText",BA.ObjectToCharSequence("Guardar ingreso"));
 BA.debugLineNum = 170;BA.debugLine="btnOperacionIngreso.Top = pnlPeriodos.Top + pnlPe";
Debug.ShouldStop(512);
registraringreso.mostCurrent._btnoperacioningreso.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registraringreso.mostCurrent._pnlperiodos.runMethod(true,"getTop"),registraringreso.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {registraringreso.mostCurrent._lblcontornoboton.runMethod(true,"getTop"),(RemoteObject.solve(new RemoteObject[] {registraringreso.mostCurrent._pnlperiodos.runMethod(true,"getTop"),registraringreso.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),registraringreso.mostCurrent._btnoperacioningreso.runMethod(true,"getHeight")}, "++",2, 1))}, "-",1, 1)),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 171;BA.debugLine="btnOperacionIngreso.Left = (anchoDispositivo - bt";
Debug.ShouldStop(1024);
registraringreso.mostCurrent._btnoperacioningreso.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registraringreso._anchodispositivo,registraringreso.mostCurrent._btnoperacioningreso.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (registraringreso) ","registraringreso",15,registraringreso.mostCurrent.activityBA,registraringreso.mostCurrent,178);
if (RapidSub.canDelegate("activity_pause")) { return pullup.wallet.registraringreso.remoteMe.runUserSub(false, "registraringreso","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 178;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(131072);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (registraringreso) ","registraringreso",15,registraringreso.mostCurrent.activityBA,registraringreso.mostCurrent,174);
if (RapidSub.canDelegate("activity_resume")) { return pullup.wallet.registraringreso.remoteMe.runUserSub(false, "registraringreso","activity_resume");}
 BA.debugLineNum = 174;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8192);
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
public static RemoteObject  _asignacioncampos() throws Exception{
try {
		Debug.PushSubsStack("asignacionCampos (registraringreso) ","registraringreso",15,registraringreso.mostCurrent.activityBA,registraringreso.mostCurrent,327);
if (RapidSub.canDelegate("asignacioncampos")) { return pullup.wallet.registraringreso.remoteMe.runUserSub(false, "registraringreso","asignacioncampos");}
RemoteObject _ingreso = RemoteObject.declareNull("pullup.wallet.main._registroingreso");
 BA.debugLineNum = 327;BA.debugLine="Sub asignacionCampos As RegistroIngreso";
Debug.ShouldStop(64);
 BA.debugLineNum = 328;BA.debugLine="Dim ingreso As RegistroIngreso";
Debug.ShouldStop(128);
_ingreso = RemoteObject.createNew ("pullup.wallet.main._registroingreso");Debug.locals.put("ingreso", _ingreso);
 BA.debugLineNum = 330;BA.debugLine="ingreso.monto = txtMonto.Text";
Debug.ShouldStop(512);
_ingreso.setField ("monto" /*RemoteObject*/ ,BA.numberCast(int.class, registraringreso.mostCurrent._txtmonto.runMethod(true,"getText")));
 BA.debugLineNum = 332;BA.debugLine="ingreso.nombre = txtNombre.Text";
Debug.ShouldStop(2048);
_ingreso.setField ("nombre" /*RemoteObject*/ ,registraringreso.mostCurrent._txtnombre.runMethod(true,"getText"));
 BA.debugLineNum = 334;BA.debugLine="ingreso.descripcion = (txtDescripcion.Text)";
Debug.ShouldStop(8192);
_ingreso.setField ("descripcion" /*RemoteObject*/ ,(registraringreso.mostCurrent._txtdescripcion.runMethod(true,"getText")));
 BA.debugLineNum = 336;BA.debugLine="ingreso.periodo = diasPeriodo";
Debug.ShouldStop(32768);
_ingreso.setField ("periodo" /*RemoteObject*/ ,registraringreso._diasperiodo);
 BA.debugLineNum = 338;BA.debugLine="ingreso.fechaCobro = fechaMasPeriodo(ingreso.peri";
Debug.ShouldStop(131072);
_ingreso.setField ("fechaCobro" /*RemoteObject*/ ,_fechamasperiodo(_ingreso.getField(true,"periodo" /*RemoteObject*/ )));
 BA.debugLineNum = 340;BA.debugLine="ingreso.color = colorCaja";
Debug.ShouldStop(524288);
_ingreso.setField ("color" /*RemoteObject*/ ,registraringreso._colorcaja);
 BA.debugLineNum = 342;BA.debugLine="Return ingreso";
Debug.ShouldStop(2097152);
if (true) return _ingreso;
 BA.debugLineNum = 343;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("btnMenu_Click (registraringreso) ","registraringreso",15,registraringreso.mostCurrent.activityBA,registraringreso.mostCurrent,182);
if (RapidSub.canDelegate("btnmenu_click")) { return pullup.wallet.registraringreso.remoteMe.runUserSub(false, "registraringreso","btnmenu_click");}
 BA.debugLineNum = 182;BA.debugLine="Private Sub btnMenu_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 183;BA.debugLine="Activity.Finish";
Debug.ShouldStop(4194304);
registraringreso.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 184;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnoperacioningreso_click() throws Exception{
try {
		Debug.PushSubsStack("btnOperacionIngreso_Click (registraringreso) ","registraringreso",15,registraringreso.mostCurrent.activityBA,registraringreso.mostCurrent,347);
if (RapidSub.canDelegate("btnoperacioningreso_click")) { return pullup.wallet.registraringreso.remoteMe.runUserSub(false, "registraringreso","btnoperacioningreso_click");}
RemoteObject _validaciones = RemoteObject.createImmutable(false);
RemoteObject _ingresoregistrar = RemoteObject.declareNull("pullup.wallet.main._registroingreso");
 BA.debugLineNum = 347;BA.debugLine="Private Sub btnOperacionIngreso_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 348;BA.debugLine="Dim cur As Cursor";
Debug.ShouldStop(134217728);
registraringreso.mostCurrent._cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 BA.debugLineNum = 349;BA.debugLine="Dim validaciones As Boolean";
Debug.ShouldStop(268435456);
_validaciones = RemoteObject.createImmutable(false);Debug.locals.put("validaciones", _validaciones);
 BA.debugLineNum = 350;BA.debugLine="Dim ingresosActuales As Int";
Debug.ShouldStop(536870912);
registraringreso._ingresosactuales = RemoteObject.createImmutable(0);
 BA.debugLineNum = 352;BA.debugLine="validaciones = validarCampos";
Debug.ShouldStop(-2147483648);
_validaciones = _validarcampos();Debug.locals.put("validaciones", _validaciones);
 BA.debugLineNum = 353;BA.debugLine="If(validaciones = True) Then";
Debug.ShouldStop(1);
if ((RemoteObject.solveBoolean("=",_validaciones,registraringreso.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 355;BA.debugLine="Dim ingresoRegistrar As RegistroIngreso";
Debug.ShouldStop(4);
_ingresoregistrar = RemoteObject.createNew ("pullup.wallet.main._registroingreso");Debug.locals.put("ingresoRegistrar", _ingresoregistrar);
 BA.debugLineNum = 356;BA.debugLine="ingresoRegistrar = asignacionCampos";
Debug.ShouldStop(8);
_ingresoregistrar = _asignacioncampos();Debug.locals.put("ingresoRegistrar", _ingresoregistrar);
 BA.debugLineNum = 359;BA.debugLine="If(tipoIngreso = \"Recurrente\") Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",registraringreso.mostCurrent._tipoingreso,RemoteObject.createImmutable("Recurrente")))) { 
 BA.debugLineNum = 360;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO ingresos_recurre";
Debug.ShouldStop(128);
registraringreso._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO ingresos_recurrentes (monto, nombre, descripcion, periodo, fecha_cobro, color) VALUES (?, ?, ?, ?, ?, ?)")),(Object)(registraringreso.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {6},new Object[] {(_ingresoregistrar.getField(true,"monto" /*RemoteObject*/ )),(_ingresoregistrar.getField(true,"nombre" /*RemoteObject*/ )),(_ingresoregistrar.getField(true,"descripcion" /*RemoteObject*/ )),(_ingresoregistrar.getField(true,"periodo" /*RemoteObject*/ )),(_ingresoregistrar.getField(true,"fechaCobro" /*RemoteObject*/ )),(_ingresoregistrar.getField(true,"color" /*RemoteObject*/ ))})))));
 BA.debugLineNum = 364;BA.debugLine="cur = sql.ExecQuery(\"SELECT suma_ingresos FROM";
Debug.ShouldStop(2048);
registraringreso.mostCurrent._cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), registraringreso._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT suma_ingresos FROM ingresos"))));
 BA.debugLineNum = 365;BA.debugLine="cur.Position = 0";
Debug.ShouldStop(4096);
registraringreso.mostCurrent._cur.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 366;BA.debugLine="ingresosActuales = cur.GetInt(\"suma_ingresos\")";
Debug.ShouldStop(8192);
registraringreso._ingresosactuales = registraringreso.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("suma_ingresos")));
 BA.debugLineNum = 369;BA.debugLine="sql.ExecNonQuery2(\"UPDATE ingresos SET suma_ing";
Debug.ShouldStop(65536);
registraringreso._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE ingresos SET suma_ingresos = ? WHERE id_ingreso = 1")),(Object)(registraringreso.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {((RemoteObject.solve(new RemoteObject[] {registraringreso._ingresosactuales,_ingresoregistrar.getField(true,"monto" /*RemoteObject*/ )}, "+",1, 1)))})))));
 BA.debugLineNum = 372;BA.debugLine="ToastMessageShow(\"Ingreso registrado\",True)";
Debug.ShouldStop(524288);
registraringreso.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Ingreso registrado")),(Object)(registraringreso.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 374;BA.debugLine="Activity.Finish";
Debug.ShouldStop(2097152);
registraringreso.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 376;BA.debugLine="StartActivity(IngresosRecurrentes)";
Debug.ShouldStop(8388608);
registraringreso.mostCurrent.__c.runVoidMethod ("StartActivity",registraringreso.processBA,(Object)((registraringreso.mostCurrent._ingresosrecurrentes.getObject())));
 }else 
{ BA.debugLineNum = 378;BA.debugLine="Else If(tipoIngreso = \"Unico\") Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",registraringreso.mostCurrent._tipoingreso,RemoteObject.createImmutable("Unico")))) { 
 BA.debugLineNum = 379;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO ingresos_unicos";
Debug.ShouldStop(67108864);
registraringreso._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO ingresos_unicos (monto, nombre, descripcion, fecha_registro, color) VALUES (?, ?, ?, ?, ?)")),(Object)(registraringreso.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {(_ingresoregistrar.getField(true,"monto" /*RemoteObject*/ )),(_ingresoregistrar.getField(true,"nombre" /*RemoteObject*/ )),(_ingresoregistrar.getField(true,"descripcion" /*RemoteObject*/ )),(_ingresoregistrar.getField(true,"fechaCobro" /*RemoteObject*/ )),(_ingresoregistrar.getField(true,"color" /*RemoteObject*/ ))})))));
 BA.debugLineNum = 383;BA.debugLine="cur = sql.ExecQuery(\"SELECT suma_ingresos FROM";
Debug.ShouldStop(1073741824);
registraringreso.mostCurrent._cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), registraringreso._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT suma_ingresos FROM ingresos"))));
 BA.debugLineNum = 384;BA.debugLine="cur.Position = 0";
Debug.ShouldStop(-2147483648);
registraringreso.mostCurrent._cur.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 385;BA.debugLine="ingresosActuales = cur.GetInt(\"suma_ingresos\")";
Debug.ShouldStop(1);
registraringreso._ingresosactuales = registraringreso.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("suma_ingresos")));
 BA.debugLineNum = 387;BA.debugLine="sql.ExecNonQuery2(\"UPDATE ingresos SET suma_ing";
Debug.ShouldStop(4);
registraringreso._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE ingresos SET suma_ingresos = ? WHERE id_ingreso = 1")),(Object)(registraringreso.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {((RemoteObject.solve(new RemoteObject[] {registraringreso._ingresosactuales,_ingresoregistrar.getField(true,"monto" /*RemoteObject*/ )}, "+",1, 1)))})))));
 BA.debugLineNum = 389;BA.debugLine="ToastMessageShow(\"Ingreso registrado\",True)";
Debug.ShouldStop(16);
registraringreso.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Ingreso registrado")),(Object)(registraringreso.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 391;BA.debugLine="Activity.Finish";
Debug.ShouldStop(64);
registraringreso.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 393;BA.debugLine="StartActivity(IngresosUnicos)";
Debug.ShouldStop(256);
registraringreso.mostCurrent.__c.runVoidMethod ("StartActivity",registraringreso.processBA,(Object)((registraringreso.mostCurrent._ingresosunicos.getObject())));
 }}
;
 }else {
 BA.debugLineNum = 397;BA.debugLine="Msgbox2(\"Por favor, rellene todos los campos, se";
Debug.ShouldStop(4096);
registraringreso.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("Por favor, rellene todos los campos, seleccione un periodo y color")),(Object)(BA.ObjectToCharSequence("Registro incorrecto")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((registraringreso.mostCurrent.__c.getField(false,"Null"))),registraringreso.mostCurrent.activityBA);
 };
 BA.debugLineNum = 399;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnrecurrente_click() throws Exception{
try {
		Debug.PushSubsStack("btnRecurrente_Click (registraringreso) ","registraringreso",15,registraringreso.mostCurrent.activityBA,registraringreso.mostCurrent,189);
if (RapidSub.canDelegate("btnrecurrente_click")) { return pullup.wallet.registraringreso.remoteMe.runUserSub(false, "registraringreso","btnrecurrente_click");}
 BA.debugLineNum = 189;BA.debugLine="Private Sub btnRecurrente_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 190;BA.debugLine="tipoIngreso = \"Recurrente\"";
Debug.ShouldStop(536870912);
registraringreso.mostCurrent._tipoingreso = BA.ObjectToString("Recurrente");
 BA.debugLineNum = 191;BA.debugLine="Log(tipoIngreso)";
Debug.ShouldStop(1073741824);
registraringreso.mostCurrent.__c.runVoidMethod ("LogImpl","514024706",registraringreso.mostCurrent._tipoingreso,0);
 BA.debugLineNum = 192;BA.debugLine="rd1Semana.Enabled = True";
Debug.ShouldStop(-2147483648);
registraringreso.mostCurrent._rd1semana.runMethod(true,"setEnabled",registraringreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 193;BA.debugLine="rd2Semanas.Enabled = True";
Debug.ShouldStop(1);
registraringreso.mostCurrent._rd2semanas.runMethod(true,"setEnabled",registraringreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 194;BA.debugLine="rd3Semanas.Enabled = True";
Debug.ShouldStop(2);
registraringreso.mostCurrent._rd3semanas.runMethod(true,"setEnabled",registraringreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 195;BA.debugLine="rd1Mes.Enabled = True";
Debug.ShouldStop(4);
registraringreso.mostCurrent._rd1mes.runMethod(true,"setEnabled",registraringreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 196;BA.debugLine="rd1Ano.Enabled = True";
Debug.ShouldStop(8);
registraringreso.mostCurrent._rd1ano.runMethod(true,"setEnabled",registraringreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 197;BA.debugLine="btnRecurrente.TextColor = Colors.White";
Debug.ShouldStop(16);
registraringreso.mostCurrent._btnrecurrente.runMethod(true,"setTextColor",registraringreso.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 198;BA.debugLine="btnUnico.TextColor = Colors.Black";
Debug.ShouldStop(32);
registraringreso.mostCurrent._btnunico.runMethod(true,"setTextColor",registraringreso.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 199;BA.debugLine="esquinas.Initialize(Colors.RGB(121,80,242), 20)";
Debug.ShouldStop(64);
registraringreso.mostCurrent._esquinas.runVoidMethod ("Initialize",(Object)(registraringreso.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 121)),(Object)(BA.numberCast(int.class, 80)),(Object)(BA.numberCast(int.class, 242)))),(Object)(BA.numberCast(int.class, 20)));
 BA.debugLineNum = 200;BA.debugLine="esquinas2.Initialize(Colors.RGB(237,237,237), 20)";
Debug.ShouldStop(128);
registraringreso.mostCurrent._esquinas2.runVoidMethod ("Initialize",(Object)(registraringreso.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 237)),(Object)(BA.numberCast(int.class, 237)),(Object)(BA.numberCast(int.class, 237)))),(Object)(BA.numberCast(int.class, 20)));
 BA.debugLineNum = 201;BA.debugLine="btnRecurrente.Background = esquinas";
Debug.ShouldStop(256);
registraringreso.mostCurrent._btnrecurrente.runMethod(false,"setBackground",(registraringreso.mostCurrent._esquinas.getObject()));
 BA.debugLineNum = 202;BA.debugLine="btnUnico.Background = esquinas2";
Debug.ShouldStop(512);
registraringreso.mostCurrent._btnunico.runMethod(false,"setBackground",(registraringreso.mostCurrent._esquinas2.getObject()));
 BA.debugLineNum = 203;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnunico_click() throws Exception{
try {
		Debug.PushSubsStack("btnUnico_Click (registraringreso) ","registraringreso",15,registraringreso.mostCurrent.activityBA,registraringreso.mostCurrent,208);
if (RapidSub.canDelegate("btnunico_click")) { return pullup.wallet.registraringreso.remoteMe.runUserSub(false, "registraringreso","btnunico_click");}
 BA.debugLineNum = 208;BA.debugLine="Private Sub btnUnico_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 209;BA.debugLine="tipoIngreso = \"Unico\"";
Debug.ShouldStop(65536);
registraringreso.mostCurrent._tipoingreso = BA.ObjectToString("Unico");
 BA.debugLineNum = 210;BA.debugLine="Log(tipoIngreso)";
Debug.ShouldStop(131072);
registraringreso.mostCurrent.__c.runVoidMethod ("LogImpl","514090242",registraringreso.mostCurrent._tipoingreso,0);
 BA.debugLineNum = 211;BA.debugLine="rd1Semana.Enabled = False";
Debug.ShouldStop(262144);
registraringreso.mostCurrent._rd1semana.runMethod(true,"setEnabled",registraringreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 212;BA.debugLine="rd2Semanas.Enabled = False";
Debug.ShouldStop(524288);
registraringreso.mostCurrent._rd2semanas.runMethod(true,"setEnabled",registraringreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 213;BA.debugLine="rd3Semanas.Enabled = False";
Debug.ShouldStop(1048576);
registraringreso.mostCurrent._rd3semanas.runMethod(true,"setEnabled",registraringreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 214;BA.debugLine="rd1Mes.Enabled = False";
Debug.ShouldStop(2097152);
registraringreso.mostCurrent._rd1mes.runMethod(true,"setEnabled",registraringreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 215;BA.debugLine="rd1Ano.Enabled = False";
Debug.ShouldStop(4194304);
registraringreso.mostCurrent._rd1ano.runMethod(true,"setEnabled",registraringreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 216;BA.debugLine="btnRecurrente.TextColor = Colors.Black";
Debug.ShouldStop(8388608);
registraringreso.mostCurrent._btnrecurrente.runMethod(true,"setTextColor",registraringreso.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 217;BA.debugLine="btnUnico.TextColor = Colors.White";
Debug.ShouldStop(16777216);
registraringreso.mostCurrent._btnunico.runMethod(true,"setTextColor",registraringreso.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 218;BA.debugLine="esquinas.Initialize(Colors.RGB(237,237,237), 20)";
Debug.ShouldStop(33554432);
registraringreso.mostCurrent._esquinas.runVoidMethod ("Initialize",(Object)(registraringreso.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 237)),(Object)(BA.numberCast(int.class, 237)),(Object)(BA.numberCast(int.class, 237)))),(Object)(BA.numberCast(int.class, 20)));
 BA.debugLineNum = 219;BA.debugLine="esquinas2.Initialize(Colors.RGB(121,80,242), 20)";
Debug.ShouldStop(67108864);
registraringreso.mostCurrent._esquinas2.runVoidMethod ("Initialize",(Object)(registraringreso.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 121)),(Object)(BA.numberCast(int.class, 80)),(Object)(BA.numberCast(int.class, 242)))),(Object)(BA.numberCast(int.class, 20)));
 BA.debugLineNum = 220;BA.debugLine="btnRecurrente.Background = esquinas";
Debug.ShouldStop(134217728);
registraringreso.mostCurrent._btnrecurrente.runMethod(false,"setBackground",(registraringreso.mostCurrent._esquinas.getObject()));
 BA.debugLineNum = 221;BA.debugLine="btnUnico.Background = esquinas2";
Debug.ShouldStop(268435456);
registraringreso.mostCurrent._btnunico.runMethod(false,"setBackground",(registraringreso.mostCurrent._esquinas2.getObject()));
 BA.debugLineNum = 222;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("cpBarraColor_ColorChanged (registraringreso) ","registraringreso",15,registraringreso.mostCurrent.activityBA,registraringreso.mostCurrent,241);
if (RapidSub.canDelegate("cpbarracolor_colorchanged")) { return pullup.wallet.registraringreso.remoteMe.runUserSub(false, "registraringreso","cpbarracolor_colorchanged", _color);}
Debug.locals.put("color", _color);
 BA.debugLineNum = 241;BA.debugLine="Private Sub cpBarraColor_ColorChanged(color As Int";
Debug.ShouldStop(65536);
 BA.debugLineNum = 242;BA.debugLine="lblFondoMonto.Color = color";
Debug.ShouldStop(131072);
registraringreso.mostCurrent._lblfondomonto.runVoidMethod ("setColor",_color);
 BA.debugLineNum = 243;BA.debugLine="colorCaja = color";
Debug.ShouldStop(262144);
registraringreso._colorcaja = _color;
 BA.debugLineNum = 244;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fechamasperiodo(RemoteObject _periodo) throws Exception{
try {
		Debug.PushSubsStack("fechaMasPeriodo (registraringreso) ","registraringreso",15,registraringreso.mostCurrent.activityBA,registraringreso.mostCurrent,257);
if (RapidSub.canDelegate("fechamasperiodo")) { return pullup.wallet.registraringreso.remoteMe.runUserSub(false, "registraringreso","fechamasperiodo", _periodo);}
RemoteObject _fechaactual = RemoteObject.createImmutable("");
RemoteObject _fechaproxima = RemoteObject.createImmutable(0L);
Debug.locals.put("periodo", _periodo);
 BA.debugLineNum = 257;BA.debugLine="Sub fechaMasPeriodo(periodo As Int) As String";
Debug.ShouldStop(1);
 BA.debugLineNum = 258;BA.debugLine="Dim fechaActual As String";
Debug.ShouldStop(2);
_fechaactual = RemoteObject.createImmutable("");Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 259;BA.debugLine="Dim fechaProxima As Long";
Debug.ShouldStop(4);
_fechaproxima = RemoteObject.createImmutable(0L);Debug.locals.put("fechaProxima", _fechaproxima);
 BA.debugLineNum = 261;BA.debugLine="fechaActual = DateTime.Date(obtenerFechaActual)";
Debug.ShouldStop(16);
_fechaactual = registraringreso.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(_obtenerfechaactual()));Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 262;BA.debugLine="fechaProxima = DateTime.DateParse(fechaActual)";
Debug.ShouldStop(32);
_fechaproxima = registraringreso.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateParse",(Object)(_fechaactual));Debug.locals.put("fechaProxima", _fechaproxima);
 BA.debugLineNum = 263;BA.debugLine="fechaProxima = DateTime.Add(fechaProxima, 0, 0, p";
Debug.ShouldStop(64);
_fechaproxima = registraringreso.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Add",(Object)(_fechaproxima),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_periodo));Debug.locals.put("fechaProxima", _fechaproxima);
 BA.debugLineNum = 265;BA.debugLine="Return DateTime.Date(fechaProxima)";
Debug.ShouldStop(256);
if (true) return registraringreso.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(_fechaproxima));
 BA.debugLineNum = 266;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
registraringreso._alturadispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 15;BA.debugLine="Dim anchoDispositivo As Int";
registraringreso._anchodispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 16;BA.debugLine="Dim tipoIngreso As String";
registraringreso.mostCurrent._tipoingreso = RemoteObject.createImmutable("");
 //BA.debugLineNum = 17;BA.debugLine="Dim colorCaja As Int";
registraringreso._colorcaja = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 18;BA.debugLine="Dim diasPeriodo As Int";
registraringreso._diasperiodo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 19;BA.debugLine="Dim aparicionMsgBox1 As Boolean";
registraringreso._aparicionmsgbox1 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 20;BA.debugLine="Dim aparicionMsgBox2 As Boolean";
registraringreso._aparicionmsgbox2 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 21;BA.debugLine="Dim aparicionMsgBox3 As Boolean";
registraringreso._aparicionmsgbox3 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 22;BA.debugLine="Dim esquinas As ColorDrawable";
registraringreso.mostCurrent._esquinas = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");
 //BA.debugLineNum = 23;BA.debugLine="Dim esquinas2 As ColorDrawable";
registraringreso.mostCurrent._esquinas2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");
 //BA.debugLineNum = 24;BA.debugLine="Dim cur As Cursor";
registraringreso.mostCurrent._cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Dim ingresosActuales As Int";
registraringreso._ingresosactuales = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 29;BA.debugLine="Private btnMenu As Button";
registraringreso.mostCurrent._btnmenu = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private btnOperacionIngreso As Button";
registraringreso.mostCurrent._btnoperacioningreso = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private btnRecurrente As Button";
registraringreso.mostCurrent._btnrecurrente = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private btnUnico As Button";
registraringreso.mostCurrent._btnunico = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private txtDescripcion As EditText";
registraringreso.mostCurrent._txtdescripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private txtMonto As EditText";
registraringreso.mostCurrent._txtmonto = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private txtNombre As EditText";
registraringreso.mostCurrent._txtnombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private lblContornoBoton As Label";
registraringreso.mostCurrent._lblcontornoboton = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private lblFondoDescripcion As Label";
registraringreso.mostCurrent._lblfondodescripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private lblFondoMonto As Label";
registraringreso.mostCurrent._lblfondomonto = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private lblFondoNombre As Label";
registraringreso.mostCurrent._lblfondonombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private lblNombreVista As Label";
registraringreso.mostCurrent._lblnombrevista = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private rd1Ano As RadioButton";
registraringreso.mostCurrent._rd1ano = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private rd1Mes As RadioButton";
registraringreso.mostCurrent._rd1mes = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private rd1Semana As RadioButton";
registraringreso.mostCurrent._rd1semana = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private rd2Semanas As RadioButton";
registraringreso.mostCurrent._rd2semanas = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private rd3Semanas As RadioButton";
registraringreso.mostCurrent._rd3semanas = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private pnlPeriodos As Panel";
registraringreso.mostCurrent._pnlperiodos = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private pnlSelector As Panel";
registraringreso.mostCurrent._pnlselector = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private pnlNavInferior As Panel";
registraringreso.mostCurrent._pnlnavinferior = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private cpBarraColor As ASColorSlider";
registraringreso.mostCurrent._cpbarracolor = RemoteObject.createNew ("pullup.wallet.ascolorslider");
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _limitarlongitudentrada(RemoteObject _antiguo,RemoteObject _nuevo,RemoteObject _longitud,RemoteObject _view,RemoteObject _campo) throws Exception{
try {
		Debug.PushSubsStack("limitarLongitudEntrada (registraringreso) ","registraringreso",15,registraringreso.mostCurrent.activityBA,registraringreso.mostCurrent,270);
if (RapidSub.canDelegate("limitarlongitudentrada")) { return pullup.wallet.registraringreso.remoteMe.runUserSub(false, "registraringreso","limitarlongitudentrada", _antiguo, _nuevo, _longitud, _view, _campo);}
Debug.locals.put("antiguo", _antiguo);
Debug.locals.put("nuevo", _nuevo);
Debug.locals.put("longitud", _longitud);
Debug.locals.put("view", _view);
Debug.locals.put("campo", _campo);
 BA.debugLineNum = 270;BA.debugLine="Sub limitarLongitudEntrada(antiguo As String, nuev";
Debug.ShouldStop(8192);
 BA.debugLineNum = 271;BA.debugLine="If(nuevo.Length > longitud) Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean(">",_nuevo.runMethod(true,"length"),BA.numberCast(double.class, _longitud)))) { 
 BA.debugLineNum = 272;BA.debugLine="If(campo = \"monto\") Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("monto")))) { 
 BA.debugLineNum = 273;BA.debugLine="If(aparicionMsgBox1 = False) Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("=",registraringreso._aparicionmsgbox1,registraringreso.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 274;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
Debug.ShouldStop(131072);
registraringreso.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para el monto es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((registraringreso.mostCurrent.__c.getField(false,"Null"))),registraringreso.mostCurrent.activityBA);
 BA.debugLineNum = 275;BA.debugLine="aparicionMsgBox1 = True";
Debug.ShouldStop(262144);
registraringreso._aparicionmsgbox1 = registraringreso.mostCurrent.__c.getField(true,"True");
 };
 }else 
{ BA.debugLineNum = 277;BA.debugLine="Else If(campo = \"nombre\") Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("nombre")))) { 
 BA.debugLineNum = 278;BA.debugLine="If(aparicionMsgBox2 = False) Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",registraringreso._aparicionmsgbox2,registraringreso.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 279;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
Debug.ShouldStop(4194304);
registraringreso.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para el nombre es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((registraringreso.mostCurrent.__c.getField(false,"Null"))),registraringreso.mostCurrent.activityBA);
 BA.debugLineNum = 280;BA.debugLine="aparicionMsgBox2 = True";
Debug.ShouldStop(8388608);
registraringreso._aparicionmsgbox2 = registraringreso.mostCurrent.__c.getField(true,"True");
 };
 }else 
{ BA.debugLineNum = 282;BA.debugLine="Else If(campo = \"descripcion\") Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("descripcion")))) { 
 BA.debugLineNum = 283;BA.debugLine="If(aparicionMsgBox3 = False) Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",registraringreso._aparicionmsgbox3,registraringreso.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 284;BA.debugLine="Msgbox2(\"La longitud máxima permitida para la";
Debug.ShouldStop(134217728);
registraringreso.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para la descripción es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((registraringreso.mostCurrent.__c.getField(false,"Null"))),registraringreso.mostCurrent.activityBA);
 BA.debugLineNum = 285;BA.debugLine="aparicionMsgBox3 = True";
Debug.ShouldStop(268435456);
registraringreso._aparicionmsgbox3 = registraringreso.mostCurrent.__c.getField(true,"True");
 };
 }}}
;
 BA.debugLineNum = 288;BA.debugLine="view.Text = antiguo";
Debug.ShouldStop(-2147483648);
_view.runMethod(true,"setText",BA.ObjectToCharSequence(_antiguo));
 };
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
public static RemoteObject  _obtenerfechaactual() throws Exception{
try {
		Debug.PushSubsStack("obtenerFechaActual (registraringreso) ","registraringreso",15,registraringreso.mostCurrent.activityBA,registraringreso.mostCurrent,247);
if (RapidSub.canDelegate("obtenerfechaactual")) { return pullup.wallet.registraringreso.remoteMe.runUserSub(false, "registraringreso","obtenerfechaactual");}
RemoteObject _ahora = RemoteObject.createImmutable(0L);
 BA.debugLineNum = 247;BA.debugLine="Sub obtenerFechaActual As Long";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 248;BA.debugLine="Dim ahora As Long";
Debug.ShouldStop(8388608);
_ahora = RemoteObject.createImmutable(0L);Debug.locals.put("ahora", _ahora);
 BA.debugLineNum = 249;BA.debugLine="ahora = DateTime.Now";
Debug.ShouldStop(16777216);
_ahora = registraringreso.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow");Debug.locals.put("ahora", _ahora);
 BA.debugLineNum = 250;BA.debugLine="Return ahora";
Debug.ShouldStop(33554432);
if (true) return _ahora;
 BA.debugLineNum = 252;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable(0L);
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
registraringreso._sql = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _rd1ano_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("rd1Ano_CheckedChange (registraringreso) ","registraringreso",15,registraringreso.mostCurrent.activityBA,registraringreso.mostCurrent,322);
if (RapidSub.canDelegate("rd1ano_checkedchange")) { return pullup.wallet.registraringreso.remoteMe.runUserSub(false, "registraringreso","rd1ano_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 322;BA.debugLine="Private Sub rd1Ano_CheckedChange(Checked As Boolea";
Debug.ShouldStop(2);
 BA.debugLineNum = 323;BA.debugLine="diasPeriodo = 365";
Debug.ShouldStop(4);
registraringreso._diasperiodo = BA.numberCast(int.class, 365);
 BA.debugLineNum = 324;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("rd1Mes_CheckedChange (registraringreso) ","registraringreso",15,registraringreso.mostCurrent.activityBA,registraringreso.mostCurrent,318);
if (RapidSub.canDelegate("rd1mes_checkedchange")) { return pullup.wallet.registraringreso.remoteMe.runUserSub(false, "registraringreso","rd1mes_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 318;BA.debugLine="Private Sub rd1Mes_CheckedChange(Checked As Boolea";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 319;BA.debugLine="diasPeriodo = 30";
Debug.ShouldStop(1073741824);
registraringreso._diasperiodo = BA.numberCast(int.class, 30);
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
public static RemoteObject  _rd1semana_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("rd1Semana_CheckedChange (registraringreso) ","registraringreso",15,registraringreso.mostCurrent.activityBA,registraringreso.mostCurrent,314);
if (RapidSub.canDelegate("rd1semana_checkedchange")) { return pullup.wallet.registraringreso.remoteMe.runUserSub(false, "registraringreso","rd1semana_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 314;BA.debugLine="Private Sub rd1Semana_CheckedChange(Checked As Boo";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 315;BA.debugLine="diasPeriodo = 7";
Debug.ShouldStop(67108864);
registraringreso._diasperiodo = BA.numberCast(int.class, 7);
 BA.debugLineNum = 316;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("rd2Semanas_CheckedChange (registraringreso) ","registraringreso",15,registraringreso.mostCurrent.activityBA,registraringreso.mostCurrent,310);
if (RapidSub.canDelegate("rd2semanas_checkedchange")) { return pullup.wallet.registraringreso.remoteMe.runUserSub(false, "registraringreso","rd2semanas_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 310;BA.debugLine="Private Sub rd2Semanas_CheckedChange(Checked As Bo";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 311;BA.debugLine="diasPeriodo = 14";
Debug.ShouldStop(4194304);
registraringreso._diasperiodo = BA.numberCast(int.class, 14);
 BA.debugLineNum = 312;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("rd3Semanas_CheckedChange (registraringreso) ","registraringreso",15,registraringreso.mostCurrent.activityBA,registraringreso.mostCurrent,306);
if (RapidSub.canDelegate("rd3semanas_checkedchange")) { return pullup.wallet.registraringreso.remoteMe.runUserSub(false, "registraringreso","rd3semanas_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 306;BA.debugLine="Private Sub rd3Semanas_CheckedChange(Checked As Bo";
Debug.ShouldStop(131072);
 BA.debugLineNum = 307;BA.debugLine="diasPeriodo = 21";
Debug.ShouldStop(262144);
registraringreso._diasperiodo = BA.numberCast(int.class, 21);
 BA.debugLineNum = 308;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("txtDescripcion_TextChanged (registraringreso) ","registraringreso",15,registraringreso.mostCurrent.activityBA,registraringreso.mostCurrent,301);
if (RapidSub.canDelegate("txtdescripcion_textchanged")) { return pullup.wallet.registraringreso.remoteMe.runUserSub(false, "registraringreso","txtdescripcion_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 301;BA.debugLine="Private Sub txtDescripcion_TextChanged (Old As Str";
Debug.ShouldStop(4096);
 BA.debugLineNum = 302;BA.debugLine="limitarLongitudEntrada(Old, New, 41, txtDescripci";
Debug.ShouldStop(8192);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 41),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), registraringreso.mostCurrent._txtdescripcion.getObject()),RemoteObject.createImmutable("descripcion"));
 BA.debugLineNum = 303;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("txtMonto_TextChanged (registraringreso) ","registraringreso",15,registraringreso.mostCurrent.activityBA,registraringreso.mostCurrent,293);
if (RapidSub.canDelegate("txtmonto_textchanged")) { return pullup.wallet.registraringreso.remoteMe.runUserSub(false, "registraringreso","txtmonto_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 293;BA.debugLine="Private Sub txtMonto_TextChanged (Old As String, N";
Debug.ShouldStop(16);
 BA.debugLineNum = 294;BA.debugLine="limitarLongitudEntrada(Old, New, 9, txtMonto, \"mo";
Debug.ShouldStop(32);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 9),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), registraringreso.mostCurrent._txtmonto.getObject()),RemoteObject.createImmutable("monto"));
 BA.debugLineNum = 295;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("txtNombre_TextChanged (registraringreso) ","registraringreso",15,registraringreso.mostCurrent.activityBA,registraringreso.mostCurrent,297);
if (RapidSub.canDelegate("txtnombre_textchanged")) { return pullup.wallet.registraringreso.remoteMe.runUserSub(false, "registraringreso","txtnombre_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 297;BA.debugLine="Private Sub txtNombre_TextChanged (Old As String,";
Debug.ShouldStop(256);
 BA.debugLineNum = 298;BA.debugLine="limitarLongitudEntrada(Old, New, 16, txtNombre, \"";
Debug.ShouldStop(512);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 16),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), registraringreso.mostCurrent._txtnombre.getObject()),RemoteObject.createImmutable("nombre"));
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
public static RemoteObject  _validarcampos() throws Exception{
try {
		Debug.PushSubsStack("validarCampos (registraringreso) ","registraringreso",15,registraringreso.mostCurrent.activityBA,registraringreso.mostCurrent,225);
if (RapidSub.canDelegate("validarcampos")) { return pullup.wallet.registraringreso.remoteMe.runUserSub(false, "registraringreso","validarcampos");}
 BA.debugLineNum = 225;BA.debugLine="Sub validarCampos As Boolean";
Debug.ShouldStop(1);
 BA.debugLineNum = 226;BA.debugLine="If(txtMonto.Text.Length <> 0 And txtNombre.Text.L";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("!",registraringreso.mostCurrent._txtmonto.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",registraringreso.mostCurrent._txtnombre.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",registraringreso.mostCurrent._txtdescripcion.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",registraringreso._colorcaja,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 227;BA.debugLine="If(tipoIngreso = \"Recurrente\" And diasPeriodo <>";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",registraringreso.mostCurrent._tipoingreso,BA.ObjectToString("Recurrente")) && RemoteObject.solveBoolean("!",registraringreso._diasperiodo,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 228;BA.debugLine="Return True";
Debug.ShouldStop(8);
if (true) return registraringreso.mostCurrent.__c.getField(true,"True");
 }else 
{ BA.debugLineNum = 229;BA.debugLine="Else If(tipoIngreso = \"Unico\") Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",registraringreso.mostCurrent._tipoingreso,RemoteObject.createImmutable("Unico")))) { 
 BA.debugLineNum = 230;BA.debugLine="Return True";
Debug.ShouldStop(32);
if (true) return registraringreso.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 232;BA.debugLine="Return False";
Debug.ShouldStop(128);
if (true) return registraringreso.mostCurrent.__c.getField(true,"False");
 }}
;
 }else {
 BA.debugLineNum = 235;BA.debugLine="Return False";
Debug.ShouldStop(1024);
if (true) return registraringreso.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 237;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}