package com.sap.ap.cts.editor;

//import java.util.Iterator;

//import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.ap.cts.monet.parser.PackageParserFactory;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;


//import data.classes.SapClass;

public class PackageEditor extends AbstractGrammarBasedEditor {

	public PackageEditor() {
		super(new PackageParserFactory(), new PackageMapper());
	}

	@Override
	public TextBlock parse(TextBlock rootBlock) throws SemanticParserException {
		ResourceSet connection = getWorkingConnection();
		initializeNewParser(connection);
		TextBlock newRoot =  super.parse(rootBlock);
		return newRoot;
	}
}
