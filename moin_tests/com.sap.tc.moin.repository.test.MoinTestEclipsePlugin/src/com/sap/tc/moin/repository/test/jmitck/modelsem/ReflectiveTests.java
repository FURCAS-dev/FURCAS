package com.sap.tc.moin.repository.test.jmitck.modelsem;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidNameException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidObjectException;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.TestErrorException;
import com.sap.tc.moin.repository.test.jmitck.javatest.Status;

/**
 * Defines a number of tests that do not have compilation dependencies on
 * generated interfaces. These tests exercise methods of the reflective
 * interfaces.
 * 
 * @author <a href="mailto:gk@AKAL"></a>
 * @version 1.0
 */
@SuppressWarnings( "nls" )
public class ReflectiveTests extends SemModelTests {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, ReflectiveTests.class );

    /**
     * Tests the refMofId method, by insuring that the value returned for each
     * RefBaseObject in the extent of the Containment Model is unique.
     * 
     * @return a <code>Status</code> value, indicating the result of the test.
     */
    public Status refMofIdTest( ) {

        // requires the Containment Model
        // preloaded
        makeExtent( rp );

        Map<String, RefObject> allIds = new HashMap<String, RefObject>( );
        return duplicateIdFound( rp, allIds );
    }

    /**
     * Creates an extent, based on the Containment metamodel, and a number of
     * model elements, without using the generated interfaces. Used by various
     * test cases.
     * 
     * @param rp a ContainmentPackage, with a number of corresponding model
     * elements
     */
    public static void makeExtent( RefPackage rp ) {

        try {
            Class<?> containmentExtentClass = Class.forName( "com.sap.tc.moin.repository.test.jmitck.tst4.ContainmentExtent" );
            Class<?> containmentPackageClass = Class.forName( "com.sap.tc.moin.repository.test.jmitck.tst4.containment.ContainmentPackage" );
            Method m = containmentExtentClass.getMethod( "makeExtent", new Class[] { containmentPackageClass } );
            m.invoke( null, new Object[] { rp } );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "Exception creating Containment Extent for the test" );
            throw new TestErrorException( "Unexpected exception creating objects " + "in ContainmentPackage for the test" );
        }
    }

    private Status duplicateIdFound( RefPackage rpkg, Map<String, RefObject> ids ) {

        for ( Iterator<RefClass> i = rpkg.refAllClasses( ).iterator( ); i.hasNext( ); ) {
            RefClass rc = i.next( );
            for ( Iterator<RefObject> j = rc.refAllOfClass( ).iterator( ); j.hasNext( ); ) {
                RefObject ro = j.next( );
                String id = ro.refMofId( );
                if ( id == null ) {
                    return Status.failed( "RefObject " + Util.refBaseObjectAsString( ro ) + " returned null as its MofId, from the " + "refMofId method" );
                }
                RefObject existing = ids.put( id, ro );
                if ( existing != null ) {
                    return Status.failed( "Two RefObject elements [" + Util.refBaseObjectAsString( existing ) + "] and [" + Util.refBaseObjectAsString( ro ) + " have the same MofId: " + id );
                }
            }
        }
        for ( Iterator<RefPackage> i = rpkg.refAllPackages( ).iterator( ); i.hasNext( ); ) {
            RefPackage nested = i.next( );
            Status s = duplicateIdFound( nested, ids );
            if ( !s.isPassed( ) ) {
                return s;
            }
        }
        return Status.passed( "All RefObject MofIds, returned from refMofId " + "method, are unique and non-null" );
    }

    /**
     * Defines the refMetaObject test. For details on the test and its
     * parameters, see the <a
     * href="../../../../../TestTypes/refMetaObject.html">refMetaObject</a>
     * documentation.
     * 
     * @return the results of the test.
     */
    public Status refMetaObjectTest( ) {

        makeExtent( rp );
        String elementKind = getParam( "elementKind", true );
        String elementName = getParam( "elementName", true );
        String metaObjectName = getParam( "metaObjectName", true );
        RefBaseObject obj = null;
        try {
            if ( elementKind.equals( "RefPackage" ) ) {
                obj = Util.getRefPackage( elementName, rp );
                // obj = rp.refPackage(elementName);
            } else if ( elementKind.equals( "RefAssociation" ) ) {
                obj = Util.getRefAssociation( elementName, rp );
                // obj = rp.refAssociation(elementName);
            } else if ( elementKind.equals( "RefClass" ) ) {
                obj = Util.getRefClass( elementName, rp );
                // obj = rp.refClass(elementName);
            } else {
                // for refObject, just grab an instance
                RefClass rc = Util.getRefClass( elementName, rp );
                Collection<RefObject> c = rc.refAllOfClass( );
                if ( c.isEmpty( ) ) {
                    System.out.println( "elementName=" + elementName + " rc=" + rc );
                    throw new TestErrorException( "Could not find an instance of " + "the specified RefObject type " + elementName + " to conduct a refMetaObject test" );
                }
                obj = c.iterator( ).next( );
            }
        } catch ( InvalidNameException ine ) {
            log.trace( ine, MoinSeverity.ERROR, "" );
            return Status.failed( "Unexpected InvalidNameException looking " + " for " + elementKind + " " + elementName + " within " + Util.refBaseObjectAsString( rp ) + " unable to complete test" );
        } catch ( InvalidCallException ice ) {
            log.trace( ice, MoinSeverity.ERROR, "" );
            return Status.failed( "Unexpected InvalidCallException looking " + " for " + elementKind + " " + elementName + " within " + Util.refBaseObjectAsString( rp ) + " unable to complete test" );

        } catch ( TestErrorException tee ) {
            throw tee;
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while setting up to execute refMetaObject; " + "unable to complete test" );

        }
        return checkMetaObject( elementKind, elementName, metaObjectName, obj );
    }

    private Status checkMetaObject( String elementKind, String elementName, String metaObjectName, RefBaseObject rbo ) {

        if ( rbo == null ) {
            throw new TestErrorException( "The " + elementKind + " specified " + elementName + " could not be found " + "to run the test" );
        }
        RefObject meta = rbo.refMetaObject( );
        if ( meta == null ) {
            return Status.failed( "Specified " + elementKind + " " + elementName + " returned null from refMetaOBject" );
        }
        try {
            ModelElement me = (ModelElement) meta;
            String name = Util.dotNotation( me.getQualifiedName( ) );
            if ( !metaObjectName.equals( name ) ) {
                return Status.failed( "Expected specified " + elementKind + " " + elementName + " to return a metaobject " + " named " + metaObjectName + " from refMetaObject; but instead returned " + name );
            } else {
                return Status.passed( "Specified " + elementKind + " " + elementName + " returned a MofPackage " + " named " + metaObjectName + " from refMetaObject as expected" );
            }
        } catch ( ClassCastException cce ) {
            // too small to bother with a Map
            String expectedType = null;
            if ( elementKind.equals( "RefPackage" ) ) {
                expectedType = "MofPackage";
            } else if ( elementKind.equals( "RefAssociation" ) ) {
                expectedType = "Association";
            } else {
                expectedType = "MofClass";
            }
            return Status.failed( "Expected specified " + elementKind + " " + elementName + " to return a " + expectedType + " from refMetaObject; but instead returned " + " an instance of " + meta.getClass( ).getName( ) );
        }
    }

    /**
     * Defines the invalidObjDesignator test. For details on the test and its
     * parameters, see the <a
     * href="../../../../../TestTypes/invalidObjDesignator.html"
     * >invalidObjDesignator</a> documentation.
     * 
     * @return the results of the test.
     */
    public Status refBadObjDesignatorTest( ) {

        String attrName = getParam( "attributeName", true );
        String elementName = getParam( "elementName", true );
        makeExtent( rp );
        RefClass rc = Util.getRefClass( elementName, rp );
        Collection<RefObject> c = rc.refAllOfClass( );
        if ( c.isEmpty( ) ) {
            throw new TestErrorException( "Could not find an instance of the " + "specified RefObject type " + elementName + " to conduct a invalidObjDesignator " + "test" );
        }
        RefObject ro = c.iterator( ).next( );

        MofClass metaClass = (MofClass) ro.refMetaObject( );
        Attribute metaAttr;
        try {
            metaAttr = (Attribute) metaClass.lookupElementExtended( attrName );
        } catch ( NameNotFoundException nnfe ) {
            throw new TestErrorException( "Test specification error; " + attrName + " is not an attribute of " + elementName );
        }
        Collection<RefObject> allAttributes = metaAttr.refClass( ).refAllOfClass( );
        Attribute otherAttr = null;
        boolean found = false;
        for ( Iterator<RefObject> i = allAttributes.iterator( ); i.hasNext( ) && !found; ) {
            otherAttr = (Attribute) i.next( );
            try {
                found = !( metaClass.lookupElementExtended( otherAttr.getName( ) ) instanceof Attribute );
            } catch ( NameNotFoundException e ) {
                found = true;
            }
        }
        if ( !found ) {
            return Status.error( "Error in test setup; Could not find another " + "Attribute to use as an incorrect designator" );
        }

        trOut.println( "Will invoke refGetValue on a " + elementName + " using the incorrect RefObject designator " + Util.refBaseObjectAsString( otherAttr ) + " instead of a valid designator: " + Util.refBaseObjectAsString( metaAttr ) );
        try {
            ro.refGetValue( otherAttr );
            return Status.failed( "Used the incorrect RefObject designator in " + "the refGetValue method on a " + elementName + "; the expected InvalidCallException was not " + "thrown" );
        } catch ( InvalidCallException ioe ) {
            return Status.passed( "Correctly threw an InvalidObjectException" );
        } catch ( Throwable th ) {
            return Status.failed( "Exception thrown in response to the incorrect " + "RefObject designator was not the expected " + "InvalidCallException; but was a " + th.getClass( ).getName( ) + " with the message " + th.getMessage( ) );
        }
    }

//    private Status checkLinkCount( String assocName, int expected ) {
//
//        int cnt = Util.getRefAssociation( assocName, rp ).refAllLinks( ).size( );
//        if ( cnt != expected ) {
//            return Status.failed( "After refDelete, expected " + expected + " links in Association " + assocName + "; instead found " + cnt + " links" );
//        } else {
//            return Status.passed( "" );
//        }
//    }

    private Status checkExtentCount( String className, int expected ) {

        int cnt = Util.getRefClass( className, rp ).refAllOfClass( ).size( );
        if ( cnt != expected ) {
            return Status.failed( "After refDelete, expected " + expected + "instances of " + className + "; instead found " + cnt + " instances" );
        } else {
            return Status.passed( "" );
        }
    }

    /**
     * Defines the refDelete test. This test creates a deep composition of model
     * elements in the CompositionPackage, along with some elements not in the
     * composition. It creates a number of non-composite links between objects
     * in and out of the composition. Then refDelete is invoked on the root of
     * the composition. Afterwords, the extent of each RefClass and
     * RefAssociation is checked, to make sure only the expected links and
     * objects remain.
     * 
     * @return a <code>Status</code> value
     */
    public Status refDelete( ) {

        int cnt = 0;
        for ( Iterator<RefClass> i = rp.refAllClasses( ).iterator( ); i.hasNext( ); ) {
            RefClass rc = i.next( );
            cnt = cnt + rc.refAllOfClass( ).size( );
        }
        if ( cnt != 0 ) {
            throw new TestErrorException( "Error in pre-test; must start this " + " in an empty extent" );
        }
        RefObject compRoot = null;
        try {
            Class<?> compositionTests = Class.forName( "com.sap.tc.moin.repository.test.jmitck.tst3.CompositionTests" );
            Class<?> compositionPkg = Class.forName( "com.sap.tc.moin.repository.test.jmitck.tst3.composition.CompositionPackage" );
            Method m = compositionTests.getMethod( "constructComposition", new Class[] { compositionPkg } );
            compRoot = (RefObject) m.invoke( null, new Object[] { rp } );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "Exception creating Composition elments for the test" );
            throw new TestErrorException( "Unexpected exception creating objects " + "in CompositionPackage for the test" );
        }

        //Collection links = Util.getRefAssociation( "Composition.ChildFriendOfChild", rp ).refAllLinks( );
        try {
            compRoot.refDelete( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " on invocation of refDelete on a RefObject" );
        }
        Status status = checkExtentCount( "Composition.GrandParent", 0 );
        if ( status.isFailed( ) ) {
            return status;
        }
        status = checkExtentCount( "Composition.Parent", 1 );
        if ( status.isFailed( ) ) {
            return status;
        }
        status = checkExtentCount( "Composition.Child", 2 );
        if ( status.isFailed( ) ) {
            return status;
        }
//        status = checkLinkCount( "Composition.ChildFriendOfChild", 1 );
//        if ( status.isFailed( ) ) {
//            return status;
//        }
//        status = checkLinkCount( "Composition.GrandParentParent", 0 );
//        if ( status.isFailed( ) ) {
//            return status;
//        }
//        status = checkLinkCount( "Composition.ParentChild", 2 );
//        if ( status.isFailed( ) ) {
//            return status;
//        }
//        status = checkLinkCount( "Composition.ParentGrownParent", 0 );
//        if ( status.isFailed( ) ) {
//            return status;
//        }
        return Status.passed( "After refDelete on the root of a composition " + " hierarchy, the correct number of objects of " + "each type have been removed from the extent, as " + "well as the correct numbe of each kind of link" );
    }

    /**
     * Defines the refInvalidObject test. This test uses the refDelete test to
     * delete the elements of a composition, then tries to access a deleted
     * object from the reference of a valid object. The implementation should
     * either no longer have the reference value available (link was deleted) or
     * now raise an InvalidObjectException.
     * 
     * @return a <code>Status</code> value
     */
    public Status refInvalidObjectTest( ) {

        Status preStat = refDelete( );
        if ( !preStat.isPassed( ) ) {
            return Status.error( "Could not conduct the test for Invalid Object; " + "error setting up" );
        }

        Collection<RefObject> children = rp.refClass( "Child" ).refAllOfClass( );
        // Collection children = rp.refClass("Composition.Child").refAllOfClass();
        for ( Iterator<RefObject> i = children.iterator( ); i.hasNext( ); ) {
            RefObject child = i.next( );
            try {
                // Collection badColl =
                //    (Collection) child.refGetValue("Composition.Child.friends");
                Collection<?> badColl = (Collection<?>) child.refGetValue( "friends" );
                for ( Iterator<?> j = badColl.iterator( ); j.hasNext( ); ) {
                    RefObject ro = (RefObject) j.next( );
                    if ( !children.contains( ro ) ) {
                        return Status.failed( "An object maintained a valid reference " + "to an object that was deleted; " + Util.refBaseObjectAsString( child ) + " references deleted object " + Util.refBaseObjectAsString( ro ) );
                    }
                }
            } catch ( InvalidObjectException ioe ) {
                trOut.println( "An object which previously referenced an element " + "that was deleted now throws an " + "InvalidObjectException on access" );
            } catch ( Throwable th ) {
                return Status.failed( "An object which previously referenced an " + "element to an object that was deleted " + " threw an exception on accesss, but not " + "the expected InvalidObjectException; " + "instead it as a " + th.getClass( ).getName( ) + " with the message " + th );
            }
        }
        return Status.passed( "All objects which previously referenced elements " + "that were deleted no longer reference the " + "deleted elements" );

    }

    /**
     * Defines the refPackageAccess test, which tests the implementation of
     * refAllPackages, refAllAssociations, and refAllClasses
     * 
     * @return a <code>Status</code> value
     */
    public Status refPackageAccess( ) {

        Map<String, String[]> packages = containmentPackages( );
        Map<String, String[]> classes = containmentClasses( );
        Map<String, String[]> associations = containmentAssociations( );
        makeExtent( rp );
        return checkRefAllPackages( rp, packages, classes, associations );

    }

    private List<String> makeNameList( Map<String, String[]> map, String key ) {

        String[] names = map.get( key );
        if ( names == null ) {
            return new ArrayList<String>( );
        } else {
            return Arrays.asList( names );
        }
    }

    private Status checkRefAllPackages( RefPackage rpkg, Map<String, String[]> packages, Map<String, String[]> classes, Map<String, String[]> associations ) {

        String pkgName = ( (ModelElement) rpkg.refMetaObject( ) ).getName( );
        List<String> pkgNames = makeNameList( packages, pkgName );
        List<String> assocNames = makeNameList( associations, pkgName );
        List<String> clsNames = makeNameList( classes, pkgName );
        Collection<RefPackage> componentPkgs = null;
        Collection<RefClass> componentCls = null;
        Collection<RefAssociation> componentAssoc = null;
        try {
            componentPkgs = rpkg.refAllPackages( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " on invocation of refAllPackages" );
        }
        try {
            componentAssoc = rpkg.refAllAssociations( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " on invocation of refAllAssociations" );
        }
        try {
            componentCls = rpkg.refAllClasses( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " on invocation of refAllClasses" );
        }
        for ( Iterator<RefPackage> i = componentPkgs.iterator( ); i.hasNext( ); ) {
            Object obj = i.next( );
            if ( obj == null ) {
                return Status.failed( "The refAllPackages method returned a " + "collection with a null element" );
            }

            RefPackage containedPkg;
            try {
                containedPkg = (RefPackage) obj;
            } catch ( ClassCastException cce ) {
                return Status.failed( "The refAllPackages method returned a " + "collection with an element that was not " + "a RefPackage; it was an instance of " + obj.getClass( ).getName( ) );
            }
            String name = ( (ModelElement) containedPkg.refMetaObject( ) ).getName( );
            if ( !pkgNames.contains( name ) ) {
                return Status.failed( "The refAllPackages method invoked on " + pkgName + " returned a " + name + " package; not expected" );
            }
        }

        for ( Iterator<RefAssociation> i = componentAssoc.iterator( ); i.hasNext( ); ) {
            Object obj = i.next( );
            if ( obj == null ) {
                return Status.failed( "The refAllAssociations method invoked on " + pkgName + " returned a " + "collection with a null element" );
            }

            RefAssociation containedAssoc;
            try {
                containedAssoc = (RefAssociation) obj;
            } catch ( ClassCastException cce ) {
                return Status.failed( "The refAllAssociations method invoked on " + pkgName + " returned a " + "collection with an element that was not " + "a RefAssociation; it was an instance of " + obj.getClass( ).getName( ) );
            }
            String name = ( (ModelElement) containedAssoc.refMetaObject( ) ).getName( );
            if ( !assocNames.contains( name ) ) {
                return Status.failed( "The refAllAssociations method invoked on " + pkgName + " returned a " + name + " association; not expected" );
            }
        }

        for ( Iterator<RefClass> i = componentCls.iterator( ); i.hasNext( ); ) {
            Object obj = i.next( );
            if ( obj == null ) {
                return Status.failed( "The refAllClasses method invoked on " + pkgName + " returned a " + "collection with a null element" );
            }

            RefClass containedCls;
            try {
                containedCls = (RefClass) obj;
            } catch ( ClassCastException cce ) {
                return Status.failed( "The refAllClasses method invoked on " + pkgName + " returned a " + "collection with an element that was not " + "a RefClass; it was an instance of " + obj.getClass( ).getName( ) );
            }
            String name = ( (ModelElement) containedCls.refMetaObject( ) ).getName( );
            if ( !clsNames.contains( name ) ) {
                return Status.failed( "The refAllClasses method invoked on " + pkgName + " returned a " + name + " class; not expected" );
            }
        }

        Status finalStatus = null;
        for ( Iterator<RefPackage> i = componentPkgs.iterator( ); i.hasNext( ); ) {
            RefPackage containedPkg = i.next( );
            Status s = checkRefAllPackages( containedPkg, packages, classes, associations );
            if ( !s.isPassed( ) ) {
                return s;
            } else {
                finalStatus = ( finalStatus == null ) ? s : finalStatus.augment( s );
            }
        }
        String msg = "Each of refAllPackages, refAllAssociations, and " + "refAllClassed returned the expected results for RefPackage " + pkgName;
        return ( finalStatus == null ) ? Status.passed( msg ) : finalStatus.augment( msg );
    }

    private Map<String, String[]> containmentPackages( ) {

        Map<String, String[]> packages = new HashMap<String, String[]>( );
        packages.put( "Containment", new String[] { "Pkg1", "Pkg2", "InnerContainment", "Inner2Containment" } );
        packages.put( "InnerContainment", new String[] { "DeepContainment" } );
        packages.put( "Pkg1", new String[] { "Pkg1InnerPkg" } );
        packages.put( "Pkg2", new String[] { "Pkg2BasePkg", "Pkg2InnerPkgA", "Pkg2InnerPkgB" } );
        return packages;
    }

    private Map<String, String[]> containmentClasses( ) {

        Map<String, String[]> classes = new HashMap<String, String[]>( );
        classes.put( "Pkg1", new String[] { "ClassInPkg1" } );
        classes.put( "Pkg1InnerPkg", new String[] { "ClassInInnerPkg" } );
        classes.put( "Pkg2", new String[] { "ClassInPkg2", "MultiInheriting" } );
        classes.put( "Pkg2BasePkg", new String[] { "BaseClassInInnerPkg" } );
        classes.put( "Pkg2InnerPkgA", new String[] { "ClassAInInnerPkgA" } );
        classes.put( "Pkg2InnerPkgB", new String[] { "ClassBInInnerPkgB" } );
        classes.put( "Containment", new String[] { "ClassInTopLevel" } );
        classes.put( "Inner2Containment", new String[] { "ClassInInner2" } );
        classes.put( "InnerContainment", new String[] { "ClassInInner" } );
        classes.put( "DeepContainment", new String[] { "ClassInDeep" } );
        return classes;
    }

    private Map<String, String[]> containmentAssociations( ) {

        Map<String, String[]> associations = new HashMap<String, String[]>( );
        associations.put( "Containment", new String[] { "InnerLinksImportedInner", "LinkingTwoNested", "OuterInner" } );
        associations.put( "DeepContainment", new String[] { "DeepOuterInDeep", "ReachingIntoCluster" } );

        return associations;
    }

    /**
     * Defines the refPackageAccessByMetaobject test, which tests the
     * refPackage, refAssociation, and refClass methods, using metaobject
     * designators as arguments
     * 
     * @return a <code>Status</code> value
     */
    public Status refPackageAccessByMetaobject( ) {

        Map<String, String[]> packages = containmentPackages( );
        Map<String, String[]> classes = containmentClasses( );
        Map<String, String[]> associations = containmentAssociations( );
        makeExtent( rp );
        return checkRefPackagesByMetaObject( rp, packages, classes, associations );

    }

    private ModelElement lookupElement( MofPackage parent, String name, String kind ) {

        ModelElement answer = null;
        try {
            answer = parent.lookupElementExtended( name );
        } catch ( NameNotFoundException nnfe ) {
            // ignore and deal with below
        }
        if ( answer == null || ( kind.equals( "MofPackage" ) && !( answer instanceof MofPackage ) ) ) {
            log.trace( MoinSeverity.DEBUG, "Couldn't find " + name );
            if ( kind.equals( "MofPackage" ) ) {
                log.trace( MoinSeverity.DEBUG, "Look within the topLevel Packages for a cluster" );
                for ( Iterator<RefObject> i = parent.refClass( ).refAllOfClass( ).iterator( ); i.hasNext( ); ) {
                    MofPackage topLevel = (MofPackage) i.next( );
                    log.trace( MoinSeverity.DEBUG, "Top level Package " + topLevel.getName( ) );
                    if ( name.equals( topLevel.getName( ) ) ) {
                        log.trace( MoinSeverity.DEBUG, "Top Level matched" );
                        return topLevel;
                    }
                }
            }
            // log.trace(MoinSeverity.ERROR, "", nnfe);
            throw new TestErrorException( kind + " named " + name + " could not " + "be found within MofPackage " + Util.dotNotation( parent.getQualifiedName( ) ) );
        }
        return answer;
    }

    private Status checkRefPackagesByMetaObject( RefPackage rpkg, Map<String, String[]> packages, Map<String, String[]> classes, Map<String, String[]> associations ) {

        MofPackage mp = rpkg.refMetaObject( );
        String pkgName = mp.getName( );
        List<String> pkgNames = makeNameList( packages, pkgName );
        List<String> assocNames = makeNameList( associations, pkgName );
        List<String> clsNames = makeNameList( classes, pkgName );
        Status finalStatus = null;
        for ( Iterator<String> i = pkgNames.iterator( ); i.hasNext( ); ) {
            String name = i.next( );
            MofPackage nestedMeta = (MofPackage) lookupElement( mp, name, "MofPackage" );
            RefPackage nested;
            try {
                nested = rpkg.refPackage( nestedMeta );
            } catch ( Throwable th ) {
                return Status.failed( "Within the RefPackage " + pkgName + " refPackage(" + Util.refBaseObjectAsString( nestedMeta ) + ") resulted in an unexpected exception: " + th.getClass( ).getName( ) + " with the message " + th );
            }
            if ( nested == null ) {
                return Status.failed( "Within the RefPackage " + pkgName + " refPackage(" + Util.refBaseObjectAsString( nestedMeta ) + ") returned null" );
            }
            Status s = checkRefPackagesByMetaObject( nested, packages, classes, associations );
            if ( !s.isPassed( ) ) {
                return s;
            }
            finalStatus = ( finalStatus == null ) ? s : finalStatus.augment( s );
        }
        for ( Iterator<String> i = clsNames.iterator( ); i.hasNext( ); ) {
            String name = i.next( );
            MofClass metaClass = (MofClass) lookupElement( mp, name, "MofClass" );

            RefClass rc;
            try {
                rc = rpkg.refClass( metaClass );
            } catch ( Throwable th ) {
                return Status.failed( "Within the RefPackage " + pkgName + " refClass(" + Util.refBaseObjectAsString( metaClass ) + ") resulted in an unexpected exception: " + th.getClass( ).getName( ) + " with the message " + th );
            }
            if ( rc == null ) {
                return Status.failed( "Within the RefPackage " + pkgName + " refClass(" + Util.refBaseObjectAsString( metaClass ) + ") returned null" );
            }
        }
        for ( Iterator<String> i = assocNames.iterator( ); i.hasNext( ); ) {
            String name = i.next( );
            Association metaAssoc = (Association) lookupElement( mp, name, "Association" );
            RefAssociation ra;
            try {
                ra = rpkg.refAssociation( metaAssoc );
            } catch ( Throwable th ) {
                return Status.failed( "Within the RefPackage " + pkgName + " refAssociation(" + Util.refBaseObjectAsString( metaAssoc ) + ") resulted in an unexpected exception: " + th.getClass( ).getName( ) + " with the message " + th );
            }
            if ( ra == null ) {
                return Status.failed( "Within the RefPackage " + pkgName + " refAssociation(" + Util.refBaseObjectAsString( metaAssoc ) + ") returned null" );
            }
        }
        String msg = "Each RefPackage, RefAssociation, and RefClass contained " + "in " + pkgName + " was retrieved by metobject designator using " + "the corresponding refPackage, refAssociation, or refClass method";
        return ( finalStatus == null ) ? Status.passed( msg ) : finalStatus.augment( msg );
    }

    /**
     * Defines the refPackageAccessByString test, which tests the refPackage,
     * refAssociation, and refClass methods, using String designators as
     * arguments
     * 
     * @return a <code>Status</code> value
     */
    public Status refPackageAccessByString( ) {

        Map<String, String[]> packages = containmentPackages( );
        Map<String, String[]> classes = containmentClasses( );
        Map<String, String[]> associations = containmentAssociations( );
        makeExtent( rp );
        return checkRefPackagesByString( rp, packages, classes, associations );

    }

    private Status checkRefPackagesByString( RefPackage rpkg, Map<String, String[]> packages, Map<String, String[]> classes, Map<String, String[]> associations ) {

        String fullPackageName = Util.typeName( rpkg );
        String pkgName = Util.simpleNameOf( fullPackageName );

        List<String> pkgNames = makeNameList( packages, pkgName );
        List<String> assocNames = makeNameList( associations, pkgName );
        List<String> clsNames = makeNameList( classes, pkgName );
        Status finalStatus = null;
        for ( Iterator<String> i = pkgNames.iterator( ); i.hasNext( ); ) {
            String name = i.next( );
            RefPackage nested;
            //       String nestedPkgName;
            //       String nextLevelPrefix;
            //       if (name.equals("Pkg1") || name.equals("Pkg2")) {
            //          nestedPkgName = name;
            //          nextLevelPrefix = "";
            //       } else {
            //          nestedPkgName = fullPackageName + "." + name;
            //          nextLevelPrefix = fullPackageName + ".";
            //       }
            try {
                if ( name.indexOf( "." ) != -1 ) {
                    throw new RuntimeException( "Attempted to call refPackage using " + name );
                }
                nested = rpkg.refPackage( name );
            } catch ( Throwable th ) {
                return Status.failed( "Within the RefPackage " + fullPackageName + " refPackage(" + name + ") resulted in an unexpected exception: " + th.getClass( ).getName( ) + " with the message " + th );
            }
            if ( nested == null ) {
                return Status.failed( "Within the RefPackage " + fullPackageName + " refPackage(" + name + ") returned null" );
            }
            Status s = checkRefPackagesByString( nested, packages, classes, associations );
            if ( !s.isPassed( ) ) {
                return s;
            }
            finalStatus = ( finalStatus == null ) ? s : finalStatus.augment( s );
        }
        for ( Iterator<String> i = clsNames.iterator( ); i.hasNext( ); ) {
            String name = i.next( );
            RefClass rc;
            //       String clsName = fullPackageName + "." + name;
            //       // deal with package inheritance
            //       if (clsName.equals("Pkg2.Pkg2InnerPkgA.BaseClassInInnerPkg") ||
            //            clsName.equals("Pkg2.Pkg2InnerPkgB.BaseClassInInnerPkg")) {
            //          clsName = "Pkg2.Pkg2BasePkg.BaseClassInInnerPkg";
            //       }
            try {
                if ( name.indexOf( "." ) != -1 ) {
                    throw new RuntimeException( "Attempted to call refClass using " + name );
                }
                rc = rpkg.refClass( name );
            } catch ( Throwable th ) {
                return Status.failed( "Within the RefPackage " + fullPackageName + " refClass(" + name + ") resulted in an unexpected exception: " + th.getClass( ).getName( ) + " with the message " + th );
            }
            if ( rc == null ) {
                return Status.failed( "Within the RefPackage " + fullPackageName + " refClass(" + name + ") returned null" );
            }
        }
        for ( Iterator<String> i = assocNames.iterator( ); i.hasNext( ); ) {
            String name = i.next( );
            RefAssociation ra;
            try {
                if ( name.indexOf( "." ) != -1 ) {
                    throw new RuntimeException( "Attempted to call refAssociation using " + name );
                }
                ra = rpkg.refAssociation( name );
                // ra = rpkg.refAssociation(fullPackageName + "." + name);
            } catch ( Throwable th ) {
                return Status.failed( "Within the RefPackage " + fullPackageName + " refAssociation(" + name + ") resulted in an unexpected exception: " + th.getClass( ).getName( ) + " with the message " + th );
            }
            if ( ra == null ) {
                return Status.failed( "Within the RefPackage " + fullPackageName + " refAssociation(" + name + ") returned null" );
            }
        }

        String msg = "Each RefPackage, RefAssociation, and RefClass contained " + "in " + pkgName + " was retrieved by String designator using " + "the corresponding refPackage, refAssociation, or refClass method";
        return ( finalStatus == null ) ? Status.passed( msg ) : finalStatus.augment( msg );
    }

    /**
     * Defines the emptyInitialExtent test, which insures that when an extent is
     * first created, it contains no RefObjects.
     * 
     * @return a <code>Status</code> value
     */
    public Status emptyInitialExtent( ) {

        int cnt = 0;
        for ( Iterator<RefClass> i = rp.refAllClasses( ).iterator( ); i.hasNext( ); ) {
            RefClass rc = i.next( );
            cnt = cnt + rc.refAllOfClass( ).size( );
        }
        if ( cnt != 0 ) {
            return Status.failed( "Extent defined by " + Util.refBaseObjectAsString( rp ) + " contains " + cnt + " elements upon initialization" );
        } else {
            return Status.passed( "Extent defined by " + Util.refBaseObjectAsString( rp ) + " contains " + " no elements upon initialization" );
        }
    }

    /**
     * Defines the emptyInitialLinkExtent test, which insures that when an
     * extent is first created, it contains no links.
     * 
     * @return a <code>Status</code> value
     */
//    public Status emptyInitialLinkExtent( ) {
//
//        int cnt = 0;
//        for ( Iterator i = rp.refAllAssociations( ).iterator( ); i.hasNext( ); ) {
//            RefAssociation ra = (RefAssociation) i.next( );
//            cnt = cnt + ra.refAllLinks( ).size( );
//        }
//        if ( cnt != 0 ) {
//            return Status.failed( "Extent defined by " + Util.refBaseObjectAsString( rp ) + " contains " + cnt + " links upon initialization" );
//        } else {
//            return Status.passed( "Extent defined by " + Util.refBaseObjectAsString( rp ) + " contains " + " no links upon initialization" );
//        }
//    }
    /**
     * Defines the refDeleteOnRefPackage test. This test invokes refDelete on
     * top-level RefPackage, tnen insures that the RefClasses it used to contain
     * can no longer be accessed.
     * 
     * @return a <code>Status</code> value
     */
    public Status refDeleteOnRefPackage( ) {

        makeExtent( rp );
        try {
            rp.refDelete( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Unexepected Exception encountered when " + "invoking refDelete on a ContainmentPackage " + "instance" );

        }
        int accesscnt = 0;
        try {
            for ( Iterator<RefClass> i = rp.refAllClasses( ).iterator( ); i.hasNext( ); ) {
                RefClass rc = i.next( );
                accesscnt++;
                for ( Iterator<RefObject> j = rc.refAllOfType( ).iterator( ); j.hasNext( ); ) {
                    RefObject ro = j.next( );
                    trOut.println( Util.refBaseObjectAsString( ro ) );
                }
            }
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.passed( "Successfully invoked refDelete on a " + "ContainmentPackage instance and threw " + th );
        }
        if ( accesscnt > 0 ) {
            return Status.failed( "After invoking refDelete on a " + "ContainmentPackage, could still access " + accesscnt + " RefClass instances" );
        } else {
            return Status.passed( "Successfully invoked refDelete on a " + "ContainmentPackage instance, and can no longer" + "access its RefClass instances" );
        }
    }

    /**
     * Defines the createAbstractObject test. This test attempts to create a
     * instance of a RefObject subtype defined in the metamodel as abstract.
     * 
     * @return a <code>Status</code> value
     */
    public Status createAbstractObject( ) {

        RefClass rc;
        try {
            rc = rp.refClass( "BaseClass" );
            // rc = rp.refClass("Links.BaseClass");
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while setting up to execute the test" );

        }
        try {
            rc.refCreateInstance( );
        } catch ( Throwable th ) {
            return Status.passed( "Exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while trying to create a RefObject defined " + "as abstract" );
        }
        return Status.failed( "Did not detect the an attempt was made to " + "create a RefObject defined as abstract" );
    }

    private Status checkIsInstanceOf( RefObject instance, String instanceType, RefObject metaObject, boolean asType, boolean expected ) {

        try {
            boolean isInst = instance.refIsInstanceOf( metaObject, asType );
            String resultMsg = "The refIsInstanceOf method invoked on a " + instanceType + " using metaobject " + Util.refBaseObjectAsString( metaObject ) + ( ( asType ) ? " " : " not" ) + " considering subtypes returned " + isInst;
            trOut.println( resultMsg );
            if ( isInst ^ ( !expected ) ) {
                return Status.passed( resultMsg );
            } else {
                return Status.failed( resultMsg + "; expected to return " + expected );
            }
        } catch ( Throwable th ) {
            return Status.passed( "Exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while invoking  refIsInstanceOf" );
        }
    }

    /**
     * Defines the refIsInstanceOf test. The test invokes refIsInstanceOf on a
     * nuber of objects, to insure that the implemention returns the correct
     * value.
     * 
     * @return a <code>Status</code> value
     */
    public Status isInstanceOf( ) {

        RefClass greenClass;
        RefClass blueClass;
        RefClass baseClass;
        RefClass leafClass;
        RefObject metaGreen;
        RefObject metaBlue;
        RefObject metaBase;
        RefObject metaLeaf;
        RefObject greenInstance;
        RefObject blueInstance;
        RefObject leafInstance;

        try {
            greenClass = rp.refClass( "Green" );
            blueClass = rp.refClass( "Blue" );
            baseClass = rp.refClass( "BaseClass" );
            leafClass = rp.refClass( "Leaf" );
            metaGreen = greenClass.refMetaObject( );
            metaBlue = blueClass.refMetaObject( );
            metaBase = baseClass.refMetaObject( );
            metaLeaf = leafClass.refMetaObject( );

            greenInstance = greenClass.refCreateInstance( );
            blueInstance = blueClass.refCreateInstance( );
            leafInstance = leafClass.refCreateInstance( );

        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while setting up to execute the test" );

        }
        Status s = checkIsInstanceOf( greenInstance, "Green", metaGreen, false, true );
        if ( !s.isPassed( ) ) {
            return s;
        }
        Status finalStatus = s;
        s = checkIsInstanceOf( greenInstance, "Green", metaGreen, true, true );
        if ( !s.isPassed( ) ) {
            return s;
        }
        finalStatus = finalStatus.augment( s );
        s = checkIsInstanceOf( greenInstance, "Green", metaBlue, false, false );
        if ( !s.isPassed( ) ) {
            return s;
        }
        finalStatus = finalStatus.augment( s );
        s = checkIsInstanceOf( greenInstance, "Green", metaBlue, true, true );
        if ( !s.isPassed( ) ) {
            return s;
        }
        finalStatus = finalStatus.augment( s );
        s = checkIsInstanceOf( greenInstance, "Green", metaBase, false, false );
        if ( !s.isPassed( ) ) {
            return s;
        }
        finalStatus = finalStatus.augment( s );
        s = checkIsInstanceOf( greenInstance, "Green", metaBase, true, true );
        if ( !s.isPassed( ) ) {
            return s;
        }

        finalStatus = finalStatus.augment( s );
        s = checkIsInstanceOf( greenInstance, "Green", metaLeaf, false, false );
        if ( !s.isPassed( ) ) {
            return s;
        }
        finalStatus = finalStatus.augment( s );
        s = checkIsInstanceOf( greenInstance, "Green", metaLeaf, true, false );
        if ( !s.isPassed( ) ) {
            return s;
        }

        finalStatus = finalStatus.augment( s );
        s = checkIsInstanceOf( blueInstance, "Blue", metaGreen, false, false );
        if ( !s.isPassed( ) ) {
            return s;
        }
        finalStatus = finalStatus.augment( s );
        s = checkIsInstanceOf( blueInstance, "Blue", metaGreen, false, false );
        if ( !s.isPassed( ) ) {
            return s;
        }
        finalStatus = finalStatus.augment( s );
        s = checkIsInstanceOf( blueInstance, "Blue", metaBlue, true, true );
        if ( !s.isPassed( ) ) {
            return s;
        }
        finalStatus = finalStatus.augment( s );
        s = checkIsInstanceOf( blueInstance, "Blue", metaBlue, false, true );
        if ( !s.isPassed( ) ) {
            return s;
        }
        finalStatus = finalStatus.augment( s );
        s = checkIsInstanceOf( blueInstance, "Blue", metaBase, false, false );
        if ( !s.isPassed( ) ) {
            return s;
        }
        finalStatus = finalStatus.augment( s );
        s = checkIsInstanceOf( blueInstance, "Blue", metaBase, true, true );
        if ( !s.isPassed( ) ) {
            return s;
        }
        finalStatus = finalStatus.augment( s );
        s = checkIsInstanceOf( blueInstance, "Blue", metaLeaf, false, false );
        if ( !s.isPassed( ) ) {
            return s;
        }
        finalStatus = finalStatus.augment( s );
        s = checkIsInstanceOf( blueInstance, "Blue", metaLeaf, true, false );
        if ( !s.isPassed( ) ) {
            return s;
        }

        finalStatus = finalStatus.augment( s );
        s = checkIsInstanceOf( leafInstance, "Leaf", metaGreen, false, false );
        if ( !s.isPassed( ) ) {
            return s;
        }
        finalStatus = finalStatus.augment( s );
        s = checkIsInstanceOf( leafInstance, "Leaf", metaGreen, false, false );
        if ( !s.isPassed( ) ) {
            return s;
        }
        finalStatus = finalStatus.augment( s );
        s = checkIsInstanceOf( leafInstance, "Leaf", metaBlue, false, false );
        if ( !s.isPassed( ) ) {
            return s;
        }
        finalStatus = finalStatus.augment( s );
        s = checkIsInstanceOf( leafInstance, "Leaf", metaBlue, false, false );
        if ( !s.isPassed( ) ) {
            return s;
        }

        finalStatus = finalStatus.augment( s );
        s = checkIsInstanceOf( leafInstance, "Leaf", metaBase, false, false );
        if ( !s.isPassed( ) ) {
            return s;
        }
        finalStatus = finalStatus.augment( s );
        s = checkIsInstanceOf( leafInstance, "Leaf", metaBase, false, false );
        if ( !s.isPassed( ) ) {
            return s;
        }

        finalStatus = finalStatus.augment( s );
        s = checkIsInstanceOf( leafInstance, "Leaf", metaLeaf, false, true );
        if ( !s.isPassed( ) ) {
            return s;
        }
        finalStatus = finalStatus.augment( s );
        s = checkIsInstanceOf( leafInstance, "Leaf", metaLeaf, true, true );
        if ( !s.isPassed( ) ) {
            return s;
        }
        return finalStatus;
    }

    /**
     * Defines the refClass test, which tests the refClass method defined in
     * RefObject.
     * 
     * @return a <code>Status</code> value
     */
    public Status refObjectsRefClass( ) {

        RefClass greenClass;
        RefObject greenInstance;
        RefClass greenInstanceClass;

        try {
            greenClass = rp.refClass( "Green" );
            // greenClass = rp.refClass("Links.Green");
            greenInstance = greenClass.refCreateInstance( );

        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.error( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while setting up to execute the test" );

        }

        try {
            greenInstanceClass = greenInstance.refClass( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " on invocation of refClass on an instance of " + "Green" );

        }
        if ( !greenClass.equals( greenInstanceClass ) ) {
            return Status.failed( "The GreanClass instance returned from " + "invoking refClass on a Green instance is not " + "equal to the correct GreenClass instance for " + "this Green instance" );
        } else {
            return Status.passed( "The GreanClass instance returned from " + "invoking refClass on a Green instance is " + "the correct GreenClass instance" );
        }
    }
}
