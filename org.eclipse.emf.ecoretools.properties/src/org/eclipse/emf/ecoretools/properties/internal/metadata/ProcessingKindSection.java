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
 * $Id: ProcessingKindSection.java,v 1.4 2008/05/26 12:28:57 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.properties.internal.metadata;

import java.util.Iterator;

import org.eclipse.emf.common.command.CompoundCommand;
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
 * Section to edit processing kind extended metadata annotation
 * 
 * @see ExtendedMetaData#setProcessingKind(EStructuralFeature, int)
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ProcessingKindSection extends AbstractTabbedPropertySection {

	/**
	 * A boolean that store if refreshing is happening and no model
	 * modifications should be performed
	 */
	private boolean isRefreshing = false;

	/**
	 * The combo box control for the section.
	 */
	private CCombo processingKindCb;

	/**
	 * The section label;
	 */
	private CLabel labelTxt;

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createWidgets(Composite composite) {
		labelTxt = getWidgetFactory().createCLabel(composite, getLabelText());

		processingKindCb = getWidgetFactory().createCCombo(composite, SWT.FLAT | SWT.READ_ONLY | SWT.BORDER);
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void setSectionData(Composite composite) {
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(processingKindCb, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		labelTxt.setLayoutData(data);

		data = new FormData();
		data.left = new FormAttachment(0, getStandardLabelWidth(composite, new String[] { getLabelText() }));
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(labelTxt, 0, SWT.CENTER);
		processingKindCb.setLayoutData(data);
	}

	/**
	 * Adds the listeners on the widgets
	 */
	@Override
	protected void hookListeners() {
		processingKindCb.addModifyListener(new ModifyListener() {

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
			final int newProcessingKind = getIndex(processingKindCb.getText());
			EditingDomain editingDomain = getEditingDomain();
			if (getEObjectList().size() == 1) {
				int oldProcessingKind = ExtendedMetaData.INSTANCE.getProcessingKind((EStructuralFeature) getEObject());
				if (oldProcessingKind != newProcessingKind) {
					editingDomain.getCommandStack().execute(new EMFRecordingChangeCommand(getEObject().eResource()) {

						@Override
						protected void doExecute() {
							ExtendedMetaData.INSTANCE.setProcessingKind((EStructuralFeature) getEObject(), newProcessingKind);
						}
					});
				}
			} else {
				CompoundCommand compoundCommand = new CompoundCommand();
				/* apply the property change to all selected elements */
				for (Iterator<EObject> i = getEObjectList().iterator(); i.hasNext();) {
					final EObject nextObject = i.next();

					int oldProcessingKind = ExtendedMetaData.INSTANCE.getProcessingKind((EStructuralFeature) nextObject);
					if (oldProcessingKind != newProcessingKind) {
						compoundCommand.append(new EMFRecordingChangeCommand(nextObject.eResource()) {

							@Override
							protected void doExecute() {
								ExtendedMetaData.INSTANCE.setProcessingKind((EStructuralFeature) nextObject, newProcessingKind);
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

		processingKindCb.setItems(ExtendedMetaData.PROCESSING_KINDS);
		int processingKind = ExtendedMetaData.INSTANCE.getProcessingKind((EStructuralFeature) getEObject());
		processingKindCb.setText(ExtendedMetaData.PROCESSING_KINDS[processingKind]);

		isRefreshing = false;
	}

	/**
	 * Gets the respectif index of the key inside this array. It returns -1 when
	 * the key is not find inside the array
	 * 
	 * @param key
	 * @return the key index
	 */
	private int getIndex(String key) {
		String[] contentKinds = ExtendedMetaData.PROCESSING_KINDS;
		for (int i = 0; i < contentKinds.length; i++) {
			if (contentKinds[i].equals(key)) {
				return i;
			}
		}
		return -1;
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
		return Messages.ProcessingKindSection_ProcessingKind;
	}

}
