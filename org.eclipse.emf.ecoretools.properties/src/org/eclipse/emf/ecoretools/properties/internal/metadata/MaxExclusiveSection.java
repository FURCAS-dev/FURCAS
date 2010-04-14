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
 * $Id: MaxExclusiveSection.java,v 1.4 2008/05/26 12:28:57 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.properties.internal.metadata;

import java.util.Iterator;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EDataType;
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
 * Section to edit max exclusive extended metadata annotation
 * 
 * @see ExtendedMetaData#setMaxExclusiveFacet(EDataType, String)
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class MaxExclusiveSection extends AbstractTabbedPropertySection {

	/**
	 * A boolean that store if refreshing is happening and no model
	 * modifications should be performed
	 */
	private boolean isRefreshing = false;

	/**
	 * The text for the section.
	 */
	private Text constraintTxt;

	/**
	 * The section label;
	 */
	private CLabel labelTxt;

	// /**
	// * @see
	// org.eclipse.ui.views.properties.tabbed.ISection#createControls(org.eclipse.swt.widgets.Composite,
	// org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
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
	// constraintTxt = getWidgetFactory().createText(composite, "");
	//
	// data = new FormData();
	// data.left = new FormAttachment(0, 0);
	// data.right = new FormAttachment(constraintTxt,
	// -ITabbedPropertyConstants.HSPACE);
	// data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
	// labelTxt.setLayoutData(data);
	//
	// data = new FormData();
	// data.left = new FormAttachment(0, getStandardLabelWidth(composite, new
	// String[] {label}));
	// data.right = new FormAttachment(100, 0);
	// data.top = new FormAttachment(labelTxt, 0, SWT.CENTER);
	// constraintTxt.setLayoutData(data);
	//
	// hookListeners();
	// }

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createWidgets(Composite composite) {
		labelTxt = getWidgetFactory().createCLabel(composite, getLabelText());

		constraintTxt = getWidgetFactory().createText(composite, ""); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void setSectionData(Composite composite) {
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(constraintTxt, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		labelTxt.setLayoutData(data);

		data = new FormData();
		data.left = new FormAttachment(0, getStandardLabelWidth(composite, new String[] { getLabelText() }));
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(labelTxt, 0, SWT.CENTER);
		constraintTxt.setLayoutData(data);
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
		listener.startListeningTo(constraintTxt);
		listener.startListeningForEnter(constraintTxt);
	}

	/**
	 * Handle the text modified event.
	 */
	protected void handleTextModified() {
		if (!isRefreshing) {
			final String newConstraint = getText();
			EditingDomain editingDomain = getEditingDomain();
			if (getEObjectList().size() == 1) {
				String oldConstraint = ExtendedMetaData.INSTANCE.getMaxExclusiveFacet((EDataType) getEObject());
				if ((oldConstraint != null && !oldConstraint.equals(newConstraint)) || (oldConstraint == null && newConstraint != null)) {
					editingDomain.getCommandStack().execute(new EMFRecordingChangeCommand(getEObject().eResource()) {

						@Override
						protected void doExecute() {
							ExtendedMetaData.INSTANCE.setMaxExclusiveFacet((EDataType) getEObject(), newConstraint);
						}
					});
				}
			} else {
				CompoundCommand compoundCommand = new CompoundCommand();
				/* apply the property change to all selected elements */
				for (Iterator<EObject> i = getEObjectList().iterator(); i.hasNext();) {
					final EObject nextObject = i.next();

					String oldConstraint = ExtendedMetaData.INSTANCE.getMaxExclusiveFacet((EDataType) nextObject);
					if ((oldConstraint != null && !oldConstraint.equals(newConstraint)) || (oldConstraint == null && newConstraint != null)) {
						editingDomain.getCommandStack().execute(new EMFRecordingChangeCommand(nextObject.eResource()) {

							@Override
							protected void doExecute() {
								ExtendedMetaData.INSTANCE.setMaxExclusiveFacet((EDataType) nextObject, newConstraint);
							}
						});
					}
				}
				editingDomain.getCommandStack().execute(compoundCommand);
			}
		}
	}

	private String getText() {
		if (constraintTxt.getText() != null && !"".equals(constraintTxt.getText())) { //$NON-NLS-1$
			return constraintTxt.getText();
		}

		return null;
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
	 */
	@Override
	public void refresh() {
		isRefreshing = true;

		String text = ExtendedMetaData.INSTANCE.getMaxExclusiveFacet((EDataType) getEObject());
		if (text == null) {
			text = ""; //$NON-NLS-1$
		}
		constraintTxt.setText(text);

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
		return Messages.MaxExclusiveSection_MaximumConstraint;
	}

}
