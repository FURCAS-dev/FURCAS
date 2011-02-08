package com.sap.furcas.ide.editor.commands;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.ide.editor.CtsActivator;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.unparser.PrettyPrinter;
import com.sap.furcas.unparser.SyntaxAndModelMismatchException;
import com.sap.furcas.unparser.extraction.textblocks.TextBlockTCSExtractorStream;

public class PrettyPrintCommand extends AbstractCommand {

    private final EObject modelElement;
    private final ConcreteSyntax syntax;
    private final TextBlockTCSExtractorStream target;
    
    private TextBlock result;
    private SyntaxAndModelMismatchException prettyPrintException;

    public PrettyPrintCommand(EObject modelElement, ConcreteSyntax syntax, TextBlockTCSExtractorStream target) {
        super("Pretty Print");
        this.modelElement = modelElement;
        this.syntax = syntax;
        this.target = target;
    }

    @Override
    public boolean canExecute() {
        return true;
    }

    @Override
    public void execute() {
        try {
            PrettyPrinter prettyPrinter = new PrettyPrinter();
            prettyPrinter.prettyPrint(modelElement, syntax, target);

            result = target.getPrintedResultRootBlock();
        } catch (SyntaxAndModelMismatchException e) {
            prettyPrintException = e;
        } catch (Exception e) {
            CtsActivator.logError(e);
            throw new RuntimeException(e);
        }
    }

    public TextBlock getPrintedResultRootBlock() {
        return result;
    }

    public SyntaxAndModelMismatchException getPrettyPrintException() {
        return prettyPrintException;
    }

    @Override
    public void redo() {

    }

}
