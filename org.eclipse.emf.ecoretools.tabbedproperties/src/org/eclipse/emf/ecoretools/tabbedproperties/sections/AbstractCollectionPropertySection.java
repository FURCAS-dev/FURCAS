/***************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana and ohers.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Mario Cervera Ubeda (Integranova) - initial API and implementation
 *
 * $Id: AbstractCollectionPropertySection.java,v 1.3 2009/06/02 12:46:54 jlescot Exp $
 ******************************************************************************/
package org.eclipse.emf.ecoretools.tabbedproperties.sections;

import java.util.Iterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecoretools.tabbedproperties.internal.Messages;
import org.eclipse.emf.ecoretools.tabbedproperties.providers.TabbedPropertiesLabelProvider;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * An abstract implementation of a section prepared to deal with collections.
 * 
 * Creation 3 apr. 2008
 * 
 * @author Mario Cervera Ubeda (Integranova)
 * 
 */
public abstract class AbstractCollectionPropertySection extends AbstractTabbedPropertySection {

	/** Widgets */

	/** The Group hosting the whole section */
	private Group groupMembers;

	/** Three composites to arrange the user interface */
	private Composite compositeListElements;

	private Composite compositeButtons;

	private Composite compositeListMembers;

	/** List widget with the elements that may be part of the collection. */
	private TableViewer listElements = null;

	/** List widget with the members of the collection. */
	private TableViewer listMembers = null;

	/** Add / Remove buttons. */
	private Button buttonAdd = null;

	private Button buttonRemove = null;

	/** Up / Down buttons. */
	private Button buttonUp = null;

	private Button buttonDown = null;

	/**
	 * @see org.eclipse.emf.tabbedproperties.sections.AbstractTabbedPropertySection#createControls(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
	}

	/**
	 * @see org.eclipse.emf.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
	 */
	protected void createWidgets(Composite composite) {
		groupMembers = getWidgetFactory().createGroup(composite, getLabelText());
		GridLayout gl = new GridLayout(3, false);
		groupMembers.setLayout(gl);

		compositeListElements = getWidgetFactory().createComposite(groupMembers);
		compositeListElements.setLayout(new GridLayout());

		compositeButtons = getWidgetFactory().createComposite(groupMembers);
		compositeButtons.setLayout(new GridLayout());

		compositeListMembers = getWidgetFactory().createComposite(groupMembers);
		compositeListMembers.setLayout(new GridLayout());

		listElements = new TableViewer(compositeListElements);
		listElements.setLabelProvider(getLabelProvider());

		listMembers = new TableViewer(compositeListMembers);
		listMembers.setLabelProvider(getLabelProvider());

		buttonAdd = getWidgetFactory().createButton(compositeButtons, Messages.AbstractCollectionPropertySection_Add, SWT.PUSH);
		buttonRemove = getWidgetFactory().createButton(compositeButtons, Messages.AbstractCollectionPropertySection_Remove, SWT.PUSH);
		getWidgetFactory().createLabel(compositeButtons, " "); // A hidden Label //$NON-NLS-1$
		buttonUp = getWidgetFactory().createButton(compositeButtons, Messages.AbstractCollectionPropertySection_Up, SWT.PUSH);
		buttonDown = getWidgetFactory().createButton(compositeButtons, Messages.AbstractCollectionPropertySection_Down, SWT.PUSH);
	}

	/**
	 * @see org.eclipse.emf.tabbedproperties.sections.AbstractTabbedPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
	 */
	protected void setSectionData(Composite composite) {
		FormData fdata;
		GridData gdata;

		fdata = new FormData();
		fdata.top = new FormAttachment(0, 0);
		fdata.left = new FormAttachment(0, 0);
		fdata.right = new FormAttachment(100, 0);
		fdata.bottom = new FormAttachment(100, 0);
		groupMembers.setLayoutData(fdata);

		gdata = new GridData(GridData.FILL_BOTH);
		compositeListElements.setLayoutData(gdata);
		gdata = new GridData();
		compositeButtons.setLayoutData(gdata);
		gdata = new GridData(GridData.FILL_BOTH);
		compositeListMembers.setLayoutData(gdata);
		gdata = new GridData(GridData.FILL_BOTH);
		listElements.getTable().setLayoutData(gdata);
		listMembers.getTable().setLayoutData(gdata);
		buttonAdd.setLayoutData(gdata);
		buttonRemove.setLayoutData(gdata);
		buttonUp.setLayoutData(gdata);
		buttonDown.setLayoutData(gdata);
	}

	/**
	 * @see org.eclipse.emf.tabbedproperties.sections.AbstractTabbedPropertySection#hookListeners()
	 */
	protected void hookListeners() {
		buttonAdd.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				return; // should never be invoked
			}

			public void widgetSelected(SelectionEvent e) {
				handleAddButtonSelected();
			}
		});

		buttonRemove.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				return; // should never be invoked
			}

			public void widgetSelected(SelectionEvent e) {
				handleRemoveButtonSelected();
			}
		});

		buttonUp.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				return; // should never be invoked
			}

			public void widgetSelected(SelectionEvent e) {
				handleUpButtonSelected();
			}
		});

		buttonDown.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				return; // should never be invoked
			}

			public void widgetSelected(SelectionEvent e) {
				handleDownButtonSelected();
			}
		});
	}

	/**
	 * @see org.eclipse.emf.tabbedproperties.sections.AbstractListPropertySection#getLabelProvider()
	 */
	protected IBaseLabelProvider getLabelProvider() {
		return new TabbedPropertiesLabelProvider(new EcoreItemProviderAdapterFactory());
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	public void refresh() {
		fillListElements();
		fillListMembers();
	}

	private void fillListElements() {
		EList<EObject> elements = getElements();
		listElements.getTable().removeAll();
		for (EObject object : elements) {
			listElements.add(object);
		}
	}

	private void fillListMembers() {
		EList<EObject> elements = getFeatureAsList();
		listMembers.getTable().removeAll();
		for (EObject object : elements) {
			listMembers.add(object);
		}
	}

	private void handleAddButtonSelected() {
		if (listElements.getSelection() instanceof StructuredSelection) {
			StructuredSelection selection = (StructuredSelection) listElements.getSelection();
			if (!selection.isEmpty()) {
				Iterator<?> iterator = selection.iterator();
				while (iterator.hasNext()) {
					executeAddCommand(iterator.next());
				}
			}
		}
	}

	private void handleRemoveButtonSelected() {
		if (listMembers.getSelection() instanceof StructuredSelection) {
			StructuredSelection selection = (StructuredSelection) listMembers.getSelection();
			if (!selection.isEmpty()) {
				Iterator<?> iterator = selection.iterator();
				while (iterator.hasNext()) {
					executeRemoveCommand(iterator.next());
				}
			}
		}
	}

	private void handleUpButtonSelected() {
		executeMovement(true);
	}

	private void handleDownButtonSelected() {
		executeMovement(false);
	}

	private void executeMovement(boolean up) {
		if (listMembers.getSelection() instanceof StructuredSelection) {
			StructuredSelection selection = (StructuredSelection) listMembers.getSelection();
			if (!selection.isEmpty()) {
				EList<EObject> membersToMove = new BasicEList<EObject>();
				Iterator<?> iterator = selection.iterator();
				while (iterator.hasNext()) {
					membersToMove.add((EObject) iterator.next());
				}
				int[] indexes = new int[membersToMove.size()];
				for (int k = 0; k < indexes.length; k++) {
					indexes[k] = -1;
				}
				EList<EObject> members = getFeatureAsList();
				EList<EObject> movedMembers = moveMembers(members, membersToMove, up, indexes);
				if (!movedMembers.equals(members)) {
					executeEmptyListCommand();
					executeAddAllCommand(movedMembers);
					listMembers.getTable().setSelection(indexes);
				}
			}
		}
		return;
	}

	/*
	 * Moves the columns contained in membersToMove one position up or down
	 * (depending on the boolean variable up) in the collection members
	 */
	private EList<EObject> moveMembers(EList<EObject> members, EList<EObject> membersToMove, boolean up, int[] indexes) {
		EList<EObject> result = new BasicEList<EObject>();
		if (firstOrLastElements(members, membersToMove, up, indexes)) {
			// Don't move the elements
			result.addAll(members);
		} else {
			// Copy the elements that won't be moved
			for (Object o : members) {
				if (o instanceof EObject) {
					EObject c = (EObject) o;
					if (!membersToMove.contains(c)) {
						result.add(c);
					}
				}
			}

			// Calculate the indexes of the elements to move
			if (up) { // Case movement upwards
				for (int i = 0; i < membersToMove.size(); i++) {
					EObject eobject = membersToMove.get(i);
					int index = members.indexOf(eobject);
					int newIndex = -1;
					if (index == 0) {
						newIndex = index;
					} else {
						if (!containsIndex(index - 1, indexes)) {
							newIndex = index - 1;
						} else {
							newIndex = index;
						}
					}
					result.add(newIndex, eobject);
					indexes[i] = newIndex;
				}
			} else { // Case movement downwards
				for (int i = membersToMove.size() - 1; i >= 0; i--) {
					EObject eobject = membersToMove.get(i);
					// First get the new indexes for the elements to be moved
					int index = members.indexOf(eobject);
					int newIndex = -1;
					if (index == members.size() - 1) {
						newIndex = members.size() - 1;
					} else {
						if (!containsIndex(index + 1, indexes)) {
							newIndex = index + 1;
						} else {
							newIndex = index;
						}
					}
					indexes[i] = newIndex;
				}
				for (int i = 0; i < indexes.length; i++) {
					result.add(indexes[i], membersToMove.get(i));
				}
			}
		}
		return result;
	}

	/*
	 * This method returns true if the selected members to move are together and
	 * in the beginning of the collection (in case up is true) or the end of the
	 * collection (in case up is false) This is important because if this method
	 * returns true the elements shouldn't be moved
	 */
	private boolean firstOrLastElements(EList<EObject> members, EList<EObject> membersToMove, boolean up, int[] indexes) {
		if (membersToMove.size() == members.size()) {
			return true;
		}
		int size = membersToMove.size();
		int[] indexes2 = new int[size];
		int i = 0;
		for (EObject member : membersToMove) {
			indexes2[i] = members.indexOf(member);
			i++;
		}
		// If the first or last member are not in the first or last position we
		// can stop here
		if ((indexes2[0] != 0 && up) || (indexes2[size - 1] != size - 1 && !up)) {
			return false;
		}
		// Are the members together?
		for (int j = 0; j < indexes2.length - 1; j++) {
			if (indexes2[j + 1] - indexes2[j] != 1) {
				return false;
			}
		}
		// Maybe the group of members is at the beginning or the end of the
		// collection
		// but we have to move them anyway because of the direction of the
		// movement
		if ((indexes2[0] == 0 && !up) || indexes2[size - 1] == size - 1 && up) {
			return false;
		}
		indexes = indexes2;
		return true;
	}

	private boolean containsIndex(int i, int[] indexes) {
		for (int j = 0; j < indexes.length; j++) {
			if (indexes[j] == i) {
				return true;
			}
		}
		return false;
	}

	private void executeAddCommand(Object objectToAdd) {
		EditingDomain domain = getEditingDomain();
		if (domain != null) {
			Command command = AddCommand.create(domain, getEObject(), getFeature(), objectToAdd);
			domain.getCommandStack().execute(command);
		}
	}

	private void executeRemoveCommand(Object objectToRemove) {
		EditingDomain domain = getEditingDomain();
		if (domain != null) {
			Command command = RemoveCommand.create(domain, getEObject(), getFeature(), objectToRemove);
			domain.getCommandStack().execute(command);
		}
	}

	private void executeEmptyListCommand() {
		EditingDomain domain = getEditingDomain();
		if (domain != null) {
			Command command = SetCommand.create(domain, getEObject(), getFeature(), new BasicEList<EObject>());
			domain.getCommandStack().execute(command);
		}
	}

	private void executeAddAllCommand(EList<EObject> membersToAdd) {
		EditingDomain domain = getEditingDomain();
		if (domain != null) {
			Command command = SetCommand.create(domain, getEObject(), getFeature(), membersToAdd);
			domain.getCommandStack().execute(command);
		}
	}

	protected EList<EObject> getFeatureAsList() {
		EObject eobject = getEObject();
		if (eobject != null) {
			Object featureValue = eobject.eGet(getFeature());
			if (featureValue instanceof EList) {
				return (EList<EObject>) featureValue;
			}
		}
		return null;
	}

	/**
	 * Return the candidates EObjects to be part of the collection
	 * 
	 * @return the candidates to be part of the collection
	 */
	protected abstract EList<EObject> getElements();

}
