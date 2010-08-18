package ocljmi;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;

import uk.ac.kent.cs.kmf.util.ConsoleLog;
import uk.ac.kent.cs.kmf.util.ILog;



/**
 * @author dha
 *
 */
public class Ocl4Jmi {
	public static JmiOclProcessorImpl processor = null;

	/** 
	 * Initialise the model 
	 * */
	public static void InitModel(String basePackage, String packageName, String modelName, ILog log) {		
		// Use reflection to initialize the model
		try {
			// Compute the name of modelNamePackage and modelNamePackageImpl
			//String offset = modelName;
//			String interfaceName = modelName+"Package";
//			String className = interfaceName+"Impl";
//			String fullInterfaceName = basePackage+"."+packageName+"."+interfaceName;
//			String fullClassName = basePackage+"."+packageName+".impl."+className;
//
//			// Get the interface and the class
//			Class interf = Class.forName(fullInterfaceName);
//			Class cls = Class.forName(fullClassName);
//			
//			// Initialize the model
//			// LibraryPackageImpl.init();
//			Method init = cls.getMethod("init", new Class[] {});
//			init.invoke(null, new Object[] {});
//			//Epackage.Registery.INSTANCE
//			Map registry = MofPackage.Registry.INSTANCE;
//			// String enterpiseURI = LibraryPackage.eNS_URI;
//			Field field = interf.getField("eNS_URI");
//			String enterpiseURI = (String)field.get(null);
			EPackage model = null;//TODO: getMofPackage by name
			InitModel(model, log);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void InitModel(EPackage model, ILog log) {
		processor = new JmiOclProcessorImpl(log, ((EObject)model).get___Connection());
		processor.addMetaModel(model);
	}
	
	public static void main(String[] args) {
		System.out.println("test0");
		processor = new JmiOclProcessorImpl(new ConsoleLog(), getConnection());
//		processor.evaluate("context Integer def: inc() : Integer = self + 1  context OclVoid inv: 1.inc()");
		System.out.println(processor.evaluate("context Integer def: inc() : Integer = self + 1  context OclVoid inv: 1.inc()").toString());
		System.out.println("test1");
	}

	private static ResourceSet getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
}
