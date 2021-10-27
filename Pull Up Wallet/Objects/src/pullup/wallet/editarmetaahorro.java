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

public class editarmetaahorro extends Activity implements B4AActivity{
	public static editarmetaahorro mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "pullup.wallet", "pullup.wallet.editarmetaahorro");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (editarmetaahorro).");
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
		activityBA = new BA(this, layout, processBA, "pullup.wallet", "pullup.wallet.editarmetaahorro");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "pullup.wallet.editarmetaahorro", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (editarmetaahorro) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (editarmetaahorro) Resume **");
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
		return editarmetaahorro.class;
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
            BA.LogInfo("** Activity (editarmetaahorro) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (editarmetaahorro) Pause event (activity is not paused). **");
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
            editarmetaahorro mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (editarmetaahorro) Resume **");
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
public anywheresoftware.b4a.sql.SQL.CursorWrapper _cur = null;
public static int _idregistro = 0;
public anywheresoftware.b4a.objects.StringUtils _stu = null;
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
RDebugUtils.currentModule="editarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=6815744;
 //BA.debugLineNum = 6815744;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=6815745;
 //BA.debugLineNum = 6815745;BA.debugLine="Activity.LoadLayout(\"LFormMetaAhorro\")";
mostCurrent._activity.LoadLayout("LFormMetaAhorro",mostCurrent.activityBA);
RDebugUtils.currentLine=6815746;
 //BA.debugLineNum = 6815746;BA.debugLine="alturaDispositivo = Main.alturaDispositivo";
_alturadispositivo = mostCurrent._main._alturadispositivo /*int*/ ;
RDebugUtils.currentLine=6815747;
 //BA.debugLineNum = 6815747;BA.debugLine="anchoDispositivo = Main.anchoDispositivo";
_anchodispositivo = mostCurrent._main._anchodispositivo /*int*/ ;
RDebugUtils.currentLine=6815748;
 //BA.debugLineNum = 6815748;BA.debugLine="sql = Starter.sql";
_sql = mostCurrent._starter._sql /*anywheresoftware.b4a.sql.SQL*/ ;
RDebugUtils.currentLine=6815749;
 //BA.debugLineNum = 6815749;BA.debugLine="aparicionMsgBox1 = False";
_aparicionmsgbox1 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=6815750;
 //BA.debugLineNum = 6815750;BA.debugLine="aparicionMsgBox2 = False";
_aparicionmsgbox2 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=6815751;
 //BA.debugLineNum = 6815751;BA.debugLine="aparicionMsgBox3 = False";
_aparicionmsgbox3 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=6815752;
 //BA.debugLineNum = 6815752;BA.debugLine="aparicionMsgBox4 = False";
_aparicionmsgbox4 = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=6815755;
 //BA.debugLineNum = 6815755;BA.debugLine="lblNombreVista.TextSize = 20";
mostCurrent._lblnombrevista.setTextSize((float) (20));
RDebugUtils.currentLine=6815756;
 //BA.debugLineNum = 6815756;BA.debugLine="lblNombreVista.TextColor = Colors.Black";
mostCurrent._lblnombrevista.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=6815757;
 //BA.debugLineNum = 6815757;BA.debugLine="lblNombreVista.Height = 30dip";
mostCurrent._lblnombrevista.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=6815758;
 //BA.debugLineNum = 6815758;BA.debugLine="lblNombreVista.Width = anchoDispositivo * 0.9";
mostCurrent._lblnombrevista.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=6815759;
 //BA.debugLineNum = 6815759;BA.debugLine="lblNombreVista.Top = 30dip";
mostCurrent._lblnombrevista.setTop(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=6815760;
 //BA.debugLineNum = 6815760;BA.debugLine="lblNombreVista.Left = (anchoDispositivo - lblNomb";
mostCurrent._lblnombrevista.setLeft((int) ((_anchodispositivo-mostCurrent._lblnombrevista.getWidth())/(double)2));
RDebugUtils.currentLine=6815762;
 //BA.debugLineNum = 6815762;BA.debugLine="txtMetaAhorro.Width = anchoDispositivo * 0.9";
mostCurrent._txtmetaahorro.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=6815763;
 //BA.debugLineNum = 6815763;BA.debugLine="txtMetaAhorro.Height = alturaDispositivo * 0.14";
mostCurrent._txtmetaahorro.setHeight((int) (_alturadispositivo*0.14));
RDebugUtils.currentLine=6815764;
 //BA.debugLineNum = 6815764;BA.debugLine="txtMetaAhorro.Top = lblNombreVista.Top * 1.5 + lb";
mostCurrent._txtmetaahorro.setTop((int) (mostCurrent._lblnombrevista.getTop()*1.5+mostCurrent._lblnombrevista.getHeight()));
RDebugUtils.currentLine=6815765;
 //BA.debugLineNum = 6815765;BA.debugLine="txtMetaAhorro.Left = (anchoDispositivo - txtMetaA";
mostCurrent._txtmetaahorro.setLeft((int) ((_anchodispositivo-mostCurrent._txtmetaahorro.getWidth())/(double)2));
RDebugUtils.currentLine=6815766;
 //BA.debugLineNum = 6815766;BA.debugLine="lblFondoMetaAhorro.Width = txtMetaAhorro.Width";
mostCurrent._lblfondometaahorro.setWidth(mostCurrent._txtmetaahorro.getWidth());
RDebugUtils.currentLine=6815767;
 //BA.debugLineNum = 6815767;BA.debugLine="lblFondoMetaAhorro.Height = txtMetaAhorro.Height";
mostCurrent._lblfondometaahorro.setHeight(mostCurrent._txtmetaahorro.getHeight());
RDebugUtils.currentLine=6815768;
 //BA.debugLineNum = 6815768;BA.debugLine="lblFondoMetaAhorro.Top = txtMetaAhorro.Top";
mostCurrent._lblfondometaahorro.setTop(mostCurrent._txtmetaahorro.getTop());
RDebugUtils.currentLine=6815769;
 //BA.debugLineNum = 6815769;BA.debugLine="lblFondoMetaAhorro.Left = txtMetaAhorro.Left";
mostCurrent._lblfondometaahorro.setLeft(mostCurrent._txtmetaahorro.getLeft());
RDebugUtils.currentLine=6815771;
 //BA.debugLineNum = 6815771;BA.debugLine="lblMetaAhorroTitulo.Width = lblFondoMetaAhorro.Wi";
mostCurrent._lblmetaahorrotitulo.setWidth((int) (mostCurrent._lblfondometaahorro.getWidth()*0.9));
RDebugUtils.currentLine=6815772;
 //BA.debugLineNum = 6815772;BA.debugLine="lblMetaAhorroTitulo.Height = stu.MeasureMultiline";
mostCurrent._lblmetaahorrotitulo.setHeight((int) (mostCurrent._stu.MeasureMultilineTextHeight((android.widget.TextView)(mostCurrent._lblmetaahorrotitulo.getObject()),BA.ObjectToCharSequence(mostCurrent._lblmetaahorrotitulo.getText()))+2));
RDebugUtils.currentLine=6815773;
 //BA.debugLineNum = 6815773;BA.debugLine="lblMetaAhorroTitulo.Top = lblFondoMetaAhorro.Top";
mostCurrent._lblmetaahorrotitulo.setTop((int) (mostCurrent._lblfondometaahorro.getTop()+mostCurrent._lblfondometaahorro.getHeight()*0.05));
RDebugUtils.currentLine=6815774;
 //BA.debugLineNum = 6815774;BA.debugLine="lblMetaAhorroTitulo.Left = lblFondoMetaAhorro.Lef";
mostCurrent._lblmetaahorrotitulo.setLeft((int) (mostCurrent._lblfondometaahorro.getLeft()+mostCurrent._lblfondomontoahorro.getHeight()*0.1));
RDebugUtils.currentLine=6815775;
 //BA.debugLineNum = 6815775;BA.debugLine="lblMetaAhorroTitulo.Gravity = Gravity.CENTER_VERT";
mostCurrent._lblmetaahorrotitulo.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=6815777;
 //BA.debugLineNum = 6815777;BA.debugLine="txtNombre.Width = anchoDispositivo * 0.9";
mostCurrent._txtnombre.setWidth((int) (_anchodispositivo*0.9));
RDebugUtils.currentLine=6815778;
 //BA.debugLineNum = 6815778;BA.debugLine="txtNombre.Height = alturaDispositivo * 0.06";
mostCurrent._txtnombre.setHeight((int) (_alturadispositivo*0.06));
RDebugUtils.currentLine=6815779;
 //BA.debugLineNum = 6815779;BA.debugLine="txtNombre.Top = txtMetaAhorro.Top + txtMetaAhorro";
mostCurrent._txtnombre.setTop((int) (mostCurrent._txtmetaahorro.getTop()+mostCurrent._txtmetaahorro.getHeight()+mostCurrent._lblnombrevista.getTop()/(double)2));
RDebugUtils.currentLine=6815780;
 //BA.debugLineNum = 6815780;BA.debugLine="txtNombre.Left = (anchoDispositivo - txtNombre.Wi";
mostCurrent._txtnombre.setLeft((int) ((_anchodispositivo-mostCurrent._txtnombre.getWidth())/(double)2));
RDebugUtils.currentLine=6815781;
 //BA.debugLineNum = 6815781;BA.debugLine="lblFondoNombre.Width = txtMetaAhorro.Width";
mostCurrent._lblfondonombre.setWidth(mostCurrent._txtmetaahorro.getWidth());
RDebugUtils.currentLine=6815782;
 //BA.debugLineNum = 6815782;BA.debugLine="lblFondoNombre.Height = txtNombre.Height";
mostCurrent._lblfondonombre.setHeight(mostCurrent._txtnombre.getHeight());
RDebugUtils.currentLine=6815783;
 //BA.debugLineNum = 6815783;BA.debugLine="lblFondoNombre.Top = txtNombre.Top";
mostCurrent._lblfondonombre.setTop(mostCurrent._txtnombre.getTop());
RDebugUtils.currentLine=6815784;
 //BA.debugLineNum = 6815784;BA.debugLine="lblFondoNombre.Left = txtNombre.Left";
mostCurrent._lblfondonombre.setLeft(mostCurrent._txtnombre.getLeft());
RDebugUtils.currentLine=6815786;
 //BA.debugLineNum = 6815786;BA.debugLine="txtDescripcion.Width = txtNombre.Width";
mostCurrent._txtdescripcion.setWidth(mostCurrent._txtnombre.getWidth());
RDebugUtils.currentLine=6815787;
 //BA.debugLineNum = 6815787;BA.debugLine="txtDescripcion.Height = txtNombre.Height";
mostCurrent._txtdescripcion.setHeight(mostCurrent._txtnombre.getHeight());
RDebugUtils.currentLine=6815788;
 //BA.debugLineNum = 6815788;BA.debugLine="txtDescripcion.Top = txtNombre.Top + txtNombre.He";
mostCurrent._txtdescripcion.setTop((int) (mostCurrent._txtnombre.getTop()+mostCurrent._txtnombre.getHeight()+mostCurrent._lblnombrevista.getTop()/(double)2));
RDebugUtils.currentLine=6815789;
 //BA.debugLineNum = 6815789;BA.debugLine="txtDescripcion.Left = txtNombre.Left";
mostCurrent._txtdescripcion.setLeft(mostCurrent._txtnombre.getLeft());
RDebugUtils.currentLine=6815790;
 //BA.debugLineNum = 6815790;BA.debugLine="lblFondoDescripcion.Width = txtDescripcion.Width";
mostCurrent._lblfondodescripcion.setWidth(mostCurrent._txtdescripcion.getWidth());
RDebugUtils.currentLine=6815791;
 //BA.debugLineNum = 6815791;BA.debugLine="lblFondoDescripcion.Height = txtDescripcion.Heigh";
mostCurrent._lblfondodescripcion.setHeight(mostCurrent._txtdescripcion.getHeight());
RDebugUtils.currentLine=6815792;
 //BA.debugLineNum = 6815792;BA.debugLine="lblFondoDescripcion.Top = txtDescripcion.Top";
mostCurrent._lblfondodescripcion.setTop(mostCurrent._txtdescripcion.getTop());
RDebugUtils.currentLine=6815793;
 //BA.debugLineNum = 6815793;BA.debugLine="lblFondoDescripcion.Left = txtDescripcion.Left";
mostCurrent._lblfondodescripcion.setLeft(mostCurrent._txtdescripcion.getLeft());
RDebugUtils.currentLine=6815795;
 //BA.debugLineNum = 6815795;BA.debugLine="txtMontoAhorro.Width = txtMetaAhorro.Width";
mostCurrent._txtmontoahorro.setWidth(mostCurrent._txtmetaahorro.getWidth());
RDebugUtils.currentLine=6815796;
 //BA.debugLineNum = 6815796;BA.debugLine="txtMontoAhorro.Height = txtMetaAhorro.Height";
mostCurrent._txtmontoahorro.setHeight(mostCurrent._txtmetaahorro.getHeight());
RDebugUtils.currentLine=6815797;
 //BA.debugLineNum = 6815797;BA.debugLine="txtMontoAhorro.Top = txtDescripcion.Top + txtDesc";
mostCurrent._txtmontoahorro.setTop((int) (mostCurrent._txtdescripcion.getTop()+mostCurrent._txtdescripcion.getHeight()+mostCurrent._lblnombrevista.getTop()/(double)2));
RDebugUtils.currentLine=6815798;
 //BA.debugLineNum = 6815798;BA.debugLine="txtMontoAhorro.Left = txtNombre.Left";
mostCurrent._txtmontoahorro.setLeft(mostCurrent._txtnombre.getLeft());
RDebugUtils.currentLine=6815799;
 //BA.debugLineNum = 6815799;BA.debugLine="lblFondoMontoAhorro.Width = txtMontoAhorro.Width";
mostCurrent._lblfondomontoahorro.setWidth(mostCurrent._txtmontoahorro.getWidth());
RDebugUtils.currentLine=6815800;
 //BA.debugLineNum = 6815800;BA.debugLine="lblFondoMontoAhorro.Height = txtMontoAhorro.Heigh";
mostCurrent._lblfondomontoahorro.setHeight(mostCurrent._txtmontoahorro.getHeight());
RDebugUtils.currentLine=6815801;
 //BA.debugLineNum = 6815801;BA.debugLine="lblFondoMontoAhorro.Top = txtMontoAhorro.Top";
mostCurrent._lblfondomontoahorro.setTop(mostCurrent._txtmontoahorro.getTop());
RDebugUtils.currentLine=6815802;
 //BA.debugLineNum = 6815802;BA.debugLine="lblFondoMontoAhorro.Left = txtMontoAhorro.Left";
mostCurrent._lblfondomontoahorro.setLeft(mostCurrent._txtmontoahorro.getLeft());
RDebugUtils.currentLine=6815804;
 //BA.debugLineNum = 6815804;BA.debugLine="lblMontoAhorroTitulo.Width = lblFondoMontoAhorro.";
mostCurrent._lblmontoahorrotitulo.setWidth((int) (mostCurrent._lblfondomontoahorro.getWidth()*0.9));
RDebugUtils.currentLine=6815805;
 //BA.debugLineNum = 6815805;BA.debugLine="lblMontoAhorroTitulo.Height = stu.MeasureMultilin";
mostCurrent._lblmontoahorrotitulo.setHeight((int) (mostCurrent._stu.MeasureMultilineTextHeight((android.widget.TextView)(mostCurrent._lblmontoahorrotitulo.getObject()),BA.ObjectToCharSequence(mostCurrent._lblmontoahorrotitulo.getText()))+2));
RDebugUtils.currentLine=6815806;
 //BA.debugLineNum = 6815806;BA.debugLine="lblMontoAhorroTitulo.Top = lblFondoMontoAhorro.To";
mostCurrent._lblmontoahorrotitulo.setTop((int) (mostCurrent._lblfondomontoahorro.getTop()+mostCurrent._lblfondomontoahorro.getHeight()*0.05));
RDebugUtils.currentLine=6815807;
 //BA.debugLineNum = 6815807;BA.debugLine="lblMontoAhorroTitulo.Left = lblFondoMontoAhorro.L";
mostCurrent._lblmontoahorrotitulo.setLeft((int) (mostCurrent._lblfondomontoahorro.getLeft()+mostCurrent._lblfondomontoahorro.getHeight()*0.1));
RDebugUtils.currentLine=6815808;
 //BA.debugLineNum = 6815808;BA.debugLine="lblMontoAhorroTitulo.Gravity = Gravity.CENTER_VER";
mostCurrent._lblmontoahorrotitulo.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=6815810;
 //BA.debugLineNum = 6815810;BA.debugLine="pnlSelector.Top = txtMontoAhorro.Top + txtMontoAh";
mostCurrent._pnlselector.setTop((int) (mostCurrent._txtmontoahorro.getTop()+mostCurrent._txtmontoahorro.getHeight()+mostCurrent._lblnombrevista.getTop()/(double)2));
RDebugUtils.currentLine=6815811;
 //BA.debugLineNum = 6815811;BA.debugLine="pnlSelector.Left = txtMontoAhorro.Left + txtMonto";
mostCurrent._pnlselector.setLeft((int) (mostCurrent._txtmontoahorro.getLeft()+mostCurrent._txtmontoahorro.getWidth()-mostCurrent._pnlselector.getWidth()));
RDebugUtils.currentLine=6815813;
 //BA.debugLineNum = 6815813;BA.debugLine="pnlPeriodos.Top = pnlSelector.Top";
mostCurrent._pnlperiodos.setTop(mostCurrent._pnlselector.getTop());
RDebugUtils.currentLine=6815814;
 //BA.debugLineNum = 6815814;BA.debugLine="pnlPeriodos.Left = txtMontoAhorro.Left";
mostCurrent._pnlperiodos.setLeft(mostCurrent._txtmontoahorro.getLeft());
RDebugUtils.currentLine=6815815;
 //BA.debugLineNum = 6815815;BA.debugLine="pnlPeriodos.Width = (txtMontoAhorro.Width - pnlSe";
mostCurrent._pnlperiodos.setWidth((int) ((mostCurrent._txtmontoahorro.getWidth()-mostCurrent._pnlselector.getWidth())*0.9));
RDebugUtils.currentLine=6815816;
 //BA.debugLineNum = 6815816;BA.debugLine="pnlPeriodos.Height = pnlSelector.Height";
mostCurrent._pnlperiodos.setHeight(mostCurrent._pnlselector.getHeight());
RDebugUtils.currentLine=6815819;
 //BA.debugLineNum = 6815819;BA.debugLine="rd1Semana.Width = pnlPeriodos.Width";
mostCurrent._rd1semana.setWidth(mostCurrent._pnlperiodos.getWidth());
RDebugUtils.currentLine=6815820;
 //BA.debugLineNum = 6815820;BA.debugLine="rd1Semana.Height = pnlPeriodos.Height * 0.18";
mostCurrent._rd1semana.setHeight((int) (mostCurrent._pnlperiodos.getHeight()*0.18));
RDebugUtils.currentLine=6815821;
 //BA.debugLineNum = 6815821;BA.debugLine="rd1Semana.Left = 0";
mostCurrent._rd1semana.setLeft((int) (0));
RDebugUtils.currentLine=6815822;
 //BA.debugLineNum = 6815822;BA.debugLine="rd1Semana.Top = 0";
mostCurrent._rd1semana.setTop((int) (0));
RDebugUtils.currentLine=6815824;
 //BA.debugLineNum = 6815824;BA.debugLine="rd2Semanas.Width = rd1Semana.Width";
mostCurrent._rd2semanas.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=6815825;
 //BA.debugLineNum = 6815825;BA.debugLine="rd2Semanas.Height = rd1Semana.Height";
mostCurrent._rd2semanas.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=6815826;
 //BA.debugLineNum = 6815826;BA.debugLine="rd2Semanas.Left = rd1Semana.Left";
mostCurrent._rd2semanas.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=6815827;
 //BA.debugLineNum = 6815827;BA.debugLine="rd2Semanas.Top = rd1Semana.Height + pnlPeriodos.H";
mostCurrent._rd2semanas.setTop((int) (mostCurrent._rd1semana.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=6815829;
 //BA.debugLineNum = 6815829;BA.debugLine="rd3Semanas.Width = rd1Semana.Width";
mostCurrent._rd3semanas.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=6815830;
 //BA.debugLineNum = 6815830;BA.debugLine="rd3Semanas.Height = rd1Semana.Height";
mostCurrent._rd3semanas.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=6815831;
 //BA.debugLineNum = 6815831;BA.debugLine="rd3Semanas.Left = rd1Semana.Left";
mostCurrent._rd3semanas.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=6815832;
 //BA.debugLineNum = 6815832;BA.debugLine="rd3Semanas.Top = rd2Semanas.Top + rd2Semanas.Heig";
mostCurrent._rd3semanas.setTop((int) (mostCurrent._rd2semanas.getTop()+mostCurrent._rd2semanas.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=6815834;
 //BA.debugLineNum = 6815834;BA.debugLine="rd1Mes.Width = rd1Semana.Width";
mostCurrent._rd1mes.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=6815835;
 //BA.debugLineNum = 6815835;BA.debugLine="rd1Mes.Height = rd1Semana.Height";
mostCurrent._rd1mes.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=6815836;
 //BA.debugLineNum = 6815836;BA.debugLine="rd1Mes.Left = rd1Semana.Left";
mostCurrent._rd1mes.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=6815837;
 //BA.debugLineNum = 6815837;BA.debugLine="rd1Mes.Top = rd3Semanas.Top + rd3Semanas.Height +";
mostCurrent._rd1mes.setTop((int) (mostCurrent._rd3semanas.getTop()+mostCurrent._rd3semanas.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=6815839;
 //BA.debugLineNum = 6815839;BA.debugLine="rd1Ano.Width = rd1Semana.Width";
mostCurrent._rd1ano.setWidth(mostCurrent._rd1semana.getWidth());
RDebugUtils.currentLine=6815840;
 //BA.debugLineNum = 6815840;BA.debugLine="rd1Ano.Height = rd1Semana.Height";
mostCurrent._rd1ano.setHeight(mostCurrent._rd1semana.getHeight());
RDebugUtils.currentLine=6815841;
 //BA.debugLineNum = 6815841;BA.debugLine="rd1Ano.Left = rd1Semana.Left";
mostCurrent._rd1ano.setLeft(mostCurrent._rd1semana.getLeft());
RDebugUtils.currentLine=6815842;
 //BA.debugLineNum = 6815842;BA.debugLine="rd1Ano.Top = rd1Mes.Top + rd1Mes.Height + pnlPeri";
mostCurrent._rd1ano.setTop((int) (mostCurrent._rd1mes.getTop()+mostCurrent._rd1mes.getHeight()+mostCurrent._pnlperiodos.getHeight()*0.025));
RDebugUtils.currentLine=6815847;
 //BA.debugLineNum = 6815847;BA.debugLine="pnlNavInferior.Height = alturaDispositivo * 0.08";
mostCurrent._pnlnavinferior.setHeight((int) (_alturadispositivo*0.08));
RDebugUtils.currentLine=6815848;
 //BA.debugLineNum = 6815848;BA.debugLine="pnlNavInferior.Width = anchoDispositivo";
mostCurrent._pnlnavinferior.setWidth(_anchodispositivo);
RDebugUtils.currentLine=6815849;
 //BA.debugLineNum = 6815849;BA.debugLine="pnlNavInferior.Left = 0";
mostCurrent._pnlnavinferior.setLeft((int) (0));
RDebugUtils.currentLine=6815850;
 //BA.debugLineNum = 6815850;BA.debugLine="pnlNavInferior.Top = alturaDispositivo - pnlNavIn";
mostCurrent._pnlnavinferior.setTop((int) (_alturadispositivo-mostCurrent._pnlnavinferior.getHeight()));
RDebugUtils.currentLine=6815853;
 //BA.debugLineNum = 6815853;BA.debugLine="btnMenu.Width = anchoDispositivo * 0.15";
mostCurrent._btnmenu.setWidth((int) (_anchodispositivo*0.15));
RDebugUtils.currentLine=6815854;
 //BA.debugLineNum = 6815854;BA.debugLine="btnMenu.Height = btnMenu.Width";
mostCurrent._btnmenu.setHeight(mostCurrent._btnmenu.getWidth());
RDebugUtils.currentLine=6815855;
 //BA.debugLineNum = 6815855;BA.debugLine="btnMenu.Top = pnlNavInferior.Top - btnMenu.Height";
mostCurrent._btnmenu.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._btnmenu.getHeight()/(double)2));
RDebugUtils.currentLine=6815856;
 //BA.debugLineNum = 6815856;BA.debugLine="btnMenu.Left = (anchoDispositivo - btnMenu.Width)";
mostCurrent._btnmenu.setLeft((int) ((_anchodispositivo-mostCurrent._btnmenu.getWidth())/(double)2));
RDebugUtils.currentLine=6815858;
 //BA.debugLineNum = 6815858;BA.debugLine="lblContornoBoton.Width = anchoDispositivo * 0.17";
mostCurrent._lblcontornoboton.setWidth((int) (_anchodispositivo*0.17));
RDebugUtils.currentLine=6815859;
 //BA.debugLineNum = 6815859;BA.debugLine="lblContornoBoton.Height = lblContornoBoton.Width";
mostCurrent._lblcontornoboton.setHeight(mostCurrent._lblcontornoboton.getWidth());
RDebugUtils.currentLine=6815860;
 //BA.debugLineNum = 6815860;BA.debugLine="lblContornoBoton.Left = (anchoDispositivo - lblCo";
mostCurrent._lblcontornoboton.setLeft((int) ((_anchodispositivo-mostCurrent._lblcontornoboton.getWidth())/(double)2));
RDebugUtils.currentLine=6815861;
 //BA.debugLineNum = 6815861;BA.debugLine="lblContornoBoton.Top = pnlNavInferior.Top - lblCo";
mostCurrent._lblcontornoboton.setTop((int) (mostCurrent._pnlnavinferior.getTop()-mostCurrent._lblcontornoboton.getHeight()/(double)2));
RDebugUtils.currentLine=6815866;
 //BA.debugLineNum = 6815866;BA.debugLine="btnOperacionMetaAhorro.Text = \"Editar meta de aho";
mostCurrent._btnoperacionmetaahorro.setText(BA.ObjectToCharSequence("Editar meta de ahorro"));
RDebugUtils.currentLine=6815867;
 //BA.debugLineNum = 6815867;BA.debugLine="btnOperacionMetaAhorro.Top = pnlPeriodos.Top + pn";
mostCurrent._btnoperacionmetaahorro.setTop((int) (mostCurrent._pnlperiodos.getTop()+mostCurrent._pnlperiodos.getHeight()+(mostCurrent._lblcontornoboton.getTop()-(mostCurrent._pnlperiodos.getTop()+mostCurrent._pnlperiodos.getHeight()+mostCurrent._btnoperacionmetaahorro.getHeight()))/(double)2));
RDebugUtils.currentLine=6815868;
 //BA.debugLineNum = 6815868;BA.debugLine="btnOperacionMetaAhorro.Left = (anchoDispositivo -";
mostCurrent._btnoperacionmetaahorro.setLeft((int) ((_anchodispositivo-mostCurrent._btnoperacionmetaahorro.getWidth())/(double)2));
RDebugUtils.currentLine=6815869;
 //BA.debugLineNum = 6815869;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="editarmetaahorro";
RDebugUtils.currentLine=6946816;
 //BA.debugLineNum = 6946816;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=6946817;
 //BA.debugLineNum = 6946817;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="editarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=6881280;
 //BA.debugLineNum = 6881280;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=6881281;
 //BA.debugLineNum = 6881281;BA.debugLine="End Sub";
return "";
}
public static pullup.wallet.main._registrometaahorro  _asignacioncampos() throws Exception{
RDebugUtils.currentModule="editarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "asignacioncampos", false))
	 {return ((pullup.wallet.main._registrometaahorro) Debug.delegate(mostCurrent.activityBA, "asignacioncampos", null));}
pullup.wallet.main._registrometaahorro _metaahorro = null;
RDebugUtils.currentLine=7864320;
 //BA.debugLineNum = 7864320;BA.debugLine="Sub asignacionCampos As RegistroMetaAhorro";
RDebugUtils.currentLine=7864321;
 //BA.debugLineNum = 7864321;BA.debugLine="Dim metaAhorro As RegistroMetaAhorro";
_metaahorro = new pullup.wallet.main._registrometaahorro();
RDebugUtils.currentLine=7864323;
 //BA.debugLineNum = 7864323;BA.debugLine="metaAhorro.montoMeta = txtMetaAhorro.Text";
_metaahorro.montoMeta /*int*/  = (int)(Double.parseDouble(mostCurrent._txtmetaahorro.getText()));
RDebugUtils.currentLine=7864325;
 //BA.debugLineNum = 7864325;BA.debugLine="metaAhorro.montoAhorro = txtMontoAhorro.Text";
_metaahorro.montoAhorro /*int*/  = (int)(Double.parseDouble(mostCurrent._txtmontoahorro.getText()));
RDebugUtils.currentLine=7864327;
 //BA.debugLineNum = 7864327;BA.debugLine="metaAhorro.nombre = txtNombre.Text";
_metaahorro.nombre /*String*/  = mostCurrent._txtnombre.getText();
RDebugUtils.currentLine=7864329;
 //BA.debugLineNum = 7864329;BA.debugLine="metaAhorro.descripcion = (txtDescripcion.Text)";
_metaahorro.descripcion /*String*/  = (mostCurrent._txtdescripcion.getText());
RDebugUtils.currentLine=7864331;
 //BA.debugLineNum = 7864331;BA.debugLine="metaAhorro.periodo = diasPeriodo";
_metaahorro.periodo /*int*/  = _diasperiodo;
RDebugUtils.currentLine=7864333;
 //BA.debugLineNum = 7864333;BA.debugLine="metaAhorro.progreso = 0";
_metaahorro.progreso /*int*/  = (int) (0);
RDebugUtils.currentLine=7864335;
 //BA.debugLineNum = 7864335;BA.debugLine="metaAhorro.color = colorCaja";
_metaahorro.color /*int*/  = _colorcaja;
RDebugUtils.currentLine=7864337;
 //BA.debugLineNum = 7864337;BA.debugLine="Return metaAhorro";
if (true) return _metaahorro;
RDebugUtils.currentLine=7864338;
 //BA.debugLineNum = 7864338;BA.debugLine="End Sub";
return null;
}
public static String  _btnmenu_click() throws Exception{
RDebugUtils.currentModule="editarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnmenu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnmenu_click", null));}
RDebugUtils.currentLine=7012352;
 //BA.debugLineNum = 7012352;BA.debugLine="Private Sub btnMenu_Click";
RDebugUtils.currentLine=7012353;
 //BA.debugLineNum = 7012353;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=7012354;
 //BA.debugLineNum = 7012354;BA.debugLine="End Sub";
return "";
}
public static String  _btnoperacionmetaahorro_click() throws Exception{
RDebugUtils.currentModule="editarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnoperacionmetaahorro_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnoperacionmetaahorro_click", null));}
boolean _validaciones = false;
pullup.wallet.main._registrometaahorro _metaahorroregistrar = null;
RDebugUtils.currentLine=7929856;
 //BA.debugLineNum = 7929856;BA.debugLine="Private Sub btnOperacionMetaAhorro_Click";
RDebugUtils.currentLine=7929857;
 //BA.debugLineNum = 7929857;BA.debugLine="Dim validaciones As Boolean";
_validaciones = false;
RDebugUtils.currentLine=7929859;
 //BA.debugLineNum = 7929859;BA.debugLine="validaciones = validarCampos";
_validaciones = _validarcampos();
RDebugUtils.currentLine=7929860;
 //BA.debugLineNum = 7929860;BA.debugLine="If(validaciones = True) Then";
if ((_validaciones==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=7929862;
 //BA.debugLineNum = 7929862;BA.debugLine="Dim metaAhorroRegistrar As RegistroMetaAhorro";
_metaahorroregistrar = new pullup.wallet.main._registrometaahorro();
RDebugUtils.currentLine=7929863;
 //BA.debugLineNum = 7929863;BA.debugLine="metaAhorroRegistrar = asignacionCampos";
_metaahorroregistrar = _asignacioncampos();
RDebugUtils.currentLine=7929866;
 //BA.debugLineNum = 7929866;BA.debugLine="Starter.sql.ExecNonQuery2(\"UPDATE metas_ahorro S";
mostCurrent._starter._sql /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("UPDATE metas_ahorro SET monto_meta = ?, nombre = ?, descripcion = ?, monto_ahorro = ?, periodo_ahorro = ?, color = ?  WHERE id_meta_ahorro = '"+BA.NumberToString(_idregistro)+"'",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_metaahorroregistrar.montoMeta /*int*/ ),(Object)(_metaahorroregistrar.nombre /*String*/ ),(Object)(_metaahorroregistrar.descripcion /*String*/ ),(Object)(_metaahorroregistrar.montoAhorro /*int*/ ),(Object)(_metaahorroregistrar.periodo /*int*/ ),(Object)(_metaahorroregistrar.color /*int*/ )}));
RDebugUtils.currentLine=7929868;
 //BA.debugLineNum = 7929868;BA.debugLine="ToastMessageShow(\"Meta de ahorro editada\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Meta de ahorro editada"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7929870;
 //BA.debugLineNum = 7929870;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=7929872;
 //BA.debugLineNum = 7929872;BA.debugLine="StartActivity(MetasDeAhorro)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._metasdeahorro.getObject()));
 }else {
RDebugUtils.currentLine=7929875;
 //BA.debugLineNum = 7929875;BA.debugLine="Msgbox2(\"Por favor, rellene todos los campos, se";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Por favor, rellene todos los campos, seleccione un periodo y color"),BA.ObjectToCharSequence("Registro incorrecto"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 };
RDebugUtils.currentLine=7929877;
 //BA.debugLineNum = 7929877;BA.debugLine="End Sub";
return "";
}
public static boolean  _validarcampos() throws Exception{
RDebugUtils.currentModule="editarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "validarcampos", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "validarcampos", null));}
RDebugUtils.currentLine=7077888;
 //BA.debugLineNum = 7077888;BA.debugLine="Sub validarCampos As Boolean";
RDebugUtils.currentLine=7077889;
 //BA.debugLineNum = 7077889;BA.debugLine="If(txtMetaAhorro.Text.Length <> 0 And txtNombre.T";
if ((mostCurrent._txtmetaahorro.getText().length()!=0 && mostCurrent._txtnombre.getText().length()!=0 && mostCurrent._txtmontoahorro.getText().length()!=0 && mostCurrent._txtdescripcion.getText().length()!=0 && _colorcaja!=0 && _diasperiodo!=0)) { 
RDebugUtils.currentLine=7077890;
 //BA.debugLineNum = 7077890;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=7077892;
 //BA.debugLineNum = 7077892;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=7077894;
 //BA.debugLineNum = 7077894;BA.debugLine="End Sub";
return false;
}
public static String  _consultaaeditar(int _rowid) throws Exception{
RDebugUtils.currentModule="editarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "consultaaeditar", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "consultaaeditar", new Object[] {_rowid}));}
pullup.wallet.main._registrometaahorro _metaahorro = null;
RDebugUtils.currentLine=7995392;
 //BA.debugLineNum = 7995392;BA.debugLine="Sub consultaAEditar(rowid As Int)";
RDebugUtils.currentLine=7995393;
 //BA.debugLineNum = 7995393;BA.debugLine="Dim metaAhorro As RegistroMetaAhorro";
_metaahorro = new pullup.wallet.main._registrometaahorro();
RDebugUtils.currentLine=7995394;
 //BA.debugLineNum = 7995394;BA.debugLine="idRegistro = rowid";
_idregistro = _rowid;
RDebugUtils.currentLine=7995396;
 //BA.debugLineNum = 7995396;BA.debugLine="cur = sql.ExecQuery(\"SELECT * FROM metas_ahorro W";
mostCurrent._cur = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM metas_ahorro WHERE id_meta_ahorro = '"+BA.NumberToString(_idregistro)+"'")));
RDebugUtils.currentLine=7995397;
 //BA.debugLineNum = 7995397;BA.debugLine="If(cur.RowCount > 0) Then";
if ((mostCurrent._cur.getRowCount()>0)) { 
RDebugUtils.currentLine=7995398;
 //BA.debugLineNum = 7995398;BA.debugLine="cur.Position = 0";
mostCurrent._cur.setPosition((int) (0));
RDebugUtils.currentLine=7995399;
 //BA.debugLineNum = 7995399;BA.debugLine="metaAhorro.nombre = cur.GetString(\"nombre\")";
_metaahorro.nombre /*String*/  = mostCurrent._cur.GetString("nombre");
RDebugUtils.currentLine=7995400;
 //BA.debugLineNum = 7995400;BA.debugLine="metaAhorro.montoMeta = cur.GetInt(\"monto_meta\")";
_metaahorro.montoMeta /*int*/  = mostCurrent._cur.GetInt("monto_meta");
RDebugUtils.currentLine=7995401;
 //BA.debugLineNum = 7995401;BA.debugLine="metaAhorro.montoAhorro = cur.GetInt(\"monto_ahorr";
_metaahorro.montoAhorro /*int*/  = mostCurrent._cur.GetInt("monto_ahorro");
RDebugUtils.currentLine=7995402;
 //BA.debugLineNum = 7995402;BA.debugLine="metaAhorro.descripcion = cur.GetString(\"descripc";
_metaahorro.descripcion /*String*/  = mostCurrent._cur.GetString("descripcion");
RDebugUtils.currentLine=7995403;
 //BA.debugLineNum = 7995403;BA.debugLine="metaAhorro.periodo = cur.GetInt(\"periodo_ahorro\"";
_metaahorro.periodo /*int*/  = mostCurrent._cur.GetInt("periodo_ahorro");
RDebugUtils.currentLine=7995404;
 //BA.debugLineNum = 7995404;BA.debugLine="metaAhorro.color = cur.GetString(\"color\")";
_metaahorro.color /*int*/  = (int)(Double.parseDouble(mostCurrent._cur.GetString("color")));
RDebugUtils.currentLine=7995406;
 //BA.debugLineNum = 7995406;BA.debugLine="reasignarCamposAEditar(metaAhorro)";
_reasignarcamposaeditar(_metaahorro);
 };
RDebugUtils.currentLine=7995408;
 //BA.debugLineNum = 7995408;BA.debugLine="End Sub";
return "";
}
public static String  _reasignarcamposaeditar(pullup.wallet.main._registrometaahorro _registro) throws Exception{
RDebugUtils.currentModule="editarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "reasignarcamposaeditar", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "reasignarcamposaeditar", new Object[] {_registro}));}
RDebugUtils.currentLine=8060928;
 //BA.debugLineNum = 8060928;BA.debugLine="Sub reasignarCamposAEditar(registro As RegistroMet";
RDebugUtils.currentLine=8060929;
 //BA.debugLineNum = 8060929;BA.debugLine="txtNombre.Text = registro.nombre";
mostCurrent._txtnombre.setText(BA.ObjectToCharSequence(_registro.nombre /*String*/ ));
RDebugUtils.currentLine=8060930;
 //BA.debugLineNum = 8060930;BA.debugLine="txtMetaAhorro.Text = registro.montoMeta";
mostCurrent._txtmetaahorro.setText(BA.ObjectToCharSequence(_registro.montoMeta /*int*/ ));
RDebugUtils.currentLine=8060931;
 //BA.debugLineNum = 8060931;BA.debugLine="txtMontoAhorro.Text = registro.montoAhorro";
mostCurrent._txtmontoahorro.setText(BA.ObjectToCharSequence(_registro.montoAhorro /*int*/ ));
RDebugUtils.currentLine=8060932;
 //BA.debugLineNum = 8060932;BA.debugLine="txtDescripcion.Text = registro.descripcion";
mostCurrent._txtdescripcion.setText(BA.ObjectToCharSequence(_registro.descripcion /*String*/ ));
RDebugUtils.currentLine=8060933;
 //BA.debugLineNum = 8060933;BA.debugLine="Select registro.periodo";
switch (BA.switchObjectToInt(_registro.periodo /*int*/ ,(int) (7),(int) (14),(int) (21),(int) (30),(int) (365))) {
case 0: {
RDebugUtils.currentLine=8060935;
 //BA.debugLineNum = 8060935;BA.debugLine="rd1Semana.Checked = True";
mostCurrent._rd1semana.setChecked(anywheresoftware.b4a.keywords.Common.True);
 break; }
case 1: {
RDebugUtils.currentLine=8060937;
 //BA.debugLineNum = 8060937;BA.debugLine="rd2Semanas.Checked = True";
mostCurrent._rd2semanas.setChecked(anywheresoftware.b4a.keywords.Common.True);
 break; }
case 2: {
RDebugUtils.currentLine=8060939;
 //BA.debugLineNum = 8060939;BA.debugLine="rd3Semanas.Checked = True";
mostCurrent._rd3semanas.setChecked(anywheresoftware.b4a.keywords.Common.True);
 break; }
case 3: {
RDebugUtils.currentLine=8060941;
 //BA.debugLineNum = 8060941;BA.debugLine="rd1Mes.Checked = True";
mostCurrent._rd1mes.setChecked(anywheresoftware.b4a.keywords.Common.True);
 break; }
case 4: {
RDebugUtils.currentLine=8060943;
 //BA.debugLineNum = 8060943;BA.debugLine="rd1Ano.Checked = True";
mostCurrent._rd1ano.setChecked(anywheresoftware.b4a.keywords.Common.True);
 break; }
}
;
RDebugUtils.currentLine=8060945;
 //BA.debugLineNum = 8060945;BA.debugLine="diasPeriodo = registro.periodo";
_diasperiodo = _registro.periodo /*int*/ ;
RDebugUtils.currentLine=8060946;
 //BA.debugLineNum = 8060946;BA.debugLine="cpBarraColor_ColorChanged(registro.color)";
_cpbarracolor_colorchanged(_registro.color /*int*/ );
RDebugUtils.currentLine=8060947;
 //BA.debugLineNum = 8060947;BA.debugLine="End Sub";
return "";
}
public static String  _cpbarracolor_colorchanged(int _color) throws Exception{
RDebugUtils.currentModule="editarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cpbarracolor_colorchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cpbarracolor_colorchanged", new Object[] {_color}));}
RDebugUtils.currentLine=7143424;
 //BA.debugLineNum = 7143424;BA.debugLine="Private Sub cpBarraColor_ColorChanged(color As Int";
RDebugUtils.currentLine=7143425;
 //BA.debugLineNum = 7143425;BA.debugLine="lblFondoMontoAhorro.Color = color";
mostCurrent._lblfondomontoahorro.setColor(_color);
RDebugUtils.currentLine=7143426;
 //BA.debugLineNum = 7143426;BA.debugLine="lblFondoMetaAhorro.Color = color";
mostCurrent._lblfondometaahorro.setColor(_color);
RDebugUtils.currentLine=7143427;
 //BA.debugLineNum = 7143427;BA.debugLine="colorCaja = color";
_colorcaja = _color;
RDebugUtils.currentLine=7143428;
 //BA.debugLineNum = 7143428;BA.debugLine="End Sub";
return "";
}
public static String  _limitarlongitudentrada(String _antiguo,String _nuevo,int _longitud,anywheresoftware.b4a.objects.B4XViewWrapper _view,String _campo) throws Exception{
RDebugUtils.currentModule="editarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "limitarlongitudentrada", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "limitarlongitudentrada", new Object[] {_antiguo,_nuevo,_longitud,_view,_campo}));}
RDebugUtils.currentLine=7208960;
 //BA.debugLineNum = 7208960;BA.debugLine="Sub limitarLongitudEntrada(antiguo As String, nuev";
RDebugUtils.currentLine=7208961;
 //BA.debugLineNum = 7208961;BA.debugLine="If(nuevo.Length > longitud) Then";
if ((_nuevo.length()>_longitud)) { 
RDebugUtils.currentLine=7208962;
 //BA.debugLineNum = 7208962;BA.debugLine="If(campo = \"montoAhorro\") Then";
if (((_campo).equals("montoAhorro"))) { 
RDebugUtils.currentLine=7208963;
 //BA.debugLineNum = 7208963;BA.debugLine="If(aparicionMsgBox1 = False) Then";
if ((_aparicionmsgbox1==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=7208964;
 //BA.debugLineNum = 7208964;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para el monto del ahorro es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=7208965;
 //BA.debugLineNum = 7208965;BA.debugLine="aparicionMsgBox1 = True";
_aparicionmsgbox1 = anywheresoftware.b4a.keywords.Common.True;
 };
 }else 
{RDebugUtils.currentLine=7208967;
 //BA.debugLineNum = 7208967;BA.debugLine="Else If(campo = \"metaAhorro\") Then";
if (((_campo).equals("metaAhorro"))) { 
RDebugUtils.currentLine=7208968;
 //BA.debugLineNum = 7208968;BA.debugLine="If(aparicionMsgBox2 = False) Then";
if ((_aparicionmsgbox2==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=7208969;
 //BA.debugLineNum = 7208969;BA.debugLine="Msgbox2(\"La longitud máxima permitida para la";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para la monto meta es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=7208970;
 //BA.debugLineNum = 7208970;BA.debugLine="aparicionMsgBox2 = True";
_aparicionmsgbox2 = anywheresoftware.b4a.keywords.Common.True;
 };
 }else 
{RDebugUtils.currentLine=7208972;
 //BA.debugLineNum = 7208972;BA.debugLine="Else If(campo = \"nombre\") Then";
if (((_campo).equals("nombre"))) { 
RDebugUtils.currentLine=7208973;
 //BA.debugLineNum = 7208973;BA.debugLine="If(aparicionMsgBox3 = False) Then";
if ((_aparicionmsgbox3==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=7208974;
 //BA.debugLineNum = 7208974;BA.debugLine="Msgbox2(\"La longitud máxima permitida para el";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para el nombre es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=7208975;
 //BA.debugLineNum = 7208975;BA.debugLine="aparicionMsgBox3 = True";
_aparicionmsgbox3 = anywheresoftware.b4a.keywords.Common.True;
 };
 }else 
{RDebugUtils.currentLine=7208977;
 //BA.debugLineNum = 7208977;BA.debugLine="Else If(campo = \"descripcion\") Then";
if (((_campo).equals("descripcion"))) { 
RDebugUtils.currentLine=7208978;
 //BA.debugLineNum = 7208978;BA.debugLine="If(aparicionMsgBox4 = False) Then";
if ((_aparicionmsgbox4==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=7208979;
 //BA.debugLineNum = 7208979;BA.debugLine="Msgbox2(\"La longitud máxima permitida para la";
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("La longitud máxima permitida para la descripción es de "+BA.NumberToString(_longitud)+" caracteres"),BA.ObjectToCharSequence("Límite alcanzado"),"Entendido","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
RDebugUtils.currentLine=7208980;
 //BA.debugLineNum = 7208980;BA.debugLine="aparicionMsgBox4 = True";
_aparicionmsgbox4 = anywheresoftware.b4a.keywords.Common.True;
 };
 }}}}
;
RDebugUtils.currentLine=7208983;
 //BA.debugLineNum = 7208983;BA.debugLine="view.Text = antiguo";
_view.setText(BA.ObjectToCharSequence(_antiguo));
 };
RDebugUtils.currentLine=7208985;
 //BA.debugLineNum = 7208985;BA.debugLine="End Sub";
return "";
}
public static String  _rd1ano_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="editarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd1ano_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd1ano_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=7798784;
 //BA.debugLineNum = 7798784;BA.debugLine="Private Sub rd1Ano_CheckedChange(Checked As Boolea";
RDebugUtils.currentLine=7798785;
 //BA.debugLineNum = 7798785;BA.debugLine="diasPeriodo = 365";
_diasperiodo = (int) (365);
RDebugUtils.currentLine=7798786;
 //BA.debugLineNum = 7798786;BA.debugLine="End Sub";
return "";
}
public static String  _rd1mes_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="editarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd1mes_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd1mes_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=7733248;
 //BA.debugLineNum = 7733248;BA.debugLine="Private Sub rd1Mes_CheckedChange(Checked As Boolea";
RDebugUtils.currentLine=7733249;
 //BA.debugLineNum = 7733249;BA.debugLine="diasPeriodo = 30";
_diasperiodo = (int) (30);
RDebugUtils.currentLine=7733250;
 //BA.debugLineNum = 7733250;BA.debugLine="End Sub";
return "";
}
public static String  _rd1semana_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="editarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd1semana_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd1semana_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=7667712;
 //BA.debugLineNum = 7667712;BA.debugLine="Private Sub rd1Semana_CheckedChange(Checked As Boo";
RDebugUtils.currentLine=7667713;
 //BA.debugLineNum = 7667713;BA.debugLine="diasPeriodo = 7";
_diasperiodo = (int) (7);
RDebugUtils.currentLine=7667714;
 //BA.debugLineNum = 7667714;BA.debugLine="End Sub";
return "";
}
public static String  _rd2semanas_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="editarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd2semanas_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd2semanas_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=7602176;
 //BA.debugLineNum = 7602176;BA.debugLine="Private Sub rd2Semanas_CheckedChange(Checked As Bo";
RDebugUtils.currentLine=7602177;
 //BA.debugLineNum = 7602177;BA.debugLine="diasPeriodo = 14";
_diasperiodo = (int) (14);
RDebugUtils.currentLine=7602178;
 //BA.debugLineNum = 7602178;BA.debugLine="End Sub";
return "";
}
public static String  _rd3semanas_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="editarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rd3semanas_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rd3semanas_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=7536640;
 //BA.debugLineNum = 7536640;BA.debugLine="Private Sub rd3Semanas_CheckedChange(Checked As Bo";
RDebugUtils.currentLine=7536641;
 //BA.debugLineNum = 7536641;BA.debugLine="diasPeriodo = 21";
_diasperiodo = (int) (21);
RDebugUtils.currentLine=7536642;
 //BA.debugLineNum = 7536642;BA.debugLine="End Sub";
return "";
}
public static String  _txtdescripcion_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="editarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtdescripcion_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtdescripcion_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=7471104;
 //BA.debugLineNum = 7471104;BA.debugLine="Private Sub txtDescripcion_TextChanged (Old As Str";
RDebugUtils.currentLine=7471105;
 //BA.debugLineNum = 7471105;BA.debugLine="limitarLongitudEntrada(Old, New, 41, txtDescripci";
_limitarlongitudentrada(_old,_new,(int) (41),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtdescripcion.getObject())),"descripcion");
RDebugUtils.currentLine=7471106;
 //BA.debugLineNum = 7471106;BA.debugLine="End Sub";
return "";
}
public static String  _txtmetaahorro_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="editarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtmetaahorro_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtmetaahorro_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=7405568;
 //BA.debugLineNum = 7405568;BA.debugLine="Private Sub txtMetaAhorro_TextChanged (Old As Stri";
RDebugUtils.currentLine=7405569;
 //BA.debugLineNum = 7405569;BA.debugLine="limitarLongitudEntrada(Old, New, 9, txtMetaAhorro";
_limitarlongitudentrada(_old,_new,(int) (9),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtmetaahorro.getObject())),"metaAhorro");
RDebugUtils.currentLine=7405570;
 //BA.debugLineNum = 7405570;BA.debugLine="End Sub";
return "";
}
public static String  _txtmontoahorro_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="editarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtmontoahorro_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtmontoahorro_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=7340032;
 //BA.debugLineNum = 7340032;BA.debugLine="Private Sub txtMontoAhorro_TextChanged (Old As Str";
RDebugUtils.currentLine=7340033;
 //BA.debugLineNum = 7340033;BA.debugLine="limitarLongitudEntrada(Old ,New, 9, txtMontoAhorr";
_limitarlongitudentrada(_old,_new,(int) (9),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtmontoahorro.getObject())),"montoAhorro");
RDebugUtils.currentLine=7340034;
 //BA.debugLineNum = 7340034;BA.debugLine="End Sub";
return "";
}
public static String  _txtnombre_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="editarmetaahorro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtnombre_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtnombre_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=7274496;
 //BA.debugLineNum = 7274496;BA.debugLine="Private Sub txtNombre_TextChanged (Old As String,";
RDebugUtils.currentLine=7274497;
 //BA.debugLineNum = 7274497;BA.debugLine="limitarLongitudEntrada(Old, New, 16, txtNombre, \"";
_limitarlongitudentrada(_old,_new,(int) (16),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._txtnombre.getObject())),"nombre");
RDebugUtils.currentLine=7274498;
 //BA.debugLineNum = 7274498;BA.debugLine="End Sub";
return "";
}
}