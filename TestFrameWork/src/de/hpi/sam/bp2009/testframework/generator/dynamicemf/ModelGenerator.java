package de.hpi.sam.bp2009.testframework.generator.dynamicemf;

import java.util.Random;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;

import de.hpi.sam.bp2009.testframework.generator.dynamicemf.ModelGeneratorOptions.EAttributeOption;
import de.hpi.sam.bp2009.testframework.generator.dynamicemf.ModelGeneratorOptions.EReferenceOption;

public class ModelGenerator implements Generator{
	
	private static Random random = new Random();
	
	public MetaModelStructure generateMetaModelStructure(ModelGeneratorOptions options ){
		//parameter description:
		//numberOfClasses: absolute number of classes in the meta model
		//referenceTypes: array of reference types to create in the model
		//numberOfReferences: 2 dim. array to specify number of occurences per referenceType
		//			[i][0] holds total number of occurences
		//			[i][1] holds maximum number of referenceTypes[i] per class
		//			[i][2] holds minimum number of referenceTypes[i] per class
		//attributeTypes: same as referenceTypes just for attributes
		//numberOfAttributes: same as numberOfReferences just for attributes		

		//generate the meta model structure
		MetaModelStructure metaModel = new MetaModelStructure(options.metaClassOptions.size());
		for(int i = 0; i < (options.referenceOptions.size()); i++){
			//create all the references and associate them according to min and max values
			EReferenceOption ref = options.referenceOptions.get(i);
			for(int j = 0; j < ref.absOccurences; j++){
				int source = metaModel.getSourceClass(ref.maxOccurences, ref.minOccurences);
				int target = metaModel.getTargetClass();
				if((source != -1) && (target != -1)){
					metaModel.addReferenceToClass(ref.reference, source, target);
				}
			}
		}
		for(int i = 0; i < (options.attributeOptions.size()); i++){
			//create all the attributes and associate them according to min and max values
			EAttributeOption attr = options.attributeOptions.get(i);
			for(int j = 0; j < attr.absOccurences; j++){
				int source = metaModel.getAttributeClass(attr.maxOccurences, attr.minOccurences);
				if(source != -1){
					metaModel.addAttributeToClass(attr.attribute, source);
				}
			}
		}
		return metaModel;
	}
	public ModelStructure generateModelStructure(MetaModelStructure metaModel, ModelGeneratorOptions options){
		//parameter description:
		//metaModel: the generated MetaModelStructure to generate a ModelStructure for
		//numberOfClasses: 2 dim. array to specify the number of instances of classes of the meta model
		//				[i][0] holds the maximum number of instances of the class i of the meta model
		//				[i][1] holds the minimum number of instances of the class i of the meta model
		//numberOfReferences: same as numberOfClasses just for references
		//numberOfAttributes: same as numberOfClasses just for attributes
		
		ModelStructure model = new ModelStructure(metaModel);
		for (int i = 0; i < options.metaClassOptions.size(); i++){
			int numberOfInstances = random.nextInt(options.metaClassOptions.get(i).maxInstances-options.metaClassOptions.get(i).minInstances);
			for (int j = 0; j < numberOfInstances; j++){
				model.addClass(i);				
			}
		}
		for (int i = 0; i < options.attributeOptions.size(); i++){
			EAttributeOption attr = options.attributeOptions.get(i);
			EAttribute attribute = metaModel.attributes.get(i).attributeType;
			int numberOfInstances = random.nextInt(attr.maxOccurences-attr.minOccurences);
			for (int j = 0; j < numberOfInstances; j++){
				int owner = model.getAttributeOwner(attribute);
				if(owner != -1){
					model.addAttribute(attribute, owner);
				}
			}
		}
		for (int i = 0; i < options.referenceOptions.size(); i++){
			EReference reference = metaModel.references.get(i).referenceType;
			int numberOfInstances = random.nextInt(options.referenceOptions.get(i).maxOccurences-options.referenceOptions.get(i).minOccurences);
			for (int j = 0; j < numberOfInstances; j++){
				int source = model.getReferenceSource(reference);
				int target = model.getReferenceTarget(reference);
				if((source != -1) && (target != -1)){
					model.addReference(reference, source, target);
				}
			}
		}
		return model;
	}
	
	public Resource generate(MetaModelStructure metaModelStructure, ModelStructure modelStructure){
		//build the actual model via dynamic EMF
		ModelBuilder builder = new ModelBuilder();
		return builder.buildModel(metaModelStructure, modelStructure);
	}
	
	public static void main(String[] args) {
		//do some testruns...

		new ModelGenerator().generate(ModelGeneratorOptions.defaultValue());
	}
	@Override
	public Resource generate(Object options) {
		if(options instanceof ModelGeneratorOptions){
			MetaModelStructure metaModel = generateMetaModelStructure((ModelGeneratorOptions) options);
			ModelStructure modelStructure = generateModelStructure(metaModel, (ModelGeneratorOptions)options);
			return generate(metaModel, modelStructure);
		}
		return null;
	}
}
