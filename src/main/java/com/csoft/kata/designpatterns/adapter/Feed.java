package com.csoft.kata.designpatterns.adapter;

import java.util.List;

public class Feed {

    private final List<JobAPI> jobAPIs;

    public Feed(List<JobAPI> jobAPIs) {
        this.jobAPIs = jobAPIs;
    }

    public List<JobAPI.Job> getJobs() {
        return jobAPIs.stream()
                .map(JobAPI::getJobs)
                .flatMap(List::stream).toList();
    }

}
