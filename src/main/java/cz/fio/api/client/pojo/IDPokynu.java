
package cz.fio.api.client.pojo;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IDPokynu implements Serializable
{

	@SerializedName("value")
	@Expose
	private Long value;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("id")
	@Expose
	private Long id;
	private final static long serialVersionUID = 6523517891094814169L;

	public Long getValue()
	{
		return value;
	}

	public void setValue(Long value)
	{
		this.value = value;
	}

	public IDPokynu withValue(Long value)
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

	public IDPokynu withName(String name)
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

	public IDPokynu withId(Long id)
	{
		this.id = id;
		return this;
	}

}
