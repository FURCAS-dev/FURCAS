package de.hpi.sam.bp2009.benchframework.testrunWizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import de.hpi.sam.bp2009.benchframework.Operator;

public class OperatorTable {
	
	public List<Operator> operatorList= new ArrayList<Operator>();
	public List<Operator> selectedOperatorList= new ArrayList<Operator>();
	private TableViewer tv;
	private OperatorCellModifier modifier;

	public static String ORDERNR="Order";
	public static String NAME="Name";
	public static String DESCRIPTION="Description";
	public static final String[] PROPS = { ORDERNR, NAME, DESCRIPTION};
	void refresh(){
		tv.refresh();
	}
	void createTable(Composite parent){
		 	tv = new TableViewer(parent, SWT.BORDER |SWT.MULTI |SWT.FULL_SELECTION);
		    tv.setContentProvider(new OperatorContentProvider());
		    tv.setLabelProvider(new OperatorLabelProvider(this));
		    tv.setInput(operatorList);
		    Table table = tv.getTable();
		    table.setLayoutData(new GridData(GridData.FILL_BOTH));
		    
		    new TableColumn(table, SWT.CENTER).setText(ORDERNR);
		    new TableColumn(table, SWT.CENTER).setText(NAME);
		    new TableColumn(table, SWT.CENTER).setText(DESCRIPTION);


		    for (int i = 0, n = table.getColumnCount(); i < n; i++) {
		      table.getColumn(i).pack();
		    }

		    table.setHeaderVisible(true);
		    table.setLinesVisible(true);

//		    newPerson.addSelectionListener(new SelectionAdapter() {
//		      public void widgetSelected(SelectionEvent event) {
//		        Student p = new Student();
//		        p.setName("Name");
//		        p.setMale(true);
//		        p.setAgeRange(Integer.valueOf("0"));
//		        p.setShirtColor(new RGB(255, 0, 0));
//		        studentList.add(p);
//		        tv.refresh();
//		      }
//		    });

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
					// TODO Auto-generated method stub
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
		    System.out.println(tv.isCellEditorActive());
		    table.pack();
		    tv.refresh();
		   		    
		
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
		    return true;
		  }

		  public Object getValue(Object element, String property) {
		    Operator opObj = (Operator) element;
		    if (OperatorTable.NAME.equals(property))
		      return opObj.getName();
		    else if (OperatorTable.ORDERNR.equals(property))
		      return table.operatorList.indexOf(opObj)+"";
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
		    	if(i>=table.operatorList.size())
		    		i=table.operatorList.size()-1;
		    	table.operatorList.remove(p);
		    	table.operatorList.add(i,p);
		    }
		    }catch(NumberFormatException e)
		    {e.printStackTrace();}

		    viewer.refresh();
		  }
		}
	class OperatorContentProvider implements IStructuredContentProvider {
		  public Object[] getElements(Object inputElement) {
		    return ((List) inputElement).toArray();
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
		      return (table.operatorList.indexOf(op))+"";
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

}
