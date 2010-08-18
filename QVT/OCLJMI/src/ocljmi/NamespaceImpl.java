package ocljmi;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.naming.NameNotFoundException;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.Environment;
import org.oslo.ocl20.semantics.bridge.ModelElement;
import org.oslo.ocl20.semantics.bridge.Namespace;





/**
 * @author dha
 *
 */
public class NamespaceImpl extends org.oslo.ocl20.semantics.bridge.impl.NamespaceImpl implements Namespace {

	protected OclProcessor processor=null;

	public NamespaceImpl(EPackage mofPkg, OclProcessor proc) {
		this.processor = proc;
		_mofPkg = mofPkg;
	}

	EPackage _mofPkg;

	Map _elements = new HashMap();
	public ModelElement lookupOwnedElement(String name) {
		ModelElement mel = (ModelElement) _elements.get(name);
		if (mel == null) {
			Classifier ecl = null;
			try {
				//*******************bearbeit spaeter***********************
				EModelElement el = _mofPkg.lookupElement(name);
				if(el instanceof Classifier)
					ecl = (Classifier)el; 
			} catch (NameNotFoundException e) {
				//throw new RuntimeException(e);
			}
			if (ecl == null) {
				//List Classifiers = _mofPkg.getContents()
				for (Iterator it=_mofPkg.eAllContents(); it.hasNext(); ) {
					
					EModelElement me=(EModelElement) it.next();
					if (me instanceof EPackage){
						EPackage pp=(EPackage) me;
					
						if (name.equals(pp.getName())) {
							mel = this.processor.getBridgeFactory().buildNamespace(pp);
							_elements.put(name, mel);
							return mel;
						}
					} else if(me instanceof EFactory) {
					    EPackage pp= (EPackage) ((EFactory) me).getImportedNamespace();
	                                        
                                            if (name.equals(pp.getName())) {
                                                    mel = this.processor.getBridgeFactory().buildNamespace(pp);
                                                    _elements.put(name, mel);
                                                    return mel;
                                            }
					}
				}
				return null;
			}
			else {
				mel = this.processor.getBridgeFactory().buildClassifier(ecl);
				_elements.put(name, mel);
			}
		}
		return mel;
	}
	//--- Namespace ---

	Namespace _namespace = null;
	public Namespace getNamespace() {
		if (_namespace == null)
			//*******************bearbeit spaeter***********************
			_namespace = new NamespaceImpl((EPackage) _mofPkg.eContainer(), this.processor);
		return _namespace;
	}
	public void setNamespace(Namespace n) {
		_namespace = n;
	}

	/**
	 * @see ocl20.bridge.Namespace#getEnvironmentWithoutParents()
	 */
	public Environment getEnvironmentWithoutParents() {
		Environment env = this.processor.getBridgeFactory().buildEnvironment();
		env.addNamespace(this);
		env.setParent(null);
		return env;
	}

	/**
	 * @see ocl20.bridge.Namespace#getEnvironmentWithParents()
	 */
	public Environment getEnvironmentWithParents() {
		if (this.getNamespace() == null) {
			return null;
		} else {
			Environment result = getEnvironmentWithoutParents();
			result.setParent(this.getNamespace().getEnvironmentWithParents());
			return result;
		}
	}

	/**
	 * @see ocl20.bridge.ModelElement#getName()
	 */
	public String getName() {
		return _mofPkg.getName();
	}

	public String getFullName(String sep) {
		String name = "";
		EPackage pkg = (EPackage) _mofPkg.eContainer();
		while (pkg != null) {
			if (!name.equals("")) name = sep+name;
			name = pkg.getName()+name;
			pkg = (EPackage) pkg.eContainer();
		}
		if (!name.equals("")) name += sep;
		return name+_mofPkg.getName();
	}
	/**
	 * @see ocl20.bridge.ModelElement#setName(String)
	 */
	public void setName(String name) {
	}

	/**
	 * @see ocl20.ocl20Visitable#accept(ocl20Visitor, Object)
	 */
	public Object accept(SemanticsVisitor v, Object obj) {
		return v.visit(this,obj);
	}

	public Object clone() {
		return new NamespaceImpl(_mofPkg, this.processor);
	}
	public Object getDelegate() {
		return _mofPkg;
	}
}
