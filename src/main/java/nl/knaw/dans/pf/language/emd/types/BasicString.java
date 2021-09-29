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

import java.util.Locale;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * A string can be an expression in a certain language or an encoding in compliance with a certain scheme (among other things). {@link BasicString} is a
 * {@link LanguageTokenizedString} with a scheme attribute.
 * 
 * @author ecco
 */
public class BasicString extends LanguageTokenizedString {

    /**
     * the serial version id.
     */
    private static final long serialVersionUID = -8903312231226570431L;

    // ecco: CHECKSTYLE: OFF
    /**
     * The name of the scheme. (If the value is from a scheme, dependent on a scheme etc.)
     */
    protected String scheme;

    // ecco: CHECKSTYLE: ON

    /**
     * Constructs a BasicString.
     */
    public BasicString() {
        super();
    }

    /**
     * Constructs a BasicString.
     * 
     * @param value
     *        the value of this BasicString
     */
    public BasicString(final String value) {
        super(value);
    }

    /**
     * Constructs a BasicString.
     * 
     * @param value
     *        the value of this BasicString
     * @param language
     *        the language of this BasicString
     * @throws InvalidLanguageTokenException
     *         if the language does not conform to the regex in {@link #LANGUAGE_TOKEN}
     */
    public BasicString(final String value, final String language) throws InvalidLanguageTokenException {
        super(value, language);
    }

    /**
     * Save constructor of a BasicString.
     * 
     * @param value
     *        the value of this BasicString
     * @param locale
     *        the java representation of a language token
     * @throws InvalidLanguageTokenException
     *         if a language token could not be parsed from the given locale
     * @see #setLanguage(Locale)
     */
    public BasicString(final String value, final Locale locale) throws InvalidLanguageTokenException {
        super(value, locale);
    }

    /**
     * Constructs a BasicString.
     * 
     * @param value
     *        the value of this BasicString
     * @param language
     *        the language of this BasicString
     * @param scheme
     *        any string that codes for a scheme
     * @throws InvalidLanguageTokenException
     *         if the language does not conform to the regex in {@link #LANGUAGE_TOKEN}
     */
    public BasicString(final String value, final String language, final String scheme) throws InvalidLanguageTokenException {
        super(value, language);
        setScheme(scheme);
    }

    /**
     * Save constructor of a BasicString.
     * 
     * @param value
     *        the value of this BasicString
     * @param locale
     *        the java representation of a language token
     * @param scheme
     *        any string that codes for a scheme
     * @throws InvalidLanguageTokenException
     *         if a language token could not be parsed from the given locale
     * @see #setLanguage(Locale)
     */
    public BasicString(final String value, final Locale locale, final String scheme) throws InvalidLanguageTokenException {
        super(value, locale);
        setScheme(scheme);
    }

    /**
     * Get the scheme of this BasicString.
     * 
     * @return any string that codes for a scheme, or <code>null</code>
     */
    public String getScheme() {
        return scheme;
    }

    /**
     * Set the scheme of this BasicString.
     * 
     * @param scheme
     *        any string that codes for a scheme, or <code>null</code>
     */
    public final void setScheme(final String scheme) {
        this.scheme = scheme;
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj != null) {
            if (obj == this) {
                equals = true;
            } else {
                if (obj.getClass().equals(this.getClass())) {
                    final BasicString other = (BasicString) obj;
                    equals = new EqualsBuilder().append(this.value, other.value).append(this.scheme, other.scheme).append(this.schemeId, other.schemeId)
                            .append(this.language, other.language).isEquals();
                }
            }
        }
        return equals;
    }

    public boolean shallowEquals(Object obj) {
        boolean shequals = false;
        if (obj != null) {
            if (obj == this) {
                shequals = true;
            } else {
                if (obj.getClass().equals(this.getClass())) {
                    final BasicString other = (BasicString) obj;
                    shequals = new EqualsBuilder().append(this.value, other.value).append(this.scheme, other.scheme).append(this.schemeId, other.schemeId)
                            .isEquals();
                }
            }
        }
        return shequals;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(23, 29).append(value).append(scheme).append(schemeId).append(language).toHashCode();
    }

    public boolean isComplete() {
        return true;
    }

}
