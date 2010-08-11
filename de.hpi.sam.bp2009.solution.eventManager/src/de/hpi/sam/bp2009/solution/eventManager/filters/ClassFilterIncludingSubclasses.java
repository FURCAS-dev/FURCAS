package de.hpi.sam.bp2009.solution.eventManager.filters;

import org.eclipse.emf.ecore.EClass;

public class ClassFilterIncludingSubclasses extends ClassFilter {

    public ClassFilterIncludingSubclasses(EClass clazz, boolean negated) {
        super(clazz, negated);
    }
    @Override
    protected boolean matches(EClass cls) {
        if (super.matches(cls)) {
            return true;
        }
        return cls.getEAllSuperTypes().contains(getWantedClass());
        
    }
    @Override
    public int hashCode() {
        return 2*super.hashCode();
    }
    @Override
    public ClassFilterIncludingSubclasses clone() {
        return new ClassFilterIncludingSubclasses(getWantedClass(), isNegated());
        
    }
    @Override
    public String toString() {
        if (getWantedClass() != null)
            return "wantedClass conformsTo " + getWantedClass().toString();
        return "empty ClassFilter";
    }
}
