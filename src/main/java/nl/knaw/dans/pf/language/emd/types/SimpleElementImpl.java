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
 * Basic implementation of the {@link SimpleElement}.
 * 
 * @author ecco
 * @param <T>
 *        the wrapped type
 */
public abstract class SimpleElementImpl<T> implements SimpleElement<T>, MetadataItem {

    /**
     *
     */
    private static final long serialVersionUID = -2927383818237650985L;

    // ecco: CHECKSTYLE: OFF
    /**
     * The wrapped type.
     */
    protected T value;

    /**
     * The id of a list of choices used in a value or attribute.
     */
    protected String schemeId;

    // ecco: CHECKSTYLE: ON

    /**
     * {@inheritDoc}
     */
    public T getValue() {
        return value;
    }

    /**
     * {@inheritDoc}
     */
    public void setValue(final T value) {
        this.value = value;
    }

    /**
     * @return the schemeId
     */
    public String getSchemeId() {
        return schemeId;
    }

    /**
     * @param schemeId
     *        the schemeId to set
     */
    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId;
    }

    /**
     * Returns a string-representation of the value of this SimpleElement.
     * 
     * @return string-representation of the value
     */
    @Override
    public String toString() {
        return value == null ? "" : value.toString();
    }

}
