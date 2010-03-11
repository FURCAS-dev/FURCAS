/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: CommonHoverHelper.java,v 1.1 2010/03/11 14:51:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.imp;

import java.util.List;

import org.eclipse.imp.editor.AnnotationHoverBase;
import org.eclipse.imp.language.ServiceFactory;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.imp.services.IDocumentationProvider;
import org.eclipse.imp.services.IHoverHelper;
import org.eclipse.imp.services.IReferenceResolver;
import org.eclipse.imp.services.base.HoverHelperBase;
import org.eclipse.imp.utils.HTMLPrinter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.examples.common.utils.TracingOption;
import org.eclipse.ocl.examples.editor.ui.OCLExamplesEditorPlugin;

public abstract class CommonHoverHelper extends HoverHelperBase implements IHoverHelper
{
	public static TracingOption hoverDebug = new TracingOption(OCLExamplesEditorPlugin.PLUGIN_ID, "hover/debug");

	IReferenceResolver fResolver = null;

	public String getHoverHelpAt(IParseController parseController, ISourceViewer srcViewer, int offset) {
		CommonParseController commonParseController = (CommonParseController) parseController;
		// If there are any annotations associated with the line that contains
		// the given offset, return those
		try {
//			@SuppressWarnings("unchecked")
			List<Annotation> annotations = AnnotationHoverBase.getSourceAnnotationsForLine(
					srcViewer, srcViewer.getDocument().getLineOfOffset(offset));
			if (annotations != null && annotations.size() > 0) {
				// Some annotations have no text, such as breakpoint annotations;
				// if that's all we have, then don't bother returning it
				String msg = AnnotationHoverBase.formatAnnotationList(annotations);
				if (msg != null) {
					return msg;
				}
			}
		} catch (BadLocationException e) {
			return "??? (BadLocationException for annotation)";
		}

		// Otherwise, return a message determined directly or indirectly based
		// on the node whose representation occurs at the given offset

		// Get the current AST; no AST implies no message
		ICommonParseResult parseResult = commonParseController.getCurrentResult();
		if (parseResult == null)
			return null;
		CSTNode cst = parseResult.getCST();
		if (cst == null)
			return null;

		// Declare variables used in formulating the message
		Object sourceNode = null; // node at current hover point
		Object targetNode = null; // node referenced from current hover point
		Object helpNode = null; // node for which a help message is to be constructed
		String msg = null; // the help message for helpNode

		// Get the node at the given offset; no node implies no message
		ISourcePositionLocator nodeLocator = parseResult.getSourcePositionLocator();
		sourceNode = nodeLocator.findNode(cst, offset);
		if (sourceNode == null)
			return null;

		// Check whether there is a reference resolver for the identified
		// source node; if so, attempt to get the node that is referenced by
		// the source node, on the assumption that the referenced node should
		// be the basis for the help message (e.g., as a decl for an identifier)
		if (true) {
			if (fResolver == null && fLanguage != null) {
				try {
					fResolver = ServiceFactory.getInstance().getReferenceResolver(fLanguage);
				} catch (Exception e) {
					getPlugin().writeErrorMsg("Exception getting Reference Resolver service from service factory");
					fResolver = null;
				}
			}
			if (fResolver != null) {
				targetNode = fResolver.getLinkTarget(sourceNode, commonParseController);  // FIXME need to pass offset if PathNameCS is to be fragmented
			}
		}
		
		if (hoverDebug.isActive())
			hoverDebug.println("Hover at " + offset + " on"
					+ " source: " + sourceNode.getClass().getSimpleName()
					+ " target: " + (targetNode != null ? targetNode.getClass().getSimpleName() : "null"));

		// If the target node is not null, provide help based on that;
		// otherwise, provide help based on the source node
		if (targetNode != null)
			helpNode = targetNode;
		else
			helpNode = sourceNode;

		// Now need to determine whether the help message should be determined
		// based on the text represented by the node or based on some separate
		// text provided through an IDocumentationProvider

		// Check whether there is a documentation provider for the language;
		// if so, check whether it provides documentation for the help node;
		// if so, return that documentation
		IDocumentationProvider docProvider = null;
		if (fLanguage != null && true) {
			try {
				docProvider = ServiceFactory.getInstance().getDocumentationProvider(fLanguage);

			} catch (Exception e) {
				getPlugin().writeErrorMsg("Exception getting Documentation Provider Service from service factory");
				fResolver = null;
			}
		}
		if (docProvider != null) {
			msg = docProvider.getDocumentation(helpNode, commonParseController);
			if (msg != null)
				return HTMLPrinter.convertToHTMLContent(msg);
		}

		// Otherwise, base the help message on the text that is represented
		// by the help node
		if (helpNode instanceof CSTNode) {
			CSTNode def = (CSTNode) helpNode;
			msg = parseResult.getTextRange(def.getStartOffset(), def.getEndOffset() - def.getStartOffset() + 1);
			int maxMsgLen = 80;
			if (msg == null || msg.length() == 0)
				return "No help available";
			else if (msg.length() <= maxMsgLen)
				return msg;
			else
				return msg.subSequence(0, maxMsgLen) + "...";
		} else {
			return "No help available";
		}
	}

	protected abstract ICommonPlugin getPlugin();
}
