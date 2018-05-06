package com.learncamel.transform.aggregator;

import org.apache.camel.Exchange;

public class AggregatorPredicateStrategy implements org.apache.camel.processor.aggregate.AggregationStrategy {
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        return newExchange;
    }
}
