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

public class ingresosunicos extends Activity implements B4AActivity{
	public static ingresosunicos mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "pullup.wallet", "pullup.wallet.ingresosunicos");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (ingresosunicos).");
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
		activityBA = new BA(this, layout, processBA, "pullup.wallet", "pullup.wallet.ingresosunicos");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "pullup.wallet.ingresosunicos", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (ingresosunicos) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (ingresosunicos) Resume **");
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
		return ingresosunicos.class;
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
            BA.LogInfo("** Activity (ingresosunicos) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (ingresosunicos) Pause event (activity is not paused). **");
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
            ingresosunicos mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (ingresosunicos) Resume **");
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


public static class _indiceingresounico{
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
public static class _ingresounico{
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
public static int _sumaingresosantigua = 0;
public static int _montoseleccionado = 0;
public static int _sumaingresosactual = 0;
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
public pullup.wallet.metasdeahorro _metasdeahorro = null;
public pullup.wallet.registrargasto _registrargasto = null;
public pullup.wallet.registraringreso _registraringreso = null;
public pullup.wallet.registrarmetaahorro _registrarmetaahorro = null;
public pullup.wallet.registrarsuscripcion _registrarsuscripcion = null;
public pullup.wallet.suscripciones _suscripciones = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="ingresosunicos";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.LabelWrapper _lblseccion = null;
int _top = 0;
int _id = 0;
pullup.wallet.ingresosunicos._ingresounico _datosingresounico = null;
anywheresoftware.b4a.objects.LabelWrapper _lblmensaje = null;
RDebugUtils.currentLine=11468800;
 //BA.debugLineNum = 11468800;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=11468803;
 //BA.debugLineNum = 11468803;BA.debugLine="Activity.LoadLayout(\"LDeslizable\")";
mostCurrent._activity.LoadLayout("LDeslizable",mostCurrent.activityBA);
RDebugUtils.currentLine=11468804;
 //BA.debugLineNum = 11468804;BA.debugLine="Activity.Color = Colors.ARGB(255, 233, 236, 239)";
mostCurrent._activity.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (233),(int) (236),(int) (239)));
RDebugUtils.currentLine=11468805;
 //BA.debugLineNum = 11468805;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
_alturadispositivo = mostCurrent._main._alturadispositivo /*int*/ ;
RDebugUtils.currentLine=11468806;
 //BA.debugLineNum = 11468806;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
_anchodispositivo = mostCurrent._main._anchodispositivo /*int*/ ;
RDebugUtils.currentLine=11468807;
 //BA.debugLineNum = 11468807;BA.debugLine="sql = Starter.sql";
_sql = mostCurrent._starter._sql /*anywheresoftware.b4a.sql.SQL*/ ;
RDebugUtils.currentLine=11468808;
 //BA.debugLineNum = 11468808;BA.debugLine="bmpTest.InitializeMutable(1dip, 1dip)";
mostCurrent._bmptest.InitializeMutable(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)));
RDebugUtils.currentLine=11468809;
 //BA.debugLineNum = 11468809;BA.debugLine="cvsTest.Initialize2(bmpTest)";
mostCurrent._cvstest.Initialize2((android.graphics.Bitmap)(mostCurrent._bmptest.getObject()));
RDebugUtils.currentLine=11468812;
 //BA.debugLineNum = 11468812;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
mostCurrent._pnlnavinferior.setHeight((int) (_alturadispositivo*0.08));
RDebugUtils.currentLine=11468813;
 //BA.debugLineNum = 11468813;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
mostCurrent._pnlnavinferior.setWidth(_anchodispositivo);
RDebugUtils.currentLine=11468814;
 //BA.debugLineNum = 11468814;BA.debugLine="pnlNavInferior.Left = 0";
mostCurrent._pnlnavinferior.setLeft((int) (0));
RDebugUtils.currentLine=11468815;
 //BA.debugLineNum = 11468815;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
mostCurrent._pnlnavinferior.setTop((int) (_alturadispositivo-mostCurrent._pnlnavinferior.getHeight()));
RDebugUtils.currentLine=11468818;
 //BA.debugLineNum = 11468818;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
mostCurrent._btnmenu.setWidth((int) (_anchodispositivo*0.15));
RDebugUtils.currentLine=11468819;
 //BA.debugLineNum = 11468819;BA.debugLine="btnMenu.Height = btnMenu.Width";
mostCurrent._btnmenu.setHeight(mostCurrent._btnmenu.getWidth());
RDebugUtils.currentLine=11468820;
 //BA.debugLineNum = 11468820;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
mostCurrent._btnmenu.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._btnmenu.getHeight()/(double)2));
RDebugUtils.currentLine=11468821;
 //BA.debugLineNum = 11468821;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
mostCurrent._btnmenu.setLeft((int) ((_anchodispositivo-mostCurrent._btnmenu.getWidth())/(double)2));
RDebugUtils.currentLine=11468823;
 //BA.debugLineNum = 11468823;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
mostCurrent._lblcontornoboton.setWidth((int) (_anchodispositivo*0.17));
RDebugUtils.currentLine=11468824;
 //BA.debugLineNum = 11468824;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
mostCurrent._lblcontornoboton.setHeight(mostCurrent._lblcontornoboton.getWidth());
RDebugUtils.currentLine=11468825;
 //BA.debugLineNum = 11468825;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
mostCurrent._lblcontornoboton.setLeft((int) ((_anchodispositivo-mostCurrent._lblcontornoboton.getWidth())/(double)2));
RDebugUtils.currentLine=11468826;
 //BA.debugLineNum = 11468826;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
mostCurrent._lblcontornoboton.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._lblcontornoboton.getHeight()/(double)2));
RDebugUtils.currentLine=11468830;
 //BA.debugLineNum = 11468830;BA.debugLine="svPantalla.Height = pnlNavInferior.Top";
mostCurrent._svpantalla.setHeight(mostCurrent._pnlnavinferior.getTop());
RDebugUtils.currentLine=11468831;
 //BA.debugLineNum = 11468831;BA.debugLine="svPantalla.Panel.LoadLayout(\"LPantallaDeslizable\"";
mostCurrent._svpantalla.getPanel().LoadLayout("LPantallaDeslizable",mostCurrent.activityBA);
RDebugUtils.currentLine=11468832;
 //BA.debugLineNum = 11468832;BA.debugLine="svPantalla.Width = anchoDispositivo * 1.5";
mostCurrent._svpantalla.setWidth((int) (_anchodispositivo*1.5));
RDebugUtils.currentLine=11468833;
 //BA.debugLineNum = 11468833;BA.debugLine="pnlDeslizable.Width = svPantalla.Width";
mostCurrent._pnldeslizable.setWidth(mostCurrent._svpantalla.getWidth());
RDebugUtils.currentLine=11468839;
 //BA.debugLineNum = 11468839;BA.debugLine="Dim lblSeccion As Label";
_lblseccion = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=11468840;
 //BA.debugLineNum = 11468840;BA.debugLine="lblSeccion.Initialize(\"lblSeccion\")";
_lblseccion.Initialize(mostCurrent.activityBA,"lblSeccion");
RDebugUtils.currentLine=11468841;
 //BA.debugLineNum = 11468841;BA.debugLine="lblSeccion.Text = \"Ingresos únicos\"";
_lblseccion.setText(BA.ObjectToCharSequence("Ingresos únicos"));
RDebugUtils.currentLine=11468842;
 //BA.debugLineNum = 11468842;BA.debugLine="lblSeccion.TextSize = 20";
_lblseccion.setTextSize((float) (20));
RDebugUtils.currentLine=11468843;
 //BA.debugLineNum = 11468843;BA.debugLine="lblSeccion.TextColor = Colors.Black";
_lblseccion.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=11468844;
 //BA.debugLineNum = 11468844;BA.debugLine="lblSeccion.Height = 30dip";
_lblseccion.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=11468845;
 //BA.debugLineNum = 11468845;BA.debugLine="lblSeccion.Width = anchoDispositivo * 0.9";
_lblseccion.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=11468846;
 //BA.debugLineNum = 11468846;BA.debugLine="lblSeccion.Top = 30dip";
_lblseccion.setTop(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=11468847;
 //BA.debugLineNum = 11468847;BA.debugLine="lblSeccion.Left = (anchoDispositivo - lblSeccion.";
_lblseccion.setLeft((int) ((_anchodispositivo-_lblseccion.getWidth())/(double)2));
RDebugUtils.currentLine=11468848;
 //BA.debugLineNum = 11468848;BA.debugLine="pnlDeslizable.AddView(lblSeccion, lblSeccion.Left";
mostCurrent._pnldeslizable.AddView((android.view.View)(_lblseccion.getObject()),_lblseccion.getLeft(),_lblseccion.getTop(),_lblseccion.getWidth(),_lblseccion.getHeight());
RDebugUtils.currentLine=11468853;
 //BA.debugLineNum = 11468853;BA.debugLine="Dim top As Int";
_top = 0;
RDebugUtils.currentLine=11468854;
 //BA.debugLineNum = 11468854;BA.debugLine="top = lblSeccion.Top + lblSeccion.Height + 30dip";
_top = (int) (_lblseccion.getTop()+_lblseccion.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=11468857;
 //BA.debugLineNum = 11468857;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM ingresos_unico";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM ingresos_unicos ORDER BY rowid ASC")));
RDebugUtils.currentLine=11468858;
 //BA.debugLineNum = 11468858;BA.debugLine="nRegistros = cur.RowCount";
_nregistros = mostCurrent._cur.getRowCount();
RDebugUtils.currentLine=11468862;
 //BA.debugLineNum = 11468862;BA.debugLine="If nRegistros > 0 Then";
if (_nregistros>0) { 
RDebugUtils.currentLine=11468864;
 //BA.debugLineNum = 11468864;BA.debugLine="Dim Relaciones(nRegistros, 2) As B4XView";
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
RDebugUtils.currentLine=11468865;
 //BA.debugLineNum = 11468865;BA.debugLine="Dim arrayPnlsOpciones(nRegistros) As B4XView";
mostCurrent._arraypnlsopciones = new anywheresoftware.b4a.objects.B4XViewWrapper[_nregistros];
{
int d0 = mostCurrent._arraypnlsopciones.length;
for (int i0 = 0;i0 < d0;i0++) {
mostCurrent._arraypnlsopciones[i0] = new anywheresoftware.b4a.objects.B4XViewWrapper();
}
}
;
RDebugUtils.currentLine=11468867;
 //BA.debugLineNum = 11468867;BA.debugLine="For id = 0 To nRegistros - 1";
{
final int step41 = 1;
final int limit41 = (int) (_nregistros-1);
_id = (int) (0) ;
for (;_id <= limit41 ;_id = _id + step41 ) {
RDebugUtils.currentLine=11468868;
 //BA.debugLineNum = 11468868;BA.debugLine="cur.Position = id";
mostCurrent._cur.setPosition(_id);
RDebugUtils.currentLine=11468870;
 //BA.debugLineNum = 11468870;BA.debugLine="Dim datosIngresoUnico As IngresoUnico";
_datosingresounico = new pullup.wallet.ingresosunicos._ingresounico();
RDebugUtils.currentLine=11468871;
 //BA.debugLineNum = 11468871;BA.debugLine="datosIngresoUnico.rowid = cur.GetInt(\"id_ingres";
_datosingresounico.rowid /*int*/  = mostCurrent._cur.GetInt("id_ingreso_unico");
RDebugUtils.currentLine=11468872;
 //BA.debugLineNum = 11468872;BA.debugLine="datosIngresoUnico.nombre = cur.GetString(\"nombr";
_datosingresounico.nombre /*String*/  = mostCurrent._cur.GetString("nombre");
RDebugUtils.currentLine=11468873;
 //BA.debugLineNum = 11468873;BA.debugLine="datosIngresoUnico.monto = cur.GetInt(\"monto\")";
_datosingresounico.monto /*int*/  = mostCurrent._cur.GetInt("monto");
RDebugUtils.currentLine=11468874;
 //BA.debugLineNum = 11468874;BA.debugLine="datosIngresoUnico.descripcion = cur.GetString(\"";
_datosingresounico.descripcion /*String*/  = mostCurrent._cur.GetString("descripcion");
RDebugUtils.currentLine=11468875;
 //BA.debugLineNum = 11468875;BA.debugLine="datosIngresoUnico.fecha = cur.GetString(\"fecha_";
_datosingresounico.fecha /*String*/  = mostCurrent._cur.GetString("fecha_registro");
RDebugUtils.currentLine=11468876;
 //BA.debugLineNum = 11468876;BA.debugLine="datosIngresoUnico.color = cur.GetInt(\"color\")";
_datosingresounico.color /*int*/  = mostCurrent._cur.GetInt("color");
RDebugUtils.currentLine=11468878;
 //BA.debugLineNum = 11468878;BA.debugLine="creaObjetoLista(id, top, datosIngresoUnico)";
_creaobjetolista(_id,_top,_datosingresounico);
RDebugUtils.currentLine=11468880;
 //BA.debugLineNum = 11468880;BA.debugLine="top = top + alturaDispositivo * 0.12 + 60";
_top = (int) (_top+_alturadispositivo*0.12+60);
 }
};
 }else {
RDebugUtils.currentLine=11468884;
 //BA.debugLineNum = 11468884;BA.debugLine="Dim lblMensaje As Label";
_lblmensaje = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=11468885;
 //BA.debugLineNum = 11468885;BA.debugLine="lblMensaje.Initialize(\"lblMensaje\")";
_lblmensaje.Initialize(mostCurrent.activityBA,"lblMensaje");
RDebugUtils.currentLine=11468886;
 //BA.debugLineNum = 11468886;BA.debugLine="lblMensaje.Height = alturaDispositivo * 0.2";
_lblmensaje.setHeight((int) (_alturadispositivo*0.2));
RDebugUtils.currentLine=11468887;
 //BA.debugLineNum = 11468887;BA.debugLine="lblMensaje.Width = anchoDispositivo * 0.9";
_lblmensaje.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=11468888;
 //BA.debugLineNum = 11468888;BA.debugLine="lblMensaje.Top = (alturaDispositivo - lblMensaje";
_lblmensaje.setTop((int) ((_alturadispositivo-_lblmensaje.getHeight())/(double)2));
RDebugUtils.currentLine=11468889;
 //BA.debugLineNum = 11468889;BA.debugLine="lblMensaje.Left = (anchoDispositivo - lblMensaje";
_lblmensaje.setLeft((int) ((_anchodispositivo-_lblmensaje.getWidth())/(double)2));
RDebugUtils.currentLine=11468890;
 //BA.debugLineNum = 11468890;BA.debugLine="lblMensaje.Text = cs.Initialize.Color(Colors.Bla";
_lblmensaje.setText(BA.ObjectToCharSequence(mostCurrent._cs.Initialize().Color(anywheresoftware.b4a.keywords.Common.Colors.Black).Alignment(BA.getEnumFromString(android.text.Layout.Alignment.class,"ALIGN_CENTER")).Typeface(anywheresoftware.b4a.keywords.Common.Typeface.getMATERIALICONS()).Size((int) (50)).Append(BA.ObjectToCharSequence(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (0xe89c)))+anywheresoftware.b4a.keywords.Common.CRLF)).Typeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT).Size((int) (18)).Append(BA.ObjectToCharSequence("Está muy vacío aquí adentro."+anywheresoftware.b4a.keywords.Common.CRLF)).Append(BA.ObjectToCharSequence("Agrega un ingreso único desde el menú principal.")).PopAll().getObject()));
RDebugUtils.currentLine=11468891;
 //BA.debugLineNum = 11468891;BA.debugLine="Activity.AddView(lblMensaje, lblMensaje.Left, lb";
mostCurrent._activity.AddView((android.view.View)(_lblmensaje.getObject()),_lblmensaje.getLeft(),_lblmensaje.getTop(),_lblmensaje.getWidth(),_lblmensaje.getHeight());
 };
RDebugUtils.currentLine=11468894;
 //BA.debugLineNum = 11468894;BA.debugLine="svPantalla.Panel.Height = top + 100";
mostCurrent._svpantalla.getPanel().setHeight((int) (_top+100));
RDebugUtils.currentLine=11468895;
 //BA.debugLineNum = 11468895;BA.debugLine="End Sub";
return "";
}
public static String  _creaobjetolista(int _indice,int _top,pullup.wallet.ingresosunicos._ingresounico _datos) throws Exception{
RDebugUtils.currentModule="ingresosunicos";
if (Debug.shouldDelegate(mostCurrent.activityBA, "creaobjetolista", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "creaobjetolista", new Object[] {_indice,_top,_datos}));}
anywheresoftware.b4a.objects.PanelWrapper _pnlingresounico = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlopciones = null;
anywheresoftware.b4a.objects.LabelWrapper _lblnombre = null;
anywheresoftware.b4a.objects.LabelWrapper _lblmonto = null;
anywheresoftware.b4a.objects.LabelWrapper _lbldescripcion = null;
anywheresoftware.b4a.objects.LabelWrapper _lblfecha = null;
anywheresoftware.b4a.objects.LabelWrapper _lblopciones = null;
anywheresoftware.b4a.objects.ButtonWrapper _btneditar = null;
anywheresoftware.b4a.objects.ButtonWrapper _btneliminar = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
pullup.wallet.ingresosunicos._indiceingresounico _referencia = null;
pullup.wallet.ingresosunicos._indiceingresounico _referencia2 = null;
RDebugUtils.currentLine=11730944;
 //BA.debugLineNum = 11730944;BA.debugLine="Sub creaObjetoLista(indice As Int, top As Int, dat";
RDebugUtils.currentLine=11730945;
 //BA.debugLineNum = 11730945;BA.debugLine="Dim pnlIngresoUnico As Panel";
_pnlingresounico = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=11730946;
 //BA.debugLineNum = 11730946;BA.debugLine="Dim pnlOpciones As Panel";
_pnlopciones = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=11730947;
 //BA.debugLineNum = 11730947;BA.debugLine="Dim lblNombre As Label";
_lblnombre = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=11730948;
 //BA.debugLineNum = 11730948;BA.debugLine="Dim lblMonto As Label";
_lblmonto = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=11730949;
 //BA.debugLineNum = 11730949;BA.debugLine="Dim lblDescripcion As Label";
_lbldescripcion = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=11730950;
 //BA.debugLineNum = 11730950;BA.debugLine="Dim lblFecha As Label";
_lblfecha = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=11730951;
 //BA.debugLineNum = 11730951;BA.debugLine="Dim lblOpciones As Label";
_lblopciones = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=11730952;
 //BA.debugLineNum = 11730952;BA.debugLine="Dim btnEditar As Button";
_btneditar = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=11730953;
 //BA.debugLineNum = 11730953;BA.debugLine="Dim btnEliminar As Button";
_btneliminar = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=11730956;
 //BA.debugLineNum = 11730956;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=11730957;
 //BA.debugLineNum = 11730957;BA.debugLine="cd.Initialize(datos.color, 20)";
_cd.Initialize(_datos.color /*int*/ ,(int) (20));
RDebugUtils.currentLine=11730960;
 //BA.debugLineNum = 11730960;BA.debugLine="pnlIngresoUnico.Initialize(\"pnlIngresoUnico\")";
_pnlingresounico.Initialize(mostCurrent.activityBA,"pnlIngresoUnico");
RDebugUtils.currentLine=11730961;
 //BA.debugLineNum = 11730961;BA.debugLine="pnlIngresoUnico.Top = top";
_pnlingresounico.setTop(_top);
RDebugUtils.currentLine=11730962;
 //BA.debugLineNum = 11730962;BA.debugLine="pnlIngresoUnico.Background = cd";
_pnlingresounico.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=11730963;
 //BA.debugLineNum = 11730963;BA.debugLine="pnlIngresoUnico.Width = anchoDispositivo * 0.9";
_pnlingresounico.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=11730964;
 //BA.debugLineNum = 11730964;BA.debugLine="pnlIngresoUnico.Height = alturaDispositivo * 0.14";
_pnlingresounico.setHeight((int) (_alturadispositivo*0.14));
RDebugUtils.currentLine=11730965;
 //BA.debugLineNum = 11730965;BA.debugLine="pnlIngresoUnico.Left = (anchoDispositivo - pnlIng";
_pnlingresounico.setLeft((int) ((_anchodispositivo-_pnlingresounico.getWidth())/(double)2));
RDebugUtils.currentLine=11730967;
 //BA.debugLineNum = 11730967;BA.debugLine="lblNombre.Initialize(\"lblNombre\")";
_lblnombre.Initialize(mostCurrent.activityBA,"lblNombre");
RDebugUtils.currentLine=11730968;
 //BA.debugLineNum = 11730968;BA.debugLine="lblNombre.TextColor = Colors.White";
_lblnombre.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=11730969;
 //BA.debugLineNum = 11730969;BA.debugLine="lblNombre.Text = datos.nombre.ToUpperCase.CharAt(";
_lblnombre.setText(BA.ObjectToCharSequence(BA.ObjectToString(_datos.nombre /*String*/ .toUpperCase().charAt((int) (0)))+_datos.nombre /*String*/ .substring((int) (1)).toLowerCase()));
RDebugUtils.currentLine=11730970;
 //BA.debugLineNum = 11730970;BA.debugLine="lblNombre.TextSize = 19";
_lblnombre.setTextSize((float) (19));
RDebugUtils.currentLine=11730971;
 //BA.debugLineNum = 11730971;BA.debugLine="lblNombre.Height = pnlIngresoUnico.Height * 0.3";
_lblnombre.setHeight((int) (_pnlingresounico.getHeight()*0.3));
RDebugUtils.currentLine=11730972;
 //BA.debugLineNum = 11730972;BA.debugLine="lblNombre.Width = pnlIngresoUnico.Width * 0.9";
_lblnombre.setWidth((int) (_pnlingresounico.getWidth()*0.9));
RDebugUtils.currentLine=11730973;
 //BA.debugLineNum = 11730973;BA.debugLine="lblNombre.Top = 0";
_lblnombre.setTop((int) (0));
RDebugUtils.currentLine=11730974;
 //BA.debugLineNum = 11730974;BA.debugLine="lblNombre.Left = pnlIngresoUnico.Width * 0.05";
_lblnombre.setLeft((int) (_pnlingresounico.getWidth()*0.05));
RDebugUtils.currentLine=11730975;
 //BA.debugLineNum = 11730975;BA.debugLine="lblNombre.Gravity = Gravity.CENTER_VERTICAL";
_lblnombre.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=11730976;
 //BA.debugLineNum = 11730976;BA.debugLine="pnlIngresoUnico.AddView(lblNombre, lblNombre.Left";
_pnlingresounico.AddView((android.view.View)(_lblnombre.getObject()),_lblnombre.getLeft(),_lblnombre.getTop(),_lblnombre.getWidth(),_lblnombre.getHeight());
RDebugUtils.currentLine=11730978;
 //BA.debugLineNum = 11730978;BA.debugLine="lblDescripcion.Initialize(\"lblDescripcion\")";
_lbldescripcion.Initialize(mostCurrent.activityBA,"lblDescripcion");
RDebugUtils.currentLine=11730979;
 //BA.debugLineNum = 11730979;BA.debugLine="lblDescripcion.Text = datos.descripcion.ToUpperCa";
_lbldescripcion.setText(BA.ObjectToCharSequence(BA.ObjectToString(_datos.descripcion /*String*/ .toUpperCase().charAt((int) (0)))+_datos.descripcion /*String*/ .substring((int) (1)).toLowerCase()));
RDebugUtils.currentLine=11730980;
 //BA.debugLineNum = 11730980;BA.debugLine="lblDescripcion.TextColor = Colors.White";
_lbldescripcion.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=11730981;
 //BA.debugLineNum = 11730981;BA.debugLine="lblDescripcion.Height = pnlIngresoUnico.Height *";
_lbldescripcion.setHeight((int) (_pnlingresounico.getHeight()*0.3));
RDebugUtils.currentLine=11730982;
 //BA.debugLineNum = 11730982;BA.debugLine="lblDescripcion.Width = pnlIngresoUnico.Width * 0.";
_lbldescripcion.setWidth((int) (_pnlingresounico.getWidth()*0.9));
RDebugUtils.currentLine=11730983;
 //BA.debugLineNum = 11730983;BA.debugLine="lblDescripcion.Top = lblNombre.Height";
_lbldescripcion.setTop(_lblnombre.getHeight());
RDebugUtils.currentLine=11730984;
 //BA.debugLineNum = 11730984;BA.debugLine="lblDescripcion.Left = lblNombre.Left";
_lbldescripcion.setLeft(_lblnombre.getLeft());
RDebugUtils.currentLine=11730985;
 //BA.debugLineNum = 11730985;BA.debugLine="lblDescripcion.Gravity = Gravity.CENTER_VERTICAL";
_lbldescripcion.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=11730986;
 //BA.debugLineNum = 11730986;BA.debugLine="pnlIngresoUnico.AddView(lblDescripcion, lblDescri";
_pnlingresounico.AddView((android.view.View)(_lbldescripcion.getObject()),_lbldescripcion.getLeft(),_lbldescripcion.getTop(),_lbldescripcion.getWidth(),_lbldescripcion.getHeight());
RDebugUtils.currentLine=11730988;
 //BA.debugLineNum = 11730988;BA.debugLine="lblFecha.Initialize(\"lblFecha\")";
_lblfecha.Initialize(mostCurrent.activityBA,"lblFecha");
RDebugUtils.currentLine=11730989;
 //BA.debugLineNum = 11730989;BA.debugLine="lblFecha.Text = datos.fecha";
_lblfecha.setText(BA.ObjectToCharSequence(_datos.fecha /*String*/ ));
RDebugUtils.currentLine=11730990;
 //BA.debugLineNum = 11730990;BA.debugLine="lblFecha.TextSize = 16";
_lblfecha.setTextSize((float) (16));
RDebugUtils.currentLine=11730991;
 //BA.debugLineNum = 11730991;BA.debugLine="lblFecha.TextColor = Colors.DarkGray";
_lblfecha.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.DarkGray);
RDebugUtils.currentLine=11730992;
 //BA.debugLineNum = 11730992;BA.debugLine="lblFecha.Height = pnlIngresoUnico.Height * 0.4";
_lblfecha.setHeight((int) (_pnlingresounico.getHeight()*0.4));
RDebugUtils.currentLine=11730993;
 //BA.debugLineNum = 11730993;BA.debugLine="lblFecha.Width = pnlIngresoUnico.Width * 0.9";
_lblfecha.setWidth((int) (_pnlingresounico.getWidth()*0.9));
RDebugUtils.currentLine=11730994;
 //BA.debugLineNum = 11730994;BA.debugLine="lblFecha.Top = lblDescripcion.Top + lblDescripcio";
_lblfecha.setTop((int) (_lbldescripcion.getTop()+_lbldescripcion.getHeight()));
RDebugUtils.currentLine=11730995;
 //BA.debugLineNum = 11730995;BA.debugLine="lblFecha.Left = lblNombre.Left";
_lblfecha.setLeft(_lblnombre.getLeft());
RDebugUtils.currentLine=11730996;
 //BA.debugLineNum = 11730996;BA.debugLine="lblFecha.Gravity = Gravity.CENTER_VERTICAL";
_lblfecha.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=11730997;
 //BA.debugLineNum = 11730997;BA.debugLine="pnlIngresoUnico.AddView(lblFecha, lblFecha.Left,";
_pnlingresounico.AddView((android.view.View)(_lblfecha.getObject()),_lblfecha.getLeft(),_lblfecha.getTop(),_lblfecha.getWidth(),_lblfecha.getHeight());
RDebugUtils.currentLine=11730999;
 //BA.debugLineNum = 11730999;BA.debugLine="lblMonto.Initialize(\"lblMonto\")";
_lblmonto.Initialize(mostCurrent.activityBA,"lblMonto");
RDebugUtils.currentLine=11731000;
 //BA.debugLineNum = 11731000;BA.debugLine="lblMonto.TextSize = 16";
_lblmonto.setTextSize((float) (16));
RDebugUtils.currentLine=11731001;
 //BA.debugLineNum = 11731001;BA.debugLine="lblMonto.TextColor = Colors.Red";
_lblmonto.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=11731002;
 //BA.debugLineNum = 11731002;BA.debugLine="lblMonto.Width = cvsTest.MeasureStringWidth((\"$\"";
_lblmonto.setWidth((int) (mostCurrent._cvstest.MeasureStringWidth(("$"+BA.NumberToString(_datos.monto /*int*/ )),anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT,_lblmonto.getTextSize())+2));
RDebugUtils.currentLine=11731003;
 //BA.debugLineNum = 11731003;BA.debugLine="lblMonto.Height = pnlIngresoUnico.Height * 0.4";
_lblmonto.setHeight((int) (_pnlingresounico.getHeight()*0.4));
RDebugUtils.currentLine=11731004;
 //BA.debugLineNum = 11731004;BA.debugLine="lblMonto.Text = \"$\" & datos.monto";
_lblmonto.setText(BA.ObjectToCharSequence("$"+BA.NumberToString(_datos.monto /*int*/ )));
RDebugUtils.currentLine=11731005;
 //BA.debugLineNum = 11731005;BA.debugLine="lblMonto.Top = lblFecha.Top";
_lblmonto.setTop(_lblfecha.getTop());
RDebugUtils.currentLine=11731006;
 //BA.debugLineNum = 11731006;BA.debugLine="lblMonto.Left = pnlIngresoUnico.Width - lblMonto.";
_lblmonto.setLeft((int) (_pnlingresounico.getWidth()-_lblmonto.getWidth()-_lblnombre.getLeft()));
RDebugUtils.currentLine=11731007;
 //BA.debugLineNum = 11731007;BA.debugLine="lblMonto.Gravity = Gravity.CENTER_VERTICAL";
_lblmonto.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=11731008;
 //BA.debugLineNum = 11731008;BA.debugLine="pnlIngresoUnico.AddView(lblMonto, lblMonto.Left,";
_pnlingresounico.AddView((android.view.View)(_lblmonto.getObject()),_lblmonto.getLeft(),_lblmonto.getTop(),_lblmonto.getWidth(),_lblmonto.getHeight());
RDebugUtils.currentLine=11731010;
 //BA.debugLineNum = 11731010;BA.debugLine="lblOpciones.Initialize(\"lblOpciones\")";
_lblopciones.Initialize(mostCurrent.activityBA,"lblOpciones");
RDebugUtils.currentLine=11731011;
 //BA.debugLineNum = 11731011;BA.debugLine="lblOpciones.Typeface = Typeface.FONTAWESOME";
_lblopciones.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.getFONTAWESOME());
RDebugUtils.currentLine=11731012;
 //BA.debugLineNum = 11731012;BA.debugLine="lblOpciones.Text = Chr(0xF142)";
_lblopciones.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf142))));
RDebugUtils.currentLine=11731013;
 //BA.debugLineNum = 11731013;BA.debugLine="lblOpciones.TextSize = 18";
_lblopciones.setTextSize((float) (18));
RDebugUtils.currentLine=11731014;
 //BA.debugLineNum = 11731014;BA.debugLine="lblOpciones.TextColor = Colors.White";
_lblopciones.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=11731015;
 //BA.debugLineNum = 11731015;BA.debugLine="lblOpciones.Height = lblNombre.Height";
_lblopciones.setHeight(_lblnombre.getHeight());
RDebugUtils.currentLine=11731016;
 //BA.debugLineNum = 11731016;BA.debugLine="lblOpciones.Width = 8dip";
_lblopciones.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (8)));
RDebugUtils.currentLine=11731017;
 //BA.debugLineNum = 11731017;BA.debugLine="lblOpciones.Left = lblMonto.Left + lblMonto.Width";
_lblopciones.setLeft((int) (_lblmonto.getLeft()+_lblmonto.getWidth()-_lblopciones.getWidth()));
RDebugUtils.currentLine=11731018;
 //BA.debugLineNum = 11731018;BA.debugLine="lblOpciones.Top = 0";
_lblopciones.setTop((int) (0));
RDebugUtils.currentLine=11731019;
 //BA.debugLineNum = 11731019;BA.debugLine="lblOpciones.Gravity = Gravity.CENTER_VERTICAL";
_lblopciones.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=11731020;
 //BA.debugLineNum = 11731020;BA.debugLine="pnlIngresoUnico.AddView(lblOpciones, lblOpciones.";
_pnlingresounico.AddView((android.view.View)(_lblopciones.getObject()),_lblopciones.getLeft(),_lblopciones.getTop(),_lblopciones.getWidth(),_lblopciones.getHeight());
RDebugUtils.currentLine=11731022;
 //BA.debugLineNum = 11731022;BA.debugLine="pnlOpciones.Initialize(\"pnlOpciones\")";
_pnlopciones.Initialize(mostCurrent.activityBA,"pnlOpciones");
RDebugUtils.currentLine=11731023;
 //BA.debugLineNum = 11731023;BA.debugLine="cd.Initialize(Colors.Black, 20)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.Black,(int) (20));
RDebugUtils.currentLine=11731024;
 //BA.debugLineNum = 11731024;BA.debugLine="pnlOpciones.Background = cd";
_pnlopciones.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=11731025;
 //BA.debugLineNum = 11731025;BA.debugLine="pnlOpciones.Height = pnlIngresoUnico.Height * 0.8";
_pnlopciones.setHeight((int) (_pnlingresounico.getHeight()*0.8));
RDebugUtils.currentLine=11731026;
 //BA.debugLineNum = 11731026;BA.debugLine="pnlOpciones.Width = pnlIngresoUnico.Height";
_pnlopciones.setWidth(_pnlingresounico.getHeight());
RDebugUtils.currentLine=11731027;
 //BA.debugLineNum = 11731027;BA.debugLine="pnlOpciones.Top = lblOpciones.Top";
_pnlopciones.setTop(_lblopciones.getTop());
RDebugUtils.currentLine=11731028;
 //BA.debugLineNum = 11731028;BA.debugLine="pnlOpciones.Left = lblOpciones.Left - lblOpciones";
_pnlopciones.setLeft((int) (_lblopciones.getLeft()-_lblopciones.getWidth()*2-_pnlopciones.getWidth()));
RDebugUtils.currentLine=11731029;
 //BA.debugLineNum = 11731029;BA.debugLine="pnlOpciones.Visible = False";
_pnlopciones.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=11731030;
 //BA.debugLineNum = 11731030;BA.debugLine="pnlIngresoUnico.AddView(pnlOpciones, pnlOpciones.";
_pnlingresounico.AddView((android.view.View)(_pnlopciones.getObject()),_pnlopciones.getLeft(),_pnlopciones.getTop(),_pnlopciones.getWidth(),_pnlopciones.getHeight());
RDebugUtils.currentLine=11731032;
 //BA.debugLineNum = 11731032;BA.debugLine="btnEditar.Initialize(\"btnEditar\")";
_btneditar.Initialize(mostCurrent.activityBA,"btnEditar");
RDebugUtils.currentLine=11731033;
 //BA.debugLineNum = 11731033;BA.debugLine="btnEditar.Color = Colors.Transparent";
_btneditar.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=11731034;
 //BA.debugLineNum = 11731034;BA.debugLine="btnEditar.Text = \"Editar\"";
_btneditar.setText(BA.ObjectToCharSequence("Editar"));
RDebugUtils.currentLine=11731035;
 //BA.debugLineNum = 11731035;BA.debugLine="btnEditar.TextColor = Colors.White";
_btneditar.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=11731036;
 //BA.debugLineNum = 11731036;BA.debugLine="btnEditar.TextSize = 14";
_btneditar.setTextSize((float) (14));
RDebugUtils.currentLine=11731037;
 //BA.debugLineNum = 11731037;BA.debugLine="btnEditar.Height = pnlOpciones.Height * 0.4";
_btneditar.setHeight((int) (_pnlopciones.getHeight()*0.4));
RDebugUtils.currentLine=11731038;
 //BA.debugLineNum = 11731038;BA.debugLine="btnEditar.Width = pnlOpciones.Height * 0.8";
_btneditar.setWidth((int) (_pnlopciones.getHeight()*0.8));
RDebugUtils.currentLine=11731039;
 //BA.debugLineNum = 11731039;BA.debugLine="btnEditar.Top = (pnlOpciones.Height * 0.2) / 3";
_btneditar.setTop((int) ((_pnlopciones.getHeight()*0.2)/(double)3));
RDebugUtils.currentLine=11731040;
 //BA.debugLineNum = 11731040;BA.debugLine="btnEditar.Left = (pnlOpciones.Width - btnEditar.W";
_btneditar.setLeft((int) ((_pnlopciones.getWidth()-_btneditar.getWidth())/(double)2));
RDebugUtils.currentLine=11731041;
 //BA.debugLineNum = 11731041;BA.debugLine="pnlOpciones.AddView(btnEditar, btnEditar.Left, bt";
_pnlopciones.AddView((android.view.View)(_btneditar.getObject()),_btneditar.getLeft(),_btneditar.getTop(),_btneditar.getWidth(),_btneditar.getHeight());
RDebugUtils.currentLine=11731043;
 //BA.debugLineNum = 11731043;BA.debugLine="btnEliminar.Initialize(\"btnEliminar\")";
_btneliminar.Initialize(mostCurrent.activityBA,"btnEliminar");
RDebugUtils.currentLine=11731044;
 //BA.debugLineNum = 11731044;BA.debugLine="btnEliminar.Color = Colors.Transparent";
_btneliminar.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=11731045;
 //BA.debugLineNum = 11731045;BA.debugLine="btnEliminar.Text = \"Eliminar\"";
_btneliminar.setText(BA.ObjectToCharSequence("Eliminar"));
RDebugUtils.currentLine=11731046;
 //BA.debugLineNum = 11731046;BA.debugLine="btnEliminar.TextColor = Colors.White";
_btneliminar.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=11731047;
 //BA.debugLineNum = 11731047;BA.debugLine="btnEliminar.TextSize = 14";
_btneliminar.setTextSize((float) (14));
RDebugUtils.currentLine=11731048;
 //BA.debugLineNum = 11731048;BA.debugLine="btnEliminar.Height = btnEditar.Height";
_btneliminar.setHeight(_btneditar.getHeight());
RDebugUtils.currentLine=11731049;
 //BA.debugLineNum = 11731049;BA.debugLine="btnEliminar.Width = pnlOpciones.Width * 0.9";
_btneliminar.setWidth((int) (_pnlopciones.getWidth()*0.9));
RDebugUtils.currentLine=11731050;
 //BA.debugLineNum = 11731050;BA.debugLine="btnEliminar.Top = btnEditar.Top * 2 + btnEditar.H";
_btneliminar.setTop((int) (_btneditar.getTop()*2+_btneditar.getHeight()));
RDebugUtils.currentLine=11731051;
 //BA.debugLineNum = 11731051;BA.debugLine="btnEliminar.Left = (pnlOpciones.Width - btnElimin";
_btneliminar.setLeft((int) ((_pnlopciones.getWidth()-_btneliminar.getWidth())/(double)2));
RDebugUtils.currentLine=11731052;
 //BA.debugLineNum = 11731052;BA.debugLine="pnlOpciones.AddView(btnEliminar, btnEliminar.Left";
_pnlopciones.AddView((android.view.View)(_btneliminar.getObject()),_btneliminar.getLeft(),_btneliminar.getTop(),_btneliminar.getWidth(),_btneliminar.getHeight());
RDebugUtils.currentLine=11731054;
 //BA.debugLineNum = 11731054;BA.debugLine="pnlDeslizable.AddView(pnlIngresoUnico, pnlIngreso";
mostCurrent._pnldeslizable.AddView((android.view.View)(_pnlingresounico.getObject()),_pnlingresounico.getLeft(),_top,_pnlingresounico.getWidth(),_pnlingresounico.getHeight());
RDebugUtils.currentLine=11731058;
 //BA.debugLineNum = 11731058;BA.debugLine="Dim referencia As IndiceIngresoUnico";
_referencia = new pullup.wallet.ingresosunicos._indiceingresounico();
RDebugUtils.currentLine=11731059;
 //BA.debugLineNum = 11731059;BA.debugLine="referencia.indiceElemento = indice";
_referencia.indiceElemento /*int*/  = _indice;
RDebugUtils.currentLine=11731060;
 //BA.debugLineNum = 11731060;BA.debugLine="referencia.rowid = 0";
_referencia.rowid /*int*/  = (int) (0);
RDebugUtils.currentLine=11731062;
 //BA.debugLineNum = 11731062;BA.debugLine="lblOpciones.Tag = referencia";
_lblopciones.setTag((Object)(_referencia));
RDebugUtils.currentLine=11731065;
 //BA.debugLineNum = 11731065;BA.debugLine="Dim referencia2 As IndiceIngresoUnico";
_referencia2 = new pullup.wallet.ingresosunicos._indiceingresounico();
RDebugUtils.currentLine=11731066;
 //BA.debugLineNum = 11731066;BA.debugLine="referencia2.indiceElemento = 0";
_referencia2.indiceElemento /*int*/  = (int) (0);
RDebugUtils.currentLine=11731067;
 //BA.debugLineNum = 11731067;BA.debugLine="referencia2.rowid = datos.rowid";
_referencia2.rowid /*int*/  = _datos.rowid /*int*/ ;
RDebugUtils.currentLine=11731069;
 //BA.debugLineNum = 11731069;BA.debugLine="pnlOpciones.Tag = referencia2";
_pnlopciones.setTag((Object)(_referencia2));
RDebugUtils.currentLine=11731072;
 //BA.debugLineNum = 11731072;BA.debugLine="Relaciones(indice, 0) = lblOpciones";
mostCurrent._relaciones[_indice][(int) (0)] = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lblopciones.getObject()));
RDebugUtils.currentLine=11731073;
 //BA.debugLineNum = 11731073;BA.debugLine="Relaciones(indice, 1) = pnlOpciones";
mostCurrent._relaciones[_indice][(int) (1)] = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnlopciones.getObject()));
RDebugUtils.currentLine=11731076;
 //BA.debugLineNum = 11731076;BA.debugLine="arrayPnlsOpciones(indice) = pnlOpciones";
mostCurrent._arraypnlsopciones[_indice] = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnlopciones.getObject()));
RDebugUtils.currentLine=11731077;
 //BA.debugLineNum = 11731077;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="ingresosunicos";
RDebugUtils.currentLine=11599872;
 //BA.debugLineNum = 11599872;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=11599874;
 //BA.debugLineNum = 11599874;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="ingresosunicos";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=11534336;
 //BA.debugLineNum = 11534336;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=11534338;
 //BA.debugLineNum = 11534338;BA.debugLine="End Sub";
return "";
}
public static String  _btneditar_click() throws Exception{
RDebugUtils.currentModule="ingresosunicos";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btneditar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btneditar_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btneditar = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlpadre = null;
int _idregistro = 0;
pullup.wallet.ingresosunicos._indiceingresounico _indice = null;
RDebugUtils.currentLine=11862016;
 //BA.debugLineNum = 11862016;BA.debugLine="Sub btnEditar_Click";
RDebugUtils.currentLine=11862017;
 //BA.debugLineNum = 11862017;BA.debugLine="Dim btnEditar As Button";
_btneditar = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=11862018;
 //BA.debugLineNum = 11862018;BA.debugLine="Dim pnlPadre As Panel";
_pnlpadre = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=11862019;
 //BA.debugLineNum = 11862019;BA.debugLine="Dim idRegistro As Int";
_idregistro = 0;
RDebugUtils.currentLine=11862020;
 //BA.debugLineNum = 11862020;BA.debugLine="Dim indice As IndiceIngresoUnico";
_indice = new pullup.wallet.ingresosunicos._indiceingresounico();
RDebugUtils.currentLine=11862023;
 //BA.debugLineNum = 11862023;BA.debugLine="btnEditar = Sender";
_btneditar = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=11862025;
 //BA.debugLineNum = 11862025;BA.debugLine="pnlPadre = btnEditar.Parent";
_pnlpadre = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_btneditar.getParent()));
RDebugUtils.currentLine=11862027;
 //BA.debugLineNum = 11862027;BA.debugLine="indice = pnlPadre.Tag";
_indice = (pullup.wallet.ingresosunicos._indiceingresounico)(_pnlpadre.getTag());
RDebugUtils.currentLine=11862029;
 //BA.debugLineNum = 11862029;BA.debugLine="idRegistro = indice.rowid";
_idregistro = _indice.rowid /*int*/ ;
RDebugUtils.currentLine=11862030;
 //BA.debugLineNum = 11862030;BA.debugLine="CallSubDelayed2(editarIngresoUnico, \"consultaAEdi";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._editaringresounico.getObject()),"consultaAEditar",(Object)(_idregistro));
RDebugUtils.currentLine=11862031;
 //BA.debugLineNum = 11862031;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=11862032;
 //BA.debugLineNum = 11862032;BA.debugLine="End Sub";
return "";
}
public static String  _btneliminar_click() throws Exception{
RDebugUtils.currentModule="ingresosunicos";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btneliminar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btneliminar_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _btneliminar = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlpadre = null;
int _idregistro = 0;
pullup.wallet.ingresosunicos._indiceingresounico _indice = null;
int _resultado = 0;
RDebugUtils.currentLine=11927552;
 //BA.debugLineNum = 11927552;BA.debugLine="Sub btnEliminar_Click";
RDebugUtils.currentLine=11927553;
 //BA.debugLineNum = 11927553;BA.debugLine="Dim btnEliminar As Button";
_btneliminar = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=11927554;
 //BA.debugLineNum = 11927554;BA.debugLine="Dim pnlPadre As Panel";
_pnlpadre = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=11927555;
 //BA.debugLineNum = 11927555;BA.debugLine="Dim idRegistro As Int";
_idregistro = 0;
RDebugUtils.currentLine=11927556;
 //BA.debugLineNum = 11927556;BA.debugLine="Dim indice As IndiceIngresoUnico";
_indice = new pullup.wallet.ingresosunicos._indiceingresounico();
RDebugUtils.currentLine=11927559;
 //BA.debugLineNum = 11927559;BA.debugLine="btnEliminar = Sender";
_btneliminar = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=11927561;
 //BA.debugLineNum = 11927561;BA.debugLine="pnlPadre = btnEliminar.Parent";
_pnlpadre = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_btneliminar.getParent()));
RDebugUtils.currentLine=11927563;
 //BA.debugLineNum = 11927563;BA.debugLine="indice = pnlPadre.Tag";
_indice = (pullup.wallet.ingresosunicos._indiceingresounico)(_pnlpadre.getTag());
RDebugUtils.currentLine=11927565;
 //BA.debugLineNum = 11927565;BA.debugLine="idRegistro = indice.rowid";
_idregistro = _indice.rowid /*int*/ ;
RDebugUtils.currentLine=11927568;
 //BA.debugLineNum = 11927568;BA.debugLine="Dim resultado As Int";
_resultado = 0;
RDebugUtils.currentLine=11927569;
 //BA.debugLineNum = 11927569;BA.debugLine="resultado = Msgbox2(\"¿Estás seguro?\", \"Eliminar i";
_resultado = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("¿Estás seguro?"),BA.ObjectToCharSequence("Eliminar ingreso único"),"Sí","","No",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=11927570;
 //BA.debugLineNum = 11927570;BA.debugLine="If (resultado = DialogResponse.POSITIVE) Then";
if ((_resultado==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE)) { 
RDebugUtils.currentLine=11927572;
 //BA.debugLineNum = 11927572;BA.debugLine="cur = sql.ExecQuery2(\"SELECT monto FROM ingresos";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery2("SELECT monto FROM ingresos_unicos WHERE id_ingreso_unico = ?",new String[]{BA.NumberToString(_idregistro)+""})));
RDebugUtils.currentLine=11927573;
 //BA.debugLineNum = 11927573;BA.debugLine="cur.Position = 0";
mostCurrent._cur.setPosition((int) (0));
RDebugUtils.currentLine=11927574;
 //BA.debugLineNum = 11927574;BA.debugLine="montoSeleccionado = cur.GetInt(\"monto\")";
_montoseleccionado = mostCurrent._cur.GetInt("monto");
RDebugUtils.currentLine=11927577;
 //BA.debugLineNum = 11927577;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM ingresos WHER";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM ingresos WHERE id_ingreso = 1")));
RDebugUtils.currentLine=11927578;
 //BA.debugLineNum = 11927578;BA.debugLine="cur.Position = 0";
mostCurrent._cur.setPosition((int) (0));
RDebugUtils.currentLine=11927579;
 //BA.debugLineNum = 11927579;BA.debugLine="sumaIngresosAntigua = cur.GetInt(\"suma_ingresos\"";
_sumaingresosantigua = mostCurrent._cur.GetInt("suma_ingresos");
RDebugUtils.currentLine=11927582;
 //BA.debugLineNum = 11927582;BA.debugLine="sumaIngresosActual = sumaIngresosAntigua - monto";
_sumaingresosactual = (int) (_sumaingresosantigua-_montoseleccionado);
RDebugUtils.currentLine=11927584;
 //BA.debugLineNum = 11927584;BA.debugLine="sql.ExecNonQuery2(\"UPDATE ingresos SET suma_ingr";
_sql.ExecNonQuery2("UPDATE ingresos SET suma_ingresos = ? WHERE id_ingreso = 1",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_sumaingresosactual)}));
RDebugUtils.currentLine=11927587;
 //BA.debugLineNum = 11927587;BA.debugLine="sql.ExecNonQuery(\"DELETE FROM ingresos_unicos WH";
_sql.ExecNonQuery("DELETE FROM ingresos_unicos WHERE id_ingreso_unico = '"+BA.NumberToString(_idregistro)+"'");
RDebugUtils.currentLine=11927590;
 //BA.debugLineNum = 11927590;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=11927591;
 //BA.debugLineNum = 11927591;BA.debugLine="StartActivity(Me)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,ingresosunicos.getObject());
 };
RDebugUtils.currentLine=11927593;
 //BA.debugLineNum = 11927593;BA.debugLine="End Sub";
return "";
}
public static String  _btnmenu_click() throws Exception{
RDebugUtils.currentModule="ingresosunicos";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnmenu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnmenu_click", null));}
RDebugUtils.currentLine=11665408;
 //BA.debugLineNum = 11665408;BA.debugLine="Private Sub btnMenu_Click";
RDebugUtils.currentLine=11665409;
 //BA.debugLineNum = 11665409;BA.debugLine="CallSubDelayed(Main, \"actualizarDatos\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._main.getObject()),"actualizarDatos");
RDebugUtils.currentLine=11665410;
 //BA.debugLineNum = 11665410;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=11665411;
 //BA.debugLineNum = 11665411;BA.debugLine="End Sub";
return "";
}
public static String  _lblopciones_click() throws Exception{
RDebugUtils.currentModule="ingresosunicos";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblopciones_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblopciones_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _lblopcion = null;
pullup.wallet.ingresosunicos._indiceingresounico _indice = null;
int _contador = 0;
RDebugUtils.currentLine=11796480;
 //BA.debugLineNum = 11796480;BA.debugLine="Sub lblOpciones_Click";
RDebugUtils.currentLine=11796481;
 //BA.debugLineNum = 11796481;BA.debugLine="Dim lblOpcion As Label";
_lblopcion = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=11796482;
 //BA.debugLineNum = 11796482;BA.debugLine="Dim indice As IndiceIngresoUnico";
_indice = new pullup.wallet.ingresosunicos._indiceingresounico();
RDebugUtils.currentLine=11796484;
 //BA.debugLineNum = 11796484;BA.debugLine="lblOpcion = Sender";
_lblopcion = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=11796485;
 //BA.debugLineNum = 11796485;BA.debugLine="indice = lblOpcion.Tag";
_indice = (pullup.wallet.ingresosunicos._indiceingresounico)(_lblopcion.getTag());
RDebugUtils.currentLine=11796488;
 //BA.debugLineNum = 11796488;BA.debugLine="For contador = 0 To arrayPnlsOpciones.Length - 1";
{
final int step5 = 1;
final int limit5 = (int) (mostCurrent._arraypnlsopciones.length-1);
_contador = (int) (0) ;
for (;_contador <= limit5 ;_contador = _contador + step5 ) {
RDebugUtils.currentLine=11796489;
 //BA.debugLineNum = 11796489;BA.debugLine="If (contador <> indice.indiceElemento) Then";
if ((_contador!=_indice.indiceElemento /*int*/ )) { 
RDebugUtils.currentLine=11796490;
 //BA.debugLineNum = 11796490;BA.debugLine="arrayPnlsOpciones(contador).Visible = False";
mostCurrent._arraypnlsopciones[_contador].setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 }
};
RDebugUtils.currentLine=11796495;
 //BA.debugLineNum = 11796495;BA.debugLine="Relaciones(indice.indiceElemento, 1).SetVisibleAn";
mostCurrent._relaciones[_indice.indiceElemento /*int*/ ][(int) (1)].SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.Not(mostCurrent._relaciones[_indice.indiceElemento /*int*/ ][(int) (1)].getVisible()));
RDebugUtils.currentLine=11796496;
 //BA.debugLineNum = 11796496;BA.debugLine="End Sub";
return "";
}
}