package com.easysoft.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class DeferredQueueService {
    private Queue<DeferredResult<Object>> queue = new ConcurrentLinkedQueue<DeferredResult<Object>>();

    public void add(DeferredResult<Object> deferredResult) {
        queue.add(deferredResult);
    }

    public DeferredResult<Object> poll() {
        return queue.poll();
    }
}
