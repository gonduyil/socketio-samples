package org.uncertaintyman.test;

import io.socket.client.Ack;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import java.net.URISyntaxException;

public class SocketIoClientTests {

    public static void main(String[] args) throws URISyntaxException {
        Socket socket  = IO.socket("http://10.60.151.237:10001", new IO.Options());
       // Socket socket = new Socket("http://10.60.151.237:10001");

        socket.on("my_response", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                System.out.println("1231231");

                if (args.length > 1 && args[1] instanceof Ack) {
                    ((Ack)args[1]).call("gggggggggg");
                }
                String data = (String)args[0];
            }
        });
        socket.connect();

        /*
        CREATE,DROP,INDEX,ALTER
         */
    }
}
