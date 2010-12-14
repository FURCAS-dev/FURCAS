package com.sap.furcas.ide.editor;

import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationAccess;
import org.eclipse.jface.text.source.IAnnotationAccessExtension;
import org.eclipse.jface.text.source.ImageUtilities;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;


public class AnnotationMarkerAccess implements IAnnotationAccess,
		IAnnotationAccessExtension {

	public String getType(Annotation annotation) {
		return annotation.getType();
	}

	public boolean isMultiLine(Annotation annotation) {
		return true;
	}

	public boolean isTemporary(Annotation annotation) {
		return !annotation.isPersistent();
	}

	public String getTypeLabel(Annotation annotation) {
		if (getType(annotation).equals(
				AbstractGrammarBasedEditor.ERROR_TYPE))
			return "Errors";
		if (getType(annotation).equals(
				AbstractGrammarBasedEditor.WARNING_TYPE))
			return "Warnings";
		return null;
	}

	public int getLayer(Annotation annotation) {
		return 0;
	}

	public void paint(Annotation annotation, GC gc, Canvas canvas,
			Rectangle bounds) {
		if (getType(annotation).equals(
				AbstractGrammarBasedEditor.ERROR_TYPE))
			ImageUtilities.drawImage(DialogsImages.imageRegistry
					.get(DialogsImages.ERROR), gc, canvas, bounds, SWT.CENTER);
		else if (getType(annotation).equals(
				AbstractGrammarBasedEditor.WARNING_TYPE))
			ImageUtilities
					.drawImage(DialogsImages.imageRegistry
							.get(DialogsImages.WARNING), gc, canvas, bounds,
							SWT.CENTER);
	}

	public boolean isPaintable(Annotation annotation) {
		return true;
	}

	public boolean isSubtype(Object annotationType, Object potentialSupertype) {
		if (annotationType.equals(potentialSupertype))
			return true;

		return false;
	}

	public Object[] getSupertypes(Object annotationType) {
		return new Object[0];
	}
}
