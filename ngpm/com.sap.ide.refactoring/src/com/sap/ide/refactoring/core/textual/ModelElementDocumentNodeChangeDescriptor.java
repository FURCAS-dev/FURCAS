/**
 *
 */
package com.sap.ide.refactoring.core.textual;

import textblocks.DocumentNode;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class ModelElementDocumentNodeChangeDescriptor {

    public enum ChangeType {
	CREATED, DELETED, CHANGED;
    }

    public final RefObject modelElement;
    public final DocumentNode documentNode;
    public final ChangeType changeType;

    public ModelElementDocumentNodeChangeDescriptor(RefObject modelElement, DocumentNode documentNode, ChangeType changeType) {
        this.modelElement = modelElement;
	this.documentNode = documentNode;
	this.changeType = changeType;
    }
}