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

package org.eclipse.imp.editor.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.imp.editor.UniversalEditor;
import org.eclipse.imp.parser.IMessageHandlerExtension;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * An implementation of the IMessageHandler interface that creates editor annotations
 * directly from messages. Used for live parsing within a source editor (cf. building,
 * which uses the class MarkerCreator to create markers).
 * @author rmfuhrer
 */
public class AnnotationCreator implements IMessageHandlerExtension {
    private static class PositionedMessage {
        public final String message;
        public final Position pos;
        public PositionedMessage(String msg, Position pos) {
            this.message= msg;
            this.pos= pos;
        }
    }
    private final ITextEditor fEditor;
    private final String fAnnotationType;
    private final List<PositionedMessage> fMessages= new LinkedList<PositionedMessage>();
    private final List<Annotation> fAnnotations= new LinkedList<Annotation>();

    public AnnotationCreator(ITextEditor textEditor, String annotationType) {
        fEditor= textEditor;
        if (annotationType == null)
        	fAnnotationType = UniversalEditor.PARSE_ANNOTATION_TYPE;
        else 
        	fAnnotationType= annotationType;
    }

    public void clearMessages() {
        removeAnnotations();
        fMessages.clear();
    }

    public void startMessageGroup(String groupName) { }
    public void endMessageGroup() { }

    public void handleSimpleMessage(String message, int startOffset, int endOffset,
            int startCol, int endCol,
            int startLine, int endLine) {
        Position pos= new Position(startOffset, endOffset - startOffset + 1);
        fMessages.add(new PositionedMessage(message, pos));
    }

    public void endMessages() {
        IAnnotationModel model= fEditor.getDocumentProvider().getAnnotationModel(fEditor.getEditorInput());
        if (model instanceof IAnnotationModelExtension) {
            IAnnotationModelExtension modelExt= (IAnnotationModelExtension) model;
            Annotation[] oldAnnotations= fAnnotations.toArray(new Annotation[fAnnotations.size()]);
            Map<Annotation, Position> newAnnotations= new HashMap<Annotation, Position>(fMessages.size());
            for(PositionedMessage pm: fMessages) {
                Annotation anno= new Annotation(fAnnotationType, false, pm.message);
                newAnnotations.put(anno, pm.pos);
                fAnnotations.add(anno);
            }
            modelExt.replaceAnnotations(oldAnnotations, newAnnotations);
        } else if (model != null) { // model could be null if, e.g., we're directly browsing a file version in a src repo
            for(Iterator i= model.getAnnotationIterator(); i.hasNext(); ) {
                Annotation a= (Annotation) i.next();

                if (a.getType().equals(fAnnotationType)) {
                    model.removeAnnotation(a);
                }
            }
            for(PositionedMessage pm: fMessages) {
                Annotation annotation= new Annotation(fAnnotationType, false, pm.message);

                model.addAnnotation(annotation, pm.pos);
                fAnnotations.add(annotation);
            }
        }
//      System.out.println("Annotation model updated.");
        fMessages.clear();
    }

    private void removeAnnotations() {
        final IDocumentProvider docProvider= fEditor.getDocumentProvider();

        if (docProvider == null) {
            return;
        }

        IAnnotationModel model= docProvider.getAnnotationModel(fEditor.getEditorInput());

        if (model == null)
            return;

        if (model instanceof IAnnotationModelExtension) {
            IAnnotationModelExtension modelExt= (IAnnotationModelExtension) model;
            Annotation[] oldAnnotations= fAnnotations.toArray(new Annotation[fAnnotations.size()]);

            modelExt.replaceAnnotations(oldAnnotations, Collections.EMPTY_MAP);
        } else {
            for(Iterator i= model.getAnnotationIterator(); i.hasNext(); ) {
                Annotation a= (Annotation) i.next();

                if (a.getType().equals(fAnnotationType)) {
                    model.removeAnnotation(a);
                }
            }
        }
//      System.out.println("Annotations removed.");
        fAnnotations.clear();
    }
}
