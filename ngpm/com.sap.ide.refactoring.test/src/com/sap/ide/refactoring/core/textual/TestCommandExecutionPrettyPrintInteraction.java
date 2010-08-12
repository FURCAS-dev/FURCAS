package com.sap.ide.refactoring.core.textual;

import static com.sap.ide.refactoring.test.RefactoringAssertionUtil.assertEqualsIgnoreWhitespaces;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;

import ngpm.NgpmPackage;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.junit.Ignore;
import org.junit.Test;

import textblocks.TextBlock;

import com.sap.ide.refactoring.core.AbstractRefactoringCommand;
import com.sap.ide.refactoring.core.RefactoringCoreException;
import com.sap.ide.refactoring.core.execution.RefactoringCommandExecutor;
import com.sap.ide.refactoring.core.execution.RefactoringResult;
import com.sap.ide.refactoring.test.RefactoringBaseTest;
import com.sap.mi.textual.parsing.textblocks.TbDebugUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import data.classes.MethodSignature;
import data.classes.SapClass;
import data.classes.SignatureImplementation;

/**
 * Tests the integration of {@link RefactoringCommandExecutor},
 * {@link TextBlockInChangeCalculator} and {@link TextBlocksSynchronizationCommand}.
 * 
 * @author D049157
 * 
 */
public class TestCommandExecutionPrettyPrintInteraction extends RefactoringBaseTest {

    private static class NothingChangedCommand extends AbstractRefactoringCommand {

	private final SapClass clazz;

	protected NothingChangedCommand(Connection connection, SapClass clazz) {
	    super(connection, "Do nothing");
	    this.clazz = clazz;
	}

	@Override
	protected void performRefactoring(IProgressMonitor pm) {
	    for (MethodSignature method : new ArrayList<MethodSignature>(clazz.getOwnedSignatures())) {
		// Do something to trigger events. Then make everything the way before
		clazz.getOwnedSignatures().remove(method);
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
	protected void performRefactoring(IProgressMonitor pm) {
	    NgpmPackage rootPkg = connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
	    MethodSignature method = (MethodSignature) rootPkg.getData().getClasses().getMethodSignature().refCreateInstance();
	    method.setName(methodName);
	    SignatureImplementation impl = (SignatureImplementation) rootPkg.getBehavioral().getActions().getBlock()
		    .refCreateInstance();
	    impl.setImplements(method);

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
	protected void performRefactoring(IProgressMonitor pm) {
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
	protected void performRefactoring(IProgressMonitor pm) {
	    for (MethodSignature method : new ArrayList<MethodSignature>(sourceClazz.getOwnedSignatures())) {
		if (method.getName().equals(methodName)) {
		    sourceClazz.getOwnedSignatures().remove(method);
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
    private RefactoringCommandExecutor cmdExecutor;

    private RefactoringEditorFacade facade;
    
    @Test
    public void testSomethingChangedButNothingNeedsPrettyPrinting() throws RefactoringCoreException {
	facade = createEditorFacadeForRunletClass("ClassWithEmptyMethod");
	SapClass clazz = (SapClass) facade.getDecoratedDomainRootObject();

	AbstractRefactoringCommand cmd = new NothingChangedCommand(facade.getEditorConnection(), clazz);
	cmdExecutor = new RefactoringCommandExecutorTestable(facade, cmd);

	RefactoringResult result = cmdExecutor.runRefactoring(new NullProgressMonitor());
	TextBlockChange textualChange = getTextBlockChange(result.change, clazz);

	String currentContent = textualChange.getCurrentContent(new NullProgressMonitor());
	String previewContent = textualChange.getPreviewContent(new NullProgressMonitor());
	assertEqualsIgnoreWhitespaces("Content must remain unchanged", currentContent, previewContent);
	
	assertEquals("Content and formatting must remain unchanged", currentContent, previewContent);
    }

    @Test
    public void testCreateModelElementNeedsToTriggerTextBlocksCreation() throws RefactoringCoreException {
	facade = createEditorFacadeForRunletClass("Class2");
	SapClass clazz = (SapClass) facade.getDecoratedDomainRootObject();

	AbstractRefactoringCommand cmd = new CreateMethodCommand(facade.getEditorConnection(), clazz, "NewMethod");
	cmdExecutor = new RefactoringCommandExecutorTestable(facade, cmd);

	RefactoringResult result = cmdExecutor.runRefactoring(new NullProgressMonitor());
	TextBlockChange textualChange = getTextBlockChange(result.change, clazz);

	String currentContent = textualChange.getCurrentContent(new NullProgressMonitor());
	String previewContent = textualChange.getPreviewContent(new NullProgressMonitor());
	assertFalse("Method must not have been existed before", currentContent.contains("void NewMethod()"));
	assertTrue("New method must have been created", previewContent.contains("void NewMethod()"));
    }

    @Test
    public void testDeleteModelElementNeedsToTriggerTextBlocksDeletion() throws RefactoringCoreException {
	facade = createEditorFacadeForRunletClass("ClassWithEmptyMethod");
	SapClass clazz = (SapClass) facade.getDecoratedDomainRootObject();

	AbstractRefactoringCommand cmd = new DeleteMethodCommand(facade.getEditorConnection(), clazz, "m");
	cmdExecutor = new RefactoringCommandExecutorTestable(facade, cmd);

	RefactoringResult result = cmdExecutor.runRefactoring(new NullProgressMonitor());
	TextBlockChange textualChange = getTextBlockChange(result.change, clazz);

	String currentContent = textualChange.getCurrentContent(new NullProgressMonitor());
	String previewContent = textualChange.getPreviewContent(new NullProgressMonitor());
	assertTrue("Method must exist before", currentContent.contains("void m()"));
	assertFalse("Method must not exist any longer", previewContent.contains("void m()"));
    }

    @Test
    public void testMovedModelElementTakesTextWithIt() throws CoreException, RefactoringCoreException {
	facade = createEditorFacadeForRunletClass("RedefineParameterTst2");
	SapClass sourceClazz = findRunletClass("RedefineParameterTst2");
	SapClass targetClazz = findRunletClass("Class2");

	AbstractRefactoringCommand cmd = new MoveMethodCommand(facade.getEditorConnection(), sourceClazz, targetClazz, "n");
	cmdExecutor = new RefactoringCommandExecutorTestable(facade, cmd);

	// Assert that the model is as we expect it to be
	assertTrue("n".equals(sourceClazz.getOwnedSignatures().iterator().next().getName()));
	assertTrue(targetClazz.getOwnedSignatures().isEmpty());

	RefactoringResult result = cmdExecutor.runRefactoring(new NullProgressMonitor());

	TextBlockChange changeOfClass2 = getTextBlockChange(result.change, targetClazz);
	TextBlockChange changeOfThisToParameterChange = getTextBlockChange(result.change, sourceClazz);

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
     * @throws RefactoringCoreException 
     */
    @Test
    @Ignore // will work ater reparsing of the TB model
    public void testMovedModelElementEvenTakesTextBlockWithIt() throws CoreException, RefactoringCoreException {
	facade = createEditorFacadeForRunletClass("RedefineParameterTst2");
	SapClass sourceClazz = findRunletClass("RedefineParameterTst2");
	SapClass targetClazz = findRunletClass("Class2");

	AbstractRefactoringCommand cmd = new MoveMethodCommand(facade.getEditorConnection(), sourceClazz, targetClazz, "n");
	cmdExecutor = new RefactoringCommandExecutorTestable(facade, cmd);
	
	RefactoringResult result = cmdExecutor.runRefactoring(new NullProgressMonitor());

	TextBlock sourceRootBlock = (TextBlock) TextBlockRefactoringUtil.findCorrespondingTextBlocks(sourceClazz, "Class").iterator().next();
	TextBlock methodTextBlockBefore = sourceRootBlock.getSubBlocks().iterator().next();
	String methodAsStringBefore = TbDebugUtil.getDocumentNodeAsPlainString(methodTextBlockBefore);
	
	result.change.perform(new NullProgressMonitor());
	
	TextBlock targetRootBlock = (TextBlock) TextBlockRefactoringUtil.findCorrespondingTextBlocks(targetClazz, "Class").iterator().next();
	TextBlock methodTextBlockAfter = targetRootBlock.getSubBlocks().iterator().next();
	String methodAsStringAfter = TbDebugUtil.getDocumentNodeAsPlainString(methodTextBlockAfter);
	assertEquals("Method TB must have moved!", methodAsStringBefore, methodAsStringAfter);
	
    }

    /**
     * Makes heavy assumptions on how we compose our changes. Likely to break...
     */
    private TextBlockChange getTextBlockChange(Change compositeChange, RefObject changedRefObject) {
	try {
	    RefactoringStatus status = compositeChange.isValid(new NullProgressMonitor());
	    assertTrue("Change must be valid. Otherwise, this implies that the change operation failed: " + status.toString(), status.isOK());
	} catch (Exception e) {
	    fail(e.getMessage());
	}
	Change[] changes = ((CompositeChange) ((CompositeChange) compositeChange).getChildren()[1]).getChildren();
	for (Change change : changes) {
	    TextBlockChange tbChange = (TextBlockChange) change;
	    if (changedRefObject.equals(tbChange.getModifiedElement())) {
		return tbChange;
	    }
	}
	throw new AssertionError("Unable to find change for " + changedRefObject);
    }

}
