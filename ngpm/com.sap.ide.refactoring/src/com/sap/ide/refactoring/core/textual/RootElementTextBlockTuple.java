package com.sap.ide.refactoring.core.textual;

import textblocks.TextBlock;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;


/**
 * Represents the union of a root textblock and a corresponding root model element.
 * For each tuple changed by a refactoring, we show a new change object in the
 * refactoring UI. 
 * 
 * 
 * @see ModelElementDocumentNodeChangeDescriptor 
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class RootElementTextBlockTuple {

    public final RefObject modelElement;
    public final TextBlock textBlock;
    
    public RootElementTextBlockTuple(RefObject modelElement, TextBlock textBlock) {
        this.modelElement = modelElement;
	this.textBlock = textBlock;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((modelElement == null) ? 0 : modelElement.hashCode());
	result = prime * result + ((textBlock == null) ? 0 : textBlock.hashCode());
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
	RootElementTextBlockTuple other = (RootElementTextBlockTuple) obj;
	return modelElement == other.modelElement && textBlock == other.textBlock;
    }
}
