/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: UMLEvaluationEnvironment.java,v 1.2 2007/03/22 21:59:20 cdamus Exp $
 */

package org.eclipse.ocl.uml;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.ocl.AbstractEvaluationEnvironment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.LazyExtentMap;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.uml.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.uml.util.OCLUMLUtil;
import org.eclipse.ocl.util.CollectionUtil;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralNull;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLSwitch;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Implementation of the {@link EvaluationEnvironment} for evaluation of
 * OCL expressions on instances of UML models (i.e., on M0 models).
 * 
 * @author Christian W. Damus (cdamus)
 */
public class UMLEvaluationEnvironment
		extends AbstractEvaluationEnvironment<Classifier, Operation, Property, Class, EObject> {

	private static final EPackage CACHE_MISS = EcoreFactory.eINSTANCE.createEPackage();
	
	private final EPackage.Registry registry;
	
    // cache of UML to Ecore package mappings
    private final Map<Package, EPackage> packageMap = new java.util.HashMap<Package, EPackage>();
    private final UMLEnvironmentFactory factory;
    
    private ValueExtractor valueExtractor;
    
    /**
     * Initializes me.
     */
    public UMLEvaluationEnvironment(UMLEnvironmentFactory factory) {
        this.factory = factory;
        this.registry = factory.getEPackageRegistry();
    }
    
    /**
     * Initializes me with my parent evaluation environment (nesting scope).
     * 
     * @param parent my parent (nesting scope); must not be <code>null</code>
     */
    public UMLEvaluationEnvironment(
    		EvaluationEnvironment<Classifier, Operation, Property, Class, EObject> parent) {
    	super(parent);
        
        UMLEvaluationEnvironment umlParent = (UMLEvaluationEnvironment) getParent();
        
        this.factory = umlParent.factory;
    	this.registry = umlParent.getEPackageRegistry();
    }

    /**
     * Obtains my package registry for looking up the Ecore definitions of
     * UML packages.
     * 
     * @return my package registry
     */
    protected final EPackage.Registry getEPackageRegistry() {
    	return registry;
    }
    
    // implements the inherited specification
	protected Method getJavaMethodFor(Operation operation, Object receiver) {
		Method result = null;

		// in the case of infix operators, we need to replace the name with
		//    a valid Java name.  We will choose the legacy OCL parser names
		//    which some clients already depend on
		String operName = operation.getName();
		int opcode = OCLStandardLibraryUtil.getOperationCode(operName);
		switch (opcode) {
		case PredefinedType.PLUS:
			operName = "plus"; //$NON-NLS-1$
			break;
		case PredefinedType.MINUS:
			operName = "minus"; //$NON-NLS-1$
			break;
		case PredefinedType.TIMES:
			operName = "times"; //$NON-NLS-1$
			break;
		case PredefinedType.DIVIDE:
			operName = "divide"; //$NON-NLS-1$
			break;
		case PredefinedType.LESS_THAN:
			operName = "lessThan"; //$NON-NLS-1$
			break;
		case PredefinedType.LESS_THAN_EQUAL:
			operName = "lessThanEqual"; //$NON-NLS-1$
			break;
		case PredefinedType.GREATER_THAN:
			operName = "greaterThan"; //$NON-NLS-1$
			break;
		case PredefinedType.GREATER_THAN_EQUAL:
			operName = "greaterThanEqual"; //$NON-NLS-1$
			break;
		}
		
		// get containing class for the operation
		Classifier container = (Classifier) operation.getOwner();

		// get the corresponding Ecore classifier
		EClassifier eclassifier = getEClassifier(container, receiver);
		
		// get the corresponding java instance class
		java.lang.Class<?> containerClass = eclassifier.getInstanceClass();

		// get the parameter types as java classes
		EList<Parameter> parms = operation.getOwnedParameters();
		EList<java.lang.Class<?>> javaParms = new BasicEList<java.lang.Class<?>>(parms.size());
		for (int i = 0, n = parms.size(); i < n; i++) {
			Parameter parm = parms.get(i);
			
			if (parm.getDirection() != ParameterDirectionKind.RETURN_LITERAL) {
				if (parm.isMultivalued()) {
					javaParms.add(EList.class); // TODO: EList could be suppressed
				} else {
					eclassifier = getEClassifier(
							(Classifier) parm.getType(),
							receiver);
					javaParms.add(eclassifier.getInstanceClass());
				}
			}
		}

		// lookup the method on the java class
		try {
			result = containerClass.getMethod(
					operName,
					javaParms.toArray(new java.lang.Class<?>[javaParms.size()]));
		} catch (NoSuchMethodException e) {
			//do nothing
		}

		return result;
	}
	
    // implements the inherited specification
	@Override
	protected Object getInvalidResult() {
		return OCLStandardLibraryImpl.OCL_INVALID;
	}
    
    // implements the inherited specification
    public Object navigateProperty(Property property, List<?> qualifiers, Object source)
    	throws IllegalArgumentException {
    	
    	if (source instanceof InstanceSpecification) {
    	    // TODO: In case there is no slot, look for an init constraint
            //     and a default value, in that order
    		InstanceSpecification instance = (InstanceSpecification) source;
    		
    		for (Slot slot : instance.getSlots()) {
    			if (slot.getDefiningFeature() == property) {
    				if (!qualifiers.isEmpty()) {
    					return findValueQualifiedBy(instance, property, qualifiers);
    				}
    				
    				return getValue(slot);
    			}
    		}
            
            // look for a slot on a property that redefines the property
            //    we are looking for
            for (Slot slot : instance.getSlots()) {
                if (redefines(slot.getDefiningFeature(), property)) {
                    if (!qualifiers.isEmpty()) {
                        return findValueQualifiedBy(instance, property, qualifiers);
                    }
                    
                    return getValue(slot);
                }
            }
    		
    		// an instance needs not have a slot for every feature
    		return isMultivaluedSlot(instance, property)?
    				CollectionUtil.createNewCollection(
    						CollectionKind.getKind(
    								property.isOrdered(),
    								property.isUnique()))
    					: null;
    	} else if (source instanceof EObject) {
            // TODO: In case the property is unset, look for an init constraint
            //     and a default value, in that order
    		EObject esource = (EObject) source;
    		
    		EStructuralFeature feature = esource.eClass().getEStructuralFeature(
    				property.getName());
    		
    		if (feature != null) {
    			Object result = esource.eGet(feature);
    			
    			if (property.getType() instanceof Enumeration) {
    				result = convertEnumerationValue(
    						(Enumeration) property.getType(),
    						result);
    			}
    			
    			return result;
    		}
    	}
    	
    	throw new IllegalArgumentException(
    			"no such property: " + property.getName()); //$NON-NLS-1$
    }
    
    /**
     * Queries whether the specified property redefines (recursively) another
     * property.
     * 
     * @param feature a property
     * @param redefined a property that (we hope) it redefines
     * 
     * @return <code>true</code> if the feature redefines the redefined
     *     property (or some property that, recursively, redefines it);
     *     <code>false</code>, otherwise
     */
    private boolean redefines(StructuralFeature feature, Property redefined) {
        if (feature == redefined) {
            // base case
            return true;
        }
        
        if (feature instanceof Property) {
            Property property = (Property) feature;
            
            for (Property next : property.getRedefinedProperties()) {
                if (redefines(next, redefined)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     * Gets the Java value in an instance's slot.
     * 
     * @param slot a slot
     * @return the value in the slot, as a Java object
     *      (not a {@link ValueSpecification})
     */
    private Object getValue(Slot slot) {
		List<ValueSpecification> values = slot.getValues();
		
		if (isMultivaluedSlot(slot)) {
            StructuralFeature feature = slot.getDefiningFeature();
            
            // create a collection of the kind appropriate to the feature.
            //   If the feature is ordered, then the order of the values in
            //   the slot is preserved
			return getValueExtractor().extractValues(
                values,
                CollectionKind.getKind(feature.isOrdered(), feature.isUnique()));
		} else {
			return values.isEmpty()? null :
				getValueExtractor().extractValue(values.get(0));
		}
    }
    
    /**
     * Queries whether an instance's slot is multivalued.  This depends on the
     * owner, because a member-end slot of an association class link has
     * multiplicity 1 regardless of the multiplicity of the slot's defining
     * property.
     * 
     * @param slot a slot
     * @return whether the slot is multi-valued from the perspective of its
     *    owner's type
     */
    private boolean isMultivaluedSlot(Slot slot) {
    	return isMultivaluedSlot(
    			slot.getOwningInstance(),
    			(Property) slot.getDefiningFeature());
    }
    
    private boolean isMultivaluedSlot(InstanceSpecification owner, Property property) {
    	Classifier classifier = owner.getClassifiers().isEmpty()?
    			null : owner.getClassifiers().get(0);
    	
    	if (classifier instanceof Association) {
    		return (property.getAssociation() != classifier)
    			&& property.isMultivalued();
    	}
    	
    	return property.isMultivalued();
    }
    
    /**
     * Converts enumeration literal values in the Ecore definition of an
     * enumeration to the corresponding UML literal specification.
     * 
     * @param enumType the type of the expected enumeration literal(s)
     * @param value an enumeration literal or some collection of literals in
     *    the case of a multivalued attribute, as the Ecore definition of the
     *    enumeration literal(s)
     * @return the corresponding UML definition of the enumeration literal(s)
     */
    private Object convertEnumerationValue(Enumeration enumType, Object value) {
    	Object result;
    	
    	if (value instanceof Enumerator) {
    		result = enumType.getOwnedLiteral(((Enumerator) value).getName());
    	} else if (value instanceof Collection) {
    		@SuppressWarnings("unchecked")
    		Collection<Enumerator> coll = (Collection<Enumerator>) value;
    		
    		// create a collection of the same kind
    		Collection<EnumerationLiteral> newColl =
    			CollectionUtil.createNewCollectionOfSameKind(coll);
    		
    		for (Enumerator e : coll) {
    			newColl.add(enumType.getOwnedLiteral(e.getName()));
    		}
    		
    		result = newColl;
    	} else {
    		result = value;
    	}
    	
    	return result;
    }
    
    private ValueExtractor getValueExtractor() {
    	if (valueExtractor == null) {
    		valueExtractor = new ValueExtractor();
    	}
    	
    	return valueExtractor;
    }
    
    Object findValueQualifiedBy(InstanceSpecification source, Property property, List<?> qualifiers) {
    	// from amongst the links referencing this source instance, find the
    	//   one that has the specified qualifier values and get its value for
    	//   the property
    	Association association = property.getAssociation();
    	Property otherEnd = property.getOtherEnd();
    	
    	for (EStructuralFeature.Setting setting :
    			UMLUtil.getNonNavigableInverseReferences(source)) {
    		
    		if (setting.getEStructuralFeature() ==
    				UMLPackage.Literals.INSTANCE_VALUE__INSTANCE) {
    			
    			InstanceValue value = (InstanceValue) setting.getEObject();
    			if (value.getOwner() instanceof Slot) {
    				Slot slot = (Slot) value.getOwner();
    				
    				// TODO: Account for redefinition of the member ends
    				if (slot.getDefiningFeature() == otherEnd) {
    					InstanceSpecification link = slot.getOwningInstance();
    					
    					for (Classifier c : link.getClassifiers()) {
    						if (c.conformsTo(association)) {
    							// found a link instance of this association.
    							//   Look for the qualifier values
    							if (match(link, property.getQualifiers(), qualifiers)) {
    								// get the property value for this link
    								return navigateProperty(
    										property,
    										Collections.emptyList(),
    										link);
    							}
    							
    						}
    					}
    				}
    			}
    		}
    	}
    	
    	return null;
    }
    
    /**
     * Queries whether the specified <code>instance</code> has slots for the
     * given <code>properties</code> that have these <code>values</code>.
     * 
     * @param instance an instance specification
     * @param properties a list of properties
     * @param values values to look for in the slots of the instance defined by
     *     the given properties
     *     
     * @return <code>true</code> if this instance has the matching property
     *     values; <code>false</code>, otherwise
     */
    private boolean match(
    		InstanceSpecification instance,
    		List<Property> properties,
    		List<?> values) {
    	
    	int found = 0;
    	
    	for (Slot slot : instance.getSlots()) {
    		int index = properties.indexOf(slot.getDefiningFeature());
    		
    		if (index >= 0) {
    			Object actualValue = getValue(slot);
    			
    			if (UMLUtil.safeEquals(actualValue, values.get(index))) {
    				found++;
    			}
    		}
    	}
    	
    	return found == properties.size();
    }

    // implements the inherited specification
    public Object navigateAssociationClass(
    		Classifier associationClass,
    		Property navigationSource,
    		Object source)
    		throws IllegalArgumentException {

    	if (source instanceof InstanceSpecification) {
       		InstanceSpecification sourceInstance = (InstanceSpecification) source;
       		
       		Collection<Property> ends;
       		if (navigationSource != null) {
       			// qualified navigation:  select the links belonging to the
       			//   the navigation source, i.e., where the opposite of the
       			//   navigation source references the source instance
       			ends = Collections.singleton(navigationSource.getOtherEnd());
       		} else {
       			// unqualified navigation:  select links where either end is
       			//   the navigation source
       			ends = ((AssociationClass) associationClass).getMemberEnds();
       		}
       		
       		// find link instances of this association class that have a slot
       		//   referencing the source instance
        	Collection<InstanceSpecification> links = CollectionUtil.createNewSet();
        	
        	for (EStructuralFeature.Setting setting :
        			UMLUtil.getNonNavigableInverseReferences(sourceInstance)) {
        		
        		if (setting.getEStructuralFeature()
        				== UMLPackage.Literals.INSTANCE_VALUE__INSTANCE) {
        			
        			InstanceValue value = (InstanceValue) setting.getEObject();
        			if (value.getOwner() instanceof Slot) {
        				Slot slot = (Slot) value.getOwner();
        				
        				// only consider slots that are defined by association
        				//    ends, because the association class may have other
        				//    properties can reference our source instance
        				// TODO: Account for redefinition of the member ends
        				if (ends.contains(slot.getDefiningFeature())) {
        					InstanceSpecification link = slot.getOwningInstance();
        					
        					for (Classifier c : link.getClassifiers()) {
        						if (c.conformsTo(associationClass)) {
        							// found a link!
        							links.add(link);
        							break;
        						}
        					}
        				}
        			}
        		}
        	}
        	
        	// these association class instances are the answer.  If we know the
        	//   navigation source and it is not many, then do not return a
        	//   collection value
        	if ((navigationSource != null) && !navigationSource.isMultivalued()) {
        		return links.isEmpty()? null : links.iterator().next();
        	}
        	
        	return links;
       	} else if (source instanceof EObject) {
    		// UML-to-Ecore conversion does not support association classes
    	}
    	
    	throw new IllegalArgumentException(
    			"no such association class: " + associationClass.getName()); //$NON-NLS-1$
	}
    
    // implements the inherited specification
    public Tuple<Operation, Property> createTuple(
    		Classifier type, Map<Property, Object> values) {
    	
    	@SuppressWarnings("unchecked")
    	TupleType<Operation, Property> tupleType =
    		(TupleType<Operation, Property>) type;
    	
    	return new TupleImpl(tupleType, values);
    }
	
    // implements the inherited specification
	public Map<Class, Set<EObject>> createExtentMap(Object object) {
		if (object instanceof InstanceSpecification) {
			return new LazyExtentMap<Class, EObject>((EObject) object) {
                // implements the inherited specification
				@Override
				protected boolean isInstance(Class cls, EObject element) {
					boolean result = false;
					
					if (element instanceof InstanceSpecification) {
						EList<Classifier> classifiers =
							((InstanceSpecification) element).getClassifiers();
						
						for (Classifier c : classifiers) {
							if (c.conformsTo(cls)) {
								result = true;
								break;
							}
						}
					}
					
					return result;
				}};
		} else if (object instanceof EObject) {
			return new LazyExtentMap<Class, EObject>((EObject) object) {
                // implements the inherited specification
				@Override
				protected boolean isInstance(Class cls, EObject element) {
					EClassifier eclass = getEClassifier(cls, element);
					
					return (eclass != null) && eclass.isInstance(element);
				}};
		}
		
		return Collections.emptyMap();
	}

    // implements the inherited specification
	public boolean isKindOf(Object object, Classifier classifier) {
		if (object instanceof ValueSpecification) {
			ValueSpecification value = (ValueSpecification) object;
			
			if (value.getType() != null) {
				Classifier type = (Classifier) value.getType();
				
				// special case for Integer/UnlimitedNatural and Real
                //   which are not related types in java but are in OCL
				if ((type == OCLStandardLibraryImpl.INSTANCE.getInteger())
						&& (classifier == OCLStandardLibraryImpl.INSTANCE.getReal())) {
					return true;
				}
				
				return type.conformsTo(classifier);
			}
		} else if (object instanceof InstanceSpecification) {
			InstanceSpecification instance = (InstanceSpecification) object;
			
			for (Classifier c : instance.getClassifiers()) {
				if (c.conformsTo(classifier)) {
					return true;
				}
			}
		} else if (object instanceof EObject) {
            // special case for Integer/UnlimitedNatural and Real
            //   which are not related types in java but are in OCL
			EClassifier eclassifier = getEClassifier(classifier, object);
			
			if (eclassifier == null) {
				return false;
			}
			
			if ((object.getClass() == Integer.class)
					&& (eclassifier.getInstanceClass() == Double.class)) {
				return Boolean.TRUE;
			}
			
			return eclassifier.isInstance(object);
		}
		
		return false;
	}
    
    // implements the inherited specification
	public boolean isTypeOf(Object object, Classifier classifier) {
		if (object instanceof ValueSpecification) {
			ValueSpecification value = (ValueSpecification) object;
			
			return value.getType() == classifier;
		} else if (object instanceof InstanceSpecification) {
			return ((InstanceSpecification) object).getClassifiers().contains(
					classifier);
		} else if (object instanceof EObject) {
			EClassifier eclassifier = getEClassifier(classifier, object);
			
			if (eclassifier == null) {
				return false;
			}
			
			if (classifier instanceof EClass && object instanceof EObject) {
				return ((EObject) object).eClass() == eclassifier;
			} else if (!(object instanceof EObject) && !(eclassifier instanceof EClass)) {
				return object.getClass() == eclassifier.getInstanceClass();
			}
		}
		
		return false;
	}
    
    public Classifier getType(Object object) {
        return factory.getClassifier(object);
    }
	
    /**
     * Looks up the Ecore definition of the specified UML package.
     * 
     * @param pkg a UML package
     * @return its Ecore definition, or <code>null</code> if not found
     */
	protected EPackage getEPackage(Package pkg) {
		EPackage result = packageMap.get(pkg);
		
		if (result == null) {
			result = OCLUMLUtil.getEPackage(pkg, registry);
			
			if (result == null) {
				result = CACHE_MISS;
			}
			
			packageMap.put(pkg, result);
		}
		
		return (result == CACHE_MISS)? null : result;
	}
	
    /**
     * Looks up the Ecore definition of the specified UML classifier, using the
     * specified <code>element</code> as a context for finding profile
     * applications in the case that the classifier is a stereotype or some
     * other type in a {@link Profile}.  Finding the Ecore definition of a profile
     * type requires finding the actual applied version of the profile.
     * 
     * @param umlClassifier a UML classifier
     * @param element an element in the context of which the OCL evaluation
     *     is being performed
     * @return the corresponding Ecore classifier, or <code>null</code> if not
     *     found
     */
	protected EClassifier getEClassifier(Classifier umlClassifier, Object element) {
		EClassifier result = null;
		Package umlPackage = umlClassifier.getPackage();
		EPackage ecorePackage = null;
		
		if (umlPackage instanceof Profile) {
			// use the element to get the most appropriate profile definition
			Profile profile = (Profile) umlPackage;
			
			if (element instanceof Element) {
				Element umlElement = (Element) element;
				
				Package nesting = umlElement.getNearestPackage();
				while (nesting != null) {
					ProfileApplication appl = nesting.getProfileApplication(profile);
					if (appl != null) {
						ecorePackage = appl.getAppliedDefinition();
						break;
					}
					
					nesting = nesting.getNearestPackage();
				}
			}
			
			if (ecorePackage == null) {
				// assume the latest definition of the profile (if any)
				ecorePackage = profile.getDefinition();
			}
		} else if (umlPackage != null) {
			ecorePackage = getEPackage(umlPackage);
		}
		
		if (ecorePackage != null) {
			result = ecorePackage.getEClassifier(
					UMLUtil.getValidJavaIdentifier(umlClassifier.getName()));
		}
		
		return result;
	}
	
    /**
     * UML implementation of a tuple value.
     * 
     * @author Christian W. Damus (cdamus)
     */
	static class TupleImpl implements Tuple<Operation, Property> {
		private final TupleType<Operation, Property> type;
		private final Map<String, Object> parts =
			new java.util.HashMap<String, Object>();
		
        /**
         * Initializes me with a map of part values.
         * 
         * @param type my type
         * @param values my parts
         */
		TupleImpl(TupleType<Operation, Property> type,
				Map<Property, Object> values) {
			this.type = type;
			
			for (Map.Entry<Property, Object> entry : values.entrySet()) {
				parts.put(entry.getKey().getName(), entry.getValue());
			}
		}
		
        // implements the inherited specification
		public TupleType<Operation, Property> getTupleType() {
			return type;
		}

        // implements the inherited specification
		public Object getValue(String partName) {
			return parts.get(partName);
		}

        // implements the inherited specification
		public Object getValue(Property part) {
			return getValue(part.getName());
		}
		
        // overrides the inherited implementation
		@Override
		public boolean equals(Object o) {
			boolean result = o instanceof TupleImpl;
			
			if (result) {
				TupleImpl other = (TupleImpl) o;
			
				result &= other.type.equals(type);
				result &= other.parts.equals(parts);
			}
			
			return result;
		}
		
        // overrides the inherited implementation
		@Override
		public int hashCode() {
			return 37 * type.hashCode() + 17 * parts.hashCode();
		}
	}
	
    /**
     * A converter of UML value specifications to OCL (Java) values.
     * 
     * @author Christian W. Damus (cdamus)
     */
	class ValueExtractor extends UMLSwitch<Object> {
		@Override
		public Object caseLiteralBoolean(LiteralBoolean object) {
			return Boolean.valueOf(object.booleanValue());
		}
		
		@Override
		public Object caseLiteralInteger(LiteralInteger object) {
			return new Integer(object.integerValue());
		}
		
		@Override
		public Object caseLiteralNull(LiteralNull object) {
			return null;
		}
		
		@Override
		public Object caseLiteralString(LiteralString object) {
			return object.stringValue();
		}
		
		@Override
		public Object caseLiteralUnlimitedNatural(LiteralUnlimitedNatural object) {
			return new Integer(object.unlimitedValue());
		}
		
		@Override
		public Object caseInstanceValue(InstanceValue object) {
			return object.getInstance();
		}
		
		@Override
		public Object caseValueSpecification(ValueSpecification object) {
			// the default case is a value specification that we don't understand
			return OCLStandardLibraryImpl.OCL_INVALID;
		}
		
        /**
         * Converts the specified collection of UML values to a collection of
         * OCL values.
         * 
         * @param values UML values
         * @return the corresponding OCL values
         */
		Collection<?> extractValues(
                Collection<? extends ValueSpecification> values,
                CollectionKind collectionKind) {
			Collection<Object> result =
				CollectionUtil.createNewCollection(collectionKind);
			
			for (ValueSpecification value : values) {
				result.add(extractValue(value));
			}
			
			return result;
		}
		
        /**
         * Converts the specified UML values to an OCL value.
         * 
         * @param values a UML value
         * @return the corresponding OCL value
         */
		Object extractValue(ValueSpecification value) {
			return doSwitch(value);
		}
	}
}