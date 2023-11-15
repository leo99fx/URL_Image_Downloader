package ImageDownloader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ListImages {

	public static void main(String[] args) throws Exception {
		// Path to the folder containing images
		String imagesFolder = "imagesPath/";

		// Create a File object for the images folder
		File folder = new File(imagesFolder);

		// Check if the folder exists and is a directory
		if (folder.exists() && folder.isDirectory()) {

			// List all files in the folder
			File[] files = folder.listFiles();

			// Path to the output file listing image names
			String outputFile = "path/imagesList.txt";

			try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
				// Iterate through files in the folder
				for (File file : files) {
					// Check if it's a file and has a ".jpg" extension
					if (file.isFile() && file.getName().toLowerCase().endsWith(".jpg")) {
						// Get the file name
						String fileName = file.getName();

						// Print the file name to the console
						System.out.println(fileName);

						// Write the file name to the output file
						writer.println(fileName);
					}
				}

				// Print a message indicating the completion of the listing
				System.out.println("Listing saved in " + outputFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// Print a message if the folder does not exist or is not a valid directory
			System.out.println("The folder does not exist or is not a valid directory.");
		}
	}
}
