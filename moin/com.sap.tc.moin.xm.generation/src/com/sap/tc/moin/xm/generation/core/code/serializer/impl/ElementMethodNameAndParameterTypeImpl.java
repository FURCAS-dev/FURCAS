package com.sap.tc.moin.xm.generation.core.code.serializer.impl;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.xm.generation.core.code.serializer.template.ElementMethodNameAndParameterType;
import com.sap.tc.moin.xm.generation.core.code.serializer.template.QualifiedName;


public class ElementMethodNameAndParameterTypeImpl implements ElementMethodNameAndParameterType {


    private final String elementMethodName;

    private final String parameterType;

    private final QualifiedName elementQName;

    /**
     * Constructor.
     * 
     * @param aElementQName element QName which must be written to the output
     * stream before the method is called
     * @param methodName method name
     * @param qualifiedJavaClassNameOfParameterType
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public ElementMethodNameAndParameterTypeImpl( final QualifiedName aElementQName, final String methodName, final String qualifiedJavaClassNameOfParameterType ) {

        if ( methodName == null ) {
            throw new MoinNullPointerException( "methodName" ); //$NON-NLS-1$
        }
        if ( qualifiedJavaClassNameOfParameterType == null ) {
            throw new MoinNullPointerException( "qualifiedJavaClassNameOfParameterType" ); //$NON-NLS-1$
        }
        if ( aElementQName == null ) {
            throw new MoinNullPointerException( "aElementQName" ); //$NON-NLS-1$
        }
        this.elementMethodName = methodName;
        this.parameterType = qualifiedJavaClassNameOfParameterType;
        this.elementQName = aElementQName;

    }

    public String getElementMethodName( ) {

        return this.elementMethodName;
    }

    public String getParameterType( ) {

        return this.parameterType;
    }

    public QualifiedName getElementQName( ) {

        return this.elementQName;
    }

}
