package com.sap.tc.moin.friends.ocl.editor;

import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.omg.ocl.attaching.OclConstraint;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;


/**
 * The OCL Editor service
 */
public interface OclEditorService {

    /**
     * Parses the given OCL constraint
     * 
     * @param oc the OCL Constraint
     * @param constraint the constraint to be parsed
     * @param partitions
     * @return the ProcessReport with all errors and warnings occurred during
     * parsing
     * @throws OclManagerException
     */
    public ProcessReport parseOclConstraint( OclConstraint oc, String constraint, Set<ModelPartition> partitions ) throws OclManagerException;

    /**
     * Parses the given OCL constraint
     * 
     * @param oc
     * @param constraint the constraint to be parsed
     * @param partitions
     * @param offset
     * @param length
     * @param isRemove
     * @return the ProcessReport with all errors and warnings occurred during
     * parsing
     * @throws OclManagerException
     */
    public IncrementalProcessReport parseOclConstraint( OclConstraint oc, String constraint, Set<ModelPartition> partitions, int offset, int length, boolean isRemove ) throws OclManagerException;

    /**
     * @param oc
     * @param constraint
     * @param offset
     * @param partitions
     * @return the proposals
     * @throws OclManagerException
     */
    public List<IOclProposal> computeProposals( OclConstraint oc, String constraint, int offset, Set<ModelPartition> partitions ) throws OclManagerException;

    /**
     * @param constraint
     * @return the formatted String
     */
    public String format( String constraint );

    /**
     * @param oc
     * @param constraint
     * @param offset
     * @param partitions
     * @param locale
     * @return the information
     * @throws OclManagerException
     */
    public String getInformationAtOffset( OclConstraint oc, String constraint, int offset, Set<ModelPartition> partitions, Locale locale ) throws OclManagerException;

    /**
     * @param oc
     * @param constraint
     * @param offset
     * @param partitions
     * @return the MRI
     * @throws OclManagerException
     */
    public RegionWrappedMRI getMRIAtOffset( OclConstraint oc, String constraint, int offset, Set<ModelPartition> partitions ) throws OclManagerException;

    /**
     * @param oc
     * @param constraint
     * @param errorOffset
     * @param errorLength
     * @param partitions
     * @return the proposals
     * @throws OclManagerException
     */
    public List<IOclProposal> computeErrorFix( OclConstraint oc, String constraint, int errorOffset, int errorLength, Set<ModelPartition> partitions ) throws OclManagerException;

}
