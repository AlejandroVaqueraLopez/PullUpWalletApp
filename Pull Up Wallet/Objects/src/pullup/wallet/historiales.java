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

public class historiales extends Activity implements B4AActivity{
	public static historiales mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "pullup.wallet", "pullup.wallet.historiales");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (historiales).");
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
		activityBA = new BA(this, layout, processBA, "pullup.wallet", "pullup.wallet.historiales");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "pullup.wallet.historiales", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (historiales) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (historiales) Resume **");
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
		return historiales.class;
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
            BA.LogInfo("** Activity (historiales) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (historiales) Pause event (activity is not paused). **");
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
            historiales mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (historiales) Resume **");
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


public static class _indicehistorial{
public boolean IsInitialized;
public int rowid;
public void Initialize() {
IsInitialized = true;
rowid = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _historial{
public boolean IsInitialized;
public int rowid;
public int sumaIngresos;
public int sumaEgresos;
public int balance;
public String fechaHistorial;
public void Initialize() {
IsInitialized = true;
rowid = 0;
sumaIngresos = 0;
sumaEgresos = 0;
balance = 0;
fechaHistorial = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}

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
public static int _nregistros = 0;
public anywheresoftware.b4a.objects.ButtonWrapper _btnmenu = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblcontornoboton = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlnavinferior = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnldeslizable = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _svpantalla = null;
public anywheresoftware.b4a.sql.SQL.CursorWrapper _cur = null;
public anywheresoftware.b4a.objects.CSBuilder _cs = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvstest = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmptest = null;
public anywheresoftware.b4a.objects.StringUtils _stu = null;
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
public pullup.wallet.ingresosrecurrentes _ingresosrecurrentes = null;
public pullup.wallet.ingresosunicos _ingresosunicos = null;
public pullup.wallet.metasdeahorro _metasdeahorro = null;
public pullup.wallet.registrargasto _registrargasto = null;
public pullup.wallet.registraringreso _registraringreso = null;
public pullup.wallet.registrarmetaahorro _registrarmetaahorro = null;
public pullup.wallet.registrarsuscripcion _registrarsuscripcion = null;
public pullup.wallet.suscripciones _suscripciones = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="historiales";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.LabelWrapper _lblseccion = null;
int _top = 0;
int _id = 0;
pullup.wallet.historiales._historial _datoshistorial = null;
anywheresoftware.b4a.objects.LabelWrapper _lblmensaje = null;
RDebugUtils.currentLine=10289152;
 //BA.debugLineNum = 10289152;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=10289154;
 //BA.debugLineNum = 10289154;BA.debugLine="Activity.LoadLayout(\"LDeslizable\")";
mostCurrent._activity.LoadLayout("LDeslizable",mostCurrent.activityBA);
RDebugUtils.currentLine=10289155;
 //BA.debugLineNum = 10289155;BA.debugLine="Activity.Color = Colors.ARGB(255, 233, 236, 239)";
mostCurrent._activity.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (233),(int) (236),(int) (239)));
RDebugUtils.currentLine=10289156;
 //BA.debugLineNum = 10289156;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
_alturadispositivo = mostCurrent._main._alturadispositivo /*int*/ ;
RDebugUtils.currentLine=10289157;
 //BA.debugLineNum = 10289157;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
_anchodispositivo = mostCurrent._main._anchodispositivo /*int*/ ;
RDebugUtils.currentLine=10289158;
 //BA.debugLineNum = 10289158;BA.debugLine="sql = Starter.sql";
_sql = mostCurrent._starter._sql /*anywheresoftware.b4a.sql.SQL*/ ;
RDebugUtils.currentLine=10289159;
 //BA.debugLineNum = 10289159;BA.debugLine="bmpTest.InitializeMutable(1dip, 1dip)";
mostCurrent._bmptest.InitializeMutable(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)));
RDebugUtils.currentLine=10289160;
 //BA.debugLineNum = 10289160;BA.debugLine="cvsTest.Initialize2(bmpTest)";
mostCurrent._cvstest.Initialize2((android.graphics.Bitmap)(mostCurrent._bmptest.getObject()));
RDebugUtils.currentLine=10289163;
 //BA.debugLineNum = 10289163;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
mostCurrent._pnlnavinferior.setHeight((int) (_alturadispositivo*0.08));
RDebugUtils.currentLine=10289164;
 //BA.debugLineNum = 10289164;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
mostCurrent._pnlnavinferior.setWidth(_anchodispositivo);
RDebugUtils.currentLine=10289165;
 //BA.debugLineNum = 10289165;BA.debugLine="pnlNavInferior.Left = 0";
mostCurrent._pnlnavinferior.setLeft((int) (0));
RDebugUtils.currentLine=10289166;
 //BA.debugLineNum = 10289166;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
mostCurrent._pnlnavinferior.setTop((int) (_alturadispositivo-mostCurrent._pnlnavinferior.getHeight()));
RDebugUtils.currentLine=10289169;
 //BA.debugLineNum = 10289169;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
mostCurrent._btnmenu.setWidth((int) (_anchodispositivo*0.15));
RDebugUtils.currentLine=10289170;
 //BA.debugLineNum = 10289170;BA.debugLine="btnMenu.Height = btnMenu.Width";
mostCurrent._btnmenu.setHeight(mostCurrent._btnmenu.getWidth());
RDebugUtils.currentLine=10289171;
 //BA.debugLineNum = 10289171;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
mostCurrent._btnmenu.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._btnmenu.getHeight()/(double)2));
RDebugUtils.currentLine=10289172;
 //BA.debugLineNum = 10289172;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
mostCurrent._btnmenu.setLeft((int) ((_anchodispositivo-mostCurrent._btnmenu.getWidth())/(double)2));
RDebugUtils.currentLine=10289174;
 //BA.debugLineNum = 10289174;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
mostCurrent._lblcontornoboton.setWidth((int) (_anchodispositivo*0.17));
RDebugUtils.currentLine=10289175;
 //BA.debugLineNum = 10289175;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
mostCurrent._lblcontornoboton.setHeight(mostCurrent._lblcontornoboton.getWidth());
RDebugUtils.currentLine=10289176;
 //BA.debugLineNum = 10289176;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
mostCurrent._lblcontornoboton.setLeft((int) ((_anchodispositivo-mostCurrent._lblcontornoboton.getWidth())/(double)2));
RDebugUtils.currentLine=10289177;
 //BA.debugLineNum = 10289177;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
mostCurrent._lblcontornoboton.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._lblcontornoboton.getHeight()/(double)2));
RDebugUtils.currentLine=10289181;
 //BA.debugLineNum = 10289181;BA.debugLine="svPantalla.Height = pnlNavInferior.Top";
mostCurrent._svpantalla.setHeight(mostCurrent._pnlnavinferior.getTop());
RDebugUtils.currentLine=10289182;
 //BA.debugLineNum = 10289182;BA.debugLine="svPantalla.Panel.LoadLayout(\"LPantallaDeslizable\"";
mostCurrent._svpantalla.getPanel().LoadLayout("LPantallaDeslizable",mostCurrent.activityBA);
RDebugUtils.currentLine=10289183;
 //BA.debugLineNum = 10289183;BA.debugLine="svPantalla.Width = anchoDispositivo * 1.5";
mostCurrent._svpantalla.setWidth((int) (_anchodispositivo*1.5));
RDebugUtils.currentLine=10289184;
 //BA.debugLineNum = 10289184;BA.debugLine="pnlDeslizable.Width = svPantalla.Width";
mostCurrent._pnldeslizable.setWidth(mostCurrent._svpantalla.getWidth());
RDebugUtils.currentLine=10289190;
 //BA.debugLineNum = 10289190;BA.debugLine="Dim lblSeccion As Label";
_lblseccion = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=10289191;
 //BA.debugLineNum = 10289191;BA.debugLine="lblSeccion.Initialize(\"lblSeccion\")";
_lblseccion.Initialize(mostCurrent.activityBA,"lblSeccion");
RDebugUtils.currentLine=10289192;
 //BA.debugLineNum = 10289192;BA.debugLine="lblSeccion.Text = \"Historiales\"";
_lblseccion.setText(BA.ObjectToCharSequence("Historiales"));
RDebugUtils.currentLine=10289193;
 //BA.debugLineNum = 10289193;BA.debugLine="lblSeccion.TextSize = 20";
_lblseccion.setTextSize((float) (20));
RDebugUtils.currentLine=10289194;
 //BA.debugLineNum = 10289194;BA.debugLine="lblSeccion.TextColor = Colors.Black";
_lblseccion.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=10289195;
 //BA.debugLineNum = 10289195;BA.debugLine="lblSeccion.Height = 30dip";
_lblseccion.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=10289196;
 //BA.debugLineNum = 10289196;BA.debugLine="lblSeccion.Width = anchoDispositivo * 0.9";
_lblseccion.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=10289197;
 //BA.debugLineNum = 10289197;BA.debugLine="lblSeccion.Top = 30dip";
_lblseccion.setTop(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=10289198;
 //BA.debugLineNum = 10289198;BA.debugLine="lblSeccion.Left = (anchoDispositivo - lblSeccion.";
_lblseccion.setLeft((int) ((_anchodispositivo-_lblseccion.getWidth())/(double)2));
RDebugUtils.currentLine=10289199;
 //BA.debugLineNum = 10289199;BA.debugLine="pnlDeslizable.AddView(lblSeccion, lblSeccion.Left";
mostCurrent._pnldeslizable.AddView((android.view.View)(_lblseccion.getObject()),_lblseccion.getLeft(),_lblseccion.getTop(),_lblseccion.getWidth(),_lblseccion.getHeight());
RDebugUtils.currentLine=10289204;
 //BA.debugLineNum = 10289204;BA.debugLine="Dim top As Int";
_top = 0;
RDebugUtils.currentLine=10289205;
 //BA.debugLineNum = 10289205;BA.debugLine="top = lblSeccion.Top + lblSeccion.Height + 30dip";
_top = (int) (_lblseccion.getTop()+_lblseccion.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=10289208;
 //BA.debugLineNum = 10289208;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM historial_bala";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM historial_balance ORDER BY rowid ASC")));
RDebugUtils.currentLine=10289209;
 //BA.debugLineNum = 10289209;BA.debugLine="nRegistros = cur.RowCount";
_nregistros = mostCurrent._cur.getRowCount();
RDebugUtils.currentLine=10289213;
 //BA.debugLineNum = 10289213;BA.debugLine="If nRegistros > 0 Then";
if (_nregistros>0) { 
RDebugUtils.currentLine=10289215;
 //BA.debugLineNum = 10289215;BA.debugLine="For id = 0 To nRegistros - 1";
{
final int step39 = 1;
final int limit39 = (int) (_nregistros-1);
_id = (int) (0) ;
for (;_id <= limit39 ;_id = _id + step39 ) {
RDebugUtils.currentLine=10289216;
 //BA.debugLineNum = 10289216;BA.debugLine="cur.Position = id";
mostCurrent._cur.setPosition(_id);
RDebugUtils.currentLine=10289218;
 //BA.debugLineNum = 10289218;BA.debugLine="Dim datosHistorial As Historial";
_datoshistorial = new pullup.wallet.historiales._historial();
RDebugUtils.currentLine=10289219;
 //BA.debugLineNum = 10289219;BA.debugLine="datosHistorial.rowid = cur.GetInt(\"id_historial";
_datoshistorial.rowid /*int*/  = mostCurrent._cur.GetInt("id_historial");
RDebugUtils.currentLine=10289220;
 //BA.debugLineNum = 10289220;BA.debugLine="datosHistorial.sumaIngresos = cur.GetInt(\"suma_";
_datoshistorial.sumaIngresos /*int*/  = mostCurrent._cur.GetInt("suma_ingresos");
RDebugUtils.currentLine=10289221;
 //BA.debugLineNum = 10289221;BA.debugLine="datosHistorial.sumaEgresos = cur.GetInt(\"suma_e";
_datoshistorial.sumaEgresos /*int*/  = mostCurrent._cur.GetInt("suma_egresos");
RDebugUtils.currentLine=10289222;
 //BA.debugLineNum = 10289222;BA.debugLine="datosHistorial.balance = cur.GetInt(\"balance\")";
_datoshistorial.balance /*int*/  = mostCurrent._cur.GetInt("balance");
RDebugUtils.currentLine=10289223;
 //BA.debugLineNum = 10289223;BA.debugLine="datosHistorial.fechaHistorial = cur.GetString(\"";
_datoshistorial.fechaHistorial /*String*/  = mostCurrent._cur.GetString("fecha_historial");
RDebugUtils.currentLine=10289225;
 //BA.debugLineNum = 10289225;BA.debugLine="creaObjetoLista(top, datosHistorial)";
_creaobjetolista(_top,_datoshistorial);
RDebugUtils.currentLine=10289227;
 //BA.debugLineNum = 10289227;BA.debugLine="top = top + alturaDispositivo * 0.2 + 60";
_top = (int) (_top+_alturadispositivo*0.2+60);
 }
};
 }else {
RDebugUtils.currentLine=10289231;
 //BA.debugLineNum = 10289231;BA.debugLine="Dim lblMensaje As Label";
_lblmensaje = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=10289232;
 //BA.debugLineNum = 10289232;BA.debugLine="lblMensaje.Initialize(\"lblMensaje\")";
_lblmensaje.Initialize(mostCurrent.activityBA,"lblMensaje");
RDebugUtils.currentLine=10289233;
 //BA.debugLineNum = 10289233;BA.debugLine="lblMensaje.Height = alturaDispositivo * 0.2";
_lblmensaje.setHeight((int) (_alturadispositivo*0.2));
RDebugUtils.currentLine=10289234;
 //BA.debugLineNum = 10289234;BA.debugLine="lblMensaje.Width = anchoDispositivo * 0.9";
_lblmensaje.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=10289235;
 //BA.debugLineNum = 10289235;BA.debugLine="lblMensaje.Top = (alturaDispositivo - lblMensaje";
_lblmensaje.setTop((int) ((_alturadispositivo-_lblmensaje.getHeight())/(double)2));
RDebugUtils.currentLine=10289236;
 //BA.debugLineNum = 10289236;BA.debugLine="lblMensaje.Left = (anchoDispositivo - lblMensaje";
_lblmensaje.setLeft((int) ((_anchodispositivo-_lblmensaje.getWidth())/(double)2));
RDebugUtils.currentLine=10289237;
 //BA.debugLineNum = 10289237;BA.debugLine="lblMensaje.Text = cs.Initialize.Color(Colors.Bla";
_lblmensaje.setText(BA.ObjectToCharSequence(mostCurrent._cs.Initialize().Color(anywheresoftware.b4a.keywords.Common.Colors.Black).Alignment(BA.getEnumFromString(android.text.Layout.Alignment.class,"ALIGN_CENTER")).Typeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS()).Size((int) (50)).Append(BA.ObjectToCharSequence(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (0xe89c)))+anywheresoftware.b4a.keywords.Common.CRLF)).Typeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT).Size((int) (18)).Append(BA.ObjectToCharSequence("Está muy vacío aquí adentro."+anywheresoftware.b4a.keywords.Common.CRLF)).Append(BA.ObjectToCharSequence("Genera tu historial si lo crees necesario.")).PopAll().getObject()));
RDebugUtils.currentLine=10289238;
 //BA.debugLineNum = 10289238;BA.debugLine="Activity.AddView(lblMensaje, lblMensaje.Left, lb";
mostCurrent._activity.AddView((android.view.View)(_lblmensaje.getObject()),_lblmensaje.getLeft(),_lblmensaje.getTop(),_lblmensaje.getWidth(),_lblmensaje.getHeight());
 };
RDebugUtils.currentLine=10289241;
 //BA.debugLineNum = 10289241;BA.debugLine="svPantalla.Panel.Height = top + 100";
mostCurrent._svpantalla.getPanel().setHeight((int) (_top+100));
RDebugUtils.currentLine=10289242;
 //BA.debugLineNum = 10289242;BA.debugLine="End Sub";
return "";
}
public static String  _creaobjetolista(int _top,pullup.wallet.historiales._historial _datos) throws Exception{
RDebugUtils.currentModule="historiales";
if (Debug.shouldDelegate(mostCurrent.activityBA, "creaobjetolista", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "creaobjetolista", new Object[] {_top,_datos}));}
anywheresoftware.b4a.objects.PanelWrapper _pnlhistorial = null;
anywheresoftware.b4a.objects.LabelWrapper _lblbalance = null;
anywheresoftware.b4a.objects.LabelWrapper _lblingresos = null;
anywheresoftware.b4a.objects.LabelWrapper _lblegresos = null;
anywheresoftware.b4a.objects.LabelWrapper _lblfechahistorial = null;
anywheresoftware.b4a.objects.LabelWrapper _lbleliminar = null;
anywheresoftware.b4a.objects.LabelWrapper _lbliconoingresos = null;
anywheresoftware.b4a.objects.LabelWrapper _lbliconoegresos = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
pullup.wallet.historiales._indicehistorial _referencia = null;
RDebugUtils.currentLine=10551296;
 //BA.debugLineNum = 10551296;BA.debugLine="Sub creaObjetoLista(top As Int, datos As Historial";
RDebugUtils.currentLine=10551297;
 //BA.debugLineNum = 10551297;BA.debugLine="Dim pnlHistorial As Panel";
_pnlhistorial = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=10551298;
 //BA.debugLineNum = 10551298;BA.debugLine="Dim lblBalance As Label";
_lblbalance = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=10551299;
 //BA.debugLineNum = 10551299;BA.debugLine="Dim lblIngresos As Label";
_lblingresos = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=10551300;
 //BA.debugLineNum = 10551300;BA.debugLine="Dim lblEgresos As Label";
_lblegresos = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=10551301;
 //BA.debugLineNum = 10551301;BA.debugLine="Dim lblFechaHistorial As Label";
_lblfechahistorial = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=10551302;
 //BA.debugLineNum = 10551302;BA.debugLine="Dim lblEliminar As Label";
_lbleliminar = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=10551303;
 //BA.debugLineNum = 10551303;BA.debugLine="Dim lblIconoIngresos As Label";
_lbliconoingresos = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=10551304;
 //BA.debugLineNum = 10551304;BA.debugLine="Dim lblIconoEgresos As Label";
_lbliconoegresos = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=10551307;
 //BA.debugLineNum = 10551307;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=10551308;
 //BA.debugLineNum = 10551308;BA.debugLine="cd.Initialize(Colors.White, 20)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.White,(int) (20));
RDebugUtils.currentLine=10551313;
 //BA.debugLineNum = 10551313;BA.debugLine="pnlHistorial.Initialize(\"pnlHistorial\")";
_pnlhistorial.Initialize(mostCurrent.activityBA,"pnlHistorial");
RDebugUtils.currentLine=10551314;
 //BA.debugLineNum = 10551314;BA.debugLine="pnlHistorial.Top = top";
_pnlhistorial.setTop(_top);
RDebugUtils.currentLine=10551315;
 //BA.debugLineNum = 10551315;BA.debugLine="pnlHistorial.Background = cd";
_pnlhistorial.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=10551316;
 //BA.debugLineNum = 10551316;BA.debugLine="pnlHistorial.Width = anchoDispositivo * 0.9";
_pnlhistorial.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=10551317;
 //BA.debugLineNum = 10551317;BA.debugLine="pnlHistorial.Height = alturaDispositivo * 0.2";
_pnlhistorial.setHeight((int) (_alturadispositivo*0.2));
RDebugUtils.currentLine=10551318;
 //BA.debugLineNum = 10551318;BA.debugLine="pnlHistorial.Left = (anchoDispositivo - pnlHistor";
_pnlhistorial.setLeft((int) ((_anchodispositivo-_pnlhistorial.getWidth())/(double)2));
RDebugUtils.currentLine=10551319;
 //BA.debugLineNum = 10551319;BA.debugLine="pnlHistorial.Width = anchoDispositivo * 0.9";
_pnlhistorial.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=10551323;
 //BA.debugLineNum = 10551323;BA.debugLine="lblBalance.Initialize(\"lblBalance\")";
_lblbalance.Initialize(mostCurrent.activityBA,"lblBalance");
RDebugUtils.currentLine=10551324;
 //BA.debugLineNum = 10551324;BA.debugLine="lblBalance.Text = cs.Initialize.Color(Colors.Blac";
_lblbalance.setText(BA.ObjectToCharSequence(mostCurrent._cs.Initialize().Color(anywheresoftware.b4a.keywords.Common.Colors.Black).Alignment(BA.getEnumFromString(android.text.Layout.Alignment.class,"ALIGN_CENTER")).Typeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT).Size((int) (14)).Append(BA.ObjectToCharSequence("Balance:"+anywheresoftware.b4a.keywords.Common.CRLF)).Typeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT).Size((int) (16)).Append(BA.ObjectToCharSequence("$"+BA.NumberToString(_datos.balance /*int*/ ))).PopAll().getObject()));
RDebugUtils.currentLine=10551325;
 //BA.debugLineNum = 10551325;BA.debugLine="lblBalance.Height = pnlHistorial.Height * 0.4";
_lblbalance.setHeight((int) (_pnlhistorial.getHeight()*0.4));
RDebugUtils.currentLine=10551326;
 //BA.debugLineNum = 10551326;BA.debugLine="lblBalance.Top = 0";
_lblbalance.setTop((int) (0));
RDebugUtils.currentLine=10551327;
 //BA.debugLineNum = 10551327;BA.debugLine="lblBalance.Gravity = Gravity.CENTER";
_lblbalance.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=10551328;
 //BA.debugLineNum = 10551328;BA.debugLine="pnlHistorial.AddView(lblBalance, lblBalance.Left,";
_pnlhistorial.AddView((android.view.View)(_lblbalance.getObject()),_lblbalance.getLeft(),_lblbalance.getTop(),_lblbalance.getWidth(),_lblbalance.getHeight());
RDebugUtils.currentLine=10551329;
 //BA.debugLineNum = 10551329;BA.debugLine="lblBalance.Width = stu.MeasureMultilineTextHeight";
_lblbalance.setWidth(mostCurrent._stu.MeasureMultilineTextHeight((android.widget.TextView)(_lblbalance.getObject()),BA.ObjectToCharSequence(_lblbalance.getText())));
RDebugUtils.currentLine=10551330;
 //BA.debugLineNum = 10551330;BA.debugLine="lblBalance.Left = (pnlHistorial.Width - lblBalanc";
_lblbalance.setLeft((int) ((_pnlhistorial.getWidth()-_lblbalance.getWidth())/(double)2));
RDebugUtils.currentLine=10551332;
 //BA.debugLineNum = 10551332;BA.debugLine="cd.Initialize(Colors.Transparent, 100)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.Transparent,(int) (100));
RDebugUtils.currentLine=10551333;
 //BA.debugLineNum = 10551333;BA.debugLine="lblIconoIngresos.Initialize(\"lblIconoIngresos\")";
_lbliconoingresos.Initialize(mostCurrent.activityBA,"lblIconoIngresos");
RDebugUtils.currentLine=10551334;
 //BA.debugLineNum = 10551334;BA.debugLine="lblIconoIngresos.Background = cd";
_lbliconoingresos.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=10551335;
 //BA.debugLineNum = 10551335;BA.debugLine="lblIconoIngresos.Typeface = Typeface.MATERIALICON";
_lbliconoingresos.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
RDebugUtils.currentLine=10551336;
 //BA.debugLineNum = 10551336;BA.debugLine="lblIconoIngresos.Top = lblBalance.Height";
_lbliconoingresos.setTop(_lblbalance.getHeight());
RDebugUtils.currentLine=10551337;
 //BA.debugLineNum = 10551337;BA.debugLine="lblIconoIngresos.Left = pnlHistorial.Width * 0.05";
_lbliconoingresos.setLeft((int) (_pnlhistorial.getWidth()*0.05));
RDebugUtils.currentLine=10551338;
 //BA.debugLineNum = 10551338;BA.debugLine="lblIconoIngresos.Height = pnlHistorial.Height * 0";
_lbliconoingresos.setHeight((int) (_pnlhistorial.getHeight()*0.3));
RDebugUtils.currentLine=10551339;
 //BA.debugLineNum = 10551339;BA.debugLine="lblIconoIngresos.Width = lblIconoIngresos.Height";
_lbliconoingresos.setWidth(_lbliconoingresos.getHeight());
RDebugUtils.currentLine=10551340;
 //BA.debugLineNum = 10551340;BA.debugLine="lblIconoIngresos.Text = Chr(0xE5D8)";
_lbliconoingresos.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xe5d8))));
RDebugUtils.currentLine=10551341;
 //BA.debugLineNum = 10551341;BA.debugLine="lblIconoIngresos.TextColor = Colors.White";
_lbliconoingresos.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=10551342;
 //BA.debugLineNum = 10551342;BA.debugLine="lblIconoIngresos.Color = Colors.ARGB(255, 42, 197";
_lbliconoingresos.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (42),(int) (197),(int) (33)));
RDebugUtils.currentLine=10551343;
 //BA.debugLineNum = 10551343;BA.debugLine="lblIconoIngresos.Gravity = Gravity.CENTER";
_lbliconoingresos.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=10551344;
 //BA.debugLineNum = 10551344;BA.debugLine="pnlHistorial.AddView(lblIconoIngresos, lblIconoIn";
_pnlhistorial.AddView((android.view.View)(_lbliconoingresos.getObject()),_lbliconoingresos.getLeft(),_lbliconoingresos.getTop(),_lbliconoingresos.getWidth(),_lbliconoingresos.getHeight());
RDebugUtils.currentLine=10551346;
 //BA.debugLineNum = 10551346;BA.debugLine="lblIngresos.Initialize(\"lblIngresos\")";
_lblingresos.Initialize(mostCurrent.activityBA,"lblIngresos");
RDebugUtils.currentLine=10551347;
 //BA.debugLineNum = 10551347;BA.debugLine="lblIngresos.Height = lblIconoIngresos.Height";
_lblingresos.setHeight(_lbliconoingresos.getHeight());
RDebugUtils.currentLine=10551348;
 //BA.debugLineNum = 10551348;BA.debugLine="lblIngresos.Width = pnlHistorial.Width * 0.5 - (l";
_lblingresos.setWidth((int) (_pnlhistorial.getWidth()*0.5-(_lbliconoingresos.getLeft()+_lbliconoingresos.getWidth())));
RDebugUtils.currentLine=10551349;
 //BA.debugLineNum = 10551349;BA.debugLine="lblIngresos.Left = lblIconoIngresos.Left + lblIco";
_lblingresos.setLeft((int) (_lbliconoingresos.getLeft()+_lbliconoingresos.getWidth()));
RDebugUtils.currentLine=10551350;
 //BA.debugLineNum = 10551350;BA.debugLine="lblIngresos.Top = lblIconoIngresos.Top";
_lblingresos.setTop(_lbliconoingresos.getTop());
RDebugUtils.currentLine=10551351;
 //BA.debugLineNum = 10551351;BA.debugLine="lblIngresos.Text = \"$\" & datos.sumaIngresos & \".0";
_lblingresos.setText(BA.ObjectToCharSequence("$"+BA.NumberToString(_datos.sumaIngresos /*int*/ )+".00"));
RDebugUtils.currentLine=10551352;
 //BA.debugLineNum = 10551352;BA.debugLine="lblIngresos.TextSize = 13";
_lblingresos.setTextSize((float) (13));
RDebugUtils.currentLine=10551353;
 //BA.debugLineNum = 10551353;BA.debugLine="lblIngresos.TextColor = Colors.ARGB(255, 42, 197,";
_lblingresos.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (42),(int) (197),(int) (33)));
RDebugUtils.currentLine=10551354;
 //BA.debugLineNum = 10551354;BA.debugLine="lblIngresos.Gravity = Gravity.CENTER";
_lblingresos.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=10551355;
 //BA.debugLineNum = 10551355;BA.debugLine="pnlHistorial.AddView(lblIngresos, lblIngresos.Lef";
_pnlhistorial.AddView((android.view.View)(_lblingresos.getObject()),_lblingresos.getLeft(),_lblingresos.getTop(),_lblingresos.getWidth(),_lblingresos.getHeight());
RDebugUtils.currentLine=10551357;
 //BA.debugLineNum = 10551357;BA.debugLine="lblIconoEgresos.Initialize(\"lblIconoEgresos\")";
_lbliconoegresos.Initialize(mostCurrent.activityBA,"lblIconoEgresos");
RDebugUtils.currentLine=10551358;
 //BA.debugLineNum = 10551358;BA.debugLine="lblIconoEgresos.Background = cd";
_lbliconoegresos.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=10551359;
 //BA.debugLineNum = 10551359;BA.debugLine="lblIconoEgresos.Typeface = Typeface.MATERIALICONS";
_lbliconoegresos.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS());
RDebugUtils.currentLine=10551360;
 //BA.debugLineNum = 10551360;BA.debugLine="lblIconoEgresos.Top = lblIconoIngresos.Top";
_lbliconoegresos.setTop(_lbliconoingresos.getTop());
RDebugUtils.currentLine=10551361;
 //BA.debugLineNum = 10551361;BA.debugLine="lblIconoEgresos.Left = pnlHistorial.Width * 0.5 +";
_lbliconoegresos.setLeft((int) (_pnlhistorial.getWidth()*0.5+_lbliconoingresos.getLeft()));
RDebugUtils.currentLine=10551362;
 //BA.debugLineNum = 10551362;BA.debugLine="lblIconoEgresos.Height = lblIconoIngresos.Height";
_lbliconoegresos.setHeight(_lbliconoingresos.getHeight());
RDebugUtils.currentLine=10551363;
 //BA.debugLineNum = 10551363;BA.debugLine="lblIconoEgresos.Width = lblIconoIngresos.Width";
_lbliconoegresos.setWidth(_lbliconoingresos.getWidth());
RDebugUtils.currentLine=10551364;
 //BA.debugLineNum = 10551364;BA.debugLine="lblIconoEgresos.Text = Chr(0xE5DB)";
_lbliconoegresos.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xe5db))));
RDebugUtils.currentLine=10551365;
 //BA.debugLineNum = 10551365;BA.debugLine="lblIconoEgresos.TextColor = Colors.White";
_lbliconoegresos.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=10551366;
 //BA.debugLineNum = 10551366;BA.debugLine="lblIconoEgresos.Color = Colors.Red";
_lbliconoegresos.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=10551367;
 //BA.debugLineNum = 10551367;BA.debugLine="lblIconoEgresos.Gravity = Gravity.CENTER";
_lbliconoegresos.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=10551368;
 //BA.debugLineNum = 10551368;BA.debugLine="pnlHistorial.AddView(lblIconoEgresos, lblIconoEgr";
_pnlhistorial.AddView((android.view.View)(_lbliconoegresos.getObject()),_lbliconoegresos.getLeft(),_lbliconoegresos.getTop(),_lbliconoegresos.getWidth(),_lbliconoegresos.getHeight());
RDebugUtils.currentLine=10551370;
 //BA.debugLineNum = 10551370;BA.debugLine="lblEgresos.Initialize(\"lblEgresos\")";
_lblegresos.Initialize(mostCurrent.activityBA,"lblEgresos");
RDebugUtils.currentLine=10551371;
 //BA.debugLineNum = 10551371;BA.debugLine="lblEgresos.Height = lblIconoEgresos.Height";
_lblegresos.setHeight(_lbliconoegresos.getHeight());
RDebugUtils.currentLine=10551372;
 //BA.debugLineNum = 10551372;BA.debugLine="lblEgresos.Width = lblIngresos.Width";
_lblegresos.setWidth(_lblingresos.getWidth());
RDebugUtils.currentLine=10551373;
 //BA.debugLineNum = 10551373;BA.debugLine="lblEgresos.Left = lblIconoEgresos.Left + lblIcono";
_lblegresos.setLeft((int) (_lbliconoegresos.getLeft()+_lbliconoegresos.getWidth()));
RDebugUtils.currentLine=10551374;
 //BA.debugLineNum = 10551374;BA.debugLine="lblEgresos.Top = lblIconoEgresos.Top";
_lblegresos.setTop(_lbliconoegresos.getTop());
RDebugUtils.currentLine=10551375;
 //BA.debugLineNum = 10551375;BA.debugLine="lblEgresos.Text = \"$\" & datos.sumaEgresos & \".00\"";
_lblegresos.setText(BA.ObjectToCharSequence("$"+BA.NumberToString(_datos.sumaEgresos /*int*/ )+".00"));
RDebugUtils.currentLine=10551376;
 //BA.debugLineNum = 10551376;BA.debugLine="lblEgresos.TextSize = 13";
_lblegresos.setTextSize((float) (13));
RDebugUtils.currentLine=10551377;
 //BA.debugLineNum = 10551377;BA.debugLine="lblEgresos.TextColor = Colors.Red";
_lblegresos.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=10551378;
 //BA.debugLineNum = 10551378;BA.debugLine="lblEgresos.Gravity = Gravity.CENTER";
_lblegresos.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=10551379;
 //BA.debugLineNum = 10551379;BA.debugLine="pnlHistorial.AddView(lblEgresos, lblEgresos.Left,";
_pnlhistorial.AddView((android.view.View)(_lblegresos.getObject()),_lblegresos.getLeft(),_lblegresos.getTop(),_lblegresos.getWidth(),_lblegresos.getHeight());
RDebugUtils.currentLine=10551381;
 //BA.debugLineNum = 10551381;BA.debugLine="lblFechaHistorial.Initialize(\"lblFechaHistorial\")";
_lblfechahistorial.Initialize(mostCurrent.activityBA,"lblFechaHistorial");
RDebugUtils.currentLine=10551382;
 //BA.debugLineNum = 10551382;BA.debugLine="lblFechaHistorial.TextColor = Colors.Black";
_lblfechahistorial.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=10551383;
 //BA.debugLineNum = 10551383;BA.debugLine="lblFechaHistorial.Text = cs.Initialize.Color(Colo";
_lblfechahistorial.setText(BA.ObjectToCharSequence(mostCurrent._cs.Initialize().Color(anywheresoftware.b4a.keywords.Common.Colors.Black).Typeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT).Size((int) (14)).Append(BA.ObjectToCharSequence("Fecha del historial:"+anywheresoftware.b4a.keywords.Common.CRLF)).Append(BA.ObjectToCharSequence(_datos.fechaHistorial /*String*/ )).PopAll().getObject()));
RDebugUtils.currentLine=10551384;
 //BA.debugLineNum = 10551384;BA.debugLine="lblFechaHistorial.Width = cvsTest.MeasureStringWi";
_lblfechahistorial.setWidth((int) (mostCurrent._cvstest.MeasureStringWidth(_lblfechahistorial.getText(),anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT,(float) (16))+2));
RDebugUtils.currentLine=10551385;
 //BA.debugLineNum = 10551385;BA.debugLine="lblFechaHistorial.Height = pnlHistorial.Height *";
_lblfechahistorial.setHeight((int) (_pnlhistorial.getHeight()*0.3));
RDebugUtils.currentLine=10551386;
 //BA.debugLineNum = 10551386;BA.debugLine="lblFechaHistorial.Top = lblIconoIngresos.Top + lb";
_lblfechahistorial.setTop((int) (_lbliconoingresos.getTop()+_lbliconoingresos.getHeight()));
RDebugUtils.currentLine=10551387;
 //BA.debugLineNum = 10551387;BA.debugLine="lblFechaHistorial.Left = (pnlHistorial.Width - lb";
_lblfechahistorial.setLeft((int) ((_pnlhistorial.getWidth()-_lblfechahistorial.getWidth())*0.5));
RDebugUtils.currentLine=10551388;
 //BA.debugLineNum = 10551388;BA.debugLine="lblFechaHistorial.Gravity = Gravity.CENTER";
_lblfechahistorial.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=10551389;
 //BA.debugLineNum = 10551389;BA.debugLine="pnlHistorial.AddView(lblFechaHistorial, lblFechaH";
_pnlhistorial.AddView((android.view.View)(_lblfechahistorial.getObject()),_lblfechahistorial.getLeft(),_lblfechahistorial.getTop(),_lblfechahistorial.getWidth(),_lblfechahistorial.getHeight());
RDebugUtils.currentLine=10551391;
 //BA.debugLineNum = 10551391;BA.debugLine="lblEliminar.Initialize(\"lblEliminar\")";
_lbleliminar.Initialize(mostCurrent.activityBA,"lblEliminar");
RDebugUtils.currentLine=10551392;
 //BA.debugLineNum = 10551392;BA.debugLine="lblEliminar.Typeface = Typeface.FONTAWESOME";
_lbleliminar.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getFONTAWESOME());
RDebugUtils.currentLine=10551393;
 //BA.debugLineNum = 10551393;BA.debugLine="lblEliminar.Text = Chr(0xF1F8)";
_lbleliminar.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf1f8))));
RDebugUtils.currentLine=10551394;
 //BA.debugLineNum = 10551394;BA.debugLine="lblEliminar.TextSize = 18";
_lbleliminar.setTextSize((float) (18));
RDebugUtils.currentLine=10551395;
 //BA.debugLineNum = 10551395;BA.debugLine="lblEliminar.TextColor = Colors.Black";
_lbleliminar.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=10551396;
 //BA.debugLineNum = 10551396;BA.debugLine="lblEliminar.Width = cvsTest.MeasureStringWidth(lb";
_lbleliminar.setWidth((int) (mostCurrent._cvstest.MeasureStringWidth(_lbleliminar.getText(),anywheresoftware.b4a.keywords.Common.Typeface.getFONTAWESOME(),_lbleliminar.getTextSize())+2));
RDebugUtils.currentLine=10551397;
 //BA.debugLineNum = 10551397;BA.debugLine="lblEliminar.Left = pnlHistorial.Width - lblElimin";
_lbleliminar.setLeft((int) (_pnlhistorial.getWidth()-_lbleliminar.getWidth()*2));
RDebugUtils.currentLine=10551398;
 //BA.debugLineNum = 10551398;BA.debugLine="lblEliminar.Top = lblEliminar.Width";
_lbleliminar.setTop(_lbleliminar.getWidth());
RDebugUtils.currentLine=10551399;
 //BA.debugLineNum = 10551399;BA.debugLine="lblEliminar.Gravity = Gravity.CENTER";
_lbleliminar.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=10551400;
 //BA.debugLineNum = 10551400;BA.debugLine="pnlHistorial.AddView(lblEliminar, lblEliminar.Lef";
_pnlhistorial.AddView((android.view.View)(_lbleliminar.getObject()),_lbleliminar.getLeft(),_lbleliminar.getTop(),_lbleliminar.getWidth(),_lbleliminar.getHeight());
RDebugUtils.currentLine=10551402;
 //BA.debugLineNum = 10551402;BA.debugLine="lblEliminar.Height = stu.MeasureMultilineTextHeig";
_lbleliminar.setHeight((int) (mostCurrent._stu.MeasureMultilineTextHeight((android.widget.TextView)(_lbleliminar.getObject()),BA.ObjectToCharSequence(_lbleliminar.getText()))+2));
RDebugUtils.currentLine=10551404;
 //BA.debugLineNum = 10551404;BA.debugLine="pnlDeslizable.AddView(pnlHistorial, pnlHistorial.";
mostCurrent._pnldeslizable.AddView((android.view.View)(_pnlhistorial.getObject()),_pnlhistorial.getLeft(),_top,_pnlhistorial.getWidth(),_pnlhistorial.getHeight());
RDebugUtils.currentLine=10551409;
 //BA.debugLineNum = 10551409;BA.debugLine="Dim referencia As IndiceHistorial";
_referencia = new pullup.wallet.historiales._indicehistorial();
RDebugUtils.currentLine=10551410;
 //BA.debugLineNum = 10551410;BA.debugLine="referencia.rowid = datos.rowid";
_referencia.rowid /*int*/  = _datos.rowid /*int*/ ;
RDebugUtils.currentLine=10551412;
 //BA.debugLineNum = 10551412;BA.debugLine="lblEliminar.Tag = referencia";
_lbleliminar.setTag((Object)(_referencia));
RDebugUtils.currentLine=10551413;
 //BA.debugLineNum = 10551413;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="historiales";
RDebugUtils.currentLine=10420224;
 //BA.debugLineNum = 10420224;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=10420226;
 //BA.debugLineNum = 10420226;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="historiales";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=10354688;
 //BA.debugLineNum = 10354688;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=10354690;
 //BA.debugLineNum = 10354690;BA.debugLine="End Sub";
return "";
}
public static String  _btnmenu_click() throws Exception{
RDebugUtils.currentModule="historiales";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnmenu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnmenu_click", null));}
RDebugUtils.currentLine=10485760;
 //BA.debugLineNum = 10485760;BA.debugLine="Private Sub btnMenu_Click";
RDebugUtils.currentLine=10485761;
 //BA.debugLineNum = 10485761;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=10485762;
 //BA.debugLineNum = 10485762;BA.debugLine="End Sub";
return "";
}
public static String  _lbleliminar_click() throws Exception{
RDebugUtils.currentModule="historiales";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbleliminar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lbleliminar_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _lbleliminar = null;
pullup.wallet.historiales._indicehistorial _indice = null;
int _idregistro = 0;
int _resultado = 0;
RDebugUtils.currentLine=10616832;
 //BA.debugLineNum = 10616832;BA.debugLine="Sub lblEliminar_Click";
RDebugUtils.currentLine=10616833;
 //BA.debugLineNum = 10616833;BA.debugLine="Dim lblEliminar As Label";
_lbleliminar = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=10616834;
 //BA.debugLineNum = 10616834;BA.debugLine="Dim indice As IndiceHistorial";
_indice = new pullup.wallet.historiales._indicehistorial();
RDebugUtils.currentLine=10616835;
 //BA.debugLineNum = 10616835;BA.debugLine="Dim idRegistro As Int";
_idregistro = 0;
RDebugUtils.currentLine=10616837;
 //BA.debugLineNum = 10616837;BA.debugLine="lblEliminar = Sender";
_lbleliminar = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=10616838;
 //BA.debugLineNum = 10616838;BA.debugLine="indice = lblEliminar.Tag";
_indice = (pullup.wallet.historiales._indicehistorial)(_lbleliminar.getTag());
RDebugUtils.currentLine=10616840;
 //BA.debugLineNum = 10616840;BA.debugLine="lblEliminar = Sender";
_lbleliminar = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=10616842;
 //BA.debugLineNum = 10616842;BA.debugLine="indice = lblEliminar.Tag";
_indice = (pullup.wallet.historiales._indicehistorial)(_lbleliminar.getTag());
RDebugUtils.currentLine=10616844;
 //BA.debugLineNum = 10616844;BA.debugLine="idRegistro = indice.rowid";
_idregistro = _indice.rowid /*int*/ ;
RDebugUtils.currentLine=10616847;
 //BA.debugLineNum = 10616847;BA.debugLine="Log(idRegistro)";
anywheresoftware.b4a.keywords.Common.LogImpl("510616847",BA.NumberToString(_idregistro),0);
RDebugUtils.currentLine=10616848;
 //BA.debugLineNum = 10616848;BA.debugLine="Dim resultado As Int";
_resultado = 0;
RDebugUtils.currentLine=10616849;
 //BA.debugLineNum = 10616849;BA.debugLine="resultado = Msgbox2(\"¿Estás seguro?\", \"Eliminar h";
_resultado = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("¿Estás seguro?"),BA.ObjectToCharSequence("Eliminar historial"),"Sí","","No",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=10616850;
 //BA.debugLineNum = 10616850;BA.debugLine="If (resultado = DialogResponse.POSITIVE) Then";
if ((_resultado==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE)) { 
RDebugUtils.currentLine=10616852;
 //BA.debugLineNum = 10616852;BA.debugLine="sql.ExecNonQuery(\"DELETE FROM historial_balance";
_sql.ExecNonQuery("DELETE FROM historial_balance WHERE id_historial = '"+BA.NumberToString(_idregistro)+"'");
RDebugUtils.currentLine=10616855;
 //BA.debugLineNum = 10616855;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=10616856;
 //BA.debugLineNum = 10616856;BA.debugLine="StartActivity(Me)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,historiales.getObject());
 };
RDebugUtils.currentLine=10616858;
 //BA.debugLineNum = 10616858;BA.debugLine="End Sub";
return "";
}
}