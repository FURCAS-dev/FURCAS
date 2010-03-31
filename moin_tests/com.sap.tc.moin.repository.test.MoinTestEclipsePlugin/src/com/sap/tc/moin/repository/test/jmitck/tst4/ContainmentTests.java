package com.sap.tc.moin.repository.test.jmitck.tst4;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.test.jmitck.TestErrorException;
import com.sap.tc.moin.repository.test.jmitck.javatest.Status;
import com.sap.tc.moin.repository.test.jmitck.modelsem.SemModelTests;
import com.sap.tc.moin.repository.test.jmitck.modelsem.Util;
import com.sap.tc.moin.repository.test.jmitck.tst4.containment.ContainmentPackage;

/**
 * Defines tests using the Containment metamodel and its generated code.
 */
@SuppressWarnings( "nls" )
public class ContainmentTests extends SemModelTests {

    /**
     * Defines a test which creates instances in the ContainmentPackage extent,
     * as defined in the ContainmentExtent class. The Containment metamodel
     * defines a complex set of nested, inherited, imported, and clustered
     * packages, with links and other dependencies among types in the various
     * packages.
     * 
     * @return a <code>Status</code> value
     */
    public Status createContainment( ) {

        try {
            ContainmentExtent.makeExtent( (ContainmentPackage) rp );
        } catch ( Throwable th ) {
            return Status.failed( "Could not construct a containment of objects: " + "encountered undexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) );
        }
        return Status.passed( "Constructed the containment elements without raising exception" );
    }

    /**
     * Defines a test of the refImmediatePackage method. Invokes the method on
     * each of the RefBaseObjects of the ContainmentExtent.
     * 
     * @return a <code>Status</code> value
     */
    public Status refImmediatePackage( ) {

        ContainmentExtent ce = null;
        try {
            ce = ContainmentExtent.makeExtent( (ContainmentPackage) rp );
        } catch ( Throwable th ) {
            return Status.failed( "Could not construct a pretest state for " + "refImmediatePackage invocations; " + "encountered unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) );
        }
        try {
            checkRefImmediate( ce.containmentPkg, null );
            checkRefImmediate( ce.importablePkg, null );
            checkRefImmediate( ce.innerContainmentPkg, ce.containmentPkg );
            checkRefImmediate( ce.deepContainmentPkg, ce.innerContainmentPkg );
            checkRefImmediate( ce.inner2ContainmentPkg, ce.containmentPkg );
            checkRefImmediate( ce.innerImportablePkg, ce.importablePkg );

            checkRefImmediate( ce.classInTopLevelClass, ce.containmentPkg );
            checkRefImmediate( ce.classInTopLevel1, ce.containmentPkg );
            checkRefImmediate( ce.classInTopLevel2, ce.containmentPkg );
            checkRefImmediate( ce.classInInnerClass, ce.innerContainmentPkg );
            checkRefImmediate( ce.classInInner1, ce.innerContainmentPkg );
            checkRefImmediate( ce.classInInner2, ce.innerContainmentPkg );

            checkRefImmediate( ce.classInDeepClass, ce.deepContainmentPkg );
            checkRefImmediate( ce.classInDeep1, ce.deepContainmentPkg );
            checkRefImmediate( ce.classInDeep2, ce.deepContainmentPkg );

            checkRefImmediate( ce.classInInner2Class, ce.inner2ContainmentPkg );
            checkRefImmediate( ce.classInInner2_1, ce.inner2ContainmentPkg );
            checkRefImmediate( ce.classInInner2_2, ce.inner2ContainmentPkg );

            checkRefImmediate( ce.classInImportableClass, ce.importablePkg );
            checkRefImmediate( ce.classInImportable1, ce.importablePkg );
            checkRefImmediate( ce.classInImportable2, ce.importablePkg );

            checkRefImmediate( ce.classInInnerImportableClass, ce.innerImportablePkg );
            checkRefImmediate( ce.classInInnerImportable1, ce.innerImportablePkg );
            checkRefImmediate( ce.classInInnerImportable2, ce.innerImportablePkg );

            checkRefImmediate( ce.containmentPkg.getInnerLinksImportedInner( ), ce.containmentPkg );
            checkRefImmediate( ce.containmentPkg.getLinkingTwoNested( ), ce.containmentPkg );
            checkRefImmediate( ce.containmentPkg.getOuterInner( ), ce.containmentPkg );
            checkRefImmediate( ce.deepContainmentPkg.getDeepOuterInDeep( ), ce.deepContainmentPkg );
            checkRefImmediate( ce.deepContainmentPkg.getReachingIntoCluster( ), ce.deepContainmentPkg );

            return Status.passed( "Successfully returned each correct value from refImmediatePackage for each RefBaseObject in the ContainmentPackage RefPackage extehnd and the ImportablePackage RefPackage extent" );

        } catch ( TestErrorException tee ) {
            return Status.failed( tee.getMessage( ) );
        } catch ( Throwable th ) {
            return Status.failed( "Unexpected exception on refImmediatePackage " + "invocation: " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) );
        }

    }

    /**
     * Defines a test of the refOutermostPackage method. Invokes the method on
     * each of the RefBaseObjects of the ContainmentExtent.
     * 
     * @return a <code>Status</code> value
     */
    public Status refOutermostPackage( ) {

        ContainmentExtent ce = null;
        try {
            ce = ContainmentExtent.makeExtent( (ContainmentPackage) rp );
        } catch ( Throwable th ) {
            return Status.failed( "Could not construct a pretest state for " + "refOutermostPackage invocations; " + "encountered unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) );
        }
        try {
            checkRefOutermost( ce.containmentPkg, ce.containmentPkg );
            checkRefOutermost( ce.importablePkg, ce.importablePkg );
            checkRefOutermost( ce.innerContainmentPkg, ce.containmentPkg );
            checkRefOutermost( ce.deepContainmentPkg, ce.containmentPkg );
            checkRefOutermost( ce.inner2ContainmentPkg, ce.containmentPkg );
            checkRefOutermost( ce.innerImportablePkg, ce.importablePkg );

            checkRefOutermost( ce.classInTopLevelClass, ce.containmentPkg );
            checkRefOutermost( ce.classInTopLevel1, ce.containmentPkg );
            checkRefOutermost( ce.classInTopLevel2, ce.containmentPkg );
            checkRefOutermost( ce.classInInnerClass, ce.containmentPkg );
            checkRefOutermost( ce.classInInner1, ce.containmentPkg );
            checkRefOutermost( ce.classInInner2, ce.containmentPkg );

            checkRefOutermost( ce.classInDeepClass, ce.containmentPkg );
            checkRefOutermost( ce.classInDeep1, ce.containmentPkg );
            checkRefOutermost( ce.classInDeep2, ce.containmentPkg );

            checkRefOutermost( ce.classInInner2Class, ce.containmentPkg );
            checkRefOutermost( ce.classInInner2_1, ce.containmentPkg );
            checkRefOutermost( ce.classInInner2_2, ce.containmentPkg );

            checkRefOutermost( ce.containmentPkg.getInnerLinksImportedInner( ), ce.containmentPkg );
            checkRefOutermost( ce.containmentPkg.getLinkingTwoNested( ), ce.containmentPkg );
            checkRefOutermost( ce.containmentPkg.getOuterInner( ), ce.containmentPkg );
            checkRefOutermost( ce.deepContainmentPkg.getDeepOuterInDeep( ), ce.containmentPkg );

            return Status.passed( "Successfully returned each correct value from refOutermostPackage for each RefBaseObject in the ContainmentPackage RefPackage extehnd and the ImportablePackage RefPackage extent" );

        } catch ( TestErrorException tee ) {
            return Status.failed( tee.getMessage( ) );
        } catch ( Throwable th ) {
            return Status.failed( "Unexpected exception on refOutermostPackage " + "invocation: " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) );
        }

    }

    private void checkRefImmediate( RefBaseObject rbo, RefPackage rp ) {

        RefPackage immedPkg = rbo.refImmediatePackage( );
        String rboName = " an instance of " + ( ( rbo instanceof RefClass ) ? " the Class Proxy for " : "" ) + Util.dotNotation( ( (ModelElement) rbo.refMetaObject( ) ).getQualifiedName( ) );
        String rpName = ( rp == null ) ? "null" : "RefPackage subtype instance of type " + Util.dotNotation( ( (ModelElement) rp.refMetaObject( ) ).getQualifiedName( ) );
        String immedName = ( immedPkg == null ) ? "null" : "instance of type " + Util.dotNotation( ( (ModelElement) immedPkg.refMetaObject( ) ).getQualifiedName( ) );
        boolean passed = false;
        if ( immedPkg == null ) {
            if ( rp == null ) {
                passed = true;
            } else {
                passed = false;
            }
        } else {
            passed = immedPkg.equals( rp );
        }

        if ( passed ) {
            trOut.println( "Invocation of refImmediatePackage on " + rboName + " returned " + immedName + " as expected" );
        } else {
            throw new TestErrorException( "Value returned by invocation of " + "refImmediatePackage on a " + rboName + " was expected to be " + rpName + " but instead was " + immedName );
        }
    }

    private void checkRefOutermost( RefBaseObject rbo, RefPackage rp ) {

        RefPackage outerPkg = rbo.refOutermostPackage( );
        String rboName = " an instance of " + ( ( rbo instanceof RefClass ) ? " the Class Proxy for " : "" ) + Util.dotNotation( ( (ModelElement) rbo.refMetaObject( ) ).getQualifiedName( ) );
        String rpName = ( rp == null ) ? "null" : "RefPackage subtype instance of type " + Util.dotNotation( ( (ModelElement) rp.refMetaObject( ) ).getQualifiedName( ) );
        String outerName = ( outerPkg == null ) ? "null" : "instance of type " + Util.dotNotation( ( (ModelElement) outerPkg.refMetaObject( ) ).getQualifiedName( ) );
        boolean passed = false;
        if ( outerPkg == null ) {
            if ( rp == null ) {
                passed = true;
            } else {
                passed = false;
            }
        } else {
            passed = outerPkg.equals( rp );
        }

        if ( passed ) {
            trOut.println( "Invocation of refOutermostPackage on " + rboName + " returned " + outerName + " as expected" );
        } else {
            throw new TestErrorException( "Value returned by invocation of " + "refOutermostPackage on a " + rboName + " was expected to be " + rpName + " but instead was " + outerName );
        }
    }

}
