/*
 * Copyright (C) 2014 DANS - Data Archiving and Networked Services (info@dans.knaw.nl)
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
package nl.knaw.dans.pf.language.emd.types;

public enum EmdScheme {
    // @formatter:off
    ARCHAEOLOGY_DC_IDENTIFIER /* choicelist + */,
    ARCHAEOLOGY_DC_SUBJECT /* choicelist + recursivelist */,
    ARCHAEOLOGY_DCTERMS_ACCESSRIGHTS,
    ARCHAEOLOGY_DCTERMS_DATE /* choicelist */,
    ARCHAEOLOGY_DCTERMS_TEMPORAL /* choicelist + recursivelist */,
    ARCHAEOLOGY_EAS_SPATIAL/* EN?* choicelist */,
    COMMON_EAS_SPATIAL/* EN?* choicelist */,
    COMMON_DC_FORMAT /* choicelist */,
    COMMON_DC_LANGUAGE /* choicelist */,
    COMMON_DC_TYPE /* choicelist */,
    COMMON_DCTERMS_ACCESSRIGHTS /* choicelist */,
    COMMON_DCTERMS_AUDIENCE /* choicelist */,
    COMMON_DCTERMS_DATE /* choicelist */,
    COMMON_DCTERMS_RELATION /* choicelist */,
    LIFESCIENCE_DC_SUBJECT /* choicelist */,
    LIFESCIENCE_EAS_SPATIAL /* choicelist */,
    ;
    // @formatter:on
    public String getId() {
        return name().toLowerCase().replaceAll("_", ".");
    }
}
