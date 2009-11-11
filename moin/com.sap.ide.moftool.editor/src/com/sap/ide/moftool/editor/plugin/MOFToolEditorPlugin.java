/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG (MITG:V0.1) (EditorPlugin.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.plugin;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPluginDescriptor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import com.sap.ide.moftool.editor.exec.ExecMOFToolDefaultImpl;
import com.sap.ide.moftool.editor.provider.MOFToolLabelProvider;
import com.sap.mi.fwk.mm.MetamodelManager;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.util.LinkUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ide.metamodels.MoinDeploymentException;

/**
 * @generated modified
 */
public class MOFToolEditorPlugin extends AbstractUIPlugin {

	public static final String LAYOUT_VERTICAL = "LAYOUT_VERTICAL"; //$NON-NLS-1$
	public static final String LAYOUT_VERTICAL_DISABLED = "LAYOUT_VERTICAL_DISABLED"; //$NON-NLS-1$
	public static final String LAYOUT_HORIZONTAL_DISABLED = "LAYOUT_HORIZONTAL_DISABLED"; //$NON-NLS-1$
	public static final String LAYOUT_HORIZONTAL = "LAYOUT_HORIZONTAL"; //$NON-NLS-1$

	/**
	 * // currently defaulted
	 * 
	 * @generated
	 */
	public static final String ID = "com.sap.ide.moftool.editor"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String PLUGIN_MAINPROJECT = "mi.tools"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String PLUGIN_SUBPROJECT = "_com.sap.ide.moftool.editor"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String METAMODEL_NATURE_ID = "com.sap.tc.moin.nwdi.dctype.mm.MoinMetaModelNature"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String METAMODEL_TAG = "Model"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final String ATN_CLASSES = "ATN_Classes"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private boolean mImageRegistryInitialized;

	/**
	 * @generated
	 */
	public static final String ATN_tcnf_MofRoot = "ATN_tcnf_MofRoot"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String ATN_tumcnf_UsedMMRoot = "ATN_tumcnf_UsedMMRoot"; //$NON-NLS-1$

	/**
	 * @modified
	 */
	public static final String ATN_tumcnf_UsedMMDCs = "ATN_tumcnf_UsedMMDCs"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String ATN_tco_TCO_NodeInParameters = "ATN_tco_TCO_NodeInParameters"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String ATN_tco_TCO_NodeOutParameters = "ATN_tco_TCO_NodeOutParameters"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String ATN_tco_TCO_NodeInOutParameters = "ATN_tco_TCO_NodeInOutParameters"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String ATN_tco_TCO_NodeTags = "ATN_tco_TCO_NodeTags"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String ATN_tce_TCE_NodeParameters = "ATN_tce_TCE_NodeParameters"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String ATN_tce_TCE_NodeTags = "ATN_tce_TCE_NodeTags"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String ATN_tpa_TPA_NodeAssociationEnds = "ATN_tpa_TPA_NodeAssociationEnds"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String ATN_tpa_TPA_NodeReferences = "ATN_tpa_TPA_NodeReferences"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String ATN_tpa_TPA_NodeConstraints = "ATN_tpa_TPA_NodeConstraints"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String ATN_tpa_TPA_NodeTags = "ATN_tpa_TPA_NodeTags"; //$NON-NLS-1$

	public static final String ATN_tcnf_AssocContainer = "ATN_tcnf_AssocContainer"; //$NON-NLS-1$

	// The shared instance.
	/**
	 * @generated
	 */
	private static MOFToolEditorPlugin sPlugin;

	/**
	 * @generated
	 */
	public MOFToolEditorPlugin() {
		super();
		sPlugin = this;
//		assureMetamodelsLoaded();
	}

	/**
	 * @generated
	 */
	public static MOFToolEditorPlugin getDefault() {
		if (sPlugin == null) {
			sPlugin = new MOFToolEditorPlugin();
		}
		return sPlugin;
	}

	/**
	 * @modified
	 */
	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		super.initializeImageRegistry(reg);
		this.mImageRegistryInitialized = true;
		URL lInstallURL = null;
		try {
			Bundle bundle = Platform.getBundle(ID); // 
			lInstallURL = Platform.resolve(bundle.getEntry("/")); //$NON-NLS-1$ 
		} catch (IOException e) {
			logError(e);
			return;
		}

		addImageDescriptorToRegistryIfPresent(reg, ATN_tcnf_AssocContainer, lInstallURL,
				"resources/icons/tree/tcnf/ATN_AssocContainer.gif"); //$NON-NLS-1$

		addImageDescriptorToRegistryIfPresent(reg, ATN_tcnf_MofRoot, lInstallURL,
				"resources/icons/tree/tcnf/ATN_MofRoot.gif"); //$NON-NLS-1$

		addImageDescriptorToRegistryIfPresent(reg, ATN_tumcnf_UsedMMRoot, lInstallURL,
				"resources/icons/tree/tumcnf/ATN_UsedMMRoot.gif"); //$NON-NLS-1$

		addImageDescriptorToRegistryIfPresent(reg, ATN_tumcnf_UsedMMDCs, lInstallURL,
				"resources/icons/tree/tumcnf/ATN_UsedMMDCs.gif"); //$NON-NLS-1$

		addImageDescriptorToRegistryIfPresent(reg, LAYOUT_HORIZONTAL, lInstallURL,
				"resources/icons/layouthorizontal.gif"); //$NON-NLS-1$
		addImageDescriptorToRegistryIfPresent(reg, LAYOUT_VERTICAL, lInstallURL, "resources/icons/layoutvertical.gif"); //$NON-NLS-1$
		addImageDescriptorToRegistryIfPresent(reg, LAYOUT_HORIZONTAL_DISABLED, lInstallURL,
				"resources/icons/layouthorizontal_disabled.gif"); //$NON-NLS-1$
		addImageDescriptorToRegistryIfPresent(reg, LAYOUT_VERTICAL_DISABLED, lInstallURL,
				"resources/icons/layoutvertical_disabled.gif"); //$NON-NLS-1$

		String mmclasses[] = new String[] {
				"Class", "Diagram", "EnumerationType", "Package", "StructureType", "Association", null }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
		for (String cl : mmclasses) {
			if (cl != null) {
				addImageDescriptorToRegistryIfPresent(reg,
						"metamodel/" + cl, lInstallURL, "resources/icons/metamodel/" + cl + ".gif"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
		}
	}

	/**
	 * @generated
	 */
	public Image getImage(String key) {
		return getImageRegistry().get(key);
	}

	/**
	 * @generated
	 */
	public ImageDescriptor getImageDescriptor(String key) {
		return getImageRegistry().getDescriptor(key);
	}

	/**
	 * @generated
	 */
	public static void logError(Exception e) {
		String msg = e.getMessage();
		if (msg == null)
			msg = String.valueOf(e);
		getDefault().getLog().log(new Status(IStatus.ERROR, MOFToolEditorPlugin.ID, IStatus.OK, msg, e));
	}

	/**
	 * @generated
	 */
	public static void logWarning(String msg) {
		if (msg == null)
			msg = "no message"; //$NON-NLS-1$
		getDefault().getLog().log(new Status(IStatus.WARNING, MOFToolEditorPlugin.ID, IStatus.OK, msg, null));
	}

	/**
	 * Executor Factory methods.
	 * 
	 * @generated
	 */
	private ExecMOFToolDefaultImpl mDefaultExecutor = null;

	/**
	 * @generated
	 */
	public synchronized ExecMOFToolDefaultImpl getExecMOFToolDefault() {
		if (mDefaultExecutor == null) {
			mDefaultExecutor = new ExecMOFToolDefaultImpl();
		}
		return mDefaultExecutor;
	}

	/**
	 * @generated
	 */
	public static Object resolveInputToRootIfPossible(Object input) {
		if (input instanceof RefBaseObject)
			return input;
		if (input instanceof IAdaptable) {
			Object obj = null;
			if (null != (obj = ((IAdaptable) input).getAdapter(RefPackage.class))) {
				RefPackage root = (RefPackage) obj; // JMIReflection.MMBridge.getRoot((RefPackage)
													// obj,MofPackage.class);
				return root;
			}
		}
		if (input instanceof RefPackage) {
			RefPackage root = (RefPackage) input; // JMIReflection.MMBridge.getRoot((RefPackage)input,MofPackage.class);
			return root;
		}
		return input;
	}

	/**
	 * @generated
	 */
	public static RefPackage getRoot(Connection co) {
		RefPackage rp = co.getPackage(CONTAINERNAME_Model, METAMODEL_TAG);
		if (rp == null)
			logError(new IllegalStateException("Cannot locate metamodel root (RefPackage) " + METAMODEL_TAG)); //$NON-NLS-1$
		return rp;
	}

	/**
	 * Add image to Image registry reg if the resource (installURL + location) can be loaded. (Clients complained about
	 * the default not present image beeing shown, preferring null )
	 * 
	 * @param reg
	 * @param key
	 * @param installURL
	 * @param location
	 * @generated
	 */
	private void addImageDescriptorToRegistryIfPresent(ImageRegistry reg, String key, URL installURL, String location) {
		URL u = null;
		try {
			u = new URL(installURL, location);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		try {
			Object ux = u.getContent();
		} catch (IOException e) {
			logWarning("Resource " + location + " for key " + key + " not found"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			return; //        
		}
		ImageDescriptor id = ImageDescriptor.createFromURL(u);
		reg.put(key, id);
	}

	/**
	 * given an object, (even an Graphics editor edit part), return the underlying Business Object!
	 * 
	 * @generated
	 */
	public static RefObject getBusinessRefObject(Object object) {
		//		
		RefObject result = (RefObject) Platform.getAdapterManager().getAdapter(object, RefObject.class);
		if (result != null && !(result instanceof PictogramElement)) {
			return result;
		}

		// unwrap a StructuredSelection
		if (object instanceof IStructuredSelection) {
			object = ((IStructuredSelection) object).getFirstElement();
		}
		// do it yourself
		if (object instanceof EditPart) {
			EditPart editPart = (EditPart) object;
			Object model = editPart.getModel();
			if (model instanceof PictogramElement) {
				PictogramElement pe = (PictogramElement) model;
				RefObject[] objects = LinkUtil.getAllBusinessObjectsForLinkedPictogramElement(pe);
				// take the first domain object that is an instance
				// of the given adapter class
				for (RefObject businessobject : objects) {
					return businessobject; // return the
					// first(!)
				}
			}
		}

		return ModelAdapterUI.getInstance().getRefObject(object);
	}

	/**
	 * @generated
	 */
	public static String CONTAINERNAME_Model = "sap.com/tc/moin/mof_1.4"; //$NON-NLS-1$

	/**
	 * @modified
	 */
	public static String CONTAINERNAME_GFW = "sap.com/com/sap/mi/gfw/mm"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static String[] CONTAINERNAMES = new String[] { "sap.com/tc/moin/mof_1.4", "sap.com/com/sap/mi/gfw/mm", //$NON-NLS-1$ //$NON-NLS-2$
			"sap.com/com/sap/mi/gfw/mm" //$NON-NLS-1$

	};

//	/**
//	 * @generated
//	 */
//	public void assureMetamodelsLoaded() {
//		try {
//			MetamodelManager.getInstance().importMetamodels(null, CONTAINERNAMES);
//		} catch (MoinDeploymentException e) {
//			logError(e);
//		}
//	}

	/**
	 * @generated
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		this.mLabelProvider = null;
		if (this.mImageRegistryInitialized) { // avoid creation on exit
			this.getImageRegistry().dispose();
		}
		super.stop(context);
		sPlugin = null;
	}

	/**
	 * @generated
	 */
	ILabelProvider mLabelProvider = null;

	/**
	 * @generated
	 */
	public ILabelProvider getLabelProvider() {
		if (this.mLabelProvider == null) {
			this.mLabelProvider = new MOFToolLabelProvider();
		}
		return this.mLabelProvider;
	}

}
