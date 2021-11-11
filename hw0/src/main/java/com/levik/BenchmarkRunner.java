package com.levik;

import org.openjdk.jmh.annotations.Benchmark;

public class BenchmarkRunner {

    @Benchmark
    public void init() {
        // Do nothing
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}
