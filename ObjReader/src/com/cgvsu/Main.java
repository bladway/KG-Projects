package com.cgvsu;

import com.cgvsu.model.Model;
import com.cgvsu.objreader.ObjReader;
import com.cgvsu.objreader.ReaderExceptions;

import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
/*Warning! Please use only UTF-8 encoding, support for other encodings is not guaranteed*/
/*реализация objReader строгое содержимое файла (никаких посторонних символов), большинство косяков
выходят в исключениях, содержимое файла читается в любом порядке*/
    public static void main(String[] args) {
        Path fileName = Path.of("../ObjModels/Trash/Тест НаРусском.obj");
        String fileContent;
        try {
            fileContent = Files.readString(fileName);
        } catch (IOException exception) {
            throw new ReaderExceptions.WrongFileException("Can't read this file. Extension or encoding is wrong");
        }

        System.out.println("Loading model ...");
        Model model = ObjReader.read(fileContent);
        System.out.println("Vertices: " + model.getVertices().size());
        System.out.println("Texture vertices: " + model.getTextureVertices().size());
        System.out.println("Normals: " + model.getNormals().size());
        System.out.println("Polygons: " + model.getPolygons().size());
    }
}
