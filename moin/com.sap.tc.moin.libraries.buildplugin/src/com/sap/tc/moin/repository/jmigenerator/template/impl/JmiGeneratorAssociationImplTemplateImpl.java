package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.List;

import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorAssociationImplTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorBaseTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorAssociationWrapper;

/**
 * The Association implementation template
 */
public class JmiGeneratorAssociationImplTemplateImpl extends JmiGeneratorBaseTemplateImpl implements JmiGeneratorAssociationImplTemplate {

    private final JmiGeneratorAssociationWrapper myAssocWrapper;

    /**
     * @param wrapper
     */
    public JmiGeneratorAssociationImplTemplateImpl( JmiGeneratorAssociationWrapper wrapper ) {

        super( wrapper, JmiGenerationKind.CLASS );
        this.myAssocWrapper = wrapper;
    }

    public List<JmiGeneratorClassOperation> getOperations( ) {

        return this.myAssocWrapper.getOperations( this.genKind );
    }

    public JmiGeneratorInterfaceTemplate getInterface( ) {

        return (JmiGeneratorInterfaceTemplate) this.myAssocWrapper.getJavaTemplate( JmiGenerationKind.INTERFACE, "dummy" ); //$NON-NLS-1$
    }

    //    public String getEnd0Type() {
    //        return this.myAssocWrapper.getEnd0Type();
    //    }
    //
    //    public String getEnd1Type() {
    //        return this.myAssocWrapper.getEnd1Type();
    //    }

    public JmiGeneratorBaseTemplate getWrapper( ) {

        return this.myAssocWrapper.getJavaTemplate( JmiGenerationKind.WRAPPER, "Wrapper" ); //$NON-NLS-1$
    }

}
