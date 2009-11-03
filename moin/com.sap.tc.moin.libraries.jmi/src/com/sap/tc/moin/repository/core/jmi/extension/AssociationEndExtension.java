/*
 * Created on 23.11.2005
 */
package com.sap.tc.moin.repository.core.jmi.extension;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;

/**
 * This interface provides information about an {@link AssociationEnd}, 
 * their storage and their compositeness. This information is needed for
 * AssociationEnds instantiated by the MOF ROM, because this info cannot be 
 * calculated on the fly.
 * <p>
 * TODO This interface is to be refactored to a place with non-API interfaces. 
 * @author d024227
 */
public interface AssociationEndExtension {

    public Association get___Association( );

    public byte get___EndNumber( );

    public boolean is___EndComposite( );

    public boolean is___EndOrdered( );

    public boolean is___EndStored( );

    public void set___ExtensionInfo( Association association, byte endNumber, boolean composite, boolean ordered, boolean stored );
}
