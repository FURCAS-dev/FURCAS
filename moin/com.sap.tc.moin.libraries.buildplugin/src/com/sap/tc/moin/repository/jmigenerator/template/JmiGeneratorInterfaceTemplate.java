package com.sap.tc.moin.repository.jmigenerator.template;


/**
 * The common super interface for all java interface generation templates.
 */
public interface JmiGeneratorInterfaceTemplate extends JmiGeneratorBaseTemplate {

    /**
     * @return the Javadoc for an element
     */
    public JmiGeneratorJavadoc getJavadoc( );

    /**
     * @return <code>true</code> if this is a client-facing interface
     */
    public boolean isInterface( );
}
