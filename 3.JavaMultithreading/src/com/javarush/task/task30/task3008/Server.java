package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();
    public static void sendBroadcastMessage(Message message){
        try {
        for (Connection connection : connectionMap.values()) {
            connection.send(message);
        }
            } catch (IOException e) {
                e.printStackTrace();
                ConsoleHelper.writeMessage("Сообщение не отправлено");
            }
        }

    private static class Handler extends Thread{
        private Socket socket;
        public Handler(Socket socket){
            this.socket = socket;
        }
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            while (true){
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();

                if (message.getType() == MessageType.USER_NAME){
                    if (message.getData() != null && !message.getData().isEmpty()){
                        if (connectionMap.get(message.getData()) == null){
                            connectionMap.put(message.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return message.getData();
                        }
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for (String key : connectionMap.keySet()){
                Message message = new Message(MessageType.USER_ADDED, key);
                if (!key.equals(userName))
                    connection.send(message);
            }
        }
         private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true){
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT){
                    String s = userName + ": " + message.getData();
                    Message formMessage = new Message(MessageType.TEXT, s);
                    sendBroadcastMessage(formMessage);
                }else
                    ConsoleHelper.writeMessage("Ощибка");
            }

         }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено соединение с удаленным адресом: " + socket.getRemoteSocketAddress());
            String clent = null;
            try (Connection connection = new Connection(socket)) {
                clent = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clent));
                sendListOfUsers(connection, clent);
                serverMainLoop(connection, clent);

            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Ошибка при обмене данными с удаленнвм адресом");
            }
            if (clent != null) {
                connectionMap.remove(clent);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clent));
            }
            ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");

        }
        }
    public static void main(String[] args) throws IOException{

        int serverPort = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(serverPort)) {
            ConsoleHelper.writeMessage("Сервер запущен");

            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        }catch (IOException e){
            System.out.println("Ошибка зауска");
        }
    }
}
