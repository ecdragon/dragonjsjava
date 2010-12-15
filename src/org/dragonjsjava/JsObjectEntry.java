package org.dragonjsjava;

public class JsObjectEntry {
	
	private JsProperty property;
	private JsValue jsValue;
	
	//Constructor ensures name generation (but doesn't prevent null)
	public JsObjectEntry(JsProperty property, JsValue jsValue) {
		this.property = property;
		this.jsValue = jsValue;
	}
	
	public String getJsProperty() {
		return property.name();
	}	
	public JsValue getJsValue() {
		return jsValue;
	}

	/**
	 * Returns name : valueJsString (quoted string, number, etc) unquoted
	 */
	public String getJsObjectEntryString() {
		return property.name() + " : " + jsValue.generateJsValueString();
	}
}