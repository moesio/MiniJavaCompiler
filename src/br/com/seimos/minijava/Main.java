package br.com.seimos.minijava;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import br.com.seimos.minijava.parser.MiniJavaParser;
import br.com.seimos.minijava.syntaxtree.Program;
import br.com.seimos.minijava.visitor.TreeDumper;
import br.com.seimos.minijava.visitor.TreeFormatter;

public class Main {

	public static void main(String[] args) {

		ArrayList<String> files = new ArrayList<String>();
		files.add("resources/examples/BinarySearch");
		//		files.add("resources/examples/BinaryTree");
		//		files.add("resources/examples/BubbleSort");
		//		files.add("resources/examples/LinearSearch");
		//		files.add("resources/examples/Factorial");
		//		files.add("resources/examples/LinearSearch");
		//		files.add("resources/examples/LinkedList");
		//		files.add("resources/examples/QuickSort");
		//		files.add("resources/examples/TreeVisitor");

		BufferedReader reader;
		Main main = new Main();
		TreeDumper dumper = new TreeDumper();
		dumper.printSpecials(true);
		dumper.startAtNextToken();

		for (String fileName : files) {
			System.out.println(new StringBuilder().append("Compilando ").append(fileName)
					.append("... "));
			try {
				reader = new BufferedReader(new FileReader(new StringBuilder().append(fileName)
						.append(".java").toString()));
				Program program = main.lexicalAnalysis(reader);

				if (program != null) {
					program.accept(new TreeFormatter(5, 0));
					main.dumpingSource(dumper, program);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	private Program lexicalAnalysis(BufferedReader reader) {
		System.out.print("Análise léxica...");
		MiniJavaParser parser;
		parser = new MiniJavaParser(reader);
		Program program = null;
		try {
			program = parser.Program();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("Erro na compilação");
			System.out.println(e.getMessage());
		}
		return program;
	}

	private void dumpingSource(TreeDumper dumper, Program program) {
		System.out.println("Mostrando árvore...");

		dumper.resetPosition();
		program.accept(dumper);
		System.out.println("\nOK");
	}

}
