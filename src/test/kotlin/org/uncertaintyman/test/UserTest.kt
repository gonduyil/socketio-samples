package org.uncertaintyman.test

import io.socket.client.Ack
import io.socket.client.IO
import io.socket.client.Socket
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeUnit

class UserTest {


    fun main(args: Array<String>) {
        val userId: String = "110110110"
        var register: String = """
            {
                            cmd: "register",
                            userId: ${userId},
                            role: "S",
                            deviceVersion: "1.0",
                            token: "123",
                            tty: "1"
            }
        """.trimIndent();

        val url: String = """http://ailearn-instruction-proxy-svr.ailearn.ink?systemId=${userId}&loginType=0&token=eyJ0eXAiOiJK&userType=2&tty=1&role=S&deviceVersion=1.0&appVersion=2.0""".trimMargin()



        val socket: Socket = IO.socket(url, IO.Options())

        socket.on("my_response") { args ->
            println("1231231")
            if (args.size > 1 && args[1] is Ack) {
                (args[1] as Ack).call("gggggggggg")
            }
            val data = args[0] as String
        }

        socket.on("push_msg_event")  {
            println("push_msg_event:${it[0]}")
            if (it.size > 1 && it[1] is Ack) {
                //(args[1] as Ack).call("gggggggggg")
            }
            val data = it[0] as String
        }



        socket.connect()

    }

    @Test
    fun test() {

    }
}