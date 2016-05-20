package com.rupendra.solr.filter.concatenate;

import java.io.Reader;
import java.util.Map;

import org.apache.lucene.analysis.CharFilter;
import org.apache.lucene.analysis.util.CharFilterFactory;

public class WordConcatenateFilterFactory extends CharFilterFactory {

	public WordConcatenateFilterFactory(Map<String, String> args) {
		super(args);
	}

	@Override
	public CharFilter create(Reader input) {
		return new WordConcatenateFilter(input);
	}
}