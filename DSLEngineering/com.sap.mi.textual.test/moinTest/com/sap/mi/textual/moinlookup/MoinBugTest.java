package com.sap.mi.textual.moinlookup;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.parsergenerator.emf.lookup.EcoreMetaLookup;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.mi.textual.test.util.MOINContainerNameLookUpFactory;

/**
 * Tests potential Moin bug with deferred OCL Instantiation?
 * To be run as an Eclipse Plugin JUnit test (else connection Manager fails).
 */
public class MoinBugTest  {

    private static Connection connection;


    @BeforeClass
    public static void setup() {
        connection = ConnectionManager.getInstance().createTransientConnection();
    }
    
    @AfterClass
    public static void tearDown() {
        connection.close();
    }
    
    @Test 
    public void testWorkaround() throws Exception {
        EcoreMetaLookup lookup = MOINContainerNameLookUpFactory.getMOINContainerNameLookUpFactory(OclPackage.PACKAGE_DESCRIPTOR.getModelContainerName() );
        List<ResolvedNameAndReferenceBean<RefObject>> result = lookup.qualifyName("OclExpression");
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
    
    @Test
    @Ignore //This test only tests for a bug if it is run as a first test with moin. In a suite, it will pass even if the bug still exists. 
    public void testMoinItself() throws Exception {
        // The test queries for all MOF classifiers within the scope of Primitives, MOF itself, and OCL
        // all these elements should be returned, however, OCL elements are missing
        // additionally, if an exclusive query is made, the OCL elements start being returned by further queries.
        // formally this is 2 bugs, one for too few elements returned at first, one for the inconsistent behavior of the method
        // but both are likely to have the same cause.
        
        Moin moin = MoinFactory.getMoinInstance();
        
        Set<PRI> priSet = new HashSet<PRI>();
        PRI pri1 = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/PrimitiveTypes.moinmm");
        // bug happening with OCL only?
        PRI pri3 = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/OCL.moinmm");
        PRI pri4 = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/Model.moinmm");
        priSet.add(pri1);
        priSet.add(pri3);
        
        priSet.add(pri4);

        // the real bug is too few elements being returned with query 1, but it was detected by a difference between result1 and result3
        int result1 = getClassifierNumber(true, priSet);
        // next line required to reproduce the inconsistent behavior
        connection.getClass(OclExpression.CLASS_DESCRIPTOR).getClass();
        int result3 = getClassifierNumber(true, priSet);

        assertFalse(0 == result1);
        
        assertFalse(0 == result3);
        
       
        assertEquals(result1, result3); // this line confirms the inconsistent behavior before and after calling the method with "false"
        
        assertTrue("Too few elements returned from query, possibly OCL elements missing.", 120 < result1); // expecting around 152 elements, with bug only 59 (this is the real bug)

    }


    protected int getClassifierNumber(boolean inclusive, Set<PRI> queryPRIs ) throws Exception { 
      
        Moin moin = MoinFactory.getMoinInstance();
        final Set<CRI> containerScope = new HashSet<CRI>(); 
        containerScope.add(moin.createCri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4"));

        String query ="select instance \n" + 
        "from \"sap.com/tc/moin/mof_1.4\"#" + "Model::Classifier as instance \n";

        MQLProcessor processor = connection.getMQLProcessor();
        QueryScopeProvider scopeProvider = processor.getQueryScopeProvider(inclusive, queryPRIs , containerScope);
        MQLResultSet resultSet = processor.execute(query, scopeProvider);

        int size = resultSet.getSize();
        assertFalse(size == 0);
        
        for (int j = 0; j < resultSet.getSize(); j++) {
            
            MRI mri = resultSet.getMri(j, "instance");

            // this line is required to reproduce the inconsistency bug
            connection.getElement(mri);
        }

        return resultSet.getSize();
    }


}
