
package cz.fio.api.client.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import cz.fio.api.util.pojo.IValue;

public class KodBanky implements IValue<String>
{

	@SerializedName("value")
	@Expose
	private String value;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("id")
	@Expose
	private Long id;
	private final static long serialVersionUID = -4010430926417541989L;

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public KodBanky withValue(String value)
	{
		this.value = value;
		return this;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public KodBanky withName(String name)
	{
		this.name = name;
		return this;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public KodBanky withId(Long id)
	{
		this.id = id;
		return this;
	}

}
