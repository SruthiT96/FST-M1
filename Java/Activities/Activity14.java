package activities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

public class Activity14 {
public static void main(String[] args) throws IOException {
	try {
		File file = new File("src/main/java/examples/HelloWorld.java");
		boolean fStatus = file.createNewFile();
		if(fStatus) {
			System.out.println("file creation is successful");
			FileUtils.writeStringToFile(file, "Some text in a file", Charset.defaultCharset());
		}else {
			System.out.println("File already exists at this path.");
		}
		//Read string from file
		System.out.println("Data in file: " + FileUtils.readFileToString(file, "UTF8"));
		//Create directory
		File destDir = new File("src/main/resources/destDir");
		//Copy file to directory
		FileUtils.copyFileToDirectory(file, destDir);
		
		//Get file from new directory
		File newFile = FileUtils.getFile(destDir, "newfile.txt");
		//Read data from file
		String newFileData = FileUtils.readFileToString(newFile, "UTF8");
		
		System.out.println("Data in new file: " + newFileData);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
}
}
