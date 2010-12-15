package org.dragonjsjava;

public class JsNumber implements JsValue {
	
	private int wholeNumber;
	private int decimal;
	private int e;
	
	public JsNumber(int wholeNumber, int decimal, int e) {
		this.wholeNumber = wholeNumber;
		this.decimal = decimal;
		this.e = e;
	}

	@Override
	public String generateJsValueString() {
		
		StringBuilder resultString = new StringBuilder();
		
		resultString.append(Integer.toString(wholeNumber));
		
		if(decimal > 0 || decimal < 0) {
			int returnDecimal = Math.abs(decimal);
			resultString.append(".");
			resultString.append(Integer.toString(returnDecimal));
		}
		
		if(e > 0 || e < 0) {
			resultString.append("E");
			resultString.append(Integer.toString(e));
		}
		
		return resultString.toString();
		
	}
	
}