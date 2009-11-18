package ModelGenerator;

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
	//first dimension specifies the class,
	//second dimension the number of ReferenceSources(0), ReferenceTargets(1) and Attributes(2)
	private int[][] classes;
	private ArrayList<MetaModelReference> references;
	private ArrayList<MetaModelAttribute> attributes;
	private Random random = new Random();
	
	public void createClasses(int number){
		classes = new int[number][3];
	}
	
	public int getSourceClass(int max, int min){
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
		return random.nextInt(classes.length);
	}
	
	public int getAttributeClass(int max, int min){
		if (getClassesBelowAttributeMin(min).size() != 0){
			return getClassesBelowAttributeMin(min).get(0);
		}
		if (getClassesBelowAttributeMax(max).size() != 0){
			int classToGet = random.nextInt(getClassesBelowAttributeMax(max).size());
			return getClassesBelowAttributeMax(max).get(classToGet);
		}
		return -1;
	}
	
	public ArrayList<Integer> getClassesBelowSourceMin(int limit){
		ArrayList<Integer> result = new ArrayList<Integer>(); 
		for (int i = 0; i < (classes.length); i++){
			if (classes[i][0] < limit){
				result.add(i);
			}
		}
		return result;
	}
	
	public ArrayList<Integer> getClassesBelowSourceMax(int limit){
		ArrayList<Integer> result = new ArrayList<Integer>(); 
		for (int i = 0; i < (classes.length); i++){
			if (classes[i][0] < limit){
				result.add(i);
			}
		}
		return result;
	}
	
	public ArrayList<Integer> getClassesBelowAttributeMin(int limit){
		ArrayList<Integer> result = new ArrayList<Integer>(); 
		for (int i = 0; i < (classes.length); i++){
			if (classes[i][2] < limit){
				result.add(i);
			}
		}
		return result;
	}
	
	public ArrayList<Integer> getClassesBelowAttributeMax(int limit){
		ArrayList<Integer> result = new ArrayList<Integer>(); 
		for (int i = 0; i < (classes.length); i++){
			if (classes[i][2] < limit){
				result.add(i);
			}
		}
		return result;
	}
	
	public void addReferenceToClass(EReference reference, int source, int target){
		classes[source][0]++;
		classes[target][1]++;
		MetaModelReference metaModelReference = new MetaModelReference();
		metaModelReference.referenceType = reference;
		metaModelReference.sourceClass = source;
		metaModelReference.targetClass = target;
		references.add(metaModelReference);
	}
	
	public void addAttributeToClass(EAttribute attribute, int aClass){
		classes[aClass][2]++;
		MetaModelAttribute metaModelAttribute = new MetaModelAttribute();
		metaModelAttribute.attributeType = attribute;
		metaModelAttribute.ownerClass = aClass;
		attributes.add(metaModelAttribute);
	}
}
