```markdown
# Image Downloader and List Images

## Description
This Java project consists of two programs: ImageDownloader and ListImages. The ImageDownloader downloads images from a list of URLs, and the ListImages program lists the names of JPG files in a specified folder.

## ImageDownloader

### Usage
1. Prepare a text file (`url.txt`) containing a list of image URLs, with each URL on a new line.
2. Run the `ImageDownloader` program, providing the path to the URL file and the destination folder for downloaded images as command-line arguments.

```bash
java ImageDownloader.ImageDownloader path/url.txt imagesPath
```

### Functionality
- Downloads images from URLs listed in the specified file.
- Saves the downloaded images in the specified folder.

### Example
```bash
java ImageDownloader.ImageDownloader path/url.txt imagesPath
```

## ListImages

### Usage
1. Ensure that images are stored in the specified folder (`imagesPath`).
2. Run the `ListImages` program to list the names of JPG files in the folder.

```bash
java ImageDownloader.ListImages
```

### Functionality
- Lists the names of JPG files in the specified folder.
- Saves the list to a text file (`imagesList.txt`).

### Example
```bash
java ImageDownloader.ListImages
```

## Dependencies
- Java SE Development Kit (JDK) 8 or later

## Author
Leonel Julian Fernandes
