package com.sap.ide.refactoring.ui;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.AnnotationPainter;
import org.eclipse.jface.text.source.AnnotationRulerColumn;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.IAnnotationAccess;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.OverviewRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.ltk.core.refactoring.RefactoringStatusContext;
import org.eclipse.ltk.ui.refactoring.TextStatusContextViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import textblocks.DocumentNode;
import textblocks.TextBlock;

import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.editor.AbstractGrammarBasedViewerConfiguration.AnnotationHover;
import com.sap.ide.cts.editor.AnnotationMarkerAccess;
import com.sap.ide.refactoring.core.RefactoringSeverity;
import com.sap.mi.textual.parsing.textblocks.TbUtil;

/**
 * An Eclipse refactoring context status viewer extended with source code annotations.
 * Can serve as a base class for other context viewers.
 * 
 * @author Stephan Erb (d049157)
 *
 */
public abstract class AnnotationEnabledStatusContextViewer extends TextStatusContextViewer {
    
    private class ColorCache implements ISharedTextColors {
        @Override
	public Color getColor(RGB rgb) {
            return new Color(Display.getDefault(), rgb);
        }

        @Override
	public void dispose() {
        }
    }
    
    private class CodeViewerConfiguration extends SourceViewerConfiguration {

        private final AnnotationModel annotationModel;

	public CodeViewerConfiguration(AnnotationModel annotationModel) {
	    this.annotationModel = annotationModel;
	}

	@Override
	public IAnnotationHover getAnnotationHover(ISourceViewer sourceViewer) {
            return new AnnotationHover(annotationModel);
        }
    }

    private static final String ERROR_TYPE = severityAsAnnotationString(RefactoringSeverity.ERROR);
    private static final String WARNING_TYPE = severityAsAnnotationString(RefactoringSeverity.WARNING);
    private static final RGB ERROR_RGB = new RGB(255, 0, 0);
    private static final RGB WARNING_RGB = new RGB(255, 255, 0);
    
    protected final TextPresentation textPresentation = new TextPresentation();

    protected SourceViewer sourceViewer;
    protected AnnotationModel annotationModel;
    protected OverviewRuler overviewRuler;

    @Override
    protected SourceViewer createSourceViewer(Composite parent) {
	annotationModel = new AnnotationModel();
	
        // rulers
	IAnnotationAccess annotationAccess = new AnnotationMarkerAccess();
        CompositeRuler compositeRuler = new CompositeRuler();
        ColorCache colorCache = new ColorCache();
        overviewRuler = new OverviewRuler(annotationAccess, 12, colorCache);
        AnnotationRulerColumn annotationRuler = new AnnotationRulerColumn(annotationModel, 16, annotationAccess);
        compositeRuler.setModel(annotationModel);
        overviewRuler.setModel(annotationModel);

        // annotation ruler is decorating our composite ruler
        compositeRuler.addDecorator(0, annotationRuler);
        
        // add what types are show on the different rulers
        annotationRuler.addAnnotationType(ERROR_TYPE);
        annotationRuler.addAnnotationType(WARNING_TYPE);
        overviewRuler.addAnnotationType(ERROR_TYPE);
        overviewRuler.addAnnotationType(WARNING_TYPE);
        overviewRuler.addHeaderAnnotationType(ERROR_TYPE);
        overviewRuler.addHeaderAnnotationType(WARNING_TYPE);
        // set what layer this type is on
        overviewRuler.setAnnotationTypeLayer(ERROR_TYPE, 3);
        overviewRuler.setAnnotationTypeLayer(WARNING_TYPE, 3);
        // set what color is used on the overview ruler for the type
        overviewRuler.setAnnotationTypeColor(ERROR_TYPE, new Color(Display.getDefault(), ERROR_RGB));
        overviewRuler.setAnnotationTypeColor(WARNING_TYPE, new Color(Display.getDefault(), WARNING_RGB));
	
        sourceViewer = new SourceViewer(parent, compositeRuler, overviewRuler, true, SWT.V_SCROLL | SWT.H_SCROLL | SWT.MULTI | SWT.FULL_SELECTION);

        // to paint the annotations
        AnnotationPainter ap = new AnnotationPainter(sourceViewer, annotationAccess);
        ap.addAnnotationType(ERROR_TYPE);
        ap.addAnnotationType(WARNING_TYPE);
        ap.setAnnotationTypeColor(ERROR_TYPE, new Color(Display.getDefault(), ERROR_RGB));
        ap.setAnnotationTypeColor(WARNING_TYPE, new Color(Display.getDefault(), WARNING_RGB));
        
        sourceViewer.addPainter(ap); // this will draw the squigglies under the text
        sourceViewer.configure(new CodeViewerConfiguration(annotationModel));

	return sourceViewer;
    }
    
    protected void addAnnotation(RefactoringSeverity severity, String message, DocumentNode documentNode) {
	Annotation annotation = new Annotation(severityAsAnnotationString(severity), /*persistent*/false, message);
	Position position;
	position = new Position(TbUtil.getAbsoluteOffsetWithoutBlanks((TextBlock) documentNode), documentNode.getLength());

	highlightTextPosition(position);
	annotationModel.addAnnotation(annotation, position);
	overviewRuler.update();
    }
    
    private static String severityAsAnnotationString(RefactoringSeverity severity) {
	switch (severity) {
	case ERROR:
	    return AbstractGrammarBasedEditor.ERROR_TYPE;
	case FATAL:
	    return AbstractGrammarBasedEditor.ERROR_TYPE;
	case WARNING:
	    return AbstractGrammarBasedEditor.WARNING_TYPE;
	default:
	    return severity.toString();
	}
    }

    protected void highlightTextPosition(Position position) {
	// per default, no highlight	
    }

    protected void setAnnotatedDocumentRegion(IDocument document, IRegion region) {
	Control ctrl = getControl();
	if (ctrl != null && ctrl.isDisposed()) {
	    ctrl = null;
	}
	try {
	    if (ctrl != null) {
		ctrl.setRedraw(false);
	    }
	    sourceViewer.setDocument(document, annotationModel);
	    if (region != null && document != null) {
		int offset = region.getOffset();
		int length = region.getLength();
		if (offset >= 0 && length >= 0) {
		    sourceViewer.setSelectedRange(offset, length);
		    sourceViewer.revealRange(offset, length);
		}
	    }
	} finally {
	    if (ctrl != null) {
		ctrl.setRedraw(true);
	    }
	}
    }
    
    @Override
    public void setInput(RefactoringStatusContext input) {
	annotationModel.removeAllAnnotations();
	textPresentation.clear();
	setInputAndAnnotations(input);
    }

    protected abstract void setInputAndAnnotations(RefactoringStatusContext input);

}
