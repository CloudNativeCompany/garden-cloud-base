/*
 *     Copyright 2022 tony-is-coding  belong to `org.garden`
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */
package org.cnc.garden.cloud.web.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * org.cnc.garden.cloud.web.properties - SwaggerProperties
 *
 * @author tony-is-coding
 * @date 2022/6/5 15:32
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "garden.swagger")
public class SwaggerProperties {

    private boolean enable;
    private String basePackage;

    private String title;
    private String description;
    private String license;
    private String serviceUrl;
    private String contactName;
    private String contactUrl;
    private String contactEmail;

}
