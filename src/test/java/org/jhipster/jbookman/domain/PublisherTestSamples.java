package org.jhipster.jbookman.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class PublisherTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Publisher getPublisherSample1() {
        return new Publisher().id(1L).name("name1").contact("contact1").website("website1").socialmedia("socialmedia1");
    }

    public static Publisher getPublisherSample2() {
        return new Publisher().id(2L).name("name2").contact("contact2").website("website2").socialmedia("socialmedia2");
    }

    public static Publisher getPublisherRandomSampleGenerator() {
        return new Publisher()
            .id(longCount.incrementAndGet())
            .name(UUID.randomUUID().toString())
            .contact(UUID.randomUUID().toString())
            .website(UUID.randomUUID().toString())
            .socialmedia(UUID.randomUUID().toString());
    }
}
