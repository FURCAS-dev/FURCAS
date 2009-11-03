package com.sap.tc.moin.repository.cdam.ide.internal;

import org.eclipse.core.resources.IProject;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.spi.facility.ide.ContainerInitializationState;


/**
 * Dispatches Eclipse-project related calls to the respective facility. The
 * facility is retrieved from the IProject metadata by evaluating ???
 */
public interface IdeFacilityDispatcherInternal {


    /**
     * The method determines the initialization state in MOIN for the given
     * potential model container <code>eclipseProject</code>.
     * 
     * @param eclipseProject An open Eclipse project, must not be null
     * @return The initialization state of a MOIN project or
     * {@link ContainerInitializationState#NOT_MOIN_RELEVANT} if
     * <code>eclipseProject</code> is not MOIN-relevant.
     * @see ContainerInitializationState
     */
    ContainerInitializationState getContainerInitializationState( IProject eclipseProject );

    /**
     * Test functionality for MIE test utility (required by Galaxy): The method
     * determines the initialization state in MOIN for the given potential model
     * container <code>cri</code> in <code>clientSpec</code>.
     */
    ContainerInitializationState getContainerInitializationState( ClientSpec clientSpec, CRI cri );

    /**
     * Repair functionality:
     * <p>
     * The method refreshes the partitions of all development components in the
     * development configuration of the given project
     * <code>eclipseProject</code>.
     * <p>
     */
    void refreshClientSpecFromFileSystem( IProject eclipseProject );

    /**
     * The method initializes MOIN for the given model container
     * <code>eclipseProject</code> and returns the initialized MOIN client
     * specification.
     * <p>
     * Caution:
     * <p>
     * The method is synchronized and locks the Eclipse workspace. Therefore it
     * should be only used if needed (this can be checked using {@see
     * IdePrimaryFacility#getInitializationState(IProject)}) and it should not
     * be performed in the UI thread. It is not allowed to call this method
     * inside a command (deadlock prevention).
     * 
     * @param eclipseProject An open Eclipse project, must not be null
     * @return The initialized {@link ClientSpec} or <code>null</code> if
     * project is not a MOIN DC project.
     */
    ClientSpec initializeClientSpec( IProject eclipseProject );
}
