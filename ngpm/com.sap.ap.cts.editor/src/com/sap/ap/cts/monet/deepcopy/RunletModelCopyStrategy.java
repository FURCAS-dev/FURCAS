package com.sap.ap.cts.monet.deepcopy;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.ide.cts.editor.deepcopy.DeepCopyHelper;
import com.sap.ide.cts.editor.deepcopy.GenericModelCopyStrategy;
import com.sap.ide.cts.editor.junitcreate.DocumentHistory;

import data.classes.AssociationEndSignatureImplementation;
import data.classes.SapClass;

/**
 * A Runlet / NGPM metamodel specific policy handler. Used for deep copying in
 * {@link DocumentHistory} and by ModelClipboard when performing drag&drop and
 * copy&paste operations.
 * 
 * @author D049157
 */
public class RunletModelCopyStrategy extends GenericModelCopyStrategy {

    private static final String COPY_POSTFIX = "Cpy0";

    private Boolean hasAssocEndConnectedToAssocEndSignImpl(EObject sourceElement, DeepCopyMap copyMap) {
	ResourceSet co = sourceElement.get___Connection();
	if (sourceElement instanceof data.classes.AssociationEnd) {
	    Collection<EObject> linkedElements = DeepCopyHelper.getAllLinkedElements(co, sourceElement);
	    for (EObject linkedElement : linkedElements) {
		if (linkedElement instanceof AssociationEndSignatureImplementation
			&& copyMap.containsKey(linkedElement)
			&& copyMap.get(linkedElement).getModifiedPolicy().getDeepCopyPolicyOption() == DeepCopyPolicyOption.FULL_COPY) {
		    return true;
		}
	    }
	}
	return false;
    }

    private Boolean hasAssocConnectedToAssocEnd(EObject sourceElement, DeepCopyMap copyMap) {
	ResourceSet co = sourceElement.get___Connection();
	if (sourceElement instanceof data.classes.Association) {
	    Collection<EObject> childElements = DeepCopyHelper.getCompositeChildrenImmediate(co, sourceElement);
	    for (EObject childElement : childElements) {
		if (childElement instanceof data.classes.AssociationEnd
			&& copyMap.containsKey(childElement)
			&& copyMap.get(childElement).getModifiedPolicy().getDeepCopyPolicyOption() == DeepCopyPolicyOption.FULL_COPY) {
		    return true;
		}
	    }
	}
	return false;
    }

    private Boolean hasAssocConnectedToClassTypeDef(EObject sourceElement, DeepCopyMap copyMap) {
	ResourceSet co = sourceElement.get___Connection();
	if (sourceElement instanceof data.classes.Association) {
	    Collection<EObject> childElements = DeepCopyHelper.getCompositeChildrenImmediate(co, sourceElement);
	    for (EObject childElement : childElements) {
		if (childElement instanceof data.classes.ClassTypeDefinition
			&& copyMap.containsKey(childElement)
			&& copyMap.get(childElement).getModifiedPolicy().getDeepCopyPolicyOption() == DeepCopyPolicyOption.FULL_COPY) {
		}
	    }
	}
	return false;
    }

    @Override
    protected DeepCopyPolicy getMetaModelSpecificMapping(EObject sourceElement, DeepCopyMap copyMap) {
	if (hasAssocEndConnectedToAssocEndSignImpl(sourceElement, copyMap)) {
	    // System.out.println("altering to FULL for: AssocEnd via AssocEndSignImpl");
	    return new DeepCopyPolicy(DeepCopyPolicyOption.FULL_COPY, null);
	}

	if (hasAssocConnectedToClassTypeDef(sourceElement, copyMap)) {
	    // System.out.println("altering to FULL for: Assoc via ClassTypeDef");
	    return new DeepCopyPolicy(DeepCopyPolicyOption.FULL_COPY, null);
	}

	if (hasAssocConnectedToAssocEnd(sourceElement, copyMap)) {
	    // System.out.println("altering to FULL for: Assoc via EndAssoc");
	    return new DeepCopyPolicy(DeepCopyPolicyOption.FULL_COPY, null);
	}
	return null;
    }

    @Override
    public Boolean prepareLinkingToCompositeParent(String identifier, RefBaseObject source, RefBaseObject copy) {
	// Create a new, unique name with the same length as the original
	// class name. Otherwise all indices of logged activities would
	// need to be adapted.
	if (copy instanceof SapClass) {
	    SapClass clazz = (SapClass) copy;
	    ResourceSet co = clazz.get___Connection();
	    String classname = clazz.getName();
	    	    
	    if (COPY_POSTFIX.length() <= classname.length()) {
		classname = replaceStringEndWith(classname, COPY_POSTFIX);
	    }
	    
	    Integer counter = 0;
	    while(classExists(co, classname)) {
		counter += 1;
		int substr_size = counter.toString().length();
		
		if (substr_size > classname.length()) {
		    throw new RuntimeException("Failed to generate unique name for copy " + clazz + " of " + source);
		}
		classname = replaceStringEndWith(classname, counter.toString());
	    }
	    assert classname.length() == clazz.getName().length();
	    clazz.setName(classname);
	}
	return true;
    }
    
    private String replaceStringEndWith(String string, String replaceEnd) {
	String strBegin = string.substring(0, string.length() - replaceEnd.length());
	return strBegin + replaceEnd;
    }
    
    private Boolean classExists(ResourceSet co, String classname) {
	MQLProcessor mql = co.getMQLProcessor();
	MQLResultSet queryResult = mql.execute(
		"select c from data::classes::SapClass as c where for c(name='" + classname + "')",
		mql.getQueryScopeProvider(/* scopeInclusive */false, /* partitionScope */ null, (String[]) null));
		return queryResult.getRefObjects("c").length > 0;	
    }
	
	
    
}
