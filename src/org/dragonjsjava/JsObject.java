package org.dragonjsjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Per json.org, a json object is { string : value (, string : value...) }
 * So basically name / value pairs separated by commas, enclosed by curly braces
 */
public class JsObject implements JsValue {
	
	private List<JsObjectEntry> jsObjectEntries;
	private String jsValueString;
	
	public JsObject(List<JsObjectEntry> jsObjectEntries) {
		this.jsObjectEntries = jsObjectEntries;
	}
	public JsObject(JsObjectEntry... jsObjectEntries) {
		List<JsObjectEntry> jsObjectEntryList = new ArrayList<JsObjectEntry>();
		for(JsObjectEntry jsObjectEntryIt : jsObjectEntries) {
			if(jsObjectEntryIt != null) {
				jsObjectEntryList.add(jsObjectEntryIt);
			}
		}
		this.jsObjectEntries = jsObjectEntryList;
	}
	/**
	 * Just in case you want to build it yourself...
	 */
	public JsObject(String jsValueString) {
		this.jsValueString = jsValueString;
	}
	
	/**
	 * Creates a string js object - like { name : "someName", num : 5 }
	 * Uses the list of JsObjectEntries it has
	 */
	@Override
	public String generateJsValueString() {
		
		if(jsValueString != null) {
			return jsValueString;
		}
		
		StringBuilder resultString = new StringBuilder();
		resultString.append("{ ");
		if(jsObjectEntries != null && !jsObjectEntries.isEmpty()) {
			Boolean first = Boolean.TRUE;
			for(JsObjectEntry objectEntryIt : jsObjectEntries) {
				if(!first) {
					resultString.append(", ");
				}
				resultString.append(objectEntryIt.getJsObjectEntryString());
				first = Boolean.FALSE;
			}
		}
		resultString.append(" }");
		
		return resultString.toString();
	}
	
	/**
	 * Takes the input map of JsProperty -> JsValue and translates it into
	 *   a list of JsObjectEntries. It adds this list to a new JsObject, then
	 *   runs the generateJsValueString on that object
	 */
	public static String generateJsObjectString(Map<JsProperty, JsValue> jsObjectEntryMap) {
		List<JsObjectEntry> jsObjectEntryList = new ArrayList<JsObjectEntry>();
		for(Entry<JsProperty, JsValue> entryIt : jsObjectEntryMap.entrySet()) {
			JsObjectEntry jsObjectEntry = new JsObjectEntry(entryIt.getKey(), entryIt.getValue());
			jsObjectEntryList.add(jsObjectEntry);
		}
		JsObject resultJsObject = new JsObject(jsObjectEntryList);
		return resultJsObject.generateJsValueString();
	}
}