package com.sap.tc.moin.xm.generation.core.code.serializer.template;

import java.util.List;

/**
 * Template for a method which represents a substitution group.
 */
public interface SubstitutionGroupMethod {


    /**
     * Returns the QName of the substitution group head.
     * 
     * @return qualified name, cannot be <code>null</code>
     */
    QualifiedName getSubstitutionGroupHead( );

    /**
     * Returns the name of the method.
     * 
     * @return method name, cannot be <code>null</code>
     */
    String getMethodName( );


    /**
     * Returns the information of the method calls contained in the body of the
     * substitution group method.
     * 
     * @return list of element method names and their parameter types, cannot be
     * <code>null</code>
     */
    List<ElementMethodNameAndParameterType> getMethodCalls( );

}
