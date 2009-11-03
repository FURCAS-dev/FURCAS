package com.sap.tc.moin.repository.jmigenerator.template;

import java.util.List;

/**
 * The Package interface template
 */
public interface JmiGeneratorPackageInterfaceTemplate extends JmiGeneratorInterfaceTemplate {

    /**
     * @return the constant for the package extent descriptor
     */
    public JmiGeneratorDescriptorConstant getPackageExtentDescriptorConstant( );

    /**
     * @return the constants
     */
    public List<JmiGeneratorConstant> getConstants( );

    /**
     * @return the (nested) packages
     */
    public List<JmiGeneratorPackageFeature> getRefPackages( );

    /**
     * @return the classes
     */
    public List<JmiGeneratorPackageFeature> getRefClasses( );

    /**
     * @return the associations
     */
    public List<JmiGeneratorPackageFeature> getRefAssociations( );

    /**
     * @return the structure types
     */
    public List<JmiGeneratorClassOperation> getStructureTypes( );

}
