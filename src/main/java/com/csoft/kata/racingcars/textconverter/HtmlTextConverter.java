package com.csoft.kata.racingcars.textconverter;

import java.io.BufferedReader;
import java.io.IOException;

public class HtmlTextConverter
{
    private BufferedReader reader;

    public HtmlTextConverter(BufferedReader reader)
    {
        this.reader = reader;
    }

    public String convertToHtml() throws IOException{

	    String line = reader.readLine();
	    String html = "";
	    while (line != null)
	    {
	    	html += StringEscapeUtils.escapeHtml(line);
	        html += "<br />";
	        line = reader.readLine();
	    }
	    return html;

    }
}