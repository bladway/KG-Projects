package com.cgvsu;

import com.cgvsu.model.Model;
import com.cgvsu.objreader.ObjReader;
import com.cgvsu.objreader.ReaderExceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    private final static boolean willItWriteInformationToConsole = true;
/*Warning! Please use only UTF-8 encoding, support for other encodings is not guaranteed*/
/*реализация objReader строгое содержимое файла (никаких посторонних символов), большинство косяков
выходят в исключениях, содержимое файла читается в любом порядке*/
    public static void main(String[] args) {
        Path fileName = Path.of("Teapot.obj");
        String fileContent;
        try {
            fileContent = Files.readString(fileName);
        } catch (IOException exception) {
            throw new ReaderExceptions.WrongFileException("Can't read this file. Extension or encoding is wrong");
        }
        if (willItWriteInformationToConsole) System.out.println("Loading model ...");
        Model model = ObjReader.read(fileContent, willItWriteInformationToConsole);
        if (willItWriteInformationToConsole) {
            System.out.println("Vertices: " + model.getVertices().size());
            System.out.println("Texture vertices: " + model.getTextureVertices().size());
            System.out.println("Normals: " + model.getNormals().size());
            System.out.println("Polygons: " + model.getPolygons().size());
        }
    }
}
