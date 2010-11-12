/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: EditorFactoryImpl.java,v 1.2 2010/04/08 06:26:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.ocl.examples.editor.*;
import org.eclipse.ocl.examples.editor.util.FormatProvider;
import org.eclipse.ocl.examples.editor.util.ImageProvider;
import org.eclipse.ocl.examples.editor.util.TextProvider;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EditorFactoryImpl extends EFactoryImpl implements EditorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EditorFactory init() {
		try {
			EditorFactory theEditorFactory = (EditorFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/ocl/1.0/Editor"); 
			if (theEditorFactory != null) {
				return theEditorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EditorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditorFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EditorPackage.ECORE_LABEL_ELEMENT: return createEcoreLabelElement();
			case EditorPackage.ECORE_NODE: return createEcoreNode();
			case EditorPackage.EDITOR_DEFINITION: return createEditorDefinition();
			case EditorPackage.FOLDING_BEHAVIOR: return createFoldingBehavior();
			case EditorPackage.JAVA_LABEL_ELEMENT: return createJavaLabelElement();
			case EditorPackage.JAVA_NODE: return createJavaNode();
			case EditorPackage.LABEL_BEHAVIOR: return createLabelBehavior();
			case EditorPackage.OUTLINE_BEHAVIOR: return createOutlineBehavior();
			case EditorPackage.OUTLINE_ELEMENT: return createOutlineElement();
			case EditorPackage.OUTLINE_GROUP: return createOutlineGroup();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case EditorPackage.FORMAT_PROVIDER:
				return createFormatProviderFromString(eDataType, initialValue);
			case EditorPackage.IMAGE_PROVIDER:
				return createImageProviderFromString(eDataType, initialValue);
			case EditorPackage.TEXT_PROVIDER:
				return createTextProviderFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case EditorPackage.FORMAT_PROVIDER:
				return convertFormatProviderToString(eDataType, instanceValue);
			case EditorPackage.IMAGE_PROVIDER:
				return convertImageProviderToString(eDataType, instanceValue);
			case EditorPackage.TEXT_PROVIDER:
				return convertTextProviderToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoreLabelElement createEcoreLabelElement() {
		EcoreLabelElementImpl ecoreLabelElement = new EcoreLabelElementImpl();
		return ecoreLabelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoreNode createEcoreNode() {
		EcoreNodeImpl ecoreNode = new EcoreNodeImpl();
		return ecoreNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditorDefinition createEditorDefinition() {
		EditorDefinitionImpl editorDefinition = new EditorDefinitionImpl();
		return editorDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FoldingBehavior createFoldingBehavior() {
		FoldingBehaviorImpl foldingBehavior = new FoldingBehaviorImpl();
		return foldingBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaLabelElement createJavaLabelElement() {
		JavaLabelElementImpl javaLabelElement = new JavaLabelElementImpl();
		return javaLabelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaNode createJavaNode() {
		JavaNodeImpl javaNode = new JavaNodeImpl();
		return javaNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabelBehavior createLabelBehavior() {
		LabelBehaviorImpl labelBehavior = new LabelBehaviorImpl();
		return labelBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutlineBehavior createOutlineBehavior() {
		OutlineBehaviorImpl outlineBehavior = new OutlineBehaviorImpl();
		return outlineBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutlineElement createOutlineElement() {
		OutlineElementImpl outlineElement = new OutlineElementImpl();
		return outlineElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutlineGroup createOutlineGroup() {
		OutlineGroupImpl outlineGroup = new OutlineGroupImpl();
		return outlineGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormatProvider createFormatProviderFromString(EDataType eDataType, String initialValue) {
		return (FormatProvider)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFormatProviderToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageProvider createImageProviderFromString(EDataType eDataType, String initialValue) {
		return (ImageProvider)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertImageProviderToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextProvider createTextProviderFromString(EDataType eDataType, String initialValue) {
		return (TextProvider)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTextProviderToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditorPackage getEditorPackage() {
		return (EditorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EditorPackage getPackage() {
		return EditorPackage.eINSTANCE;
	}

} //EditorFactoryImpl
