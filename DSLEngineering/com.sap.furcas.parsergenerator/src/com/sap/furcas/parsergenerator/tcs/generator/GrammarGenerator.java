package com.sap.furcas.parsergenerator.tcs.generator;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.parsergenerator.tcs.generator.errorhandling.GenerationErrorHandler;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.utils.projects.ReferenceScopeBean;

/**
 * The Class GrammarGenerationBuildHelper.
 */
public class GrammarGenerator {

    /**
     * Assumes file is a Syntax definition, parses that file, creates a grammar
     * file in the same directory, and returns it.
     * 
     * @param refScopeBean
     *            the lookup
     * @param file
     *            the file
     * @param monitor
     *            the monitor
     * @param errorhandler
     *            the errorhandler
     * @param qualifiedNamesSeparator
     * @param targetpackage
     * @param parserSuperClass
     * 
     * @return the generated grammar file
     * 
     * @throws CoreException
     *             the core exception
     */
    public static IFile buildGrammar(ReferenceScopeBean refScopeBean, ResourceSet targetConnection, IFile file,
	    IProgressMonitor monitor, GenerationErrorHandler errorhandler, String targetpackage,
	    Class<? extends ObservableInjectingParser> parserSuperClass) throws CoreException {

	IFile newFile = getGrammarFile(file);
	monitor.worked(10);

	// IContainer directory = file.getParent();

	GrammarGenerationHelper.writeGrammarIfChanged(file, refScopeBean, targetConnection, newFile, monitor, errorhandler,
		targetpackage, parserSuperClass);
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
	String newFileName = fileName.substring(0, (fileName.length() - file.getFileExtension().length() - 1)); // -1
														// for
														// the
														// dot
	return newFileName;
    }


    /**
     * returns the name of the grammarfile that would be created in build.
     */
    public static IFile[] getFilesForClean(IFile file) {
	IFile[] files = new IFile[5];

	files[0] = getGrammarFile(file);

	IContainer directory = file.getParent();
	String newFileName = getFileNameBase(file) + "Parser.java";
	files[1] = directory.getFile(new Path(IPath.SEPARATOR + newFileName));
	newFileName = getFileNameBase(file) + "Lexer.java";
	files[2] = directory.getFile(new Path(IPath.SEPARATOR + newFileName));
	newFileName = getFileNameBase(file) + "__.g";
	files[3] = directory.getFile(new Path(IPath.SEPARATOR + newFileName));
	newFileName = getFileNameBase(file) + ".tokens";
	files[4] = directory.getFile(new Path(IPath.SEPARATOR + newFileName));

	return files;
    }

}
