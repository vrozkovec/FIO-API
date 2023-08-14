package cz.fio.api.util.pojo;

import java.io.Serializable;

public interface IValue<T> extends Serializable
{
	T getValue();
}
