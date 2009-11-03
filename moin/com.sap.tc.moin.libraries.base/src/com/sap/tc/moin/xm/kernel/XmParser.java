package com.sap.tc.moin.xm.kernel;



import java.io.InputStream;

import com.sap.tc.moin.repository.exception.MoinBaseRuntimeException;
import com.sap.tc.moin.repository.xm.XmCustomException;
import com.sap.tc.moin.repository.xm.XmException;
import com.sap.tc.moin.repository.xm.XmInvalidXmlException;
import com.sap.tc.moin.repository.xm.parser.ParserErrorHandler;

/**
 * XML mapping parser which parses an XML document and maps it to a MOIN model.
 * You can get an instance by the factory {@link XmFactory}.
 * <p>
 * <strong>Note that this implementation is not thread-safe.</strong> If
 * multiple threads call the method
 * {@link #parse(InputStream, XmParserCallback)} concurrently, it <i>must</i> be
 * synchronized externally.
 * 
 * @param <TElement> either a RefObject representing a MOF class instance in the
 * Import integration strategy or a SpiElement in the CPS integration strategy
 * @param <TMofClass> either RefClass in the Import integration strategy or
 * SpiClass in the CPS integration strategy
 * @param <TMofAssociation> either a RefAssociation in the Import integration
 * strategy or a SpiAssociation in the CPS integration strategy
 */
public abstract class XmParser<TElement, TMofClass, TMofAssociation> {


    /**
     * Maps an XML document to a MOIN model.
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
     * 
     * @param is input stream containing the XML document. Caller is responsible
     * for closing the stream after return.
     * @param callback call-back for creating and accessing MOIN model elements
     * @throws XmInvalidXmlException if the error handler (
     * {@link ParserErrorHandler}) throws such an exception, after such an
     * exception the state of the model partition is not defined
     * @throws XmCustomException if the custom parser throws an exception; after
     * such an exception the state of the model partition is not defined
     * @throws MoinBaseRuntimeException if an error in the MOIN Core
     * occurs;after such an exception the state of the model partition is not
     * defined
     * @throws NullPointerException if a parameter is <tt>null</tt>
     */
    public abstract void parse( InputStream is, XmParserCallback<TElement, TMofClass, TMofAssociation> callback ) throws XmException;

}
