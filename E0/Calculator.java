public class Calculator {

    static int add(int a, int b) {
        int ans = a + b;
        return ans;
    }

    static float multiply(float a, float b) {
        return (float) (a * b);
    }
    static int sub(int a, int b) {
        int ans = a - b;
        return ans;
    }

    static double div(double a, double b) {
        double ans = a/b;
        return ans;
    }

    static float circleArea(int radius) {
        return (float) (Math.PI * (radius * radius));
    }

    static double sphereVolume(float radius) {
        double ans = (4/3) * Math.PI * radius * radius * radius;
        return ans;
    }

}