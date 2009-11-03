/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvttemplate.impl;

import de.ikv.medini.qvt.model.qvttemplate.*;

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
public class QvtTemplateFactoryImpl extends EFactoryImpl implements QvtTemplateFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QvtTemplateFactory init() {
		try {
			QvtTemplateFactory theQvtTemplateFactory = (QvtTemplateFactory)EPackage.Registry.INSTANCE.getEFactory("urn:semanticsQvt.model.qvttemplate.ecore"); 
			if (theQvtTemplateFactory != null) {
				return theQvtTemplateFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QvtTemplateFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QvtTemplateFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case QvtTemplatePackage.COLLETION_TEMPLATE_EXP: return createColletionTemplateExp();
			case QvtTemplatePackage.OBJECT_TEMPLATE_EXP: return createObjectTemplateExp();
			case QvtTemplatePackage.PROPERTY_TEMPLATE_ITEM: return createPropertyTemplateItem();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColletionTemplateExp createColletionTemplateExp() {
		ColletionTemplateExpImpl colletionTemplateExp = new ColletionTemplateExpImpl();
		return colletionTemplateExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectTemplateExp createObjectTemplateExp() {
		ObjectTemplateExpImpl objectTemplateExp = new ObjectTemplateExpImpl();
		return objectTemplateExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyTemplateItem createPropertyTemplateItem() {
		PropertyTemplateItemImpl propertyTemplateItem = new PropertyTemplateItemImpl();
		return propertyTemplateItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QvtTemplatePackage getQvtTemplatePackage() {
		return (QvtTemplatePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static QvtTemplatePackage getPackage() {
		return QvtTemplatePackage.eINSTANCE;
	}

} //QvtTemplateFactoryImpl
