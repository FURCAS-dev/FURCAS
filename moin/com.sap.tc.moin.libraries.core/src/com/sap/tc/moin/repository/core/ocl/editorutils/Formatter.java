package com.sap.tc.moin.repository.core.ocl.editorutils;

import java.util.TreeMap;

import com.sap.tc.moin.ocl.parser.gen.OclLexerGen;
import com.sap.tc.moin.ocl.parser.gen.OclParserGen;
import com.sap.tc.moin.ocl.parser.gen.oclAst.Node;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.shared.util.ProcessReportImpl;


/**
 * The actual formatter implementation
 */
public class Formatter {

    /** Newline: nl */
    public static final String NEWLINE = "nl"; //$NON-NLS-1$

    /** Indentation: in */
    public static final String INDENT = "in"; //$NON-NLS-1$

    /** Single line comment: -- */
    private static final String SINGLELINECOMMENT = "--"; //$NON-NLS-1$

    /** Tab: \t */
    public static final String TAB = "\t"; //$NON-NLS-1$

    /** Multi line comment start: /* */
    private static final String MULTILINECOMMENTSTART = "/*"; //$NON-NLS-1$

    /** Multi line comment end: *&#47; */
    private static final String MULTILINECOMMENTEND = "*/"; //$NON-NLS-1$

    private TreeMap<Integer, String> comments = new TreeMap<Integer, String>( );

    /**
     * @param constraint constraint
     * @return the formatted string
     */
    public String format( String constraint ) {

        String actComments = getComments( constraint );
        ProcessReportImpl report = new ProcessReportImpl( 1 );
        OclLexerGen lexer = new OclLexerGen( actComments.toCharArray( ), "OCL", report, 4 ); //$NON-NLS-1$
        OclParserGen parser = new OclParserGen( lexer, report );

        lexer.lexer( parser );

        Node ast = parser.parser( );
        if ( ast == null ) {
            return actComments;
        }

        FormatterVisitor visitor = new FormatterVisitor( parser, actComments, this.comments );
        ast.accept( visitor );

        return visitor.getResult( );
    }

    /**
     * Collects all single- and multiline comments and puts them into
     * {@link TreeMap} comments<Integer offset, String comment>. The Comments
     * 
     * @param constraint
     * @return TODO the stripped constraint?
     */
    private String getComments( String actConstraint ) {

        this.comments.clear( );

        String constraint = actConstraint;
        String lineDelimiter = System.getProperty( "line.separator" ); //$NON-NLS-1$
        int offset = 0;
        while ( offset < constraint.length( ) ) {
            int sstart = constraint.indexOf( SINGLELINECOMMENT, offset );
            int mstart = constraint.indexOf( MULTILINECOMMENTSTART, offset );
            if ( sstart == -1 && mstart == -1 ) {
                return constraint;
            }
            int end;
            int start;
            boolean single = ( Math.min( sstart, mstart ) == sstart ) != ( Math.min( sstart, mstart ) == -1 );
            if ( single ) {
                end = constraint.indexOf( lineDelimiter, sstart );
                start = sstart;

            } else {
                end = constraint.indexOf( MULTILINECOMMENTEND, mstart );
                start = mstart;
            }
            if ( end == -1 ) {
                end = constraint.length( );
            }

            int lineOffset = constraint.substring( 0, start ).lastIndexOf( lineDelimiter );
            if ( lineOffset == -1 ) {
                lineOffset = 0;
            } else
                lineOffset += lineDelimiter.length( );

            String offsetString = constraint.substring( lineOffset, start );
            // boolean lineStart = offsetString.matches( "\\s*" );
            // boolean indent = !( offsetString.length( ) == 0 );

            String header = OclConstants.EMPTY;
            if ( offsetString.matches( "\\s*" ) ) { //$NON-NLS-1$
                header += NEWLINE;
                if ( !( offsetString.length( ) == 0 ) ) {
                    header += INDENT;
                }
            }

            if ( single ) {
                String comment = constraint.substring( sstart, end );
                this.comments.put( Integer.valueOf( sstart ), header + comment + NEWLINE );
            } else {
                String comment = constraint.substring( mstart + 2, end ).trim( );
                boolean endLine;
                try {
                    endLine = removeHeadingWS( constraint.substring( end + 2 ) ).startsWith( lineDelimiter );
                } catch ( IndexOutOfBoundsException e ) {
                    endLine = true;
                    constraint += MULTILINECOMMENTEND;
                }
                if ( endLine ) {
                    this.comments.put( Integer.valueOf( mstart ), header + MULTILINECOMMENTSTART + OclConstants.SPACE + comment + OclConstants.SPACE + MULTILINECOMMENTEND + NEWLINE );
                } else {
                    this.comments.put( Integer.valueOf( mstart ), header + MULTILINECOMMENTSTART + OclConstants.SPACE + comment + OclConstants.SPACE + MULTILINECOMMENTEND );
                }
            }
            offset = end;
        }
        return constraint;
    }

    private String removeHeadingWS( String actString ) {

        String string = actString;
        while ( string.startsWith( OclConstants.SPACE ) || string.startsWith( TAB ) ) {
            string = string.substring( 1 );
        }
        return string;
    }

}
