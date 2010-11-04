package com.sap.furcas.runtime.common.implementation;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import com.sap.furcas.runtime.common.exceptions.ParserGeneratorInvocationException;
import com.sap.furcas.runtime.common.interfaces.TCSParserGenerator;
import com.sap.furcas.runtime.common.interfaces.TCSParserGeneratorFactory;

public class TCSParserGeneratorFactoryImpl implements TCSParserGeneratorFactory {

    private final String extensionPointId = "com.sap.furcas.parsergenerator.tcsparsergenerator";
    
    @Override
    public TCSParserGenerator createTCSParserGenerator() throws ParserGeneratorInvocationException {
        
        IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(extensionPointId);
        
        if(configurationElements.length != 1){
            throw new ParserGeneratorInvocationException("Expected to find 1 TCSParsergenerator but found "+configurationElements.length);
        }
        
        for (IConfigurationElement configurationElement : configurationElements) {
            Object object;
            try {
                object = configurationElement.createExecutableExtension("class");
                if (object instanceof TCSParserGenerator) {
                    return ((TCSParserGenerator) object);
                }
            } catch (CoreException e) {
              throw new ParserGeneratorInvocationException(e);
            }

        }
        throw new AssertionError("Cannot happen");
    }

}
