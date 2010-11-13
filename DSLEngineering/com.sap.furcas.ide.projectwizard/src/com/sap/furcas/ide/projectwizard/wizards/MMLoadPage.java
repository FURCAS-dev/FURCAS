package com.sap.furcas.ide.projectwizard.wizards;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;


/* 
 * This wizardpage is displayed when the user chooses to import some kind of existing MetaModel into his
 * Metamodelproject. Until now it just tells you how to do it manually. TODO 
 * */
public class MMLoadPage extends WizardPage {
    public FurcasWizard wizard;

    protected MMLoadPage(String pageName, FurcasWizard wiz) {
        super(pageName);
        wizard = wiz;
        setTitle("Uh oh");
        setDescription("Not fully implemented yet.");
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = 1;
        layout.verticalSpacing = 1;
        Label label = new Label(container, SWT.NULL);
        label.setText("All you have to do is a right click in the editor view");
        Label label1 = new Label(container, SWT.NULL);
        label1.setText("after the wizard has finished. Then click on \"Load Resource...\"");
        Label label2 = new Label(container, SWT.NULL);
        label2.setText("Now feel free to choose a desired MetaModel for your DSL.");
        setErrorMessage(null);
        setPageComplete(true);
        setControl(container);

    }

    @Override
    public IWizardPage getNextPage() {
        return null;
    }

}
