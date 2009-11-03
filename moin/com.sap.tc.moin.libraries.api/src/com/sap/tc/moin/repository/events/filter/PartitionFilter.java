package com.sap.tc.moin.repository.events.filter;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;

/**
 * The PartitionFilter will be used to notify about modifications of a partition. Clients will use this filter in order to get
 * PartitionChangedEvents like the <code>PartitionContentChangedEvent</code>. Unlike the PartitionMembershipFilter,
 * only PartitionEvents are affected. The partition is specified by using its {@link PRI} as filter criterion.
 * 
 * @author Daniel Vocke (D044825)
 */
public class PartitionFilter extends EventFilter {

    /**
     * @param filterCriterion The {@link PRI} of the partition that shall be observed.
     */

    public PartitionFilter( ModelPartition filterCriterion ) {

        super( filterCriterion.getPri( ) );
    }

    /**
     * @param filterCriterion The {@link PRI} of the partition that shall be observed.
     */

    public PartitionFilter( PRI filterCriterion ) {

        super( filterCriterion );
    }

}