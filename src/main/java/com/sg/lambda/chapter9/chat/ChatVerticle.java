package com.sg.lambda.chapter9.chat;

import io.vertx.core.*;

public class ChatVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        vertx.createNetServer()
                .connectHandler(socket -> {
                    socket.handler(new User(socket, this));
                }).listen(10_000);


    }
}
