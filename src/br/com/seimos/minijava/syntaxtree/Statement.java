//
// Generated by JTB 1.3.2
//

package br.com.seimos.minijava.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * f0 -> &lt;LBRACE&gt; StatementList() &lt;RBRACE&gt;
 *       | &lt;IF&gt; &lt;LPAREN&gt; Expression() &lt;RPAREN&gt; Statement() &lt;ELSE&gt; Statement()
 *       | &lt;WHILE&gt; &lt;LPAREN&gt; Expression() &lt;RPAREN&gt; Statement()
 *       | &lt;SYSO&gt; &lt;LPAREN&gt; Expression() &lt;RPAREN&gt; &lt;SEMICOLON&gt;
 *       | &lt;IDENTIFIER&gt; &lt;EQUALS&gt; Expression() &lt;SEMICOLON&gt;
 *       | &lt;IDENTIFIER&gt; &lt;LBRACKET&gt; Expression() &lt;RBRACKET&gt; &lt;EQUALS&gt; Expression() &lt;SEMICOLON&gt;
 * </PRE>
 */
public class Statement implements Node {
	public NodeChoice f0;

	public Statement(NodeChoice n0) {
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
