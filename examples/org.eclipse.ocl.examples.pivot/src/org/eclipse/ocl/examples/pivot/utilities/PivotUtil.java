/**
 * <copyright>
 * 
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: PivotUtil.java,v 1.18 2011/05/20 15:27:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.ocl.examples.common.utils.ClassUtils;
import org.eclipse.ocl.examples.pivot.BagType;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CollectionKind;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.OrderedSetType;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.SemanticException;
import org.eclipse.ocl.examples.pivot.SequenceType;
import org.eclipse.ocl.examples.pivot.SetType;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationContext;
import org.eclipse.ocl.examples.pivot.util.Pivotable;

public class PivotUtil
{	
	public static final String SCHEME_PIVOT = "pivot";

//	public static final URI INTERNAL_URI = URI.createURI("internal.essentialocl");

	private static final AdapterFactory reflectiveAdapterFactory =
		new ReflectiveItemProviderAdapterFactory();

	private static final AdapterFactory defaultAdapterFactory =
		new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);


	/**
	 * 'Highest' precedence first
	 */
	public static class PrecedenceComparator implements Comparator<Precedence>
	{
		public static final PrecedenceComparator INSTANCE = new PrecedenceComparator();

		public int compare(Precedence p1, Precedence p2) {
			int o1 = p1 != null ? p1.getOrder().intValue() : -1;
			int o2 = p2 != null ? p2.getOrder().intValue() : -1;
			return o1 - o2; // NB least positive is highest precedence
		}
	}

	/**
	 * In TemplateSignature order.
	 */
	public static class TemplateParameterSubstitutionComparator
		implements Comparator<TemplateParameterSubstitution>
	{
		public static Comparator<? super TemplateParameterSubstitution> INSTANCE =
			new TemplateParameterSubstitutionComparator();

		public int compare(TemplateParameterSubstitution o1, TemplateParameterSubstitution o2) {
			TemplateParameter f1 = o1.getFormal();
			TemplateParameter f2 = o2.getFormal();
			int i1 = f1.getSignature().getParameters().indexOf(f1);
			int i2 = f2.getSignature().getParameters().indexOf(f2);
			return i1 - i2;
		}
	}

	public static void appendMultiplicity(StringBuffer s, int lower, int upper) {
		if (upper < 0) {
			if (lower == 0) {
				s.append("[*]");
			}
			else if (lower == 1) {
				s.append("[+]");
			}
			else {
				s.append("[" + lower + "..*]");
			}
		}
		else if (upper == 1) {
			if (lower == 0) {
				s.append("[?]");
			}
			else {
				//;
			}
		}
		else if (upper == lower) {
			s.append("[" + lower + "]");
		}
		else {
			s.append("[" + lower + ".." + upper + "]");
		}
	}

	public static void checkResourceErrors(String message, Resource resource) throws ParserException {
		List<Resource.Diagnostic> errors = resource.getErrors();
		if (errors.size() > 0) {
			throw new SemanticException(formatResourceDiagnostics(resource.getErrors(), message, "\n"));
		}
	}

	public static boolean conformsTo(EStructuralFeature eStructuralFeature, EClassifier contentType) {
		if (eStructuralFeature == null) {			// Wildcard match all
			return true;
		}
		EClassifier targetType = eStructuralFeature.getEType();
		if (targetType == contentType) {
			return true;
		}
		if (!(targetType instanceof EClass)) {
			return false;
		}
		if (!(contentType instanceof EClass)) {
			return false;
		}
		return ((EClass) targetType).isSuperTypeOf((EClass) contentType);
	}

	/**
	 * Mostly copied from {@link java.util.Properties#loadConvert} via
	 * {@link org.eclipse.xtext.util.Strings#convertFromJavaString}
	 */
	public static String convertFromOCLString(String javaString) {
		char[] in = javaString.toCharArray();
		int off = 0;
		int len = javaString.length();
		char[] convtBuf = new char[len];
		char aChar;
		char[] out = convtBuf;
		int outLen = 0;
		int end = off + len;

		while (off < end) {
			aChar = in[off++];
			if (aChar == '\\') {
				aChar = in[off++];
				if (aChar == 'u') {
					// Read the xxxx
					int value = 0;
					if(off+4 > end)
						throw new IllegalArgumentException("Malformed \\uxxxx encoding.");
					for (int i = 0; i < 4; i++) {
						aChar = in[off++];
						switch (aChar) {
							case '0':
							case '1':
							case '2':
							case '3':
							case '4':
							case '5':
							case '6':
							case '7':
							case '8':
							case '9':
								value = (value << 4) + aChar - '0';
								break;
							case 'a':
							case 'b':
							case 'c':
							case 'd':
							case 'e':
							case 'f':
								value = (value << 4) + 10 + aChar - 'a';
								break;
							case 'A':
							case 'B':
							case 'C':
							case 'D':
							case 'E':
							case 'F':
								value = (value << 4) + 10 + aChar - 'A';
								break;
							default:
								throw new IllegalArgumentException("Malformed \\uxxxx encoding.");
						}
					}
					out[outLen++] = (char) value;
				} else {
					if (aChar == 't')
						aChar = '\t';
					else if (aChar == 'r')
						aChar = '\r';
					else if (aChar == 'n')
						aChar = '\n';
					else if (aChar == 'f')
						aChar = '\f';
					else if (aChar == 'b')
						aChar = '\b';
					else if (aChar == '"')
						aChar = '\"';
					else if (aChar == '\'')
						aChar = '\'';
					else if (aChar == '\\')
						aChar = '\\';
					else
						throw new IllegalArgumentException("Illegal escape character \\" + aChar);
					out[outLen++] = aChar;
				}
			} else {
				out[outLen++] = aChar;
			}
		}
		return new String(out, 0, outLen);
	}

	/**
	 * Mostly copied from {@link java.util.Properties#saveConvert} via
	 * {@link org.eclipse.xtext.util.Strings#convertToJavaString}
	 */
	public static String convertToOCLString(String theString) {
		if (theString == null) {
			return null;
		}
		int len = theString.length();
		int bufLen = len * 2;
		if (bufLen < 0) {
			bufLen = Integer.MAX_VALUE;
		}
		StringBuffer outBuffer = new StringBuffer(bufLen);

		for (int x = 0; x < len; x++) {
			char aChar = theString.charAt(x);
			// Handle common case first, selecting largest block that
			// avoids the specials below
			if ((aChar > 61) && (aChar < 127)) {
				if (aChar == '\\') {
					outBuffer.append('\\');
					outBuffer.append('\\');
					continue;
				}
				outBuffer.append(aChar);
				continue;
			}
			switch (aChar) {
				case ' ':
					outBuffer.append(' ');
					break;
				case '\t':
					outBuffer.append('\\');
					outBuffer.append('t');
					break;
				case '\n':
					outBuffer.append('\\');
					outBuffer.append('n');
					break;
				case '\r':
					outBuffer.append('\\');
					outBuffer.append('r');
					break;
				case '\f':
					outBuffer.append('\\');
					outBuffer.append('f');
					break;
				case '\b':
					outBuffer.append('\\');
					outBuffer.append('b');
					break;
				case '\'':
					outBuffer.append('\\');
					outBuffer.append('\'');
					break;
//				case '"':
//					outBuffer.append('\\');
//					outBuffer.append('"');
//					break;
				default:
					if (((aChar < 0x0020) || (aChar > 0x007e))) {
						outBuffer.append('\\');
						outBuffer.append('u');
						outBuffer.append(toHex((aChar >> 12) & 0xF));
						outBuffer.append(toHex((aChar >> 8) & 0xF));
						outBuffer.append(toHex((aChar >> 4) & 0xF));
						outBuffer.append(toHex(aChar & 0xF));
					} else {
						outBuffer.append(aChar);
					}
			}
		}
		return outBuffer.toString();
	}

	/**
	 * Create an Xtext resource containing the parsed expression within
	 * a typeContext and supervised by a typeManager.
	 * 
	 * Provided an EssentialOCL resource registration has been made the
	 * created resource named internal.essentialocl may be cast to an
	 * XtextResource. Semantic errors may be found at the Resource.errors
	 * and may be converted to ParseExceptions by invoking
	 * checkResourceErrors.
	 * 
	 * @param typeManager the overall type / meta-model domain
	 * @param typeContext the type that provides the scope of expression
	 * @param expression to be parsed
	 * @return the Xtext resource which may be cast to XtextResource
	 * 
	 * @throws IOException if resource loading fails
	 */
	public static Resource createXtextResource(TypeManager typeManager, URI uri,
			NamedElement typeContext, String expression) throws IOException {
		InputStream inputStream = new ByteArrayInputStream(expression.getBytes());
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(uri);
		TypeManagerResourceAdapter.getAdapter(resource, typeManager);
		if (resource instanceof EvaluationContext) {
			((EvaluationContext)resource).setContext(typeContext, null);
		}
		resource.load(inputStream, null);
		return resource;
	}

	public static Type findTypeOf(TypeManager typeManager, EClassifier eClass) {
		Resource resource = eClass.eResource();
		if (resource != null) {
			Ecore2Pivot adapter = Ecore2Pivot.findAdapter(resource, typeManager);
			if (adapter != null) {
				Type type = adapter.getCreated(Type.class, eClass);
				if (type != null) {
					return type;
				}
			}
		}
		return null;
	}

	public static String formatResourceDiagnostics(List<Resource.Diagnostic> diagnostics, String messagePrefix, String newLine) {
		if (diagnostics.size() <= 0) {
			return null;
		}
		StringBuffer s = new StringBuffer();
		s.append(messagePrefix);
		for (Resource.Diagnostic diagnostic : diagnostics) {
			s.append(newLine);
			s.append(diagnostic.getMessage());
		}
		return s.toString();
	}

	public static <T> T getAdapter(Class<T> adapterClass, List<Adapter> eAdapters) {
		return getAdapter(adapterClass, eAdapters, adapterClass);
	}

	public static <T> T getAdapter(Class<T> adapterClass, Notifier notifier) {
		return getAdapter(adapterClass, notifier, adapterClass);
	}

	public static <T> T getAdapter(Class<T> adapterClass, Notifier notifier, Object adapterType) {
		return getAdapter(adapterClass, notifier.eAdapters(), adapterType);
	}

	public static <T> T getAdapter(Class<T> adapterClass, List<Adapter> eAdapters, Object adapterType) {
		Adapter adapter = EcoreUtil.getAdapter(eAdapters, adapterType);
		if (adapter == null) {
			return null;
		}
		if (!adapterClass.isAssignableFrom(adapter.getClass())) {
			throw new ClassCastException(adapter.getClass().getName() + " is not assignable to " + adapterClass.getName());
		}
		@SuppressWarnings("unchecked")
		T castAdapter = (T) adapter;
		return castAdapter;
	}

	public static List<TemplateParameter> getAllTemplateParameters(Collection<TemplateBinding> templateBindings) {
		List<TemplateParameter> list = null;
		for (TemplateBinding templateBinding : templateBindings) {	// FIXME Establish ordering
			TemplateSignature templateSignature = templateBinding.getSignature();
			if (templateSignature != null) {
				List<TemplateParameter> templateParameters = templateSignature.getParameters();
				if (templateParameters.size() > 0) {
					if (list == null) {
						list = new ArrayList<TemplateParameter>();
					}
					list.addAll(templateParameters);
				}
			}
		}
		return list != null ? list : Collections.<TemplateParameter>emptyList();
	}

	public static List<List<TemplateParameter>> getAllTemplateParameterLists(EObject eObject) {
		List<List<TemplateParameter>> result = null;
		EObject eContainer = eObject.eContainer();
		if (eContainer != null) {
			result = getAllTemplateParameterLists(eContainer);
		}
		if (eObject instanceof TemplateableElement) {
			TemplateableElement unspecializedTemplateableElement = (TemplateableElement)eObject;
			if (eObject instanceof Type) {
				eObject = getUnspecializedTemplateableElement((Type)eObject);
			}
			TemplateSignature templateSignature = unspecializedTemplateableElement.getOwnedTemplateSignature();
			if (templateSignature != null) {
				List<TemplateParameter> templateParameters = templateSignature.getParameters();
				if (templateParameters.size() > 0) {
					if (result == null) {
						result = new ArrayList<List<TemplateParameter>>();
					}
					result.add(templateParameters);
				}
			}
		}
		return result;
	}

	public static List<TemplateParameter> getAllTemplateParameters(EObject eObject) {
		List<TemplateParameter> result = null;
		EObject eContainer = eObject.eContainer();
		if (eContainer != null) {
			result = getAllTemplateParameters(eContainer);
		}
		if (eObject instanceof TemplateableElement) {
			TemplateableElement unspecializedTemplateableElement = (TemplateableElement)eObject;
			if (eObject instanceof Type) {
				eObject = getUnspecializedTemplateableElement((Type)eObject);
			}
			TemplateSignature templateSignature = unspecializedTemplateableElement.getOwnedTemplateSignature();
			if (templateSignature != null) {
				List<TemplateParameter> templateParameters = templateSignature.getParameters();
				if (templateParameters.size() > 0) {
					if (result == null) {
						result = new ArrayList<TemplateParameter>();
					}
					result.addAll(templateParameters);
				}
			}
		}
		return result;
	}

	public static Map<TemplateParameter, ParameterableElement> getAllTemplateParametersAsBindings(EObject eObject) {
		if (eObject instanceof Type) {
			eObject = getUnspecializedTemplateableElement((Type)eObject);
		}
		Map<TemplateParameter, ParameterableElement> result = null;
		EObject eContainer = eObject.eContainer();
		if (eContainer != null) {
			result = getAllTemplateParametersAsBindings(eContainer);
		}
		if (eObject instanceof TemplateableElement) {
//			TemplateableElement unspecializedTemplateableElement = getUnspecializedTemplateableElement((TemplateableElement)eObject);
			TemplateSignature templateSignature = ((TemplateableElement)eObject).getOwnedTemplateSignature();
			if (templateSignature != null) {
				List<TemplateParameter> templateParameters = templateSignature.getParameters();
				if (templateParameters.size() > 0) {
					if (result == null) {
						result = new HashMap<TemplateParameter, ParameterableElement>();
					}
					for (TemplateParameter templateParameter : templateSignature.getParameters()) {
						result.put(templateParameter, null);
					}
				}
			}
		}
		return result;
	}

	public static Map<TemplateParameter, ParameterableElement> getAllTemplateParameterSubstitutions(Map<TemplateParameter, ParameterableElement> map,
			TemplateableElement templateableElement) {
		for (EObject eObject = templateableElement; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof TemplateableElement) {
				for (TemplateBinding templateBinding : ((TemplateableElement) eObject).getTemplateBindings()) {
					for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getParameterSubstitutions()) {
						if (map == null) {
							map = new HashMap<TemplateParameter, ParameterableElement>();
						}
						map.put(templateParameterSubstitution.getFormal(), templateParameterSubstitution.getActual());
					}
				}
			}
			if (eObject instanceof org.eclipse.ocl.examples.pivot.Class) {
				for (org.eclipse.ocl.examples.pivot.Class superType : ((org.eclipse.ocl.examples.pivot.Class)eObject).getSuperClasses()) {
					map = getAllTemplateParameterSubstitutions(map, superType);
				}		
			}
		}
		return map;
	}

	public static Map<TemplateParameter, ParameterableElement> getAllTemplateParameterSubstitutions(Map<TemplateParameter, ParameterableElement> bindings,
		Type argumentType, LambdaType lambdaType) {
		Type resultType = lambdaType.getResultType();
		TemplateParameter resultTemplateParameter = resultType.getOwningTemplateParameter();
		if (resultTemplateParameter != null) {
			if (bindings == null) {
				bindings = new HashMap<TemplateParameter, ParameterableElement>();
			}
			bindings.put(resultTemplateParameter, argumentType);
		}
		// FIXME There is much more to do
		// FIXME Conflict checking
		return bindings;
	}

	public static Type getBehavioralType(Type type) {		// FIXME fold this into normal code
		if (type instanceof DataType) {
			DataType dataType = (DataType)type;
			Type behavioralType = dataType.getBehavioralType();
			if (behavioralType != null) {
				return behavioralType;
			}
		}
		return type;
	}

	public static String getBody(OpaqueExpression specification) {
		List<String> bodies = specification.getBodies();
		List<String> languages = specification.getLanguages();
		if ((bodies == null) || (languages == null)) {
			return null;
		}
		int iMax = Math.min(bodies.size(), languages.size());
		for (int i = 0; i < iMax; i++) {
			if (PivotConstants.OCL_LANGUAGE.equalsIgnoreCase(languages.get(i))) {
				return bodies.get(i);
			}
		}
		return null;
	}

	public static CollectionKind getCollectionKind(CollectionType collectionType) {
		if (collectionType instanceof OrderedSetType) {
			return CollectionKind.ORDERED_SET;
		}
		else if (collectionType instanceof SequenceType) {
			return CollectionKind.SEQUENCE;
		}
		else if (collectionType instanceof SetType) {
			return CollectionKind.SET;
		}
		else if (collectionType instanceof BagType) {
			return CollectionKind.BAG;
		}
		else {
			return CollectionKind.COLLECTION;
		}
	}

	public static org.eclipse.ocl.examples.pivot.Class getFeaturingClass(Feature feature) {
		org.eclipse.ocl.examples.pivot.Class owner = null;
		if (feature instanceof Property) {
			owner = ((Property)feature).getClass_();
		}
		else if (feature instanceof Operation) {
			owner = ((Operation)feature).getClass_();
		}
		return owner;
	}

	public static <T extends NamedElement> T getNamedElement(Iterable<T> elements, String name) {
		if (elements == null)
			return null;
		for (T element : elements)
			if (ClassUtils.equals(name, element.getName()))
				return element;
		return null;				
	}

	public static org.eclipse.ocl.examples.pivot.Package getPackage(EObject object) {
		for (EObject eObject = object; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
				return (org.eclipse.ocl.examples.pivot.Package)eObject;
			}
		}
		return null;
	}

	public static String getLabel(EObject eObject) {
		IItemLabelProvider labeler =
			(IItemLabelProvider) defaultAdapterFactory.adapt(eObject, IItemLabelProvider.class);		
		if (labeler == null) {
			labeler = (IItemLabelProvider) reflectiveAdapterFactory.adapt(eObject, IItemLabelProvider.class);
		}		
		if (labeler != null) {
			return labeler.getText(eObject);
		}
		return eObject.toString();
	}

	public static String getMessage(OpaqueExpression specification) {
		List<String> messages = specification.getMessages();
		List<String> languages = specification.getLanguages();
		if ((messages == null) || (languages == null)) {
			return null;
		}
		int iMax = Math.min(messages.size(), languages.size());
		for (int i = 0; i < iMax; i++) {
			if (PivotConstants.OCL_LANGUAGE.equalsIgnoreCase(languages.get(i))) {
				return messages.get(i);
			}
		}
		return null;
	}

	public static <T extends Element> T getPivot(Class<T> pivotClass, Pivotable pivotableElement) {
		Element pivotElement = pivotableElement.getPivot();
		if (pivotElement == null) {
			return null;
		}
		if (!pivotClass.isAssignableFrom(pivotElement.getClass())) {
			throw new ClassCastException(pivotElement.getClass().getName() + " is not assignable to " + pivotClass.getName());
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) pivotElement;
		return castElement;
	}

	public static URI getNonPivotURI(URI uri) {
		assert isPivotURI(uri);
		String[] oldSegments = uri.segments();
		String[] newSegments = new String[oldSegments.length - 1];
		newSegments[0] = uri.scheme();
		System.arraycopy(oldSegments, 1, newSegments, 0, oldSegments.length-1);
		URI pivotURI = URI.createHierarchicalURI(oldSegments[0], uri.authority(), uri.device(), newSegments,
				uri.query(), uri.fragment());
		return pivotURI;
	}

	public static URI getPivotURI(URI uri) {
		String oldScheme = uri.scheme();
		if (oldScheme == null) {
			oldScheme = "null";
		}
		String[] oldSegments = uri.segments();
		String[] newSegments = new String[oldSegments.length + 1];
		newSegments[0] = oldScheme;
		System.arraycopy(oldSegments, 0, newSegments, 1, oldSegments.length);
		URI pivotURI = URI.createHierarchicalURI(SCHEME_PIVOT, uri.authority(), uri.device(), newSegments,
				uri.query(), uri.fragment());
		return pivotURI;
	}

	public static Feature getReferredFeature(CallExp callExp) {
		Feature feature = null;
		if (callExp instanceof LoopExp) {
			feature = ((LoopExp)callExp).getReferredIteration();
		}
		else if (callExp instanceof OperationCallExp) {
			feature = ((OperationCallExp)callExp).getReferredOperation();
		}
		else if (callExp instanceof PropertyCallExp) {
			feature = ((PropertyCallExp)callExp).getReferredProperty();
		}
		return feature;
	}

	public static Operation getReferredOperation(CallExp callExp) {
		Operation operation = null;
		if (callExp instanceof LoopExp) {
			operation = ((LoopExp)callExp).getReferredIteration();
		}
		else if (callExp instanceof OperationCallExp) {
			operation = ((OperationCallExp)callExp).getReferredOperation();
		}
		return operation;
	}

	public static List<TemplateParameter> getTemplateParameters(TemplateableElement templateableElement) {
		if (templateableElement != null) {
			TemplateSignature ownedTemplateSignature = templateableElement.getOwnedTemplateSignature();
			if (ownedTemplateSignature != null) {
				return ownedTemplateSignature.getParameters();
			}
		}
		return Collections.emptyList();
	}

	public static List<ParameterableElement> getTemplateParameterables(TemplateableElement templateableElement) {
		if (templateableElement == null) {
			return Collections.emptyList();
		}
		TemplateSignature ownedTemplateSignature = templateableElement.getOwnedTemplateSignature();
		if (ownedTemplateSignature == null) {
			return Collections.emptyList();
		}
		List<TemplateParameter> templateParameters = ownedTemplateSignature.getParameters();
		if (templateParameters.size() == 0) {
			return Collections.emptyList();
		}
		if (templateParameters.size() == 1) {
			return Collections.singletonList(templateParameters.get(0).getParameteredElement());
		}
		List<ParameterableElement> results = new ArrayList<ParameterableElement>(templateParameters.size());
		for (TemplateParameter templateParameter : templateParameters) {
			results.add(templateParameter.getParameteredElement());
		}
		return results;
	}

	public static TypeManager getTypeManager(Resource resource) {
		TypeManagerResourceAdapter adapter = TypeManagerResourceAdapter.getAdapter(resource, null);
		TypeManager typeManager = adapter.getTypeManager();
		assert typeManager != null;
		return typeManager;
	}

	public static List<Type> getTypeTemplateParameterables(TemplateableElement templateableElement) {
		if (templateableElement == null) {
			return Collections.emptyList();
		}
		TemplateSignature ownedTemplateSignature = templateableElement.getOwnedTemplateSignature();
		if (ownedTemplateSignature == null) {
			return Collections.emptyList();
		}
		List<TemplateParameter> templateParameters = ownedTemplateSignature.getParameters();
		if (templateParameters.size() == 0) {
			return Collections.emptyList();
		}
		if (templateParameters.size() == 1) {
			return Collections.singletonList((Type)templateParameters.get(0).getParameteredElement());
		}
		List<Type> results = new ArrayList<Type>(templateParameters.size());
		for (TemplateParameter templateParameter : templateParameters) {
			results.add((Type) templateParameter.getParameteredElement());
		}
		return results;
	}

	public static <T extends Type> T getUnspecializedTemplateableElement(T templateableElement) {
		if (templateableElement == null) {
			return null;
		}
		TemplateableElement unspecializedElement = templateableElement.getUnspecializedElement();
		if (unspecializedElement == null) {
			return templateableElement;
		}
		@SuppressWarnings("unchecked")
		T castUnspecializedElement = (T) unspecializedElement;
		return (T) castUnspecializedElement;
	}

	public static boolean isPivotURI(URI uri) {
		return SCHEME_PIVOT.equals(uri.scheme()) && (uri.segments().length > 0);
	}
	
	public static boolean isValidIdentifier(String value) {
		if (value == null) {
			return false;
		}
		int iMax = value.length();
		for (int i = 0; i < iMax; i++) {
			char c = value.charAt(i);
			if (('A' <= c) && (c <= 'Z')) {					
			}
			else if (('a' <= c) && (c <= 'z')) {					
			}
			else if (c == '_') {					
			}
			else if (('0' <= c) && (c <= '9') && (i > 0)) {					
			}
			else {
				return false;
			}
		}
		return true;
	}

	public static <T extends EObject> void refreshList(List<? super T> elements, List<? extends T> newElements) {
		for (int k = newElements.size(); k-- > 0; ) {
			T newElement = newElements.get(k);
			if (newElement.eIsProxy()) {
				elements.remove(k);			// Lose oldContent before adding possible 'duplicates'
			}
		}
		for (int k = elements.size(); k-- > 0; ) {
			Object oldElement = elements.get(k);
			if (!newElements.contains(oldElement)) {
				elements.remove(k);			// Lose oldContent before adding possible 'duplicates'
			}
		}
		int newMax = newElements.size();
		for (int i = 0; i < newMax; i++) {					// Invariant: lists are equal up to index i
			T newElement = newElements.get(i);
			int oldMax = elements.size();
			boolean reused = false;;
			for (int j = i; j < oldMax; j++) {
				Object oldElement = elements.get(j);
				if (oldElement == newElement) {
					if (j != i) {
						elements.remove(j);
						elements.add(i, newElement);
					}
					reused = true;
					break;
				}
			}
			if (!reused) {
				if (i < oldMax) {
					elements.add(i, newElement);
				}
				else {
					elements.add(newElement);
				}
			}
			assert newElements.get(i) == elements.get(i);
		}
		for (int k = elements.size(); k > newMax; ) {
			elements.remove(--k);
		}
		assert newElements.size() == elements.size();
	}

	public static <T extends EObject> void refreshSet(List<? super T> oldElements, Collection<? extends T> newElements) {
		for (int i = oldElements.size(); i-- > 0;) {	// Remove any oldElements not in newElements
			Object oldElement = oldElements.get(i);
			if (!newElements.contains(oldElement)) {
				oldElements.remove(i);
			}
		}
		for (T newElement : newElements) {				// Add any newElements not in oldElements
			if (!newElement.eIsProxy() && !oldElements.contains(newElement)) {
				oldElements.add(newElement);
			}
		}
	}

	public static ExpressionInOcl resolveSpecification(TypeManager typeManager, URI uri, NamedElement contextClassifier, String expression) throws ParserException {
		Resource resource = null;
		try {
			resource = createXtextResource(typeManager, uri, contextClassifier, expression);
			checkResourceErrors("Errors in '" + expression + "'", resource);
			return getExpressionInOcl(resource);
		} catch (IOException e) {
//				throw new ParserException("Failed to load expression", e);
			ExpressionInOcl specification = PivotFactory.eINSTANCE.createExpressionInOcl();
			OclExpression invalidValueBody = typeManager.createInvalidExpression();
			specification.setBodyExpression(invalidValueBody);
			return specification;
		} finally {
			if (resource != null) {
				TypeManagerResourceAdapter adapter = TypeManagerResourceAdapter.findAdapter(resource);
				if (adapter != null) {
					adapter.dispose();
				}
			}
		}
	}

	public static ExpressionInOcl resolveMessage(TypeManager typeManager, URI uri, ExpressionInOcl specification, String expression) throws ParserException {
		try {
			Resource resource = createXtextResource(typeManager, uri, specification, expression);
			checkResourceErrors("Errors in '" + expression + "'", resource);
			return getExpressionInOcl(resource);
		} catch (IOException e) {
//				throw new ParserException("Failed to load expression", e);
			OclExpression invalidValueBody = typeManager.createInvalidExpression();
			specification.setBodyExpression(invalidValueBody);
			return specification;
		}			
	}

	public static ExpressionInOcl getExpressionInOcl(Resource resource) throws ParserException {
		List<EObject> contents = resource.getContents();
		int size = contents.size();
		if (size == 0) {
			return null;
		}
		if (size > 1) {
			throw new ParserException("Extra returns ignored");
		}
		EObject csObject = contents.get(0);
		if (csObject instanceof Pivotable) {
			Element pivotElement = ((Pivotable)csObject).getPivot();
			if (pivotElement instanceof ExpressionInOcl) {
				return (ExpressionInOcl) pivotElement;
			}
		}
		throw new ParserException("Non-expression ignored");
	}

	public static <T extends MonikeredElement> List<T> sortByMoniker(List<T> list) {
		Collections.sort(list, new Comparator<MonikeredElement>()
		{
			public int compare(MonikeredElement o1, MonikeredElement o2) {
				return o1.getMoniker().compareTo(o2.getMoniker());
			}
		});
		return list;
	}

	/**
	 * Copied from {@link java.util.Properties}
	 */
	public static char toHex(int nibble) {
		return hexDigit[(nibble & 0xF)];
	}

	/**
	 * Copied from {@link java.util.Properties}
	 */
	private static final char[] hexDigit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
}
