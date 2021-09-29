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

/**
 * A {@link BasicString} who's value is most likely an expression in a certain language from a person that is the author of the remark.
 * 
 * @author ecco
 */
public class BasicRemark extends BasicString {

    /**
     *
     */
    private static final long serialVersionUID = 4387943467496611507L;

    private String author;

    /**
     * Constructor.
     */
    public BasicRemark() {
        super();
    }

    /**
     * Constructs a BasicRemark.
     * 
     * @param value
     *        the value of this BasicRemark
     */
    public BasicRemark(final String value) {
        super(value);
    }

    /**
     * Constructor.
     * 
     * @param value
     *        the value of this BasicRemark
     * @param language
     *        the language of this BasicRemark
     * @throws InvalidLanguageTokenException
     *         if the language does not conform to the regular expression in {@link #LANGUAGE_TOKEN}
     */
    public BasicRemark(final String value, final String language) throws InvalidLanguageTokenException {
        super(value, language);
    }

    /**
     * Save constructor.
     * 
     * @param value
     *        the value of this BasicRemark
     * @param locale
     *        the java representation of a language token
     * @throws InvalidLanguageTokenException
     *         if a language token could not be parsed from the given locale
     * @see #setLanguage(Locale)
     */
    public BasicRemark(final String value, final Locale locale) throws InvalidLanguageTokenException {
        super(value, locale);
    }

    /**
     * Constructor.
     * 
     * @param value
     *        the value of this BasicRemark
     * @param language
     *        the language of this BasicRemark
     * @param author
     *        the author
     * @throws InvalidLanguageTokenException
     *         if the language does not conform to the regex in {@link #LANGUAGE_TOKEN}
     */
    public BasicRemark(final String value, final String language, final String author) throws InvalidLanguageTokenException {
        super(value, language);
        this.author = author;
    }

    /**
     * Save constructor.
     * 
     * @param value
     *        the value of this BasicString
     * @param locale
     *        the java representation of a language token
     * @param author
     *        the author
     * @throws InvalidLanguageTokenException
     *         if a language token could not be parsed from the given locale
     * @see #setLanguage(Locale)
     */
    public BasicRemark(final String value, final Locale locale, final String author) throws InvalidLanguageTokenException {
        super(value, locale);
        this.author = author;
    }

    /**
     * Get the author.
     * 
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set the author.
     * 
     * @param author
     *        the author
     */
    public void setAuthor(final String author) {
        this.author = author;
    }

}
