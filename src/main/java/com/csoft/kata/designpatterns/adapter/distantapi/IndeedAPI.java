package com.csoft.kata.designpatterns.adapter.distantapi;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public interface IndeedAPI {

    List<IndeedJob> getJobs();

    @Getter
    @AllArgsConstructor
    class IndeedJob {
        String content;
    }
}
