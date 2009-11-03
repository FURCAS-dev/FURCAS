The ./modelsyntax folder contains the syntax metamodel for both OCL and QVT. 

If you regenerate model code from Syntax.genmodel, apply following patches to the generated code: 

*In org.oslo.ocl20.syntax.ast.qvt.impl.FactoryImpl, delete the method with the signature
 
	public static org.oslo.ocl20.syntax.ast.qvt.Package getPackage()
 
 
