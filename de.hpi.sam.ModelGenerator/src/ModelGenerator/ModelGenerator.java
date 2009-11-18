package ModelGenerator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

public class ModelGenerator{
	public void generateMetaModel(int numberOfClasses, EReference[] referenceTypes,
									int[][] numberOfReferences, EAttribute[] attributeTypes,
									int[][] numberOfAttributes ){
		//get a copier that resolves proxies
		Copier copier = new Copier(true);
		
		//generate the meta model structure
		MetaModelStructure metaModel = new MetaModelStructure();
		metaModel.createClasses(numberOfClasses);
		for(int i = 0; i < (referenceTypes.length); i++){
			//create all the references and associate them according to min and max values
			for(int j = 0; j < numberOfReferences[i][0]; j++){
				int source = metaModel.getSourceClass(numberOfReferences[i][1], numberOfReferences[i][2]);
				int target = metaModel.getTargetClass();
				EObject reference = copier.copy(referenceTypes[i]);
				metaModel.addReferenceToClass((EReference)reference, source, target);
			}
		}
		for(int i = 0; i < (attributeTypes.length); i++){
			//create all the attributes and associate them according to min and max values
			for(int j = 0; j < numberOfAttributes[i][0]; j++){
				int source = metaModel.getAttributeClass(numberOfAttributes[i][1], numberOfAttributes[i][2]);
				EObject attribute = copier.copy(attributeTypes[i]);
				metaModel.addAttributeToClass((EAttribute)attribute, source);
			}
		}
	}
}
