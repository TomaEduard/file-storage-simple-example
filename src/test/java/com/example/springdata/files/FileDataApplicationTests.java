package com.example.springdata.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springdata.files.entities.Image;
import com.example.springdata.files.repos.ImageRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileDataApplicationTests {

	@Autowired
	ImageRepository imageRepository;

	@Test
	public void testImageSave() throws IOException {
		Image image = new Image();
		image.setId(1);
		image.setName("WallpaperStudio10-19841.jpg");
		File file = new File("C:/Users/eduar/Documents/images/WallpaperStudio10-19841.jpg");
		byte fileContent[] = new byte[(int) file.length()];
		FileInputStream inputStream = new FileInputStream(file);
		inputStream.read(fileContent);

		image.setData(fileContent);
		imageRepository.save(image);
		inputStream.close();
	}

	@Test
	public void testReadImage() {
		Image image = imageRepository.findById(1L).get();

		File file = new File("C:/Users/eduar/Documents/images/download/" + image.getName());
		FileOutputStream fileOutputStream = null;
		
		try {
			fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(image.getData());

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileOutputStream.close();
			} catch (Exception e) {
				
			}
		}

	}

}
