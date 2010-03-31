/*
 * Created on 20.06.2005
 */
package com.sap.tc.moin.repository.test.core;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.testcasesmofelement.TestcasesMofElementPackage;
import com.sap.tc.moin.testcasesmofelement.case001.ToOne;
import com.sap.tc.moin.testcasesmofelement.case002.ToMany;

/**
 * Tests the most abstract superclass of all model elements in the repository,
 * which is mof.reflect.Element. This class maps to com.sap.tc.moin.repository.mmi.reflect.RefObject.
 * References typed with this element should be able to store elements from any
 * metamodel.
 * 
 * @author D044784
 */
public class TestMofElement extends CoreMoinTest {

    private TestcasesMofElementPackage testcases;



    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        testcases = (TestcasesMofElementPackage) getMOINConnection( ).getPackage( TestMetaModels.TESTCASES_CN, "testcasesMofElement" );

    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        testcases = null;
    }

    @Test
    public void testTypedAccessMultiplicityToOne( ) throws Exception {

        com.sap.tc.moin.testcasesmofelement.case001.A a = getMOINConnection( ).createElementInPartition( com.sap.tc.moin.testcasesmofelement.case001.A.class, null );
        MofClass clazz = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );

        a.setToOneElement( clazz );
        verify( clazz.equals( a.getToOneElement( ) ), "Typed access failed, input element was: " + clazz + " but output was: " + a.getToOneElement( ) );
    }

    @Test
    public void testReflectiveAccessMultiplicityToOne( ) throws Exception {

        com.sap.tc.moin.testcasesmofelement.case001.A a = getMOINConnection( ).createElementInPartition( com.sap.tc.moin.testcasesmofelement.case001.A.class, null );
        MofClass clazz = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );

        a.refSetValue( "toOneElement", clazz );

        verify( clazz.equals( a.refGetValue( "toOneElement" ) ), "Reflective access failed, input element was: " + clazz + " but output was: " + a.refGetValue( "toOneElement" ) );
    }

    @Test
    public void testTypedAccessViaAssociationMultiplicityToOne( ) throws Exception {

        com.sap.tc.moin.testcasesmofelement.case001.A a = getMOINConnection( ).createElementInPartition( com.sap.tc.moin.testcasesmofelement.case001.A.class, null );
        MofClass clazz = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );

        ToOne assoc = testcases.getCase001( ).getToOne( );

        assoc.add( clazz, a );

        verify( clazz.equals( assoc.getToOneElement( a ) ), "Typed access via association failed, input element was: " + clazz + " but output was: " + assoc.getToOneElement( a ) );
    }

    @Test
    public void testReflectiveAccessViaAssociationMultiplicityToOne( ) throws Exception {

        com.sap.tc.moin.testcasesmofelement.case001.A a = getMOINConnection( ).createElementInPartition( com.sap.tc.moin.testcasesmofelement.case001.A.class, null );
        MofClass clazz = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );

        ToOne assoc = testcases.getCase001( ).getToOne( );

        assoc.refAddLink( clazz, a );

        verify( assoc.refQuery( "a1", a ) != null && assoc.refQuery( "a1", a ).iterator( ).hasNext( ) && clazz.equals( assoc.refQuery( "a1", a ).iterator( ).next( ) ), "Reflective access via association failed, input element was: " + clazz + " but output was: " + assoc.refQuery( "a1", a ) );
    }

    @Test
    public void testTypedAccessMultiplicityToMany( ) throws Exception {

        com.sap.tc.moin.testcasesmofelement.case002.A a = getMOINConnection( ).createElementInPartition( com.sap.tc.moin.testcasesmofelement.case002.A.class, null );
        MofClass clazz = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );

        a.getToManyElement( ).add( clazz );
        verify( a.getToManyElement( ) != null && a.getToManyElement( ).iterator( ).hasNext( ) && clazz.equals( a.getToManyElement( ).iterator( ).next( ) ), "Typed access failed, input element was: " + clazz + " but output was: " + a.getToManyElement( ) );
    }

    @Test
    public void testReflectiveAccessMultiplicityToMany( ) throws Exception {

        com.sap.tc.moin.testcasesmofelement.case002.A a = getMOINConnection( ).createElementInPartition( com.sap.tc.moin.testcasesmofelement.case002.A.class, null );
        MofClass clazz = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );

        ( (Collection) a.refGetValue( "toManyElement" ) ).add( clazz );

        verify( a.refGetValue( "toManyElement" ) != null && ( (Collection) a.refGetValue( "toManyElement" ) ).iterator( ).hasNext( ) && clazz.equals( ( (Collection) a.refGetValue( "toManyElement" ) ).iterator( ).next( ) ), "Reflective access failed, input element was: " + clazz
                                                                                                                                                                                                                               + " but output was: " + a.refGetValue( "toManyElement" ) );
    }

    @Test
    public void testTypedAccessViaAssociationMultiplicityToMany( ) throws Exception {

        com.sap.tc.moin.testcasesmofelement.case002.A a = getMOINConnection( ).createElementInPartition( com.sap.tc.moin.testcasesmofelement.case002.A.class, null );
        MofClass clazz = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );

        ToMany assoc = testcases.getCase002( ).getToMany( );

        assoc.add( clazz, a );

        verify( assoc.getToManyElement( a ) != null && assoc.getToManyElement( a ).iterator( ).hasNext( ) && clazz.equals( assoc.getToManyElement( a ).iterator( ).next( ) ), "Typed access via association failed, input element was: " + clazz + " but output was: " + assoc.getToManyElement( a ) );
    }

    @Test
    public void testReflectiveAccessViaAssociationMultiplicityToMany( ) throws Exception {

        com.sap.tc.moin.testcasesmofelement.case002.A a = getMOINConnection( ).createElementInPartition( com.sap.tc.moin.testcasesmofelement.case002.A.class, null );
        MofClass clazz = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );

        ToMany assoc = testcases.getCase002( ).getToMany( );

        assoc.refAddLink( clazz, a );

        verify( assoc.refQuery( "a2", a ) != null && assoc.refQuery( "a2", a ).iterator( ).hasNext( ) && clazz.equals( assoc.refQuery( "a2", a ).iterator( ).next( ) ), "Reflective access via association failed, input element was: " + clazz + " but output was: " + assoc.refQuery( "a2", a ) );
    }

    @Test
    public void testReflectiveAccessViaAssociationQueryMultiplicityToMany( ) throws Exception {

        com.sap.tc.moin.testcasesmofelement.case002.A a = getMOINConnection( ).createElementInPartition( com.sap.tc.moin.testcasesmofelement.case002.A.class, null );
        MofClass clazz = getMOINConnection( ).getNullPartition( ).createElement( MofClass.class );

        ToMany assoc = testcases.getCase002( ).getToMany( );

        assoc.refQuery( "a2", a ).add( clazz );

        verify( assoc.refQuery( "a2", a ) != null && assoc.refQuery( "a2", a ).iterator( ).hasNext( ) && clazz.equals( assoc.refQuery( "a2", a ).iterator( ).next( ) ), "Reflective access via association failed, input element was: " + clazz + " but output was: " + assoc.refQuery( "a2", a ) );
    }
}
