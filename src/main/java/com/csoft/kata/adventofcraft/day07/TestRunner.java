package com.csoft.kata.adventofcraft.day07;

import com.csoft.kata.adventofcraft.day07.dependencies.Logger;
import com.csoft.kata.adventofcraft.day07.dependencies.Project;

public class TestRunner {
    private final Logger log;

    public TestRunner(Logger log) {
        this.log = log;
    }

    public boolean runTestsIfNeeded(Project project) {
        if (project.hasTests()) {
            return runTests(project);
        } else {
            log.info("No tests");
            return true;
        }
    }

    private boolean runTests(Project project) {
        if ("success".equals(project.runTests())) {
            log.info("Tests passed");
            return true;
        } else {
            log.error("Tests failed");
            return false;
        }
    }
}