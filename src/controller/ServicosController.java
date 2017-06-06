package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class ServicosController {

	public ServicosController() {
		super();
	}

	public void servicos() throws IOException {
		String cmd = "sc queryex type= service state= all";
		Process p = Runtime.getRuntime().exec(cmd);
		InputStream is = p.getInputStream();
		FileOutputStream os = new FileOutputStream(new File(
				"C:\\TEMP\\servicos.txt"));

		int read = 0;
		byte[] bytes = new byte[1024];

		while ((read = is.read(bytes)) != -1) {
			os.write(bytes, 0, read);
		}

		System.out.println("Feito!");
		is.close();
		os.close();
	}

	public void enableService(String service) throws IOException {
		String cmd = "sc config " + service + " start= demand";
		Process p = Runtime.getRuntime().exec(cmd);
		InputStream is = p.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String linha = br.readLine();
		StringBuffer sb = new StringBuffer();
		while (linha != null) {
			sb.append(linha);
			linha = br.readLine();
		}
		JOptionPane.showMessageDialog(null, sb.toString(), "Saída",
				JOptionPane.INFORMATION_MESSAGE);
		br.close();
		isr.close();
		is.close();
	}

	public void startService(String service) throws IOException {
		String cmd = "net start " + service;
		Process p = Runtime.getRuntime().exec(cmd);
		InputStream is = p.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String linha = br.readLine();
		StringBuffer sb = new StringBuffer();
		while (linha != null) {
			sb.append(linha);
			linha = br.readLine();
		}
		br.close();
		isr.close();
		is.close();
	}

	
}
