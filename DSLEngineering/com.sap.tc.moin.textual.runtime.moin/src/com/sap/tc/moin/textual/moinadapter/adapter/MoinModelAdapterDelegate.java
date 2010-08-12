/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2008-04-10 13:55:50 +0200 (Do, 10 Apr 2008) $
 * @version $Revision: 859 $
 * @author: $Author: c5107456 $
 *******************************************************************************/
package com.sap.tc.moin.textual.moinadapter.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.mi.textual.grammar.exceptions.DeferredActionResolvingException;
import com.sap.mi.textual.grammar.exceptions.DeferredModelElementCreationException;
import com.sap.mi.textual.grammar.exceptions.ReferenceSettingException;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;
import com.sap.tc.moin.textual.moinadapter.adapter.AdapterJMIHelper.AssociationBean;

/**
 * Functionality Delegate for MOINModelAdapter. This class contains the 
 * core AdapterFunctionality, while it delegates repeated and tedious JMI tasks
 * to a helper class.
 */
public class MoinModelAdapterDelegate {

    private final AdapterJMIHelper jmiHelperDelegate;
    private final JmiHelper jmiHelper;
    private final Collection<StructureTypeMockObject> structureTypeMocks = new ArrayList<StructureTypeMockObject>();
    private final Map<Object, Object> mock2ModelElementMap = new HashMap<Object, Object>();

    public MoinModelAdapterDelegate(RefPackage root, final Connection connection, Collection<PRI> referenceScope, Collection<CRI> additionalCRIScope) {
        this.jmiHelper = connection.getJmiHelper();
        this.jmiHelperDelegate = new AdapterJMIHelper(root, connection, jmiHelper, referenceScope, additionalCRIScope); 
        if (jmiHelper == null) {
            throw new IllegalArgumentException("jmihelper was null of connection " + connection);
        }
    }
    
    /**
     * Constructor meant for testing only
     * @param adapterHelper
     * @param jmiHelper
     * @deprecated use public constructor instead
     */
    @Deprecated
    MoinModelAdapterDelegate(AdapterJMIHelper adapterHelper, JmiHelper jmiHelper) {
        this.jmiHelper = jmiHelper;
        this.jmiHelperDelegate = adapterHelper;
    }

    public Object createElement(List<String> typeName) throws ModelAdapterException {
        Object clazz = jmiHelperDelegate.createObject(typeName);
        if (clazz instanceof StructureTypeMockObject) { // save deferred action for later
            StructureTypeMockObject mock = (StructureTypeMockObject) clazz;
            structureTypeMocks.add(mock );
        }
        return clazz;
    }

    /**
     * 
     * @param arg0
     * @return
     * @throws ModelAdapterException
     * @deprecated
     */
    @Deprecated
	public Object createEnumLiteral(String arg0) {
        // TODO: delete this method, deprecated
        throw new RuntimeException("Not implemented yet");
    }
    
    /**
     * @param enumName
     * @param name
     * @return
     * @throws ModelAdapterException 
     */
    public Object getEnumLiteral(List<String> enumName, String name) throws ModelAdapterException {
        RefEnum enumLiteral = jmiHelperDelegate.getEnumLiteral(enumName, name);
        return enumLiteral;
    }

    public Object get(RefObject refObject , String propertyName) throws ModelAdapterException {
        try {
            Object value = null;
            
	    MofClass mofClass = (MofClass) refObject.refMetaObject();
	    // property may either be an attribute or a reference. First
	    // checking Attribute, if not then check reference.
	    Attribute attribute = jmiHelper.getAttributeByName(mofClass,
		    propertyName, true);
	    if (attribute != null) {

		value = refObject.refGetValue(attribute);
	    } else {
		// could be a reference instead

		// try looking up reference directly
		Reference reference = jmiHelper.getReferenceByName(mofClass,
			propertyName, true);
		if (reference != null) {
		    value = refObject.refGetValue(reference);
		} else {
		    // could still be the passive end of an Association.
		    AssociationBean associationBean = AdapterJMIHelper
			    .findAssociation(refObject, propertyName, jmiHelper);

		    if (associationBean == null) {
			throw new ModelAdapterException(
				"MofClass has no such property: "
					+ mofClass.getName() + "."
					+ propertyName);
		    } else {
			value = associationBean.refAss.refQuery(propertyName,
				refObject);
		    }
		}
	    } // end if is attribute else try reference
	    return value;
	} catch (InvalidCallException ice) {
	    throw new ModelAdapterException(refObject
		    + " does not have a property with the name '"
		    + propertyName + "'");
	}
    }


    public String getString(RefObject refObject, String propertyName) {
        return String.valueOf(refObject.refGetValue(propertyName) );
    }

    public boolean instanceOf(RefObject refObject, RefObject metaType) {
        return refObject.refIsInstanceOf(metaType, true);

    }

    /**
     * <tt>value</tt> can be a collection of objects which then will all be set at once for
     * a multi-valued feature <tt>propertyName</tt>
     */
    @SuppressWarnings("unchecked")
    public void set( RefObject refAObject, String propertyName, Object value)
    throws ModelAdapterException {

        // if value is a mock, set to real object instead, may require creating the real object from the mock first
        if (value instanceof StructureTypeMockObject) {
            StructureTypeMockObject mock = (StructureTypeMockObject) value;
            // set value to the real object
            if (mock2ModelElementMap.containsKey(mock)) {
                value = mock2ModelElementMap.get(mock);
            } else {
                value = jmiHelperDelegate.actualCreateFromMock(mock);
            }
            
            mock2ModelElementMap.put(mock, value);
        }
        
        MofClass mofClass = (MofClass) refAObject.refMetaObject();

        // property may either be an attribute or a reference. First checking Attribute, if not then check reference.
        Attribute attribute = jmiHelper.getAttributeByName(mofClass, propertyName, true);
        if (attribute != null) {

            MultiplicityType mult = attribute.getMultiplicity();
            if ( mult != null) {
                if (mult.getUpper() == 1) {
                    //only set if value really changed
                    Object originalValue = refAObject.refGetValue(propertyName);
                    if((value == null && originalValue != null) || 
                	    (value != null && originalValue == null) ||
                	    !originalValue.equals(value)) {
                	refAObject.refSetValue(propertyName, value);
                    }
                } else {
                    Collection<Object> multiProperty = (Collection<Object>) refAObject.refGetValue(propertyName);
                    if (mult.getUpper() < 0 || multiProperty.size() < mult.getUpper()) {
                    	if(value instanceof Collection) {
                    		multiProperty.addAll((Collection<? extends Object>) value);
                    	} else {
                    		multiProperty.add(value);
                    	}
                    } else {
                        throw new ModelAdapterException("Cannot add value, property " + propertyName + " has an upper multiplicity of " + mult.getUpper());
                    }
                }
            }           
        } else {
            // could be a reference instead

            // try looking up reference directly
            Reference reference = jmiHelper.getReferenceByName(mofClass, propertyName, true);
            if (reference != null && value instanceof RefObject) {
                RefObject refObjectValue = (RefObject) value;
                try {
                    jmiHelperDelegate.createAssociationLink(reference, refAObject, refObjectValue);
                } catch (TypeMismatchException tme) {
                    throw new ModelAdapterException("Cannot add value, property " + propertyName +
                	    " has wrong type", tme);
                }
            } else if (reference != null && value instanceof Collection) {
                if(reference.getMultiplicity().getUpper() < ((Collection)value).size() && reference.getMultiplicity().getUpper() != -1) {
                    throw new ModelAdapterException("Cannot add value, property " + propertyName + " has an upper multiplicity of " + 
                            reference.getMultiplicity().getUpper()  + " but wanted to to set " + ((Collection<?>)value).size() + " elements (" + value + "");
                }
            	for (Iterator iterator = ((Collection)value).iterator(); iterator
						.hasNext();) {
					RefObject refObjectValue = (RefObject) iterator.next();
					jmiHelperDelegate.createAssociationLink(reference, refAObject, refObjectValue);					
				}
                
            } else {
                // could still be the passive end of an Association. 
                boolean associationFound = jmiHelperDelegate.findAssociationAndAddLink(refAObject, propertyName, value);

                if (! associationFound ) {
                    throw new ModelAdapterException("MofClass has no such property: "+ mofClass.getName() + "." + propertyName);
                }
            } 
        } // end if is attribute else try reference

    }

    
    @SuppressWarnings("unchecked")
    public void set( RefObject refAObject, String propertyName, Object value, int index)
    throws ModelAdapterException {

	// if value is a mock, set to real object instead, may require creating the real object from the mock first
        if (value instanceof StructureTypeMockObject) {
            StructureTypeMockObject mock = (StructureTypeMockObject) value;
            // set value to the real object
            if (mock2ModelElementMap.containsKey(mock)) {
                value = mock2ModelElementMap.get(mock);
            } else {
                value = jmiHelperDelegate.actualCreateFromMock(mock);
            }
            
            mock2ModelElementMap.put(mock, value);
        }
        
        MofClass mofClass = (MofClass) refAObject.refMetaObject();

        // property may either be an attribute or a reference. First checking Attribute, if not then check reference.
        Attribute attribute = jmiHelper.getAttributeByName(mofClass, propertyName, true);
        if (attribute != null) {

            MultiplicityType mult = attribute.getMultiplicity();
            if ( mult != null) {
                if (mult.getUpper() == 1) {
                    refAObject.refSetValue(propertyName, value);
                } else {
                	//unordered means don't care about the index
                	if(!mult.isOrdered()) {
	                    Collection<Object> multiProperty = (Collection<Object>) refAObject.refGetValue(propertyName);
	                    if (mult.getUpper() < 0 || multiProperty.size() < mult.getUpper()) {
	                    	if(value instanceof Collection) {
	                    		multiProperty.addAll((Collection<? extends Object>) value);
	                    	} else {
	                    		multiProperty.add(value);
	                    	}
	                    } else {
	                        throw new ModelAdapterException("Cannot add value, property " + propertyName + " has an upper multiplicity of " + mult.getUpper());
	                    }
                	} else {
                		List<Object> multiProperty = (List<Object>) refAObject.refGetValue(propertyName);
                		if(index <= multiProperty.size() && index >= 0) {
		                    if (mult.getUpper() < 0 || multiProperty.size() < mult.getUpper()) {
		                    	if(value instanceof Collection) {
		                    		multiProperty.addAll(index, (Collection<? extends Object>) value);
		                    	} else {
		                    		multiProperty.add(index, value);
		                    	}
		                    } else {
		                        throw new ModelAdapterException("Cannot add value, property " + propertyName + " has an upper multiplicity of " + mult.getUpper());
		                    }
                		} else {
	                        throw new ModelAdapterException("Cannot add value to property " + propertyName + " with index " + index + ", when the property has " + multiProperty.size() + " elements.");
                		}
                	}
                }
            }           
        } else {
            // could be a reference instead

            // try looking up reference directly
            Reference reference = jmiHelper.getReferenceByName(mofClass, propertyName, true);
            if (reference != null && value instanceof RefObject) {
                RefObject refObjectValue = (RefObject) value;
                jmiHelperDelegate.createAssociationLink(reference, refAObject, refObjectValue, index);
            } else if (reference != null && value instanceof Collection) {
            	for (Iterator iterator = ((Collection)value).iterator(); iterator
						.hasNext();) {
					RefObject refObjectValue = (RefObject) iterator.next();
					jmiHelperDelegate.createAssociationLink(reference, refAObject, refObjectValue, index);					
				}
                
            } else {
                // could still be the passive end of an Association. 
                boolean associationFound = jmiHelperDelegate.findAssociationAndAddLink(refAObject, propertyName, value);

                if (! associationFound ) {
                    throw new ModelAdapterException("MofClass has no such property: "+ mofClass.getName() + "." + propertyName);
                }
            } 
        } // end if is attribute else try reference

    }
    
    @SuppressWarnings("unchecked")
    public void unset(RefObject refAObject, String propertyName, Object value)  throws ModelAdapterException {        
	        MofClass mofClass = (MofClass) refAObject.refMetaObject();

	        // property may either be an attribute or a reference. First checking Attribute, if not then check reference.
	        Attribute attribute = jmiHelper.getAttributeByName(mofClass, propertyName, true);
	        if (attribute != null) {

	            MultiplicityType mult = attribute.getMultiplicity();
	            if ( mult != null) {
	                if (mult.getUpper() == 1) {
	                    refAObject.refSetValue(propertyName, null);
	                } else {
	                	if(!mult.isOrdered()) {
		                    Collection<Object> multiProperty = (Collection<Object>) refAObject.refGetValue(propertyName);
		                    if (mult.getUpper() < 0 || multiProperty.size() < mult.getUpper()) {
		                    	if(value instanceof Collection) {
		                    		multiProperty.removeAll((Collection<? extends Object>) value);
		                    	} else {
		                    		multiProperty.remove(value);
		                    	}
		                    } else {
		                        throw new ModelAdapterException("Cannot add value, property " + propertyName + " has an upper multiplicity of " + mult.getUpper());
		                    }
	                	}
	                }
	            }           
	        } else {
	            // could be a reference instead

	            // try looking up reference directly
	            Reference reference = jmiHelper.getReferenceByName(mofClass, propertyName, true);
	            if (reference != null && value instanceof RefObject) {
	                RefObject refObjectValue = (RefObject) value;
	                jmiHelperDelegate.removeAssociationLink(reference, refAObject, refObjectValue);
	            } else if (reference != null && value instanceof Collection) {
	            	for (Iterator<?> iterator = ((Collection<?>)value).iterator(); iterator
							.hasNext();) {
						RefObject refObjectValue = (RefObject) iterator.next();
						jmiHelperDelegate.removeAssociationLink(reference, refAObject, refObjectValue);					
					}
	                
	            } else {
	                // could still be the passive end of an Association. 
	                AssociationBean associationFound = AdapterJMIHelper.findAssociation(refAObject, propertyName, jmiHelper);

	                if ( associationFound == null ) {
	                    throw new ModelAdapterException("MofClass has no such property: "+ mofClass.getName() + "." + propertyName);
	                } else {
	                    if(associationFound.isFirst) {
	                        if(value instanceof Collection) {
	                            for (Object obj : (Collection<?>) value) {
	                                associationFound.refAss.refRemoveLink(refAObject, (RefObject) obj);
                                    }
	                        } else {
	                            associationFound.refAss.refRemoveLink(refAObject, (RefObject) value);
	                        }
	                	
	                    } else {
	                        if(value instanceof Collection) {
    	                            for (Object obj : (Collection<?>) value) {
                                        associationFound.refAss.refRemoveLink((RefObject) obj, refAObject);
                                    }
	                        } else {
	                            associationFound.refAss.refRemoveLink((RefObject) value, refAObject);
	                        }
	                    }
	                }
	            } 
	        } // end if is attribute else try reference
		
	}


    /**
     * 
     * @param sourceModelElement
     * @param referencePropertyName
     * @param targetType
     * @param targetKeyName
     * @param targetKeyValue
     * @param contextObject - this might also be a collection of contextObjects!
     * @return
     * @throws ModelAdapterException
     * @throws ReferenceSettingException
     */
    public Object setReference(RefObject sourceModelElement,
            String referencePropertyName, List<String> targetType,
            String targetKeyName, Object targetKeyValue, Object contextObject)
    throws ModelAdapterException, ReferenceSettingException {
        Object result = null;

        if (contextObject == null) {
            // find target class with given property, assumes it is unique with that key and value 
            result = jmiHelperDelegate.findRefObjectOfType(targetType, targetKeyName, targetKeyValue);
        } else if (targetKeyName == null) {
        	//this is the case where the lookIn is actually the searched model element and no further element
        	//needs to be resolved. This occurs e.g. in LookupProperty
        	result = contextObject;
        } else {
            // need to investigate contextObject more. 
            RefObject referenceType = getMetaType(targetType);

            List<RefObject> contents = null;
            // look into immediate contents of context and look for appropriate object, and make sure it is unique
            if(contextObject instanceof Collection<?>) {
            	for (Object obj : ((Collection<?>)contextObject)) {
            		if(obj instanceof RefObject) {
            			contents = getContainedElements((RefObject) obj);
            		} else {
            			throw new ReferenceSettingException("Expected context objext either to be of type " +
                    			"Collection<RefObject>or RefObject but got:" +obj.getClass());
            		}
				}
            } else if(contextObject instanceof RefObject){
            	contents = getContainedElements((RefObject) contextObject);
            } else {
            	throw new ReferenceSettingException("Expected context objext either to be of type " +
            			"Collection<RefObject>or RefObject but got:" +contextObject.getClass());
            }
            //old and buggy:
//            contents = getContentsIncludingInherited((Namespace) contextObject);
            
            for (Iterator<RefObject> iterator = contents.iterator(); iterator.hasNext();) {
            	RefObject loopCandidateModelElement = iterator.next();


                if (instanceOf(loopCandidateModelElement, referenceType)) {
                    Object candidateFeatureValue = loopCandidateModelElement.refGetValue(targetKeyName);

                    if (candidateFeatureValue != null && candidateFeatureValue.equals(targetKeyValue)) {
                        if (result == null) {
                        	//TODO what if there is more than one result?
                        	//maybe use collection and add all results
                            result = loopCandidateModelElement;
                        } else {
                            throw new ReferenceSettingException("More than one candidate found within " + contextObject + " of type " + MessageUtil.asModelName(targetType) + " with feature " + targetKeyName + " equals " + targetKeyValue);
                        }
                    }
                }
            }
        }
//      }
        // create link
        if (result != null) {
            set(sourceModelElement, referencePropertyName, result);
        }

        return result;
    }
    
    
    /**
     * @param contextObject
     * @return
     */
    private List<RefObject> getContainedElements(
            RefObject contextObject) {
    	//TODO here all composite contents of the given contextobject have to be resolved somehow.
    	//maybe this can be done using an mql query?
    	//TODO this needs to be extended by those associations that do not have a reference
    	//but are also defined as composite associations
    	List<RefObject> allContents = new ArrayList<RefObject>();
    	for (ModelElement element : getContentsIncludingInherited((MofClass)contextObject.refMetaObject())) {
			if(element instanceof Reference &&
					((Reference) element).getExposedEnd().getAggregation().equals(AggregationKindEnum.COMPOSITE)) {
				Object result = contextObject.refGetValue(element);
				if(result instanceof Collection<?>) {
				    for (Object o : (Collection<?>) result) {
					allContents.add((RefObject) o);
				    }
				} else {
					allContents.add((RefObject) result);
				}				
			}
		}
    	
    	return allContents;
    }
    
    /**
     * @param contextObject
     * @return
     */
    private List<ModelElement> getContentsIncludingInherited(
            Namespace contextObject) {
        List<ModelElement> result = new ArrayList<ModelElement>();
        
        List<ModelElement> contents = contextObject.getContents();        
        result.addAll(contents);
        if (contextObject instanceof GeneralizableElement) {
            GeneralizableElement generalizable = (GeneralizableElement) contextObject;
            List<GeneralizableElement> superList = jmiHelper.getAllSupertypes(generalizable);
            for (Iterator<GeneralizableElement> iterator = superList.iterator(); iterator.hasNext();) {
                GeneralizableElement superType = iterator.next();
                
                List<ModelElement> supercontents = superType.getContents(); 
                result.addAll(supercontents);
            }
        }        
        
        return result;
    }

    /**
     * @param type
     * @return
     */
    public RefObject[] getElementsOfType(String type) {
        return jmiHelperDelegate.getElementsOfType(type);
    }
    

    /**
     * @throws ModelAdapterException 
     * 
     */
    public Map<Object, Object> performAllDeferredActions() throws DeferredActionResolvingException {
        
        List<DeferredModelElementCreationException> exceptions = new ArrayList<DeferredModelElementCreationException>();
        for (Iterator<StructureTypeMockObject> iterator = structureTypeMocks.iterator(); iterator.hasNext();) {
            StructureTypeMockObject mock = iterator.next();
            if (mock2ModelElementMap.containsKey(mock)) {
                continue; // mock already resolved earlier, e.g. in set()
	    }
	    Object realModelElement = jmiHelperDelegate.actualCreateFromMock(mock);
	    mock2ModelElementMap.put(mock, realModelElement);
	    if (exceptions.size() > 0) {
                DeferredActionResolvingException exception = new DeferredActionResolvingException(exceptions.size() + " deferred actions failed", exceptions);
                throw exception;
            }
        }
        return mock2ModelElementMap;
    }

    /**
     * @return
     */
    public boolean hasDeferredActions() {
        return (structureTypeMocks != null && structureTypeMocks.size() > 0 );
    }

    public static final String OCL_QUERY_PREFIX = "OCL:";
    
    /**
     * @param referencePropertyName
     * @param keyValue 
     * @param oclQuery
     * @param contextObject 
     * @param foreachObject TODO
     * @param refObject
     * @return
     * @throws ModelAdapterException 
     */
    public Object setQueriedReference(RefObject sourceModelElement,
            String referencePropertyName, Object keyValue, String oclQuery, Object contextObject, Object foreachObject) throws ModelAdapterException, ReferenceSettingException {
        
        if (keyValue instanceof RefObject || keyValue instanceof StructureTypeMockObject) {
            //TODO what if the property is not a string??
            throw new ReferenceSettingException("Queries by non-primitive References not possible: " + oclQuery);
        }
        
    	Object refObject = null;
    	if(oclQuery.startsWith(OCL_QUERY_PREFIX)) {
    		refObject = jmiHelperDelegate.findElementWithOCLQuery(sourceModelElement, 
    				referencePropertyName, keyValue, oclQuery.substring(OCL_QUERY_PREFIX.length()), contextObject, foreachObject);
    	} else {
    	    	refObject = jmiHelperDelegate.findElementWithOCLQuery(sourceModelElement, 
			referencePropertyName, keyValue, oclQuery, contextObject, foreachObject);
    	}
        
        // create link
        if (refObject != null) {
            set(sourceModelElement, referencePropertyName, refObject);
        }

        return refObject;
    }
    
    public Collection<?> getOclEvaluation(RefObject sourceModelElement,
            String referencePropertyName, Object keyValue, String oclQuery, Object contextObject) throws ModelAdapterException, ReferenceSettingException {
        
        if (keyValue instanceof RefObject || keyValue instanceof StructureTypeMockObject) {
            //TODO what if the property is not a string??
            throw new ReferenceSettingException("Queries by non-primitive References not possible: " + oclQuery);
        }
        
        Collection<?> refObject = null;
    	if(oclQuery.startsWith(OCL_QUERY_PREFIX)) {
    		refObject = jmiHelperDelegate.findElementsWithOCLQuery(sourceModelElement, 
    				referencePropertyName, keyValue, oclQuery.substring(OCL_QUERY_PREFIX.length()), contextObject);
    	} else {
    		throw new ReferenceSettingException("Query needs to be prefixed with '"+OCL_QUERY_PREFIX+"'");
    	}
        
        return refObject;
    }

    /**
     * @param typeName
     * @return
     * @throws ModelAdapterException 
     */
    public MofClass getMetaType(List<String> typeName) throws ModelAdapterException {
        MofClass mofClass = jmiHelperDelegate.getMofClass(typeName);
        return mofClass;
    }

    /**
     * @param typeName
     * @param attributes 
     * @return
     */
    public Collection<Object> queryElement(List<String> typeName, Map<String, List<Object>> attributes) {

//        Map<String, Collection<?>> multiValuedAttributesMap = new HashMap<String, Collection<?>>();
        Map<String, Object> singleValuedAttributesMap = new HashMap<String, Object>();
        Map<String, Partitionable> partitionableReferenceValuedAttributesMap = new HashMap<String, Partitionable>();
        Set<String> featureNames = attributes.keySet();
        for (Iterator<String> iterator = featureNames.iterator(); iterator.hasNext();) {
            String featureName = iterator.next();
            List<Object> value = attributes.get(featureName);
            if (value != null && value.size() > 0) {
                if (value.size() > 1) {
                    // TODO (maybe merely discard for now?)
                    throw new RuntimeException("Resolution by multi-valued attributes not possible.");
                    //multiValuedAttributesMap.put(featureName, value);
                } else {
                    Object valueitem = value.get(0);
                    if(valueitem instanceof IModelElementProxy ) {
                	valueitem = ((IModelElementProxy)valueitem).getRealObject();
                    }
		    if (valueitem instanceof Partitionable ) {
                        partitionableReferenceValuedAttributesMap.put(featureName, (Partitionable) valueitem);
                    } else {
                        // TODO validate attributes map (primitives or list of primitives of suitable type in map)
                        singleValuedAttributesMap.put(featureName, valueitem);
                    }
                }
            }
        }
        return jmiHelperDelegate.queryElement(typeName, partitionableReferenceValuedAttributesMap, singleValuedAttributesMap/*, multiValuedAttributesMap*/);
    }

    
}
