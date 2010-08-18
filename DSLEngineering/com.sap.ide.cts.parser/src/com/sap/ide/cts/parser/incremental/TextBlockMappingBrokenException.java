package com.sap.ide.cts.parser.incremental;

import com.sap.furcas.metamodel.textblocks.TextBlock;

public class TextBlockMappingBrokenException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 9219821413600357353L;
    private final TextBlock block; 
    
    public TextBlockMappingBrokenException(TextBlock block) {
	this.block = block;
    }
    
    public TextBlock getBlock() {
        return block;
    }
}
