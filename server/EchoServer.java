package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static final int SERVER_PORT = 8189;

    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Ожидаем подключение...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Соединение установлено!");

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            while (true) {

                String message = in.readUTF();
                System.out.println("Cообщение пользователя: " + message);
                if (message.equals("/exit")) {
                    break;
                }
                out.writeUTF("Ответ от сервера: " + message.toUpperCase());
            }
            System.out.println("Сервер остановлен.");


        }
        catch (IOException e) {
            System.out.println("Порт уже занят");
            e.printStackTrace();
        }
    }
}