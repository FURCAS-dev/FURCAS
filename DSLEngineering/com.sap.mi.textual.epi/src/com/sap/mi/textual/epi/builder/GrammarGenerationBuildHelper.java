package com.sap.mi.textual.epi.builder;

import java.util.ArrayList;
import java.util.logging.ErrorManager;

import javax.tools.Tool;


import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.mi.textual.epi.conf.ReferenceScopeBean;
import com.sap.mi.textual.epi.errors.GrammarGenerationErrorHandler;
import com.sap.mi.textual.epi.util.EclipseMarkerUtil;
import com.sap.mi.textual.epi.util.ToolClassesGenerationHelper;




/**
 * The Class GrammarGenerationBuildHelper.
 */
public class GrammarGenerationBuildHelper {

	/**
	 * Assumes file is a Syntax definition, parses that file, creates a grammar file in the same directory, and returns it.
	 * 
	 * @param refScopeBean the lookup
	 * @param file the file
	 * @param monitor the monitor
	 * @param errorhandler the errorhandler
	 * @param qualifiedNamesSeparator 
	 * @param targetpackage 
	 * @param parserSuperClass 
	 * 
	 * @return the generated grammar file
	 * 
	 * @throws CoreException the core exception
	 */
	public static IFile buildGrammar(ReferenceScopeBean refScopeBean, ResourceSet targetConnection, IFile file, IProgressMonitor monitor, GrammarGenerationErrorHandler errorhandler, String targetpackage, Class<? extends ObservableInjectingParser> parserSuperClass) throws CoreException {

		

		IFile newFile = getGrammarFile(file);
		monitor.worked(10);


//		IContainer directory = file.getParent();
		
        ToolClassesGenerationHelper.writeGrammarIfChanged(file, refScopeBean, targetConnection, newFile, monitor, errorhandler, targetpackage, parserSuperClass);
		// was grammar file written (implies has changed)?
		// grammar without errors?
		return newFile;
	}
	
	private static IFile getGrammarFile(IFile file) {
        IContainer directory = file.getParent();
        
        String newFileName = getFileNameBase(file) + ".g";
        IFile newFile = directory.getFile(new Path(IPath.SEPARATOR + newFileName));
        return newFile;
	}
	

	private static String getFileNameBase(IFile file) {
	    String fileName = file.getName();
        // "s m i  l e s".substring(1, 5) returns "mile"
        // 0 1 2 3 4 5
        String newFileName = fileName.substring(0,
                ( fileName.length() - file.getFileExtension().length()  - 1 ) ); // -1 for the dot
        return newFileName;
	}
	
	/**
	 * Builds the parser.
	 * 
	 * @param grammarfile the grammarfile
	 * @param mymonitor the mymonitor
	 * @param errorhandler 
	 */
	public static void buildParser(IFile grammarfile, IProgressMonitor mymonitor, GrammarGenerationErrorHandler errorhandler) {
	    EclipseMarkerUtil.deleteMarkers(grammarfile);

	    ArrayList<String> argList = new ArrayList<String>();
//	    see http://antlr.org/wiki/display/ANTLR3/Command+line+options
//	    args[0] = "-Xwatchconversion";
//	    args[1] = "-Xdfaverbose";
	    
//	    argList.add("-lib");
//	    argList.add(grammarfile.getParent().getRawLocation().toOSString()); // does not work, ANTLR does not look in lib for grammar
	    
	    argList.add(grammarfile.getRawLocation().toOSString());
	    argList.add("-report");

	    String[] args = argList.toArray(new String[argList.size()]);
	    
	    // attempt to restore the original listener afterwards, so that other tools are not affected.
	    ANTLRErrorListener previousListener = ErrorManager.getErrorListener();

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

	/**
	 * returns the name of the grammarfile that would be created in build.
	 */
	public static IFile[] getFilesForClean(IFile file) {
	    IFile[] files = new IFile[5];

	    files[0] = getGrammarFile(file);

	    IContainer directory = file.getParent();
	    String newFileName =getFileNameBase(file) + "Parser.java";
	    files[1] = directory.getFile(new Path(IPath.SEPARATOR + newFileName));
	    newFileName =getFileNameBase(file) + "Lexer.java";
	    files[2] = directory.getFile(new Path(IPath.SEPARATOR + newFileName));
	    newFileName =getFileNameBase(file) + "__.g";
	    files[3] = directory.getFile(new Path(IPath.SEPARATOR + newFileName));
	    newFileName =getFileNameBase(file) + ".tokens";
        files[4] = directory.getFile(new Path(IPath.SEPARATOR + newFileName));
        
        return files;
	}
	
	private static class MyANTLRErrorListener implements ANTLRErrorListener {
	    private GrammarGenerationErrorHandler errorhandler;
        /**
         * @param errorhandler
         */
	    public MyANTLRErrorListener(GrammarGenerationErrorHandler errorhandler) {
	        this.errorhandler = errorhandler;
	    }

	    public void error(Message arg0) {
	        errorhandler.error(arg0);
        }

        public void error(ToolMessage arg0) {
            errorhandler.error(arg0);
        }

        public void info(String arg0) {
            errorhandler.info(arg0);
        }

        public void warning(Message arg0) {
            errorhandler.warn(arg0);
        }};
}
