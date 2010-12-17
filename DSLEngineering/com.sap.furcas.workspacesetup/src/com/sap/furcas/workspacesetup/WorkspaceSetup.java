package com.sap.furcas.workspacesetup;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class WorkspaceSetup implements IWorkbenchWindowActionDelegate {
    public static String parentPom;

    private IWorkbenchWindow window;
    private Hashtable<String, String> projectMap = new Hashtable<String, String>();

    /**
     * The action has been activated. The argument of the method represents the 'real' action sitting in the workbench UI.
     * 
     * @see IWorkbenchWindowActionDelegate#run
     */
    public void run(IAction action) {

        // Let user find the parent pom.xml
        FileDialog fileDialog = new FileDialog(window.getShell(), SWT.OPEN);
        fileDialog.setText("Import");
        fileDialog.setFilterPath("C:/");
        fileDialog.setFilterExtensions(new String[] { "pom.xml" });
        fileDialog.open();

        // Save path and find all Maven modules
        String path = fileDialog.getFilterPath();
        if (path.length() > 0 && fileDialog.getFileName().length() > 0) {
            parentPom = path;

            try {
                readPom(parentPom);
            } catch (XPathExpressionException e) {
                MessageDialog.openError(window.getShell(), "Unexpected Error: XPath not working!", e.getMessage());
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                MessageDialog.openError(window.getShell(), "Unexpected Error: DocumentBuilderFactory not working!",
                        e.getMessage());
                e.printStackTrace();
            }
        }

        // catch CoreException and InterruptedException
        try {
            WorkspaceModifyOperation operation = new ImportOperation();
            new ProgressMonitorDialog(window.getShell()).run(true, true, operation);
        } catch (InvocationTargetException e) {
            // Do nothing: User canceled the action
        } catch (InterruptedException e) {
            MessageDialog.openError(window.getShell(), "Error!", e.getMessage());
            e.printStackTrace();
        }
    }

    private void readPom(String path) throws XPathExpressionException, ParserConfigurationException {
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        XPath xpath = XPathFactory.newInstance().newXPath();

        try {
            File file = new File(path + File.separator + "pom.xml");
            Document doc;

            doc = db.parse(file);

            XPathExpression expr = xpath.compile("//project/modules/module/text()");
            Object result = expr.evaluate(doc, XPathConstants.NODESET);
            NodeList nodes = (NodeList) result;

            if (nodes.getLength() > 0) {
                // More submodules found
                for (int i = 0; i < nodes.getLength(); i++) {
                    readPom(path + File.separator + nodes.item(i).getNodeValue());
                }
            } else {
                // Project found
                projectMap.put(path, extractWorkspace(path));
            }
        } catch (SAXException e) {
            MessageDialog.openError(window.getShell(), "Could not parse pom.xml!", e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            MessageDialog.openError(window.getShell(), "Could not open pom.xml!", e.getMessage());
            e.printStackTrace();
        }
    }

    private String extractWorkspace(String path) {
        try {
            // remove path/to/working/set/
            path = path.replace(parentPom, "").substring(1);
            
            String[] segments = path.split(Pattern.quote(File.separator));
            if(segments.length > 2) {
                // like EMF/query2/org.eclipse.emf.query2
                return segments[0] + "-" + segments[1];
            } else {
                // like DSLEngineering/com.sap.furcas.workspacesetup
                return segments[0];
            }
        } catch (Exception e) {
            System.out.println("Could not extract workspace: " + path);
            return "INVALID";
        }
    }

    /**
     * Selection in the workbench has been changed. We can change the state of the 'real' action here if we want, but this can
     * only happen after the delegate has been created.
     * 
     * @see IWorkbenchWindowActionDelegate#selectionChanged
     */
    public void selectionChanged(IAction action, ISelection selection) {
    }

    /**
     * We can use this method to dispose of any system resources we previously allocated.
     * 
     * @see IWorkbenchWindowActionDelegate#dispose
     */
    public void dispose() {
    }

    /**
     * We will cache window object in order to be able to provide parent shell for the message dialog.
     * 
     * @see IWorkbenchWindowActionDelegate#init
     */
    public void init(IWorkbenchWindow window) {
        this.window = window;
    }

    public static IProject importProject(String projectPath) throws CoreException {
        IProjectDescription description = ResourcesPlugin.getWorkspace().loadProjectDescription(
                new Path(projectPath + File.separator + ".project"));
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(description.getName());
        if (!project.exists()) {
            project.create(description, null);
        }
        if (!project.isOpen()) {
            project.open(null);
        }
        return project;
    }

    public static IProject importProject(String projectPath, String workingSet) throws CoreException {
        System.out.println("importProject()");
        IProject project = importProject(projectPath);
        System.out.println("addProjectToWorkingSet()");
        addProjectToWorkingSet(project, workingSet);
        System.out.println("return");
        return project;
    }

    public static void addProjectToWorkingSet(IProject project, String workingSet) {
        IWorkingSetManager workingSetManager = PlatformUI.getWorkbench().getWorkingSetManager();
        IWorkingSet set = workingSetManager.getWorkingSet(workingSet);
        if (set == null) {
            System.out.println("createWorkingSet()");
            set = workingSetManager.createWorkingSet(workingSet, new IProject[] { project });
            set.setId("org.eclipse.jdt.ui.JavaWorkingSetPage");
            workingSetManager.addWorkingSet(set);
        } else {
            System.out.println("setElements()");
            ArrayList<IAdaptable> oldList = new ArrayList<IAdaptable>();
            IAdaptable[] old = set.getElements();
            for (IAdaptable p : old) {
                oldList.add(p);
            }
            oldList.add(project);
            set.setElements(oldList.toArray(old));
        }
    }

    class ImportOperation extends WorkspaceModifyOperation {
        @Override
        protected void execute(IProgressMonitor progressMonitor) {
            try {
                // loop through projects and sync them
                Iterator<String> set = projectMap.keySet().iterator();
                while (set.hasNext()) {
                    String projectPath = set.next();
                    System.out.println(projectPath + ": " + projectMap.get(projectPath));

                    importProject(projectPath, projectMap.get(projectPath));
                    
                    System.out.println("Done.");
                }

                // loop through loaded projects and remove all unused projects
                IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects(0);
                for (IProject project : projects) {
                    if (project.getLocation().toString().startsWith(parentPom.replace(File.separator, "/"))) {
                        if (!projectMap.containsKey(project.getLocation().toString().replace("/", File.separator))) {
                            System.out.println("Remove project: " + project.getLocation().toString());
                            project.delete(false, false, null);
                        } else {
                            System.out.println("Keep project: " + project.getLocation().toString());
                        }
                    } else {
                        System.out.println("Leave project: " + project.getLocation().toString());
                    }
                }
            } catch (CoreException e) {
                MessageDialog.openError(window.getShell(), "Unexpected Error: Eclipse-Core not working!", e.getMessage());
                e.printStackTrace();
            }

        }
    };
}
