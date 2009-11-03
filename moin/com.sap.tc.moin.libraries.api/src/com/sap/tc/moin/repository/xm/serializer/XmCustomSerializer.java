package com.sap.tc.moin.repository.xm.serializer;

import com.sap.tc.moin.repository.xm.XmException;
import com.sap.tc.moin.repository.xm.ie.ModelExporter;



/**
 * Interface for a custom implementation of a serializer which transforms a MOIN
 * model into an XML document.
 * <p>
 * An implementation can either be used in {@link ModelExporter} or in the
 * Custom Parser/Serializer integration strategy (see
 * com.sap.tc.moin.repository.spi.ps.SpiXmParserSerializerConfiguration) via
 * {@link XmSerializerConfiguration}.
 * <p>
 * A custom serializer instance can hold state during the serializing of a
 * single XML document. <strong>However, when the serializing of this single XML
 * document is finished, then the instance should have the same state as at the
 * beginning of the serializing.</strong>
 * <p>
 * This class is intended to be implemented by clients. Before you use this
 * interface, please check the abstract class {@link XmCustomSerializerAbstract}
 * which implements this interface and which provides several convenience
 * methods.
 */
public interface XmCustomSerializer {


    /**
     * Executes the serialization.
     * 
     * @param helper helper instance with helper methods to access MOIN model
     * entities and to create XML elements and attributes
     * @throws XmException for error handling
     */
    void execute( SerializerHelper helper ) throws XmException;

}
