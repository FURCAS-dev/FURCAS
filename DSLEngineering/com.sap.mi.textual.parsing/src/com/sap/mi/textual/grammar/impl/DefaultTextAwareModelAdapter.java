/**
 * 
 */
package com.sap.mi.textual.grammar.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.grammar.IBareModelAdapter;
import com.sap.mi.textual.grammar.IModelAdapter;
import com.sap.mi.textual.grammar.ModelElementCreationException;
import com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken;
import com.sap.mi.textual.grammar.exceptions.DeferredActionResolvingException;
import com.sap.mi.textual.grammar.exceptions.ReferenceSettingException;

/**
 * simple implementation using a simple resolution strategy and a
 * IBareModelAdapter else.
 */
public class DefaultTextAwareModelAdapter implements IModelAdapter {

	private final IBareModelAdapter modelAdapter;

	/**
	 * @param modelAdapter
	 */
	public DefaultTextAwareModelAdapter(IBareModelAdapter modelAdapter) {
		super();
		if (modelAdapter == null) {
			throw new IllegalArgumentException();
		}
		this.modelAdapter = modelAdapter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.ITextAwareModelAdapter#createOrResolveElement(java.util.List,
	 *      java.util.Map,
	 *      com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken,
	 *      com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken)
	 */
	@Override
	public Object createOrResolveElement(List<String> typeName,
			Map<String, List<Object>> attributes,
			ANTLR3LocationToken firstToken,
			ANTLR3LocationToken lastToken, boolean resolveOnly,
			boolean createOnly) throws ModelAdapterException,
			ModelElementCreationException {

		// ModelElementProxy proxy = (ModelElementProxy) proxyObject;
		// If referenceOnly, merely resolve it, don't create it
		if (resolveOnly) {

			try {
				Collection<Object> resultSet = modelAdapter
						.queryElement(typeName,
								attributes);

				if (resultSet != null && resultSet.size() >= 1) {
					if (resultSet.size() == 1) {
						return resultSet.iterator()
								.next();
					} else {
						throw new ModelElementCreationException(
								"Reference "
										+ typeName
										+ " with attributes "
										+ attributes
										+ " is ambiguous.");
					}
				} else {
					throw new ModelElementCreationException(
							"Reference "
									+ typeName
									+ " with attributes "
									+ attributes
									+ " could not be resolved.");
				}
			} catch (ModelAdapterException e) {
				// TODO move this to getModelAdapter() and
				// delete ModelElement on errors (?)
				throw new ModelElementCreationException(
						"BUG: Exception resolving type "
								+ typeName
								+ " with attributes "
								+ attributes
								+ " : "
								+ e
										.getMessage(),
						e);
			}
		} else { // create new object and set its attributes,
				// this is the default behavior
			Object createdObject = modelAdapter
					.createElement(typeName);

			Set<String> features = attributes.keySet();
			for (String prop : features) {
				List<Object> valueList = attributes.get(prop);
				for (Iterator<Object> iterator = valueList
						.iterator(); iterator.hasNext();) {
					// TODO: for single value properties,
					// cause error when trying to set more
					// than once?
					Object value = iterator.next();
					if (value instanceof ModelElementProxy) {
						ModelElementProxy valueProxy = (ModelElementProxy) value;
						value = valueProxy
								.getRealObject();
						if (value == null)
							throw new RuntimeException(
									"Bug: proxy value for '"
											+ prop
											+ "' of type "
											+ valueProxy
													.getType()
											+ " had not been resolved.");
					}
					try {
						set(createdObject, prop, value);
					} catch (ModelAdapterException e) {
						// TODO move this to
						// getModelAdapter() and delete
						// ModelElement on errors (?)
						throw new ModelElementCreationException(
								"Exception setting feature "
										+ prop
										+ " for object "
										+ createdObject
										+ " to "
										+ value
										+ ": "
										+ e
												.getMessage(),
								e);
					}
				}
			}
			return createdObject;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelAdapter#createEnumLiteral(java.util.List,
	 *      java.lang.String)
	 */
	@Override
	public Object createEnumLiteral(List<String> enumName, String name)
			throws ModelAdapterException {
		return modelAdapter.createEnumLiteral(enumName, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelAdapter#hasDeferredActions()
	 */
	@Override
	public boolean hasDeferredActions() {
		return modelAdapter.hasDeferredActions();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelAdapter#performAllDeferredActions()
	 */
	@Override
	public Map<Object, Object> performAllDeferredActions()
			throws DeferredActionResolvingException {
		return modelAdapter.performAllDeferredActions();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelAdapter#set(java.lang.Object,
	 *      java.lang.String, java.lang.Object)
	 */
	@Override
	public void set(Object modelElement, String prop, Object value)
			throws ModelAdapterException {
		modelAdapter.set(modelElement, prop, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelAdapter#set(java.lang.Object,
	 *      java.lang.String, java.lang.Object, int)
	 */
	@Override
	public void set(Object modelElement, String prop, Object value,
			int index) throws ModelAdapterException {
		modelAdapter.set(modelElement, prop, value, index);
	}

	@Override
	public void unset(Object modelElement, String prop, Object value)
			throws ModelAdapterException {
		modelAdapter.unset(modelElement, prop, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelAdapter#setOclReference(java.lang.Object,
	 *      java.lang.String, java.lang.Object, java.lang.String,
	 *      java.lang.Object)
	 */
	@Override
	public Object setOclReference(Object modelElement, String propertyName,
			Object keyValue, String oclQuery, Object contextElement, Object currentForeachElement)
			throws ModelAdapterException, ReferenceSettingException {
		return modelAdapter.setOclReference(modelElement, propertyName,
				keyValue, oclQuery, contextElement, currentForeachElement);
	}

	
	@Override
	public Collection<?> getPredicateOclReference(Object modelElement,
			String propertyName, Object keyValue, String oclQuery,
			Object contextElement) throws ModelAdapterException {
		return modelAdapter.getPredicateOclReference(modelElement, propertyName,
				keyValue, oclQuery, contextElement);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelAdapter#setReference(java.lang.Object,
	 *      java.lang.String, java.util.List, java.lang.String,
	 *      java.lang.Object)
	 */
	@Override
	public Object setReference(Object sourceModelElement,
			String referencePropertyName, List<String> targetType,
			String targetKeyName, Object targetKeyValue)
			throws ModelAdapterException, ReferenceSettingException {
		return modelAdapter.setReference(sourceModelElement,
				referencePropertyName, targetType,
				targetKeyName, targetKeyValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelAdapter#setWithinContextObject(java.lang.Object,
	 *      java.lang.String, java.util.List, java.lang.String,
	 *      java.lang.Object, java.lang.Object)
	 */
	@Override
	public Object setWithinContextObject(Object modelElement,
			String propertyName, List<String> valueTypeName,
			String keyName, Object keyValue, Object contextObject)
			throws ModelAdapterException, ReferenceSettingException {
		return modelAdapter.setWithinContextObject(modelElement,
				propertyName, valueTypeName, keyName, keyValue,
				contextObject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelElementInvestigator#get(java.lang.Object,
	 *      java.lang.String)
	 */
	@Override
	public Object get(Object modelElement, String propertyName)
			throws ModelAdapterException {
		return modelAdapter.get(modelElement, propertyName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelElementInvestigator#getMetaType(java.util.List)
	 */
	@Override
	public Object getMetaType(List<String> typeName)
			throws ModelAdapterException {
		return modelAdapter.getMetaType(typeName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelElementInvestigator#instanceOf(java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	public boolean instanceOf(Object instance, Object metaType)
			throws ModelAdapterException {
		return modelAdapter.instanceOf(instance, metaType);
	}

	@Override
	public Collection<Resource> getPRIPartitions(ResourceSet conn, String languageId) {
		//must be done in a subclass
		return null;
	}

}
