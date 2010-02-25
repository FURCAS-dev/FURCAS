package de.hpi.sam.bp2009.benchframework.testrunWizard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.ResultProcessor;

public class ListPage extends WizardPage {
	private static final String RESULT_COMBO_BOX_LABEL = "choose a resultview:";
	private static final String OPERATOR__COMBO_BOX_LABEL = "choose operators:";
	private static final String PAGETITEL="Testrun Configuration";
	private static final String PAGEDESC="Choose the steps you want to perform during the test run.";
	private static final String ADDBUTTONTEXT="Add";
	private static final String REMOVEBUTTONTEXT = "Remove";
	private static final String ADDRESULTPROCESSOR = "Choose a Result View!";
	private OperatorTable tbl = new OperatorTable();
	private Combo operatorBox;
	private Map<String, EClass> nameToEclass;
	private Map<String, Integer> nameToCount;

	private Map<String, ResultProcessor> nameToProc;
	private Combo processorBox;

	protected ListPage(String pageName) {
		super(pageName);
		setTitle(PAGETITEL);
		setDescription(PAGEDESC);
		setPageComplete(false);
	}

	@Override
	public void createControl(Composite parent) {
		//create the widgets for the page
		Composite composite = null;
		composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(GridData.FILL_BOTH, false);
		layout.numColumns = 2;
		composite.setLayout(layout);
		generateEClassMappingAndSelectionBoxForOperators(composite);
		
		buildAddButton(composite);

		tbl.setOperatorList(((TestframeworkWizard)getWizard()).getRun().getOperators());
		tbl.createTable(composite);

		buildRemoveButton(composite);
		generateEClassMappingAndSelectionBoxForResultProcessors(composite);
		setControl(composite);
		setPageComplete(true);
	}

	private void generateEClassMappingAndSelectionBoxForResultProcessors(
			Composite composite) {
		processorBox=new Combo(composite, SWT.RIGHT);
		processorBox.setText(RESULT_COMBO_BOX_LABEL);
		nameToProc=new HashMap<String,ResultProcessor>();
		for(ResultProcessor p:((TestframeworkWizard)getWizard()).getIntImpl().getEngine().getRegisteredResultProcessors()){
			nameToProc.put(p.getName(), p);
			processorBox.add(p.getName());
			}
		processorBox.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				ResultProcessor obj = nameToProc.get(processorBox.getItem(processorBox.getSelectionIndex()));
				obj.setTestrun(((TestframeworkWizard)getWizard()).getRun());
				((TestframeworkWizard)getWizard()).setResultProcessor(obj);
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				//Nothing to do
			}
		});
		Label label= new Label(composite, SWT.LEFT);
		label.setText(ADDRESULTPROCESSOR);
	}

	private void generateEClassMappingAndSelectionBoxForOperators(
			Composite composite) {
		operatorBox= new Combo(composite, SWT.UP);
		operatorBox.setText(OPERATOR__COMBO_BOX_LABEL);
		nameToEclass=new HashMap<String,EClass>();
		nameToCount=new HashMap<String,Integer>();
		List<String> comboBoxItems = new ArrayList<String>(); 
		for(Operator op:((TestframeworkWizard)getWizard()).getIntImpl().getAvailableOperators()){
			comboBoxItems.add(op.getName());
			nameToEclass.put(op.getName(), op.eClass());
			nameToCount.put(op.getName(),0);
		}
		//just sort the items in the operatorBox
		Collections.sort(comboBoxItems);
		for (String item: comboBoxItems){
			operatorBox.add(item);
		}
	}

	/** Generates an RemoveButton and add it to the Canvas
	 *  this method access the operatortable tbl
	 *  
	 * @param parent to draw on
	 */
	private void buildRemoveButton(Composite parent) {
		Button btn = new Button(parent, SWT.CENTER);
		btn.setText(REMOVEBUTTONTEXT);
		btn.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if(tbl.getSelectedOperatorList().isEmpty())
					return;
				TestframeworkWizard wiz=((TestframeworkWizard)getWizard());
				wiz.getRun().getOperators().removeAll(tbl.getSelectedOperatorList());

				setPageComplete(true);
				tbl.refresh();
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				//Do nothing
			}
		});
	}

	/** Generates an AddButton and add it to the Canvas
	 *  this method access the selectionbox and the nameToClass map
	 *  
	 * @param parent to draw on
	 */
	private void buildAddButton(Composite parent) {
		Button btn = new Button(parent, SWT.CENTER);
		btn.setText(ADDBUTTONTEXT);
		btn.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if(operatorBox.getSelectionIndex()==-1)
					return;
				String name=operatorBox.getItem(operatorBox.getSelectionIndex());
				EClass cls = nameToEclass.get(name);
				
				EObject obj=cls.getEPackage().getEFactoryInstance().create(cls);
				
				if(obj instanceof Operator){
					Operator op= (Operator)obj;
					
					op.setName(op.getName()+ " "+ nameToCount.get(name));
					nameToCount.put(name,nameToCount.get(name)+1);
					
					TestframeworkWizard wiz=((TestframeworkWizard)getWizard());
					wiz.getRun().getOperators().add(op);
					setPageComplete(true);
				}
				tbl.refresh();
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				//Do nothing
			}


		});
	}
	@Override
	public IWizardPage getNextPage() {
		TestframeworkWizard wiz=((TestframeworkWizard)getWizard());
		wiz.flushInnerPages();
		for(Operator op:wiz.getRun().getOperators())
			addOperatorToWizard(op, wiz);
		return super.getNextPage();
	}
	
	@Override
	public boolean canFlipToNextPage() {
		return !((TestframeworkWizard)getWizard()).getRun().getOperators().isEmpty();
	}
	private void addOperatorToWizard(Operator op,
			TestframeworkWizard wiz) {
		/*
		 * add wizard page or make it visible
		 */
		if(op.getOption()!=null && op.getOption().getWizardPage()!=null){
			WizardPage page = op.getOption().getWizardPage();
			page.setTitle(page.getTitle() + " (" +op.getName()+")");
			/*
			 * FIXME if multiple instances running some concurrency issues might result here
			 */
			if(page.getWizard()==null)
				wiz.addPage(page);
			else if(page.getControl()!=null)
				page.setVisible(true);
		}
	}
}
