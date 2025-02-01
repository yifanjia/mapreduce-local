package com.yifan.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Objects;

@Data
@Builder
public class TaskReplica {
    @NonNull
    private Worker worker;
    @NonNull
    private TaskStatus taskStatus;
}
