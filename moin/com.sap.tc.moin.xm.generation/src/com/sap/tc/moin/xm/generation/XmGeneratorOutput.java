package com.sap.tc.moin.xm.generation;

/**
 * Return object of the XM generator ({@link XmGenerator}).
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface XmGeneratorOutput {

    /**
     * Returns the generated java class for the XM Parser.
     * 
     * @return parser java source code, <code>null</code> if the generator input
     * {@link XmGeneratorInput} has indicated that a parser shall not be
     * generated
     */
    String getParserJavaSourceCode( );

    /**
     * Returns the generated java class for the XM Serializer.
     * 
     * @return serializer java source code, <code>null</code> if the generator
     * input {@link XmGeneratorInput} has indicated that a serializer shall not
     * be generated
     */
    String getSerializerJavaSourceCode( );

    /**
     * Returns the source code of the factory for the parser/serializer needed
     * in the CP/S integration strategy. This factory must be registered in the
     * model-storage XML (see method {@link #getModelstorageXml()}).
     * 
     * @return java source code of the XM CPS factory, <code>null</code> if the
     * generator input {@link XmGeneratorInput} has indicated that a factory
     * shall not be generated
     */
    String getXmCpsFactoryJavaSourceCode( );

    /**
     * Returns the model-storage XML which is needed if the XM parser/serializer
     * is running in the CP/S integration strategy.
     * 
     * @return model-storage XML containing the registration information for
     * CP/S, <code>null</code> if the generator input {@link XmGeneratorInput}
     * has indicated that a this XML shall not be generated
     */
    String getModelstorageXml( );


    /**
     * Returns the generation protocol.
     * 
     * @return protocol, cannot be <code>null</code>
     */
    XmGenerationProtocol getProtocol( );


}
