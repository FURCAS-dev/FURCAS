/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: LabelGeneratorRegistryReader.java,v 1.2 2010/04/08 06:27:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.common.plugin;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.ocl.examples.common.label.ILabelGenerator;

/**
 * A plugin extension reader that populates the
 * {@link ILabelGenerator.Registry#INSTANCE
 * global} label generator registry. Clients are not expected to use
 * this class directly.
 */
class LabelGeneratorRegistryReader extends RegistryReader
{
	static class LabelGeneratorDescriptor extends PluginClassDescriptor implements ILabelGenerator.Descriptor
	{
		protected ILabelGenerator<?> labelGenerator;

		public LabelGeneratorDescriptor(IConfigurationElement e, String attrName) {
			super(e, attrName);
		}

		public ILabelGenerator<?> getLabelGenerator() {
			if (labelGenerator == null) {
				labelGenerator = (ILabelGenerator<?>) createInstance();
			}
			return labelGenerator;
		}

		public IConfigurationElement getElement() {
			return element;
		}
	}

	static final String TAG_GENERATOR = "generator";
	static final String ATT_FOR = "for";
	static final String ATT_CLASS = "class";

	public LabelGeneratorRegistryReader() {
		super(Platform.getExtensionRegistry(), OCLExamplesCommonPlugin
				.getPlugin().getBundle().getSymbolicName(),
				OCLExamplesCommonPlugin.LABEL_GENERATOR_PPID);
	}

	@Override
	protected boolean readElement(IConfigurationElement element, boolean add) {
		if (element.getName().equals(TAG_GENERATOR)) {
			String helpedClass = element.getAttribute(ATT_FOR);
			if (helpedClass == null) {
				logMissingAttribute(element, ATT_FOR);
			} else if (element.getAttribute(ATT_CLASS) == null) {
				logMissingAttribute(element, ATT_CLASS);
			} else if (add) {
				Object previous = ILabelGenerator.Registry.INSTANCE
						.install(helpedClass, new LabelGeneratorDescriptor(element, ATT_CLASS));
				if (previous instanceof LabelGeneratorDescriptor) {
					LabelGeneratorDescriptor descriptor = (LabelGeneratorDescriptor) previous;
					OCLExamplesCommonPlugin.INSTANCE.log("Both '"
							+ descriptor.getElement().getContributor().getName()
							+ "' and '" + element.getContributor().getName()
							+ "' register an invocation delegate factory for '"
							+ helpedClass + "'");
				}
				return true;
			} else {
				ILabelGenerator.Registry.INSTANCE.uninstall(helpedClass);
				return true;
			}
		}

		return false;
	}
}
