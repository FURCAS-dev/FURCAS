/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtrelation.impl;

import de.ikv.medini.qvt.model.qvtrelation.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QvtRelationFactoryImpl extends EFactoryImpl implements QvtRelationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QvtRelationFactory init() {
		try {
			QvtRelationFactory theQvtRelationFactory = (QvtRelationFactory)EPackage.Registry.INSTANCE.getEFactory("urn:semanticsQvt.model.qvtrelation.ecore"); 
			if (theQvtRelationFactory != null) {
				return theQvtRelationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QvtRelationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QvtRelationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case QvtRelationPackage.DOMAIN_PATTERN: return createDomainPattern();
			case QvtRelationPackage.KEY: return createKey();
			case QvtRelationPackage.RELATION: return createRelation();
			case QvtRelationPackage.RELATION_CALL_EXP: return createRelationCallExp();
			case QvtRelationPackage.RELATION_DOMAIN: return createRelationDomain();
			case QvtRelationPackage.RELATION_IMPLEMENTATION: return createRelationImplementation();
			case QvtRelationPackage.RELATIONAL_TRANSFORMATION: return createRelationalTransformation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainPattern createDomainPattern() {
		DomainPatternImpl domainPattern = new DomainPatternImpl();
		return domainPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Key createKey() {
		KeyImpl key = new KeyImpl();
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation createRelation() {
		RelationImpl relation = new RelationImpl();
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationCallExp createRelationCallExp() {
		RelationCallExpImpl relationCallExp = new RelationCallExpImpl();
		return relationCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationDomain createRelationDomain() {
		RelationDomainImpl relationDomain = new RelationDomainImpl();
		return relationDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationImplementation createRelationImplementation() {
		RelationImplementationImpl relationImplementation = new RelationImplementationImpl();
		return relationImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalTransformation createRelationalTransformation() {
		RelationalTransformationImpl relationalTransformation = new RelationalTransformationImpl();
		return relationalTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QvtRelationPackage getQvtRelationPackage() {
		return (QvtRelationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static QvtRelationPackage getPackage() {
		return QvtRelationPackage.eINSTANCE;
	}

} //QvtRelationFactoryImpl
