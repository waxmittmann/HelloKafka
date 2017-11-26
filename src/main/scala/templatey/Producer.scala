package templatey

import java.time.Instant

import cakesolutions.kafka.KafkaProducer
import cakesolutions.kafka.KafkaProducer.Conf
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer

object Producer {

  // Create a org.apache.kafka.clients.producer.KafkaProducer
  val producer = KafkaProducer(
    Conf(new StringSerializer(), new StringSerializer(), bootstrapServers = "localhost:9092")
  )

  def main(args: Array[String]): Unit = {

    var at = 0

    while(true) {
      println("Write commencing")
      for {i <- 0 to 10} yield {
        producer.send(
          new ProducerRecord[String, String](
            "test",
            0,
            s"key_$at",
            i.toString,
          )
        )
      }
      println("Write complete")
      at = at + 1

      System.in.read()
    }

//    val producerRecord = new ProducerRecord[String, String](
//      "test",
//      0,
//      "a",
//      "b",
//    )
//    producer.send(producerRecord)
  }

}
