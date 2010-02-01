/**
 * 
 */
package de.hpi.sam.bp2009.benchframework.simpleResultProcessor.impl;

import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.ResultObject;

/**
 * @author Philipp
 *
 */
public class SimpleResultPage extends WizardPage {
	private static final String[] COLUMNNAMES={"Operator", "Key", "Value"};
	private static final String PAGENAME = "Simple Result View";
	private Table table;
	private EList<Operator> ops;

	/**
	 * @return the ops
	 */
	public EList<Operator> getOps() {
		return ops;
	}
	/**
	 * @param ops the ops to set
	 */
	public void setOps(EList<Operator> ops) {
		this.ops = ops;
	}
	/**
	 * @param pageName
	 */
	public SimpleResultPage(String pageName) {
		super(pageName);
		// TODO Auto-generated constructor stub
	}
	public SimpleResultPage( EList<Operator> ops){
		super(PAGENAME);
		this.ops=ops;
	}
	/* (non-Javadoc)
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
		table= new Table(composite, SWT.BORDER);
		for(String col: COLUMNNAMES){
			TableColumn c= new TableColumn(table, SWT.NONE);
			c.setText(col);
		}
			
		for(Operator o:ops){
			ResultObject r = o.getResult();
			if(r!=null){
				for(Entry<String, Object>entry:r.getPropertyMap().entrySet()){
					TableItem item= new TableItem(table, SWT.NONE);
					item.setText(o.getName());
					item.setText(0, o.getName());
					item.setText(1, entry.getKey());
					item.setText(2, entry.getValue().toString());
			}
			}

		}
		for(TableColumn c:table.getColumns())
			c.pack();
		
		
	}
	
}
