package org.us._42.avaj.aircraft;

import org.us._42.avaj.*;
import org.us._42.avaj.aircraft.*;
import org.us._42.avaj.exceptions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Aircraft {
	protected long id;
	protected String name;
	protected final Coordinates coordinates;
	protected String type;
	private static long idCounter = 0;

	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
		this.id = this.nextId();
	}

	private void logMessage(String message) {
        try {
            FileWriter myWriter = new FileWriter("simulation.txt", true);
            myWriter.write(message);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

	private String genFormat() {
		String type = this.type;
		String name = this.name;
		long id = this.id;
		return (type + "#" + name + "(" + id + ")");
	}

	protected void weatherMessage(String message) {
        String format = this.genFormat();
        this.logMessage(format + ": " + message);
    }

    protected void landingMessage() {
        String format = this.genFormat();
		String message = " landing.\n";
        this.logMessage(format + message);
		this.logMessage("Tower says: " + format + " unregistered from weather tower.\n");
		int longitude = coordinates.getLongitude();
		int latitude = coordinates.getLatitude();
		int height = coordinates.getHeight();
		this.logMessage("Current coordinates (" + longitude + ", " + latitude + ", " + height + ")\n");
    }

    protected void registerMessage() {
        this.logMessage("Tower says: " + this.genFormat() + " registered to weather tower.\n");
    }

	private long nextId() {
		return idCounter++;
	}
}
