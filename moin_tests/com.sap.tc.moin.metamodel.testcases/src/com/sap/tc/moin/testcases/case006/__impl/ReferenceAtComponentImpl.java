/**
 * Generated by the MOIN Generator Version 3.0
 **/

package com.sap.tc.moin.testcases.case006.__impl;

public final class ReferenceAtComponentImpl extends com.sap.tc.moin.repository.core.jmi.reflect.RefAssociationImpl
{
    // default constructor
    public ReferenceAtComponentImpl() {
        super();
    }

    // specific constructor
    public ReferenceAtComponentImpl(java.lang.Object workspace, java.lang.String mofId, com.sap.tc.moin.repository.mmi.reflect.RefPackage immediatePackage, com.sap.tc.moin.repository.mmi.reflect.RefObject metaObject) {
        super(workspace, mofId, immediatePackage, metaObject);
    }
    
    public boolean exists(com.sap.tc.moin.repository.mmi.reflect.RefBaseObject _Y, com.sap.tc.moin.repository.mmi.reflect.RefBaseObject _X) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        return exists(get___CurrentConnection(), _Y, _X);
    }
    public boolean exists(com.sap.tc.moin.repository.core.CoreConnection connection, com.sap.tc.moin.repository.mmi.reflect.RefBaseObject _Y, com.sap.tc.moin.repository.mmi.reflect.RefBaseObject _X) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        return ___existsMult1( connection, _Y, _X, "45F120A52BD4F2590FCC48413FDFC703AB1BC298"); //$NON-NLS-1$
    }
    public com.sap.tc.moin.repository.mmi.reflect.RefBaseObject getY(com.sap.tc.moin.repository.mmi.reflect.RefBaseObject _X) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        return getY(get___CurrentConnection(), _X);
    }
    public com.sap.tc.moin.repository.mmi.reflect.RefBaseObject getY(com.sap.tc.moin.repository.core.CoreConnection connection, com.sap.tc.moin.repository.mmi.reflect.RefBaseObject _X) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        com.sap.tc.moin.repository.core.EndAndMetaObject endAndMetaObject = get___EndAndMetaObject( 1 );
        return (com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) ___queryElementAtOtherLinkEnd( connection, (com.sap.tc.moin.repository.core.CorePartitionable) _X, endAndMetaObject );
    }
    public com.sap.tc.moin.repository.mmi.reflect.RefBaseObject getX(com.sap.tc.moin.repository.mmi.reflect.RefBaseObject _Y) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        return getX(get___CurrentConnection(), _Y);
    }
    public com.sap.tc.moin.repository.mmi.reflect.RefBaseObject getX(com.sap.tc.moin.repository.core.CoreConnection connection, com.sap.tc.moin.repository.mmi.reflect.RefBaseObject _Y) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        return (com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) ___getElementAtOtherLinkEnd( connection, (com.sap.tc.moin.repository.core.CorePartitionable) _Y, "45F120A52BD4F2590FCC48413FDFC703AB1BC298"); //$NON-NLS-1$
    }
    public boolean add(com.sap.tc.moin.repository.mmi.reflect.RefBaseObject _Y, com.sap.tc.moin.repository.mmi.reflect.RefBaseObject _X) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
          return refAddLink((com.sap.tc.moin.repository.mmi.reflect.RefObject)_Y, (com.sap.tc.moin.repository.mmi.reflect.RefObject)_X);
    }
    public boolean add(com.sap.tc.moin.repository.core.CoreConnection connection, com.sap.tc.moin.repository.mmi.reflect.RefBaseObject _Y, com.sap.tc.moin.repository.mmi.reflect.RefBaseObject _X) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
          return refAddLink(connection, (com.sap.tc.moin.repository.mmi.reflect.RefObject)_Y, (com.sap.tc.moin.repository.mmi.reflect.RefObject)_X);
    }
    public boolean remove(com.sap.tc.moin.repository.mmi.reflect.RefBaseObject _Y, com.sap.tc.moin.repository.mmi.reflect.RefBaseObject _X) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        return refRemoveLink((com.sap.tc.moin.repository.mmi.reflect.RefObject)_Y, (com.sap.tc.moin.repository.mmi.reflect.RefObject)_X);
    }
    public boolean remove(com.sap.tc.moin.repository.core.CoreConnection connection, com.sap.tc.moin.repository.mmi.reflect.RefBaseObject _Y, com.sap.tc.moin.repository.mmi.reflect.RefBaseObject _X) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        return refRemoveLink(connection, (com.sap.tc.moin.repository.mmi.reflect.RefObject)_Y, (com.sap.tc.moin.repository.mmi.reflect.RefObject)_X);
    }
    public boolean refLinkExists(com.sap.tc.moin.repository.core.CoreConnection connection, com.sap.tc.moin.repository.mmi.reflect.RefObject firstEnd, com.sap.tc.moin.repository.mmi.reflect.RefObject secondEnd) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        if ( firstEnd == null || secondEnd == null ) { return false; }
        checkTypesForRefLinkExists( connection, firstEnd, secondEnd );
        return exists( connection, (com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) firstEnd, (com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) secondEnd );
    }

    public java.lang.Class<com.sap.tc.moin.testcases.case006.ReferenceAtComponent> get___JmiInterface() {
        return com.sap.tc.moin.testcases.case006.ReferenceAtComponent.class;
    }
    
    @Override
    public com.sap.tc.moin.repository.spi.core.Wrapper<com.sap.tc.moin.testcases.case006.ReferenceAtComponent> createWrapper(com.sap.tc.moin.repository.core.CoreConnection conn, boolean synchronize) {
        return new com.sap.tc.moin.testcases.case006.__impl.ReferenceAtComponentWrapper(conn, this, synchronize);
    }
}