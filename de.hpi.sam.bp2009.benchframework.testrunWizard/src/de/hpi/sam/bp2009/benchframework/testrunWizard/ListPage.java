package de.hpi.sam.bp2009.benchframework.testrunWizard;

import java.util.ArrayList;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;

import de.hpi.sam.bp2009.benchframework.Operator;

public class ListPage extends WizardPage {
	Table table;
	ExpandBar expandBar;
	public ArrayList<Operator> currentOperators;

    protected ListPage(String pageName) {
        super(pageName);
        setTitle("Testrun Configuration");
        setDescription("Choose the steps you want to perform during the test run.");
        setPageComplete(false);
        System.out.println("list page");
    }



	@Override
	public void createControl(Composite parent) {
		//create the widgets for the page
		Composite composite = null;
		try {
			composite = new Composite(parent, SWT.NONE);
			GridLayout layout = new GridLayout();
			layout.numColumns = 1;
			composite.setLayout(layout);
			table = new Table(composite,SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        table.addSelectionListener(new SelectionListener() {
			
			

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				currentOperators= new ArrayList<Operator>();
				for(TableItem item: table.getSelection()){
					currentOperators.add((Operator)(item.getData()));
				}
				System.out.println(((Operator)table.getSelection()[0].getData()).getName());
				
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do
				
			}
		});
        try {
			table.setLinesVisible(true);
			table.setHeaderVisible(true);
			GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
			data.heightHint = 200;
			table.setLayoutData(data);
			//fill the table header
			String[] headers = {"","Module", "Options"};
			for (String header:headers){
				TableColumn column = new TableColumn(table, SWT.NONE);
				column.setText(header);
			}
			//fill one line of the table
			int z=0;
			for(Operator op:((TestframeworkWizard)getWizard()).getIntImpl().getAvailableOperators()){ 
			    TableItem item = new TableItem(table, SWT.NONE);
			    item.addListener(SWT.MouseDown, new Listener() {
					
					@Override
					public void handleEvent(Event event) {
						System.out.println("event");
					}
				});
			    item.setData(op);
			    String[] line = {"",op.getName(), op.getDescription()};
			    item.setText(line);
			}
			//resize columns according to it's content
			for (int i = 0; i<headers.length; i++){
				table.getColumn(i).pack();
			}
			setControl(composite);
			setPageComplete(true);
			//setPageComplete(currentOperators.size() > 0);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
//	@Override
//	public boolean canFlipToNextPage() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	@Override
//	public IWizardPage getNextPage() {
//		// TODO Auto-generated method stub
//		IWizardPage choose = null;
//		try {
//			choose = ((TestframeworkWizard) this.getWizard()).getChooseModulePage();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return choose;
//	}
}
