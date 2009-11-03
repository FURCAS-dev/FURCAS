package org.oslo.ocl20.bridge4emf;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.bridge.Environment;
import org.oslo.ocl20.semantics.bridge.ModelElement;
import org.oslo.ocl20.semantics.bridge.Namespace;
import org.oslo.ocl20.semantics.bridge.impl.EnvironmentImpl;

/**
 * @author dha
 */
public class NamespaceImpl extends org.oslo.ocl20.semantics.bridge.impl.NamespaceImpl implements Namespace {

	protected OclProcessor processor = null;

	public NamespaceImpl(EPackage ePkg, OclProcessor proc) {
		this.processor = proc;
		this._ePkg = ePkg;
	}

	EPackage _ePkg;

	Map _elements = new HashMap();

	/**
	 * Returns the package name of the given package including all "dummy" packages (i.e. package
	 * for which no EPackage instance exists) as prefix
	 * 
	 * @param ePackage
	 * @return
	 */
	public static String getCompoundPackageName(EPackage ePackage) {
		String result = ePackage.getName();
		return result;
	}

	/**
	 * Reconstructs a suitable full qualified package name in the form "a.b.c" of the given package
	 * from the package URI and namespace prefix
	 * 
	 * @param ePackage
	 * @return the name or <code>null</code> if package URI cannot be analyzed in a sensefull way
	 */
	private static String extractSuitableName(EPackage ePackage) {
		String result = ePackage.getNsURI();
		if (result.endsWith(".ecore")) {
			result = result.substring(0, result.length() - ".ecore".length());
		}
		if (!result.endsWith(ePackage.getName())) {
			return null;
		}
		int slashslash = result.lastIndexOf("//");
		if (slashslash != -1) {
			result = result.substring(slashslash + "//".length());
		}
		result = result.replace("/", EnvironmentImpl.COMPOUND_PACKAGE_SEPARATOR);
		String nsPrefix = ePackage.getNsPrefix().replace(".", EnvironmentImpl.COMPOUND_PACKAGE_SEPARATOR);
		if (result.endsWith(nsPrefix)) {
			return nsPrefix;
		}
		return result;
	}

	@Override
	public ModelElement lookupOwnedElement(String name) {
		ModelElement mel = (ModelElement) this._elements.get(name);
		if (mel == null) {
			EClassifier ecl = this._ePkg.getEClassifier(name);
			if (ecl == null) {
				for (Object element : this._ePkg.getESubpackages()) {
					EPackage pp = (EPackage) element;
					if (name.equals(NamespaceImpl.getCompoundPackageName(pp))) {
						mel = this.processor.getBridgeFactory().buildNamespace(pp);
						this._elements.put(name, mel);
						return mel;
					}
				}
				return null;
			} else {
				mel = this.processor.getBridgeFactory().buildClassifier(ecl);
				this._elements.put(name, mel);
			}
		}
		return mel;
	}

	// --- Namespace ---

	Namespace _namespace = null;

	@Override
	public Namespace getNamespace() {
		if (this._namespace == null) {
			this._namespace = new NamespaceImpl(this._ePkg.getESuperPackage(), this.processor);
		}
		return this._namespace;
	}

	@Override
	public void setNamespace(Namespace n) {
		this._namespace = n;
	}

	/**
	 * @see ocl20.bridge.Namespace#getEnvironmentWithoutParents()
	 */
	@Override
	public Environment getEnvironmentWithoutParents() {
		Environment env = this.processor.getBridgeFactory().buildEnvironment();
		env.addNamespace(this);
		env.setParent(null);
		return env;
	}

	/**
	 * @see ocl20.bridge.Namespace#getEnvironmentWithParents()
	 */
	@Override
	public Environment getEnvironmentWithParents() {
		if (this.getNamespace() == null) {
			return null;
		} else {
			Environment result = this.getEnvironmentWithoutParents();
			result.setParent(this.getNamespace().getEnvironmentWithParents());
			return result;
		}
	}

	/**
	 * @see ocl20.bridge.ModelElement#getName()
	 */
	@Override
	public String getName() {
		return NamespaceImpl.getCompoundPackageName(this._ePkg);
	}

	@Override
	public String getFullName(String sep) {
		String name = "";
		EPackage pkg = this._ePkg.getESuperPackage();
		while (pkg != null) {
			if (!name.equals("")) {
				name = sep + name;
			}
			name = NamespaceImpl.getCompoundPackageName(pkg) + name;
			pkg = pkg.getESuperPackage();
		}
		if (!name.equals("")) {
			name += sep;
		}
		return name + NamespaceImpl.getCompoundPackageName(this._ePkg);
	}

	/**
	 * @see ocl20.bridge.ModelElement#setName(String)
	 */
	@Override
	public void setName(String name) {
	}

	/**
	 * @see ocl20.ocl20Visitable#accept(ocl20Visitor, Object)
	 */
	public Object accept(SemanticsVisitor v, Object obj) {
		return v.visit(this, obj);
	}

	@Override
	public Object clone() {
		return new NamespaceImpl(this._ePkg, this.processor);
	}

	@Override
	public Object getDelegate() {
		return this._ePkg;
	}
}
