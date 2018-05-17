package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {
        String resultFileName = args[0];
        List<String> fileNamePartList = new ArrayList<>();
        fileNamePartList.addAll(Arrays.asList(args).subList(1, args.length));

        Collections.sort(fileNamePartList, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return o1.compareTo(o2);
            }
        });
        List<FileInputStream> streams = new ArrayList<>();
        for (String fileNamePart : fileNamePartList)
        {
            try
            {
                streams.add(new FileInputStream(fileNamePart));
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }

        byte[] buffer = new byte[2048];
        int len = 0;

        try
        {
            FileOutputStream fos = new FileOutputStream(new File(resultFileName));
            ZipInputStream zis = new ZipInputStream(new SequenceInputStream(Collections.enumeration(streams)));

            while (zis.getNextEntry() != null)
            {
                while ((len = zis.read(buffer)) > 0)
                {
                    fos.write(buffer, 0, len);
                }
                zis.closeEntry();
            }
            zis.close();
            fos.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
