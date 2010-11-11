/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.debug.test;

import org.junit.Test;

import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.AssociationNavigationStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.BranchingNavigationStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.IndirectingStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.NavigationStepSequence;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.debug.NavigationStepDebugHelperImpl;

public class GraphTest {
    final static private String BASE_PRINT_PATH = GraphTest.class.getResource("").getPath();
    
    @Test
    public void testNavigationSequenceStepGraph(){
	AssociationNavigationStep associationNavigationStep1 = new AssociationNavigationStep(null, null, null, null);
	AssociationNavigationStep associationNavigationStep2 = new AssociationNavigationStep(null, null, null, null);
	AssociationNavigationStep associationNavigationStep3 = new AssociationNavigationStep(null, null, null, null);
	AssociationNavigationStep associationNavigationStep4 = new AssociationNavigationStep(null, null, null, null);
	AssociationNavigationStep associationNavigationStep5 = new AssociationNavigationStep(null, null, null, null);
	AssociationNavigationStep associationNavigationStep6 = new AssociationNavigationStep(null, null, null, null);
	
	NavigationStepSequence nestedSequence = new NavigationStepSequence(null, associationNavigationStep2, associationNavigationStep3, associationNavigationStep4);
	NavigationStepSequence sequence = new NavigationStepSequence(null, associationNavigationStep1, nestedSequence, associationNavigationStep5, associationNavigationStep6);
	
	NavigationStepDebugHelperImpl.printGraphFile(sequence, BASE_PRINT_PATH + "testNavigationSequenceStepGraph.graphml");
    }
    
    @Test
    public void testBranchingNavigationStepGraph(){
	AssociationNavigationStep associationNavigationStep1 = new AssociationNavigationStep(null, null, null, null);
	AssociationNavigationStep associationNavigationStep2 = new AssociationNavigationStep(null, null, null, null);
	AssociationNavigationStep associationNavigationStep3 = new AssociationNavigationStep(null, null, null, null);
	AssociationNavigationStep associationNavigationStep4 = new AssociationNavigationStep(null, null, null, null);
	AssociationNavigationStep associationNavigationStep5 = new AssociationNavigationStep(null, null, null, null);
	AssociationNavigationStep associationNavigationStep6 = new AssociationNavigationStep(null, null, null, null);
	
	BranchingNavigationStep nestedBranch = new BranchingNavigationStep(null, null, null, associationNavigationStep2, associationNavigationStep3, associationNavigationStep4);
	BranchingNavigationStep branch = new BranchingNavigationStep(null, null, null, associationNavigationStep1, nestedBranch, associationNavigationStep5, associationNavigationStep6);

	NavigationStepDebugHelperImpl.printGraphFile(branch, BASE_PRINT_PATH + "testBranchingNavigationStepGraph.graphml");
    }
    
    @Test
    public void testIndirectionStepGraph(){
	AssociationNavigationStep associationNavigationStep1 = new AssociationNavigationStep(null, null, null, null);
	AssociationNavigationStep associationNavigationStep2 = new AssociationNavigationStep(null, null, null, null);
	AssociationNavigationStep associationNavigationStep3 = new AssociationNavigationStep(null, null, null, null);
	AssociationNavigationStep associationNavigationStep4 = new AssociationNavigationStep(null, null, null, null);
	AssociationNavigationStep associationNavigationStep5 = new AssociationNavigationStep(null, null, null, null);
	AssociationNavigationStep associationNavigationStep6 = new AssociationNavigationStep(null, null, null, null);
	
	
	IndirectingStep indirectAnother = new IndirectingStep(null);
	indirectAnother.setActualStep(associationNavigationStep6);
	
	IndirectingStep indirectSelf = new IndirectingStep(null);
	
	BranchingNavigationStep nestedBranch = new BranchingNavigationStep(null, null, null, associationNavigationStep2, associationNavigationStep3, associationNavigationStep4, indirectAnother);
	BranchingNavigationStep branch = new BranchingNavigationStep(null, null, null, associationNavigationStep1, nestedBranch, associationNavigationStep5, associationNavigationStep6, indirectSelf, indirectAnother);
	
	indirectSelf.setActualStep(branch);

	NavigationStepDebugHelperImpl.printGraphFile(branch, BASE_PRINT_PATH + "testIndirectionStepGraph.graphml");
    }
    
    @Test
    public void testAllGraph(){

	AssociationNavigationStep associationNavigationStep1 = new AssociationNavigationStep(null, null, null, null);
	AssociationNavigationStep associationNavigationStep2 = new AssociationNavigationStep(null, null, null, null);
	AssociationNavigationStep associationNavigationStep3 = new AssociationNavigationStep(null, null, null, null);
	AssociationNavigationStep associationNavigationStep4 = new AssociationNavigationStep(null, null, null, null);
	AssociationNavigationStep associationNavigationStep5 = new AssociationNavigationStep(null, null, null, null);
	AssociationNavigationStep associationNavigationStep6 = new AssociationNavigationStep(null, null, null, null);
	
	AssociationNavigationStep associationNavigationStep7 = new AssociationNavigationStep(null, null, null, null);
	AssociationNavigationStep associationNavigationStep8 = new AssociationNavigationStep(null, null, null, null);
	AssociationNavigationStep associationNavigationStep9 = new AssociationNavigationStep(null, null, null, null);
	
	NavigationStepSequence sequence = new NavigationStepSequence(null, null, associationNavigationStep7, associationNavigationStep8, associationNavigationStep9);
	
	IndirectingStep indirectAnother = new IndirectingStep(null);
	indirectAnother.setActualStep(associationNavigationStep6);
	
	IndirectingStep indirectSelf = new IndirectingStep(null);
	
	BranchingNavigationStep nestedBranch = new BranchingNavigationStep(null, null, null, associationNavigationStep2, associationNavigationStep3, associationNavigationStep4, indirectAnother, sequence);
	BranchingNavigationStep branch = new BranchingNavigationStep(null, null, null, associationNavigationStep1, nestedBranch, associationNavigationStep5, associationNavigationStep6, indirectSelf, indirectAnother);
	
	indirectSelf.setActualStep(branch);
	
	NavigationStepDebugHelperImpl.printGraphFile(branch, BASE_PRINT_PATH + "testAllGraph.graphml");
	
	
    }
    
    @Test
    public void testEdgeLabeling(){
	/**PathCache pathCache = new PathCache();
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
	
	NavigationStepSequence sequence = new NavigationStepSequence(null, null, pathCache, associationNavigationStep7, associationNavigationStep8, associationNavigationStep9);
	
	IndirectingStep indirectAnother = new IndirectingStep(null);
	indirectAnother.setActualStep(associationNavigationStep6);
	
	IndirectingStep indirectSelf = new IndirectingStep(null);
	
	BranchingNavigationStep nestedBranch = new BranchingNavigationStep(null, null, null, null, pathCache, associationNavigationStep2, associationNavigationStep3, associationNavigationStep4, indirectAnother, sequence);
	BranchingNavigationStep branch = new BranchingNavigationStep(null, null, null, null, pathCache, associationNavigationStep1, nestedBranch, associationNavigationStep5, associationNavigationStep6, indirectSelf, indirectAnother);
	
	indirectSelf.setActualStep(branch);

	NavigationStepDebugHelperImpl.printGraphFile(branch, BASE_PRINT_PATH + "testAllGraph.graphml");
	printToString(branch, BASE_PRINT_PATH + "testAllGraph.step");	**/
    }
    
}
