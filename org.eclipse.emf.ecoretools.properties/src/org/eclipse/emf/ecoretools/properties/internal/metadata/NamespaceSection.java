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
 * $Id: NamespaceSection.java,v 1.4 2008/05/26 12:28:57 jlescot Exp $
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
 * Section to edit namespace extended metadata annotation
 * 
 * @see ExtendedMetaData#setNamespace(EStructuralFeature, String)
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class NamespaceSection extends AbstractTabbedPropertySection {

	/**
	 * A boolean that store if refreshing is happening and no model
	 * modifications should be performed
	 */
	private boolean isRefreshing = false;

	/**
	 * The text for the section.
	 */
	private Text namespaceTxt;

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
	// namespaceTxt = getWidgetFactory().createText(composite, "");
	//
	// data = new FormData();
	// data.left = new FormAttachment(0, 0);
	// data.right = new FormAttachment(namespaceTxt,
	// -ITabbedPropertyConstants.HSPACE);
	// data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
	// labelTxt.setLayoutData(data);
	//
	// data = new FormData();
	// data.left = new FormAttachment(0, getStandardLabelWidth(composite, new
	// String[] {label}));
	// data.right = new FormAttachment(100, 0);
	// data.top = new FormAttachment(labelTxt, 0, SWT.CENTER);
	// namespaceTxt.setLayoutData(data);
	//
	// hookListeners();
	// }

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createWidgets(Composite composite) {
		labelTxt = getWidgetFactory().createCLabel(composite, getLabelText());

		namespaceTxt = getWidgetFactory().createText(composite, ""); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void setSectionData(Composite composite) {
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(namespaceTxt, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		labelTxt.setLayoutData(data);

		data = new FormData();
		data.left = new FormAttachment(0, getStandardLabelWidth(composite, new String[] { getLabelText() }));
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(labelTxt, 0, SWT.CENTER);
		namespaceTxt.setLayoutData(data);
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
		listener.startListeningTo(namespaceTxt);
		listener.startListeningForEnter(namespaceTxt);
	}

	/**
	 * Handle the text modified event.
	 */
	protected void handleTextModified() {
		if (!isRefreshing) {
			final String newNamespace = namespaceTxt.getText();
			EditingDomain editingDomain = getEditingDomain();
			if (getEObjectList().size() == 1) {
				String oldNamespace = ExtendedMetaData.INSTANCE.getNamespace((EStructuralFeature) getEObject());
				if (oldNamespace == null || !oldNamespace.equals(newNamespace)) {
					editingDomain.getCommandStack().execute(new EMFRecordingChangeCommand(getEObject().eResource()) {

						@Override
						protected void doExecute() {
							ExtendedMetaData.INSTANCE.setNamespace((EStructuralFeature) getEObject(), newNamespace);
						}
					});
				}
			} else {
				CompoundCommand compoundCommand = new CompoundCommand();
				/* apply the property change to all selected elements */
				for (Iterator<EObject> i = getEObjectList().iterator(); i.hasNext();) {
					final EObject nextObject = i.next();

					String oldNamespace = ExtendedMetaData.INSTANCE.getNamespace((EStructuralFeature) nextObject);
					if (oldNamespace != null && !oldNamespace.equals(newNamespace)) {
						editingDomain.getCommandStack().execute(new EMFRecordingChangeCommand(nextObject.eResource()) {

							@Override
							protected void doExecute() {
								ExtendedMetaData.INSTANCE.setNamespace((EStructuralFeature) nextObject, newNamespace);
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

		String txt = ExtendedMetaData.INSTANCE.getNamespace((EStructuralFeature) getEObject());
		if (txt == null) {
			txt = ""; //$NON-NLS-1$
		}

		namespaceTxt.setText(txt);

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
		return Messages.NamespaceSection_Namespace;
	}

}
