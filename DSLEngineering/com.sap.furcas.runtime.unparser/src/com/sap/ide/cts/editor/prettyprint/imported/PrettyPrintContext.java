package com.sap.ide.cts.editor.prettyprint.imported;

import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.INDENTATION_PRIMITIVE;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.runtime.tcs.TcsUtil;

public class PrettyPrintContext {

    // to keep the pretty printer from going into recursion in the case that
    // serialize for one model elment calls serialize for the same model element
    // recursively
    private final Set<EObject> visitedModelElements = new HashSet<EObject>();

    private final Stack<Integer> priorities = new Stack<Integer>();
    private final Stack<String> currentSeparator = new Stack<String>();
    private final Stack<ClassTemplate> classTemplates = new Stack<ClassTemplate>();
    private final Stack<EObject> parentEObjects = new Stack<EObject>();

    private int indentLevel = 0;
    private String curIndent = "";

    public Stack<EObject> getParentEObjects() {
	return parentEObjects;
    }

    private int typeLast = 0;

    public Stack<ClassTemplate> getClassTemplates() {
	return classTemplates;
    }

    public int getTypeLast() {
	return typeLast;
    }

    public void setTypeLast(int typeLast) {
	this.typeLast = typeLast;
    }

    public Set<EObject> getVisitedModelElements() {
	return visitedModelElements;
    }

    public Stack<Integer> getPriorities() {
	return priorities;
    }

    public Stack<String> getCurrentSeparator() {
	return currentSeparator;
    }

    public int getIndentLevel() {
	return indentLevel;
    }

    public void setIndentLevel(int indentLevel) {
	this.indentLevel = indentLevel;
    }

    public String getCurIndent() {
	return curIndent;
    }

    public void setCurIndent(String curIndent) {
	this.curIndent = curIndent;
    }

    public void incIndentLevel(int amount) {
	indentLevel += amount;
	
	for (int i = 0; i < amount; i++) {
	    addToCurIndent(INDENTATION_PRIMITIVE);
	}
    }

    private void addToCurIndent(String toAdd) {
	curIndent += toAdd;
    }

    public void decIndentLevel(int amount) {
	indentLevel -= amount;

	removeFromCurIndent(INDENTATION_PRIMITIVE.length() * amount);
    }

    private void removeFromCurIndent(int toRemoveLength) {
	curIndent = curIndent.substring(0, curIndent.length() - toRemoveLength);
    }


    @Override
    public PrettyPrintContext clone() {
	PrettyPrintContext result = new PrettyPrintContext();

	result.setCurIndent(curIndent);
	result.setIndentLevel(indentLevel);
	result.setTypeLast(typeLast);
	result.getVisitedModelElements().addAll(visitedModelElements);

	Iterator<Integer> prioIter = priorities.iterator();
	while (prioIter.hasNext()) {
	    result.getPriorities().push(prioIter.next());
	}

	Iterator<String> sepIter = currentSeparator.iterator();
	while (sepIter.hasNext()) {
	    result.getCurrentSeparator().push(sepIter.next());
	}

	Iterator<ClassTemplate> ctIter = classTemplates.iterator();
	while (ctIter.hasNext()) {
	    result.getClassTemplates().push(ctIter.next());
	}

	Iterator<EObject> poIter = parentEObjects.iterator();
	while (poIter.hasNext()) {
	    result.getParentEObjects().push(poIter.next());
	}

	return result;
    }

    /**
     * Helper method to resolve ClassTemplate context from PrettyPrint context.
     * 
     * @param context
     * @param tag
     * @return
     */
    public static EObject getContextElement(PrettyPrintContext context, String tag) {
	assert (context.getClassTemplates().size() == context.getParentEObjects().size());
	assert (context.getClassTemplates().size() > 0);

	PrettyPrintContext clone = context.clone();

	ClassTemplate curParentCT = null;
	EObject curParentRO = null;

	while (clone.getClassTemplates().size() > 0) {
	    curParentCT = clone.getClassTemplates().pop();
	    curParentRO = clone.getParentEObjects().pop();

	    if (TcsUtil.matchesContext(curParentCT, tag)) {

		return curParentRO;
	    }
	}

	return null;
    }
    
}
