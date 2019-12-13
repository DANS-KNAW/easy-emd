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
package nl.knaw.dans.pf.language.emd.types;

import java.io.Serializable;
import java.net.URI;

import static nl.knaw.dans.pf.language.emd.types.Author.DEFAULT_SCHEME;

public class EntityId implements Serializable {

  private String entityId;
  private String scheme;
  private URI identificationSystem;

  public EntityId() {}

  public EntityId(String entityId){
    this.entityId = entityId;
  }
  public EntityId(String entityId, String scheme, URI identificationSystem) {
    this.entityId = entityId;
    this.scheme = scheme;
    this.identificationSystem = identificationSystem;
  }

  public String getEntityId() {
    return this.entityId;
  }

  public void setEntityId(String entityId) {
    this.entityId = entityId;
    if (this.scheme == null)
      this.scheme = DEFAULT_SCHEME;
  }

  public String getScheme() {
    return this.scheme;
  }

  public void setScheme(String scheme) {
    this.scheme = scheme;
  }

  public URI getIdentificationSystem() {
    return this.identificationSystem;
  }

  public void setIdentificationSystem(URI identificationSystem) {
    this.identificationSystem = identificationSystem;
  }
}
