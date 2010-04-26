package de.hpi.sam.bp2009.benchframework.testrunWizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.TestRun;

public class OperatorTable {
	private static final String 	ORDERNR="Order";
	private static final String 	NAME="Name";
	private static final String 	DESCRIPTION="Description";
	/**
	 * names of all columns
	 */
	private static final String[] PROPS = { ORDERNR, NAME, DESCRIPTION};
	/**
	 * Width of each column in percent
	 */
	private static final int[]	PROPSWIDTH={10, 30, 60};
	/**
	 * offset from table to parent in pixel
	 */
	protected static final double OFFSET = 20;

	private List<Operator> selectedOperatorList= new ArrayList<Operator>();
	private TableViewer tv;

	public OperatorTable() {
		int sum=0;
		for(int i:PROPSWIDTH)
			sum+=i;
		Assert.isLegal(!(sum>100),"Column width exceeds 100 percent");
		Assert.isLegal(PROPS.length==PROPSWIDTH.length,"column count and width count do not match");
	}
	private TestframeworkWizard wiz;
	/**
	 * @return the selectedOperatorList
	 */
	public List<Operator> getSelectedOperatorList() {
		return selectedOperatorList;
	}

	/**
	 * Refreshs the contained table
	 */
	void refresh(){
		if(tv==null)
			return;
		tv.setInput(getTestRun().getOperators());
		tv.refresh();
	}
	void createTable(Composite parent){
		tv = new TableViewer(parent, SWT.BORDER_DASH |SWT.MULTI |SWT.FULL_SELECTION);
		tv.setContentProvider(new OperatorContentProvider());
		tv.setLabelProvider(new OperatorLabelProvider(this));
		tv.setInput(getTestRun().getOperators());
		tv.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = tv.getSelection();
				Object[] selectedArray = ((IStructuredSelection) selection).toArray();
				selectedOperatorList=new ArrayList<Operator>();
				for(Object o:selectedArray){
					selectedOperatorList.add((Operator)o);
				}
			}
		});
		Table table = tv.getTable();
		table.setLayoutData(new GridData(GridData.FILL_BOTH));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		for(String text: PROPS)
			new TableColumn(table, SWT.FILL|SWT.CENTER).setText(text);

		table.addControlListener(new ControlListener() {

			@Override
			public void controlResized(ControlEvent e) {
				Table table= tv.getTable();
				for (int i = 0, n = table.getColumnCount(); i < n; i++) {
					int size=(int) ((PROPSWIDTH[i]/100.0)*(table.getParent().getSize().x-OFFSET));
					table.getColumn(i).setWidth(size);
				}

			}

			@Override
			public void controlMoved(ControlEvent e) {
				//nothing to do
			}
		});


		CellEditor[] editors = new CellEditor[4];
		TextCellEditor textEditor = new TextCellEditor(table);
		((Text) textEditor.getControl()).setTextLimit(60);
		textEditor.setValidator(new ICellEditorValidator() {

			@Override
			public String isValid(Object value) {
				try{
					Integer.parseInt(value.toString());
				}catch (NumberFormatException e) {
					return "No Valid Index";
				}
				return null;
			}
		});
		editors[0] = textEditor;
		//textEditor.activate();

		editors[1] = new TextCellEditor(table, SWT.Modify);
		//		    editors[2] = new ComboBoxCellEditor(table, AgeRange.INSTANCES, SWT.READ_ONLY);
		editors[2] = new TextCellEditor(table); 
		tv.setColumnProperties(PROPS);
		tv.setCellModifier(new OperatorCellModifier(tv,this));
		tv.setCellEditors(editors);
		tv.refresh();
		table.pack();



	}

	class OperatorCellModifier implements ICellModifier {
		private Viewer viewer;
		private OperatorTable table;

		public OperatorCellModifier(Viewer viewer) {
			this.viewer = viewer;
		}

		public OperatorCellModifier(TableViewer tv, OperatorTable operatorTable) {
			this(tv);
			this.table=operatorTable;
		}

		public boolean canModify(Object element, String property) {
			return OperatorTable.ORDERNR.equals(property);
		}

		public Object getValue(Object element, String property) {
			Operator opObj = (Operator) element;
			if (OperatorTable.NAME.equals(property))
				return opObj.getName();
			else if (OperatorTable.ORDERNR.equals(property))
				return table.getTestRun().getOperators().indexOf(opObj)+"";
			else if (OperatorTable.DESCRIPTION.equals(property))
				return opObj.getDescription();
			else
				return null;
		}

		public void modify(Object element, String property, Object value) {
			if (element instanceof Item) element = ((Item) element).getData();

			Operator p = (Operator) element;
			try{
				if (OperatorTable.ORDERNR.equals(property)){
					Integer i=Integer.parseInt((String) value);
					EList<Operator> list = table.getTestRun().getOperators();
					if(i>=list.size())
						i=list.size()-1;
					list.remove(p);
					list.add(i,p);
				}
			}catch(NumberFormatException e)
			{e.printStackTrace();}

			viewer.refresh();
		}
	}
	class OperatorContentProvider implements IStructuredContentProvider {
		public Object[] getElements(Object inputElement) {
			return ((List<?>) inputElement).toArray();
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}
	class OperatorLabelProvider implements ITableLabelProvider {
		private OperatorTable table;

		public OperatorLabelProvider(OperatorTable operatorTable) {
			super();
			this.table=operatorTable;
		}

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			Operator op = (Operator) element;
			switch (columnIndex) {
			case 0:
				return (table.getTestRun().getOperators().indexOf(op))+"";
			case 1:
				return op.getName();
			case 2:
				return op.getDescription();
			}
			return null;
		}

		public void addListener(ILabelProviderListener listener) {
		}

		public void dispose() {
		}

		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {
		}
	}

	private TestRun getTestRun(){
		if(getTestframeworkWizard()==null)
			return null;
		return getTestframeworkWizard().getRun();
	}

	public void setWizard(TestframeworkWizard testframeworkWizard) {
		this.wiz=testframeworkWizard;
		
	}
	public TestframeworkWizard getTestframeworkWizard(){
		return wiz;
	}

}
