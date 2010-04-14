/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: EcoreParserProvider.java,v 1.7 2009/05/06 14:19:21 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.providers;

import java.text.ParsePosition;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAnnotationSourceEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAttributeEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassName2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassNameEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EDataTypeInstanceClass2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EDataTypeInstanceClassEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EDataTypeName2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EDataTypeNameEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnumLiteralEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnumName2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnumNameEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EOperationEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EPackageNameEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EReferenceLowerBoundUpperBoundEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EReferenceNameEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EStringToStringMapEntryEditPart;
import org.eclipse.emf.ecoretools.diagram.parsers.MessageFormatParser;
import org.eclipse.emf.ecoretools.diagram.part.EcoreVisualIDRegistry;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EcoreParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser eClassName_4001Parser;

	/**
	 * @generated
	 */
	private IParser getEClassName_4001Parser() {
		if (eClassName_4001Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eClassName_4001Parser = parser;
		}
		return eClassName_4001Parser;
	}

	/**
	 * @generated
	 */
	private IParser ePackageName_4006Parser;

	/**
	 * @generated
	 */
	private IParser getEPackageName_4006Parser() {
		if (ePackageName_4006Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			ePackageName_4006Parser = parser;
		}
		return ePackageName_4006Parser;
	}

	/**
	 * @generated
	 */
	private IParser eAnnotationSource_4007Parser;

	/**
	 * @generated
	 */
	private IParser getEAnnotationSource_4007Parser() {
		if (eAnnotationSource_4007Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getEAnnotation_Source() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eAnnotationSource_4007Parser = parser;
		}
		return eAnnotationSource_4007Parser;
	}

	/**
	 * @generated
	 */
	private IParser eDataTypeName_4008Parser;

	/**
	 * @generated
	 */
	private IParser getEDataTypeName_4008Parser() {
		if (eDataTypeName_4008Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eDataTypeName_4008Parser = parser;
		}
		return eDataTypeName_4008Parser;
	}

	/**
	 * @generated
	 */
	private IParser eDataTypeInstanceClassName_4009Parser;

	/**
	 * @generated
	 */
	private IParser getEDataTypeInstanceClassName_4009Parser() {
		if (eDataTypeInstanceClassName_4009Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getEClassifier_InstanceClassName() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("<<javaclass>> {0}"); //$NON-NLS-1$
			parser.setEditorPattern("<<javaclass>> {0}"); //$NON-NLS-1$
			parser.setEditPattern("<<javaclass>> {0}"); //$NON-NLS-1$
			eDataTypeInstanceClassName_4009Parser = parser;
		}
		return eDataTypeInstanceClassName_4009Parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumName_4010Parser;

	/**
	 * @generated
	 */
	private IParser getEEnumName_4010Parser() {
		if (eEnumName_4010Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eEnumName_4010Parser = parser;
		}
		return eEnumName_4010Parser;
	}

	/**
	 * @generated
	 */
	private IParser eAttribute_2001Parser;

	/**
	 * @generated
	 */
	private IParser getEAttribute_2001Parser() {
		if (eAttribute_2001Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eAttribute_2001Parser = parser;
		}
		return eAttribute_2001Parser;
	}

	/**
	 * @generated
	 */
	private IParser eOperation_2002Parser;

	/**
	 * @generated
	 */
	private IParser getEOperation_2002Parser() {
		if (eOperation_2002Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eOperation_2002Parser = parser;
		}
		return eOperation_2002Parser;
	}

	/**
	 * @generated
	 */
	private IParser eClassName_4002Parser;

	/**
	 * @generated
	 */
	private IParser getEClassName_4002Parser() {
		if (eClassName_4002Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eClassName_4002Parser = parser;
		}
		return eClassName_4002Parser;
	}

	/**
	 * @generated
	 */
	private IParser eDataTypeName_4003Parser;

	/**
	 * @generated
	 */
	private IParser getEDataTypeName_4003Parser() {
		if (eDataTypeName_4003Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eDataTypeName_4003Parser = parser;
		}
		return eDataTypeName_4003Parser;
	}

	/**
	 * @generated
	 */
	private IParser eDataTypeInstanceClassName_4004Parser;

	/**
	 * @generated
	 */
	private IParser getEDataTypeInstanceClassName_4004Parser() {
		if (eDataTypeInstanceClassName_4004Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getEClassifier_InstanceClassName() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("<<javaclass>> {0}"); //$NON-NLS-1$
			parser.setEditorPattern("<<javaclass>> {0}"); //$NON-NLS-1$
			parser.setEditPattern("<<javaclass>> {0}"); //$NON-NLS-1$
			eDataTypeInstanceClassName_4004Parser = parser;
		}
		return eDataTypeInstanceClassName_4004Parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumName_4005Parser;

	/**
	 * @generated
	 */
	private IParser getEEnumName_4005Parser() {
		if (eEnumName_4005Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eEnumName_4005Parser = parser;
		}
		return eEnumName_4005Parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumLiteral_2006Parser;

	/**
	 * @generated
	 */
	private IParser getEEnumLiteral_2006Parser() {
		if (eEnumLiteral_2006Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eEnumLiteral_2006Parser = parser;
		}
		return eEnumLiteral_2006Parser;
	}

	/**
	 * @generated
	 */
	private IParser eStringToStringMapEntry_2007Parser;

	/**
	 * @generated
	 */
	private IParser getEStringToStringMapEntry_2007Parser() {
		if (eStringToStringMapEntry_2007Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getEStringToStringMapEntry_Key() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eStringToStringMapEntry_2007Parser = parser;
		}
		return eStringToStringMapEntry_2007Parser;
	}

	/**
	 * @generated
	 */
	private IParser eReferenceName_4011Parser;

	/**
	 * @generated
	 */
	private IParser getEReferenceName_4011Parser() {
		if (eReferenceName_4011Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eReferenceName_4011Parser = parser;
		}
		return eReferenceName_4011Parser;
	}

	/**
	 * @generated
	 */
	private IParser eReferenceLowerBoundUpperBound_4012Parser;

	/**
	 * @generated NOT
	 */
	private IParser getEReferenceLowerBoundUpperBound_4012Parser() {
		if (eReferenceLowerBoundUpperBound_4012Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getETypedElement_LowerBound(), EcorePackage.eINSTANCE.getETypedElement_UpperBound() };
			MessageFormatParser parser = new MessageFormatParser(features) {

				// Bug 216102 : Cardinality edition could be more intuitive
				@Override
				public ICommand getParseCommand(IAdaptable adapter, String newString, int flags) {
					String parsableString = ((String) newString).replace("*", "-1").replace("?", "-2"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
					if (parsableString.indexOf("..") == -1) { //$NON-NLS-1$
						parsableString = parsableString.concat("..").concat(parsableString); //$NON-NLS-1$
					}

					Object[] values = getEditProcessor().parse(parsableString, new ParsePosition(0));
					return getParseCommand(adapter, values, flags);
				}
			};
			parser.setViewPattern("{0}..{1,choice,-2#?|-1#*|-1<{1}}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}..{1,choice,-2#?|-1#*|-1<{1}}"); //$NON-NLS-1$
			parser.setEditPattern("{0}..{1}"); //$NON-NLS-1$
			eReferenceLowerBoundUpperBound_4012Parser = parser;
		}
		return eReferenceLowerBoundUpperBound_4012Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case EClassNameEditPart.VISUAL_ID:
			return getEClassName_4001Parser();
		case EPackageNameEditPart.VISUAL_ID:
			return getEPackageName_4006Parser();
		case EAnnotationSourceEditPart.VISUAL_ID:
			return getEAnnotationSource_4007Parser();
		case EDataTypeNameEditPart.VISUAL_ID:
			return getEDataTypeName_4008Parser();
		case EDataTypeInstanceClassEditPart.VISUAL_ID:
			return getEDataTypeInstanceClassName_4009Parser();
		case EEnumNameEditPart.VISUAL_ID:
			return getEEnumName_4010Parser();
		case EAttributeEditPart.VISUAL_ID:
			return getEAttribute_2001Parser();
		case EOperationEditPart.VISUAL_ID:
			return getEOperation_2002Parser();
		case EClassName2EditPart.VISUAL_ID:
			return getEClassName_4002Parser();
		case EDataTypeName2EditPart.VISUAL_ID:
			return getEDataTypeName_4003Parser();
		case EDataTypeInstanceClass2EditPart.VISUAL_ID:
			return getEDataTypeInstanceClassName_4004Parser();
		case EEnumName2EditPart.VISUAL_ID:
			return getEEnumName_4005Parser();
		case EEnumLiteralEditPart.VISUAL_ID:
			return getEEnumLiteral_2006Parser();
		case EStringToStringMapEntryEditPart.VISUAL_ID:
			return getEStringToStringMapEntry_2007Parser();
		case EReferenceNameEditPart.VISUAL_ID:
			return getEReferenceName_4011Parser();
		case EReferenceLowerBoundUpperBoundEditPart.VISUAL_ID:
			return getEReferenceLowerBoundUpperBound_4012Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * 
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(EcoreVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(EcoreVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (EcoreElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
