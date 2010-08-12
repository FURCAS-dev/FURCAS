package com.sap.ide.refactoring.core.textual;

import java.util.ArrayList;
import java.util.Collection;

import com.sap.ide.refactoring.core.AbstractRefactoringCommand;
import com.sap.ide.refactoring.core.execution.RefactoringCommandExecutor;
import com.sap.ide.refactoring.core.execution.participation.AbstractCommandExecutionParticipant;
import com.sap.ide.refactoring.core.execution.participation.TextBlockSynchronizationParticipant;

public class RefactoringCommandExecutorTestable extends RefactoringCommandExecutor{
    
    public RefactoringCommandExecutorTestable(RefactoringEditorFacade facade, AbstractRefactoringCommand cmd) {
	super(facade, cmd);
    }
    
    @Override
    protected Collection<AbstractCommandExecutionParticipant> createParticipants() {
	Collection<AbstractCommandExecutionParticipant> participants = new ArrayList<AbstractCommandExecutionParticipant>();
	participants.add(new TextBlockSynchronizationParticipant(facade));
	return participants;
    }

}
