package com.csoft.kata.designpatterns.adapter;

import com.csoft.kata.designpatterns.adapter.distantapi.LinkedInAPI;

import java.util.List;

public class LinkedInAPIAdapter implements JobAPI {
    private LinkedInAPI linkedInAPI;

    public LinkedInAPIAdapter(LinkedInAPI linkedInAPI) {
        this.linkedInAPI = linkedInAPI;
    }

    @Override
    public List<Job> getJobs() {
        return linkedInAPI.getJobs().stream()
                .map(linkedJob -> new Job(linkedJob.getContent()))
                .toList();
    }
}
