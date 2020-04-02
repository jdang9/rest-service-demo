package com.demo.rest_service.upload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

@Path("/fileservice")
public class FileService {

	//Enter location + file name here
	//This will be a user input or just simply copy from original source name
	//In this case, it will just be static name
	private static final String FILE_PATH = ""; 
	
	@Path("/upload")
	@POST
	public void upload(List<Attachment> attachments) throws FileNotFoundException, IOException {
		for (Attachment a : attachments) {
			copyFile(a.getDataHandler().getInputStream());
		}
	}

	private void copyFile(InputStream inputStream) throws FileNotFoundException, IOException {
		OutputStream out = null;
		int read = 0;
		byte[] bytes = new byte[1024];

		out = new FileOutputStream(new File(FILE_PATH));
		while ((read = inputStream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		out.flush();
		out.close();	
	}

}