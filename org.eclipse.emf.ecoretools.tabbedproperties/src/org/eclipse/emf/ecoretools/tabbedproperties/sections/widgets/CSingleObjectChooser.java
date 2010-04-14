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
 * $Id: CSingleObjectChooser.java,v 1.1 2008/05/26 12:25:13 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tabbedproperties.sections.widgets;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TypedListener;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * A field widget and a Button that allow you to retrieve an object contained in
 * a list of objects
 * 
 * Creation 6 avr. 2006
 * 
 * @author David Sciamma
 */
public class CSingleObjectChooser extends Composite {

	private Text field;

	private Button chooseBt;

	private Object[] objects;

	private TabbedPropertySheetWidgetFactory widgetFactory;

	private ILabelProvider labelProvider;

	private Object selectedObject;

	private AbstractTabbedPropertySection section;

	/**
	 * Constructor
	 * 
	 * @param parent
	 *            the parent Composite
	 * @param factory
	 *            the factory necessary to create the widget
	 * @param style
	 */
	public CSingleObjectChooser(Composite parent, TabbedPropertySheetWidgetFactory factory, int style) {
		super(parent, style);

		this.widgetFactory = factory;
		createContents(this);
		widgetFactory.adapt(this);
		hookListeners();
	}

	/**
	 * Creates the UI. User must call the super method to create the main
	 * widgets (buttons) to this composite.
	 * 
	 * @param parent
	 *            this widget
	 */
	protected void createContents(Composite parent) {
		setLayout(parent);

		field = widgetFactory.createText(parent, "", SWT.FLAT | SWT.BORDER | SWT.READ_ONLY); //$NON-NLS-1$
		field.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		chooseBt = widgetFactory.createButton(parent, "...", SWT.PUSH); //$NON-NLS-1$
	}

	/**
	 * This method sets a gridlayout to the composite. The number of columns is
	 * determined by the getNumberOfColumns method. The minimum number of
	 * columns is 2.
	 * 
	 * @param parent
	 *            the composite featuring a gridlayout
	 */
	private void setLayout(Composite parent) {
		int numColumns = getNumberOfColumns();
		if (numColumns < 2) {
			numColumns = 2;
		}
		GridLayout layout = new GridLayout(numColumns, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		parent.setLayout(layout);
	}

	/**
	 * Returns the number of columns in this composite. The default object is 2
	 * because the main composite have 2 widgets.
	 * 
	 * Returning a number less than 2 will be ingnored.
	 * 
	 * @return The number of columns to set in this composite. It must be
	 *         greater or equals than 2
	 */
	protected int getNumberOfColumns() {
		return 2;
	}

	/**
	 * Adds the listeners on the choose button. If user overrides this method,
	 * he must call the super method to add the corresponding selection
	 * listener, otherwise disfunctions may occur
	 */
	protected void hookListeners() {
		chooseBt.addSelectionListener(new SelectionAdapter() {

			/**
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				handleChoose();
			}
		});
	}

	/**
	 * Set the objects in which the user can choose.
	 * 
	 * @param objs
	 *            the list of objects
	 */
	public void setChoices(Object[] objs) {
		if (objs != null && objs.length > 0) {
			// replace any null entry with a NullObject
			Object[] objects2 = new Object[objs.length];
			for (int cpt = 0; cpt < objs.length; cpt++) {
				if (objs[cpt] == null) {
					objects2[cpt] = new NullObject();
				} else {
					objects2[cpt] = objs[cpt];
				}
			}

			this.objects = objects2;
		}
		setSelection(null);
	}

	/**
	 * Sets the editable state of the text field. The default value is
	 * READ-ONLY. However clients may set this value as true by calling this
	 * method
	 * 
	 * @param isEditable
	 */
	public void setEditable(boolean isEditable) {
		if (field != null) {
			field.setEditable(isEditable);
		}
	}

	/**
	 * Set the provider that displays the objects
	 * 
	 * @param provider
	 *            the LabelProvider
	 */
	public void setLabelProvider(ILabelProvider provider) {
		labelProvider = provider;
	}

	/**
	 * Open the dialog to choose in the searchable list
	 */
	private void handleChoose() {
		section.refresh();
		ChooseDialog dialog = new ChooseDialog(getShell(), objects);
		dialog.setLabelProvider(labelProvider);
		List<Object> selectedObjects = new ArrayList<Object>();
		selectedObjects.add(selectedObject);
		dialog.setInitialElementSelections(selectedObjects);

		if (dialog.open() == Window.OK) {
			Object[] selection = dialog.getResult();

			if (selection != null && selection.length > 0) {
				setSelection(selection[0]);
			} else {
				setSelection(null);
			}

			Event e = new Event();
			notifyListeners(SWT.Selection, e);
		}
	}

	/**
	 * Set whether the Choose button is enabled
	 * 
	 * @param isChangeable
	 */
	public void setChangeable(boolean isChangeable) {
		chooseBt.setEnabled(isChangeable);
	}

	/**
	 * Returns the selected object
	 * 
	 * @return the selection
	 */
	public Object getSelection() {
		return selectedObject;
	}

	/**
	 * Set the selection of the comboViewer
	 * 
	 * @param selection
	 *            the selected object
	 */
	public void setSelection(Object selection) {
		if (selection instanceof NullObject) {
			selectedObject = null;
		} else {
			selectedObject = selection;
		}

		String name = ""; //$NON-NLS-1$
		if (selectedObject != null) {
			name = labelProvider.getText(selectedObject);
			if (name == null) {
				name = ""; //$NON-NLS-1$
			}
		}
		field.setText(name);
	}

	/**
	 * Add a SelectionListener on both the CCombo and the Button
	 * 
	 * @param listener
	 */
	public void addSelectionListener(SelectionListener listener) {
		if (listener == null) {
			SWT.error(SWT.ERROR_NULL_ARGUMENT);
		}
		TypedListener typedListener = new TypedListener(listener);
		addListener(SWT.Selection, typedListener);
	}

	/**
	 * Remove the SelectionListener of the CCombo and the Button
	 * 
	 * @param listener
	 */
	public void removeSelectionListener(SelectionListener listener) {
		if (listener == null) {
			SWT.error(SWT.ERROR_NULL_ARGUMENT);
		}
		removeListener(SWT.Selection, listener);
	}

	/**
	 * An object used to replace a null entry in the comboViewer choices tab
	 * 
	 * Creation 6 avr. 2006
	 * 
	 * @author jlescot
	 */
	static class NullObject {

		/**
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return ""; //$NON-NLS-1$
		}

		/**
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		public boolean equals(Object obj) {
			return obj instanceof NullObject;
		}

	}

	/**
	 * @return the widgetFactory
	 */
	protected TabbedPropertySheetWidgetFactory getWidgetFactory() {
		return widgetFactory;
	}

	/**
	 * Enables/disables itself, and also its contained text and button
	 * 
	 * @see org.eclipse.swt.widgets.Control#setEnabled(boolean)
	 */
	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		field.setEnabled(enabled);
		chooseBt.setEnabled(enabled);
	}

	public void setSection(AbstractTabbedPropertySection abstractTabbedPropertySection) {
		this.section = abstractTabbedPropertySection;
	}
}
