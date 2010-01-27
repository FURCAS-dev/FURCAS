package de.hpi.sam.bp2009.benchframework.testrunWizard;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.swt.widgets.Combo;
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
	private Combo box;
	private Button btn;
	private Map<String, EClass> nameToEclass;

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
			layout.numColumns = 2;
			composite.setLayout(layout);
			box= new Combo(composite, SWT.UP);
			nameToEclass=new HashMap<String,EClass>();
			for(Operator op:((TestframeworkWizard)getWizard()).getIntImpl().getAvailableOperators()){
				box.add(op.getName());
				nameToEclass.put(op.getName(), op.eClass());
			}
			
			
			btn= new Button(composite, SWT.CENTER);
			btn.setText("Add");
			btn.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					
					String item=box.getItem(box.getSelectionIndex());
					System.out.println(item);
					EClass cls = nameToEclass.get(item);
					EObject obj=cls.getEPackage().getEFactoryInstance().create(cls);
					if(obj instanceof Operator){
						((TestframeworkWizard)getWizard()).run.getOperators().add((Operator)obj);
						((TestframeworkWizard)getWizard()).addPage(((Operator)obj).getOption().getWizardPage());
					}
					tbl.refresh();
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					
				}
				

			});
			
			tbl.operatorList=((TestframeworkWizard)getWizard()).run.getOperators();
			tbl.createTable(composite);
			setControl(composite);
			setPageComplete(true);
	}
	@Override
	public IWizardPage getNextPage() {
		System.out.println(this.getWizard().getNextPage(this).getName());
		// TODO Auto-generated method stub
		return super.getNextPage();
	}
	@Override
	public boolean canFlipToNextPage() {
		// TODO Auto-generated method stub
		return true;
	}
}
