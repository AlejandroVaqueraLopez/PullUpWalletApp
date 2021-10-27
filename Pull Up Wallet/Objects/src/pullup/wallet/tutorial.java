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

public class tutorial extends Activity implements B4AActivity{
	public static tutorial mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "pullup.wallet", "pullup.wallet.tutorial");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (tutorial).");
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
		activityBA = new BA(this, layout, processBA, "pullup.wallet", "pullup.wallet.tutorial");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "pullup.wallet.tutorial", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (tutorial) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (tutorial) Resume **");
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
		return tutorial.class;
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
            BA.LogInfo("** Activity (tutorial) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (tutorial) Pause event (activity is not paused). **");
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
            tutorial mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (tutorial) Resume **");
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
public static anywheresoftware.b4a.objects.Timer _tmranimacion = null;
public static int _pausarpanel = 0;
public static int _contador1 = 0;
public pullup.wallet.diapositivas._slidingdata _sdsosten = null;
public anywheresoftware.b4a.objects.PanelWrapper[] _paneles = null;
public static String _diapositiva = "";
public anywheresoftware.b4a.objects.drawable.ColorDrawable _esquinas = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnizquierda = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnterminartutorial = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnindicador = null;
public static String _menu = "";
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _activarbitmap = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _inactivarbitmap = null;
public pullup.wallet.main _main = null;
public pullup.wallet.starter _starter = null;
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
public pullup.wallet.suscripciones _suscripciones = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="tutorial";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="contador1 = 0";
_contador1 = (int) (0);
RDebugUtils.currentLine=2228228;
 //BA.debugLineNum = 2228228;BA.debugLine="esquinas.Initialize(Colors.RGB(197,197,197), 20)";
mostCurrent._esquinas.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (197),(int) (197),(int) (197)),(int) (20));
RDebugUtils.currentLine=2228229;
 //BA.debugLineNum = 2228229;BA.debugLine="For contador1 = 0 To paneles.Length - 1 Step 1 'S";
{
final int step3 = 1;
final int limit3 = (int) (mostCurrent._paneles.length-1);
_contador1 = (int) (0) ;
for (;_contador1 <= limit3 ;_contador1 = _contador1 + step3 ) {
RDebugUtils.currentLine=2228230;
 //BA.debugLineNum = 2228230;BA.debugLine="diapositiva = contador1 + 1 'Se guarda el numero";
mostCurrent._diapositiva = BA.NumberToString(_contador1+1);
RDebugUtils.currentLine=2228231;
 //BA.debugLineNum = 2228231;BA.debugLine="paneles(contador1).Initialize(\"paneles\")";
mostCurrent._paneles[_contador1].Initialize(mostCurrent.activityBA,"paneles");
RDebugUtils.currentLine=2228232;
 //BA.debugLineNum = 2228232;BA.debugLine="paneles(contador1).SetBackgroundImage(LoadBitmap";
mostCurrent._paneles[_contador1].SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"slide"+mostCurrent._diapositiva+".png").getObject()));
RDebugUtils.currentLine=2228233;
 //BA.debugLineNum = 2228233;BA.debugLine="Activity.AddView(paneles(contador1), 100%x, 0, 1";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._paneles[_contador1].getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80))));
RDebugUtils.currentLine=2228234;
 //BA.debugLineNum = 2228234;BA.debugLine="Activity.AddMenuItem(\"Panel #\" & contador1, \"Men";
mostCurrent._activity.AddMenuItem(BA.ObjectToCharSequence("Panel #"+BA.NumberToString(_contador1)),"Menu");
 }
};
RDebugUtils.currentLine=2228238;
 //BA.debugLineNum = 2228238;BA.debugLine="btnIzquierda.Initialize(\"Left\")";
mostCurrent._btnizquierda.Initialize(mostCurrent.activityBA,"Left");
RDebugUtils.currentLine=2228239;
 //BA.debugLineNum = 2228239;BA.debugLine="btnIzquierda.Text = \">\"";
mostCurrent._btnizquierda.setText(BA.ObjectToCharSequence(">"));
RDebugUtils.currentLine=2228240;
 //BA.debugLineNum = 2228240;BA.debugLine="btnIzquierda.Background = esquinas";
mostCurrent._btnizquierda.setBackground((android.graphics.drawable.Drawable)(mostCurrent._esquinas.getObject()));
RDebugUtils.currentLine=2228241;
 //BA.debugLineNum = 2228241;BA.debugLine="btnIzquierda.Color = Colors.RGB(28,230,210)";
mostCurrent._btnizquierda.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (28),(int) (230),(int) (210)));
RDebugUtils.currentLine=2228242;
 //BA.debugLineNum = 2228242;BA.debugLine="Activity.AddView(btnIzquierda, 60%x, 101%y - 75di";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._btnizquierda.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (101),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (75))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=2228250;
 //BA.debugLineNum = 2228250;BA.debugLine="btnTerminarTutorial.Initialize(\"TerminarTutorial\"";
mostCurrent._btnterminartutorial.Initialize(mostCurrent.activityBA,"TerminarTutorial");
RDebugUtils.currentLine=2228251;
 //BA.debugLineNum = 2228251;BA.debugLine="btnTerminarTutorial.Text = \"Terminar\"";
mostCurrent._btnterminartutorial.setText(BA.ObjectToCharSequence("Terminar"));
RDebugUtils.currentLine=2228252;
 //BA.debugLineNum = 2228252;BA.debugLine="btnTerminarTutorial.Background = esquinas";
mostCurrent._btnterminartutorial.setBackground((android.graphics.drawable.Drawable)(mostCurrent._esquinas.getObject()));
RDebugUtils.currentLine=2228253;
 //BA.debugLineNum = 2228253;BA.debugLine="btnTerminarTutorial.Color = Colors.RGB(28,230,210";
mostCurrent._btnterminartutorial.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (28),(int) (230),(int) (210)));
RDebugUtils.currentLine=2228254;
 //BA.debugLineNum = 2228254;BA.debugLine="Activity.AddView(btnTerminarTutorial, 10%x, 101%y";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._btnterminartutorial.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (101),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (75))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=2228257;
 //BA.debugLineNum = 2228257;BA.debugLine="activarBitmap.Initialize(File.DirAssets, \"indicat";
mostCurrent._activarbitmap.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"indicator_active.png");
RDebugUtils.currentLine=2228258;
 //BA.debugLineNum = 2228258;BA.debugLine="inactivarBitmap.Initialize(File.DirAssets, \"indic";
mostCurrent._inactivarbitmap.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"indicator_inactive.png");
RDebugUtils.currentLine=2228264;
 //BA.debugLineNum = 2228264;BA.debugLine="sdSosten.Initialize";
mostCurrent._sdsosten.Initialize();
RDebugUtils.currentLine=2228265;
 //BA.debugLineNum = 2228265;BA.debugLine="Diapositivas.Initialize(sdSosten, paneles, True,";
mostCurrent._diapositivas._initialize /*String*/ (mostCurrent.activityBA,mostCurrent._sdsosten,mostCurrent._paneles,anywheresoftware.b4a.keywords.Common.True,(int) (150));
RDebugUtils.currentLine=2228266;
 //BA.debugLineNum = 2228266;BA.debugLine="sdSosten.currentPanel = pausarPanel - 1";
mostCurrent._sdsosten.currentPanel /*int*/  = (int) (_pausarpanel-1);
RDebugUtils.currentLine=2228268;
 //BA.debugLineNum = 2228268;BA.debugLine="pnIndicador = Diapositivas.CreatePageIndicator(pa";
mostCurrent._pnindicador = mostCurrent._diapositivas._createpageindicator /*anywheresoftware.b4a.objects.PanelWrapper*/ (mostCurrent.activityBA,mostCurrent._paneles.length,mostCurrent._inactivarbitmap,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (16)));
RDebugUtils.currentLine=2228269;
 //BA.debugLineNum = 2228269;BA.debugLine="Activity.AddView(pnIndicador , (100%x - 120dip) /";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._pnindicador.getObject()),(int) ((anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)))/(double)2),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (16)));
RDebugUtils.currentLine=2228270;
 //BA.debugLineNum = 2228270;BA.debugLine="pnIndicador.BringToFront";
mostCurrent._pnindicador.BringToFront();
RDebugUtils.currentLine=2228271;
 //BA.debugLineNum = 2228271;BA.debugLine="ChangePanel(0)";
_changepanel((int) (0));
RDebugUtils.currentLine=2228272;
 //BA.debugLineNum = 2228272;BA.debugLine="End Sub";
return "";
}
public static String  _changepanel(int _page) throws Exception{
RDebugUtils.currentModule="tutorial";
if (Debug.shouldDelegate(mostCurrent.activityBA, "changepanel", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "changepanel", new Object[] {_page}));}
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub ChangePanel(page As Int)";
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="btnIzquierda.Enabled = False";
mostCurrent._btnizquierda.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2555910;
 //BA.debugLineNum = 2555910;BA.debugLine="sdSosten.targetPanel = page";
mostCurrent._sdsosten.targetPanel /*int*/  = _page;
RDebugUtils.currentLine=2555911;
 //BA.debugLineNum = 2555911;BA.debugLine="Diapositivas.ChangePanel(sdSosten)";
mostCurrent._diapositivas._changepanel /*String*/ (mostCurrent.activityBA,mostCurrent._sdsosten);
RDebugUtils.currentLine=2555912;
 //BA.debugLineNum = 2555912;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="tutorial";
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="If UserClosed = False Then";
if (_userclosed==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="pausarPanel = sdSosten.currentPanel";
_pausarpanel = mostCurrent._sdsosten.currentPanel /*int*/ ;
 }else {
RDebugUtils.currentLine=2752516;
 //BA.debugLineNum = 2752516;BA.debugLine="pausarPanel = 0";
_pausarpanel = (int) (0);
 };
RDebugUtils.currentLine=2752518;
 //BA.debugLineNum = 2752518;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="tutorial";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="End Sub";
return "";
}
public static String  _animation1_animationend() throws Exception{
RDebugUtils.currentModule="tutorial";
if (Debug.shouldDelegate(mostCurrent.activityBA, "animation1_animationend", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "animation1_animationend", null));}
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Sub Animation1_AnimationEnd";
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="Diapositivas.AnimationEnd(sdSosten)";
mostCurrent._diapositivas._animationend /*String*/ (mostCurrent.activityBA,mostCurrent._sdsosten);
RDebugUtils.currentLine=2621445;
 //BA.debugLineNum = 2621445;BA.debugLine="If sdSosten.rotate Then";
if (mostCurrent._sdsosten.rotate /*boolean*/ ) { 
RDebugUtils.currentLine=2621446;
 //BA.debugLineNum = 2621446;BA.debugLine="btnIzquierda.Enabled = True";
mostCurrent._btnizquierda.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=2621449;
 //BA.debugLineNum = 2621449;BA.debugLine="If sdSosten.currentPanel = sdSosten.panels.Lengt";
if (mostCurrent._sdsosten.currentPanel /*int*/ ==mostCurrent._sdsosten.Panels /*anywheresoftware.b4a.objects.PanelWrapper[]*/ .length-1) { 
mostCurrent._btnizquierda.setEnabled(anywheresoftware.b4a.keywords.Common.False);}
else {
mostCurrent._btnizquierda.setEnabled(anywheresoftware.b4a.keywords.Common.True);};
 };
RDebugUtils.currentLine=2621454;
 //BA.debugLineNum = 2621454;BA.debugLine="Diapositivas.SetPageIndicator(pnIndicador, sdSost";
mostCurrent._diapositivas._setpageindicator /*String*/ (mostCurrent.activityBA,mostCurrent._pnindicador,mostCurrent._sdsosten.currentPanel /*int*/ ,mostCurrent._activarbitmap,mostCurrent._inactivarbitmap);
RDebugUtils.currentLine=2621455;
 //BA.debugLineNum = 2621455;BA.debugLine="End Sub";
return "";
}
public static String  _left_click() throws Exception{
RDebugUtils.currentModule="tutorial";
if (Debug.shouldDelegate(mostCurrent.activityBA, "left_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "left_click", null));}
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub Left_Click";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="ChangePanel(Diapositivas.PANEL_LEFT)";
_changepanel(mostCurrent._diapositivas._panel_left /*int*/ );
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="End Sub";
return "";
}
public static String  _menu_click() throws Exception{
RDebugUtils.currentModule="tutorial";
if (Debug.shouldDelegate(mostCurrent.activityBA, "menu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "menu_click", null));}
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub Menu_Click";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="menu = Sender";
mostCurrent._menu = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA));
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="btnIzquierda.Enabled = False";
mostCurrent._btnizquierda.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2293764;
 //BA.debugLineNum = 2293764;BA.debugLine="ChangePanel(menu.SubString(\"Panel #\".Length))";
_changepanel((int)(Double.parseDouble(mostCurrent._menu.substring("Panel #".length()))));
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="End Sub";
return "";
}
public static String  _right_click() throws Exception{
RDebugUtils.currentModule="tutorial";
if (Debug.shouldDelegate(mostCurrent.activityBA, "right_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "right_click", null));}
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub Right_Click";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="ChangePanel(Diapositivas.PANEL_RIGHT)";
_changepanel(mostCurrent._diapositivas._panel_right /*int*/ );
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="End Sub";
return "";
}
public static String  _terminartutorial_click() throws Exception{
RDebugUtils.currentModule="tutorial";
if (Debug.shouldDelegate(mostCurrent.activityBA, "terminartutorial_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "terminartutorial_click", null));}
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub TerminarTutorial_Click";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="Log(\"Ir a menu\")";
anywheresoftware.b4a.keywords.Common.LogImpl("52424834","Ir a menu",0);
RDebugUtils.currentLine=2424835;
 //BA.debugLineNum = 2424835;BA.debugLine="End Sub";
return "";
}
}