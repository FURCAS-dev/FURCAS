package com.sap.furcas.parsergenerator;

import java.io.File;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * File-based configuration bean for the {@link TCSParserGenerator}.  
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class GrammarGenerationSourceConfiguration {
    
    private final File syntaxDefFile;
    private final ResourceSet resourceSet;
    private final Set<URI> referenceScope;

    public GrammarGenerationSourceConfiguration(File syntaxDefFile, ResourceSet resourceSet, Set<URI> referenceScope) {
        this.syntaxDefFile = syntaxDefFile;
        this.resourceSet = resourceSet;
        this.referenceScope = referenceScope;
    }

    public File getSyntaxDefinitionFile() {
       return syntaxDefFile;
    }

    public ResourceSet getResourceSet() {
        return resourceSet;
    }

    public Set<URI> getReferenceScope() {
       return referenceScope;
    }
}
