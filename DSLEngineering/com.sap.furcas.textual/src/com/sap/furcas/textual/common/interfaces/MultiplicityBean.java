/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-04-23 14:54:43 +0200 (Do, 23 Apr 2009) $
 * @version $Revision: 6272 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.textual.common.interfaces;


/**
 * The Class MultiplicityBean.
 */
public class MultiplicityBean {

	@Override
    public String toString() {
        return super.toString() + '(' + lowerBound + ',' + upperBound + ')';
    }

	private int lowerBound = 1;
	private int upperBound = 1;
	
	/**
	 * Checks if is optional.
	 * 
	 * @return true, if is optional
	 */
	public boolean isOptional() {
		return lowerBound <=0;
	}
	

	

    @Override
    public int hashCode() {
        // semantically all negative upper bounds are equal
        int semanticupperBound = -1;
        if (upperBound > -1) {
            semanticupperBound = upperBound;
        }
        int semanticlowerBound = 0;
        if (lowerBound > 0) {
            semanticlowerBound = lowerBound;
        }
        final int prime = 31;
        int result = 1;
        result = prime * result + semanticlowerBound;
        result = prime * result + semanticupperBound;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final MultiplicityBean other = (MultiplicityBean) obj;
        int semanticlowerBound = 0;
        if (lowerBound > 0) {
            semanticlowerBound = lowerBound;
        }
        int othersemanticlowerBound = 0;
        if (other.lowerBound > 0) {
            othersemanticlowerBound = other.lowerBound;
        }
        if (semanticlowerBound != othersemanticlowerBound)
            return false;
        
        // semantically all negative upper bounds are equal
        int semanticupperBound = -1;
        if (upperBound > -1) {
            semanticupperBound = upperBound;
        }
        int semanticOtherUpperBound = -1;
        if (other.upperBound > -1) {
            semanticOtherUpperBound = other.upperBound;
        }
        if (semanticupperBound != semanticOtherUpperBound)
            return false;
        return true;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    /**
     * @return
     */
    public boolean isMultiple() {
        return getUpperBound() < 0 || getUpperBound() > 1;
    }




    public int getLowerBound() {
        return lowerBound;
    }




    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

	
}
