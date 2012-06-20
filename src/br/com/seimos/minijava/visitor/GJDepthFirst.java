//
// Generated by JTB 1.3.2
//

package br.com.seimos.minijava.visitor;
import br.com.seimos.minijava.syntaxtree.*;
import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class GJDepthFirst<R,A> implements GJVisitor<R,A> {
   //
   // Auto class visitors--probably don't need to be overridden.
   //
   public R visit(NodeList n, A argu) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeListOptional n, A argu) {
      if ( n.present() ) {
         R _ret=null;
         int _count=0;
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this,argu);
            _count++;
         }
         return _ret;
      }
      else
         return null;
   }

   public R visit(NodeOptional n, A argu) {
      if ( n.present() )
         return n.node.accept(this,argu);
      else
         return null;
   }

   public R visit(NodeSequence n, A argu) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeToken n, A argu) { return null; }

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
   public R visit(Program n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
   }

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
   public R visit(MainClass n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
      n.f6.accept(this, argu);
      n.f7.accept(this, argu);
      n.f8.accept(this, argu);
      n.f9.accept(this, argu);
      n.f10.accept(this, argu);
      n.f11.accept(this, argu);
      n.f12.accept(this, argu);
      n.f13.accept(this, argu);
      n.f14.accept(this, argu);
      n.f15.accept(this, argu);
      n.f16.accept(this, argu);
      return _ret;
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
   public R visit(ClassDeclaration n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
      n.f6.accept(this, argu);
      return _ret;
   }

   /**
    * <PRE>
    * f0 -> [ ClassDeclaration() ClassDeclarationList() ]
    * </PRE>
    */
   public R visit(ClassDeclarationList n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * <PRE>
    * f0 -> [ Statement() StatementList() ]
    * </PRE>
    */
   public R visit(StatementList n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
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
   public R visit(Statement n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * <PRE>
    * f0 -> Type()
    * f1 -> &lt;IDENTIFIER&gt;
    * f2 -> &lt;SEMICOLON&gt;
    * </PRE>
    */
   public R visit(VarDeclaration n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
   }

   /**
    * <PRE>
    * f0 -> [ VarDeclaration() VarDeclarationList() ]
    * </PRE>
    */
   public R visit(VarDeclarationList n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
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
   public R visit(MethodDeclaration n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
      n.f6.accept(this, argu);
      n.f7.accept(this, argu);
      n.f8.accept(this, argu);
      n.f9.accept(this, argu);
      n.f10.accept(this, argu);
      n.f11.accept(this, argu);
      n.f12.accept(this, argu);
      return _ret;
   }

   /**
    * <PRE>
    * f0 -> [ MethodDeclaration() MethodDeclarationList() ]
    * </PRE>
    */
   public R visit(MethodDeclarationList n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
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
   public R visit(Expression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
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
   public R visit(PrimaryExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * <PRE>
    * f0 -> [ Expression() ExpressionRestList() ]
    * </PRE>
    */
   public R visit(ExpressionList n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * <PRE>
    * f0 -> &lt;INTEGER&gt; &lt;LBRACKET&gt; &lt;RBRACKET&gt;
    *       | &lt;BOOLEAN&gt;
    *       | &lt;INTEGER&gt;
    *       | &lt;IDENTIFIER&gt;
    * </PRE>
    */
   public R visit(Type n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * <PRE>
    * f0 -> [ Type() &lt;IDENTIFIER&gt; FormalRestList() ]
    * </PRE>
    */
   public R visit(FormalList n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * <PRE>
    * f0 -> &lt;COMMA&gt;
    * f1 -> Type()
    * f2 -> &lt;IDENTIFIER&gt;
    * </PRE>
    */
   public R visit(FormalRest n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
   }

   /**
    * <PRE>
    * f0 -> [ FormalRest() FormalRestList() ]
    * </PRE>
    */
   public R visit(FormalRestList n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * <PRE>
    * f0 -> &lt;COMMA&gt;
    * f1 -> Expression()
    * </PRE>
    */
   public R visit(ExpressionRest n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      return _ret;
   }

   /**
    * <PRE>
    * f0 -> [ ExpressionRest() ExpressionRestList() ]
    * </PRE>
    */
   public R visit(ExpressionRestList n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * <PRE>
    * f0 -> PrimaryExpression()
    * f1 -> &lt;AND&gt;
    * f2 -> PrimaryExpression()
    * </PRE>
    */
   public R visit(AndExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
   }

   /**
    * <PRE>
    * f0 -> PrimaryExpression()
    * f1 -> &lt;LT&gt;
    * f2 -> PrimaryExpression()
    * </PRE>
    */
   public R visit(LessThanExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
   }

   /**
    * <PRE>
    * f0 -> PrimaryExpression()
    * f1 -> &lt;PLUS&gt;
    * f2 -> PrimaryExpression()
    * </PRE>
    */
   public R visit(PlusExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
   }

   /**
    * <PRE>
    * f0 -> PrimaryExpression()
    * f1 -> &lt;MINUS&gt;
    * f2 -> PrimaryExpression()
    * </PRE>
    */
   public R visit(MinusExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
   }

   /**
    * <PRE>
    * f0 -> PrimaryExpression()
    * f1 -> &lt;TIMES&gt;
    * f2 -> PrimaryExpression()
    * </PRE>
    */
   public R visit(TimesExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
   }

   /**
    * <PRE>
    * f0 -> PrimaryExpression()
    * f1 -> &lt;LBRACKET&gt;
    * f2 -> Expression()
    * f3 -> &lt;RBRACKET&gt;
    * </PRE>
    */
   public R visit(ArrayLookupExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      return _ret;
   }

   /**
    * <PRE>
    * f0 -> PrimaryExpression()
    * f1 -> &lt;DOT&gt;
    * f2 -> &lt;LENGTH&gt;
    * </PRE>
    */
   public R visit(ArrayLengthExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
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
   public R visit(MethodCallExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
      return _ret;
   }

}