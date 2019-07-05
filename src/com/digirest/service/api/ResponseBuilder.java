package com.digirest.service.api;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.jose4j.json.internal.json_simple.JSONArray;
import org.jose4j.json.internal.json_simple.JSONObject;

public class ResponseBuilder {
	
	public static Response createResponse( Response.Status status  ) {
		JSONObject jsonObject = new JSONObject();
		
	
			jsonObject.put( "message", status.toString() );
		
		
		return Response.status( status ).entity( jsonObject.toString() ).build();
	}
	
	public static Response createResponse( Response.Status status, String message ) {
		JSONObject jsonObject = new JSONObject();
		

			jsonObject.put( "message", message );
		
		
		return Response.status( status ).entity( jsonObject.toString() ).build();
	}
	
	public static Response createResponse( Response.Status status, JsonSerializable json ){
		return Response.status( status ).entity( json.toJson().toString() ).build();
	}
	
	public static Response createResponse( Response.Status status, Object json ) {
		return Response.status( status ).entity( json.toString() ).build();
	}
	
	public static Response createResponse( Response.Status status, List<JsonSerializable> json )  {
		
		JSONArray jsonArray = new JSONArray();
		
		for( int i = 0; i < json.size(); i++ ) {
			jsonArray.add( json.get(i).toJson() );
		}
		
		return Response.status( status ).entity( jsonArray.toString() ).build();
	}
	
	public static Response createResponse( Response.Status status, Map<String,Object> map ) {
		
		JSONObject jsonObject = new JSONObject();

			for( Map.Entry<String,Object> entry : map.entrySet() ) {
				jsonObject.put( entry.getKey(), entry.getValue() );
			}
			
			System.out.println("JSon object:"+jsonObject.toJSONString());
		
		return Response.status( status ).entity(jsonObject.toString() ).build();
	}
}
