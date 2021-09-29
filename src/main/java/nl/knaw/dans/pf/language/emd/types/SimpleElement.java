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

import java.io.Serializable;

/**
 * Wrapper of type-save values.
 * <p/>
 * The meaningful part of an element in xml is in essence a string value that can be serialized to a java type. Classes that implement this interface make sure
 * that the meaningful part can be set and obtained through the methods {@link #setValue(Object)} and {@link #getValue()}.
 * 
 * @author ecco
 * @param <T>
 *        the wrapped type
 */
public interface SimpleElement<T> extends Serializable {

    /**
     * Type-save method to get the meaningful part of an element.
     * 
     * @return the meaningful part of an element
     */
    T getValue();

    /**
     * Type-save method to set the meaningful part of an element.
     * 
     * @param value
     *        the meaningful part of an element
     */
    void setValue(T value);
}
