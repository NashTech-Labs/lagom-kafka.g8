package com.knoldus.hello.impl;

import akka.Done;
import akka.stream.javadsl.Flow;
import com.google.inject.Singleton;
import com.knoldus.hello.api.GreetingMessage;
import com.knoldus.hello.api.HelloService;

import javax.inject.Inject;

@Singleton public class Consumer {

  private final HelloService helloService;

  @Inject public Consumer(HelloService helloService) {
    this.helloService = helloService;
    helloService.greetingsTopic().subscribe()
        .atLeastOnce(Flow.fromFunction(this::displayMessage));
  }

  private Done displayMessage(GreetingMessage message) {
    System.out.println("Message :  " + message);
    return Done.getInstance();
  }

}