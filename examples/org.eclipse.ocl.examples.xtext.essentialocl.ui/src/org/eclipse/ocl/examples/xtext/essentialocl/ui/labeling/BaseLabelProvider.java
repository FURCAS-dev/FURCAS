/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: BaseLabelProvider.java,v 1.2 2011/01/24 21:30:14 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.ui.labeling;

import java.net.URL;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.AssociationClassCallExp;
import org.eclipse.ocl.examples.pivot.BagType;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Detail;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidType;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.LiteralExp;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.MessageExp;
import org.eclipse.ocl.examples.pivot.MessageType;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.NavigationCallExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.NumericLiteralExp;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.OrderedSetType;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.PrimitiveLiteralExp;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.SequenceType;
import org.eclipse.ocl.examples.pivot.SetType;
import org.eclipse.ocl.examples.pivot.StateExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateParameterType;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintExprVisitor;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintNameVisitor;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintTypeVisitor;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.osgi.framework.Bundle;

import com.google.inject.Inject;

/**
 * Provides labels for BaseCST objects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class BaseLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public BaseLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	protected void appendClass(StringBuffer s, Object object) {
		s.append("<");
		s.append(object != null ? object.getClass().getSimpleName() : "null");
		s.append(">");
	}

	protected void appendMultiplicity(StringBuffer s, TypedMultiplicityElement ele) {
//		String multiplicity = ele.getMultiplicity();
//		if (multiplicity != null) {
//			s.append("[");
//			s.append(multiplicity);
//			s.append("]");
//		}
//		else {
			int lower = ele.getLower().intValue();
			int upper = ele.getUpper().intValue();
			if ((lower != 1) || (upper != 1)) {
				s.append("[");
				if (upper < 0) {
					if (lower == 1) {
						s.append("+");
					}
					else {
						if (lower != 0) {
							s.append(lower);
							s.append("..");
						}
						s.append("*");
					}
				}
				else if ((lower == 0) && (upper == 1)) {
					s.append("?");
				}
				else {
					s.append(lower);
					if (lower != upper) {
						s.append("..");
						s.append(upper);
					}
				}
				s.append("]");
			}
//		}
	}

	protected void appendName(StringBuffer s, NamedElement element) {
		if (element != null) {
			if (element.eIsProxy()) {
				EcoreUtil.resolve(element, element);
			}
			appendString(s, element.getName());
		}	
	}

	protected void appendName(StringBuffer s, NamedElementCS csElement) {
		if (csElement != null) {
			if (csElement.eIsProxy()) {
				EcoreUtil.resolve(csElement, csElement);
			}
			appendString(s, csElement.getName());
		}	
	}

	protected void appendOptionalName(StringBuffer s, NamedElementCS csElement) {
		if (csElement != null) {
			appendOptionalString(s, csElement.getName());
		}	
	}

	protected void appendOptionalString(StringBuffer s, String string) {
		if (string != null) {
			s.append(string);
		}	
	}

	protected void appendParameters(StringBuffer s, List<Parameter> parameters) {
		s.append("(");
		String prefix = "";
		for (Parameter csParameter : parameters) {
			s.append(prefix);
			appendType(s, csParameter.getType());
			appendMultiplicity(s, csParameter);
			prefix = ", ";
		}
		s.append(")");
	}

	protected void appendString(StringBuffer s, String string) {
		if (string != null) {
			s.append(string);
		}	
		else {
			s.append("<null>");
		}	
	}

	protected void appendString(StringBuffer s, String string, int countLimit) {
		if (string == null) {
			s.append("<null>");
		}	
		else if (string.length() > countLimit){
			s.append(string.substring(0, countLimit-3));
			s.append("...");
		}	
		else {
			s.append(string);
		}	
	}

	protected void appendSuperTypes(StringBuffer s, List<org.eclipse.ocl.examples.pivot.Class> superTypes) {
		if (!superTypes.isEmpty()) {
			String prefix = " -> ";
			for (org.eclipse.ocl.examples.pivot.Class superType : superTypes) {
				s.append(prefix);
				appendType(s, superType);
				prefix = ", ";
			}
		}
	}

	protected void appendType(StringBuffer s, TypeRefCS type) {
		Element pivot = type.getPivot();
		if (pivot instanceof MonikeredElement) {
			appendString(s, ((MonikeredElement)pivot).getMoniker());
		}
		else {
			appendString(s, "null");
		}
/*		if (type instanceof PrimitiveTypeRefCS) {
			appendName(s, (PrimitiveTypeRefCS)type);
		}
//		else if (type instanceof CollectionTypeRefCS) {
//			appendName(s, (CollectionTypeRefCS)type);
//			appendTemplateBinding(s, ((CollectionTypeRefCS)type).getOwnedTemplateBinding());
//		}
		else if (type instanceof QualifiedTypeRefCS) {
			appendType(s, ((QualifiedTypeRefCS)type).getElement());
		}
		else if (type instanceof TypedTypeRefCS) {
			appendType(s, ((TypedTypeRefCS)type).getType());
			appendTemplateBinding(s, ((TypedTypeRefCS)type).getOwnedTemplateBinding());
		}
		else if (type instanceof WildcardTypeRefCS) {
			s.append("?");
		} */
	}

	protected void appendTemplateParameterSubstitution(StringBuffer s, TemplateParameterSubstitutionCS csTemplateParameterSubstitution) {
		TemplateParameterSubstitution templateParameterSubstitution = (TemplateParameterSubstitution) csTemplateParameterSubstitution.getPivot();
		appendName(s, (NamedElement) templateParameterSubstitution.getFormal().getParameteredElement()
	);
		s.append(" => ");
		appendType(s, (TypeRefCS) csTemplateParameterSubstitution.getOwnedActualParameter());
	}

	protected void appendTemplateBinding(StringBuffer s, TemplateBindingCS templateBinding) {
		if (templateBinding != null) {
			Collection<TemplateParameterSubstitutionCS> templateParameterSubstitutions = templateBinding.getOwnedParameterSubstitution();
			appendTemplateParameterSubstitutions(s, templateParameterSubstitutions);
		}
	}

	protected void appendTemplateParameterSubstitutions(StringBuffer s, Collection<TemplateParameterSubstitutionCS> templateParameterSubstitutions) {
		s.append("<");
		String prefix = "";
		for (TemplateParameterSubstitutionCS templateParameterSubstitution : templateParameterSubstitutions) {
			s.append(prefix);
			appendTemplateParameterSubstitution(s, templateParameterSubstitution);
			prefix = ", ";
		}
		s.append(">");
	}

	protected void appendTemplateSignature(StringBuffer s, TemplateableElement templateableElement) {
		if (templateableElement != null) {
			TemplateSignature templateSignature = templateableElement.getOwnedTemplateSignature();
			if (templateSignature != null) {
				s.append("<");
				Collection<TemplateParameter> templateParameters = templateSignature.getParameters();
				if (!templateParameters.isEmpty()) {
					String prefix = "";
					for (TemplateParameter templateParameter : templateParameters) {
						s.append(prefix);
						appendName(s, (NamedElement) templateParameter.getParameteredElement());
						prefix = ", ";
					}
				}
				s.append(">");
			}
		}
	}

	protected void appendType(StringBuffer s, Type type) {
		appendName(s, type);
	}
	
	@Override
	protected Image convertToImage(Object imageDescription) {
		if (imageDescription instanceof String) {
			String imagePath = (String)imageDescription;
			if (imagePath.startsWith("/")) {	
				int index = imagePath.indexOf('/', 1);
				if (index > 1) {
					String bundlePath = imagePath.substring(1, index);
					Bundle bundle = Platform.getBundle(bundlePath);
					if (bundle != null) {
						String imageFile = imagePath.substring(index+1);
						Path path = new Path(imageFile);
						URL imgUrl = FileLocator.find(bundle, path, null);
						if (imgUrl != null) {
							return super.convertToImage(ImageDescriptor.createFromURL(imgUrl));
						}
					}
				}
			}				
		}
		return super.convertToImage(imageDescription);
	}
	 
	@Override
	protected Object doGetText(Object element) {
		Object object = super.doGetText(element);
		if (object instanceof String) {
			String text = (String)object;
			int index = text.indexOf('\n');
			if (index >= 0) {
				text = text.substring(0, index);
			}
			object = text.trim();
		}
		return object;
	}

	protected String text(Element ele) {
		return "<" + ele.getClass().getSimpleName() + ">";
	}

	protected String image(Annotation ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EAnnotation.gif";
	}

	public String text(Annotation ele) {
		StringBuffer s = new StringBuffer();
		s.append("\"");
		appendString(s, ele.getName(), 40);			
		s.append("\"");
		return s.toString();
	}

	protected String image(AnyType ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/AnyType.gif";
	}

	protected String image(AssociationClassCallExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/AssociationClassCallExp.gif";
	}

	protected String image(BagType ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/BagType.gif";
	}

	protected String image(BooleanLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/BooleanLiteralExp.gif";
	}

	protected String image(org.eclipse.ocl.examples.pivot.Class ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Class.gif";
	}

	protected String text(org.eclipse.ocl.examples.pivot.Class ele) {
		StringBuffer s = new StringBuffer();
		appendName(s, ele);
		appendTemplateSignature(s, ele);
		appendSuperTypes(s, ele.getSuperClasses());
		return s.toString();
	}

	protected String image(CollectionItem ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/CollectionItem.gif";
	}

	protected String image(CollectionLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/CollectionLiteralExp.gif";
	}

	protected String image(CollectionLiteralPart ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/CollectionLiteralPart.gif";
	}

	protected String text(CollectionLiteralPart ele) {
		return null;
	}

	protected String image(CollectionRange ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/CollectionRange.gif";
	}

	protected String image(CollectionType ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/CollectionType.gif";
	}

	protected String image(Comment ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Comment.gif";
	}

	public String text(Comment ele) {
		StringBuffer s = new StringBuffer();
		s.append("\"");
		appendString(s, ele.getBody(), 40);			
		s.append("\"");
		return s.toString();
	}

	protected String image(Constraint ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Constraint.gif";
	}

	protected String text(DataType ele) {
		StringBuffer s = new StringBuffer();
		appendName(s, ele);
/*		List<TemplateParameterCS> typeParameters = ElementUtil.getTemplateParameters(ele);
		if (!typeParameters.isEmpty()) {
			s.append("<");
			String prefix = "";
			for (TemplateParameterCS typeParameter : typeParameters) {
				s.append(prefix);
				appendTemplateParameter(s, typeParameter);
				prefix = ", ";
			}
			s.append(">");
		} */ // FIXME
		String instance = ele.getInstanceClassName();
		if (instance != null) {
			s.append(" [");
			s.append(instance);
			s.append("]");
		}
		return s.toString();
	}

	protected String image(EnumLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/EnumLiteralExp.gif";
	}

	protected String text(org.eclipse.ocl.examples.pivot.Enumeration ele) {
		StringBuffer s = new StringBuffer();
		appendName(s, ele);
/*		List<TemplateParameterCS> typeParameters = ElementUtil.getTemplateParameters(ele);
		if (!typeParameters.isEmpty()) {
			s.append("<");
			String prefix = "";
			for (TemplateParameterCS typeParameter : typeParameters) {
				s.append(prefix);
				appendTemplateParameter(s, typeParameter);
				prefix = ", ";
			}
			s.append(">");
		} */ // FIXME
		String instance = ele.getInstanceClassName();
		if (instance != null) {
			s.append(" [");
			s.append(instance);
			s.append("]");
		}
		return s.toString();
	}

	protected String image(Detail ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EStringToStringMapEntry.gif";
	}

	public String text(Detail ele) {
		StringBuffer s = new StringBuffer();
		s.append("\"");
		appendString(s, ele.getName());			
		s.append("\" : ");
		appendString(s, ele.getValues().get(0), 40);
		return s.toString();
	}

	protected String image(EnumerationLiteral ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/EnumerationLiteral.gif";
	}

	protected String image(ExpressionInOcl ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/ExpressionInOCL.gif";
	}

	protected String image(IfExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/IfExp.gif";
	}

	protected String text(IfExp ele) {
		return "if";
	}

	protected String image(ImportCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/PackageImport.gif";
	}

	protected String text(ImportCS ele) {
		StringBuffer s = new StringBuffer();
		appendOptionalName(s, ele);
		s.append(" : ");
//		appendString(s, ele.getUri());
		return s.toString();
	}

	protected String image(IntegerLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/IntegerLiteralExp.gif";
	}

	protected String image(InvalidLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/InvalidLiteralExp.gif";
	}

	protected String image(InvalidType ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/InvalidType.gif";
	}

	protected String image(IterateExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/IterateExp.gif";
	}

	protected String image(IteratorExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/IteratorExp.gif";
	}

	protected String image(LetExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/LetExp.gif";
	}

	protected String image(LiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/LiteralExp.gif";
	}

	protected String image(LoopExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/LoopExp.gif";
	}

	protected String image(MessageExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/MessageExp.gif";
	}

	protected String image(MessageType ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/MessageType.gif";
	}
	
	protected Object image(ModelElementCS ele) {
		return doGetImage(ele.getPivot());
	}
	
	protected Object text(ModelElementCS ele) {
		return doGetText(ele.getPivot());
	}

	protected String image(NavigationCallExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/NavigationCallExp.gif";
	}

	protected String image(NullLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/NullLiteralExp.gif";
	}

	protected String image(NumericLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/NumericLiteralExp.gif";
	}

	protected String text(OclExpression ele) {
		Namespace namespace = PrettyPrintNameVisitor.getNamespace(ele.eContainer());
		StringBuffer s = new StringBuffer();
		s.append(PrettyPrintExprVisitor.prettyPrint(ele, namespace));
		s.append(" : ");
		s.append(PrettyPrintTypeVisitor.prettyPrint(ele.getType(), namespace));
		return s.toString();
	}

	protected String image(Operation ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Operation.gif";
	}

	protected String text(Operation ele) {
		StringBuffer s = new StringBuffer();
		appendName(s, ele);
		appendTemplateSignature(s, ele);
		appendParameters(s, ele.getOwnedParameters());
		s.append(" : ");
		appendType(s, ele.getType());
		appendMultiplicity(s, ele);
		return s.toString();
	}

	protected String image(OperationCallExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/OperationCallExp.gif";
	}

	protected String image(OrderedSetType ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/OrderedSetType.gif";
	}

	protected String image(org.eclipse.ocl.examples.pivot.Package ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Package.gif";
	}

	protected String text(org.eclipse.ocl.examples.pivot.Package ele) {
		return ele.getName();
	}

	protected String image(Parameter ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Parameter_in.gif";
	}

	protected String text(Parameter ele) {
		StringBuffer s = new StringBuffer();
		appendName(s, ele);
		s.append(" : ");
		appendType(s, ele.getType());
		appendMultiplicity(s, ele);
		return s.toString();
	}

	protected String text(Precedence ele) {
		return PrettyPrintExprVisitor.prettyPrint(ele);
	}

	protected String image(PrimitiveLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/PrimitiveLiteralExp.gif";
	}

	protected String image(PrimitiveType ele) {
//		return "/org.eclipse.ocl.edit/icons/full/obj16/PrimitiveType.gif";
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/PrimitiveType.gif";
	}

	protected String image(Property ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Property.gif";
	}

	protected String text(Property ele) {
		StringBuffer s = new StringBuffer();
		appendName(s, ele);
		s.append(" : ");
		appendType(s, ele.getType());
		appendMultiplicity(s, ele);
		return s.toString();
	}

	protected String image(PropertyCallExp ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/PropertyCallExp.gif";
	}

	protected String image(RealLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/RealLiteralExp.gif";
	}

	protected String image(SequenceType ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/SequenceType.gif";
	}

	protected String image(SetType ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/SetType.gif";
	}

	protected String image(StateExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/StateExp.gif";
	}

	protected String image(StringLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/StringLiteralExp.gif";
	}

	protected String image(TemplateParameter ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/TemplateParameter.gif";
	}

	protected String text(TemplateParameter ele) {
		return text(ele.getParameteredElement());
	}

	protected String image(TemplateParameterType ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/TemplateParameterType.gif";
	}

	protected String image(TupleLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/TupleLiteralExp.gif";
	}

	protected String image(TupleLiteralPart ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/TupleLiteralPart.gif";
	}

	protected String image(TupleTypeCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/TupleType.gif";
	}

	protected String text(Type ele) {
		StringBuffer s = new StringBuffer();
		appendType(s, ele);
		return s.toString();
	}

	protected String image(TypeExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/TypeExp.gif";
	}

	protected String text(TypeRefCS ele) {
		StringBuffer s = new StringBuffer();
		appendType(s, ele);
		return s.toString();
	}

	protected String image(UnlimitedNaturalLiteralExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/UnlimitedNaturalLiteralExp.gif";
	}

	protected String image(Variable ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/Variable.gif";
	}

	protected String text(Variable ele) {
		return PrettyPrintExprVisitor.prettyPrint(ele);
	}

	protected String image(VariableExp ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/VariableExp.gif";
	}

	protected String image(VoidType ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/VoidType.gif";
	}
}
