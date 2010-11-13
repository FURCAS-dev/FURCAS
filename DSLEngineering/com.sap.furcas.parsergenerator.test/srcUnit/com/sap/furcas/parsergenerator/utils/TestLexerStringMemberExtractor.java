/**
 * 
 */
package com.sap.furcas.parsergenerator.utils;

import static com.sap.furcas.runtime.parser.testutils.StringListHelper.list;
import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Test;

import com.sap.furcas.parsergenerator.util.LexerStringMemberExtractor;
import com.sap.furcas.parsergenerator.util.LexerStringMemberExtractor.InvalidLexerStringException;

/**
 *
 */
public class TestLexerStringMemberExtractor {

   
    @Test
    public void testLexerStringMemberExtractor() throws InvalidLexerStringException {
        LexerStringMemberExtractor ext = new LexerStringMemberExtractor("test1@lexer::members [[contenttest]]test2");
        assertEquals("test1test2", ext.getCutLexerString());
        assertEquals(list("contenttest"), ext.getContentParts());
    }
    
    @Test
    public void testLexerStringMemberExtractorStart() throws InvalidLexerStringException {
        LexerStringMemberExtractor ext = new LexerStringMemberExtractor("test1@lexer::members [[contenttest]]");
        assertEquals("test1", ext.getCutLexerString());
        assertEquals(list("contenttest"), ext.getContentParts());
    }
    
    @Test
    public void testLexerStringMemberEnd() throws InvalidLexerStringException {
        LexerStringMemberExtractor ext = new LexerStringMemberExtractor("@lexer::members [[contenttest]]test2");
        assertEquals("test2", ext.getCutLexerString());
        assertEquals(list("contenttest"), ext.getContentParts());
    }
    
    @Test
    public void testLexerStringMemberNone() throws InvalidLexerStringException {
        LexerStringMemberExtractor ext = new LexerStringMemberExtractor("test2");
        assertEquals("test2", ext.getCutLexerString());
        assertEquals(Collections.EMPTY_LIST, ext.getContentParts());
    }
    
    @Test
    public void testLexerStringMemberExtractorDouble() throws InvalidLexerStringException {
        LexerStringMemberExtractor ext = new LexerStringMemberExtractor("test1@lexer::members [[contenttest]]test2@lexer::members [[contenttest2]]test3");
        assertEquals("test1test2test3", ext.getCutLexerString());
        assertEquals(list("contenttest", "contenttest2"), ext.getContentParts());
    }
    
    
    @Test (expected=InvalidLexerStringException.class )
    public void testLexerStringMemberInvalidbefore() throws InvalidLexerStringException {
        new LexerStringMemberExtractor("test1@lexer::members lalala [[contenttest]]test2");
    }
    
    @Test (expected=InvalidLexerStringException.class )
    public void testLexerStringMemberInvalidBrackets() throws InvalidLexerStringException {
        new LexerStringMemberExtractor("test1@lexer::members lalala [[contenttesttest2");
    }
    
    @Test (expected=InvalidLexerStringException.class )
    public void testLexerStringMemberInvalidBrackets2() throws InvalidLexerStringException {
        new LexerStringMemberExtractor("test1@lexer::members lalala content]]testtest2");
    }
    @Test (expected=InvalidLexerStringException.class )
    public void testLexerStringMemberInvalidBrackets3() throws InvalidLexerStringException {
        new LexerStringMemberExtractor("test1@lexer::members]][[ lalala contenttesttest2");
    }
}
