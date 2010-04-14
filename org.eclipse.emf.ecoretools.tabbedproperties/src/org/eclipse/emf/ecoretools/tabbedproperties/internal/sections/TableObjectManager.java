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
 * $Id: TableObjectManager.java,v 1.1 2008/05/26 12:25:14 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tabbedproperties.internal.sections;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.tabbedproperties.internal.Messages;
import org.eclipse.emf.ecoretools.tabbedproperties.sections.widgets.ChooseDialog;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.celleditor.FeatureEditorDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Class that manages model changes. This manager supports four basic types such
 * as boolean, string, int and enumerations.
 * 
 * Creation 10 august 06
 * 
 * @author <a href="alfredo@anyware-tech.com">Jose Alfredo SERRANO</a>
 */
public class TableObjectManager {

	/** The object id for the '<em>EBoolean</em>' data type */
	public static final int BOOL = 1;

	/** The object id for the '<em>EENUM</em>' data type */
	public static final int ENUM = 2;

	/** The object id for the '<em>EString</em>' data type */
	public static final int STR = 3;

	/** The object id for the '<em>EInteger</em>' data type */
	public static final int INT = 4;

	/** The object id for the '<em>BIG_Integer</em>' data type */
	public static final int B_INT = 6;

	/** The object id for the '<em>EReference</em>' */
	public static final int REF = 5;

	/** The object id for the '<em>EDouble</em>' */
	public static final int DBL = 7;

	private EObject inputEObject;

	private EStructuralFeature feature;

	private EClassifier type;

	private EditingDomain editingDomain;

	private ILabelProvider labelProvider;

	/**
	 * Constructor Creates a new instance of an EObjectManager.
	 * 
	 * @param eObject
	 *            Object to manage
	 * @param structuralFeature
	 *            Structural Feature to edit. Actually this may be a List type
	 */
	public TableObjectManager(EObject eObject, EStructuralFeature structuralFeature) {
		inputEObject = eObject;
		feature = structuralFeature;
		type = feature.getEType();
	}

	/**
	 * Add a new task to the collection of elements
	 */
	public void addElement() {
		addElement(createNewElement());
	}

	/**
	 * Add a new element to the collection of elements
	 * 
	 * @param newElement
	 *            the Element to add
	 */
	public void addElement(Object newElement) {
		if (newElement == null) {
			return;
		}

		Command command;
		if (newElement instanceof List) {
			List<?> newElements = (List<?>) newElement;
			CompoundCommand cpcmd = new CompoundCommand();
			for (Object element : newElements) {
				cpcmd.append(AddCommand.create(editingDomain, inputEObject, feature, element));
			}
			command = cpcmd;
		} else {
			command = AddCommand.create(editingDomain, inputEObject, feature, newElement);
		}
		editingDomain.getCommandStack().execute(command);
	}

	/**
	 * Removes the given element from the feature list
	 * 
	 * @param element
	 *            Element to remove
	 */
	public void removeElement(Object element) {
		Command removeCmd = RemoveCommand.create(editingDomain, inputEObject, feature, element);
		editingDomain.getCommandStack().execute(removeCmd);
	}

	/**
	 * Updates the Structural Feature setting its value with the given object
	 * 
	 * @param newValue
	 *            The new element to set.
	 */
	public void updateElement(Object newValue) {
		if (newValue == null) {
			return;
		}

		Command command;
		List<?> oldValues = (List<?>) inputEObject.eGet(feature);
		if (newValue instanceof List) {
			List<?> newElements = (List<?>) newValue;
			CompoundCommand cpcmd = new CompoundCommand();
			// Search for deleted items
			for (Object element : oldValues) {
				if (!newElements.contains(element)) {
					cpcmd.append(RemoveCommand.create(editingDomain, inputEObject, feature, element));
				}
			}
			// Search for added items
			for (Object element : newElements) {
				if (!oldValues.contains(element)) {
					cpcmd.append(AddCommand.create(editingDomain, inputEObject, feature, element));
				}
			}
			command = cpcmd;
		} else {
			command = AddCommand.create(editingDomain, inputEObject, feature, newValue, oldValues.size());
		}
		editingDomain.getCommandStack().execute(command);
	}

	/**
	 * Modifies the value of an element in the list
	 * 
	 * @param oldValue
	 *            old value in order to get its place
	 * @param newValue
	 *            new value to insert that the olds value place
	 */
	public void elementChanged(Object oldValue, Object newValue) {
		if (!oldValue.equals(newValue)) {
			Command command = null;
			if (feature.isMany()) {
				List<?> list = (List<?>) inputEObject.eGet(feature);
				int index = list.indexOf(oldValue);

				CompoundCommand cpcmd = new CompoundCommand();
				cpcmd.append(DeleteCommand.create(editingDomain, oldValue));
				cpcmd.append(AddCommand.create(editingDomain, inputEObject, feature, Collections.singleton(newValue), index));
				command = cpcmd;
			} else {
				command = SetCommand.create(editingDomain, inputEObject, feature, newValue);
			}
			editingDomain.getCommandStack().execute(command);
		}
	}

	/**
	 * This method should be calld if client wants to manage model changements
	 * 
	 * @param editingDomain
	 *            the editingDomain to set
	 */
	public void setEditingDomain(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	/**
	 * Set the LabelProvider to use
	 * 
	 * @param labelProvider
	 */
	public void setLabelProvider(ILabelProvider labelProvider) {
		this.labelProvider = labelProvider;
	}

	/**
	 * @return the feature to edit
	 */
	public EStructuralFeature getManagedFeature() {
		return feature;
	}

	/**
	 * @return Returns the input Eobject
	 */
	public EObject getInputEObject() {
		return inputEObject;
	}

	/**
	 * Get the Feature type of the EObject feature of the manager This class
	 * manages list. The return type will be certainly a EList/List type
	 * 
	 * @return feature type
	 */
	public List<?> eGet() {
		if (feature.isMany()) {
			return (List<?>) inputEObject.eGet(feature);
		}
		return new ArrayList<Object>(1);
	}

	/**
	 * TODO Comment this method
	 * 
	 * @return String[]
	 */
	public String[] getEnumLiterals() {
		List<EEnumLiteral> literals = ((EEnum) type).getELiterals();
		String[] result = new String[literals.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = literals.get(i).getLiteral();
		}
		return result;
	}

	/**
	 * TODO Comment this method
	 * 
	 * @param value
	 * @return Object
	 */
	public Object createEnum(int value) {
		String literal = ((EEnum) type).getEEnumLiteral(value).getLiteral();
		return EcoreUtil.createFromString((EDataType) type, literal);
	}

	/**
	 * Creates a new type of elements
	 * 
	 * @return The new element
	 */
	private Object createNewElement() {
		Object newElement = null;
		switch (getEType()) {
		case BOOL: // TODO this case may be removed
			newElement = new Boolean(false);
			break;
		case ENUM: // TODO this case may be removed
			newElement = createEnum(0);
			break;
		case INT:
			newElement = new Integer(0);
			break;
		case B_INT:
			newElement = new BigInteger("0"); //$NON-NLS-1$
			break;
		case DBL:
			newElement = new Double(0);
			break;
		case STR:
			newElement = Messages.TableObjectManager_NewString;
			break;
		case REF:
			if (((EClass) type).isAbstract()) {
				newElement = createObjectFromDialog();
			} else {
				newElement = EcoreUtil.create((EClass) type);
			}
			break;
		default:
			break;
		}
		return newElement;
	}

	/**
	 * Computes the EStructuralFeature type. When the type is an enumeration
	 * this function will initialize the literals array
	 * 
	 * @see EcorePackage#EBOOLEAN , EcorePackage#ESTRING , EcorePackage#EINT or
	 *      EcorePackage#EEnum
	 * @see #BOOL
	 * @see #INT
	 * @see #STR
	 * @see #ENUM
	 * 
	 * @return An integer code which determine the type
	 */
	public int getEType() {
		if (type instanceof EEnum) {
			return ENUM;
		} else if (type instanceof EDataType) {
			Class<?> clazz = type.getInstanceClass();
			if (clazz == int.class || clazz == Integer.class) {
				return INT;
			} else if (clazz == double.class || clazz == Double.class) {
				return DBL;
			} else if (clazz == BigInteger.class) {
				return B_INT;
			} else if (clazz == String.class) {
				return STR;
			} else if (clazz == boolean.class || clazz == Boolean.class) {
				return BOOL;
			} else {
				return 0;
			}
		} else if (type instanceof EClass) {
			return REF;
		} else {
			return 0;
		}
	}

	/**
	 * Return the new List of elements that have been specified in the
	 * FeatureEditorDialog.
	 * 
	 * @return List
	 */
	public List<?> chooseObjectsFromDialog() {
		Collection<EObject> choiceOfValues = ItemPropertyDescriptor.getReachableObjectsOfType(inputEObject, feature.getEType());
		Shell shell = Display.getDefault().getActiveShell();
		String displayName = Messages.TableObjectManager_ChooseObjectsToAdd;
		List<?> choices = new ArrayList<EObject>(choiceOfValues);
		FeatureEditorDialog dialog = new FeatureEditorDialog(shell, labelProvider, inputEObject, feature, displayName, choices);
		dialog.open();
		return dialog.getResult();
	}

	/**
	 * @return Object
	 */
	public Object createObjectFromDialog() {
		Collection<?> descriptors = editingDomain.getNewChildDescriptors(inputEObject, null);
		Object[] selection = descriptors.toArray();
		if (selection.length > 1) {
			Object[] values = new Object[selection.length];
			for (int i = 0; i < selection.length; i++) {
				values[i] = ((CommandParameter) selection[i]).getEValue();
			}
			Shell shell = Display.getDefault().getActiveShell();
			ChooseDialog dialog = new ChooseDialog(shell, values);
			dialog.setLabelProvider(labelProvider);
			if (dialog.open() == Window.OK) {
				selection = dialog.getResult();
			} else {
				selection = new Object[0];
			}
		}
		if (selection.length > 0) {
			return selection[0];
		}
		return null;
	}
}
