/**
 *  Copyright (c) 2015 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


package org.wso2.carbon.bpmn.rest.model.repository;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.wso2.carbon.bpmn.rest.common.DateToStringSerializer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
@XmlRootElement(name = "modelResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ModelResponse extends ModelRequest {

    protected String id;
    protected String url;
    @JsonSerialize(using = DateToStringSerializer.class, as=Date.class)
    protected Date createTime;
    @JsonSerialize(using = DateToStringSerializer.class, as=Date.class)
    protected Date lastUpdateTime;
    protected String deploymentUrl;
    //protected String tenantId;
    protected String sourceUrl;
    protected String sourceExtraUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getDeploymentUrl() {
        return deploymentUrl;
    }

    public void setDeploymentUrl(String deploymentUrl) {
        this.deploymentUrl = deploymentUrl;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
    public String getSourceExtraUrl() {
        return sourceExtraUrl;
    }
    public void setSourceExtraUrl(String sourceExtraUrl) {
        this.sourceExtraUrl = sourceExtraUrl;
    }
}
