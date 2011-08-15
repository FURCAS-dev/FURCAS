/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.ide.editor.imp.services;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.imp.editor.ModelTreeNode;
import org.eclipse.imp.parser.ISourcePositionLocator;

import com.sap.furcas.ide.editor.imp.FurcasParseController;
import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;
import com.sap.ide.cts.parser.incremental.IncrementalParser.TextBlocksTarjanTreeContentProvider;
import com.sap.ide.cts.parser.incremental.util.TarjansLCA;

/**
 * Allows IMP to inspect the "AST" nodes returned by our {@link FurcasParseController}.
 * In case of the letter these are always {@link DocumentNode}s.
 * 
 * @author Stephan Erb
 *
 */
public class FurcasSourcePositionLocator implements ISourcePositionLocator {
    
    @Override
    public Object findNode(Object astRoot, int offset) {
        TextBlock rootBlock = (TextBlock) astRoot;
        TextBlocksModel textBlockModel = new TextBlocksModel(rootBlock);
        
        return textBlockModel.getFloorTokenInRoot(offset);
    }

    @Override
    public Object findNode(Object astRoot, int startOffset, int endOffset) {
        TextBlock rootBlock = (TextBlock) astRoot;
        TextBlocksModel textBlockModel = new TextBlocksModel(rootBlock);
        
        DocumentNode leftMostSelectedNode = textBlockModel.getFloorTokenInRoot(startOffset);
        DocumentNode rightMostSelectedNode = textBlockModel.getFloorTokenInRoot(endOffset);

        // Handle special case that exactly a whole textblock is selected.
        // We use this LCA shortcut as it is (much) faster than #getNodesBetweenAsRootSet.
        TarjansLCA<DocumentNode> lca = new TarjansLCA<DocumentNode>(new TextBlocksTarjanTreeContentProvider());
        DocumentNode commonAncestor = lca.lcaSearch(textBlockModel.getRoot(), leftMostSelectedNode, rightMostSelectedNode);

        DocumentNode leftMostAncestorNode = TbNavigationUtil.firstToken(commonAncestor); // could be BOS token
        DocumentNode rightMostAncestorNode = TbNavigationUtil.lastToken(commonAncestor); // could be EOS token

        // special case handling for omitted BOS/EOS token
        boolean equalLeftMostToken = leftMostAncestorNode.equals(leftMostSelectedNode) || leftMostAncestorNode instanceof Bostoken &&
                TbNavigationUtil.getNextInSubTree(leftMostAncestorNode).equals(leftMostSelectedNode);
        boolean equalRightMostToken = rightMostAncestorNode.equals(rightMostSelectedNode)  || rightMostAncestorNode instanceof Eostoken &&
                TbNavigationUtil.getPreviousInSubTree(rightMostAncestorNode).equals(rightMostSelectedNode);

        if (equalLeftMostToken && equalRightMostToken) {
            return Collections.singletonList(commonAncestor);
        } else {
            return textBlockModel.getNodesBetweenAsRootSet(textBlockModel.getRoot(), startOffset, endOffset);
        }
    }

    @Override
     public int getStartOffset(Object entity) {
        if (entity instanceof TextBlock) {
            TextBlock tb = (TextBlock) entity;
            return TbUtil.getAbsoluteOffsetWithoutBlanks(tb);
        } else if (entity instanceof DocumentNode) {
            return TbUtil.getAbsoluteOffset((DocumentNode) entity);
        } 
        if (entity instanceof ModelTreeNode) {
            return getStartOffset(((ModelTreeNode) entity).getASTNode());
        }
        throw new AssertionError("Unknown entity type " + entity.getClass());
    }

    @Override
    public int getEndOffset(Object entity) {
        if (entity instanceof TextBlock) {
            TextBlock tb = (TextBlock) entity;
            return TbUtil.getAbsoluteOffsetWithoutBlanks(tb) + getLength(tb)  - 1;
        } else if (entity instanceof DocumentNode) {
            DocumentNode node = (DocumentNode) entity;
            return TbUtil.getAbsoluteOffset(node) + getLength(node) - 1;
        } 
        if (entity instanceof ModelTreeNode) {
            return getEndOffset(((ModelTreeNode) entity).getASTNode());
        }
        throw new AssertionError("Unknown entity type " + entity.getClass());
    }

    @Override
    public int getLength(Object entity) {
        if (entity instanceof TextBlock) {
            TextBlock tb = (TextBlock) entity;
            return TbUtil.getLengthWithoutStartingBlanks(tb);
        } else if (entity instanceof DocumentNode) {
            DocumentNode node = (DocumentNode) entity;
            return node.getLength();
        } 
        if (entity instanceof ModelTreeNode) {
            return getLength(((ModelTreeNode) entity).getASTNode());
        }
        throw new AssertionError("Unknown entity type " + entity.getClass());
    }

    @Override
    public IPath getPath(Object node) {
        if (node instanceof DocumentNode) {
            return new Path(((DocumentNode) node).eResource().getURI().toFileString());
        } 
        if (node instanceof ModelTreeNode) {
            return getPath(((ModelTreeNode) node).getASTNode());
        }
        throw new AssertionError("Unknown entity type " + node.getClass());
    }
    
    
    /**
     * Find the TextBlock representing the given modelElement within the tree under
     * the given rootBlock. It is assumed that there can only be one.
     */
    public TextBlock findTextBlockOf(TextBlock rootBlock, EObject modelElement, ResourceSet resourceSet) {
        Collection<TextBlock> result = TbUtil.findTextBlockOf(rootBlock, modelElement, resourceSet);
        if (result.size() == 0) {
            return null;
        } else {
            assert result.size() == 1;
            return result.iterator().next();
        }
    }

}
