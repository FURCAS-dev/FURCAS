package de.hpi.sam.bp2009.benchframework.testrunWizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ICellEditorListener;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import de.hpi.sam.bp2009.benchframework.Operator;

public class ChooseModulePage extends WizardPage {
	Table table;
	ExpandBar expandBar;
	public List<Operator> operators;
	
    protected ChooseModulePage(String pageName) {
        super(pageName);
        setTitle("Testrun Configuration");
        setDescription("Choose the order of steps you want to perform during the test run.");
        System.out.println("choose page");
        setPageComplete(false);
    }
    

	public ChooseModulePage(String string, List<Operator> selectedOperatorList) {
		this(string);
		this.operators=selectedOperatorList;
	}

	@Override
	protected boolean isControlCreated() {
		
		return false;
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
			table = new Table(composite,SWT.MULTI | SWT.BORDER | SWT.DRAG);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
			if (this.operators != null){
				for (Operator op: this.operators){
					TableItem item = new TableItem(table, SWT.NONE);
					item.setData(op);
					item.setText(op.getName());
				}
			}
			
			//resize columns according to it's content
			for (int i = 0; i<headers.length; i++){
				table.getColumn(i).pack();
			}
			setControl(composite);
			
			setPageComplete(true);
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
//		//return ((TestframeworkWizard)getWizard()).chooseModulePage;
//		
//		return this.getPreviousPage();
//	}
}
