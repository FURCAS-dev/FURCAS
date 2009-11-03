package com.sap.tc.moin.friends.ocl;

import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.ProcessReport;

/**
 * Activates the OCL constraints of a metamodel
 */
public interface OclActivator {

    /**
     * Searches for OclConstraints in a Set of ModelPartitions and parses them
     * <p>
     * The parsing result is added to the respective constraint's partition
     * 
     * @param partitions the partitions to handle
     * @return a Map that maps ProcessReports describing problems encountered
     * during parsing to the MRI of the constraint that could not be parsed (may
     * be empty)
     * @throws RuntimeException if a fatal parsing problem is encountered
     */
    public Map<ProcessReport, MRI> parseOclConstraintsInPartitions( Set<ModelPartition> partitions );

}
