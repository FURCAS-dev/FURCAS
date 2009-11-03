package org.oslo.ocl20.synthesis;

import java.util.Set;

/**
 * 
 * @author Octavian Patrascoiu
 *
 */
public interface RuntimeEnvironment {
	public RuntimeEnvironment getParent();
	public void setParent(RuntimeEnvironment p);

	public Object getValue(String name);
	public void setValue(String name, Object value);
	public Set getKeys();

	public RuntimeEnvironment newEnvironment();
}
