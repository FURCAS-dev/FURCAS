package de.hpi.sam.bp2009.benchframework.testrunWizard;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DragDetectEvent;
import org.eclipse.swt.events.DragDetectListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import de.hpi.sam.bp2009.benchframework.Operator;

public class ChooseModulePage extends WizardPage {
	Table table;
	ExpandBar expandBar;
	private ArrayList<Operator> currentOperators;

    protected ChooseModulePage(String pageName) {
        super(pageName);
        setTitle("Testrun Configuration2564654");
        setDescription("Choose the order of steps you want to perform during the test run.");
        System.out.println("choose page");
        setPageComplete(false);
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
			table = new Table(composite,SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION | SWT.DRAG);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        table.addDragDetectListener(new DragDetectListener() {
			
			@Override
			public void dragDetected(DragDetectEvent e) {
				System.out.println("drag");
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
			if (((ListPage) this.getPreviousPage()).currentOperators != null) {
				for (Operator op : ((ListPage) this.getPreviousPage()).currentOperators) {
					TableItem item = new TableItem(table, SWT.NONE);
					System.out.println("ghhgjhj");
					item.addListener(SWT.MouseDown, new Listener() {

						@Override
						public void handleEvent(Event event) {
							System.out.println("event");
						}
					});
					item.setData(op);
					String[] line = { "", op.getName(), op.getDescription() };
					item.setText(line);
				}
			}
			//resize columns according to it's content
			for (int i = 0; i<headers.length; i++){
				table.getColumn(i).pack();
			}
			setControl(composite);
			System.out.println("testline");
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
