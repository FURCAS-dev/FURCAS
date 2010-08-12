package com.sap.ide.refactoring.core.execution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.junit.Test;

import com.sap.ide.refactoring.core.AbstractRefactoringCommand;
import com.sap.ide.refactoring.core.execution.participation.ContributionMap;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.ide.refactoring.test.RefactoringBaseTest;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class TestRefactoringCommandExecutor extends RefactoringBaseTest {

    private static class PassingNullRefactoring extends AbstractRefactoringCommand {

	protected PassingNullRefactoring(Connection connection, String description) {
	    super(connection, description);
	}

	@Override
	protected void performRefactoring(IProgressMonitor pm) {

	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
	    return Collections.emptyList();
	}
    }

    private static class FailingNullRefactoring extends PassingNullRefactoring {

	protected FailingNullRefactoring(Connection connection, String description) {
	    super(connection, description);
	}

	@Override
	public RefactoringStatus postValidate(ContributionMap contributions, IProgressMonitor pm) {
	    return RefactoringStatus.createFatalErrorStatus("Intended Fail");
	}
    }

    private static class CrashingNullRefactoring extends PassingNullRefactoring {

	protected CrashingNullRefactoring(Connection connection, String description) {
	    super(connection, description);
	}

	@Override
	protected void performRefactoring(IProgressMonitor pm) {
	    throw new RuntimeException("Huups I Crashed (but on purpose, so don't worry!)");
	}
    }

    /**
     * System under test
     */
    private RefactoringCommandExecutor sut;
    private RefactoringEditorFacade facade;

    @Test
    public void testExecutionOfPassingRefactoring() throws Exception {
	facade = createEditorFacadeForRunletClass("Class1");
	AbstractRefactoringCommand cmd = new PassingNullRefactoring(connection, "Passing");
	sut = new RefactoringCommandExecutor(facade, cmd);

	RefactoringResult result = sut.runRefactoring(new NullProgressMonitor());

	assertTrue("Must have passed without errors", result.status.isOK());
	assertTrue("Change must be applicable", result.change.isValid(new NullProgressMonitor()).isOK());
	assertEquals(cmd.getDescription(), result.refactoringCommandHandle.getDescription());
    }

    @Test
    public void testExecutionOfFailingRefactoring() throws Exception {
	facade = createEditorFacadeForRunletClass("Class1");
	AbstractRefactoringCommand cmd = new FailingNullRefactoring(connection ,"Failing");
	sut = new RefactoringCommandExecutor(facade, cmd);

	RefactoringResult result = sut.runRefactoring(new NullProgressMonitor());

	assertFalse("Must have failed", result.status.isOK());
	assertFalse("Change must be applicable", result.change.isValid(new NullProgressMonitor()).isOK());
	assertEquals(cmd.getDescription(), result.refactoringCommandHandle.getDescription());
    }

    @Test
    public void testExecutionOfCrashingRefactoring() throws Exception {
	facade = createEditorFacadeForRunletClass("Class1");
	AbstractRefactoringCommand cmd = new CrashingNullRefactoring(connection ,"Failing");
	sut = new RefactoringCommandExecutor(facade, cmd);

	RefactoringResult result = sut.runRefactoring(new NullProgressMonitor());

	assertFalse("Must have failed", result.status.isOK());
	assertFalse("Change must not be applicable", result.change.isValid(new NullProgressMonitor()).isOK());
    }
}
