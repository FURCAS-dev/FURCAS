/**
 * 
 */
package com.sap.mi.textual.moinlookup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.mi.textual.common.exceptions.MetaModelLookupException;
import com.sap.mi.textual.common.interfaces.IMetaModelLookup;
import com.sap.mi.textual.common.interfaces.MultiplicityBean;
import com.sap.mi.textual.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.tc.moin.repository.Partitionable;

/**
 *
 */
public abstract class AbstractMoinLookup  implements IMetaModelLookup<RefObject> {

    /**
     * looks structural features
     * 
     * @param reference the type name
     * @param name the feature name
     * 
     * @return feature or null
     * @throws MetaModelLookupException 
     */
    protected TypedElement getTypedElement(ResolvedNameAndReferenceBean<RefObject> reference, String name) throws MetaModelLookupException  {
        TypedElement returnElement = null;
        
        Classifier classifier = getClassifier(reference);
        try {
            if (classifier != null && (classifier instanceof MofClass) ) {
            
                ModelElement me = classifier.lookupElementExtended(name); // throws exception or not?
                if (me != null) {
                    if (me instanceof StructuralFeature) {
                        returnElement = (StructuralFeature) me;
                    } 
                }
            }
        } catch (NameNotFoundException e) {
            // may still be associationend
        }
        if (classifier != null && returnElement == null && ((Partitionable)classifier).get___Connection() != null) {
			// may be an AssociationEnd that is not exposed
			// first get all supertypes of the classifier
			Set<AssociationEnd> end = ((Partitionable) classifier)
					.get___Connection().getJmiHelper().getAssociationEnds(
							classifier, true);
			for (AssociationEnd associationEnd : end) {
				if (associationEnd.otherEnd().getName().equals(name)) {
					if (returnElement != null) {
						throw new MetaModelLookupException("Ambiguous feature detected, name: " + name
								+ " for classifier: " + classifier.getQualifiedName());
					} else {
						returnElement = associationEnd.otherEnd();
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
    protected StructureField getStructureField(ResolvedNameAndReferenceBean<RefObject> reference, String featureName) throws MetaModelLookupException  {
        StructureField returnFeature = null;
        
        try {
            Classifier classifier = getClassifier(reference);
            if (classifier != null  && (classifier instanceof StructureType)) {
                
                ModelElement me = classifier.lookupElementExtended(featureName); // throws exception or not?
                if (me != null) {
                    if (me instanceof StructureField) {
                        returnFeature = (StructureField) me;
                    } 
                }
            }
        } catch (NameNotFoundException e) {
            // return null
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
    protected final Classifier getClassifier(ResolvedNameAndReferenceBean<RefObject> reference) throws MetaModelLookupException {
        if (reference != null) {
            if (reference.getReference() instanceof Classifier) {
                Classifier classi = (Classifier) reference.getReference();
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
    protected abstract Classifier getClassifierByName(List<String> names) throws MetaModelLookupException;

    public boolean isAbstract(ResolvedNameAndReferenceBean<RefObject> referedElement) throws MetaModelLookupException {
        Classifier classi = getClassifier(referedElement);
        return classi.isAbstract();
    }
    
    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#getFeatureClassName(java.lang.String, java.lang.String)
     */
    public ResolvedNameAndReferenceBean<RefObject> getFeatureClassReference(ResolvedNameAndReferenceBean<RefObject> referedElement, String featureName) throws MetaModelLookupException {
     
//        List<String> featureClassNameList = null;
        Classifier resultType = null;
        // could be feature, association, or StructureField, so try each in turn
        String[] path = featureName.split("\\.");
        ResolvedNameAndReferenceBean<RefObject> referedElementPart = referedElement;
        for (int i = 0; i < path.length; i++) {
            String featureNamePart = path[i];
            TypedElement feature = getTypedElement(referedElementPart, featureNamePart);
            if (feature != null) {
                resultType = feature.getType();
//                featureClassNameList = feature.getType().getQualifiedName();
            } 
                    
            if (resultType == null) {
                // try Association
                AssociationEnd assoEnd = getAssociationEnd(referedElementPart, featureNamePart);
                if (assoEnd != null) {
                    resultType = assoEnd.getType();
//                    featureClassNameList = assoEnd.getType().getQualifiedName();
                }
            }
            
            if (resultType == null) {
                // try Association
                StructureField strucField = getStructureField(referedElementPart, featureNamePart);
                if (strucField != null) {
                    resultType = strucField.getType();
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
    protected abstract AssociationEnd getAssociationEnd(ResolvedNameAndReferenceBean<RefObject> reference,
            String featureName) throws MetaModelLookupException;

    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#getMultiplicity(java.lang.String, java.lang.String)
     */
    public MultiplicityBean getMultiplicity(ResolvedNameAndReferenceBean<RefObject> referedElement, String featureName) throws MetaModelLookupException {
       
        MultiplicityType mofMult = null;
     // could be feature, association, or StructureField, so try each in turn
        // could be feature, association, or StructureField, so try each in turn
        String[] path = featureName.split("\\.");
        ResolvedNameAndReferenceBean<RefObject> referedElementPart = referedElement;
        MultiplicityBean bean = null;
        for (int i = 0; i < path.length; i++) {
            String featureNamePart = path[i];
            TypedElement feature = getTypedElement(referedElementPart, featureNamePart);
            if (feature != null) {
            	if(feature instanceof AssociationEnd) {
            		mofMult = ((AssociationEnd) feature).getMultiplicity();
            	} else if (feature instanceof StructuralFeature) {
            		mofMult = ((StructuralFeature) feature).getMultiplicity();
            	}
            	referedElementPart = getBean(feature.getType());
            } 
            
            if (mofMult == null) {
                // try Association
                AssociationEnd assoEnd = getAssociationEnd(referedElementPart, featureNamePart);
                if (assoEnd != null) {
                    mofMult = assoEnd.getMultiplicity();
                    referedElementPart = getBean(assoEnd.getType());
                }
            }
            
            
            if (mofMult != null) {
                bean = new MultiplicityBean();
                bean.setLowerBound(mofMult.getLower());
                bean.setUpperBound(mofMult.getUpper());
            }
            
            if (mofMult == null) {
                // try Association
                StructureField strucField = getStructureField(referedElementPart, featureNamePart);
                if (strucField != null) {
                    // structure field are always mandatory and of single multiplicity
                    bean = new MultiplicityBean();
                    bean.setLowerBound(1);
                    bean.setUpperBound(1);
                    referedElementPart = getBean(strucField.getType());
                }
            }
        }

       
        return bean;
    }
    

//    /* (non-Javadoc)
//     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#hasFeature(java.lang.String, java.lang.String)
//     */
//    public boolean hasFeature(ResolvedNameAndReferenceBean<RefObject> reference, String featureName) throws MetaModelLookupException {
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
    public List<ResolvedNameAndReferenceBean<RefObject>> qualifyName(String typeName) throws MetaModelLookupException {
        // Find all Classifiers of this name
        // return all qualified names for these Classifiers
        List<ResolvedNameAndReferenceBean<RefObject>> names = new ArrayList<ResolvedNameAndReferenceBean<RefObject>>();
        List<Classifier> classifiers = getClassifiers(typeName);
        for (Iterator<Classifier> iterator = classifiers.iterator(); iterator.hasNext();) {
            Classifier classifier = iterator.next();
            names.add(getBean(classifier));
        }
        return names;
    }
    
    protected ResolvedNameAndReferenceBean<RefObject> getBean(Classifier refObject) {

        if (refObject == null) {
            return null;
        } else {
            // TODO use wrapper instead of mere bean
            return new ResolvedNameAndReferenceBean<RefObject>(refObject.getQualifiedName(), refObject);
        }
    }
    
    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#getEnumLiterals(java.lang.String)
     */
	public List<String> getEnumLiterals(ResolvedNameAndReferenceBean<RefObject> reference)
			throws MetaModelLookupException {
	    
		Classifier classifier = getClassifier(reference);
		if (!(classifier instanceof EnumerationType)) {
			throw new MetaModelLookupException("The given name ("+reference.getNames()+") does not resolve to an EnumerationType");
		}
		EnumerationType enumeration = (EnumerationType)classifier;
		List<String> literals = new ArrayList<String>(enumeration.getLabels().size());
		literals.addAll(enumeration.getLabels());
		return literals;
	}

    /**
     * @param typeName
     * @return
     * @throws MetaModelLookupException 
     */
    protected abstract List<Classifier> getClassifiers(String typeName) throws MetaModelLookupException;

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
    public boolean isSubTypeOf(ResolvedNameAndReferenceBean<RefObject> subType, ResolvedNameAndReferenceBean<RefObject> superType) throws MetaModelLookupException {
        Classifier supertypeClass = getClassifier(superType);
        Classifier subtypeClass = getClassifier(subType);
        
        if (supertypeClass == null || subtypeClass == null) {
            return false;
        }
        if (subtypeClass.equals(supertypeClass)) {
            return true;
        }
        
        List<GeneralizableElement> superList = subtypeClass.allSupertypes();
        for (Iterator<GeneralizableElement> iterator = superList.iterator(); iterator.hasNext();) {
            GeneralizableElement generalizableElement = iterator
                    .next();
            if (generalizableElement.equals(supertypeClass)) {
                return true;
            }
            
        }
        
        return false;
    }
    
    @Override
    public ResolvedNameAndReferenceBean<RefObject> resolveReference(
            List<String> names) throws MetaModelLookupException {
        return getBean(getClassifierByName(names));
    }



    @Override
    public ResolvedNameAndReferenceBean<RefObject> resolveReferenceName(
            RefObject reference) {
        if (reference instanceof Classifier) {
            Classifier classi = (Classifier) reference;
//            List<String> names = classi.getQualifiedName();
            return getBean(classi);    
        } else {
            throw new IllegalArgumentException("Expected Classifier, not " + reference.getClass());
        }
        
    }
}
