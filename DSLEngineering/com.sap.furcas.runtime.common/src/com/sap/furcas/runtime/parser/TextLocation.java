/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-04-23 14:54:43 +0200 (Do, 23 Apr 2009) $
 * Revision: $Revision: 6272 $
 * Author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.runtime.parser;

 

/**
 * serves to store locations in a text. A location starts within some line, 
 * and ends within a line, where the second line must be greater or equal 
 * to the first, and if equal the position must be greater than the first.
 */
public class TextLocation {

    private int index, stopindex, startLine, endLine, startPosition, endPosition;

    /**
     *  Creates a Text location object, positioning data in both the startindex-endindex format, as well as in the line, column - line,column format
     * @param index (position of first char of location in document)
     * @param stopIndex (position of last char of location in document)
     * @param startLine
     * @param startPosition
     * @param endLine
     * @param endPosition
     */
    public TextLocation(int index, int stopIndex, int startLine, int startPosition, int endLine,
            int endPosition) {
        super();
        this.startLine = startLine;
        this.startPosition = startPosition;
        this.endLine = endLine;  
        this.endPosition = endPosition;
        this.index = index;  
        this.stopindex = stopIndex;
        
    }
    
    /**
     * self-explaining Constructor.
     * @param startLine
     * @param endLine
     * @param startPosition
     * @param endPosition
     */
    public TextLocation(ANTLR3LocationToken token) {
        super();
        if (token != null) {
            this.startLine = token.getLine();
            this.startPosition = token.getCharPositionInLine();
            this.endLine = token.getEndLine();  
            this.endPosition = token.getEndColumn();
            this.index = token.getStartIndex();  
            this.stopindex = token.getStopIndex()+1;
        } else {
            this.index = -1;
            this.stopindex = -1;
            this.startLine = 0;
            this.endLine = 0;
            this.startPosition = 0;
            this.endPosition = 0;
        }
    }
    
    
    
    public int getStartLine() {
        return startLine;
    }

    public int getEndLine() {
        return endLine;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }
    

    @Override
    public String toString() {
        return new StringBuilder().append(getStartLine()).append(':')
        .append(getStartPosition()).append('-')
        .append(getEndLine()).append(':')
        .append(getEndPosition())
        .toString();
    }

    public int getIndex() {
        return index;
    }

    public int getStopIndex() {
        return stopindex;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + endLine;
        result = prime * result + endPosition;
        result = prime * result + index;
        result = prime * result + startLine;
        result = prime * result + startPosition;
        result = prime * result + stopindex;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TextLocation other = (TextLocation) obj;
        if (endLine != other.endLine) {
            return false;
        }
        if (endPosition != other.endPosition) {
            return false;
        }
        if (index != other.index) {
            return false;
        }
        if (startLine != other.startLine) {
            return false;
        }
        if (startPosition != other.startPosition) {
            return false;
        }
        if (stopindex != other.stopindex) {
            return false;
        }
        return true;
    }
    
    
}
