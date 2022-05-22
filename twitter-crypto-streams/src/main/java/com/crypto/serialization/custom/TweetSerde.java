package com.crypto.serialization.custom;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

import com.crypto.pojo.Tweet;

public class TweetSerde implements Serde<Tweet>{

	@Override
	public Serializer<Tweet> serializer() {
		return null;
	}

	@Override
	public Deserializer<Tweet> deserializer() {
		return new GsonDeserialization<Tweet>();
	}

}
