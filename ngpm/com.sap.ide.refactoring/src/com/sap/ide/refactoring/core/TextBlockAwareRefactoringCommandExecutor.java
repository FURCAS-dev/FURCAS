package com.sap.ide.refactoring.core;


import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import com.sap.ide.refactoring.Activator;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.ide.refactoring.core.textual.TextBlockInChangeCalculator;
import com.sap.ide.refactoring.core.textual.TextBlocksNeedingPrettyPrintChangeListener;
import com.sap.ide.refactoring.core.textual.TextBlocksSynchronizationCommand;
import com.sap.mi.textual.parsing.textblocks.TbValidationUtil;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.events.filter.ConnectionFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;

/**
 * Class used to execute {@link AbstractRefactoringCommand}s, while making sure that TextBlocks are
 * updated accordingly (for that, see {@link TextBlocksSynchronizationCommand},
 * {@link TextBlocksNeedingPrettyPrintChangeListener} and {@link TextBlockInChangeCalculator} 
 * 
 * @author D049157
 *
 */
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
    public RefactoringResult runRefactoring(IProgressMonitor pm) {
	pm.beginTask("Running refactoring: " + refactoringCommand.getDescription(), 20);
	System.out.println("-- Enter preview routine");
	
	// pre refactoring check
	TbValidationUtil.assertTextBlockConsistencyRecursive(facade.getTextBlocksModel().getRoot());
	setupModelElementChangeListener();
	RefactoringResult result = runRefactoringInternal(refactoringCommand, pm);
	tearDownModelElementChangeListener();
	// post refactoring check with the refactoring still applied
	TbValidationUtil.assertTextBlockConsistencyRecursive(facade.getTextBlocksModel().getRoot());
	
	if (result.refactoringCommandHandle != null) {
	    // command could be executed; undo it
	    CommandUndoRedoHelper helper = new CommandUndoRedoHelper(facade.getConnection());
	    helper.undoRefactoring(result.refactoringCommandHandle);
	}
	// post undo check. State should be as it were before the refactoring (pre state)
	TbValidationUtil.assertTextBlockConsistencyRecursive(facade.getTextBlocksModel().getRoot());
	
	pm.done();
	System.out.println("-- Exit preview routine");
	return result;
    }

    private RefactoringResult runRefactoringInternal(AbstractRefactoringCommand cmd, IProgressMonitor pm) {
	System.out.println("   Run refactoring: " + cmd.getDescription());
	CommandUndoRedoHelper helper = new CommandUndoRedoHelper(facade.getConnection());
	RefactoringResult result = null;
	RefactoringStatus status = new RefactoringStatus();
	try {
	    // REFACTORING START: run several commands
	    status.merge(cmd.preValidate());
	    pm.worked(1);
	    CommandHandle refactoringCmdHandle = cmd.execute();
	    pm.worked(10);
	    status.merge(cmd.postValidate());
	    pm.worked(1);
	    
	    // Synchronously, directly after the refactoring several update/change handlers perform their
	    // work. This includes delayed reference resolving.
	    
	    TbValidationUtil.assertTextBlockConsistencyRecursive(facade.getTextBlocksModel().getRoot());

	    TextBlocksSynchronizationCommand prettyPrintCmd = new TextBlocksSynchronizationCommand(facade.getConnection(),
		    listener.getTextBlocksNeedingPrettyPrinting(), listener.getTextBlocksNeedingShortPrettyPrinting());
	    prettyPrintCmd.execute();
	    pm.worked(4);
	    
	    TbValidationUtil.assertTextBlockConsistencyRecursive(facade.getTextBlocksModel().getRoot());


	    // REFACTORING ENDED: last command run
	    CommandHandle dependentCommandHandle =  helper.peekUndoStack(); //captures the handle of the last of these commands

	    Change change = createChange(status, refactoringCmdHandle, dependentCommandHandle, prettyPrintCmd.getTextBlockChanges());
	    result = new RefactoringResult(refactoringCmdHandle, change, status);
	} catch (RefactoringCoreException e) {
	    result = new RefactoringResult(e.asRefactoringStatus());
	} catch (Exception e) {
	    Activator.logError(e);
	    status.merge(RefactoringStatus.createFatalErrorStatus("Failed to execute " + cmd.getDescription() + ": " + e.getMessage()));
	    result = new RefactoringResult(status);
	}
	return result;
    }

     /**
      * Create a change
      *
      * @param refactoringCommandHandle  The executed refactoring.
      * @param dependentCommandHandle  The newest command directly or indirectly triggered by the command
      * (e.g. reference re-evaluations)
     * @param collection
      * @return
      */
    private Change createChange(RefactoringStatus status, CommandHandle refactoringCommandHandle, CommandHandle dependentCommandHandle, Collection<? extends Change> textBlockChanges) {
	CompositeChange change = new CompositeChange(refactoringCommandHandle.getDescription());
	change.add(new ModelChange(facade, status, refactoringCommandHandle, dependentCommandHandle));
	change.addAll(textBlockChanges.toArray(new Change[textBlockChanges.size()]));
	return change;
    }

    private void setupModelElementChangeListener() {
	EventFilter filter = new ConnectionFilter(facade.getConnection());
	listener = new TextBlocksNeedingPrettyPrintChangeListener();
	facade.getConnection().getSession().getEventRegistry().registerListener(listener, filter);
	facade.getConnection().getSession().getEventRegistry().registerPreChangeListener(listener, filter);
    }

    private void tearDownModelElementChangeListener() {
	facade.getConnection().getSession().getEventRegistry().deregister(listener);
	listener = null;
    }






}
