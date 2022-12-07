package com.cgvsu.math;

import com.cgvsu.objreader.ObjReader;

// Это заготовка для собственной библиотеки для работы с линейной алгеброй
public class Vector3f {
    private static final float eps = 1e-7f;
    private final float x;
    private final float y;
    private final float z;

    public Vector3f(final float x, final float y, final float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Vector3f gotVector = (Vector3f) obj;
        return Math.abs(this.x - gotVector.x) < eps && Math.abs(this.y - gotVector.y) < eps
                && Math.abs(this.z - gotVector.z) < eps;
    }


    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }
}
