package br.com.seimos.minijava.visitor;

import java.util.Enumeration;
import java.util.HashMap;

import br.com.seimos.minijava.errorcheck.Error;
import br.com.seimos.minijava.symboltable.ClassTable;
import br.com.seimos.minijava.symboltable.MethodTable;
import br.com.seimos.minijava.syntaxtree.AndExpression;
import br.com.seimos.minijava.syntaxtree.ArrayLengthExpression;
import br.com.seimos.minijava.syntaxtree.ArrayLookupExpression;
import br.com.seimos.minijava.syntaxtree.ClassDeclaration;
import br.com.seimos.minijava.syntaxtree.ClassDeclarationList;
import br.com.seimos.minijava.syntaxtree.Expression;
import br.com.seimos.minijava.syntaxtree.ExpressionList;
import br.com.seimos.minijava.syntaxtree.ExpressionRest;
import br.com.seimos.minijava.syntaxtree.ExpressionRestList;
import br.com.seimos.minijava.syntaxtree.FormalList;
import br.com.seimos.minijava.syntaxtree.FormalRest;
import br.com.seimos.minijava.syntaxtree.FormalRestList;
import br.com.seimos.minijava.syntaxtree.LessThanExpression;
import br.com.seimos.minijava.syntaxtree.MainClass;
import br.com.seimos.minijava.syntaxtree.MethodCallExpression;
import br.com.seimos.minijava.syntaxtree.MethodDeclaration;
import br.com.seimos.minijava.syntaxtree.MethodDeclarationList;
import br.com.seimos.minijava.syntaxtree.MinusExpression;
import br.com.seimos.minijava.syntaxtree.Node;
import br.com.seimos.minijava.syntaxtree.NodeChoice;
import br.com.seimos.minijava.syntaxtree.NodeList;
import br.com.seimos.minijava.syntaxtree.NodeListOptional;
import br.com.seimos.minijava.syntaxtree.NodeOptional;
import br.com.seimos.minijava.syntaxtree.NodeSequence;
import br.com.seimos.minijava.syntaxtree.NodeToken;
import br.com.seimos.minijava.syntaxtree.PlusExpression;
import br.com.seimos.minijava.syntaxtree.PrimaryExpression;
import br.com.seimos.minijava.syntaxtree.Program;
import br.com.seimos.minijava.syntaxtree.Statement;
import br.com.seimos.minijava.syntaxtree.StatementList;
import br.com.seimos.minijava.syntaxtree.TimesExpression;
import br.com.seimos.minijava.syntaxtree.Type;
import br.com.seimos.minijava.syntaxtree.VarDeclaration;
import br.com.seimos.minijava.syntaxtree.VarDeclarationList;

public class SymbolicTableVisitor implements Visitor {

	private static final String VOID = "void";
	private ClassTable currentClass;
	private MethodTable currentMethod;
	private HashMap<String, ClassTable> classList = new HashMap<String, ClassTable>();
	private HashMap<String, MethodTable> methodList = new HashMap<String, MethodTable>();
	private Error error = new Error();

	private void addToClassList(String name, ClassTable classTable) {
		if (classList.put(name, classTable) != null) {
			error.complain("class " + name + " already exists");
		}
	}

	private void addToMethodList(String name, MethodTable methodTable) {
		if (methodList.put(name, methodTable) != null) {
			error.complain("method " + name + " already exists at class " + currentClass);
		}
	}

	public void visit(NodeList n) {
		for (Enumeration<Node> e = n.elements(); e.hasMoreElements();)
			e.nextElement().accept(this);
	}

	public void visit(NodeListOptional n) {
		if (n.present())
			for (Enumeration<Node> e = n.elements(); e.hasMoreElements();)
				e.nextElement().accept(this);
	}

	public void visit(NodeOptional n) {
		if (n.present())
			n.node.accept(this);
	}

	public void visit(NodeSequence n) {
		for (Enumeration<Node> e = n.elements(); e.hasMoreElements();)
			e.nextElement().accept(this);
	}

	public void visit(NodeToken n) {
	}

	public void visit(NodeChoice n) {
	}

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
	public void visit(Program n) {
		n.f0.accept(this);
		n.f1.accept(this);

	}

	/**
	 * <PRE>
	 * f0 -> &lt;CLASS&gt;
	 * f1 -> &lt;IDENTIFIER&gt;
	 * f2 -> &lt;LBRACE&gt;
	 * f3 -> &lt;PUBLIC&gt;
	 * f4 -> &lt;STATIC&gt;
	 * f5 -> &lt;Type&gt;
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
	public void visit(MainClass n) {
		currentClass = new ClassTable(n.f1);
		addToClassList(n.f1.tokenImage, currentClass);
		currentMethod = new MethodTable(n.f5);
		addToMethodList(n.f11.tokenImage, currentMethod);
		currentMethod.setResultType(VOID);
		currentMethod.addParameter("string[]", n.f11);

		n.f1.accept(this);
		n.f5.accept(this);
		n.f11.accept(this);
		n.f14.accept(this);

		currentClass = null;

	}

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
	public void visit(ClassDeclaration n) {
		currentClass = new ClassTable(n.f1);
		if (n.f2.present()) {
			currentClass.setSuperClass(n.f2.node);
		}

		n.f1.accept(this);
		n.f2.accept(this);
		n.f4.accept(this);
		n.f5.accept(this);

		currentClass = null;

	}

	/**
	 * <PRE>
	 * f0 -> [ ClassDeclaration() ClassDeclarationList() ]
	 * </PRE>
	 */
	public void visit(ClassDeclarationList n) {
		n.f0.accept(this);
	}

	/**
	 * <PRE>
	 * f0 -> [ Statement() StatementList() ]
	 * </PRE>
	 */
	public void visit(StatementList n) {
		n.f0.accept(this);
	}

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
	public void visit(Statement n) {
		n.f0.accept(this);
	}

	/**
	 * <PRE>
	 * f0 -> Type()
	 * f1 -> &lt;IDENTIFIER&gt;
	 * f2 -> &lt;SEMICOLON&gt;
	 * </PRE>
	 */
	public void visit(VarDeclaration n) {
		n.f0.accept(this);
		n.f1.accept(this);
	}

	/**
	 * <PRE>
	 * f0 -> [ VarDeclaration() VarDeclarationList() ]
	 * </PRE>
	 */
	public void visit(VarDeclarationList n) {
		n.f0.accept(this);
	}

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
	public void visit(MethodDeclaration n) {
		n.f2.accept(this);
		n.f4.accept(this);
		n.f7.accept(this);
		n.f8.accept(this);
		n.f10.accept(this);
	}

	/**
	 * <PRE>
	 * f0 -> [ MethodDeclaration() MethodDeclarationList() ]
	 * </PRE>
	 */
	public void visit(MethodDeclarationList n) {
		n.f0.accept(this);
	}

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
	public void visit(Expression n) {
		n.f0.accept(this);
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
	public void visit(PrimaryExpression n) {
		n.f0.accept(this);
	}

	/**
	 * <PRE>
	 * f0 -> [ Expression() ExpressionRestList() ]
	 * </PRE>
	 */
	public void visit(ExpressionList n) {
		n.f0.accept(this);
	}

	/**
	 * <PRE>
	 * f0 -> &lt;INTEGER&gt; &lt;LBRACKET&gt; &lt;RBRACKET&gt;
	 *       | &lt;BOOLEAN&gt;
	 *       | &lt;INTEGER&gt;
	 *       | &lt;IDENTIFIER&gt;
	 * </PRE>
	 */
	public void visit(Type n) {
		n.f0.accept(this);
	}

	/**
	 * <PRE>
	 * f0 -> [ Type() &lt;IDENTIFIER&gt; FormalRestList() ]
	 * </PRE>
	 */
	public void visit(FormalList n) {
		n.f0.accept(this);
	}

	/**
	 * <PRE>
	 * f0 -> &lt;COMMA&gt;
	 * f1 -> Type()
	 * f2 -> &lt;IDENTIFIER&gt;
	 * </PRE>
	 */
	public void visit(FormalRest n) {
		n.f2.accept(this);
	}

	/**
	 * <PRE>
	 * f0 -> [ FormalRest() FormalRestList() ]
	 * </PRE>
	 */
	public void visit(FormalRestList n) {
		n.f0.accept(this);
	}

	/**
	 * <PRE>
	 * f0 -> &lt;COMMA&gt;
	 * f1 -> Expression()
	 * </PRE>
	 */
	public void visit(ExpressionRest n) {
		n.f0.accept(this);
		n.f1.accept(this);
	}

	/**
	 * <PRE>
	 * f0 -> [ ExpressionRest() ExpressionRestList() ]
	 * </PRE>
	 */
	public void visit(ExpressionRestList n) {
		n.f0.accept(this);
	}

	/**
	 * <PRE>
	 * f0 -> PrimaryExpression()
	 * f1 -> &lt;AND&gt;
	 * f2 -> PrimaryExpression()
	 * </PRE>
	 */
	public void visit(AndExpression n) {
		n.f0.accept(this);
		n.f2.accept(this);
	}

	/**
	 * <PRE>
	 * f0 -> PrimaryExpression()
	 * f1 -> &lt;LT&gt;
	 * f2 -> PrimaryExpression()
	 * </PRE>
	 */
	public void visit(LessThanExpression n) {
		n.f0.accept(this);
		n.f2.accept(this);
	}

	/**
	 * <PRE>
	 * f0 -> PrimaryExpression()
	 * f1 -> &lt;PLUS&gt;
	 * f2 -> PrimaryExpression()
	 * </PRE>
	 */
	public void visit(PlusExpression n) {
		n.f0.accept(this);
		n.f2.accept(this);
	}

	/**
	 * <PRE>
	 * f0 -> PrimaryExpression()
	 * f1 -> &lt;MINUS&gt;
	 * f2 -> PrimaryExpression()
	 * </PRE>
	 */
	public void visit(MinusExpression n) {
		n.f0.accept(this);
		n.f2.accept(this);
	}

	/**
	 * <PRE>
	 * f0 -> PrimaryExpression()
	 * f1 -> &lt;TIMES&gt;
	 * f2 -> PrimaryExpression()
	 * </PRE>
	 */
	public void visit(TimesExpression n) {
		n.f0.accept(this);
		n.f2.accept(this);
	}

	/**
	 * <PRE>
	 * f0 -> PrimaryExpression()
	 * f1 -> &lt;LBRACKET&gt;
	 * f2 -> Expression()
	 * f3 -> &lt;RBRACKET&gt;
	 * </PRE>
	 */
	public void visit(ArrayLookupExpression n) {
		n.f0.accept(this);
		n.f2.accept(this);
	}

	/**
	 * <PRE>
	 * f0 -> PrimaryExpression()
	 * f1 -> &lt;DOT&gt;
	 * f2 -> &lt;LENGTH&gt;
	 * </PRE>
	 */
	public void visit(ArrayLengthExpression n) {
		n.f0.accept(this);
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
	public void visit(MethodCallExpression n) {
		n.f0.accept(this);
		n.f2.accept(this);
		n.f4.accept(this);
	}

}
