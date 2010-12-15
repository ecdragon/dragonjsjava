package org.dragonjsjava;

import java.util.ArrayList;
import java.util.List;

public class JsCodeBlock {
	
	private List<JsCreatable> linesOfCode = new ArrayList<JsCreatable>();
	
	public void addLine(JsCreatable newLine) {
		linesOfCode.add(newLine);
	}
	
	public String generateCodeBlock() {
		StringBuilder codeBlockBuilder = new StringBuilder();
		for(JsCreatable lineIt : linesOfCode) {
			codeBlockBuilder.append(lineIt.generateJsCreateString());
			codeBlockBuilder.append("\n");
		}
		String codeBlockString = codeBlockBuilder.toString();
		System.out.println(codeBlockString);
		return codeBlockString;
	}
}