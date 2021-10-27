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

public class registrarmetaahorro extends Activity implements B4AActivity{
	public static registrarmetaahorro mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "pullup.wallet", "pullup.wallet.registrarmetaahorro");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (registrarmetaahorro).");
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
		activityBA = new BA(this, layout, processBA, "pullup.wallet", "pullup.wallet.registrarmetaahorro");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "pullup.wallet.registrarmetaahorro", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (registrarmetaahorro) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (registrarmetaahorro) Resume **");
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
		return registrarmetaahorro.class;
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
            BA.LogInfo("** Activity (registrarmetaahorro) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (registrarmetaahorro) Pause event (activity is not paused). **");
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
            registrarmetaahorro mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (registrarmetaahorro) Resume **");
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
public static boolean _aparicionmsgbox4 = false;
public anywheresoftware.b4a.objects.StringUtils _stu = null;
public anywheresoftware.b4a.sql.SQL.CursorWrapper _cur = null;
public static int _egresosactuales = 0;
public anywheresoftware.b4a.objects.ButtonWrapper _btnmenu = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnoperacionmetaahorro = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtdescripcion = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtnombre = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtmetaahorro = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtmontoahorro = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblfondodescripcion = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblfondonombre = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblfondometaahorro = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblfondomontoahorro = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblcontornoboton = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblnombrevista = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblmetaahorrotitulo = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblmontoahorrotitulo = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlnavinferior = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlperiodos = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlselector = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _rd1ano = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _rd1mes = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _rd1semana = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _rd2semanas = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _rd3semanas = null;
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
public pullup.wallet.registrarsuscripcion _registrarsuscripcion = null;
public pullup.wallet.suscripciones _suscripciones = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="registrarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=15269888;
 //BA.debugLineNum = 15269888;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=15269889;
 //BA.debugLineNum = 15269889;BA.debugLine="Activity.LoadLayout(\"LFormMetaAhorro\")";
mostCurrent._activity.LoadLayout("LFormMetaAhorro",mostCurrent.activityBA);
RDebugUtils.currentLine=15269890;
 //BA.debugLineNum = 15269890;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
_alturadispositivo = mostCurrent._main._alturadispositivo /*int*/ ;
RDebugUtils.currentLine=15269891;
 //BA.debugLineNum = 15269891;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
_anchodispositivo = mostCurrent._main._anchodispositivo /*int*/ ;
RDebugUtils.currentLine=15269892;
 //BA.debugLineNum = 15269892;BA.debugLine="sql = Starter.sql";
_sql = mostCurrent._starter._sql /*anywheresoftware.b4a.sql.SQL*/ ;
RDebugUtils.currentLine=15269893;
 //BA.debugLineNum = 15269893;BA.debugLine="aparicionMsgBox1 = False";
_aparicionmsgbox1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=15269894;
 //BA.debugLineNum = 15269894;BA.debugLine="aparicionMsgBox2 = False";
_aparicionmsgbox2 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=15269895;
 //BA.debugLineNum = 15269895;BA.debugLine="aparicionMsgBox3 = False";
_aparicionmsgbox3 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=15269896;
 //BA.debugLineNum = 15269896;BA.debugLine="aparicionMsgBox4 = False";
_aparicionmsgbox4 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=15269897;
 //BA.debugLineNum = 15269897;BA.debugLine="diasPeriodo = 7";
_diasperiodo = (int) (7);
RDebugUtils.currentLine=15269898;
 //BA.debugLineNum = 15269898;BA.debugLine="colorCaja = 0";
_colorcaja = (int) (0);
RDebugUtils.currentLine=15269901;
 //BA.debugLineNum = 15269901;BA.debugLine="lblNombreVista.TextSize = 20";
mostCurrent._lblnombrevista.setTextSize((float) (20));
RDebugUtils.currentLine=15269902;
 //BA.debugLineNum = 15269902;BA.debugLine="lblNombreVista.TextColor = Colors.Black";
mostCurrent._lblnombrevista.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=15269903;
 //BA.debugLineNum = 15269903;BA.debugLine="lblNombreVista.Height = 30dip";
mostCurrent._lblnombrevista.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=15269904;
 //BA.debugLineNum = 15269904;BA.debugLine="lblNombreVista.Width = anchoDispositivo * 0.9";
mostCurrent._lblnombrevista.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=15269905;
 //BA.debugLineNum = 15269905;BA.debugLine="lblNombreVista.Top = 30dip";
mostCurrent._lblnombrevista.setTop(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=15269906;
 //BA.debugLineNum = 15269906;BA.debugLine="lblNombreVista.Left = (anchoDispositivo - lblNomb";
mostCurrent._lblnombrevista.setLeft((int) ((_anchodispositivo-mostCurrent._lblnombrevista.getWidth())/(double)2));
RDebugUtils.currentLine=15269908;
 //BA.debugLineNum = 15269908;BA.debugLine="txtMetaAhorro.Width = anchoDispositivo * 0.9";
mostCurrent._txtmetaahorro.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=15269909;
 //BA.debugLineNum = 15269909;BA.debugLine="txtMetaAhorro.Height = alturaDispositivo * 0.14";
mostCurrent._txtmetaahorro.setHeight((int) (_alturadispositivo*0.14));
RDebugUtils.currentLine=15269910;
 //BA.debugLineNum = 15269910;BA.debugLine="txtMetaAhorro.Top = lblNombreVista.Top * 1.5 + lb";
mostCurrent._txtmetaahorro.setTop((int) (mostCurrent._lblnombrevista.getTop()*1.5+mostCurrent._lblnombrevista.getHeight()));
RDebugUtils.currentLine=15269911;
 //BA.debugLineNum = 15269911;BA.debugLine="txtMetaAhorro.Left = (anchoDispositivo - txtMetaA";
mostCurrent._txtmetaahorro.setLeft((int) ((_anchodispositivo-mostCurrent._txtmetaahorro.getWidth())/(double)2));
RDebugUtils.currentLine=15269912;
 //BA.debugLineNum = 15269912;BA.debugLine="lblFondoMetaAhorro.Width = txtMetaAhorro.Width";
mostCurrent._lblfondometaahorro.setWidth(mostCurrent._txtmetaahorro.getWidth());
RDebugUtils.currentLine=15269913;
 //BA.debugLineNum = 15269913;BA.debugLine="lblFondoMetaAhorro.Height = txtMetaAhorro.Height";
mostCurrent._lblfondometaahorro.setHeight(mostCurrent._txtmetaahorro.getHeight());
RDebugUtils.currentLine=15269914;
 //BA.debugLineNum = 15269914;BA.debugLine="lblFondoMetaAhorro.Top = txtMetaAhorro.Top";
mostCurrent._lblfondometaahorro.setTop(mostCurrent._txtmetaahorro.getTop());
RDebugUtils.currentLine=15269915;
 //BA.debugLineNum = 15269915;BA.debugLine="lblFondoMetaAhorro.Left = txtMetaAhorro.Left";
mostCurrent._lblfondometaahorro.setLeft(mostCurrent._txtmetaahorro.getLeft());
RDebugUtils.currentLine=15269917;
 //BA.debugLineNum = 15269917;BA.debugLine="lblMetaAhorroTitulo.Width = lblFondoMetaAhorro.Wi";
mostCurrent._lblmetaahorrotitulo.setWidth((int) (mostCurrent._lblfondometaahorro.getWidth()*0.9));
RDebugUtils.currentLine=15269918;
 //BA.debugLineNum = 15269918;BA.debugLine="lblMetaAhorroTitulo.Height = stu.MeasureMultiline";
mostCurrent._lblmetaahorrotitulo.setHeight((int) (mostCurrent._stu.MeasureMultilineTextHeight((android.widget.TextView)(mostCurrent._lblmetaahorrotitulo.getObject()),BA.ObjectToCharSequence(mostCurrent._lblmetaahorrotitulo.getText()))+2));
RDebugUtils.currentLine=15269919;
 //BA.debugLineNum = 15269919;BA.debugLine="lblMetaAhorroTitulo.Top = lblFondoMetaAhorro.Top";
mostCurrent._lblmetaahorrotitulo.setTop((int) (mostCurrent._lblfondometaahorro.getTop()+mostCurrent._lblfondometaahorro.getHeight()*0.05));
RDebugUtils.currentLine=15269920;
 //BA.debugLineNum = 15269920;BA.debugLine="lblMetaAhorroTitulo.Left = lblFondoMetaAhorro.Lef";
mostCurrent._lblmetaahorrotitulo.setLeft((int) (mostCurrent._lblfondometaahorro.getLeft()+mostCurrent._lblfondomontoahorro.getHeight()*0.1));
RDebugUtils.currentLine=15269921;
 //BA.debugLineNum = 15269921;BA.debugLine="lblMetaAhorroTitulo.Gravity = Gravity.CENTER_VERT";
mostCurrent._lblmetaahorrotitulo.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=15269923;
 //BA.debugLineNum = 15269923;BA.debugLine="txtNombre.Width = anchoDispositivo * 0.9";
mostCurrent._txtnombre.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=15269924;
 //BA.debugLineNum = 15269924;BA.debugLine="txtNombre.Height = alturaDispositivo * 0.06";
mostCurrent._txtnombre.setHeight((int) (_alturadispositivo*0.06));
RDebugUtils.currentLine=15269925;
 //BA.debugLineNum = 15269925;BA.debugLine="txtNombre.Top = txtMetaAhorro.Top + txtMetaAhorro";
mostCurrent._txtnombre.setTop((int) (mostCurrent._txtmetaahorro.getTop()+mostCurrent._txtmetaahorro.getHeight()+mostCurrent._lblnombrevista.getTop()/(double)2));
RDebugUtils.currentLine=15269926;
 //BA.debugLineNum = 15269926;BA.debugLine="txtNombre.Left = (anchoDispositivo - txtNombre.Wi";
mostCurrent._txtnombre.setLeft((int) ((_anchodispositivo-mostCurrent._txtnombre.getWidth())/(double)2));
RDebugUtils.currentLine=15269927;
 //BA.debugLineNum = 15269927;BA.debugLine="lblFondoNombre.Width = txtMetaAhorro.Width";
mostCurrent._lblfondonombre.setWidth(mostCurrent._txtmetaahorro.getWidth());
RDebugUtils.currentLine=15269928;
 //BA.debugLineNum = 15269928;BA.debugLine="lblFondoNombre.Height = txtNombre.Height";
mostCurrent._lblfondonombre.setHeight(mostCurrent._txtnombre.getHeight());
RDebugUtils.currentLine=15269929;
 //BA.debugLineNum = 15269929;BA.debugLine="lblFondoNombre.Top = txtNombre.Top";
mostCurrent._lblfondonombre.setTop(mostCurrent._txtnombre.getTop());
RDebugUtils.currentLine=15269930;
 //BA.debugLineNum = 15269930;BA.debugLine="lblFondoNombre.Left = txtNombre.Left";
mostCurrent._lblfondonombre.setLeft(mostCurrent._txtnombre.getLeft());
RDebugUtils.currentLine=15269932;
 //BA.debugLineNum = 15269932;BA.debugLine="txtDescripcion.Width = txtNombre.Width";
mostCurrent._txtdescripcion.setWidth(mostCurrent._txtnombre.getWidth());
RDebugUtils.currentLine=15269933;
 //BA.debugLineNum = 15269933;BA.debugLine="txtDescripcion.Height = txtNombre.Height";
mostCurrent._txtdescripcion.setHeight(mostCurrent._txtnombre.getHeight());
RDebugUtils.currentLine=15269934;
 //BA.debugLineNum = 15269934;BA.debugLine="txtDescripcion.Top = txtNombre.Top + txtNombre.He";
mostCurrent._txtdescripcion.setTop((int) (mostCurrent._txtnombre.getTop()+mostCurrent._txtnombre.getHeight()+mostCurrent._lblnombrevista.getTop()/(double)2));
RDebugUtils.currentLine=15269935;
 //BA.debugLineNum = 15269935;BA.debugLine="txtDescripcion.Left = txtNombre.Left";
mostCurrent._txtdescripcion.setLeft(mostCurrent._txtnombre.getLeft());
RDebugUtils.currentLine=15269936;
 //BA.debugLineNum = 15269936;BA.debugLine="lblFondoDescripcion.Width = txtDescripcion.Width";
mostCurrent._lblfondodescripcion.setWidth(mostCurrent._txtdescripcion.getWidth());
RDebugUtils.currentLine=15269937;
 //BA.debugLineNum = 15269937;BA.debugLine="lblFondoDescripcion.Height = txtDescripcion.Heigh";
mostCurrent._lblfondodescripcion.setHeight(mostCurrent._txtdescripcion.getHeight());
RDebugUtils.currentLine=15269938;
 //BA.debugLineNum = 15269938;BA.debugLine="lblFondoDescripcion.Top = txtDescripcion.Top";
mostCurrent._lblfondodescripcion.setTop(mostCurrent._txtdescripcion.getTop());
RDebugUtils.currentLine=15269939;
 //BA.debugLineNum = 15269939;BA.debugLine="lblFondoDescripcion.Left = txtDescripcion.Left";
mostCurrent._lblfondodescripcion.setLeft(mostCurrent._txtdescripcion.getLeft());
RDebugUtils.currentLine=15269941;
 //BA.debugLineNum = 15269941;BA.debugLine="txtMontoAhorro.Width = txtMetaAhorro.Width";
mostCurrent._txtmontoahorro.setWidth(mostCurrent._txtmetaahorro.getWidth());
RDebugUtils.currentLine=15269942;
 //BA.debugLineNum = 15269942;BA.debugLine="txtMontoAhorro.Height = txtMetaAhorro.Height";
mostCurrent._txtmontoahorro.setHeight(mostCurrent._txtmetaahorro.getHeight());
RDebugUtils.currentLine=15269943;
 //BA.debugLineNum = 15269943;BA.debugLine="txtMontoAhorro.Top = txtDescripcion.Top + txtDesc";
mostCurrent._txtmontoahorro.setTop((int) (mostCurrent._txtdescripcion.getTop()+mostCurrent._txtdescripcion.getHeight()+mostCurrent._lblnombrevista.getTop()/(double)2));
RDebugUtils.currentLine=15269944;
 //BA.debugLineNum = 15269944;BA.debugLine="txtMontoAhorro.Left = txtNombre.Left";
mostCurrent._txtmontoahorro.setLeft(mostCurrent._txtnombre.getLeft());
RDebugUtils.currentLine=15269945;
 //BA.debugLineNum = 15269945;BA.debugLine="lblFondoMontoAhorro.Width = txtMontoAhorro.Width";
mostCurrent._lblfondomontoahorro.setWidth(mostCurrent._txtmontoahorro.getWidth());
RDebugUtils.currentLine=15269946;
 //BA.debugLineNum = 15269946;BA.debugLine="lblFondoMontoAhorro.Height = txtMontoAhorro.Heigh";
mostCurrent._lblfondomontoahorro.setHeight(mostCurrent._txtmontoahorro.getHeight());
RDebugUtils.currentLine=15269947;
 //BA.debugLineNum = 15269947;BA.debugLine="lblFondoMontoAhorro.Top = txtMontoAhorro.Top";
mostCurrent._lblfondomontoahorro.setTop(mostCurrent._txtmontoahorro.getTop());
RDebugUtils.currentLine=15269948;
 //BA.debugLineNum = 15269948;BA.debugLine="lblFondoMontoAhorro.Left = txtMontoAhorro.Left";
mostCurrent._lblfondomontoahorro.setLeft(mostCurrent._txtmontoahorro.getLeft());
RDebugUtils.currentLine=15269950;
 //BA.debugLineNum = 15269950;BA.debugLine="lblMontoAhorroTitulo.Width = lblFondoMontoAhorro.";
mostCurrent._lblmontoahorrotitulo.setWidth((int) (mostCurrent._lblfondomontoahorro.getWidth()*0.9));
RDebugUtils.currentLine=15269951;
 //BA.debugLineNum = 15269951;BA.debugLine="lblMontoAhorroTitulo.Height = stu.MeasureMultilin";
mostCurrent._lblmontoahorrotitulo.setHeight((int) (mostCurrent._stu.MeasureMultilineTextHeight((android.widget.TextView)(mostCurrent._lblmontoahorrotitulo.getObject()),BA.ObjectToCharSequence(mostCurrent._lblmontoahorrotitulo.getText()))+2));
RDebugUtils.currentLine=15269952;
 //BA.debugLineNum = 15269952;BA.debugLine="lblMontoAhorroTitulo.Top = lblFondoMontoAhorro.To";
mostCurrent._lblmontoahorrotitulo.setTop((int) (mostCurrent._lblfondomontoahorro.getTop()+mostCurrent._lblfondomontoahorro.getHeight()*0.05));
RDebugUtils.currentLine=15269953;
 //BA.debugLineNum = 15269953;BA.debugLine="lblMontoAhorroTitulo.Left = lblFondoMontoAhorro.L";
mostCurrent._lblmontoahorrotitulo.setLeft((int) (mostCurrent._lblfondomontoahorro.getLeft()+mostCurrent._lblfondomontoahorro.getHeight()*0.1));
RDebugUtils.currentLine=15269954;
 //BA.debugLineNum = 15269954;BA.debugLine="lblMontoAhorroTitulo.Gravity = Gravity.CENTER_VER";
mostCurrent._lblmontoahorrotitulo.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=15269956;
 //BA.debugLineNum = 15269956;BA.debugLine="pnlSelector.Top = txtMontoAhorro.Top + txtMontoAh";
mostCurrent._pnlselector.setTop((int) (mostCurrent._txtmontoahorro.getTop()+mostCurrent._txtmontoahorro.getHeight()+mostCurrent._lblnombrevista.getTop()/(double)2));
RDebugUtils.currentLine=15269957;
 //BA.debugLineNum = 15269957;BA.debugLine="pnlSelector.Left = txtMontoAhorro.Left + txtMonto";
mostCurrent._pnlselector.setLeft((int) (mostCurrent._txtmontoahorro.getLeft()+mostCurrent._txtmontoahorro.getWidth()-mostCurrent._pnlselector.getWidth()));
RDebugUtils.currentLine=15269959;
 //BA.debugLineNum = 15269959;BA.debugLine="pnlPeriodos.Top = pnlSelector.Top";
mostCurrent._pnlperiodos.setTop(mostCurrent._pnlselector.getTop());
RDebugUtils.currentLine=15269960;
 //BA.debugLineNum = 15269960;BA.debugLine="pnlPeriodos.Left = txtMontoAhorro.Left";
mostCurrent._pnlperiodos.setLeft(mostCurrent._txtmontoahorro.getLeft());
RDebugUtils.currentLine=15269961;
 //BA.debugLineNum = 15269961;BA.debugLine="pnlPeriodos.Width = (txtMontoAhorro.Width - pnlSe";
mostCurrent._pnlperiodos.setWidth((int) ((mostCurrent._txtmontoahorro.getWidth()-mostCurrent._pnlselector.getWidth())*0.9));
RDebugUtils.currentLine=15269962;
 //BA.debugLineNum = 15269962;BA.debugLine="pnlPeriodos.Height = pnlSelector.Height";
mostCurrent._pnlperiodos.setHeight(mostCurrent._pnlselector.getHeight());
RDebugUtils.currentLine=15269965;
 //BA.debugLineNum = 15269965;BA.debugLine="rd1Semana.Width = pnlPeriodos.Width";
mostCurrent._rd1semana.setWidth(mostCurrent._pnlperiodos.getWidth());
RDebugUtils.currentLine=15269966;
 //BA.debugLineNum = 15269966;BA.debugLine="rd1Semana.Height = pnlPeriodos.Height * 0.18";
mostCurrent._rd1semana.setHeight((int) (mostCurrent._pnlperiodos.getHeight()*0.18));
RDebugUtils.currentLine=15269967;
 //BA.debugLineNum = 15269967;BA.debugLine="rd1Semana.Left = 0";
mostCurrent._rd1semana.setLeft((int) (0));
RDebugUtils.currentLine=15269968;
 //BA.debugLineNum = 15269968;BA.debugLine="rd1Semana.Top = 0";
mostCurrent._rd1semana.setTop((int) (0));
RDebugUtils.currentLine=15269970;
 //BA.debugLineNum = 15269970;BA.debugLine="rd2Semanas.Width = rd1Semana.Width";
mostCurrent._rd2semanas.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=15269971;
 //BA.debugLineNum = 15269971;BA.debugLine="rd2Semanas.Height = rd1Semana.Height";
mostCurrent._rd2semanas.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=15269972;
 //BA.debugLineNum = 15269972;BA.debugLine="rd2Semanas.Left = rd1Semana.Left";
mostCurrent._rd2semanas.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=15269973;
 //BA.debugLineNum = 15269973;BA.debugLine="rd2Semanas.Top = rd1Semana.Height + pnlPeriodos.H";
mostCurrent._rd2semanas.setTop((int) (mostCurrent._rd1semana.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=15269975;
 //BA.debugLineNum = 15269975;BA.debugLine="rd3Semanas.Width = rd1Semana.Width";
mostCurrent._rd3semanas.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=15269976;
 //BA.debugLineNum = 15269976;BA.debugLine="rd3Semanas.Height = rd1Semana.Height";
mostCurrent._rd3semanas.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=15269977;
 //BA.debugLineNum = 15269977;BA.debugLine="rd3Semanas.Left = rd1Semana.Left";
mostCurrent._rd3semanas.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=15269978;
 //BA.debugLineNum = 15269978;BA.debugLine="rd3Semanas.Top = rd2Semanas.Top + rd2Semanas.Heig";
mostCurrent._rd3semanas.setTop((int) (mostCurrent._rd2semanas.getTop()+mostCurrent._rd2semanas.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=15269980;
 //BA.debugLineNum = 15269980;BA.debugLine="rd1Mes.Width = rd1Semana.Width";
mostCurrent._rd1mes.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=15269981;
 //BA.debugLineNum = 15269981;BA.debugLine="rd1Mes.Height = rd1Semana.Height";
mostCurrent._rd1mes.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=15269982;
 //BA.debugLineNum = 15269982;BA.debugLine="rd1Mes.Left = rd1Semana.Left";
mostCurrent._rd1mes.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=15269983;
 //BA.debugLineNum = 15269983;BA.debugLine="rd1Mes.Top = rd3Semanas.Top + rd3Semanas.Height +";
mostCurrent._rd1mes.setTop((int) (mostCurrent._rd3semanas.getTop()+mostCurrent._rd3semanas.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=15269985;
 //BA.debugLineNum = 15269985;BA.debugLine="rd1Ano.Width = rd1Semana.Width";
mostCurrent._rd1ano.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=15269986;
 //BA.debugLineNum = 15269986;BA.debugLine="rd1Ano.Height = rd1Semana.Height";
mostCurrent._rd1ano.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=15269987;
 //BA.debugLineNum = 15269987;BA.debugLine="rd1Ano.Left = rd1Semana.Left";
mostCurrent._rd1ano.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=15269988;
 //BA.debugLineNum = 15269988;BA.debugLine="rd1Ano.Top = rd1Mes.Top + rd1Mes.Height + pnlPeri";
mostCurrent._rd1ano.setTop((int) (mostCurrent._rd1mes.getTop()+mostCurrent._rd1mes.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=15269993;
 //BA.debugLineNum = 15269993;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
mostCurrent._pnlnavinferior.setHeight((int) (_alturadispositivo*0.08));
RDebugUtils.currentLine=15269994;
 //BA.debugLineNum = 15269994;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
mostCurrent._pnlnavinferior.setWidth(_anchodispositivo);
RDebugUtils.currentLine=15269995;
 //BA.debugLineNum = 15269995;BA.debugLine="pnlNavInferior.Left = 0";
mostCurrent._pnlnavinferior.setLeft((int) (0));
RDebugUtils.currentLine=15269996;
 //BA.debugLineNum = 15269996;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
mostCurrent._pnlnavinferior.setTop((int) (_alturadispositivo-mostCurrent._pnlnavinferior.getHeight()));
RDebugUtils.currentLine=15269999;
 //BA.debugLineNum = 15269999;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
mostCurrent._btnmenu.setWidth((int) (_anchodispositivo*0.15));
RDebugUtils.currentLine=15270000;
 //BA.debugLineNum = 15270000;BA.debugLine="btnMenu.Height = btnMenu.Width";
mostCurrent._btnmenu.setHeight(mostCurrent._btnmenu.getWidth());
RDebugUtils.currentLine=15270001;
 //BA.debugLineNum = 15270001;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
mostCurrent._btnmenu.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._btnmenu.getHeight()/(double)2));
RDebugUtils.currentLine=15270002;
 //BA.debugLineNum = 15270002;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
mostCurrent._btnmenu.setLeft((int) ((_anchodispositivo-mostCurrent._btnmenu.getWidth())/(double)2));
RDebugUtils.currentLine=15270004;
 //BA.debugLineNum = 15270004;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
mostCurrent._lblcontornoboton.setWidth((int) (_anchodispositivo*0.17));
RDebugUtils.currentLine=15270005;
 //BA.debugLineNum = 15270005;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
mostCurrent._lblcontornoboton.setHeight(mostCurrent._lblcontornoboton.getWidth());
RDebugUtils.currentLine=15270006;
 //BA.debugLineNum = 15270006;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
mostCurrent._lblcontornoboton.setLeft((int) ((_anchodispositivo-mostCurrent._lblcontornoboton.getWidth())/(double)2));
RDebugUtils.currentLine=15270007;
 //BA.debugLineNum = 15270007;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
mostCurrent._lblcontornoboton.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._lblcontornoboton.getHeight()/(double)2));
RDebugUtils.currentLine=15270012;
 //BA.debugLineNum = 15270012;BA.debugLine="btnOperacionMetaAhorro.Text = \"Guardar meta de ah";
mostCurrent._btnoperacionmetaahorro.setText(BA.ObjectToCharSequence("Guardar meta de ahorro"));
RDebugUtils.currentLine=15270013;
 //BA.debugLineNum = 15270013;BA.debugLine="btnOperacionMetaAhorro.Top = pnlPeriodos.Top + pn";
mostCurrent._btnoperacionmetaahorro.setTop((int) (mostCurrent._pnlperiodos.getTop()+mostCurrent._pnlperiodos.getHeight()+(mostCurrent._lblcontornoboton.getTop()-(mostCurrent._pnlperiodos.getTop()+mostCurrent._pnlperiodos.getHeight()+mostCurrent._btnoperacionmetaahorro.getHeight()))/(double)2));
RDebugUtils.currentLine=15270014;
 //BA.debugLineNum = 15270014;BA.debugLine="btnOperacionMetaAhorro.Left = (anchoDispositivo -";
mostCurrent._btnoperacionmetaahorro.setLeft((int) ((_anchodispositivo-mostCurrent._btnoperacionmetaahorro.getWidth())/(double)2));
RDebugUtils.currentLine=15270015;
 //BA.debugLineNum = 15270015;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="registrarmetaahorro";
RDebugUtils.currentLine=15400960;
 //BA.debugLineNum = 15400960;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=15400961;
 //BA.debugLineNum = 15400961;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="registrarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=15335424;
 //BA.debugLineNum = 15335424;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=15335425;
 //BA.debugLineNum = 15335425;BA.debugLine="End Sub";
return "";
}
public static pullup.wallet.main._registrometaahorro  _asignacioncampos() throws Exception{
RDebugUtils.currentModule="registrarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "asignacioncampos", false))
	 {return ((pullup.wallet.main._registrometaahorro) Debug.delegate(mostCurrent.activityBA, "asignacioncampos", null));}
pullup.wallet.main._registrometaahorro _metaahorro = null;
RDebugUtils.currentLine=16449536;
 //BA.debugLineNum = 16449536;BA.debugLine="Sub asignacionCampos As RegistroMetaAhorro";
RDebugUtils.currentLine=16449537;
 //BA.debugLineNum = 16449537;BA.debugLine="Dim metaAhorro As RegistroMetaAhorro";
_metaahorro = new pullup.wallet.main._registrometaahorro();
RDebugUtils.currentLine=16449539;
 //BA.debugLineNum = 16449539;BA.debugLine="metaAhorro.montoMeta = txtMetaAhorro.Text";
_metaahorro.montoMeta /*int*/  = (int)(Double.parseDouble(mostCurrent._txtmetaahorro.getText()));
RDebugUtils.currentLine=16449541;
 //BA.debugLineNum = 16449541;BA.debugLine="metaAhorro.montoAhorro = txtMontoAhorro.Text";
_metaahorro.montoAhorro /*int*/  = (int)(Double.parseDouble(mostCurrent._txtmontoahorro.getText()));
RDebugUtils.currentLine=16449543;
 //BA.debugLineNum = 16449543;BA.debugLine="metaAhorro.nombre = txtNombre.Text";
_metaahorro.nombre /*String*/  = mostCurrent._txtnombre.getText();
RDebugUtils.currentLine=16449545;
 //BA.debugLineNum = 16449545;BA.debugLine="metaAhorro.descripcion = (txtDescripcion.Text)";
_metaahorro.descripcion /*String*/  = (mostCurrent._txtdescripcion.getText());
RDebugUtils.currentLine=16449547;
 //BA.debugLineNum = 16449547;BA.debugLine="metaAhorro.periodo = diasPeriodo";
_metaahorro.periodo /*int*/  = _diasperiodo;
RDebugUtils.currentLine=16449549;
 //BA.debugLineNum = 16449549;BA.debugLine="metaAhorro.progreso = txtMontoAhorro.Text";
_metaahorro.progreso /*int*/  = (int)(Double.parseDouble(mostCurrent._txtmontoahorro.getText()));
RDebugUtils.currentLine=16449551;
 //BA.debugLineNum = 16449551;BA.debugLine="metaAhorro.fechaPago = fechaMasPeriodo(metaAhorro";
_metaahorro.fechaPago /*String*/  = _fechamasperiodo(_metaahorro.periodo /*int*/ );
RDebugUtils.currentLine=16449553;
 //BA.debugLineNum = 16449553;BA.debugLine="metaAhorro.color = colorCaja";
_metaahorro.color /*int*/  = _colorcaja;
RDebugUtils.currentLine=16449555;
 //BA.debugLineNum = 16449555;BA.debugLine="Return metaAhorro";
if (true) return _metaahorro;
RDebugUtils.currentLine=16449556;
 //BA.debugLineNum = 16449556;BA.debugLine="End Sub";
return null;
}
public static String  _fechamasperiodo(int _periodo) throws Exception{
RDebugUtils.currentModule="registrarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fechamasperiodo", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fechamasperiodo", new Object[] {_periodo}));}
String _fechaactual = "";
long _fechaproxima = 0L;
RDebugUtils.currentLine=15728640;
 //BA.debugLineNum = 15728640;BA.debugLine="Sub fechaMasPeriodo(periodo As Int) As String";
RDebugUtils.currentLine=15728641;
 //BA.debugLineNum = 15728641;BA.debugLine="Dim fechaActual As String";
_fechaactual = "";
RDebugUtils.currentLine=15728642;
 //BA.debugLineNum = 15728642;BA.debugLine="Dim fechaProxima As Long";
_fechaproxima = 0L;
RDebugUtils.currentLine=15728644;
 //BA.debugLineNum = 15728644;BA.debugLine="fechaActual = DateTime.Date(obtenerFechaActual)";
_fechaactual = anywheresoftware.b4a.keywords.Common.DateTime.Date(_obtenerfechaactual());
RDebugUtils.currentLine=15728645;
 //BA.debugLineNum = 15728645;BA.debugLine="fechaProxima = DateTime.DateParse(fechaActual)";
_fechaproxima = anywheresoftware.b4a.keywords.Common.DateTime.DateParse(_fechaactual);
RDebugUtils.currentLine=15728646;
 //BA.debugLineNum = 15728646;BA.debugLine="fechaProxima = DateTime.Add(fechaProxima, 0, 0, p";
_fechaproxima = anywheresoftware.b4a.keywords.Common.DateTime.Add(_fechaproxima,(int) (0),(int) (0),_periodo);
RDebugUtils.currentLine=15728648;
 //BA.debugLineNum = 15728648;BA.debugLine="Return DateTime.Date(fechaProxima)";
if (true) return anywheresoftware.b4a.keywords.Common.DateTime.Date(_fechaproxima);
RDebugUtils.currentLine=15728649;
 //BA.debugLineNum = 15728649;BA.debugLine="End Sub";
return "";
}
public static String  _btnmenu_click() throws Exception{
RDebugUtils.currentModule="registrarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnmenu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnmenu_click", null));}
RDebugUtils.currentLine=15466496;
 //BA.debugLineNum = 15466496;BA.debugLine="Private Sub btnMenu_Click";
RDebugUtils.currentLine=15466497;
 //BA.debugLineNum = 15466497;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=15466498;
 //BA.debugLineNum = 15466498;BA.debugLine="End Sub";
return "";
}
public static String  _btnoperacionmetaahorro_click() throws Exception{
RDebugUtils.currentModule="registrarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnoperacionmetaahorro_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnoperacionmetaahorro_click", null));}
boolean _validaciones = false;
pullup.wallet.main._registrometaahorro _metaahorroregistrar = null;
RDebugUtils.currentLine=16515072;
 //BA.debugLineNum = 16515072;BA.debugLine="Private Sub btnOperacionMetaAhorro_Click";
RDebugUtils.currentLine=16515073;
 //BA.debugLineNum = 16515073;BA.debugLine="Dim validaciones As Boolean";
_validaciones = false;
RDebugUtils.currentLine=16515075;
 //BA.debugLineNum = 16515075;BA.debugLine="validaciones = validarCampos";
_validaciones = _validarcampos();
RDebugUtils.currentLine=16515076;
 //BA.debugLineNum = 16515076;BA.debugLine="If(validaciones = True) Then";
if ((_validaciones==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=16515078;
 //BA.debugLineNum = 16515078;BA.debugLine="Dim metaAhorroRegistrar As RegistroMetaAhorro";
_metaahorroregistrar = new pullup.wallet.main._registrometaahorro();
RDebugUtils.currentLine=16515079;
 //BA.debugLineNum = 16515079;BA.debugLine="metaAhorroRegistrar = asignacionCampos";
_metaahorroregistrar = _asignacioncampos();
RDebugUtils.currentLine=16515082;
 //BA.debugLineNum = 16515082;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO metas_ahorro (mon";
_sql.ExecNonQuery2("INSERT INTO metas_ahorro (monto_meta, monto_ahorro, nombre, descripcion, periodo_ahorro, progreso, fecha_pago, color) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_metaahorroregistrar.montoMeta /*int*/ ),(Object)(_metaahorroregistrar.montoAhorro /*int*/ ),(Object)(_metaahorroregistrar.nombre /*String*/ ),(Object)(_metaahorroregistrar.descripcion /*String*/ ),(Object)(_metaahorroregistrar.periodo /*int*/ ),(Object)(_metaahorroregistrar.progreso /*int*/ ),(Object)(_metaahorroregistrar.fechaPago /*String*/ ),(Object)(_metaahorroregistrar.color /*int*/ )}));
RDebugUtils.currentLine=16515086;
 //BA.debugLineNum = 16515086;BA.debugLine="cur = sql.ExecQuery(\"SELECT suma_egresos FROM eg";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT suma_egresos FROM egresos")));
RDebugUtils.currentLine=16515087;
 //BA.debugLineNum = 16515087;BA.debugLine="cur.Position = 0";
mostCurrent._cur.setPosition((int) (0));
RDebugUtils.currentLine=16515088;
 //BA.debugLineNum = 16515088;BA.debugLine="egresosActuales = cur.GetInt(\"suma_egresos\")";
_egresosactuales = mostCurrent._cur.GetInt("suma_egresos");
RDebugUtils.currentLine=16515091;
 //BA.debugLineNum = 16515091;BA.debugLine="sql.ExecNonQuery2(\"UPDATE egresos SET suma_egres";
_sql.ExecNonQuery2("UPDATE egresos SET suma_egresos = ? WHERE id_egreso = 1",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)((_egresosactuales+_metaahorroregistrar.montoAhorro /*int*/ ))}));
RDebugUtils.currentLine=16515093;
 //BA.debugLineNum = 16515093;BA.debugLine="ToastMessageShow(\"Meta de ahorro registrada\", Tr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Meta de ahorro registrada"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=16515095;
 //BA.debugLineNum = 16515095;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=16515097;
 //BA.debugLineNum = 16515097;BA.debugLine="StartActivity(MetasDeAhorro)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._metasdeahorro.getObject()));
 }else {
RDebugUtils.currentLine=16515100;
 //BA.debugLineNum = 16515100;BA.debugLine="Msgbox2(\"Por favor, rellene todos los campos, se";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Por favor, rellene todos los campos, seleccione un periodo y color"),BA.ObjectToCharSequence("Registro incorrecto"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 };
RDebugUtils.currentLine=16515102;
 //BA.debugLineNum = 16515102;BA.debugLine="End Sub";
return "";
}
public static boolean  _validarcampos() throws Exception{
RDebugUtils.currentModule="registrarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "validarcampos", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "validarcampos", null));}
RDebugUtils.currentLine=15532032;
 //BA.debugLineNum = 15532032;BA.debugLine="Sub validarCampos As Boolean";
RDebugUtils.currentLine=15532033;
 //BA.debugLineNum = 15532033;BA.debugLine="If(txtMetaAhorro.Text.Length <> 0 And txtNombre.T";
if ((mostCurrent._txtmetaahorro.getText().length()!=0 && mostCurrent._txtnombre.getText().length()!=0 && mostCurrent._txtmontoahorro.getText().length()!=0 && mostCurrent._txtdescripcion.getText().length()!=0 && _colorcaja!=0 && _diasperiodo!=0)) { 
RDebugUtils.currentLine=15532034;
 //BA.debugLineNum = 15532034;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=15532036;
 //BA.debugLineNum = 15532036;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=15532038;
 //BA.debugLineNum = 15532038;BA.debugLine="End Sub";
return false;
}
public static String  _cpbarracolor_colorchanged(int _color) throws Exception{
RDebugUtils.currentModule="registrarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cpbarracolor_colorchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cpbarracolor_colorchanged", new Object[] {_color}));}
RDebugUtils.currentLine=15597568;
 //BA.debugLineNum = 15597568;BA.debugLine="Private Sub cpBarraColor_ColorChanged(color As Int";
RDebugUtils.currentLine=15597569;
 //BA.debugLineNum = 15597569;BA.debugLine="lblFondoMontoAhorro.Color = color";
mostCurrent._lblfondomontoahorro.setColor(_color);
RDebugUtils.currentLine=15597570;
 //BA.debugLineNum = 15597570;BA.debugLine="lblFondoMetaAhorro.Color = color";
mostCurrent._lblfondometaahorro.setColor(_color);
RDebugUtils.currentLine=15597571;
 //BA.debugLineNum = 15597571;BA.debugLine="colorCaja = color";
_colorcaja = _color;
RDebugUtils.currentLine=15597572;
 //BA.debugLineNum = 15597572;BA.debugLine="End Sub";
return "";
}
public static long  _obtenerfechaactual() throws Exception{
RDebugUtils.currentModule="registrarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "obtenerfechaactual", false))
	 {return ((Long) Debug.delegate(mostCurrent.activityBA, "obtenerfechaactual", null));}
long _ahora = 0L;
RDebugUtils.currentLine=15663104;
 //BA.debugLineNum = 15663104;BA.debugLine="Sub obtenerFechaActual As Long";
RDebugUtils.currentLine=15663105;
 //BA.debugLineNum = 15663105;BA.debugLine="Dim ahora As Long";
_ahora = 0L;
RDebugUtils.currentLine=15663106;
 //BA.debugLineNum = 15663106;BA.debugLine="ahora = DateTime.Now";
_ahora = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
RDebugUtils.currentLine=15663107;
 //BA.debugLineNum = 15663107;BA.debugLine="Return ahora";
if (true) return _ahora;
RDebugUtils.currentLine=15663109;
 //BA.debugLineNum = 15663109;BA.debugLine="End Sub";
return 0L;
}
public static String  _limitarlongitudentrada(String _antiguo,String _nuevo,int _longitud,anywheresoftware.b4a.objects.B4XViewWrapper _view,String _campo) throws Exception{
RDebugUtils.currentModule="registrarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "limitarlongitudentrada", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "limitarlongitudentrada", new Object[] {_antiguo,_nuevo,_longitud,_view,_campo}));}
RDebugUtils.currentLine=15794176;
 //BA.debugLineNum = 15794176;BA.debugLine="Sub limitarLongitudEntrada(antiguo As String, nuev";
RDebugUtils.currentLine=15794177;
 //BA.debugLineNum = 15794177;BA.debugLine="If(nuevo.Length > longitud) Then";
if ((_nuevo.length()>_longitud)) { 
RDebugUtils.currentLine=15794178;
 //BA.debugLineNum = 15794178;BA.debugLine="If(campo = \"montoAhorro\") Then";
if (((_campo).equals("montoAhorro"))) { 
RDebugUtils.currentLine=15794179;
 //BA.debugLineNum = 15794179;BA.debugLine="If(aparicionMsgBox1 = False) Then";
if ((_aparicionmsgbox1==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=15794180;
 //BA.debugLineNum = 15794180;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para el monto del ahorro es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=15794181;
 //BA.debugLineNum = 15794181;BA.debugLine="aparicionMsgBox1 = True";
_aparicionmsgbox1 = anywheresoftware.b4a.keywords.Common.True;
 };
 }else 
{RDebugUtils.currentLine=15794183;
 //BA.debugLineNum = 15794183;BA.debugLine="Else If(campo = \"metaAhorro\") Then";
if (((_campo).equals("metaAhorro"))) { 
RDebugUtils.currentLine=15794184;
 //BA.debugLineNum = 15794184;BA.debugLine="If(aparicionMsgBox2 = False) Then";
if ((_aparicionmsgbox2==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=15794185;
 //BA.debugLineNum = 15794185;BA.debugLine="Msgbox2(\"La longitud máxima permitida para la";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para la monto meta es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=15794186;
 //BA.debugLineNum = 15794186;BA.debugLine="aparicionMsgBox2 = True";
_aparicionmsgbox2 = anywheresoftware.b4a.keywords.Common.True;
 };
 }else 
{RDebugUtils.currentLine=15794188;
 //BA.debugLineNum = 15794188;BA.debugLine="Else If(campo = \"nombre\") Then";
if (((_campo).equals("nombre"))) { 
RDebugUtils.currentLine=15794189;
 //BA.debugLineNum = 15794189;BA.debugLine="If(aparicionMsgBox3 = False) Then";
if ((_aparicionmsgbox3==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=15794190;
 //BA.debugLineNum = 15794190;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para el nombre es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=15794191;
 //BA.debugLineNum = 15794191;BA.debugLine="aparicionMsgBox3 = True";
_aparicionmsgbox3 = anywheresoftware.b4a.keywords.Common.True;
 };
 }else 
{RDebugUtils.currentLine=15794193;
 //BA.debugLineNum = 15794193;BA.debugLine="Else If(campo = \"descripcion\") Then";
if (((_campo).equals("descripcion"))) { 
RDebugUtils.currentLine=15794194;
 //BA.debugLineNum = 15794194;BA.debugLine="If(aparicionMsgBox4 = False) Then";
if ((_aparicionmsgbox4==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=15794195;
 //BA.debugLineNum = 15794195;BA.debugLine="Msgbox2(\"La longitud máxima permitida para la";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para la descripción es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=15794196;
 //BA.debugLineNum = 15794196;BA.debugLine="aparicionMsgBox4 = True";
_aparicionmsgbox4 = anywheresoftware.b4a.keywords.Common.True;
 };
 }}}}
;
RDebugUtils.currentLine=15794199;
 //BA.debugLineNum = 15794199;BA.debugLine="view.Text = antiguo";
_view.setText(BA.ObjectToCharSequence(_antiguo));
 };
RDebugUtils.currentLine=15794201;
 //BA.debugLineNum = 15794201;BA.debugLine="End Sub";
return "";
}
public static String  _rd1ano_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="registrarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd1ano_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd1ano_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=16384000;
 //BA.debugLineNum = 16384000;BA.debugLine="Private Sub rd1Ano_CheckedChange(Checked As Boolea";
RDebugUtils.currentLine=16384001;
 //BA.debugLineNum = 16384001;BA.debugLine="diasPeriodo = 365";
_diasperiodo = (int) (365);
RDebugUtils.currentLine=16384002;
 //BA.debugLineNum = 16384002;BA.debugLine="End Sub";
return "";
}
public static String  _rd1mes_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="registrarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd1mes_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd1mes_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=16318464;
 //BA.debugLineNum = 16318464;BA.debugLine="Private Sub rd1Mes_CheckedChange(Checked As Boolea";
RDebugUtils.currentLine=16318465;
 //BA.debugLineNum = 16318465;BA.debugLine="diasPeriodo = 30";
_diasperiodo = (int) (30);
RDebugUtils.currentLine=16318466;
 //BA.debugLineNum = 16318466;BA.debugLine="End Sub";
return "";
}
public static String  _rd1semana_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="registrarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd1semana_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd1semana_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=16252928;
 //BA.debugLineNum = 16252928;BA.debugLine="Private Sub rd1Semana_CheckedChange(Checked As Boo";
RDebugUtils.currentLine=16252929;
 //BA.debugLineNum = 16252929;BA.debugLine="diasPeriodo = 7";
_diasperiodo = (int) (7);
RDebugUtils.currentLine=16252930;
 //BA.debugLineNum = 16252930;BA.debugLine="End Sub";
return "";
}
public static String  _rd2semanas_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="registrarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd2semanas_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd2semanas_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=16187392;
 //BA.debugLineNum = 16187392;BA.debugLine="Private Sub rd2Semanas_CheckedChange(Checked As Bo";
RDebugUtils.currentLine=16187393;
 //BA.debugLineNum = 16187393;BA.debugLine="diasPeriodo = 14";
_diasperiodo = (int) (14);
RDebugUtils.currentLine=16187394;
 //BA.debugLineNum = 16187394;BA.debugLine="End Sub";
return "";
}
public static String  _rd3semanas_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="registrarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd3semanas_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd3semanas_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=16121856;
 //BA.debugLineNum = 16121856;BA.debugLine="Private Sub rd3Semanas_CheckedChange(Checked As Bo";
RDebugUtils.currentLine=16121857;
 //BA.debugLineNum = 16121857;BA.debugLine="diasPeriodo = 21";
_diasperiodo = (int) (21);
RDebugUtils.currentLine=16121858;
 //BA.debugLineNum = 16121858;BA.debugLine="End Sub";
return "";
}
public static String  _txtdescripcion_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registrarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtdescripcion_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtdescripcion_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=16056320;
 //BA.debugLineNum = 16056320;BA.debugLine="Private Sub txtDescripcion_TextChanged (Old As Str";
RDebugUtils.currentLine=16056321;
 //BA.debugLineNum = 16056321;BA.debugLine="limitarLongitudEntrada(Old, New, 41, txtDescripci";
_limitarlongitudentrada(_old,_new,(int) (41),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtdescripcion.getObject())),"descripcion");
RDebugUtils.currentLine=16056322;
 //BA.debugLineNum = 16056322;BA.debugLine="End Sub";
return "";
}
public static String  _txtmetaahorro_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registrarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtmetaahorro_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtmetaahorro_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=15990784;
 //BA.debugLineNum = 15990784;BA.debugLine="Private Sub txtMetaAhorro_TextChanged (Old As Stri";
RDebugUtils.currentLine=15990785;
 //BA.debugLineNum = 15990785;BA.debugLine="limitarLongitudEntrada(Old, New, 9, txtMetaAhorro";
_limitarlongitudentrada(_old,_new,(int) (9),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtmetaahorro.getObject())),"metaAhorro");
RDebugUtils.currentLine=15990786;
 //BA.debugLineNum = 15990786;BA.debugLine="End Sub";
return "";
}
public static String  _txtmontoahorro_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registrarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtmontoahorro_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtmontoahorro_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=15925248;
 //BA.debugLineNum = 15925248;BA.debugLine="Private Sub txtMontoAhorro_TextChanged (Old As Str";
RDebugUtils.currentLine=15925249;
 //BA.debugLineNum = 15925249;BA.debugLine="limitarLongitudEntrada(Old ,New, 9, txtMontoAhorr";
_limitarlongitudentrada(_old,_new,(int) (9),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtmontoahorro.getObject())),"montoAhorro");
RDebugUtils.currentLine=15925250;
 //BA.debugLineNum = 15925250;BA.debugLine="End Sub";
return "";
}
public static String  _txtnombre_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registrarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtnombre_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtnombre_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=15859712;
 //BA.debugLineNum = 15859712;BA.debugLine="Private Sub txtNombre_TextChanged (Old As String,";
RDebugUtils.currentLine=15859713;
 //BA.debugLineNum = 15859713;BA.debugLine="limitarLongitudEntrada(Old, New, 16, txtNombre, \"";
_limitarlongitudentrada(_old,_new,(int) (16),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtnombre.getObject())),"nombre");
RDebugUtils.currentLine=15859714;
 //BA.debugLineNum = 15859714;BA.debugLine="End Sub";
return "";
}
}