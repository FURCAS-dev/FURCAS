package de.hpi.sam.bp2009.benchframework.testrunWizard;

import java.util.HashMap;
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

import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.ResultProcessor;

public class ListPage extends WizardPage {
	private static final String PAGETITEL="Testrun Configuration";
	private static final String PAGEDESC="Choose the steps you want to perform during the test run.";
	private static final String ADDBUTTONTEXT="Add";
	private static final String REMOVEBUTTONTEXT = "Remove";
	private OperatorTable tbl = new OperatorTable();
	private Combo operatorBox;
	private Map<String, EClass> nameToEclass;
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
		processorBox=new Combo(composite, SWT.UP);
		for(ResultProcessor p:((TestframeworkWizard)getWizard()).getIntImpl().getEngine().getRegisteredResultProcessors())
			processorBox.setData(p.toString(),p);
		processorBox.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				ResultProcessor obj = (ResultProcessor) processorBox.getData(processorBox.getItem(processorBox.getSelectionIndex()));
				obj.setTestrun(((TestframeworkWizard)getWizard()).getRun());
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		setControl(composite);
		setPageComplete(true);
	}

	private void generateEClassMappingAndSelectionBoxForOperators(
			Composite composite) {
		operatorBox= new Combo(composite, SWT.UP);
		nameToEclass=new HashMap<String,EClass>();
		for(Operator op:((TestframeworkWizard)getWizard()).getIntImpl().getAvailableOperators()){
			operatorBox.add(op.getName());
			nameToEclass.put(op.getName(), op.eClass());
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
				EClass cls = nameToEclass.get(operatorBox.getItem(operatorBox.getSelectionIndex()));
				EObject obj=cls.getEPackage().getEFactoryInstance().create(cls);
				if(obj instanceof Operator){
					Operator op= (Operator)obj;
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
			/*
			 * FIXME if multiple instances running some concurrency issues might result here
			 */
			if(page.getWizard()==null)
				wiz.addPage(page);
			else
				page.setVisible(true);
		}
	}
}
