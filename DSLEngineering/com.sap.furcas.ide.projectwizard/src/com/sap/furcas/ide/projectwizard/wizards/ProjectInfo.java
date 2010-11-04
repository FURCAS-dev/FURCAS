/*******************************************************************************
 *
 *******************************************************************************/
package com.sap.furcas.ide.projectwizard.wizards;

//import org.eclipse.ui.actions.WorkspaceModifyOperation;

public class ProjectInfo {
    private String projectName;
    private String languageName;
    private String fileExtension;
    private String nsURI;
    private String basePackage;
    private boolean createGeneratorProject = false;

    public boolean isCreateGeneratorProject() {
	return createGeneratorProject;
    }

    public void setCreateGeneratorProject(boolean createGeneratorProject) {
	this.createGeneratorProject = createGeneratorProject;
    }

    public String getBasePackage() {
	return basePackage;
    }

    public void setBasePackage(String basePackage) {
	this.basePackage = basePackage;
    }

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

    public String getProjectName() {
	return projectName;
    }

    public void setProjectName(String projectName) {
	this.projectName = projectName;
    }

    public String getTCSFileName() {
	return getLanguageName().replaceAll("\\s", "_") + ".tcs"; // +"xtxt";
    }

    public String getBasePath() {
	return getBasePackage().replaceAll("\\.", "/");
    }

}
