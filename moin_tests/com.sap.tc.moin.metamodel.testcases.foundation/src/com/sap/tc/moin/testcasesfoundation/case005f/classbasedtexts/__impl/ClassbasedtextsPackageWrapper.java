/**
 * Generated by the MOIN Generator Version 3.0
 **/

package com.sap.tc.moin.testcasesfoundation.case005f.classbasedtexts.__impl;

public class ClassbasedtextsPackageWrapper extends com.sap.tc.moin.repository.core.jmi.reflect.RefPackageWrapperImpl<com.sap.tc.moin.testcasesfoundation.case005f.classbasedtexts.__impl.ClassbasedtextsPackageImpl> implements com.sap.tc.moin.testcasesfoundation.case005f.classbasedtexts.ClassbasedtextsPackage,com.sap.tc.moin.repository.Partitionable
{

    /**
     * The ClassbasedtextsPackage wrapper
     */
    public ClassbasedtextsPackageWrapper(com.sap.tc.moin.repository.core.CoreConnection conn, com.sap.tc.moin.testcasesfoundation.case005f.classbasedtexts.__impl.ClassbasedtextsPackageImpl baseObject, boolean synchronize) {
        super(conn, baseObject, synchronize);
    }

    private com.sap.tc.moin.testcasesfoundation.case005f.classbasedtexts.__impl.ClassbasedtextsPackageImpl getCastWrappedObject() {
        return (com.sap.tc.moin.testcasesfoundation.case005f.classbasedtexts.__impl.ClassbasedtextsPackageImpl) getWrappedObject();
    }
    
    public com.sap.tc.moin.testcasesfoundation.case005f.classbasedtexts.__impl.ClassbasedtextsPackageImpl unwrap() {
        return (com.sap.tc.moin.testcasesfoundation.case005f.classbasedtexts.__impl.ClassbasedtextsPackageImpl) getWrappedObject();
    }
    
    public com.sap.tc.moin.repository.mmi.reflect.RefClass getGeneralText()
    {
        try {
            if (synchronize) {
                synchronizationManager.acquireReadLock();
                try {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return (com.sap.tc.moin.repository.mmi.reflect.RefClass) wrapResult(getCastWrappedObject().getGeneralText(connection));
                } finally {
                    synchronizationManager.releaseReadLock();
                }
       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return (com.sap.tc.moin.repository.mmi.reflect.RefClass) wrapResult(getCastWrappedObject().getGeneralText(connection)); 
        } catch (com.sap.tc.moin.repository.mmi.reflect.JmiException ex) {
            wrapJmiExceptionArgs(ex);
            throw ex;
        }
    }
    public com.sap.tc.moin.repository.mmi.reflect.RefClass getSpecializedText()
    {
        try {
            if (synchronize) {
                synchronizationManager.acquireReadLock();
                try {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return (com.sap.tc.moin.repository.mmi.reflect.RefClass) wrapResult(getCastWrappedObject().getSpecializedText(connection));
                } finally {
                    synchronizationManager.releaseReadLock();
                }
       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return (com.sap.tc.moin.repository.mmi.reflect.RefClass) wrapResult(getCastWrappedObject().getSpecializedText(connection)); 
        } catch (com.sap.tc.moin.repository.mmi.reflect.JmiException ex) {
            wrapJmiExceptionArgs(ex);
            throw ex;
        }
    }
    // methods for structure type creators
    
    public java.lang.Class<com.sap.tc.moin.testcasesfoundation.case005f.classbasedtexts.ClassbasedtextsPackage> get___JmiInterface() {
        return com.sap.tc.moin.testcasesfoundation.case005f.classbasedtexts.ClassbasedtextsPackage.class;
    }
    
    protected String metaObjectToString() {
        return "com.sap.tc.moin.testcasesfoundation.case005f.classbasedtexts.ClassbasedtextsPackage (Java Type)\ntestcasesfoundation.case005f.classbasedtexts (MOF Type)"; //$NON-NLS-1$
    }
}