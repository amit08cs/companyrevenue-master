package reader.reader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import spientFeesCalculator_master.Transaction;

/**
 * 
 * @author saurabhsharma01
 *
 */
public abstract class AbstractTransactionReader {

	/**
	 * 
	 */
	static  public List<Transaction> transactionList;

	/**
	 * 
	 */
	public abstract void readTransaction(File transactionFile);

	/**
	 * This method will save the transaction into list.
	 * later on in database.
	 * @param transaction
	 */
	public void saveTransaction(Transaction transaction){

		if(transactionList==null){
			transactionList = new ArrayList<Transaction>();
		}

		transactionList.add(calculateTransactionFee(transaction));

	}

	/**
	 * This method will be update the fee according to transaction.
	 * @param transaction
	 */
	private Transaction calculateTransactionFee(Transaction transaction) {
/*		if(isIntradayTransaction(transaction)){
			transaction.setTransactionFees(TRANSACTIONFEES.TEN.getFees());
		} else {

			if(transaction.getPriority()){
				transaction.setTransactionFees(TRANSACTIONFEES.FIVE_HUNDREAD.getFees());

			} else{				
				if(transaction.getTransactionType() == TRANSACTIONTYPE.SELL.getType() ||
						transaction.getTransactionType() == TRANSACTIONTYPE.WITHDRAW.getType()){

					transaction.setTransactionFees(TRANSACTIONFEES.HUNDREAD.getFees());

				} else if(transaction.getTransactionType() == TRANSACTIONTYPE.BUY.getType() ||
						transaction.getTransactionType() == TRANSACTIONTYPE.DEPOSIT.getType()){

					transaction.setTransactionFees(TRANSACTIONFEES.FIFTY.getFees());			
				}

			}

		}*/
		return transaction;
	}

	/**
	 * This method cheack weather transction is IntraDay or not.
	 * @param transaction
	 * @return
	 */
	private boolean isIntradayTransaction(Transaction transaction) {/*
		boolean isIntraDayTransaction= false;
		Transaction temp = null;
		if(transactionList.size() > 0 ){
			for (Transaction trans : transactionList) {
				if(trans.getClientId().equals(transaction.getClientId())&&
						trans.getSecurityId().equals(transaction.getSecurityId()) &&
						trans.getTransactionDate().equals(transaction.getTransactionDate())){
					if((trans.getTransactionType()==TRANSACTIONTYPE.BUY.getType() && 
							transaction.getTransactionType()==TRANSACTIONTYPE.SELL.getType()) ||
							(trans.getTransactionType()==TRANSACTIONTYPE.SELL.getType() && 
							transaction.getTransactionType()==TRANSACTIONTYPE.BUY.getType())){
						isIntraDayTransaction= true;
						temp= trans;						
						break;
					}
				}

			}

			if(temp!=null){
				transactionList.remove(temp);
				temp.setTransactionFees(TRANSACTIONFEES.TEN.getFees());
				transactionList.add(temp);
			}

		} else {
			isIntraDayTransaction= false;
		}

		return isIntraDayTransaction;
	*/
		return true;
		}

	/**
	 * 
	 * @param transactionAttributes
	 * @return
	 */
	public Transaction getTransaction(String[] transactionAttributes) {	
		for (String string : transactionAttributes) {
			System.out.print(" "+string);
		}
		Transaction transaction = new Transaction();
		transaction.setExternalTransactionID(transactionAttributes[0]);
		transaction.setCompanyName(transactionAttributes[1]);
		transaction.setRevanue(transactionAttributes[2]);
		transaction.setYear(transactionAttributes[3]);
		return transaction;
	}
}
