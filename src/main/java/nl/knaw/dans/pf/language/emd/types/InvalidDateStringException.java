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
 * Signifies an attempt to modify a date with an invalid string.
 * 
 * @author ecco
 */
public class InvalidDateStringException extends EasyMetadataException {

    private static final long serialVersionUID = 5670941485794338819L;

    // ecco: CHECKSTYLE: OFF

    public InvalidDateStringException() {
        super();
    }

    public InvalidDateStringException(final String message) {
        super(message);
    }

    public InvalidDateStringException(final Throwable cause) {
        super(cause);
    }

    public InvalidDateStringException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
