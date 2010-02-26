/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.StdLibrary;

import com.sap.tc.moin.repository.mmi.Model.ModelPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.omg.OCL.StdLibrary.StdLibraryFactory
 * @model kind="package"
 * @generated
 */
public interface StdLibraryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "StdLibrary";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/OCL/StdLibrary";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "stdlibrary";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StdLibraryPackage eINSTANCE = org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.omg.OCL.StdLibrary.impl.OclAnyStdLibImpl <em>Ocl Any Std Lib</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.OCL.StdLibrary.impl.OclAnyStdLibImpl
	 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getOclAnyStdLib()
	 * @generated
	 */
	int OCL_ANY_STD_LIB = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_ANY_STD_LIB__NAME = ModelPackage.CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_ANY_STD_LIB__QUALIFIED_NAME = ModelPackage.CLASSIFIER__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_ANY_STD_LIB__ANNOTATION = ModelPackage.CLASSIFIER__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Required Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_ANY_STD_LIB__REQUIRED_ELEMENTS = ModelPackage.CLASSIFIER__REQUIRED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_ANY_STD_LIB__CONTAINER = ModelPackage.CLASSIFIER__CONTAINER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_ANY_STD_LIB__CONSTRAINTS = ModelPackage.CLASSIFIER__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_ANY_STD_LIB__CONTENTS = ModelPackage.CLASSIFIER__CONTENTS;

	/**
	 * The feature id for the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_ANY_STD_LIB__IS_ROOT = ModelPackage.CLASSIFIER__IS_ROOT;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_ANY_STD_LIB__IS_LEAF = ModelPackage.CLASSIFIER__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_ANY_STD_LIB__IS_ABSTRACT = ModelPackage.CLASSIFIER__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_ANY_STD_LIB__VISIBILITY = ModelPackage.CLASSIFIER__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_ANY_STD_LIB__SUPERTYPES = ModelPackage.CLASSIFIER__SUPERTYPES;

	/**
	 * The number of structural features of the '<em>Ocl Any Std Lib</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_ANY_STD_LIB_FEATURE_COUNT = ModelPackage.CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.OCL.StdLibrary.impl.StringStdLibImpl <em>String Std Lib</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.OCL.StdLibrary.impl.StringStdLibImpl
	 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getStringStdLib()
	 * @generated
	 */
	int STRING_STD_LIB = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_STD_LIB__NAME = OCL_ANY_STD_LIB__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_STD_LIB__QUALIFIED_NAME = OCL_ANY_STD_LIB__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_STD_LIB__ANNOTATION = OCL_ANY_STD_LIB__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Required Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_STD_LIB__REQUIRED_ELEMENTS = OCL_ANY_STD_LIB__REQUIRED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_STD_LIB__CONTAINER = OCL_ANY_STD_LIB__CONTAINER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_STD_LIB__CONSTRAINTS = OCL_ANY_STD_LIB__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_STD_LIB__CONTENTS = OCL_ANY_STD_LIB__CONTENTS;

	/**
	 * The feature id for the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_STD_LIB__IS_ROOT = OCL_ANY_STD_LIB__IS_ROOT;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_STD_LIB__IS_LEAF = OCL_ANY_STD_LIB__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_STD_LIB__IS_ABSTRACT = OCL_ANY_STD_LIB__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_STD_LIB__VISIBILITY = OCL_ANY_STD_LIB__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_STD_LIB__SUPERTYPES = OCL_ANY_STD_LIB__SUPERTYPES;

	/**
	 * The number of structural features of the '<em>String Std Lib</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_STD_LIB_FEATURE_COUNT = OCL_ANY_STD_LIB_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.OCL.StdLibrary.impl.BooleanStdLibImpl <em>Boolean Std Lib</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.OCL.StdLibrary.impl.BooleanStdLibImpl
	 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getBooleanStdLib()
	 * @generated
	 */
	int BOOLEAN_STD_LIB = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_STD_LIB__NAME = OCL_ANY_STD_LIB__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_STD_LIB__QUALIFIED_NAME = OCL_ANY_STD_LIB__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_STD_LIB__ANNOTATION = OCL_ANY_STD_LIB__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Required Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_STD_LIB__REQUIRED_ELEMENTS = OCL_ANY_STD_LIB__REQUIRED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_STD_LIB__CONTAINER = OCL_ANY_STD_LIB__CONTAINER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_STD_LIB__CONSTRAINTS = OCL_ANY_STD_LIB__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_STD_LIB__CONTENTS = OCL_ANY_STD_LIB__CONTENTS;

	/**
	 * The feature id for the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_STD_LIB__IS_ROOT = OCL_ANY_STD_LIB__IS_ROOT;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_STD_LIB__IS_LEAF = OCL_ANY_STD_LIB__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_STD_LIB__IS_ABSTRACT = OCL_ANY_STD_LIB__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_STD_LIB__VISIBILITY = OCL_ANY_STD_LIB__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_STD_LIB__SUPERTYPES = OCL_ANY_STD_LIB__SUPERTYPES;

	/**
	 * The number of structural features of the '<em>Boolean Std Lib</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_STD_LIB_FEATURE_COUNT = OCL_ANY_STD_LIB_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.OCL.StdLibrary.impl.FloatStdLibImpl <em>Float Std Lib</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.OCL.StdLibrary.impl.FloatStdLibImpl
	 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getFloatStdLib()
	 * @generated
	 */
	int FLOAT_STD_LIB = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_STD_LIB__NAME = OCL_ANY_STD_LIB__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_STD_LIB__QUALIFIED_NAME = OCL_ANY_STD_LIB__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_STD_LIB__ANNOTATION = OCL_ANY_STD_LIB__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Required Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_STD_LIB__REQUIRED_ELEMENTS = OCL_ANY_STD_LIB__REQUIRED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_STD_LIB__CONTAINER = OCL_ANY_STD_LIB__CONTAINER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_STD_LIB__CONSTRAINTS = OCL_ANY_STD_LIB__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_STD_LIB__CONTENTS = OCL_ANY_STD_LIB__CONTENTS;

	/**
	 * The feature id for the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_STD_LIB__IS_ROOT = OCL_ANY_STD_LIB__IS_ROOT;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_STD_LIB__IS_LEAF = OCL_ANY_STD_LIB__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_STD_LIB__IS_ABSTRACT = OCL_ANY_STD_LIB__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_STD_LIB__VISIBILITY = OCL_ANY_STD_LIB__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_STD_LIB__SUPERTYPES = OCL_ANY_STD_LIB__SUPERTYPES;

	/**
	 * The number of structural features of the '<em>Float Std Lib</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_STD_LIB_FEATURE_COUNT = OCL_ANY_STD_LIB_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.OCL.StdLibrary.impl.CollectionTypeStdLibImpl <em>Collection Type Std Lib</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.OCL.StdLibrary.impl.CollectionTypeStdLibImpl
	 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getCollectionTypeStdLib()
	 * @generated
	 */
	int COLLECTION_TYPE_STD_LIB = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_STD_LIB__NAME = ModelPackage.CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_STD_LIB__QUALIFIED_NAME = ModelPackage.CLASSIFIER__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_STD_LIB__ANNOTATION = ModelPackage.CLASSIFIER__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Required Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_STD_LIB__REQUIRED_ELEMENTS = ModelPackage.CLASSIFIER__REQUIRED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_STD_LIB__CONTAINER = ModelPackage.CLASSIFIER__CONTAINER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_STD_LIB__CONSTRAINTS = ModelPackage.CLASSIFIER__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_STD_LIB__CONTENTS = ModelPackage.CLASSIFIER__CONTENTS;

	/**
	 * The feature id for the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_STD_LIB__IS_ROOT = ModelPackage.CLASSIFIER__IS_ROOT;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_STD_LIB__IS_LEAF = ModelPackage.CLASSIFIER__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_STD_LIB__IS_ABSTRACT = ModelPackage.CLASSIFIER__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_STD_LIB__VISIBILITY = ModelPackage.CLASSIFIER__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_STD_LIB__SUPERTYPES = ModelPackage.CLASSIFIER__SUPERTYPES;

	/**
	 * The number of structural features of the '<em>Collection Type Std Lib</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_STD_LIB_FEATURE_COUNT = ModelPackage.CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.OCL.StdLibrary.impl.SetTypeStdLibImpl <em>Set Type Std Lib</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.OCL.StdLibrary.impl.SetTypeStdLibImpl
	 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getSetTypeStdLib()
	 * @generated
	 */
	int SET_TYPE_STD_LIB = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_STD_LIB__NAME = COLLECTION_TYPE_STD_LIB__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_STD_LIB__QUALIFIED_NAME = COLLECTION_TYPE_STD_LIB__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_STD_LIB__ANNOTATION = COLLECTION_TYPE_STD_LIB__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Required Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_STD_LIB__REQUIRED_ELEMENTS = COLLECTION_TYPE_STD_LIB__REQUIRED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_STD_LIB__CONTAINER = COLLECTION_TYPE_STD_LIB__CONTAINER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_STD_LIB__CONSTRAINTS = COLLECTION_TYPE_STD_LIB__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_STD_LIB__CONTENTS = COLLECTION_TYPE_STD_LIB__CONTENTS;

	/**
	 * The feature id for the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_STD_LIB__IS_ROOT = COLLECTION_TYPE_STD_LIB__IS_ROOT;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_STD_LIB__IS_LEAF = COLLECTION_TYPE_STD_LIB__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_STD_LIB__IS_ABSTRACT = COLLECTION_TYPE_STD_LIB__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_STD_LIB__VISIBILITY = COLLECTION_TYPE_STD_LIB__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_STD_LIB__SUPERTYPES = COLLECTION_TYPE_STD_LIB__SUPERTYPES;

	/**
	 * The number of structural features of the '<em>Set Type Std Lib</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_STD_LIB_FEATURE_COUNT = COLLECTION_TYPE_STD_LIB_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.OCL.StdLibrary.impl.SequenceTypeStdLibImpl <em>Sequence Type Std Lib</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.OCL.StdLibrary.impl.SequenceTypeStdLibImpl
	 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getSequenceTypeStdLib()
	 * @generated
	 */
	int SEQUENCE_TYPE_STD_LIB = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_STD_LIB__NAME = COLLECTION_TYPE_STD_LIB__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_STD_LIB__QUALIFIED_NAME = COLLECTION_TYPE_STD_LIB__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_STD_LIB__ANNOTATION = COLLECTION_TYPE_STD_LIB__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Required Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_STD_LIB__REQUIRED_ELEMENTS = COLLECTION_TYPE_STD_LIB__REQUIRED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_STD_LIB__CONTAINER = COLLECTION_TYPE_STD_LIB__CONTAINER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_STD_LIB__CONSTRAINTS = COLLECTION_TYPE_STD_LIB__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_STD_LIB__CONTENTS = COLLECTION_TYPE_STD_LIB__CONTENTS;

	/**
	 * The feature id for the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_STD_LIB__IS_ROOT = COLLECTION_TYPE_STD_LIB__IS_ROOT;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_STD_LIB__IS_LEAF = COLLECTION_TYPE_STD_LIB__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_STD_LIB__IS_ABSTRACT = COLLECTION_TYPE_STD_LIB__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_STD_LIB__VISIBILITY = COLLECTION_TYPE_STD_LIB__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_STD_LIB__SUPERTYPES = COLLECTION_TYPE_STD_LIB__SUPERTYPES;

	/**
	 * The number of structural features of the '<em>Sequence Type Std Lib</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_STD_LIB_FEATURE_COUNT = COLLECTION_TYPE_STD_LIB_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.OCL.StdLibrary.impl.BagTypeStdLibImpl <em>Bag Type Std Lib</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.OCL.StdLibrary.impl.BagTypeStdLibImpl
	 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getBagTypeStdLib()
	 * @generated
	 */
	int BAG_TYPE_STD_LIB = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_STD_LIB__NAME = COLLECTION_TYPE_STD_LIB__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_STD_LIB__QUALIFIED_NAME = COLLECTION_TYPE_STD_LIB__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_STD_LIB__ANNOTATION = COLLECTION_TYPE_STD_LIB__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Required Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_STD_LIB__REQUIRED_ELEMENTS = COLLECTION_TYPE_STD_LIB__REQUIRED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_STD_LIB__CONTAINER = COLLECTION_TYPE_STD_LIB__CONTAINER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_STD_LIB__CONSTRAINTS = COLLECTION_TYPE_STD_LIB__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_STD_LIB__CONTENTS = COLLECTION_TYPE_STD_LIB__CONTENTS;

	/**
	 * The feature id for the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_STD_LIB__IS_ROOT = COLLECTION_TYPE_STD_LIB__IS_ROOT;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_STD_LIB__IS_LEAF = COLLECTION_TYPE_STD_LIB__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_STD_LIB__IS_ABSTRACT = COLLECTION_TYPE_STD_LIB__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_STD_LIB__VISIBILITY = COLLECTION_TYPE_STD_LIB__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_STD_LIB__SUPERTYPES = COLLECTION_TYPE_STD_LIB__SUPERTYPES;

	/**
	 * The number of structural features of the '<em>Bag Type Std Lib</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_STD_LIB_FEATURE_COUNT = COLLECTION_TYPE_STD_LIB_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.OCL.StdLibrary.impl.OrderedSetTypeStdLibImpl <em>Ordered Set Type Std Lib</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.OCL.StdLibrary.impl.OrderedSetTypeStdLibImpl
	 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getOrderedSetTypeStdLib()
	 * @generated
	 */
	int ORDERED_SET_TYPE_STD_LIB = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_STD_LIB__NAME = COLLECTION_TYPE_STD_LIB__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_STD_LIB__QUALIFIED_NAME = COLLECTION_TYPE_STD_LIB__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_STD_LIB__ANNOTATION = COLLECTION_TYPE_STD_LIB__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Required Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_STD_LIB__REQUIRED_ELEMENTS = COLLECTION_TYPE_STD_LIB__REQUIRED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_STD_LIB__CONTAINER = COLLECTION_TYPE_STD_LIB__CONTAINER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_STD_LIB__CONSTRAINTS = COLLECTION_TYPE_STD_LIB__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_STD_LIB__CONTENTS = COLLECTION_TYPE_STD_LIB__CONTENTS;

	/**
	 * The feature id for the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_STD_LIB__IS_ROOT = COLLECTION_TYPE_STD_LIB__IS_ROOT;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_STD_LIB__IS_LEAF = COLLECTION_TYPE_STD_LIB__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_STD_LIB__IS_ABSTRACT = COLLECTION_TYPE_STD_LIB__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_STD_LIB__VISIBILITY = COLLECTION_TYPE_STD_LIB__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_STD_LIB__SUPERTYPES = COLLECTION_TYPE_STD_LIB__SUPERTYPES;

	/**
	 * The number of structural features of the '<em>Ordered Set Type Std Lib</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_STD_LIB_FEATURE_COUNT = COLLECTION_TYPE_STD_LIB_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.OCL.StdLibrary.impl.OclVoidStdLibImpl <em>Ocl Void Std Lib</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.OCL.StdLibrary.impl.OclVoidStdLibImpl
	 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getOclVoidStdLib()
	 * @generated
	 */
	int OCL_VOID_STD_LIB = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_VOID_STD_LIB__NAME = OCL_ANY_STD_LIB__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_VOID_STD_LIB__QUALIFIED_NAME = OCL_ANY_STD_LIB__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_VOID_STD_LIB__ANNOTATION = OCL_ANY_STD_LIB__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Required Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_VOID_STD_LIB__REQUIRED_ELEMENTS = OCL_ANY_STD_LIB__REQUIRED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_VOID_STD_LIB__CONTAINER = OCL_ANY_STD_LIB__CONTAINER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_VOID_STD_LIB__CONSTRAINTS = OCL_ANY_STD_LIB__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_VOID_STD_LIB__CONTENTS = OCL_ANY_STD_LIB__CONTENTS;

	/**
	 * The feature id for the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_VOID_STD_LIB__IS_ROOT = OCL_ANY_STD_LIB__IS_ROOT;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_VOID_STD_LIB__IS_LEAF = OCL_ANY_STD_LIB__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_VOID_STD_LIB__IS_ABSTRACT = OCL_ANY_STD_LIB__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_VOID_STD_LIB__VISIBILITY = OCL_ANY_STD_LIB__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_VOID_STD_LIB__SUPERTYPES = OCL_ANY_STD_LIB__SUPERTYPES;

	/**
	 * The number of structural features of the '<em>Ocl Void Std Lib</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_VOID_STD_LIB_FEATURE_COUNT = OCL_ANY_STD_LIB_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.OCL.StdLibrary.impl.IntegerStdLibImpl <em>Integer Std Lib</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.OCL.StdLibrary.impl.IntegerStdLibImpl
	 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getIntegerStdLib()
	 * @generated
	 */
	int INTEGER_STD_LIB = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_STD_LIB__NAME = OCL_ANY_STD_LIB__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_STD_LIB__QUALIFIED_NAME = OCL_ANY_STD_LIB__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_STD_LIB__ANNOTATION = OCL_ANY_STD_LIB__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Required Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_STD_LIB__REQUIRED_ELEMENTS = OCL_ANY_STD_LIB__REQUIRED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_STD_LIB__CONTAINER = OCL_ANY_STD_LIB__CONTAINER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_STD_LIB__CONSTRAINTS = OCL_ANY_STD_LIB__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_STD_LIB__CONTENTS = OCL_ANY_STD_LIB__CONTENTS;

	/**
	 * The feature id for the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_STD_LIB__IS_ROOT = OCL_ANY_STD_LIB__IS_ROOT;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_STD_LIB__IS_LEAF = OCL_ANY_STD_LIB__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_STD_LIB__IS_ABSTRACT = OCL_ANY_STD_LIB__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_STD_LIB__VISIBILITY = OCL_ANY_STD_LIB__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_STD_LIB__SUPERTYPES = OCL_ANY_STD_LIB__SUPERTYPES;

	/**
	 * The number of structural features of the '<em>Integer Std Lib</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_STD_LIB_FEATURE_COUNT = OCL_ANY_STD_LIB_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.OCL.StdLibrary.impl.OclTypeStdLibImpl <em>Ocl Type Std Lib</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.OCL.StdLibrary.impl.OclTypeStdLibImpl
	 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getOclTypeStdLib()
	 * @generated
	 */
	int OCL_TYPE_STD_LIB = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_TYPE_STD_LIB__NAME = OCL_ANY_STD_LIB__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_TYPE_STD_LIB__QUALIFIED_NAME = OCL_ANY_STD_LIB__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_TYPE_STD_LIB__ANNOTATION = OCL_ANY_STD_LIB__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Required Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_TYPE_STD_LIB__REQUIRED_ELEMENTS = OCL_ANY_STD_LIB__REQUIRED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_TYPE_STD_LIB__CONTAINER = OCL_ANY_STD_LIB__CONTAINER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_TYPE_STD_LIB__CONSTRAINTS = OCL_ANY_STD_LIB__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_TYPE_STD_LIB__CONTENTS = OCL_ANY_STD_LIB__CONTENTS;

	/**
	 * The feature id for the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_TYPE_STD_LIB__IS_ROOT = OCL_ANY_STD_LIB__IS_ROOT;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_TYPE_STD_LIB__IS_LEAF = OCL_ANY_STD_LIB__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_TYPE_STD_LIB__IS_ABSTRACT = OCL_ANY_STD_LIB__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_TYPE_STD_LIB__VISIBILITY = OCL_ANY_STD_LIB__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_TYPE_STD_LIB__SUPERTYPES = OCL_ANY_STD_LIB__SUPERTYPES;

	/**
	 * The number of structural features of the '<em>Ocl Type Std Lib</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_TYPE_STD_LIB_FEATURE_COUNT = OCL_ANY_STD_LIB_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.OCL.StdLibrary.impl.TupleTypeStdLibImpl <em>Tuple Type Std Lib</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.OCL.StdLibrary.impl.TupleTypeStdLibImpl
	 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getTupleTypeStdLib()
	 * @generated
	 */
	int TUPLE_TYPE_STD_LIB = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_STD_LIB__NAME = ModelPackage.CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_STD_LIB__QUALIFIED_NAME = ModelPackage.CLASSIFIER__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_STD_LIB__ANNOTATION = ModelPackage.CLASSIFIER__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Required Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_STD_LIB__REQUIRED_ELEMENTS = ModelPackage.CLASSIFIER__REQUIRED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_STD_LIB__CONTAINER = ModelPackage.CLASSIFIER__CONTAINER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_STD_LIB__CONSTRAINTS = ModelPackage.CLASSIFIER__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_STD_LIB__CONTENTS = ModelPackage.CLASSIFIER__CONTENTS;

	/**
	 * The feature id for the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_STD_LIB__IS_ROOT = ModelPackage.CLASSIFIER__IS_ROOT;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_STD_LIB__IS_LEAF = ModelPackage.CLASSIFIER__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_STD_LIB__IS_ABSTRACT = ModelPackage.CLASSIFIER__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_STD_LIB__VISIBILITY = ModelPackage.CLASSIFIER__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_STD_LIB__SUPERTYPES = ModelPackage.CLASSIFIER__SUPERTYPES;

	/**
	 * The number of structural features of the '<em>Tuple Type Std Lib</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_STD_LIB_FEATURE_COUNT = ModelPackage.CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.OCL.StdLibrary.impl.DoubleStdLibImpl <em>Double Std Lib</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.OCL.StdLibrary.impl.DoubleStdLibImpl
	 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getDoubleStdLib()
	 * @generated
	 */
	int DOUBLE_STD_LIB = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_STD_LIB__NAME = OCL_ANY_STD_LIB__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_STD_LIB__QUALIFIED_NAME = OCL_ANY_STD_LIB__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_STD_LIB__ANNOTATION = OCL_ANY_STD_LIB__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Required Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_STD_LIB__REQUIRED_ELEMENTS = OCL_ANY_STD_LIB__REQUIRED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_STD_LIB__CONTAINER = OCL_ANY_STD_LIB__CONTAINER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_STD_LIB__CONSTRAINTS = OCL_ANY_STD_LIB__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_STD_LIB__CONTENTS = OCL_ANY_STD_LIB__CONTENTS;

	/**
	 * The feature id for the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_STD_LIB__IS_ROOT = OCL_ANY_STD_LIB__IS_ROOT;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_STD_LIB__IS_LEAF = OCL_ANY_STD_LIB__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_STD_LIB__IS_ABSTRACT = OCL_ANY_STD_LIB__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_STD_LIB__VISIBILITY = OCL_ANY_STD_LIB__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_STD_LIB__SUPERTYPES = OCL_ANY_STD_LIB__SUPERTYPES;

	/**
	 * The number of structural features of the '<em>Double Std Lib</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_STD_LIB_FEATURE_COUNT = OCL_ANY_STD_LIB_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.OCL.StdLibrary.impl.LongStdLibImpl <em>Long Std Lib</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.OCL.StdLibrary.impl.LongStdLibImpl
	 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getLongStdLib()
	 * @generated
	 */
	int LONG_STD_LIB = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_STD_LIB__NAME = OCL_ANY_STD_LIB__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_STD_LIB__QUALIFIED_NAME = OCL_ANY_STD_LIB__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_STD_LIB__ANNOTATION = OCL_ANY_STD_LIB__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Required Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_STD_LIB__REQUIRED_ELEMENTS = OCL_ANY_STD_LIB__REQUIRED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_STD_LIB__CONTAINER = OCL_ANY_STD_LIB__CONTAINER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_STD_LIB__CONSTRAINTS = OCL_ANY_STD_LIB__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_STD_LIB__CONTENTS = OCL_ANY_STD_LIB__CONTENTS;

	/**
	 * The feature id for the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_STD_LIB__IS_ROOT = OCL_ANY_STD_LIB__IS_ROOT;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_STD_LIB__IS_LEAF = OCL_ANY_STD_LIB__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_STD_LIB__IS_ABSTRACT = OCL_ANY_STD_LIB__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_STD_LIB__VISIBILITY = OCL_ANY_STD_LIB__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_STD_LIB__SUPERTYPES = OCL_ANY_STD_LIB__SUPERTYPES;

	/**
	 * The number of structural features of the '<em>Long Std Lib</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_STD_LIB_FEATURE_COUNT = OCL_ANY_STD_LIB_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.OCL.StdLibrary.impl.OclInvalidStdLibImpl <em>Ocl Invalid Std Lib</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.OCL.StdLibrary.impl.OclInvalidStdLibImpl
	 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getOclInvalidStdLib()
	 * @generated
	 */
	int OCL_INVALID_STD_LIB = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_INVALID_STD_LIB__NAME = OCL_ANY_STD_LIB__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_INVALID_STD_LIB__QUALIFIED_NAME = OCL_ANY_STD_LIB__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_INVALID_STD_LIB__ANNOTATION = OCL_ANY_STD_LIB__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Required Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_INVALID_STD_LIB__REQUIRED_ELEMENTS = OCL_ANY_STD_LIB__REQUIRED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_INVALID_STD_LIB__CONTAINER = OCL_ANY_STD_LIB__CONTAINER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_INVALID_STD_LIB__CONSTRAINTS = OCL_ANY_STD_LIB__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_INVALID_STD_LIB__CONTENTS = OCL_ANY_STD_LIB__CONTENTS;

	/**
	 * The feature id for the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_INVALID_STD_LIB__IS_ROOT = OCL_ANY_STD_LIB__IS_ROOT;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_INVALID_STD_LIB__IS_LEAF = OCL_ANY_STD_LIB__IS_LEAF;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_INVALID_STD_LIB__IS_ABSTRACT = OCL_ANY_STD_LIB__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_INVALID_STD_LIB__VISIBILITY = OCL_ANY_STD_LIB__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_INVALID_STD_LIB__SUPERTYPES = OCL_ANY_STD_LIB__SUPERTYPES;

	/**
	 * The number of structural features of the '<em>Ocl Invalid Std Lib</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_INVALID_STD_LIB_FEATURE_COUNT = OCL_ANY_STD_LIB_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.omg.OCL.StdLibrary.OclAnyStdLib <em>Ocl Any Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Any Std Lib</em>'.
	 * @see org.omg.OCL.StdLibrary.OclAnyStdLib
	 * @generated
	 */
	EClass getOclAnyStdLib();

	/**
	 * Returns the meta object for class '{@link org.omg.OCL.StdLibrary.StringStdLib <em>String Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Std Lib</em>'.
	 * @see org.omg.OCL.StdLibrary.StringStdLib
	 * @generated
	 */
	EClass getStringStdLib();

	/**
	 * Returns the meta object for class '{@link org.omg.OCL.StdLibrary.BooleanStdLib <em>Boolean Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Std Lib</em>'.
	 * @see org.omg.OCL.StdLibrary.BooleanStdLib
	 * @generated
	 */
	EClass getBooleanStdLib();

	/**
	 * Returns the meta object for class '{@link org.omg.OCL.StdLibrary.FloatStdLib <em>Float Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Float Std Lib</em>'.
	 * @see org.omg.OCL.StdLibrary.FloatStdLib
	 * @generated
	 */
	EClass getFloatStdLib();

	/**
	 * Returns the meta object for class '{@link org.omg.OCL.StdLibrary.CollectionTypeStdLib <em>Collection Type Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Type Std Lib</em>'.
	 * @see org.omg.OCL.StdLibrary.CollectionTypeStdLib
	 * @generated
	 */
	EClass getCollectionTypeStdLib();

	/**
	 * Returns the meta object for class '{@link org.omg.OCL.StdLibrary.SetTypeStdLib <em>Set Type Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Type Std Lib</em>'.
	 * @see org.omg.OCL.StdLibrary.SetTypeStdLib
	 * @generated
	 */
	EClass getSetTypeStdLib();

	/**
	 * Returns the meta object for class '{@link org.omg.OCL.StdLibrary.SequenceTypeStdLib <em>Sequence Type Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Type Std Lib</em>'.
	 * @see org.omg.OCL.StdLibrary.SequenceTypeStdLib
	 * @generated
	 */
	EClass getSequenceTypeStdLib();

	/**
	 * Returns the meta object for class '{@link org.omg.OCL.StdLibrary.BagTypeStdLib <em>Bag Type Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bag Type Std Lib</em>'.
	 * @see org.omg.OCL.StdLibrary.BagTypeStdLib
	 * @generated
	 */
	EClass getBagTypeStdLib();

	/**
	 * Returns the meta object for class '{@link org.omg.OCL.StdLibrary.OrderedSetTypeStdLib <em>Ordered Set Type Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordered Set Type Std Lib</em>'.
	 * @see org.omg.OCL.StdLibrary.OrderedSetTypeStdLib
	 * @generated
	 */
	EClass getOrderedSetTypeStdLib();

	/**
	 * Returns the meta object for class '{@link org.omg.OCL.StdLibrary.OclVoidStdLib <em>Ocl Void Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Void Std Lib</em>'.
	 * @see org.omg.OCL.StdLibrary.OclVoidStdLib
	 * @generated
	 */
	EClass getOclVoidStdLib();

	/**
	 * Returns the meta object for class '{@link org.omg.OCL.StdLibrary.IntegerStdLib <em>Integer Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Std Lib</em>'.
	 * @see org.omg.OCL.StdLibrary.IntegerStdLib
	 * @generated
	 */
	EClass getIntegerStdLib();

	/**
	 * Returns the meta object for class '{@link org.omg.OCL.StdLibrary.OclTypeStdLib <em>Ocl Type Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Type Std Lib</em>'.
	 * @see org.omg.OCL.StdLibrary.OclTypeStdLib
	 * @generated
	 */
	EClass getOclTypeStdLib();

	/**
	 * Returns the meta object for class '{@link org.omg.OCL.StdLibrary.TupleTypeStdLib <em>Tuple Type Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Type Std Lib</em>'.
	 * @see org.omg.OCL.StdLibrary.TupleTypeStdLib
	 * @generated
	 */
	EClass getTupleTypeStdLib();

	/**
	 * Returns the meta object for class '{@link org.omg.OCL.StdLibrary.DoubleStdLib <em>Double Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Std Lib</em>'.
	 * @see org.omg.OCL.StdLibrary.DoubleStdLib
	 * @generated
	 */
	EClass getDoubleStdLib();

	/**
	 * Returns the meta object for class '{@link org.omg.OCL.StdLibrary.LongStdLib <em>Long Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Long Std Lib</em>'.
	 * @see org.omg.OCL.StdLibrary.LongStdLib
	 * @generated
	 */
	EClass getLongStdLib();

	/**
	 * Returns the meta object for class '{@link org.omg.OCL.StdLibrary.OclInvalidStdLib <em>Ocl Invalid Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Invalid Std Lib</em>'.
	 * @see org.omg.OCL.StdLibrary.OclInvalidStdLib
	 * @generated
	 */
	EClass getOclInvalidStdLib();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StdLibraryFactory getStdLibraryFactory();

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
		 * The meta object literal for the '{@link org.omg.OCL.StdLibrary.impl.OclAnyStdLibImpl <em>Ocl Any Std Lib</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.OCL.StdLibrary.impl.OclAnyStdLibImpl
		 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getOclAnyStdLib()
		 * @generated
		 */
		EClass OCL_ANY_STD_LIB = eINSTANCE.getOclAnyStdLib();

		/**
		 * The meta object literal for the '{@link org.omg.OCL.StdLibrary.impl.StringStdLibImpl <em>String Std Lib</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.OCL.StdLibrary.impl.StringStdLibImpl
		 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getStringStdLib()
		 * @generated
		 */
		EClass STRING_STD_LIB = eINSTANCE.getStringStdLib();

		/**
		 * The meta object literal for the '{@link org.omg.OCL.StdLibrary.impl.BooleanStdLibImpl <em>Boolean Std Lib</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.OCL.StdLibrary.impl.BooleanStdLibImpl
		 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getBooleanStdLib()
		 * @generated
		 */
		EClass BOOLEAN_STD_LIB = eINSTANCE.getBooleanStdLib();

		/**
		 * The meta object literal for the '{@link org.omg.OCL.StdLibrary.impl.FloatStdLibImpl <em>Float Std Lib</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.OCL.StdLibrary.impl.FloatStdLibImpl
		 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getFloatStdLib()
		 * @generated
		 */
		EClass FLOAT_STD_LIB = eINSTANCE.getFloatStdLib();

		/**
		 * The meta object literal for the '{@link org.omg.OCL.StdLibrary.impl.CollectionTypeStdLibImpl <em>Collection Type Std Lib</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.OCL.StdLibrary.impl.CollectionTypeStdLibImpl
		 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getCollectionTypeStdLib()
		 * @generated
		 */
		EClass COLLECTION_TYPE_STD_LIB = eINSTANCE.getCollectionTypeStdLib();

		/**
		 * The meta object literal for the '{@link org.omg.OCL.StdLibrary.impl.SetTypeStdLibImpl <em>Set Type Std Lib</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.OCL.StdLibrary.impl.SetTypeStdLibImpl
		 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getSetTypeStdLib()
		 * @generated
		 */
		EClass SET_TYPE_STD_LIB = eINSTANCE.getSetTypeStdLib();

		/**
		 * The meta object literal for the '{@link org.omg.OCL.StdLibrary.impl.SequenceTypeStdLibImpl <em>Sequence Type Std Lib</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.OCL.StdLibrary.impl.SequenceTypeStdLibImpl
		 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getSequenceTypeStdLib()
		 * @generated
		 */
		EClass SEQUENCE_TYPE_STD_LIB = eINSTANCE.getSequenceTypeStdLib();

		/**
		 * The meta object literal for the '{@link org.omg.OCL.StdLibrary.impl.BagTypeStdLibImpl <em>Bag Type Std Lib</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.OCL.StdLibrary.impl.BagTypeStdLibImpl
		 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getBagTypeStdLib()
		 * @generated
		 */
		EClass BAG_TYPE_STD_LIB = eINSTANCE.getBagTypeStdLib();

		/**
		 * The meta object literal for the '{@link org.omg.OCL.StdLibrary.impl.OrderedSetTypeStdLibImpl <em>Ordered Set Type Std Lib</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.OCL.StdLibrary.impl.OrderedSetTypeStdLibImpl
		 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getOrderedSetTypeStdLib()
		 * @generated
		 */
		EClass ORDERED_SET_TYPE_STD_LIB = eINSTANCE.getOrderedSetTypeStdLib();

		/**
		 * The meta object literal for the '{@link org.omg.OCL.StdLibrary.impl.OclVoidStdLibImpl <em>Ocl Void Std Lib</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.OCL.StdLibrary.impl.OclVoidStdLibImpl
		 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getOclVoidStdLib()
		 * @generated
		 */
		EClass OCL_VOID_STD_LIB = eINSTANCE.getOclVoidStdLib();

		/**
		 * The meta object literal for the '{@link org.omg.OCL.StdLibrary.impl.IntegerStdLibImpl <em>Integer Std Lib</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.OCL.StdLibrary.impl.IntegerStdLibImpl
		 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getIntegerStdLib()
		 * @generated
		 */
		EClass INTEGER_STD_LIB = eINSTANCE.getIntegerStdLib();

		/**
		 * The meta object literal for the '{@link org.omg.OCL.StdLibrary.impl.OclTypeStdLibImpl <em>Ocl Type Std Lib</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.OCL.StdLibrary.impl.OclTypeStdLibImpl
		 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getOclTypeStdLib()
		 * @generated
		 */
		EClass OCL_TYPE_STD_LIB = eINSTANCE.getOclTypeStdLib();

		/**
		 * The meta object literal for the '{@link org.omg.OCL.StdLibrary.impl.TupleTypeStdLibImpl <em>Tuple Type Std Lib</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.OCL.StdLibrary.impl.TupleTypeStdLibImpl
		 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getTupleTypeStdLib()
		 * @generated
		 */
		EClass TUPLE_TYPE_STD_LIB = eINSTANCE.getTupleTypeStdLib();

		/**
		 * The meta object literal for the '{@link org.omg.OCL.StdLibrary.impl.DoubleStdLibImpl <em>Double Std Lib</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.OCL.StdLibrary.impl.DoubleStdLibImpl
		 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getDoubleStdLib()
		 * @generated
		 */
		EClass DOUBLE_STD_LIB = eINSTANCE.getDoubleStdLib();

		/**
		 * The meta object literal for the '{@link org.omg.OCL.StdLibrary.impl.LongStdLibImpl <em>Long Std Lib</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.OCL.StdLibrary.impl.LongStdLibImpl
		 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getLongStdLib()
		 * @generated
		 */
		EClass LONG_STD_LIB = eINSTANCE.getLongStdLib();

		/**
		 * The meta object literal for the '{@link org.omg.OCL.StdLibrary.impl.OclInvalidStdLibImpl <em>Ocl Invalid Std Lib</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.OCL.StdLibrary.impl.OclInvalidStdLibImpl
		 * @see org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl#getOclInvalidStdLib()
		 * @generated
		 */
		EClass OCL_INVALID_STD_LIB = eINSTANCE.getOclInvalidStdLib();

	}

} //StdLibraryPackage
