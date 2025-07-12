package playwrightsessions;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

import java.io.*;



public class FileUploadHandle {
	
	public static void main(String args[]) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		//input[type=file] => the input element must be in this format
		//to add one file
		page.setInputFiles("input#filesToUpload",Paths.get("pom.xml"));
		//to remove one file
		page.setInputFiles("input#filesToUpload",new Path[0]);
		
		//input multiple files
		page.setInputFiles("input#filesToUpload",new Path[] {
				Paths.get("pom.xml"),
				Paths.get("trace.zip")
		});
		
		//to remove all files uploaded
		page.setInputFiles("input#filesToUpload",new Path[0]);
		//run time create file and upload
		page.setInputFiles("input#filesToUpload", new FilePayload("Hari.txt","text/plain","This is Hari".getBytes(StandardCharsets.UTF_8)));


	    
	}

}
