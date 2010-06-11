package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.EcoreEvaluationEnvironment;

public class PartialEcoreEvaluationEnvironment extends EcoreEvaluationEnvironment {
    private final Map<String, Object> map = new HashMap<String, Object>();
    
    public PartialEcoreEvaluationEnvironment() {
        super();
    }
    
    public PartialEcoreEvaluationEnvironment(
            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
        super(parent);
    }

    /**
     * Returns the value associated with the supplied name. If no value has been set
     * previously, a {@link ValueNotFoundException} is thrown.
     * 
     * @param name
     *            the name whose value is to be returned
     * @return the value associated with the name
     */
    @Override
    public Object getValueOf(String name) {
        if (!map.containsKey(name)) {
            throw new ValueNotFoundException(name);
        }
        return map.get(name);
    }

    /**
     * Replaces the current value of the supplied name with the supplied value.
     * 
     * @param name
     *            the name
     * @param value
     *            the new value
     */
    public void replace(String name, Object value) {
        map.put(name, value);
    }

    /**
     * Adds the supplied name and value binding to the environment
     * 
     * @param name
     *            the name to add
     * @param value
     *            the associated binding
     */
    public void add(String name, Object value) {
        if (map.containsKey(name)) {
            String message = "The name: "+name+" already has a binding: "+map.get(name);
            throw new IllegalArgumentException(message);
        }
        map.put(name, value);
    }

    /**
     * Removes the supplied name and binding from the environment (if it exists)
     * and returns it.
     * 
     * @param name
     *            the name to remove
     * @return the value associated with the removed name
     */
    public Object remove(String name) {
        return map.remove(name);
    }

    /**
     * Clears the environment of variables.
     */
    public void clear() {
        map.clear();
    }

    /**
     * Returns a string representation of the bindings
     */
    @Override
    public String toString() {
        return map.toString();
    }

}
