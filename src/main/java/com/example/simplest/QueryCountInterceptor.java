package com.example.simplest;

import org.hibernate.EmptyInterceptor;
import org.springframework.stereotype.Component;

@Component
public class QueryCountInterceptor extends EmptyInterceptor {
    private int count;
    @Override
    public String onPrepareStatement(String sql) {
        count++;
        return super.onPrepareStatement(sql);
    }

    public int getCount() {
        return count;
    }
    public void reset() {
        count = 0;
    }
}
