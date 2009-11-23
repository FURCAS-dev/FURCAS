package ModelGenerator;

import java.util.Random;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;

public class ModelGenerator{
	
	private static Random random = new Random();
	
	
	public MetaModelStructure generateMetaModelStructure(int numberOfClasses,
												EReference[] referenceTypes,
												int[][] numberOfReferences,
												EAttribute[] attributeTypes,
												int[][] numberOfAttributes ){
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
		MetaModelStructure metaModel = new MetaModelStructure(numberOfClasses);
		for(int i = 0; i < (referenceTypes.length); i++){
			//create all the references and associate them according to min and max values
			for(int j = 0; j < numberOfReferences[i][0]; j++){
				int source = metaModel.getSourceClass(numberOfReferences[i][1], numberOfReferences[i][2]);
				int target = metaModel.getTargetClass();
				metaModel.addReferenceToClass(referenceTypes[i], source, target);
			}
		}
		for(int i = 0; i < (attributeTypes.length); i++){
			//create all the attributes and associate them according to min and max values
			for(int j = 0; j < numberOfAttributes[i][0]; j++){
				int source = metaModel.getAttributeClass(numberOfAttributes[i][1], numberOfAttributes[i][2]);
				metaModel.addAttributeToClass(attributeTypes[i], source);
			}
		}
		return metaModel;
	}
	public ModelStructure generateModelStructure(MetaModelStructure metaModel,
										int[][] numberOfClasses,
										int[][] numberOfReferences,
										int[][] numberOfAttributes){
		//parameter description:
		//metaModel: the generated MetaModelStructure to generate a ModelStructure for
		//numberOfClasses: 2 dim. array to specify the number of instances of classes of the meta model
		//				[i][0] holds the maximum number of instances of the class i of the meta model
		//				[i][1] holds the minimum number of instances of the class i of the meta model
		//numberOfReferences: same as numberOfClasses just for references
		//numberOfAttributes: same as numberOfClasses just for attributes
		
		ModelStructure model = new ModelStructure(metaModel);
		for (int i = 0; i < numberOfClasses.length; i++){
			int numberOfInstances = random.nextInt(numberOfClasses[i][0]-numberOfClasses[i][1]);
			for (int j = 0; j < numberOfInstances; j++){
				model.addClass(i);				
			}
		}
		for (int i = 0; i < numberOfAttributes.length; i++){
			EAttribute attribute = metaModel.attributes.get(i).attributeType;
			int numberOfInstances = random.nextInt(numberOfAttributes[i][0]-numberOfAttributes[i][1]);
			for (int j = 0; j < numberOfInstances; j++){
				int owner = model.getAttributeOwner(attribute);
				model.addAttribute(attribute, owner);				
			}
		}
		for (int i = 0; i < numberOfReferences.length; i++){
			EReference reference = metaModel.references.get(i).referenceType;
			int numberOfInstances = random.nextInt(numberOfReferences[i][0]-numberOfReferences[i][1]);
			for (int j = 0; j < numberOfInstances; j++){
				int source = model.getReferenceSource(reference);
				int target = model.getReferenceTarget(reference);
				model.addReference(reference, source, target);				
			}
		}
		return model;
	}
	
	public void buildModel(MetaModelStructure metaModelStructure, ModelStructure modelStructure){
		//build the actual model via dynamic EMF
		ModelBuilder builder = new ModelBuilder();
		builder.buildModel(metaModelStructure, modelStructure);
	}
}
