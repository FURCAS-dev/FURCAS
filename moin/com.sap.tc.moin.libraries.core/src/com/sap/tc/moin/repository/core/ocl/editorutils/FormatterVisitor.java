package com.sap.tc.moin.repository.core.ocl.editorutils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import lpg.lpgjavaruntime.IToken;

import com.sap.tc.moin.ocl.parser.gen.OclParserGen;
import com.sap.tc.moin.ocl.parser.gen.oclAst.*;
import com.sap.tc.moin.ocl.utils.OclConstants;

/**
 * Formatter Visitor
 */
public class FormatterVisitor extends AbstractOclAstVisitor {

    final TreeMap<Integer, String> comments;

    private class LineBreak implements Comparable<LineBreak> {

        int offset;

        String indent;

        int compPrio;

        LineBreak( int actOffset, String actIndent, int actPrio, boolean additionalIndent ) {

            this.offset = actOffset;
            this.indent = actIndent;
            if ( additionalIndent ) {
                this.indent += FormatterVisitor.this.indentation;
            }
            this.compPrio = actPrio;
        }

        public int compareTo( LineBreak o ) {

            int tmp = this.compPrio - o.compPrio;
            if ( tmp == 0 ) {
                tmp = this.offset - o.offset;
            }
            return tmp;
        }

    }

    StringBuffer result = new StringBuffer( );

    String currentIndentation = OclConstants.EMPTY;

    String prevIndentation = OclConstants.EMPTY;

    // String indent = "\t";

    String indentation = "    "; //$NON-NLS-1$

    String lineDelimiter = System.getProperty( "line.separator" ); //$NON-NLS-1$

    String constraint;

    SortedMap<Integer, LineBreak> lineBreaks = new TreeMap<Integer, LineBreak>( );

    // TreeMap<Integer, String> highPrioLineBreaks = new TreeMap<Integer,
    // String>( );
    //
    // TreeMap<Integer, String> lowPrioLineBreaks = new TreeMap<Integer,
    // String>( );

    int maxLineLength = 100;

    OclParserGen parser;

    int priority = 0;

    boolean notLetExpr = true;

    /**
     * @param actParser parser
     * @param actConstraint constraint
     * @param actComments comments
     */
    public FormatterVisitor( OclParserGen actParser, String actConstraint, TreeMap<Integer, String> actComments ) {

        this.constraint = actConstraint;
        this.parser = actParser;
        this.comments = actComments;
    }

    /**
     * @return the formatted String
     */
    public String getResult( ) {

        appendComments( this.constraint.length( ) );
        manageLineBreaks( );
        return this.result.toString( );
    }

    //
    /**
     * @param min
     * @param prefered
     * @param max
     * @return the best LineBreak for this region
     */
    private LineBreak getLineBreak( int min, int prefered, int max ) {

        LineBreak actResult;

        SortedMap<Integer, LineBreak> breakMap = this.lineBreaks.subMap( Integer.valueOf( min ), Integer.valueOf( prefered ) );
        if ( breakMap.isEmpty( ) ) {
            breakMap = this.lineBreaks.subMap( Integer.valueOf( min ), Integer.valueOf( max ) );
            if ( breakMap.isEmpty( ) )
                actResult = null;
            else
                actResult = breakMap.get( breakMap.firstKey( ) );
        } else {
            List<LineBreak> breaks = new ArrayList<LineBreak>( breakMap.size( ) );
            breaks.addAll( breakMap.values( ) );
            if ( breaks.isEmpty( ) )
                actResult = null;
            else {
                Collections.sort( breaks );
                actResult = breaks.get( 0 );
            }
        }
        if ( actResult != null )
            this.lineBreaks = this.lineBreaks.tailMap( Integer.valueOf( actResult.offset ) );
        return actResult;
    }


    /**
     * This method formats the result in consideration of the line length. It
     * use the previous defined LineBreaks.
     */
    private void manageLineBreaks( ) {

        int curLineOffset = 0;
        int modOffset = 0;
        // boolean stillLongLines = true;
        // while ( stillLongLines ) {
        String[] lines = this.result.toString( ).split( this.lineDelimiter );
        String tmp;
        int lineNumber = 0;
        for ( String string : lines ) {
            tmp = string;
            int lineEnd = curLineOffset + string.length( );
            int localModOffset = curLineOffset;
            boolean modification = true;
            while ( modification ) {
                modification = false;
                if ( tmp.length( ) > this.maxLineLength ) {
                    LineBreak lb = getLineBreak( localModOffset, localModOffset + this.maxLineLength + 1, lineEnd );
                    if ( lb != null ) {
                        this.result.insert( lb.offset + modOffset, this.lineDelimiter + lb.indent );
                        modOffset += this.lineDelimiter.length( ) + lb.indent.length( );
                        modification = true;

                        // tmp = lb.indent + string.substring( ( lb.offset -
                        // curLineOffset ) - ( lineNumber *
                        // lineDelimiter.length( ) ) );
                        tmp = lb.indent + string.substring( ( lb.offset - curLineOffset ) );
                        localModOffset = lb.offset + 1;// += ( key -
                        // curLineOffset ) -
                        // ( lineNumber *
                        // lineDelimiter.length(
                        // ) );
                    }
                }
            }
            curLineOffset += string.length( ) + this.lineDelimiter.length( );
            lineNumber++;
        }
    }

    /**
     * Increments the current indentation.
     */
    private void shiftRight( ) {

        this.currentIndentation += this.indentation;
        this.prevIndentation = this.currentIndentation;
    }

    /**
     * Adds a new line to result followed by the current indentation.
     */
    private void newLine( ) {

        this.result.append( this.lineDelimiter );
        this.result.append( this.currentIndentation );
    }


    /**
     * Decrements the current indentation.
     */
    private void shiftLeft( ) {

        this.currentIndentation = this.currentIndentation.substring( 0, this.currentIndentation.length( ) - this.indentation.length( ) );
        // currentIndentation.delete( currentIndentation.lastIndexOf( indent
        // ), currentIndentation.length( ) );
    }

    /**
     * Inserts a whitespace to the result.
     */
    private void space( ) {

        this.result.append( OclConstants.SPACE );
    }

    private void infixOperation( Object child1, Object child2, IToken delimiter ) {

        accept( child1 );
        space( );
        append( delimiter );
        space( );
        markLineBreak( true );
        accept( child2 );
    }

    /**
     * Adds a new LineBreak to linebreaks. Uses the current length of the
     * result, the current priority and considers the boolean indent
     * 
     * @param additionalIndent states if there should be an additional indent
     * after this LineBreak.
     */
    private void markLineBreak( boolean additionalIndent ) {

        this.lineBreaks.put( Integer.valueOf( this.result.length( ) ), new LineBreak( this.result.length( ), this.currentIndentation, this.priority, additionalIndent ) );
    }

    private void accept( Object n ) {

        this.priority++;
        ( (Node) n ).accept( this );
        this.priority--;
    }

    private void append( IToken token ) {

        appendComments( token.getStartOffset( ) );
        this.result.append( token );
        this.prevIndentation = this.currentIndentation;

    }

    private void appendComments( int offset ) {

        SortedMap<Integer, String> commentsToAdd = this.comments.headMap( Integer.valueOf( offset ) );
        while ( !commentsToAdd.isEmpty( ) ) {
            Integer curKey = commentsToAdd.firstKey( );
            String comment = commentsToAdd.get( curKey );

            String tmp = removeTrailingWS( this.result.toString( ) );
            boolean endsWithLineDelimiter = tmp.endsWith( this.lineDelimiter );
            // if ( comment.startsWith( SINGLELINECOMMENT ) ) {
            // comment = comment.replaceFirst( SINGLELINECOMMENT, "" );
            // } else {
            // comment = comment.replaceFirst( MULTILINECOMMENT, "" );
            // }

            boolean endLine = comment.endsWith( Formatter.NEWLINE );
            if ( endLine )
                comment = comment.substring( 0, comment.length( ) - Formatter.NEWLINE.length( ) );

            if ( comment.startsWith( Formatter.NEWLINE ) ) {
                comment = comment.replaceFirst( Formatter.NEWLINE, OclConstants.EMPTY );
                boolean indent = comment.startsWith( Formatter.INDENT );
                if ( indent ) {
                    comment = comment.replaceFirst( Formatter.INDENT, OclConstants.EMPTY );
                }
                if ( endsWithLineDelimiter ) {
                    this.result.insert( tmp.length( ), formatMultiLineComment( comment, indent, false ) + this.lineDelimiter );
                    endLine = false;
                } else {
                    this.result.append( this.lineDelimiter + formatMultiLineComment( comment, indent, false ) );
                }
            } else {
                if ( endsWithLineDelimiter ) {
                    this.result.insert( tmp.length( ) - this.lineDelimiter.length( ), formatMultiLineComment( comment, true, true ) );
                    endLine = false;
                } else {
                    this.result.append( formatMultiLineComment( comment, true, true ) );
                }
            }
            if ( endLine )
                newLine( );

            commentsToAdd.remove( curKey );
            this.comments.remove( curKey );
        }
    }

    private String formatMultiLineComment( String actComment, boolean indent, boolean ignoreFirst ) {

        String comment = actComment;
        if ( !comment.contains( this.lineDelimiter ) ) {
            if ( indent && !ignoreFirst ) {
                return this.prevIndentation + comment;
            }

            return comment;
        }
        // comment.replaceFirst( "/*", "" );
        // comment.substring( 0, comment.lastIndexOf( "*/" ) );

        String[] lines = comment.split( this.lineDelimiter );
        comment = OclConstants.EMPTY;
        for ( int i = 0; i < lines.length; i++ ) {
            if ( indent && !( ignoreFirst && i == 0 ) ) {
                comment += this.prevIndentation;
            }
            comment += removeTrailingWS( removeHeadingWS( lines[i] ) );
            if ( i < lines.length - 1 ) {
                comment += this.lineDelimiter;
            }
        }
        return comment;
    }

    private String removeTrailingWS( String actString ) {

        String string = actString;
        while ( string.endsWith( OclConstants.SPACE ) || string.endsWith( Formatter.TAB ) ) {
            string = string.substring( 0, string.length( ) - 1 );
        }
        return string;
    }

    private String removeHeadingWS( String actString ) {

        String string = actString;
        while ( string.startsWith( OclConstants.SPACE ) || string.startsWith( Formatter.TAB ) ) {
            string = string.substring( 1 );
        }
        return string;
    }

    private IToken nextIToken( Node n ) {

        return this.parser.getIToken( n.getRightIToken( ).getTokenIndex( ) + 1 );
    }

    private IToken nextIToken( IToken t ) {

        return this.parser.getIToken( t.getTokenIndex( ) + 1 );
    }

    private IToken prevIToken( Node n ) {

        return this.parser.getIToken( n.getLeftIToken( ).getTokenIndex( ) - 1 );
    }

    @Override
    public void unimplementedVisitor( String s ) {

        // Do nothing

    }

    @Override
    /*
     * <b> <li>booleanExpression ::= booleanExpression and relationalExpression
     * </b>
     */
    public void visit( AndBooleanExpression n ) {

//        accept( n.getbooleanExpression( ) );
//        space( );
//        append( nextIToken( (Node) n.getbooleanExpression( ) ) );
//        space( );
//        markLineBreak( true );
//        priority++;
//        n.getrelationalExpression( ).accept( this );
//        priority--;
        infixOperation( n.getbooleanExpression( ), n.getrelationalExpression( ), nextIToken( (Node) n.getbooleanExpression( ) ) );

    }

    @Override
    /*
     * <b> <li>argumentN ::= argumentN , oclExpression </b>
     */
    public void visit( Arguments n ) {

        n.getargumentN( ).accept( this );
        append( nextIToken( (Node) n.getargumentN( ) ) );
        space( );
        markLineBreak( true );
        accept( n.getoclExpression( ) );
    }

    @Override
    /*
     * <b> <li>associationQualifier ::= [ pathName ] </b>
     */
    public void visit( AssociationQualifier n ) {

        append( n.getLeftIToken( ) );
        space( );
        accept( n.getpathName( ) );
        space( );
        append( n.getRightIToken( ) );
    }

    @Override
    /*
     * <b> <li>attrOrAssocContext ::= context sPathName withTypeExpression
     * initOrDerValueN </b>
     */
    public void visit( AttrOrAssocContextDecl n ) {

        append( n.getLeftIToken( ) );
        space( );
        accept( n.getsPathName( ) );
        space( );
        // append( nextIToken( (Node) n.getsPathName( ) ) );
        // space( );
        accept( n.getwithTypeExpression( ) );
        shiftRight( );
        newLine( );
        accept( n.getinitOrDerValueN( ) );
        shiftLeft( );

    }

    @Override
    /*
     * attrOrNavCall $AttrOrNavCall ::= pathName timeExpressionOpt
     * associationQualifierOpt
     */
    public void visit( AttrOrNavCall n ) {

        accept( n.getpathName( ) );
        if ( n.getassociationQualifierOpt( ) != null )
            accept( n.getassociationQualifierOpt( ) );
        if ( n.gettimeExpressionOpt( ) != null )
            accept( n.gettimeExpressionOpt( ) );
    }

    @Override
    /*
     * <b> <li>collectionKind ::= Bag </b>
     */
    public void visit( BagKind n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>prePostOrBodyDecl ::= body identifierOpt : oclExpression </b>
     */
    public void visit( BodyDecl n ) {

        append( n.getLeftIToken( ) );
        if ( n.getidentifierOpt( ) != null ) {
            space( );
            accept( n.getidentifierOpt( ) );
        }
        append( prevIToken( (Node) n.getoclExpression( ) ) );
        shiftRight( );
        newLine( );
        accept( n.getoclExpression( ) );
        shiftLeft( );
    }

    @Override
    /*
     * <b> <li>booleanLiteral ::= false </b>
     */
    public void visit( BooleanLiteralFalse n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>booleanLiteral ::= true </b>
     */
    public void visit( BooleanLiteralTrue n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>operationCall ::= allInstances timeExpressionOpt arguments </b>
     */
    public void visit( CallAllInstances n ) {

        append( n.getLeftIToken( ) );
        if ( n.gettimeExpressionOpt( ) != null ) {
            accept( n.gettimeExpressionOpt( ) );
        }
        accept( n.getarguments( ) );
    }

    @Override
    /*
     * <b> <li>operationCall ::= and timeExpressionOpt arguments </b>
     */
    public void visit( CallAnd n ) {

        append( n.getLeftIToken( ) );
        if ( n.gettimeExpressionOpt( ) != null ) {
            accept( n.gettimeExpressionOpt( ) );
        }
        accept( n.getarguments( ) );
    }

    @Override
    /*
     * <b> <li>operationCall ::= / timeExpressionOpt arguments </b>
     */
    public void visit( CallDivide n ) {

        append( n.getLeftIToken( ) );
        if ( n.gettimeExpressionOpt( ) != null ) {
            accept( n.gettimeExpressionOpt( ) );
        }
        accept( n.getarguments( ) );
    }

    @Override
    /*
     * <b> <li>operationCall ::= = timeExpressionOpt arguments </b>
     */
    public void visit( CallEqual n ) {

        append( n.getLeftIToken( ) );
        if ( n.gettimeExpressionOpt( ) != null ) {
            accept( n.gettimeExpressionOpt( ) );
        }
        accept( n.getarguments( ) );
    }

    @Override
    /*
     * <b> <li>operationCall ::= > timeExpressionOpt arguments </b>
     */
    public void visit( CallGreater n ) {

        append( n.getLeftIToken( ) );
        if ( n.gettimeExpressionOpt( ) != null ) {
            accept( n.gettimeExpressionOpt( ) );
        }
        accept( n.getarguments( ) );
    }

    @Override
    /*
     * <b> <li>operationCall ::= > timeExpressionOpt arguments </b>
     */
    public void visit( CallGreaterEqual n ) {

        append( n.getLeftIToken( ) );
        if ( n.gettimeExpressionOpt( ) != null ) {
            accept( n.gettimeExpressionOpt( ) );
        }
        accept( n.getarguments( ) );
    }

    @Override
    /*
     * <b> <li>operationCall ::= < timeExpressionOpt arguments </b>
     */
    public void visit( CallLess n ) {

        append( n.getLeftIToken( ) );
        if ( n.gettimeExpressionOpt( ) != null ) {
            accept( n.gettimeExpressionOpt( ) );
        }
        accept( n.getarguments( ) );
    }

    @Override
    /*
     * <b> <li>operationCall ::= <= timeExpressionOpt arguments </b>
     */
    public void visit( CallLessEqual n ) {

        append( n.getLeftIToken( ) );
        if ( n.gettimeExpressionOpt( ) != null ) {
            accept( n.gettimeExpressionOpt( ) );
        }
        accept( n.getarguments( ) );
    }

    @Override
    /*
     * <b> <li>operationCall ::= timeExpressionOpt arguments </b>
     */
    public void visit( CallMult n ) {

        append( n.getLeftIToken( ) );
        if ( n.gettimeExpressionOpt( ) != null ) {
            accept( n.gettimeExpressionOpt( ) );
        }
        accept( n.getarguments( ) );
    }

    @Override
    /*
     * <b> <li>operationCall ::= <> timeExpressionOpt arguments </b>
     */
    public void visit( CallNotEqual n ) {

        append( n.getLeftIToken( ) );
        if ( n.gettimeExpressionOpt( ) != null ) {
            accept( n.gettimeExpressionOpt( ) );
        }
        accept( n.getarguments( ) );
    }

    @Override
    /*
     * <b> <li>operationCall ::= oclAsType timeExpressionOpt arguments </b>
     */
    public void visit( CallOclAsType n ) {

        append( n.getLeftIToken( ) );
        if ( n.gettimeExpressionOpt( ) != null ) {
            accept( n.gettimeExpressionOpt( ) );
        }
        accept( n.getarguments( ) );
    }

    @Override
    /*
     * <b> <li>operationCall ::= oclIsInvalid timeExpressionOpt arguments </b>
     */
    public void visit( CallOclIsInvalid n ) {

        append( n.getLeftIToken( ) );
        if ( n.gettimeExpressionOpt( ) != null ) {
            accept( n.gettimeExpressionOpt( ) );
        }
        accept( n.getarguments( ) );
    }

    @Override
    /*
     * <b> <li>operationCall ::= oclIsKindOf timeExpressionOpt arguments </b>
     */
    public void visit( CallOclIsKindOf n ) {

        append( n.getLeftIToken( ) );
        if ( n.gettimeExpressionOpt( ) != null ) {
            accept( n.gettimeExpressionOpt( ) );
        }
        accept( n.getarguments( ) );
    }

    @Override
    /*
     * <b> <li>operationCall ::= oclIsTypeOf timeExpressionOpt arguments </b>
     */
    public void visit( CallOclIsTypeOf n ) {

        append( n.getLeftIToken( ) );
        if ( n.gettimeExpressionOpt( ) != null ) {
            accept( n.gettimeExpressionOpt( ) );
        }
        accept( n.getarguments( ) );
    }

    @Override
    /*
     * <b> <li>operationCall ::= oclIsUndefined timeExpressionOpt arguments </b>
     */
    public void visit( CallOclIsUndefined n ) {

        append( n.getLeftIToken( ) );
        if ( n.gettimeExpressionOpt( ) != null ) {
            accept( n.gettimeExpressionOpt( ) );
        }
        accept( n.getarguments( ) );
    }

    @Override
    /*
     * <b> <li>operationCall ::= or timeExpressionOpt arguments </b>
     */
    public void visit( CallOr n ) {

        append( n.getLeftIToken( ) );
        if ( n.gettimeExpressionOpt( ) != null ) {
            accept( n.gettimeExpressionOpt( ) );
        }
        accept( n.getarguments( ) );
    }

    @Override
    /*
     * <b> <li>operationCall ::= + timeExpressionOpt arguments </b>
     */
    public void visit( CallPlus n ) {

        append( n.getLeftIToken( ) );
        if ( n.gettimeExpressionOpt( ) != null ) {
            accept( n.gettimeExpressionOpt( ) );
        }
        accept( n.getarguments( ) );
    }

    @Override
    /*
     * <b> <li>operationCall ::= xor timeExpressionOpt arguments </b>
     */
    public void visit( CallXor n ) {

        append( n.getLeftIToken( ) );
        if ( n.gettimeExpressionOpt( ) != null ) {
            accept( n.gettimeExpressionOpt( ) );
        }
        accept( n.getarguments( ) );
    }

    @Override
    /*
     * <b> <li>collectionKind ::= Collection </b>
     */
    public void visit( CollectionKind n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>collectionLiteral ::= collectionKind { collectionLiteralPartM }
     * </b>
     */
    public void visit( CollectionLiteral n ) {

        accept( n.getcollectionKind( ) );
        append( nextIToken( (Node) n.getcollectionKind( ) ) );
        space( );
        if ( n.getcollectionLiteralPartM( ) != null ) {
            accept( n.getcollectionLiteralPartM( ) );
            space( );
        }
        append( n.getRightIToken( ) );
    }

    @Override
    /*
     * <b> <li> collectionLiteralPart ::= oclExpression collectionRangeOpt </b>
     */
    public void visit( CollectionLiteralExpression n ) {

        accept( n.getoclExpression( ) );
        if ( n.getcollectionRangeOpt( ) != null ) {
            accept( n.getcollectionRangeOpt( ) );
        }
    }

    @Override
    /*
     * <b> <li> CollectionLiteralIntegerRange ::= minusOpt integerLiteralRange
     * oclExpression </b>
     */
    public void visit( CollectionLiteralIntegerRange n ) {

        if ( n.getminusOpt( ) != null )
            accept( n.getminusOpt( ) );
        accept( n.getintegerLiteralRange( ) );
        accept( n.getoclExpression( ) );
    }

    @Override
    /*
     * <b> <li>collectionLiteralPartN ::= collectionLiteralPartN ,
     * collectionLiteralPart </b>
     */
    public void visit( CollectionLiteralParts n ) {

        accept( n.getcollectionLiteralPartN( ) );
        append( nextIToken( (Node) n.getcollectionLiteralPartN( ) ) );
        space( );
        accept( n.getcollectionLiteralPart( ) );
    }

    @Override
    /*
     * <b> <li>propertyInvocation ::= -> propertyCall </b>
     */
    public void visit( CollectionPropertyInvocation n ) {

        append( n.getLeftIToken( ) );
        accept( n.getpropertyCall( ) );

    }

    @Override
    /*
     * <b> <li>collectionRangeOpt ::= .. oclExpression </b>
     */
    public void visit( CollectionRange n ) {

        append( n.getLeftIToken( ) );
        accept( n.getoclExpression( ) );
    }

    @Override
    /*
     * <b> <li>collectionType ::= collectionKind ( typePathName ) </b>
     */
    public void visit( com.sap.tc.moin.ocl.parser.gen.oclAst.CollectionType n ) {

        accept( n.getcollectionKind( ) );
        append( nextIToken( (Node) n.getcollectionKind( ) ) );
        space( );
        accept( n.gettypePathName( ) );
        space( );
        append( n.getRightIToken( ) );
    }

    @Override
    /*
     * <b> <li>identifierWithOptContainerPrefix ::= identifier # sPathName </b>
     */
    public void visit( ContainerNamePrefix n ) {

        accept( n.getidentifier( ) );
        append( nextIToken( n.getidentifier( ) ) );
        accept( n.getsPathName( ) );
    }

    @Override
    /*
     * <b> <li> oclFile ::= contextBody </b>
     */
    public void visit( ContextBodyOclFile n ) {

        accept( n.getcontextBody( ) );
    }

    @Override
    /*
     * <b> <li>contextDeclarationN ::= contextDeclarationN contextDeclaration
     * </b>
     */
    public void visit( ContextDeclarations n ) {

        accept( n.getcontextDeclarationN( ) );
        newLine( );
        accept( n.getcontextDeclaration( ) );
    }

    @Override
    /*
     * <b> <li>invOrDef ::= def identifierOpt : defExpression </b>
     */
    public void visit( DefDeclaration n ) {

        append( n.getLeftIToken( ) );
        if ( n.getidentifierOpt( ) != null ) {
            space( );
            accept( n.getidentifierOpt( ) );
        }
        append( prevIToken( (Node) n.getdefExpression( ) ) );
        shiftRight( );
        newLine( );
        accept( n.getdefExpression( ) );
        shiftLeft( );
    }

    @Override
    /*
     * <b> <li>initOrDerValue ::= derive : oclExpression </b>
     */
    public void visit( DeriveValue n ) {

        append( n.getLeftIToken( ) );
        append( nextIToken( n.getLeftIToken( ) ) );
        shiftRight( );
        newLine( );
        accept( n.getoclExpression( ) );
        shiftLeft( );
    }

    @Override
    /*
     * <b> <li>multiplicativeExpression ::= multiplicativeExpression /
     * unaryExpression </b>
     */
    public void visit( DivideMultiplicativeExpression n ) {

//        accept( n.getmultiplicativeExpression( ) );
//        space( );
//        append( nextIToken( (Node) n.getmultiplicativeExpression( ) ) );
//        space( );
//        markLineBreak( true );
//        accept( n.getunaryExpression( ) );
        infixOperation( n.getmultiplicativeExpression( ), n.getunaryExpression( ), nextIToken( (Node) n.getmultiplicativeExpression( ) ) );
    }

    @Override
    /*
     * <b> <li>relationalExpression ::= relationalExpression =
     * compareableExpression </b>
     */
    public void visit( EqualRelationalExpression n ) {

//        accept( n.getrelationalExpression( ) );
//        space( );
//        append( nextIToken( (Node) n.getrelationalExpression( ) ) );
//        space( );
//        markLineBreak( true );
//        accept( n.getcompareableExpression( ) );
        infixOperation( n.getrelationalExpression( ), n.getcompareableExpression( ), nextIToken( (Node) n.getrelationalExpression( ) ) );
    }

    @Override
    /*
     * <b> <li>invOrDef ::= exp identifierOpt : oclExpression </b>
     */
    public void visit( ExpDeclaration n ) {

        append( n.getLeftIToken( ) );
        if ( n.getidentifierOpt( ) != null ) {
            space( );
            accept( n.getidentifierOpt( ) );
        }
        append( prevIToken( (Node) n.getoclExpression( ) ) );
        shiftRight( );
        newLine( );
        accept( n.getoclExpression( ) );
        shiftLeft( );
    }

    @Override
    /*
     * <b> <li>relationalExpression ::= relationalExpression >=
     * compareableExpression </b>
     */
    public void visit( GreaterEqualRelationalExpression n ) {

//        accept( n.getrelationalExpression( ) );
//        space( );
//        append( nextIToken( (Node) n.getrelationalExpression( ) ) );
//        space( );
//        markLineBreak( true );
//        accept( n.getcompareableExpression( ) );
        infixOperation( n.getrelationalExpression( ), n.getcompareableExpression( ), nextIToken( (Node) n.getrelationalExpression( ) ) );
    }

    @Override
    /*
     * <b> <li>relationalExpression ::= relationalExpression >
     * compareableExpression </b>
     */
    public void visit( GreaterRelationalExpression n ) {

//        accept( n.getrelationalExpression( ) );
//        space( );
//        append( nextIToken( (Node) n.getrelationalExpression( ) ) );
//        space( );
//        markLineBreak( true );
//        accept( n.getcompareableExpression( ) );
        infixOperation( n.getrelationalExpression( ), n.getcompareableExpression( ), nextIToken( (Node) n.getrelationalExpression( ) ) );
    }

    @Override
    /*
     * <b> <li>identifier ::= IDENTIFIER </b>
     */
    public void visit( Ident n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>ifExpression ::= if oclExpression then oclExpression else
     * oclExpression endif </b>
     */
    public void visit( IfExpression n ) {

        append( n.getLeftIToken( ) );
        shiftRight( );
        newLine( );
        accept( n.getoclExpression( ) );
        shiftLeft( );
        newLine( );
        append( nextIToken( (Node) n.getoclExpression( ) ) );
        shiftRight( );
        newLine( );
        accept( n.getoclExpression4( ) );
        shiftLeft( );
        newLine( );
        append( nextIToken( (Node) n.getoclExpression4( ) ) );
        shiftRight( );
        newLine( );
        accept( n.getoclExpression6( ) );
        shiftLeft( );
        newLine( );
        append( n.getRightIToken( ) );

    }

    @Override
    /*
     * <b> <li>initOrDerValueN ::= initOrDerValueN initOrDerValue </b>
     */
    public void visit( InitOrDerValueN n ) {

        accept( n.getinitOrDerValueN( ) );
        newLine( );
        accept( n.getinitOrDerValue( ) );
    }

    @Override
    /*
     * <b> <li>initOrDerValue ::= init : oclExpression </b>
     */
    public void visit( InitValue n ) {

        append( n.getLeftIToken( ) );
        append( nextIToken( n.getLeftIToken( ) ) );
        shiftRight( );
        newLine( );
        accept( n.getoclExpression( ) );
        shiftLeft( );
    }

    @Override
    /*
     * <b> <li>integerLiteral ::= INTEGER_LITERAL </b>
     */
    public void visit( IntegerLiteral n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li> integerLiteralRange ::= INTEGER_RANGE_START </b>
     */
    public void visit( IntegerLiteralRange n ) {

        append( n.getLeftIToken( ) );
        append( n.getRightIToken( ) );
    }

    @Override
    /*
     * <b> <li>invalidLiteral ::= invalid </b>
     */
    public void visit( InvalidLiteral n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>invOrDef ::= inv identifierOpt : oclExpression </b>
     */
    public void visit( InvDeclaration n ) {

        append( n.getLeftIToken( ) );
        if ( n.getidentifierOpt( ) != null ) {
            space( );
            accept( n.getidentifierOpt( ) );
        }
        append( prevIToken( (Node) n.getoclExpression( ) ) );
        shiftRight( );
        newLine( );
        accept( n.getoclExpression( ) );
        shiftLeft( );
    }

    @Override
    /*
     * <b> <li>invOrDefN ::= invOrDefN invOrDef </b>
     */
    public void visit( InvOrDefs n ) {

        accept( n.getinvOrDefN( ) );
        newLine( );
        accept( n.getinvOrDef( ) );
    }

    @Override
    /*
     * <b> <li>iterateExp ::= iterate ( variableAssignment | oclExpression )
     * </b>
     */
    public void visit( IterateVarDecl n ) {

        append( n.getLeftIToken( ) );
        append( nextIToken( n.getLeftIToken( ) ) );
        space( );
        accept( n.getvariableAssignment( ) );
        space( );
        append( nextIToken( n.getvariableAssignment( ) ) );
        space( );
        markLineBreak( true );
        accept( n.getoclExpression( ) );
        space( );
        append( n.getRightIToken( ) );

    }

    @Override
    /*
     * <b> <li>iterateExp ::= iterate ( variableDeclaration ; variableAssignment
     * | oclExpression ) </b>
     */
    public void visit( IterateVarDeclAndAcc n ) {

        append( n.getLeftIToken( ) );
        append( nextIToken( n.getLeftIToken( ) ) );
        space( );
        accept( n.getvariableDeclaration( ) );
        append( nextIToken( n.getvariableDeclaration( ) ) );
        space( );
        markLineBreak( true );
        accept( n.getvariableAssignment( ) );
        space( );
        append( nextIToken( n.getvariableAssignment( ) ) );
        space( );
        markLineBreak( true );
        accept( n.getoclExpression( ) );
        space( );
        append( n.getRightIToken( ) );

    }

    @Override
    /*
     * <b> <li>iteratorExp ::= any ( iterContents ) </b>
     */
    public void visit( IteratorAny n ) {

        append( n.getLeftIToken( ) );
        append( nextIToken( n.getLeftIToken( ) ) );
        space( );
        accept( n.getiterContents( ) );
        space( );
        append( n.getRightIToken( ) );
    }

    @Override
    /*
     * <b> <li>iteratorExp ::= collect ( iterContents ) </b>
     */
    public void visit( IteratorCollect n ) {

        append( n.getLeftIToken( ) );
        append( nextIToken( n.getLeftIToken( ) ) );
        space( );
        accept( n.getiterContents( ) );
        space( );
        append( n.getRightIToken( ) );
    }

    @Override
    /*
     * <b> <li>iteratorExp ::= collectNested ( iterContents ) </b>
     */
    public void visit( IteratorCollectNested n ) {

        append( n.getLeftIToken( ) );
        append( nextIToken( n.getLeftIToken( ) ) );
        space( );
        accept( n.getiterContents( ) );
        space( );
        append( n.getRightIToken( ) );
    }

    @Override
    /*
     * <b> <li>iteratorExp ::= exists ( iterContents ) </b>
     */
    public void visit( IteratorExists n ) {

        append( n.getLeftIToken( ) );
        append( nextIToken( n.getLeftIToken( ) ) );
        space( );
        accept( n.getiterContents( ) );
        space( );
        append( n.getRightIToken( ) );
    }

    @Override
    /*
     * <b> <li>iteratorExp ::= forAll ( iterContents ) </b>
     */
    public void visit( IteratorForAll n ) {

        append( n.getLeftIToken( ) );
        append( nextIToken( n.getLeftIToken( ) ) );
        space( );
        accept( n.getiterContents( ) );
        space( );
        append( n.getRightIToken( ) );
    }

    @Override
    /*
     * <b> <li>iteratorExp ::= isUnique ( iterContents ) </b>
     */
    public void visit( IteratorIsUnique n ) {

        append( n.getLeftIToken( ) );
        append( nextIToken( n.getLeftIToken( ) ) );
        space( );
        accept( n.getiterContents( ) );
        space( );
        append( n.getRightIToken( ) );
    }

    @Override
    /*
     * <b> <li>iteratorExp ::= one ( iterContents ) </b>
     */
    public void visit( IteratorOne n ) {

        append( n.getLeftIToken( ) );
        append( nextIToken( n.getLeftIToken( ) ) );
        space( );
        accept( n.getiterContents( ) );
        space( );
        append( n.getRightIToken( ) );
    }

    @Override
    /*
     * <b> <li>iterContents ::= variableDeclaration | oclExpression </b>
     */
    public void visit( IteratorOneVarDecl n ) {

        accept( n.getvariableDeclaration( ) );
        space( );
        append( nextIToken( n.getvariableDeclaration( ) ) );
        space( );
        markLineBreak( true );
        accept( n.getoclExpression( ) );
    }

    @Override
    /*
     * <b> <li>iteratorExp ::= reject ( iterContents ) </b>
     */
    public void visit( IteratorReject n ) {

        append( n.getLeftIToken( ) );
        append( nextIToken( n.getLeftIToken( ) ) );
        space( );
        accept( n.getiterContents( ) );
        space( );
        append( n.getRightIToken( ) );
    }

    @Override
    /*
     * <b> <li>iteratorExp ::= select ( iterContents ) </b>
     */
    public void visit( IteratorSelect n ) {

        append( n.getLeftIToken( ) );
        append( nextIToken( n.getLeftIToken( ) ) );
        space( );
        accept( n.getiterContents( ) );
        space( );
        append( n.getRightIToken( ) );
    }

    @Override
    /*
     * <b> <li>iteratorExp ::= sortedBy ( iterContents ) </b>
     */
    public void visit( IteratorSortedBy n ) {

        append( n.getLeftIToken( ) );
        append( nextIToken( n.getLeftIToken( ) ) );
        space( );
        accept( n.getiterContents( ) );
        space( );
        append( n.getRightIToken( ) );

    }

    @Override
    /*
     * <b> <li>iterContents ::= variableDeclaration , variableDeclaration |
     * oclExpression </b>
     */
    public void visit( IteratorTwoVarDecl n ) {

        accept( n.getvariableDeclaration( ) );
        append( nextIToken( n.getvariableDeclaration( ) ) );
        space( );
        markLineBreak( true );
        accept( n.getvariableDeclaration3( ) );
        space( );
        append( nextIToken( n.getvariableDeclaration3( ) ) );
        space( );
        markLineBreak( true );
        accept( n.getoclExpression( ) );
    }

    @Override
    /*
     * <b> <li>relationalExpression ::= relationalExpression <=
     * compareableExpression </b>
     */
    public void visit( LessEqualRelationalExpression n ) {

//        accept( n.getrelationalExpression( ) );
//        space( );
//        append( nextIToken( (Node) n.getrelationalExpression( ) ) );
//        space( );
//        markLineBreak( true );
//        accept( n.getcompareableExpression( ) );
        infixOperation( n.getrelationalExpression( ), n.getcompareableExpression( ), nextIToken( (Node) n.getrelationalExpression( ) ) );
    }

    @Override
    /*
     * <b> <li>relationalExpression ::= relationalExpression <
     * compareableExpression </b>
     */
    public void visit( LessRelationalExpression n ) {

//        accept( n.getrelationalExpression( ) );
//        space( );
//        append( nextIToken( (Node) n.getrelationalExpression( ) ) );
//        space( );
//        markLineBreak( true );
//        accept( n.getcompareableExpression( ) );
        infixOperation( n.getrelationalExpression( ), n.getcompareableExpression( ), nextIToken( (Node) n.getrelationalExpression( ) ) );
    }

    @Override
    /*
     * <b> <li>letExpression ::= letExpression ::= let variableAssignmentN in
     * oclExpression </b>
     */
    public void visit( LetExpression n ) {

        append( n.getLeftIToken( ) );
        shiftRight( );
        newLine( );
        this.notLetExpr = false;
        accept( n.getvariableAssignmentN( ) );
        this.notLetExpr = true;
        shiftLeft( );
        newLine( );
        append( nextIToken( (Node) n.getvariableAssignmentN( ) ) );
        shiftRight( );
        newLine( );
        accept( n.getoclExpression( ) );
        shiftLeft( );
    }

    @Override
    /*
     * <b> <li>logicalExpression ::= logicalExpression implies booleanExpression
     * </b>
     */
    public void visit( LogicalExpression n ) {

        accept( n.getlogicalExpression( ) );
        space( );
        append( nextIToken( (Node) n.getlogicalExpression( ) ) );
        space( );
        accept( n.getbooleanExpression( ) );
    }

    @Override
    /*
     * <b> <li>propertyInvocation ::= -> loopExp </b>
     */
    public void visit( LoopPropertyInvocation n ) {

        append( n.getLeftIToken( ) );
        accept( n.getloopExp( ) );
    }

    @Override
    public void visit( Minus n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>additiveExpression ::= additiveExpression -
     * multiplicativeExpression </b>
     */
    public void visit( MinusAdditiveExpression n ) {

//        accept( n.getadditiveExpression( ) );
//        space( );
//        append( nextIToken( (Node) n.getadditiveExpression( ) ) );
//        space( );
//        accept( n.getmultiplicativeExpression( ) );
        infixOperation( n.getadditiveExpression( ), n.getmultiplicativeExpression( ), nextIToken( (Node) n.getadditiveExpression( ) ) );
    }

    @Override
    /*
     * <b> <li>unaryExpression ::= - unaryExpression </b>
     */
    public void visit( MinusUnaryExpression n ) {

        append( n.getLeftIToken( ) );
        space( );
        accept( n.getunaryExpression( ) );
    }

    @Override
    /*
     * <b> <li>arguments ::= ( argumentN ) </b>
     */
    public void visit( MultipleArguments n ) {

        append( n.getLeftIToken( ) );
        space( );
        accept( n.getargumentN( ) );
        space( );
        append( n.getRightIToken( ) );
    }

    @Override
    /*
     * <b> <li>multiplicativeExpression ::= multiplicativeExpression
     * unaryExpression </b>
     */
    public void visit( MultMultiplicativeExpression n ) {

//        accept( n.getmultiplicativeExpression( ) );
//        space( );
//        append( nextIToken( (Node) n.getmultiplicativeExpression( ) ) );
//        space( );
//        accept( n.getunaryExpression( ) );
        infixOperation( n.getmultiplicativeExpression( ), n.getunaryExpression( ), nextIToken( (Node) n.getmultiplicativeExpression( ) ) );
    }

    @Override
    /*
     * <b> <li>arguments ::= ( ) </b>
     */
    public void visit( NoArguments n ) {

        append( n.getLeftIToken( ) );
        space( );
        append( n.getRightIToken( ) );
    }

    @Override
    public void visit( NodeToken n ) {

        super.visit( n );
    }

    @Override
    /*
     * <b> <li>relationalExpression ::= relationalExpression <>
     * compareableExpression </b>
     */
    public void visit( NotEqualRelationalExpression n ) {

//        accept( n.getrelationalExpression( ) );
//        space( );
//        append( nextIToken( (Node) n.getrelationalExpression( ) ) );
//        space( );
//        accept( n.getcompareableExpression( ) );
        infixOperation( n.getrelationalExpression( ), n.getcompareableExpression( ), nextIToken( (Node) n.getrelationalExpression( ) ) );
    }

    @Override
    /*
     * <b> <li>unaryExpression ::= not unaryExpression </b>
     */
    public void visit( NotUnaryExpression n ) {

        append( n.getLeftIToken( ) );
        space( );
        accept( n.getunaryExpression( ) );
    }

    @Override
    /*
     * <b> <li>unaryExpression ::= not unaryExpression </b>
     */
    public void visit( NullLiteral n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>propertyInvocation ::= . propertyCall </b>
     */
    public void visit( ObjectPropertyInvocation n ) {

        append( n.getLeftIToken( ) );
        accept( n.getpropertyCall( ) );
    }

    @Override
    /*
     * <b> <li> oclFile ::= oclExpression </b>
     */
    public void visit( OclFileOclExpression n ) {

        accept( n.getoclExpression( ) );

    }

    @Override
    /*
     * <b> <li>operationCall ::= sPathName timeExpressionOpt arguments</b>
     */
    public void visit( OperationCall n ) {

        accept( n.getpathName( ) );
        if ( n.gettimeExpressionOpt( ) != null )
            accept( n.gettimeExpressionOpt( ) );
        accept( n.getarguments( ) );

    }

    @Override
    /*
     * <b> <li>operationContextDecl ::= context operation prePostOrBodyDeclN
     * </b>
     */
    public void visit( OperationContextDecl n ) {

        append( n.getLeftIToken( ) );
        space( );
        accept( n.getoperation( ) );
        shiftRight( );
        newLine( );
        accept( n.getprePostOrBodyDeclN( ) );
        shiftLeft( );
    }

    @Override
    /*
     * <b> <li>operation ::= sPathName ( variableDeclarationWithTypeM )
     * withTypeExpression </b>
     */
    public void visit( OperationDecl n ) {

        accept( n.getsPathName( ) );
        append( nextIToken( (Node) n.getsPathName( ) ) );
        space( );
        if ( n.getvariableDeclarationWithTypeM( ) != null ) {
            accept( n.getvariableDeclarationWithTypeM( ) );
            space( );
        }
        append( prevIToken( n.getwithTypeExpression( ) ) );
        space( );
        accept( n.getwithTypeExpression( ) );
    }

    @Override
    /*
     * <b> <li>defExpression ::= operation = oclExpression </b>
     */
    public void visit( OperationDefExpression n ) {

        accept( n.getoperation( ) );
        space( );
        append( nextIToken( n.getoperation( ) ) );
        space( );
        accept( n.getoclExpression( ) );
    }

    @Override
    /*
     * <b> <li>booleanExpression ::= booleanExpression or relationalExpression
     * </b>
     */
    public void visit( OrBooleanExpression n ) {

//        accept( n.getbooleanExpression( ) );
//        space( );
//        append( nextIToken( (Node) n.getbooleanExpression( ) ) );
//        space( );
//        markLineBreak( false );
//        accept( n.getrelationalExpression( ) );
        infixOperation( n.getbooleanExpression( ), n.getrelationalExpression( ), nextIToken( (Node) n.getbooleanExpression( ) ) );
    }

    @Override
    /*
     * <b> <li>collectionKind ::= OrderedSet </b>
     */
    public void visit( OrderedSetKind n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>packageDeclaration ::= package sPathName contextDeclarationM
     * endpackage</b>
     */
    public void visit( PackageDeclaration n ) {

        append( n.getLeftIToken( ) );
        space( );
        accept( n.getsPathName( ) );
        if ( n.getcontextDeclarationM( ) != null ) {
            shiftRight( );
            newLine( );
            accept( n.getcontextDeclarationM( ) );
            shiftLeft( );
        }
        newLine( );
        append( n.getRightIToken( ) );
    }

    @Override
    /*
     * <b> <li>packageDeclarationN ::= packageDeclarationN packageDeclaration
     * </b>
     */
    public void visit( PackageDeclarations n ) {

        accept( n.getpackageDeclarationN( ) );
        newLine( );
        accept( n.getpackageDeclaration( ) );
    }

    @Override
    /*
     * <b> <li>primaryExpression ::= ( oclExpression ) </b>
     */
    public void visit( ParenthesizedPrimaryExpression n ) {

        append( n.getLeftIToken( ) );
        space( );
        accept( n.getoclExpression( ) );
        space( );
        append( n.getRightIToken( ) );
    }

    @Override
    /*
     * <b> <li>Rule 8: sPathName ::= identifier </b>
     */
    public void visit( PathNameIdent n ) {

        append( n.getLeftIToken( ) );

    }

    @Override
    /*
     * <b> <li>sPathName ::= identifier :: sPathName </b>
     */
    public void visit( PathNames n ) {

        accept( n.getidentifier( ) );

        markLineBreak( true );

        append( nextIToken( n.getidentifier( ) ) );
        accept( n.getsPathName( ) );
    }

    @Override
    /*
     * <b> <li>additiveExpression ::= additiveExpression +
     * multiplicativeExpression </b>
     */
    public void visit( PlusAdditiveExpression n ) {

//        accept( n.getadditiveExpression( ) );
//        space( );
//        append( nextIToken( (Node) n.getadditiveExpression( ) ) );
//        space( );
//        accept( n.getmultiplicativeExpression( ) );
        infixOperation( n.getadditiveExpression( ), n.getmultiplicativeExpression( ), nextIToken( (Node) n.getadditiveExpression( ) ) );
    }

    @Override
    /*
     * <b> <li>prePostOrBodyDecl ::= post identifierOpt : oclExpression </b>
     */
    public void visit( PostConditionDecl n ) {

        append( n.getLeftIToken( ) );
        if ( n.getidentifierOpt( ) != null ) {
            space( );
            accept( n.getidentifierOpt( ) );
        }
        append( prevIToken( (Node) n.getoclExpression( ) ) );
        shiftRight( );
        newLine( );
        accept( n.getoclExpression( ) );
        shiftLeft( );
    }

    @Override
    /*
     * <b> <li>postfixExpression ::= postfixExpression propertyInvocation </b>
     */
    public void visit( PostfixExpression n ) {

        accept( n.getpostfixExpression( ) );

        markLineBreak( true );

        accept( n.getpropertyInvocation( ) );

    }

    @Override
    /*
     * <b> <li>prePostOrBodyDecl ::= pre identifierOpt : oclExpression </b>
     */
    public void visit( PreConditionDecl n ) {

        append( n.getLeftIToken( ) );
        if ( n.getidentifierOpt( ) != null ) {
            space( );
            accept( n.getidentifierOpt( ) );
        }
        append( prevIToken( (Node) n.getoclExpression( ) ) );
        shiftRight( );
        newLine( );
        accept( n.getoclExpression( ) );
        shiftLeft( );
    }

    @Override
    /*
     * <b> <li>prePostOrBodyDeclN ::= prePostOrBodyDeclN prePostOrBodyDecl </b>
     */
    public void visit( PrePostOrBodyDecls n ) {

        accept( n.getprePostOrBodyDeclN( ) );
        newLine( );
        accept( n.getprePostOrBodyDecl( ) );
    }

    @Override
    /*
     * <b> <li>primitiveType ::= Boolean </b>
     */
    public void visit( PrimTypeBoolean n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>primitiveType ::= Double </b>
     */
    public void visit( PrimTypeDouble n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>primitiveType ::= Float </b>
     */
    public void visit( PrimTypeFloat n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>primitiveType ::= Integer </b>
     */
    public void visit( PrimTypeInteger n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>primitiveType ::= OclAny </b>
     */
    public void visit( PrimTypeOclAny n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>primitiveType ::= OclInvalid </b>
     */
    public void visit( PrimTypeOclInvalid n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>primitiveType ::= OclVoid </b>
     */
    public void visit( PrimTypeOclVoid n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>Rule 35: primitiveType ::= Real </b>
     */
    public void visit( PrimTypeReal n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>primitiveType ::= String </b>
     */
    public void visit( PrimTypeString n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>realLiteral ::= REAL_LITERAL </b>
     */
    public void visit( RealLiteral n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>varPathName ::= self </b>
     */
    public void visit( Self n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>Rule 43: collectionKind ::= Sequence </b>
     */
    public void visit( SequenceKind n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>collectionKind ::= Set </b>
     */
    public void visit( SetKind n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>stringLiteral ::= STRING_LITERAL </b>
     */
    public void visit( StringLiteral n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>timeExpression ::= ATPRE </b>
     */
    public void visit( TimeExpressionOpt n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>tupleLiteral ::= Tuple { variableAssignmentM } </b>
     */
    public void visit( TupleLiteral n ) {

        append( n.getLeftIToken( ) );
        append( nextIToken( n.getLeftIToken( ) ) );
        space( );
        if ( n.getvariableAssignmentM( ) != null ) {
            accept( n.getvariableAssignmentM( ) );
            space( );
        }
        append( n.getRightIToken( ) );
    }

    @Override
    /*
     * <b> <li>tupleType ::= Tuple ( variableDeclarationWithTypeM ) </b>
     */
    public void visit( TupleType n ) {

        append( n.getLeftIToken( ) );
        append( nextIToken( n.getLeftIToken( ) ) );
        space( );
        if ( n.getvariableDeclarationWithTypeM( ) != null ) {
            accept( n.getvariableDeclarationWithTypeM( ) );
            space( );
        }
        append( n.getRightIToken( ) );
    }

    @Override
    /*
     * <b> <li>varPathName ::= typeLiteral </b>
     */
    public void visit( TypeLiteral n ) {

        append( n.getLeftIToken( ) );
    }

    @Override
    /*
     * <b> <li>varPathName ::= sPathName timeExpressionOpt
     * associationQualifierOpt</b>
     */
    public void visit( Variable n ) {

        accept( n.getpathName( ) );
        if ( n.gettimeExpressionOpt( ) != null )
            accept( n.gettimeExpressionOpt( ) );
        if ( n.getassociationQualifierOpt( ) != null )
            accept( n.getassociationQualifierOpt( ) );

    }

    @Override
    /*
     * <b> <li>variableAssignment ::= identifier withTypeExpressionOpt =
     * oclExpression </b>
     */
    public void visit( VariableAssignment n ) {

        accept( n.getidentifier( ) );
        space( );
        if ( n.getwithTypeExpressionOpt( ) != null ) {
            accept( n.getwithTypeExpressionOpt( ) );
            space( );
        }
        append( prevIToken( (Node) n.getoclExpression( ) ) );
        space( );
        markLineBreak( true );
        accept( n.getoclExpression( ) );

    }

    @Override
    /*
     * <b> <li>variableAssignmentN ::= variableAssignment , variableAssignmentN
     * </b>
     */
    public void visit( VariableAssignmentN n ) {

        accept( n.getvariableAssignment( ) );
        append( nextIToken( n.getvariableAssignment( ) ) );
        space( );
        markLineBreak( this.notLetExpr );
        accept( n.getvariableAssignmentN( ) );

    }

    @Override
    /*
     * <b> <li>variableAssignmentWithType ::= identifier withTypeExpression =
     * oclExpression </b>
     */
    public void visit( VariableAssignmentWithType n ) {

        accept( n.getidentifier( ) );
        space( );
        accept( n.getwithTypeExpression( ) );
        space( );
        append( nextIToken( n.getwithTypeExpression( ) ) );
        space( );
        accept( n.getoclExpression( ) );
    }

    @Override
    public void visit( com.sap.tc.moin.ocl.parser.gen.oclAst.VariableDeclaration n ) {

        accept( n.getidentifier( ) );
        if ( n.getwithTypeExpressionOpt( ) != null )
            accept( n.getwithTypeExpressionOpt( ) );

    }

    @Override
    /*
     * <b> <li>variableDeclarationWithType ::= identifier withTypeExpression
     * </b>
     */
    public void visit( VariableDeclarationWithType n ) {

        accept( n.getidentifier( ) );
        space( );
        accept( n.getwithTypeExpression( ) );
    }

    @Override
    /*
     * <b> <li>variableDeclarationWithTypeN ::= variableDeclarationWithType ,
     * variableDeclarationWithTypeN </b>
     */
    public void visit( VariableDeclarationWithTypeN n ) {

        accept( n.getvariableDeclarationWithType( ) );
        append( nextIToken( n.getvariableDeclarationWithType( ) ) );
        space( );
        accept( n.getvariableDeclarationWithTypeN( ) );
    }

    @Override
    /*
     * <b> <li>withTypeExpression ::= : typePathName </b>
     */
    public void visit( WithTypeExpression n ) {

        append( n.getLeftIToken( ) );
        space( );
        accept( n.gettypePathName( ) );

    }

    @Override
    /*
     * <b> <li>booleanExpression ::= booleanExpression xor relationalExpression
     * </b>
     */
    public void visit( XorBooleanExpression n ) {

//        accept( n.getbooleanExpression( ) );
//        space( );
//        append( nextIToken( (Node) n.getbooleanExpression( ) ) );
//        space( );
//        markLineBreak( true );
//        accept( n.getrelationalExpression( ) );
        infixOperation( n.getbooleanExpression( ), n.getrelationalExpression( ), nextIToken( (Node) n.getbooleanExpression( ) ) );
    }

    @Override
    /*
     * <b> <li>Rule 70: classifierContextDecl ::= context sPathName invOrDefN
     * </b>
     */
    public void visit( ClassifierContextDecl n ) {

        append( n.getLeftIToken( ) );
        space( );
        accept( n.getsPathName( ) );
        shiftRight( );
        newLine( );
        accept( n.getinvOrDefN( ) );
        shiftLeft( );

    }

}