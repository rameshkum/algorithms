package hr.grubic.algorithms.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Charlie’s second assignment was given by the Professor as soon as he
 * submitted the first one. Professor asked Charlie to create a list of all the
 * attributes of every tag found in HTML pages.
 * 
 * <p>
 * This is a paragraph
 * </p>
 * 
 * The above HTML string has p as its tag but no attributes.
 * 
 * <a href="http://www.hackerrank.com">HackerRank</a>
 * 
 * This string has a as a tag and href as an attribute.
 * 
 * Input Format
 * 
 * The first line contains N, the number of lines in the HTML fragment. This is
 * followed by lines from a valid HTML document or fragment.
 * 
 * Constraints
 * 
 * Number of characters in the test fragments <= 10000 characters. Characters
 * will be restricted to ASCII. Fragments for the tests will be picked up from
 * Wikipedia. Attributes are all lowercase alphabets.
 * 
 * Output Format
 * 
 * Each tag must be separated by a newline arranged in lexicographic order Each
 * attribute noted for a given tag must be arranged next to a tag in
 * lexicographic order.
 * 
 * The output will be of the format
 * 
 * tag-1:attribute-1,attribute-2,attribute-3....
 * tag-2:attribute-1,attribute-2,attribute-3....
 * tag-3:attribute-1,attribute-2,attribute-3.... ...
 * tag-n:attribute-1,attribute-2,attribute-3....
 * 
 * Where tag-1 is lexicographically smaller than tag-2 and attribute-1 is
 * lexicographically smaller than attribute-2
 * 
 * Sample Input:1
 * 
 * 2
 * <p>
 * <a href="http://www.quackit.com/html/tutorial/html_links.cfm">Example
 * Link</a>
 * </p>
 * <div class="more-info"><a
 * href="http://www.quackit.com/html/examples/html_links_examples.cfm">More Link
 * Examples...</a></div>
 * 
 * @author majagrubic
 * 
 */
public class HTMLParse {

	private enum State {
		TAG, ATTRIBUTE, OPENTAG, // <
		CLOSEDTAG, // >
		CLOSINGTAG, // /
		OTHER, ERROR
	}

	private static final char OPENING_TAG = '<';
	private static final char CLOSING_TAG = '>';
	private static final char SPACE = ' ';
	private static final char BACKSLASH = '/';
	private static final char SINGLE_QUOTE = '\'';
	private static final char DOUBLE_QUOTE ='\"';

	static Map<String, TreeSet<String>> tagsAndAttributes = new TreeMap<String, TreeSet<String>>();
	static int i;

	public static void parseLine(String htmlLine) {
		if (htmlLine == null || htmlLine.length() == 0
				|| !htmlLine.startsWith("<")) {
			return;
		}
		i = 0;
		State state = State.OPENTAG;
		String currentTag = null;
		while (i < htmlLine.length()) {
			if (state == State.OPENTAG) {
				i++;
				if (htmlLine.charAt(i) == BACKSLASH) {
					state = State.CLOSINGTAG;
					continue;
				}
				String tag = getAttributeOrTag(htmlLine, CLOSING_TAG, SPACE);
				if (!tagsAndAttributes.containsKey(tag)) {
					tagsAndAttributes.put(tag, new TreeSet<String>());
				}
				while (i < htmlLine.length() && htmlLine.charAt(i) == SPACE)
					i++;
				if (htmlLine.charAt(i) == CLOSING_TAG) {
					state = State.CLOSEDTAG;
					continue;
				}
				currentTag = tag.toString();
				state = State.ATTRIBUTE;
			} else if (state == State.CLOSINGTAG) {
				state = getNextStateFromClosedClosing(state, htmlLine);
			} else if (state == State.CLOSEDTAG) {
				state = getNextStateFromClosedClosing(state, htmlLine);
			} else if (state == State.ATTRIBUTE) {
				String attribute = getAttributeOrTag(htmlLine, '=');
				tagsAndAttributes.get(currentTag).add(attribute);
				state = State.OTHER;
			} else if (state == State.OTHER) {
				i += 2;
				while (i < htmlLine.length()) {
					if (htmlLine.charAt(i) == SINGLE_QUOTE
							|| htmlLine.charAt(i) == DOUBLE_QUOTE)
						break;
					i++;
				}
				state = getNextStateFromOther(htmlLine);
			}
		}
	}

	private static State getNextStateFromClosedClosing(State current,
			String htmlLine) {
		while (i < htmlLine.length()) {
			if (current == State.CLOSINGTAG
					&& htmlLine.charAt(i) == CLOSING_TAG) {
				return State.CLOSEDTAG;
			}
			if (current == State.CLOSEDTAG && htmlLine.charAt(i) == OPENING_TAG) {
				return State.OPENTAG;
			}
			i++;
		}
		return State.ERROR;
	}

	private static String getAttributeOrTag(String htmlLine, char... delimiters) {

		StringBuilder tagOrAttribute = new StringBuilder();
		while (i < htmlLine.length()) {
			if (isInArray(htmlLine.charAt(i), delimiters))
				break;
			tagOrAttribute.append(htmlLine.charAt(i));
			i++;
		}
		return tagOrAttribute.toString();
	}

	private static boolean isInArray(char c, char... delimiters) {
		for (char d : delimiters) {
			if (c == d)
				return true;
		}
		return false;
	}

	private static State getNextStateFromOther(String htmlLine) {
		if (i > htmlLine.length()) {
			return State.ERROR;
		}

		i++;
		while (i < htmlLine.length() && htmlLine.charAt(i) == SPACE)
			i++;
		if (isLetter(htmlLine.charAt(i))) {
			return State.ATTRIBUTE;
		}
		if (htmlLine.charAt(i) == '/') {
			return State.CLOSINGTAG;
		}
		if (htmlLine.charAt(i) == CLOSING_TAG) {
			return State.CLOSEDTAG;
		}
		return State.ERROR;
	}

	private static void print() {
		StringBuilder output = new StringBuilder();
		for (Map.Entry<String, TreeSet<String>> entry : tagsAndAttributes
				.entrySet()) {
			output.append(entry.getKey()).append(":");
			int size = entry.getValue().size();
			int k = 0;
			for (String attribute : entry.getValue()) {
				output.append(attribute);
				if (k + 1 != size)
					output.append(",");
				k++;
			}
			output.append("\n");

		}
		System.out.println(output.toString());
	}

	private static boolean isLetter(char c) {
		return c >= 'a' && c <= 'z';
	}

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line = reader.readLine();
		int n = Integer.parseInt(line);
		for (int i = 0; i < n; i++) {
			line = reader.readLine();
			parseLine(line);
		}
		print();
	}
}
