import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Author:ZouDouble
 * Description:实现最简单的客户端服务器程序
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-02 19:24
 */
public class UDPEchoServer {
    //实现客户端服务器需要两个步骤
    //(1)进行初始化操作(实例化Socket对象)
    //(2)进入主循环，建立请求连接(主循环是一个死循环，因为服务器需要时刻准备着相应用户请求)
        //a)解析请求数据
        //b)根据请求计算响应
        //c)将相应结果写回客户端
    private DatagramSocket socket = null;
    public UDPEchoServer(int port) throws SocketException {
        //此处实例化socket的时候会给它绑定一个端口号和一个IP地址,将来客户端就会根据这个端口号+IP地址来访问相关数据
        socket = new DatagramSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器开始启动");
        while(true){
            //(a)解析请求数据
            //DatagramPacket是UDP发送接收数据的基本单位
            //在实例化requestPacket的时候需要给它指定一个缓冲区，并且告诉它缓冲区的大小
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(requestPacket);
            //将请求数据转化为String
            /**
             * 此处调用trim的原因：用户发送的请求数据很有可能小于4096
             * 而此处的getLength得到的长度是4096，通过trim可以减少不必要的空白
             * */
            String request = new String(requestPacket.getData(),0,requestPacket.getLength()).trim();
            //b)根据请求计算响应
            String response = process(request);
            //c)将响应写回客户端,响应数据是response,需要把它包装为Packet对象
          DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length,
                  requestPacket.getSocketAddress());
          socket.send(requestPacket);
          //打印服务日志
            System.out.printf("[%s:%d] req:%s resp:%s\n",requestPacket.getAddress().toString(),
                    requestPacket.getPort(),request,response);
        }
    }

    private String process(String request) {
        //由于此处是echo server，因此请求是什么，响应就是什么
        //如果是其他类型的服务器，就会有很多复杂的逻辑
        return request;
    }

    public static void main(String[] args) throws IOException {
            UDPEchoServer server = new UDPEchoServer(9092);
            server.start();
    }
}
