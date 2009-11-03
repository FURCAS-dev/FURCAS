package com.sap.tc.moin.repository.test.jmitck.tst4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.TestErrorException;
import com.sap.tc.moin.repository.test.jmitck.javatest.Status;
import com.sap.tc.moin.repository.test.jmitck.modelsem.SemModelTests;
import com.sap.tc.moin.repository.test.jmitck.modelsem.Util;
import com.sap.tc.moin.repository.test.jmitck.tst4.containment.ContainmentPackage;

/**
 * Defines tests on methods of RefAssociation. Even though testing
 * com.sap.tc.moin.repository.mmi.reflective methods, these have compilation dependencies on
 * interfaces generated from the Containment metamodel for tests setup,
 * execution, etc.
 */
@SuppressWarnings( "nls" )
public class RefAssociationTests extends SemModelTests {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, RefAssociationTests.class );

    private boolean foundByLinkExists( RefAssociation ra, RefObject end1, RefObject end2 ) {

        try {
            return ra.refLinkExists( end1, end2 );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            throw new TestFailedException( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while invoking refLinkExists" );
        }
    }

    private Status checkByLinkExists( RefAssociation ra, RefObject end1, RefObject end2 ) {

        try {
            if ( !foundByLinkExists( ra, end1, end2 ) ) {
                return Status.failed( "The invocation of refLinkExists failed to find " + " the link (" + Util.refBaseObjectAsString( end1 ) + ", " + Util.refBaseObjectAsString( end2 ) + ") within " + Util.refBaseObjectAsString( ra ) );
            } else {
                return Status.passed( "Found expected link in " + Util.refBaseObjectAsString( ra ) );
            }
        } catch ( TestFailedException tfe ) {
            log.trace( tfe, MoinSeverity.INFO, "" );
            return Status.failed( tfe.getMessage( ) );
        }
    }

    /**
     * Defines the linkExists test. The test exercises the refLinkExists method
     * to insure it can correctly identify existing links.
     * 
     * @return a <code>Status</code> value
     */
    public Status linkExists( ) {

        ContainmentExtent ce = initializeExtent( "refLinkExists invocations" );
        Status overallStatus = null;
        List<Link> linkList = makeListOfExistingLinks( ce );
        int cnt = 0;
        for ( Iterator<Link> i = linkList.iterator( ); i.hasNext( ); ) {
            Link link = i.next( );
            Status status = checkByLinkExists( link.refAssoc, link.end1, link.end2 );
            if ( !status.isPassed( ) ) {
                return status;
            }
            overallStatus = ( overallStatus == null ) ? status : overallStatus.augment( status );
            cnt++;
        }
        return overallStatus.augment( "Found the links in each of " + cnt + " refLinkExists invocations" );
    }

    /**
     * Defines the linkNotExists test. The test exercises the refLinkExists
     * method to insure it will return false when given a pair of objects that
     * are not a link on the RefAssociation's exent.
     * 
     * @return a <code>Status</code> value
     */
    public Status linkNotExists( ) {

        ContainmentExtent ce = initializeExtent( "refLinkExists invocations" );
        Status overallStatus = null;
        List<Link> linkList = makeListOfNonLinks( ce );
        int cnt = 0;
        for ( Iterator<Link> i = linkList.iterator( ); i.hasNext( ); ) {
            Link link = i.next( );
            try {
                if ( !foundByLinkExists( link.refAssoc, link.end1, link.end2 ) ) {
                    Status s = Status.passed( "The invocation of refLinkExists " + "returned false for a link that did not " + " exist within " + Util.refBaseObjectAsString( link.refAssoc ) + " as expected" );
                    cnt++;
                    overallStatus = ( overallStatus == null ) ? s : overallStatus.augment( s );
                    overallStatus.augment( s );
                } else {
                    return Status.failed( "The refLinkExists returned true for " + "link (" + Util.refBaseObjectAsString( link.end1 ) + ", " + Util.refBaseObjectAsString( link.end2 ) + ") withun " + Util.refBaseObjectAsString( link.refAssoc ) + " but tne link doesn't exist" );
                }
            } catch ( TestFailedException tfe ) {
                return Status.failed( tfe.getMessage( ) );
            }

        }
        return overallStatus.augment( "Returned false for the non-existant link " + "in " + cnt + " refLinkExists invocations" );
    }

    private List<Link> makeListOfExistingLinks( ContainmentExtent ce ) {

        List<Link> linkList = new ArrayList<Link>( );
        RefAssociation outerInner = ce.containmentPkg.getOuterInner( );
        linkList.add( new Link( outerInner, ce.classInTopLevel1, ce.classInInner1 ) );
        linkList.add( new Link( outerInner, ce.classInTopLevel1, ce.classInInner2 ) );
        RefAssociation reachingIntoCluster = ce.deepContainmentPkg.getReachingIntoCluster( );
        linkList.add( new Link( reachingIntoCluster, ce.classInTopLevel1, ce.multiInheriting ) );
        RefAssociation deepOuterInDeep = ce.deepContainmentPkg.getDeepOuterInDeep( );
        linkList.add( new Link( deepOuterInDeep, ce.classInTopLevel1, ce.classInDeep1 ) );

        RefAssociation innerLinksImportedInner = ce.containmentPkg.getInnerLinksImportedInner( );
        linkList.add( new Link( innerLinksImportedInner, ce.classInInner1, ce.classInInnerImportable1 ) );
        RefAssociation linkingTwoNested = ce.containmentPkg.getLinkingTwoNested( );
        linkList.add( new Link( linkingTwoNested, ce.classInInner1, ce.classInInner2_1 ) );
        return linkList;
    }

    private ContainmentExtent initializeExtent( String testDesc ) {

        try {
            return ContainmentExtent.makeExtent( (ContainmentPackage) rp );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            throw new TestErrorException( "Could not construct the pretest " + "state for " + testDesc + " encountered unexpected exception of " + " type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) );
        }
    }

    private List<Link> makeListOfNonLinks( ContainmentExtent ce ) {

        List<Link> linkList = new ArrayList<Link>( );

        RefAssociation linkingTwoNested = ce.containmentPkg.getLinkingTwoNested( );
        linkList.add( new Link( linkingTwoNested, ce.classInInner1, ce.classInInner2_2 ) );
        return linkList;
    }

    private static class Link {

        public RefAssociation refAssoc;

        public RefObject end1;

        public RefObject end2;

        public Link( RefAssociation refAssoc, RefObject end1, RefObject end2 ) {

            this.refAssoc = refAssoc;
            this.end1 = end1;
            this.end2 = end2;
        }
    }

    private static class TestFailedException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TestFailedException( String msg ) {

            super( msg );
        }
    }

    /**
     * Defines a boundary condition test which invokes refQuery with an invalid
     * metaobject-designator. Invokes the method on a
     * <code>Containment.OuterInner</code> instance, but passes in an
     * AssociationEnd from the Association defining
     * <code>Containment.LinkingTwoNested</code>.
     * 
     * @return a <code>Status</code> value
     */
    public Status refQueryInvalidCall( ) {

        String testDesc = "InvalidCallException test";
        ContainmentExtent ce = initializeExtent( testDesc );
        RefAssociation ra = null;
        RefObject someOtherEnd = null;
        try {
            ra = ce.containmentPkg.refAssociation( "OuterInner" );
            // ra = ce.containmentPkg.refAssociation("Containment.OuterInner");
            RefAssociation other = ce.containmentPkg.refAssociation( "LinkingTwoNested" );
            // RefAssociation other = 
            //    ce.containmentPkg.refAssociation("Containment.LinkingTwoNested");
            Association metaAssoc = other.refMetaObject( );
            for ( Iterator<ModelElement> i = metaAssoc.getContents( ).iterator( ); i.hasNext( ); ) {
                Object obj = i.next( );
                if ( obj instanceof AssociationEnd ) {
                    someOtherEnd = (RefObject) obj;
                    break;
                }
            }
            if ( someOtherEnd == null ) {
                throw new RuntimeException( "Could not find an AssociationEnd " + "instance" );
            }
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            throw new TestErrorException( "Could not construct the pretest " + "state for " + testDesc + " encountered unexpected exception of " + " type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) );
        }

        try {
            ra.refQuery( someOtherEnd, ce.classInTopLevel1 );
            return Status.failed( "Use of the incorrect metaobject designator " + Util.refBaseObjectAsString( someOtherEnd ) + " in refQery invocation on a " + "Containment.InnerOuter did not result in any " + "exception" );
        } catch ( InvalidCallException ice ) {
            return Status.passed( "Use of the incorrect metaobject designator " + Util.refBaseObjectAsString( someOtherEnd ) + " in refQery invocation on a " + "Containment.InnerOuter resulted in an " + "InvalidCallException, as expected" );
        } catch ( Throwable th ) {
            return Status.failed( "Use of the incorrect metaobject designator " + Util.refBaseObjectAsString( someOtherEnd ) + " in refQery invocation on a " + "Containment.InnerOuter resulted in an " + "exception, but not the expected " + "InvalidCallException; it was a "
                                  + th.getClass( ).getName( ) + " with a message " + th );
        }
    }

    /**
     * Defines a boundary condition test which invokes refQuery with an invalid
     * string-designator. Invokes the method on a
     * <code>Containment.OuterInner</code> instance, but passes in the String
     * "inner" (valid for <code>Containment.LinkingTwoNested</code>, but not for
     * this RefAssociation.
     * 
     * @return a <code>Status</code> value
     */
    public Status refQueryInvalidName( ) {

        String testDesc = "InvalidNameException test";
        ContainmentExtent ce = initializeExtent( testDesc );
        RefAssociation ra = null;
        try {
            ra = ce.containmentPkg.refAssociation( "OuterInner" );
            // ra = ce.containmentPkg.refAssociation("Containment.OuterInner");
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            throw new TestErrorException( "Could not construct the pretest " + "state for " + testDesc + " encountered unexpected exception of " + " type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) );
        }

        try {
            ra.refQuery( "inner", ce.classInTopLevel1 );
            // ra.refQuery("Containment.LinkingTwoNested.inner", ce.classInTopLevel1);
            return Status.failed( "Use of the incorrect metaobject designator " + "inner" + " in refQery invocation on a " + "Containment.InnerOuter did not result in any " + "exception" );
        } catch ( InvalidCallException ice ) {
            return Status.passed( "Use of the incorrect metaobject designator " + "inner" + " in refQery invocation on a " + "Containment.InnerOuter resulted in an " + "InvalidCallException, as expected" );
        } catch ( Throwable th ) {
            return Status.failed( "Use of the incorrect metaobject designator " + "inner" + " in refQery invocation on a " + "Containment.InnerOuter resulted in an " + "exception, but not the expected " + "InvalidCallException; it was a " + th.getClass( ).getName( ) + " with a message " + th );
        }
    }

    /**
     * Defines a parameterized test for type mismatch boundary conditions on
     * RefAssociation method invocations. The <code>method</code> parameter from
     * the <code>TestDescription</code> specifies the RefAssociation method for
     * the current test. For each method specified, an object of an invalid type
     * is passed in.
     * 
     * @return a <code>Status</code> value
     */
    public Status refAssocTypeMismatch( ) {

        String method = getParam( "method", true );
        String testDesc = "TypeMismatchException test";
        ContainmentExtent ce = initializeExtent( testDesc );
        RefAssociation ra = null;
        try {
            ra = ce.containmentPkg.refAssociation( "OuterInner" );
            // ra = ce.containmentPkg.refAssociation("Containment.OuterInner");

        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            throw new TestErrorException( "Could not construct the pretest " + "state for " + testDesc + " encountered unexpected exception of " + " type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) );
        }

        try {
            if ( method.equals( "refLinkExists" ) ) {
                ra.refLinkExists( ce.classInTopLevel1, ce.classInTopLevel1 );
            } else if ( method.equals( "refQuery" ) ) {
                // ra.refQuery("Containment.OuterInner.innerEnd", ce.classInTopLevel1);
                ra.refQuery( "innerEnd", ce.classInTopLevel1 );
            } else if ( method.equals( "refAddLink" ) ) {
                ra.refAddLink( ce.classInTopLevel1, ce.classInTopLevel1 );
            } else if ( method.equals( "refRemoveLink" ) ) {
                ra.refRemoveLink( ce.classInTopLevel1, ce.classInTopLevel1 );
            } else {
                return Status.error( "Specified method of " + method + " unknown for this test " );
            }
            return Status.failed( "Use of an argument of an invalid type " + Util.refBaseObjectAsString( ce.classInTopLevel1 ) + " in " + method + " invocation on a " + "Containment.InnerOuter did not result in any " + "exception" );
        } catch ( TypeMismatchException ice ) {
            return Status.passed( "Use of an argument of an invalid type " + Util.refBaseObjectAsString( ce.classInTopLevel1 ) + " in " + method + " invocation on a " + "Containment.InnerOuter resulted in an " + "TypeMismatchException, as expected" );
        } catch ( Throwable th ) {
            return Status.failed( "Use of an argument of an invalid type " + Util.refBaseObjectAsString( ce.classInTopLevel1 ) + " in " + method + " invocation on a " + "Containment.InnerOuter resulted in an " + "exception, but not the expected " + "TypeMismatchException; it was a "
                                  + th.getClass( ).getName( ) + " with a message " + th );
        }
    }

}
