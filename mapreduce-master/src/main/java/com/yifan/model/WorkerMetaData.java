package com.yifan.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Objects;

@Data
@Builder
public class WorkerMetaData {
    @NonNull
    private String workerId;
    @NonNull
    private NetworkAddr networkAddr;
    private int mapTaskNum = 0;
    private int reduceTaskNum = 0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerMetaData worker = (WorkerMetaData) o;
        return Objects.equals(workerId, worker.workerId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(workerId);
    }
}
