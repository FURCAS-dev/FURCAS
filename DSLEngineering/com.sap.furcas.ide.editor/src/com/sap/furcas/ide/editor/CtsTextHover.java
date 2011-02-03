package com.sap.furcas.ide.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.DefaultTextHover;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.ISourceViewer;

import com.sap.furcas.ide.editor.document.CtsDocument;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.runtime.textblocks.TbUtil;

public class CtsTextHover extends DefaultTextHover {

	public CtsTextHover(ISourceViewer sourceViewer) {
		super(sourceViewer);
	}

	@Override
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
		sb.append(element.eClass().eGet(EcorePackage.eINSTANCE.getENamedElement_Name()));
                EStructuralFeature nameFeature = element.eClass()
                        .getEStructuralFeature("name");
                if (nameFeature != null) {
                    Object value = element.eGet(nameFeature);
                    sb.append(" Name:").append(value);
                }
		return sb.toString();
	}
	
	private void appendId(StringBuffer sb, EObject correspsondingME) {
		sb.append(" ID:");
		sb.append(EcoreUtil.getURI(correspsondingME));
	}

	@Override
    public IRegion getHoverRegion(ITextViewer viewer, int offset) {
			AbstractToken token = ((CtsDocument)viewer.getDocument()).getTextBlocksModelStore().getFloorToken(offset);
			IRegion region = new Region(TbUtil.getAbsoluteOffset(token), token.getLength());
			return region;
	}

}
