package qvtjmi;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;



public class PartitionHelper {
	public static Resource getPartition(EObject object) {
		return ((EObject)object).eResource();
	}
	
	public static void addToPartion(EObject object) {
	}
}
