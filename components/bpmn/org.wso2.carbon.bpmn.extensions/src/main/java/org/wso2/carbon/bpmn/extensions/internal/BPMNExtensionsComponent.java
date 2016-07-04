/*
* Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.wso2.carbon.bpmn.extensions.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.bpmn.core.BPMNEngineService;
import org.wso2.carbon.bpmn.core.BPMNServerHolder;
import org.wso2.carbon.bpmn.extensions.rest.BPMNRestExtensionHolder;
import org.wso2.carbon.bpmn.extensions.rest.RESTInvoker;
import org.wso2.carbon.registry.core.service.RegistryService;

/**
 * @scr.component name="org.wso2.carbon.bpel.BPMNExtensionsComponent" immediate="true"
 * @scr.reference name="registry.service" interface="org.wso2.carbon.registry.core.service.RegistryService"
 * cardinality="1..1" policy="dynamic"  bind="setRegistryService" unbind="unsetRegistryService"
 * @scr.reference name="bpmnengine.service" interface="org.wso2.carbon.bpmn.core.BPMNEngineService"
 * cardinality="1..1" policy="dynamic"  bind="setBPMNEngineService" unbind="unsetBPMNEngineService"
 */

public class BPMNExtensionsComponent {

    private static Log log = LogFactory.getLog(BPMNExtensionsComponent.class);
    private static RegistryService registryService;
    private static BPMNEngineService engineService;

    protected void activate(ComponentContext ctxt) {

        RESTInvoker restInvoker = new RESTInvoker();
        BPMNRestExtensionHolder holder = BPMNRestExtensionHolder.getInstance();
        holder.setRestInvoker(restInvoker);

        if (log.isDebugEnabled()) {
            log.debug("Activated bpmn extensions component and configured rest invoker");
        }
    }

    protected void deactivate(ComponentContext ctxt) {
        if (log.isDebugEnabled()) {
            log.debug("deactivated bpmn extensions component");
        }
    }

    protected void setRegistryService(RegistryService registryService) {
        if (log.isDebugEnabled()) {
            log.debug("RegistryService bound to the BPMN Extensions component");
        }
        BPMNExtensionsComponent.registryService = registryService;

    }

    protected void unsetRegistryService(RegistryService registryService) {
        if (log.isDebugEnabled()) {
            log.debug("RegistryService unbound from the BPMN Extensions component");
        }
        BPMNExtensionsComponent.registryService = null;
    }

    protected void setBPMNEngineService(BPMNEngineService engineService) {
        if (log.isDebugEnabled()) {
            log.debug("BPMNEngineService bound to the BPMN Extensions component");
        }
        BPMNExtensionsComponent.engineService = engineService;
    }

    protected void unsetBPMNEngineService(BPMNEngineService engineService) {
        BPMNExtensionsComponent.engineService = null;
    }

    public static RegistryService getRegistryService() {
        return  registryService;
    }

    public static BPMNEngineService getEngineService() {
        return engineService;
    }
}

