package com.sap.tc.moin.xm.generation.core.code.serializer.template;

/**
 * Template for generating the body of a substitution group method body.
 */
public interface ElementMethodNameAndParameterType {

    /**
     * Returns the name of the element method.
     * 
     * @return method name, cannot be <code>null</code>
     */
    String getElementMethodName( );

    /**
     * Returns the qualified java class name of the type of the parameter of the
     * element method name.
     * 
     * @return parameter type qualified java class name, cannot be
     * <code>null</code>
     */
    String getParameterType( );


    /**
     * Returns the element QName which must be written to the output stream
     * before the method is called.
     * 
     * @return QName, cannot be <code>null</code>
     */
    QualifiedName getElementQName( );
}
