package org.example.post_jdk8;

public sealed interface Shape permits Circle, Rectangle, Triangle {
    static double getPerimeter(Shape s) throws IllegalArgumentException {
        return switch (s) {
            case Rectangle r -> 2 * r.length() + 2 *
                    r.width();
            case Circle c -> 2 * c.radius() * Math.PI;
            default -> throw new IllegalArgumentException("Unrecognized shape");
        };
    }

    static void printAngleFromXAxis(Object obj) {
        if (obj instanceof Rectangle(int a, int b)) {
            System.out.println(Math.toDegrees(Math.atan2(a, b)));
        }
    }
}
