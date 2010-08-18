package ocljmi;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.EnumLiteral;
import org.oslo.ocl20.semantics.bridge.ModelElement;
import org.oslo.ocl20.semantics.bridge.OclModelElementType;
import org.oslo.ocl20.semantics.bridge.Property;
import org.oslo.ocl20.semantics.model.types.BooleanType;
import org.oslo.ocl20.standard.lib.OclAny;
import org.oslo.ocl20.standard.lib.OclAnyModelElement;
import org.oslo.ocl20.standard.lib.OclEnumeration;
import org.oslo.ocl20.standard.lib.OclSet;
import org.oslo.ocl20.standard.lib.OclType;
import org.oslo.ocl20.standard.lib.OclUndefined;
import org.oslo.ocl20.synthesis.ModelEvaluationAdapter;

import uk.ac.kent.cs.kmf.util.ILog;



/**
 * @author dha
 * 
 */
public class JmiEvaluationAdapter implements ModelEvaluationAdapter {
	protected OclProcessor processor;

	public JmiEvaluationAdapter(OclProcessor proc) {
		this.processor = proc;
	}

	// -- For Code Generation ---

	public String getGetterName(Property property) {
		String name = property.getName();
		Classifier type = property.getType();
		String upperName = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
		// Class x = (Class)type.getDelegate();
		if (type instanceof BooleanType) {
			return "is" + upperName;
		} else {
			return "get" + upperName;
		}

	}

	public String getSetterName(Property property) {
		return null;
	}

	// --- For Evaluation ---

	public Object getEnumLiteralValue(EnumLiteral enumLit) {

		// return ((MediniEnumLiteralImpl) enumLit).getInstance();
		// return new OclEnumerationImpl(enumLit.getEnumeration(), ((EnumLiteralImpl)enumLit)._eenumLit.getInstance(), processor.getStdLibAdapter());
		// return ((EnumLiteralImpl)enumLit)._eenumLit.getInstance();
		return ((EnumLiteralImpl) enumLit).getInstance();
	}

	// Model element
	public boolean OclModelElement_equalTo(OclAny o1, OclAny o2) {
		if (o1 == null && o2 == null) {
			return true;
		}
		if (o1 == null || o2 == null) {
			return false;
		}

		Object obj1 = o1.asJavaObject();
		Object obj2 = o2.asJavaObject();
		if (obj1 instanceof EObject &&
				obj2 instanceof EObject &&
				((EObject) obj1).refMofId() != null &&
				((EObject) obj2).refMofId() != null) {
			if (obj1 != null) {
				return (((EObject) obj1).refMofId()).equals(((EObject) obj2).refMofId());
			}
		}
		return obj1.equals(obj2);
	}

	public boolean OclModelElement_oclIsNew(OclAny o1) {
		return false;
	}

	public boolean OclModelElement_oclIsUndefined(OclAny o1) {
		return o1 == null || o1 instanceof OclUndefined;
	}

	public Object OclModelElement_oclAsType(OclAny o1, OclType o2) {
		return o1;
	}

	public boolean OclModelElement_oclIsTypeOf(OclAny o1, OclType type) {
		if (type.asJavaObject() instanceof OclModelElementType != o1.asJavaObject() instanceof EObject) {
			return false;
		}
		if (!(type.asJavaObject() instanceof OclModelElementType)) {
			// handle primitive types, see medini adapter
			OclType oclTypeOfTheObject = o1.oclType();
			Classifier classifierOfTheObject = (Classifier) oclTypeOfTheObject.asJavaObject();
			Classifier classifierToCompareTo = (Classifier) type.asJavaObject();
			return classifierToCompareTo.equals(classifierOfTheObject);
		}
		OclType oclTypeOfTheObject = o1.oclType();
		Classifier classifierOfTheObject = (Classifier) oclTypeOfTheObject.asJavaObject();
		Classifier classifierToCompareTo = (Classifier) type.asJavaObject();
		return classifierOfTheObject.conformsTo(classifierToCompareTo).booleanValue() && classifierToCompareTo.conformsTo(classifierOfTheObject).booleanValue();
	}

	public boolean OclModelElement_oclIsKindOf(OclAny o1, OclType type) {
		OclType oclTypeOfTheObject = o1.oclType();
		Classifier classifierOfTheObject = (Classifier) oclTypeOfTheObject.asJavaObject();
		Classifier classifierToCompareTo = (Classifier) type.asJavaObject();
		return classifierOfTheObject.conformsTo(classifierToCompareTo).booleanValue();
		/*
		 * if ((type.asJavaObject() instanceof OclModelElementType)!=(o1.asJavaObject() instanceof EObject)) { return false; } if (!(type.asJavaObject() instanceof
		 * OclModelElementType)) { //handle primitive types, see medini adapter OclType oclTypeOfTheObject = o1.oclType(); Classifier classifierOfTheObject = (Classifier)
		 * oclTypeOfTheObject.asJavaObject(); Classifier classifierToCompareTo = (Classifier) type.asJavaObject(); return
		 * (classifierOfTheObject.conformsTo(classifierToCompareTo)).booleanValue(); } EClass cObj = ((EObject)o1.asJavaObject()).eClass(); Class cType =
		 * (Class)((OclModelElementType)type.asJavaObject()).getDelegate(); return cType.isAssignableFrom(cObj.getInstanceClass());
		 */
	}

	// public OclSet OclType_allInstances(OclType self) {
	// OclModelElementType InstanceName =
	// (OclModelElementType)self.asJavaObject();
	// EClass InstanceTyp = (EClass)
	// ((OclModelElementTypeImpl)self.asJavaObject()).getImplementation();
	// List InstancesList = new ArrayList();
	//        
	// // [HEINI]
	//        
	// RuntimeEnvironment renv = this.processor.getRuntimeEnvironment();
	//        
	// EObject eobject = (EObject)renv.getValue("self");
	// TreeIterator iter = eobject.eResource().getAllContents();
	// while (iter.hasNext())
	// {
	// EObject content = (EObject)iter.next();
	// if (content.getClass().getName().equals(InstanceTyp.getName()))
	// {
	// if (!(InstancesList.contains(content)))
	// {
	// InstancesList.add(content);
	//                    
	// }
	// }
	//            
	// if (InstanceTyp.isSuperTypeOf(content.eClass()))
	// {
	// if (!(InstancesList.contains(content)))
	// {
	// InstancesList.add(content);
	//                    
	// }
	// }
	// }
	// //findInstances(InstanceName.getName(),eobject);
	//        
	// OclSet set=this.processor.getStdLibAdapter().Collection(
	// (Collection) InstancesList).asSet();
	// //list_.clear();
	// //visit_list_.clear();
	// return set;
	// /*return null;*/
	// }

	public OclSet OclType_allInstances(OclType self) {
		return this.internalAllInstances(self, new HashSet(this.processor.getModelsForAllInstances()));
	}

	public OclSet OclType_allInstances(OclType self, Collection models) {
		return this.internalAllInstances(self, models);
	}

	/**
	 * Calculates allInstances() for type <code>type</code> for the models <code>resources</code>
	 * 
	 * @param type
	 * @param resources
	 *            collection of {@link Resource} instances
	 * @return aggregation of allInstances() over given models
	 */
	private OclSet internalAllInstances(OclType type, Collection resources) {
		OclModelElementTypeImpl oclModelElementTypeImpl = (OclModelElementTypeImpl) type.asJavaObject();
		EClass instanceTyp = (EClass) oclModelElementTypeImpl.getImplementation();
		//******************************************
		EClass instanceRefClass = getRefClass(instanceTyp);// TODO getRefClass Spaeter
//**********************************
		LinkedHashSet instancesList = new LinkedHashSet();

//		for (Iterator iter = resources.iterator(); iter.hasNext();) {
//			Resource currentResource = (Resource) iter.next();
//			TreeIterator treeIterator = currentResource.getAllContents();
//			while (treeIterator.hasNext()) {
//				EObject content = (EObject) treeIterator.next();
//				if (instanceTyp.isInstance(content)) {
//					instancesList.add(this.processor.getStdLibAdapter().OclAny(content));
//				}
//
//			}
//		}
		//****************************************************
		instancesList.addAll(instanceRefClass.getEAllReferences());
//***********************************************************
		OclSet set = this.processor.getStdLibAdapter().Set(oclModelElementTypeImpl, instancesList);
		return set;
	}

	private EClass getRefClass(EClass instanceTyp) {
		try {
			return ((ResourceSet)processor.getClass().getMethod("getConnection").invoke(processor)).getJmiHelper().getRefClassForMofClass(instanceTyp);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public OclType OclModelElement_oclType(OclAnyModelElement self) {
		EObject mofObj = (EObject) self.asJavaObject();
		//????
		EClass cObj = (EClass) mofObj.refMetaObject();
		Classifier type = this.processor.getBridgeFactory().buildClassifier(cObj);
		return this.processor.getStdLibAdapter().Type(type);
	}

	// --- Enumeration
	public boolean EnumLiteral_equalTo(OclEnumeration e1, OclAny e2) {

		Object o1 = e1.asJavaObject();
		Object o2 = e2.asJavaObject();

		if (e1.asJavaObject() instanceof String) {
			String enumliteral = (String) e1.asJavaObject();
			o1 = enumliteral;

		}

		if (e2.asJavaObject() instanceof String) {
			String enumliteral = (String) e2.asJavaObject();
			o2 = enumliteral;

		}

		return o1.equals(o2);

	}

	public boolean EnumLiteral_oclIsNew(Object o1) {
		return false;
	}

	public boolean EnumLiteral_oclIsUndefined(Object o1) {
		return o1 == null;
	}

	public Object EnumLiteral_oclAsType(Object o1, Object o2) {
		return o1;
	}

	public boolean EnumLiteral_oclIsTypeOf(Object o1, Object o2) {
		return o1.getClass() == o2.getClass();
	}

	public boolean EnumLiteral_oclIsKindOf(Object o1, Object o2) {
		Class c1 = o1.getClass();
		Class c2 = o2.getClass();
		return c1.isAssignableFrom(c2);
	}

	public Set EnumLiteral_allInstances(Object o1) {
		return new LinkedHashSet();
	}

	public Object getImpl(ModelElement me) {
		return me.getDelegate();
	}

	public Class getImplClass(Classifier cls) {
//		MofClass ecls = (MofClass) cls.getDelegate();
//		//return ecls.getInstanceClass();
//		return ecls.getInstanceClass();
		throw new UnsupportedOperationException();
	}

	public Object getValueForFeauture(Object source, Property property) {
		if (source instanceof EObject) {
			EObject mofo = (EObject) source;
			return mofo.refGetValue(property.getName());
		}
		throw new RuntimeException("Expected EObject but found " + source);
	}

	public Object invokeModelOperation(Classifier sourceType, Classifier resultType, Object source, String operName, List javaTypes, List args, ILog log) {
		Object result = null;
		try {
			Method oper = this.getMethod(source, operName, (Class[]) javaTypes.toArray(new Class[] {}));
			if (source != null) {
				if (oper != null) {
					result = oper.invoke(source, args.toArray());
				} else {
					// try converting source into an OclAnyModelElement ?
					log.reportError("eval: Operation " + operName + javaTypes + " not found on object " + source);
				}
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return this.processor.getStdLibAdapter().OclAny(result);
	}

	/** Get a method using reflection */
	private Method getMethod(Object source, String operName, Class[] types) throws Exception {
		if (source == null) {
			return null;
		}
		Method method = null;
		try {
			// --- Search foe exact match ---
			try {
				method = source.getClass().getMethod(operName, types);
			} catch (Exception e) {
			}
			// --- Search compatible methods ---
			if (method == null) {
				Method methods[] = source.getClass().getMethods();
				for (Method element : methods) {
					String methodName = element.getName();
					Class argTypes[] = element.getParameterTypes();
					if (methodName.equals(operName) && types.length == argTypes.length) {
						boolean found = true;
						for (int j = 0; j < types.length; j++) {
							if (!argTypes[j].isAssignableFrom(types[j])) {
								found = false;
								break;
							}
						}
						if (found) {
							return element;
						}
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return method;
	}

}
