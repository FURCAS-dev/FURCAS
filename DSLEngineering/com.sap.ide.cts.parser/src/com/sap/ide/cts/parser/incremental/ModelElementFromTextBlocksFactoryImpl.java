package com.sap.ide.cts.parser.incremental;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.parsing.textblocks.ModelElementFromTextBlocksFactory;
import com.sap.furcas.parsing.textblocks.observer.TextBlockProxy;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.impl.DelayedReference;
import com.sap.furcas.runtime.parser.impl.ModelElementProxy;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;

public class ModelElementFromTextBlocksFactoryImpl implements ModelElementFromTextBlocksFactory {

	private ObservableInjectingParser batchParser;
	private ReferenceHandler referenceManager;
	private PartitionAssignmentHandler partitionHandler;

	public ModelElementFromTextBlocksFactoryImpl(ObservableInjectingParser batchParser,
		ReferenceHandler referenceManager, PartitionAssignmentHandler partitionHandler) {
		super();
		this.batchParser = batchParser;
		this.referenceManager = referenceManager;
		this.partitionHandler = partitionHandler;
	}


	@Override
	public Collection<? extends EObject> createModelElementsFromTextBlock(TextBlockProxy newVersion) {
		List<EObject> elements = new ArrayList<EObject>(newVersion
			.getCorrespondingModelElementProxies().size());
		for (IModelElementProxy proxy : newVersion.getCorrespondingModelElementProxies()) {
			if (proxy instanceof ModelElementProxy) {
				instantiateProxy(elements, proxy);
			}
		}
		return elements;
	}


	private void instantiateProxy(List<EObject> elements,
			IModelElementProxy proxy) {
		// only instantiate if it was not already instantiated
		if (proxy.getRealObject() == null) {
			// if there are any unresolved proxies left in the attribute
			// list this originates from a left recursive refactored
			// operator template, so try to resolve elements on the left
			resolveUnresolvedProxies((ModelElementProxy) proxy);
			Object result = batchParser.createOrResolve(proxy,
					(ANTLR3LocationToken) ((ModelElementProxy) proxy)
							.getFirstToken(),
					(ANTLR3LocationToken) ((ModelElementProxy) proxy)
							.getLastToken());
			if (result != null) {
				if (result instanceof EObject) {
					elements.add((EObject) result);
					batchParser.setLocationAndComment(result,
							((ModelElementProxy) proxy).getFirstToken());
					if (!proxy.isReferenceOnly()) {
						// assign to default partition, but only if it was not
						// resolved
						// by a reference only template
						partitionHandler.assignToDefaultPartition((EObject) result);
					}
				} else if (result instanceof StructureTypeMockObject) {
					// try {
					// adapterJmiHelper.actualCreateFromMock((StructureTypeMockObject)
					// result);
					// } catch (DeferredModelElementCreationException e) {
					// throw new IncrementalParsingException(e);
					// }
				} else {
					// throw new RuntimeException(
					// "Expected to resolve element to EObject but got: "
					// + result);
				}
			} else {
				batchParser.discardProxy(proxy);
			}
			for (DelayedReference delayedRef : batchParser
					.getUnresolvedReferences()) {
				if (delayedRef.getModelElement().equals(proxy.getRealObject())
						|| (proxy.getRealObject() != null && proxy
								.getRealObject().equals(
										delayedRef.getContextElement()))) {
					referenceManager.addNewlyResolvableReferences(delayedRef);
				}
			}
		} else {
			elements.add((EObject) proxy.getRealObject());
		}
	}

	/**
	 * Removes all unresolved proxies from the attribute list of the given
	 * proxy.
	 * 
	 * @param proxy
	 */
	private void resolveUnresolvedProxies(ModelElementProxy proxy) {
		for (String key : proxy.getAttributeMap().keySet()) {
			List<Object> value = proxy.getAttributeMap().get(key);
			for (Iterator<Object> iterator = value.iterator(); iterator
					.hasNext();) {
				Object element = iterator.next();
				if (element instanceof IModelElementProxy) {
					if (((IModelElementProxy) element).getRealObject() == null) {
						instantiateProxy(new ArrayList<EObject>(),
								(IModelElementProxy) element);
						// iterator.remove();
					}
				}
			}
		}
	}


	
}
