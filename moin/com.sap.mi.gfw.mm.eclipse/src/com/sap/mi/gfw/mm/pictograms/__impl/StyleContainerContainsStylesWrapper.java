/**
 * Generated by the MOIN Generator Version 3.0
 **/

package com.sap.mi.gfw.mm.pictograms.__impl;

public class StyleContainerContainsStylesWrapper extends com.sap.tc.moin.repository.core.jmi.reflect.RefAssociationWrapperImpl<com.sap.mi.gfw.mm.pictograms.StyleContainerContainsStyles> implements com.sap.mi.gfw.mm.pictograms.StyleContainerContainsStyles,com.sap.tc.moin.repository.Partitionable
{

    /**
     * The StyleContainerContainsStyles wrapper
     */
    public StyleContainerContainsStylesWrapper(com.sap.tc.moin.repository.core.CoreConnection conn, com.sap.mi.gfw.mm.pictograms.__impl.StyleContainerContainsStylesImpl baseObject, boolean synchronize) {
        super(conn, baseObject, synchronize);
    }
    
    private com.sap.mi.gfw.mm.pictograms.__impl.StyleContainerContainsStylesImpl getCastWrappedObject() {
        return (com.sap.mi.gfw.mm.pictograms.__impl.StyleContainerContainsStylesImpl) getWrappedObject();
    }

    public com.sap.mi.gfw.mm.pictograms.StyleContainerContainsStyles unwrap() {
        return (com.sap.mi.gfw.mm.pictograms.StyleContainerContainsStyles) getWrappedObject();
    }
    
    public boolean exists(com.sap.mi.gfw.mm.pictograms.Style _Styles, com.sap.mi.gfw.mm.pictograms.StyleContainer _StyleContainer) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        try {
            if (synchronize) {
                synchronizationManager.acquireReadLock();
                try {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return getCastWrappedObject().exists(connection, unwrapArg((com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) _Styles), unwrapArg((com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) _StyleContainer));
                } finally {
                    synchronizationManager.releaseReadLock();
                }
       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return getCastWrappedObject().exists(connection, unwrapArg((com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) _Styles), unwrapArg((com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) _StyleContainer)); 
        } catch (com.sap.tc.moin.repository.mmi.reflect.JmiException ex) {
            wrapJmiExceptionArgs(ex);
            throw ex;
        }
    }
    public java.util.Collection getStyles(com.sap.mi.gfw.mm.pictograms.StyleContainer _StyleContainer) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        try {
            if (synchronize) {
                synchronizationManager.acquireReadLock();
                try {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return (java.util.Collection) wrapResult(getCastWrappedObject().getStyles(connection, unwrapArg((com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) _StyleContainer)));
                } finally {
                    synchronizationManager.releaseReadLock();
                }
       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return (java.util.Collection) wrapResult(getCastWrappedObject().getStyles(connection, unwrapArg((com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) _StyleContainer))); 
        } catch (com.sap.tc.moin.repository.mmi.reflect.JmiException ex) {
            wrapJmiExceptionArgs(ex);
            throw ex;
        }
    }
    public com.sap.mi.gfw.mm.pictograms.StyleContainer getStyleContainer(com.sap.mi.gfw.mm.pictograms.Style _Styles) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        try {
            if (synchronize) {
                synchronizationManager.acquireReadLock();
                try {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return (com.sap.mi.gfw.mm.pictograms.StyleContainer) wrapResult(getCastWrappedObject().getStyleContainer(connection, unwrapArg((com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) _Styles)));
                } finally {
                    synchronizationManager.releaseReadLock();
                }
       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return (com.sap.mi.gfw.mm.pictograms.StyleContainer) wrapResult(getCastWrappedObject().getStyleContainer(connection, unwrapArg((com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) _Styles))); 
        } catch (com.sap.tc.moin.repository.mmi.reflect.JmiException ex) {
            wrapJmiExceptionArgs(ex);
            throw ex;
        }
    }
    public boolean add(com.sap.mi.gfw.mm.pictograms.Style _Styles, com.sap.mi.gfw.mm.pictograms.StyleContainer _StyleContainer) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        try {
            if (synchronize) {
                synchronized (synchronizationManager.getProhibitWriteSyncObject()) {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return getCastWrappedObject().add(connection, unwrapArg((com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) _Styles), unwrapArg((com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) _StyleContainer));
                }       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return getCastWrappedObject().add(connection, unwrapArg((com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) _Styles), unwrapArg((com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) _StyleContainer)); 
        } catch (com.sap.tc.moin.repository.mmi.reflect.JmiException ex) {
            wrapJmiExceptionArgs(ex);
            throw ex;
        }
    }
    public boolean remove(com.sap.mi.gfw.mm.pictograms.Style _Styles, com.sap.mi.gfw.mm.pictograms.StyleContainer _StyleContainer) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        try {
            if (synchronize) {
                synchronized (synchronizationManager.getProhibitWriteSyncObject()) {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return getCastWrappedObject().remove(connection, unwrapArg((com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) _Styles), unwrapArg((com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) _StyleContainer));
                }       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return getCastWrappedObject().remove(connection, unwrapArg((com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) _Styles), unwrapArg((com.sap.tc.moin.repository.mmi.reflect.RefBaseObject) _StyleContainer)); 
        } catch (com.sap.tc.moin.repository.mmi.reflect.JmiException ex) {
            wrapJmiExceptionArgs(ex);
            throw ex;
        }
    }   

    public java.lang.Class<com.sap.mi.gfw.mm.pictograms.StyleContainerContainsStyles> get___JmiInterface() {
        return com.sap.mi.gfw.mm.pictograms.StyleContainerContainsStyles.class;
    }

    protected String metaObjectToString() {
        return "com.sap.mi.gfw.mm.pictograms.StyleContainerContainsStyles (Java Type)\npictograms.StyleContainerContainsStyles (MOF Type)"; //$NON-NLS-1$
    }    
}