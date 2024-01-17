package com.csoft.kata.adventofcraft.day07;

import com.csoft.kata.adventofcraft.day07.dependencies.Config;
import com.csoft.kata.adventofcraft.day07.dependencies.Emailer;
import com.csoft.kata.adventofcraft.day07.dependencies.Logger;

public class EmailSummarySender {
    private final Config config;
    private final Emailer emailer;
    private final Logger log;

    public EmailSummarySender(Config config, Emailer emailer, Logger log) {
        this.config = config;
        this.emailer = emailer;
        this.log = log;
    }

    public void sendEmailSummary(boolean testsPassed, boolean deploySuccessful) {
        if (config.sendEmailSummary()) {
            log.info("Sending email");
            if (testsPassed) {
                if (deploySuccessful) {
                    emailer.send("Deployment completed successfully");
                } else {
                    emailer.send("Deployment failed");
                }
            } else {
                emailer.send("Tests failed");
            }
        } else {
            log.info("Email disabled");
        }
    }
}