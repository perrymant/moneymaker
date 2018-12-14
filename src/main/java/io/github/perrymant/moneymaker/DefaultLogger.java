package io.github.perrymant.moneymaker;

import org.springframework.stereotype.Service;

@Service
class DefaultLogger implements Logger {
    @Override
    public void info(final String str) {
        System.out.println(str);
    }
}
