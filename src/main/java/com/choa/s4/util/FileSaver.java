package com.choa.s4.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	
	// MultipartFile transferTo
	public String saveTransfer(File dest, MultipartFile multipartFile)throws Exception {
		
		if(!dest.exists()) {
			dest.mkdirs();
		}
		
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		
		dest = new File(dest, fileName);
		
		multipartFile.transferTo(dest);
		
		return fileName;
	}
	
	
	
	// FileCopyUtil.copy
	public String saveCopy(File dest, MultipartFile multipartFile)throws Exception{
		
		if(!dest.exists()) {
			dest.mkdirs();
		}
		
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		
		dest = new File(dest, fileName);
		
		FileCopyUtils.copy(multipartFile.getBytes(), dest);
	
		return fileName;
	}

}
