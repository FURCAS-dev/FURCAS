package com.sap.furcas.runtime.parser.impl;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ReferenceSettingException;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ModelElementCreationException;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.impl.context.ContextManager;

public class DefaultLookupDelayedReference extends DelayedReference {

    public DefaultLookupDelayedReference(IModelElementProxy currentContextElement, Object currentForeachElement,
            Object modelElement, String propertyName, List<String> valueTypeName, String keyName, Object keyValue,
            String lookIn, String autoCreate, List<String> createAs, boolean importContext, String createIn, boolean b,
            ANTLR3LocationToken lastToken) {
        super(currentContextElement, currentForeachElement, modelElement, propertyName, valueTypeName, keyName,
                keyValue, lookIn, autoCreate, createAs, importContext, createIn, b, ReferenceType.TYPE_OCL, lastToken);
    }

    public DefaultLookupDelayedReference(IModelElementProxy currentContextElement, Object currentForeachElement,
            Object object, String propertyName, String keyName, Object keyValue, String query, boolean optional,
            ANTLR3LocationToken lastToken) {
        super(currentContextElement, currentForeachElement, object, propertyName, keyName, keyValue, query, ReferenceType.TYPE_OCL,
                optional, lastToken);
    }

    /**
     * default way of setting references, instead of using MQL query
     * 
     * @param reference
     * @param modelAdapter
     * @param referenceContext
     * @param contextByElement
     * @throws ModelAdapterException
     * @throws ModelElementCreationException
     */
	public boolean setDelayedReference(DelayedReference reference,
			IModelAdapter modelAdapter, ContextManager contextManager,
			ObservableInjectingParser parser) throws ModelAdapterException,
			ModelElementCreationException {
        Object contextElement = reference.getContextElement();
        if (contextElement instanceof IModelElementProxy) {
            IModelElementProxy proxyContext = (IModelElementProxy) contextElement;
            contextElement = proxyContext.getRealObject();
        }
		// TODO validate no obsolete property args are set
		try {
			contextElement = DelayedReferencesHelper.getNavigatedContextElementFromReference(reference,
					modelAdapter, contextManager, contextElement);
			if (reference.getModelElement() instanceof ModelElementProxy) {
				ModelElementProxy proxy = (ModelElementProxy) reference
						.getModelElement();
				if (proxy.getRealObject() == null) {
					Object result;
					result = modelAdapter.createOrResolveElement(
							proxy.getType(), proxy.getAttributeMap(), null,
							null, false, true);
					if (result instanceof EObject) {
						reference.setModelElement(result);
					}
				} else {
					reference.setModelElement(proxy.getRealObject());
				}
			}
			Object result = modelAdapter.setReferenceWithOCLQuery(
					reference.getModelElement(), reference.getPropertyName(),
					reference.getKeyValue(), reference.getOclQuery(),
					contextElement, reference.getCurrentForeachElement());
			if (result == null) {
				String message = "Referenced ModelElement for query '"
						+ reference.getOclQuery()
						+ "' was not found for property '"
						+ reference.getPropertyName() + "' of "
						+ reference.getModelElement().getClass().getName()
						+ " with key value: " + reference.getKeyValue();
				parser.getInjector().addError(new ParsingError(message, reference.getToken()));
				return false;
			} else {
				reference.setRealValue(result);
				return true;
			}
		} catch (ReferenceSettingException rse) {
			parser.getInjector().addError(new ParsingError(rse.getMessage(), reference.getToken()));
			return false;
		} catch (LookupPathNavigationException lpne) {
			parser.getInjector().addError(new ParsingError(lpne.getMessage(), reference.getToken()));
			return false;
		} catch (ModelElementCreationException e) {
			parser.getInjector().addError(new ParsingError(e.getMessage(), reference.getToken()));
			return false;
		}

	}

}
