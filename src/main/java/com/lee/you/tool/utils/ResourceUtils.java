package com.lee.you.tool.utils;

import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;

public final class ResourceUtils
{
	public static InputStream getResource(String file)
	{
		if (StringUtils.isBlank(file))
		{
			System.out.println("文件为空");
			return null;
		}
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		return classLoader.getResourceAsStream(file);
	}
}
