package com.sap.ide.cts.editor;

import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidNameException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.jface.text.DefaultTextHover;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.ISourceViewer;

import textblocks.AbstractToken;

import com.sap.furcas.textual.textblocks.TbUtil;
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
			for (RefObject element : token.getCorrespondingModelElements()) {
				sb.append("Corresponding element of Token: ").append(toString(element)).append("\n");
			}
		}
		if (token.getReferencedElements().size() > 0) {
			for (RefObject element : token.getReferencedElements()) {
				sb.append("Referenced element of Token: ").append(toString(element)).append("\n");
			}
		}
		if (token.getParentBlock().getCorrespondingModelElements().size() > 0){
			for (RefObject element : token.getParentBlock().getCorrespondingModelElements()) {
				sb.append("Corresponding element of Block: ").append(toString(element)).append("\n");
			}
		}
		
		if (token.getParentBlock().getReferencedElements().size() > 0){
			for (RefObject element : token.getParentBlock().getReferencedElements()) {
				sb.append("Referenced element of Block: ").append(toString(element)).append("\n");
			}
		}
		return sb.toString();
	}

	private Object toString(RefObject element) {
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
	
	private void appendId(StringBuffer sb, RefObject correspsondingME) {
		sb.append(" ID:");
		sb.append(correspsondingME.refMofId());
	}

	public IRegion getHoverRegion(ITextViewer viewer, int offset) {
			AbstractToken token = ((CtsDocument)viewer.getDocument()).getTextBlocksModelStore().getFloorToken(offset);
			IRegion region = new Region(TbUtil.getAbsoluteOffset(token), token.getLength());
			return region;
	}

}
