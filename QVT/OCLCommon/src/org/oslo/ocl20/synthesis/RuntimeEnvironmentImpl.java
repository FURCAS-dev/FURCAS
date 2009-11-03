package org.oslo.ocl20.synthesis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Octavian Patrascoiu
 *
 */

public class RuntimeEnvironmentImpl 
	implements RuntimeEnvironment
{
	public RuntimeEnvironmentImpl() {
		bindings = new HashMap();
	}

	private RuntimeEnvironment parent;
	public RuntimeEnvironment getParent() {
		return parent;
	}
	public void setParent(RuntimeEnvironment p) {
		parent = p;
	}

	private Map bindings;
	public Set getKeys() {
		return bindings.keySet();
	}
	public Object getValue(String name) {
		Object value = bindings.get(name);
		if (value == null) {
			if (parent != null) value = parent.getValue(name);
		}
		return value;
	}
	public void setValue(String name, Object value) {
		bindings.put(name, value);
	}
	
	public RuntimeEnvironment newEnvironment() {
		RuntimeEnvironment newEnv = new RuntimeEnvironmentImpl();
		newEnv.setParent(this);
		return newEnv;
	}
}
