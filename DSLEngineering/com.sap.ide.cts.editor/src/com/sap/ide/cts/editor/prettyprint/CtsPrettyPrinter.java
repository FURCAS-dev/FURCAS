package com.sap.ide.cts.editor.prettyprint;

import tcs.ClassTemplate;
import tcs.ConcreteSyntax;

import com.sap.ide.cts.editor.prettyprint.imported.PrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.imported.TCSExtractorStream;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class CtsPrettyPrinter {

	public static void prettyPrint(RefObject source, ConcreteSyntax syntax,
			TCSExtractorStream target, ClassTemplate template, PrettyPrintContext context) throws SyntaxAndModelMismatchException {

		new PrettyPrinter().prettyPrint(source, syntax, target, template, context);

	}
}
