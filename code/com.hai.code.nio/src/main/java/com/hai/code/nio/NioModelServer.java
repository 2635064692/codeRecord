package com.hai.code.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author admin_z by 2021/9/7
 * @ClassName NioModelView
 */
public class NioModelServer {

    private static int port = 8000;
    private static InetSocketAddress address = null;
    private static Selector selector;
    private static ByteBuffer buffer = ByteBuffer.allocate(1024);


    public static void main(String[] args) throws IOException {
        address = new InetSocketAddress(port);

        // Channel多路复用
        ServerSocketChannel server = ServerSocketChannel.open();
        //监听一个端口
        server.bind(address);
        // 设置为非阻塞
        server.configureBlocking(false);

        // 初始化Selector
        selector = Selector.open();

        // 把路和selector关联上
        server.register(selector, SelectionKey.OP_ACCEPT);// 表示客户端可以进行连接请求了

        // 使用selector进行循环判断，看哪一个key被选中，哪些key可以进行操作
        // 轮询操作
        while (true) {
            int count = selector.select();
            if (count == 0) {
                continue;
            }
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                //对key进行后续操作
                process(key);
                iterator.remove();
            }
        }
    }

    // 接下来根据key进行连接的创建，读写操作
    private static void process(SelectionKey key) throws IOException {
        // 判断这个key的状态，可接受、可读写？
        if (key.isAcceptable()) {
            // 创建连接对象，客户端对象  下面代表服务端的channel
            ServerSocketChannel server = (ServerSocketChannel) key.channel();
            SocketChannel client = server.accept();
            client.configureBlocking(false);
            // 将key注册为可读
            client.register(selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) {
            // 创建连接对象，客户端对象  下面代表服务端的channel
            SocketChannel client = (SocketChannel) key.channel();
            // 根据客户端进行接下来的操作 将客户端传来的数据读到buffer中
            int len = client.read(buffer);
            if (len > 0) {
                buffer.flip();// 复位 对缓冲区对象中的数据进行锁定
                String text = new String(buffer.array(), 0, len);
                System.out.println(text);
            }
            // 读完之后，将key注册为可写
            client.register(selector, SelectionKey.OP_WRITE);
            buffer.clear();
        } else if (key.isWritable()) {
            SocketChannel client = (SocketChannel) key.channel();
            client.write(buffer.wrap("获取数据成功".getBytes()));
            client.close();
        }
    }

}
