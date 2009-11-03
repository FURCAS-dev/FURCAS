package com.sap.tc.moin.repository.core;

import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.omg.ocl.attaching.OclConstraint;

import com.sap.tc.moin.friends.ocl.editor.IOclProposal;
import com.sap.tc.moin.friends.ocl.editor.IncrementalProcessReport;
import com.sap.tc.moin.friends.ocl.editor.OclEditorService;
import com.sap.tc.moin.friends.ocl.editor.RegionWrappedMRI;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;


/**
 * Used to implement {@link OclEditorService}
 */
public interface CoreOclEditorService {

    /**
     * See {@link OclEditorService}
     * 
     * @param connection connection
     * @param corePartitions partitions
     * @param ocl expression
     * @param constraint constraint
     * @return the report
     * @throws OclManagerException internal
     */
    public ProcessReport parseOclConstraints( CoreConnection connection, Set<CoreModelPartition> corePartitions, OclConstraint ocl, String constraint ) throws OclManagerException;

    /**
     * See {@link OclEditorService}
     * 
     * @param connection connection
     * @param partitions partitions
     * @param oclConstraintImpl constraint
     * @param constraint expression
     * @param offset offset
     * @param length length
     * @param isRemove to be removed
     * @return the report
     * @throws OclManagerException internal
     */
    public IncrementalProcessReport parseOclConstraints( CoreConnection connection, Set<CoreModelPartition> partitions, OclConstraint oclConstraintImpl, String constraint, int offset, int length, boolean isRemove ) throws OclManagerException;

    /**
     * See {@link OclEditorService}
     * 
     * @param connection connection
     * @param partitions partitions
     * @param oclConstraintImpl constraint
     * @param constraint expression
     * @param offset offset
     * @return the report
     * @throws OclManagerException internal
     */
    public List<IOclProposal> computeProposals( CoreConnection connection, Set<CoreModelPartition> partitions, OclConstraint oclConstraintImpl, String constraint, int offset ) throws OclManagerException;

    /**
     * See {@link OclEditorService}
     * 
     * @param constraint the expression
     * @return the formatter expression
     */
    public String format( String constraint );

    /**
     * See {@link OclEditorService}
     * 
     * @param connection connection
     * @param partitions partitions
     * @param oclConstraintImpl constraint
     * @param constraint expression
     * @param offset offset
     * @param locale localization
     * @return the information
     */
    public String getInformationAtOffset( CoreConnection connection, Set<CoreModelPartition> partitions, OclConstraint oclConstraintImpl, String constraint, int offset, Locale locale );

    /**
     * See {@link OclEditorService}
     * 
     * @param connection connection
     * @param partitions partitions
     * @param oclConstraintImpl constraint
     * @param constraint expression
     * @param offset offset
     * @return the MRI
     */
    public RegionWrappedMRI getMRIAtOffset( CoreConnection connection, Set<CoreModelPartition> partitions, OclConstraint oclConstraintImpl, String constraint, int offset );

    /**
     * See {@link OclEditorService}
     * 
     * @param connection connection
     * @param partitions partitions
     * @param oclConstraintImpl constraint
     * @param constraint expression
     * @param errorOffset offset
     * @param errorLength length
     * @return the proposals
     * @throws OclManagerException internal
     */
    public List<IOclProposal> computeErrorFix( CoreConnection connection, Set<CoreModelPartition> partitions, OclConstraint oclConstraintImpl, String constraint, int errorOffset, int errorLength ) throws OclManagerException;
}
