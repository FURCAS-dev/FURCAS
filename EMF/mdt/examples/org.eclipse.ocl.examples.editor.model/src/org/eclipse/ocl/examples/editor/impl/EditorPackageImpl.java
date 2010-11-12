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
 * $Id: EditorPackageImpl.java,v 1.2 2010/04/08 06:26:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.editor.AbstractLabelElement;
import org.eclipse.ocl.examples.editor.AbstractNode;
import org.eclipse.ocl.examples.editor.AbstractOutlineElement;
import org.eclipse.ocl.examples.editor.Behavior;
import org.eclipse.ocl.examples.editor.EcoreLabelElement;
import org.eclipse.ocl.examples.editor.EcoreNode;
import org.eclipse.ocl.examples.editor.EditorDefinition;
import org.eclipse.ocl.examples.editor.EditorFactory;
import org.eclipse.ocl.examples.editor.EditorPackage;
import org.eclipse.ocl.examples.editor.FoldingBehavior;
import org.eclipse.ocl.examples.editor.JavaLabelElement;
import org.eclipse.ocl.examples.editor.JavaNode;
import org.eclipse.ocl.examples.editor.LabelBehavior;
import org.eclipse.ocl.examples.editor.OutlineBehavior;
import org.eclipse.ocl.examples.editor.OutlineElement;
import org.eclipse.ocl.examples.editor.OutlineGroup;
import org.eclipse.ocl.examples.editor.util.FormatProvider;
import org.eclipse.ocl.examples.editor.util.ImageProvider;
import org.eclipse.ocl.examples.editor.util.TextProvider;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EditorPackageImpl extends EPackageImpl implements EditorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractLabelElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractOutlineElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ecoreLabelElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ecoreNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass editorDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass foldingBehaviorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaLabelElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass labelBehaviorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outlineBehaviorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outlineElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outlineGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType formatProviderEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType imageProviderEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType textProviderEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.ocl.examples.editor.EditorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EditorPackageImpl() {
		super(eNS_URI, EditorFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link EditorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EditorPackage init() {
		if (isInited) return (EditorPackage)EPackage.Registry.INSTANCE.getEPackage(EditorPackage.eNS_URI);

		// Obtain or create and register package
		EditorPackageImpl theEditorPackage = (EditorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EditorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EditorPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEditorPackage.createPackageContents();

		// Initialize created meta-data
		theEditorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEditorPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EditorPackage.eNS_URI, theEditorPackage);
		return theEditorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractLabelElement() {
		return abstractLabelElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractNode() {
		return abstractNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractNode_Behavior() {
		return (EReference)abstractNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractNode_Base() {
		return (EReference)abstractNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractOutlineElement() {
		return abstractOutlineElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehavior() {
		return behaviorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEcoreLabelElement() {
		return ecoreLabelElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEcoreLabelElement_Path() {
		return (EReference)ecoreLabelElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEcoreLabelElement_End() {
		return (EReference)ecoreLabelElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEcoreLabelElement_HideIfBlank() {
		return (EAttribute)ecoreLabelElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEcoreLabelElement_Prefix() {
		return (EAttribute)ecoreLabelElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEcoreLabelElement_Separator() {
		return (EAttribute)ecoreLabelElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEcoreLabelElement_Suffix() {
		return (EAttribute)ecoreLabelElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEcoreLabelElement_TextProvider() {
		return (EAttribute)ecoreLabelElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEcoreNode() {
		return ecoreNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEcoreNode_Element() {
		return (EReference)ecoreNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEditorDefinition() {
		return editorDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEditorDefinition_Language() {
		return (EAttribute)editorDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEditorDefinition_Extends() {
		return (EReference)editorDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEditorDefinition_Node() {
		return (EReference)editorDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFoldingBehavior() {
		return foldingBehaviorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaLabelElement() {
		return javaLabelElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaLabelElement_Class() {
		return (EAttribute)javaLabelElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaLabelElement_Method() {
		return (EAttribute)javaLabelElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaNode() {
		return javaNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaNode_Name() {
		return (EAttribute)javaNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLabelBehavior() {
		return labelBehaviorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLabelBehavior_Image() {
		return (EAttribute)labelBehaviorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLabelBehavior_ImageProvider() {
		return (EAttribute)labelBehaviorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLabelBehavior_Format() {
		return (EAttribute)labelBehaviorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLabelBehavior_FormatProvider() {
		return (EAttribute)labelBehaviorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLabelBehavior_Elements() {
		return (EReference)labelBehaviorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutlineBehavior() {
		return outlineBehaviorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutlineBehavior_Elements() {
		return (EReference)outlineBehaviorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOutlineBehavior_Hidden() {
		return (EAttribute)outlineBehaviorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutlineElement() {
		return outlineElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutlineElement_Feature() {
		return (EReference)outlineElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutlineGroup() {
		return outlineGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOutlineGroup_Image() {
		return (EAttribute)outlineGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOutlineGroup_Name() {
		return (EAttribute)outlineGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutlineGroup_Elements() {
		return (EReference)outlineGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOutlineGroup_Hidden() {
		return (EAttribute)outlineGroupEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFormatProvider() {
		return formatProviderEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getImageProvider() {
		return imageProviderEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTextProvider() {
		return textProviderEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditorFactory getEditorFactory() {
		return (EditorFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		abstractLabelElementEClass = createEClass(ABSTRACT_LABEL_ELEMENT);

		abstractNodeEClass = createEClass(ABSTRACT_NODE);
		createEReference(abstractNodeEClass, ABSTRACT_NODE__BEHAVIOR);
		createEReference(abstractNodeEClass, ABSTRACT_NODE__BASE);

		abstractOutlineElementEClass = createEClass(ABSTRACT_OUTLINE_ELEMENT);

		behaviorEClass = createEClass(BEHAVIOR);

		ecoreLabelElementEClass = createEClass(ECORE_LABEL_ELEMENT);
		createEReference(ecoreLabelElementEClass, ECORE_LABEL_ELEMENT__PATH);
		createEReference(ecoreLabelElementEClass, ECORE_LABEL_ELEMENT__END);
		createEAttribute(ecoreLabelElementEClass, ECORE_LABEL_ELEMENT__HIDE_IF_BLANK);
		createEAttribute(ecoreLabelElementEClass, ECORE_LABEL_ELEMENT__PREFIX);
		createEAttribute(ecoreLabelElementEClass, ECORE_LABEL_ELEMENT__SEPARATOR);
		createEAttribute(ecoreLabelElementEClass, ECORE_LABEL_ELEMENT__SUFFIX);
		createEAttribute(ecoreLabelElementEClass, ECORE_LABEL_ELEMENT__TEXT_PROVIDER);

		ecoreNodeEClass = createEClass(ECORE_NODE);
		createEReference(ecoreNodeEClass, ECORE_NODE__ELEMENT);

		editorDefinitionEClass = createEClass(EDITOR_DEFINITION);
		createEAttribute(editorDefinitionEClass, EDITOR_DEFINITION__LANGUAGE);
		createEReference(editorDefinitionEClass, EDITOR_DEFINITION__EXTENDS);
		createEReference(editorDefinitionEClass, EDITOR_DEFINITION__NODE);

		foldingBehaviorEClass = createEClass(FOLDING_BEHAVIOR);

		javaLabelElementEClass = createEClass(JAVA_LABEL_ELEMENT);
		createEAttribute(javaLabelElementEClass, JAVA_LABEL_ELEMENT__CLASS);
		createEAttribute(javaLabelElementEClass, JAVA_LABEL_ELEMENT__METHOD);

		javaNodeEClass = createEClass(JAVA_NODE);
		createEAttribute(javaNodeEClass, JAVA_NODE__NAME);

		labelBehaviorEClass = createEClass(LABEL_BEHAVIOR);
		createEAttribute(labelBehaviorEClass, LABEL_BEHAVIOR__IMAGE);
		createEAttribute(labelBehaviorEClass, LABEL_BEHAVIOR__IMAGE_PROVIDER);
		createEAttribute(labelBehaviorEClass, LABEL_BEHAVIOR__FORMAT);
		createEAttribute(labelBehaviorEClass, LABEL_BEHAVIOR__FORMAT_PROVIDER);
		createEReference(labelBehaviorEClass, LABEL_BEHAVIOR__ELEMENTS);

		outlineBehaviorEClass = createEClass(OUTLINE_BEHAVIOR);
		createEReference(outlineBehaviorEClass, OUTLINE_BEHAVIOR__ELEMENTS);
		createEAttribute(outlineBehaviorEClass, OUTLINE_BEHAVIOR__HIDDEN);

		outlineElementEClass = createEClass(OUTLINE_ELEMENT);
		createEReference(outlineElementEClass, OUTLINE_ELEMENT__FEATURE);

		outlineGroupEClass = createEClass(OUTLINE_GROUP);
		createEAttribute(outlineGroupEClass, OUTLINE_GROUP__IMAGE);
		createEAttribute(outlineGroupEClass, OUTLINE_GROUP__NAME);
		createEReference(outlineGroupEClass, OUTLINE_GROUP__ELEMENTS);
		createEAttribute(outlineGroupEClass, OUTLINE_GROUP__HIDDEN);

		// Create data types
		formatProviderEDataType = createEDataType(FORMAT_PROVIDER);
		imageProviderEDataType = createEDataType(IMAGE_PROVIDER);
		textProviderEDataType = createEDataType(TEXT_PROVIDER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		ecoreLabelElementEClass.getESuperTypes().add(this.getAbstractLabelElement());
		ecoreNodeEClass.getESuperTypes().add(this.getAbstractNode());
		foldingBehaviorEClass.getESuperTypes().add(this.getBehavior());
		javaLabelElementEClass.getESuperTypes().add(this.getAbstractLabelElement());
		javaNodeEClass.getESuperTypes().add(this.getAbstractNode());
		labelBehaviorEClass.getESuperTypes().add(this.getBehavior());
		outlineBehaviorEClass.getESuperTypes().add(this.getBehavior());
		outlineElementEClass.getESuperTypes().add(this.getAbstractOutlineElement());
		outlineGroupEClass.getESuperTypes().add(this.getAbstractOutlineElement());

		// Initialize classes and features; add operations and parameters
		initEClass(abstractLabelElementEClass, AbstractLabelElement.class, "AbstractLabelElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractNodeEClass, AbstractNode.class, "AbstractNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractNode_Behavior(), this.getBehavior(), null, "behavior", null, 0, -1, AbstractNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAbstractNode_Base(), this.getAbstractNode(), null, "base", null, 0, 1, AbstractNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractOutlineElementEClass, AbstractOutlineElement.class, "AbstractOutlineElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(behaviorEClass, Behavior.class, "Behavior", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ecoreLabelElementEClass, EcoreLabelElement.class, "EcoreLabelElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEcoreLabelElement_Path(), theEcorePackage.getEReference(), null, "path", null, 0, -1, EcoreLabelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEcoreLabelElement_End(), theEcorePackage.getEStructuralFeature(), null, "end", null, 1, 1, EcoreLabelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEcoreLabelElement_HideIfBlank(), theEcorePackage.getEBoolean(), "hideIfBlank", "false", 0, 1, EcoreLabelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEcoreLabelElement_Prefix(), theEcorePackage.getEString(), "prefix", "", 0, 1, EcoreLabelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEcoreLabelElement_Separator(), theEcorePackage.getEString(), "separator", " ", 0, 1, EcoreLabelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEcoreLabelElement_Suffix(), theEcorePackage.getEString(), "suffix", "", 0, 1, EcoreLabelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEJavaClass());
		EGenericType g2 = createEGenericType(this.getTextProvider());
		g1.getETypeArguments().add(g2);
		initEAttribute(getEcoreLabelElement_TextProvider(), g1, "textProvider", null, 0, 1, EcoreLabelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ecoreNodeEClass, EcoreNode.class, "EcoreNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEcoreNode_Element(), theEcorePackage.getEClassifier(), null, "element", null, 1, 1, EcoreNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(editorDefinitionEClass, EditorDefinition.class, "EditorDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEditorDefinition_Language(), theEcorePackage.getEString(), "language", null, 1, 1, EditorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEditorDefinition_Extends(), this.getEditorDefinition(), null, "extends", null, 0, -1, EditorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEditorDefinition_Node(), this.getAbstractNode(), null, "node", null, 0, -1, EditorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(foldingBehaviorEClass, FoldingBehavior.class, "FoldingBehavior", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(javaLabelElementEClass, JavaLabelElement.class, "JavaLabelElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaLabelElement_Class(), theEcorePackage.getEString(), "class", null, 0, 1, JavaLabelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaLabelElement_Method(), theEcorePackage.getEString(), "method", "toString", 1, 1, JavaLabelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaNodeEClass, JavaNode.class, "JavaNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaNode_Name(), theEcorePackage.getEString(), "name", null, 1, 1, JavaNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(labelBehaviorEClass, LabelBehavior.class, "LabelBehavior", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLabelBehavior_Image(), theEcorePackage.getEString(), "image", null, 0, 1, LabelBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType(this.getImageProvider());
		g1.getETypeArguments().add(g2);
		initEAttribute(getLabelBehavior_ImageProvider(), g1, "imageProvider", null, 0, 1, LabelBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLabelBehavior_Format(), theEcorePackage.getEString(), "format", "", 1, 1, LabelBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType(this.getFormatProvider());
		g1.getETypeArguments().add(g2);
		initEAttribute(getLabelBehavior_FormatProvider(), g1, "formatProvider", null, 0, 1, LabelBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLabelBehavior_Elements(), this.getAbstractLabelElement(), null, "elements", null, 0, -1, LabelBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outlineBehaviorEClass, OutlineBehavior.class, "OutlineBehavior", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutlineBehavior_Elements(), this.getAbstractOutlineElement(), null, "elements", null, 0, -1, OutlineBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOutlineBehavior_Hidden(), theEcorePackage.getEBoolean(), "hidden", "false", 0, 1, OutlineBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outlineElementEClass, OutlineElement.class, "OutlineElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutlineElement_Feature(), theEcorePackage.getEStructuralFeature(), null, "feature", null, 1, 1, OutlineElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outlineGroupEClass, OutlineGroup.class, "OutlineGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOutlineGroup_Image(), theEcorePackage.getEString(), "image", null, 0, 1, OutlineGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOutlineGroup_Name(), theEcorePackage.getEString(), "name", "", 1, 1, OutlineGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutlineGroup_Elements(), this.getAbstractOutlineElement(), null, "elements", null, 0, -1, OutlineGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOutlineGroup_Hidden(), theEcorePackage.getEBoolean(), "hidden", "false", 0, 1, OutlineGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(formatProviderEDataType, FormatProvider.class, "FormatProvider", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(imageProviderEDataType, ImageProvider.class, "ImageProvider", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(textProviderEDataType, TextProvider.class, "TextProvider", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EditorPackageImpl
