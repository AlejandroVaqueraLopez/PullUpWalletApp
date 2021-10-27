package pullup.wallet;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class editarmetaahorro_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (editarmetaahorro) ","editarmetaahorro",7,editarmetaahorro.mostCurrent.activityBA,editarmetaahorro.mostCurrent,58);
if (RapidSub.canDelegate("activity_create")) { return pullup.wallet.editarmetaahorro.remoteMe.runUserSub(false, "editarmetaahorro","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 58;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 59;BA.debugLine="Activity.LoadLayout(\"LFormMetaAhorro\")";
Debug.ShouldStop(67108864);
editarmetaahorro.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("LFormMetaAhorro")),editarmetaahorro.mostCurrent.activityBA);
 BA.debugLineNum = 60;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
Debug.ShouldStop(134217728);
editarmetaahorro._alturadispositivo = editarmetaahorro.mostCurrent._main._alturadispositivo /*RemoteObject*/ ;
 BA.debugLineNum = 61;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
Debug.ShouldStop(268435456);
editarmetaahorro._anchodispositivo = editarmetaahorro.mostCurrent._main._anchodispositivo /*RemoteObject*/ ;
 BA.debugLineNum = 62;BA.debugLine="sql = Starter.sql";
Debug.ShouldStop(536870912);
editarmetaahorro._sql = editarmetaahorro.mostCurrent._starter._sql /*RemoteObject*/ ;
 BA.debugLineNum = 63;BA.debugLine="aparicionMsgBox1 = False";
Debug.ShouldStop(1073741824);
editarmetaahorro._aparicionmsgbox1 = editarmetaahorro.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 64;BA.debugLine="aparicionMsgBox2 = False";
Debug.ShouldStop(-2147483648);
editarmetaahorro._aparicionmsgbox2 = editarmetaahorro.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 65;BA.debugLine="aparicionMsgBox3 = False";
Debug.ShouldStop(1);
editarmetaahorro._aparicionmsgbox3 = editarmetaahorro.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 66;BA.debugLine="aparicionMsgBox4 = False";
Debug.ShouldStop(2);
editarmetaahorro._aparicionmsgbox4 = editarmetaahorro.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 69;BA.debugLine="lblNombreVista.TextSize = 20";
Debug.ShouldStop(16);
editarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 70;BA.debugLine="lblNombreVista.TextColor = Colors.Black";
Debug.ShouldStop(32);
editarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"setTextColor",editarmetaahorro.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 71;BA.debugLine="lblNombreVista.Height = 30dip";
Debug.ShouldStop(64);
editarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"setHeight",editarmetaahorro.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 72;BA.debugLine="lblNombreVista.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(128);
editarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 73;BA.debugLine="lblNombreVista.Top = 30dip";
Debug.ShouldStop(256);
editarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"setTop",editarmetaahorro.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 74;BA.debugLine="lblNombreVista.Left = (anchoDispositivo - lblNomb";
Debug.ShouldStop(512);
editarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editarmetaahorro._anchodispositivo,editarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 76;BA.debugLine="txtMetaAhorro.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(2048);
editarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 77;BA.debugLine="txtMetaAhorro.Height = alturaDispositivo * 0.14";
Debug.ShouldStop(4096);
editarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro._alturadispositivo,RemoteObject.createImmutable(0.14)}, "*",0, 0)));
 BA.debugLineNum = 78;BA.debugLine="txtMetaAhorro.Top = lblNombreVista.Top * 1.5 + lb";
Debug.ShouldStop(8192);
editarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(1.5),editarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"getHeight")}, "*+",1, 0)));
 BA.debugLineNum = 79;BA.debugLine="txtMetaAhorro.Left = (anchoDispositivo - txtMetaA";
Debug.ShouldStop(16384);
editarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editarmetaahorro._anchodispositivo,editarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 80;BA.debugLine="lblFondoMetaAhorro.Width = txtMetaAhorro.Width";
Debug.ShouldStop(32768);
editarmetaahorro.mostCurrent._lblfondometaahorro.runMethod(true,"setWidth",editarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getWidth"));
 BA.debugLineNum = 81;BA.debugLine="lblFondoMetaAhorro.Height = txtMetaAhorro.Height";
Debug.ShouldStop(65536);
editarmetaahorro.mostCurrent._lblfondometaahorro.runMethod(true,"setHeight",editarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getHeight"));
 BA.debugLineNum = 82;BA.debugLine="lblFondoMetaAhorro.Top = txtMetaAhorro.Top";
Debug.ShouldStop(131072);
editarmetaahorro.mostCurrent._lblfondometaahorro.runMethod(true,"setTop",editarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getTop"));
 BA.debugLineNum = 83;BA.debugLine="lblFondoMetaAhorro.Left = txtMetaAhorro.Left";
Debug.ShouldStop(262144);
editarmetaahorro.mostCurrent._lblfondometaahorro.runMethod(true,"setLeft",editarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getLeft"));
 BA.debugLineNum = 85;BA.debugLine="lblMetaAhorroTitulo.Width = lblFondoMetaAhorro.Wi";
Debug.ShouldStop(1048576);
editarmetaahorro.mostCurrent._lblmetaahorrotitulo.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._lblfondometaahorro.runMethod(true,"getWidth"),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 86;BA.debugLine="lblMetaAhorroTitulo.Height = stu.MeasureMultiline";
Debug.ShouldStop(2097152);
editarmetaahorro.mostCurrent._lblmetaahorrotitulo.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._stu.runMethod(true,"MeasureMultilineTextHeight",(Object)((editarmetaahorro.mostCurrent._lblmetaahorrotitulo.getObject())),(Object)(BA.ObjectToCharSequence(editarmetaahorro.mostCurrent._lblmetaahorrotitulo.runMethod(true,"getText")))),RemoteObject.createImmutable(2)}, "+",1, 1));
 BA.debugLineNum = 87;BA.debugLine="lblMetaAhorroTitulo.Top = lblFondoMetaAhorro.Top";
Debug.ShouldStop(4194304);
editarmetaahorro.mostCurrent._lblmetaahorrotitulo.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._lblfondometaahorro.runMethod(true,"getTop"),editarmetaahorro.mostCurrent._lblfondometaahorro.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.05)}, "+*",1, 0)));
 BA.debugLineNum = 88;BA.debugLine="lblMetaAhorroTitulo.Left = lblFondoMetaAhorro.Lef";
Debug.ShouldStop(8388608);
editarmetaahorro.mostCurrent._lblmetaahorrotitulo.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._lblfondometaahorro.runMethod(true,"getLeft"),editarmetaahorro.mostCurrent._lblfondomontoahorro.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.1)}, "+*",1, 0)));
 BA.debugLineNum = 89;BA.debugLine="lblMetaAhorroTitulo.Gravity = Gravity.CENTER_VERT";
Debug.ShouldStop(16777216);
editarmetaahorro.mostCurrent._lblmetaahorrotitulo.runMethod(true,"setGravity",editarmetaahorro.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 91;BA.debugLine="txtNombre.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(67108864);
editarmetaahorro.mostCurrent._txtnombre.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 92;BA.debugLine="txtNombre.Height = alturaDispositivo * 0.06";
Debug.ShouldStop(134217728);
editarmetaahorro.mostCurrent._txtnombre.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro._alturadispositivo,RemoteObject.createImmutable(0.06)}, "*",0, 0)));
 BA.debugLineNum = 93;BA.debugLine="txtNombre.Top = txtMetaAhorro.Top + txtMetaAhorro";
Debug.ShouldStop(268435456);
editarmetaahorro.mostCurrent._txtnombre.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getTop"),editarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getHeight"),editarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 94;BA.debugLine="txtNombre.Left = (anchoDispositivo - txtNombre.Wi";
Debug.ShouldStop(536870912);
editarmetaahorro.mostCurrent._txtnombre.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editarmetaahorro._anchodispositivo,editarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 95;BA.debugLine="lblFondoNombre.Width = txtMetaAhorro.Width";
Debug.ShouldStop(1073741824);
editarmetaahorro.mostCurrent._lblfondonombre.runMethod(true,"setWidth",editarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getWidth"));
 BA.debugLineNum = 96;BA.debugLine="lblFondoNombre.Height = txtNombre.Height";
Debug.ShouldStop(-2147483648);
editarmetaahorro.mostCurrent._lblfondonombre.runMethod(true,"setHeight",editarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getHeight"));
 BA.debugLineNum = 97;BA.debugLine="lblFondoNombre.Top = txtNombre.Top";
Debug.ShouldStop(1);
editarmetaahorro.mostCurrent._lblfondonombre.runMethod(true,"setTop",editarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getTop"));
 BA.debugLineNum = 98;BA.debugLine="lblFondoNombre.Left = txtNombre.Left";
Debug.ShouldStop(2);
editarmetaahorro.mostCurrent._lblfondonombre.runMethod(true,"setLeft",editarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 100;BA.debugLine="txtDescripcion.Width = txtNombre.Width";
Debug.ShouldStop(8);
editarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"setWidth",editarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getWidth"));
 BA.debugLineNum = 101;BA.debugLine="txtDescripcion.Height = txtNombre.Height";
Debug.ShouldStop(16);
editarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"setHeight",editarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getHeight"));
 BA.debugLineNum = 102;BA.debugLine="txtDescripcion.Top = txtNombre.Top + txtNombre.He";
Debug.ShouldStop(32);
editarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getTop"),editarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getHeight"),editarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 103;BA.debugLine="txtDescripcion.Left = txtNombre.Left";
Debug.ShouldStop(64);
editarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"setLeft",editarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 104;BA.debugLine="lblFondoDescripcion.Width = txtDescripcion.Width";
Debug.ShouldStop(128);
editarmetaahorro.mostCurrent._lblfondodescripcion.runMethod(true,"setWidth",editarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"getWidth"));
 BA.debugLineNum = 105;BA.debugLine="lblFondoDescripcion.Height = txtDescripcion.Heigh";
Debug.ShouldStop(256);
editarmetaahorro.mostCurrent._lblfondodescripcion.runMethod(true,"setHeight",editarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"getHeight"));
 BA.debugLineNum = 106;BA.debugLine="lblFondoDescripcion.Top = txtDescripcion.Top";
Debug.ShouldStop(512);
editarmetaahorro.mostCurrent._lblfondodescripcion.runMethod(true,"setTop",editarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"getTop"));
 BA.debugLineNum = 107;BA.debugLine="lblFondoDescripcion.Left = txtDescripcion.Left";
Debug.ShouldStop(1024);
editarmetaahorro.mostCurrent._lblfondodescripcion.runMethod(true,"setLeft",editarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"getLeft"));
 BA.debugLineNum = 109;BA.debugLine="txtMontoAhorro.Width = txtMetaAhorro.Width";
Debug.ShouldStop(4096);
editarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"setWidth",editarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getWidth"));
 BA.debugLineNum = 110;BA.debugLine="txtMontoAhorro.Height = txtMetaAhorro.Height";
Debug.ShouldStop(8192);
editarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"setHeight",editarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getHeight"));
 BA.debugLineNum = 111;BA.debugLine="txtMontoAhorro.Top = txtDescripcion.Top + txtDesc";
Debug.ShouldStop(16384);
editarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"getTop"),editarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"getHeight"),editarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 112;BA.debugLine="txtMontoAhorro.Left = txtNombre.Left";
Debug.ShouldStop(32768);
editarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"setLeft",editarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getLeft"));
 BA.debugLineNum = 113;BA.debugLine="lblFondoMontoAhorro.Width = txtMontoAhorro.Width";
Debug.ShouldStop(65536);
editarmetaahorro.mostCurrent._lblfondomontoahorro.runMethod(true,"setWidth",editarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getWidth"));
 BA.debugLineNum = 114;BA.debugLine="lblFondoMontoAhorro.Height = txtMontoAhorro.Heigh";
Debug.ShouldStop(131072);
editarmetaahorro.mostCurrent._lblfondomontoahorro.runMethod(true,"setHeight",editarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getHeight"));
 BA.debugLineNum = 115;BA.debugLine="lblFondoMontoAhorro.Top = txtMontoAhorro.Top";
Debug.ShouldStop(262144);
editarmetaahorro.mostCurrent._lblfondomontoahorro.runMethod(true,"setTop",editarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getTop"));
 BA.debugLineNum = 116;BA.debugLine="lblFondoMontoAhorro.Left = txtMontoAhorro.Left";
Debug.ShouldStop(524288);
editarmetaahorro.mostCurrent._lblfondomontoahorro.runMethod(true,"setLeft",editarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getLeft"));
 BA.debugLineNum = 118;BA.debugLine="lblMontoAhorroTitulo.Width = lblFondoMontoAhorro.";
Debug.ShouldStop(2097152);
editarmetaahorro.mostCurrent._lblmontoahorrotitulo.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._lblfondomontoahorro.runMethod(true,"getWidth"),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 119;BA.debugLine="lblMontoAhorroTitulo.Height = stu.MeasureMultilin";
Debug.ShouldStop(4194304);
editarmetaahorro.mostCurrent._lblmontoahorrotitulo.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._stu.runMethod(true,"MeasureMultilineTextHeight",(Object)((editarmetaahorro.mostCurrent._lblmontoahorrotitulo.getObject())),(Object)(BA.ObjectToCharSequence(editarmetaahorro.mostCurrent._lblmontoahorrotitulo.runMethod(true,"getText")))),RemoteObject.createImmutable(2)}, "+",1, 1));
 BA.debugLineNum = 120;BA.debugLine="lblMontoAhorroTitulo.Top = lblFondoMontoAhorro.To";
Debug.ShouldStop(8388608);
editarmetaahorro.mostCurrent._lblmontoahorrotitulo.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._lblfondomontoahorro.runMethod(true,"getTop"),editarmetaahorro.mostCurrent._lblfondomontoahorro.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.05)}, "+*",1, 0)));
 BA.debugLineNum = 121;BA.debugLine="lblMontoAhorroTitulo.Left = lblFondoMontoAhorro.L";
Debug.ShouldStop(16777216);
editarmetaahorro.mostCurrent._lblmontoahorrotitulo.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._lblfondomontoahorro.runMethod(true,"getLeft"),editarmetaahorro.mostCurrent._lblfondomontoahorro.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.1)}, "+*",1, 0)));
 BA.debugLineNum = 122;BA.debugLine="lblMontoAhorroTitulo.Gravity = Gravity.CENTER_VER";
Debug.ShouldStop(33554432);
editarmetaahorro.mostCurrent._lblmontoahorrotitulo.runMethod(true,"setGravity",editarmetaahorro.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 124;BA.debugLine="pnlSelector.Top = txtMontoAhorro.Top + txtMontoAh";
Debug.ShouldStop(134217728);
editarmetaahorro.mostCurrent._pnlselector.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getTop"),editarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getHeight"),editarmetaahorro.mostCurrent._lblnombrevista.runMethod(true,"getTop"),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 125;BA.debugLine="pnlSelector.Left = txtMontoAhorro.Left + txtMonto";
Debug.ShouldStop(268435456);
editarmetaahorro.mostCurrent._pnlselector.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getLeft"),editarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getWidth"),editarmetaahorro.mostCurrent._pnlselector.runMethod(true,"getWidth")}, "+-",2, 1));
 BA.debugLineNum = 127;BA.debugLine="pnlPeriodos.Top = pnlSelector.Top";
Debug.ShouldStop(1073741824);
editarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"setTop",editarmetaahorro.mostCurrent._pnlselector.runMethod(true,"getTop"));
 BA.debugLineNum = 128;BA.debugLine="pnlPeriodos.Left = txtMontoAhorro.Left";
Debug.ShouldStop(-2147483648);
editarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"setLeft",editarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getLeft"));
 BA.debugLineNum = 129;BA.debugLine="pnlPeriodos.Width = (txtMontoAhorro.Width - pnlSe";
Debug.ShouldStop(1);
editarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getWidth"),editarmetaahorro.mostCurrent._pnlselector.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 130;BA.debugLine="pnlPeriodos.Height = pnlSelector.Height";
Debug.ShouldStop(2);
editarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"setHeight",editarmetaahorro.mostCurrent._pnlselector.runMethod(true,"getHeight"));
 BA.debugLineNum = 133;BA.debugLine="rd1Semana.Width = pnlPeriodos.Width";
Debug.ShouldStop(16);
editarmetaahorro.mostCurrent._rd1semana.runMethod(true,"setWidth",editarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"getWidth"));
 BA.debugLineNum = 134;BA.debugLine="rd1Semana.Height = pnlPeriodos.Height * 0.18";
Debug.ShouldStop(32);
editarmetaahorro.mostCurrent._rd1semana.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.18)}, "*",0, 0)));
 BA.debugLineNum = 135;BA.debugLine="rd1Semana.Left = 0";
Debug.ShouldStop(64);
editarmetaahorro.mostCurrent._rd1semana.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 136;BA.debugLine="rd1Semana.Top = 0";
Debug.ShouldStop(128);
editarmetaahorro.mostCurrent._rd1semana.runMethod(true,"setTop",BA.numberCast(int.class, 0));
 BA.debugLineNum = 138;BA.debugLine="rd2Semanas.Width = rd1Semana.Width";
Debug.ShouldStop(512);
editarmetaahorro.mostCurrent._rd2semanas.runMethod(true,"setWidth",editarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 139;BA.debugLine="rd2Semanas.Height = rd1Semana.Height";
Debug.ShouldStop(1024);
editarmetaahorro.mostCurrent._rd2semanas.runMethod(true,"setHeight",editarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 140;BA.debugLine="rd2Semanas.Left = rd1Semana.Left";
Debug.ShouldStop(2048);
editarmetaahorro.mostCurrent._rd2semanas.runMethod(true,"setLeft",editarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 141;BA.debugLine="rd2Semanas.Top = rd1Semana.Height + pnlPeriodos.H";
Debug.ShouldStop(4096);
editarmetaahorro.mostCurrent._rd2semanas.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getHeight"),editarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "+*",1, 0)));
 BA.debugLineNum = 143;BA.debugLine="rd3Semanas.Width = rd1Semana.Width";
Debug.ShouldStop(16384);
editarmetaahorro.mostCurrent._rd3semanas.runMethod(true,"setWidth",editarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 144;BA.debugLine="rd3Semanas.Height = rd1Semana.Height";
Debug.ShouldStop(32768);
editarmetaahorro.mostCurrent._rd3semanas.runMethod(true,"setHeight",editarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 145;BA.debugLine="rd3Semanas.Left = rd1Semana.Left";
Debug.ShouldStop(65536);
editarmetaahorro.mostCurrent._rd3semanas.runMethod(true,"setLeft",editarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 146;BA.debugLine="rd3Semanas.Top = rd2Semanas.Top + rd2Semanas.Heig";
Debug.ShouldStop(131072);
editarmetaahorro.mostCurrent._rd3semanas.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._rd2semanas.runMethod(true,"getTop"),editarmetaahorro.mostCurrent._rd2semanas.runMethod(true,"getHeight"),editarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "++*",2, 0)));
 BA.debugLineNum = 148;BA.debugLine="rd1Mes.Width = rd1Semana.Width";
Debug.ShouldStop(524288);
editarmetaahorro.mostCurrent._rd1mes.runMethod(true,"setWidth",editarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 149;BA.debugLine="rd1Mes.Height = rd1Semana.Height";
Debug.ShouldStop(1048576);
editarmetaahorro.mostCurrent._rd1mes.runMethod(true,"setHeight",editarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 150;BA.debugLine="rd1Mes.Left = rd1Semana.Left";
Debug.ShouldStop(2097152);
editarmetaahorro.mostCurrent._rd1mes.runMethod(true,"setLeft",editarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 151;BA.debugLine="rd1Mes.Top = rd3Semanas.Top + rd3Semanas.Height +";
Debug.ShouldStop(4194304);
editarmetaahorro.mostCurrent._rd1mes.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._rd3semanas.runMethod(true,"getTop"),editarmetaahorro.mostCurrent._rd3semanas.runMethod(true,"getHeight"),editarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "++*",2, 0)));
 BA.debugLineNum = 153;BA.debugLine="rd1Ano.Width = rd1Semana.Width";
Debug.ShouldStop(16777216);
editarmetaahorro.mostCurrent._rd1ano.runMethod(true,"setWidth",editarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getWidth"));
 BA.debugLineNum = 154;BA.debugLine="rd1Ano.Height = rd1Semana.Height";
Debug.ShouldStop(33554432);
editarmetaahorro.mostCurrent._rd1ano.runMethod(true,"setHeight",editarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getHeight"));
 BA.debugLineNum = 155;BA.debugLine="rd1Ano.Left = rd1Semana.Left";
Debug.ShouldStop(67108864);
editarmetaahorro.mostCurrent._rd1ano.runMethod(true,"setLeft",editarmetaahorro.mostCurrent._rd1semana.runMethod(true,"getLeft"));
 BA.debugLineNum = 156;BA.debugLine="rd1Ano.Top = rd1Mes.Top + rd1Mes.Height + pnlPeri";
Debug.ShouldStop(134217728);
editarmetaahorro.mostCurrent._rd1ano.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._rd1mes.runMethod(true,"getTop"),editarmetaahorro.mostCurrent._rd1mes.runMethod(true,"getHeight"),editarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.025)}, "++*",2, 0)));
 BA.debugLineNum = 161;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
Debug.ShouldStop(1);
editarmetaahorro.mostCurrent._pnlnavinferior.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro._alturadispositivo,RemoteObject.createImmutable(0.08)}, "*",0, 0)));
 BA.debugLineNum = 162;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
Debug.ShouldStop(2);
editarmetaahorro.mostCurrent._pnlnavinferior.runMethod(true,"setWidth",editarmetaahorro._anchodispositivo);
 BA.debugLineNum = 163;BA.debugLine="pnlNavInferior.Left = 0";
Debug.ShouldStop(4);
editarmetaahorro.mostCurrent._pnlnavinferior.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 164;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
Debug.ShouldStop(8);
editarmetaahorro.mostCurrent._pnlnavinferior.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {editarmetaahorro._alturadispositivo,editarmetaahorro.mostCurrent._pnlnavinferior.runMethod(true,"getHeight")}, "-",1, 1));
 BA.debugLineNum = 167;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
Debug.ShouldStop(64);
editarmetaahorro.mostCurrent._btnmenu.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro._anchodispositivo,RemoteObject.createImmutable(0.15)}, "*",0, 0)));
 BA.debugLineNum = 168;BA.debugLine="btnMenu.Height = btnMenu.Width";
Debug.ShouldStop(128);
editarmetaahorro.mostCurrent._btnmenu.runMethod(true,"setHeight",editarmetaahorro.mostCurrent._btnmenu.runMethod(true,"getWidth"));
 BA.debugLineNum = 169;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
Debug.ShouldStop(256);
editarmetaahorro.mostCurrent._btnmenu.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),editarmetaahorro.mostCurrent._btnmenu.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 170;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
Debug.ShouldStop(512);
editarmetaahorro.mostCurrent._btnmenu.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editarmetaahorro._anchodispositivo,editarmetaahorro.mostCurrent._btnmenu.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 172;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
Debug.ShouldStop(2048);
editarmetaahorro.mostCurrent._lblcontornoboton.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro._anchodispositivo,RemoteObject.createImmutable(0.17)}, "*",0, 0)));
 BA.debugLineNum = 173;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
Debug.ShouldStop(4096);
editarmetaahorro.mostCurrent._lblcontornoboton.runMethod(true,"setHeight",editarmetaahorro.mostCurrent._lblcontornoboton.runMethod(true,"getWidth"));
 BA.debugLineNum = 174;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
Debug.ShouldStop(8192);
editarmetaahorro.mostCurrent._lblcontornoboton.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editarmetaahorro._anchodispositivo,editarmetaahorro.mostCurrent._lblcontornoboton.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 175;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
Debug.ShouldStop(16384);
editarmetaahorro.mostCurrent._lblcontornoboton.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),editarmetaahorro.mostCurrent._lblcontornoboton.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 180;BA.debugLine="btnOperacionMetaAhorro.Text = \"Editar meta de aho";
Debug.ShouldStop(524288);
editarmetaahorro.mostCurrent._btnoperacionmetaahorro.runMethod(true,"setText",BA.ObjectToCharSequence("Editar meta de ahorro"));
 BA.debugLineNum = 181;BA.debugLine="btnOperacionMetaAhorro.Top = pnlPeriodos.Top + pn";
Debug.ShouldStop(1048576);
editarmetaahorro.mostCurrent._btnoperacionmetaahorro.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"getTop"),editarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._lblcontornoboton.runMethod(true,"getTop"),(RemoteObject.solve(new RemoteObject[] {editarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"getTop"),editarmetaahorro.mostCurrent._pnlperiodos.runMethod(true,"getHeight"),editarmetaahorro.mostCurrent._btnoperacionmetaahorro.runMethod(true,"getHeight")}, "++",2, 1))}, "-",1, 1)),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 182;BA.debugLine="btnOperacionMetaAhorro.Left = (anchoDispositivo -";
Debug.ShouldStop(2097152);
editarmetaahorro.mostCurrent._btnoperacionmetaahorro.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editarmetaahorro._anchodispositivo,editarmetaahorro.mostCurrent._btnoperacionmetaahorro.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (editarmetaahorro) ","editarmetaahorro",7,editarmetaahorro.mostCurrent.activityBA,editarmetaahorro.mostCurrent,188);
if (RapidSub.canDelegate("activity_pause")) { return pullup.wallet.editarmetaahorro.remoteMe.runUserSub(false, "editarmetaahorro","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 188;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 189;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Activity_Resume (editarmetaahorro) ","editarmetaahorro",7,editarmetaahorro.mostCurrent.activityBA,editarmetaahorro.mostCurrent,185);
if (RapidSub.canDelegate("activity_resume")) { return pullup.wallet.editarmetaahorro.remoteMe.runUserSub(false, "editarmetaahorro","activity_resume");}
 BA.debugLineNum = 185;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 186;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("asignacionCampos (editarmetaahorro) ","editarmetaahorro",7,editarmetaahorro.mostCurrent.activityBA,editarmetaahorro.mostCurrent,280);
if (RapidSub.canDelegate("asignacioncampos")) { return pullup.wallet.editarmetaahorro.remoteMe.runUserSub(false, "editarmetaahorro","asignacioncampos");}
RemoteObject _metaahorro = RemoteObject.declareNull("pullup.wallet.main._registrometaahorro");
 BA.debugLineNum = 280;BA.debugLine="Sub asignacionCampos As RegistroMetaAhorro";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 281;BA.debugLine="Dim metaAhorro As RegistroMetaAhorro";
Debug.ShouldStop(16777216);
_metaahorro = RemoteObject.createNew ("pullup.wallet.main._registrometaahorro");Debug.locals.put("metaAhorro", _metaahorro);
 BA.debugLineNum = 283;BA.debugLine="metaAhorro.montoMeta = txtMetaAhorro.Text";
Debug.ShouldStop(67108864);
_metaahorro.setField ("montoMeta" /*RemoteObject*/ ,BA.numberCast(int.class, editarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getText")));
 BA.debugLineNum = 285;BA.debugLine="metaAhorro.montoAhorro = txtMontoAhorro.Text";
Debug.ShouldStop(268435456);
_metaahorro.setField ("montoAhorro" /*RemoteObject*/ ,BA.numberCast(int.class, editarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getText")));
 BA.debugLineNum = 287;BA.debugLine="metaAhorro.nombre = txtNombre.Text";
Debug.ShouldStop(1073741824);
_metaahorro.setField ("nombre" /*RemoteObject*/ ,editarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getText"));
 BA.debugLineNum = 289;BA.debugLine="metaAhorro.descripcion = (txtDescripcion.Text)";
Debug.ShouldStop(1);
_metaahorro.setField ("descripcion" /*RemoteObject*/ ,(editarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"getText")));
 BA.debugLineNum = 291;BA.debugLine="metaAhorro.periodo = diasPeriodo";
Debug.ShouldStop(4);
_metaahorro.setField ("periodo" /*RemoteObject*/ ,editarmetaahorro._diasperiodo);
 BA.debugLineNum = 293;BA.debugLine="metaAhorro.progreso = 0";
Debug.ShouldStop(16);
_metaahorro.setField ("progreso" /*RemoteObject*/ ,BA.numberCast(int.class, 0));
 BA.debugLineNum = 295;BA.debugLine="metaAhorro.color = colorCaja";
Debug.ShouldStop(64);
_metaahorro.setField ("color" /*RemoteObject*/ ,editarmetaahorro._colorcaja);
 BA.debugLineNum = 297;BA.debugLine="Return metaAhorro";
Debug.ShouldStop(256);
if (true) return _metaahorro;
 BA.debugLineNum = 298;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("btnMenu_Click (editarmetaahorro) ","editarmetaahorro",7,editarmetaahorro.mostCurrent.activityBA,editarmetaahorro.mostCurrent,191);
if (RapidSub.canDelegate("btnmenu_click")) { return pullup.wallet.editarmetaahorro.remoteMe.runUserSub(false, "editarmetaahorro","btnmenu_click");}
 BA.debugLineNum = 191;BA.debugLine="Private Sub btnMenu_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 192;BA.debugLine="Activity.Finish";
Debug.ShouldStop(-2147483648);
editarmetaahorro.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 193;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("btnOperacionMetaAhorro_Click (editarmetaahorro) ","editarmetaahorro",7,editarmetaahorro.mostCurrent.activityBA,editarmetaahorro.mostCurrent,302);
if (RapidSub.canDelegate("btnoperacionmetaahorro_click")) { return pullup.wallet.editarmetaahorro.remoteMe.runUserSub(false, "editarmetaahorro","btnoperacionmetaahorro_click");}
RemoteObject _validaciones = RemoteObject.createImmutable(false);
RemoteObject _metaahorroregistrar = RemoteObject.declareNull("pullup.wallet.main._registrometaahorro");
 BA.debugLineNum = 302;BA.debugLine="Private Sub btnOperacionMetaAhorro_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 303;BA.debugLine="Dim validaciones As Boolean";
Debug.ShouldStop(16384);
_validaciones = RemoteObject.createImmutable(false);Debug.locals.put("validaciones", _validaciones);
 BA.debugLineNum = 305;BA.debugLine="validaciones = validarCampos";
Debug.ShouldStop(65536);
_validaciones = _validarcampos();Debug.locals.put("validaciones", _validaciones);
 BA.debugLineNum = 306;BA.debugLine="If(validaciones = True) Then";
Debug.ShouldStop(131072);
if ((RemoteObject.solveBoolean("=",_validaciones,editarmetaahorro.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 308;BA.debugLine="Dim metaAhorroRegistrar As RegistroMetaAhorro";
Debug.ShouldStop(524288);
_metaahorroregistrar = RemoteObject.createNew ("pullup.wallet.main._registrometaahorro");Debug.locals.put("metaAhorroRegistrar", _metaahorroregistrar);
 BA.debugLineNum = 309;BA.debugLine="metaAhorroRegistrar = asignacionCampos";
Debug.ShouldStop(1048576);
_metaahorroregistrar = _asignacioncampos();Debug.locals.put("metaAhorroRegistrar", _metaahorroregistrar);
 BA.debugLineNum = 312;BA.debugLine="Starter.sql.ExecNonQuery2(\"UPDATE metas_ahorro S";
Debug.ShouldStop(8388608);
editarmetaahorro.mostCurrent._starter._sql /*RemoteObject*/ .runVoidMethod ("ExecNonQuery2",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE metas_ahorro SET monto_meta = ?, nombre = ?, descripcion = ?, monto_ahorro = ?, periodo_ahorro = ?, color = ?  WHERE id_meta_ahorro = '"),editarmetaahorro._idregistro,RemoteObject.createImmutable("'"))),(Object)(editarmetaahorro.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {6},new Object[] {(_metaahorroregistrar.getField(true,"montoMeta" /*RemoteObject*/ )),(_metaahorroregistrar.getField(true,"nombre" /*RemoteObject*/ )),(_metaahorroregistrar.getField(true,"descripcion" /*RemoteObject*/ )),(_metaahorroregistrar.getField(true,"montoAhorro" /*RemoteObject*/ )),(_metaahorroregistrar.getField(true,"periodo" /*RemoteObject*/ )),(_metaahorroregistrar.getField(true,"color" /*RemoteObject*/ ))})))));
 BA.debugLineNum = 314;BA.debugLine="ToastMessageShow(\"Meta de ahorro editada\", True)";
Debug.ShouldStop(33554432);
editarmetaahorro.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Meta de ahorro editada")),(Object)(editarmetaahorro.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 316;BA.debugLine="Activity.Finish";
Debug.ShouldStop(134217728);
editarmetaahorro.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 318;BA.debugLine="StartActivity(MetasDeAhorro)";
Debug.ShouldStop(536870912);
editarmetaahorro.mostCurrent.__c.runVoidMethod ("StartActivity",editarmetaahorro.processBA,(Object)((editarmetaahorro.mostCurrent._metasdeahorro.getObject())));
 }else {
 BA.debugLineNum = 321;BA.debugLine="Msgbox2(\"Por favor, rellene todos los campos, se";
Debug.ShouldStop(1);
editarmetaahorro.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("Por favor, rellene todos los campos, seleccione un periodo y color")),(Object)(BA.ObjectToCharSequence("Registro incorrecto")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((editarmetaahorro.mostCurrent.__c.getField(false,"Null"))),editarmetaahorro.mostCurrent.activityBA);
 };
 BA.debugLineNum = 323;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("consultaAEditar (editarmetaahorro) ","editarmetaahorro",7,editarmetaahorro.mostCurrent.activityBA,editarmetaahorro.mostCurrent,326);
if (RapidSub.canDelegate("consultaaeditar")) { return pullup.wallet.editarmetaahorro.remoteMe.runUserSub(false, "editarmetaahorro","consultaaeditar", _rowid);}
RemoteObject _metaahorro = RemoteObject.declareNull("pullup.wallet.main._registrometaahorro");
Debug.locals.put("rowid", _rowid);
 BA.debugLineNum = 326;BA.debugLine="Sub consultaAEditar(rowid As Int)";
Debug.ShouldStop(32);
 BA.debugLineNum = 327;BA.debugLine="Dim metaAhorro As RegistroMetaAhorro";
Debug.ShouldStop(64);
_metaahorro = RemoteObject.createNew ("pullup.wallet.main._registrometaahorro");Debug.locals.put("metaAhorro", _metaahorro);
 BA.debugLineNum = 328;BA.debugLine="idRegistro = rowid";
Debug.ShouldStop(128);
editarmetaahorro._idregistro = _rowid;
 BA.debugLineNum = 330;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM metas_ahorro W";
Debug.ShouldStop(512);
editarmetaahorro.mostCurrent._cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), editarmetaahorro._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM metas_ahorro WHERE id_meta_ahorro = '"),editarmetaahorro._idregistro,RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 331;BA.debugLine="If(cur.RowCount > 0) Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean(">",editarmetaahorro.mostCurrent._cur.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 332;BA.debugLine="cur.Position = 0";
Debug.ShouldStop(2048);
editarmetaahorro.mostCurrent._cur.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 333;BA.debugLine="metaAhorro.nombre = cur.GetString(\"nombre\")";
Debug.ShouldStop(4096);
_metaahorro.setField ("nombre" /*RemoteObject*/ ,editarmetaahorro.mostCurrent._cur.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("nombre"))));
 BA.debugLineNum = 334;BA.debugLine="metaAhorro.montoMeta = cur.GetInt(\"monto_meta\")";
Debug.ShouldStop(8192);
_metaahorro.setField ("montoMeta" /*RemoteObject*/ ,editarmetaahorro.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("monto_meta"))));
 BA.debugLineNum = 335;BA.debugLine="metaAhorro.montoAhorro = cur.GetInt(\"monto_ahorr";
Debug.ShouldStop(16384);
_metaahorro.setField ("montoAhorro" /*RemoteObject*/ ,editarmetaahorro.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("monto_ahorro"))));
 BA.debugLineNum = 336;BA.debugLine="metaAhorro.descripcion = cur.GetString(\"descripc";
Debug.ShouldStop(32768);
_metaahorro.setField ("descripcion" /*RemoteObject*/ ,editarmetaahorro.mostCurrent._cur.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("descripcion"))));
 BA.debugLineNum = 337;BA.debugLine="metaAhorro.periodo = cur.GetInt(\"periodo_ahorro\"";
Debug.ShouldStop(65536);
_metaahorro.setField ("periodo" /*RemoteObject*/ ,editarmetaahorro.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("periodo_ahorro"))));
 BA.debugLineNum = 338;BA.debugLine="metaAhorro.color = cur.GetString(\"color\")";
Debug.ShouldStop(131072);
_metaahorro.setField ("color" /*RemoteObject*/ ,BA.numberCast(int.class, editarmetaahorro.mostCurrent._cur.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("color")))));
 BA.debugLineNum = 340;BA.debugLine="reasignarCamposAEditar(metaAhorro)";
Debug.ShouldStop(524288);
_reasignarcamposaeditar(_metaahorro);
 };
 BA.debugLineNum = 342;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("cpBarraColor_ColorChanged (editarmetaahorro) ","editarmetaahorro",7,editarmetaahorro.mostCurrent.activityBA,editarmetaahorro.mostCurrent,206);
if (RapidSub.canDelegate("cpbarracolor_colorchanged")) { return pullup.wallet.editarmetaahorro.remoteMe.runUserSub(false, "editarmetaahorro","cpbarracolor_colorchanged", _color);}
Debug.locals.put("color", _color);
 BA.debugLineNum = 206;BA.debugLine="Private Sub cpBarraColor_ColorChanged(color As Int";
Debug.ShouldStop(8192);
 BA.debugLineNum = 207;BA.debugLine="lblFondoMontoAhorro.Color = color";
Debug.ShouldStop(16384);
editarmetaahorro.mostCurrent._lblfondomontoahorro.runVoidMethod ("setColor",_color);
 BA.debugLineNum = 208;BA.debugLine="lblFondoMetaAhorro.Color = color";
Debug.ShouldStop(32768);
editarmetaahorro.mostCurrent._lblfondometaahorro.runVoidMethod ("setColor",_color);
 BA.debugLineNum = 209;BA.debugLine="colorCaja = color";
Debug.ShouldStop(65536);
editarmetaahorro._colorcaja = _color;
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 14;BA.debugLine="Dim alturaDispositivo As Int";
editarmetaahorro._alturadispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 15;BA.debugLine="Dim anchoDispositivo As Int";
editarmetaahorro._anchodispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 16;BA.debugLine="Dim colorCaja As Int";
editarmetaahorro._colorcaja = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 17;BA.debugLine="Dim diasPeriodo As Int";
editarmetaahorro._diasperiodo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 18;BA.debugLine="Dim aparicionMsgBox1 As Boolean";
editarmetaahorro._aparicionmsgbox1 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 19;BA.debugLine="Dim aparicionMsgBox2 As Boolean";
editarmetaahorro._aparicionmsgbox2 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 20;BA.debugLine="Dim aparicionMsgBox3 As Boolean";
editarmetaahorro._aparicionmsgbox3 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 21;BA.debugLine="Dim aparicionMsgBox4 As Boolean";
editarmetaahorro._aparicionmsgbox4 = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 22;BA.debugLine="Dim cur As Cursor";
editarmetaahorro.mostCurrent._cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Dim idRegistro As Int";
editarmetaahorro._idregistro = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 24;BA.debugLine="Dim stu As StringUtils";
editarmetaahorro.mostCurrent._stu = RemoteObject.createNew ("anywheresoftware.b4a.objects.StringUtils");
 //BA.debugLineNum = 28;BA.debugLine="Private btnMenu As Button";
editarmetaahorro.mostCurrent._btnmenu = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private btnOperacionMetaAhorro As Button";
editarmetaahorro.mostCurrent._btnoperacionmetaahorro = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private txtDescripcion As EditText";
editarmetaahorro.mostCurrent._txtdescripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private txtNombre As EditText";
editarmetaahorro.mostCurrent._txtnombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private txtMetaAhorro As EditText";
editarmetaahorro.mostCurrent._txtmetaahorro = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private txtMontoAhorro As EditText";
editarmetaahorro.mostCurrent._txtmontoahorro = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private lblFondoDescripcion As Label";
editarmetaahorro.mostCurrent._lblfondodescripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private lblFondoNombre As Label";
editarmetaahorro.mostCurrent._lblfondonombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private lblFondoMetaAhorro As Label";
editarmetaahorro.mostCurrent._lblfondometaahorro = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private lblFondoMontoAhorro As Label";
editarmetaahorro.mostCurrent._lblfondomontoahorro = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private lblContornoBoton As Label";
editarmetaahorro.mostCurrent._lblcontornoboton = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private lblNombreVista As Label";
editarmetaahorro.mostCurrent._lblnombrevista = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private lblMetaAhorroTitulo As Label";
editarmetaahorro.mostCurrent._lblmetaahorrotitulo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private lblMontoAhorroTitulo As Label";
editarmetaahorro.mostCurrent._lblmontoahorrotitulo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private pnlNavInferior As Panel";
editarmetaahorro.mostCurrent._pnlnavinferior = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private pnlPeriodos As Panel";
editarmetaahorro.mostCurrent._pnlperiodos = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private pnlSelector As Panel";
editarmetaahorro.mostCurrent._pnlselector = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private rd1Ano As RadioButton";
editarmetaahorro.mostCurrent._rd1ano = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private rd1Mes As RadioButton";
editarmetaahorro.mostCurrent._rd1mes = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private rd1Semana As RadioButton";
editarmetaahorro.mostCurrent._rd1semana = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private rd2Semanas As RadioButton";
editarmetaahorro.mostCurrent._rd2semanas = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private rd3Semanas As RadioButton";
editarmetaahorro.mostCurrent._rd3semanas = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private cpBarraColor As ASColorSlider  'Miembro g";
editarmetaahorro.mostCurrent._cpbarracolor = RemoteObject.createNew ("pullup.wallet.ascolorslider");
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _limitarlongitudentrada(RemoteObject _antiguo,RemoteObject _nuevo,RemoteObject _longitud,RemoteObject _view,RemoteObject _campo) throws Exception{
try {
		Debug.PushSubsStack("limitarLongitudEntrada (editarmetaahorro) ","editarmetaahorro",7,editarmetaahorro.mostCurrent.activityBA,editarmetaahorro.mostCurrent,214);
if (RapidSub.canDelegate("limitarlongitudentrada")) { return pullup.wallet.editarmetaahorro.remoteMe.runUserSub(false, "editarmetaahorro","limitarlongitudentrada", _antiguo, _nuevo, _longitud, _view, _campo);}
Debug.locals.put("antiguo", _antiguo);
Debug.locals.put("nuevo", _nuevo);
Debug.locals.put("longitud", _longitud);
Debug.locals.put("view", _view);
Debug.locals.put("campo", _campo);
 BA.debugLineNum = 214;BA.debugLine="Sub limitarLongitudEntrada(antiguo As String, nuev";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 215;BA.debugLine="If(nuevo.Length > longitud) Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean(">",_nuevo.runMethod(true,"length"),BA.numberCast(double.class, _longitud)))) { 
 BA.debugLineNum = 216;BA.debugLine="If(campo = \"montoAhorro\") Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("montoAhorro")))) { 
 BA.debugLineNum = 217;BA.debugLine="If(aparicionMsgBox1 = False) Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",editarmetaahorro._aparicionmsgbox1,editarmetaahorro.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 218;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
Debug.ShouldStop(33554432);
editarmetaahorro.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para el monto del ahorro es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((editarmetaahorro.mostCurrent.__c.getField(false,"Null"))),editarmetaahorro.mostCurrent.activityBA);
 BA.debugLineNum = 219;BA.debugLine="aparicionMsgBox1 = True";
Debug.ShouldStop(67108864);
editarmetaahorro._aparicionmsgbox1 = editarmetaahorro.mostCurrent.__c.getField(true,"True");
 };
 }else 
{ BA.debugLineNum = 221;BA.debugLine="Else If(campo = \"metaAhorro\") Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("metaAhorro")))) { 
 BA.debugLineNum = 222;BA.debugLine="If(aparicionMsgBox2 = False) Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",editarmetaahorro._aparicionmsgbox2,editarmetaahorro.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 223;BA.debugLine="Msgbox2(\"La longitud máxima permitida para la";
Debug.ShouldStop(1073741824);
editarmetaahorro.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para la monto meta es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((editarmetaahorro.mostCurrent.__c.getField(false,"Null"))),editarmetaahorro.mostCurrent.activityBA);
 BA.debugLineNum = 224;BA.debugLine="aparicionMsgBox2 = True";
Debug.ShouldStop(-2147483648);
editarmetaahorro._aparicionmsgbox2 = editarmetaahorro.mostCurrent.__c.getField(true,"True");
 };
 }else 
{ BA.debugLineNum = 226;BA.debugLine="Else If(campo = \"nombre\") Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("nombre")))) { 
 BA.debugLineNum = 227;BA.debugLine="If(aparicionMsgBox3 = False) Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",editarmetaahorro._aparicionmsgbox3,editarmetaahorro.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 228;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
Debug.ShouldStop(8);
editarmetaahorro.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para el nombre es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((editarmetaahorro.mostCurrent.__c.getField(false,"Null"))),editarmetaahorro.mostCurrent.activityBA);
 BA.debugLineNum = 229;BA.debugLine="aparicionMsgBox3 = True";
Debug.ShouldStop(16);
editarmetaahorro._aparicionmsgbox3 = editarmetaahorro.mostCurrent.__c.getField(true,"True");
 };
 }else 
{ BA.debugLineNum = 231;BA.debugLine="Else If(campo = \"descripcion\") Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",_campo,RemoteObject.createImmutable("descripcion")))) { 
 BA.debugLineNum = 232;BA.debugLine="If(aparicionMsgBox4 = False) Then";
Debug.ShouldStop(128);
if ((RemoteObject.solveBoolean("=",editarmetaahorro._aparicionmsgbox4,editarmetaahorro.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 233;BA.debugLine="Msgbox2(\"La longitud máxima permitida para la";
Debug.ShouldStop(256);
editarmetaahorro.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La longitud máxima permitida para la descripción es de "),_longitud,RemoteObject.createImmutable(" caracteres")))),(Object)(BA.ObjectToCharSequence("Límite alcanzado")),(Object)(BA.ObjectToString("Entendido")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((editarmetaahorro.mostCurrent.__c.getField(false,"Null"))),editarmetaahorro.mostCurrent.activityBA);
 BA.debugLineNum = 234;BA.debugLine="aparicionMsgBox4 = True";
Debug.ShouldStop(512);
editarmetaahorro._aparicionmsgbox4 = editarmetaahorro.mostCurrent.__c.getField(true,"True");
 };
 }}}}
;
 BA.debugLineNum = 237;BA.debugLine="view.Text = antiguo";
Debug.ShouldStop(4096);
_view.runMethod(true,"setText",BA.ObjectToCharSequence(_antiguo));
 };
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim sql As SQL";
editarmetaahorro._sql = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _rd1ano_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("rd1Ano_CheckedChange (editarmetaahorro) ","editarmetaahorro",7,editarmetaahorro.mostCurrent.activityBA,editarmetaahorro.mostCurrent,275);
if (RapidSub.canDelegate("rd1ano_checkedchange")) { return pullup.wallet.editarmetaahorro.remoteMe.runUserSub(false, "editarmetaahorro","rd1ano_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 275;BA.debugLine="Private Sub rd1Ano_CheckedChange(Checked As Boolea";
Debug.ShouldStop(262144);
 BA.debugLineNum = 276;BA.debugLine="diasPeriodo = 365";
Debug.ShouldStop(524288);
editarmetaahorro._diasperiodo = BA.numberCast(int.class, 365);
 BA.debugLineNum = 277;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("rd1Mes_CheckedChange (editarmetaahorro) ","editarmetaahorro",7,editarmetaahorro.mostCurrent.activityBA,editarmetaahorro.mostCurrent,271);
if (RapidSub.canDelegate("rd1mes_checkedchange")) { return pullup.wallet.editarmetaahorro.remoteMe.runUserSub(false, "editarmetaahorro","rd1mes_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 271;BA.debugLine="Private Sub rd1Mes_CheckedChange(Checked As Boolea";
Debug.ShouldStop(16384);
 BA.debugLineNum = 272;BA.debugLine="diasPeriodo = 30";
Debug.ShouldStop(32768);
editarmetaahorro._diasperiodo = BA.numberCast(int.class, 30);
 BA.debugLineNum = 273;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("rd1Semana_CheckedChange (editarmetaahorro) ","editarmetaahorro",7,editarmetaahorro.mostCurrent.activityBA,editarmetaahorro.mostCurrent,267);
if (RapidSub.canDelegate("rd1semana_checkedchange")) { return pullup.wallet.editarmetaahorro.remoteMe.runUserSub(false, "editarmetaahorro","rd1semana_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 267;BA.debugLine="Private Sub rd1Semana_CheckedChange(Checked As Boo";
Debug.ShouldStop(1024);
 BA.debugLineNum = 268;BA.debugLine="diasPeriodo = 7";
Debug.ShouldStop(2048);
editarmetaahorro._diasperiodo = BA.numberCast(int.class, 7);
 BA.debugLineNum = 269;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("rd2Semanas_CheckedChange (editarmetaahorro) ","editarmetaahorro",7,editarmetaahorro.mostCurrent.activityBA,editarmetaahorro.mostCurrent,263);
if (RapidSub.canDelegate("rd2semanas_checkedchange")) { return pullup.wallet.editarmetaahorro.remoteMe.runUserSub(false, "editarmetaahorro","rd2semanas_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 263;BA.debugLine="Private Sub rd2Semanas_CheckedChange(Checked As Bo";
Debug.ShouldStop(64);
 BA.debugLineNum = 264;BA.debugLine="diasPeriodo = 14";
Debug.ShouldStop(128);
editarmetaahorro._diasperiodo = BA.numberCast(int.class, 14);
 BA.debugLineNum = 265;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("rd3Semanas_CheckedChange (editarmetaahorro) ","editarmetaahorro",7,editarmetaahorro.mostCurrent.activityBA,editarmetaahorro.mostCurrent,259);
if (RapidSub.canDelegate("rd3semanas_checkedchange")) { return pullup.wallet.editarmetaahorro.remoteMe.runUserSub(false, "editarmetaahorro","rd3semanas_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 259;BA.debugLine="Private Sub rd3Semanas_CheckedChange(Checked As Bo";
Debug.ShouldStop(4);
 BA.debugLineNum = 260;BA.debugLine="diasPeriodo = 21";
Debug.ShouldStop(8);
editarmetaahorro._diasperiodo = BA.numberCast(int.class, 21);
 BA.debugLineNum = 261;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("reasignarCamposAEditar (editarmetaahorro) ","editarmetaahorro",7,editarmetaahorro.mostCurrent.activityBA,editarmetaahorro.mostCurrent,345);
if (RapidSub.canDelegate("reasignarcamposaeditar")) { return pullup.wallet.editarmetaahorro.remoteMe.runUserSub(false, "editarmetaahorro","reasignarcamposaeditar", _registro);}
Debug.locals.put("registro", _registro);
 BA.debugLineNum = 345;BA.debugLine="Sub reasignarCamposAEditar(registro As RegistroMet";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 346;BA.debugLine="txtNombre.Text = registro.nombre";
Debug.ShouldStop(33554432);
editarmetaahorro.mostCurrent._txtnombre.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_registro.getField(true,"nombre" /*RemoteObject*/ )));
 BA.debugLineNum = 347;BA.debugLine="txtMetaAhorro.Text = registro.montoMeta";
Debug.ShouldStop(67108864);
editarmetaahorro.mostCurrent._txtmetaahorro.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_registro.getField(true,"montoMeta" /*RemoteObject*/ )));
 BA.debugLineNum = 348;BA.debugLine="txtMontoAhorro.Text = registro.montoAhorro";
Debug.ShouldStop(134217728);
editarmetaahorro.mostCurrent._txtmontoahorro.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_registro.getField(true,"montoAhorro" /*RemoteObject*/ )));
 BA.debugLineNum = 349;BA.debugLine="txtDescripcion.Text = registro.descripcion";
Debug.ShouldStop(268435456);
editarmetaahorro.mostCurrent._txtdescripcion.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_registro.getField(true,"descripcion" /*RemoteObject*/ )));
 BA.debugLineNum = 350;BA.debugLine="Select registro.periodo";
Debug.ShouldStop(536870912);
switch (BA.switchObjectToInt(_registro.getField(true,"periodo" /*RemoteObject*/ ),BA.numberCast(int.class, 7),BA.numberCast(int.class, 14),BA.numberCast(int.class, 21),BA.numberCast(int.class, 30),BA.numberCast(int.class, 365))) {
case 0: {
 BA.debugLineNum = 352;BA.debugLine="rd1Semana.Checked = True";
Debug.ShouldStop(-2147483648);
editarmetaahorro.mostCurrent._rd1semana.runMethodAndSync(true,"setChecked",editarmetaahorro.mostCurrent.__c.getField(true,"True"));
 break; }
case 1: {
 BA.debugLineNum = 354;BA.debugLine="rd2Semanas.Checked = True";
Debug.ShouldStop(2);
editarmetaahorro.mostCurrent._rd2semanas.runMethodAndSync(true,"setChecked",editarmetaahorro.mostCurrent.__c.getField(true,"True"));
 break; }
case 2: {
 BA.debugLineNum = 356;BA.debugLine="rd3Semanas.Checked = True";
Debug.ShouldStop(8);
editarmetaahorro.mostCurrent._rd3semanas.runMethodAndSync(true,"setChecked",editarmetaahorro.mostCurrent.__c.getField(true,"True"));
 break; }
case 3: {
 BA.debugLineNum = 358;BA.debugLine="rd1Mes.Checked = True";
Debug.ShouldStop(32);
editarmetaahorro.mostCurrent._rd1mes.runMethodAndSync(true,"setChecked",editarmetaahorro.mostCurrent.__c.getField(true,"True"));
 break; }
case 4: {
 BA.debugLineNum = 360;BA.debugLine="rd1Ano.Checked = True";
Debug.ShouldStop(128);
editarmetaahorro.mostCurrent._rd1ano.runMethodAndSync(true,"setChecked",editarmetaahorro.mostCurrent.__c.getField(true,"True"));
 break; }
}
;
 BA.debugLineNum = 362;BA.debugLine="diasPeriodo = registro.periodo";
Debug.ShouldStop(512);
editarmetaahorro._diasperiodo = _registro.getField(true,"periodo" /*RemoteObject*/ );
 BA.debugLineNum = 363;BA.debugLine="cpBarraColor_ColorChanged(registro.color)";
Debug.ShouldStop(1024);
_cpbarracolor_colorchanged(_registro.getField(true,"color" /*RemoteObject*/ ));
 BA.debugLineNum = 364;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("txtDescripcion_TextChanged (editarmetaahorro) ","editarmetaahorro",7,editarmetaahorro.mostCurrent.activityBA,editarmetaahorro.mostCurrent,254);
if (RapidSub.canDelegate("txtdescripcion_textchanged")) { return pullup.wallet.editarmetaahorro.remoteMe.runUserSub(false, "editarmetaahorro","txtdescripcion_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 254;BA.debugLine="Private Sub txtDescripcion_TextChanged (Old As Str";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 255;BA.debugLine="limitarLongitudEntrada(Old, New, 41, txtDescripci";
Debug.ShouldStop(1073741824);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 41),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), editarmetaahorro.mostCurrent._txtdescripcion.getObject()),RemoteObject.createImmutable("descripcion"));
 BA.debugLineNum = 256;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("txtMetaAhorro_TextChanged (editarmetaahorro) ","editarmetaahorro",7,editarmetaahorro.mostCurrent.activityBA,editarmetaahorro.mostCurrent,250);
if (RapidSub.canDelegate("txtmetaahorro_textchanged")) { return pullup.wallet.editarmetaahorro.remoteMe.runUserSub(false, "editarmetaahorro","txtmetaahorro_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 250;BA.debugLine="Private Sub txtMetaAhorro_TextChanged (Old As Stri";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 251;BA.debugLine="limitarLongitudEntrada(Old, New, 9, txtMetaAhorro";
Debug.ShouldStop(67108864);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 9),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), editarmetaahorro.mostCurrent._txtmetaahorro.getObject()),RemoteObject.createImmutable("metaAhorro"));
 BA.debugLineNum = 252;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("txtMontoAhorro_TextChanged (editarmetaahorro) ","editarmetaahorro",7,editarmetaahorro.mostCurrent.activityBA,editarmetaahorro.mostCurrent,246);
if (RapidSub.canDelegate("txtmontoahorro_textchanged")) { return pullup.wallet.editarmetaahorro.remoteMe.runUserSub(false, "editarmetaahorro","txtmontoahorro_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 246;BA.debugLine="Private Sub txtMontoAhorro_TextChanged (Old As Str";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 247;BA.debugLine="limitarLongitudEntrada(Old ,New, 9, txtMontoAhorr";
Debug.ShouldStop(4194304);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 9),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), editarmetaahorro.mostCurrent._txtmontoahorro.getObject()),RemoteObject.createImmutable("montoAhorro"));
 BA.debugLineNum = 248;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("txtNombre_TextChanged (editarmetaahorro) ","editarmetaahorro",7,editarmetaahorro.mostCurrent.activityBA,editarmetaahorro.mostCurrent,242);
if (RapidSub.canDelegate("txtnombre_textchanged")) { return pullup.wallet.editarmetaahorro.remoteMe.runUserSub(false, "editarmetaahorro","txtnombre_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 242;BA.debugLine="Private Sub txtNombre_TextChanged (Old As String,";
Debug.ShouldStop(131072);
 BA.debugLineNum = 243;BA.debugLine="limitarLongitudEntrada(Old, New, 16, txtNombre, \"";
Debug.ShouldStop(262144);
_limitarlongitudentrada(_old,_new,BA.numberCast(int.class, 16),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), editarmetaahorro.mostCurrent._txtnombre.getObject()),RemoteObject.createImmutable("nombre"));
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
public static RemoteObject  _validarcampos() throws Exception{
try {
		Debug.PushSubsStack("validarCampos (editarmetaahorro) ","editarmetaahorro",7,editarmetaahorro.mostCurrent.activityBA,editarmetaahorro.mostCurrent,196);
if (RapidSub.canDelegate("validarcampos")) { return pullup.wallet.editarmetaahorro.remoteMe.runUserSub(false, "editarmetaahorro","validarcampos");}
 BA.debugLineNum = 196;BA.debugLine="Sub validarCampos As Boolean";
Debug.ShouldStop(8);
 BA.debugLineNum = 197;BA.debugLine="If(txtMetaAhorro.Text.Length <> 0 And txtNombre.T";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("!",editarmetaahorro.mostCurrent._txtmetaahorro.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",editarmetaahorro.mostCurrent._txtnombre.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",editarmetaahorro.mostCurrent._txtmontoahorro.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",editarmetaahorro.mostCurrent._txtdescripcion.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",editarmetaahorro._colorcaja,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("!",editarmetaahorro._diasperiodo,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 198;BA.debugLine="Return True";
Debug.ShouldStop(32);
if (true) return editarmetaahorro.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 200;BA.debugLine="Return False";
Debug.ShouldStop(128);
if (true) return editarmetaahorro.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 202;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}