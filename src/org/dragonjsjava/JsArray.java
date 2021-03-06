package org.dragonjsjava;

import java.util.ArrayList;
import java.util.List;

/**
 * According to json.org, a json array = [ value (, value...) ]
 * So basically a collection of values separated by commas, enclosed by square braces
 */
public class JsArray implements JsValue {
	
	private List<JsValue> values;
	private String jsValueString;
	
	//Constructors
	public JsArray(List<JsValue> values) {
		this.values = values;
	}
	public JsArray(JsValue... jsValuesArray) {
		values = new ArrayList<JsValue>();
		if(jsValuesArray != null) {
			for(JsValue entryIt : jsValuesArray) {
				values.add(entryIt);
			}
		}
	}
	/**
	 * Just in case you want to build it yourself...
	 */
	public JsArray(String jsValueString) {
		this.jsValueString = jsValueString;
	}

	/**
	 * This method iterates through all values in this array and calls "generateJsValueString" on each,
	 * separates by commas, and wraps in square braces and returns the string result
	 * Ex = [ 1, 2, 3, 4, "aString", [ "anestedarrayelement1" ], { anObject : "anObjectvalue" } ] 
	 */
	@Override
	public String generateJsValueString() {
		
		if(jsValueString != null) {
			return jsValueString;
		}
		
		StringBuilder resultString = new StringBuilder();
		resultString.append("[ ");
		if(values != null && !values.isEmpty()) {
			Boolean first = Boolean.TRUE;
			for(JsValue valueIt : values) {
				if(!first) {
					resultString.append(", ");
				}
				resultString.append(valueIt.generateJsValueString());
				first = Boolean.FALSE;
			}
		}
		resultString.append(" ]");
		return resultString.toString();
	}
}