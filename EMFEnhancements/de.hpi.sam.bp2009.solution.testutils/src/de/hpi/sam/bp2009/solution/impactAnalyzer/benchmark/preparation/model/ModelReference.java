package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.model;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class ModelReference {
	private final EObject from;
	private final EObject to;
	private final EReference reference;
	
	public ModelReference(EObject from, EObject to, EReference reference) {
		this.from = from;
		this.to = to;
		this.reference = reference;
	}
	
	public EObject getFrom() {
		return from;
	}

	public EObject getTo() {
		return to;
	}

	public EReference getReference() {
		return reference;
	}
}
