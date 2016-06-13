package br.ufc.quixada.tcc.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;

import org.graphast.config.Configuration;
import org.graphast.importer.OSMImporterImpl;
import org.graphast.model.Graph;
import org.graphast.model.GraphBounds;
import org.graphast.model.GraphImpl;

import br.ufc.quixada.tcc.pbfReader.Reader2;

public class TestImport {
	
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		
		TestImport t = new TestImport();
		 String graphastTmpDir = Configuration.USER_HOME + "/graphast/tmp/osmimporter";

		// OSMImporterImpl test = new OSMImporterImpl("berlin_small_slice.osm.pbf", graphastTmpDir);
		// GraphBounds bounds = test.execute();
		//bounds.save();
		 
		
	
	File file = new File(Configuration.USER_HOME + "/andorra-latest.osm.pbf");
	if(file != null){
		 Reader2 r = new Reader2(file, graphastTmpDir);
		 
		 GraphBounds bounds = r.execute();
		 bounds.save();
	} 
		
		 
		 Graph graph = new GraphImpl(Configuration.USER_HOME + "/graphast/tmp/osmimporter");
		graph.load();
	}
	public File createDataFile(String dataFileName) {
		try {
			BufferedReader dataReader;
			BufferedWriter dataWriter;
			File tmpFile;
			String line;

			// Open the data template file.
			dataReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(
					 dataFileName)));
			
			
			// Create a temporary file and open it.
			tmpFile = new File(Configuration.USER_HOME, dataFileName);
			dataWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tmpFile)));

			// Copy all data into the temp file replacing the version string.
			while ((line = dataReader.readLine()) != null) {
				dataWriter.write(line);
				dataWriter.newLine();
			}

			dataReader.close();
			dataWriter.close();

			return tmpFile;
		} catch (IOException e) {
			
		}
		return null;
	}


}
