package com.laptrinhjavawed.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtils {
	private String value=null;
	public HttpUtils(String value) {
		this.value=value;
	}
	public 	<T> T toModel(Class<T> tModel) {
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			return objectMapper.readValue(value, tModel);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static HttpUtils of(BufferedReader reader) {
		StringBuilder result = new StringBuilder();
		String line;
		try {
			while((line=reader.readLine())!=null) {
				result.append(line);
			}
			return new HttpUtils(result.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
