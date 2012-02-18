/*
 * Copyright (C) 2011 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.juzu.impl.http;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import org.juzu.test.AbstractHttpTestCase;
import org.juzu.test.UserAgent;

import java.util.Arrays;
import java.util.List;

/** @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a> */
public class HttpTestCase extends AbstractHttpTestCase
{

   @Test
   public void testNoApplication()
   {
      assertInternalError();
   }

   @Test
   public void testLifeCycle() throws Exception
   {
      assertDeploy("http", "lifecycle");
      UserAgent ua = assertInitialPage();
      HtmlPage page = ua.getHomePage();
      String actionURL = page.asText();
      assertTrue(actionURL.length() > 0);
      String resourceURL = ((HtmlPage)page.getWebClient().getPage(actionURL)).asText();
      assertTrue(resourceURL.length() > 0);
      String done = ((HtmlPage)page.getWebClient().getPage(resourceURL)).asText();
      assertEquals("done", done);
   }

   @Test
   public void testRedirect() throws Exception
   {
      assertDeploy("http", "redirect");
      UserAgent ua = assertInitialPage();
      HtmlPage page = ua.getHomePage();
      String actionURL = page.asText();
      assertTrue(actionURL.length() > 0);
      ua.assertRedirect("http://www.foo.org", actionURL);
   }

   @Test
   public void testJS() throws Exception
   {
      assertDeploy("http", "js");
      UserAgent ua = assertInitialPage();
      HtmlPage page = ua.getHomePage();
      List<String> alerts = ua.getAlerts(page);
      assertEquals(Arrays.asList("foo"), alerts);
   }

   @Test
   public void testAjax() throws Exception
   {
      assertDeploy("http", "ajax");
      UserAgent ua = assertInitialPage();
      HtmlPage page = ua.getHomePage();
      HtmlAnchor trigger = (HtmlAnchor)page.getElementById("trigger");
      trigger.click();
      assertEquals("bar", page.getElementById("foo").asText());
   }
}
