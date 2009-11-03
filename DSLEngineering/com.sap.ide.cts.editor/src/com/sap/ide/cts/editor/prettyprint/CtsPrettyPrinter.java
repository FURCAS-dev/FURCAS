package com.sap.ide.cts.editor.prettyprint;

import tcs.ConcreteSyntax;

import com.sap.ide.cts.editor.prettyprint.imported.PrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.imported.TCSExtractorStream;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class CtsPrettyPrinter {

	public static void prettyPrint(RefObject source, ConcreteSyntax syntax,
			TCSExtractorStream target) throws SyntaxAndModelMismatchException {

		new PrettyPrinter().prettyPrint(source, syntax, target);

	}
}
