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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.imp.language.ILanguageService;
import org.eclipse.imp.utils.HTMLPrinter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.ISourceViewerExtension2;
import org.eclipse.jface.text.source.projection.AnnotationBag;
import org.eclipse.jface.text.source.projection.ProjectionAnnotation;

public class AnnotationHoverBase implements IAnnotationHover, ILanguageService {

    public AnnotationHoverBase() { }

    protected static boolean isRulerLine(Position position, IDocument document, int line) {
        if (position.getOffset() > -1 && position.getLength() > -1) {
            try {
                // RMF 11/10/2006 - This used to add 1 to the line computed by the document,
                // which appears to be bogus. First, it didn't work right (annotation hovers
                // never appeared); second, the line passed in comes from the Eclipse
                // framework, so it should be consistent (wrt the index base) with what the
                // IDocument API provides.
                return line == document.getLineOfOffset(position.getOffset())/* + 1 */;
            } catch (BadLocationException x) {
            }
        }
        return false;
    }

    protected static IAnnotationModel getAnnotationModel(ISourceViewer viewer) {
        if (viewer instanceof ISourceViewerExtension2) {
            ISourceViewerExtension2 extension= (ISourceViewerExtension2) viewer;
            return extension.getVisualAnnotationModel();
        }
        return viewer.getAnnotationModel();
    }

    public static List<Annotation> getSourceAnnotationsForLine(ISourceViewer viewer, int line) {
        IAnnotationModel model= getAnnotationModel(viewer);
        if (model == null)
            return null;

        IDocument document= viewer.getDocument();
        List<Annotation> srcAnnotations= new ArrayList<Annotation>();
        Iterator<?> iterator= model.getAnnotationIterator();
    
        while (iterator.hasNext()) {
            Annotation annotation= (Annotation) iterator.next();
            Position position= model.getPosition(annotation);
    
            if (position == null)
                continue;
    
            if (!isRulerLine(position, document, line))
                continue;

            if (annotation instanceof AnnotationBag) {
                AnnotationBag bag= (AnnotationBag) annotation;
                for(Iterator<?> iter= bag.iterator(); iter.hasNext(); ) {
                    Annotation bagAnnotation= (Annotation) iter.next();

                    position= model.getPosition(bagAnnotation);
                    if (position != null && includeAnnotation(bagAnnotation, position))
                        srcAnnotations.add(bagAnnotation);
                }
            } else {
                if (includeAnnotation(annotation, position))
                    srcAnnotations.add(annotation);
            }
        }
    
        return srcAnnotations;
    }

    // Following is just used for debugging to discover new annotation types to filter out
//    private static Set<String> fAnnotationTypes= new HashSet<String>();

    private static Set<String> sAnnotationTypesToFilter= new HashSet<String>();

    static {
        sAnnotationTypesToFilter.add("org.eclipse.ui.workbench.texteditor.quickdiffUnchanged");
        sAnnotationTypesToFilter.add("org.eclipse.ui.workbench.texteditor.quickdiffChange");
        sAnnotationTypesToFilter.add("org.eclipse.ui.workbench.texteditor.quickdiffAddition");
        sAnnotationTypesToFilter.add("org.eclipse.ui.workbench.texteditor.quickdiffDeletion");
        sAnnotationTypesToFilter.add("org.eclipse.debug.core.breakpoint");
        sAnnotationTypesToFilter.add(MarkOccurrencesAction.OCCURRENCE_ANNOTATION);
        sAnnotationTypesToFilter.add(ProjectionAnnotation.TYPE);
    }

    /**
     * Check preferences, etc., to determine whether this annotation is actually showing.
     * (Don't want to show a hover for a non-visible annotation.)
     * @param annotation
     * @param position
     * @return
     */
    private static boolean includeAnnotation(Annotation annotation, Position position) {
        String type= annotation.getType();
//        if (!fAnnotationTypes.contains(type)) {
//            fAnnotationTypes.add(type);
//            System.out.println("Annotation type: " + type);
//        }
        return !sAnnotationTypesToFilter.contains(type);
    }

    public static String formatAnnotationList(List<Annotation> javaAnnotations) {
        if (javaAnnotations != null) {
            if (javaAnnotations.size() == 1) {
                // optimization
                Annotation annotation= (Annotation) javaAnnotations.get(0);
                String message= annotation.getText();

                if (message != null && message.trim().length() > 0)
                    return HTMLPrinter.formatSingleMessage(message);
            } else {
                List<String> messages= new ArrayList<String>(javaAnnotations.size());

                for(Annotation annotation: javaAnnotations) {
                    String message= annotation.getText();
                    if (message != null && message.trim().length() > 0)
                        messages.add(message.trim());
                }

                if (messages.size() == 1)
                    return HTMLPrinter.formatSingleMessage((String) messages.get(0));

                if (messages.size() > 1)
                    return HTMLPrinter.formatMultipleMessages(messages);
            }
        }
        return null;
    }

    /**
     * @see IVerticalRulerHover#getHoverInfo(ISourceViewer, int)
     */
    public String getHoverInfo(ISourceViewer sourceViewer, int lineNumber) {
        List<Annotation> javaAnnotations= getSourceAnnotationsForLine(sourceViewer, lineNumber);

        return formatAnnotationList(javaAnnotations);
    }
}
