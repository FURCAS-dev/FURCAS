package de.hpi.sam.bp2009.benchframework.testrunWizard;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;

public class ListPage extends WizardPage {
	Table table;
	ExpandBar expandBar;

    protected ListPage(String pageName) {
        super(pageName);
        setTitle("Testrun Configuration");
        setDescription("Choose the steps you want to perform during the test run.");
    }


	@Override
	public void createControl(Composite parent) {
		//create the widgets for the page
		Composite composite = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        composite.setLayout(layout);
        table = new Table(composite, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
        table.setLinesVisible(true);
        table.setHeaderVisible(true);
        GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
        data.heightHint = 200;
        table.setLayoutData(data);
        //fill the table header
        String[] headers = {"Step", "Module", "Options"};
        for (String header:headers){
        	TableColumn column = new TableColumn(table, SWT.NONE);
        	column.setText(header);
        }
        //fill one line of the table
        TableItem item = new TableItem(table, SWT.NONE);
        String[] line = {"1", "Sample Module", "Some Options..."};
        item.setText(line);
        //resize columns according to it's content
        for (int i = 0; i<headers.length; i++){
        	table.getColumn(i).pack();
        }
        setControl(composite);
	}
	@Override
	public boolean canFlipToNextPage() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public IWizardPage getNextPage() {
		// TODO Auto-generated method stub
		return ((TestframeworkWizard)getWizard()).chooseModulePage;
	}
}
