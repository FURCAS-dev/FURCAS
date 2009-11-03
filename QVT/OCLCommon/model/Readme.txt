The ./model folder contains the OCL metamodel. 

If you regenerate model code of the OCL metamodel, delete all contents of the srcgen folder, generate model code and apply following patches to the generated code: 

*Replace the declaration of org.oslo.ocl20.semantics.bridge.impl.EnvironmentImpl/namedElementEntrys to
	protected Map namedElementEntrys = new HashMap();
 
 
