package com.sap.furcas.ide.editor.commands;

import org.eclipse.emf.common.command.AbstractCommand;

import com.sap.furcas.ide.editor.CtsActivator;
import com.sap.furcas.ide.editor.imp.services.FurcasParseController;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;

public class ParseCommand extends AbstractCommand {

    private final TextBlock oldBlock;
    private TextBlock newBlock;
    private SemanticParserException parseException;
    private final FurcasParseController parseController;

    public ParseCommand(TextBlock oldBlock, FurcasParseController parseController) {
        super("Incremental Parse and Model Update");
        this.oldBlock = oldBlock;
        this.parseController = parseController;
    }

    @Override
    public boolean canExecute() {
        return true;
    }

    @Override
    public void execute() {
        try {
            newBlock = parseController.parse(oldBlock);
        } catch (SemanticParserException e) {
            parseException = e;
        } catch (Exception e) {
            CtsActivator.logError(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void redo() {

    }

    public TextBlock getNewBlock() {
        return newBlock;
    }

    public SemanticParserException getParseException() {
        return parseException;
    }

}
