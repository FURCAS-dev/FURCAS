package com.sap.ide.refactoring.core.execution.participation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import com.sap.ide.refactoring.core.execution.participation.AbstractCommandExecutionParticipant.ParticipantDescriptor;

/**
 * Container class used to collect contributions.
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class ContributionMap {

    private final Map<ParticipantDescriptor, Collection<ContributionInfo>> contributions;

    public ContributionMap(Map<ParticipantDescriptor, Collection<ContributionInfo>> contributions) {
	this.contributions = contributions;
    }
    
    /**
     * The map can be queried with the {@link ParticipantDescriptor}s of the individual
     * refactoring participants. 
     */
    public Collection<ContributionInfo> getContributionsOfParticipant(ParticipantDescriptor descriptor) {
	if (contributions.containsKey(descriptor)) {
	    return contributions.get(descriptor);
	} else {
	    return Collections.emptyList();
	}
    }
    
    public Collection<ContributionInfo> getAllContributions() {
	Collection<ContributionInfo> flattenedContributions = new ArrayList<ContributionInfo>();
	
	for (Collection<ContributionInfo> values : contributions.values()) {
	    flattenedContributions.addAll(values);
	}
	return flattenedContributions;
    }
   
}
