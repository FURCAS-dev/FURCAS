package com.sap.tc.moin.repository.jmigenerator.template;

/**
 * The Enumeration Label
 */
public interface JmiGeneratorEnumLabel {

    /**
     * @return the publicly visible name
     */
    public String getName( );

    /**
     * @return the internal name used in the <code>XyzEnum.class</code>
     */
    public String getJavaName( );

}
