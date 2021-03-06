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

    private boolean autoResolve = true;

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

    private String mmBundleName;

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getNsURI() {
        return nsURI;
    }

    public void setNsURI(String nsURI) {
        this.nsURI = nsURI;
    }

    public boolean isAutoResolve() {
        return autoResolve;
    }

    public void setAutoResolve(boolean autoResolve) {
        this.autoResolve = autoResolve;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTCSFileName() {
        String tcsFile = getLanguageName().replaceAll("\\s", "_") + ".tcs";
        return CreateProject.capitalizeFirstChar(tcsFile);
    }

    public String getBasePath() {
        return getProjectName().replaceAll("\\.", "/");
    }

    public void setLoadMetamodel(boolean loadMetamodel) {
        this.loadMetamodel = loadMetamodel;
    }

    public boolean isLoadMetamodel() {
        return loadMetamodel;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setModelPath(String modelPath) {
        this.modelPath = modelPath;
    }

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
