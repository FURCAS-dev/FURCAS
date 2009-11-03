/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.oslo.ocl20.semantics.SemanticsFactory
 * @model kind="package"
 * @generated
 */
public interface SemanticsPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "semantics";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "urn:semantics.ecore";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "semantics";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	SemanticsPackage eINSTANCE = org.oslo.ocl20.semantics.impl.SemanticsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.impl.SemanticsVisitableImpl
	 * <em>Visitable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.impl.SemanticsVisitableImpl
	 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getSemanticsVisitable()
	 * @generated
	 */
	int SEMANTICS_VISITABLE = 0;

	/**
	 * The number of structural features of the '<em>Visitable</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTICS_VISITABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.impl.SemanticsVisitorImpl
	 * <em>Visitor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.impl.SemanticsVisitorImpl
	 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getSemanticsVisitor()
	 * @generated
	 */
	int SEMANTICS_VISITOR = 1;

	/**
	 * The number of structural features of the '<em>Visitor</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTICS_VISITOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.impl.OclVisitorImpl
	 * <em>Ocl Visitor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.impl.OclVisitorImpl
	 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getOclVisitor()
	 * @generated
	 */
	int OCL_VISITOR = 2;

	/**
	 * The number of structural features of the '<em>Ocl Visitor</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_VISITOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '<em>Boolean</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see java.lang.Boolean
	 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getBoolean()
	 * @generated
	 */
	int BOOLEAN = 3;

	/**
	 * The meta object id for the '<em>Bridge Factory</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.factories.BridgeFactory
	 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getBridgeFactory()
	 * @generated
	 */
	int BRIDGE_FACTORY = 4;

	/**
	 * The meta object id for the '<em>Class</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see java.lang.Class
	 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 5;

	/**
	 * The meta object id for the '<em>Integer</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see java.lang.Integer
	 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getInteger()
	 * @generated
	 */
	int INTEGER = 6;

	/**
	 * The meta object id for the '<em>List</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see java.util.List
	 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getList()
	 * @generated
	 */
	int LIST = 7;

	/**
	 * The meta object id for the '<em>Map</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see java.util.Map
	 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getMap()
	 * @generated
	 */
	int MAP = 8;

	/**
	 * The meta object id for the '<em>Object</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see java.lang.Object
	 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getObject()
	 * @generated
	 */
	int OBJECT = 9;

	/**
	 * The meta object id for the '<em>Ocl Processor</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.OclProcessor
	 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getOclProcessor()
	 * @generated
	 */
	int OCL_PROCESSOR = 10;

	/**
	 * The meta object id for the '<em>Real</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see java.lang.Double
	 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getReal()
	 * @generated
	 */
	int REAL = 11;

	/**
	 * The meta object id for the '<em>Set</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see java.util.Set
	 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getSet()
	 * @generated
	 */
	int SET = 12;

	/**
	 * The meta object id for the '<em>Type Factory</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.factories.TypeFactory
	 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getTypeFactory()
	 * @generated
	 */
	int TYPE_FACTORY = 13;

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.SemanticsVisitable
	 * <em>Visitable</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Visitable</em>'.
	 * @see org.oslo.ocl20.semantics.SemanticsVisitable
	 * @generated
	 */
	EClass getSemanticsVisitable();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.SemanticsVisitor
	 * <em>Visitor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Visitor</em>'.
	 * @see org.oslo.ocl20.semantics.SemanticsVisitor
	 * @generated
	 */
	EClass getSemanticsVisitor();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.OclVisitor
	 * <em>Ocl Visitor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Ocl Visitor</em>'.
	 * @see org.oslo.ocl20.semantics.OclVisitor
	 * @generated
	 */
	EClass getOclVisitor();

	/**
	 * Returns the meta object for data type '{@link java.lang.Boolean <em>Boolean</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Boolean</em>'.
	 * @see java.lang.Boolean
	 * @model instanceClass="java.lang.Boolean" serializeable="false"
	 *        annotation="instance instance='java.lang.Boolean'"
	 * @generated
	 */
	EDataType getBoolean();

	/**
	 * Returns the meta object for data type '
	 * {@link org.oslo.ocl20.semantics.factories.BridgeFactory <em>Bridge Factory</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Bridge Factory</em>'.
	 * @see org.oslo.ocl20.semantics.factories.BridgeFactory
	 * @model instanceClass="org.oslo.ocl20.semantics.factories.BridgeFactory" serializeable="false"
	 *        annotation="instance instance='org.oslo.ocl20.semantics.factories.BridgeFactory'"
	 * @generated
	 */
	EDataType getBridgeFactory();

	/**
	 * Returns the meta object for data type '{@link java.lang.Class <em>Class</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Class</em>'.
	 * @see java.lang.Class
	 * @model instanceClass="java.lang.Class" serializeable="false"
	 *        annotation="instance instance='java.lang.Class'"
	 * @generated
	 */
	EDataType getClass_();

	/**
	 * Returns the meta object for data type '{@link java.lang.Integer <em>Integer</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Integer</em>'.
	 * @see java.lang.Integer
	 * @model instanceClass="java.lang.Integer" serializeable="false"
	 *        annotation="instance instance='java.lang.Integer'"
	 * @generated
	 */
	EDataType getInteger();

	/**
	 * Returns the meta object for data type '{@link java.util.List <em>List</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>List</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List" serializeable="false"
	 *        annotation="instance instance='java.util.List'"
	 * @generated
	 */
	EDataType getList();

	/**
	 * Returns the meta object for data type '{@link java.util.Map <em>Map</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Map</em>'.
	 * @see java.util.Map
	 * @model instanceClass="java.util.Map" serializeable="false"
	 *        annotation="instance instance='java.util.Map'"
	 * @generated
	 */
	EDataType getMap();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Object</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Object</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object" serializeable="false"
	 * @generated
	 */
	EDataType getObject();

	/**
	 * Returns the meta object for data type '{@link org.oslo.ocl20.OclProcessor
	 * <em>Ocl Processor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Ocl Processor</em>'.
	 * @see org.oslo.ocl20.OclProcessor
	 * @model instanceClass="org.oslo.ocl20.OclProcessor" serializeable="false"
	 *        annotation="instance instance='org.oslo.ocl20.OclProcessor'"
	 * @generated
	 */
	EDataType getOclProcessor();

	/**
	 * Returns the meta object for data type '{@link java.lang.Double <em>Real</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Real</em>'.
	 * @see java.lang.Double
	 * @model instanceClass="java.lang.Double" serializeable="false"
	 *        annotation="instance instance='java.lang.Double'"
	 * @generated
	 */
	EDataType getReal();

	/**
	 * Returns the meta object for data type '{@link java.util.Set <em>Set</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Set</em>'.
	 * @see java.util.Set
	 * @model instanceClass="java.util.Set" serializeable="false"
	 *        annotation="instance instance='java.util.Set'"
	 * @generated
	 */
	EDataType getSet();

	/**
	 * Returns the meta object for data type '{@link org.oslo.ocl20.semantics.factories.TypeFactory
	 * <em>Type Factory</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Type Factory</em>'.
	 * @see org.oslo.ocl20.semantics.factories.TypeFactory
	 * @model instanceClass="org.oslo.ocl20.semantics.factories.TypeFactory" serializeable="false"
	 *        annotation="instance instance='org.oslo.ocl20.semantics.factories.TypeFactory'"
	 * @generated
	 */
	EDataType getTypeFactory();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SemanticsFactory getSemanticsFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.impl.SemanticsVisitableImpl <em>Visitable</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.impl.SemanticsVisitableImpl
		 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getSemanticsVisitable()
		 * @generated
		 */
		EClass SEMANTICS_VISITABLE = eINSTANCE.getSemanticsVisitable();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.impl.SemanticsVisitorImpl <em>Visitor</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.impl.SemanticsVisitorImpl
		 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getSemanticsVisitor()
		 * @generated
		 */
		EClass SEMANTICS_VISITOR = eINSTANCE.getSemanticsVisitor();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.semantics.impl.OclVisitorImpl
		 * <em>Ocl Visitor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.impl.OclVisitorImpl
		 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getOclVisitor()
		 * @generated
		 */
		EClass OCL_VISITOR = eINSTANCE.getOclVisitor();

		/**
		 * The meta object literal for the '<em>Boolean</em>' data type. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see java.lang.Boolean
		 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getBoolean()
		 * @generated
		 */
		EDataType BOOLEAN = eINSTANCE.getBoolean();

		/**
		 * The meta object literal for the '<em>Bridge Factory</em>' data type. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.factories.BridgeFactory
		 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getBridgeFactory()
		 * @generated
		 */
		EDataType BRIDGE_FACTORY = eINSTANCE.getBridgeFactory();

		/**
		 * The meta object literal for the '<em>Class</em>' data type. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see java.lang.Class
		 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getClass_()
		 * @generated
		 */
		EDataType CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em>Integer</em>' data type. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see java.lang.Integer
		 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getInteger()
		 * @generated
		 */
		EDataType INTEGER = eINSTANCE.getInteger();

		/**
		 * The meta object literal for the '<em>List</em>' data type. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see java.util.List
		 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getList()
		 * @generated
		 */
		EDataType LIST = eINSTANCE.getList();

		/**
		 * The meta object literal for the '<em>Map</em>' data type. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see java.util.Map
		 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getMap()
		 * @generated
		 */
		EDataType MAP = eINSTANCE.getMap();

		/**
		 * The meta object literal for the '<em>Object</em>' data type. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see java.lang.Object
		 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getObject()
		 * @generated
		 */
		EDataType OBJECT = eINSTANCE.getObject();

		/**
		 * The meta object literal for the '<em>Ocl Processor</em>' data type. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.OclProcessor
		 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getOclProcessor()
		 * @generated
		 */
		EDataType OCL_PROCESSOR = eINSTANCE.getOclProcessor();

		/**
		 * The meta object literal for the '<em>Real</em>' data type. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see java.lang.Double
		 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getReal()
		 * @generated
		 */
		EDataType REAL = eINSTANCE.getReal();

		/**
		 * The meta object literal for the '<em>Set</em>' data type. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see java.util.Set
		 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getSet()
		 * @generated
		 */
		EDataType SET = eINSTANCE.getSet();

		/**
		 * The meta object literal for the '<em>Type Factory</em>' data type. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.factories.TypeFactory
		 * @see org.oslo.ocl20.semantics.impl.SemanticsPackageImpl#getTypeFactory()
		 * @generated
		 */
		EDataType TYPE_FACTORY = eINSTANCE.getTypeFactory();

	}

} // SemanticsPackage
