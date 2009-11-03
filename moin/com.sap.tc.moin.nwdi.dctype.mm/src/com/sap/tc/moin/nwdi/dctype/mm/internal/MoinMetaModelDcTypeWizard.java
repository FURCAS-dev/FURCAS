package com.sap.tc.moin.nwdi.dctype.mm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.Bundle;

import com.sap.ide.dii05.lib.api.util.DiiResourceService;
import com.sap.mi.fwk.dcfwk.ui.NewMoinDcWizard;
import com.sap.tc.moin.nwdi.dctype.mm.MoinMetaModelDcType;
import com.sap.tc.moin.nwdi.dctype.mm.internal.preferences.PreferenceInitializer;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;
import com.tssap.util.ui.dialog.UserDialog;

public class MoinMetaModelDcTypeWizard extends NewMoinDcWizard {

	private static final TracerI sTracer = TracingManager.getTracer(MoinMetaModelDcTypeWizard.class);

	public MoinMetaModelDcTypeWizard() {
		super( );
	}


	protected String getDcTypeId( ) {
		return MoinMetaModelDcType.DC_TYPE_ID;
	}

	protected String getWizardTitle( ) {
		return LocalizationMessages.MoinMetaModelDcTypeWizard_0;
	}

	@Override
	public boolean performFinish() {
		// Create new DC
		if (!super.performFinish()) {
			return false;
		}
		
		// Ask user to create plugin wrapper as well
		if (UserDialog.openQuestion(getShell(), LocalizationMessages.MoinMetaModelDcTypeWizard_1,
				LocalizationMessages.MoinMetaModelDcTypeWizard_2,
				MoinMetaModelDCTypePlugin.getDefault().getPreferenceStore(),
				PreferenceInitializer.CREATE_WRAPPER_PLUGIN_WITH_METAMODEL_DC)) {
			// Find the new project
			IProject project = DiiResourceService.getProject(getResultDc());
			if (project == null) {
				IllegalArgumentException e = new IllegalArgumentException("Project for new DC not found."); //$NON-NLS-X$ //$NON-NLS-1$
				sTracer.error(e.getMessage(), e);
				return false;
			}
			
			// Create wizard class
			Wizard wizard = createWrapperPluginWizard(project);
			
			final WizardDialog dialog = new WizardDialog(getShell(), wizard);
			Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						dialog.open();
					}	
				});
		}
		
		return true;
	}

	/*
	 * Do not call, only public for technical reasons
	 */
	public Wizard createWrapperPluginWizard(IProject project) {
		Class<?> classObject = null;
		String bundleName = "com.sap.ide.moftool.editor"; //$NON-NLS-X$ //$NON-NLS-1$
		Bundle bundle = Platform.getBundle(bundleName);
		if (bundle == null) {	
			IllegalArgumentException e = new IllegalArgumentException("Bundle not found. Bundle name = " + //$NON-NLS-X$ //$NON-NLS-1$
					bundleName);
			sTracer.error(e.getMessage(), e);
			return null;
		}
				
		String className = "com.sap.ide.moftool.editor.core.ui.wizards.plugin.CreateJaProPluginProjectWizard"; //$NON-NLS-X$ //$NON-NLS-1$
		try {
			classObject = bundle.loadClass(className);
		}
		catch (ClassNotFoundException e) {
			sTracer.error(e.getMessage(), e);
			return null;
		}
		
		Object result = null;
		
		try {
			Constructor<?> constructor = classObject.getConstructor(IProject.class);
			result = constructor.newInstance(project);
		}
		catch (NoSuchMethodException e) {	
			sTracer.error(e.getMessage(), e);
			return null;
		}
		catch (InstantiationException e) {	
			sTracer.error(e.getMessage(), e);
			return null;
		}
		catch (InvocationTargetException e) {
			sTracer.error(e.getMessage(), e);
			return null;
		}
		catch (IllegalAccessException e) {
			sTracer.error(e.getMessage(), e);
			return null;
		}
		
		Wizard wizard = null;
		if (result instanceof Wizard) {
			wizard = (Wizard)result;
		}
		
		return wizard;
	}
}
