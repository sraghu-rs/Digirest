package com.digirest.service.api;


import org.jose4j.json.internal.json_simple.JSONObject;

public interface JsonSerializable {
	public JSONObject toJson();
}
