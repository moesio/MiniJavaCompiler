package br.com.seimos.minijava.symboltable;

import java.util.HashMap;

import br.com.seimos.minijava.syntaxtree.NodeToken;

public class MethodTable {

	private HashMap<String, String> variables = new HashMap<String, String>();
	private HashMap<String, String> parameters = new HashMap<String, String>();
	private String name;
	private String resultType;
	
	public MethodTable(NodeToken identifier) {
		name = identifier.tokenImage;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public boolean addParameter(String type, NodeToken identifier) {
		if (variables.put(type, identifier.tokenImage) != null){
			return false;
		}
		return true;
	}

}
