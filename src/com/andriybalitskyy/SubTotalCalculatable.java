package com.andriybalitskyy;

public interface SubTotalCalculatable<T> {

    T calculate(Input input, T t);
}