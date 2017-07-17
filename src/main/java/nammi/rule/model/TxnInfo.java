package nammi.rule.model;

import java.io.Serializable;
import java.util.Date;

public class TxnInfo implements Serializable {
	private static final long serialVersionUID = 5682558089786240010L;
	private Long txnAmount;
	private String cardholderName;
	private String bankCardNo;
	private Date txnTime;
	
	
	public Long getTxnAmount() {
		return txnAmount;
	}
	public void setTxnAmount(Long txnAmount) {
		this.txnAmount = txnAmount;
	}
	public String getCardholderName() {
		return cardholderName;
	}
	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}
	public String getBankCardNo() {
		return bankCardNo;
	}
	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}
	public Date getTxnTime() {
		return txnTime;
	}
	public void setTxnTime(Date txnTime) {
		this.txnTime = txnTime;
	}
	
	
}
