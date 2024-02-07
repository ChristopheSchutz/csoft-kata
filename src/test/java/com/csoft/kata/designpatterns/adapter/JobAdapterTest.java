package com.csoft.kata.designpatterns.adapter;

import com.csoft.kata.designpatterns.adapter.distantapi.IndeedAPI;
import com.csoft.kata.designpatterns.adapter.distantapi.LinkedInAPI;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JobAdapterTest {

    private final IndeedAPI indeedAPI = () -> List.of(new IndeedAPI.IndeedJob("Indeed job 1"), new IndeedAPI.IndeedJob("Indeed job 2"));
    private final LinkedInAPI linkedInAPI = () -> List.of(new LinkedInAPI.LinkedInJob("LinkedIn job 1"), new LinkedInAPI.LinkedInJob("LinkedIn job 2"));

    @Test
    public void should_retrieve_jobs_from_adapter() {
        var indeedAPIAdapter = new IndeedAPIAdapter(indeedAPI);
        var linkedInAPIAdapter = new LinkedInAPIAdapter(linkedInAPI);
        Feed feed = new Feed(List.of(indeedAPIAdapter, linkedInAPIAdapter));

        Assertions.assertThat(feed.getJobs()).hasSize(4);
    }
}
