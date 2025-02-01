package com.yifan.api;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.70.0)",
    comments = "Source: worker.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WorkerServiceGrpc {

  private WorkerServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "WorkerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.yifan.api.Worker.FileChunk,
      com.yifan.api.Worker.UploadStatus> getUploadFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "uploadFile",
      requestType = com.yifan.api.Worker.FileChunk.class,
      responseType = com.yifan.api.Worker.UploadStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.yifan.api.Worker.FileChunk,
      com.yifan.api.Worker.UploadStatus> getUploadFileMethod() {
    io.grpc.MethodDescriptor<com.yifan.api.Worker.FileChunk, com.yifan.api.Worker.UploadStatus> getUploadFileMethod;
    if ((getUploadFileMethod = WorkerServiceGrpc.getUploadFileMethod) == null) {
      synchronized (WorkerServiceGrpc.class) {
        if ((getUploadFileMethod = WorkerServiceGrpc.getUploadFileMethod) == null) {
          WorkerServiceGrpc.getUploadFileMethod = getUploadFileMethod =
              io.grpc.MethodDescriptor.<com.yifan.api.Worker.FileChunk, com.yifan.api.Worker.UploadStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "uploadFile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yifan.api.Worker.FileChunk.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yifan.api.Worker.UploadStatus.getDefaultInstance()))
              .setSchemaDescriptor(new WorkerServiceMethodDescriptorSupplier("uploadFile"))
              .build();
        }
      }
    }
    return getUploadFileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.yifan.api.Worker.Empty,
      com.yifan.api.Worker.HeartbeatResponse> getHeartbeatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "heartbeat",
      requestType = com.yifan.api.Worker.Empty.class,
      responseType = com.yifan.api.Worker.HeartbeatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.yifan.api.Worker.Empty,
      com.yifan.api.Worker.HeartbeatResponse> getHeartbeatMethod() {
    io.grpc.MethodDescriptor<com.yifan.api.Worker.Empty, com.yifan.api.Worker.HeartbeatResponse> getHeartbeatMethod;
    if ((getHeartbeatMethod = WorkerServiceGrpc.getHeartbeatMethod) == null) {
      synchronized (WorkerServiceGrpc.class) {
        if ((getHeartbeatMethod = WorkerServiceGrpc.getHeartbeatMethod) == null) {
          WorkerServiceGrpc.getHeartbeatMethod = getHeartbeatMethod =
              io.grpc.MethodDescriptor.<com.yifan.api.Worker.Empty, com.yifan.api.Worker.HeartbeatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "heartbeat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yifan.api.Worker.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yifan.api.Worker.HeartbeatResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WorkerServiceMethodDescriptorSupplier("heartbeat"))
              .build();
        }
      }
    }
    return getHeartbeatMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WorkerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkerServiceStub>() {
        @java.lang.Override
        public WorkerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkerServiceStub(channel, callOptions);
        }
      };
    return WorkerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static WorkerServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkerServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkerServiceBlockingV2Stub>() {
        @java.lang.Override
        public WorkerServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkerServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return WorkerServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WorkerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkerServiceBlockingStub>() {
        @java.lang.Override
        public WorkerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkerServiceBlockingStub(channel, callOptions);
        }
      };
    return WorkerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WorkerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkerServiceFutureStub>() {
        @java.lang.Override
        public WorkerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkerServiceFutureStub(channel, callOptions);
        }
      };
    return WorkerServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default io.grpc.stub.StreamObserver<com.yifan.api.Worker.FileChunk> uploadFile(
        io.grpc.stub.StreamObserver<com.yifan.api.Worker.UploadStatus> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getUploadFileMethod(), responseObserver);
    }

    /**
     */
    default void heartbeat(com.yifan.api.Worker.Empty request,
        io.grpc.stub.StreamObserver<com.yifan.api.Worker.HeartbeatResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHeartbeatMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service WorkerService.
   */
  public static abstract class WorkerServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return WorkerServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service WorkerService.
   */
  public static final class WorkerServiceStub
      extends io.grpc.stub.AbstractAsyncStub<WorkerServiceStub> {
    private WorkerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkerServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.yifan.api.Worker.FileChunk> uploadFile(
        io.grpc.stub.StreamObserver<com.yifan.api.Worker.UploadStatus> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getUploadFileMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void heartbeat(com.yifan.api.Worker.Empty request,
        io.grpc.stub.StreamObserver<com.yifan.api.Worker.HeartbeatResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHeartbeatMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service WorkerService.
   */
  public static final class WorkerServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<WorkerServiceBlockingV2Stub> {
    private WorkerServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkerServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkerServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<com.yifan.api.Worker.FileChunk, com.yifan.api.Worker.UploadStatus>
        uploadFile() {
      return io.grpc.stub.ClientCalls.blockingClientStreamingCall(
          getChannel(), getUploadFileMethod(), getCallOptions());
    }

    /**
     */
    public com.yifan.api.Worker.HeartbeatResponse heartbeat(com.yifan.api.Worker.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHeartbeatMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service WorkerService.
   */
  public static final class WorkerServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WorkerServiceBlockingStub> {
    private WorkerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.yifan.api.Worker.HeartbeatResponse heartbeat(com.yifan.api.Worker.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHeartbeatMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service WorkerService.
   */
  public static final class WorkerServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<WorkerServiceFutureStub> {
    private WorkerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.yifan.api.Worker.HeartbeatResponse> heartbeat(
        com.yifan.api.Worker.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHeartbeatMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HEARTBEAT = 0;
  private static final int METHODID_UPLOAD_FILE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HEARTBEAT:
          serviceImpl.heartbeat((com.yifan.api.Worker.Empty) request,
              (io.grpc.stub.StreamObserver<com.yifan.api.Worker.HeartbeatResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPLOAD_FILE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.uploadFile(
              (io.grpc.stub.StreamObserver<com.yifan.api.Worker.UploadStatus>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getUploadFileMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.yifan.api.Worker.FileChunk,
              com.yifan.api.Worker.UploadStatus>(
                service, METHODID_UPLOAD_FILE)))
        .addMethod(
          getHeartbeatMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.yifan.api.Worker.Empty,
              com.yifan.api.Worker.HeartbeatResponse>(
                service, METHODID_HEARTBEAT)))
        .build();
  }

  private static abstract class WorkerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WorkerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.yifan.api.Worker.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WorkerService");
    }
  }

  private static final class WorkerServiceFileDescriptorSupplier
      extends WorkerServiceBaseDescriptorSupplier {
    WorkerServiceFileDescriptorSupplier() {}
  }

  private static final class WorkerServiceMethodDescriptorSupplier
      extends WorkerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    WorkerServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (WorkerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WorkerServiceFileDescriptorSupplier())
              .addMethod(getUploadFileMethod())
              .addMethod(getHeartbeatMethod())
              .build();
        }
      }
    }
    return result;
  }
}
