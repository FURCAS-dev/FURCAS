package com.sap.tc.moin.repository.test.jmitck.tst2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.ConstraintViolationException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.WrongSizeException;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.TestErrorException;
import com.sap.tc.moin.repository.test.jmitck.javatest.Status;
import com.sap.tc.moin.repository.test.jmitck.modelsem.SemModelTests;
import com.sap.tc.moin.repository.test.jmitck.modelsem.Util;
import com.sap.tc.moin.repository.test.jmitck.tst2.links.BaseClass;
import com.sap.tc.moin.repository.test.jmitck.tst2.links.Blue;
import com.sap.tc.moin.repository.test.jmitck.tst2.links.Green;
import com.sap.tc.moin.repository.test.jmitck.tst2.links.Leaf;
import com.sap.tc.moin.repository.test.jmitck.tst2.links.LeafCoversLeaves;
import com.sap.tc.moin.repository.test.jmitck.tst2.links.LinksPackage;
import com.sap.tc.moin.repository.test.jmitck.tst2.links.RootClass;
import com.sap.tc.moin.repository.test.jmitck.tst2.links.RootPaintedBlue;
import com.sap.tc.moin.repository.test.jmitck.tst2.links.Yellow;

/**
 * Defines tests invoked on the interfaces generated from the Links metamodel.
 */
@SuppressWarnings( { "deprecation", "nls" } )
public class LinksTests extends SemModelTests {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, LinksTests.class );

    /**
     * Defines the linkConsistency test. The purpose of the test is to insure
     * that link manipulation by reference is reflected in association queries;
     * and link manapulation by association is reflected in reference access.
     * 
     * @return a <code>Status</code> value
     */
    public Status checkLinkConsistency( ) {

        LinksPackage lp = (LinksPackage) rp;
        LeafCoversLeaves lcl = null;
        Leaf leafA = null;
        Leaf leafB = null;
        Leaf leafToMove = null;
        Collection<Leaf> aCovers = null;
        Collection<Leaf> bCovers = null;
        Collection<Leaf> beforeACovers = null;
        Collection<Leaf> beforeBCovers = null;
        try {
            leafA = (Leaf) lp.getLeaf( ).refCreateInstance( Arrays.asList( "coveringA", "leafA" ) );
            for ( int i = 0; i < 10; i++ ) {
                Leaf leaf = (Leaf) lp.getLeaf( ).refCreateInstance( Arrays.asList( "covered_" + i + 1, "under" ) );
                if ( i == 4 ) {
                    leafToMove = leaf;
                }
                leafA.getCovers( ).add( leaf );
            }
            leafB = (Leaf) lp.getLeaf( ).refCreateInstance( Arrays.asList( "coveringB", "leafB" ) );
            for ( int i = 0; i < 10; i++ ) {
                Leaf leaf = (Leaf) lp.getLeaf( ).refCreateInstance( Arrays.asList( "covered_" + i + 1, "under" ) );
                leafB.getCovers( ).add( leaf );
            }
            lcl = lp.getLeafCoversLeaves( );
            beforeACovers = new ArrayList<Leaf>( leafA.getCovers( ) );
            beforeBCovers = new ArrayList<Leaf>( leafB.getCovers( ) );
            aCovers = lcl.getCoveredEnd( leafA );
            bCovers = lcl.getCoveredEnd( leafB );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.error( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " setting up the test" );
        }

        boolean removed;
        try {
            removed = aCovers.remove( leafToMove );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while invoking remove on the " + "collection returned from the covers link query" );
        }
        if ( !removed ) {
            return Status.failed( "remove method on the collection returned from " + "getCovers did not return true; the " + leafAsString( leafToMove ) + " should be removed from collection" );
        }

        try {
            bCovers.add( leafToMove );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while invoking add on the collection " + "returned from the link query to add " + leafAsString( leafToMove ) );
        }
        if ( !removed ) {
            return Status.failed( "add method on the collection from the link " + "query did not return true; a reference to " + "RefAssociationLink with firstEnd: " + leafAsString( leafToMove ) + " should be added to the collection" );
        }
        beforeACovers.remove( leafToMove );
        beforeBCovers.add( leafToMove );
        Collection<Leaf> afterACovers = null;
        Collection<Leaf> afterBCovers = null;
        try {
            afterACovers = leafA.getCovers( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while accessing the reference covers of Leaf " + "after updating the collection from the " + "Association query" );
        }
        if ( !Util.equalCollections( beforeACovers, afterACovers ) ) {
            return Status.failed( "After modifying links in the collection " + "returned from the Association query, expected " + "the covers reference to contain the elements " + leafCollAsString( beforeACovers ) + " but instead contained " + leafCollAsString( afterACovers ) );
        }
        try {
            afterBCovers = leafB.getCovers( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while accessing the reference covers of Leaf " + "after updating the collection from the " + "Association query" );
        }
        if ( !Util.equalCollections( beforeBCovers, afterBCovers ) ) {
            return Status.failed( "After modifying links in the collection " + "returned from the Association query, expected " + "the covers reference to contain the elements " + leafCollAsString( beforeBCovers ) + " but instead contained " + leafCollAsString( afterBCovers ) );
        }
        return Status.passed( "After modifying links in the collections " + "returned from Association queries, the elements " + "returned by the covers reference of both effected" + " elements correctly reflect the change" );
    }

    /**
     * Defines the linkOrdering test, which insures that the ordering is
     * preserved for references and association ends defined as ordered.
     * 
     * @return a <code>Status</code> value
     */
    public Status checkOrdering( ) {

        LinksPackage lp = (LinksPackage) rp;
        RootPaintedBlue rpb = null;
        RootClass rootOne = null;
        RootClass rootTwo = null;
        Green greenA = null;
        Green greenB = null;
        List<Blue> control = new ArrayList<Blue>( );
        List<Blue> toAdd = new ArrayList<Blue>( );
        List<Blue> currentRootOneRef = null;
        try {
            rootOne = (RootClass) lp.getRootClass( ).refCreateInstance( Arrays.asList( "rootOne" ) );
            rootTwo = (RootClass) lp.getRootClass( ).refCreateInstance( Arrays.asList( "rootTwo" ) );
            for ( int i = 0; i < 10; i++ ) {
                Blue blue = (Blue) lp.getBlue( ).refCreateInstance( Arrays.asList( "base_" + i + 1, "blue color" ) );
                rootOne.getCoatsOfBlue( ).add( blue );
                control.add( blue );
            }

            for ( int i = 10; i < 13; i++ ) {
                Blue blue = (Blue) lp.getBlue( ).refCreateInstance( Arrays.asList( "base_" + i + 1, "blue overcoat" ) );
                toAdd.add( blue );
            }
            greenA = (Green) lp.getGreen( ).refCreateInstance( Arrays.asList( "Insert", "blue tint", "yellow mellow", "dark" ) );
            greenB = (Green) lp.getGreen( ).refCreateInstance( Arrays.asList( "Insert", "blue gloss", "less yellow", "light" ) );
            rpb = lp.getRootPaintedBlue( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.error( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " setting up the test" );
        }

        boolean changed;
        try {
            changed = ( rootOne.getCoatsOfBlue( ).remove( 9 ) != null );
            control.remove( 9 );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while removing an element from the RootClass " + " coatsOfBlue reference collection" );
        }

        if ( !changed ) {
            return Status.failed( "remove method on RootClass coatsOfBlue " + "reference collection did not return true to " + "relect the change (unsure whether change was " + "made)" );
        }

        try {
            changed = rootOne.getCoatsOfBlue( ).addAll( toAdd );
            control.addAll( toAdd );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while invoking addAll on the collection of " + " a RootClass coatsOfBlue reference" );
        }
        if ( !changed ) {
            return Status.failed( "addAll method on RootClass coatsOfBlue " + "reference collection did not return true to " + "relect the change (unsure whether change was " + "made)" );
        }

        try {
            rootOne.getCoatsOfBlue( ).add( 0, greenA );
            control.add( 0, greenA );
            currentRootOneRef = rootOne.getCoatsOfBlue( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while inserting an element into the first " + "position of the on the collection of " + " a RootClass coatsOfBlue reference" );
        }
        try {
            changed = ( rpb.getBlueEnd( rootOne ).remove( 4 ) != null );
            control.remove( 4 );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while removing an element from the " + " collection returned by the query on the " + " association" );
        }
        if ( !changed ) {
            return Status.failed( "remove method on RootPaintedBlue blueEnds " + "query collection did not return true to " + "relect the change (unsure whether change was " + "made)" );
        }

        try {
            Collection<RootClass> roots = rpb.getRootEnd( greenB );
            roots.add( rootTwo );
            changed = roots.add( rootOne );
            control.add( greenB );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while adding an element to a " + " collection returned by the query on the " + " association" );
        }
        if ( !changed ) {
            return Status.failed( "add method on RootPaintedBlue blueEnds " + "query collection did not return true to " + "relect the change (unsure whether change was " + "made)" );
        }
        if ( !Util.equalLists( control, currentRootOneRef ) ) {
            return Status.failed( "After modifying links in the collection " + "returned from the Association query, expected " + "the coatsOfBlue reference to contain the elements " + blueCollAsString( control ) + " but instead contained " + blueCollAsString( currentRootOneRef ) );
        } else {
            return Status.passed( "After modifying links in the collections " + "returned from Association queries, the elements " + "returned by the coatsOfPaint reference " + " relfect the changes, including correct ordering" );
        }
    }

    /**
     * Defines the linkOutOfBounds test. Test checks proper handling of
     * out-of-bounds indexing of Lists returned from ordered references.
     * 
     * @return a <code>Status</code> value
     */
    public Status checkOutOfBounds( ) {

        LinksPackage lp = (LinksPackage) rp;
        RootClass rootOne = null;
        try {
            rootOne = (RootClass) lp.getRootClass( ).refCreateInstance( Arrays.asList( "rootOne" ) );
            for ( int i = 0; i < 10; i++ ) {
                Blue blue = (Blue) lp.getBlue( ).refCreateInstance( Arrays.asList( "base_" + i + 1, "blue color" ) );
                rootOne.getCoatsOfBlue( ).add( blue );
            }
            new ArrayList<Blue>( rootOne.getCoatsOfBlue( ) );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.error( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " setting up the test" );
        }

        boolean changed;

        try {
            changed = ( rootOne.getCoatsOfBlue( ).remove( 9 ) != null );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while removing an element from the RootClass " + " coatsOfBlue reference collection" );
        }

        if ( !changed ) {
            return Status.failed( "remove method on RootClass coatsOfBlue " + "reference collection did not return true to " + "relect the change (unsure whether change was " + "made)" );
        }

        try {
            changed = ( rootOne.getCoatsOfBlue( ).remove( 9 ) != null );
            return Status.failed( "Failed to detecte the out of  bounds condition" );
        } catch ( IndexOutOfBoundsException oobe ) {
            return Status.passed( "Correctly detected the out of bounds condition " + " on the reference" );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Exception thrown under the out-of-bounds " + "condition was not the expected " + "IndexOutOfBoundsException, but was a " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) );
        }
    }

    private String leafCollAsString( Collection<Leaf> c ) {

        StringBuffer sb = new StringBuffer( "{" );
        int cnt = 0;
        for ( Iterator<Leaf> i = c.iterator( ); i.hasNext( ); cnt++ ) {
            if ( cnt > 0 ) {
                sb.append( "," );
            }
            sb.append( leafAsString( i.next( ) ) );
        }
        return sb.append( "}" ).toString( );
    }

    private String leafAsString( Leaf leaf ) {

        return "Leaf(" + leaf.getRootAttr( ) + ", " + leaf.getLeafAttr( ) + ")";
    }

    private String blueCollAsString( Collection<Blue> c ) {

        StringBuffer sb = new StringBuffer( "{" );
        int cnt = 0;
        for ( Iterator<Blue> i = c.iterator( ); i.hasNext( ); cnt++ ) {
            if ( cnt > 0 ) {
                sb.append( "," );
            }
            sb.append( blueAsString( i.next( ) ) );
        }
        return sb.append( "}" ).toString( );
    }

    private String blueAsString( Blue blue ) {

        return ( ( blue instanceof Green ) ? "Green" : "Blue" ) + "(" + blue.getBaseAttr( ) + ", " + blue.getBlueAttr( ) + ( ( blue instanceof Green ) ? ", " + ( (Green) blue ).getGreenAttr( ) : "" ) + ")";
    }

    /**
     * Defines the refAllOfClass test, which tests that method defined in
     * RefClass. Since the Links metamodel defines a "diamond pattern" of
     * subtyping, it is an interesting candidate for testing.
     * 
     * @return a <code>Status</code> value
     */
    public Status refAllOfClass( ) {

        int cnt = 0;
        for ( Iterator<RefClass> i = rp.refAllClasses( ).iterator( ); i.hasNext( ); ) {
            RefClass rc = i.next( );
            cnt = cnt + rc.refAllOfClass( ).size( );
        }
        if ( cnt != 0 ) {
            throw new TestErrorException( "Error in pre-test; must start this " + " in an empty extent" );
        }

        LinksPackage lp = null;
        Collection<Blue> blueClassControl = new ArrayList<Blue>( );
        Collection<Green> greenClassControl = new ArrayList<Green>( );
        Collection<Yellow> yellowClassControl = new ArrayList<Yellow>( );
        Collection<RefClass> baseClassControl = new ArrayList<RefClass>( );
        try {
            lp = (LinksPackage) rp;
            for ( int i = 0; i < 10; i++ ) {
                Blue blue = (Blue) lp.getBlue( ).refCreateInstance( Arrays.asList( "base_" + i + 1, "blue_" + i + 1 ) );
                blueClassControl.add( blue );
            }

            for ( int i = 0; i < 6; i++ ) {
                Yellow yellow = (Yellow) lp.getYellow( ).refCreateInstance( Arrays.asList( "base_" + i + 1, "yellow_" + i + 1 ) );
                yellowClassControl.add( yellow );
            }
            for ( int i = 0; i < 3; i++ ) {
                Green green = (Green) lp.getGreen( ).refCreateInstance( Arrays.asList( "base_" + i + 1, "blue_" + i + 1, "yellow_" + i + 1, "green_" + i + 1 ) );
                greenClassControl.add( green );
            }
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.error( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " setting up the test" );
        }

        Collection<RefObject> blueClassCurrent = null;
        Collection<RefObject> greenClassCurrent = null;
        Collection<RefObject> yellowClassCurrent = null;
        Collection<RefObject> baseClassCurrent = null;
        try {
            blueClassCurrent = lp.getBlue( ).refAllOfClass( );
            greenClassCurrent = lp.getGreen( ).refAllOfClass( );
            yellowClassCurrent = lp.getYellow( ).refAllOfClass( );
            baseClassCurrent = lp.getBaseClass( ).refAllOfClass( );

        } catch ( Throwable th ) {
            return Status.passed( "Unexpected exception on a refAllOfClass " + "invocation; exception type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) );
        }

        if ( !Util.equalCollections( baseClassControl, baseClassCurrent ) ) {
            return Status.failed( "The BaseClassClass.refAllOfClass method did " + "return the expected results" );
        }

        if ( !Util.equalCollections( blueClassControl, blueClassCurrent ) ) {
            return Status.failed( "The BlueClass.refAllOfClass method did " + "return the expected results" );
        }

        if ( !Util.equalCollections( yellowClassControl, yellowClassCurrent ) ) {
            return Status.failed( "The YellowClass.refAllOfClass method did " + "return the expected results" );
        }

        if ( !Util.equalCollections( greenClassControl, greenClassCurrent ) ) {
            return Status.failed( "The GreenClass.refAllOfClass method did " + "return the expected results" );
        }

        return Status.passed( "refAllOfClass returned the correct elements for " + "each class in the hierarchy" );
    }

    /**
     * Defines the refAllOfType test, which tests that method defined in
     * RefClass. Since the Links metamodel defines a "diamond pattern" of
     * subtyping, it is an interesting candidate for testing.
     * 
     * @return a <code>Status</code> value
     */
    public Status refAllOfType( ) {

        int cnt = 0;
        for ( Iterator<RefClass> i = rp.refAllClasses( ).iterator( ); i.hasNext( ); ) {
            RefClass rc = i.next( );
            cnt = cnt + rc.refAllOfClass( ).size( );
        }
        if ( cnt != 0 ) {
            throw new TestErrorException( "Error in pre-test; must start this " + " in an empty extent" );
        }

        LinksPackage lp = null;
        Collection<BaseClass> baseTypeControl = new ArrayList<BaseClass>( );
        Collection<Blue> blueTypeControl = new ArrayList<Blue>( );
        Collection<Green> greenTypeControl = new ArrayList<Green>( );
        Collection<Yellow> yellowTypeControl = new ArrayList<Yellow>( );
        try {
            lp = (LinksPackage) rp;
            for ( int i = 0; i < 10; i++ ) {
                Blue blue = (Blue) lp.getBlue( ).refCreateInstance( Arrays.asList( "base_" + i + 1, "blue_" + i + 1 ) );
                blueTypeControl.add( blue );
                baseTypeControl.add( blue );
            }

            for ( int i = 0; i < 6; i++ ) {
                Yellow yellow = (Yellow) lp.getYellow( ).refCreateInstance( Arrays.asList( "base_" + i + 1, "yellow_" + i + 1 ) );
                yellowTypeControl.add( yellow );
                baseTypeControl.add( yellow );
            }
            for ( int i = 0; i < 3; i++ ) {
                Green green = (Green) lp.getGreen( ).refCreateInstance( Arrays.asList( "base_" + i + 1, "blue_" + i + 1, "yellow_" + i + 1, "green_" + i + 1 ) );
                greenTypeControl.add( green );
                yellowTypeControl.add( green );
                blueTypeControl.add( green );
                baseTypeControl.add( green );
            }
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.error( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " setting up the test" );
        }

        Collection<RefObject> baseTypeCurrent = null;
        Collection<RefObject> blueTypeCurrent = null;
        Collection<RefObject> greenTypeCurrent = null;
        Collection<RefObject> yellowTypeCurrent = null;
        try {
            blueTypeCurrent = lp.getBlue( ).refAllOfType( );
            greenTypeCurrent = lp.getGreen( ).refAllOfType( );
            yellowTypeCurrent = lp.getYellow( ).refAllOfType( );
            baseTypeCurrent = lp.getBaseClass( ).refAllOfType( );

        } catch ( Throwable th ) {
            return Status.failed( "Unexpected exception on a refAllOfType " + "invocation; exception type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) );
        }

        if ( !Util.equalCollections( baseTypeControl, baseTypeCurrent ) ) {
            return Status.failed( "The BaseClassClass.refAllOfType method did " + "return the expected results" );
        }

        if ( !Util.equalCollections( blueTypeControl, blueTypeCurrent ) ) {
            return Status.failed( "The BlueClass.refAllOfType method did " + "return the expected results" );
        }

        if ( !Util.equalCollections( yellowTypeControl, yellowTypeCurrent ) ) {
            return Status.failed( "The YellowClass.refAllOfType method did " + "return the expected results" );
        }

        if ( !Util.equalCollections( greenTypeControl, greenTypeCurrent ) ) {
            return Status.failed( "The GreenClass.refAllOfType method did " + "return the expected results" );
        }

        return Status.passed( "refAllOfType returned the correct elements for " + "each class in the hierarchy" );
    }

    /**
     * Defines the refAllOfClassStatic test. This test makes sure that the
     * collection returned from a refAllOfClass invocation cannot be modified
     * (it remains static).
     * 
     * @return a <code>Status</code> value
     */
    public Status refAllOfClassStatic( ) {

        LinksPackage lp = null;
        Collection<RefObject> leaves = null;
        Leaf firstLeaf = null;
        try {
            lp = (LinksPackage) rp;
            for ( int i = 0; i < 10; i++ ) {
                lp.getLeaf( ).refCreateInstance( Arrays.asList( "leaf_num_" + i + 1, "testing" ) );
            }
            leaves = lp.getLeaf( ).refAllOfClass( );
            firstLeaf = (Leaf) leaves.iterator( ).next( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.error( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " setting up the test" );
        }

        try {
            leaves.remove( firstLeaf );
        } catch ( UnsupportedOperationException uoe ) {
            return Status.passed( "Attempt to modify the results of a " + "refAllOfClass invocation resulted in an " + "UnsupportedOperationException; that's a valid " + "response!" );
        } catch ( Throwable th ) {
            return Status.passed( "Attempt to modify the results of a " + "refAllOfClass invocation resulted in an " + "unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + "; expected either an " + "UnsupportedOperationException or no exception" );
        }

        try {
            Collection<RefObject> currentLeaves = lp.getLeaf( ).refAllOfClass( );
            int cnt = currentLeaves.size( );
            if ( cnt != 10 ) {
                return Status.failed( "Modification of the results of a " + "refAllOfClass invocation changed the " + "extent of the Class; Extent had 10 " + "elements before; after a remove on the " + "collection, the extend had " + cnt + " elements" );
            } else {
                return Status.passed( "Modification of the results of a " + "refAllOfClass invocation was allowed, but " + "did not result in modification of the " + "extent" );
            }
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while accessing the extent " + "after modifying the collection returned from " + "the previous refAllOfClass invocation" );
        }
    }

    /**
     * Defines the referenceOverflow test, which determines whether an attempt
     * to exceed the multiplicity defined for a reference is detected.
     * 
     * @return a <code>Status</code> value
     */
    public Status referenceOverflow( ) {

        LinksPackage lp = (LinksPackage) rp;
        Leaf coveringLeaf = null;
        Leaf maxLeaf = null;
        Leaf overflowLeaf = null;
        Collection<Leaf> expected = new ArrayList<Leaf>( );
        try {
            coveringLeaf = (Leaf) lp.getLeaf( ).refCreateInstance( Arrays.asList( "coversOthers", "cover" ) );
            for ( int i = 0; i < 12; i++ ) {
                Leaf leaf = (Leaf) lp.getLeaf( ).refCreateInstance( Arrays.asList( "leaf_num_" + ( i + 1 ), "covered" ) );
                coveringLeaf.getCovers( ).add( leaf );
                expected.add( leaf );
            }
            maxLeaf = (Leaf) lp.getLeaf( ).refCreateInstance( Arrays.asList( "leaf_num_13", "covered" ) );
            expected.add( maxLeaf );
            overflowLeaf = (Leaf) lp.getLeaf( ).refCreateInstance( Arrays.asList( "leaf_num_14", "not covered" ) );

        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.error( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " setting up the test" );
        }

        boolean changed;

        try {
            changed = coveringLeaf.getCovers( ).add( maxLeaf );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while adding the 13th element to a reference " + " with an upper bound of 13" );
        }

        if ( !changed ) {
            return Status.failed( "The add method returned false; appearantly " + "the 13th element was not added to a reference " + "with an upper bound of 13" );
        }

        try {
            changed = coveringLeaf.getCovers( ).add( overflowLeaf );
        } catch ( WrongSizeException oobe ) {
            if ( coveringLeaf.getCovers( ).size( ) > 13 ) {
                return Status.failed( "Correctly threw exception when reference " + "overflow attempted, but the add method " + "changed the reference anyway; number of " + "elements: " + coveringLeaf.getCovers( ).size( ) );
            }
            Collection<Leaf> current = null;
            try {
                current = coveringLeaf.getCovers( );
            } catch ( Throwable th ) {
                log.trace( th, MoinSeverity.INFO, "" );
                return Status.failed( "Correctly threw exception when reference " + "overflow attempted, but on subsequent " + "access of the reference, unexpected " + "exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " encountered" );
            }
            if ( !Util.equalCollections( expected, current ) ) {
                System.out.println( "<<<1>>> " + expected );
                System.out.println( "<<<2>>> " + current );
                return Status.failed( "Correctly threw exception when reference " + "overflow attempted, but on subsequent " + "access of the reference, determined that " + "the add which triggered the overflow " + "altered the reference" );
            } else {
                return Status.passed( "Correctly threw exception when reference " + "overflow attempted and correctly " + "maintained reference values" );
            }
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Threw exception when reference " + "overflow attempted, but the exception was " + "not the expected WrongSizeException; " + "instead, exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " encountered" );
        }
        if ( changed ) {
            trOut.println( "After the add, the reference has " + coveringLeaf.getCovers( ) + " elements" );
            return Status.failed( "Overflow was not detected; The 14th element " + "was added to the reference defined with upper " + "bound of 13 (at least, true was returned from " + "the add method)" );
        }
        Collection<Leaf> current = null;
        try {
            current = coveringLeaf.getCovers( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Returned false from the add method, " + "indicating that the overflow attempt was " + "detected, but on subsequent" + "access of the reference, unexpected " + "exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " encountered" );
        }
        if ( !Util.equalCollections( expected, current ) ) {
            return Status.failed( "Returned false from the add method, " + "indicating that the overflow attempt was " + "detected, but on subsequent" + "access of the reference, determined that " + "the add which triggered the overflow " + "altered the reference" );
        } else {
            return Status.passed( "Returned false from the add method, " + "indicating that the overflow attempt was " + "detected, and correctly " + "maintained reference values" );
        }
    }

    /**
     * Defines the referenceOverflow test, which determines whether an attempt
     * to exceed the multiplicity defined for an association end is detected.
     * 
     * @return a <code>Status</code> value
     */
    public Status linkEndOverflow( ) {

        LinksPackage lp = (LinksPackage) rp;
        LeafCoversLeaves lcl = null;
        Leaf coveringLeaf = null;
        Leaf maxLeaf = null;
        Leaf overflowLeaf = null;
        Collection<Leaf> expected = new ArrayList<Leaf>( );
        try {
            lcl = lp.getLeafCoversLeaves( );
            coveringLeaf = (Leaf) lp.getLeaf( ).refCreateInstance( Arrays.asList( "coversOthers", "cover" ) );
            for ( int i = 0; i < 12; i++ ) {
                Leaf leaf = (Leaf) lp.getLeaf( ).refCreateInstance( Arrays.asList( "leaf_num_" + i + 1, "covered" ) );
                coveringLeaf.getCovers( ).add( leaf );
                expected.add( leaf );
            }
            maxLeaf = (Leaf) lp.getLeaf( ).refCreateInstance( Arrays.asList( "leaf_num_13", "covered" ) );
            expected.add( maxLeaf );
            overflowLeaf = (Leaf) lp.getLeaf( ).refCreateInstance( Arrays.asList( "leaf_num_14", "not covered" ) );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.error( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " setting up the test" );
        }

        boolean changed;

        try {
            changed = lcl.add( coveringLeaf, maxLeaf );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while adding the 13th link to a link end " + " with an upper bound of 13" );
        }

        if ( !changed ) {
            return Status.failed( "The add method returned false; appearantly " + "the 13th link was not added to the link end " + "with an upper bound of 13" );
        }

        try {
            changed = lcl.add( coveringLeaf, overflowLeaf );
        } catch ( WrongSizeException oobe ) {
            if ( lcl.getCoveredEnd( coveringLeaf ).size( ) > 13 ) {
                return Status.failed( "Correctly threw exception when link end " + "overflow attempted but the add method " + "changed the link end anyway; number of " + "elements: " + lcl.getCoveredEnd( coveringLeaf ).size( ) );
            }
            Collection<Leaf> current = null;
            try {
                current = lcl.getCoveredEnd( coveringLeaf );
            } catch ( Throwable th ) {
                log.trace( th, MoinSeverity.INFO, "" );
                return Status.failed( "Correctly threw exception when link end " + "overflow attempted, but on subsequent " + "access of the link end, unexpected " + "exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " encountered" );
            }
            if ( !Util.equalCollections( expected, current ) ) {
                return Status.failed( "Correctly threw exception when link end " + "overflow attempted, but on subsequent " + "access of the link end, determined that " + "the add which triggered the overflow " + "altered the link end" );
            } else {
                return Status.passed( "Correctly threw exception when link end " + "overflow attempted and correctly " + "maintained link values" );
            }
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Threw exception and when link end " + "overflow attempted, but the exception was " + "not the expected WrongSizeException; " + "instead, exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " encountered" );
        }
        if ( changed ) {
            return Status.failed( "Overflow was not detected; The 14th element " + "was added to the reference defined with upper " + "bound of 13 (at least, true was returned from " + "the add method)" );
        }
        Collection<Leaf> current = null;
        try {
            current = coveringLeaf.getCovers( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Returned false from the add method, " + "indicating that the overflow attempt was " + "detected, but on subsequent" + "access of the link end, unexpected " + "exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " encountered" );
        }
        if ( !Util.equalCollections( expected, current ) ) {

            return Status.failed( "Returned false from the add method, " + "indicating that the overflow attempt was " + "detected, but on subsequent" + "access of the link end, determined that " + "the add which triggered the overflow " + "altered the link end" );
        } else {
            return Status.passed( "Returned false from the add method, " + "indicating that the overflow attempt was " + "detected, and correctly " + "maintained link values" );
        }
    }

    /**
     * Defines the referenceUnderflow test. This test uses refVerifyConstraints
     * to detect an underflow condition -- a reference having fewer values than
     * required by the multiplicity definition.
     * <p>
     * Since underflow is never prevented, it can only be detected using the
     * refVerifyConstraints method.
     * 
     * @return a <code>Status</code> value
     */
    public Status referenceUnderflow( ) {

        boolean deep = getBooleanParam( "deep", false );
        boolean onRefPackage = getBooleanParam( "onPackage", false );

        LinksPackage lp = (LinksPackage) rp;
        Green green = null;
        try {
            green = (Green) lp.getGreen( ).refCreateInstance( Arrays.asList( "Coating", "bluish", "yellowee", "dark" ) );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.error( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " setting up the test" );
        }

        Collection<JmiException> violations = null;
        String targetDesc = null;
        try {
            if ( onRefPackage ) {
                targetDesc = "LinksPackage RefPackage instance";
                violations = lp.refVerifyConstraints( deep );
            } else {
                targetDesc = "Green instance";
                violations = green.refVerifyConstraints( deep );
            }
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " when invoking refVerifyConstraints on a " + targetDesc + ";  a Green instance has an underflow reference" );
        }

        if ( violations == null ) {
            return Status.failed( "The refVerifyConstraints method invoked on a " + targetDesc + " did not detect the underflow " + "condition as a " + "constraint violation; it returned null" );
        }

        trOut.println( "refVerifyConstraints returned " + violations.size( ) + " elements" );
        for ( Iterator<JmiException> i = violations.iterator( ); i.hasNext( ); ) {
            Object obj = i.next( );
            if ( obj == null ) {
                return Status.failed( "The refVerifyConstraint method invoked " + "on a " + targetDesc + " returned a collection with a null element" );
            }
            JmiException exc;
            try {
                exc = (JmiException) obj;
            } catch ( ClassCastException cce ) {
                return Status.failed( "The refVerifyConstraint method returned " + "a collection with an element that was not " + "a JmiException; instead, it was an  " + "instance of " + obj.getClass( ).getName( ) );
            }
            if ( exc instanceof WrongSizeException ) {
                return Status.passed( "The refVerifyConstraints method invoked " + "on a " + targetDesc + "detected the underflow condition as a " + "constraint violation, and returned a " + "WrongSizeException instance" );
            } else if ( exc instanceof ConstraintViolationException ) {
                return Status.passed( "The refVerifyConstraints method invoked " + "on a " + targetDesc + "detected the underflow condition as a " + "constraint violation, and returned a " + "ConstraintViolationException instance" );
            } else {
                trOut.println( "Collection returned from refVerifyConstraints " + "included a " + exc.getClass( ).getName( ) + " with the message " + exc );
            }

        }
        return Status.failed( "The refVerifyConstraints method invoked " + "on a " + targetDesc + " did not " + "detect the underflow condition as a " + "constraint violation; it returned "
                              + ( ( violations.isEmpty( ) ) ? " no violations" : "violations, but none of type ConstraintViolationException" ) );
    }
}
