/*
 * Copyright 2015 Shopping24 GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.s24.search.solr.util;

import org.apache.solr.common.util.NamedList;

/**
 * Builder for instances of {@link NamedList}.
 *
 * @param <T> the type of the elements of the returned list.
 */
public class NamedListBuilder<T> {

   NamedList<T> underConstruction = new NamedList<>();

   /**
    * Creates a new Builder instance.
    */
   public NamedListBuilder() {
   }

   /**
    * Adds the given name-value pair to the end of the named list constructed by this builder.
    */
   public NamedListBuilder add(String name, T value) {
      if (underConstruction == null) {
         throw new IllegalStateException("build() was already invoked on this builder instance");
      }

      underConstruction.add(name, value);
      return this;
   }

   /**
    * Returns the named list constructed by this builder.
    */
   public NamedList<T> build() {
      if (underConstruction == null) {
         throw new IllegalStateException("build() was already invoked on this builder instance");
      }

      NamedList<T> result = underConstruction;
      underConstruction = null;
      return result;
   }
}
