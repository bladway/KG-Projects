package com.cgvsu.objreader;

public class ReaderExceptions {
    public static class ObjReaderException extends RuntimeException {
        public ObjReaderException(final String errorMessage, final int lineInd) {
            super("Error parsing OBJ file on line: " + lineInd + ". " + errorMessage);
        }
    }
    public static class NotDefinedUniformFormatException extends RuntimeException {
        public NotDefinedUniformFormatException(final String errorMessage) {
            super("Error, not universal format: " + errorMessage);
        }
    }
    public static class FaceException extends  RuntimeException {
        public FaceException(final String errorMessage, final int ordinalNumberOfFace) {
            super("Some face incorrect, not exists vertex: " + ordinalNumberOfFace + ". " + errorMessage);
        }
    }
    public static class WrongFileException extends  RuntimeException {
        public WrongFileException(final String errorMessage) {
            super("Error, wrong file: " + errorMessage);
        }
    }
}
