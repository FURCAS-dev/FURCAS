package com.sap.ide.cts.editor.prettyprint;

import tcs.ConcreteSyntax;

import com.sap.ide.cts.editor.prettyprint.imported.PrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.imported.TCSExtractorStream;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class IncrementalPrettyPrinter extends PrettyPrinter
{

	@Override
	public void prettyPrint(RefObject source, ConcreteSyntax syntax, TCSExtractorStream target) throws SyntaxAndModelMismatchException
	{
		System.out.println();
		super.prettyPrint(source, syntax, target);
	}
	
}
