package com.sap.ide.cts.qvt.test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import textblocks.Bostoken;
import textblocks.Eostoken;
import textblocks.LexedToken;
import textblocks.TextBlock;
import uk.ac.kent.cs.kmf.util.ILog;

import junit.framework.Assert;

import data.classes.SapClass;
import de.ikv.medini.ocl.test.util.Utilities;
import de.ikv.medini.qvt.QVTProcessorConsts;
import de.ikv.medini.qvt.QvtProcessorImpl;
import de.ikv.medini.qvt.test.QVTTestCase;

public class TestCreateTextBlocksByQVT extends QVTTestCase {
    
    private Object sapClass;

    public void testSimpleCreateTbInverse() throws FileNotFoundException {
        TextBlock testBlock = (TextBlock) this.adapter.createModelElement("TCS::textblocks::TextBlock");
        LexedToken testToken = (LexedToken) this.adapter.createModelElement("TCS::textblocks::LexedToken");
        testToken.setValue("TestClass2");
        this.adapter.setValueForFeature(testBlock, "tokens", testToken);
        
        this.checkTraces("testCreateTb.qvt", "testCreateTb", "source", "target", 1);
        
        ILog log = ((QvtProcessorImpl)this.adapter.getQvtProcessor()).getLog();
        log.finalReport();
        assertEquals(0, log.getErrors());
        
        Collection sapClasses = this.findElementsByType(true, "ngpm::data::classes::SapClass");
        assertEquals(2, sapClasses.size());
        boolean found = false;
        for (Object object : sapClasses) {
           if("TestClass2".equals(((SapClass) object).getName())) {
               found = true;
           }
        }
        assertEquals(true, found);
    }
    
    public void testSimpleCreateTb() throws FileNotFoundException {
        this.checkTraces("testCreateTb.qvt", "testCreateTb", "target", "source", 1);
        
        assertEquals(1, this.findElementsByType(true, "TCS::textblocks::TextBlock").size());
        assertEquals(1, this.findElementsByType(true, "TCS::textblocks::LexedToken").size());
    }
    
    public void testCompleteCreateTb() throws FileNotFoundException {
        this.checkTraces("testCreateCompleteTb.qvt", "testCreateTb", "target", "source", 1);

        Collection<TextBlock> tbs = this.findElementsByType(true, "TCS::textblocks::TextBlock");
        assertEquals(1, tbs.size());
        assertEquals(1, this.findElementsByType(true, "TCS::textblocks::LexedToken").size());
        assertEquals(1, this.findElementsByType(true, "TCS::textblocks::EOSToken").size());
        assertEquals(1, this.findElementsByType(true, "TCS::textblocks::BOSToken").size());
        TextBlock tb = (TextBlock) tbs.iterator().next();
        assertEquals(3, tb.getTokens().size());
        assertTrue(Bostoken.class.isAssignableFrom(tb.getTokens().get(0).getClass()));
        assertTrue(Eostoken.class.isAssignableFrom(tb.getTokens().get(2).getClass()));
        assertEquals(this.sapClass, tb.getCorrespondingModelElements().get(0));
    }

    @Override
    protected void setUp() throws Exception {
            metamodelIDs = new String[]{"ngpm","TCS","Reflect"};
            super.setUp();
            ((QvtProcessorImpl)this.adapter.getQvtProcessor()).setProperty(QVTProcessorConsts.PROP_DEBUG, "true");
            // topPackage
            this.sapClass = this.createModelElement("ngpm::data::classes::SapClass");
            this.adapter.setValueForFeature(this.sapClass, "name", "TestClass");
    
    }
    
    /**
     * Get IDs of all model elements
     * 
     * @param onTarget
     *            if true, IDs of the target model are collected
     * @return
     */
    protected Collection getSourceIDs(boolean onTarget) {

            List result = !onTarget ? this.adapter.evaluateOnSource("ngpm::data::classes::SapClass.allInstances()") : this.adapter.evaluateOnTarget("textblocks::TextBlock.allInstances()");
            Assert.assertEquals(1, result.size());
            Assert.assertEquals(true, result.get(0) instanceof Collection);
            Collection ids1 = new HashSet(Utilities.getIdentities((Collection) result.get(0), this.adapter));

            return new ArrayList(ids1);
    }
}
