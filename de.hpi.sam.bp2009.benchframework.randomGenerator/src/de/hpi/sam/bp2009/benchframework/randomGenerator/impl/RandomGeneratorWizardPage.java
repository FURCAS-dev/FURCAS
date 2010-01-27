package de.hpi.sam.bp2009.benchframework.randomGenerator.impl;


import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorOptionObject;

public class RandomGeneratorWizardPage extends WizardPage {
	
	Text fileName;
	private RandomGeneratorOptionObject option;
	protected boolean validPackage = false;
	
	protected RandomGeneratorWizardPage(String pageName) {
		super(pageName);
		setTitle("Random Generator Configuration");
		setDescription("Set the options for the Random Generator.");
		setPageComplete(false);
	}
	protected RandomGeneratorWizardPage(String pageName, RandomGeneratorOptionObject option) {
		this(pageName);
		this.option = option;
	}
	public void createControl(Composite parent) {
		//create the widgets for the page
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		composite.setLayout(layout);
		fileName = new Text(composite, SWT.BORDER);
		fileName.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				//check if given URI is a package in package registry
				EPackage pckg = Registry.INSTANCE.getEPackage(((Text)e.getSource()).getText());
				if (pckg != null){
					option.setMetaModel(pckg);
					validPackage  = true;
				}
			}
		});
	    //setControl(composite);
	}
	
	@Override
	public boolean canFlipToNextPage() {
		return validPackage;
	}
}
