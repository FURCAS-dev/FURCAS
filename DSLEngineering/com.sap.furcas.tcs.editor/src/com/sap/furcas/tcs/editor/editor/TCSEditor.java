package com.sap.furcas.tcs.editor.editor; 


import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;

import com.sap.furcas.ide.dslproject.conf.IProjectMetaRefConf;
import com.sap.furcas.ide.dslproject.conf.ProjectMetaRefConfFactory;
import com.sap.furcas.ide.editor.AbstractGrammarBasedEditor;
import com.sap.furcas.ide.editor.document.ModelEditorInput;
import com.sap.furcas.tcs.editor.parser.TCSParserFactory;

public class TCSEditor extends AbstractGrammarBasedEditor { 

	public TCSEditor() { 

		super(new TCSParserFactory(), new TCSTokenMapper()); 
	}

    @Override
    protected Set<URI> getAdditionalLookupURIS() {
        try {
            IProjectMetaRefConf conf = ProjectMetaRefConfFactory
                    .getConfig(((ModelEditorInput) getEditorInput()).getProject());
            Set<URI> priScope = conf.getMetaLookUpForProject()
                    .getReferenceScope();
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
