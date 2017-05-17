package com.lee.you.tool.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class JdbcUtils
{
	private static String driverClass = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	private static Connection conn = null;
	
	private static final Object object = new Object();
	
	static
	{
		try
		{
			InputStream in = ResourceUtils.getResource("jdbc.properties");
			Properties ppt = new Properties();
			ppt.load(in);
			
			driverClass = ppt.getProperty("jdbc.driverClassName");
			url = ppt.getProperty("jdbc.url");
			username = ppt.getProperty("jdbc.username");
			password = ppt.getProperty("jdbc.password");
			
			Class.forName(driverClass);
		} catch (ClassNotFoundException e)
		{
			System.out.println("jdbc.properties没找到");
		} catch (IOException e)
		{
			System.out.println("mysql驱动加载失败");
		}
	}
	
	public static Connection getConnection()
	{
		if (null == conn)
		{
			synchronized (object)
			{
				if (null == conn)
				{
					try
					{
						conn = DriverManager.getConnection(url, username, password);
					} catch (SQLException e)
					{
						System.out.println("数据库连接获取异常");
					}
				}
			}
		}
		return conn;
	}
}
