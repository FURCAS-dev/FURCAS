package com.sap.furcas.runtime.parser.textblocks;

import static com.sap.furcas.runtime.textblocks.TbNavigationUtil.getParentBlock;

import java.util.Stack;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ContextTags;
import com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.common.implementation.ResolvedModelElementProxy;
import com.sap.furcas.runtime.parser.impl.ContextBuilder;

public class TbParsingUtil {

    
    /**
     * Starting at the text block <tt>fromHereOutwards</tt> constructs a context stack using the
     * <tt>contextBuilder</tt>. Ascends the text block structure, and each block that was created
     * by a "context" template will add a context using the <tt>contextBuilder</tt>. The context
     * contents created by <tt>addToContext</tt> templates will <em>not</em> be added to these
     * contexts here.
     *
     * @param fromHereOutwards
     * @param contextBuilder
     */
    public static void constructContext(DocumentNode fromHereOutwards, ContextBuilder contextBuilder) {
	TextBlock parentBlock = getParentBlock(fromHereOutwards);
	Stack<TextBlock> contextStack = new Stack<TextBlock>();
	while (parentBlock != null) {
	    if (parentBlock.getType() != null) {
		Template template = parentBlock.getType().getParseRule();
		if ((template instanceof ContextTemplate && ((ContextTemplate) template).isIsContext())) {
		    contextStack.push(parentBlock);
		}
	    }
	    parentBlock = parentBlock.getParent();
	}
	while (!contextStack.isEmpty()) {
	    TextBlock t = contextStack.pop();
	    ContextTags tags = null;
	    Template template = t.getType().getParseRule();
	    if (template instanceof ContextTemplate) {
		tags = ((ContextTemplate) template).getContextTags();
	    }
	    if (tags != null) {
		for (EObject element : t.getCorrespondingModelElements()) {
		    contextBuilder.addContext(new ResolvedModelElementProxy(element), tags.getTags()
				.toArray(new String[0]));
		}
	    } else {
		for (EObject element : t.getCorrespondingModelElements()) {
		 // FIXME I saw a case where the iterator did not produce any elements!
			contextBuilder.addContext(new ResolvedModelElementProxy(element));
		}
	    }
	    for (EObject elementInContext : t.getElementsInContext()) {
		contextBuilder.addToCurrentContext(new ResolvedModelElementProxy(elementInContext));
	    }
	}
    }
}
