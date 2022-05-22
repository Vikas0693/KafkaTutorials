package com.crypto.translator;

import com.crypto.pojo.Tweet;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.google.cloud.translate.Translate.TranslateOption;

public class GoogleTranslator implements ITranslator {
	public Tweet translate(Tweet tweet, String targetLanguage) {
		// instantiate a client
		Translate translate = TranslateOptions.getDefaultInstance().getService();

		// translate the tweet text into the target language
		Translation translation =
				translate.translate(
						tweet.getText(),
						TranslateOption.sourceLanguage("en"),
						TranslateOption.targetLanguage(targetLanguage));

		// if you want to get real functional, clone the tweet and set the text on the new object
		tweet.setText(translation.getTranslatedText());
		return tweet;
	}
}
