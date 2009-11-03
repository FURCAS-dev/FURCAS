/*
 * Created on 23.11.2005
 */
package com.sap.tc.moin.repository.core.jmi.extension;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;

/**
 * This interface provides information about the ends of an {@link Association}.
 * This information is needed for Associations instantiated by the MOF ROM,
 * because this info cannot be calculated on the fly.
 * <p>
 * TODO This interface is to be refactored to a place with non-API interfaces. 
 * 
 * @author d024227
 */
public interface AssociationExtension {

    public AssociationEnd[] get___AssociationEnds( );

    public void set___AssociationEnds( AssociationEnd[] associationEnds );
}
