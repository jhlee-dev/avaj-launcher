package org.us._42.avaj;

import org.us._42.avaj.*;
import org.us._42.avaj.aircraft.*;
import org.us._42.avaj.exceptions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Tower {

	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		this.observers.add(0, flyable);
	}

	public void unregister(Flyable flyable) {
		int i = this.observers.indexOf(flyable);
		if (i >= 0) {
			this.observers.remove(i);
		}
	}

	protected void conditionsChanged() {
		for (int i = this.observers.size() - 1; i >= 0; i--) {
			this.observers.get(i).updateConditions();
		}
	}
}
