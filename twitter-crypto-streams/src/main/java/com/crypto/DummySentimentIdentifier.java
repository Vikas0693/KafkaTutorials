package com.crypto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.crypto.pojo.Tweet;
import com.crypto.schema.avro.EntitySentiment;

public class DummySentimentIdentifier {

	public List<EntitySentiment> getEntitySentimentsFromRecords(Tweet tweet) {
		EntitySentiment es = new EntitySentiment();
		es.setEntity("bitcoin");
		es.setCreatedAt(tweet.getCreatedAt());
		es.setId(tweet.getId());
		es.setSentimentScore(.69);
		es.setSentimentMagnitude(.69);
		es.setSalience(.47);
		es.setText(tweet.getText());
		
		EntitySentiment es1 = new EntitySentiment();
		es1.setEntity("ethereum");
		es1.setCreatedAt(tweet.getCreatedAt());
		es1.setId(tweet.getId());
		es1.setSentimentScore(-.2);
		es1.setSentimentMagnitude(-.2);
		es1.setSalience(.03);
		es1.setText(tweet.getText());
		
		List<EntitySentiment> list = new ArrayList();
		if(tweet.getText().toLowerCase().contains("bitcoin"))
			list.add(es);
		if(tweet.getText().toLowerCase().contains("ethereum"))
			list.add(es1);
		return list;
	}
}
