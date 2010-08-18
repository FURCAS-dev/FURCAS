package com.sap.ide.refactoring.core;


import java.util.Collection;

import javax.xml.stream.EventFilter;

import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.ide.refactoring.core.textual.TextBlocksNeedingPrettyPrintChangeListener;
import com.sap.ide.refactoring.core.textual.UpdateTextBlocksCommand;

public class TextBlockAwareRefactoringCommandExecutor {

    private final RefactoringEditorFacade facade;
    private final AbstractRefactoringCommand refactoringCommand;
    private TextBlocksNeedingPrettyPrintChangeListener listener;

    public TextBlockAwareRefactoringCommandExecutor(RefactoringEditorFacade facade, AbstractRefactoringCommand cmd) {
	this.facade = facade;
	this.refactoringCommand = cmd;
    }

    /**
     * Run the refactoring.
     *
     * @return A change object describing the performed changes.
     * The workspace remains unchanged until {@link Change#perform} is called.
     */
    public RefactoringResult runRefactoring() {
	System.out.println("-- Enter preview routine");
	setupModelElementChangeListener();
	RefactoringResult result = runRefactoringInternal(refactoringCommand);
	tearDownModelElementChangeListener();
	if (result.refactoringCommandHandle != null) {
	    // command could be executed; undo it
	    CommandUndoRedoHelper helper = new CommandUndoRedoHelper(facade.getConnection());
	    helper.undoRefactoring(result.refactoringCommandHandle);
	}
	System.out.println("-- Exit preview routine");
	return result;
    }

    private RefactoringResult runRefactoringInternal(AbstractRefactoringCommand cmd) {
	System.out.println("   Run refactoring: " + cmd.getDescription());
	CommandUndoRedoHelper helper = new CommandUndoRedoHelper(facade.getConnection());
	RefactoringResult result = null;
	RefactoringStatus status = new RefactoringStatus();
	try {
	    // REFACTORING START: run several commands
	    status.merge(cmd.preValidate());
	    CommandHandle refactoringCmdHandle = cmd.execute();
	    status.merge(cmd.postValidate());
	    // Synchronously, directly after the refactoring several update/change handlers perform their
	    // work. This includes delayed reference resolving.

	    UpdateTextBlocksCommand prettyPrintCmd = new UpdateTextBlocksCommand(facade.getConnection(),
		    listener.getTextBlocksNeedingPrettyPrinting(), listener.getTextBlocksNeedingShortPrettyPrinting());
	    prettyPrintCmd.execute();

	    // REFACTORING ENDED: last command run
	    CommandHandle dependentCommandHandle =  helper.peekUndoStack(); //captures the handle of the last of these commands

	    Change change = createChange(status, refactoringCmdHandle, dependentCommandHandle, prettyPrintCmd.getTextBlockChanges());
	    result = new RefactoringResult(refactoringCmdHandle, change, status);
	} catch (RefactoringCoreException e) {
	    result = new RefactoringResult(e.asRefactoringStatus());
	} catch (Exception e) {
	    e.printStackTrace();
	    status.merge(RefactoringStatus.createFatalErrorStatus("Failed to execute " + cmd.getDescription() + ": " + e.getMessage()));
	    result = new RefactoringResult(status);
	}
	return result;
    }

     /**
      * Create a change
      *
      * @param refactoringCommandHandle  The executed refactoring.
      * @param dependentCommandHandle  The newest command directly or inderictly triggered by the command
      * (e.g. reference re-evaluations)
     * @param collection
      * @return
      */
    private Change createChange(RefactoringStatus status, CommandHandle refactoringCommandHandle, CommandHandle dependentCommandHandle, Collection<Change> textBlockChanges) {
	CompositeChange change = new CompositeChange(refactoringCommandHandle.getDescription());
	change.add(new ModelChange(facade, status, refactoringCommandHandle, dependentCommandHandle));
	change.addAll(textBlockChanges.toArray(new Change[textBlockChanges.size()]));
	return change;
    }

    private void setupModelElementChangeListener() {
	EventFilter filter = new ConnectionFilter(facade.getConnection());

	listener = new TextBlocksNeedingPrettyPrintChangeListener();
	facade.getConnection().getSession().getEventRegistry().registerListener(listener, filter);
    }

    private void tearDownModelElementChangeListener() {
	facade.getConnection().getSession().getEventRegistry().deregister(listener);
	listener = null;
    }






}
