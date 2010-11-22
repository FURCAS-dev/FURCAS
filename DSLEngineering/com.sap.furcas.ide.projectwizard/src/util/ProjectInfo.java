package util;

/* This class saves all the information entered on the first page of the wizard.*/
public class ProjectInfo {
    private String projectName;
    private String languageName;
    private String fileExtension;
    private String nsURI;
    private String URIPath;
    private String className;
    private String mmProject;
    private boolean loadMetamodel = false;
    private boolean fromWorkspace = false;



    public String getFileExtension() {
        return fileExtension;
    }
    
    public String getURIPath(){
        return URIPath;
    }
    
    public void setURIPath(String s){
        URIPath = s;
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
        return getProjectName().replaceAll("\\.", "/");
    }

    public void setLoadMetamodel(boolean loadMetamodel) {
        this.loadMetamodel = loadMetamodel;
    }

    public boolean isLoadMetamodel() {
        return loadMetamodel;
    }

    public void setFromWorkspace(boolean fromWorkspace) {
        this.fromWorkspace = fromWorkspace;
    }

    public boolean isFromWorkspace() {
        return fromWorkspace;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setMmProject(String mmProject) {
        this.mmProject = mmProject;
    }

    public String getMmProject() {
        return mmProject;
    }



}
