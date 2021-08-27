package gov.hhs.acf.cb.nytds.util;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper Class to do hold the common functions used throughout.
 * 
 * 
 * @author Satinder Gill
 * @version $Revision: 1.0 $ $Date: 7/23/2009 $
 */
@Deprecated
public class CommonFunctions
{
	protected static Logger log = Logger.getLogger(CommonFunctions.class);

	/**
	 * Ensure the existance of a directory.
	 * 
	 * @param directory directory to ensure exists
	 * @throws IOException directory doesn't exist and can't be created
	 */
	public static void mkdir(File directory) throws IOException
	{
		if (directory.isDirectory())
		{
			return;
		}
		if (directory.exists() && !directory.isDirectory())
		{
			throw new IOException(String.format("%s already exists but is not a directory.", directory.getAbsolutePath()));
		}
		boolean creationSuccessful;
		creationSuccessful = directory.mkdirs();
		if (!creationSuccessful)
		{
			throw new IOException(String.format("Unable to create directory %s.", directory.getAbsolutePath()));
		}
	}

	/**
	 * Convert a Boolean to an Integer.
	 */
	public static Integer booleanToInt(Boolean value)
	{
		assert (value != null);
		return value.booleanValue() ? 1 : 0;
	}

	/**
	 * Returns a string which is the concatenation of the strings in the given
	 * collection.
	 * 
	 * @param separator
	 *           the separator between elements.
	 * @param collection
	 *           the collection to concatenate
	 * @return string which is the concatenation of the strings in the given
	 *         collection
	 */
	public static String join(String separator, Collection<String> collection)
	{
		if (collection.isEmpty())
		{
			return "";
		}

		StringBuilder stringBuilder = new StringBuilder();

		for (String i : collection)
		{
			stringBuilder.append(i + separator);
		}

		stringBuilder.delete(stringBuilder.length() - separator.length(), stringBuilder.length());

		return stringBuilder.toString();
	}


	/**
	 * Given a list of Object arrays of length 2, return a Map with String keys
	 * and values. This is intended to be used to convert Hibernate Query results
	 * into maps suitable for use in Struts select tags, i.e., an id and some
	 * text.
	 * 
	 * @param queryResult
	 *           Hibernate Query result
	 * @return string key/value map
	 */
	public static Map<String, String> getSelectMapFromQueryResult(List<Object[]> queryResult)
	{
		Map<String, String> selectMap = new LinkedHashMap<>();

		for (Object[] pair : queryResult)
		{
			assert (pair.length == 2);
			selectMap.put(String.valueOf(pair[0]), String.valueOf(pair[1]));
		}

		return selectMap;
	}
}