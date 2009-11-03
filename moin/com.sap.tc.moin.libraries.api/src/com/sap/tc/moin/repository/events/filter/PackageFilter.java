package com.sap.tc.moin.repository.events.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.Partitionable;

/**
 * Clients that use a PackageFilter will get all events that affect model
 * elements which are contained by this package extent.<br>
 * Note that this Filter does not filter on M1-packages, only on Package Extents
 * (M2-packages). This means that fitlering on a certain package (extent) will
 * result in the same set of events like registering on all meta types that are
 * contained in that package.<br>
 * This filter enables clients to listen for changes on a huge number of
 * elements.
 * 
 * @see EventFilter
 * @author Daniel Vocke (D044825)
 */

public class PackageFilter extends EventFilter {

    /**
     * @param filterCriterion The package that shall be observed.
     */
    public PackageFilter( RefPackage filterCriterion ) {

        super( getExpandedExtentTree( filterCriterion ) );
    }

    /**
     * @param filterCriteria The packages that shall be observed.
     */
    public PackageFilter( Set<RefPackage> filterCriteria ) {

        super( getExpandedExtentTree( filterCriteria ) );
    }

    /**
     * @param filterCriterion The package that shall be observed.
     */
    public PackageFilter( LRI filterCriterion ) {

        super( getLriAsCollection( filterCriterion ) );
    }

    private static Collection<LRI> getLriAsCollection( LRI lri ) {

        Collection<LRI> extents = new ArrayList<LRI>( );
        extents.add( lri );
        return extents;
    }

    private static Collection<LRI> getExpandedExtentTree( Collection<RefPackage> packages ) {

        Collection<LRI> extents = new ArrayList<LRI>( );
        for ( RefPackage pckg : packages ) {
            extents.addAll( getExpandedExtentTree( pckg ) );
        }
        return extents;
    }

    private static Collection<LRI> getExpandedExtentTree( RefPackage extent ) {

        Collection<LRI> extents = new ArrayList<LRI>( );
        extents.add( ( (Partitionable) extent ).get___Mri( ).getLri( ) );

        Collection<RefPackage> containedPackages = getContainedPackageExtents( extent );

        for ( RefPackage _package : containedPackages ) {
            extents.add( ( (Partitionable) _package ).get___Mri( ).getLri( ) );
        }
        return extents;
    }

    private static Collection<RefPackage> getContainedPackageExtents( RefPackage refPackage ) {

        Collection<RefPackage> result = new ArrayList<RefPackage>( );

        for ( Iterator it = refPackage.refAllPackages( ).iterator( ); it.hasNext( ); ) {
            RefPackage containedPackage = (RefPackage) it.next( );
            result.add( containedPackage );
            result.addAll( getContainedPackageExtents( containedPackage ) );
        }
        return result;
    }

}