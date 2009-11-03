package com.sap.tc.moin.repository.jmigenerator.template.impl;

import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorEnumInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorBaseWrapper;

/**
 * The Enumeration interface
 */
public class JmiGeneratorEnumInterfaceTemplateImpl extends JmiGeneratorBaseTemplateImpl implements JmiGeneratorEnumInterfaceTemplate {

    /**
     * @param wrapper
     */
    public JmiGeneratorEnumInterfaceTemplateImpl( JmiGeneratorBaseWrapper wrapper ) {

        super( wrapper, JmiGenerationKind.INTERFACE );
    }

    public boolean isInterface( ) {

        return true;
    }

}
