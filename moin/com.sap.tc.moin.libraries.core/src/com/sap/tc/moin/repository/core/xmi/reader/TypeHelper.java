package com.sap.tc.moin.repository.core.xmi.reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ImportInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.NamespaceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.PrimitiveTypeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureTypeInternal;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.jmi.reflect.RefClassImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefPackageImpl;
import com.sap.tc.moin.repository.core.xmi.XmiConstants;
import com.sap.tc.moin.repository.exception.MoinIllegalNullArgumentException;
import com.sap.tc.moin.repository.messages.core.XMI;
import com.sap.tc.moin.repository.shared.util.QualifiedName;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

/**
 * This class mainly contains methods for dealing with MOF 1.4 types, like
 * providing default values, resolving PrimitiveType values etc.
 */
public class TypeHelper {

    /**
     * The array of package extents as it was passed to one of the
     * <code>read</code> methods of
     * {@link com.sap.tc.moin.repository.xmi.XmiReader}.
     */
    private RefPackage[] extents;

    /**
     * Cache for class/package/association proxies.
     */
    private Map<ModelElementInternal, RefBaseObject> proxies;

    /**
     * Cache for the reverse (wrt. refMetaObject()) direction MofPackage ->
     * RefPackage.
     */
    private Map<MofPackageInternal, RefPackage> refPackagesByMofPackage;

    /**
     * This collection maps a namespace prefix to the list of packages that have
     * this prefix attached via the <code>org.omg.xmi.namespace</code> tag.
     * (Note that there can be more than one package using the same prefix.)
     */
    private Map<String /* namespacePrefix */, List<MofPackageInternal>> packagesByNamespacePrefix;

    /**
     * This collection maps a qualified package name (given as a dot separated
     * String) to the corresponding MofPackage instance.
     */
    private Map<String /* qualifiedPackageName */, MofPackageInternal> packagesByQName;

    /**
     * This cache stores all already resolved ModelElement instances
     * corresponding to the names found in the XMI document. The names can
     * either be qualified or can contain a namespace prefix, depending on
     * whether the XMI document was serialized using namespaces or not.
     */
    private Map<String /* xmiName */, ModelElementInternal> resolvedXmiNames;

    private final CoreConnection connection;

    /**
     * Constructs a new TypeHelper instance.
     */
    public TypeHelper( CoreConnection connection, RefPackage[] packageExtents ) {

        this.connection = connection;
        extents = packageExtents;
        proxies = new HashMap<ModelElementInternal, RefBaseObject>( );
        refPackagesByMofPackage = new HashMap<MofPackageInternal, RefPackage>( );
        packagesByNamespacePrefix = new HashMap<String, List<MofPackageInternal>>( );
        packagesByQName = new HashMap<String, MofPackageInternal>( );
        resolvedXmiNames = new HashMap<String, ModelElementInternal>( );
        // Search all package extents for namespace prefixes.
        for ( int i = 0; i < extents.length; i++ ) {
            findNamespacePrefixes( (MofPackageInternal) extents[i].refMetaObject( ), new HashSet<MofPackageInternal>( ) /* visitedPackages */);
        }
    }

    public void setExtents( RefPackage[] packageExtents ) {

        extents = packageExtents;
        // Search all package extents for namespace prefixes.
        for ( int i = 0; i < extents.length; i++ ) {
            findNamespacePrefixes( (MofPackageInternal) extents[i].refMetaObject( ), new HashSet<MofPackageInternal>( ) /* visitedPackages */);
        }
    }

    /**
     * Returns the package extents on which this {@link TypeHelper} instance is
     * operating.
     */
    public RefPackage[] getExtents( ) {

        return extents;
    }

    /**
     * This method returns the model element with the given name as specified in
     * the XMI document. Depending on whether the XMI document was serialized
     * using XML namespaces or not, the name can either be qualified or it can
     * contain a namespace prefix. Successfully resolved names are cached in the
     * map {@link #resolvedXmiNames}.
     */
    public ModelElementInternal resolveQualifiedName( String xmiName ) {

        ModelElementInternal result = resolvedXmiNames.get( xmiName );
        if ( result != null ) {
            return result;
        }
        List<MofPackageInternal> packagesToSearch = null;
        String elementName = null;
        int colonPos = xmiName.indexOf( XmiConstants.NS_SEPARATOR );
        if ( colonPos < 0 ) {
            // a namespace prefix is not present => qualified name must be given
            int index = xmiName.lastIndexOf( XmiConstants.DOT_SEPARATOR );
            String packageName = xmiName;
            while ( index > -1 ) {
                packageName = packageName.substring( 0, index );
                MofPackageInternal pkg = packagesByQName.get( packageName );
                if ( pkg != null ) {
                    // we found the (one and only) package
                    packagesToSearch = new ArrayList<MofPackageInternal>( );
                    packagesToSearch.add( pkg );
                    elementName = xmiName.substring( index + 1 );
                    break;
                }
                index = packageName.lastIndexOf( XmiConstants.DOT_SEPARATOR );
            }
        } else {
            // xmiName contains a namespace prefix. Determine the list of all
            // packages using that prefix.
            packagesToSearch = packagesByNamespacePrefix.get( xmiName.substring( 0, colonPos ) );
            elementName = xmiName.substring( colonPos + 1 );
        }
        if ( packagesToSearch == null || elementName == null ) {
            throw new XmiParseException( XMI.MOIN_XMI_1069, new Object[] { xmiName } );
        }
        int dotPos = elementName.indexOf( XmiConstants.DOT_SEPARATOR );
        SpiJmiHelper jmiHelper = connection.getCoreJmiHelper( );
        for ( Iterator<MofPackageInternal> it = packagesToSearch.iterator( ); it.hasNext( ); ) {
            MofPackage pkg = (MofPackage) it.next( );
            try {
                if ( dotPos == -1 ) {
                    // must be a "class level" element
                    result = (ModelElementInternal) jmiHelper.getAllContentMap( connection.getSession( ), pkg ).get( elementName );
                } else {
                    // must be an "feature level" element
                    Classifier element = (Classifier) jmiHelper.getAllContentMap( connection.getSession( ), pkg ).get( elementName.substring( 0, dotPos ) );
                    if ( element == null ) {
                        // not resolvable in the context of the current package;
                        // continue with the next package
                        continue;
                    }
                    result = (ModelElementInternal) jmiHelper.getAllContentMap( connection.getSession( ), element ).get( elementName.substring( dotPos + 1 ) );
                }
            } catch ( Exception e ) {
                result = null;
            }
            if ( result != null ) {
                // resolved successfully in the context of the current package
                break;
            }
        }
        if ( result == null ) {
            throw new XmiParseException( XMI.MOIN_XMI_1069, new Object[] { xmiName } );
        }
        resolvedXmiNames.put( xmiName, result );
        return result;
    }

    public RefBaseObject getProxy( ModelElementInternal element ) {

        RefBaseObject proxy = proxies.get( element );
        if ( proxy != null ) {
            return proxy;
        }
        if ( element instanceof MofClassInternal ) {
            proxy = connection.getCoreJmiHelper( ).getRefClassForMofClass( connection.getSession( ), (MofClass) element );
            if ( proxy != null ) {
                proxies.put( element, proxy );
            }
            return proxy;
        }
        if ( element instanceof AssociationInternal ) {
            proxy = connection.getCoreJmiHelper( ).getRefAssociationForAssociation( connection.getSession( ), (Association) element );
            if ( proxy != null ) {
                proxies.put( element, proxy );
            }
            return proxy;
        }
        LinkedList<ModelElement> path = new LinkedList<ModelElement>( );
        ModelElementInternal container = (ModelElementInternal) element.getContainer( connection );
        if ( container == null ) {
            throw new MoinIllegalNullArgumentException( "container" ); //$NON-NLS-1$
        }
        // Compute all containers up to a package (which has container == null).
        while ( container != null ) {
            path.add( (ModelElement) container );
            container = (ModelElementInternal) container.getContainer( connection );
        }
        MofPackageInternal mofPackage = (MofPackageInternal) path.removeLast( );
        // Retrieve the package proxy.
        RefPackage refPackage = getRefPackageForMofPackage( mofPackage );
        proxy = refPackage;
        while ( path.size( ) > 0 ) {
            ModelElement elem = path.removeLast( );
            if ( elem instanceof MofPackage ) {
                refPackage = refPackage.refPackage( elem );
                if ( path.size( ) == 0 ) {
                    proxy = refPackage;
                }
            } else {
                if ( ( elem instanceof MofClass ) && ( path.size( ) == 0 ) ) {
                    RefClass refClass = refPackage.refClass( elem );
                    proxy = refClass;
                } else {
                    break;
                }
            }
        }
        if ( proxy != null ) {
            proxies.put( element, proxy );
        }
        return proxy;
    }

    public RefPackage findRefPackage( String qualifiedName ) {

        RefPackage refPackage = null;
        // Search all extents for the RefPackage.
        for ( int i = 0; i < extents.length && refPackage == null; i++ ) {
            refPackage = connection.getJmiHelper( ).findRefPackageByQualifiedName( QualifiedName.createQualifiedName( qualifiedName ), extents[i] );
        }
        return refPackage;
    }

    /**
     * Creates an instance of the given StructureType, and initializes the
     * structure's fields with the values from the given list.
     */
    public RefStruct createStructure( StructureTypeInternal structType, List fieldValues ) {

        RefBaseObject proxy = getProxy( structType );
        RefStruct struct = null;
        if ( proxy instanceof RefClass ) {
            struct = ( (RefClassImpl) proxy ).refCreateStruct( connection, structType, fieldValues );
        } else {
            struct = ( (RefPackageImpl) proxy ).refCreateStruct( connection, structType, fieldValues );
        }
        return struct;
    }

    /**
     * @param type type that should be resolved
     * @param valueAsText text representation of a value
     * @return primitive type value
     */
    public Object resolvePrimitiveValue( PrimitiveTypeInternal type, String valueAsText ) {

        String typeName = type.getName( );
        if ( XmiConstants.BOOLEAN_TYPE.equals( typeName ) ) {
            return Boolean.valueOf( valueAsText );
        }
        if ( XmiConstants.DOUBLE_TYPE.equals( typeName ) ) {
            return new Double( valueAsText );
        }
        if ( XmiConstants.FLOAT_TYPE.equals( typeName ) ) {
            return new Float( valueAsText );
        }
        if ( XmiConstants.INTEGER_TYPE.equals( typeName ) ) {
            return Integer.valueOf( valueAsText );
        }
        if ( XmiConstants.LONG_TYPE.equals( typeName ) ) {
            return Long.valueOf( valueAsText );
        }
        if ( XmiConstants.STRING_TYPE.equals( typeName ) ) {
            return ( valueAsText == null ) ? "" : valueAsText; //$NON-NLS-1$
        }
        throw new JmiException( XMI.MOIN_XMI_1033, typeName );
    }

    /**
     * Returns the RefPackage for the given MofPackage, and caches the result in
     * the {@link #refPackagesByMofPackage} map.
     */
    private RefPackage getRefPackageForMofPackage( MofPackageInternal mofPackage ) {

        RefPackage result = refPackagesByMofPackage.get( mofPackage );
        if ( result == null ) {
            result = connection.getCoreJmiHelper( ).getRefPackageForMofPackage( connection.getSession( ), (MofPackage) mofPackage );
            refPackagesByMofPackage.put( mofPackage, result );
        }
        return result;
    }

    /**
     * Searches the given MofPackage for a namespace prefix attached to it via a
     * <code>org.omg.xmi.namespace</code> tag. Recursively descends to all
     * directly contained and clustered packages. Populates the two collections
     * {@link #packagesByQName} and {@link #packagesByNamespacePrefix} with the
     * search results.
     */
    private void findNamespacePrefixes( MofPackageInternal pkg, Set<MofPackageInternal> visitedPackages ) {

        if ( visitedPackages.contains( pkg ) ) {
            return;
        }
        String qName = QualifiedName.toDotSeparatedString( pkg.getQualifiedName( connection ) );
        packagesByQName.put( qName, pkg );
        String nsPrefix = connection.getCoreJmiHelper( ).getTagValue( connection.getSession( ), (ModelElement) pkg, XmiConstants.TAGID_XMI_NAMESPACE );
        if ( nsPrefix != null ) {
            List<MofPackageInternal> list = packagesByNamespacePrefix.get( nsPrefix );
            if ( list == null ) {
                list = new ArrayList<MofPackageInternal>( );
                packagesByNamespacePrefix.put( nsPrefix, list );
            }
            list.add( pkg );
        }
        visitedPackages.add( pkg );
        List<MofPackageInternal> furtherPackagesToScan = getDirectlyContainedAndClusteredPackages( pkg );
        for ( Iterator<MofPackageInternal> it = furtherPackagesToScan.iterator( ); it.hasNext( ); ) {
            MofPackageInternal mp = it.next( );
            findNamespacePrefixes( mp, visitedPackages );
        }
    }

    /**
     * For a given MofPackage including all of its supertypes, returns all
     * directly contained and clustered packages.
     * 
     * @param connection
     */
    @SuppressWarnings( { "unchecked" } )
    private List<MofPackageInternal> getDirectlyContainedAndClusteredPackages( MofPackageInternal pkg ) {

        List<MofPackageInternal> result = new ArrayList<MofPackageInternal>( );
        List list = new ArrayList( );
        list.add( pkg );
        list.addAll( pkg.allSupertypes( connection ) );
        for ( int i = 0, n = list.size( ); i < n; i++ ) {
            ModelElementInternal element = (ModelElementInternal) list.get( i );
            if ( element instanceof NamespaceInternal ) {
                JmiList contents = (JmiList) ( (NamespaceInternal) element ).getContents( connection );
                for ( int j = 0, o = contents.size( connection.getSession( ) ); j < o; j++ ) {
                    ModelElement me = (ModelElement) contents.get( connection.getSession( ), j );
                    if ( me instanceof MofPackageInternal ) {
                        result.add( (MofPackageInternal) me );
                    } else if ( me instanceof ImportInternal ) {
                        ImportInternal im = (ImportInternal) me;
                        if ( im.isClustered( ) ) {
                            NamespaceInternal namespace = (NamespaceInternal) im.getImportedNamespace( connection );
                            if ( namespace instanceof MofPackageInternal ) {
                                // Classes can also be clusteredly imported (MOF
                                // constraint C-46).
                                result.add( (MofPackageInternal) namespace );
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}