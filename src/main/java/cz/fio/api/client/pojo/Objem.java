
package cz.fio.api.client.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import cz.fio.api.util.pojo.IValue;

public class Objem implements IValue<Double>
{

	@SerializedName("value")
	@Expose
	private Double value;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("id")
	@Expose
	private Long id;
	private final static long serialVersionUID = 6296077280754280269L;

	public Double getValue()
	{
		return value;
	}

	public void setValue(Double value)
	{
		this.value = value;
	}

	public Objem withValue(Double value)
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

	public Objem withName(String name)
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

	public Objem withId(Long id)
	{
		this.id = id;
		return this;
	}

}
