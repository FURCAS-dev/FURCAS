/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package persistence.expressions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see persistence.expressions.ExpressionsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://de.hpi.sam.bp2009.OCL' validationDelegates='http://de.hpi.sam.bp2009.OCL'"
 * @generated
 */
public interface ExpressionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "expressions";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///persistence/expressions.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "persistence.expressions";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionsPackage eINSTANCE = persistence.expressions.impl.ExpressionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link persistence.expressions.impl.AllImpl <em>All</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see persistence.expressions.impl.AllImpl
	 * @see persistence.expressions.impl.ExpressionsPackageImpl#getAll()
	 * @generated
	 */
	int ALL = 0;

	/**
	 * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL__OWNED_TYPE_DEFINITION = dataaccess.expressions.ExpressionsPackage.EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
	 * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL__EXPRESSION_STATEMENT = dataaccess.expressions.ExpressionsPackage.EXPRESSION__EXPRESSION_STATEMENT;

	/**
	 * The feature id for the '<em><b>In Iterator</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL__IN_ITERATOR = dataaccess.expressions.ExpressionsPackage.EXPRESSION__IN_ITERATOR;

	/**
	 * The feature id for the '<em><b>From Clause</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL__FROM_CLAUSE = dataaccess.expressions.ExpressionsPackage.EXPRESSION__FROM_CLAUSE;

	/**
	 * The feature id for the '<em><b>Template</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL__TEMPLATE = dataaccess.expressions.ExpressionsPackage.EXPRESSION__TEMPLATE;

	/**
	 * The feature id for the '<em><b>Snapshot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL__SNAPSHOT = dataaccess.expressions.ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Of Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL__OF_CLASS = dataaccess.expressions.ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Snapshot Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL__SNAPSHOT_IDENTIFIER = dataaccess.expressions.ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>All</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_FEATURE_COUNT = dataaccess.expressions.ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link persistence.expressions.impl.CommitImpl <em>Commit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see persistence.expressions.impl.CommitImpl
	 * @see persistence.expressions.impl.ExpressionsPackageImpl#getCommit()
	 * @generated
	 */
	int COMMIT = 1;

	/**
	 * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMIT__OWNED_TYPE_DEFINITION = dataaccess.expressions.ExpressionsPackage.EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
	 * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMIT__EXPRESSION_STATEMENT = dataaccess.expressions.ExpressionsPackage.EXPRESSION__EXPRESSION_STATEMENT;

	/**
	 * The feature id for the '<em><b>In Iterator</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMIT__IN_ITERATOR = dataaccess.expressions.ExpressionsPackage.EXPRESSION__IN_ITERATOR;

	/**
	 * The feature id for the '<em><b>From Clause</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMIT__FROM_CLAUSE = dataaccess.expressions.ExpressionsPackage.EXPRESSION__FROM_CLAUSE;

	/**
	 * The feature id for the '<em><b>Template</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMIT__TEMPLATE = dataaccess.expressions.ExpressionsPackage.EXPRESSION__TEMPLATE;

	/**
	 * The number of structural features of the '<em>Commit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMIT_FEATURE_COUNT = dataaccess.expressions.ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link persistence.expressions.impl.SnapshotImpl <em>Snapshot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see persistence.expressions.impl.SnapshotImpl
	 * @see persistence.expressions.impl.ExpressionsPackageImpl#getSnapshot()
	 * @generated
	 */
	int SNAPSHOT = 2;

	/**
	 * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__OWNED_TYPE_DEFINITION = dataaccess.expressions.ExpressionsPackage.OBJECT_BASED_EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
	 * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__EXPRESSION_STATEMENT = dataaccess.expressions.ExpressionsPackage.OBJECT_BASED_EXPRESSION__EXPRESSION_STATEMENT;

	/**
	 * The feature id for the '<em><b>In Iterator</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__IN_ITERATOR = dataaccess.expressions.ExpressionsPackage.OBJECT_BASED_EXPRESSION__IN_ITERATOR;

	/**
	 * The feature id for the '<em><b>From Clause</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__FROM_CLAUSE = dataaccess.expressions.ExpressionsPackage.OBJECT_BASED_EXPRESSION__FROM_CLAUSE;

	/**
	 * The feature id for the '<em><b>Template</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__TEMPLATE = dataaccess.expressions.ExpressionsPackage.OBJECT_BASED_EXPRESSION__TEMPLATE;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__OBJECT = dataaccess.expressions.ExpressionsPackage.OBJECT_BASED_EXPRESSION__OBJECT;

	/**
	 * The number of structural features of the '<em>Snapshot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_FEATURE_COUNT = dataaccess.expressions.ExpressionsPackage.OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link persistence.expressions.SnapshotSelection <em>Snapshot Selection</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see persistence.expressions.SnapshotSelection
	 * @see persistence.expressions.impl.ExpressionsPackageImpl#getSnapshotSelection()
	 * @generated
	 */
	int SNAPSHOT_SELECTION = 3;


	/**
	 * Returns the meta object for class '{@link persistence.expressions.All <em>All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>All</em>'.
	 * @see persistence.expressions.All
	 * @generated
	 */
	EClass getAll();

	/**
	 * Returns the meta object for the attribute '{@link persistence.expressions.All#getSnapshot <em>Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snapshot</em>'.
	 * @see persistence.expressions.All#getSnapshot()
	 * @see #getAll()
	 * @generated
	 */
	EAttribute getAll_Snapshot();

	/**
	 * Returns the meta object for the reference '{@link persistence.expressions.All#getOfClass <em>Of Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Of Class</em>'.
	 * @see persistence.expressions.All#getOfClass()
	 * @see #getAll()
	 * @generated
	 */
	EReference getAll_OfClass();

	/**
	 * Returns the meta object for the containment reference '{@link persistence.expressions.All#getSnapshotIdentifier <em>Snapshot Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Snapshot Identifier</em>'.
	 * @see persistence.expressions.All#getSnapshotIdentifier()
	 * @see #getAll()
	 * @generated
	 */
	EReference getAll_SnapshotIdentifier();

	/**
	 * Returns the meta object for class '{@link persistence.expressions.Commit <em>Commit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Commit</em>'.
	 * @see persistence.expressions.Commit
	 * @generated
	 */
	EClass getCommit();

	/**
	 * Returns the meta object for class '{@link persistence.expressions.Snapshot <em>Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Snapshot</em>'.
	 * @see persistence.expressions.Snapshot
	 * @generated
	 */
	EClass getSnapshot();

	/**
	 * Returns the meta object for enum '{@link persistence.expressions.SnapshotSelection <em>Snapshot Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Snapshot Selection</em>'.
	 * @see persistence.expressions.SnapshotSelection
	 * @generated
	 */
	EEnum getSnapshotSelection();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExpressionsFactory getExpressionsFactory();

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
		 * The meta object literal for the '{@link persistence.expressions.impl.AllImpl <em>All</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see persistence.expressions.impl.AllImpl
		 * @see persistence.expressions.impl.ExpressionsPackageImpl#getAll()
		 * @generated
		 */
		EClass ALL = eINSTANCE.getAll();

		/**
		 * The meta object literal for the '<em><b>Snapshot</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALL__SNAPSHOT = eINSTANCE.getAll_Snapshot();

		/**
		 * The meta object literal for the '<em><b>Of Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALL__OF_CLASS = eINSTANCE.getAll_OfClass();

		/**
		 * The meta object literal for the '<em><b>Snapshot Identifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALL__SNAPSHOT_IDENTIFIER = eINSTANCE.getAll_SnapshotIdentifier();

		/**
		 * The meta object literal for the '{@link persistence.expressions.impl.CommitImpl <em>Commit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see persistence.expressions.impl.CommitImpl
		 * @see persistence.expressions.impl.ExpressionsPackageImpl#getCommit()
		 * @generated
		 */
		EClass COMMIT = eINSTANCE.getCommit();

		/**
		 * The meta object literal for the '{@link persistence.expressions.impl.SnapshotImpl <em>Snapshot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see persistence.expressions.impl.SnapshotImpl
		 * @see persistence.expressions.impl.ExpressionsPackageImpl#getSnapshot()
		 * @generated
		 */
		EClass SNAPSHOT = eINSTANCE.getSnapshot();

		/**
		 * The meta object literal for the '{@link persistence.expressions.SnapshotSelection <em>Snapshot Selection</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see persistence.expressions.SnapshotSelection
		 * @see persistence.expressions.impl.ExpressionsPackageImpl#getSnapshotSelection()
		 * @generated
		 */
		EEnum SNAPSHOT_SELECTION = eINSTANCE.getSnapshotSelection();

	}

} //ExpressionsPackage
