/**
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
package nl.knaw.dans.pf.language.emd.validation;

import java.net.MalformedURLException;
import java.net.URL;

import nl.knaw.dans.pf.language.emd.EasyMetadata;
import nl.knaw.dans.pf.language.emd.binding.EmdMarshaller;
import nl.knaw.dans.pf.language.xml.exc.XMLException;
import nl.knaw.dans.pf.language.xml.validation.AbstractValidator;
import nl.knaw.dans.pf.language.xml.validation.XMLErrorHandler;

import org.xml.sax.SAXException;

/**
 * Utility class for validating easymetadata.
 * 
 * @author ecco
 */
public final class EMDValidator extends AbstractValidator {

    /**
     * The version token for version {@value} .
     */
    public static final String VERSION_0_1 = "0.1";

    public static final String SCHEMA_LOCATION = "http://easy.dans.knaw.nl/schemas/md/emd/2017/emd.xsd";

    private static final EMDValidator instance = new EMDValidator();

    private String schemaLocation;

    // singleton
    private EMDValidator() {

    }

    public static EMDValidator instance() {
        return instance;
    }

    /**
     * Parameter <code>version</code> is silently ignored.
     */
    @Override
    public URL getSchemaURL(final String version) {
        URL schemaURL;
        try {
            schemaURL = new URL(getSchemaLocation());
        }
        catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return schemaURL;
    }

    public String getSchemaLocation() {
        if (schemaLocation == null) {
            schemaLocation = SCHEMA_LOCATION;
        }
        return schemaLocation;
    }

    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }

    public XMLErrorHandler validate(EasyMetadata emd) throws XMLException, SAXException {
        return validate(new EmdMarshaller(emd).getXmlString(), null);
    }

}
