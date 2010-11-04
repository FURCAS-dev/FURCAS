package com.sap.furcas.parsergenerator.tcs.generator.file;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;

public class GrammarGenerationTargetConfiguration {

    private final String parserPackageName;
    private final IFile grammarFile;
    
    public GrammarGenerationTargetConfiguration(String parserPackageName, IFile grammarFile) {
        this.parserPackageName = parserPackageName;
        this.grammarFile = grammarFile;
    }
    
    public GrammarGenerationTargetConfiguration(IFile grammarFile) {
        this(getPackageName(grammarFile), grammarFile);
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
    
    public IFile getGrammarTargetFile() {
        return grammarFile;
    }

    public String getParserTargetPackageName() {
        return parserPackageName;
    }

}
