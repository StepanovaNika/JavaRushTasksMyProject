package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String strPath = reader.readLine();
        reader.close();

        Path path = Paths.get(strPath);
        if (!Files.isDirectory(path)){
            System.out.println(path.toAbsolutePath().toString() + " - не папка");
            return;
        }
        SimplePath simplePath = new SimplePath(path);
        Files.walkFileTree(path, simplePath);
        System.out.println("Всего папок - " + simplePath.getDirs());
        System.out.println("Всего файлов - " + simplePath.getFiles());
        System.out.println("Общий размер - " + simplePath.getBytes());




    }
    public static class SimplePath extends SimpleFileVisitor<Path> {
        public int dirs = -1;
        public int files = 0;
        public int bytes = 0;
        private Path path;

        public SimplePath(Path path) {
            this.path = path;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            dirs++;
            return super.postVisitDirectory(dir, exc);
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            bytes += attrs.size();
            files++;
            return super.visitFile(file, attrs);
        }

        public int getDirs() {
            return dirs;
        }

        public int getFiles() {
            return files;
        }

        public int getBytes() {
            return bytes;
        }
    }

}
