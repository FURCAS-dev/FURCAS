package com.sap.tc.moin.repository.core.checks;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.Tag;

import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.VariableDeclaration;
import org.omg.ocl.types.CollectionType;

public class ModelElementNameChecker {

    enum ErrorCode {
        IS_NULL, LENGTH_IS_NULL, FIRST_CHAR_IS_NOT_LETTER, CHAR_IS_NOT_LETTER_DIGIT_UNDERSCORE, CHAR_IS_NOT_ASCII, IS_JAVA_KEYWORD
    }

    /**
     * Checks if the given name complies to the MOIN recommendation on model
     * element names. The only deviation from MOF is, that Java keywords and
     * white spaces are not allowed.
     */
    static final ErrorCode analyzeMoinModelElementName( String name, boolean whiteSpaceAllowed, List<Object> objectsInError ) {

        if ( objectsInError == null ) {
            objectsInError = new ArrayList<Object>( );
        } else {
            objectsInError.clear( );
        }
        ErrorCode errorCode = analyzeMofModelElementName( name, whiteSpaceAllowed, objectsInError );
        if ( errorCode != null ) {
            return errorCode;
        }
        if ( JavaIdentifierCheck.isJavaKeyWord( name ) ) {
            objectsInError.add( name );
            return ErrorCode.IS_JAVA_KEYWORD;
        }
        return null;
    }

    /**
     * Checks if the given name complies to the MOF recommendation on model
     * element names. The only deviation from MOF is, that white spaces are not
     * allowed.
     */
    static final ErrorCode analyzeMofModelElementName( String name, boolean whiteSpaceAllowed, List<Object> objectsInError ) {

        if ( objectsInError == null ) {
            objectsInError = new ArrayList<Object>( );
        } else {
            objectsInError.clear( );
        }
        if ( name == null ) {
            objectsInError.add( name );
            return ErrorCode.IS_NULL;
        }
        if ( name.length( ) == 0 ) {
            objectsInError.add( name );
            return ErrorCode.LENGTH_IS_NULL;
        }
        char[] nameChars = name.toCharArray( );
        if ( !Character.isLetter( nameChars[0] ) ) {
            objectsInError.add( name );
            objectsInError.add( nameChars[0] );
            return ErrorCode.FIRST_CHAR_IS_NOT_LETTER;
        }
        for ( int i = 1; i < nameChars.length; i++ ) {
            ErrorCode errorCode = analyzeMofModelElementNameCharacter( nameChars[i], whiteSpaceAllowed, null );
            if ( errorCode != null ) {
                switch ( errorCode ) {
                    case CHAR_IS_NOT_LETTER_DIGIT_UNDERSCORE:
                        objectsInError.add( name );
                        objectsInError.add( i );
                        objectsInError.add( nameChars[i] );
                        return ErrorCode.CHAR_IS_NOT_LETTER_DIGIT_UNDERSCORE;
                    case CHAR_IS_NOT_ASCII:
                        objectsInError.add( name );
                        objectsInError.add( i );
                        objectsInError.add( nameChars[i] );
                        return ErrorCode.CHAR_IS_NOT_ASCII;
                }
            }
        }
        return null;
    }

    static boolean isValidMofModelElementName( String name, boolean whiteSpaceAllowed ) {
        return analyzeMofModelElementName( name, whiteSpaceAllowed, null ) == null;
    }

    static final ErrorCode analyzeMofModelElementNameCharacter( char c, boolean whiteSpaceAllowed, List<Object> objectsInError ) {
        if ( objectsInError == null ) {
            objectsInError = new ArrayList<Object>( );
        } else {
            objectsInError.clear( );
        }
        if ( Character.isSpaceChar( c ) && whiteSpaceAllowed ) {
            return null;
        }
        if ( !Character.isLetter( c ) && !Character.isDigit( c ) && c != '_' ) {
            objectsInError.add( c );
            return ErrorCode.CHAR_IS_NOT_LETTER_DIGIT_UNDERSCORE;
        }
        if ( !JavaIdentifierCheck.isValid7BitAscii( c ) ) {
            objectsInError.add( c );
            return ErrorCode.CHAR_IS_NOT_ASCII;
        }
        return null;
    }

    static boolean isModelElementSpecialCase( ModelElement modelElement ) {

        if ( modelElement instanceof Parameter && modelElement.getName( ).equals( "*return" ) ) { //$NON-NLS-1$
            return true;
        }
        if ( modelElement instanceof Tag || modelElement instanceof CollectionType || modelElement instanceof VariableDeclaration || modelElement instanceof OclExpression ) {
            return true;
        }
        if ( modelElement instanceof VariableDeclaration || modelElement instanceof OclExpression ) {
            return true;
        }
        if ( modelElement instanceof MofPackage && modelElement.getName( ).startsWith( "OclGenerated_" ) ) { //$NON-NLS-1$
            return true;
        }
        return false;
    }

    private static boolean isLegalMoinModelElementNameStartCharacter( char c ) {

        if ( !isLegalMoinModelElementNamePartCharacter( c ) ) {
            return false;
        }
        if ( !Character.isJavaIdentifierStart( c ) ) {
            return false;
        }
        if ( c == '_' ) {
            return false;
        }
        return true;
    }

    private static boolean isLegalMoinModelElementNamePartCharacter( char c ) {

        if ( Character.isLetter( c ) ) {
            return true;
        }
        if ( Character.isDigit( c ) ) {
            return true;
        }
        if ( c == '_' ) {
            return true;
        }
        if ( c == '$' ) {
            return true;
        }
        return false;
    }

    static boolean isEmptyMofModelElementName( String name ) {

        if ( name == null || name.length( ) == 0 ) {
            return true;
        }
        return false;
    }
}
