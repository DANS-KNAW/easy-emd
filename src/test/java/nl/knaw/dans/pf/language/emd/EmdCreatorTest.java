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
import nl.knaw.dans.pf.language.emd.types.BasicString;
import nl.knaw.dans.pf.language.emd.types.EntityId;
import org.junit.Assert;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// ecco: CHECKSTYLE: OFF

public class EmdCreatorTest {

    @Test
    public void testToStringWithSeparator() {
        EmdCreator emdc = new EmdCreator();
        Assert.assertEquals("", emdc.toString("foo"));

        emdc.getDcCreator().add(new BasicString("Frank Zappa"));
        Assert.assertEquals("Frank Zappa", emdc.toString("foo"));

        emdc.getDcCreator().add(new BasicString("Bob Dylan"));
        Assert.assertEquals("Frank ZappafooBob Dylan", emdc.toString("foo"));

        emdc.getEasCreator().add(new Author());
        Assert.assertEquals("Frank ZappafooBob Dylanfoo", emdc.toString("foo"));

        emdc.getEasCreator().add(new Author("Dr.", "PHD", "van", "Vliet"));
        Assert.assertEquals("Frank ZappafooBob DylanfoofooVliet, Dr. PHD van", emdc.toString("foo"));
        Assert.assertEquals("Frank Zappa; Bob Dylan; ; Vliet, Dr. PHD van", emdc.toString("; "));

        Assert.assertEquals("Frank Zappa;Bob Dylan;;Vliet, Dr. PHD van", emdc.toString());
    }

    @Test
    public void testToStringAuthorWithRole() throws URISyntaxException {
        Author author = new Author("Dr.", "A.B.C.", "van", "D.");
        author.setOrganization("myOrg");
        List<EntityId> entityIds = new ArrayList<EntityId>();
        entityIds.add(new EntityId("12345", "scheme123", new URI("http://x")));
        author.setEntityIdHolder(entityIds);
        author.setRole(new Author.Role("RightsHolder", "DATACITE"));

        Assert.assertEquals("D., Dr. A.B.C. van (myOrg), RightsHolder", author.toString());
    }

    @Test
    public void testToStringOrganisationAuthorWithRole() throws URISyntaxException {
        Author author = new Author();
        author.setOrganization("myOrg");
        author.setRole(new Author.Role("Sponsor", "DATACITE"));

        Assert.assertEquals("myOrg, Sponsor", author.toString());
    }

    @Test
    public void testIsEmpty() {
        List<?> list = new LinkedList<Object>();
        Assert.assertTrue(list.isEmpty());
        Assert.assertTrue(list.add(null));
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(1, list.size());

        EmdCreator emdc = new EmdCreator();
        Assert.assertTrue(emdc.isEmpty());
        emdc.getDcCreator().add(null);
        Assert.assertFalse(emdc.isEmpty());
    }
}
