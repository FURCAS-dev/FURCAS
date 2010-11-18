/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.presentation;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.ocl.ecore.edit.OCLEcoreEditPlugin;
import org.eclipse.ocl.edit.OCLEditPlugin;

/**
 * This is the central singleton for the FURCAS editor plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class FURCASEditorPlugin extends EMFPlugin {
        /**
     * Keep track of the singleton.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public static final FURCASEditorPlugin INSTANCE = new FURCASEditorPlugin();
        
        /**
     * Keep track of the singleton.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private static Implementation plugin;

        /**
     * Create the instance.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public FURCASEditorPlugin() {
        super
            (new ResourceLocator [] {
                EcoreEditPlugin.INSTANCE,
                OCLEditPlugin.INSTANCE,
                OCLEcoreEditPlugin.INSTANCE,
            });
    }

        /**
     * Returns the singleton instance of the Eclipse plugin.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the singleton instance.
     * @generated
     */
        @Override
        public ResourceLocator getPluginResourceLocator() {
        return plugin;
    }
        
        /**
     * Returns the singleton instance of the Eclipse plugin.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @return the singleton instance.
     * @generated
     */
        public static Implementation getPlugin() {
        return plugin;
    }
        
        /**
     * The actual implementation of the Eclipse <b>Plugin</b>.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public static class Implementation extends EclipseUIPlugin {
                /**
         * Creates an instance.
         * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
         * @generated
         */
                public Implementation() {
            super();
    
            // Remember the static instance.
            //
            plugin = this;
        }
        }

}
