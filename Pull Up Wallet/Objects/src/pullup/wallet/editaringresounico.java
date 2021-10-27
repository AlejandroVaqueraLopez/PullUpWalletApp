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

public class editaringresounico extends Activity implements B4AActivity{
	public static editaringresounico mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "pullup.wallet", "pullup.wallet.editaringresounico");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (editaringresounico).");
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
		activityBA = new BA(this, layout, processBA, "pullup.wallet", "pullup.wallet.editaringresounico");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "pullup.wallet.editaringresounico", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (editaringresounico) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (editaringresounico) Resume **");
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
		return editaringresounico.class;
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
            BA.LogInfo("** Activity (editaringresounico) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (editaringresounico) Pause event (activity is not paused). **");
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
            editaringresounico mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (editaringresounico) Resume **");
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
public static int _sumaingresosantigua = 0;
public static int _montoantiguo = 0;
public static int _montonuevo = 0;
public static int _sumaingresosactual = 0;
public anywheresoftware.b4a.objects.ButtonWrapper _btnmenu = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnoperacioningresounico = null;
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
public pullup.wallet.editargasto _editargasto = null;
public pullup.wallet.editaringresorecurrente _editaringresorecurrente = null;
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
RDebugUtils.currentModule="editaringresounico";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=5767168;
 //BA.debugLineNum = 5767168;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=5767170;
 //BA.debugLineNum = 5767170;BA.debugLine="Activity.LoadLayout(\"LEditarIngresoUnico\")";
mostCurrent._activity.LoadLayout("LEditarIngresoUnico",mostCurrent.activityBA);
RDebugUtils.currentLine=5767171;
 //BA.debugLineNum = 5767171;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
_alturadispositivo = mostCurrent._main._alturadispositivo /*int*/ ;
RDebugUtils.currentLine=5767172;
 //BA.debugLineNum = 5767172;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
_anchodispositivo = mostCurrent._main._anchodispositivo /*int*/ ;
RDebugUtils.currentLine=5767173;
 //BA.debugLineNum = 5767173;BA.debugLine="sql = Starter.sql";
_sql = mostCurrent._starter._sql /*anywheresoftware.b4a.sql.SQL*/ ;
RDebugUtils.currentLine=5767174;
 //BA.debugLineNum = 5767174;BA.debugLine="aparicionMsgBox1 = False";
_aparicionmsgbox1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=5767175;
 //BA.debugLineNum = 5767175;BA.debugLine="aparicionMsgBox2 = False";
_aparicionmsgbox2 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=5767176;
 //BA.debugLineNum = 5767176;BA.debugLine="aparicionMsgBox3 = False";
_aparicionmsgbox3 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=5767177;
 //BA.debugLineNum = 5767177;BA.debugLine="colorCaja = 0";
_colorcaja = (int) (0);
RDebugUtils.currentLine=5767180;
 //BA.debugLineNum = 5767180;BA.debugLine="lblNombreVista.TextSize = 20";
mostCurrent._lblnombrevista.setTextSize((float) (20));
RDebugUtils.currentLine=5767181;
 //BA.debugLineNum = 5767181;BA.debugLine="lblNombreVista.TextColor = Colors.Black";
mostCurrent._lblnombrevista.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=5767182;
 //BA.debugLineNum = 5767182;BA.debugLine="lblNombreVista.Height = 30dip";
mostCurrent._lblnombrevista.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=5767183;
 //BA.debugLineNum = 5767183;BA.debugLine="lblNombreVista.Width = anchoDispositivo * 0.9";
mostCurrent._lblnombrevista.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=5767184;
 //BA.debugLineNum = 5767184;BA.debugLine="lblNombreVista.Top = 30dip";
mostCurrent._lblnombrevista.setTop(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=5767185;
 //BA.debugLineNum = 5767185;BA.debugLine="lblNombreVista.Left = (anchoDispositivo - lblNomb";
mostCurrent._lblnombrevista.setLeft((int) ((_anchodispositivo-mostCurrent._lblnombrevista.getWidth())/(double)2));
RDebugUtils.currentLine=5767187;
 //BA.debugLineNum = 5767187;BA.debugLine="txtMonto.Width = anchoDispositivo * 0.9";
mostCurrent._txtmonto.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=5767188;
 //BA.debugLineNum = 5767188;BA.debugLine="txtMonto.Height = alturaDispositivo * 0.25";
mostCurrent._txtmonto.setHeight((int) (_alturadispositivo*0.25));
RDebugUtils.currentLine=5767189;
 //BA.debugLineNum = 5767189;BA.debugLine="txtMonto.Top = lblNombreVista.Top * 2 + lblNombre";
mostCurrent._txtmonto.setTop((int) (mostCurrent._lblnombrevista.getTop()*2+mostCurrent._lblnombrevista.getHeight()));
RDebugUtils.currentLine=5767190;
 //BA.debugLineNum = 5767190;BA.debugLine="txtMonto.Left = (anchoDispositivo - txtMonto.Widt";
mostCurrent._txtmonto.setLeft((int) ((_anchodispositivo-mostCurrent._txtmonto.getWidth())/(double)2));
RDebugUtils.currentLine=5767191;
 //BA.debugLineNum = 5767191;BA.debugLine="lblFondoMonto.Width = txtMonto.Width";
mostCurrent._lblfondomonto.setWidth(mostCurrent._txtmonto.getWidth());
RDebugUtils.currentLine=5767192;
 //BA.debugLineNum = 5767192;BA.debugLine="lblFondoMonto.Height = txtMonto.Height";
mostCurrent._lblfondomonto.setHeight(mostCurrent._txtmonto.getHeight());
RDebugUtils.currentLine=5767193;
 //BA.debugLineNum = 5767193;BA.debugLine="lblFondoMonto.Top = txtMonto.Top";
mostCurrent._lblfondomonto.setTop(mostCurrent._txtmonto.getTop());
RDebugUtils.currentLine=5767194;
 //BA.debugLineNum = 5767194;BA.debugLine="lblFondoMonto.Left = txtMonto.Left";
mostCurrent._lblfondomonto.setLeft(mostCurrent._txtmonto.getLeft());
RDebugUtils.currentLine=5767196;
 //BA.debugLineNum = 5767196;BA.debugLine="txtNombre.Width = anchoDispositivo * 0.9";
mostCurrent._txtnombre.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=5767197;
 //BA.debugLineNum = 5767197;BA.debugLine="txtNombre.Height = alturaDispositivo * 0.1";
mostCurrent._txtnombre.setHeight((int) (_alturadispositivo*0.1));
RDebugUtils.currentLine=5767198;
 //BA.debugLineNum = 5767198;BA.debugLine="txtNombre.Top = txtMonto.Top + txtMonto.Height +";
mostCurrent._txtnombre.setTop((int) (mostCurrent._txtmonto.getTop()+mostCurrent._txtmonto.getHeight()+mostCurrent._lblnombrevista.getTop()));
RDebugUtils.currentLine=5767199;
 //BA.debugLineNum = 5767199;BA.debugLine="txtNombre.Left = (anchoDispositivo - txtNombre.Wi";
mostCurrent._txtnombre.setLeft((int) ((_anchodispositivo-mostCurrent._txtnombre.getWidth())/(double)2));
RDebugUtils.currentLine=5767200;
 //BA.debugLineNum = 5767200;BA.debugLine="lblFondoNombre.Width = txtMonto.Width";
mostCurrent._lblfondonombre.setWidth(mostCurrent._txtmonto.getWidth());
RDebugUtils.currentLine=5767201;
 //BA.debugLineNum = 5767201;BA.debugLine="lblFondoNombre.Height = txtNombre.Height";
mostCurrent._lblfondonombre.setHeight(mostCurrent._txtnombre.getHeight());
RDebugUtils.currentLine=5767202;
 //BA.debugLineNum = 5767202;BA.debugLine="lblFondoNombre.Top = txtNombre.Top";
mostCurrent._lblfondonombre.setTop(mostCurrent._txtnombre.getTop());
RDebugUtils.currentLine=5767203;
 //BA.debugLineNum = 5767203;BA.debugLine="lblFondoNombre.Left = txtNombre.Left";
mostCurrent._lblfondonombre.setLeft(mostCurrent._txtnombre.getLeft());
RDebugUtils.currentLine=5767205;
 //BA.debugLineNum = 5767205;BA.debugLine="pnlSelector.Top = txtNombre.Top + txtNombre.Heigh";
mostCurrent._pnlselector.setTop((int) (mostCurrent._txtnombre.getTop()+mostCurrent._txtnombre.getHeight()+mostCurrent._lblnombrevista.getTop()));
RDebugUtils.currentLine=5767206;
 //BA.debugLineNum = 5767206;BA.debugLine="pnlSelector.Left = txtNombre.Left + txtNombre.Wid";
mostCurrent._pnlselector.setLeft((int) (mostCurrent._txtnombre.getLeft()+mostCurrent._txtnombre.getWidth()-mostCurrent._pnlselector.getWidth()));
RDebugUtils.currentLine=5767208;
 //BA.debugLineNum = 5767208;BA.debugLine="txtDescripcion.Width = (txtNombre.Width - pnlSele";
mostCurrent._txtdescripcion.setWidth((int) ((mostCurrent._txtnombre.getWidth()-mostCurrent._pnlselector.getWidth())*0.9));
RDebugUtils.currentLine=5767209;
 //BA.debugLineNum = 5767209;BA.debugLine="txtDescripcion.Height = pnlSelector.Height";
mostCurrent._txtdescripcion.setHeight(mostCurrent._pnlselector.getHeight());
RDebugUtils.currentLine=5767210;
 //BA.debugLineNum = 5767210;BA.debugLine="txtDescripcion.Top = pnlSelector.Top";
mostCurrent._txtdescripcion.setTop(mostCurrent._pnlselector.getTop());
RDebugUtils.currentLine=5767211;
 //BA.debugLineNum = 5767211;BA.debugLine="txtDescripcion.Left = txtNombre.Left";
mostCurrent._txtdescripcion.setLeft(mostCurrent._txtnombre.getLeft());
RDebugUtils.currentLine=5767212;
 //BA.debugLineNum = 5767212;BA.debugLine="lblFondoDescripcion.Width = txtDescripcion.Width";
mostCurrent._lblfondodescripcion.setWidth(mostCurrent._txtdescripcion.getWidth());
RDebugUtils.currentLine=5767213;
 //BA.debugLineNum = 5767213;BA.debugLine="lblFondoDescripcion.Height = txtDescripcion.Heigh";
mostCurrent._lblfondodescripcion.setHeight(mostCurrent._txtdescripcion.getHeight());
RDebugUtils.currentLine=5767214;
 //BA.debugLineNum = 5767214;BA.debugLine="lblFondoDescripcion.Top = txtDescripcion.Top";
mostCurrent._lblfondodescripcion.setTop(mostCurrent._txtdescripcion.getTop());
RDebugUtils.currentLine=5767215;
 //BA.debugLineNum = 5767215;BA.debugLine="lblFondoDescripcion.Left = txtDescripcion.Left";
mostCurrent._lblfondodescripcion.setLeft(mostCurrent._txtdescripcion.getLeft());
RDebugUtils.currentLine=5767220;
 //BA.debugLineNum = 5767220;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
mostCurrent._pnlnavinferior.setHeight((int) (_alturadispositivo*0.08));
RDebugUtils.currentLine=5767221;
 //BA.debugLineNum = 5767221;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
mostCurrent._pnlnavinferior.setWidth(_anchodispositivo);
RDebugUtils.currentLine=5767222;
 //BA.debugLineNum = 5767222;BA.debugLine="pnlNavInferior.Left = 0";
mostCurrent._pnlnavinferior.setLeft((int) (0));
RDebugUtils.currentLine=5767223;
 //BA.debugLineNum = 5767223;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
mostCurrent._pnlnavinferior.setTop((int) (_alturadispositivo-mostCurrent._pnlnavinferior.getHeight()));
RDebugUtils.currentLine=5767226;
 //BA.debugLineNum = 5767226;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
mostCurrent._btnmenu.setWidth((int) (_anchodispositivo*0.15));
RDebugUtils.currentLine=5767227;
 //BA.debugLineNum = 5767227;BA.debugLine="btnMenu.Height = btnMenu.Width";
mostCurrent._btnmenu.setHeight(mostCurrent._btnmenu.getWidth());
RDebugUtils.currentLine=5767228;
 //BA.debugLineNum = 5767228;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
mostCurrent._btnmenu.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._btnmenu.getHeight()/(double)2));
RDebugUtils.currentLine=5767229;
 //BA.debugLineNum = 5767229;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
mostCurrent._btnmenu.setLeft((int) ((_anchodispositivo-mostCurrent._btnmenu.getWidth())/(double)2));
RDebugUtils.currentLine=5767231;
 //BA.debugLineNum = 5767231;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
mostCurrent._lblcontornoboton.setWidth((int) (_anchodispositivo*0.17));
RDebugUtils.currentLine=5767232;
 //BA.debugLineNum = 5767232;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
mostCurrent._lblcontornoboton.setHeight(mostCurrent._lblcontornoboton.getWidth());
RDebugUtils.currentLine=5767233;
 //BA.debugLineNum = 5767233;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
mostCurrent._lblcontornoboton.setLeft((int) ((_anchodispositivo-mostCurrent._lblcontornoboton.getWidth())/(double)2));
RDebugUtils.currentLine=5767234;
 //BA.debugLineNum = 5767234;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
mostCurrent._lblcontornoboton.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._lblcontornoboton.getHeight()/(double)2));
RDebugUtils.currentLine=5767239;
 //BA.debugLineNum = 5767239;BA.debugLine="btnOperacionIngresoUnico.Text = \"Editar ingreso ú";
mostCurrent._btnoperacioningresounico.setText(BA.ObjectToCharSequence("Editar ingreso único"));
RDebugUtils.currentLine=5767240;
 //BA.debugLineNum = 5767240;BA.debugLine="btnOperacionIngresoUnico.Top = txtDescripcion.Top";
mostCurrent._btnoperacioningresounico.setTop((int) (mostCurrent._txtdescripcion.getTop()+mostCurrent._txtdescripcion.getHeight()+(mostCurrent._lblcontornoboton.getTop()-(mostCurrent._txtdescripcion.getTop()+mostCurrent._txtdescripcion.getHeight()+mostCurrent._btnoperacioningresounico.getHeight()))/(double)2));
RDebugUtils.currentLine=5767241;
 //BA.debugLineNum = 5767241;BA.debugLine="btnOperacionIngresoUnico.Left = (anchoDispositivo";
mostCurrent._btnoperacioningresounico.setLeft((int) ((_anchodispositivo-mostCurrent._btnoperacioningresounico.getWidth())/(double)2));
RDebugUtils.currentLine=5767242;
 //BA.debugLineNum = 5767242;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="editaringresounico";
RDebugUtils.currentLine=5898240;
 //BA.debugLineNum = 5898240;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=5898242;
 //BA.debugLineNum = 5898242;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="editaringresounico";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=5832704;
 //BA.debugLineNum = 5832704;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=5832706;
 //BA.debugLineNum = 5832706;BA.debugLine="End Sub";
return "";
}
public static pullup.wallet.main._registroingreso  _asignacioncampos() throws Exception{
RDebugUtils.currentModule="editaringresounico";
if (Debug.shouldDelegate(mostCurrent.activityBA, "asignacioncampos", false))
	 {return ((pullup.wallet.main._registroingreso) Debug.delegate(mostCurrent.activityBA, "asignacioncampos", null));}
pullup.wallet.main._registroingreso _ingresounico = null;
RDebugUtils.currentLine=6422528;
 //BA.debugLineNum = 6422528;BA.debugLine="Sub asignacionCampos As RegistroIngreso";
RDebugUtils.currentLine=6422529;
 //BA.debugLineNum = 6422529;BA.debugLine="Dim ingresoUnico As RegistroIngreso";
_ingresounico = new pullup.wallet.main._registroingreso();
RDebugUtils.currentLine=6422531;
 //BA.debugLineNum = 6422531;BA.debugLine="ingresoUnico.monto = txtMonto.Text";
_ingresounico.monto /*int*/  = (int)(Double.parseDouble(mostCurrent._txtmonto.getText()));
RDebugUtils.currentLine=6422533;
 //BA.debugLineNum = 6422533;BA.debugLine="ingresoUnico.nombre = txtNombre.Text";
_ingresounico.nombre /*String*/  = mostCurrent._txtnombre.getText();
RDebugUtils.currentLine=6422535;
 //BA.debugLineNum = 6422535;BA.debugLine="ingresoUnico.descripcion = (txtDescripcion.Text)";
_ingresounico.descripcion /*String*/  = (mostCurrent._txtdescripcion.getText());
RDebugUtils.currentLine=6422537;
 //BA.debugLineNum = 6422537;BA.debugLine="ingresoUnico.color = colorCaja";
_ingresounico.color /*int*/  = _colorcaja;
RDebugUtils.currentLine=6422539;
 //BA.debugLineNum = 6422539;BA.debugLine="Return ingresoUnico";
if (true) return _ingresounico;
RDebugUtils.currentLine=6422540;
 //BA.debugLineNum = 6422540;BA.debugLine="End Sub";
return null;
}
public static String  _btnmenu_click() throws Exception{
RDebugUtils.currentModule="editaringresounico";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnmenu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnmenu_click", null));}
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Private Sub btnMenu_Click";
RDebugUtils.currentLine=5963777;
 //BA.debugLineNum = 5963777;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=5963778;
 //BA.debugLineNum = 5963778;BA.debugLine="End Sub";
return "";
}
public static String  _btnoperacioningresounico_click() throws Exception{
RDebugUtils.currentModule="editaringresounico";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnoperacioningresounico_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnoperacioningresounico_click", null));}
boolean _validaciones = false;
pullup.wallet.main._registroingreso _ingresounicoregistro = null;
RDebugUtils.currentLine=6488064;
 //BA.debugLineNum = 6488064;BA.debugLine="Private Sub btnOperacionIngresoUnico_Click";
RDebugUtils.currentLine=6488065;
 //BA.debugLineNum = 6488065;BA.debugLine="Dim validaciones As Boolean";
_validaciones = false;
RDebugUtils.currentLine=6488067;
 //BA.debugLineNum = 6488067;BA.debugLine="validaciones = validarCampos";
_validaciones = _validarcampos();
RDebugUtils.currentLine=6488068;
 //BA.debugLineNum = 6488068;BA.debugLine="If(validaciones = True) Then";
if ((_validaciones==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=6488070;
 //BA.debugLineNum = 6488070;BA.debugLine="Dim ingresoUnicoRegistro As RegistroIngreso";
_ingresounicoregistro = new pullup.wallet.main._registroingreso();
RDebugUtils.currentLine=6488071;
 //BA.debugLineNum = 6488071;BA.debugLine="ingresoUnicoRegistro = asignacionCampos";
_ingresounicoregistro = _asignacioncampos();
RDebugUtils.currentLine=6488074;
 //BA.debugLineNum = 6488074;BA.debugLine="cur = sql.ExecQuery2(\"SELECT monto FROM ingresos";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery2("SELECT monto FROM ingresos_unicos WHERE id_ingreso_unico = ?",new String[]{BA.NumberToString(_idregistro)+""})));
RDebugUtils.currentLine=6488075;
 //BA.debugLineNum = 6488075;BA.debugLine="cur.Position = 0";
mostCurrent._cur.setPosition((int) (0));
RDebugUtils.currentLine=6488077;
 //BA.debugLineNum = 6488077;BA.debugLine="montoAntiguo = cur.GetInt(\"monto\")";
_montoantiguo = mostCurrent._cur.GetInt("monto");
RDebugUtils.currentLine=6488078;
 //BA.debugLineNum = 6488078;BA.debugLine="montoNuevo = ingresoUnicoRegistro.monto";
_montonuevo = _ingresounicoregistro.monto /*int*/ ;
RDebugUtils.currentLine=6488081;
 //BA.debugLineNum = 6488081;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM ingresos WHER";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM ingresos WHERE id_ingreso = 1")));
RDebugUtils.currentLine=6488082;
 //BA.debugLineNum = 6488082;BA.debugLine="cur.Position = 0";
mostCurrent._cur.setPosition((int) (0));
RDebugUtils.currentLine=6488083;
 //BA.debugLineNum = 6488083;BA.debugLine="sumaIngresosAntigua = cur.GetInt(\"suma_ingresos\"";
_sumaingresosantigua = mostCurrent._cur.GetInt("suma_ingresos");
RDebugUtils.currentLine=6488086;
 //BA.debugLineNum = 6488086;BA.debugLine="sumaIngresosActual = (sumaIngresosAntigua - mont";
_sumaingresosactual = (int) ((_sumaingresosantigua-_montoantiguo)+_montonuevo);
RDebugUtils.currentLine=6488089;
 //BA.debugLineNum = 6488089;BA.debugLine="sql.ExecNonQuery2(\"UPDATE ingresos SET suma_ingr";
_sql.ExecNonQuery2("UPDATE ingresos SET suma_ingresos = ? WHERE id_ingreso = 1",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_sumaingresosactual)}));
RDebugUtils.currentLine=6488092;
 //BA.debugLineNum = 6488092;BA.debugLine="Starter.sql.ExecNonQuery2(\"UPDATE ingresos_unico";
mostCurrent._starter._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE ingresos_unicos SET monto = ?, nombre = ?, descripcion = ?, color = ?  WHERE id_ingreso_unico = '"+BA.NumberToString(_idregistro)+"'",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_ingresounicoregistro.monto /*int*/ ),(Object)(_ingresounicoregistro.nombre /*String*/ ),(Object)(_ingresounicoregistro.descripcion /*String*/ ),(Object)(_ingresounicoregistro.color /*int*/ )}));
RDebugUtils.currentLine=6488094;
 //BA.debugLineNum = 6488094;BA.debugLine="ToastMessageShow(\"Ingreso único editado\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Ingreso único editado"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6488096;
 //BA.debugLineNum = 6488096;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=6488098;
 //BA.debugLineNum = 6488098;BA.debugLine="StartActivity(IngresosUnicos)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._ingresosunicos.getObject()));
 }else {
RDebugUtils.currentLine=6488101;
 //BA.debugLineNum = 6488101;BA.debugLine="Msgbox2(\"Por favor, rellene todos los campos y s";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Por favor, rellene todos los campos y seleccione un color"),BA.ObjectToCharSequence("Registro incorrecto"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 };
RDebugUtils.currentLine=6488103;
 //BA.debugLineNum = 6488103;BA.debugLine="End Sub";
return "";
}
public static boolean  _validarcampos() throws Exception{
RDebugUtils.currentModule="editaringresounico";
if (Debug.shouldDelegate(mostCurrent.activityBA, "validarcampos", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "validarcampos", null));}
RDebugUtils.currentLine=6029312;
 //BA.debugLineNum = 6029312;BA.debugLine="Sub validarCampos As Boolean";
RDebugUtils.currentLine=6029313;
 //BA.debugLineNum = 6029313;BA.debugLine="If(txtMonto.Text.Length <> 0 And txtNombre.Text.L";
if ((mostCurrent._txtmonto.getText().length()!=0 && mostCurrent._txtnombre.getText().length()!=0 && mostCurrent._txtdescripcion.getText().length()!=0 && _colorcaja!=0)) { 
RDebugUtils.currentLine=6029314;
 //BA.debugLineNum = 6029314;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=6029316;
 //BA.debugLineNum = 6029316;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=6029318;
 //BA.debugLineNum = 6029318;BA.debugLine="End Sub";
return false;
}
public static String  _consultaaeditar(int _rowid) throws Exception{
RDebugUtils.currentModule="editaringresounico";
if (Debug.shouldDelegate(mostCurrent.activityBA, "consultaaeditar", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "consultaaeditar", new Object[] {_rowid}));}
pullup.wallet.main._registroingreso _ingresounico = null;
RDebugUtils.currentLine=6553600;
 //BA.debugLineNum = 6553600;BA.debugLine="Sub consultaAEditar(rowid As Int)";
RDebugUtils.currentLine=6553601;
 //BA.debugLineNum = 6553601;BA.debugLine="Dim ingresoUnico As RegistroIngreso";
_ingresounico = new pullup.wallet.main._registroingreso();
RDebugUtils.currentLine=6553602;
 //BA.debugLineNum = 6553602;BA.debugLine="idRegistro = rowid";
_idregistro = _rowid;
RDebugUtils.currentLine=6553604;
 //BA.debugLineNum = 6553604;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM ingresos_unico";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM ingresos_unicos WHERE id_ingreso_unico = '"+BA.NumberToString(_idregistro)+"'")));
RDebugUtils.currentLine=6553605;
 //BA.debugLineNum = 6553605;BA.debugLine="If(cur.RowCount > 0) Then";
if ((mostCurrent._cur.getRowCount()>0)) { 
RDebugUtils.currentLine=6553606;
 //BA.debugLineNum = 6553606;BA.debugLine="cur.Position = 0";
mostCurrent._cur.setPosition((int) (0));
RDebugUtils.currentLine=6553607;
 //BA.debugLineNum = 6553607;BA.debugLine="ingresoUnico.nombre = cur.GetString(\"nombre\")";
_ingresounico.nombre /*String*/  = mostCurrent._cur.GetString("nombre");
RDebugUtils.currentLine=6553608;
 //BA.debugLineNum = 6553608;BA.debugLine="ingresoUnico.monto = cur.GetInt(\"monto\")";
_ingresounico.monto /*int*/  = mostCurrent._cur.GetInt("monto");
RDebugUtils.currentLine=6553609;
 //BA.debugLineNum = 6553609;BA.debugLine="ingresoUnico.descripcion = cur.GetString(\"descri";
_ingresounico.descripcion /*String*/  = mostCurrent._cur.GetString("descripcion");
RDebugUtils.currentLine=6553610;
 //BA.debugLineNum = 6553610;BA.debugLine="ingresoUnico.color = cur.GetString(\"color\")";
_ingresounico.color /*int*/  = (int)(Double.parseDouble(mostCurrent._cur.GetString("color")));
RDebugUtils.currentLine=6553612;
 //BA.debugLineNum = 6553612;BA.debugLine="reasignarCamposAEditar(ingresoUnico)";
_reasignarcamposaeditar(_ingresounico);
 };
RDebugUtils.currentLine=6553614;
 //BA.debugLineNum = 6553614;BA.debugLine="End Sub";
return "";
}
public static String  _reasignarcamposaeditar(pullup.wallet.main._registroingreso _registro) throws Exception{
RDebugUtils.currentModule="editaringresounico";
if (Debug.shouldDelegate(mostCurrent.activityBA, "reasignarcamposaeditar", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "reasignarcamposaeditar", new Object[] {_registro}));}
RDebugUtils.currentLine=6619136;
 //BA.debugLineNum = 6619136;BA.debugLine="Sub reasignarCamposAEditar(registro As RegistroIng";
RDebugUtils.currentLine=6619137;
 //BA.debugLineNum = 6619137;BA.debugLine="txtNombre.Text = registro.nombre";
mostCurrent._txtnombre.setText(BA.ObjectToCharSequence(_registro.nombre /*String*/ ));
RDebugUtils.currentLine=6619138;
 //BA.debugLineNum = 6619138;BA.debugLine="txtMonto.Text = registro.monto";
mostCurrent._txtmonto.setText(BA.ObjectToCharSequence(_registro.monto /*int*/ ));
RDebugUtils.currentLine=6619139;
 //BA.debugLineNum = 6619139;BA.debugLine="txtDescripcion.Text = registro.descripcion";
mostCurrent._txtdescripcion.setText(BA.ObjectToCharSequence(_registro.descripcion /*String*/ ));
RDebugUtils.currentLine=6619141;
 //BA.debugLineNum = 6619141;BA.debugLine="cpBarraColor_ColorChanged(registro.color)";
_cpbarracolor_colorchanged(_registro.color /*int*/ );
RDebugUtils.currentLine=6619142;
 //BA.debugLineNum = 6619142;BA.debugLine="End Sub";
return "";
}
public static String  _cpbarracolor_colorchanged(int _color) throws Exception{
RDebugUtils.currentModule="editaringresounico";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cpbarracolor_colorchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cpbarracolor_colorchanged", new Object[] {_color}));}
RDebugUtils.currentLine=6356992;
 //BA.debugLineNum = 6356992;BA.debugLine="Sub cpBarraColor_ColorChanged(color As Int)";
RDebugUtils.currentLine=6356993;
 //BA.debugLineNum = 6356993;BA.debugLine="lblFondoMonto.Color = color";
mostCurrent._lblfondomonto.setColor(_color);
RDebugUtils.currentLine=6356994;
 //BA.debugLineNum = 6356994;BA.debugLine="colorCaja = color";
_colorcaja = _color;
RDebugUtils.currentLine=6356995;
 //BA.debugLineNum = 6356995;BA.debugLine="End Sub";
return "";
}
public static String  _limitarlongitudentrada(String _antiguo,String _nuevo,int _longitud,anywheresoftware.b4a.objects.B4XViewWrapper _view,String _campo) throws Exception{
RDebugUtils.currentModule="editaringresounico";
if (Debug.shouldDelegate(mostCurrent.activityBA, "limitarlongitudentrada", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "limitarlongitudentrada", new Object[] {_antiguo,_nuevo,_longitud,_view,_campo}));}
RDebugUtils.currentLine=6094848;
 //BA.debugLineNum = 6094848;BA.debugLine="Sub limitarLongitudEntrada(antiguo As String, nuev";
RDebugUtils.currentLine=6094849;
 //BA.debugLineNum = 6094849;BA.debugLine="If(nuevo.Length > longitud) Then";
if ((_nuevo.length()>_longitud)) { 
RDebugUtils.currentLine=6094850;
 //BA.debugLineNum = 6094850;BA.debugLine="If(campo = \"monto\") Then";
if (((_campo).equals("monto"))) { 
RDebugUtils.currentLine=6094851;
 //BA.debugLineNum = 6094851;BA.debugLine="If(aparicionMsgBox1 = False) Then";
if ((_aparicionmsgbox1==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=6094852;
 //BA.debugLineNum = 6094852;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para el monto es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=6094853;
 //BA.debugLineNum = 6094853;BA.debugLine="aparicionMsgBox1 = True";
_aparicionmsgbox1 = anywheresoftware.b4a.keywords.Common.True;
 };
 }else 
{RDebugUtils.currentLine=6094855;
 //BA.debugLineNum = 6094855;BA.debugLine="Else If(campo = \"nombre\") Then";
if (((_campo).equals("nombre"))) { 
RDebugUtils.currentLine=6094856;
 //BA.debugLineNum = 6094856;BA.debugLine="If(aparicionMsgBox2 = False) Then";
if ((_aparicionmsgbox2==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=6094857;
 //BA.debugLineNum = 6094857;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para el nombre es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=6094858;
 //BA.debugLineNum = 6094858;BA.debugLine="aparicionMsgBox2 = True";
_aparicionmsgbox2 = anywheresoftware.b4a.keywords.Common.True;
 };
 }else 
{RDebugUtils.currentLine=6094860;
 //BA.debugLineNum = 6094860;BA.debugLine="Else If(campo = \"descripcion\") Then";
if (((_campo).equals("descripcion"))) { 
RDebugUtils.currentLine=6094861;
 //BA.debugLineNum = 6094861;BA.debugLine="If(aparicionMsgBox3 = False) Then";
if ((_aparicionmsgbox3==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=6094862;
 //BA.debugLineNum = 6094862;BA.debugLine="Msgbox2(\"La longitud máxima permitida para la";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para la descripción es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=6094863;
 //BA.debugLineNum = 6094863;BA.debugLine="aparicionMsgBox3 = True";
_aparicionmsgbox3 = anywheresoftware.b4a.keywords.Common.True;
 };
 }}}
;
RDebugUtils.currentLine=6094866;
 //BA.debugLineNum = 6094866;BA.debugLine="view.Text = antiguo";
_view.setText(BA.ObjectToCharSequence(_antiguo));
 };
RDebugUtils.currentLine=6094868;
 //BA.debugLineNum = 6094868;BA.debugLine="End Sub";
return "";
}
public static String  _txtdescripcion_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="editaringresounico";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtdescripcion_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtdescripcion_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=6291456;
 //BA.debugLineNum = 6291456;BA.debugLine="Private Sub txtDescripcion_TextChanged (Old As Str";
RDebugUtils.currentLine=6291457;
 //BA.debugLineNum = 6291457;BA.debugLine="limitarLongitudEntrada(Old, New, 41, txtDescripci";
_limitarlongitudentrada(_old,_new,(int) (41),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtdescripcion.getObject())),"descripcion");
RDebugUtils.currentLine=6291458;
 //BA.debugLineNum = 6291458;BA.debugLine="End Sub";
return "";
}
public static String  _txtmonto_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="editaringresounico";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtmonto_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtmonto_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=6160384;
 //BA.debugLineNum = 6160384;BA.debugLine="Private Sub txtMonto_TextChanged (Old As String, N";
RDebugUtils.currentLine=6160385;
 //BA.debugLineNum = 6160385;BA.debugLine="limitarLongitudEntrada(Old, New, 9, txtMonto, \"mo";
_limitarlongitudentrada(_old,_new,(int) (9),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtmonto.getObject())),"monto");
RDebugUtils.currentLine=6160386;
 //BA.debugLineNum = 6160386;BA.debugLine="End Sub";
return "";
}
public static String  _txtnombre_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="editaringresounico";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtnombre_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtnombre_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=6225920;
 //BA.debugLineNum = 6225920;BA.debugLine="Private Sub txtNombre_TextChanged (Old As String,";
RDebugUtils.currentLine=6225921;
 //BA.debugLineNum = 6225921;BA.debugLine="limitarLongitudEntrada(Old, New, 16, txtNombre, \"";
_limitarlongitudentrada(_old,_new,(int) (16),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtnombre.getObject())),"nombre");
RDebugUtils.currentLine=6225922;
 //BA.debugLineNum = 6225922;BA.debugLine="End Sub";
return "";
}
}