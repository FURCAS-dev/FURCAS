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
 * $Id: EditorPackage.java,v 1.2 2010/04/08 06:26:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.editor.EditorFactory
 * @model kind="package"
 * @generated
 */
public interface EditorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "editor";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/1.0/Editor";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ed";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.ocl.editor";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EditorPackage eINSTANCE = org.eclipse.ocl.examples.editor.impl.EditorPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.editor.impl.AbstractLabelElementImpl <em>Abstract Label Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.editor.impl.AbstractLabelElementImpl
	 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getAbstractLabelElement()
	 * @generated
	 */
	int ABSTRACT_LABEL_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Abstract Label Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LABEL_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.editor.impl.AbstractNodeImpl <em>Abstract Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.editor.impl.AbstractNodeImpl
	 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getAbstractNode()
	 * @generated
	 */
	int ABSTRACT_NODE = 1;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NODE__BEHAVIOR = 0;

	/**
	 * The feature id for the '<em><b>Base</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NODE__BASE = 1;

	/**
	 * The number of structural features of the '<em>Abstract Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NODE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.editor.impl.AbstractOutlineElementImpl <em>Abstract Outline Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.editor.impl.AbstractOutlineElementImpl
	 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getAbstractOutlineElement()
	 * @generated
	 */
	int ABSTRACT_OUTLINE_ELEMENT = 2;

	/**
	 * The number of structural features of the '<em>Abstract Outline Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OUTLINE_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.editor.impl.BehaviorImpl <em>Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.editor.impl.BehaviorImpl
	 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getBehavior()
	 * @generated
	 */
	int BEHAVIOR = 3;

	/**
	 * The number of structural features of the '<em>Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.editor.impl.EcoreLabelElementImpl <em>Ecore Label Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.editor.impl.EcoreLabelElementImpl
	 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getEcoreLabelElement()
	 * @generated
	 */
	int ECORE_LABEL_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_LABEL_ELEMENT__PATH = ABSTRACT_LABEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_LABEL_ELEMENT__END = ABSTRACT_LABEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Hide If Blank</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_LABEL_ELEMENT__HIDE_IF_BLANK = ABSTRACT_LABEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_LABEL_ELEMENT__PREFIX = ABSTRACT_LABEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_LABEL_ELEMENT__SEPARATOR = ABSTRACT_LABEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Suffix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_LABEL_ELEMENT__SUFFIX = ABSTRACT_LABEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Text Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_LABEL_ELEMENT__TEXT_PROVIDER = ABSTRACT_LABEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Ecore Label Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_LABEL_ELEMENT_FEATURE_COUNT = ABSTRACT_LABEL_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.editor.impl.EditorDefinitionImpl <em>Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.editor.impl.EditorDefinitionImpl
	 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getEditorDefinition()
	 * @generated
	 */
	int EDITOR_DEFINITION = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.editor.impl.FoldingBehaviorImpl <em>Folding Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.editor.impl.FoldingBehaviorImpl
	 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getFoldingBehavior()
	 * @generated
	 */
	int FOLDING_BEHAVIOR = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.editor.impl.JavaNodeImpl <em>Java Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.editor.impl.JavaNodeImpl
	 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getJavaNode()
	 * @generated
	 */
	int JAVA_NODE = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.editor.impl.EcoreNodeImpl <em>Ecore Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.editor.impl.EcoreNodeImpl
	 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getEcoreNode()
	 * @generated
	 */
	int ECORE_NODE = 5;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_NODE__BEHAVIOR = ABSTRACT_NODE__BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Base</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_NODE__BASE = ABSTRACT_NODE__BASE;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_NODE__ELEMENT = ABSTRACT_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ecore Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_NODE_FEATURE_COUNT = ABSTRACT_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_DEFINITION__LANGUAGE = 0;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_DEFINITION__EXTENDS = 1;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_DEFINITION__NODE = 2;

	/**
	 * The number of structural features of the '<em>Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_DEFINITION_FEATURE_COUNT = 3;

	/**
	 * The number of structural features of the '<em>Folding Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDING_BEHAVIOR_FEATURE_COUNT = BEHAVIOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.editor.impl.JavaLabelElementImpl <em>Java Label Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.editor.impl.JavaLabelElementImpl
	 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getJavaLabelElement()
	 * @generated
	 */
	int JAVA_LABEL_ELEMENT = 8;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_LABEL_ELEMENT__CLASS = ABSTRACT_LABEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_LABEL_ELEMENT__METHOD = ABSTRACT_LABEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Java Label Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_LABEL_ELEMENT_FEATURE_COUNT = ABSTRACT_LABEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NODE__BEHAVIOR = ABSTRACT_NODE__BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Base</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NODE__BASE = ABSTRACT_NODE__BASE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NODE__NAME = ABSTRACT_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Java Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NODE_FEATURE_COUNT = ABSTRACT_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.editor.impl.LabelBehaviorImpl <em>Label Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.editor.impl.LabelBehaviorImpl
	 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getLabelBehavior()
	 * @generated
	 */
	int LABEL_BEHAVIOR = 10;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_BEHAVIOR__IMAGE = BEHAVIOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Image Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_BEHAVIOR__IMAGE_PROVIDER = BEHAVIOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_BEHAVIOR__FORMAT = BEHAVIOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Format Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_BEHAVIOR__FORMAT_PROVIDER = BEHAVIOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_BEHAVIOR__ELEMENTS = BEHAVIOR_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Label Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_BEHAVIOR_FEATURE_COUNT = BEHAVIOR_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.editor.impl.OutlineBehaviorImpl <em>Outline Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.editor.impl.OutlineBehaviorImpl
	 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getOutlineBehavior()
	 * @generated
	 */
	int OUTLINE_BEHAVIOR = 11;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTLINE_BEHAVIOR__ELEMENTS = BEHAVIOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Hidden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTLINE_BEHAVIOR__HIDDEN = BEHAVIOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Outline Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTLINE_BEHAVIOR_FEATURE_COUNT = BEHAVIOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.editor.impl.OutlineElementImpl <em>Outline Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.editor.impl.OutlineElementImpl
	 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getOutlineElement()
	 * @generated
	 */
	int OUTLINE_ELEMENT = 12;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTLINE_ELEMENT__FEATURE = ABSTRACT_OUTLINE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Outline Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTLINE_ELEMENT_FEATURE_COUNT = ABSTRACT_OUTLINE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.editor.impl.OutlineGroupImpl <em>Outline Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.editor.impl.OutlineGroupImpl
	 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getOutlineGroup()
	 * @generated
	 */
	int OUTLINE_GROUP = 13;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTLINE_GROUP__IMAGE = ABSTRACT_OUTLINE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTLINE_GROUP__NAME = ABSTRACT_OUTLINE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTLINE_GROUP__ELEMENTS = ABSTRACT_OUTLINE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Hidden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTLINE_GROUP__HIDDEN = ABSTRACT_OUTLINE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Outline Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTLINE_GROUP_FEATURE_COUNT = ABSTRACT_OUTLINE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '<em>Format Provider</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.editor.util.FormatProvider
	 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getFormatProvider()
	 * @generated
	 */
	int FORMAT_PROVIDER = 14;

	/**
	 * The meta object id for the '<em>Image Provider</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.editor.util.ImageProvider
	 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getImageProvider()
	 * @generated
	 */
	int IMAGE_PROVIDER = 15;

	/**
	 * The meta object id for the '<em>Text Provider</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.editor.util.TextProvider
	 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getTextProvider()
	 * @generated
	 */
	int TEXT_PROVIDER = 16;

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.editor.AbstractLabelElement <em>Abstract Label Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Label Element</em>'.
	 * @see org.eclipse.ocl.examples.editor.AbstractLabelElement
	 * @generated
	 */
	EClass getAbstractLabelElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.editor.AbstractNode <em>Abstract Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Node</em>'.
	 * @see org.eclipse.ocl.examples.editor.AbstractNode
	 * @generated
	 */
	EClass getAbstractNode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.editor.AbstractNode#getBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Behavior</em>'.
	 * @see org.eclipse.ocl.examples.editor.AbstractNode#getBehavior()
	 * @see #getAbstractNode()
	 * @generated
	 */
	EReference getAbstractNode_Behavior();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.editor.AbstractNode#getBase <em>Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base</em>'.
	 * @see org.eclipse.ocl.examples.editor.AbstractNode#getBase()
	 * @see #getAbstractNode()
	 * @generated
	 */
	EReference getAbstractNode_Base();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.editor.AbstractOutlineElement <em>Abstract Outline Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Outline Element</em>'.
	 * @see org.eclipse.ocl.examples.editor.AbstractOutlineElement
	 * @generated
	 */
	EClass getAbstractOutlineElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.editor.Behavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior</em>'.
	 * @see org.eclipse.ocl.examples.editor.Behavior
	 * @generated
	 */
	EClass getBehavior();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.editor.EcoreLabelElement <em>Ecore Label Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecore Label Element</em>'.
	 * @see org.eclipse.ocl.examples.editor.EcoreLabelElement
	 * @generated
	 */
	EClass getEcoreLabelElement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.editor.EcoreLabelElement#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Path</em>'.
	 * @see org.eclipse.ocl.examples.editor.EcoreLabelElement#getPath()
	 * @see #getEcoreLabelElement()
	 * @generated
	 */
	EReference getEcoreLabelElement_Path();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.editor.EcoreLabelElement#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End</em>'.
	 * @see org.eclipse.ocl.examples.editor.EcoreLabelElement#getEnd()
	 * @see #getEcoreLabelElement()
	 * @generated
	 */
	EReference getEcoreLabelElement_End();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.editor.EcoreLabelElement#isHideIfBlank <em>Hide If Blank</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hide If Blank</em>'.
	 * @see org.eclipse.ocl.examples.editor.EcoreLabelElement#isHideIfBlank()
	 * @see #getEcoreLabelElement()
	 * @generated
	 */
	EAttribute getEcoreLabelElement_HideIfBlank();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.editor.EcoreLabelElement#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.eclipse.ocl.examples.editor.EcoreLabelElement#getPrefix()
	 * @see #getEcoreLabelElement()
	 * @generated
	 */
	EAttribute getEcoreLabelElement_Prefix();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.editor.EcoreLabelElement#getSeparator <em>Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Separator</em>'.
	 * @see org.eclipse.ocl.examples.editor.EcoreLabelElement#getSeparator()
	 * @see #getEcoreLabelElement()
	 * @generated
	 */
	EAttribute getEcoreLabelElement_Separator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.editor.EcoreLabelElement#getSuffix <em>Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suffix</em>'.
	 * @see org.eclipse.ocl.examples.editor.EcoreLabelElement#getSuffix()
	 * @see #getEcoreLabelElement()
	 * @generated
	 */
	EAttribute getEcoreLabelElement_Suffix();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.editor.EcoreLabelElement#getTextProvider <em>Text Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Provider</em>'.
	 * @see org.eclipse.ocl.examples.editor.EcoreLabelElement#getTextProvider()
	 * @see #getEcoreLabelElement()
	 * @generated
	 */
	EAttribute getEcoreLabelElement_TextProvider();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.editor.EcoreNode <em>Ecore Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecore Node</em>'.
	 * @see org.eclipse.ocl.examples.editor.EcoreNode
	 * @generated
	 */
	EClass getEcoreNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.editor.EcoreNode#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.ocl.examples.editor.EcoreNode#getElement()
	 * @see #getEcoreNode()
	 * @generated
	 */
	EReference getEcoreNode_Element();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.editor.EditorDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Definition</em>'.
	 * @see org.eclipse.ocl.examples.editor.EditorDefinition
	 * @generated
	 */
	EClass getEditorDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.editor.EditorDefinition#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see org.eclipse.ocl.examples.editor.EditorDefinition#getLanguage()
	 * @see #getEditorDefinition()
	 * @generated
	 */
	EAttribute getEditorDefinition_Language();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.editor.EditorDefinition#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extends</em>'.
	 * @see org.eclipse.ocl.examples.editor.EditorDefinition#getExtends()
	 * @see #getEditorDefinition()
	 * @generated
	 */
	EReference getEditorDefinition_Extends();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.editor.EditorDefinition#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Node</em>'.
	 * @see org.eclipse.ocl.examples.editor.EditorDefinition#getNode()
	 * @see #getEditorDefinition()
	 * @generated
	 */
	EReference getEditorDefinition_Node();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.editor.FoldingBehavior <em>Folding Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Folding Behavior</em>'.
	 * @see org.eclipse.ocl.examples.editor.FoldingBehavior
	 * @generated
	 */
	EClass getFoldingBehavior();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.editor.JavaLabelElement <em>Java Label Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Label Element</em>'.
	 * @see org.eclipse.ocl.examples.editor.JavaLabelElement
	 * @generated
	 */
	EClass getJavaLabelElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.editor.JavaLabelElement#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class</em>'.
	 * @see org.eclipse.ocl.examples.editor.JavaLabelElement#getClass_()
	 * @see #getJavaLabelElement()
	 * @generated
	 */
	EAttribute getJavaLabelElement_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.editor.JavaLabelElement#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method</em>'.
	 * @see org.eclipse.ocl.examples.editor.JavaLabelElement#getMethod()
	 * @see #getJavaLabelElement()
	 * @generated
	 */
	EAttribute getJavaLabelElement_Method();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.editor.JavaNode <em>Java Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Node</em>'.
	 * @see org.eclipse.ocl.examples.editor.JavaNode
	 * @generated
	 */
	EClass getJavaNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.editor.JavaNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.editor.JavaNode#getName()
	 * @see #getJavaNode()
	 * @generated
	 */
	EAttribute getJavaNode_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.editor.LabelBehavior <em>Label Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label Behavior</em>'.
	 * @see org.eclipse.ocl.examples.editor.LabelBehavior
	 * @generated
	 */
	EClass getLabelBehavior();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.editor.LabelBehavior#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see org.eclipse.ocl.examples.editor.LabelBehavior#getImage()
	 * @see #getLabelBehavior()
	 * @generated
	 */
	EAttribute getLabelBehavior_Image();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.editor.LabelBehavior#getImageProvider <em>Image Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Provider</em>'.
	 * @see org.eclipse.ocl.examples.editor.LabelBehavior#getImageProvider()
	 * @see #getLabelBehavior()
	 * @generated
	 */
	EAttribute getLabelBehavior_ImageProvider();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.editor.LabelBehavior#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see org.eclipse.ocl.examples.editor.LabelBehavior#getFormat()
	 * @see #getLabelBehavior()
	 * @generated
	 */
	EAttribute getLabelBehavior_Format();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.editor.LabelBehavior#getFormatProvider <em>Format Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format Provider</em>'.
	 * @see org.eclipse.ocl.examples.editor.LabelBehavior#getFormatProvider()
	 * @see #getLabelBehavior()
	 * @generated
	 */
	EAttribute getLabelBehavior_FormatProvider();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.editor.LabelBehavior#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.ocl.examples.editor.LabelBehavior#getElements()
	 * @see #getLabelBehavior()
	 * @generated
	 */
	EReference getLabelBehavior_Elements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.editor.OutlineBehavior <em>Outline Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Outline Behavior</em>'.
	 * @see org.eclipse.ocl.examples.editor.OutlineBehavior
	 * @generated
	 */
	EClass getOutlineBehavior();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.editor.OutlineBehavior#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.ocl.examples.editor.OutlineBehavior#getElements()
	 * @see #getOutlineBehavior()
	 * @generated
	 */
	EReference getOutlineBehavior_Elements();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.editor.OutlineBehavior#isHidden <em>Hidden</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hidden</em>'.
	 * @see org.eclipse.ocl.examples.editor.OutlineBehavior#isHidden()
	 * @see #getOutlineBehavior()
	 * @generated
	 */
	EAttribute getOutlineBehavior_Hidden();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.editor.OutlineElement <em>Outline Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Outline Element</em>'.
	 * @see org.eclipse.ocl.examples.editor.OutlineElement
	 * @generated
	 */
	EClass getOutlineElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.editor.OutlineElement#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see org.eclipse.ocl.examples.editor.OutlineElement#getFeature()
	 * @see #getOutlineElement()
	 * @generated
	 */
	EReference getOutlineElement_Feature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.editor.OutlineGroup <em>Outline Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Outline Group</em>'.
	 * @see org.eclipse.ocl.examples.editor.OutlineGroup
	 * @generated
	 */
	EClass getOutlineGroup();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.editor.OutlineGroup#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see org.eclipse.ocl.examples.editor.OutlineGroup#getImage()
	 * @see #getOutlineGroup()
	 * @generated
	 */
	EAttribute getOutlineGroup_Image();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.editor.OutlineGroup#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.editor.OutlineGroup#getName()
	 * @see #getOutlineGroup()
	 * @generated
	 */
	EAttribute getOutlineGroup_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.editor.OutlineGroup#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.ocl.examples.editor.OutlineGroup#getElements()
	 * @see #getOutlineGroup()
	 * @generated
	 */
	EReference getOutlineGroup_Elements();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.editor.OutlineGroup#isHidden <em>Hidden</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hidden</em>'.
	 * @see org.eclipse.ocl.examples.editor.OutlineGroup#isHidden()
	 * @see #getOutlineGroup()
	 * @generated
	 */
	EAttribute getOutlineGroup_Hidden();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.examples.editor.util.FormatProvider <em>Format Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Format Provider</em>'.
	 * @see org.eclipse.ocl.examples.editor.util.FormatProvider
	 * @model instanceClass="org.eclipse.ocl.examples.editor.util.FormatProvider"
	 * @generated
	 */
	EDataType getFormatProvider();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.examples.editor.util.ImageProvider <em>Image Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Image Provider</em>'.
	 * @see org.eclipse.ocl.examples.editor.util.ImageProvider
	 * @model instanceClass="org.eclipse.ocl.examples.editor.util.ImageProvider"
	 * @generated
	 */
	EDataType getImageProvider();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.examples.editor.util.TextProvider <em>Text Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Text Provider</em>'.
	 * @see org.eclipse.ocl.examples.editor.util.TextProvider
	 * @model instanceClass="org.eclipse.ocl.examples.editor.util.TextProvider"
	 * @generated
	 */
	EDataType getTextProvider();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EditorFactory getEditorFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.editor.impl.AbstractLabelElementImpl <em>Abstract Label Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.editor.impl.AbstractLabelElementImpl
		 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getAbstractLabelElement()
		 * @generated
		 */
		EClass ABSTRACT_LABEL_ELEMENT = eINSTANCE.getAbstractLabelElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.editor.impl.AbstractNodeImpl <em>Abstract Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.editor.impl.AbstractNodeImpl
		 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getAbstractNode()
		 * @generated
		 */
		EClass ABSTRACT_NODE = eINSTANCE.getAbstractNode();

		/**
		 * The meta object literal for the '<em><b>Behavior</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_NODE__BEHAVIOR = eINSTANCE.getAbstractNode_Behavior();

		/**
		 * The meta object literal for the '<em><b>Base</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_NODE__BASE = eINSTANCE.getAbstractNode_Base();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.editor.impl.AbstractOutlineElementImpl <em>Abstract Outline Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.editor.impl.AbstractOutlineElementImpl
		 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getAbstractOutlineElement()
		 * @generated
		 */
		EClass ABSTRACT_OUTLINE_ELEMENT = eINSTANCE.getAbstractOutlineElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.editor.impl.BehaviorImpl <em>Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.editor.impl.BehaviorImpl
		 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getBehavior()
		 * @generated
		 */
		EClass BEHAVIOR = eINSTANCE.getBehavior();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.editor.impl.EcoreLabelElementImpl <em>Ecore Label Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.editor.impl.EcoreLabelElementImpl
		 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getEcoreLabelElement()
		 * @generated
		 */
		EClass ECORE_LABEL_ELEMENT = eINSTANCE.getEcoreLabelElement();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECORE_LABEL_ELEMENT__PATH = eINSTANCE.getEcoreLabelElement_Path();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECORE_LABEL_ELEMENT__END = eINSTANCE.getEcoreLabelElement_End();

		/**
		 * The meta object literal for the '<em><b>Hide If Blank</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECORE_LABEL_ELEMENT__HIDE_IF_BLANK = eINSTANCE.getEcoreLabelElement_HideIfBlank();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECORE_LABEL_ELEMENT__PREFIX = eINSTANCE.getEcoreLabelElement_Prefix();

		/**
		 * The meta object literal for the '<em><b>Separator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECORE_LABEL_ELEMENT__SEPARATOR = eINSTANCE.getEcoreLabelElement_Separator();

		/**
		 * The meta object literal for the '<em><b>Suffix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECORE_LABEL_ELEMENT__SUFFIX = eINSTANCE.getEcoreLabelElement_Suffix();

		/**
		 * The meta object literal for the '<em><b>Text Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECORE_LABEL_ELEMENT__TEXT_PROVIDER = eINSTANCE.getEcoreLabelElement_TextProvider();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.editor.impl.EcoreNodeImpl <em>Ecore Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.editor.impl.EcoreNodeImpl
		 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getEcoreNode()
		 * @generated
		 */
		EClass ECORE_NODE = eINSTANCE.getEcoreNode();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECORE_NODE__ELEMENT = eINSTANCE.getEcoreNode_Element();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.editor.impl.EditorDefinitionImpl <em>Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.editor.impl.EditorDefinitionImpl
		 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getEditorDefinition()
		 * @generated
		 */
		EClass EDITOR_DEFINITION = eINSTANCE.getEditorDefinition();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDITOR_DEFINITION__LANGUAGE = eINSTANCE.getEditorDefinition_Language();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDITOR_DEFINITION__EXTENDS = eINSTANCE.getEditorDefinition_Extends();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDITOR_DEFINITION__NODE = eINSTANCE.getEditorDefinition_Node();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.editor.impl.FoldingBehaviorImpl <em>Folding Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.editor.impl.FoldingBehaviorImpl
		 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getFoldingBehavior()
		 * @generated
		 */
		EClass FOLDING_BEHAVIOR = eINSTANCE.getFoldingBehavior();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.editor.impl.JavaLabelElementImpl <em>Java Label Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.editor.impl.JavaLabelElementImpl
		 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getJavaLabelElement()
		 * @generated
		 */
		EClass JAVA_LABEL_ELEMENT = eINSTANCE.getJavaLabelElement();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_LABEL_ELEMENT__CLASS = eINSTANCE.getJavaLabelElement_Class();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_LABEL_ELEMENT__METHOD = eINSTANCE.getJavaLabelElement_Method();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.editor.impl.JavaNodeImpl <em>Java Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.editor.impl.JavaNodeImpl
		 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getJavaNode()
		 * @generated
		 */
		EClass JAVA_NODE = eINSTANCE.getJavaNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_NODE__NAME = eINSTANCE.getJavaNode_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.editor.impl.LabelBehaviorImpl <em>Label Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.editor.impl.LabelBehaviorImpl
		 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getLabelBehavior()
		 * @generated
		 */
		EClass LABEL_BEHAVIOR = eINSTANCE.getLabelBehavior();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABEL_BEHAVIOR__IMAGE = eINSTANCE.getLabelBehavior_Image();

		/**
		 * The meta object literal for the '<em><b>Image Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABEL_BEHAVIOR__IMAGE_PROVIDER = eINSTANCE.getLabelBehavior_ImageProvider();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABEL_BEHAVIOR__FORMAT = eINSTANCE.getLabelBehavior_Format();

		/**
		 * The meta object literal for the '<em><b>Format Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABEL_BEHAVIOR__FORMAT_PROVIDER = eINSTANCE.getLabelBehavior_FormatProvider();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABEL_BEHAVIOR__ELEMENTS = eINSTANCE.getLabelBehavior_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.editor.impl.OutlineBehaviorImpl <em>Outline Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.editor.impl.OutlineBehaviorImpl
		 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getOutlineBehavior()
		 * @generated
		 */
		EClass OUTLINE_BEHAVIOR = eINSTANCE.getOutlineBehavior();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTLINE_BEHAVIOR__ELEMENTS = eINSTANCE.getOutlineBehavior_Elements();

		/**
		 * The meta object literal for the '<em><b>Hidden</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTLINE_BEHAVIOR__HIDDEN = eINSTANCE.getOutlineBehavior_Hidden();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.editor.impl.OutlineElementImpl <em>Outline Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.editor.impl.OutlineElementImpl
		 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getOutlineElement()
		 * @generated
		 */
		EClass OUTLINE_ELEMENT = eINSTANCE.getOutlineElement();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTLINE_ELEMENT__FEATURE = eINSTANCE.getOutlineElement_Feature();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.editor.impl.OutlineGroupImpl <em>Outline Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.editor.impl.OutlineGroupImpl
		 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getOutlineGroup()
		 * @generated
		 */
		EClass OUTLINE_GROUP = eINSTANCE.getOutlineGroup();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTLINE_GROUP__IMAGE = eINSTANCE.getOutlineGroup_Image();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTLINE_GROUP__NAME = eINSTANCE.getOutlineGroup_Name();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTLINE_GROUP__ELEMENTS = eINSTANCE.getOutlineGroup_Elements();

		/**
		 * The meta object literal for the '<em><b>Hidden</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTLINE_GROUP__HIDDEN = eINSTANCE.getOutlineGroup_Hidden();

		/**
		 * The meta object literal for the '<em>Format Provider</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.editor.util.FormatProvider
		 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getFormatProvider()
		 * @generated
		 */
		EDataType FORMAT_PROVIDER = eINSTANCE.getFormatProvider();

		/**
		 * The meta object literal for the '<em>Image Provider</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.editor.util.ImageProvider
		 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getImageProvider()
		 * @generated
		 */
		EDataType IMAGE_PROVIDER = eINSTANCE.getImageProvider();

		/**
		 * The meta object literal for the '<em>Text Provider</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.editor.util.TextProvider
		 * @see org.eclipse.ocl.examples.editor.impl.EditorPackageImpl#getTextProvider()
		 * @generated
		 */
		EDataType TEXT_PROVIDER = eINSTANCE.getTextProvider();

	}

} //EditorPackage
