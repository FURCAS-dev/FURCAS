package com.sap.tc.moin.repository.core.impl;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.MoinReference;
import com.sap.tc.moin.repository.spi.core.SpiPartitionable;
import com.sap.tc.moin.repository.spi.core.SpiSession;

public abstract class AbstractReferenceImpl implements MoinReference {

    /**
     * The Java references to the JMI instance representing the resolved
     * reference target. If <tt>null</tt>, this reference hasn't been resolved
     * yet.
     */
    protected CorePartitionable resolved;

    /**
     * If <code>false</code> the <code>Reference</code> stays unresolved after
     * the resolve method has been called. The calculated Partitionable is not
     * cached and the Reference has to calculate it again when it is requested
     * the next time.
     */
    protected boolean cacheable;

    /**
     * The meta object of the {@link CorePartitionable} instance to which this
     * reference points. This field is populated lazily in {@link #getType()}.
     */
    private ModelElement metaObject;

    protected AbstractReferenceImpl( CorePartitionable partitionable, boolean cacheable ) {

        this.resolved = cacheable ? partitionable : null;
        this.cacheable = cacheable;
        if ( this.resolved != null ) {
            metaObject = (ModelElement) ( (RefBaseObject) resolved ).refMetaObject( );
        }
    }

    public final SpiPartitionable get( SpiSession session ) {

        return this.get( (CoreSession) session );
    }

    public final CorePartitionable get( CoreSession session ) {

        CorePartitionable result = ( resolved != null ? resolved : resolve( session ) );
        if ( result != null ) {
            assert result.get___Partition( ) != null : "Found resolved reference with deleted cached element"; //$NON-NLS-1$
            assert result.get___Workspace( ) != null : "Found resolved reference where the cached element has workspace == null"; //$NON-NLS-1$
            result.get___Partition( ).updateEvictionTimestamp( );
        }
        return result;
    }

    public final CorePartitionable getWithoutException( CoreSession session ) {

        CorePartitionable result = null;
        if ( resolved != null ) {
            result = resolved;
        } else {
            result = resolveWithoutException( session );
        }
        if ( result != null ) {
            assert result.get___Partition( ) != null : "Found resolved reference with deleted cached element"; //$NON-NLS-1$
            assert result.get___Workspace( ) != null : "Found resolved reference where the cached element has workspace == null"; //$NON-NLS-1$
            result.get___Partition( ).updateEvictionTimestamp( );
        }
        return result;
    }

    /**
     * Resolves element.
     */
    protected abstract CorePartitionable resolve( CoreSession session );

    /**
     * Resolves element.
     */
    protected abstract CorePartitionable resolveWithoutException( CoreSession session );

    /**
     * Tells if this reference is already resolved. Note, that a reference may
     * also be reverted from being resolved into an unresolved reference. This
     * can happen, e.g., when a partition is unloaded / evicted.
     */
    public final boolean isCached( ) {

        return resolved != null;
    }

    /**
     * Returns the meta object of the model element to which this reference
     * points. Note that on the first call to this method, the reference gets
     * resolved, while on subsequent calls the resolved-state remains unchanged.
     */
    public final ModelElement getType( CoreSession session ) {

        if ( metaObject == null ) {
            metaObject = (ModelElement) ( (RefBaseObject) get( session ) ).refMetaObject( );
        }
        return metaObject;
    }
}