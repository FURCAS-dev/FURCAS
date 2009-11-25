/**
 * 
 */
package de.hpi.sam.bp2009.testframework.generator.dynamicemf;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * @author martin.hanysz
 *
 */
public class ModelGeneratorOptions extends OptionObject{
	static class EReferenceOption{
		EReference reference;
		int maxOccurences;
		int minOccurences;
		int absOccurences;
		EReferenceOption(EReference e, int min, int max, int abs){
			reference=e;
			maxOccurences=max;
			minOccurences=min;
			absOccurences=abs;
			assert(min<max);
			assert(min<abs);
		}
	}
	static class EAttributeOption{
		EAttribute attribute;
		int maxOccurences;
		int minOccurences;
		int absOccurences;
		EAttributeOption(EAttribute e, int min, int max, int abs){
			attribute=e;
			maxOccurences=max;
			minOccurences=min;
			absOccurences=abs;
			assert(min<max);
			assert(min<abs);
		}
	}
	static class MetaClass{
		int maxInstances;
		int minInstances;
		MetaClass(int min, int max){
			maxInstances=max;
			minInstances=min;
			assert(min<max);
		}
	}
	
	ArrayList<EReferenceOption> referenceOptions= new ArrayList<EReferenceOption>();
	ArrayList<EAttributeOption> attributeOptions= new ArrayList<EAttributeOption>();
	ArrayList<MetaClass> metaClassOptions= new ArrayList<MetaClass>();
	
	public static OptionObject defaultValue() {
		
		ModelGeneratorOptions options = new ModelGeneratorOptions();
		
		EReference ref1 = EcoreFactory.eINSTANCE.createEReference();
		ref1.setLowerBound(1);
		ref1.setUpperBound(10);
		
		EReference ref2 = EcoreFactory.eINSTANCE.createEReference();
		ref2.setLowerBound(1);
		ref2.setUpperBound(1);
		ref2.setContainment(true);
		options.referenceOptions.add(new EReferenceOption(ref1, 2,3,3));
		options.referenceOptions.add(new EReferenceOption(ref2, 6,8,7));

		EAttribute attr1 = EcoreFactory.eINSTANCE.createEAttribute();
		attr1.setEType(EcorePackage.eINSTANCE.getEFloat());
		attr1.setDefaultValue(2.9);
		
		EAttribute attr2 = EcoreFactory.eINSTANCE.createEAttribute();
		attr2.setEType(EcorePackage.eINSTANCE.getEString());
		attr2.setDefaultValue("Hallo Welt!");
		
		EAttribute attr3 = EcoreFactory.eINSTANCE.createEAttribute();
		attr3.setEType(EcorePackage.eINSTANCE.getEInt());
		attr3.setDefaultValue(100);
		
		options.attributeOptions.add(new EAttributeOption(attr1, 3, 4,90 ));
		options.attributeOptions.add(new EAttributeOption(attr2, 3, 9,10 ));
		options.attributeOptions.add(new EAttributeOption(attr3, 0, 4,30 ));
		
		options.metaClassOptions.add(new MetaClass(10, 100));
		options.metaClassOptions.add(new MetaClass(1, 1000));
		options.metaClassOptions.add(new MetaClass(100, 101));
		options.metaClassOptions.add(new MetaClass(1000, 2000));
		options.metaClassOptions.add(new MetaClass(1, 4000));	
		
		return options;
	}
	
	
}
