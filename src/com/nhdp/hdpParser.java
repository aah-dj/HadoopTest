package com.nhdp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class hdpParser {

	public static void main(String[] args) {
		System.out.println("start");
		String workingPath = "/Users/muzhumbp13/Documents/usr/Nielsen/nhdp/";
		String filename = workingPath + "mconnectsboxHadoop.log";
		Path outfile = Paths.get(workingPath + "mconnectsboxHadoop.csv");
		ParseFile(filename, outfile);
	}

	public static void ParseFile(String name, Path outFile) {
		try {
			// Writing to file
			BufferedWriter writer = Files.newBufferedWriter(outFile,
					Charset.defaultCharset());

			Path path = FileSystems.getDefault().getPath("", name);
			InputStream in = Files.newInputStream(path);
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			String line = null;
			while ((line = reader.readLine()) != null) {
				// System.out.println(line);
				if (!line.matches("^d.*")) {
					String[] s = (line.split(" "));
					for (int i = 0; i < s.length - 1; i++) {
//						System.out.print(s[i] + ",");
						writer.append(s[i] + ",");
					}
//					System.out.println(s[s.length - 1]);
					writer.append(s[s.length - 1]);
					writer.newLine();

				}
				
				// return lines;
			}
			writer.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	
		// return null;
	}
}
