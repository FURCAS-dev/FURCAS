package com.sap.ide.cts.editor.prettyprint.textblocks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import tcs.ConcreteSyntax;
import tcs.Template;
import textblocks.TextBlock;

import com.sap.ide.cts.editor.CtsActivator;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * <p>
 * A simple class used to index TextBlocks so that those can be easily searched
 * by the {@link TextBlockPrettyPrintingTraverser}, which needs to know
 * if we have already have old TextBlocks for existing model elements.
 * </p>
 * 
 * The method {@link #index(TextBlock)} should be called for each potentially
 * reusable TextBlocks tree.
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class TextBlockIndex {

    private static class ModelElementKey {
	
	public final RefObject correspondingModelElement;
	private final ConcreteSyntax syntax;
	private final Template template;
	
	public ModelElementKey(ConcreteSyntax syntax, Template template, RefObject correspondingModelElement) {
	    this.template = template;
	    this.correspondingModelElement = correspondingModelElement;
	    this.syntax = syntax;
	}
	
	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((correspondingModelElement == null) ? 0 : correspondingModelElement.hashCode());
	    result = prime * result + ((syntax == null) ? 0 : syntax.hashCode());
	    result = prime * result + ((template == null) ? 0 : template.hashCode());
	    return result;
	}

	@Override
	public boolean equals(Object obj) {
	    if (!(obj instanceof ModelElementKey)) {
		return false;
	    }
	    ModelElementKey other = (ModelElementKey) obj;
		return other.correspondingModelElement.equals(this.correspondingModelElement) && other.syntax.equals(this.syntax) &&
			(other.template == null && this.template == null || other.template.equals(this.template)); 
	}
    }
        
    private final Map<ModelElementKey, Collection<TextBlock>> blockIndexPerModelElement = new HashMap<ModelElementKey, Collection<TextBlock>>();
    private final TextBlockIndex sharedTextBlocksIndex;
    

    /**
     * Create an empty index;
     */
    public TextBlockIndex() {
	// use empty backing index.
	this(null);
    }
    
    /**
     * Create an index with a backing index that will be used as a fallback
     * if nothing if found within this index. The backing index will never be modified; 
     * 
     * @param sharedTextBlocksIndex
     */
    public TextBlockIndex( TextBlockIndex sharedTextBlocksIndex) {
	this.sharedTextBlocksIndex = sharedTextBlocksIndex;
    }

    /**
     * Recursively stores the given TextBlock and all its subBlocks within this index.
     */
    public void index(TextBlock textBlock) {
	if (textBlock.getType() == null) {
	    CtsActivator.logWarning("Not indexing TextBlock due to broken mapping: " + textBlock);
	    return;
	}
	
	storePerTemplateAndModelElement(textBlock);
	storePerModelElement(textBlock);
	
	for (TextBlock subBlock : textBlock.getSubBlocks()) {
	    index(subBlock);
	}
    }

    private void storePerModelElement(TextBlock textBlock) {
	Template template = textBlock.getType().getParseRule();
	for (RefObject correspondingModelElement : textBlock.getCorrespondingModelElements()) {
	    if (!correspondingModelElement.is___Alive()) {
		// if the model element is gone, then there is no reason to keep this textblock
		return;
	    }
	    ModelElementKey key = new ModelElementKey(template.getConcretesyntax(), /*template*/ null, correspondingModelElement);
	    getBlockListForKey(key).add(textBlock);
	}
    }

    private void storePerTemplateAndModelElement(TextBlock textBlock) {
	Template template = textBlock.getType().getParseRule();
	for (RefObject correspondingModelElement : textBlock.getCorrespondingModelElements()) {
	    if (!correspondingModelElement.is___Alive()) {
		// if the model element is gone, then there is no reason to keep this textblock
		return;
	    }
	    ModelElementKey key = new ModelElementKey(template.getConcretesyntax(), template, correspondingModelElement);
	    getBlockListForKey(key).add(textBlock);
	}
    }
    
    private Collection<TextBlock> getBlockListForKey(ModelElementKey key) {
	if (!blockIndexPerModelElement.containsKey(key)) {
	    blockIndexPerModelElement.put(key, new ArrayList<TextBlock>(1));
	}
	return blockIndexPerModelElement.get(key);
    }
    
    /**
     * Returns null if nothing was found.
     * 
     * @param template
     * @param correspondingModelElement
     * @return
     */
    public Collection<TextBlock> findTextBlock(ConcreteSyntax syntax, Template template, RefObject correspondingModelElement) {
	Collection<TextBlock> found = null;
	
	found = getBlockListForKey(new ModelElementKey(syntax, template, correspondingModelElement));
	if (!found.isEmpty()) {
	    return found;
	}
	found = getBlockListForKey(new ModelElementKey(syntax, /*template*/ null, correspondingModelElement));
	if (!found.isEmpty()) {
	    return found;
	}
	// fallback
	if (sharedTextBlocksIndex == null) {
	    return Collections.emptyList();
	} else {
	    return sharedTextBlocksIndex.findTextBlock(syntax, template, correspondingModelElement);
	}
    }
    
}
