package com.sap.furcas.ide.editor.document;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.PartInitException;

import com.sap.furcas.ide.editor.commands.PrettyPrintCommand;
import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.unparser.extraction.textblocks.TextBlockTCSExtractorStream;


/**
 * Util classes required to get a corresponding rootBlock for an existing
 * rootObject.
 * 
 * @author D049157
 * 
 */
public class TbModelInitializationUtil {

    /**
     * Tries to pretty print a TextBlock model for a given rootObject
     */
    public static TextBlock initilizeTextBlocksFromModel(EObject rootObject, ConcreteSyntax syntax, EditingDomain editingDomain, AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory) throws PartInitException {

        TextBlockTCSExtractorStream target = new TextBlockTCSExtractorStream(TextblocksPackage.eINSTANCE, parserFactory);
        PrettyPrintCommand ppCommand = new PrettyPrintCommand(rootObject, syntax, target);
        editingDomain.getCommandStack().execute(ppCommand);

        if (ppCommand.getPrettyPrintException() != null) {
            throw new PartInitException("Failed to pretty print " + rootObject, ppCommand.getPrettyPrintException());
        }

        return ppCommand.getPrintedResultRootBlock();
    }

}
