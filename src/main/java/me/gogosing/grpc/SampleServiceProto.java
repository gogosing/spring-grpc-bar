package me.gogosing.grpc;

import io.grpc.stub.StreamObserver;
import me.gogosing.sample.proto.MessageRequest;
import me.gogosing.sample.proto.MessageResponse;
import me.gogosing.sample.proto.SampleGrpc;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * Created by JinBum Jeong on 2020/03/02.
 */
@GrpcService
public class SampleServiceProto extends SampleGrpc.SampleImplBase {

    @Override
    public void getMessage(
            MessageRequest request,
            StreamObserver<MessageResponse> responseObserver
    ) {
        String message = String.format("this message from bar service : %s", request.getContents());

        MessageResponse response = MessageResponse.newBuilder()
                .setContents(message)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
