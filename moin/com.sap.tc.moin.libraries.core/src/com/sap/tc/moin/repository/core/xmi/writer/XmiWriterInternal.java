package com.sap.tc.moin.repository.core.xmi.writer;

import java.io.OutputStream;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;

/**
 * This internal interface has to be implemented by each XmiWriter implementation, independent of the specific XMI
 * version (1.2, 2.0, etc.). It is used by {@link com.sap.tc.moin.repository.core.xmi.writer.XmiWriterImpl} to forward
 * <code>write</code> calls to the correct implementation, matching the given <code>xmiVersion</code> parameter.
 * 
 * @author d027299
 */
interface XmiWriterInternal {

    /**
     * Writes the given collection of model elements to the OutputStream using the specified XMI version. This method
     * serializes the complete composition hierarchy of the model elements in the collection. The OutputStream is left
     * open after completion.
     * 
     * @param os the OutputStream to use
     * @param objects the collection of model elements to serialize. Only instances of {@link RefObject}, which are at
     * the same time instances of {@link Partitionable}, are allowed as collection elements.
     * @throws IllegalArgumentException if the OutputStream or the collection are 'null', the collection contains
     * objects of the wrong type, or the collection contains model elements which are not assigned to the same workspace
     * as this XmiWriter instance.
     * @throws UnsupportedOperationException if an unsupported XMI version is requested
     */
    public void write( OutputStream os, Collection objects ) throws java.io.IOException;

    /**
     * Writes a complete package extent to the given OutputStream using the specified XMI version. The OutputStream is
     * left open after completion.
     * <p>
     * A package extent contains the extents of all nested or clustered packages, as well as all class extents and
     * association extents contained by all the aforementioned packages.
     * <p>
     * According to the XMI specification, the serialization of a package extent is not unlike dumping an entire part of
     * a database into an XMI document, for example to replicate it into another environment. The resulting document has
     * to include all model elements, all links (including links of associations for which no reference exists in the
     * metamodel), and all values of classifier-level attributes. This distinguishes it from the serialization of a
     * collection of model elements via {@link #write(OutputStream, Collection)}, which neither includes
     * classifier-level attributes nor links not represented by references.
     * 
     * @param os the OutputStream to use
     * @param extent the package extent to serialize
     * @throws IllegalArgumentException if the OutputStream or the RefPackage are 'null'
     * @throws UnsupportedOperationException if an unsupported XMI version is requested
     */
    public void write( OutputStream os, RefPackage extent ) throws java.io.IOException;

    /**
     * Writes the model partition to the OutputStream using the specified XMI version. It must not be <code>null</code>,
     * must have a valid URI, and has to be assigned to the same workspace as the XmiWriter instance.
     * 
     * @param os the OutputStream to use
     * @param partition the model partition to serialize
     * @throws IllegalArgumentException if the OutputStream or the ModelPartition are 'null', or if the ModelPartition
     * is not assigned to a Workspace
     * @throws UnsupportedOperationException if an unsupported XMI version is requested
     */
    public void write( OutputStream os, ModelPartition partition ) throws java.io.IOException;
}