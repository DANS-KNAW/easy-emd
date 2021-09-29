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

/**
 * Signifies an attempt to modify easymetadata with an illegal argument.
 * 
 * @author ecco
 */
public class EasyMetadataException extends IllegalArgumentException {

    private static final long serialVersionUID = 4837214352995804241L;

    // ecco: CHECKSTYLE: OFF

    EasyMetadataException() {
        super();
    }

    EasyMetadataException(final String message) {
        super(message);
    }

    EasyMetadataException(final Throwable cause) {
        super(cause);
    }

    EasyMetadataException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
