/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblocks.util;

import com.sap.furcas.metamodel.FURCAS.textblocks.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage
 * @generated
 */
public class TextblocksAdapterFactory extends AdapterFactoryImpl {
        /**
         * The cached model package.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected static TextblocksPackage modelPackage;

        /**
         * Creates an instance of the adapter factory.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public TextblocksAdapterFactory() {
                if (modelPackage == null) {
                        modelPackage = TextblocksPackage.eINSTANCE;
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
        @Override
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
         * The switch that delegates to the <code>createXXX</code> methods.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected TextblocksSwitch<Adapter> modelSwitch =
                new TextblocksSwitch<Adapter>() {
                        @Override
                        public Adapter caseTextBlock(TextBlock object) {
                                return createTextBlockAdapter();
                        }
                        @Override
                        public Adapter caseAbstractToken(AbstractToken object) {
                                return createAbstractTokenAdapter();
                        }
                        @Override
                        public Adapter caseOmittedToken(OmittedToken object) {
                                return createOmittedTokenAdapter();
                        }
                        @Override
                        public Adapter caseLexedToken(LexedToken object) {
                                return createLexedTokenAdapter();
                        }
                        @Override
                        public Adapter caseUnlexedToken(UnlexedToken object) {
                                return createUnlexedTokenAdapter();
                        }
                        @Override
                        public Adapter caseDocumentNode(DocumentNode object) {
                                return createDocumentNodeAdapter();
                        }
                        @Override
                        public Adapter caseForEachContext(ForEachContext object) {
                                return createForEachContextAdapter();
                        }
                        @Override
                        public Adapter caseEostoken(Eostoken object) {
                                return createEostokenAdapter();
                        }
                        @Override
                        public Adapter caseBostoken(Bostoken object) {
                                return createBostokenAdapter();
                        }
                        @Override
                        public Adapter defaultCase(EObject object) {
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
        @Override
        public Adapter createAdapter(Notifier target) {
                return modelSwitch.doSwitch((EObject)target);
        }


        /**
         * Creates a new adapter for an object of class '{@link com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock <em>Text Block</em>}'.
         * <!-- begin-user-doc -->
         * This default implementation returns null so that we can easily ignore cases;
         * it's useful to ignore a case when inheritance will catch all the cases anyway.
         * <!-- end-user-doc -->
         * @return the new adapter.
         * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock
         * @generated
         */
        public Adapter createTextBlockAdapter() {
                return null;
        }

        /**
         * Creates a new adapter for an object of class '{@link com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken <em>Abstract Token</em>}'.
         * <!-- begin-user-doc -->
         * This default implementation returns null so that we can easily ignore cases;
         * it's useful to ignore a case when inheritance will catch all the cases anyway.
         * <!-- end-user-doc -->
         * @return the new adapter.
         * @see com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken
         * @generated
         */
        public Adapter createAbstractTokenAdapter() {
                return null;
        }

        /**
         * Creates a new adapter for an object of class '{@link com.sap.furcas.metamodel.FURCAS.textblocks.OmittedToken <em>Omitted Token</em>}'.
         * <!-- begin-user-doc -->
         * This default implementation returns null so that we can easily ignore cases;
         * it's useful to ignore a case when inheritance will catch all the cases anyway.
         * <!-- end-user-doc -->
         * @return the new adapter.
         * @see com.sap.furcas.metamodel.FURCAS.textblocks.OmittedToken
         * @generated
         */
        public Adapter createOmittedTokenAdapter() {
                return null;
        }

        /**
         * Creates a new adapter for an object of class '{@link com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken <em>Lexed Token</em>}'.
         * <!-- begin-user-doc -->
         * This default implementation returns null so that we can easily ignore cases;
         * it's useful to ignore a case when inheritance will catch all the cases anyway.
         * <!-- end-user-doc -->
         * @return the new adapter.
         * @see com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken
         * @generated
         */
        public Adapter createLexedTokenAdapter() {
                return null;
        }

        /**
         * Creates a new adapter for an object of class '{@link com.sap.furcas.metamodel.FURCAS.textblocks.UnlexedToken <em>Unlexed Token</em>}'.
         * <!-- begin-user-doc -->
         * This default implementation returns null so that we can easily ignore cases;
         * it's useful to ignore a case when inheritance will catch all the cases anyway.
         * <!-- end-user-doc -->
         * @return the new adapter.
         * @see com.sap.furcas.metamodel.FURCAS.textblocks.UnlexedToken
         * @generated
         */
        public Adapter createUnlexedTokenAdapter() {
                return null;
        }

        /**
         * Creates a new adapter for an object of class '{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode <em>Document Node</em>}'.
         * <!-- begin-user-doc -->
         * This default implementation returns null so that we can easily ignore cases;
         * it's useful to ignore a case when inheritance will catch all the cases anyway.
         * <!-- end-user-doc -->
         * @return the new adapter.
         * @see com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode
         * @generated
         */
        public Adapter createDocumentNodeAdapter() {
                return null;
        }

        /**
         * Creates a new adapter for an object of class '{@link com.sap.furcas.metamodel.FURCAS.textblocks.ForEachContext <em>For Each Context</em>}'.
         * <!-- begin-user-doc -->
         * This default implementation returns null so that we can easily ignore cases;
         * it's useful to ignore a case when inheritance will catch all the cases anyway.
         * <!-- end-user-doc -->
         * @return the new adapter.
         * @see com.sap.furcas.metamodel.FURCAS.textblocks.ForEachContext
         * @generated
         */
        public Adapter createForEachContextAdapter() {
                return null;
        }

        /**
         * Creates a new adapter for an object of class '{@link com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken <em>Eostoken</em>}'.
         * <!-- begin-user-doc -->
         * This default implementation returns null so that we can easily ignore cases;
         * it's useful to ignore a case when inheritance will catch all the cases anyway.
         * <!-- end-user-doc -->
         * @return the new adapter.
         * @see com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken
         * @generated
         */
        public Adapter createEostokenAdapter() {
                return null;
        }

        /**
         * Creates a new adapter for an object of class '{@link com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken <em>Bostoken</em>}'.
         * <!-- begin-user-doc -->
         * This default implementation returns null so that we can easily ignore cases;
         * it's useful to ignore a case when inheritance will catch all the cases anyway.
         * <!-- end-user-doc -->
         * @return the new adapter.
         * @see com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken
         * @generated
         */
        public Adapter createBostokenAdapter() {
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

} //TextblocksAdapterFactory
