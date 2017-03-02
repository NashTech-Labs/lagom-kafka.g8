package com.knoldus.hello.api;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.broker.Topic;

import static com.lightbend.lagom.javadsl.api.Service.*;

public interface HelloService extends Service {


    String GREETINGS_TOPIC = "greeting";

    ServiceCall<NotUsed, String> hello(String id);

    ServiceCall<GreetingMessage, Done> useGreeting(String id);

    @Override
    default Descriptor descriptor() {
        return named("helloservice").withCalls(
                pathCall("/api/hello/:id", this::hello),
                pathCall("/api/hello/:id", this::useGreeting)
        ).publishing(
                topic(GREETINGS_TOPIC, this::greetingsTopic)
        ).withAutoAcl(true);
    }

    Topic<GreetingMessage> greetingsTopic();
}