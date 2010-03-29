package com.sap.ide.cts.parser.incremental.util;

import java.util.List;

import com.sap.ide.cts.parser.incremental.util.TarjansLCA.Node;

public class DefaultTarjanTreeContentProvider<T> implements
		ITarjanTreeContentProvider<T> {

	@Override
	public List<Node<T>> getChildren(Node<T> node) {
		return node.children;
	}

}
