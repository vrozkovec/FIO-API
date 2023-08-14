
package cz.fio.api.client.pojo;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info implements Serializable
{

	@SerializedName("accountId")
	@Expose
	private String accountId;
	@SerializedName("bankId")
	@Expose
	private String bankId;
	@SerializedName("currency")
	@Expose
	private String currency;
	@SerializedName("iban")
	@Expose
	private String iban;
	@SerializedName("bic")
	@Expose
	private String bic;
	@SerializedName("openingBalance")
	@Expose
	private Double openingBalance;
	@SerializedName("closingBalance")
	@Expose
	private Double closingBalance;
	@SerializedName("dateStart")
	@Expose
	private String dateStart;
	@SerializedName("dateEnd")
	@Expose
	private String dateEnd;
	@SerializedName("yearList")
	@Expose
	private Object yearList;
	@SerializedName("idList")
	@Expose
	private Object idList;
	@SerializedName("idFrom")
	@Expose
	private Long idFrom;
	@SerializedName("idTo")
	@Expose
	private Long idTo;
	@SerializedName("idLastDownload")
	@Expose
	private Object idLastDownload;
	private final static long serialVersionUID = -4510921473052406678L;

	public String getAccountId()
	{
		return accountId;
	}

	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}

	public Info withAccountId(String accountId)
	{
		this.accountId = accountId;
		return this;
	}

	public String getBankId()
	{
		return bankId;
	}

	public void setBankId(String bankId)
	{
		this.bankId = bankId;
	}

	public Info withBankId(String bankId)
	{
		this.bankId = bankId;
		return this;
	}

	public String getCurrency()
	{
		return currency;
	}

	public void setCurrency(String currency)
	{
		this.currency = currency;
	}

	public Info withCurrency(String currency)
	{
		this.currency = currency;
		return this;
	}

	public String getIban()
	{
		return iban;
	}

	public void setIban(String iban)
	{
		this.iban = iban;
	}

	public Info withIban(String iban)
	{
		this.iban = iban;
		return this;
	}

	public String getBic()
	{
		return bic;
	}

	public void setBic(String bic)
	{
		this.bic = bic;
	}

	public Info withBic(String bic)
	{
		this.bic = bic;
		return this;
	}

	public Double getOpeningBalance()
	{
		return openingBalance;
	}

	public void setOpeningBalance(Double openingBalance)
	{
		this.openingBalance = openingBalance;
	}

	public Info withOpeningBalance(Double openingBalance)
	{
		this.openingBalance = openingBalance;
		return this;
	}

	public Double getClosingBalance()
	{
		return closingBalance;
	}

	public void setClosingBalance(Double closingBalance)
	{
		this.closingBalance = closingBalance;
	}

	public Info withClosingBalance(Double closingBalance)
	{
		this.closingBalance = closingBalance;
		return this;
	}

	public String getDateStart()
	{
		return dateStart;
	}

	public void setDateStart(String dateStart)
	{
		this.dateStart = dateStart;
	}

	public Info withDateStart(String dateStart)
	{
		this.dateStart = dateStart;
		return this;
	}

	public String getDateEnd()
	{
		return dateEnd;
	}

	public void setDateEnd(String dateEnd)
	{
		this.dateEnd = dateEnd;
	}

	public Info withDateEnd(String dateEnd)
	{
		this.dateEnd = dateEnd;
		return this;
	}

	public Object getYearList()
	{
		return yearList;
	}

	public void setYearList(Object yearList)
	{
		this.yearList = yearList;
	}

	public Info withYearList(Object yearList)
	{
		this.yearList = yearList;
		return this;
	}

	public Object getIdList()
	{
		return idList;
	}

	public void setIdList(Object idList)
	{
		this.idList = idList;
	}

	public Info withIdList(Object idList)
	{
		this.idList = idList;
		return this;
	}

	public Long getIdFrom()
	{
		return idFrom;
	}

	public void setIdFrom(Long idFrom)
	{
		this.idFrom = idFrom;
	}

	public Info withIdFrom(Long idFrom)
	{
		this.idFrom = idFrom;
		return this;
	}

	public Long getIdTo()
	{
		return idTo;
	}

	public void setIdTo(Long idTo)
	{
		this.idTo = idTo;
	}

	public Info withIdTo(Long idTo)
	{
		this.idTo = idTo;
		return this;
	}

	public Object getIdLastDownload()
	{
		return idLastDownload;
	}

	public void setIdLastDownload(Object idLastDownload)
	{
		this.idLastDownload = idLastDownload;
	}

	public Info withIdLastDownload(Object idLastDownload)
	{
		this.idLastDownload = idLastDownload;
		return this;
	}

}
