package com.sap.tc.moin.repository.jmigenerator;

import java.util.List;

/**
 * The generated code
 */
public interface JmiGeneratorPathCodePair {

    /**
     * @return the relative path (as dictated by the Java package of the
     * generated class
     */
    public List<String> getRelativePath( );

    /**
     * @return the file name (as dictated by the Java class name)
     */
    public String getFileName( );

    /**
     * @return the file extension
     */
    public String getFileExtension( );

    /**
     * @return the generated code
     */
    public String getCode( );

}
