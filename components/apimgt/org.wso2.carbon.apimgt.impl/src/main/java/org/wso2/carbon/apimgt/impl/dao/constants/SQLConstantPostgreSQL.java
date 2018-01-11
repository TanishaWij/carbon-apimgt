/*
*  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/


package org.wso2.carbon.apimgt.impl.dao.constants;

/**
 * This class holds postgre sql queries.
 */
public class SQLConstantPostgreSQL extends SQLConstants{

    public static final String GET_APPLICATIONS_PREFIX_CASESENSITVE_WITHGROUPID =
            "select distinct x.*,bl.ENABLED from (" +
                    " SELECT " +
                    "   APPLICATION_ID, " +
                    "   NAME," +
                    "   APPLICATION_TIER," +
                    "   APP.SUBSCRIBER_ID,  " +
                    "   CALLBACK_URL,  " +
                    "   DESCRIPTION, " +
                    "   APPLICATION_STATUS, " +
                    "   USER_ID, " +
                    "   GROUP_ID, " +
                    "   UUID " +
                    " FROM" +
                    "   AM_APPLICATION APP, " +
                    "   AM_SUBSCRIBER SUB  " +
                    " WHERE " +
                    "   SUB.SUBSCRIBER_ID = APP.SUBSCRIBER_ID " +
                    " AND " +
                    "   (GROUP_ID= ?  OR  (GROUP_ID='' AND LOWER (SUB.USER_ID) = LOWER(?)))" +
                    " And " +
                    "    NAME like ?" +
                    " ORDER BY $1 $2 " +
                    " offset ? limit  ? "+
                    " )x left join AM_BLOCK_CONDITIONS bl on  ( bl.TYPE = 'APPLICATION' AND bl.VALUE = concat(concat(x.USER_ID,':'),x.name)) ";


    public static final String GET_APPLICATIONS_PREFIX_NONE_CASESENSITVE_WITHGROUPID =
            "select distinct x.*,bl.ENABLED from (" +
                    "SELECT " +
                    "   APPLICATION_ID, " +
                    "   NAME," +
                    "   APPLICATION_TIER," +
                    "   APP.SUBSCRIBER_ID,  " +
                    "   CALLBACK_URL,  " +
                    "   DESCRIPTION, " +
                    "   APPLICATION_STATUS, " +
                    "   USER_ID, " +
                    "   GROUP_ID, " +
                    "   UUID " +
                    " FROM" +
                    "   AM_APPLICATION APP, " +
                    "   AM_SUBSCRIBER SUB  " +
                    " WHERE " +
                    "   SUB.SUBSCRIBER_ID = APP.SUBSCRIBER_ID " +
                    " AND " +
                    "   (GROUP_ID= ?  OR (GROUP_ID='' AND SUB.USER_ID=?))"+
                    " And "+
                    "    NAME like ?"+
                    " ORDER BY $1 $2 " +
                    " offset ? limit  ? "+
                    " )x left join AM_BLOCK_CONDITIONS bl on  ( bl.TYPE = 'APPLICATION' AND bl.VALUE = concat(concat(x.USER_ID,':'),x.name)) ";

    public static final String GET_APPLICATIONS_PREFIX_CASESENSITVE_WITH_MULTIGROUPID =
            "select distinct x.*,bl.ENABLED from (" +
                    " SELECT " +
                    "   APPLICATION_ID, " +
                    "   NAME," +
                    "   APPLICATION_TIER," +
                    "   APP.SUBSCRIBER_ID,  " +
                    "   CALLBACK_URL,  " +
                    "   DESCRIPTION, " +
                    "   APPLICATION_STATUS, " +
                    "   USER_ID, " +
                    "   GROUP_ID, " +
                    "   UUID " +
                    " FROM" +
                    "   AM_APPLICATION APP, " +
                    "   AM_SUBSCRIBER SUB  " +
                    " WHERE " +
                    "   SUB.SUBSCRIBER_ID = APP.SUBSCRIBER_ID " +
                    " AND (" +
                    "    (APPLICATION_ID IN ( SELECT APPLICATION_ID FROM AM_APPLICATION_GROUP_MAPPING WHERE GROUP_ID IN ($params) AND TENANT = ?)) " +
                    "           OR " +
                    "    (LOWER (SUB.USER_ID) = LOWER(?))" +
                    " )" +
                    " And "+
                    "    NAME like ?" +
                    " ORDER BY $1 $2 " +
                    " offset ? limit  ? "+
                    " )x left join AM_BLOCK_CONDITIONS bl on  ( bl.TYPE = 'APPLICATION' AND bl.VALUE = concat(concat(x.USER_ID,':'),x.name)) ";


    public static final String GET_APPLICATIONS_PREFIX_NONE_CASESENSITVE_WITH_MULTIGROUPID =
            "select distinct x.*,bl.ENABLED from (" +
                    "SELECT " +
                    "   APPLICATION_ID, " +
                    "   NAME," +
                    "   APPLICATION_TIER," +
                    "   APP.SUBSCRIBER_ID,  " +
                    "   CALLBACK_URL,  " +
                    "   DESCRIPTION, " +
                    "   APPLICATION_STATUS, " +
                    "   USER_ID, " +
                    "   GROUP_ID, " +
                    "   UUID " +
                    " FROM" +
                    "   AM_APPLICATION APP, " +
                    "   AM_SUBSCRIBER SUB  " +
                    " WHERE " +
                    "   SUB.SUBSCRIBER_ID = APP.SUBSCRIBER_ID " +
                    " AND (" +
                    "    (APPLICATION_ID IN ( SELECT APPLICATION_ID FROM AM_APPLICATION_GROUP_MAPPING WHERE GROUP_ID " +
                    " IN ($params) AND TENANT = ? ))" +
                    "           OR " +
                    "    (SUB.USER_ID = ? )" +
                    " )" +
                    " And " +
                    "    NAME like ?"+
                    " ORDER BY $1 $2 " +
                    " offset ? limit  ? "+
                    " )x left join AM_BLOCK_CONDITIONS bl on  ( bl.TYPE = 'APPLICATION' AND bl.VALUE = concat(concat(x.USER_ID,':'),x.name)) ";


    public static final String GET_APPLICATIONS_PREFIX_CASESENSITVE =
            "select distinct x.*,bl.ENABLED from (" +
                    "SELECT " +
                    "   APPLICATION_ID, " +
                    "   NAME," +
                    "   APPLICATION_TIER," +
                    "   APP.SUBSCRIBER_ID,  " +
                    "   CALLBACK_URL,  " +
                    "   DESCRIPTION, " +
                    "   APPLICATION_STATUS, " +
                    "   USER_ID, " +
                    "   GROUP_ID, " +
                    "   UUID " +
                    " FROM" +
                    "   AM_APPLICATION APP, " +
                    "   AM_SUBSCRIBER SUB  " +
                    " WHERE " +
                    "   SUB.SUBSCRIBER_ID = APP.SUBSCRIBER_ID " +
                    " AND " +
                    "    LOWER(SUB.USER_ID) = LOWER(?)"+
                    " And "+
                    "    NAME like ?"+
                    " ORDER BY $1 $2 " +
                    " offset ? limit  ? "+
                    " )x left join AM_BLOCK_CONDITIONS bl on  ( bl.TYPE = 'APPLICATION' AND bl.VALUE = concat(concat(x.USER_ID,':'),x.name)) ";

    public static final String GET_APPLICATIONS_PREFIX_NONE_CASESENSITVE =
            "select distinct x.*,bl.ENABLED from (" +
                    "SELECT " +
                    "   APPLICATION_ID, " +
                    "   NAME," +
                    "   APPLICATION_TIER," +
                    "   APP.SUBSCRIBER_ID,  " +
                    "   CALLBACK_URL,  " +
                    "   DESCRIPTION, " +
                    "   APPLICATION_STATUS, " +
                    "   USER_ID, " +
                    "   GROUP_ID, " +
                    "   UUID " +
                    " FROM" +
                    "   AM_APPLICATION APP, " +
                    "   AM_SUBSCRIBER SUB  " +
                    " WHERE " +
                    "   SUB.SUBSCRIBER_ID = APP.SUBSCRIBER_ID " +
                    " AND " +
                    "   SUB.USER_ID=?" +
                    " And "+
                    "    NAME like ?"+
                    " ORDER BY $1 $2 " +
                    " offset ? limit  ? "+
                    " )x left join AM_BLOCK_CONDITIONS bl on  ( bl.TYPE = 'APPLICATION' AND bl.VALUE = concat(concat(x.USER_ID,':'),x.name)) ";


}