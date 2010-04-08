/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 E.D.Willink and others.
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
 * $Id: ILabelGenerator.java,v 1.2 2010/04/08 06:27:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.common.label;

import java.util.Map;

/**
 * ILabelGenerator provides an extensible capability to derive a customized text string
 * for an object. This is typically used to provide debug or UI descriptions of objects.
 * <p>
 * Extensibility is provided by registering new label generators with the registry to
 * support additional classes. These may be registered automatically through use of the
 * <code>org.eclipse.ocl.examples.common.label_generator</code>
 * extension point. 
 * <p>
 * Minor customization can be achieved by using a modified Builder to build the label.
 * The builder can be parameterised by options.
 * <p>
 * Full customization can be achieved by using an alternate Registry with completely
 * different label generators..
 */
public interface ILabelGenerator<T>
{
	/**
	 * An ILabelGenerator.Builder may have options with an associated typed value.
	 */
	interface Option<T> {}
	
	/**
	 * An ILabelGenerator.Builder (typically realised by a StringBuilder)
	 * builds the generated label. The formatting may have options.
	 */
	interface Builder
	{
		
		/**
		 * If the SHOW_CLASS_NAME option is present and true, the value of object.getClass().getName()
		 * is prefixed to the formatted description of each object.
		 */
		static final Option<Boolean> SHOW_CLASS_NAME = new Option<Boolean>() {};
		
		/**
		 * If the SHOW_CLASS_SIMPLE_NAME option is present and true, the value of object.getClass().getSimpleName()
		 * is prefixed to the formatted description of each object.
		 */
		static final Option<Boolean> SHOW_CLASS_SIMPLE_NAME = new Option<Boolean>() {};
		
		/**
		 * Append the generated label of an object to the overall generated label.
		 * 
		 * @param object to be appended.
		 */
		void appendObject(Object object);
		void appendString(String string);
		void buildLabelFor(Object labelledObject);
		<T> T getOption(Option<T> option);
		Registry getRegistry();
		<T> void setOption(Option<T> option, T value);
	}
	
    /**
     * An <code>ILabelGenerator.Descriptor</code> may be used by the {@link ILabelGenerator.Registry}
     * to defer loading of the labelled class until an instance needs a label.
     */
    interface Descriptor
    {
    	ILabelGenerator<?> getLabelGenerator();
    }

    /**
     * An <code>ILabelGenerator.Registry</code> maintains a mapping from the
     * class name to be labelled and the label generator that can build its
     * label. The global <code>INSTANCE</code> is populated by the
     * <code>org.eclipse.ocl.examples.common.label_generator</code>
     * extension point.
     */
   interface Registry
    {
    	Registry INSTANCE = new LabelGeneratorRegistry();
    	
       	<T> void buildLabelFor(ILabelGenerator.Builder labelBuilder, T labelledObject);
    	<T> void buildSubLabelFor(ILabelGenerator.Builder labelBuilder, T labelledObject);
    	ILabelGenerator<?> get(String labelledClass);
    	Object install(Class<?> labelledClass, ILabelGenerator<?> labelGenerator);
    	Object install(String labelledClass, ILabelGenerator<?> labelGenerator);
    	Object install(String labelledClass, ILabelGenerator.Descriptor labelDescriptor);
       	String labelFor(Object labelledObject);
       	String labelFor(Object labelledObject, Map<ILabelGenerator.Option<?>, Object> options);
    	Object uninstall(String labelledClass);
    }

	/**
	 * Self defines the interface of an object able to label itself.
	 */
	public interface Self
	{
		public void buildLabel(ILabelGenerator.Builder labelBuilder);
	}

    void buildLabelFor(Builder labelBuilder, T labelledObject);
}