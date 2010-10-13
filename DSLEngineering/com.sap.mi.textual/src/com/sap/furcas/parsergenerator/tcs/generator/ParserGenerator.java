package com.sap.furcas.parsergenerator.tcs.generator;

import java.util.ArrayList;

import org.antlr.Tool;
import org.antlr.tool.ANTLRErrorListener;
import org.antlr.tool.ErrorManager;
import org.antlr.tool.Message;
import org.antlr.tool.ToolMessage;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;

import com.sap.furcas.parsergenerator.tcs.generator.errorhandling.EclipseMarkerUtil;
import com.sap.furcas.parsergenerator.tcs.generator.errorhandling.GenerationErrorHandler;

public class ParserGenerator {

    private static class MyANTLRErrorListener implements ANTLRErrorListener {
	private final GenerationErrorHandler errorhandler;

	/**
	 * @param errorhandler
	 */
	public MyANTLRErrorListener(GenerationErrorHandler errorhandler) {
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
     * Builds the parser.
     * 
     * @param grammarfile
     *            the grammarfile
     * @param mymonitor
     *            the mymonitor
     * @param errorhandler
     */
    public static void buildParser(IFile grammarfile, IProgressMonitor mymonitor, GenerationErrorHandler errorhandler) {
	EclipseMarkerUtil.deleteMarkers(grammarfile);

	ArrayList<String> argList = new ArrayList<String>();
	// see http://antlr.org/wiki/display/ANTLR3/Command+line+options
	// args[0] = "-Xwatchconversion";
	// args[1] = "-Xdfaverbose";

	// argList.add("-lib");
	// argList.add(grammarfile.getParent().getRawLocation().toOSString());
	// // does not work, ANTLR does not look in lib for grammar

	argList.add(grammarfile.getRawLocation().toOSString());
	argList.add("-report");

	String[] args = argList.toArray(new String[argList.size()]);

	// attempt to restore the original listener afterwards, so that other
	// tools are not affected.
	ANTLRErrorListener previousListener = org.antlr.tool.ErrorManager.getErrorListener();

	ANTLRErrorListener listener = new MyANTLRErrorListener(errorhandler);
	try {
	    ErrorManager.setErrorListener(listener);

	    Tool antlr = new Tool(args);
	    antlr.process();

	} finally {
	    // restore original Listener
	    ErrorManager.setErrorListener(previousListener);
	}
	if (mymonitor != null) {
	    mymonitor.worked(70);
	}
    }
    
}
