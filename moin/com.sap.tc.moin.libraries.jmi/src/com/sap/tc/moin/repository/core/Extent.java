/*
 * Created on 25.11.2005
 */
package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

/**
 * MOF defines package ({@link RefPackage}), class ({@link RefClass}) and association ({@link RefAssociation})
 * extents, but there is no common interface for them. This interface has been added by MOIN in order to be able to
 * determine if an object is instanceof Extent.
 * <p>
 * This interface is not intended to be implemented by clients.
 * 
 * @author d024227
 */
public interface Extent extends RefBaseObject {

}
