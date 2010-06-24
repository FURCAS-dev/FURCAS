package com.sap.ide.refactoring.core.textual;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;

import ngpm.NgpmPackage;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.junit.Test;

import textblocks.TextBlock;

import com.sap.ide.refactoring.core.AbstractRefactoringCommand;
import com.sap.ide.refactoring.core.RefactoringResult;
import com.sap.ide.refactoring.core.TextBlockAwareRefactoringCommandExecutor;
import com.sap.ide.refactoring.core.TextBlockChange;
import com.sap.ide.refactoring.test.RefactoringBaseTest;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.PartitionOperation;

import data.classes.MethodSignature;
import data.classes.SapClass;
import data.classes.SignatureImplementation;

/**
 * Tests the integration of {@link TextBlockAwareRefactoringCommandExecutor},
 * {@link TextBlockInChangeCalculator} and {@link TextBlocksSynchronizationCommand}.
 * 
 * @author D049157
 * 
 */
public class CommandExecutionPrettyPrintInteractionTest extends RefactoringBaseTest {

    private static class NothingChangedCommand extends AbstractRefactoringCommand {

	private final SapClass clazz;

	protected NothingChangedCommand(Connection connection, SapClass clazz) {
	    super(connection, "Do nothing");
	    this.clazz = clazz;
	}

	@Override
	protected void performRefactoring() {
	    for (MethodSignature method : new ArrayList<MethodSignature>(clazz.getOwnedSignatures())) {
		// Do something to trigger events. Then make everything the way before
		method.setOwner(null);
		clazz.getOwnedSignatures().remove(method);
		method.setOwner(clazz);
		clazz.getOwnedSignatures().add(method);
	    }
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
	    return null;
	}
    }

    private class CreateMethodCommand extends AbstractRefactoringCommand {

	private final SapClass clazz;
	private final String methodName;

	protected CreateMethodCommand(Connection connection, SapClass clazz, String methodName) {
	    super(connection, "Creat method " + methodName);
	    this.clazz = clazz;
	    this.methodName = methodName;
	}

	@Override
	protected void performRefactoring() {
	    NgpmPackage rootPkg = connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
	    MethodSignature method = (MethodSignature) rootPkg.getData().getClasses().getMethodSignature().refCreateInstance();
	    method.setName(methodName);
	    SignatureImplementation impl = (SignatureImplementation) rootPkg.getBehavioral().getActions().getBlock()
		    .refCreateInstance();
	    method.setImplementation(impl);

	    clazz.getOwnedSignatures().add(method);
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
	    return null;
	}
    }

    private static class DeleteMethodCommand extends AbstractRefactoringCommand {

	private final SapClass clazz;
	private final String methodName;

	protected DeleteMethodCommand(Connection connection, SapClass clazz, String methodName) {
	    super(connection, "Delete method " + methodName);
	    this.clazz = clazz;
	    this.methodName = methodName;
	}

	@Override
	protected void performRefactoring() {
	    for (MethodSignature method : clazz.getOwnedSignatures()) {
		if (method.getName().equals(methodName)) {
		    method.refDelete();
		}
	    }
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
	    return null;
	}
    }

    private static class MoveMethodCommand extends AbstractRefactoringCommand {

	private final String methodName;
	private final SapClass sourceClazz;
	private final SapClass targetClazz;

	protected MoveMethodCommand(Connection connection, SapClass sourceClazz, SapClass targetClazz, String methodName) {
	    super(connection, "Move method " + methodName);
	    this.sourceClazz = sourceClazz;
	    assert sourceClazz != null;
	    this.targetClazz = targetClazz;
	    assert targetClazz != null;
	    this.methodName = methodName;
	}

	@Override
	protected void performRefactoring() {
	    for (MethodSignature method : new ArrayList<MethodSignature>(sourceClazz.getOwnedSignatures())) {
		if (method.getName().equals(methodName)) {
		    sourceClazz.getOwnedSignatures().remove(method);
		    method.setOwner(targetClazz);
		    targetClazz.getOwnedSignatures().add(method);
		}
	    }
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
	    return null;
	}
    }

    /**
     * System under test
     */
    private TextBlockAwareRefactoringCommandExecutor cmdExecutor;

    private RefactoringEditorFacade facade;
    
    @Test
    public void testSomethingChangedButNothingNeedsPrettyPrinting() throws CoreException {
	facade = createEditorFacadeForRunletClass("ClassWithEmptyMethod");
	SapClass clazz = (SapClass) facade.getDecoratedDomainRootObject();

	AbstractRefactoringCommand cmd = new NothingChangedCommand(facade.getConnection(), clazz);
	cmdExecutor = new TextBlockAwareRefactoringCommandExecutor(facade, cmd);

	RefactoringResult result = cmdExecutor.runRefactoring(new NullProgressMonitor());
	TextBlockChange textualChange = getFirstTextBlockChange(result.change);

	String currentContent = textualChange.getCurrentContent(new NullProgressMonitor());
	String previewContent = textualChange.getPreviewContent(new NullProgressMonitor());
	assertEqualsIgnoreWhitespaces("Content must remain unchanged", currentContent, previewContent);
	
	assertEquals("Content and formatting must remain unchanged", currentContent, previewContent);
    }

    @Test
    public void testCreateModelElementNeedsToTriggerTextBlocksCreation() throws CoreException {
	facade = createEditorFacadeForRunletClass("Class2");
	SapClass clazz = (SapClass) facade.getDecoratedDomainRootObject();

	AbstractRefactoringCommand cmd = new CreateMethodCommand(facade.getConnection(), clazz, "NewMethod");
	cmdExecutor = new TextBlockAwareRefactoringCommandExecutor(facade, cmd);

	RefactoringResult result = cmdExecutor.runRefactoring(new NullProgressMonitor());
	TextBlockChange textualChange = getFirstTextBlockChange(result.change);

	String currentContent = textualChange.getCurrentContent(new NullProgressMonitor());
	String previewContent = textualChange.getPreviewContent(new NullProgressMonitor());
	assertFalse("Method must not have been existed before", currentContent.contains("void NewMethod()"));
	assertTrue("New method must have been created", previewContent.contains("void NewMethod()"));
    }

    @Test
    public void testDeleteModelElementNeedsToTriggerTextBlocksDeletion() throws CoreException {
	facade = createEditorFacadeForRunletClass("ClassWithEmptyMethod");
	SapClass clazz = (SapClass) facade.getDecoratedDomainRootObject();

	AbstractRefactoringCommand cmd = new DeleteMethodCommand(facade.getConnection(), clazz, "m");
	cmdExecutor = new TextBlockAwareRefactoringCommandExecutor(facade, cmd);

	RefactoringResult result = cmdExecutor.runRefactoring(new NullProgressMonitor());
	TextBlockChange textualChange = getFirstTextBlockChange(result.change);

	String currentContent = textualChange.getCurrentContent(new NullProgressMonitor());
	String previewContent = textualChange.getPreviewContent(new NullProgressMonitor());
	assertTrue("Method must exist before", currentContent.contains("void m()"));
	assertFalse("Method must not exist any longer", previewContent.contains("void m()"));
    }

    @Test
    public void testMovedModelElementTakesTextWithIt() throws CoreException {
	facade = createEditorFacadeForRunletClass("RedefineParameterTst2");
	SapClass sourceClazz = findRunletClass("RedefineParameterTst2");
	SapClass targetClazz = findRunletClass("Class2");

	AbstractRefactoringCommand cmd = new MoveMethodCommand(facade.getConnection(), sourceClazz, targetClazz, "n");
	cmdExecutor = new TextBlockAwareRefactoringCommandExecutor(facade, cmd);

	// Assert that the model is as we expect it to be
	assertTrue("n".equals(sourceClazz.getOwnedSignatures().iterator().next().getName()));
	assertTrue(targetClazz.getOwnedSignatures().isEmpty());

	RefactoringResult result = cmdExecutor.runRefactoring(new NullProgressMonitor());

	// Two classes are involved: therefore there are two change objects.
	// We must find out which belongs to which class
	TextBlockChange changeOfClass2;
	TextBlockChange changeOfThisToParameterChange;
	if (getTextBlockChange(result.change, 1).getCurrentContent(new NullProgressMonitor()).contains("Class2")) {
	    changeOfClass2 = getTextBlockChange(result.change, 1);
	    changeOfThisToParameterChange = getTextBlockChange(result.change, 2);
	} else {
	    changeOfClass2 = getTextBlockChange(result.change, 2);
	    changeOfThisToParameterChange = getTextBlockChange(result.change, 1);
	}

	String currentContentOfThisFoo = changeOfThisToParameterChange.getCurrentContent(new NullProgressMonitor());
	String previewContentOfThisFoo = changeOfThisToParameterChange.getPreviewContent(new NullProgressMonitor());
	String currentContentOfClass2 = changeOfClass2.getCurrentContent(new NullProgressMonitor());
	String previewContentOfClass2 = changeOfClass2.getPreviewContent(new NullProgressMonitor());

	// Assert that the model is as we expect it to be
	result.change.perform(new NullProgressMonitor()); // re-apply so that we can check the model
	assertTrue("n".equals(targetClazz.getOwnedSignatures().iterator().next().getName()));
	assertTrue(sourceClazz.getOwnedSignatures().isEmpty());

	// Check that the text has been changed as expected.
	assertTrue("Method must exist before in " + currentContentOfThisFoo, currentContentOfThisFoo.contains("n("));
	assertFalse("Method must not exist any longer in " + previewContentOfThisFoo, previewContentOfThisFoo.contains("n("));
	assertFalse("Method must not exist before", currentContentOfClass2.contains("n("));
	assertTrue("Method must exist afterwards in " + previewContentOfClass2, previewContentOfClass2.contains("n("));
    }
    
    /** 
     * The following is a whitebox test. It makes some heavy assumptions and might
     * break rather often...
     * 
     * @throws CoreException
     */
    @Test
    public void testMovedModelElementEvenTakesTextBlockWithIt() throws CoreException {
	facade = createEditorFacadeForRunletClass("RedefineParameterTst2");
	SapClass sourceClazz = findRunletClass("RedefineParameterTst2");
	SapClass targetClazz = findRunletClass("Class2");

	AbstractRefactoringCommand cmd = new MoveMethodCommand(facade.getConnection(), sourceClazz, targetClazz, "n");
	cmdExecutor = new TextBlockAwareRefactoringCommandExecutor(facade, cmd);
	
	RefactoringResult result = cmdExecutor.runRefactoring(new NullProgressMonitor());

	TextBlock sourceRootBlock = (TextBlock) TextBlockRefactoringUtil.findCorrespondingTextBlocks(sourceClazz).iterator().next();
	TextBlock targetRootBlock = (TextBlock) TextBlockRefactoringUtil.findCorrespondingTextBlocks(targetClazz).iterator().next();

	assertEquals("Testcase makes assumption on sourceClass TextBlocks model", 1, sourceRootBlock.getSubBlocks().size());
	assertEquals("Testcase makes assumption on targetClass TextBlocks model", 0, targetRootBlock.getSubBlocks().size());
	TextBlock methodTextBlock = sourceRootBlock.getSubBlocks().iterator().next();
	
	assertEquals("Method TB is in its old place", sourceRootBlock, methodTextBlock.getParentBlock());
	result.change.perform(new NullProgressMonitor());
	
	assertEquals("Method TB must have moved!", targetRootBlock, methodTextBlock.getParentBlock());
	
    }

    private TextBlockChange getTextBlockChange(Change change, int n) {
	try {
	    assertTrue("Change must be valid. Otherwise, this implies that the change operation failed", change.isValid(
		    new NullProgressMonitor()).isOK());
	} catch (Exception e) {
	    fail(e.getMessage());
	}
	return (TextBlockChange) ((CompositeChange) change).getChildren()[n];
    }

    private TextBlockChange getFirstTextBlockChange(Change change) {
	return getTextBlockChange(change, 1);
    }
    
    private void assertEqualsIgnoreWhitespaces(String message, String expected, String actual) {
	expected = expected.replaceAll(" ", "").replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "");
	actual = actual.replaceAll(" ", "").replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "");
	assertEquals(message, expected, actual);
    }


}
