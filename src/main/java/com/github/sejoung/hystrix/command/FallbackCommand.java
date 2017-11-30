package com.github.sejoung.hystrix.command;

import com.github.sejoung.hystrix.constants.CommonConstants;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FallbackCommand extends HystrixCommand<String> {

    private static final Logger logger = LoggerFactory.getLogger(FallbackCommand.class);

    public FallbackCommand() {
        super(HystrixCommandGroupKey.Factory.asKey(CommonConstants.COMMAND_GROUP));
    }

    @Override
    protected String run() throws Exception {
        throw new RuntimeException("Always fail");
    }

    @Override
    protected String getFallback() {
        logger.info("About to fallback");
        return "Falling back";
    }

}