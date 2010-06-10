package com.sap.mi.textual.parsing.textblocks;

import java.util.Collection;

import textblocks.TextBlock;

import com.sap.mi.textual.parsing.textblocks.observer.TextBlockProxy;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public interface ModelElementFromTextBlocksFactory {
	Collection<? extends RefObject> createModelElementsFromTextBlock(
			TextBlockProxy newVersionProxy, TextBlock textBlock, TextBlock parent, ModelPartition defaultPartition) ;
}
