package reader.reader;

import java.io.File;
import java.io.IOException;

import spientFeesCalculator_master.Constant.FILETYPE;

public class XMLTransctionReader extends AbstractTransactionReader implements ITransactionManager {

	// TODO : Add Implementation
	@Override
	public void readTransaction(File transactionFile) {
		// TODO Auto-generated method stub

	}

	// TODO : Add Implementation
	@Override
	public ITransactionManager readFile(FILETYPE fileType) {
		if (fileType == FILETYPE.CSV) {
			return TrasactionReader.getTrasactionReaderInstance().readXmlFile();
		}
		return null;
	}

	// TODO : Add Implementation
	@Override
	public void saveFile(File fileName) throws IOException {
		// TODO Auto-generated method stub

	}
	// TODO : Add Implementation
	@Override
	public void displayTransactionReport() {
		// TODO Auto-generated method stub
		
	}

}
