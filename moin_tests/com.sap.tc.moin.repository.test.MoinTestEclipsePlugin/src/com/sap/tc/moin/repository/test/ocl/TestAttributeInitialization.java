package com.sap.tc.moin.repository.test.ocl;

import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.test.ocl.base.BaseOclTest;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case013.B13;
import com.sap.tc.moin.testcases.case013.B13Sub1;
import com.sap.tc.moin.testcases.case013.B13Sub1Sub2;
import com.sap.tc.moin.testcases.case013.B13Sub2;
import com.sap.tc.moin.testcases.case013.B13Sub2Sub;
import com.sap.tc.moin.testcases.case013.C13Sub;
import com.sap.tc.moin.testcases.case013.Case013Package;
import com.sap.tc.moin.testcases.case013.E13Enum;
import com.sap.tc.moin.testcasesfoundation.TestcasesfoundationPackage;
import com.sap.tc.moin.testcasesfoundation.case003f.Case003fPackage;
import com.sap.tc.moin.testcasesfoundation.case004f.Case004fPackage;

@SuppressWarnings( "nls" )
public class TestAttributeInitialization extends BaseOclTest {

    protected TestcasesPackage testcasesPackage = null;

    protected TestcasesfoundationPackage testcasesfoundationPackage = null;

    protected Case013Package case013Package = null;

    protected Case003fPackage case003fPackage = null;

    protected Case004fPackage case004fPackage = null;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        testcasesPackage = (TestcasesPackage) getMOINConnection( ).getPackage( null, new String[] { "testcases" } );
        testcasesfoundationPackage = (TestcasesfoundationPackage) getMOINConnection( ).getPackage( null, new String[] { "testcasesfoundation" } );
        case013Package = testcasesPackage.getCase013( );
        case003fPackage = testcasesfoundationPackage.getCase003f( );
        case004fPackage = testcasesfoundationPackage.getCase004f( );
    }

    @Test
    public void testNoInitialization( ) {

        B13 b13 = this.connection.createElementInPartition( B13.class, null );
        B13Sub2 b13Sub2 = this.connection.createElementInPartition( B13Sub2.class, null );
        B13Sub2Sub b13Sub2Sub = this.connection.createElementInPartition( B13Sub2Sub.class, null );
        // not initialized, test Java default
        Object actual = b13.getNotInitializedStringAttribute1( );
        assertEquals( "The initial value should be \"null\", but it is " + actual, null, actual );
        // sub class 2, not initialized and not overridden, test Java default
        actual = b13Sub2.getNotInitializedStringAttribute1( );
        assertEquals( "The initial value should be \"null\", but it is " + actual, null, actual );
        // sub class from sub class 2, not initialized and not overridden, test Java default
        actual = b13Sub2Sub.getNotInitializedStringAttribute1( );
        assertEquals( "The initial value should be \"null\", but it is " + actual, null, actual );
    }

    @Test
    public void testInitialization( ) {

        // initializations via specific creator
        B13 b13 = this.connection.createElementInPartition( B13.class, null );
        // initializations in B13 class
        Object actual = b13.getInitializedStringAttribute1( );
        assertEquals( "The initial value should be \"42String\", but it is " + actual, "42String", actual );
        actual = b13.getInitializedIntegerAttribute1( );
        assertEquals( "The initial value should be \"42\", but it is " + actual, 42, actual );
        actual = b13.isInitializedBooleanAttribute1( );
        assertEquals( "The initial value should be \"true\", but it is " + actual, true, actual );
        actual = b13.getInitializedDoubleAttribute1( );
        assertEquals( "The initial value should be \"42.0\", but it is " + actual, 42.0, actual );
        // initializations via reflective creator
        b13 = connection.createElement( B13.class );
        // initializations in B13 class
        actual = b13.getInitializedStringAttribute1( );
        assertEquals( "The initial value should be \"42String\", but it is " + actual, "42String", actual );
        actual = b13.getInitializedIntegerAttribute1( );
        assertEquals( "The initial value should be \"42\", but it is " + actual, 42, actual );
        actual = b13.isInitializedBooleanAttribute1( );
        assertEquals( "The initial value should be \"true\", but it is " + actual, true, actual );
        actual = b13.getInitializedDoubleAttribute1( );
        assertEquals( "The initial value should be \"42.0\", but it is " + actual, 42.0, actual );
        actual = b13.getInitializedEnumerationAttribute1( );
        assertEquals( "The initial value should be \"enumField1\", but it is " + actual, E13Enum.ENUM_FIELD1, actual );
    }

    @Test
    public void testInheritedInitializationForSub1( ) {

        B13Sub1 b13Sub1 = this.connection.createElementInPartition( B13Sub1.class, null );
        // sub class 1, overridden
        Object actual = b13Sub1.getInitializedStringAttribute1( );
        assertEquals( "The initial value should be \"42StringSub1\", but it is " + actual, "42StringSub1", actual );
        actual = b13Sub1.getInitializedDoubleAttribute1( );
        assertEquals( "The initial value should be \"0.24e2\", but it is " + actual, 0.24e2, actual );
        actual = b13Sub1.getInitializedEnumerationAttribute1( );
        assertEquals( "The initial value should be \"enumField1\", but it is " + actual, E13Enum.ENUM_FIELD1, actual );
    }

    @Test
    public void testInheritedInitializationForSub2( ) {

        B13Sub2 b13Sub2 = this.connection.createElementInPartition( B13Sub2.class, null );
        // sub class 2, overridden
        Object actual = b13Sub2.getInitializedStringAttribute1( );
        assertEquals( "The initial value should be \"42StringSub2\", but it is " + actual, "42StringSub2", actual );
        actual = b13Sub2.getInitializedIntegerAttribute1( );
        assertEquals( "The initial value should be \"24\", but it is " + actual, 24, actual );
        actual = b13Sub2.getInitializedEnumerationAttribute1( );
        assertEquals( "The initial value should be \"enumField2\", but it is " + actual, E13Enum.ENUM_FIELD2, actual );
    }

    @Test
    public void testInheritedInitializationForSub1Sub2( ) {

        B13Sub1Sub2 b13Sub1Sub2 = this.connection.createElementInPartition( B13Sub1Sub2.class, null );
        // sub class from sub class 1 and sub class 2
        // not overridden, inherits initialization from sub class 2 (defined in both super classes, last one "wins")
        Object actual = b13Sub1Sub2.getInitializedStringAttribute1( );
        assertEquals( "The initial value should be \"42StringSub2\", but it is " + actual, "42StringSub2", actual );
        // not overridden, inherits initialization from sub class 1
        actual = b13Sub1Sub2.getInitializedDoubleAttribute1( );
        assertEquals( "The initial value should be \"0.24e2\", but it is " + actual, 0.24e2, actual );
        // not overridden, inherits initialization from sub class 2
        actual = b13Sub1Sub2.getInitializedIntegerAttribute1( );
        assertEquals( "The initial value should be \"24\", but it is " + actual, 24, actual );
        // not overridden, inherited from B13
        actual = b13Sub1Sub2.isInitializedBooleanAttribute1( );
        assertEquals( "The initial value should be \"true\", but it is " + actual, true, actual );
        // not overridden, inherits initialization from sub class 2
        actual = b13Sub1Sub2.getInitializedEnumerationAttribute1( );
        assertEquals( "The initial value should be \"enumField2\", but it is " + actual, E13Enum.ENUM_FIELD2, actual );
    }

    @Test
    public void testInheritedInitializationForSub2Sub( ) {

        B13Sub2Sub b13Sub2Sub = this.connection.createElementInPartition( B13Sub2Sub.class, null );
        // sub class from sub class 2
        // not overridden, inherits initialization from sub class 2
        Object actual = b13Sub2Sub.getInitializedIntegerAttribute1( );
        assertEquals( "The initial value should be \"24\", but it is " + actual, 24, actual );
        // not overridden, inherits initialization from sub class 2
        actual = b13Sub2Sub.getInitializedStringAttribute1( );
        assertEquals( "The initial value should be \"42StringSub2\", but it is " + actual, "42StringSub2", actual );
        // not overridden, inherits initialization from B13
        actual = b13Sub2Sub.getInitializedDoubleAttribute1( );
        assertEquals( "The initial value should be \"42.0\", but it is " + actual, 42.0, actual );
        // not overridden, inherited from B13
        actual = b13Sub2Sub.isInitializedBooleanAttribute1( );
        assertEquals( "The initial value should be \"true\", but it is " + actual, true, actual );
        // not overridden, inherits initialization from sub class 2
        actual = b13Sub2Sub.getInitializedEnumerationAttribute1( );
        assertEquals( "The initial value should be \"enumField2\", but it is " + actual, E13Enum.ENUM_FIELD2, actual );
    }

    @Test
    public void testInheritedInitializationForC13Sub( ) {

        // C13Sub inherits from the abstract class C13Abstract
        C13Sub c13Sub = this.connection.createElementInPartition( C13Sub.class, null );
        Object actual = c13Sub.getAttribute1( );
        assertEquals( "The initial value should be \"1.5\", but it is " + actual, 1.5, actual );
    }
}
