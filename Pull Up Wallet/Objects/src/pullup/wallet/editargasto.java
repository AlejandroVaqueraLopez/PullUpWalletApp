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

public class editargasto extends Activity implements B4AActivity{
	public static editargasto mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "pullup.wallet", "pullup.wallet.editargasto");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (editargasto).");
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
		activityBA = new BA(this, layout, processBA, "pullup.wallet", "pullup.wallet.editargasto");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "pullup.wallet.editargasto", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (editargasto) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (editargasto) Resume **");
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
		return editargasto.class;
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
            BA.LogInfo("** Activity (editargasto) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (editargasto) Pause event (activity is not paused). **");
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
            editargasto mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (editargasto) Resume **");
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
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.sql.SQL _sql = null;
public static int _alturadispositivo = 0;
public static int _anchodispositivo = 0;
public static int _colorcaja = 0;
public static boolean _aparicionmsgbox1 = false;
public static boolean _aparicionmsgbox2 = false;
public static boolean _aparicionmsgbox3 = false;
public anywheresoftware.b4a.sql.SQL.CursorWrapper _cur = null;
public static int _idregistro = 0;
public static int _sumaegresosantigua = 0;
public static int _montoantiguo = 0;
public static int _montonuevo = 0;
public static int _sumaegresosactual = 0;
public anywheresoftware.b4a.objects.ButtonWrapper _btnmenu = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnoperaciongasto = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtdescripcion = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtmonto = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtnombre = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblfondomonto = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblfondodescripcion = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblfondonombre = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblcontornoboton = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblnombrevista = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlnavinferior = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlselector = null;
public pullup.wallet.ascolorslider _cpbarracolor = null;
public pullup.wallet.main _main = null;
public pullup.wallet.starter _starter = null;
public pullup.wallet.tutorial _tutorial = null;
public pullup.wallet.diapositivas _diapositivas = null;
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
RDebugUtils.currentModule="editargasto";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="Activity.LoadLayout(\"LFormGasto\")";
mostCurrent._activity.LoadLayout("LFormGasto",mostCurrent.activityBA);
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
_alturadispositivo = mostCurrent._main._alturadispositivo /*int*/ ;
RDebugUtils.currentLine=3342339;
 //BA.debugLineNum = 3342339;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
_anchodispositivo = mostCurrent._main._anchodispositivo /*int*/ ;
RDebugUtils.currentLine=3342340;
 //BA.debugLineNum = 3342340;BA.debugLine="sql = Starter.sql";
_sql = mostCurrent._starter._sql /*anywheresoftware.b4a.sql.SQL*/ ;
RDebugUtils.currentLine=3342341;
 //BA.debugLineNum = 3342341;BA.debugLine="aparicionMsgBox1 = False";
_aparicionmsgbox1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=3342342;
 //BA.debugLineNum = 3342342;BA.debugLine="aparicionMsgBox2 = False";
_aparicionmsgbox2 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=3342343;
 //BA.debugLineNum = 3342343;BA.debugLine="aparicionMsgBox3 = False";
_aparicionmsgbox3 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=3342344;
 //BA.debugLineNum = 3342344;BA.debugLine="colorCaja = 0";
_colorcaja = (int) (0);
RDebugUtils.currentLine=3342348;
 //BA.debugLineNum = 3342348;BA.debugLine="lblNombreVista.TextSize = 20";
mostCurrent._lblnombrevista.setTextSize((float) (20));
RDebugUtils.currentLine=3342349;
 //BA.debugLineNum = 3342349;BA.debugLine="lblNombreVista.TextColor = Colors.Black";
mostCurrent._lblnombrevista.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3342350;
 //BA.debugLineNum = 3342350;BA.debugLine="lblNombreVista.Height = 30dip";
mostCurrent._lblnombrevista.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=3342351;
 //BA.debugLineNum = 3342351;BA.debugLine="lblNombreVista.Width = anchoDispositivo * 0.9";
mostCurrent._lblnombrevista.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=3342352;
 //BA.debugLineNum = 3342352;BA.debugLine="lblNombreVista.Top = 30dip";
mostCurrent._lblnombrevista.setTop(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=3342353;
 //BA.debugLineNum = 3342353;BA.debugLine="lblNombreVista.Left = (anchoDispositivo - lblNomb";
mostCurrent._lblnombrevista.setLeft((int) ((_anchodispositivo-mostCurrent._lblnombrevista.getWidth())/(double)2));
RDebugUtils.currentLine=3342355;
 //BA.debugLineNum = 3342355;BA.debugLine="txtMonto.Width = anchoDispositivo * 0.9";
mostCurrent._txtmonto.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=3342356;
 //BA.debugLineNum = 3342356;BA.debugLine="txtMonto.Height = alturaDispositivo * 0.25";
mostCurrent._txtmonto.setHeight((int) (_alturadispositivo*0.25));
RDebugUtils.currentLine=3342357;
 //BA.debugLineNum = 3342357;BA.debugLine="txtMonto.Top = lblNombreVista.Top * 2 + lblNombre";
mostCurrent._txtmonto.setTop((int) (mostCurrent._lblnombrevista.getTop()*2+mostCurrent._lblnombrevista.getHeight()));
RDebugUtils.currentLine=3342358;
 //BA.debugLineNum = 3342358;BA.debugLine="txtMonto.Left = (anchoDispositivo - txtMonto.Widt";
mostCurrent._txtmonto.setLeft((int) ((_anchodispositivo-mostCurrent._txtmonto.getWidth())/(double)2));
RDebugUtils.currentLine=3342359;
 //BA.debugLineNum = 3342359;BA.debugLine="lblFondoMonto.Width = txtMonto.Width";
mostCurrent._lblfondomonto.setWidth(mostCurrent._txtmonto.getWidth());
RDebugUtils.currentLine=3342360;
 //BA.debugLineNum = 3342360;BA.debugLine="lblFondoMonto.Height = txtMonto.Height";
mostCurrent._lblfondomonto.setHeight(mostCurrent._txtmonto.getHeight());
RDebugUtils.currentLine=3342361;
 //BA.debugLineNum = 3342361;BA.debugLine="lblFondoMonto.Top = txtMonto.Top";
mostCurrent._lblfondomonto.setTop(mostCurrent._txtmonto.getTop());
RDebugUtils.currentLine=3342362;
 //BA.debugLineNum = 3342362;BA.debugLine="lblFondoMonto.Left = txtMonto.Left";
mostCurrent._lblfondomonto.setLeft(mostCurrent._txtmonto.getLeft());
RDebugUtils.currentLine=3342364;
 //BA.debugLineNum = 3342364;BA.debugLine="txtNombre.Width = anchoDispositivo * 0.9";
mostCurrent._txtnombre.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=3342365;
 //BA.debugLineNum = 3342365;BA.debugLine="txtNombre.Height = alturaDispositivo * 0.1";
mostCurrent._txtnombre.setHeight((int) (_alturadispositivo*0.1));
RDebugUtils.currentLine=3342366;
 //BA.debugLineNum = 3342366;BA.debugLine="txtNombre.Top = txtMonto.Top + txtMonto.Height +";
mostCurrent._txtnombre.setTop((int) (mostCurrent._txtmonto.getTop()+mostCurrent._txtmonto.getHeight()+mostCurrent._lblnombrevista.getTop()));
RDebugUtils.currentLine=3342367;
 //BA.debugLineNum = 3342367;BA.debugLine="txtNombre.Left = (anchoDispositivo - txtNombre.Wi";
mostCurrent._txtnombre.setLeft((int) ((_anchodispositivo-mostCurrent._txtnombre.getWidth())/(double)2));
RDebugUtils.currentLine=3342368;
 //BA.debugLineNum = 3342368;BA.debugLine="lblFondoNombre.Width = txtMonto.Width";
mostCurrent._lblfondonombre.setWidth(mostCurrent._txtmonto.getWidth());
RDebugUtils.currentLine=3342369;
 //BA.debugLineNum = 3342369;BA.debugLine="lblFondoNombre.Height = txtNombre.Height";
mostCurrent._lblfondonombre.setHeight(mostCurrent._txtnombre.getHeight());
RDebugUtils.currentLine=3342370;
 //BA.debugLineNum = 3342370;BA.debugLine="lblFondoNombre.Top = txtNombre.Top";
mostCurrent._lblfondonombre.setTop(mostCurrent._txtnombre.getTop());
RDebugUtils.currentLine=3342371;
 //BA.debugLineNum = 3342371;BA.debugLine="lblFondoNombre.Left = txtNombre.Left";
mostCurrent._lblfondonombre.setLeft(mostCurrent._txtnombre.getLeft());
RDebugUtils.currentLine=3342373;
 //BA.debugLineNum = 3342373;BA.debugLine="pnlSelector.Top = txtNombre.Top + txtNombre.Heigh";
mostCurrent._pnlselector.setTop((int) (mostCurrent._txtnombre.getTop()+mostCurrent._txtnombre.getHeight()+mostCurrent._lblnombrevista.getTop()));
RDebugUtils.currentLine=3342374;
 //BA.debugLineNum = 3342374;BA.debugLine="pnlSelector.Left = txtNombre.Left + txtNombre.Wid";
mostCurrent._pnlselector.setLeft((int) (mostCurrent._txtnombre.getLeft()+mostCurrent._txtnombre.getWidth()-mostCurrent._pnlselector.getWidth()));
RDebugUtils.currentLine=3342376;
 //BA.debugLineNum = 3342376;BA.debugLine="txtDescripcion.Width = (txtNombre.Width - pnlSele";
mostCurrent._txtdescripcion.setWidth((int) ((mostCurrent._txtnombre.getWidth()-mostCurrent._pnlselector.getWidth())*0.9));
RDebugUtils.currentLine=3342377;
 //BA.debugLineNum = 3342377;BA.debugLine="txtDescripcion.Height = pnlSelector.Height";
mostCurrent._txtdescripcion.setHeight(mostCurrent._pnlselector.getHeight());
RDebugUtils.currentLine=3342378;
 //BA.debugLineNum = 3342378;BA.debugLine="txtDescripcion.Top = pnlSelector.Top";
mostCurrent._txtdescripcion.setTop(mostCurrent._pnlselector.getTop());
RDebugUtils.currentLine=3342379;
 //BA.debugLineNum = 3342379;BA.debugLine="txtDescripcion.Left = txtNombre.Left";
mostCurrent._txtdescripcion.setLeft(mostCurrent._txtnombre.getLeft());
RDebugUtils.currentLine=3342380;
 //BA.debugLineNum = 3342380;BA.debugLine="lblFondoDescripcion.Width = txtDescripcion.Width";
mostCurrent._lblfondodescripcion.setWidth(mostCurrent._txtdescripcion.getWidth());
RDebugUtils.currentLine=3342381;
 //BA.debugLineNum = 3342381;BA.debugLine="lblFondoDescripcion.Height = txtDescripcion.Heigh";
mostCurrent._lblfondodescripcion.setHeight(mostCurrent._txtdescripcion.getHeight());
RDebugUtils.currentLine=3342382;
 //BA.debugLineNum = 3342382;BA.debugLine="lblFondoDescripcion.Top = txtDescripcion.Top";
mostCurrent._lblfondodescripcion.setTop(mostCurrent._txtdescripcion.getTop());
RDebugUtils.currentLine=3342383;
 //BA.debugLineNum = 3342383;BA.debugLine="lblFondoDescripcion.Left = txtDescripcion.Left";
mostCurrent._lblfondodescripcion.setLeft(mostCurrent._txtdescripcion.getLeft());
RDebugUtils.currentLine=3342388;
 //BA.debugLineNum = 3342388;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
mostCurrent._pnlnavinferior.setHeight((int) (_alturadispositivo*0.08));
RDebugUtils.currentLine=3342389;
 //BA.debugLineNum = 3342389;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
mostCurrent._pnlnavinferior.setWidth(_anchodispositivo);
RDebugUtils.currentLine=3342390;
 //BA.debugLineNum = 3342390;BA.debugLine="pnlNavInferior.Left = 0";
mostCurrent._pnlnavinferior.setLeft((int) (0));
RDebugUtils.currentLine=3342391;
 //BA.debugLineNum = 3342391;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
mostCurrent._pnlnavinferior.setTop((int) (_alturadispositivo-mostCurrent._pnlnavinferior.getHeight()));
RDebugUtils.currentLine=3342394;
 //BA.debugLineNum = 3342394;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
mostCurrent._btnmenu.setWidth((int) (_anchodispositivo*0.15));
RDebugUtils.currentLine=3342395;
 //BA.debugLineNum = 3342395;BA.debugLine="btnMenu.Height = btnMenu.Width";
mostCurrent._btnmenu.setHeight(mostCurrent._btnmenu.getWidth());
RDebugUtils.currentLine=3342396;
 //BA.debugLineNum = 3342396;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
mostCurrent._btnmenu.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._btnmenu.getHeight()/(double)2));
RDebugUtils.currentLine=3342397;
 //BA.debugLineNum = 3342397;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
mostCurrent._btnmenu.setLeft((int) ((_anchodispositivo-mostCurrent._btnmenu.getWidth())/(double)2));
RDebugUtils.currentLine=3342399;
 //BA.debugLineNum = 3342399;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
mostCurrent._lblcontornoboton.setWidth((int) (_anchodispositivo*0.17));
RDebugUtils.currentLine=3342400;
 //BA.debugLineNum = 3342400;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
mostCurrent._lblcontornoboton.setHeight(mostCurrent._lblcontornoboton.getWidth());
RDebugUtils.currentLine=3342401;
 //BA.debugLineNum = 3342401;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
mostCurrent._lblcontornoboton.setLeft((int) ((_anchodispositivo-mostCurrent._lblcontornoboton.getWidth())/(double)2));
RDebugUtils.currentLine=3342402;
 //BA.debugLineNum = 3342402;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
mostCurrent._lblcontornoboton.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._lblcontornoboton.getHeight()/(double)2));
RDebugUtils.currentLine=3342407;
 //BA.debugLineNum = 3342407;BA.debugLine="btnOperacionGasto.Text = \"Editar gasto\"";
mostCurrent._btnoperaciongasto.setText(BA.ObjectToCharSequence("Editar gasto"));
RDebugUtils.currentLine=3342408;
 //BA.debugLineNum = 3342408;BA.debugLine="btnOperacionGasto.Top = txtDescripcion.Top + txtD";
mostCurrent._btnoperaciongasto.setTop((int) (mostCurrent._txtdescripcion.getTop()+mostCurrent._txtdescripcion.getHeight()+(mostCurrent._lblcontornoboton.getTop()-(mostCurrent._txtdescripcion.getTop()+mostCurrent._txtdescripcion.getHeight()+mostCurrent._btnoperaciongasto.getHeight()))/(double)2));
RDebugUtils.currentLine=3342409;
 //BA.debugLineNum = 3342409;BA.debugLine="btnOperacionGasto.Left = (anchoDispositivo - btnO";
mostCurrent._btnoperaciongasto.setLeft((int) ((_anchodispositivo-mostCurrent._btnoperaciongasto.getWidth())/(double)2));
RDebugUtils.currentLine=3342410;
 //BA.debugLineNum = 3342410;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="editargasto";
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="editargasto";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=3407874;
 //BA.debugLineNum = 3407874;BA.debugLine="End Sub";
return "";
}
public static pullup.wallet.main._registrogasto  _asignacioncampos() throws Exception{
RDebugUtils.currentModule="editargasto";
if (Debug.shouldDelegate(mostCurrent.activityBA, "asignacioncampos", false))
	 {return ((pullup.wallet.main._registrogasto) Debug.delegate(mostCurrent.activityBA, "asignacioncampos", null));}
pullup.wallet.main._registrogasto _gasto = null;
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Sub asignacionCampos As RegistroGasto";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="Dim gasto As RegistroGasto";
_gasto = new pullup.wallet.main._registrogasto();
RDebugUtils.currentLine=3997699;
 //BA.debugLineNum = 3997699;BA.debugLine="gasto.monto = txtMonto.Text";
_gasto.monto /*int*/  = (int)(Double.parseDouble(mostCurrent._txtmonto.getText()));
RDebugUtils.currentLine=3997701;
 //BA.debugLineNum = 3997701;BA.debugLine="gasto.nombre = txtNombre.Text";
_gasto.nombre /*String*/  = mostCurrent._txtnombre.getText();
RDebugUtils.currentLine=3997703;
 //BA.debugLineNum = 3997703;BA.debugLine="gasto.descripcion = (txtDescripcion.Text)";
_gasto.descripcion /*String*/  = (mostCurrent._txtdescripcion.getText());
RDebugUtils.currentLine=3997705;
 //BA.debugLineNum = 3997705;BA.debugLine="gasto.color = colorCaja";
_gasto.color /*int*/  = _colorcaja;
RDebugUtils.currentLine=3997707;
 //BA.debugLineNum = 3997707;BA.debugLine="Return gasto";
if (true) return _gasto;
RDebugUtils.currentLine=3997708;
 //BA.debugLineNum = 3997708;BA.debugLine="End Sub";
return null;
}
public static String  _btnmenu_click() throws Exception{
RDebugUtils.currentModule="editargasto";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnmenu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnmenu_click", null));}
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Private Sub btnMenu_Click";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="End Sub";
return "";
}
public static String  _btnoperaciongasto_click() throws Exception{
RDebugUtils.currentModule="editargasto";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnoperaciongasto_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnoperaciongasto_click", null));}
boolean _validaciones = false;
pullup.wallet.main._registrogasto _gastoregistro = null;
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Private Sub btnOperacionGasto_Click";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="Dim validaciones As Boolean";
_validaciones = false;
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="validaciones = validarCampos";
_validaciones = _validarcampos();
RDebugUtils.currentLine=4063236;
 //BA.debugLineNum = 4063236;BA.debugLine="If(validaciones = True) Then";
if ((_validaciones==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=4063238;
 //BA.debugLineNum = 4063238;BA.debugLine="Dim gastoRegistro As RegistroGasto";
_gastoregistro = new pullup.wallet.main._registrogasto();
RDebugUtils.currentLine=4063239;
 //BA.debugLineNum = 4063239;BA.debugLine="gastoRegistro = asignacionCampos";
_gastoregistro = _asignacioncampos();
RDebugUtils.currentLine=4063242;
 //BA.debugLineNum = 4063242;BA.debugLine="cur = sql.ExecQuery2(\"SELECT monto FROM gastos W";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery2("SELECT monto FROM gastos WHERE id_gasto = ?",new String[]{BA.NumberToString(_idregistro)+""})));
RDebugUtils.currentLine=4063243;
 //BA.debugLineNum = 4063243;BA.debugLine="cur.Position = 0";
mostCurrent._cur.setPosition((int) (0));
RDebugUtils.currentLine=4063245;
 //BA.debugLineNum = 4063245;BA.debugLine="montoAntiguo = cur.GetInt(\"monto\")";
_montoantiguo = mostCurrent._cur.GetInt("monto");
RDebugUtils.currentLine=4063246;
 //BA.debugLineNum = 4063246;BA.debugLine="montoNuevo = gastoRegistro.monto";
_montonuevo = _gastoregistro.monto /*int*/ ;
RDebugUtils.currentLine=4063249;
 //BA.debugLineNum = 4063249;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM egresos WHERE";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM egresos WHERE id_egreso = 1")));
RDebugUtils.currentLine=4063250;
 //BA.debugLineNum = 4063250;BA.debugLine="cur.Position = 0";
mostCurrent._cur.setPosition((int) (0));
RDebugUtils.currentLine=4063251;
 //BA.debugLineNum = 4063251;BA.debugLine="sumaEgresosAntigua = cur.GetInt(\"suma_egresos\")";
_sumaegresosantigua = mostCurrent._cur.GetInt("suma_egresos");
RDebugUtils.currentLine=4063254;
 //BA.debugLineNum = 4063254;BA.debugLine="sumaEgresosActual = (sumaEgresosAntigua - montoA";
_sumaegresosactual = (int) ((_sumaegresosantigua-_montoantiguo)+_montonuevo);
RDebugUtils.currentLine=4063257;
 //BA.debugLineNum = 4063257;BA.debugLine="sql.ExecNonQuery2(\"UPDATE egresos SET suma_egres";
_sql.ExecNonQuery2("UPDATE egresos SET suma_egresos = ? WHERE id_egreso = 1",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_sumaegresosactual)}));
RDebugUtils.currentLine=4063260;
 //BA.debugLineNum = 4063260;BA.debugLine="Starter.sql.ExecNonQuery2(\"UPDATE gastos SET mon";
mostCurrent._starter._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE gastos SET monto = ?, nombre = ?, descripcion = ?, color = ?  WHERE id_gasto = '"+BA.NumberToString(_idregistro)+"'",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_gastoregistro.monto /*int*/ ),(Object)(_gastoregistro.nombre /*String*/ ),(Object)(_gastoregistro.descripcion /*String*/ ),(Object)(_gastoregistro.color /*int*/ )}));
RDebugUtils.currentLine=4063262;
 //BA.debugLineNum = 4063262;BA.debugLine="ToastMessageShow(\"Gasto editado\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Gasto editado"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4063264;
 //BA.debugLineNum = 4063264;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=4063266;
 //BA.debugLineNum = 4063266;BA.debugLine="StartActivity(Gastos)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._gastos.getObject()));
 }else {
RDebugUtils.currentLine=4063269;
 //BA.debugLineNum = 4063269;BA.debugLine="Msgbox2(\"Por favor, rellene todos los campos y s";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Por favor, rellene todos los campos y seleccione un color"),BA.ObjectToCharSequence("Registro incorrecto"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 };
RDebugUtils.currentLine=4063271;
 //BA.debugLineNum = 4063271;BA.debugLine="End Sub";
return "";
}
public static boolean  _validarcampos() throws Exception{
RDebugUtils.currentModule="editargasto";
if (Debug.shouldDelegate(mostCurrent.activityBA, "validarcampos", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "validarcampos", null));}
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub validarCampos As Boolean";
RDebugUtils.currentLine=3604481;
 //BA.debugLineNum = 3604481;BA.debugLine="If(txtMonto.Text.Length <> 0 And txtNombre.Text.L";
if ((mostCurrent._txtmonto.getText().length()!=0 && mostCurrent._txtnombre.getText().length()!=0 && mostCurrent._txtdescripcion.getText().length()!=0 && _colorcaja!=0)) { 
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=3604484;
 //BA.debugLineNum = 3604484;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=3604486;
 //BA.debugLineNum = 3604486;BA.debugLine="End Sub";
return false;
}
public static String  _consultaaeditar(int _rowid) throws Exception{
RDebugUtils.currentModule="editargasto";
if (Debug.shouldDelegate(mostCurrent.activityBA, "consultaaeditar", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "consultaaeditar", new Object[] {_rowid}));}
pullup.wallet.main._registrogasto _gasto = null;
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Sub consultaAEditar(rowid As Int)";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="Dim gasto As RegistroGasto";
_gasto = new pullup.wallet.main._registrogasto();
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="idRegistro = rowid";
_idregistro = _rowid;
RDebugUtils.currentLine=4128772;
 //BA.debugLineNum = 4128772;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM gastos WHERE i";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM gastos WHERE id_gasto = '"+BA.NumberToString(_idregistro)+"'")));
RDebugUtils.currentLine=4128773;
 //BA.debugLineNum = 4128773;BA.debugLine="If(cur.RowCount > 0) Then";
if ((mostCurrent._cur.getRowCount()>0)) { 
RDebugUtils.currentLine=4128774;
 //BA.debugLineNum = 4128774;BA.debugLine="cur.Position = 0";
mostCurrent._cur.setPosition((int) (0));
RDebugUtils.currentLine=4128775;
 //BA.debugLineNum = 4128775;BA.debugLine="gasto.nombre = cur.GetString(\"nombre\")";
_gasto.nombre /*String*/  = mostCurrent._cur.GetString("nombre");
RDebugUtils.currentLine=4128776;
 //BA.debugLineNum = 4128776;BA.debugLine="gasto.monto = cur.GetInt(\"monto\")";
_gasto.monto /*int*/  = mostCurrent._cur.GetInt("monto");
RDebugUtils.currentLine=4128777;
 //BA.debugLineNum = 4128777;BA.debugLine="gasto.descripcion = cur.GetString(\"descripcion\")";
_gasto.descripcion /*String*/  = mostCurrent._cur.GetString("descripcion");
RDebugUtils.currentLine=4128778;
 //BA.debugLineNum = 4128778;BA.debugLine="gasto.color = cur.GetString(\"color\")";
_gasto.color /*int*/  = (int)(Double.parseDouble(mostCurrent._cur.GetString("color")));
RDebugUtils.currentLine=4128780;
 //BA.debugLineNum = 4128780;BA.debugLine="reasignarCamposAEditar(gasto)";
_reasignarcamposaeditar(_gasto);
 };
RDebugUtils.currentLine=4128782;
 //BA.debugLineNum = 4128782;BA.debugLine="End Sub";
return "";
}
public static String  _reasignarcamposaeditar(pullup.wallet.main._registrogasto _registro) throws Exception{
RDebugUtils.currentModule="editargasto";
if (Debug.shouldDelegate(mostCurrent.activityBA, "reasignarcamposaeditar", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "reasignarcamposaeditar", new Object[] {_registro}));}
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Sub reasignarCamposAEditar(registro As RegistroGas";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="txtNombre.Text = registro.nombre";
mostCurrent._txtnombre.setText(BA.ObjectToCharSequence(_registro.nombre /*String*/ ));
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="txtMonto.Text = registro.monto";
mostCurrent._txtmonto.setText(BA.ObjectToCharSequence(_registro.monto /*int*/ ));
RDebugUtils.currentLine=4194307;
 //BA.debugLineNum = 4194307;BA.debugLine="txtDescripcion.Text = registro.descripcion";
mostCurrent._txtdescripcion.setText(BA.ObjectToCharSequence(_registro.descripcion /*String*/ ));
RDebugUtils.currentLine=4194309;
 //BA.debugLineNum = 4194309;BA.debugLine="cpBarraColor_ColorChanged(registro.color)";
_cpbarracolor_colorchanged(_registro.color /*int*/ );
RDebugUtils.currentLine=4194310;
 //BA.debugLineNum = 4194310;BA.debugLine="End Sub";
return "";
}
public static String  _cpbarracolor_colorchanged(int _color) throws Exception{
RDebugUtils.currentModule="editargasto";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cpbarracolor_colorchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cpbarracolor_colorchanged", new Object[] {_color}));}
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Sub cpBarraColor_ColorChanged(color As Int)";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="lblFondoMonto.Color = color";
mostCurrent._lblfondomonto.setColor(_color);
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="colorCaja = color";
_colorcaja = _color;
RDebugUtils.currentLine=3932163;
 //BA.debugLineNum = 3932163;BA.debugLine="End Sub";
return "";
}
public static String  _limitarlongitudentrada(String _antiguo,String _nuevo,int _longitud,anywheresoftware.b4a.objects.B4XViewWrapper _view,String _campo) throws Exception{
RDebugUtils.currentModule="editargasto";
if (Debug.shouldDelegate(mostCurrent.activityBA, "limitarlongitudentrada", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "limitarlongitudentrada", new Object[] {_antiguo,_nuevo,_longitud,_view,_campo}));}
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Sub limitarLongitudEntrada(antiguo As String, nuev";
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="If(nuevo.Length > longitud) Then";
if ((_nuevo.length()>_longitud)) { 
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="If(campo = \"monto\") Then";
if (((_campo).equals("monto"))) { 
RDebugUtils.currentLine=3670019;
 //BA.debugLineNum = 3670019;BA.debugLine="If(aparicionMsgBox1 = False) Then";
if ((_aparicionmsgbox1==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=3670020;
 //BA.debugLineNum = 3670020;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para el monto es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=3670021;
 //BA.debugLineNum = 3670021;BA.debugLine="aparicionMsgBox1 = True";
_aparicionmsgbox1 = anywheresoftware.b4a.keywords.Common.True;
 };
 }else 
{RDebugUtils.currentLine=3670023;
 //BA.debugLineNum = 3670023;BA.debugLine="Else If(campo = \"nombre\") Then";
if (((_campo).equals("nombre"))) { 
RDebugUtils.currentLine=3670024;
 //BA.debugLineNum = 3670024;BA.debugLine="If(aparicionMsgBox2 = False) Then";
if ((_aparicionmsgbox2==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=3670025;
 //BA.debugLineNum = 3670025;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para el nombre es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=3670026;
 //BA.debugLineNum = 3670026;BA.debugLine="aparicionMsgBox2 = True";
_aparicionmsgbox2 = anywheresoftware.b4a.keywords.Common.True;
 };
 }else 
{RDebugUtils.currentLine=3670028;
 //BA.debugLineNum = 3670028;BA.debugLine="Else If(campo = \"descripcion\") Then";
if (((_campo).equals("descripcion"))) { 
RDebugUtils.currentLine=3670029;
 //BA.debugLineNum = 3670029;BA.debugLine="If(aparicionMsgBox3 = False) Then";
if ((_aparicionmsgbox3==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=3670030;
 //BA.debugLineNum = 3670030;BA.debugLine="Msgbox2(\"La longitud máxima permitida para la";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para la descripción es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=3670031;
 //BA.debugLineNum = 3670031;BA.debugLine="aparicionMsgBox3 = True";
_aparicionmsgbox3 = anywheresoftware.b4a.keywords.Common.True;
 };
 }}}
;
RDebugUtils.currentLine=3670034;
 //BA.debugLineNum = 3670034;BA.debugLine="view.Text = antiguo";
_view.setText(BA.ObjectToCharSequence(_antiguo));
 };
RDebugUtils.currentLine=3670036;
 //BA.debugLineNum = 3670036;BA.debugLine="End Sub";
return "";
}
public static String  _txtdescripcion_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="editargasto";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtdescripcion_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtdescripcion_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Private Sub txtDescripcion_TextChanged (Old As Str";
RDebugUtils.currentLine=3866625;
 //BA.debugLineNum = 3866625;BA.debugLine="limitarLongitudEntrada(Old, New, 41, txtDescripci";
_limitarlongitudentrada(_old,_new,(int) (41),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtdescripcion.getObject())),"descripcion");
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="End Sub";
return "";
}
public static String  _txtmonto_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="editargasto";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtmonto_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtmonto_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Private Sub txtMonto_TextChanged (Old As String, N";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="limitarLongitudEntrada(Old, New, 9, txtMonto, \"mo";
_limitarlongitudentrada(_old,_new,(int) (9),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtmonto.getObject())),"monto");
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="End Sub";
return "";
}
public static String  _txtnombre_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="editargasto";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtnombre_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtnombre_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Private Sub txtNombre_TextChanged (Old As String,";
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="limitarLongitudEntrada(Old, New, 16, txtNombre, \"";
_limitarlongitudentrada(_old,_new,(int) (16),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtnombre.getObject())),"nombre");
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="End Sub";
return "";
}
}