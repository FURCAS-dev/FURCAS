package de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;

public class ExecutionTimeWizardPage extends WizardPage {

	protected ExecutionTimeWizardPage(String pageName) {
		super(pageName);
		setTitle("Execution Time Measurement");
		setDescription("Nothing to set here...");
	}

	@Override
	public void createControl(Composite parent) {
		//nothing to render here...simply make the next button available
	}
	
	@Override
	public boolean canFlipToNextPage() {
		return true;
	}

}
