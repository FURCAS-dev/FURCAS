package com.sap.tc.moin.repository.test.jmitck.tst3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.ClosureViolationException;
import com.sap.tc.moin.repository.mmi.reflect.CompositionCycleException;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.MetamodelLoader;
import com.sap.tc.moin.repository.test.jmitck.TestErrorException;
import com.sap.tc.moin.repository.test.jmitck.javatest.Status;
import com.sap.tc.moin.repository.test.jmitck.modelsem.SemModelTests;
import com.sap.tc.moin.repository.test.jmitck.modelsem.Util;
import com.sap.tc.moin.repository.test.jmitck.tst3.composition.Child;
import com.sap.tc.moin.repository.test.jmitck.tst3.composition.CompositionPackage;
import com.sap.tc.moin.repository.test.jmitck.tst3.composition.GrandParent;
import com.sap.tc.moin.repository.test.jmitck.tst3.composition.Parent;
import com.sap.tc.moin.repository.test.jmitck.tst3.composition.ParentChild;
import com.sap.tc.moin.repository.test.jmitck.tst3.composition.ParentGrownParent;

/**
 * Defines tests of composition features.
 */
@SuppressWarnings( "nls" )
public class CompositionTests extends SemModelTests {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, CompositionTests.class );

    /**
     * Defines a test to create a fairly deep, complex composition.
     * 
     * @return a <code>Status</code> value
     */
    public Status createComposition( ) {

        try {
            constructComposition( (CompositionPackage) rp );
        } catch ( Throwable th ) {
            return Status.failed( "Could not construct a composition: " + "encountered undexpected " + Util.showExc( th ) );
        }
        return Status.passed( "Constructed a composition without raising exception" );
    }

    /**
     * Creates a fairly deep, complex composition. The created composition is
     * used in a number of tests.
     * 
     * @return the root (top-most composite) of the composition.
     */
    public static GrandParent constructComposition( CompositionPackage cpkg ) {

        //lifecycle-dependency
        try {
            RefClass gpc = cpkg.getGrandParent( );
            RefClass pc = cpkg.getParent( );
            GrandParent gp = (GrandParent) gpc.refCreateInstance( );
            Parent p1 = (Parent) pc.refCreateInstance( );
            Parent p2 = (Parent) pc.refCreateInstance( );
            Parent p3 = (Parent) pc.refCreateInstance( );
            Parent p4 = (Parent) pc.refCreateInstance( );
            gp.setName( "Grandpa" );
            p1.setName( "Parent One" );
            p2.setName( "Parent Two" );
            p3.setName( "Parent Three" );
            p4.setName( "Parent Four" );

            Parent cp1 = (Parent) pc.refCreateInstance( );
            Parent cp2 = (Parent) pc.refCreateInstance( );
            cp1.setName( "Childless Parent One" );
            cp2.setName( "Childless Parent Two" );

            Collection<Parent> gpChildren = gp.getChildren( );
            Collection<Parent> temp = new ArrayList<Parent>( );
            temp.add( p1 );
            temp.add( p2 );
            temp.add( cp1 );
            gpChildren.addAll( temp );

            gpChildren = p1.getParentChildren( );
            gpChildren.add( p3 );
            gpChildren.add( cp2 );

            RefClass cc = cpkg.getChild( );

            Child c1 = (Child) cc.refCreateInstance( );
            Child c2 = (Child) cc.refCreateInstance( );
            Child c3 = (Child) cc.refCreateInstance( );
            c1.setName( "First Child" );
            c2.setName( "Second Child" );
            c3.setName( "Third Child" );

            Child k1 = (Child) cc.refCreateInstance( );
            Child k2 = (Child) cc.refCreateInstance( );
            Child k3 = (Child) cc.refCreateInstance( );
            k1.setName( "First Kid" );
            k2.setName( "First Kid" );
            k3.setName( "First Kid" );

            Child s1 = (Child) cc.refCreateInstance( );
            s1.setName( "Only Son" );

            Child u1 = (Child) cc.refCreateInstance( );
            Child u2 = (Child) cc.refCreateInstance( );
            u1.setName( "First Unrelated" );
            u2.setName( "Second Unrelated" );
            p4.getChildren( ).add( u1 );
            p4.getChildren( ).add( u2 );

            List<Child> pChildren = p1.getChildren( );
            pChildren.add( c1 );
            pChildren.add( c2 );
            pChildren.add( c3 );

            pChildren = p2.getChildren( );
            pChildren.add( k1 );
            pChildren.add( k2 );
            pChildren.add( k3 );

            pChildren = p3.getChildren( );
            pChildren.add( s1 );

            u1.getFriends( ).add( s1 );
            u2.getFriends( ).add( s1 );
            c3.getFriends( ).add( u1 );
            k3.getFriends( ).add( u2 );
            u2.getFriends( ).add( k3 );
            u2.getFriends( ).add( u1 );
            return gp;

        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "Exception creating Composition elments for the test" );
            throw new TestErrorException( "Unexpected exception creating objects " + "in CompositionPackage for the test; " + "Exception type: " + th.getClass( ).getName( ) + " with message: " + th );
        }

    }

    /**
     * Defines the refImmediateInComp test, which invokes refImmediateCompsite
     * on each element in the composition, except the top-most composite object.
     * 
     * @return a <code>Status</code> value
     */
    public Status refImmediateCompositeTest( ) {

        GrandParent gp = constructComposition( (CompositionPackage) rp );
        Collection<Parent> children = gp.getChildren( );
        for ( Iterator<Parent> i = children.iterator( ); i.hasNext( ); ) {
            Parent p = i.next( );
            RefFeatured immed = p.refImmediateComposite( );
            if ( immed == null ) {
                return Status.failed( "Call to refImmediateComposite returned " + "null, but element of type \"Parent\" " + "with name \"" + p.getName( ) + "\" is in " + "composition of \"GrandParent\" with name \"" + gp.getName( ) );
            }
            if ( !immed.equals( gp ) ) {
                return Status.failed( "Call to refImmediateComposite returned " + " an instance of type " + immed.getClass( ).getName( ) + " which was " + "not the expected  element \"GrandParent\" " + "with name \"" + gp.getName( ) );
            }
            Collection<Parent> parentChildren = p.getParentChildren( );
            for ( Iterator<Parent> j = parentChildren.iterator( ); j.hasNext( ); ) {
                Parent cp = j.next( );
                RefFeatured immed2 = cp.refImmediateComposite( );
                if ( immed2 == null ) {
                    return Status.failed( "Call to refImmediateComposite returned " + "null, but element of type \"Parent\" " + "with name \"" + cp.getName( ) + "\" is in " + "composition of \"Parent\" with name \"" + p.getName( ) );
                }
                if ( !immed2.equals( p ) ) {
                    return Status.failed( "Call to refImmediateComposite returned " + " an instance of type " + immed2.getClass( ).getName( ) + " which was " + "not the expected  element \"Parent\" " + "with name \"" + p.getName( ) );
                }
                Collection<Parent> grandkids = cp.getParentChildren( );
                for ( Iterator<Parent> k = grandkids.iterator( ); k.hasNext( ); ) {
                    Child c = (Child) k.next( );
                    RefFeatured immed3 = c.refImmediateComposite( );
                    if ( immed3 == null ) {
                        return Status.failed( "Call to refImmediateComposite " + "returned null, but element of type " + "\"Child\" with name \"" + c.getName( ) + "\" is in composition of \"Parent\" " + "with name \"" + cp.getName( ) );
                    }
                    if ( !immed3.equals( cp ) ) {
                        return Status.failed( "Call to refImmediateComposite " + "returned an instance of type " + immed3.getClass( ).getName( ) + " which was not the expected element " + "\"GrandParent\" with name \"" + gp.getName( ) );
                    }
                }

            }

        }
        return Status.passed( "All calls to refImmediateComposite invoked on " + "objects in composition returned the correct value" );
    }

    /**
     * Defines the refImmediateTopLevel test, which invokes refImmediateCompsite
     * on the top-most composite object of the composition.
     * 
     * @return a <code>Status</code> value
     */
    public Status refImmediateCompositeTopLevelTest( ) {

        GrandParent gp = constructComposition( (CompositionPackage) rp );
        RefFeatured rf = gp.refImmediateComposite( );
        if ( rf == null ) {
            return Status.passed( "Uncontained element returns null from " + "refImmediateComposite" );
        } else {
            return Status.passed( "Uncontained element returned an object of " + " type " + rf.getClass( ).getName( ) + " from refImmediateComposite; should return null" );
        }
    }

    /**
     * Defines the boundary condition test to insure that an element cannot
     * reference itself as a component in a composite link.
     * 
     * @return a <code>Status</code> value
     */
    public Status selfCompositionTest( ) {

        CompositionPackage cpkg = (CompositionPackage) rp;
        RefClass pc = cpkg.getParent( );
        Parent p = (Parent) pc.refCreateInstance( );
        p.setName( "Parent" );
        try {
            p.getParentChildren( ).add( p );
            return Status.failed( "Setting an element as a component of itself " + "did not throw the required " + "CompositionCycleException (or any other " + "exception)" );
        } catch ( CompositionCycleException cce ) {
            RefObject elementInError = cce.getElementInError( );
            if ( elementInError == null ) {
                String msg = "Setting an element as a component of itself " + "resulted in a CompositionCycleException, as expected, " + "but the exeception's getElementInError method returned null";
                return Status.failed( msg );
            }
            if ( !( elementInError instanceof ModelElement ) ) {
                String msg = "Setting an element as a component of itself " + "resulted in a CompositionCycleException, as expected, " + "but the exeception's getElementInError method returned an " + "instance of " + elementInError.getClass( ).getName( ) + " which is not a ModelElement subtype";
                return Status.failed( msg );
            }
            String msg = "Setting an element as a component of itself " + "resulted in a CompositionCycleException, and the exeception's " + "getElementInError method returned an instance of a " + "ModelElement subtype, as expected";
            return Status.passed( msg );
        } catch ( Throwable th ) {
            String msg = "Setting an element as a component of itself " + "caused the " + Util.showExc( th ) + " to be thrown; but a " + "CompositionCycleException was expected";
            return Status.failed( msg );
        }
    }

    /**
     * Defines the boundary condition test to insure that an element cannot be
     * contained within its own composition, considering the closure of the
     * composite. The test creates 9 levels of components, then links the lowest
     * component element to the root element as its component. This link places
     * the root element within it own overall components, but 10 levels of
     * components must be traversed to detect the cyclic composition.
     * 
     * @return a <code>Status</code> value
     */
    public Status cyclicCompositionTest( ) {

        String method = getParam( "method", true );
        CompositionPackage cpkg = (CompositionPackage) rp;
        RefClass pc = cpkg.getParent( );
        final int P_CNT = 10;
        Parent[] parents = new Parent[P_CNT];
        ParentGrownParent pgpAssoc = cpkg.getParentGrownParent( );
        try {
            for ( int i = 0; i < P_CNT; i++ ) {
                parents[i] = (Parent) pc.refCreateInstance( );
                parents[i].setName( "Parent" + i );
            }
            for ( int i = 1; i < P_CNT; i++ ) {
                parents[i - 1].getParentChildren( ).add( parents[i] );
            }
        } catch ( Throwable th ) {
            return Status.error( "Unexpected " + Util.showExc( th ) + " while setting up test; unable to run test" );
        }
        try {
            // just to check
            //       Parent start = parents[P_CNT - 1];
            //       Parent current = start;
            //       boolean isCyclic = false;
            //       for (int i = 0; i < P_CNT + 1; i++) {
            //          Parent currentParent = (Parent) current.refImmediateComposite();
            //          if (currentParent.equals(start)) {
            //             isCyclic = true;
            //             trOut.println("Detected parent at the " + i + " level as " +
            //                           " the same as starting element");
            //             break;
            //          }
            //          current = currentParent;
            //       }
            //       if (!isCyclic) {
            //          throw new TestErrorException("Attempt to create a cyclic " +
            //                                       "composition failed");
            //       }
            if ( method.equals( "add" ) ) {
                parents[P_CNT - 1].getParentChildren( ).add( parents[0] );
            } else if ( method.equals( "addLink" ) ) {
                pgpAssoc.add( parents[P_CNT - 1], parents[0] );
            } else if ( method.equals( "refAddLink" ) ) {
                pgpAssoc.refAddLink( parents[P_CNT - 1], parents[0] );
            } else {
                return Status.error( "Specified method of " + method + " unknown for this test " );
            }
            parents[P_CNT - 1].getParentChildren( ).clear( );
            return Status.failed( "Setting an element as a component of its " + "component did not throw the required " + "CompositionCycleException (or any other " + "exception)" );
        } catch ( CompositionCycleException cce ) {
            parents[P_CNT - 1].getParentChildren( ).clear( );
            RefObject elementInError = cce.getElementInError( );
            if ( elementInError == null ) {
                String msg = "Setting an element as a component of its component " + "resulted in a CompositionCycleException, as expected, " + "but the exeception's getElementInError method returned null";
                return Status.failed( msg );
            }
            if ( !( elementInError instanceof ModelElement ) ) {
                String msg = "Setting an element as a component of its component " + "resulted in a CompositionCycleException, as expected, " + "but the exeception's getElementInError method returned an " + "instance of " + elementInError.getClass( ).getName( )
                             + " which is not a ModelElement subtype";
                return Status.failed( msg );
            }
            String msg = "Setting an element as a component of its component " + "resulted in a CompositionCycleException, and the exeception's " + "getElementInError method returned an instance of a " + "ModelElement subtype, as expected";
            return Status.passed( msg );
        } catch ( Throwable th ) {
            parents[P_CNT - 1].getParentChildren( ).clear( );
            String msg = "Setting an element as a component of its component " + "caused the " + Util.showExc( th ) + " to be thrown; but a " + "CompositionCycleException was expected";
            return Status.failed( msg );
        }
    }

    /**
     * Defines the closureViolationt test.
     * <p>
     * This boundary condition test ensures that an element in one outermost
     * extent can be a component of an element from a different outermost
     * extent.
     * <p>
     * This test was modified to reflect the MOIN repository implementation
     * which has no restrictions concerning composition and reference closure.
     * 
     * @return a <code>Status</code> value
     */
    public Status closureViolationTest( ) {

        String method = getParam( "method", true );
        CompositionPackage cpkg = (CompositionPackage) rp;
        Parent owningParent = null;
        Child otherExtentChild = null;
        RefObject metaElement = null;
        ParentChild pcAssoc = null;
        try {
            CompositionPackage otherPkg = (CompositionPackage) MetamodelLoader.getInstance( ).getVendorGenerator( ).createRefPackage( "Composition", "com.sap.tc.moin.repository.test.jmitck.tst3" );
            if ( otherPkg == null ) {
                return Status.error( "Second CompositionPackage instance could " + "not be retrieved; value was null" );
            }
            owningParent = (Parent) cpkg.getParent( ).refCreateInstance( );
            owningParent.setName( "parentone" );
            otherExtentChild = (Child) otherPkg.getChild( ).refCreateInstance( );
            otherExtentChild.setName( "other" );
            pcAssoc = cpkg.getParentChild( );
            if ( method.equals( "setRefValue(obj)" ) ) {
                metaElement = Util.getMetaFeature( otherExtentChild, "Composition.Child.parent" );
                if ( metaElement == null ) {
                    return Status.error( "Could not access the needed metadata " + " while setting up test; unable to run test" );
                }
            }
        } catch ( Throwable th ) {
            return Status.error( "Unexpected " + Util.showExc( th ) + " while setting up test; unable to run test" );
        }
        try {
            if ( method.equals( "add" ) ) {
                owningParent.getChildren( ).add( otherExtentChild );
            } else if ( method.equals( "setParent" ) ) {
                otherExtentChild.setParent( owningParent );
            } else if ( method.equals( "addLink" ) ) {
                pcAssoc.add( owningParent, otherExtentChild );
            } else if ( method.equals( "refAddLink" ) ) {
                pcAssoc.refAddLink( owningParent, otherExtentChild );
            } else if ( method.equals( "setRefValue(str)" ) ) {
                otherExtentChild.refSetValue( "parent", owningParent );
            } else if ( method.equals( "setRefValue(obj)" ) ) {
                otherExtentChild.refSetValue( metaElement, owningParent );
            } else {
                return Status.error( "Specified method of " + method + " unknown for this test " );
            }
            if ( owningParent.getChildren( ).isEmpty( ) ) {
                return Status.failed( "Responded to the Composition Closure and the composite was not altered correctly" );
            }
            return Status.passed( "Responded to the Composition Closure and the composite was altered correctly" );
        } catch ( ClosureViolationException cve ) {
            return Status.failed( "Responded to the Composition Closure by thowing a ClosureViolationException which should not be the case in MOIN" );
        } catch ( Throwable th ) {
            return Status.failed( "Responded to the Composition Closure by thowing an excption which should not be the case in MOIN: " + Util.showExc( th ) );
        }
    }
}
