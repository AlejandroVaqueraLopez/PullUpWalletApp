package pullup.wallet;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "pullup.wallet", "pullup.wallet.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "pullup.wallet", "pullup.wallet.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "pullup.wallet.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (tutorial.mostCurrent != null);
vis = vis | (editargasto.mostCurrent != null);
vis = vis | (editaringresorecurrente.mostCurrent != null);
vis = vis | (editaringresounico.mostCurrent != null);
vis = vis | (editarmetaahorro.mostCurrent != null);
vis = vis | (editarsuscripcion.mostCurrent != null);
vis = vis | (gastos.mostCurrent != null);
vis = vis | (historiales.mostCurrent != null);
vis = vis | (ingresosrecurrentes.mostCurrent != null);
vis = vis | (ingresosunicos.mostCurrent != null);
vis = vis | (metasdeahorro.mostCurrent != null);
vis = vis | (registrargasto.mostCurrent != null);
vis = vis | (registraringreso.mostCurrent != null);
vis = vis | (registrarmetaahorro.mostCurrent != null);
vis = vis | (registrarsuscripcion.mostCurrent != null);
vis = vis | (suscripciones.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
 {
            Activity __a = null;
            if (tutorial.previousOne != null) {
				__a = tutorial.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(tutorial.mostCurrent == null ? null : tutorial.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (editargasto.previousOne != null) {
				__a = editargasto.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(editargasto.mostCurrent == null ? null : editargasto.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (editaringresorecurrente.previousOne != null) {
				__a = editaringresorecurrente.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(editaringresorecurrente.mostCurrent == null ? null : editaringresorecurrente.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (editaringresounico.previousOne != null) {
				__a = editaringresounico.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(editaringresounico.mostCurrent == null ? null : editaringresounico.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (editarmetaahorro.previousOne != null) {
				__a = editarmetaahorro.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(editarmetaahorro.mostCurrent == null ? null : editarmetaahorro.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (editarsuscripcion.previousOne != null) {
				__a = editarsuscripcion.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(editarsuscripcion.mostCurrent == null ? null : editarsuscripcion.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (gastos.previousOne != null) {
				__a = gastos.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(gastos.mostCurrent == null ? null : gastos.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (historiales.previousOne != null) {
				__a = historiales.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(historiales.mostCurrent == null ? null : historiales.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (ingresosrecurrentes.previousOne != null) {
				__a = ingresosrecurrentes.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(ingresosrecurrentes.mostCurrent == null ? null : ingresosrecurrentes.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (ingresosunicos.previousOne != null) {
				__a = ingresosunicos.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(ingresosunicos.mostCurrent == null ? null : ingresosunicos.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (metasdeahorro.previousOne != null) {
				__a = metasdeahorro.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(metasdeahorro.mostCurrent == null ? null : metasdeahorro.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (registrargasto.previousOne != null) {
				__a = registrargasto.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(registrargasto.mostCurrent == null ? null : registrargasto.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (registraringreso.previousOne != null) {
				__a = registraringreso.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(registraringreso.mostCurrent == null ? null : registraringreso.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (registrarmetaahorro.previousOne != null) {
				__a = registrarmetaahorro.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(registrarmetaahorro.mostCurrent == null ? null : registrarmetaahorro.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (registrarsuscripcion.previousOne != null) {
				__a = registrarsuscripcion.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(registrarsuscripcion.mostCurrent == null ? null : registrarsuscripcion.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (suscripciones.previousOne != null) {
				__a = suscripciones.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(suscripciones.mostCurrent == null ? null : suscripciones.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

}
public static class _registrogasto{
public boolean IsInitialized;
public String nombre;
public int monto;
public String descripcion;
public String fechaRegistro;
public int color;
public void Initialize() {
IsInitialized = true;
nombre = "";
monto = 0;
descripcion = "";
fechaRegistro = "";
color = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _registrosuscripcion{
public boolean IsInitialized;
public String nombre;
public int monto;
public String descripcion;
public int periodo;
public String fechaPago;
public int color;
public void Initialize() {
IsInitialized = true;
nombre = "";
monto = 0;
descripcion = "";
periodo = 0;
fechaPago = "";
color = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _registrometaahorro{
public boolean IsInitialized;
public String nombre;
public int montoAhorro;
public int montoMeta;
public String descripcion;
public int periodo;
public int progreso;
public String fechaPago;
public int color;
public void Initialize() {
IsInitialized = true;
nombre = "";
montoAhorro = 0;
montoMeta = 0;
descripcion = "";
periodo = 0;
progreso = 0;
fechaPago = "";
color = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _registroingreso{
public boolean IsInitialized;
public String nombre;
public int monto;
public String descripcion;
public int periodo;
public String fechaCobro;
public int color;
public void Initialize() {
IsInitialized = true;
nombre = "";
monto = 0;
descripcion = "";
periodo = 0;
fechaCobro = "";
color = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public anywheresoftware.b4a.keywords.Common __c = null;
public static int _alturadispositivo = 0;
public static int _anchodispositivo = 0;
public static anywheresoftware.b4a.sql.SQL _sql = null;
public anywheresoftware.b4a.objects.CSBuilder _cs = null;
public static boolean _click = false;
public anywheresoftware.b4a.sql.SQL.CursorWrapper _cur = null;
public static int _balance = 0;
public static int _ingresos = 0;
public static int _egresos = 0;
public anywheresoftware.b4a.objects.ButtonWrapper _btningresosrecurrentes = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btningresosunicos = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btngastos = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnmetasdeahorro = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnsuscripciones = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnhistoriales = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnagregar = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnagregargasto = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnagregaringreso = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnagregarmetadeahorro = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnagregarsuscripcion = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btngenerarhistorial = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblexplora = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblcontornoboton = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbliconoegresos = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbliconoingresos = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblbalance = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblegresos = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblingresos = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblbalancetitulo = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblestado = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlbalance = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlopciones = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlnavinferior = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlagregar = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlcabecera = null;
public pullup.wallet.starter _starter = null;
public pullup.wallet.tutorial _tutorial = null;
public pullup.wallet.diapositivas _diapositivas = null;
public pullup.wallet.editargasto _editargasto = null;
public pullup.wallet.editaringresorecurrente _editaringresorecurrente = null;
public pullup.wallet.editaringresounico _editaringresounico = null;
public pullup.wallet.editarmetaahorro _editarmetaahorro = null;
public pullup.wallet.editarsuscripcion _editarsuscripcion = null;
public pullup.wallet.gastos _gastos = null;
public pullup.wallet.historiales _historiales = null;
public pullup.wallet.ingresosrecurrentes _ingresosrecurrentes = null;
public pullup.wallet.ingresosunicos _ingresosunicos = null;
public pullup.wallet.metasdeahorro _metasdeahorro = null;
public pullup.wallet.registrargasto _registrargasto = null;
public pullup.wallet.registraringreso _registraringreso = null;
public pullup.wallet.registrarmetaahorro _registrarmetaahorro = null;
public pullup.wallet.registrarsuscripcion _registrarsuscripcion = null;
public pullup.wallet.suscripciones _suscripciones = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="sql = Starter.sql";
_sql = mostCurrent._starter._sql /*anywheresoftware.b4a.sql.SQL*/ ;
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="verificarPrimerIngreso";
_verificarprimeringreso();
RDebugUtils.currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="If(FirstTime = True) Then";
if ((_firsttime==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=196612;
 //BA.debugLineNum = 196612;BA.debugLine="cobraIngresos";
_cobraingresos();
RDebugUtils.currentLine=196613;
 //BA.debugLineNum = 196613;BA.debugLine="realizaEgresos";
_realizaegresos();
 };
RDebugUtils.currentLine=196615;
 //BA.debugLineNum = 196615;BA.debugLine="Activity.LoadLayout(\"LMain\")";
mostCurrent._activity.LoadLayout("LMain",mostCurrent.activityBA);
RDebugUtils.currentLine=196616;
 //BA.debugLineNum = 196616;BA.debugLine="Activity.Color = Colors.ARGB(255, 233, 236, 239)";
mostCurrent._activity.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (233),(int) (236),(int) (239)));
RDebugUtils.currentLine=196617;
 //BA.debugLineNum = 196617;BA.debugLine="alturaDispositivo = GetDeviceLayoutValues.Height";
_alturadispositivo = anywheresoftware.b4a.keywords.Common.GetDeviceLayoutValues(mostCurrent.activityBA).Height;
RDebugUtils.currentLine=196618;
 //BA.debugLineNum = 196618;BA.debugLine="anchoDispositivo = GetDeviceLayoutValues.Width";
_anchodispositivo = anywheresoftware.b4a.keywords.Common.GetDeviceLayoutValues(mostCurrent.activityBA).Width;
RDebugUtils.currentLine=196619;
 //BA.debugLineNum = 196619;BA.debugLine="click = False";
_click = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=196620;
 //BA.debugLineNum = 196620;BA.debugLine="ingresos = balanceActualIngresos";
_ingresos = _balanceactualingresos();
RDebugUtils.currentLine=196621;
 //BA.debugLineNum = 196621;BA.debugLine="egresos = balanceActualEgresos";
_egresos = _balanceactualegresos();
RDebugUtils.currentLine=196622;
 //BA.debugLineNum = 196622;BA.debugLine="balance = balanceGeneral";
_balance = _balancegeneral();
RDebugUtils.currentLine=196625;
 //BA.debugLineNum = 196625;BA.debugLine="pnlCabecera.Height = alturaDispositivo * 0.07";
mostCurrent._pnlcabecera.setHeight((int) (_alturadispositivo*0.07));
RDebugUtils.currentLine=196626;
 //BA.debugLineNum = 196626;BA.debugLine="pnlCabecera.Width = anchoDispositivo * 0.9";
mostCurrent._pnlcabecera.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=196627;
 //BA.debugLineNum = 196627;BA.debugLine="pnlCabecera.Left = (anchoDispositivo - pnlCabecer";
mostCurrent._pnlcabecera.setLeft((int) ((_anchodispositivo-mostCurrent._pnlcabecera.getWidth())/(double)2));
RDebugUtils.currentLine=196630;
 //BA.debugLineNum = 196630;BA.debugLine="lblEstado.Height = pnlCabecera.Height";
mostCurrent._lblestado.setHeight(mostCurrent._pnlcabecera.getHeight());
RDebugUtils.currentLine=196631;
 //BA.debugLineNum = 196631;BA.debugLine="lblEstado.Width = lblEstado.Height";
mostCurrent._lblestado.setWidth(mostCurrent._lblestado.getHeight());
RDebugUtils.currentLine=196632;
 //BA.debugLineNum = 196632;BA.debugLine="lblEstado.Color = Colors.Transparent";
mostCurrent._lblestado.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=196633;
 //BA.debugLineNum = 196633;BA.debugLine="lblEstado.TextSize = 24";
mostCurrent._lblestado.setTextSize((float) (24));
RDebugUtils.currentLine=196634;
 //BA.debugLineNum = 196634;BA.debugLine="lblEstado.Gravity = Gravity.CENTER";
mostCurrent._lblestado.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=196635;
 //BA.debugLineNum = 196635;BA.debugLine="estadoBalance(balance)";
_estadobalance(_balance);
RDebugUtils.currentLine=196640;
 //BA.debugLineNum = 196640;BA.debugLine="pnlBalance.Width = anchoDispositivo * 0.9";
mostCurrent._pnlbalance.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=196641;
 //BA.debugLineNum = 196641;BA.debugLine="pnlBalance.Height = alturaDispositivo * 0.2";
mostCurrent._pnlbalance.setHeight((int) (_alturadispositivo*0.2));
RDebugUtils.currentLine=196642;
 //BA.debugLineNum = 196642;BA.debugLine="pnlBalance.Left = (anchoDispositivo - pnlBalance.";
mostCurrent._pnlbalance.setLeft((int) ((_anchodispositivo-mostCurrent._pnlbalance.getWidth())/(double)2));
RDebugUtils.currentLine=196643;
 //BA.debugLineNum = 196643;BA.debugLine="pnlBalance.Top = pnlCabecera.Top + pnlCabecera.He";
mostCurrent._pnlbalance.setTop((int) (mostCurrent._pnlcabecera.getTop()+mostCurrent._pnlcabecera.getHeight()+50));
RDebugUtils.currentLine=196647;
 //BA.debugLineNum = 196647;BA.debugLine="lblBalanceTitulo.Top = pnlBalance.Height * 0.05";
mostCurrent._lblbalancetitulo.setTop((int) (mostCurrent._pnlbalance.getHeight()*0.05));
RDebugUtils.currentLine=196648;
 //BA.debugLineNum = 196648;BA.debugLine="lblBalanceTitulo.Gravity = Gravity.CENTER_HORIZON";
mostCurrent._lblbalancetitulo.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
RDebugUtils.currentLine=196650;
 //BA.debugLineNum = 196650;BA.debugLine="lblBalance.Top = lblBalanceTitulo.Top + lblBalanc";
mostCurrent._lblbalance.setTop((int) (mostCurrent._lblbalancetitulo.getTop()+mostCurrent._lblbalancetitulo.getHeight()));
RDebugUtils.currentLine=196651;
 //BA.debugLineNum = 196651;BA.debugLine="lblBalance.Gravity = Gravity.CENTER_HORIZONTAL";
mostCurrent._lblbalance.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
RDebugUtils.currentLine=196652;
 //BA.debugLineNum = 196652;BA.debugLine="lblBalance.Text = \"$\" & balance & \".00\"";
mostCurrent._lblbalance.setText(BA.ObjectToCharSequence("$"+BA.NumberToString(_balance)+".00"));
RDebugUtils.currentLine=196653;
 //BA.debugLineNum = 196653;BA.debugLine="lblBalance.TextSize = 16";
mostCurrent._lblbalance.setTextSize((float) (16));
RDebugUtils.currentLine=196655;
 //BA.debugLineNum = 196655;BA.debugLine="lblIconoIngresos.Left = lblBalanceTitulo.Top";
mostCurrent._lbliconoingresos.setLeft(mostCurrent._lblbalancetitulo.getTop());
RDebugUtils.currentLine=196656;
 //BA.debugLineNum = 196656;BA.debugLine="lblIconoIngresos.Top = pnlBalance.Height * 0.35";
mostCurrent._lbliconoingresos.setTop((int) (mostCurrent._pnlbalance.getHeight()*0.35));
RDebugUtils.currentLine=196658;
 //BA.debugLineNum = 196658;BA.debugLine="lblIngresos.Height = lblIconoIngresos.Height";
mostCurrent._lblingresos.setHeight(mostCurrent._lbliconoingresos.getHeight());
RDebugUtils.currentLine=196659;
 //BA.debugLineNum = 196659;BA.debugLine="lblIngresos.Width = (pnlBalance.Width / 2) - (lbl";
mostCurrent._lblingresos.setWidth((int) ((mostCurrent._pnlbalance.getWidth()/(double)2)-(mostCurrent._lbliconoingresos.getLeft()*2+mostCurrent._lbliconoingresos.getWidth())));
RDebugUtils.currentLine=196660;
 //BA.debugLineNum = 196660;BA.debugLine="lblIngresos.Left = lblIconoIngresos.Left * 2 + lb";
mostCurrent._lblingresos.setLeft((int) (mostCurrent._lbliconoingresos.getLeft()*2+mostCurrent._lbliconoingresos.getWidth()));
RDebugUtils.currentLine=196661;
 //BA.debugLineNum = 196661;BA.debugLine="lblIngresos.Top = lblIconoIngresos.Top";
mostCurrent._lblingresos.setTop(mostCurrent._lbliconoingresos.getTop());
RDebugUtils.currentLine=196662;
 //BA.debugLineNum = 196662;BA.debugLine="lblIngresos.Text = \"$\" & ingresos & \".00\"";
mostCurrent._lblingresos.setText(BA.ObjectToCharSequence("$"+BA.NumberToString(_ingresos)+".00"));
RDebugUtils.currentLine=196663;
 //BA.debugLineNum = 196663;BA.debugLine="lblIngresos.TextSize = 13";
mostCurrent._lblingresos.setTextSize((float) (13));
RDebugUtils.currentLine=196665;
 //BA.debugLineNum = 196665;BA.debugLine="lblIconoEgresos.Left = pnlBalance.Width / 2 + lbl";
mostCurrent._lbliconoegresos.setLeft((int) (mostCurrent._pnlbalance.getWidth()/(double)2+mostCurrent._lbliconoingresos.getLeft()));
RDebugUtils.currentLine=196666;
 //BA.debugLineNum = 196666;BA.debugLine="lblIconoEgresos.Top = lblIconoIngresos.Top";
mostCurrent._lbliconoegresos.setTop(mostCurrent._lbliconoingresos.getTop());
RDebugUtils.currentLine=196668;
 //BA.debugLineNum = 196668;BA.debugLine="lblEgresos.Height = lblIconoEgresos.Height";
mostCurrent._lblegresos.setHeight(mostCurrent._lbliconoegresos.getHeight());
RDebugUtils.currentLine=196669;
 //BA.debugLineNum = 196669;BA.debugLine="lblEgresos.Width = lblIngresos.Width";
mostCurrent._lblegresos.setWidth(mostCurrent._lblingresos.getWidth());
RDebugUtils.currentLine=196670;
 //BA.debugLineNum = 196670;BA.debugLine="lblEgresos.Left = lblIconoEgresos.Left + lblIcono";
mostCurrent._lblegresos.setLeft((int) (mostCurrent._lbliconoegresos.getLeft()+mostCurrent._lbliconoegresos.getWidth()+mostCurrent._lbliconoingresos.getLeft()));
RDebugUtils.currentLine=196671;
 //BA.debugLineNum = 196671;BA.debugLine="lblEgresos.Top = lblIconoEgresos.Top";
mostCurrent._lblegresos.setTop(mostCurrent._lbliconoegresos.getTop());
RDebugUtils.currentLine=196672;
 //BA.debugLineNum = 196672;BA.debugLine="lblEgresos.Text = \"$\" & egresos & \".00\"";
mostCurrent._lblegresos.setText(BA.ObjectToCharSequence("$"+BA.NumberToString(_egresos)+".00"));
RDebugUtils.currentLine=196673;
 //BA.debugLineNum = 196673;BA.debugLine="lblEgresos.TextSize = 13";
mostCurrent._lblegresos.setTextSize((float) (13));
RDebugUtils.currentLine=196676;
 //BA.debugLineNum = 196676;BA.debugLine="btnGenerarHistorial.TextSize = 14";
mostCurrent._btngenerarhistorial.setTextSize((float) (14));
RDebugUtils.currentLine=196677;
 //BA.debugLineNum = 196677;BA.debugLine="btnGenerarHistorial.Height = (pnlBalance.Height -";
mostCurrent._btngenerarhistorial.setHeight((int) ((mostCurrent._pnlbalance.getHeight()-(mostCurrent._lblegresos.getTop()+mostCurrent._lblegresos.getHeight()))*0.8));
RDebugUtils.currentLine=196678;
 //BA.debugLineNum = 196678;BA.debugLine="btnGenerarHistorial.Width = pnlBalance.Width * 0.";
mostCurrent._btngenerarhistorial.setWidth((int) (mostCurrent._pnlbalance.getWidth()*0.4));
RDebugUtils.currentLine=196679;
 //BA.debugLineNum = 196679;BA.debugLine="btnGenerarHistorial.Top = lblIconoIngresos.Top +";
mostCurrent._btngenerarhistorial.setTop((int) (mostCurrent._lbliconoingresos.getTop()+mostCurrent._lbliconoingresos.getHeight()+(mostCurrent._pnlbalance.getHeight()-(mostCurrent._lblegresos.getTop()+mostCurrent._lblegresos.getHeight()+mostCurrent._btngenerarhistorial.getHeight()))/(double)2));
RDebugUtils.currentLine=196680;
 //BA.debugLineNum = 196680;BA.debugLine="btnGenerarHistorial.Left = ((pnlBalance.Width / 2";
mostCurrent._btngenerarhistorial.setLeft((int) (((mostCurrent._pnlbalance.getWidth()/(double)2)-mostCurrent._btngenerarhistorial.getWidth())/(double)2));
RDebugUtils.currentLine=196682;
 //BA.debugLineNum = 196682;BA.debugLine="btnHistoriales.TextSize = 14";
mostCurrent._btnhistoriales.setTextSize((float) (14));
RDebugUtils.currentLine=196683;
 //BA.debugLineNum = 196683;BA.debugLine="btnHistoriales.Height = btnGenerarHistorial.Heigh";
mostCurrent._btnhistoriales.setHeight(mostCurrent._btngenerarhistorial.getHeight());
RDebugUtils.currentLine=196684;
 //BA.debugLineNum = 196684;BA.debugLine="btnHistoriales.Width = btnGenerarHistorial.Width";
mostCurrent._btnhistoriales.setWidth(mostCurrent._btngenerarhistorial.getWidth());
RDebugUtils.currentLine=196685;
 //BA.debugLineNum = 196685;BA.debugLine="btnHistoriales.Top = btnGenerarHistorial.Top";
mostCurrent._btnhistoriales.setTop(mostCurrent._btngenerarhistorial.getTop());
RDebugUtils.currentLine=196686;
 //BA.debugLineNum = 196686;BA.debugLine="btnHistoriales.Left = (pnlBalance.Width / 2) + bt";
mostCurrent._btnhistoriales.setLeft((int) ((mostCurrent._pnlbalance.getWidth()/(double)2)+mostCurrent._btngenerarhistorial.getLeft()));
RDebugUtils.currentLine=196691;
 //BA.debugLineNum = 196691;BA.debugLine="pnlOpciones.Height = alturaDispositivo * 0.5";
mostCurrent._pnlopciones.setHeight((int) (_alturadispositivo*0.5));
RDebugUtils.currentLine=196692;
 //BA.debugLineNum = 196692;BA.debugLine="pnlOpciones.Width = anchoDispositivo * 0.9";
mostCurrent._pnlopciones.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=196693;
 //BA.debugLineNum = 196693;BA.debugLine="pnlOpciones.Left = pnlCabecera.Left";
mostCurrent._pnlopciones.setLeft(mostCurrent._pnlcabecera.getLeft());
RDebugUtils.currentLine=196694;
 //BA.debugLineNum = 196694;BA.debugLine="pnlOpciones.Top = pnlBalance.Top + pnlBalance.Hei";
mostCurrent._pnlopciones.setTop((int) (mostCurrent._pnlbalance.getTop()+mostCurrent._pnlbalance.getHeight()+50));
RDebugUtils.currentLine=196697;
 //BA.debugLineNum = 196697;BA.debugLine="lblExplora.Width = anchoDispositivo * 0.8";
mostCurrent._lblexplora.setWidth((int) (_anchodispositivo*0.8));
RDebugUtils.currentLine=196698;
 //BA.debugLineNum = 196698;BA.debugLine="lblExplora.Left = (pnlOpciones.Width - lblExplora";
mostCurrent._lblexplora.setLeft((int) ((mostCurrent._pnlopciones.getWidth()-mostCurrent._lblexplora.getWidth())/(double)2));
RDebugUtils.currentLine=196699;
 //BA.debugLineNum = 196699;BA.debugLine="lblExplora.Top = lblExplora.Left";
mostCurrent._lblexplora.setTop(mostCurrent._lblexplora.getLeft());
RDebugUtils.currentLine=196700;
 //BA.debugLineNum = 196700;BA.debugLine="lblExplora.TextSize = 16";
mostCurrent._lblexplora.setTextSize((float) (16));
RDebugUtils.currentLine=196703;
 //BA.debugLineNum = 196703;BA.debugLine="btnIngresosRecurrentes.Top = lblExplora.Top * 2 +";
mostCurrent._btningresosrecurrentes.setTop((int) (mostCurrent._lblexplora.getTop()*2+mostCurrent._lblexplora.getHeight()));
RDebugUtils.currentLine=196704;
 //BA.debugLineNum = 196704;BA.debugLine="btnIngresosRecurrentes.Left = lblExplora.Left";
mostCurrent._btningresosrecurrentes.setLeft(mostCurrent._lblexplora.getLeft());
RDebugUtils.currentLine=196705;
 //BA.debugLineNum = 196705;BA.debugLine="btnIngresosRecurrentes.Width = lblExplora.Width";
mostCurrent._btningresosrecurrentes.setWidth(mostCurrent._lblexplora.getWidth());
RDebugUtils.currentLine=196706;
 //BA.debugLineNum = 196706;BA.debugLine="btnIngresosRecurrentes.Height = ((pnlOpciones.Hei";
mostCurrent._btningresosrecurrentes.setHeight((int) (((mostCurrent._pnlopciones.getHeight()-(mostCurrent._lblexplora.getTop()+mostCurrent._lblexplora.getHeight()))-mostCurrent._lblexplora.getTop()*6)/(double)5));
RDebugUtils.currentLine=196707;
 //BA.debugLineNum = 196707;BA.debugLine="btnIngresosRecurrentes.Text = cs.Initialize.Color";
mostCurrent._btningresosrecurrentes.setText(BA.ObjectToCharSequence(mostCurrent._cs.Initialize().Color(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (78),(int) (236),(int) (26))).Typeface(anywheresoftware.b4a.keywords.Common.Typeface.getFONTAWESOME()).Size((int) (16)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf0d6)))).Pop().Color(anywheresoftware.b4a.keywords.Common.Colors.Black).Append(BA.ObjectToCharSequence("		Ingresos recurrentes")).PopAll().getObject()));
RDebugUtils.currentLine=196710;
 //BA.debugLineNum = 196710;BA.debugLine="btnIngresosUnicos.Top = btnIngresosRecurrentes.To";
mostCurrent._btningresosunicos.setTop((int) (mostCurrent._btningresosrecurrentes.getTop()+mostCurrent._btningresosrecurrentes.getHeight()+mostCurrent._lblexplora.getLeft()));
RDebugUtils.currentLine=196711;
 //BA.debugLineNum = 196711;BA.debugLine="btnIngresosUnicos.Left = btnIngresosRecurrentes.L";
mostCurrent._btningresosunicos.setLeft(mostCurrent._btningresosrecurrentes.getLeft());
RDebugUtils.currentLine=196712;
 //BA.debugLineNum = 196712;BA.debugLine="btnIngresosUnicos.Width = btnIngresosRecurrentes.";
mostCurrent._btningresosunicos.setWidth(mostCurrent._btningresosrecurrentes.getWidth());
RDebugUtils.currentLine=196713;
 //BA.debugLineNum = 196713;BA.debugLine="btnIngresosUnicos.Height = btnIngresosRecurrentes";
mostCurrent._btningresosunicos.setHeight(mostCurrent._btningresosrecurrentes.getHeight());
RDebugUtils.currentLine=196714;
 //BA.debugLineNum = 196714;BA.debugLine="btnIngresosUnicos.Text = cs.Initialize.Color(Colo";
mostCurrent._btningresosunicos.setText(BA.ObjectToCharSequence(mostCurrent._cs.Initialize().Color(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (255),(int) (187),(int) (0))).Typeface(anywheresoftware.b4a.keywords.Common.Typeface.getFONTAWESOME()).Size((int) (16)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf06b)))).Pop().Color(anywheresoftware.b4a.keywords.Common.Colors.Black).Append(BA.ObjectToCharSequence("		Ingresos únicos")).PopAll().getObject()));
RDebugUtils.currentLine=196716;
 //BA.debugLineNum = 196716;BA.debugLine="btnGastos.Top = btnIngresosUnicos.Top + btnIngres";
mostCurrent._btngastos.setTop((int) (mostCurrent._btningresosunicos.getTop()+mostCurrent._btningresosunicos.getHeight()+mostCurrent._lblexplora.getLeft()));
RDebugUtils.currentLine=196717;
 //BA.debugLineNum = 196717;BA.debugLine="btnGastos.Left = btnIngresosRecurrentes.Left";
mostCurrent._btngastos.setLeft(mostCurrent._btningresosrecurrentes.getLeft());
RDebugUtils.currentLine=196718;
 //BA.debugLineNum = 196718;BA.debugLine="btnGastos.Width = btnIngresosRecurrentes.Width";
mostCurrent._btngastos.setWidth(mostCurrent._btningresosrecurrentes.getWidth());
RDebugUtils.currentLine=196719;
 //BA.debugLineNum = 196719;BA.debugLine="btnGastos.Height = btnIngresosRecurrentes.Height";
mostCurrent._btngastos.setHeight(mostCurrent._btningresosrecurrentes.getHeight());
RDebugUtils.currentLine=196720;
 //BA.debugLineNum = 196720;BA.debugLine="btnGastos.Text = cs.Initialize.Color(Colors.ARGB(";
mostCurrent._btngastos.setText(BA.ObjectToCharSequence(mostCurrent._cs.Initialize().Color(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (223),(int) (32),(int) (11))).Typeface(anywheresoftware.b4a.keywords.Common.Typeface.getFONTAWESOME()).Size((int) (16)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf283)))).Pop().Color(anywheresoftware.b4a.keywords.Common.Colors.Black).Append(BA.ObjectToCharSequence("		Gastos")).PopAll().getObject()));
RDebugUtils.currentLine=196722;
 //BA.debugLineNum = 196722;BA.debugLine="btnSuscripciones.Top = btnGastos.Top + btnGastos.";
mostCurrent._btnsuscripciones.setTop((int) (mostCurrent._btngastos.getTop()+mostCurrent._btngastos.getHeight()+mostCurrent._lblexplora.getLeft()));
RDebugUtils.currentLine=196723;
 //BA.debugLineNum = 196723;BA.debugLine="btnSuscripciones.Left = btnIngresosRecurrentes.Le";
mostCurrent._btnsuscripciones.setLeft(mostCurrent._btningresosrecurrentes.getLeft());
RDebugUtils.currentLine=196724;
 //BA.debugLineNum = 196724;BA.debugLine="btnSuscripciones.Width = btnIngresosRecurrentes.W";
mostCurrent._btnsuscripciones.setWidth(mostCurrent._btningresosrecurrentes.getWidth());
RDebugUtils.currentLine=196725;
 //BA.debugLineNum = 196725;BA.debugLine="btnSuscripciones.Height = btnIngresosRecurrentes.";
mostCurrent._btnsuscripciones.setHeight(mostCurrent._btningresosrecurrentes.getHeight());
RDebugUtils.currentLine=196726;
 //BA.debugLineNum = 196726;BA.debugLine="btnSuscripciones.Text = cs.Initialize.Color(Color";
mostCurrent._btnsuscripciones.setText(BA.ObjectToCharSequence(mostCurrent._cs.Initialize().Color(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (0),(int) (114),(int) (255))).Typeface(anywheresoftware.b4a.keywords.Common.Typeface.getFONTAWESOME()).Size((int) (16)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf0e2)))).Pop().Color(anywheresoftware.b4a.keywords.Common.Colors.Black).Append(BA.ObjectToCharSequence("		Suscripciones")).PopAll().getObject()));
RDebugUtils.currentLine=196728;
 //BA.debugLineNum = 196728;BA.debugLine="btnMetasDeAhorro.Top = btnSuscripciones.Top + btn";
mostCurrent._btnmetasdeahorro.setTop((int) (mostCurrent._btnsuscripciones.getTop()+mostCurrent._btnsuscripciones.getHeight()+mostCurrent._lblexplora.getLeft()));
RDebugUtils.currentLine=196729;
 //BA.debugLineNum = 196729;BA.debugLine="btnMetasDeAhorro.Left = btnIngresosRecurrentes.Le";
mostCurrent._btnmetasdeahorro.setLeft(mostCurrent._btningresosrecurrentes.getLeft());
RDebugUtils.currentLine=196730;
 //BA.debugLineNum = 196730;BA.debugLine="btnMetasDeAhorro.Width = btnIngresosRecurrentes.W";
mostCurrent._btnmetasdeahorro.setWidth(mostCurrent._btningresosrecurrentes.getWidth());
RDebugUtils.currentLine=196731;
 //BA.debugLineNum = 196731;BA.debugLine="btnMetasDeAhorro.Height = btnIngresosRecurrentes.";
mostCurrent._btnmetasdeahorro.setHeight(mostCurrent._btningresosrecurrentes.getHeight());
RDebugUtils.currentLine=196732;
 //BA.debugLineNum = 196732;BA.debugLine="btnMetasDeAhorro.Text = cs.Initialize.Color(Color";
mostCurrent._btnmetasdeahorro.setText(BA.ObjectToCharSequence(mostCurrent._cs.Initialize().Color(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (188),(int) (36),(int) (97))).Typeface(anywheresoftware.b4a.keywords.Common.Typeface.getFONTAWESOME()).Size((int) (16)).Append(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf19c)))).Pop().Color(anywheresoftware.b4a.keywords.Common.Colors.Black).Append(BA.ObjectToCharSequence("		Metas de ahorro")).PopAll().getObject()));
RDebugUtils.currentLine=196737;
 //BA.debugLineNum = 196737;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
mostCurrent._pnlnavinferior.setHeight((int) (_alturadispositivo*0.08));
RDebugUtils.currentLine=196738;
 //BA.debugLineNum = 196738;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
mostCurrent._pnlnavinferior.setWidth(_anchodispositivo);
RDebugUtils.currentLine=196739;
 //BA.debugLineNum = 196739;BA.debugLine="pnlNavInferior.Left = 0";
mostCurrent._pnlnavinferior.setLeft((int) (0));
RDebugUtils.currentLine=196740;
 //BA.debugLineNum = 196740;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
mostCurrent._pnlnavinferior.setTop((int) (_alturadispositivo-mostCurrent._pnlnavinferior.getHeight()));
RDebugUtils.currentLine=196743;
 //BA.debugLineNum = 196743;BA.debugLine="btnAgregar.Width = anchoDispositivo * 0.15";
mostCurrent._btnagregar.setWidth((int) (_anchodispositivo*0.15));
RDebugUtils.currentLine=196744;
 //BA.debugLineNum = 196744;BA.debugLine="btnAgregar.Height = btnAgregar.Width";
mostCurrent._btnagregar.setHeight(mostCurrent._btnagregar.getWidth());
RDebugUtils.currentLine=196745;
 //BA.debugLineNum = 196745;BA.debugLine="btnAgregar.Top = pnlNavInferior.Top - btnAgregar.";
mostCurrent._btnagregar.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._btnagregar.getHeight()/(double)2));
RDebugUtils.currentLine=196746;
 //BA.debugLineNum = 196746;BA.debugLine="btnAgregar.Left = (anchoDispositivo - btnAgregar.";
mostCurrent._btnagregar.setLeft((int) ((_anchodispositivo-mostCurrent._btnagregar.getWidth())/(double)2));
RDebugUtils.currentLine=196747;
 //BA.debugLineNum = 196747;BA.debugLine="btnAgregar.Text = Chr(0xF067) 'Ícono de FontAweso";
mostCurrent._btnagregar.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf067))));
RDebugUtils.currentLine=196749;
 //BA.debugLineNum = 196749;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
mostCurrent._lblcontornoboton.setWidth((int) (_anchodispositivo*0.17));
RDebugUtils.currentLine=196750;
 //BA.debugLineNum = 196750;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
mostCurrent._lblcontornoboton.setHeight(mostCurrent._lblcontornoboton.getWidth());
RDebugUtils.currentLine=196751;
 //BA.debugLineNum = 196751;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
mostCurrent._lblcontornoboton.setLeft((int) ((_anchodispositivo-mostCurrent._lblcontornoboton.getWidth())/(double)2));
RDebugUtils.currentLine=196752;
 //BA.debugLineNum = 196752;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
mostCurrent._lblcontornoboton.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._lblcontornoboton.getHeight()/(double)2));
RDebugUtils.currentLine=196757;
 //BA.debugLineNum = 196757;BA.debugLine="pnlAgregar.Width = anchoDispositivo * 0.6";
mostCurrent._pnlagregar.setWidth((int) (_anchodispositivo*0.6));
RDebugUtils.currentLine=196758;
 //BA.debugLineNum = 196758;BA.debugLine="pnlAgregar.Height = pnlAgregar.Width";
mostCurrent._pnlagregar.setHeight(mostCurrent._pnlagregar.getWidth());
RDebugUtils.currentLine=196759;
 //BA.debugLineNum = 196759;BA.debugLine="pnlAgregar.Left = (anchoDispositivo - pnlAgregar.";
mostCurrent._pnlagregar.setLeft((int) ((_anchodispositivo-mostCurrent._pnlagregar.getWidth())/(double)2));
RDebugUtils.currentLine=196760;
 //BA.debugLineNum = 196760;BA.debugLine="pnlAgregar.Top = lblContornoBoton.Top - pnlAgrega";
mostCurrent._pnlagregar.setTop((int) (mostCurrent._lblcontornoboton.getTop()-mostCurrent._pnlagregar.getHeight()-50));
RDebugUtils.currentLine=196764;
 //BA.debugLineNum = 196764;BA.debugLine="btnAgregarIngreso.Height = (pnlAgregar.Height * 0";
mostCurrent._btnagregaringreso.setHeight((int) ((mostCurrent._pnlagregar.getHeight()*0.76)/(double)4));
RDebugUtils.currentLine=196765;
 //BA.debugLineNum = 196765;BA.debugLine="btnAgregarIngreso.Width = pnlAgregar.Width * 0.9";
mostCurrent._btnagregaringreso.setWidth((int) (mostCurrent._pnlagregar.getWidth()*0.9));
RDebugUtils.currentLine=196766;
 //BA.debugLineNum = 196766;BA.debugLine="btnAgregarIngreso.Top = pnlAgregar.Height * 0.048";
mostCurrent._btnagregaringreso.setTop((int) (mostCurrent._pnlagregar.getHeight()*0.048));
RDebugUtils.currentLine=196767;
 //BA.debugLineNum = 196767;BA.debugLine="btnAgregarIngreso.Left = (pnlAgregar.Width - btnA";
mostCurrent._btnagregaringreso.setLeft((int) ((mostCurrent._pnlagregar.getWidth()-mostCurrent._btnagregaringreso.getWidth())/(double)2));
RDebugUtils.currentLine=196769;
 //BA.debugLineNum = 196769;BA.debugLine="btnAgregarGasto.Height = btnAgregarIngreso.Height";
mostCurrent._btnagregargasto.setHeight(mostCurrent._btnagregaringreso.getHeight());
RDebugUtils.currentLine=196770;
 //BA.debugLineNum = 196770;BA.debugLine="btnAgregarGasto.Width = btnAgregarIngreso.Width";
mostCurrent._btnagregargasto.setWidth(mostCurrent._btnagregaringreso.getWidth());
RDebugUtils.currentLine=196771;
 //BA.debugLineNum = 196771;BA.debugLine="btnAgregarGasto.Top = btnAgregarIngreso.Top * 2 +";
mostCurrent._btnagregargasto.setTop((int) (mostCurrent._btnagregaringreso.getTop()*2+mostCurrent._btnagregaringreso.getHeight()));
RDebugUtils.currentLine=196772;
 //BA.debugLineNum = 196772;BA.debugLine="btnAgregarGasto.Left = btnAgregarIngreso.Left";
mostCurrent._btnagregargasto.setLeft(mostCurrent._btnagregaringreso.getLeft());
RDebugUtils.currentLine=196774;
 //BA.debugLineNum = 196774;BA.debugLine="btnAgregarSuscripcion.Height = btnAgregarIngreso.";
mostCurrent._btnagregarsuscripcion.setHeight(mostCurrent._btnagregaringreso.getHeight());
RDebugUtils.currentLine=196775;
 //BA.debugLineNum = 196775;BA.debugLine="btnAgregarSuscripcion.Width = btnAgregarIngreso.W";
mostCurrent._btnagregarsuscripcion.setWidth(mostCurrent._btnagregaringreso.getWidth());
RDebugUtils.currentLine=196776;
 //BA.debugLineNum = 196776;BA.debugLine="btnAgregarSuscripcion.Top = btnAgregarGasto.Top +";
mostCurrent._btnagregarsuscripcion.setTop((int) (mostCurrent._btnagregargasto.getTop()+mostCurrent._btnagregargasto.getHeight()+mostCurrent._pnlagregar.getHeight()*0.04));
RDebugUtils.currentLine=196777;
 //BA.debugLineNum = 196777;BA.debugLine="btnAgregarSuscripcion.Left = btnAgregarIngreso.Le";
mostCurrent._btnagregarsuscripcion.setLeft(mostCurrent._btnagregaringreso.getLeft());
RDebugUtils.currentLine=196779;
 //BA.debugLineNum = 196779;BA.debugLine="btnAgregarMetaDeAhorro.Height = btnAgregarIngreso";
mostCurrent._btnagregarmetadeahorro.setHeight(mostCurrent._btnagregaringreso.getHeight());
RDebugUtils.currentLine=196780;
 //BA.debugLineNum = 196780;BA.debugLine="btnAgregarMetaDeAhorro.Width = btnAgregarIngreso.";
mostCurrent._btnagregarmetadeahorro.setWidth(mostCurrent._btnagregaringreso.getWidth());
RDebugUtils.currentLine=196781;
 //BA.debugLineNum = 196781;BA.debugLine="btnAgregarMetaDeAhorro.Top = btnAgregarSuscripcio";
mostCurrent._btnagregarmetadeahorro.setTop((int) (mostCurrent._btnagregarsuscripcion.getTop()+mostCurrent._btnagregarsuscripcion.getHeight()+mostCurrent._pnlagregar.getHeight()*0.04));
RDebugUtils.currentLine=196782;
 //BA.debugLineNum = 196782;BA.debugLine="btnAgregarMetaDeAhorro.Left = btnAgregarIngreso.L";
mostCurrent._btnagregarmetadeahorro.setLeft(mostCurrent._btnagregaringreso.getLeft());
RDebugUtils.currentLine=196783;
 //BA.debugLineNum = 196783;BA.debugLine="End Sub";
return "";
}
public static String  _verificarprimeringreso() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "verificarprimeringreso", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "verificarprimeringreso", null));}
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub verificarPrimerIngreso";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM primer_uso\")";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM primer_uso")));
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="If(cur.RowCount = 0) Then";
if ((mostCurrent._cur.getRowCount()==0)) { 
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO primer_uso (ingre";
_sql.ExecNonQuery2("INSERT INTO primer_uso (ingreso) VALUES (?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("Pull Up")}));
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO ingresos (suma_in";
_sql.ExecNonQuery2("INSERT INTO ingresos (suma_ingresos) VALUES (?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(0)}));
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO egresos (suma_egr";
_sql.ExecNonQuery2("INSERT INTO egresos (suma_egresos) VALUES (?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(0)}));
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="StartActivity(Tutorial)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._tutorial.getObject()));
 };
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="End Sub";
return "";
}
public static String  _cobraingresos() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cobraingresos", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cobraingresos", null));}
anywheresoftware.b4a.sql.SQL.CursorWrapper _cur1 = null;
anywheresoftware.b4a.sql.SQL.CursorWrapper _cur2 = null;
String _fechaactual = "";
long _fechaactuallong = 0L;
String _fechacobro = "";
long _fechacobrolong = 0L;
int _ingresosactuales = 0;
int _monto = 0;
int _periodo = 0;
int _contador = 0;
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub cobraIngresos";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="Dim cur1 As Cursor";
_cur1 = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="Dim cur2 As Cursor";
_cur2 = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="Dim fechaActual As String";
_fechaactual = "";
RDebugUtils.currentLine=1441796;
 //BA.debugLineNum = 1441796;BA.debugLine="Dim fechaActualLong As Long";
_fechaactuallong = 0L;
RDebugUtils.currentLine=1441797;
 //BA.debugLineNum = 1441797;BA.debugLine="Dim fechaCobro As String";
_fechacobro = "";
RDebugUtils.currentLine=1441798;
 //BA.debugLineNum = 1441798;BA.debugLine="Dim fechaCobroLong As Long";
_fechacobrolong = 0L;
RDebugUtils.currentLine=1441799;
 //BA.debugLineNum = 1441799;BA.debugLine="Dim ingresosActuales As Int";
_ingresosactuales = 0;
RDebugUtils.currentLine=1441800;
 //BA.debugLineNum = 1441800;BA.debugLine="Dim monto As Int";
_monto = 0;
RDebugUtils.currentLine=1441801;
 //BA.debugLineNum = 1441801;BA.debugLine="Dim periodo As Int";
_periodo = 0;
RDebugUtils.currentLine=1441803;
 //BA.debugLineNum = 1441803;BA.debugLine="fechaActual = DateTime.Now";
_fechaactual = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=1441804;
 //BA.debugLineNum = 1441804;BA.debugLine="fechaActual = DateTime.Date(fechaActual)";
_fechaactual = anywheresoftware.b4a.keywords.Common.DateTime.Date((long)(Double.parseDouble(_fechaactual)));
RDebugUtils.currentLine=1441805;
 //BA.debugLineNum = 1441805;BA.debugLine="fechaActualLong = DateTime.DateParse(fechaActual)";
_fechaactuallong = anywheresoftware.b4a.keywords.Common.DateTime.DateParse(_fechaactual);
RDebugUtils.currentLine=1441807;
 //BA.debugLineNum = 1441807;BA.debugLine="cur1 = sql.ExecQuery(\"SELECT * FROM ingresos_recu";
_cur1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM ingresos_recurrentes ORDER BY rowid ASC")));
RDebugUtils.currentLine=1441808;
 //BA.debugLineNum = 1441808;BA.debugLine="cur2 = sql.ExecQuery(\"SELECT * FROM ingresos\")";
_cur2 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM ingresos")));
RDebugUtils.currentLine=1441809;
 //BA.debugLineNum = 1441809;BA.debugLine="If(cur1.RowCount <> 0) Then";
if ((_cur1.getRowCount()!=0)) { 
RDebugUtils.currentLine=1441810;
 //BA.debugLineNum = 1441810;BA.debugLine="For contador = 0  To cur1.RowCount - 1 Step 1";
{
final int step16 = 1;
final int limit16 = (int) (_cur1.getRowCount()-1);
_contador = (int) (0) ;
for (;_contador <= limit16 ;_contador = _contador + step16 ) {
RDebugUtils.currentLine=1441811;
 //BA.debugLineNum = 1441811;BA.debugLine="cur1.Position = contador";
_cur1.setPosition(_contador);
RDebugUtils.currentLine=1441812;
 //BA.debugLineNum = 1441812;BA.debugLine="cur2.Position = 0";
_cur2.setPosition((int) (0));
RDebugUtils.currentLine=1441814;
 //BA.debugLineNum = 1441814;BA.debugLine="ingresosActuales = cur2.GetInt(\"suma_ingresos\")";
_ingresosactuales = _cur2.GetInt("suma_ingresos");
RDebugUtils.currentLine=1441815;
 //BA.debugLineNum = 1441815;BA.debugLine="monto = cur1.GetInt(\"monto\")";
_monto = _cur1.GetInt("monto");
RDebugUtils.currentLine=1441816;
 //BA.debugLineNum = 1441816;BA.debugLine="periodo = cur1.GetInt(\"periodo\")";
_periodo = _cur1.GetInt("periodo");
RDebugUtils.currentLine=1441819;
 //BA.debugLineNum = 1441819;BA.debugLine="fechaCobro = cur1.GetString(\"fecha_cobro\").Repl";
_fechacobro = _cur1.GetString("fecha_cobro").replace("-","/");
RDebugUtils.currentLine=1441820;
 //BA.debugLineNum = 1441820;BA.debugLine="fechaCobroLong = DateTime.DateParse(fechaCobro)";
_fechacobrolong = anywheresoftware.b4a.keywords.Common.DateTime.DateParse(_fechacobro);
RDebugUtils.currentLine=1441822;
 //BA.debugLineNum = 1441822;BA.debugLine="If(fechaCobroLong <= fechaActualLong) Then";
if ((_fechacobrolong<=_fechaactuallong)) { 
RDebugUtils.currentLine=1441823;
 //BA.debugLineNum = 1441823;BA.debugLine="ingresosActuales = ingresosActuales + monto";
_ingresosactuales = (int) (_ingresosactuales+_monto);
RDebugUtils.currentLine=1441825;
 //BA.debugLineNum = 1441825;BA.debugLine="Do Until (DateTime.Add(fechaCobroLong, 0, 0, p";
while (!((anywheresoftware.b4a.keywords.Common.DateTime.Add(_fechacobrolong,(int) (0),(int) (0),_periodo)>_fechaactuallong))) {
RDebugUtils.currentLine=1441826;
 //BA.debugLineNum = 1441826;BA.debugLine="ingresosActuales = ingresosActuales + monto";
_ingresosactuales = (int) (_ingresosactuales+_monto);
RDebugUtils.currentLine=1441828;
 //BA.debugLineNum = 1441828;BA.debugLine="fechaActual = DateTime.Now";
_fechaactual = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=1441829;
 //BA.debugLineNum = 1441829;BA.debugLine="fechaActual = DateTime.Date(fechaActual)";
_fechaactual = anywheresoftware.b4a.keywords.Common.DateTime.Date((long)(Double.parseDouble(_fechaactual)));
RDebugUtils.currentLine=1441830;
 //BA.debugLineNum = 1441830;BA.debugLine="fechaActualLong = DateTime.DateParse(fechaAct";
_fechaactuallong = anywheresoftware.b4a.keywords.Common.DateTime.DateParse(_fechaactual);
RDebugUtils.currentLine=1441831;
 //BA.debugLineNum = 1441831;BA.debugLine="fechaCobroLong = DateTime.Add(fechaCobroLong,";
_fechacobrolong = anywheresoftware.b4a.keywords.Common.DateTime.Add(_fechacobrolong,(int) (0),(int) (0),_periodo);
 }
;
RDebugUtils.currentLine=1441834;
 //BA.debugLineNum = 1441834;BA.debugLine="fechaCobroLong = DateTime.Add(fechaCobroLong,";
_fechacobrolong = anywheresoftware.b4a.keywords.Common.DateTime.Add(_fechacobrolong,(int) (0),(int) (0),_periodo);
RDebugUtils.currentLine=1441835;
 //BA.debugLineNum = 1441835;BA.debugLine="fechaCobro = DateTime.Date(fechaCobroLong)";
_fechacobro = anywheresoftware.b4a.keywords.Common.DateTime.Date(_fechacobrolong);
 };
RDebugUtils.currentLine=1441838;
 //BA.debugLineNum = 1441838;BA.debugLine="sql.ExecNonQuery2(\"UPDATE ingresos SET suma_ing";
_sql.ExecNonQuery2("UPDATE ingresos SET suma_ingresos = ?  WHERE id_ingreso = 1",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_ingresosactuales)}));
RDebugUtils.currentLine=1441839;
 //BA.debugLineNum = 1441839;BA.debugLine="sql.ExecNonQuery2(\"UPDATE ingresos_recurrentes";
_sql.ExecNonQuery2("UPDATE ingresos_recurrentes SET fecha_cobro = ? WHERE id_ingreso_recurrente = '"+BA.NumberToString((_contador+1))+"'",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_fechacobro)}));
 }
};
 };
RDebugUtils.currentLine=1441842;
 //BA.debugLineNum = 1441842;BA.debugLine="End Sub";
return "";
}
public static String  _realizaegresos() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "realizaegresos", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "realizaegresos", null));}
anywheresoftware.b4a.sql.SQL.CursorWrapper _cur1 = null;
anywheresoftware.b4a.sql.SQL.CursorWrapper _cur2 = null;
String _fechaactual = "";
long _fechaactuallong = 0L;
String _fechapago = "";
long _fechapagolong = 0L;
int _egresosactuales = 0;
int _monto = 0;
int _periodo = 0;
int _progreso = 0;
int _montometa = 0;
int _contador = 0;
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub realizaEgresos";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="Dim cur1 As Cursor";
_cur1 = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="Dim cur2 As Cursor";
_cur2 = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="Dim fechaActual As String";
_fechaactual = "";
RDebugUtils.currentLine=1507332;
 //BA.debugLineNum = 1507332;BA.debugLine="Dim fechaActualLong As Long";
_fechaactuallong = 0L;
RDebugUtils.currentLine=1507333;
 //BA.debugLineNum = 1507333;BA.debugLine="Dim fechaPago As String";
_fechapago = "";
RDebugUtils.currentLine=1507334;
 //BA.debugLineNum = 1507334;BA.debugLine="Dim fechaPagoLong As Long";
_fechapagolong = 0L;
RDebugUtils.currentLine=1507335;
 //BA.debugLineNum = 1507335;BA.debugLine="Dim egresosActuales As Int";
_egresosactuales = 0;
RDebugUtils.currentLine=1507336;
 //BA.debugLineNum = 1507336;BA.debugLine="Dim monto As Int";
_monto = 0;
RDebugUtils.currentLine=1507337;
 //BA.debugLineNum = 1507337;BA.debugLine="Dim periodo As Int";
_periodo = 0;
RDebugUtils.currentLine=1507338;
 //BA.debugLineNum = 1507338;BA.debugLine="Dim progreso As Int";
_progreso = 0;
RDebugUtils.currentLine=1507339;
 //BA.debugLineNum = 1507339;BA.debugLine="Dim montoMeta As Int";
_montometa = 0;
RDebugUtils.currentLine=1507341;
 //BA.debugLineNum = 1507341;BA.debugLine="fechaActual = DateTime.Now";
_fechaactual = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=1507342;
 //BA.debugLineNum = 1507342;BA.debugLine="fechaActual = DateTime.Date(fechaActual)";
_fechaactual = anywheresoftware.b4a.keywords.Common.DateTime.Date((long)(Double.parseDouble(_fechaactual)));
RDebugUtils.currentLine=1507343;
 //BA.debugLineNum = 1507343;BA.debugLine="fechaActualLong = DateTime.DateParse(fechaActual)";
_fechaactuallong = anywheresoftware.b4a.keywords.Common.DateTime.DateParse(_fechaactual);
RDebugUtils.currentLine=1507345;
 //BA.debugLineNum = 1507345;BA.debugLine="cur1 = sql.ExecQuery(\"SELECT * FROM suscripciones";
_cur1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM suscripciones ORDER BY rowid ASC")));
RDebugUtils.currentLine=1507346;
 //BA.debugLineNum = 1507346;BA.debugLine="cur2 = sql.ExecQuery(\"SELECT * FROM egresos\")";
_cur2 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM egresos")));
RDebugUtils.currentLine=1507348;
 //BA.debugLineNum = 1507348;BA.debugLine="If(cur1.RowCount <> 0) Then";
if ((_cur1.getRowCount()!=0)) { 
RDebugUtils.currentLine=1507349;
 //BA.debugLineNum = 1507349;BA.debugLine="For contador = 0  To cur1.RowCount - 1 Step 1";
{
final int step18 = 1;
final int limit18 = (int) (_cur1.getRowCount()-1);
_contador = (int) (0) ;
for (;_contador <= limit18 ;_contador = _contador + step18 ) {
RDebugUtils.currentLine=1507350;
 //BA.debugLineNum = 1507350;BA.debugLine="cur1.Position = contador";
_cur1.setPosition(_contador);
RDebugUtils.currentLine=1507351;
 //BA.debugLineNum = 1507351;BA.debugLine="cur2.Position = 0";
_cur2.setPosition((int) (0));
RDebugUtils.currentLine=1507353;
 //BA.debugLineNum = 1507353;BA.debugLine="egresosActuales = cur2.GetInt(\"suma_egresos\")";
_egresosactuales = _cur2.GetInt("suma_egresos");
RDebugUtils.currentLine=1507354;
 //BA.debugLineNum = 1507354;BA.debugLine="monto = cur1.GetInt(\"monto\")";
_monto = _cur1.GetInt("monto");
RDebugUtils.currentLine=1507355;
 //BA.debugLineNum = 1507355;BA.debugLine="periodo = cur1.GetInt(\"periodo\")";
_periodo = _cur1.GetInt("periodo");
RDebugUtils.currentLine=1507358;
 //BA.debugLineNum = 1507358;BA.debugLine="fechaPago = cur1.GetString(\"fecha_pago\").Replac";
_fechapago = _cur1.GetString("fecha_pago").replace("-","/");
RDebugUtils.currentLine=1507359;
 //BA.debugLineNum = 1507359;BA.debugLine="fechaPagoLong = DateTime.DateParse(fechaPago)";
_fechapagolong = anywheresoftware.b4a.keywords.Common.DateTime.DateParse(_fechapago);
RDebugUtils.currentLine=1507361;
 //BA.debugLineNum = 1507361;BA.debugLine="If(fechaPagoLong <= fechaActualLong) Then";
if ((_fechapagolong<=_fechaactuallong)) { 
RDebugUtils.currentLine=1507362;
 //BA.debugLineNum = 1507362;BA.debugLine="egresosActuales = egresosActuales + monto";
_egresosactuales = (int) (_egresosactuales+_monto);
RDebugUtils.currentLine=1507364;
 //BA.debugLineNum = 1507364;BA.debugLine="Do Until (DateTime.Add(fechaPagoLong, 0, 0, pe";
while (!((anywheresoftware.b4a.keywords.Common.DateTime.Add(_fechapagolong,(int) (0),(int) (0),_periodo)>_fechaactuallong))) {
RDebugUtils.currentLine=1507365;
 //BA.debugLineNum = 1507365;BA.debugLine="egresosActuales = egresosActuales + monto";
_egresosactuales = (int) (_egresosactuales+_monto);
RDebugUtils.currentLine=1507367;
 //BA.debugLineNum = 1507367;BA.debugLine="fechaActual = DateTime.Now";
_fechaactual = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=1507368;
 //BA.debugLineNum = 1507368;BA.debugLine="fechaActual = DateTime.Date(fechaActual)";
_fechaactual = anywheresoftware.b4a.keywords.Common.DateTime.Date((long)(Double.parseDouble(_fechaactual)));
RDebugUtils.currentLine=1507369;
 //BA.debugLineNum = 1507369;BA.debugLine="fechaActualLong = DateTime.DateParse(fechaAct";
_fechaactuallong = anywheresoftware.b4a.keywords.Common.DateTime.DateParse(_fechaactual);
RDebugUtils.currentLine=1507370;
 //BA.debugLineNum = 1507370;BA.debugLine="fechaPagoLong = DateTime.Add(fechaPagoLong, 0";
_fechapagolong = anywheresoftware.b4a.keywords.Common.DateTime.Add(_fechapagolong,(int) (0),(int) (0),_periodo);
 }
;
RDebugUtils.currentLine=1507373;
 //BA.debugLineNum = 1507373;BA.debugLine="fechaPagoLong = DateTime.Add(fechaPagoLong, 0,";
_fechapagolong = anywheresoftware.b4a.keywords.Common.DateTime.Add(_fechapagolong,(int) (0),(int) (0),_periodo);
RDebugUtils.currentLine=1507374;
 //BA.debugLineNum = 1507374;BA.debugLine="fechaPago = DateTime.Date(fechaPagoLong)";
_fechapago = anywheresoftware.b4a.keywords.Common.DateTime.Date(_fechapagolong);
 };
RDebugUtils.currentLine=1507377;
 //BA.debugLineNum = 1507377;BA.debugLine="sql.ExecNonQuery2(\"UPDATE egresos SET suma_egre";
_sql.ExecNonQuery2("UPDATE egresos SET suma_egresos = ?  WHERE id_egreso = 1",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_egresosactuales)}));
RDebugUtils.currentLine=1507378;
 //BA.debugLineNum = 1507378;BA.debugLine="sql.ExecNonQuery2(\"UPDATE suscripciones SET fec";
_sql.ExecNonQuery2("UPDATE suscripciones SET fecha_pago = ? WHERE id_suscripcion = '"+BA.NumberToString((_contador+1))+"'",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_fechapago)}));
RDebugUtils.currentLine=1507379;
 //BA.debugLineNum = 1507379;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM suscripcione";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM suscripciones WHERE id_suscripcion = '"+BA.NumberToString((_contador+1))+"'")));
RDebugUtils.currentLine=1507380;
 //BA.debugLineNum = 1507380;BA.debugLine="cur.Position = 0";
mostCurrent._cur.setPosition((int) (0));
 }
};
 };
RDebugUtils.currentLine=1507383;
 //BA.debugLineNum = 1507383;BA.debugLine="cur1 = sql.ExecQuery(\"SELECT * FROM metas_ahorro";
_cur1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM metas_ahorro ORDER BY rowid ASC")));
RDebugUtils.currentLine=1507384;
 //BA.debugLineNum = 1507384;BA.debugLine="cur2 = sql.ExecQuery(\"SELECT * FROM egresos\")";
_cur2 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM egresos")));
RDebugUtils.currentLine=1507386;
 //BA.debugLineNum = 1507386;BA.debugLine="egresosActuales = 0";
_egresosactuales = (int) (0);
RDebugUtils.currentLine=1507388;
 //BA.debugLineNum = 1507388;BA.debugLine="If(cur1.RowCount <> 0) Then";
if ((_cur1.getRowCount()!=0)) { 
RDebugUtils.currentLine=1507389;
 //BA.debugLineNum = 1507389;BA.debugLine="For contador = 0  To cur1.RowCount - 1 Step 1";
{
final int step48 = 1;
final int limit48 = (int) (_cur1.getRowCount()-1);
_contador = (int) (0) ;
for (;_contador <= limit48 ;_contador = _contador + step48 ) {
RDebugUtils.currentLine=1507390;
 //BA.debugLineNum = 1507390;BA.debugLine="cur1.Position = contador";
_cur1.setPosition(_contador);
RDebugUtils.currentLine=1507391;
 //BA.debugLineNum = 1507391;BA.debugLine="cur2.Position = 0";
_cur2.setPosition((int) (0));
RDebugUtils.currentLine=1507392;
 //BA.debugLineNum = 1507392;BA.debugLine="progreso = cur1.GetInt(\"progreso\")";
_progreso = _cur1.GetInt("progreso");
RDebugUtils.currentLine=1507393;
 //BA.debugLineNum = 1507393;BA.debugLine="montoMeta = cur1.getInt(\"monto_meta\")";
_montometa = _cur1.GetInt("monto_meta");
RDebugUtils.currentLine=1507395;
 //BA.debugLineNum = 1507395;BA.debugLine="egresosActuales = cur2.GetInt(\"suma_egresos\")";
_egresosactuales = _cur2.GetInt("suma_egresos");
RDebugUtils.currentLine=1507396;
 //BA.debugLineNum = 1507396;BA.debugLine="monto = cur1.GetInt(\"monto_ahorro\")";
_monto = _cur1.GetInt("monto_ahorro");
RDebugUtils.currentLine=1507397;
 //BA.debugLineNum = 1507397;BA.debugLine="periodo = cur1.GetInt(\"periodo_ahorro\")";
_periodo = _cur1.GetInt("periodo_ahorro");
RDebugUtils.currentLine=1507400;
 //BA.debugLineNum = 1507400;BA.debugLine="fechaPago = cur1.GetString(\"fecha_pago\").Replac";
_fechapago = _cur1.GetString("fecha_pago").replace("-","/");
RDebugUtils.currentLine=1507401;
 //BA.debugLineNum = 1507401;BA.debugLine="fechaPagoLong = DateTime.DateParse(fechaPago)";
_fechapagolong = anywheresoftware.b4a.keywords.Common.DateTime.DateParse(_fechapago);
RDebugUtils.currentLine=1507403;
 //BA.debugLineNum = 1507403;BA.debugLine="If(fechaPagoLong <= fechaActualLong) Then";
if ((_fechapagolong<=_fechaactuallong)) { 
RDebugUtils.currentLine=1507404;
 //BA.debugLineNum = 1507404;BA.debugLine="If(progreso + monto <= montoMeta) Then";
if ((_progreso+_monto<=_montometa)) { 
RDebugUtils.currentLine=1507405;
 //BA.debugLineNum = 1507405;BA.debugLine="egresosActuales = egresosActuales + monto";
_egresosactuales = (int) (_egresosactuales+_monto);
RDebugUtils.currentLine=1507406;
 //BA.debugLineNum = 1507406;BA.debugLine="progreso = progreso + monto";
_progreso = (int) (_progreso+_monto);
 }else {
RDebugUtils.currentLine=1507408;
 //BA.debugLineNum = 1507408;BA.debugLine="egresosActuales = montoMeta - progreso";
_egresosactuales = (int) (_montometa-_progreso);
RDebugUtils.currentLine=1507409;
 //BA.debugLineNum = 1507409;BA.debugLine="progreso = montoMeta";
_progreso = _montometa;
 };
RDebugUtils.currentLine=1507412;
 //BA.debugLineNum = 1507412;BA.debugLine="Do Until (DateTime.Add(fechaPagoLong, 0, 0, pe";
while (!((anywheresoftware.b4a.keywords.Common.DateTime.Add(_fechapagolong,(int) (0),(int) (0),_periodo)>_fechaactuallong))) {
RDebugUtils.currentLine=1507413;
 //BA.debugLineNum = 1507413;BA.debugLine="If(progreso + monto <= montoMeta) Then";
if ((_progreso+_monto<=_montometa)) { 
RDebugUtils.currentLine=1507414;
 //BA.debugLineNum = 1507414;BA.debugLine="egresosActuales = egresosActuales + monto";
_egresosactuales = (int) (_egresosactuales+_monto);
RDebugUtils.currentLine=1507415;
 //BA.debugLineNum = 1507415;BA.debugLine="progreso = progreso + monto";
_progreso = (int) (_progreso+_monto);
 }else {
RDebugUtils.currentLine=1507417;
 //BA.debugLineNum = 1507417;BA.debugLine="egresosActuales = montoMeta - progreso";
_egresosactuales = (int) (_montometa-_progreso);
RDebugUtils.currentLine=1507418;
 //BA.debugLineNum = 1507418;BA.debugLine="progreso = montoMeta";
_progreso = _montometa;
 };
RDebugUtils.currentLine=1507421;
 //BA.debugLineNum = 1507421;BA.debugLine="fechaActual = DateTime.Now";
_fechaactual = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=1507422;
 //BA.debugLineNum = 1507422;BA.debugLine="fechaActual = DateTime.Date(fechaActual)";
_fechaactual = anywheresoftware.b4a.keywords.Common.DateTime.Date((long)(Double.parseDouble(_fechaactual)));
RDebugUtils.currentLine=1507423;
 //BA.debugLineNum = 1507423;BA.debugLine="fechaActualLong = DateTime.DateParse(fechaAct";
_fechaactuallong = anywheresoftware.b4a.keywords.Common.DateTime.DateParse(_fechaactual);
RDebugUtils.currentLine=1507424;
 //BA.debugLineNum = 1507424;BA.debugLine="fechaPagoLong = DateTime.Add(fechaPagoLong, 0";
_fechapagolong = anywheresoftware.b4a.keywords.Common.DateTime.Add(_fechapagolong,(int) (0),(int) (0),_periodo);
 }
;
RDebugUtils.currentLine=1507427;
 //BA.debugLineNum = 1507427;BA.debugLine="fechaPagoLong = DateTime.Add(fechaPagoLong, 0,";
_fechapagolong = anywheresoftware.b4a.keywords.Common.DateTime.Add(_fechapagolong,(int) (0),(int) (0),_periodo);
RDebugUtils.currentLine=1507428;
 //BA.debugLineNum = 1507428;BA.debugLine="fechaPago = DateTime.Date(fechaPagoLong)";
_fechapago = anywheresoftware.b4a.keywords.Common.DateTime.Date(_fechapagolong);
 };
RDebugUtils.currentLine=1507431;
 //BA.debugLineNum = 1507431;BA.debugLine="sql.ExecNonQuery2(\"UPDATE egresos SET suma_egre";
_sql.ExecNonQuery2("UPDATE egresos SET suma_egresos = ?  WHERE id_egreso = 1",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_egresosactuales)}));
RDebugUtils.currentLine=1507432;
 //BA.debugLineNum = 1507432;BA.debugLine="sql.ExecNonQuery2(\"UPDATE metas_ahorro SET fech";
_sql.ExecNonQuery2("UPDATE metas_ahorro SET fecha_pago = ?, progreso = ? WHERE id_meta_ahorro = '"+BA.NumberToString((_contador+1))+"'",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_fechapago),(Object)(_progreso)}));
 }
};
 };
RDebugUtils.currentLine=1507435;
 //BA.debugLineNum = 1507435;BA.debugLine="End Sub";
return "";
}
public static int  _balanceactualingresos() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "balanceactualingresos", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "balanceactualingresos", null));}
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub balanceActualIngresos As Int";
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM ingresos\")";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM ingresos")));
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="cur.Position = 0";
mostCurrent._cur.setPosition((int) (0));
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="Return cur.GetInt(\"suma_ingresos\")";
if (true) return mostCurrent._cur.GetInt("suma_ingresos");
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="End Sub";
return 0;
}
public static int  _balanceactualegresos() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "balanceactualegresos", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "balanceactualegresos", null));}
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub balanceActualEgresos As Int";
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM egresos\")";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM egresos")));
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="cur.Position = 0";
mostCurrent._cur.setPosition((int) (0));
RDebugUtils.currentLine=1310724;
 //BA.debugLineNum = 1310724;BA.debugLine="Return cur.GetInt(\"suma_egresos\")";
if (true) return mostCurrent._cur.GetInt("suma_egresos");
RDebugUtils.currentLine=1310725;
 //BA.debugLineNum = 1310725;BA.debugLine="End Sub";
return 0;
}
public static int  _balancegeneral() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "balancegeneral", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "balancegeneral", null));}
int _ingresosactuales = 0;
int _egresosactuales = 0;
int _balanceactual = 0;
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub balanceGeneral As Int";
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="Dim ingresosActuales As Int";
_ingresosactuales = 0;
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="Dim egresosActuales As Int";
_egresosactuales = 0;
RDebugUtils.currentLine=1376260;
 //BA.debugLineNum = 1376260;BA.debugLine="Dim balanceActual As Int";
_balanceactual = 0;
RDebugUtils.currentLine=1376262;
 //BA.debugLineNum = 1376262;BA.debugLine="ingresosActuales = balanceActualIngresos";
_ingresosactuales = _balanceactualingresos();
RDebugUtils.currentLine=1376263;
 //BA.debugLineNum = 1376263;BA.debugLine="egresosActuales = balanceActualEgresos";
_egresosactuales = _balanceactualegresos();
RDebugUtils.currentLine=1376265;
 //BA.debugLineNum = 1376265;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM historial_bala";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM historial_balance ORDER BY rowid ASC")));
RDebugUtils.currentLine=1376266;
 //BA.debugLineNum = 1376266;BA.debugLine="If(cur.RowCount > 0) Then";
if ((mostCurrent._cur.getRowCount()>0)) { 
RDebugUtils.currentLine=1376267;
 //BA.debugLineNum = 1376267;BA.debugLine="cur.Position = cur.RowCount - 1";
mostCurrent._cur.setPosition((int) (mostCurrent._cur.getRowCount()-1));
RDebugUtils.currentLine=1376268;
 //BA.debugLineNum = 1376268;BA.debugLine="balanceActual = cur.GetInt(\"balance\")";
_balanceactual = mostCurrent._cur.GetInt("balance");
RDebugUtils.currentLine=1376269;
 //BA.debugLineNum = 1376269;BA.debugLine="balanceActual = balanceActual + ingresosActuales";
_balanceactual = (int) (_balanceactual+_ingresosactuales-_egresosactuales);
 }else {
RDebugUtils.currentLine=1376271;
 //BA.debugLineNum = 1376271;BA.debugLine="balanceActual = ingresosActuales - egresosActual";
_balanceactual = (int) (_ingresosactuales-_egresosactuales);
 };
RDebugUtils.currentLine=1376274;
 //BA.debugLineNum = 1376274;BA.debugLine="Return balanceActual";
if (true) return _balanceactual;
RDebugUtils.currentLine=1376275;
 //BA.debugLineNum = 1376275;BA.debugLine="End Sub";
return 0;
}
public static String  _estadobalance(int _balanceactual) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "estadobalance", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "estadobalance", new Object[] {_balanceactual}));}
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Sub estadoBalance(balanceActual As Int)";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="If(balanceActual < 0) Then";
if ((_balanceactual<0)) { 
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="lblEstado.Text = Chr(0xE811)";
mostCurrent._lblestado.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xe811))));
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="lblEstado.TextColor = Colors.ARGB(255, 234, 33,";
mostCurrent._lblestado.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (234),(int) (33),(int) (7)));
 }else 
{RDebugUtils.currentLine=1638404;
 //BA.debugLineNum = 1638404;BA.debugLine="Else If(balanceActual = 0) Then";
if ((_balanceactual==0)) { 
RDebugUtils.currentLine=1638405;
 //BA.debugLineNum = 1638405;BA.debugLine="lblEstado.Text = Chr(0xE812)";
mostCurrent._lblestado.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xe812))));
RDebugUtils.currentLine=1638406;
 //BA.debugLineNum = 1638406;BA.debugLine="lblEstado.TextColor = Colors.ARGB(255, 234, 199,";
mostCurrent._lblestado.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (234),(int) (199),(int) (7)));
 }else {
RDebugUtils.currentLine=1638408;
 //BA.debugLineNum = 1638408;BA.debugLine="lblEstado.Text = Chr(0xE813)";
mostCurrent._lblestado.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xe813))));
RDebugUtils.currentLine=1638409;
 //BA.debugLineNum = 1638409;BA.debugLine="lblEstado.TextColor = Colors.ARGB(255, 15, 234,";
mostCurrent._lblestado.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (15),(int) (234),(int) (7)));
 }}
;
RDebugUtils.currentLine=1638411;
 //BA.debugLineNum = 1638411;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _actualizardatos() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "actualizardatos", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "actualizardatos", null));}
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub actualizarDatos";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="lblBalance.Text = \"$\" & balanceGeneral & \".00\"";
mostCurrent._lblbalance.setText(BA.ObjectToCharSequence("$"+BA.NumberToString(_balancegeneral())+".00"));
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="lblIngresos.Text = \"$\" & balanceActualIngresos &";
mostCurrent._lblingresos.setText(BA.ObjectToCharSequence("$"+BA.NumberToString(_balanceactualingresos())+".00"));
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="lblEgresos.Text = \"$\" & balanceActualEgresos & \".";
mostCurrent._lblegresos.setText(BA.ObjectToCharSequence("$"+BA.NumberToString(_balanceactualegresos())+".00"));
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="estadoBalance(balanceGeneral)";
_estadobalance(_balancegeneral());
RDebugUtils.currentLine=1572869;
 //BA.debugLineNum = 1572869;BA.debugLine="End Sub";
return "";
}
public static String  _btnagregar_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnagregar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnagregar_click", null));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Private Sub btnAgregar_Click";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="click = Not(click)";
_click = anywheresoftware.b4a.keywords.Common.Not(_click);
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="pnlAgregar.Elevation = 8dip";
mostCurrent._pnlagregar.setElevation((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (8))));
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="pnlAgregar.SetVisibleAnimated(200, click) 'https:";
mostCurrent._pnlagregar.SetVisibleAnimated((int) (200),_click);
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="End Sub";
return "";
}
public static String  _btnagregargasto_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnagregargasto_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnagregargasto_click", null));}
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Private Sub btnAgregarGasto_Click";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="StartActivity(registrarGasto)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._registrargasto.getObject()));
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="btnAgregar_Click";
_btnagregar_click();
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="End Sub";
return "";
}
public static String  _btnagregaringreso_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnagregaringreso_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnagregaringreso_click", null));}
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Private Sub btnAgregarIngreso_Click";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="StartActivity(registrarIngreso)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._registraringreso.getObject()));
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="btnAgregar_Click";
_btnagregar_click();
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="End Sub";
return "";
}
public static String  _btnagregarmetadeahorro_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnagregarmetadeahorro_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnagregarmetadeahorro_click", null));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Private Sub btnAgregarMetaDeAhorro_Click";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="StartActivity(registrarMetaAhorro)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._registrarmetaahorro.getObject()));
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="btnAgregar_Click";
_btnagregar_click();
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="End Sub";
return "";
}
public static String  _btnagregarsuscripcion_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnagregarsuscripcion_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnagregarsuscripcion_click", null));}
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Private Sub btnAgregarSuscripcion_Click";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="StartActivity(registrarSuscripcion)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._registrarsuscripcion.getObject()));
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="btnAgregar_Click";
_btnagregar_click();
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="End Sub";
return "";
}
public static String  _btngastos_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btngastos_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btngastos_click", null));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Private Sub btnGastos_Click";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="StartActivity(Gastos)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._gastos.getObject()));
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="End Sub";
return "";
}
public static String  _btngenerarhistorial_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btngenerarhistorial_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btngenerarhistorial_click", null));}
int _resultado = 0;
int _totalingresos = 0;
int _totalegresos = 0;
int _totalbalance = 0;
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Private Sub btnGenerarHistorial_Click";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="Dim resultado As Int";
_resultado = 0;
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="Dim totalIngresos As Int";
_totalingresos = 0;
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="Dim totalEgresos As Int";
_totalegresos = 0;
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="Dim totalBalance As Int";
_totalbalance = 0;
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="totalIngresos = balanceActualIngresos";
_totalingresos = _balanceactualingresos();
RDebugUtils.currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="totalEgresos = balanceActualEgresos";
_totalegresos = _balanceactualegresos();
RDebugUtils.currentLine=393223;
 //BA.debugLineNum = 393223;BA.debugLine="totalBalance = balanceGeneral";
_totalbalance = _balancegeneral();
RDebugUtils.currentLine=393225;
 //BA.debugLineNum = 393225;BA.debugLine="resultado = Msgbox2(\"¿Estás seguro?\", \"Generar hi";
_resultado = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("¿Estás seguro?"),BA.ObjectToCharSequence("Generar historial"),"Sí","","No",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=393227;
 //BA.debugLineNum = 393227;BA.debugLine="If (resultado = DialogResponse.POSITIVE) Then";
if ((_resultado==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE)) { 
RDebugUtils.currentLine=393228;
 //BA.debugLineNum = 393228;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO historial_balance";
_sql.ExecNonQuery2("INSERT INTO historial_balance (balance, suma_ingresos, suma_egresos, fecha_historial) VALUES (?, ?, ?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_totalbalance),(Object)(_totalingresos),(Object)(_totalegresos),(Object)(_obtenerfechaactual())}));
RDebugUtils.currentLine=393229;
 //BA.debugLineNum = 393229;BA.debugLine="ToastMessageShow(\"Historial generado\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Historial generado"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=393230;
 //BA.debugLineNum = 393230;BA.debugLine="sql.ExecNonQuery2(\"UPDATE ingresos SET suma_ingr";
_sql.ExecNonQuery2("UPDATE ingresos SET suma_ingresos = ?  WHERE id_ingreso = 1",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(0)}));
RDebugUtils.currentLine=393231;
 //BA.debugLineNum = 393231;BA.debugLine="sql.ExecNonQuery2(\"UPDATE egresos SET suma_egres";
_sql.ExecNonQuery2("UPDATE egresos SET suma_egresos = ?  WHERE id_egreso = 1",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(0)}));
RDebugUtils.currentLine=393232;
 //BA.debugLineNum = 393232;BA.debugLine="lblIngresos.Text = \"$\" & \"0.00\"";
mostCurrent._lblingresos.setText(BA.ObjectToCharSequence("$"+"0.00"));
RDebugUtils.currentLine=393233;
 //BA.debugLineNum = 393233;BA.debugLine="lblEgresos.Text = \"$\"  & \"0.00\"";
mostCurrent._lblegresos.setText(BA.ObjectToCharSequence("$"+"0.00"));
 };
RDebugUtils.currentLine=393235;
 //BA.debugLineNum = 393235;BA.debugLine="End Sub";
return "";
}
public static String  _obtenerfechaactual() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "obtenerfechaactual", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "obtenerfechaactual", null));}
long _ahora = 0L;
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub obtenerFechaActual As String";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="Dim ahora As Long";
_ahora = 0L;
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="ahora = DateTime.Now";
_ahora = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="Return (DateTime.Date(ahora))";
if (true) return (anywheresoftware.b4a.keywords.Common.DateTime.Date(_ahora));
RDebugUtils.currentLine=1179653;
 //BA.debugLineNum = 1179653;BA.debugLine="End Sub";
return "";
}
public static String  _btnhistoriales_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnhistoriales_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnhistoriales_click", null));}
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Private Sub btnHistoriales_Click";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="StartActivity(Historiales)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._historiales.getObject()));
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="End Sub";
return "";
}
public static String  _btningresosrecurrentes_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btningresosrecurrentes_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btningresosrecurrentes_click", null));}
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Private Sub btnIngresosRecurrentes_Click";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="StartActivity(IngresosRecurrentes)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._ingresosrecurrentes.getObject()));
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="End Sub";
return "";
}
public static String  _btningresosunicos_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btningresosunicos_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btningresosunicos_click", null));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Private Sub btnIngresosUnicos_Click";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="StartActivity(IngresosUnicos)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._ingresosunicos.getObject()));
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="End Sub";
return "";
}
public static String  _btnmetasdeahorro_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnmetasdeahorro_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnmetasdeahorro_click", null));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Private Sub btnMetasDeAhorro_Click";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="StartActivity(MetasDeAhorro)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._metasdeahorro.getObject()));
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="End Sub";
return "";
}
public static String  _btnsuscripciones_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnsuscripciones_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnsuscripciones_click", null));}
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Private Sub btnSuscripciones_Click";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="StartActivity(Suscripciones)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._suscripciones.getObject()));
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="End Sub";
return "";
}
}