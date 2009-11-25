package de.hpi.sam.bp2009.testframework.generator.dynamicemf;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

import de.hpi.sam.bp2009.testframework.generator.dynamicemf.MetaModelStructure.MetaModelAttribute;
import de.hpi.sam.bp2009.testframework.generator.dynamicemf.MetaModelStructure.MetaModelReference;
import de.hpi.sam.bp2009.testframework.generator.dynamicemf.ModelStructure.ClassInstance;
import de.hpi.sam.bp2009.testframework.generator.dynamicemf.ModelStructure.ReferenceInstance;


public class ModelBuilder {
	
	ResourceSet resourceSet;
	Resource resource;
	
	private Copier copier = new Copier();
	
	public ModelBuilder(){
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new  XMIResourceFactoryImpl());
		URI uri = URI.createFileURI(new File("model.xmi").getAbsolutePath());
		resource = resourceSet.createResource(uri);
		
	}	
		
	public Resource buildModel(MetaModelStructure metaModelStructure, ModelStructure modelStructure){
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
			//create a copy of the attribute type and make it unique by setting the name
			EAttribute anAttribute = (EAttribute) copier.copy(attributeStructure.attributeType);
			anAttribute.setName("Attribute" + j);
			anAttribute.setEType(attributeStructure.attributeType.getEType());
			ownerClass.getEStructuralFeatures().add(anAttribute);
		}
		//create all meta references
		for(int k = 0; k < metaModelStructure.references.size(); k++){
			MetaModelReference referenceStructure = metaModelStructure.references.get(k);
			EClass sourceClass = (EClass) metaModelEPackage.getEClassifiers().get(referenceStructure.sourceClass);
			EClass targetClass = (EClass) metaModelEPackage.getEClassifiers().get(referenceStructure.targetClass);
			EReference aReference = (EReference) copier.copy(referenceStructure.referenceType);
			aReference.setName("Reference" + k);
			aReference.setEType(targetClass);
			sourceClass.getEStructuralFeatures().add(aReference);
		}
		//build an instance of the meta model according to the given structure
		EFactory instanceFactory = metaModelEPackage.getEFactoryInstance();
		
		//build the class instances
		for(int i = 0; i < modelStructure.classes.size(); i++){
			ClassInstance classInstanceStructure = modelStructure.classes.get(i);
			EClass metaClass = (EClass) metaModelEPackage.getEClassifiers().get(classInstanceStructure.metaClass);
			EObject aClassInstance  = instanceFactory.create(metaClass);
			aClassInstance.eSet(metaClass.getEAllAttributes().get(0), metaClass.getEAllAttributes().get(0).getDefaultValue()); 
			resource.getContents().add(aClassInstance);			
		}
		//build the references
		for(int j = 0; j < modelStructure.references.size(); j++){
			ReferenceInstance referenceStructure = modelStructure.references.get(j);
			EClass source = (EClass) resource.getContents().get(referenceStructure.source); 
			for(int k = 0; k < referenceStructure.targets.size(); k++){
				EStructuralFeature reference = source.getEStructuralFeature("Reference" + j);
				EClassifier targetClass = (EClassifier) resource.getContents().get(referenceStructure.targets.get(k));
				source.eSet(reference, targetClass);
				resource.getContents().add(source);
			}
		}
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resource;
	}
}
