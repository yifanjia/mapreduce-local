package com.yifan.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class TaskReplica {
    @NonNull
    private WorkerMetaData worker;
    @NonNull
    private TaskStatus taskStatus;
}
