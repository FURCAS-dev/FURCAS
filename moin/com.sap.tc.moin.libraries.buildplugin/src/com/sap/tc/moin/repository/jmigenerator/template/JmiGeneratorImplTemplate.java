package com.sap.tc.moin.repository.jmigenerator.template;

/**
 * The common super interface for all java implementation generation templates.
 */
public interface JmiGeneratorImplTemplate extends JmiGeneratorBaseTemplate {

    /**
     * @return the template referring to the implemented interface
     */
    public JmiGeneratorInterfaceTemplate getInterface( );

}
