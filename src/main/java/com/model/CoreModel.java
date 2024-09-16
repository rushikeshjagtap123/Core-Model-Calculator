package com.model;

public class CoreModel {
	private String coreModel;
	private int width;
	private int height;
	private int depth;
	private int leFactor;

	public CoreModel(String coreModel) {
		this.coreModel = coreModel;
		parseCoreModel();
	}

	private void parseCoreModel() {

		String[] parts = coreModel.split("/");

		if (parts.length >= 2) {

			this.width = Integer.parseInt(parts[0].substring(2));
			this.height = Integer.parseInt(parts[1]);

			if (parts.length == 3) {
				this.depth = Integer.parseInt(parts[2]);
			} else {
				this.depth = 0;
			}

			this.leFactor = coreModel.startsWith("EE") ? 2 : 1;
		} else {
			throw new IllegalArgumentException("Invalid core model format");
		}
	}

	public double calculateEffectiveVolume() {
		double Ae = calculateEffectiveArea();
		double le = calculateEffectiveLength();
		return Ae * le;
	}

	public double calculateEffectiveLength() {

		return leFactor * (width + height);
	}

	public double calculateEffectiveArea() {
		return width * height;
	}

	public double calculateCoreWindowArea() {
		double windowHeight = height * 0.8;
		double windowWidth = depth * 0.6;
		return windowHeight * windowWidth;
	}

	public double calculateCoreFactor() {
		double Ae = calculateEffectiveArea();
		double le = calculateEffectiveLength();
		double Ve = calculateEffectiveVolume();
		return (Ae * le) / Ve;
	}

	public void displayCoreModel() {
		System.out.println("Core Model: " + coreModel);
		System.out.println("Effective Volume (Ve): " + calculateEffectiveVolume());
		System.out.println("Effective Length (le): " + calculateEffectiveLength());
		System.out.println("Effective Area (Ae): " + calculateEffectiveArea());
		System.out.println("Core Window Area (An): " + calculateCoreWindowArea());
		System.out.println("Core Factor (C_F): " + calculateCoreFactor());
	}
}
