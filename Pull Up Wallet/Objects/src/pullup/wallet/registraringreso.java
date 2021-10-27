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

public class registraringreso extends Activity implements B4AActivity{
	public static registraringreso mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "pullup.wallet", "pullup.wallet.registraringreso");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (registraringreso).");
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
		activityBA = new BA(this, layout, processBA, "pullup.wallet", "pullup.wallet.registraringreso");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "pullup.wallet.registraringreso", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (registraringreso) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (registraringreso) Resume **");
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
		return registraringreso.class;
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
            BA.LogInfo("** Activity (registraringreso) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (registraringreso) Pause event (activity is not paused). **");
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
            registraringreso mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (registraringreso) Resume **");
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
public static String _tipoingreso = "";
public static int _colorcaja = 0;
public static int _diasperiodo = 0;
public static boolean _aparicionmsgbox1 = false;
public static boolean _aparicionmsgbox2 = false;
public static boolean _aparicionmsgbox3 = false;
public anywheresoftware.b4a.objects.drawable.ColorDrawable _esquinas = null;
public anywheresoftware.b4a.objects.drawable.ColorDrawable _esquinas2 = null;
public anywheresoftware.b4a.sql.SQL.CursorWrapper _cur = null;
public static int _ingresosactuales = 0;
public anywheresoftware.b4a.objects.ButtonWrapper _btnmenu = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnoperacioningreso = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnrecurrente = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnunico = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtdescripcion = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtmonto = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtnombre = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblcontornoboton = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblfondodescripcion = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblfondomonto = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblfondonombre = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblnombrevista = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _rd1ano = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _rd1mes = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _rd1semana = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _rd2semanas = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _rd3semanas = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlperiodos = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlselector = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlnavinferior = null;
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
public pullup.wallet.registrarmetaahorro _registrarmetaahorro = null;
public pullup.wallet.registrarsuscripcion _registrarsuscripcion = null;
public pullup.wallet.suscripciones _suscripciones = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="registraringreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=13762560;
 //BA.debugLineNum = 13762560;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=13762561;
 //BA.debugLineNum = 13762561;BA.debugLine="Activity.LoadLayout(\"LFormIngreso\")";
mostCurrent._activity.LoadLayout("LFormIngreso",mostCurrent.activityBA);
RDebugUtils.currentLine=13762562;
 //BA.debugLineNum = 13762562;BA.debugLine="alturaDispositivo = GetDeviceLayoutValues.Height";
_alturadispositivo = anywheresoftware.b4a.keywords.Common.GetDeviceLayoutValues(mostCurrent.activityBA).Height;
RDebugUtils.currentLine=13762563;
 //BA.debugLineNum = 13762563;BA.debugLine="anchoDispositivo = GetDeviceLayoutValues.Width";
_anchodispositivo = anywheresoftware.b4a.keywords.Common.GetDeviceLayoutValues(mostCurrent.activityBA).Width;
RDebugUtils.currentLine=13762564;
 //BA.debugLineNum = 13762564;BA.debugLine="btnRecurrente.TextColor = Colors.White";
mostCurrent._btnrecurrente.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=13762565;
 //BA.debugLineNum = 13762565;BA.debugLine="btnUnico.TextColor = Colors.Black";
mostCurrent._btnunico.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=13762566;
 //BA.debugLineNum = 13762566;BA.debugLine="tipoIngreso = \"Recurrente\"";
mostCurrent._tipoingreso = "Recurrente";
RDebugUtils.currentLine=13762567;
 //BA.debugLineNum = 13762567;BA.debugLine="sql = Starter.sql";
_sql = mostCurrent._starter._sql /*anywheresoftware.b4a.sql.SQL*/ ;
RDebugUtils.currentLine=13762568;
 //BA.debugLineNum = 13762568;BA.debugLine="diasPeriodo = 7";
_diasperiodo = (int) (7);
RDebugUtils.currentLine=13762571;
 //BA.debugLineNum = 13762571;BA.debugLine="lblNombreVista.TextSize = 20";
mostCurrent._lblnombrevista.setTextSize((float) (20));
RDebugUtils.currentLine=13762572;
 //BA.debugLineNum = 13762572;BA.debugLine="lblNombreVista.TextColor = Colors.Black";
mostCurrent._lblnombrevista.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=13762573;
 //BA.debugLineNum = 13762573;BA.debugLine="lblNombreVista.Height = 30dip";
mostCurrent._lblnombrevista.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=13762574;
 //BA.debugLineNum = 13762574;BA.debugLine="lblNombreVista.Width = anchoDispositivo * 0.9";
mostCurrent._lblnombrevista.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=13762575;
 //BA.debugLineNum = 13762575;BA.debugLine="lblNombreVista.Top = 30dip";
mostCurrent._lblnombrevista.setTop(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=13762576;
 //BA.debugLineNum = 13762576;BA.debugLine="lblNombreVista.Left = (anchoDispositivo - lblNomb";
mostCurrent._lblnombrevista.setLeft((int) ((_anchodispositivo-mostCurrent._lblnombrevista.getWidth())/(double)2));
RDebugUtils.currentLine=13762578;
 //BA.debugLineNum = 13762578;BA.debugLine="txtMonto.Width = anchoDispositivo * 0.9";
mostCurrent._txtmonto.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=13762579;
 //BA.debugLineNum = 13762579;BA.debugLine="txtMonto.Height = alturaDispositivo * 0.22";
mostCurrent._txtmonto.setHeight((int) (_alturadispositivo*0.22));
RDebugUtils.currentLine=13762580;
 //BA.debugLineNum = 13762580;BA.debugLine="txtMonto.Top = lblNombreVista.Top * 1.5 + lblNomb";
mostCurrent._txtmonto.setTop((int) (mostCurrent._lblnombrevista.getTop()*1.5+mostCurrent._lblnombrevista.getHeight()));
RDebugUtils.currentLine=13762581;
 //BA.debugLineNum = 13762581;BA.debugLine="txtMonto.Left = (anchoDispositivo - txtMonto.Widt";
mostCurrent._txtmonto.setLeft((int) ((_anchodispositivo-mostCurrent._txtmonto.getWidth())/(double)2));
RDebugUtils.currentLine=13762582;
 //BA.debugLineNum = 13762582;BA.debugLine="lblFondoMonto.Width = txtMonto.Width";
mostCurrent._lblfondomonto.setWidth(mostCurrent._txtmonto.getWidth());
RDebugUtils.currentLine=13762583;
 //BA.debugLineNum = 13762583;BA.debugLine="lblFondoMonto.Height = txtMonto.Height";
mostCurrent._lblfondomonto.setHeight(mostCurrent._txtmonto.getHeight());
RDebugUtils.currentLine=13762584;
 //BA.debugLineNum = 13762584;BA.debugLine="lblFondoMonto.Top = txtMonto.Top";
mostCurrent._lblfondomonto.setTop(mostCurrent._txtmonto.getTop());
RDebugUtils.currentLine=13762585;
 //BA.debugLineNum = 13762585;BA.debugLine="lblFondoMonto.Left = txtMonto.Left";
mostCurrent._lblfondomonto.setLeft(mostCurrent._txtmonto.getLeft());
RDebugUtils.currentLine=13762588;
 //BA.debugLineNum = 13762588;BA.debugLine="btnRecurrente.Width = anchoDispositivo * 0.3";
mostCurrent._btnrecurrente.setWidth((int) (_anchodispositivo*0.3));
RDebugUtils.currentLine=13762589;
 //BA.debugLineNum = 13762589;BA.debugLine="btnRecurrente.Height = alturaDispositivo * 0.05";
mostCurrent._btnrecurrente.setHeight((int) (_alturadispositivo*0.05));
RDebugUtils.currentLine=13762590;
 //BA.debugLineNum = 13762590;BA.debugLine="btnRecurrente.Top = txtMonto.Top + txtMonto.Heigh";
mostCurrent._btnrecurrente.setTop((int) (mostCurrent._txtmonto.getTop()+mostCurrent._txtmonto.getHeight()+mostCurrent._lblnombrevista.getTop()/(double)2));
RDebugUtils.currentLine=13762591;
 //BA.debugLineNum = 13762591;BA.debugLine="btnRecurrente.Left = ((anchoDispositivo / 2) - bt";
mostCurrent._btnrecurrente.setLeft((int) (((_anchodispositivo/(double)2)-mostCurrent._btnrecurrente.getWidth())/(double)2));
RDebugUtils.currentLine=13762593;
 //BA.debugLineNum = 13762593;BA.debugLine="btnUnico.Width = btnRecurrente.Width";
mostCurrent._btnunico.setWidth(mostCurrent._btnrecurrente.getWidth());
RDebugUtils.currentLine=13762594;
 //BA.debugLineNum = 13762594;BA.debugLine="btnUnico.Height = btnRecurrente.Height";
mostCurrent._btnunico.setHeight(mostCurrent._btnrecurrente.getHeight());
RDebugUtils.currentLine=13762595;
 //BA.debugLineNum = 13762595;BA.debugLine="btnUnico.Top = btnRecurrente.Top";
mostCurrent._btnunico.setTop(mostCurrent._btnrecurrente.getTop());
RDebugUtils.currentLine=13762596;
 //BA.debugLineNum = 13762596;BA.debugLine="btnUnico.Left = (anchoDispositivo / 2) + btnRecur";
mostCurrent._btnunico.setLeft((int) ((_anchodispositivo/(double)2)+mostCurrent._btnrecurrente.getLeft()));
RDebugUtils.currentLine=13762598;
 //BA.debugLineNum = 13762598;BA.debugLine="txtNombre.Width = anchoDispositivo * 0.9";
mostCurrent._txtnombre.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=13762599;
 //BA.debugLineNum = 13762599;BA.debugLine="txtNombre.Height = alturaDispositivo * 0.07";
mostCurrent._txtnombre.setHeight((int) (_alturadispositivo*0.07));
RDebugUtils.currentLine=13762600;
 //BA.debugLineNum = 13762600;BA.debugLine="txtNombre.Top = btnRecurrente.Top + btnRecurrente";
mostCurrent._txtnombre.setTop((int) (mostCurrent._btnrecurrente.getTop()+mostCurrent._btnrecurrente.getHeight()+mostCurrent._lblnombrevista.getTop()/(double)2));
RDebugUtils.currentLine=13762601;
 //BA.debugLineNum = 13762601;BA.debugLine="txtNombre.Left = (anchoDispositivo - txtNombre.Wi";
mostCurrent._txtnombre.setLeft((int) ((_anchodispositivo-mostCurrent._txtnombre.getWidth())/(double)2));
RDebugUtils.currentLine=13762602;
 //BA.debugLineNum = 13762602;BA.debugLine="lblFondoNombre.Width = txtMonto.Width";
mostCurrent._lblfondonombre.setWidth(mostCurrent._txtmonto.getWidth());
RDebugUtils.currentLine=13762603;
 //BA.debugLineNum = 13762603;BA.debugLine="lblFondoNombre.Height = txtNombre.Height";
mostCurrent._lblfondonombre.setHeight(mostCurrent._txtnombre.getHeight());
RDebugUtils.currentLine=13762604;
 //BA.debugLineNum = 13762604;BA.debugLine="lblFondoNombre.Top = txtNombre.Top";
mostCurrent._lblfondonombre.setTop(mostCurrent._txtnombre.getTop());
RDebugUtils.currentLine=13762605;
 //BA.debugLineNum = 13762605;BA.debugLine="lblFondoNombre.Left = txtNombre.Left";
mostCurrent._lblfondonombre.setLeft(mostCurrent._txtnombre.getLeft());
RDebugUtils.currentLine=13762607;
 //BA.debugLineNum = 13762607;BA.debugLine="txtDescripcion.Width = txtNombre.Width";
mostCurrent._txtdescripcion.setWidth(mostCurrent._txtnombre.getWidth());
RDebugUtils.currentLine=13762608;
 //BA.debugLineNum = 13762608;BA.debugLine="txtDescripcion.Height = txtNombre.Height";
mostCurrent._txtdescripcion.setHeight(mostCurrent._txtnombre.getHeight());
RDebugUtils.currentLine=13762609;
 //BA.debugLineNum = 13762609;BA.debugLine="txtDescripcion.Top = txtNombre.Top + txtNombre.He";
mostCurrent._txtdescripcion.setTop((int) (mostCurrent._txtnombre.getTop()+mostCurrent._txtnombre.getHeight()+mostCurrent._lblnombrevista.getTop()/(double)2));
RDebugUtils.currentLine=13762610;
 //BA.debugLineNum = 13762610;BA.debugLine="txtDescripcion.Left = txtNombre.Left";
mostCurrent._txtdescripcion.setLeft(mostCurrent._txtnombre.getLeft());
RDebugUtils.currentLine=13762611;
 //BA.debugLineNum = 13762611;BA.debugLine="lblFondoDescripcion.Width = txtDescripcion.Width";
mostCurrent._lblfondodescripcion.setWidth(mostCurrent._txtdescripcion.getWidth());
RDebugUtils.currentLine=13762612;
 //BA.debugLineNum = 13762612;BA.debugLine="lblFondoDescripcion.Height = txtDescripcion.Heigh";
mostCurrent._lblfondodescripcion.setHeight(mostCurrent._txtdescripcion.getHeight());
RDebugUtils.currentLine=13762613;
 //BA.debugLineNum = 13762613;BA.debugLine="lblFondoDescripcion.Top = txtDescripcion.Top";
mostCurrent._lblfondodescripcion.setTop(mostCurrent._txtdescripcion.getTop());
RDebugUtils.currentLine=13762614;
 //BA.debugLineNum = 13762614;BA.debugLine="lblFondoDescripcion.Left = txtDescripcion.Left";
mostCurrent._lblfondodescripcion.setLeft(mostCurrent._txtdescripcion.getLeft());
RDebugUtils.currentLine=13762616;
 //BA.debugLineNum = 13762616;BA.debugLine="pnlSelector.Top = txtDescripcion.Top + txtDescrip";
mostCurrent._pnlselector.setTop((int) (mostCurrent._txtdescripcion.getTop()+mostCurrent._txtdescripcion.getHeight()+mostCurrent._lblnombrevista.getTop()/(double)2));
RDebugUtils.currentLine=13762617;
 //BA.debugLineNum = 13762617;BA.debugLine="pnlSelector.Left = txtDescripcion.Left + txtDescr";
mostCurrent._pnlselector.setLeft((int) (mostCurrent._txtdescripcion.getLeft()+mostCurrent._txtdescripcion.getWidth()-mostCurrent._pnlselector.getWidth()));
RDebugUtils.currentLine=13762619;
 //BA.debugLineNum = 13762619;BA.debugLine="pnlPeriodos.Top = pnlSelector.Top";
mostCurrent._pnlperiodos.setTop(mostCurrent._pnlselector.getTop());
RDebugUtils.currentLine=13762620;
 //BA.debugLineNum = 13762620;BA.debugLine="pnlPeriodos.Left = txtDescripcion.Left";
mostCurrent._pnlperiodos.setLeft(mostCurrent._txtdescripcion.getLeft());
RDebugUtils.currentLine=13762621;
 //BA.debugLineNum = 13762621;BA.debugLine="pnlPeriodos.Width = (txtDescripcion.Width - pnlSe";
mostCurrent._pnlperiodos.setWidth((int) ((mostCurrent._txtdescripcion.getWidth()-mostCurrent._pnlselector.getWidth())*0.9));
RDebugUtils.currentLine=13762622;
 //BA.debugLineNum = 13762622;BA.debugLine="pnlPeriodos.Height = pnlSelector.Height";
mostCurrent._pnlperiodos.setHeight(mostCurrent._pnlselector.getHeight());
RDebugUtils.currentLine=13762625;
 //BA.debugLineNum = 13762625;BA.debugLine="rd1Semana.Width = pnlPeriodos.Width";
mostCurrent._rd1semana.setWidth(mostCurrent._pnlperiodos.getWidth());
RDebugUtils.currentLine=13762626;
 //BA.debugLineNum = 13762626;BA.debugLine="rd1Semana.Height = pnlPeriodos.Height * 0.18";
mostCurrent._rd1semana.setHeight((int) (mostCurrent._pnlperiodos.getHeight()*0.18));
RDebugUtils.currentLine=13762627;
 //BA.debugLineNum = 13762627;BA.debugLine="rd1Semana.Left = 0";
mostCurrent._rd1semana.setLeft((int) (0));
RDebugUtils.currentLine=13762628;
 //BA.debugLineNum = 13762628;BA.debugLine="rd1Semana.Top = 0";
mostCurrent._rd1semana.setTop((int) (0));
RDebugUtils.currentLine=13762630;
 //BA.debugLineNum = 13762630;BA.debugLine="rd2Semanas.Width = rd1Semana.Width";
mostCurrent._rd2semanas.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=13762631;
 //BA.debugLineNum = 13762631;BA.debugLine="rd2Semanas.Height = rd1Semana.Height";
mostCurrent._rd2semanas.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=13762632;
 //BA.debugLineNum = 13762632;BA.debugLine="rd2Semanas.Left = rd1Semana.Left";
mostCurrent._rd2semanas.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=13762633;
 //BA.debugLineNum = 13762633;BA.debugLine="rd2Semanas.Top = rd1Semana.Height + pnlPeriodos.H";
mostCurrent._rd2semanas.setTop((int) (mostCurrent._rd1semana.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=13762635;
 //BA.debugLineNum = 13762635;BA.debugLine="rd3Semanas.Width = rd1Semana.Width";
mostCurrent._rd3semanas.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=13762636;
 //BA.debugLineNum = 13762636;BA.debugLine="rd3Semanas.Height = rd1Semana.Height";
mostCurrent._rd3semanas.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=13762637;
 //BA.debugLineNum = 13762637;BA.debugLine="rd3Semanas.Left = rd1Semana.Left";
mostCurrent._rd3semanas.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=13762638;
 //BA.debugLineNum = 13762638;BA.debugLine="rd3Semanas.Top = rd2Semanas.Top + rd2Semanas.Heig";
mostCurrent._rd3semanas.setTop((int) (mostCurrent._rd2semanas.getTop()+mostCurrent._rd2semanas.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=13762640;
 //BA.debugLineNum = 13762640;BA.debugLine="rd1Mes.Width = rd1Semana.Width";
mostCurrent._rd1mes.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=13762641;
 //BA.debugLineNum = 13762641;BA.debugLine="rd1Mes.Height = rd1Semana.Height";
mostCurrent._rd1mes.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=13762642;
 //BA.debugLineNum = 13762642;BA.debugLine="rd1Mes.Left = rd1Semana.Left";
mostCurrent._rd1mes.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=13762643;
 //BA.debugLineNum = 13762643;BA.debugLine="rd1Mes.Top = rd3Semanas.Top + rd3Semanas.Height +";
mostCurrent._rd1mes.setTop((int) (mostCurrent._rd3semanas.getTop()+mostCurrent._rd3semanas.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=13762645;
 //BA.debugLineNum = 13762645;BA.debugLine="rd1Ano.Width = rd1Semana.Width";
mostCurrent._rd1ano.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=13762646;
 //BA.debugLineNum = 13762646;BA.debugLine="rd1Ano.Height = rd1Semana.Height";
mostCurrent._rd1ano.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=13762647;
 //BA.debugLineNum = 13762647;BA.debugLine="rd1Ano.Left = rd1Semana.Left";
mostCurrent._rd1ano.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=13762648;
 //BA.debugLineNum = 13762648;BA.debugLine="rd1Ano.Top = rd1Mes.Top + rd1Mes.Height + pnlPeri";
mostCurrent._rd1ano.setTop((int) (mostCurrent._rd1mes.getTop()+mostCurrent._rd1mes.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=13762653;
 //BA.debugLineNum = 13762653;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
mostCurrent._pnlnavinferior.setHeight((int) (_alturadispositivo*0.08));
RDebugUtils.currentLine=13762654;
 //BA.debugLineNum = 13762654;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
mostCurrent._pnlnavinferior.setWidth(_anchodispositivo);
RDebugUtils.currentLine=13762655;
 //BA.debugLineNum = 13762655;BA.debugLine="pnlNavInferior.Left = 0";
mostCurrent._pnlnavinferior.setLeft((int) (0));
RDebugUtils.currentLine=13762656;
 //BA.debugLineNum = 13762656;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
mostCurrent._pnlnavinferior.setTop((int) (_alturadispositivo-mostCurrent._pnlnavinferior.getHeight()));
RDebugUtils.currentLine=13762659;
 //BA.debugLineNum = 13762659;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
mostCurrent._btnmenu.setWidth((int) (_anchodispositivo*0.15));
RDebugUtils.currentLine=13762660;
 //BA.debugLineNum = 13762660;BA.debugLine="btnMenu.Height = btnMenu.Width";
mostCurrent._btnmenu.setHeight(mostCurrent._btnmenu.getWidth());
RDebugUtils.currentLine=13762661;
 //BA.debugLineNum = 13762661;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
mostCurrent._btnmenu.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._btnmenu.getHeight()/(double)2));
RDebugUtils.currentLine=13762662;
 //BA.debugLineNum = 13762662;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
mostCurrent._btnmenu.setLeft((int) ((_anchodispositivo-mostCurrent._btnmenu.getWidth())/(double)2));
RDebugUtils.currentLine=13762664;
 //BA.debugLineNum = 13762664;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
mostCurrent._lblcontornoboton.setWidth((int) (_anchodispositivo*0.17));
RDebugUtils.currentLine=13762665;
 //BA.debugLineNum = 13762665;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
mostCurrent._lblcontornoboton.setHeight(mostCurrent._lblcontornoboton.getWidth());
RDebugUtils.currentLine=13762666;
 //BA.debugLineNum = 13762666;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
mostCurrent._lblcontornoboton.setLeft((int) ((_anchodispositivo-mostCurrent._lblcontornoboton.getWidth())/(double)2));
RDebugUtils.currentLine=13762667;
 //BA.debugLineNum = 13762667;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
mostCurrent._lblcontornoboton.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._lblcontornoboton.getHeight()/(double)2));
RDebugUtils.currentLine=13762672;
 //BA.debugLineNum = 13762672;BA.debugLine="btnOperacionIngreso.Text = \"Guardar ingreso\"";
mostCurrent._btnoperacioningreso.setText(BA.ObjectToCharSequence("Guardar ingreso"));
RDebugUtils.currentLine=13762673;
 //BA.debugLineNum = 13762673;BA.debugLine="btnOperacionIngreso.Top = pnlPeriodos.Top + pnlPe";
mostCurrent._btnoperacioningreso.setTop((int) (mostCurrent._pnlperiodos.getTop()+mostCurrent._pnlperiodos.getHeight()+(mostCurrent._lblcontornoboton.getTop()-(mostCurrent._pnlperiodos.getTop()+mostCurrent._pnlperiodos.getHeight()+mostCurrent._btnoperacioningreso.getHeight()))/(double)2));
RDebugUtils.currentLine=13762674;
 //BA.debugLineNum = 13762674;BA.debugLine="btnOperacionIngreso.Left = (anchoDispositivo - bt";
mostCurrent._btnoperacioningreso.setLeft((int) ((_anchodispositivo-mostCurrent._btnoperacioningreso.getWidth())/(double)2));
RDebugUtils.currentLine=13762675;
 //BA.debugLineNum = 13762675;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="registraringreso";
RDebugUtils.currentLine=13893632;
 //BA.debugLineNum = 13893632;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=13893634;
 //BA.debugLineNum = 13893634;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="registraringreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=13828096;
 //BA.debugLineNum = 13828096;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=13828098;
 //BA.debugLineNum = 13828098;BA.debugLine="End Sub";
return "";
}
public static pullup.wallet.main._registroingreso  _asignacioncampos() throws Exception{
RDebugUtils.currentModule="registraringreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "asignacioncampos", false))
	 {return ((pullup.wallet.main._registroingreso) Debug.delegate(mostCurrent.activityBA, "asignacioncampos", null));}
pullup.wallet.main._registroingreso _ingreso = null;
RDebugUtils.currentLine=15007744;
 //BA.debugLineNum = 15007744;BA.debugLine="Sub asignacionCampos As RegistroIngreso";
RDebugUtils.currentLine=15007745;
 //BA.debugLineNum = 15007745;BA.debugLine="Dim ingreso As RegistroIngreso";
_ingreso = new pullup.wallet.main._registroingreso();
RDebugUtils.currentLine=15007747;
 //BA.debugLineNum = 15007747;BA.debugLine="ingreso.monto = txtMonto.Text";
_ingreso.monto /*int*/  = (int)(Double.parseDouble(mostCurrent._txtmonto.getText()));
RDebugUtils.currentLine=15007749;
 //BA.debugLineNum = 15007749;BA.debugLine="ingreso.nombre = txtNombre.Text";
_ingreso.nombre /*String*/  = mostCurrent._txtnombre.getText();
RDebugUtils.currentLine=15007751;
 //BA.debugLineNum = 15007751;BA.debugLine="ingreso.descripcion = (txtDescripcion.Text)";
_ingreso.descripcion /*String*/  = (mostCurrent._txtdescripcion.getText());
RDebugUtils.currentLine=15007753;
 //BA.debugLineNum = 15007753;BA.debugLine="ingreso.periodo = diasPeriodo";
_ingreso.periodo /*int*/  = _diasperiodo;
RDebugUtils.currentLine=15007755;
 //BA.debugLineNum = 15007755;BA.debugLine="ingreso.fechaCobro = fechaMasPeriodo(ingreso.peri";
_ingreso.fechaCobro /*String*/  = _fechamasperiodo(_ingreso.periodo /*int*/ );
RDebugUtils.currentLine=15007757;
 //BA.debugLineNum = 15007757;BA.debugLine="ingreso.color = colorCaja";
_ingreso.color /*int*/  = _colorcaja;
RDebugUtils.currentLine=15007759;
 //BA.debugLineNum = 15007759;BA.debugLine="Return ingreso";
if (true) return _ingreso;
RDebugUtils.currentLine=15007760;
 //BA.debugLineNum = 15007760;BA.debugLine="End Sub";
return null;
}
public static String  _fechamasperiodo(int _periodo) throws Exception{
RDebugUtils.currentModule="registraringreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fechamasperiodo", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fechamasperiodo", new Object[] {_periodo}));}
String _fechaactual = "";
long _fechaproxima = 0L;
RDebugUtils.currentLine=14352384;
 //BA.debugLineNum = 14352384;BA.debugLine="Sub fechaMasPeriodo(periodo As Int) As String";
RDebugUtils.currentLine=14352385;
 //BA.debugLineNum = 14352385;BA.debugLine="Dim fechaActual As String";
_fechaactual = "";
RDebugUtils.currentLine=14352386;
 //BA.debugLineNum = 14352386;BA.debugLine="Dim fechaProxima As Long";
_fechaproxima = 0L;
RDebugUtils.currentLine=14352388;
 //BA.debugLineNum = 14352388;BA.debugLine="fechaActual = DateTime.Date(obtenerFechaActual)";
_fechaactual = anywheresoftware.b4a.keywords.Common.DateTime.Date(_obtenerfechaactual());
RDebugUtils.currentLine=14352389;
 //BA.debugLineNum = 14352389;BA.debugLine="fechaProxima = DateTime.DateParse(fechaActual)";
_fechaproxima = anywheresoftware.b4a.keywords.Common.DateTime.DateParse(_fechaactual);
RDebugUtils.currentLine=14352390;
 //BA.debugLineNum = 14352390;BA.debugLine="fechaProxima = DateTime.Add(fechaProxima, 0, 0, p";
_fechaproxima = anywheresoftware.b4a.keywords.Common.DateTime.Add(_fechaproxima,(int) (0),(int) (0),_periodo);
RDebugUtils.currentLine=14352392;
 //BA.debugLineNum = 14352392;BA.debugLine="Return DateTime.Date(fechaProxima)";
if (true) return anywheresoftware.b4a.keywords.Common.DateTime.Date(_fechaproxima);
RDebugUtils.currentLine=14352393;
 //BA.debugLineNum = 14352393;BA.debugLine="End Sub";
return "";
}
public static String  _btnmenu_click() throws Exception{
RDebugUtils.currentModule="registraringreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnmenu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnmenu_click", null));}
RDebugUtils.currentLine=13959168;
 //BA.debugLineNum = 13959168;BA.debugLine="Private Sub btnMenu_Click";
RDebugUtils.currentLine=13959169;
 //BA.debugLineNum = 13959169;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=13959170;
 //BA.debugLineNum = 13959170;BA.debugLine="End Sub";
return "";
}
public static String  _btnoperacioningreso_click() throws Exception{
RDebugUtils.currentModule="registraringreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnoperacioningreso_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnoperacioningreso_click", null));}
boolean _validaciones = false;
pullup.wallet.main._registroingreso _ingresoregistrar = null;
RDebugUtils.currentLine=15073280;
 //BA.debugLineNum = 15073280;BA.debugLine="Private Sub btnOperacionIngreso_Click";
RDebugUtils.currentLine=15073281;
 //BA.debugLineNum = 15073281;BA.debugLine="Dim cur As Cursor";
mostCurrent._cur = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=15073282;
 //BA.debugLineNum = 15073282;BA.debugLine="Dim validaciones As Boolean";
_validaciones = false;
RDebugUtils.currentLine=15073283;
 //BA.debugLineNum = 15073283;BA.debugLine="Dim ingresosActuales As Int";
_ingresosactuales = 0;
RDebugUtils.currentLine=15073285;
 //BA.debugLineNum = 15073285;BA.debugLine="validaciones = validarCampos";
_validaciones = _validarcampos();
RDebugUtils.currentLine=15073286;
 //BA.debugLineNum = 15073286;BA.debugLine="If(validaciones = True) Then";
if ((_validaciones==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=15073288;
 //BA.debugLineNum = 15073288;BA.debugLine="Dim ingresoRegistrar As RegistroIngreso";
_ingresoregistrar = new pullup.wallet.main._registroingreso();
RDebugUtils.currentLine=15073289;
 //BA.debugLineNum = 15073289;BA.debugLine="ingresoRegistrar = asignacionCampos";
_ingresoregistrar = _asignacioncampos();
RDebugUtils.currentLine=15073292;
 //BA.debugLineNum = 15073292;BA.debugLine="If(tipoIngreso = \"Recurrente\") Then";
if (((mostCurrent._tipoingreso).equals("Recurrente"))) { 
RDebugUtils.currentLine=15073293;
 //BA.debugLineNum = 15073293;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO ingresos_recurre";
_sql.ExecNonQuery2("INSERT INTO ingresos_recurrentes (monto, nombre, descripcion, periodo, fecha_cobro, color) VALUES (?, ?, ?, ?, ?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_ingresoregistrar.monto /*int*/ ),(Object)(_ingresoregistrar.nombre /*String*/ ),(Object)(_ingresoregistrar.descripcion /*String*/ ),(Object)(_ingresoregistrar.periodo /*int*/ ),(Object)(_ingresoregistrar.fechaCobro /*String*/ ),(Object)(_ingresoregistrar.color /*int*/ )}));
RDebugUtils.currentLine=15073297;
 //BA.debugLineNum = 15073297;BA.debugLine="cur = sql.ExecQuery(\"SELECT suma_ingresos FROM";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT suma_ingresos FROM ingresos")));
RDebugUtils.currentLine=15073298;
 //BA.debugLineNum = 15073298;BA.debugLine="cur.Position = 0";
mostCurrent._cur.setPosition((int) (0));
RDebugUtils.currentLine=15073299;
 //BA.debugLineNum = 15073299;BA.debugLine="ingresosActuales = cur.GetInt(\"suma_ingresos\")";
_ingresosactuales = mostCurrent._cur.GetInt("suma_ingresos");
RDebugUtils.currentLine=15073302;
 //BA.debugLineNum = 15073302;BA.debugLine="sql.ExecNonQuery2(\"UPDATE ingresos SET suma_ing";
_sql.ExecNonQuery2("UPDATE ingresos SET suma_ingresos = ? WHERE id_ingreso = 1",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)((_ingresosactuales+_ingresoregistrar.monto /*int*/ ))}));
RDebugUtils.currentLine=15073305;
 //BA.debugLineNum = 15073305;BA.debugLine="ToastMessageShow(\"Ingreso registrado\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Ingreso registrado"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=15073307;
 //BA.debugLineNum = 15073307;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=15073309;
 //BA.debugLineNum = 15073309;BA.debugLine="StartActivity(IngresosRecurrentes)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._ingresosrecurrentes.getObject()));
 }else 
{RDebugUtils.currentLine=15073311;
 //BA.debugLineNum = 15073311;BA.debugLine="Else If(tipoIngreso = \"Unico\") Then";
if (((mostCurrent._tipoingreso).equals("Unico"))) { 
RDebugUtils.currentLine=15073312;
 //BA.debugLineNum = 15073312;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO ingresos_unicos";
_sql.ExecNonQuery2("INSERT INTO ingresos_unicos (monto, nombre, descripcion, fecha_registro, color) VALUES (?, ?, ?, ?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_ingresoregistrar.monto /*int*/ ),(Object)(_ingresoregistrar.nombre /*String*/ ),(Object)(_ingresoregistrar.descripcion /*String*/ ),(Object)(_ingresoregistrar.fechaCobro /*String*/ ),(Object)(_ingresoregistrar.color /*int*/ )}));
RDebugUtils.currentLine=15073316;
 //BA.debugLineNum = 15073316;BA.debugLine="cur = sql.ExecQuery(\"SELECT suma_ingresos FROM";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT suma_ingresos FROM ingresos")));
RDebugUtils.currentLine=15073317;
 //BA.debugLineNum = 15073317;BA.debugLine="cur.Position = 0";
mostCurrent._cur.setPosition((int) (0));
RDebugUtils.currentLine=15073318;
 //BA.debugLineNum = 15073318;BA.debugLine="ingresosActuales = cur.GetInt(\"suma_ingresos\")";
_ingresosactuales = mostCurrent._cur.GetInt("suma_ingresos");
RDebugUtils.currentLine=15073320;
 //BA.debugLineNum = 15073320;BA.debugLine="sql.ExecNonQuery2(\"UPDATE ingresos SET suma_ing";
_sql.ExecNonQuery2("UPDATE ingresos SET suma_ingresos = ? WHERE id_ingreso = 1",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)((_ingresosactuales+_ingresoregistrar.monto /*int*/ ))}));
RDebugUtils.currentLine=15073322;
 //BA.debugLineNum = 15073322;BA.debugLine="ToastMessageShow(\"Ingreso registrado\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Ingreso registrado"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=15073324;
 //BA.debugLineNum = 15073324;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=15073326;
 //BA.debugLineNum = 15073326;BA.debugLine="StartActivity(IngresosUnicos)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._ingresosunicos.getObject()));
 }}
;
 }else {
RDebugUtils.currentLine=15073330;
 //BA.debugLineNum = 15073330;BA.debugLine="Msgbox2(\"Por favor, rellene todos los campos, se";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Por favor, rellene todos los campos, seleccione un periodo y color"),BA.ObjectToCharSequence("Registro incorrecto"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 };
RDebugUtils.currentLine=15073332;
 //BA.debugLineNum = 15073332;BA.debugLine="End Sub";
return "";
}
public static boolean  _validarcampos() throws Exception{
RDebugUtils.currentModule="registraringreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "validarcampos", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "validarcampos", null));}
RDebugUtils.currentLine=14155776;
 //BA.debugLineNum = 14155776;BA.debugLine="Sub validarCampos As Boolean";
RDebugUtils.currentLine=14155777;
 //BA.debugLineNum = 14155777;BA.debugLine="If(txtMonto.Text.Length <> 0 And txtNombre.Text.L";
if ((mostCurrent._txtmonto.getText().length()!=0 && mostCurrent._txtnombre.getText().length()!=0 && mostCurrent._txtdescripcion.getText().length()!=0 && _colorcaja!=0)) { 
RDebugUtils.currentLine=14155778;
 //BA.debugLineNum = 14155778;BA.debugLine="If(tipoIngreso = \"Recurrente\" And diasPeriodo <>";
if (((mostCurrent._tipoingreso).equals("Recurrente") && _diasperiodo!=0)) { 
RDebugUtils.currentLine=14155779;
 //BA.debugLineNum = 14155779;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else 
{RDebugUtils.currentLine=14155780;
 //BA.debugLineNum = 14155780;BA.debugLine="Else If(tipoIngreso = \"Unico\") Then";
if (((mostCurrent._tipoingreso).equals("Unico"))) { 
RDebugUtils.currentLine=14155781;
 //BA.debugLineNum = 14155781;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=14155783;
 //BA.debugLineNum = 14155783;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 }}
;
 }else {
RDebugUtils.currentLine=14155786;
 //BA.debugLineNum = 14155786;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=14155788;
 //BA.debugLineNum = 14155788;BA.debugLine="End Sub";
return false;
}
public static String  _btnrecurrente_click() throws Exception{
RDebugUtils.currentModule="registraringreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnrecurrente_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnrecurrente_click", null));}
RDebugUtils.currentLine=14024704;
 //BA.debugLineNum = 14024704;BA.debugLine="Private Sub btnRecurrente_Click";
RDebugUtils.currentLine=14024705;
 //BA.debugLineNum = 14024705;BA.debugLine="tipoIngreso = \"Recurrente\"";
mostCurrent._tipoingreso = "Recurrente";
RDebugUtils.currentLine=14024706;
 //BA.debugLineNum = 14024706;BA.debugLine="Log(tipoIngreso)";
anywheresoftware.b4a.keywords.Common.LogImpl("514024706",mostCurrent._tipoingreso,0);
RDebugUtils.currentLine=14024707;
 //BA.debugLineNum = 14024707;BA.debugLine="rd1Semana.Enabled = True";
mostCurrent._rd1semana.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=14024708;
 //BA.debugLineNum = 14024708;BA.debugLine="rd2Semanas.Enabled = True";
mostCurrent._rd2semanas.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=14024709;
 //BA.debugLineNum = 14024709;BA.debugLine="rd3Semanas.Enabled = True";
mostCurrent._rd3semanas.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=14024710;
 //BA.debugLineNum = 14024710;BA.debugLine="rd1Mes.Enabled = True";
mostCurrent._rd1mes.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=14024711;
 //BA.debugLineNum = 14024711;BA.debugLine="rd1Ano.Enabled = True";
mostCurrent._rd1ano.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=14024712;
 //BA.debugLineNum = 14024712;BA.debugLine="btnRecurrente.TextColor = Colors.White";
mostCurrent._btnrecurrente.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=14024713;
 //BA.debugLineNum = 14024713;BA.debugLine="btnUnico.TextColor = Colors.Black";
mostCurrent._btnunico.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=14024714;
 //BA.debugLineNum = 14024714;BA.debugLine="esquinas.Initialize(Colors.RGB(121,80,242), 20)";
mostCurrent._esquinas.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (121),(int) (80),(int) (242)),(int) (20));
RDebugUtils.currentLine=14024715;
 //BA.debugLineNum = 14024715;BA.debugLine="esquinas2.Initialize(Colors.RGB(237,237,237), 20)";
mostCurrent._esquinas2.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (237),(int) (237),(int) (237)),(int) (20));
RDebugUtils.currentLine=14024716;
 //BA.debugLineNum = 14024716;BA.debugLine="btnRecurrente.Background = esquinas";
mostCurrent._btnrecurrente.setBackground((android.graphics.drawable.Drawable)(mostCurrent._esquinas.getObject()));
RDebugUtils.currentLine=14024717;
 //BA.debugLineNum = 14024717;BA.debugLine="btnUnico.Background = esquinas2";
mostCurrent._btnunico.setBackground((android.graphics.drawable.Drawable)(mostCurrent._esquinas2.getObject()));
RDebugUtils.currentLine=14024718;
 //BA.debugLineNum = 14024718;BA.debugLine="End Sub";
return "";
}
public static String  _btnunico_click() throws Exception{
RDebugUtils.currentModule="registraringreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnunico_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnunico_click", null));}
RDebugUtils.currentLine=14090240;
 //BA.debugLineNum = 14090240;BA.debugLine="Private Sub btnUnico_Click";
RDebugUtils.currentLine=14090241;
 //BA.debugLineNum = 14090241;BA.debugLine="tipoIngreso = \"Unico\"";
mostCurrent._tipoingreso = "Unico";
RDebugUtils.currentLine=14090242;
 //BA.debugLineNum = 14090242;BA.debugLine="Log(tipoIngreso)";
anywheresoftware.b4a.keywords.Common.LogImpl("514090242",mostCurrent._tipoingreso,0);
RDebugUtils.currentLine=14090243;
 //BA.debugLineNum = 14090243;BA.debugLine="rd1Semana.Enabled = False";
mostCurrent._rd1semana.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=14090244;
 //BA.debugLineNum = 14090244;BA.debugLine="rd2Semanas.Enabled = False";
mostCurrent._rd2semanas.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=14090245;
 //BA.debugLineNum = 14090245;BA.debugLine="rd3Semanas.Enabled = False";
mostCurrent._rd3semanas.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=14090246;
 //BA.debugLineNum = 14090246;BA.debugLine="rd1Mes.Enabled = False";
mostCurrent._rd1mes.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=14090247;
 //BA.debugLineNum = 14090247;BA.debugLine="rd1Ano.Enabled = False";
mostCurrent._rd1ano.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=14090248;
 //BA.debugLineNum = 14090248;BA.debugLine="btnRecurrente.TextColor = Colors.Black";
mostCurrent._btnrecurrente.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=14090249;
 //BA.debugLineNum = 14090249;BA.debugLine="btnUnico.TextColor = Colors.White";
mostCurrent._btnunico.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=14090250;
 //BA.debugLineNum = 14090250;BA.debugLine="esquinas.Initialize(Colors.RGB(237,237,237), 20)";
mostCurrent._esquinas.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (237),(int) (237),(int) (237)),(int) (20));
RDebugUtils.currentLine=14090251;
 //BA.debugLineNum = 14090251;BA.debugLine="esquinas2.Initialize(Colors.RGB(121,80,242), 20)";
mostCurrent._esquinas2.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (121),(int) (80),(int) (242)),(int) (20));
RDebugUtils.currentLine=14090252;
 //BA.debugLineNum = 14090252;BA.debugLine="btnRecurrente.Background = esquinas";
mostCurrent._btnrecurrente.setBackground((android.graphics.drawable.Drawable)(mostCurrent._esquinas.getObject()));
RDebugUtils.currentLine=14090253;
 //BA.debugLineNum = 14090253;BA.debugLine="btnUnico.Background = esquinas2";
mostCurrent._btnunico.setBackground((android.graphics.drawable.Drawable)(mostCurrent._esquinas2.getObject()));
RDebugUtils.currentLine=14090254;
 //BA.debugLineNum = 14090254;BA.debugLine="End Sub";
return "";
}
public static String  _cpbarracolor_colorchanged(int _color) throws Exception{
RDebugUtils.currentModule="registraringreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cpbarracolor_colorchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cpbarracolor_colorchanged", new Object[] {_color}));}
RDebugUtils.currentLine=14221312;
 //BA.debugLineNum = 14221312;BA.debugLine="Private Sub cpBarraColor_ColorChanged(color As Int";
RDebugUtils.currentLine=14221313;
 //BA.debugLineNum = 14221313;BA.debugLine="lblFondoMonto.Color = color";
mostCurrent._lblfondomonto.setColor(_color);
RDebugUtils.currentLine=14221314;
 //BA.debugLineNum = 14221314;BA.debugLine="colorCaja = color";
_colorcaja = _color;
RDebugUtils.currentLine=14221315;
 //BA.debugLineNum = 14221315;BA.debugLine="End Sub";
return "";
}
public static long  _obtenerfechaactual() throws Exception{
RDebugUtils.currentModule="registraringreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "obtenerfechaactual", false))
	 {return ((Long) Debug.delegate(mostCurrent.activityBA, "obtenerfechaactual", null));}
long _ahora = 0L;
RDebugUtils.currentLine=14286848;
 //BA.debugLineNum = 14286848;BA.debugLine="Sub obtenerFechaActual As Long";
RDebugUtils.currentLine=14286849;
 //BA.debugLineNum = 14286849;BA.debugLine="Dim ahora As Long";
_ahora = 0L;
RDebugUtils.currentLine=14286850;
 //BA.debugLineNum = 14286850;BA.debugLine="ahora = DateTime.Now";
_ahora = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
RDebugUtils.currentLine=14286851;
 //BA.debugLineNum = 14286851;BA.debugLine="Return ahora";
if (true) return _ahora;
RDebugUtils.currentLine=14286853;
 //BA.debugLineNum = 14286853;BA.debugLine="End Sub";
return 0L;
}
public static String  _limitarlongitudentrada(String _antiguo,String _nuevo,int _longitud,anywheresoftware.b4a.objects.B4XViewWrapper _view,String _campo) throws Exception{
RDebugUtils.currentModule="registraringreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "limitarlongitudentrada", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "limitarlongitudentrada", new Object[] {_antiguo,_nuevo,_longitud,_view,_campo}));}
RDebugUtils.currentLine=14417920;
 //BA.debugLineNum = 14417920;BA.debugLine="Sub limitarLongitudEntrada(antiguo As String, nuev";
RDebugUtils.currentLine=14417921;
 //BA.debugLineNum = 14417921;BA.debugLine="If(nuevo.Length > longitud) Then";
if ((_nuevo.length()>_longitud)) { 
RDebugUtils.currentLine=14417922;
 //BA.debugLineNum = 14417922;BA.debugLine="If(campo = \"monto\") Then";
if (((_campo).equals("monto"))) { 
RDebugUtils.currentLine=14417923;
 //BA.debugLineNum = 14417923;BA.debugLine="If(aparicionMsgBox1 = False) Then";
if ((_aparicionmsgbox1==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=14417924;
 //BA.debugLineNum = 14417924;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para el monto es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=14417925;
 //BA.debugLineNum = 14417925;BA.debugLine="aparicionMsgBox1 = True";
_aparicionmsgbox1 = anywheresoftware.b4a.keywords.Common.True;
 };
 }else 
{RDebugUtils.currentLine=14417927;
 //BA.debugLineNum = 14417927;BA.debugLine="Else If(campo = \"nombre\") Then";
if (((_campo).equals("nombre"))) { 
RDebugUtils.currentLine=14417928;
 //BA.debugLineNum = 14417928;BA.debugLine="If(aparicionMsgBox2 = False) Then";
if ((_aparicionmsgbox2==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=14417929;
 //BA.debugLineNum = 14417929;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para el nombre es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=14417930;
 //BA.debugLineNum = 14417930;BA.debugLine="aparicionMsgBox2 = True";
_aparicionmsgbox2 = anywheresoftware.b4a.keywords.Common.True;
 };
 }else 
{RDebugUtils.currentLine=14417932;
 //BA.debugLineNum = 14417932;BA.debugLine="Else If(campo = \"descripcion\") Then";
if (((_campo).equals("descripcion"))) { 
RDebugUtils.currentLine=14417933;
 //BA.debugLineNum = 14417933;BA.debugLine="If(aparicionMsgBox3 = False) Then";
if ((_aparicionmsgbox3==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=14417934;
 //BA.debugLineNum = 14417934;BA.debugLine="Msgbox2(\"La longitud máxima permitida para la";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para la descripción es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=14417935;
 //BA.debugLineNum = 14417935;BA.debugLine="aparicionMsgBox3 = True";
_aparicionmsgbox3 = anywheresoftware.b4a.keywords.Common.True;
 };
 }}}
;
RDebugUtils.currentLine=14417938;
 //BA.debugLineNum = 14417938;BA.debugLine="view.Text = antiguo";
_view.setText(BA.ObjectToCharSequence(_antiguo));
 };
RDebugUtils.currentLine=14417940;
 //BA.debugLineNum = 14417940;BA.debugLine="End Sub";
return "";
}
public static String  _rd1ano_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="registraringreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd1ano_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd1ano_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=14942208;
 //BA.debugLineNum = 14942208;BA.debugLine="Private Sub rd1Ano_CheckedChange(Checked As Boolea";
RDebugUtils.currentLine=14942209;
 //BA.debugLineNum = 14942209;BA.debugLine="diasPeriodo = 365";
_diasperiodo = (int) (365);
RDebugUtils.currentLine=14942210;
 //BA.debugLineNum = 14942210;BA.debugLine="End Sub";
return "";
}
public static String  _rd1mes_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="registraringreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd1mes_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd1mes_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=14876672;
 //BA.debugLineNum = 14876672;BA.debugLine="Private Sub rd1Mes_CheckedChange(Checked As Boolea";
RDebugUtils.currentLine=14876673;
 //BA.debugLineNum = 14876673;BA.debugLine="diasPeriodo = 30";
_diasperiodo = (int) (30);
RDebugUtils.currentLine=14876674;
 //BA.debugLineNum = 14876674;BA.debugLine="End Sub";
return "";
}
public static String  _rd1semana_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="registraringreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd1semana_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd1semana_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=14811136;
 //BA.debugLineNum = 14811136;BA.debugLine="Private Sub rd1Semana_CheckedChange(Checked As Boo";
RDebugUtils.currentLine=14811137;
 //BA.debugLineNum = 14811137;BA.debugLine="diasPeriodo = 7";
_diasperiodo = (int) (7);
RDebugUtils.currentLine=14811138;
 //BA.debugLineNum = 14811138;BA.debugLine="End Sub";
return "";
}
public static String  _rd2semanas_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="registraringreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd2semanas_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd2semanas_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=14745600;
 //BA.debugLineNum = 14745600;BA.debugLine="Private Sub rd2Semanas_CheckedChange(Checked As Bo";
RDebugUtils.currentLine=14745601;
 //BA.debugLineNum = 14745601;BA.debugLine="diasPeriodo = 14";
_diasperiodo = (int) (14);
RDebugUtils.currentLine=14745602;
 //BA.debugLineNum = 14745602;BA.debugLine="End Sub";
return "";
}
public static String  _rd3semanas_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="registraringreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd3semanas_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd3semanas_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=14680064;
 //BA.debugLineNum = 14680064;BA.debugLine="Private Sub rd3Semanas_CheckedChange(Checked As Bo";
RDebugUtils.currentLine=14680065;
 //BA.debugLineNum = 14680065;BA.debugLine="diasPeriodo = 21";
_diasperiodo = (int) (21);
RDebugUtils.currentLine=14680066;
 //BA.debugLineNum = 14680066;BA.debugLine="End Sub";
return "";
}
public static String  _txtdescripcion_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registraringreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtdescripcion_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtdescripcion_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=14614528;
 //BA.debugLineNum = 14614528;BA.debugLine="Private Sub txtDescripcion_TextChanged (Old As Str";
RDebugUtils.currentLine=14614529;
 //BA.debugLineNum = 14614529;BA.debugLine="limitarLongitudEntrada(Old, New, 41, txtDescripci";
_limitarlongitudentrada(_old,_new,(int) (41),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtdescripcion.getObject())),"descripcion");
RDebugUtils.currentLine=14614530;
 //BA.debugLineNum = 14614530;BA.debugLine="End Sub";
return "";
}
public static String  _txtmonto_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registraringreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtmonto_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtmonto_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=14483456;
 //BA.debugLineNum = 14483456;BA.debugLine="Private Sub txtMonto_TextChanged (Old As String, N";
RDebugUtils.currentLine=14483457;
 //BA.debugLineNum = 14483457;BA.debugLine="limitarLongitudEntrada(Old, New, 9, txtMonto, \"mo";
_limitarlongitudentrada(_old,_new,(int) (9),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtmonto.getObject())),"monto");
RDebugUtils.currentLine=14483458;
 //BA.debugLineNum = 14483458;BA.debugLine="End Sub";
return "";
}
public static String  _txtnombre_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registraringreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtnombre_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtnombre_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=14548992;
 //BA.debugLineNum = 14548992;BA.debugLine="Private Sub txtNombre_TextChanged (Old As String,";
RDebugUtils.currentLine=14548993;
 //BA.debugLineNum = 14548993;BA.debugLine="limitarLongitudEntrada(Old, New, 16, txtNombre, \"";
_limitarlongitudentrada(_old,_new,(int) (16),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtnombre.getObject())),"nombre");
RDebugUtils.currentLine=14548994;
 //BA.debugLineNum = 14548994;BA.debugLine="End Sub";
return "";
}
}