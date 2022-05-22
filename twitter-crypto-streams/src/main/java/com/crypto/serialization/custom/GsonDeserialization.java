package com.crypto.serialization.custom;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

import org.apache.kafka.common.serialization.Deserializer;

import com.crypto.pojo.Tweet;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GsonDeserialization<T> implements Deserializer<T> {
	
	private Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
	
	@Override
	public T deserialize(String topic, byte[] data) {

		if(data == null)
			return null;
		Type type = new TypeToken<Tweet>() {}.getType();
		T tweet = gson.fromJson(new String(data, StandardCharsets.UTF_8),  type);
		return tweet;
	}

}
