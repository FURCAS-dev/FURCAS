package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.List;

import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorEnumImplTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorEnumInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorEnumLabel;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorFeature;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorEnumWrapper;

/**
 * The Enum implementation
 */
public class JmiGeneratorEnumImplTemplateImpl extends JmiGeneratorBaseTemplateImpl implements JmiGeneratorEnumImplTemplate {

    private final JmiGeneratorEnumWrapper myEnumWrapper;

    /**
     * @param wrapper
     */
    public JmiGeneratorEnumImplTemplateImpl( JmiGeneratorEnumWrapper wrapper ) {

        super( wrapper, JmiGenerationKind.CLASS );
        this.myEnumWrapper = wrapper;
    }

    /**
     * @return the features
     */
    public List<JmiGeneratorFeature> getFeatures( ) {

        return null;
    }

    public List<JmiGeneratorEnumLabel> getEnumLabels( ) {

        return this.myEnumWrapper.getEnumLabels( );
    }

    public String getImplementationType( ) {

        return this.myEnumWrapper.getJavaClassName( JmiGenerationKind.INTERFACE, false );
    }

    public List<String> getType( ) {

        return this.myEnumWrapper.getType( );
    }

    public JmiGeneratorEnumInterfaceTemplate getInterface( ) {

        return (JmiGeneratorEnumInterfaceTemplate) this.myEnumWrapper.getJavaTemplate( JmiGenerationKind.INTERFACE, "" ); //$NON-NLS-1$
    }

    public String getQualifiedNameForStringArrayInitializer( ) {

        return this.myEnumWrapper.getQualifiedNameForStringArrayInitializer( );
    }

    public List<String> getQualifiedName( ) {

        return this.myEnumWrapper.getQualifiedName( );
    }


}