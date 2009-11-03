package com.sap.tc.moin.xm.generation.core.metamodel.om;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.mmi.reflect.RefClassCalculatedMofId;
import com.sap.tc.moin.xm.generation.XmGeneratorInput;


public abstract class XmModelElementImpl implements XmModelElement {

    private final String xsdName;

    String mofName;

    ModelElement modelElement;

    private final XmNamespace xmNamespace;

    private final XmXsdComponentKind kind;

    private final XmGeneratorInput input;

    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    /**
     * Constructor.
     * 
     * @param aInput
     * @param xsdName
     * @param mofName
     * @param namespace
     * @param kind
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    XmModelElementImpl( final XmGeneratorInput aInput, final String xsdName, final String mofName, final XmNamespace namespace, final XmXsdComponentKind kind ) {

        if ( aInput == null ) {
            throw new MoinNullPointerException( "aInput" ); //$NON-NLS-1$
        }
        if ( xsdName == null ) {
            throw new MoinNullPointerException( "xsdName" ); //$NON-NLS-1$
        }
        if ( mofName == null ) {
            throw new MoinNullPointerException( "mofName" ); //$NON-NLS-1$
        }
        if ( kind == null ) {
            throw new MoinNullPointerException( "kind" ); //$NON-NLS-1$
        }
        if ( namespace == null ) {
            throw new MoinNullPointerException( "namespace" ); //$NON-NLS-1$
        }
        this.xsdName = xsdName;
        this.mofName = mofName;
        this.xmNamespace = namespace;
        this.kind = kind;
        this.xmNamespace.addContainedElement( this );
        this.input = aInput;
    }

    /**
     * Constructor for MOIN association.
     * 
     * @param aInput
     * @param mofName
     * @param namespace
     * @param kind throws NullPointerException if a parameter is
     * <code>null</code>
     */
    XmModelElementImpl( final XmGeneratorInput aInput, final String mofName, final XmNamespace namespace, final XmXsdComponentKind kind ) {

        if ( aInput == null ) {
            throw new MoinNullPointerException( "aInput" ); //$NON-NLS-1$
        }
        if ( mofName == null ) {
            throw new MoinNullPointerException( "mofName" ); //$NON-NLS-1$
        }
        if ( kind == null ) {
            throw new MoinNullPointerException( "kind" ); //$NON-NLS-1$
        }
        if ( namespace == null ) {
            throw new MoinNullPointerException( "namespace" ); //$NON-NLS-1$
        }
        this.xsdName = null;
        this.mofName = mofName;
        this.xmNamespace = namespace;
        this.kind = kind;
        this.xmNamespace.addContainedElement( this );
        this.input = aInput;
    }


    /**
     * Constructor for the root package and MOIN primitive types.
     * 
     * @param aInput
     * @param xsdName
     * @param mofName
     * @param xmNamespace
     * @param kind throws NullPointerException if a parameter is
     * <code>null</code>
     */
    XmModelElementImpl( final XmGeneratorInput aInput, final String xsdName, final String mofName, final XmXsdComponentKind kind ) {

        if ( aInput == null ) {
            throw new MoinNullPointerException( "aInput" ); //$NON-NLS-1$
        }
        if ( xsdName == null ) {
            throw new MoinNullPointerException( "xsdName" ); //$NON-NLS-1$
        }
        if ( mofName == null ) {
            throw new MoinNullPointerException( "mofName" ); //$NON-NLS-1$
        }
        if ( kind == null ) {
            throw new MoinNullPointerException( "kind" ); //$NON-NLS-1$
        }
        this.xsdName = xsdName;
        this.mofName = mofName;
        this.xmNamespace = null;
        this.kind = kind;
        this.input = aInput;
    }

    public String getXSDName( ) {

        return xsdName;
    }

    public void setMofName( final String mofName ) {

        this.mofName = mofName;
    }

    public String getMofName( ) {

        return mofName;
    }

    public XmXsdComponentKind getXsdComponentKind( ) {

        return this.kind;
    }

    /**
     * Returns the container of this object.
     * 
     * @return container, <code>null</code> if this instance is of type
     * {@link XmRootPackage}
     */
    public XmNamespace getNamespace( ) {

        return this.xmNamespace;
    }

    /**
     * Returns the generator input.
     * 
     * @return generator input, cannot be <code>null</code>
     */
    XmGeneratorInput getInput( ) {

        return this.input;
    }

    /**
     * Creates and returns a new instance of a MOF class represented by this
     * object.
     * <p>
     * The MOFID of the instance is calculated from {@link #mofName} and
     * {@link #xmNamespace}. More precisely: The prefix of the root package, and
     * the qualified name of the class instance are used as logical keys for the
     * MOFID calculation.
     * <p>
     * Remark: The MOFID calculation of MOIN includes the MOFID of the
     * meta-object (class) of the instance.
     * 
     * @param classDescriptor class descriptor
     * @return created instance; cannot be <code>null</code>
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    RefObject createClassInstance( final ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor ) {

        if ( this.getClass( ) == XmRootPackage.class ) {
            // tool package must be treated separately, because the java prefix would be not added in the logical key otherwise.
            final String javaPrefix = ( (XmRootPackage) this ).getJavaPrefix( );
            if ( javaPrefix.length( ) > 0 ) {
                return this.createClassInstance( classDescriptor, new String[] { javaPrefix, this.mofName } );
            } else {
                return this.createClassInstance( classDescriptor, this.mofName, this.xmNamespace );
            }
        } else {
            return this.createClassInstance( classDescriptor, this.mofName, this.xmNamespace );
        }
    }


    /**
     * Creates and returns a new instance of a MOF class, representing a
     * {@link RefObject} which is contained by an association. This is typicaly
     * an association end.
     * <p>
     * The MOFID of the instance is calculated. The prefix of the root package,
     * and the qualified name of the class instance are used as logical keys for
     * the MOFID calculation.
     * <p>
     * Remark: The MOFID calculation of MOIN includes the MOFID of the
     * meta-object (class) of the instance.
     * 
     * @param classDescriptor class descriptor
     * @param name MOF name of the instance to be created
     * @param xmAssociation representing the MOF association which will contain
     * the created instance
     * @return created instance; cannot be <code>null</code>
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    RefObject createClassInstance( final ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor, final String name, final XmAssociation xmAssociation ) {

        final String[] logicalKeyOfAssociation = this.calculateLogicalKey( xmAssociation.getMofName( ), xmAssociation.getNamespace( ) );
        final String[] logicalKey = new String[logicalKeyOfAssociation.length + 1];
        System.arraycopy( logicalKeyOfAssociation, 0, logicalKey, 0, logicalKeyOfAssociation.length );
        logicalKey[logicalKeyOfAssociation.length] = name;
        return this.createClassInstance( classDescriptor, logicalKey );
    }



    /**
     * Creates and returns a new instance of a MOF class, representing a
     * {@link RefObject}.
     * <p>
     * The MOFID of the instance is calculated. The prefix of the root package,
     * and the qualified name of the class instance are used as logical keys for
     * the MOFID calculation.
     * <p>
     * Remark: The MOFID calculation of MOIN includes the MOFID of the
     * meta-object (class) of the instance.
     * 
     * @param classDescriptor class descriptor
     * @param name MOF name of the instance to be created
     * @param aXmNamespace namespace of the object to be created
     * @return created instance; cannot be <code>null</code>
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    RefObject createClassInstance( final ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor, final String name, final XmNamespace aXmNamespace ) {

        return this.createClassInstance( classDescriptor, this.calculateLogicalKey( name, aXmNamespace ) );
    }

    private RefObject createClassInstance( final ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor, final String[] logicalKey ) {

        if ( classDescriptor == null ) {
            throw new NullPointerException( "classDescriptor is null" ); //$NON-NLS-1$
        }

        if ( logicalKey == null ) {
            throw new NullPointerException( "logicalKey is null" ); //$NON-NLS-1$
        }
        final RefClassCalculatedMofId clazz = (RefClassCalculatedMofId) this.input.getConnection( ).getClass( classDescriptor );
        return clazz.refCreateInstanceInPartition( this.input.getMetamodelPartition( ), logicalKey );
    }

    private ModelPackage modelPackage;

    MultiplicityType createMultiplicityType( final int lower, final int upper, final boolean isOrdered, final boolean isUnique ) {

        final StructureFieldContainer<MultiplicityType> container = new StructureFieldContainer<MultiplicityType>( );
        container.put( MultiplicityType.DESCRIPTORS.LOWER( ), lower );
        container.put( MultiplicityType.DESCRIPTORS.UPPER( ), upper );
        container.put( MultiplicityType.DESCRIPTORS.IS_ORDERED( ), isOrdered );
        container.put( MultiplicityType.DESCRIPTORS.IS_UNIQUE( ), isUnique );
        if ( this.modelPackage == null ) {
            this.modelPackage = input.getConnection( ).getPackage( ModelPackage.PACKAGE_DESCRIPTOR );
        }
        return this.modelPackage.createMultiplicityType( container );
    }

    /**
     * Calculates the logical key from the qualified name and the java prefix of
     * the root package.
     * 
     * @param name
     * @param xmNamespace, can be <code>null</code>
     * @return logical key, cannot be null, or empty
     * @throws NullPointerException if the name is <code>null</code>
     */
    private String[] calculateLogicalKey( final String name, final XmNamespace aXmNamespace ) {

        if ( name == null ) {
            throw new NullPointerException( "name is null" ); //$NON-NLS-1$
        }
        final List<String> result = new ArrayList<String>( );
        result.add( name );
        this.addNamespace( aXmNamespace, result );
        // reverse so that the name is at the end
        Collections.reverse( result );
        return result.toArray( EMPTY_STRING_ARRAY );
    }

    /**
     * Traverses the namespace path and adds the names of the namespaces to the
     * list. If the namespace is a root package, then also the prefix is added.
     * 
     * @param aXmNamespace namespace, can be <code>null</code>
     * @param result list
     * @throws NullPointerException if <tt>result</tt> is <code>null</code>
     */
    private void addNamespace( final XmNamespace aXmNamespace, final List<String> result ) {

        if ( aXmNamespace != null ) {
            result.add( aXmNamespace.getMofName( ) );
            if ( aXmNamespace.getClass( ) == XmRootPackage.class ) {
                final String javaPrefix = ( (XmRootPackage) aXmNamespace ).getJavaPrefix( );
                if ( javaPrefix.length( ) > 0 ) {
                    result.add( javaPrefix );
                }
            }
            // recursion
            this.addNamespace( aXmNamespace.getNamespace( ), result );
        }

    }

    @Override
    public String toString( ) {

        return this.getMofName( );
    }
}
