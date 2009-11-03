package com.sap.tc.moin.repository.core.jmi.reflect;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.Extent;
import com.sap.tc.moin.repository.core.ExtentManager;
import com.sap.tc.moin.repository.core.MetamodelWorkspace;
import com.sap.tc.moin.repository.core.PackageExtent;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.jmi.extension.RefPackageExtension;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.messages.jmi.impl.JmiBase;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.model.__impl.ImportImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageImpl;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidNameException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

/**
 * @author d024227
 */
public abstract class RefPackageImpl extends RefBaseObjectImpl implements PackageExtent, RefPackage, RefPackageExtension {

    protected final class RefPackageAndName {

        /** Name */
        public String name = null;

        /** Java Class Name */
        public String javaClassNameQualified = null;

        /** Imported */
        public boolean imported = false;

        /** WeakReference to RefPackage */
        public WeakReference<RefPackage> refPackage = null;

        /**
         * @param name
         * @param javaClassNameQualified
         * @param imported
         */
        public RefPackageAndName( String name, String javaClassNameQualified, boolean imported ) {

            this.name = name;
            this.javaClassNameQualified = javaClassNameQualified;
            this.imported = imported;
            this.refPackage = null;
        }
    }

    protected final class RefClassAndName {

        /** Name */
        public String name = null;

        /** Java Class name */
        public String javaClassNameQualified = null;

        /** WeakReference to RefClass */
        public WeakReference<RefClass> refClass = null;

        /**
         * @param name
         * @param javaClassNameQualified
         */
        public RefClassAndName( String name, String javaClassNameQualified ) {

            this.name = name;
            this.javaClassNameQualified = javaClassNameQualified;
            this.refClass = null;
        }
    }

    protected final class RefAssociationAndName {

        /** Name */
        public String name = null;

        /** Java Class Name */
        public String javaClassNameQualified = null;

        /** WeakReference to RefAssociation */
        public WeakReference<RefAssociation> refAssociation = null;

        /**
         * @param name
         * @param javaClassNameQualified
         */
        public RefAssociationAndName( String name, String javaClassNameQualified ) {

            this.name = name;
            this.javaClassNameQualified = javaClassNameQualified;
            this.refAssociation = null;
        }
    }

    protected List<RefPackageAndName> ___refPackages = null;

    protected Map<String, RefPackageAndName> ___refPackagesByName = null;

    protected List<RefClassAndName> ___refClasses = null;

    protected Map<String, RefClassAndName> ___refClassesByName = null;

    protected List<RefAssociationAndName> ___refAssociations = null;

    protected Map<String, RefAssociationAndName> ___refAssociationsByName = null;

    /***************************************************************************
     * Caches for M2 information; called by Jmihelper
     **************************************************************************/

    /**
     * Cache for all supertypes of this class.
     */
    private List<GeneralizableElement> allSupertypes;

    public RefPackageImpl( ) {

        super( );
        initialize( );
    }

    public RefPackageImpl( Object workspace, String mofId, RefPackage immediatePackage, RefObject metaObject ) {

        super( (Workspace) workspace, mofId, immediatePackage, metaObject, ( (Workspace) workspace ).getPartitionManager( ).getExtentPartition( ) );
        initialize( );
    }

    @Override
    public MofPackage refMetaObject( ) {

        return (MofPackage) super.refMetaObject( );
    }

    /***************************************************************************
     * PackageExtent methods
     **************************************************************************/

    public List<GeneralizableElement> get___AllSupertypes( ) {

        return allSupertypes;
    }

    public void set___AllSupertypes( List<GeneralizableElement> types ) {

        allSupertypes = types;
    }

    @Deprecated
    public final RefClass refClass( RefObject type ) {

        return refClass( (CoreConnection) null, type );
    }

    public final RefClass refClass( CoreConnection connection, RefObject type ) {

        //FIXME remove connection from signature
        if ( type instanceof Classifier ) {
            return refClass( ( (Classifier) type ).getName( ) );
        }
        throw new InvalidCallException( type, null, "refClass()" ); //$NON-NLS-1$
    }


    public final RefClass refClass( String typeName ) {

        return refClass( (CoreConnection) null, typeName );
    }

    public final RefClass refClass( CoreConnection connection, String typeName ) {

        //FIXME remove connection from signature
        if ( typeName == null ) {
            throw new InvalidCallException( typeName, null, "refClass()" ); //$NON-NLS-1$
        }
        RefClass rc = null;
        RefClassAndName rcan = this.___refClassesByName.get( typeName );
        if ( rcan != null ) {
            if ( rcan.refClass != null ) {
                rc = rcan.refClass.get( );
            }
            if ( rc == null ) {
                rc = create___RefClass( rcan );
                rcan.refClass = new WeakReference<RefClass>( rc );
            }
        }
        if ( rc == null ) {
            throw new InvalidNameException( typeName, JmiBase.CLASSNOTFOUND, typeName );
        }
        return rc;
    }


    public final RefPackage refPackage( RefObject ro ) {

        return refPackage( (CoreConnection) null, ro );
    }

    public final RefPackage refPackage( CoreConnection connection, RefObject ro ) {

        //FIXME remove connection from signature
        RefPackage rp = null;
        if ( ro instanceof ModelElement ) {
            rp = refPackage( ( (ModelElement) ro ).getName( ) );
        } else {
            throw new InvalidCallException( ro, null, "refPackage()" ); //$NON-NLS-1$
        }
        return rp;
    }


    public final RefPackage refPackage( String packageName ) {

        return refPackage( (CoreConnection) null, packageName );
    }


    public final RefPackage refPackage( CoreConnection connection, String packageName ) {

        //FIXME remove connection from Signature
        if ( packageName == null ) {
            throw new InvalidCallException( packageName, null, "refPackage()" ); //$NON-NLS-1$
        }
        RefPackage rp = null;
        // search with name
        RefPackageAndName rpan = this.___refPackagesByName.get( packageName );
        if ( rpan != null ) {
            if ( rpan.refPackage != null ) {
                rp = rpan.refPackage.get( );
            }
            if ( rp == null ) {
                rp = create___RefPackage( rpan );
                rpan.refPackage = new WeakReference<RefPackage>( rp );
            }
        }
        if ( rp == null ) {
            throw new InvalidNameException( packageName, JmiBase.PACKAGENOTFOUND, packageName );
        }
        return rp;
    }


    public final RefAssociation refAssociation( RefObject association ) {

        return refAssociation( (CoreConnection) null, association );
    }

    public final RefAssociation refAssociation( CoreConnection connection, RefObject association ) {

        //FIXME remove connection from signature
        if ( association instanceof Association ) {
            return refAssociation( connection, ( (Association) association ).getName( ) );
        }
        throw new InvalidCallException( association, null, "refAssociation()" ); //$NON-NLS-1$
    }


    public final RefAssociation refAssociation( String associationName ) {

        return refAssociation( (CoreConnection) null, associationName );
    }

    public final RefAssociation refAssociation( CoreConnection connection, String associationName ) {

        //FIXME remove connection from signature
        if ( associationName == null ) {
            throw new InvalidCallException( associationName, null, "refAssociation()" ); //$NON-NLS-1$
        }
        RefAssociation ra = null;
        RefAssociationAndName raan = this.___refAssociationsByName.get( associationName );
        if ( raan != null ) {
            if ( raan.refAssociation != null ) {
                ra = raan.refAssociation.get( );
            }
            if ( ra == null ) {
                ra = create___RefAssociation( raan );
                raan.refAssociation = new WeakReference<RefAssociation>( ra );
            }
        }
        if ( ra == null ) {
            throw new InvalidNameException( associationName, JmiBase.ASSOCNOTFOUND, associationName );
        }
        return ra;
    }


    public final Collection<RefPackage> refAllPackages( ) {

        return refAllPackages( (CoreConnection) null );
    }

    public final Collection<RefPackage> refAllPackages( CoreConnection connection ) {

        //FIXME remove connection from signature
        List<RefPackage> result = new ArrayList<RefPackage>( this.___refPackages.size( ) );
        for ( int i = 0, n = this.___refPackages.size( ); i < n; i++ ) {
            RefPackageAndName rpan = this.___refPackages.get( i );
            result.add( refPackage( rpan.name ) );
        }
        return result;
    }

    public final Collection<RefClass> refAllClasses( ) {

        return refAllClasses( (CoreConnection) null );
    }

    public final Collection<RefClass> refAllClasses( CoreConnection connection ) {

        //FIXME remove connection from signature
        List<RefClass> result = new ArrayList<RefClass>( this.___refClasses.size( ) );
        for ( int i = 0, n = this.___refClasses.size( ); i < n; i++ ) {
            RefClassAndName rcan = this.___refClasses.get( i );
            result.add( refClass( rcan.name ) );
        }
        return result;
    }

    public final Collection<RefAssociation> refAllAssociations( ) {

        return refAllAssociations( (CoreConnection) null );
    }

    public final Collection<RefAssociation> refAllAssociations( CoreConnection connection ) {

        //FIXME remove connection from signature
        List<RefAssociation> result = new ArrayList<RefAssociation>( this.___refAssociations.size( ) );
        for ( int i = 0, n = this.___refAssociations.size( ); i < n; i++ ) {
            RefAssociationAndName raan = this.___refAssociations.get( i );
            result.add( refAssociation( raan.name ) );
        }
        return result;
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

        return ref___CreateStruct( get___CurrentConnection( ), structName, params );
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

    public final void refDelete( ) {

        throw new MoinUnsupportedOperationException( JmiReflectMessages.DELETIONOFPACKAGESNOTSUPPORTED );
    }

    @Override
    public final void ___delete( ) {

        this.___refPackages.clear( );
        this.___refPackagesByName.clear( );
        this.___refClasses.clear( );
        this.___refClassesByName.clear( );
        this.___refAssociations.clear( );
        this.___refAssociationsByName.clear( );
    }

    /**
     * Has to be overwritten in the generated classes and is called in the
     * constructor of this base class.
     */
    protected abstract void initialize( );

    /***************************************************************************
     * java.lang.Object level methods
     **************************************************************************/

    @Override
    public String toString( ) {

        StringBuffer result = new StringBuffer( );
        result.append( "{RefPackage" ); //$NON-NLS-1$
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

    /**
     * This method is not to be overwritten by a generated class, but is called
     * within this implementation
     */
    private final RefAssociation create___RefAssociation( RefAssociationAndName raan ) {

        return (RefAssociation) create___RefAssociationOrRefClass( raan.name );
    }

    /**
     * This method is not to be overwritten by a generated class, but is called
     * within this implementation
     * 
     * @param connection
     */
    private final RefClass create___RefClass( RefClassAndName rcan ) {

        return (RefClass) create___RefAssociationOrRefClass( rcan.name );
    }

    private final Extent create___RefAssociationOrRefClass( String name ) {

        Map<String, ModelElement> allContentMap = get___JmiHelper( ).getAllContentMap( null /* session */, refMetaObject( ) );
        RefObject refMetaObject = allContentMap.get( name );
        return create___Extent( refMetaObject );
    }

    /**
     * This method is not to be overwritten by a generated class, but is called
     * within this implementation
     * 
     * @param connection
     */
    private final RefPackage create___RefPackage( RefPackageAndName rpan ) {

        MofPackage refMetaObject;
        try {
            if ( rpan.imported ) {
                ImportImpl imp = (ImportImpl) ( (MofPackageImpl) refMetaObject( ) ).lookupElement( null/* connection */, rpan.name );
                refMetaObject = (MofPackage) imp.getImportedNamespace( (CoreConnection) null );
            } else {
                refMetaObject = (MofPackage) ( (MofPackageImpl) refMetaObject( ) ).lookupElement( null/* connection */, rpan.name );
            }

        } catch ( NameNotFoundException e ) {
            throw new JmiException( e );
        }
        return (RefPackage) create___Extent( refMetaObject );
    }

    private final Extent create___Extent( RefObject refMetaObject ) {

        ExtentManager extentManager = get___Workspace( ).getWorkspaceSet( ).getMoin( ).getExtentManager( );
        return extentManager.createExtent( this, refMetaObject );
    }

//    private final Extent create___Extent( CoreConnection connection, RefObject refMetaObject ) {
//
//        Extent result;
//        MRI mriOfExtentsMetaObject = ( (Partitionable) refMetaObject ).get___Mri( );
//        ExtentManager extentManager = get___Workspace( ).getWorkspaceSet( ).getExtentManager( );
//        synchronized ( extentManager ) {
//            Extent extent = extentManager.getExtent( connection, mriOfExtentsMetaObject );
//            if ( extent != null ) {
//                result = extent;
//            } else {
//                // not yet in the extent manager, but maybe already existing
//                String mofId = extentManager.convertToExtentMofId( refMetaObject.refMofId( ) );
//                result = (Extent) get___Workspace( ).getInstanceManager( ).getInstance( mofId );
//                if ( result == null ) {
//                    result = (Extent) create___Extent( get___Workspace( ), mofId, this, refMetaObject );
//                    ( (RefObjectExtension) refMetaObject ).set___Extent( result );
//                }
//                extentManager.addExtent( result );
//            }
//        }
//
//        return result;
//    }

    /**
     * This method has to be overwritten by the generated class.
     * <p>
     * Warning: it is essential for this method to have the return type
     * java.lang.Object. This helps to avoid unneeded classloading at start
     * time.
     * </p>
     */
    protected abstract Object create___Extent( Object workspace, String mofId, RefPackage immediatePackage, RefObject refMetaObject );

    public final RefBaseObject create___ExtentForExtentManager( MetamodelWorkspace workspace, String mofId, RefPackage immediatePackage, RefObject refMetaObject ) {

        return (RefBaseObject) create___Extent( workspace, mofId, immediatePackage, refMetaObject );
    }

    @Override
    public final MetamodelWorkspace get___Workspace( ) {

        // an extent is always in the metamodel workspace
        return (MetamodelWorkspace) this.___workspace;
    }
}
