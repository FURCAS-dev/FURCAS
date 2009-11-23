package ModelGenerator;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;

public class ModelStructure {
	
	class ClassInstance{
		int metaClass;
		ArrayList<ReferenceInstance> startingReferences;
		ArrayList<ReferenceInstance> endingReferences;
		public ClassInstance (int aMetaClass){
			metaClass = aMetaClass;
		}
		public ReferenceInstance getEndingReference (EReference referenceType){
			for(int i=0; i< endingReferences.size(); i++){
				if (endingReferences.get(i).metaClass == getMetaReferenceIndex(referenceType)){
					return endingReferences.get(i);
				}
			}
			return null;
		}
	}
	
	class AttributeInstance{
		int metaClass;
		ClassInstance owner;
		public AttributeInstance (int aMetaClass) {
			metaClass = aMetaClass;
		}
	}
	
	class ReferenceInstance{
		int metaClass;
		ClassInstance source;
		ArrayList<ClassInstance> targets;
		public ReferenceInstance (int aMetaClass) {
			metaClass = aMetaClass;
		}
	}
	
	MetaModelStructure metaModel;
	ArrayList<ClassInstance> classes;
	//each entry represents an instance of a class of the meta model
	ArrayList<AttributeInstance> attributes;
	//each entry represents an instance of an attribute of the meta model
	ArrayList<ReferenceInstance> references;
	//each entry represents an instance of a reference of the meta model
	
	public ModelStructure(MetaModelStructure metaModelStructure){
		metaModel = metaModelStructure;
	}
	
	public void addClass(int aClass){
		//add a class instance to the model structure
		ClassInstance classToAdd = new ClassInstance(aClass);
		classToAdd.startingReferences = new ArrayList<ReferenceInstance>();
		classToAdd.endingReferences = new ArrayList<ReferenceInstance>();
		classes.add(classToAdd);
	}
	
	public void addAttribute(EAttribute attributeType, int owner){
		//add an attribute instance to the model structure
		AttributeInstance attribute = new AttributeInstance(getMetaAttributeIndex(attributeType));
		attribute.owner = classes.get(owner);
		attributes.add(attribute);
	}
	
	public void addReference(EReference referenceType, int source, int target){
		//add a reference instance to the model structure
		ReferenceInstance reference = new ReferenceInstance(getMetaReferenceIndex(referenceType));
		reference.source = classes.get(source);
		reference.targets.add(classes.get(target));
		references.add(reference);
		classes.get(source).startingReferences.add(reference);
		classes.get(target).endingReferences.add(reference);
	}

	public int getAttributeOwner(EAttribute attribute){
		//get the first possible owner of the given attribute
		int metaClass = metaModel.getOwnerOf(attribute);
		for (int i = 0; i < classes.size(); i++){
			if (classes.get(i).metaClass == metaClass){
				return i;
			}
		}
		return -1;
	}
	
	public int getReferenceSource(EReference reference) {
		//get the first possible source of the given reference
		int metaSourceClass = metaModel.getSourceOf(reference);
		
		for (int i = 0; i < classes.size(); i++){
			if ((classes.get(i).metaClass == metaSourceClass) && (classes.get(i).startingReferences.contains(reference) == false)){
				return i;
			}
		}
		return -1;
	}
	
	public int getReferenceTarget(EReference reference) {
		//get the first possible target of the given reference
		int metaTargetClass = metaModel.getTargetOf(reference);
		for (int i = 0; i < classes.size(); i++){
			if ((classes.get(i).metaClass == metaTargetClass) && (classes.get(i).getEndingReference(reference).targets.size() < reference.getUpperBound())){
				return i;
			}
		}
		return -1;
	}
	
	private int getMetaAttributeIndex(EAttribute attribute){
		//get the index of the attribute in the meta model
		for (int i = 0; i < metaModel.attributes.size(); i++){
			if (attribute == metaModel.attributes.get(i).attributeType){
				return i;
			}
		}
		return -1;
	}
	
	private int getMetaReferenceIndex(EReference reference) {
		//get the index of the reference in the meta model
		for (int i = 0; i < metaModel.references.size(); i++){
			if (reference == metaModel.references.get(i).referenceType){
				return i;
			}
		}
		return -1;
	}
}
