package com.sg.lambda.chapter9.chat;

import io.vertx.core.Handler;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.net.NetSocket;
import io.vertx.core.shareddata.LocalMap;

import java.util.Optional;
import java.util.regex.Pattern;

public class User implements Handler<Buffer> {

    private static final Pattern NEW_LINE = Pattern.compile("\\n");

    private final NetSocket socket;
    private final LocalMap<String, String> names;
    private final EventBus eventBus;
    private Optional<String> name;

    public User(NetSocket socket, Verticle verticle) {
        Vertx vertx = verticle.getVertx();

        this.socket = socket;
        this.names = vertx.sharedData().getLocalMap("names");
        this.eventBus = vertx.eventBus();
        this.name = Optional.empty();
    }

    @Override
    public void handle(Buffer buffer) {
        NEW_LINE.splitAsStream(buffer.toString())
                .forEach(line -> {
                    if (!name.isPresent()) {
                        setName(line);
                    } else {
                        //handleMessage(line);
                    }
                });
    }

    private void setName(String name) {
        this.name = Optional.of(name);
    }
}
