package com.sap.ide.refactoring.op.move;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.junit.Test;

import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.ide.refactoring.model.move.MovableElementTarget;
import com.sap.ide.refactoring.test.RefactoringBaseTest;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import data.classes.MethodSignature;
import data.classes.SapClass;

public class TestMove extends RefactoringBaseTest {

    /**
     * Refactor by:
     * 
     * @param sut using this refactoring instance, to
     * @param movee move this element
     * @param target to this element by
     * @param associationRole using a role of this name
     * @return
     */
    private Change move(MoveRefactoring sut, RefObject movee, RefObject target, String associationRole) {

	sut.setElementToMove(movee);
	assertTrue(sut.checkInitialConditions(new NullProgressMonitor()).isOK());

	boolean targetFound = false;
	Collection<MovableElementTarget> potentialTargets = sut.getElementToMove().getPotentialMovingTargets();
	for (MovableElementTarget potentialTarget : potentialTargets) {
	    if (potentialTarget.getWrappedModelElement().equals(target) && potentialTarget.getRole().equals(associationRole)) {
		sut.setTarget(potentialTarget);
		System.out.println("found for " + potentialTarget.getRole());
		targetFound = true;
		break;
	    }
	}
	assertTrue(targetFound);
		
	RefactoringStatus finalCheck = sut.checkFinalConditions(new NullProgressMonitor());
	assertTrue(finalCheck.toString(), finalCheck.isOK());
	Change change = sut.createChange(new NullProgressMonitor());
	return change;
    }

    @Test
    public void testMoveMethodFromOneToAnotherClass() throws Exception {
	RefactoringEditorFacade facade = createEditorFacadeForRunletClass("ClassWithAbstractMethod");
	MoveRefactoring sut = new MoveRefactoring(facade);
	
	SapClass sourceClass = findRunletClassUsingConnection("ClassWithAbstractMethod", facade.getEditorConnection());
	SapClass targetClass = findRunletClassUsingConnection("Class2", facade.getEditorConnection());
	MethodSignature method = sourceClass.getOwnedSignatures().iterator().next();

	assertEquals("Method should be owned by the source before the refactoring", sourceClass, method.refImmediateComposite());
	Change change = move(sut, method, targetClass, /*role*/"owner");
	change.perform(new NullProgressMonitor());

	assertTrue("Method should no longer by in the source class", sourceClass.getOwnedSignatures().isEmpty());
	assertEquals("Method should now be owned by the target", targetClass, method.refImmediateComposite());
	assertTrue("Should be added as a method signature", targetClass.getOwnedSignatures().contains(method));
    }

    @Test
    public void testMoveMethodMovesTextAsWell() throws Exception {
	RefactoringEditorFacade facade = createEditorFacadeForRunletClass("ClassWithAbstractMethod");
	MoveRefactoring sut = new MoveRefactoring(facade);
	
	SapClass sourceClass = findRunletClassUsingConnection("ClassWithAbstractMethod", facade.getEditorConnection());
	SapClass targetClass = findRunletClassUsingConnection("Class2", facade.getEditorConnection());
	MethodSignature method = sourceClass.getOwnedSignatures().iterator().next();
	
	Change change = move(sut, method, targetClass, /*role*/"owner");
	change.perform(new NullProgressMonitor());
	
	RefactoringEditorFacade sourceFacade = createEditorFacadeForRunletClass("ClassWithAbstractMethod");
	RefactoringEditorFacade targetFacade = createEditorFacadeForRunletClass("Class2");
	
	assertFalse("Method must no longer be in the source: " + sourceFacade.getContentAsText(),
		sourceFacade.getContentAsText().contains("void n"));
	assertTrue("Method must be in the target class: " +  targetFacade.getContentAsText(),
		targetFacade.getContentAsText().contains("void n"));
    }
}
