package com.sap.tc.moin.repository.core.checks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class JavaIdentifierCheck {

    private static Set<String> JAVA_KEYWORDS_AND_RESERVED_WORDS = new HashSet<String>( Arrays.asList( new String[] { "abstract", //$NON-NLS-1$
        "assert", //$NON-NLS-1$
        "boolean", //$NON-NLS-1$
        "break", //$NON-NLS-1$
        "byte", //$NON-NLS-1$
        "case", //$NON-NLS-1$
        "catch", //$NON-NLS-1$
        "char", //$NON-NLS-1$
        "class", //$NON-NLS-1$
        "const", //$NON-NLS-1$
        "continue", //$NON-NLS-1$
        "default", //$NON-NLS-1$
        "do", //$NON-NLS-1$
        "double", //$NON-NLS-1$
        "else", //$NON-NLS-1$
        "enum", //$NON-NLS-1$
        "extends", //$NON-NLS-1$
        "false", //$NON-NLS-1$
        "final", //$NON-NLS-1$
        "finally", //$NON-NLS-1$
        "float", //$NON-NLS-1$
        "for", //$NON-NLS-1$
        "goto", //$NON-NLS-1$
        "if", //$NON-NLS-1$
        "implements", //$NON-NLS-1$
        "import", //$NON-NLS-1$
        "instanceof", //$NON-NLS-1$
        "int", //$NON-NLS-1$
        "interface", //$NON-NLS-1$
        "long", //$NON-NLS-1$
        "native", //$NON-NLS-1$
        "new", //$NON-NLS-1$
        "null", //$NON-NLS-1$
        "package", //$NON-NLS-1$
        "private", //$NON-NLS-1$
        "protected", //$NON-NLS-1$
        "public", //$NON-NLS-1$
        "return", //$NON-NLS-1$
        "short", //$NON-NLS-1$
        "static", //$NON-NLS-1$
        "strictfp", //$NON-NLS-1$
        "super", //$NON-NLS-1$
        "switch", //$NON-NLS-1$
        "synchronized", //$NON-NLS-1$
        "this", //$NON-NLS-1$
        "throw", //$NON-NLS-1$
        "throws", //$NON-NLS-1$
        "transient", //$NON-NLS-1$
        "true", //$NON-NLS-1$
        "try", //$NON-NLS-1$
        "void", //$NON-NLS-1$
        "volatile", //$NON-NLS-1$
        "while" } ) ); //$NON-NLS-1$

    private JavaIdentifierCheck( ) {

        // do not use
    }

    public static final boolean isJavaKeyWord( String s ) {

        return JAVA_KEYWORDS_AND_RESERVED_WORDS.contains( s );
    }

    public static final boolean isValid7BitAscii( char c ) {

        return c < 0x80;
    }

//    public static void main( String[] args ) {
//
//        check( null, false );
//        check( "#Hello", false );
//        check( "H#ello", false );
//        check( "_Hello", false );
//        check( "__Hello", false );
//        check( "___Hello", false );
//        check( "_a__Hello", false );
//        check( "__a_Hello", false );
//        check( "____Hello", false );
//        check( "_____Hello", false );
//        check( "______Hello", false );
//        check( "H_ello", false );
//        check( "-Hello", false );
//        check( "H-ello", false );
//        check( ".Hello", false );
//        check( "H.ello", false );
//        check( "~Hello", false );
//        check( "H~ello", false );
//        check( ":Hello", false );
//        check( "H:ello", false );
//        check( ">H>ello", false );
//        check( "H>ello", false );
//        check( "$Hello", false );
//        check( "H$ello", false );
//        check( "1Hello", false );
//        check( "H1ello", true );
//        check( "Hello123", true );
//        check( "Hell\\", false );
//        check( "\\Hello", false );
//        check( "Hell�", false );
//        check( "�Hello", false );
//        check( "short", false );
//        check( "shorty", true );
//        check( "Class", true );
//        check( "Package", true );
//        check(
//               "abstractassertbooleanbreakbytecasecatchcharclassconstcontinuedefaultdodoubleelseenumextendsfalsefinalfinallyfloatforgotoifimplementsimportinstanceofintinterfacelongnativenewnullpackageprivateprotectedpublicreturnshortstaticstrictfpsuperswitchsynchronizedthisthrowthrowstransienttruetryvoidvolatilewhile",
//               true );
//    }
//
//    private static void check( String identifier, boolean valid ) {
//
//        double timems = System.nanoTime( );
//        boolean result = ModelElementNameCheck.isValidModelElementName( identifier );
//        timems = ( System.nanoTime( ) - timems ) / 1000000d;
//        String timeout = " " + timems + " [ms]";
//        if ( result == valid ) {
//            System.out.println( identifier + " " + valid + " -> " + result + timeout );
//        } else {
//            System.err.println( identifier + " " + valid + " -> " + result + timeout + " --> PANIC" );
//        }
//    }
}
