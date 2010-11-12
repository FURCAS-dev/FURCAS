/**
 * <copyright>
 * 
 * Copyright (c) 2007,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: LabelGeneratorRegistry.java,v 1.2 2010/04/08 06:27:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.common.label;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ocl.examples.common.label.ILabelGenerator.Descriptor;
import org.eclipse.ocl.examples.common.label.generators.ENamedElementLabelGenerator;
import org.eclipse.ocl.examples.common.label.generators.EObjectLabelGenerator;
import org.eclipse.ocl.examples.common.label.generators.EcoreURILabelGenerator;
import org.eclipse.ocl.examples.common.label.generators.StringLabelGenerator;


/**
 * DebugString supports generation of debug identification of objects, determining a name usuing
 * the following alternatives.
 * <br>The null object is identified as <null-Object>
 * <br>Implementers of IDebugString are identified by IDebugString.toDebugString();
 * <br>MethodCall registrations in DebugUtils are identified by MethodCall.invoke().
 * <br>Other objects are identified as <unknown-'class-name' 'object.toString()'>
 * <p>
 * MethodCall registrations may be made via registerInstanceMethod or registerStaticMethod.
 * <p>
 * A debug string may be obtained via DebugString.toDebug(object).
 * <p>
 * DebugString providers string formatters for simple classes such as String, Number, Boolean
 * and Ecore components such as EObject, Resource and ResourceSet.
 * <p>
 * User extensions should be registered prior to use. Beware that late registration can
 * give misleading results since in the absence of an exact MethodCall registration the
 * class hierarchy is search first for base classes then for instances for which there
 * is an exact MethodCall match. This result is then cached and so may occlude a late
 * registration.
 */
public class LabelGeneratorRegistry implements ILabelGenerator.Registry
{	
	public static String debugLabelFor(Object object) {
		Map<ILabelGenerator.Option<?>, Object> options = new HashMap<ILabelGenerator.Option<?>, Object>();
		options.put(ILabelGenerator.Builder.SHOW_CLASS_SIMPLE_NAME, Boolean.TRUE);
		ILabelGenerator.Builder result = new DefaultLabelGeneratorBuilder(INSTANCE, options);
		result.buildLabelFor(object);
		return result.toString();
	}

	public static void initialize(ILabelGenerator.Registry registry) {
		ENamedElementLabelGenerator.initialize(registry);
		EObjectLabelGenerator.initialize(registry);
		EcoreURILabelGenerator.initialize(registry);
		StringLabelGenerator.initialize(registry);
	}

	protected final ILabelGenerator.Registry delegate;
	private final Map<String, Object> map = new HashMap<String, Object>();
	
	/**
	 * Construct a registry that resolves label generators locally.
	 */
	public LabelGeneratorRegistry() {
		this.delegate = null;
	}
	
	/**
	 * Construct a registry that resolves label generators locally when possible
	 * but which delegates to delegate otherwise.
	 */
	public LabelGeneratorRegistry(ILabelGenerator.Registry delegate) {
		this.delegate = delegate;
	}

	public <T> void buildLabelFor(ILabelGenerator.Builder s, T labelledObject) {
		if (labelledObject == null) {
			s.appendString("<null-Object>");
			return;
		}
		Boolean showClassName = s.getOption(ILabelGenerator.Builder.SHOW_CLASS_NAME);
		if ((showClassName != null) && showClassName) {
			s.appendString(labelledObject.getClass().getName());
			s.appendString(" ");
		}
		else {
			Boolean showClassSimpleName = s.getOption(ILabelGenerator.Builder.SHOW_CLASS_SIMPLE_NAME);
			if ((showClassSimpleName != null) && showClassSimpleName) {
				s.appendString(labelledObject.getClass().getSimpleName());
				s.appendString(" ");
			}			
		}
		if (labelledObject instanceof ILabelGenerator.Self) {
			((ILabelGenerator.Self)labelledObject).buildLabel(s);
			return;
		}
		buildSubLabelFor(s, labelledObject);
	}

	public <T> void buildSubLabelFor(ILabelGenerator.Builder labelBuilder, T labelledObject) {
		if (labelledObject == null) {
			labelBuilder.appendString("<null-Object>");
			return;
		}
		ILabelGenerator<?> labelGenerator = get(labelledObject.getClass());
		if (labelGenerator == null) {
			labelGenerator = getLabelGenerator(labelledObject.getClass());
			if (labelGenerator != null)
				install(labelledObject.getClass(), labelGenerator);
		}
		if (labelGenerator != null) {
			@SuppressWarnings("unchecked")
			ILabelGenerator<T> castLabelGenerator = (ILabelGenerator<T>) labelGenerator;
			castLabelGenerator.buildLabelFor(labelBuilder, labelledObject);
			return;
		}
		else
			getLabelGenerator(labelledObject.getClass());		// Debugging
		labelBuilder.appendString("<unknown-");
		labelBuilder.appendString(labelledObject.getClass().getSimpleName());
		labelBuilder.appendString(" ");
		labelBuilder.appendString(labelledObject.toString());
		labelBuilder.appendString(">");
	}
	
  	public ILabelGenerator.Builder createDefaultLabelBuilder(Map<ILabelGenerator.Option<?>, Object> options) {
  		return new DefaultLabelGeneratorBuilder(this, options);
  	}
    
	public ILabelGenerator<?> get(String labelledClass) {
		Object object = map.get(labelledClass);
		if (object instanceof ILabelGenerator.Descriptor) {
			object = ((ILabelGenerator.Descriptor)object).getLabelGenerator();
			map.put(labelledClass, object);
		}
		if (object != null) {
			return (ILabelGenerator<?>)object;
		}
		else if (delegate != null) {
			return delegate.get(labelledClass);			
		}
		else {
			return null;
		}
	}

	public ILabelGenerator<?> get(Class<?> labelledClass) {
		return get(labelledClass.getName());
	}

	protected ILabelGenerator<?> getLabelGenerator(Class<?> cls) {
		for (Class<?> sCls = cls; sCls != null; sCls = sCls.getSuperclass()) {
			ILabelGenerator<?> labelGenerator = get(sCls);
			if (labelGenerator != null)
				return labelGenerator;	
		}
		for (Class<?> iCls : cls.getInterfaces()) {
			ILabelGenerator<?> labelGenerator = get(iCls);
			if (labelGenerator != null)
				return labelGenerator;	
		}
		for (Class<?> iCls : cls.getInterfaces()) {
			ILabelGenerator<?> labelGenerator = getLabelGenerator(iCls);
			if (labelGenerator != null)
				return labelGenerator;	
		}
		Class<?> sCls = cls.getSuperclass();
		if (sCls != null)
			return getLabelGenerator(sCls);
		return null;
	}

	public Object install(String labelledClass, Descriptor labelDescriptor) {
		return map.put(labelledClass, labelDescriptor);
	}

	public Object install(String labelledClass, ILabelGenerator<?> labelGenerator) {
		return map.put(labelledClass, labelGenerator);
	}

	public Object install(Class<?> labelledClass, ILabelGenerator<?> labelGenerator) {
		return map.put(labelledClass.getName(), labelGenerator);
	}

	public String labelFor(Object labelledObject) {
		ILabelGenerator.Builder labelBuilder = createDefaultLabelBuilder(null);
		labelBuilder.buildLabelFor(labelledObject);
		return labelBuilder.toString();
	}

	public String labelFor(Object labelledObject, Map<ILabelGenerator.Option<?>, Object> options) {
		ILabelGenerator.Builder labelBuilder = createDefaultLabelBuilder(options);
		labelBuilder.buildLabelFor(labelledObject);
		return labelBuilder.toString();
	}

	public Object uninstall(String labelledClass) {
		return map.remove(labelledClass);
	}
}