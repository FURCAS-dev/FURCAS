/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtrelation.util;

import de.ikv.medini.qvt.model.qvtbase.Domain;
import de.ikv.medini.qvt.model.qvtbase.Pattern;
import de.ikv.medini.qvt.model.qvtbase.Rule;
import de.ikv.medini.qvt.model.qvtbase.Transformation;

import de.ikv.medini.qvt.model.qvtrelation.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.oslo.ocl20.semantics.SemanticsVisitable;

import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.DefinedClass;
import org.oslo.ocl20.semantics.bridge.DefinedPackage;
import org.oslo.ocl20.semantics.bridge.Element;
import org.oslo.ocl20.semantics.bridge.ModelElement;
import org.oslo.ocl20.semantics.bridge.NamedElement;
import org.oslo.ocl20.semantics.bridge.Namespace;

import org.oslo.ocl20.semantics.model.expressions.OclExpression;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage
 * @generated
 */
public class QvtRelationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QvtRelationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QvtRelationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = QvtRelationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QvtRelationSwitch modelSwitch =
		new QvtRelationSwitch() {
			public Object caseDomainPattern(DomainPattern object) {
				return createDomainPatternAdapter();
			}
			public Object caseKey(Key object) {
				return createKeyAdapter();
			}
			public Object caseRelation(Relation object) {
				return createRelationAdapter();
			}
			public Object caseRelationCallExp(RelationCallExp object) {
				return createRelationCallExpAdapter();
			}
			public Object caseRelationDomain(RelationDomain object) {
				return createRelationDomainAdapter();
			}
			public Object caseRelationImplementation(RelationImplementation object) {
				return createRelationImplementationAdapter();
			}
			public Object caseRelationalTransformation(RelationalTransformation object) {
				return createRelationalTransformationAdapter();
			}
			public Object caseSemanticsVisitable(SemanticsVisitable object) {
				return createSemanticsVisitableAdapter();
			}
			public Object caseElement(Element object) {
				return createElementAdapter();
			}
			public Object casePattern(Pattern object) {
				return createPatternAdapter();
			}
			public Object caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			public Object caseRule(Rule object) {
				return createRuleAdapter();
			}
			public Object caseModelElement(ModelElement object) {
				return createModelElementAdapter();
			}
			public Object caseOclExpression(OclExpression object) {
				return createOclExpressionAdapter();
			}
			public Object caseDomain(Domain object) {
				return createDomainAdapter();
			}
			public Object caseNamespace(Namespace object) {
				return createNamespaceAdapter();
			}
			public Object caseClassifier(Classifier object) {
				return createClassifierAdapter();
			}
			public Object caseDefinedClass(DefinedClass object) {
				return createDefinedClassAdapter();
			}
			public Object caseDefinedPackage(DefinedPackage object) {
				return createDefinedPackageAdapter();
			}
			public Object caseTransformation(Transformation object) {
				return createTransformationAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.ikv.medini.qvt.model.qvtrelation.DomainPattern <em>Domain Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.ikv.medini.qvt.model.qvtrelation.DomainPattern
	 * @generated
	 */
	public Adapter createDomainPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.ikv.medini.qvt.model.qvtrelation.Key <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.ikv.medini.qvt.model.qvtrelation.Key
	 * @generated
	 */
	public Adapter createKeyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.ikv.medini.qvt.model.qvtrelation.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.ikv.medini.qvt.model.qvtrelation.Relation
	 * @generated
	 */
	public Adapter createRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.ikv.medini.qvt.model.qvtrelation.RelationCallExp <em>Relation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.ikv.medini.qvt.model.qvtrelation.RelationCallExp
	 * @generated
	 */
	public Adapter createRelationCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.ikv.medini.qvt.model.qvtrelation.RelationDomain <em>Relation Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.ikv.medini.qvt.model.qvtrelation.RelationDomain
	 * @generated
	 */
	public Adapter createRelationDomainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.ikv.medini.qvt.model.qvtrelation.RelationImplementation <em>Relation Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.ikv.medini.qvt.model.qvtrelation.RelationImplementation
	 * @generated
	 */
	public Adapter createRelationImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.ikv.medini.qvt.model.qvtrelation.RelationalTransformation <em>Relational Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.ikv.medini.qvt.model.qvtrelation.RelationalTransformation
	 * @generated
	 */
	public Adapter createRelationalTransformationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.semantics.SemanticsVisitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.SemanticsVisitable
	 * @generated
	 */
	public Adapter createSemanticsVisitableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.semantics.bridge.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.bridge.Element
	 * @generated
	 */
	public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.ikv.medini.qvt.model.qvtbase.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.ikv.medini.qvt.model.qvtbase.Pattern
	 * @generated
	 */
	public Adapter createPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.semantics.bridge.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.bridge.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.ikv.medini.qvt.model.qvtbase.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.ikv.medini.qvt.model.qvtbase.Rule
	 * @generated
	 */
	public Adapter createRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.semantics.bridge.ModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.bridge.ModelElement
	 * @generated
	 */
	public Adapter createModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.semantics.model.expressions.OclExpression <em>Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.model.expressions.OclExpression
	 * @generated
	 */
	public Adapter createOclExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.ikv.medini.qvt.model.qvtbase.Domain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.ikv.medini.qvt.model.qvtbase.Domain
	 * @generated
	 */
	public Adapter createDomainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.semantics.bridge.Namespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.bridge.Namespace
	 * @generated
	 */
	public Adapter createNamespaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.semantics.bridge.Classifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.bridge.Classifier
	 * @generated
	 */
	public Adapter createClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.semantics.bridge.DefinedClass <em>Defined Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.bridge.DefinedClass
	 * @generated
	 */
	public Adapter createDefinedClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.semantics.bridge.DefinedPackage <em>Defined Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.semantics.bridge.DefinedPackage
	 * @generated
	 */
	public Adapter createDefinedPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.ikv.medini.qvt.model.qvtbase.Transformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.ikv.medini.qvt.model.qvtbase.Transformation
	 * @generated
	 */
	public Adapter createTransformationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //QvtRelationAdapterFactory
