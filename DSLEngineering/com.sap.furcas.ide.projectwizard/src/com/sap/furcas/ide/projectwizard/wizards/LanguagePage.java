package com.sap.furcas.ide.projectwizard.wizards;

import org.eclipse.jface.viewers.ISelection;
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


/* 
 * This is the first page of the wizard used to collect all the necessary information needed for the
 * creation of a new Furcas DSL project.
 * */

public class LanguagePage extends WizardPage {
    private Text projectText;

    private Text languageNameText;

    private Text fileExtensionText;

    public boolean valid = true;

    private ProjectInfo projectInfo = new ProjectInfo();

    public ProjectInfo getProjectInfo() {
        return projectInfo;
    }

    public LanguagePage(ISelection selection) {
        super("wizardPage");
        setTitle("Furcas Project Wizard");
        setDescription("This wizard creates a pair of projects for your DSL.");
    }

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

    private void initialize() {
        projectText.setText("my.dsl");
        languageNameText.setText("mydsl");
        fileExtensionText.setText("dsl");

    }

    void dialogChanged() {
        projectInfo.setProjectName(projectText.getText());
        projectInfo.setLanguageName(languageNameText.getText());
        projectInfo.setFileExtension(fileExtensionText.getText());

        if (!projectInfo.getProjectName().matches("\\w+[\\w\\.]*\\w+")) {
            valid = false;
            setErrorMessage("Project name must be specified (And must be in Java Package syntax (e.g. org.example))");
            return;
        }
        if (!projectInfo.getLanguageName().matches("\\w{3,}")) {
            valid = false;
            setErrorMessage("Language name must be specified (no whitespace, no special chars!)");
            return;
        }
        if (!projectInfo.getFileExtension().matches("\\w{2,6}")) {
            valid = false;
            setErrorMessage("A file extension consists of 2 to 6 characters (example: dsl)");
            return;
        }
        setErrorMessage(null);
        setPageComplete(true);
        valid = true;
    }

}