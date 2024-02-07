package com.csoft.kata.designpatterns.template;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TemplateTest {

    @Test
    public void testTemplate() {
        WebPageTemplate home = new HomePage();
        String homePageContent = home.display();

        WebPageTemplate profile = new ProfilePage();
        String profilePageContent = profile.display();

        Assertions.assertThat(homePageContent).isEqualTo("This is the home page !\nLorem ipsum...\n2024 All Rights reserved.");
        Assertions.assertThat(profilePageContent).isEqualTo("Logged in as super user !\nAbout me :\n2024 All Rights reserved.");
    }
}
