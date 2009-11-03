package com.sap.tc.moin.repository.events.type;

import com.sap.tc.moin.repository.mmi.model.Attribute;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;

/**
 * This event type indicates a changed attribute of a model element.
 * <p>
 * This interface is not intended to be implemented by clients.
 * 
 * @author Martin Kolb
 * @noimplement This interface is not intended to be implemented by clients.
 */

public interface AttributeValueEvent extends ElementChangeEvent {

    /**
     * The affected meta object of an AttributeValueEvent points to the
     * corresponding meta attribute. This meta attribute is an attribute of the
     * meta object of the describing class.
     * 
     * @return an MRI pointing to the instance of the meta object of the changed
     * attribute.
     */
    public MRI getAffectedMetaObjectMri( );

    /**
     * Retrieves the attribute meta-object of the changes attribute.
     * 
     * @param resolvingConnection the connection used to resolve the MRI
     * @return the meta object of the attribute
     */
    public Attribute getAffectedMetaObject( Connection resolvingConnection );

}