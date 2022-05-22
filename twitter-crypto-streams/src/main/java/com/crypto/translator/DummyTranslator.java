package com.crypto.translator;

import com.crypto.pojo.Tweet;

public class DummyTranslator implements ITranslator {

	@Override
	public Tweet translate(Tweet tweet, String targetLanguage) {
		tweet.setText("Translated to "+targetLanguage+":"+tweet.getText());
		return tweet;
	}

}
