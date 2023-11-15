package ImageDownloader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageDownloader {

	public static void main(String[] args) throws Exception {
		// Path to the file containing image URLs
		String filePath = "path/url.txt";

		// Folder where images will be downloaded
		String folderPath = "imagesPath";

		try {
			// Create the folder if it does not exist
			createFolderIfNotExists(folderPath);

			// Read the URLs from the file and download each image
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(Files.newInputStream(Paths.get(filePath))));
			String line;

			while ((line = reader.readLine()) != null) {
				downloadImage(line, folderPath);
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Download finished");
	}

	// Create a folder if it does not exist
	private static void createFolderIfNotExists(String folderPath) throws IOException {
		Path path = Paths.get(folderPath);

		if (!Files.exists(path)) {
			Files.createDirectory(path);
		}
	}

	// Download an image from a given URL and save it to the specified folder
	private static void downloadImage(String imageUrl, String folderPath) {
		try {
			URL url = new URL(imageUrl);
			URLConnection connection = url.openConnection();
			InputStream inputStream = connection.getInputStream();

			// Extract the file name from the URL
			String fileName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);

			// Construct the local file path
			String filePath = folderPath + File.separator + fileName;

			// Create a FileOutputStream to write the image data to the local file
			FileOutputStream outputStream = new FileOutputStream(filePath);
			byte[] buffer = new byte[2048];
			int length;

			// Read from the input stream and write to the output stream in chunks
			while ((length = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, length);
			}

			// Close streams
			inputStream.close();
			outputStream.close();

			System.out.println("Image downloaded: " + fileName);
		} catch (IOException e) {
			System.err.println("Error downloading image from URL: " + imageUrl);
			e.printStackTrace();
		}
	}
}
