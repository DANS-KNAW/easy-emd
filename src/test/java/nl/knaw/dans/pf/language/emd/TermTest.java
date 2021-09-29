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

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import nl.knaw.dans.pf.language.emd.EasyMetadata;
import nl.knaw.dans.pf.language.emd.MDContainer;
import nl.knaw.dans.pf.language.emd.Term;
import nl.knaw.dans.pf.language.emd.Term.Name;
import nl.knaw.dans.pf.language.emd.Term.Namespace;
import nl.knaw.dans.pf.language.emd.binding.EasyMetadataFactory;
import nl.knaw.dans.pf.language.emd.types.BasicString;
import nl.knaw.dans.pf.language.emd.types.MetadataItem;
import nl.knaw.dans.pf.language.emd.types.ApplicationSpecific.MetadataFormat;

import org.junit.Test;

// ecco: CHECKSTYLE: OFF

public class TermTest {

    @Test
    public void testConstructor() {
        Term term = new Term("abstract");
        assertEquals(Name.ABSTRACT, term.getName());

        Term term1 = new Term("dc.title");
        assertEquals(Name.TITLE, term1.getName());
        assertEquals(Namespace.DC, term1.getNamespace());

        Term term2 = new Term("title", "dc");
        assertEquals(Name.TITLE, term2.getName());
        assertEquals(Namespace.DC, term2.getNamespace());

        assertEquals(term1, term2);
        assertEquals(term1.hashCode(), term2.hashCode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor2() {
        new Term("foo");
    }

    @Test
    public void getContainer() {
        EasyMetadata emd = EasyMetadataFactory.newEasyMetadata(MetadataFormat.DEFAULT);
        Term term = new Term("dc.title");
        Map<Term, MDContainer> termsMap = emd.getTermsMap();
        MDContainer mdContainer = termsMap.get(term);
        EmdContainer container = emd.getContainer(mdContainer, false);
        assertEquals(EmdTitle.class, container.getClass());
    }

    @Test
    public void getMetadataListByTerm() {
        EasyMetadata emd = EasyMetadataFactory.newEasyMetadata(MetadataFormat.DEFAULT);
        Term term = new Term("dc.title");
        List<MetadataItem> titles = emd.getTerm(term);
        BasicString bs = new BasicString("foo");
        titles.add(bs);
        assertEquals("foo", emd.getEmdTitle().getDcTitle().get(0).getValue());
    }

    @Test
    public void getMethodName() {
        Term term = new Term("dc.title");
        assertEquals("DCTITLE", term.getMethodName());
    }

}
