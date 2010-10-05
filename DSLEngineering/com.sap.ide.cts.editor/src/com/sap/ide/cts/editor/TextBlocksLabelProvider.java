package com.sap.ide.cts.editor;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;

import textblocks.AbstractToken;
import textblocks.TextBlock;

import com.sap.furcas.textual.common.interfaces.IModelElementInvestigator;
import com.sap.furcas.textual.textblocks.model.ShortPrettyPrinter;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidNameException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class TextBlocksLabelProvider implements ILabelProvider {

    	private ShortPrettyPrinter shortPrettyPrinter;

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
			if (!tb.getCorrespondingModelElements().isEmpty()){
			    sb.append(" Corresponding elements: ");
			}
			for (RefObject correspsondingME : tb.getCorrespondingModelElements()) {
				sb.append(correspsondingME.refMetaObject().refGetValue("name"));
				try {
					Object value = correspsondingME.refGetValue("name");
					sb.append(" Name:").append(value);
				} catch(InvalidNameException e) {
					appendId(sb, correspsondingME);
				} catch(InvalidCallException e) {
					appendId(sb, correspsondingME);
				}
			}
			if (!tb.getReferencedElements().isEmpty()) {
			    sb.append(" Referenced elements: ");
			}
			for (RefObject referencedME : tb.getReferencedElements()) {
				sb.append(referencedME.refMetaObject().refGetValue("name"));
				try {
					Object value = referencedME.refGetValue("name");
					sb.append(" Name:").append(value);
				} catch(InvalidNameException e) {
					appendId(sb, referencedME);
				} catch(InvalidCallException e) {
					appendId(sb, referencedME);
				}
			}
		} else if (element instanceof AbstractToken){
			AbstractToken tok = (AbstractToken)element;
			sb.append("\"");
			String tokenValue = shortPrettyPrinter.resynchronizeToEditableState(tok);
			sb.append(tokenValue.replaceAll("\n", "\\\\n").replaceAll("\r", "\\\\r").replaceAll("\t", "\\\\t"));
			sb.append("\"");
			if (!tok.getCorrespondingModelElements().isEmpty()){
			    sb.append(" Corresponding elements: ");
			}
			for (RefObject correspsondingME : tok.getCorrespondingModelElements()) {
				sb.append(correspsondingME.refMetaObject().refGetValue("name"));
				try {
					Object value = correspsondingME.refGetValue("name");
					sb.append(" Name:").append(value);
				} catch(InvalidNameException e) {
					appendId(sb, correspsondingME);
				} catch(InvalidCallException e) {
					appendId(sb, correspsondingME);
				}
			}
			if (!tok.getReferencedElements().isEmpty()) {
			    sb.append(" Referenced elements: ");
			}
			for (RefObject referencedME : tok.getReferencedElements()) {
			        if(referencedME != null) {
        				sb.append(referencedME.refMetaObject().refGetValue("name"));
        				try {
        					Object value = referencedME.refGetValue("name");
        					sb.append(" Name:").append(value);
        				} catch(InvalidNameException e) {
        					appendId(sb, referencedME);
        				} catch(InvalidCallException e) {
        					appendId(sb, referencedME);
        				}
			        }
			}
		}
		return sb.toString();
	}

	private void appendId(StringBuffer sb, RefObject correspsondingME) {
		sb.append(" ID:");
		sb.append(correspsondingME.refMofId());
	}

}
