package com.csoft.kata.adventofcraft.day07;

import com.csoft.kata.adventofcraft.day07.dependencies.Logger;
import com.csoft.kata.adventofcraft.day07.dependencies.Project;

public class Deployer {
    private final Logger log;

    public Deployer(Logger log) {
        this.log = log;
    }

    public boolean deploy(Project project, boolean testsPassed) {
        if (testsPassed) {
            if ("success".equals(project.deploy())) {
                log.info("Deployment successful");
                return true;
            } else {
                log.error("Deployment failed");
                return false;
            }
        } else {
            return false;
        }
    }
}