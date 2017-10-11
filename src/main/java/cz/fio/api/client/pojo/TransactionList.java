
package cz.fio.api.client.pojo;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransactionList implements Serializable
{

	@SerializedName("transaction")
	@Expose
	private List<Transaction> transaction = null;
	private final static long serialVersionUID = 3048009453799694749L;

	public List<Transaction> getTransaction()
	{
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction)
	{
		this.transaction = transaction;
	}

	public TransactionList withTransaction(List<Transaction> transaction)
	{
		this.transaction = transaction;
		return this;
	}

}
