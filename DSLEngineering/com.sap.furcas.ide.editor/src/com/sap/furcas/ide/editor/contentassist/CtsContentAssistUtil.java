package com.sap.furcas.ide.editor.contentassist;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.antlr.runtime.Token;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.swt.graphics.Image;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionCall;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.runtime.tcs.PropertyArgumentUtil;
import com.sap.furcas.runtime.tcs.TcsUtil;

public class CtsContentAssistUtil {

    private static Image keywordImage = null;
    private static Image propertyImage = null;
    private static Image propValueImage = null;
    private static Image templateImage = null;
    private static ITextViewer imageHostViewer = null;

    private static ICompletionProposal createProposal(String displayString, String replacementString, Image img,
            ITextViewer viewer, int line, int charPositionInLine, Token token) {

        int cursorPosition = getOffset(viewer, line, charPositionInLine);
        int replacementOffset = cursorPosition;
        int replacementLength = 0;

        if (token != null) {

            if (isInToken(line, charPositionInLine, token)) {
                replacementOffset = getOffset(viewer, getLine(token), getCharPositionInLine(token));

                replacementLength = Math.min(displayString.length(),
                        Math.min(getLength(token), getCommonPrefix(token.getText(), replacementString).length()));
            } else {

                // TODO workaround because ANTRL will not create error token
                // for unlexed characters
                // TODO this assumes languages with standard whitespaces
                // filter by currently un-tokenized non-whitespace prefix

                int stopOffset = -1;

                // stop at end of last valid token
                if (getCharPositionInLine(token) != -1) {
                    try {
                        stopOffset = viewer.getDocument().getLineInformation(getLine(token)).getOffset()
                                + getCharPositionInLine(token);
                    } catch (BadLocationException e) {
                        // do nothing
                    }
                }

                String prefix = "";
                try {
                    prefix = computeNonWhitespacePrefix(viewer.getDocument().get(), viewer.getDocument().getLineInformation(line)
                            .getOffset()
                            + charPositionInLine, stopOffset);
                } catch (BadLocationException e) {
                    // do nothing
                }

                if (!prefix.isEmpty()) {

                    replacementOffset = cursorPosition - prefix.length();
                    replacementLength = Math.min(displayString.length(),
                            Math.min(prefix.length(), getCommonPrefix(prefix, replacementString).length()));
                }

                // end workaround
            }
        }
        return new CompletionProposal(replacementString, replacementOffset, replacementLength, replacementString.length(), img,
                displayString, null, null);
    }

    /**
     * computes the non-whitespace-prefix starting at the offset and going back
     * until reaching stopOffset
     * 
     * @param documentContents
     * @param offset
     * @param stopOffset
     * @return
     */
    public static String computeNonWhitespacePrefix(String documentContents, int offset, int stopOffset) {

        String result = "";
        int curOffset = offset - 1;
        while (curOffset >= 0 && !(curOffset == stopOffset) && !isWhitespace(documentContents.charAt(curOffset))) {
            result = documentContents.charAt(curOffset) + result;
            curOffset--;
        }

        return result;
    }

    private static boolean isWhitespace(char c) {
        return (c == ' ' || c == '\n' || c == '\r' || c == '\t');
    }

    public static String getCommonPrefix(String a, String b) {
        int prefixLength = 0;
        while (prefixLength < a.length() && prefixLength < b.length()) {
            if (a.regionMatches(0, b, 0, prefixLength + 1)) {
                prefixLength++;
            } else {
                break;
            }
        }
        return a.substring(0, prefixLength);
    }

    private static Image getKeywordImage(ITextViewer currentViewer) {
        if (imageHostViewer != currentViewer || keywordImage == null) {
            imageHostViewer = currentViewer;
            keywordImage = new Image(imageHostViewer.getTextWidget().getDisplay(),
                    CtsContentAssistUtil.class.getResourceAsStream("img/keyword.gif"));
        }

        return keywordImage;
    }

    private static Image getPropertyImage(ITextViewer currentViewer) {
        if (imageHostViewer != currentViewer || propertyImage == null) {
            imageHostViewer = currentViewer;
            propertyImage = new Image(imageHostViewer.getTextWidget().getDisplay(),
                    CtsContentAssistUtil.class.getResourceAsStream("img/property.gif"));
        }

        return propertyImage;
    }

    private static Image getPropValueImage(ITextViewer currentViewer) {
        if (imageHostViewer != currentViewer || propValueImage == null) {
            imageHostViewer = currentViewer;
            propValueImage = new Image(imageHostViewer.getTextWidget().getDisplay(),
                    CtsContentAssistUtil.class.getResourceAsStream("img/propValue.gif"));
        }

        return propValueImage;
    }

    private static Image getTemplateImage(ITextViewer currentViewer) {
        if (imageHostViewer != currentViewer || templateImage == null) {
            imageHostViewer = currentViewer;
            templateImage = new Image(imageHostViewer.getTextWidget().getDisplay(),
                    CtsContentAssistUtil.class.getResourceAsStream("img/template.gif"));
        }

        return templateImage;
    }

    public static ICompletionProposal createKeywordProposal(String displayString, String replacementString, ITextViewer viewer,
            int line, int charPositionInLine, Token token) {

        Image img = null;
        if (viewer != null && viewer.getTextWidget() != null) {
            img = getKeywordImage(viewer);
        }

        return createProposal(displayString, replacementString, img, viewer, line, charPositionInLine, token);
    }

    public static ICompletionProposal createPropValueProposal(String displayString, String replacementString, ITextViewer viewer,
            int line, int charPositionInLine, Token token) {

        Image img = null;
        if (viewer != null && viewer.getTextWidget() != null) {
            img = getPropValueImage(viewer);
        }

        return createProposal(displayString, replacementString, img, viewer, line, charPositionInLine, token);
    }

    public static ICompletionProposal createTemplateProposal(String displayString, String replacementString, ITextViewer viewer,
            int line, int charPositionInLine, Token token) {

        Image img = null;
        if (viewer != null && viewer.getTextWidget() != null) {
            img = getTemplateImage(viewer);
        }

        return createProposal(displayString, replacementString, img, viewer, line, charPositionInLine, token);
    }

    public static ICompletionProposal createPropertyProposal(String displayString, String replacementString, ITextViewer viewer,
            int line, int charPositionInLine, Token token) {

        Image img = null;
        if (viewer != null && viewer.getTextWidget() != null) {
            img = getPropertyImage(viewer);
        }

        return createProposal(displayString, replacementString, img, viewer, line, charPositionInLine, token);
    }

    public static int getOffset(ITextViewer viewer, int line, int charPositionInLine) {
        if (viewer != null) {
            try {
                return viewer.getDocument().getLineOffset(line) + charPositionInLine;
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static boolean isContained(SequenceElement e, Set<SequenceElement> templateFirstAtomicSet) {
        if (e != null) {
            return templateFirstAtomicSet.contains(e);
        }
        return false;
    }

    public static boolean isInToken(int line, int charPositionInLine, Token t) {
        if (line != getLine(t)) {
            return false;
        }
        if (charPositionInLine < getCharPositionInLine(t)) {
            return false;
        }
        if (charPositionInLine > getCharPositionInLine(t) + getLength(t)) {
            return false;
        }
        return true;
    }

    public static int getAbsoluteOffset(ITextViewer viewer, int line, int charPositionInLine) throws BadLocationException {
        return viewer.getDocument().getLineInformation(line).getOffset() + charPositionInLine;
    }

    public static String getDocumentContents(ITextViewer viewer) {
        return viewer.getDocument().get();
    }

    public static int getCharPositionInLine(Token token) {
        // ANTRL line positions start at 0
        return token.getCharPositionInLine();
    }

    public static int getLine(Token token) {
        // ANTRL lines start at 1
        return token.getLine() - 1;
    }

    public static int getLength(Token token) {
        int length = 0;
        if (token.getText() != null) {
            length = token.getText().length();
        }
        return length;
    }

    public static boolean isContextAtWhitespace(ITextViewer viewer, CtsContentAssistContext context) throws BadLocationException {
        if (context != null) {
            if (context.getToken() != null) {
                String contents = getDocumentContents(viewer);
                int offset = getAbsoluteOffset(viewer, getLine(context.getToken()), getCharPositionInLine(context.getToken()));

                char c = contents.charAt(offset);
                if (isWhitespace(c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void fixTokenText(ITextViewer viewer, Token t) throws BadLocationException {
        // assumes the tokens line and charPositionInLine point to its start
        // location

        String contents = getDocumentContents(viewer);
        int curOffset = CtsContentAssistUtil.getAbsoluteOffset(viewer, getLine(t), getCharPositionInLine(t));

        String newText = "";

        boolean firstWhitespace = true;

        while (curOffset < contents.length()) {
            char c = contents.charAt(curOffset);
            if (!isWhitespace(c)) {
                firstWhitespace = false;
                newText += c;
            } else {
                if (!firstWhitespace) {
                    break;
                }

                // move token to the right or down
                if (c == ' ' || c == '\t') {
                    t.setCharPositionInLine(t.getCharPositionInLine() + 1);
                }
                if (c == '\n') {
                    t.setLine(t.getLine() + 1);
                }
            }
            curOffset++;
        }
        t.setText(newText);
    }

    /**
     * 
     * @param viewer
     * @param offset
     *            0..n-1
     * @return
     * @throws BadLocationException
     */
    public static int getLine(ITextViewer viewer, int offset) throws BadLocationException {
        return viewer.getDocument().getLineOfOffset(offset);
    }

    public static boolean isAtEndOfToken(int line, int charPositionInLine, Token t) {
        if (line != getLine(t)) {
            return false;
        }
        if (charPositionInLine == getCharPositionInLine(t) + getLength(t)) {
            return true;
        }
        return false;
    }
    
    public static boolean isAtomic(Property p, Map<List<String>, Map<String, ClassTemplate>> classTemplateMap) {
        ETypedElement s = TcsUtil.getStructuralFeature(p);
        if (s != null) {
            if (s instanceof EReference) {
                if (!PropertyArgumentUtil.containsRefersToArg(p) && !PropertyArgumentUtil.containsAsArg(p) && !PropertyArgumentUtil.containsLookupScopePArg(p)) {
                    return false;
                }

            }
            if (s instanceof EAttribute && classTemplateMap != null) {
                // check if we have a non-primitive type attribute by querying
                // classTemplateMap
                List<String> typeName = TcsUtil.getQualifiedName(TcsUtil.getType(p));
                if (classTemplateMap.containsKey(typeName)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static Stack<Property> duplicatePropertyStack(Stack<Property> source) {
        if (source == null) {
            return null;
        }
        Stack<Property> copiedPropertyStack = new Stack<Property>();
        for (Property p : source) {
            copiedPropertyStack.push(p);
        }
        return copiedPropertyStack;
    }

    public static Stack<FunctionCall> duplicateFunctionCallStack(Stack<FunctionCall> source) {
        if (source == null) {
            return null;
        }
        Stack<FunctionCall> copiedFunctionCallStack = new Stack<FunctionCall>();
        for (FunctionCall p : source) {
            copiedFunctionCallStack.push(p);
        }
        return copiedFunctionCallStack;
    }

    public static Stack<Template> duplicateTemplateStack(Stack<Template> source) {
        if (source == null) {
            return null;
        }
        Stack<Template> copiedTemplateStack = new Stack<Template>();
        for (Template p : source) {
            copiedTemplateStack.push(p);
        }
        return copiedTemplateStack;
    }
}
