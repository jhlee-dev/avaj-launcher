import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite{
	public static void main(String[] args) {
		
		String h ="Hello\n";
		try {
			File myObj = new File("filename.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
			//FileWriter myWriter = new FileWriter("filename.txt");
			//myWriter.write("Files in Java\n");
			//myWriter.close();

			FileWriter myWriter2 = new FileWriter("filename.txt", true);
			myWriter2.write(h);
			myWriter2.close();

			String str = "Hello";
			String[] arr = str.split(" ", 0);
			System.out.println(arr.length);
			String str2 = "Hello  ";
			String[] arr2 = str2.split(" ", 0);
			System.out.println(arr2.length);
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
