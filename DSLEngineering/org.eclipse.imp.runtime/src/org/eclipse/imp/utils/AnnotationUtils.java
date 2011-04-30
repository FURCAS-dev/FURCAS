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

package org.eclipse.imp.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.projection.AnnotationBag;

public class AnnotationUtils {
    private AnnotationUtils() {
    }

    public static String formatAnnotationList(List<Annotation> annotations) {
        if (annotations != null) {
            if (annotations.size() == 1) {
                // optimization
                Annotation annotation= (Annotation) annotations.get(0);
                String message= annotation.getText();
                if (message != null && message.trim().length() > 0)
                    return HTMLPrinter.formatSingleMessage(message);
            } else {
                List<String> messages= new ArrayList<String>();
                for(Annotation annotation : annotations) {
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

    public static IAnnotationModel getAnnotationModel(ISourceViewer viewer) {
        // if (viewer instanceof ISourceViewerExtension2) {
        // ISourceViewerExtension2 extension= (ISourceViewerExtension2) viewer;
        //
        // return extension.getVisualAnnotationModel();
        // }
        return viewer.getAnnotationModel();
    }

    /**
     * Check preferences, etc., to determine whether this annotation is actually showing. (Don't want to show a hover
     * for a non-visible annotation.)
     * 
     * @param annotation
     * @param position
     * @param messagesAtPosition
     * @return
     */
    public static boolean includeAnnotation(Annotation annotation, Position position) {
        return true;
    }

    public static List<Annotation> getAnnotations(ISourceViewer viewer, IPositionPredicate posPred) {
        IAnnotationModel model= getAnnotationModel(viewer);
        if (model == null)
            return null;
        List<Annotation> annotations= new ArrayList<Annotation>();
        Iterator<Annotation> iterator= model.getAnnotationIterator();
        while (iterator.hasNext()) {
            Annotation annotation= (Annotation) iterator.next();
            Position position= model.getPosition(annotation);
            // System.out.println("Checking annotation @ " + position.offset + ":" + position.length + " => " +
            // annotation.getText());
            if (annotation.getType().equals("org.eclipse.ui.workbench.texteditor.quickdiffUnchanged"))
                continue;
            if (position == null)
                continue;
            if (!posPred.matchPosition(position))
                continue;
            if (annotation instanceof AnnotationBag) {
                AnnotationBag bag= (AnnotationBag) annotation;
                for(Iterator<Annotation> e= bag.iterator(); e.hasNext(); ) {
                    Annotation bagAnnotation= (Annotation) e.next();
                    position= model.getPosition(bagAnnotation);
                    if (position != null && includeAnnotation(bagAnnotation, position))
                        annotations.add(bagAnnotation);
                }
            } else {
                if (includeAnnotation(annotation, position))
                    annotations.add(annotation);
            }
        }
        return annotations;
    }

    public static List<Annotation> getAnnotationsForLine(ISourceViewer viewer, final int line) {
        final IDocument document= viewer.getDocument();
        IPositionPredicate posPred= new IPositionPredicate() {
            public boolean matchPosition(Position p) {
                return AnnotationUtils.offsetIsAtLine(p, document, line);
            }
        };
        return getAnnotations(viewer, posPred);
    }

    public static List<Annotation> getAnnotationsForOffset(ISourceViewer viewer, final int offset) {
        IPositionPredicate posPred= new IPositionPredicate() {
            public boolean matchPosition(Position p) {
                return offset >= p.offset && offset < p.offset + p.length;
            }
        };
        return getAnnotations(viewer, posPred);
    }

    public static boolean offsetIsAtLine(Position position, IDocument document, int line) {
        if (position.getOffset() > -1 && position.getLength() > -1) {
            try {
                int posLine= document.getLineOfOffset(position.getOffset());
                // System.out.println(" at line " + posLine);
                return line == posLine;
            } catch (BadLocationException x) {
            }
        }
        return false;
    }
}
