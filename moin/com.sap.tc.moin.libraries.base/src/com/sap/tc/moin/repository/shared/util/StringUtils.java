package com.sap.tc.moin.repository.shared.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Locale;

/**
 * Collection of utility methods for string operations.
 */
public final class StringUtils {

    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    /**
     * Default delimiter character used for string composition.
     */
    public final static char SEP = '&';

    /**
     * Default escape character used for string composition.
     */
    public final static char ESC = '\\';

    // sb must only be used in non-recursive synchronized methods!
    // TODO: consider a pool of string builders rather than full synchronization
    private static final StringBuilder sb = new StringBuilder( );

    /**
     * Convenience method for String concatenation: allows null arguments and
     * uses a string builder with optimal capacity
     * 
     * @param args the objects to concatenate
     * @return the concatenated String
     */
    public static String concatenateUnsynced( Object... args ) {

        String[] sArgs = new String[args.length];
        int size = 0;

        // create strings from the object arguments and determine the total size of the concatenated string
        for ( int i = 0; i < args.length; i++ ) {
            if ( args[i] != null ) {
                sArgs[i] = args[i].toString( );
            } else {
                sArgs[i] = "null"; //$NON-NLS-1$
            }

            size += sArgs[i].length( );
        }

        StringBuilder actSb = new StringBuilder( size );
        for ( String s : sArgs ) {
            actSb.append( s );
        }
        return actSb.toString( );
    }

    /**
     * Optimized method to produce a concatenated String that contains the input
     * elements, separated by the SEP character; occurrences of the SEP
     * character or the ESC character within the input elements are escaped with
     * the ESC character.
     * 
     * @param input the input
     * @return the result
     */
    public static synchronized String combine( String[] input ) {

        // use default separator and escape characters
        return combine( input, SEP, ESC );
    }

    /**
     * Optimized method to produce a concatenated String that contains the input
     * elements, separated by the specified <code>delimiter</code> character;
     * occurrences of the <code>delimiter</code> character or the
     * <code>escape</code> character within the input elements are escaped with
     * the <code>escape</code> character. The elements are added to the
     * specified string builder <code>sb</code> (unsynchronized!). If input is
     * <code>null</code> or empty, the given string builder will be reset, i.e.
     * <code>sb.toString()</code> will result in an empty string after this
     * method call.
     * 
     * @param input the string array to combine
     * @param delimiter the delimiter character
     * @param escape the escape character
     * @return the result
     */
    public static synchronized String combine( String[] input, char delimiter, char escape ) {

        combine( input, delimiter, escape, sb );
        return sb.toString( );
    }

    /**
     * Optimized method to produce a concatenated String that contains the input
     * elements, separated by the specified <code>delimiter</code> character;
     * occurrences of the <code>delimiter</code> character or the
     * <code>escape</code> character within the input elements are escaped with
     * the <code>escape</code> character. The elements are added to the
     * specified string builder <code>sb</code> (unsynchronized!). If input is
     * <code>null</code> or empty, the given string builder will be reset, i.e.
     * <code>sb.toString()</code> will result in an empty string after this
     * method call.
     * 
     * @param input the string array to combine
     * @param delimiter the delimiter character
     * @param escape the escape character
     * @param actSb the string builder to use
     */
    public static void combine( String[] input, char delimiter, char escape, StringBuilder actSb ) {

        // reset the string builder (does preserve capacity)
        actSb.setLength( 0 );

        // check null or empty input
        if ( input == null || input.length == 0 ) {
            return;
        }

        // determine total size first and ensure buffer capacity
        int size = 0;
        for ( int i = 0; i < input.length; i++ ) {
            size += input[i].length( );
        }
        actSb.ensureCapacity( size + input.length + input.length );

        // append the all characters except the last and the delimiter
        for ( int i = 0; i < input.length - 1; i++ ) {
            appendEscaped( actSb, input[i], delimiter, escape );
            actSb.append( delimiter );
        }

        // append the last character
        appendEscaped( actSb, input[input.length - 1], delimiter, escape );
    }

    /**
     * Appends the specified input string to the specified string builder. Any
     * occurrence of the specified delimiter character or the specified escape
     * character are escaped with the escape character. Example for default
     * delimiter {@link #SEP} and escape {@link #ESC}: OOO&OOO&&OOO\\OOO\OOO ->
     * OOO\&OOO\&\&OOO\\\\OOO\\OOO
     * 
     * @param actSb the StringBuilder
     * @param input input
     * @param delimiter delimiter
     * @param escape escape
     */
    private static void appendEscaped( StringBuilder actSb, String input, char delimiter, char escape ) {

        if ( ( input.indexOf( delimiter ) < 0 ) && ( input.indexOf( escape ) < 0 ) ) {
            actSb.append( input );
        } else {
            for ( int i = 0; i < input.length( ); i++ ) {
                char c = input.charAt( i );
                if ( c == delimiter || c == escape ) {
                    actSb.append( escape );
                }
                actSb.append( c );
            }
        }
    }

    /**
     * Splits up the given string into a list of tokens. This method uses the
     * indexOf method rather than regular expressions and should be faster and
     * consume much less memory than the String.split() method.
     * 
     * @param aString the string to be split up
     * @param aSeparator the separator string which separates the tokens within
     * the string
     * @return a list of the tokens after the string is split up
     * @see String#split(java.lang.String)
     */
    public static String[] split( String aString, String aSeparator ) {

        int lastIndex = 0;
        int nextIndex = 0;
        int tokenCount = 0;

        // An empty String results in an empty result array
        if ( ( null == aString ) || ( aString.length( ) == 0 ) ) {
            return EMPTY_STRING_ARRAY;
        }

        // An empty separator results in a result array with just the string as result
        if ( ( null == aSeparator ) || ( aSeparator.length( ) == 0 ) ) {
            return new String[] { aString };
        }

        // First count the number of occurences of the separator string
        nextIndex = aString.indexOf( aSeparator );
        while ( nextIndex != -1 ) {
            tokenCount++;
            nextIndex = aString.indexOf( aSeparator, nextIndex + aSeparator.length( ) );
        }

        // if the separator did not occur in the string at all the original string
        // is the only entry in the result array
        if ( 0 == tokenCount ) {
            return new String[] { aString };
        }

        // More than one token, create the array of appropriate size
        String[] tokenArray = new String[tokenCount + 1];

        // And begin again to search for the tokens
        lastIndex = 0;
        tokenCount = 0;
        nextIndex = aString.indexOf( aSeparator );
        while ( nextIndex != -1 ) {
            tokenArray[tokenCount++] = aString.substring( lastIndex, nextIndex );
            lastIndex = nextIndex + aSeparator.length( );
            nextIndex = aString.indexOf( aSeparator, lastIndex );
        }

        // Copy the rest
        tokenArray[tokenCount] = aString.substring( lastIndex );
        return tokenArray;
    }

    /**
     * Splits up the given string into a list of tokens. This method uses the
     * indexOf method rather than regular expressions and should be faster and
     * consume much less memory than the String.split() method.
     * <p>
     * This method does not consider escaped characters!
     * 
     * @param aString the string to be split up
     * @param aSeparator the separator character which separates the tokens
     * within the string
     * @return a list of the tokens after the string is split up
     * @see String#split(java.lang.String)
     */
    public static String[] split( String aString, char aSeparator ) {

        int lastIndex = 0;
        int nextIndex = 0;
        int tokenCount = 0;

        // An empty String results in an empty result array
        if ( ( null == aString ) || ( aString.length( ) == 0 ) ) {
            return EMPTY_STRING_ARRAY;
        }

        // First count the number of occurrences of the separator string
        for ( int i = aString.length( ) - 1; i >= 0; --i ) {
            if ( aString.charAt( i ) == aSeparator ) {
                ++tokenCount;
            }
        }

        // if the separator did not occur in the string at all the original string
        // is the only entry in the result array
        if ( 0 == tokenCount ) {
            return new String[] { aString };
        }

        // More than one token, create the array of appropriate size
        String[] tokenArray = new String[tokenCount + 1];

        // And begin again to search for the tokens
        lastIndex = 0;
        tokenCount = 0;
        nextIndex = aString.indexOf( aSeparator );
        while ( nextIndex != -1 ) {
            tokenArray[tokenCount++] = aString.substring( lastIndex, nextIndex );
            lastIndex = nextIndex + 1;
            nextIndex = aString.indexOf( aSeparator, lastIndex );
        }

        // Copy the rest
        tokenArray[tokenCount] = aString.substring( lastIndex );
        return tokenArray;
    }

    /**
     * Splits up the given string into a list of tokens. This method uses the
     * indexOf method rather than regular expressions and should be faster and
     * consume much less memory than the String.split() method.
     * <p>
     * This method <b>does</b> consider escaped characters! It removes all
     * escape characters <code>escapeChar</code> from the input string , i.e.
     * this method performs the reverse operation to method
     * {@link #combine(String[], char, char)}: for any string array s,
     * split(combine(s, d, e), d, e) equals s.
     * 
     * @param aString the string to be split up
     * @param aSeparator the separator character which separates the tokens
     * within the string
     * @param aEscapeChar a character used to escape delimiters when
     * constructing the sequence
     * @return a list of the tokens after the string is split up
     * @see String#split(java.lang.String)
     */
    public static String[] split( String aString, char aSeparator, char aEscapeChar ) {

        int lastIndex = 0;
        int tokenCount = 0;

        // An empty String results in an empty result array
        if ( ( null == aString ) || ( aString.length( ) == 0 ) ) {
            return EMPTY_STRING_ARRAY;
        }

        // First count the number of occurrences of the separator string
        // if a separator is preceded by an escape char, it is not counted as token 
        // also determine if there are escape chars at all
        boolean hasEscapeChars = false;
        for ( int i = aString.length( ) - 1; i >= 1; --i ) {
            if ( aString.charAt( i ) == aSeparator ) {
                if ( aString.charAt( i - 1 ) != aEscapeChar ) {
                    ++tokenCount;
                } else {
                    hasEscapeChars = true;
                }
            }
        }

        if ( aString.charAt( 0 ) == aSeparator ) {
            ++tokenCount;
        }

        // if the separator did not occur in the string at all the original string
        // is the only entry in the result array
        if ( 0 == tokenCount ) {
            return new String[] { aString };
        }

        // More than one token, create the array of appropriate size
        String[] tokenArray = new String[tokenCount + 1];

        // And begin again to search for the tokens
        lastIndex = 0;
        tokenCount = 0;

        // if there are escape characters in a token, we use a string builder for
        // constructing the unescaped token; otherwise, we directly use the substring
        StringBuilder currentTokenBuilder = hasEscapeChars ? new StringBuilder( ) : null;

        // the current token
        String token;

        // flag denoting if the direct predecessor character is an escape char
        boolean predecessorIsEscape = false;

        // we re-use the hasEscapeChars flag - this time, it's for the current token
        hasEscapeChars = false;
        char c = aString.charAt( 0 );
        if ( c == aSeparator ) {
            tokenArray[tokenCount++] = ""; //$NON-NLS-1$
            lastIndex = 1;
        } else if ( c == aEscapeChar ) {
            predecessorIsEscape = true;
            // we don't have to use the builder for the very first token, we simply increment
            // the index and keep the hasEscapeChars false
            lastIndex = 1;
        }

        for ( int i = 1; i < aString.length( ); i++ ) {
            c = aString.charAt( i );
            if ( c == aSeparator ) {
                if ( !predecessorIsEscape ) {
                    if ( !hasEscapeChars ) {
                        // if there are no escape chars in the current token,
                        // we can directly take it from the original string
                        token = aString.substring( lastIndex, i );
                    } else {
                        // if there was at least 1 escape char in the current token,
                        // we have to take if form the builder

                        // append the current substring to the builder
                        currentTokenBuilder.append( aString.substring( lastIndex, i ) );

                        // then assign it to the token
                        token = currentTokenBuilder.toString( );

                        // and reset it
                        currentTokenBuilder.setLength( 0 );
                    }

                    tokenArray[tokenCount++] = token;
                    lastIndex = i + 1;
                }
                // reset the direct predecessor flag and the escape chars flag for the next token                
                predecessorIsEscape = false;
                hasEscapeChars = false;
            } else if ( c == aEscapeChar ) {
                // put the current substring into the builder, but omit the escape char
                currentTokenBuilder.append( aString.substring( lastIndex, i ) );
                lastIndex = i + 1;
                predecessorIsEscape = true;
                hasEscapeChars = true;
            } else {
                predecessorIsEscape = false;
            }
        }

        // Copy the rest
        tokenArray[tokenCount] = aString.substring( lastIndex );
        return tokenArray;
    }

    /**
     * Takes the given multi-line String and prepends to each line the given
     * number of spaces.
     * 
     * @param aString the String
     * @param numberOfLeadingSpaces number of spaces to indent
     * @return the result
     */
    public static String indentString( String aString, int numberOfLeadingSpaces ) {

        char[] indentation = new char[numberOfLeadingSpaces];
        for ( int i = 0; i < numberOfLeadingSpaces; i++ ) {
            indentation[i] = ' ';
        }
        StringBuilder indentedString = new StringBuilder( );
        BufferedReader reader = null;
        try {
            reader = new BufferedReader( new StringReader( aString ) );
            String line = null;
            int i = 0;
            while ( ( line = reader.readLine( ) ) != null ) {
                if ( i == 0 ) {
                    indentedString.append( line );
                } else {
                    indentedString.append( indentation ).append( line );
                }
                indentedString.append( "\n" ); //$NON-NLS-1$
                i++;
            }
        } catch ( IOException e ) {
            throw new RuntimeException( e );
        } finally {
            try {
                if ( reader != null ) {
                    reader.close( );
                }
            } catch ( IOException e ) {
                throw new RuntimeException( e );
            }
        }
        return indentedString.toString( );
    }

    /**
     * @param input input
     * @return result
     */
    public static String convertFirstCharToLower( String input ) {

        return input.substring( 0, 1 ).toLowerCase( Locale.ENGLISH ) + input.substring( 1 );
    }

    /**
     * @param input input
     * @return result
     */
    public static String convertFirstCharToUpper( String input ) {

        return input.substring( 0, 1 ).toUpperCase( Locale.ENGLISH ) + input.substring( 1 );
    }

    /**
     * Split a CamelCase String into a String separated by the specified
     * <code>separatorString</code>.
     * <p>
     * Example: unCamelize("isAbstract", "_") results in "IS_ABSTRACT"
     * 
     * @param inputString the String you wish to split
     * @param separatorString separator
     * @return result
     */
    public static String unCamelize( final String inputString, final String separatorString ) {

        if ( inputString == null || inputString.length( ) == 0 || separatorString == null || separatorString.length( ) == 0 ) {
            return inputString;
        }
        StringBuilder result = new StringBuilder( );
        boolean inited = false;
        boolean mode = false;
        int insertedSeparators = 0;
        for ( int i = 0, n = inputString.length( ); i < n; i++ ) {
            char c = inputString.charAt( i );
            if ( ( c >= 'a' && c <= 'z' ) || ( c >= 'A' && c <= 'Z' ) ) {
                if ( !inited ) {
                    mode = Character.isLowerCase( c );
                    inited = true;
                    result.append( c );
                } else {
                    boolean lowerCase = Character.isLowerCase( c );
                    if ( mode == lowerCase ) {
                        result.append( c );
                    } else {
                        mode = lowerCase;
                        if ( !lowerCase ) {
                            // lowercase -> uppercase switch
                            result.append( separatorString );
                            insertedSeparators++;
                        } else {
                            // uppercase -> lowercase switch
                            if ( i > 2 && Character.isUpperCase( inputString.charAt( i - 2 ) ) ) {
                                result.insert( i - 1 + ( insertedSeparators * separatorString.length( ) ), separatorString );
                            }
                        }
                        result.append( c );
                    }
                }
            } else {
                result.append( c );
            }
        }
        return result.toString( );
    }
}