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

public class suscripciones extends Activity implements B4AActivity{
	public static suscripciones mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "pullup.wallet", "pullup.wallet.suscripciones");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (suscripciones).");
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
		activityBA = new BA(this, layout, processBA, "pullup.wallet", "pullup.wallet.suscripciones");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "pullup.wallet.suscripciones", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (suscripciones) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (suscripciones) Resume **");
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
		return suscripciones.class;
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
            BA.LogInfo("** Activity (suscripciones) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (suscripciones) Pause event (activity is not paused). **");
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
            suscripciones mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (suscripciones) Resume **");
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


public static class _indicesuscripcion{
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
public static class _suscripcion{
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
public pullup.wallet.ingresosrecurrentes _ingresosrecurrentes = null;
public pullup.wallet.ingresosunicos _ingresosunicos = null;
public pullup.wallet.metasdeahorro _metasdeahorro = null;
public pullup.wallet.registrargasto _registrargasto = null;
public pullup.wallet.registraringreso _registraringreso = null;
public pullup.wallet.registrarmetaahorro _registrarmetaahorro = null;
public pullup.wallet.registrarsuscripcion _registrarsuscripcion = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="suscripciones";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.LabelWrapper _lblseccion = null;
int _top = 0;
int _id = 0;
pullup.wallet.suscripciones._suscripcion _datossuscripcion = null;
anywheresoftware.b4a.objects.LabelWrapper _lblmensaje = null;
RDebugUtils.currentLine=18087936;
 //BA.debugLineNum = 18087936;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=18087939;
 //BA.debugLineNum = 18087939;BA.debugLine="Activity.LoadLayout(\"LDeslizable\")";
mostCurrent._activity.LoadLayout("LDeslizable",mostCurrent.activityBA);
RDebugUtils.currentLine=18087940;
 //BA.debugLineNum = 18087940;BA.debugLine="Activity.Color = Colors.ARGB(255, 233, 236, 239)";
mostCurrent._activity.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (233),(int) (236),(int) (239)));
RDebugUtils.currentLine=18087941;
 //BA.debugLineNum = 18087941;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
_alturadispositivo = mostCurrent._main._alturadispositivo /*int*/ ;
RDebugUtils.currentLine=18087942;
 //BA.debugLineNum = 18087942;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
_anchodispositivo = mostCurrent._main._anchodispositivo /*int*/ ;
RDebugUtils.currentLine=18087943;
 //BA.debugLineNum = 18087943;BA.debugLine="bmpTest.InitializeMutable(1dip, 1dip)";
mostCurrent._bmptest.InitializeMutable(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)));
RDebugUtils.currentLine=18087944;
 //BA.debugLineNum = 18087944;BA.debugLine="cvsTest.Initialize2(bmpTest)";
mostCurrent._cvstest.Initialize2((android.graphics.Bitmap)(mostCurrent._bmptest.getObject()));
RDebugUtils.currentLine=18087947;
 //BA.debugLineNum = 18087947;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
mostCurrent._pnlnavinferior.setHeight((int) (_alturadispositivo*0.08));
RDebugUtils.currentLine=18087948;
 //BA.debugLineNum = 18087948;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
mostCurrent._pnlnavinferior.setWidth(_anchodispositivo);
RDebugUtils.currentLine=18087949;
 //BA.debugLineNum = 18087949;BA.debugLine="pnlNavInferior.Left = 0";
mostCurrent._pnlnavinferior.setLeft((int) (0));
RDebugUtils.currentLine=18087950;
 //BA.debugLineNum = 18087950;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
mostCurrent._pnlnavinferior.setTop((int) (_alturadispositivo-mostCurrent._pnlnavinferior.getHeight()));
RDebugUtils.currentLine=18087953;
 //BA.debugLineNum = 18087953;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
mostCurrent._btnmenu.setWidth((int) (_anchodispositivo*0.15));
RDebugUtils.currentLine=18087954;
 //BA.debugLineNum = 18087954;BA.debugLine="btnMenu.Height = btnMenu.Width";
mostCurrent._btnmenu.setHeight(mostCurrent._btnmenu.getWidth());
RDebugUtils.currentLine=18087955;
 //BA.debugLineNum = 18087955;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
mostCurrent._btnmenu.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._btnmenu.getHeight()/(double)2));
RDebugUtils.currentLine=18087956;
 //BA.debugLineNum = 18087956;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
mostCurrent._btnmenu.setLeft((int) ((_anchodispositivo-mostCurrent._btnmenu.getWidth())/(double)2));
RDebugUtils.currentLine=18087958;
 //BA.debugLineNum = 18087958;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
mostCurrent._lblcontornoboton.setWidth((int) (_anchodispositivo*0.17));
RDebugUtils.currentLine=18087959;
 //BA.debugLineNum = 18087959;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
mostCurrent._lblcontornoboton.setHeight(mostCurrent._lblcontornoboton.getWidth());
RDebugUtils.currentLine=18087960;
 //BA.debugLineNum = 18087960;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
mostCurrent._lblcontornoboton.setLeft((int) ((_anchodispositivo-mostCurrent._lblcontornoboton.getWidth())/(double)2));
RDebugUtils.currentLine=18087961;
 //BA.debugLineNum = 18087961;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
mostCurrent._lblcontornoboton.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._lblcontornoboton.getHeight()/(double)2));
RDebugUtils.currentLine=18087965;
 //BA.debugLineNum = 18087965;BA.debugLine="svPantalla.Height = pnlNavInferior.Top";
mostCurrent._svpantalla.setHeight(mostCurrent._pnlnavinferior.getTop());
RDebugUtils.currentLine=18087966;
 //BA.debugLineNum = 18087966;BA.debugLine="svPantalla.Panel.LoadLayout(\"LPantallaDeslizable\"";
mostCurrent._svpantalla.getPanel().LoadLayout("LPantallaDeslizable",mostCurrent.activityBA);
RDebugUtils.currentLine=18087967;
 //BA.debugLineNum = 18087967;BA.debugLine="svPantalla.Width = anchoDispositivo * 1.5";
mostCurrent._svpantalla.setWidth((int) (_anchodispositivo*1.5));
RDebugUtils.currentLine=18087968;
 //BA.debugLineNum = 18087968;BA.debugLine="pnlDeslizable.Width = svPantalla.Width";
mostCurrent._pnldeslizable.setWidth(mostCurrent._svpantalla.getWidth());
RDebugUtils.currentLine=18087974;
 //BA.debugLineNum = 18087974;BA.debugLine="Dim lblSeccion As Label";
_lblseccion = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=18087975;
 //BA.debugLineNum = 18087975;BA.debugLine="lblSeccion.Initialize(\"lblSeccion\")";
_lblseccion.Initialize(mostCurrent.activityBA,"lblSeccion");
RDebugUtils.currentLine=18087976;
 //BA.debugLineNum = 18087976;BA.debugLine="lblSeccion.Text = \"Suscripciones\"";
_lblseccion.setText(BA.ObjectToCharSequence("Suscripciones"));
RDebugUtils.currentLine=18087977;
 //BA.debugLineNum = 18087977;BA.debugLine="lblSeccion.TextSize = 20";
_lblseccion.setTextSize((float) (20));
RDebugUtils.currentLine=18087978;
 //BA.debugLineNum = 18087978;BA.debugLine="lblSeccion.TextColor = Colors.Black";
_lblseccion.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=18087979;
 //BA.debugLineNum = 18087979;BA.debugLine="lblSeccion.Height = 30dip";
_lblseccion.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=18087980;
 //BA.debugLineNum = 18087980;BA.debugLine="lblSeccion.Width = anchoDispositivo * 0.9";
_lblseccion.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=18087981;
 //BA.debugLineNum = 18087981;BA.debugLine="lblSeccion.Top = 30dip";
_lblseccion.setTop(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=18087982;
 //BA.debugLineNum = 18087982;BA.debugLine="lblSeccion.Left = (anchoDispositivo - lblSeccion.";
_lblseccion.setLeft((int) ((_anchodispositivo-_lblseccion.getWidth())/(double)2));
RDebugUtils.currentLine=18087983;
 //BA.debugLineNum = 18087983;BA.debugLine="pnlDeslizable.AddView(lblSeccion, lblSeccion.Left";
mostCurrent._pnldeslizable.AddView((android.view.View)(_lblseccion.getObject()),_lblseccion.getLeft(),_lblseccion.getTop(),_lblseccion.getWidth(),_lblseccion.getHeight());
RDebugUtils.currentLine=18087988;
 //BA.debugLineNum = 18087988;BA.debugLine="Dim top As Int";
_top = 0;
RDebugUtils.currentLine=18087989;
 //BA.debugLineNum = 18087989;BA.debugLine="top = lblSeccion.Top + lblSeccion.Height + 30dip";
_top = (int) (_lblseccion.getTop()+_lblseccion.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=18087992;
 //BA.debugLineNum = 18087992;BA.debugLine="sql = Starter.sql";
_sql = mostCurrent._starter._sql /*anywheresoftware.b4a.sql.SQL*/ ;
RDebugUtils.currentLine=18087993;
 //BA.debugLineNum = 18087993;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM suscripciones";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM suscripciones ORDER BY rowid ASC")));
RDebugUtils.currentLine=18087994;
 //BA.debugLineNum = 18087994;BA.debugLine="nRegistros = cur.RowCount";
_nregistros = mostCurrent._cur.getRowCount();
RDebugUtils.currentLine=18087998;
 //BA.debugLineNum = 18087998;BA.debugLine="If nRegistros > 0 Then";
if (_nregistros>0) { 
RDebugUtils.currentLine=18088000;
 //BA.debugLineNum = 18088000;BA.debugLine="Dim Relaciones(nRegistros, 2) As B4XView";
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
RDebugUtils.currentLine=18088001;
 //BA.debugLineNum = 18088001;BA.debugLine="Dim arrayPnlsOpciones(nRegistros) As B4XView";
mostCurrent._arraypnlsopciones = new anywheresoftware.b4a.objects.B4XViewWrapper[_nregistros];
{
int d0 = mostCurrent._arraypnlsopciones.length;
for (int i0 = 0;i0 < d0;i0++) {
mostCurrent._arraypnlsopciones[i0] = new anywheresoftware.b4a.objects.B4XViewWrapper();
}
}
;
RDebugUtils.currentLine=18088003;
 //BA.debugLineNum = 18088003;BA.debugLine="For id = 0 To nRegistros - 1";
{
final int step41 = 1;
final int limit41 = (int) (_nregistros-1);
_id = (int) (0) ;
for (;_id <= limit41 ;_id = _id + step41 ) {
RDebugUtils.currentLine=18088004;
 //BA.debugLineNum = 18088004;BA.debugLine="cur.Position = id";
mostCurrent._cur.setPosition(_id);
RDebugUtils.currentLine=18088006;
 //BA.debugLineNum = 18088006;BA.debugLine="Dim datosSuscripcion As Suscripcion";
_datossuscripcion = new pullup.wallet.suscripciones._suscripcion();
RDebugUtils.currentLine=18088007;
 //BA.debugLineNum = 18088007;BA.debugLine="datosSuscripcion.rowid = cur.GetInt(\"id_suscrip";
_datossuscripcion.rowid /*int*/  = mostCurrent._cur.GetInt("id_suscripcion");
RDebugUtils.currentLine=18088008;
 //BA.debugLineNum = 18088008;BA.debugLine="datosSuscripcion.nombre = cur.GetString(\"nombre";
_datossuscripcion.nombre /*String*/  = mostCurrent._cur.GetString("nombre");
RDebugUtils.currentLine=18088009;
 //BA.debugLineNum = 18088009;BA.debugLine="datosSuscripcion.monto = cur.GetInt(\"monto\")";
_datossuscripcion.monto /*int*/  = mostCurrent._cur.GetInt("monto");
RDebugUtils.currentLine=18088010;
 //BA.debugLineNum = 18088010;BA.debugLine="datosSuscripcion.descripcion = cur.GetString(\"d";
_datossuscripcion.descripcion /*String*/  = mostCurrent._cur.GetString("descripcion");
RDebugUtils.currentLine=18088011;
 //BA.debugLineNum = 18088011;BA.debugLine="datosSuscripcion.periodo = cur.GetString(\"perio";
_datossuscripcion.periodo /*String*/  = mostCurrent._cur.GetString("periodo");
RDebugUtils.currentLine=18088012;
 //BA.debugLineNum = 18088012;BA.debugLine="datosSuscripcion.color = cur.GetInt(\"color\")";
_datossuscripcion.color /*int*/  = mostCurrent._cur.GetInt("color");
RDebugUtils.currentLine=18088014;
 //BA.debugLineNum = 18088014;BA.debugLine="creaObjetoLista(id, top, datosSuscripcion)";
_creaobjetolista(_id,_top,_datossuscripcion);
RDebugUtils.currentLine=18088016;
 //BA.debugLineNum = 18088016;BA.debugLine="top = top + alturaDispositivo * 0.12 + 60";
_top = (int) (_top+_alturadispositivo*0.12+60);
 }
};
 }else {
RDebugUtils.currentLine=18088020;
 //BA.debugLineNum = 18088020;BA.debugLine="Dim lblMensaje As Label";
_lblmensaje = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=18088021;
 //BA.debugLineNum = 18088021;BA.debugLine="lblMensaje.Initialize(\"lblMensaje\")";
_lblmensaje.Initialize(mostCurrent.activityBA,"lblMensaje");
RDebugUtils.currentLine=18088022;
 //BA.debugLineNum = 18088022;BA.debugLine="lblMensaje.Height = alturaDispositivo * 0.2";
_lblmensaje.setHeight((int) (_alturadispositivo*0.2));
RDebugUtils.currentLine=18088023;
 //BA.debugLineNum = 18088023;BA.debugLine="lblMensaje.Width = anchoDispositivo * 0.9";
_lblmensaje.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=18088024;
 //BA.debugLineNum = 18088024;BA.debugLine="lblMensaje.Top = (alturaDispositivo - lblMensaje";
_lblmensaje.setTop((int) ((_alturadispositivo-_lblmensaje.getHeight())/(double)2));
RDebugUtils.currentLine=18088025;
 //BA.debugLineNum = 18088025;BA.debugLine="lblMensaje.Left = (anchoDispositivo - lblMensaje";
_lblmensaje.setLeft((int) ((_anchodispositivo-_lblmensaje.getWidth())/(double)2));
RDebugUtils.currentLine=18088026;
 //BA.debugLineNum = 18088026;BA.debugLine="lblMensaje.Text = cs.Initialize.Color(Colors.Bla";
_lblmensaje.setText(BA.ObjectToCharSequence(mostCurrent._cs.Initialize().Color(anywheresoftware.b4a.keywords.Common.Colors.Black).Alignment(BA.getEnumFromString(android.text.Layout.Alignment.class,"ALIGN_CENTER")).Typeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS()).Size((int) (50)).Append(BA.ObjectToCharSequence(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (0xe89c)))+anywheresoftware.b4a.keywords.Common.CRLF)).Typeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT).Size((int) (18)).Append(BA.ObjectToCharSequence("Está muy vacío aquí adentro."+anywheresoftware.b4a.keywords.Common.CRLF)).Append(BA.ObjectToCharSequence("Agrega una suscripción desde el menú principal.")).PopAll().getObject()));
RDebugUtils.currentLine=18088027;
 //BA.debugLineNum = 18088027;BA.debugLine="Activity.AddView(lblMensaje, lblMensaje.Left, lb";
mostCurrent._activity.AddView((android.view.View)(_lblmensaje.getObject()),_lblmensaje.getLeft(),_lblmensaje.getTop(),_lblmensaje.getWidth(),_lblmensaje.getHeight());
 };
RDebugUtils.currentLine=18088030;
 //BA.debugLineNum = 18088030;BA.debugLine="svPantalla.Panel.Height = top + 100";
mostCurrent._svpantalla.getPanel().setHeight((int) (_top+100));
RDebugUtils.currentLine=18088031;
 //BA.debugLineNum = 18088031;BA.debugLine="End Sub";
return "";
}
public static String  _creaobjetolista(int _indice,int _top,pullup.wallet.suscripciones._suscripcion _datos) throws Exception{
RDebugUtils.currentModule="suscripciones";
if (Debug.shouldDelegate(mostCurrent.activityBA, "creaobjetolista", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "creaobjetolista", new Object[] {_indice,_top,_datos}));}
anywheresoftware.b4a.objects.PanelWrapper _pnlsuscripcion = null;
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
pullup.wallet.suscripciones._indicesuscripcion _referencia = null;
pullup.wallet.suscripciones._indicesuscripcion _referencia2 = null;
RDebugUtils.currentLine=18350080;
 //BA.debugLineNum = 18350080;BA.debugLine="Sub creaObjetoLista(indice As Int, top As Int, dat";
RDebugUtils.currentLine=18350081;
 //BA.debugLineNum = 18350081;BA.debugLine="Dim pnlSuscripcion As Panel";
_pnlsuscripcion = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=18350082;
 //BA.debugLineNum = 18350082;BA.debugLine="Dim pnlOpciones As Panel";
_pnlopciones = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=18350083;
 //BA.debugLineNum = 18350083;BA.debugLine="Dim lblNombre As Label";
_lblnombre = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=18350084;
 //BA.debugLineNum = 18350084;BA.debugLine="Dim lblMonto As Label";
_lblmonto = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=18350085;
 //BA.debugLineNum = 18350085;BA.debugLine="Dim lblDescripcion As Label";
_lbldescripcion = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=18350086;
 //BA.debugLineNum = 18350086;BA.debugLine="Dim lblPeriodo As Label";
_lblperiodo = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=18350087;
 //BA.debugLineNum = 18350087;BA.debugLine="Dim lblOpciones As Label";
_lblopciones = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=18350088;
 //BA.debugLineNum = 18350088;BA.debugLine="Dim btnEditar As Button";
_btneditar = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=18350089;
 //BA.debugLineNum = 18350089;BA.debugLine="Dim btnEliminar As Button";
_btneliminar = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=18350092;
 //BA.debugLineNum = 18350092;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=18350093;
 //BA.debugLineNum = 18350093;BA.debugLine="cd.Initialize(datos.color, 20)";
_cd.Initialize(_datos.color /*int*/ ,(int) (20));
RDebugUtils.currentLine=18350096;
 //BA.debugLineNum = 18350096;BA.debugLine="pnlSuscripcion.Initialize(\"pnlSuscripcion\")";
_pnlsuscripcion.Initialize(mostCurrent.activityBA,"pnlSuscripcion");
RDebugUtils.currentLine=18350097;
 //BA.debugLineNum = 18350097;BA.debugLine="pnlSuscripcion.Top = top";
_pnlsuscripcion.setTop(_top);
RDebugUtils.currentLine=18350098;
 //BA.debugLineNum = 18350098;BA.debugLine="pnlSuscripcion.Background = cd";
_pnlsuscripcion.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=18350099;
 //BA.debugLineNum = 18350099;BA.debugLine="pnlSuscripcion.Width = anchoDispositivo * 0.9";
_pnlsuscripcion.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=18350100;
 //BA.debugLineNum = 18350100;BA.debugLine="pnlSuscripcion.Height = alturaDispositivo * 0.14";
_pnlsuscripcion.setHeight((int) (_alturadispositivo*0.14));
RDebugUtils.currentLine=18350101;
 //BA.debugLineNum = 18350101;BA.debugLine="pnlSuscripcion.Left = (anchoDispositivo - pnlSusc";
_pnlsuscripcion.setLeft((int) ((_anchodispositivo-_pnlsuscripcion.getWidth())/(double)2));
RDebugUtils.currentLine=18350103;
 //BA.debugLineNum = 18350103;BA.debugLine="lblNombre.Initialize(\"lblNombre\")";
_lblnombre.Initialize(mostCurrent.activityBA,"lblNombre");
RDebugUtils.currentLine=18350104;
 //BA.debugLineNum = 18350104;BA.debugLine="lblNombre.TextColor = Colors.White";
_lblnombre.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=18350105;
 //BA.debugLineNum = 18350105;BA.debugLine="lblNombre.Text = datos.nombre.ToUpperCase.CharAt(";
_lblnombre.setText(BA.ObjectToCharSequence(BA.ObjectToString(_datos.nombre /*String*/ .toUpperCase().charAt((int) (0)))+_datos.nombre /*String*/ .substring((int) (1)).toLowerCase()));
RDebugUtils.currentLine=18350106;
 //BA.debugLineNum = 18350106;BA.debugLine="lblNombre.TextSize = 19";
_lblnombre.setTextSize((float) (19));
RDebugUtils.currentLine=18350107;
 //BA.debugLineNum = 18350107;BA.debugLine="lblNombre.Height = pnlSuscripcion.Height * 0.3";
_lblnombre.setHeight((int) (_pnlsuscripcion.getHeight()*0.3));
RDebugUtils.currentLine=18350108;
 //BA.debugLineNum = 18350108;BA.debugLine="lblNombre.Width = pnlSuscripcion.Width * 0.9";
_lblnombre.setWidth((int) (_pnlsuscripcion.getWidth()*0.9));
RDebugUtils.currentLine=18350109;
 //BA.debugLineNum = 18350109;BA.debugLine="lblNombre.Top = 0";
_lblnombre.setTop((int) (0));
RDebugUtils.currentLine=18350110;
 //BA.debugLineNum = 18350110;BA.debugLine="lblNombre.Left = pnlSuscripcion.Width * 0.05";
_lblnombre.setLeft((int) (_pnlsuscripcion.getWidth()*0.05));
RDebugUtils.currentLine=18350111;
 //BA.debugLineNum = 18350111;BA.debugLine="lblNombre.Gravity = Gravity.CENTER_VERTICAL";
_lblnombre.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=18350112;
 //BA.debugLineNum = 18350112;BA.debugLine="pnlSuscripcion.AddView(lblNombre, lblNombre.Left,";
_pnlsuscripcion.AddView((android.view.View)(_lblnombre.getObject()),_lblnombre.getLeft(),_lblnombre.getTop(),_lblnombre.getWidth(),_lblnombre.getHeight());
RDebugUtils.currentLine=18350114;
 //BA.debugLineNum = 18350114;BA.debugLine="lblDescripcion.Initialize(\"lblDescripcion\")";
_lbldescripcion.Initialize(mostCurrent.activityBA,"lblDescripcion");
RDebugUtils.currentLine=18350115;
 //BA.debugLineNum = 18350115;BA.debugLine="lblDescripcion.Text = datos.descripcion.ToUpperCa";
_lbldescripcion.setText(BA.ObjectToCharSequence(BA.ObjectToString(_datos.descripcion /*String*/ .toUpperCase().charAt((int) (0)))+_datos.descripcion /*String*/ .substring((int) (1)).toLowerCase()));
RDebugUtils.currentLine=18350116;
 //BA.debugLineNum = 18350116;BA.debugLine="lblDescripcion.TextColor = Colors.White";
_lbldescripcion.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=18350117;
 //BA.debugLineNum = 18350117;BA.debugLine="lblDescripcion.Height = pnlSuscripcion.Height * 0";
_lbldescripcion.setHeight((int) (_pnlsuscripcion.getHeight()*0.3));
RDebugUtils.currentLine=18350118;
 //BA.debugLineNum = 18350118;BA.debugLine="lblDescripcion.Width = pnlSuscripcion.Width * 0.9";
_lbldescripcion.setWidth((int) (_pnlsuscripcion.getWidth()*0.9));
RDebugUtils.currentLine=18350119;
 //BA.debugLineNum = 18350119;BA.debugLine="lblDescripcion.Top = lblNombre.Height";
_lbldescripcion.setTop(_lblnombre.getHeight());
RDebugUtils.currentLine=18350120;
 //BA.debugLineNum = 18350120;BA.debugLine="lblDescripcion.Left = lblNombre.Left";
_lbldescripcion.setLeft(_lblnombre.getLeft());
RDebugUtils.currentLine=18350121;
 //BA.debugLineNum = 18350121;BA.debugLine="lblDescripcion.Gravity = Gravity.CENTER_VERTICAL";
_lbldescripcion.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=18350122;
 //BA.debugLineNum = 18350122;BA.debugLine="pnlSuscripcion.AddView(lblDescripcion, lblDescrip";
_pnlsuscripcion.AddView((android.view.View)(_lbldescripcion.getObject()),_lbldescripcion.getLeft(),_lbldescripcion.getTop(),_lbldescripcion.getWidth(),_lbldescripcion.getHeight());
RDebugUtils.currentLine=18350124;
 //BA.debugLineNum = 18350124;BA.debugLine="lblPeriodo.Initialize(\"lblPeriodo\")";
_lblperiodo.Initialize(mostCurrent.activityBA,"lblPeriodo");
RDebugUtils.currentLine=18350126;
 //BA.debugLineNum = 18350126;BA.debugLine="Dim textoPeriodo As String";
_textoperiodo = "";
RDebugUtils.currentLine=18350127;
 //BA.debugLineNum = 18350127;BA.debugLine="If (datos.periodo = 7) Then";
if (((_datos.periodo /*String*/ ).equals(BA.NumberToString(7)))) { 
RDebugUtils.currentLine=18350128;
 //BA.debugLineNum = 18350128;BA.debugLine="textoPeriodo = \"1 semana\"";
_textoperiodo = "1 semana";
 }else 
{RDebugUtils.currentLine=18350129;
 //BA.debugLineNum = 18350129;BA.debugLine="Else If (datos.periodo = 14) Then";
if (((_datos.periodo /*String*/ ).equals(BA.NumberToString(14)))) { 
RDebugUtils.currentLine=18350130;
 //BA.debugLineNum = 18350130;BA.debugLine="textoPeriodo = \"2 semanas\"";
_textoperiodo = "2 semanas";
 }else 
{RDebugUtils.currentLine=18350131;
 //BA.debugLineNum = 18350131;BA.debugLine="Else If (datos.periodo = 21) Then";
if (((_datos.periodo /*String*/ ).equals(BA.NumberToString(21)))) { 
RDebugUtils.currentLine=18350132;
 //BA.debugLineNum = 18350132;BA.debugLine="textoPeriodo = \"3 semanas\"";
_textoperiodo = "3 semanas";
 }else 
{RDebugUtils.currentLine=18350133;
 //BA.debugLineNum = 18350133;BA.debugLine="Else If (datos.periodo = 30) Then";
if (((_datos.periodo /*String*/ ).equals(BA.NumberToString(30)))) { 
RDebugUtils.currentLine=18350134;
 //BA.debugLineNum = 18350134;BA.debugLine="textoPeriodo = \"1 mes\"";
_textoperiodo = "1 mes";
 }else 
{RDebugUtils.currentLine=18350135;
 //BA.debugLineNum = 18350135;BA.debugLine="Else If (datos.periodo = 365) Then";
if (((_datos.periodo /*String*/ ).equals(BA.NumberToString(365)))) { 
RDebugUtils.currentLine=18350136;
 //BA.debugLineNum = 18350136;BA.debugLine="textoPeriodo = \"1 año\"";
_textoperiodo = "1 año";
 }}}}}
;
RDebugUtils.currentLine=18350139;
 //BA.debugLineNum = 18350139;BA.debugLine="lblPeriodo.Text = textoPeriodo";
_lblperiodo.setText(BA.ObjectToCharSequence(_textoperiodo));
RDebugUtils.currentLine=18350140;
 //BA.debugLineNum = 18350140;BA.debugLine="lblPeriodo.TextSize = 16";
_lblperiodo.setTextSize((float) (16));
RDebugUtils.currentLine=18350141;
 //BA.debugLineNum = 18350141;BA.debugLine="lblPeriodo.TextColor = Colors.DarkGray";
_lblperiodo.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.DarkGray);
RDebugUtils.currentLine=18350142;
 //BA.debugLineNum = 18350142;BA.debugLine="lblPeriodo.Height = pnlSuscripcion.Height * 0.4";
_lblperiodo.setHeight((int) (_pnlsuscripcion.getHeight()*0.4));
RDebugUtils.currentLine=18350143;
 //BA.debugLineNum = 18350143;BA.debugLine="lblPeriodo.Width = pnlSuscripcion.Width * 0.9";
_lblperiodo.setWidth((int) (_pnlsuscripcion.getWidth()*0.9));
RDebugUtils.currentLine=18350144;
 //BA.debugLineNum = 18350144;BA.debugLine="lblPeriodo.Top = lblDescripcion.Top + lblDescripc";
_lblperiodo.setTop((int) (_lbldescripcion.getTop()+_lbldescripcion.getHeight()));
RDebugUtils.currentLine=18350145;
 //BA.debugLineNum = 18350145;BA.debugLine="lblPeriodo.Left = lblNombre.Left";
_lblperiodo.setLeft(_lblnombre.getLeft());
RDebugUtils.currentLine=18350146;
 //BA.debugLineNum = 18350146;BA.debugLine="lblPeriodo.Gravity = Gravity.CENTER_VERTICAL";
_lblperiodo.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=18350147;
 //BA.debugLineNum = 18350147;BA.debugLine="pnlSuscripcion.AddView(lblPeriodo, lblPeriodo.Lef";
_pnlsuscripcion.AddView((android.view.View)(_lblperiodo.getObject()),_lblperiodo.getLeft(),_lblperiodo.getTop(),_lblperiodo.getWidth(),_lblperiodo.getHeight());
RDebugUtils.currentLine=18350149;
 //BA.debugLineNum = 18350149;BA.debugLine="lblMonto.Initialize(\"lblMonto\")";
_lblmonto.Initialize(mostCurrent.activityBA,"lblMonto");
RDebugUtils.currentLine=18350150;
 //BA.debugLineNum = 18350150;BA.debugLine="lblMonto.TextSize = 16";
_lblmonto.setTextSize((float) (16));
RDebugUtils.currentLine=18350151;
 //BA.debugLineNum = 18350151;BA.debugLine="lblMonto.TextColor = Colors.White";
_lblmonto.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=18350152;
 //BA.debugLineNum = 18350152;BA.debugLine="lblMonto.Width = cvsTest.MeasureStringWidth((\"$\"";
_lblmonto.setWidth((int) (mostCurrent._cvstest.MeasureStringWidth(("$"+BA.NumberToString(_datos.monto /*int*/ )),anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT,_lblmonto.getTextSize())+2));
RDebugUtils.currentLine=18350153;
 //BA.debugLineNum = 18350153;BA.debugLine="lblMonto.Height = pnlSuscripcion.Height * 0.4";
_lblmonto.setHeight((int) (_pnlsuscripcion.getHeight()*0.4));
RDebugUtils.currentLine=18350154;
 //BA.debugLineNum = 18350154;BA.debugLine="lblMonto.Text = \"$\" & datos.monto";
_lblmonto.setText(BA.ObjectToCharSequence("$"+BA.NumberToString(_datos.monto /*int*/ )));
RDebugUtils.currentLine=18350155;
 //BA.debugLineNum = 18350155;BA.debugLine="lblMonto.Top = lblPeriodo.Top";
_lblmonto.setTop(_lblperiodo.getTop());
RDebugUtils.currentLine=18350156;
 //BA.debugLineNum = 18350156;BA.debugLine="lblMonto.Left = pnlSuscripcion.Width - lblMonto.W";
_lblmonto.setLeft((int) (_pnlsuscripcion.getWidth()-_lblmonto.getWidth()-_lblnombre.getLeft()));
RDebugUtils.currentLine=18350157;
 //BA.debugLineNum = 18350157;BA.debugLine="lblMonto.Gravity = Gravity.CENTER_VERTICAL";
_lblmonto.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=18350158;
 //BA.debugLineNum = 18350158;BA.debugLine="pnlSuscripcion.AddView(lblMonto, lblMonto.Left, l";
_pnlsuscripcion.AddView((android.view.View)(_lblmonto.getObject()),_lblmonto.getLeft(),_lblmonto.getTop(),_lblmonto.getWidth(),_lblmonto.getHeight());
RDebugUtils.currentLine=18350160;
 //BA.debugLineNum = 18350160;BA.debugLine="lblOpciones.Initialize(\"lblOpciones\")";
_lblopciones.Initialize(mostCurrent.activityBA,"lblOpciones");
RDebugUtils.currentLine=18350161;
 //BA.debugLineNum = 18350161;BA.debugLine="lblOpciones.Typeface = Typeface.FONTAWESOME";
_lblopciones.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getFONTAWESOME());
RDebugUtils.currentLine=18350162;
 //BA.debugLineNum = 18350162;BA.debugLine="lblOpciones.Text = Chr(0xF142)";
_lblopciones.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf142))));
RDebugUtils.currentLine=18350163;
 //BA.debugLineNum = 18350163;BA.debugLine="lblOpciones.TextSize = 18";
_lblopciones.setTextSize((float) (18));
RDebugUtils.currentLine=18350164;
 //BA.debugLineNum = 18350164;BA.debugLine="lblOpciones.TextColor = Colors.White";
_lblopciones.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=18350165;
 //BA.debugLineNum = 18350165;BA.debugLine="lblOpciones.Height = lblNombre.Height";
_lblopciones.setHeight(_lblnombre.getHeight());
RDebugUtils.currentLine=18350166;
 //BA.debugLineNum = 18350166;BA.debugLine="lblOpciones.Width = 8dip";
_lblopciones.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (8)));
RDebugUtils.currentLine=18350167;
 //BA.debugLineNum = 18350167;BA.debugLine="lblOpciones.Left = lblMonto.Left + lblMonto.Width";
_lblopciones.setLeft((int) (_lblmonto.getLeft()+_lblmonto.getWidth()-_lblopciones.getWidth()));
RDebugUtils.currentLine=18350168;
 //BA.debugLineNum = 18350168;BA.debugLine="lblOpciones.Top = 0";
_lblopciones.setTop((int) (0));
RDebugUtils.currentLine=18350169;
 //BA.debugLineNum = 18350169;BA.debugLine="lblOpciones.Gravity = Gravity.CENTER_VERTICAL";
_lblopciones.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=18350170;
 //BA.debugLineNum = 18350170;BA.debugLine="pnlSuscripcion.AddView(lblOpciones, lblOpciones.L";
_pnlsuscripcion.AddView((android.view.View)(_lblopciones.getObject()),_lblopciones.getLeft(),_lblopciones.getTop(),_lblopciones.getWidth(),_lblopciones.getHeight());
RDebugUtils.currentLine=18350172;
 //BA.debugLineNum = 18350172;BA.debugLine="pnlOpciones.Initialize(\"pnlOpciones\")";
_pnlopciones.Initialize(mostCurrent.activityBA,"pnlOpciones");
RDebugUtils.currentLine=18350173;
 //BA.debugLineNum = 18350173;BA.debugLine="cd.Initialize(Colors.Black, 20)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.Black,(int) (20));
RDebugUtils.currentLine=18350174;
 //BA.debugLineNum = 18350174;BA.debugLine="pnlOpciones.Background = cd";
_pnlopciones.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=18350175;
 //BA.debugLineNum = 18350175;BA.debugLine="pnlOpciones.Height = pnlSuscripcion.Height * 0.8";
_pnlopciones.setHeight((int) (_pnlsuscripcion.getHeight()*0.8));
RDebugUtils.currentLine=18350176;
 //BA.debugLineNum = 18350176;BA.debugLine="pnlOpciones.Width = pnlSuscripcion.Height";
_pnlopciones.setWidth(_pnlsuscripcion.getHeight());
RDebugUtils.currentLine=18350177;
 //BA.debugLineNum = 18350177;BA.debugLine="pnlOpciones.Top = lblOpciones.Top";
_pnlopciones.setTop(_lblopciones.getTop());
RDebugUtils.currentLine=18350178;
 //BA.debugLineNum = 18350178;BA.debugLine="pnlOpciones.Left = lblOpciones.Left - lblOpciones";
_pnlopciones.setLeft((int) (_lblopciones.getLeft()-_lblopciones.getWidth()*2-_pnlopciones.getWidth()));
RDebugUtils.currentLine=18350179;
 //BA.debugLineNum = 18350179;BA.debugLine="pnlOpciones.Visible = False";
_pnlopciones.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=18350180;
 //BA.debugLineNum = 18350180;BA.debugLine="pnlSuscripcion.AddView(pnlOpciones, pnlOpciones.L";
_pnlsuscripcion.AddView((android.view.View)(_pnlopciones.getObject()),_pnlopciones.getLeft(),_pnlopciones.getTop(),_pnlopciones.getWidth(),_pnlopciones.getHeight());
RDebugUtils.currentLine=18350182;
 //BA.debugLineNum = 18350182;BA.debugLine="btnEditar.Initialize(\"btnEditar\")";
_btneditar.Initialize(mostCurrent.activityBA,"btnEditar");
RDebugUtils.currentLine=18350183;
 //BA.debugLineNum = 18350183;BA.debugLine="btnEditar.Color = Colors.Transparent";
_btneditar.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=18350184;
 //BA.debugLineNum = 18350184;BA.debugLine="btnEditar.Text = \"Editar\"";
_btneditar.setText(BA.ObjectToCharSequence("Editar"));
RDebugUtils.currentLine=18350185;
 //BA.debugLineNum = 18350185;BA.debugLine="btnEditar.TextColor = Colors.White";
_btneditar.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=18350186;
 //BA.debugLineNum = 18350186;BA.debugLine="btnEditar.TextSize = 14";
_btneditar.setTextSize((float) (14));
RDebugUtils.currentLine=18350187;
 //BA.debugLineNum = 18350187;BA.debugLine="btnEditar.Height = pnlOpciones.Height * 0.4";
_btneditar.setHeight((int) (_pnlopciones.getHeight()*0.4));
RDebugUtils.currentLine=18350188;
 //BA.debugLineNum = 18350188;BA.debugLine="btnEditar.Width = pnlOpciones.Height * 0.8";
_btneditar.setWidth((int) (_pnlopciones.getHeight()*0.8));
RDebugUtils.currentLine=18350189;
 //BA.debugLineNum = 18350189;BA.debugLine="btnEditar.Top = (pnlOpciones.Height * 0.2) / 3";
_btneditar.setTop((int) ((_pnlopciones.getHeight()*0.2)/(double)3));
RDebugUtils.currentLine=18350190;
 //BA.debugLineNum = 18350190;BA.debugLine="btnEditar.Left = (pnlOpciones.Width - btnEditar.W";
_btneditar.setLeft((int) ((_pnlopciones.getWidth()-_btneditar.getWidth())/(double)2));
RDebugUtils.currentLine=18350191;
 //BA.debugLineNum = 18350191;BA.debugLine="pnlOpciones.AddView(btnEditar, btnEditar.Left, bt";
_pnlopciones.AddView((android.view.View)(_btneditar.getObject()),_btneditar.getLeft(),_btneditar.getTop(),_btneditar.getWidth(),_btneditar.getHeight());
RDebugUtils.currentLine=18350193;
 //BA.debugLineNum = 18350193;BA.debugLine="btnEliminar.Initialize(\"btnEliminar\")";
_btneliminar.Initialize(mostCurrent.activityBA,"btnEliminar");
RDebugUtils.currentLine=18350194;
 //BA.debugLineNum = 18350194;BA.debugLine="btnEliminar.Color = Colors.Transparent";
_btneliminar.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=18350195;
 //BA.debugLineNum = 18350195;BA.debugLine="btnEliminar.Text = \"Eliminar\"";
_btneliminar.setText(BA.ObjectToCharSequence("Eliminar"));
RDebugUtils.currentLine=18350196;
 //BA.debugLineNum = 18350196;BA.debugLine="btnEliminar.TextColor = Colors.White";
_btneliminar.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=18350197;
 //BA.debugLineNum = 18350197;BA.debugLine="btnEliminar.TextSize = 14";
_btneliminar.setTextSize((float) (14));
RDebugUtils.currentLine=18350198;
 //BA.debugLineNum = 18350198;BA.debugLine="btnEliminar.Height = btnEditar.Height";
_btneliminar.setHeight(_btneditar.getHeight());
RDebugUtils.currentLine=18350199;
 //BA.debugLineNum = 18350199;BA.debugLine="btnEliminar.Width = pnlOpciones.Width * 0.9";
_btneliminar.setWidth((int) (_pnlopciones.getWidth()*0.9));
RDebugUtils.currentLine=18350200;
 //BA.debugLineNum = 18350200;BA.debugLine="btnEliminar.Top = btnEditar.Top * 2 + btnEditar.H";
_btneliminar.setTop((int) (_btneditar.getTop()*2+_btneditar.getHeight()));
RDebugUtils.currentLine=18350201;
 //BA.debugLineNum = 18350201;BA.debugLine="btnEliminar.Left = (pnlOpciones.Width - btnElimin";
_btneliminar.setLeft((int) ((_pnlopciones.getWidth()-_btneliminar.getWidth())/(double)2));
RDebugUtils.currentLine=18350202;
 //BA.debugLineNum = 18350202;BA.debugLine="pnlOpciones.AddView(btnEliminar, btnEliminar.Left";
_pnlopciones.AddView((android.view.View)(_btneliminar.getObject()),_btneliminar.getLeft(),_btneliminar.getTop(),_btneliminar.getWidth(),_btneliminar.getHeight());
RDebugUtils.currentLine=18350204;
 //BA.debugLineNum = 18350204;BA.debugLine="pnlDeslizable.AddView(pnlSuscripcion, pnlSuscripc";
mostCurrent._pnldeslizable.AddView((android.view.View)(_pnlsuscripcion.getObject()),_pnlsuscripcion.getLeft(),_top,_pnlsuscripcion.getWidth(),_pnlsuscripcion.getHeight());
RDebugUtils.currentLine=18350207;
 //BA.debugLineNum = 18350207;BA.debugLine="Dim referencia As IndiceSuscripcion";
_referencia = new pullup.wallet.suscripciones._indicesuscripcion();
RDebugUtils.currentLine=18350208;
 //BA.debugLineNum = 18350208;BA.debugLine="referencia.indiceElemento = indice";
_referencia.indiceElemento /*int*/  = _indice;
RDebugUtils.currentLine=18350209;
 //BA.debugLineNum = 18350209;BA.debugLine="referencia.rowid = 0";
_referencia.rowid /*int*/  = (int) (0);
RDebugUtils.currentLine=18350211;
 //BA.debugLineNum = 18350211;BA.debugLine="lblOpciones.Tag = referencia";
_lblopciones.setTag((Object)(_referencia));
RDebugUtils.currentLine=18350214;
 //BA.debugLineNum = 18350214;BA.debugLine="Dim referencia2 As IndiceSuscripcion";
_referencia2 = new pullup.wallet.suscripciones._indicesuscripcion();
RDebugUtils.currentLine=18350215;
 //BA.debugLineNum = 18350215;BA.debugLine="referencia2.indiceElemento = 0";
_referencia2.indiceElemento /*int*/  = (int) (0);
RDebugUtils.currentLine=18350216;
 //BA.debugLineNum = 18350216;BA.debugLine="referencia2.rowid = datos.rowid";
_referencia2.rowid /*int*/  = _datos.rowid /*int*/ ;
RDebugUtils.currentLine=18350218;
 //BA.debugLineNum = 18350218;BA.debugLine="pnlOpciones.Tag = referencia2";
_pnlopciones.setTag((Object)(_referencia2));
RDebugUtils.currentLine=18350221;
 //BA.debugLineNum = 18350221;BA.debugLine="Relaciones(indice, 0) = lblOpciones";
mostCurrent._relaciones[_indice][(int) (0)] = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lblopciones.getObject()));
RDebugUtils.currentLine=18350222;
 //BA.debugLineNum = 18350222;BA.debugLine="Relaciones(indice, 1) = pnlOpciones";
mostCurrent._relaciones[_indice][(int) (1)] = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnlopciones.getObject()));
RDebugUtils.currentLine=18350225;
 //BA.debugLineNum = 18350225;BA.debugLine="arrayPnlsOpciones(indice) = pnlOpciones";
mostCurrent._arraypnlsopciones[_indice] = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnlopciones.getObject()));
RDebugUtils.currentLine=18350226;
 //BA.debugLineNum = 18350226;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="suscripciones";
RDebugUtils.currentLine=18219008;
 //BA.debugLineNum = 18219008;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=18219010;
 //BA.debugLineNum = 18219010;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="suscripciones";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=18153472;
 //BA.debugLineNum = 18153472;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=18153474;
 //BA.debugLineNum = 18153474;BA.debugLine="End Sub";
return "";
}
public static String  _btneditar_click() throws Exception{
RDebugUtils.currentModule="suscripciones";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btneditar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btneditar_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btneditar = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlpadre = null;
int _idregistro = 0;
pullup.wallet.suscripciones._indicesuscripcion _indice = null;
RDebugUtils.currentLine=18481152;
 //BA.debugLineNum = 18481152;BA.debugLine="Sub btnEditar_Click";
RDebugUtils.currentLine=18481153;
 //BA.debugLineNum = 18481153;BA.debugLine="Dim btnEditar As Button";
_btneditar = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=18481154;
 //BA.debugLineNum = 18481154;BA.debugLine="Dim pnlPadre As Panel";
_pnlpadre = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=18481155;
 //BA.debugLineNum = 18481155;BA.debugLine="Dim idRegistro As Int";
_idregistro = 0;
RDebugUtils.currentLine=18481156;
 //BA.debugLineNum = 18481156;BA.debugLine="Dim indice As IndiceSuscripcion";
_indice = new pullup.wallet.suscripciones._indicesuscripcion();
RDebugUtils.currentLine=18481159;
 //BA.debugLineNum = 18481159;BA.debugLine="btnEditar = Sender";
_btneditar = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=18481161;
 //BA.debugLineNum = 18481161;BA.debugLine="pnlPadre = btnEditar.Parent";
_pnlpadre = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_btneditar.getParent()));
RDebugUtils.currentLine=18481163;
 //BA.debugLineNum = 18481163;BA.debugLine="indice = pnlPadre.Tag";
_indice = (pullup.wallet.suscripciones._indicesuscripcion)(_pnlpadre.getTag());
RDebugUtils.currentLine=18481165;
 //BA.debugLineNum = 18481165;BA.debugLine="idRegistro = indice.rowid";
_idregistro = _indice.rowid /*int*/ ;
RDebugUtils.currentLine=18481166;
 //BA.debugLineNum = 18481166;BA.debugLine="CallSubDelayed2(editarSuscripcion, \"consultaAEdit";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._editarsuscripcion.getObject()),"consultaAEditar",(Object)(_idregistro));
RDebugUtils.currentLine=18481167;
 //BA.debugLineNum = 18481167;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=18481168;
 //BA.debugLineNum = 18481168;BA.debugLine="End Sub";
return "";
}
public static String  _btneliminar_click() throws Exception{
RDebugUtils.currentModule="suscripciones";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btneliminar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btneliminar_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btneliminar = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlpadre = null;
int _idregistro = 0;
pullup.wallet.suscripciones._indicesuscripcion _indice = null;
int _resultado = 0;
RDebugUtils.currentLine=18546688;
 //BA.debugLineNum = 18546688;BA.debugLine="Sub btnEliminar_Click";
RDebugUtils.currentLine=18546689;
 //BA.debugLineNum = 18546689;BA.debugLine="Dim btnEliminar As Button";
_btneliminar = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=18546690;
 //BA.debugLineNum = 18546690;BA.debugLine="Dim pnlPadre As Panel";
_pnlpadre = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=18546691;
 //BA.debugLineNum = 18546691;BA.debugLine="Dim idRegistro As Int";
_idregistro = 0;
RDebugUtils.currentLine=18546692;
 //BA.debugLineNum = 18546692;BA.debugLine="Dim indice As IndiceSuscripcion";
_indice = new pullup.wallet.suscripciones._indicesuscripcion();
RDebugUtils.currentLine=18546695;
 //BA.debugLineNum = 18546695;BA.debugLine="btnEliminar = Sender";
_btneliminar = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=18546697;
 //BA.debugLineNum = 18546697;BA.debugLine="pnlPadre = btnEliminar.Parent";
_pnlpadre = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_btneliminar.getParent()));
RDebugUtils.currentLine=18546699;
 //BA.debugLineNum = 18546699;BA.debugLine="indice = pnlPadre.Tag";
_indice = (pullup.wallet.suscripciones._indicesuscripcion)(_pnlpadre.getTag());
RDebugUtils.currentLine=18546701;
 //BA.debugLineNum = 18546701;BA.debugLine="idRegistro = indice.rowid";
_idregistro = _indice.rowid /*int*/ ;
RDebugUtils.currentLine=18546704;
 //BA.debugLineNum = 18546704;BA.debugLine="Dim resultado As Int";
_resultado = 0;
RDebugUtils.currentLine=18546705;
 //BA.debugLineNum = 18546705;BA.debugLine="resultado = Msgbox2(\"¿Estás seguro?\", \"Eliminar s";
_resultado = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("¿Estás seguro?"),BA.ObjectToCharSequence("Eliminar suscripción"),"Sí","","No",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=18546706;
 //BA.debugLineNum = 18546706;BA.debugLine="If (resultado = DialogResponse.POSITIVE) Then";
if ((_resultado==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE)) { 
RDebugUtils.currentLine=18546708;
 //BA.debugLineNum = 18546708;BA.debugLine="sql.ExecNonQuery(\"DELETE FROM suscripciones WHER";
_sql.ExecNonQuery("DELETE FROM suscripciones WHERE id_suscripcion = '"+BA.NumberToString(_idregistro)+"'");
RDebugUtils.currentLine=18546711;
 //BA.debugLineNum = 18546711;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=18546712;
 //BA.debugLineNum = 18546712;BA.debugLine="StartActivity(Me)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,suscripciones.getObject());
 };
RDebugUtils.currentLine=18546714;
 //BA.debugLineNum = 18546714;BA.debugLine="End Sub";
return "";
}
public static String  _btnmenu_click() throws Exception{
RDebugUtils.currentModule="suscripciones";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnmenu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnmenu_click", null));}
RDebugUtils.currentLine=18284544;
 //BA.debugLineNum = 18284544;BA.debugLine="Private Sub btnMenu_Click";
RDebugUtils.currentLine=18284545;
 //BA.debugLineNum = 18284545;BA.debugLine="CallSubDelayed(Main, \"actualizarDatos\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._main.getObject()),"actualizarDatos");
RDebugUtils.currentLine=18284546;
 //BA.debugLineNum = 18284546;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=18284547;
 //BA.debugLineNum = 18284547;BA.debugLine="End Sub";
return "";
}
public static String  _lblopciones_click() throws Exception{
RDebugUtils.currentModule="suscripciones";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblopciones_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblopciones_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _lblopcion = null;
pullup.wallet.suscripciones._indicesuscripcion _indice = null;
int _contador = 0;
RDebugUtils.currentLine=18415616;
 //BA.debugLineNum = 18415616;BA.debugLine="Sub lblOpciones_Click";
RDebugUtils.currentLine=18415617;
 //BA.debugLineNum = 18415617;BA.debugLine="Dim lblOpcion As Label";
_lblopcion = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=18415618;
 //BA.debugLineNum = 18415618;BA.debugLine="Dim indice As IndiceSuscripcion";
_indice = new pullup.wallet.suscripciones._indicesuscripcion();
RDebugUtils.currentLine=18415620;
 //BA.debugLineNum = 18415620;BA.debugLine="lblOpcion = Sender";
_lblopcion = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=18415621;
 //BA.debugLineNum = 18415621;BA.debugLine="indice = lblOpcion.Tag";
_indice = (pullup.wallet.suscripciones._indicesuscripcion)(_lblopcion.getTag());
RDebugUtils.currentLine=18415624;
 //BA.debugLineNum = 18415624;BA.debugLine="For contador = 0 To arrayPnlsOpciones.Length - 1";
{
final int step5 = 1;
final int limit5 = (int) (mostCurrent._arraypnlsopciones.length-1);
_contador = (int) (0) ;
for (;_contador <= limit5 ;_contador = _contador + step5 ) {
RDebugUtils.currentLine=18415625;
 //BA.debugLineNum = 18415625;BA.debugLine="If (contador <> indice.indiceElemento) Then";
if ((_contador!=_indice.indiceElemento /*int*/ )) { 
RDebugUtils.currentLine=18415626;
 //BA.debugLineNum = 18415626;BA.debugLine="arrayPnlsOpciones(contador).Visible = False";
mostCurrent._arraypnlsopciones[_contador].setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 }
};
RDebugUtils.currentLine=18415631;
 //BA.debugLineNum = 18415631;BA.debugLine="Relaciones(indice.indiceElemento, 1).SetVisibleAn";
mostCurrent._relaciones[_indice.indiceElemento /*int*/ ][(int) (1)].SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.Not(mostCurrent._relaciones[_indice.indiceElemento /*int*/ ][(int) (1)].getVisible()));
RDebugUtils.currentLine=18415632;
 //BA.debugLineNum = 18415632;BA.debugLine="End Sub";
return "";
}
}