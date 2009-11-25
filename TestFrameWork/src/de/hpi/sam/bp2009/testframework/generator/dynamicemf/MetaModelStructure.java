package de.hpi.sam.bp2009.testframework.generator.dynamicemf;

import java.util.ArrayList;
import java.util.Random;
import org.eclipse.emf.ecore.*;

public class MetaModelStructure {
	
	class MetaModelReference {
		EReference referenceType;
		int sourceClass;
		int targetClass;
	}
	
	class MetaModelAttribute {
		EAttribute attributeType;
		int ownerClass;
	}
	
	
	ArrayList<MetaModelReference> references;
	ArrayList<MetaModelAttribute> attributes;
	int[][] classes;
	//first dimension specifies the class,
	//second dimension the number of ReferenceSources(index 0), ReferenceTargets(index 1) and Attributes(index 2)
	private static Random random = new Random();	
	
	public MetaModelStructure(int numberOfClasses){
		classes = new int[numberOfClasses][3];
		references = new ArrayList<MetaModelReference>();
		attributes = new ArrayList<MetaModelAttribute>();
	}
	
	public int getSourceClass(int max, int min){
		//get a class to use it as a source for a reference
		if (getClassesBelowSourceMin(min).size() != 0){
			return getClassesBelowSourceMin(min).get(0);
		}
		if (getClassesBelowSourceMax(max).size() != 0){
			int classToGet = random.nextInt(getClassesBelowSourceMax(max).size());
			return getClassesBelowSourceMax(max).get(classToGet);
		}
		return -1;
	}
	
	public int getTargetClass(){
		//get a class to use it as a target for a reference
		return random.nextInt(classes.length);
	}
	
	public int getAttributeClass(int max, int min){
		//get a class to attach an attribute to it
		if (getClassesBelowAttributeMin(min).size() != 0){
			return getClassesBelowAttributeMin(min).get(0);
		}
		if (getClassesBelowAttributeMax(max).size() != 0){
			int classToGet = random.nextInt(getClassesBelowAttributeMax(max).size());
			return getClassesBelowAttributeMax(max).get(classToGet);
		}
		return -1;
	}
	
	public int getOwnerOf(EAttribute attribute){
		//return the index of the class that owns the given attribute
		for (int i = 0; i < attributes.size(); i++){
			if (attribute == attributes.get(i).attributeType){
				return attributes.get(i).ownerClass;
			}
		}
		return -1;
	}
	
	public int getSourceOf(EReference reference) {
		//return the index of the source class of the given reference
		for (int i = 0; i < references.size(); i++){
			if (reference == references.get(i)){
				return references.get(i).sourceClass;
			}
		}
		return -1;
	}
	
	public int getTargetOf(EReference reference) {
		//return the index of the target class of the given reference
		for (int i = 0; i < references.size(); i++){
			if (reference == references.get(i)){
				return references.get(i).targetClass;
			}
		}
		return -1;
	}
	
	public void addReferenceToClass(EReference referenceType, int source, int target){
		//add a reference to the meta model structure
		MetaModelReference metaModelReference = new MetaModelReference();
		metaModelReference.referenceType = referenceType;
		metaModelReference.sourceClass = source;
		metaModelReference.targetClass = target;
		references.add(metaModelReference);
		classes[source][0]++;
		classes[target][1]++;
	}
	
	public void addAttributeToClass(EAttribute attributeType, int aClass){
		//add an attribute to the meta model structure
		MetaModelAttribute metaModelAttribute = new MetaModelAttribute();
		metaModelAttribute.attributeType = attributeType;
		metaModelAttribute.ownerClass = aClass;
		attributes.add(metaModelAttribute);
		classes[aClass][2]++;
	}
	
	
	private ArrayList<Integer> getClassesBelowSourceMin(int limit){
		//get all classes that haven't reached the minimum number of reference sources
		ArrayList<Integer> result = new ArrayList<Integer>(); 
		for (int i = 0; i < (classes.length); i++){
			if (classes[i][0] < limit){
				result.add(i);
			}
		}
		return result;
	}
	
	private ArrayList<Integer> getClassesBelowSourceMax(int limit){
		//get all classes that haven't reached the maximum number of reference sources
		ArrayList<Integer> result = new ArrayList<Integer>(); 
		for (int i = 0; i < (classes.length); i++){
			if (classes[i][0] < limit){
				result.add(i);
			}
		}
		return result;
	}
	
	private ArrayList<Integer> getClassesBelowAttributeMin(int limit){
		//get all classes that haven't reached the minimum number of attributes
		ArrayList<Integer> result = new ArrayList<Integer>(); 
		for (int i = 0; i < (classes.length); i++){
			if (classes[i][2] < limit){
				result.add(i);
			}
		}
		return result;
	}
	
	private ArrayList<Integer> getClassesBelowAttributeMax(int limit){
		//get all classes that haven't reached the maximum number of attributes
		ArrayList<Integer> result = new ArrayList<Integer>(); 
		for (int i = 0; i < (classes.length); i++){
			if (classes[i][2] < limit){
				result.add(i);
			}
		}
		return result;
	}
}
