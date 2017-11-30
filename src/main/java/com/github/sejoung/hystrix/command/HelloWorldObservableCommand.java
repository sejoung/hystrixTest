package com.github.sejoung.hystrix.command;

import com.github.sejoung.hystrix.constants.CommonConstants;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;

public class HelloWorldObservableCommand extends HystrixObservableCommand<String> {

    private String name;

    public HelloWorldObservableCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey(CommonConstants.COMMAND_GROUP));
        this.name = name;
    }

    @Override
    protected Observable<String> resumeWithFallback() {
        return Observable.just("Returning a Fallback");
    }

    @Override
    protected Observable<String> construct() {
        return Observable.just("Hello" + this.name);
    }

}
