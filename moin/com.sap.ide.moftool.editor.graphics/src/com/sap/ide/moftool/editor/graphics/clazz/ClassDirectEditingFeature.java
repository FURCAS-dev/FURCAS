package com.sap.ide.moftool.editor.graphics.clazz;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.ModelElement;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public abstract class ClassDirectEditingFeature extends AbstractDirectEditingFeature{
    
	protected  List<String> ALL_QUALIFIED_CLASSIFIERS = new ArrayList<String>();
    protected  List<String> ALL_CLASSIFIERS = new ArrayList<String>();
    protected  List<String> ALL_CLASSIFIERS_WITH_COMMENT = new ArrayList<String>();
    protected static final char TYPE_SEPERATOR=':';
    
    public ClassDirectEditingFeature(IFeatureProvider fp) {
        super(fp);
        Collection<Classifier> col = MofService.getAvailableClassifiers(getConnection());
        for (Classifier classifier : col) {
        	ALL_CLASSIFIERS.add(classifier.getName());
        	String concatVal = null;
        	String concatValWithoutLastSegment = null; 
            String packageInfo = " ()"; //$NON-NLS-1$
            if (classifier.getQualifiedName().size() > 1) {
            	List<String> qualifiedName = classifier.getQualifiedName();
            	concatVal = MofService.getQualifiedNameAsString(qualifiedName);
            	int lastSegmentIndex = concatVal.lastIndexOf('.');
            	if (lastSegmentIndex != -1) {
            		concatValWithoutLastSegment = concatVal.substring(0, lastSegmentIndex);
            	} else {
            		concatValWithoutLastSegment = concatVal; 
            	}
//              packageInfo = " (from " + concatValWithoutLastSegment + ")";
                String pattern = Messages.ClassDirectEditingFeature_0_xmsg;
                packageInfo = MessageFormat.format(pattern, new Object[]{concatValWithoutLastSegment});

            }
            String str = classifier.getName() + packageInfo;
            ALL_CLASSIFIERS_WITH_COMMENT.add(str); 
            ALL_QUALIFIED_CLASSIFIERS.add(concatVal);
        }
        Collections.sort(ALL_CLASSIFIERS);
        Collections.sort(ALL_CLASSIFIERS_WITH_COMMENT);
        Collections.sort(ALL_QUALIFIED_CLASSIFIERS);
    }

    public int getEditingType() {
        return 0;
    }

    public String getInitialValue(IDirectEditingContext context) {
        return null;
    }

    public void setValue(String value, IDirectEditingContext context) {
    }

    protected List<String> getAllClassifiers(){
        return ALL_CLASSIFIERS;
    }
    
    protected List<String> getAllQualifiedClassifiers(){
        return ALL_QUALIFIED_CLASSIFIERS;
    }
    

    
    @Override
    public boolean isCompletionAvailable() {
        return true;
    }

    @Override
    public boolean isAutoCompletionEnabled() {
        return true;
    }

	/* (non-Javadoc)
	 * @see com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature#canDirectEdit(com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	@Override
	public boolean canDirectEdit(IDirectEditingContext context) {
		boolean ret = super.canDirectEdit(context);
		if (!ret) {
			return false;
		}
		PictogramElement pe = context.getPictogramElement();
		if (pe != null) {
			Object bo = getBusinessObjectForPictogramElement(pe);
			if (bo instanceof ModelElement) {     
				ret = !ModelElementService.isForeignObject(getDiagram(), (ModelElement)bo);
			}
		}
		return ret;
	}
}
