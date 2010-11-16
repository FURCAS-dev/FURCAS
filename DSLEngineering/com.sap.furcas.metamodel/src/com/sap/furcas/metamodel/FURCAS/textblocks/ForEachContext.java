/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblocks;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Each Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.ForEachContext#getForeachPedicatePropertyInit <em>Foreach Pedicate Property Init</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.ForEachContext#getContextElement <em>Context Element</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.ForEachContext#getResultModelElement <em>Result Model Element</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.ForEachContext#getSourceModelElement <em>Source Model Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getForEachContext()
 * @model
 * @generated
 */
public interface ForEachContext extends EObject {
        /**
     * Returns the value of the '<em><b>Foreach Pedicate Property Init</b></em>' reference.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Foreach Pedicate Property Init</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Foreach Pedicate Property Init</em>' reference.
     * @see #setForeachPedicatePropertyInit(ForeachPredicatePropertyInit)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getForEachContext_ForeachPedicatePropertyInit()
     * @model
     * @generated
     */
        ForeachPredicatePropertyInit getForeachPedicatePropertyInit();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.ForEachContext#getForeachPedicatePropertyInit <em>Foreach Pedicate Property Init</em>}' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Foreach Pedicate Property Init</em>' reference.
     * @see #getForeachPedicatePropertyInit()
     * @generated
     */
        void setForeachPedicatePropertyInit(ForeachPredicatePropertyInit value);

        /**
     * Returns the value of the '<em><b>Context Element</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Context Element</em>' reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Context Element</em>' reference list.
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getForEachContext_ContextElement()
     * @model
     * @generated
     */
        EList<EObject> getContextElement();

        /**
     * Returns the value of the '<em><b>Result Model Element</b></em>' reference.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Result Model Element</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Result Model Element</em>' reference.
     * @see #setResultModelElement(EObject)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getForEachContext_ResultModelElement()
     * @model
     * @generated
     */
        EObject getResultModelElement();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.ForEachContext#getResultModelElement <em>Result Model Element</em>}' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Result Model Element</em>' reference.
     * @see #getResultModelElement()
     * @generated
     */
        void setResultModelElement(EObject value);

        /**
     * Returns the value of the '<em><b>Source Model Element</b></em>' reference.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Source Model Element</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Source Model Element</em>' reference.
     * @see #setSourceModelElement(EObject)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getForEachContext_SourceModelElement()
     * @model
     * @generated
     */
        EObject getSourceModelElement();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.ForEachContext#getSourceModelElement <em>Source Model Element</em>}' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Model Element</em>' reference.
     * @see #getSourceModelElement()
     * @generated
     */
        void setSourceModelElement(EObject value);

} // ForEachContext
