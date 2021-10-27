
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

public class editargasto implements IRemote{
	public static editargasto mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public editargasto() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("editargasto"), "pullup.wallet.editargasto");
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
		pcBA = new PCBA(this, editargasto.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _sql = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL");
public static RemoteObject _alturadispositivo = RemoteObject.createImmutable(0);
public static RemoteObject _anchodispositivo = RemoteObject.createImmutable(0);
public static RemoteObject _colorcaja = RemoteObject.createImmutable(0);
public static RemoteObject _aparicionmsgbox1 = RemoteObject.createImmutable(false);
public static RemoteObject _aparicionmsgbox2 = RemoteObject.createImmutable(false);
public static RemoteObject _aparicionmsgbox3 = RemoteObject.createImmutable(false);
public static RemoteObject _cur = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
public static RemoteObject _idregistro = RemoteObject.createImmutable(0);
public static RemoteObject _sumaegresosantigua = RemoteObject.createImmutable(0);
public static RemoteObject _montoantiguo = RemoteObject.createImmutable(0);
public static RemoteObject _montonuevo = RemoteObject.createImmutable(0);
public static RemoteObject _sumaegresosactual = RemoteObject.createImmutable(0);
public static RemoteObject _btnmenu = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnoperaciongasto = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _txtdescripcion = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtmonto = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtnombre = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _lblfondomonto = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblfondodescripcion = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblfondonombre = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblcontornoboton = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblnombrevista = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pnlnavinferior = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlselector = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _cpbarracolor = RemoteObject.declareNull("pullup.wallet.ascolorslider");
public static pullup.wallet.main _main = null;
public static pullup.wallet.starter _starter = null;
public static pullup.wallet.tutorial _tutorial = null;
public static pullup.wallet.diapositivas _diapositivas = null;
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
public static pullup.wallet.registraringreso _registraringreso = null;
public static pullup.wallet.registrarmetaahorro _registrarmetaahorro = null;
public static pullup.wallet.registrarsuscripcion _registrarsuscripcion = null;
public static pullup.wallet.suscripciones _suscripciones = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",editargasto.mostCurrent._activity,"alturaDispositivo",editargasto._alturadispositivo,"anchoDispositivo",editargasto._anchodispositivo,"aparicionMsgBox1",editargasto._aparicionmsgbox1,"aparicionMsgBox2",editargasto._aparicionmsgbox2,"aparicionMsgBox3",editargasto._aparicionmsgbox3,"btnMenu",editargasto.mostCurrent._btnmenu,"btnOperacionGasto",editargasto.mostCurrent._btnoperaciongasto,"colorCaja",editargasto._colorcaja,"cpBarraColor",editargasto.mostCurrent._cpbarracolor,"cur",editargasto.mostCurrent._cur,"Diapositivas",Debug.moduleToString(pullup.wallet.diapositivas.class),"editarIngresoRecurrente",Debug.moduleToString(pullup.wallet.editaringresorecurrente.class),"editarIngresoUnico",Debug.moduleToString(pullup.wallet.editaringresounico.class),"editarMetaAhorro",Debug.moduleToString(pullup.wallet.editarmetaahorro.class),"editarSuscripcion",Debug.moduleToString(pullup.wallet.editarsuscripcion.class),"Gastos",Debug.moduleToString(pullup.wallet.gastos.class),"Historiales",Debug.moduleToString(pullup.wallet.historiales.class),"idRegistro",editargasto._idregistro,"IngresosRecurrentes",Debug.moduleToString(pullup.wallet.ingresosrecurrentes.class),"IngresosUnicos",Debug.moduleToString(pullup.wallet.ingresosunicos.class),"lblContornoBoton",editargasto.mostCurrent._lblcontornoboton,"lblFondoDescripcion",editargasto.mostCurrent._lblfondodescripcion,"lblFondoMonto",editargasto.mostCurrent._lblfondomonto,"lblFondoNombre",editargasto.mostCurrent._lblfondonombre,"lblNombreVista",editargasto.mostCurrent._lblnombrevista,"Main",Debug.moduleToString(pullup.wallet.main.class),"MetasDeAhorro",Debug.moduleToString(pullup.wallet.metasdeahorro.class),"montoAntiguo",editargasto._montoantiguo,"montoNuevo",editargasto._montonuevo,"pnlNavInferior",editargasto.mostCurrent._pnlnavinferior,"pnlSelector",editargasto.mostCurrent._pnlselector,"registrarGasto",Debug.moduleToString(pullup.wallet.registrargasto.class),"registrarIngreso",Debug.moduleToString(pullup.wallet.registraringreso.class),"registrarMetaAhorro",Debug.moduleToString(pullup.wallet.registrarmetaahorro.class),"registrarSuscripcion",Debug.moduleToString(pullup.wallet.registrarsuscripcion.class),"sql",editargasto._sql,"Starter",Debug.moduleToString(pullup.wallet.starter.class),"sumaEgresosActual",editargasto._sumaegresosactual,"sumaEgresosAntigua",editargasto._sumaegresosantigua,"Suscripciones",Debug.moduleToString(pullup.wallet.suscripciones.class),"Tutorial",Debug.moduleToString(pullup.wallet.tutorial.class),"txtDescripcion",editargasto.mostCurrent._txtdescripcion,"txtMonto",editargasto.mostCurrent._txtmonto,"txtNombre",editargasto.mostCurrent._txtnombre};
}
}