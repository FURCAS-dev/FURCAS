package com.sap.furcas.parsergenerator.tcs.generator.file;

import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class FileGenerationSourceConfiguration {
    
    private final IFile syntaxDefFile;
    private final ResourceSet resourceSet;
    private final Set<URI> referenceScope;

    public FileGenerationSourceConfiguration(IFile syntaxDefFile, ResourceSet resourceSet, Set<URI> referenceScope) {
        this.syntaxDefFile = syntaxDefFile;
        this.resourceSet = resourceSet;
        this.referenceScope = referenceScope;
    }

    public IFile getSyntaxDefinitionFile() {
       return syntaxDefFile;
    }

    public ResourceSet getResourceSet() {
        return resourceSet;
    }

    public Set<URI> getReferenceScope() {
       return referenceScope;
    }

}
