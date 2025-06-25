import java.io.*;
import java.nio.file.*;

public class Q12{
	public static void main(String[] args){
		String fName="Q12_Text.txt";
		try (FileWriter writer=new FileWriter(fName)){
			writer.write("Hello, this is a text\n");
			writer.write("This is a very serious text");
		}
		catch(IOException ioe){
			System.out.println("Error in writing file: "+ioe.getMessage());
		}

		try (BufferedReader reader=new BufferedReader(new FileReader(fName))){
			String line;
			System.out.println("Reading the file: ");
			while ((line=reader.readLine())!=null){
				System.out.println(line);
			}
		}
		catch(IOException ioe){
			System.out.println("Error in writing file: "+ioe.getMessage());
		}

		File f=new File(fName);
		if(f.delete()) {System.out.println("File deleted Successfully");}
		else {System.out.println("File not deleted");}
	}
}