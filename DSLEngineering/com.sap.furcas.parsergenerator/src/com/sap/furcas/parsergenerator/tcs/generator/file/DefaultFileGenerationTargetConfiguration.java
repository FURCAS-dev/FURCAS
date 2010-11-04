package com.sap.furcas.parsergenerator.tcs.generator.file;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

/**
 * Default grammar configuration that generates grammar and mapping to the folder
 * where the syntax definition is stored.
 * 
 * TODO: might make sense to extend / change this behavior.
 */
public class DefaultFileGenerationTargetConfiguration extends FileGenerationTargetConfiguration {

    private static final String GRAMMAR_ANTLR_POSTFIX = ".g";
    private static final String MAPPING_XMI_POSTFIX = "Mapping.xmi";
    

    public DefaultFileGenerationTargetConfiguration(IFile syntaxDefFile) {
        super(getPackageName(syntaxDefFile), getGrammarFile(syntaxDefFile), getMappingFile(syntaxDefFile));
    }

    private static IFile getGrammarFile(IFile syntaxDefFile) {
        IContainer directory = syntaxDefFile.getParent();
        String newFileName = getFileNameBase(syntaxDefFile) + GRAMMAR_ANTLR_POSTFIX;
        IFile newFile = directory.getFile(new Path(IPath.SEPARATOR + newFileName));
        return newFile;
    }

    private static String getFileNameBase(IFile file) {
        String fileName = file.getName();
        // "s m i  l e s".substring(1, 5) returns "mile"
        // 0 1 2 3 4 5
        String newFileName = fileName.substring(0, (fileName.length() - file.getFileExtension().length() - 1)); // -1
        return newFileName;
    }
    
    private static IFile getMappingFile(IFile syntaxDefFile) {
        IContainer directory = syntaxDefFile.getParent();
        String newFileName = getFileNameBase(syntaxDefFile) + MAPPING_XMI_POSTFIX;
        IFile newFile = directory.getFile(new Path(IPath.SEPARATOR + newFileName));
        return newFile;
    }
    
    /**
     * Returns the files path in package notation except for the filename,
     * or returns "generated" if no such path exists
     */
    private static String getPackageName(IFile file) {
        String targetPackage = null;
        IPath path = file.getParent().getProjectRelativePath();
        if (path != null && path.segmentCount() >= 2) { // source folder /
            // packagefolder1
            targetPackage = path.segment(1);
            for (int i = 2; i < path.segmentCount(); i++) {
                String segment = path.segment(i);
                targetPackage += '.' + segment;
            }
        } else {
            targetPackage = "generated";
        }
        return targetPackage;
    }
}
