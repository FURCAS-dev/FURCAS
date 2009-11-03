package com.sap.tc.moin.xm.kernel;

import java.io.OutputStream;

import com.sap.tc.moin.repository.exception.MoinBaseRuntimeException;
import com.sap.tc.moin.repository.xm.XmException;

/**
 * Serializer of a MOIN model to a XML document. You can get an instance by the
 * factory {@link XmFactory}.
 * <p>
 * The serializer maps the model content of a specific model partition to a
 * specific XML document. It is recommended, to have a one-to-one relationship
 * between XML documents and model partitions.
 * <p>
 * <strong>Note that this implementation is not synchronized.</strong> If
 * multiple threads call the method
 * {@link #serialize(OutputStream, XmSerializerCallback)} concurrently, it
 * <i>must</i> be synchronized externally.
 * 
 * @param <TElement> either a RefObject representing a MOF class instance in the
 * Export case or a SpiElement in the CPS case
 * @param <TMofClass> either RefClass in the Export case or SpiClass in the CPS
 * case
 * @param <TMofAssociation> either a RefAssociation in the Export case or a
 * SpiAssociation in the CPS case
 */
public abstract class XmSerializer<TElement, TMofClass, TMofAssociation> {

    /**
     * Serializes a MOIN model contained in a model partition into an XML
     * document.
     * 
     * @param outputstream output stream for the exported XML document
     * @param callback for accessing the MOIN model elements which must be
     * serialized
     * @throws XmException if an error occurs in the XML mapping
     * @throws MoinBaseRuntimeException if an error occurs in the MOIN Core
     * @throws NullPointerException if a parameter is <tt>null</tt>
     */
    public abstract void serialize( OutputStream outputstream, XmSerializerCallback<TElement, TMofClass, TMofAssociation> callback ) throws XmException;
}
