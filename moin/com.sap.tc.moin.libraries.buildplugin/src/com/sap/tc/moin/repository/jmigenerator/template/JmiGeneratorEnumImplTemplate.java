package com.sap.tc.moin.repository.jmigenerator.template;

import java.util.List;

/**
 * The Enumeration implementation template
 */
public interface JmiGeneratorEnumImplTemplate extends JmiGeneratorImplTemplate {

    /**
     * @return the labels
     */
    public List<JmiGeneratorEnumLabel> getEnumLabels( );

    /**
     * @return the fully qualified Java implementation type
     */
    public String getImplementationType( );

    /**
     * @return the type; this is actually stored as List<String>
     */
    public List<String> getType( );

    public String getQualifiedNameForStringArrayInitializer( );

    public List<String> getQualifiedName( );
}
