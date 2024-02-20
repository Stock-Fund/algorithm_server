package org.example.socket;
import com.google.protobuf.InvalidProtocolBufferException;
import org.example.socket.proto.java.Algorithm;
public class ProtocolHandler {
    public void handleProtocol(String protocol, byte[] data) throws InvalidProtocolBufferException {
        switch (protocol) {
            case "Algorithm.Stock":
                Algorithm.Stock message = Algorithm.Stock.parseFrom(data);
                String name = message.getName();
                System.out.print("Hello proto!"+name);
                // 处理 stock 的逻辑
                break;
            default:
                // 处理未知协议的逻辑
                break;
        }
    }
}