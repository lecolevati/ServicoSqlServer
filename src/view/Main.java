package view;

import java.io.IOException;

import controller.ServicosController;

public class Main {

	public static void main(String[] args) {
		ServicosController sc = new ServicosController();
		String service = "MSSQLSERVER";
		try {
			sc.enableService(service);
			sc.startService(service);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		try {
//			sc.servicos();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}

}
