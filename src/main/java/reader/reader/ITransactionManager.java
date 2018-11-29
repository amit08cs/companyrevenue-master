package reader.reader;

import java.io.File;
import java.io.IOException;

import spientFeesCalculator_master.Constant.FILETYPE;

/**
 * 
 * @author saurabhsharma01
 *
 */
public interface ITransactionManager {

	public void displayTransactionReport();

	public ITransactionManager readFile(FILETYPE fileType);
	public void saveFile(File fileName) throws IOException;
	
}
