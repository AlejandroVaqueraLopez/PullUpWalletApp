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

public class metasdeahorro extends Activity implements B4AActivity{
	public static metasdeahorro mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "pullup.wallet", "pullup.wallet.metasdeahorro");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (metasdeahorro).");
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
		activityBA = new BA(this, layout, processBA, "pullup.wallet", "pullup.wallet.metasdeahorro");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "pullup.wallet.metasdeahorro", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (metasdeahorro) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (metasdeahorro) Resume **");
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
		return metasdeahorro.class;
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
            BA.LogInfo("** Activity (metasdeahorro) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (metasdeahorro) Pause event (activity is not paused). **");
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
            metasdeahorro mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (metasdeahorro) Resume **");
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


public static class _indicemetaahorro{
public boolean IsInitialized;
public int indiceElemento;
public int rowid;
public void Initialize() {
IsInitialized = true;
indiceElemento = 0;
rowid = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _metaahorro{
public boolean IsInitialized;
public int rowid;
public String nombre;
public int montoFinal;
public int montoPeriodico;
public int progreso;
public String periodo;
public String descripcion;
public int color;
public void Initialize() {
IsInitialized = true;
rowid = 0;
nombre = "";
montoFinal = 0;
montoPeriodico = 0;
progreso = 0;
periodo = "";
descripcion = "";
color = 0;
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
public anywheresoftware.b4a.objects.B4XViewWrapper[][] _relaciones = null;
public anywheresoftware.b4a.objects.B4XViewWrapper[] _arraypnlsopciones = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnmenu = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblcontornoboton = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlnavinferior = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnldeslizable = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _svpantalla = null;
public anywheresoftware.b4a.sql.SQL.CursorWrapper _cur = null;
public anywheresoftware.b4a.objects.CSBuilder _cs = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmptest = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvstest = null;
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
public pullup.wallet.historiales _historiales = null;
public pullup.wallet.ingresosrecurrentes _ingresosrecurrentes = null;
public pullup.wallet.ingresosunicos _ingresosunicos = null;
public pullup.wallet.registrargasto _registrargasto = null;
public pullup.wallet.registraringreso _registraringreso = null;
public pullup.wallet.registrarmetaahorro _registrarmetaahorro = null;
public pullup.wallet.registrarsuscripcion _registrarsuscripcion = null;
public pullup.wallet.suscripciones _suscripciones = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="metasdeahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.LabelWrapper _lblseccion = null;
int _top = 0;
int _id = 0;
pullup.wallet.metasdeahorro._metaahorro _datosmetaahorro = null;
anywheresoftware.b4a.objects.LabelWrapper _lblmensaje = null;
RDebugUtils.currentLine=12124160;
 //BA.debugLineNum = 12124160;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=12124163;
 //BA.debugLineNum = 12124163;BA.debugLine="Activity.LoadLayout(\"LDeslizable\")";
mostCurrent._activity.LoadLayout("LDeslizable",mostCurrent.activityBA);
RDebugUtils.currentLine=12124164;
 //BA.debugLineNum = 12124164;BA.debugLine="Activity.Color = Colors.ARGB(255, 233, 236, 239)";
mostCurrent._activity.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (233),(int) (236),(int) (239)));
RDebugUtils.currentLine=12124165;
 //BA.debugLineNum = 12124165;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
_alturadispositivo = mostCurrent._main._alturadispositivo /*int*/ ;
RDebugUtils.currentLine=12124166;
 //BA.debugLineNum = 12124166;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
_anchodispositivo = mostCurrent._main._anchodispositivo /*int*/ ;
RDebugUtils.currentLine=12124167;
 //BA.debugLineNum = 12124167;BA.debugLine="bmpTest.InitializeMutable(1dip, 1dip)";
mostCurrent._bmptest.InitializeMutable(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)));
RDebugUtils.currentLine=12124168;
 //BA.debugLineNum = 12124168;BA.debugLine="cvsTest.Initialize2(bmpTest)";
mostCurrent._cvstest.Initialize2((android.graphics.Bitmap)(mostCurrent._bmptest.getObject()));
RDebugUtils.currentLine=12124171;
 //BA.debugLineNum = 12124171;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
mostCurrent._pnlnavinferior.setHeight((int) (_alturadispositivo*0.08));
RDebugUtils.currentLine=12124172;
 //BA.debugLineNum = 12124172;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
mostCurrent._pnlnavinferior.setWidth(_anchodispositivo);
RDebugUtils.currentLine=12124173;
 //BA.debugLineNum = 12124173;BA.debugLine="pnlNavInferior.Left = 0";
mostCurrent._pnlnavinferior.setLeft((int) (0));
RDebugUtils.currentLine=12124174;
 //BA.debugLineNum = 12124174;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
mostCurrent._pnlnavinferior.setTop((int) (_alturadispositivo-mostCurrent._pnlnavinferior.getHeight()));
RDebugUtils.currentLine=12124177;
 //BA.debugLineNum = 12124177;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
mostCurrent._btnmenu.setWidth((int) (_anchodispositivo*0.15));
RDebugUtils.currentLine=12124178;
 //BA.debugLineNum = 12124178;BA.debugLine="btnMenu.Height = btnMenu.Width";
mostCurrent._btnmenu.setHeight(mostCurrent._btnmenu.getWidth());
RDebugUtils.currentLine=12124179;
 //BA.debugLineNum = 12124179;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
mostCurrent._btnmenu.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._btnmenu.getHeight()/(double)2));
RDebugUtils.currentLine=12124180;
 //BA.debugLineNum = 12124180;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
mostCurrent._btnmenu.setLeft((int) ((_anchodispositivo-mostCurrent._btnmenu.getWidth())/(double)2));
RDebugUtils.currentLine=12124182;
 //BA.debugLineNum = 12124182;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
mostCurrent._lblcontornoboton.setWidth((int) (_anchodispositivo*0.17));
RDebugUtils.currentLine=12124183;
 //BA.debugLineNum = 12124183;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
mostCurrent._lblcontornoboton.setHeight(mostCurrent._lblcontornoboton.getWidth());
RDebugUtils.currentLine=12124184;
 //BA.debugLineNum = 12124184;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
mostCurrent._lblcontornoboton.setLeft((int) ((_anchodispositivo-mostCurrent._lblcontornoboton.getWidth())/(double)2));
RDebugUtils.currentLine=12124185;
 //BA.debugLineNum = 12124185;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
mostCurrent._lblcontornoboton.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._lblcontornoboton.getHeight()/(double)2));
RDebugUtils.currentLine=12124189;
 //BA.debugLineNum = 12124189;BA.debugLine="svPantalla.Height = pnlNavInferior.Top";
mostCurrent._svpantalla.setHeight(mostCurrent._pnlnavinferior.getTop());
RDebugUtils.currentLine=12124190;
 //BA.debugLineNum = 12124190;BA.debugLine="svPantalla.Panel.LoadLayout(\"LPantallaDeslizable\"";
mostCurrent._svpantalla.getPanel().LoadLayout("LPantallaDeslizable",mostCurrent.activityBA);
RDebugUtils.currentLine=12124191;
 //BA.debugLineNum = 12124191;BA.debugLine="svPantalla.Width = anchoDispositivo * 1.5";
mostCurrent._svpantalla.setWidth((int) (_anchodispositivo*1.5));
RDebugUtils.currentLine=12124192;
 //BA.debugLineNum = 12124192;BA.debugLine="pnlDeslizable.Width = svPantalla.Width";
mostCurrent._pnldeslizable.setWidth(mostCurrent._svpantalla.getWidth());
RDebugUtils.currentLine=12124198;
 //BA.debugLineNum = 12124198;BA.debugLine="Dim lblSeccion As Label";
_lblseccion = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=12124199;
 //BA.debugLineNum = 12124199;BA.debugLine="lblSeccion.Initialize(\"lblSeccion\")";
_lblseccion.Initialize(mostCurrent.activityBA,"lblSeccion");
RDebugUtils.currentLine=12124200;
 //BA.debugLineNum = 12124200;BA.debugLine="lblSeccion.Text = \"Metas de ahorro\"";
_lblseccion.setText(BA.ObjectToCharSequence("Metas de ahorro"));
RDebugUtils.currentLine=12124201;
 //BA.debugLineNum = 12124201;BA.debugLine="lblSeccion.TextSize = 20";
_lblseccion.setTextSize((float) (20));
RDebugUtils.currentLine=12124202;
 //BA.debugLineNum = 12124202;BA.debugLine="lblSeccion.TextColor = Colors.Black";
_lblseccion.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=12124203;
 //BA.debugLineNum = 12124203;BA.debugLine="lblSeccion.Height = 30dip";
_lblseccion.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=12124204;
 //BA.debugLineNum = 12124204;BA.debugLine="lblSeccion.Width = anchoDispositivo * 0.9";
_lblseccion.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=12124205;
 //BA.debugLineNum = 12124205;BA.debugLine="lblSeccion.Top = 30dip";
_lblseccion.setTop(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=12124206;
 //BA.debugLineNum = 12124206;BA.debugLine="lblSeccion.Left = (anchoDispositivo - lblSeccion.";
_lblseccion.setLeft((int) ((_anchodispositivo-_lblseccion.getWidth())/(double)2));
RDebugUtils.currentLine=12124207;
 //BA.debugLineNum = 12124207;BA.debugLine="pnlDeslizable.AddView(lblSeccion, lblSeccion.Left";
mostCurrent._pnldeslizable.AddView((android.view.View)(_lblseccion.getObject()),_lblseccion.getLeft(),_lblseccion.getTop(),_lblseccion.getWidth(),_lblseccion.getHeight());
RDebugUtils.currentLine=12124212;
 //BA.debugLineNum = 12124212;BA.debugLine="Dim top As Int";
_top = 0;
RDebugUtils.currentLine=12124213;
 //BA.debugLineNum = 12124213;BA.debugLine="top = lblSeccion.Top + lblSeccion.Height + 30dip";
_top = (int) (_lblseccion.getTop()+_lblseccion.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=12124216;
 //BA.debugLineNum = 12124216;BA.debugLine="sql = Starter.sql";
_sql = mostCurrent._starter._sql /*anywheresoftware.b4a.sql.SQL*/ ;
RDebugUtils.currentLine=12124217;
 //BA.debugLineNum = 12124217;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM metas_ahorro O";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM metas_ahorro ORDER BY rowid ASC")));
RDebugUtils.currentLine=12124218;
 //BA.debugLineNum = 12124218;BA.debugLine="nRegistros = cur.RowCount";
_nregistros = mostCurrent._cur.getRowCount();
RDebugUtils.currentLine=12124222;
 //BA.debugLineNum = 12124222;BA.debugLine="If nRegistros > 0 Then";
if (_nregistros>0) { 
RDebugUtils.currentLine=12124224;
 //BA.debugLineNum = 12124224;BA.debugLine="Dim Relaciones(nRegistros, 2) As B4XView";
mostCurrent._relaciones = new anywheresoftware.b4a.objects.B4XViewWrapper[_nregistros][];
{
int d0 = mostCurrent._relaciones.length;
int d1 = (int) (2);
for (int i0 = 0;i0 < d0;i0++) {
mostCurrent._relaciones[i0] = new anywheresoftware.b4a.objects.B4XViewWrapper[d1];
for (int i1 = 0;i1 < d1;i1++) {
mostCurrent._relaciones[i0][i1] = new anywheresoftware.b4a.objects.B4XViewWrapper();
}
}
}
;
RDebugUtils.currentLine=12124225;
 //BA.debugLineNum = 12124225;BA.debugLine="Dim arrayPnlsOpciones(nRegistros) As B4XView";
mostCurrent._arraypnlsopciones = new anywheresoftware.b4a.objects.B4XViewWrapper[_nregistros];
{
int d0 = mostCurrent._arraypnlsopciones.length;
for (int i0 = 0;i0 < d0;i0++) {
mostCurrent._arraypnlsopciones[i0] = new anywheresoftware.b4a.objects.B4XViewWrapper();
}
}
;
RDebugUtils.currentLine=12124227;
 //BA.debugLineNum = 12124227;BA.debugLine="For id = 0 To nRegistros - 1";
{
final int step41 = 1;
final int limit41 = (int) (_nregistros-1);
_id = (int) (0) ;
for (;_id <= limit41 ;_id = _id + step41 ) {
RDebugUtils.currentLine=12124228;
 //BA.debugLineNum = 12124228;BA.debugLine="cur.Position = id";
mostCurrent._cur.setPosition(_id);
RDebugUtils.currentLine=12124230;
 //BA.debugLineNum = 12124230;BA.debugLine="Dim datosMetaAhorro As MetaAhorro";
_datosmetaahorro = new pullup.wallet.metasdeahorro._metaahorro();
RDebugUtils.currentLine=12124231;
 //BA.debugLineNum = 12124231;BA.debugLine="datosMetaAhorro.rowid = cur.GetInt(\"id_meta_aho";
_datosmetaahorro.rowid /*int*/  = mostCurrent._cur.GetInt("id_meta_ahorro");
RDebugUtils.currentLine=12124232;
 //BA.debugLineNum = 12124232;BA.debugLine="datosMetaAhorro.nombre = cur.GetString(\"nombre\"";
_datosmetaahorro.nombre /*String*/  = mostCurrent._cur.GetString("nombre");
RDebugUtils.currentLine=12124233;
 //BA.debugLineNum = 12124233;BA.debugLine="datosMetaAhorro.montoPeriodico = cur.GetString(";
_datosmetaahorro.montoPeriodico /*int*/  = (int)(Double.parseDouble(mostCurrent._cur.GetString("monto_ahorro")));
RDebugUtils.currentLine=12124234;
 //BA.debugLineNum = 12124234;BA.debugLine="datosMetaAhorro.montoFinal = cur.GetInt(\"monto_";
_datosmetaahorro.montoFinal /*int*/  = mostCurrent._cur.GetInt("monto_meta");
RDebugUtils.currentLine=12124235;
 //BA.debugLineNum = 12124235;BA.debugLine="datosMetaAhorro.progreso = cur.GetInt(\"progreso";
_datosmetaahorro.progreso /*int*/  = mostCurrent._cur.GetInt("progreso");
RDebugUtils.currentLine=12124236;
 //BA.debugLineNum = 12124236;BA.debugLine="datosMetaAhorro.descripcion = cur.GetString(\"de";
_datosmetaahorro.descripcion /*String*/  = mostCurrent._cur.GetString("descripcion");
RDebugUtils.currentLine=12124237;
 //BA.debugLineNum = 12124237;BA.debugLine="datosMetaAhorro.periodo = cur.GetString(\"period";
_datosmetaahorro.periodo /*String*/  = mostCurrent._cur.GetString("periodo_ahorro");
RDebugUtils.currentLine=12124238;
 //BA.debugLineNum = 12124238;BA.debugLine="datosMetaAhorro.color = cur.GetInt(\"color\")";
_datosmetaahorro.color /*int*/  = mostCurrent._cur.GetInt("color");
RDebugUtils.currentLine=12124240;
 //BA.debugLineNum = 12124240;BA.debugLine="creaObjetoLista(id, top, datosMetaAhorro)";
_creaobjetolista(_id,_top,_datosmetaahorro);
RDebugUtils.currentLine=12124242;
 //BA.debugLineNum = 12124242;BA.debugLine="top = top + alturaDispositivo * 0.18 + 60";
_top = (int) (_top+_alturadispositivo*0.18+60);
 }
};
 }else {
RDebugUtils.currentLine=12124246;
 //BA.debugLineNum = 12124246;BA.debugLine="Dim lblMensaje As Label";
_lblmensaje = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=12124247;
 //BA.debugLineNum = 12124247;BA.debugLine="lblMensaje.Initialize(\"lblMensaje\")";
_lblmensaje.Initialize(mostCurrent.activityBA,"lblMensaje");
RDebugUtils.currentLine=12124248;
 //BA.debugLineNum = 12124248;BA.debugLine="lblMensaje.Height = alturaDispositivo * 0.2";
_lblmensaje.setHeight((int) (_alturadispositivo*0.2));
RDebugUtils.currentLine=12124249;
 //BA.debugLineNum = 12124249;BA.debugLine="lblMensaje.Width = anchoDispositivo * 0.9";
_lblmensaje.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=12124250;
 //BA.debugLineNum = 12124250;BA.debugLine="lblMensaje.Top = (alturaDispositivo - lblMensaje";
_lblmensaje.setTop((int) ((_alturadispositivo-_lblmensaje.getHeight())/(double)2));
RDebugUtils.currentLine=12124251;
 //BA.debugLineNum = 12124251;BA.debugLine="lblMensaje.Left = (anchoDispositivo - lblMensaje";
_lblmensaje.setLeft((int) ((_anchodispositivo-_lblmensaje.getWidth())/(double)2));
RDebugUtils.currentLine=12124252;
 //BA.debugLineNum = 12124252;BA.debugLine="lblMensaje.Text = cs.Initialize.Color(Colors.Bla";
_lblmensaje.setText(BA.ObjectToCharSequence(mostCurrent._cs.Initialize().Color(anywheresoftware.b4a.keywords.Common.Colors.Black).Alignment(BA.getEnumFromString(android.text.Layout.Alignment.class,"ALIGN_CENTER")).Typeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS()).Size((int) (50)).Append(BA.ObjectToCharSequence(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (0xe89c)))+anywheresoftware.b4a.keywords.Common.CRLF)).Typeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT).Size((int) (18)).Append(BA.ObjectToCharSequence("Está muy vacío aquí adentro."+anywheresoftware.b4a.keywords.Common.CRLF)).Append(BA.ObjectToCharSequence("Agrega una meta de ahorro desde el menú principal.")).PopAll().getObject()));
RDebugUtils.currentLine=12124253;
 //BA.debugLineNum = 12124253;BA.debugLine="Activity.AddView(lblMensaje, lblMensaje.Left, lb";
mostCurrent._activity.AddView((android.view.View)(_lblmensaje.getObject()),_lblmensaje.getLeft(),_lblmensaje.getTop(),_lblmensaje.getWidth(),_lblmensaje.getHeight());
 };
RDebugUtils.currentLine=12124256;
 //BA.debugLineNum = 12124256;BA.debugLine="svPantalla.Panel.Height = top + 100";
mostCurrent._svpantalla.getPanel().setHeight((int) (_top+100));
RDebugUtils.currentLine=12124257;
 //BA.debugLineNum = 12124257;BA.debugLine="End Sub";
return "";
}
public static String  _creaobjetolista(int _indice,int _top,pullup.wallet.metasdeahorro._metaahorro _datos) throws Exception{
RDebugUtils.currentModule="metasdeahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "creaobjetolista", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "creaobjetolista", new Object[] {_indice,_top,_datos}));}
anywheresoftware.b4a.objects.PanelWrapper _pnlmetaahorro = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlopciones = null;
anywheresoftware.b4a.objects.LabelWrapper _lblnombre = null;
anywheresoftware.b4a.objects.LabelWrapper _lblmontofinal = null;
anywheresoftware.b4a.objects.LabelWrapper _lbldescripcion = null;
anywheresoftware.b4a.objects.ProgressBarWrapper _pbprogreso = null;
anywheresoftware.b4a.objects.LabelWrapper _lblprogreso = null;
anywheresoftware.b4a.objects.LabelWrapper _lblperiodoymonto = null;
anywheresoftware.b4a.objects.LabelWrapper _lblopciones = null;
anywheresoftware.b4a.objects.ButtonWrapper _btneditar = null;
anywheresoftware.b4a.objects.ButtonWrapper _btneliminar = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
String _textoperiodo = "";
pullup.wallet.suscripciones._indicesuscripcion _referencia = null;
pullup.wallet.suscripciones._indicesuscripcion _referencia2 = null;
RDebugUtils.currentLine=12386304;
 //BA.debugLineNum = 12386304;BA.debugLine="Sub creaObjetoLista(indice As Int, top As Int, dat";
RDebugUtils.currentLine=12386305;
 //BA.debugLineNum = 12386305;BA.debugLine="Dim pnlMetaAhorro As Panel";
_pnlmetaahorro = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=12386306;
 //BA.debugLineNum = 12386306;BA.debugLine="Dim pnlOpciones As Panel";
_pnlopciones = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=12386307;
 //BA.debugLineNum = 12386307;BA.debugLine="Dim lblNombre As Label";
_lblnombre = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=12386308;
 //BA.debugLineNum = 12386308;BA.debugLine="Dim lblMontoFinal As Label";
_lblmontofinal = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=12386309;
 //BA.debugLineNum = 12386309;BA.debugLine="Dim lblDescripcion As Label";
_lbldescripcion = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=12386310;
 //BA.debugLineNum = 12386310;BA.debugLine="Dim pbProgreso As ProgressBar";
_pbprogreso = new anywheresoftware.b4a.objects.ProgressBarWrapper();
RDebugUtils.currentLine=12386311;
 //BA.debugLineNum = 12386311;BA.debugLine="Dim lblProgreso As Label";
_lblprogreso = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=12386312;
 //BA.debugLineNum = 12386312;BA.debugLine="Dim lblPeriodoYMonto As Label";
_lblperiodoymonto = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=12386313;
 //BA.debugLineNum = 12386313;BA.debugLine="Dim lblOpciones As Label";
_lblopciones = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=12386314;
 //BA.debugLineNum = 12386314;BA.debugLine="Dim btnEditar As Button";
_btneditar = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=12386315;
 //BA.debugLineNum = 12386315;BA.debugLine="Dim btnEliminar As Button";
_btneliminar = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=12386318;
 //BA.debugLineNum = 12386318;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=12386319;
 //BA.debugLineNum = 12386319;BA.debugLine="cd.Initialize(datos.color, 20)";
_cd.Initialize(_datos.color /*int*/ ,(int) (20));
RDebugUtils.currentLine=12386322;
 //BA.debugLineNum = 12386322;BA.debugLine="pnlMetaAhorro.Initialize(\"pnlMetaAhorro\")";
_pnlmetaahorro.Initialize(mostCurrent.activityBA,"pnlMetaAhorro");
RDebugUtils.currentLine=12386323;
 //BA.debugLineNum = 12386323;BA.debugLine="pnlMetaAhorro.Top = top";
_pnlmetaahorro.setTop(_top);
RDebugUtils.currentLine=12386324;
 //BA.debugLineNum = 12386324;BA.debugLine="pnlMetaAhorro.Background = cd";
_pnlmetaahorro.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=12386325;
 //BA.debugLineNum = 12386325;BA.debugLine="pnlMetaAhorro.Width = anchoDispositivo * 0.9";
_pnlmetaahorro.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=12386326;
 //BA.debugLineNum = 12386326;BA.debugLine="pnlMetaAhorro.Height = alturaDispositivo * 0.18";
_pnlmetaahorro.setHeight((int) (_alturadispositivo*0.18));
RDebugUtils.currentLine=12386327;
 //BA.debugLineNum = 12386327;BA.debugLine="pnlMetaAhorro.Left = (anchoDispositivo - pnlMetaA";
_pnlmetaahorro.setLeft((int) ((_anchodispositivo-_pnlmetaahorro.getWidth())/(double)2));
RDebugUtils.currentLine=12386329;
 //BA.debugLineNum = 12386329;BA.debugLine="lblNombre.Initialize(\"lblNombre\")";
_lblnombre.Initialize(mostCurrent.activityBA,"lblNombre");
RDebugUtils.currentLine=12386330;
 //BA.debugLineNum = 12386330;BA.debugLine="lblNombre.TextColor = Colors.White";
_lblnombre.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=12386331;
 //BA.debugLineNum = 12386331;BA.debugLine="lblNombre.Text = datos.nombre.ToUpperCase.CharAt(";
_lblnombre.setText(BA.ObjectToCharSequence(BA.ObjectToString(_datos.nombre /*String*/ .toUpperCase().charAt((int) (0)))+_datos.nombre /*String*/ .substring((int) (1)).toLowerCase()));
RDebugUtils.currentLine=12386332;
 //BA.debugLineNum = 12386332;BA.debugLine="lblNombre.TextSize = 19";
_lblnombre.setTextSize((float) (19));
RDebugUtils.currentLine=12386333;
 //BA.debugLineNum = 12386333;BA.debugLine="lblNombre.Gravity = Gravity.CENTER_VERTICAL";
_lblnombre.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=12386334;
 //BA.debugLineNum = 12386334;BA.debugLine="lblNombre.Height = pnlMetaAhorro.Height * 0.25";
_lblnombre.setHeight((int) (_pnlmetaahorro.getHeight()*0.25));
RDebugUtils.currentLine=12386335;
 //BA.debugLineNum = 12386335;BA.debugLine="lblNombre.Width = pnlMetaAhorro.Width * 0.9";
_lblnombre.setWidth((int) (_pnlmetaahorro.getWidth()*0.9));
RDebugUtils.currentLine=12386336;
 //BA.debugLineNum = 12386336;BA.debugLine="lblNombre.Top = 0";
_lblnombre.setTop((int) (0));
RDebugUtils.currentLine=12386337;
 //BA.debugLineNum = 12386337;BA.debugLine="lblNombre.Left = pnlMetaAhorro.Width * 0.05";
_lblnombre.setLeft((int) (_pnlmetaahorro.getWidth()*0.05));
RDebugUtils.currentLine=12386338;
 //BA.debugLineNum = 12386338;BA.debugLine="pnlMetaAhorro.AddView(lblNombre, lblNombre.Left,";
_pnlmetaahorro.AddView((android.view.View)(_lblnombre.getObject()),_lblnombre.getLeft(),_lblnombre.getTop(),_lblnombre.getWidth(),_lblnombre.getHeight());
RDebugUtils.currentLine=12386340;
 //BA.debugLineNum = 12386340;BA.debugLine="lblDescripcion.Initialize(\"lblDescripcion\")";
_lbldescripcion.Initialize(mostCurrent.activityBA,"lblDescripcion");
RDebugUtils.currentLine=12386341;
 //BA.debugLineNum = 12386341;BA.debugLine="lblDescripcion.Text = datos.descripcion.ToUpperCa";
_lbldescripcion.setText(BA.ObjectToCharSequence(BA.ObjectToString(_datos.descripcion /*String*/ .toUpperCase().charAt((int) (0)))+_datos.descripcion /*String*/ .substring((int) (1)).toLowerCase()));
RDebugUtils.currentLine=12386342;
 //BA.debugLineNum = 12386342;BA.debugLine="lblDescripcion.TextColor = Colors.White";
_lbldescripcion.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=12386343;
 //BA.debugLineNum = 12386343;BA.debugLine="lblDescripcion.Height = pnlMetaAhorro.Height * 0.";
_lbldescripcion.setHeight((int) (_pnlmetaahorro.getHeight()*0.25));
RDebugUtils.currentLine=12386344;
 //BA.debugLineNum = 12386344;BA.debugLine="lblDescripcion.Width = pnlMetaAhorro.Width * 0.9";
_lbldescripcion.setWidth((int) (_pnlmetaahorro.getWidth()*0.9));
RDebugUtils.currentLine=12386345;
 //BA.debugLineNum = 12386345;BA.debugLine="lblDescripcion.Top = lblNombre.Top + lblNombre.He";
_lbldescripcion.setTop((int) (_lblnombre.getTop()+_lblnombre.getHeight()+5));
RDebugUtils.currentLine=12386346;
 //BA.debugLineNum = 12386346;BA.debugLine="lblDescripcion.Left = lblNombre.Left";
_lbldescripcion.setLeft(_lblnombre.getLeft());
RDebugUtils.currentLine=12386347;
 //BA.debugLineNum = 12386347;BA.debugLine="pnlMetaAhorro.AddView(lblDescripcion, lblDescripc";
_pnlmetaahorro.AddView((android.view.View)(_lbldescripcion.getObject()),_lbldescripcion.getLeft(),_lbldescripcion.getTop(),_lbldescripcion.getWidth(),_lbldescripcion.getHeight());
RDebugUtils.currentLine=12386349;
 //BA.debugLineNum = 12386349;BA.debugLine="pbProgreso.Initialize(\"pgProgreso\")";
_pbprogreso.Initialize(mostCurrent.activityBA,"pgProgreso");
RDebugUtils.currentLine=12386350;
 //BA.debugLineNum = 12386350;BA.debugLine="pbProgreso.Width = pnlMetaAhorro.Width * 0.9";
_pbprogreso.setWidth((int) (_pnlmetaahorro.getWidth()*0.9));
RDebugUtils.currentLine=12386351;
 //BA.debugLineNum = 12386351;BA.debugLine="pbProgreso.Height = pnlMetaAhorro.Height * 0.15";
_pbprogreso.setHeight((int) (_pnlmetaahorro.getHeight()*0.15));
RDebugUtils.currentLine=12386352;
 //BA.debugLineNum = 12386352;BA.debugLine="pbProgreso.Top = lblDescripcion.Top + lblDescripc";
_pbprogreso.setTop((int) (_lbldescripcion.getTop()+_lbldescripcion.getHeight()));
RDebugUtils.currentLine=12386353;
 //BA.debugLineNum = 12386353;BA.debugLine="pbProgreso.Left = (pnlMetaAhorro.Width - pbProgre";
_pbprogreso.setLeft((int) ((_pnlmetaahorro.getWidth()-_pbprogreso.getWidth())/(double)2));
RDebugUtils.currentLine=12386354;
 //BA.debugLineNum = 12386354;BA.debugLine="If(datos.progreso <> 0 Or datos.periodo <> Null)";
if ((_datos.progreso /*int*/ !=0 || _datos.periodo /*String*/ != null)) { 
RDebugUtils.currentLine=12386355;
 //BA.debugLineNum = 12386355;BA.debugLine="pbProgreso.Progress = (datos.progreso * 100) / d";
_pbprogreso.setProgress((int) ((_datos.progreso /*int*/ *100)/(double)_datos.montoFinal /*int*/ ));
 }else {
RDebugUtils.currentLine=12386357;
 //BA.debugLineNum = 12386357;BA.debugLine="pbProgreso.Progress = 0";
_pbprogreso.setProgress((int) (0));
 };
RDebugUtils.currentLine=12386359;
 //BA.debugLineNum = 12386359;BA.debugLine="pnlMetaAhorro.AddView(pbProgreso, pbProgreso.Left";
_pnlmetaahorro.AddView((android.view.View)(_pbprogreso.getObject()),_pbprogreso.getLeft(),_pbprogreso.getTop(),_pbprogreso.getWidth(),_pbprogreso.getHeight());
RDebugUtils.currentLine=12386361;
 //BA.debugLineNum = 12386361;BA.debugLine="lblProgreso.Initialize(\"lblProgreso\")";
_lblprogreso.Initialize(mostCurrent.activityBA,"lblProgreso");
RDebugUtils.currentLine=12386362;
 //BA.debugLineNum = 12386362;BA.debugLine="lblProgreso.TextColor = Colors.Black";
_lblprogreso.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=12386365;
 //BA.debugLineNum = 12386365;BA.debugLine="lblProgreso.Width = cvsTest.MeasureStringWidth(\"$";
_lblprogreso.setWidth((int) (mostCurrent._cvstest.MeasureStringWidth("$"+BA.NumberToString(_datos.progreso /*int*/ ),anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT,_lblprogreso.getTextSize())+2));
RDebugUtils.currentLine=12386366;
 //BA.debugLineNum = 12386366;BA.debugLine="lblProgreso.Height = stu.MeasureMultilineTextHeig";
_lblprogreso.setHeight((int) (mostCurrent._stu.MeasureMultilineTextHeight((android.widget.TextView)(_lblprogreso.getObject()),BA.ObjectToCharSequence("$"+BA.NumberToString(_datos.progreso /*int*/ )))+2));
RDebugUtils.currentLine=12386367;
 //BA.debugLineNum = 12386367;BA.debugLine="lblProgreso.Text = \"$\" & datos.progreso";
_lblprogreso.setText(BA.ObjectToCharSequence("$"+BA.NumberToString(_datos.progreso /*int*/ )));
RDebugUtils.currentLine=12386369;
 //BA.debugLineNum = 12386369;BA.debugLine="lblProgreso.Left = (pbProgreso.Width - lblProgres";
_lblprogreso.setLeft((int) ((_pbprogreso.getWidth()-_lblprogreso.getWidth())*(_pbprogreso.getProgress()/(double)100)+_pbprogreso.getLeft()));
RDebugUtils.currentLine=12386370;
 //BA.debugLineNum = 12386370;BA.debugLine="lblProgreso.Top = pbProgreso.Top + pbProgreso.Hei";
_lblprogreso.setTop((int) (_pbprogreso.getTop()+_pbprogreso.getHeight()));
RDebugUtils.currentLine=12386371;
 //BA.debugLineNum = 12386371;BA.debugLine="pnlMetaAhorro.AddView(lblProgreso, lblProgreso.Le";
_pnlmetaahorro.AddView((android.view.View)(_lblprogreso.getObject()),_lblprogreso.getLeft(),_lblprogreso.getTop(),_lblprogreso.getWidth(),_lblprogreso.getHeight());
RDebugUtils.currentLine=12386373;
 //BA.debugLineNum = 12386373;BA.debugLine="lblPeriodoYMonto.Initialize(\"lblPeriodoYMonto\")";
_lblperiodoymonto.Initialize(mostCurrent.activityBA,"lblPeriodoYMonto");
RDebugUtils.currentLine=12386375;
 //BA.debugLineNum = 12386375;BA.debugLine="Dim textoPeriodo As String";
_textoperiodo = "";
RDebugUtils.currentLine=12386376;
 //BA.debugLineNum = 12386376;BA.debugLine="If (datos.periodo = 7) Then";
if (((_datos.periodo /*String*/ ).equals(BA.NumberToString(7)))) { 
RDebugUtils.currentLine=12386377;
 //BA.debugLineNum = 12386377;BA.debugLine="textoPeriodo = \"1 semana\"";
_textoperiodo = "1 semana";
 }else 
{RDebugUtils.currentLine=12386378;
 //BA.debugLineNum = 12386378;BA.debugLine="Else If (datos.periodo = 14) Then";
if (((_datos.periodo /*String*/ ).equals(BA.NumberToString(14)))) { 
RDebugUtils.currentLine=12386379;
 //BA.debugLineNum = 12386379;BA.debugLine="textoPeriodo = \"2 semanas\"";
_textoperiodo = "2 semanas";
 }else 
{RDebugUtils.currentLine=12386380;
 //BA.debugLineNum = 12386380;BA.debugLine="Else If (datos.periodo = 21) Then";
if (((_datos.periodo /*String*/ ).equals(BA.NumberToString(21)))) { 
RDebugUtils.currentLine=12386381;
 //BA.debugLineNum = 12386381;BA.debugLine="textoPeriodo = \"3 semanas\"";
_textoperiodo = "3 semanas";
 }else 
{RDebugUtils.currentLine=12386382;
 //BA.debugLineNum = 12386382;BA.debugLine="Else If (datos.periodo = 30) Then";
if (((_datos.periodo /*String*/ ).equals(BA.NumberToString(30)))) { 
RDebugUtils.currentLine=12386383;
 //BA.debugLineNum = 12386383;BA.debugLine="textoPeriodo = \"1 mes\"";
_textoperiodo = "1 mes";
 }else 
{RDebugUtils.currentLine=12386384;
 //BA.debugLineNum = 12386384;BA.debugLine="Else If (datos.periodo = 365) Then";
if (((_datos.periodo /*String*/ ).equals(BA.NumberToString(365)))) { 
RDebugUtils.currentLine=12386385;
 //BA.debugLineNum = 12386385;BA.debugLine="textoPeriodo = \"1 año\"";
_textoperiodo = "1 año";
 }}}}}
;
RDebugUtils.currentLine=12386388;
 //BA.debugLineNum = 12386388;BA.debugLine="lblPeriodoYMonto.Text = textoPeriodo & \": $\" & da";
_lblperiodoymonto.setText(BA.ObjectToCharSequence(_textoperiodo+": $"+BA.NumberToString(_datos.montoPeriodico /*int*/ )));
RDebugUtils.currentLine=12386389;
 //BA.debugLineNum = 12386389;BA.debugLine="lblPeriodoYMonto.TextSize = 16";
_lblperiodoymonto.setTextSize((float) (16));
RDebugUtils.currentLine=12386390;
 //BA.debugLineNum = 12386390;BA.debugLine="lblPeriodoYMonto.TextColor = Colors.DarkGray";
_lblperiodoymonto.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.DarkGray);
RDebugUtils.currentLine=12386391;
 //BA.debugLineNum = 12386391;BA.debugLine="lblPeriodoYMonto.Height = pnlMetaAhorro.Height *";
_lblperiodoymonto.setHeight((int) (_pnlmetaahorro.getHeight()*0.25));
RDebugUtils.currentLine=12386392;
 //BA.debugLineNum = 12386392;BA.debugLine="lblPeriodoYMonto.Width = pnlMetaAhorro.Width * 0.";
_lblperiodoymonto.setWidth((int) (_pnlmetaahorro.getWidth()*0.9));
RDebugUtils.currentLine=12386393;
 //BA.debugLineNum = 12386393;BA.debugLine="lblPeriodoYMonto.Top = lblProgreso.Top + lblProgr";
_lblperiodoymonto.setTop((int) (_lblprogreso.getTop()+_lblprogreso.getHeight()));
RDebugUtils.currentLine=12386394;
 //BA.debugLineNum = 12386394;BA.debugLine="lblPeriodoYMonto.Left = lblNombre.Left";
_lblperiodoymonto.setLeft(_lblnombre.getLeft());
RDebugUtils.currentLine=12386395;
 //BA.debugLineNum = 12386395;BA.debugLine="pnlMetaAhorro.AddView(lblPeriodoYMonto, lblPeriod";
_pnlmetaahorro.AddView((android.view.View)(_lblperiodoymonto.getObject()),_lblperiodoymonto.getLeft(),_lblperiodoymonto.getTop(),_lblperiodoymonto.getWidth(),_lblperiodoymonto.getHeight());
RDebugUtils.currentLine=12386397;
 //BA.debugLineNum = 12386397;BA.debugLine="lblMontoFinal.Initialize(\"lblMontoFinal\")";
_lblmontofinal.Initialize(mostCurrent.activityBA,"lblMontoFinal");
RDebugUtils.currentLine=12386398;
 //BA.debugLineNum = 12386398;BA.debugLine="lblMontoFinal.Text = \"$\" & datos.montoFinal";
_lblmontofinal.setText(BA.ObjectToCharSequence("$"+BA.NumberToString(_datos.montoFinal /*int*/ )));
RDebugUtils.currentLine=12386399;
 //BA.debugLineNum = 12386399;BA.debugLine="lblMontoFinal.TextSize = 18";
_lblmontofinal.setTextSize((float) (18));
RDebugUtils.currentLine=12386400;
 //BA.debugLineNum = 12386400;BA.debugLine="lblMontoFinal.TextColor = Colors.Red";
_lblmontofinal.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=12386401;
 //BA.debugLineNum = 12386401;BA.debugLine="lblMontoFinal.Height = pnlMetaAhorro.Height * 0.2";
_lblmontofinal.setHeight((int) (_pnlmetaahorro.getHeight()*0.25));
RDebugUtils.currentLine=12386402;
 //BA.debugLineNum = 12386402;BA.debugLine="lblMontoFinal.Width = pnlMetaAhorro.Width * 0.2";
_lblmontofinal.setWidth((int) (_pnlmetaahorro.getWidth()*0.2));
RDebugUtils.currentLine=12386403;
 //BA.debugLineNum = 12386403;BA.debugLine="lblMontoFinal.Top = lblPeriodoYMonto.Top";
_lblmontofinal.setTop(_lblperiodoymonto.getTop());
RDebugUtils.currentLine=12386404;
 //BA.debugLineNum = 12386404;BA.debugLine="lblMontoFinal.Left = pnlMetaAhorro.Width - lblMon";
_lblmontofinal.setLeft((int) (_pnlmetaahorro.getWidth()-_lblmontofinal.getWidth()-_lblnombre.getLeft()));
RDebugUtils.currentLine=12386405;
 //BA.debugLineNum = 12386405;BA.debugLine="pnlMetaAhorro.AddView(lblMontoFinal, lblMontoFina";
_pnlmetaahorro.AddView((android.view.View)(_lblmontofinal.getObject()),_lblmontofinal.getLeft(),_lblmontofinal.getTop(),_lblmontofinal.getWidth(),_lblmontofinal.getHeight());
RDebugUtils.currentLine=12386407;
 //BA.debugLineNum = 12386407;BA.debugLine="lblOpciones.Initialize(\"lblOpciones\")";
_lblopciones.Initialize(mostCurrent.activityBA,"lblOpciones");
RDebugUtils.currentLine=12386408;
 //BA.debugLineNum = 12386408;BA.debugLine="lblOpciones.Typeface = Typeface.FONTAWESOME";
_lblopciones.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getFONTAWESOME());
RDebugUtils.currentLine=12386409;
 //BA.debugLineNum = 12386409;BA.debugLine="lblOpciones.Text = Chr(0xF142)";
_lblopciones.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf142))));
RDebugUtils.currentLine=12386410;
 //BA.debugLineNum = 12386410;BA.debugLine="lblOpciones.TextSize = 18";
_lblopciones.setTextSize((float) (18));
RDebugUtils.currentLine=12386411;
 //BA.debugLineNum = 12386411;BA.debugLine="lblOpciones.TextColor = Colors.White";
_lblopciones.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=12386412;
 //BA.debugLineNum = 12386412;BA.debugLine="lblOpciones.Height = lblNombre.Height";
_lblopciones.setHeight(_lblnombre.getHeight());
RDebugUtils.currentLine=12386413;
 //BA.debugLineNum = 12386413;BA.debugLine="lblOpciones.Width = 8dip";
_lblopciones.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (8)));
RDebugUtils.currentLine=12386414;
 //BA.debugLineNum = 12386414;BA.debugLine="lblOpciones.Left = lblMontoFinal.Left + lblMontoF";
_lblopciones.setLeft((int) (_lblmontofinal.getLeft()+_lblmontofinal.getWidth()-_lblopciones.getWidth()));
RDebugUtils.currentLine=12386415;
 //BA.debugLineNum = 12386415;BA.debugLine="lblOpciones.Top = pnlMetaAhorro.Height * 0.12";
_lblopciones.setTop((int) (_pnlmetaahorro.getHeight()*0.12));
RDebugUtils.currentLine=12386416;
 //BA.debugLineNum = 12386416;BA.debugLine="pnlMetaAhorro.AddView(lblOpciones, lblOpciones.Le";
_pnlmetaahorro.AddView((android.view.View)(_lblopciones.getObject()),_lblopciones.getLeft(),_lblopciones.getTop(),_lblopciones.getWidth(),_lblopciones.getHeight());
RDebugUtils.currentLine=12386418;
 //BA.debugLineNum = 12386418;BA.debugLine="pnlOpciones.Initialize(\"pnlOpciones\")";
_pnlopciones.Initialize(mostCurrent.activityBA,"pnlOpciones");
RDebugUtils.currentLine=12386419;
 //BA.debugLineNum = 12386419;BA.debugLine="cd.Initialize(Colors.Black, 20)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.Black,(int) (20));
RDebugUtils.currentLine=12386420;
 //BA.debugLineNum = 12386420;BA.debugLine="pnlOpciones.Background = cd";
_pnlopciones.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=12386421;
 //BA.debugLineNum = 12386421;BA.debugLine="pnlOpciones.Height = pnlMetaAhorro.Height * 0.8";
_pnlopciones.setHeight((int) (_pnlmetaahorro.getHeight()*0.8));
RDebugUtils.currentLine=12386422;
 //BA.debugLineNum = 12386422;BA.debugLine="pnlOpciones.Width = pnlMetaAhorro.Height";
_pnlopciones.setWidth(_pnlmetaahorro.getHeight());
RDebugUtils.currentLine=12386423;
 //BA.debugLineNum = 12386423;BA.debugLine="pnlOpciones.Top = lblOpciones.Top";
_pnlopciones.setTop(_lblopciones.getTop());
RDebugUtils.currentLine=12386424;
 //BA.debugLineNum = 12386424;BA.debugLine="pnlOpciones.Left = lblOpciones.Left - lblOpciones";
_pnlopciones.setLeft((int) (_lblopciones.getLeft()-_lblopciones.getWidth()*2-_pnlopciones.getWidth()));
RDebugUtils.currentLine=12386425;
 //BA.debugLineNum = 12386425;BA.debugLine="pnlOpciones.Visible = False";
_pnlopciones.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=12386426;
 //BA.debugLineNum = 12386426;BA.debugLine="pnlMetaAhorro.AddView(pnlOpciones, pnlOpciones.Le";
_pnlmetaahorro.AddView((android.view.View)(_pnlopciones.getObject()),_pnlopciones.getLeft(),_pnlopciones.getTop(),_pnlopciones.getWidth(),_pnlopciones.getHeight());
RDebugUtils.currentLine=12386428;
 //BA.debugLineNum = 12386428;BA.debugLine="btnEditar.Initialize(\"btnEditar\")";
_btneditar.Initialize(mostCurrent.activityBA,"btnEditar");
RDebugUtils.currentLine=12386429;
 //BA.debugLineNum = 12386429;BA.debugLine="btnEditar.Color = Colors.Transparent";
_btneditar.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=12386430;
 //BA.debugLineNum = 12386430;BA.debugLine="btnEditar.Text = \"Editar\"";
_btneditar.setText(BA.ObjectToCharSequence("Editar"));
RDebugUtils.currentLine=12386431;
 //BA.debugLineNum = 12386431;BA.debugLine="btnEditar.TextColor = Colors.White";
_btneditar.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=12386432;
 //BA.debugLineNum = 12386432;BA.debugLine="btnEditar.TextSize = 14";
_btneditar.setTextSize((float) (14));
RDebugUtils.currentLine=12386433;
 //BA.debugLineNum = 12386433;BA.debugLine="btnEditar.Height = pnlOpciones.Height * 0.4";
_btneditar.setHeight((int) (_pnlopciones.getHeight()*0.4));
RDebugUtils.currentLine=12386434;
 //BA.debugLineNum = 12386434;BA.debugLine="btnEditar.Width = pnlOpciones.Height * 0.8";
_btneditar.setWidth((int) (_pnlopciones.getHeight()*0.8));
RDebugUtils.currentLine=12386435;
 //BA.debugLineNum = 12386435;BA.debugLine="btnEditar.Top = (pnlOpciones.Height * 0.2) / 3";
_btneditar.setTop((int) ((_pnlopciones.getHeight()*0.2)/(double)3));
RDebugUtils.currentLine=12386436;
 //BA.debugLineNum = 12386436;BA.debugLine="btnEditar.Left = (pnlOpciones.Width - btnEditar.W";
_btneditar.setLeft((int) ((_pnlopciones.getWidth()-_btneditar.getWidth())/(double)2));
RDebugUtils.currentLine=12386437;
 //BA.debugLineNum = 12386437;BA.debugLine="pnlOpciones.AddView(btnEditar, btnEditar.Left, bt";
_pnlopciones.AddView((android.view.View)(_btneditar.getObject()),_btneditar.getLeft(),_btneditar.getTop(),_btneditar.getWidth(),_btneditar.getHeight());
RDebugUtils.currentLine=12386439;
 //BA.debugLineNum = 12386439;BA.debugLine="btnEliminar.Initialize(\"btnEliminar\")";
_btneliminar.Initialize(mostCurrent.activityBA,"btnEliminar");
RDebugUtils.currentLine=12386440;
 //BA.debugLineNum = 12386440;BA.debugLine="btnEliminar.Color = Colors.Transparent";
_btneliminar.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=12386441;
 //BA.debugLineNum = 12386441;BA.debugLine="btnEliminar.Text = \"Eliminar\"";
_btneliminar.setText(BA.ObjectToCharSequence("Eliminar"));
RDebugUtils.currentLine=12386442;
 //BA.debugLineNum = 12386442;BA.debugLine="btnEliminar.TextColor = Colors.White";
_btneliminar.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=12386443;
 //BA.debugLineNum = 12386443;BA.debugLine="btnEliminar.TextSize = 14";
_btneliminar.setTextSize((float) (14));
RDebugUtils.currentLine=12386444;
 //BA.debugLineNum = 12386444;BA.debugLine="btnEliminar.Height = btnEditar.Height";
_btneliminar.setHeight(_btneditar.getHeight());
RDebugUtils.currentLine=12386445;
 //BA.debugLineNum = 12386445;BA.debugLine="btnEliminar.Width = pnlOpciones.Width * 0.9";
_btneliminar.setWidth((int) (_pnlopciones.getWidth()*0.9));
RDebugUtils.currentLine=12386446;
 //BA.debugLineNum = 12386446;BA.debugLine="btnEliminar.Top = btnEditar.Top * 2 + btnEditar.H";
_btneliminar.setTop((int) (_btneditar.getTop()*2+_btneditar.getHeight()));
RDebugUtils.currentLine=12386447;
 //BA.debugLineNum = 12386447;BA.debugLine="btnEliminar.Left = (pnlOpciones.Width - btnElimin";
_btneliminar.setLeft((int) ((_pnlopciones.getWidth()-_btneliminar.getWidth())/(double)2));
RDebugUtils.currentLine=12386448;
 //BA.debugLineNum = 12386448;BA.debugLine="pnlOpciones.AddView(btnEliminar, btnEliminar.Left";
_pnlopciones.AddView((android.view.View)(_btneliminar.getObject()),_btneliminar.getLeft(),_btneliminar.getTop(),_btneliminar.getWidth(),_btneliminar.getHeight());
RDebugUtils.currentLine=12386450;
 //BA.debugLineNum = 12386450;BA.debugLine="pnlDeslizable.AddView(pnlMetaAhorro, pnlMetaAhorr";
mostCurrent._pnldeslizable.AddView((android.view.View)(_pnlmetaahorro.getObject()),_pnlmetaahorro.getLeft(),_top,_pnlmetaahorro.getWidth(),_pnlmetaahorro.getHeight());
RDebugUtils.currentLine=12386453;
 //BA.debugLineNum = 12386453;BA.debugLine="Dim referencia As IndiceSuscripcion";
_referencia = new pullup.wallet.suscripciones._indicesuscripcion();
RDebugUtils.currentLine=12386454;
 //BA.debugLineNum = 12386454;BA.debugLine="referencia.indiceElemento = indice";
_referencia.indiceElemento /*int*/  = _indice;
RDebugUtils.currentLine=12386455;
 //BA.debugLineNum = 12386455;BA.debugLine="referencia.rowid = 0";
_referencia.rowid /*int*/  = (int) (0);
RDebugUtils.currentLine=12386457;
 //BA.debugLineNum = 12386457;BA.debugLine="lblOpciones.Tag = referencia";
_lblopciones.setTag((Object)(_referencia));
RDebugUtils.currentLine=12386460;
 //BA.debugLineNum = 12386460;BA.debugLine="Dim referencia2 As IndiceSuscripcion";
_referencia2 = new pullup.wallet.suscripciones._indicesuscripcion();
RDebugUtils.currentLine=12386461;
 //BA.debugLineNum = 12386461;BA.debugLine="referencia2.indiceElemento = 0";
_referencia2.indiceElemento /*int*/  = (int) (0);
RDebugUtils.currentLine=12386462;
 //BA.debugLineNum = 12386462;BA.debugLine="referencia2.rowid = datos.rowid";
_referencia2.rowid /*int*/  = _datos.rowid /*int*/ ;
RDebugUtils.currentLine=12386464;
 //BA.debugLineNum = 12386464;BA.debugLine="pnlOpciones.Tag = referencia2";
_pnlopciones.setTag((Object)(_referencia2));
RDebugUtils.currentLine=12386467;
 //BA.debugLineNum = 12386467;BA.debugLine="Relaciones(indice, 0) = lblOpciones";
mostCurrent._relaciones[_indice][(int) (0)] = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lblopciones.getObject()));
RDebugUtils.currentLine=12386468;
 //BA.debugLineNum = 12386468;BA.debugLine="Relaciones(indice, 1) = pnlOpciones";
mostCurrent._relaciones[_indice][(int) (1)] = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnlopciones.getObject()));
RDebugUtils.currentLine=12386471;
 //BA.debugLineNum = 12386471;BA.debugLine="arrayPnlsOpciones(indice) = pnlOpciones";
mostCurrent._arraypnlsopciones[_indice] = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnlopciones.getObject()));
RDebugUtils.currentLine=12386472;
 //BA.debugLineNum = 12386472;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="metasdeahorro";
RDebugUtils.currentLine=12255232;
 //BA.debugLineNum = 12255232;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=12255234;
 //BA.debugLineNum = 12255234;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="metasdeahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=12189696;
 //BA.debugLineNum = 12189696;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=12189698;
 //BA.debugLineNum = 12189698;BA.debugLine="End Sub";
return "";
}
public static String  _btneditar_click() throws Exception{
RDebugUtils.currentModule="metasdeahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btneditar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btneditar_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btneditar = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlpadre = null;
int _idregistro = 0;
pullup.wallet.suscripciones._indicesuscripcion _indice = null;
RDebugUtils.currentLine=12517376;
 //BA.debugLineNum = 12517376;BA.debugLine="Sub btnEditar_Click";
RDebugUtils.currentLine=12517377;
 //BA.debugLineNum = 12517377;BA.debugLine="Dim btnEditar As Button";
_btneditar = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=12517378;
 //BA.debugLineNum = 12517378;BA.debugLine="Dim pnlPadre As Panel";
_pnlpadre = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=12517379;
 //BA.debugLineNum = 12517379;BA.debugLine="Dim idRegistro As Int";
_idregistro = 0;
RDebugUtils.currentLine=12517380;
 //BA.debugLineNum = 12517380;BA.debugLine="Dim indice As IndiceSuscripcion";
_indice = new pullup.wallet.suscripciones._indicesuscripcion();
RDebugUtils.currentLine=12517383;
 //BA.debugLineNum = 12517383;BA.debugLine="btnEditar = Sender";
_btneditar = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=12517385;
 //BA.debugLineNum = 12517385;BA.debugLine="pnlPadre = btnEditar.Parent";
_pnlpadre = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_btneditar.getParent()));
RDebugUtils.currentLine=12517387;
 //BA.debugLineNum = 12517387;BA.debugLine="indice = pnlPadre.Tag";
_indice = (pullup.wallet.suscripciones._indicesuscripcion)(_pnlpadre.getTag());
RDebugUtils.currentLine=12517389;
 //BA.debugLineNum = 12517389;BA.debugLine="idRegistro = indice.rowid";
_idregistro = _indice.rowid /*int*/ ;
RDebugUtils.currentLine=12517390;
 //BA.debugLineNum = 12517390;BA.debugLine="CallSubDelayed2(editarMetaAhorro, \"consultaAEdita";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._editarmetaahorro.getObject()),"consultaAEditar",(Object)(_idregistro));
RDebugUtils.currentLine=12517391;
 //BA.debugLineNum = 12517391;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=12517392;
 //BA.debugLineNum = 12517392;BA.debugLine="End Sub";
return "";
}
public static String  _btneliminar_click() throws Exception{
RDebugUtils.currentModule="metasdeahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btneliminar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btneliminar_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btneliminar = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlpadre = null;
int _idregistro = 0;
pullup.wallet.suscripciones._indicesuscripcion _indice = null;
int _resultado = 0;
RDebugUtils.currentLine=12582912;
 //BA.debugLineNum = 12582912;BA.debugLine="Sub btnEliminar_Click";
RDebugUtils.currentLine=12582913;
 //BA.debugLineNum = 12582913;BA.debugLine="Dim btnEliminar As Button";
_btneliminar = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=12582914;
 //BA.debugLineNum = 12582914;BA.debugLine="Dim pnlPadre As Panel";
_pnlpadre = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=12582915;
 //BA.debugLineNum = 12582915;BA.debugLine="Dim idRegistro As Int";
_idregistro = 0;
RDebugUtils.currentLine=12582916;
 //BA.debugLineNum = 12582916;BA.debugLine="Dim indice As IndiceSuscripcion";
_indice = new pullup.wallet.suscripciones._indicesuscripcion();
RDebugUtils.currentLine=12582919;
 //BA.debugLineNum = 12582919;BA.debugLine="btnEliminar = Sender";
_btneliminar = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=12582921;
 //BA.debugLineNum = 12582921;BA.debugLine="pnlPadre = btnEliminar.Parent";
_pnlpadre = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_btneliminar.getParent()));
RDebugUtils.currentLine=12582923;
 //BA.debugLineNum = 12582923;BA.debugLine="indice = pnlPadre.Tag";
_indice = (pullup.wallet.suscripciones._indicesuscripcion)(_pnlpadre.getTag());
RDebugUtils.currentLine=12582925;
 //BA.debugLineNum = 12582925;BA.debugLine="idRegistro = indice.rowid";
_idregistro = _indice.rowid /*int*/ ;
RDebugUtils.currentLine=12582928;
 //BA.debugLineNum = 12582928;BA.debugLine="Dim resultado As Int";
_resultado = 0;
RDebugUtils.currentLine=12582929;
 //BA.debugLineNum = 12582929;BA.debugLine="resultado = Msgbox2(\"¿Estás seguro?\", \"Eliminar m";
_resultado = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("¿Estás seguro?"),BA.ObjectToCharSequence("Eliminar meta de ahorro"),"Sí","","No",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=12582930;
 //BA.debugLineNum = 12582930;BA.debugLine="If (resultado = DialogResponse.POSITIVE) Then";
if ((_resultado==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE)) { 
RDebugUtils.currentLine=12582932;
 //BA.debugLineNum = 12582932;BA.debugLine="sql.ExecNonQuery(\"DELETE FROM metas_ahorro WHERE";
_sql.ExecNonQuery("DELETE FROM metas_ahorro WHERE id_meta_ahorro = '"+BA.NumberToString(_idregistro)+"'");
RDebugUtils.currentLine=12582935;
 //BA.debugLineNum = 12582935;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=12582936;
 //BA.debugLineNum = 12582936;BA.debugLine="StartActivity(Me)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,metasdeahorro.getObject());
 };
RDebugUtils.currentLine=12582938;
 //BA.debugLineNum = 12582938;BA.debugLine="End Sub";
return "";
}
public static String  _btnmenu_click() throws Exception{
RDebugUtils.currentModule="metasdeahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnmenu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnmenu_click", null));}
RDebugUtils.currentLine=12320768;
 //BA.debugLineNum = 12320768;BA.debugLine="Private Sub btnMenu_Click";
RDebugUtils.currentLine=12320769;
 //BA.debugLineNum = 12320769;BA.debugLine="CallSubDelayed(Main, \"actualizarDatos\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._main.getObject()),"actualizarDatos");
RDebugUtils.currentLine=12320770;
 //BA.debugLineNum = 12320770;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=12320771;
 //BA.debugLineNum = 12320771;BA.debugLine="End Sub";
return "";
}
public static String  _lblopciones_click() throws Exception{
RDebugUtils.currentModule="metasdeahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblopciones_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblopciones_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _lblopcion = null;
pullup.wallet.suscripciones._indicesuscripcion _indice = null;
int _contador = 0;
RDebugUtils.currentLine=12451840;
 //BA.debugLineNum = 12451840;BA.debugLine="Sub lblOpciones_Click";
RDebugUtils.currentLine=12451841;
 //BA.debugLineNum = 12451841;BA.debugLine="Dim lblOpcion As Label";
_lblopcion = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=12451842;
 //BA.debugLineNum = 12451842;BA.debugLine="Dim indice As IndiceSuscripcion";
_indice = new pullup.wallet.suscripciones._indicesuscripcion();
RDebugUtils.currentLine=12451844;
 //BA.debugLineNum = 12451844;BA.debugLine="lblOpcion = Sender";
_lblopcion = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=12451845;
 //BA.debugLineNum = 12451845;BA.debugLine="indice = lblOpcion.Tag";
_indice = (pullup.wallet.suscripciones._indicesuscripcion)(_lblopcion.getTag());
RDebugUtils.currentLine=12451848;
 //BA.debugLineNum = 12451848;BA.debugLine="For contador = 0 To arrayPnlsOpciones.Length - 1";
{
final int step5 = 1;
final int limit5 = (int) (mostCurrent._arraypnlsopciones.length-1);
_contador = (int) (0) ;
for (;_contador <= limit5 ;_contador = _contador + step5 ) {
RDebugUtils.currentLine=12451849;
 //BA.debugLineNum = 12451849;BA.debugLine="If (contador <> indice.indiceElemento) Then";
if ((_contador!=_indice.indiceElemento /*int*/ )) { 
RDebugUtils.currentLine=12451850;
 //BA.debugLineNum = 12451850;BA.debugLine="arrayPnlsOpciones(contador).Visible = False";
mostCurrent._arraypnlsopciones[_contador].setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 }
};
RDebugUtils.currentLine=12451855;
 //BA.debugLineNum = 12451855;BA.debugLine="Relaciones(indice.indiceElemento, 1).SetVisibleAn";
mostCurrent._relaciones[_indice.indiceElemento /*int*/ ][(int) (1)].SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.Not(mostCurrent._relaciones[_indice.indiceElemento /*int*/ ][(int) (1)].getVisible()));
RDebugUtils.currentLine=12451856;
 //BA.debugLineNum = 12451856;BA.debugLine="End Sub";
return "";
}
}