/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-04-23 14:54:43 +0200 (Do, 23 Apr 2009) $
 * @version $Revision: 6272 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator.util;

import java.io.IOException;

/**
 * StringBuffer clone to use varchar notation, for readability of code.
 */
public class VarStringBuffer implements Appendable, CharSequence {

    private StringBuilder buffer;
    
    
    
    public VarStringBuffer() {
        super();
        buffer = new StringBuilder();
    }
    
    public VarStringBuffer(int initSize) {
        super();
        buffer = new StringBuilder(initSize);
    }
    
    public VarStringBuffer(StringBuilder initBuffer) {
        super();
        buffer = initBuffer;
    }
    

    /* (non-Javadoc)
     * @see java.lang.Appendable#append(java.lang.CharSequence)
     */
    public VarStringBuffer append(CharSequence csq)  {
       buffer.append(csq);
       return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Appendable#append(char)
     */
    public VarStringBuffer append(char c)  {
        buffer.append(c);
        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Appendable#append(java.lang.CharSequence, int, int)
     */
    public VarStringBuffer append(CharSequence csq, int start, int end)
            throws IOException {
        buffer.append(csq, start, end);
        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.CharSequence#charAt(int)
     */
    public char charAt(int index) {
        return buffer.charAt(index);
    }

    /* (non-Javadoc)
     * @see java.lang.CharSequence#length()
     */
    public int length() {
        return buffer.length();
    }

    /* (non-Javadoc)
     * @see java.lang.CharSequence#subSequence(int, int)
     */
    public CharSequence subSequence(int start, int end) {
        return buffer.subSequence(start, end);
    }
    
    public VarStringBuffer append(Object obj) {
        if (obj != null) {
            buffer.append(String.valueOf(obj));
        }
        return this;
    }
    
    public VarStringBuffer append(Object... objArray) {
        if (objArray != null) {
            for (Object object : objArray) {
                buffer.append(String.valueOf(object));    
            }        
        }
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        return buffer.toString().equals(String.valueOf(obj));
    }

    @Override
    public int hashCode() {
        return buffer.toString().hashCode();
    }

    @Override
    public String toString() {
        return buffer.toString();
    }

    /**
     * @param i
     */
    public void ensureCapacity(int i) {
        buffer.ensureCapacity(i);
    }

}
