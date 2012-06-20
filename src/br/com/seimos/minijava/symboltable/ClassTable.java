package br.com.seimos.minijava.symboltable;

import java.util.HashMap;

import br.com.seimos.minijava.syntaxtree.Node;
import br.com.seimos.minijava.syntaxtree.NodeToken;

public class ClassTable {
	private HashMap<String, String> fields = new HashMap<String, String>();
	private HashMap<String, String> method = new HashMap<String, String>();
	private String name;
	private String superClass;

	public ClassTable(NodeToken identifier) {
		this.name = identifier.tokenImage;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(name);
		if (superClass != null) {
			result.append(" extends ").append(superClass);
		}
		return result.toString();
	}

	public void setSuperClass(Node node) {
		superClass = ((NodeToken) node).tokenImage;
	}
}
