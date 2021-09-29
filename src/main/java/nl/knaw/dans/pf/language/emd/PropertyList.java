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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PropertyList implements Serializable {

    private static final long serialVersionUID = 442071239235827438L;
    private String comment;
    private List<Property> properties = new ArrayList<Property>();;

    public PropertyList() {

    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void addProperty(String key, String value) {
        properties.add(new Property(key, value));
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public String getValue(String key, String defaultValue) {
        String value = defaultValue;
        for (Property prop : properties) {
            if (prop.getKey().equals(key)) {
                value = prop.getValue();
                break;
            }
        }
        return value;
    }

    public static class Property implements Serializable {

        private static final long serialVersionUID = 1L;
        private String key;
        private String value;

        @SuppressWarnings("unused")
        private Property() {

        }

        public Property(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

}
