package com.csoft.kata.designpatterns.adapter;

import com.csoft.kata.designpatterns.adapter.distantapi.IndeedAPI;

import java.util.List;

public class IndeedAPIAdapter implements JobAPI {
    private IndeedAPI indeedAPI;

    public IndeedAPIAdapter(IndeedAPI indeedAPI) {
        this.indeedAPI = indeedAPI;
    }

    @Override
    public List<Job> getJobs() {
        return indeedAPI.getJobs().stream()
                .map(indeedJob -> new Job(indeedJob.getContent()))
                .toList();
    }
}
