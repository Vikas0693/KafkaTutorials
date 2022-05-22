package com.crypto;

import java.util.Properties;

import org.apache.kafka.common.serialization.Serdes.StringSerde;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppMain {

	private final static Logger LOGGER = LoggerFactory.getLogger(AppMain.class);
	public static void main(String[] args) {
		
		if(args == null) {
			LOGGER.info("Arguments passed cannot be null. Argument runs the specific version of code.");
		}
		// set the required properties for running Kafka Streams
	    Properties config = new Properties();
	    config.put(StreamsConfig.APPLICATION_ID_CONFIG, "dev");
	    config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
	    
		String version = args[0];
		if(version.equalsIgnoreCase("v1")) {
			LOGGER.info("V1 of code base will run");
			config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, StringSerde.class);
			Topology topology = Topology_V1.buildTopology();
			KafkaStreams stream = new KafkaStreams(topology, config);

			//since runnable is a functional interface & signature of runnable is similar to stream.close ,we can use double colon
			Runnable closeStream = stream::close;
			Runtime.getRuntime().addShutdownHook(new Thread(closeStream));
			
			stream.start();
		}else if(version.equalsIgnoreCase("v2")) {
			LOGGER.info("V2 of code base will run");
			Topology topology = Topology_V1.buildTopologyWithCustomSerialization();
			KafkaStreams stream = new KafkaStreams(topology, config);
			
			
			//since runnable is a functional interface & signature of runnable is similar to strea.close ,we can use double colon
			Runnable closeStream = stream::close;
			Runtime.getRuntime().addShutdownHook(new Thread(closeStream));
			
			stream.start();
		}else if(version.equalsIgnoreCase("v3")) {
			LOGGER.info("V3 of code base will run");
			Topology topology = Topology_V1.buildTopologyWithCustomSerializationAndFilter();
			KafkaStreams stream = new KafkaStreams(topology, config);
			
			
			//since runnable is a functional interface & signature of runnable is similar to strea.close ,we can use double colon
			Runnable closeStream = stream::close;
			Runtime.getRuntime().addShutdownHook(new Thread(closeStream));
			
			stream.start();
		}else if(version.equalsIgnoreCase("v4")) {
			LOGGER.info("V4 of code base will run");
			Topology topology = Topology_V1.buildTopologyWithCustomSerializationAndFilterAndBranching();
			KafkaStreams stream = new KafkaStreams(topology, config);
			
			//since runnable is a functional interface & signature of runnable is similar to stream.close ,we can use double colon
			Runnable closeStream = stream::close;
			Runtime.getRuntime().addShutdownHook(new Thread(closeStream));
			
			stream.start();
		}else if(version.equalsIgnoreCase("v5")) {
			LOGGER.info("V5 of code base will run");
			Topology topology = Topology_V1.buildTopologyWithCustomSerializationAndFilterAndBranchingAndTranslationAndMerging();
			KafkaStreams stream = new KafkaStreams(topology, config);
			
			//since runnable is a functional interface & signature of runnable is similar to stream.close ,we can use double colon
			Runnable closeStream = stream::close;
			Runtime.getRuntime().addShutdownHook(new Thread(closeStream));
			
			stream.start();
		}else if(version.equalsIgnoreCase("v6")) {
			LOGGER.info("V6 of code base will run");
			Topology topology = Topology_V1.buildTopologyWithCustomSerializationAndFilterAndBranchingAndTranslationAndMergingAndSentimentAnalysis();
			KafkaStreams stream = new KafkaStreams(topology, config);
			
			//since runnable is a functional interface & signature of runnable is similar to stream.close ,we can use double colon
			Runnable closeStream = stream::close;
			Runtime.getRuntime().addShutdownHook(new Thread(closeStream));
			
			stream.start();
		}
		else if(version.equalsIgnoreCase("v7")) {
			LOGGER.info("V7 of code base will run");
			Topology topology = Topology_V1.buildTopologyWithCustomSerializationAndFilterAndBranchingAndTranslationAndMergingAndSentimentAnalysisAndSink();
			
			KafkaStreams stream = new KafkaStreams(topology, config);
			
			//since runnable is a functional interface & signature of runnable is similar to stream.close ,we can use double colon
			Runnable closeStream = stream::close;
			Runtime.getRuntime().addShutdownHook(new Thread(closeStream));
			
			stream.start();
		}
		else {
			LOGGER.info("Arguments passed does not match the expected arguments.");
		}
	}

}
