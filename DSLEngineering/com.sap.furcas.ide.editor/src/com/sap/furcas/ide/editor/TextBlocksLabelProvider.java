package com.sap.furcas.ide.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.common.interfaces.IModelElementInvestigator;
import com.sap.furcas.runtime.textblocks.shortprettyprint.ShortPrettyPrinter;

public class TextBlocksLabelProvider implements ILabelProvider {

    	private final ShortPrettyPrinter shortPrettyPrinter;

	public TextBlocksLabelProvider(
		IModelElementInvestigator adapter) {
		this.shortPrettyPrinter = new ShortPrettyPrinter(adapter);
    }

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("restriction") // need some Eclipse constants
	@Override
	public Image getImage(Object element) {
		if (element instanceof TextBlock) {
			return org.eclipse.ui.internal.WorkbenchImages.getImage(ISharedImages.IMG_OBJ_FILE);
		} else if (element instanceof AbstractToken){
			return org.eclipse.ui.internal.WorkbenchImages.getImage(org.eclipse.ui.internal.IWorkbenchGraphicConstants.IMG_OBJ_ACTIVITY);
		} else {
			return null;
		}
	}

	@Override
	public String getText(Object element) {
		StringBuffer sb = new StringBuffer();
		if (element instanceof TextBlock) {
			TextBlock tb = (TextBlock) element;
			appendCorrespondingAndReferencedElements(sb, tb);
		} else if (element instanceof AbstractToken){
			AbstractToken tok = (AbstractToken)element;
			sb.append("\"");
			String tokenValue = shortPrettyPrinter.resynchronizeToEditableState(tok);
			sb.append(tokenValue.replaceAll("\n", "\\\\n").replaceAll("\r", "\\\\r").replaceAll("\t", "\\\\t"));
			sb.append("\"");
			appendCorrespondingAndReferencedElements(sb, tok);
		}
		return sb.toString();
	}

    private void appendCorrespondingAndReferencedElements(StringBuffer sb,
            DocumentNode tb) {
        if (!tb.getCorrespondingModelElements().isEmpty()){
            sb.append(" Corresponding elements: ");
        }
        for (EObject correspsondingME : tb.getCorrespondingModelElements()) {
            sb.append(correspsondingME.eClass().eGet(
                            EcorePackage.eINSTANCE.getENamedElement_Name()));
                        EStructuralFeature eStructuralFeature = correspsondingME
                                .eClass().getEStructuralFeature("name");
                        if (eStructuralFeature != null) {
                            Object value = correspsondingME.eGet(eStructuralFeature);
                            sb.append(" Name:").append(value);
                        }
        }
        if (!tb.getReferencedElements().isEmpty()) {
            sb.append(" Referenced elements: ");
        }
        for (EObject referencedME : tb.getReferencedElements()) {
                        sb.append(referencedME.eClass().eGet(
                                EcorePackage.eINSTANCE.getENamedElement_Name()));
                        EStructuralFeature eStructuralFeature = referencedME
                                .eClass().getEStructuralFeature("name");
                        if (eStructuralFeature != null) {
                            Object value = referencedME.eGet(eStructuralFeature);
                            sb.append(" Name:").append(value);
                        }
        }
    }

	private void appendId(StringBuffer sb, EObject correspsondingME) {
		sb.append(" URI:");
		sb.append(EcoreUtil.getURI(correspsondingME));
	}

}
