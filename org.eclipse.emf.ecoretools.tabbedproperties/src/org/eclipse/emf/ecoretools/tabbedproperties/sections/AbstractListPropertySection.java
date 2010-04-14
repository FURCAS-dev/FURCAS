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
 * $Id: AbstractListPropertySection.java,v 1.2 2008/12/04 14:58:21 dsciamma Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tabbedproperties.sections;

import org.eclipse.emf.ecoretools.tabbedproperties.sections.widgets.TableViewerComposite;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * An abstract implementation of a section with a list. It represents a list
 * field.
 * 
 * Creation 9 aug. 2006
 * 
 * @author Alfredo SERRANO
 */
public abstract class AbstractListPropertySection extends AbstractTabbedPropertySection {

	/**
	 * The list control for the section
	 */
	private TableViewerComposite table;

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#createControls(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
	 */
	protected void createWidgets(Composite composite) {
		table = new TableViewerComposite(composite, new String[] { getLabelText() }, getWidgetFactory()) {

			public void updateSelectedItem(Object data) {
				updateSelection(data);
			}
		};
		table.setLabelProvider(getLabelProvider());

		if (getFeature() != null) {
			table.setEnabled(getFeature().isChangeable());
		}
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
	 */
	protected void setSectionData(Composite composite) {
		FormData data;
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, 0);
		table.setLayoutData(data);
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#hookListeners()
	 */
	protected void hookListeners() {
		table.setAddListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				addElement();
			}
		});
	}

	/**
	 * This method may be overriden if client want to implement their own add
	 * treatment
	 * 
	 */
	protected void addElement() {
		table.addElement();
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	public void refresh() {
		table.setEnabled(!isReadOnly());
		table.setInput(getEObject(), getFeature());
		table.setEditingDomain(getEditingDomain());
		table.refresh();
	}

	/**
	 * @return the table
	 */
	public TableViewerComposite getTable() {
		return table;
	}

	/**
	 * Set the table
	 * 
	 * @param table
	 */
	protected void setTable(TableViewerComposite table) {
		this.table = table;
	}

	/**
	 * This method may be overriden if client desire to listen the table
	 * selection
	 * 
	 * @param data
	 *            the selected data from the listened table.
	 */
	public void updateSelection(Object data) {
		// do nothing
	}

	/**
	 * Returns the feature which is multiple
	 * 
	 * @return Object This object is an instance of a java.util.List
	 */
	protected abstract Object getListValues();

	/**
	 * Returns a label provider to be set for this table.
	 * 
	 * @return The Label provider. It may be null when client handles
	 *         attributes.
	 */
	protected abstract IBaseLabelProvider getLabelProvider();

}
