//
// Generated by JTB 1.3.2
//

package br.com.seimos.minijava.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * f0 -> PrimaryExpression()
 * f1 -> &lt;DOT&gt;
 * f2 -> &lt;IDENTIFIER&gt;
 * f3 -> &lt;LPAREN&gt;
 * f4 -> ExpressionList()
 * f5 -> &lt;RPAREN&gt;
 * </PRE>
 */
public class MethodCallExpression implements Node {
	public PrimaryExpression f0;
	public NodeToken f1;
	public NodeToken f2;
	public NodeToken f3;
	public ExpressionList f4;
	public NodeToken f5;

	public MethodCallExpression(PrimaryExpression n0, NodeToken n1, NodeToken n2, NodeToken n3, ExpressionList n4, NodeToken n5) {
		f0 = n0;
		f1 = n1;
		f2 = n2;
		f3 = n3;
		f4 = n4;
		f5 = n5;
	}

	public MethodCallExpression(PrimaryExpression n0, NodeToken n1, ExpressionList n2) {
		f0 = n0;
		f1 = new NodeToken(".");
		f2 = n1;
		f3 = new NodeToken("(");
		f4 = n2;
		f5 = new NodeToken(")");
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
