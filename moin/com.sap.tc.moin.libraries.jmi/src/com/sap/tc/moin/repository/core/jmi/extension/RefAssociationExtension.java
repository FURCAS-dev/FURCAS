/*
 * Created on 07.10.2005
 */
package com.sap.tc.moin.repository.core.jmi.extension;

import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * @author d024227
 */
public interface RefAssociationExtension extends RefAssociation, RefBaseObjectExtension {

    public boolean add___AssociationEnds( RefObject firstEnd, RefObject secondEnd, Reference addedViaReference );
}