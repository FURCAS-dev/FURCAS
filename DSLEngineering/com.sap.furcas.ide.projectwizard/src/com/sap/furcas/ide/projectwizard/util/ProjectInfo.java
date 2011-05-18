package com.sap.furcas.ide.projectwizard.util;

import com.sap.furcas.ide.projectwizard.wizards.SelectionPage;

/**
 * Saves all the information entered in the wizard. See the variables for detailed information.
 * 
 * @author Frederik Petersen (D054528)
 * 
 */
public class ProjectInfo {

    /**
     * The name of the language project as entered on the {@link}LanguagePage.
     */
    private String projectName = "";

    /**
     * The name of the language as entered on the {@link}LanguagePage.
     */
    private String languageName = "";

    /**
     * The languages file extension as entered on the {@link}LanguagePage.
     */
    private String fileExtension = "";

    /**
     * The nsURI of the metamodel as entered on the {@link SelectionPage} if new Metamodel project creation is chosen.
     */
    private String nsURI = "";

    /**
     * Stores the name of the first class that is used for the main template in the language. When new Metamodel project creation
     * is chosen it will be assigned on the {@link}SelectionPage. If not it will be assigned on the {@link}ClassChooserPage.
     */
    private String className = "";

    /**
     * Is not directly entered by the user but gets assigned on the {@link}LoadPage. It stores the Path to a referenced metamodel
     * if needed.
     */
    private String modelPath = "";

    /**
     * Will be true if an existing metamodel will be loaded and false if a new Metamodel project will be created.
     */
    private boolean loadMetamodel = false;

    /**
     * Will be true if loading an existing metamodel from workspace OR if loading the metamodel from a freshly created metamodel
     * project. Will be false if loading from registered packages.
     */
    private boolean fromWorkspace = false;

	private String mmBundleName;

    /**
     * 
     * @return The file extension.
     */
    public String getFileExtension() {
        return fileExtension;
    }

    /**
     * 
     * @param fileExtension
     */
    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    /**
     * 
     * @return The language name.
     */
    public String getLanguageName() {
        return languageName;
    }

    /**
     * 
     * @param languageName
     */
    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    /**
     * 
     * @return The namespace URI.
     */
    public String getNsURI() {
        return nsURI;
    }

    /**
     * 
     * @param nsURI
     */
    public void setNsURI(String nsURI) {
        this.nsURI = nsURI;
    }

    /**
     * 
     * @return The project name.
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 
     * @param projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 
     * @return The tcs filename.
     */
    public String getTCSFileName() {
        String tcsFile = getLanguageName().replaceAll("\\s", "_") + ".tcs";
        return CreateProject.capitalizeFirstChar(tcsFile);
    }

    /**
     * 
     * @return The projects basepath.
     */
    public String getBasePath() {
        return getProjectName().replaceAll("\\.", "/");
    }

    /**
     * 
     * @param loadMetamodel
     */
    public void setLoadMetamodel(boolean loadMetamodel) {
        this.loadMetamodel = loadMetamodel;
    }

    /**
     * 
     * @return <code>loadMetamodel</code>
     */
    public boolean isLoadMetamodel() {
        return loadMetamodel;
    }

    /**
     * 
     * @param fromWorkspace
     */
    public void setFromWorkspace(boolean fromWorkspace) {
        this.fromWorkspace = fromWorkspace;
    }

    /**
     * 
     * @return <code>fromWorkspace</code>
     */
    public boolean isFromWorkspace() {
        return fromWorkspace;
    }

    /**
     * 
     * @param className
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 
     * @return The class name.
     */
    public String getClassName() {
        return className;
    }

    /**
     * 
     * @param modelPath
     */
    public void setModelPath(String modelPath) {
        this.modelPath = modelPath;
    }

    /**
     * 
     * @return The model path.
     */
    public String getModelPath() {
        return modelPath;
    }

	public void setMMBundleName(String mmBundleName) {
		this.mmBundleName = mmBundleName;
		
	}

	public String getMmBundleName() {
		return mmBundleName;
	}

}
