/**
 * 
 */
package com.sap.furcas.parser.tcs.bootstrap;


/**
 *
 */
public class TCSBootStrap {

    private static final String GENERATIONDIR = "./generationTmp/";
    private static final String GRAMMAR = GENERATIONDIR + "TCS.g";
    private static final String SYNTAXDEFINITION = "./syntaxdefinition/TCS.tcs";
    
    public static void main(String[] args)  {
        try {
//            File grammarFile = new File(GRAMMAR);
//            File syntaxDefFile = new File(SYNTAXDEFINITION);
//                   
//            
//            GrammarGenerator.buildGrammar(refScopeBean, targetConnection, syntaxDefFile, monitor, errorhandler, targetpackage, parserSuperClass)
//            
//            
//            Collection<String> warnings = GrammarWritingHelper.writeGrammarIfChanged(lookup, syntaxDefFile, grammarFile, "::", "com.sap.mi.textual.grammar.parser", connection, null);
//            for (String message : warnings) {
//                System.out.println("Warning: " + message);
//            }
//            System.out.println("Wrote grammar to " + grammarFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Grammar Generation Failed");
        } finally {
            
        }
    }
    
}
