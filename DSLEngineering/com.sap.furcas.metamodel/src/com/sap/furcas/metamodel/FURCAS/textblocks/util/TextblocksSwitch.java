/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblocks.util;

import com.sap.furcas.metamodel.FURCAS.textblocks.*;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.ForEachContext;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.OmittedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.metamodel.FURCAS.textblocks.UnlexedToken;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage
 * @generated
 */
public class TextblocksSwitch<T> {
        /**
	 * The cached model package
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected static TextblocksPackage modelPackage;

        /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public TextblocksSwitch() {
		if (modelPackage == null) {
			modelPackage = TextblocksPackage.eINSTANCE;
		}
	}

        /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
        public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

        /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
        protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

        /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
        protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case TextblocksPackage.TEXT_BLOCK: {
				TextBlock textBlock = (TextBlock)theEObject;
				T result = caseTextBlock(textBlock);
				if (result == null) result = caseDocumentNode(textBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TextblocksPackage.ABSTRACT_TOKEN: {
				AbstractToken abstractToken = (AbstractToken)theEObject;
				T result = caseAbstractToken(abstractToken);
				if (result == null) result = caseDocumentNode(abstractToken);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TextblocksPackage.OMITTED_TOKEN: {
				OmittedToken omittedToken = (OmittedToken)theEObject;
				T result = caseOmittedToken(omittedToken);
				if (result == null) result = caseAbstractToken(omittedToken);
				if (result == null) result = caseDocumentNode(omittedToken);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TextblocksPackage.LEXED_TOKEN: {
				LexedToken lexedToken = (LexedToken)theEObject;
				T result = caseLexedToken(lexedToken);
				if (result == null) result = caseAbstractToken(lexedToken);
				if (result == null) result = caseDocumentNode(lexedToken);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TextblocksPackage.UNLEXED_TOKEN: {
				UnlexedToken unlexedToken = (UnlexedToken)theEObject;
				T result = caseUnlexedToken(unlexedToken);
				if (result == null) result = caseAbstractToken(unlexedToken);
				if (result == null) result = caseDocumentNode(unlexedToken);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TextblocksPackage.DOCUMENT_NODE: {
				DocumentNode documentNode = (DocumentNode)theEObject;
				T result = caseDocumentNode(documentNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TextblocksPackage.FOR_EACH_CONTEXT: {
				ForEachContext forEachContext = (ForEachContext)theEObject;
				T result = caseForEachContext(forEachContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TextblocksPackage.EOSTOKEN: {
				Eostoken eostoken = (Eostoken)theEObject;
				T result = caseEostoken(eostoken);
				if (result == null) result = caseAbstractToken(eostoken);
				if (result == null) result = caseDocumentNode(eostoken);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TextblocksPackage.BOSTOKEN: {
				Bostoken bostoken = (Bostoken)theEObject;
				T result = caseBostoken(bostoken);
				if (result == null) result = caseAbstractToken(bostoken);
				if (result == null) result = caseDocumentNode(bostoken);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Text Block</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseTextBlock(TextBlock object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Token</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Token</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseAbstractToken(AbstractToken object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Omitted Token</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Omitted Token</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseOmittedToken(OmittedToken object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Lexed Token</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lexed Token</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseLexedToken(LexedToken object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Unlexed Token</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unlexed Token</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseUnlexedToken(UnlexedToken object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Document Node</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseDocumentNode(DocumentNode object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>For Each Context</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Each Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseForEachContext(ForEachContext object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Eostoken</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Eostoken</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseEostoken(Eostoken object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Bostoken</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bostoken</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseBostoken(Bostoken object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch, but this is the last case anyway.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
        public T defaultCase(EObject object) {
		return null;
	}

} //TextblocksSwitch
