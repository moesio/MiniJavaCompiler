//
// Generated by JTB 1.3.2
//

package br.com.seimos.minijava.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * f0 -> PrimaryExpression()
 * f1 -> &lt;LBRACKET&gt;
 * f2 -> Expression()
 * f3 -> &lt;RBRACKET&gt;
 * </PRE>
 */
public class ArrayLookupExpression implements Node {
	public PrimaryExpression f0;
	public NodeToken f1;
	public Expression f2;
	public NodeToken f3;

	public ArrayLookupExpression(PrimaryExpression n0, NodeToken n1, Expression n2, NodeToken n3) {
		f0 = n0;
		f1 = n1;
		f2 = n2;
		f3 = n3;
	}

	public ArrayLookupExpression(PrimaryExpression n0, Expression n1) {
		f0 = n0;
		f1 = new NodeToken("[");
		f2 = n1;
		f3 = new NodeToken("]");
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
