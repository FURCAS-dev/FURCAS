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

import java.util.List;

import org.eclipse.imp.editor.UniversalEditor.StructuredSourceViewerConfiguration;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.runtime.RuntimePlugin;
import org.eclipse.imp.services.IAutoEditStrategy;
import org.eclipse.imp.services.ILanguageSyntaxProperties;
import org.eclipse.imp.services.base.DefaultAutoIndentStrategy;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.DocumentRewriteSession;
import org.eclipse.jface.text.DocumentRewriteSessionType;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension4;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.information.IInformationPresenter;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

public class StructuredSourceViewer extends ProjectionViewer {
    /**
     * Text operation code for requesting the outline for the current input.
     */
    public static final int SHOW_OUTLINE= 51;

    /**
     * Text operation code for requesting the outline for the element at the current position.
     */
    public static final int OPEN_STRUCTURE= 52;

    /**
     * Text operation code for requesting the hierarchy for the current input.
     */
    public static final int SHOW_HIERARCHY= 53;

    /**
     * Text operation code for toggling the commenting of a selected range of text, or the current line.
     */
    public static final int TOGGLE_COMMENT= 54;

    /**
     * Text operation code for toggling the display of "occurrences" of the
     * current selection, whatever that means to the current language.
     */
    public static final int MARK_OCCURRENCES= 55;

    /**
     * Text operation code for indenting the currently selected text.
     */
    public static final int INDENT_SELECTION= 60;

    private IInformationPresenter fOutlinePresenter;

    private IInformationPresenter fStructurePresenter;

    private IInformationPresenter fHierarchyPresenter;

    private IAutoEditStrategy fAutoEditStrategy;

    private IParseController fParseController;
    
    public StructuredSourceViewer(Composite parent, IVerticalRuler verticalRuler, IOverviewRuler overviewRuler, boolean showAnnotationsOverview, int styles) {
        super(parent, verticalRuler, overviewRuler, showAnnotationsOverview, styles);
    }

    /*
     * @see ITextOperationTarget#canDoOperation(int)
     */
    public boolean canDoOperation(int operation) {
        switch(operation) {
        case SHOW_OUTLINE:
            return fOutlinePresenter != null;
        case OPEN_STRUCTURE:
            return fStructurePresenter != null;
        case SHOW_HIERARCHY:
            return fHierarchyPresenter != null;
        case TOGGLE_COMMENT:
            return true;
        case INDENT_SELECTION:
            return fAutoEditStrategy != null;
        }
        return super.canDoOperation(operation);
    }

    /*
     * @see ITextOperationTarget#doOperation(int)
     */
    public void doOperation(int operation) {
        if (getTextWidget() == null)
            return;
        switch (operation) {
        case SHOW_OUTLINE:
            if (fOutlinePresenter != null)
                fOutlinePresenter.showInformation();
            return;
        case OPEN_STRUCTURE:
            if (fStructurePresenter != null)
                fStructurePresenter.showInformation();
            return;
        case SHOW_HIERARCHY:
            if (fHierarchyPresenter != null)
                fHierarchyPresenter.showInformation();
            return;
        case TOGGLE_COMMENT:
            doToggleComment();
            return;
            // mmk 4/8/08
        case INDENT_SELECTION:
            doIndentLines();
            return;
        }
        super.doOperation(operation);
    }

    public void setParseController(IParseController parseController) {
    	fParseController = parseController;
    }

    public void setFormatter(IContentFormatter formatter) {
        fContentFormatter= formatter;
    }

    private void doToggleComment() {
        ILanguageSyntaxProperties syntaxProps= fParseController.getSyntaxProperties();

        if (syntaxProps == null)
            return;

        IDocument doc= this.getDocument();
        DocumentRewriteSession rewriteSession= null;
        Point p= this.getSelectedRange();
        final String lineCommentPrefix= syntaxProps.getSingleLineCommentPrefix();

    	if (doc instanceof IDocumentExtension4) {
    	    IDocumentExtension4 extension= (IDocumentExtension4) doc;
    	    rewriteSession= extension.startRewriteSession(DocumentRewriteSessionType.SEQUENTIAL);
    	}

    	try {
            final int selStart= p.x;
            final int selLen= p.y;
            final int selEnd= selStart + selLen;
            final int startLine= doc.getLineOfOffset(selStart);
            int endLine= doc.getLineOfOffset(selEnd);

            if (selLen > 0 && lookingAtLineEnd(doc, selEnd))
                endLine--;

            boolean linesAllHaveCommentPrefix= linesHaveCommentPrefix(doc, lineCommentPrefix, startLine, endLine);
        	boolean useCommonLeadingSpace= true; // take from a preference?
			int leadingSpaceToUse= useCommonLeadingSpace ? calculateLeadingSpace(doc, startLine, endLine) : 0;

            for(int line= startLine; line <= endLine; line++) {
                int lineStart= doc.getLineOffset(line);
                int lineEnd= lineStart + doc.getLineLength(line) - 1;

                if (linesAllHaveCommentPrefix) {
                	// remove the comment prefix from each line, wherever it occurs in the line
                	int offset= lineStart;
                    while (Character.isWhitespace(doc.getChar(offset)) && offset < lineEnd) {
                        offset++;
                    }
                    // The first non-whitespace characters *must* be the single-line comment prefix
                    doc.replace(offset, lineCommentPrefix.length(), "");
                } else {
                	// add the comment prefix to each line, after however many spaces leadingSpaceToAdd indicates
                	int offset= lineStart + leadingSpaceToUse;
                	doc.replace(offset, 0, lineCommentPrefix + " ");
                }
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        } finally {
            if (doc instanceof IDocumentExtension4) {
                IDocumentExtension4 extension= (IDocumentExtension4) doc;
                extension.stopRewriteSession(rewriteSession);
            }
            restoreSelection();
        }
    }

    private int calculateLeadingSpace(IDocument doc, int startLine, int endLine) {
    	try {
        	int result= Integer.MAX_VALUE;
        	for(int line= startLine; line <= endLine; line++) {
        		int lineStart= doc.getLineOffset(line);
        		int lineEnd= lineStart + doc.getLineLength(line) - 1;
        		int offset= lineStart;
        		while (Character.isWhitespace(doc.getChar(offset)) && offset < lineEnd) {
        			offset++;
        		}
        		int leadingSpaces= offset - lineStart;
				result= Math.min(result, leadingSpaces);
        	}
    		return result;
    	} catch (BadLocationException e) {
    		return 0;
    	}
	}

	/**
     * @return true, if the given inclusive range of lines all start with the single-line comment prefix,
     * even if they have different amounts of leading whitespace
     */
    private boolean linesHaveCommentPrefix(IDocument doc, String lineCommentPrefix, int startLine, int endLine) {
    	try {
    		int docLen= doc.getLength();

    		for(int line= startLine; line <= endLine; line++) {
                int lineStart= doc.getLineOffset(line);
                int lineEnd= lineStart + doc.getLineLength(line) - 1;
                int offset= lineStart;

                while (Character.isWhitespace(doc.getChar(offset)) && offset < lineEnd) {
                    offset++;
                }
                if (docLen - offset > lineCommentPrefix.length() && doc.get(offset, lineCommentPrefix.length()).equals(lineCommentPrefix)) {
                	// this line starts with the single-line comment prefix
                } else {
                	return false;
                }
            }
    	} catch (BadLocationException e) {
    		return false;
    	}
		return true;
	}

	private void doIndentLines() {
        IDocument doc= this.getDocument();
        DocumentRewriteSession rewriteSession= null;
        Point p= this.getSelectedRange();

        if (doc instanceof IDocumentExtension4) {
            IDocumentExtension4 extension= (IDocumentExtension4) doc;
            rewriteSession= extension.startRewriteSession(DocumentRewriteSessionType.SEQUENTIAL);
        }

        try {
            final int selStart= p.x;
            final int selLen= p.y;
            final int selEnd= selStart + selLen;
            final int startLine= doc.getLineOfOffset(selStart);
            int endLine= doc.getLineOfOffset(selEnd);

            if (selLen > 0 && lookingAtLineEnd(doc, selEnd))
                endLine--;
            for(int line= startLine; line <= endLine; line++) {
                int lineStartOffset= doc.getLineOffset(line);

                // Replace the existing indentation with the desired indentation.
                // Use the language-specific AutoEditStrategy, which requires a DocumentCommand.
                DocumentCommand cmd= new DocumentCommand() { };
                cmd.offset= lineStartOffset;
                cmd.length= 0;
                cmd.text= Character.toString('\t');
                cmd.doit= true;
                cmd.shiftsCaret= false;
                fAutoEditStrategy.customizeDocumentCommand(doc, cmd);
                doc.replace(cmd.offset, cmd.length, cmd.text);
            }
        } catch (BadLocationException e) {
            RuntimePlugin.getInstance().logException("Indent Selection command failed", e);
        } finally {
            if (doc instanceof IDocumentExtension4) {
                IDocumentExtension4 extension= (IDocumentExtension4) doc;
                extension.stopRewriteSession(rewriteSession);
            }
            restoreSelection();
        }
    }

    private boolean lookingAtLineEnd(IDocument doc, int pos) {
        String[] legalLineTerms= doc.getLegalLineDelimiters();
        try {
            for(String lineTerm: legalLineTerms) {
                int len= lineTerm.length();
                if (pos > len && doc.get(pos - len, len).equals(lineTerm)) {
                    return true;
                }
            }
        } catch (BadLocationException e) {
            RuntimePlugin.getInstance().logException("Error examining document for line termination", e);
        }
        return false;
    }

    /*
     * @see ISourceViewer#configure(SourceViewerConfiguration)
     */
    public void configure(SourceViewerConfiguration configuration) {
        /*
         * Prevent access to colors disposed in unconfigure(), see: https://bugs.eclipse.org/bugs/show_bug.cgi?id=53641
         * https://bugs.eclipse.org/bugs/show_bug.cgi?id=86177
         */
        StyledText textWidget= getTextWidget();
        if (textWidget != null && !textWidget.isDisposed()) {
            Color foregroundColor= textWidget.getForeground();
            if (foregroundColor != null && foregroundColor.isDisposed())
                textWidget.setForeground(null);
            Color backgroundColor= textWidget.getBackground();
            if (backgroundColor != null && backgroundColor.isDisposed())
                textWidget.setBackground(null);
        }
        super.configure(configuration);
        if (configuration instanceof StructuredSourceViewerConfiguration) {
            StructuredSourceViewerConfiguration sSVConfiguration= (StructuredSourceViewerConfiguration) configuration;

            fOutlinePresenter= sSVConfiguration.getOutlinePresenter(this);
            if (fOutlinePresenter != null)
                fOutlinePresenter.install(this);

            fStructurePresenter= sSVConfiguration.getOutlinePresenter(this);
            if (fStructurePresenter != null)
                fStructurePresenter.install(this);

            fHierarchyPresenter= sSVConfiguration.getHierarchyPresenter(this, true);
            if (fHierarchyPresenter != null)
                fHierarchyPresenter.install(this);

            if (fAutoIndentStrategies != null) {
                List<org.eclipse.jface.text.IAutoEditStrategy> strategies= (List<org.eclipse.jface.text.IAutoEditStrategy>) fAutoIndentStrategies.get(IDocument.DEFAULT_CONTENT_TYPE);
                // TODO If there are multiple IAudoEditStrategy's, we may pick up one that doesn't do indent. How to identify the right one?
                // SMS 5 Aug 2008:  There's another problem here, in that the available strategy here
                // may not be of type IAutoEditStrategy.  See bug #243212.  To provide at least a
                // short term fix, I'm going to substitute an appropriate value when that turns out 
                // to be the case.  This may be revised if we decide to somehow avoid the possibility
                // that a strategy of an inappropriate type might appear here.
                if (strategies != null && strategies.size() > 0) {
//                    fAutoEditStrategy= (IAutoEditStrategy) strategies.get(0);
                	if (strategies.get(0) instanceof IAutoEditStrategy)
                		fAutoEditStrategy= (IAutoEditStrategy) strategies.get(0);
                	else
                		fAutoEditStrategy = new DefaultAutoIndentStrategy();
                }
            }
        }
        //	if (fPreferenceStore != null) {
        //	    fPreferenceStore.addPropertyChangeListener(this);
        //	    initializeViewerColors();
        //	}
    }

    /*
     * @see org.eclipse.jface.text.source.ISourceViewerExtension2#unconfigure()
     * @since 3.0
     */
    public void unconfigure() {
        if (fOutlinePresenter != null) {
            fOutlinePresenter.uninstall();
            fOutlinePresenter= null;
        }
        if (fStructurePresenter != null) {
            fStructurePresenter.uninstall();
            fStructurePresenter= null;
        }
        if (fHierarchyPresenter != null) {
            fHierarchyPresenter.uninstall();
            fHierarchyPresenter= null;
        }
        // if (fForegroundColor != null) {
        // fForegroundColor.dispose();
        // fForegroundColor= null;
        // }
        // if (fBackgroundColor != null) {
        // fBackgroundColor.dispose();
        // fBackgroundColor= null;
        //	}
        //	if (fPreferenceStore != null)
        //	    fPreferenceStore.removePropertyChangeListener(this);
        super.unconfigure();
    }
}
