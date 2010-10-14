package com.sap.runlet.interpreter.test;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;

import behavioral.actions.ActionsFactory;
import behavioral.actions.Block;
import behavioral.actions.IfElse;

public class OclPerformanceTest extends TestCase {
    public void testDerivedGetterPerformance() {
	IProject project = getStdlibProject();
	try {
	    project.open(/* progress monitor */null);
	    Block ifBlock = ActionsFactory.eINSTANCE.createBlock();
	    Block elseBlock = ActionsFactory.eINSTANCE.createBlock();
	    IfElse ie = ActionsFactory.eINSTANCE.createIfElse();
	    ie.getNestedBlocks().add(ifBlock);
	    ie.getNestedBlocks().add(elseBlock);
	    assertEquals(ie.getNestedBlocks().get(0), ifBlock);
	    assertEquals(ie.getNestedBlocks().get(1), elseBlock);
	    assertEquals(ie.getIfBlock(), ifBlock);
	    assertEquals(ie.getElseBlock(), elseBlock);
	    long start = System.currentTimeMillis();
	    for (int i=0; i<100000; i++) {
		ie.getIfBlock();
		ie.getElseBlock();
	    }
	    long end = System.currentTimeMillis();
	    System.out.println("testDerivedGetterPerformance OCL: "+(end-start)+"ms");
	    start = System.currentTimeMillis();
	    for (int i=0; i<100000; i++) {
		ie.getNestedBlocks().get(0);
		ie.getNestedBlocks().get(1);
	    }
	    end = System.currentTimeMillis();
	    System.out.println("testDerivedGetterPerformance JMI: "+(end-start)+"ms");
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    private IProject getStdlibProject() {
	IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(
		"ngpm.stdlib");
	return project;
    }
    
}
