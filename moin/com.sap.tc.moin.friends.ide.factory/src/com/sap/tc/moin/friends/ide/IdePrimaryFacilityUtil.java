package com.sap.tc.moin.friends.ide;

import org.eclipse.core.resources.IProject;

import com.sap.tc.moin.facility.primary.ide.IdePrimaryFacility;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.ClientSpec;


public interface IdePrimaryFacilityUtil {

    /**
     * The <code>ContainerInitializationState</code> reflects which state a
     * potential model container (i.e. a given Eclipse project or a development
     * component) has concerning the initialization inside of MOIN: MOIN could
     * be initialized for the given container. MOIN could be initialized only
     * for the client spec to which the given container belongs. MOIN could be
     * not initialized for the given container. The given container could be not
     * MOIN-relevant.
     */
    enum ContainerInitializationState {

        /**
         * The potential model container is not MOIN relevant, this means it is
         * no model container (example: the project is no DC project or it does
         * not have the respective DC definition parts needed by MOIN
         * (MOIN-attribute, definition of MOIN-relevant folders)).
         */
        NOT_MOIN_RELEVANT,

        /**
         * The model container is MOIN-relevant, but MOIN is not initialized for
         * it, this means the respective client spec and data area are not
         * initialized and the respective management structures for the
         * container management in MOIN are not initialized; this means that all
         * model container in the respective data universe (example: in the
         * respective Development Configuration Import) are invisible for MOIN,
         * but it could made visible by
         * {@link IdePrimaryFacilityUtil#initializeClientSpec(IProject)}.
         */
        NOT_INITIALIZED,

        /**
         * The model container is MOIN-relevant and MOIN is partially
         * initialized for it: the respective client spec and data area are
         * already initialized (the initialization was probably done based on
         * another container), but the respective management structures for the
         * container management in MOIN are not initialized; this means that
         * this model container is still invisible for MOIN, but it could made
         * visible by
         * {@link IdePrimaryFacilityUtil#refreshFromFileSystem(IProject, boolean)}
         * .
         */
        CLIENT_SPEC_ONLY_INITIALIZED,

        /**
         * MOIN is fully initialized for the model container, this means the
         * respective client spec and data area are initialized and the
         * respective management structures for the container management in MOIN
         * are initialized for this container.
         */
        INITIALIZED
    }


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
    IdePrimaryFacilityUtil.ContainerInitializationState getContainerInitializationState( IdePrimaryFacility idePrimaryFacility, IProject eclipseProject );

    /**
     * Test functionality for MIE test utility (required by Galaxy): The method
     * determines the initialization state in MOIN for the given potential model
     * container <code>cri</code> in <code>clientSpec</code>.
     */
    IdePrimaryFacilityUtil.ContainerInitializationState getContainerInitializationState( IdePrimaryFacility idePrimaryFacility, ClientSpec clientSpec, CRI cri );

    /**
     * The method initializes MOIN for the given model container
     * <code>eclipseProject</code> and returns the initialized MOIN client
     * specification.
     * <p>
     * Caution:
     * <p>
     * The method is synchronized and locks the Eclipse workspace. Therefore it
     * should be only used if needed (this can be checked using
     * {@link IdePrimaryFacilityUtil#getContainerInitializationState(IProject)})
     * and it should not be performed in the UI thread. It is not allowed to
     * call this method inside a command (deadlock prevention).
     * 
     * @param eclipseProject An open Eclipse project, must not be null
     * @return The initialized {@link ClientSpec} or <code>null</code> if
     * project is not a MOIN DC project.
     */
    ClientSpec initializeClientSpec( IdePrimaryFacility idePrimaryFacility, IProject eclipseProject );

    /**
     * Repair functionality:
     * <p>
     * The method refreshes the partitions of all development components in the
     * development configuration of the given project
     * <code>eclipseProject</code>.
     * <p>
     */
    void refreshClientSpecFromFileSystem( IdePrimaryFacility idePrimaryFacility, IProject eclipseProject );
}
