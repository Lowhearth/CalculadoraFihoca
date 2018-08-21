package com.privalia.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface IDao <T> {
	T add (T model) throws UnsupportedOperationException, IOException;
		
	
}
