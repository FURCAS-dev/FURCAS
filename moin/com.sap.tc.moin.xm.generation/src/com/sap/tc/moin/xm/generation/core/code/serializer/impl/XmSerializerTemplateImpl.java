package com.sap.tc.moin.xm.generation.core.code.serializer.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.xm.generation.core.code.serializer.template.ComplexTypeMethod;
import com.sap.tc.moin.xm.generation.core.code.serializer.template.QualifiedName;
import com.sap.tc.moin.xm.generation.core.code.serializer.template.SubstitutionGroupMethod;
import com.sap.tc.moin.xm.generation.core.code.serializer.template.XmSerializerTemplate;
import com.sap.tc.moin.xm.generation.core.code.util.XmParserSerializerTemplateImpl;


public class XmSerializerTemplateImpl extends XmParserSerializerTemplateImpl implements XmSerializerTemplate {

    /* Contains the unique qualified names of the XML elements. */
    private final List<QualifiedName> elementQNames = new ArrayList<QualifiedName>( );

    /* Contains the unique qualified names of the XML attributes. */
    private final List<QualifiedName> attributeQNames = new ArrayList<QualifiedName>( );

    /** Method names to complex type methods and document root method. */
    private final Map<String, ComplexTypeMethodImpl> methodNames2ComplexTypeMethods = new LinkedHashMap<String, ComplexTypeMethodImpl>( );

    /** Method names to substitution group methods. */
    private final Map<String, SubstitutionGroupMethodImpl> methodNames2SubstitutionGroupMethods = new LinkedHashMap<String, SubstitutionGroupMethodImpl>( );

    private String methodNameOfDocumentRoot;

    /**
     * Constructor.
     * 
     * @param javaClassName
     * @param javaPackageName
     * @param schemaName
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public XmSerializerTemplateImpl( final String javaClassName, final String javaPackageName, final String schemaName ) {

        super( javaClassName, javaPackageName, schemaName );
    }

    /**
     * Adds a qualified XML element name.
     * 
     * @param qName qualified name
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    public void addElementQName( final QualifiedName qName ) {

        if ( qName == null ) {
            throw new MoinNullPointerException( "qName" ); //$NON-NLS-1$
        }
        if ( this.elementQNames.contains( qName ) ) {
            // do nothing
        } else {
            this.elementQNames.add( qName );
        }
    }

    /**
     * Adds a qualified XML attribute name.
     * 
     * @param qName qualified name
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    public void addAttributeQName( final QualifiedName qName ) {

        if ( qName == null ) {
            throw new MoinNullPointerException( "qName" ); //$NON-NLS-1$
        }
        if ( this.attributeQNames.contains( qName ) ) {
            // do nothing
        } else {
            this.attributeQNames.add( qName );
        }
    }



    public List<QualifiedName> getElementQNames( ) {

        return this.elementQNames;
    }

    public List<QualifiedName> getAttributeQNames( ) {

        return this.attributeQNames;
    }


    private static final List<String> EXTENDS_LIST = new ArrayList<String>( 1 );

    static {
        EXTENDS_LIST.add( "com.sap.tc.moin.repository.xm.serializer.XmCustomSerializerAbstract" ); //$NON-NLS-1$
    }

    public List<String> getExtends( ) {

        return EXTENDS_LIST;
    }


    public String getQualifiedClassNameOfRootMoinClass( ) {

        return this.methodNames2ComplexTypeMethods.get( this.methodNameOfDocumentRoot ).getQualifiedClassNameOfParameter( );
    }


    /**
     * Sets the method of the document root.
     * 
     * @param rootComplexTypeMethod method
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public void setRootMethod( final String documentRootMethodName ) {

        if ( documentRootMethodName == null ) {
            throw new MoinNullPointerException( "documentRootMethodName" ); //$NON-NLS-1$
        }
        this.methodNameOfDocumentRoot = documentRootMethodName;
    }


    /**
     * Adds a complex type method or the document root method.
     * 
     * @param method element method
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    public void addComplexTypeMethod( final ComplexTypeMethodImpl method ) {

        if ( method == null ) {
            throw new MoinNullPointerException( "method" ); //$NON-NLS-1$
        }
        this.methodNames2ComplexTypeMethods.put( method.getMethodName( ), method );
    }



    public String getMethodNameOfRootComplexType( ) {

        return this.methodNameOfDocumentRoot;
    }

    public Collection<? extends ComplexTypeMethod> getComplexTypeMethods( ) {

        return this.methodNames2ComplexTypeMethods.values( );
    }


    /**
     * Adds an substitution group method.
     * 
     * @param method element method
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    public void addSubstitutionGroupMethod( final SubstitutionGroupMethodImpl method ) {

        if ( method == null ) {
            throw new MoinNullPointerException( "method" ); //$NON-NLS-1$
        }
        this.methodNames2SubstitutionGroupMethods.put( method.getMethodName( ), method );
    }


    /**
     * Returns the map which contains as keys the method names and as values the
     * substitution group methods.
     * 
     * @return map, cannot be <code>null</code>
     */
    public Map<String, SubstitutionGroupMethodImpl> getSubstitutionGroupMethodMap( ) {

        return this.methodNames2SubstitutionGroupMethods;
    }



    public Collection<? extends SubstitutionGroupMethod> getSubstitutionGroupMethods( ) {

        return this.methodNames2SubstitutionGroupMethods.values( );
    }

}
