package com.sap.tc.moin.xm.kernel.impl.parser.sax;



/**
 * This is a special exception that is used to stop parsing when no further
 * parsing is necessary for building the MOIN model.
 */
public class XmStopParseException extends org.xml.sax.SAXException {

    static final long serialVersionUID = 210102479218258961L;

    /**
     * Constructor.
     */
    XmStopParseException( ) {

        super( "Parsing stopped" ); //$NON-NLS-1$
    }
}
