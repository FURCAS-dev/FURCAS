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
 * The Class ParsingError.
 */
public class ParsingError {

	/** The message. */
	private final String message;
	
	private TextLocation location;
	
    public int getIndex() {
        return location.getIndex();
    }

    public int getStopIndex() {
        return location.getStopIndex();
    }

    public ParsingError(String message, ANTLR3LocationToken token) {
        this.message = message;
        this.location = new TextLocation(token);
        if (this.location == null) {
            this.location = new TextLocation(0,0,0,0,0,0);
        }
    }
    
    public ParsingError(String message, TextLocation location) {
        this.message = message;
        this.location = location;
        if (this.location == null) {
            this.location = new TextLocation(0,0,0,0,0,0);
        }
    }
    
//    /**
//     * Instantiates a new parsing error.
//     * 
//     * @param message the message
//     * @param line the line
//     * @param position the position
//     * @param endLine 
//     * @param endPosition 
//     */
//    public ParsingError(String message, int index, int stopIndex, int line, int position, int endLine, int endPosition) {
//        super();
//        this.message = message;
//        location = new TextLocation(index, stopIndex, line, position, endLine, endPosition);
//        
//    }
    
	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Gets the line.
	 * 
	 * @return the line
	 */
	public int getLine() {
		return location.getStartLine();
	}
	
	/**
	 * Gets the position.
	 * 
	 * @return the position
	 */
	public int getPosition() {
		return location.getStartPosition();
	}

    public int getEndLine() {
        return location.getEndLine();
    }

    public int getEndPosition() {
        return location.getEndPosition();
    }

    public TextLocation getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "ParsingError: \"" + this.getMessage() +  "\" at " +  this.getLine() + ":" + getPosition() + "-" + getEndLine() + ":" + getEndPosition();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((location == null) ? 0 : location.hashCode());
        result = prime * result + ((message == null) ? 0 : message.hashCode());
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
        final ParsingError other = (ParsingError) obj;
        if (location == null) {
            if (other.location != null) {
                return false;
            }
        } else if (!location.equals(other.location)) {
            return false;
        }
        if (message == null) {
            if (other.message != null) {
                return false;
            }
        } else if (!message.equals(other.message)) {
            return false;
        }
        return true;
    }
	
    
    
}
