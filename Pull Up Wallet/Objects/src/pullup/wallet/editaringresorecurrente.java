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

public class editaringresorecurrente extends Activity implements B4AActivity{
	public static editaringresorecurrente mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "pullup.wallet", "pullup.wallet.editaringresorecurrente");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (editaringresorecurrente).");
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
		activityBA = new BA(this, layout, processBA, "pullup.wallet", "pullup.wallet.editaringresorecurrente");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "pullup.wallet.editaringresorecurrente", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (editaringresorecurrente) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (editaringresorecurrente) Resume **");
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
		return editaringresorecurrente.class;
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
            BA.LogInfo("** Activity (editaringresorecurrente) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (editaringresorecurrente) Pause event (activity is not paused). **");
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
            editaringresorecurrente mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (editaringresorecurrente) Resume **");
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
public static int _idregistro = 0;
public anywheresoftware.b4a.objects.ButtonWrapper _btnmenu = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnoperacioningresorecurrente = null;
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
RDebugUtils.currentModule="editaringresorecurrente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=4390914;
 //BA.debugLineNum = 4390914;BA.debugLine="Activity.LoadLayout(\"LEditarIngresoRecurrente\")";
mostCurrent._activity.LoadLayout("LEditarIngresoRecurrente",mostCurrent.activityBA);
RDebugUtils.currentLine=4390915;
 //BA.debugLineNum = 4390915;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
_alturadispositivo = mostCurrent._main._alturadispositivo /*int*/ ;
RDebugUtils.currentLine=4390916;
 //BA.debugLineNum = 4390916;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
_anchodispositivo = mostCurrent._main._anchodispositivo /*int*/ ;
RDebugUtils.currentLine=4390917;
 //BA.debugLineNum = 4390917;BA.debugLine="sql = Starter.sql";
_sql = mostCurrent._starter._sql /*anywheresoftware.b4a.sql.SQL*/ ;
RDebugUtils.currentLine=4390918;
 //BA.debugLineNum = 4390918;BA.debugLine="aparicionMsgBox1 = False";
_aparicionmsgbox1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=4390919;
 //BA.debugLineNum = 4390919;BA.debugLine="aparicionMsgBox2 = False";
_aparicionmsgbox2 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=4390920;
 //BA.debugLineNum = 4390920;BA.debugLine="aparicionMsgBox3 = False";
_aparicionmsgbox3 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=4390923;
 //BA.debugLineNum = 4390923;BA.debugLine="lblNombreVista.TextSize = 20";
mostCurrent._lblnombrevista.setTextSize((float) (20));
RDebugUtils.currentLine=4390924;
 //BA.debugLineNum = 4390924;BA.debugLine="lblNombreVista.TextColor = Colors.Black";
mostCurrent._lblnombrevista.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=4390925;
 //BA.debugLineNum = 4390925;BA.debugLine="lblNombreVista.Height = 30dip";
mostCurrent._lblnombrevista.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=4390926;
 //BA.debugLineNum = 4390926;BA.debugLine="lblNombreVista.Width = anchoDispositivo * 0.9";
mostCurrent._lblnombrevista.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=4390927;
 //BA.debugLineNum = 4390927;BA.debugLine="lblNombreVista.Top = 30dip";
mostCurrent._lblnombrevista.setTop(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=4390928;
 //BA.debugLineNum = 4390928;BA.debugLine="lblNombreVista.Left = (anchoDispositivo - lblNomb";
mostCurrent._lblnombrevista.setLeft((int) ((_anchodispositivo-mostCurrent._lblnombrevista.getWidth())/(double)2));
RDebugUtils.currentLine=4390930;
 //BA.debugLineNum = 4390930;BA.debugLine="txtMonto.Width = anchoDispositivo * 0.9";
mostCurrent._txtmonto.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=4390931;
 //BA.debugLineNum = 4390931;BA.debugLine="txtMonto.Height = alturaDispositivo * 0.22";
mostCurrent._txtmonto.setHeight((int) (_alturadispositivo*0.22));
RDebugUtils.currentLine=4390932;
 //BA.debugLineNum = 4390932;BA.debugLine="txtMonto.Top = lblNombreVista.Top * 2 + lblNombre";
mostCurrent._txtmonto.setTop((int) (mostCurrent._lblnombrevista.getTop()*2+mostCurrent._lblnombrevista.getHeight()));
RDebugUtils.currentLine=4390933;
 //BA.debugLineNum = 4390933;BA.debugLine="txtMonto.Left = (anchoDispositivo - txtMonto.Widt";
mostCurrent._txtmonto.setLeft((int) ((_anchodispositivo-mostCurrent._txtmonto.getWidth())/(double)2));
RDebugUtils.currentLine=4390934;
 //BA.debugLineNum = 4390934;BA.debugLine="lblFondoMonto.Width = txtMonto.Width";
mostCurrent._lblfondomonto.setWidth(mostCurrent._txtmonto.getWidth());
RDebugUtils.currentLine=4390935;
 //BA.debugLineNum = 4390935;BA.debugLine="lblFondoMonto.Height = txtMonto.Height";
mostCurrent._lblfondomonto.setHeight(mostCurrent._txtmonto.getHeight());
RDebugUtils.currentLine=4390936;
 //BA.debugLineNum = 4390936;BA.debugLine="lblFondoMonto.Top = txtMonto.Top";
mostCurrent._lblfondomonto.setTop(mostCurrent._txtmonto.getTop());
RDebugUtils.currentLine=4390937;
 //BA.debugLineNum = 4390937;BA.debugLine="lblFondoMonto.Left = txtMonto.Left";
mostCurrent._lblfondomonto.setLeft(mostCurrent._txtmonto.getLeft());
RDebugUtils.currentLine=4390939;
 //BA.debugLineNum = 4390939;BA.debugLine="txtNombre.Width = anchoDispositivo * 0.9";
mostCurrent._txtnombre.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=4390940;
 //BA.debugLineNum = 4390940;BA.debugLine="txtNombre.Height = alturaDispositivo * 0.07";
mostCurrent._txtnombre.setHeight((int) (_alturadispositivo*0.07));
RDebugUtils.currentLine=4390941;
 //BA.debugLineNum = 4390941;BA.debugLine="txtNombre.Top = txtMonto.Top + txtMonto.Height +";
mostCurrent._txtnombre.setTop((int) (mostCurrent._txtmonto.getTop()+mostCurrent._txtmonto.getHeight()+mostCurrent._lblnombrevista.getTop()/(double)2));
RDebugUtils.currentLine=4390942;
 //BA.debugLineNum = 4390942;BA.debugLine="txtNombre.Left = (anchoDispositivo - txtNombre.Wi";
mostCurrent._txtnombre.setLeft((int) ((_anchodispositivo-mostCurrent._txtnombre.getWidth())/(double)2));
RDebugUtils.currentLine=4390943;
 //BA.debugLineNum = 4390943;BA.debugLine="lblFondoNombre.Width = txtMonto.Width";
mostCurrent._lblfondonombre.setWidth(mostCurrent._txtmonto.getWidth());
RDebugUtils.currentLine=4390944;
 //BA.debugLineNum = 4390944;BA.debugLine="lblFondoNombre.Height = txtNombre.Height";
mostCurrent._lblfondonombre.setHeight(mostCurrent._txtnombre.getHeight());
RDebugUtils.currentLine=4390945;
 //BA.debugLineNum = 4390945;BA.debugLine="lblFondoNombre.Top = txtNombre.Top";
mostCurrent._lblfondonombre.setTop(mostCurrent._txtnombre.getTop());
RDebugUtils.currentLine=4390946;
 //BA.debugLineNum = 4390946;BA.debugLine="lblFondoNombre.Left = txtNombre.Left";
mostCurrent._lblfondonombre.setLeft(mostCurrent._txtnombre.getLeft());
RDebugUtils.currentLine=4390948;
 //BA.debugLineNum = 4390948;BA.debugLine="txtDescripcion.Width = txtNombre.Width";
mostCurrent._txtdescripcion.setWidth(mostCurrent._txtnombre.getWidth());
RDebugUtils.currentLine=4390949;
 //BA.debugLineNum = 4390949;BA.debugLine="txtDescripcion.Height = txtNombre.Height";
mostCurrent._txtdescripcion.setHeight(mostCurrent._txtnombre.getHeight());
RDebugUtils.currentLine=4390950;
 //BA.debugLineNum = 4390950;BA.debugLine="txtDescripcion.Top = txtNombre.Top + txtNombre.He";
mostCurrent._txtdescripcion.setTop((int) (mostCurrent._txtnombre.getTop()+mostCurrent._txtnombre.getHeight()+mostCurrent._lblnombrevista.getTop()/(double)2));
RDebugUtils.currentLine=4390951;
 //BA.debugLineNum = 4390951;BA.debugLine="txtDescripcion.Left = txtNombre.Left";
mostCurrent._txtdescripcion.setLeft(mostCurrent._txtnombre.getLeft());
RDebugUtils.currentLine=4390952;
 //BA.debugLineNum = 4390952;BA.debugLine="lblFondoDescripcion.Width = txtDescripcion.Width";
mostCurrent._lblfondodescripcion.setWidth(mostCurrent._txtdescripcion.getWidth());
RDebugUtils.currentLine=4390953;
 //BA.debugLineNum = 4390953;BA.debugLine="lblFondoDescripcion.Height = txtDescripcion.Heigh";
mostCurrent._lblfondodescripcion.setHeight(mostCurrent._txtdescripcion.getHeight());
RDebugUtils.currentLine=4390954;
 //BA.debugLineNum = 4390954;BA.debugLine="lblFondoDescripcion.Top = txtDescripcion.Top";
mostCurrent._lblfondodescripcion.setTop(mostCurrent._txtdescripcion.getTop());
RDebugUtils.currentLine=4390955;
 //BA.debugLineNum = 4390955;BA.debugLine="lblFondoDescripcion.Left = txtDescripcion.Left";
mostCurrent._lblfondodescripcion.setLeft(mostCurrent._txtdescripcion.getLeft());
RDebugUtils.currentLine=4390957;
 //BA.debugLineNum = 4390957;BA.debugLine="pnlSelector.Top = txtDescripcion.Top + txtDescrip";
mostCurrent._pnlselector.setTop((int) (mostCurrent._txtdescripcion.getTop()+mostCurrent._txtdescripcion.getHeight()+mostCurrent._lblnombrevista.getTop()/(double)2));
RDebugUtils.currentLine=4390958;
 //BA.debugLineNum = 4390958;BA.debugLine="pnlSelector.Left = txtDescripcion.Left + txtDescr";
mostCurrent._pnlselector.setLeft((int) (mostCurrent._txtdescripcion.getLeft()+mostCurrent._txtdescripcion.getWidth()-mostCurrent._pnlselector.getWidth()));
RDebugUtils.currentLine=4390960;
 //BA.debugLineNum = 4390960;BA.debugLine="pnlPeriodos.Top = pnlSelector.Top";
mostCurrent._pnlperiodos.setTop(mostCurrent._pnlselector.getTop());
RDebugUtils.currentLine=4390961;
 //BA.debugLineNum = 4390961;BA.debugLine="pnlPeriodos.Left = txtDescripcion.Left";
mostCurrent._pnlperiodos.setLeft(mostCurrent._txtdescripcion.getLeft());
RDebugUtils.currentLine=4390962;
 //BA.debugLineNum = 4390962;BA.debugLine="pnlPeriodos.Width = (txtDescripcion.Width - pnlSe";
mostCurrent._pnlperiodos.setWidth((int) ((mostCurrent._txtdescripcion.getWidth()-mostCurrent._pnlselector.getWidth())*0.9));
RDebugUtils.currentLine=4390963;
 //BA.debugLineNum = 4390963;BA.debugLine="pnlPeriodos.Height = pnlSelector.Height";
mostCurrent._pnlperiodos.setHeight(mostCurrent._pnlselector.getHeight());
RDebugUtils.currentLine=4390966;
 //BA.debugLineNum = 4390966;BA.debugLine="rd1Semana.Width = pnlPeriodos.Width";
mostCurrent._rd1semana.setWidth(mostCurrent._pnlperiodos.getWidth());
RDebugUtils.currentLine=4390967;
 //BA.debugLineNum = 4390967;BA.debugLine="rd1Semana.Height = pnlPeriodos.Height * 0.18";
mostCurrent._rd1semana.setHeight((int) (mostCurrent._pnlperiodos.getHeight()*0.18));
RDebugUtils.currentLine=4390968;
 //BA.debugLineNum = 4390968;BA.debugLine="rd1Semana.Left = 0";
mostCurrent._rd1semana.setLeft((int) (0));
RDebugUtils.currentLine=4390969;
 //BA.debugLineNum = 4390969;BA.debugLine="rd1Semana.Top = 0";
mostCurrent._rd1semana.setTop((int) (0));
RDebugUtils.currentLine=4390971;
 //BA.debugLineNum = 4390971;BA.debugLine="rd2Semanas.Width = rd1Semana.Width";
mostCurrent._rd2semanas.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=4390972;
 //BA.debugLineNum = 4390972;BA.debugLine="rd2Semanas.Height = rd1Semana.Height";
mostCurrent._rd2semanas.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=4390973;
 //BA.debugLineNum = 4390973;BA.debugLine="rd2Semanas.Left = rd1Semana.Left";
mostCurrent._rd2semanas.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=4390974;
 //BA.debugLineNum = 4390974;BA.debugLine="rd2Semanas.Top = rd1Semana.Height + pnlPeriodos.H";
mostCurrent._rd2semanas.setTop((int) (mostCurrent._rd1semana.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=4390976;
 //BA.debugLineNum = 4390976;BA.debugLine="rd3Semanas.Width = rd1Semana.Width";
mostCurrent._rd3semanas.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=4390977;
 //BA.debugLineNum = 4390977;BA.debugLine="rd3Semanas.Height = rd1Semana.Height";
mostCurrent._rd3semanas.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=4390978;
 //BA.debugLineNum = 4390978;BA.debugLine="rd3Semanas.Left = rd1Semana.Left";
mostCurrent._rd3semanas.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=4390979;
 //BA.debugLineNum = 4390979;BA.debugLine="rd3Semanas.Top = rd2Semanas.Top + rd2Semanas.Heig";
mostCurrent._rd3semanas.setTop((int) (mostCurrent._rd2semanas.getTop()+mostCurrent._rd2semanas.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=4390981;
 //BA.debugLineNum = 4390981;BA.debugLine="rd1Mes.Width = rd1Semana.Width";
mostCurrent._rd1mes.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=4390982;
 //BA.debugLineNum = 4390982;BA.debugLine="rd1Mes.Height = rd1Semana.Height";
mostCurrent._rd1mes.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=4390983;
 //BA.debugLineNum = 4390983;BA.debugLine="rd1Mes.Left = rd1Semana.Left";
mostCurrent._rd1mes.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=4390984;
 //BA.debugLineNum = 4390984;BA.debugLine="rd1Mes.Top = rd3Semanas.Top + rd3Semanas.Height +";
mostCurrent._rd1mes.setTop((int) (mostCurrent._rd3semanas.getTop()+mostCurrent._rd3semanas.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=4390986;
 //BA.debugLineNum = 4390986;BA.debugLine="rd1Ano.Width = rd1Semana.Width";
mostCurrent._rd1ano.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=4390987;
 //BA.debugLineNum = 4390987;BA.debugLine="rd1Ano.Height = rd1Semana.Height";
mostCurrent._rd1ano.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=4390988;
 //BA.debugLineNum = 4390988;BA.debugLine="rd1Ano.Left = rd1Semana.Left";
mostCurrent._rd1ano.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=4390989;
 //BA.debugLineNum = 4390989;BA.debugLine="rd1Ano.Top = rd1Mes.Top + rd1Mes.Height + pnlPeri";
mostCurrent._rd1ano.setTop((int) (mostCurrent._rd1mes.getTop()+mostCurrent._rd1mes.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=4390994;
 //BA.debugLineNum = 4390994;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
mostCurrent._pnlnavinferior.setHeight((int) (_alturadispositivo*0.08));
RDebugUtils.currentLine=4390995;
 //BA.debugLineNum = 4390995;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
mostCurrent._pnlnavinferior.setWidth(_anchodispositivo);
RDebugUtils.currentLine=4390996;
 //BA.debugLineNum = 4390996;BA.debugLine="pnlNavInferior.Left = 0";
mostCurrent._pnlnavinferior.setLeft((int) (0));
RDebugUtils.currentLine=4390997;
 //BA.debugLineNum = 4390997;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
mostCurrent._pnlnavinferior.setTop((int) (_alturadispositivo-mostCurrent._pnlnavinferior.getHeight()));
RDebugUtils.currentLine=4391000;
 //BA.debugLineNum = 4391000;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
mostCurrent._btnmenu.setWidth((int) (_anchodispositivo*0.15));
RDebugUtils.currentLine=4391001;
 //BA.debugLineNum = 4391001;BA.debugLine="btnMenu.Height = btnMenu.Width";
mostCurrent._btnmenu.setHeight(mostCurrent._btnmenu.getWidth());
RDebugUtils.currentLine=4391002;
 //BA.debugLineNum = 4391002;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
mostCurrent._btnmenu.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._btnmenu.getHeight()/(double)2));
RDebugUtils.currentLine=4391003;
 //BA.debugLineNum = 4391003;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
mostCurrent._btnmenu.setLeft((int) ((_anchodispositivo-mostCurrent._btnmenu.getWidth())/(double)2));
RDebugUtils.currentLine=4391005;
 //BA.debugLineNum = 4391005;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
mostCurrent._lblcontornoboton.setWidth((int) (_anchodispositivo*0.17));
RDebugUtils.currentLine=4391006;
 //BA.debugLineNum = 4391006;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
mostCurrent._lblcontornoboton.setHeight(mostCurrent._lblcontornoboton.getWidth());
RDebugUtils.currentLine=4391007;
 //BA.debugLineNum = 4391007;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
mostCurrent._lblcontornoboton.setLeft((int) ((_anchodispositivo-mostCurrent._lblcontornoboton.getWidth())/(double)2));
RDebugUtils.currentLine=4391008;
 //BA.debugLineNum = 4391008;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
mostCurrent._lblcontornoboton.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._lblcontornoboton.getHeight()/(double)2));
RDebugUtils.currentLine=4391013;
 //BA.debugLineNum = 4391013;BA.debugLine="btnOperacionIngresoRecurrente.Text = \"Editar ingr";
mostCurrent._btnoperacioningresorecurrente.setText(BA.ObjectToCharSequence("Editar ingreso recurrente"));
RDebugUtils.currentLine=4391014;
 //BA.debugLineNum = 4391014;BA.debugLine="btnOperacionIngresoRecurrente.Top = pnlPeriodos.T";
mostCurrent._btnoperacioningresorecurrente.setTop((int) (mostCurrent._pnlperiodos.getTop()+mostCurrent._pnlperiodos.getHeight()+(mostCurrent._lblcontornoboton.getTop()-(mostCurrent._pnlperiodos.getTop()+mostCurrent._pnlperiodos.getHeight()+mostCurrent._btnoperacioningresorecurrente.getHeight()))/(double)2));
RDebugUtils.currentLine=4391015;
 //BA.debugLineNum = 4391015;BA.debugLine="btnOperacionIngresoRecurrente.Left = (anchoDispos";
mostCurrent._btnoperacioningresorecurrente.setLeft((int) ((_anchodispositivo-mostCurrent._btnoperacioningresorecurrente.getWidth())/(double)2));
RDebugUtils.currentLine=4391016;
 //BA.debugLineNum = 4391016;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="editaringresorecurrente";
RDebugUtils.currentLine=4521984;
 //BA.debugLineNum = 4521984;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=4521985;
 //BA.debugLineNum = 4521985;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="editaringresorecurrente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=4456449;
 //BA.debugLineNum = 4456449;BA.debugLine="End Sub";
return "";
}
public static pullup.wallet.main._registroingreso  _asignacioncampos() throws Exception{
RDebugUtils.currentModule="editaringresorecurrente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "asignacioncampos", false))
	 {return ((pullup.wallet.main._registroingreso) Debug.delegate(mostCurrent.activityBA, "asignacioncampos", null));}
pullup.wallet.main._registroingreso _ingresorecurrente = null;
RDebugUtils.currentLine=5373952;
 //BA.debugLineNum = 5373952;BA.debugLine="Sub asignacionCampos As RegistroIngreso";
RDebugUtils.currentLine=5373953;
 //BA.debugLineNum = 5373953;BA.debugLine="Dim ingresoRecurrente As RegistroIngreso";
_ingresorecurrente = new pullup.wallet.main._registroingreso();
RDebugUtils.currentLine=5373955;
 //BA.debugLineNum = 5373955;BA.debugLine="ingresoRecurrente.monto = txtMonto.Text";
_ingresorecurrente.monto /*int*/  = (int)(Double.parseDouble(mostCurrent._txtmonto.getText()));
RDebugUtils.currentLine=5373957;
 //BA.debugLineNum = 5373957;BA.debugLine="ingresoRecurrente.nombre = txtNombre.Text";
_ingresorecurrente.nombre /*String*/  = mostCurrent._txtnombre.getText();
RDebugUtils.currentLine=5373959;
 //BA.debugLineNum = 5373959;BA.debugLine="ingresoRecurrente.descripcion = (txtDescripcion.T";
_ingresorecurrente.descripcion /*String*/  = (mostCurrent._txtdescripcion.getText());
RDebugUtils.currentLine=5373961;
 //BA.debugLineNum = 5373961;BA.debugLine="ingresoRecurrente.periodo = diasPeriodo";
_ingresorecurrente.periodo /*int*/  = _diasperiodo;
RDebugUtils.currentLine=5373963;
 //BA.debugLineNum = 5373963;BA.debugLine="ingresoRecurrente.color = colorCaja";
_ingresorecurrente.color /*int*/  = _colorcaja;
RDebugUtils.currentLine=5373965;
 //BA.debugLineNum = 5373965;BA.debugLine="Return ingresoRecurrente";
if (true) return _ingresorecurrente;
RDebugUtils.currentLine=5373966;
 //BA.debugLineNum = 5373966;BA.debugLine="End Sub";
return null;
}
public static String  _btnmenu_click() throws Exception{
RDebugUtils.currentModule="editaringresorecurrente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnmenu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnmenu_click", null));}
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Private Sub btnMenu_Click";
RDebugUtils.currentLine=4587521;
 //BA.debugLineNum = 4587521;BA.debugLine="Activity.Finish 'REGRESAR A MENU";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=4587522;
 //BA.debugLineNum = 4587522;BA.debugLine="End Sub";
return "";
}
public static String  _btnoperacioningresorecurrente_click() throws Exception{
RDebugUtils.currentModule="editaringresorecurrente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnoperacioningresorecurrente_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnoperacioningresorecurrente_click", null));}
boolean _validaciones = false;
pullup.wallet.main._registroingreso _ingresorecurrenteregistro = null;
RDebugUtils.currentLine=5439488;
 //BA.debugLineNum = 5439488;BA.debugLine="Private Sub btnOperacionIngresoRecurrente_Click";
RDebugUtils.currentLine=5439489;
 //BA.debugLineNum = 5439489;BA.debugLine="Dim validaciones As Boolean";
_validaciones = false;
RDebugUtils.currentLine=5439491;
 //BA.debugLineNum = 5439491;BA.debugLine="validaciones = validarCampos";
_validaciones = _validarcampos();
RDebugUtils.currentLine=5439492;
 //BA.debugLineNum = 5439492;BA.debugLine="If(validaciones = True) Then";
if ((_validaciones==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=5439494;
 //BA.debugLineNum = 5439494;BA.debugLine="Dim ingresoRecurrenteRegistro As RegistroIngreso";
_ingresorecurrenteregistro = new pullup.wallet.main._registroingreso();
RDebugUtils.currentLine=5439495;
 //BA.debugLineNum = 5439495;BA.debugLine="ingresoRecurrenteRegistro = asignacionCampos";
_ingresorecurrenteregistro = _asignacioncampos();
RDebugUtils.currentLine=5439498;
 //BA.debugLineNum = 5439498;BA.debugLine="sql.ExecNonQuery2(\"UPDATE ingresos_recurrentes S";
_sql.ExecNonQuery2("UPDATE ingresos_recurrentes SET monto = ?, nombre = ?, descripcion = ?, periodo = ?, color = ? WHERE id_ingreso_recurrente = '"+BA.NumberToString(_idregistro)+"'",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_ingresorecurrenteregistro.monto /*int*/ ),(Object)(_ingresorecurrenteregistro.nombre /*String*/ ),(Object)(_ingresorecurrenteregistro.descripcion /*String*/ ),(Object)(_ingresorecurrenteregistro.periodo /*int*/ ),(Object)(_ingresorecurrenteregistro.color /*int*/ )}));
RDebugUtils.currentLine=5439500;
 //BA.debugLineNum = 5439500;BA.debugLine="ToastMessageShow(\"Ingreso recurrente editado\",Tr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Ingreso recurrente editado"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5439502;
 //BA.debugLineNum = 5439502;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=5439504;
 //BA.debugLineNum = 5439504;BA.debugLine="StartActivity(IngresosRecurrentes)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._ingresosrecurrentes.getObject()));
 }else {
RDebugUtils.currentLine=5439507;
 //BA.debugLineNum = 5439507;BA.debugLine="Msgbox2(\"Por favor, rellene todos los campos, se";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Por favor, rellene todos los campos, seleccione un periodo y color"),BA.ObjectToCharSequence("Registro incorrecto"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 };
RDebugUtils.currentLine=5439509;
 //BA.debugLineNum = 5439509;BA.debugLine="End Sub";
return "";
}
public static boolean  _validarcampos() throws Exception{
RDebugUtils.currentModule="editaringresorecurrente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "validarcampos", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "validarcampos", null));}
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Sub validarCampos As Boolean";
RDebugUtils.currentLine=4653057;
 //BA.debugLineNum = 4653057;BA.debugLine="If(txtMonto.Text.Length <> 0 And txtNombre.Text.L";
if ((mostCurrent._txtmonto.getText().length()!=0 && mostCurrent._txtnombre.getText().length()!=0 && mostCurrent._txtdescripcion.getText().length()!=0 && _colorcaja!=0 && _diasperiodo!=0)) { 
RDebugUtils.currentLine=4653058;
 //BA.debugLineNum = 4653058;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=4653060;
 //BA.debugLineNum = 4653060;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=4653062;
 //BA.debugLineNum = 4653062;BA.debugLine="End Sub";
return false;
}
public static String  _consultaaeditar(int _rowid) throws Exception{
RDebugUtils.currentModule="editaringresorecurrente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "consultaaeditar", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "consultaaeditar", new Object[] {_rowid}));}
pullup.wallet.main._registroingreso _ingresorecurrente = null;
RDebugUtils.currentLine=5505024;
 //BA.debugLineNum = 5505024;BA.debugLine="Sub consultaAEditar(rowid As Int)";
RDebugUtils.currentLine=5505025;
 //BA.debugLineNum = 5505025;BA.debugLine="Dim ingresoRecurrente As RegistroIngreso";
_ingresorecurrente = new pullup.wallet.main._registroingreso();
RDebugUtils.currentLine=5505026;
 //BA.debugLineNum = 5505026;BA.debugLine="idRegistro = rowid";
_idregistro = _rowid;
RDebugUtils.currentLine=5505028;
 //BA.debugLineNum = 5505028;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM ingresos_recur";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM ingresos_recurrentes WHERE id_ingreso_recurrente = '"+BA.NumberToString(_idregistro)+"'")));
RDebugUtils.currentLine=5505029;
 //BA.debugLineNum = 5505029;BA.debugLine="If(cur.RowCount > 0) Then";
if ((mostCurrent._cur.getRowCount()>0)) { 
RDebugUtils.currentLine=5505030;
 //BA.debugLineNum = 5505030;BA.debugLine="cur.Position = 0";
mostCurrent._cur.setPosition((int) (0));
RDebugUtils.currentLine=5505031;
 //BA.debugLineNum = 5505031;BA.debugLine="ingresoRecurrente.nombre = cur.GetString(\"nombre";
_ingresorecurrente.nombre /*String*/  = mostCurrent._cur.GetString("nombre");
RDebugUtils.currentLine=5505032;
 //BA.debugLineNum = 5505032;BA.debugLine="ingresoRecurrente.monto = cur.GetInt(\"monto\")";
_ingresorecurrente.monto /*int*/  = mostCurrent._cur.GetInt("monto");
RDebugUtils.currentLine=5505033;
 //BA.debugLineNum = 5505033;BA.debugLine="ingresoRecurrente.descripcion = cur.GetString(\"d";
_ingresorecurrente.descripcion /*String*/  = mostCurrent._cur.GetString("descripcion");
RDebugUtils.currentLine=5505034;
 //BA.debugLineNum = 5505034;BA.debugLine="ingresoRecurrente.periodo = cur.GetInt(\"periodo\"";
_ingresorecurrente.periodo /*int*/  = mostCurrent._cur.GetInt("periodo");
RDebugUtils.currentLine=5505035;
 //BA.debugLineNum = 5505035;BA.debugLine="ingresoRecurrente.color = cur.GetString(\"color\")";
_ingresorecurrente.color /*int*/  = (int)(Double.parseDouble(mostCurrent._cur.GetString("color")));
RDebugUtils.currentLine=5505037;
 //BA.debugLineNum = 5505037;BA.debugLine="reasignarCamposAEditar(ingresoRecurrente)";
_reasignarcamposaeditar(_ingresorecurrente);
 };
RDebugUtils.currentLine=5505039;
 //BA.debugLineNum = 5505039;BA.debugLine="End Sub";
return "";
}
public static String  _reasignarcamposaeditar(pullup.wallet.main._registroingreso _registro) throws Exception{
RDebugUtils.currentModule="editaringresorecurrente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "reasignarcamposaeditar", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "reasignarcamposaeditar", new Object[] {_registro}));}
RDebugUtils.currentLine=5570560;
 //BA.debugLineNum = 5570560;BA.debugLine="Sub reasignarCamposAEditar(registro As RegistroIng";
RDebugUtils.currentLine=5570561;
 //BA.debugLineNum = 5570561;BA.debugLine="txtNombre.Text = registro.nombre";
mostCurrent._txtnombre.setText(BA.ObjectToCharSequence(_registro.nombre /*String*/ ));
RDebugUtils.currentLine=5570562;
 //BA.debugLineNum = 5570562;BA.debugLine="txtMonto.Text = registro.monto";
mostCurrent._txtmonto.setText(BA.ObjectToCharSequence(_registro.monto /*int*/ ));
RDebugUtils.currentLine=5570563;
 //BA.debugLineNum = 5570563;BA.debugLine="txtDescripcion.Text = registro.descripcion";
mostCurrent._txtdescripcion.setText(BA.ObjectToCharSequence(_registro.descripcion /*String*/ ));
RDebugUtils.currentLine=5570564;
 //BA.debugLineNum = 5570564;BA.debugLine="Select registro.periodo";
switch (BA.switchObjectToInt(_registro.periodo /*int*/ ,(int) (7),(int) (14),(int) (21),(int) (30),(int) (365))) {
case 0: {
RDebugUtils.currentLine=5570566;
 //BA.debugLineNum = 5570566;BA.debugLine="rd1Semana.Checked = True";
mostCurrent._rd1semana.setChecked(anywheresoftware.b4a.keywords.Common.True);
 break; }
case 1: {
RDebugUtils.currentLine=5570568;
 //BA.debugLineNum = 5570568;BA.debugLine="rd2Semanas.Checked = True";
mostCurrent._rd2semanas.setChecked(anywheresoftware.b4a.keywords.Common.True);
 break; }
case 2: {
RDebugUtils.currentLine=5570570;
 //BA.debugLineNum = 5570570;BA.debugLine="rd3Semanas.Checked = True";
mostCurrent._rd3semanas.setChecked(anywheresoftware.b4a.keywords.Common.True);
 break; }
case 3: {
RDebugUtils.currentLine=5570572;
 //BA.debugLineNum = 5570572;BA.debugLine="rd1Mes.Checked = True";
mostCurrent._rd1mes.setChecked(anywheresoftware.b4a.keywords.Common.True);
 break; }
case 4: {
RDebugUtils.currentLine=5570574;
 //BA.debugLineNum = 5570574;BA.debugLine="rd1Ano.Checked = True";
mostCurrent._rd1ano.setChecked(anywheresoftware.b4a.keywords.Common.True);
 break; }
}
;
RDebugUtils.currentLine=5570576;
 //BA.debugLineNum = 5570576;BA.debugLine="diasPeriodo = registro.periodo";
_diasperiodo = _registro.periodo /*int*/ ;
RDebugUtils.currentLine=5570577;
 //BA.debugLineNum = 5570577;BA.debugLine="cpBarraColor_ColorChanged(registro.color)";
_cpbarracolor_colorchanged(_registro.color /*int*/ );
RDebugUtils.currentLine=5570578;
 //BA.debugLineNum = 5570578;BA.debugLine="End Sub";
return "";
}
public static String  _cpbarracolor_colorchanged(int _color) throws Exception{
RDebugUtils.currentModule="editaringresorecurrente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cpbarracolor_colorchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cpbarracolor_colorchanged", new Object[] {_color}));}
RDebugUtils.currentLine=4718592;
 //BA.debugLineNum = 4718592;BA.debugLine="Sub cpBarraColor_ColorChanged(color As Int)";
RDebugUtils.currentLine=4718593;
 //BA.debugLineNum = 4718593;BA.debugLine="lblFondoMonto.Color = color";
mostCurrent._lblfondomonto.setColor(_color);
RDebugUtils.currentLine=4718594;
 //BA.debugLineNum = 4718594;BA.debugLine="colorCaja = color";
_colorcaja = _color;
RDebugUtils.currentLine=4718595;
 //BA.debugLineNum = 4718595;BA.debugLine="End Sub";
return "";
}
public static String  _limitarlongitudentrada(String _antiguo,String _nuevo,int _longitud,anywheresoftware.b4a.objects.B4XViewWrapper _view,String _campo) throws Exception{
RDebugUtils.currentModule="editaringresorecurrente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "limitarlongitudentrada", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "limitarlongitudentrada", new Object[] {_antiguo,_nuevo,_longitud,_view,_campo}));}
RDebugUtils.currentLine=4784128;
 //BA.debugLineNum = 4784128;BA.debugLine="Sub limitarLongitudEntrada(antiguo As String, nuev";
RDebugUtils.currentLine=4784129;
 //BA.debugLineNum = 4784129;BA.debugLine="If(nuevo.Length > longitud) Then";
if ((_nuevo.length()>_longitud)) { 
RDebugUtils.currentLine=4784130;
 //BA.debugLineNum = 4784130;BA.debugLine="If(campo = \"monto\") Then";
if (((_campo).equals("monto"))) { 
RDebugUtils.currentLine=4784131;
 //BA.debugLineNum = 4784131;BA.debugLine="If(aparicionMsgBox1 = False) Then";
if ((_aparicionmsgbox1==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=4784132;
 //BA.debugLineNum = 4784132;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para el monto es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=4784133;
 //BA.debugLineNum = 4784133;BA.debugLine="aparicionMsgBox1 = True";
_aparicionmsgbox1 = anywheresoftware.b4a.keywords.Common.True;
 };
 }else 
{RDebugUtils.currentLine=4784135;
 //BA.debugLineNum = 4784135;BA.debugLine="Else If(campo = \"nombre\") Then";
if (((_campo).equals("nombre"))) { 
RDebugUtils.currentLine=4784136;
 //BA.debugLineNum = 4784136;BA.debugLine="If(aparicionMsgBox2 = False) Then";
if ((_aparicionmsgbox2==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=4784137;
 //BA.debugLineNum = 4784137;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para el nombre es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=4784138;
 //BA.debugLineNum = 4784138;BA.debugLine="aparicionMsgBox2 = True";
_aparicionmsgbox2 = anywheresoftware.b4a.keywords.Common.True;
 };
 }else 
{RDebugUtils.currentLine=4784140;
 //BA.debugLineNum = 4784140;BA.debugLine="Else If(campo = \"descripcion\") Then";
if (((_campo).equals("descripcion"))) { 
RDebugUtils.currentLine=4784141;
 //BA.debugLineNum = 4784141;BA.debugLine="If(aparicionMsgBox3 = False) Then";
if ((_aparicionmsgbox3==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=4784142;
 //BA.debugLineNum = 4784142;BA.debugLine="Msgbox2(\"La longitud máxima permitida para la";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para la descripción es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=4784143;
 //BA.debugLineNum = 4784143;BA.debugLine="aparicionMsgBox3 = True";
_aparicionmsgbox3 = anywheresoftware.b4a.keywords.Common.True;
 };
 }}}
;
RDebugUtils.currentLine=4784146;
 //BA.debugLineNum = 4784146;BA.debugLine="view.Text = antiguo";
_view.setText(BA.ObjectToCharSequence(_antiguo));
 };
RDebugUtils.currentLine=4784148;
 //BA.debugLineNum = 4784148;BA.debugLine="End Sub";
return "";
}
public static String  _rd1ano_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="editaringresorecurrente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd1ano_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd1ano_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=5308416;
 //BA.debugLineNum = 5308416;BA.debugLine="Private Sub rd1Ano_CheckedChange(Checked As Boolea";
RDebugUtils.currentLine=5308417;
 //BA.debugLineNum = 5308417;BA.debugLine="diasPeriodo = 365";
_diasperiodo = (int) (365);
RDebugUtils.currentLine=5308418;
 //BA.debugLineNum = 5308418;BA.debugLine="End Sub";
return "";
}
public static String  _rd1mes_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="editaringresorecurrente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd1mes_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd1mes_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=5242880;
 //BA.debugLineNum = 5242880;BA.debugLine="Private Sub rd1Mes_CheckedChange(Checked As Boolea";
RDebugUtils.currentLine=5242881;
 //BA.debugLineNum = 5242881;BA.debugLine="diasPeriodo = 30";
_diasperiodo = (int) (30);
RDebugUtils.currentLine=5242882;
 //BA.debugLineNum = 5242882;BA.debugLine="End Sub";
return "";
}
public static String  _rd1semana_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="editaringresorecurrente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd1semana_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd1semana_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=5177344;
 //BA.debugLineNum = 5177344;BA.debugLine="Private Sub rd1Semana_CheckedChange(Checked As Boo";
RDebugUtils.currentLine=5177345;
 //BA.debugLineNum = 5177345;BA.debugLine="diasPeriodo = 7";
_diasperiodo = (int) (7);
RDebugUtils.currentLine=5177346;
 //BA.debugLineNum = 5177346;BA.debugLine="End Sub";
return "";
}
public static String  _rd2semanas_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="editaringresorecurrente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd2semanas_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd2semanas_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=5111808;
 //BA.debugLineNum = 5111808;BA.debugLine="Private Sub rd2Semanas_CheckedChange(Checked As Bo";
RDebugUtils.currentLine=5111809;
 //BA.debugLineNum = 5111809;BA.debugLine="diasPeriodo = 14";
_diasperiodo = (int) (14);
RDebugUtils.currentLine=5111810;
 //BA.debugLineNum = 5111810;BA.debugLine="End Sub";
return "";
}
public static String  _rd3semanas_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="editaringresorecurrente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd3semanas_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd3semanas_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=5046272;
 //BA.debugLineNum = 5046272;BA.debugLine="Private Sub rd3Semanas_CheckedChange(Checked As Bo";
RDebugUtils.currentLine=5046273;
 //BA.debugLineNum = 5046273;BA.debugLine="diasPeriodo = 21";
_diasperiodo = (int) (21);
RDebugUtils.currentLine=5046274;
 //BA.debugLineNum = 5046274;BA.debugLine="End Sub";
return "";
}
public static String  _txtdescripcion_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="editaringresorecurrente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtdescripcion_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtdescripcion_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=4980736;
 //BA.debugLineNum = 4980736;BA.debugLine="Private Sub txtDescripcion_TextChanged (Old As Str";
RDebugUtils.currentLine=4980737;
 //BA.debugLineNum = 4980737;BA.debugLine="limitarLongitudEntrada(Old, New, 41, txtDescripci";
_limitarlongitudentrada(_old,_new,(int) (41),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtdescripcion.getObject())),"descripcion");
RDebugUtils.currentLine=4980738;
 //BA.debugLineNum = 4980738;BA.debugLine="End Sub";
return "";
}
public static String  _txtmonto_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="editaringresorecurrente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtmonto_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtmonto_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=4849664;
 //BA.debugLineNum = 4849664;BA.debugLine="Private Sub txtMonto_TextChanged (Old As String, N";
RDebugUtils.currentLine=4849665;
 //BA.debugLineNum = 4849665;BA.debugLine="limitarLongitudEntrada(Old, New, 9, txtMonto, \"mo";
_limitarlongitudentrada(_old,_new,(int) (9),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtmonto.getObject())),"monto");
RDebugUtils.currentLine=4849666;
 //BA.debugLineNum = 4849666;BA.debugLine="End Sub";
return "";
}
public static String  _txtnombre_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="editaringresorecurrente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtnombre_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtnombre_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=4915200;
 //BA.debugLineNum = 4915200;BA.debugLine="Private Sub txtNombre_TextChanged (Old As String,";
RDebugUtils.currentLine=4915201;
 //BA.debugLineNum = 4915201;BA.debugLine="limitarLongitudEntrada(Old, New, 16, txtNombre, \"";
_limitarlongitudentrada(_old,_new,(int) (16),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtnombre.getObject())),"nombre");
RDebugUtils.currentLine=4915202;
 //BA.debugLineNum = 4915202;BA.debugLine="End Sub";
return "";
}
}