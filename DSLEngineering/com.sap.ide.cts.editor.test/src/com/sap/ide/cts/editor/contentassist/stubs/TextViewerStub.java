package com.sap.ide.cts.editor.contentassist.stubs;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IEventConsumer;
import org.eclipse.jface.text.IFindReplaceTarget;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextInputListener;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.IUndoManager;
import org.eclipse.jface.text.IViewportListener;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;

import com.sap.ide.cts.editor.contentassist.TcsFixtureBase;
import com.sap.ide.cts.editor.test.util.StringReplacement;

/**
 * Stub loading document from Filepath.
 */
public class TextViewerStub implements ITextViewer {

	private String fixturePath;
	private StringReplacement postFixtureReplacement;

	public TextViewerStub(String fixturePath,
			StringReplacement postFixtureReplacement) {
		Assert.isNotNull(fixturePath);

		this.fixturePath = fixturePath;
		this.postFixtureReplacement = postFixtureReplacement;
	}

	@Override
	public IDocument getDocument() {
		InputStream in = TcsFixtureBase.class.getResourceAsStream(fixturePath);

		StringBuilder out = new StringBuilder();
		byte[] b = new byte[4096];
		try {
			for (int n; (n = in.read(b)) != -1;) {
				out.append(new String(b, 0, n));
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Document result = new Document(out.toString());
		if (postFixtureReplacement != null) {
			try {
				postFixtureReplacement.applyTo(result);
			} catch (BadLocationException e) {
				System.out.println("post fixture replacement failed: " + e);
				return new Document(out.toString());
			}
		}

		return result;
	}

	@Override
	public ISelectionProvider getSelectionProvider() {
		fail("not implemented");
		return null;
	}

	@Override
	public Point getSelectedRange() {
		fail("not implemented");
		return null;
	}

	@Override
	public StyledText getTextWidget() {
		return null;
	}

	@Override
	public void activatePlugins() {
		fail("not implemented");

	}

	@Override
	public void addTextInputListener(ITextInputListener listener) {
		fail("not implemented");

	}

	@Override
	public void addTextListener(ITextListener listener) {
		fail("not implemented");

	}

	@Override
	public void addViewportListener(IViewportListener listener) {
		fail("not implemented");

	}

	@Override
	public void changeTextPresentation(TextPresentation presentation,
			boolean controlRedraw) {
		fail("not implemented");

	}

	@Override
	public int getBottomIndex() {
		fail("not implemented");
		return 0;
	}

	@Override
	public int getBottomIndexEndOffset() {
		fail("not implemented");
		return 0;
	}

	@Override
	public IFindReplaceTarget getFindReplaceTarget() {
		fail("not implemented");
		return null;
	}

	@Override
	public ITextOperationTarget getTextOperationTarget() {
		fail("not implemented");
		return null;
	}

	@Override
	public int getTopIndex() {
		fail("not implemented");
		return 0;
	}

	@Override
	public int getTopIndexStartOffset() {
		fail("not implemented");
		return 0;
	}

	@Override
	public int getTopInset() {
		fail("not implemented");
		return 0;
	}

	@Override
	public IRegion getVisibleRegion() {
		fail("not implemented");
		return null;
	}

	@Override
	public void invalidateTextPresentation() {
		fail("not implemented");

	}

	@Override
	public boolean isEditable() {
		fail("not implemented");
		return false;
	}

	@Override
	public boolean overlapsWithVisibleRegion(int offset, int length) {
		fail("not implemented");
		return false;
	}

	@Override
	public void removeTextInputListener(ITextInputListener listener) {
		fail("not implemented");

	}

	@Override
	public void removeTextListener(ITextListener listener) {
		fail("not implemented");

	}

	@Override
	public void removeViewportListener(IViewportListener listener) {
		fail("not implemented");

	}

	@Override
	public void resetPlugins() {
		fail("not implemented");

	}

	@Override
	public void resetVisibleRegion() {
		fail("not implemented");

	}

	@Override
	public void revealRange(int offset, int length) {
		fail("not implemented");

	}

	@Deprecated
	@Override
	public void setAutoIndentStrategy(
			org.eclipse.jface.text.IAutoIndentStrategy strategy,
			String contentType) {
		fail("not implemented");

	}

	@Override
	public void setDefaultPrefixes(String[] defaultPrefixes, String contentType) {
		fail("not implemented");

	}

	@Override
	public void setDocument(IDocument document) {
		fail("not implemented");

	}

	@Override
	public void setDocument(IDocument document, int modelRangeOffset,
			int modelRangeLength) {
		fail("not implemented");

	}

	@Override
	public void setEditable(boolean editable) {
		fail("not implemented");

	}

	@Override
	public void setEventConsumer(IEventConsumer consumer) {
		fail("not implemented");

	}

	@Override
	public void setIndentPrefixes(String[] indentPrefixes, String contentType) {
		fail("not implemented");

	}

	@Override
	public void setSelectedRange(int offset, int length) {
		fail("not implemented");

	}

	@Override
	public void setTextDoubleClickStrategy(ITextDoubleClickStrategy strategy,
			String contentType) {
		fail("not implemented");

	}

	@Override
	public void setTextColor(Color color) {
		fail("not implemented");
	}

	@Override
	public void setTextColor(Color color, int offset, int length,
			boolean controlRedraw) {
		fail("not implemented");
	}

	@Override
	public void setTextHover(ITextHover textViewerHover, String contentType) {
		fail("not implemented");

	}

	@Override
	public void setTopIndex(int index) {
		fail("not implemented");

	}

	@Override
	public void setUndoManager(IUndoManager undoManager) {
		fail("not implemented");

	}

	@Override
	public void setVisibleRegion(int offset, int length) {
		fail("not implemented");

	}

}
