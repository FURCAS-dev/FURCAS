/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2008-04-10 13:55:50 +0200 (Do, 10 Apr 2008) $
 * @version $Revision: 859 $
 * @author: $Author: c5107456 $
 *******************************************************************************/
package com.sap.tc.moin.textual.moinadapter.adapter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.mi.textual.grammar.IBareModelAdapter;
import com.sap.mi.textual.grammar.exceptions.DeferredActionResolvingException;
import com.sap.mi.textual.grammar.exceptions.ReferenceSettingException;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinBaseRuntimeException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

/**
 * allows creation of MOIN model elements.
 * Facade for this functionality, this class only contains protectors, functionality is in delegate (for readability).
 * This class checks arguments are not null and of correct modelElement type, and also handles all JMIExceptions
 * by adding what arguments led to them being thrown.
 * 
 */
public class MOINModelAdapter implements IBareModelAdapter {

    protected MoinModelAdapterDelegate delegate;

    private static Set<String> javaLangPrimitiveClassnames = new HashSet<String>();
    static {
	javaLangPrimitiveClassnames.add("Boolean");
	javaLangPrimitiveClassnames.add("Integer");
	javaLangPrimitiveClassnames.add("Long");
	javaLangPrimitiveClassnames.add("Double");
	javaLangPrimitiveClassnames.add("Float");
	javaLangPrimitiveClassnames.add("String");
    }
    
    /**
     * Creates a new ModelAdapter which creates MOIN ModelElements.
     * The referenceScope will implicitly include the PRI of the root element and the visible PRIs of the connection.
     * 
     * @param root Metamodel root as reference for type creation
     * @param connection
     * @param creationScopePri target PRI (if null will not specified) 
     * @param referenceScope (Where to look to resolve references)
     * @param additionalCRIScope Additional containers for lookup
     */
	public MOINModelAdapter(RefPackage root, final Connection connection,
		/*PRI creationScopePri,*/ Collection<PRI> referenceScope, Collection<CRI> additionalCRIScope) {
		
		if (root == null || connection == null ) {
			throw new IllegalArgumentException("One of the following was null: " + root + ", " + connection );
		}

		delegate = new MoinModelAdapterDelegate(root, connection, referenceScope, additionalCRIScope);
		
	}


    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelAdapter#createElement(java.lang.String)
     */
	public Object createElement(List<String>typeName) throws ModelAdapterException {
	    if (typeName == null || typeName.size()==0) {
	        throw new IllegalArgumentException("typeName was null or empty: " + typeName);
	    } else {
	        for (Iterator<String> iterator = typeName.iterator(); iterator.hasNext();) {
                String namePart = iterator.next();
                if (namePart == null || namePart.trim().equals("")) {
                    throw new IllegalArgumentException("typeName part was null or empty: " + typeName);
                }
            }
	    }
	    try {
	        return delegate.createElement(typeName);
	    } catch (JmiException jmiex) {
	        throw new ModelAdapterException("JmiException while creating Element of type " + typeName, jmiex);
	    } catch (MoinBaseRuntimeException jmiex) {
            throw new ModelAdapterException("MoinBaseRuntimeException while creating Element of type " + typeName, jmiex);
	    } catch (RuntimeException re) {
            throw new RuntimeException("Exception while creating Element of type " + typeName, re);
        }
	}


	

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelAdapter#createEnumLiteral(java.util.List, java.lang.String)
     */
    public Object createEnumLiteral(List<String> enumName, String name)
            throws ModelAdapterException {
        if (enumName == null || enumName.size()==0) {
            throw new IllegalArgumentException("typeName was null or empty: " + enumName);
        } else {
            for (Iterator<String> iterator = enumName.iterator(); iterator.hasNext();) {
                String namePart = iterator.next();
                if (namePart == null || namePart.trim().equals("")) {
                    throw new IllegalArgumentException("typeName part was null or empty: " + enumName);
                }
            }
        }
        try {
            // In MOF, no need to create instance, they are static
            return delegate.getEnumLiteral(enumName, name);
        } catch (JmiException jmiex) {
            throw new ModelAdapterException(jmiex.getMessage(), jmiex);
        } catch (RuntimeException re) {
            throw new RuntimeException("Exception while creating Enum Literal of type " + name, re);
        }
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelAdapter#get(java.lang.Object, java.lang.String)
     */
    public Object get(Object modelElementOrProxy, String propertyName)
    throws ModelAdapterException {
        Object modelElement = null;
        if(modelElementOrProxy instanceof IModelElementProxy) {
            modelElement = ((IModelElementProxy) modelElementOrProxy).getRealObject();
        } else {
            modelElement = modelElementOrProxy;
        }
	//TODO implement path notation getter: eg. prop1.prop2 for propertyName
        if (modelElement == null || propertyName == null) {
            throw new IllegalArgumentException("One of the following was null: " + modelElement + ", " + propertyName);
        }
        if (modelElement instanceof RefObject) {
            RefObject refObject = (RefObject) modelElement;

            try {
        	if(propertyName.contains(".")) {
        	    Object value = null;
        	    for (String part : propertyName.split("\\.")) {
        		value = delegate.get(refObject, part);
        		if(value == null || !(value instanceof RefObject)) {
        		    break;
        		} else {
        		    refObject = (RefObject) value;
        		}
		    }
        	    return value;
        	} else {
        	    return delegate.get(refObject, propertyName);
        	}
            } catch (JmiException jmiex) {
                throw new ModelAdapterException("JmiException while getting property " + getCutToString(modelElement) + "." + propertyName, jmiex);
            } catch (RuntimeException re) {
                throw new RuntimeException("Exception while getting property " + getCutToString(modelElement) + "." + propertyName, re);
            }
        } else {
            throw new IllegalArgumentException("Unknown Model Element type " + modelElement.getClass());
        }
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelAdapter#getString(java.lang.Object, java.lang.String)
     */
    @Deprecated
    public String getString(Object modelElement, String propertyName)
    throws ModelAdapterException {
        if (modelElement == null || propertyName == null) {
            throw new IllegalArgumentException("One of the following was null: " + modelElement + "," + propertyName);
        }

        if (modelElement instanceof RefObject) {
            RefObject refObject = (RefObject) modelElement;


            try {
                return delegate.getString(refObject, propertyName);
            } catch (JmiException jmiex) {
                throw new ModelAdapterException("JmiException while getting String property " + getCutToString(modelElement) + "." + propertyName, jmiex);
            } catch (RuntimeException re) {
                throw new RuntimeException("Exception while getting String property " + getCutToString(modelElement) + "." + propertyName, re);
            }
        } else {
            throw new IllegalArgumentException("Unknown Model Element type " + modelElement.getClass());
        }
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelAdapter#instanceOf(java.lang.Object, java.lang.String)
     */
    public boolean instanceOf(Object modelElement, Object metaType)
    throws ModelAdapterException {
        if (modelElement == null || metaType == null) {
            throw new IllegalArgumentException("One of the following was null: " + modelElement + "," + metaType);
        }
        if (! ( modelElement instanceof RefObject) ) {
            throw new IllegalArgumentException("Unknown Model Element type " + modelElement.getClass());
        }
        if( ! (metaType instanceof RefObject) ) {
            throw new IllegalArgumentException("Unknown meta type " + metaType.getClass());
        }

        try {
            return delegate.instanceOf( (RefObject) modelElement,  (RefObject) metaType);
        } catch (JmiException jmiex) {
            throw new ModelAdapterException("JmiException while checking " + getCutToString(modelElement) + " instanceOf " + metaType, jmiex);
        } catch (MoinBaseRuntimeException jmiex) {
            throw new ModelAdapterException("MoinBaseRuntimeException while checking " + getCutToString(modelElement) + " instanceOf " + metaType + " : " + jmiex.getMessage(), jmiex);
        } catch (RuntimeException re) {
            throw new RuntimeException("Exception while checking " + modelElement + " instanceOf " + metaType, re);
        }

    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelAdapter#set(java.lang.Object, java.lang.String, java.lang.Object)
     */
    public void set(Object modelElement, String propertyName, Object value)
            throws ModelAdapterException {
        if (modelElement == null || propertyName == null) {
            throw new IllegalArgumentException("One of the following was null: " + modelElement + "," + propertyName );
        }
        if (value == null) { 
            // don't need to call set to set to null, as this is for injection only
            return;
        }
        if (modelElement instanceof StructureTypeMockObject) {
            StructureTypeMockObject mock = (StructureTypeMockObject) modelElement;
            mock.setField(propertyName, value);
        } else {
        	RefObject refObject = null;
			if (modelElement instanceof RefObject) {
				refObject = (RefObject) modelElement;
			} else if(modelElement instanceof IModelElementProxy){
				refObject = (RefObject) ((IModelElementProxy)modelElement).getRealObject();
			} else {
				throw new IllegalArgumentException(
						"Unknown Model Element type " + modelElement.getClass());
			}

			try {
				delegate.set(refObject, propertyName, value);
			} catch (JmiException jmiex) {
				throw new ModelAdapterException("JmiException while setting "
						+ refObject.getClass() + "." + propertyName + " to "
						+ getCutToString(value) + ":" + jmiex.getClass() + ":"
						+ jmiex.getMessage(), jmiex);
			} catch (RuntimeException re) {
				throw new RuntimeException("Exception while setting "
						+ refObject.getClass() + "." + propertyName + " to "
						+ getCutToString(value) + " : " + re.getMessage(), re);
			}

		}
	}
    
    /*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelAdapter#set(java.lang.Object,
	 *      java.lang.String, java.lang.Object, int)
	 */
    public void set(Object modelElement, String propertyName, Object value, int index)
            throws ModelAdapterException {
        if (modelElement == null || propertyName == null) {
            throw new IllegalArgumentException("One of the following was null: " + modelElement + "," + propertyName );
        }
        if (value == null) { 
            // don't need to call set to set to null, as this is for injection only
            return;
        }
        
        if (modelElement instanceof RefObject) {
            RefObject refObject = (RefObject) modelElement;

            try {
                delegate.set(refObject, propertyName, value, index);
            } catch (JmiException jmiex) {                
                throw new ModelAdapterException("JmiException while setting " + refObject.getClass() + "." + propertyName + " to " + getCutToString(value)+ ":" + jmiex.getClass() + ":" +jmiex.getMessage(), jmiex);
            } catch (RuntimeException re) {
                throw new RuntimeException("Exception while setting " + refObject.getClass() + "." + propertyName + " to " + getCutToString(value) + " : " + re.getMessage(), re);
            }
        } else if (modelElement instanceof StructureTypeMockObject) {
            StructureTypeMockObject mock = (StructureTypeMockObject) modelElement;
            mock.setField(propertyName, value);
        } else {
            throw new IllegalArgumentException("Unknown Model Element type " + modelElement.getClass());
        }
    }
    
    	@Override
	public void unset(Object modelElement, String propertyName, Object value) throws ModelAdapterException {
		if (modelElement == null || propertyName == null) {
			throw new IllegalArgumentException(
					"One of the following was null: "
							+ modelElement + ","
							+ propertyName);
		}

		if (modelElement instanceof RefObject) {
			RefObject refObject = (RefObject) modelElement;

			try {
				delegate.unset(refObject, propertyName, value);
			} catch (JmiException jmiex) {
				throw new ModelAdapterException(
						"JmiException while unsetting "
								+ refObject
										.getClass()
								+ "."
								+ propertyName
								+ " to "
								+ getCutToString(value)
								+ ":"
								+ jmiex
										.getClass()
								+ ":"
								+ jmiex
										.getMessage(),
						jmiex);
			} catch (RuntimeException re) {
				throw new RuntimeException(
						"Exception while unsetting "
								+ refObject
										.getClass()
								+ "."
								+ propertyName
								+ " to "
								+ getCutToString(value)
								+ " : "
								+ re
										.getMessage(),
						re);
			}
		} else if (modelElement instanceof StructureTypeMockObject) {
			StructureTypeMockObject mock = (StructureTypeMockObject) modelElement;
			mock.unsetField(propertyName);
		} else {
			throw new IllegalArgumentException(
					"Unknown Model Element type "
							+ modelElement
									.getClass());
		}
	}

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelAdapter#setReference(java.lang.Object, java.lang.String, java.lang.String, java.lang.String, java.lang.Object)
     */
    public Object setReference(Object sourceModelElement,
            String referencePropertyName, List<String> targetType,
            String targetKeyName, Object targetKeyValue)
    throws ModelAdapterException, ReferenceSettingException {
        if (sourceModelElement == null || referencePropertyName == null || targetType == null || targetKeyName == null) {
            throw new IllegalArgumentException("One of the following was null: " + sourceModelElement + "," + referencePropertyName + "," + targetType + "," + targetKeyName);
        }
        RefObject refObject = null;
        if (sourceModelElement instanceof RefObject) {
            refObject = (RefObject) sourceModelElement;
        }else if(sourceModelElement instanceof IModelElementProxy){
        	refObject = (RefObject) ((IModelElementProxy)sourceModelElement).getRealObject();
        } else {
            throw new IllegalArgumentException("Unknown Model Element type " + sourceModelElement.getClass());
        }
        try {
            return delegate.setReference(refObject, referencePropertyName, targetType, targetKeyName, targetKeyValue, null);
        } catch (JmiException jmiex) {
            throw new ModelAdapterException("JmiException while setting Reference " + sourceModelElement + "." + referencePropertyName + " to modelelement of type " + MessageUtil.asModelName(targetType) + " with " + targetKeyName + "=" + targetKeyValue, jmiex);
        } catch (MoinBaseRuntimeException re) {
            throw new ModelAdapterException("MoinBaseRuntimeException while setting Reference " + sourceModelElement + "." + referencePropertyName + " to modelelement of type " + targetType + " with " + targetKeyName + "=" + targetKeyValue, re);
        } catch (RuntimeException re) {
            throw new RuntimeException("RuntimeException while setting Reference " + sourceModelElement + "." + referencePropertyName + " to modelelement of type " + targetType + " with " + targetKeyName + "=" + targetKeyValue, re);
        }
    }

    

    /**
     * @param string
     */
    public RefObject[] getElementsOfType(String type) {
        try {
            return delegate.getElementsOfType(type); 
        } catch (RuntimeException re) {
            throw new RuntimeException("JmiException while getting elements of type" + type, re);
        }
    }


    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelAdapter#hasDeferredActions()
     */
    @Override
    public boolean hasDeferredActions() {

        return delegate.hasDeferredActions();
    }


    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelAdapter#performAllDeferredActions()
     */
    @Override
    public Map<Object, Object> performAllDeferredActions()
            throws DeferredActionResolvingException {
        return delegate.performAllDeferredActions();
    }
    
    private static String getCutToString(Object object) {
        if (object == null) {
            return null;
        }
        String toString = object.toString();
        
        String[] tokens = toString.split("\\s");
        return tokens[0];
    }


    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelAdapter#setOCLReference(java.lang.Object, java.lang.String, java.lang.String)
     */
    @Override
    public Object setOclReference(Object sourceModelElement, String referencePropertyName, Object keyValue, 
            String oclQuery, Object contextObject, Object currentForeachElement) throws ModelAdapterException, ReferenceSettingException {
        if (sourceModelElement == null || referencePropertyName == null || oclQuery == null) {
            throw new IllegalArgumentException("One of the following was null: " + sourceModelElement + "," + referencePropertyName + "," + oclQuery );
        }
        if (sourceModelElement instanceof RefObject) {
            RefObject refObject = (RefObject) sourceModelElement;
//try {
            return delegate.setQueriedReference(refObject, referencePropertyName, keyValue, oclQuery, contextObject, currentForeachElement);
//catch( MQLException e) {}
            
        } else {
        	return null;
            //throw new IllegalArgumentException("Unknown Model Element type " + sourceModelElement.getClass());
        }
    }


    @Override
	public Collection<?> getPredicateOclReference(Object modelElement,
			String propertyName, Object keyValue, String oclQuery,
			Object contextElement) throws ModelAdapterException {
		return delegate.getOclEvaluation((RefObject)modelElement,propertyName,keyValue,oclQuery,contextElement);
	}


	/* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelAdapter#getMetaType(java.util.List)
     */
    @Override
    public Object getMetaType(List<String> typeName)  throws ModelAdapterException {
        if (typeName == null || typeName.size() == 0) {
            return null;
        }
        return delegate.getMetaType(typeName);
    }


    /**
     * Sets within context of an element, if not null, contextElement must be a subtype of type MOF::Namespace (thus containing other modelElements)
     * @see com.sap.mi.textual.grammar.IModelAdapter#setWithinContextObject(java.lang.Object, java.lang.String, java.util.List, java.lang.String, java.lang.Object, java.lang.Object)
     */
    @Override
    public Object setWithinContextObject(Object sourceModelElementOrProxy,
            String referencePropertyName, List<String> targetType, String targetKeyName,
            Object targetKeyValue, Object contextObject) 
        throws ModelAdapterException, ReferenceSettingException {
            if (sourceModelElementOrProxy == null || referencePropertyName == null || targetType == null) {
                throw new IllegalArgumentException("One of the following was null: " + sourceModelElementOrProxy + "," + referencePropertyName + "," + targetType);
            }
            Object sourceModelElement = null;
            if (sourceModelElementOrProxy instanceof IModelElementProxy) {
                sourceModelElement =  ((IModelElementProxy) sourceModelElementOrProxy).getRealObject();
            } else {
                sourceModelElement = sourceModelElementOrProxy;
            }
            if ( ! ( sourceModelElement instanceof RefObject) ) {
                throw new IllegalArgumentException("Illegal Model Element type " + sourceModelElement.getClass() + ", RefObject required");
            }
            if (contextObject instanceof IModelElementProxy) {
        	contextObject = ((IModelElementProxy) contextObject).getRealObject();
            }
            if ( ! (( contextObject instanceof RefObject) || contextObject instanceof Collection<?> ||
        	    isPrimitive(contextObject))) {
                throw new IllegalArgumentException("Illegal Model Element type " + contextObject.getClass() + ", RefObject required");
            } 
            //TODO: @Thibault: Why ???
//            if ( ! ( contextObject instanceof Namespace) ) { // To be more meaningful, this is a separate case with a separate exception
//                throw new ReferenceSettingException("Context Model Element is of type " + contextObject.getClass() + ", but subtype of Namespace is required");
//            }
            
            
            try {
                return delegate.setReference((RefObject) sourceModelElement, referencePropertyName, targetType, targetKeyName, targetKeyValue, contextObject);
            } catch (JmiException jmiex) {
                throw new ModelAdapterException("JmiException while setting Reference " + sourceModelElement + "." + referencePropertyName + " to modelelement of type " + targetType + " with " + targetKeyName + "=" + targetKeyValue, jmiex);
            } catch (MoinBaseRuntimeException re) {
                throw new ModelAdapterException("MoinBaseRuntimeException while setting Reference " + sourceModelElement + "." + referencePropertyName + " to modelelement of type " + targetType + " with " + targetKeyName + "=" + targetKeyValue, re);
            } catch (RuntimeException re) {
                throw new RuntimeException("RuntimeException while setting Reference " + sourceModelElement + "." + referencePropertyName + " to modelelement of type " + targetType + " with " + targetKeyName + "=" + targetKeyValue, re);
            }

    }

    /**
     * Checks if <tt>o</tt>'s Java type qualifies as a primitive type in MOF. In particular,
     * those types are {@link Boolean}, {@link String}, {@link Float}, {@link Long},
     * {@link Integer} and {@link Double}.
     */
    private boolean isPrimitive(Object o) {
	return (o.getClass().getPackage().getName().equals("java.lang") &&
		javaLangPrimitiveClassnames.contains(o.getClass().getSimpleName()));
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelAdapter#queryElement(java.util.List, java.util.Map)
     */
    @Override
    public Collection<Object> queryElement(List<String> typeName,
            Map<String, List<Object>> attributes) throws ModelAdapterException {
        if (typeName == null || typeName.size()==0) {
            throw new IllegalArgumentException("typeName was null or empty: " + typeName);
        } else {
            for (Iterator<String> iterator = typeName.iterator(); iterator.hasNext();) {
                String namePart = iterator.next();
                if (namePart == null || namePart.trim().equals("")) {
                    throw new IllegalArgumentException("typeName part was null or empty: " + typeName);
                }
            }
        }
        try {
            return delegate.queryElement(typeName, attributes);
        } catch (Exception e) {
            throw new ModelAdapterException(e.getMessage(), e);            
        }
    }
    
}
