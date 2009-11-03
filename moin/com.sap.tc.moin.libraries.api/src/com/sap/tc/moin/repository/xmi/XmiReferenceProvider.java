package com.sap.tc.moin.repository.xmi;

import com.sap.tc.moin.repository.MRI;

/**
 * This interface allows the XMI document producer to provide custom XMI-IDs for
 * model elements, as well as custom values for the non-ID part of the
 * <code>href</code> attribute of external links. The methods in this interface
 * are called back by the {@link com.sap.tc.moin.repository.xmi.XmiWriter}
 * during serialization, every time an XMI-ID or a <code>href</code> attribute
 * need to be written.
 * <p>
 * An instance of this interface can be registered using
 * {@link com.sap.tc.moin.repository.xmi.XmiWriter#setReferenceProvider(XmiReferenceProvider)}
 * . If not specified, a default implementation will be used, returning the
 * model element's partition MRI in {@link #getResourceLocation(MRI)} and its
 * MOF-ID in {@link #getIdentifier(MRI)}.
 * <p>
 * This interface <i>is</i> intended to be implemented by clients.
 */
public interface XmiReferenceProvider {

    /**
     * If a <code>href</code> attribute needs to be written for a model element,
     * because it is external to the currently written XMI document, this method
     * is called back. The returned String will be used for the non-ID part of
     * the <code>href</code> attribute. The ultimate value of <code>href</code>
     * is then computed by appending the appropriate delimiter character ("|" or
     * "#", depending on the XMI version), and finally by appending the result
     * of {@link #getIdentifier(MRI)}.
     * 
     * @param mriOfModelElement the MRI of current model element
     * @return the location part of the <code>href</code> attribute
     */
    public String getResourceLocation( MRI mriOfModelElement );

    /**
     * The returned String will be used for the XMI-ID of the given model
     * element, as well as for the ID part of <code>href</code> attributes.
     * 
     * @param mriOfModelElement the MRI of current model element
     * @return the XMI-ID / ID part of the location
     */
    public String getIdentifier( MRI mriOfModelElement );
}