/**
 *
 */
package com.sap.ide.refactoring.core.textual;

import textblocks.DocumentNode;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Describes the change of the {@link #modelElement} represented by this class.
 * The associated DocumentNode shall be updated according to the type of the change.
 * 
 * @see TextBlockInChangeCalculator
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class ModelElementDocumentNodeChangeDescriptor  {

    public enum ChangeType {
	CREATED, DELETED, CHANGED;
    }

    public final ChangeType changeType;
    public final RefObject modelElement;
    public final DocumentNode documentNode;

    public ModelElementDocumentNodeChangeDescriptor(RefObject modelElement, DocumentNode documentNode, ChangeType changeType) {
	this.modelElement = modelElement;
	this.documentNode = documentNode;
	this.changeType = changeType;
    }
}