import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TextWriter {

	
	// TextWriter constructor
	public TextWriter() {

	}
	
	// allows a user to append to a given file
	// inputs: path is the file path
	public void appendText(String path, String text) throws IOException {
		// checks if the file exists and if not creates one
		fileExists(path);
		
		// need bufferedWriter for PrintWriter and need a FileWriter for a BufferedWriter
		FileWriter writer = new FileWriter(path, true);
		BufferedWriter bfWriter = new BufferedWriter(writer);
		PrintWriter pWriter = new PrintWriter(bfWriter);
		
		// appends the text to the file
		pWriter.println();
		pWriter.print(text);
		pWriter.close();
	}
	
	// creates the requested file if it does not exist
	public void fileExists(String path) throws IOException{
		File yourFile = new File(path);
		if(!yourFile.exists()) {
			yourFile.createNewFile();
			System.out.println("File created at " + path);
		} 
	}
	
}
