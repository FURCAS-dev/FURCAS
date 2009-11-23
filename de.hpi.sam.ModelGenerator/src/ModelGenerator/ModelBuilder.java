package ModelGenerator;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;

import ModelGenerator.MetaModelStructure.MetaModelAttribute;
import ModelGenerator.MetaModelStructure.MetaModelReference;
import ModelGenerator.ModelStructure.ClassInstance;

public class ModelBuilder {
	public void buildModel(MetaModelStructure metaModelStructure, ModelStructure modelStructure){
		//build the meta model and an instance of it according to the given structures
		EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;
		EPackage metaModelEPackage = ecoreFactory.createEPackage();
		metaModelEPackage.setName("MetaModelPackage");
		
		//create all meta classes
		for(int i = 0; i < metaModelStructure.classes.length; i++){
			EClass anEClass = ecoreFactory.createEClass();
			anEClass.setName("Class" + i);
			metaModelEPackage.getEClassifiers().add(anEClass);
		}
		//create all meta attributes and attach them to their owner classes
		for(int j = 0; j < metaModelStructure.attributes.size(); j++){
			MetaModelAttribute attributeStructure = metaModelStructure.attributes.get(j);
			EClass ownerClass = (EClass) metaModelEPackage.getEClassifiers().get(attributeStructure.ownerClass);
			EAttribute anAttribute = ecoreFactory.createEAttribute();
			anAttribute.setName("Attribute" + j);
			anAttribute.setEType(attributeStructure.attributeType.getEType());
			ownerClass.getEStructuralFeatures().add(anAttribute);
		}
		//create all meta references
		for(int k = 0; k < metaModelStructure.references.size(); k++){
			MetaModelReference referenceStructure = metaModelStructure.references.get(k);
			EClass sourceClass = (EClass) metaModelEPackage.getEClassifiers().get(referenceStructure.sourceClass);
			EClass targetClass = (EClass) metaModelEPackage.getEClassifiers().get(referenceStructure.targetClass);
			EReference aReference = ecoreFactory.createEReference();
			aReference.setName("Reference" + k);
			aReference.setLowerBound(referenceStructure.referenceType.getLowerBound());
			aReference.setUpperBound(referenceStructure.referenceType.getLowerBound());
			//TODO build an identical copy of the referenceType (maybe use a copier and just change relevant attributes)
			aReference.setEType(targetClass);
			sourceClass.getEStructuralFeatures().add(aReference);
		}
		//build an instance of the meta model according to the given structure
		EFactory instanceFactory = metaModelEPackage.getEFactoryInstance();
		
		//build the class instances
		for(int i = 0; i < modelStructure.classes.size(); i++){
			ClassInstance classInstanceStructure = modelStructure.classes.get(i);
			//TODO check if the indices are correct!
			EClass metaClass = (EClass) metaModelEPackage.getEClassifiers().get(classInstanceStructure.metaClass);
			EObject aClassInstance  = instanceFactory.create(metaClass);
			//set the references
			TreeIterator<EObject> iterator = aClassInstance.eAllContents();
			while(iterator.hasNext()){
				//TODO continue here
			}
		}
	}
}
