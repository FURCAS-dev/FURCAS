/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.collectionexpressions;

import dataaccess.expressions.ExpressionsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see dataaccess.expressions.collectionexpressions.CollectionexpressionsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://de.hpi.sam.bp2009.OCL' validationDelegates='http://de.hpi.sam.bp2009.OCL'"
 * @generated
 */
public interface CollectionexpressionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "collectionexpressions";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///dataaccess/expressions/collectionexpressions.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dataaccess.expressions.collectionexpressions";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CollectionexpressionsPackage eINSTANCE = dataaccess.expressions.collectionexpressions.impl.CollectionexpressionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link dataaccess.expressions.collectionexpressions.impl.CollectionExpressionImpl <em>Collection Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataaccess.expressions.collectionexpressions.impl.CollectionExpressionImpl
	 * @see dataaccess.expressions.collectionexpressions.impl.CollectionexpressionsPackageImpl#getCollectionExpression()
	 * @generated
	 */
	int COLLECTION_EXPRESSION = 4;

	/**
	 * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION__OWNED_TYPE_DEFINITION = ExpressionsPackage.EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
	 * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION__EXPRESSION_STATEMENT = ExpressionsPackage.EXPRESSION__EXPRESSION_STATEMENT;

	/**
	 * The feature id for the '<em><b>In Iterator</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION__IN_ITERATOR = ExpressionsPackage.EXPRESSION__IN_ITERATOR;

	/**
	 * The feature id for the '<em><b>From Clause</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION__FROM_CLAUSE = ExpressionsPackage.EXPRESSION__FROM_CLAUSE;

	/**
	 * The feature id for the '<em><b>Template</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION__TEMPLATE = ExpressionsPackage.EXPRESSION__TEMPLATE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION__SOURCE = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION_FEATURE_COUNT = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dataaccess.expressions.collectionexpressions.impl.CollectionExpressionWithArgumentImpl <em>Collection Expression With Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataaccess.expressions.collectionexpressions.impl.CollectionExpressionWithArgumentImpl
	 * @see dataaccess.expressions.collectionexpressions.impl.CollectionexpressionsPackageImpl#getCollectionExpressionWithArgument()
	 * @generated
	 */
	int COLLECTION_EXPRESSION_WITH_ARGUMENT = 7;

	/**
	 * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION_WITH_ARGUMENT__OWNED_TYPE_DEFINITION = COLLECTION_EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
	 * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION_WITH_ARGUMENT__EXPRESSION_STATEMENT = COLLECTION_EXPRESSION__EXPRESSION_STATEMENT;

	/**
	 * The feature id for the '<em><b>In Iterator</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION_WITH_ARGUMENT__IN_ITERATOR = COLLECTION_EXPRESSION__IN_ITERATOR;

	/**
	 * The feature id for the '<em><b>From Clause</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION_WITH_ARGUMENT__FROM_CLAUSE = COLLECTION_EXPRESSION__FROM_CLAUSE;

	/**
	 * The feature id for the '<em><b>Template</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION_WITH_ARGUMENT__TEMPLATE = COLLECTION_EXPRESSION__TEMPLATE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION_WITH_ARGUMENT__SOURCE = COLLECTION_EXPRESSION__SOURCE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION_WITH_ARGUMENT__ARGUMENT = COLLECTION_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Expression With Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION_WITH_ARGUMENT_FEATURE_COUNT = COLLECTION_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dataaccess.expressions.collectionexpressions.impl.IncludingImpl <em>Including</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataaccess.expressions.collectionexpressions.impl.IncludingImpl
	 * @see dataaccess.expressions.collectionexpressions.impl.CollectionexpressionsPackageImpl#getIncluding()
	 * @generated
	 */
	int INCLUDING = 0;

	/**
	 * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDING__OWNED_TYPE_DEFINITION = COLLECTION_EXPRESSION_WITH_ARGUMENT__OWNED_TYPE_DEFINITION;

	/**
	 * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDING__EXPRESSION_STATEMENT = COLLECTION_EXPRESSION_WITH_ARGUMENT__EXPRESSION_STATEMENT;

	/**
	 * The feature id for the '<em><b>In Iterator</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDING__IN_ITERATOR = COLLECTION_EXPRESSION_WITH_ARGUMENT__IN_ITERATOR;

	/**
	 * The feature id for the '<em><b>From Clause</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDING__FROM_CLAUSE = COLLECTION_EXPRESSION_WITH_ARGUMENT__FROM_CLAUSE;

	/**
	 * The feature id for the '<em><b>Template</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDING__TEMPLATE = COLLECTION_EXPRESSION_WITH_ARGUMENT__TEMPLATE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDING__SOURCE = COLLECTION_EXPRESSION_WITH_ARGUMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDING__ARGUMENT = COLLECTION_EXPRESSION_WITH_ARGUMENT__ARGUMENT;

	/**
	 * The number of structural features of the '<em>Including</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDING_FEATURE_COUNT = COLLECTION_EXPRESSION_WITH_ARGUMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dataaccess.expressions.collectionexpressions.impl.ExcludingImpl <em>Excluding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataaccess.expressions.collectionexpressions.impl.ExcludingImpl
	 * @see dataaccess.expressions.collectionexpressions.impl.CollectionexpressionsPackageImpl#getExcluding()
	 * @generated
	 */
	int EXCLUDING = 1;

	/**
	 * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDING__OWNED_TYPE_DEFINITION = COLLECTION_EXPRESSION_WITH_ARGUMENT__OWNED_TYPE_DEFINITION;

	/**
	 * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDING__EXPRESSION_STATEMENT = COLLECTION_EXPRESSION_WITH_ARGUMENT__EXPRESSION_STATEMENT;

	/**
	 * The feature id for the '<em><b>In Iterator</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDING__IN_ITERATOR = COLLECTION_EXPRESSION_WITH_ARGUMENT__IN_ITERATOR;

	/**
	 * The feature id for the '<em><b>From Clause</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDING__FROM_CLAUSE = COLLECTION_EXPRESSION_WITH_ARGUMENT__FROM_CLAUSE;

	/**
	 * The feature id for the '<em><b>Template</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDING__TEMPLATE = COLLECTION_EXPRESSION_WITH_ARGUMENT__TEMPLATE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDING__SOURCE = COLLECTION_EXPRESSION_WITH_ARGUMENT__SOURCE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDING__ARGUMENT = COLLECTION_EXPRESSION_WITH_ARGUMENT__ARGUMENT;

	/**
	 * The number of structural features of the '<em>Excluding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDING_FEATURE_COUNT = COLLECTION_EXPRESSION_WITH_ARGUMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dataaccess.expressions.collectionexpressions.impl.IncludingAtImpl <em>Including At</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataaccess.expressions.collectionexpressions.impl.IncludingAtImpl
	 * @see dataaccess.expressions.collectionexpressions.impl.CollectionexpressionsPackageImpl#getIncludingAt()
	 * @generated
	 */
	int INCLUDING_AT = 2;

	/**
	 * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDING_AT__OWNED_TYPE_DEFINITION = INCLUDING__OWNED_TYPE_DEFINITION;

	/**
	 * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDING_AT__EXPRESSION_STATEMENT = INCLUDING__EXPRESSION_STATEMENT;

	/**
	 * The feature id for the '<em><b>In Iterator</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDING_AT__IN_ITERATOR = INCLUDING__IN_ITERATOR;

	/**
	 * The feature id for the '<em><b>From Clause</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDING_AT__FROM_CLAUSE = INCLUDING__FROM_CLAUSE;

	/**
	 * The feature id for the '<em><b>Template</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDING_AT__TEMPLATE = INCLUDING__TEMPLATE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDING_AT__SOURCE = INCLUDING__SOURCE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDING_AT__ARGUMENT = INCLUDING__ARGUMENT;

	/**
	 * The feature id for the '<em><b>At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDING_AT__AT = INCLUDING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Including At</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDING_AT_FEATURE_COUNT = INCLUDING_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dataaccess.expressions.collectionexpressions.impl.IterateImpl <em>Iterate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataaccess.expressions.collectionexpressions.impl.IterateImpl
	 * @see dataaccess.expressions.collectionexpressions.impl.CollectionexpressionsPackageImpl#getIterate()
	 * @generated
	 */
	int ITERATE = 3;

	/**
	 * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE__OWNED_TYPE_DEFINITION = COLLECTION_EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
	 * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE__EXPRESSION_STATEMENT = COLLECTION_EXPRESSION__EXPRESSION_STATEMENT;

	/**
	 * The feature id for the '<em><b>In Iterator</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE__IN_ITERATOR = COLLECTION_EXPRESSION__IN_ITERATOR;

	/**
	 * The feature id for the '<em><b>From Clause</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE__FROM_CLAUSE = COLLECTION_EXPRESSION__FROM_CLAUSE;

	/**
	 * The feature id for the '<em><b>Template</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE__TEMPLATE = COLLECTION_EXPRESSION__TEMPLATE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE__SOURCE = COLLECTION_EXPRESSION__SOURCE;

	/**
	 * The feature id for the '<em><b>Iterators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE__ITERATORS = COLLECTION_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Accumulator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE__ACCUMULATOR = COLLECTION_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Iterator Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE__ITERATOR_EXPRESSION = COLLECTION_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Iterate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_FEATURE_COUNT = COLLECTION_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link dataaccess.expressions.collectionexpressions.impl.ExcludingAtImpl <em>Excluding At</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataaccess.expressions.collectionexpressions.impl.ExcludingAtImpl
	 * @see dataaccess.expressions.collectionexpressions.impl.CollectionexpressionsPackageImpl#getExcludingAt()
	 * @generated
	 */
	int EXCLUDING_AT = 5;

	/**
	 * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDING_AT__OWNED_TYPE_DEFINITION = EXCLUDING__OWNED_TYPE_DEFINITION;

	/**
	 * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDING_AT__EXPRESSION_STATEMENT = EXCLUDING__EXPRESSION_STATEMENT;

	/**
	 * The feature id for the '<em><b>In Iterator</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDING_AT__IN_ITERATOR = EXCLUDING__IN_ITERATOR;

	/**
	 * The feature id for the '<em><b>From Clause</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDING_AT__FROM_CLAUSE = EXCLUDING__FROM_CLAUSE;

	/**
	 * The feature id for the '<em><b>Template</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDING_AT__TEMPLATE = EXCLUDING__TEMPLATE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDING_AT__SOURCE = EXCLUDING__SOURCE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDING_AT__ARGUMENT = EXCLUDING__ARGUMENT;

	/**
	 * The feature id for the '<em><b>At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDING_AT__AT = EXCLUDING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Excluding At</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDING_AT_FEATURE_COUNT = EXCLUDING_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dataaccess.expressions.collectionexpressions.impl.WithPositionImpl <em>With Position</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataaccess.expressions.collectionexpressions.impl.WithPositionImpl
	 * @see dataaccess.expressions.collectionexpressions.impl.CollectionexpressionsPackageImpl#getWithPosition()
	 * @generated
	 */
	int WITH_POSITION = 6;

	/**
	 * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_POSITION__OWNED_TYPE_DEFINITION = ExpressionsPackage.EXPRESSION_WITH_ARGUMENT__OWNED_TYPE_DEFINITION;

	/**
	 * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_POSITION__EXPRESSION_STATEMENT = ExpressionsPackage.EXPRESSION_WITH_ARGUMENT__EXPRESSION_STATEMENT;

	/**
	 * The feature id for the '<em><b>In Iterator</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_POSITION__IN_ITERATOR = ExpressionsPackage.EXPRESSION_WITH_ARGUMENT__IN_ITERATOR;

	/**
	 * The feature id for the '<em><b>From Clause</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_POSITION__FROM_CLAUSE = ExpressionsPackage.EXPRESSION_WITH_ARGUMENT__FROM_CLAUSE;

	/**
	 * The feature id for the '<em><b>Template</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_POSITION__TEMPLATE = ExpressionsPackage.EXPRESSION_WITH_ARGUMENT__TEMPLATE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_POSITION__ARGUMENT = ExpressionsPackage.EXPRESSION_WITH_ARGUMENT__ARGUMENT;

	/**
	 * The feature id for the '<em><b>At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_POSITION__AT = ExpressionsPackage.EXPRESSION_WITH_ARGUMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>With Position</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_POSITION_FEATURE_COUNT = ExpressionsPackage.EXPRESSION_WITH_ARGUMENT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link dataaccess.expressions.collectionexpressions.Including <em>Including</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Including</em>'.
	 * @see dataaccess.expressions.collectionexpressions.Including
	 * @generated
	 */
	EClass getIncluding();

	/**
	 * Returns the meta object for class '{@link dataaccess.expressions.collectionexpressions.Excluding <em>Excluding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Excluding</em>'.
	 * @see dataaccess.expressions.collectionexpressions.Excluding
	 * @generated
	 */
	EClass getExcluding();

	/**
	 * Returns the meta object for class '{@link dataaccess.expressions.collectionexpressions.IncludingAt <em>Including At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Including At</em>'.
	 * @see dataaccess.expressions.collectionexpressions.IncludingAt
	 * @generated
	 */
	EClass getIncludingAt();

	/**
	 * Returns the meta object for class '{@link dataaccess.expressions.collectionexpressions.Iterate <em>Iterate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterate</em>'.
	 * @see dataaccess.expressions.collectionexpressions.Iterate
	 * @generated
	 */
	EClass getIterate();

	/**
	 * Returns the meta object for the containment reference list '{@link dataaccess.expressions.collectionexpressions.Iterate#getIterators <em>Iterators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Iterators</em>'.
	 * @see dataaccess.expressions.collectionexpressions.Iterate#getIterators()
	 * @see #getIterate()
	 * @generated
	 */
	EReference getIterate_Iterators();

	/**
	 * Returns the meta object for the containment reference '{@link dataaccess.expressions.collectionexpressions.Iterate#getAccumulator <em>Accumulator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Accumulator</em>'.
	 * @see dataaccess.expressions.collectionexpressions.Iterate#getAccumulator()
	 * @see #getIterate()
	 * @generated
	 */
	EReference getIterate_Accumulator();

	/**
	 * Returns the meta object for the containment reference '{@link dataaccess.expressions.collectionexpressions.Iterate#getIteratorExpression <em>Iterator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Iterator Expression</em>'.
	 * @see dataaccess.expressions.collectionexpressions.Iterate#getIteratorExpression()
	 * @see #getIterate()
	 * @generated
	 */
	EReference getIterate_IteratorExpression();

	/**
	 * Returns the meta object for class '{@link dataaccess.expressions.collectionexpressions.CollectionExpression <em>Collection Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Expression</em>'.
	 * @see dataaccess.expressions.collectionexpressions.CollectionExpression
	 * @generated
	 */
	EClass getCollectionExpression();

	/**
	 * Returns the meta object for the containment reference '{@link dataaccess.expressions.collectionexpressions.CollectionExpression#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see dataaccess.expressions.collectionexpressions.CollectionExpression#getSource()
	 * @see #getCollectionExpression()
	 * @generated
	 */
	EReference getCollectionExpression_Source();

	/**
	 * Returns the meta object for class '{@link dataaccess.expressions.collectionexpressions.ExcludingAt <em>Excluding At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Excluding At</em>'.
	 * @see dataaccess.expressions.collectionexpressions.ExcludingAt
	 * @generated
	 */
	EClass getExcludingAt();

	/**
	 * Returns the meta object for class '{@link dataaccess.expressions.collectionexpressions.WithPosition <em>With Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>With Position</em>'.
	 * @see dataaccess.expressions.collectionexpressions.WithPosition
	 * @generated
	 */
	EClass getWithPosition();

	/**
	 * Returns the meta object for the attribute '{@link dataaccess.expressions.collectionexpressions.WithPosition#getAt <em>At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>At</em>'.
	 * @see dataaccess.expressions.collectionexpressions.WithPosition#getAt()
	 * @see #getWithPosition()
	 * @generated
	 */
	EAttribute getWithPosition_At();

	/**
	 * Returns the meta object for class '{@link dataaccess.expressions.collectionexpressions.CollectionExpressionWithArgument <em>Collection Expression With Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Expression With Argument</em>'.
	 * @see dataaccess.expressions.collectionexpressions.CollectionExpressionWithArgument
	 * @generated
	 */
	EClass getCollectionExpressionWithArgument();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CollectionexpressionsFactory getCollectionexpressionsFactory();

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
		 * The meta object literal for the '{@link dataaccess.expressions.collectionexpressions.impl.IncludingImpl <em>Including</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataaccess.expressions.collectionexpressions.impl.IncludingImpl
		 * @see dataaccess.expressions.collectionexpressions.impl.CollectionexpressionsPackageImpl#getIncluding()
		 * @generated
		 */
		EClass INCLUDING = eINSTANCE.getIncluding();

		/**
		 * The meta object literal for the '{@link dataaccess.expressions.collectionexpressions.impl.ExcludingImpl <em>Excluding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataaccess.expressions.collectionexpressions.impl.ExcludingImpl
		 * @see dataaccess.expressions.collectionexpressions.impl.CollectionexpressionsPackageImpl#getExcluding()
		 * @generated
		 */
		EClass EXCLUDING = eINSTANCE.getExcluding();

		/**
		 * The meta object literal for the '{@link dataaccess.expressions.collectionexpressions.impl.IncludingAtImpl <em>Including At</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataaccess.expressions.collectionexpressions.impl.IncludingAtImpl
		 * @see dataaccess.expressions.collectionexpressions.impl.CollectionexpressionsPackageImpl#getIncludingAt()
		 * @generated
		 */
		EClass INCLUDING_AT = eINSTANCE.getIncludingAt();

		/**
		 * The meta object literal for the '{@link dataaccess.expressions.collectionexpressions.impl.IterateImpl <em>Iterate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataaccess.expressions.collectionexpressions.impl.IterateImpl
		 * @see dataaccess.expressions.collectionexpressions.impl.CollectionexpressionsPackageImpl#getIterate()
		 * @generated
		 */
		EClass ITERATE = eINSTANCE.getIterate();

		/**
		 * The meta object literal for the '<em><b>Iterators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATE__ITERATORS = eINSTANCE.getIterate_Iterators();

		/**
		 * The meta object literal for the '<em><b>Accumulator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATE__ACCUMULATOR = eINSTANCE.getIterate_Accumulator();

		/**
		 * The meta object literal for the '<em><b>Iterator Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATE__ITERATOR_EXPRESSION = eINSTANCE.getIterate_IteratorExpression();

		/**
		 * The meta object literal for the '{@link dataaccess.expressions.collectionexpressions.impl.CollectionExpressionImpl <em>Collection Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataaccess.expressions.collectionexpressions.impl.CollectionExpressionImpl
		 * @see dataaccess.expressions.collectionexpressions.impl.CollectionexpressionsPackageImpl#getCollectionExpression()
		 * @generated
		 */
		EClass COLLECTION_EXPRESSION = eINSTANCE.getCollectionExpression();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_EXPRESSION__SOURCE = eINSTANCE.getCollectionExpression_Source();

		/**
		 * The meta object literal for the '{@link dataaccess.expressions.collectionexpressions.impl.ExcludingAtImpl <em>Excluding At</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataaccess.expressions.collectionexpressions.impl.ExcludingAtImpl
		 * @see dataaccess.expressions.collectionexpressions.impl.CollectionexpressionsPackageImpl#getExcludingAt()
		 * @generated
		 */
		EClass EXCLUDING_AT = eINSTANCE.getExcludingAt();

		/**
		 * The meta object literal for the '{@link dataaccess.expressions.collectionexpressions.impl.WithPositionImpl <em>With Position</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataaccess.expressions.collectionexpressions.impl.WithPositionImpl
		 * @see dataaccess.expressions.collectionexpressions.impl.CollectionexpressionsPackageImpl#getWithPosition()
		 * @generated
		 */
		EClass WITH_POSITION = eINSTANCE.getWithPosition();

		/**
		 * The meta object literal for the '<em><b>At</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WITH_POSITION__AT = eINSTANCE.getWithPosition_At();

		/**
		 * The meta object literal for the '{@link dataaccess.expressions.collectionexpressions.impl.CollectionExpressionWithArgumentImpl <em>Collection Expression With Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataaccess.expressions.collectionexpressions.impl.CollectionExpressionWithArgumentImpl
		 * @see dataaccess.expressions.collectionexpressions.impl.CollectionexpressionsPackageImpl#getCollectionExpressionWithArgument()
		 * @generated
		 */
		EClass COLLECTION_EXPRESSION_WITH_ARGUMENT = eINSTANCE.getCollectionExpressionWithArgument();

	}

} //CollectionexpressionsPackage
