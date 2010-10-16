/**
 * 
 */
package com.sap.furcas.parsergenerator.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Util class for the specialized task of finding ocurrences of "@lexer::members [[ ... ]]" within a String
 * cutting out he occurences, and returning the contents within the brackets. 
 */
public class LexerStringMemberExtractor {

    private static final String LEXERMEMBER = "@lexer::members";
    private static final String LEXERMEMBER_OPEN = "[[";
    private static final String LEXERMEMBER_CLOSE = "]]";
    
    private String cutLexerString;
    private List<String> contentParts;
    
    public LexerStringMemberExtractor(String lexerString) throws InvalidLexerStringException {
        StringBuilder resultLexerString = new StringBuilder(lexerString.length());
        contentParts =  cutLexerMembers(lexerString, resultLexerString, 0);
     
        cutLexerString = resultLexerString.toString();
    }
    
    /**
     * @return the cutLexerString
     */
    public String getCutLexerString() {
        return cutLexerString;
    }

    /**
     * @return the contentParts
     */
    public List<String> getContentParts() {
        return contentParts;
    }

    /**
     * to be called recursively. Adds to the Stringbuilder the parts of the string excluding "@lexer::members [[...]]"
     * and returns a list of all the contents within such brackets.
     * @param lexerString
     * @param resultLexerString
     * @param startIndex
     * @return
     * @throws InvalidLexerStringException if syntax format is violated
     */
    private static List<String> cutLexerMembers(String lexerString, StringBuilder resultLexerString, int startIndex) throws InvalidLexerStringException {
    
        int index = lexerString.indexOf(LEXERMEMBER, startIndex);
        if ( index >= 0) {
            int searchIndex = index + LEXERMEMBER.length();

            // find the relevant region by finding start an end brackets
            int bracketStart = lexerString.indexOf(LEXERMEMBER_OPEN, searchIndex);
            int bracketEnd = lexerString.indexOf(LEXERMEMBER_CLOSE, searchIndex);
            
            // check sanity
            if (bracketStart == -1) {
                throw new InvalidLexerStringException("Missing opening brackets " + LEXERMEMBER_OPEN + " after " + LEXERMEMBER);
            } else if (bracketEnd == -1) {
                throw new InvalidLexerStringException("Missing closing brackets " + LEXERMEMBER_CLOSE + " after " + LEXERMEMBER);
            } else if (bracketEnd < bracketStart) {
                throw new InvalidLexerStringException("Closing brackets " + LEXERMEMBER_CLOSE + " before opening brackets after " + LEXERMEMBER);
            } else {
                String substring = lexerString.substring(searchIndex, bracketStart);
                if (! substring.trim().matches("")) {
                    throw new InvalidLexerStringException("Bad characters after " + LEXERMEMBER + " :" +  substring);
                }    
            }
            
            String content = lexerString.substring(bracketStart + LEXERMEMBER_OPEN.length(), bracketEnd);
            resultLexerString.append(lexerString.substring(startIndex, index));
            // search in the remaining bits
            List<String> othermembers = cutLexerMembers(lexerString, resultLexerString, bracketEnd + LEXERMEMBER_CLOSE.length());
            othermembers.add(0, content);
            return othermembers;
        } else { // lexermember not found in the remaining bit
            resultLexerString.append(lexerString.substring(startIndex, lexerString.length()));
            return new ArrayList<String>();
        }
        
    }

    public static class InvalidLexerStringException extends Exception  {
        private static final long serialVersionUID = -2103938980689077911L;
        public InvalidLexerStringException(String message) {
            super(message);
        }
    }
}
