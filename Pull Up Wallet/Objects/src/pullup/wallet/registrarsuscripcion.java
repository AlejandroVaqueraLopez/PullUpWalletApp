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

public class registrarsuscripcion extends Activity implements B4AActivity{
	public static registrarsuscripcion mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "pullup.wallet", "pullup.wallet.registrarsuscripcion");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (registrarsuscripcion).");
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
		activityBA = new BA(this, layout, processBA, "pullup.wallet", "pullup.wallet.registrarsuscripcion");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "pullup.wallet.registrarsuscripcion", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (registrarsuscripcion) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (registrarsuscripcion) Resume **");
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
		return registrarsuscripcion.class;
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
            BA.LogInfo("** Activity (registrarsuscripcion) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (registrarsuscripcion) Pause event (activity is not paused). **");
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
            registrarsuscripcion mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (registrarsuscripcion) Resume **");
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
public static int _diasperiodo = 0;
public static boolean _aparicionmsgbox1 = false;
public static boolean _aparicionmsgbox2 = false;
public static boolean _aparicionmsgbox3 = false;
public anywheresoftware.b4a.sql.SQL.CursorWrapper _cur = null;
public static int _egresosactuales = 0;
public anywheresoftware.b4a.objects.ButtonWrapper _btnmenu = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnoperacionsuscripcion = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtdescripcion = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtmonto = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtnombre = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblfondomonto = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblfondodescripcion = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblfondonombre = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblcontornoboton = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblnombrevista = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _rd1ano = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _rd1mes = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _rd1semana = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _rd2semanas = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _rd3semanas = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlnavinferior = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlperiodos = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlselector = null;
public pullup.wallet.ascolorslider _cpbarracolor = null;
public pullup.wallet.main _main = null;
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
public pullup.wallet.suscripciones _suscripciones = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="registrarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=16711680;
 //BA.debugLineNum = 16711680;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=16711681;
 //BA.debugLineNum = 16711681;BA.debugLine="Activity.LoadLayout(\"LFormSuscripcion\")";
mostCurrent._activity.LoadLayout("LFormSuscripcion",mostCurrent.activityBA);
RDebugUtils.currentLine=16711682;
 //BA.debugLineNum = 16711682;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
_alturadispositivo = mostCurrent._main._alturadispositivo /*int*/ ;
RDebugUtils.currentLine=16711683;
 //BA.debugLineNum = 16711683;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
_anchodispositivo = mostCurrent._main._anchodispositivo /*int*/ ;
RDebugUtils.currentLine=16711684;
 //BA.debugLineNum = 16711684;BA.debugLine="sql = Starter.sql";
_sql = mostCurrent._starter._sql /*anywheresoftware.b4a.sql.SQL*/ ;
RDebugUtils.currentLine=16711685;
 //BA.debugLineNum = 16711685;BA.debugLine="aparicionMsgBox1 = False";
_aparicionmsgbox1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=16711686;
 //BA.debugLineNum = 16711686;BA.debugLine="aparicionMsgBox2 = False";
_aparicionmsgbox2 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=16711687;
 //BA.debugLineNum = 16711687;BA.debugLine="aparicionMsgBox3 = False";
_aparicionmsgbox3 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=16711688;
 //BA.debugLineNum = 16711688;BA.debugLine="diasPeriodo = 7";
_diasperiodo = (int) (7);
RDebugUtils.currentLine=16711689;
 //BA.debugLineNum = 16711689;BA.debugLine="colorCaja = 0";
_colorcaja = (int) (0);
RDebugUtils.currentLine=16711692;
 //BA.debugLineNum = 16711692;BA.debugLine="lblNombreVista.TextSize = 20";
mostCurrent._lblnombrevista.setTextSize((float) (20));
RDebugUtils.currentLine=16711693;
 //BA.debugLineNum = 16711693;BA.debugLine="lblNombreVista.TextColor = Colors.Black";
mostCurrent._lblnombrevista.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=16711694;
 //BA.debugLineNum = 16711694;BA.debugLine="lblNombreVista.Height = 30dip";
mostCurrent._lblnombrevista.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=16711695;
 //BA.debugLineNum = 16711695;BA.debugLine="lblNombreVista.Width = anchoDispositivo * 0.9";
mostCurrent._lblnombrevista.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=16711696;
 //BA.debugLineNum = 16711696;BA.debugLine="lblNombreVista.Top = 30dip";
mostCurrent._lblnombrevista.setTop(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=16711697;
 //BA.debugLineNum = 16711697;BA.debugLine="lblNombreVista.Left = (anchoDispositivo - lblNomb";
mostCurrent._lblnombrevista.setLeft((int) ((_anchodispositivo-mostCurrent._lblnombrevista.getWidth())/(double)2));
RDebugUtils.currentLine=16711699;
 //BA.debugLineNum = 16711699;BA.debugLine="txtMonto.Width = anchoDispositivo * 0.9";
mostCurrent._txtmonto.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=16711700;
 //BA.debugLineNum = 16711700;BA.debugLine="txtMonto.Height = alturaDispositivo * 0.22";
mostCurrent._txtmonto.setHeight((int) (_alturadispositivo*0.22));
RDebugUtils.currentLine=16711701;
 //BA.debugLineNum = 16711701;BA.debugLine="txtMonto.Top = lblNombreVista.Top * 2 + lblNombre";
mostCurrent._txtmonto.setTop((int) (mostCurrent._lblnombrevista.getTop()*2+mostCurrent._lblnombrevista.getHeight()));
RDebugUtils.currentLine=16711702;
 //BA.debugLineNum = 16711702;BA.debugLine="txtMonto.Left = (anchoDispositivo - txtMonto.Widt";
mostCurrent._txtmonto.setLeft((int) ((_anchodispositivo-mostCurrent._txtmonto.getWidth())/(double)2));
RDebugUtils.currentLine=16711703;
 //BA.debugLineNum = 16711703;BA.debugLine="lblFondoMonto.Width = txtMonto.Width";
mostCurrent._lblfondomonto.setWidth(mostCurrent._txtmonto.getWidth());
RDebugUtils.currentLine=16711704;
 //BA.debugLineNum = 16711704;BA.debugLine="lblFondoMonto.Height = txtMonto.Height";
mostCurrent._lblfondomonto.setHeight(mostCurrent._txtmonto.getHeight());
RDebugUtils.currentLine=16711705;
 //BA.debugLineNum = 16711705;BA.debugLine="lblFondoMonto.Top = txtMonto.Top";
mostCurrent._lblfondomonto.setTop(mostCurrent._txtmonto.getTop());
RDebugUtils.currentLine=16711706;
 //BA.debugLineNum = 16711706;BA.debugLine="lblFondoMonto.Left = txtMonto.Left";
mostCurrent._lblfondomonto.setLeft(mostCurrent._txtmonto.getLeft());
RDebugUtils.currentLine=16711708;
 //BA.debugLineNum = 16711708;BA.debugLine="txtNombre.Width = anchoDispositivo * 0.9";
mostCurrent._txtnombre.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=16711709;
 //BA.debugLineNum = 16711709;BA.debugLine="txtNombre.Height = alturaDispositivo * 0.07";
mostCurrent._txtnombre.setHeight((int) (_alturadispositivo*0.07));
RDebugUtils.currentLine=16711710;
 //BA.debugLineNum = 16711710;BA.debugLine="txtNombre.Top = txtMonto.Top + txtMonto.Height +";
mostCurrent._txtnombre.setTop((int) (mostCurrent._txtmonto.getTop()+mostCurrent._txtmonto.getHeight()+mostCurrent._lblnombrevista.getTop()/(double)2));
RDebugUtils.currentLine=16711711;
 //BA.debugLineNum = 16711711;BA.debugLine="txtNombre.Left = (anchoDispositivo - txtNombre.Wi";
mostCurrent._txtnombre.setLeft((int) ((_anchodispositivo-mostCurrent._txtnombre.getWidth())/(double)2));
RDebugUtils.currentLine=16711712;
 //BA.debugLineNum = 16711712;BA.debugLine="lblFondoNombre.Width = txtMonto.Width";
mostCurrent._lblfondonombre.setWidth(mostCurrent._txtmonto.getWidth());
RDebugUtils.currentLine=16711713;
 //BA.debugLineNum = 16711713;BA.debugLine="lblFondoNombre.Height = txtNombre.Height";
mostCurrent._lblfondonombre.setHeight(mostCurrent._txtnombre.getHeight());
RDebugUtils.currentLine=16711714;
 //BA.debugLineNum = 16711714;BA.debugLine="lblFondoNombre.Top = txtNombre.Top";
mostCurrent._lblfondonombre.setTop(mostCurrent._txtnombre.getTop());
RDebugUtils.currentLine=16711715;
 //BA.debugLineNum = 16711715;BA.debugLine="lblFondoNombre.Left = txtNombre.Left";
mostCurrent._lblfondonombre.setLeft(mostCurrent._txtnombre.getLeft());
RDebugUtils.currentLine=16711717;
 //BA.debugLineNum = 16711717;BA.debugLine="txtDescripcion.Width = txtNombre.Width";
mostCurrent._txtdescripcion.setWidth(mostCurrent._txtnombre.getWidth());
RDebugUtils.currentLine=16711718;
 //BA.debugLineNum = 16711718;BA.debugLine="txtDescripcion.Height = txtNombre.Height";
mostCurrent._txtdescripcion.setHeight(mostCurrent._txtnombre.getHeight());
RDebugUtils.currentLine=16711719;
 //BA.debugLineNum = 16711719;BA.debugLine="txtDescripcion.Top = txtNombre.Top + txtNombre.He";
mostCurrent._txtdescripcion.setTop((int) (mostCurrent._txtnombre.getTop()+mostCurrent._txtnombre.getHeight()+mostCurrent._lblnombrevista.getTop()/(double)2));
RDebugUtils.currentLine=16711720;
 //BA.debugLineNum = 16711720;BA.debugLine="txtDescripcion.Left = txtNombre.Left";
mostCurrent._txtdescripcion.setLeft(mostCurrent._txtnombre.getLeft());
RDebugUtils.currentLine=16711721;
 //BA.debugLineNum = 16711721;BA.debugLine="lblFondoDescripcion.Width = txtDescripcion.Width";
mostCurrent._lblfondodescripcion.setWidth(mostCurrent._txtdescripcion.getWidth());
RDebugUtils.currentLine=16711722;
 //BA.debugLineNum = 16711722;BA.debugLine="lblFondoDescripcion.Height = txtDescripcion.Heigh";
mostCurrent._lblfondodescripcion.setHeight(mostCurrent._txtdescripcion.getHeight());
RDebugUtils.currentLine=16711723;
 //BA.debugLineNum = 16711723;BA.debugLine="lblFondoDescripcion.Top = txtDescripcion.Top";
mostCurrent._lblfondodescripcion.setTop(mostCurrent._txtdescripcion.getTop());
RDebugUtils.currentLine=16711724;
 //BA.debugLineNum = 16711724;BA.debugLine="lblFondoDescripcion.Left = txtDescripcion.Left";
mostCurrent._lblfondodescripcion.setLeft(mostCurrent._txtdescripcion.getLeft());
RDebugUtils.currentLine=16711726;
 //BA.debugLineNum = 16711726;BA.debugLine="pnlSelector.Top = txtDescripcion.Top + txtDescrip";
mostCurrent._pnlselector.setTop((int) (mostCurrent._txtdescripcion.getTop()+mostCurrent._txtdescripcion.getHeight()+mostCurrent._lblnombrevista.getTop()/(double)2));
RDebugUtils.currentLine=16711727;
 //BA.debugLineNum = 16711727;BA.debugLine="pnlSelector.Left = txtDescripcion.Left + txtDescr";
mostCurrent._pnlselector.setLeft((int) (mostCurrent._txtdescripcion.getLeft()+mostCurrent._txtdescripcion.getWidth()-mostCurrent._pnlselector.getWidth()));
RDebugUtils.currentLine=16711729;
 //BA.debugLineNum = 16711729;BA.debugLine="pnlPeriodos.Top = pnlSelector.Top";
mostCurrent._pnlperiodos.setTop(mostCurrent._pnlselector.getTop());
RDebugUtils.currentLine=16711730;
 //BA.debugLineNum = 16711730;BA.debugLine="pnlPeriodos.Left = txtDescripcion.Left";
mostCurrent._pnlperiodos.setLeft(mostCurrent._txtdescripcion.getLeft());
RDebugUtils.currentLine=16711731;
 //BA.debugLineNum = 16711731;BA.debugLine="pnlPeriodos.Width = (txtDescripcion.Width - pnlSe";
mostCurrent._pnlperiodos.setWidth((int) ((mostCurrent._txtdescripcion.getWidth()-mostCurrent._pnlselector.getWidth())*0.9));
RDebugUtils.currentLine=16711732;
 //BA.debugLineNum = 16711732;BA.debugLine="pnlPeriodos.Height = pnlSelector.Height";
mostCurrent._pnlperiodos.setHeight(mostCurrent._pnlselector.getHeight());
RDebugUtils.currentLine=16711735;
 //BA.debugLineNum = 16711735;BA.debugLine="rd1Semana.Width = pnlPeriodos.Width";
mostCurrent._rd1semana.setWidth(mostCurrent._pnlperiodos.getWidth());
RDebugUtils.currentLine=16711736;
 //BA.debugLineNum = 16711736;BA.debugLine="rd1Semana.Height = pnlPeriodos.Height * 0.18";
mostCurrent._rd1semana.setHeight((int) (mostCurrent._pnlperiodos.getHeight()*0.18));
RDebugUtils.currentLine=16711737;
 //BA.debugLineNum = 16711737;BA.debugLine="rd1Semana.Left = 0";
mostCurrent._rd1semana.setLeft((int) (0));
RDebugUtils.currentLine=16711738;
 //BA.debugLineNum = 16711738;BA.debugLine="rd1Semana.Top = 0";
mostCurrent._rd1semana.setTop((int) (0));
RDebugUtils.currentLine=16711740;
 //BA.debugLineNum = 16711740;BA.debugLine="rd2Semanas.Width = rd1Semana.Width";
mostCurrent._rd2semanas.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=16711741;
 //BA.debugLineNum = 16711741;BA.debugLine="rd2Semanas.Height = rd1Semana.Height";
mostCurrent._rd2semanas.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=16711742;
 //BA.debugLineNum = 16711742;BA.debugLine="rd2Semanas.Left = rd1Semana.Left";
mostCurrent._rd2semanas.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=16711743;
 //BA.debugLineNum = 16711743;BA.debugLine="rd2Semanas.Top = rd1Semana.Height + pnlPeriodos.H";
mostCurrent._rd2semanas.setTop((int) (mostCurrent._rd1semana.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=16711745;
 //BA.debugLineNum = 16711745;BA.debugLine="rd3Semanas.Width = rd1Semana.Width";
mostCurrent._rd3semanas.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=16711746;
 //BA.debugLineNum = 16711746;BA.debugLine="rd3Semanas.Height = rd1Semana.Height";
mostCurrent._rd3semanas.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=16711747;
 //BA.debugLineNum = 16711747;BA.debugLine="rd3Semanas.Left = rd1Semana.Left";
mostCurrent._rd3semanas.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=16711748;
 //BA.debugLineNum = 16711748;BA.debugLine="rd3Semanas.Top = rd2Semanas.Top + rd2Semanas.Heig";
mostCurrent._rd3semanas.setTop((int) (mostCurrent._rd2semanas.getTop()+mostCurrent._rd2semanas.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=16711750;
 //BA.debugLineNum = 16711750;BA.debugLine="rd1Mes.Width = rd1Semana.Width";
mostCurrent._rd1mes.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=16711751;
 //BA.debugLineNum = 16711751;BA.debugLine="rd1Mes.Height = rd1Semana.Height";
mostCurrent._rd1mes.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=16711752;
 //BA.debugLineNum = 16711752;BA.debugLine="rd1Mes.Left = rd1Semana.Left";
mostCurrent._rd1mes.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=16711753;
 //BA.debugLineNum = 16711753;BA.debugLine="rd1Mes.Top = rd3Semanas.Top + rd3Semanas.Height +";
mostCurrent._rd1mes.setTop((int) (mostCurrent._rd3semanas.getTop()+mostCurrent._rd3semanas.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=16711755;
 //BA.debugLineNum = 16711755;BA.debugLine="rd1Ano.Width = rd1Semana.Width";
mostCurrent._rd1ano.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=16711756;
 //BA.debugLineNum = 16711756;BA.debugLine="rd1Ano.Height = rd1Semana.Height";
mostCurrent._rd1ano.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=16711757;
 //BA.debugLineNum = 16711757;BA.debugLine="rd1Ano.Left = rd1Semana.Left";
mostCurrent._rd1ano.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=16711758;
 //BA.debugLineNum = 16711758;BA.debugLine="rd1Ano.Top = rd1Mes.Top + rd1Mes.Height + pnlPeri";
mostCurrent._rd1ano.setTop((int) (mostCurrent._rd1mes.getTop()+mostCurrent._rd1mes.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=16711763;
 //BA.debugLineNum = 16711763;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
mostCurrent._pnlnavinferior.setHeight((int) (_alturadispositivo*0.08));
RDebugUtils.currentLine=16711764;
 //BA.debugLineNum = 16711764;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
mostCurrent._pnlnavinferior.setWidth(_anchodispositivo);
RDebugUtils.currentLine=16711765;
 //BA.debugLineNum = 16711765;BA.debugLine="pnlNavInferior.Left = 0";
mostCurrent._pnlnavinferior.setLeft((int) (0));
RDebugUtils.currentLine=16711766;
 //BA.debugLineNum = 16711766;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
mostCurrent._pnlnavinferior.setTop((int) (_alturadispositivo-mostCurrent._pnlnavinferior.getHeight()));
RDebugUtils.currentLine=16711769;
 //BA.debugLineNum = 16711769;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
mostCurrent._btnmenu.setWidth((int) (_anchodispositivo*0.15));
RDebugUtils.currentLine=16711770;
 //BA.debugLineNum = 16711770;BA.debugLine="btnMenu.Height = btnMenu.Width";
mostCurrent._btnmenu.setHeight(mostCurrent._btnmenu.getWidth());
RDebugUtils.currentLine=16711771;
 //BA.debugLineNum = 16711771;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
mostCurrent._btnmenu.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._btnmenu.getHeight()/(double)2));
RDebugUtils.currentLine=16711772;
 //BA.debugLineNum = 16711772;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
mostCurrent._btnmenu.setLeft((int) ((_anchodispositivo-mostCurrent._btnmenu.getWidth())/(double)2));
RDebugUtils.currentLine=16711774;
 //BA.debugLineNum = 16711774;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
mostCurrent._lblcontornoboton.setWidth((int) (_anchodispositivo*0.17));
RDebugUtils.currentLine=16711775;
 //BA.debugLineNum = 16711775;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
mostCurrent._lblcontornoboton.setHeight(mostCurrent._lblcontornoboton.getWidth());
RDebugUtils.currentLine=16711776;
 //BA.debugLineNum = 16711776;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
mostCurrent._lblcontornoboton.setLeft((int) ((_anchodispositivo-mostCurrent._lblcontornoboton.getWidth())/(double)2));
RDebugUtils.currentLine=16711777;
 //BA.debugLineNum = 16711777;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
mostCurrent._lblcontornoboton.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._lblcontornoboton.getHeight()/(double)2));
RDebugUtils.currentLine=16711782;
 //BA.debugLineNum = 16711782;BA.debugLine="btnOperacionSuscripcion.Text = \"Guardar suscripci";
mostCurrent._btnoperacionsuscripcion.setText(BA.ObjectToCharSequence("Guardar suscripción"));
RDebugUtils.currentLine=16711783;
 //BA.debugLineNum = 16711783;BA.debugLine="btnOperacionSuscripcion.Top = pnlPeriodos.Top + p";
mostCurrent._btnoperacionsuscripcion.setTop((int) (mostCurrent._pnlperiodos.getTop()+mostCurrent._pnlperiodos.getHeight()+(mostCurrent._lblcontornoboton.getTop()-(mostCurrent._pnlperiodos.getTop()+mostCurrent._pnlperiodos.getHeight()+mostCurrent._btnoperacionsuscripcion.getHeight()))/(double)2));
RDebugUtils.currentLine=16711784;
 //BA.debugLineNum = 16711784;BA.debugLine="btnOperacionSuscripcion.Left = (anchoDispositivo";
mostCurrent._btnoperacionsuscripcion.setLeft((int) ((_anchodispositivo-mostCurrent._btnoperacionsuscripcion.getWidth())/(double)2));
RDebugUtils.currentLine=16711785;
 //BA.debugLineNum = 16711785;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="registrarsuscripcion";
RDebugUtils.currentLine=16842752;
 //BA.debugLineNum = 16842752;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=16842753;
 //BA.debugLineNum = 16842753;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="registrarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=16777216;
 //BA.debugLineNum = 16777216;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=16777217;
 //BA.debugLineNum = 16777217;BA.debugLine="End Sub";
return "";
}
public static pullup.wallet.main._registrosuscripcion  _asignacioncampos() throws Exception{
RDebugUtils.currentModule="registrarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "asignacioncampos", false))
	 {return ((pullup.wallet.main._registrosuscripcion) Debug.delegate(mostCurrent.activityBA, "asignacioncampos", null));}
pullup.wallet.main._registrosuscripcion _susripcion = null;
RDebugUtils.currentLine=17825792;
 //BA.debugLineNum = 17825792;BA.debugLine="Sub asignacionCampos As RegistroSuscripcion";
RDebugUtils.currentLine=17825793;
 //BA.debugLineNum = 17825793;BA.debugLine="Dim susripcion As RegistroSuscripcion";
_susripcion = new pullup.wallet.main._registrosuscripcion();
RDebugUtils.currentLine=17825795;
 //BA.debugLineNum = 17825795;BA.debugLine="susripcion.monto = txtMonto.Text";
_susripcion.monto /*int*/  = (int)(Double.parseDouble(mostCurrent._txtmonto.getText()));
RDebugUtils.currentLine=17825797;
 //BA.debugLineNum = 17825797;BA.debugLine="susripcion.nombre = txtNombre.Text";
_susripcion.nombre /*String*/  = mostCurrent._txtnombre.getText();
RDebugUtils.currentLine=17825799;
 //BA.debugLineNum = 17825799;BA.debugLine="susripcion.descripcion = (txtDescripcion.Text)";
_susripcion.descripcion /*String*/  = (mostCurrent._txtdescripcion.getText());
RDebugUtils.currentLine=17825801;
 //BA.debugLineNum = 17825801;BA.debugLine="susripcion.periodo = diasPeriodo";
_susripcion.periodo /*int*/  = _diasperiodo;
RDebugUtils.currentLine=17825803;
 //BA.debugLineNum = 17825803;BA.debugLine="susripcion.fechaPago = fechaMasPeriodo(susripcion";
_susripcion.fechaPago /*String*/  = _fechamasperiodo(_susripcion.periodo /*int*/ );
RDebugUtils.currentLine=17825805;
 //BA.debugLineNum = 17825805;BA.debugLine="susripcion.color = colorCaja";
_susripcion.color /*int*/  = _colorcaja;
RDebugUtils.currentLine=17825807;
 //BA.debugLineNum = 17825807;BA.debugLine="Return susripcion";
if (true) return _susripcion;
RDebugUtils.currentLine=17825808;
 //BA.debugLineNum = 17825808;BA.debugLine="End Sub";
return null;
}
public static String  _fechamasperiodo(int _periodo) throws Exception{
RDebugUtils.currentModule="registrarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fechamasperiodo", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fechamasperiodo", new Object[] {_periodo}));}
String _fechaactual = "";
long _fechaproxima = 0L;
RDebugUtils.currentLine=17170432;
 //BA.debugLineNum = 17170432;BA.debugLine="Sub fechaMasPeriodo(periodo As Int) As String";
RDebugUtils.currentLine=17170433;
 //BA.debugLineNum = 17170433;BA.debugLine="Dim fechaActual As String";
_fechaactual = "";
RDebugUtils.currentLine=17170434;
 //BA.debugLineNum = 17170434;BA.debugLine="Dim fechaProxima As Long";
_fechaproxima = 0L;
RDebugUtils.currentLine=17170436;
 //BA.debugLineNum = 17170436;BA.debugLine="fechaActual = DateTime.Date(obtenerFechaActual)";
_fechaactual = anywheresoftware.b4a.keywords.Common.DateTime.Date(_obtenerfechaactual());
RDebugUtils.currentLine=17170437;
 //BA.debugLineNum = 17170437;BA.debugLine="fechaProxima = DateTime.DateParse(fechaActual)";
_fechaproxima = anywheresoftware.b4a.keywords.Common.DateTime.DateParse(_fechaactual);
RDebugUtils.currentLine=17170438;
 //BA.debugLineNum = 17170438;BA.debugLine="fechaProxima = DateTime.Add(fechaProxima, 0, 0, p";
_fechaproxima = anywheresoftware.b4a.keywords.Common.DateTime.Add(_fechaproxima,(int) (0),(int) (0),_periodo);
RDebugUtils.currentLine=17170440;
 //BA.debugLineNum = 17170440;BA.debugLine="Return DateTime.Date(fechaProxima)";
if (true) return anywheresoftware.b4a.keywords.Common.DateTime.Date(_fechaproxima);
RDebugUtils.currentLine=17170441;
 //BA.debugLineNum = 17170441;BA.debugLine="End Sub";
return "";
}
public static String  _btnmenu_click() throws Exception{
RDebugUtils.currentModule="registrarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnmenu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnmenu_click", null));}
RDebugUtils.currentLine=16908288;
 //BA.debugLineNum = 16908288;BA.debugLine="Private Sub btnMenu_Click";
RDebugUtils.currentLine=16908289;
 //BA.debugLineNum = 16908289;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=16908290;
 //BA.debugLineNum = 16908290;BA.debugLine="End Sub";
return "";
}
public static String  _btnoperacionsuscripcion_click() throws Exception{
RDebugUtils.currentModule="registrarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnoperacionsuscripcion_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnoperacionsuscripcion_click", null));}
boolean _validaciones = false;
pullup.wallet.main._registrosuscripcion _suscripcionregistrar = null;
RDebugUtils.currentLine=17891328;
 //BA.debugLineNum = 17891328;BA.debugLine="Private Sub btnOperacionSuscripcion_Click";
RDebugUtils.currentLine=17891329;
 //BA.debugLineNum = 17891329;BA.debugLine="Dim validaciones As Boolean";
_validaciones = false;
RDebugUtils.currentLine=17891331;
 //BA.debugLineNum = 17891331;BA.debugLine="validaciones = validarCampos";
_validaciones = _validarcampos();
RDebugUtils.currentLine=17891332;
 //BA.debugLineNum = 17891332;BA.debugLine="If(validaciones = True) Then";
if ((_validaciones==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=17891334;
 //BA.debugLineNum = 17891334;BA.debugLine="Dim suscripcionRegistrar As RegistroSuscripcion";
_suscripcionregistrar = new pullup.wallet.main._registrosuscripcion();
RDebugUtils.currentLine=17891335;
 //BA.debugLineNum = 17891335;BA.debugLine="suscripcionRegistrar = asignacionCampos";
_suscripcionregistrar = _asignacioncampos();
RDebugUtils.currentLine=17891338;
 //BA.debugLineNum = 17891338;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO suscripciones (mo";
_sql.ExecNonQuery2("INSERT INTO suscripciones (monto, nombre, descripcion, periodo, fecha_pago, color) VALUES (?, ?, ?, ?, ?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_suscripcionregistrar.monto /*int*/ ),(Object)(_suscripcionregistrar.nombre /*String*/ ),(Object)(_suscripcionregistrar.descripcion /*String*/ ),(Object)(_suscripcionregistrar.periodo /*int*/ ),(Object)(_suscripcionregistrar.fechaPago /*String*/ ),(Object)(_suscripcionregistrar.color /*int*/ )}));
RDebugUtils.currentLine=17891342;
 //BA.debugLineNum = 17891342;BA.debugLine="cur = sql.ExecQuery(\"SELECT suma_egresos FROM eg";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT suma_egresos FROM egresos")));
RDebugUtils.currentLine=17891343;
 //BA.debugLineNum = 17891343;BA.debugLine="cur.Position = 0";
mostCurrent._cur.setPosition((int) (0));
RDebugUtils.currentLine=17891344;
 //BA.debugLineNum = 17891344;BA.debugLine="egresosActuales = cur.GetInt(\"suma_egresos\")";
_egresosactuales = mostCurrent._cur.GetInt("suma_egresos");
RDebugUtils.currentLine=17891347;
 //BA.debugLineNum = 17891347;BA.debugLine="sql.ExecNonQuery2(\"UPDATE egresos SET suma_egres";
_sql.ExecNonQuery2("UPDATE egresos SET suma_egresos = ? WHERE id_egreso = 1",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)((_egresosactuales+_suscripcionregistrar.monto /*int*/ ))}));
RDebugUtils.currentLine=17891349;
 //BA.debugLineNum = 17891349;BA.debugLine="ToastMessageShow(\"Suscripción registrada\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Suscripción registrada"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=17891351;
 //BA.debugLineNum = 17891351;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=17891353;
 //BA.debugLineNum = 17891353;BA.debugLine="StartActivity(Suscripciones)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._suscripciones.getObject()));
 }else {
RDebugUtils.currentLine=17891356;
 //BA.debugLineNum = 17891356;BA.debugLine="Msgbox2(\"Por favor, rellene todos los campos, se";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Por favor, rellene todos los campos, seleccione un periodo y color"),BA.ObjectToCharSequence("Registro incorrecto"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 };
RDebugUtils.currentLine=17891358;
 //BA.debugLineNum = 17891358;BA.debugLine="End Sub";
return "";
}
public static boolean  _validarcampos() throws Exception{
RDebugUtils.currentModule="registrarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "validarcampos", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "validarcampos", null));}
RDebugUtils.currentLine=16973824;
 //BA.debugLineNum = 16973824;BA.debugLine="Sub validarCampos As Boolean";
RDebugUtils.currentLine=16973825;
 //BA.debugLineNum = 16973825;BA.debugLine="If(txtMonto.Text.Length <> 0 And txtNombre.Text.L";
if ((mostCurrent._txtmonto.getText().length()!=0 && mostCurrent._txtnombre.getText().length()!=0 && mostCurrent._txtdescripcion.getText().length()!=0 && _colorcaja!=0 && _diasperiodo!=0)) { 
RDebugUtils.currentLine=16973826;
 //BA.debugLineNum = 16973826;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=16973828;
 //BA.debugLineNum = 16973828;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=16973830;
 //BA.debugLineNum = 16973830;BA.debugLine="End Sub";
return false;
}
public static String  _cpbarracolor_colorchanged(int _color) throws Exception{
RDebugUtils.currentModule="registrarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cpbarracolor_colorchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cpbarracolor_colorchanged", new Object[] {_color}));}
RDebugUtils.currentLine=17039360;
 //BA.debugLineNum = 17039360;BA.debugLine="Sub cpBarraColor_ColorChanged(color As Int)";
RDebugUtils.currentLine=17039361;
 //BA.debugLineNum = 17039361;BA.debugLine="lblFondoMonto.Color = color";
mostCurrent._lblfondomonto.setColor(_color);
RDebugUtils.currentLine=17039362;
 //BA.debugLineNum = 17039362;BA.debugLine="colorCaja = color";
_colorcaja = _color;
RDebugUtils.currentLine=17039363;
 //BA.debugLineNum = 17039363;BA.debugLine="End Sub";
return "";
}
public static long  _obtenerfechaactual() throws Exception{
RDebugUtils.currentModule="registrarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "obtenerfechaactual", false))
	 {return ((Long) Debug.delegate(mostCurrent.activityBA, "obtenerfechaactual", null));}
long _ahora = 0L;
RDebugUtils.currentLine=17104896;
 //BA.debugLineNum = 17104896;BA.debugLine="Sub obtenerFechaActual As Long";
RDebugUtils.currentLine=17104897;
 //BA.debugLineNum = 17104897;BA.debugLine="Dim ahora As Long";
_ahora = 0L;
RDebugUtils.currentLine=17104898;
 //BA.debugLineNum = 17104898;BA.debugLine="ahora = DateTime.Now";
_ahora = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
RDebugUtils.currentLine=17104899;
 //BA.debugLineNum = 17104899;BA.debugLine="Return ahora";
if (true) return _ahora;
RDebugUtils.currentLine=17104901;
 //BA.debugLineNum = 17104901;BA.debugLine="End Sub";
return 0L;
}
public static String  _limitarlongitudentrada(String _antiguo,String _nuevo,int _longitud,anywheresoftware.b4a.objects.B4XViewWrapper _view,String _campo) throws Exception{
RDebugUtils.currentModule="registrarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "limitarlongitudentrada", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "limitarlongitudentrada", new Object[] {_antiguo,_nuevo,_longitud,_view,_campo}));}
RDebugUtils.currentLine=17235968;
 //BA.debugLineNum = 17235968;BA.debugLine="Sub limitarLongitudEntrada(antiguo As String, nuev";
RDebugUtils.currentLine=17235969;
 //BA.debugLineNum = 17235969;BA.debugLine="If(nuevo.Length > longitud) Then";
if ((_nuevo.length()>_longitud)) { 
RDebugUtils.currentLine=17235970;
 //BA.debugLineNum = 17235970;BA.debugLine="If(campo = \"monto\") Then";
if (((_campo).equals("monto"))) { 
RDebugUtils.currentLine=17235971;
 //BA.debugLineNum = 17235971;BA.debugLine="If(aparicionMsgBox1 = False) Then";
if ((_aparicionmsgbox1==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=17235972;
 //BA.debugLineNum = 17235972;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para el monto es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=17235973;
 //BA.debugLineNum = 17235973;BA.debugLine="aparicionMsgBox1 = True";
_aparicionmsgbox1 = anywheresoftware.b4a.keywords.Common.True;
 };
 }else 
{RDebugUtils.currentLine=17235975;
 //BA.debugLineNum = 17235975;BA.debugLine="Else If(campo = \"nombre\") Then";
if (((_campo).equals("nombre"))) { 
RDebugUtils.currentLine=17235976;
 //BA.debugLineNum = 17235976;BA.debugLine="If(aparicionMsgBox2 = False) Then";
if ((_aparicionmsgbox2==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=17235977;
 //BA.debugLineNum = 17235977;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para el nombre es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=17235978;
 //BA.debugLineNum = 17235978;BA.debugLine="aparicionMsgBox2 = True";
_aparicionmsgbox2 = anywheresoftware.b4a.keywords.Common.True;
 };
 }else 
{RDebugUtils.currentLine=17235980;
 //BA.debugLineNum = 17235980;BA.debugLine="Else If(campo = \"descripcion\") Then";
if (((_campo).equals("descripcion"))) { 
RDebugUtils.currentLine=17235981;
 //BA.debugLineNum = 17235981;BA.debugLine="If(aparicionMsgBox3 = False) Then";
if ((_aparicionmsgbox3==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=17235982;
 //BA.debugLineNum = 17235982;BA.debugLine="Msgbox2(\"La longitud máxima permitida para la";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para la descripción es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=17235983;
 //BA.debugLineNum = 17235983;BA.debugLine="aparicionMsgBox3 = True";
_aparicionmsgbox3 = anywheresoftware.b4a.keywords.Common.True;
 };
 }}}
;
RDebugUtils.currentLine=17235986;
 //BA.debugLineNum = 17235986;BA.debugLine="view.Text = antiguo";
_view.setText(BA.ObjectToCharSequence(_antiguo));
 };
RDebugUtils.currentLine=17235988;
 //BA.debugLineNum = 17235988;BA.debugLine="End Sub";
return "";
}
public static String  _rd1ano_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="registrarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd1ano_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd1ano_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=17760256;
 //BA.debugLineNum = 17760256;BA.debugLine="Private Sub rd1Ano_CheckedChange(Checked As Boolea";
RDebugUtils.currentLine=17760257;
 //BA.debugLineNum = 17760257;BA.debugLine="diasPeriodo = 365";
_diasperiodo = (int) (365);
RDebugUtils.currentLine=17760258;
 //BA.debugLineNum = 17760258;BA.debugLine="End Sub";
return "";
}
public static String  _rd1mes_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="registrarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd1mes_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd1mes_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=17694720;
 //BA.debugLineNum = 17694720;BA.debugLine="Private Sub rd1Mes_CheckedChange(Checked As Boolea";
RDebugUtils.currentLine=17694721;
 //BA.debugLineNum = 17694721;BA.debugLine="diasPeriodo = 30";
_diasperiodo = (int) (30);
RDebugUtils.currentLine=17694722;
 //BA.debugLineNum = 17694722;BA.debugLine="End Sub";
return "";
}
public static String  _rd1semana_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="registrarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd1semana_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd1semana_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=17629184;
 //BA.debugLineNum = 17629184;BA.debugLine="Private Sub rd1Semana_CheckedChange(Checked As Boo";
RDebugUtils.currentLine=17629185;
 //BA.debugLineNum = 17629185;BA.debugLine="diasPeriodo = 7";
_diasperiodo = (int) (7);
RDebugUtils.currentLine=17629186;
 //BA.debugLineNum = 17629186;BA.debugLine="End Sub";
return "";
}
public static String  _rd2semanas_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="registrarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd2semanas_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd2semanas_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=17563648;
 //BA.debugLineNum = 17563648;BA.debugLine="Private Sub rd2Semanas_CheckedChange(Checked As Bo";
RDebugUtils.currentLine=17563649;
 //BA.debugLineNum = 17563649;BA.debugLine="diasPeriodo = 14";
_diasperiodo = (int) (14);
RDebugUtils.currentLine=17563650;
 //BA.debugLineNum = 17563650;BA.debugLine="End Sub";
return "";
}
public static String  _rd3semanas_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="registrarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd3semanas_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd3semanas_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=17498112;
 //BA.debugLineNum = 17498112;BA.debugLine="Private Sub rd3Semanas_CheckedChange(Checked As Bo";
RDebugUtils.currentLine=17498113;
 //BA.debugLineNum = 17498113;BA.debugLine="diasPeriodo = 21";
_diasperiodo = (int) (21);
RDebugUtils.currentLine=17498114;
 //BA.debugLineNum = 17498114;BA.debugLine="End Sub";
return "";
}
public static String  _txtdescripcion_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registrarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtdescripcion_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtdescripcion_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=17432576;
 //BA.debugLineNum = 17432576;BA.debugLine="Private Sub txtDescripcion_TextChanged (Old As Str";
RDebugUtils.currentLine=17432577;
 //BA.debugLineNum = 17432577;BA.debugLine="limitarLongitudEntrada(Old, New, 41, txtDescripci";
_limitarlongitudentrada(_old,_new,(int) (41),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtdescripcion.getObject())),"descripcion");
RDebugUtils.currentLine=17432578;
 //BA.debugLineNum = 17432578;BA.debugLine="End Sub";
return "";
}
public static String  _txtmonto_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registrarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtmonto_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtmonto_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=17301504;
 //BA.debugLineNum = 17301504;BA.debugLine="Private Sub txtMonto_TextChanged (Old As String, N";
RDebugUtils.currentLine=17301505;
 //BA.debugLineNum = 17301505;BA.debugLine="limitarLongitudEntrada(Old, New, 9, txtMonto, \"mo";
_limitarlongitudentrada(_old,_new,(int) (9),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtmonto.getObject())),"monto");
RDebugUtils.currentLine=17301506;
 //BA.debugLineNum = 17301506;BA.debugLine="End Sub";
return "";
}
public static String  _txtnombre_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registrarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtnombre_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtnombre_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=17367040;
 //BA.debugLineNum = 17367040;BA.debugLine="Private Sub txtNombre_TextChanged (Old As String,";
RDebugUtils.currentLine=17367041;
 //BA.debugLineNum = 17367041;BA.debugLine="limitarLongitudEntrada(Old, New, 16, txtNombre, \"";
_limitarlongitudentrada(_old,_new,(int) (16),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtnombre.getObject())),"nombre");
RDebugUtils.currentLine=17367042;
 //BA.debugLineNum = 17367042;BA.debugLine="End Sub";
return "";
}
}