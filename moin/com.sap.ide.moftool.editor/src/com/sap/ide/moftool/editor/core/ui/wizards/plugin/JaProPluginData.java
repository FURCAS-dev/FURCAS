package com.sap.ide.moftool.editor.core.ui.wizards.plugin;

import org.eclipse.core.resources.IProject;

import com.sap.mi.fwk.dcfwk.DCHelper;

public class JaProPluginData {

	private IProject mProject = null;

	private String mMetamodelMainProjectLocation = null;
	private String mVendor = null;
	private String mMetamodelDcName = null;
	private String mMetamodelName = null;

	private String mPluginMainProjectLocation = null;
	private String mPluginCodeline = null;
	private boolean mCreateNewPluginMainProject = false;

	private String mPluginId = null;
	private String mVendorName = null;
	private String mMailResponsible = null;
	private String mCsnComponent = null;

	private String mExportPackages = null;
	private String mMetamodelGuidPackage = null;

	private boolean mAddToPerforce = false;
	private boolean mImportProject = true;

	public JaProPluginData(IProject project) {
		super();
		// mAddToPerforce = DCFwk.isLocalDevelopmentDC(project);

		mProject = project;
		if (DCHelper.getInstance().isDC(project) && !DCHelper.getInstance().isLocalDevelopmentDC(project)) {
			mAddToPerforce = true;
		}
	}

	/**
	 * @return the mMetamodelMainProjectName
	 */
	public String getMetamodelMainProjectLocation() {
		return mMetamodelMainProjectLocation;
	}

	/**
	 * @param metamodelMainProjectName
	 *            the mMetamodelMainProjectName to set
	 */
	public void setMetamodelMainProjectLocation(String metamodelMainProjectLocation) {
		mMetamodelMainProjectLocation = metamodelMainProjectLocation;
	}

	/**
	 * @return the mVendor
	 */
	public String getVendor() {
		return mVendor;
	}

	/**
	 * @param vendor
	 *            the mVendor to set
	 */
	public void setVendor(String vendor) {
		mVendor = vendor;
	}

	/**
	 * @return the mMetamodelDcName
	 */
	public String getMetamodelDcName() {
		return mMetamodelDcName;
	}

	/**
	 * @param metamodelDcName
	 *            the mMetamodelDcName to set
	 */
	public void setMetamodelDcName(String metamodelDcName) {
		mMetamodelDcName = metamodelDcName;
	}

	/**
	 * @return the mMetamodelName
	 */
	public String getMetamodelName() {
		return mMetamodelName;
	}

	/**
	 * @param metamodelName
	 *            the mMetamodelName to set
	 */
	public void setMetamodelName(String metamodelName) {
		mMetamodelName = metamodelName;
	}

	/**
	 * @return the mProject
	 */
	public IProject getProject() {
		return mProject;
	}

	/**
	 * @return the mPluginMainProjectLocation
	 */
	public String getPluginMainProjectLocation() {
		return mPluginMainProjectLocation;
	}

	/**
	 * @param pluginMainProjectLocation
	 *            the mPluginMainProjectLocation to set
	 */
	public void setPluginMainProjectLocation(String pluginMainProjectLocation) {
		mPluginMainProjectLocation = pluginMainProjectLocation;
	}

	/**
	 * @return the mPluginCodeline
	 */
	public String getPluginCodeline() {
		return mPluginCodeline;
	}

	/**
	 * @param pluginCodeline
	 *            the mPluginCodeline to set
	 */
	public void setPluginCodeline(String pluginCodeline) {
		mPluginCodeline = pluginCodeline;
	}

	/**
	 * @return the mPluginName
	 */
	public String getPluginId() {
		return mPluginId;
	}

	/**
	 * @param pluginName
	 *            the mPluginName to set
	 */
	public void setPluginId(String pluginName) {
		mPluginId = pluginName;
	}

	/**
	 * @return the mVendorName
	 */
	public String getVendorName() {
		return mVendorName;
	}

	/**
	 * @param vendorName
	 *            the mVendorName to set
	 */
	public void setVendorName(String vendorName) {
		mVendorName = vendorName;
	}

	/**
	 * @return the mMailResponsible
	 */
	public String getMailResponsible() {
		return mMailResponsible;
	}

	/**
	 * @param mailResponsible
	 *            the mMailResponsible to set
	 */
	public void setMailResponsible(String mailResponsible) {
		mMailResponsible = mailResponsible;
	}

	/**
	 * @return the mCsnComponent
	 */
	public String getCsnComponent() {
		return mCsnComponent;
	}

	/**
	 * @param csnComponent
	 *            the mCsnComponent to set
	 */
	public void setCsnComponent(String csnComponent) {
		mCsnComponent = csnComponent;
	}

	/**
	 * @return the mExportPackages
	 */
	public String getExportPackages() {
		return mExportPackages;
	}

	/**
	 * @param exportPackages
	 *            the mExportPackages to set
	 */
	public void setExportPackages(String exportPackages) {
		mExportPackages = exportPackages;
	}

	/**
	 * @return the mMetamodelGuid
	 */
	public String getMetamodelGuidPackage() {
		return mMetamodelGuidPackage;
	}

	/**
	 * @param metamodelGuidPackage
	 *            the mMetamodelGuid to set
	 */
	public void setMetamodelGuidPackage(String metamodelGuidPackage) {
		mMetamodelGuidPackage = metamodelGuidPackage;
	}

	/**
	 * @return the mCreateNewPluginMainProject
	 */
	public boolean isCreateNewPluginMainProject() {
		return mCreateNewPluginMainProject;
	}

	/**
	 * @param createNewPluginMainProject
	 *            the mCreateNewPluginMainProject to set
	 */
	public void setCreateNewPluginMainProject(boolean createNewPluginMainProject) {
		mCreateNewPluginMainProject = createNewPluginMainProject;
	}

	/**
	 * @return the mAddToPerforce
	 */
	public boolean isAddToPerforce() {
		return mAddToPerforce;
	}

	/**
	 * @param addToPerforce
	 *            the mAddToPerforce to set
	 */
	public void setAddToPerforce(boolean addToPerforce) {
		mAddToPerforce = addToPerforce;
	}

	/**
	 * @return the mImportProject
	 */
	public boolean isImportProject() {
		return mImportProject;
	}

	/**
	 * @param importProject
	 *            the mImportProject to set
	 */
	public void setImportProject(boolean importProject) {
		mImportProject = importProject;
	}
}
