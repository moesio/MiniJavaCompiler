//
// Generated by JTB 1.3.2
//

package br.com.seimos.minijava.syntaxtree;


/**
 * Grammar production:
 * <PRE>
 * f0 -> Type()
 * f1 -> &lt;IDENTIFIER&gt;
 * f2 -> &lt;SEMICOLON&gt;
 * </PRE>
 */
public class VarDeclaration implements Node {
   public Type f0;
   public NodeToken f1;
   public NodeToken f2;

   public VarDeclaration(Type n0, NodeToken n1, NodeToken n2) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
   }

   public VarDeclaration(Type n0, NodeToken n1) {
      f0 = n0;
      f1 = n1;
      f2 = new NodeToken(";");
   }

   public void accept(br.com.seimos.minijava.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(br.com.seimos.minijava.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(br.com.seimos.minijava.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(br.com.seimos.minijava.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

