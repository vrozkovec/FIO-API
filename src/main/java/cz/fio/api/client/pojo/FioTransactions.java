
package cz.fio.api.client.pojo;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FioTransactions implements Serializable
{

	@SerializedName("accountStatement")
	@Expose
	private AccountStatement accountStatement;
	private final static long serialVersionUID = -3899826784987188985L;

	public AccountStatement getAccountStatement()
	{
		return accountStatement;
	}

	public void setAccountStatement(AccountStatement accountStatement)
	{
		this.accountStatement = accountStatement;
	}

	public FioTransactions withAccountStatement(AccountStatement accountStatement)
	{
		this.accountStatement = accountStatement;
		return this;
	}

}
