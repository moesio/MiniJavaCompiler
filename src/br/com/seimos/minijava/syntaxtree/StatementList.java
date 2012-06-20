//
// Generated by JTB 1.3.2
//

package br.com.seimos.minijava.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * f0 -> [ Statement() StatementList() ]
 * </PRE>
 */
public class StatementList implements Node {
	public NodeOptional f0;

	public StatementList(NodeOptional n0) {
		f0 = n0;
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
