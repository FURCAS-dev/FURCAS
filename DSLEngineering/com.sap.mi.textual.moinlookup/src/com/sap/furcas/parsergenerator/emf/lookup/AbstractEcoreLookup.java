/**
 * 
 */
package com.sap.furcas.parsergenerator.emf.lookup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;

import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.interfaces.MultiplicityBean;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.runtime.common.util.EcoreHelper;



/**
 *
 */
public abstract class AbstractEcoreLookup  implements IMetaModelLookup<EObject> {

    /**
     * looks structural features
     * 
     * @param reference the type name
     * @param name the feature name
     * 
     * @return feature or null
     * @throws MetaModelLookupException 
     */
    protected ETypedElement getTypedElement(ResolvedNameAndReferenceBean<EObject> reference, String name) throws MetaModelLookupException  {
        ETypedElement returnElement = null;
        
        EClassifier classifier = getClassifier(reference);
        if (classifier != null && (classifier instanceof EClass) ) {
		
		    EModelElement me = EcoreHelper.lookupElementExtended(classifier, name); // throws exception or not?
		    if (me != null) {
		        if (me instanceof EStructuralFeature) {
		            returnElement = (EStructuralFeature) me;
		        } 
		    }
		}
        if (classifier != null && returnElement == null && ((EObject)classifier).eResource() != null) {
			// may be an AssociationEnd that is not exposed
			// first get all supertypes of the classifier
			Set<EReference> end = EcoreHelper.getUnexposedReferences(classifier, true);
			for (EReference associationEnd : end) {
				if (associationEnd.getName().equals(name)) {
					if (returnElement != null) {
						throw new MetaModelLookupException("Ambiguous feature detected, name: " + name
								+ " for classifier: " + EcoreHelper.getQualifiedName(classifier));
					} else {
						returnElement = associationEnd.getEOpposite();
					}
				}
			}
		}
        return returnElement;
    }
    
    /**
     * looks up type by name.
     * 
     * @param reference the type name
     * @param featureName the feature name
     * 
     * @return feature or null
     * @throws MetaModelLookupException 
     */
    protected EDataType getStructureField(ResolvedNameAndReferenceBean<EObject> reference, String featureName) throws MetaModelLookupException  {
        EDataType returnFeature = null;
        
        EClassifier classifier = getClassifier(reference);
		if (classifier != null  && (classifier instanceof EDataType)) {
		    
		    EModelElement me = EcoreHelper.lookupElementExtended(classifier, featureName); // throws exception or not?
		    if (me != null) {
		        if (me instanceof EDataType) {
		            returnFeature = (EDataType) me;
		        } 
		    }
		}
        return returnFeature;
    }
    
    /**
     * looks up type by name.
     * 
     * @param typeName the type name
     * 
     * @return the classifier
     * @throws MetaModelLookupException 
     */
    protected final EClassifier getClassifier(ResolvedNameAndReferenceBean<EObject> reference) throws MetaModelLookupException {
        if (reference != null) {
            if (reference.getReference() instanceof EClassifier) {
                EClassifier classi = (EClassifier) reference.getReference();
                return classi;
            }
            return getClassifierByName(reference.getNames());
        }
        return null;
    }

    
    /**
     * uses classifier name to look up classifier
     * @param names
     * @return
     * @throws MetaModelLookupException 
     */
    protected abstract EClassifier getClassifierByName(List<String> names) throws MetaModelLookupException;

    @Override
    public boolean isAbstract(ResolvedNameAndReferenceBean<EObject> referedElement) throws MetaModelLookupException {
        EClassifier classi = getClassifier(referedElement);
        if(classi instanceof EClass) {
        	return ((EClass) classi).isAbstract();
        } else {
        	return false;
        }
    }
    
    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#getFeatureClassName(java.lang.String, java.lang.String)
     */
    @Override
    public ResolvedNameAndReferenceBean<EObject> getFeatureClassReference(ResolvedNameAndReferenceBean<EObject> referedElement, String featureName) throws MetaModelLookupException {
     
//        List<String> featureClassNameList = null;
        EClassifier resultType = null;
        // could be feature, association, or StructureField, so try each in turn
        String[] path = featureName.split("\\.");
        ResolvedNameAndReferenceBean<EObject> referedElementPart = referedElement;
        for (int i = 0; i < path.length; i++) {
            String featureNamePart = path[i];
            ETypedElement feature = getTypedElement(referedElementPart, featureNamePart);
            if (feature != null) {
                resultType = feature.getEType();
//                featureClassNameList = feature.getType().getQualifiedName();
            } 
                    
            if (resultType == null) {
                // try Association
                EReference assoEnd = getAssociationEnd(referedElementPart, featureNamePart);
                if (assoEnd != null) {
                    resultType = assoEnd.getEType();
//                    featureClassNameList = assoEnd.getType().getQualifiedName();
                }
            }
            
            if (resultType == null) {
                // try Association
                EDataType strucField = getStructureField(referedElementPart, featureNamePart);
                if (strucField != null) {
                    resultType = strucField;
//                    featureClassNameList = strucField.getType().getQualifiedName();
                }
            }
            referedElementPart = getBean(resultType);
	}
        

        return referedElementPart;

    }
    
    /**
     * @param reference
     * @param featureName
     * @return
     * @throws MetaModelLookupException 
     */
    protected abstract EReference getAssociationEnd(ResolvedNameAndReferenceBean<EObject> reference,
            String featureName) throws MetaModelLookupException;

    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#getMultiplicity(java.lang.String, java.lang.String)
     */
    @Override
    public MultiplicityBean getMultiplicity(ResolvedNameAndReferenceBean<EObject> referedElement, String featureName) throws MetaModelLookupException {
       
    	EStructuralFeature mofMult = null;
     // could be feature, association, or StructureField, so try each in turn
        // could be feature, association, or StructureField, so try each in turn
        String[] path = featureName.split("\\.");
        ResolvedNameAndReferenceBean<EObject> referedElementPart = referedElement;
        MultiplicityBean bean = null;
        for (int i = 0; i < path.length; i++) {
            String featureNamePart = path[i];
            ETypedElement feature = getTypedElement(referedElementPart, featureNamePart);
            if (feature != null) {
            	if(feature instanceof EStructuralFeature) {
            		mofMult = ((EStructuralFeature) feature);
            		mofMult.setLowerBound(((EStructuralFeature) feature).getLowerBound());
            		mofMult.setUpperBound(((EStructuralFeature) feature).getUpperBound());
            	}
            	referedElementPart = getBean(feature.getEType());
            } 
            
//            if (mofMult == null) {
//                // try Association
//                EReference assoEnd = getAssociationEnd(referedElementPart, featureNamePart);
//                if (assoEnd != null) {
////                    mofMult = assoEnd.getMultiplicity();
//                	mofMult.setLowerBound(assoEnd.getLowerBound());
//            		mofMult.setUpperBound(assoEnd.getUpperBound());
//                    referedElementPart = getBean(assoEnd.getEType());
//                }
//            }
            
            
            if (mofMult != null) {
                bean = new MultiplicityBean();
                bean.setLowerBound(mofMult.getLowerBound());
                bean.setUpperBound(mofMult.getUpperBound());
            }
            
            if (mofMult == null) {
                // try Association
                EDataType strucField = getStructureField(referedElementPart, featureNamePart);
                if (strucField != null) {
                    // structure field are always mandatory and of single multiplicity
                    bean = new MultiplicityBean();
                    bean.setLowerBound(1);
                    bean.setUpperBound(1);
                    referedElementPart = getBean(strucField);
                }
            }
        }

       
        return bean;
    }
    

//    /* (non-Javadoc)
//     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#hasFeature(java.lang.String, java.lang.String)
//     */
//    public boolean hasFeature(ResolvedNameAndReferenceBean<EObject> reference, String featureName) throws MetaModelLookupException {
////        List<String> typeName = reference.getNames();
//        boolean hasFeature = false;
//        if ((getFeature(reference, featureName) != null)
//                || ((getAssociationEnd(reference, featureName) != null))
//                || ((getStructureField(reference, featureName) != null))) {
//            hasFeature = true;
//        }
//        return hasFeature;
//    }
//    

    
    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#qualifyName(java.lang.String)
     */
    @Override
    public List<ResolvedNameAndReferenceBean<EObject>> qualifyName(String typeName) throws MetaModelLookupException {
        // Find all Classifiers of this name
        // return all qualified names for these Classifiers
        List<ResolvedNameAndReferenceBean<EObject>> names = new ArrayList<ResolvedNameAndReferenceBean<EObject>>();
        List<EClassifier> classifiers = getClassifiers(typeName);
        for (Iterator<EClassifier> iterator = classifiers.iterator(); iterator.hasNext();) {
            EClassifier classifier = iterator.next();
            names.add(getBean(classifier));
        }
        return names;
    }
    
    protected ResolvedNameAndReferenceBean<EObject> getBean(EClassifier refObject) {

        if (refObject == null) {
            return null;
        } else {
            // TODO use wrapper instead of mere bean
            return new ResolvedNameAndReferenceBean<EObject>(EcoreHelper.getQualifiedName(refObject), refObject);
        }
    }
    
    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#getEnumLiterals(java.lang.String)
     */
	@Override
	public List<String> getEnumLiterals(ResolvedNameAndReferenceBean<EObject> reference)
			throws MetaModelLookupException {
	    
		EClassifier classifier = getClassifier(reference);
		if (!(classifier instanceof EEnum)) {
			throw new MetaModelLookupException("The given name ("+reference.getNames()+") does not resolve to an EnumerationType");
		}
		EEnum enumeration = (EEnum)classifier;
		List<String> literals = new ArrayList<String>(enumeration.getELiterals().size());
		for (EEnumLiteral literal : enumeration.getELiterals()) {
			literals.add(literal.getLiteral());
		}
		return literals;
	}

    /**
     * @param typeName
     * @return
     * @throws MetaModelLookupException 
     */
    protected abstract List<EClassifier> getClassifiers(String typeName) throws MetaModelLookupException;

    protected static String getStringRepresentationOfName(List<String> name) {
        String nameString = null;
        if (name!= null) {
            StringBuilder nameStringBuilder = new StringBuilder(name.size() * 10);
        
            for (Iterator<String> iterator = name.iterator(); iterator.hasNext();) {
                String namePart = iterator.next();
                nameStringBuilder.append(namePart);
                if (iterator.hasNext()) {
                    nameStringBuilder.append("::");
                }
            }
            nameString = nameStringBuilder.toString();
        }
        return nameString;
    }
    
    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#isSubTypeOf(java.util.List, java.util.List)
     */
    @Override
    public boolean isSubTypeOf(ResolvedNameAndReferenceBean<EObject> subType, ResolvedNameAndReferenceBean<EObject> superType) throws MetaModelLookupException {
        EClassifier supertypeClass = getClassifier(superType);
        EClassifier subtypeClass = getClassifier(subType);
        
        if (supertypeClass == null || subtypeClass == null) {
            return false;
        }
        if (subtypeClass.equals(supertypeClass)) {
            return true;
        }
        
        List<EClass> superList = ((EClass)subtypeClass).getEAllSuperTypes();
        for (Iterator<EClass> iterator = superList.iterator(); iterator.hasNext();) {
            EClass generalizableElement = iterator
                    .next();
            if (generalizableElement.equals(supertypeClass)) {
                return true;
            }
            
        }
        
        return false;
    }
    
    @Override
    public ResolvedNameAndReferenceBean<EObject> resolveReference(
            List<String> names) throws MetaModelLookupException {
        return getBean(getClassifierByName(names));
    }



    @Override
    public ResolvedNameAndReferenceBean<EObject> resolveReferenceName(
            EObject reference) {
        if (reference instanceof EClassifier) {
            EClassifier classi = (EClassifier) reference;
//            List<String> names = classi.getQualifiedName();
            return getBean(classi);    
        } else {
            throw new IllegalArgumentException("Expected Classifier, not " + reference.getClass());
        }
        
    }
}
