package com.sap.furcas.parsergenerator.tcs.generator;

import java.io.File;
import java.util.ArrayList;

import org.antlr.Tool;
import org.antlr.tool.ANTLRErrorListener;
import org.antlr.tool.ErrorManager;
import org.antlr.tool.Message;
import org.antlr.tool.ToolMessage;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.sap.furcas.parsergenerator.GenerationErrorHandler;

public class ParserGenerator {

    private static class DelegatingANTLRErrorListener implements ANTLRErrorListener {
        private final GenerationErrorHandler errorhandler;

        public DelegatingANTLRErrorListener(GenerationErrorHandler errorhandler) {
            this.errorhandler = errorhandler;
        }

        @Override
        public void error(Message arg0) {
            errorhandler.error(arg0);
        }

        @Override
        public void error(ToolMessage arg0) {
            errorhandler.error(arg0);
        }

        @Override
        public void info(String arg0) {
            errorhandler.info(arg0);
        }

        @Override
        public void warning(Message arg0) {
            errorhandler.warn(arg0);
        }
    };
    
    /**
     * Reads the ANTLR grammar from the given grammar file and compiles it to java.
     * The lexer and parser will be placed in the same folder as the grammar file. 
     */
    public static void buildParser(File grammarfile, GenerationErrorHandler errorhandler) {
        buildParser(grammarfile, errorhandler, new NullProgressMonitor());
    }

    /**
     * Reads the ANTLR grammar from the given grammar file and compiles it to java.
     * The lexer and parser will be placed in the same folder as the grammar file. 
     */
    public static void buildParser(File grammarfile, GenerationErrorHandler errorhandler, IProgressMonitor monitor) {
        monitor.beginTask("Compiling Parser from ANTLR Grammar", 10);
	
        ArrayList<String> argList = new ArrayList<String>();
	// see http://antlr.org/wiki/display/ANTLR3/Command+line+options
	// args[0] = "-Xwatchconversion";
	// args[1] = "-Xdfaverbose";

	// argList.add("-lib");
	// argList.add(grammarfile.getParent().getRawLocation().toOSString());
	// // does not work, ANTLR does not look in lib for grammar

	argList.add(grammarfile.getAbsolutePath());
	argList.add("-report");

	String[] args = argList.toArray(new String[argList.size()]);

	// attempt to restore the original listener afterwards, so that other
	// tools are not affected.
	ANTLRErrorListener previousListener = org.antlr.tool.ErrorManager.getErrorListener();

	ANTLRErrorListener listener = new DelegatingANTLRErrorListener(errorhandler);
	try {
	    ErrorManager.setErrorListener(listener);
	    Tool antlr = new Tool(args);
	    antlr.process();
	} finally {
	    // restore original Listener
	    ErrorManager.setErrorListener(previousListener);
	    monitor.done();
	}
    }
    
}
