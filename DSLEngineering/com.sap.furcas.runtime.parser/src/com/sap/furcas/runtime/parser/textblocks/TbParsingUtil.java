package com.sap.furcas.runtime.parser.textblocks;

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
     * Starting at the text block <tt>fromHereOutwards</tt> constructs a context stack using the <tt>contextBuilder</tt>
     * . Ascends the text block structure, and each block that was created by a "context" template will add a context
     * using the <tt>contextBuilder</tt>. The context contents created by <tt>addToContext</tt> templates will
     * <em>not</em> be added to these contexts here.
     * 
     * @param fromHereOutwards
     *            the first block checked for belonging to a {@link ContextTemplate} with
     *            <code>{@link ContextTemplate#isIsContext()}==true</code>. It is permissible
     *            to pass <code>null</code> turning the call into a no-op.
     * @param contextBuilder
     *            the contexts discovered starting from <code>fromHereOutwards</code> (inclusive) are
     *            {@link ContextBuilder#addContext(com.sap.furcas.runtime.common.interfaces.IModelElementProxy, String...)
     *            added} to this context builder. All elements <em>in</em> those contexts (see
     *            {@link TextBlock#getElementsInContext()}) are {@link ContextBuilder#addToCurrentContext(Object) added}
     *            to their respective contexts on this context builder.
     */
    public static void constructContext(DocumentNode fromHereOutwards, ContextBuilder contextBuilder) {
	TextBlock parentBlock = fromHereOutwards == null ? null :
	    fromHereOutwards instanceof TextBlock ? (TextBlock) fromHereOutwards : fromHereOutwards.getParent();
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
	        // The correspondingModelElements not only contain the element produced by t's
	        // parseRule but also those produced by other templates and foreach property inits
	        // TODO When there is more than one element in the correspondingModelElements, decide whether additionalTemplate or template used by foreach-propinit hasContext
	        if (!t.getCorrespondingModelElements().isEmpty()) {
                    // FIXME I saw a case where the iterator did not produce any elements!
                    // FIXME ...and I saw a case where additional correspondingModelElements were produced by additionalTemplates or foreach propinits that are not context
	            // currently, only the first correspondingModelElement is used because only it was created by the parseRule
	            contextBuilder.addContext(new ResolvedModelElementProxy(t.getCorrespondingModelElements().iterator().next()));
	        }
	    }
	    for (EObject elementInContext : t.getElementsInContext()) {
		contextBuilder.addToCurrentContext(new ResolvedModelElementProxy(elementInContext));
	    }
	}
    }
}
