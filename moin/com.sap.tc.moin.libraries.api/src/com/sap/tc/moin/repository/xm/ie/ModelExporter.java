package com.sap.tc.moin.repository.xm.ie;

import java.io.OutputStream;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinBaseRuntimeException;
import com.sap.tc.moin.repository.xm.XmException;

/**
 * Exporter of MOIN models.
 * <p>
 * The exporter maps the model content of a specific model partition to a
 * specific XML document.
 * <p>
 * If you use a Model Exporter instance in different threads, the export calls
 * will be serialized. <strong>Therefore we recommend to use different Model
 * Exporter instances in different threads.</strong>
 * 
 * @noimplement This class is not intended to be implemented by clients.
 */
public abstract class ModelExporter {

    /**
     * Exports a MOIN model contained in a model partition into an XML document.
     * 
     * @param outputstream output stream for the exported XML document
     * @param modelPartitionPri PRI of the model partition which shall be
     * exported
     * @throws XmException if an error in the XML mapping occurs, after such an
     * exception the state of the output stream is undefined
     * @throws MoinBaseRuntimeException if an error in the MOIN Core occurs,
     * after such an exception the state of the output stream is undefined
     * @throws NullPointerException if a parameter is <tt>null</tt>
     * @throws IllegalArgumentException if the model partition for the given PRI
     * does not exist
     */
    public abstract void doExport( OutputStream outputstream, PRI modelPartitionPri ) throws XmException;


}
