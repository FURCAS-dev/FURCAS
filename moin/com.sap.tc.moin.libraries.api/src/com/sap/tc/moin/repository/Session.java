/*
 * Created on Jan 17, 2006
 */
package com.sap.tc.moin.repository;

import java.util.Collection;

import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.events.EventRegistry;

/**
 * Sessions are isolated with regard to their user-specific contents. Sessions
 * that share the same CompountClientSpec see each other's changes only after a
 * call to {@link Connection#save()}.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface Session {

    /**
     * Method to check, if a Session is still alive or if it has been closed
     * already.
     * 
     * @return true, if the Session is still valid and alive, otherwise false
     */
    public boolean isAlive( );

    /**
     * Returns the CompoundClientSpec this session is based on.
     * 
     * @return the CompoundClientSpec
     */
    public CompoundClientSpec getCompoundClientSpec( );

    /**
     * Gets the event registry for this session.
     * 
     * @return the event registry for this session
     */
    public EventRegistry getEventRegistry( );

    /**
     * Gets the application lock manager
     * 
     * @return the lock manager
     */
    public LockManager getLockManager( );


    /**
     * Creates a {@link Connection}
     * 
     * @return the newly created {@link Connection}
     */
    public Connection createConnection( );


    /**
     * Returns the root interface for the access to MOIN
     * 
     * @return the root interface for the access to MOIN
     */
    public Moin getMoin( );

    /**
     * Creates a {@link Connection} with the passed in label
     * 
     * @param label human readable label
     * @return the newly created {@link Connection}
     */
    public Connection createConnection( String label );

    /**
     * Returns the collection of partitions that are part of the specified model
     * container. This does NOT include partitions in referenced other
     * containers.
     * 
     * @param cri the {@link CRI} of the container.
     * @return the collection of partitions that are part of the specified model
     * container
     */
    public Collection<PRI> getInnerPartitions( CRI cri );

    /**
     * The underlying infrastructure defines usage relations between containers.
     * Those usage relations define which parts of which containers content are
     * visible for which other containers. The method returns those partitions
     * from those other containers which are visible for the given container
     * defined by <code>cri</code>.
     * 
     * @param cri the {@link CRI} of the container.
     * @return the partitions from those containers which are visible for the
     * given container
     */
    public Collection<PRI> getOuterPartitions( CRI cri );

    /**
     * The underlying infrastructure defines usage relations between containers.
     * Those usage relations define which containers are visible for other
     * containers. The method returns those containers which are visible for the
     * given container defined by <code>cri</code>.
     * 
     * @param cri the {@link CRI} of the container.
     * @return the containers which are visible for the given container
     */
    public Collection<CRI> getReferencedContainers( CRI cri );

    /**
     * Returns <code>true</code> if there exists at least one link between an
     * element in priOne and at least one element in one of the otherPris. In
     * all other cases this method returns <code>false</code>.
     * 
     * @param priOne a partition
     * @param otherPris a number of other partition
     * @return true if at least one link exists between priOne and one of the
     * otherPris
     */
    public boolean hasCrossPartitionLinks( PRI priOne, PRI... otherPris );

    /**
     * Checks if a container can be potentially modified.<br>
     * I.e. this container is available as source and is not only referenced as
     * an archive.<br>
     * Note that a return value of <code>true</code> does not necessarily mean
     * that partitions in this container can be modified. It might be that the
     * these partitions must be "opened for edit" in the source code control
     * system before they can be changed.
     * 
     * @param cri the container to be checked
     * @return <code>true</code> if the container is modifiable
     */
    public boolean isContainerModifiable( CRI cri );

}
