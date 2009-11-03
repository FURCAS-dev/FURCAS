package com.sap.tc.moin.repository.jmigenerator.template.impl;

import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorWrapperTemplate;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorBaseWrapper;

public abstract class JmiGeneratorBaseWrapperTemplateImpl extends JmiGeneratorBaseTemplateImpl implements JmiGeneratorWrapperTemplate {

    public JmiGeneratorBaseWrapperTemplateImpl( JmiGeneratorBaseWrapper wrapper, JmiGenerationKind actGenKind ) {

        super( wrapper, actGenKind );
    }

    public String getInterfaceType( ) {

        return getInterface( ).getPackageName( ) + "." + getInterface( ).getJavaName( ); //$NON-NLS-1$
    }

}
