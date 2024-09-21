package org.jhipster.jbookman.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class CurrencyTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static Currency getCurrencySample1() {
        return new Currency().id(1L).alphabeticcode("alphabeticcode1").numericcode(1).name("name1").minorunit(1);
    }

    public static Currency getCurrencySample2() {
        return new Currency().id(2L).alphabeticcode("alphabeticcode2").numericcode(2).name("name2").minorunit(2);
    }

    public static Currency getCurrencyRandomSampleGenerator() {
        return new Currency()
            .id(longCount.incrementAndGet())
            .alphabeticcode(UUID.randomUUID().toString())
            .numericcode(intCount.incrementAndGet())
            .name(UUID.randomUUID().toString())
            .minorunit(intCount.incrementAndGet());
    }
}
