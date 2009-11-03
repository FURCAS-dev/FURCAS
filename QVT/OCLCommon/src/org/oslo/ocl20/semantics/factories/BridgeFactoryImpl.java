package org.oslo.ocl20.semantics.factories;

import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.bridge.Environment;
import org.oslo.ocl20.semantics.bridge.ModelElement;
import org.oslo.ocl20.semantics.bridge.NamedElement;
import org.oslo.ocl20.synthesis.CreationHelper;


abstract public class BridgeFactoryImpl implements BridgeFactory {
	protected OclProcessor processor=null;
	public OclProcessor getProcessor() {return processor;}
	public BridgeFactoryImpl(OclProcessor proc) {
		this.processor = proc;
	}
	/** Build a namedElement */
	public NamedElement buildNamedElement(String name, ModelElement referred_element, Boolean imp) {
		return CreationHelper.createNamedElement(name, referred_element, imp);
	}
	
	/** Build an environment */
	public Environment buildEnvironment() {
		return CreationHelper.createEnvironment(this);
	}
}
