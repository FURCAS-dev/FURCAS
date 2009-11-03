package com.sap.tc.moin.repository.jmigenerator.template.impl;

import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorPackageFeature;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorAssociationWrapper;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorBaseWrapper;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorClassWrapper;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorPackageWrapper;

/**
 * Helper template
 */
public class JmiGeneratorFeatureExtendedImpl extends JmiGeneratorFeatureImpl implements JmiGeneratorPackageFeature {

    private final Boolean isImported;

    private final String javaProxyInterfaceType;

    private final String javaProxyImplementationType;

    private boolean isMofClass;

    private boolean isMofClassAbstract;

    /**
     * @param wrapper
     * @param actImported
     */
    public JmiGeneratorFeatureExtendedImpl( JmiGeneratorPackageWrapper wrapper, boolean actImported ) {

        super( wrapper );
        this.isImported = Boolean.valueOf( actImported );
        this.javaProxyInterfaceType = wrapper.getJavaClassName( JmiGenerationKind.INTERFACE, true );
        this.javaProxyImplementationType = wrapper.getJavaClassName( JmiGenerationKind.CLASS, true );
    }

    /**
     * @param wrapper
     */
    public JmiGeneratorFeatureExtendedImpl( JmiGeneratorClassWrapper wrapper ) {

        super( wrapper );
        this.isImported = Boolean.FALSE;
        this.javaProxyInterfaceType = wrapper.getJavaProxyClassName( JmiGenerationKind.INTERFACE, true );
        this.javaProxyImplementationType = wrapper.getJavaProxyClassName( JmiGenerationKind.CLASS, true );
    }

    /**
     * @param wrapper
     */
    public JmiGeneratorFeatureExtendedImpl( JmiGeneratorAssociationWrapper wrapper ) {

        super( wrapper );
        this.isImported = Boolean.FALSE;
        this.javaProxyInterfaceType = wrapper.getJavaClassName( JmiGenerationKind.INTERFACE, true );
        this.javaProxyImplementationType = wrapper.getJavaClassName( JmiGenerationKind.CLASS, true );
    }

    public Boolean isImported( ) {

        return this.isImported;
    }

    public String getJavaProxyInterfaceType( ) {

        return this.javaProxyInterfaceType;
    }

    public String getJavaProxyImplementationType( ) {

        return this.javaProxyImplementationType;
    }

    public Boolean isWrapResult( ) {

        return Boolean.TRUE;
    }

    public Boolean isNoThreadLocal( ) {

        return Boolean.TRUE;
    }

    public Boolean isNeedsToPassCoreConnectionInWrapper( ) {

        return Boolean.TRUE;
    }

    public Boolean isClassProxyGenerated( ) {

        return !JmiGeneratorBaseWrapper.noClassProxy( );
    }

    public boolean isMofClass( ) {

        return isMofClass;
    }

    public void setMofClass( boolean isMofClass ) {

        this.isMofClass = isMofClass;
    }

    public boolean isMofClassAbstract( ) {

        return isMofClassAbstract;
    }

    public void setMofClassAbstract( boolean isMofClassAbstract ) {

        this.isMofClassAbstract = isMofClassAbstract;
    }

    public String getType( ) {

        return javaProxyInterfaceType;
    }

    public String getTypeParameter( ) {

        return null;
    }
}
