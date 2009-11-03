package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.List;

import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorBaseTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorJavadoc;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorBaseWrapper;

/**
 * The abstract base template
 */
public abstract class JmiGeneratorBaseTemplateImpl implements JmiGeneratorBaseTemplate {

    protected final JmiGeneratorBaseWrapper myWrapper;

    protected JmiGenerationKind genKind;

    /**
     * @param wrapper
     * @param actGenKind
     */
    public JmiGeneratorBaseTemplateImpl( JmiGeneratorBaseWrapper wrapper, JmiGenerationKind actGenKind ) {

        this.myWrapper = wrapper;
        this.genKind = actGenKind;
    }

    /**
     * @return the list of fully qualified base classes
     */
    public List<String> getExtends( ) {

        return this.myWrapper.getExtends( this.genKind, true );
    }

    public boolean getBelongsToMof( ) {

        return myWrapper.belongsToMof( );
    }

    /**
     * @return the list of fully qualified implemented classes
     */
    public List<String> getImplements( ) {

        return this.myWrapper.getImplements( this.genKind, true );
    }

    /**
     * @return the java class name (without package)
     */
    public String getJavaName( ) {

        return this.myWrapper.getJavaClassName( this.genKind, false );
    }

    /**
     * @return the Java package name
     */
    public String getPackageName( ) {

        return this.myWrapper.getJavaPackageNameQualified( this.genKind );
    }

    /**
     * @return the header comments
     */
    public String getPreamble( ) {

        return JmiGeneratorBaseWrapper.PREAMBLE;
    }

    /**
     * @return the Javadoc for an element
     */
    public JmiGeneratorJavadoc getJavadoc( ) {

        return this.myWrapper.getJavadocForAnnotation( );
    }

}
