package pullup.wallet;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class registrarsuscripcion_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (registrarsuscripcion) ","registrarsuscripcion",17,registrarsuscripcion.mostCurrent.activityBA,registrarsuscripcion.mostCurrent,52);
if (RapidSub.canDelegate("activity_create")) { return pullup.wallet.registrarsuscripcion.remoteMe.runUserSub(false, "registrarsuscripcion","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 52;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 53;BA.debugLine="Activity.LoadLayout(\"LFormSuscripcion\")";
Debug.ShouldStop(1048576);
registrarsuscripcion.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("LFormSuscripcion")),registrarsuscripcion.mostCurrent.activityBA);
 BA.debugLineNum = 54;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
Debug.ShouldStop(2097152);
registrarsuscripcion._alturadispositivo = registrarsuscripcion.mostCurrent._main._alturadispositivo /*RemoteObject*/ ;
 BA.debugLineNum = 55;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
Debug.ShouldStop(4194304);
registrarsuscripcion._anchodispositivo = registrarsuscripcion.mostCurrent._main._anchodispositivo /*RemoteObject*/ ;
 BA.debugLineNum = 56;BA.debugLine="sql = Starter.sql";
Debug.ShouldStop(8388608);
registrarsuscripcion._sql = registrarsuscripcion.mostCurrent._starter._sql /*RemoteObject*/ ;
 BA.debugLineNum = 57;BA.debugLine="aparicionMsgBox1 = False";
Debug.ShouldStop(16777216);
registrarsuscripcion._aparicionmsgbox1 = registrarsuscripcion.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 58;BA.debugLine="aparicionMsgBox2 = False";
Debug.ShouldStop(33554432);
registrarsuscripcion._aparicionmsgbox2 = registrarsuscripcion.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 59;BA.debugLine="aparicionMsgBox3 = False";
Debug.ShouldStop(67108864);
registrarsuscripcion._aparicionmsgbox3 = registrarsuscripcion.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 60;BA.debugLine="diasPeriodo = 7";
Debug.ShouldStop(134217728);
registrarsuscripcion._diasperiodo = BA.numberCast(int.class, 7);
 BA.debugLineNum = 61;BA.debugLine="colorCaja = 0";
Debug.ShouldStop(268435456);
registrarsuscripcion._colorcaja = BA.numberCast(int.class, 0);
 BA.debugLineNum = 64;BA.debugLine="lblNombreVista.TextSize = 20";
Debug.ShouldStop(-2147483648);
registrarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 65;BA.debugLine="lblNombreVista.TextColor = Colors.Black";
Debug.ShouldStop(1);
registrarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"setTextColor",registrarsuscripcion.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 66;BA.debugLine="lblNombreVista.Height = 30dip";
Debug.ShouldStop(2);
registrarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"setHeight",registrarsuscripcion.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 67;BA.debugLine="lblNombreVista.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(4);
registrarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarsuscripcion._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 68;BA.debugLine="lblNombreVista.Top = 30dip";
Debug.ShouldStop(8);
registrarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"setTop",registrarsuscripcion.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 69;BA.debugLine="lblNombreVista.Left = (anchoDispositivo - lblNomb";
Debug.ShouldStop(16);
registrarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registrarsuscripcion._anchodispositivo,registrarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 71;BA.debugLine="txtMonto.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(64);
registrarsuscripcion.mostCurrent._txtmonto.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarsuscripcion._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 72;BA.debugLine="txtMonto.Height = alturaDispositivo * 0.22";
Debug.ShouldStop(128);
registrarsuscripcion.mostCurrent._txtmonto.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarsuscripcion._alturadispositivo,RemoteObject.createImmutable(0.22)}, "*",0, 0)));
 BA.debugLineNum = 73;BA.debugLine="txtMonto.Top = lblNombreVista.Top * 2 + lblNombre";
Debug.ShouldStop(256);
registrarsuscripcion.mostCurrent._txtmonto.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {registrarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2),registrarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"getHeight")}, "*+",1, 1));
 BA.debugLineNum = 74;BA.debugLine="txtMonto.Left = (anchoDispositivo - txtMonto.Widt";
Debug.ShouldStop(512);
registrarsuscripcion.mostCurrent._txtmonto.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registrarsuscripcion._anchodispositivo,registrarsuscripcion.mostCurrent._txtmonto.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 75;BA.debugLine="lblFondoMonto.Width = txtMonto.Width";
Debug.ShouldStop(1024);
registrarsuscripcion.mostCurrent._lblfondomonto.runMethod(true,"setWidth",registrarsuscripcion.mostCurrent._txtmonto.runMethod(true,"getWidth"));
 BA.debugLineNum = 76;BA.debugLine="lblFondoMonto.Height = txtMonto.Height";
Debug.ShouldStop(2048);
registrarsuscripcion.mostCurrent._lblfondomonto.runMethod(true,"setHeight",registrarsuscripcion.mostCurrent._txtmonto.runMethod(true,"getHeight"));
 BA.debugLineNum = 77;BA.debugLine="lblFondoMonto.Top = txtMonto.Top";
Debug.ShouldStop(4096);
registrarsuscripcion.mostCurrent._lblfondomonto.runMethod(true,"setTop",registrarsuscripcion.mostCurrent._txtmonto.runMethod(true,"getTop"));
 BA.debugLineNum = 78;BA.debugLine="lblFondoMonto.Left = txtMonto.Left";
Debug.ShouldStop(8192);
registrarsuscripcion.mostCurrent._lblfondomonto.runMethod(true,"setLeft",registrarsuscripcion.mostCurrent._txtmonto.runMethod(true,"getLeft"));
 BA.debugLineNum = 80;BA.debugLine="txtNombre.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(32768);
registrarsuscripcion.mostCurrent._txtnombre.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarsuscripcion._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 81;BA.debugLine="txtNombre.Height = alturaDispositivo * 0.07";
Debug.ShouldStop(65536);
registrarsuscripcion.mostCurrent._txtnombre.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarsuscripcion._alturadispositivo,RemoteObject.createImmutable(0.07)}, "*",0, 0)));
 BA.debugLineNum = 82;BA.debugLine="txtNombre.Top = txtMonto.Top + txtMonto.Height +";
Debug.ShouldStop(131072);
registrarsuscripcion.mostCurrent._txtnombre.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarsuscripcion.mostCurrent._txtmonto.runMethod(true,"getTop"),registrarsuscripcion.mostCurrent._txtmonto.runMethod(true,"getHeight"),registrarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 83;BA.debugLine="txtNombre.Left = (anchoDispositivo - txtNombre.Wi";
Debug.ShouldStop(262144);
registrarsuscripcion.mostCurrent._txtnombre.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registrarsuscripcion._anchodispositivo,registrarsuscripcion.mostCurrent._txtnombre.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 84;BA.debugLine="lblFondoNombre.Width = txtMonto.Width";
Debug.ShouldStop(524288);
registrarsuscripcion.mostCurrent._lblfondonombre.runMethod(true,"setWidth",registrarsuscripcion.mostCurrent._txtmonto.runMethod(true,"getWidth"));
 BA.debugLineNum = 85;BA.debugLine="lblFondoNombre.Height = txtNombre.Height";
Debug.ShouldStop(1048576);
registrarsuscripcion.mostCurrent._lblfondonombre.runMethod(true,"setHeight",registrarsuscripcion.mostCurrent._txtnombre.runMethod(true,"getHeight"));
 BA.debugLineNum = 86;BA.debugLine="lblFondoNombre.Top = txtNombre.Top";
Debug.ShouldStop(2097152);
registrarsuscripcion.mostCurrent._lblfondonombre.runMethod(true,"setTop",registrarsuscripcion.mostCurrent._txtnombre.runMethod(true,"getTop"));
 BA.debugLineNum = 87;BA.debugLine="lblFondoNombre.Left = txtNombre.Left";
Debug.ShouldStop(4194304);
registrarsuscripcion.mostCurrent._lblfondonombre.runMethod(true,"setLeft",registrarsuscripcion.mostCurrent._txtnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 89;BA.debugLine="txtDescripcion.Width = txtNombre.Width";
Debug.ShouldStop(16777216);
registrarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"setWidth",registrarsuscripcion.mostCurrent._txtnombre.runMethod(true,"getWidth"));
 BA.debugLineNum = 90;BA.debugLine="txtDescripcion.Height = txtNombre.Height";
Debug.ShouldStop(33554432);
registrarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"setHeight",registrarsuscripcion.mostCurrent._txtnombre.runMethod(true,"getHeight"));
 BA.debugLineNum = 91;BA.debugLine="txtDescripcion.Top = txtNombre.Top + txtNombre.He";
Debug.ShouldStop(67108864);
registrarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarsuscripcion.mostCurrent._txtnombre.runMethod(true,"getTop"),registrarsuscripcion.mostCurrent._txtnombre.runMethod(true,"getHeight"),registrarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 92;BA.debugLine="txtDescripcion.Left = txtNombre.Left";
Debug.ShouldStop(134217728);
registrarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"setLeft",registrarsuscripcion.mostCurrent._txtnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 93;BA.debugLine="lblFondoDescripcion.Width = txtDescripcion.Width";
Debug.ShouldStop(268435456);
registrarsuscripcion.mostCurrent._lblfondodescripcion.runMethod(true,"setWidth",registrarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getWidth"));
 BA.debugLineNum = 94;BA.debugLine="lblFondoDescripcion.Height = txtDescripcion.Heigh";
Debug.ShouldStop(536870912);
registrarsuscripcion.mostCurrent._lblfondodescripcion.runMethod(true,"setHeight",registrarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getHeight"));
 BA.debugLineNum = 95;BA.debugLine="lblFondoDescripcion.Top = txtDescripcion.Top";
Debug.ShouldStop(1073741824);
registrarsuscripcion.mostCurrent._lblfondodescripcion.runMethod(true,"setTop",registrarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getTop"));
 BA.debugLineNum = 96;BA.debugLine="lblFondoDescripcion.Left = txtDescripcion.Left";
Debug.ShouldStop(-2147483648);
registrarsuscripcion.mostCurrent._lblfondodescripcion.runMethod(true,"setLeft",registrarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getLeft"));
 BA.debugLineNum = 98;BA.debugLine="pnlSelector.Top = txtDescripcion.Top + txtDescrip";
Debug.ShouldStop(2);
registrarsuscripcion.mostCurrent._pnlselector.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getTop"),registrarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getHeight"),registrarsuscripcion.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 99;BA.debugLine="pnlSelector.Left = txtDescripcion.Left + txtDescr";
Debug.ShouldStop(4);
registrarsuscripcion.mostCurrent._pnlselector.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {registrarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getLeft"),registrarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getWidth"),registrarsuscripcion.mostCurrent._pnlselector.runMethod(true,"getWidth")}, "+-",2, 1));
 BA.debugLineNum = 101;BA.debugLine="pnlPeriodos.Top = pnlSelector.Top";
Debug.ShouldStop(16);
registrarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"setTop",registrarsuscripcion.mostCurrent._pnlselector.runMethod(true,"getTop"));
 BA.debugLineNum = 102;BA.debugLine="pnlPeriodos.Left = txtDescripcion.Left";
Debug.ShouldStop(32);
registrarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"setLeft",registrarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getLeft"));
 BA.debugLineNum = 103;BA.debugLine="pnlPeriodos.Width = (txtDescripcion.Width - pnlSe";
Debug.ShouldStop(64);
registrarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registrarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getWidth"),registrarsuscripcion.mostCurrent._pnlselector.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 104;BA.debugLine="pnlPeriodos.Height = pnlSelector.Height";
Debug.ShouldStop(128);
registrarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"setHeight",registrarsuscripcion.mostCurrent._pnlselector.runMethod(true,"getHeight"));
 BA.debugLineNum = 107;BA.debugLine="rd1Semana.Width = pnlPeriodos.Width";
Debug.ShouldStop(1024);
registrarsuscripcion.mostCurrent._rd1semana.runMethod(true,"setWidth",registrarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"getWidth"));
 BA.debugLineNum = 108;BA.debugLine="rd1Semana.Height = pnlPeriodos.Height * 0.18";
Debug.ShouldStop(2048);
registrarsuscripcion.mostCurrent._rd1semana.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.18)}, "*",0, 0)));
 BA.debugLineNum = 109;BA.debugLine="rd1Semana.Left = 0";
Debug.ShouldStop(4096);
registrarsuscripcion.mostCurrent._rd1semana.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 110;BA.debugLine="rd1Semana.Top = 0";
Debug.ShouldStop(8192);
registrarsuscripcion.mostCurrent._rd1semana.runMethod(true,"setTop",BA.numberCast(int.class, 0));
 BA.debugLineNum = 112;BA.debugLine="rd2Semanas.Width = rd1Semana.Width";
Debug.ShouldStop(32768);
registrarsuscripcion.mostCurrent._rd2semanas.runMethod(true,"setWidth",registrarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 113;BA.debugLine="rd2Semanas.Height = rd1Semana.Height";
Debug.ShouldStop(65536);
registrarsuscripcion.mostCurrent._rd2semanas.runMethod(true,"setHeight",registrarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 114;BA.debugLine="rd2Semanas.Left = rd1Semana.Left";
Debug.ShouldStop(131072);
registrarsuscripcion.mostCurrent._rd2semanas.runMethod(true,"setLeft",registrarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 115;BA.debugLine="rd2Semanas.Top = rd1Semana.Height + pnlPeriodos.H";
Debug.ShouldStop(262144);
registrarsuscripcion.mostCurrent._rd2semanas.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getHeight"),registrarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "+*",1, 0)));
 BA.debugLineNum = 117;BA.debugLine="rd3Semanas.Width = rd1Semana.Width";
Debug.ShouldStop(1048576);
registrarsuscripcion.mostCurrent._rd3semanas.runMethod(true,"setWidth",registrarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 118;BA.debugLine="rd3Semanas.Height = rd1Semana.Height";
Debug.ShouldStop(2097152);
registrarsuscripcion.mostCurrent._rd3semanas.runMethod(true,"setHeight",registrarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 119;BA.debugLine="rd3Semanas.Left = rd1Semana.Left";
Debug.ShouldStop(4194304);
registrarsuscripcion.mostCurrent._rd3semanas.runMethod(true,"setLeft",registrarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 120;BA.debugLine="rd3Semanas.Top = rd2Semanas.Top + rd2Semanas.Heig";
Debug.ShouldStop(8388608);
registrarsuscripcion.mostCurrent._rd3semanas.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarsuscripcion.mostCurrent._rd2semanas.runMethod(true,"getTop"),registrarsuscripcion.mostCurrent._rd2semanas.runMethod(true,"getHeight"),registrarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "++*",2, 0)));
 BA.debugLineNum = 122;BA.debugLine="rd1Mes.Width = rd1Semana.Width";
Debug.ShouldStop(33554432);
registrarsuscripcion.mostCurrent._rd1mes.runMethod(true,"setWidth",registrarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 123;BA.debugLine="rd1Mes.Height = rd1Semana.Height";
Debug.ShouldStop(67108864);
registrarsuscripcion.mostCurrent._rd1mes.runMethod(true,"setHeight",registrarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 124;BA.debugLine="rd1Mes.Left = rd1Semana.Left";
Debug.ShouldStop(134217728);
registrarsuscripcion.mostCurrent._rd1mes.runMethod(true,"setLeft",registrarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 125;BA.debugLine="rd1Mes.Top = rd3Semanas.Top + rd3Semanas.Height +";
Debug.ShouldStop(268435456);
registrarsuscripcion.mostCurrent._rd1mes.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarsuscripcion.mostCurrent._rd3semanas.runMethod(true,"getTop"),registrarsuscripcion.mostCurrent._rd3semanas.runMethod(true,"getHeight"),registrarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "++*",2, 0)));
 BA.debugLineNum = 127;BA.debugLine="rd1Ano.Width = rd1Semana.Width";
Debug.ShouldStop(1073741824);
registrarsuscripcion.mostCurrent._rd1ano.runMethod(true,"setWidth",registrarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 128;BA.debugLine="rd1Ano.Height = rd1Semana.Height";
Debug.ShouldStop(-2147483648);
registrarsuscripcion.mostCurrent._rd1ano.runMethod(true,"setHeight",registrarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 129;BA.debugLine="rd1Ano.Left = rd1Semana.Left";
Debug.ShouldStop(1);
registrarsuscripcion.mostCurrent._rd1ano.runMethod(true,"setLeft",registrarsuscripcion.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 130;BA.debugLine="rd1Ano.Top = rd1Mes.Top + rd1Mes.Height + pnlPeri";
Debug.ShouldStop(2);
registrarsuscripcion.mostCurrent._rd1ano.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarsuscripcion.mostCurrent._rd1mes.runMethod(true,"getTop"),registrarsuscripcion.mostCurrent._rd1mes.runMethod(true,"getHeight"),registrarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "++*",2, 0)));
 BA.debugLineNum = 135;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
Debug.ShouldStop(64);
registrarsuscripcion.mostCurrent._pnlnavinferior.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarsuscripcion._alturadispositivo,RemoteObject.createImmutable(0.08)}, "*",0, 0)));
 BA.debugLineNum = 136;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
Debug.ShouldStop(128);
registrarsuscripcion.mostCurrent._pnlnavinferior.runMethod(true,"setWidth",registrarsuscripcion._anchodispositivo);
 BA.debugLineNum = 137;BA.debugLine="pnlNavInferior.Left = 0";
Debug.ShouldStop(256);
registrarsuscripcion.mostCurrent._pnlnavinferior.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 138;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
Debug.ShouldStop(512);
registrarsuscripcion.mostCurrent._pnlnavinferior.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {registrarsuscripcion._alturadispositivo,registrarsuscripcion.mostCurrent._pnlnavinferior.runMethod(true,"getHeight")}, "-",1, 1));
 BA.debugLineNum = 141;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
Debug.ShouldStop(4096);
registrarsuscripcion.mostCurrent._btnmenu.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarsuscripcion._anchodispositivo,RemoteObject.createImmutable(0.15)}, "*",0, 0)));
 BA.debugLineNum = 142;BA.debugLine="btnMenu.Height = btnMenu.Width";
Debug.ShouldStop(8192);
registrarsuscripcion.mostCurrent._btnmenu.runMethod(true,"setHeight",registrarsuscripcion.mostCurrent._btnmenu.runMethod(true,"getWidth"));
 BA.debugLineNum = 143;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
Debug.ShouldStop(16384);
registrarsuscripcion.mostCurrent._btnmenu.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarsuscripcion.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),registrarsuscripcion.mostCurrent._btnmenu.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 144;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
Debug.ShouldStop(32768);
registrarsuscripcion.mostCurrent._btnmenu.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registrarsuscripcion._anchodispositivo,registrarsuscripcion.mostCurrent._btnmenu.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 146;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
Debug.ShouldStop(131072);
registrarsuscripcion.mostCurrent._lblcontornoboton.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarsuscripcion._anchodispositivo,RemoteObject.createImmutable(0.17)}, "*",0, 0)));
 BA.debugLineNum = 147;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
Debug.ShouldStop(262144);
registrarsuscripcion.mostCurrent._lblcontornoboton.runMethod(true,"setHeight",registrarsuscripcion.mostCurrent._lblcontornoboton.runMethod(true,"getWidth"));
 BA.debugLineNum = 148;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
Debug.ShouldStop(524288);
registrarsuscripcion.mostCurrent._lblcontornoboton.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registrarsuscripcion._anchodispositivo,registrarsuscripcion.mostCurrent._lblcontornoboton.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 149;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
Debug.ShouldStop(1048576);
registrarsuscripcion.mostCurrent._lblcontornoboton.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarsuscripcion.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),registrarsuscripcion.mostCurrent._lblcontornoboton.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 154;BA.debugLine="btnOperacionSuscripcion.Text = \"Guardar suscripci";
Debug.ShouldStop(33554432);
registrarsuscripcion.mostCurrent._btnoperacionsuscripcion.runMethod(true,"setText",BA.ObjectToCharSequence("Guardar suscripción"));
 BA.debugLineNum = 155;BA.debugLine="btnOperacionSuscripcion.Top = pnlPeriodos.Top + p";
Debug.ShouldStop(67108864);
registrarsuscripcion.mostCurrent._btnoperacionsuscripcion.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"getTop"),registrarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {registrarsuscripcion.mostCurrent._lblcontornoboton.runMethod(true,"getTop"),(RemoteObject.solve(new RemoteObject[] {registrarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"getTop"),registrarsuscripcion.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),registrarsuscripcion.mostCurrent._btnoperacionsuscripcion.runMethod(true,"getHeight")}, "++",2, 1))}, "-",1, 1)),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 156;BA.debugLine="btnOperacionSuscripcion.Left = (anchoDispositivo";
Debug.ShouldStop(134217728);
registrarsuscripcion.mostCurrent._btnoperacionsuscripcion.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registrarsuscripcion._anchodispositivo,registrarsuscripcion.mostCurrent._btnoperacionsuscripcion.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
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
		Debug.PushSubsStack("Activity_Pause (registrarsuscripcion) ","registrarsuscripcion",17,registrarsuscripcion.mostCurrent.activityBA,registrarsuscripcion.mostCurrent,162);
if (RapidSub.canDelegate("activity_pause")) { return pullup.wallet.registrarsuscripcion.remoteMe.runUserSub(false, "registrarsuscripcion","activity_pause", _userclosed);}
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
		Debug.PushSubsStack("Activity_Resume (registrarsuscripcion) ","registrarsuscripcion",17,registrarsuscripcion.mostCurrent.activityBA,registrarsuscripcion.mostCurrent,159);
if (RapidSub.canDelegate("activity_resume")) { return pullup.wallet.registrarsuscripcion.remoteMe.runUserSub(false, "registrarsuscripcion","activity_resume");}
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
		Debug.PushSubsStack("asignacionCampos (registrarsuscripcion) ","registrarsuscripcion",17,registrarsuscripcion.mostCurrent.activityBA,registrarsuscripcion.mostCurrent,266);
if (RapidSub.canDelegate("asignacioncampos")) { return pullup.wallet.registrarsuscripcion.remoteMe.runUserSub(false, "registrarsuscripcion","asignacioncampos");}
RemoteObject _susripcion = RemoteObject.declareNull("pullup.wallet.main._registrosuscripcion");
 BA.debugLineNum = 266;BA.debugLine="Sub asignacionCampos As RegistroSuscripcion";
Debug.ShouldStop(512);
 BA.debugLineNum = 267;BA.debugLine="Dim susripcion As RegistroSuscripcion";
Debug.ShouldStop(1024);
_susripcion = RemoteObject.createNew ("pullup.wallet.main._registrosuscripcion");Debug.locals.put("susripcion", _susripcion);
 BA.debugLineNum = 269;BA.debugLine="susripcion.monto = txtMonto.Text";
Debug.ShouldStop(4096);
_susripcion.setField ("monto" /*RemoteObject*/ ,BA.numberCast(int.class, registrarsuscripcion.mostCurrent._txtmonto.runMethod(true,"getText")));
 BA.debugLineNum = 271;BA.debugLine="susripcion.nombre = txtNombre.Text";
Debug.ShouldStop(16384);
_susripcion.setField ("nombre" /*RemoteObject*/ ,registrarsuscripcion.mostCurrent._txtnombre.runMethod(true,"getText"));
 BA.debugLineNum = 273;BA.debugLine="susripcion.descripcion = (txtDescripcion.Text)";
Debug.ShouldStop(65536);
_susripcion.setField ("descripcion" /*RemoteObject*/ ,(registrarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getText")));
 BA.debugLineNum = 275;BA.debugLine="susripcion.periodo = diasPeriodo";
Debug.ShouldStop(262144);
_susripcion.setField ("periodo" /*RemoteObject*/ ,registrarsuscripcion._diasperiodo);
 BA.debugLineNum = 277;BA.debugLine="susripcion.fechaPago = fechaMasPeriodo(susripcion";
Debug.ShouldStop(1048576);
_susripcion.setField ("fechaPago" /*RemoteObject*/ ,_fechamasperiodo(_susripcion.getField(true,"periodo" /*RemoteObject*/ )));
 BA.debugLineNum = 279;BA.debugLine="susripcion.color = colorCaja";
Debug.ShouldStop(4194304);
_susripcion.setField ("color" /*RemoteObject*/ ,registrarsuscripcion._colorcaja);
 BA.debugLineNum = 281;BA.debugLine="Return susripcion";
Debug.ShouldStop(16777216);
if (true) return _susripcion;
 BA.debugLineNum = 282;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("btnMenu_Click (registrarsuscripcion) ","registrarsuscripcion",17,registrarsuscripcion.mostCurrent.activityBA,registrarsuscripcion.mostCurrent,165);
if (RapidSub.canDelegate("btnmenu_click")) { return pullup.wallet.registrarsuscripcion.remoteMe.runUserSub(false, "registrarsuscripcion","btnmenu_click");}
 BA.debugLineNum = 165;BA.debugLine="Private Sub btnMenu_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 166;BA.debugLine="Activity.Finish";
Debug.ShouldStop(32);
registrarsuscripcion.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _btnoperacionsuscripcion_click() throws Exception{
try {
		Debug.PushSubsStack("btnOperacionSuscripcion_Click (registrarsuscripcion) ","registrarsuscripcion",17,registrarsuscripcion.mostCurrent.activityBA,registrarsuscripcion.mostCurrent,286);
if (RapidSub.canDelegate("btnoperacionsuscripcion_click")) { return pullup.wallet.registrarsuscripcion.remoteMe.runUserSub(false, "registrarsuscripcion","btnoperacionsuscripcion_click");}
RemoteObject _validaciones = RemoteObject.createImmutable(false);
RemoteObject _suscripcionregistrar = RemoteObject.declareNull("pullup.wallet.main._registrosuscripcion");
 BA.debugLineNum = 286;BA.debugLine="Private Sub btnOperacionSuscripcion_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 287;BA.debugLine="Dim validaciones As Boolean";
Debug.ShouldStop(1073741824);
_validaciones = RemoteObject.createImmutable(false);Debug.locals.put("validaciones", _validaciones);
 BA.debugLineNum = 289;BA.debugLine="validaciones = validarCampos";
Debug.ShouldStop(1);
_validaciones = _validarcampos();Debug.locals.put("validaciones", _validaciones);
 BA.debugLineNum = 290;BA.debugLine="If(validaciones = True) Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",_validaciones,registrarsuscripcion.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 292;BA.debugLine="Dim suscripcionRegistrar As RegistroSuscripcion";
Debug.ShouldStop(8);
_suscripcionregistrar = RemoteObject.createNew ("pullup.wallet.main._registrosuscripcion");Debug.locals.put("suscripcionRegistrar", _suscripcionregistrar);
 BA.debugLineNum = 293;BA.debugLine="suscripcionRegistrar = asignacionCampos";
Debug.ShouldStop(16);
_suscripcionregistrar = _asignacioncampos();Debug.locals.put("suscripcionRegistrar", _suscripcionregistrar);
 BA.debugLineNum = 296;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO suscripciones (mo";
Debug.ShouldStop(128);
registrarsuscripcion._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO suscripciones (monto, nombre, descripcion, periodo, fecha_pago, color) VALUES (?, ?, ?, ?, ?, ?)")),(Object)(registrarsuscripcion.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {6},new Object[] {(_suscripcionregistrar.getField(true,"monto" /*RemoteObject*/ )),(_suscripcionregistrar.getField(true,"nombre" /*RemoteObject*/ )),(_suscripcionregistrar.getField(true,"descripcion" /*RemoteObject*/ )),(_suscripcionregistrar.getField(true,"periodo" /*RemoteObject*/ )),(_suscripcionregistrar.getField(true,"fechaPago" /*RemoteObject*/ )),(_suscripcionregistrar.getField(true,"color" /*RemoteObject*/ ))})))));
 BA.debugLineNum = 300;BA.debugLine="cur = sql.ExecQuery(\"SELECT suma_egresos FROM eg";
Debug.ShouldStop(2048);
registrarsuscripcion.mostCurrent._cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), registrarsuscripcion._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT suma_egresos FROM egresos"))));
 BA.debugLineNum = 301;BA.debugLine="cur.Position = 0";
Debug.ShouldStop(4096);
registrarsuscripcion.mostCurrent._cur.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 302;BA.debugLine="egresosActuales = cur.GetInt(\"suma_egresos\")";
Debug.ShouldStop(8192);
registrarsuscripcion._egresosactuales = registrarsuscripcion.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("suma_egresos")));
 BA.debugLineNum = 305;BA.debugLine="sql.ExecNonQuery2(\"UPDATE egresos SET suma_egres";
Debug.ShouldStop(65536);
registrarsuscripcion._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE egresos SET suma_egresos = ? WHERE id_egreso = 1")),(Object)(registrarsuscripcion.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {((RemoteObject.solve(new RemoteObject[] {registrarsuscripcion._egresosactuales,_suscripcionregistrar.getField(true,"monto" /*RemoteObject*/ )}, "+",1, 1)))})))));
 BA.debugLineNum = 307;BA.debugLine="ToastMessageShow(\"Suscripción registrada\", True)";
Debug.ShouldStop(262144);
registrarsuscripcion.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Suscripción registrada")),(Object)(registrarsuscripcion.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 309;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1048576);
registrarsuscripcion.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 311;BA.debugLine="StartActivity(Suscripciones)";
Debug.ShouldStop(4194304);
registrarsuscripcion.mostCurrent.__c.runVoidMethod ("StartActivity",registrarsuscripcion.processBA,(Object)((registrarsuscripcion.mostCurrent._suscripciones.getObject())));
 }else {
 BA.debugLineNum = 314;BA.debugLine="Msgbox2(\"Por favor, rellene todos los campos, se";
Debug.ShouldStop(33554432);
registrarsuscripcion.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("Por favor, rellene todos los campos, seleccione un periodo y color")),(Object)(BA.ObjectToCharSequence("Registro incorrecto")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((registrarsuscripcion.mostCurrent.__c.getField(false,"Null"))),registrarsuscripcion.mostCurrent.activityBA);
 };
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
public static RemoteObject  _cpbarracolor_colorchanged(RemoteObject _color) throws Exception{
try {
		Debug.PushSubsStack("cpBarraColor_ColorChanged (registrarsuscripcion) ","registrarsuscripcion",17,registrarsuscripcion.mostCurrent.activityBA,registrarsuscripcion.mostCurrent,179);
if (RapidSub.canDelegate("cpbarracolor_colorchanged")) { return pullup.wallet.registrarsuscripcion.remoteMe.runUserSub(false, "registrarsuscripcion","cpbarracolor_colorchanged", _color);}
Debug.locals.put("color", _color);
 BA.debugLineNum = 179;BA.debugLine="Sub cpBarraColor_ColorChanged(color As Int)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 180;BA.debugLine="lblFondoMonto.Color = color";
Debug.ShouldStop(524288);
registrarsuscripcion.mostCurrent._lblfondomonto.runVoidMethod ("setColor",_color);
 BA.debugLineNum = 181;BA.debugLine="colorCaja = color";
Debug.ShouldStop(1048576);
registrarsuscripcion._colorcaja = _color;
 BA.debugLineNum = 182;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("fechaMasPeriodo (registrarsuscripcion) ","registrarsuscripcion",17,registrarsuscripcion.mostCurrent.activityBA,registrarsuscripcion.mostCurrent,195);
if (RapidSub.canDelegate("fechamasperiodo")) { return pullup.wallet.registrarsuscripcion.remoteMe.runUserSub(false, "registrarsuscripcion","fechamasperiodo", _periodo);}
RemoteObject _fechaactual = RemoteObject.createImmutable("");
RemoteObject _fechaproxima = RemoteObject.createImmutable(0L);
Debug.locals.put("periodo", _periodo);
 BA.debugLineNum = 195;BA.debugLine="Sub fechaMasPeriodo(periodo As Int) As String";
Debug.ShouldStop(4);
 BA.debugLineNum = 196;BA.debugLine="Dim fechaActual As String";
Debug.ShouldStop(8);
_fechaactual = RemoteObject.createImmutable("");Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 197;BA.debugLine="Dim fechaProxima As Long";
Debug.ShouldStop(16);
_fechaproxima = RemoteObject.createImmutable(0L);Debug.locals.put("fechaProxima", _fechaproxima);
 BA.debugLineNum = 199;BA.debugLine="fechaActual = DateTime.Date(obtenerFechaActual)";
Debug.ShouldStop(64);
_fechaactual = registrarsuscripcion.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(_obtenerfechaactual()));Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 200;BA.debugLine="fechaProxima = DateTime.DateParse(fechaActual)";
Debug.ShouldStop(128);
_fechaproxima = registrarsuscripcion.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateParse",(Object)(_fechaactual));Debug.locals.put("fechaProxima", _fechaproxima);
 BA.debugLineNum = 201;BA.debugLine="fechaProxima = DateTime.Add(fechaProxima, 0, 0, p";
Debug.ShouldStop(256);
_fechaproxima = registrarsuscripcion.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Add",(Object)(_fechaproxima),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_periodo));Debug.locals.put("fechaProxima", _fechaproxima);
 BA.debugLineNum = 203;BA.debugLine="Return DateTime.Date(fechaProxima)";
Debug.ShouldStop(1024);
if (true) return registrarsuscripcion.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(_fechaproxima));
 BA.debugLineNum = 204;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 14;BA.debugLine="Dim alturaDispositivo As Int";
registrarsuscripcion._alturadispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 15;BA.debugLine="Dim anchoDispositivo As Int";
registrarsuscripcion._anchodispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 16;BA.debugLine="Dim colorCaja As Int";
registrarsuscripcion._colorcaja = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 17;BA.debugLine="Dim diasPeriodo As Int";
registrarsuscripcion._diasperiodo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 18;BA.debugLine="Dim aparicionMsgBox1 As Boolean";
registrarsuscripcion._aparicionmsgbox1 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 19;BA.debugLine="Dim aparicionMsgBox2 As Boolean";
registrarsuscripcion._aparicionmsgbox2 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 20;BA.debugLine="Dim aparicionMsgBox3 As Boolean";
registrarsuscripcion._aparicionmsgbox3 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 21;BA.debugLine="Dim cur As Cursor";
registrarsuscripcion.mostCurrent._cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Dim egresosActuales As Int";
registrarsuscripcion._egresosactuales = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 26;BA.debugLine="Private btnMenu As Button";
registrarsuscripcion.mostCurrent._btnmenu = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private btnOperacionSuscripcion As Button";
registrarsuscripcion.mostCurrent._btnoperacionsuscripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private txtDescripcion As EditText";
registrarsuscripcion.mostCurrent._txtdescripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private txtMonto As EditText";
registrarsuscripcion.mostCurrent._txtmonto = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private txtNombre As EditText";
registrarsuscripcion.mostCurrent._txtnombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private lblFondoMonto As Label";
registrarsuscripcion.mostCurrent._lblfondomonto = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private lblFondoDescripcion As Label";
registrarsuscripcion.mostCurrent._lblfondodescripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private lblFondoNombre As Label";
registrarsuscripcion.mostCurrent._lblfondonombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private lblContornoBoton As Label";
registrarsuscripcion.mostCurrent._lblcontornoboton = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private lblNombreVista As Label";
registrarsuscripcion.mostCurrent._lblnombrevista = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private rd1Ano As RadioButton";
registrarsuscripcion.mostCurrent._rd1ano = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private rd1Mes As RadioButton";
registrarsuscripcion.mostCurrent._rd1mes = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private rd1Semana As RadioButton";
registrarsuscripcion.mostCurrent._rd1semana = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private rd2Semanas As RadioButton";
registrarsuscripcion.mostCurrent._rd2semanas = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private rd3Semanas As RadioButton";
registrarsuscripcion.mostCurrent._rd3semanas = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private pnlNavInferior As Panel";
registrarsuscripcion.mostCurrent._pnlnavinferior = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private pnlPeriodos As Panel";
registrarsuscripcion.mostCurrent._pnlperiodos = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private pnlSelector As Panel";
registrarsuscripcion.mostCurrent._pnlselector = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private cpBarraColor As ASColorSlider  'Miembro g";
registrarsuscripcion.mostCurrent._cpbarracolor = RemoteObject.createNew ("pullup.wallet.ascolorslider");
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _limitarlongitudentrada(RemoteObject _antiguo,RemoteObject _nuevo,RemoteObject _longitud,RemoteObject _view,RemoteObject _campo) throws Exception{
try {
		Debug.PushSubsStack("limitarLongitudEntrada (registrarsuscripcion) ","registrarsuscripcion",17,registrarsuscripcion.mostCurrent.activityBA,registrarsuscripcion.mostCurrent,208);
if (RapidSub.canDelegate("limitarlongitudentrada")) { return pullup.wallet.registrarsuscripcion.remoteMe.runUserSub(false, "registrarsuscripcion","limitarlongitudentrada", _antiguo, _nuevo, _longitud, _view, _campo);}
Debug.locals.put("antiguo", _antiguo);
Debug.locals.put("nuevo", _nuevo);
Debug.locals.put("longitud", _longitud);
Debug.locals.put("view", _view);
Debug.locals.put("campo", _campo);
 BA.debugLineNum = 208;BA.debugLine="Sub limitarLongitudEntrada(antiguo As String, nuev";
Debug.ShouldStop(32768);
 BA.debugLineNum = 209;BA.debugLine="If(nuevo.Length > longitud) Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean(">",_nuevo.runMethod(true,"length"),BA.numberCast(double.class, _longitud)))) { 
 BA.debugLineNum = 210;BA.debugLine="If(campo = \"monto\") Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("monto")))) { 
 BA.debugLineNum = 211;BA.debugLine="If(aparicionMsgBox1 = False) Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",registrarsuscripcion._aparicionmsgbox1,registrarsuscripcion.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 212;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
Debug.ShouldStop(524288);
registrarsuscripcion.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para el monto es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((registrarsuscripcion.mostCurrent.__c.getField(false,"Null"))),registrarsuscripcion.mostCurrent.activityBA);
 BA.debugLineNum = 213;BA.debugLine="aparicionMsgBox1 = True";
Debug.ShouldStop(1048576);
registrarsuscripcion._aparicionmsgbox1 = registrarsuscripcion.mostCurrent.__c.getField(true,"True");
 };
 }else 
{ BA.debugLineNum = 215;BA.debugLine="Else If(campo = \"nombre\") Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("nombre")))) { 
 BA.debugLineNum = 216;BA.debugLine="If(aparicionMsgBox2 = False) Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",registrarsuscripcion._aparicionmsgbox2,registrarsuscripcion.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 217;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
Debug.ShouldStop(16777216);
registrarsuscripcion.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para el nombre es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((registrarsuscripcion.mostCurrent.__c.getField(false,"Null"))),registrarsuscripcion.mostCurrent.activityBA);
 BA.debugLineNum = 218;BA.debugLine="aparicionMsgBox2 = True";
Debug.ShouldStop(33554432);
registrarsuscripcion._aparicionmsgbox2 = registrarsuscripcion.mostCurrent.__c.getField(true,"True");
 };
 }else 
{ BA.debugLineNum = 220;BA.debugLine="Else If(campo = \"descripcion\") Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("descripcion")))) { 
 BA.debugLineNum = 221;BA.debugLine="If(aparicionMsgBox3 = False) Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",registrarsuscripcion._aparicionmsgbox3,registrarsuscripcion.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 222;BA.debugLine="Msgbox2(\"La longitud máxima permitida para la";
Debug.ShouldStop(536870912);
registrarsuscripcion.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para la descripción es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((registrarsuscripcion.mostCurrent.__c.getField(false,"Null"))),registrarsuscripcion.mostCurrent.activityBA);
 BA.debugLineNum = 223;BA.debugLine="aparicionMsgBox3 = True";
Debug.ShouldStop(1073741824);
registrarsuscripcion._aparicionmsgbox3 = registrarsuscripcion.mostCurrent.__c.getField(true,"True");
 };
 }}}
;
 BA.debugLineNum = 226;BA.debugLine="view.Text = antiguo";
Debug.ShouldStop(2);
_view.runMethod(true,"setText",BA.ObjectToCharSequence(_antiguo));
 };
 BA.debugLineNum = 228;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("obtenerFechaActual (registrarsuscripcion) ","registrarsuscripcion",17,registrarsuscripcion.mostCurrent.activityBA,registrarsuscripcion.mostCurrent,185);
if (RapidSub.canDelegate("obtenerfechaactual")) { return pullup.wallet.registrarsuscripcion.remoteMe.runUserSub(false, "registrarsuscripcion","obtenerfechaactual");}
RemoteObject _ahora = RemoteObject.createImmutable(0L);
 BA.debugLineNum = 185;BA.debugLine="Sub obtenerFechaActual As Long";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 186;BA.debugLine="Dim ahora As Long";
Debug.ShouldStop(33554432);
_ahora = RemoteObject.createImmutable(0L);Debug.locals.put("ahora", _ahora);
 BA.debugLineNum = 187;BA.debugLine="ahora = DateTime.Now";
Debug.ShouldStop(67108864);
_ahora = registrarsuscripcion.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow");Debug.locals.put("ahora", _ahora);
 BA.debugLineNum = 188;BA.debugLine="Return ahora";
Debug.ShouldStop(134217728);
if (true) return _ahora;
 BA.debugLineNum = 190;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
registrarsuscripcion._sql = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _rd1ano_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("rd1Ano_CheckedChange (registrarsuscripcion) ","registrarsuscripcion",17,registrarsuscripcion.mostCurrent.activityBA,registrarsuscripcion.mostCurrent,260);
if (RapidSub.canDelegate("rd1ano_checkedchange")) { return pullup.wallet.registrarsuscripcion.remoteMe.runUserSub(false, "registrarsuscripcion","rd1ano_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 260;BA.debugLine="Private Sub rd1Ano_CheckedChange(Checked As Boolea";
Debug.ShouldStop(8);
 BA.debugLineNum = 261;BA.debugLine="diasPeriodo = 365";
Debug.ShouldStop(16);
registrarsuscripcion._diasperiodo = BA.numberCast(int.class, 365);
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
public static RemoteObject  _rd1mes_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("rd1Mes_CheckedChange (registrarsuscripcion) ","registrarsuscripcion",17,registrarsuscripcion.mostCurrent.activityBA,registrarsuscripcion.mostCurrent,256);
if (RapidSub.canDelegate("rd1mes_checkedchange")) { return pullup.wallet.registrarsuscripcion.remoteMe.runUserSub(false, "registrarsuscripcion","rd1mes_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 256;BA.debugLine="Private Sub rd1Mes_CheckedChange(Checked As Boolea";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 257;BA.debugLine="diasPeriodo = 30";
Debug.ShouldStop(1);
registrarsuscripcion._diasperiodo = BA.numberCast(int.class, 30);
 BA.debugLineNum = 258;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("rd1Semana_CheckedChange (registrarsuscripcion) ","registrarsuscripcion",17,registrarsuscripcion.mostCurrent.activityBA,registrarsuscripcion.mostCurrent,252);
if (RapidSub.canDelegate("rd1semana_checkedchange")) { return pullup.wallet.registrarsuscripcion.remoteMe.runUserSub(false, "registrarsuscripcion","rd1semana_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 252;BA.debugLine="Private Sub rd1Semana_CheckedChange(Checked As Boo";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 253;BA.debugLine="diasPeriodo = 7";
Debug.ShouldStop(268435456);
registrarsuscripcion._diasperiodo = BA.numberCast(int.class, 7);
 BA.debugLineNum = 254;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("rd2Semanas_CheckedChange (registrarsuscripcion) ","registrarsuscripcion",17,registrarsuscripcion.mostCurrent.activityBA,registrarsuscripcion.mostCurrent,248);
if (RapidSub.canDelegate("rd2semanas_checkedchange")) { return pullup.wallet.registrarsuscripcion.remoteMe.runUserSub(false, "registrarsuscripcion","rd2semanas_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 248;BA.debugLine="Private Sub rd2Semanas_CheckedChange(Checked As Bo";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 249;BA.debugLine="diasPeriodo = 14";
Debug.ShouldStop(16777216);
registrarsuscripcion._diasperiodo = BA.numberCast(int.class, 14);
 BA.debugLineNum = 250;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("rd3Semanas_CheckedChange (registrarsuscripcion) ","registrarsuscripcion",17,registrarsuscripcion.mostCurrent.activityBA,registrarsuscripcion.mostCurrent,244);
if (RapidSub.canDelegate("rd3semanas_checkedchange")) { return pullup.wallet.registrarsuscripcion.remoteMe.runUserSub(false, "registrarsuscripcion","rd3semanas_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 244;BA.debugLine="Private Sub rd3Semanas_CheckedChange(Checked As Bo";
Debug.ShouldStop(524288);
 BA.debugLineNum = 245;BA.debugLine="diasPeriodo = 21";
Debug.ShouldStop(1048576);
registrarsuscripcion._diasperiodo = BA.numberCast(int.class, 21);
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
public static RemoteObject  _txtdescripcion_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtDescripcion_TextChanged (registrarsuscripcion) ","registrarsuscripcion",17,registrarsuscripcion.mostCurrent.activityBA,registrarsuscripcion.mostCurrent,239);
if (RapidSub.canDelegate("txtdescripcion_textchanged")) { return pullup.wallet.registrarsuscripcion.remoteMe.runUserSub(false, "registrarsuscripcion","txtdescripcion_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 239;BA.debugLine="Private Sub txtDescripcion_TextChanged (Old As Str";
Debug.ShouldStop(16384);
 BA.debugLineNum = 240;BA.debugLine="limitarLongitudEntrada(Old, New, 41, txtDescripci";
Debug.ShouldStop(32768);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 41),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), registrarsuscripcion.mostCurrent._txtdescripcion.getObject()),RemoteObject.createImmutable("descripcion"));
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
public static RemoteObject  _txtmonto_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtMonto_TextChanged (registrarsuscripcion) ","registrarsuscripcion",17,registrarsuscripcion.mostCurrent.activityBA,registrarsuscripcion.mostCurrent,231);
if (RapidSub.canDelegate("txtmonto_textchanged")) { return pullup.wallet.registrarsuscripcion.remoteMe.runUserSub(false, "registrarsuscripcion","txtmonto_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 231;BA.debugLine="Private Sub txtMonto_TextChanged (Old As String, N";
Debug.ShouldStop(64);
 BA.debugLineNum = 232;BA.debugLine="limitarLongitudEntrada(Old, New, 9, txtMonto, \"mo";
Debug.ShouldStop(128);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 9),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), registrarsuscripcion.mostCurrent._txtmonto.getObject()),RemoteObject.createImmutable("monto"));
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
public static RemoteObject  _txtnombre_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtNombre_TextChanged (registrarsuscripcion) ","registrarsuscripcion",17,registrarsuscripcion.mostCurrent.activityBA,registrarsuscripcion.mostCurrent,235);
if (RapidSub.canDelegate("txtnombre_textchanged")) { return pullup.wallet.registrarsuscripcion.remoteMe.runUserSub(false, "registrarsuscripcion","txtnombre_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 235;BA.debugLine="Private Sub txtNombre_TextChanged (Old As String,";
Debug.ShouldStop(1024);
 BA.debugLineNum = 236;BA.debugLine="limitarLongitudEntrada(Old, New, 16, txtNombre, \"";
Debug.ShouldStop(2048);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 16),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), registrarsuscripcion.mostCurrent._txtnombre.getObject()),RemoteObject.createImmutable("nombre"));
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
public static RemoteObject  _validarcampos() throws Exception{
try {
		Debug.PushSubsStack("validarCampos (registrarsuscripcion) ","registrarsuscripcion",17,registrarsuscripcion.mostCurrent.activityBA,registrarsuscripcion.mostCurrent,170);
if (RapidSub.canDelegate("validarcampos")) { return pullup.wallet.registrarsuscripcion.remoteMe.runUserSub(false, "registrarsuscripcion","validarcampos");}
 BA.debugLineNum = 170;BA.debugLine="Sub validarCampos As Boolean";
Debug.ShouldStop(512);
 BA.debugLineNum = 171;BA.debugLine="If(txtMonto.Text.Length <> 0 And txtNombre.Text.L";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("!",registrarsuscripcion.mostCurrent._txtmonto.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",registrarsuscripcion.mostCurrent._txtnombre.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",registrarsuscripcion.mostCurrent._txtdescripcion.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",registrarsuscripcion._colorcaja,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",registrarsuscripcion._diasperiodo,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 172;BA.debugLine="Return True";
Debug.ShouldStop(2048);
if (true) return registrarsuscripcion.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 174;BA.debugLine="Return False";
Debug.ShouldStop(8192);
if (true) return registrarsuscripcion.mostCurrent.__c.getField(true,"False");
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