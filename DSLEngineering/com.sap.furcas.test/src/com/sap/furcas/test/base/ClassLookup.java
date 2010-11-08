package com.sap.furcas.test.base;

/**
 * This interface is used by {@link GeneratedParserBasedTest} to load the compiled parser- and lexer-classes from your test project's "generated" folder.
 * Each test project must have a default implementation of this interface in order to allow the classloader to find the generated files.
 * The default implementation of this interface is: 
 * 
 * return Class.forName(className);
 * 
 * 
 * @author Sebastian Schlag (D049672)
 *
 */
public interface ClassLookup {
    
    public Class<?> loadClass(String className) throws ClassNotFoundException;

}
