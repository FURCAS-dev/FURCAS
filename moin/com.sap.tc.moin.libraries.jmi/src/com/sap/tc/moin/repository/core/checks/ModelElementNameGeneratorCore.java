package com.sap.tc.moin.repository.core.checks;

import java.util.List;

public class ModelElementNameGeneratorCore {

    public static String buildMoinCompliantModelElementName( List<String> words, String prefix ) {
        if ( words == null ) {
            throw new IllegalArgumentException( "The parameter \"words\" is null." ); //$NON-NLS-1$
        }
        if ( words.size( ) == 0 ) {
            throw new IllegalArgumentException( "The Parameter \"words\" is empty." ); //$NON-NLS-1$
        }
        if ( prefix != null && !ModelElementNameChecker.isValidMofModelElementName( prefix, false ) ) {
            throw new IllegalArgumentException( "The prefix is not a valid MOIN name." ); //$NON-NLS-1$
        }
        StringBuilder result = new StringBuilder( );
        for ( String word : words ) {
            if ( word == null ) {
                throw new IllegalArgumentException( "One element of the Parameter \"words\" is null." ); //$NON-NLS-1$
            }
            result.append( removeInvalidMoinCharactersAndFirstCharacterToUpperCase( word ) );
        }
        if ( result.length( ) == 0 ) {
            return null;
        }
        String resultString = ensureFirstCharacterIsUpperCaseLetter( result.toString( ), prefix );
        if ( resultString == null || resultString.length( ) == 0 ) {
            return null;
        }
        return resultString;
    }

    private static String removeInvalidMoinCharactersAndFirstCharacterToUpperCase( String word ) {

        StringBuilder sb = new StringBuilder( );
        boolean isFirst = true;
        for ( int i = 0; i < word.length( ); i++ ) {
            char c = word.charAt( i );
            if ( ModelElementNameChecker.analyzeMofModelElementNameCharacter( c, false, null ) == null ) {
                if ( isFirst ) {
                    sb.append( Character.toUpperCase( c ) );
                    isFirst = false;
                } else {
                    sb.append( c );
                }
            }
        }
        return sb.toString( );
    }

    private static String ensureFirstCharacterIsUpperCaseLetter( String name, String prefix ) {

        if ( !Character.isLetter( name.charAt( 0 ) ) ) {
            // the first character is not a letter,
            // append the prefix at the beginning, if present
            if ( prefix != null ) {
                return prefix + name;
            } else {
                return null;
            }
        }
        // name is not empty and its first character is a letter,
        // upper case it
        if ( Character.isUpperCase( name.charAt( 0 ) ) ) {
            return name;
        } else {
            StringBuilder sb = new StringBuilder( );
            sb.append( Character.toUpperCase( name.charAt( 0 ) ) );
            if ( name.length( ) == 1 ) {
                // end of size
            } else {
                sb.append( name.subSequence( 1, name.length( ) ) );
            }
            return sb.toString( );
        }
    }
}
