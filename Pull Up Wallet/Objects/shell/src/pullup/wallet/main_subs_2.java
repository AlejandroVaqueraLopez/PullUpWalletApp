package pullup.wallet;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_2 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,81);
if (RapidSub.canDelegate("activity_create")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 81;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 82;BA.debugLine="sql = Starter.sql";
Debug.ShouldStop(131072);
main._sql = main.mostCurrent._starter._sql /*RemoteObject*/ ;
 BA.debugLineNum = 83;BA.debugLine="verificarPrimerIngreso";
Debug.ShouldStop(262144);
_verificarprimeringreso();
 BA.debugLineNum = 84;BA.debugLine="If(FirstTime = True) Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",_firsttime,main.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 85;BA.debugLine="cobraIngresos";
Debug.ShouldStop(1048576);
_cobraingresos();
 BA.debugLineNum = 86;BA.debugLine="realizaEgresos";
Debug.ShouldStop(2097152);
_realizaegresos();
 };
 BA.debugLineNum = 88;BA.debugLine="Activity.LoadLayout(\"LMain\")";
Debug.ShouldStop(8388608);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("LMain")),main.mostCurrent.activityBA);
 BA.debugLineNum = 89;BA.debugLine="Activity.Color = Colors.ARGB(255, 233, 236, 239)";
Debug.ShouldStop(16777216);
main.mostCurrent._activity.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 233)),(Object)(BA.numberCast(int.class, 236)),(Object)(BA.numberCast(int.class, 239))));
 BA.debugLineNum = 90;BA.debugLine="alturaDispositivo = GetDeviceLayoutValues.Height";
Debug.ShouldStop(33554432);
main._alturadispositivo = main.mostCurrent.__c.runMethod(false,"GetDeviceLayoutValues",main.mostCurrent.activityBA).getField(true,"Height");
 BA.debugLineNum = 91;BA.debugLine="anchoDispositivo = GetDeviceLayoutValues.Width";
Debug.ShouldStop(67108864);
main._anchodispositivo = main.mostCurrent.__c.runMethod(false,"GetDeviceLayoutValues",main.mostCurrent.activityBA).getField(true,"Width");
 BA.debugLineNum = 92;BA.debugLine="click = False";
Debug.ShouldStop(134217728);
main._click = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 93;BA.debugLine="ingresos = balanceActualIngresos";
Debug.ShouldStop(268435456);
main._ingresos = _balanceactualingresos();
 BA.debugLineNum = 94;BA.debugLine="egresos = balanceActualEgresos";
Debug.ShouldStop(536870912);
main._egresos = _balanceactualegresos();
 BA.debugLineNum = 95;BA.debugLine="balance = balanceGeneral";
Debug.ShouldStop(1073741824);
main._balance = _balancegeneral();
 BA.debugLineNum = 98;BA.debugLine="pnlCabecera.Height = alturaDispositivo * 0.07";
Debug.ShouldStop(2);
main.mostCurrent._pnlcabecera.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main._alturadispositivo,RemoteObject.createImmutable(0.07)}, "*",0, 0)));
 BA.debugLineNum = 99;BA.debugLine="pnlCabecera.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(4);
main.mostCurrent._pnlcabecera.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 100;BA.debugLine="pnlCabecera.Left = (anchoDispositivo - pnlCabecer";
Debug.ShouldStop(8);
main.mostCurrent._pnlcabecera.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main._anchodispositivo,main.mostCurrent._pnlcabecera.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 103;BA.debugLine="lblEstado.Height = pnlCabecera.Height";
Debug.ShouldStop(64);
main.mostCurrent._lblestado.runMethod(true,"setHeight",main.mostCurrent._pnlcabecera.runMethod(true,"getHeight"));
 BA.debugLineNum = 104;BA.debugLine="lblEstado.Width = lblEstado.Height";
Debug.ShouldStop(128);
main.mostCurrent._lblestado.runMethod(true,"setWidth",main.mostCurrent._lblestado.runMethod(true,"getHeight"));
 BA.debugLineNum = 105;BA.debugLine="lblEstado.Color = Colors.Transparent";
Debug.ShouldStop(256);
main.mostCurrent._lblestado.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 106;BA.debugLine="lblEstado.TextSize = 24";
Debug.ShouldStop(512);
main.mostCurrent._lblestado.runMethod(true,"setTextSize",BA.numberCast(float.class, 24));
 BA.debugLineNum = 107;BA.debugLine="lblEstado.Gravity = Gravity.CENTER";
Debug.ShouldStop(1024);
main.mostCurrent._lblestado.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 108;BA.debugLine="estadoBalance(balance)";
Debug.ShouldStop(2048);
_estadobalance(main._balance);
 BA.debugLineNum = 113;BA.debugLine="pnlBalance.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(65536);
main.mostCurrent._pnlbalance.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 114;BA.debugLine="pnlBalance.Height = alturaDispositivo * 0.2";
Debug.ShouldStop(131072);
main.mostCurrent._pnlbalance.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main._alturadispositivo,RemoteObject.createImmutable(0.2)}, "*",0, 0)));
 BA.debugLineNum = 115;BA.debugLine="pnlBalance.Left = (anchoDispositivo - pnlBalance.";
Debug.ShouldStop(262144);
main.mostCurrent._pnlbalance.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main._anchodispositivo,main.mostCurrent._pnlbalance.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 116;BA.debugLine="pnlBalance.Top = pnlCabecera.Top + pnlCabecera.He";
Debug.ShouldStop(524288);
main.mostCurrent._pnlbalance.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pnlcabecera.runMethod(true,"getTop"),main.mostCurrent._pnlcabecera.runMethod(true,"getHeight"),RemoteObject.createImmutable(50)}, "++",2, 1));
 BA.debugLineNum = 120;BA.debugLine="lblBalanceTitulo.Top = pnlBalance.Height * 0.05";
Debug.ShouldStop(8388608);
main.mostCurrent._lblbalancetitulo.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pnlbalance.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.05)}, "*",0, 0)));
 BA.debugLineNum = 121;BA.debugLine="lblBalanceTitulo.Gravity = Gravity.CENTER_HORIZON";
Debug.ShouldStop(16777216);
main.mostCurrent._lblbalancetitulo.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL"));
 BA.debugLineNum = 123;BA.debugLine="lblBalance.Top = lblBalanceTitulo.Top + lblBalanc";
Debug.ShouldStop(67108864);
main.mostCurrent._lblbalance.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lblbalancetitulo.runMethod(true,"getTop"),main.mostCurrent._lblbalancetitulo.runMethod(true,"getHeight")}, "+",1, 1));
 BA.debugLineNum = 124;BA.debugLine="lblBalance.Gravity = Gravity.CENTER_HORIZONTAL";
Debug.ShouldStop(134217728);
main.mostCurrent._lblbalance.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL"));
 BA.debugLineNum = 125;BA.debugLine="lblBalance.Text = \"$\" & balance & \".00\"";
Debug.ShouldStop(268435456);
main.mostCurrent._lblbalance.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("$"),main._balance,RemoteObject.createImmutable(".00"))));
 BA.debugLineNum = 126;BA.debugLine="lblBalance.TextSize = 16";
Debug.ShouldStop(536870912);
main.mostCurrent._lblbalance.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 128;BA.debugLine="lblIconoIngresos.Left = lblBalanceTitulo.Top";
Debug.ShouldStop(-2147483648);
main.mostCurrent._lbliconoingresos.runMethod(true,"setLeft",main.mostCurrent._lblbalancetitulo.runMethod(true,"getTop"));
 BA.debugLineNum = 129;BA.debugLine="lblIconoIngresos.Top = pnlBalance.Height * 0.35";
Debug.ShouldStop(1);
main.mostCurrent._lbliconoingresos.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pnlbalance.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.35)}, "*",0, 0)));
 BA.debugLineNum = 131;BA.debugLine="lblIngresos.Height = lblIconoIngresos.Height";
Debug.ShouldStop(4);
main.mostCurrent._lblingresos.runMethod(true,"setHeight",main.mostCurrent._lbliconoingresos.runMethod(true,"getHeight"));
 BA.debugLineNum = 132;BA.debugLine="lblIngresos.Width = (pnlBalance.Width / 2) - (lbl";
Debug.ShouldStop(8);
main.mostCurrent._lblingresos.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pnlbalance.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0)),(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lbliconoingresos.runMethod(true,"getLeft"),RemoteObject.createImmutable(2),main.mostCurrent._lbliconoingresos.runMethod(true,"getWidth")}, "*+",1, 1))}, "-",1, 0)));
 BA.debugLineNum = 133;BA.debugLine="lblIngresos.Left = lblIconoIngresos.Left * 2 + lb";
Debug.ShouldStop(16);
main.mostCurrent._lblingresos.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lbliconoingresos.runMethod(true,"getLeft"),RemoteObject.createImmutable(2),main.mostCurrent._lbliconoingresos.runMethod(true,"getWidth")}, "*+",1, 1));
 BA.debugLineNum = 134;BA.debugLine="lblIngresos.Top = lblIconoIngresos.Top";
Debug.ShouldStop(32);
main.mostCurrent._lblingresos.runMethod(true,"setTop",main.mostCurrent._lbliconoingresos.runMethod(true,"getTop"));
 BA.debugLineNum = 135;BA.debugLine="lblIngresos.Text = \"$\" & ingresos & \".00\"";
Debug.ShouldStop(64);
main.mostCurrent._lblingresos.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("$"),main._ingresos,RemoteObject.createImmutable(".00"))));
 BA.debugLineNum = 136;BA.debugLine="lblIngresos.TextSize = 13";
Debug.ShouldStop(128);
main.mostCurrent._lblingresos.runMethod(true,"setTextSize",BA.numberCast(float.class, 13));
 BA.debugLineNum = 138;BA.debugLine="lblIconoEgresos.Left = pnlBalance.Width / 2 + lbl";
Debug.ShouldStop(512);
main.mostCurrent._lbliconoegresos.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pnlbalance.runMethod(true,"getWidth"),RemoteObject.createImmutable(2),main.mostCurrent._lbliconoingresos.runMethod(true,"getLeft")}, "/+",1, 0)));
 BA.debugLineNum = 139;BA.debugLine="lblIconoEgresos.Top = lblIconoIngresos.Top";
Debug.ShouldStop(1024);
main.mostCurrent._lbliconoegresos.runMethod(true,"setTop",main.mostCurrent._lbliconoingresos.runMethod(true,"getTop"));
 BA.debugLineNum = 141;BA.debugLine="lblEgresos.Height = lblIconoEgresos.Height";
Debug.ShouldStop(4096);
main.mostCurrent._lblegresos.runMethod(true,"setHeight",main.mostCurrent._lbliconoegresos.runMethod(true,"getHeight"));
 BA.debugLineNum = 142;BA.debugLine="lblEgresos.Width = lblIngresos.Width";
Debug.ShouldStop(8192);
main.mostCurrent._lblegresos.runMethod(true,"setWidth",main.mostCurrent._lblingresos.runMethod(true,"getWidth"));
 BA.debugLineNum = 143;BA.debugLine="lblEgresos.Left = lblIconoEgresos.Left + lblIcono";
Debug.ShouldStop(16384);
main.mostCurrent._lblegresos.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lbliconoegresos.runMethod(true,"getLeft"),main.mostCurrent._lbliconoegresos.runMethod(true,"getWidth"),main.mostCurrent._lbliconoingresos.runMethod(true,"getLeft")}, "++",2, 1));
 BA.debugLineNum = 144;BA.debugLine="lblEgresos.Top = lblIconoEgresos.Top";
Debug.ShouldStop(32768);
main.mostCurrent._lblegresos.runMethod(true,"setTop",main.mostCurrent._lbliconoegresos.runMethod(true,"getTop"));
 BA.debugLineNum = 145;BA.debugLine="lblEgresos.Text = \"$\" & egresos & \".00\"";
Debug.ShouldStop(65536);
main.mostCurrent._lblegresos.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("$"),main._egresos,RemoteObject.createImmutable(".00"))));
 BA.debugLineNum = 146;BA.debugLine="lblEgresos.TextSize = 13";
Debug.ShouldStop(131072);
main.mostCurrent._lblegresos.runMethod(true,"setTextSize",BA.numberCast(float.class, 13));
 BA.debugLineNum = 149;BA.debugLine="btnGenerarHistorial.TextSize = 14";
Debug.ShouldStop(1048576);
main.mostCurrent._btngenerarhistorial.runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 150;BA.debugLine="btnGenerarHistorial.Height = (pnlBalance.Height -";
Debug.ShouldStop(2097152);
main.mostCurrent._btngenerarhistorial.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pnlbalance.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lblegresos.runMethod(true,"getTop"),main.mostCurrent._lblegresos.runMethod(true,"getHeight")}, "+",1, 1))}, "-",1, 1)),RemoteObject.createImmutable(0.8)}, "*",0, 0)));
 BA.debugLineNum = 151;BA.debugLine="btnGenerarHistorial.Width = pnlBalance.Width * 0.";
Debug.ShouldStop(4194304);
main.mostCurrent._btngenerarhistorial.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pnlbalance.runMethod(true,"getWidth"),RemoteObject.createImmutable(0.4)}, "*",0, 0)));
 BA.debugLineNum = 152;BA.debugLine="btnGenerarHistorial.Top = lblIconoIngresos.Top +";
Debug.ShouldStop(8388608);
main.mostCurrent._btngenerarhistorial.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lbliconoingresos.runMethod(true,"getTop"),main.mostCurrent._lbliconoingresos.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pnlbalance.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lblegresos.runMethod(true,"getTop"),main.mostCurrent._lblegresos.runMethod(true,"getHeight"),main.mostCurrent._btngenerarhistorial.runMethod(true,"getHeight")}, "++",2, 1))}, "-",1, 1)),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 153;BA.debugLine="btnGenerarHistorial.Left = ((pnlBalance.Width / 2";
Debug.ShouldStop(16777216);
main.mostCurrent._btngenerarhistorial.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pnlbalance.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0)),main.mostCurrent._btngenerarhistorial.runMethod(true,"getWidth")}, "-",1, 0)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 155;BA.debugLine="btnHistoriales.TextSize = 14";
Debug.ShouldStop(67108864);
main.mostCurrent._btnhistoriales.runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 156;BA.debugLine="btnHistoriales.Height = btnGenerarHistorial.Heigh";
Debug.ShouldStop(134217728);
main.mostCurrent._btnhistoriales.runMethod(true,"setHeight",main.mostCurrent._btngenerarhistorial.runMethod(true,"getHeight"));
 BA.debugLineNum = 157;BA.debugLine="btnHistoriales.Width = btnGenerarHistorial.Width";
Debug.ShouldStop(268435456);
main.mostCurrent._btnhistoriales.runMethod(true,"setWidth",main.mostCurrent._btngenerarhistorial.runMethod(true,"getWidth"));
 BA.debugLineNum = 158;BA.debugLine="btnHistoriales.Top = btnGenerarHistorial.Top";
Debug.ShouldStop(536870912);
main.mostCurrent._btnhistoriales.runMethod(true,"setTop",main.mostCurrent._btngenerarhistorial.runMethod(true,"getTop"));
 BA.debugLineNum = 159;BA.debugLine="btnHistoriales.Left = (pnlBalance.Width / 2) + bt";
Debug.ShouldStop(1073741824);
main.mostCurrent._btnhistoriales.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pnlbalance.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0)),main.mostCurrent._btngenerarhistorial.runMethod(true,"getLeft")}, "+",1, 0)));
 BA.debugLineNum = 164;BA.debugLine="pnlOpciones.Height = alturaDispositivo * 0.5";
Debug.ShouldStop(8);
main.mostCurrent._pnlopciones.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main._alturadispositivo,RemoteObject.createImmutable(0.5)}, "*",0, 0)));
 BA.debugLineNum = 165;BA.debugLine="pnlOpciones.Width = anchoDispositivo * 0.9";
Debug.ShouldStop(16);
main.mostCurrent._pnlopciones.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main._anchodispositivo,RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 166;BA.debugLine="pnlOpciones.Left = pnlCabecera.Left";
Debug.ShouldStop(32);
main.mostCurrent._pnlopciones.runMethod(true,"setLeft",main.mostCurrent._pnlcabecera.runMethod(true,"getLeft"));
 BA.debugLineNum = 167;BA.debugLine="pnlOpciones.Top = pnlBalance.Top + pnlBalance.Hei";
Debug.ShouldStop(64);
main.mostCurrent._pnlopciones.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pnlbalance.runMethod(true,"getTop"),main.mostCurrent._pnlbalance.runMethod(true,"getHeight"),RemoteObject.createImmutable(50)}, "++",2, 1));
 BA.debugLineNum = 170;BA.debugLine="lblExplora.Width = anchoDispositivo * 0.8";
Debug.ShouldStop(512);
main.mostCurrent._lblexplora.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main._anchodispositivo,RemoteObject.createImmutable(0.8)}, "*",0, 0)));
 BA.debugLineNum = 171;BA.debugLine="lblExplora.Left = (pnlOpciones.Width - lblExplora";
Debug.ShouldStop(1024);
main.mostCurrent._lblexplora.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pnlopciones.runMethod(true,"getWidth"),main.mostCurrent._lblexplora.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 172;BA.debugLine="lblExplora.Top = lblExplora.Left";
Debug.ShouldStop(2048);
main.mostCurrent._lblexplora.runMethod(true,"setTop",main.mostCurrent._lblexplora.runMethod(true,"getLeft"));
 BA.debugLineNum = 173;BA.debugLine="lblExplora.TextSize = 16";
Debug.ShouldStop(4096);
main.mostCurrent._lblexplora.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 176;BA.debugLine="btnIngresosRecurrentes.Top = lblExplora.Top * 2 +";
Debug.ShouldStop(32768);
main.mostCurrent._btningresosrecurrentes.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lblexplora.runMethod(true,"getTop"),RemoteObject.createImmutable(2),main.mostCurrent._lblexplora.runMethod(true,"getHeight")}, "*+",1, 1));
 BA.debugLineNum = 177;BA.debugLine="btnIngresosRecurrentes.Left = lblExplora.Left";
Debug.ShouldStop(65536);
main.mostCurrent._btningresosrecurrentes.runMethod(true,"setLeft",main.mostCurrent._lblexplora.runMethod(true,"getLeft"));
 BA.debugLineNum = 178;BA.debugLine="btnIngresosRecurrentes.Width = lblExplora.Width";
Debug.ShouldStop(131072);
main.mostCurrent._btningresosrecurrentes.runMethod(true,"setWidth",main.mostCurrent._lblexplora.runMethod(true,"getWidth"));
 BA.debugLineNum = 179;BA.debugLine="btnIngresosRecurrentes.Height = ((pnlOpciones.Hei";
Debug.ShouldStop(262144);
main.mostCurrent._btningresosrecurrentes.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pnlopciones.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lblexplora.runMethod(true,"getTop"),main.mostCurrent._lblexplora.runMethod(true,"getHeight")}, "+",1, 1))}, "-",1, 1)),main.mostCurrent._lblexplora.runMethod(true,"getTop"),RemoteObject.createImmutable(6)}, "-*",1, 1)),RemoteObject.createImmutable(5)}, "/",0, 0)));
 BA.debugLineNum = 180;BA.debugLine="btnIngresosRecurrentes.Text = cs.Initialize.Color";
Debug.ShouldStop(524288);
main.mostCurrent._btningresosrecurrentes.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._cs.runMethod(false,"Initialize").runMethod(false,"Color",(Object)(main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 78)),(Object)(BA.numberCast(int.class, 236)),(Object)(BA.numberCast(int.class, 26))))).runMethod(false,"Typeface",(Object)(main.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"getFONTAWESOME"))).runMethod(false,"Size",(Object)(BA.numberCast(int.class, 16))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf0d6)))))).runMethod(false,"Pop").runMethod(false,"Color",(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("		Ingresos recurrentes")))).runMethod(false,"PopAll").getObject()));
 BA.debugLineNum = 183;BA.debugLine="btnIngresosUnicos.Top = btnIngresosRecurrentes.To";
Debug.ShouldStop(4194304);
main.mostCurrent._btningresosunicos.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {main.mostCurrent._btningresosrecurrentes.runMethod(true,"getTop"),main.mostCurrent._btningresosrecurrentes.runMethod(true,"getHeight"),main.mostCurrent._lblexplora.runMethod(true,"getLeft")}, "++",2, 1));
 BA.debugLineNum = 184;BA.debugLine="btnIngresosUnicos.Left = btnIngresosRecurrentes.L";
Debug.ShouldStop(8388608);
main.mostCurrent._btningresosunicos.runMethod(true,"setLeft",main.mostCurrent._btningresosrecurrentes.runMethod(true,"getLeft"));
 BA.debugLineNum = 185;BA.debugLine="btnIngresosUnicos.Width = btnIngresosRecurrentes.";
Debug.ShouldStop(16777216);
main.mostCurrent._btningresosunicos.runMethod(true,"setWidth",main.mostCurrent._btningresosrecurrentes.runMethod(true,"getWidth"));
 BA.debugLineNum = 186;BA.debugLine="btnIngresosUnicos.Height = btnIngresosRecurrentes";
Debug.ShouldStop(33554432);
main.mostCurrent._btningresosunicos.runMethod(true,"setHeight",main.mostCurrent._btningresosrecurrentes.runMethod(true,"getHeight"));
 BA.debugLineNum = 187;BA.debugLine="btnIngresosUnicos.Text = cs.Initialize.Color(Colo";
Debug.ShouldStop(67108864);
main.mostCurrent._btningresosunicos.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._cs.runMethod(false,"Initialize").runMethod(false,"Color",(Object)(main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 187)),(Object)(BA.numberCast(int.class, 0))))).runMethod(false,"Typeface",(Object)(main.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"getFONTAWESOME"))).runMethod(false,"Size",(Object)(BA.numberCast(int.class, 16))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf06b)))))).runMethod(false,"Pop").runMethod(false,"Color",(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("		Ingresos únicos")))).runMethod(false,"PopAll").getObject()));
 BA.debugLineNum = 189;BA.debugLine="btnGastos.Top = btnIngresosUnicos.Top + btnIngres";
Debug.ShouldStop(268435456);
main.mostCurrent._btngastos.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {main.mostCurrent._btningresosunicos.runMethod(true,"getTop"),main.mostCurrent._btningresosunicos.runMethod(true,"getHeight"),main.mostCurrent._lblexplora.runMethod(true,"getLeft")}, "++",2, 1));
 BA.debugLineNum = 190;BA.debugLine="btnGastos.Left = btnIngresosRecurrentes.Left";
Debug.ShouldStop(536870912);
main.mostCurrent._btngastos.runMethod(true,"setLeft",main.mostCurrent._btningresosrecurrentes.runMethod(true,"getLeft"));
 BA.debugLineNum = 191;BA.debugLine="btnGastos.Width = btnIngresosRecurrentes.Width";
Debug.ShouldStop(1073741824);
main.mostCurrent._btngastos.runMethod(true,"setWidth",main.mostCurrent._btningresosrecurrentes.runMethod(true,"getWidth"));
 BA.debugLineNum = 192;BA.debugLine="btnGastos.Height = btnIngresosRecurrentes.Height";
Debug.ShouldStop(-2147483648);
main.mostCurrent._btngastos.runMethod(true,"setHeight",main.mostCurrent._btningresosrecurrentes.runMethod(true,"getHeight"));
 BA.debugLineNum = 193;BA.debugLine="btnGastos.Text = cs.Initialize.Color(Colors.ARGB(";
Debug.ShouldStop(1);
main.mostCurrent._btngastos.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._cs.runMethod(false,"Initialize").runMethod(false,"Color",(Object)(main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 223)),(Object)(BA.numberCast(int.class, 32)),(Object)(BA.numberCast(int.class, 11))))).runMethod(false,"Typeface",(Object)(main.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"getFONTAWESOME"))).runMethod(false,"Size",(Object)(BA.numberCast(int.class, 16))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf283)))))).runMethod(false,"Pop").runMethod(false,"Color",(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("		Gastos")))).runMethod(false,"PopAll").getObject()));
 BA.debugLineNum = 195;BA.debugLine="btnSuscripciones.Top = btnGastos.Top + btnGastos.";
Debug.ShouldStop(4);
main.mostCurrent._btnsuscripciones.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {main.mostCurrent._btngastos.runMethod(true,"getTop"),main.mostCurrent._btngastos.runMethod(true,"getHeight"),main.mostCurrent._lblexplora.runMethod(true,"getLeft")}, "++",2, 1));
 BA.debugLineNum = 196;BA.debugLine="btnSuscripciones.Left = btnIngresosRecurrentes.Le";
Debug.ShouldStop(8);
main.mostCurrent._btnsuscripciones.runMethod(true,"setLeft",main.mostCurrent._btningresosrecurrentes.runMethod(true,"getLeft"));
 BA.debugLineNum = 197;BA.debugLine="btnSuscripciones.Width = btnIngresosRecurrentes.W";
Debug.ShouldStop(16);
main.mostCurrent._btnsuscripciones.runMethod(true,"setWidth",main.mostCurrent._btningresosrecurrentes.runMethod(true,"getWidth"));
 BA.debugLineNum = 198;BA.debugLine="btnSuscripciones.Height = btnIngresosRecurrentes.";
Debug.ShouldStop(32);
main.mostCurrent._btnsuscripciones.runMethod(true,"setHeight",main.mostCurrent._btningresosrecurrentes.runMethod(true,"getHeight"));
 BA.debugLineNum = 199;BA.debugLine="btnSuscripciones.Text = cs.Initialize.Color(Color";
Debug.ShouldStop(64);
main.mostCurrent._btnsuscripciones.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._cs.runMethod(false,"Initialize").runMethod(false,"Color",(Object)(main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 114)),(Object)(BA.numberCast(int.class, 255))))).runMethod(false,"Typeface",(Object)(main.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"getFONTAWESOME"))).runMethod(false,"Size",(Object)(BA.numberCast(int.class, 16))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf0e2)))))).runMethod(false,"Pop").runMethod(false,"Color",(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("		Suscripciones")))).runMethod(false,"PopAll").getObject()));
 BA.debugLineNum = 201;BA.debugLine="btnMetasDeAhorro.Top = btnSuscripciones.Top + btn";
Debug.ShouldStop(256);
main.mostCurrent._btnmetasdeahorro.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {main.mostCurrent._btnsuscripciones.runMethod(true,"getTop"),main.mostCurrent._btnsuscripciones.runMethod(true,"getHeight"),main.mostCurrent._lblexplora.runMethod(true,"getLeft")}, "++",2, 1));
 BA.debugLineNum = 202;BA.debugLine="btnMetasDeAhorro.Left = btnIngresosRecurrentes.Le";
Debug.ShouldStop(512);
main.mostCurrent._btnmetasdeahorro.runMethod(true,"setLeft",main.mostCurrent._btningresosrecurrentes.runMethod(true,"getLeft"));
 BA.debugLineNum = 203;BA.debugLine="btnMetasDeAhorro.Width = btnIngresosRecurrentes.W";
Debug.ShouldStop(1024);
main.mostCurrent._btnmetasdeahorro.runMethod(true,"setWidth",main.mostCurrent._btningresosrecurrentes.runMethod(true,"getWidth"));
 BA.debugLineNum = 204;BA.debugLine="btnMetasDeAhorro.Height = btnIngresosRecurrentes.";
Debug.ShouldStop(2048);
main.mostCurrent._btnmetasdeahorro.runMethod(true,"setHeight",main.mostCurrent._btningresosrecurrentes.runMethod(true,"getHeight"));
 BA.debugLineNum = 205;BA.debugLine="btnMetasDeAhorro.Text = cs.Initialize.Color(Color";
Debug.ShouldStop(4096);
main.mostCurrent._btnmetasdeahorro.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._cs.runMethod(false,"Initialize").runMethod(false,"Color",(Object)(main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 188)),(Object)(BA.numberCast(int.class, 36)),(Object)(BA.numberCast(int.class, 97))))).runMethod(false,"Typeface",(Object)(main.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"getFONTAWESOME"))).runMethod(false,"Size",(Object)(BA.numberCast(int.class, 16))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf19c)))))).runMethod(false,"Pop").runMethod(false,"Color",(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("		Metas de ahorro")))).runMethod(false,"PopAll").getObject()));
 BA.debugLineNum = 210;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
Debug.ShouldStop(131072);
main.mostCurrent._pnlnavinferior.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main._alturadispositivo,RemoteObject.createImmutable(0.08)}, "*",0, 0)));
 BA.debugLineNum = 211;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
Debug.ShouldStop(262144);
main.mostCurrent._pnlnavinferior.runMethod(true,"setWidth",main._anchodispositivo);
 BA.debugLineNum = 212;BA.debugLine="pnlNavInferior.Left = 0";
Debug.ShouldStop(524288);
main.mostCurrent._pnlnavinferior.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 213;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
Debug.ShouldStop(1048576);
main.mostCurrent._pnlnavinferior.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {main._alturadispositivo,main.mostCurrent._pnlnavinferior.runMethod(true,"getHeight")}, "-",1, 1));
 BA.debugLineNum = 216;BA.debugLine="btnAgregar.Width = anchoDispositivo * 0.15";
Debug.ShouldStop(8388608);
main.mostCurrent._btnagregar.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main._anchodispositivo,RemoteObject.createImmutable(0.15)}, "*",0, 0)));
 BA.debugLineNum = 217;BA.debugLine="btnAgregar.Height = btnAgregar.Width";
Debug.ShouldStop(16777216);
main.mostCurrent._btnagregar.runMethod(true,"setHeight",main.mostCurrent._btnagregar.runMethod(true,"getWidth"));
 BA.debugLineNum = 218;BA.debugLine="btnAgregar.Top = pnlNavInferior.Top - btnAgregar.";
Debug.ShouldStop(33554432);
main.mostCurrent._btnagregar.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),main.mostCurrent._btnagregar.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 219;BA.debugLine="btnAgregar.Left = (anchoDispositivo - btnAgregar.";
Debug.ShouldStop(67108864);
main.mostCurrent._btnagregar.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main._anchodispositivo,main.mostCurrent._btnagregar.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 220;BA.debugLine="btnAgregar.Text = Chr(0xF067) 'Ícono de FontAweso";
Debug.ShouldStop(134217728);
main.mostCurrent._btnagregar.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf067)))));
 BA.debugLineNum = 222;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
Debug.ShouldStop(536870912);
main.mostCurrent._lblcontornoboton.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main._anchodispositivo,RemoteObject.createImmutable(0.17)}, "*",0, 0)));
 BA.debugLineNum = 223;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
Debug.ShouldStop(1073741824);
main.mostCurrent._lblcontornoboton.runMethod(true,"setHeight",main.mostCurrent._lblcontornoboton.runMethod(true,"getWidth"));
 BA.debugLineNum = 224;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
Debug.ShouldStop(-2147483648);
main.mostCurrent._lblcontornoboton.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main._anchodispositivo,main.mostCurrent._lblcontornoboton.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 225;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
Debug.ShouldStop(1);
main.mostCurrent._lblcontornoboton.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pnlnavinferior.runMethod(true,"getTop"),main.mostCurrent._lblcontornoboton.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 230;BA.debugLine="pnlAgregar.Width = anchoDispositivo * 0.6";
Debug.ShouldStop(32);
main.mostCurrent._pnlagregar.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main._anchodispositivo,RemoteObject.createImmutable(0.6)}, "*",0, 0)));
 BA.debugLineNum = 231;BA.debugLine="pnlAgregar.Height = pnlAgregar.Width";
Debug.ShouldStop(64);
main.mostCurrent._pnlagregar.runMethod(true,"setHeight",main.mostCurrent._pnlagregar.runMethod(true,"getWidth"));
 BA.debugLineNum = 232;BA.debugLine="pnlAgregar.Left = (anchoDispositivo - pnlAgregar.";
Debug.ShouldStop(128);
main.mostCurrent._pnlagregar.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main._anchodispositivo,main.mostCurrent._pnlagregar.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 233;BA.debugLine="pnlAgregar.Top = lblContornoBoton.Top - pnlAgrega";
Debug.ShouldStop(256);
main.mostCurrent._pnlagregar.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {main.mostCurrent._lblcontornoboton.runMethod(true,"getTop"),main.mostCurrent._pnlagregar.runMethod(true,"getHeight"),RemoteObject.createImmutable(50)}, "--",2, 1));
 BA.debugLineNum = 237;BA.debugLine="btnAgregarIngreso.Height = (pnlAgregar.Height * 0";
Debug.ShouldStop(4096);
main.mostCurrent._btnagregaringreso.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pnlagregar.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.76)}, "*",0, 0)),RemoteObject.createImmutable(4)}, "/",0, 0)));
 BA.debugLineNum = 238;BA.debugLine="btnAgregarIngreso.Width = pnlAgregar.Width * 0.9";
Debug.ShouldStop(8192);
main.mostCurrent._btnagregaringreso.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pnlagregar.runMethod(true,"getWidth"),RemoteObject.createImmutable(0.9)}, "*",0, 0)));
 BA.debugLineNum = 239;BA.debugLine="btnAgregarIngreso.Top = pnlAgregar.Height * 0.048";
Debug.ShouldStop(16384);
main.mostCurrent._btnagregaringreso.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pnlagregar.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.048)}, "*",0, 0)));
 BA.debugLineNum = 240;BA.debugLine="btnAgregarIngreso.Left = (pnlAgregar.Width - btnA";
Debug.ShouldStop(32768);
main.mostCurrent._btnagregaringreso.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pnlagregar.runMethod(true,"getWidth"),main.mostCurrent._btnagregaringreso.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 242;BA.debugLine="btnAgregarGasto.Height = btnAgregarIngreso.Height";
Debug.ShouldStop(131072);
main.mostCurrent._btnagregargasto.runMethod(true,"setHeight",main.mostCurrent._btnagregaringreso.runMethod(true,"getHeight"));
 BA.debugLineNum = 243;BA.debugLine="btnAgregarGasto.Width = btnAgregarIngreso.Width";
Debug.ShouldStop(262144);
main.mostCurrent._btnagregargasto.runMethod(true,"setWidth",main.mostCurrent._btnagregaringreso.runMethod(true,"getWidth"));
 BA.debugLineNum = 244;BA.debugLine="btnAgregarGasto.Top = btnAgregarIngreso.Top * 2 +";
Debug.ShouldStop(524288);
main.mostCurrent._btnagregargasto.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {main.mostCurrent._btnagregaringreso.runMethod(true,"getTop"),RemoteObject.createImmutable(2),main.mostCurrent._btnagregaringreso.runMethod(true,"getHeight")}, "*+",1, 1));
 BA.debugLineNum = 245;BA.debugLine="btnAgregarGasto.Left = btnAgregarIngreso.Left";
Debug.ShouldStop(1048576);
main.mostCurrent._btnagregargasto.runMethod(true,"setLeft",main.mostCurrent._btnagregaringreso.runMethod(true,"getLeft"));
 BA.debugLineNum = 247;BA.debugLine="btnAgregarSuscripcion.Height = btnAgregarIngreso.";
Debug.ShouldStop(4194304);
main.mostCurrent._btnagregarsuscripcion.runMethod(true,"setHeight",main.mostCurrent._btnagregaringreso.runMethod(true,"getHeight"));
 BA.debugLineNum = 248;BA.debugLine="btnAgregarSuscripcion.Width = btnAgregarIngreso.W";
Debug.ShouldStop(8388608);
main.mostCurrent._btnagregarsuscripcion.runMethod(true,"setWidth",main.mostCurrent._btnagregaringreso.runMethod(true,"getWidth"));
 BA.debugLineNum = 249;BA.debugLine="btnAgregarSuscripcion.Top = btnAgregarGasto.Top +";
Debug.ShouldStop(16777216);
main.mostCurrent._btnagregarsuscripcion.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._btnagregargasto.runMethod(true,"getTop"),main.mostCurrent._btnagregargasto.runMethod(true,"getHeight"),main.mostCurrent._pnlagregar.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.04)}, "++*",2, 0)));
 BA.debugLineNum = 250;BA.debugLine="btnAgregarSuscripcion.Left = btnAgregarIngreso.Le";
Debug.ShouldStop(33554432);
main.mostCurrent._btnagregarsuscripcion.runMethod(true,"setLeft",main.mostCurrent._btnagregaringreso.runMethod(true,"getLeft"));
 BA.debugLineNum = 252;BA.debugLine="btnAgregarMetaDeAhorro.Height = btnAgregarIngreso";
Debug.ShouldStop(134217728);
main.mostCurrent._btnagregarmetadeahorro.runMethod(true,"setHeight",main.mostCurrent._btnagregaringreso.runMethod(true,"getHeight"));
 BA.debugLineNum = 253;BA.debugLine="btnAgregarMetaDeAhorro.Width = btnAgregarIngreso.";
Debug.ShouldStop(268435456);
main.mostCurrent._btnagregarmetadeahorro.runMethod(true,"setWidth",main.mostCurrent._btnagregaringreso.runMethod(true,"getWidth"));
 BA.debugLineNum = 254;BA.debugLine="btnAgregarMetaDeAhorro.Top = btnAgregarSuscripcio";
Debug.ShouldStop(536870912);
main.mostCurrent._btnagregarmetadeahorro.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._btnagregarsuscripcion.runMethod(true,"getTop"),main.mostCurrent._btnagregarsuscripcion.runMethod(true,"getHeight"),main.mostCurrent._pnlagregar.runMethod(true,"getHeight"),RemoteObject.createImmutable(0.04)}, "++*",2, 0)));
 BA.debugLineNum = 255;BA.debugLine="btnAgregarMetaDeAhorro.Left = btnAgregarIngreso.L";
Debug.ShouldStop(1073741824);
main.mostCurrent._btnagregarmetadeahorro.runMethod(true,"setLeft",main.mostCurrent._btnagregaringreso.runMethod(true,"getLeft"));
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,262);
if (RapidSub.canDelegate("activity_pause")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 262;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(32);
 BA.debugLineNum = 264;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,258);
if (RapidSub.canDelegate("activity_resume")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 258;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2);
 BA.debugLineNum = 260;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _actualizardatos() throws Exception{
try {
		Debug.PushSubsStack("actualizarDatos (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,559);
if (RapidSub.canDelegate("actualizardatos")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","actualizardatos");}
 BA.debugLineNum = 559;BA.debugLine="Sub actualizarDatos";
Debug.ShouldStop(16384);
 BA.debugLineNum = 560;BA.debugLine="lblBalance.Text = \"$\" & balanceGeneral & \".00\"";
Debug.ShouldStop(32768);
main.mostCurrent._lblbalance.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("$"),_balancegeneral(),RemoteObject.createImmutable(".00"))));
 BA.debugLineNum = 561;BA.debugLine="lblIngresos.Text = \"$\" & balanceActualIngresos &";
Debug.ShouldStop(65536);
main.mostCurrent._lblingresos.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("$"),_balanceactualingresos(),RemoteObject.createImmutable(".00"))));
 BA.debugLineNum = 562;BA.debugLine="lblEgresos.Text = \"$\" & balanceActualEgresos & \".";
Debug.ShouldStop(131072);
main.mostCurrent._lblegresos.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("$"),_balanceactualegresos(),RemoteObject.createImmutable(".00"))));
 BA.debugLineNum = 563;BA.debugLine="estadoBalance(balanceGeneral)";
Debug.ShouldStop(262144);
_estadobalance(_balancegeneral());
 BA.debugLineNum = 564;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _balanceactualegresos() throws Exception{
try {
		Debug.PushSubsStack("balanceActualEgresos (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,360);
if (RapidSub.canDelegate("balanceactualegresos")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","balanceactualegresos");}
 BA.debugLineNum = 360;BA.debugLine="Sub balanceActualEgresos As Int";
Debug.ShouldStop(128);
 BA.debugLineNum = 362;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM egresos\")";
Debug.ShouldStop(512);
main.mostCurrent._cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM egresos"))));
 BA.debugLineNum = 363;BA.debugLine="cur.Position = 0";
Debug.ShouldStop(1024);
main.mostCurrent._cur.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 364;BA.debugLine="Return cur.GetInt(\"suma_egresos\")";
Debug.ShouldStop(2048);
if (true) return main.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("suma_egresos")));
 BA.debugLineNum = 365;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _balanceactualingresos() throws Exception{
try {
		Debug.PushSubsStack("balanceActualIngresos (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,352);
if (RapidSub.canDelegate("balanceactualingresos")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","balanceactualingresos");}
 BA.debugLineNum = 352;BA.debugLine="Sub balanceActualIngresos As Int";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 354;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM ingresos\")";
Debug.ShouldStop(2);
main.mostCurrent._cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM ingresos"))));
 BA.debugLineNum = 355;BA.debugLine="cur.Position = 0";
Debug.ShouldStop(4);
main.mostCurrent._cur.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 356;BA.debugLine="Return cur.GetInt(\"suma_ingresos\")";
Debug.ShouldStop(8);
if (true) return main.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("suma_ingresos")));
 BA.debugLineNum = 357;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _balancegeneral() throws Exception{
try {
		Debug.PushSubsStack("balanceGeneral (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,368);
if (RapidSub.canDelegate("balancegeneral")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","balancegeneral");}
RemoteObject _ingresosactuales = RemoteObject.createImmutable(0);
RemoteObject _egresosactuales = RemoteObject.createImmutable(0);
RemoteObject _balanceactual = RemoteObject.createImmutable(0);
 BA.debugLineNum = 368;BA.debugLine="Sub balanceGeneral As Int";
Debug.ShouldStop(32768);
 BA.debugLineNum = 370;BA.debugLine="Dim ingresosActuales As Int";
Debug.ShouldStop(131072);
_ingresosactuales = RemoteObject.createImmutable(0);Debug.locals.put("ingresosActuales", _ingresosactuales);
 BA.debugLineNum = 371;BA.debugLine="Dim egresosActuales As Int";
Debug.ShouldStop(262144);
_egresosactuales = RemoteObject.createImmutable(0);Debug.locals.put("egresosActuales", _egresosactuales);
 BA.debugLineNum = 372;BA.debugLine="Dim balanceActual As Int";
Debug.ShouldStop(524288);
_balanceactual = RemoteObject.createImmutable(0);Debug.locals.put("balanceActual", _balanceactual);
 BA.debugLineNum = 374;BA.debugLine="ingresosActuales = balanceActualIngresos";
Debug.ShouldStop(2097152);
_ingresosactuales = _balanceactualingresos();Debug.locals.put("ingresosActuales", _ingresosactuales);
 BA.debugLineNum = 375;BA.debugLine="egresosActuales = balanceActualEgresos";
Debug.ShouldStop(4194304);
_egresosactuales = _balanceactualegresos();Debug.locals.put("egresosActuales", _egresosactuales);
 BA.debugLineNum = 377;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM historial_bala";
Debug.ShouldStop(16777216);
main.mostCurrent._cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM historial_balance ORDER BY rowid ASC"))));
 BA.debugLineNum = 378;BA.debugLine="If(cur.RowCount > 0) Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean(">",main.mostCurrent._cur.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 379;BA.debugLine="cur.Position = cur.RowCount - 1";
Debug.ShouldStop(67108864);
main.mostCurrent._cur.runMethod(true,"setPosition",RemoteObject.solve(new RemoteObject[] {main.mostCurrent._cur.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1));
 BA.debugLineNum = 380;BA.debugLine="balanceActual = cur.GetInt(\"balance\")";
Debug.ShouldStop(134217728);
_balanceactual = main.mostCurrent._cur.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("balance")));Debug.locals.put("balanceActual", _balanceactual);
 BA.debugLineNum = 381;BA.debugLine="balanceActual = balanceActual + ingresosActuales";
Debug.ShouldStop(268435456);
_balanceactual = RemoteObject.solve(new RemoteObject[] {_balanceactual,_ingresosactuales,_egresosactuales}, "+-",2, 1);Debug.locals.put("balanceActual", _balanceactual);
 }else {
 BA.debugLineNum = 383;BA.debugLine="balanceActual = ingresosActuales - egresosActual";
Debug.ShouldStop(1073741824);
_balanceactual = RemoteObject.solve(new RemoteObject[] {_ingresosactuales,_egresosactuales}, "-",1, 1);Debug.locals.put("balanceActual", _balanceactual);
 };
 BA.debugLineNum = 386;BA.debugLine="Return balanceActual";
Debug.ShouldStop(2);
if (true) return _balanceactual;
 BA.debugLineNum = 387;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnagregar_click() throws Exception{
try {
		Debug.PushSubsStack("btnAgregar_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,337);
if (RapidSub.canDelegate("btnagregar_click")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","btnagregar_click");}
 BA.debugLineNum = 337;BA.debugLine="Private Sub btnAgregar_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 338;BA.debugLine="click = Not(click)";
Debug.ShouldStop(131072);
main._click = main.mostCurrent.__c.runMethod(true,"Not",(Object)(main._click));
 BA.debugLineNum = 339;BA.debugLine="pnlAgregar.Elevation = 8dip";
Debug.ShouldStop(262144);
main.mostCurrent._pnlagregar.runMethod(true,"setElevation",BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 8)))));
 BA.debugLineNum = 340;BA.debugLine="pnlAgregar.SetVisibleAnimated(200, click) 'https:";
Debug.ShouldStop(524288);
main.mostCurrent._pnlagregar.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 200)),(Object)(main._click));
 BA.debugLineNum = 341;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnagregargasto_click() throws Exception{
try {
		Debug.PushSubsStack("btnAgregarGasto_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,331);
if (RapidSub.canDelegate("btnagregargasto_click")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","btnagregargasto_click");}
 BA.debugLineNum = 331;BA.debugLine="Private Sub btnAgregarGasto_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 332;BA.debugLine="StartActivity(registrarGasto)";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._registrargasto.getObject())));
 BA.debugLineNum = 333;BA.debugLine="btnAgregar_Click";
Debug.ShouldStop(4096);
_btnagregar_click();
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
public static RemoteObject  _btnagregaringreso_click() throws Exception{
try {
		Debug.PushSubsStack("btnAgregarIngreso_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,326);
if (RapidSub.canDelegate("btnagregaringreso_click")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","btnagregaringreso_click");}
 BA.debugLineNum = 326;BA.debugLine="Private Sub btnAgregarIngreso_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 327;BA.debugLine="StartActivity(registrarIngreso)";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._registraringreso.getObject())));
 BA.debugLineNum = 328;BA.debugLine="btnAgregar_Click";
Debug.ShouldStop(128);
_btnagregar_click();
 BA.debugLineNum = 329;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnagregarmetadeahorro_click() throws Exception{
try {
		Debug.PushSubsStack("btnAgregarMetaDeAhorro_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,321);
if (RapidSub.canDelegate("btnagregarmetadeahorro_click")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","btnagregarmetadeahorro_click");}
 BA.debugLineNum = 321;BA.debugLine="Private Sub btnAgregarMetaDeAhorro_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 322;BA.debugLine="StartActivity(registrarMetaAhorro)";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._registrarmetaahorro.getObject())));
 BA.debugLineNum = 323;BA.debugLine="btnAgregar_Click";
Debug.ShouldStop(4);
_btnagregar_click();
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
public static RemoteObject  _btnagregarsuscripcion_click() throws Exception{
try {
		Debug.PushSubsStack("btnAgregarSuscripcion_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,316);
if (RapidSub.canDelegate("btnagregarsuscripcion_click")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","btnagregarsuscripcion_click");}
 BA.debugLineNum = 316;BA.debugLine="Private Sub btnAgregarSuscripcion_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 317;BA.debugLine="StartActivity(registrarSuscripcion)";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._registrarsuscripcion.getObject())));
 BA.debugLineNum = 318;BA.debugLine="btnAgregar_Click";
Debug.ShouldStop(536870912);
_btnagregar_click();
 BA.debugLineNum = 319;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btngastos_click() throws Exception{
try {
		Debug.PushSubsStack("btnGastos_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,311);
if (RapidSub.canDelegate("btngastos_click")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","btngastos_click");}
 BA.debugLineNum = 311;BA.debugLine="Private Sub btnGastos_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 312;BA.debugLine="StartActivity(Gastos)";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._gastos.getObject())));
 BA.debugLineNum = 313;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btngenerarhistorial_click() throws Exception{
try {
		Debug.PushSubsStack("btnGenerarHistorial_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,269);
if (RapidSub.canDelegate("btngenerarhistorial_click")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","btngenerarhistorial_click");}
RemoteObject _resultado = RemoteObject.createImmutable(0);
RemoteObject _totalingresos = RemoteObject.createImmutable(0);
RemoteObject _totalegresos = RemoteObject.createImmutable(0);
RemoteObject _totalbalance = RemoteObject.createImmutable(0);
 BA.debugLineNum = 269;BA.debugLine="Private Sub btnGenerarHistorial_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 270;BA.debugLine="Dim resultado As Int";
Debug.ShouldStop(8192);
_resultado = RemoteObject.createImmutable(0);Debug.locals.put("resultado", _resultado);
 BA.debugLineNum = 271;BA.debugLine="Dim totalIngresos As Int";
Debug.ShouldStop(16384);
_totalingresos = RemoteObject.createImmutable(0);Debug.locals.put("totalIngresos", _totalingresos);
 BA.debugLineNum = 272;BA.debugLine="Dim totalEgresos As Int";
Debug.ShouldStop(32768);
_totalegresos = RemoteObject.createImmutable(0);Debug.locals.put("totalEgresos", _totalegresos);
 BA.debugLineNum = 273;BA.debugLine="Dim totalBalance As Int";
Debug.ShouldStop(65536);
_totalbalance = RemoteObject.createImmutable(0);Debug.locals.put("totalBalance", _totalbalance);
 BA.debugLineNum = 274;BA.debugLine="totalIngresos = balanceActualIngresos";
Debug.ShouldStop(131072);
_totalingresos = _balanceactualingresos();Debug.locals.put("totalIngresos", _totalingresos);
 BA.debugLineNum = 275;BA.debugLine="totalEgresos = balanceActualEgresos";
Debug.ShouldStop(262144);
_totalegresos = _balanceactualegresos();Debug.locals.put("totalEgresos", _totalegresos);
 BA.debugLineNum = 276;BA.debugLine="totalBalance = balanceGeneral";
Debug.ShouldStop(524288);
_totalbalance = _balancegeneral();Debug.locals.put("totalBalance", _totalbalance);
 BA.debugLineNum = 278;BA.debugLine="resultado = Msgbox2(\"¿Estás seguro?\", \"Generar hi";
Debug.ShouldStop(2097152);
_resultado = main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("¿Estás seguro?")),(Object)(BA.ObjectToCharSequence("Generar historial")),(Object)(BA.ObjectToString("Sí")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("No")),(Object)((main.mostCurrent.__c.getField(false,"Null"))),main.mostCurrent.activityBA);Debug.locals.put("resultado", _resultado);
 BA.debugLineNum = 280;BA.debugLine="If (resultado = DialogResponse.POSITIVE) Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",_resultado,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE"))))) { 
 BA.debugLineNum = 281;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO historial_balance";
Debug.ShouldStop(16777216);
main._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO historial_balance (balance, suma_ingresos, suma_egresos, fecha_historial) VALUES (?, ?, ?, ?)")),(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {4},new Object[] {(_totalbalance),(_totalingresos),(_totalegresos),(_obtenerfechaactual())})))));
 BA.debugLineNum = 282;BA.debugLine="ToastMessageShow(\"Historial generado\", True)";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Historial generado")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 283;BA.debugLine="sql.ExecNonQuery2(\"UPDATE ingresos SET suma_ingr";
Debug.ShouldStop(67108864);
main._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE ingresos SET suma_ingresos = ?  WHERE id_ingreso = 1")),(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0))})))));
 BA.debugLineNum = 284;BA.debugLine="sql.ExecNonQuery2(\"UPDATE egresos SET suma_egres";
Debug.ShouldStop(134217728);
main._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE egresos SET suma_egresos = ?  WHERE id_egreso = 1")),(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0))})))));
 BA.debugLineNum = 285;BA.debugLine="lblIngresos.Text = \"$\" & \"0.00\"";
Debug.ShouldStop(268435456);
main.mostCurrent._lblingresos.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("$"),RemoteObject.createImmutable("0.00"))));
 BA.debugLineNum = 286;BA.debugLine="lblEgresos.Text = \"$\"  & \"0.00\"";
Debug.ShouldStop(536870912);
main.mostCurrent._lblegresos.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("$"),RemoteObject.createImmutable("0.00"))));
 };
 BA.debugLineNum = 288;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnhistoriales_click() throws Exception{
try {
		Debug.PushSubsStack("btnHistoriales_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,291);
if (RapidSub.canDelegate("btnhistoriales_click")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","btnhistoriales_click");}
 BA.debugLineNum = 291;BA.debugLine="Private Sub btnHistoriales_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 292;BA.debugLine="StartActivity(Historiales)";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._historiales.getObject())));
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
public static RemoteObject  _btningresosrecurrentes_click() throws Exception{
try {
		Debug.PushSubsStack("btnIngresosRecurrentes_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,307);
if (RapidSub.canDelegate("btningresosrecurrentes_click")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","btningresosrecurrentes_click");}
 BA.debugLineNum = 307;BA.debugLine="Private Sub btnIngresosRecurrentes_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 308;BA.debugLine="StartActivity(IngresosRecurrentes)";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._ingresosrecurrentes.getObject())));
 BA.debugLineNum = 309;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btningresosunicos_click() throws Exception{
try {
		Debug.PushSubsStack("btnIngresosUnicos_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,303);
if (RapidSub.canDelegate("btningresosunicos_click")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","btningresosunicos_click");}
 BA.debugLineNum = 303;BA.debugLine="Private Sub btnIngresosUnicos_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 304;BA.debugLine="StartActivity(IngresosUnicos)";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._ingresosunicos.getObject())));
 BA.debugLineNum = 305;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnmetasdeahorro_click() throws Exception{
try {
		Debug.PushSubsStack("btnMetasDeAhorro_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,299);
if (RapidSub.canDelegate("btnmetasdeahorro_click")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","btnmetasdeahorro_click");}
 BA.debugLineNum = 299;BA.debugLine="Private Sub btnMetasDeAhorro_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 300;BA.debugLine="StartActivity(MetasDeAhorro)";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._metasdeahorro.getObject())));
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
public static RemoteObject  _btnsuscripciones_click() throws Exception{
try {
		Debug.PushSubsStack("btnSuscripciones_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,295);
if (RapidSub.canDelegate("btnsuscripciones_click")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","btnsuscripciones_click");}
 BA.debugLineNum = 295;BA.debugLine="Private Sub btnSuscripciones_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 296;BA.debugLine="StartActivity(Suscripciones)";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._suscripciones.getObject())));
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
public static RemoteObject  _cobraingresos() throws Exception{
try {
		Debug.PushSubsStack("cobraIngresos (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,392);
if (RapidSub.canDelegate("cobraingresos")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","cobraingresos");}
RemoteObject _cur1 = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _cur2 = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _fechaactual = RemoteObject.createImmutable("");
RemoteObject _fechaactuallong = RemoteObject.createImmutable(0L);
RemoteObject _fechacobro = RemoteObject.createImmutable("");
RemoteObject _fechacobrolong = RemoteObject.createImmutable(0L);
RemoteObject _ingresosactuales = RemoteObject.createImmutable(0);
RemoteObject _monto = RemoteObject.createImmutable(0);
RemoteObject _periodo = RemoteObject.createImmutable(0);
int _contador = 0;
 BA.debugLineNum = 392;BA.debugLine="Sub cobraIngresos";
Debug.ShouldStop(128);
 BA.debugLineNum = 393;BA.debugLine="Dim cur1 As Cursor";
Debug.ShouldStop(256);
_cur1 = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("cur1", _cur1);
 BA.debugLineNum = 394;BA.debugLine="Dim cur2 As Cursor";
Debug.ShouldStop(512);
_cur2 = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("cur2", _cur2);
 BA.debugLineNum = 395;BA.debugLine="Dim fechaActual As String";
Debug.ShouldStop(1024);
_fechaactual = RemoteObject.createImmutable("");Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 396;BA.debugLine="Dim fechaActualLong As Long";
Debug.ShouldStop(2048);
_fechaactuallong = RemoteObject.createImmutable(0L);Debug.locals.put("fechaActualLong", _fechaactuallong);
 BA.debugLineNum = 397;BA.debugLine="Dim fechaCobro As String";
Debug.ShouldStop(4096);
_fechacobro = RemoteObject.createImmutable("");Debug.locals.put("fechaCobro", _fechacobro);
 BA.debugLineNum = 398;BA.debugLine="Dim fechaCobroLong As Long";
Debug.ShouldStop(8192);
_fechacobrolong = RemoteObject.createImmutable(0L);Debug.locals.put("fechaCobroLong", _fechacobrolong);
 BA.debugLineNum = 399;BA.debugLine="Dim ingresosActuales As Int";
Debug.ShouldStop(16384);
_ingresosactuales = RemoteObject.createImmutable(0);Debug.locals.put("ingresosActuales", _ingresosactuales);
 BA.debugLineNum = 400;BA.debugLine="Dim monto As Int";
Debug.ShouldStop(32768);
_monto = RemoteObject.createImmutable(0);Debug.locals.put("monto", _monto);
 BA.debugLineNum = 401;BA.debugLine="Dim periodo As Int";
Debug.ShouldStop(65536);
_periodo = RemoteObject.createImmutable(0);Debug.locals.put("periodo", _periodo);
 BA.debugLineNum = 403;BA.debugLine="fechaActual = DateTime.Now";
Debug.ShouldStop(262144);
_fechaactual = BA.NumberToString(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 404;BA.debugLine="fechaActual = DateTime.Date(fechaActual)";
Debug.ShouldStop(524288);
_fechaactual = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(BA.numberCast(long.class, _fechaactual)));Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 405;BA.debugLine="fechaActualLong = DateTime.DateParse(fechaActual)";
Debug.ShouldStop(1048576);
_fechaactuallong = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateParse",(Object)(_fechaactual));Debug.locals.put("fechaActualLong", _fechaactuallong);
 BA.debugLineNum = 407;BA.debugLine="cur1 = sql.ExecQuery(\"SELECT * FROM ingresos_recu";
Debug.ShouldStop(4194304);
_cur1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM ingresos_recurrentes ORDER BY rowid ASC"))));
 BA.debugLineNum = 408;BA.debugLine="cur2 = sql.ExecQuery(\"SELECT * FROM ingresos\")";
Debug.ShouldStop(8388608);
_cur2 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM ingresos"))));
 BA.debugLineNum = 409;BA.debugLine="If(cur1.RowCount <> 0) Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("!",_cur1.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 410;BA.debugLine="For contador = 0  To cur1.RowCount - 1 Step 1";
Debug.ShouldStop(33554432);
{
final int step16 = 1;
final int limit16 = RemoteObject.solve(new RemoteObject[] {_cur1.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_contador = 0 ;
for (;(step16 > 0 && _contador <= limit16) || (step16 < 0 && _contador >= limit16) ;_contador = ((int)(0 + _contador + step16))  ) {
Debug.locals.put("contador", _contador);
 BA.debugLineNum = 411;BA.debugLine="cur1.Position = contador";
Debug.ShouldStop(67108864);
_cur1.runMethod(true,"setPosition",BA.numberCast(int.class, _contador));
 BA.debugLineNum = 412;BA.debugLine="cur2.Position = 0";
Debug.ShouldStop(134217728);
_cur2.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 414;BA.debugLine="ingresosActuales = cur2.GetInt(\"suma_ingresos\")";
Debug.ShouldStop(536870912);
_ingresosactuales = _cur2.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("suma_ingresos")));Debug.locals.put("ingresosActuales", _ingresosactuales);
 BA.debugLineNum = 415;BA.debugLine="monto = cur1.GetInt(\"monto\")";
Debug.ShouldStop(1073741824);
_monto = _cur1.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("monto")));Debug.locals.put("monto", _monto);
 BA.debugLineNum = 416;BA.debugLine="periodo = cur1.GetInt(\"periodo\")";
Debug.ShouldStop(-2147483648);
_periodo = _cur1.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("periodo")));Debug.locals.put("periodo", _periodo);
 BA.debugLineNum = 419;BA.debugLine="fechaCobro = cur1.GetString(\"fecha_cobro\").Repl";
Debug.ShouldStop(4);
_fechacobro = _cur1.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("fecha_cobro"))).runMethod(true,"replace",(Object)(BA.ObjectToString("-")),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("fechaCobro", _fechacobro);
 BA.debugLineNum = 420;BA.debugLine="fechaCobroLong = DateTime.DateParse(fechaCobro)";
Debug.ShouldStop(8);
_fechacobrolong = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateParse",(Object)(_fechacobro));Debug.locals.put("fechaCobroLong", _fechacobrolong);
 BA.debugLineNum = 422;BA.debugLine="If(fechaCobroLong <= fechaActualLong) Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("k",_fechacobrolong,_fechaactuallong))) { 
 BA.debugLineNum = 423;BA.debugLine="ingresosActuales = ingresosActuales + monto";
Debug.ShouldStop(64);
_ingresosactuales = RemoteObject.solve(new RemoteObject[] {_ingresosactuales,_monto}, "+",1, 1);Debug.locals.put("ingresosActuales", _ingresosactuales);
 BA.debugLineNum = 425;BA.debugLine="Do Until (DateTime.Add(fechaCobroLong, 0, 0, p";
Debug.ShouldStop(256);
while (!((RemoteObject.solveBoolean(">",main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Add",(Object)(_fechacobrolong),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_periodo)),_fechaactuallong)))) {
 BA.debugLineNum = 426;BA.debugLine="ingresosActuales = ingresosActuales + monto";
Debug.ShouldStop(512);
_ingresosactuales = RemoteObject.solve(new RemoteObject[] {_ingresosactuales,_monto}, "+",1, 1);Debug.locals.put("ingresosActuales", _ingresosactuales);
 BA.debugLineNum = 428;BA.debugLine="fechaActual = DateTime.Now";
Debug.ShouldStop(2048);
_fechaactual = BA.NumberToString(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 429;BA.debugLine="fechaActual = DateTime.Date(fechaActual)";
Debug.ShouldStop(4096);
_fechaactual = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(BA.numberCast(long.class, _fechaactual)));Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 430;BA.debugLine="fechaActualLong = DateTime.DateParse(fechaAct";
Debug.ShouldStop(8192);
_fechaactuallong = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateParse",(Object)(_fechaactual));Debug.locals.put("fechaActualLong", _fechaactuallong);
 BA.debugLineNum = 431;BA.debugLine="fechaCobroLong = DateTime.Add(fechaCobroLong,";
Debug.ShouldStop(16384);
_fechacobrolong = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Add",(Object)(_fechacobrolong),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_periodo));Debug.locals.put("fechaCobroLong", _fechacobrolong);
 }
;
 BA.debugLineNum = 434;BA.debugLine="fechaCobroLong = DateTime.Add(fechaCobroLong,";
Debug.ShouldStop(131072);
_fechacobrolong = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Add",(Object)(_fechacobrolong),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_periodo));Debug.locals.put("fechaCobroLong", _fechacobrolong);
 BA.debugLineNum = 435;BA.debugLine="fechaCobro = DateTime.Date(fechaCobroLong)";
Debug.ShouldStop(262144);
_fechacobro = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(_fechacobrolong));Debug.locals.put("fechaCobro", _fechacobro);
 };
 BA.debugLineNum = 438;BA.debugLine="sql.ExecNonQuery2(\"UPDATE ingresos SET suma_ing";
Debug.ShouldStop(2097152);
main._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE ingresos SET suma_ingresos = ?  WHERE id_ingreso = 1")),(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_ingresosactuales)})))));
 BA.debugLineNum = 439;BA.debugLine="sql.ExecNonQuery2(\"UPDATE ingresos_recurrentes";
Debug.ShouldStop(4194304);
main._sql.runVoidMethod ("ExecNonQuery2",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE ingresos_recurrentes SET fecha_cobro = ? WHERE id_ingreso_recurrente = '"),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_contador),RemoteObject.createImmutable(1)}, "+",1, 1)),RemoteObject.createImmutable("'"))),(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_fechacobro)})))));
 }
}Debug.locals.put("contador", _contador);
;
 };
 BA.debugLineNum = 442;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _estadobalance(RemoteObject _balanceactual) throws Exception{
try {
		Debug.PushSubsStack("estadoBalance (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,567);
if (RapidSub.canDelegate("estadobalance")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","estadobalance", _balanceactual);}
Debug.locals.put("balanceActual", _balanceactual);
 BA.debugLineNum = 567;BA.debugLine="Sub estadoBalance(balanceActual As Int)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 568;BA.debugLine="If(balanceActual < 0) Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("<",_balanceactual,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 569;BA.debugLine="lblEstado.Text = Chr(0xE811)";
Debug.ShouldStop(16777216);
main.mostCurrent._lblestado.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xe811)))));
 BA.debugLineNum = 570;BA.debugLine="lblEstado.TextColor = Colors.ARGB(255, 234, 33,";
Debug.ShouldStop(33554432);
main.mostCurrent._lblestado.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 234)),(Object)(BA.numberCast(int.class, 33)),(Object)(BA.numberCast(int.class, 7))));
 }else 
{ BA.debugLineNum = 571;BA.debugLine="Else If(balanceActual = 0) Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",_balanceactual,BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 572;BA.debugLine="lblEstado.Text = Chr(0xE812)";
Debug.ShouldStop(134217728);
main.mostCurrent._lblestado.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xe812)))));
 BA.debugLineNum = 573;BA.debugLine="lblEstado.TextColor = Colors.ARGB(255, 234, 199,";
Debug.ShouldStop(268435456);
main.mostCurrent._lblestado.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 234)),(Object)(BA.numberCast(int.class, 199)),(Object)(BA.numberCast(int.class, 7))));
 }else {
 BA.debugLineNum = 575;BA.debugLine="lblEstado.Text = Chr(0xE813)";
Debug.ShouldStop(1073741824);
main.mostCurrent._lblestado.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xe813)))));
 BA.debugLineNum = 576;BA.debugLine="lblEstado.TextColor = Colors.ARGB(255, 15, 234,";
Debug.ShouldStop(-2147483648);
main.mostCurrent._lblestado.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 15)),(Object)(BA.numberCast(int.class, 234)),(Object)(BA.numberCast(int.class, 7))));
 }}
;
 BA.debugLineNum = 578;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 29;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 31;BA.debugLine="Dim cs As CSBuilder 'https://www.b4x.com/android/";
main.mostCurrent._cs = RemoteObject.createNew ("anywheresoftware.b4a.objects.CSBuilder");
 //BA.debugLineNum = 32;BA.debugLine="Dim click As Boolean";
main._click = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 33;BA.debugLine="Dim cur As Cursor";
main.mostCurrent._cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Dim balance As Int";
main._balance = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 35;BA.debugLine="Dim ingresos As Int";
main._ingresos = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 36;BA.debugLine="Dim egresos As Int";
main._egresos = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 40;BA.debugLine="Private btnIngresosRecurrentes As Button";
main.mostCurrent._btningresosrecurrentes = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private btnIngresosUnicos As Button";
main.mostCurrent._btningresosunicos = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private btnGastos As Button";
main.mostCurrent._btngastos = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private btnMetasDeAhorro As Button";
main.mostCurrent._btnmetasdeahorro = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private btnSuscripciones As Button";
main.mostCurrent._btnsuscripciones = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private btnHistoriales As Button";
main.mostCurrent._btnhistoriales = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private btnAgregar As Button";
main.mostCurrent._btnagregar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private btnAgregarGasto As Button";
main.mostCurrent._btnagregargasto = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private btnAgregarIngreso As Button";
main.mostCurrent._btnagregaringreso = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private btnAgregarMetaDeAhorro As Button";
main.mostCurrent._btnagregarmetadeahorro = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private btnAgregarSuscripcion As Button";
main.mostCurrent._btnagregarsuscripcion = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private btnGenerarHistorial As Button";
main.mostCurrent._btngenerarhistorial = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private lblExplora As Label";
main.mostCurrent._lblexplora = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private lblContornoBoton As Label";
main.mostCurrent._lblcontornoboton = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private lblIconoEgresos As Label";
main.mostCurrent._lbliconoegresos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 56;BA.debugLine="Private lblIconoIngresos As Label";
main.mostCurrent._lbliconoingresos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 57;BA.debugLine="Private lblBalance As Label";
main.mostCurrent._lblbalance = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private lblEgresos As Label";
main.mostCurrent._lblegresos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Private lblIngresos As Label";
main.mostCurrent._lblingresos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private lblBalanceTitulo As Label";
main.mostCurrent._lblbalancetitulo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Private lblEstado As Label";
main.mostCurrent._lblestado = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 63;BA.debugLine="Private pnlBalance As Panel";
main.mostCurrent._pnlbalance = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 64;BA.debugLine="Private pnlOpciones As Panel";
main.mostCurrent._pnlopciones = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 65;BA.debugLine="Private pnlNavInferior As Panel";
main.mostCurrent._pnlnavinferior = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 66;BA.debugLine="Private pnlAgregar As Panel";
main.mostCurrent._pnlagregar = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 67;BA.debugLine="Private pnlCabecera As Panel";
main.mostCurrent._pnlcabecera = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _obtenerfechaactual() throws Exception{
try {
		Debug.PushSubsStack("obtenerFechaActual (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,344);
if (RapidSub.canDelegate("obtenerfechaactual")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","obtenerfechaactual");}
RemoteObject _ahora = RemoteObject.createImmutable(0L);
 BA.debugLineNum = 344;BA.debugLine="Sub obtenerFechaActual As String";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 345;BA.debugLine="Dim ahora As Long";
Debug.ShouldStop(16777216);
_ahora = RemoteObject.createImmutable(0L);Debug.locals.put("ahora", _ahora);
 BA.debugLineNum = 346;BA.debugLine="ahora = DateTime.Now";
Debug.ShouldStop(33554432);
_ahora = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow");Debug.locals.put("ahora", _ahora);
 BA.debugLineNum = 347;BA.debugLine="Return (DateTime.Date(ahora))";
Debug.ShouldStop(67108864);
if (true) return (main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(_ahora)));
 BA.debugLineNum = 349;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
tutorial_subs_0._process_globals();
diapositivas_subs_0._process_globals();
editargasto_subs_0._process_globals();
editaringresorecurrente_subs_0._process_globals();
editaringresounico_subs_0._process_globals();
editarmetaahorro_subs_0._process_globals();
editarsuscripcion_subs_0._process_globals();
gastos_subs_0._process_globals();
historiales_subs_0._process_globals();
ingresosrecurrentes_subs_0._process_globals();
ingresosunicos_subs_0._process_globals();
metasdeahorro_subs_0._process_globals();
registrargasto_subs_0._process_globals();
registraringreso_subs_0._process_globals();
registrarmetaahorro_subs_0._process_globals();
registrarsuscripcion_subs_0._process_globals();
suscripciones_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("pullup.wallet.main");
starter.myClass = BA.getDeviceClass ("pullup.wallet.starter");
tutorial.myClass = BA.getDeviceClass ("pullup.wallet.tutorial");
diapositivas.myClass = BA.getDeviceClass ("pullup.wallet.diapositivas");
editargasto.myClass = BA.getDeviceClass ("pullup.wallet.editargasto");
editaringresorecurrente.myClass = BA.getDeviceClass ("pullup.wallet.editaringresorecurrente");
editaringresounico.myClass = BA.getDeviceClass ("pullup.wallet.editaringresounico");
editarmetaahorro.myClass = BA.getDeviceClass ("pullup.wallet.editarmetaahorro");
editarsuscripcion.myClass = BA.getDeviceClass ("pullup.wallet.editarsuscripcion");
gastos.myClass = BA.getDeviceClass ("pullup.wallet.gastos");
historiales.myClass = BA.getDeviceClass ("pullup.wallet.historiales");
ingresosrecurrentes.myClass = BA.getDeviceClass ("pullup.wallet.ingresosrecurrentes");
ingresosunicos.myClass = BA.getDeviceClass ("pullup.wallet.ingresosunicos");
metasdeahorro.myClass = BA.getDeviceClass ("pullup.wallet.metasdeahorro");
registrargasto.myClass = BA.getDeviceClass ("pullup.wallet.registrargasto");
registraringreso.myClass = BA.getDeviceClass ("pullup.wallet.registraringreso");
registrarmetaahorro.myClass = BA.getDeviceClass ("pullup.wallet.registrarmetaahorro");
registrarsuscripcion.myClass = BA.getDeviceClass ("pullup.wallet.registrarsuscripcion");
suscripciones.myClass = BA.getDeviceClass ("pullup.wallet.suscripciones");
ascolorslider.myClass = BA.getDeviceClass ("pullup.wallet.ascolorslider");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 20;BA.debugLine="Dim alturaDispositivo As Int";
main._alturadispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 21;BA.debugLine="Dim anchoDispositivo As Int";
main._anchodispositivo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 22;BA.debugLine="Type RegistroGasto(nombre As String, monto As Int";
;
 //BA.debugLineNum = 23;BA.debugLine="Type RegistroSuscripcion(nombre As String, monto";
;
 //BA.debugLineNum = 24;BA.debugLine="Type RegistroMetaAhorro(nombre As String, montoAh";
;
 //BA.debugLineNum = 25;BA.debugLine="Type RegistroIngreso(nombre As String, monto As I";
;
 //BA.debugLineNum = 26;BA.debugLine="Dim sql As SQL";
main._sql = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _realizaegresos() throws Exception{
try {
		Debug.PushSubsStack("realizaEgresos (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,447);
if (RapidSub.canDelegate("realizaegresos")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","realizaegresos");}
RemoteObject _cur1 = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _cur2 = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _fechaactual = RemoteObject.createImmutable("");
RemoteObject _fechaactuallong = RemoteObject.createImmutable(0L);
RemoteObject _fechapago = RemoteObject.createImmutable("");
RemoteObject _fechapagolong = RemoteObject.createImmutable(0L);
RemoteObject _egresosactuales = RemoteObject.createImmutable(0);
RemoteObject _monto = RemoteObject.createImmutable(0);
RemoteObject _periodo = RemoteObject.createImmutable(0);
RemoteObject _progreso = RemoteObject.createImmutable(0);
RemoteObject _montometa = RemoteObject.createImmutable(0);
int _contador = 0;
 BA.debugLineNum = 447;BA.debugLine="Sub realizaEgresos";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 448;BA.debugLine="Dim cur1 As Cursor";
Debug.ShouldStop(-2147483648);
_cur1 = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("cur1", _cur1);
 BA.debugLineNum = 449;BA.debugLine="Dim cur2 As Cursor";
Debug.ShouldStop(1);
_cur2 = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("cur2", _cur2);
 BA.debugLineNum = 450;BA.debugLine="Dim fechaActual As String";
Debug.ShouldStop(2);
_fechaactual = RemoteObject.createImmutable("");Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 451;BA.debugLine="Dim fechaActualLong As Long";
Debug.ShouldStop(4);
_fechaactuallong = RemoteObject.createImmutable(0L);Debug.locals.put("fechaActualLong", _fechaactuallong);
 BA.debugLineNum = 452;BA.debugLine="Dim fechaPago As String";
Debug.ShouldStop(8);
_fechapago = RemoteObject.createImmutable("");Debug.locals.put("fechaPago", _fechapago);
 BA.debugLineNum = 453;BA.debugLine="Dim fechaPagoLong As Long";
Debug.ShouldStop(16);
_fechapagolong = RemoteObject.createImmutable(0L);Debug.locals.put("fechaPagoLong", _fechapagolong);
 BA.debugLineNum = 454;BA.debugLine="Dim egresosActuales As Int";
Debug.ShouldStop(32);
_egresosactuales = RemoteObject.createImmutable(0);Debug.locals.put("egresosActuales", _egresosactuales);
 BA.debugLineNum = 455;BA.debugLine="Dim monto As Int";
Debug.ShouldStop(64);
_monto = RemoteObject.createImmutable(0);Debug.locals.put("monto", _monto);
 BA.debugLineNum = 456;BA.debugLine="Dim periodo As Int";
Debug.ShouldStop(128);
_periodo = RemoteObject.createImmutable(0);Debug.locals.put("periodo", _periodo);
 BA.debugLineNum = 457;BA.debugLine="Dim progreso As Int";
Debug.ShouldStop(256);
_progreso = RemoteObject.createImmutable(0);Debug.locals.put("progreso", _progreso);
 BA.debugLineNum = 458;BA.debugLine="Dim montoMeta As Int";
Debug.ShouldStop(512);
_montometa = RemoteObject.createImmutable(0);Debug.locals.put("montoMeta", _montometa);
 BA.debugLineNum = 460;BA.debugLine="fechaActual = DateTime.Now";
Debug.ShouldStop(2048);
_fechaactual = BA.NumberToString(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 461;BA.debugLine="fechaActual = DateTime.Date(fechaActual)";
Debug.ShouldStop(4096);
_fechaactual = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(BA.numberCast(long.class, _fechaactual)));Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 462;BA.debugLine="fechaActualLong = DateTime.DateParse(fechaActual)";
Debug.ShouldStop(8192);
_fechaactuallong = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateParse",(Object)(_fechaactual));Debug.locals.put("fechaActualLong", _fechaactuallong);
 BA.debugLineNum = 464;BA.debugLine="cur1 = sql.ExecQuery(\"SELECT * FROM suscripciones";
Debug.ShouldStop(32768);
_cur1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM suscripciones ORDER BY rowid ASC"))));
 BA.debugLineNum = 465;BA.debugLine="cur2 = sql.ExecQuery(\"SELECT * FROM egresos\")";
Debug.ShouldStop(65536);
_cur2 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM egresos"))));
 BA.debugLineNum = 467;BA.debugLine="If(cur1.RowCount <> 0) Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("!",_cur1.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 468;BA.debugLine="For contador = 0  To cur1.RowCount - 1 Step 1";
Debug.ShouldStop(524288);
{
final int step18 = 1;
final int limit18 = RemoteObject.solve(new RemoteObject[] {_cur1.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_contador = 0 ;
for (;(step18 > 0 && _contador <= limit18) || (step18 < 0 && _contador >= limit18) ;_contador = ((int)(0 + _contador + step18))  ) {
Debug.locals.put("contador", _contador);
 BA.debugLineNum = 469;BA.debugLine="cur1.Position = contador";
Debug.ShouldStop(1048576);
_cur1.runMethod(true,"setPosition",BA.numberCast(int.class, _contador));
 BA.debugLineNum = 470;BA.debugLine="cur2.Position = 0";
Debug.ShouldStop(2097152);
_cur2.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 472;BA.debugLine="egresosActuales = cur2.GetInt(\"suma_egresos\")";
Debug.ShouldStop(8388608);
_egresosactuales = _cur2.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("suma_egresos")));Debug.locals.put("egresosActuales", _egresosactuales);
 BA.debugLineNum = 473;BA.debugLine="monto = cur1.GetInt(\"monto\")";
Debug.ShouldStop(16777216);
_monto = _cur1.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("monto")));Debug.locals.put("monto", _monto);
 BA.debugLineNum = 474;BA.debugLine="periodo = cur1.GetInt(\"periodo\")";
Debug.ShouldStop(33554432);
_periodo = _cur1.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("periodo")));Debug.locals.put("periodo", _periodo);
 BA.debugLineNum = 477;BA.debugLine="fechaPago = cur1.GetString(\"fecha_pago\").Replac";
Debug.ShouldStop(268435456);
_fechapago = _cur1.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("fecha_pago"))).runMethod(true,"replace",(Object)(BA.ObjectToString("-")),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("fechaPago", _fechapago);
 BA.debugLineNum = 478;BA.debugLine="fechaPagoLong = DateTime.DateParse(fechaPago)";
Debug.ShouldStop(536870912);
_fechapagolong = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateParse",(Object)(_fechapago));Debug.locals.put("fechaPagoLong", _fechapagolong);
 BA.debugLineNum = 480;BA.debugLine="If(fechaPagoLong <= fechaActualLong) Then";
Debug.ShouldStop(-2147483648);
if ((RemoteObject.solveBoolean("k",_fechapagolong,_fechaactuallong))) { 
 BA.debugLineNum = 481;BA.debugLine="egresosActuales = egresosActuales + monto";
Debug.ShouldStop(1);
_egresosactuales = RemoteObject.solve(new RemoteObject[] {_egresosactuales,_monto}, "+",1, 1);Debug.locals.put("egresosActuales", _egresosactuales);
 BA.debugLineNum = 483;BA.debugLine="Do Until (DateTime.Add(fechaPagoLong, 0, 0, pe";
Debug.ShouldStop(4);
while (!((RemoteObject.solveBoolean(">",main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Add",(Object)(_fechapagolong),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_periodo)),_fechaactuallong)))) {
 BA.debugLineNum = 484;BA.debugLine="egresosActuales = egresosActuales + monto";
Debug.ShouldStop(8);
_egresosactuales = RemoteObject.solve(new RemoteObject[] {_egresosactuales,_monto}, "+",1, 1);Debug.locals.put("egresosActuales", _egresosactuales);
 BA.debugLineNum = 486;BA.debugLine="fechaActual = DateTime.Now";
Debug.ShouldStop(32);
_fechaactual = BA.NumberToString(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 487;BA.debugLine="fechaActual = DateTime.Date(fechaActual)";
Debug.ShouldStop(64);
_fechaactual = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(BA.numberCast(long.class, _fechaactual)));Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 488;BA.debugLine="fechaActualLong = DateTime.DateParse(fechaAct";
Debug.ShouldStop(128);
_fechaactuallong = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateParse",(Object)(_fechaactual));Debug.locals.put("fechaActualLong", _fechaactuallong);
 BA.debugLineNum = 489;BA.debugLine="fechaPagoLong = DateTime.Add(fechaPagoLong, 0";
Debug.ShouldStop(256);
_fechapagolong = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Add",(Object)(_fechapagolong),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_periodo));Debug.locals.put("fechaPagoLong", _fechapagolong);
 }
;
 BA.debugLineNum = 492;BA.debugLine="fechaPagoLong = DateTime.Add(fechaPagoLong, 0,";
Debug.ShouldStop(2048);
_fechapagolong = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Add",(Object)(_fechapagolong),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_periodo));Debug.locals.put("fechaPagoLong", _fechapagolong);
 BA.debugLineNum = 493;BA.debugLine="fechaPago = DateTime.Date(fechaPagoLong)";
Debug.ShouldStop(4096);
_fechapago = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(_fechapagolong));Debug.locals.put("fechaPago", _fechapago);
 };
 BA.debugLineNum = 496;BA.debugLine="sql.ExecNonQuery2(\"UPDATE egresos SET suma_egre";
Debug.ShouldStop(32768);
main._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE egresos SET suma_egresos = ?  WHERE id_egreso = 1")),(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_egresosactuales)})))));
 BA.debugLineNum = 497;BA.debugLine="sql.ExecNonQuery2(\"UPDATE suscripciones SET fec";
Debug.ShouldStop(65536);
main._sql.runVoidMethod ("ExecNonQuery2",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE suscripciones SET fecha_pago = ? WHERE id_suscripcion = '"),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_contador),RemoteObject.createImmutable(1)}, "+",1, 1)),RemoteObject.createImmutable("'"))),(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_fechapago)})))));
 BA.debugLineNum = 498;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM suscripcione";
Debug.ShouldStop(131072);
main.mostCurrent._cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM suscripciones WHERE id_suscripcion = '"),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_contador),RemoteObject.createImmutable(1)}, "+",1, 1)),RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 499;BA.debugLine="cur.Position = 0";
Debug.ShouldStop(262144);
main.mostCurrent._cur.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 }
}Debug.locals.put("contador", _contador);
;
 };
 BA.debugLineNum = 502;BA.debugLine="cur1 = sql.ExecQuery(\"SELECT * FROM metas_ahorro";
Debug.ShouldStop(2097152);
_cur1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM metas_ahorro ORDER BY rowid ASC"))));
 BA.debugLineNum = 503;BA.debugLine="cur2 = sql.ExecQuery(\"SELECT * FROM egresos\")";
Debug.ShouldStop(4194304);
_cur2 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM egresos"))));
 BA.debugLineNum = 505;BA.debugLine="egresosActuales = 0";
Debug.ShouldStop(16777216);
_egresosactuales = BA.numberCast(int.class, 0);Debug.locals.put("egresosActuales", _egresosactuales);
 BA.debugLineNum = 507;BA.debugLine="If(cur1.RowCount <> 0) Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("!",_cur1.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 508;BA.debugLine="For contador = 0  To cur1.RowCount - 1 Step 1";
Debug.ShouldStop(134217728);
{
final int step48 = 1;
final int limit48 = RemoteObject.solve(new RemoteObject[] {_cur1.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_contador = 0 ;
for (;(step48 > 0 && _contador <= limit48) || (step48 < 0 && _contador >= limit48) ;_contador = ((int)(0 + _contador + step48))  ) {
Debug.locals.put("contador", _contador);
 BA.debugLineNum = 509;BA.debugLine="cur1.Position = contador";
Debug.ShouldStop(268435456);
_cur1.runMethod(true,"setPosition",BA.numberCast(int.class, _contador));
 BA.debugLineNum = 510;BA.debugLine="cur2.Position = 0";
Debug.ShouldStop(536870912);
_cur2.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 511;BA.debugLine="progreso = cur1.GetInt(\"progreso\")";
Debug.ShouldStop(1073741824);
_progreso = _cur1.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("progreso")));Debug.locals.put("progreso", _progreso);
 BA.debugLineNum = 512;BA.debugLine="montoMeta = cur1.getInt(\"monto_meta\")";
Debug.ShouldStop(-2147483648);
_montometa = _cur1.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("monto_meta")));Debug.locals.put("montoMeta", _montometa);
 BA.debugLineNum = 514;BA.debugLine="egresosActuales = cur2.GetInt(\"suma_egresos\")";
Debug.ShouldStop(2);
_egresosactuales = _cur2.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("suma_egresos")));Debug.locals.put("egresosActuales", _egresosactuales);
 BA.debugLineNum = 515;BA.debugLine="monto = cur1.GetInt(\"monto_ahorro\")";
Debug.ShouldStop(4);
_monto = _cur1.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("monto_ahorro")));Debug.locals.put("monto", _monto);
 BA.debugLineNum = 516;BA.debugLine="periodo = cur1.GetInt(\"periodo_ahorro\")";
Debug.ShouldStop(8);
_periodo = _cur1.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("periodo_ahorro")));Debug.locals.put("periodo", _periodo);
 BA.debugLineNum = 519;BA.debugLine="fechaPago = cur1.GetString(\"fecha_pago\").Replac";
Debug.ShouldStop(64);
_fechapago = _cur1.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("fecha_pago"))).runMethod(true,"replace",(Object)(BA.ObjectToString("-")),(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("fechaPago", _fechapago);
 BA.debugLineNum = 520;BA.debugLine="fechaPagoLong = DateTime.DateParse(fechaPago)";
Debug.ShouldStop(128);
_fechapagolong = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateParse",(Object)(_fechapago));Debug.locals.put("fechaPagoLong", _fechapagolong);
 BA.debugLineNum = 522;BA.debugLine="If(fechaPagoLong <= fechaActualLong) Then";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean("k",_fechapagolong,_fechaactuallong))) { 
 BA.debugLineNum = 523;BA.debugLine="If(progreso + monto <= montoMeta) Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("k",RemoteObject.solve(new RemoteObject[] {_progreso,_monto}, "+",1, 1),BA.numberCast(double.class, _montometa)))) { 
 BA.debugLineNum = 524;BA.debugLine="egresosActuales = egresosActuales + monto";
Debug.ShouldStop(2048);
_egresosactuales = RemoteObject.solve(new RemoteObject[] {_egresosactuales,_monto}, "+",1, 1);Debug.locals.put("egresosActuales", _egresosactuales);
 BA.debugLineNum = 525;BA.debugLine="progreso = progreso + monto";
Debug.ShouldStop(4096);
_progreso = RemoteObject.solve(new RemoteObject[] {_progreso,_monto}, "+",1, 1);Debug.locals.put("progreso", _progreso);
 }else {
 BA.debugLineNum = 527;BA.debugLine="egresosActuales = montoMeta - progreso";
Debug.ShouldStop(16384);
_egresosactuales = RemoteObject.solve(new RemoteObject[] {_montometa,_progreso}, "-",1, 1);Debug.locals.put("egresosActuales", _egresosactuales);
 BA.debugLineNum = 528;BA.debugLine="progreso = montoMeta";
Debug.ShouldStop(32768);
_progreso = _montometa;Debug.locals.put("progreso", _progreso);
 };
 BA.debugLineNum = 531;BA.debugLine="Do Until (DateTime.Add(fechaPagoLong, 0, 0, pe";
Debug.ShouldStop(262144);
while (!((RemoteObject.solveBoolean(">",main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Add",(Object)(_fechapagolong),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_periodo)),_fechaactuallong)))) {
 BA.debugLineNum = 532;BA.debugLine="If(progreso + monto <= montoMeta) Then";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("k",RemoteObject.solve(new RemoteObject[] {_progreso,_monto}, "+",1, 1),BA.numberCast(double.class, _montometa)))) { 
 BA.debugLineNum = 533;BA.debugLine="egresosActuales = egresosActuales + monto";
Debug.ShouldStop(1048576);
_egresosactuales = RemoteObject.solve(new RemoteObject[] {_egresosactuales,_monto}, "+",1, 1);Debug.locals.put("egresosActuales", _egresosactuales);
 BA.debugLineNum = 534;BA.debugLine="progreso = progreso + monto";
Debug.ShouldStop(2097152);
_progreso = RemoteObject.solve(new RemoteObject[] {_progreso,_monto}, "+",1, 1);Debug.locals.put("progreso", _progreso);
 }else {
 BA.debugLineNum = 536;BA.debugLine="egresosActuales = montoMeta - progreso";
Debug.ShouldStop(8388608);
_egresosactuales = RemoteObject.solve(new RemoteObject[] {_montometa,_progreso}, "-",1, 1);Debug.locals.put("egresosActuales", _egresosactuales);
 BA.debugLineNum = 537;BA.debugLine="progreso = montoMeta";
Debug.ShouldStop(16777216);
_progreso = _montometa;Debug.locals.put("progreso", _progreso);
 };
 BA.debugLineNum = 540;BA.debugLine="fechaActual = DateTime.Now";
Debug.ShouldStop(134217728);
_fechaactual = BA.NumberToString(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 541;BA.debugLine="fechaActual = DateTime.Date(fechaActual)";
Debug.ShouldStop(268435456);
_fechaactual = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(BA.numberCast(long.class, _fechaactual)));Debug.locals.put("fechaActual", _fechaactual);
 BA.debugLineNum = 542;BA.debugLine="fechaActualLong = DateTime.DateParse(fechaAct";
Debug.ShouldStop(536870912);
_fechaactuallong = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateParse",(Object)(_fechaactual));Debug.locals.put("fechaActualLong", _fechaactuallong);
 BA.debugLineNum = 543;BA.debugLine="fechaPagoLong = DateTime.Add(fechaPagoLong, 0";
Debug.ShouldStop(1073741824);
_fechapagolong = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Add",(Object)(_fechapagolong),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_periodo));Debug.locals.put("fechaPagoLong", _fechapagolong);
 }
;
 BA.debugLineNum = 546;BA.debugLine="fechaPagoLong = DateTime.Add(fechaPagoLong, 0,";
Debug.ShouldStop(2);
_fechapagolong = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Add",(Object)(_fechapagolong),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_periodo));Debug.locals.put("fechaPagoLong", _fechapagolong);
 BA.debugLineNum = 547;BA.debugLine="fechaPago = DateTime.Date(fechaPagoLong)";
Debug.ShouldStop(4);
_fechapago = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(_fechapagolong));Debug.locals.put("fechaPago", _fechapago);
 };
 BA.debugLineNum = 550;BA.debugLine="sql.ExecNonQuery2(\"UPDATE egresos SET suma_egre";
Debug.ShouldStop(32);
main._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE egresos SET suma_egresos = ?  WHERE id_egreso = 1")),(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_egresosactuales)})))));
 BA.debugLineNum = 551;BA.debugLine="sql.ExecNonQuery2(\"UPDATE metas_ahorro SET fech";
Debug.ShouldStop(64);
main._sql.runVoidMethod ("ExecNonQuery2",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE metas_ahorro SET fecha_pago = ?, progreso = ? WHERE id_meta_ahorro = '"),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_contador),RemoteObject.createImmutable(1)}, "+",1, 1)),RemoteObject.createImmutable("'"))),(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_fechapago),(_progreso)})))));
 }
}Debug.locals.put("contador", _contador);
;
 };
 BA.debugLineNum = 554;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _verificarprimeringreso() throws Exception{
try {
		Debug.PushSubsStack("verificarPrimerIngreso (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,71);
if (RapidSub.canDelegate("verificarprimeringreso")) { return pullup.wallet.main.remoteMe.runUserSub(false, "main","verificarprimeringreso");}
 BA.debugLineNum = 71;BA.debugLine="Sub verificarPrimerIngreso";
Debug.ShouldStop(64);
 BA.debugLineNum = 72;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM primer_uso\")";
Debug.ShouldStop(128);
main.mostCurrent._cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM primer_uso"))));
 BA.debugLineNum = 73;BA.debugLine="If(cur.RowCount = 0) Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._cur.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0)))) { 
 BA.debugLineNum = 74;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO primer_uso (ingre";
Debug.ShouldStop(512);
main._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO primer_uso (ingreso) VALUES (?)")),(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(RemoteObject.createImmutable("Pull Up"))})))));
 BA.debugLineNum = 75;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO ingresos (suma_in";
Debug.ShouldStop(1024);
main._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO ingresos (suma_ingresos) VALUES (?)")),(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0))})))));
 BA.debugLineNum = 76;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO egresos (suma_egr";
Debug.ShouldStop(2048);
main._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO egresos (suma_egresos) VALUES (?)")),(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {RemoteObject.createImmutable((0))})))));
 BA.debugLineNum = 77;BA.debugLine="StartActivity(Tutorial)";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._tutorial.getObject())));
 };
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}