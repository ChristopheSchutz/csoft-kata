package com.csoft.kata.adventofcraft.day07;

import com.csoft.kata.adventofcraft.day07.dependencies.Project;

public class Pipeline {
    private final TestRunner testRunner;
    private final Deployer deployer;
    private final EmailSummarySender emailSummarySender;

    public Pipeline(TestRunner testRunner, Deployer deployer, EmailSummarySender emailSummarySender) {
        this.testRunner = testRunner;
        this.deployer = deployer;
        this.emailSummarySender = emailSummarySender;
    }

    public void run(Project project) {
        boolean testsPassed = testRunner.runTestsIfNeeded(project);
        boolean deploySuccessful = deployer.deploy(project, testsPassed);
        emailSummarySender.sendEmailSummary(testsPassed, deploySuccessful);
    }
}