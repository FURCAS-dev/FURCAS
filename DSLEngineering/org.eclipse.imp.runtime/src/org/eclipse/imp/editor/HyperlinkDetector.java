/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation

*******************************************************************************/

package org.eclipse.imp.editor;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.imp.language.ILanguageService;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.language.ServiceFactory;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.imp.services.IEntityNameLocator;
import org.eclipse.imp.services.IReferenceResolver;
import org.eclipse.imp.services.ISourceHyperlinkDetector;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * Provides a method to detect hyperlinks originating from a
 * given region in the parse stream of a given parse controller.
 */
public class HyperlinkDetector implements ISourceHyperlinkDetector, ILanguageService {
    private IReferenceResolver fResolver;
    private IEntityNameLocator fEntityNameLocator;
    private final Language fLanguage;

    public HyperlinkDetector(Language lang) {
        fLanguage= lang;
        fEntityNameLocator= ServiceFactory.getInstance().getEntityNameLocator(fLanguage);
    }

    public IHyperlink[] detectHyperlinks(final IRegion region, ITextEditor editor, final ITextViewer textViewer, IParseController parseController) {
    	// This is the only language-specific bit ...
        if (fResolver == null) {
            fResolver = ServiceFactory.getInstance().getReferenceResolver(fLanguage);
        }

    	// SMS 17 Aug 2007
    	if (fResolver == null)
    	    return null;

    	if (parseController == null)
    		return null;
	
    	// Get stuff for getting link source node
        Object ast= parseController.getCurrentAst();
        if (ast == null) return null;
        int offset= region.getOffset();
        ISourcePositionLocator nodeLocator = parseController.getSourcePositionLocator();

        // Get link source node
        Object source = nodeLocator.findNode(ast, offset);
        if (source == null) return null;

        // Got a suitable link source node; get link target node
       	Object target = fResolver.getLinkTarget(source, parseController);
       	if (target == null) return null;

       	if (fEntityNameLocator != null) {
       	    Object name= fEntityNameLocator.getName(target);
       	    if (name != null) {
       	        target= name;
       	    }
       	}

       	// Link target node exists; get info for new hyperlink
       	// Note:  source presumably has a legitimate starting offset
       	// and length (since they have been selected from the source file)
        final int srcStart= nodeLocator.getStartOffset(source);
        final int srcLength= nodeLocator.getEndOffset(source) - srcStart + 1;

        // The target (depending on what--and where--the target is) may not have a
        // legitimate location (or one within the file). In that case, set the target
        // to the beginning of the file and give it a nominal length.

        final int targetStart= (nodeLocator.getStartOffset(target) < 0) ? 0 : nodeLocator.getStartOffset(target);
        final int targetLength= 0; // nodeLocator.getEndOffset(target) - targetStart + 1;

        // Use the file path info to determine whether the target editor is the same as
        // the source editor, and initialize the TargetLink accordingly.
        final IPath targetPath= nodeLocator.getPath(target);
        // SMS 10 Sep 2007
        if (targetPath == null) {
        	//System.out.println("HyperlinkDetector.detectHyperlinks(..):  targetPath == null, returning null");
        	return null;
        }
        final String linkText = fResolver.getLinkText(source);

        IPath srcPath= ((IFileEditorInput) editor.getEditorInput()).getFile().getLocation();
        // SMS 11 Jun 2007:  default implementation of getPath in NodeLocator template returns
        // an empty path, so test for that here and assume it means that the link target is in 
        // the same unit as the link source
        IPath wsPath= ResourcesPlugin.getWorkspace().getRoot().getLocation();
        boolean isSamePath= targetPath.equals(srcPath) || srcPath.removeFirstSegments(wsPath.segmentCount()).setDevice(null).makeAbsolute().equals(targetPath);
        
        // SMS 5 Aug 2008
        // The above test for isSamePath doesn't necessarily work because the default node
        // locator always returns an empty path for any given node.  Special customization
        // is needed which, among our known IDEs, has only been done for X10DT (PolyglotNodeLocator)
        // and LPG.  So in cases where it might make sense, we can try relying on the node locator
        // to return a negative offset for a node that is not in a given AST.  I.e., if the target
        // node is not in the same AST as the source node then assume their paths are different.
        // OK, this might not be strictly true if you can get more than one AST from a single
        // file, but it will prevent problems in the common case of one AST per source file.
        if (!isSamePath && targetPath.segmentCount() == 0) {
        	isSamePath = nodeLocator.getStartOffset(target) >= 0;
        }
        
        ITextEditor targetEditor= (targetPath.segmentCount() == 0 || isSamePath) ? editor : null;
        Object targetArg= targetEditor == null ? targetPath : target;

        // If the target is exactly the same entity, don't bother with the hyperlink.
        if (srcStart == targetStart && srcLength == targetLength && targetPath.equals(srcPath))
            return null;

        IRegionSelectionService selService= isSamePath ? (IRegionSelectionService) editor.getAdapter(IRegionSelectionService.class) : null;

        IHyperlink[] result = new IHyperlink[] {
            new TargetLink(linkText, srcStart, srcLength, targetArg, targetStart, targetLength, selService)
        };

        return result;
    }
}
