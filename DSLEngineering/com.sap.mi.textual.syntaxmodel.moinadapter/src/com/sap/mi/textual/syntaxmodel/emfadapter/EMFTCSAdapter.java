/**
 * 
 */
package com.sap.mi.textual.syntaxmodel.emfadapter;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.TCS.TCSPackage;
import com.sap.furcas.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.grammar.IBareModelAdapter;
import com.sap.mi.textual.grammar.exceptions.DeferredActionResolvingException;
import com.sap.mi.textual.grammar.exceptions.ReferenceSettingException;
import com.sap.tc.moin.textual.emfadapter.adapter.MOINModelAdapter;


/**
 * specialized Adapter for TCS Syntaxes
 */
public class EMFTCSAdapter implements IBareModelAdapter {

	private final MOINModelAdapter adapter;
	private final ResourceSet connection;

	/**
	 * @param metamodelURIs
	 * 
	 */
	public EMFTCSAdapter(ResourceSet connection, Set<URI> metamodelURIs) {
		super();
		this.connection = connection;
		final EPackage rootPackage = TCSPackage.eINSTANCE;
		if (rootPackage == null) {
			throw new IllegalArgumentException(
					"ResourceSet cannot resolve TCSPackage "
							+ TCSPackage.eINSTANCE);
		}
		Set<URI> adapterReferenceScopeURIs;
		if (metamodelURIs != null) {
			adapterReferenceScopeURIs = new HashSet<URI>(
					metamodelURIs);
		} else {
			adapterReferenceScopeURIs = new HashSet<URI>();
		}

		// For TCS, need the Mof Model as well as the transient
		// partitions as scope.
		adapterReferenceScopeURIs
				.add(URI.createURI("http://www.eclipse.org/emf/2002/Ecore"));
		

		adapter = new MOINModelAdapter(rootPackage, connection,
				adapterReferenceScopeURIs,  null);
	}

	public void close() {
		//connection.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelAdapter#createElement(java.lang.String)
	 */
	@Override
	public Object createElement(List<String> typeName)
			throws ModelAdapterException {
		Object element = adapter.createElement(typeName);
		return element;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelAdapter#createEnumLiteral(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public Object createEnumLiteral(List<String> enumName, String name)
			throws ModelAdapterException {
		Object createdLiteral = adapter.createEnumLiteral(enumName,
				name);
		return createdLiteral;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelAdapter#get(java.lang.Object,
	 *      java.lang.String)
	 */
	@Override
	public Object get(Object modelElement, String propertyName)
			throws ModelAdapterException {
		Object element = adapter.get(modelElement, propertyName);
		return element;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelAdapter#hasDeferredActions()
	 */
	@Override
	public boolean hasDeferredActions() {
		return adapter.hasDeferredActions();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelAdapter#instanceOf(java.lang.Object,
	 *      java.lang.String)
	 */
	@Override
	public boolean instanceOf(Object instance, Object typeName)
			throws ModelAdapterException {
		return adapter.instanceOf(instance, typeName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelAdapter#performAllDeferredActions()
	 */
	@Override
	public Map<Object, Object> performAllDeferredActions()
			throws DeferredActionResolvingException {

		Map<Object, Object> map = adapter.performAllDeferredActions();
		return map;
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
		adapter.set(modelElement, prop, value);
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
		adapter.set(modelElement, prop, value, index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelAdapter#setReference(java.lang.Object,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.Object)
	 */
	@Override
	public Object setReference(Object sourceModelElement,
			String referencePropertyName, List<String> targetType,
			String targetKeyName, Object targetKeyValue)
			throws ModelAdapterException, ReferenceSettingException {
		Object reference = adapter.setReference(sourceModelElement,
				referencePropertyName, targetType,
				targetKeyName, targetKeyValue);
		return reference;
	}

	/**
	 * @param string
	 * @return
	 */
	public Set<Object> getElementsByType(String string) {
		Object[] array = adapter.getElementsOfType(string);
		Set<Object> set = null;
		if (array != null) {
			set = new HashSet<Object>(Arrays.asList(array));
		}
		return set;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelAdapter#setOclReference(java.lang.Object,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public Object setOclReference(Object modelElement, String propertyName,
			Object keyValue, String oclQuery, Object contextObject, Object currentForeachElement)
			throws ModelAdapterException {
		Object result = adapter
				.setOclReference(modelElement, propertyName,
						keyValue, oclQuery,
						contextObject, currentForeachElement);
		return result;
	}

	@Override
	public Collection getPredicateOclReference(Object modelElement,
			String propertyName, Object keyValue, String oclQuery,
			Object contextElement) throws ModelAdapterException {
		// TODO fill in the right stuff
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelAdapter#getMetaType(java.util.List)
	 */
	@Override
	public Object getMetaType(List<String> typeName)
			throws ModelAdapterException {
		return adapter.getMetaType(typeName);
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
		return adapter.setWithinContextObject(modelElement,
				propertyName, valueTypeName, keyName, keyValue,
				contextObject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelAdapter#queryElement(java.util.List,
	 *      java.util.Map)
	 */
	@Override
	public Collection<Object> queryElement(List<String> type,
			Map<String, List<Object>> attributes)
			throws ModelAdapterException {
		return adapter.queryElement(type, attributes);
	}

	@Override
	public void unset(Object modelElement, String prop, Object value)
			throws ModelAdapterException {
		adapter.unset(modelElement, prop, value);
	}
	
}
