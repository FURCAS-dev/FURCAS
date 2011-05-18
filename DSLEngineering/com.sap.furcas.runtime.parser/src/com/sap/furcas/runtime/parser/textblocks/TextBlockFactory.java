package com.sap.furcas.runtime.parser.textblocks;

import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.common.exceptions.DeferredModelElementCreationException;
import com.sap.furcas.runtime.parser.textblocks.observer.TextBlockProxy;

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
	TextBlock createNewTextBlock(TextBlockProxy proxy, TextBlock parent) throws DeferredModelElementCreationException;

}
