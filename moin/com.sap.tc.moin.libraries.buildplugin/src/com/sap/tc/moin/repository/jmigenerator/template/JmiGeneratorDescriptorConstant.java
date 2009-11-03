package com.sap.tc.moin.repository.jmigenerator.template;

import java.util.List;

/**
 * The constant subclass for descriptors
 */
public interface JmiGeneratorDescriptorConstant extends JmiGeneratorConstant {

    /**
     * @return the components (MofID, container name, qualified name) used for
     * the constructor
     */
    public List<String> getComponents( );
}
