package org.dragonjsjava;

public class JsBoolean implements JsValue {
	
	private Boolean jsBoolean;
	
	public JsBoolean(Boolean jsBoolean) {
		this.jsBoolean = jsBoolean;
	}
	
	public Boolean getJsBoolean() {
		return jsBoolean;
	}
	/* Immutable
	public void setJsBoolean(Boolean jsBoolean) {
		this.jsBoolean = jsBoolean;
	}
	*/

	@Override
	public String generateJsValueString() {
		return jsBoolean ? "true" : "false";
	}
}