package pullup.wallet;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class registrarmetaahorro_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (registrarmetaahorro) ","registrarmetaahorro",16,registrarmetaahorro.mostCurrent.activityBA,registrarmetaahorro.mostCurrent,58);
if (RapidSub.canDelegate("activity_create")) { return pullup.wallet.registrarmetaahorro.remoteMe.runUserSub(false, "registrarmetaahorro","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 58;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 59;BA.debugLine="Activity.LoadLayout(\"LFormMetaAhorro\")";
Debug.ShouldStop(67108864);
registrarmetaahorro.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("LFormMetaAhorro")),registrarmetaahorro.mostCurrent.activityBA);
 BA.debugLineNum = 60;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
Debug.ShouldStop(134217728);
registrarmetaahorro._alturadispositivo = registrarmetaahorro.mostCurrent._main._alturadispositivo /*RemoteObject*/ ;
 BA.debugLineNum = 61;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
Debug.ShouldStop(268435456);
registrarmetaahorro._anchodispositivo = registrarmetaahorro.mostCurrent._main._anchodispositivo /*RemoteObject*/ ;
 BA.debugLineNum = 62;BA.debugLine="sql = Starter.sql";
Debug.ShouldStop(536870912);
registrarmetaahorro._sql = registrarmetaahorro.mostCurrent._starter._sql /*RemoteObject*/ ;
 BA.debugLineNum = 63;BA.debugLine="aparicionMsgBox1 = False";
Debug.ShouldStop(1073741824);
registrarmetaahorro._aparicionmsgbox1 = registrarmetaahorro.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 64;BA.debugLine="aparicionMsgBox2 = False";
Debug.ShouldStop(-2147483648);
registrarmetaahorro._aparicionmsgbox2 = registrarmetaahorro.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 65;BA.debugLine="aparicionMsgBox3 = False";
Debug.ShouldStop(1);
registrarmetaahorro._aparicionmsgbox3 = registrarmetaahorro.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 66;BA.debugLine="aparicionMsgBox4 = False";
Debug.ShouldStop(2);
registrarmetaahorro._aparicionmsgbox4 = registrarmetaahorro.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 67;BA.debugLine="diasPeriodo = 7";
Debug.ShouldStop(4);
registrarmetaahorro._diasperiodo = BA.numberCast(int.class, 7);
 BA.debugLineNum = 68;BA.debugLine="colorCaja = 0";
Debug.ShouldStop(8);
registrarmetaahorro._colorcaja = BA.numberCast(int.class, 0);
 BA.debugLineNum = 71;BA.debugLine="lblNombreVista.TextSize = 20";
Debug.ShouldStop(64);
registrarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 72;BA.debugLine="lblNombreVista.TextColor = Colors.Black";
Debug.ShouldStop(128);
registrarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"setTextColor",registrarmetaahorro.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 73;BA.debugLine="lblNombreVista.Height = 30dip";
Debug.ShouldStop(256);
registrarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"setHeight",registrarmetaahorro.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 74;BA.debugLine="lblNombreVista.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(512);
registrarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 75;BA.debugLine="lblNombreVista.Top = 30dip";
Debug.ShouldStop(1024);
registrarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"setTop",registrarmetaahorro.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 76;BA.debugLine="lblNombreVista.Left = (anchoDispositivo - lblNomb";
Debug.ShouldStop(2048);
registrarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registrarmetaahorro._anchodispositivo,registrarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 78;BA.debugLine="txtMetaAhorro.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(8192);
registrarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 79;BA.debugLine="txtMetaAhorro.Height = alturaDispositivo * 0.14";
Debug.ShouldStop(16384);
registrarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro._alturadispositivo,RemoteObject.createImmutable(0.14)}, "*",0, 0)));
 BA.debugLineNum = 80;BA.debugLine="txtMetaAhorro.Top = lblNombreVista.Top * 1.5 + lb";
Debug.ShouldStop(32768);
registrarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(1.5),registrarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"getHeight")}, "*+",1, 0)));
 BA.debugLineNum = 81;BA.debugLine="txtMetaAhorro.Left = (anchoDispositivo - txtMetaA";
Debug.ShouldStop(65536);
registrarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registrarmetaahorro._anchodispositivo,registrarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 82;BA.debugLine="lblFondoMetaAhorro.Width = txtMetaAhorro.Width";
Debug.ShouldStop(131072);
registrarmetaahorro.mostCurrent._lblfondometaahorro.runMethod(true,"setWidth",registrarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getWidth"));
 BA.debugLineNum = 83;BA.debugLine="lblFondoMetaAhorro.Height = txtMetaAhorro.Height";
Debug.ShouldStop(262144);
registrarmetaahorro.mostCurrent._lblfondometaahorro.runMethod(true,"setHeight",registrarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getHeight"));
 BA.debugLineNum = 84;BA.debugLine="lblFondoMetaAhorro.Top = txtMetaAhorro.Top";
Debug.ShouldStop(524288);
registrarmetaahorro.mostCurrent._lblfondometaahorro.runMethod(true,"setTop",registrarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getTop"));
 BA.debugLineNum = 85;BA.debugLine="lblFondoMetaAhorro.Left = txtMetaAhorro.Left";
Debug.ShouldStop(1048576);
registrarmetaahorro.mostCurrent._lblfondometaahorro.runMethod(true,"setLeft",registrarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getLeft"));
 BA.debugLineNum = 87;BA.debugLine="lblMetaAhorroTitulo.Width = lblFondoMetaAhorro.Wi";
Debug.ShouldStop(4194304);
registrarmetaahorro.mostCurrent._lblmetaahorrotitulo.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._lblfondometaahorro.runMethod(true,"getWidth"),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 88;BA.debugLine="lblMetaAhorroTitulo.Height = stu.MeasureMultiline";
Debug.ShouldStop(8388608);
registrarmetaahorro.mostCurrent._lblmetaahorrotitulo.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._stu.runMethod(true,"MeasureMultilineTextHeight",(Object)((registrarmetaahorro.mostCurrent._lblmetaahorrotitulo.getObject())),(Object)(BA.ObjectToCharSequence(registrarmetaahorro.mostCurrent._lblmetaahorrotitulo.runMethod(true,"getText")))),RemoteObject.createImmutable(2)}, "+",1, 1));
 BA.debugLineNum = 89;BA.debugLine="lblMetaAhorroTitulo.Top = lblFondoMetaAhorro.Top";
Debug.ShouldStop(16777216);
registrarmetaahorro.mostCurrent._lblmetaahorrotitulo.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._lblfondometaahorro.runMethod(true,"getTop"),registrarmetaahorro.mostCurrent._lblfondometaahorro.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.05)}, "+*",1, 0)));
 BA.debugLineNum = 90;BA.debugLine="lblMetaAhorroTitulo.Left = lblFondoMetaAhorro.Lef";
Debug.ShouldStop(33554432);
registrarmetaahorro.mostCurrent._lblmetaahorrotitulo.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._lblfondometaahorro.runMethod(true,"getLeft"),registrarmetaahorro.mostCurrent._lblfondomontoahorro.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.1)}, "+*",1, 0)));
 BA.debugLineNum = 91;BA.debugLine="lblMetaAhorroTitulo.Gravity = Gravity.CENTER_VERT";
Debug.ShouldStop(67108864);
registrarmetaahorro.mostCurrent._lblmetaahorrotitulo.runMethod(true,"setGravity",registrarmetaahorro.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 93;BA.debugLine="txtNombre.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(268435456);
registrarmetaahorro.mostCurrent._txtnombre.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 94;BA.debugLine="txtNombre.Height = alturaDispositivo * 0.06";
Debug.ShouldStop(536870912);
registrarmetaahorro.mostCurrent._txtnombre.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro._alturadispositivo,RemoteObject.createImmutable(0.06)}, "*",0, 0)));
 BA.debugLineNum = 95;BA.debugLine="txtNombre.Top = txtMetaAhorro.Top + txtMetaAhorro";
Debug.ShouldStop(1073741824);
registrarmetaahorro.mostCurrent._txtnombre.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getTop"),registrarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getHeight"),registrarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 96;BA.debugLine="txtNombre.Left = (anchoDispositivo - txtNombre.Wi";
Debug.ShouldStop(-2147483648);
registrarmetaahorro.mostCurrent._txtnombre.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registrarmetaahorro._anchodispositivo,registrarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 97;BA.debugLine="lblFondoNombre.Width = txtMetaAhorro.Width";
Debug.ShouldStop(1);
registrarmetaahorro.mostCurrent._lblfondonombre.runMethod(true,"setWidth",registrarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getWidth"));
 BA.debugLineNum = 98;BA.debugLine="lblFondoNombre.Height = txtNombre.Height";
Debug.ShouldStop(2);
registrarmetaahorro.mostCurrent._lblfondonombre.runMethod(true,"setHeight",registrarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getHeight"));
 BA.debugLineNum = 99;BA.debugLine="lblFondoNombre.Top = txtNombre.Top";
Debug.ShouldStop(4);
registrarmetaahorro.mostCurrent._lblfondonombre.runMethod(true,"setTop",registrarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getTop"));
 BA.debugLineNum = 100;BA.debugLine="lblFondoNombre.Left = txtNombre.Left";
Debug.ShouldStop(8);
registrarmetaahorro.mostCurrent._lblfondonombre.runMethod(true,"setLeft",registrarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 102;BA.debugLine="txtDescripcion.Width = txtNombre.Width";
Debug.ShouldStop(32);
registrarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"setWidth",registrarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getWidth"));
 BA.debugLineNum = 103;BA.debugLine="txtDescripcion.Height = txtNombre.Height";
Debug.ShouldStop(64);
registrarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"setHeight",registrarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getHeight"));
 BA.debugLineNum = 104;BA.debugLine="txtDescripcion.Top = txtNombre.Top + txtNombre.He";
Debug.ShouldStop(128);
registrarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getTop"),registrarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getHeight"),registrarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 105;BA.debugLine="txtDescripcion.Left = txtNombre.Left";
Debug.ShouldStop(256);
registrarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"setLeft",registrarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 106;BA.debugLine="lblFondoDescripcion.Width = txtDescripcion.Width";
Debug.ShouldStop(512);
registrarmetaahorro.mostCurrent._lblfondodescripcion.runMethod(true,"setWidth",registrarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"getWidth"));
 BA.debugLineNum = 107;BA.debugLine="lblFondoDescripcion.Height = txtDescripcion.Heigh";
Debug.ShouldStop(1024);
registrarmetaahorro.mostCurrent._lblfondodescripcion.runMethod(true,"setHeight",registrarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"getHeight"));
 BA.debugLineNum = 108;BA.debugLine="lblFondoDescripcion.Top = txtDescripcion.Top";
Debug.ShouldStop(2048);
registrarmetaahorro.mostCurrent._lblfondodescripcion.runMethod(true,"setTop",registrarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"getTop"));
 BA.debugLineNum = 109;BA.debugLine="lblFondoDescripcion.Left = txtDescripcion.Left";
Debug.ShouldStop(4096);
registrarmetaahorro.mostCurrent._lblfondodescripcion.runMethod(true,"setLeft",registrarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"getLeft"));
 BA.debugLineNum = 111;BA.debugLine="txtMontoAhorro.Width = txtMetaAhorro.Width";
Debug.ShouldStop(16384);
registrarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"setWidth",registrarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getWidth"));
 BA.debugLineNum = 112;BA.debugLine="txtMontoAhorro.Height = txtMetaAhorro.Height";
Debug.ShouldStop(32768);
registrarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"setHeight",registrarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getHeight"));
 BA.debugLineNum = 113;BA.debugLine="txtMontoAhorro.Top = txtDescripcion.Top + txtDesc";
Debug.ShouldStop(65536);
registrarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"getTop"),registrarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"getHeight"),registrarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 114;BA.debugLine="txtMontoAhorro.Left = txtNombre.Left";
Debug.ShouldStop(131072);
registrarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"setLeft",registrarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 115;BA.debugLine="lblFondoMontoAhorro.Width = txtMontoAhorro.Width";
Debug.ShouldStop(262144);
registrarmetaahorro.mostCurrent._lblfondomontoahorro.runMethod(true,"setWidth",registrarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getWidth"));
 BA.debugLineNum = 116;BA.debugLine="lblFondoMontoAhorro.Height = txtMontoAhorro.Heigh";
Debug.ShouldStop(524288);
registrarmetaahorro.mostCurrent._lblfondomontoahorro.runMethod(true,"setHeight",registrarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getHeight"));
 BA.debugLineNum = 117;BA.debugLine="lblFondoMontoAhorro.Top = txtMontoAhorro.Top";
Debug.ShouldStop(1048576);
registrarmetaahorro.mostCurrent._lblfondomontoahorro.runMethod(true,"setTop",registrarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getTop"));
 BA.debugLineNum = 118;BA.debugLine="lblFondoMontoAhorro.Left = txtMontoAhorro.Left";
Debug.ShouldStop(2097152);
registrarmetaahorro.mostCurrent._lblfondomontoahorro.runMethod(true,"setLeft",registrarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getLeft"));
 BA.debugLineNum = 120;BA.debugLine="lblMontoAhorroTitulo.Width = lblFondoMontoAhorro.";
Debug.ShouldStop(8388608);
registrarmetaahorro.mostCurrent._lblmontoahorrotitulo.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._lblfondomontoahorro.runMethod(true,"getWidth"),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 121;BA.debugLine="lblMontoAhorroTitulo.Height = stu.MeasureMultilin";
Debug.ShouldStop(16777216);
registrarmetaahorro.mostCurrent._lblmontoahorrotitulo.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._stu.runMethod(true,"MeasureMultilineTextHeight",(Object)((registrarmetaahorro.mostCurrent._lblmontoahorrotitulo.getObject())),(Object)(BA.ObjectToCharSequence(registrarmetaahorro.mostCurrent._lblmontoahorrotitulo.runMethod(true,"getText")))),RemoteObject.createImmutable(2)}, "+",1, 1));
 BA.debugLineNum = 122;BA.debugLine="lblMontoAhorroTitulo.Top = lblFondoMontoAhorro.To";
Debug.ShouldStop(33554432);
registrarmetaahorro.mostCurrent._lblmontoahorrotitulo.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._lblfondomontoahorro.runMethod(true,"getTop"),registrarmetaahorro.mostCurrent._lblfondomontoahorro.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.05)}, "+*",1, 0)));
 BA.debugLineNum = 123;BA.debugLine="lblMontoAhorroTitulo.Left = lblFondoMontoAhorro.L";
Debug.ShouldStop(67108864);
registrarmetaahorro.mostCurrent._lblmontoahorrotitulo.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._lblfondomontoahorro.runMethod(true,"getLeft"),registrarmetaahorro.mostCurrent._lblfondomontoahorro.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.1)}, "+*",1, 0)));
 BA.debugLineNum = 124;BA.debugLine="lblMontoAhorroTitulo.Gravity = Gravity.CENTER_VER";
Debug.ShouldStop(134217728);
registrarmetaahorro.mostCurrent._lblmontoahorrotitulo.runMethod(true,"setGravity",registrarmetaahorro.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 126;BA.debugLine="pnlSelector.Top = txtMontoAhorro.Top + txtMontoAh";
Debug.ShouldStop(536870912);
registrarmetaahorro.mostCurrent._pnlselector.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getTop"),registrarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getHeight"),registrarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 127;BA.debugLine="pnlSelector.Left = txtMontoAhorro.Left + txtMonto";
Debug.ShouldStop(1073741824);
registrarmetaahorro.mostCurrent._pnlselector.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getLeft"),registrarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getWidth"),registrarmetaahorro.mostCurrent._pnlselector.runMethod(true,"getWidth")}, "+-",2, 1));
 BA.debugLineNum = 129;BA.debugLine="pnlPeriodos.Top = pnlSelector.Top";
Debug.ShouldStop(1);
registrarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"setTop",registrarmetaahorro.mostCurrent._pnlselector.runMethod(true,"getTop"));
 BA.debugLineNum = 130;BA.debugLine="pnlPeriodos.Left = txtMontoAhorro.Left";
Debug.ShouldStop(2);
registrarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"setLeft",registrarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getLeft"));
 BA.debugLineNum = 131;BA.debugLine="pnlPeriodos.Width = (txtMontoAhorro.Width - pnlSe";
Debug.ShouldStop(4);
registrarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getWidth"),registrarmetaahorro.mostCurrent._pnlselector.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 132;BA.debugLine="pnlPeriodos.Height = pnlSelector.Height";
Debug.ShouldStop(8);
registrarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"setHeight",registrarmetaahorro.mostCurrent._pnlselector.runMethod(true,"getHeight"));
 BA.debugLineNum = 135;BA.debugLine="rd1Semana.Width = pnlPeriodos.Width";
Debug.ShouldStop(64);
registrarmetaahorro.mostCurrent._rd1semana.runMethod(true,"setWidth",registrarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"getWidth"));
 BA.debugLineNum = 136;BA.debugLine="rd1Semana.Height = pnlPeriodos.Height * 0.18";
Debug.ShouldStop(128);
registrarmetaahorro.mostCurrent._rd1semana.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.18)}, "*",0, 0)));
 BA.debugLineNum = 137;BA.debugLine="rd1Semana.Left = 0";
Debug.ShouldStop(256);
registrarmetaahorro.mostCurrent._rd1semana.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 138;BA.debugLine="rd1Semana.Top = 0";
Debug.ShouldStop(512);
registrarmetaahorro.mostCurrent._rd1semana.runMethod(true,"setTop",BA.numberCast(int.class, 0));
 BA.debugLineNum = 140;BA.debugLine="rd2Semanas.Width = rd1Semana.Width";
Debug.ShouldStop(2048);
registrarmetaahorro.mostCurrent._rd2semanas.runMethod(true,"setWidth",registrarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 141;BA.debugLine="rd2Semanas.Height = rd1Semana.Height";
Debug.ShouldStop(4096);
registrarmetaahorro.mostCurrent._rd2semanas.runMethod(true,"setHeight",registrarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 142;BA.debugLine="rd2Semanas.Left = rd1Semana.Left";
Debug.ShouldStop(8192);
registrarmetaahorro.mostCurrent._rd2semanas.runMethod(true,"setLeft",registrarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 143;BA.debugLine="rd2Semanas.Top = rd1Semana.Height + pnlPeriodos.H";
Debug.ShouldStop(16384);
registrarmetaahorro.mostCurrent._rd2semanas.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getHeight"),registrarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "+*",1, 0)));
 BA.debugLineNum = 145;BA.debugLine="rd3Semanas.Width = rd1Semana.Width";
Debug.ShouldStop(65536);
registrarmetaahorro.mostCurrent._rd3semanas.runMethod(true,"setWidth",registrarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 146;BA.debugLine="rd3Semanas.Height = rd1Semana.Height";
Debug.ShouldStop(131072);
registrarmetaahorro.mostCurrent._rd3semanas.runMethod(true,"setHeight",registrarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 147;BA.debugLine="rd3Semanas.Left = rd1Semana.Left";
Debug.ShouldStop(262144);
registrarmetaahorro.mostCurrent._rd3semanas.runMethod(true,"setLeft",registrarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 148;BA.debugLine="rd3Semanas.Top = rd2Semanas.Top + rd2Semanas.Heig";
Debug.ShouldStop(524288);
registrarmetaahorro.mostCurrent._rd3semanas.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._rd2semanas.runMethod(true,"getTop"),registrarmetaahorro.mostCurrent._rd2semanas.runMethod(true,"getHeight"),registrarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "++*",2, 0)));
 BA.debugLineNum = 150;BA.debugLine="rd1Mes.Width = rd1Semana.Width";
Debug.ShouldStop(2097152);
registrarmetaahorro.mostCurrent._rd1mes.runMethod(true,"setWidth",registrarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 151;BA.debugLine="rd1Mes.Height = rd1Semana.Height";
Debug.ShouldStop(4194304);
registrarmetaahorro.mostCurrent._rd1mes.runMethod(true,"setHeight",registrarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 152;BA.debugLine="rd1Mes.Left = rd1Semana.Left";
Debug.ShouldStop(8388608);
registrarmetaahorro.mostCurrent._rd1mes.runMethod(true,"setLeft",registrarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 153;BA.debugLine="rd1Mes.Top = rd3Semanas.Top + rd3Semanas.Height +";
Debug.ShouldStop(16777216);
registrarmetaahorro.mostCurrent._rd1mes.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._rd3semanas.runMethod(true,"getTop"),registrarmetaahorro.mostCurrent._rd3semanas.runMethod(true,"getHeight"),registrarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "++*",2, 0)));
 BA.debugLineNum = 155;BA.debugLine="rd1Ano.Width = rd1Semana.Width";
Debug.ShouldStop(67108864);
registrarmetaahorro.mostCurrent._rd1ano.runMethod(true,"setWidth",registrarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 156;BA.debugLine="rd1Ano.Height = rd1Semana.Height";
Debug.ShouldStop(134217728);
registrarmetaahorro.mostCurrent._rd1ano.runMethod(true,"setHeight",registrarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 157;BA.debugLine="rd1Ano.Left = rd1Semana.Left";
Debug.ShouldStop(268435456);
registrarmetaahorro.mostCurrent._rd1ano.runMethod(true,"setLeft",registrarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 158;BA.debugLine="rd1Ano.Top = rd1Mes.Top + rd1Mes.Height + pnlPeri";
Debug.ShouldStop(536870912);
registrarmetaahorro.mostCurrent._rd1ano.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._rd1mes.runMethod(true,"getTop"),registrarmetaahorro.mostCurrent._rd1mes.runMethod(true,"getHeight"),registrarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "++*",2, 0)));
 BA.debugLineNum = 163;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
Debug.ShouldStop(4);
registrarmetaahorro.mostCurrent._pnlnavinferior.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro._alturadispositivo,RemoteObject.createImmutable(0.08)}, "*",0, 0)));
 BA.debugLineNum = 164;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
Debug.ShouldStop(8);
registrarmetaahorro.mostCurrent._pnlnavinferior.runMethod(true,"setWidth",registrarmetaahorro._anchodispositivo);
 BA.debugLineNum = 165;BA.debugLine="pnlNavInferior.Left = 0";
Debug.ShouldStop(16);
registrarmetaahorro.mostCurrent._pnlnavinferior.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 166;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
Debug.ShouldStop(32);
registrarmetaahorro.mostCurrent._pnlnavinferior.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {registrarmetaahorro._alturadispositivo,registrarmetaahorro.mostCurrent._pnlnavinferior.runMethod(true,"getHeight")}, "-",1, 1));
 BA.debugLineNum = 169;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
Debug.ShouldStop(256);
registrarmetaahorro.mostCurrent._btnmenu.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro._anchodispositivo,RemoteObject.createImmutable(0.15)}, "*",0, 0)));
 BA.debugLineNum = 170;BA.debugLine="btnMenu.Height = btnMenu.Width";
Debug.ShouldStop(512);
registrarmetaahorro.mostCurrent._btnmenu.runMethod(true,"setHeight",registrarmetaahorro.mostCurrent._btnmenu.runMethod(true,"getWidth"));
 BA.debugLineNum = 171;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
Debug.ShouldStop(1024);
registrarmetaahorro.mostCurrent._btnmenu.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),registrarmetaahorro.mostCurrent._btnmenu.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 172;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
Debug.ShouldStop(2048);
registrarmetaahorro.mostCurrent._btnmenu.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registrarmetaahorro._anchodispositivo,registrarmetaahorro.mostCurrent._btnmenu.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 174;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
Debug.ShouldStop(8192);
registrarmetaahorro.mostCurrent._lblcontornoboton.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro._anchodispositivo,RemoteObject.createImmutable(0.17)}, "*",0, 0)));
 BA.debugLineNum = 175;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
Debug.ShouldStop(16384);
registrarmetaahorro.mostCurrent._lblcontornoboton.runMethod(true,"setHeight",registrarmetaahorro.mostCurrent._lblcontornoboton.runMethod(true,"getWidth"));
 BA.debugLineNum = 176;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
Debug.ShouldStop(32768);
registrarmetaahorro.mostCurrent._lblcontornoboton.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registrarmetaahorro._anchodispositivo,registrarmetaahorro.mostCurrent._lblcontornoboton.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 177;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
Debug.ShouldStop(65536);
registrarmetaahorro.mostCurrent._lblcontornoboton.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),registrarmetaahorro.mostCurrent._lblcontornoboton.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 182;BA.debugLine="btnOperacionMetaAhorro.Text = \"Guardar meta de ah";
Debug.ShouldStop(2097152);
registrarmetaahorro.mostCurrent._btnoperacionmetaahorro.runMethod(true,"setText",BA.ObjectToCharSequence("Guardar meta de ahorro"));
 BA.debugLineNum = 183;BA.debugLine="btnOperacionMetaAhorro.Top = pnlPeriodos.Top + pn";
Debug.ShouldStop(4194304);
registrarmetaahorro.mostCurrent._btnoperacionmetaahorro.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"getTop"),registrarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._lblcontornoboton.runMethod(true,"getTop"),(RemoteObject.solve(new RemoteObject[] {registrarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"getTop"),registrarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),registrarmetaahorro.mostCurrent._btnoperacionmetaahorro.runMethod(true,"getHeight")}, "++",2, 1))}, "-",1, 1)),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 184;BA.debugLine="btnOperacionMetaAhorro.Left = (anchoDispositivo -";
Debug.ShouldStop(8388608);
registrarmetaahorro.mostCurrent._btnoperacionmetaahorro.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {registrarmetaahorro._anchodispositivo,registrarmetaahorro.mostCurrent._btnoperacionmetaahorro.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 185;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Activity_Pause (registrarmetaahorro) ","registrarmetaahorro",16,registrarmetaahorro.mostCurrent.activityBA,registrarmetaahorro.mostCurrent,190);
if (RapidSub.canDelegate("activity_pause")) { return pullup.wallet.registrarmetaahorro.remoteMe.runUserSub(false, "registrarmetaahorro","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 190;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 191;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("Activity_Resume (registrarmetaahorro) ","registrarmetaahorro",16,registrarmetaahorro.mostCurrent.activityBA,registrarmetaahorro.mostCurrent,187);
if (RapidSub.canDelegate("activity_resume")) { return pullup.wallet.registrarmetaahorro.remoteMe.runUserSub(false, "registrarmetaahorro","activity_resume");}
 BA.debugLineNum = 187;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(67108864);
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
public static RemoteObject  _asignacioncampos() throws Exception{
try {
		Debug.PushSubsStack("asignacionCampos (registrarmetaahorro) ","registrarmetaahorro",16,registrarmetaahorro.mostCurrent.activityBA,registrarmetaahorro.mostCurrent,304);
if (RapidSub.canDelegate("asignacioncampos")) { return pullup.wallet.registrarmetaahorro.remoteMe.runUserSub(false, "registrarmetaahorro","asignacioncampos");}
RemoteObject _metaahorro = RemoteObject.declareNull("pullup.wallet.main._registrometaahorro");
 BA.debugLineNum = 304;BA.debugLine="Sub asignacionCampos As RegistroMetaAhorro";
Debug.ShouldStop(32768);
 BA.debugLineNum = 305;BA.debugLine="Dim metaAhorro As RegistroMetaAhorro";
Debug.ShouldStop(65536);
_metaahorro = RemoteObject.createNew ("pullup.wallet.main._registrometaahorro");Debug.locals.put("metaAhorro", _metaahorro);
 BA.debugLineNum = 307;BA.debugLine="metaAhorro.montoMeta = txtMetaAhorro.Text";
Debug.ShouldStop(262144);
_metaahorro.setField ("montoMeta" /*RemoteObject*/ ,BA.numberCast(int.class, registrarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getText")));
 BA.debugLineNum = 309;BA.debugLine="metaAhorro.montoAhorro = txtMontoAhorro.Text";
Debug.ShouldStop(1048576);
_metaahorro.setField ("montoAhorro" /*RemoteObject*/ ,BA.numberCast(int.class, registrarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getText")));
 BA.debugLineNum = 311;BA.debugLine="metaAhorro.nombre = txtNombre.Text";
Debug.ShouldStop(4194304);
_metaahorro.setField ("nombre" /*RemoteObject*/ ,registrarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getText"));
 BA.debugLineNum = 313;BA.debugLine="metaAhorro.descripcion = (txtDescripcion.Text)";
Debug.ShouldStop(16777216);
_metaahorro.setField ("descripcion" /*RemoteObject*/ ,(registrarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"getText")));
 BA.debugLineNum = 315;BA.debugLine="metaAhorro.periodo = diasPeriodo";
Debug.ShouldStop(67108864);
_metaahorro.setField ("periodo" /*RemoteObject*/ ,registrarmetaahorro._diasperiodo);
 BA.debugLineNum = 317;BA.debugLine="metaAhorro.progreso = txtMontoAhorro.Text";
Debug.ShouldStop(268435456);
_metaahorro.setField ("progreso" /*RemoteObject*/ ,BA.numberCast(int.class, registrarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getText")));
 BA.debugLineNum = 319;BA.debugLine="metaAhorro.fechaPago = fechaMasPeriodo(metaAhorro";
Debug.ShouldStop(1073741824);
_metaahorro.setField ("fechaPago" /*RemoteObject*/ ,_fechamasperiodo(_metaahorro.getField(true,"periodo" /*RemoteObject*/ )));
 BA.debugLineNum = 321;BA.debugLine="metaAhorro.color = colorCaja";
Debug.ShouldStop(1);
_metaahorro.setField ("color" /*RemoteObject*/ ,registrarmetaahorro._colorcaja);
 BA.debugLineNum = 323;BA.debugLine="Return metaAhorro";
Debug.ShouldStop(4);
if (true) return _metaahorro;
 BA.debugLineNum = 324;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("btnMenu_Click (registrarmetaahorro) ","registrarmetaahorro",16,registrarmetaahorro.mostCurrent.activityBA,registrarmetaahorro.mostCurrent,193);
if (RapidSub.canDelegate("btnmenu_click")) { return pullup.wallet.registrarmetaahorro.remoteMe.runUserSub(false, "registrarmetaahorro","btnmenu_click");}
 BA.debugLineNum = 193;BA.debugLine="Private Sub btnMenu_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 194;BA.debugLine="Activity.Finish";
Debug.ShouldStop(2);
registrarmetaahorro.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 195;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnoperacionmetaahorro_click() throws Exception{
try {
		Debug.PushSubsStack("btnOperacionMetaAhorro_Click (registrarmetaahorro) ","registrarmetaahorro",16,registrarmetaahorro.mostCurrent.activityBA,registrarmetaahorro.mostCurrent,328);
if (RapidSub.canDelegate("btnoperacionmetaahorro_click")) { return pullup.wallet.registrarmetaahorro.remoteMe.runUserSub(false, "registrarmetaahorro","btnoperacionmetaahorro_click");}
RemoteObject _validaciones = RemoteObject.createImmutable(false);
RemoteObject _metaahorroregistrar = RemoteObject.declareNull("pullup.wallet.main._registrometaahorro");
 BA.debugLineNum = 328;BA.debugLine="Private Sub btnOperacionMetaAhorro_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 329;BA.debugLine="Dim validaciones As Boolean";
Debug.ShouldStop(256);
_validaciones = RemoteObject.createImmutable(false);Debug.locals.put("validaciones", _validaciones);
 BA.debugLineNum = 331;BA.debugLine="validaciones = validarCampos";
Debug.ShouldStop(1024);
_validaciones = _validarcampos();Debug.locals.put("validaciones", _validaciones);
 BA.debugLineNum = 332;BA.debugLine="If(validaciones = True) Then";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean("=",_validaciones,registrarmetaahorro.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 334;BA.debugLine="Dim metaAhorroRegistrar As RegistroMetaAhorro";
Debug.ShouldStop(8192);
_metaahorroregistrar = RemoteObject.createNew ("pullup.wallet.main._registrometaahorro");Debug.locals.put("metaAhorroRegistrar", _metaahorroregistrar);
 BA.debugLineNum = 335;BA.debugLine="metaAhorroRegistrar = asignacionCampos";
Debug.ShouldStop(16384);
_metaahorroregistrar = _asignacioncampos();Debug.locals.put("metaAhorroRegistrar", _metaahorroregistrar);
 BA.debugLineNum = 338;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO metas_ahorro (mon";
Debug.ShouldStop(131072);
registrarmetaahorro._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO metas_ahorro (monto_meta, monto_ahorro, nombre, descripcion, periodo_ahorro, progreso, fecha_pago, color) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")),(Object)(registrarmetaahorro.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {8},new Object[] {(_metaahorroregistrar.getField(true,"montoMeta" /*RemoteObject*/ )),(_metaahorroregistrar.getField(true,"montoAhorro" /*RemoteObject*/ )),(_metaahorroregistrar.getField(true,"nombre" /*RemoteObject*/ )),(_metaahorroregistrar.getField(true,"descripcion" /*RemoteObject*/ )),(_metaahorroregistrar.getField(true,"periodo" /*RemoteObject*/ )),(_metaahorroregistrar.getField(true,"progreso" /*RemoteObject*/ )),(_metaahorroregistrar.getField(true,"fechaPago" /*RemoteObject*/ )),(_metaahorroregistrar.getField(true,"color" /*RemoteObject*/ ))})))));
 BA.debugLineNum = 342;BA.debugLine="cur = sql.ExecQuery(\"SELECT suma_egresos FROM eg";
Debug.ShouldStop(2097152);
registrarmetaahorro.mostCurrent._cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), registrarmetaahorro._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT suma_egresos FROM egresos"))));
 BA.debugLineNum = 343;BA.debugLine="cur.Position = 0";
Debug.ShouldStop(4194304);
registrarmetaahorro.mostCurrent._cur.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 344;BA.debugLine="egresosActuales = cur.GetInt(\"suma_egresos\")";
Debug.ShouldStop(8388608);
registrarmetaahorro._egresosactuales = registrarmetaahorro.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("suma_egresos")));
 BA.debugLineNum = 347;BA.debugLine="sql.ExecNonQuery2(\"UPDATE egresos SET suma_egres";
Debug.ShouldStop(67108864);
registrarmetaahorro._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE egresos SET suma_egresos = ? WHERE id_egreso = 1")),(Object)(registrarmetaahorro.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {((RemoteObject.solve(new RemoteObject[] {registrarmetaahorro._egresosactuales,_metaahorroregistrar.getField(true,"montoAhorro" /*RemoteObject*/ )}, "+",1, 1)))})))));
 BA.debugLineNum = 349;BA.debugLine="ToastMessageShow(\"Meta de ahorro registrada\", Tr";
Debug.ShouldStop(268435456);
registrarmetaahorro.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Meta de ahorro registrada")),(Object)(registrarmetaahorro.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 351;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1073741824);
registrarmetaahorro.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 353;BA.debugLine="StartActivity(MetasDeAhorro)";
Debug.ShouldStop(1);
registrarmetaahorro.mostCurrent.__c.runVoidMethod ("StartActivity",registrarmetaahorro.processBA,(Object)((registrarmetaahorro.mostCurrent._metasdeahorro.getObject())));
 }else {
 BA.debugLineNum = 356;BA.debugLine="Msgbox2(\"Por favor, rellene todos los campos, se";
Debug.ShouldStop(8);
registrarmetaahorro.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("Por favor, rellene todos los campos, seleccione un periodo y color")),(Object)(BA.ObjectToCharSequence("Registro incorrecto")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((registrarmetaahorro.mostCurrent.__c.getField(false,"Null"))),registrarmetaahorro.mostCurrent.activityBA);
 };
 BA.debugLineNum = 358;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("cpBarraColor_ColorChanged (registrarmetaahorro) ","registrarmetaahorro",16,registrarmetaahorro.mostCurrent.activityBA,registrarmetaahorro.mostCurrent,208);
if (RapidSub.canDelegate("cpbarracolor_colorchanged")) { return pullup.wallet.registrarmetaahorro.remoteMe.runUserSub(false, "registrarmetaahorro","cpbarracolor_colorchanged", _color);}
Debug.locals.put("color", _color);
 BA.debugLineNum = 208;BA.debugLine="Private Sub cpBarraColor_ColorChanged(color As Int";
Debug.ShouldStop(32768);
 BA.debugLineNum = 209;BA.debugLine="lblFondoMontoAhorro.Color = color";
Debug.ShouldStop(65536);
registrarmetaahorro.mostCurrent._lblfondomontoahorro.runVoidMethod ("setColor",_color);
 BA.debugLineNum = 210;BA.debugLine="lblFondoMetaAhorro.Color = color";
Debug.ShouldStop(131072);
registrarmetaahorro.mostCurrent._lblfondometaahorro.runVoidMethod ("setColor",_color);
 BA.debugLineNum = 211;BA.debugLine="colorCaja = color";
Debug.ShouldStop(262144);
registrarmetaahorro._colorcaja = _color;
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
public static RemoteObject  _fechamasperiodo(RemoteObject _periodo) throws Exception{
try {
		Debug.PushSubsStack("fechaMasPeriodo (registrarmetaahorro) ","registrarmetaahorro",16,registrarmetaahorro.mostCurrent.activityBA,registrarmetaahorro.mostCurrent,225);
if (RapidSub.canDelegate("fechamasperiodo")) { return pullup.wallet.registrarmetaahorro.remoteMe.runUserSub(false, "registrarmetaahorro","fechamasperiodo", _periodo);}
RemoteObject _fechaactual = RemoteObject.createImmutable("");
RemoteObject _fechaproxima = RemoteObject.createImmutable(0L);
Debug.locals.put("periodo", _periodo);
 BA.debugLineNum = 225;BA.debugLine="Sub fechaMasPeriodo(periodo As Int) As String";
Debug.ShouldStop(1);
 BA.debugLineNum = 226;BA.debugLine="Dim fechaActual As String";
Debug.ShouldStop(2);
_fechaactual = RemoteObject.createImmutable("");Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 227;BA.debugLine="Dim fechaProxima As Long";
Debug.ShouldStop(4);
_fechaproxima = RemoteObject.createImmutable(0L);Debug.locals.put("fechaProxima", _fechaproxima);
 BA.debugLineNum = 229;BA.debugLine="fechaActual = DateTime.Date(obtenerFechaActual)";
Debug.ShouldStop(16);
_fechaactual = registrarmetaahorro.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(_obtenerfechaactual()));Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 230;BA.debugLine="fechaProxima = DateTime.DateParse(fechaActual)";
Debug.ShouldStop(32);
_fechaproxima = registrarmetaahorro.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateParse",(Object)(_fechaactual));Debug.locals.put("fechaProxima", _fechaproxima);
 BA.debugLineNum = 231;BA.debugLine="fechaProxima = DateTime.Add(fechaProxima, 0, 0, p";
Debug.ShouldStop(64);
_fechaproxima = registrarmetaahorro.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Add",(Object)(_fechaproxima),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_periodo));Debug.locals.put("fechaProxima", _fechaproxima);
 BA.debugLineNum = 233;BA.debugLine="Return DateTime.Date(fechaProxima)";
Debug.ShouldStop(256);
if (true) return registrarmetaahorro.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(_fechaproxima));
 BA.debugLineNum = 234;BA.debugLine="End Sub";
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
registrarmetaahorro._alturadispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 15;BA.debugLine="Dim anchoDispositivo As Int";
registrarmetaahorro._anchodispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 16;BA.debugLine="Dim colorCaja As Int";
registrarmetaahorro._colorcaja = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 17;BA.debugLine="Dim diasPeriodo As Int";
registrarmetaahorro._diasperiodo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 18;BA.debugLine="Dim aparicionMsgBox1 As Boolean";
registrarmetaahorro._aparicionmsgbox1 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 19;BA.debugLine="Dim aparicionMsgBox2 As Boolean";
registrarmetaahorro._aparicionmsgbox2 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 20;BA.debugLine="Dim aparicionMsgBox3 As Boolean";
registrarmetaahorro._aparicionmsgbox3 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 21;BA.debugLine="Dim aparicionMsgBox4 As Boolean";
registrarmetaahorro._aparicionmsgbox4 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 22;BA.debugLine="Dim stu As StringUtils";
registrarmetaahorro.mostCurrent._stu = RemoteObject.createNew ("anywheresoftware.b4a.objects.StringUtils");
 //BA.debugLineNum = 23;BA.debugLine="Dim cur As Cursor";
registrarmetaahorro.mostCurrent._cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Dim egresosActuales As Int";
registrarmetaahorro._egresosactuales = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 28;BA.debugLine="Private btnMenu As Button";
registrarmetaahorro.mostCurrent._btnmenu = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private btnOperacionMetaAhorro As Button";
registrarmetaahorro.mostCurrent._btnoperacionmetaahorro = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private txtDescripcion As EditText";
registrarmetaahorro.mostCurrent._txtdescripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private txtNombre As EditText";
registrarmetaahorro.mostCurrent._txtnombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private txtMetaAhorro As EditText";
registrarmetaahorro.mostCurrent._txtmetaahorro = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private txtMontoAhorro As EditText";
registrarmetaahorro.mostCurrent._txtmontoahorro = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private lblFondoDescripcion As Label";
registrarmetaahorro.mostCurrent._lblfondodescripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private lblFondoNombre As Label";
registrarmetaahorro.mostCurrent._lblfondonombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private lblFondoMetaAhorro As Label";
registrarmetaahorro.mostCurrent._lblfondometaahorro = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private lblFondoMontoAhorro As Label";
registrarmetaahorro.mostCurrent._lblfondomontoahorro = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private lblContornoBoton As Label";
registrarmetaahorro.mostCurrent._lblcontornoboton = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private lblNombreVista As Label";
registrarmetaahorro.mostCurrent._lblnombrevista = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private lblMetaAhorroTitulo As Label";
registrarmetaahorro.mostCurrent._lblmetaahorrotitulo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private lblMontoAhorroTitulo As Label";
registrarmetaahorro.mostCurrent._lblmontoahorrotitulo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private pnlNavInferior As Panel";
registrarmetaahorro.mostCurrent._pnlnavinferior = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private pnlPeriodos As Panel";
registrarmetaahorro.mostCurrent._pnlperiodos = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private pnlSelector As Panel";
registrarmetaahorro.mostCurrent._pnlselector = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private rd1Ano As RadioButton";
registrarmetaahorro.mostCurrent._rd1ano = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private rd1Mes As RadioButton";
registrarmetaahorro.mostCurrent._rd1mes = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private rd1Semana As RadioButton";
registrarmetaahorro.mostCurrent._rd1semana = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private rd2Semanas As RadioButton";
registrarmetaahorro.mostCurrent._rd2semanas = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private rd3Semanas As RadioButton";
registrarmetaahorro.mostCurrent._rd3semanas = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private cpBarraColor As ASColorSlider  'Miembro g";
registrarmetaahorro.mostCurrent._cpbarracolor = RemoteObject.createNew ("pullup.wallet.ascolorslider");
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _limitarlongitudentrada(RemoteObject _antiguo,RemoteObject _nuevo,RemoteObject _longitud,RemoteObject _view,RemoteObject _campo) throws Exception{
try {
		Debug.PushSubsStack("limitarLongitudEntrada (registrarmetaahorro) ","registrarmetaahorro",16,registrarmetaahorro.mostCurrent.activityBA,registrarmetaahorro.mostCurrent,238);
if (RapidSub.canDelegate("limitarlongitudentrada")) { return pullup.wallet.registrarmetaahorro.remoteMe.runUserSub(false, "registrarmetaahorro","limitarlongitudentrada", _antiguo, _nuevo, _longitud, _view, _campo);}
Debug.locals.put("antiguo", _antiguo);
Debug.locals.put("nuevo", _nuevo);
Debug.locals.put("longitud", _longitud);
Debug.locals.put("view", _view);
Debug.locals.put("campo", _campo);
 BA.debugLineNum = 238;BA.debugLine="Sub limitarLongitudEntrada(antiguo As String, nuev";
Debug.ShouldStop(8192);
 BA.debugLineNum = 239;BA.debugLine="If(nuevo.Length > longitud) Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean(">",_nuevo.runMethod(true,"length"),BA.numberCast(double.class, _longitud)))) { 
 BA.debugLineNum = 240;BA.debugLine="If(campo = \"montoAhorro\") Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("montoAhorro")))) { 
 BA.debugLineNum = 241;BA.debugLine="If(aparicionMsgBox1 = False) Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("=",registrarmetaahorro._aparicionmsgbox1,registrarmetaahorro.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 242;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
Debug.ShouldStop(131072);
registrarmetaahorro.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para el monto del ahorro es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((registrarmetaahorro.mostCurrent.__c.getField(false,"Null"))),registrarmetaahorro.mostCurrent.activityBA);
 BA.debugLineNum = 243;BA.debugLine="aparicionMsgBox1 = True";
Debug.ShouldStop(262144);
registrarmetaahorro._aparicionmsgbox1 = registrarmetaahorro.mostCurrent.__c.getField(true,"True");
 };
 }else 
{ BA.debugLineNum = 245;BA.debugLine="Else If(campo = \"metaAhorro\") Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("metaAhorro")))) { 
 BA.debugLineNum = 246;BA.debugLine="If(aparicionMsgBox2 = False) Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",registrarmetaahorro._aparicionmsgbox2,registrarmetaahorro.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 247;BA.debugLine="Msgbox2(\"La longitud máxima permitida para la";
Debug.ShouldStop(4194304);
registrarmetaahorro.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para la monto meta es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((registrarmetaahorro.mostCurrent.__c.getField(false,"Null"))),registrarmetaahorro.mostCurrent.activityBA);
 BA.debugLineNum = 248;BA.debugLine="aparicionMsgBox2 = True";
Debug.ShouldStop(8388608);
registrarmetaahorro._aparicionmsgbox2 = registrarmetaahorro.mostCurrent.__c.getField(true,"True");
 };
 }else 
{ BA.debugLineNum = 250;BA.debugLine="Else If(campo = \"nombre\") Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("nombre")))) { 
 BA.debugLineNum = 251;BA.debugLine="If(aparicionMsgBox3 = False) Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",registrarmetaahorro._aparicionmsgbox3,registrarmetaahorro.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 252;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
Debug.ShouldStop(134217728);
registrarmetaahorro.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para el nombre es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((registrarmetaahorro.mostCurrent.__c.getField(false,"Null"))),registrarmetaahorro.mostCurrent.activityBA);
 BA.debugLineNum = 253;BA.debugLine="aparicionMsgBox3 = True";
Debug.ShouldStop(268435456);
registrarmetaahorro._aparicionmsgbox3 = registrarmetaahorro.mostCurrent.__c.getField(true,"True");
 };
 }else 
{ BA.debugLineNum = 255;BA.debugLine="Else If(campo = \"descripcion\") Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("descripcion")))) { 
 BA.debugLineNum = 256;BA.debugLine="If(aparicionMsgBox4 = False) Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("=",registrarmetaahorro._aparicionmsgbox4,registrarmetaahorro.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 257;BA.debugLine="Msgbox2(\"La longitud máxima permitida para la";
Debug.ShouldStop(1);
registrarmetaahorro.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para la descripción es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((registrarmetaahorro.mostCurrent.__c.getField(false,"Null"))),registrarmetaahorro.mostCurrent.activityBA);
 BA.debugLineNum = 258;BA.debugLine="aparicionMsgBox4 = True";
Debug.ShouldStop(2);
registrarmetaahorro._aparicionmsgbox4 = registrarmetaahorro.mostCurrent.__c.getField(true,"True");
 };
 }}}}
;
 BA.debugLineNum = 261;BA.debugLine="view.Text = antiguo";
Debug.ShouldStop(16);
_view.runMethod(true,"setText",BA.ObjectToCharSequence(_antiguo));
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
public static RemoteObject  _obtenerfechaactual() throws Exception{
try {
		Debug.PushSubsStack("obtenerFechaActual (registrarmetaahorro) ","registrarmetaahorro",16,registrarmetaahorro.mostCurrent.activityBA,registrarmetaahorro.mostCurrent,215);
if (RapidSub.canDelegate("obtenerfechaactual")) { return pullup.wallet.registrarmetaahorro.remoteMe.runUserSub(false, "registrarmetaahorro","obtenerfechaactual");}
RemoteObject _ahora = RemoteObject.createImmutable(0L);
 BA.debugLineNum = 215;BA.debugLine="Sub obtenerFechaActual As Long";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 216;BA.debugLine="Dim ahora As Long";
Debug.ShouldStop(8388608);
_ahora = RemoteObject.createImmutable(0L);Debug.locals.put("ahora", _ahora);
 BA.debugLineNum = 217;BA.debugLine="ahora = DateTime.Now";
Debug.ShouldStop(16777216);
_ahora = registrarmetaahorro.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow");Debug.locals.put("ahora", _ahora);
 BA.debugLineNum = 218;BA.debugLine="Return ahora";
Debug.ShouldStop(33554432);
if (true) return _ahora;
 BA.debugLineNum = 220;BA.debugLine="End Sub";
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
registrarmetaahorro._sql = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _rd1ano_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("rd1Ano_CheckedChange (registrarmetaahorro) ","registrarmetaahorro",16,registrarmetaahorro.mostCurrent.activityBA,registrarmetaahorro.mostCurrent,299);
if (RapidSub.canDelegate("rd1ano_checkedchange")) { return pullup.wallet.registrarmetaahorro.remoteMe.runUserSub(false, "registrarmetaahorro","rd1ano_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 299;BA.debugLine="Private Sub rd1Ano_CheckedChange(Checked As Boolea";
Debug.ShouldStop(1024);
 BA.debugLineNum = 300;BA.debugLine="diasPeriodo = 365";
Debug.ShouldStop(2048);
registrarmetaahorro._diasperiodo = BA.numberCast(int.class, 365);
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
public static RemoteObject  _rd1mes_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("rd1Mes_CheckedChange (registrarmetaahorro) ","registrarmetaahorro",16,registrarmetaahorro.mostCurrent.activityBA,registrarmetaahorro.mostCurrent,295);
if (RapidSub.canDelegate("rd1mes_checkedchange")) { return pullup.wallet.registrarmetaahorro.remoteMe.runUserSub(false, "registrarmetaahorro","rd1mes_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 295;BA.debugLine="Private Sub rd1Mes_CheckedChange(Checked As Boolea";
Debug.ShouldStop(64);
 BA.debugLineNum = 296;BA.debugLine="diasPeriodo = 30";
Debug.ShouldStop(128);
registrarmetaahorro._diasperiodo = BA.numberCast(int.class, 30);
 BA.debugLineNum = 297;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("rd1Semana_CheckedChange (registrarmetaahorro) ","registrarmetaahorro",16,registrarmetaahorro.mostCurrent.activityBA,registrarmetaahorro.mostCurrent,291);
if (RapidSub.canDelegate("rd1semana_checkedchange")) { return pullup.wallet.registrarmetaahorro.remoteMe.runUserSub(false, "registrarmetaahorro","rd1semana_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 291;BA.debugLine="Private Sub rd1Semana_CheckedChange(Checked As Boo";
Debug.ShouldStop(4);
 BA.debugLineNum = 292;BA.debugLine="diasPeriodo = 7";
Debug.ShouldStop(8);
registrarmetaahorro._diasperiodo = BA.numberCast(int.class, 7);
 BA.debugLineNum = 293;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("rd2Semanas_CheckedChange (registrarmetaahorro) ","registrarmetaahorro",16,registrarmetaahorro.mostCurrent.activityBA,registrarmetaahorro.mostCurrent,287);
if (RapidSub.canDelegate("rd2semanas_checkedchange")) { return pullup.wallet.registrarmetaahorro.remoteMe.runUserSub(false, "registrarmetaahorro","rd2semanas_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 287;BA.debugLine="Private Sub rd2Semanas_CheckedChange(Checked As Bo";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 288;BA.debugLine="diasPeriodo = 14";
Debug.ShouldStop(-2147483648);
registrarmetaahorro._diasperiodo = BA.numberCast(int.class, 14);
 BA.debugLineNum = 289;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("rd3Semanas_CheckedChange (registrarmetaahorro) ","registrarmetaahorro",16,registrarmetaahorro.mostCurrent.activityBA,registrarmetaahorro.mostCurrent,283);
if (RapidSub.canDelegate("rd3semanas_checkedchange")) { return pullup.wallet.registrarmetaahorro.remoteMe.runUserSub(false, "registrarmetaahorro","rd3semanas_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 283;BA.debugLine="Private Sub rd3Semanas_CheckedChange(Checked As Bo";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 284;BA.debugLine="diasPeriodo = 21";
Debug.ShouldStop(134217728);
registrarmetaahorro._diasperiodo = BA.numberCast(int.class, 21);
 BA.debugLineNum = 285;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("txtDescripcion_TextChanged (registrarmetaahorro) ","registrarmetaahorro",16,registrarmetaahorro.mostCurrent.activityBA,registrarmetaahorro.mostCurrent,278);
if (RapidSub.canDelegate("txtdescripcion_textchanged")) { return pullup.wallet.registrarmetaahorro.remoteMe.runUserSub(false, "registrarmetaahorro","txtdescripcion_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 278;BA.debugLine="Private Sub txtDescripcion_TextChanged (Old As Str";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 279;BA.debugLine="limitarLongitudEntrada(Old, New, 41, txtDescripci";
Debug.ShouldStop(4194304);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 41),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), registrarmetaahorro.mostCurrent._txtdescripcion.getObject()),RemoteObject.createImmutable("descripcion"));
 BA.debugLineNum = 280;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtmetaahorro_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtMetaAhorro_TextChanged (registrarmetaahorro) ","registrarmetaahorro",16,registrarmetaahorro.mostCurrent.activityBA,registrarmetaahorro.mostCurrent,274);
if (RapidSub.canDelegate("txtmetaahorro_textchanged")) { return pullup.wallet.registrarmetaahorro.remoteMe.runUserSub(false, "registrarmetaahorro","txtmetaahorro_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 274;BA.debugLine="Private Sub txtMetaAhorro_TextChanged (Old As Stri";
Debug.ShouldStop(131072);
 BA.debugLineNum = 275;BA.debugLine="limitarLongitudEntrada(Old, New, 9, txtMetaAhorro";
Debug.ShouldStop(262144);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 9),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), registrarmetaahorro.mostCurrent._txtmetaahorro.getObject()),RemoteObject.createImmutable("metaAhorro"));
 BA.debugLineNum = 276;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtmontoahorro_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtMontoAhorro_TextChanged (registrarmetaahorro) ","registrarmetaahorro",16,registrarmetaahorro.mostCurrent.activityBA,registrarmetaahorro.mostCurrent,270);
if (RapidSub.canDelegate("txtmontoahorro_textchanged")) { return pullup.wallet.registrarmetaahorro.remoteMe.runUserSub(false, "registrarmetaahorro","txtmontoahorro_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 270;BA.debugLine="Private Sub txtMontoAhorro_TextChanged (Old As Str";
Debug.ShouldStop(8192);
 BA.debugLineNum = 271;BA.debugLine="limitarLongitudEntrada(Old ,New, 9, txtMontoAhorr";
Debug.ShouldStop(16384);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 9),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), registrarmetaahorro.mostCurrent._txtmontoahorro.getObject()),RemoteObject.createImmutable("montoAhorro"));
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
public static RemoteObject  _txtnombre_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtNombre_TextChanged (registrarmetaahorro) ","registrarmetaahorro",16,registrarmetaahorro.mostCurrent.activityBA,registrarmetaahorro.mostCurrent,266);
if (RapidSub.canDelegate("txtnombre_textchanged")) { return pullup.wallet.registrarmetaahorro.remoteMe.runUserSub(false, "registrarmetaahorro","txtnombre_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 266;BA.debugLine="Private Sub txtNombre_TextChanged (Old As String,";
Debug.ShouldStop(512);
 BA.debugLineNum = 267;BA.debugLine="limitarLongitudEntrada(Old, New, 16, txtNombre, \"";
Debug.ShouldStop(1024);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 16),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), registrarmetaahorro.mostCurrent._txtnombre.getObject()),RemoteObject.createImmutable("nombre"));
 BA.debugLineNum = 268;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("validarCampos (registrarmetaahorro) ","registrarmetaahorro",16,registrarmetaahorro.mostCurrent.activityBA,registrarmetaahorro.mostCurrent,198);
if (RapidSub.canDelegate("validarcampos")) { return pullup.wallet.registrarmetaahorro.remoteMe.runUserSub(false, "registrarmetaahorro","validarcampos");}
 BA.debugLineNum = 198;BA.debugLine="Sub validarCampos As Boolean";
Debug.ShouldStop(32);
 BA.debugLineNum = 199;BA.debugLine="If(txtMetaAhorro.Text.Length <> 0 And txtNombre.T";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("!",registrarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",registrarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",registrarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",registrarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",registrarmetaahorro._colorcaja,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",registrarmetaahorro._diasperiodo,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 200;BA.debugLine="Return True";
Debug.ShouldStop(128);
if (true) return registrarmetaahorro.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 202;BA.debugLine="Return False";
Debug.ShouldStop(512);
if (true) return registrarmetaahorro.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 204;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}