package com.sap.ide.cts.editor.commands;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.commands.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.ide.cts.editor.CtsActivator;
import com.sap.ide.cts.editor.prettyprint.CtsPrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.CtsTextBlockTCSExtractorStream;
import com.sap.ide.cts.editor.prettyprint.SyntaxAndModelMismatchException;

public class PrettyPrintCommand extends Command {

	private final EObject refObject;
	private final ConcreteSyntax syntax;
	private final CtsTextBlockTCSExtractorStream target;
	private TextBlock result;

	public PrettyPrintCommand(EObject refObject, ConcreteSyntax syntax,
			CtsTextBlockTCSExtractorStream target, ResourceSet con) {
		super(con, "Pretty Print Full");
		this.refObject = refObject;
		this.syntax = syntax;
		this.target = target;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void doExecute() {
		try {
			CtsPrettyPrinter.prettyPrint(refObject, syntax, target, null, null);

			result = target.getRootBlock();
		} catch (SyntaxAndModelMismatchException e) {
			CtsActivator.logError(e);

			result = null;
		}
	}

	@Override
	public Collection<EOperation> getAffectedPartitions() {
		EObject partitionable = refObject;
		URI pri = partitionable.eResource().getURI();
		EOperation editOperation = new EOperation(
				EOperation.Operation.EDIT, pri);
		return Collections.singleton(editOperation);
	}

	public TextBlock getResult() {
		return result;
	}

}
