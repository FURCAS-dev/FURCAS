package com.sap.ide.refactoring.core.execution;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.NullChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import com.sap.ide.refactoring.Activator;
import com.sap.ide.refactoring.core.AbstractRefactoringCommand;
import com.sap.ide.refactoring.core.RefactoringCoreException;
import com.sap.ide.refactoring.core.execution.participation.AbstractCommandExecutionParticipant;
import com.sap.ide.refactoring.core.execution.participation.AbstractCommandExecutionParticipant.ParticipantDescriptor;
import com.sap.ide.refactoring.core.execution.participation.ContributionInfo;
import com.sap.ide.refactoring.core.execution.participation.ContributionMap;
import com.sap.ide.refactoring.core.execution.participation.MetaModelConstraintCheckingParticipant;
import com.sap.ide.refactoring.core.execution.participation.ReferenceReEvaluationObservingParticipant;
import com.sap.ide.refactoring.core.execution.participation.TextBlockSynchronizationParticipant;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.ide.refactoring.core.textual.TextBlockInChangeCalculator;
import com.sap.ide.refactoring.core.textual.TextBlocksNeedingPrettyPrintChangeListener;
import com.sap.ide.refactoring.core.textual.TextBlocksSynchronizationCommand;
import com.sap.ide.refactoring.ui.NamedSubProgressMonitor;
import com.sap.mi.textual.parsing.textblocks.TbValidationUtil;
import com.sap.tc.moin.repository.commands.CommandHandle;

/**
 * Class used to execute {@link AbstractRefactoringCommand}s, while making sure that TextBlocks are
 * updated accordingly (for that, see {@link TextBlocksSynchronizationCommand},
 * {@link TextBlocksNeedingPrettyPrintChangeListener} and {@link TextBlockInChangeCalculator} 
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class RefactoringCommandExecutor {

    protected final RefactoringEditorFacade facade;
    private final AbstractRefactoringCommand refactoringCommand;
    private final Collection<AbstractCommandExecutionParticipant> participants;

    public RefactoringCommandExecutor(RefactoringEditorFacade facade, AbstractRefactoringCommand cmd) {
	this.facade = facade;
	this.refactoringCommand = cmd;
	
	this.participants = createParticipants();
    }

    /**
     * Run the refactoring.
     *
     * @return A change object describing the performed changes.
     * The workspace remains unchanged until {@link Change#perform} is called.
     * @throws RefactoringCoreException 
     */
    public RefactoringResult runRefactoring(IProgressMonitor pm) throws RefactoringCoreException {
	pm.beginTask("Refactoring: ", 100);
	try {
	    setupExecutionParticipants(new NamedSubProgressMonitor(pm, 10));
	    RefactoringResult result = runRefactoringInternal(refactoringCommand, pm);
	    tearDownExecutionParticipants(new NamedSubProgressMonitor(pm, 5));

	    undoRefactoring(result, new NamedSubProgressMonitor(pm, 10));
	    return result;
	} finally {
	    pm.done();
	}
    }

    private RefactoringResult runRefactoringInternal(AbstractRefactoringCommand cmd, IProgressMonitor pm) {
	CommandUndoRedoHelper helper = new CommandUndoRedoHelper(facade.getEditorConnection());
	RefactoringResult result = null;
	RefactoringStatus status = new RefactoringStatus();
	try {
	    status.merge(cmd.preValidate(new NamedSubProgressMonitor(pm, 5)));
	    cmd.setExecutionProgressMonitor(new NamedSubProgressMonitor(pm, 25));
	    CommandHandle refactoringCmdHandle = cmd.execute();
	    // here (synchronously, directly after the refactoring) several update/change handlers perform their
	    // work. This includes delayed reference resolving.

	    ContributionMap contributions = letParticipantsContribute(new SubProgressMonitor(pm, 40));
	    status.merge(cmd.postValidate(contributions, new NamedSubProgressMonitor(pm, 5)));
	    
	    CommandHandle dependentCommandHandle =  helper.peekUndoStack(); //captures the handle of the last of these commands
	    Change change = createCollectiveCompositeChange(status, refactoringCmdHandle, dependentCommandHandle, contributions);
	    result = RefactoringResult.createResult(refactoringCmdHandle, change, status);
	} catch (Exception e) {
	    Activator.logError(e, "Refactoring exeuction failed " + cmd.getDescription() );
	    status.merge(RefactoringStatus.createFatalErrorStatus("Failed to execute " + cmd.getDescription() + ": " + e.getMessage()));
	    result = RefactoringResult.createFailingResult(status);
	}
	return result;
    }

     /**
      * Create a change
      *
      * @param refactoringCommandHandle  The executed refactoring.
      * @param dependentCommandHandle  The newest command directly or indirectly triggered by the command
      * (e.g. reference re-evaluations)
      * @param contributions
      * @return
      */
    private Change createCollectiveCompositeChange(RefactoringStatus status, CommandHandle refactoringCommandHandle, CommandHandle dependentCommandHandle, ContributionMap contributions) {
	CompositeChange change = new CompositeChange(refactoringCommandHandle.getDescription());
	change.markAsSynthetic();
	change.add(new ModelChange(facade, status, refactoringCommandHandle, dependentCommandHandle));
	
	for (ContributionInfo contributionInfo : contributions.getAllContributions()) {
	    status.merge(contributionInfo.status);
	    // NullChanged become an empty UI entry. Prevent that.
	    if (! (contributionInfo.change instanceof NullChange)) {
		change.add(contributionInfo.change);
	    }
	}
	return change;
    }
    
    private void undoRefactoring(RefactoringResult result, IProgressMonitor pm) throws RefactoringCoreException {
	if (result.refactoringCommandHandle != null) {
	    // command could be executed; undo it
	    CommandUndoRedoHelper helper = new CommandUndoRedoHelper(facade.getEditorConnection());
	    helper.undoRefactoring(result.refactoringCommandHandle, pm);
	}
	// post undo check. State should be as it were before the refactoring (pre state)
	TbValidationUtil.assertTextBlockConsistencyRecursive(facade.getTextBlocksModel().getRoot());
    }
    
    /**
     * Can be overwritten in tests if the executor shall run without participants,
     * or if a refactoring requires a specific set of participants.
     */
    protected Collection<AbstractCommandExecutionParticipant> createParticipants() {
	Collection<AbstractCommandExecutionParticipant> participants = new ArrayList<AbstractCommandExecutionParticipant>();
	
	participants.add(new TextBlockSynchronizationParticipant(facade));
	participants.add(new MetaModelConstraintCheckingParticipant(facade));
	participants.add(new ReferenceReEvaluationObservingParticipant(facade));
	
	return participants;
    }
    
    private void setupExecutionParticipants(IProgressMonitor pm) {
	for (AbstractCommandExecutionParticipant participant : participants) {
	    try {
		participant.setup(new NamedSubProgressMonitor(pm, 1));
	    } catch (Exception e) {
		Activator.logError(e, "Participant setup failed");
	    }
	}
	pm.done();
    }
    
    private ContributionMap letParticipantsContribute(IProgressMonitor pm) {
	pm.beginTask("", participants.size());
	Map<ParticipantDescriptor, Collection<ContributionInfo>> results = new HashMap<ParticipantDescriptor, Collection<ContributionInfo>>();
	for (AbstractCommandExecutionParticipant participant : participants) {
	    try {
		results.put(participant.getDescriptor(), participant.contribute(new NamedSubProgressMonitor(pm, 1)));
	    } catch (Exception e) {
		Activator.logError(e, "Participant setup failed");
	    }
	}
	pm.done();
	return new ContributionMap(results);
    }
    
    private void tearDownExecutionParticipants(IProgressMonitor pm) {
	for (AbstractCommandExecutionParticipant participant : participants) {
	    try {
		participant.teardown(new NamedSubProgressMonitor(pm, 1));
	    } catch (Exception e) {
		Activator.logError(e, "Participant teardown failed");
	    }
	}
	pm.done();
    }
 
}
