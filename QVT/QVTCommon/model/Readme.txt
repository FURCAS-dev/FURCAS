The ./model folder contains the QVT metamodel. 

If you regenerate model code of the QVT metamodel, delete all contents of the srcgen folder, copy OCLCommon/model/SemanticsOcl.ecore into this directory, generate model code and apply following patches to the generated code: 

*Add following methods to de.ikv.medini.qvt.model.qvtbase.impl.TypedModelImpl:

	public int hashCode() {
		if (this.getName() == null) {
			return 0;
		}
		return this.getName().hashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof TypedModel) {
			TypedModel t = (TypedModel) obj;
			if (this.getName() != null && this.getName().equals(t.getName())) {
				// TODO: Include type when comparing
				/*
				 * if (this.getType().equals(t.getType())) return true; else return false;
				 */
				return true;
			}
		}
		return false;
	} 
 


*de.ikv.medini.qvt.model.qvtbase.QvtBasePackage: Since FunctionParameter inherits the attribute "type" twice (from VariableDeclaration and from Parameter), there are two occurences of the following line, from which you have to delete exactly one:

	int FUNCTION_PARAMETER__NAME = BridgePackage.PARAMETER__NAME;

*delete generated org.oslo.ocl20.semantics* packages in srggen folder 