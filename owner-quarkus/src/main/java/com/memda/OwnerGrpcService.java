package com.memda;

import io.grpc.stub.StreamObserver;

import javax.inject.Singleton;

@Singleton
public class OwnerGrpcService extends OwnerGrpc.OwnerImplBase{

    @Override
    public void getOwnerName(OwnerNameRequest request, StreamObserver<OwnerNameReply> responseObserver) {
        String id = request.getId();
        String ownerName;
        switch (id){
            case "AB-13-CD":
                ownerName = "Patrick";
                break;
            case "AB-50-XZ":
                ownerName="Mohamed";
                break;
            default:
                ownerName = "inconnu";
                break;
        }
        responseObserver.onNext(OwnerNameReply.newBuilder().setName(ownerName).build());
        responseObserver.onCompleted();
    }
}
