//
// Generated by JTB 1.3.2
//

package br.com.seimos.minijava.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * f0 -> &lt;PUBLIC&gt;
 * f1 -> Type()
 * f2 -> &lt;IDENTIFIER&gt;
 * f3 -> &lt;LPAREN&gt;
 * f4 -> FormalList()
 * f5 -> &lt;RPAREN&gt;
 * f6 -> &lt;LBRACE&gt;
 * f7 -> VarDeclarationList()
 * f8 -> StatementList()
 * f9 -> &lt;RETURN&gt;
 * f10 -> Expression()
 * f11 -> &lt;SEMICOLON&gt;
 * f12 -> &lt;RBRACE&gt;
 * </PRE>
 */
public class MethodDeclaration implements Node {
	public NodeToken f0;
	public Type f1;
	public NodeToken f2;
	public NodeToken f3;
	public FormalList f4;
	public NodeToken f5;
	public NodeToken f6;
	public VarDeclarationList f7;
	public StatementList f8;
	public NodeToken f9;
	public Expression f10;
	public NodeToken f11;
	public NodeToken f12;

	public MethodDeclaration(NodeToken n0, Type n1, NodeToken n2, NodeToken n3, FormalList n4, NodeToken n5, NodeToken n6, VarDeclarationList n7, StatementList n8, NodeToken n9,
			Expression n10, NodeToken n11, NodeToken n12) {
		f0 = n0;
		f1 = n1;
		f2 = n2;
		f3 = n3;
		f4 = n4;
		f5 = n5;
		f6 = n6;
		f7 = n7;
		f8 = n8;
		f9 = n9;
		f10 = n10;
		f11 = n11;
		f12 = n12;
	}

	public MethodDeclaration(Type n0, NodeToken n1, FormalList n2, VarDeclarationList n3, StatementList n4, Expression n5) {
		f0 = new NodeToken("public");
		f1 = n0;
		f2 = n1;
		f3 = new NodeToken("(");
		f4 = n2;
		f5 = new NodeToken(")");
		f6 = new NodeToken("{");
		f7 = n3;
		f8 = n4;
		f9 = new NodeToken("return");
		f10 = n5;
		f11 = new NodeToken(";");
		f12 = new NodeToken("}");
	}

	public void accept(br.com.seimos.minijava.visitor.Visitor v) {
		v.visit(this);
	}

	public <R, A> R accept(br.com.seimos.minijava.visitor.GJVisitor<R, A> v, A argu) {
		return v.visit(this, argu);
	}

	public <R> R accept(br.com.seimos.minijava.visitor.GJNoArguVisitor<R> v) {
		return v.visit(this);
	}

	public <A> void accept(br.com.seimos.minijava.visitor.GJVoidVisitor<A> v, A argu) {
		v.visit(this, argu);
	}
}
