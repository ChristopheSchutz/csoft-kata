package com.csoft.kata.racingcars.textconverter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class HtmlTextConverterTest {

    @Test
    public void should_convert() throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader("line1\nline2"));
        HtmlTextConverter converter = new HtmlTextConverter(reader);
        assertEquals("line1<br />line2<br />", converter.convertToHtml());
    }

}