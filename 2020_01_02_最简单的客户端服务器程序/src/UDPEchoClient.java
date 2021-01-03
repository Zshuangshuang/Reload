import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-02 20:13
 */
public class UDPEchoClient {
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;

    public UDPEchoClient(String serverIp, int serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        socket = new DatagramSocket();
    }
public void start() throws IOException {
    Scanner scanner = new Scanner(System.in);
        while (true){
            //(1)读取用户输入内容
            System.out.println("->");
            String request = scanner.nextLine();
            if (request.equals("exit")){
                break;
            }
            //(2)构造请求数据发送给服务器
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length,
                    InetAddress.getByName(serverIp),serverPort);
            socket.send(requestPacket);
            //(3)从服务器读取响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(),0,responsePacket.getLength()).trim();
            //(4)显示响应数据
            System.out.println(response);
        }
}
    public static void main(String[] args) throws IOException {
        UDPEchoClient client = new UDPEchoClient("127.0.0.1",9092);
        client.start();

    }
}
