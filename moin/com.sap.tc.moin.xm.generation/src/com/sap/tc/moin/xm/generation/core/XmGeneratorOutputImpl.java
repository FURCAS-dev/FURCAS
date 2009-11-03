package com.sap.tc.moin.xm.generation.core;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.xm.generation.XmGenerationProtocol;
import com.sap.tc.moin.xm.generation.XmGeneratorOutput;


final class XmGeneratorOutputImpl implements XmGeneratorOutput {


    private final String pCode;

    private final String sCode;

    private final String xmCpsFactory;

    private final String modelStorage;

    private final XmGenerationProtocol protocol;

    XmGeneratorOutputImpl( final String parserCode, final String serializerCode, final String xmCpsFacotryCode, final String modelstorageXml, final XmGenerationProtocol aProtocol ) {

        if ( aProtocol == null ) {
            throw new MoinNullPointerException( "aProtocol" ); //$NON-NLS-1$
        }
        this.pCode = parserCode;
        this.sCode = serializerCode;
        this.xmCpsFactory = xmCpsFacotryCode;
        this.modelStorage = modelstorageXml;
        this.protocol = aProtocol;
    }

    public String getParserJavaSourceCode( ) {

        return this.pCode;
    }


    public String getSerializerJavaSourceCode( ) {

        return this.sCode;
    }

    public String getXmCpsFactoryJavaSourceCode( ) {

        return this.xmCpsFactory;
    }

    public String getModelstorageXml( ) {

        return this.modelStorage;
    }

    public XmGenerationProtocol getProtocol( ) {

        return this.protocol;
    }

}
