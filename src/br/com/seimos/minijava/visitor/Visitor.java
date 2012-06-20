//
// Generated by JTB 1.3.2
//

package br.com.seimos.minijava.visitor;

import br.com.seimos.minijava.syntaxtree.*;

/**
 * All void visitors must implement this interface.
 */

public interface Visitor {

	//
	// void Auto class visitors
	//

	public void visit(NodeList n);

	public void visit(NodeListOptional n);

	public void visit(NodeOptional n);

	public void visit(NodeSequence n);

	public void visit(NodeToken n);

	//
	// User-generated visitor methods below
	//

	/**
	 * <PRE>
	 * f0 -> MainClass()
	 * f1 -> ClassDeclarationList()
	 * f2 -> &lt;EOF&gt;
	 * </PRE>
	 */
	public void visit(Program n);

	/**
	 * <PRE>
	 * f0 -> &lt;CLASS&gt;
	 * f1 -> &lt;IDENTIFIER&gt;
	 * f2 -> &lt;LBRACE&gt;
	 * f3 -> &lt;PUBLIC&gt;
	 * f4 -> &lt;STATIC&gt;
	 * f5 -> &lt;VOID&gt;
	 * f6 -> &lt;MAIN&gt;
	 * f7 -> &lt;LPAREN&gt;
	 * f8 -> &lt;STRING&gt;
	 * f9 -> &lt;LBRACKET&gt;
	 * f10 -> &lt;RBRACKET&gt;
	 * f11 -> &lt;IDENTIFIER&gt;
	 * f12 -> &lt;RPAREN&gt;
	 * f13 -> &lt;LBRACE&gt;
	 * f14 -> Statement()
	 * f15 -> &lt;RBRACE&gt;
	 * f16 -> &lt;RBRACE&gt;
	 * </PRE>
	 */
	public void visit(MainClass n);

	/**
	 * <PRE>
	 * f0 -> &lt;CLASS&gt;
	 * f1 -> &lt;IDENTIFIER&gt;
	 * f2 -> ( &lt;EXTENDS&gt; &lt;IDENTIFIER&gt; )?
	 * f3 -> &lt;LBRACE&gt;
	 * f4 -> VarDeclarationList()
	 * f5 -> MethodDeclarationList()
	 * f6 -> &lt;RBRACE&gt;
	 * </PRE>
	 */
	public void visit(ClassDeclaration n);

	/**
	 * <PRE>
	 * f0 -> [ ClassDeclaration() ClassDeclarationList() ]
	 * </PRE>
	 */
	public void visit(ClassDeclarationList n);

	/**
	 * <PRE>
	 * f0 -> [ Statement() StatementList() ]
	 * </PRE>
	 */
	public void visit(StatementList n);

	/**
	 * <PRE>
	 * f0 -> &lt;LBRACE&gt; StatementList() &lt;RBRACE&gt;
	 *       | &lt;IF&gt; &lt;LPAREN&gt; Expression() &lt;RPAREN&gt; Statement() &lt;ELSE&gt; Statement()
	 *       | &lt;WHILE&gt; &lt;LPAREN&gt; Expression() &lt;RPAREN&gt; Statement()
	 *       | &lt;SYSO&gt; &lt;LPAREN&gt; Expression() &lt;RPAREN&gt; &lt;SEMICOLON&gt;
	 *       | &lt;IDENTIFIER&gt; &lt;EQUALS&gt; Expression() &lt;SEMICOLON&gt;
	 *       | &lt;IDENTIFIER&gt; &lt;LBRACKET&gt; Expression() &lt;RBRACKET&gt; &lt;EQUALS&gt; Expression() &lt;SEMICOLON&gt;
	 * </PRE>
	 */
	public void visit(Statement n);

	/**
	 * <PRE>
	 * f0 -> Type()
	 * f1 -> &lt;IDENTIFIER&gt;
	 * f2 -> &lt;SEMICOLON&gt;
	 * </PRE>
	 */
	public void visit(VarDeclaration n);

	/**
	 * <PRE>
	 * f0 -> [ VarDeclaration() VarDeclarationList() ]
	 * </PRE>
	 */
	public void visit(VarDeclarationList n);

	/**
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
	public void visit(MethodDeclaration n);

	/**
	 * <PRE>
	 * f0 -> [ MethodDeclaration() MethodDeclarationList() ]
	 * </PRE>
	 */
	public void visit(MethodDeclarationList n);

	/**
	 * <PRE>
	 * f0 -> AndExpression()
	 *       | LessThanExpression()
	 *       | PlusExpression()
	 *       | MinusExpression()
	 *       | TimesExpression()
	 *       | ArrayLookupExpression()
	 *       | ArrayLengthExpression()
	 *       | MethodCallExpression()
	 *       | PrimaryExpression()
	 * </PRE>
	 */
	public void visit(Expression n);

	/**
	 * <PRE>
	 * f0 -> &lt;INTEGER_LITERAL&gt;
	 *       | &lt;TRUE&gt;
	 *       | &lt;FALSE&gt;
	 *       | &lt;IDENTIFIER&gt;
	 *       | &lt;THIS&gt;
	 *       | &lt;NEW&gt; &lt;INTEGER&gt; &lt;LBRACKET&gt; Expression() &lt;RBRACKET&gt;
	 *       | &lt;NEW&gt; &lt;IDENTIFIER&gt; &lt;LPAREN&gt; &lt;RPAREN&gt;
	 *       | &lt;NOT&gt; Expression()
	 *       | &lt;LPAREN&gt; Expression() &lt;RPAREN&gt;
	 * </PRE>
	 */
	public void visit(PrimaryExpression n);

	/**
	 * <PRE>
	 * f0 -> [ Expression() ExpressionRestList() ]
	 * </PRE>
	 */
	public void visit(ExpressionList n);

	/**
	 * <PRE>
	 * f0 -> &lt;INTEGER&gt; &lt;LBRACKET&gt; &lt;RBRACKET&gt;
	 *       | &lt;BOOLEAN&gt;
	 *       | &lt;INTEGER&gt;
	 *       | &lt;IDENTIFIER&gt;
	 * </PRE>
	 */
	public void visit(Type n);

	/**
	 * <PRE>
	 * f0 -> [ Type() &lt;IDENTIFIER&gt; FormalRestList() ]
	 * </PRE>
	 */
	public void visit(FormalList n);

	/**
	 * <PRE>
	 * f0 -> &lt;COMMA&gt;
	 * f1 -> Type()
	 * f2 -> &lt;IDENTIFIER&gt;
	 * </PRE>
	 */
	public void visit(FormalRest n);

	/**
	 * <PRE>
	 * f0 -> [ FormalRest() FormalRestList() ]
	 * </PRE>
	 */
	public void visit(FormalRestList n);

	/**
	 * <PRE>
	 * f0 -> &lt;COMMA&gt;
	 * f1 -> Expression()
	 * </PRE>
	 */
	public void visit(ExpressionRest n);

	/**
	 * <PRE>
	 * f0 -> [ ExpressionRest() ExpressionRestList() ]
	 * </PRE>
	 */
	public void visit(ExpressionRestList n);

	/**
	 * <PRE>
	 * f0 -> PrimaryExpression()
	 * f1 -> &lt;AND&gt;
	 * f2 -> PrimaryExpression()
	 * </PRE>
	 */
	public void visit(AndExpression n);

	/**
	 * <PRE>
	 * f0 -> PrimaryExpression()
	 * f1 -> &lt;LT&gt;
	 * f2 -> PrimaryExpression()
	 * </PRE>
	 */
	public void visit(LessThanExpression n);

	/**
	 * <PRE>
	 * f0 -> PrimaryExpression()
	 * f1 -> &lt;PLUS&gt;
	 * f2 -> PrimaryExpression()
	 * </PRE>
	 */
	public void visit(PlusExpression n);

	/**
	 * <PRE>
	 * f0 -> PrimaryExpression()
	 * f1 -> &lt;MINUS&gt;
	 * f2 -> PrimaryExpression()
	 * </PRE>
	 */
	public void visit(MinusExpression n);

	/**
	 * <PRE>
	 * f0 -> PrimaryExpression()
	 * f1 -> &lt;TIMES&gt;
	 * f2 -> PrimaryExpression()
	 * </PRE>
	 */
	public void visit(TimesExpression n);

	/**
	 * <PRE>
	 * f0 -> PrimaryExpression()
	 * f1 -> &lt;LBRACKET&gt;
	 * f2 -> Expression()
	 * f3 -> &lt;RBRACKET&gt;
	 * </PRE>
	 */
	public void visit(ArrayLookupExpression n);

	/**
	 * <PRE>
	 * f0 -> PrimaryExpression()
	 * f1 -> &lt;DOT&gt;
	 * f2 -> &lt;LENGTH&gt;
	 * </PRE>
	 */
	public void visit(ArrayLengthExpression n);

	/**
	 * <PRE>
	 * f0 -> PrimaryExpression()
	 * f1 -> &lt;DOT&gt;
	 * f2 -> &lt;IDENTIFIER&gt;
	 * f3 -> &lt;LPAREN&gt;
	 * f4 -> ExpressionList()
	 * f5 -> &lt;RPAREN&gt;
	 * </PRE>
	 */
	public void visit(MethodCallExpression n);

}
