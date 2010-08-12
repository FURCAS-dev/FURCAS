package com.sap.ide.refactoring.core.execution.participation;

import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;

import com.sap.ide.refactoring.core.AbstractModelRefactoring;
import com.sap.ide.refactoring.core.execution.RefactoringResult;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;


/**
 * Base class for refactoring execution participants.
 * 
 * Participants listen to events thrown during a refactoring.  Based on these events
 * they may perform certain tasks and contribute their result in form of
 * ContributionInfos, which are incorporated into the overall {@link RefactoringResult}
 * 
 * Additionally, {@link AbstractModelRefactoring}s may inspect contributions
 * in their preValidation step.
 * 
 * @author Stephan Erb (d049157)
 *
 */
public abstract class AbstractCommandExecutionParticipant {

    public static class ParticipantDescriptor {}
    
    protected final RefactoringEditorFacade facade;

    public AbstractCommandExecutionParticipant(RefactoringEditorFacade facade) {
	this.facade = facade;
    }
    
    public abstract void setup(IProgressMonitor pm);

    public abstract Collection<ContributionInfo> contribute(IProgressMonitor pm);
    
    public abstract void teardown(IProgressMonitor pm);

    public abstract ParticipantDescriptor getDescriptor();

    
    
}
