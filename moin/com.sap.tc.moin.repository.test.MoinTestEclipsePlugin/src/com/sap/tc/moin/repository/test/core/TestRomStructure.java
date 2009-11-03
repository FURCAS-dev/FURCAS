/*
 * Created on 28.10.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.sap.tc.moin.repository.test.core;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.ocl.OclPackage;

import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 * @author d045996
 *
 * This Test verifies the static structure of the MOF-ROM (including OCL) 
 * and at the same time checks the generated JMI API. 
 * The content of the MofPackage "OCL" is "dumped" with a simple serializer
 * and then compared with an "expected" dump.
 * 
 * Status:
 *   The "expected" dump is already checked with the Rose model. The only 
 * difference was in the class OclConstrain, that does not contains the two
 * derived attributes "expression" and "language"    
 */
public class TestRomStructure extends CoreMoinTest {

    //private ModelPackage mofModelPackage;

    /**
     * The model element of the Mof ModelPackage
     */
    private com.sap.tc.moin.repository.mmi.model.MofPackage packageElement;

    /**
     * Gets a connection from MMR and obtains the Mof ModelPackage meta object.
     */
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        ModelPackage mofModelPackage = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
        packageElement = (MofPackage) mofModelPackage.refMetaObject( );

        OclPackage oclPackage = (OclPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_OCL );
        packageElement = (MofPackage) oclPackage.refMetaObject( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        packageElement = null;
    }

    /*
     * Creates a dump of the content of the Mof ROM, to compare with an expected
     * dump.
     */
    @Test
    public void testMofROMModelContent( ) throws Exception {

        // String useWrappers = System.getProperty("moin.use.wrappers");
        // if (!(useWrappers != null && useWrappers.equalsIgnoreCase("false"))) {
        // // This test cannot work with wrappers because TestMofModel.txt contains Strings from
        // <obj>.getClass().getName(),
        // // which in the wrapper case results in "$Proxy..." instead of e.g. "com.sap.tc.moin.repository.mmi.model.__impl.AttributeImpl".
        // return;
        // }
        // // Create Dump
        // MofModelDumper mmd = new MofModelDumper(packageElement);
        // String dump = mmd.dumpModel(true, false);
        //        
        // java.lang.System.out.println("-------------------------------------");
        // java.lang.System.out.println(dump);
        //
        // // Read Desired
        // StringBuffer desired = new StringBuffer();
        // InputStream is = Thread.currentThread().getContextClassLoader()
        // .getResourceAsStream("com/sap/tc/moin/repository/test/rom/MofROM.txt");
        // BufferedReader in = new BufferedReader( new InputStreamReader(is));
        // String line = in.readLine();
        // while (line !=null) {
        // desired.append(line).append("\n");
        // line = in.readLine();
        // }
        // String t = desired.toString();
        // // Compare
        //        
        //        // Compare
        //        assertEquals(desired.toString(),dump+"\n");
    }
}
