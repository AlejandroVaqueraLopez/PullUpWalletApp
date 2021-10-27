
package pullup.wallet;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class registraringreso implements IRemote{
	public static registraringreso mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public registraringreso() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("registraringreso"), "pullup.wallet.registraringreso");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, registraringreso.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _sql = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL");
public static RemoteObject _alturadispositivo = RemoteObject.createImmutable(0);
public static RemoteObject _anchodispositivo = RemoteObject.createImmutable(0);
public static RemoteObject _tipoingreso = RemoteObject.createImmutable("");
public static RemoteObject _colorcaja = RemoteObject.createImmutable(0);
public static RemoteObject _diasperiodo = RemoteObject.createImmutable(0);
public static RemoteObject _aparicionmsgbox1 = RemoteObject.createImmutable(false);
public static RemoteObject _aparicionmsgbox2 = RemoteObject.createImmutable(false);
public static RemoteObject _aparicionmsgbox3 = RemoteObject.createImmutable(false);
public static RemoteObject _esquinas = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
public static RemoteObject _esquinas2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
public static RemoteObject _cur = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
public static RemoteObject _ingresosactuales = RemoteObject.createImmutable(0);
public static RemoteObject _btnmenu = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnoperacioningreso = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnrecurrente = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnunico = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _txtdescripcion = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtmonto = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtnombre = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _lblcontornoboton = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblfondodescripcion = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblfondomonto = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblfondonombre = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblnombrevista = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _rd1ano = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _rd1mes = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _rd1semana = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _rd2semanas = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _rd3semanas = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _pnlperiodos = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlselector = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlnavinferior = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _cpbarracolor = RemoteObject.declareNull("pullup.wallet.ascolorslider");
public static pullup.wallet.main _main = null;
public static pullup.wallet.starter _starter = null;
public static pullup.wallet.tutorial _tutorial = null;
public static pullup.wallet.diapositivas _diapositivas = null;
public static pullup.wallet.editargasto _editargasto = null;
public static pullup.wallet.editaringresorecurrente _editaringresorecurrente = null;
public static pullup.wallet.editaringresounico _editaringresounico = null;
public static pullup.wallet.editarmetaahorro _editarmetaahorro = null;
public static pullup.wallet.editarsuscripcion _editarsuscripcion = null;
public static pullup.wallet.gastos _gastos = null;
public static pullup.wallet.historiales _historiales = null;
public static pullup.wallet.ingresosrecurrentes _ingresosrecurrentes = null;
public static pullup.wallet.ingresosunicos _ingresosunicos = null;
public static pullup.wallet.metasdeahorro _metasdeahorro = null;
public static pullup.wallet.registrargasto _registrargasto = null;
public static pullup.wallet.registrarmetaahorro _registrarmetaahorro = null;
public static pullup.wallet.registrarsuscripcion _registrarsuscripcion = null;
public static pullup.wallet.suscripciones _suscripciones = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",registraringreso.mostCurrent._activity,"alturaDispositivo",registraringreso._alturadispositivo,"anchoDispositivo",registraringreso._anchodispositivo,"aparicionMsgBox1",registraringreso._aparicionmsgbox1,"aparicionMsgBox2",registraringreso._aparicionmsgbox2,"aparicionMsgBox3",registraringreso._aparicionmsgbox3,"btnMenu",registraringreso.mostCurrent._btnmenu,"btnOperacionIngreso",registraringreso.mostCurrent._btnoperacioningreso,"btnRecurrente",registraringreso.mostCurrent._btnrecurrente,"btnUnico",registraringreso.mostCurrent._btnunico,"colorCaja",registraringreso._colorcaja,"cpBarraColor",registraringreso.mostCurrent._cpbarracolor,"cur",registraringreso.mostCurrent._cur,"Diapositivas",Debug.moduleToString(pullup.wallet.diapositivas.class),"diasPeriodo",registraringreso._diasperiodo,"editarGasto",Debug.moduleToString(pullup.wallet.editargasto.class),"editarIngresoRecurrente",Debug.moduleToString(pullup.wallet.editaringresorecurrente.class),"editarIngresoUnico",Debug.moduleToString(pullup.wallet.editaringresounico.class),"editarMetaAhorro",Debug.moduleToString(pullup.wallet.editarmetaahorro.class),"editarSuscripcion",Debug.moduleToString(pullup.wallet.editarsuscripcion.class),"esquinas",registraringreso.mostCurrent._esquinas,"esquinas2",registraringreso.mostCurrent._esquinas2,"Gastos",Debug.moduleToString(pullup.wallet.gastos.class),"Historiales",Debug.moduleToString(pullup.wallet.historiales.class),"ingresosActuales",registraringreso._ingresosactuales,"IngresosRecurrentes",Debug.moduleToString(pullup.wallet.ingresosrecurrentes.class),"IngresosUnicos",Debug.moduleToString(pullup.wallet.ingresosunicos.class),"lblContornoBoton",registraringreso.mostCurrent._lblcontornoboton,"lblFondoDescripcion",registraringreso.mostCurrent._lblfondodescripcion,"lblFondoMonto",registraringreso.mostCurrent._lblfondomonto,"lblFondoNombre",registraringreso.mostCurrent._lblfondonombre,"lblNombreVista",registraringreso.mostCurrent._lblnombrevista,"Main",Debug.moduleToString(pullup.wallet.main.class),"MetasDeAhorro",Debug.moduleToString(pullup.wallet.metasdeahorro.class),"pnlNavInferior",registraringreso.mostCurrent._pnlnavinferior,"pnlPeriodos",registraringreso.mostCurrent._pnlperiodos,"pnlSelector",registraringreso.mostCurrent._pnlselector,"rd1Ano",registraringreso.mostCurrent._rd1ano,"rd1Mes",registraringreso.mostCurrent._rd1mes,"rd1Semana",registraringreso.mostCurrent._rd1semana,"rd2Semanas",registraringreso.mostCurrent._rd2semanas,"rd3Semanas",registraringreso.mostCurrent._rd3semanas,"registrarGasto",Debug.moduleToString(pullup.wallet.registrargasto.class),"registrarMetaAhorro",Debug.moduleToString(pullup.wallet.registrarmetaahorro.class),"registrarSuscripcion",Debug.moduleToString(pullup.wallet.registrarsuscripcion.class),"sql",registraringreso._sql,"Starter",Debug.moduleToString(pullup.wallet.starter.class),"Suscripciones",Debug.moduleToString(pullup.wallet.suscripciones.class),"tipoIngreso",registraringreso.mostCurrent._tipoingreso,"Tutorial",Debug.moduleToString(pullup.wallet.tutorial.class),"txtDescripcion",registraringreso.mostCurrent._txtdescripcion,"txtMonto",registraringreso.mostCurrent._txtmonto,"txtNombre",registraringreso.mostCurrent._txtnombre};
}
}