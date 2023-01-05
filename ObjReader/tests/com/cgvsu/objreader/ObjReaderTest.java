package com.cgvsu.objreader;

import com.cgvsu.math.Vector2f;
import com.cgvsu.math.Vector3f;
import com.cgvsu.model.Model;
import com.cgvsu.model.Polygon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ObjReaderTest {

    @Test
    public void testParseVertex01() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.01", "1.02", "1.03"));
        Vector3f result = ObjReader.parseVertex(wordsInLineWithoutToken, 5);
        Vector3f expectedResult = new Vector3f(1.01f, 1.02f, 1.03f);
        Assertions.assertTrue(result.equals(expectedResult));
    }

    @Test
    public void testParseVertex02() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.01", "1.02", "1.03"));
        Vector3f result = ObjReader.parseVertex(wordsInLineWithoutToken, 5);
        Vector3f expectedResult = new Vector3f(1.01f, 1.02f, 1.10f);
        Assertions.assertFalse(result.equals(expectedResult));
    }



    @Test
    public void testParseVertex03() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.0", "2.0"));
        try {
            ObjReader.parseVertex(wordsInLineWithoutToken, 5);
            Assertions.assertTrue(false);
        } catch (ReaderExceptions.ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 5. Wrong number of vertex arguments.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseVertex04() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("ab", "o", "ba"));
        try {
            ObjReader.parseVertex(wordsInLineWithoutToken, 10);
            Assertions.assertTrue(false);
        } catch (ReaderExceptions.ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Failed to parse float value.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseVertex05() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.0", "2.0", "3.0", "4.0"));
        try {
            ObjReader.parseVertex(wordsInLineWithoutToken, 5);
            Assertions.assertTrue(false);
        } catch (ReaderExceptions.ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 5. Wrong number of vertex arguments.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseTextureVertex01() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("8.58", "1.87"));
        Vector2f result = ObjReader.parseTextureVertex(wordsInLineWithoutToken, 5);
        Vector2f expectedResult = new Vector2f(8.58f, 1.87f);
        Assertions.assertTrue(result.equals(expectedResult));
    }

    @Test
    public void testParseTextureVertex02() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("8.58", "1.87", "1.04"));
        Vector2f result = ObjReader.parseTextureVertex(wordsInLineWithoutToken, 5);
        Vector2f expectedResult = new Vector2f(8.58f, 1.87f);
        Assertions.assertTrue(result.equals(expectedResult));
    }

    @Test
    public void testParseTextureVertex06() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("8.58", "1.87", "1.08"));
        Vector2f result = ObjReader.parseTextureVertex(wordsInLineWithoutToken, 5);
        Vector2f expectedResult = new Vector2f(8.8f, 1.87f);
        Assertions.assertFalse(result.equals(expectedResult));
    }

    @Test
    public void testParseTextureVertex03() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("ab", "o"));
        try {
            ObjReader.parseTextureVertex(wordsInLineWithoutToken, 10);
            Assertions.assertTrue(false);
        } catch (ReaderExceptions.ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Failed to parse float value.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseTextureVertex04() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.0"));
        try {
            ObjReader.parseTextureVertex(wordsInLineWithoutToken, 10);
            Assertions.assertTrue(false);
        } catch (ReaderExceptions.ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Wrong number of texture vertex arguments.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseTextureVertex05() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.0", "2.0", "3.0", "4.0"));
        try {
            ObjReader.parseTextureVertex(wordsInLineWithoutToken, 5);
            Assertions.assertTrue(false);
        } catch (ReaderExceptions.ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 5. Wrong number of texture vertex arguments.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseNormal01() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.01", "1.02", "1.03"));
        Vector3f result = ObjReader.parseVertex(wordsInLineWithoutToken, 5);
        Vector3f expectedResult = new Vector3f(1.01f, 1.02f, 1.03f);
        Assertions.assertTrue(result.equals(expectedResult));
    }

    @Test
    public void testParseNormal02() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.01", "1.02", "1.03"));
        Vector3f result = ObjReader.parseVertex(wordsInLineWithoutToken, 5);
        Vector3f expectedResult = new Vector3f(1.01f, 1.02f, 1.10f);
        Assertions.assertFalse(result.equals(expectedResult));
    }



    @Test
    public void testParseNormal03() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.0", "2.0"));
        try {
            ObjReader.parseVertex(wordsInLineWithoutToken, 5);
            Assertions.assertTrue(false);
        } catch (ReaderExceptions.ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 5. Wrong number of vertex arguments.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseNormal04() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("ab", "o", "ba"));
        try {
            ObjReader.parseVertex(wordsInLineWithoutToken, 10);
            Assertions.assertTrue(false);
        } catch (ReaderExceptions.ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Failed to parse float value.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseNormal05() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.0", "2.0", "3.0", "4.0"));
        try {
            ObjReader.parseVertex(wordsInLineWithoutToken, 5);
            Assertions.assertTrue(false);
        } catch (ReaderExceptions.ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 5. Wrong number of vertex arguments.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseFace01() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("2/3/2", "1/2/1", "1/2/3"));
        Polygon polygon = ObjReader.parseFace(wordsInLineWithoutToken, 5);
        Polygon expectedResult = new Polygon();
        expectedResult.setVertexIndices(new ArrayList<>(Arrays.asList(1, 0, 0)));
        expectedResult.setTextureVertexIndices(new ArrayList<>(Arrays.asList(2, 1, 1)));
        expectedResult.setNormalIndices(new ArrayList<>(Arrays.asList(1, 0, 2)));
        List<Polygon> listPolygon = new ArrayList<>();
        listPolygon.add(polygon);
        List<Polygon> listExpectedPolygon = new ArrayList<>();
        listExpectedPolygon.add(expectedResult);
        Assertions.assertTrue(equalsList(listPolygon, listExpectedPolygon));
    }

    @Test
    public void testParseFace02() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("2/3/2", "1/2/1", "1/2/5"));
        Polygon polygon = ObjReader.parseFace(wordsInLineWithoutToken, 5);
        Polygon expectedResult = new Polygon();
        expectedResult.setVertexIndices(new ArrayList<>(Arrays.asList(2, 1, 1)));
        expectedResult.setTextureVertexIndices(new ArrayList<>(Arrays.asList(3, 2, 2)));
        expectedResult.setNormalIndices(new ArrayList<>(Arrays.asList(2, 1, 3)));
        Assertions.assertNotEquals(polygon, expectedResult);
    }



    @Test
    public void testParseFace03() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("2/3/2", "1/2/1"));
        try {
            ObjReader.parseFace(wordsInLineWithoutToken, 5);
            Assertions.assertTrue(false);
        } catch (ReaderExceptions.ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 5. Not enough vertexes for polygon.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseFace04() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("2/3/2", "1/2/1", "1/2/0"));
        try {
            ObjReader.parseFace(wordsInLineWithoutToken, 10);
            Assertions.assertTrue(false);
        } catch (ReaderExceptions.ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Some vector reference cannot be negative.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseFace05() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("-2/3/2", "1/2/1", "1/2/5"));
        try {
            ObjReader.parseFace(wordsInLineWithoutToken, 5);
            Assertions.assertTrue(false);
        } catch (ReaderExceptions.ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 5. Some vector reference cannot be negative.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseFace06() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("2/3/2/5", "1/2/1", "1/2/5"));
        try {
            ObjReader.parseFace(wordsInLineWithoutToken, 5);
            Assertions.assertTrue(false);
        } catch (ReaderExceptions.ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 5. Invalid element size.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseFace07() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("gf/gf/gf", "sd/sa/1", "1/2/5"));
        try {
            ObjReader.parseFace(wordsInLineWithoutToken, 5);
            Assertions.assertTrue(false);
        } catch (ReaderExceptions.ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 5. Failed to parse int value.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseFace08() {
        List<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("", "", "1/5/6"));
        try {
            ObjReader.parseFace(wordsInLineWithoutToken, 5);
            Assertions.assertTrue(false);
        } catch (ReaderExceptions.ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 5. Polygon vertex setting error.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseFaceOne01() {
        String wordsInLineWithoutToken = "3/4/5";
        List<Integer> verticesIndices = new ArrayList<>();
        List<Integer> textureVerticesIndices = new ArrayList<>();
        List<Integer> normalVerticesIndices = new ArrayList<>();
        ObjReader.parseOneFaceWord(wordsInLineWithoutToken, verticesIndices, textureVerticesIndices, normalVerticesIndices, 5);
        Assertions.assertTrue(verticesIndices.equals(new ArrayList<>(Arrays.asList(2))));
        Assertions.assertTrue(textureVerticesIndices.equals(new ArrayList<>(Arrays.asList(3))));
        Assertions.assertTrue(normalVerticesIndices.equals(new ArrayList<>(Arrays.asList(4))));
    }

    @Test
    public void testParseFaceOne02() {
        String wordsInLineWithoutToken = "3/4/0";
        try {
            List<Integer> verticesIndices = new ArrayList<>();
            List<Integer> textureVerticesIndices = new ArrayList<>();
            List<Integer> normalVerticesIndices = new ArrayList<>();
            ObjReader.parseOneFaceWord(wordsInLineWithoutToken, verticesIndices, textureVerticesIndices, normalVerticesIndices, 5);
            Assertions.assertTrue(false);
        } catch (ReaderExceptions.ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 5. Some vector reference cannot be negative.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseFaceOne03() {
        String wordsInLineWithoutToken = "3/4/1/3";
        try {
            List<Integer> verticesIndices = new ArrayList<>();
            List<Integer> textureVerticesIndices = new ArrayList<>();
            List<Integer> normalVerticesIndices = new ArrayList<>();
            ObjReader.parseOneFaceWord(wordsInLineWithoutToken, verticesIndices, textureVerticesIndices, normalVerticesIndices, 5);
            Assertions.assertTrue(false);
        } catch (ReaderExceptions.ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 5. Invalid element size.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseFaceOne04() {
        String wordsInLineWithoutToken = "df/fs/8";
        try {
            List<Integer> verticesIndices = new ArrayList<>();
            List<Integer> textureVerticesIndices = new ArrayList<>();
            List<Integer> normalVerticesIndices = new ArrayList<>();
            ObjReader.parseOneFaceWord(wordsInLineWithoutToken, verticesIndices, textureVerticesIndices, normalVerticesIndices, 5);
            Assertions.assertTrue(false);
        } catch (ReaderExceptions.ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 5. Failed to parse int value.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testCheckConsistency01() {
        List<Vector3f> vertices = new ArrayList<>(Arrays.asList(
                new Vector3f(5f, 8f, 6f), new Vector3f(8f, 8f, 5f),
                new Vector3f(7f, 8f, 5f), new Vector3f(7f, 5f, 5f),
                new Vector3f(5f, 8f, 6f)));
        List<Vector2f> textureVertices = new ArrayList<>(Arrays.asList(
                new Vector2f(1f, 2f), new Vector2f(4f, 5f),
                new Vector2f(7f, 8f)));
        List<Vector3f> normalVertices = new ArrayList<>(Arrays.asList(
                new Vector3f(9f, 8f, 7f), new Vector3f(6f, 5f, 4f),
                new Vector3f(3f, 2f, 1f)));
        List<Polygon> polygons = new ArrayList<>(Arrays.asList(
                new Polygon(Arrays.asList(0,1,2), Arrays.asList(1,2,1), Arrays.asList(1,1,0)),
                new Polygon(Arrays.asList(4,3,2), Arrays.asList(2,1,1), Arrays.asList(0,0,10)),
                new Polygon(Arrays.asList(1,2,4), Arrays.asList(1,1,2), Arrays.asList(1,2,2))));
        Model model = new Model(vertices, textureVertices, normalVertices, polygons);
        try {
            Assertions.assertTrue(model.checkConsistency());
        } catch (ReaderExceptions.FaceException exception) {
            String expectedError = "Some face incorrect, not exists vertex: 2. Polygon description is wrong.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testCheckConsistency02() {
        List<Vector3f> vertices = new ArrayList<>(Arrays.asList(
                new Vector3f(5f, 8f, 6f), new Vector3f(8f, 8f, 5f),
                new Vector3f(7f, 8f, 5f), new Vector3f(7f, 5f, 5f),
                new Vector3f(5f, 8f, 6f)));
        List<Vector2f> textureVertices = new ArrayList<>(Arrays.asList(
                new Vector2f(1f, 2f), new Vector2f(4f, 5f),
                new Vector2f(7f, 8f)));
        List<Vector3f> normalVertices = new ArrayList<>(Arrays.asList(
                new Vector3f(9f, 8f, 7f), new Vector3f(6f, 5f, 4f),
                new Vector3f(3f, 2f, 1f)));
        List<Polygon> polygons = new ArrayList<>(Arrays.asList(
                new Polygon(Arrays.asList(0,1,2), Arrays.asList(1,1), Arrays.asList(1,1,0)),
                new Polygon(Arrays.asList(4,3,2), Arrays.asList(2,1,1), new ArrayList<>()),
                new Polygon(Arrays.asList(1,2,4), Arrays.asList(1,1,2), Arrays.asList(1,2,2))));
        Model model = new Model(vertices, textureVertices, normalVertices, polygons);
        try {
            Assertions.assertTrue(model.checkConsistency());
        } catch (ReaderExceptions.NotDefinedUniformFormatException exception) {
            String expectedError = "Error, not universal format: The unified format for specifying polygon descriptions is not defined.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testRussianReadFromDirectory() {
        try {
            Path fileName = Path.of("ObjModels/Trash/ТестНаРусском.obj");
            String fileContent = Files.readString(fileName);
            Model model = ObjReader.read(fileContent, false);
        } catch (IOException exception) {
            Assertions.fail();
        }

    }

    @Test
    public void testRead01() {
        List<Vector3f> vertices = new ArrayList<>(Arrays.asList(
                new Vector3f(5f, 8f, 6f), new Vector3f(8f, 8f, 5f),
                new Vector3f(7f, 8f, 5f), new Vector3f(7f, 5f, 5f),
                new Vector3f(5f, 8f, 6f)));
        List<Vector2f> textureVertices = new ArrayList<>(Arrays.asList(
                new Vector2f(1f, 2f), new Vector2f(4f, 5f),
                new Vector2f(7f, 8f)));
        List<Vector3f> normalVertices = new ArrayList<>(Arrays.asList(
                new Vector3f(9f, 8f, 7f), new Vector3f(6f, 5f, 4f),
                new Vector3f(3f, 2f, 1f)));
        List<Polygon> polygons = new ArrayList<>(Arrays.asList(
                new Polygon(Arrays.asList(0,1,2), Arrays.asList(1,2,1), Arrays.asList(1,1,0)),
                new Polygon(Arrays.asList(4,3,2), Arrays.asList(2,1,1), Arrays.asList(0,0,1)),
                new Polygon(Arrays.asList(1,2,4), Arrays.asList(1,1,2), Arrays.asList(1,2,2))));
        Model model = ObjReader.read(
                "v 5 8 6\n" +
                        "v 8 8 5\n" +
                        "v 7 8 5\n" +
                        "v 7 5 5\n" +
                        "v 5 8 6\n" +
                        "vn 9 8 7\n" +
                        "vn 6 5 4\n" +
                        "vn 3 2 1\n" +
                        "vt 1 2 \n" +
                        "vt 4 5 \n" +
                        "vt 7 8\n" +
                        "f 1/2/2 2/3/2 3/2/1\n" +
                        "f 5/3/1 4/2/1 3/2/2\n" +
                        "f 2/2/2 3/2/3 5/3/3", false);
        Assertions.assertTrue(equalsList(vertices, model.getVertices()));
        Assertions.assertTrue(equalsList(textureVertices, model.getTextureVertices()));
        Assertions.assertTrue(equalsList(normalVertices, model.getNormals()));
        Assertions.assertTrue(equalsList(polygons, model.getPolygons()));
    }



    private static <T> boolean equalsList(final List<T> list1, final List<T> list2) {
        if (list1.size() == list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                if (!list1.get(i).equals(list2.get(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /*private static boolean equalsPol(final List<Polygon> list1, final List<Polygon> list2) {
        if (list1.size() == list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                if (!list1.get(i).getVertexIndices().equals(list2.get(i).getVertexIndices())
                        || !list1.get(i).getTextureVertexIndices().equals(list2.get(i).getTextureVertexIndices())
                        || !list1.get(i).getNormalIndices().equals(list2.get(i).getNormalIndices())) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }*/

   /* private static boolean equals3f(final List<Vector3f> list1, final List<Vector3f> list2) {
        if (list1.size() == list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                if (!list1.get(i).equals(list2.get(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }*/

   /* private static boolean equals2f(final List<Vector2f> list1, final List<Vector2f> list2) {
        if (list1.size() == list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                if (!list1.get(i).equals(list2.get(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }*/

    /*private static boolean equals(final float a, final float b) {
       return Math.abs(a - b) < ObjReader.getEps();
    }*/
}