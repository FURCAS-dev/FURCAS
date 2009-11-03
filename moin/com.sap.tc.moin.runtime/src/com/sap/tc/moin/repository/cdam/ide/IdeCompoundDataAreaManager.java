package com.sap.tc.moin.repository.cdam.ide;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.sap.tc.moin.facility.primary.ide.IdePrimaryFacility;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.cdam.CompoundDataAreaManager;
import com.sap.tc.moin.repository.commands.PartitionOperation;

/**
 * The IDE {@link CompoundDataAreaManager}. <br>
 * <br>
 * The <code>@Deprecated</code> methods are currently under discussion and are
 * intended to be used by MIE/BI only!
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IdeCompoundDataAreaManager extends CompoundDataAreaManager {

    /**
     * @param project
     * @return a {@link CompoundClientSpec} for an IDE project
     */
    CompoundClientSpec getCompoundClientSpec( IProject project );

    /**
     * @param clientSpec
     * @return the {@link CompoundClientSpec} for a given {@link ClientSpec}
     */
    CompoundClientSpec getDefaultCompoundClientSpec( ClientSpec clientSpec );

    /**
     * The methods creates a partition resource identifier for the partition
     * with the given <code>partitionPath</code> in the given
     * <code>project</code>.
     * <p>
     * 
     * @param project The Eclipse project of the model container of the
     * partition, must not be <code>null</code>
     * @param partitionPath The relative path from the project root to the
     * partition file. It must start with the resource folder where the
     * partition is located. This is restricted to folder 'src/' currently, must
     * not be <code>null</code>
     * @return The {@link PRI} of a partition within the model container
     * represented by the given project.
     * @throws IllegalStateException if the Eclipse project is not a MOIN DC or
     * not initialized.
     * @see PRI#createMri(String) Creates a MRI for a model element located in a
     * partition of a given project.
     */
    @Deprecated
    PRI createPri( IProject project, String partitionPath );


    /**
     * The method returns the MOIN client-specification for the given model
     * container <code>eclipseProject</code>. If MOIN is not yet initialized for
     * this model container then <code>null</code> is returned.
     * 
     * @param eclipseProject An open Eclipse project, must not be null
     * @return The initialized {@link ClientSpec} for the model container or
     * <code>null</code> if project is not initialized or not MOIN relevant.
     */
    @Deprecated
    ClientSpec getClientSpec( IProject eclipseProject );

    /**
     * The method returns the Eclipse project for the given model container
     * identifier <code>cri</code>.
     * <p>
     * 
     * @param cri The identifier of the container, must not be null
     * @return <code>null</code> in case the model container does not exist, is
     * transient or it is not yet initialized for MOIN and in case the project
     * does not exist (e.g. it was deleted in the meanwhile) or it is closed.
     * @see CRI#isVolatileContainer()
     */
    @Deprecated
    IProject getProject( CRI cri );

    /**
     * Retrieve the model container identifier for the given Eclipse project
     * <code>project</code>.
     * 
     * @param project An open Eclipse project, must not be null
     * @return The model container identifier {@link CRI} for the given Eclipse
     * project <code>project</code>. In case the Eclipse project is not
     * MOIN-relevant or not yet initialized for MOIN the method returns
     * <code>null</code>.
     */
    @Deprecated
    CRI getContainer( IProject project );

    /**
     * The method refreshes the partitions of the given <code>project</code> in
     * the MOIN Index and in the MOIN internal state according to the partitions
     * located in this project on file system, i.e. the respective MOIN project
     * is refreshed for all MOIN clients.
     * <p>
     * If <code>forced</code> is false, then only the changed partitions are
     * updated. Those partitions are determined based on a timestamp comparison
     * which can lead to rare cases where changes (which did not cause a
     * timestamp-change on file system) are not detected so that the respective
     * partition is not updated in Index. In case <code>forced</code> is true,
     * then the timestamp is not considered, but all partitions are updated in
     * MOIN Index.
     * <p>
     * Remarks:
     * <p>
     * The caller of this method is responsible for the handling of dirty
     * partitions, i.e. it should provide a possibility that the user can save
     * the dirty partitions of the respective project for all open connections.
     * During this method the affected partitions are evicted from the internal
     * caches related to all connections regardless if they are dirty or not.
     * <p>
     * Caution:
     * <p>
     * The method is synchronized and locks the Eclipse project. Therefore it
     * should be only used if needed (this can be checked using
     * {@link IdePrimaryFacility#getInitializationState(IProject)}) and it
     * should not be performed in the UI thread. It is not allowed to call this
     * method inside a command (deadlock prevention).
     * 
     * @param project An Eclipse project, must not be null
     * @param forced If <code>false</code> only changed partitions are updated.
     * <code>true</code> forces a complete refresh of all partitions.
     */
    @Deprecated
    void refreshFromFileSystem( IProject project, boolean forced );

    /**
     * The method returns the Eclipse File object which corresponds to the given
     * <code>PRI</code>. If the respective File object cannot be retrieved (e.g.
     * in case the Eclipse project hosting the respective partition, then
     * <code>null</code> is returned.
     * 
     * @param pri The identifier of the partition, must not be null
     * @return <code>null</code> if the partition does not exist or the project
     * is not MOIN relevant or closed.
     */
    @Deprecated
    IFile getFile( PRI pri );

    /**
     * The method prepares the partition modifications described in
     * <code>affectedPartitions</code> concerning Scenario 3 life cycle
     * management. This means that the operations described in
     * <code>affectedPartitions</code> are mapped to the respective versioning
     * operations. These operations are presented to the user in a dialog, so
     * that she can decide if the versioning operations should be performed. If
     * yes then the versioning operations are performed and the result of those
     * operations is returned.
     * <p>
     * The intended result of this preparation is that the respective partitions
     * have the state on local disc and in the underlying versioning system
     * (DTR) which allows MOIN to perform the intended change.
     * <p>
     * Example:
     * <p>
     * A partition which should be changed is checked-out-for-edit. The result
     * of this preparation should be that the respective partition is writable
     * on local disc and that it has the versioning state checked-out-for-edit
     * for the respective user and DTR client in DTR.
     * <p>
     * Caution:
     * <p>
     * The underlying life cycle management library performs a switch to the UI
     * thread and it might require respective locks needed to perform the
     * versioning operations.
     * </p>
     * 
     * @param affectedPartitions Must not be null
     * @return {@link Status#OK_STATUS} if preparation succeeded or a
     * {@link Status} with severity {@link IStatus#CANCEL} otherwise.
     */
    @Deprecated
    IStatus prepareModification( Collection<PartitionOperation> affectedPartitions );

    /**
     * The method prepares changing MOIN model partitions in a given project
     * where the affected partitions are not known. This is e.g. the case when
     * the getAffectedPartitions method of a command returns null. The changes
     * can include partition modifications and partition deletions. The method
     * performs repository operations for all model partitions in project to
     * ensure that the desired model change can be performed. In case of DTR
     * EDIT_EXCLUSIVE operations are performed to ensure that deletions are
     * possible on save.
     * <p>
     * Caution:
     * <p>
     * The underlying life cycle management library performs a switch to the UI
     * thread and it might require respective locks needed to perform the
     * versioning operations.
     * </p>
     * 
     * @param project The project where partitions are to be changed, must not
     * be null
     * @return {@link Status#OK_STATUS} if preparation succeeded or a
     * {@link Status} with severity {@link IStatus#CANCEL} otherwise.
     */
    @Deprecated
    IStatus prepareModificationInProject( IProject project );
    
    @Deprecated
    IStatus prepareModificationHeadless( Collection<PartitionOperation> affectedPartitions);

    @Deprecated
    IStatus prepareModificationInProjectHeadless( IProject project );
    

}