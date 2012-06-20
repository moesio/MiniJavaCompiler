MiniJavaCompiler
================

MiniJava compiler. A study for Modern Compilers

Para gerar o léxico
$ pwd
src/br/com/seimos/minijava/parser
$ java -classpath ../../../../resources/javacc.jar javacc MiniJavaGrammar.jj 

- Depois de gerado o léxico, usei o jtb.jar dentro de resources para gerar a árvore sintática e os visitors da seguinte forma

$ pwd
src/br/com/seimos/minijava
$ java -jar ../../../../../resources/jtb132.jar -o parser/MiniJavaGrammarAST.txt -p br.com.seimos.minijava -jd -printer parser/MiniJavaGrammar.jj 