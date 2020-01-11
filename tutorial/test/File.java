import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite{
	public static void main(String[] args) {
		try {
			File myObj = new File("filename.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
			FileWriter myWriter = new FileWriter("filename.txt");
			myWriter.write("Files in Java");
			myWriter.close();

			FileWriter myWriter2 = new FileWriter("filename.txt", true);
			myWriter.write("Files in Java2");
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
