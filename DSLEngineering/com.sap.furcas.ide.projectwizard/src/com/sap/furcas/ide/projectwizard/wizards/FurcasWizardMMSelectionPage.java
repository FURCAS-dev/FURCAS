package com.sap.furcas.ide.projectwizard.wizards;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.jface.viewers.ISelection;
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

/* This is the second page of the wizard. It lets you choose, wether you want to create a pure fresh MetaModel
 * or import an existing one into your new Metamodel.*/

public class FurcasWizardMMSelectionPage extends WizardPage {
    Button selectmm1;
    Button selectmm2;
    Label classNameLabel;
    Label nsURILabel;
    Text nsURIText;
    Text classNameText;
    private MMLoadPage page3;
    FurcasWizard wiz;
    ProjectInfo pi;
    String className;

    public FurcasWizardMMSelectionPage(ISelection selection, FurcasWizard w, ProjectInfo projectInfo) {
        super("Metamodel");
        page3 = null;
        wiz = w;
        pi = projectInfo;
        setTitle("Metamodelselection");
        setDescription("Choose an existing Metamodel or create a new one");
        setPageComplete(false);
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = 2;
        layout.verticalSpacing = 9;

        // First option
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
                classNameLabel.setText("Name the first class of the metamodel:");
                nsURILabel.setText("nsURI of the metamodel:");
                classNameText.setVisible(true);
                nsURIText.setVisible(true);
                classNameLabel.setVisible(true);
                nsURILabel.setVisible(true);
            }

            public void mouseUp(MouseEvent e) {
            }
        });
        // second option
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
        className = classNameText.getText();
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
        nsURIText.setText("mydsl/metamodel/example");
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

    protected void dialogChanged() {
        pi.setNsURI(nsURIText.getText());
        className = classNameText.getText();
        if (!isAlpha(className)) {
            setErrorMessage("The classname can only contain upper and lowercase letters");
            return;
        }
        if (!isUpper(className.charAt(0))) {
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

    public Integer getSel() {
        Integer sel = 0;
        if (selectmm1.getSelection() == true)
            sel = 1;
        else if (selectmm2.getSelection() == true)
            sel = 2;
        return sel;
    }

    @Override
    public IWizardPage getNextPage() {
        if (getSel() == 2) {
            if (page3 == null) {
                page3 = new MMLoadPage("LoadPage", wiz, pi);
                wiz.addPage(page3);
                page3.setPageComplete(false);
                this.setPageComplete(true);
                wiz.enableLoadPage();
            }
            if (wiz.createmm) {
                wiz.createmm = false;
            }
            return page3;
        } else if (getSel() == 1)
            pi.setNsURI(nsURIText.getText());
            if (page3 != null)
                page3.setPageComplete(true);
        wiz.addMMP();
        return null;
    }

    public String getClassName() {
        return className;
    }

    private boolean isAlpha(final String s) {
        final char[] chars = s.toCharArray();
        for (int x = 0; x < chars.length; x++) {
            final char c = chars[x];
            if ((c >= 'a') && (c <= 'z'))
                continue; // lowercase
            if ((c >= 'A') && (c <= 'Z'))
                continue; // uppercase
            return false;
        }
        return true;
    }

    private boolean isUpper(final char c) {
        if ((c >= 'A') && (c <= 'Z'))
            return true;
        return false;
    }

}
