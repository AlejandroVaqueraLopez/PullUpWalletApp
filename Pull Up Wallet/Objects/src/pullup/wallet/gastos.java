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

public class gastos extends Activity implements B4AActivity{
	public static gastos mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "pullup.wallet", "pullup.wallet.gastos");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (gastos).");
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
		activityBA = new BA(this, layout, processBA, "pullup.wallet", "pullup.wallet.gastos");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "pullup.wallet.gastos", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (gastos) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (gastos) Resume **");
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
		return gastos.class;
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
            BA.LogInfo("** Activity (gastos) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (gastos) Pause event (activity is not paused). **");
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
            gastos mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (gastos) Resume **");
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


public static class _indicegasto{
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
public static class _gasto{
public boolean IsInitialized;
public int rowid;
public String nombre;
public int monto;
public String fecha;
public String descripcion;
public int color;
public void Initialize() {
IsInitialized = true;
rowid = 0;
nombre = "";
monto = 0;
fecha = "";
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
public static int _sumaegresosantigua = 0;
public static int _montoseleccionado = 0;
public static int _sumaegresosactual = 0;
public pullup.wallet.main _main = null;
public pullup.wallet.starter _starter = null;
public pullup.wallet.tutorial _tutorial = null;
public pullup.wallet.diapositivas _diapositivas = null;
public pullup.wallet.editargasto _editargasto = null;
public pullup.wallet.editaringresorecurrente _editaringresorecurrente = null;
public pullup.wallet.editaringresounico _editaringresounico = null;
public pullup.wallet.editarmetaahorro _editarmetaahorro = null;
public pullup.wallet.editarsuscripcion _editarsuscripcion = null;
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
RDebugUtils.currentModule="gastos";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.LabelWrapper _lblseccion = null;
int _top = 0;
int _id = 0;
pullup.wallet.gastos._gasto _datosgasto = null;
anywheresoftware.b4a.objects.LabelWrapper _lblmensaje = null;
RDebugUtils.currentLine=9633792;
 //BA.debugLineNum = 9633792;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=9633795;
 //BA.debugLineNum = 9633795;BA.debugLine="Activity.LoadLayout(\"LDeslizable\")";
mostCurrent._activity.LoadLayout("LDeslizable",mostCurrent.activityBA);
RDebugUtils.currentLine=9633796;
 //BA.debugLineNum = 9633796;BA.debugLine="Activity.Color = Colors.ARGB(255, 233, 236, 239)";
mostCurrent._activity.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (233),(int) (236),(int) (239)));
RDebugUtils.currentLine=9633797;
 //BA.debugLineNum = 9633797;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
_alturadispositivo = mostCurrent._main._alturadispositivo /*int*/ ;
RDebugUtils.currentLine=9633798;
 //BA.debugLineNum = 9633798;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
_anchodispositivo = mostCurrent._main._anchodispositivo /*int*/ ;
RDebugUtils.currentLine=9633799;
 //BA.debugLineNum = 9633799;BA.debugLine="sql = Starter.sql";
_sql = mostCurrent._starter._sql /*anywheresoftware.b4a.sql.SQL*/ ;
RDebugUtils.currentLine=9633800;
 //BA.debugLineNum = 9633800;BA.debugLine="bmpTest.InitializeMutable(1dip, 1dip)";
mostCurrent._bmptest.InitializeMutable(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)));
RDebugUtils.currentLine=9633801;
 //BA.debugLineNum = 9633801;BA.debugLine="cvsTest.Initialize2(bmpTest)";
mostCurrent._cvstest.Initialize2((android.graphics.Bitmap)(mostCurrent._bmptest.getObject()));
RDebugUtils.currentLine=9633804;
 //BA.debugLineNum = 9633804;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
mostCurrent._pnlnavinferior.setHeight((int) (_alturadispositivo*0.08));
RDebugUtils.currentLine=9633805;
 //BA.debugLineNum = 9633805;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
mostCurrent._pnlnavinferior.setWidth(_anchodispositivo);
RDebugUtils.currentLine=9633806;
 //BA.debugLineNum = 9633806;BA.debugLine="pnlNavInferior.Left = 0";
mostCurrent._pnlnavinferior.setLeft((int) (0));
RDebugUtils.currentLine=9633807;
 //BA.debugLineNum = 9633807;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
mostCurrent._pnlnavinferior.setTop((int) (_alturadispositivo-mostCurrent._pnlnavinferior.getHeight()));
RDebugUtils.currentLine=9633810;
 //BA.debugLineNum = 9633810;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
mostCurrent._btnmenu.setWidth((int) (_anchodispositivo*0.15));
RDebugUtils.currentLine=9633811;
 //BA.debugLineNum = 9633811;BA.debugLine="btnMenu.Height = btnMenu.Width";
mostCurrent._btnmenu.setHeight(mostCurrent._btnmenu.getWidth());
RDebugUtils.currentLine=9633812;
 //BA.debugLineNum = 9633812;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
mostCurrent._btnmenu.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._btnmenu.getHeight()/(double)2));
RDebugUtils.currentLine=9633813;
 //BA.debugLineNum = 9633813;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
mostCurrent._btnmenu.setLeft((int) ((_anchodispositivo-mostCurrent._btnmenu.getWidth())/(double)2));
RDebugUtils.currentLine=9633815;
 //BA.debugLineNum = 9633815;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
mostCurrent._lblcontornoboton.setWidth((int) (_anchodispositivo*0.17));
RDebugUtils.currentLine=9633816;
 //BA.debugLineNum = 9633816;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
mostCurrent._lblcontornoboton.setHeight(mostCurrent._lblcontornoboton.getWidth());
RDebugUtils.currentLine=9633817;
 //BA.debugLineNum = 9633817;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
mostCurrent._lblcontornoboton.setLeft((int) ((_anchodispositivo-mostCurrent._lblcontornoboton.getWidth())/(double)2));
RDebugUtils.currentLine=9633818;
 //BA.debugLineNum = 9633818;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
mostCurrent._lblcontornoboton.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._lblcontornoboton.getHeight()/(double)2));
RDebugUtils.currentLine=9633822;
 //BA.debugLineNum = 9633822;BA.debugLine="svPantalla.Height = pnlNavInferior.Top";
mostCurrent._svpantalla.setHeight(mostCurrent._pnlnavinferior.getTop());
RDebugUtils.currentLine=9633823;
 //BA.debugLineNum = 9633823;BA.debugLine="svPantalla.Panel.LoadLayout(\"LPantallaDeslizable\"";
mostCurrent._svpantalla.getPanel().LoadLayout("LPantallaDeslizable",mostCurrent.activityBA);
RDebugUtils.currentLine=9633824;
 //BA.debugLineNum = 9633824;BA.debugLine="svPantalla.Width = anchoDispositivo * 1.5";
mostCurrent._svpantalla.setWidth((int) (_anchodispositivo*1.5));
RDebugUtils.currentLine=9633825;
 //BA.debugLineNum = 9633825;BA.debugLine="pnlDeslizable.Width = svPantalla.Width";
mostCurrent._pnldeslizable.setWidth(mostCurrent._svpantalla.getWidth());
RDebugUtils.currentLine=9633832;
 //BA.debugLineNum = 9633832;BA.debugLine="Dim lblSeccion As Label";
_lblseccion = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=9633833;
 //BA.debugLineNum = 9633833;BA.debugLine="lblSeccion.Initialize(\"lblSeccion\")";
_lblseccion.Initialize(mostCurrent.activityBA,"lblSeccion");
RDebugUtils.currentLine=9633834;
 //BA.debugLineNum = 9633834;BA.debugLine="lblSeccion.Text = \"Gastos\"";
_lblseccion.setText(BA.ObjectToCharSequence("Gastos"));
RDebugUtils.currentLine=9633835;
 //BA.debugLineNum = 9633835;BA.debugLine="lblSeccion.TextSize = 20";
_lblseccion.setTextSize((float) (20));
RDebugUtils.currentLine=9633836;
 //BA.debugLineNum = 9633836;BA.debugLine="lblSeccion.TextColor = Colors.Black";
_lblseccion.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=9633837;
 //BA.debugLineNum = 9633837;BA.debugLine="lblSeccion.Height = 30dip";
_lblseccion.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=9633838;
 //BA.debugLineNum = 9633838;BA.debugLine="lblSeccion.Width = anchoDispositivo * 0.9";
_lblseccion.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=9633839;
 //BA.debugLineNum = 9633839;BA.debugLine="lblSeccion.Top = 30dip";
_lblseccion.setTop(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=9633840;
 //BA.debugLineNum = 9633840;BA.debugLine="lblSeccion.Left = (anchoDispositivo - lblSeccion.";
_lblseccion.setLeft((int) ((_anchodispositivo-_lblseccion.getWidth())/(double)2));
RDebugUtils.currentLine=9633841;
 //BA.debugLineNum = 9633841;BA.debugLine="pnlDeslizable.AddView(lblSeccion, lblSeccion.Left";
mostCurrent._pnldeslizable.AddView((android.view.View)(_lblseccion.getObject()),_lblseccion.getLeft(),_lblseccion.getTop(),_lblseccion.getWidth(),_lblseccion.getHeight());
RDebugUtils.currentLine=9633846;
 //BA.debugLineNum = 9633846;BA.debugLine="Dim top As Int";
_top = 0;
RDebugUtils.currentLine=9633847;
 //BA.debugLineNum = 9633847;BA.debugLine="top = lblSeccion.Top + lblSeccion.Height + 30dip";
_top = (int) (_lblseccion.getTop()+_lblseccion.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=9633850;
 //BA.debugLineNum = 9633850;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM gastos ORDER B";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM gastos ORDER BY rowid ASC")));
RDebugUtils.currentLine=9633851;
 //BA.debugLineNum = 9633851;BA.debugLine="nRegistros = cur.RowCount";
_nregistros = mostCurrent._cur.getRowCount();
RDebugUtils.currentLine=9633855;
 //BA.debugLineNum = 9633855;BA.debugLine="If nRegistros > 0 Then";
if (_nregistros>0) { 
RDebugUtils.currentLine=9633857;
 //BA.debugLineNum = 9633857;BA.debugLine="Dim Relaciones(nRegistros, 2) As B4XView";
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
RDebugUtils.currentLine=9633858;
 //BA.debugLineNum = 9633858;BA.debugLine="Dim arrayPnlsOpciones(nRegistros) As B4XView";
mostCurrent._arraypnlsopciones = new anywheresoftware.b4a.objects.B4XViewWrapper[_nregistros];
{
int d0 = mostCurrent._arraypnlsopciones.length;
for (int i0 = 0;i0 < d0;i0++) {
mostCurrent._arraypnlsopciones[i0] = new anywheresoftware.b4a.objects.B4XViewWrapper();
}
}
;
RDebugUtils.currentLine=9633860;
 //BA.debugLineNum = 9633860;BA.debugLine="For id = 0 To nRegistros - 1";
{
final int step41 = 1;
final int limit41 = (int) (_nregistros-1);
_id = (int) (0) ;
for (;_id <= limit41 ;_id = _id + step41 ) {
RDebugUtils.currentLine=9633861;
 //BA.debugLineNum = 9633861;BA.debugLine="cur.Position = id";
mostCurrent._cur.setPosition(_id);
RDebugUtils.currentLine=9633863;
 //BA.debugLineNum = 9633863;BA.debugLine="Dim datosGasto As Gasto";
_datosgasto = new pullup.wallet.gastos._gasto();
RDebugUtils.currentLine=9633864;
 //BA.debugLineNum = 9633864;BA.debugLine="datosGasto.rowid = cur.GetInt(\"id_gasto\")";
_datosgasto.rowid /*int*/  = mostCurrent._cur.GetInt("id_gasto");
RDebugUtils.currentLine=9633865;
 //BA.debugLineNum = 9633865;BA.debugLine="datosGasto.nombre = cur.GetString(\"nombre\")";
_datosgasto.nombre /*String*/  = mostCurrent._cur.GetString("nombre");
RDebugUtils.currentLine=9633866;
 //BA.debugLineNum = 9633866;BA.debugLine="datosGasto.monto = cur.GetInt(\"monto\")";
_datosgasto.monto /*int*/  = mostCurrent._cur.GetInt("monto");
RDebugUtils.currentLine=9633867;
 //BA.debugLineNum = 9633867;BA.debugLine="datosGasto.descripcion = cur.GetString(\"descrip";
_datosgasto.descripcion /*String*/  = mostCurrent._cur.GetString("descripcion");
RDebugUtils.currentLine=9633868;
 //BA.debugLineNum = 9633868;BA.debugLine="datosGasto.fecha = cur.GetString(\"fecha_registr";
_datosgasto.fecha /*String*/  = mostCurrent._cur.GetString("fecha_registro");
RDebugUtils.currentLine=9633869;
 //BA.debugLineNum = 9633869;BA.debugLine="datosGasto.color = cur.GetInt(\"color\")";
_datosgasto.color /*int*/  = mostCurrent._cur.GetInt("color");
RDebugUtils.currentLine=9633871;
 //BA.debugLineNum = 9633871;BA.debugLine="creaObjetoLista(id, top, datosGasto)";
_creaobjetolista(_id,_top,_datosgasto);
RDebugUtils.currentLine=9633873;
 //BA.debugLineNum = 9633873;BA.debugLine="top = top + alturaDispositivo * 0.12 + 60";
_top = (int) (_top+_alturadispositivo*0.12+60);
 }
};
 }else {
RDebugUtils.currentLine=9633877;
 //BA.debugLineNum = 9633877;BA.debugLine="Dim lblMensaje As Label";
_lblmensaje = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=9633878;
 //BA.debugLineNum = 9633878;BA.debugLine="lblMensaje.Initialize(\"lblMensaje\")";
_lblmensaje.Initialize(mostCurrent.activityBA,"lblMensaje");
RDebugUtils.currentLine=9633879;
 //BA.debugLineNum = 9633879;BA.debugLine="lblMensaje.Height = alturaDispositivo * 0.2";
_lblmensaje.setHeight((int) (_alturadispositivo*0.2));
RDebugUtils.currentLine=9633880;
 //BA.debugLineNum = 9633880;BA.debugLine="lblMensaje.Width = anchoDispositivo * 0.9";
_lblmensaje.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=9633881;
 //BA.debugLineNum = 9633881;BA.debugLine="lblMensaje.Top = (alturaDispositivo - lblMensaje";
_lblmensaje.setTop((int) ((_alturadispositivo-_lblmensaje.getHeight())/(double)2));
RDebugUtils.currentLine=9633882;
 //BA.debugLineNum = 9633882;BA.debugLine="lblMensaje.Left = (anchoDispositivo - lblMensaje";
_lblmensaje.setLeft((int) ((_anchodispositivo-_lblmensaje.getWidth())/(double)2));
RDebugUtils.currentLine=9633883;
 //BA.debugLineNum = 9633883;BA.debugLine="lblMensaje.Text = cs.Initialize.Color(Colors.Bla";
_lblmensaje.setText(BA.ObjectToCharSequence(mostCurrent._cs.Initialize().Color(anywheresoftware.b4a.keywords.Common.Colors.Black).Alignment(BA.getEnumFromString(android.text.Layout.Alignment.class,"ALIGN_CENTER")).Typeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS()).Size((int) (50)).Append(BA.ObjectToCharSequence(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (0xe89c)))+anywheresoftware.b4a.keywords.Common.CRLF)).Typeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT).Size((int) (18)).Append(BA.ObjectToCharSequence("Está muy vacío aquí adentro."+anywheresoftware.b4a.keywords.Common.CRLF)).Append(BA.ObjectToCharSequence("Agrega un gasto desde el menú principal.")).PopAll().getObject()));
RDebugUtils.currentLine=9633884;
 //BA.debugLineNum = 9633884;BA.debugLine="Activity.AddView(lblMensaje, lblMensaje.Left, lb";
mostCurrent._activity.AddView((android.view.View)(_lblmensaje.getObject()),_lblmensaje.getLeft(),_lblmensaje.getTop(),_lblmensaje.getWidth(),_lblmensaje.getHeight());
 };
RDebugUtils.currentLine=9633887;
 //BA.debugLineNum = 9633887;BA.debugLine="svPantalla.Panel.Height = top + 100";
mostCurrent._svpantalla.getPanel().setHeight((int) (_top+100));
RDebugUtils.currentLine=9633891;
 //BA.debugLineNum = 9633891;BA.debugLine="sumaEgresosAntigua = 0";
_sumaegresosantigua = (int) (0);
RDebugUtils.currentLine=9633892;
 //BA.debugLineNum = 9633892;BA.debugLine="montoSeleccionado = 0";
_montoseleccionado = (int) (0);
RDebugUtils.currentLine=9633893;
 //BA.debugLineNum = 9633893;BA.debugLine="sumaEgresosActual = 0";
_sumaegresosactual = (int) (0);
RDebugUtils.currentLine=9633894;
 //BA.debugLineNum = 9633894;BA.debugLine="End Sub";
return "";
}
public static String  _creaobjetolista(int _indice,int _top,pullup.wallet.gastos._gasto _datos) throws Exception{
RDebugUtils.currentModule="gastos";
if (Debug.shouldDelegate(mostCurrent.activityBA, "creaobjetolista", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "creaobjetolista", new Object[] {_indice,_top,_datos}));}
anywheresoftware.b4a.objects.PanelWrapper _pnlgasto = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlopciones = null;
anywheresoftware.b4a.objects.LabelWrapper _lblnombre = null;
anywheresoftware.b4a.objects.LabelWrapper _lblmonto = null;
anywheresoftware.b4a.objects.LabelWrapper _lbldescripcion = null;
anywheresoftware.b4a.objects.LabelWrapper _lblfecha = null;
anywheresoftware.b4a.objects.LabelWrapper _lblopciones = null;
anywheresoftware.b4a.objects.ButtonWrapper _btneditar = null;
anywheresoftware.b4a.objects.ButtonWrapper _btneliminar = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
pullup.wallet.gastos._indicegasto _referencia = null;
pullup.wallet.gastos._indicegasto _referencia2 = null;
RDebugUtils.currentLine=9895936;
 //BA.debugLineNum = 9895936;BA.debugLine="Sub creaObjetoLista(indice As Int, top As Int, dat";
RDebugUtils.currentLine=9895937;
 //BA.debugLineNum = 9895937;BA.debugLine="Dim pnlGasto As Panel";
_pnlgasto = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=9895938;
 //BA.debugLineNum = 9895938;BA.debugLine="Dim pnlOpciones As Panel";
_pnlopciones = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=9895939;
 //BA.debugLineNum = 9895939;BA.debugLine="Dim lblNombre As Label";
_lblnombre = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=9895940;
 //BA.debugLineNum = 9895940;BA.debugLine="Dim lblMonto As Label";
_lblmonto = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=9895941;
 //BA.debugLineNum = 9895941;BA.debugLine="Dim lblDescripcion As Label";
_lbldescripcion = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=9895942;
 //BA.debugLineNum = 9895942;BA.debugLine="Dim lblFecha As Label";
_lblfecha = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=9895943;
 //BA.debugLineNum = 9895943;BA.debugLine="Dim lblOpciones As Label";
_lblopciones = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=9895944;
 //BA.debugLineNum = 9895944;BA.debugLine="Dim btnEditar As Button";
_btneditar = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=9895945;
 //BA.debugLineNum = 9895945;BA.debugLine="Dim btnEliminar As Button";
_btneliminar = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=9895948;
 //BA.debugLineNum = 9895948;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=9895949;
 //BA.debugLineNum = 9895949;BA.debugLine="cd.Initialize(datos.color, 20)";
_cd.Initialize(_datos.color /*int*/ ,(int) (20));
RDebugUtils.currentLine=9895952;
 //BA.debugLineNum = 9895952;BA.debugLine="pnlGasto.Initialize(\"pnlGasto\")";
_pnlgasto.Initialize(mostCurrent.activityBA,"pnlGasto");
RDebugUtils.currentLine=9895953;
 //BA.debugLineNum = 9895953;BA.debugLine="pnlGasto.Top = top";
_pnlgasto.setTop(_top);
RDebugUtils.currentLine=9895954;
 //BA.debugLineNum = 9895954;BA.debugLine="pnlGasto.Background = cd";
_pnlgasto.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=9895955;
 //BA.debugLineNum = 9895955;BA.debugLine="pnlGasto.Width = anchoDispositivo * 0.9";
_pnlgasto.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=9895956;
 //BA.debugLineNum = 9895956;BA.debugLine="pnlGasto.Height = alturaDispositivo * 0.14";
_pnlgasto.setHeight((int) (_alturadispositivo*0.14));
RDebugUtils.currentLine=9895957;
 //BA.debugLineNum = 9895957;BA.debugLine="pnlGasto.Left = (anchoDispositivo - pnlGasto.Widt";
_pnlgasto.setLeft((int) ((_anchodispositivo-_pnlgasto.getWidth())/(double)2));
RDebugUtils.currentLine=9895959;
 //BA.debugLineNum = 9895959;BA.debugLine="lblNombre.Initialize(\"lblNombre\")";
_lblnombre.Initialize(mostCurrent.activityBA,"lblNombre");
RDebugUtils.currentLine=9895960;
 //BA.debugLineNum = 9895960;BA.debugLine="lblNombre.TextColor = Colors.White";
_lblnombre.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=9895961;
 //BA.debugLineNum = 9895961;BA.debugLine="lblNombre.Text = datos.nombre.ToUpperCase.CharAt(";
_lblnombre.setText(BA.ObjectToCharSequence(BA.ObjectToString(_datos.nombre /*String*/ .toUpperCase().charAt((int) (0)))+_datos.nombre /*String*/ .substring((int) (1)).toLowerCase()));
RDebugUtils.currentLine=9895962;
 //BA.debugLineNum = 9895962;BA.debugLine="lblNombre.TextSize = 19";
_lblnombre.setTextSize((float) (19));
RDebugUtils.currentLine=9895963;
 //BA.debugLineNum = 9895963;BA.debugLine="lblNombre.Height = pnlGasto.Height * 0.3";
_lblnombre.setHeight((int) (_pnlgasto.getHeight()*0.3));
RDebugUtils.currentLine=9895964;
 //BA.debugLineNum = 9895964;BA.debugLine="lblNombre.Width = pnlGasto.Width * 0.9";
_lblnombre.setWidth((int) (_pnlgasto.getWidth()*0.9));
RDebugUtils.currentLine=9895965;
 //BA.debugLineNum = 9895965;BA.debugLine="lblNombre.Top = 0";
_lblnombre.setTop((int) (0));
RDebugUtils.currentLine=9895966;
 //BA.debugLineNum = 9895966;BA.debugLine="lblNombre.Left = pnlGasto.Width * 0.05";
_lblnombre.setLeft((int) (_pnlgasto.getWidth()*0.05));
RDebugUtils.currentLine=9895967;
 //BA.debugLineNum = 9895967;BA.debugLine="lblNombre.Gravity = Gravity.CENTER_VERTICAL";
_lblnombre.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=9895968;
 //BA.debugLineNum = 9895968;BA.debugLine="pnlGasto.AddView(lblNombre, lblNombre.Left, lblNo";
_pnlgasto.AddView((android.view.View)(_lblnombre.getObject()),_lblnombre.getLeft(),_lblnombre.getTop(),_lblnombre.getWidth(),_lblnombre.getHeight());
RDebugUtils.currentLine=9895970;
 //BA.debugLineNum = 9895970;BA.debugLine="lblDescripcion.Initialize(\"lblDescripcion\")";
_lbldescripcion.Initialize(mostCurrent.activityBA,"lblDescripcion");
RDebugUtils.currentLine=9895971;
 //BA.debugLineNum = 9895971;BA.debugLine="lblDescripcion.Text = datos.descripcion.ToUpperCa";
_lbldescripcion.setText(BA.ObjectToCharSequence(BA.ObjectToString(_datos.descripcion /*String*/ .toUpperCase().charAt((int) (0)))+_datos.descripcion /*String*/ .substring((int) (1)).toLowerCase()));
RDebugUtils.currentLine=9895972;
 //BA.debugLineNum = 9895972;BA.debugLine="lblDescripcion.TextColor = Colors.White";
_lbldescripcion.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=9895973;
 //BA.debugLineNum = 9895973;BA.debugLine="lblDescripcion.Height = pnlGasto.Height * 0.3";
_lbldescripcion.setHeight((int) (_pnlgasto.getHeight()*0.3));
RDebugUtils.currentLine=9895974;
 //BA.debugLineNum = 9895974;BA.debugLine="lblDescripcion.Width = pnlGasto.Width * 0.9";
_lbldescripcion.setWidth((int) (_pnlgasto.getWidth()*0.9));
RDebugUtils.currentLine=9895975;
 //BA.debugLineNum = 9895975;BA.debugLine="lblDescripcion.Top = lblNombre.Height";
_lbldescripcion.setTop(_lblnombre.getHeight());
RDebugUtils.currentLine=9895976;
 //BA.debugLineNum = 9895976;BA.debugLine="lblDescripcion.Left = lblNombre.Left";
_lbldescripcion.setLeft(_lblnombre.getLeft());
RDebugUtils.currentLine=9895977;
 //BA.debugLineNum = 9895977;BA.debugLine="lblDescripcion.Gravity = Gravity.CENTER_VERTICAL";
_lbldescripcion.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=9895978;
 //BA.debugLineNum = 9895978;BA.debugLine="pnlGasto.AddView(lblDescripcion, lblDescripcion.L";
_pnlgasto.AddView((android.view.View)(_lbldescripcion.getObject()),_lbldescripcion.getLeft(),_lbldescripcion.getTop(),_lbldescripcion.getWidth(),_lbldescripcion.getHeight());
RDebugUtils.currentLine=9895980;
 //BA.debugLineNum = 9895980;BA.debugLine="lblFecha.Initialize(\"lblFecha\")";
_lblfecha.Initialize(mostCurrent.activityBA,"lblFecha");
RDebugUtils.currentLine=9895981;
 //BA.debugLineNum = 9895981;BA.debugLine="lblFecha.Text = datos.fecha";
_lblfecha.setText(BA.ObjectToCharSequence(_datos.fecha /*String*/ ));
RDebugUtils.currentLine=9895982;
 //BA.debugLineNum = 9895982;BA.debugLine="lblFecha.TextSize = 16";
_lblfecha.setTextSize((float) (16));
RDebugUtils.currentLine=9895983;
 //BA.debugLineNum = 9895983;BA.debugLine="lblFecha.TextColor = Colors.DarkGray";
_lblfecha.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.DarkGray);
RDebugUtils.currentLine=9895984;
 //BA.debugLineNum = 9895984;BA.debugLine="lblFecha.Height = pnlGasto.Height * 0.4";
_lblfecha.setHeight((int) (_pnlgasto.getHeight()*0.4));
RDebugUtils.currentLine=9895985;
 //BA.debugLineNum = 9895985;BA.debugLine="lblFecha.Width = pnlGasto.Width * 0.9";
_lblfecha.setWidth((int) (_pnlgasto.getWidth()*0.9));
RDebugUtils.currentLine=9895986;
 //BA.debugLineNum = 9895986;BA.debugLine="lblFecha.Top = lblDescripcion.Top + lblDescripcio";
_lblfecha.setTop((int) (_lbldescripcion.getTop()+_lbldescripcion.getHeight()));
RDebugUtils.currentLine=9895987;
 //BA.debugLineNum = 9895987;BA.debugLine="lblFecha.Left = lblNombre.Left";
_lblfecha.setLeft(_lblnombre.getLeft());
RDebugUtils.currentLine=9895988;
 //BA.debugLineNum = 9895988;BA.debugLine="lblFecha.Gravity = Gravity.CENTER_VERTICAL";
_lblfecha.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=9895989;
 //BA.debugLineNum = 9895989;BA.debugLine="pnlGasto.AddView(lblFecha, lblFecha.Left, lblFech";
_pnlgasto.AddView((android.view.View)(_lblfecha.getObject()),_lblfecha.getLeft(),_lblfecha.getTop(),_lblfecha.getWidth(),_lblfecha.getHeight());
RDebugUtils.currentLine=9895991;
 //BA.debugLineNum = 9895991;BA.debugLine="lblMonto.Initialize(\"lblMonto\")";
_lblmonto.Initialize(mostCurrent.activityBA,"lblMonto");
RDebugUtils.currentLine=9895992;
 //BA.debugLineNum = 9895992;BA.debugLine="lblMonto.TextSize = 16";
_lblmonto.setTextSize((float) (16));
RDebugUtils.currentLine=9895993;
 //BA.debugLineNum = 9895993;BA.debugLine="lblMonto.TextColor = Colors.Red";
_lblmonto.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=9895994;
 //BA.debugLineNum = 9895994;BA.debugLine="lblMonto.Width = cvsTest.MeasureStringWidth((\"$\"";
_lblmonto.setWidth((int) (mostCurrent._cvstest.MeasureStringWidth(("$"+BA.NumberToString(_datos.monto /*int*/ )),anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT,_lblmonto.getTextSize())+2));
RDebugUtils.currentLine=9895995;
 //BA.debugLineNum = 9895995;BA.debugLine="lblMonto.Height = pnlGasto.Height * 0.4";
_lblmonto.setHeight((int) (_pnlgasto.getHeight()*0.4));
RDebugUtils.currentLine=9895996;
 //BA.debugLineNum = 9895996;BA.debugLine="lblMonto.Text = \"$\" & datos.monto";
_lblmonto.setText(BA.ObjectToCharSequence("$"+BA.NumberToString(_datos.monto /*int*/ )));
RDebugUtils.currentLine=9895997;
 //BA.debugLineNum = 9895997;BA.debugLine="lblMonto.Top = lblFecha.Top";
_lblmonto.setTop(_lblfecha.getTop());
RDebugUtils.currentLine=9895998;
 //BA.debugLineNum = 9895998;BA.debugLine="lblMonto.Left = pnlGasto.Width - lblMonto.Width -";
_lblmonto.setLeft((int) (_pnlgasto.getWidth()-_lblmonto.getWidth()-_lblnombre.getLeft()));
RDebugUtils.currentLine=9895999;
 //BA.debugLineNum = 9895999;BA.debugLine="lblMonto.Gravity = Gravity.CENTER_VERTICAL";
_lblmonto.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=9896000;
 //BA.debugLineNum = 9896000;BA.debugLine="pnlGasto.AddView(lblMonto, lblMonto.Left, lblMont";
_pnlgasto.AddView((android.view.View)(_lblmonto.getObject()),_lblmonto.getLeft(),_lblmonto.getTop(),_lblmonto.getWidth(),_lblmonto.getHeight());
RDebugUtils.currentLine=9896002;
 //BA.debugLineNum = 9896002;BA.debugLine="lblOpciones.Initialize(\"lblOpciones\")";
_lblopciones.Initialize(mostCurrent.activityBA,"lblOpciones");
RDebugUtils.currentLine=9896003;
 //BA.debugLineNum = 9896003;BA.debugLine="lblOpciones.Typeface = Typeface.FONTAWESOME";
_lblopciones.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getFONTAWESOME());
RDebugUtils.currentLine=9896004;
 //BA.debugLineNum = 9896004;BA.debugLine="lblOpciones.Text = Chr(0xF142)";
_lblopciones.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf142))));
RDebugUtils.currentLine=9896005;
 //BA.debugLineNum = 9896005;BA.debugLine="lblOpciones.TextSize = 18";
_lblopciones.setTextSize((float) (18));
RDebugUtils.currentLine=9896006;
 //BA.debugLineNum = 9896006;BA.debugLine="lblOpciones.TextColor = Colors.White";
_lblopciones.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=9896007;
 //BA.debugLineNum = 9896007;BA.debugLine="lblOpciones.Height = lblNombre.Height";
_lblopciones.setHeight(_lblnombre.getHeight());
RDebugUtils.currentLine=9896008;
 //BA.debugLineNum = 9896008;BA.debugLine="lblOpciones.Width = 8dip";
_lblopciones.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (8)));
RDebugUtils.currentLine=9896009;
 //BA.debugLineNum = 9896009;BA.debugLine="lblOpciones.Left = lblMonto.Left + lblMonto.Width";
_lblopciones.setLeft((int) (_lblmonto.getLeft()+_lblmonto.getWidth()-_lblopciones.getWidth()));
RDebugUtils.currentLine=9896010;
 //BA.debugLineNum = 9896010;BA.debugLine="lblOpciones.Top = 0";
_lblopciones.setTop((int) (0));
RDebugUtils.currentLine=9896011;
 //BA.debugLineNum = 9896011;BA.debugLine="lblOpciones.Gravity = Gravity.CENTER_VERTICAL";
_lblopciones.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=9896012;
 //BA.debugLineNum = 9896012;BA.debugLine="pnlGasto.AddView(lblOpciones, lblOpciones.Left, l";
_pnlgasto.AddView((android.view.View)(_lblopciones.getObject()),_lblopciones.getLeft(),_lblopciones.getTop(),_lblopciones.getWidth(),_lblopciones.getHeight());
RDebugUtils.currentLine=9896014;
 //BA.debugLineNum = 9896014;BA.debugLine="pnlOpciones.Initialize(\"pnlOpciones\")";
_pnlopciones.Initialize(mostCurrent.activityBA,"pnlOpciones");
RDebugUtils.currentLine=9896015;
 //BA.debugLineNum = 9896015;BA.debugLine="cd.Initialize(Colors.Black, 20)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.Black,(int) (20));
RDebugUtils.currentLine=9896016;
 //BA.debugLineNum = 9896016;BA.debugLine="pnlOpciones.Background = cd";
_pnlopciones.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=9896017;
 //BA.debugLineNum = 9896017;BA.debugLine="pnlOpciones.Height = pnlGasto.Height * 0.8";
_pnlopciones.setHeight((int) (_pnlgasto.getHeight()*0.8));
RDebugUtils.currentLine=9896018;
 //BA.debugLineNum = 9896018;BA.debugLine="pnlOpciones.Width = pnlGasto.Height";
_pnlopciones.setWidth(_pnlgasto.getHeight());
RDebugUtils.currentLine=9896019;
 //BA.debugLineNum = 9896019;BA.debugLine="pnlOpciones.Top = lblOpciones.Top";
_pnlopciones.setTop(_lblopciones.getTop());
RDebugUtils.currentLine=9896020;
 //BA.debugLineNum = 9896020;BA.debugLine="pnlOpciones.Left = lblOpciones.Left - lblOpciones";
_pnlopciones.setLeft((int) (_lblopciones.getLeft()-_lblopciones.getWidth()*2-_pnlopciones.getWidth()));
RDebugUtils.currentLine=9896021;
 //BA.debugLineNum = 9896021;BA.debugLine="pnlOpciones.Visible = False";
_pnlopciones.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=9896022;
 //BA.debugLineNum = 9896022;BA.debugLine="pnlGasto.AddView(pnlOpciones, pnlOpciones.Left, p";
_pnlgasto.AddView((android.view.View)(_pnlopciones.getObject()),_pnlopciones.getLeft(),_pnlopciones.getTop(),_pnlopciones.getWidth(),_pnlopciones.getHeight());
RDebugUtils.currentLine=9896024;
 //BA.debugLineNum = 9896024;BA.debugLine="btnEditar.Initialize(\"btnEditar\")";
_btneditar.Initialize(mostCurrent.activityBA,"btnEditar");
RDebugUtils.currentLine=9896025;
 //BA.debugLineNum = 9896025;BA.debugLine="btnEditar.Color = Colors.Transparent";
_btneditar.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=9896026;
 //BA.debugLineNum = 9896026;BA.debugLine="btnEditar.Text = \"Editar\"";
_btneditar.setText(BA.ObjectToCharSequence("Editar"));
RDebugUtils.currentLine=9896027;
 //BA.debugLineNum = 9896027;BA.debugLine="btnEditar.TextColor = Colors.White";
_btneditar.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=9896028;
 //BA.debugLineNum = 9896028;BA.debugLine="btnEditar.TextSize = 14";
_btneditar.setTextSize((float) (14));
RDebugUtils.currentLine=9896029;
 //BA.debugLineNum = 9896029;BA.debugLine="btnEditar.Height = pnlOpciones.Height * 0.4";
_btneditar.setHeight((int) (_pnlopciones.getHeight()*0.4));
RDebugUtils.currentLine=9896030;
 //BA.debugLineNum = 9896030;BA.debugLine="btnEditar.Width = pnlOpciones.Height * 0.8";
_btneditar.setWidth((int) (_pnlopciones.getHeight()*0.8));
RDebugUtils.currentLine=9896031;
 //BA.debugLineNum = 9896031;BA.debugLine="btnEditar.Top = (pnlOpciones.Height * 0.2) / 3";
_btneditar.setTop((int) ((_pnlopciones.getHeight()*0.2)/(double)3));
RDebugUtils.currentLine=9896032;
 //BA.debugLineNum = 9896032;BA.debugLine="btnEditar.Left = (pnlOpciones.Width - btnEditar.W";
_btneditar.setLeft((int) ((_pnlopciones.getWidth()-_btneditar.getWidth())/(double)2));
RDebugUtils.currentLine=9896033;
 //BA.debugLineNum = 9896033;BA.debugLine="pnlOpciones.AddView(btnEditar, btnEditar.Left, bt";
_pnlopciones.AddView((android.view.View)(_btneditar.getObject()),_btneditar.getLeft(),_btneditar.getTop(),_btneditar.getWidth(),_btneditar.getHeight());
RDebugUtils.currentLine=9896035;
 //BA.debugLineNum = 9896035;BA.debugLine="btnEliminar.Initialize(\"btnEliminar\")";
_btneliminar.Initialize(mostCurrent.activityBA,"btnEliminar");
RDebugUtils.currentLine=9896036;
 //BA.debugLineNum = 9896036;BA.debugLine="btnEliminar.Color = Colors.Transparent";
_btneliminar.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=9896037;
 //BA.debugLineNum = 9896037;BA.debugLine="btnEliminar.Text = \"Eliminar\"";
_btneliminar.setText(BA.ObjectToCharSequence("Eliminar"));
RDebugUtils.currentLine=9896038;
 //BA.debugLineNum = 9896038;BA.debugLine="btnEliminar.TextColor = Colors.White";
_btneliminar.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=9896039;
 //BA.debugLineNum = 9896039;BA.debugLine="btnEliminar.TextSize = 14";
_btneliminar.setTextSize((float) (14));
RDebugUtils.currentLine=9896040;
 //BA.debugLineNum = 9896040;BA.debugLine="btnEliminar.Height = btnEditar.Height";
_btneliminar.setHeight(_btneditar.getHeight());
RDebugUtils.currentLine=9896041;
 //BA.debugLineNum = 9896041;BA.debugLine="btnEliminar.Width = pnlOpciones.Width * 0.9";
_btneliminar.setWidth((int) (_pnlopciones.getWidth()*0.9));
RDebugUtils.currentLine=9896042;
 //BA.debugLineNum = 9896042;BA.debugLine="btnEliminar.Top = btnEditar.Top * 2 + btnEditar.H";
_btneliminar.setTop((int) (_btneditar.getTop()*2+_btneditar.getHeight()));
RDebugUtils.currentLine=9896043;
 //BA.debugLineNum = 9896043;BA.debugLine="btnEliminar.Left = (pnlOpciones.Width - btnElimin";
_btneliminar.setLeft((int) ((_pnlopciones.getWidth()-_btneliminar.getWidth())/(double)2));
RDebugUtils.currentLine=9896044;
 //BA.debugLineNum = 9896044;BA.debugLine="pnlOpciones.AddView(btnEliminar, btnEliminar.Left";
_pnlopciones.AddView((android.view.View)(_btneliminar.getObject()),_btneliminar.getLeft(),_btneliminar.getTop(),_btneliminar.getWidth(),_btneliminar.getHeight());
RDebugUtils.currentLine=9896046;
 //BA.debugLineNum = 9896046;BA.debugLine="pnlDeslizable.AddView(pnlGasto, pnlGasto.Left, to";
mostCurrent._pnldeslizable.AddView((android.view.View)(_pnlgasto.getObject()),_pnlgasto.getLeft(),_top,_pnlgasto.getWidth(),_pnlgasto.getHeight());
RDebugUtils.currentLine=9896050;
 //BA.debugLineNum = 9896050;BA.debugLine="Dim referencia As IndiceGasto";
_referencia = new pullup.wallet.gastos._indicegasto();
RDebugUtils.currentLine=9896051;
 //BA.debugLineNum = 9896051;BA.debugLine="referencia.indiceElemento = indice";
_referencia.indiceElemento /*int*/  = _indice;
RDebugUtils.currentLine=9896052;
 //BA.debugLineNum = 9896052;BA.debugLine="referencia.rowid = 0";
_referencia.rowid /*int*/  = (int) (0);
RDebugUtils.currentLine=9896054;
 //BA.debugLineNum = 9896054;BA.debugLine="lblOpciones.Tag = referencia";
_lblopciones.setTag((Object)(_referencia));
RDebugUtils.currentLine=9896057;
 //BA.debugLineNum = 9896057;BA.debugLine="Dim referencia2 As IndiceGasto";
_referencia2 = new pullup.wallet.gastos._indicegasto();
RDebugUtils.currentLine=9896058;
 //BA.debugLineNum = 9896058;BA.debugLine="referencia2.indiceElemento = 0";
_referencia2.indiceElemento /*int*/  = (int) (0);
RDebugUtils.currentLine=9896059;
 //BA.debugLineNum = 9896059;BA.debugLine="referencia2.rowid = datos.rowid";
_referencia2.rowid /*int*/  = _datos.rowid /*int*/ ;
RDebugUtils.currentLine=9896061;
 //BA.debugLineNum = 9896061;BA.debugLine="pnlOpciones.Tag = referencia2";
_pnlopciones.setTag((Object)(_referencia2));
RDebugUtils.currentLine=9896064;
 //BA.debugLineNum = 9896064;BA.debugLine="Relaciones(indice, 0) = lblOpciones";
mostCurrent._relaciones[_indice][(int) (0)] = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lblopciones.getObject()));
RDebugUtils.currentLine=9896065;
 //BA.debugLineNum = 9896065;BA.debugLine="Relaciones(indice, 1) = pnlOpciones";
mostCurrent._relaciones[_indice][(int) (1)] = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnlopciones.getObject()));
RDebugUtils.currentLine=9896068;
 //BA.debugLineNum = 9896068;BA.debugLine="arrayPnlsOpciones(indice) = pnlOpciones";
mostCurrent._arraypnlsopciones[_indice] = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnlopciones.getObject()));
RDebugUtils.currentLine=9896069;
 //BA.debugLineNum = 9896069;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="gastos";
RDebugUtils.currentLine=9764864;
 //BA.debugLineNum = 9764864;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=9764866;
 //BA.debugLineNum = 9764866;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="gastos";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=9699328;
 //BA.debugLineNum = 9699328;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=9699330;
 //BA.debugLineNum = 9699330;BA.debugLine="End Sub";
return "";
}
public static String  _btneditar_click() throws Exception{
RDebugUtils.currentModule="gastos";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btneditar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btneditar_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btneditar = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlpadre = null;
int _idregistro = 0;
pullup.wallet.gastos._indicegasto _indice = null;
RDebugUtils.currentLine=10027008;
 //BA.debugLineNum = 10027008;BA.debugLine="Sub btnEditar_Click";
RDebugUtils.currentLine=10027009;
 //BA.debugLineNum = 10027009;BA.debugLine="Dim btnEditar As Button";
_btneditar = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=10027010;
 //BA.debugLineNum = 10027010;BA.debugLine="Dim pnlPadre As Panel";
_pnlpadre = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=10027011;
 //BA.debugLineNum = 10027011;BA.debugLine="Dim idRegistro As Int";
_idregistro = 0;
RDebugUtils.currentLine=10027012;
 //BA.debugLineNum = 10027012;BA.debugLine="Dim indice As IndiceGasto";
_indice = new pullup.wallet.gastos._indicegasto();
RDebugUtils.currentLine=10027015;
 //BA.debugLineNum = 10027015;BA.debugLine="btnEditar = Sender";
_btneditar = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=10027017;
 //BA.debugLineNum = 10027017;BA.debugLine="pnlPadre = btnEditar.Parent";
_pnlpadre = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_btneditar.getParent()));
RDebugUtils.currentLine=10027019;
 //BA.debugLineNum = 10027019;BA.debugLine="indice = pnlPadre.Tag";
_indice = (pullup.wallet.gastos._indicegasto)(_pnlpadre.getTag());
RDebugUtils.currentLine=10027021;
 //BA.debugLineNum = 10027021;BA.debugLine="idRegistro = indice.rowid";
_idregistro = _indice.rowid /*int*/ ;
RDebugUtils.currentLine=10027022;
 //BA.debugLineNum = 10027022;BA.debugLine="CallSubDelayed2(editarGasto, \"consultaAEditar\", i";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._editargasto.getObject()),"consultaAEditar",(Object)(_idregistro));
RDebugUtils.currentLine=10027023;
 //BA.debugLineNum = 10027023;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=10027024;
 //BA.debugLineNum = 10027024;BA.debugLine="End Sub";
return "";
}
public static String  _btneliminar_click() throws Exception{
RDebugUtils.currentModule="gastos";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btneliminar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btneliminar_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btneliminar = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlpadre = null;
int _idregistro = 0;
pullup.wallet.gastos._indicegasto _indice = null;
int _resultado = 0;
RDebugUtils.currentLine=10092544;
 //BA.debugLineNum = 10092544;BA.debugLine="Sub btnEliminar_Click";
RDebugUtils.currentLine=10092545;
 //BA.debugLineNum = 10092545;BA.debugLine="Dim btnEliminar As Button";
_btneliminar = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=10092546;
 //BA.debugLineNum = 10092546;BA.debugLine="Dim pnlPadre As Panel";
_pnlpadre = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=10092547;
 //BA.debugLineNum = 10092547;BA.debugLine="Dim idRegistro As Int";
_idregistro = 0;
RDebugUtils.currentLine=10092548;
 //BA.debugLineNum = 10092548;BA.debugLine="Dim indice As IndiceGasto";
_indice = new pullup.wallet.gastos._indicegasto();
RDebugUtils.currentLine=10092551;
 //BA.debugLineNum = 10092551;BA.debugLine="btnEliminar = Sender";
_btneliminar = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=10092553;
 //BA.debugLineNum = 10092553;BA.debugLine="pnlPadre = btnEliminar.Parent";
_pnlpadre = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_btneliminar.getParent()));
RDebugUtils.currentLine=10092555;
 //BA.debugLineNum = 10092555;BA.debugLine="indice = pnlPadre.Tag";
_indice = (pullup.wallet.gastos._indicegasto)(_pnlpadre.getTag());
RDebugUtils.currentLine=10092557;
 //BA.debugLineNum = 10092557;BA.debugLine="idRegistro = indice.rowid";
_idregistro = _indice.rowid /*int*/ ;
RDebugUtils.currentLine=10092560;
 //BA.debugLineNum = 10092560;BA.debugLine="Dim resultado As Int";
_resultado = 0;
RDebugUtils.currentLine=10092561;
 //BA.debugLineNum = 10092561;BA.debugLine="resultado = Msgbox2(\"¿Estás seguro?\", \"Eliminar g";
_resultado = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("¿Estás seguro?"),BA.ObjectToCharSequence("Eliminar gasto"),"Sí","","No",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=10092562;
 //BA.debugLineNum = 10092562;BA.debugLine="If (resultado = DialogResponse.POSITIVE) Then";
if ((_resultado==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE)) { 
RDebugUtils.currentLine=10092564;
 //BA.debugLineNum = 10092564;BA.debugLine="cur = sql.ExecQuery2(\"SELECT monto FROM gastos W";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery2("SELECT monto FROM gastos WHERE id_gasto = ?",new String[]{BA.NumberToString(_idregistro)+""})));
RDebugUtils.currentLine=10092565;
 //BA.debugLineNum = 10092565;BA.debugLine="cur.Position = 0";
mostCurrent._cur.setPosition((int) (0));
RDebugUtils.currentLine=10092566;
 //BA.debugLineNum = 10092566;BA.debugLine="montoSeleccionado = cur.GetInt(\"monto\")";
_montoseleccionado = mostCurrent._cur.GetInt("monto");
RDebugUtils.currentLine=10092569;
 //BA.debugLineNum = 10092569;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM egresos WHERE";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM egresos WHERE id_egreso = 1")));
RDebugUtils.currentLine=10092570;
 //BA.debugLineNum = 10092570;BA.debugLine="cur.Position = 0";
mostCurrent._cur.setPosition((int) (0));
RDebugUtils.currentLine=10092571;
 //BA.debugLineNum = 10092571;BA.debugLine="sumaEgresosAntigua = cur.GetInt(\"suma_egresos\")";
_sumaegresosantigua = mostCurrent._cur.GetInt("suma_egresos");
RDebugUtils.currentLine=10092574;
 //BA.debugLineNum = 10092574;BA.debugLine="sumaEgresosActual = sumaEgresosAntigua - montoSe";
_sumaegresosactual = (int) (_sumaegresosantigua-_montoseleccionado);
RDebugUtils.currentLine=10092576;
 //BA.debugLineNum = 10092576;BA.debugLine="sql.ExecNonQuery2(\"UPDATE egresos SET suma_egres";
_sql.ExecNonQuery2("UPDATE egresos SET suma_egresos = ? WHERE id_egreso = 1",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_sumaegresosactual)}));
RDebugUtils.currentLine=10092579;
 //BA.debugLineNum = 10092579;BA.debugLine="sql.ExecNonQuery(\"DELETE FROM gastos WHERE id_ga";
_sql.ExecNonQuery("DELETE FROM gastos WHERE id_gasto = '"+BA.NumberToString(_idregistro)+"'");
RDebugUtils.currentLine=10092583;
 //BA.debugLineNum = 10092583;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=10092584;
 //BA.debugLineNum = 10092584;BA.debugLine="StartActivity(Me)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,gastos.getObject());
 };
RDebugUtils.currentLine=10092586;
 //BA.debugLineNum = 10092586;BA.debugLine="End Sub";
return "";
}
public static String  _btnmenu_click() throws Exception{
RDebugUtils.currentModule="gastos";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnmenu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnmenu_click", null));}
RDebugUtils.currentLine=9830400;
 //BA.debugLineNum = 9830400;BA.debugLine="Private Sub btnMenu_Click";
RDebugUtils.currentLine=9830401;
 //BA.debugLineNum = 9830401;BA.debugLine="CallSubDelayed(Main, \"actualizarDatos\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._main.getObject()),"actualizarDatos");
RDebugUtils.currentLine=9830402;
 //BA.debugLineNum = 9830402;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=9830403;
 //BA.debugLineNum = 9830403;BA.debugLine="End Sub";
return "";
}
public static String  _lblopciones_click() throws Exception{
RDebugUtils.currentModule="gastos";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblopciones_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblopciones_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _lblopcion = null;
pullup.wallet.gastos._indicegasto _indice = null;
int _contador = 0;
RDebugUtils.currentLine=9961472;
 //BA.debugLineNum = 9961472;BA.debugLine="Sub lblOpciones_Click";
RDebugUtils.currentLine=9961473;
 //BA.debugLineNum = 9961473;BA.debugLine="Dim lblOpcion As Label";
_lblopcion = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=9961474;
 //BA.debugLineNum = 9961474;BA.debugLine="Dim indice As IndiceGasto";
_indice = new pullup.wallet.gastos._indicegasto();
RDebugUtils.currentLine=9961476;
 //BA.debugLineNum = 9961476;BA.debugLine="lblOpcion = Sender";
_lblopcion = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=9961477;
 //BA.debugLineNum = 9961477;BA.debugLine="indice = lblOpcion.Tag";
_indice = (pullup.wallet.gastos._indicegasto)(_lblopcion.getTag());
RDebugUtils.currentLine=9961480;
 //BA.debugLineNum = 9961480;BA.debugLine="For contador = 0 To arrayPnlsOpciones.Length - 1";
{
final int step5 = 1;
final int limit5 = (int) (mostCurrent._arraypnlsopciones.length-1);
_contador = (int) (0) ;
for (;_contador <= limit5 ;_contador = _contador + step5 ) {
RDebugUtils.currentLine=9961481;
 //BA.debugLineNum = 9961481;BA.debugLine="If (contador <> indice.indiceElemento) Then";
if ((_contador!=_indice.indiceElemento /*int*/ )) { 
RDebugUtils.currentLine=9961482;
 //BA.debugLineNum = 9961482;BA.debugLine="arrayPnlsOpciones(contador).Visible = False";
mostCurrent._arraypnlsopciones[_contador].setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 }
};
RDebugUtils.currentLine=9961487;
 //BA.debugLineNum = 9961487;BA.debugLine="Relaciones(indice.indiceElemento, 1).SetVisibleAn";
mostCurrent._relaciones[_indice.indiceElemento /*int*/ ][(int) (1)].SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.Not(mostCurrent._relaciones[_indice.indiceElemento /*int*/ ][(int) (1)].getVisible()));
RDebugUtils.currentLine=9961488;
 //BA.debugLineNum = 9961488;BA.debugLine="End Sub";
return "";
}
}