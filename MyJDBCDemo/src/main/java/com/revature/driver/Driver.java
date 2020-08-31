package com.revature.driver;

import java.sql.SQLException;

import com.revature.daoimpl.AlbumDaoImpl;

public class Driver {

	public static void main(String[] args) {
		AlbumDaoImpl adi= new AlbumDaoImpl();
		
		try {
			System.out.println(adi.getAllAlbums());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
