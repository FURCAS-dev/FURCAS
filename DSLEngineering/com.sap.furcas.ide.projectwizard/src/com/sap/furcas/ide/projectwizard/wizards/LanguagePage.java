package com.sap.furcas.ide.projectwizard.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.sap.furcas.ide.projectwizard.util.ProjectInfo;

/**
 * This is the first page of the wizard used to collect the information needed for the creation of a new Furcas DSL project. That
 * is:
 * <p>
 * The projectname, the language name and its file extension.
 * </p>
 * The projectwizard uses {@link}ProjectInfo to save all the user input.
 * 
 * @author Frederik Petersen (D054528)
 * 
 */
public class LanguagePage extends WizardPage {
    /**
     * The textfield for the project name.
     */
    private Text projectText;

    /**
     * The textfield for the language name.
     */
    private Text languageNameText;

    /**
     * The textfield for the file extension.
     */
    private Text fileExtensionText;
    
    /**
     * The instance of {@link}ProjectInfo that keeps track of the user input. Found everywhere in the wizard.
     */
    private ProjectInfo projectInfo = new ProjectInfo();

    /**
     * 
     * @return The user input
     */
    public ProjectInfo getProjectInfo() {
        return projectInfo;
    }

    /**
     * Creates the language page and sets title etc.
     */
    public LanguagePage() {
        super("wizardPage");
        setTitle("Furcas Project Wizard");
        setDescription("This wizard creates a pair of projects for your DSL.");
    }

    /**
     * Creates the UI of the wizard being the 3 labels and 3 textfields. Also adds listeners that call the method
     * <code>dialogChanged()</code> everytime the content of any textfield changes.
     */
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = 2;
        layout.verticalSpacing = 9;
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        Label label = new Label(container, SWT.NULL);
        label.setText("Main &project name:");

        projectText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        projectText.setLayoutData(gd);
        projectText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });

        label = new Label(container, SWT.NULL);
        label.setText("&Language name:");

        languageNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        languageNameText.setLayoutData(gd);
        languageNameText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });

        label = new Label(container, SWT.NULL);
        label.setText("DSL-File extension:");

        fileExtensionText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        fileExtensionText.setLayoutData(gd);
        fileExtensionText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });

        initialize();
        dialogChanged();
        setControl(container);
    }

    /**
     * Initializes all three textfields
     */
    private void initialize() {
        projectText.setText("my.dsl");
        languageNameText.setText("mydsl");
        fileExtensionText.setText("dsl");

    }

    /**
     * This method is called when the content of one of the textfields changes. It sets the fitting variables in
     * the ProjectInfo instance and checks the user input for errors. If the user has entered appropriate input
     * the finish button will be enabled.
     */
    void dialogChanged() {
        projectInfo.setProjectName(projectText.getText());
        projectInfo.setLanguageName(languageNameText.getText());
        projectInfo.setFileExtension(fileExtensionText.getText());

        if (!projectInfo.getProjectName().matches("\\w+[\\w\\.]*\\w+")) {
            setErrorMessage("Project name must be specified (And must be in Java Package syntax (e.g. org.example))");
            setPageComplete(false);
            return;
        }
        if (!projectInfo.getLanguageName().matches("\\w{3,}")) {
            setErrorMessage("Language name must be specified (no whitespace, no special chars!)");
            setPageComplete(false);
            return;
        }
        if (!projectInfo.getFileExtension().matches("\\w{2,6}")) {
            setErrorMessage("A file extension consists of 2 to 6 characters (example: dsl)");
            setPageComplete(false);
            return;
        }
        setErrorMessage(null);
        setPageComplete(true);
    }

}