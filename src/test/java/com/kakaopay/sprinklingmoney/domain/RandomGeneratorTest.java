package com.kakaopay.sprinklingmoney.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomGeneratorTest {

    @Test
    public void test() throws Exception {
        int randomSize = 3;
        for (int i = 0; i < 9; i++) {
            String randomString = RandomGenerator.makeRandomString(randomSize);
            System.out.println(randomString);
        }
    }
}