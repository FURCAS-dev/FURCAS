package com.sap.ide.cts.parser.incremental;

import java.util.ArrayList;
import java.util.Collection;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.common.exceptions.DeferredModelElementCreationException;
import com.sap.furcas.runtime.parser.textblocks.TextBlockFactory;
import com.sap.furcas.runtime.parser.textblocks.observer.TextBlockProxy;

public class DefaultTextBlockReuseStrategy implements TextBlockReuseStrategy {

	private TextBlockFactory creator;
	private final Collection<TextBlock> changedTbs = new ArrayList<TextBlock>();

	@Override
	public boolean canBeReUsed(AbstractToken candidate, Object newToken) {
		return false;
	}

	@Override
	public TbBean reuseTextBlock(TextBlock oldVersion, TextBlockProxy newVersion) throws DeferredModelElementCreationException {
		//default is to never reuse 
		TextBlock newTb = creator.createNewTextBlock(newVersion, oldVersion.getParent());
		changedTbs.add(newTb);
		return new TbBean(newTb, true, ReuseType.DELETE);
	}

	@Override
	public void setReferenceHandler(ReferenceHandler handler) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setTextBlockFactory(TextBlockFactory creator) {
		this.creator = creator;
	}

	@Override
	public void notifyTokenReuse(AbstractToken subNode) {
	    // TODO Auto-generated method stub
	    
	}

	@Override
	public void clearChangedBlocksList() {
		changedTbs.clear();
	}

	@Override
	public Collection<TextBlock> getChangedBlocks() {
		return changedTbs;
	}

}
