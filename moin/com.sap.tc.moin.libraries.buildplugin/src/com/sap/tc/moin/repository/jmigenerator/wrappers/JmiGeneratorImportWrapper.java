package com.sap.tc.moin.repository.jmigenerator.wrappers;

import com.sap.tc.moin.repository.mmi.model.Import;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.__impl.ImportInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorImpl;

/**
 * The Import wrapper
 */
public class JmiGeneratorImportWrapper extends JmiGeneratorPackageWrapper {

    private ImportInternal importer;

    /**
     * @param theImporter
     * @param parent
     * @param generator
     */
    public JmiGeneratorImportWrapper( CoreConnection connection, String metamodelName, Import theImporter, JmiGeneratorBaseWrapper parent, JmiGeneratorImpl generator ) {

        super( connection, metamodelName, (MofPackage) ( (ImportInternal) theImporter ).getImportedNamespace( connection ), parent, generator );
        this.importer = (ImportInternal) theImporter;
    }

    @Override
    public String getAccessorName( ) {

        return super.getAccessorNameForModelElement( this.importer );
    }

}
