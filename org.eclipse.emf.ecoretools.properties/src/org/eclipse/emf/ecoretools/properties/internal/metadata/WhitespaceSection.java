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
 * $Id: WhitespaceSection.java,v 1.4 2008/05/26 12:28:57 jlescot Exp $
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
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

/**
 * Section to edit whitespace extended metadata annotation
 * 
 * @see ExtendedMetaData#setWhiteSpaceFacet(org.eclipse.emf.ecore.EDataType,
 *      int)
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class WhitespaceSection extends AbstractTabbedPropertySection {

	/**
	 * A boolean that store if refreshing is happening and no model
	 * modifications should be performed
	 */
	private boolean isRefreshing = false;

	/**
	 * The combo box control for the section.
	 */
	private CCombo whitespaceCb;

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
	// whitespaceCb = getWidgetFactory().createCCombo(composite, SWT.FLAT |
	// SWT.READ_ONLY | SWT.BORDER);
	//
	// data = new FormData();
	// data.left = new FormAttachment(0, 0);
	// data.right = new FormAttachment(whitespaceCb,
	// -ITabbedPropertyConstants.HSPACE);
	// data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
	// labelTxt.setLayoutData(data);
	//
	// data = new FormData();
	// data.left = new FormAttachment(0, getStandardLabelWidth(composite, new
	// String[] {label}));
	// data.right = new FormAttachment(100, 0);
	// data.top = new FormAttachment(labelTxt, 0, SWT.CENTER);
	// whitespaceCb.setLayoutData(data);
	//
	// hookListeners();
	// }

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createWidgets(Composite composite) {
		labelTxt = getWidgetFactory().createCLabel(composite, getLabelText());

		whitespaceCb = getWidgetFactory().createCCombo(composite, SWT.FLAT | SWT.READ_ONLY | SWT.BORDER);
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void setSectionData(Composite composite) {
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(whitespaceCb, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		labelTxt.setLayoutData(data);

		data = new FormData();
		data.left = new FormAttachment(0, getStandardLabelWidth(composite, new String[] { getLabelText() }));
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(labelTxt, 0, SWT.CENTER);
		whitespaceCb.setLayoutData(data);
	}

	/**
	 * Adds the listeners on the widgets
	 */
	@Override
	protected void hookListeners() {
		whitespaceCb.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				handleComboModified();
			}
		});
	}

	/**
	 * Handle the combo modified event.
	 */
	protected void handleComboModified() {
		if (!isRefreshing) {
			final int newWhitespace = whitespaceCb.getSelectionIndex();
			EditingDomain editingDomain = getEditingDomain();
			if (getEObjectList().size() == 1) {
				int oldWhitespace = ExtendedMetaData.INSTANCE.getWhiteSpaceFacet((EDataType) getEObject());
				if (oldWhitespace != newWhitespace) {
					editingDomain.getCommandStack().execute(new EMFRecordingChangeCommand(getEObject().eResource()) {

						@Override
						protected void doExecute() {
							ExtendedMetaData.INSTANCE.setWhiteSpaceFacet((EDataType) getEObject(), newWhitespace);
						}
					});
				}
			} else {
				CompoundCommand compoundCommand = new CompoundCommand();
				/* apply the property change to all selected elements */
				for (Iterator<EObject> i = getEObjectList().iterator(); i.hasNext();) {
					final EObject nextObject = i.next();

					int oldWhitespace = ExtendedMetaData.INSTANCE.getWhiteSpaceFacet((EDataType) nextObject);
					if (oldWhitespace != newWhitespace) {
						compoundCommand.append(new EMFRecordingChangeCommand(nextObject.eResource()) {

							@Override
							protected void doExecute() {
								ExtendedMetaData.INSTANCE.setWhiteSpaceFacet((EDataType) nextObject, newWhitespace);
							}
						});
					}
				}
				editingDomain.getCommandStack().execute(compoundCommand);
			}
		}
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
	 */
	@Override
	public void refresh() {
		isRefreshing = true;

		whitespaceCb.setItems(ExtendedMetaData.WHITE_SPACE_KINDS);
		int whitespace = ExtendedMetaData.INSTANCE.getWhiteSpaceFacet((EDataType) getEObject());
		whitespaceCb.setText(ExtendedMetaData.WHITE_SPACE_KINDS[whitespace]);

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
		return Messages.WhitespaceSection_Whitespace;
	}

}
