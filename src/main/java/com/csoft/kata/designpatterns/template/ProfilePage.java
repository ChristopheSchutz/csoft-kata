package com.csoft.kata.designpatterns.template;

public class ProfilePage extends WebPageTemplate {

    @Override
    protected String displayHeader() {
        return "Logged in as super user !";
    }

    @Override
    protected String displayContent() {
        return "About me :";
    }

    @Override
    protected String displayFooter() {
        return "2024 All Rights reserved.";
    }
}
