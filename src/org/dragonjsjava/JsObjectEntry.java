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
	 * Returns name (string) : valueJsString (string, number, etc)
	 * Property name is fed into JsString to have it rendered as a string (with quotes)
	 */
	public String getJsObjectEntryString() {
		return (new JsString(property.name()).generateJsValueString()) + " : " + jsValue.generateJsValueString();
	}
}