package org.jhipster.jbookman.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class AuthorTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Author getAuthorSample1() {
        return new Author().id(1L).name("name1").website("website1").socialmedia("socialmedia1");
    }

    public static Author getAuthorSample2() {
        return new Author().id(2L).name("name2").website("website2").socialmedia("socialmedia2");
    }

    public static Author getAuthorRandomSampleGenerator() {
        return new Author()
            .id(longCount.incrementAndGet())
            .name(UUID.randomUUID().toString())
            .website(UUID.randomUUID().toString())
            .socialmedia(UUID.randomUUID().toString());
    }
}
