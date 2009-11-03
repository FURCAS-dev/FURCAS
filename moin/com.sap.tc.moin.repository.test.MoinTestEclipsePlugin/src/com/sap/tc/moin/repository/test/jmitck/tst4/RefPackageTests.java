package com.sap.tc.moin.repository.test.jmitck.tst4;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;

import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
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
import com.sap.tc.moin.repository.test.jmitck.tst4.containment.innercontainment.Point;
import com.sap.tc.moin.repository.test.jmitck.tst5.importable.innerimportable.ColorKindEnum;

/**
 * Defines tests on methods of RefPackage. Even though testing
 * com.sap.tc.moin.repository.mmi.reflective methods, these have compilation dependencies on
 * interfaces generated from the Containment metamodel for tests setup,
 * execution, etc.
 */
@SuppressWarnings( "nls" )
public class RefPackageTests extends SemModelTests {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, RefPackageTests.class );

    /**
     * Defines tests of the refCreateStruct methods defined in RefClass and
     * RefPackage.
     * 
     * @return a <code>Status</code> value
     */
    public Status createStruct( ) {

        ContainmentExtent ce = initializeExtent( "refStruct invocations" );
        StructureFieldContainer<Point> containerInnercontainmentPoint = new StructureFieldContainer<Point>( );
        Status status = null;
        List<Object> params = new ArrayList<Object>( );
        params.add( new Integer( 7 ) );
        params.add( "some coordinate" );
        String structName = "Containment.InnerContainment.ClassInInner.PointInClass";
        // return testCreateStruct("Containment.InnerContainment.ClassInInner",
        status = testCreateStruct( structName, rp, true, params, ce.classInTopLevel1.getPoint( ) );

        if ( !status.isPassed( ) ) {
            return status;
        }
        params = new ArrayList<Object>( );
        params.add( new Integer( 9 ) );
        params.add( ColorKindEnum.RED );
        structName = "Containment.InnerContainment.Point";
        status = testCreateStruct( structName, rp, false, params, ce.classInInner1.getPoint( ) );
        if ( !status.isPassed( ) ) {
            return status;
        }

        params = new ArrayList<Object>( );
        params.add( new Integer( 0 ) );
        containerInnercontainmentPoint.put( Point.DESCRIPTORS.X( ), 44 );
        containerInnercontainmentPoint.put( Point.DESCRIPTORS.COLOR( ), ColorKindEnum.BLUE );
        params.add( ce.innerContainmentPkg.createPoint( containerInnercontainmentPoint ) );
        structName = "Containment.Point";
        status = testCreateStruct( structName, rp, false, params, ce.classInInner2_1.getPoint( ) );
        if ( !status.isPassed( ) ) {
            return status;
        }

        params = new ArrayList<Object>( );
        params.add( new Integer( 8 ) );
        params.add( new Integer( 8 ) );
        structName = "Importable.InnerImportable.Point";
        status = testCreateStruct( structName, ce.importablePkg, false, params, ce.classInImportable1.getPoint( ) );
        if ( !status.isPassed( ) ) {
            return status;
        }
        params = new ArrayList<Object>( );
        params.add( new Integer( 92 ) );
        params.add( new Boolean( true ) );
        structName = "Pkg2.Point";
        status = testCreateStruct( structName, rp, false, params, ce.classInPkg1.getPoint( ) );
        return status;
    }

    private String creatorName( String refBaseObjectName, boolean inClass ) {

        return refBaseObjectName + " : " + ( ( inClass ) ? "RefClass" : "RefPackage" );
    }

    private Status testCreateStruct( String structName, RefPackage structureTypeRoot, boolean inClass, List<? extends Object> params, RefStruct existing ) {

        String refBaseObjectName = Util.qualificationOf( structName );

        // will use just one of the two below
        RefPackage structCreatorPkg = null;
        RefClass structCreatorCls = null;
        trOut.println( "Testing refStruct on " + creatorName( refBaseObjectName, inClass ) + " to create a " + structName + " with " + params.size( ) + " arguments" );
        for ( int i = 0; i < params.size( ); i++ ) {
            trOut.println( "   argument[" + i + "] " + params.get( i ) );
        }
        try {
            if ( inClass ) {
                structCreatorCls = Util.getRefClass( refBaseObjectName, structureTypeRoot );
                // structCreatorCls = structureTypeRoot.refClass(refBaseObjectName);
            } else {
                structCreatorPkg = Util.getRefPackage( refBaseObjectName, structureTypeRoot );
                // structCreatorPkg = structureTypeRoot.refPackage(refBaseObjectName);
            }
            if ( ( structCreatorCls == null ) && ( structCreatorPkg == null ) ) {
                return Status.error( "Could not access an instance of " + creatorName( refBaseObjectName, inClass ) + " to conduct test" );
            }

            trOut.println( "Found the " + creatorName( refBaseObjectName, inClass ) + " instance for invoking the refStruct method" );
        } catch ( InvalidCallException ice ) {
            log.trace( ice, MoinSeverity.ERROR, "" );
            return Status.error( "Could not access an instance of " + creatorName( refBaseObjectName, inClass ) + " to conduct test" );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.error( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while setting up to execute refStruct; " + "unable to complete test" );

        }
        RefStruct struct = null;
        try {
            String simpleName = Util.simpleNameOf( structName );
            if ( isStrReflectiveTest ) {
                trOut.println( "Invoking refStruct using the String designator: " + structName );
                if ( inClass ) {
                    struct = structCreatorCls.refCreateStruct( simpleName, params );
                } else {
                    struct = structCreatorPkg.refCreateStruct( simpleName, params );
                }
            } else {
                RefBaseObject creator = ( inClass ) ? (RefBaseObject) structCreatorCls : (RefBaseObject) structCreatorPkg;

                GeneralizableElement ge = (GeneralizableElement) creator.refMetaObject( );
                if ( ge == null ) {
                    return Status.error( "Could not find the metaobject " + "corresponding to " + refBaseObjectName );
                }
                StructureType st = (StructureType) ge.lookupElementExtended( simpleName );

                if ( st == null ) {
                    log.trace( MoinSeverity.ERROR, "Last segment of struct name " + structName + ", " + simpleName + " used in lookup on " + Util.refBaseObjectAsString( ge ) + " returned null" );
                    return Status.error( "Could not find the metaobject " + "defining the struct type " + structName );
                }
                trOut.println( "Invoking refStruct using the metaobject " + "designator: " + Util.refBaseObjectAsString( st ) );
                if ( inClass ) {
                    struct = structCreatorCls.refCreateStruct( st, params );
                } else {
                    struct = structCreatorPkg.refCreateStruct( st, params );
                }
            }
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while invoking refStruct" );
        }
        if ( struct.equals( existing ) ) {
            return Status.passed( "refStruct invocation to create a " + structName + " on a " + creatorName( refBaseObjectName, inClass ) + " returned the same value as the equivalent call " + "in the specific interface" );
        } else {
            return Status.passed( "refStruct invocation to create a " + structName + " on a " + creatorName( refBaseObjectName, inClass ) + " returned the value " + struct + " but expected the value " + existing );
        }
    }

    private ContainmentExtent initializeExtent( String testDesc ) {

        try {
            return ContainmentExtent.makeExtent( (ContainmentPackage) rp );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            throw new TestErrorException( "Could not construct the pretest " + "state for " + testDesc + " encountered unexpected exception of " + " type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) );
        }
    }

    /**
     * Defines tests of the refGetEnum method defined in RefPackage.
     * 
     * @return a <code>Status</code> value
     */
    public Status createEnum( ) {

        ContainmentExtent ce = initializeExtent( "refEnum invocations" );
        Status status = null;
        String enumName = "Importable.InnerImportable.ClassInInnerImportable.ColorKind";
        status = testCreateEnum( enumName, ce.importablePkg, true, "red", ColorKindEnum.RED );

        return status;
    }

    // shameless cut'n'paste reuse 
    private Status testCreateEnum( String enumName, RefPackage enumerationTypeRoot, boolean inClass, String label, RefEnum existing ) {

        String refBaseObjectName = Util.qualificationOf( enumName );
        // will use just one of the two below
        RefPackage enumCreatorPkg = null;
        RefClass enumCreatorCls = null;
        trOut.println( "Testing refEnum on " + creatorName( refBaseObjectName, inClass ) + " to create a " + enumName + " with label " + label );
        try {
            if ( inClass ) {
                enumCreatorCls = Util.getRefClass( refBaseObjectName, enumerationTypeRoot );
            } else {
                enumCreatorPkg = Util.getRefPackage( refBaseObjectName, enumerationTypeRoot );
                // enumCreatorPkg = enumerationTypeRoot.refPackage(refBaseObjectName);
            }
            if ( ( enumCreatorCls == null ) && ( enumCreatorPkg == null ) ) {
                return Status.error( "Could not access an instance of " + creatorName( refBaseObjectName, inClass ) + " to conduct test" );
            }

            trOut.println( "Found the " + creatorName( refBaseObjectName, inClass ) + " instance for invoking the refEnum method" );
        } catch ( InvalidCallException ice ) {
            log.trace( ice, MoinSeverity.ERROR, "" );
            return Status.error( "Could not access an instance of " + creatorName( refBaseObjectName, inClass ) + " to conduct test" );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.error( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while setting up to execute refEnum; " + "unable to complete test" );

        }
        RefEnum enumeration = null;
        try {
            String simpleName = Util.simpleNameOf( enumName );
            if ( isStrReflectiveTest ) {
                trOut.println( "Invoking refEnum using the String designator: " + enumName );
                if ( inClass ) {
                    enumeration = enumCreatorCls.refGetEnum( simpleName, label );
                } else {
                    enumeration = enumCreatorPkg.refGetEnum( simpleName, label );
                }
            } else {
                RefBaseObject creator = ( inClass ) ? (RefBaseObject) enumCreatorCls : (RefBaseObject) enumCreatorPkg;
                GeneralizableElement ge = (GeneralizableElement) creator.refMetaObject( );
                if ( ge == null ) {
                    return Status.error( "Could not find the metaobject " + "corresponding to " + refBaseObjectName );
                }
                EnumerationType et = (EnumerationType) ge.lookupElementExtended( simpleName );

                if ( et == null ) {
                    log.trace( MoinSeverity.ERROR, "Last segment of enumeration name " + enumName + ", " + simpleName + " used in lookup on " + Util.refBaseObjectAsString( ge ) + " returned null" );
                    return Status.error( "Could not find the metaobject " + "defining the enumeration type " + enumName );
                }
                trOut.println( "Invoking refEnum using the metaobject " + "designator: " + Util.refBaseObjectAsString( et ) );
                if ( inClass ) {
                    enumeration = enumCreatorCls.refGetEnum( et, label );
                } else {
                    enumeration = enumCreatorPkg.refGetEnum( et, label );
                }
            }
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.failed( "Unexpected exception of type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " while invoking refEnum to create a " + enumName + " with label " + label );
        }
        if ( enumeration.equals( existing ) ) {
            return Status.passed( "refEnum invocation to create a " + enumName + " with label " + label + " on a " + creatorName( refBaseObjectName, inClass ) + " returned the same value as the equivalent call " + "in the specific interface" );
        } else {
            return Status.passed( "refEnum invocation to create a " + enumName + " with label " + label + " on a " + creatorName( refBaseObjectName, inClass ) + " returned the value " + enumeration + " but expected the value " + existing );
        }
    }

    /**
     * Defines a boundary condition test which passes in an argument of the
     * wrong type in the RefPackage's refCreateStruct method.
     * 
     * @return a <code>Status</code> value
     */
    public Status refPkgTypeMismatch( ) {

        String testDesc = "TypeMismatchException test";
        ContainmentExtent ce = initializeExtent( testDesc );
        RefPackage rpkg = null;
        rpkg = ce.containmentPkg;
        List<Object> args = new ArrayList<Object>( );
        args.add( new Integer( 9 ) );
        args.add( "bad parameter" );
        try {
            rpkg.refCreateStruct( "Point", args );
            // rpkg.refCreateStruct("Containment.Point", args);
            return Status.failed( "Use of an argument of an invalid type " + "(a String for the second element) " + " in refCreateStruct invocation on a " + "Containment RefPackage did not result in any " + "exception" );
        } catch ( TypeMismatchException ice ) {
            return Status.passed( "Use of an argument of an invalid type " + "(a String for the second element) " + " in refCreateStruct invocation on a " + "Containment RefPackage resulted in an " + "TypeMismatchException, as expected" );
        } catch ( Throwable th ) {
            return Status.failed( "Use of an argument of an invalid type " + "(a String for the second element) " + " in refCreateStruct invocation on a " + "Containment RefPackage resulted in an " + "exception, but not the expected " + "TypeMismatchException; it was a " + th.getClass( ).getName( )
                                  + " with a message " + th );
        }
    }

}
