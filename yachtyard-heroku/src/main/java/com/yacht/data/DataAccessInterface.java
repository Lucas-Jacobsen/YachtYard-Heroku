package com.yacht.data;

public interface DataAccessInterface <T>
{
	public T getById(int id);
	public Iterable<T> getAll();
	public T create(T item);
	public T update(T item);
	public boolean deleteById(int id);
	
	
}
