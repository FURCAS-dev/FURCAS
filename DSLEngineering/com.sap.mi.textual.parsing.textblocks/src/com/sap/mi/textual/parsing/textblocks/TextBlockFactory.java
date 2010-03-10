package com.sap.mi.textual.parsing.textblocks;

import tcs.Template;
import textblockdefinition.TextBlockDefinition;
import textblocks.TextBlock;

import com.sap.mi.textual.parsing.textblocks.observer.TextBlockProxy;
import com.sap.tc.moin.repository.ModelPartition;

/**
 * Util interface to decouple instantiation of Textblocks.
 */
public interface TextBlockFactory {

	/**
	 * Creates a new empty {@link TextBlock} having set some initial properties.
	 * 
	 * @return a newly instantiated {@link TextBlock}
	 */
	TextBlock createBlock();
	
	/**
	 * Instantiate a new {@link TextBlock} using the information given by the <tt>proxy</tt> and
	 * the given parent {@link TextBlock}
	 * @param proxy the proxy for which to instantiate a new {@link TextBlock}
	 * @param parent The parent to which to add the new proxy.
	 * @return A newly instantiated {@link TextBlock}
	 */
//	TextBlock createNewTextBlock(TextBlockProxy proxy, TextBlock parent);
	TextBlock createNewTextBlock(TextBlockProxy proxy, TextBlock parent,
			ModelPartition defaultPartition);
	
	/**
	 * Retrieves the corresponding {@link TextBlockDefinition} for a given {@link Template}.
	 * A new {@link TextBlockDefinition} should be created if none exists. This should furthermore be 
	 * the same for each template.
	 * 
	 * @param template The template for which to search the {@link TextBlockDefinition}
	 * @return the found {@link TextBlockDefinition} or a new one if none exists.
	 */
	TextBlockDefinition getTbDef(Template template);

	
}
