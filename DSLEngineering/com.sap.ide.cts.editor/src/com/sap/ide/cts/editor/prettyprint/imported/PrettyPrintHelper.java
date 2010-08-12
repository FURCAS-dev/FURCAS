package com.sap.ide.cts.editor.prettyprint.imported;

import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.TYPE_SYMBOL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import tcs.ClassTemplate;

import com.sap.ide.cts.editor.prettyprint.MOINImportedModelAdapter;
import com.sap.mi.textual.tcs.util.TcsUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

public class PrettyPrintHelper {

    public static boolean isSymbol(int type, int test) {
	test += TYPE_SYMBOL;
	return (type & test) == test;
    }
    
    public static ClassTemplate findSupertypeTemplate(GeneralizableElement g, String mode,
	    Map<List<String>, Map<String, ClassTemplate>> classTemplateMap) {
	ClassTemplate template = null;
	for (GeneralizableElement supertype : g.getSupertypes()) {
	    if (supertype instanceof Classifier) {
		Classifier c = (Classifier) supertype;
		template = TcsUtil.resolveClassTemplate(c.getQualifiedName(), mode, classTemplateMap);
		if (template != null && !template.isAbstract()) {
		    return template;
		}
	    }
	}
	for (GeneralizableElement supertype : g.getSupertypes()) {
	    template = findSupertypeTemplate(supertype, mode, classTemplateMap);
	    if (template != null && !template.isAbstract()) {
		return template;
	    }
	}
	return null;
    }

    public static ClassTemplate findSupertypeTemplate(RefObject r, String mode,
	    Map<List<String>, Map<String, ClassTemplate>> classTemplateMap) {
	return findSupertypeTemplate((MofClass) r.refMetaObject(), mode, classTemplateMap);
    }

    public static ClassTemplate findSupertypeTemplate(RefStruct r, String mode,
	    Map<List<String>, Map<String, ClassTemplate>> classTemplateMap, Connection conn) {
	return findSupertypeTemplate((MofClass) conn.getElement(r.refMetaObjectMri()), mode, classTemplateMap);
    }

    public static RefObject getBlockArgument(RefObject ame, String name) {
	RefObject ret = null;
	for (Iterator<?> i = MOINImportedModelAdapter.getCol(ame, "blockArgs"); i.hasNext() && (ret == null);) {
	    Object arg = i.next();
	    if (MOINImportedModelAdapter.getTypeName((RefObject) arg).equals("TCS::" + name + "BArg")) {
		ret = (RefObject) arg;
	    }
	}
	return ret;
    }

    public static RefObject getPropertyArgument(RefObject ame, String name) {
	RefObject ret = null;
	for (Iterator<?> i = MOINImportedModelAdapter.getCol(ame, "propertyArgs"); i.hasNext() && (ret == null);) {
	    Object arg = i.next();
	    if (MOINImportedModelAdapter.getTypeName((RefObject) arg).equals("TCS::" + name + "PArg")) {
		ret = (RefObject) arg;
	    }
	}
	return ret;
    }

    public static boolean isInstanceOf(RefObject element, List<String> type) {
	MofClass m = (MofClass) element.refMetaObject();

	List<GeneralizableElement> typesToCheck = new ArrayList<GeneralizableElement>(m.allSupertypes());
	// also add element type itself
	typesToCheck.add(m);

	for (GeneralizableElement g : typesToCheck)

	{
	    List<String> qName = g.getQualifiedName();
	    // maybe type is not fully qualified, compare each part
	    if (isTypeMatch(qName, type)) {
		return true;
	    }
	}
	return false;
    }

    /**
     * compares the types from the end backwards (in case the
     * partiallyQulifiedTypeName is not fully qualified)
     * 
     * Example: ConcreteSyntax instead of TCS::ConcreteSyntax
     * 
     * @param fullyQualifiedTypeName
     * @param partiallyQualifiedTypeName
     * 
     * @return
     */
    public static boolean isTypeMatch(List<String> fullyQualifiedTypeName, List<String> partiallyQualifiedTypeName) {
	boolean allPartsMatch = true;
	if (fullyQualifiedTypeName.size() >= partiallyQualifiedTypeName.size()) {
	    for (int i = 1; i <= partiallyQualifiedTypeName.size(); i++) {
		if (!fullyQualifiedTypeName.get(fullyQualifiedTypeName.size() - i).equals(
			partiallyQualifiedTypeName.get(partiallyQualifiedTypeName.size() - i))) {
		    allPartsMatch = false;
		}
	    }
	}
	return allPartsMatch;
    }
    
}
