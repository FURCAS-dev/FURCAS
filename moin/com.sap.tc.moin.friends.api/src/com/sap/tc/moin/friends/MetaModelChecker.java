package com.sap.tc.moin.friends;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.NameViolation;

/**
 * The MetaModelChecker interface provides several name checking methods within
 * the meta-model.
 */
public interface MetaModelChecker {

    /**
     * Checks character and uniqueness violations in a given namespace for an
     * existing model element object.
     * 
     * @param connection
     * @param namespace
     * @param modelElement
     * @return a {@link NameViolation} object in error case, <code>null</code>
     * otherwise
     */
    public NameViolation checkModelElementName( Connection connection, Namespace namespace, ModelElement modelElement );

    /**
     * Checks character and uniqueness violations in a given namespace for a
     * model element to be created.
     * 
     * @param connection
     * @param namespace
     * @param modelElementName
     * @return a {@link NameViolation} object in error case, <code>null</code>
     * otherwise
     */
    public NameViolation checkModelElementName( Connection connection, Namespace namespace, String modelElementName );

    /**
     * Checks character and uniqueness violations in a given container for an
     * existing package object.
     * 
     * @param connection
     * @param containerCri
     * @param mofPackage
     * @return a {@link NameViolation} object in error case, <code>null</code>
     * otherwise
     */
    public NameViolation checkToplevelPackageName( Connection connection, CRI containerCri, MofPackage mofPackage );

    /**
     * Checks character and uniqueness violations in a given container for a
     * package to be created.
     * 
     * @param connection
     * @param containerCri
     * @param mofPackageName
     * @param prefix The package prefix
     * @return a {@link NameViolation} object in error case, <code>null</code>
     * otherwise
     */
    public NameViolation checkToplevelPackageName( Connection connection, CRI containerCri, String mofPackageName, String prefix );
}
