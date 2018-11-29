package spientFeesCalculator_master;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import reader.reader.ITransactionManager;
import reader.reader.TrasactionReader;
import spientFeesCalculator_master.Constant.FILETYPE;


public class MainFeeCalculator {
	private static BufferedReader in;
	
	public static void main(String[] args){
		String fileName = "";
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			if (args.length<1){
				System.out.println("Enter path to .CSV file: ");
				fileName = in.readLine();
			} else
			{
				fileName = args[0];
			}
			if (null == fileName || fileName.trim().isEmpty()) {
				throw new Exception();
			}else {
				new MainFeeCalculator().procseeFile(fileName);
			}
		}catch(Exception e) {
			System.out.println("File doesn't exist");
		}
	}

	public  void procseeFile(String fileName) throws Exception, IOException {
		File transactionfile = new File(fileName);	
		File exportedFile = new File(transactionfile.getParent(),  fileName.substring(0, fileName.lastIndexOf("."))+"_"+Math.random()+".csv");
		ITransactionManager tranction= TrasactionReader.getTrasactionReaderInstance().readFile(FILETYPE.CSV,transactionfile);	
		if (tranction == null) {
			throw new Exception();
		}else {
			tranction.displayTransactionReport();
			tranction.saveFile(exportedFile);
		}
	}
}
