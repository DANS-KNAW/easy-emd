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

import nl.knaw.dans.pf.language.emd.types.Author;
import nl.knaw.dans.pf.language.emd.types.BasicDate;
import nl.knaw.dans.pf.language.emd.types.BasicIdentifier;
import nl.knaw.dans.pf.language.emd.types.BasicRemark;
import nl.knaw.dans.pf.language.emd.types.BasicString;
import nl.knaw.dans.pf.language.emd.types.EntityId;
import nl.knaw.dans.pf.language.emd.types.IsoDate;
import nl.knaw.dans.pf.language.emd.types.Polygon;
import nl.knaw.dans.pf.language.emd.types.PolygonPart;
import nl.knaw.dans.pf.language.emd.types.PolygonPoint;
import nl.knaw.dans.pf.language.emd.types.Relation;
import nl.knaw.dans.pf.language.emd.types.Spatial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static nl.knaw.dans.pf.language.emd.types.ApplicationSpecific.PakbonStatus.IMPORTED;

// ecco: CHECKSTYLE: OFF

public class EmdHelper {
    /**
     * Logger for this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EasyMetadataImpl.class);

    public static void populate(int repeatFill, EasyMetadata emd) throws URISyntaxException {
        for (MDContainer mdContainer : MDContainer.values()) {
            EmdContainer emdContainer = emd.getContainer(mdContainer, false);

            populate(repeatFill, emdContainer);
        }

    }

    public static void populate(int repeatFill, EmdContainer emdContainer) throws URISyntaxException {
        for (Term term : emdContainer.getTerms()) {
            List<?> list = emdContainer.get(term);
            fill(list, term, repeatFill);
        }
        if (emdContainer instanceof EmdOther) {
            EmdOther emdOther = (EmdOther) emdContainer;

            for (int i = 0; i < repeatFill; i++) {
                PropertyList propertyList = new PropertyList();
                propertyList.setComment("PropertyList " + i);
                propertyList.addProperty("key 1", "value 1");
                propertyList.addProperty("key 2", "value 2");
                emdOther.add(propertyList);
            }

            emdOther.getEasApplicationSpecific().setPakbonStatus(IMPORTED);
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void fill(List list, Term term, int times) throws URISyntaxException {
        if (term.getType() == null) {
            LOGGER.warn("No type set for " + term.toString());
            return;
        }

        if (term.getType().equals(BasicString.class)) {
            for (int i = 0; i < times; i++) {
                BasicString bs = getBasicString(term, i);
                list.add(bs);
            }
        } else if (term.getType().equals(Author.class)) {
            for (int i = 0; i < times; i++) {
                Author author = new Author();
                if (i % 3 == 0) {
                    List<EntityId> entityIds = new ArrayList<EntityId>();
                    entityIds.add(new EntityId("9876543216", "DAI", new URI("info:eu-repo/dai/nl/")));
                    entityIds.add(new EntityId("1230", "ISNI", new URI("http://isni.org/")));
                    entityIds.add(new EntityId("1230", "ORCID", new URI("https://orcid.org/")));
                    author.setEntityIdHolder(entityIds);
                    author.setInitials("abc");
                    author.setPrefix("van");
                    author.setSurname(term.getName().termName + " " + i);
                    author.setTitle("Dr.");
                } else if (i % 3 <= 1) {
                    List<EntityId> entityIds = new ArrayList<EntityId>();
                    entityIds.add(new EntityId("123" + i, null, new URI("http://author.org/sys" + i)));
                    author.setEntityIdHolder(entityIds);
                    author.setInitials("abc");
                    author.setPrefix("van");
                    author.setSurname(term.getName().termName + " " + i);
                    author.setTitle("Dr.");
                    author.setOrganization("DANS");
                    author.setRole(new Author.Role("RightsHolder", "DATACITE"));
                } else {
                    author.setOrganization("DANS");
                    author.setRole(new Author.Role("DataCollector", "DATACITE"));
                }
                list.add(author);
            }
        } else if (term.getType().equals(BasicDate.class)) {
            for (int i = 0; i < times; i++) {
                BasicDate bdate = new BasicDate("maart '98");
                bdate.setLanguage(new Locale("en", "US"));
                bdate.setSchemeId("basic.date.bla" + i);
                list.add(bdate);
            }
        } else if (term.getType().equals(BasicIdentifier.class)) {
            for (int i = 0; i < times; i++) {
                BasicIdentifier bid = getBasicIdentifier(i);
                bid.setSchemeId("basic.identifier.bla" + i);
                list.add(bid);
            }
        } else if (term.getType().equals(BasicRemark.class)) {
            for (int i = 0; i < times; i++) {
                BasicRemark remark = new BasicRemark(term.getName().termName + " " + i);
                remark.setAuthor("Author von Bar");
                remark.setLanguage("nl-NL");
                remark.setScheme("REM" + i);
                remark.setSchemeId("remark.bal.bal" + i);
                list.add(remark);
            }
        } else if (term.getType().equals(IsoDate.class)) {
            for (int i = 0; i < times; i++) {
                IsoDate idate = new IsoDate();
                idate.setSchemeId("iso.date.bla" + i);
                list.add(idate);
            }
        } else if (term.getType().equals(Relation.class)) {
            for (int i = 0; i < times; i++) {
                Relation rel = new Relation(getBasicString(term, i));
                rel.setEmphasis(i % 2 == 0);
                rel.setSubjectIdentifier(getBasicIdentifier(i));
                rel.setSubjectLink(new URI("http://relation.com/sys" + i));
                list.add(rel);
            }
        } else if (term.getType().equals(Spatial.class)) {
            for (int i = 0; i < times; i++) {
                Spatial spat = new Spatial();
                spat.setPlace(getBasicString(term, i));
                if (i % 4 == 0) {
                    // Spatial.Point point = new Spatial.Point("POI" + i, 123.45, 456.78);
                    Spatial.Point point = new Spatial.Point("POI" + i, "123.45", "456.78");
                    point.setSchemeId("point.bla" + i);
                    spat.setPoint(point);
                } else if (i % 4 == 1) {
                    // Spatial.Box box = new Spatial.Box("BOX" + i, 12.3, 23.4, 34.5, 45.6);
                    Spatial.Box box = new Spatial.Box("BOX" + i, "12.3", "23.4", "34.5", "45.6");
                    box.setSchemeId("box.bla" + i);
                    spat.setBox(box);
                } else if (i % 4 == 2) {
                    PolygonPart exterior = new PolygonPart("main triangle", Arrays.asList(new PolygonPoint("52.08110", "4.34521"), new PolygonPoint("52.08071",
                            "4.34422"), new PolygonPoint("52.07913", "4.34332"), new PolygonPoint("52.08110", "4.34521")));
                    PolygonPart interior1 = new PolygonPart("hole1", Arrays.asList(new PolygonPoint("52.080542", "4.344215"), new PolygonPoint("52.080450",
                            "4.344323"), new PolygonPoint("52.080357", "4.344110"), new PolygonPoint("52.080542", "4.344215")));
                    PolygonPart interior2 = new PolygonPart("hole2", Arrays.asList(new PolygonPoint("52.080542", "4.344215"), new PolygonPoint("52.080450",
                            "4.344323"), new PolygonPoint("52.080357", "4.344110"), new PolygonPoint("52.080542", "4.344215")));
                    Polygon polygon = new Polygon("POLYGON" + i, exterior, Arrays.asList(interior1, interior2));
                    polygon.setSchemeId("polygon.bla" + i);
                    spat.setPolygon(polygon);
                } else if (i % 4 == 3) {
                    PolygonPart exterior1 = new PolygonPart("main triangle", Arrays.asList(new PolygonPoint("52.08110", "4.34521"), new PolygonPoint(
                            "52.08071", "4.34422"), new PolygonPoint("52.07913", "4.34332"), new PolygonPoint("52.08110", "4.34521")));
                    PolygonPart interior1 = new PolygonPart("hole1", Arrays.asList(new PolygonPoint("52.080542", "4.344215"), new PolygonPoint("52.080450",
                            "4.344323"), new PolygonPoint("52.080357", "4.344110"), new PolygonPoint("52.080542", "4.344215")));
                    Polygon polygon1 = new Polygon("POLYGON" + i, exterior1, Collections.singletonList(interior1));
                    polygon1.setSchemeId("polygon.bla" + i + "a");

                    PolygonPart exterior2 = new PolygonPart("main triangle", Arrays.asList(new PolygonPoint("52.079710", "4.342778"), new PolygonPoint(
                            "52.080518", "4.343342"), new PolygonPoint("52.07913", "4.34332"), new PolygonPoint("52.079710", "4.342778")));
                    Polygon polygon2 = new Polygon("POLYGON" + i, exterior2, Collections.<PolygonPart> emptyList());
                    polygon2.setSchemeId("polygon.bla" + i + "b");

                    spat.setPolygons(Arrays.asList(polygon1, polygon2));
                }
                list.add(spat);
            }
        }
        if (list.isEmpty()) {
            LOGGER.warn("No fill-method for " + term.getType());
        }
    }

    private static BasicString getBasicString(Term term, int i) {
        BasicString bs = new BasicString(term.getName().termName + " " + i);
        bs.setLanguage(new Locale("nl", "NL"));
        bs.setScheme("BSS" + i);
        bs.setSchemeId("common.dc.type" + i);
        return bs;
    }

    private static BasicIdentifier getBasicIdentifier(int i) throws URISyntaxException {
        BasicIdentifier bid = new BasicIdentifier("ABC" + i);
        bid.setIdentificationSystem(new URI("http://pid.org/sys" + i));
        bid.setLanguage(new Locale("de", "DE"));
        bid.setScheme("BID" + i);
        bid.setSchemeId("BID.bla.foo" + i);
        return bid;
    }
}
