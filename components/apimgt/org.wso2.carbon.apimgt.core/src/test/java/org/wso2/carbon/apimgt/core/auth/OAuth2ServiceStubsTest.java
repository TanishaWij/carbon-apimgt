/*
 *  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.wso2.carbon.apimgt.core.auth;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
   Test cases for OAuth2ServiceStubs class
 */
public class OAuth2ServiceStubsTest {

    String tokenEndpoint = "https://localhost:9443/oauth2/token";
    String revokeEndpoint = "https://localhost:9443/oauth2/revoke";
    String introspectEndpoint = "http://localhost:9763/oauth2/introspect";
    String userInfoEndpoint = "https://localhost:9443/api/auth/oidc/v1.0/userinfo";
    String keyManagerCertAlias = "wso2carbon";
    OAuth2ServiceStubs oAuth2ServiceStubs = new OAuth2ServiceStubs(tokenEndpoint, revokeEndpoint, introspectEndpoint,
            userInfoEndpoint, keyManagerCertAlias, "admin", "admin");

    @Test
    public void testGetTokenServiceStub() throws Exception {

        Assert.assertTrue(oAuth2ServiceStubs.getTokenServiceStub() instanceof OAuth2ServiceStubs.TokenServiceStub);
    }

    @Test
    public void testGetRevokeServiceStub() throws Exception {

        Assert.assertTrue(oAuth2ServiceStubs.getRevokeServiceStub() instanceof OAuth2ServiceStubs.RevokeServiceStub);
    }

    @Test
    public void testGetIntrospectionServiceStub() throws Exception {

        Assert.assertTrue(oAuth2ServiceStubs.getIntrospectionServiceStub() instanceof OAuth2ServiceStubs.
                IntrospectionServiceStub);
    }
    @Test
    public void testGetUserInfoServiceStub() throws Exception {

        Assert.assertTrue(oAuth2ServiceStubs.getUserInfoServiceStub() instanceof OAuth2ServiceStubs.
                UserInfoServiceStub);
    }
}
