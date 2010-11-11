package com.sap.ide.refactoring.core.execution.participation;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;

import com.sap.ide.refactoring.core.constraints.ConstraintViolation;
import com.sap.ide.refactoring.core.constraints.MetaModelConstraintRegistry;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;

/**
 * Participant evaluationg metamodel constraints.
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class MetaModelConstraintCheckingParticipant extends AbstractCommandExecutionParticipant {

    public static ParticipantDescriptor DESCRIPTOR = new ParticipantDescriptor();
    
    private MetaModelConstraintRegistry metaModelConstraintsRegistry;
    
    public MetaModelConstraintCheckingParticipant(RefactoringEditorFacade facade) {
	super(facade);
    }

    @Override
    public void setup(IProgressMonitor pm) {
	metaModelConstraintsRegistry = new MetaModelConstraintRegistry(facade.getEditorConnection());
	metaModelConstraintsRegistry.registerAllMetaModelConstraintsForIncrementalEvaluation(pm);
    }

    @Override
    public Collection<ContributionInfo> contribute(IProgressMonitor pm) {
	Collection<ContributionInfo> contributions = new ArrayList<ContributionInfo>();
	
	Collection<ConstraintViolation> violations = metaModelConstraintsRegistry.evaluateConstraints(pm);
	for (ConstraintViolation violation : violations) {
	    contributions.add(new ContributionInfo(violation.asRefactoringStatus()));
	}
	return contributions;
    }

    @Override
    public void teardown(IProgressMonitor pm) {
	metaModelConstraintsRegistry.deregisterRegisteredMetaModelConstraintListeners(pm);
	metaModelConstraintsRegistry = null;
    }

    @Override
    public ParticipantDescriptor getDescriptor() {
	return DESCRIPTOR;
    }

}
