package com.sap.ide.cts.parser.incremental;

import textblocks.AbstractToken;
import textblocks.TextBlock;

import com.sap.mi.textual.parsing.textblocks.observer.TextBlockProxy;

public class DefaultTextBlockReuseStrategy implements ITextBlockReuseStrategy {

	private ITextBlockCreator creator;

	@Override
	public boolean canBeReUsed(AbstractToken candidate, Object newToken) {
		return false;
	}

	@Override
	public TbBean reuseTextBlock(TextBlock oldVersion, TextBlockProxy newVersion) {
		//default is to never reuse 
		return new TbBean(creator.createNewTextBlock(newVersion, oldVersion.getParentBlock()), true, ReuseType.DELETE);
	}

	@Override
	public void setReferenceHandler(IReferenceHandler handler) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTextBlockCreator(ITextBlockCreator creator) {
		this.creator = creator;
	}

	@Override
	public void notifyTokenReuse(AbstractToken subNode) {
	    // TODO Auto-generated method stub
	    
	}

}
