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
 * $Id: EOperationParameterSection.java,v 1.8 2008/05/26 12:28:57 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.properties.internal.sections;

import java.util.Iterator;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecoretools.properties.internal.Messages;
import org.eclipse.emf.ecoretools.tabbedproperties.providers.TabbedPropertiesLabelProvider;
import org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractListPropertySection;
import org.eclipse.emf.ecoretools.tabbedproperties.sections.widgets.CSingleObjectChooser;
import org.eclipse.emf.ecoretools.tabbedproperties.utils.TextChangeListener;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * TODO Comment this class
 */
public class EOperationParameterSection extends AbstractListPropertySection {

	/** The widgets */
	private Text parameterNameTxt;

	private CSingleObjectChooser typeChooser;

	/**
	 * A boolean that store if refreshing is happening and no model
	 * modifications should be performed
	 */
	private boolean isRefreshing = false;

	/**
	 * The group Details
	 */
	private Group groupDetails;

	// /**
	// * @see
	// org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#createControls(org.eclipse.swt.widgets.Composite,
	// org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	// */
	// public void createControls(Composite parent, TabbedPropertySheetPage
	// aTabbedPropertySheetPage)
	// {
	// super.createControls(parent, aTabbedPropertySheetPage);
	//
	// Composite composite = getSectionComposite();
	// FormData data;
	//
	// Group groupDetails = getWidgetFactory().createGroup(composite, "Parameter
	// Details");
	// groupDetails.setLayout(new GridLayout());
	//
	// data = new FormData();
	// data.left = new FormAttachment(0, 0);
	// data.right = new FormAttachment(100, 0);
	// data.top = new FormAttachment(getTable(),
	// ITabbedPropertyConstants.VSPACE);
	// groupDetails.setLayoutData(data);
	//
	// createGroupContents(groupDetails);
	// hookListeners();
	// }

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractListPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createWidgets(Composite composite) {
		super.createWidgets(composite);
		groupDetails = getWidgetFactory().createGroup(composite, Messages.EOperationParameterSection_ParameterDetails);
		groupDetails.setLayout(new GridLayout());

		createGroupContents(groupDetails);
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractListPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void setSectionData(Composite composite) {
		super.setSectionData(composite);
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(getTable(), ITabbedPropertyConstants.VSPACE);
		groupDetails.setLayoutData(data);
	}

	/**
	 * Create the group contents
	 * 
	 * @param parent
	 *            the parent Composite
	 */
	protected void createGroupContents(Composite parent) {
		TabbedPropertySheetWidgetFactory widgetFactory = getWidgetFactory();
		Composite composite = widgetFactory.createComposite(parent);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		widgetFactory.createLabel(composite, Messages.EOperationParameterSection_Name);
		parameterNameTxt = widgetFactory.createText(composite, "", SWT.BORDER); //$NON-NLS-1$
		parameterNameTxt.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		widgetFactory.createLabel(composite, Messages.EOperationParameterSection_Type);
		typeChooser = new CSingleObjectChooser(composite, getWidgetFactory(), SWT.NONE);
		typeChooser.setLabelProvider((ILabelProvider) getLabelProvider());
		typeChooser.setSection(this);
		typeChooser.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractListPropertySection#hookListeners()
	 */
	@Override
	protected void hookListeners() {
		// Add the Listener for the eparameter name
		TextChangeListener parameterNameListener = new TextChangeListener() {

			@Override
			public void textChanged(Control control) {
				String newText = parameterNameTxt.getText();
				EParameter parameter = (EParameter) getTable().getSelectionItem();
				if (parameter != null && !newText.equals(parameter.getName())) {
					getEditingDomain().getCommandStack().execute(SetCommand.create(getEditingDomain(), parameter, EcorePackage.Literals.ENAMED_ELEMENT__NAME, newText));
				}
				refresh();
			}
		};
		parameterNameListener.startListeningTo(parameterNameTxt);
		parameterNameListener.startListeningForEnter(parameterNameTxt);

		// Add a listener to the parameter type field
		typeChooser.addSelectionListener(new SelectionAdapter() {

			/**
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleComboModified();
			}
		});
	}

	/**
	 * Update the model when the combo is modified
	 */
	protected void handleComboModified() {
		if (!isRefreshing && getParameterType() != typeChooser.getSelection()) {
			EditingDomain editingDomain = getEditingDomain();
			EParameter parameter = (EParameter) getTable().getSelectionItem();
			if (getEObjectList().size() == 1) {
				/* apply the property change to single selected object */
				editingDomain.getCommandStack().execute(SetCommand.create(editingDomain, parameter, EcorePackage.Literals.ETYPED_ELEMENT__ETYPE, typeChooser.getSelection()));
			} else {
				CompoundCommand compoundCommand = new CompoundCommand();
				/* apply the property change to all selected elements */
				for (Iterator<EObject> i = getEObjectList().iterator(); i.hasNext();) {
					EObject nextObject = i.next();
					compoundCommand.append(SetCommand.create(editingDomain, nextObject, EcorePackage.Literals.ETYPED_ELEMENT__ETYPE, typeChooser.getSelection()));
				}
				editingDomain.getCommandStack().execute(compoundCommand);
			}
		}

	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractListPropertySection#getLabelProvider()
	 */
	@Override
	protected IBaseLabelProvider getLabelProvider() {
		return new TabbedPropertiesLabelProvider(new EcoreItemProviderAdapterFactory());
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractListPropertySection#getListValues()
	 */
	@Override
	protected Object getListValues() {
		return ((EOperation) getEObject()).getEParameters();
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
	 */
	@Override
	protected EStructuralFeature getFeature() {
		return EcorePackage.Literals.EOPERATION__EPARAMETERS;
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
	 */
	@Override
	protected String getLabelText() {
		return Messages.EOperationParameterSection_Parameters;
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
	 */
	@Override
	public void refresh() {
		isRefreshing = true;
		super.refresh();
		typeChooser.setChoices(getComboFeatureValues());
		typeChooser.setSelection(getParameterType());
		EParameter parameter = (EParameter) getTable().getSelectionItem();
		String nameToDisplay = getEParameterName(parameter);
		parameterNameTxt.setText(nameToDisplay);
		isRefreshing = false;

	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractListPropertySection#updateSelection(java.lang.Object)
	 */
	@Override
	public void updateSelection(Object data) {
		if (data instanceof EParameter) {
			EParameter parameter = (EParameter) data;
			String nameToDisplay = getEParameterName(parameter);
			parameterNameTxt.setText(nameToDisplay);
			typeChooser.setSelection(getParameterType());
		}
	}

	/**
	 * Returns the name of the given parameters
	 * 
	 * @param parameter
	 *            The parameter to know the name
	 * @return the parameters name
	 */
	private String getEParameterName(EParameter parameter) {
		return parameter == null ? "" : parameter.getName() != null ? parameter.getName() : ""; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Search for all reachable events in the model
	 * 
	 * @return An array ob events
	 */
	private Object[] getComboFeatureValues() {

		Iterator<Adapter> iter = getEObject().eAdapters().iterator();
		while (iter.hasNext()) {
			Adapter adapter = iter.next();
			if (adapter instanceof ItemProviderAdapter) {
				IItemPropertyDescriptor descriptor = ((ItemProviderAdapter) adapter).getPropertyDescriptor(getEObject(), EcorePackage.Literals.ETYPED_ELEMENT__ETYPE.getName());
				if (descriptor != null) {
					return descriptor.getChoiceOfValues(getEObject()).toArray();
				}
			}
		}
		return new String[] { "" }; //$NON-NLS-1$
	}

	/**
	 * Returns the parameters type
	 * 
	 * @return the parameters type
	 */
	private Object getParameterType() {
		EParameter parameter = (EParameter) getTable().getSelectionItem();
		if (parameter != null) {
			return parameter.getEType();
		}
		return null;
	}
}
