package com.sap.tc.moin.ocl.ia.instancescope.debug.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

import com.sap.tc.moin.ocl.ia.instancescope.AssociationNavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.BranchingNavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.IndirectingStep;
import com.sap.tc.moin.ocl.ia.instancescope.NavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.NavigationStepSequence;
import com.sap.tc.moin.ocl.ia.instancescope.debug.NavigationStepDebugHelper;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndImpl;

public class GraphTest {
    final static private String BASE_PRINT_PATH = GraphTest.class.getResource("").getPath();
    
    @Test
    public void testNavigationSequenceStepGraph(){
	AssociationEndImpl end = new AssociationEndImpl();
	AssociationNavigationStep associationNavigationStep1 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep2 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep3 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep4 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep5 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep6 = new AssociationNavigationStep(null, null, end, null);
	
	NavigationStepSequence nestedSequence = new NavigationStepSequence(null, null, associationNavigationStep2, associationNavigationStep3, associationNavigationStep4);
	NavigationStepSequence sequence = new NavigationStepSequence(null, null, associationNavigationStep1, nestedSequence, associationNavigationStep5, associationNavigationStep6);
	
	NavigationStepDebugHelper.printGraphFile(sequence, BASE_PRINT_PATH + "testNavigationSequenceStepGraph.graphml");
	
	printToString(sequence, BASE_PRINT_PATH + "testNavigationSequenceStepGraph.step");
    }
    
    @Test
    public void testBranchingNavigationStepGraph(){
	AssociationEndImpl end = new AssociationEndImpl();
	AssociationNavigationStep associationNavigationStep1 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep2 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep3 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep4 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep5 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep6 = new AssociationNavigationStep(null, null, end, null);
	
	BranchingNavigationStep nestedBranch = new BranchingNavigationStep(null, null, null, null, associationNavigationStep2, associationNavigationStep3, associationNavigationStep4);
	BranchingNavigationStep branch = new BranchingNavigationStep(null, null, null, null, associationNavigationStep1, nestedBranch, associationNavigationStep5, associationNavigationStep6);

	NavigationStepDebugHelper.printGraphFile(branch, BASE_PRINT_PATH + "testBranchingNavigationStepGraph.graphml");
    }
    
    @Test
    public void testIndirectionStepGraph(){
	AssociationEndImpl end = new AssociationEndImpl();
	AssociationNavigationStep associationNavigationStep1 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep2 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep3 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep4 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep5 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep6 = new AssociationNavigationStep(null, null, end, null);
	
	
	IndirectingStep indirectAnother = new IndirectingStep(null);
	indirectAnother.setActualStep(associationNavigationStep6);
	
	IndirectingStep indirectSelf = new IndirectingStep(null);
	
	BranchingNavigationStep nestedBranch = new BranchingNavigationStep(null, null, null, null, associationNavigationStep2, associationNavigationStep3, associationNavigationStep4, indirectAnother);
	BranchingNavigationStep branch = new BranchingNavigationStep(null, null, null, null, associationNavigationStep1, nestedBranch, associationNavigationStep5, associationNavigationStep6, indirectSelf, indirectAnother);
	
	indirectSelf.setActualStep(branch);

	NavigationStepDebugHelper.printGraphFile(branch, BASE_PRINT_PATH + "testIndirectionStepGraph.graphml");
	printToString(branch, BASE_PRINT_PATH + "testIndirectionStepGraph.step");
    }
    
    @Test
    public void testAllGraph(){
	AssociationEndImpl end = new AssociationEndImpl();
	AssociationNavigationStep associationNavigationStep1 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep2 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep3 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep4 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep5 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep6 = new AssociationNavigationStep(null, null, end, null);
	
	AssociationNavigationStep associationNavigationStep7 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep8 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep9 = new AssociationNavigationStep(null, null, end, null);
	
	NavigationStepSequence sequence = new NavigationStepSequence(null, null, associationNavigationStep7, associationNavigationStep8, associationNavigationStep9);
	
	IndirectingStep indirectAnother = new IndirectingStep(null);
	indirectAnother.setActualStep(associationNavigationStep6);
	
	IndirectingStep indirectSelf = new IndirectingStep(null);
	
	BranchingNavigationStep nestedBranch = new BranchingNavigationStep(null, null, null, null, associationNavigationStep2, associationNavigationStep3, associationNavigationStep4, indirectAnother, sequence);
	BranchingNavigationStep branch = new BranchingNavigationStep(null, null, null, null, associationNavigationStep1, nestedBranch, associationNavigationStep5, associationNavigationStep6, indirectSelf, indirectAnother);
	
	indirectSelf.setActualStep(branch);
	
	NavigationStepDebugHelper.printGraphFile(branch, BASE_PRINT_PATH + "testAllGraph.graphml");
	printToString(branch, BASE_PRINT_PATH + "testAllGraph.step");
	
	
    }
    
    @Test
    public void testEdgeLabeling(){
	AssociationEndImpl end = new AssociationEndImpl();
	
	AssociationNavigationStep associationNavigationStep1 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep2 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep3 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep4 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep5 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep6 = new AssociationNavigationStep(null, null, end, null);
	
	AssociationNavigationStep associationNavigationStep7 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep8 = new AssociationNavigationStep(null, null, end, null);
	AssociationNavigationStep associationNavigationStep9 = new AssociationNavigationStep(null, null, end, null);
	
	NavigationStepSequence sequence = new NavigationStepSequence(null, null, associationNavigationStep7, associationNavigationStep8, associationNavigationStep9);
	
	IndirectingStep indirectAnother = new IndirectingStep(null);
	indirectAnother.setActualStep(associationNavigationStep6);
	
	IndirectingStep indirectSelf = new IndirectingStep(null);
	
	BranchingNavigationStep nestedBranch = new BranchingNavigationStep(null, null, null, null, associationNavigationStep2, associationNavigationStep3, associationNavigationStep4, indirectAnother, sequence);
	BranchingNavigationStep branch = new BranchingNavigationStep(null, null, null, null, associationNavigationStep1, nestedBranch, associationNavigationStep5, associationNavigationStep6, indirectSelf, indirectAnother);
	
	indirectSelf.setActualStep(branch);

	NavigationStepDebugHelper.printGraphFile(branch, BASE_PRINT_PATH + "testAllGraph.graphml");
	printToString(branch, BASE_PRINT_PATH + "testAllGraph.step");	
    }
    
    
    private void printToString(NavigationStep step, String path){
	File f = new File(path);
	
	try {
	    f.createNewFile();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
	FileWriter writer;
	try {
	    writer = new FileWriter(f);

	    BufferedWriter bufferedWriter = new BufferedWriter(writer);
        	
	    bufferedWriter.write(step.toString());
	    bufferedWriter.flush();
	    bufferedWriter.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
