package com.sap.mi.tcs.editor;

import java.util.Collection;

import org.eclipse.core.runtime.CoreException;

import textblocks.TextBlock;

import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.tcs.parser.TcsParserFactory;
import com.sap.mi.textual.epi.conf.IProjectMetaRefConf;
import com.sap.mi.textual.epi.conf.ProjectMetaRefConfFactory;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;

public class TcsEditor extends AbstractGrammarBasedEditor {

    // private IModelInjector defaultInjector = new
    // DummyModelInjector(MyActionsParser.tokenNames);;

    public TcsEditor() {
	super(new TcsParserFactory(), new TcsMapper());
    }

    @Override
    public TextBlock parse(TextBlock rootBlock) throws SemanticParserException {
	Connection connection = getWorkingConnection();
	initializeNewParser(connection);
	// Call super implementation to do the actual stuff
	TextBlock newRoot = super.parse(rootBlock);

	return newRoot;
    }

    @Override
    protected Collection<PRI> getAdditionalLookupPRIS() {
	try {
	    IProjectMetaRefConf conf = ProjectMetaRefConfFactory
		    .getConfig(ModelAdapter.getInstance().getProject(
			    getWorkingConnection()));
	    Collection<PRI> priScope = conf.getMetaLookUpForProject()
		    .getReferencePRIs();
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
