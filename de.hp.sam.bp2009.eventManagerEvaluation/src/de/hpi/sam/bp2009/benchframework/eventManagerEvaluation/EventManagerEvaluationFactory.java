/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.eventManagerEvaluation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.eventManagerEvaluation.EventManagerEvaluationPackage
 * @generated
 */
public interface EventManagerEvaluationFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EventManagerEvaluationFactory eINSTANCE = de.hpi.sam.bp2009.benchframework.eventManagerEvaluation.impl.EventManagerEvaluationFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Event Manager Operator</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Event Manager Operator</em>'.
     * @generated
     */
    EventManagerOperator createEventManagerOperator();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    EventManagerEvaluationPackage getEventManagerEvaluationPackage();

} //EventManagerEvaluationFactory
