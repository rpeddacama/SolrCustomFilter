package com.rupendra.solr.filter.concatenate;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.apache.lucene.analysis.charfilter.BaseCharFilter;

public class WordConcatenateFilter extends BaseCharFilter {

	private Reader transformedInput;

	public WordConcatenateFilter(Reader in) {
		super(in);
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		// Buffer all input on the first call.
		if (transformedInput == null) {
			fill();
		}

		return transformedInput.read(cbuf, off, len);
	}

	private void fill() throws IOException {
		StringBuilder buffered = new StringBuilder();
		char [] temp = new char [1024];
		for (int cnt = input.read(temp); cnt > 0; cnt = input.read(temp)) {
			buffered.append(temp, 0, cnt);
		}
		//transformedInput = new StringReader("rup");
		transformedInput = new StringReader(buffered.toString()+" "+buffered.toString().replaceAll("\\s", ""));
	}

	@Override
	public int read() throws IOException {
		if (transformedInput == null) {
			fill();
		}

		return transformedInput.read();
	}

	@Override
	protected int correct(int currentOff) {
		return Math.max(0,  super.correct(currentOff));
	}

}