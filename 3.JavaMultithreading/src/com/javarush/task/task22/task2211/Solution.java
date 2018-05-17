package com.javarush.task.task22.task2211;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?";
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream= new FileInputStream(new File(args[0]));
        FileOutputStream outputStream = new FileOutputStream(new File(args[1]));


        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        inputStream.close();
        Charset w1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");

        String string = new String (buffer, utf8);

        outputStream.write(string.getBytes(w1251));
        outputStream.close();
    }
}
