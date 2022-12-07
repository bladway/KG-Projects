package com.cgvsu.math;

import com.cgvsu.objreader.ObjReader;

// Это заготовка для собственной библиотеки для работы с линейной алгеброй
public class Vector2f {
    private static final float eps = 1e-7f;
    private final float x;
    private final float y;

    public Vector2f(final float x, final float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }

            Vector2f gotVector = (Vector2f) obj;
            return Math.abs(this.x - gotVector.x) < eps && Math.abs(this.y - gotVector.y) < eps;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
