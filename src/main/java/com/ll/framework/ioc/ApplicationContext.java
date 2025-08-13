package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestFacadePostService;
import com.ll.domain.testPost.testPost.service.TestPostService;

public class ApplicationContext {
    private static TestPostService testPostService;
    private static TestPostRepository testPostRepository;
    private static TestFacadePostService testFacadePostService;

    public ApplicationContext() {
        testPostRepository = new TestPostRepository();
        testPostService = new TestPostService(testPostRepository);
        testFacadePostService = new TestFacadePostService(testPostService, testPostRepository);
    }

    public <T> T genBean(String beanName) {
        if (beanName.equals("testPostService")) {
            return (T) testPostService;
        } else if (beanName.equals("testPostRepository")) {
            return (T) testPostRepository;
        } else if (beanName.equals("testFacadePostService")) {
            return (T) testFacadePostService;
        }
        return (T) null;
    }
}
