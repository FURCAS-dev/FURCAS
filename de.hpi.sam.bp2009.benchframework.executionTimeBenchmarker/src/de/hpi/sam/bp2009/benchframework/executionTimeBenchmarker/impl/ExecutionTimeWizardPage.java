package de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl;

import java.util.HashMap;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerOptionObject;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.MeasurableClassLiterals;
import de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluatorNotifyLiterals;

public class ExecutionTimeWizardPage extends WizardPage {
	
	private static final String END_COMBO_BOX_LABEL = "choose end point:";
	private static final String START_COMBO_BOX_LABEL = "choose start point:";
	private static final String OCL_EVALUATOR = "Ocl Evaluator";
	private static final String EVENT_MANAGER = "Event Manager";
	private static final String IMPACT_ANALYZER = "Impact Analyzer";
	private static final String PAGENAME = "Time Measurement";
	private Combo startPointChooseBox;
	private Combo endPointChooseBox;
	private HashMap<String, Integer> nameToLiteral;
	private HashMap<String, Integer> clsNameToLiteral;
	
	private ExecutionTimeBenchmarkerOptionObject option;

	public ExecutionTimeWizardPage(ExecutionTimeBenchmarkerOptionObject option){
		this(PAGENAME);
		this.option = option;
	}
	
	protected ExecutionTimeWizardPage(String pageName) {
		super(pageName);
		setTitle("Execution Time Measurement");
		setDescription("Choose the method you like to benchmark");
		
	}

	/* (non-Javadoc)
	 * creates a page with two comboboxes to chose a start point and an end point for time measurement
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		//create the widgets for the page
		Composite composite = null;
		composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(GridData.FILL_BOTH, false);
		layout.numColumns = 1;
		composite.setLayout(layout);
		
		generateSelectionBox(composite);	
		
		setControl(composite);
		setPageComplete(true);
	}
	
	/**
	 * creates two comboboxes for the start point and the end point
	 * with a combination of all classes and points
	 * and adds a selection listener to save the chosen measurement points
	 * in the option object 
	 * @param parent the composite to witch the comboboxes should be added
	 */
	private void generateSelectionBox(Composite parent) {
		startPointChooseBox = new Combo(parent, SWT.UP);
		startPointChooseBox.setText(START_COMBO_BOX_LABEL);
		endPointChooseBox = new Combo(parent, SWT.UP);
		endPointChooseBox.setText(END_COMBO_BOX_LABEL);
		
		//map a class name to the corresponding literal
		clsNameToLiteral = new HashMap<String, Integer>();
		clsNameToLiteral.put(IMPACT_ANALYZER, MeasurableClassLiterals.IMPACT_ANALYZER_VALUE);
		clsNameToLiteral.put(EVENT_MANAGER, MeasurableClassLiterals.EVENT_MANAGER_VALUE);
		clsNameToLiteral.put(OCL_EVALUATOR, MeasurableClassLiterals.OCL_EVALUATOR_VALUE);

		//map a point name to the corresponding literal
		nameToLiteral = new HashMap<String, Integer>();
		//adds all measurement points from IA to the comboboxes
		//FIXME add new literals for measurements
//		for( ModifiedImpactAnalyzerNotifyLiterals literal: ModifiedImpactAnalyzerNotifyLiterals.values()){			
//			String name = literal.name();
//			int value = literal.getValue();
//			addLiteralToBoxes(name, value, IMPACT_ANALYZER);
//		}
//		//adds all measurement points from EM to the comboboxes
//		for( ModifiedEventManagerNotifyLiterals literal: ModifiedEventManagerNotifyLiterals.values()){
//			String name = literal.name();
//			int value = literal.getValue();
//			addLiteralToBoxes(name, value, EVENT_MANAGER);
//		}
		//adds all measurement points from OclOpt to the comboboxes
		for(  QueryEvaluatorNotifyLiterals literal: QueryEvaluatorNotifyLiterals.values()){
			String name = literal.name();
			int value = literal.getValue();
			addLiteralToBoxes(name, value, OCL_EVALUATOR);

		}
		
		//adds a selection listener to save the chosen start point and the corresponding class in the option object
		startPointChooseBox.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String boxItem = startPointChooseBox.getItem(startPointChooseBox.getSelectionIndex());
				String[] items = boxItem.split(":");
				items[1] = items[1].trim();
				option.setClassLiteral(clsNameToLiteral.get(items[0]));
				option.setStartLiteral(nameToLiteral.get(items[1]));				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do	
			}
		});
		//adds a selection listener to save the chosen end point in the option object
		endPointChooseBox.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				String boxItem = endPointChooseBox.getItem(endPointChooseBox.getSelectionIndex());
				String[] items = boxItem.split(":");
				items[1] = items[1].trim();
				option.setEndLiteral(nameToLiteral.get(items[1]));			
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do	
			}
		});
	}

	/**
	 * @param name
	 * @param value
	 */
	private void addLiteralToBoxes(String name, int value, String cls) {
		nameToLiteral.put(name, value);		
		startPointChooseBox.add(cls + ": " + name);	
		endPointChooseBox.add(cls + ": " + name);
	}
	
	@Override
	public boolean canFlipToNextPage() {
		return true;
	}
}
