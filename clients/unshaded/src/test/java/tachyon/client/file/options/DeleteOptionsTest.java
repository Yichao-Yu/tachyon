/*
 * Licensed to the University of California, Berkeley under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package tachyon.client.file.options;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import tachyon.conf.TachyonConf;

public class DeleteOptionsTest {
  @Test
  public void builderTest() {
    Random random = new Random();
    boolean recursive = random.nextBoolean();

    DeleteOptions options =
        new DeleteOptions.Builder(new TachyonConf())
            .setRecursive(recursive)
            .build();

    Assert.assertEquals(recursive, options.isRecursive());
  }

  @Test
  public void defaultsTest() {
    DeleteOptions options = DeleteOptions.defaults();

    Assert.assertFalse(options.isRecursive());
  }
}
