package com.sap.tc.moin.repository.test.cps;

import org.junit.Test;

import com.sap.tc.moin.repository.runtimehost.deployment.PriPatternRegistry;
import com.sap.tc.moin.repository.runtimehost.deployment.PriPatternRegistry.PrefixMap;
import com.sap.tc.moin.test.testcase.MoinTestCase;


public class TestPriPatternRegistry extends MoinTestCase {


    private static final String ROSE_XMI = "Rose xmi";

    private static final String ROSE_XMI_NEW = "Rose xmi new";

    private static final String STANDARD2 = "Standard 2";

    private static final String CPS_TEST_2 = "CPS test 2";

    private static final String CPS_TEST = "CPS test";

    private static final String TEXT_ANY = "Text any";

    private static final String STANDARD = "Standard";

    /**
     * Tests the pri pattern registry.
     */
    @Test
    public void testPriPatternRegistry( ) {

        PriPatternRegistry reg = new PriPatternRegistry( );

        verify( reg.put( "moin/meta/", ".moinmm", STANDARD ), "Valid insert not successful." );

        verify( !reg.put( "moin/", ".moinmm", STANDARD2 ), "Illegal insert successful." );

        verify( reg.put( "java/", ".java", "Java" ), "Valid insert not successful." );

        verify( reg.put( "cpstest/", ".cpstest", CPS_TEST ), "Valid insert not successful." );

        verify( reg.put( "moin/test/", ".cpstest", CPS_TEST_2 ), "Valid insert not successful." );

        verify( reg.put( "mmr/meta/", ".xmi", ROSE_XMI ), "Valid insert not successful." );

        verify( reg.put( "mmr/meta/", ".xminew", ROSE_XMI_NEW ), "Valid insert not successful." );

        verify( !reg.put( "", ".cpstest", "CPS test faulty" ), "Illegal insert successful." );

        verify( reg.put( "", ".txt", TEXT_ANY ), "Valid insert not successful." );

        verify( reg.find( "moin/folder/afsdfajsks.mointest" ) == null, "Wrong result found." ); // n

        verify( STANDARD.equals( reg.find( "moin/meta/afsdfajsks.moinmm" ) ), "Nothing found." );

        verify( TEXT_ANY.equals( reg.find( "moin/meta/afsdfajsks.txt" ) ), "Nothing found" );

        verify( CPS_TEST.equals( reg.find( "cpstest/fadafsf.cpstest" ) ), "Nothing found" );

        verify( CPS_TEST_2.equals( reg.find( "moin/test/fadafsf.cpstest" ) ), "Nothing found" );

        verify( CPS_TEST_2.equals( reg.find( "moin/test/fadafsf.cpstest" ) ), "Nothing found" );

        verify( ROSE_XMI_NEW.equals( reg.find( "mmr/meta/fadafsf.xminew" ) ), "Nothing found" );
    }

    /**
     * Tests the pri pattern registry.
     */
    @Test
    public void testPriPatternRegistrySpecialCases( ) {

        // test last
        PriPatternRegistry reg1 = new PriPatternRegistry( );

        verify( reg1.put( "moin/meta/", ".moinmm", STANDARD ), "Valid insert not successful." );

        verify( !reg1.put( "moin/", ".moinmm", STANDARD2 ), "Illegal insert successful." );

        verify( reg1.put( "moin/test/", ".cpstest", CPS_TEST_2 ), "Valid insert not successful." );

        verify( reg1.put( "mmr/meta/", ".xmi", ROSE_XMI ), "Valid insert not successful." );

        verify( reg1.put( "mmr/meta/", ".xminew", ROSE_XMI_NEW ), "Valid insert not successful." );

        verify( reg1.put( "zulu/", ".zulu", CPS_TEST ), "Valid insert not successful." );

        verify( reg1.put( "", ".txt", TEXT_ANY ), "Valid insert not successful." );

        verify( reg1.find( "zulu/meta/afsdfajsks.moinmm" ) == null, "Wrong result found." );

        verify( CPS_TEST.equals( reg1.find( "zulu/meta/afsdfajsks.zulu" ) ), "Nothing found." );


        // only one
        PriPatternRegistry reg2 = new PriPatternRegistry( );

        verify( reg2.put( "moin/meta/", ".moinmm", STANDARD ), "Valid insert not successful." );

        verify( reg2.find( "moin/folder/afsdfajsks.mointest" ) == null, "Wrong result found." ); // n

        verify( STANDARD.equals( reg2.find( "moin/meta/afsdfajsks.moinmm" ) ), "Nothing found." );

        // first
        PriPatternRegistry reg3 = new PriPatternRegistry( );

        verify( reg3.put( "moin/meta/", ".moinmm", STANDARD ), "Valid insert not successful." );

        verify( !reg3.put( "moin/", ".moinmm", STANDARD2 ), "Illegal insert successful." );

        verify( reg3.put( "java/", ".java", "Java" ), "Valid insert not successful." );

        verify( reg3.put( "alpha/", ".cpstest", CPS_TEST ), "Valid insert not successful." );

        verify( reg3.put( "moin/test/", ".cpstest", CPS_TEST_2 ), "Valid insert not successful." );

        verify( reg3.put( "mmr/meta/", ".xmi", ROSE_XMI ), "Valid insert not successful." );

        verify( reg3.put( "mmr/meta/", ".xminew", ROSE_XMI_NEW ), "Valid insert not successful." );

        verify( reg3.find( "beta/folder/afsdfajsks.mointest" ) == null, "Wrong result found." ); // n

        verify( CPS_TEST.equals( reg3.find( "alpha/meta/afsdfajsks.cpstest" ) ), "Nothing found." );

        // empty
        PriPatternRegistry reg4 = new PriPatternRegistry( );

        verify( reg4.put( "moin/meta/", ".moinmm", STANDARD ), "Valid insert not successful." );

        verify( !reg4.put( "moin/", ".moinmm", STANDARD2 ), "Illegal insert successful." );

        verify( reg4.put( "java/", ".java", "Java" ), "Valid insert not successful." );

        verify( reg4.put( "alpha/", ".cpstest", CPS_TEST ), "Valid insert not successful." );

        verify( reg4.put( ".cpstest", ".cpstest", CPS_TEST_2 ), "Valid insert not successful." );

        verify( reg4.put( "mmr/meta/", ".xmi", ROSE_XMI ), "Valid insert not successful." );

        verify( reg4.put( "mmr/meta/", ".xminew", ROSE_XMI_NEW ), "Valid insert not successful." );

        verify( reg4.find( "" ) == null, "Wrong result found." );

        verify( reg4.find( "a" ) == null, "Wrong result found." );

        verify( CPS_TEST.equals( reg4.find( "alpha/.cpstest" ) ), "Nothing found." );

        verify( CPS_TEST_2.equals( reg4.find( ".cpstest" ) ), "Nothing found." );
    }

    /**
     * Tests the more flexible prefix map
     */
    @Test
    public void testPriPatternRegistryFlexible( ) {

        PrefixMap<String> reg = new PriPatternRegistry.FlexiblePrefixMapImpl<String>( );

        verify( reg.put( "moin/meta/", STANDARD ), "Valid insert not successful." );

        verify( reg.put( "moin/", STANDARD2 ), "Valid insert not successful." );

        verify( reg.put( "java/", "Java" ), "Valid insert not successful." );

        verify( reg.put( "cpstest/", CPS_TEST ), "Valid insert not successful." );

        verify( reg.put( "moin/test/", CPS_TEST_2 ), "Valid insert not successful." );

        verify( reg.put( "mmr/meta/", ROSE_XMI ), "Valid insert not successful." );

        verify( reg.put( "", TEXT_ANY ), "Valid insert not successful." );

        verify( !reg.put( "", "CPS test faulty" ), "Illegal insert succeeded." );

        verify( TEXT_ANY.equals( reg.find( "xmoin/folder/afsdfajsks.mointest" ) ), "Nothing found." );

        verify( STANDARD.equals( reg.find( "moin/meta/afsdfajsks.moinmm" ) ), "Nothing found." );

        verify( STANDARD2.equals( reg.find( "moin/metax/afsdfajsks.txt" ) ), "Nothing found" );

        verify( CPS_TEST.equals( reg.find( "cpstest/fadafsf.cpstest" ) ), "Nothing found" );

        verify( CPS_TEST_2.equals( reg.find( "moin/test/fadafsf.cpstest" ) ), "Nothing found" );

    }
}
