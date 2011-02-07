package com.sap.furcas.ide.editor.imp.services;
import org.eclipse.imp.services.base.TreeModelBuilderBase;

import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;

/**
 * A model builder for the IMP outline view. It works together with the
 * {@link FurcasLabelProvider}.
 * 
 * This class is generic and does not need a language specific implementation.
 * 
 * @author Stephan Erb
 *
 */
public class FurcasTreeModelBuilder extends TreeModelBuilderBase {

    @Override
    public void visitTree(Object astNode) {
        TextBlock node = (TextBlock) astNode;
        for (DocumentNode childNode : node.getSubBlocks()) {
            pushSubItem(childNode);
            visitTree(childNode);
            popSubItem();
        }
    }

}
