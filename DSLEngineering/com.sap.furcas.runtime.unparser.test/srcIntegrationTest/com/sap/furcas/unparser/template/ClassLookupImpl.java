package com.sap.furcas.unparser.template;

import com.sap.furcas.runtime.parser.testbase.ClassLookup;


/**
 * Default interface implementation for com.sap.furcas.parsergenerator.test package.
 * 
 * @author Sebastian Schlag (D049672)
 *
 */
public class ClassLookupImpl implements ClassLookup {

    @Override
    public Class<?> loadClass(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }

}
