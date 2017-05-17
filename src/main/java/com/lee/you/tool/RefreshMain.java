package com.lee.you.tool;

import java.sql.Connection;

import com.lee.you.tool.utils.JdbcUtils;

public class RefreshMain
{

	public static void main(String[] args)
	{
		Connection conn = JdbcUtils.getConnection();
	}

}
