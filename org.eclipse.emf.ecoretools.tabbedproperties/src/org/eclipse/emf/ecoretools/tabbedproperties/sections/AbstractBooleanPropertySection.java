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
 * $Id: AbstractBooleanPropertySection.java,v 1.2 2008/12/04 14:58:21 dsciamma Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tabbedproperties.sections;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * An abstract implementation of a section with a check button. It represents a
 * boolean field.
 * 
 * Creation 5 apr. 2006 Updated 7 aug. 2006
 * 
 * @author Jacques Lescot
 * @author Alfredo Serrano
 */
public abstract class AbstractBooleanPropertySection extends AbstractTabbedPropertySection {

	/**
	 * The checkButton control for the section.
	 */
	private Button checkButton;

	/**
	 * Listen events when the check box is selected
	 */
	private SelectionListener listener = new SelectionListener() {

		public void widgetSelected(SelectionEvent e) {
			handleCheckButtonModified();
		}

		public void widgetDefaultSelected(SelectionEvent e) {
			// Do nothing
		}
	};

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#createControls(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		// Composite composite =
		// getWidgetFactory().createFlatFormComposite(parent);
		// checkButton = getWidgetFactory().createButton(composite,
		// getLabelText(), SWT.CHECK);
		//
		// FormData data;
		// data = new FormData();
		// data.left = new FormAttachment(0, 0);
		// data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		// checkButton.setLayoutData(data);

		// checkButton.addSelectionListener(listener);
		//
		// if (getFeature() != null)
		// {
		// checkButton.setEnabled(getFeature().isChangeable());
		// }
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
	 */
	protected void createWidgets(Composite composite) {
		checkButton = getWidgetFactory().createButton(composite, getLabelText(), SWT.CHECK);

		if (getFeature() != null) {
			checkButton.setEnabled(getFeature().isChangeable());
		}

	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
	 */
	protected void setSectionData(Composite composite) {
		FormData data;
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		checkButton.setLayoutData(data);

	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#hookListeners()
	 */
	protected void hookListeners() {
		checkButton.addSelectionListener(listener);
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	public void refresh() {
		checkButton.setEnabled(!isReadOnly());
		checkButton.setSelection(getFeatureValue());
	}

	/**
	 * Handle the checkbutton modified event.
	 */
	protected void handleCheckButtonModified() {
		createCommand(Boolean.valueOf(getFeatureValue()), Boolean.valueOf(checkButton.getSelection()));
	}

	/**
	 * @return the checkButton
	 */
	protected Button getCheckButton() {
		return checkButton;
	}

	/**
	 * Get the new value of the feature for the text field for the section.
	 * 
	 * @return the boolean value of the feature.
	 */
	protected boolean getFeatureValue() {
		Object bool = getEObject().eGet(getFeature());
		if (bool == null || !(bool instanceof Boolean)) {
			return false;
		}
		return ((Boolean) bool).booleanValue();

	}

	/**
	 * By default, return the name of the Feature
	 * 
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
	 */
	protected String getLabelText() {
		return getFeature().getName();
	}
}