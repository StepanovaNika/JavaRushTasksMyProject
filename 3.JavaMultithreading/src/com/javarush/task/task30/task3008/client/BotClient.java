package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import sun.text.resources.no.CollationData_no;

import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {
    @Override
    protected String getUserName() {
        String botName = "date_bot_" + ((int) (Math.random() * 100));
        return botName;
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);

            String name = "";
            String messageText = "";
            if (message.contains(": ")) {
                name = message.substring(0, message.indexOf(": "));
                messageText = message.substring(message.indexOf(": ") + 2);
            }
            else {
                messageText = message;
            }


            SimpleDateFormat format = null;
            if (messageText.equalsIgnoreCase("дата")){
                format = new SimpleDateFormat( "d.MM.YYYY");
            }
            else if(messageText.equalsIgnoreCase("день")){
                format = new SimpleDateFormat( "d");
            }
            else if (messageText.equalsIgnoreCase("месяц")){
                format = new SimpleDateFormat( "MMMM");
            }
            else if (messageText.equalsIgnoreCase("год")){
                format = new SimpleDateFormat("YYYY");
            }
            else if (messageText.equalsIgnoreCase("время")){
                format = new SimpleDateFormat("H:mm:ss");
            }
            else if (messageText.equalsIgnoreCase("час")){
                format = new SimpleDateFormat("H");
            }
            else if (messageText.equalsIgnoreCase("минуты")){
                format = new SimpleDateFormat("m");
            }
            else if (messageText.equalsIgnoreCase("секунды")){
                format = new SimpleDateFormat("s");
            }
            if (format != null)
            {
                sendTextMessage("Информация для " + name + ": " + format.format(Calendar.getInstance().getTime()));
            }
        }
    }
}
