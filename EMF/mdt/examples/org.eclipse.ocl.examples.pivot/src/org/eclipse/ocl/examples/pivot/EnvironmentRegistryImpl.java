/**
 * <copyright>
 *
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EnvironmentRegistryImpl.java,v 1.2 2011/01/24 20:47:52 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot;

import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionDelta;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IRegistryChangeEvent;
import org.eclipse.core.runtime.IRegistryChangeListener;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;

/**
 * Implementation of the environment registry.
 * 
 * @author cdamus
 */
public class EnvironmentRegistryImpl implements Environment.Registry {
	private final EList<Object> environments = new BasicEList<Object>();
	
    private static final String PT_ENVIRONMENTS = "environments"; //$NON-NLS-1$
    private static final String E_ENVIRONMENT_FACTORY = "environmentFactory"; //$NON-NLS-1$
    private static final String A_CLASS = "class"; //$NON-NLS-1$
    private static final String E_PACKAGE = "package"; //$NON-NLS-1$
    private static final String A_NS_URI = "nsURI"; //$NON-NLS-1$
    
	public Environment getEnvironmentFor(OclExpression expression) {
		return getEnvironmentFor(expression.getType());
	}

	public Environment getEnvironmentFor(Object abstractSyntaxElement) {
		
		if (abstractSyntaxElement instanceof TypedElement) {
			return getEnvironmentFor(((TypedElement) abstractSyntaxElement).getType());
		}
		
		for (int i = 0; i < environments.size(); i++) {
			Object next = environments.get(i);
			
			if (next instanceof EnvironmentDescriptor) {
				EnvironmentDescriptor descriptor = (EnvironmentDescriptor) next;
				
				if (descriptor.matches(abstractSyntaxElement)) {
					// instantiate the descriptor now
					next = descriptor.instantiate();
					environments.set(i, next);
				}
			}
			
			if (next instanceof Environment) {
				Environment env =
					(Environment) next;
				UMLReflection uml = env.getUMLReflection();
                
				if (uml.isClassifier(abstractSyntaxElement)
						|| uml.isOperation(abstractSyntaxElement)
						|| uml.isProperty(abstractSyntaxElement)) {
					
					return (Environment) next;
				}
			}
		}
		
		return null;
	}

	public void registerEnvironment(Environment environment) {

		if (!environments.contains(environment)) {
			environments.add(environment);
		}
	}
    
    public void deregisterEnvironment(Environment environment) {
        environments.remove(environment);
    }
	
	/**
	 * Utility class that reads the Eclipse extension registry to find registered
	 * OCL environments.
	 * 
	 * @author cdamus
	 * 
	 * @since 1.1
	 */
	class RegistryReader implements IRegistryChangeListener {
		private final String namespace;
		private IExtensionRegistry extensionRegistry;
		private final Map<String, EnvironmentDescriptor> descriptors =
			new java.util.HashMap<String, EnvironmentDescriptor>();
		
		RegistryReader(PivotPlugin plugin) {
			// FIXME
			namespace = "org.eclipse.ocl"; //$NON-NLS-1$ //plugin.getSymbolicName();
		}
		
		void readRegistry() {
			if (extensionRegistry == null) {
				extensionRegistry = Platform.getExtensionRegistry();
				readRegistryImpl();
			}
		}
		
		private void readRegistryImpl() {
			extensionRegistry.addRegistryChangeListener(this, namespace);
			
			IExtension[] extensions = extensionRegistry.getExtensionPoint(
					namespace, PT_ENVIRONMENTS).getExtensions();
			
			for (IExtension extension : extensions) {
				read(extension);
			}
		}
		
		private void read(IExtension extension) {
			IConfigurationElement[] elements = extension.getConfigurationElements();
			
			for (IConfigurationElement element : elements) {
				if (E_ENVIRONMENT_FACTORY.equals(element.getName())) {
					readEnvironmentFactory(element);
				} else {
				    PivotPlugin.log(Diagnostic.ERROR, 1,
                        OCLMessages.bind(
                            OCLMessages.EnvRegistry_unknownElement_ERROR_,
                            getExtensionID(extension),
                            element.getName()),
                        null);
                }
			}
		}
		
		private void readEnvironmentFactory(final IConfigurationElement element) {
			String className = element.getAttribute(A_CLASS);
			
			if (className != null) {
				EnvironmentDescriptor descriptor = new EnvironmentDescriptor() {
					@Override
					EnvironmentFactory createFactory() {
						try {
							return (EnvironmentFactory)
								element.createExecutableExtension(A_CLASS);
						} catch (CoreException e) {
                            PivotPlugin.getPlugin().log(e);
							return null;
						}
					}};
				descriptors.put(className, descriptor);
				environments.add(descriptor);
				
				for (IConfigurationElement pkg : element.getChildren(E_PACKAGE)) {
					readPackage(descriptor, pkg);
				}
            } else {
                PivotPlugin.log(Diagnostic.ERROR, 1,
                    OCLMessages.bind(
                        OCLMessages.EnvRegistry_missingClass_ERROR_,
                        getExtensionID(element)),
                    null);
			}
		}
		
		private void readPackage(EnvironmentDescriptor descriptor,
				IConfigurationElement element) {
			
			String nsURI = element.getAttribute(A_NS_URI);
			if (nsURI != null) {
				descriptor.addPackageURI(nsURI);
            } else {
                PivotPlugin.log(Diagnostic.ERROR, 1,
                    OCLMessages.bind(
                        OCLMessages.EnvRegistry_missingNsURI_ERROR_,
                        getExtensionID(element)),
                    null);
			}
		}
		
		private void remove(IExtension extension) {
			IConfigurationElement[] elements = extension.getConfigurationElements();
			
			for (IConfigurationElement element : elements) {
				if (E_ENVIRONMENT_FACTORY.equals(element.getName())) {
					removeEnvironmentFactory(element);
				}
			}
		}
		
		private void removeEnvironmentFactory(IConfigurationElement element) {
			String className = element.getAttribute(A_CLASS);
			
			if (className != null) {
				EnvironmentDescriptor descriptor = descriptors.get(className);
				
				if (descriptor != null) {
					descriptor.dispose();
				}
			}
		}

		public void registryChanged(IRegistryChangeEvent event) {
			for (IExtensionDelta delta : event.getExtensionDeltas(
                    namespace, PT_ENVIRONMENTS)) {
				switch (delta.getKind()) {
				case IExtensionDelta.ADDED:
					read(delta.getExtension());
					break;
				case IExtensionDelta.REMOVED:
					remove(delta.getExtension());
					break;
				}
			}
		}
	}
	
	/**
	 * Descriptor for a lazily-instantiated OCL environment, loaded from the
	 * Eclipse extension registry.
	 * 
	 * @author cdamus
	 *
	 * @since 1.1
	 */
	private abstract class EnvironmentDescriptor {
		private final Set<String> packageURIs = new java.util.HashSet<String>();
		private Environment env;
		
		EnvironmentDescriptor() {
			super();
		}
		
		void addPackageURI(String packageURI) {
			packageURIs.add(packageURI);
		}
		
		boolean matches(Object object) {
			boolean result = object instanceof EObject;
			
			if (result) {
				EPackage epackage = ((EObject) object).eClass().getEPackage();
				
				result = (epackage != null) && packageURIs.contains(epackage.getNsURI());
			}
			
			return result;
		}
		
		Environment instantiate() {
			if (env == null) {
				EnvironmentFactory factory = createFactory();
			
				env = factory.createEnvironment();
			}
			
			return env;
		}
		
		void dispose() {
			if (env != null) {
				// I have been instantiated, so remove my environment from
				//    the list
				environments.remove(env);
			}
			
			// make sure that I'm not in the environments list, either
			environments.remove(this);
		}
		
		abstract EnvironmentFactory createFactory();
	}
    
    /**
     * Obtains the ID of the extension defining the specified element,
     * or the defining plug-in ID if the extension has none.
     * 
     * @param element an element
     * @return an identifier for the extension
     */
    private String getExtensionID(IConfigurationElement element) {
        return getExtensionID(element.getDeclaringExtension());
    }
    
    /**
     * Obtains the ID of the specified extension,
     * or the defining plug-in ID if the extension has none.
     * 
     * @param extension an extension
     * @return an identifier for the extension
     */
    private String getExtensionID(IExtension extension) {
        String result = extension.getUniqueIdentifier();
        
        if (result == null) {
            result = extension.getNamespaceIdentifier();
        }
        
        return result;
    }
}
