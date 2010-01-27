package de.hpi.sam.bp2009.benchframework.testrunWizard;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ICellEditorListener;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.internal.SWTEventListener;
import org.eclipse.swt.internal.SWTEventObject;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import de.hpi.sam.bp2009.benchframework.Operator;

public class ListPage extends WizardPage {
	private static final char[] Operator = null;
	Table table;
	ExpandBar expandBar;
	public ArrayList<Operator> currentOperators;
	public ArrayList<Button> checkboxes = new ArrayList<Button>();
	OperatorTable tbl = new OperatorTable();

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
			composite = new Composite(parent, SWT.NONE);
			GridLayout layout = new GridLayout();
			layout.numColumns = 1;
			composite.setLayout(layout);
			
	
			tbl.operatorList=	((TestframeworkWizard)getWizard()).getIntImpl().getAvailableOperators();
			tbl.createTable(composite);
			setControl(composite);
			setPageComplete(true);
	}
	@Override
	public boolean canFlipToNextPage() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public IWizardPage getNextPage() {
		IWizardPage page = ((TestframeworkWizard)getWizard()).getChooseModulePage();
		((ChooseModulePage)page).operators=tbl.selectedOperatorList;
		page.dispose();
		return page;
	}
	
}
