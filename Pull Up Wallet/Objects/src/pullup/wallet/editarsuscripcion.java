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

public class editarsuscripcion extends Activity implements B4AActivity{
	public static editarsuscripcion mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "pullup.wallet", "pullup.wallet.editarsuscripcion");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (editarsuscripcion).");
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
		activityBA = new BA(this, layout, processBA, "pullup.wallet", "pullup.wallet.editarsuscripcion");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "pullup.wallet.editarsuscripcion", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (editarsuscripcion) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (editarsuscripcion) Resume **");
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
		return editarsuscripcion.class;
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
            BA.LogInfo("** Activity (editarsuscripcion) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (editarsuscripcion) Pause event (activity is not paused). **");
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
            editarsuscripcion mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (editarsuscripcion) Resume **");
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
RDebugUtils.currentModule="editarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=8257536;
 //BA.debugLineNum = 8257536;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=8257537;
 //BA.debugLineNum = 8257537;BA.debugLine="Activity.LoadLayout(\"LFormSuscripcion\")";
mostCurrent._activity.LoadLayout("LFormSuscripcion",mostCurrent.activityBA);
RDebugUtils.currentLine=8257538;
 //BA.debugLineNum = 8257538;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
_alturadispositivo = mostCurrent._main._alturadispositivo /*int*/ ;
RDebugUtils.currentLine=8257539;
 //BA.debugLineNum = 8257539;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
_anchodispositivo = mostCurrent._main._anchodispositivo /*int*/ ;
RDebugUtils.currentLine=8257540;
 //BA.debugLineNum = 8257540;BA.debugLine="sql = Starter.sql";
_sql = mostCurrent._starter._sql /*anywheresoftware.b4a.sql.SQL*/ ;
RDebugUtils.currentLine=8257541;
 //BA.debugLineNum = 8257541;BA.debugLine="aparicionMsgBox1 = False";
_aparicionmsgbox1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=8257542;
 //BA.debugLineNum = 8257542;BA.debugLine="aparicionMsgBox2 = False";
_aparicionmsgbox2 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=8257543;
 //BA.debugLineNum = 8257543;BA.debugLine="aparicionMsgBox3 = False";
_aparicionmsgbox3 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=8257546;
 //BA.debugLineNum = 8257546;BA.debugLine="lblNombreVista.TextSize = 20";
mostCurrent._lblnombrevista.setTextSize((float) (20));
RDebugUtils.currentLine=8257547;
 //BA.debugLineNum = 8257547;BA.debugLine="lblNombreVista.TextColor = Colors.Black";
mostCurrent._lblnombrevista.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=8257548;
 //BA.debugLineNum = 8257548;BA.debugLine="lblNombreVista.Height = 30dip";
mostCurrent._lblnombrevista.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=8257549;
 //BA.debugLineNum = 8257549;BA.debugLine="lblNombreVista.Width = anchoDispositivo * 0.9";
mostCurrent._lblnombrevista.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=8257550;
 //BA.debugLineNum = 8257550;BA.debugLine="lblNombreVista.Top = 30dip";
mostCurrent._lblnombrevista.setTop(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=8257551;
 //BA.debugLineNum = 8257551;BA.debugLine="lblNombreVista.Left = (anchoDispositivo - lblNomb";
mostCurrent._lblnombrevista.setLeft((int) ((_anchodispositivo-mostCurrent._lblnombrevista.getWidth())/(double)2));
RDebugUtils.currentLine=8257553;
 //BA.debugLineNum = 8257553;BA.debugLine="txtMonto.Width = anchoDispositivo * 0.9";
mostCurrent._txtmonto.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=8257554;
 //BA.debugLineNum = 8257554;BA.debugLine="txtMonto.Height = alturaDispositivo * 0.22";
mostCurrent._txtmonto.setHeight((int) (_alturadispositivo*0.22));
RDebugUtils.currentLine=8257555;
 //BA.debugLineNum = 8257555;BA.debugLine="txtMonto.Top = lblNombreVista.Top * 2 + lblNombre";
mostCurrent._txtmonto.setTop((int) (mostCurrent._lblnombrevista.getTop()*2+mostCurrent._lblnombrevista.getHeight()));
RDebugUtils.currentLine=8257556;
 //BA.debugLineNum = 8257556;BA.debugLine="txtMonto.Left = (anchoDispositivo - txtMonto.Widt";
mostCurrent._txtmonto.setLeft((int) ((_anchodispositivo-mostCurrent._txtmonto.getWidth())/(double)2));
RDebugUtils.currentLine=8257557;
 //BA.debugLineNum = 8257557;BA.debugLine="lblFondoMonto.Width = txtMonto.Width";
mostCurrent._lblfondomonto.setWidth(mostCurrent._txtmonto.getWidth());
RDebugUtils.currentLine=8257558;
 //BA.debugLineNum = 8257558;BA.debugLine="lblFondoMonto.Height = txtMonto.Height";
mostCurrent._lblfondomonto.setHeight(mostCurrent._txtmonto.getHeight());
RDebugUtils.currentLine=8257559;
 //BA.debugLineNum = 8257559;BA.debugLine="lblFondoMonto.Top = txtMonto.Top";
mostCurrent._lblfondomonto.setTop(mostCurrent._txtmonto.getTop());
RDebugUtils.currentLine=8257560;
 //BA.debugLineNum = 8257560;BA.debugLine="lblFondoMonto.Left = txtMonto.Left";
mostCurrent._lblfondomonto.setLeft(mostCurrent._txtmonto.getLeft());
RDebugUtils.currentLine=8257562;
 //BA.debugLineNum = 8257562;BA.debugLine="txtNombre.Width = anchoDispositivo * 0.9";
mostCurrent._txtnombre.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=8257563;
 //BA.debugLineNum = 8257563;BA.debugLine="txtNombre.Height = alturaDispositivo * 0.07";
mostCurrent._txtnombre.setHeight((int) (_alturadispositivo*0.07));
RDebugUtils.currentLine=8257564;
 //BA.debugLineNum = 8257564;BA.debugLine="txtNombre.Top = txtMonto.Top + txtMonto.Height +";
mostCurrent._txtnombre.setTop((int) (mostCurrent._txtmonto.getTop()+mostCurrent._txtmonto.getHeight()+mostCurrent._lblnombrevista.getTop()/(double)2));
RDebugUtils.currentLine=8257565;
 //BA.debugLineNum = 8257565;BA.debugLine="txtNombre.Left = (anchoDispositivo - txtNombre.Wi";
mostCurrent._txtnombre.setLeft((int) ((_anchodispositivo-mostCurrent._txtnombre.getWidth())/(double)2));
RDebugUtils.currentLine=8257566;
 //BA.debugLineNum = 8257566;BA.debugLine="lblFondoNombre.Width = txtMonto.Width";
mostCurrent._lblfondonombre.setWidth(mostCurrent._txtmonto.getWidth());
RDebugUtils.currentLine=8257567;
 //BA.debugLineNum = 8257567;BA.debugLine="lblFondoNombre.Height = txtNombre.Height";
mostCurrent._lblfondonombre.setHeight(mostCurrent._txtnombre.getHeight());
RDebugUtils.currentLine=8257568;
 //BA.debugLineNum = 8257568;BA.debugLine="lblFondoNombre.Top = txtNombre.Top";
mostCurrent._lblfondonombre.setTop(mostCurrent._txtnombre.getTop());
RDebugUtils.currentLine=8257569;
 //BA.debugLineNum = 8257569;BA.debugLine="lblFondoNombre.Left = txtNombre.Left";
mostCurrent._lblfondonombre.setLeft(mostCurrent._txtnombre.getLeft());
RDebugUtils.currentLine=8257571;
 //BA.debugLineNum = 8257571;BA.debugLine="txtDescripcion.Width = txtNombre.Width";
mostCurrent._txtdescripcion.setWidth(mostCurrent._txtnombre.getWidth());
RDebugUtils.currentLine=8257572;
 //BA.debugLineNum = 8257572;BA.debugLine="txtDescripcion.Height = txtNombre.Height";
mostCurrent._txtdescripcion.setHeight(mostCurrent._txtnombre.getHeight());
RDebugUtils.currentLine=8257573;
 //BA.debugLineNum = 8257573;BA.debugLine="txtDescripcion.Top = txtNombre.Top + txtNombre.He";
mostCurrent._txtdescripcion.setTop((int) (mostCurrent._txtnombre.getTop()+mostCurrent._txtnombre.getHeight()+mostCurrent._lblnombrevista.getTop()/(double)2));
RDebugUtils.currentLine=8257574;
 //BA.debugLineNum = 8257574;BA.debugLine="txtDescripcion.Left = txtNombre.Left";
mostCurrent._txtdescripcion.setLeft(mostCurrent._txtnombre.getLeft());
RDebugUtils.currentLine=8257575;
 //BA.debugLineNum = 8257575;BA.debugLine="lblFondoDescripcion.Width = txtDescripcion.Width";
mostCurrent._lblfondodescripcion.setWidth(mostCurrent._txtdescripcion.getWidth());
RDebugUtils.currentLine=8257576;
 //BA.debugLineNum = 8257576;BA.debugLine="lblFondoDescripcion.Height = txtDescripcion.Heigh";
mostCurrent._lblfondodescripcion.setHeight(mostCurrent._txtdescripcion.getHeight());
RDebugUtils.currentLine=8257577;
 //BA.debugLineNum = 8257577;BA.debugLine="lblFondoDescripcion.Top = txtDescripcion.Top";
mostCurrent._lblfondodescripcion.setTop(mostCurrent._txtdescripcion.getTop());
RDebugUtils.currentLine=8257578;
 //BA.debugLineNum = 8257578;BA.debugLine="lblFondoDescripcion.Left = txtDescripcion.Left";
mostCurrent._lblfondodescripcion.setLeft(mostCurrent._txtdescripcion.getLeft());
RDebugUtils.currentLine=8257580;
 //BA.debugLineNum = 8257580;BA.debugLine="pnlSelector.Top = txtDescripcion.Top + txtDescrip";
mostCurrent._pnlselector.setTop((int) (mostCurrent._txtdescripcion.getTop()+mostCurrent._txtdescripcion.getHeight()+mostCurrent._lblnombrevista.getTop()/(double)2));
RDebugUtils.currentLine=8257581;
 //BA.debugLineNum = 8257581;BA.debugLine="pnlSelector.Left = txtDescripcion.Left + txtDescr";
mostCurrent._pnlselector.setLeft((int) (mostCurrent._txtdescripcion.getLeft()+mostCurrent._txtdescripcion.getWidth()-mostCurrent._pnlselector.getWidth()));
RDebugUtils.currentLine=8257583;
 //BA.debugLineNum = 8257583;BA.debugLine="pnlPeriodos.Top = pnlSelector.Top";
mostCurrent._pnlperiodos.setTop(mostCurrent._pnlselector.getTop());
RDebugUtils.currentLine=8257584;
 //BA.debugLineNum = 8257584;BA.debugLine="pnlPeriodos.Left = txtDescripcion.Left";
mostCurrent._pnlperiodos.setLeft(mostCurrent._txtdescripcion.getLeft());
RDebugUtils.currentLine=8257585;
 //BA.debugLineNum = 8257585;BA.debugLine="pnlPeriodos.Width = (txtDescripcion.Width - pnlSe";
mostCurrent._pnlperiodos.setWidth((int) ((mostCurrent._txtdescripcion.getWidth()-mostCurrent._pnlselector.getWidth())*0.9));
RDebugUtils.currentLine=8257586;
 //BA.debugLineNum = 8257586;BA.debugLine="pnlPeriodos.Height = pnlSelector.Height";
mostCurrent._pnlperiodos.setHeight(mostCurrent._pnlselector.getHeight());
RDebugUtils.currentLine=8257589;
 //BA.debugLineNum = 8257589;BA.debugLine="rd1Semana.Width = pnlPeriodos.Width";
mostCurrent._rd1semana.setWidth(mostCurrent._pnlperiodos.getWidth());
RDebugUtils.currentLine=8257590;
 //BA.debugLineNum = 8257590;BA.debugLine="rd1Semana.Height = pnlPeriodos.Height * 0.18";
mostCurrent._rd1semana.setHeight((int) (mostCurrent._pnlperiodos.getHeight()*0.18));
RDebugUtils.currentLine=8257591;
 //BA.debugLineNum = 8257591;BA.debugLine="rd1Semana.Left = 0";
mostCurrent._rd1semana.setLeft((int) (0));
RDebugUtils.currentLine=8257592;
 //BA.debugLineNum = 8257592;BA.debugLine="rd1Semana.Top = 0";
mostCurrent._rd1semana.setTop((int) (0));
RDebugUtils.currentLine=8257594;
 //BA.debugLineNum = 8257594;BA.debugLine="rd2Semanas.Width = rd1Semana.Width";
mostCurrent._rd2semanas.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=8257595;
 //BA.debugLineNum = 8257595;BA.debugLine="rd2Semanas.Height = rd1Semana.Height";
mostCurrent._rd2semanas.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=8257596;
 //BA.debugLineNum = 8257596;BA.debugLine="rd2Semanas.Left = rd1Semana.Left";
mostCurrent._rd2semanas.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=8257597;
 //BA.debugLineNum = 8257597;BA.debugLine="rd2Semanas.Top = rd1Semana.Height + pnlPeriodos.H";
mostCurrent._rd2semanas.setTop((int) (mostCurrent._rd1semana.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=8257599;
 //BA.debugLineNum = 8257599;BA.debugLine="rd3Semanas.Width = rd1Semana.Width";
mostCurrent._rd3semanas.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=8257600;
 //BA.debugLineNum = 8257600;BA.debugLine="rd3Semanas.Height = rd1Semana.Height";
mostCurrent._rd3semanas.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=8257601;
 //BA.debugLineNum = 8257601;BA.debugLine="rd3Semanas.Left = rd1Semana.Left";
mostCurrent._rd3semanas.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=8257602;
 //BA.debugLineNum = 8257602;BA.debugLine="rd3Semanas.Top = rd2Semanas.Top + rd2Semanas.Heig";
mostCurrent._rd3semanas.setTop((int) (mostCurrent._rd2semanas.getTop()+mostCurrent._rd2semanas.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=8257604;
 //BA.debugLineNum = 8257604;BA.debugLine="rd1Mes.Width = rd1Semana.Width";
mostCurrent._rd1mes.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=8257605;
 //BA.debugLineNum = 8257605;BA.debugLine="rd1Mes.Height = rd1Semana.Height";
mostCurrent._rd1mes.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=8257606;
 //BA.debugLineNum = 8257606;BA.debugLine="rd1Mes.Left = rd1Semana.Left";
mostCurrent._rd1mes.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=8257607;
 //BA.debugLineNum = 8257607;BA.debugLine="rd1Mes.Top = rd3Semanas.Top + rd3Semanas.Height +";
mostCurrent._rd1mes.setTop((int) (mostCurrent._rd3semanas.getTop()+mostCurrent._rd3semanas.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=8257609;
 //BA.debugLineNum = 8257609;BA.debugLine="rd1Ano.Width = rd1Semana.Width";
mostCurrent._rd1ano.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=8257610;
 //BA.debugLineNum = 8257610;BA.debugLine="rd1Ano.Height = rd1Semana.Height";
mostCurrent._rd1ano.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=8257611;
 //BA.debugLineNum = 8257611;BA.debugLine="rd1Ano.Left = rd1Semana.Left";
mostCurrent._rd1ano.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=8257612;
 //BA.debugLineNum = 8257612;BA.debugLine="rd1Ano.Top = rd1Mes.Top + rd1Mes.Height + pnlPeri";
mostCurrent._rd1ano.setTop((int) (mostCurrent._rd1mes.getTop()+mostCurrent._rd1mes.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=8257617;
 //BA.debugLineNum = 8257617;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
mostCurrent._pnlnavinferior.setHeight((int) (_alturadispositivo*0.08));
RDebugUtils.currentLine=8257618;
 //BA.debugLineNum = 8257618;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
mostCurrent._pnlnavinferior.setWidth(_anchodispositivo);
RDebugUtils.currentLine=8257619;
 //BA.debugLineNum = 8257619;BA.debugLine="pnlNavInferior.Left = 0";
mostCurrent._pnlnavinferior.setLeft((int) (0));
RDebugUtils.currentLine=8257620;
 //BA.debugLineNum = 8257620;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
mostCurrent._pnlnavinferior.setTop((int) (_alturadispositivo-mostCurrent._pnlnavinferior.getHeight()));
RDebugUtils.currentLine=8257623;
 //BA.debugLineNum = 8257623;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
mostCurrent._btnmenu.setWidth((int) (_anchodispositivo*0.15));
RDebugUtils.currentLine=8257624;
 //BA.debugLineNum = 8257624;BA.debugLine="btnMenu.Height = btnMenu.Width";
mostCurrent._btnmenu.setHeight(mostCurrent._btnmenu.getWidth());
RDebugUtils.currentLine=8257625;
 //BA.debugLineNum = 8257625;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
mostCurrent._btnmenu.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._btnmenu.getHeight()/(double)2));
RDebugUtils.currentLine=8257626;
 //BA.debugLineNum = 8257626;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
mostCurrent._btnmenu.setLeft((int) ((_anchodispositivo-mostCurrent._btnmenu.getWidth())/(double)2));
RDebugUtils.currentLine=8257628;
 //BA.debugLineNum = 8257628;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
mostCurrent._lblcontornoboton.setWidth((int) (_anchodispositivo*0.17));
RDebugUtils.currentLine=8257629;
 //BA.debugLineNum = 8257629;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
mostCurrent._lblcontornoboton.setHeight(mostCurrent._lblcontornoboton.getWidth());
RDebugUtils.currentLine=8257630;
 //BA.debugLineNum = 8257630;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
mostCurrent._lblcontornoboton.setLeft((int) ((_anchodispositivo-mostCurrent._lblcontornoboton.getWidth())/(double)2));
RDebugUtils.currentLine=8257631;
 //BA.debugLineNum = 8257631;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
mostCurrent._lblcontornoboton.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._lblcontornoboton.getHeight()/(double)2));
RDebugUtils.currentLine=8257636;
 //BA.debugLineNum = 8257636;BA.debugLine="btnOperacionSuscripcion.Text = \"Editar suscripció";
mostCurrent._btnoperacionsuscripcion.setText(BA.ObjectToCharSequence("Editar suscripción"));
RDebugUtils.currentLine=8257637;
 //BA.debugLineNum = 8257637;BA.debugLine="btnOperacionSuscripcion.Top = pnlPeriodos.Top + p";
mostCurrent._btnoperacionsuscripcion.setTop((int) (mostCurrent._pnlperiodos.getTop()+mostCurrent._pnlperiodos.getHeight()+(mostCurrent._lblcontornoboton.getTop()-(mostCurrent._pnlperiodos.getTop()+mostCurrent._pnlperiodos.getHeight()+mostCurrent._btnoperacionsuscripcion.getHeight()))/(double)2));
RDebugUtils.currentLine=8257638;
 //BA.debugLineNum = 8257638;BA.debugLine="btnOperacionSuscripcion.Left = (anchoDispositivo";
mostCurrent._btnoperacionsuscripcion.setLeft((int) ((_anchodispositivo-mostCurrent._btnoperacionsuscripcion.getWidth())/(double)2));
RDebugUtils.currentLine=8257639;
 //BA.debugLineNum = 8257639;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="editarsuscripcion";
RDebugUtils.currentLine=8388608;
 //BA.debugLineNum = 8388608;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=8388609;
 //BA.debugLineNum = 8388609;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="editarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=8323072;
 //BA.debugLineNum = 8323072;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=8323073;
 //BA.debugLineNum = 8323073;BA.debugLine="End Sub";
return "";
}
public static pullup.wallet.main._registrosuscripcion  _asignacioncampos() throws Exception{
RDebugUtils.currentModule="editarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "asignacioncampos", false))
	 {return ((pullup.wallet.main._registrosuscripcion) Debug.delegate(mostCurrent.activityBA, "asignacioncampos", null));}
pullup.wallet.main._registrosuscripcion _susripcion = null;
RDebugUtils.currentLine=9240576;
 //BA.debugLineNum = 9240576;BA.debugLine="Sub asignacionCampos As RegistroSuscripcion";
RDebugUtils.currentLine=9240577;
 //BA.debugLineNum = 9240577;BA.debugLine="Dim susripcion As RegistroSuscripcion";
_susripcion = new pullup.wallet.main._registrosuscripcion();
RDebugUtils.currentLine=9240579;
 //BA.debugLineNum = 9240579;BA.debugLine="susripcion.monto = txtMonto.Text";
_susripcion.monto /*int*/  = (int)(Double.parseDouble(mostCurrent._txtmonto.getText()));
RDebugUtils.currentLine=9240581;
 //BA.debugLineNum = 9240581;BA.debugLine="susripcion.nombre = txtNombre.Text";
_susripcion.nombre /*String*/  = mostCurrent._txtnombre.getText();
RDebugUtils.currentLine=9240583;
 //BA.debugLineNum = 9240583;BA.debugLine="susripcion.descripcion = (txtDescripcion.Text)";
_susripcion.descripcion /*String*/  = (mostCurrent._txtdescripcion.getText());
RDebugUtils.currentLine=9240585;
 //BA.debugLineNum = 9240585;BA.debugLine="susripcion.periodo = diasPeriodo";
_susripcion.periodo /*int*/  = _diasperiodo;
RDebugUtils.currentLine=9240587;
 //BA.debugLineNum = 9240587;BA.debugLine="susripcion.color = colorCaja";
_susripcion.color /*int*/  = _colorcaja;
RDebugUtils.currentLine=9240589;
 //BA.debugLineNum = 9240589;BA.debugLine="Return susripcion";
if (true) return _susripcion;
RDebugUtils.currentLine=9240590;
 //BA.debugLineNum = 9240590;BA.debugLine="End Sub";
return null;
}
public static String  _btnmenu_click() throws Exception{
RDebugUtils.currentModule="editarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnmenu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnmenu_click", null));}
RDebugUtils.currentLine=8454144;
 //BA.debugLineNum = 8454144;BA.debugLine="Private Sub btnMenu_Click";
RDebugUtils.currentLine=8454145;
 //BA.debugLineNum = 8454145;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=8454146;
 //BA.debugLineNum = 8454146;BA.debugLine="End Sub";
return "";
}
public static String  _btnoperacionsuscripcion_click() throws Exception{
RDebugUtils.currentModule="editarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnoperacionsuscripcion_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnoperacionsuscripcion_click", null));}
boolean _validaciones = false;
pullup.wallet.main._registrosuscripcion _suscripcionregistro = null;
RDebugUtils.currentLine=9306112;
 //BA.debugLineNum = 9306112;BA.debugLine="Private Sub btnOperacionSuscripcion_Click";
RDebugUtils.currentLine=9306113;
 //BA.debugLineNum = 9306113;BA.debugLine="Dim validaciones As Boolean";
_validaciones = false;
RDebugUtils.currentLine=9306115;
 //BA.debugLineNum = 9306115;BA.debugLine="validaciones = validarCampos";
_validaciones = _validarcampos();
RDebugUtils.currentLine=9306116;
 //BA.debugLineNum = 9306116;BA.debugLine="If(validaciones = True) Then";
if ((_validaciones==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=9306118;
 //BA.debugLineNum = 9306118;BA.debugLine="Dim suscripcionRegistro As RegistroSuscripcion";
_suscripcionregistro = new pullup.wallet.main._registrosuscripcion();
RDebugUtils.currentLine=9306119;
 //BA.debugLineNum = 9306119;BA.debugLine="suscripcionRegistro = asignacionCampos";
_suscripcionregistro = _asignacioncampos();
RDebugUtils.currentLine=9306122;
 //BA.debugLineNum = 9306122;BA.debugLine="sql.ExecNonQuery2(\"UPDATE suscripciones SET mont";
_sql.ExecNonQuery2("UPDATE suscripciones SET monto = ?, nombre = ?, descripcion = ?, periodo = ?, color = ? WHERE id_suscripcion = '"+BA.NumberToString(_idregistro)+"'",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_suscripcionregistro.monto /*int*/ ),(Object)(_suscripcionregistro.nombre /*String*/ ),(Object)(_suscripcionregistro.descripcion /*String*/ ),(Object)(_suscripcionregistro.periodo /*int*/ ),(Object)(_suscripcionregistro.color /*int*/ )}));
RDebugUtils.currentLine=9306124;
 //BA.debugLineNum = 9306124;BA.debugLine="ToastMessageShow(\"Suscripción editada\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Suscripción editada"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=9306126;
 //BA.debugLineNum = 9306126;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=9306128;
 //BA.debugLineNum = 9306128;BA.debugLine="StartActivity(Suscripciones)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._suscripciones.getObject()));
 }else {
RDebugUtils.currentLine=9306131;
 //BA.debugLineNum = 9306131;BA.debugLine="Msgbox2(\"Por favor, rellene todos los campos, se";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Por favor, rellene todos los campos, seleccione un periodo y color"),BA.ObjectToCharSequence("Registro incorrecto"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 };
RDebugUtils.currentLine=9306133;
 //BA.debugLineNum = 9306133;BA.debugLine="End Sub";
return "";
}
public static boolean  _validarcampos() throws Exception{
RDebugUtils.currentModule="editarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "validarcampos", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "validarcampos", null));}
RDebugUtils.currentLine=8519680;
 //BA.debugLineNum = 8519680;BA.debugLine="Sub validarCampos As Boolean";
RDebugUtils.currentLine=8519681;
 //BA.debugLineNum = 8519681;BA.debugLine="If(txtMonto.Text.Length <> 0 And txtNombre.Text.L";
if ((mostCurrent._txtmonto.getText().length()!=0 && mostCurrent._txtnombre.getText().length()!=0 && mostCurrent._txtdescripcion.getText().length()!=0 && _colorcaja!=0 && _diasperiodo!=0)) { 
RDebugUtils.currentLine=8519682;
 //BA.debugLineNum = 8519682;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=8519684;
 //BA.debugLineNum = 8519684;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=8519686;
 //BA.debugLineNum = 8519686;BA.debugLine="End Sub";
return false;
}
public static String  _consultaaeditar(int _rowid) throws Exception{
RDebugUtils.currentModule="editarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "consultaaeditar", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "consultaaeditar", new Object[] {_rowid}));}
pullup.wallet.main._registrosuscripcion _suscripcion = null;
RDebugUtils.currentLine=9371648;
 //BA.debugLineNum = 9371648;BA.debugLine="Sub consultaAEditar(rowid As Int)";
RDebugUtils.currentLine=9371649;
 //BA.debugLineNum = 9371649;BA.debugLine="Dim suscripcion As RegistroSuscripcion";
_suscripcion = new pullup.wallet.main._registrosuscripcion();
RDebugUtils.currentLine=9371650;
 //BA.debugLineNum = 9371650;BA.debugLine="idRegistro = rowid";
_idregistro = _rowid;
RDebugUtils.currentLine=9371652;
 //BA.debugLineNum = 9371652;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM suscripciones";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM suscripciones WHERE id_suscripcion = '"+BA.NumberToString(_idregistro)+"'")));
RDebugUtils.currentLine=9371653;
 //BA.debugLineNum = 9371653;BA.debugLine="If(cur.RowCount > 0) Then";
if ((mostCurrent._cur.getRowCount()>0)) { 
RDebugUtils.currentLine=9371654;
 //BA.debugLineNum = 9371654;BA.debugLine="cur.Position = 0";
mostCurrent._cur.setPosition((int) (0));
RDebugUtils.currentLine=9371655;
 //BA.debugLineNum = 9371655;BA.debugLine="suscripcion.nombre = cur.GetString(\"nombre\")";
_suscripcion.nombre /*String*/  = mostCurrent._cur.GetString("nombre");
RDebugUtils.currentLine=9371656;
 //BA.debugLineNum = 9371656;BA.debugLine="suscripcion.monto = cur.GetInt(\"monto\")";
_suscripcion.monto /*int*/  = mostCurrent._cur.GetInt("monto");
RDebugUtils.currentLine=9371657;
 //BA.debugLineNum = 9371657;BA.debugLine="suscripcion.descripcion = cur.GetString(\"descrip";
_suscripcion.descripcion /*String*/  = mostCurrent._cur.GetString("descripcion");
RDebugUtils.currentLine=9371658;
 //BA.debugLineNum = 9371658;BA.debugLine="suscripcion.periodo = cur.GetInt(\"periodo\")";
_suscripcion.periodo /*int*/  = mostCurrent._cur.GetInt("periodo");
RDebugUtils.currentLine=9371659;
 //BA.debugLineNum = 9371659;BA.debugLine="suscripcion.color = cur.GetString(\"color\")";
_suscripcion.color /*int*/  = (int)(Double.parseDouble(mostCurrent._cur.GetString("color")));
RDebugUtils.currentLine=9371661;
 //BA.debugLineNum = 9371661;BA.debugLine="reasignarCamposAEditar(suscripcion)";
_reasignarcamposaeditar(_suscripcion);
 };
RDebugUtils.currentLine=9371663;
 //BA.debugLineNum = 9371663;BA.debugLine="End Sub";
return "";
}
public static String  _reasignarcamposaeditar(pullup.wallet.main._registrosuscripcion _registro) throws Exception{
RDebugUtils.currentModule="editarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "reasignarcamposaeditar", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "reasignarcamposaeditar", new Object[] {_registro}));}
RDebugUtils.currentLine=9437184;
 //BA.debugLineNum = 9437184;BA.debugLine="Sub reasignarCamposAEditar(registro As RegistroSus";
RDebugUtils.currentLine=9437185;
 //BA.debugLineNum = 9437185;BA.debugLine="txtNombre.Text = registro.nombre";
mostCurrent._txtnombre.setText(BA.ObjectToCharSequence(_registro.nombre /*String*/ ));
RDebugUtils.currentLine=9437186;
 //BA.debugLineNum = 9437186;BA.debugLine="txtMonto.Text = registro.monto";
mostCurrent._txtmonto.setText(BA.ObjectToCharSequence(_registro.monto /*int*/ ));
RDebugUtils.currentLine=9437187;
 //BA.debugLineNum = 9437187;BA.debugLine="txtDescripcion.Text = registro.descripcion";
mostCurrent._txtdescripcion.setText(BA.ObjectToCharSequence(_registro.descripcion /*String*/ ));
RDebugUtils.currentLine=9437188;
 //BA.debugLineNum = 9437188;BA.debugLine="Select registro.periodo";
switch (BA.switchObjectToInt(_registro.periodo /*int*/ ,(int) (7),(int) (14),(int) (21),(int) (30),(int) (365))) {
case 0: {
RDebugUtils.currentLine=9437190;
 //BA.debugLineNum = 9437190;BA.debugLine="rd1Semana.Checked = True";
mostCurrent._rd1semana.setChecked(anywheresoftware.b4a.keywords.Common.True);
 break; }
case 1: {
RDebugUtils.currentLine=9437192;
 //BA.debugLineNum = 9437192;BA.debugLine="rd2Semanas.Checked = True";
mostCurrent._rd2semanas.setChecked(anywheresoftware.b4a.keywords.Common.True);
 break; }
case 2: {
RDebugUtils.currentLine=9437194;
 //BA.debugLineNum = 9437194;BA.debugLine="rd3Semanas.Checked = True";
mostCurrent._rd3semanas.setChecked(anywheresoftware.b4a.keywords.Common.True);
 break; }
case 3: {
RDebugUtils.currentLine=9437196;
 //BA.debugLineNum = 9437196;BA.debugLine="rd1Mes.Checked = True";
mostCurrent._rd1mes.setChecked(anywheresoftware.b4a.keywords.Common.True);
 break; }
case 4: {
RDebugUtils.currentLine=9437198;
 //BA.debugLineNum = 9437198;BA.debugLine="rd1Ano.Checked = True";
mostCurrent._rd1ano.setChecked(anywheresoftware.b4a.keywords.Common.True);
 break; }
}
;
RDebugUtils.currentLine=9437200;
 //BA.debugLineNum = 9437200;BA.debugLine="diasPeriodo = registro.periodo";
_diasperiodo = _registro.periodo /*int*/ ;
RDebugUtils.currentLine=9437201;
 //BA.debugLineNum = 9437201;BA.debugLine="cpBarraColor_ColorChanged(registro.color)";
_cpbarracolor_colorchanged(_registro.color /*int*/ );
RDebugUtils.currentLine=9437202;
 //BA.debugLineNum = 9437202;BA.debugLine="End Sub";
return "";
}
public static String  _cpbarracolor_colorchanged(int _color) throws Exception{
RDebugUtils.currentModule="editarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cpbarracolor_colorchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cpbarracolor_colorchanged", new Object[] {_color}));}
RDebugUtils.currentLine=8585216;
 //BA.debugLineNum = 8585216;BA.debugLine="Sub cpBarraColor_ColorChanged(color As Int)";
RDebugUtils.currentLine=8585217;
 //BA.debugLineNum = 8585217;BA.debugLine="lblFondoMonto.Color = color";
mostCurrent._lblfondomonto.setColor(_color);
RDebugUtils.currentLine=8585218;
 //BA.debugLineNum = 8585218;BA.debugLine="colorCaja = color";
_colorcaja = _color;
RDebugUtils.currentLine=8585219;
 //BA.debugLineNum = 8585219;BA.debugLine="End Sub";
return "";
}
public static String  _limitarlongitudentrada(String _antiguo,String _nuevo,int _longitud,anywheresoftware.b4a.objects.B4XViewWrapper _view,String _campo) throws Exception{
RDebugUtils.currentModule="editarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "limitarlongitudentrada", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "limitarlongitudentrada", new Object[] {_antiguo,_nuevo,_longitud,_view,_campo}));}
RDebugUtils.currentLine=8650752;
 //BA.debugLineNum = 8650752;BA.debugLine="Sub limitarLongitudEntrada(antiguo As String, nuev";
RDebugUtils.currentLine=8650753;
 //BA.debugLineNum = 8650753;BA.debugLine="If(nuevo.Length > longitud) Then";
if ((_nuevo.length()>_longitud)) { 
RDebugUtils.currentLine=8650754;
 //BA.debugLineNum = 8650754;BA.debugLine="If(campo = \"monto\") Then";
if (((_campo).equals("monto"))) { 
RDebugUtils.currentLine=8650755;
 //BA.debugLineNum = 8650755;BA.debugLine="If(aparicionMsgBox1 = False) Then";
if ((_aparicionmsgbox1==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=8650756;
 //BA.debugLineNum = 8650756;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para el monto es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=8650757;
 //BA.debugLineNum = 8650757;BA.debugLine="aparicionMsgBox1 = True";
_aparicionmsgbox1 = anywheresoftware.b4a.keywords.Common.True;
 };
 }else 
{RDebugUtils.currentLine=8650759;
 //BA.debugLineNum = 8650759;BA.debugLine="Else If(campo = \"nombre\") Then";
if (((_campo).equals("nombre"))) { 
RDebugUtils.currentLine=8650760;
 //BA.debugLineNum = 8650760;BA.debugLine="If(aparicionMsgBox2 = False) Then";
if ((_aparicionmsgbox2==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=8650761;
 //BA.debugLineNum = 8650761;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para el nombre es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=8650762;
 //BA.debugLineNum = 8650762;BA.debugLine="aparicionMsgBox2 = True";
_aparicionmsgbox2 = anywheresoftware.b4a.keywords.Common.True;
 };
 }else 
{RDebugUtils.currentLine=8650764;
 //BA.debugLineNum = 8650764;BA.debugLine="Else If(campo = \"descripcion\") Then";
if (((_campo).equals("descripcion"))) { 
RDebugUtils.currentLine=8650765;
 //BA.debugLineNum = 8650765;BA.debugLine="If(aparicionMsgBox3 = False) Then";
if ((_aparicionmsgbox3==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=8650766;
 //BA.debugLineNum = 8650766;BA.debugLine="Msgbox2(\"La longitud máxima permitida para la";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para la descripción es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=8650767;
 //BA.debugLineNum = 8650767;BA.debugLine="aparicionMsgBox3 = True";
_aparicionmsgbox3 = anywheresoftware.b4a.keywords.Common.True;
 };
 }}}
;
RDebugUtils.currentLine=8650770;
 //BA.debugLineNum = 8650770;BA.debugLine="view.Text = antiguo";
_view.setText(BA.ObjectToCharSequence(_antiguo));
 };
RDebugUtils.currentLine=8650772;
 //BA.debugLineNum = 8650772;BA.debugLine="End Sub";
return "";
}
public static String  _rd1ano_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="editarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd1ano_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd1ano_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=9175040;
 //BA.debugLineNum = 9175040;BA.debugLine="Private Sub rd1Ano_CheckedChange(Checked As Boolea";
RDebugUtils.currentLine=9175041;
 //BA.debugLineNum = 9175041;BA.debugLine="diasPeriodo = 365";
_diasperiodo = (int) (365);
RDebugUtils.currentLine=9175042;
 //BA.debugLineNum = 9175042;BA.debugLine="End Sub";
return "";
}
public static String  _rd1mes_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="editarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd1mes_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd1mes_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=9109504;
 //BA.debugLineNum = 9109504;BA.debugLine="Private Sub rd1Mes_CheckedChange(Checked As Boolea";
RDebugUtils.currentLine=9109505;
 //BA.debugLineNum = 9109505;BA.debugLine="diasPeriodo = 30";
_diasperiodo = (int) (30);
RDebugUtils.currentLine=9109506;
 //BA.debugLineNum = 9109506;BA.debugLine="End Sub";
return "";
}
public static String  _rd1semana_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="editarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd1semana_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd1semana_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=9043968;
 //BA.debugLineNum = 9043968;BA.debugLine="Private Sub rd1Semana_CheckedChange(Checked As Boo";
RDebugUtils.currentLine=9043969;
 //BA.debugLineNum = 9043969;BA.debugLine="diasPeriodo = 7";
_diasperiodo = (int) (7);
RDebugUtils.currentLine=9043970;
 //BA.debugLineNum = 9043970;BA.debugLine="End Sub";
return "";
}
public static String  _rd2semanas_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="editarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd2semanas_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd2semanas_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=8978432;
 //BA.debugLineNum = 8978432;BA.debugLine="Private Sub rd2Semanas_CheckedChange(Checked As Bo";
RDebugUtils.currentLine=8978433;
 //BA.debugLineNum = 8978433;BA.debugLine="diasPeriodo = 14";
_diasperiodo = (int) (14);
RDebugUtils.currentLine=8978434;
 //BA.debugLineNum = 8978434;BA.debugLine="End Sub";
return "";
}
public static String  _rd3semanas_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="editarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd3semanas_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd3semanas_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=8912896;
 //BA.debugLineNum = 8912896;BA.debugLine="Private Sub rd3Semanas_CheckedChange(Checked As Bo";
RDebugUtils.currentLine=8912897;
 //BA.debugLineNum = 8912897;BA.debugLine="diasPeriodo = 21";
_diasperiodo = (int) (21);
RDebugUtils.currentLine=8912898;
 //BA.debugLineNum = 8912898;BA.debugLine="End Sub";
return "";
}
public static String  _txtdescripcion_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="editarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtdescripcion_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtdescripcion_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=8847360;
 //BA.debugLineNum = 8847360;BA.debugLine="Private Sub txtDescripcion_TextChanged (Old As Str";
RDebugUtils.currentLine=8847361;
 //BA.debugLineNum = 8847361;BA.debugLine="limitarLongitudEntrada(Old, New, 41, txtDescripci";
_limitarlongitudentrada(_old,_new,(int) (41),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtdescripcion.getObject())),"descripcion");
RDebugUtils.currentLine=8847362;
 //BA.debugLineNum = 8847362;BA.debugLine="End Sub";
return "";
}
public static String  _txtmonto_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="editarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtmonto_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtmonto_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=8716288;
 //BA.debugLineNum = 8716288;BA.debugLine="Private Sub txtMonto_TextChanged (Old As String, N";
RDebugUtils.currentLine=8716289;
 //BA.debugLineNum = 8716289;BA.debugLine="limitarLongitudEntrada(Old, New, 9, txtMonto, \"mo";
_limitarlongitudentrada(_old,_new,(int) (9),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtmonto.getObject())),"monto");
RDebugUtils.currentLine=8716290;
 //BA.debugLineNum = 8716290;BA.debugLine="End Sub";
return "";
}
public static String  _txtnombre_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="editarsuscripcion";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtnombre_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtnombre_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=8781824;
 //BA.debugLineNum = 8781824;BA.debugLine="Private Sub txtNombre_TextChanged (Old As String,";
RDebugUtils.currentLine=8781825;
 //BA.debugLineNum = 8781825;BA.debugLine="limitarLongitudEntrada(Old, New, 16, txtNombre, \"";
_limitarlongitudentrada(_old,_new,(int) (16),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtnombre.getObject())),"nombre");
RDebugUtils.currentLine=8781826;
 //BA.debugLineNum = 8781826;BA.debugLine="End Sub";
return "";
}
}