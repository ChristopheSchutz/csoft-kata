package com.csoft.kata.designpatterns.adapter.distantapi;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public interface LinkedInAPI {

    List<LinkedInJob> getJobs();

    @Getter
    @AllArgsConstructor
    class LinkedInJob {
        String content;
    }
}
