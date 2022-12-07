package com.cgvsu.rasterization;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class ColourfulEllipse {
    /*Заполнения эллипса алгоритмом scanline с получением цвета для каждой точки, цвет каждой точки определяется расстоянием
    от центра эллипса до этой точки по прямой линии, построенной по двум точкам: текущей, выбранной точки
    и точки центра эллипса*/
    public static void drawColourfulEllipse
            (GraphicsContext gc, int centerPointX, int centerPointY, int xAxis, int yAxis, Color centerColor, Color edgeColor) {
        PixelWriter pixelWriter = gc.getPixelWriter();
        for (int x = centerPointX - xAxis; x < centerPointX + xAxis; x++) {
            double localZeroY = Math.sqrt(yAxis * yAxis * (1 - ((x - centerPointX) * (x - centerPointX))
                    / (xAxis * xAxis + 0.0)));
            int startBorder = (int)(-localZeroY + centerPointY);
            int endBorder = (int)(localZeroY + centerPointY);
            for (int y = startBorder; y < endBorder; y++) {
                pixelWriter.setColor(x, y, getColorForPointInEllipse(x, y, centerPointX, centerPointY, xAxis, yAxis, centerColor, edgeColor));
            }
        }
    }

    public static Color getColorForPointInEllipse(
            double pointX, double pointY,
            double centerPointX, double centerPointY,
            double xAxis, double yAxis,
            Color centerColor, Color edgeColor) {
        double x1;
        double x2;
        double y1;
        double y2;
        if (Double.compare(centerPointX, pointX) == 0) {
            x1 = centerPointX;
            x2 = centerPointX;
            y1 = centerPointY + yAxis;
            y2 = centerPointY - yAxis;
        } else {
            double k = (centerPointY - pointY) / (centerPointX - pointX);
            double b = (pointY - k * pointX);
            double S = b - centerPointY;
            double V = xAxis * xAxis * yAxis * yAxis;
            double A = yAxis * yAxis + xAxis * xAxis * k * k;
            double B = 2 * (xAxis * xAxis * k * S - yAxis * yAxis * centerPointX);
            double C = yAxis * yAxis * centerPointX * centerPointX + xAxis * xAxis * S * S - V;
            double Dis = B * B - 4 * A * C;
            x1 = ((B - 2 * B) + Math.sqrt(Dis)) / (2 * A);
            y1 = k * x1 + b;
            x2 = ((B - 2 * B) - Math.sqrt(Dis)) / (2 * A);
            y2 = k * x2 + b;
        }
        double edgePointX;
        double edgePointY;
        if (distanceBetweenTwoPoints(x1, y1, pointX, pointY) <= distanceBetweenTwoPoints(x2, y2, pointX, pointY)) {
            edgePointX = x1;
            edgePointY = y1;
        } else {
            edgePointX = x2;
            edgePointY = y2;
        }
        final double distanceOfPointFromCentreInPercent =
                (distanceBetweenTwoPoints(centerPointX, centerPointY, pointX, pointY) /
                        distanceBetweenTwoPoints(centerPointX, centerPointY, edgePointX, edgePointY));
        double colorR = centerColor.getRed() + (edgeColor.getRed() - centerColor.getRed()) * distanceOfPointFromCentreInPercent;

        double colorG = centerColor.getGreen() + (edgeColor.getGreen() - centerColor.getGreen()) * distanceOfPointFromCentreInPercent;

        double colorB = centerColor.getBlue() + (edgeColor.getBlue() - centerColor.getBlue()) * distanceOfPointFromCentreInPercent;
        colorR = Math.abs(Math.min(colorR, 1.0));
        colorB = Math.abs(Math.min(colorB, 1.0));
        colorG = Math.abs(Math.min(colorG, 1.0));
        return new Color(colorR, colorG, colorB, 1.0);
    }
    public static double distanceBetweenTwoPoints(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
