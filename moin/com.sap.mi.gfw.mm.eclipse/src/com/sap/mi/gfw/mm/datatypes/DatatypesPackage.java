/**
 * Generated by the MOIN Generator Version 3.0
 **/

package com.sap.mi.gfw.mm.datatypes;

/**
 * This interface is not intended to be implemented by clients.
 */
public interface DatatypesPackage extends com.sap.tc.moin.repository.mmi.reflect.RefPackage
{
    /**
     * Extent descriptor
     */
    public final com.sap.tc.moin.repository.mmi.descriptors.PackageDescriptor<com.sap.mi.gfw.mm.datatypes.DatatypesPackage> PACKAGE_DESCRIPTOR = new com.sap.tc.moin.repository.mmi.descriptors.PackageDescriptor<com.sap.mi.gfw.mm.datatypes.DatatypesPackage>("45E806E3DB1DD427F30649EE07AB9667E4BD8C17", "sap.com/com/sap/mi/gfw/mm", "datatypes"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ 
    // classes
    public com.sap.tc.moin.repository.mmi.reflect.RefClass getViewPort();
    public com.sap.tc.moin.repository.mmi.reflect.RefClass getColor();
    // structure type creators
    public com.sap.mi.gfw.mm.datatypes.Point createPoint(com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer<? super com.sap.mi.gfw.mm.datatypes.Point> structureFieldContainer) throws com.sap.tc.moin.repository.mmi.reflect.JmiException;
}