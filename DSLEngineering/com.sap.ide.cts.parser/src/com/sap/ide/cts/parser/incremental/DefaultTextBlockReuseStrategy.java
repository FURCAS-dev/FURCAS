package com.sap.ide.cts.parser.incremental;

import java.util.ArrayList;
import java.util.Collection;

import textblocks.AbstractToken;
import textblocks.TextBlock;

import com.sap.mi.textual.parsing.textblocks.TextBlockFactory;
import com.sap.mi.textual.parsing.textblocks.observer.TextBlockProxy;
import com.sap.tc.moin.repository.ModelPartition;

public class DefaultTextBlockReuseStrategy implements TextBlockReuseStrategy {

	private TextBlockFactory creator;
	private Collection<TextBlock> changedTbs = new ArrayList<TextBlock>();
	private IncrementalParser incParser;

	@Override
	public boolean canBeReUsed(AbstractToken candidate, Object newToken) {
		return false;
	}

	@Override
	public TbBean reuseTextBlock(TextBlock oldVersion, TextBlockProxy newVersion, ModelPartition defaultPartition) {
		//default is to never reuse 
		TextBlock newTb = creator.createNewTextBlock(newVersion, oldVersion.getParentBlock(), defaultPartition);
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
