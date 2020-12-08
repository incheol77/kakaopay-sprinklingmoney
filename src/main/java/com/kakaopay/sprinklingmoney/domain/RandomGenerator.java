package com.kakaopay.sprinklingmoney.domain;

public class RandomGenerator {
    public static String makeRandomString(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("[size] must be a positive number.");
        }
        char[] random = new char[size];
        for (int i = 0; i < random.length; i++) {
            int position = (int)Math.floor(Math.random() * 3);
            switch(position) {
                case 0:
                    random[i] = (char) (Math.random() * 10 + '0');
                    break;
                case 1:
                    random[i] = (char) (Math.random() * 26 + 'A');
                    break;
                case 2:
                    random[i] = (char) (Math.random() * 26 + 'a');
            }
        }
        return new String(random);
    }
}
