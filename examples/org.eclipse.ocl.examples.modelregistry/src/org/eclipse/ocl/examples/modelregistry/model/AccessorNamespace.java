/**
 * 
 */
package org.eclipse.ocl.examples.modelregistry.model;

public abstract class AccessorNamespace<A extends Accessor<A>> implements Accessor.Namespace<A>
{
	protected final String name;
	
	public AccessorNamespace(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}