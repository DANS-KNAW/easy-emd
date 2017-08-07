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
package nl.knaw.dans.pf.language.emd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URI;
import java.util.List;

import nl.knaw.dans.pf.language.emd.binding.EmdMarshaller;
import nl.knaw.dans.pf.language.emd.binding.EmdUnmarshaller;
import nl.knaw.dans.pf.language.emd.types.ApplicationSpecific;
import nl.knaw.dans.pf.language.emd.types.BasicIdentifier;
import nl.knaw.dans.pf.language.emd.types.EmdArchive;
import nl.knaw.dans.pf.language.emd.types.EmdConstants;
import nl.knaw.dans.pf.language.emd.validation.EMDValidator;
import nl.knaw.dans.pf.language.xml.validation.XMLErrorHandler;

import org.joda.time.DateTime;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EasyMetadataImplJiBXTest {

    private static final Logger logger = LoggerFactory.getLogger(EasyMetadataImplJiBXTest.class);

    private boolean verbose = false;

    @Test
    public void constructEmpty() throws Exception {
        EasyMetadata emd = new EasyMetadataImpl();
        if (verbose)
            System.err.println(new EmdMarshaller(emd).getXmlString());
    }

    @Test
    public void testEtc() throws Exception {
        EasyMetadata emd = new EasyMetadataImpl();
        EmdOther emdOther = emd.getEmdOther();

        List<PropertyList> etc = emdOther.getPropertyListCollection();
        PropertyList propList = new PropertyList();
        etc.add(propList);
        propList.setComment("Conversion from EasyI-matadata to EasyII-metadata");
        propList.addProperty("date", new DateTime().toString());
        propList.addProperty("aipId", "abcde12345");

        String xmlString = new EmdMarshaller(emd).getXmlString();

        if (verbose)
            logger.debug("\n" + xmlString);

        XMLErrorHandler handler = EMDValidator.instance().validate(xmlString, null);
        assertTrue(handler.passed());
    }

    @Test
    public void testApplicationSpecific() throws Exception {
        EasyMetadata emd = new EasyMetadataImpl();
        EmdOther emdOther = emd.getEmdOther();

        ApplicationSpecific easApplicationSpecific = emdOther.getEasApplicationSpecific();
        easApplicationSpecific.setPakbonStatus(ApplicationSpecific.PakbonStatus.IMPORTED);

        EmdArchive archive = new EmdArchive();
        archive.setLocation(EmdArchive.Location.DATAVAULT);
        easApplicationSpecific.setArchive(archive);

        byte[] bytes = new EmdMarshaller(emd).getXmlByteArray();
        EasyMetadata emd2 = new EmdUnmarshaller<EasyMetadata>(EasyMetadataImpl.class).unmarshal(bytes);
        assertEquals(EmdArchive.Location.DATAVAULT, emd2.getEmdOther().getEasApplicationSpecific().getArchive().getLocation());
    }

    @Test
    public void testIdentifier() throws Exception {
        EasyMetadata emd = new EasyMetadataImpl();
        BasicIdentifier bi = new BasicIdentifier("123");
        bi.setScheme(EmdConstants.SCHEME_ARCHIS_ONDERZOEK_M_NR);
        bi.setIdentificationSystem(URI.create("http://foo.com"));
        emd.getEmdIdentifier().add(bi);

        byte[] bytes = new EmdMarshaller(emd).getXmlByteArray();

        EasyMetadata emd2 = new EmdUnmarshaller<EasyMetadata>(EasyMetadataImpl.class).unmarshal(bytes);
        // System.out.println(emd2.asXMLString(4));
        BasicIdentifier bi2 = emd2.getEmdIdentifier().getIdentifier(EmdConstants.SCHEME_ARCHIS_ONDERZOEK_M_NR);
        assertEquals("123", bi2.getValue());
        assertEquals(URI.create("http://foo.com"), bi2.getIdentificationSystem());
    }

    @Test
    public void testSerialization() throws Exception {
        BasicIdentifier bi = new BasicIdentifier("123");
        bi.setScheme(EmdConstants.SCHEME_ARCHIS_ONDERZOEK_M_NR);
        bi.setIdentificationSystem(URI.create("http://foo.com"));

        serialize(bi, "target/basicIdentifier.so");

        BasicIdentifier bi2 = (BasicIdentifier) deserialize("target/basicIdentifier.so");
        assertEquals(URI.create("http://foo.com"), bi2.getIdentificationSystem());

    }

    private void serialize(Serializable so, String filename) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        fos = new FileOutputStream(filename);
        out = new ObjectOutputStream(fos);
        out.writeObject(so);
        out.close();
    }

    private Object deserialize(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fis);
        Object so = in.readObject();
        in.close();
        return so;
    }

}
