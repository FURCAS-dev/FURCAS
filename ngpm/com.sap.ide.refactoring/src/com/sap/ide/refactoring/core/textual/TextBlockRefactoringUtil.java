package com.sap.ide.refactoring.core.textual;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import tcs.ConcreteSyntax;
import tcs.Template;
import textblocks.DocumentNode;
import textblocks.DocumentNodeReferencedElement;
import textblocks.DocumentNodeReferencesCorrespondingModelElement;
import textblocks.TextBlock;
import textblocks.TextblocksPackage;

import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class TextBlockRefactoringUtil {
        
    public static Collection<DocumentNode> findCorrespondingTextBlocks(RefObject modelElement) {
	Connection co = modelElement.get___Connection();
	DocumentNodeReferencesCorrespondingModelElement assoc = co.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR).getDocumentNodeReferencesCorrespondingModelElement();
	return assoc.getDocumentNode(modelElement);
    }
    
    public static Collection<DocumentNode> findCorrespondingTextBlocks(RefObject modelElement, String syntaxName) { 
	return filterForSyntaxName(findCorrespondingTextBlocks(modelElement), syntaxName);
    }
    
    /**
     * TODO: can we do better than that?
     */
    private static Collection<DocumentNode> filterForSyntaxName(Collection<DocumentNode> nodes, String syntaxName) {
	nodes = new ArrayList<DocumentNode>(nodes);
	Iterator<DocumentNode> iter = nodes.iterator();
	while (iter.hasNext()) {
	    boolean valid = true;
	    DocumentNode node = iter.next();
	    if (node instanceof TextBlock) {
		TextBlock block = (TextBlock) node;
		if (block.getType() == null) {
		    valid = false;
		} else {
		    Template template = ((TextBlock) node).getType().getParseRule();
		    ConcreteSyntax syntax = template.getConcretesyntax();
		    if (!syntax.getName().equals(syntaxName)) {
			valid = false;
		    }
		}
	    } else {
		valid = false;
	    }
	    if (!valid) {
		iter.remove();
	    }
	}
	return nodes;
    }
    
    public static Collection<DocumentNode> findReferencedTextBlocks(RefObject modelElement) {
	Connection co = modelElement.get___Connection();
	DocumentNodeReferencedElement assoc = co.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR).getDocumentNodeReferencedElement();
	return assoc.getDocumentNode(modelElement);
    }
    
    public static Collection<RootElementTextBlockTuple> findTextBlockRootDomainRootObjectTuples(DocumentNode documentNode) {
	Connection co = documentNode.get___Connection();
	DocumentNodeReferencesCorrespondingModelElement assoc = co.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR)
		.getDocumentNodeReferencesCorrespondingModelElement();
	Set<RootElementTextBlockTuple> roots = new HashSet<RootElementTextBlockTuple>();
	TextBlock tbRootNode = TbNavigationUtil.getUltraRoot(documentNode);
	for (RefObject rootObject : assoc.getCorrespondingModelElements(tbRootNode)) {
	    roots.add(new RootElementTextBlockTuple(rootObject, tbRootNode));
	}
	return roots;
    }
    
    public static Collection<RootElementTextBlockTuple> findTextBlockRootDomainRootObjectTuplesForModelElement(RefObject modelElement) {
	Set<RootElementTextBlockTuple> rootTuples = new HashSet<RootElementTextBlockTuple>();
	for (DocumentNode documentNode : TextBlockRefactoringUtil.findCorrespondingTextBlocks(modelElement)) {
	    rootTuples.addAll(TextBlockRefactoringUtil.findTextBlockRootDomainRootObjectTuples(documentNode));
	}
	return rootTuples;
    }
    
    public static RefactoringStatus isValidIdentifier(String name, RefactoringEditorFacade facade) {
	RefactoringStatus status = new RefactoringStatus();
	
	if (name == null || name.isEmpty()) {
	    status.merge(RefactoringStatus.createFatalErrorStatus("Name is empty."));
	}
	if (name.contains(" ") || name.contains("\t") || name.contains("\n") || name.contains("\r")) {
	    status.merge(RefactoringStatus.createWarningStatus("Name contains special characters."));
	} 
	if (facade.getTokenNames().contains(name)) {
	    status.merge(RefactoringStatus.createWarningStatus("Name is an identifier. Usage discouraged."));
	}
	return status;
    }

}
