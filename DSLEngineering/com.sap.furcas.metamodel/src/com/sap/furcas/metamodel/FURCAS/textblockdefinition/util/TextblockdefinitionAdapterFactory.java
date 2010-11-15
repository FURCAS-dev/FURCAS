/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblockdefinition.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage
 * @generated
 */
public class TextblockdefinitionAdapterFactory extends AdapterFactoryImpl {
        /**
     * The cached model package.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected static TextblockdefinitionPackage modelPackage;

        /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public TextblockdefinitionAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = TextblockdefinitionPackage.eINSTANCE;
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
        protected TextblockdefinitionSwitch<Adapter> modelSwitch =
                new TextblockdefinitionSwitch<Adapter>() {
            @Override
            public Adapter caseTextBlockDefinition(TextBlockDefinition object) {
                return createTextBlockDefinitionAdapter();
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
     * Creates a new adapter for an object of class '{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition <em>Text Block Definition</em>}'.
     * <!-- begin-user-doc -->
         * This default implementation returns null so that we can easily ignore cases;
         * it's useful to ignore a case when inheritance will catch all the cases anyway.
         * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition
     * @generated
     */
        public Adapter createTextBlockDefinitionAdapter() {
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

} //TextblockdefinitionAdapterFactory
