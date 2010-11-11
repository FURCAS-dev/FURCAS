package com.sap.ide.cts.editor;

import javax.naming.InvalidNameException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.DefaultTextHover;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.ISourceViewer;

import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.ide.cts.editor.document.CtsDocument;

public class CtsTextHover extends DefaultTextHover {

	public CtsTextHover(ISourceViewer sourceViewer) {
		super(sourceViewer);
	}

	public String getHoverInfo(ITextViewer viewer, IRegion hoverRegion) {
		String annotationText = super.getHoverInfo(viewer, hoverRegion);
		AbstractToken token = ((CtsDocument)viewer.getDocument()).getTextBlocksModelStore().getFloorToken(hoverRegion.getOffset());
		StringBuffer sb = new StringBuffer(annotationText == null ? "" : annotationText + "\n");
		if (token.getCorrespondingModelElements().size() > 0) {
			for (EObject element : token.getCorrespondingModelElements()) {
				sb.append("Corresponding element of Token: ").append(toString(element)).append("\n");
			}
		}
		if (token.getReferencedElements().size() > 0) {
			for (EObject element : token.getReferencedElements()) {
				sb.append("Referenced element of Token: ").append(toString(element)).append("\n");
			}
		}
		if (token.getParent().getCorrespondingModelElements().size() > 0){
			for (EObject element : token.getParent().getCorrespondingModelElements()) {
				sb.append("Corresponding element of Block: ").append(toString(element)).append("\n");
			}
		}
		
		if (token.getParent().getReferencedElements().size() > 0){
			for (EObject element : token.getParent().getReferencedElements()) {
				sb.append("Referenced element of Block: ").append(toString(element)).append("\n");
			}
		}
		return sb.toString();
	}

	private Object toString(EObject element) {
		StringBuffer sb = new StringBuffer();
		sb.append(element.refMetaObject().refGetValue("name"));
		try {
			Object value = element.refGetValue("name");
			sb.append(" Name:").append(value);
		} catch(InvalidNameException e) {
			appendId(sb, element);
		} catch(InvalidCallException e) {
			appendId(sb, element);
		}
		return sb.toString();
	}
	
	private void appendId(StringBuffer sb, EObject correspsondingME) {
		sb.append(" ID:");
		sb.append(correspsondingME.refMofId());
	}

	public IRegion getHoverRegion(ITextViewer viewer, int offset) {
			AbstractToken token = ((CtsDocument)viewer.getDocument()).getTextBlocksModelStore().getFloorToken(offset);
			IRegion region = new Region(TbUtil.getAbsoluteOffset(token), token.getLength());
			return region;
	}

}
