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
 * $Id: NameSection.java,v 1.4 2008/05/26 12:28:57 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.properties.internal.metadata;

import java.util.Iterator;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecoretools.properties.internal.Messages;
import org.eclipse.emf.ecoretools.tabbedproperties.EMFRecordingChangeCommand;
import org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection;
import org.eclipse.emf.ecoretools.tabbedproperties.utils.TextChangeListener;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

/**
 * Section to edit name extended metadata annotation
 * 
 * @see ExtendedMetaData#setName(EStructuralFeature, String)
 * @see ExtendedMetaData#setName(EClassifier, String)
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class NameSection extends AbstractTabbedPropertySection {

	/**
	 * A boolean that store if refreshing is happening and no model
	 * modifications should be performed
	 */
	private boolean isRefreshing = false;

	/**
	 * The text for the section.
	 */
	private Text nameTxt;

	/**
	 * The section label;
	 */
	private CLabel labelTxt;

	// /**
	// * @see
	// org.eclipse.ui.views.properties.tabbed.ISection#createControls(org.eclipse.swt.widgets.Composite,
	// * org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	// */
	// public void createControls(Composite parent, TabbedPropertySheetPage
	// aTabbedPropertySheetPage)
	// {
	// super.createControls(parent, aTabbedPropertySheetPage);
	// Composite composite = getWidgetFactory().createFlatFormComposite(parent);
	// FormData data;
	//
	// String label = getLabelText();
	// CLabel labelTxt = getWidgetFactory().createCLabel(composite, label);
	//
	// nameTxt = getWidgetFactory().createText(composite, "");
	//
	// data = new FormData();
	// data.left = new FormAttachment(0, 0);
	// data.right = new FormAttachment(nameTxt,
	// -ITabbedPropertyConstants.HSPACE);
	// data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
	// labelTxt.setLayoutData(data);
	//
	// data = new FormData();
	// data.left = new FormAttachment(0, getStandardLabelWidth(composite, new
	// String[] {label}));
	// data.right = new FormAttachment(100, 0);
	// data.top = new FormAttachment(labelTxt, 0, SWT.CENTER);
	// nameTxt.setLayoutData(data);
	//
	// hookListeners();
	// }

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createWidgets(Composite composite) {
		labelTxt = getWidgetFactory().createCLabel(composite, getLabelText());

		nameTxt = getWidgetFactory().createText(composite, ""); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void setSectionData(Composite composite) {
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(nameTxt, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		labelTxt.setLayoutData(data);

		data = new FormData();
		data.left = new FormAttachment(0, getStandardLabelWidth(composite, new String[] { getLabelText() }));
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(labelTxt, 0, SWT.CENTER);
		nameTxt.setLayoutData(data);
	}

	/**
	 * Adds the listeners on the widgets
	 */
	@Override
	protected void hookListeners() {
		TextChangeListener listener = new TextChangeListener() {

			@Override
			public void textChanged(Control control) {
				handleTextModified();
			}
		};
		listener.startListeningTo(nameTxt);
		listener.startListeningForEnter(nameTxt);
	}

	/**
	 * Handle the text modified event.
	 */
	protected void handleTextModified() {
		if (!isRefreshing) {
			final String newName = nameTxt.getText();
			EditingDomain editingDomain = getEditingDomain();
			if (getEObjectList().size() == 1) {
				String oldName = getName(getEObject());
				if (oldName != null && !oldName.equals(newName)) {
					editingDomain.getCommandStack().execute(new EMFRecordingChangeCommand(getEObject().eResource()) {

						@Override
						protected void doExecute() {
							if (getEObject() instanceof EStructuralFeature) {
								ExtendedMetaData.INSTANCE.setName((EStructuralFeature) getEObject(), newName);
							}
							if (getEObject() instanceof EClassifier) {
								ExtendedMetaData.INSTANCE.setName((EClassifier) getEObject(), newName);
							}
						}
					});
				}
			} else {
				CompoundCommand compoundCommand = new CompoundCommand();
				/* apply the property change to all selected elements */
				for (Iterator<EObject> i = getEObjectList().iterator(); i.hasNext();) {
					final EObject nextObject = i.next();

					String oldName = getName(nextObject);
					if (oldName != null && !oldName.equals(newName)) {
						editingDomain.getCommandStack().execute(new EMFRecordingChangeCommand(nextObject.eResource()) {

							@Override
							protected void doExecute() {
								if (nextObject instanceof EStructuralFeature) {
									ExtendedMetaData.INSTANCE.setName((EStructuralFeature) nextObject, newName);
								}
								if (nextObject instanceof EClassifier) {
									ExtendedMetaData.INSTANCE.setName((EClassifier) nextObject, newName);
								}
							}
						});
					}
				}
				editingDomain.getCommandStack().execute(compoundCommand);
			}
		}
	}

	/**
	 * Get the name of the model object depending on its type
	 * 
	 * @param model
	 *            The model object
	 * @return String
	 */
	private String getName(EObject model) {
		if (model instanceof EStructuralFeature) {
			return ExtendedMetaData.INSTANCE.getName((EStructuralFeature) model);
		}
		if (model instanceof EClassifier) {
			return ExtendedMetaData.INSTANCE.getName((EClassifier) model);
		}
		return ""; //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
	 */
	@Override
	public void refresh() {
		isRefreshing = true;

		nameTxt.setText(getName(getEObject()));

		isRefreshing = false;
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
	 */
	@Override
	protected EStructuralFeature getFeature() {
		return null;
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
	 */
	@Override
	protected String getLabelText() {
		return Messages.NameSection_Name;
	}

}
