package com.test.controller;

public class Demo2 {
	
	boolean inComment;
	
	public static void main(String[] args) {
		Demo2 d = new Demo2();
		
		String s1 = "<property name=\"password\" value=\"123456\"><!-- hello --></property>";
		String s2 = "<!-- hello --><property name=\"password\" value=\"123456\"></property>";
		String s3 = "<property name=\"password\" value=\"123456\"></property><!-- hello -->";
		String s4 = "<property name=\"password\" value=\"123456\"></property><!-- hello";
//		String s = d.consume("<property name=\"password\" value=\"123456\"><!-- hello --></property>");
		String s = d.consumeCommentTokens(s1);
		System.out.println(d.inComment);
		System.out.println(s);
	}
	
	private String consumeCommentTokens(String line) {
		if (!line.contains("<!--") && !line.contains("-->")) {
			return line;
		}
		while ((line = consume(line)) != null) {
			if (!this.inComment && !line.trim().startsWith("<!--")) {
				return line;
			}
		}
		return line;
	}

	private String consume(String line) {
		int index = (this.inComment ? endComment(line) : startComment(line));
		return (index == -1 ? null : line.substring(index));
	}

	/**
	 * Try to consume the {@link #START_COMMENT} token.
	 * @see #commentToken(String, String, boolean)
	 */
	private int startComment(String line) {
		return commentToken(line, "<!--", true);
	}

	private int endComment(String line) {
		return commentToken(line, "-->", false);
	}

	/**
	 * Try to consume the supplied token against the supplied content and update the
	 * in comment parse state to the supplied value. Returns the index into the content
	 * which is after the token or -1 if the token is not found.
	 */
	private int commentToken(String line, String token, boolean inCommentIfPresent) {
		int index = line.indexOf(token);
		if (index > - 1) {
			this.inComment = inCommentIfPresent;
		}
		return (index == -1 ? index : index + token.length());
	}
}
