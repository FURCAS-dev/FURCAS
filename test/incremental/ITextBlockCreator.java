package com.sap.ide.cts.parser.incremental;

import textblocks.TextBlock;

import com.sap.mi.textual.parsing.textblocks.observer.TextBlockProxy;

public interface ITextBlockCreator {

	TextBlock createNewTextBlock(TextBlockProxy proxy, TextBlock parent);

}
