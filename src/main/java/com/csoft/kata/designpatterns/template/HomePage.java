package com.csoft.kata.designpatterns.template;

public class HomePage extends WebPageTemplate {

    @Override
    protected String displayHeader() {
        return "This is the home page !";
    }

    @Override
    protected String displayContent() {
        return "Lorem ipsum...";
    }

    @Override
    protected String displayFooter() {
        return "2024 All Rights reserved.";
    }
}
