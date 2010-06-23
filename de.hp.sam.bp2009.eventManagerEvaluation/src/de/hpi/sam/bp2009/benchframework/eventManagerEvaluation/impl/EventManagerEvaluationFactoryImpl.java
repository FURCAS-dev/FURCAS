/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.eventManagerEvaluation.impl;

import de.hpi.sam.bp2009.benchframework.eventManagerEvaluation.*;

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
public class EventManagerEvaluationFactoryImpl extends EFactoryImpl implements EventManagerEvaluationFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static EventManagerEvaluationFactory init() {
        try {
            EventManagerEvaluationFactory theEventManagerEvaluationFactory = (EventManagerEvaluationFactory)EPackage.Registry.INSTANCE.getEFactory("http.//de.hpi.sam.bp2009.benchframework.eventManagerEvaluation"); 
            if (theEventManagerEvaluationFactory != null) {
                return theEventManagerEvaluationFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new EventManagerEvaluationFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EventManagerEvaluationFactoryImpl() {
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
            case EventManagerEvaluationPackage.EVENT_MANAGER_OPERATOR: return createEventManagerOperator();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EventManagerOperator createEventManagerOperator() {
        EventManagerOperatorImpl eventManagerOperator = new EventManagerOperatorImpl();
        return eventManagerOperator;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EventManagerEvaluationPackage getEventManagerEvaluationPackage() {
        return (EventManagerEvaluationPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static EventManagerEvaluationPackage getPackage() {
        return EventManagerEvaluationPackage.eINSTANCE;
    }

} //EventManagerEvaluationFactoryImpl
