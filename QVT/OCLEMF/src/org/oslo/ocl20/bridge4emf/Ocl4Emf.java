package org.oslo.ocl20.bridge4emf;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import uk.ac.kent.cs.kmf.util.ConsoleLog;
import uk.ac.kent.cs.kmf.util.ILog;

/**
 * @author dha
 */
public class Ocl4Emf {
	public static EmfOclProcessorImpl processor = null;

	/**
	 * Initialise the model
	 */
	public static void InitModel(String basePackage, String packageName, String modelName, ILog log) {
		// Use reflection to initialize the model
		try {
			// Compute the name of modelNamePackage and modelNamePackageImpl
			// String offset = modelName;
			String interfaceName = modelName + "Package";
			String className = interfaceName + "Impl";
			String fullInterfaceName = basePackage + "." + packageName + "." + interfaceName;
			String fullClassName = basePackage + "." + packageName + ".impl." + className;

			// Get the interface and the class
			Class interf = Class.forName(fullInterfaceName);
			Class cls = Class.forName(fullClassName);

			// Initialize the model
			// LibraryPackageImpl.init();
			Method init = cls.getMethod("init", new Class[] {});
			init.invoke(null, new Object[] {});
			Map registry = EPackage.Registry.INSTANCE;
			// String enterpiseURI = LibraryPackage.eNS_URI;
			Field field = interf.getField("eNS_URI");
			String enterpiseURI = (String) field.get(null);
			EPackage model = (EPackage) registry.get(enterpiseURI);
			InitModel(model, log);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void InitModel(EPackage model, ILog log) {
		processor = new EmfOclProcessorImpl(log);
		processor.addMetaModel(model);
	}

	public static void main(String[] args) {
		System.out.println("test0");
		processor = new EmfOclProcessorImpl(new ConsoleLog());
		// processor.evaluate("context Integer def: inc() : Integer = self + 1  context OclVoid inv: 1.inc()");
		System.out.println(processor.evaluate(
		    "context Integer def: inc() : Integer = self + 1  context OclVoid inv: 1.inc()").toString());
		System.out.println("test1");
	}
}
