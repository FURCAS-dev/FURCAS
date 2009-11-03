package com.sap.tc.moin.repository.spi.facility.ide;

import org.eclipse.core.resources.IProject;

/**
 * The <code>ContainerInitializationState</code> reflects which state a
 * potential model container (i.e. a given Eclipse project or a development
 * component) has concerning the initialization inside of MOIN: MOIN could
 * be initialized for the given container. MOIN could be initialized only
 * for the client spec to which the given container belongs. MOIN could be
 * not initialized for the given container. The given container could be not
 * MOIN-relevant.
 */
public enum ContainerInitializationState {

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
     * {@link SpiIdeFacility#initializeClientSpec(IProject)}.
     */
    NOT_INITIALIZED,

    /**
     * The model container is MOIN-relevant and MOIN is partially
     * initialized for it: the respective client spec and data area are
     * already initialized (the initialization was probably done based on
     * another container), but the respective management structures for the
     * container management in MOIN are not initialized; this means that
     * this model container is still invisible for MOIN, but it could made
     * visible by {@link refreshFromFileSystem(IProject, boolean)}.
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