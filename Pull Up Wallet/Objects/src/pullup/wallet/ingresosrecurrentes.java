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

public class ingresosrecurrentes extends Activity implements B4AActivity{
	public static ingresosrecurrentes mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "pullup.wallet", "pullup.wallet.ingresosrecurrentes");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (ingresosrecurrentes).");
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
		activityBA = new BA(this, layout, processBA, "pullup.wallet", "pullup.wallet.ingresosrecurrentes");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "pullup.wallet.ingresosrecurrentes", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (ingresosrecurrentes) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (ingresosrecurrentes) Resume **");
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
		return ingresosrecurrentes.class;
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
            BA.LogInfo("** Activity (ingresosrecurrentes) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (ingresosrecurrentes) Pause event (activity is not paused). **");
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
            ingresosrecurrentes mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (ingresosrecurrentes) Resume **");
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


public static class _indiceingresorecurrente{
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
public static class _ingresorecurrente{
public boolean IsInitialized;
public int rowid;
public String nombre;
public int monto;
public String periodo;
public String descripcion;
public int color;
public void Initialize() {
IsInitialized = true;
rowid = 0;
nombre = "";
monto = 0;
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
public anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvstest = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmptest = null;
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
public pullup.wallet.ingresosunicos _ingresosunicos = null;
public pullup.wallet.metasdeahorro _metasdeahorro = null;
public pullup.wallet.registrargasto _registrargasto = null;
public pullup.wallet.registraringreso _registraringreso = null;
public pullup.wallet.registrarmetaahorro _registrarmetaahorro = null;
public pullup.wallet.registrarsuscripcion _registrarsuscripcion = null;
public pullup.wallet.suscripciones _suscripciones = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="ingresosrecurrentes";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.LabelWrapper _lblseccion = null;
int _top = 0;
int _id = 0;
pullup.wallet.ingresosrecurrentes._ingresorecurrente _datosingresorecurrente = null;
anywheresoftware.b4a.objects.LabelWrapper _lblmensaje = null;
RDebugUtils.currentLine=10813440;
 //BA.debugLineNum = 10813440;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=10813443;
 //BA.debugLineNum = 10813443;BA.debugLine="Activity.LoadLayout(\"LDeslizable\")";
mostCurrent._activity.LoadLayout("LDeslizable",mostCurrent.activityBA);
RDebugUtils.currentLine=10813444;
 //BA.debugLineNum = 10813444;BA.debugLine="Activity.Color = Colors.ARGB(255, 233, 236, 239)";
mostCurrent._activity.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (233),(int) (236),(int) (239)));
RDebugUtils.currentLine=10813445;
 //BA.debugLineNum = 10813445;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
_alturadispositivo = mostCurrent._main._alturadispositivo /*int*/ ;
RDebugUtils.currentLine=10813446;
 //BA.debugLineNum = 10813446;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
_anchodispositivo = mostCurrent._main._anchodispositivo /*int*/ ;
RDebugUtils.currentLine=10813447;
 //BA.debugLineNum = 10813447;BA.debugLine="bmpTest.InitializeMutable(1dip, 1dip)";
mostCurrent._bmptest.InitializeMutable(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)));
RDebugUtils.currentLine=10813448;
 //BA.debugLineNum = 10813448;BA.debugLine="cvsTest.Initialize2(bmpTest)";
mostCurrent._cvstest.Initialize2((android.graphics.Bitmap)(mostCurrent._bmptest.getObject()));
RDebugUtils.currentLine=10813451;
 //BA.debugLineNum = 10813451;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
mostCurrent._pnlnavinferior.setHeight((int) (_alturadispositivo*0.08));
RDebugUtils.currentLine=10813452;
 //BA.debugLineNum = 10813452;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
mostCurrent._pnlnavinferior.setWidth(_anchodispositivo);
RDebugUtils.currentLine=10813453;
 //BA.debugLineNum = 10813453;BA.debugLine="pnlNavInferior.Left = 0";
mostCurrent._pnlnavinferior.setLeft((int) (0));
RDebugUtils.currentLine=10813454;
 //BA.debugLineNum = 10813454;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
mostCurrent._pnlnavinferior.setTop((int) (_alturadispositivo-mostCurrent._pnlnavinferior.getHeight()));
RDebugUtils.currentLine=10813457;
 //BA.debugLineNum = 10813457;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
mostCurrent._btnmenu.setWidth((int) (_anchodispositivo*0.15));
RDebugUtils.currentLine=10813458;
 //BA.debugLineNum = 10813458;BA.debugLine="btnMenu.Height = btnMenu.Width";
mostCurrent._btnmenu.setHeight(mostCurrent._btnmenu.getWidth());
RDebugUtils.currentLine=10813459;
 //BA.debugLineNum = 10813459;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
mostCurrent._btnmenu.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._btnmenu.getHeight()/(double)2));
RDebugUtils.currentLine=10813460;
 //BA.debugLineNum = 10813460;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
mostCurrent._btnmenu.setLeft((int) ((_anchodispositivo-mostCurrent._btnmenu.getWidth())/(double)2));
RDebugUtils.currentLine=10813462;
 //BA.debugLineNum = 10813462;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
mostCurrent._lblcontornoboton.setWidth((int) (_anchodispositivo*0.17));
RDebugUtils.currentLine=10813463;
 //BA.debugLineNum = 10813463;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
mostCurrent._lblcontornoboton.setHeight(mostCurrent._lblcontornoboton.getWidth());
RDebugUtils.currentLine=10813464;
 //BA.debugLineNum = 10813464;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
mostCurrent._lblcontornoboton.setLeft((int) ((_anchodispositivo-mostCurrent._lblcontornoboton.getWidth())/(double)2));
RDebugUtils.currentLine=10813465;
 //BA.debugLineNum = 10813465;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
mostCurrent._lblcontornoboton.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._lblcontornoboton.getHeight()/(double)2));
RDebugUtils.currentLine=10813469;
 //BA.debugLineNum = 10813469;BA.debugLine="svPantalla.Height = pnlNavInferior.Top";
mostCurrent._svpantalla.setHeight(mostCurrent._pnlnavinferior.getTop());
RDebugUtils.currentLine=10813470;
 //BA.debugLineNum = 10813470;BA.debugLine="svPantalla.Panel.LoadLayout(\"LPantallaDeslizable\"";
mostCurrent._svpantalla.getPanel().LoadLayout("LPantallaDeslizable",mostCurrent.activityBA);
RDebugUtils.currentLine=10813471;
 //BA.debugLineNum = 10813471;BA.debugLine="svPantalla.Width = anchoDispositivo * 1.5";
mostCurrent._svpantalla.setWidth((int) (_anchodispositivo*1.5));
RDebugUtils.currentLine=10813472;
 //BA.debugLineNum = 10813472;BA.debugLine="pnlDeslizable.Width = svPantalla.Width";
mostCurrent._pnldeslizable.setWidth(mostCurrent._svpantalla.getWidth());
RDebugUtils.currentLine=10813478;
 //BA.debugLineNum = 10813478;BA.debugLine="Dim lblSeccion As Label";
_lblseccion = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=10813479;
 //BA.debugLineNum = 10813479;BA.debugLine="lblSeccion.Initialize(\"lblSeccion\")";
_lblseccion.Initialize(mostCurrent.activityBA,"lblSeccion");
RDebugUtils.currentLine=10813480;
 //BA.debugLineNum = 10813480;BA.debugLine="lblSeccion.Text = \"Ingresos recurrentes\"";
_lblseccion.setText(BA.ObjectToCharSequence("Ingresos recurrentes"));
RDebugUtils.currentLine=10813481;
 //BA.debugLineNum = 10813481;BA.debugLine="lblSeccion.TextSize = 20";
_lblseccion.setTextSize((float) (20));
RDebugUtils.currentLine=10813482;
 //BA.debugLineNum = 10813482;BA.debugLine="lblSeccion.TextColor = Colors.Black";
_lblseccion.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=10813483;
 //BA.debugLineNum = 10813483;BA.debugLine="lblSeccion.Height = 30dip";
_lblseccion.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=10813484;
 //BA.debugLineNum = 10813484;BA.debugLine="lblSeccion.Width = anchoDispositivo * 0.9";
_lblseccion.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=10813485;
 //BA.debugLineNum = 10813485;BA.debugLine="lblSeccion.Top = 30dip";
_lblseccion.setTop(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=10813486;
 //BA.debugLineNum = 10813486;BA.debugLine="lblSeccion.Left = (anchoDispositivo - lblSeccion.";
_lblseccion.setLeft((int) ((_anchodispositivo-_lblseccion.getWidth())/(double)2));
RDebugUtils.currentLine=10813487;
 //BA.debugLineNum = 10813487;BA.debugLine="pnlDeslizable.AddView(lblSeccion, lblSeccion.Left";
mostCurrent._pnldeslizable.AddView((android.view.View)(_lblseccion.getObject()),_lblseccion.getLeft(),_lblseccion.getTop(),_lblseccion.getWidth(),_lblseccion.getHeight());
RDebugUtils.currentLine=10813492;
 //BA.debugLineNum = 10813492;BA.debugLine="Dim top As Int";
_top = 0;
RDebugUtils.currentLine=10813493;
 //BA.debugLineNum = 10813493;BA.debugLine="top = lblSeccion.Top + lblSeccion.Height + 30dip";
_top = (int) (_lblseccion.getTop()+_lblseccion.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=10813496;
 //BA.debugLineNum = 10813496;BA.debugLine="sql = Starter.sql";
_sql = mostCurrent._starter._sql /*anywheresoftware.b4a.sql.SQL*/ ;
RDebugUtils.currentLine=10813497;
 //BA.debugLineNum = 10813497;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM ingresos_recur";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM ingresos_recurrentes ORDER BY rowid ASC")));
RDebugUtils.currentLine=10813498;
 //BA.debugLineNum = 10813498;BA.debugLine="nRegistros = cur.RowCount";
_nregistros = mostCurrent._cur.getRowCount();
RDebugUtils.currentLine=10813502;
 //BA.debugLineNum = 10813502;BA.debugLine="If nRegistros > 0 Then";
if (_nregistros>0) { 
RDebugUtils.currentLine=10813504;
 //BA.debugLineNum = 10813504;BA.debugLine="Dim Relaciones(nRegistros, 2) As B4XView";
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
RDebugUtils.currentLine=10813505;
 //BA.debugLineNum = 10813505;BA.debugLine="Dim arrayPnlsOpciones(nRegistros) As B4XView";
mostCurrent._arraypnlsopciones = new anywheresoftware.b4a.objects.B4XViewWrapper[_nregistros];
{
int d0 = mostCurrent._arraypnlsopciones.length;
for (int i0 = 0;i0 < d0;i0++) {
mostCurrent._arraypnlsopciones[i0] = new anywheresoftware.b4a.objects.B4XViewWrapper();
}
}
;
RDebugUtils.currentLine=10813507;
 //BA.debugLineNum = 10813507;BA.debugLine="For id = 0 To nRegistros - 1";
{
final int step41 = 1;
final int limit41 = (int) (_nregistros-1);
_id = (int) (0) ;
for (;_id <= limit41 ;_id = _id + step41 ) {
RDebugUtils.currentLine=10813508;
 //BA.debugLineNum = 10813508;BA.debugLine="cur.Position = id";
mostCurrent._cur.setPosition(_id);
RDebugUtils.currentLine=10813510;
 //BA.debugLineNum = 10813510;BA.debugLine="Dim datosIngresoRecurrente As IngresoRecurrente";
_datosingresorecurrente = new pullup.wallet.ingresosrecurrentes._ingresorecurrente();
RDebugUtils.currentLine=10813511;
 //BA.debugLineNum = 10813511;BA.debugLine="datosIngresoRecurrente.rowid = cur.GetInt(\"id_i";
_datosingresorecurrente.rowid /*int*/  = mostCurrent._cur.GetInt("id_ingreso_recurrente");
RDebugUtils.currentLine=10813512;
 //BA.debugLineNum = 10813512;BA.debugLine="datosIngresoRecurrente.nombre = cur.GetString(\"";
_datosingresorecurrente.nombre /*String*/  = mostCurrent._cur.GetString("nombre");
RDebugUtils.currentLine=10813513;
 //BA.debugLineNum = 10813513;BA.debugLine="datosIngresoRecurrente.monto = cur.GetInt(\"mont";
_datosingresorecurrente.monto /*int*/  = mostCurrent._cur.GetInt("monto");
RDebugUtils.currentLine=10813514;
 //BA.debugLineNum = 10813514;BA.debugLine="datosIngresoRecurrente.descripcion = cur.GetStr";
_datosingresorecurrente.descripcion /*String*/  = mostCurrent._cur.GetString("descripcion");
RDebugUtils.currentLine=10813515;
 //BA.debugLineNum = 10813515;BA.debugLine="datosIngresoRecurrente.periodo = cur.GetString(";
_datosingresorecurrente.periodo /*String*/  = mostCurrent._cur.GetString("periodo");
RDebugUtils.currentLine=10813516;
 //BA.debugLineNum = 10813516;BA.debugLine="datosIngresoRecurrente.color = cur.GetInt(\"colo";
_datosingresorecurrente.color /*int*/  = mostCurrent._cur.GetInt("color");
RDebugUtils.currentLine=10813518;
 //BA.debugLineNum = 10813518;BA.debugLine="creaObjetoLista(id, top, datosIngresoRecurrente";
_creaobjetolista(_id,_top,_datosingresorecurrente);
RDebugUtils.currentLine=10813520;
 //BA.debugLineNum = 10813520;BA.debugLine="top = top + alturaDispositivo * 0.12 + 60";
_top = (int) (_top+_alturadispositivo*0.12+60);
 }
};
 }else {
RDebugUtils.currentLine=10813524;
 //BA.debugLineNum = 10813524;BA.debugLine="Dim lblMensaje As Label";
_lblmensaje = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=10813525;
 //BA.debugLineNum = 10813525;BA.debugLine="lblMensaje.Initialize(\"lblMensaje\")";
_lblmensaje.Initialize(mostCurrent.activityBA,"lblMensaje");
RDebugUtils.currentLine=10813526;
 //BA.debugLineNum = 10813526;BA.debugLine="lblMensaje.Height = alturaDispositivo * 0.2";
_lblmensaje.setHeight((int) (_alturadispositivo*0.2));
RDebugUtils.currentLine=10813527;
 //BA.debugLineNum = 10813527;BA.debugLine="lblMensaje.Width = anchoDispositivo * 0.9";
_lblmensaje.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=10813528;
 //BA.debugLineNum = 10813528;BA.debugLine="lblMensaje.Top = (alturaDispositivo - lblMensaje";
_lblmensaje.setTop((int) ((_alturadispositivo-_lblmensaje.getHeight())/(double)2));
RDebugUtils.currentLine=10813529;
 //BA.debugLineNum = 10813529;BA.debugLine="lblMensaje.Left = (anchoDispositivo - lblMensaje";
_lblmensaje.setLeft((int) ((_anchodispositivo-_lblmensaje.getWidth())/(double)2));
RDebugUtils.currentLine=10813530;
 //BA.debugLineNum = 10813530;BA.debugLine="lblMensaje.Text = cs.Initialize.Color(Colors.Bla";
_lblmensaje.setText(BA.ObjectToCharSequence(mostCurrent._cs.Initialize().Color(anywheresoftware.b4a.keywords.Common.Colors.Black).Alignment(BA.getEnumFromString(android.text.Layout.Alignment.class,"ALIGN_CENTER")).Typeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS()).Size((int) (50)).Append(BA.ObjectToCharSequence(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (0xe89c)))+anywheresoftware.b4a.keywords.Common.CRLF)).Typeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT).Size((int) (18)).Append(BA.ObjectToCharSequence("Está muy vacío aquí adentro."+anywheresoftware.b4a.keywords.Common.CRLF)).Append(BA.ObjectToCharSequence("Agrega un ingreso recurrente desde el menú principal.")).PopAll().getObject()));
RDebugUtils.currentLine=10813531;
 //BA.debugLineNum = 10813531;BA.debugLine="Activity.AddView(lblMensaje, lblMensaje.Left, lb";
mostCurrent._activity.AddView((android.view.View)(_lblmensaje.getObject()),_lblmensaje.getLeft(),_lblmensaje.getTop(),_lblmensaje.getWidth(),_lblmensaje.getHeight());
 };
RDebugUtils.currentLine=10813534;
 //BA.debugLineNum = 10813534;BA.debugLine="svPantalla.Panel.Height = top + 100";
mostCurrent._svpantalla.getPanel().setHeight((int) (_top+100));
RDebugUtils.currentLine=10813535;
 //BA.debugLineNum = 10813535;BA.debugLine="End Sub";
return "";
}
public static String  _creaobjetolista(int _indice,int _top,pullup.wallet.ingresosrecurrentes._ingresorecurrente _datos) throws Exception{
RDebugUtils.currentModule="ingresosrecurrentes";
if (Debug.shouldDelegate(mostCurrent.activityBA, "creaobjetolista", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "creaobjetolista", new Object[] {_indice,_top,_datos}));}
anywheresoftware.b4a.objects.PanelWrapper _pnlingresorecurrente = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlopciones = null;
anywheresoftware.b4a.objects.LabelWrapper _lblnombre = null;
anywheresoftware.b4a.objects.LabelWrapper _lblmonto = null;
anywheresoftware.b4a.objects.LabelWrapper _lbldescripcion = null;
anywheresoftware.b4a.objects.LabelWrapper _lblperiodo = null;
anywheresoftware.b4a.objects.LabelWrapper _lblopciones = null;
anywheresoftware.b4a.objects.ButtonWrapper _btneditar = null;
anywheresoftware.b4a.objects.ButtonWrapper _btneliminar = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
String _textoperiodo = "";
pullup.wallet.ingresosrecurrentes._indiceingresorecurrente _referencia = null;
pullup.wallet.ingresosrecurrentes._indiceingresorecurrente _referencia2 = null;
RDebugUtils.currentLine=11075584;
 //BA.debugLineNum = 11075584;BA.debugLine="Sub creaObjetoLista(indice As Int, top As Int, dat";
RDebugUtils.currentLine=11075585;
 //BA.debugLineNum = 11075585;BA.debugLine="Dim pnlIngresoRecurrente As Panel";
_pnlingresorecurrente = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=11075586;
 //BA.debugLineNum = 11075586;BA.debugLine="Dim pnlOpciones As Panel";
_pnlopciones = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=11075587;
 //BA.debugLineNum = 11075587;BA.debugLine="Dim lblNombre As Label";
_lblnombre = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=11075588;
 //BA.debugLineNum = 11075588;BA.debugLine="Dim lblMonto As Label";
_lblmonto = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=11075589;
 //BA.debugLineNum = 11075589;BA.debugLine="Dim lblDescripcion As Label";
_lbldescripcion = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=11075590;
 //BA.debugLineNum = 11075590;BA.debugLine="Dim lblPeriodo As Label";
_lblperiodo = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=11075591;
 //BA.debugLineNum = 11075591;BA.debugLine="Dim lblOpciones As Label";
_lblopciones = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=11075592;
 //BA.debugLineNum = 11075592;BA.debugLine="Dim btnEditar As Button";
_btneditar = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=11075593;
 //BA.debugLineNum = 11075593;BA.debugLine="Dim btnEliminar As Button";
_btneliminar = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=11075596;
 //BA.debugLineNum = 11075596;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=11075597;
 //BA.debugLineNum = 11075597;BA.debugLine="cd.Initialize(datos.color, 20)";
_cd.Initialize(_datos.color /*int*/ ,(int) (20));
RDebugUtils.currentLine=11075600;
 //BA.debugLineNum = 11075600;BA.debugLine="pnlIngresoRecurrente.Initialize(\"pnlSuscripcion\")";
_pnlingresorecurrente.Initialize(mostCurrent.activityBA,"pnlSuscripcion");
RDebugUtils.currentLine=11075601;
 //BA.debugLineNum = 11075601;BA.debugLine="pnlIngresoRecurrente.Top = top";
_pnlingresorecurrente.setTop(_top);
RDebugUtils.currentLine=11075602;
 //BA.debugLineNum = 11075602;BA.debugLine="pnlIngresoRecurrente.Background = cd";
_pnlingresorecurrente.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=11075603;
 //BA.debugLineNum = 11075603;BA.debugLine="pnlIngresoRecurrente.Width = anchoDispositivo * 0";
_pnlingresorecurrente.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=11075604;
 //BA.debugLineNum = 11075604;BA.debugLine="pnlIngresoRecurrente.Height = alturaDispositivo *";
_pnlingresorecurrente.setHeight((int) (_alturadispositivo*0.14));
RDebugUtils.currentLine=11075605;
 //BA.debugLineNum = 11075605;BA.debugLine="pnlIngresoRecurrente.Left = (anchoDispositivo - p";
_pnlingresorecurrente.setLeft((int) ((_anchodispositivo-_pnlingresorecurrente.getWidth())/(double)2));
RDebugUtils.currentLine=11075607;
 //BA.debugLineNum = 11075607;BA.debugLine="lblNombre.Initialize(\"lblNombre\")";
_lblnombre.Initialize(mostCurrent.activityBA,"lblNombre");
RDebugUtils.currentLine=11075608;
 //BA.debugLineNum = 11075608;BA.debugLine="lblNombre.TextColor = Colors.White";
_lblnombre.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=11075609;
 //BA.debugLineNum = 11075609;BA.debugLine="lblNombre.Text = datos.nombre.ToUpperCase.CharAt(";
_lblnombre.setText(BA.ObjectToCharSequence(BA.ObjectToString(_datos.nombre /*String*/ .toUpperCase().charAt((int) (0)))+_datos.nombre /*String*/ .substring((int) (1)).toLowerCase()));
RDebugUtils.currentLine=11075610;
 //BA.debugLineNum = 11075610;BA.debugLine="lblNombre.TextSize = 19";
_lblnombre.setTextSize((float) (19));
RDebugUtils.currentLine=11075611;
 //BA.debugLineNum = 11075611;BA.debugLine="lblNombre.Height = pnlIngresoRecurrente.Height *";
_lblnombre.setHeight((int) (_pnlingresorecurrente.getHeight()*0.3));
RDebugUtils.currentLine=11075612;
 //BA.debugLineNum = 11075612;BA.debugLine="lblNombre.Width = pnlIngresoRecurrente.Width * 0.";
_lblnombre.setWidth((int) (_pnlingresorecurrente.getWidth()*0.9));
RDebugUtils.currentLine=11075613;
 //BA.debugLineNum = 11075613;BA.debugLine="lblNombre.Top = 0";
_lblnombre.setTop((int) (0));
RDebugUtils.currentLine=11075614;
 //BA.debugLineNum = 11075614;BA.debugLine="lblNombre.Left = pnlIngresoRecurrente.Width * 0.0";
_lblnombre.setLeft((int) (_pnlingresorecurrente.getWidth()*0.05));
RDebugUtils.currentLine=11075615;
 //BA.debugLineNum = 11075615;BA.debugLine="lblNombre.Gravity = Gravity.CENTER_VERTICAL";
_lblnombre.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=11075616;
 //BA.debugLineNum = 11075616;BA.debugLine="pnlIngresoRecurrente.AddView(lblNombre, lblNombre";
_pnlingresorecurrente.AddView((android.view.View)(_lblnombre.getObject()),_lblnombre.getLeft(),_lblnombre.getTop(),_lblnombre.getWidth(),_lblnombre.getHeight());
RDebugUtils.currentLine=11075618;
 //BA.debugLineNum = 11075618;BA.debugLine="lblDescripcion.Initialize(\"lblDescripcion\")";
_lbldescripcion.Initialize(mostCurrent.activityBA,"lblDescripcion");
RDebugUtils.currentLine=11075619;
 //BA.debugLineNum = 11075619;BA.debugLine="lblDescripcion.Text = datos.descripcion.ToUpperCa";
_lbldescripcion.setText(BA.ObjectToCharSequence(BA.ObjectToString(_datos.descripcion /*String*/ .toUpperCase().charAt((int) (0)))+_datos.descripcion /*String*/ .substring((int) (1)).toLowerCase()));
RDebugUtils.currentLine=11075620;
 //BA.debugLineNum = 11075620;BA.debugLine="lblDescripcion.TextColor = Colors.White";
_lbldescripcion.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=11075621;
 //BA.debugLineNum = 11075621;BA.debugLine="lblDescripcion.Height = pnlIngresoRecurrente.Heig";
_lbldescripcion.setHeight((int) (_pnlingresorecurrente.getHeight()*0.3));
RDebugUtils.currentLine=11075622;
 //BA.debugLineNum = 11075622;BA.debugLine="lblDescripcion.Width = pnlIngresoRecurrente.Width";
_lbldescripcion.setWidth((int) (_pnlingresorecurrente.getWidth()*0.9));
RDebugUtils.currentLine=11075623;
 //BA.debugLineNum = 11075623;BA.debugLine="lblDescripcion.Top = lblNombre.Height";
_lbldescripcion.setTop(_lblnombre.getHeight());
RDebugUtils.currentLine=11075624;
 //BA.debugLineNum = 11075624;BA.debugLine="lblDescripcion.Left = lblNombre.Left";
_lbldescripcion.setLeft(_lblnombre.getLeft());
RDebugUtils.currentLine=11075625;
 //BA.debugLineNum = 11075625;BA.debugLine="lblDescripcion.Gravity = Gravity.CENTER_VERTICAL";
_lbldescripcion.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=11075626;
 //BA.debugLineNum = 11075626;BA.debugLine="pnlIngresoRecurrente.AddView(lblDescripcion, lblD";
_pnlingresorecurrente.AddView((android.view.View)(_lbldescripcion.getObject()),_lbldescripcion.getLeft(),_lbldescripcion.getTop(),_lbldescripcion.getWidth(),_lbldescripcion.getHeight());
RDebugUtils.currentLine=11075628;
 //BA.debugLineNum = 11075628;BA.debugLine="lblPeriodo.Initialize(\"lblPeriodo\")";
_lblperiodo.Initialize(mostCurrent.activityBA,"lblPeriodo");
RDebugUtils.currentLine=11075630;
 //BA.debugLineNum = 11075630;BA.debugLine="Dim textoPeriodo As String";
_textoperiodo = "";
RDebugUtils.currentLine=11075631;
 //BA.debugLineNum = 11075631;BA.debugLine="If (datos.periodo = 7) Then";
if (((_datos.periodo /*String*/ ).equals(BA.NumberToString(7)))) { 
RDebugUtils.currentLine=11075632;
 //BA.debugLineNum = 11075632;BA.debugLine="textoPeriodo = \"1 semana\"";
_textoperiodo = "1 semana";
 }else 
{RDebugUtils.currentLine=11075633;
 //BA.debugLineNum = 11075633;BA.debugLine="Else If (datos.periodo = 14) Then";
if (((_datos.periodo /*String*/ ).equals(BA.NumberToString(14)))) { 
RDebugUtils.currentLine=11075634;
 //BA.debugLineNum = 11075634;BA.debugLine="textoPeriodo = \"2 semanas\"";
_textoperiodo = "2 semanas";
 }else 
{RDebugUtils.currentLine=11075635;
 //BA.debugLineNum = 11075635;BA.debugLine="Else If (datos.periodo = 21) Then";
if (((_datos.periodo /*String*/ ).equals(BA.NumberToString(21)))) { 
RDebugUtils.currentLine=11075636;
 //BA.debugLineNum = 11075636;BA.debugLine="textoPeriodo = \"3 semanas\"";
_textoperiodo = "3 semanas";
 }else 
{RDebugUtils.currentLine=11075637;
 //BA.debugLineNum = 11075637;BA.debugLine="Else If (datos.periodo = 30) Then";
if (((_datos.periodo /*String*/ ).equals(BA.NumberToString(30)))) { 
RDebugUtils.currentLine=11075638;
 //BA.debugLineNum = 11075638;BA.debugLine="textoPeriodo = \"1 mes\"";
_textoperiodo = "1 mes";
 }else 
{RDebugUtils.currentLine=11075639;
 //BA.debugLineNum = 11075639;BA.debugLine="Else If (datos.periodo = 365) Then";
if (((_datos.periodo /*String*/ ).equals(BA.NumberToString(365)))) { 
RDebugUtils.currentLine=11075640;
 //BA.debugLineNum = 11075640;BA.debugLine="textoPeriodo = \"1 año\"";
_textoperiodo = "1 año";
 }}}}}
;
RDebugUtils.currentLine=11075643;
 //BA.debugLineNum = 11075643;BA.debugLine="lblPeriodo.Text = textoPeriodo";
_lblperiodo.setText(BA.ObjectToCharSequence(_textoperiodo));
RDebugUtils.currentLine=11075644;
 //BA.debugLineNum = 11075644;BA.debugLine="lblPeriodo.TextSize = 16";
_lblperiodo.setTextSize((float) (16));
RDebugUtils.currentLine=11075645;
 //BA.debugLineNum = 11075645;BA.debugLine="lblPeriodo.TextColor = Colors.DarkGray";
_lblperiodo.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.DarkGray);
RDebugUtils.currentLine=11075646;
 //BA.debugLineNum = 11075646;BA.debugLine="lblPeriodo.Height = pnlIngresoRecurrente.Height *";
_lblperiodo.setHeight((int) (_pnlingresorecurrente.getHeight()*0.4));
RDebugUtils.currentLine=11075647;
 //BA.debugLineNum = 11075647;BA.debugLine="lblPeriodo.Width = pnlIngresoRecurrente.Width * 0";
_lblperiodo.setWidth((int) (_pnlingresorecurrente.getWidth()*0.9));
RDebugUtils.currentLine=11075648;
 //BA.debugLineNum = 11075648;BA.debugLine="lblPeriodo.Top = lblDescripcion.Top + lblDescripc";
_lblperiodo.setTop((int) (_lbldescripcion.getTop()+_lbldescripcion.getHeight()));
RDebugUtils.currentLine=11075649;
 //BA.debugLineNum = 11075649;BA.debugLine="lblPeriodo.Left = lblNombre.Left";
_lblperiodo.setLeft(_lblnombre.getLeft());
RDebugUtils.currentLine=11075650;
 //BA.debugLineNum = 11075650;BA.debugLine="lblPeriodo.Gravity = Gravity.CENTER_VERTICAL";
_lblperiodo.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=11075651;
 //BA.debugLineNum = 11075651;BA.debugLine="pnlIngresoRecurrente.AddView(lblPeriodo, lblPerio";
_pnlingresorecurrente.AddView((android.view.View)(_lblperiodo.getObject()),_lblperiodo.getLeft(),_lblperiodo.getTop(),_lblperiodo.getWidth(),_lblperiodo.getHeight());
RDebugUtils.currentLine=11075653;
 //BA.debugLineNum = 11075653;BA.debugLine="lblMonto.Initialize(\"lblMonto\")";
_lblmonto.Initialize(mostCurrent.activityBA,"lblMonto");
RDebugUtils.currentLine=11075654;
 //BA.debugLineNum = 11075654;BA.debugLine="lblMonto.TextSize = 16";
_lblmonto.setTextSize((float) (16));
RDebugUtils.currentLine=11075655;
 //BA.debugLineNum = 11075655;BA.debugLine="lblMonto.TextColor = Colors.White";
_lblmonto.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=11075656;
 //BA.debugLineNum = 11075656;BA.debugLine="lblMonto.Width = cvsTest.MeasureStringWidth((\"$\"";
_lblmonto.setWidth((int) (mostCurrent._cvstest.MeasureStringWidth(("$"+BA.NumberToString(_datos.monto /*int*/ )),anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT,_lblmonto.getTextSize())+2));
RDebugUtils.currentLine=11075657;
 //BA.debugLineNum = 11075657;BA.debugLine="lblMonto.Height = pnlIngresoRecurrente.Height * 0";
_lblmonto.setHeight((int) (_pnlingresorecurrente.getHeight()*0.4));
RDebugUtils.currentLine=11075658;
 //BA.debugLineNum = 11075658;BA.debugLine="lblMonto.Text = \"$\" & datos.monto";
_lblmonto.setText(BA.ObjectToCharSequence("$"+BA.NumberToString(_datos.monto /*int*/ )));
RDebugUtils.currentLine=11075659;
 //BA.debugLineNum = 11075659;BA.debugLine="lblMonto.Top = lblPeriodo.Top";
_lblmonto.setTop(_lblperiodo.getTop());
RDebugUtils.currentLine=11075660;
 //BA.debugLineNum = 11075660;BA.debugLine="lblMonto.Left = pnlIngresoRecurrente.Width - lblM";
_lblmonto.setLeft((int) (_pnlingresorecurrente.getWidth()-_lblmonto.getWidth()-_lblnombre.getLeft()));
RDebugUtils.currentLine=11075661;
 //BA.debugLineNum = 11075661;BA.debugLine="lblMonto.Gravity = Gravity.CENTER_VERTICAL";
_lblmonto.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=11075662;
 //BA.debugLineNum = 11075662;BA.debugLine="pnlIngresoRecurrente.AddView(lblMonto, lblMonto.L";
_pnlingresorecurrente.AddView((android.view.View)(_lblmonto.getObject()),_lblmonto.getLeft(),_lblmonto.getTop(),_lblmonto.getWidth(),_lblmonto.getHeight());
RDebugUtils.currentLine=11075664;
 //BA.debugLineNum = 11075664;BA.debugLine="lblOpciones.Initialize(\"lblOpciones\")";
_lblopciones.Initialize(mostCurrent.activityBA,"lblOpciones");
RDebugUtils.currentLine=11075665;
 //BA.debugLineNum = 11075665;BA.debugLine="lblOpciones.Typeface = Typeface.FONTAWESOME";
_lblopciones.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getFONTAWESOME());
RDebugUtils.currentLine=11075666;
 //BA.debugLineNum = 11075666;BA.debugLine="lblOpciones.Text = Chr(0xF142)";
_lblopciones.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf142))));
RDebugUtils.currentLine=11075667;
 //BA.debugLineNum = 11075667;BA.debugLine="lblOpciones.TextSize = 18";
_lblopciones.setTextSize((float) (18));
RDebugUtils.currentLine=11075668;
 //BA.debugLineNum = 11075668;BA.debugLine="lblOpciones.TextColor = Colors.White";
_lblopciones.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=11075669;
 //BA.debugLineNum = 11075669;BA.debugLine="lblOpciones.Height = lblNombre.Height";
_lblopciones.setHeight(_lblnombre.getHeight());
RDebugUtils.currentLine=11075670;
 //BA.debugLineNum = 11075670;BA.debugLine="lblOpciones.Width = 8dip";
_lblopciones.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (8)));
RDebugUtils.currentLine=11075671;
 //BA.debugLineNum = 11075671;BA.debugLine="lblOpciones.Left = lblMonto.Left + lblMonto.Width";
_lblopciones.setLeft((int) (_lblmonto.getLeft()+_lblmonto.getWidth()-_lblopciones.getWidth()));
RDebugUtils.currentLine=11075672;
 //BA.debugLineNum = 11075672;BA.debugLine="lblOpciones.Top = 0";
_lblopciones.setTop((int) (0));
RDebugUtils.currentLine=11075673;
 //BA.debugLineNum = 11075673;BA.debugLine="lblOpciones.Gravity = Gravity.CENTER_VERTICAL";
_lblopciones.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=11075674;
 //BA.debugLineNum = 11075674;BA.debugLine="pnlIngresoRecurrente.AddView(lblOpciones, lblOpci";
_pnlingresorecurrente.AddView((android.view.View)(_lblopciones.getObject()),_lblopciones.getLeft(),_lblopciones.getTop(),_lblopciones.getWidth(),_lblopciones.getHeight());
RDebugUtils.currentLine=11075676;
 //BA.debugLineNum = 11075676;BA.debugLine="pnlOpciones.Initialize(\"pnlOpciones\")";
_pnlopciones.Initialize(mostCurrent.activityBA,"pnlOpciones");
RDebugUtils.currentLine=11075677;
 //BA.debugLineNum = 11075677;BA.debugLine="cd.Initialize(Colors.Black, 20)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.Black,(int) (20));
RDebugUtils.currentLine=11075678;
 //BA.debugLineNum = 11075678;BA.debugLine="pnlOpciones.Background = cd";
_pnlopciones.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=11075679;
 //BA.debugLineNum = 11075679;BA.debugLine="pnlOpciones.Height = pnlIngresoRecurrente.Height";
_pnlopciones.setHeight((int) (_pnlingresorecurrente.getHeight()*0.8));
RDebugUtils.currentLine=11075680;
 //BA.debugLineNum = 11075680;BA.debugLine="pnlOpciones.Width = pnlIngresoRecurrente.Height";
_pnlopciones.setWidth(_pnlingresorecurrente.getHeight());
RDebugUtils.currentLine=11075681;
 //BA.debugLineNum = 11075681;BA.debugLine="pnlOpciones.Top = lblOpciones.Top";
_pnlopciones.setTop(_lblopciones.getTop());
RDebugUtils.currentLine=11075682;
 //BA.debugLineNum = 11075682;BA.debugLine="pnlOpciones.Left = lblOpciones.Left - lblOpciones";
_pnlopciones.setLeft((int) (_lblopciones.getLeft()-_lblopciones.getWidth()*2-_pnlopciones.getWidth()));
RDebugUtils.currentLine=11075683;
 //BA.debugLineNum = 11075683;BA.debugLine="pnlOpciones.Visible = False";
_pnlopciones.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=11075684;
 //BA.debugLineNum = 11075684;BA.debugLine="pnlIngresoRecurrente.AddView(pnlOpciones, pnlOpci";
_pnlingresorecurrente.AddView((android.view.View)(_pnlopciones.getObject()),_pnlopciones.getLeft(),_pnlopciones.getTop(),_pnlopciones.getWidth(),_pnlopciones.getHeight());
RDebugUtils.currentLine=11075686;
 //BA.debugLineNum = 11075686;BA.debugLine="btnEditar.Initialize(\"btnEditar\")";
_btneditar.Initialize(mostCurrent.activityBA,"btnEditar");
RDebugUtils.currentLine=11075687;
 //BA.debugLineNum = 11075687;BA.debugLine="btnEditar.Color = Colors.Transparent";
_btneditar.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=11075688;
 //BA.debugLineNum = 11075688;BA.debugLine="btnEditar.Text = \"Editar\"";
_btneditar.setText(BA.ObjectToCharSequence("Editar"));
RDebugUtils.currentLine=11075689;
 //BA.debugLineNum = 11075689;BA.debugLine="btnEditar.TextColor = Colors.White";
_btneditar.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=11075690;
 //BA.debugLineNum = 11075690;BA.debugLine="btnEditar.TextSize = 14";
_btneditar.setTextSize((float) (14));
RDebugUtils.currentLine=11075691;
 //BA.debugLineNum = 11075691;BA.debugLine="btnEditar.Height = pnlOpciones.Height * 0.4";
_btneditar.setHeight((int) (_pnlopciones.getHeight()*0.4));
RDebugUtils.currentLine=11075692;
 //BA.debugLineNum = 11075692;BA.debugLine="btnEditar.Width = pnlOpciones.Height * 0.8";
_btneditar.setWidth((int) (_pnlopciones.getHeight()*0.8));
RDebugUtils.currentLine=11075693;
 //BA.debugLineNum = 11075693;BA.debugLine="btnEditar.Top = (pnlOpciones.Height * 0.2) / 3";
_btneditar.setTop((int) ((_pnlopciones.getHeight()*0.2)/(double)3));
RDebugUtils.currentLine=11075694;
 //BA.debugLineNum = 11075694;BA.debugLine="btnEditar.Left = (pnlOpciones.Width - btnEditar.W";
_btneditar.setLeft((int) ((_pnlopciones.getWidth()-_btneditar.getWidth())/(double)2));
RDebugUtils.currentLine=11075695;
 //BA.debugLineNum = 11075695;BA.debugLine="pnlOpciones.AddView(btnEditar, btnEditar.Left, bt";
_pnlopciones.AddView((android.view.View)(_btneditar.getObject()),_btneditar.getLeft(),_btneditar.getTop(),_btneditar.getWidth(),_btneditar.getHeight());
RDebugUtils.currentLine=11075697;
 //BA.debugLineNum = 11075697;BA.debugLine="btnEliminar.Initialize(\"btnEliminar\")";
_btneliminar.Initialize(mostCurrent.activityBA,"btnEliminar");
RDebugUtils.currentLine=11075698;
 //BA.debugLineNum = 11075698;BA.debugLine="btnEliminar.Color = Colors.Transparent";
_btneliminar.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=11075699;
 //BA.debugLineNum = 11075699;BA.debugLine="btnEliminar.Text = \"Eliminar\"";
_btneliminar.setText(BA.ObjectToCharSequence("Eliminar"));
RDebugUtils.currentLine=11075700;
 //BA.debugLineNum = 11075700;BA.debugLine="btnEliminar.TextColor = Colors.White";
_btneliminar.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=11075701;
 //BA.debugLineNum = 11075701;BA.debugLine="btnEliminar.TextSize = 14";
_btneliminar.setTextSize((float) (14));
RDebugUtils.currentLine=11075702;
 //BA.debugLineNum = 11075702;BA.debugLine="btnEliminar.Height = btnEditar.Height";
_btneliminar.setHeight(_btneditar.getHeight());
RDebugUtils.currentLine=11075703;
 //BA.debugLineNum = 11075703;BA.debugLine="btnEliminar.Width = pnlOpciones.Width * 0.9";
_btneliminar.setWidth((int) (_pnlopciones.getWidth()*0.9));
RDebugUtils.currentLine=11075704;
 //BA.debugLineNum = 11075704;BA.debugLine="btnEliminar.Top = btnEditar.Top * 2 + btnEditar.H";
_btneliminar.setTop((int) (_btneditar.getTop()*2+_btneditar.getHeight()));
RDebugUtils.currentLine=11075705;
 //BA.debugLineNum = 11075705;BA.debugLine="btnEliminar.Left = (pnlOpciones.Width - btnElimin";
_btneliminar.setLeft((int) ((_pnlopciones.getWidth()-_btneliminar.getWidth())/(double)2));
RDebugUtils.currentLine=11075706;
 //BA.debugLineNum = 11075706;BA.debugLine="pnlOpciones.AddView(btnEliminar, btnEliminar.Left";
_pnlopciones.AddView((android.view.View)(_btneliminar.getObject()),_btneliminar.getLeft(),_btneliminar.getTop(),_btneliminar.getWidth(),_btneliminar.getHeight());
RDebugUtils.currentLine=11075708;
 //BA.debugLineNum = 11075708;BA.debugLine="pnlDeslizable.AddView(pnlIngresoRecurrente, pnlIn";
mostCurrent._pnldeslizable.AddView((android.view.View)(_pnlingresorecurrente.getObject()),_pnlingresorecurrente.getLeft(),_top,_pnlingresorecurrente.getWidth(),_pnlingresorecurrente.getHeight());
RDebugUtils.currentLine=11075711;
 //BA.debugLineNum = 11075711;BA.debugLine="Dim referencia As IndiceIngresoRecurrente";
_referencia = new pullup.wallet.ingresosrecurrentes._indiceingresorecurrente();
RDebugUtils.currentLine=11075712;
 //BA.debugLineNum = 11075712;BA.debugLine="referencia.indiceElemento = indice";
_referencia.indiceElemento /*int*/  = _indice;
RDebugUtils.currentLine=11075713;
 //BA.debugLineNum = 11075713;BA.debugLine="referencia.rowid = 0";
_referencia.rowid /*int*/  = (int) (0);
RDebugUtils.currentLine=11075715;
 //BA.debugLineNum = 11075715;BA.debugLine="lblOpciones.Tag = referencia";
_lblopciones.setTag((Object)(_referencia));
RDebugUtils.currentLine=11075718;
 //BA.debugLineNum = 11075718;BA.debugLine="Dim referencia2 As IndiceIngresoRecurrente";
_referencia2 = new pullup.wallet.ingresosrecurrentes._indiceingresorecurrente();
RDebugUtils.currentLine=11075719;
 //BA.debugLineNum = 11075719;BA.debugLine="referencia2.indiceElemento = 0";
_referencia2.indiceElemento /*int*/  = (int) (0);
RDebugUtils.currentLine=11075720;
 //BA.debugLineNum = 11075720;BA.debugLine="referencia2.rowid = datos.rowid";
_referencia2.rowid /*int*/  = _datos.rowid /*int*/ ;
RDebugUtils.currentLine=11075722;
 //BA.debugLineNum = 11075722;BA.debugLine="pnlOpciones.Tag = referencia2";
_pnlopciones.setTag((Object)(_referencia2));
RDebugUtils.currentLine=11075725;
 //BA.debugLineNum = 11075725;BA.debugLine="Relaciones(indice, 0) = lblOpciones";
mostCurrent._relaciones[_indice][(int) (0)] = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lblopciones.getObject()));
RDebugUtils.currentLine=11075726;
 //BA.debugLineNum = 11075726;BA.debugLine="Relaciones(indice, 1) = pnlOpciones";
mostCurrent._relaciones[_indice][(int) (1)] = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnlopciones.getObject()));
RDebugUtils.currentLine=11075729;
 //BA.debugLineNum = 11075729;BA.debugLine="arrayPnlsOpciones(indice) = pnlOpciones";
mostCurrent._arraypnlsopciones[_indice] = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnlopciones.getObject()));
RDebugUtils.currentLine=11075730;
 //BA.debugLineNum = 11075730;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="ingresosrecurrentes";
RDebugUtils.currentLine=10944512;
 //BA.debugLineNum = 10944512;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=10944514;
 //BA.debugLineNum = 10944514;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="ingresosrecurrentes";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=10878976;
 //BA.debugLineNum = 10878976;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=10878978;
 //BA.debugLineNum = 10878978;BA.debugLine="End Sub";
return "";
}
public static String  _btneditar_click() throws Exception{
RDebugUtils.currentModule="ingresosrecurrentes";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btneditar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btneditar_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btneditar = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlpadre = null;
int _idregistro = 0;
pullup.wallet.ingresosrecurrentes._indiceingresorecurrente _indice = null;
RDebugUtils.currentLine=11206656;
 //BA.debugLineNum = 11206656;BA.debugLine="Sub btnEditar_Click";
RDebugUtils.currentLine=11206657;
 //BA.debugLineNum = 11206657;BA.debugLine="Dim btnEditar As Button";
_btneditar = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=11206658;
 //BA.debugLineNum = 11206658;BA.debugLine="Dim pnlPadre As Panel";
_pnlpadre = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=11206659;
 //BA.debugLineNum = 11206659;BA.debugLine="Dim idRegistro As Int";
_idregistro = 0;
RDebugUtils.currentLine=11206660;
 //BA.debugLineNum = 11206660;BA.debugLine="Dim indice As IndiceIngresoRecurrente";
_indice = new pullup.wallet.ingresosrecurrentes._indiceingresorecurrente();
RDebugUtils.currentLine=11206663;
 //BA.debugLineNum = 11206663;BA.debugLine="btnEditar = Sender";
_btneditar = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=11206665;
 //BA.debugLineNum = 11206665;BA.debugLine="pnlPadre = btnEditar.Parent";
_pnlpadre = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_btneditar.getParent()));
RDebugUtils.currentLine=11206667;
 //BA.debugLineNum = 11206667;BA.debugLine="indice = pnlPadre.Tag";
_indice = (pullup.wallet.ingresosrecurrentes._indiceingresorecurrente)(_pnlpadre.getTag());
RDebugUtils.currentLine=11206669;
 //BA.debugLineNum = 11206669;BA.debugLine="idRegistro = indice.rowid";
_idregistro = _indice.rowid /*int*/ ;
RDebugUtils.currentLine=11206670;
 //BA.debugLineNum = 11206670;BA.debugLine="CallSubDelayed2(editarIngresoRecurrente, \"consult";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._editaringresorecurrente.getObject()),"consultaAEditar",(Object)(_idregistro));
RDebugUtils.currentLine=11206671;
 //BA.debugLineNum = 11206671;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=11206672;
 //BA.debugLineNum = 11206672;BA.debugLine="End Sub";
return "";
}
public static String  _btneliminar_click() throws Exception{
RDebugUtils.currentModule="ingresosrecurrentes";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btneliminar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btneliminar_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btneliminar = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlpadre = null;
int _idregistro = 0;
pullup.wallet.ingresosrecurrentes._indiceingresorecurrente _indice = null;
int _resultado = 0;
RDebugUtils.currentLine=11272192;
 //BA.debugLineNum = 11272192;BA.debugLine="Sub btnEliminar_Click";
RDebugUtils.currentLine=11272193;
 //BA.debugLineNum = 11272193;BA.debugLine="Dim btnEliminar As Button";
_btneliminar = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=11272194;
 //BA.debugLineNum = 11272194;BA.debugLine="Dim pnlPadre As Panel";
_pnlpadre = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=11272195;
 //BA.debugLineNum = 11272195;BA.debugLine="Dim idRegistro As Int";
_idregistro = 0;
RDebugUtils.currentLine=11272196;
 //BA.debugLineNum = 11272196;BA.debugLine="Dim indice As IndiceIngresoRecurrente";
_indice = new pullup.wallet.ingresosrecurrentes._indiceingresorecurrente();
RDebugUtils.currentLine=11272199;
 //BA.debugLineNum = 11272199;BA.debugLine="btnEliminar = Sender";
_btneliminar = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=11272201;
 //BA.debugLineNum = 11272201;BA.debugLine="pnlPadre = btnEliminar.Parent";
_pnlpadre = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_btneliminar.getParent()));
RDebugUtils.currentLine=11272203;
 //BA.debugLineNum = 11272203;BA.debugLine="indice = pnlPadre.Tag";
_indice = (pullup.wallet.ingresosrecurrentes._indiceingresorecurrente)(_pnlpadre.getTag());
RDebugUtils.currentLine=11272205;
 //BA.debugLineNum = 11272205;BA.debugLine="idRegistro = indice.rowid";
_idregistro = _indice.rowid /*int*/ ;
RDebugUtils.currentLine=11272208;
 //BA.debugLineNum = 11272208;BA.debugLine="Dim resultado As Int";
_resultado = 0;
RDebugUtils.currentLine=11272209;
 //BA.debugLineNum = 11272209;BA.debugLine="resultado = Msgbox2(\"¿Estás seguro?\", \"Eliminar i";
_resultado = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("¿Estás seguro?"),BA.ObjectToCharSequence("Eliminar ingreso recurrente"),"Sí","","No",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=11272210;
 //BA.debugLineNum = 11272210;BA.debugLine="If (resultado = DialogResponse.POSITIVE) Then";
if ((_resultado==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE)) { 
RDebugUtils.currentLine=11272212;
 //BA.debugLineNum = 11272212;BA.debugLine="sql.ExecNonQuery(\"DELETE FROM ingresos_recurrent";
_sql.ExecNonQuery("DELETE FROM ingresos_recurrentes WHERE id_ingreso_recurrente = '"+BA.NumberToString(_idregistro)+"'");
RDebugUtils.currentLine=11272216;
 //BA.debugLineNum = 11272216;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=11272217;
 //BA.debugLineNum = 11272217;BA.debugLine="StartActivity(Me)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,ingresosrecurrentes.getObject());
 };
RDebugUtils.currentLine=11272219;
 //BA.debugLineNum = 11272219;BA.debugLine="End Sub";
return "";
}
public static String  _btnmenu_click() throws Exception{
RDebugUtils.currentModule="ingresosrecurrentes";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnmenu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnmenu_click", null));}
RDebugUtils.currentLine=11010048;
 //BA.debugLineNum = 11010048;BA.debugLine="Private Sub btnMenu_Click";
RDebugUtils.currentLine=11010049;
 //BA.debugLineNum = 11010049;BA.debugLine="CallSubDelayed(Main, \"actualizarDatos\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._main.getObject()),"actualizarDatos");
RDebugUtils.currentLine=11010050;
 //BA.debugLineNum = 11010050;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=11010051;
 //BA.debugLineNum = 11010051;BA.debugLine="End Sub";
return "";
}
public static String  _lblopciones_click() throws Exception{
RDebugUtils.currentModule="ingresosrecurrentes";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblopciones_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblopciones_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _lblopcion = null;
pullup.wallet.ingresosrecurrentes._indiceingresorecurrente _indice = null;
int _contador = 0;
RDebugUtils.currentLine=11141120;
 //BA.debugLineNum = 11141120;BA.debugLine="Sub lblOpciones_Click";
RDebugUtils.currentLine=11141121;
 //BA.debugLineNum = 11141121;BA.debugLine="Dim lblOpcion As Label";
_lblopcion = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=11141122;
 //BA.debugLineNum = 11141122;BA.debugLine="Dim indice As IndiceIngresoRecurrente";
_indice = new pullup.wallet.ingresosrecurrentes._indiceingresorecurrente();
RDebugUtils.currentLine=11141124;
 //BA.debugLineNum = 11141124;BA.debugLine="lblOpcion = Sender";
_lblopcion = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=11141125;
 //BA.debugLineNum = 11141125;BA.debugLine="indice = lblOpcion.Tag";
_indice = (pullup.wallet.ingresosrecurrentes._indiceingresorecurrente)(_lblopcion.getTag());
RDebugUtils.currentLine=11141128;
 //BA.debugLineNum = 11141128;BA.debugLine="For contador = 0 To arrayPnlsOpciones.Length - 1";
{
final int step5 = 1;
final int limit5 = (int) (mostCurrent._arraypnlsopciones.length-1);
_contador = (int) (0) ;
for (;_contador <= limit5 ;_contador = _contador + step5 ) {
RDebugUtils.currentLine=11141129;
 //BA.debugLineNum = 11141129;BA.debugLine="If (contador <> indice.indiceElemento) Then";
if ((_contador!=_indice.indiceElemento /*int*/ )) { 
RDebugUtils.currentLine=11141130;
 //BA.debugLineNum = 11141130;BA.debugLine="arrayPnlsOpciones(contador).Visible = False";
mostCurrent._arraypnlsopciones[_contador].setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 }
};
RDebugUtils.currentLine=11141135;
 //BA.debugLineNum = 11141135;BA.debugLine="Relaciones(indice.indiceElemento, 1).SetVisibleAn";
mostCurrent._relaciones[_indice.indiceElemento /*int*/ ][(int) (1)].SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.Not(mostCurrent._relaciones[_indice.indiceElemento /*int*/ ][(int) (1)].getVisible()));
RDebugUtils.currentLine=11141136;
 //BA.debugLineNum = 11141136;BA.debugLine="End Sub";
return "";
}
}