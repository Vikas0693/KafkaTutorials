package com.crypto;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Predicate;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;

import com.crypto.pojo.Tweet;
import com.crypto.schema.avro.EntitySentiment;
import com.crypto.serialization.custom.TweetSerde;
import com.crypto.translator.DummyTranslator;
import com.crypto.translator.GoogleTranslator;
import com.crypto.translator.ITranslator;
import com.google.gson.Gson;

public class Topology_V1 {
	
	public static Topology buildTopology() {
		StreamsBuilder builder = new StreamsBuilder();
		
		KStream<byte[], byte[]> stream = builder.stream("tweets");
		//log stream
		stream.print(Printed.<byte[], byte[]>toSysOut().withLabel("tweets-stream"));
		
		Topology topology = builder.build();
		return topology;
	}
	
	public static Topology buildTopologyWithCustomSerialization() {
		StreamsBuilder builder = new StreamsBuilder();
		
		KStream<byte[], Tweet> stream = builder.stream("tweets", Consumed.with(Serdes.ByteArray(), new TweetSerde()));
		
		//log stream
		stream.print(Printed.<byte[], Tweet>toSysOut().withLabel("tweets-stream"));
		
		Topology topology = builder.build();
		return topology;
	}
	
	public static Topology buildTopologyWithCustomSerializationAndFilter() {
		StreamsBuilder builder = new StreamsBuilder();
		
		KStream<byte[], Tweet> stream = builder.stream("tweets", Consumed.with(Serdes.ByteArray(), new TweetSerde()));
		
		KStream<byte[], Tweet> streamFiltered = stream.filter((key, value)->{
			return !value.getRetweet();
		});
		
//		streamFiltered = stream.filterNot((key, value)->{
//			return value.getRetweet();
//		});
		
		//log stream
		streamFiltered.print(Printed.<byte[], Tweet>toSysOut().withLabel("tweets-stream"));
		
		Topology topology = builder.build();
		return topology;
	}
	
	public static Topology buildTopologyWithCustomSerializationAndFilterAndBranching() {
		StreamsBuilder builder = new StreamsBuilder();
		
		KStream<byte[], Tweet> stream = builder.stream("tweets", Consumed.with(Serdes.ByteArray(), new TweetSerde()));
		
		KStream<byte[], Tweet> streamFiltered = stream.filter((key, value)->{
			return !value.getRetweet();
		});
		
		Predicate<byte[], Tweet> englishTweet = (key, tweet)-> tweet.getLang().equals("en");
		Predicate<byte[], Tweet> nonEnglishTweet = (key, tweet)-> !tweet.getLang().equals("en");
		
		KStream<byte[], Tweet> branch[] = streamFiltered.branch(englishTweet, nonEnglishTweet);
		
		KStream<byte[], Tweet> englishBranch = branch[0];
		KStream<byte[], Tweet> nonEnglishBranch = branch[1];
		
		//log stream
		englishBranch.print(Printed.<byte[], Tweet>toSysOut().withLabel("tweets-stream-english"));
		nonEnglishBranch.print(Printed.<byte[], Tweet>toSysOut().withLabel("tweets-stream-nonenglish"));
		
		Topology topology = builder.build();
		return topology;
	}
	
	public static Topology buildTopologyWithCustomSerializationAndFilterAndBranchingAndTranslationAndMerging() {
		StreamsBuilder builder = new StreamsBuilder();
		
		KStream<byte[], Tweet> stream = builder.stream("tweets", Consumed.with(Serdes.ByteArray(), new TweetSerde()));
		
		KStream<byte[], Tweet> streamFiltered = stream.filter((key, value)->{
			return !value.getRetweet();
		});
		
		Predicate<byte[], Tweet> englishTweet = (key, tweet)-> tweet.getLang().equals("en");
		Predicate<byte[], Tweet> nonEnglishTweet = (key, tweet)-> !tweet.getLang().equals("en");
		
		KStream<byte[], Tweet> branch[] = streamFiltered.branch(englishTweet, nonEnglishTweet);
		
		KStream<byte[], Tweet> englishBranch = branch[0];
		KStream<byte[], Tweet> nonEnglishBranch = branch[1];
		
		//log stream
		englishBranch.print(Printed.<byte[], Tweet>toSysOut().withLabel("tweets-stream-english"));
		nonEnglishBranch.print(Printed.<byte[], Tweet>toSysOut().withLabel("tweets-stream-nonenglish"));
		
		ITranslator translator = new DummyTranslator();
		//translate non english to english using google translator
		KStream<byte[], Tweet> translatedTweets = nonEnglishBranch.mapValues((record) -> {return translator.translate(record, "en");});
		
		//log stream
		translatedTweets.print(Printed.<byte[], Tweet>toSysOut().withLabel("tweets-translated-to-english"));
		
		KStream<byte[], Tweet> mergedStream = englishBranch.merge(translatedTweets);
		
		//log stream
		mergedStream.print(Printed.<byte[], Tweet>toSysOut().withLabel("tweets-merged"));
		
		Topology topology = builder.build();
		return topology;
	}
	
	public static Topology buildTopologyWithCustomSerializationAndFilterAndBranchingAndTranslationAndMergingAndSentimentAnalysis() {
		StreamsBuilder builder = new StreamsBuilder();
		
		KStream<byte[], Tweet> stream = builder.stream("tweets", Consumed.with(Serdes.ByteArray(), new TweetSerde()));
		
		KStream<byte[], Tweet> streamFiltered = stream.filter((key, value)->{
			return !value.getRetweet();
		});
		
		Predicate<byte[], Tweet> englishTweet = (key, tweet)-> tweet.getLang().equals("en");
		Predicate<byte[], Tweet> nonEnglishTweet = (key, tweet)-> !tweet.getLang().equals("en");
		
		KStream<byte[], Tweet> branch[] = streamFiltered.branch(englishTweet, nonEnglishTweet);
		
		KStream<byte[], Tweet> englishBranch = branch[0];
		KStream<byte[], Tweet> nonEnglishBranch = branch[1];
		
		//log stream
		englishBranch.print(Printed.<byte[], Tweet>toSysOut().withLabel("tweets-stream-english"));
		nonEnglishBranch.print(Printed.<byte[], Tweet>toSysOut().withLabel("tweets-stream-nonenglish"));
		
		ITranslator translator = new DummyTranslator();
		//translate non english to english using google translator
		KStream<byte[], Tweet> translatedTweets = nonEnglishBranch.mapValues((record) -> {return translator.translate(record, "en");});
		
		//log stream
		translatedTweets.print(Printed.<byte[], Tweet>toSysOut().withLabel("tweets-translated-to-english"));
		
		KStream<byte[], Tweet> mergedStream = englishBranch.merge(translatedTweets);
		
		//log stream
		mergedStream.print(Printed.<byte[], Tweet>toSysOut().withLabel("tweets-merged"));
		
		DummySentimentIdentifier di = new DummySentimentIdentifier();
		List<String> currencies = Collections.unmodifiableList(Arrays.asList("bitcoin","ethereum","dogicoin"));
		KStream<byte[], EntitySentiment> getSentimentWiseRecords = mergedStream.flatMapValues((tweet) -> {
			List<EntitySentiment> list = di.getEntitySentimentsFromRecords(tweet);
			
			list.removeIf(entitySentiment -> !currencies.contains(entitySentiment.getEntity()));
			return list;
		});
		
		//log stream
		getSentimentWiseRecords.print(Printed.<byte[], EntitySentiment>toSysOut().withLabel("Entity-Sentiment"));
		
		Topology topology = builder.build();
		return topology;
	}
	
	public static Topology buildTopologyWithCustomSerializationAndFilterAndBranchingAndTranslationAndMergingAndSentimentAnalysisAndSink() {
		StreamsBuilder builder = new StreamsBuilder();
		
		KStream<byte[], Tweet> stream = builder.stream("tweets", Consumed.with(Serdes.ByteArray(), new TweetSerde()));
		
		KStream<byte[], Tweet> streamFiltered = stream.filter((key, value)->{
			return !value.getRetweet();
		});
		
		Predicate<byte[], Tweet> englishTweet = (key, tweet)-> tweet.getLang().equals("en");
		Predicate<byte[], Tweet> nonEnglishTweet = (key, tweet)-> !tweet.getLang().equals("en");
		
		KStream<byte[], Tweet> branch[] = streamFiltered.branch(englishTweet, nonEnglishTweet);
		
		KStream<byte[], Tweet> englishBranch = branch[0];
		KStream<byte[], Tweet> nonEnglishBranch = branch[1];
		
		//log stream
		englishBranch.print(Printed.<byte[], Tweet>toSysOut().withLabel("tweets-stream-english"));
		nonEnglishBranch.print(Printed.<byte[], Tweet>toSysOut().withLabel("tweets-stream-nonenglish"));
		
		ITranslator translator = new DummyTranslator();
		//translate non english to english using google translator
		KStream<byte[], Tweet> translatedTweets = nonEnglishBranch.mapValues((record) -> {return translator.translate(record, "en");});
		
		//log stream
		translatedTweets.print(Printed.<byte[], Tweet>toSysOut().withLabel("tweets-translated-to-english"));
		
		KStream<byte[], Tweet> mergedStream = englishBranch.merge(translatedTweets);
		
		//log stream
		mergedStream.print(Printed.<byte[], Tweet>toSysOut().withLabel("tweets-merged"));
		
		DummySentimentIdentifier di = new DummySentimentIdentifier();
		List<String> currencies = Collections.unmodifiableList(Arrays.asList("bitcoin","ethereum","dogicoin"));
		KStream<byte[], EntitySentiment> getSentimentWiseRecords = mergedStream.flatMapValues((tweet) -> {
			List<EntitySentiment> list = di.getEntitySentimentsFromRecords(tweet);
			
			list.removeIf(entitySentiment -> !currencies.contains(entitySentiment.getEntity()));
			return list;
		});
		
		//log stream
		getSentimentWiseRecords.print(Printed.<byte[], EntitySentiment>toSysOut().withLabel("Entity-Sentiment"));
		
		//pushing records to crypto-sentiment
		//avro serde was not working hence converted entitysentiment to json only
		//Serde<EntitySentiment> avroSerde = AvroSerdes.get(EntitySentiment.class);
		Serde<EntitySentiment> entitySentimentJsonSerde = new Serde<EntitySentiment>() {
			@Override
			public Serializer<EntitySentiment> serializer() {
				return new Serializer<EntitySentiment>() {

					@Override
					public byte[] serialize(String topic, EntitySentiment data) {
						Gson gson = new Gson();
						String jsonFormatOfData = gson.toJson(data);
						byte[] byteData = jsonFormatOfData.getBytes(StandardCharsets.UTF_8);
						return byteData;
					}
					
				};
			}

			@Override
			public Deserializer<EntitySentiment> deserializer() {
				System.err.println("RAN deserialization for crypto-sentiment.");
				//We dont need deserialization here
				return null;
			}
		};
		getSentimentWiseRecords.to("crypto-sentiment", Produced.with(Serdes.ByteArray(), entitySentimentJsonSerde));
		
		Topology topology = builder.build();
		return topology;
	}
}
