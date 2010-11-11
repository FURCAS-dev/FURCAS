package com.sap.ide.refactoring.core.execution.participation;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;

import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.ide.refactoring.core.textual.TextBlockChange;
import com.sap.ide.refactoring.core.textual.TextBlocksNeedingPrettyPrintChangeListener;
import com.sap.ide.refactoring.core.textual.TextBlocksSynchronizationCommand;
import com.sap.tc.moin.repository.events.filter.ConnectionFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;

/**
 * Participant determining which TextBlocks require pretty printing.
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class TextBlockSynchronizationParticipant extends AbstractCommandExecutionParticipant {

    public static ParticipantDescriptor DESCRIPTOR = new ParticipantDescriptor();
    
    private TextBlocksNeedingPrettyPrintChangeListener textBlockInChangelistener;

    public TextBlockSynchronizationParticipant(RefactoringEditorFacade facade) {
	super(facade);
    }

    @Override
    public void setup(IProgressMonitor pm) {
	pm.beginTask("Preparing TextBlocks Synchronization", 1);
	try {
	    EventFilter filter = new ConnectionFilter(facade.getEditorConnection());
	    textBlockInChangelistener = new TextBlocksNeedingPrettyPrintChangeListener();
	    facade.getEditorConnection().getSession().getEventRegistry().registerListener(textBlockInChangelistener, filter);
	    facade.getEditorConnection().getSession().getEventRegistry().registerPreChangeListener(textBlockInChangelistener, filter);
	} finally {
	    pm.done();
	}
    }

    @Override
    public Collection<ContributionInfo> contribute(IProgressMonitor pm) {
	    TextBlocksSynchronizationCommand prettyPrintCmd = new TextBlocksSynchronizationCommand(
		    facade,
		    textBlockInChangelistener.getTextBlocksNeedingPrettyPrinting(),
		    textBlockInChangelistener.getTextBlocksNeedingShortPrettyPrinting(),
		    pm);
	    prettyPrintCmd.execute();
	    
	    Collection<TextBlockChange> changes = prettyPrintCmd.getTextBlockChanges();
	    CompositeChange change = new CompositeChange("TextBlock Synchronization", changes.toArray(new Change[changes.size()]));
	    change.markAsSynthetic();
	    
	    return Collections.singleton(new ContributionInfo(change, prettyPrintCmd.getSynchronizationStatus()));
    }

    @Override
    public void teardown(IProgressMonitor pm) {
	facade.getEditorConnection().getSession().getEventRegistry().deregister(textBlockInChangelistener);
	textBlockInChangelistener = null;
    }
    
    @Override
    public ParticipantDescriptor getDescriptor() {
	return DESCRIPTOR;
    }

}
