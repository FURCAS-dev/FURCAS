package de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

import de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManagerNotifyLiterals;
import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzerNotifyLiterals;
import de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizerNotifyLiterals;




public class ExecutionTimeWizardPage extends WizardPage {
	
	private static final String PAGENAME = "Time Measurement";
	private Combo timeMeasurementPointsBox;

	public ExecutionTimeWizardPage(){
		this(PAGENAME);
		
	}
	
	protected ExecutionTimeWizardPage(String pageName) {
		super(pageName);
		setTitle("Execution Time Measurement");
		setDescription("Choose the points you like to benchmark");
	}

	@Override
	public void createControl(Composite parent) {
		//create the widgets for the page
		Composite composite = null;
		composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(GridData.FILL_BOTH, false);
		layout.numColumns = 2;
		composite.setLayout(layout);
		
		generateSelectionBoxForLiterals(composite);
		
		
		setControl(composite);
		setPageComplete(true);
	}
	
	private void generateSelectionBoxForLiterals(Composite composite) {
		timeMeasurementPointsBox = new Combo(composite, SWT.UP);
		
		//add literals of IA
		for( ModifiedImpactAnalyzerNotifyLiterals literal: ModifiedImpactAnalyzerNotifyLiterals.values()){
			timeMeasurementPointsBox.add(literal.toString());
		}
		//add literals of EM
		for( ModifiedEventManagerNotifyLiterals literal: ModifiedEventManagerNotifyLiterals.values()){
			timeMeasurementPointsBox.add(literal.toString());
		}
		//add literals of OclOptimizer
		for(  ModifiedOclOptimizerNotifyLiterals literal: ModifiedOclOptimizerNotifyLiterals.values()){
			timeMeasurementPointsBox.add(literal.toString());
		}
	}
	
	@Override
	public boolean canFlipToNextPage() {
		return true;
	}
}
