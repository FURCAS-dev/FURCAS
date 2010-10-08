package com.sap.mi.tcs.editor;

import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.editor.prettyprint.imported.ModelAdapter;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;
import com.sap.mi.tcs.parser.TcsParserFactory;
import com.sap.mi.textual.epi.conf.IProjectMetaRefConf;
import com.sap.mi.textual.epi.conf.ProjectMetaRefConfFactory;


public class TcsEditor extends AbstractGrammarBasedEditor {

    // private IModelInjector defaultInjector = new
    // DummyModelInjector(MyActionsParser.tokenNames);;

    public TcsEditor() {
	super(new TcsParserFactory(), new TcsMapper());
    }

    @Override
    public TextBlock parse(TextBlock rootBlock) throws SemanticParserException {
	ResourceSet connection = getWorkingConnection();
	initializeNewParser(connection);
	// Call super implementation to do the actual stuff
	TextBlock newRoot = super.parse(rootBlock);

	return newRoot;
    }

    @Override
    protected Collection<URI> getAdditionalLookupURIS() {
	try {
	    IProjectMetaRefConf conf = ProjectMetaRefConfFactory
		    .getConfig(ModelAdapter.getInstance().getProject(
			    getWorkingConnection()));
	    Collection<URI> priScope = conf.getMetaLookUpForProject()
		    .getReferenceURIs();
	    return priScope;
	} catch (IllegalStateException e) {
	    // no dsl nature
	    // do nothing
	} catch (CoreException e) {
	    // no dsl nature
	    // do nothing
	}

	return null;
    }

}
