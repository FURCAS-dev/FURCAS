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
 * $Id: AbstractDetailedObjectPropertySection.java,v 1.1 2008/05/26 12:25:14 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tabbedproperties.sections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecoretools.tabbedproperties.internal.Messages;
import org.eclipse.emf.ecoretools.tabbedproperties.providers.TabbedPropertiesLabelProvider;
import org.eclipse.emf.ecoretools.tabbedproperties.sections.widgets.ChooseDialog;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * An abstract section used to create a model object inside the selected
 * element. You can then, depending on the selected model object edit its
 * properties through a detailed Composite which is dynamically updated.
 * 
 * Creation 10 nov. 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public abstract class AbstractDetailedObjectPropertySection extends AbstractTabbedPropertySection {

	/** The label used with to identify the Section */
	private CLabel nameLabel;

	/** The Text control for the section. */
	private Text text;

	/** The button used to create a new Element */
	private Button createButton;

	/**
	 * The Group used to edit the Details of the selected Constraint. Its
	 * contents depends on the type of Constraint that is selected in the other
	 * widget.
	 */
	private Group groupDetails;

	/** The Composite used to edit the selected Constraint properties */
	private Composite detailsComposite;

	private SelectionListener createButtonListener = new SelectionAdapter() {

		/**
		 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		public void widgetSelected(SelectionEvent e) {
			Object[] availableTypes = getAvailableTypes();
			Object selectedType = null;

			if (availableTypes.length == 1) {
				selectedType = availableTypes[0];
			}
			// When more than one concrete Types are available, a ChooseDialog
			// is prompted
			else if (availableTypes.length > 1) {
				// Open the dialog used to choose the type of Constraint
				ChooseDialog dialog = new ChooseDialog(Display.getDefault().getActiveShell(), getAvailableTypes());
				dialog.setLabelProvider(getLabelProvider());
				if (dialog.open() == Window.OK) {
					if (dialog.getResult().length > 0) {
						selectedType = dialog.getResult()[0];
					}
				}
			}

			if (selectedType != null) {
				// Create the Command to add the selected Constraint
				createCommand(getRelatedEObject(), selectedType);

				// Update the group contents when the type has changed
				updateGroupContents();
			}
		}
	};

	private Object[] getAvailableTypes() {
		Collection<?> allTypes = getEditingDomain().getNewChildDescriptors(getEObject(), null);
		List<EObject> availableTypes = new ArrayList<EObject>();

		for (Object currentType : allTypes) {
			if (currentType instanceof CommandParameter && getFeature().equals(((CommandParameter) currentType).getFeature())) {
				availableTypes.add(((CommandParameter) currentType).getEValue());
			}
		}
		return availableTypes.toArray();
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#createControls(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		// Composite composite =
		// getWidgetFactory().createFlatFormComposite(parent);

		// // The Widget used to select/create the corresponding Constraint
		// nameLabel = getWidgetFactory().createCLabel(composite,
		// getLabelText());
		// text = getWidgetFactory().createText(composite, "", SWT.READ_ONLY);
		// createButton = getWidgetFactory().createButton(composite, "Create
		// ...", SWT.NONE);
		//
		// // The group that is used to edit the Details of the selected
		// Constraint
		// groupDetails = getWidgetFactory().createGroup(composite, "Details");
		// groupDetails.setLayout(new GridLayout());

		// FormData data = new FormData();
		// data.left = new FormAttachment(0, 0);
		// data.top = new FormAttachment(createButton, 0, SWT.CENTER);
		// nameLabel.setLayoutData(data);
		//
		// data = new FormData();
		// data.left = new FormAttachment(nameLabel,
		// ITabbedPropertyConstants.HSPACE);
		// data.right = new FormAttachment(createButton,
		// -ITabbedPropertyConstants.HSPACE);
		// data.top = new FormAttachment(createButton, 0, SWT.CENTER);
		// text.setLayoutData(data);
		//
		// data = new FormData();
		// data.right = new FormAttachment(100, 0);
		// data.top = new FormAttachment(0, 0);
		// createButton.setLayoutData(data);
		//
		// data = new FormData();
		// data.left = new FormAttachment(0, 0);
		// data.right = new FormAttachment(100, 0);
		// data.top = new FormAttachment(nameLabel,
		// ITabbedPropertyConstants.VSPACE);
		// groupDetails.setLayoutData(data);
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createWidgets(Composite composite) {
		// The Widget used to select/create the corresponding Constraint
		nameLabel = getWidgetFactory().createCLabel(composite, getLabelText());
		text = getWidgetFactory().createText(composite, "", SWT.READ_ONLY); //$NON-NLS-1$
		createButton = getWidgetFactory().createButton(composite, Messages.AbstractDetailedObjectPropertySection_Create, SWT.NONE);

		// The group that is used to edit the Details of the selected Constraint
		groupDetails = getWidgetFactory().createGroup(composite, Messages.AbstractDetailedObjectPropertySection_Details);
		groupDetails.setLayout(new GridLayout());

	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void setSectionData(Composite composite) {
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(createButton, 0, SWT.CENTER);
		nameLabel.setLayoutData(data);

		data = new FormData();
		data.left = new FormAttachment(nameLabel, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(createButton, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(createButton, 0, SWT.CENTER);
		text.setLayoutData(data);

		data = new FormData();
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, 0);
		createButton.setLayoutData(data);

		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(nameLabel, ITabbedPropertyConstants.VSPACE);
		groupDetails.setLayoutData(data);

	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
	 */
	public void refresh() {
		super.refresh();

		text.setText(updateConstraintText());
		updateGroupContents();
	}

	private String updateConstraintText() {
		String name = ""; //$NON-NLS-1$
		if (getRelatedEObject() != null) {
			name = getLabelProvider().getText(getRelatedEObject());
			if (name == null) {
				name = ""; //$NON-NLS-1$
			}
		}
		return name;
	}

	/**
	 * This method should be called when the contents of the groupDetails should
	 * be updated.
	 */
	protected void updateGroupContents() {
		if (getRelatedEObject() != null) {
			if (detailsComposite != null && !detailsComposite.isDisposed()) {
				detailsComposite.dispose();
			}

			// create the new Composite associated with the related model object
			detailsComposite = getDetailsComposite();
			if (detailsComposite != null) {
				getWidgetFactory().adapt(detailsComposite);
			}

			// Update the groupDetails composite by forcing it to layout its
			// children
			groupDetails.getParent().layout();
			groupDetails.layout();
		}
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#aboutToBeShown()
	 */
	public void aboutToBeShown() {
		super.aboutToBeShown();
		if (createButton != null && !createButton.isDisposed()) {
			createButton.addSelectionListener(createButtonListener);
		}
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#aboutToBeHidden()
	 */
	public void aboutToBeHidden() {
		if (createButton != null && !createButton.isDisposed()) {
			createButton.removeSelectionListener(createButtonListener);
		}
		super.aboutToBeHidden();
	}

	/**
	 * Get the LabelProvider to use to display the Constraint element
	 * 
	 * @return ILabelProvider
	 */
	protected ILabelProvider getLabelProvider() {
		return new TabbedPropertiesLabelProvider(new EcoreItemProviderAdapterFactory());
	}

	/**
	 * This method returns the groupDetails composite. Subclasses should used it
	 * to retrieve that composite and add the custom detailsComposite
	 * 
	 * @return Group the Group Composite used to display details informations
	 *         about the relatedEObject
	 */
	public Group getGroupDetails() {
		return groupDetails;
	}

	/**
	 * Get the text value corresponding to the selected Constraint
	 * 
	 * @return String
	 */
	protected abstract String getFeatureAsText();

	/**
	 * Return the model object associated with the section. This is not the same
	 * model object returned by the getEObject() method, but this is generally
	 * an internal model object that can be edited.
	 * 
	 * @return EObject model object
	 */
	protected abstract EObject getRelatedEObject();

	/**
	 * This method should return the Composite that should be associated with
	 * the details Group
	 * 
	 * @return the Composite used as children of the detailsGroup
	 */
	protected abstract Composite getDetailsComposite();

}
