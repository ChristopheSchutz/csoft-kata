package com.csoft.kata.designpatterns.adapter;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public interface JobAPI {

    List<Job> getJobs();

    @Getter
    @AllArgsConstructor
    class Job {
        private String content;
    }
}
