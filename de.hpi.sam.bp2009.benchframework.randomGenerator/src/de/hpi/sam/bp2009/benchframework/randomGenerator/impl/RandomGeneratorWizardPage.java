package de.hpi.sam.bp2009.benchframework.randomGenerator.impl;


import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorOptionObject;

public class RandomGeneratorWizardPage extends WizardPage {
	private static final String PAGETITLE	=	"Random Generator Configuration";
	private static final String PAGEDESC	=	"Set the options for the Random Generator.";
	private static final String LABELTEXT 	= 	"Enter the URI of the metaModel, if empty we use petrinet";
	private static final String TOOLTIPTEXT = 	"This url is used to load an EPackage from the PackageRegistry";
	
	private RandomGeneratorOptionObject option;
	protected boolean validPackage = true;

	protected RandomGeneratorWizardPage(String pageName) {
		super(pageName);
		setTitle(PAGETITLE);
		setDescription(PAGEDESC);
		setPageComplete(false);
	}
	protected RandomGeneratorWizardPage(String pageName, RandomGeneratorOptionObject option) {
		this(pageName);
		this.option = option;
	}
	public void createControl(Composite parent) {
		//create the widgets for the page
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(1, true);
		composite.setLayout(layout);

		Label label = new Label(composite, SWT.CENTER);
		label.setText(LABELTEXT);
		buildTextBox(composite);
		setControl(composite);
	}
	private void buildTextBox(Composite composite) {
		Text fileName = new Text(composite, SWT.BORDER);
		fileName.setText(option.getMetaModel().getNsURI());
		fileName.setToolTipText(TOOLTIPTEXT);
		fileName.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				//check if given URI is a package in package registry
				EPackage pckg = Registry.INSTANCE.getEPackage(((Text)e.getSource()).getText());
				if (pckg != null){
					option.setMetaModel(pckg);
					validPackage  = true;
				}else{
					validPackage=false;
				}
			}
		});
	}

	@Override
	public boolean canFlipToNextPage() {
		return validPackage;
	}
}
