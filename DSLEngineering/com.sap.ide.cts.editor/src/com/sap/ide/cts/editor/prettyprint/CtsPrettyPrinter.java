package com.sap.ide.cts.editor.prettyprint;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.TCS.ClassTemplate;
import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.ide.cts.editor.prettyprint.imported.PrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.imported.TCSExtractorStream;

public class CtsPrettyPrinter {

	public static void prettyPrint(EObject source, ConcreteSyntax syntax,
			TCSExtractorStream target, ClassTemplate template, PrettyPrintContext context) throws SyntaxAndModelMismatchException {
		PrettyPrinter pp = new PrettyPrinter();
		if(target instanceof CtsTextBlockIncrementalTCSExtractorStream)
		{
			((CtsTextBlockIncrementalTCSExtractorStream) target).setPrettyPrinter(pp);
		}
		pp.prettyPrint(source, syntax, target, template, context);

	}
}
