package com.sap.furcas.ocl.editor; 


import com.sap.furcas.ide.editor.AbstractGrammarBasedEditor;
import com.sap.furcas.ocl.parser.OclParserFactory;

public class OclEditor extends AbstractGrammarBasedEditor { 

	public OclEditor() { 

		super(new OclParserFactory(), new OclTokenMapper()); 
	} 

}
