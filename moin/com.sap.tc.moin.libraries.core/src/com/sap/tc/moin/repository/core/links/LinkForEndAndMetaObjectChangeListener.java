package com.sap.tc.moin.repository.core.links;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.EndAndMetaObject;

public interface LinkForEndAndMetaObjectChangeListener {

    public void notifyOnLastLinkRemoved( EndAndMetaObject endAndMetaObject, MRI mriAtEnd, boolean wasLastForEndAndMetaObject );
}
