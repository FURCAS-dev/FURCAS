package com.sap.furcas.ocl.parser;

import generated.OclLexer;
import generated.OclParser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.ocl.editor.Activator;

public class OclParserFactory extends AbstractParserFactory<OclParser, OclLexer> {

    private static final String LANGUAGE_ID = "Ocl";

    @Override
    public Class<OclLexer> getLexerClass() {
	return OclLexer.class;
    }

    @Override
    public Class<OclParser> getParserClass() {
	return OclParser.class;
	}

    @Override
    public String getLanguageId() {
        return LANGUAGE_ID;
    }

	@Override 
    public EPackage getMetamodelPackage(ResourceSet connection) { 
        return EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/ocl/1.1.0/Ecore"); 
    } 


	@Override
	public String[] getHiddenChannelTokenNames() {
	    return new String[] { "WS", "NL", "COMMENT" };
	}
	
	@Override 
        public URI getSyntaxUri() { 
            return URI.createPlatformPluginURI(Activator.PLUGIN_ID + "/mappings/Ocl.tcs", true); 
        } 
	
	@Override
        public Set<URI> getParserLookupScope(ResourceSet connection) {
	    //TODO add ocl std lib
                return new HashSet<URI>(Arrays.asList(URI.createURI(EcorePackage.eINSTANCE.getNsURI())));
        }
	
}
