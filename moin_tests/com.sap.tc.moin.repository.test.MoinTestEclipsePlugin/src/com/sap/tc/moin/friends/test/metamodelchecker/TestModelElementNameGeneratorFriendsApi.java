package com.sap.tc.moin.friends.test.metamodelchecker;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.sap.tc.moin.friends.ModelElementNameGenerator;
import com.sap.tc.moin.friends.factory.UtilitiesFactory;
import com.sap.tc.moin.friends.test.MoinFriendsBaseTest;

@SuppressWarnings( "nls" )
public class TestModelElementNameGeneratorFriendsApi extends MoinFriendsBaseTest {

    private ModelElementNameGenerator nameGenerator = null;

    @Override
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        nameGenerator = UtilitiesFactory.getModelElementNameGenerator( );
    }

    @Override
    public void afterTestMethod( ) throws Exception {

        nameGenerator = null;
        super.afterTestMethod( );
    }

    @Test
    public void testSimpleConcatenation( ) {
        // test with one word
        String[] words = new String[] { "word" };
        String expected = "Word";
        String actual = nameGenerator.buildMoinCompliantModelElementName( Arrays.<String> asList( words ), null );
        assertEquals( "The generated model element name should be \"" + expected + "\", but it was \"" + actual + "\".", expected, actual );

        // test with two and more words
        words = new String[] { "word1", "word2" };
        expected = "Word1Word2";
        actual = nameGenerator.buildMoinCompliantModelElementName( Arrays.<String> asList( words ), null );
        assertEquals( "The generated model element name should be \"" + expected + "\", but it was \"" + actual + "\".", expected, actual );
        words = new String[] { "prefix", "word1", "word2", "word3" };
        expected = "PrefixWord1Word2Word3";
        actual = nameGenerator.buildMoinCompliantModelElementName( Arrays.<String> asList( words ), null );
        assertEquals( "The generated model element name should be \"" + expected + "\", but it was \"" + actual + "\".", expected, actual );
    }

    @Test
    public void testNonSimpleConcatenation( ) {
        // test with non-7-bit ASCII characters in the words
        String[] words = new String[] { "word1", "!§$%&/()=?word2" };
        String expected = "Word1Word2";
        String actual = nameGenerator.buildMoinCompliantModelElementName( Arrays.<String> asList( words ), "prefix" );
        assertEquals( "The generated model element name should be \"" + expected + "\", but it was \"" + actual + "\".", expected, actual );
    }

    @Test
    public void testConcatenationWithPrefix( ) {
        // test with one valid word and prefix, the prefix should not be used
        String[] words = new String[] { "word" };
        String expected = "Word";
        String actual = nameGenerator.buildMoinCompliantModelElementName( Arrays.<String> asList( words ), "prefix" );
        assertEquals( "The generated model element name should be \"" + expected + "\", but it was \"" + actual + "\".", expected, actual );
        // test with digits at the beginning
        words = new String[] { "123word", "456word", "789word" };
        expected = "prefix123word456word789word";
        actual = nameGenerator.buildMoinCompliantModelElementName( Arrays.<String> asList( words ), "prefix" );
        assertEquals( "The generated model element name should be \"" + expected + "\", but it was \"" + actual + "\".", expected, actual );
    }

    @Test
    public void testWithErroneousWords( ) {
        String[] words = null;

        // null as a word list
        try {
            nameGenerator.buildMoinCompliantModelElementName( null, null );
            errorAndStop( "The word list is equals to null, should have thrown an IllegalArgumentException" );
        } catch ( IllegalArgumentException illegalArgumentEx ) {
        }

        // an empty word list
        try {
            nameGenerator.buildMoinCompliantModelElementName( new ArrayList<String>( ), null );
            errorAndStop( "The word list is empty, should have thrown an IllegalArgumentException" );
        } catch ( IllegalArgumentException illegalArgumentEx ) {
        }

        // null as a word in the word list
        words = new String[] { "word1", "word2", null, "word4", "word5" };
        try {
            nameGenerator.buildMoinCompliantModelElementName( Arrays.<String> asList( words ), null );
            errorAndStop( "The word list contains a word that is equals to null, should have thrown an IllegalArgumentException" );
        } catch ( IllegalArgumentException illegalArgumentEx ) {
        }
    }

    @Test
    public void testWithWordsLeadingToNullName( ) {
        String[] words = null;
        String expected = null;

        // the word list leads to null for the model element name
        // would start with a digit
        words = new String[] { "1", "2", "3", "4", "5" };
        String actual = nameGenerator.buildMoinCompliantModelElementName( Arrays.<String> asList( words ), null );
        assertEquals( "The generated model element name should be \"" + expected + "\", but it was \"" + actual + "\".", expected, actual );

        // contains only non 7-bit ASCII characters
        words = new String[] { "!", "§", "$", "%", "&" };
        actual = nameGenerator.buildMoinCompliantModelElementName( Arrays.<String> asList( words ), null );
        assertEquals( "The generated model element name should be \"" + expected + "\", but it was \"" + actual + "\".", expected, actual );

        // contains only non 7-bit ASCII characters, prefix is not considered
        words = new String[] { "!", "§", "$", "%", "&" };
        actual = nameGenerator.buildMoinCompliantModelElementName( Arrays.<String> asList( words ), "prefix" );
        assertEquals( "The generated model element name should be \"" + expected + "\", but it was \"" + actual + "\".", expected, actual );
    }
}
