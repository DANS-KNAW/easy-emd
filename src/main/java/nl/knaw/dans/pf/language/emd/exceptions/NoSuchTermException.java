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
package nl.knaw.dans.pf.language.emd.exceptions;

/**
 * Indicates that a Term does not exist.
 * 
 * @author ecco
 */
public class NoSuchTermException extends RuntimeException {

    private static final long serialVersionUID = -432326920395537600L;

    // ecco: CHECKSTYLE: OFF

    public NoSuchTermException() {
        super();
    }

    public NoSuchTermException(final String message) {
        super(message);
    }

    public NoSuchTermException(final Throwable cause) {
        super(cause);
    }

    public NoSuchTermException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
