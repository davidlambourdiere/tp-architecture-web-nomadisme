package com.memda;

import io.grpc.stub.StreamObserver;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class OwnerGrpcService extends OwnerGrpc.OwnerImplBase{

    @Inject
    OwnerResource ownerResource;
    @Override
    public void getOwnerName(OwnerNameRequest request, StreamObserver<OwnerNameReply> responseObserver) {
        String ownerName = ownerResource.getOwnersHashMap().get(request.getId());
        responseObserver.onNext(OwnerNameReply.newBuilder().setName(ownerName).build());
        responseObserver.onCompleted();
    }
}
