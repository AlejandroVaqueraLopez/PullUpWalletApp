
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

public class diapositivas implements IRemote{
	public static diapositivas mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public diapositivas() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
     private static PCBA pcBA = new PCBA(null, diapositivas.class);
    static {
		mostCurrent = new diapositivas();
        remoteMe = RemoteObject.declareNull("pullup.wallet.diapositivas");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("diapositivas"), "pullup.wallet.diapositivas");
        RDebug.INSTANCE.eventTargets.put(new DeviceClass("pullup.wallet.diapositivas"), new java.lang.ref.WeakReference<PCBA> (pcBA));
	}
   
	public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
	public PCBA create(Object[] args) throws ClassNotFoundException{
        throw new RuntimeException("CREATE is not supported.");
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _panel_left = RemoteObject.createImmutable(0);
public static RemoteObject _panel_right = RemoteObject.createImmutable(0);
public static RemoteObject _leftpanel = RemoteObject.createImmutable(0);
public static pullup.wallet.main _main = null;
public static pullup.wallet.starter _starter = null;
public static pullup.wallet.tutorial _tutorial = null;
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
public static pullup.wallet.registraringreso _registraringreso = null;
public static pullup.wallet.registrarmetaahorro _registrarmetaahorro = null;
public static pullup.wallet.registrarsuscripcion _registrarsuscripcion = null;
public static pullup.wallet.suscripciones _suscripciones = null;
  public Object[] GetGlobals() {
		return new Object[] {"editarGasto",Debug.moduleToString(pullup.wallet.editargasto.class),"editarIngresoRecurrente",Debug.moduleToString(pullup.wallet.editaringresorecurrente.class),"editarIngresoUnico",Debug.moduleToString(pullup.wallet.editaringresounico.class),"editarMetaAhorro",Debug.moduleToString(pullup.wallet.editarmetaahorro.class),"editarSuscripcion",Debug.moduleToString(pullup.wallet.editarsuscripcion.class),"Gastos",Debug.moduleToString(pullup.wallet.gastos.class),"Historiales",Debug.moduleToString(pullup.wallet.historiales.class),"IngresosRecurrentes",Debug.moduleToString(pullup.wallet.ingresosrecurrentes.class),"IngresosUnicos",Debug.moduleToString(pullup.wallet.ingresosunicos.class),"leftPanel",diapositivas._leftpanel,"Main",Debug.moduleToString(pullup.wallet.main.class),"MetasDeAhorro",Debug.moduleToString(pullup.wallet.metasdeahorro.class),"PANEL_LEFT",diapositivas._panel_left,"PANEL_RIGHT",diapositivas._panel_right,"registrarGasto",Debug.moduleToString(pullup.wallet.registrargasto.class),"registrarIngreso",Debug.moduleToString(pullup.wallet.registraringreso.class),"registrarMetaAhorro",Debug.moduleToString(pullup.wallet.registrarmetaahorro.class),"registrarSuscripcion",Debug.moduleToString(pullup.wallet.registrarsuscripcion.class),"Starter",Debug.moduleToString(pullup.wallet.starter.class),"Suscripciones",Debug.moduleToString(pullup.wallet.suscripciones.class),"Tutorial",Debug.moduleToString(pullup.wallet.tutorial.class)};
}
}