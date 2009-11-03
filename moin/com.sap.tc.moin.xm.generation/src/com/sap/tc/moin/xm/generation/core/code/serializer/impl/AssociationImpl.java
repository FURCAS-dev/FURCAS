package com.sap.tc.moin.xm.generation.core.code.serializer.impl;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.xm.generation.core.code.serializer.template.Association;
import com.sap.tc.moin.xm.generation.core.code.serializer.template.QualifiedName;


public class AssociationImpl implements Association {


    private final String endName;

    private final String methodName;

    private final String qualifiedClassName;

    private final QualifiedName elementQName;


    /**
     * Constructor.
     * 
     * @param qualifiedAssociationClassName
     * @param aEndName name of the association end which defines the referenced
     * side
     * @param qNameOfElement QName of the element which must be written to the
     * output stream for this association, is
     * <tt>null<tt> if the association references a substitution group head
     * @param aMethodName name of the method which must be called with a
     * referenced model element as parameter
     * @throws NullPointerException if a parameter except <tt>qNameOfElement
     * </tt> is <code>null</code>
     */
    AssociationImpl( final String qualifiedAssociationClassName, final String aEndName, final QualifiedName qNameOfElement, final String aMethodName ) {

        if ( qualifiedAssociationClassName == null ) {
            throw new MoinNullPointerException( "qualifiedAssociationClassName" ); //$NON-NLS-1$
        }
        if ( aEndName == null ) {
            throw new MoinNullPointerException( "aEndName" ); //$NON-NLS-1$
        }
        if ( aMethodName == null ) {
            throw new MoinNullPointerException( "aMethodName" ); //$NON-NLS-1$
        }
        this.qualifiedClassName = qualifiedAssociationClassName;
        this.methodName = aMethodName;
        this.endName = aEndName;
        this.elementQName = qNameOfElement;
    }

    public String getEndName( ) {

        return this.endName;
    }

    public String getMethodName( ) {

        return this.methodName;
    }

    public String getQualifiedAssociationClassName( ) {

        return this.qualifiedClassName;
    }

    public boolean isSimpleElement( ) {

        return false;
    }

    public QualifiedName getElementQName( ) {

        return this.elementQName;
    }

}
