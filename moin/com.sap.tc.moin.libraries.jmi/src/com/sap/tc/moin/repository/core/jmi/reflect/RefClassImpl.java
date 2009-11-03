package com.sap.tc.moin.repository.core.jmi.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;
import com.sap.tc.moin.repository.mmi.reflect.InvalidObjectException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.core.ClassExtent;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.MetamodelWorkspace;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.jmi.extension.RefClassExtension;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.mmi.reflect.RefClassCalculatedMofId;
import com.sap.tc.moin.repository.messages.jmi.impl.JmiBase;
import com.sap.tc.moin.repository.metamodels.DeploymentExtension;
import com.sap.tc.moin.repository.mql.FromEntry;
import com.sap.tc.moin.repository.mql.FromTypeMri;
import com.sap.tc.moin.repository.mql.MQLPreparedQuery;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLQuery;
import com.sap.tc.moin.repository.mql.SelectAlias;
import com.sap.tc.moin.repository.mql.SelectEntry;
import com.sap.tc.moin.repository.shared.util.QualifiedName;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.shared.util.Utilities.CalculatedMofIdAppl;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.spi.core.cps.SpiMetamodelService;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.SpiValueTypeEnum;
import com.sap.tc.moin.repository.transactions.microtransactionables.InstanceCreateMicroTransactionable;

/**
 * @author d024227
 */
public class RefClassImpl extends RefFeaturedImpl implements ClassExtent, RefClass, RefClassCalculatedMofId, RefClassExtension, SpiClass {

    /***************************************************************************
     * Caches for M2 information; called by Jmihelper
     **************************************************************************/

    /**
     * Cache for the structural features of this class.
     */
    private List<StructuralFeature> structuralFeatures;

    /**
     * Cache for the structural features of this class including those of
     * supertypes.
     */
    private List<StructuralFeature> allStructuralFeatures;

    /**
     * Cache for the attributes of this class.
     */
    private List<Attribute> attributes;

    /**
     * Cache for the attributes of this class including those of supertypes.
     */
    private List<Attribute> allAttributes;

    /**
     * Cache for the translatable text attributes of this class including those
     * of supertypes.
     */
    private List<Attribute> allTranslatableTextAttributes;

    /**
     * Cache for all StructureType-typed attributes of this class including
     * those of supertypes.
     */
    private List<Attribute> allStructureTypedAttributes;

    /**
     * Cache for the references of this class.
     */
    private List<Reference> references;

    /**
     * Cache for the references of this class including those of supertypes.
     */
    private List<Reference> allReferences;

    /**
     * Cache for all supertypes of this class.
     */
    private List<GeneralizableElement> allSupertypes;

    /**
     * Caches the qualified name in dot-separated String notation.
     */
    private String dotSeparatedQualifiedName;

    /**
     * Cache for all object-valued attributes of this class including those of
     * supertypes.
     */
    private List<Attribute> allObjectValuedAttributes;

    /***************************************************************************
     * other attributes (optionally to be set)
     **************************************************************************/

    private Set<AssociationEnd> unstoredCompositeParentAssociationEnds = null;

    private Set<AssociationEnd> unstoredCompositeChildAssociationEnds = null;

    /**
     * The cached result of {@link #___mayHaveParentLinkInOtherPartition()}
     */
    private boolean mayHaveParentLinkInOtherPartitionCache;

    /**
     * The cached result of {@link #___mayHaveChildLinkInOtherPartition()}
     */
    private boolean mayHaveChildLinkInOtherPartitionCache;

    /**
     * This is a useful cache for the refAllOfType and refAllOfClass queries
     */
    private MQLPreparedQuery preparedRefAllOfClassQuery;

    private MQLPreparedQuery preparedRefAllOfTypeQuery;

    /**
     * Constructor of the Impl class
     */
    private Constructor<RefObject> constructor;

    /***************************************************************************
     * constructors
     **************************************************************************/

    public RefClassImpl( ) {

        super( );
    }

    public RefClassImpl( String fullyQualifiedImplClassName ) {

        try {
            Class implClass = Class.forName( fullyQualifiedImplClassName );
            this.constructor = implClass.getConstructor( );
        } catch ( SecurityException e ) {
            throw new RuntimeException( e );
        } catch ( NoSuchMethodException e ) {
            throw new RuntimeException( e );
        } catch ( ClassNotFoundException e ) {
            throw new RuntimeException( e );
        }
    }

    public RefClassImpl( Object workspace, String mofId, RefPackage immediatePackage, RefObject metaObject ) {

        super( (Workspace) workspace, mofId, immediatePackage, metaObject, ( (Workspace) workspace ).getPartitionManager( ).getExtentPartition( ) );
    }

    public RefClassImpl( Object workspace, String mofId, RefPackage immediatePackage, RefObject metaObject, Class implClass ) {

        super( (Workspace) workspace, mofId, immediatePackage, metaObject, ( (Workspace) workspace ).getPartitionManager( ).getExtentPartition( ) );
        try {
            this.constructor = implClass.getConstructor( );
        } catch ( SecurityException e ) {
            throw new RuntimeException( e );
        } catch ( NoSuchMethodException e ) {
            throw new RuntimeException( e );
        }
    }

    @Override
    public MofClass refMetaObject( ) {

        return (MofClass) super.refMetaObject( );
    }

    /***************************************************************************
     * ClassExtent methods
     **************************************************************************/

    public List<StructuralFeature> get___StructuralFeatures( ) {

        return this.structuralFeatures;
    }

    public List<StructuralFeature> get___AllStructuralFeatures( ) {

        return this.allStructuralFeatures;
    }

    public void set___StructuralFeatures( List<StructuralFeature> features ) {

        this.structuralFeatures = features;
    }

    public void set___AllStructuralFeatures( List<StructuralFeature> features ) {

        this.allStructuralFeatures = features;
    }

    public List<Attribute> get___Attributes( ) {

        return this.attributes;
    }

    public List<Attribute> get___AllAttributes( ) {

        return this.allAttributes;
    }

    public List<Attribute> get___AllTranslatableTextAttributes( ) {

        return this.allTranslatableTextAttributes;
    }

    public List<Attribute> get___AllStructureTypedAttributes( ) {

        return this.allStructureTypedAttributes;
    }

    public List<Attribute> get___AllObjectValuedAttributes( ) {

        return this.allObjectValuedAttributes;
    }

    public void set___AllAttributes( List<Attribute> attrs ) {

        this.allAttributes = attrs;
    }

    public void set___AllTranslatableTextAttributes( List<Attribute> textAttrs ) {

        this.allTranslatableTextAttributes = textAttrs;
    }

    public void set___AllStructureTypedAttributes( List<Attribute> attributes ) {

        this.allStructureTypedAttributes = attributes;
    }

    public void set___AllObjectValuedAttributes( List<Attribute> attributes ) {

        this.allObjectValuedAttributes = attributes;
    }

    public void set___Attributes( List<Attribute> attrs ) {

        this.attributes = attrs;
    }

    public List<Reference> get___AllReferences( ) {

        return this.allReferences;
    }

    public List<Reference> get___References( ) {

        return this.references;
    }

    public void set___AllReferences( List<Reference> refs ) {

        this.allReferences = refs;
    }

    public void set___References( List<Reference> refs ) {

        this.references = refs;
    }

    public List<GeneralizableElement> get___AllSupertypes( ) {

        return this.allSupertypes;
    }

    public void set___AllSupertypes( List<GeneralizableElement> types ) {

        this.allSupertypes = types;
    }

    /***************************************************************************
     * other methods
     **************************************************************************/

    /**
     * Returns either the Attribute or the Reference specified by its name
     * 
     * @param name the name of the Attribute or Reference
     * @return the Attribute or Reference specified by name
     */
    @Override
    public final synchronized RefObject get___AttributeOrReferenceByName( String name ) {

        MofClass mc = refMetaObject( );

        for ( Iterator<Attribute> i = get___JmiHelper( ).getAttributes( mc, true ).iterator( ); i.hasNext( ); ) {
            Attribute a = i.next( );
            if ( name.equals( a.getName( ) ) ) {
                return a;
            }
        }
        for ( Reference r : get___JmiHelper( ).getReferences( mc, null, true ) ) {
            if ( name.equals( r.getName( ) ) ) {
                return r;
            }
        }

        throw new MoinLocalizedBaseRuntimeException( JmiReflectMessages.ATTRIBUTEORREFNOTFOUNDINEXTENT, name, this.toString( ) );

    }

    /**
     * Returns either the Attribute or the AssociationEnd specified by either
     * the Attribute's name or the name of the Reference referencing the
     * AssociationEnd.
     * 
     * @param name the name of the Attribute or Reference
     * @return the Attribute or AssociationEnd specified by name
     */
    @Override
    public final RefObject get___AttributeOrAssociationEndByName( String name ) {

        RefObject result = get___AttributeOrReferenceByName( name );
        if ( result instanceof Reference ) {
            // turn into AssociationEnd
            result = ( (Reference) result ).getReferencedEnd( );
        }
        if ( result == null ) {
            throw new MoinLocalizedBaseRuntimeException( JmiReflectMessages.ATTRIBUTEORASSOCENDNOTFOUNDFORNAME, name );
        }

        return result;
    }

    @Override
    public final MetamodelWorkspace get___Workspace( ) {

        // an extent is always in the metamodel workspace
        return (MetamodelWorkspace) this.___workspace;
    }

    /***************************************************************************
     * ref methods
     **************************************************************************/

    @Deprecated
    public final RefObject refCreateInstance( List<? extends Object> args ) {

        return refCreateInstance( get___CurrentConnection( ), args );
    }

    @Deprecated
    public final RefObject refCreateInstance( ) {

        return refCreateInstance( get___CurrentConnection( ), null );
    }

    @Deprecated
    public final RefObject refCreateInstanceInPartition( List<? extends Object> args, ModelPartition partition ) {

        return refCreateInstanceInPartition( get___CurrentConnection( ), args, partition );
    }

    @Deprecated
    public final RefObject refCreateInstanceInPartition( ModelPartition partition ) {

        return refCreateInstanceInPartition( get___CurrentConnection( ), null, partition );
    }

    public final RefObject refCreateInstance( CoreConnection connection, List<? extends Object> args ) {

        return refCreateInstanceInPartition( connection, args, connection.getNullPartition( ) );
    }

    public final RefObject refCreateInstanceInPartition( CoreConnection connection, List<? extends Object> args, ModelPartition partition ) {

        InstanceCreateMicroTransactionable icmtx = get___MicroTransactionableFactory( ).createInstanceCreateMicroTransactionable( connection, this, args, (CoreModelPartition) partition );
        connection.getSession( ).getTransactionManager( ).runInMicroTransaction( icmtx );
        return icmtx.getInstanceCreated( );
    }

    public final RefObject refCreateInstance( String[] logicalKey ) {

        return refCreateInstance( get___CurrentConnection( ), null, logicalKey );
    }

    public final RefObject refCreateInstanceInPartition( ModelPartition partition, String... logicalKey ) {

        throw new UnsupportedOperationException( );
    }

    public final RefObject refCreateInstanceInPartition( CoreConnection connection, List args, String[] logicalKey, ModelPartition partition ) {

        String calculatedMofId = calculateMofId( logicalKey );
        InstanceCreateMicroTransactionable icmtx = get___MicroTransactionableFactory( ).createInstanceCreateMicroTransactionable( connection, this, args, (CoreModelPartition) partition, calculatedMofId );
        connection.getSession( ).getTransactionManager( ).runInMicroTransaction( icmtx );
        return icmtx.getInstanceCreated( );
    }

    public final RefObject refCreateInstanceInPartitionWithMofId( CoreConnection connection, List args, String mofId, ModelPartition partition ) {

        InstanceCreateMicroTransactionable icmtx = get___MicroTransactionableFactory( ).createInstanceCreateMicroTransactionable( connection, this, args, (CoreModelPartition) partition, mofId );
        connection.getSession( ).getTransactionManager( ).runInMicroTransaction( icmtx );
        return icmtx.getInstanceCreated( );
    }

    public RefObject refCreateInstanceInPartition( ModelPartition partition, ClassDescriptor<?, ?> superClassDescriptor, String... logicalKey ) {

        throw new UnsupportedOperationException( );
    }

    public RefObject refCreateInstanceInPartition( CoreConnection connection, String[] logicalKey, ClassDescriptor<?, ?> superClassDescriptor, ModelPartition partition ) {

        String calculatedMofId = calculateMofId( connection, logicalKey, superClassDescriptor );
        InstanceCreateMicroTransactionable icmtx = get___MicroTransactionableFactory( ).createInstanceCreateMicroTransactionable( connection, this, null, (CoreModelPartition) partition, calculatedMofId );
        connection.getSession( ).getTransactionManager( ).runInMicroTransaction( icmtx );
        return icmtx.getInstanceCreated( );
    }

    public final RefObject refCreateInstance( CoreConnection connection, List<? extends Object> args, String[] logicalKey ) {

        String calculatedMofId = calculateMofId( logicalKey );
        InstanceCreateMicroTransactionable icmtx = get___MicroTransactionableFactory( ).createInstanceCreateMicroTransactionable( connection, this, args, connection.getNullPartition( ), calculatedMofId );
        connection.getSession( ).getTransactionManager( ).runInMicroTransaction( icmtx );
        return icmtx.getInstanceCreated( );
    }

    public final String calculateMofId( String... logicalKey ) {

        return calculateMofId( logicalKey, refMetaObject( ).refMofId( ) );
    }

    public final String calculateMofId( ClassDescriptor<?, ?> superClassDescriptor, String... logicalKey ) {

        throw new UnsupportedOperationException( );
    }

    public final String calculateMofId( CoreConnection connection, String[] logicalKey, ClassDescriptor classDescriptor ) {

        if ( classDescriptor == null ) {
            return calculateMofId( logicalKey, refMetaObject( ).refMofId( ) );
        }

        boolean isSuperType = false;
        if ( classDescriptor.getMofIdOfMetaObject( ) == refMetaObject( ).refMofId( ) ) {
            isSuperType = true;
        } else {
            List<GeneralizableElement> supertypes = connection.getCoreJmiHelper( ).getAllSupertypes( connection.getSession( ), refMetaObject( ) );
            for ( GeneralizableElement superType : supertypes ) {
                if ( classDescriptor.getMofIdOfMetaObject( ) == superType.refMofId( ) ) {
                    isSuperType = true;
                    break;
                }
            }
        }

        if ( !isSuperType ) {
            throw new MoinIllegalArgumentException( JmiReflectMessages.CLASSNOTSUPERCLASS, classDescriptor.getQualifiedName( ), ( this.refMetaObject( ) ).getName( ) );
        }

        RefClass rc = connection.getClass( classDescriptor );
        return calculateMofId( logicalKey, rc.refMetaObject( ).refMofId( ) );
    }

    /**
     * @param logicalKey
     * @return the MofId
     */
    public static final String calculateMofId( String[] logicalKey, String mofIdOfClassOrSuperClass ) {

        String myLocality = mofIdOfClassOrSuperClass;
        String[] myLogicalKey = new String[logicalKey != null ? logicalKey.length + 1 : 1];
        myLogicalKey[0] = mofIdOfClassOrSuperClass;
        if ( logicalKey != null ) {
            System.arraycopy( logicalKey, 0, myLogicalKey, 1, logicalKey.length );
        }
        return Utilities.getUtilities( ).calculateMofId( CalculatedMofIdAppl.EXTERNAL, myLocality, myLogicalKey );
    }

    /**
     * @see com.sap.tc.moin.repository.mmi.reflect.RefClass#refAllOfType()
     */
    public final Collection<RefObject> refAllOfType( ) {

        return refAllOfType( get___CurrentConnection( ) );
    }

    public final Collection<RefObject> refAllOfType( CoreConnection connection ) {

        // get the MQL processor
        MQLProcessor mql = connection.getMQLProcessor( );

        MRI[] mris = mql.execute( this.prepareRefQuery( mql, true ) ).getMris( "thisClass" ); //$NON-NLS-1$

        List<RefObject> refObjects = new ArrayList<RefObject>( mris.length );
        for ( int i = 0; i < mris.length; i++ ) {
            RefObject refObj = (RefObject) connection.getElement( mris[i] );
            if ( refObj == null ) {
                throw new InvalidObjectException( null, JmiBase.REFALLOFTYPECONTAINEDNULL, mris[i].toString( ) );
            }
            refObjects.add( i, refObj );
        }

        return refObjects;
    }

    /**
     * @see com.sap.tc.moin.repository.mmi.reflect.RefClass#refAllOfClass()
     */
    public final Collection<RefObject> refAllOfClass( ) {

        return refAllOfClass( get___CurrentConnection( ) );
    }

    public final Collection<RefObject> refAllOfClass( CoreConnection connection ) {

        MQLProcessor mql = connection.getMQLProcessor( );
        MRI[] mris = mql.execute( this.prepareRefQuery( mql, false ) ).getMris( "thisClass" ); //$NON-NLS-1$

        List<RefObject> refObjects = new ArrayList<RefObject>( mris.length );
        for ( int i = 0; i < mris.length; i++ ) {
            RefObject refObj = (RefObject) connection.getElement( mris[i] );
            if ( refObj == null ) {
                throw new InvalidObjectException( null, JmiBase.REFALLOFCLASSCONTAINEDNULL, mris[i].toString( ) );
            }
            refObjects.add( i, refObj );
        }

        return refObjects;
    }

    private MQLPreparedQuery prepareRefQuery( MQLProcessor mql, boolean includeSubtypes ) {

        MQLPreparedQuery preparedQuery = null;
        if ( includeSubtypes ) {
            preparedQuery = this.preparedRefAllOfTypeQuery;
        } else {
            preparedQuery = this.preparedRefAllOfClassQuery;
        }

        if ( preparedQuery == null ) {
            // first time usage
            MRI mriOfMofClass = ( (Partitionable) refMetaObject( ) ).get___Mri( );

            // define the types in which you are interested
            FromTypeMri typeA = new FromTypeMri( "thisClass", mriOfMofClass, !includeSubtypes ); //$NON-NLS-1$
            // define what you want of it (in this case only its MRI, no attributes)
            SelectAlias selectA = new SelectAlias( "thisClass" ); //$NON-NLS-1$
            // compose the query
            MQLQuery query = new MQLQuery( new SelectEntry[] { selectA }, new FromEntry[] { typeA } );

            preparedQuery = mql.prepare( query );

            if ( includeSubtypes ) {
                this.preparedRefAllOfTypeQuery = preparedQuery;
            } else {
                this.preparedRefAllOfClassQuery = preparedQuery;
            }
        }

        return preparedQuery;
    }

    @Deprecated
    public final RefStruct refCreateStruct( RefObject struct, List<? extends Object> params ) {

        return ref___CreateStruct( get___CurrentConnection( ), struct, params );
    }

    public final RefStruct refCreateStruct( CoreConnection connection, RefObject struct, List<? extends Object> params ) {

        return ref___CreateStruct( connection, struct, params );
    }

    @Deprecated
    public final RefStruct refCreateStruct( String structName, List<? extends Object> params ) {

        return refCreateStruct( get___CurrentConnection( ), structName, params );
    }

    public final RefStruct refCreateStruct( CoreConnection connection, String structName, List<? extends Object> params ) {

        return ref___CreateStruct( connection, structName, params );
    }

    @Deprecated
    public final RefEnum refGetEnum( RefObject enumType, String name ) {

        return ref___GetEnum( get___CurrentConnection( ), enumType, name );
    }

    public final RefEnum refGetEnum( CoreConnection connection, RefObject enumType, String name ) {

        return ref___GetEnum( connection, enumType, name );
    }

    @Deprecated
    public final RefEnum refGetEnum( String enumName, String name ) {

        return ref___GetEnum( get___CurrentConnection( ), enumName, name );
    }

    public final RefEnum refGetEnum( CoreConnection connection, String enumName, String name ) {

        return ref___GetEnum( connection, enumName, name );
    }

    /***************************************************************************
     * java.lang.Object level methods
     **************************************************************************/

    @Override
    public String toString( ) {

        StringBuffer result = new StringBuffer( );
        result.append( "{RefClass" ); //$NON-NLS-1$
        result.append( " " ); //$NON-NLS-1$
        if ( refMetaObject( ) != null ) {
            List<String> qn = refMetaObject( ).getQualifiedName( );
            result.append( "\"" ); //$NON-NLS-1$
            for ( Iterator<String> i = qn.iterator( ); i.hasNext( ); ) {
                String name = i.next( );
                result.append( name + ( i.hasNext( ) ? "::" : "" ) ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            result.append( "\"" ); //$NON-NLS-1$
        } else {
            result.append( "\"<?>\"" ); //$NON-NLS-1$
        }
        result.append( " " ); //$NON-NLS-1$
        result.append( refMofId( ) );
        result.append( "}" ); //$NON-NLS-1$
        return result.toString( );
    }

    /***************************************************************************
     * private methods
     **************************************************************************/

    public boolean is___Singleton( ) {

        // check the isSingleton
        MofClass mc = refMetaObject( );
        if ( mc != null && mc.isSingleton( ) ) {
            return true;
        }
        return false;
    }

    public boolean is___Abstract( ) {

        // check the isAbstract
        MofClass mc = refMetaObject( );
        if ( mc != null && mc.isAbstract( ) ) {
            return true;
        }
        return false;
    }

    /**
     * Checks if this instance may have a link to a composite parent that may be
     * stored only in a partition different from that holding this model
     * element. This is the case if there exists a composite association with
     * this element's class (or a superclass thereof) on the component (child)
     * end that has no storage for the component (child) end.
     * <p>
     * The results of this operation are cached for this class extent.
     * 
     * @return <tt>true</tt> if and only if this instance may be linked to a
     * composite parent by a link that is not stored in the partition holding
     * this model element.
     * <p>
     */
    public final synchronized boolean ___mayHaveParentLinkInOtherPartition( CoreSession session ) {

        if ( this.unstoredCompositeChildAssociationEnds == null ) {
            MofClass mc = refMetaObject( );

            this.unstoredCompositeChildAssociationEnds = get___JmiHelper( ).getUnstoredCompositeAssociationEndsOnChild( session, mc, /* includeSupertypes */
            true, /* findFirstOnly */
            false );
            /*
             * Note that attributes are always stored on both ends. Therefore,
             * they don't qualify as a case where this object may have a
             * composite parent without local storage of the composite link.
             */
            this.mayHaveParentLinkInOtherPartitionCache = this.unstoredCompositeChildAssociationEnds.size( ) > 0;
        }
        return this.mayHaveParentLinkInOtherPartitionCache;
    }

    /**
     * Checks if this instance may have a link to a composite parent that may be
     * stored only in a partition different from that holding this model
     * element. This is the case if there exists a composite association with
     * this element's class (or a superclass thereof) on the component (child)
     * end that has no storage for the component (child) end.
     * <p>
     * The results of this operation are cached for this class extent.
     * 
     * @return <tt>true</tt> if and only if this instance may be linked to a
     * composite parent by a link that is not stored in the partition holding
     * this model element.
     * <p>
     * @throws JmiException with cause NameNotFoundException in case the
     * IsOfType association couldn't be resolved which is required to determine
     * the association ends on <tt>classifier</tt>. This is typically the case
     * during the construction of the MOF ROM.
     */
    public final synchronized boolean ___mayHaveChildLinkInOtherPartition( CoreSession session ) {

        if ( this.unstoredCompositeParentAssociationEnds == null ) {
            MofClass mc = refMetaObject( );
            this.unstoredCompositeParentAssociationEnds = get___JmiHelper( ).getUnstoredCompositeAssociationEndsOnParent( session, mc, /* includeSupertypes */
            true, /* findFirstOnly */false );
            /*
             * Note that attributes are always stored on both ends. Therefore,
             * they don't qualify as a case where this object may have a
             * composite parent without local storage of the composite link.
             */
            this.mayHaveChildLinkInOtherPartitionCache = this.unstoredCompositeParentAssociationEnds.size( ) > 0;

        }
        return this.mayHaveChildLinkInOtherPartitionCache;
    }

    public final Set<AssociationEnd> get___UnstoredCompositeChildAssociationEnds( CoreSession session ) {

        if ( this.___mayHaveParentLinkInOtherPartition( session ) ) {
            return this.unstoredCompositeChildAssociationEnds;
        }
        return Collections.emptySet( );

    }

    public final Set<AssociationEnd> get___UnstoredCompositeParentAssociationEnds( CoreSession session ) {

        if ( this.___mayHaveChildLinkInOtherPartition( session ) ) {
            return this.unstoredCompositeParentAssociationEnds;
        }
        return Collections.emptySet( );

    }

    @Override
    protected final Collection<JmiException> refVerifyConstraints( CoreConnection connection, boolean deepVerify ) {

        Collection<JmiException> result = super.refVerifyConstraints( connection, deepVerify );

        if ( deepVerify ) {
            Collection<RefObject> c = new LinkedList<RefObject>( this.refAllOfClass( connection ) );
            for ( RefObject innerO : c ) {
                result.addAll( innerO.refVerifyConstraints( deepVerify ) );
            }
        }

        return result;
    }

    public final void ___refresh( ) {

        this.unstoredCompositeChildAssociationEnds = null;
        this.unstoredCompositeParentAssociationEnds = null;
    }

    @Override
    public final void set___Value( Session session, int featureNumber, Object value ) {

        throw new MoinUnsupportedOperationException( JmiReflectMessages.NOTPOSSIBLETOCALLTHISMETHOD, this.getClass( ) );

    }

    //
    // Custom Parser / Serializer methods 
    // 

    private Map<String, Attribute> attributesOfMofClass;

    private Map<Attribute, SpiValueTypeEnum> attributeTypes;

    private List<String> attributeNames;

    private Set<String> objectValuedAttributeNames;

    public String get___MofId( ) {

        return refMetaObject( ).refMofId( );
    }

    public String get___QualifiedName( ) {

        if ( this.dotSeparatedQualifiedName == null ) {
            RefObjectImpl refObj = (RefObjectImpl) refMetaObject( );
            DeploymentExtension deploymentExtension = refObj.get___DeploymentExtension( );
            List<String> qNameAsList = deploymentExtension.getMofIdQualifiedNameMapping( ).get( refObj.refMofId( ) );
            this.dotSeparatedQualifiedName = QualifiedName.toDotSeparatedString( qNameAsList );
        }
        return this.dotSeparatedQualifiedName;
    }

    public String get___MetamodelContainer( ) {

        return ( (Partitionable) refMetaObject( ) ).get___Partition( ).getPri( ).getContainerName( );
    }

    @SuppressWarnings( "unchecked" )
    public List<SpiType> get___AllSuperTypes( ) {

        List<GeneralizableElement> supertypes = get___JmiHelper( ).getAllSupertypes( null /* session */, refMetaObject( ) );
        if ( !supertypes.isEmpty( ) ) {
            List result = new ArrayList( supertypes.size( ) );
            for ( int i = 0, n = supertypes.size( ); i < n; i++ ) {
                MofClass mc = (MofClass) supertypes.get( i );
                result.add( get___JmiHelper( ).getRefClassForMofClass( null /* session */, mc ) );
            }
            return result;
        }
        return Collections.emptyList( );
    }

    public SpiValueTypeEnum get___AttributeTypeAsEnum( String attributeName ) {

        Attribute attribute = getOrComputeAttributes( ).get( attributeName );
        if ( attribute == null ) {
            throw new MoinIllegalArgumentException( JmiReflectMessages.ATTRIBUTEORASSOCENDNOTFOUNDFORNAME, attributeName );
        }
        return getOrComputeAttributeTypes( ).get( attribute );
    }

    public SpiType get___AttributeType( String attributeName ) {

        AttributeInternal attribute = (AttributeInternal) getOrComputeAttributes( ).get( attributeName );
        if ( attribute == null ) {
            throw new MoinIllegalArgumentException( JmiReflectMessages.ATTRIBUTEORASSOCENDNOTFOUNDFORNAME, attributeName );
        }
        Classifier attributeType = attribute.getType( /* connection */null );
        if ( attributeType instanceof MofClass ) {
            return (SpiType) get___JmiHelper( ).getRefClassForMofClass( null /* session */, (MofClass) attributeType );
        }
        return get___Workspace( ).getWorkspaceSet( ).getMoin( ).getCore( ).getMetamodelService( ).getSpiType( attributeType );
    }

    public List<String> get___AttributeNames( ) {

        if ( this.attributeNames == null ) {
            SpiJmiHelper jmiHelper = get___JmiHelper( );
            List<Attribute> attrs = jmiHelper.getAttributes( null /* session */, refMetaObject( ), true /* includeSuperTypes */);
            int size = attrs.size( );
            this.attributeNames = new ArrayList<String>( size );
            boolean initObjectValuedAttributes = ( this.objectValuedAttributeNames == null );
            if ( initObjectValuedAttributes ) {
                objectValuedAttributeNames = new HashSet<String>( 6 );
            }
            for ( int i = 0; i < size; i++ ) {
                Attribute attribute = attrs.get( i );
                if ( !attribute.isDerived( ) ) {
                    this.attributeNames.add( attribute.getName( ) );
                }
                if ( initObjectValuedAttributes && jmiHelper.getNonAliasType( null /* session */, attribute ) instanceof MofClass ) {
                    this.objectValuedAttributeNames.add( attribute.getName( ) );
                }
            }
        }
        return this.attributeNames;
    }

    public boolean is___MultiValuedAttribute( String attributeName ) {

        Attribute attribute = getOrComputeAttributes( ).get( attributeName );
        if ( attribute == null ) {
            throw new MoinIllegalArgumentException( JmiReflectMessages.ATTRIBUTEORASSOCENDNOTFOUNDFORNAME, attributeName );
        }
        return attribute.getMultiplicity( ).getUpper( ) != 1;
    }

    public boolean is___ObjectValuedAttribute( String attributeName ) {

        if ( this.objectValuedAttributeNames == null ) {
            objectValuedAttributeNames = new HashSet<String>( 6 );
            SpiJmiHelper jmiHelper = get___JmiHelper( );
            List<Attribute> attrs = jmiHelper.getAttributes( null /* session */, refMetaObject( ), true /* includeSuperTypes */);
            for ( int i = 0, n = attrs.size( ); i < n; i++ ) {
                Attribute attribute = attrs.get( i );
                if ( jmiHelper.getNonAliasType( null /* session */, attribute ) instanceof MofClass ) {
                    this.objectValuedAttributeNames.add( attribute.getName( ) );
                }
            }
        }
        return this.objectValuedAttributeNames.contains( attributeName );
    }

    public Attribute getAttribute( String attributeName ) {

        return getOrComputeAttributes( ).get( attributeName );
    }

    public String get___AttributeMofId( String attributeName ) {

        Attribute attribute = getOrComputeAttributes( ).get( attributeName );
        if ( attribute == null ) {
            throw new MoinIllegalArgumentException( JmiReflectMessages.ATTRIBUTEORASSOCENDNOTFOUNDFORNAME, attributeName );
        }
        return attribute.refMofId( );
    }

    private Map<String, Attribute> getOrComputeAttributes( ) {

        if ( this.attributesOfMofClass == null ) {
            List<Attribute> attrs = get___JmiHelper( ).getAttributes( null /* session */, refMetaObject( ), true /* includeSuperTypes */);
            if ( attrs.isEmpty( ) ) {
                this.attributesOfMofClass = Collections.emptyMap( );
            } else {
                this.attributesOfMofClass = new LinkedHashMap<String, Attribute>( Utilities.calcInitialCapacity( attrs.size( ) ) );
                for ( int i = 0, n = attrs.size( ); i < n; i++ ) {
                    Attribute attribute = attrs.get( i );
                    this.attributesOfMofClass.put( attribute.getName( ), attribute );
                }
            }
        }
        return this.attributesOfMofClass;
    }

    private Map<Attribute, SpiValueTypeEnum> getOrComputeAttributeTypes( ) {

        if ( this.attributeTypes == null ) {
            Map<String, Attribute> attrs = getOrComputeAttributes( );
            if ( attrs.isEmpty( ) ) {
                this.attributeTypes = Collections.emptyMap( );
            } else {
                this.attributeTypes = new IdentityHashMap<Attribute, SpiValueTypeEnum>( attrs.size( ) );
                SpiJmiHelper jmiHelper = get___JmiHelper( );
                SpiMetamodelService metamodelService = get___Workspace( ).getWorkspaceSet( ).getMoin( ).getCore( ).getMetamodelService( );
                for ( Attribute attribute : attrs.values( ) ) {
                    Classifier type = jmiHelper.getNonAliasType( null /* session */, attribute );
                    SpiValueTypeEnum attrType = metamodelService.getValueType( type );
                    this.attributeTypes.put( attribute, attrType );
                }
            }
        }
        return this.attributeTypes;
    }

    public RefObject get___Instance( ) {

        try {
            return constructor.newInstance( );
        } catch ( IllegalArgumentException e ) {
            return null;
        } catch ( InstantiationException e ) {
            return null;
        } catch ( IllegalAccessException e ) {
            return null;
        } catch ( InvocationTargetException e ) {
            return null;
        }
    }

    @Override
    public Wrapper<? extends RefBaseObject> createWrapper( CoreConnection conn, boolean synchronize ) {

        return new RefClassWrapperImpl( conn, this, synchronize );
    }

    @Override
    public com.sap.tc.moin.repository.mmi.reflect.RefEnum create___RefEnum( com.sap.tc.moin.repository.mmi.model.EnumerationType enumType, String name ) {

        java.lang.String enumName = enumType.getName( );
        if ( enumName.equals( "EvaluationKind" ) ) { //$NON-NLS-1$
            return com.sap.tc.moin.repository.mmi.model.EvaluationKindEnum.forName( name );
        }
        return super.create___RefEnum( enumType, name );
    }
}