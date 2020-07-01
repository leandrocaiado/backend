package br.com.prevent.service;

import java.awt.List;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import br.com.prevent.entity.Log;
import br.com.prevent.exceptions.InvalidException;


public interface LogService {
	
	boolean create(br.com.prevent.entity.Log log,String nomeArquivo) throws InvalidException;
	
	
	Iterable<Log> findByHoraAndIpAndData(String ip, Date data, String hora);


	boolean existsByNome(String nomeArquivo);
	
	


}
