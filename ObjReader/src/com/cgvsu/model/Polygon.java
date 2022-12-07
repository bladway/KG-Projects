package com.cgvsu.model;

import com.cgvsu.math.Vector2f;
import com.cgvsu.objreader.ObjReader;

import java.util.ArrayList;
import java.util.List;

public class Polygon {
    private List<Integer> vertexIndices;
    private List<Integer> textureVertexIndices;
    private List<Integer> normalIndices;

    public Polygon(final List<Integer> vertexIndices, final List<Integer> textureVertexIndices, final List<Integer> normalIndices) {
        this.vertexIndices = vertexIndices;
        this.textureVertexIndices = textureVertexIndices;
        this.normalIndices = normalIndices;
    }

    public Polygon() {
        vertexIndices = new ArrayList<>();
        textureVertexIndices = new ArrayList<>();
        normalIndices = new ArrayList<>();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Polygon gotPolygon = (Polygon) obj;
        return this.getVertexIndices().equals(gotPolygon.getVertexIndices())
                && this.getTextureVertexIndices().equals(gotPolygon.getTextureVertexIndices())
                && this.getNormalIndices().equals(gotPolygon.getNormalIndices());
    }

    public void setVertexIndices(final List<Integer> vertexIndices) {
        this.vertexIndices = vertexIndices;
    }

    public void setTextureVertexIndices(final List<Integer> textureVertexIndices) {
        this.textureVertexIndices = textureVertexIndices;
    }

    public void setNormalIndices(final List<Integer> normalIndices) {
        this.normalIndices = normalIndices;
    }

    public List<Integer> getVertexIndices() {
        return vertexIndices;
    }

    public List<Integer> getTextureVertexIndices() {
        return textureVertexIndices;
    }

    public List<Integer> getNormalIndices() {
        return normalIndices;
    }
}
