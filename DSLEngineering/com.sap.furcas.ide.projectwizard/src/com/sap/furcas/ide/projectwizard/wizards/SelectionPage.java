package com.sap.furcas.ide.projectwizard.wizards;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.sap.furcas.ide.projectwizard.util.CreateProject;
import com.sap.furcas.ide.projectwizard.util.ProjectInfo;

/**
 * This is the second page of the wizard. It lets you choose, wether you want to create a pure fresh MetaModel or import an
 * existing one into your new Metamodel.
 * 
 * @author Frederik Petersen (D054528)
 * 
 */
public class SelectionPage extends WizardPage {

    /**
     * The radio button that is selected for creating a fresh metamodel project.
     */
    Button selectmm1;

    /**
     * The radio button that is selected for importing an existing metamodel.
     */
    Button selectmm2;

    /**
     * Label in front of the className textfield. Sometimes invisible.
     */
    Label classNameLabel;

    /**
     * Label in front of the nsURI textfield. Sometimes invisible.
     */
    Label nsURILabel;

    /**
     * nsURI textfield. Sometimes invisible.
     */
    Text nsURIText;

    /**
     * classname textfield. Sometimes invisible.
     */
    Text classNameText;

    /**
     * The next page.
     */
    private LoadPage page3;

    /**
     * The FurcasWizard.
     */
    FurcasWizard wiz;

    /**
     * Keeps track of the user input.
     */
    ProjectInfo pi;

    /**
     * Sets some variables like title etc.
     * 
     * @param w
     *            Furcas Wizard
     * @param projectInfo
     *            user input
     */
    public SelectionPage(FurcasWizard w, ProjectInfo projectInfo) {
        super("Metamodel");
        page3 = null;
        wiz = w;
        pi = projectInfo;
        setTitle("Metamodelselection");
        setDescription("Choose an existing Metamodel or create a new one");
        setPageComplete(false);
    }

    /**
     * Create the URI of this page. There are two radio buttons letting the user choose between loading or creating a metamodel.
     * If the user chooses to create a new Metamodelproject two labels and two textfields come up asking the user for the
     * namespace URI and the name of the first class of the metamodel.
     */
    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = 2;
        layout.verticalSpacing = 9;

        // First option
        //
        selectmm1 = new Button(container, SWT.RADIO);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        selectmm1.setText("Create new METAMODEL-project");
        selectmm1.setLayoutData(gd);
        selectmm1.addMouseListener(new MouseListener() {
            public void mouseDoubleClick(MouseEvent e) {
            }

            public void mouseDown(MouseEvent e) {
                if (!selectmm1.getSelection()) {
                    selectmm1.setSelection(true);
                    selectmm2.setSelection(false);
                }
                getNextPage();
                setPageComplete(true);
                wiz.getContainer().updateButtons();

                nsURIText.setText("http://www."+pi.getLanguageName().toLowerCase()+".com/metamodel/");
                classNameLabel.setText("Name the first class of the metamodel:");
                nsURILabel.setText("nsURI of the metamodel:");
                classNameText.setVisible(true);
                nsURIText.setVisible(true);
                classNameLabel.setVisible(true);
                nsURILabel.setVisible(true);
                String capLangName = CreateProject.capitalizeFirstChar(pi.getLanguageName());
                pi.setModelPath("/" + pi.getProjectName() + ".metamodel/model/" + capLangName
                        + ".ecore");
            }

            public void mouseUp(MouseEvent e) {
            }
        });
        // Second option
        //
        selectmm2 = new Button(container, SWT.RADIO);
        GridData gd2 = new GridData(GridData.FILL_HORIZONTAL);
        selectmm2.setText("Use existing METAMODEL");
        selectmm2.setLayoutData(gd2);
        selectmm2.addMouseListener(new MouseListener() {
            public void mouseDoubleClick(MouseEvent e) {
            }

            public void mouseDown(MouseEvent e) {
                if (!selectmm2.getSelection()) {
                    selectmm1.setSelection(false);
                    selectmm2.setSelection(true);
                }
                getNextPage();
                setPageComplete(true);
                wiz.getContainer().updateButtons();
                classNameLabel.setVisible(false);
                nsURILabel.setVisible(false);
                classNameText.setVisible(false);
                nsURIText.setVisible(false);
            }

            public void mouseUp(MouseEvent e) {
            }
        });
        gd = new GridData(GridData.FILL_HORIZONTAL);
        classNameLabel = new Label(container, SWT.NULL);
        classNameLabel.setLayoutData(gd);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        classNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
        classNameText.setLayoutData(gd);
        classNameText.setText("ExampleClass");
        pi.setClassName(classNameText.getText());
        classNameText.setVisible(false);
        classNameText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });

        nsURILabel = new Label(container, SWT.NULL);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        nsURILabel.setLayoutData(gd);

        nsURIText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        nsURIText.setLayoutData(gd);
        nsURIText.setText("http://www."+pi.getLanguageName().toLowerCase()+".com/metamodel/");
        pi.setNsURI(nsURIText.getText());
        nsURIText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });
        nsURIText.setVisible(false);

        setErrorMessage(null);
        setControl(container);

    }

    /**
     * If the text in the textfields changes this method checks for errors.
     */
    protected void dialogChanged() {
        pi.setNsURI(nsURIText.getText());
        pi.setClassName(classNameText.getText());
        if (!isAlpha(pi.getClassName())) {
            setErrorMessage("The classname can only contain upper and lowercase letters");
            return;
        }
        if (!isUpper(pi.getClassName().charAt(0))) {
            setErrorMessage("The classname should start with an uppercase letter");
            return;
        }
        try {
            new URI(pi.getNsURI());
        } catch (URISyntaxException e) {
            setErrorMessage("The namespace URI is no valid URI (example: 'http://www.example-org/my/dsl')");
            return;
        }
        setErrorMessage(null);

    }

    /**
     * 
     * @return 1 if first radio button is selected, 2 if second radio button is selected
     */
    public Integer getSel() {
        Integer sel = 0;
        if (selectmm1.getSelection() == true)
            sel = 1;
        else if (selectmm2.getSelection() == true)
            sel = 2;
        return sel;
    }

    /**
     * This method handles the page creation from here on and assigns some user input variables.
     * 
     * @return the next page (LoadPage) or null
     */
    @Override
    public IWizardPage getNextPage() {
        if (getSel() == 2) {
            if (page3 == null) {
                page3 = new LoadPage("LoadPage", wiz, pi);
                wiz.addPage(page3);
                this.setPageComplete(true);
                pi.setLoadMetamodel(true);
            }
            page3.setPageComplete(false);
            page3.getNextPage().setPageComplete(false);
            return page3;
        } else if (getSel() == 1) {
            pi.setLoadMetamodel(false);
            pi.setNsURI(nsURIText.getText());
            pi.setClassName(classNameText.getText());
            if (page3 != null) {
                page3.setPageComplete(true);
                if (page3.getNextPage() != null){
                    page3.getNextPage().setPageComplete(true);
                }
            }
        }
        return null;
    }

    /**
     * Checks if the String s contains only letters.
     * 
     * @param s
     *            The string that is to be checked
     * @return true if the string contains only letters. false if not.
     */
    private boolean isAlpha(final String s) {
        final char[] chars = s.toCharArray();
        for (int x = 0; x < chars.length; x++) {
            final char c = chars[x];
            if ((c >= 'a') && (c <= 'z')){
                continue; // lowercase
            }
            if ((c >= 'A') && (c <= 'Z')){
                continue; // uppercase
            }
            return false;
        }
        return true;
    }

    /**
     * Checks if the char c is an upper case character.
     * 
     * @param c
     *            The character that is to be checked.
     * @return true if it is an upper case character, false if not.
     */
    private boolean isUpper(final char c) {
        if ((c >= 'A') && (c <= 'Z')){
            return true;
        }
        return false;
    }

}
