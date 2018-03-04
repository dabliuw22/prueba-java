package com.leysoft.app.services.imple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leysoft.app.entitys.CSVFile;
import com.leysoft.app.models.Labor;
import com.leysoft.app.models.Persona;
import com.leysoft.app.services.inter.CSVFileService;
import com.leysoft.app.services.inter.ReadFileService;

@Service
public class ReadFileServiceImp implements ReadFileService {
	
	@Autowired
	private CSVFileService csvFileService;

	@Override
	public List<Persona> read() throws IOException {
		List<CSVFile> csvFiles = csvFileService.findAll();
		List<Persona> list = new ArrayList<>();
		for(CSVFile csv: csvFiles) {
			BufferedReader br = new BufferedReader(new FileReader(Paths.get("files").resolve(csv.getName()).toAbsolutePath().toFile()));
			String line = br.readLine();
			int c = 0;
			while(line != null) {
				if(c > 0) {
					String[] fields = line.split(";");
					Persona p = new Persona(fields[1]);
					String[] fecha = fields[0].split("/"); 
					Labor l = new Labor(new String[] {fecha[1], fecha[2]}, Double.parseDouble(fields[4].replace(",", ".")));
					if(list.contains(p)) {
						list.forEach(x -> {
							if(x.equals(p)) {
								x.addLabor(l);
							}
						});
					} else {
						p.addLabor(l);
						list.add(p);
					}
				}
				c++;
				line = br.readLine();
			}
			br.close();
		}
		return list;
	}
}