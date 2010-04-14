/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 * 
 * $Id: TableViewerComposite.java,v 1.1 2008/05/26 12:25:13 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tabbedproperties.sections.widgets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecoretools.tabbedproperties.AbstractTabbedPropertySheetPage;
import org.eclipse.emf.ecoretools.tabbedproperties.internal.Messages;
import org.eclipse.emf.ecoretools.tabbedproperties.internal.sections.TableObjectManager;
import org.eclipse.emf.ecoretools.tabbedproperties.internal.sections.listeners.CellModifier;
import org.eclipse.emf.ecoretools.tabbedproperties.providers.TabbedPropertiesLabelProvider;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * This widget contains a TableViewer representing the Parameters of an
 * Operation. There are two Buttons (one for adding a new Parameter, the other
 * for deleting the current selected Parameter)
 * 
 * Creation 10 august 06 Last Modified 11 august 06
 * 
 * @author <a href="alfredo@anyware-tech.com">Jose Alfredo SERRANO</a>
 */
public class TableViewerComposite extends Composite {

	private TabbedPropertySheetWidgetFactory widgetFactory;

	private TableObjectManager objectManager;

	private TableViewer tableViewer;

	private Table table;

	private String[] columnNames;

	private Button addButton;

	private Button removeButton;

	private List<Button> otherButtons;

	private ILabelProvider labelProvider;

	private final Set<SelectionListener> selectionListeners;

	private SelectionListener removeListener = new SelectionAdapter() {

		public void widgetSelected(SelectionEvent e) {
			int index = table.getSelectionIndex();
			Object object = table.getItem(index).getData();
			removeElement(object);
			fireWidgetSelected();
		}
	};

	private SelectionListener addListener = new SelectionAdapter() {

		public void widgetSelected(SelectionEvent e) {
			addElement();
			fireWidgetSelected();
		}
	};

	/**
	 * InnerClass that acts as a proxy for the TableObjectManager providing
	 * content for the Table. It implements the IEObjectModifyListener interface
	 * since it must register changeListeners with the TableObjectManager
	 */
	class TableContentProvider implements IStructuredContentProvider {

		/**
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
		 *      java.lang.Object, java.lang.Object)
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// Do nothing
		}

		/**
		 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
		 */
		public void dispose() {
			// Do nothing
		}

		/**
		 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
		 */
		public Object[] getElements(Object inputElement) {
			List<?> list = objectManager.eGet();
			int size = list.size();
			return list.toArray(new Object[size]);
		}
	}

	/**
	 * The constructor
	 * 
	 * @param parent
	 *            a widget which will be the parent of the new instance (cannot
	 *            be null)
	 * @param colNames
	 *            the name of the different columns of the table
	 * @param widgetFactory
	 *            the widgetFactory to use to create the widgets
	 */
	public TableViewerComposite(Composite parent, String[] colNames, TabbedPropertySheetWidgetFactory widgetFactory) {
		super(parent, SWT.NONE);

		this.widgetFactory = widgetFactory;
		this.widgetFactory.adapt(this);

		setLayout(new GridLayout(2, false));

		this.columnNames = colNames;
		createContents();

		labelProvider = new TabbedPropertiesLabelProvider(new ComposedAdapterFactory(AbstractTabbedPropertySheetPage.getPrincipalAdapterFactories()));

		selectionListeners = new HashSet<SelectionListener>();
	}

	/**
	 * Create the Composite composed of a Table and two Buttons
	 */
	private void createContents() {
		createTable(this);
		createButtons(this);
		createTableViewer();
	}

	/**
	 * TODO modify the table appearance Create the Table
	 * 
	 * @param parent
	 *            the parent Composite
	 */
	protected void createTable(Composite parent) {
		int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.HIDE_SELECTION;

		table = widgetFactory.createTable(parent, style);

		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.grabExcessVerticalSpace = true;
		gridData.verticalSpan = 2;
		table.setLayoutData(gridData);

		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		createColumns(table, columnNames);
	}

	/**
	 * Create the table columns
	 * 
	 * @param tab
	 * @param colNames
	 */
	private void createColumns(Table tab, String[] colNames) {
		for (int i = 0; i < colNames.length; i++) {
			TableColumn column = new TableColumn(tab, SWT.LEFT, i);
			column.setText(colNames[i]);
			column.setWidth(100);
		}
	}

	/**
	 * Create the TableViewer
	 */
	protected void createTableViewer() {
		tableViewer = new TableViewer(table);
		tableViewer.setUseHashlookup(true);

		tableViewer.setColumnProperties(columnNames);

		// Set the cell modifier for the viewer
		tableViewer.setCellModifier(new CellModifier(this));
		// Setup the table viewer
		tableViewer.setContentProvider(new TableContentProvider());

		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (table.getSelection().length > 0) {
					updateSelectedItem(table.getSelection()[0].getData());
				} else {
					updateSelectedItem(null);
				}
			}

		});
	}

	/**
	 * Create cell type
	 * 
	 * @param numberOfCells
	 * @return an array of cell editors
	 */
	private CellEditor[] createCells(int numberOfCells) {
		if (numberOfCells < 0) {
			return new CellEditor[0];
		}

		CellEditor[] editors = new CellEditor[numberOfCells];
		for (int i = 0; i < numberOfCells; i++) {
			CellEditor cellEditor;
			switch (objectManager.getEType()) {
			case TableObjectManager.BOOL:
				cellEditor = new CheckboxCellEditor(table);
				editors[i] = cellEditor;
				break;
			case TableObjectManager.ENUM:
				cellEditor = new ComboBoxCellEditor(table, objectManager.getEnumLiterals(), SWT.READ_ONLY);
				editors[i] = cellEditor;
				break;
			case TableObjectManager.INT:
			case TableObjectManager.B_INT:
			case TableObjectManager.DBL:
				cellEditor = new TextCellEditor(table);
				Text text = (Text) cellEditor.getControl();
				text.setTextLimit(7);
				text.addVerifyListener(new VerifyListener() {

					public void verifyText(VerifyEvent e) {
						e.doit = "0123456789".indexOf(e.text) >= 0; //$NON-NLS-1$
					}
				});
				editors[i] = cellEditor;
				break;
			case TableObjectManager.STR:
				cellEditor = new TextCellEditor(table);
				((Text) cellEditor.getControl()).setTextLimit(60);
				editors[i] = cellEditor;
				break;
			default:
				break;
			}
		}
		return editors;
	}

	/**
	 * Create ADD and REMOVE buttons in the section composite
	 * 
	 * @param parent
	 *            the parent Composite
	 */
	protected void createButtons(Composite parent) {
		final Composite comp = widgetFactory.createComposite(parent);
		comp.setLayout(new GridLayout());

		createAddButton(comp);
		createRemoveButton(comp);
		createOtherButtons(comp);
		hookListeners();
	}

	/**
	 * Create the ADD button
	 * 
	 * @param comp
	 *            the parent Composite
	 */
	protected void createAddButton(Composite comp) {
		addButton = widgetFactory.createButton(comp, Messages.TableViewerComposite_Add, SWT.NONE);
		addButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	}

	/**
	 * Create the REMOVE button
	 * 
	 * @param comp
	 *            the parent Composite
	 */
	protected void createRemoveButton(Composite comp) {
		removeButton = widgetFactory.createButton(comp, Messages.TableViewerComposite_Remove, SWT.NONE);
		removeButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	}

	/**
	 * User may implement other buttons to be displayed at the right side of the
	 * table. This method must initialize a list of Buttons.
	 * 
	 * @param comp
	 *            The composite where buttons are going to be created
	 */
	protected void createOtherButtons(Composite comp) {
		otherButtons = new ArrayList<Button>();
	}

	/**
	 * Hook the listeners
	 */
	protected void hookListeners() {
		table.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				fireWidgetSelected();
			}
		});
		hookButtonListeners();
	}

	/**
	 * Hook the listeners
	 */
	protected void hookButtonListeners() {
		if (addButton != null && removeButton != null) {
			addButton.addSelectionListener(addListener);
			removeButton.addSelectionListener(removeListener);
		}
	}

	/**
	 * Sets or clears the input for this viewer
	 * 
	 * @param eObject
	 *            EObject to be represented
	 * @param feature
	 *            Feature to modify
	 */
	public void setInput(EObject eObject, EStructuralFeature feature) {
		if (objectManager == null || !objectManager.getInputEObject().equals(eObject)) {
			objectManager = new TableObjectManager(eObject, feature);
			objectManager.setLabelProvider(labelProvider);
			tableViewer.setInput(objectManager);
			// Create the cell editors
			CellEditor[] editors = createCells(columnNames.length);

			// Assign the cell editors to the viewer
			tableViewer.setCellEditors(editors);
		}
	}

	/**
	 * Sets the label provider for this viewer.
	 * 
	 * When the given parameter is null, it will set a default label provider,
	 * in particular when the table viewer is going to display multifeature
	 * Attributes. In order to display multifeature references, client may pass
	 * a AdapterFactoryLabelProvider.
	 * 
	 * @param labelProvider
	 *            The label Provider.
	 */
	public void setLabelProvider(IBaseLabelProvider labelProvider) {
		if (labelProvider instanceof ILabelProvider) {
			this.labelProvider = (ILabelProvider) labelProvider;
			tableViewer.setLabelProvider(labelProvider);
			if (objectManager != null) {
				objectManager.setLabelProvider(this.labelProvider);
			}
		}
	}

	/**
	 * @see org.eclipse.swt.widgets.Control#setEnabled(boolean)
	 */
	public void setEnabled(boolean enabled) {
		table.setEnabled(enabled);
		if (addButton != null && !addButton.isDisposed()) {
			addButton.setEnabled(enabled);
		}
		if (removeButton != null && !removeButton.isDisposed()) {
			removeButton.setEnabled(enabled);
		}
	}

	/**
	 * Modification will be taken in charge by the object manager. Client may
	 * specify an editing domain to consider modifications
	 * 
	 * @param editingDomain
	 *            Manages a self-contained set of interrelated EMF models and
	 *            the {@link Command}s that modify them.
	 */
	public void setEditingDomain(EditingDomain editingDomain) {
		objectManager.setEditingDomain(editingDomain);
	}

	/**
	 * Refresh the Table contents when model has been changed from the outside.
	 */
	public void refresh() {
		tableViewer.refresh();
	}

	/**
	 * Add a new empty Element in the ObjectManager
	 */
	public void addElement() {
		if (objectManager != null) {
			objectManager.addElement();
		}
	}

	/**
	 * Add the given Element in the ObjectManager
	 * 
	 * @param newElement
	 *            the Element to add
	 */
	public void addElement(Object newElement) {
		if (objectManager != null) {
			objectManager.addElement(newElement);
		}
	}

	/**
	 * Remove the given Element from the ObjectManager
	 * 
	 * @param element
	 *            the Element to remove
	 */
	public void removeElement(Object element) {
		if (objectManager != null) {
			objectManager.removeElement(element);
		}
	}

	/**
	 * Gets a collection of current column names
	 * 
	 * @return List of the current column names
	 */
	public String[] getColumnHeaders() {
		return columnNames;
	}

	/**
	 * Set a new set of columns
	 * 
	 * @param newColumnNames
	 *            Array containing the column names
	 */
	public void setColumnNames(String[] newColumnNames) {
		columnNames = newColumnNames.clone();
	}

	/**
	 * @return Return the TableObjectManager
	 */
	public TableObjectManager getObjectManager() {
		return objectManager;
	}

	/**
	 * @return Return the add button
	 */
	public Button getAddButton() {
		return addButton;
	}

	/**
	 * @return Return the remove button
	 */
	public Button getRemoveButton() {
		return removeButton;
	}

	/**
	 * @return Returns the list of buttons added if any, otherwise buttons list
	 *         is null;
	 */
	public List<Button> getOtherButtons() {
		return otherButtons;
	}

	/**
	 * Update the new Buttons to use with the Composite
	 * 
	 * @param buttons
	 *            a list of Buttons
	 */
	public void setOtherButtons(List<Button> buttons) {
		otherButtons = buttons;
	}

	/**
	 * Returns the current selection from the table
	 * 
	 * @return The Structured selection from this table
	 */
	public ISelection getSelection() {
		return tableViewer.getSelection();
	}

	/**
	 * Returns the first object that has been selected
	 * 
	 * @return The first object of the selection
	 */
	public Object getSelectionItem() {
		ISelection sel = getSelection();
		if (sel instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) sel;
			return ssel.getFirstElement();
		}
		return null;
	}

	/**
	 * Returns the contents of this table as a list.
	 * 
	 * @return The list of contest corresponding to this EStructuralFeature
	 */
	public List<?> getValue() {
		return objectManager.eGet();
	}

	/**
	 * Set the Listener to associate with the ADD button
	 * 
	 * @param listener
	 *            a SelectionListener
	 */
	public void setAddListener(SelectionListener listener) {
		SelectionListener oldListener = addListener;
		addListener = listener;
		addButton.removeSelectionListener(oldListener);
		addButton.addSelectionListener(addListener);
	}

	/**
	 * Set the Listener to associate with the REMOVE button
	 * 
	 * @param listener
	 *            a SelectionListener
	 */
	public void setRemoveListener(SelectionListener listener) {
		SelectionListener oldListener = removeListener;
		removeListener = listener;
		removeButton.removeSelectionListener(oldListener);
		removeButton.addSelectionListener(removeListener);
	}

	/**
	 * Return the table composite
	 * 
	 * @return Table
	 */
	public Table getTable() {
		return table;
	}

	/**
	 * This method is called each time a new item is selected in the Table. When
	 * client desire to do something when an item is selected, this method must
	 * be overrided
	 * 
	 * @param data
	 *            the new item that was selected
	 */
	public void updateSelectedItem(Object data) {
		// do nothing
	}

	/**
	 * @return the widgetFactory
	 */
	protected TabbedPropertySheetWidgetFactory getWidgetFactory() {
		return widgetFactory;
	}

	/**
	 * Notifies selection listeners
	 */
	protected void fireWidgetSelected() {
		for (SelectionListener listener : selectionListeners) {
			Event e = new Event();
			e.widget = table;
			listener.widgetSelected(new SelectionEvent(e));
		}
	}

	/**
	 * Adds a selection listener
	 * 
	 * @param listener
	 *            The listener to add
	 */
	public void addSelectionListener(SelectionListener listener) {
		selectionListeners.add(listener);
	}

	/**
	 * Removes a selection listener
	 * 
	 * @param listener
	 *            The listener to remove
	 */
	public void removeSelectionListener(SelectionListener listener) {
		selectionListeners.remove(listener);
	}
}
