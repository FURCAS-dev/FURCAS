package com.sap.furcas.ide.editor.action;

import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.sap.furcas.ide.editor.document.CtsDocument;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.textblocks.TbUtil;

public class HighlightTextBlockAction implements Listener {

public static final String TB_HIGHLIGHT_ANNOTATION = "TEXTBLOCK_HIGHLIGHT_ANNOTATION";
private final SourceViewer textViewer;
private final Annotation annotation;
	
	

	public HighlightTextBlockAction(SourceViewer textViewer) {
		super();
		this.textViewer = textViewer;
		annotation = new Annotation(TB_HIGHLIGHT_ANNOTATION,false, null);
	}



	@Override
    public void handleEvent(Event event) {
		if (event.keyCode == 16777227
			&& (event.stateMask & SWT.CTRL) == SWT.CTRL) {
			AbstractToken token = ((CtsDocument) textViewer.getDocument())
					.getTextBlocksModelStore().getFloorToken(
							textViewer.getSelectedRange().x);
			TextBlock immediateTB = token.getParent();
			Annotation highlightAnnotation = annotation;
			textViewer.getAnnotationModel().removeAnnotation(annotation);
			textViewer.getAnnotationModel().addAnnotation(
					highlightAnnotation,
					new Position(TbUtil.getAbsoluteOffset(immediateTB), immediateTB.getLength()));
		}

	}

}
