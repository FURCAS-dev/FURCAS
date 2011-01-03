/*******************************************************************************
 * Copyright (c) 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.unparser.textblocks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;

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
	
	public final EObject correspondingModelElement;
	private final ConcreteSyntax syntax;
	private final Template template;
	
	public ModelElementKey(ConcreteSyntax syntax, Template template, EObject correspondingModelElement) {
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
// FIXME
//	    CtsActivator.logWarning("Not indexing TextBlock due to broken mapping: " + textBlock);
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
	for (EObject correspondingModelElement : textBlock.getCorrespondingModelElements()) {
// FIXME
//	    if (!correspondingModelElement.is___Alive()) {
//		// if the model element is gone, then there is no reason to keep this textblock
//		return;
//	    }
	    ModelElementKey key = new ModelElementKey(template.getConcreteSyntax(), /*template*/ null, correspondingModelElement);
	    getBlockListForKey(key).add(textBlock);
	}
    }

    private void storePerTemplateAndModelElement(TextBlock textBlock) {
	Template template = textBlock.getType().getParseRule();
	for (EObject correspondingModelElement : textBlock.getCorrespondingModelElements()) {
// FIXME
//	    if (!correspondingModelElement.is___Alive()) {
//		// if the model element is gone, then there is no reason to keep this textblock
//		return;
//	    }
	    ModelElementKey key = new ModelElementKey(template.getConcreteSyntax(), template, correspondingModelElement);
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
    public Collection<TextBlock> findTextBlock(ConcreteSyntax syntax, Template template, EObject correspondingModelElement) {
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
