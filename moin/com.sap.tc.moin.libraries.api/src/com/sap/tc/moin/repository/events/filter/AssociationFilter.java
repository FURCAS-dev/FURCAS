package com.sap.tc.moin.repository.events.filter;

import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;

/**
 * Using association filters will reduce the set of delivered events to LinkChangedEvents of the specified 
 * Association type. 
 * Indeed refinement of associations is supported by MOF, but the event framework will ignore this exotic case.
 * 
 * @see com.sap.tc.moin.repository.events.filter.EventFilter
 * @author Daniel Vocke (D044825)
 */
public class AssociationFilter extends EventFilter {

    /**
     * @param filterCriterion The filterCriterion of type {@link Association} defines the metatype of the observed link.
     */
    public AssociationFilter( Association filterCriterion ) {

        super( filterCriterion );
    }

    /**
     * @param associationMri The associationMri defines the metatype of the observed link.
     */
    public AssociationFilter( MRI associationMri ) {

        super( associationMri );
    }

    /**
     * @param filterCriteria a collection of filter criteria
     */
    public AssociationFilter( Set<LRI> filterCriteria ) {

        super( filterCriteria );
    }

}