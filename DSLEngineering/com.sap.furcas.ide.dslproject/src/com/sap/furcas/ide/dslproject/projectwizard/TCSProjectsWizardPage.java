/*******************************************************************************
*
 *******************************************************************************/
package com.sap.furcas.ide.dslproject.projectwizard;

import java.net.URI;
import java.net.URISyntaxException;

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

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (xtxt).
 */
public class TCSProjectsWizardPage extends WizardPage {
    private Text projectText;

    private Text languageNameText;

    private Text fileExtensionText;

    private Text nsURIText;

    private Text basePackageText;

//    private Button generateGenProject;

    private ProjectInfo projectInfo = new ProjectInfo();

    public ProjectInfo getProjectInfo() {
        return projectInfo;
    }

    
    public TCSProjectsWizardPage(ISelection selection) {
        super("wizardPage");
        setTitle("Xtext projects wizard");
        setDescription("This wizard creates a pair of projects for your Xtext DSL.");
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
        label = new Label(container, SWT.NULL);
        label.setText("nsURI:");

        nsURIText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        nsURIText.setLayoutData(gd);
        nsURIText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });
        label = new Label(container, SWT.NULL);
        label.setText("Base package:");

        basePackageText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        basePackageText.setLayoutData(gd);
        basePackageText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });

//        label = new Label(container, SWT.NULL);
//        label.setText("Create generator project:");

//        generateGenProject = new Button(container, SWT.CHECK);
//        gd = new GridData(GridData.FILL_HORIZONTAL);
//        generateGenProject.setLayoutData(gd);
//        generateGenProject.addSelectionListener(new SelectionListener() {
//            public void widgetDefaultSelected(SelectionEvent e) {
//                dialogChanged();
//            }
//
//            public void widgetSelected(SelectionEvent e) {
//                dialogChanged();
//            }
//        });

        initialize();
        dialogChanged();
        setControl(container);
    }


    private void initialize() {
        projectText.setText("my.dsl");
        languageNameText.setText("mydsl");
        fileExtensionText.setText("dsl");
        nsURIText.setText("http://www.example.org/my/dsl");
        basePackageText.setText("org.example.dsl");
//        generateGenProject.setSelection(true);
    }

    void dialogChanged() {
        projectInfo.setBasePackage(basePackageText.getText());
        projectInfo.setProjectName(projectText.getText());
        projectInfo.setLanguageName(languageNameText.getText());
        projectInfo.setFileExtension(fileExtensionText.getText());
        projectInfo.setNsURI(nsURIText.getText());
//        projectInfo.setCreateGeneratorProject(generateGenProject.getSelection());

        if (!projectInfo.getProjectName().matches("\\w+[\\w\\.]*\\w+")) {
            setErrorMessage("Project name must be specified (And must be in Java Package syntax (e.g. org.example))");
            return;
        }
        if (!projectInfo.getLanguageName().matches("\\w{3,}")) {
            setErrorMessage("Language name must be specified (no whitespace, no special chars!)");
            return;
        }
        if (!projectInfo.getBasePackage().matches("\\w+[\\w\\.]*\\w+")) {
            setErrorMessage("Base package name must be specified (example: my.package.name)");
            return;
        }
        if (!projectInfo.getFileExtension().matches("\\w{2,6}")) {
            setErrorMessage("A file extension consists of 2 to 6 characters (example: dsl)");
            return;
        }
        try {
            new URI(projectInfo.getNsURI());
        } catch (URISyntaxException e) {
            setErrorMessage("The namespace URI is no valid URI (example: 'http://www.example-org/my/dsl')");
            return;
        }
        setErrorMessage(null);
        setPageComplete(true);
    }

}