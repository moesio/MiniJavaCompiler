package br.com.seimos.minijava.visitor;

import br.com.seimos.minijava.errorcheck.Error;
import br.com.seimos.minijava.syntaxtree.AndExpression;
import br.com.seimos.minijava.syntaxtree.ArrayLengthExpression;
import br.com.seimos.minijava.syntaxtree.ArrayLookupExpression;
import br.com.seimos.minijava.syntaxtree.Expression;
import br.com.seimos.minijava.syntaxtree.ExpressionList;
import br.com.seimos.minijava.syntaxtree.ExpressionRest;
import br.com.seimos.minijava.syntaxtree.ExpressionRestList;
import br.com.seimos.minijava.syntaxtree.FormalList;
import br.com.seimos.minijava.syntaxtree.FormalRest;
import br.com.seimos.minijava.syntaxtree.FormalRestList;
import br.com.seimos.minijava.syntaxtree.LessThanExpression;
import br.com.seimos.minijava.syntaxtree.MethodCallExpression;
import br.com.seimos.minijava.syntaxtree.MethodDeclaration;
import br.com.seimos.minijava.syntaxtree.MinusExpression;
import br.com.seimos.minijava.syntaxtree.Node;
import br.com.seimos.minijava.syntaxtree.PlusExpression;
import br.com.seimos.minijava.syntaxtree.PrimaryExpression;
import br.com.seimos.minijava.syntaxtree.TimesExpression;
import br.com.seimos.minijava.syntaxtree.Type;
import br.com.seimos.minijava.syntaxtree.VarDeclaration;

public class TypeVisitor extends GJNoArguDepthFirst<String> {
	private final String BOOLEAN_TYPE = "boolean";
	private final String ARRAY_TYPE = "array";
	private final String INT_TYPE = "int";
	private Error error = new Error();

	//	/**
	//	 * <PRE>
	//	 * f0 -> MainClass()
	//	 * f1 -> ClassDeclarationList()
	//	 * f2 -> &lt;EOF&gt;
	//	 * </PRE>
	//	 */
	//	public String visit(Program n) {
	//		return super.visit(n);
	//	}
	//
	//	/**
	//	 * <PRE>
	//	 * f0 -> &lt;CLASS&gt;
	//	 * f1 -> &lt;IDENTIFIER&gt;
	//	 * f2 -> &lt;LBRACE&gt;
	//	 * f3 -> &lt;PUBLIC&gt;
	//	 * f4 -> &lt;STATIC&gt;
	//	 * f5 -> &lt;VOID&gt;
	//	 * f6 -> &lt;MAIN&gt;
	//	 * f7 -> &lt;LPAREN&gt;
	//	 * f8 -> &lt;STRING&gt;
	//	 * f9 -> &lt;LBRACKET&gt;
	//	 * f10 -> &lt;RBRACKET&gt;
	//	 * f11 -> &lt;IDENTIFIER&gt;
	//	 * f12 -> &lt;RPAREN&gt;
	//	 * f13 -> &lt;LBRACE&gt;
	//	 * f14 -> Statement()
	//	 * f15 -> &lt;RBRACE&gt;
	//	 * f16 -> &lt;RBRACE&gt;
	//	 * </PRE>
	//	 */
	//	public String visit(MainClass n) {
	//		return super.visit(n);
	//	}
	//
	//	/**
	//	 * <PRE>
	//	 * f0 -> &lt;CLASS&gt;
	//	 * f1 -> &lt;IDENTIFIER&gt;
	//	 * f2 -> ( &lt;EXTENDS&gt; &lt;IDENTIFIER&gt; )?
	//	 * f3 -> &lt;LBRACE&gt;
	//	 * f4 -> VarDeclarationList()
	//	 * f5 -> MethodDeclarationList()
	//	 * f6 -> &lt;RBRACE&gt;
	//	 * </PRE>
	//	 */
	//	public String visit(ClassDeclaration n) {
	//		return super.visit(n);
	//	}
	//
	//	/**
	//	 * <PRE>
	//	 * f0 -> [ ClassDeclaration() ClassDeclarationList() ]
	//	 * </PRE>
	//	 */
	//	public String visit(ClassDeclarationList n) {
	//		return super.visit(n);
	//	}
	//
	//	/**
	//	 * <PRE>
	//	 * f0 -> [ Statement() StatementList() ]
	//	 * </PRE>
	//	 */
	//	public String visit(StatementList n) {
	//		return super.visit(n);
	//	}
	//
	//	/**
	//	 * <PRE>
	//	 * f0 -> &lt;LBRACE&gt; StatementList() &lt;RBRACE&gt;
	//	 *       | &lt;IF&gt; &lt;LPAREN&gt; Expression() &lt;RPAREN&gt; Statement() &lt;ELSE&gt; Statement()
	//	 *       | &lt;WHILE&gt; &lt;LPAREN&gt; Expression() &lt;RPAREN&gt; Statement()
	//	 *       | &lt;SYSO&gt; &lt;LPAREN&gt; Expression() &lt;RPAREN&gt; &lt;SEMICOLON&gt;
	//	 *       | &lt;IDENTIFIER&gt; &lt;EQUALS&gt; Expression() &lt;SEMICOLON&gt;
	//	 *       | &lt;IDENTIFIER&gt; &lt;LBRACKET&gt; Expression() &lt;RBRACKET&gt; &lt;EQUALS&gt; Expression() &lt;SEMICOLON&gt;
	//	 * </PRE>
	//	 */
	//	public String visit(Statement n) {
	//		return super.visit(n);
	//	}

	/**
	 * <PRE>
	 * f0 -> Type()
	 * f1 -> &lt;IDENTIFIER&gt;
	 * f2 -> &lt;SEMICOLON&gt;
	 * </PRE>
	 */
	public String visit(VarDeclaration n) {
		return n.f0.accept(this);
	}

	//	/**
	//	 * <PRE>
	//	 * f0 -> [ VarDeclaration() VarDeclarationList() ]
	//	 * </PRE>
	//	 */
	//	public String visit(VarDeclarationList n) {
	//		return super.visit(n);
	//	}
	//
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
	public String visit(MethodDeclaration n) {
		String typeExpected = n.f1.accept(this);
		String typeReturned = n.f10.accept(this);
		if (!typeExpected.equals(typeReturned)) {
			error.complain("Method " + n.f12.tokenImage + " returns "
					+ typeReturned + ". " + typeExpected + " excpected");
		}
		return null;
	}

	//	/**
	//	 * <PRE>
	//	 * f0 -> [ MethodDeclaration() MethodDeclarationList() ]
	//	 * </PRE>
	//	 */
	//	public String visit(MethodDeclarationList n) {
	//		return super.visit(n);
	//	}
	//
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
	public String visit(Expression n) {
		String expected = null;
		switch (n.f0.which) {
		case 0:
		case 1:
			expected = BOOLEAN_TYPE;
			break;
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
			expected = INT_TYPE;
			break;
		}
		String result = n.f0.choice.accept(this);
		if (!result.equals(expected)) {
			error.complain(expected + " expected but " + result + " found");
		}
		return result;
	}

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
	public String visit(PrimaryExpression n) {
		String result = null;
		switch (n.f0.which) {
		case 0:
			result = INT_TYPE;
			break;
		case 1:
		case 2:
			result = BOOLEAN_TYPE;
			break;
		case 3:
			// TODO qual o tipo do identificador? Precisa consultar tabela de símbolos?
			break;
		}
		return result;
	}

	/**
	 * <PRE>
	 * f0 -> [ Expression() ExpressionRestList() ]
	 * </PRE>
	 */
	public String visit(ExpressionList n) {
		return super.visit(n);
	}

	/**
	 * <PRE>
	 * f0 -> &lt;INTEGER&gt; &lt;LBRACKET&gt; &lt;RBRACKET&gt;
	 *       | &lt;BOOLEAN&gt;
	 *       | &lt;INTEGER&gt;
	 *       | &lt;IDENTIFIER&gt;
	 * </PRE>
	 */
	public String visit(Type n) {
		String result = null;
		switch (n.f0.which) {
		case 0:
			result = "int[]";
			break;
		case 1:
			result = "boolean";
			break;
		case 2:
			result = "int";
			break;
		}
		super.visit(n);
		return result;
	}

	/**
	 * <PRE>
	 * f0 -> [ Type() &lt;IDENTIFIER&gt; FormalRestList() ]
	 * </PRE>
	 */
	public String visit(FormalList n) {
		return super.visit(n);
	}

	/**
	 * <PRE>
	 * f0 -> &lt;COMMA&gt;
	 * f1 -> Type()
	 * f2 -> &lt;IDENTIFIER&gt;
	 * </PRE>
	 */
	public String visit(FormalRest n) {
		return super.visit(n);
	}

	/**
	 * <PRE>
	 * f0 -> [ FormalRest() FormalRestList() ]
	 * </PRE>
	 */
	public String visit(FormalRestList n) {
		return super.visit(n);
	}

	/**
	 * <PRE>
	 * f0 -> &lt;COMMA&gt;
	 * f1 -> Expression()
	 * </PRE>
	 */
	public String visit(ExpressionRest n) {
		return super.visit(n);
	}

	/**
	 * <PRE>
	 * f0 -> [ ExpressionRest() ExpressionRestList() ]
	 * </PRE>
	 */
	public String visit(ExpressionRestList n) {
		return super.visit(n);
	}

	/**
	 * <PRE>
	 * f0 -> PrimaryExpression()
	 * f1 -> &lt;AND&gt;
	 * f2 -> PrimaryExpression()
	 * </PRE>
	 */
	public String visit(AndExpression n) {
		if (n.f0.accept(this).equals(BOOLEAN_TYPE)
				&& n.f2.accept(this).equals(BOOLEAN_TYPE)) {
			return BOOLEAN_TYPE;
		} else {
			return null;
		}
	}

	/**
	 * <PRE>
	 * f0 -> PrimaryExpression()
	 * f1 -> &lt;LT&gt;
	 * f2 -> PrimaryExpression()
	 * </PRE>
	 */
	public String visit(LessThanExpression n) {
		return super.visit(n);
	}

	/**
	 * <PRE>
	 * f0 -> PrimaryExpression()
	 * f1 -> &lt;PLUS&gt;
	 * f2 -> PrimaryExpression()
	 * </PRE>
	 */
	public String visit(PlusExpression n) {
		return super.visit(n);
	}

	/**
	 * <PRE>
	 * f0 -> PrimaryExpression()
	 * f1 -> &lt;MINUS&gt;
	 * f2 -> PrimaryExpression()
	 * </PRE>
	 */
	public String visit(MinusExpression n) {
		return super.visit(n);
	}

	/**
	 * <PRE>
	 * f0 -> PrimaryExpression()
	 * f1 -> &lt;TIMES&gt;
	 * f2 -> PrimaryExpression()
	 * </PRE>
	 */
	public String visit(TimesExpression n) {
		return super.visit(n);
	}

	/**
	 * <PRE>
	 * f0 -> PrimaryExpression()
	 * f1 -> &lt;LBRACKET&gt;
	 * f2 -> Expression()
	 * f3 -> &lt;RBRACKET&gt;
	 * </PRE>
	 */
	public String visit(ArrayLookupExpression n) {
		return super.visit(n);
	}

	/**
	 * <PRE>
	 * f0 -> PrimaryExpression()
	 * f1 -> &lt;DOT&gt;
	 * f2 -> &lt;LENGTH&gt;
	 * </PRE>
	 */
	public String visit(ArrayLengthExpression n) {
		return super.visit(n);
	}

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
	public String visit(MethodCallExpression n) {
		return super.visit(n);
	}

}