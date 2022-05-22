package com.crypto.translator;

import com.crypto.pojo.Tweet;

public interface ITranslator {
	public Tweet translate(Tweet tweet, String targetLanguage);
}
