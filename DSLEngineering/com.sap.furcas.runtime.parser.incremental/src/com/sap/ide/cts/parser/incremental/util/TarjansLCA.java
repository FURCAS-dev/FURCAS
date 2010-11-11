package com.sap.ide.cts.parser.incremental.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Used to find the least common ancestor in two given nodes within a tree.
 * This is an implementation of <a
 * href="http://en.wikipedia.org/wiki/Tarjan%27s_off-line_least_common_ancestors_algorithm">Tarjan's
 * off-line least common ancestor algorithm</a> which has a linear complexity!
 */
public class TarjansLCA <T> {
	
	private ITarjanTreeContentProvider<T> contentProvider;
	
	public TarjansLCA(ITarjanTreeContentProvider<T> provider) {
		if(provider == null) {
			contentProvider = new DefaultTarjanTreeContentProvider<T>();
		} else {
			contentProvider = provider;
		}
	}
	
	public T lcaSearch(T rootNode, T from, T to) {
		SearchSet<T> query = new SearchSet<T>(from, to);
		lca(new Node<T>(rootNode), Collections.singletonList(query));
		return query.result;
	}
	

	public void lca(Node<T> node, List<SearchSet<T>> queries) {
	     MakeSet(node);
	    // u.ancestor = u;
	     for(Node<T> subnode : contentProvider.getChildren(node)){
	    	 lca(subnode, queries);
	         union(node,subnode);
	         find(node).ancestor = node;
	     }
	     node.checked = true;
	     for(SearchSet<T> query : queries){
	    	 if(query.start.equals(query.end)) {
	    		 query.result = query.start;
	    	 }
	         if(query.start.equals(node.argumet)) {
	        	 query.startNode = node;
	        	 if((query.endNode != null && query.endNode.checked)) {
	        		 query.result = find(query.endNode).argumet;
	        	 } 
	         }else if(query.end.equals(node.argumet)) {
	        	 query.endNode = node;
	        	 if(query.startNode != null && query.startNode.checked) {
	        		 query.result = find(query.startNode).argumet;
	        	 }
	         }
	     }
	     
	}
	
	private Node<T> find(Node<T> node) {
		Node<T> n=node;
        for( ; n.ancestor!=n; n=n.ancestor );
        return n;
	}

	private void union(Node<T> node1, Node<T> node2) {
		node2.ancestor=node1;
	}

	private void MakeSet(Node<T> u) {
		u.ancestor = u;
	}

	public static class SearchSet<T> {
		public T result;
		public T end;
		public Node<T> endNode;
		public T start;
		public Node<T> startNode;
		public SearchSet(T start, T end) {
			super();
			this.start = start;
			this.end = end;
		}
	}
	
	public static class Node<T> {
		
		private T argumet;

		public Node(T arg, Node<T> parent) {
			this.argumet = arg;
			if(parent != null) {
				parent.children.add(this);
			}
		}
		public Node(T argument) {
			argumet = argument;
		}
		public List<Node<T>> children = new ArrayList<Node<T>>();
		public boolean checked = false;
		public Node<T> ancestor;

		public T getArgumet() {
			return argumet;
		}
		public void setArgumet(T argumet) {
			this.argumet = argumet;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((argumet == null) ? 0 : argumet.hashCode());
			return result;
		}
		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final Node<T> other = (Node<T>) obj;
			if (argumet == null) {
				if (other.argumet != null)
					return false;
			} else if (!argumet.equals(other.argumet))
				return false;
			return true;
		}

	}
}
