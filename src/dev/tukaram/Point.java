package dev.tukaram;

public class Point {
	private double xPoint;
	private double yPoint;

	public Point(double xPoint, double yPoint) {
		this.xPoint = xPoint;
		this.yPoint = yPoint;
	}

	public double getXPoint() {
		return xPoint;
	}

	public double getYPoint() {
		return yPoint;
	}

	@Override
	public String toString() {
		return String.format("Point [X: %.2f, Y: %.2f]", xPoint, yPoint);
	}
}