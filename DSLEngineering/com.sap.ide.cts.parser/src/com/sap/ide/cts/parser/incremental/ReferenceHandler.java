package com.sap.ide.cts.parser.incremental;

import textblocks.AbstractToken;
import textblocks.LexedToken;
import textblocks.TextBlock;

import com.sap.mi.textual.grammar.impl.DelayedReference;
import com.sap.mi.textual.parsing.textblocks.observer.TextBlockProxy;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

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
	 * @param textBlock 
	 */
	void setNewFeature(SetNewFeatureBean newFeatureBean, boolean assignToPartition, TextBlock textBlock);

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
	 * Unsets the value of the property that is represented by the given <code>subNode</code>
	 * within the corresponding model element of the given {@link TextBlock}.
	 * 
	 * @param oldVersion
	 * @param subNode
	 */
	void unsetPrimitiveFeature(TextBlock oldVersion, LexedToken lt);

	/**
	 * Uses the newly computed PropertyInits stored in the proxy that is attached to the
	 * <code>newVersion</code> to apply them to an existing model element. It is important that
	 * the correct sequence of alternatives is chosen to find out which properties need to be
	 * transferred to the new element.
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
	Object getFeatureValue(RefObject modelElement, String featureName);
}
