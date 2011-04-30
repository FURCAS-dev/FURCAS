/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation
 *******************************************************************************/

package org.eclipse.imp.compare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.compare.IEncodedStreamContentAccessor;
import org.eclipse.compare.IResourceProvider;
import org.eclipse.compare.ISharedDocumentAdapter;
import org.eclipse.compare.IStreamContentAccessor;
import org.eclipse.compare.ITypedElement;
import org.eclipse.compare.structuremergeviewer.DocumentRangeNode;
import org.eclipse.compare.structuremergeviewer.IStructureComparator;
import org.eclipse.compare.structuremergeviewer.StructureCreator;
import org.eclipse.compare.structuremergeviewer.StructureRootNode;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.imp.editor.ModelTreeNode;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.language.LanguageRegistry;
import org.eclipse.imp.language.ServiceFactory;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.imp.services.ICompareNodeIdentifier;
import org.eclipse.imp.services.ILabelProvider;
import org.eclipse.imp.services.base.TreeModelBuilderBase;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.graphics.Image;

/**
 * @author rfuhrer
 */
public class ModelStructureCreator extends StructureCreator {
    public class TreeCompareNode extends DocumentRangeNode implements ITypedElement {
        private final Object fASTNode;

        /**
         * @param treeNode
         * @param document
         */
        public TreeCompareNode(ModelTreeNode treeNode, IDocument document) {
            this(null, treeNode, document);
        }

        /**
         * @param parent
         * @param treeNode
         * @param document
         */
        public TreeCompareNode(DocumentRangeNode parent, ModelTreeNode treeNode, IDocument document) {
            super(parent, fCompareNodeIdentifier.getTypeCode(treeNode.getASTNode()), fCompareNodeIdentifier.getID(treeNode.getASTNode()), document,
                  fSrcPositionLocator.getStartOffset(treeNode.getASTNode()), fSrcPositionLocator.getLength(treeNode.getASTNode()));
            fASTNode= treeNode.getASTNode();
        }

        @Override
        public String toString() {
            return getTypeCode() + ":" + getId();
        }

        public Image getImage() {
            return (fLabelProvider != null) ? fLabelProvider.getImage(fASTNode) : null;
        }

        public String getName() {
            return (fLabelProvider != null) ? fLabelProvider.getText(fASTNode) : toString();
        }

        public String getType() {
            return "?type?";
        }
    }

    private Language fLanguage;
    private ICompareNodeIdentifier fCompareNodeIdentifier;
    private ILabelProvider fLabelProvider;
    private ISourcePositionLocator fSrcPositionLocator;

    /**
     * 
     */
    public ModelStructureCreator() { }

    /* (non-Javadoc)
     * @see org.eclipse.compare.structuremergeviewer.IStructureCreator#getName()
     */
    public String getName() {
        return "Structural Comparison";
    }

    /* (non-Javadoc)
     * @see org.eclipse.compare.structuremergeviewer.StructureCreator#createStructureComparator(java.lang.Object, org.eclipse.jface.text.IDocument, org.eclipse.compare.ISharedDocumentAdapter, org.eclipse.core.runtime.IProgressMonitor)
     */
    @Override
    protected IStructureComparator createStructureComparator(Object input, IDocument document, ISharedDocumentAdapter sharedDocumentAdapter, IProgressMonitor monitor) throws CoreException {
        determineLanguage(input, document);

        if (fLanguage != null) {
            ServiceFactory svcFactory= ServiceFactory.getInstance();
            IParseController pc= svcFactory.getParseController(fLanguage);
            fCompareNodeIdentifier= svcFactory.getCompareNodeIdentifier(fLanguage);
            fLabelProvider= svcFactory.getLabelProvider(fLanguage);
            TreeModelBuilderBase builder= svcFactory.getTreeModelBuilder(fLanguage);
            fSrcPositionLocator= pc.getSourcePositionLocator();

            pc.initialize(null, null, null);

            Object astRoot= pc.parse(document.get(), monitor);
            DocumentRangeNode compareRoot;

            if (astRoot != null) {
                ModelTreeNode modelRoot= builder.buildTree(astRoot);

                // now visit the model, creating TreeCompareNodes for each ModelTreeNode
                compareRoot= buildCompareTree(modelRoot, null, document);
            } else {
                compareRoot= new StructureRootNode(document, input, this, sharedDocumentAdapter);
            }
            return compareRoot;
        }
        return null;
    }

    private TreeCompareNode buildCompareTree(ModelTreeNode treeNode, DocumentRangeNode parent, IDocument document) {
        TreeCompareNode compareNode= new TreeCompareNode(parent, treeNode, document);
        for(ModelTreeNode treeChild: treeNode.getChildren()) {
            compareNode.addChild(buildCompareTree(treeChild, compareNode, document));
        }
        return compareNode;
    }

    private void determineLanguage(Object element, IDocument document) {
        if (element instanceof IAdaptable) {
            IResourceProvider resProvider= (IResourceProvider) ((IAdaptable) element).getAdapter(IResourceProvider.class);
            if (resProvider != null) {
                IResource res= resProvider.getResource();
                fLanguage= LanguageRegistry.findLanguage(res.getFullPath(), document);
            }
        } else {
            // Could this StructureCreator ever get called for an 'element' that isn't a resource?
        }
    }

    /* (non-Javadoc)
     * @see org.eclipse.compare.structuremergeviewer.IStructureCreator#getContents(java.lang.Object, boolean)
     */
    public String getContents(Object node, boolean ignoreWhitespace) {
        if (node instanceof IStreamContentAccessor) {
            IStreamContentAccessor sca = (IStreamContentAccessor) node;
            try {
                return readString(sca);
            } catch (CoreException ex) {
            }
        }
        return null;
    }

    private static String readString(InputStream is, String encoding) {
        if (is == null)
            return null;
        BufferedReader reader = null;
        try {
            StringBuffer buffer = new StringBuffer();
            char[] part = new char[2048];
            int read = 0;
            reader = new BufferedReader(new InputStreamReader(is, encoding));

            while ((read = reader.read(part)) != -1)
                buffer.append(part, 0, read);

            return buffer.toString();

        } catch (IOException ex) {
            // NeedWork
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    // silently ignored
                }
            }
        }
        return null;
    }

    public static String readString(IStreamContentAccessor sa) throws CoreException {
        InputStream is = sa.getContents();
        if (is != null) {
            String encoding = null;
            if (sa instanceof IEncodedStreamContentAccessor) {
                try {
                    encoding = ((IEncodedStreamContentAccessor) sa).getCharset();
                } catch (Exception e) {
                }
            }
            if (encoding == null)
                encoding = ResourcesPlugin.getEncoding();
            return readString(is, encoding);
        }
        return null;
    }
}
