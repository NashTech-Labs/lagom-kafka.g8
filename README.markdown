A [Giter8][g8] template for using embedded kafka provided by Lagom framework.

About Template
----------------------
# Lagom Framework + Kafka Integration

 This is an activator template showcasing how to publish to kafka topic and subscribe to it using embedded kafka provided by Lagom framework.

 ---

 Clone Project

 ```bash
 git clone git@github.com:knoldus/lagom-kafka.git
 cd lagom-kafka
 mvn lagom:runAll

 ```
 ---
## Application runs on port `http://localhost:9000`

### Publish message to kafka topic `greeting`

curl -H "Content-Type: application/json" -X POST -d '{"message":"Hi there"}' http://localhost:9000/api/hello/Alice

### Consume message fro kafka topic

The application subscribes to the topic greeting and dump out messages to standard output.

---

For any issue please raise a ticket @ [Github Issue](https://github.com/knoldus/lagom-kafka/issues)

----------------
Written in 2017​ by [Knoldus Software LLP](http://knoldus.com)
[other author/contributor lines as appropriate]
To the extent possible under law, the author(s) have dedicated all copyright and
related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See
<http://creativecommons.org/publicdomain/zero/1.0/>.
[g8]: http://www.foundweekends.org/giter8/
