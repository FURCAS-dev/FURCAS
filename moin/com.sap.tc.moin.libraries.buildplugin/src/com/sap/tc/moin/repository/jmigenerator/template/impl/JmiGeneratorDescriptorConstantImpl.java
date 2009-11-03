package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.List;

import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorDescriptorConstant;


public class JmiGeneratorDescriptorConstantImpl extends JmiGeneratorConstantImpl implements JmiGeneratorDescriptorConstant {

    private final List<String> myComponents;

    public JmiGeneratorDescriptorConstantImpl( String visibility, String type, String name, String value, List<String> components ) {

        super( visibility, type, name, value );
        this.myComponents = components;
    }

    public List<String> getComponents( ) {

        return this.myComponents;
    }

}
