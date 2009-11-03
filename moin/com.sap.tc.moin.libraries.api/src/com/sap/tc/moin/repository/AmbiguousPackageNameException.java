package com.sap.tc.moin.repository;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Is thrown if {@link Connection#getPackage(String, String...)} is called
 * without specifying the container name and there is more than one
 * {@link RefPackage} with the specified qualified name.
 */
public class AmbiguousPackageNameException extends MoinLocalizedBaseRuntimeException {

    RefPackage[] duplicatePackages;

    /**
     * Creates an instance of this exception.
     * 
     * @param duplicatePkgs the packages which are ambiguous.
     * @param message message
     * @param packageName package name that could not be resolved
     */
    public AmbiguousPackageNameException( RefPackage[] duplicatePkgs, MoinLocalizedString message, String packageName ) {

        super( message, packageName );
        this.duplicatePackages = duplicatePkgs;
    }

    /**
     * Returns the packages that are ambiguous.
     * 
     * @return the packages which are ambiguous
     */
    public RefPackage[] getPackages( ) {

        return this.duplicatePackages;
    }

    static final long serialVersionUID = -3387516966124229948L;
}
