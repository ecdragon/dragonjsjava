package org.dragonjsjava;

public class JsString implements JsValue{

	private String string;
	
	public JsString(String string) {
		this.string = string;
	}
	public String getString() {
		return string;
	}
	/* Immutable
	public void setString(String string) {
		this.string = string;
	}
	*/
	
	@Override
	public String generateJsValueString() {
		
		String resultString = "\"" + string + "\"";
		return resultString;
		
	}
	
}