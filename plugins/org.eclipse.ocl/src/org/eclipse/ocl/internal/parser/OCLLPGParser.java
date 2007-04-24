/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D. Willink - Elimination of some shift-reduce conflicts
 *
 * </copyright>
 *
 * $Id: OCLLPGParser.java,v 1.11 2007/04/24 23:27:58 cdamus Exp $
 */

package org.eclipse.ocl.internal.parser;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.internal.cst.BooleanLiteralExpCS;
import org.eclipse.ocl.internal.cst.CSTFactory;
import org.eclipse.ocl.internal.cst.CSTNode;
import org.eclipse.ocl.internal.cst.CallExpCS;
import org.eclipse.ocl.internal.cst.ClassifierContextDeclCS;
import org.eclipse.ocl.internal.cst.CollectionLiteralExpCS;
import org.eclipse.ocl.internal.cst.CollectionLiteralPartCS;
import org.eclipse.ocl.internal.cst.CollectionRangeCS;
import org.eclipse.ocl.internal.cst.CollectionTypeCS;
import org.eclipse.ocl.internal.cst.CollectionTypeIdentifierEnum;
import org.eclipse.ocl.internal.cst.DefCS;
import org.eclipse.ocl.internal.cst.DefExpressionCS;
import org.eclipse.ocl.internal.cst.DerValueCS;
import org.eclipse.ocl.internal.cst.DotOrArrowEnum;
import org.eclipse.ocl.internal.cst.EnumLiteralExpCS;
import org.eclipse.ocl.internal.cst.FeatureCallExpCS;
import org.eclipse.ocl.internal.cst.IfExpCS;
import org.eclipse.ocl.internal.cst.InitOrDerValueCS;
import org.eclipse.ocl.internal.cst.InitValueCS;
import org.eclipse.ocl.internal.cst.IntegerLiteralExpCS;
import org.eclipse.ocl.internal.cst.InvCS;
import org.eclipse.ocl.internal.cst.InvOrDefCS;
import org.eclipse.ocl.internal.cst.InvalidLiteralExpCS;
import org.eclipse.ocl.internal.cst.IsMarkedPreCS;
import org.eclipse.ocl.internal.cst.IterateExpCS;
import org.eclipse.ocl.internal.cst.IteratorExpCS;
import org.eclipse.ocl.internal.cst.LetExpCS;
import org.eclipse.ocl.internal.cst.MessageExpCS;
import org.eclipse.ocl.internal.cst.MessageExpKind;
import org.eclipse.ocl.internal.cst.NullLiteralExpCS;
import org.eclipse.ocl.internal.cst.OCLExpressionCS;
import org.eclipse.ocl.internal.cst.OCLMessageArgCS;
import org.eclipse.ocl.internal.cst.OperationCS;
import org.eclipse.ocl.internal.cst.OperationCallExpCS;
import org.eclipse.ocl.internal.cst.OperationContextDeclCS;
import org.eclipse.ocl.internal.cst.PackageDeclarationCS;
import org.eclipse.ocl.internal.cst.PathNameCS;
import org.eclipse.ocl.internal.cst.PrePostOrBodyDeclCS;
import org.eclipse.ocl.internal.cst.PrePostOrBodyEnum;
import org.eclipse.ocl.internal.cst.PrimitiveTypeCS;
import org.eclipse.ocl.internal.cst.PropertyContextCS;
import org.eclipse.ocl.internal.cst.RealLiteralExpCS;
import org.eclipse.ocl.internal.cst.SimpleNameCS;
import org.eclipse.ocl.internal.cst.SimpleTypeEnum;
import org.eclipse.ocl.internal.cst.StateExpCS;
import org.eclipse.ocl.internal.cst.StringLiteralExpCS;
import org.eclipse.ocl.internal.cst.TupleLiteralExpCS;
import org.eclipse.ocl.internal.cst.TupleTypeCS;
import org.eclipse.ocl.internal.cst.TypeCS;
import org.eclipse.ocl.internal.cst.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.internal.cst.VariableCS;
import org.eclipse.ocl.internal.cst.VariableExpCS;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;

import lpg.lpgjavaruntime.BadParseException;
import lpg.lpgjavaruntime.BadParseSymFileException;
import lpg.lpgjavaruntime.DeterministicParser;
import lpg.lpgjavaruntime.DiagnoseParser;
import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.LexStream;
import lpg.lpgjavaruntime.Monitor;
import lpg.lpgjavaruntime.NotDeterministicParseTableException;
import lpg.lpgjavaruntime.NullExportedSymbolsException;
import lpg.lpgjavaruntime.NullTerminalSymbolsException;
import lpg.lpgjavaruntime.ParseTable;
import lpg.lpgjavaruntime.PrsStream;
import lpg.lpgjavaruntime.RuleAction;
import lpg.lpgjavaruntime.UndefinedEofSymbolException;
import lpg.lpgjavaruntime.UnimplementedTerminalsException;

@SuppressWarnings( {"unchecked", "nls"})
public class OCLLPGParser
    extends PrsStream
    implements RuleAction {

    protected static ParseTable prs = new OCLLPGParserprs();

    private DeterministicParser dtParser;

    public OCLLPGParser(LexStream lexStream) {
        super(lexStream);

        try {
            super.remapTerminalSymbols(orderedTerminalSymbols(),
                OCLLPGParserprs.EOFT_SYMBOL);
        } catch (NullExportedSymbolsException e) {
            throw new RuntimeException(e.getLocalizedMessage());
        } catch (NullTerminalSymbolsException e) {
            throw new RuntimeException(e.getLocalizedMessage());
        } catch (UnimplementedTerminalsException e) {
            java.util.ArrayList unimplemented_symbols = e.getSymbols();
            String error = "The Lexer will not scan the following token(s):";
            for (int i = 0; i < unimplemented_symbols.size(); i++) {
                Integer id = (Integer) unimplemented_symbols.get(i);
                error += "\t"
                    + OCLLPGParsersym.orderedTerminalSymbols[id.intValue()];
            }
            throw new RuntimeException(error + "\n");
        } catch (UndefinedEofSymbolException e) {
            throw new RuntimeException(
                "The Lexer does not implement the Eof symbol "
                    + OCLLPGParsersym.orderedTerminalSymbols[OCLLPGParserprs.EOFT_SYMBOL]);
        }
    }

    @Override
    public String[] orderedTerminalSymbols() {
        return OCLLPGParsersym.orderedTerminalSymbols;
    }

    public String getTokenKindName(int kind) {
        return OCLLPGParsersym.orderedTerminalSymbols[kind];
    }

    public int getEOFTokenKind() {
        return OCLLPGParserprs.EOFT_SYMBOL;
    }

    public PrsStream getParseStream() {
        return this;
    }

    protected EObject parser()
        throws ParserException {
        return parser(null, 0);
    }

    protected EObject parser(Monitor monitor)
        throws ParserException {
        return parser(monitor, 0);
    }

    protected EObject parser(int error_repair_count)
        throws ParserException {
        return parser(null, error_repair_count);
    }

    protected EObject parser(Monitor monitor, int error_repair_count)
        throws ParserException {
        ParseTable prsTable = new OCLLPGParserprs();

        try {
            dtParser = new DeterministicParser(monitor, this, prsTable, this);
        } catch (NotDeterministicParseTableException e) {
            throw new RuntimeException(
                "****Error: Regenerate OCLLPGParserprs.java with -NOBACKTRACK option");
        } catch (BadParseSymFileException e) {
            throw new RuntimeException(
                "****Error: Bad Parser Symbol File -- OCLLPGParsersym.java. Regenerate OCLLPGParserprs.java");
        }

        try {
            return (EObject) dtParser.parse();
        } catch (BadParseException e) {
            reset(e.error_token); // point to error token

            DiagnoseParser diagnoseParser = new DiagnoseParser(this, prsTable);
            diagnoseParser.diagnose(e.error_token);
        }

        return null;
    }

    protected PackageDeclarationCS createPackageDeclarationCS(
            PathNameCS pathNameCS, EList contextDecls) {
        PackageDeclarationCS result = CSTFactory.eINSTANCE
            .createPackageDeclarationCS();
        result.setPathNameCS(pathNameCS);
        if (contextDecls != null && !contextDecls.isEmpty()) {
            result.getContextDecls().addAll(contextDecls);
        }
        return result;
    }

    protected PropertyContextCS createPropertyContextCS(PathNameCS pathNameCS,
            SimpleNameCS simpleNameCS, TypeCS typeCS,
            InitOrDerValueCS initOrDerValueCS) {
        PropertyContextCS result = CSTFactory.eINSTANCE
            .createPropertyContextCS();
        result.setPathNameCS(pathNameCS);
        result.setSimpleNameCS(simpleNameCS);
        result.setTypeCS(typeCS);
        result.setInitOrDerValueCS(initOrDerValueCS);
        return result;
    }

    protected DerValueCS createDerValueCS(InitOrDerValueCS initOrDerValueCS,
            OCLExpressionCS oclExpressionCS) {
        DerValueCS result = CSTFactory.eINSTANCE.createDerValueCS();
        result.setInitOrDerValueCS(initOrDerValueCS);
        result.setExpressionCS(oclExpressionCS);
        return result;
    }

    protected InitValueCS createInitValueCS(InitOrDerValueCS initOrDerValueCS,
            OCLExpressionCS oclExpressionCS) {
        InitValueCS result = CSTFactory.eINSTANCE.createInitValueCS();
        result.setInitOrDerValueCS(initOrDerValueCS);
        result.setExpressionCS(oclExpressionCS);
        return result;
    }

    protected ClassifierContextDeclCS createClassifierContextDeclCS(
            PathNameCS pathNameCS, InvOrDefCS invOrDefCS) {
        ClassifierContextDeclCS result = CSTFactory.eINSTANCE
            .createClassifierContextDeclCS();
        result.setPathNameCS(pathNameCS);
        result.setInvOrDefCS(invOrDefCS);
        return result;
    }

    protected InvCS createInvCS(InvOrDefCS invOrDefCS,
            SimpleNameCS simpleNameCS, OCLExpressionCS oclExpressionCS) {
        InvCS result = CSTFactory.eINSTANCE.createInvCS();
        result.setSimpleNameCS(simpleNameCS);
        result.setExpressionCS(oclExpressionCS);
        result.setInvOrDefCS(invOrDefCS);
        return result;
    }

    protected DefCS createDefCS(InvOrDefCS invOrDefCS,
            SimpleNameCS simpleNameCS, DefExpressionCS defExpressionCS) {
        DefCS result = CSTFactory.eINSTANCE.createDefCS();
        result.setSimpleNameCS(simpleNameCS);
        result.setDefExpressionCS(defExpressionCS);
        result.setInvOrDefCS(invOrDefCS);
        return result;
    }

    protected DefExpressionCS createDefExpressionCS(VariableCS variableCS,
            OperationCS operationCS, OCLExpressionCS oclExpressionCS) {
        DefExpressionCS result = CSTFactory.eINSTANCE.createDefExpressionCS();
        result.setVariableCS(variableCS);
        result.setOperationCS(operationCS);
        result.setExpressionCS(oclExpressionCS);
        return result;
    }

    protected OperationContextDeclCS createOperationContextDeclCS(
            OperationCS operationCS, EList prePostOrBodyDecls) {
        OperationContextDeclCS result = CSTFactory.eINSTANCE
            .createOperationContextDeclCS();
        result.setOperationCS(operationCS);
        result.getPrePostOrBodyDecls().addAll(prePostOrBodyDecls);
        return result;
    }

    protected PrePostOrBodyDeclCS createPrePostOrBodyDeclCS(
            PrePostOrBodyEnum kind, SimpleNameCS simpleNameCS,
            OCLExpressionCS oclExpressionCS) {
        PrePostOrBodyDeclCS result = CSTFactory.eINSTANCE
            .createPrePostOrBodyDeclCS();
        result.setKind(kind);
        result.setSimpleNameCS(simpleNameCS);
        result.setExpressionCS(oclExpressionCS);
        return result;
    }

    protected OperationCS createOperationCS(PathNameCS pathNameCS,
            SimpleNameCS simpleNameCS, EList list, TypeCS typeCS) {
        OperationCS result = CSTFactory.eINSTANCE.createOperationCS();
        result.setPathNameCS(pathNameCS);
        result.setSimpleNameCS(simpleNameCS);
        result.getParameters().addAll(list);
        result.setTypeCS(typeCS);
        return result;
    }

    protected OperationCS createOperationCS(String simpleName, EList list,
            TypeCS typeCS) {
        return createOperationCS(null, createSimpleNameCS(
            SimpleTypeEnum.IDENTIFIER_LITERAL, simpleName), list, typeCS);
    }

    protected OperationCallExpCS createOperationCallExpCS(
            OCLExpressionCS oclExpressionCS, SimpleNameCS simpleNameCS,
            IsMarkedPreCS isMarkedPreCS, EList arguments) {
        OperationCallExpCS result = CSTFactory.eINSTANCE
            .createOperationCallExpCS();
        result.setSource(oclExpressionCS);
        result.setSimpleNameCS(simpleNameCS);
        result.setIsMarkedPreCS(isMarkedPreCS);
        result.getArguments().addAll(arguments);
        return result;
    }

    protected OperationCallExpCS createOperationCallExpCS(
            OCLExpressionCS oclExpressionCS, SimpleNameCS simpleNameCS,
            EList arguments) {
        return createOperationCallExpCS(oclExpressionCS, simpleNameCS,
            createIsMarkedPreCS(false), arguments);
    }

    protected OperationCallExpCS createOperationCallExpCS(
            SimpleNameCS simpleNameCS, IsMarkedPreCS isMarkedPreCS,
            EList arguments) {
        return createOperationCallExpCS(null, simpleNameCS, isMarkedPreCS,
            arguments);
    }

    protected OperationCallExpCS createOperationCallExpCS(
            SimpleNameCS simpleNameCS, IsMarkedPreCS isMarkedPreCS,
            StateExpCS stateExpCS) {
        OperationCallExpCS result = CSTFactory.eINSTANCE
            .createOperationCallExpCS();
        result.setSimpleNameCS(simpleNameCS);
        result.setIsMarkedPreCS(isMarkedPreCS);
        result.getArguments().add(stateExpCS);
        return result;
    }

    private StateExpCS createStateExpCS(PathNameCS pathName) {
        StateExpCS result = CSTFactory.eINSTANCE.createStateExpCS();
        result.getSequenceOfNames().addAll(pathName.getSequenceOfNames());
        return result;
    }

    protected VariableExpCS createVariableExpCS(SimpleNameCS simpleNameCS,
            EList arguments, IsMarkedPreCS isMarkedPreCS) {
        VariableExpCS result = CSTFactory.eINSTANCE.createVariableExpCS();
        result.setSimpleNameCS(simpleNameCS);
        result.getArguments().addAll(arguments);
        result.setIsMarkedPreCS(isMarkedPreCS);
        return result;
    }

    protected SimpleNameCS createSimpleNameCS(SimpleTypeEnum type, String value) {
        SimpleNameCS result = CSTFactory.eINSTANCE.createSimpleNameCS();
        result.setType(type);
        result.setValue(unquote(value));
        return result;
    }

    protected PrimitiveTypeCS createPrimitiveTypeCS(SimpleTypeEnum type,
            String value) {
        PrimitiveTypeCS result = CSTFactory.eINSTANCE.createPrimitiveTypeCS();
        result.setType(type);
        result.setValue(value);
        return result;
    }

    /**
     * Removes the "s surrounding a quoted string, if any.
     * 
     * @param quoted
     *            a possibly quoted string
     * @return <code>quoted</code> without the surrounding quotes, or just
     *         <code>quoted</code> verbatim if there were none
     */
    protected String unquote(String quoted) {
        String result = quoted;

        if ((result != null) && (result.length() > 1)) {
            int max = result.length() - 1;

            if ((result.charAt(0) == '"') && (quoted.charAt(max) == '"')) {
                result = result.substring(1, max);
            }

            // this is a regexp, so the backslash needs to be
            // re-escaped, thus "\\" is rendered in a Java
            // string literal as "\\\\"
            result = result.replaceAll("\\\\\"", "\""); //$NON-NLS-2$//$NON-NLS-1$
        }

        return result;
    }

    private PathNameCS createPathNameCS(String pathName) {
        PathNameCS result = CSTFactory.eINSTANCE.createPathNameCS();
        result.getSequenceOfNames().add(unquote(pathName));
        return result;
    }

    private PathNameCS extendPathNameCS(PathNameCS path, String name) {
        path.getSequenceOfNames().add(unquote(name));
        return path;
    }

    private PathNameCS createPathNameCS() {
        return CSTFactory.eINSTANCE.createPathNameCS();
    }

    protected EnumLiteralExpCS createEnumLiteralExpCS(PathNameCS pathNameCS,
            SimpleNameCS simpleNameCS) {
        EnumLiteralExpCS result = CSTFactory.eINSTANCE.createEnumLiteralExpCS();
        result.setPathNameCS(pathNameCS);
        result.setSimpleNameCS(simpleNameCS);
        return result;
    }

    protected EnumLiteralExpCS createEnumLiteralExpCS(PathNameCS pathNameCS,
            String simpleName) {
        return createEnumLiteralExpCS(pathNameCS, createSimpleNameCS(
            SimpleTypeEnum.IDENTIFIER_LITERAL, simpleName));
    }

    protected CollectionLiteralExpCS createCollectionLiteralExpCS(
            CollectionTypeIdentifierEnum type, EList collectionLiteralParts) {
        CollectionLiteralExpCS result = CSTFactory.eINSTANCE
            .createCollectionLiteralExpCS();
        result.setCollectionType(type);
        result.getCollectionLiteralParts().addAll(collectionLiteralParts);
        return result;
    }

    protected CollectionLiteralPartCS createCollectionLiteralPartCS(
            OCLExpressionCS oclExpressionCS) {
        CollectionLiteralPartCS result = CSTFactory.eINSTANCE
            .createCollectionLiteralPartCS();
        result.setExpressionCS(oclExpressionCS);
        return result;
    }

    protected CollectionRangeCS createCollectionRangeCS(
            OCLExpressionCS oclExpressionCS, OCLExpressionCS lastOCLExpressionCS) {
        CollectionRangeCS result = CSTFactory.eINSTANCE
            .createCollectionRangeCS();
        result.setExpressionCS(oclExpressionCS);
        result.setLastExpressionCS(lastOCLExpressionCS);
        return result;
    }

    protected IntegerLiteralExpCS createRangeStart(String integerDotDot,
            boolean isNegative) {
        String intToken = integerDotDot
            .substring(0, integerDotDot.indexOf('.'));
        int intValue = Integer.parseInt(intToken);
        if (isNegative) {
            intValue = -intValue;
        }

        IntegerLiteralExpCS result = CSTFactory.eINSTANCE
            .createIntegerLiteralExpCS();
        result.setIntegerSymbol(new Integer(intValue));
        result.setSymbol(Integer.toString(intValue));

        return result;
    }

    protected TupleLiteralExpCS createTupleLiteralExpCS(EList variables) {
        TupleLiteralExpCS result = CSTFactory.eINSTANCE
            .createTupleLiteralExpCS();
        result.getVariables().addAll(variables);
        return result;
    }

    protected IntegerLiteralExpCS createIntegerLiteralExpCS(String string) {
        IntegerLiteralExpCS result = CSTFactory.eINSTANCE
            .createIntegerLiteralExpCS();
        result.setSymbol(string);
        result.setIntegerSymbol(Integer.valueOf(string));
        return result;
    }

    protected UnlimitedNaturalLiteralExpCS createUnlimitedNaturalLiteralExpCS(
            String string) {
        UnlimitedNaturalLiteralExpCS result = CSTFactory.eINSTANCE
            .createUnlimitedNaturalLiteralExpCS();
        result.setSymbol(string);
        if ("*".equals(string)) {
            result.setIntegerSymbol(-1);
        } else {
            result.setIntegerSymbol(Integer.valueOf(string));
        }
        return result;
    }

    protected RealLiteralExpCS createRealLiteralExpCS(String string) {
        RealLiteralExpCS result = CSTFactory.eINSTANCE.createRealLiteralExpCS();
        result.setSymbol(string);
        result.setRealSymbol(Double.valueOf(string));
        return result;
    }

    protected StringLiteralExpCS createStringLiteralExpCS(String string) {
        StringLiteralExpCS result = CSTFactory.eINSTANCE
            .createStringLiteralExpCS();
        result.setSymbol(string);
        result.setStringSymbol(string);
        return result;
    }

    protected BooleanLiteralExpCS createBooleanLiteralExpCS(String string) {
        BooleanLiteralExpCS result = CSTFactory.eINSTANCE
            .createBooleanLiteralExpCS();
        result.setSymbol(string);
        result.setBooleanSymbol(Boolean.valueOf(string));
        return result;
    }

    protected NullLiteralExpCS createNullLiteralExpCS(String string) {
        NullLiteralExpCS result = CSTFactory.eINSTANCE.createNullLiteralExpCS();
        result.setSymbol(string);
        return result;
    }

    protected InvalidLiteralExpCS createInvalidLiteralExpCS(String string) {
        InvalidLiteralExpCS result = CSTFactory.eINSTANCE
            .createInvalidLiteralExpCS();
        result.setSymbol(string);
        return result;
    }

    protected IteratorExpCS createIteratorExpCS(SimpleNameCS simpleNameCS,
            VariableCS variable1, VariableCS variable2,
            OCLExpressionCS oclExpressionCS) {
        IteratorExpCS result = CSTFactory.eINSTANCE.createIteratorExpCS();
        result.setSimpleNameCS(simpleNameCS);
        result.setVariable1(variable1);
        result.setVariable2(variable2);
        result.setBody(oclExpressionCS);
        return result;
    }

    protected IterateExpCS createIterateExpCS(SimpleNameCS simpleNameCS,
            VariableCS variable1, VariableCS variable2,
            OCLExpressionCS oclExpressionCS) {
        IterateExpCS result = CSTFactory.eINSTANCE.createIterateExpCS();
        result.setSimpleNameCS(simpleNameCS);
        result.setVariable1(variable1);
        result.setVariable2(variable2);
        result.setBody(oclExpressionCS);
        return result;
    }

    protected VariableCS createVariableCS(String varName, TypeCS typeCS,
            OCLExpressionCS oclExpressionCS) {
        VariableCS result = CSTFactory.eINSTANCE.createVariableCS();
        result.setName(unquote(varName));
        result.setTypeCS(typeCS);
        result.setInitExpression(oclExpressionCS);
        return result;
    }

    protected CollectionTypeCS createCollectionTypeCS(
            CollectionTypeIdentifierEnum collectionType, TypeCS typeCS) {
        CollectionTypeCS result = CSTFactory.eINSTANCE.createCollectionTypeCS();
        result.setCollectionTypeIdentifier(collectionType);
        result.setTypeCS(typeCS);
        return result;
    }

    protected TupleTypeCS createTupleTypeCS(EList variables) {
        TupleTypeCS result = CSTFactory.eINSTANCE.createTupleTypeCS();
        result.getVariables().addAll(variables);
        return result;
    }

    protected FeatureCallExpCS createFeatureCallExpCS(
            SimpleNameCS simpleNameCS, EList arguments,
            IsMarkedPreCS isMarkedPreCS) {
        FeatureCallExpCS result = CSTFactory.eINSTANCE.createFeatureCallExpCS();
        result.setSimpleNameCS(simpleNameCS);
        result.getArguments().addAll(arguments);
        result.setIsMarkedPreCS(isMarkedPreCS);
        return result;
    }

    protected IsMarkedPreCS createIsMarkedPreCS(boolean isMarkedPre) {
        IsMarkedPreCS result = CSTFactory.eINSTANCE.createIsMarkedPreCS();
        result.setPre(isMarkedPre);
        return result;
    }

    protected LetExpCS createLetExpCS(EList variables,
            OCLExpressionCS oclExpressionCS) {
        LetExpCS result = CSTFactory.eINSTANCE.createLetExpCS();
        result.getVariables().addAll(variables);
        result.setInExpression(oclExpressionCS);
        return result;
    }

    protected IfExpCS createIfExpCS(OCLExpressionCS condition,
            OCLExpressionCS thenExpression, OCLExpressionCS elseExpression) {
        IfExpCS result = CSTFactory.eINSTANCE.createIfExpCS();
        result.setCondition(condition);
        result.setThenExpression(thenExpression);
        result.setElseExpression(elseExpression);
        return result;
    }

    protected MessageExpCS createMessageExpCS(int kind,
            SimpleNameCS simpleNameCS, EList oclMessageArgs) {
        MessageExpCS result = CSTFactory.eINSTANCE.createMessageExpCS();
        result
            .setKind((kind == OCLLPGParsersym.TK_CARET) ? MessageExpKind.HAS_SENT_LITERAL
                : MessageExpKind.SENT_LITERAL);
        result.setSimpleNameCS(simpleNameCS);
        result.getArguments().addAll(oclMessageArgs);
        return result;
    }

    protected OCLMessageArgCS createOCLMessageArgCS(TypeCS typeCS,
            OCLExpressionCS oclExpressionCS) {
        OCLMessageArgCS result = CSTFactory.eINSTANCE.createOCLMessageArgCS();
        result.setTypeCS(typeCS);
        result.setExpression(oclExpressionCS);
        return result;
    }

    /**
     * Sets the start and end offsets of the given <code>CSTNode</code> to the
     * start and end offsets of the given <code>IToken</code>
     * 
     * @param cstNode
     *            <code>CSTNode</code> to set offsets
     * @param startEnd
     *            <code>IToken</code> to retrieve offsets from
     */
    protected void setOffsets(CSTNode cstNode, IToken startEnd) {
        cstNode.setStartOffset(startEnd.getStartOffset());
        cstNode.setEndOffset(startEnd.getEndOffset());
    }

    /**
     * Sets the start and end offsets of the given <code>CSTNode</code> to the
     * start and end offsets of the 2nd given <code>CSTNode</code>
     * 
     * @param cstNode
     *            <code>CSTNode</code> to set offsets
     * @param startEnd
     *            <code>CSTNode</code> to retrieve offsets from
     */
    protected void setOffsets(CSTNode cstNode, CSTNode startEnd) {
        cstNode.setStartOffset(startEnd.getStartOffset());
        cstNode.setEndOffset(startEnd.getEndOffset());
    }

    /**
     * Sets the start and end offsets of the given <code>CSTNode</code> to the
     * start offset of the 2nd given <code>CSTNode</code> and the end offset
     * of the 3rd given <code>CSTNode</code>
     * 
     * @param cstNode
     *            <code>CSTNode</code> to set offsets
     * @param start
     *            <code>CSTNode</code> to retrieve start offset from
     * @param end
     *            <code>CSTNode</code> to retrieve end offset from
     */
    protected void setOffsets(CSTNode cstNode, CSTNode start, CSTNode end) {
        cstNode.setStartOffset(start.getStartOffset());
        cstNode.setEndOffset(end.getEndOffset());
    }

    /**
     * Sets the start and end offsets of the given <code>CSTNode</code> to the
     * start offset of the 2nd given <code>CSTNode</code> and the end offset
     * of the given <code>IToken</code>
     * 
     * @param cstNode
     *            <code>CSTNode</code> to set offsets
     * @param start
     *            <code>CSTNode</code> to retrieve start offset from
     * @param end
     *            <code>IToken</code> to retrieve end offset from
     */
    protected void setOffsets(CSTNode cstNode, CSTNode start, IToken end) {
        cstNode.setStartOffset(start.getStartOffset());
        cstNode.setEndOffset(end.getEndOffset());
    }

    /**
     * Sets the start and end offsets of the given <code>CSTNode</code> to the
     * start offset of the given <code>IToken</code> and the end offset of the
     * 2nd given <code>CSTNode</code>
     * 
     * @param cstNode
     *            <code>CSTNode</code> to set offsets
     * @param start
     *            <code>IToken</code> to retrieve start offset from
     * @param end
     *            <code>CSTNode</code> to retrieve end offset from
     */
    protected void setOffsets(CSTNode cstNode, IToken start, CSTNode end) {
        cstNode.setStartOffset(start.getStartOffset());
        cstNode.setEndOffset(end.getEndOffset());
    }

    /**
     * Sets the start and end offsets of the given <code>CSTNode</code> to the
     * start offset of the 1std given <code>IToken</code> and the end offset
     * of the 2nd given <code>IToken</code>
     * 
     * @param cstNode
     *            <code>CSTNode</code> to set offsets
     * @param start
     *            <code>IToken</code> to retrieve start offset from
     * @param end
     *            <code>IToken</code> to retrieve end offset from
     */
    protected void setOffsets(CSTNode cstNode, IToken start, IToken end) {
        cstNode.setStartOffset(start.getStartOffset());
        cstNode.setEndOffset(end.getEndOffset());
    }

    public void ruleAction(int ruleNumber) {
        switch (ruleNumber) {

            //
            // Rule 32: packageDeclarationCSm ::= packageDeclarationCSm
            // packageDeclarationCS
            //
            case 32: {

                PackageDeclarationCS result = (PackageDeclarationCS) dtParser
                    .getSym(2);
                result.setPackageDeclarationCS((PackageDeclarationCS) dtParser
                    .getSym(1));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 33: packageDeclarationCS ::= package pathNameCS
                // contextDeclCSmopt endpackage
                //
            case 33: {

                CSTNode result = createPackageDeclarationCS(
                    (PathNameCS) dtParser.getSym(2), (EList) dtParser.getSym(3));
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 34: packageDeclarationCS1 ::= contextDeclCSm
                //
            case 34: {

                EList contextDecls = (EList) dtParser.getSym(1);
                CSTNode result = createPackageDeclarationCS(null, contextDecls);
                if (!contextDecls.isEmpty()) {
                    setOffsets(result, (CSTNode) contextDecls.get(0),
                        (CSTNode) contextDecls.get(contextDecls.size() - 1));
                }
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 35: contextDeclCSmopt ::= $Empty
                //
            case 35:
                dtParser.setSym1(new BasicEList());
                break;

            //
            // Rule 37: contextDeclCSm ::= contextDeclCS
            //
            case 37: {

                EList result = new BasicEList();
                result.add(dtParser.getSym(1));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 38: contextDeclCSm ::= contextDeclCSm contextDeclCS
                //
            case 38: {

                EList result = (EList) dtParser.getSym(1);
                result.add(dtParser.getSym(2));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 42: propertyContextCS ::= context pathNameCS ::
                // simpleNameCS : typeCS initOrDerValueCS
                //
            case 42: {

                CSTNode result = createPropertyContextCS((PathNameCS) dtParser
                    .getSym(2), (SimpleNameCS) dtParser.getSym(4),
                    (TypeCS) dtParser.getSym(6), (InitOrDerValueCS) dtParser
                        .getSym(7));
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    (CSTNode) dtParser.getSym(7));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 43: initOrDerValueCS ::= initOrDerValueCSopt init :
                // oclExpressionCS
                //
            case 43: {

                CSTNode result = createInitValueCS((InitOrDerValueCS) dtParser
                    .getSym(1), (OCLExpressionCS) dtParser.getSym(4));
                if (dtParser.getSym(1) != null) {
                    setOffsets(result, (CSTNode) dtParser.getSym(1),
                        (CSTNode) dtParser.getSym(4));
                } else {
                    setOffsets(result, getIToken(dtParser.getToken(2)),
                        (CSTNode) dtParser.getSym(4));
                }
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 44: initOrDerValueCS ::= initOrDerValueCSopt derive :
                // oclExpressionCS
                //
            case 44: {

                CSTNode result = createDerValueCS((InitOrDerValueCS) dtParser
                    .getSym(1), (OCLExpressionCS) dtParser.getSym(4));
                if (dtParser.getSym(1) != null) {
                    setOffsets(result, (CSTNode) dtParser.getSym(1),
                        (CSTNode) dtParser.getSym(4));
                } else {
                    setOffsets(result, getIToken(dtParser.getToken(2)),
                        (CSTNode) dtParser.getSym(4));
                }
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 45: initOrDerValueCSopt ::= $Empty
                //
            case 45:
                dtParser.setSym1(null);
                break;

            //
            // Rule 47: classifierContextDeclCS ::= context pathNameCS
            // invOrDefCS
            //
            case 47: {

                CSTNode result = createClassifierContextDeclCS(
                    (PathNameCS) dtParser.getSym(2), (InvOrDefCS) dtParser
                        .getSym(3));
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    (CSTNode) dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 48: invOrDefCSopt ::= $Empty
                //
            case 48:
                dtParser.setSym1(null);
                break;

            //
            // Rule 50: invOrDefCS ::= invOrDefCSopt inv simpleNameCSopt :
            // oclExpressionCS
            //
            case 50: {

                CSTNode result = createInvCS((InvOrDefCS) dtParser.getSym(1),
                    (SimpleNameCS) dtParser.getSym(3),
                    (OCLExpressionCS) dtParser.getSym(5));
                if (dtParser.getSym(1) != null) {
                    setOffsets(result, (CSTNode) dtParser.getSym(1),
                        (CSTNode) dtParser.getSym(5));
                } else {
                    setOffsets(result, getIToken(dtParser.getToken(2)),
                        (CSTNode) dtParser.getSym(5));
                }
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 51: invOrDefCS ::= invOrDefCSopt def simpleNameCSopt :
                // defExpressionCS
                //
            case 51: {

                CSTNode result = createDefCS((InvOrDefCS) dtParser.getSym(1),
                    (SimpleNameCS) dtParser.getSym(3),
                    (DefExpressionCS) dtParser.getSym(5));
                if (dtParser.getSym(1) != null) {
                    setOffsets(result, (CSTNode) dtParser.getSym(1),
                        (CSTNode) dtParser.getSym(5));
                } else {
                    setOffsets(result, getIToken(dtParser.getToken(2)),
                        (CSTNode) dtParser.getSym(5));
                }
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 52: defExpressionCS ::= IDENTIFIER : typeCS =
                // oclExpressionCS
                //
            case 52: {

                VariableCS variableCS = createVariableCS(getTokenText(dtParser
                    .getToken(1)), (TypeCS) dtParser.getSym(3), null);
                setOffsets(variableCS, getIToken(dtParser.getToken(1)),
                    (CSTNode) dtParser.getSym(3));
                CSTNode result = createDefExpressionCS(variableCS, null,
                    (OCLExpressionCS) dtParser.getSym(5));
                setOffsets(result, variableCS, (CSTNode) dtParser.getSym(5));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 53: defExpressionCS ::= operationCS1 = oclExpressionCS
                //
            case 53: {

                CSTNode result = createDefExpressionCS(null,
                    (OperationCS) dtParser.getSym(1),
                    (OCLExpressionCS) dtParser.getSym(3));
                setOffsets(result, (CSTNode) dtParser.getSym(1),
                    (CSTNode) dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 54: operationContextDeclCS ::= context operationCS2
                // prePostOrBodyDeclCSm
                //
            case 54: {

                EList prePostOrBodyDecls = (EList) dtParser.getSym(3);
                CSTNode result = createOperationContextDeclCS(
                    (OperationCS) dtParser.getSym(2), prePostOrBodyDecls);
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    (CSTNode) prePostOrBodyDecls
                        .get(prePostOrBodyDecls.size() - 1));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 55: prePostOrBodyDeclCSm ::= prePostOrBodyDeclCS
                //
            case 55: {

                EList result = new BasicEList();
                result.add(dtParser.getSym(1));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 56: prePostOrBodyDeclCSm ::= prePostOrBodyDeclCSm
                // prePostOrBodyDeclCS
                //
            case 56: {

                EList result = (EList) dtParser.getSym(1);
                result.add(dtParser.getSym(2));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 57: prePostOrBodyDeclCS ::= pre simpleNameCSopt :
                // oclExpressionCS
                //
            case 57: {

                CSTNode result = createPrePostOrBodyDeclCS(
                    PrePostOrBodyEnum.PRE_LITERAL, (SimpleNameCS) dtParser
                        .getSym(2), (OCLExpressionCS) dtParser.getSym(4));
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    (CSTNode) dtParser.getSym(4));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 58: prePostOrBodyDeclCS ::= post simpleNameCSopt :
                // oclExpressionCS
                //
            case 58: {

                CSTNode result = createPrePostOrBodyDeclCS(
                    PrePostOrBodyEnum.POST_LITERAL, (SimpleNameCS) dtParser
                        .getSym(2), (OCLExpressionCS) dtParser.getSym(4));
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    (CSTNode) dtParser.getSym(4));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 59: prePostOrBodyDeclCS ::= body simpleNameCSopt :
                // oclExpressionCS
                //
            case 59: {

                CSTNode result = createPrePostOrBodyDeclCS(
                    PrePostOrBodyEnum.BODY_LITERAL, (SimpleNameCS) dtParser
                        .getSym(2), (OCLExpressionCS) dtParser.getSym(4));
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    (CSTNode) dtParser.getSym(4));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 62: operationCS1 ::= IDENTIFIER ( parametersCSopt ) :
                // typeCSopt
                //
            case 62: {

                CSTNode result = createOperationCS(getTokenText(dtParser
                    .getToken(1)), (EList) dtParser.getSym(3),
                    (TypeCS) dtParser.getSym(6));
                if (dtParser.getSym(6) != null) {
                    setOffsets(result, getIToken(dtParser.getToken(1)),
                        (CSTNode) dtParser.getSym(6));
                } else {
                    setOffsets(result, getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(5)));
                }
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 63: operationCS2 ::= pathNameCS :: simpleNameCS (
                // parametersCSopt ) : typeCSopt
                //
            case 63: {

                CSTNode result = createOperationCS((PathNameCS) dtParser
                    .getSym(1), (SimpleNameCS) dtParser.getSym(3),
                    (EList) dtParser.getSym(5), (TypeCS) dtParser.getSym(8));
                if (dtParser.getSym(8) != null) {
                    setOffsets(result, (CSTNode) dtParser.getSym(1),
                        (CSTNode) dtParser.getSym(8));
                } else {
                    setOffsets(result, (CSTNode) dtParser.getSym(1),
                        getIToken(dtParser.getToken(7)));
                }
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 64: parametersCSopt ::= $Empty
                //
            case 64:
                dtParser.setSym1(new BasicEList());
                break;

            //
            // Rule 66: parametersCS ::= variableCS
            //
            case 66: {

                EList result = new BasicEList();
                result.add(dtParser.getSym(1));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 67: parametersCS ::= parametersCS , variableCS
                //
            case 67: {

                EList result = (EList) dtParser.getSym(1);
                result.add(dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 68: simpleNameCSopt ::= $Empty
                //
            case 68:
                dtParser.setSym1(null);
                break;

            //
            // Rule 74: impliesExpCS ::= impliesExpCS implies andOrXorExpCS
            //
            case 74:

                //
                // Rule 75: impliesWithLet ::= impliesExpCS implies
                // andOrXorWithLet
                //
            case 75:

                //
                // Rule 78: andOrXorExpCS ::= andOrXorExpCS and equalityExpCS
                //
            case 78:

                //
                // Rule 79: andOrXorExpCS ::= andOrXorExpCS or equalityExpCS
                //
            case 79:

                //
                // Rule 80: andOrXorExpCS ::= andOrXorExpCS xor equalityExpCS
                //
            case 80:

                //
                // Rule 81: andOrXorWithLet ::= andOrXorExpCS and
                // equalityWithLet
                //
            case 81:

                //
                // Rule 82: andOrXorWithLet ::= andOrXorExpCS or equalityWithLet
                //
            case 82:

                //
                // Rule 83: andOrXorWithLet ::= andOrXorExpCS xor
                // equalityWithLet
                //
            case 83: {

                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.STRING_LITERAL, getTokenText(dtParser
                        .getToken(2)));
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
                EList args = new BasicEList();
                args.add(dtParser.getSym(3));
                CSTNode result = createOperationCallExpCS(
                    (OCLExpressionCS) dtParser.getSym(1), simpleNameCS, args);
                setOffsets(result, (CSTNode) dtParser.getSym(1),
                    (CSTNode) dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 86: equalityExpCS ::= equalityExpCS = relationalExpCS
                //
            case 86:

                //
                // Rule 87: equalityWithLet ::= equalityExpCS =
                // relationalWithLet
                //
            case 87: {

                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.STRING_LITERAL, OCLStandardLibraryUtil
                        .getOperationName(PredefinedType.EQUAL));
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
                EList args = new BasicEList();
                args.add(dtParser.getSym(3));
                CSTNode result = createOperationCallExpCS(
                    (OCLExpressionCS) dtParser.getSym(1), simpleNameCS, args);
                setOffsets(result, (CSTNode) dtParser.getSym(1),
                    (CSTNode) dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 88: equalityExpCS ::= equalityExpCS <> relationalExpCS
                //
            case 88:

                //
                // Rule 89: equalityWithLet ::= equalityExpCS <>
                // relationalWithLet
                //
            case 89: {

                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.STRING_LITERAL, OCLStandardLibraryUtil
                        .getOperationName(PredefinedType.NOT_EQUAL));
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
                EList args = new BasicEList();
                args.add(dtParser.getSym(3));
                CSTNode result = createOperationCallExpCS(
                    (OCLExpressionCS) dtParser.getSym(1), simpleNameCS, args);
                setOffsets(result, (CSTNode) dtParser.getSym(1),
                    (CSTNode) dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 92: relationalExpCS ::= relationalExpCS > ifExpCSPrec
                //
            case 92:

                //
                // Rule 93: relationalWithLet ::= relationalExpCS >
                // additiveWithLet
                //
            case 93: {

                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.STRING_LITERAL, OCLStandardLibraryUtil
                        .getOperationName(PredefinedType.GREATER_THAN));
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
                EList args = new BasicEList();
                args.add(dtParser.getSym(3));
                CSTNode result = createOperationCallExpCS(
                    (OCLExpressionCS) dtParser.getSym(1), simpleNameCS, args);
                setOffsets(result, (CSTNode) dtParser.getSym(1),
                    (CSTNode) dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 94: relationalExpCS ::= relationalExpCS < ifExpCSPrec
                //
            case 94:

                //
                // Rule 95: relationalWithLet ::= relationalExpCS <
                // additiveWithLet
                //
            case 95: {

                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.STRING_LITERAL, OCLStandardLibraryUtil
                        .getOperationName(PredefinedType.LESS_THAN));
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
                EList args = new BasicEList();
                args.add(dtParser.getSym(3));
                CSTNode result = createOperationCallExpCS(
                    (OCLExpressionCS) dtParser.getSym(1), simpleNameCS, args);
                setOffsets(result, (CSTNode) dtParser.getSym(1),
                    (CSTNode) dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 96: relationalExpCS ::= relationalExpCS >= ifExpCSPrec
                //
            case 96:

                //
                // Rule 97: relationalWithLet ::= relationalExpCS >=
                // additiveWithLet
                //
            case 97: {

                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.STRING_LITERAL, OCLStandardLibraryUtil
                        .getOperationName(PredefinedType.GREATER_THAN_EQUAL));
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
                EList args = new BasicEList();
                args.add(dtParser.getSym(3));
                CSTNode result = createOperationCallExpCS(
                    (OCLExpressionCS) dtParser.getSym(1), simpleNameCS, args);
                setOffsets(result, (CSTNode) dtParser.getSym(1),
                    (CSTNode) dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 98: relationalExpCS ::= relationalExpCS <= ifExpCSPrec
                //
            case 98:

                //
                // Rule 99: relationalWithLet ::= relationalExpCS <=
                // additiveWithLet
                //
            case 99: {

                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.STRING_LITERAL, OCLStandardLibraryUtil
                        .getOperationName(PredefinedType.LESS_THAN_EQUAL));
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
                EList args = new BasicEList();
                args.add(dtParser.getSym(3));
                CSTNode result = createOperationCallExpCS(
                    (OCLExpressionCS) dtParser.getSym(1), simpleNameCS, args);
                setOffsets(result, (CSTNode) dtParser.getSym(1),
                    (CSTNode) dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 104: additiveExpCS ::= additiveExpCS +
                // multiplicativeExpCS
                //
            case 104:

                //
                // Rule 105: additiveWithLet ::= additiveExpCS +
                // multiplicativeWithLet
                //
            case 105: {

                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.STRING_LITERAL, OCLStandardLibraryUtil
                        .getOperationName(PredefinedType.PLUS));
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
                EList args = new BasicEList();
                args.add(dtParser.getSym(3));
                CSTNode result = createOperationCallExpCS(
                    (OCLExpressionCS) dtParser.getSym(1), simpleNameCS, args);
                setOffsets(result, (CSTNode) dtParser.getSym(1),
                    (CSTNode) dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 106: additiveExpCS ::= additiveExpCS -
                // multiplicativeExpCS
                //
            case 106:

                //
                // Rule 107: additiveWithLet ::= additiveExpCS -
                // multiplicativeWithLet
                //
            case 107: {

                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.STRING_LITERAL, OCLStandardLibraryUtil
                        .getOperationName(PredefinedType.MINUS));
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
                EList args = new BasicEList();
                args.add(dtParser.getSym(3));
                CSTNode result = createOperationCallExpCS(
                    (OCLExpressionCS) dtParser.getSym(1), simpleNameCS, args);
                setOffsets(result, (CSTNode) dtParser.getSym(1),
                    (CSTNode) dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 110: multiplicativeExpCS ::= multiplicativeExpCS *
                // unaryExpCS
                //
            case 110:

                //
                // Rule 111: multiplicativeWithLet ::= multiplicativeExpCS *
                // unaryWithLet
                //
            case 111: {

                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.STRING_LITERAL, OCLStandardLibraryUtil
                        .getOperationName(PredefinedType.TIMES));
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
                EList args = new BasicEList();
                args.add(dtParser.getSym(3));
                CSTNode result = createOperationCallExpCS(
                    (OCLExpressionCS) dtParser.getSym(1), simpleNameCS, args);
                setOffsets(result, (CSTNode) dtParser.getSym(1),
                    (CSTNode) dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 112: multiplicativeExpCS ::= multiplicativeExpCS /
                // unaryExpCS
                //
            case 112:

                //
                // Rule 113: multiplicativeWithLet ::= multiplicativeExpCS /
                // unaryWithLet
                //
            case 113: {

                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.STRING_LITERAL, OCLStandardLibraryUtil
                        .getOperationName(PredefinedType.DIVIDE));
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
                EList args = new BasicEList();
                args.add(dtParser.getSym(3));
                CSTNode result = createOperationCallExpCS(
                    (OCLExpressionCS) dtParser.getSym(1), simpleNameCS, args);
                setOffsets(result, (CSTNode) dtParser.getSym(1),
                    (CSTNode) dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 116: unaryExpCS ::= - unaryExpCS
                //
            case 116: {

                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.STRING_LITERAL, OCLStandardLibraryUtil
                        .getOperationName(PredefinedType.MINUS));
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
                CSTNode result = createOperationCallExpCS(
                    (OCLExpressionCS) dtParser.getSym(2), simpleNameCS,
                    new BasicEList());
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    (CSTNode) dtParser.getSym(2));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 117: unaryExpCS ::= not unaryExpCS
                //
            case 117: {

                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.STRING_LITERAL, getTokenText(dtParser
                        .getToken(1)));
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
                CSTNode result = createOperationCallExpCS(
                    (OCLExpressionCS) dtParser.getSym(2), simpleNameCS,
                    new BasicEList());
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    (CSTNode) dtParser.getSym(2));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 119: dotArrowExpCS ::= dotArrowExpCS callExpCS
                //
            case 119: {

                CallExpCS result = (CallExpCS) dtParser.getSym(2);
                result.setSource((OCLExpressionCS) dtParser.getSym(1));
                setOffsets(result, (CSTNode) dtParser.getSym(1), result);
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 120: dotArrowExpCS ::= dotArrowExpCS messageExpCS
                //
            case 120: {

                MessageExpCS result = (MessageExpCS) dtParser.getSym(2);
                result.setTarget((OCLExpressionCS) dtParser.getSym(1));
                setOffsets(result, (CSTNode) dtParser.getSym(1),
                    (CSTNode) dtParser.getSym(2));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 121: dotArrowExpCS ::= NUMERIC_OPERATION (
                // argumentsCSopt )
                //
            case 121: {

                // NUMERIC_OPERATION -> Integer '.' Identifier
                String text = getTokenText(dtParser.getToken(1));
                int index = text.indexOf('.');
                String integer = text.substring(0, index);
                String simpleName = text.substring(index + 1);

                // create the IntegerLiteralExpCS
                int startOffset = getIToken(dtParser.getToken(1))
                    .getStartOffset();
                int endOffset = startOffset + integer.length() - 1; // inclusive

                IntegerLiteralExpCS integerLiteralExpCS = createIntegerLiteralExpCS(integer);
                integerLiteralExpCS.setStartOffset(startOffset);
                integerLiteralExpCS.setEndOffset(endOffset);

                startOffset = endOffset + 2; // end of integerLiteral +
                                                // 1('.') + 1(start of
                                                // simpleName)
                endOffset = getIToken(dtParser.getToken(1)).getEndOffset();

                // create the SimpleNameCS
                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.IDENTIFIER_LITERAL, simpleName);
                simpleNameCS.setStartOffset(startOffset);
                simpleNameCS.setEndOffset(endOffset);

                // create the OperationCallExpCS
                CSTNode result = createOperationCallExpCS(integerLiteralExpCS,
                    simpleNameCS, (EList) dtParser.getSym(3));
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 122: dotArrowExpCS ::= pathNameCS :: simpleNameCS (
                // argumentsCSopt )
                //
            case 122: {

                OperationCallExpCS result = createOperationCallExpCS(
                    (PathNameCS) dtParser.getSym(1), (SimpleNameCS) dtParser
                        .getSym(3), (EList) dtParser.getSym(5));
                setOffsets(result, (CSTNode) dtParser.getSym(1),
                    getIToken(dtParser.getToken(6)));
                result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 127: oclExpCS ::= ( oclExpressionCS )
                //
            case 127: {

                CSTNode result = (CSTNode) dtParser.getSym(2);
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    getIToken(dtParser.getToken(3)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 128: variableExpCS ::= simpleNameCS isMarkedPreCS
                //
            case 128: {

                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS) dtParser
                    .getSym(2);
                CSTNode result = createVariableExpCS((SimpleNameCS) dtParser
                    .getSym(1), new BasicEList(), isMarkedPreCS);
                if (isMarkedPreCS.isPre()) {
                    setOffsets(result, (CSTNode) dtParser.getSym(1),
                        (CSTNode) dtParser.getSym(2));
                } else {
                    setOffsets(result, (CSTNode) dtParser.getSym(1));
                }
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 129: variableExpCS ::= keywordAsIdentifier1
                // isMarkedPreCS
                //
            case 129: {

                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS) dtParser
                    .getSym(2);
                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.IDENTIFIER_LITERAL, getTokenText(dtParser
                        .getToken(1)));
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
                CSTNode result = createVariableExpCS(simpleNameCS,
                    new BasicEList(), isMarkedPreCS);
                if (isMarkedPreCS.isPre()) {
                    setOffsets(result, getIToken(dtParser.getToken(1)),
                        (CSTNode) dtParser.getSym(2));
                } else {
                    setOffsets(result, getIToken(dtParser.getToken(1)));
                }
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 130: variableExpCS ::= simpleNameCS [ argumentsCS ]
                // isMarkedPreCS
                //
            case 130: {

                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS) dtParser
                    .getSym(5);
                CSTNode result = createVariableExpCS((SimpleNameCS) dtParser
                    .getSym(1), (EList) dtParser.getSym(3), isMarkedPreCS);
                if (isMarkedPreCS.isPre()) {
                    setOffsets(result, (CSTNode) dtParser.getSym(1),
                        (CSTNode) dtParser.getSym(5));
                } else {
                    setOffsets(result, (CSTNode) dtParser.getSym(1),
                        getIToken(dtParser.getToken(4)));
                }
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 131: variableExpCS ::= keywordAsIdentifier1 [
                // argumentsCS ] isMarkedPreCS
                //
            case 131: {

                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS) dtParser
                    .getSym(5);
                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.IDENTIFIER_LITERAL, getTokenText(dtParser
                        .getToken(1)));
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
                CSTNode result = createVariableExpCS((SimpleNameCS) dtParser
                    .getSym(1), (EList) dtParser.getSym(3), isMarkedPreCS);
                if (isMarkedPreCS.isPre()) {
                    setOffsets(result, (CSTNode) dtParser.getSym(1),
                        (CSTNode) dtParser.getSym(5));
                } else {
                    setOffsets(result, (CSTNode) dtParser.getSym(1),
                        getIToken(dtParser.getToken(4)));
                }
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 133: simpleNameCS ::= self
                //
            case 133: {

                CSTNode result = createSimpleNameCS(
                    SimpleTypeEnum.SELF_LITERAL, getTokenText(dtParser
                        .getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 134: simpleNameCS ::= IDENTIFIER
                //
            case 134: {

                CSTNode result = createSimpleNameCS(
                    SimpleTypeEnum.IDENTIFIER_LITERAL, getTokenText(dtParser
                        .getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 135: primitiveTypeCS ::= Integer
                //
            case 135: {

                CSTNode result = createPrimitiveTypeCS(
                    SimpleTypeEnum.INTEGER_LITERAL, getTokenText(dtParser
                        .getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 136: primitiveTypeCS ::= UnlimitedNatural
                //
            case 136: {

                CSTNode result = createPrimitiveTypeCS(
                    SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
                    getTokenText(dtParser.getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 137: primitiveTypeCS ::= String
                //
            case 137: {

                CSTNode result = createPrimitiveTypeCS(
                    SimpleTypeEnum.STRING_LITERAL, getTokenText(dtParser
                        .getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 138: primitiveTypeCS ::= Real
                //
            case 138: {

                CSTNode result = createPrimitiveTypeCS(
                    SimpleTypeEnum.REAL_LITERAL, getTokenText(dtParser
                        .getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 139: primitiveTypeCS ::= Boolean
                //
            case 139: {

                CSTNode result = createPrimitiveTypeCS(
                    SimpleTypeEnum.BOOLEAN_LITERAL, getTokenText(dtParser
                        .getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 140: primitiveTypeCS ::= OclAny
                //
            case 140: {

                CSTNode result = createPrimitiveTypeCS(
                    SimpleTypeEnum.OCL_ANY_LITERAL, getTokenText(dtParser
                        .getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 141: primitiveTypeCS ::= OclVoid
                //
            case 141: {

                CSTNode result = createPrimitiveTypeCS(
                    SimpleTypeEnum.OCL_VOID_LITERAL, getTokenText(dtParser
                        .getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 142: primitiveTypeCS ::= Invalid
                //
            case 142: {

                CSTNode result = createPrimitiveTypeCS(
                    SimpleTypeEnum.INVALID_LITERAL, getTokenText(dtParser
                        .getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 143: primitiveTypeCS ::= OclMessage
                //
            case 143: {

                CSTNode result = createPrimitiveTypeCS(
                    SimpleTypeEnum.OCL_MESSAGE_LITERAL, getTokenText(dtParser
                        .getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 144: pathNameCS ::= IDENTIFIER
                //
            case 144: {

                CSTNode result = createPathNameCS(getTokenText(dtParser
                    .getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 145: pathNameCS ::= pathNameCS :: simpleNameCS
                //
            case 145: {

                PathNameCS result = (PathNameCS) dtParser.getSym(1);
                result = extendPathNameCS(result, getTokenText(dtParser
                    .getToken(3)));
                setOffsets(result, result, (CSTNode) dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 146: pathNameCSOpt ::= $Empty
                //
            case 146: {

                CSTNode result = createPathNameCS();
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 154: enumLiteralExpCS ::= pathNameCS ::
                // keywordAsIdentifier
                //
            case 154: {

                CSTNode result = createEnumLiteralExpCS((PathNameCS) dtParser
                    .getSym(1), getTokenText(dtParser.getToken(3)));
                setOffsets(result, (CSTNode) dtParser.getSym(1),
                    getIToken(dtParser.getToken(3)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 155: enumLiteralExpCS ::= pathNameCS :: simpleNameCS
                //
            case 155: {

                CSTNode result = createEnumLiteralExpCS((PathNameCS) dtParser
                    .getSym(1), (SimpleNameCS) dtParser.getSym(3));
                setOffsets(result, (CSTNode) dtParser.getSym(1),
                    (CSTNode) dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 156: collectionLiteralExpCS ::=
                // collectionTypeIdentifierCS { collectionLiteralPartsCSopt }
                //
            case 156: {

                Object[] objs = (Object[]) dtParser.getSym(1);
                CSTNode result = createCollectionLiteralExpCS(
                    (CollectionTypeIdentifierEnum) objs[1], (EList) dtParser
                        .getSym(3));
                setOffsets(result, (IToken) objs[0], getIToken(dtParser
                    .getToken(4)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 157: collectionTypeIdentifierCS ::= Set
                //
            case 157: {

                dtParser.setSym1(new Object[] {getIToken(dtParser.getToken(1)),
                    CollectionTypeIdentifierEnum.SET_LITERAL});
                break;
            }

                //
                // Rule 158: collectionTypeIdentifierCS ::= Bag
                //
            case 158: {

                dtParser.setSym1(new Object[] {getIToken(dtParser.getToken(1)),
                    CollectionTypeIdentifierEnum.BAG_LITERAL});
                break;
            }

                //
                // Rule 159: collectionTypeIdentifierCS ::= Sequence
                //
            case 159: {

                dtParser.setSym1(new Object[] {getIToken(dtParser.getToken(1)),
                    CollectionTypeIdentifierEnum.SEQUENCE_LITERAL});
                break;
            }

                //
                // Rule 160: collectionTypeIdentifierCS ::= Collection
                //
            case 160: {

                dtParser.setSym1(new Object[] {getIToken(dtParser.getToken(1)),
                    CollectionTypeIdentifierEnum.COLLECTION_LITERAL});
                break;
            }

                //
                // Rule 161: collectionTypeIdentifierCS ::= OrderedSet
                //
            case 161: {

                dtParser.setSym1(new Object[] {getIToken(dtParser.getToken(1)),
                    CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL});
                break;
            }

                //
                // Rule 162: collectionLiteralPartsCSopt ::= $Empty
                //
            case 162:
                dtParser.setSym1(new BasicEList());
                break;

            //
            // Rule 164: collectionLiteralPartsCS ::= collectionLiteralPartCS
            //
            case 164: {

                EList result = new BasicEList();
                result.add(dtParser.getSym(1));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 165: collectionLiteralPartsCS ::=
                // collectionLiteralPartsCS , collectionLiteralPartCS
                //
            case 165: {

                EList result = (EList) dtParser.getSym(1);
                result.add(dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 167: collectionLiteralPartCS ::= oclExpressionCS
                //
            case 167: {

                CSTNode result = createCollectionLiteralPartCS((OCLExpressionCS) dtParser
                    .getSym(1));
                setOffsets(result, (CSTNode) dtParser.getSym(1));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 168: collectionRangeCS ::= - INTEGER_RANGE_START
                // oclExpressionCS
                //
            case 168: {

                OCLExpressionCS rangeStart = createRangeStart(
                    getTokenText(dtParser.getToken(2)), true);
                CSTNode result = createCollectionRangeCS(rangeStart,
                    (OCLExpressionCS) dtParser.getSym(3));
                setOffsets(result, rangeStart, (CSTNode) dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 169: collectionRangeCS ::= INTEGER_RANGE_START
                // oclExpressionCS
                //
            case 169: {

                OCLExpressionCS rangeStart = createRangeStart(
                    getTokenText(dtParser.getToken(1)), false);
                CSTNode result = createCollectionRangeCS(rangeStart,
                    (OCLExpressionCS) dtParser.getSym(2));
                setOffsets(result, rangeStart, (CSTNode) dtParser.getSym(2));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 170: collectionRangeCS ::= oclExpressionCS ..
                // oclExpressionCS
                //
            case 170: {

                CSTNode result = createCollectionRangeCS(
                    (OCLExpressionCS) dtParser.getSym(1),
                    (OCLExpressionCS) dtParser.getSym(3));
                setOffsets(result, (CSTNode) dtParser.getSym(1),
                    (CSTNode) dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 176: tupleLiteralExpCS ::= Tuple { variableListCS2 }
                //
            case 176: {

                CSTNode result = createTupleLiteralExpCS((EList) dtParser
                    .getSym(3));
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 177: integerLiteralExpCS ::= INTEGER_LITERAL
                //
            case 177: {

                CSTNode result = createIntegerLiteralExpCS(getTokenText(dtParser
                    .getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 178: unlimitedNaturalLiteralExpCS ::= *
                //
            case 178: {

                CSTNode result = createUnlimitedNaturalLiteralExpCS(getTokenText(dtParser
                    .getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 179: realLiteralExpCS ::= REAL_LITERAL
                //
            case 179: {

                CSTNode result = createRealLiteralExpCS(getTokenText(dtParser
                    .getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 180: stringLiteralExpCS ::= STRING_LITERAL
                //
            case 180: {

                CSTNode result = createStringLiteralExpCS(getTokenText(dtParser
                    .getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 181: booleanLiteralExpCS ::= true
                //
            case 181: {

                CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser
                    .getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 182: booleanLiteralExpCS ::= false
                //
            case 182: {

                CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser
                    .getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 183: nullLiteralExpCS ::= null
                //
            case 183: {

                CSTNode result = createNullLiteralExpCS(getTokenText(dtParser
                    .getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 184: invalidLiteralExpCS ::= OclInvalid
                //
            case 184: {

                CSTNode result = createInvalidLiteralExpCS(getTokenText(dtParser
                    .getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 185: callExpCS ::= -> featureCallExpCS
                //
            case 185:

                //
                // Rule 186: callExpCS ::= -> loopExpCS
                //
            case 186: {

                CallExpCS result = (CallExpCS) dtParser.getSym(2);
                result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 187: callExpCS ::= . keywordOperationCallExpCS
                //
            case 187:

                //
                // Rule 188: callExpCS ::= . featureCallExpCS
                //
            case 188: {

                CallExpCS result = (CallExpCS) dtParser.getSym(2);
                result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 191: iteratorExpCS ::= forAll ( iterContents )
                //
            case 191:

                //
                // Rule 192: iteratorExpCS ::= exists ( iterContents )
                //
            case 192:

                //
                // Rule 193: iteratorExpCS ::= isUnique ( iterContents )
                //
            case 193:

                //
                // Rule 194: iteratorExpCS ::= one ( iterContents )
                //
            case 194:

                //
                // Rule 195: iteratorExpCS ::= any ( iterContents )
                //
            case 195:

                //
                // Rule 196: iteratorExpCS ::= collect ( iterContents )
                //
            case 196:

                //
                // Rule 197: iteratorExpCS ::= select ( iterContents )
                //
            case 197:

                //
                // Rule 198: iteratorExpCS ::= reject ( iterContents )
                //
            case 198:

                //
                // Rule 199: iteratorExpCS ::= collectNested ( iterContents )
                //
            case 199:

                //
                // Rule 200: iteratorExpCS ::= sortedBy ( iterContents )
                //
            case 200:

                //
                // Rule 201: iteratorExpCS ::= closure ( iterContents )
                //
            case 201: {

                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.KEYWORD_LITERAL, getTokenText(dtParser
                        .getToken(1)));
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
                Object[] iterContents = (Object[]) dtParser.getSym(3);
                CSTNode result = createIteratorExpCS(simpleNameCS,
                    (VariableCS) iterContents[0], (VariableCS) iterContents[1],
                    (OCLExpressionCS) iterContents[2]);
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 202: iterContents ::= oclExpressionCS
                //
            case 202: {

                dtParser.setSym1(new Object[] {null, null, dtParser.getSym(1)});
                break;
            }

                //
                // Rule 203: iterContents ::= variableCS | oclExpressionCS
                //
            case 203: {

                dtParser.setSym1(new Object[] {dtParser.getSym(1), null,
                    dtParser.getSym(3)});
                break;
            }

                //
                // Rule 204: iterContents ::= variableCS , variableCS |
                // oclExpressionCS
                //
            case 204: {

                dtParser.setSym1(new Object[] {dtParser.getSym(1),
                    dtParser.getSym(3), dtParser.getSym(5)});
                break;
            }

                //
                // Rule 205: iterateExpCS ::= iterate ( variableCS |
                // oclExpressionCS )
                //
            case 205: {

                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.KEYWORD_LITERAL, getTokenText(dtParser
                        .getToken(1)));
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
                CSTNode result = createIterateExpCS(simpleNameCS,
                    (VariableCS) dtParser.getSym(3), null,
                    (OCLExpressionCS) dtParser.getSym(5));
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    getIToken(dtParser.getToken(6)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 206: iterateExpCS ::= iterate ( variableCS ; variableCS
                // | oclExpressionCS )
                //
            case 206: {

                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.KEYWORD_LITERAL, getTokenText(dtParser
                        .getToken(1)));
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
                CSTNode result = createIterateExpCS(simpleNameCS,
                    (VariableCS) dtParser.getSym(3), (VariableCS) dtParser
                        .getSym(5), (OCLExpressionCS) dtParser.getSym(7));
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    getIToken(dtParser.getToken(8)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 207: variableCS ::= IDENTIFIER
                //
            case 207: {

                CSTNode result = createVariableCS(getTokenText(dtParser
                    .getToken(1)), null, null);
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 208: variableCS ::= IDENTIFIER : typeCS
                //
            case 208: {

                CSTNode result = createVariableCS(getTokenText(dtParser
                    .getToken(1)), (TypeCS) dtParser.getSym(3), null);
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    (CSTNode) dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 209: variableCS ::= IDENTIFIER : typeCS =
                // oclExpressionCS
                //
            case 209: {

                CSTNode result = createVariableCS(getTokenText(dtParser
                    .getToken(1)), (TypeCS) dtParser.getSym(3),
                    (OCLExpressionCS) dtParser.getSym(5));
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    (CSTNode) dtParser.getSym(5));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 210: variableCS2 ::= IDENTIFIER = oclExpressionCS
                //
            case 210: {

                CSTNode result = createVariableCS(getTokenText(dtParser
                    .getToken(1)), null, (OCLExpressionCS) dtParser.getSym(3));
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    (CSTNode) dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 211: typeCSopt ::= $Empty
                //
            case 211:
                dtParser.setSym1(null);
                break;

            //
            // Rule 217: collectionTypeCS ::= collectionTypeIdentifierCS (
            // typeCS )
            //
            case 217: {

                Object[] objs = (Object[]) dtParser.getSym(1);
                CSTNode result = createCollectionTypeCS(
                    (CollectionTypeIdentifierEnum) objs[1], (TypeCS) dtParser
                        .getSym(3));
                setOffsets(result, (IToken) objs[0], getIToken(dtParser
                    .getToken(4)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 218: tupleTypeCS ::= Tuple ( variableListCSopt )
                //
            case 218: {

                CSTNode result = createTupleTypeCS((EList) dtParser.getSym(3));
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 219: variableListCSopt ::= $Empty
                //
            case 219:
                dtParser.setSym1(new BasicEList());
                break;

            //
            // Rule 221: variableListCS ::= variableCS
            //
            case 221: {

                EList result = new BasicEList();
                result.add(dtParser.getSym(1));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 222: variableListCS ::= variableListCS , variableCS
                //
            case 222: {

                EList result = (EList) dtParser.getSym(1);
                result.add(dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 223: variableListCS2 ::= variableCS2
                //
            case 223:

                //
                // Rule 224: variableListCS2 ::= variableCS
                //
            case 224: {

                EList result = new BasicEList();
                result.add(dtParser.getSym(1));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 225: variableListCS2 ::= variableListCS2 , variableCS2
                //
            case 225:

                //
                // Rule 226: variableListCS2 ::= variableListCS2 , variableCS
                //
            case 226: {

                EList result = (EList) dtParser.getSym(1);
                result.add(dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 229: featureCallExpCS ::= MINUS isMarkedPreCS (
                // argumentsCSopt )
                //
            case 229:

                //
                // Rule 230: featureCallExpCS ::= not isMarkedPreCS (
                // argumentsCSopt )
                //
            case 230: {

                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.IDENTIFIER_LITERAL, getTokenText(dtParser
                        .getToken(1)));
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
                CSTNode result = createOperationCallExpCS(simpleNameCS,
                    (IsMarkedPreCS) dtParser.getSym(2), (EList) dtParser
                        .getSym(4));
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    getIToken(dtParser.getToken(5)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 231: operationCallExpCS ::= simpleNameCS isMarkedPreCS (
                // argumentsCSopt )
                //
            case 231: {

                CSTNode result = createOperationCallExpCS(
                    (SimpleNameCS) dtParser.getSym(1), (IsMarkedPreCS) dtParser
                        .getSym(2), (EList) dtParser.getSym(4));
                setOffsets(result, (CSTNode) dtParser.getSym(1),
                    getIToken(dtParser.getToken(5)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 232: operationCallExpCS ::= oclIsUndefined isMarkedPreCS
                // ( argumentsCSopt )
                //
            case 232:

                //
                // Rule 233: operationCallExpCS ::= oclIsInvalid isMarkedPreCS (
                // argumentsCSopt )
                //
            case 233:

                //
                // Rule 234: operationCallExpCS ::= oclIsNew isMarkedPreCS (
                // argumentsCSopt )
                //
            case 234:

                //
                // Rule 235: operationCallExpCS ::= oclAsType isMarkedPreCS (
                // argumentsCSopt )
                //
            case 235:

                //
                // Rule 236: operationCallExpCS ::= oclIsKindOf isMarkedPreCS (
                // argumentsCSopt )
                //
            case 236:

                //
                // Rule 237: operationCallExpCS ::= oclIsTypeOf isMarkedPreCS (
                // argumentsCSopt )
                //
            case 237:

                //
                // Rule 238: operationCallExpCS ::= EQUAL isMarkedPreCS (
                // argumentsCSopt )
                //
            case 238:

                //
                // Rule 239: operationCallExpCS ::= NOT_EQUAL isMarkedPreCS (
                // argumentsCSopt )
                //
            case 239:

                //
                // Rule 240: operationCallExpCS ::= PLUS isMarkedPreCS (
                // argumentsCSopt )
                //
            case 240:

                //
                // Rule 241: operationCallExpCS ::= MULTIPLY isMarkedPreCS (
                // argumentsCSopt )
                //
            case 241:

                //
                // Rule 242: operationCallExpCS ::= DIVIDE isMarkedPreCS (
                // argumentsCSopt )
                //
            case 242:

                //
                // Rule 243: operationCallExpCS ::= GREATER isMarkedPreCS (
                // argumentsCSopt )
                //
            case 243:

                //
                // Rule 244: operationCallExpCS ::= LESS isMarkedPreCS (
                // argumentsCSopt )
                //
            case 244:

                //
                // Rule 245: operationCallExpCS ::= GREATER_EQUAL isMarkedPreCS
                // ( argumentsCSopt )
                //
            case 245:

                //
                // Rule 246: operationCallExpCS ::= LESS_EQUAL isMarkedPreCS (
                // argumentsCSopt )
                //
            case 246:

                //
                // Rule 247: operationCallExpCS ::= and isMarkedPreCS (
                // argumentsCSopt )
                //
            case 247:

                //
                // Rule 248: operationCallExpCS ::= or isMarkedPreCS (
                // argumentsCSopt )
                //
            case 248:

                //
                // Rule 249: operationCallExpCS ::= xor isMarkedPreCS (
                // argumentsCSopt )
                //
            case 249:

                //
                // Rule 250: keywordOperationCallExpCS ::= keywordAsIdentifier
                // isMarkedPreCS ( argumentsCSopt )
                //
            case 250: {

                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.IDENTIFIER_LITERAL, getTokenText(dtParser
                        .getToken(1)));
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
                CSTNode result = createOperationCallExpCS(simpleNameCS,
                    (IsMarkedPreCS) dtParser.getSym(2), (EList) dtParser
                        .getSym(4));
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    getIToken(dtParser.getToken(5)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 251: operationCallExpCS ::= oclIsInState isMarkedPreCS (
                // pathNameCSOpt )
                //
            case 251: {

                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.KEYWORD_LITERAL, getTokenText(dtParser
                        .getToken(1)));
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));

                PathNameCS pathNameCS = (PathNameCS) dtParser.getSym(4);
                StateExpCS stateExpCS = createStateExpCS(pathNameCS);
                setOffsets(stateExpCS, pathNameCS);

                CSTNode result = createOperationCallExpCS(simpleNameCS,
                    (IsMarkedPreCS) dtParser.getSym(2), stateExpCS);
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    getIToken(dtParser.getToken(5)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 252: attrOrNavCallExpCS ::= simpleNameCS isMarkedPreCS
                //
            case 252: {

                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS) dtParser
                    .getSym(2);
                CSTNode result = createFeatureCallExpCS((SimpleNameCS) dtParser
                    .getSym(1), new BasicEList(), isMarkedPreCS);
                if (isMarkedPreCS.isPre()) {
                    setOffsets(result, (CSTNode) dtParser.getSym(1),
                        (CSTNode) dtParser.getSym(2));
                } else {
                    setOffsets(result, (CSTNode) dtParser.getSym(1));
                }
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 253: attrOrNavCallExpCS ::= keywordAsIdentifier
                // isMarkedPreCS
                //
            case 253: {

                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS) dtParser
                    .getSym(2);
                SimpleNameCS simpleNameCS = createSimpleNameCS(
                    SimpleTypeEnum.IDENTIFIER_LITERAL, getTokenText(dtParser
                        .getToken(1)));
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
                CSTNode result = createFeatureCallExpCS(simpleNameCS,
                    new BasicEList(), isMarkedPreCS);
                if (isMarkedPreCS.isPre()) {
                    setOffsets(result, getIToken(dtParser.getToken(1)),
                        (CSTNode) dtParser.getSym(2));
                } else {
                    setOffsets(result, getIToken(dtParser.getToken(1)));
                }
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 254: attrOrNavCallExpCS ::= simpleNameCS [ argumentsCS ]
                // isMarkedPreCS
                //
            case 254: {

                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS) dtParser
                    .getSym(5);
                CSTNode result = createFeatureCallExpCS((SimpleNameCS) dtParser
                    .getSym(1), (EList) dtParser.getSym(3), isMarkedPreCS);
                if (isMarkedPreCS.isPre()) {
                    setOffsets(result, (CSTNode) dtParser.getSym(1),
                        (CSTNode) dtParser.getSym(5));
                } else {
                    setOffsets(result, (CSTNode) dtParser.getSym(1),
                        getIToken(dtParser.getToken(4)));
                }
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 255: isMarkedPreCS ::= $Empty
                //
            case 255: {

                CSTNode result = createIsMarkedPreCS(false);
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 256: isMarkedPreCS ::= @pre
                //
            case 256: {

                CSTNode result = createIsMarkedPreCS(true);
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 257: argumentsCSopt ::= $Empty
                //
            case 257:
                dtParser.setSym1(new BasicEList());
                break;

            //
            // Rule 259: argumentsCS ::= oclExpressionCS
            //
            case 259: {

                EList result = new BasicEList();
                result.add(dtParser.getSym(1));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 260: argumentsCS ::= argumentsCS , oclExpressionCS
                //
            case 260: {

                EList result = (EList) dtParser.getSym(1);
                result.add(dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 261: letExpCS ::= let variableCS letExpSubCSopt in
                // oclExpressionCS
                //
            case 261: {

                EList variables = (EList) dtParser.getSym(3);
                variables.add(0, dtParser.getSym(2));
                CSTNode result = createLetExpCS(variables,
                    (OCLExpressionCS) dtParser.getSym(5));
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    (CSTNode) dtParser.getSym(5));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 262: letExpSubCSopt ::= $Empty
                //
            case 262:
                dtParser.setSym1(new BasicEList());
                break;

            //
            // Rule 264: letExpSubCS ::= , variableCS
            //
            case 264: {

                EList result = new BasicEList();
                result.add(dtParser.getSym(2));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 265: letExpSubCS ::= letExpSubCS , variableCS
                //
            case 265: {

                EList result = (EList) dtParser.getSym(1);
                result.add(dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 266: ifExpCS ::= if oclExpressionCS then oclExpressionCS
                // else oclExpressionCS endif
                //
            case 266: {

                CSTNode result = createIfExpCS((OCLExpressionCS) dtParser
                    .getSym(2), (OCLExpressionCS) dtParser.getSym(4),
                    (OCLExpressionCS) dtParser.getSym(6));
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    getIToken(dtParser.getToken(7)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 267: messageExpCS ::= ^ simpleNameCS (
                // oclMessageArgumentsCSopt )
                //
            case 267:

                //
                // Rule 268: messageExpCS ::= ^^ simpleNameCS (
                // oclMessageArgumentsCSopt )
                //
            case 268: {

                CSTNode result = createMessageExpCS(getIToken(
                    dtParser.getToken(1)).getKind(), (SimpleNameCS) dtParser
                    .getSym(2), (EList) dtParser.getSym(4));
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    getIToken(dtParser.getToken(5)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 269: oclMessageArgumentsCSopt ::= $Empty
                //
            case 269:
                dtParser.setSym1(new BasicEList());
                break;

            //
            // Rule 271: oclMessageArgumentsCS ::= oclMessageArgCS
            //
            case 271: {

                EList result = new BasicEList();
                result.add(dtParser.getSym(1));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 272: oclMessageArgumentsCS ::= oclMessageArgumentsCS ,
                // oclMessageArgCS
                //
            case 272: {

                EList result = (EList) dtParser.getSym(1);
                result.add(dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 273: oclMessageArgCS ::= oclExpressionCS
                //
            case 273: {

                CSTNode result = createOCLMessageArgCS(null,
                    (OCLExpressionCS) dtParser.getSym(1));
                setOffsets(result, (CSTNode) dtParser.getSym(1));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 274: oclMessageArgCS ::= ?
                //
            case 274: {

                CSTNode result = createOCLMessageArgCS(null, null);
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
                break;
            }

                //
                // Rule 275: oclMessageArgCS ::= ? : typeCS
                //
            case 275: {

                CSTNode result = createOCLMessageArgCS((TypeCS) dtParser
                    .getSym(3), null);
                setOffsets(result, getIToken(dtParser.getToken(1)),
                    (CSTNode) dtParser.getSym(3));
                dtParser.setSym1(result);
                break;
            }

            default:
                break;
        }
        return;
    }
}
