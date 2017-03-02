package com.knoldus.hello.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.broker.Topic;

import static com.lightbend.lagom.javadsl.api.Service.*;
import static com.lightbend.lagom.javadsl.api.transport.Method.GET;

public interface HelloService extends Service {

  /**
   * Example: curl http://localhost:9000/api/hello/Alice
   */
  String GREETINGS_TOPIC = "greeting";
  ServiceCall<NotUsed, String> hello(String id);

  /**
   * Example: curl -H "Content-Type: application/json" -X POST -d '{"message":
   * "Hi"}' http://localhost:9000/api/hello/Alice
   */
  ServiceCall<GreetingMessage, Done> useGreeting(String id);

  ServiceCall<NotUsed, String> health();
  @Override
  default Descriptor descriptor() {
    // @formatter:off
    return named("helloservice").withCalls(
        pathCall("/api/hello/:id",  this::hello),
        pathCall("/api/hello/:id", this::useGreeting),
        restCall(GET, "/api/health", this::health)
    ).publishing(
        topic(GREETINGS_TOPIC, this::greetingsTopic)
    ).withAutoAcl(true);
    // @formatter:on
  }
  // The topic handle
  Topic<GreetingMessage> greetingsTopic();
}