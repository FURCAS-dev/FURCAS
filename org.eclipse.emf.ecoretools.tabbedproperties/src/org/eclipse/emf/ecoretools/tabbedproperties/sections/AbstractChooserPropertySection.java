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
 * $Id: AbstractChooserPropertySection.java,v 1.2 2008/12/04 14:58:21 dsciamma Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tabbedproperties.sections;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecoretools.tabbedproperties.providers.TabbedPropertiesLabelProvider;
import org.eclipse.emf.ecoretools.tabbedproperties.sections.widgets.CSingleObjectChooser;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * An abstract implementation of a section with a field using a
 * CSingleObjectChooser composite (CCombo with a Button).
 * 
 * Creation 5 apr. 2006 Updated 7 aug. 2006
 * 
 * @author Jacques LESCOT
 * @author Alfredo SERRANO
 */
public abstract class AbstractChooserPropertySection extends AbstractTabbedPropertySection {

	/**
	 * A boolean that store if refreshing is happening and no model
	 * modifications should be performed
	 */
	private boolean isRefreshing = false;

	/**
	 * The combo box control for the section.
	 */
	private CSingleObjectChooser cSingleObjectChooser;

	/**
	 * The label for this section
	 */
	private CLabel labelCombo;

	/**
	 * Section composite. This composite can be return if client desire to
	 * implement other widgets in relation with the list represented by this
	 * instance.
	 */
	// private Composite sectionComposite;
	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		// sectionComposite =
		// getWidgetFactory().createFlatFormComposite(parent);
		//
		// labelCombo = getWidgetFactory().createCLabel(sectionComposite,
		// getLabelText());
		//
		// cSingleObjectChooser = new CSingleObjectChooser(sectionComposite,
		// getWidgetFactory(), SWT.NONE);
		// cSingleObjectChooser.setLabelProvider(getLabelProvider());
		//
		//
		// if (getFeature() != null)
		// {
		// cSingleObjectChooser.setChangeable(getFeature().isChangeable());
		// }
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
	 */
	protected void createWidgets(Composite composite) {
		labelCombo = getWidgetFactory().createCLabel(composite, getLabelText());

		cSingleObjectChooser = new CSingleObjectChooser(composite, getWidgetFactory(), SWT.NONE);
		cSingleObjectChooser.setLabelProvider(getLabelProvider());
		cSingleObjectChooser.setSection(this);

		if (getFeature() != null) {
			cSingleObjectChooser.setChangeable(getFeature().isChangeable());
		}

	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
	 */
	protected void setSectionData(Composite composite) {
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(cSingleObjectChooser, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		labelCombo.setLayoutData(data);

		data = new FormData();
		data.left = new FormAttachment(0, getStandardLabelWidth(composite, new String[] { getLabelText() }));
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(labelCombo, 0, SWT.CENTER);
		cSingleObjectChooser.setLayoutData(data);

	}

	/**
	 * Adds the listeners on the widgets
	 */
	protected void hookListeners() {
		cSingleObjectChooser.addSelectionListener(new SelectionAdapter() {

			/**
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				handleComboModified();
			}
		});
	}

	/**
	 * Handle the combo modified event.
	 */
	protected void handleComboModified() {
		if (!isRefreshing && getFeatureValue() != cSingleObjectChooser.getSelection()) {
			EditingDomain editingDomain = getEditingDomain();
			if (getEObjectList().size() == 1) {
				/* apply the property change to single selected object */
				editingDomain.getCommandStack().execute(SetCommand.create(editingDomain, getEObject(), getFeature(), cSingleObjectChooser.getSelection()));
			} else {
				CompoundCommand compoundCommand = new CompoundCommand();
				/* apply the property change to all selected elements */
				for (EObject nextObject : getEObjectList()) {
					compoundCommand.append(SetCommand.create(editingDomain, nextObject, getFeature(), cSingleObjectChooser.getSelection()));
				}
				editingDomain.getCommandStack().execute(compoundCommand);
			}
		}
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
	 */
	public void refresh() {
		isRefreshing = true;
		cSingleObjectChooser.setChangeable(!isReadOnly());
		cSingleObjectChooser.setChoices(getComboFeatureValues());
		cSingleObjectChooser.setSelection(getFeatureValue());
		isRefreshing = false;
	}

	/**
	 * @return the cSingleObjectChooser
	 */
	protected CSingleObjectChooser getCSingleObjectChooser() {
		return cSingleObjectChooser;
	}

	/**
	 * @return the isRefreshing
	 */
	protected boolean isRefreshing() {
		return isRefreshing;
	}

	/**
	 * Returns an array of all reachable objects of a given type from the
	 * current selection.
	 * 
	 * @param object
	 *            current EObject selection
	 * @param type
	 *            Reachable object which have this type
	 * @return An array of objects of the given type
	 */
	protected Object[] getChoices(EObject object, EClassifier type) {
		List<Object> choices = new ArrayList<Object>();
		choices.add(""); //$NON-NLS-1$
		choices.addAll(ItemPropertyDescriptor.getReachableObjectsOfType(getEObject(), type));

		return choices.toArray();
	}

	/**
	 * Returns the label text for the given item
	 * 
	 * @param object
	 *            the item to find the name
	 * @return The found name of the given item
	 */
	protected String getItemLabelText(EObject object) {
		return object.toString();
	}

	/**
	 * Get the LabelProvider to use to display the Object
	 * 
	 * @return ILabelProvider
	 */
	protected ILabelProvider getLabelProvider() {
		return new TabbedPropertiesLabelProvider(new EcoreItemProviderAdapterFactory());
	}

	/**
	 * Get the current feature value of the selected model object.
	 * 
	 * @return the feature value to select in the ccombo.
	 */
	protected abstract Object getFeatureValue();

	/**
	 * Get the enumeration values of the feature for the combo field for the
	 * section.
	 * 
	 * @return the list of values of the feature as text.
	 */
	protected abstract Object[] getComboFeatureValues();
}