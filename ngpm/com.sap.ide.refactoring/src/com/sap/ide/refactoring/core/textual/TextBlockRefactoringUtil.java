package com.sap.ide.refactoring.core.textual;

import java.util.Collection;

import textblocks.DocumentNode;
import textblocks.DocumentNodeReferencedElement;
import textblocks.DocumentNodeReferencesCorrespondingModelElement;
import textblocks.TextblocksPackage;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class TextBlockRefactoringUtil {
        
    public static Collection<DocumentNode> findCorrespondingTextBlocks(RefObject modelElement) {
	Connection co = modelElement.get___Connection();
	DocumentNodeReferencesCorrespondingModelElement assoc = co.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR).getDocumentNodeReferencesCorrespondingModelElement();
	return assoc.getDocumentNode(modelElement);
    }

    public static Collection<DocumentNode> findReferencedTextBlocks(RefObject modelElement) {
	Connection co = modelElement.get___Connection();
	DocumentNodeReferencedElement assoc = co.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR).getDocumentNodeReferencedElement();
	return assoc.getDocumentNode(modelElement);
    }
}
