package com.sap.tc.moin.repository.jmigenerator;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorClassWrapper;

/**
 * Resolve class names; reflectively used in the MofRomGenerator
 */
public class JmiClassNameResolverCoreImpl {

    private CoreConnection connection = null;

    JmiGeneratorImpl myGenerator = null;

    public JmiClassNameResolverCoreImpl( CoreConnection connection ) {
        this.connection = connection;
        myGenerator = new JmiGeneratorImpl( connection );
    }

    /**
     * @param me the ModelElement provided
     * @return the fully qualified class name
     */
    public String getJavaClassName( ModelElement me ) {

        return this.myGenerator.getOrCreateWrapper( me ).getJavaClassName( JmiGenerationKind.CLASS, true );
    }

    /**
     * @param me the ModelElement provided
     * @param getProxy <code>true</code> if the class proxy is required
     * @return the fully qualified class name
     */
    public String getJavaClassName( MofClass me, boolean getProxy ) {

        if ( getProxy ) {
            JmiGeneratorClassWrapper cw = (JmiGeneratorClassWrapper) this.myGenerator.getOrCreateWrapper( me );
            return cw.getJavaProxyClassName( JmiGenerationKind.CLASS, true );
        }
        return this.myGenerator.getOrCreateWrapper( me ).getJavaClassName( JmiGenerationKind.CLASS, true );

    }
}
