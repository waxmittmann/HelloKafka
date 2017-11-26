package templatey

import cakesolutions.kafka.KafkaConsumer
import cakesolutions.kafka.KafkaConsumer.Conf
import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.common.serialization.StringDeserializer

import scala.collection.JavaConverters._

object Consumer {

  def main(args: Array[String]): Unit = {
    // Create a org.apache.kafka.clients.consumer.KafkaConsumer
    val consumer = KafkaConsumer(
      Conf(new StringDeserializer(), new StringDeserializer(), bootstrapServers = "localhost:9092", groupId = "testGrp")
    )

    consumer.subscribe(List("test").asJava)

    while (true) {
      val records: ConsumerRecords[String, String] = consumer.poll(100)
      for (record <- records.iterator().asScala.toList) {
        println(s"offset = ${record.offset()}, key = ${record.key()}, value = ${record.value()}")
        //System.out.printf("offset = %d, key = %s, value = %s", record.offset, record.key, record.value)
      }
    }
  }

}
