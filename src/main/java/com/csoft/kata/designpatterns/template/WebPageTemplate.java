package com.csoft.kata.designpatterns.template;

public abstract class WebPageTemplate {

    public static final String LINE_BREAK = "\n";

    public final String display() {
        return displayHeader() + LINE_BREAK + displayContent() + LINE_BREAK + displayFooter();
    }

    protected abstract String displayHeader();

    protected abstract String displayContent();

    protected abstract String displayFooter();
}
