package de.DataCloud;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.github.jsonldjava.core.JsonLdOptions;
import com.github.jsonldjava.core.JsonLdProcessor;
import com.github.jsonldjava.utils.JsonUtils;

public class JSON_LD {

	// Open a valid json(-ld) input file
	
	InputStream inputStream;
	URL url;
	
	public JSON_LD(){
		try {
			url = new URL("http://localhost:8080/persons");
			
			String pattern = "id: \\d*";
			String replacement = ":\"$1\"";
			// Read the file into an Object (The type of this object will
			// be a List, Map, String, Boolean, Number or null, depending on the
			// root object if the file.
			Object jsonObject = JsonUtils.fromURLJavaNet(url);
			
			String jsonObjectQuoted = jsonObject.toString().replaceAll(pattern,  replacement);
			
			// Create a context JSON Map containing prefixes and definitions
			// Customize context, create an instance of JsonLdOptions with the standard JSON-LD options
			
			Map context = new HashMap();
			
			// Customize options...
			JsonLdOptions options = new JsonLdOptions(); 
			
			// Call whichever JSONLD function u want! (e.g compact)
			Object compact = JsonLdProcessor.compact(jsonObjectQuoted, context, options);
			
			
			// Print out the result ( or do not )
			System.out.println(JsonUtils.toPrettyString(compact));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
