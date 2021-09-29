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
package nl.knaw.dans.pf.language.emd;

/**
 * Semantic metaphor for metadata containers.
 * 
 * @author ecco
 */
public enum MDContainer {
    // CHECKSTYLE: OFF
    // @formatter:off
    Title(true), 
    Creator(true), 
    Subject(true), 
    Description(true), 
    Publisher(true), 
    Contributor(true), 
    Date(true), Type(true), 
    Format(true), 
    Identifier(true), 
    Relation(true), 
    Source(true), 
    Language(true), 
    Coverage(true), 
    Rights(true), 
    Audience(false), 
    Other(false);
    // @formatter:on

    /**
     * Is this metadata container part of the 15 legacy /elements/1.1/ of the DCMI-terms, also known as 'simple dublin core'.
     */
    public final boolean isDC;

    private MDContainer(final boolean isDC) {
        this.isDC = isDC;
    }
    // CHECKSTYLE: ON
}
