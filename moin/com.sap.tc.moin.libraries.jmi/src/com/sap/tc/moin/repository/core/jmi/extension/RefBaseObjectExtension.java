/*
 * Created on 07.10.2005
 */
package com.sap.tc.moin.repository.core.jmi.extension;


import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.Workspace;


/**
 * @author d024227
 */
public interface RefBaseObjectExtension extends RefBaseObject, CorePartitionable {

    public void set___Workspace( Workspace workspace );

    public void set___MofId( String mofId );

    public void set___MetaObject( RefObject metaObject );

    public void set___ImmediatePackage( RefPackage immediatePackage );

    /**
     * This method is called to signal this object that it has been deleted from
     * the repository. So this object can do cleanup operations, e.g. nulling
     * its workspace etc.<br>
     * This method is ONLY to be called by JmiActionManager.
     */
    public void ___delete( );


}
