package com.yifan.remote;

import com.yifan.api.WorkerServiceGrpc;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class StubPairs {
    @NonNull
    private WorkerServiceGrpc.WorkerServiceBlockingStub blockingStub;
    @NonNull
    private WorkerServiceGrpc.WorkerServiceStub nonBlockingStub;
}
