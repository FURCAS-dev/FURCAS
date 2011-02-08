package com.sap.furcas.ide.editor.document;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.sap.furcas.ide.editor.commands.PrettyPrintCommand;
import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.unparser.SyntaxAndModelMismatchException;
import com.sap.furcas.unparser.extraction.textblocks.TextBlockTCSExtractorStream;


/**
 * Util classes helping to create TextBlock models for an existing rootObject.
 * 
 * @author Stephan Erb
 * 
 */
public class TbModelInitializationUtil {

    /**
     * Tries to pretty print a TextBlock model for a given rootObject
     */
    public static TextBlock initilizeTextBlocksFromModel(EObject rootObject, ConcreteSyntax syntax, EditingDomain editingDomain, AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory) throws SyntaxAndModelMismatchException {

        TextBlockTCSExtractorStream target = new TextBlockTCSExtractorStream(TextblocksPackage.eINSTANCE, parserFactory);
        PrettyPrintCommand ppCommand = new PrettyPrintCommand(rootObject, syntax, target);
        editingDomain.getCommandStack().execute(ppCommand);

        if (ppCommand.getPrettyPrintException() != null) {
            throw ppCommand.getPrettyPrintException();
        }

        return ppCommand.getPrintedResultRootBlock();
    }

}
