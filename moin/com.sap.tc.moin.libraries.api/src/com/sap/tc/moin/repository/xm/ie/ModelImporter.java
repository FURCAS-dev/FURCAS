package com.sap.tc.moin.repository.xm.ie;


import java.io.InputStream;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.exception.MoinBaseRuntimeException;
import com.sap.tc.moin.repository.xm.XmException;
import com.sap.tc.moin.repository.xm.XmInvalidXmlException;
import com.sap.tc.moin.repository.xm.parser.ParserErrorHandler;

/**
 * Importer of MOIN models. You can get an instance via
 * {@link Connection#createModelImporter(com.sap.tc.moin.repository.xm.parser.XmParserConfiguration)}
 * .
 * <p>
 * The importer maps a specific XML document to a specific model partition.
 * <p>
 * If you use a Model Importer instance in different threads, the import calls
 * will be serialized. <strong>Therefore we recommend to use different Model
 * Importer instances in different threads.</strong>
 * 
 * @noimplement This class is not intended to be sub-classed by clients.
 */
public abstract class ModelImporter {


    /**
     * Imports an XML document to a MOIN model.
     * <p>
     * There is a one to one relationship between an XML document and a MOIN
     * model partition. The model partition is updated according to the content
     * of the XML document.
     * <ul>
     * <li>If there is XML content which is not contained in the model
     * partition, then the corresponding model elements and links are created in
     * the model partition.</li>
     * <li>If there exists already model elements and links in the model
     * partition for the XML content, then these model elements and links are
     * updated.</li>
     * <li>Model elements and links in the model partition for which there is no
     * corresponding XML content are removed from the model partition.</li>
     * </ul>
     * <p>
     * The caller is responsible to save the model partition via the connection
     * which was used to create the Model Importer instance. You can use the
     * method {@link #getConnection()} to get the connection.
     * <p>
     * The import is executed in a MOIN command ({@link Command}).
     * 
     * @param is input stream containing the XML document. Caller is responsible
     * for closing the stream after return.
     * @param modelPartitionPri PRI of the model partition in which imported
     * model elements are created, deleted, or updated
     * @throws XmInvalidXmlException if the error handler (
     * {@link ParserErrorHandler}) throws such an exception
     * @throws XmException if an error in the XML mapping occurs; all changes
     * done by the import are reverted;
     * @throws MoinBaseRuntimeException if an error in the MOIN Core occurs; all
     * changes done by the importer are reverted
     * @throws NullPointerException if a parameter is <tt>null</tt>
     * @throws IllegalArgumentException if the model partition for the given PRI
     * does not exist
     */
    public abstract void doImport( InputStream is, PRI modelPartitionPri ) throws XmException;


    /**
     * Returns the connection with which the model partition was updated.
     * <p>
     * This connection can be used to save or revert the changes after an
     * import.
     * 
     * @return MOIN connection
     */
    public abstract Connection getConnection( );

}
