
package cz.fio.api.client.pojo;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountStatement implements Serializable
{

	@SerializedName("info")
	@Expose
	private Info info;
	@SerializedName("transactionList")
	@Expose
	private TransactionList transactionList;
	private final static long serialVersionUID = -5821197409503711458L;

	public Info getInfo()
	{
		return info;
	}

	public void setInfo(Info info)
	{
		this.info = info;
	}

	public AccountStatement withInfo(Info info)
	{
		this.info = info;
		return this;
	}

	public TransactionList getTransactionList()
	{
		return transactionList;
	}

	public void setTransactionList(TransactionList transactionList)
	{
		this.transactionList = transactionList;
	}

	public AccountStatement withTransactionList(TransactionList transactionList)
	{
		this.transactionList = transactionList;
		return this;
	}

}
