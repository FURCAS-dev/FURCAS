package com.sap.ide.refactoring.core.execution.participation;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;

import com.sap.ide.refactoring.core.reference.CompressingReEvaluationLog;
import com.sap.ide.refactoring.core.reference.ReEvaluationInfo;
import com.sap.ide.refactoring.core.reference.ReEvaluationLogger;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.mi.textual.parsing.textblocks.reference.GlobalDelayedReferenceResolver;

/**
 * Participant observing which references are re-evaluated by the {@link GlobalDelayedReferenceResolver}
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class ReferenceReEvaluationObservingParticipant extends AbstractCommandExecutionParticipant {

    public static ParticipantDescriptor DESCRIPTOR = new ParticipantDescriptor();
    private ReEvaluationLogger reevaluationListener;
    private CompressingReEvaluationLog log;
    
    public ReferenceReEvaluationObservingParticipant(RefactoringEditorFacade facade) {
	super(facade);
    }

    @Override
    public void setup(IProgressMonitor pm) {
	log = new CompressingReEvaluationLog();
	reevaluationListener = new ReEvaluationLogger(log);
	GlobalDelayedReferenceResolver.getInstance().addReferenceResolvingListener(reevaluationListener);
    }

    @Override
    public Collection<ContributionInfo> contribute(IProgressMonitor pm) {
	Collection<ContributionInfo> contributions = new ArrayList<ContributionInfo>();

	for (ReEvaluationInfo reEvalInfo : log.getLoggedReEvaluations()) {
	    contributions.add(new ReferenceReEvalContributionInfo(reEvalInfo));
	}
	return contributions;
    }

    @Override
    public void teardown(IProgressMonitor pm) {
	GlobalDelayedReferenceResolver.getInstance().removeReferenceResolvingListener(reevaluationListener);
	this.reevaluationListener = null;
	this.log = null;
    }
    
    @Override
    public ParticipantDescriptor getDescriptor() {
	return DESCRIPTOR;
    }

}
