package com.sap.ide.cts.parser.incremental;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.parser.impl.DelayedReference;
import com.sap.furcas.runtime.parser.textblocks.observer.TextBlockProxy;

/**
 * Provides services to re-resolve references and set feature values.
 * 
 * @author C5106462
 * 
 */
public interface ReferenceHandler {
	/**
	 * Registers the given token to be used to re-resolve references that used its value as key.
	 * 
	 * @param subNode
	 */
	void registerTokenForReferenceResolving(AbstractToken subNode);

	/**
	 * Registers the given {@link DelayedReference} as being ready for re-resolving.
	 * 
	 * @param delayedRef
	 */
	void addNewlyResolvableReferences(DelayedReference delayedRef);

	/**
	 * Resolves all references that were analyzed using the {@link DelayedReference}s added
	 * through {@link #addNewlyResolvableReferences(DelayedReference)} and those computed
	 * through the tokens registered through
	 * {@link #registerTokenForReferenceResolving(AbstractToken)}.
	 */
	void resolveRemainingReferences();

	/**
	 * Clears the internal collections of newly resolvable references that were added through
	 * {@link #addNewlyResolvableReferences(DelayedReference)} as well as the list of tokens
	 * that should be used for re-resolving, which were added through
	 * {@link #registerTokenForReferenceResolving(AbstractToken)}.
	 */
	void reset();

	/**
	 * Set the feature according to the given {@link SetNewFeatureBean};
	 * 
	 * @param newFeatureBean
	 */
	void setNewFeature(SetNewFeatureBean newFeatureBean, boolean assignToPartition);

	/**
	 * Sets the value of the property that is represented by the given <code>subNode</code>
	 * within the corresponding model element of the given {@link TextBlock}.
	 * 
	 * @param newVersion
	 * @param oldVersion
	 * @param subNode
	 */
	void setNewPrimitiveFeature(TextBlockProxy newVersion, TextBlock oldVersion,
		AbstractToken subNode);

	/**
	 * Unsets the value of the property that is represented by the given <code>lt</code>
	 * within the corresponding model element of the given {@link TextBlock}.
	 * 
	 * @param oldVersion
	 * @param lt
	 */
	void unsetPrimitiveFeature(TextBlock oldVersion, LexedToken lt);
	
	/**
         * Unsets the value of the property that is represented by the given <code>tb</code>
         * within the corresponding model element of the given {@link TextBlock}.
         * 
         * @param oldVersion
         * @param tb
         */
        void unsetFeature(TextBlock oldVersion, TextBlock tb);

	/**
	 * Uses the newly computed PropertyInits stored in the proxy that is attached to the
	 * <code>newVersion</code> to apply them to an existing model element. It is important that
	 * the correct sequence of alternatives is chosen to find out which properties need to be
	 * transferred to the new element.
	 * 
	 * @TODO check if this is needed. This functionality should already have been provided by
	 * the {@link GlobalDelayedReferenceResolver}.Maybe for those elements that are just  something like this:
	 * {{property = 1}. These elements are maybe not handled by the GDRR. On the other hand the value should only 
	 * change according to changes in the parsed alternatives.
	 * 
	 * @param oldVersion
	 * @param newVersion
	 */
	void reEvaluatePropertyInits(TextBlock oldVersion, TextBlockProxy newVersion);

	/**
	 * Unsets a feature using the given newFeatureBean
	 * 
	 * @param the
	 *                {@link SetNewFeatureBean} to unset.
	 */
	void unsetFeature(SetNewFeatureBean newFeatureBean);

	/**
	 * Gets the value of the given feature from the given model element.
	 * 
	 * @param modelElement
	 *                the model element from which the value should be retrieved.
	 * @param featureName
	 *                the feature to get the value for.
	 * @return the value of the given feature from the given model element.
	 */
	Object getFeatureValue(EObject modelElement, String featureName);
}
