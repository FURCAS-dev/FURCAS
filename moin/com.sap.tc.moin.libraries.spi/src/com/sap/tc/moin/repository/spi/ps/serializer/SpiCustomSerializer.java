package com.sap.tc.moin.repository.spi.ps.serializer;

import java.io.IOException;
import java.io.OutputStream;

import com.sap.tc.moin.repository.ModelPartition;

/**
 * An instance of {@link SpiCustomSerializer} represents a component that is
 * able to serialize the contents of a MOIN {@link ModelPartition model
 * partition} into a given {@link OutputStream} in a specific format. Custom
 * serializers have to be registered first to be known by MOIN, and they can
 * access the contents of a model partition by calling the methods of an
 * instance of {@link SpiSerializerCallback}, which is passed to the
 * <code>serialize</code> method.
 */
public interface SpiCustomSerializer {

    /**
     * Serializes the contents of a model partition into the given
     * {@link OutputStream}. For accessing the contents, an instance of
     * {@link SpiSerializerCallback} is provided.
     * 
     * @param stream The target {@link OutputStream}. The stream is expected to
     * remain open after serialization.
     * @param callback the {@link SpiSerializerCallback} providing access to the
     * contents of the model partition
     * @throws IOException
     */
    public void serialize( OutputStream stream, SpiSerializerCallback callback ) throws IOException;
}
