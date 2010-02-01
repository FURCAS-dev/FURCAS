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

public class ListPage extends WizardPage {
	private static final String PAGETITEL="Testrun Configuration";
	private static final String PAGEDESC="Choose the steps you want to perform during the test run.";
	private static final String ADDBUTTONTEXT="Add";
	private static final String REMOVEBUTTONTEXT = "Remove";
	private OperatorTable tbl = new OperatorTable();
	private Combo box;
	private Map<String, EClass> nameToEclass;

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
		box= new Combo(composite, SWT.UP);
		nameToEclass=new HashMap<String,EClass>();
		for(Operator op:((TestframeworkWizard)getWizard()).getIntImpl().getAvailableOperators()){
			box.add(op.getName());
			nameToEclass.put(op.getName(), op.eClass());
		}

		buildAddButton(composite);

		tbl.setOperatorList(((TestframeworkWizard)getWizard()).run.getOperators());
		tbl.createTable(composite);

		buildRemoveButton(composite);
		setControl(composite);
		setPageComplete(true);
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
				
				// if operator has a wizard page set it invisible
				for(Operator op: tbl.getSelectedOperatorList())
					if(op.getOption()!=null && op.getOption().getWizardPage()!=null)
						op.getOption().getWizardPage().setVisible(false);
				
				TestframeworkWizard wiz=((TestframeworkWizard)getWizard());
				wiz.run.getOperators().removeAll(tbl.getSelectedOperatorList());

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
				if(box.getSelectionIndex()==-1)
					return;
				EClass cls = nameToEclass.get(box.getItem(box.getSelectionIndex()));
				EObject obj=cls.getEPackage().getEFactoryInstance().create(cls);
				if(obj instanceof Operator){
					Operator op= (Operator)obj;
					TestframeworkWizard wiz=((TestframeworkWizard)getWizard());
					wiz.run.getOperators().add(op);
					
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
		return super.getNextPage();
	}
	@Override
	public boolean canFlipToNextPage() {
		return !((TestframeworkWizard)getWizard()).run.getOperators().isEmpty();
	}
}
