/**
 * Generated by the MOIN Generator Version 3.0
 **/

package org.omg.ocl.attaching.__impl;

public final class OclConstraintExpressionImpl extends com.sap.tc.moin.repository.core.jmi.reflect.RefAssociationImpl implements org.omg.ocl.attaching.OclConstraintExpression,org.omg.ocl.attaching.__impl.OclConstraintExpressionInternal
{
    // default constructor
    public OclConstraintExpressionImpl() {
        super();
    }

    // specific constructor
    public OclConstraintExpressionImpl(java.lang.Object workspace, java.lang.String mofId, com.sap.tc.moin.repository.mmi.reflect.RefPackage immediatePackage, com.sap.tc.moin.repository.mmi.reflect.RefObject metaObject) {
        super(workspace, mofId, immediatePackage, metaObject);
    }
    
    public boolean exists(org.omg.ocl.expressions.OclExpression _OclExpression, org.omg.ocl.attaching.OclConstraint _OclConstraint) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        return exists(get___CurrentConnection(), _OclExpression, _OclConstraint);
    }
    public boolean exists(com.sap.tc.moin.repository.core.CoreConnection connection, org.omg.ocl.expressions.OclExpression _OclExpression, org.omg.ocl.attaching.OclConstraint _OclConstraint) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        return ___existsMult1( connection, _OclConstraint, _OclExpression, "45ED2E29313B19F9A338463C16FEA9A19FC4D0F7"); //$NON-NLS-1$
    }
    public org.omg.ocl.expressions.OclExpression getOclExpression(org.omg.ocl.attaching.OclConstraint _OclConstraint) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        return getOclExpression(get___CurrentConnection(), _OclConstraint);
    }
    public org.omg.ocl.expressions.OclExpression getOclExpression(com.sap.tc.moin.repository.core.CoreConnection connection, org.omg.ocl.attaching.OclConstraint _OclConstraint) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        return (org.omg.ocl.expressions.OclExpression) ___getElementAtOtherLinkEnd( connection, (com.sap.tc.moin.repository.core.CorePartitionable) _OclConstraint, "45ED2E29313B19F9A338463C16FEA9A19FC4D0F7"); //$NON-NLS-1$
    }
    public org.omg.ocl.attaching.OclConstraint getOclConstraint(org.omg.ocl.expressions.OclExpression _OclExpression) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        return getOclConstraint(get___CurrentConnection(), _OclExpression);
    }
    public org.omg.ocl.attaching.OclConstraint getOclConstraint(com.sap.tc.moin.repository.core.CoreConnection connection, org.omg.ocl.expressions.OclExpression _OclExpression) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        com.sap.tc.moin.repository.core.EndAndMetaObject endAndMetaObject = get___EndAndMetaObject( 0 );
        return (org.omg.ocl.attaching.OclConstraint) get___CompositeParentForEndAndMetaObject( connection, _OclExpression, endAndMetaObject );
    }
    public boolean add(org.omg.ocl.expressions.OclExpression _OclExpression, org.omg.ocl.attaching.OclConstraint _OclConstraint) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
          return refAddLink((com.sap.tc.moin.repository.mmi.reflect.RefObject)_OclExpression, (com.sap.tc.moin.repository.mmi.reflect.RefObject)_OclConstraint);
    }
    public boolean add(com.sap.tc.moin.repository.core.CoreConnection connection, org.omg.ocl.expressions.OclExpression _OclExpression, org.omg.ocl.attaching.OclConstraint _OclConstraint) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
          return refAddLink(connection, (com.sap.tc.moin.repository.mmi.reflect.RefObject)_OclExpression, (com.sap.tc.moin.repository.mmi.reflect.RefObject)_OclConstraint);
    }
    public boolean remove(org.omg.ocl.expressions.OclExpression _OclExpression, org.omg.ocl.attaching.OclConstraint _OclConstraint) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        return refRemoveLink((com.sap.tc.moin.repository.mmi.reflect.RefObject)_OclExpression, (com.sap.tc.moin.repository.mmi.reflect.RefObject)_OclConstraint);
    }
    public boolean remove(com.sap.tc.moin.repository.core.CoreConnection connection, org.omg.ocl.expressions.OclExpression _OclExpression, org.omg.ocl.attaching.OclConstraint _OclConstraint) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        return refRemoveLink(connection, (com.sap.tc.moin.repository.mmi.reflect.RefObject)_OclExpression, (com.sap.tc.moin.repository.mmi.reflect.RefObject)_OclConstraint);
    }
    public boolean refLinkExists(com.sap.tc.moin.repository.core.CoreConnection connection, com.sap.tc.moin.repository.mmi.reflect.RefObject firstEnd, com.sap.tc.moin.repository.mmi.reflect.RefObject secondEnd) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        if ( firstEnd == null || secondEnd == null ) { return false; }
        checkTypesForRefLinkExists( connection, firstEnd, secondEnd );
        return exists( connection, (org.omg.ocl.expressions.OclExpression) firstEnd, (org.omg.ocl.attaching.OclConstraint) secondEnd );
    }

    public java.lang.Class<org.omg.ocl.attaching.OclConstraintExpression> get___JmiInterface() {
        return org.omg.ocl.attaching.OclConstraintExpression.class;
    }
    
    @Override
    public com.sap.tc.moin.repository.spi.core.Wrapper<org.omg.ocl.attaching.OclConstraintExpression> createWrapper(com.sap.tc.moin.repository.core.CoreConnection conn, boolean synchronize) {
        return new org.omg.ocl.attaching.__impl.OclConstraintExpressionWrapper(conn, this, synchronize);
    }
}