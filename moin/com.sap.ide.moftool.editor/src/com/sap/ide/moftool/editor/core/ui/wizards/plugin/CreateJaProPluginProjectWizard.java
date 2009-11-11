package com.sap.ide.moftool.editor.core.ui.wizards.plugin;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
import org.osgi.framework.Bundle;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.ide.moftool.editor.core.commands.InternalErrorException;
import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.dcfwk.DCHelper;
import com.sap.mi.tools.mmbuilder.AddNatureHandler;
import com.sap.tc.moin.friends.factory.UtilitiesFactory;
import com.sap.tc.moin.repository.Connection;

public class CreateJaProPluginProjectWizard extends Wizard implements INewWizard {

	private String mWindowTitle = LocalizationMessages.CreateJaProPluginProjectWizard_0_XGRP;

	private JaProPluginData mData = null;

	private MainProjectWizardPage mMainProjectWizardPage = null;
	private SubProjectWizardPage mSubProjectWizardPage = null;

	/*
	 * Do not change signature! Dynamically called from
	 * MoinMetaModelDcTypeWizard#performFinish()
	 */
	public CreateJaProPluginProjectWizard(IProject project) {
		super();
		setWindowTitle(mWindowTitle);
		mData = new JaProPluginData(project);
		initialize();
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		super.addPages();
		addPage(mMainProjectWizardPage);
		addPage(mSubProjectWizardPage);
	}

	@Override
	public boolean performFinish() {
		PluginProjectGenerator generator = new PluginProjectGenerator(mData);
		try {
			getContainer().run(true, true, generator);
		} catch (InvocationTargetException e) {
			MOFToolEditorPlugin.logError(e);
		} catch (InterruptedException e) {
			// Canceled by user
			return true;
		}

		// Add to perforce
		if (mData.isAddToPerforce()) {
			// Open select Perforce client dialog
			Dialog dialog = getSetConnectionDialog();
			if (dialog == null) {
				return false;
			}
			if (dialog.open() == Dialog.OK) {
				// Get the Perforce connection parameters
				Object connectionParams = getConnectionParams(dialog);

				if (connectionParams != null) {
					// Get the client
					String client = getClient(connectionParams);
					if (client == null) {
						return false;
					}
					ArrayList<File> perforceFiles = generator.getNewFiles();
					for (Iterator<File> it = perforceFiles.iterator(); it.hasNext();) {
						File file = (File) it.next();
						try {
							Runtime.getRuntime().exec("p4 -c " + client + " add " + file.getCanonicalPath()); //$NON-NLS-1$ //$NON-NLS-2$
						} catch (IOException e) {
							MOFToolEditorPlugin.logError(e);
							return false;
						}
					}
				}
			}
		}

		// Start JaPro subproject import wizard
		if (mData.isImportProject()) {
			// Create wizard class
			Wizard wizard = getImportWizard();

			final WizardDialog wizardDialog = new WizardDialog(getShell(), wizard);
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					// Remember projects opened before importer
					IProject[] oldProjects = ResourcesPlugin.getWorkspace().getRoot().getProjects();

					// Start import wizard
					wizardDialog.open();

					// Find new project
					IProject wrapperProject = null;
					IProject[] newProjects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
					for (int i = 0; i < newProjects.length; i++) {
						boolean found = false;
						for (int j = 0; j < oldProjects.length; j++) {
							if (newProjects[i] != null && newProjects[i].equals(oldProjects[j])) {
								found = true;
								break;
							}
						}
						if (!found) {
							wrapperProject = newProjects[i];
							break;
						}
					}
					if (wrapperProject == null) {
						return;
					}

					// Add metamodel builder
					AddNatureHandler handler = new AddNatureHandler();
					try {
						handler.addNature(wrapperProject, mData.getProject(), null);
					} catch (Exception e) {
						MOFToolEditorPlugin.logError(e);
					}
				}
			});
		}

		return true;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle(mWindowTitle);
	}

	private void initialize() {
		Properties dcInfo = DCHelper.getInstance().getDCInfo(mData.getProject());
//		IDcProject dcProject = DiiResourceService.getDcProject(mData.getProject());
		if (dcInfo == null) {
			MOFToolEditorPlugin.logError(new InternalErrorException("No DC found for project '" + mData.getProject().getName() + "'")); //$NON-NLS-1$ //$NON-NLS-2$
			return;
		}

		// Metamodel DC name
		String metamodelDcName = dcInfo.getProperty(DCHelper.NAME, null);
		if (metamodelDcName == null || metamodelDcName.length() == 0) {
			MOFToolEditorPlugin.logError(new InternalErrorException("No valid DC name found")); //$NON-NLS-1$
			return;
		}
		// Replace '/' with '~'
		metamodelDcName = metamodelDcName.replace('/', '~');
		mData.setMetamodelDcName(metamodelDcName);

		// Metamodel vendor
		String vendor = dcInfo.getProperty(DCHelper.VENDOR, null);
		if (vendor == null || vendor.length() == 0) {
			MOFToolEditorPlugin.logError(new InternalErrorException("No valid vendor found")); //$NON-NLS-1$
			return;
		}
		mData.setVendor(vendor);

		// Metamodel display name
		String metamodelName = dcInfo.getProperty(DCHelper.NAME, null);
		if (metamodelName == null || metamodelName.length() == 0) {
			MOFToolEditorPlugin.logError(new InternalErrorException("No valid DC display name found")); //$NON-NLS-1$
			return;
		}
		mData.setMetamodelName(metamodelName);

		// Metamodel JaPro main project location
		// TODO retrieve from JaPro integration
		IPath metamodelDcPath = mData.getProject().getLocation();
		// Find DC vendor folder
		String lastSegment = metamodelDcPath.lastSegment();
		while (lastSegment != null && !lastSegment.equals(vendor)) {
			metamodelDcPath = metamodelDcPath.removeLastSegments(1);
			lastSegment = metamodelDcPath.lastSegment();
		}
		// Remove path hierarchy until JaPro main project
		metamodelDcPath = metamodelDcPath.removeLastSegments(7);
		// Metamodel main project name (is current folder's name)
		String metamodelMainProjectLocation = ""; //$NON-NLS-1$
		if (metamodelDcPath != null) {
			metamodelMainProjectLocation = metamodelDcPath.toString();
		}
		mData.setMetamodelMainProjectLocation(metamodelMainProjectLocation);

		// Plugin project location (initialize empty)
		mData.setCreateNewPluginMainProject(false);
		mData.setPluginMainProjectLocation(""); //$NON-NLS-1$

		// Plugin codeline
		// TODO retrieve from JaPro integration ?
		metamodelDcPath = mData.getProject().getLocation();
		int segments = new Path(metamodelMainProjectLocation).segmentCount();
		metamodelDcPath = metamodelDcPath.removeFirstSegments(segments);
		String pluginCodeline = null;
		if (metamodelDcPath != null) {
			pluginCodeline = metamodelDcPath.segment(0);
			if (pluginCodeline == null) {
				pluginCodeline = ""; //$NON-NLS-1$
			}
			if (pluginCodeline.indexOf("Dev") == -1) { //$NON-NLS-1$
				// Does not contain Dev -> assume invalid folder found ->
				// replace
				pluginCodeline = "CoreDev_stream"; //$NON-NLS-1$
			}
		}
		mData.setPluginCodeline(pluginCodeline);

		mMainProjectWizardPage = new MainProjectWizardPage(mData);

		// Plugin ID
		vendor = dcInfo.getProperty(DCHelper.VENDOR, null);
		String pluginId = ""; //$NON-NLS-1$
		while (vendor.lastIndexOf('.') != -1) {
			int index = vendor.lastIndexOf('.');
			pluginId = pluginId + vendor.substring(index + 1) + "."; //$NON-NLS-1$
			vendor = vendor.substring(0, index);
		}
		String revertedVendor = pluginId + vendor;
		pluginId = revertedVendor + "." + metamodelDcName.replace('~', '.') + ".mm.eclipse"; //$NON-NLS-1$ //$NON-NLS-2$
		while (pluginId.indexOf('/') != -1) {
			pluginId = pluginId.replace('/', '.');
		}
		// Prevent JaPro build error (occurs when a plugin name contains a
		// single underscore
		pluginId = pluginId.replaceAll("_", "__"); //$NON-NLS-1$ //$NON-NLS-2$
		mData.setPluginId(pluginId);

		// Vendor name
		vendor = dcInfo.getProperty(DCHelper.VENDOR, null);
		String vendorName = ""; //$NON-NLS-1$
		String mailResponsible = ""; //$NON-NLS-1$
		if (vendor.indexOf("sap.com") != -1) { //$NON-NLS-1$
			vendorName = "SAP AG"; //$NON-NLS-1$
			mailResponsible = "@sap.com"; //$NON-NLS-1$
		}
		mData.setVendorName(vendorName);

		// Mail responsible
		mData.setMailResponsible(mailResponsible);

		// CSN component
		mData.setCsnComponent(""); //$NON-NLS-1$

		mSubProjectWizardPage = new SubProjectWizardPage(mData);

		// Metamodel GUID
		String metamodelGuidPackage = callGetMmPackageQualified(vendor + "/" + metamodelDcName.replace('~', '/')); //$NON-NLS-1$
		mData.setMetamodelGuidPackage(metamodelGuidPackage);

		// Export packages
		List<String> allPackageNames = getAllPackages();
		allPackageNames.add("com.sap.tc.moin"); // $NON-NLS-X$ //$NON-NLS-1$
		allPackageNames.add(metamodelGuidPackage);
		Iterator<String> it = allPackageNames.iterator();
		String exportPackages = ""; //$NON-NLS-1$
		while (it.hasNext()) {
			String next = it.next();
			if (exportPackages.length() != 0) {
				exportPackages = exportPackages + "," + System.getProperty("line.separator") + " "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			exportPackages = exportPackages + next;
		}
		mData.setExportPackages(exportPackages);
	}

	private List<String> getAllPackages() {		

		Connection connection = MofService.createConnectionWithBusyCursorWhile(mData.getProject()); 
		if (connection == null) {
			return new ArrayList<String>();
		}	

		RefBaseObject baseObject = MOFToolEditorPlugin.getRoot(connection);
		Collection<MofPackage> packages = MofService.getAvailablePackages(connection);
		Iterator<MofPackage> it = packages.iterator();
		ArrayList<String> allPackageNames = new ArrayList<String>(packages.size() * 2 + 2);
		while (it.hasNext()) {
			RefBaseObject object = it.next();
				MofPackage mofPackage = (MofPackage) object;
				String qualifiedName = UtilitiesFactory.getMoinUtil().getJmiPackageName(mofPackage);
				allPackageNames.add(qualifiedName);
				allPackageNames.add(qualifiedName + ".__impl"); //$NON-NLS-1$
		}
		return allPackageNames;
	}

	/*
	 * Do not call, only public for technical reasons
	 */
	public Dialog getSetConnectionDialog() {
		Class<?> classObject = null;
		String bundleName = "com.perforce.team.ui";  //$NON-NLS-1$
		Bundle bundle = Platform.getBundle(bundleName);
		if (bundle == null) {
			IllegalArgumentException e = new IllegalArgumentException("Bundle not found. Bundle name = " +  //$NON-NLS-1$
					bundleName);
			MOFToolEditorPlugin.logError(e);
			return null;
		}

		String className = "com.perforce.team.ui.dialogs.SetConnectionDialog";  //$NON-NLS-1$
		try {
			classObject = bundle.loadClass(className);
		} catch (ClassNotFoundException e) {
			MOFToolEditorPlugin.logError(e);
			return null;
		}

		Object result = null;

		try {
			Constructor<?> constructor = classObject.getConstructor(Shell.class);
			result = constructor.newInstance(getShell());
		} catch (NoSuchMethodException e) {
			MOFToolEditorPlugin.logError(e);
			return null;
		} catch (InstantiationException e) {
			MOFToolEditorPlugin.logError(e);
			return null;
		} catch (InvocationTargetException e) {
			MOFToolEditorPlugin.logError(e);
			return null;
		} catch (IllegalAccessException e) {
			MOFToolEditorPlugin.logError(e);
			return null;
		}

		if (result instanceof Dialog) {
			return (Dialog) result;
		}

		return null;
	}

	/*
	 * Do not call, only public for technical reasons
	 */
	public Object getConnectionParams(Dialog dialog) {
		Object result = null;
		try {
			Method method = dialog.getClass().getMethod("getConnectionParams");  //$NON-NLS-1$
			result = method.invoke(dialog);
		} catch (NoSuchMethodException e) {
			MOFToolEditorPlugin.logError(e);
			return null;
		} catch (InvocationTargetException e) {
			MOFToolEditorPlugin.logError(e);
			return null;
		} catch (IllegalAccessException e) {
			MOFToolEditorPlugin.logError(e);
			return null;
		}
		return result;
	}

	/*
	 * Do not call, only public for technical reasons
	 */
	public String getClient(Object connectionParams) {
		Object result = null;
		try {
			Method method = connectionParams.getClass().getMethod("getClient");  //$NON-NLS-1$
			result = method.invoke(connectionParams);
		} catch (NoSuchMethodException e) {
			MOFToolEditorPlugin.logError(e);
			return null;
		} catch (InvocationTargetException e) {
			MOFToolEditorPlugin.logError(e);
			return null;
		} catch (IllegalAccessException e) {
			MOFToolEditorPlugin.logError(e);
			return null;
		}

		if (result instanceof String) {
			return (String) result;
		}

		return null;
	}

	/*
	 * Do not call, only public for technical reasons
	 */
	public Wizard getImportWizard() {
		Class<?> classObject = null;
		String bundleName = "com.sap.tools.japro.ui";  //$NON-NLS-1$
		Bundle bundle = Platform.getBundle(bundleName);
		if (bundle == null) {
			IllegalArgumentException e = new IllegalArgumentException("Bundle not found. Bundle name = " +  //$NON-NLS-1$
					bundleName);
			MOFToolEditorPlugin.logError(e);
			return null;
		}

		String className = "com.sap.tools.japro.wizards.imports.JaproPluginProjImportWizard";  //$NON-NLS-1$
		try {
			classObject = bundle.loadClass(className);
		} catch (ClassNotFoundException e) {
			MOFToolEditorPlugin.logError(e);
			return null;
		}

		Object result = null;

		try {
			Constructor<?> constructor = classObject.getConstructor();
			result = constructor.newInstance();
		} catch (NoSuchMethodException e) {
			MOFToolEditorPlugin.logError(e);
			return null;
		} catch (InstantiationException e) {
			MOFToolEditorPlugin.logError(e);
			return null;
		} catch (InvocationTargetException e) {
			MOFToolEditorPlugin.logError(e);
			return null;
		} catch (IllegalAccessException e) {
			MOFToolEditorPlugin.logError(e);
			return null;
		}

		if (result instanceof Wizard) {
			return (Wizard) result;
		}

		return null;
	}

	/*
	 * Do not call, only public for technical reasons
	 */
	public String callGetMmPackageQualified(String metamodelName) {
		Class<?> classObject = null;
		String bundleName = "com.sap.tc.moin.libraries.base";  //$NON-NLS-1$
		Bundle bundle = Platform.getBundle(bundleName);
		if (bundle == null) {
			IllegalArgumentException e = new IllegalArgumentException("Bundle not found. Bundle name = " +  //$NON-NLS-1$
					bundleName);
			MOFToolEditorPlugin.logError(e);
			return null;
		}

		String className = "com.sap.tc.moin.repository.shared.util.Utilities";  //$NON-NLS-1$
		try {
			classObject = bundle.loadClass(className);
		} catch (ClassNotFoundException e) {
			MOFToolEditorPlugin.logError(e);
			return null;
		}

		Object result = null;
		try {
			Method method = classObject.getMethod("getMMPackageQualified", String.class);  //$NON-NLS-1$
			result = method.invoke(null, metamodelName);
		} catch (NoSuchMethodException e) {
			MOFToolEditorPlugin.logError(e);
			return null;
		} catch (InvocationTargetException e) {
			MOFToolEditorPlugin.logError(e);
			return null;
		} catch (IllegalAccessException e) {
			MOFToolEditorPlugin.logError(e);
			return null;
		}

		if (result instanceof String) {
			return (String) result;
		}
		return null;
	}
}
