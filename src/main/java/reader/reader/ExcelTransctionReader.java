package reader.reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

import spientFeesCalculator_master.Constant.FILETYPE;
import spientFeesCalculator_master.Transaction;


public class ExcelTransctionReader extends AbstractTransactionReader implements ITransactionManager {


	@Override
	public void readTransaction(File transactionFile) {

		
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = "\t";
		

		try {

			br = new BufferedReader(new FileReader(transactionFile));
			while ((line = br.readLine()) != null) {
				String[] transactionAttributes = line.split(cvsSplitBy);
				Transaction transaction = getTransaction(transactionAttributes); 
				saveTransaction(transaction);

			}		 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}	

	@Override
	public ITransactionManager readFile(FILETYPE fileType) {
		if(fileType == FILETYPE.CSV){
			return TrasactionReader.getTrasactionReaderInstance().readExcelFile();
		}
		return null;
	}
	public void displayTransactionReport(){
		Collections.sort(transactionList,new Transaction());
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println(" Id | company | revanue | year |");
		for (Transaction transaction : transactionList) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println(transaction.getExternalTransactionID()+"\t| "+transaction.getCompanyName()+"\t| "+
					transaction.getRevanue()+"\t| "+(transaction.getYear()));
		}
		System.out.println("--------------------------------------------------------------------------------");
	}
	
	
	@Override
	public void saveFile(File fileName) throws IOException {
		try(BufferedWriter out = new BufferedWriter(new FileWriter(fileName)))
		{
			for(Transaction transaction : transactionList){
					out.write(transaction.getExternalTransactionID()+"\t"+transaction.getCompanyName()+"\t"+
							transaction.getRevanue()+"\t"+(transaction.getYear())+"\t");
				out.write("\n");
			}
			System.out.println("File saved Successfully to" + fileName);
		}
	}

}
