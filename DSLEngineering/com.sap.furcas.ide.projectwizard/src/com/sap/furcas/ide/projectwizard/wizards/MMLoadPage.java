package com.sap.furcas.ide.projectwizard.wizards;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class MMLoadPage extends WizardPage  {
	public FurcasWizard wizard;

	protected MMLoadPage(String pageName, FurcasWizard wiz) {
		super(pageName);
		wizard = wiz;
		setTitle("Uh oh");
        setDescription("Doesn't work right now, you have to do it manually. furcas.org");
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = 1;
        layout.verticalSpacing = 1;
        Label label = new Label(container, SWT.NULL);
        label.setText("Option not built in yet. Create new ecore model in your project,");
        Label label1 = new Label (container, SWT.NULL);
        label1.setText("right click in the editor area, Load Resources and select the desired");
        Label label2 = new Label (container, SWT.NULL);
        label2.setText("Metamodel. Then finish the Furcas configuration manually.");
        setErrorMessage(null);
        setPageComplete(true);
        setControl(container);

		
		
	}
	
	@Override
	public IWizardPage getNextPage(){
			return null;
		}



}
