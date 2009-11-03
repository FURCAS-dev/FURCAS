package org.oslo.ocl20.standard.lib;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.model.types.CollectionType;
import org.oslo.ocl20.semantics.model.types.TupleType;


abstract public class OclCollectionImpl
extends OclAnyImpl
implements OclCollection {
    protected OclCollectionImpl(Classifier eT, StdLibAdapter adapter) {
    	super(adapter);
        this._elementType = eT;
    }

    Classifier _elementType;
    public Classifier getElementType() {
        return this._elementType;
    }
    
	public Classifier getBaseElementType() {
		Classifier x = getElementType();
		if (x instanceof CollectionType)
			return ((CollectionType)x).getBaseElementType();
		return x;
	}

    abstract java.util.Collection implementation();

    // --- Impl ---
    public Object getImplementation() { return implementation(); }
    
    //--- ICollection ---
    public OclInteger size() {
        int size = implementation().size();
        return adapter.Integer(size);
    }
    public OclBoolean includes(Object object) {
        Iterator i = implementation().iterator();
        boolean found = false;
        while (i.hasNext())
            if (object.equals(i.next())) {
                found = true;
                break;
            }
        return adapter.Boolean(found);
    }
    public OclBoolean excludes(Object object) {
       return includes(object).not();
    }

    /* post: result = collection->iterate( elem; acc : Integer = 0 |
                                            if elem = object then acc + 1 else acc endif )
    */
    public OclInteger count(OclAny object) {
        int count = 0;
        Iterator i = implementation().iterator();
        while (i.hasNext())
            if (object.equals(i.next()))
                count++;
        return adapter.Integer(count);
    }

    public OclBoolean includesAll(OclCollection col) {
        Iterator i = ((Collection)col.getImplementation()).iterator();
        while (i.hasNext()) {
            OclAny o = (OclAny)i.next();
            if (((OclBooleanImpl)this.includes(o)) == OclBooleanImpl.TRUE) {
                //ok
            } else {
                return adapter.Boolean(false);
            }
        }
        return adapter.Boolean(true);
    }

    public OclBoolean excludesAll(OclCollection col) {
        Iterator i = ((Collection)col.getImplementation()).iterator();
        while (i.hasNext()) {
            OclAny o = (OclAny)i.next();
            if (((OclBooleanImpl)this.includes(o)) == OclBooleanImpl.TRUE) {
                return adapter.Boolean(false);
            } else {
//              ok
            }
        }
        return adapter.Boolean(true);
    }

    public OclBoolean isEmpty() {
        return adapter.Boolean(implementation().isEmpty());
    }

    public OclBoolean notEmpty() {
        return isEmpty().not();
    }

    /* post: result = collection->iterate( elem; acc : T = 0 | acc + elem ) */
    /* elem must have an operation 'add(T)' defined. */
    //T sum();
    public Object sum() {
        if (this.implementation().isEmpty())
            return adapter.Integer(0);

        Iterator i = implementation().iterator();
        Object first = i.next();

        Method addMethod = getAddMethod(first);
        if (addMethod != null) {
            Object acc = null;
            try {
                Method m = first.getClass().getMethod("clone", new Class[] {});
                acc = m.invoke(first, new Object[] {});
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (acc != null) {
                try {
                    while (i.hasNext()) {
                        OclAny next = (OclAny) i.next();
                        acc = addMethod.invoke(acc, new Object[] { next });
                    }
                    return acc;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return adapter.Undefined();
    }

    private Method getAddMethod(Object o) {
        Method[] meths = o.getClass().getMethods();
        for (int i = 0; i < meths.length; i++) {
            if (meths[i].getName().equals("add")) {
                if (meths[i].getParameterTypes().length == 1) {
                    Class x = meths[i].getParameterTypes()[0];
                    if (x.isAssignableFrom(o.getClass())) {
                        return meths[i];
                    }
                }
            }
        }
        return null;
    }

    public OclSet product(OclCollection col2) {
        Iterator i1 = this.implementation().iterator();
        Collection c2 = (java.util.Collection) col2.getImplementation();
        Set result = new LinkedHashSet();
        while (i1.hasNext()) {
            OclAny o1 = (OclAny) i1.next();
            Iterator i2 = c2.iterator();
            while (i2.hasNext()) {
                OclAny o2 = (OclAny) i2.next();
                String[] names = new String[] { "first", "second" };
                Classifier[] types = new Classifier[] { this.getElementType(), this.getElementType()};
                TupleType eT = adapter.getProcessor().getTypeFactory().buildTupleType(names,types);
                result.add(adapter.Tuple(eT, new OclAny[] { o1, o2 }));
            }
        }
        return adapter.Set(this.getElementType(), result);
    }

	public OclSequence asSequence() {
		return adapter.Sequence(this.getElementType(),implementation());
	}

	public OclSet asSet() {
		return adapter.Set(this.getElementType(), implementation());
	}
	
	public OclBag asBag() {
		return adapter.Bag(this.getElementType(), implementation());
	}
	
	public OclOrderedSet asOrderedSet() {
		return adapter.OrderedSet(this.getElementType(), implementation());
	}

    //--- Object ---
    abstract public Object clone();

}
