/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblocks;

import com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Each Execution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.ForEachExecution#getForeachPedicatePropertyInit <em>Foreach Pedicate Property Init</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.ForEachExecution#getContextElement <em>Context Element</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.ForEachExecution#getResultModelElement <em>Result Model Element</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.ForEachExecution#getSourceModelElement <em>Source Model Element</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.ForEachExecution#getContextString <em>Context String</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.ForEachExecution#getTemplateUsedForProduction <em>Template Used For Production</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getForEachExecution()
 * @model
 * @generated
 */
public interface ForEachExecution extends TextBlock {
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
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getForEachExecution_ForeachPedicatePropertyInit()
     * @model
     * @generated
     */
    ForeachPredicatePropertyInit getForeachPedicatePropertyInit();

    /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.ForEachExecution#getForeachPedicatePropertyInit <em>Foreach Pedicate Property Init</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Foreach Pedicate Property Init</em>' reference.
     * @see #getForeachPedicatePropertyInit()
     * @generated
     */
    void setForeachPedicatePropertyInit(ForeachPredicatePropertyInit value);

    /**
     * Returns the value of the '<em><b>Context Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Context Element</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Context Element</em>' reference.
     * @see #setContextElement(EObject)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getForEachExecution_ContextElement()
     * @model
     * @generated
     */
    EObject getContextElement();

    /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.ForEachExecution#getContextElement <em>Context Element</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Context Element</em>' reference.
     * @see #getContextElement()
     * @generated
     */
    void setContextElement(EObject value);

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
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getForEachExecution_ResultModelElement()
     * @model
     * @generated
     */
    EObject getResultModelElement();

    /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.ForEachExecution#getResultModelElement <em>Result Model Element</em>}' reference.
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
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getForEachExecution_SourceModelElement()
     * @model
     * @generated
     */
    EObject getSourceModelElement();

    /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.ForEachExecution#getSourceModelElement <em>Source Model Element</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Model Element</em>' reference.
     * @see #getSourceModelElement()
     * @generated
     */
    void setSourceModelElement(EObject value);

    /**
     * Returns the value of the '<em><b>Context String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Context String</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Context String</em>' attribute.
     * @see #setContextString(String)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getForEachExecution_ContextString()
     * @model
     * @generated
     */
    String getContextString();

    /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.ForEachExecution#getContextString <em>Context String</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Context String</em>' attribute.
     * @see #getContextString()
     * @generated
     */
    void setContextString(String value);

    /**
     * Returns the value of the '<em><b>Template Used For Production</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Template Used For Production</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Template Used For Production</em>' reference.
     * @see #setTemplateUsedForProduction(Template)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getForEachExecution_TemplateUsedForProduction()
     * @model required="true"
     * @generated
     */
    Template getTemplateUsedForProduction();

    /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.ForEachExecution#getTemplateUsedForProduction <em>Template Used For Production</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Template Used For Production</em>' reference.
     * @see #getTemplateUsedForProduction()
     * @generated
     */
    void setTemplateUsedForProduction(Template value);

} // ForEachExecution
