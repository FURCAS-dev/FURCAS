package com.sap.furcas.ocl.inversion.test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.junit.Assert;

import uk.ac.kent.cs.kmf.util.ILog;

import com.sap.furcas.ocl.inversion.test.adapter.LogDelegator;
import com.sap.furcas.oclinversion.OclinversionPackage;
import com.sap.furcas.oclinversion.QMarkLiteralExp;
import com.sap.furcas.oclinversion.oclequation.OclEquation;

import de.ikv.medini.ocl.test.OCLEMFTestAdapter;
import de.ikv.medini.qvt.QVTProcessorConsts;
import de.ikv.medini.qvt.QvtProcessorImpl;
import de.ikv.medini.qvt.test.QVTEMFTestAdapter;
import de.ikv.medini.qvt.test.QVTTestAdapter;
import de.ikv.medini.qvt.test.QVTTestCase;

public class TestOclInversion extends QVTTestCase {
    
    private Object oclEquation;

    public void testConcat1() throws FileNotFoundException {
        
        this.checkTraces("OclInversion.qvt", "OclInversion", "targetOcl", "sourceOcl", 1);
        
        ILog log = ((QvtProcessorImpl)this.adapter.getQvtProcessor()).getLog();
        log.finalReport();
        assertEquals(0, log.getErrors());
        
        Collection equations = this.findElementsByType(true, "oclinversion::oclequation::OclEquation");
        assertEquals(1, equations.size());
        OclEquation oclEq = (OclEquation) equations.iterator().next();
        assertTrue(oclEq.getRight() instanceof QMarkLiteralExp);
        assertTrue(oclEq.getLeft() instanceof OperationCallExp);
    }
    
    public void testConcat2() throws FileNotFoundException {
        
        this.checkTraces("OclInversion.qvt", "OclInversion", "targetOcl", "sourceOcl", 1);
        
        ILog log = ((QvtProcessorImpl)this.adapter.getQvtProcessor()).getLog();
        log.finalReport();
        assertEquals(0, log.getErrors());
        
        Collection equations = this.findElementsByType(true, "oclinversion::oclequation::OclEquation");
        assertEquals(1, equations.size());
        OclEquation oclEq = (OclEquation) equations.iterator().next();
        assertTrue(oclEq.getRight() instanceof QMarkLiteralExp);
        assertTrue(oclEq.getLeft() instanceof OperationCallExp);
    }
    
    @Override
    protected Properties getProperties() {
        Properties p = super.getProperties();
        p.put("source", "testfixture/" + this.getName().substring("test".length()) + ".xmi");
        return p;
    }
    

    @Override
    protected void setUp() throws Exception {
            EPackage.Registry.INSTANCE.put( OclinversionPackage.eINSTANCE.getNsURI(),  OclinversionPackage.eINSTANCE);
            EPackage.Registry.INSTANCE.put( EcorePackage.eINSTANCE.getNsURI(),  EcorePackage.eINSTANCE);
            EPackage.Registry.INSTANCE.put( org.eclipse.ocl.ecore.EcorePackage.eINSTANCE.getNsURI(),  org.eclipse.ocl.ecore.EcorePackage.eINSTANCE);
            metamodelIDs = new String[]{"oclinversion","ecore","oclinversion"};
            System.setProperty(QVTTestAdapter.QVTTESTADAPTER_TWOSOURCEMODELS, "true");
            System.setProperty(QVTTestAdapter.PROP_DISABLE_TRACES, "true");
            
            super.setUp();
            
            ILog oldLog = ((OCLEMFTestAdapter) this.adapter).log;
            ((OCLEMFTestAdapter) this.adapter).log = new LogDelegator(oldLog);
            ((QvtProcessorImpl)this.adapter.getQvtProcessor()).setProperty(QVTProcessorConsts.PROP_DEBUG, "true");
            ((QVTEMFTestAdapter) this.adapter).registerMetaModel((EPackageImpl) OclinversionPackage.eINSTANCE);
            ((QVTEMFTestAdapter) this.adapter).registerMetaModel((EPackageImpl) EcorePackage.eINSTANCE);
            ((QVTEMFTestAdapter) this.adapter).registerMetaModel((EPackageImpl) org.eclipse.ocl.ecore.EcorePackage.eINSTANCE);
            ((QVTEMFTestAdapter) this.adapter).initRepository();
//            ((QVTEMFTestAdapter) this.adapter).registerMetaModel((EPackageImpl) Ocl.eINSTANCE);
            // topPackage
//            this.oclEquation = this.createModelElement("oclinversion::oclequation::OclEquation");
//            this.oclEquation = this.createModelElement("oclinversion::oclequation::OclEquation");
//            this.adapter.setValueForFeature(this.oclEquation, "left", "TestClass");
    }
    
    /**
     * Get IDs of all model elements
     * 
     * @param onTarget
     *            if true, IDs of the target model are collected
     * @return
     */
    @Override
    protected Collection getSourceIDs(boolean onTarget) {

            List result = !onTarget ? this.adapter.evaluateOnSource("oclinversion::oclequation::OclEquation.allInstances()->select(eq | eq.isSource)") :
                this.adapter.evaluateOnTarget("oclinversion::oclequation::OclEquation.allInstances()->reject(eq | eq.isSource)");
            Assert.assertEquals(1, result.size());
            Assert.assertEquals(true, result.get(0) instanceof Collection);
            Collection ids1 = new HashSet();
            for (Object object : (Collection) result.get(0)) {
                ids1.add(object);
            }

            return new ArrayList(ids1);
    }
}
