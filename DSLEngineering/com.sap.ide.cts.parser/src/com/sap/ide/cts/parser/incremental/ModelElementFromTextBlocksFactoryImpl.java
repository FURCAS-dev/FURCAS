package com.sap.ide.cts.parser.incremental;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import tcs.ClassTemplate;
import tcs.Template;

import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken;
import com.sap.mi.textual.grammar.impl.DelayedReference;
import com.sap.mi.textual.grammar.impl.ModelElementProxy;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.parsing.textblocks.ModelElementFromTextBlocksFactory;
import com.sap.mi.textual.parsing.textblocks.observer.TextBlockProxy;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.textual.moinadapter.adapter.StructureTypeMockObject;

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
	public Collection<? extends RefObject> createModelElementsFromTextBlock(TextBlockProxy newVersion, ModelPartition defaultPartition) {
		List<RefObject> elements = new ArrayList<RefObject>(newVersion
			.getCorrespondingModelElements().size());
		for (IModelElementProxy proxy : newVersion.getCorrespondingModelElements()) {
			if (proxy instanceof ModelElementProxy) {
				Template template = null;
				if (((ModelElementProxy) proxy).getType().equals(
					newVersion.getTemplate().getMetaReference()
						.getQualifiedName())) {
					template = newVersion.getTemplate();
				} else {
					for (Template addTemp : newVersion.getAdditionalTemplates()) {
						if (((ModelElementProxy) proxy).getType().equals(
							addTemp.getMetaReference()
								.getQualifiedName())) {
							template = addTemp;
							break;
						}
					}
				}

				instantiateProxy(elements, proxy, template);
//				if (partitionHandler.getMainPartitionContent().equalsIgnoreCase("all") || partitionHandler.getMainPartitionContent().equalsIgnoreCase("textblocks") ) {

					partitionHandler.assignFromProxy(proxy, newVersion.getSequenceElement(), template, defaultPartition);
//				}

				

			}
		}
		return elements;
	}


	private void instantiateProxy(List<RefObject> elements,
			IModelElementProxy proxy, Template template) {
		// only instantiate if it was not already instantiated
		if (proxy.getRealObject() == null) {
			// if there are any unresolved proxies left in the attribute
			// list this originates from a left recursive refactored
			// operator template, so try to resolve elements on the left
			resolveUnresolvedProxies((ModelElementProxy) proxy, template);
			Object result = batchParser.createOrResolve(proxy,
					(ANTLR3LocationToken) ((ModelElementProxy) proxy)
							.getFirstToken(),
					(ANTLR3LocationToken) ((ModelElementProxy) proxy)
							.getLastToken());
			if (result != null) {
				if (result instanceof RefObject) {
					elements.add((RefObject) result);
					batchParser.setLocationAndComment(result,
							((ModelElementProxy) proxy).getFirstToken());
					
				} else if (result instanceof StructureTypeMockObject) {
					// try {
					// adapterJmiHelper.actualCreateFromMock((StructureTypeMockObject)
					// result);
					// } catch (DeferredModelElementCreationException e) {
					// throw new IncrementalParsingException(e);
					// }
				} else {
					// throw new RuntimeException(
					// "Expected to resolve element to RefObject but got: "
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
			elements.add((RefObject) proxy.getRealObject());
		}
	}

	/**
	 * Removes all unresolved proxies from the attribute list of the given
	 * proxy.
	 * 
	 * @param proxy
	 */
	private void resolveUnresolvedProxies(ModelElementProxy proxy, Template template) {
		for (String key : proxy.getAttributeMap().keySet()) {
			List<Object> value = proxy.getAttributeMap().get(key);
			for (Iterator<Object> iterator = value.iterator(); iterator
					.hasNext();) {
				Object element = iterator.next();
				if (element instanceof IModelElementProxy) {
					if (((IModelElementProxy) element).getRealObject() == null) {
						instantiateProxy(new ArrayList<RefObject>(),
								(IModelElementProxy) element, template);
						// iterator.remove();
					}
				}
			}
		}
	}


	
}
