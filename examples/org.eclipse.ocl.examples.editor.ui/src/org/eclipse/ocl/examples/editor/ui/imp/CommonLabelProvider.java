/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: CommonLabelProvider.java,v 1.1 2010/03/11 14:51:21 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.imp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.imp.editor.ModelTreeNode;
import org.eclipse.imp.services.ILabelProvider;
import org.eclipse.imp.utils.MarkerUtils;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.ocl.examples.editor.AbstractLabelElement;
import org.eclipse.ocl.examples.editor.EcoreLabelElement;
import org.eclipse.ocl.examples.editor.JavaLabelElement;
import org.eclipse.ocl.examples.editor.LabelBehavior;
import org.eclipse.ocl.examples.editor.OutlineGroup;
import org.eclipse.ocl.examples.editor.ui.OCLExamplesEditorPlugin;
import org.eclipse.ocl.examples.editor.util.FormatProvider;
import org.eclipse.ocl.examples.editor.util.ImageProvider;
import org.eclipse.ocl.examples.editor.util.TextProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

/**
 * CommonLabelProvider provides the LabelProvider functionality for
 * an IMP editor, using the EditorDefinition model to configure behavior.
 */
public abstract class CommonLabelProvider implements ILabelProvider
{
	private Set<ILabelProviderListener> fListeners = new HashSet<ILabelProviderListener>();
	protected ExtendedImageRegistry imageRegistry = new ExtendedImageRegistry();
	private Image errorImageOverlay = null;
	private Image warningImageOverlay = null;
	
	public void addListener(ILabelProviderListener listener) {
		fListeners.add(listener);
	}

	protected Object checkedGet(Object object, EStructuralFeature path) {
		if (path == null)
			throw new NullPointerException("Null path element");
		if (object == null)
			throw new NullPointerException("Null path object");
		if (!(object instanceof EObject))
			throw new ClassCastException("Non EObject");
		EClass objectEClass = ((EObject)object).eClass();
		EClass pathEClass = path.getEContainingClass();
		if (!pathEClass.isSuperTypeOf(objectEClass))
			throw new IllegalArgumentException("Incompatible " + objectEClass.getName() + " for " + pathEClass.getName());
		return ((EObject)object).eGet(path);
	}

	public void dispose() {}

	protected String formatEcoreLabelElement(Object node, EcoreLabelElement labelElement) {
		StringBuffer s = new StringBuffer();
		s.append(labelElement.getPrefix());
		int prefixSize = s.length();
		formatEcoreLabelElementStep(s, node, labelElement, 0);
		if (labelElement.isHideIfBlank() && (prefixSize == s.length()))
			return "";
		s.append(labelElement.getSuffix());
		return s.toString();
	}

	protected void formatEcoreLabelElementStep(StringBuffer s, Object object, EcoreLabelElement labelElement, int step) {
		EList<EReference> path = labelElement.getPath();
		int maxStep = path.size();
		if (step < maxStep) {
			EReference feature = path.get(step);
			Object nextObject = checkedGet(object, feature);
			if (feature.isMany()) {
				boolean isFirst = true;
				for (Object childObject : (Collection<?>)nextObject) {
					if (!isFirst)
						s.append(labelElement.getSeparator());
					formatEcoreLabelElementStep(s, childObject, labelElement, step+1);
					isFirst = false;
				}
			}
			else if (nextObject != null)
				formatEcoreLabelElementStep(s, nextObject, labelElement, step+1);
		}
		else {
			TextProvider textProvider = null;
			try {
				Class<TextProvider> textProviderClass = labelElement.getTextProvider();
				textProvider = textProviderClass != null ? textProviderClass.newInstance() : null;
			} catch (Exception e) {
			}
			EStructuralFeature feature = labelElement.getEnd();
			if (object instanceof EObject) {
				if (feature == null) {
					String text = null;
					if (textProvider != null)
						text = textProvider.getText(object);
					if (text == null)
						s.append("<" + ((EObject)object).eClass().getName() + ">");
					s.append(text);
				}
				else {
					Object nextObject = checkedGet(object, feature);
					if (feature.isMany()) {
						boolean isFirst = true;
						for (Object childObject : (Collection<?>)nextObject) {
							if (!isFirst)
								s.append(labelElement.getSeparator());
							String text = null;
							if (textProvider != null)
								text = textProvider.getText(childObject);
							if (text == null)
								text = formatObject(childObject);
							s.append(text);
							isFirst = false;
						}
					}
					else {
						String text = null;
						if (textProvider != null)
							text = textProvider.getText(nextObject);
						if (text == null)
							text = formatObject(nextObject);
						s.append(text);
					}
				}
			}
			else
				s.append("<" + object.getClass().getName() + ">");
		}
	}

	protected String formatEnum(Enum<?> object) {
		return object.toString();
	}

	/**
	 * Provide a formatted exception arising while identifying the object contributing to the index'th part of node's label.
	 */
	protected String formatException(Throwable e, Object node, int index) {
		return "<!" + e.getClass().getSimpleName() + "!>";
	}

	protected Object formatJavaLabelElement(Object node, JavaLabelElement labelElement) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
		String methodName = labelElement.getMethod();
		String className = labelElement.getClass_();
		if (className == null) {
			Class<?> methodClass = node.getClass();
			Method method = methodClass.getMethod(methodName);
			return String.valueOf(method.invoke(node));
		}
		else {
			Class<?> methodClass = Class.forName(className);
			for (Class<?> nodeClass = node.getClass(); nodeClass != null; nodeClass = nodeClass.getSuperclass()) {
				try {
					Method method = methodClass.getMethod(methodName, nodeClass);
					return String.valueOf(method.invoke(null, node));
				} catch (NoSuchMethodException e1) {
					for (Class<?> nodeInterface : nodeClass.getInterfaces()) {
						try {
							Method method = methodClass.getMethod(methodName, nodeInterface);
							return String.valueOf(method.invoke(null, node));
						} catch (NoSuchMethodException e2) {
						}
					}
				}
			}
			Method method = methodClass.getMethod(methodName, node.getClass());
			return String.valueOf(method.invoke(null, node));
		}
	}

	protected String formatNull() {
		return "";
	}

	protected String formatNumber(Number number) {
		return String.valueOf(number);
	}

	protected String formatObject(Object node) {
		if (node == null)
			return formatNull();
		else if (node instanceof Enum<?>)
			return formatEnum((Enum<?>)node);
		else if (node instanceof Number)
			return formatNumber((Number) node);
		else if (node instanceof String)
			return (String) node;
		else if (node instanceof OutlineGroup)
			return ((OutlineGroup) node).getName();
		CommonEditorDefinition commonEditorDefinition = getPlugin().getEditorDefinition();
		LabelBehavior behavior = commonEditorDefinition.getBehavior(node, LabelBehavior.class);
		if (behavior == null)
			return "<" + String.valueOf(node) + ">";
		String format = null;
		Class<FormatProvider> formatProviderClass = behavior.getFormatProvider();
		if (formatProviderClass != null) {
			try {
				format = formatProviderClass.newInstance().getFormat(node);
			} catch (Exception e) {
			}
		}
		if (format == null) {
			format = behavior.getFormat();
		}
		List<AbstractLabelElement> labelElements = behavior.getElements();
		int iMax = labelElements.size();
		Object[] strings = new String[iMax];
		for (int i = 0; i < iMax; i++) {
			try {
				AbstractLabelElement labelElement = labelElements.get(i);
				if (labelElement instanceof EcoreLabelElement)
					strings[i] = formatEcoreLabelElement(node, (EcoreLabelElement) labelElement);
				else if (labelElement instanceof JavaLabelElement)
					strings[i] = formatJavaLabelElement(node, (JavaLabelElement) labelElement);
				else
					strings[i] = "<?" + labelElement.getClass().getSimpleName() + "?>";
			}
			catch (Throwable e) {
				strings[i] = formatException(e, node, i);
			}
		}
	    return NLS.bind(format, strings);
	}

	protected Object getASTorCSTNode(Object element) {
		if (element instanceof ModelTreeNode)
			return ((ModelTreeNode) element).getASTNode();
		else if (element instanceof ICommonParseResult)
			return ((ICommonParseResult) element).getCST();
		else
			return element;
	}
	
	public CommonEditorDefinition getEditorDefinition() {
		return getPlugin().getEditorDefinition();
	}

	protected Image getErrorImageOverlay() {
		if (errorImageOverlay == null)
			errorImageOverlay = getImage(OCLExamplesEditorPlugin.getDefault().getBundle(), "icons/error_ovr.gif");
		return errorImageOverlay;
	}
	
	public Image getImage(Object element) {
		String imageName = null;
		if (element instanceof ModelTreeNode) {
			ModelTreeNode treeNode = (ModelTreeNode)element;
			int category = treeNode.getCategory();
			OutlineGroup outlineGroup = getEditorDefinition().getOutlineGroup(category);
			if (outlineGroup != null)
				imageName = outlineGroup.getImage();		
		}
		Object node = getASTorCSTNode(element);
		if (imageName == null)
			imageName = getImageName(node);
		if (imageName == null)
			return null;
		Image image = getImage(getPlugin().getBundle(), imageName);
		if (image == null)
			return null;
		Collection<Image> overlays = getOverlayImages(node);
		if ((overlays == null) || overlays.isEmpty())
			return image;
		List<Object> images = new ArrayList<Object>(overlays.size()+1);
		images.add(image);
		images.addAll(overlays);
		return imageRegistry.getImage(new ComposedImage(images));
	}

	protected Image getImage(Bundle defaultBundle, String imagePath) {
		Bundle bundle = defaultBundle;
		String imageFile = imagePath;
		if (imagePath.startsWith("/")) {
			int index = imagePath.indexOf('/', 1);
			if (index > 1) {
				imageFile = imagePath.substring(index+1);
				String bundlePath = imagePath.substring(1, index);
				bundle = Platform.getBundle(bundlePath);
				if (bundle == null) {
					getPlugin().logException("No such bundle '" + bundlePath + "'", null);
					return null;
				}
			}
		}
		Path path = new Path(imageFile);
		URL url = FileLocator.find(bundle, path, null);
		if (url == null)
			return null;
		Image image = imageRegistry.getImage(url);
		return image;
	}
	
	public String getImageName(Object node) {
		if (node instanceof OutlineGroup)
			return ((OutlineGroup) node).getImage();
		CommonEditorDefinition commonEditorDefinition = getPlugin().getEditorDefinition();
		LabelBehavior behavior = commonEditorDefinition.getBehavior(node, LabelBehavior.class);
		if (behavior == null)
			return null;
		String imageName = null;
		Class<ImageProvider> imageProviderClass = behavior.getImageProvider();
		if (imageProviderClass != null)
			try {
				imageName = imageProviderClass.newInstance().getImage(node);
			} catch (Exception e) {
			}
		if (imageName == null)
			imageName = behavior.getImage();
		return imageName;
	}

	protected Collection<Image> getOverlayImages(Object node) {
		if (node instanceof IFile) {
			IFile file = (IFile) node;
			int sev = MarkerUtils.getMaxProblemMarkerSeverity(file, IResource.DEPTH_ONE);
			switch (sev) {
			case IMarker.SEVERITY_ERROR:
				return Collections.singletonList(getErrorImageOverlay());
			case IMarker.SEVERITY_WARNING:
				return Collections.singletonList(getWarningImageOverlay());
			}
		}
		return null;
	}

	protected Image getWarningImageOverlay() {
		if (warningImageOverlay == null)
			warningImageOverlay = getImage(OCLExamplesEditorPlugin.getDefault().getBundle(), "icons/warn_ovr.gif");
		return warningImageOverlay;
	}

	protected abstract ICommonPlugin getPlugin();

	public String getText(Object element) {
		Object node = getASTorCSTNode(element);
		String text = formatObject(node);
		if (text == null)
			return "<!null!>";
		if (!(element instanceof ModelTreeNode))
			return text;
		ModelTreeNode treeNode = (ModelTreeNode)element;
		int category = treeNode.getCategory();
		OutlineGroup outlineGroup = getEditorDefinition().getOutlineGroup(category);
		if (outlineGroup == null)
			return text;
		return outlineGroup.getName() + text;		
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		fListeners.remove(listener);
	}
}
