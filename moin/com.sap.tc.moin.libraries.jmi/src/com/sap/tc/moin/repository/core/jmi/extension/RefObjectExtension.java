/*
 * Created on 07.10.2005
 */
package com.sap.tc.moin.repository.core.jmi.extension;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.Extent;

/**
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 * 
 * @author d024227
 */
public interface RefObjectExtension extends RefObject, RefFeaturedExtension {

    public void set___RefClass( RefClass refClass );

    public void set___Extent( Extent extent );

    public Extent get___Extent( );

    // NGLM 

    public void set___CompositeParentLink( EndStorageLink parent );

    public EndStorageLink get___CompositeParentLink( );

    public void reset___CompositeParentLink( );
}
