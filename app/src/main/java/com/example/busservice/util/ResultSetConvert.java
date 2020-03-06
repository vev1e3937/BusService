package com.example.busservice.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Fluke
 */
public class ResultSetConvert {

    /**
     * Convert ResultSet query data into an ArrayList
     * with Header is an column name
     * @param resultSet
     * @return lstData
     * @throws SQLException
     */
    public static List ConvertToList(ResultSet resultSet) throws SQLException {
        List lstData = new ArrayList(); // Initialize list to collect data
        ResultSetMetaData metaData = resultSet.getMetaData(); // Get MetaData from ResultSet that fetch into method
        int colLength = metaData.getColumnCount(); // Get column length from meta data

        // Begin parsing data
        while (resultSet.next()) {
            HashMap hashTemp = new HashMap(); // Initialize HashMap for insert data with header
            // Begin loop for get data in each column length
            for (int loop = 1; loop <= colLength; loop++) {
                String colName = metaData.getColumnLabel(loop); // Get column name
                hashTemp.put(colName, resultSet.getObject(loop)); // Put data into HashMap with colName as header and ResultSet data
            }
            lstData.add(hashTemp); // And insert HashMap data into List every parse of query
        }
        return lstData; // Send List back from request
    }

    public static HashMap ConvertToMap(ResultSet resultSet) throws SQLException {
        HashMap mapping = new HashMap();
        ResultSetMetaData metaData = resultSet.getMetaData(); // Get MetaData from ResultSet that fetch into method
        int colLength = metaData.getColumnCount(); // Get column length from meta data

        // Begin parsing data
        while (resultSet.next()) {
             // Initialize HashMap for insert data with header
            // Begin loop for get data in each column length
            for (int loop = 1; loop <= colLength; loop++) {
                String colName = metaData.getColumnLabel(loop); // Get column name
                mapping.put(colName, resultSet.getObject(loop)); // Put data into HashMap with colName as header and ResultSet data
            }
        }
        return mapping; // Send List back from request
    }

}
