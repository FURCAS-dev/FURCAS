/**
 * 
 */
package com.sap.furcas.runtime.common.interfaces;

import java.util.List;

/**
 * wraps an entity consisting of a reference to a metamodel element and its qualified name.
 */
public class ResolvedNameAndReferenceBean<EType> {

    private List<String> names;
    private EType reference;
    private List<String> operators;
    
    
    /**
     * @param name
     * @param reference
     */
    public ResolvedNameAndReferenceBean(List<String> name, EType reference) {
        super();
        if (name == null && reference == null) {
            throw new IllegalArgumentException("both arguments null not allowed");
        }
        this.names = name;
        this.reference = reference;
    }

    public ResolvedNameAndReferenceBean(List<String> names, EType reference,
            List<String> ops) {
        this(names, reference);
        this.operators = ops;
    }

    public List<String> getNames() {
        return names;
    }
    
    public List<String> getOperators() {
        return operators;
    }
    
    public String getNameUnqualified() {
        // return last element
        if (names != null && names.size() > 0) {
            return names.get(names.size()-1);
        } else {
            return null;
        }
    }
    
    public EType getReference() {
        return reference;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ResolvedNameAndReferenceBean) {
            ResolvedNameAndReferenceBean other = (ResolvedNameAndReferenceBean) obj;
            if (other.getNames() != null) {
                return other.getNames().equals(this.getNames());
            } else {
                return this.getNames() == null;
            }            
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getNames().toString() + "; isResolved = "+ (this.getReference() != null);
    }
    
    
    
}
