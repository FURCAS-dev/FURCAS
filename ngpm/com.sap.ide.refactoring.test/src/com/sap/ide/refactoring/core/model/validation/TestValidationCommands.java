package com.sap.ide.refactoring.core.model.validation;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.ide.refactoring.test.RefactoringBaseTest;

public class TestValidationCommands extends RefactoringBaseTest {

    /**
     * System under test
     */
    private AbstractValidationCommand sut;
    
    private RefactoringEditorFacade facade;
    
        
    @Test
    public void testGoodCaseOfBlockIsParsableCommand() {
	facade = createEditorFacadeForRunletClass("Class1");
	
	sut = new CheckBlockIsParsableCommand(facade, facade.getTextBlocksModel().getRoot());
	sut.execute();
	
	assertTrue("Parse must have finished without errors", sut.getResultAsStatus().isOK());
    }
    
    @Test
    public void testErrorCaseOfBlockIsParsableCommand() {
	facade = createEditorFacadeForRunletClass("Class1");
	
	facade.getTextBlocksModel().replace(0, 5, "klazz"); // introduce syntax error
	
	sut = new CheckBlockIsParsableCommand(facade, facade.getTextBlocksModel().getRoot());
	sut.execute();
	
	assertTrue("Parse must have failed", !sut.getResultAsStatus().isOK());
    }
    
    
    @After
    public void releaseResources() {
	facade = null;
	sut = null;
    }
}
